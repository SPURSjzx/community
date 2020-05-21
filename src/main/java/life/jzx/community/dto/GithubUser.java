package life.jzx.community.dto;

import lombok.Data;

/**
 * @Auther: Administrator
 * @Date: 2020/5/18 0018 15:05
 * @Description:
 */
@Data
public class GithubUser {

    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
