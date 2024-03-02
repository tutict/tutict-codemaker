package org.yupi.model;

import lombok.Data;

@Data
public class MainTemplateConfig {

/**
 * 静态模版配置
 */
        private String author;

        private String outputText;

        private boolean loop; //是否循环
}
