package com.bsty.icode.bean;

import com.bsty.icode.tree.TreeBuilder;
import lombok.Data;

@Data
public class Permission extends TreeBuilder.Node {
    private String url;
    private String description;
}
