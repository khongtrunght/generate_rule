package com.example.rule;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class Rule implements Renderable {
    private String ruleName;

    private final When when;
    private final Then then;

    public Rule(AlarmTypeTree alarmTypeTree, String ruleName) {
        this.when = new When(alarmTypeTree.getTreeNodes());
        this.then = new Then(alarmTypeTree.getTreeEdges());
        this.ruleName = ruleName;
    }

    public String render() {
        String headerStr = "rule \"" + ruleName + "\"\n";
        String whenStr = when.render();
        String thenStr = then.render();
        return headerStr + whenStr + thenStr;
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // String pathname = "/workspaces/codespaces-blank/demo/src/main/resources/trees.json";
            // AlarmTypeTree alarmTypeTree = objectMapper.readValue(new File(pathname), AlarmTypeTree.class);
            // Rule ruleFactory = new Rule(alarmTypeTree, "test");
            // System.out.println(ruleFactory.render());


            String pathname2 = "/workspaces/codespaces-blank/demo/src/main/resources/jsonobj.json";
            ArrayList<AlarmTypeTree> alarmTypeTrees = objectMapper.readValue(new File(pathname2), new TypeReference<ArrayList<AlarmTypeTree>>(){});
            int i = 0;
            for (AlarmTypeTree alarmTypeTree2: alarmTypeTrees){
                Rule ruleFactory2 = new Rule(alarmTypeTree2, String.format("test%d", i++));
                System.out.println(ruleFactory2.render());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}


