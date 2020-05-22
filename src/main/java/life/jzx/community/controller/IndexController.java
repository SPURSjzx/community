package life.jzx.community.controller;

import life.jzx.community.dto.PaginationDTO;
import life.jzx.community.dto.QuestionDTO;
import life.jzx.community.mapper.QuestionMapper;
import life.jzx.community.mapper.UserMapper;
import life.jzx.community.model.Question;
import life.jzx.community.model.User;
import life.jzx.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/15 0015 15:38
 * @Description:
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name="page",defaultValue ="1")Integer page,
                        @RequestParam(name="size",defaultValue = "2")Integer size){
        Cookie[] cookies = request.getCookies();
        if(cookies.length!=0&&cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("token")){
                    String token=cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if(user!=null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }
        PaginationDTO questionList = questionService.list(page,size);
        System.out.println("questionList"+questionList);
        model.addAttribute("questionList",questionList);
        return "index";
    }
}
