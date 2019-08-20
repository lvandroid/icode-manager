package com.bsty.icode.bean;

import com.bsty.icode.tree.TreeBuilder;
import lombok.Data;

import java.util.List;

@Data
public class Router extends TreeBuilder.Node {
    private String idPath;
    private String path;
    private String label;
    private String component;
    private String redirect;
    private String meta;
    private int level;
    private boolean hidden;
    private int type;
}
