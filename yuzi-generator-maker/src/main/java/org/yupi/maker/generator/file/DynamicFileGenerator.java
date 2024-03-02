package org.yupi.maker.generator.file;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.yupi.maker.model.DataModel;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/*
* 动态生成代码
 */
public class DynamicFileGenerator {

    public static void doGenerate(String inputPath, String outputPath,  Object model) throws Exception {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);

        File templateFile = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateFile);

        configuration.setDefaultEncoding("UTF-8");

        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        DataModel dataModel = new DataModel();
        dataModel.setAuthor("yupi");
        dataModel.setLoop(false);
        dataModel.setOutputText("求和结果:");

        if (!FileUtil.exist(outputPath)){
            FileUtil.touch(outputPath);
        }

        Writer out = new FileWriter(outputPath);

        template.process(model, out);

        out.close();
    }
}
