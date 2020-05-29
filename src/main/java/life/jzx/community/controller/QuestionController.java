package life.jzx.community.controller;

import life.jzx.community.dto.QuestionDTO;
import life.jzx.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: Administrator
 * @Date: 2020/5/26 0026 09:58
 * @Description:
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(value = "id")Integer id,
                           Model model){
        QuestionDTO questionDTO=questionService.getById(id);
        //累加阅读数
        questionService.incView(id);
        model.addAttribute("questionDTO",questionDTO);
        return "question";
    }
}
