package com.example.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class MyTreeNode {
    private Integer id;
    private String value;
    private String label;
    private Integer pid;
    private Integer isLeaf;
    private String title;
    private String userTypeIds;
    private String parentTitle;
    private List<MyTreeNode> children;
    public MyTreeNode(){
        this.children= new ArrayList<MyTreeNode>();
    }
    public MyTreeNode(Integer id, String value, String label,Integer isLeaf){
        this.id  = id;
        this.value = value;
        this.label = label;
        this.isLeaf = isLeaf;
        this.children= new ArrayList<MyTreeNode>();
    }
    public String toString(){
        return label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserTypeIds() {
        return userTypeIds;
    }

    public void setUserTypeIds(String userTypeIds) {
        this.userTypeIds = userTypeIds;
    }

    public String getParentTitle() {
        return parentTitle;
    }

    public void setParentTitle(String parentTitle) {
        this.parentTitle = parentTitle;
    }

    public List<MyTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<MyTreeNode> children) {
        this.children = children;
    }

}
