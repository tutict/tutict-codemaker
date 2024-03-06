package ${basePackage}.maker.generator.file;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import ${basePackage}.maker.model.DataModel;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/*
* 动态生成代码
 */
public class DynamicGenerator {

    public static void doGenerate(String inputPath, String outputPath,  Object model) throws Exception {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);

        File templateFile = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateFile);

        configuration.setDefaultEncoding("UTF-8");

        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);


        if (!FileUtil.exist(outputPath)){
            FileUtil.touch(outputPath);
        }

        Writer out = new FileWriter(outputPath);

        template.process(model, out);

        out.close();
    }
}
