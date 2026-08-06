package com.bytedance.trae.kmp.host;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpHostActions.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/kmp/host/KmpHostActions;", "", "<init>", "()V", "handler", "Lcom/bytedance/trae/kmp/host/KmpHostActionHandler;", "configure", "", "copyToClipboard", "text", "", "showToast", "message", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KmpHostActions {
    public static final KmpHostActions INSTANCE = new KmpHostActions();
    private static KmpHostActionHandler handler = NoopKmpHostActionHandler.INSTANCE;
    public static final int $stable = 8;

    private KmpHostActions() {
    }

    public final void configure(KmpHostActionHandler handler2) {
        Intrinsics.checkNotNullParameter(handler2, "handler");
        handler = handler2;
    }

    public final void copyToClipboard(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        handler.copyToClipboard(text);
    }

    public final void showToast(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        handler.showToast(message);
    }
}
