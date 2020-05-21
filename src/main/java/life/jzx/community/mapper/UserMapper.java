package life.jzx.community.mapper;


import life.jzx.community.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: Administrator
 * @Date: 2020/5/19 0019 14:10
 * @Description:
 */
@Mapper
public interface UserMapper {

     void insert(User user);

    User findByToken(String token);
}
