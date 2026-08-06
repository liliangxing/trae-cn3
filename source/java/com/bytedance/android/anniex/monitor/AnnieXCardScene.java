package com.bytedance.android.anniex.monitor;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Metadata;

/* compiled from: AnniexMonitorContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/monitor/AnnieXCardScene;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NEW", "RELOAD", "REUSE", "RESET_DATA", "UPDATE_DATA", "SSR", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public enum AnnieXCardScene {
    NEW("new"),
    RELOAD(WebViewContainer.EVENT_reload),
    REUSE(SchemaConstants.QUERY_KEY_REUSE),
    RESET_DATA("resetData"),
    UPDATE_DATA("updateData"),
    SSR("ssr");

    private final String value;

    AnnieXCardScene(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
