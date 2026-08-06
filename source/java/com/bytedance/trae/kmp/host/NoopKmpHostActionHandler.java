package com.bytedance.trae.kmp.host;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpHostActions.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/kmp/host/NoopKmpHostActionHandler;", "Lcom/bytedance/trae/kmp/host/KmpHostActionHandler;", "<init>", "()V", "copyToClipboard", "", "text", "", "showToast", "message", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final class NoopKmpHostActionHandler implements KmpHostActionHandler {
    public static final NoopKmpHostActionHandler INSTANCE = new NoopKmpHostActionHandler();

    @Override // com.bytedance.trae.kmp.host.KmpHostActionHandler
    public void copyToClipboard(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostActionHandler
    public void showToast(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    private NoopKmpHostActionHandler() {
    }
}
