package com.warship.test.javabase.classhotfix;

import net.bytebuddy.agent.ByteBuddyAgent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class JarByteHotFix implements ApplicationListener<ApplicationStartedEvent> {

    private HotFixClassLoaderAgent hotFixClassLoaderAgent;


    private static final class InstrumentationHolder {
        private static final Instrumentation instrumentation = ByteBuddyAgent.install();
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        try {
            HotFixClassLoaderAgent.initInstrumentation(InstrumentationHolder.instrumentation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String hotfixClass(String className, String newClassName) throws Exception {
        // 读取新类的字节码
        byte[] newClassBytes = Files.readAllBytes(Paths.get(newClassName));
        // 加载新类
        Class<?> newClass = Class.forName(className);
        System.out.println("新类加载成功：" + newClass.getName());

        // 重新定义类
        ClassDefinition classDefinition = new ClassDefinition(Class.forName(className), newClassBytes);
        HotFixClassLoaderAgent.getInstrumentation().redefineClasses(classDefinition);
        return className;
    }


}
