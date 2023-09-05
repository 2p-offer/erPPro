package com.warship.test.javabase.jarfile;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;

public class JarFileUtil {
    public static void main(String[] args) throws Exception {
        String path = "/Users/erp/Downloads/tmp/gameserver-0.0.1.jar";
        JarFile jarFile =  new JarFile(path);
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = entries.nextElement();
            System.out.println("Entry Name: " + jarEntry.getName() + ", Size: " + jarEntry.getSize());

        }
    }
}
