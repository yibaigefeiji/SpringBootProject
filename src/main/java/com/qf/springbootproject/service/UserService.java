package com.qf.springbootproject.service;

import com.qf.springbootproject.mapper.UserMapper;
import com.qf.springbootproject.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserService
 * @Author Ashe
 * @Date 2023/6/28 19:06
 * @Description
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 登录
     * @param username
     * @param password
     * @return 登录成功返回对应登录得用户信息
     */
    public User login(String username, String password) {

        User user = new User();

        user.setUsername(username);
        user.setPassword(password);

        User ret = userMapper.selectOne(user);

        return ret;

    }

    /**
     * 根据用户提供得账号密码完成注册
     * @param username
     * @param password
     * @return 注册成功1，注册失败0
     */
    public int regist(String username, String password) {
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);

        int insert = userMapper.insert(user);

        return insert;

    }

    /**
     * 修改密码
     * @param username 用户名
     * @param oldPwd 原始密码
     * @param newPwd 修改得新密码
     * @return 修改结果
     */
    public String updatePassword(String username, String oldPwd, String newPwd) {
        User user = new User();

        // 根据用户名查询对应用户
        user.setUsername(username);

        // 通过以上对象查询是否存在该用户
        User ret = userMapper.selectOne(user);

        System.out.println(ret);

        if(ret.getPassword().equals(oldPwd)) {
            // 查询到得结果，将结果中得旧密码替换成用户想要修改得密码
            ret.setPassword(newPwd);
            // 根据ret查询到得主键去修改用户得密码
            int i = userMapper.updateByPrimaryKey(ret);
            if(i != 0) {
                return "修改成功";
            } else {
                return "修改失败";
            }
        } else {
            return "您输入得原始密码是错误得";
        }
    }

    /**
     * 根据主键ID删除用户
     * @param id 参数
     * @return 被影响的行数，成功为1，失败为0
     */
    public int deleteUser(int id) {
        int i = userMapper.deleteByPrimaryKey(id);
        return i;
    }

    /**
     * 查询全部
     * @return User类型得List集合
     */
    public List<User> selectAll() {
        List<User> users = userMapper.selectAll();

        for (User user : users) {
            System.out.println(user);
        }

        return users;
    }
}
