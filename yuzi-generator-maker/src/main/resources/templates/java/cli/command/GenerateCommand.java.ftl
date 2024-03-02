package ${basePackage}.cli.command;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;
import ${basePackage}.generator.file.FileGenerator;
import ${basePackage}.model.DataModel;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name= "generate", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    <#list modelConfig.models as modelInfo>
        @Option(names = {<#if modelInfo.abbr??>"-${modelInfo.abbr}", </#if>"--${modelInfo.fieldName}"}, arity = "0..1"<#if modelInfo.description??>, description = "${modelInfo.description}"</#if>)
        private ${modelInfo.type} ${modelInfo.fieldName}<#if modelInfo.defaultValue??><#if modelInfo.type == 'boolean'> = ${modelInfo.defaultValue?c}<#else> = ${modelInfo.defaultValue}</#if></#if>;
    </#list>


    public Object call() throws Exception {

        DataModel dataModel = new DataModel();
        BeanUtil.copyProperties(this, dataModel);
        FileGenerator.doGenerate(dataModel);
        return null;
    }
}