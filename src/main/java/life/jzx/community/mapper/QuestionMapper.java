package life.jzx.community.mapper;

import life.jzx.community.dto.PaginationDTO;
import life.jzx.community.dto.QuestionDTO;
import life.jzx.community.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/20 0020 10:12
 * @Description:
 */
@Mapper
public interface QuestionMapper {

    void create(QuestionDTO questionDTO);

    List<QuestionDTO> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select count(1) from question where creator=17")
    Integer countbyid(Integer id);

    PaginationDTO listbyid(@Param(value = "creator") Integer id, @Param(value = "page") Integer page, @Param(value = "size") Integer size);

    QuestionDTO getById(@Param("id") Integer id);

    void update(QuestionDTO questionDTO);
}
