package life.jzx.community.dto;

import life.jzx.community.model.User;
import lombok.Data;

/**
 * @Auther: Administrator
 * @Date: 2020/6/3 0003 14:39
 * @Description:
 */
@Data
public class CommentDTO {
    private int id;
    private Integer parentId;
    private int type;
    private int commentator;
    private long gmt_create;
    private long gmt_modified;
    private int like_count;
    private String content;
    private User user;
}

