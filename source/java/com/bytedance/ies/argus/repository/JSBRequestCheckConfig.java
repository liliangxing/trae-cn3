package com.bytedance.ies.argus.repository;

import com.bytedance.webx.core.webview.WebViewContainer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* compiled from: SecuritySettingConfigProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R4\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR4\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/argus/repository/JSBRequestCheckConfig;", "", "()V", "methods", "", "", "getMethods", "()Ljava/util/Map;", "setMethods", "(Ljava/util/Map;)V", "settings", WebViewContainer.EVENT_getSettings, "setSettings", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class JSBRequestCheckConfig {
    private Map<String, ? extends Map<String, ? extends Object>> methods = MapsKt.emptyMap();
    private Map<String, ? extends Map<String, ? extends Object>> settings = MapsKt.emptyMap();

    public final Map<String, Map<String, Object>> getMethods() {
        return this.methods;
    }

    public final void setMethods(Map<String, ? extends Map<String, ? extends Object>> map) {
        this.methods = map;
    }

    public final Map<String, Map<String, Object>> getSettings() {
        return this.settings;
    }

    public final void setSettings(Map<String, ? extends Map<String, ? extends Object>> map) {
        this.settings = map;
    }
}
