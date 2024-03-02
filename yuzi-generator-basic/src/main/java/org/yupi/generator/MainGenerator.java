package org.yupi.generator;

import org.yupi.model.MainTemplateConfig;

import java.io.File;

public class MainGenerator {


    public static void doGenerate(Object model) throws Exception {
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + File.separator + "yuzi-generator-basic/src/main/resources/templates";
        String outputPath = projectPath;

        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        String inputDynamicFilePath = projectPath + File.separator + "yuzi-generator-basic/src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = projectPath + File.separator + "yuzi-generator-demo-projects/acm-template/src/com.yupi.acm/MainTemplate.java";

        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);

    }

    public static void main(String[] args) throws Exception {

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(mainTemplateConfig);
    }
}
