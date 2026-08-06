package com.bytedance.trae.kmp.host;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpHostDialogs.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005JR\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012JL\u0010\u0013\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012J\u0006\u0010\u0017\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/kmp/host/KmpHostDialogs;", "", "<init>", "()V", "handler", "Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;", "configure", "", "showTextInputDialog", SchemaConstants.QUERY_KEY_TITLE, "", "initialValue", "placeholder", "cancelText", "confirmText", "onConfirm", "Lkotlin/Function1;", "onDismiss", "Lkotlin/Function0;", "showConfirmDialog", "message", "destructive", "", "dismiss", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpHostDialogs {
    public static final KmpHostDialogs INSTANCE = new KmpHostDialogs();
    private static KmpHostDialogHandler handler = NoopKmpHostDialogHandler.INSTANCE;
    public static final int $stable = 8;

    private KmpHostDialogs() {
    }

    public final void configure(KmpHostDialogHandler handler2) {
        Intrinsics.checkNotNullParameter(handler2, "handler");
        handler = handler2;
    }

    public final void showTextInputDialog(String title, String initialValue, String placeholder, String cancelText, String confirmText, Function1<? super String, Unit> onConfirm, Function0<Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(title, SchemaConstants.QUERY_KEY_TITLE);
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        Intrinsics.checkNotNullParameter(confirmText, "confirmText");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        handler.showTextInputDialog(title, initialValue, placeholder, cancelText, confirmText, onConfirm, onDismiss);
    }

    public final void showConfirmDialog(String title, String message, String cancelText, String confirmText, boolean destructive, Function0<Unit> onConfirm, Function0<Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(title, SchemaConstants.QUERY_KEY_TITLE);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        Intrinsics.checkNotNullParameter(confirmText, "confirmText");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        handler.showConfirmDialog(title, message, cancelText, confirmText, destructive, onConfirm, onDismiss);
    }

    public final void dismiss() {
        handler.dismiss();
    }
}
