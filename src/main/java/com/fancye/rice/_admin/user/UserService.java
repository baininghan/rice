/**
 * @Mailto: lvsedehuanxiang@163.com
 * @Blog: baininghan.com
 */
package com.fancye.rice._admin.user;

import com.fancye.rice.common.model.User;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

/**
 * @Description: 用户表操作业务类
 * @Author: Fancye Bai
 * @Date: created in 16:05 2018/6/29
 */
public class UserService {

    public static final UserService me = new UserService();

    public Page<User> paginate(int pageNumber, int pageSize) {
        return User.dao.paginate(pageNumber, pageSize, "select *", "from user order by id asc");
    }

    public List<User> dataList() {
        return User.dao.find("select * from user");
    }
}
