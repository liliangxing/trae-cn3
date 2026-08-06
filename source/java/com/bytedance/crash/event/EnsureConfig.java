package com.bytedance.crash.event;

import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class EnsureConfig {
    private static boolean isStopped;
    private JSONObject exceptionMessage;
    private boolean isAllEnable;
    private boolean isUploadEnable;
    private Set<String> sampledLogType;

    public EnsureConfig(Set<String> set, JSONObject jSONObject, boolean z) {
        this.sampledLogType = set;
        this.isUploadEnable = z;
        if (jSONObject != null) {
            this.exceptionMessage = jSONObject;
        } else {
            this.exceptionMessage = new JSONObject();
        }
    }

    public EnsureConfig(boolean z) {
        this.isAllEnable = z;
    }

    public boolean isMessageSample(String str) {
        JSONObject jSONObject;
        if (this.isAllEnable || (jSONObject = this.exceptionMessage) == null) {
            return true;
        }
        return Math.random() <= jSONObject.optDouble(str, 1.0d);
    }

    public static void setStopEnable(boolean z) {
        isStopped = z;
    }

    public boolean isUploadEnable() {
        return this.isAllEnable || this.isUploadEnable;
    }

    public boolean isSample(String str, String str2) {
        if (!isStopped && isSample(str)) {
            return isMessageSample(str2);
        }
        return false;
    }

    public boolean isSample(String str) {
        if (isStopped) {
            return false;
        }
        if (this.isAllEnable) {
            return true;
        }
        if ("core_exception_monitor".equals(str)) {
            return this.isUploadEnable;
        }
        Set<String> set = this.sampledLogType;
        return set != null && set.contains(str);
    }

    public String toString() {
        return "EnsureConfig{sampledLogType=" + this.sampledLogType + ", isCoreExceptionEnable=" + this.isUploadEnable + ", exceptionMessage=" + this.exceptionMessage + ", isAllEnable=" + this.isAllEnable + AbstractJsonLexerKt.END_OBJ;
    }
}
