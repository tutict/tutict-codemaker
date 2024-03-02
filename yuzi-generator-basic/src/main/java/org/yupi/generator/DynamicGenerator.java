package org.yupi.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.yupi.model.MainTemplateConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/*
* 动态生成代码
 */
public class DynamicGenerator {
    public static void main(String[] args) throws Exception {

        String projectPath = System.getProperty("user.dir") + File.separator + "yuzi-generator-basic";
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("hgl");
        mainTemplateConfig.setOutputText("2019-03-28");
        mainTemplateConfig.setLoop(true);


        doGenerate(inputPath, outputPath, mainTemplateConfig);
    }

    public static void doGenerate(String inputPath, String outputPath,  Object model) throws Exception {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);

        File templateFile = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateFile);

        configuration.setDefaultEncoding("UTF-8");
        configuration.setNumberFormat("0.######");

        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);


        Writer out = new FileWriter(outputPath);

        template.process(model, out);

        out.close();
    }
}
