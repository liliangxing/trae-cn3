package com.bytedance.crash.event;

import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class BizExceptionConfig {
    private boolean isEnableUpload;
    private Set<String> sampledLogTypes;

    public BizExceptionConfig(boolean z, Set<String> set) {
        this.isEnableUpload = z;
        this.sampledLogTypes = set;
    }

    public boolean isEnable() {
        return this.isEnableUpload;
    }

    public boolean isSampled(String str) {
        Set<String> set = this.sampledLogTypes;
        if (set == null) {
            return false;
        }
        return set.contains(str);
    }

    public String getSampleType() {
        Set<String> set = this.sampledLogTypes;
        return set == null ? "null" : set.toString();
    }

    public String toString() {
        return "BizExceptionConfig{isEnableUpload=" + this.isEnableUpload + ", sampledLogTypes=" + this.sampledLogTypes + AbstractJsonLexerKt.END_OBJ;
    }
}
