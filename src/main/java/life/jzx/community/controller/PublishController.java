package life.jzx.community.controller;

import life.jzx.community.dto.QuestionDTO;
import life.jzx.community.mapper.QuestionMapper;
import life.jzx.community.model.User;
import life.jzx.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private QuestionService questionService;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(value = "id")Integer id,
                       Model model){
        //通过form隐藏传过来的id进行判断是新建问题还是修改问题
        QuestionDTO byId = questionMapper.getById(id);
        model.addAttribute("title",byId.getTitle());
        model.addAttribute("description",byId.getDescription());
        model.addAttribute("tag",byId.getTag());
        model.addAttribute("id",byId.getId());
        return "publish";
    }


    @GetMapping("/publish")
    public String publish() {
        return "/publish";
    }

    @PostMapping( "/doPublish")
    public String doPublish(QuestionDTO questionDTO,
                            Model model,
                            HttpServletRequest request,
                            @RequestParam(value = "id",required = false)Integer id){
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
        User user = (User) request.getSession().getAttribute("user");
        if(user.getId()==null){
            model.addAttribute("error","请先登录");
            return "/publish";
        }else {
            questionDTO.setCreator(user.getId());
            questionDTO.setGmtCreate(user.getGmtCreate());
            questionDTO.setId(id);
            questionService.createOrUpdate(questionDTO);
            return "redirect:/";
        }
    }
}
