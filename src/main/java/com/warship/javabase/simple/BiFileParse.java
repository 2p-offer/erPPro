package com.warship.test.javabase.simple;

import com.google.common.base.CaseFormat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Objects;

/**
 * @author erp
 */
public class BiFileParse {

    public static void main(String[] args) throws Exception {
        String fileName = "/Users/erp/self/text/待做/tmp";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] s = line.split("\t");
            String desc = s[0].trim();
            String value = s.length > 1 ? s[1].trim() : null;
            String type = s.length > 2 ? s[2].trim() : null;
            System.out.println("    /** " + desc + " */");
            System.out.println("    @JSONField(name = \"" + value + "\")");
            String dataType = getDataType(type);
            System.out.println("    private" + getDataType(dataType) + getFieldValue(value) + ";");
        }
    }

    private static String getFieldValue(String value) {
        if (Objects.isNull(value)) {
            return "NULL";
        }
        final char beginChar = value.charAt(0);
        if (beginChar == '#') {
            value = value.substring(1);
        }
        if (beginChar >= 65 && beginChar <= 90) {
            String endValue = value.substring(1);
            String startValue = String.valueOf((char) (beginChar + 32));
            value = startValue + endValue;
        }
        if (value.contains("_")) {
            value = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, value);
        }
        return value;
    }

    private static String getDataType(String type) {
        String ans = " String ";
        if (Objects.isNull(type)) {
            return ans;
        }
        if ("数值".equals(type)) {
            ans = " int ";
        } else {
        }
        return ans;
    }
}
