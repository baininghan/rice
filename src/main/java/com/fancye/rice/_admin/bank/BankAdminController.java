/**
 * @Mailto: lvsedehuanxiang@163.com
 * @Blog: baininghan.com
 */
package com.fancye.rice._admin.bank;

import com.alibaba.fastjson.JSON;
import com.fancye.rice.common.kit.tree.Tree;
import com.jfinal.core.Controller;

import java.util.List;

/**
 * @Description: 机构
 * @Author: Fancye Bai
 * @Date: created in 20:26 2018/6/29
 */
public class BankAdminController extends Controller {

    static BankService s = new BankService();

    public void index() {
        render("bank.html");
    }

    public void list() {
        List<Tree> list = s.getLayuiTreeNodes(0);
        setAttr("nodes", JSON.toJSON(list));
        render("bank.html");
    }
}
