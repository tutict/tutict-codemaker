package ${basePackage}.maker.model;

import lombok.Data;

/**
* 数据模型
*/
@Data
public class DataModel {

<#list modelConfig.models as modelInfo>
<#-- 检查 modelInfo 及其属性是否存在 -->
    <#if modelInfo.description??>
        /**
        * ${modelInfo.description}
        */
    </#if>
    private ${modelInfo.type} ${modelInfo.fieldName}<#if modelInfo.defaultValue??> = ${modelInfo.defaultValue?c} </#if>

</#list>
}

