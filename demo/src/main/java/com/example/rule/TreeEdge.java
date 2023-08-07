package com.example.rule;

public class TreeEdge {
    private String from;
    private String to;

    public TreeEdge(String from, String to){
        this.from = from;
        this.to = to;
    }

    public TreeEdge(){
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String toRuleString(){
        //  stringBuilder.append(String.format("\t\t$%s.setParent($%s);\n", treeEdge.getTo(), treeEdge.getFrom()));
        // stringBuilder.append(String.format("\t\t$%s.setChildren($%s);\n", treeEdge.getFrom(), treeEdge.getTo()));
        return String.format("\t\t$%s.setParent($%s);\n", to, from) + String.format("\t\t$%s.setChildren($%s);\n", from, to);
    }
}