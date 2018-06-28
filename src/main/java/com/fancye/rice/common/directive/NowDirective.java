/**
 * @Mailto: lvsedehuanxiang@163.com
 * @Blog: baininghan.com
 */
package com.fancye.rice.common.directive;

import com.jfinal.template.Directive;
import com.jfinal.template.Env;
import com.jfinal.template.io.Writer;
import com.jfinal.template.stat.Scope;

import java.util.Date;

/**
 * @Description: #now 创建一个模板引擎，输出当前日期
 * @Author: Fancye Bai
 * @Date: created in 20:35 2018/6/27
 */
public class NowDirective extends Directive {

    @Override
    public void exec(Env env, Scope scope, Writer writer) {
        write(writer, new Date().toString());
    }

}
