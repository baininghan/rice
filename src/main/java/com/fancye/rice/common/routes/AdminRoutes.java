/**
 * @Mailto: lvsedehuanxiang@163.com
 * @Blog: baininghan.com
 */
package com.fancye.rice.common.routes;

import com.fancye.rice._admin.index.IndexAdminController;
import com.fancye.rice._admin.user.UserAdminController;
import com.jfinal.config.Routes;

/**
 * @Description: 后台管理路由
 * @Author: Fancye Bai
 * @Date: created in 13:36 2018/6/27
 */
public class AdminRoutes extends Routes {

    @Override
    public void config() {
        setBaseViewPath("/_view/_admin");

        add("/admin", IndexAdminController.class, "/index");
        add("/user", UserAdminController.class, "/user");
    }
}
