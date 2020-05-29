package life.jzx.community.model;

import lombok.Data;

/**
 * @Auther: Administrator
 * @Date: 2020/5/28 0028 11:14
 * @Description:
 */
@Data
public class Comment {

    private int id;
    private Integer parentId;
    private int type;
    private int commentator;
    private long gmt_create;
    private long gmt_modified;
    private int like_count;
    private String content;
}
