package life.jzx.community.controller;

import life.jzx.community.dto.AccessTokenDTO;
import life.jzx.community.dto.GithubUser;
import life.jzx.community.provide.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: Administrator
 * @Date: 2020/5/18 0018 14:17
 * @Description:
 */
@Controller
public class AuthorizeController {

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
                           @RequestParam(name = "state")String state){
        System.out.println(code);
        System.out.println(state);
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(uri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_secret(clientserrcret);
        String accessTokoken = gitHubProvider.getAccessTokoken(accessTokenDTO);
        GithubUser user = gitHubProvider.getUser(accessTokoken);
        System.out.println(user.getName());
        System.out.println(user.getId());
        return "index";
    }
}
