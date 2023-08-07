package com.example.rule;

import java.util.List;

public class Header implements Renderable{
        public static final String PACKAGE = "package";
        public static final String IMPORT = "import";

        private String headerStr;

        @Override
        public String render() {
            return null;
        }

        public Header(String packageName, List<String> entities){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(PACKAGE + " ").append(packageName).append("\n");
            for (String entity: entities){
                stringBuilder.append(IMPORT + " ").append(entity).append("\n");
            }
            this.headerStr = stringBuilder.toString();
        }
    }

