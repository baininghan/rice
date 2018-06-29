/**
 * @Mailto: lvsedehuanxiang@163.com
 * @Blog: baininghan.com
 */
package com.fancye.rice.common.kit;

import com.jfinal.plugin.activerecord.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 返回给前端的数据格式化处理类
 * @Author: Fancye Bai
 * @Date: created in 16:17 2018/6/29
 */
public class Format {
    public static Map<String, Object> layuiPage(Page<?> page) {
        return layuiPage(page, 0, "");
    }

    /**
     * 按照layUI格式分页获取数据
     *
     * @param page
     * @param code
     * @param message
     */
    public static Map<String, Object> layuiPage(Page<?> page, int code, String message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("msg", message);
        result.put("count", page.getTotalRow());
        result.put("data", page.getList());
        return result;
    }

    public static Result result(Object data) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("ok");
        result.setData(data);
        return result;
    }

    /*public static Result layuiFile(File file, FileController controller) {
        Kv set = Kv.by("src", controller.getRequest().getContextPath() + "/file/get/" + file.getId())
                .set("title", file.getName());
        return result(set);
    }*/
}
