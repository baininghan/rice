/**
 * @Mailto: lvsedehuanxiang@163.com
 * @Blog: baininghan.com
 */
package com.fancye.rice._admin.user;

import com.fancye.rice.common.kit.Format;
import com.fancye.rice.common.model.User;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

/**
 * @Description: 用户后台管理
 * @Author: Fancye Bai
 * @Date: created in 15:48 2018/6/29
 */
public class UserAdminController extends Controller {

    static UserService s = UserService.me;

    public void index() {
        render("user.html");
    }

    public void list() {
        Integer pageNumber = getParaToInt("pageNumber", 1);
        Integer pageSize = getParaToInt("pageSize", 10);

        Page<User> p = s.paginate(pageNumber, pageSize);
        renderJson(Format.layuiPage(p));
    }
}
