/**
 * @Mailto: lvsedehuanxiang@163.com
 * @Blog: baininghan.com
 */
package com.fancye.rice.common.kit.tree;

import java.util.List;

/**
 * @Description: layui 树结构数据格式化
 * @Author: Fancye Bai
 * @Date: created in 20:37 2018/6/29
 */
public class Tree {

    private String name;
    private boolean spread;
    private String href;
    private List<Tree> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }
}
