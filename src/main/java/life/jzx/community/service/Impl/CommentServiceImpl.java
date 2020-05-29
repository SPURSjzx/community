package life.jzx.community.service.Impl;

import life.jzx.community.dto.QuestionDTO;
import life.jzx.community.enums.CommentTypeEnum;
import life.jzx.community.exception.CustomizeErrorCode;
import life.jzx.community.mapper.CommentMapper;
import life.jzx.community.mapper.QuestionMapper;
import life.jzx.community.model.Comment;
import life.jzx.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import life.jzx.community.exception.CustomizeException;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

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

    @Override
    public void insert(Comment comment) {
        if(comment.getParentId() == null || comment.getParentId()==0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if( !CommentTypeEnum.isExist(comment.getType())){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if(comment.getType()==CommentTypeEnum.COMMENT.getType()){
            //回复评论
            Comment dbcomment= commentMapper.selectByPrimryKey(comment.getParentId());
            if(dbcomment==null){
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUNT);
            }
            commentMapper.insert(comment);
        }else{
            //祸福问题
            QuestionDTO byId = questionMapper.getById(comment.getParentId());
            if(byId ==null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            questionMapper.incCommentCount(byId);
        }

    }
}
