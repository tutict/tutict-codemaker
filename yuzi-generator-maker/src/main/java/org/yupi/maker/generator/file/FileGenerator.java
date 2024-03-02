package org.yupi.maker.generator.file;

import org.yupi.maker.model.DataModel;

import java.io.File;

public class FileGenerator {


    public static void doGenerate(Object model) throws Exception {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        String inputPath = new File(parentFile, "yuzi-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;

        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);

        String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = projectPath + File.separator + "acm-template/src/com.yupi.acm/MainTemplate.java";

        DynamicFileGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);

    }

    public static void main(String[] args) throws Exception {

        DataModel dataModel = new DataModel();
        dataModel.setAuthor("yupi");
        dataModel.setLoop(false);
        dataModel.setOutputText("求和结果：");
        doGenerate(dataModel);
    }
}
