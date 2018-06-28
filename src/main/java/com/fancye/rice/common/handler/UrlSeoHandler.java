/**
 * @Mailto: lvsedehuanxiang@163.com
 * @Blog: baininghan.com
 */
package com.fancye.rice.common.handler;

import com.jfinal.core.Action;
import com.jfinal.core.JFinal;
import com.jfinal.handler.Handler;
import com.jfinal.kit.HandlerKit;
import com.jfinal.kit.StrKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: Fancye Bai
 * @Date: created in 14:00 2018/6/27
 */
public class UrlSeoHandler extends Handler {

    private String detailMethodName;
    private String detailMethodWithSlash;

    public UrlSeoHandler() {
        detailMethodName = "detail";
        detailMethodWithSlash = "/" + detailMethodName + "/";
    }

    public UrlSeoHandler(String detailMethodName) {
        if (StrKit.isBlank(detailMethodName)) {
            throw new  IllegalArgumentException("detailMethodName can not be blank.");
        }
        this.detailMethodName = detailMethodName;
        this.detailMethodWithSlash = "/" + detailMethodName + "/";
    }

    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        // 静态请求直接跳出
        if(target.indexOf(".") != -1) {
            return;
        }

        String[] urlPara = {null};
        Action action = JFinal.me().getAction(target, urlPara);
        if(action != null) {
            String methodName = action.getMethodName();
            if ("index".equals(methodName)) {
                if (StrKit.notBlank(urlPara[0])) {
                    target = action.getControllerKey() + detailMethodWithSlash + urlPara[0];
                }
            }
            // 不允许 "detail" 出现在 url 中，映射到 detail() 方法的 url 仅使用 "/project/123" 这种格式
            else if (detailMethodName.equals(methodName)) {
                HandlerKit.renderError404(request, response, isHandled);
                return;
            }
        }

        next.handle(target, request, response, isHandled);
    }

}
