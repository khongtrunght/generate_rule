package com.example.rule;

import java.util.Set;
public class Then implements Renderable {
    private final String thenStr;

    public Then(Set<TreeEdge> treeEdges) {
        StringBuilder stringBuilder = new StringBuilder("\tthen\n");
        for (TreeEdge treeEdge : treeEdges) {
            // stringBuilder.append(String.format("\t\t$%s.setParent($%s);\n", treeEdge.getTo(), treeEdge.getFrom()));
            // stringBuilder.append(String.format("\t\t$%s.setChildren($%s);\n", treeEdge.getFrom(), treeEdge.getTo()));
            stringBuilder.append(treeEdge.toRuleString());
        }
        stringBuilder.append("end\n");
        this.thenStr = stringBuilder.toString();
    }

    @Override
    public String render() {
        return thenStr;
    }
}
