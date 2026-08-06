package com.bytedance.trae.kmp.host;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.push.interfaze.IMessageCallbackService;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidKmpHostDialogHandler.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006JT\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\u0016JL\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J*\u0010\u001a\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0013H\u0002R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;", "Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;", "activityProvider", "Lkotlin/Function0;", "Landroid/app/Activity;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "activeDialog", "Ljava/lang/ref/WeakReference;", "Landroid/app/Dialog;", "showTextInputDialog", "", SchemaConstants.QUERY_KEY_TITLE, "", "initialValue", "placeholder", "cancelText", "confirmText", "onConfirm", "Lkotlin/Function1;", "onDismiss", "showConfirmDialog", "message", "destructive", "", "dismiss", IMessageCallbackService.EVENT_TYPE_SHOW, "factory", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidKmpHostDialogHandler implements KmpHostDialogHandler {
    public static final int $stable = 8;
    private WeakReference<Dialog> activeDialog;
    private final Function0<Activity> activityProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidKmpHostDialogHandler(Function0<? extends Activity> function0) {
        Intrinsics.checkNotNullParameter(function0, "activityProvider");
        this.activityProvider = function0;
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostDialogHandler
    public void showTextInputDialog(final String title, final String initialValue, final String placeholder, final String cancelText, final String confirmText, final Function1<? super String, Unit> onConfirm, Function0<Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(title, SchemaConstants.QUERY_KEY_TITLE);
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        Intrinsics.checkNotNullParameter(confirmText, "confirmText");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        show(onDismiss, new Function1() { // from class: com.bytedance.trae.kmp.host.AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Dialog showTextInputDialog$lambda$1;
                showTextInputDialog$lambda$1 = AndroidKmpHostDialogHandler.showTextInputDialog$lambda$1(title, initialValue, placeholder, cancelText, confirmText, onConfirm, (Activity) obj);
                return showTextInputDialog$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dialog showTextInputDialog$lambda$1(String str, String str2, String str3, String str4, String str5, final Function1 function1, Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "it");
        return CustomConfirmDialog.Companion.rename$default(CustomConfirmDialog.Companion, activity, str, str2, str3, str4, str5, new Function1() { // from class: com.bytedance.trae.kmp.host.AndroidKmpHostDialogHandler$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit showTextInputDialog$lambda$1$lambda$0;
                showTextInputDialog$lambda$1$lambda$0 = AndroidKmpHostDialogHandler.showTextInputDialog$lambda$1$lambda$0(function1, (String) obj);
                return showTextInputDialog$lambda$1$lambda$0;
            }
        }, (Function0) null, 128, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showTextInputDialog$lambda$1$lambda$0(Function1 function1, String str) {
        if (str == null) {
            str = "";
        }
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostDialogHandler
    public void showConfirmDialog(final String title, final String message, final String cancelText, final String confirmText, final boolean destructive, final Function0<Unit> onConfirm, Function0<Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(title, SchemaConstants.QUERY_KEY_TITLE);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        Intrinsics.checkNotNullParameter(confirmText, "confirmText");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        show(onDismiss, new Function1() { // from class: com.bytedance.trae.kmp.host.AndroidKmpHostDialogHandler$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Dialog showConfirmDialog$lambda$3;
                showConfirmDialog$lambda$3 = AndroidKmpHostDialogHandler.showConfirmDialog$lambda$3(destructive, title, message, cancelText, confirmText, onConfirm, (Activity) obj);
                return showConfirmDialog$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dialog showConfirmDialog$lambda$3(boolean z, String str, String str2, String str3, String str4, final Function0 function0, Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "it");
        if (z) {
            return CustomConfirmDialog.Companion.delete$default(CustomConfirmDialog.Companion, activity, str, str2, str3, str4, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 0, 0, function0, (Function0) null, 98272, (Object) null);
        }
        return new CustomConfirmDialog(activity, new CustomConfirmDialog.Config(str, str2, (String) null, (String) null, str3, str4, (Integer) null, 0.0f, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 0, 0, 0, (Integer) null, (Integer) null, (Integer) null, false, new Function1() { // from class: com.bytedance.trae.kmp.host.AndroidKmpHostDialogHandler$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit showConfirmDialog$lambda$3$lambda$2;
                showConfirmDialog$lambda$3$lambda$2 = AndroidKmpHostDialogHandler.showConfirmDialog$lambda$3$lambda$2(function0, (String) obj);
                return showConfirmDialog$lambda$3$lambda$2;
            }
        }, (Function0) null, 1572812, (DefaultConstructorMarker) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showConfirmDialog$lambda$3$lambda$2(Function0 function0, String str) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.kmp.host.KmpHostDialogHandler
    public void dismiss() {
        Dialog dialog;
        WeakReference<Dialog> weakReference = this.activeDialog;
        if (weakReference != null && (dialog = weakReference.get()) != null) {
            dialog.dismiss();
        }
        this.activeDialog = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        if ((r0.isFinishing() || r0.isDestroyed()) == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void show(final Function0<Unit> onDismiss, Function1<? super Activity, ? extends Dialog> factory) {
        Activity activity = (Activity) this.activityProvider.invoke();
        if (activity != null) {
        }
        activity = null;
        if (activity == null) {
            onDismiss.invoke();
            return;
        }
        dismiss();
        Dialog dialog = (Dialog) factory.invoke(activity);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.kmp.host.AndroidKmpHostDialogHandler$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AndroidKmpHostDialogHandler.show$lambda$6$lambda$5(AndroidKmpHostDialogHandler.this, onDismiss, dialogInterface);
            }
        });
        this.activeDialog = new WeakReference<>(dialog);
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$6$lambda$5(AndroidKmpHostDialogHandler androidKmpHostDialogHandler, Function0 function0, DialogInterface dialogInterface) {
        androidKmpHostDialogHandler.activeDialog = null;
        function0.invoke();
    }
}
