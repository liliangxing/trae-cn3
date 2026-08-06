package com.bytedance.apm.agent.v2.instrumentation;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class BatteryAgent {
    private static final Map<String, MethodExecutedValue> sExecutedRecord = new HashMap();
    private static ThreadLocal<HashMap<String, MethodExecutingValue>> sExecutingRecord = new ThreadLocal<>();
    private static boolean hasHook = false;

    /* loaded from: classes3.dex */
    public static class MethodExecutedValue {
        private int exeCount = 0;
        private int cpuCost = 0;

        public void addValue(MethodExecutingValue methodExecutingValue) {
            this.exeCount += methodExecutingValue.exeCount;
            this.cpuCost = (int) (this.cpuCost + (methodExecutingValue.end - methodExecutingValue.start));
        }

        public String toString() {
            return "MethodExecutedValue{exeCount=" + this.exeCount + ", cpuCost=" + this.cpuCost + AbstractJsonLexerKt.END_OBJ;
        }

        public int getCount() {
            return this.exeCount;
        }

        public int getCost() {
            return this.cpuCost;
        }
    }

    /* loaded from: classes3.dex */
    public static class MethodExecutingValue {
        private long start = 0;
        private long end = 0;
        private int leftCount = 0;
        private int exeCount = 0;

        public void methodIn() {
            if (this.exeCount == 0) {
                this.start = SystemClock.currentThreadTimeMillis();
            }
            this.leftCount++;
            this.exeCount++;
        }

        public boolean methodOut() {
            int i = this.leftCount - 1;
            this.leftCount = i;
            if (i != 0) {
                return false;
            }
            this.end = SystemClock.currentThreadTimeMillis();
            return true;
        }
    }

    public static boolean hasHook() {
        return hasHook;
    }

    public static void s(String str) {
        hasHook = true;
        HashMap<String, MethodExecutingValue> hashMap = sExecutingRecord.get();
        if (hashMap == null) {
            hashMap = new HashMap<>();
            sExecutingRecord.set(hashMap);
        }
        MethodExecutingValue methodExecutingValue = hashMap.get(str);
        if (methodExecutingValue == null) {
            methodExecutingValue = new MethodExecutingValue();
            hashMap.put(str, methodExecutingValue);
        }
        methodExecutingValue.methodIn();
    }

    public static void e(String str) {
        MethodExecutingValue methodExecutingValue;
        HashMap<String, MethodExecutingValue> hashMap = sExecutingRecord.get();
        if (hashMap == null || (methodExecutingValue = hashMap.get(str)) == null || !methodExecutingValue.methodOut()) {
            return;
        }
        hashMap.remove(str);
        Map<String, MethodExecutedValue> map = sExecutedRecord;
        synchronized (map) {
            MethodExecutedValue methodExecutedValue = map.get(str);
            if (methodExecutedValue == null) {
                methodExecutedValue = new MethodExecutedValue();
                map.put(str, methodExecutedValue);
            }
            methodExecutedValue.addValue(methodExecutingValue);
        }
    }

    public static Map<String, MethodExecutedValue> filterResultAndClear(long j) {
        HashMap hashMap;
        Map<String, MethodExecutedValue> map = sExecutedRecord;
        if (map.isEmpty()) {
            return null;
        }
        synchronized (map) {
            hashMap = new HashMap();
            for (Map.Entry<String, MethodExecutedValue> entry : map.entrySet()) {
                if (entry.getValue().cpuCost > j) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            sExecutedRecord.clear();
        }
        return hashMap;
    }
}
