/**
 * @Mailto: lvsedehuanxiang@163.com
 * @Blog: baininghan.com
 */
package com.fancye.rice._admin.user;

import com.fancye.rice.common.model.User;
import com.jfinal.plugin.activerecord.Page;

/**
 * @Description: 用户表操作业务类
 * @Author: Fancye Bai
 * @Date: created in 16:05 2018/6/29
 */
public class UserService {

    public static final UserService me = new UserService();

    private static final User dao = new User();

    public Page<User> paginate(int pageNumber, int pageSize) {
        return dao.paginate(pageNumber, pageSize, "select *", "from user order by loginDateTime desc");
    }
}
