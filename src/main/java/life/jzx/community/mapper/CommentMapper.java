package life.jzx.community.mapper;

import life.jzx.community.model.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: Administrator
 * @Date: 2020/5/28 0028 11:23
 * @Description:
 */
@Mapper
public interface CommentMapper {

    void insert(Comment comment);

    Comment selectByPrimryKey(Integer parentId);
}
