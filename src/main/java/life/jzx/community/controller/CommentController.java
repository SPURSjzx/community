package life.jzx.community.controller;

import life.jzx.community.dto.ComentDTO;
import life.jzx.community.dto.CommentDTO;
import life.jzx.community.dto.ResultDTO;
import life.jzx.community.enums.CommentTypeEnum;
import life.jzx.community.exception.CustomizeErrorCode;
import life.jzx.community.model.Comment;
import life.jzx.community.model.User;
import life.jzx.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/28 0028 11:16
 * @Description:
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping("/comment")
    public Object post(@RequestBody ComentDTO comentDTO,
                       HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        System.out.println(user);
        System.out.println(comentDTO);
        if(user==null){
            return ResultDTO.errorof(CustomizeErrorCode.NO_LOGIN);
        }
        if(comentDTO==null||comentDTO.getContent()==null||comentDTO.getContent().isEmpty()){
            return ResultDTO.errorof(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }else {
            System.out.println("comentDTO"+comentDTO);
            Comment comment = new Comment();
            comment.setParentId(comentDTO.getParentId());
            comment.setContent(comentDTO.getContent());
            comment.setType(comentDTO.getType());
            comment.setContent(comentDTO.getContent());
            comment.setGmt_modified(System.currentTimeMillis());
            comment.setGmt_create(System.currentTimeMillis());
            comment.setCommentator(user.getId());
            comment.setParentId(comentDTO.getParentId());
            System.out.println("comment"+comment);
            commentService.insert(comment);
        }
        return ResultDTO.okof();
    }

    @ResponseBody
    @RequestMapping(value = "/comments/{id}",method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>>comments(@PathVariable(name = "id")Integer id){
        List<CommentDTO> commentDTOS = commentService.listByQuestionId(id, CommentTypeEnum.COMMENT.getType());
        return ResultDTO.okof(commentDTOS);
    }
}
