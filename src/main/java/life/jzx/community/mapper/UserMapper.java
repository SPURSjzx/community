package life.jzx.community.mapper;


import life.jzx.community.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/19 0019 14:10
 * @Description:
 */
@Mapper
public interface UserMapper {

    List<User> selectById(List<Integer> userIds);

    void insert(User user);

    User findByToken(String token);


    User findByAccountId(String accountId);

    void update(User user);
}
