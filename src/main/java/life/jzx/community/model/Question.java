package life.jzx.community.model;

import lombok.Data;

import javax.lang.model.element.NestingKind;

/**
 * @Auther: Administrator
 * @Date: 2020/5/20 0020 10:20
 * @Description:
 */
@Data
public class Question {

    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
}
