package life.jzx.community.controller;
import life.jzx.community.dto.QuestionDTO;
import life.jzx.community.mapper.QuestionMapper;
import life.jzx.community.mapper.UserMapper;
import life.jzx.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Administrator
 * @Date: 2020/5/19 0019 16:48
 * @Description:
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish() {
        return "/publish";
    }

    @PostMapping( "/doPublish")
    public String doPublish(QuestionDTO questionDTO,
                            Model model,
                            HttpServletRequest request){
        User user = new User();
        model.addAttribute("title",questionDTO.getTitle());
        model.addAttribute("description",questionDTO.getDescription());
        model.addAttribute("tag",questionDTO.getTag());
        if (questionDTO.getTitle()==null || questionDTO.getTitle()==""){
            model.addAttribute("error","标签不能为空");
            return "/publish";
        }
        if (questionDTO.getDescription()==null || questionDTO.getDescription()==""){
            model.addAttribute("error","内容不能为空");
            return "/publish";
        }
        if (questionDTO.getTag()==null || questionDTO.getTag()==""){
            model.addAttribute("error","标签不能为空");
            return "/publish";
        }
        Cookie[] cookies = request.getCookies();
        if(cookies.length!=0 && cookies!=null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        if(user.getId()==null){
            model.addAttribute("error","请先登录");
            return "/publish";
        }else {
            questionDTO.setCreator(user.getId());
            questionDTO.setGmtCreate(user.getGmtCreate());
            questionDTO.setGmtModified(user.getGmtModified());
            questionMapper.create(questionDTO);
            return "redirect:/";
        }
    }
}
