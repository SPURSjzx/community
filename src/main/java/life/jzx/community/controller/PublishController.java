package life.jzx.community.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import	java.awt.Container;

/**
 * @Auther: Administrator
 * @Date: 2020/5/19 0019 16:48
 * @Description:
 */
@Controller
public class PublishController {

    @GetMapping("/publish")
    public String publish() {
        return "/publish";
    }
}
