package life.jzx.community.controller;

import life.jzx.community.dto.PaginationDTO;
import life.jzx.community.mapper.UserMapper;
import life.jzx.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;

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
    public String index(Model model,
                        @RequestParam(name="page",defaultValue ="1")Integer page,
                        @RequestParam(name="size",defaultValue = "2")Integer size){
        PaginationDTO questionList = questionService.list(page,size);
        model.addAttribute("questionList",questionList);
        return "index";
    }
}
