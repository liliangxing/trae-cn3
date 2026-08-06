package com.bytedance.crash.event;

import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class EventConfig {
    private static boolean isStopped;
    private boolean isAllSample;
    private Set<String> sampledService;

    public EventConfig(boolean z) {
        this.isAllSample = z;
    }

    public EventConfig(Set<String> set) {
        this.sampledService = set;
    }

    public static void setStopEnable(boolean z) {
        isStopped = z;
    }

    public boolean isSampled(String str) {
        if (isStopped) {
            return false;
        }
        if (this.isAllSample) {
            return true;
        }
        Set<String> set = this.sampledService;
        return set != null && set.contains(str);
    }

    public String toString() {
        return "EventConfig{sampledService=" + this.sampledService + ", isAllSample=" + this.isAllSample + AbstractJsonLexerKt.END_OBJ;
    }
}
