package life.jzx.community.controller;

import life.jzx.community.dto.AccessTokenDTO;
import life.jzx.community.dto.GithubUser;
import life.jzx.community.mapper.UserMapper;
import life.jzx.community.model.User;
import life.jzx.community.provide.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Auther: Administrator
 * @Date: 2020/5/18 0018 14:17
 * @Description:
 */
@Controller
public class AuthorizeController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GitHubProvider gitHubProvider;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.serrcret}")
    private String clientserrcret;
    @Value("${github.redirect.uri}")
    private String uri;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletRequest request,
                           HttpServletResponse response){
        System.out.println(code);
        System.out.println(state);
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(uri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_secret(clientserrcret);
        String accessTokoken = gitHubProvider.getAccessTokoken(accessTokenDTO);
        GithubUser githubUser = gitHubProvider.getUser(accessTokoken);
        if (githubUser!=null){
            User user=new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            System.out.println(user);
            Cookie cookie = new Cookie("token",token);
            cookie.setMaxAge(10*60);
            response.addCookie(cookie);
            return "redirect:/";
        }else{
            //登录失败
            return "redirect:/";
        }
    }
}
