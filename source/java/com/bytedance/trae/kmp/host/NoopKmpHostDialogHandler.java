package com.bytedance.trae.kmp.host;

import com.lynx.tasm.behavior.PropsConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpHostDialogs.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0016JL\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/kmp/host/NoopKmpHostDialogHandler;", "Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;", "<init>", "()V", "showTextInputDialog", "", "title", "", "initialValue", PropsConstants.PLACEHOLDER, "cancelText", "confirmText", "onConfirm", "Lkotlin/Function1;", "onDismiss", "Lkotlin/Function0;", "showConfirmDialog", "message", "destructive", "", "dismiss", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final class NoopKmpHostDialogHandler implements KmpHostDialogHandler {
    public static final NoopKmpHostDialogHandler INSTANCE = new NoopKmpHostDialogHandler();

    @Override // com.bytedance.trae.kmp.host.KmpHostDialogHandler
    public void dismiss() {
    }

    private NoopKmpHostDialogHandler() {
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostDialogHandler
    public void showTextInputDialog(String title, String initialValue, String placeholder, String cancelText, String confirmText, Function1<? super String, Unit> onConfirm, Function0<Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        Intrinsics.checkNotNullParameter(confirmText, "confirmText");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        onDismiss.invoke();
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostDialogHandler
    public void showConfirmDialog(String title, String message, String cancelText, String confirmText, boolean destructive, Function0<Unit> onConfirm, Function0<Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        Intrinsics.checkNotNullParameter(confirmText, "confirmText");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        onDismiss.invoke();
    }
}
