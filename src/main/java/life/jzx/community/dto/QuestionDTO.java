package life.jzx.community.dto;

import lombok.Data;

/**
 * @Auther: Administrator
 * @Date: 2020/5/20 0020 10:41
 * @Description:
 */
@Data
public class QuestionDTO {

    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tag='" + tag + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", creator=" + creator +
                '}';
    }
}
