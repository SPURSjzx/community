package life.jzx.community.service;

import life.jzx.community.model.User;

/**
 * @Auther: Administrator
 * @Date: 2020/5/26 0026 14:28
 * @Description:
 */
public interface UserService {

    User findByAccountId(User user);

    void createOrUpdate(User user);
}
