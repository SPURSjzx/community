package life.jzx.community.dto;

import life.jzx.community.model.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/20 0020 10:41
 * @Description:
 */
@Data
public class QuestionDTO {

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

    private User users;


}
