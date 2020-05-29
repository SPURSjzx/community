package life.jzx.community.dto;

import lombok.Data;

/**
 * @Auther: Administrator
 * @Date: 2020/5/28 0028 11:21
 * @Description:
 */
@Data
public class ComentDTO {

    private int parentId;
    private String content;
    private Integer type;
}
