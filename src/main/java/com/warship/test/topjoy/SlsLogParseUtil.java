package com.warship.test.topjoy;

import java.io.*;

public class SlsLogParseUtil {
    public static void main(String[] args) throws IOException {

        String inputFile = "/Users/erp/tmp/tmp.log";
        String outputFile = "/Users/erp/tmp/result.log";
        File file = new File(inputFile);
        if (!file.exists()) {
            throw new RuntimeException(inputFile + "文件不存在");
        }
        File outFile = new File(outputFile);
        if(!outFile.exists()){
            outFile.createNewFile();
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, false));

            String line;
            while ((line = reader.readLine()) != null) {
                int startIndex = line.indexOf("\"content\":\"") + "\"content\":\"".length();
                int endIndex = line.length() - 2;
                if (startIndex >= 0 && endIndex >= 0 && endIndex > startIndex) {
                    String content = line.substring(startIndex, endIndex);
                    if (content.contains("\\tat") ) {
                        content = content.replaceAll("\\\\tat", "\tat");
                    }
                    if (content.contains("\\n") ) {
                        content = content.replaceAll("\\\\n", "\n");
                    }
                    writer.write(content);
                    writer.newLine();
                }
            }

            reader.close();
            writer.close();
            System.out.println("File processing complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
