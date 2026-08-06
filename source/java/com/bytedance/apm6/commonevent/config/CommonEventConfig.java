package com.bytedance.apm6.commonevent.config;

import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class CommonEventConfig {
    private Set<String> sampledLogType;
    private Set<String> sampledService;

    public CommonEventConfig(Set<String> set, Set<String> set2) {
        this.sampledService = set;
        this.sampledLogType = set2;
    }

    public boolean isSampledService(String str) {
        Set<String> set = this.sampledService;
        return set != null && set.contains(str);
    }

    public boolean isSampledLogType(String str) {
        Set<String> set = this.sampledLogType;
        return set != null && set.contains(str);
    }

    public String toString() {
        return "CommonEventConfig{sampledService=" + this.sampledService + ", sampledLogType=" + this.sampledLogType + AbstractJsonLexerKt.END_OBJ;
    }
}
