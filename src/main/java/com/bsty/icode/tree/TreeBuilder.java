package com.bsty.icode.tree;

import com.bsty.icode.bean.Router;
import lombok.Data;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class TreeBuilder {
    List<? extends Node> nodes = new ArrayList<>();

    public JSONArray buildTree(List<? extends Node> nodes) {

        TreeBuilder treeBuilder = new TreeBuilder(nodes);

        return treeBuilder.buildJSONTree();
    }

    public TreeBuilder() {
    }

    public TreeBuilder(List<? extends Node> nodes) {
        super();
        this.nodes = nodes;
    }

    // 构建JSON树形结构
    public JSONArray buildJSONTree() {
        List<Node> nodeTree = buildTree();
        JSONArray jsonArray = JSONArray.fromObject(nodeTree);
//        return jsonArray.toString();
        return jsonArray;
    }

    // 构建树形结构
    public List<Node> buildTree() {
        List<Node> treeNodes = new ArrayList<>();
        List<Node> rootNodes = getRootNodes();
        for (Node rootNode : rootNodes) {
            buildChildNodes(rootNode);
            treeNodes.add(rootNode);
        }
        return treeNodes;
    }

    // 递归子节点
    public void buildChildNodes(Node node) {
        List<Node> children = getChildNodes(node);
        if (!children.isEmpty()) {
            for (Node child : children) {
                buildChildNodes(child);
            }
            node.setChildren(children);
        }
    }

    // 获取父节点下所有的子节点
    public List<Node> getChildNodes(Node pnode) {
        List<Node> childNodes = new ArrayList<>();
        for (Node n : nodes) {
            if (pnode.getId()==(n.getPid())) {
                childNodes.add(n);
            }
        }
        return childNodes;
    }

    // 判断是否为根节点
    public boolean rootNode(Node node) {
        boolean isRootNode = true;
        for (Node n : nodes) {
            if (node.getPid()==(n.getId())) {
                isRootNode = false;
                break;
            }
        }
        return isRootNode;
    }

    // 获取集合中所有的根节点
    public List<Node> getRootNodes() {
        List<Node> rootNodes = new ArrayList<>();
        for (Node n : nodes) {
            if (rootNode(n)) {
                rootNodes.add(n);
            }
        }
        return rootNodes;
    }

    @Data
    public static class Node {

        protected long id;
        protected long pid;
        protected String name;
        protected List<Node> children;

        public Node() {
        }

        public Node(long id, long pid, String name) {
            super();
            this.id = id;
            this.pid = pid;
            this.name = name;
        }
    }
}
