package life.jzx.community.service.Impl;

import life.jzx.community.dto.CommentDTO;
import life.jzx.community.dto.QuestionDTO;
import life.jzx.community.enums.CommentTypeEnum;
import life.jzx.community.exception.CustomizeErrorCode;
import life.jzx.community.mapper.CommentMapper;
import life.jzx.community.mapper.QuestionMapper;
import life.jzx.community.mapper.UserMapper;
import life.jzx.community.model.Comment;
import life.jzx.community.model.User;
import life.jzx.community.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import life.jzx.community.exception.CustomizeException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @Auther: Administrator
 * @Date: 2020/5/28 0028 11:34
 * @Description:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<CommentDTO> listByQuestionId(Integer id,Integer type) {
        List<Comment> comments = commentMapper.selectByPrimryKey(id,type);
        if(comments.size()==0){
            return new ArrayList<>();
        }
        Set<Integer> commentors = comments.stream().map(comment -> comment.getCommentator()).collect(Collectors.toSet());
        List<Integer> userIds=new ArrayList<>();
        userIds.addAll(commentors);
        List<User> users = userMapper.selectById(userIds);
        Map<Integer, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(), user -> user));
        List<CommentDTO> commentDTOS=comments.stream().map(comment ->{
            CommentDTO commentDTO= new CommentDTO();
            BeanUtils.copyProperties(comment,commentDTO);
            commentDTO.setUser(userMap.get(comment.getCommentator()));
            System.out.println("commentDTO"+commentDTO);
            return commentDTO;
        }).collect(Collectors.toList());
        return commentDTOS;
    }

    @Override
    @Transactional
    public void insert(Comment comment) {
        if(comment.getParentId() == null || comment.getParentId()==0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if( !CommentTypeEnum.isExist(comment.getType())){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if(comment.getType()==CommentTypeEnum.COMMENT.getType()){
            //回复评论
            System.out.println("impl"+comment);
            List<Comment> comments = commentMapper.selectByPrimryKey(comment.getParentId(),comment.getType());
//            if(comments.size()==0){
//                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUNT);
//            }
            commentMapper.insert(comment);
            System.out.println("..");
        }else{
            //祸福问题
            QuestionDTO byId = questionMapper.getById(comment.getParentId());
            if(byId ==null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            System.out.println(comment);
            commentMapper.insert(comment);
            questionMapper.incCommentCount(byId);
        }

    }
}
