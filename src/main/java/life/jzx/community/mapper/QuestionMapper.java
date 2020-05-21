package life.jzx.community.mapper;

import life.jzx.community.dto.QuestionDTO;
import life.jzx.community.model.Question;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: Administrator
 * @Date: 2020/5/20 0020 10:12
 * @Description:
 */
@Mapper
public interface QuestionMapper {

    void create(QuestionDTO questionDTO);
}
