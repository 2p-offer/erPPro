package com.warship.test.javabase.classhotfix;

import java.lang.instrument.Instrumentation;
import java.util.Objects;

public class HotFixClassLoaderAgent {
    public static volatile Instrumentation inst;

    public static void initInstrumentation(Instrumentation inst) {
        HotFixClassLoaderAgent.inst = inst;
    }

    public static Instrumentation getInstrumentation() {
        if (Objects.isNull(inst)) {
            throw new IllegalStateException("Agent not initialized.");
        }
        return inst;
    }
}
