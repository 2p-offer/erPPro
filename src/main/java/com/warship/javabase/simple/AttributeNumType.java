package com.warship.test.javabase.simple;

/**
 * 属性数值类型
 *
 * @author erp
 */
public enum AttributeNumType {
    /** 基础值 */
    BASE("base"),
    /** 增加累加百分比 */
    PERCENT_ADD_UP("percentAddUp"),
    /** 减少累加百分比 */
    PERCENT_ADD_DOWN("percentAddDown"),
    /** 增加累乘百分比 */
    PERCENT_MULTIPLY("percentMultiply"),
    /** 绝对值 */
    ABSOLUTE("absolute"),
    ;

    private final String type;

    AttributeNumType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
