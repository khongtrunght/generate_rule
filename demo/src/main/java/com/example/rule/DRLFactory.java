package com.example.rule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DRLFactory {
    public static final String HEADER = "package AlarmRules\nimport com.neo.drools.entity.Alarm\n";
    private List<Rule> rules;

    public DRLFactory() {
        rules = new ArrayList<>();
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public String render() {
        StringBuilder stringBuilder = new StringBuilder(HEADER);
        for (Rule rule : rules) {
            stringBuilder.append("\n").append(rule.render()).append("\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // String pathname2 = "/workspaces/codespaces-blank/demo/src/main/resources/jsonobj.json";
            // path is in args
            if (args.length != 2) {
                System.out.println("Usage: java -jar xxx.jar <inputPath> <outputPath>");
                System.exit(1);
            }
            String inputPath = args[0];
            String outputPath = args[1];
            ArrayList<AlarmTypeTree> alarmTypeTrees = objectMapper.readValue(new File(inputPath), new TypeReference<ArrayList<AlarmTypeTree>>(){});
            int i = 0;
            DRLFactory ruleFactory = new DRLFactory();
            for (AlarmTypeTree alarmTypeTree2: alarmTypeTrees){
                // Rule rule = new Rule(alarmTypeTree2, String.format("test%d", i++));
                ruleFactory.addRule(new Rule(alarmTypeTree2, String.format("test%d", i++)));
            }
            
            //  write ruleFactory.render() string to outputPath
            Path path = Paths.get(outputPath);
            Files.writeString(path, ruleFactory.render());
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
