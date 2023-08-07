package com.example.rule;

public class TreeNode {
    private String name;
    private String errorCode;

    public TreeNode(String name, String errorCode){
        this.name = name;
        this.errorCode = errorCode;
    }

    public TreeNode(){
    }

    public String toRuleString(){
        return String.format("\t\t$%s : Alarm(errorCode == '" + errorCode + "')\n", name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (!(obj instanceof TreeNode))
            return false;
        if (obj == this)
            return true;
        return this.getName().equals(((TreeNode) obj).getName());
    }
}