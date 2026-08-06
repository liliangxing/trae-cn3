package com.bytedance.crash.coredump;

import com.bytedance.crash.config.RuntimeConfig;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class CoreDumpConfig {
    private String configStr;
    private boolean isAsyncEnable;
    private boolean isEnable;
    private boolean isUploadEnable;
    private JSONArray nativeCrashFeature;

    public CoreDumpConfig(JSONArray jSONArray, boolean z, boolean z2, boolean z3) {
        this.configStr = null;
        this.isEnable = z && z2;
        if (jSONArray == null || jSONArray.length() >= 10) {
            this.isEnable = false;
        }
        if (this.isEnable) {
            StringBuffer stringBuffer = new StringBuffer("");
            boolean equals = "1".equals(jSONArray.optString(0));
            for (int i = 0; i < jSONArray.length(); i++) {
                stringBuffer.append(jSONArray.optString(i) + "#");
            }
            this.isEnable = equals;
            this.configStr = stringBuffer.toString();
        } else if (RuntimeConfig.isLocalTest()) {
            this.isEnable = true;
            this.configStr = "1#all#all#null#lib#SIG#0#0#7#";
        }
        this.isAsyncEnable = z3;
    }

    public String getCoreDumpConfig() {
        return this.configStr;
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public boolean isUploadEnable() {
        return this.isUploadEnable;
    }

    public JSONArray getNativeCrashFeature() {
        return this.nativeCrashFeature;
    }

    public String toString() {
        return "CoreDumpConfig{isEnable=" + this.isEnable + ", nativeCrashFeature=" + this.nativeCrashFeature + AbstractJsonLexerKt.END_OBJ;
    }
}
