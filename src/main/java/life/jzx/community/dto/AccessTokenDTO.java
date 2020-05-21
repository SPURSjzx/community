package life.jzx.community.dto;

import lombok.Data;

/**
 * @Auther: Administrator
 * @Date: 2020/5/18 0018 14:24
 * @Description:
 */
@Data
public class AccessTokenDTO {

    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
