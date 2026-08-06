package com.bytedance.android.monitor.setting;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class WebSettingConfig {
    public boolean enableMonitor = true;
    public boolean enableBlank = true;
    public boolean enableFetch = true;
    public boolean enableJSB = true;
    public boolean enableInjectJS = true;

    public String toString() {
        return "WebMonitorConfig{enableMonitor=" + this.enableMonitor + ", enableBlank=" + this.enableBlank + ", enableFetch=" + this.enableFetch + ", enableJSB=" + this.enableJSB + ", enableInjectJS=" + this.enableInjectJS + AbstractJsonLexerKt.END_OBJ;
    }
}
