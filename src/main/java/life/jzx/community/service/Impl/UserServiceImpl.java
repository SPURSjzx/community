package life.jzx.community.service.Impl;

import life.jzx.community.mapper.UserMapper;
import life.jzx.community.model.User;
import life.jzx.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @Auther: Administrator
 * @Date: 2020/5/26 0026 14:28
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User findByAccountId(User user) {
        User user1 = userMapper.findByAccountId(user.getAccountId());
        return user1;
    }

    @Override
    public void createOrUpdate(User user) {
        User user1 = userMapper.findByAccountId(user.getAccountId());
        if(user1==null){
            //用户不存在，进行保存
            userMapper.insert(user);
        }else{
            //对用户进行修改
            user1.setGmtCreate(System.currentTimeMillis());
            user1.setAvatarUrl(user.getAvatarUrl());
            user1.setName(user.getName());
            user1.setToken(user.getToken());
            user1.setAccountId(user.getAccountId());
            System.out.println(user1.getAccountId());
            userMapper.update(user1);
        }
    }
}
