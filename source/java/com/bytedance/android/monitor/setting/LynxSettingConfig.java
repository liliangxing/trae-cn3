package com.bytedance.android.monitor.setting;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class LynxSettingConfig {
    public boolean enableMonitor = true;
    public boolean enableBlank = true;
    public boolean enableFetch = true;
    public boolean enableJSB = true;

    public String toString() {
        return "LynxMonitorConfig{enableMonitor=" + this.enableMonitor + ", enableBlank=" + this.enableBlank + ", enableFetch=" + this.enableFetch + ", enableJSB=" + this.enableJSB + AbstractJsonLexerKt.END_OBJ;
    }
}
