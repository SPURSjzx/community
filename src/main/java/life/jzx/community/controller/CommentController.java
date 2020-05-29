package life.jzx.community.controller;

import life.jzx.community.dto.ComentDTO;
import life.jzx.community.dto.ResultDTO;
import life.jzx.community.exception.CustomizeErrorCode;
import life.jzx.community.model.Comment;
import life.jzx.community.model.User;
import life.jzx.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
        if(user==null){
            return ResultDTO.errorof(CustomizeErrorCode.NO_LOGIN);
        }
        Comment comment = new Comment();
        comment.setParentId(comentDTO.getParentId());
        comment.setContent(comentDTO.getContent());
        comment.setType(comentDTO.getType());
        comment.setGmt_modified(System.currentTimeMillis());
        comment.setGmt_create(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        commentService.insert(comment);
        return ResultDTO.okof();
    }

    @RequestMapping("/c")
    public String c(){
        System.out.println("c");
        return "ccc";
    }
}
