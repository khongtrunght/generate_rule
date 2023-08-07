package com.example.rule;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlarmTypeTree {
    @JsonProperty("nodes")
    private Set<TreeNode> treeNodes;
    @JsonProperty("edges")
    private Set<TreeEdge> treeEdges;

    public AlarmTypeTree(Set<TreeNode> treeNodes, Set<TreeEdge> treeEdges){
        this.treeNodes = treeNodes;
        this.treeEdges = treeEdges;
    }

    public AlarmTypeTree(){
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (TreeNode treeNode: treeNodes){
            stringBuilder.append(treeNode.getName()).append(" ").append(treeNode.getErrorCode()).append("\n");
        }
        for (TreeEdge treeEdge: treeEdges){
            stringBuilder.append(treeEdge.getFrom()).append(" ").append(treeEdge.getTo()).append("\n");
        }
        return stringBuilder.toString();
    }

    public Set<TreeNode> getTreeNodes() {
        return treeNodes;
    }

    public Set<TreeEdge> getTreeEdges() {
        return treeEdges;
    }


}

