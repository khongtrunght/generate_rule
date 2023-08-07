package com.example.rule;

import java.util.Set;

public class When implements Renderable {
    private final String whenStr;

    public When(Set<TreeNode> treeNodes) {
        StringBuilder stringBuilder = new StringBuilder("\twhen\n");
        for (TreeNode treeNode : treeNodes) {
            // String line = String.format("$%s : Alarm(errorCode == '" + treeNode.getErrorCode() + "')\n", treeNode.getName());
            stringBuilder.append(treeNode.toRuleString());
        }
        this.whenStr = stringBuilder.toString();
    }

    @Override
    public String render() {
        return whenStr;
    }
}
