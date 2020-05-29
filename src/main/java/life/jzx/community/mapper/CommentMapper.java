package life.jzx.community.mapper;

import life.jzx.community.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: Administrator
 * @Date: 2020/5/28 0028 11:23
 * @Description:
 */
@Mapper
public interface CommentMapper {

    void insert(@Param("comment") Comment comment);

    Comment selectByPrimryKey(Integer parentId);
}
