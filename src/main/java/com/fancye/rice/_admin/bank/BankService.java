/**
 * @Mailto: lvsedehuanxiang@163.com
 * @Blog: baininghan.com
 */
package com.fancye.rice._admin.bank;

import com.fancye.rice.common.kit.tree.Tree;
import com.fancye.rice.common.model.Bank;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Fancye Bai
 * @Date: created in 20:41 2018/6/29
 */
public class BankService {

    public static final BankService me = new BankService();

    public List<Bank> list(int parBankId) {
        return Bank.dao.find("select * from bank where parBankId = ?", parBankId);
    }

    public List<Tree> getLayuiTreeNodes(int parBankId) {
        List<Bank> list = list(parBankId);
        List<Tree> children = new ArrayList<>();
        for (Bank bank : list) {
            Tree tree = new Tree();
            tree.setName(bank.getName());
            if (0 == bank.getParent()) {
                tree.setChildren(getLayuiTreeNodes(bank.getId()));
            }

            children.add(tree);
        }

        return children;
    }

}
