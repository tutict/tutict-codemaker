package ${basePackage}.generator;

import ${basePackage}.model.MainTemplateConfig;

import java.io.File;

public class MainGenerator {

public static void doGenerate(Object model) throws Exception {

String inputRootPath = "${fileConfig.inputRootPath}";
String outputRootPath = "${fileConfig.outputRootPath}";

String inputPath;
String outputPath;

<#list fileConfig.files as fileInfo>
    inputPath = new File(inputRootPath, "${fileInfo.inputPath}").getAbsolutePath();
    outputPath = new File(outputRootPath, "${fileInfo.outputPath}").getAbsolutePath();
    <#if fileInfo.generateType == "static">
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);
        <#else >
            DynamicGenerator.doGenerate(inputPath, outputPath, model);
    </#if>

</#list>

   }
}
