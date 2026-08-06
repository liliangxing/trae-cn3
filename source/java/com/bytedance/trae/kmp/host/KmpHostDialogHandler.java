package com.bytedance.trae.kmp.host;

import com.lynx.tasm.behavior.PropsConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: KmpHostDialogs.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JT\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH&JL\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH&J\b\u0010\u0012\u001a\u00020\u0003H&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;", "", "showTextInputDialog", "", "title", "", "initialValue", PropsConstants.PLACEHOLDER, "cancelText", "confirmText", "onConfirm", "Lkotlin/Function1;", "onDismiss", "Lkotlin/Function0;", "showConfirmDialog", "message", "destructive", "", "dismiss", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface KmpHostDialogHandler {
    void dismiss();

    void showConfirmDialog(String title, String message, String cancelText, String confirmText, boolean destructive, Function0<Unit> onConfirm, Function0<Unit> onDismiss);

    void showTextInputDialog(String title, String initialValue, String placeholder, String cancelText, String confirmText, Function1<? super String, Unit> onConfirm, Function0<Unit> onDismiss);
}
