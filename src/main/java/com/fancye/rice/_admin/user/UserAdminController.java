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

    public void init() {
        for (int i = 0; i < 20; i++) {
            User u = new User();
            u.setName("test" + i);
            u.setNickname("test" + i);
            u.setSex(1);
            u.setTel("18627596970");
            u.setEmail("test@test.com");

            u.save();
        }

        renderNull();
    }

    public void index() {
        render("user.html");
    }

    public void list() {
        Integer pageNumber = getParaToInt("page", 1);
        Integer pageSize = getParaToInt("limit", 10);

        Page<User> p = s.paginate(pageNumber, pageSize);
        renderJson(Format.layuiPage(p));
    }

    public void edit() {
        User user = getBean(User.class, "user");
        boolean result = user.update();

        String name = getPara("name");
        String nickname = getPara("nickname");
        String sex = getPara("sex");

        render("user.html");
    }

    public void add() {

    }
}
