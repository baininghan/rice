/**
 * @Mailto: lvsedehuanxiang@163.com
 * @Blog: baininghan.com
 */
package com.fancye.rice.common;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.fancye.rice.common.kit.DruidKit;
import com.fancye.rice.common.model._MappingKit;
import com.fancye.rice.common.routes.APIRoutes;
import com.fancye.rice.common.routes.AdminRoutes;
import com.jfinal.config.*;
import com.jfinal.json.MixedJsonFactory;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.JsonRender;
import com.jfinal.template.Engine;

import java.sql.Connection;

/**
 * @Description: JFinal总配置
 * @Author: Fancye Bai
 * @Date: created in 13:27 2018/6/27
 */
public class RiceConfig extends JFinalConfig {

    private static Prop p = PropKit.use("rice_config_dev.txt").appendIfExists("rice_config_pro.txt");

    private WallFilter wallFilter;

    @Override
    public void configConstant(Constants me) {
        me.setDevMode(p.getBoolean("devMode", false));
        me.setJsonFactory(MixedJsonFactory.me());
    }

    @Override
    public void configRoute(Routes me) {
        me.add(new AdminRoutes());
        me.add(new APIRoutes());
        /*me.add(new FrontRoutes());*/
    }

    @Override
    public void configEngine(Engine me) {
        /*me.setDatePattern("yyyy-MM-dd HH:mm:ss");*/

        /*me.addDirective("now", NowDirective.class);*/

        me.addSharedFunction("/template/_admin_layout.html");
    }

    @Override
    public void configPlugin(Plugins me) {
        DruidPlugin dp = getDruidPlugin();
        wallFilter = new WallFilter();
        wallFilter.setDbType("mysql");
        dp.addFilter(wallFilter);
        dp.addFilter(new StatFilter());
        me.add(dp);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        arp.setTransactionLevel(Connection.TRANSACTION_READ_COMMITTED);
        arp.setContainerFactory(new CaseInsensitiveContainerFactory(true));
        arp.setShowSql(p.getBoolean("devMode", false));
        _MappingKit.mapping(arp);
        me.add(arp);

        me.add(new EhCachePlugin());
        me.add(new Cron4jPlugin());
    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {
        me.add(DruidKit.getDruidStatViewHandler());
        //me.add(new UrlSeoHandler());
    }

    @Override
    public void afterJFinalStart() {
        // 调用不带参的 renderJson() 时，排除对 loginAccount、remind 的 json 转换
        JsonRender.addExcludedAttrs(
                /*LoginService.loginAccountCacheName,
                LoginSessionInterceptor.remindKey,
                FriendInterceptor.followNum, FriendInterceptor.fansNum, FriendInterceptor.friendRelation*/
        );

        // 让 druid 允许在 sql 中使用 union
        // https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE-wallfilter
        //wallFilter.getConfig().setSelectUnionCheck(false);
    }

    public static DruidPlugin getDruidPlugin() {
        return new DruidPlugin(p.get("jdbcUrl"), p.get("user"), p.get("password"));
    }
}
