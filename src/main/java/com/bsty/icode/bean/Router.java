package com.bsty.icode.bean;

import lombok.Data;

import java.util.List;

@Data
public class Router {

    private long id;
    private long parentId;
    private String name;
    private String idPath;
    private String path;
    private String component;
    private String redirect;
    private String meta;
    private long level;
    private long hidden;
    private long type;
    List<Router> children;

}
