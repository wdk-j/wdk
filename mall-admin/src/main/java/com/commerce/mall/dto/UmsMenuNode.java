package com.commerce.mall.dto;

import com.commerce.mall.model.UmsMenu;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 后台菜单节点封装
 * Created by commerce on 2020/2/4.
 */
@Getter
@Setter
public class UmsMenuNode extends UmsMenu {

    private List<UmsMenuNode> children;
}
