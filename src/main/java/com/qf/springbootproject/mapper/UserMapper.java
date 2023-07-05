package com.qf.springbootproject.mapper;

import com.qf.springbootproject.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @InterfaceName UserMapper
 * @Author Ashe
 * @Date 2023/6/28 19:00
 * @Description
 */
// 操作数据库层
@Repository
public interface UserMapper extends Mapper<User> {
}
