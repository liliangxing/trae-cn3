package com.bytedance.push.settings.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
final class ProcessorPool {
    private static Map<String, Processor> sMethodMap = new ConcurrentHashMap();

    ProcessorPool() {
    }

    static {
        register(new ContainsProcessor());
    }

    public static Processor get(String str) {
        return sMethodMap.get(str);
    }

    public static void register(Processor processor) {
        sMethodMap.put(processor.getMethodName(), processor);
    }
}
