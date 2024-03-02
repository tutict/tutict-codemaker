package org.yupi.maker.model;

import lombok.Data;

@Data
public class DataModel {

/**
 * 静态模版配置
 */
        private String author = "yupi";

        private String outputText = "sum = ";

        private boolean loop; //是否循环
}
