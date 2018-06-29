/**
 * @Mailto: lvsedehuanxiang@163.com
 * @Blog: baininghan.com
 */
package com.fancye.rice._admin.bank;

import com.fancye.rice.common.model.Bank;

import java.util.List;

/**
 * @Description:
 * @Author: Fancye Bai
 * @Date: created in 20:41 2018/6/29
 */
public class BankService {

    public static final BankService me = new BankService();

    public List<Bank> list(int parMenuId) {
        return Bank.dao.find("select * from bank where parMenuId = ?", parMenuId);
    }

    public void getLayuiTreeNodes(int parMenuId) {
        List<Bank> list = list(0);
        for (Bank bank : list) {

        }
    }

}
