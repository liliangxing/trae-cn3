package com.bytedance.ies.bullet.service.popup.p002ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.anniex.R;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.push.interfaze.IMessageCallbackService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbsPopupDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\bJ\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0005H\u0016J\u001a\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u000bH\u0016J\u0006\u0010+\u001a\u00020\u000bJ\u0006\u0010,\u001a\u00020\u000bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "theme", "", "(Landroid/content/Context;I)V", "_enableImmersive", "", "callbackDismiss", "Lkotlin/Function0;", "", "getCallbackDismiss", "()Lkotlin/jvm/functions/Function0;", "setCallbackDismiss", "(Lkotlin/jvm/functions/Function0;)V", "callbackIfMaskCancel", "getCallbackIfMaskCancel", "setCallbackIfMaskCancel", "callbackOnBackPressed", "getCallbackOnBackPressed", "setCallbackOnBackPressed", "clickThroughMask", "getClickThroughMask", "()Z", "setClickThroughMask", "(Z)V", "isDismissed", "dismiss", "enableImmersive", "initImmersive", "onBackPressed", "setContentView", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "layoutResID", "setStatusBarColor", "window", "Landroid/view/Window;", "targetColor", IMessageCallbackService.EVENT_TYPE_SHOW, "superDismiss", "superOnBackPressed", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsPopupDialog extends AppCompatDialog {
    private boolean _enableImmersive;
    private Function0<Unit> callbackDismiss;
    private Function0<Boolean> callbackIfMaskCancel;
    private Function0<Unit> callbackOnBackPressed;
    private boolean clickThroughMask;
    private volatile boolean isDismissed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPopupDialog(Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this._enableImmersive = true;
    }

    public /* synthetic */ AbsPopupDialog(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? R.style.Dialog_Immersive_NoAnim : i);
    }

    public void setContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        supportRequestWindowFeature(1);
        super.setContentView(view);
        view.setFitsSystemWindows(false);
        initImmersive();
    }

    public void setContentView(int layoutResID) {
        supportRequestWindowFeature(1);
        super.setContentView(layoutResID);
        initImmersive();
    }

    public void setContentView(View view, ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(view, "view");
        supportRequestWindowFeature(1);
        super.setContentView(view, params);
        initImmersive();
    }

    private final void initImmersive() {
        Window window;
        View decorView;
        Window window2 = getWindow();
        if (window2 != null) {
            window2.clearFlags(1024);
            window2.setSoftInputMode(16);
            setStatusBarColor(window2, 0);
            View decorView2 = window2.getDecorView();
            decorView2.setPadding(0, 0, 0, 0);
            Activity ownerActivity = getOwnerActivity();
            if (ownerActivity != null && (window = ownerActivity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                decorView2.setSystemUiVisibility(decorView.getSystemUiVisibility());
            }
            Activity ownerActivity2 = getOwnerActivity();
            if (ownerActivity2 != null) {
                window2.setNavigationBarColor(ownerActivity2.getWindow().getNavigationBarColor());
            }
        }
    }

    private final void setStatusBarColor(Window window, int targetColor) {
        if (window != null) {
            window.clearFlags(2);
        }
        if (window != null) {
            window.clearFlags(67108864);
        }
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
        }
        if (window != null) {
            window.setStatusBarColor(targetColor);
        }
        View findViewById = window != null ? window.findViewById(android.R.id.content) : null;
        if (findViewById == null) {
            return;
        }
        findViewById.setForeground(null);
    }

    public void show() {
        Window window;
        View decorView;
        View decorView2;
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setFlags(8, 8);
        }
        try {
            super.show();
            Activity ownerActivity = getOwnerActivity();
            if (ownerActivity != null && (window = ownerActivity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (!this._enableImmersive) {
                    systemUiVisibility ^= 512;
                }
                Window window3 = getWindow();
                if (window3 != null && (decorView2 = window3.getDecorView()) != null) {
                    decorView2.setSystemUiVisibility(systemUiVisibility);
                }
            }
            Window window4 = getWindow();
            if (window4 != null) {
                window4.clearFlags(8);
            }
        } catch (Throwable th) {
            BulletLogger.INSTANCE.printLog("AbsPopupDialog show error: " + th, LogLevel.E, "XPopup");
        }
    }

    public final boolean getClickThroughMask() {
        return this.clickThroughMask;
    }

    public final void setClickThroughMask(boolean z) {
        this.clickThroughMask = z;
    }

    public final Function0<Boolean> getCallbackIfMaskCancel() {
        return this.callbackIfMaskCancel;
    }

    public final void setCallbackIfMaskCancel(Function0<Boolean> function0) {
        this.callbackIfMaskCancel = function0;
    }

    public final Function0<Unit> getCallbackOnBackPressed() {
        return this.callbackOnBackPressed;
    }

    public final void setCallbackOnBackPressed(Function0<Unit> function0) {
        this.callbackOnBackPressed = function0;
    }

    public void onBackPressed() {
        Function0<Unit> function0 = this.callbackOnBackPressed;
        if (function0 != null) {
            function0.invoke();
        } else {
            superOnBackPressed();
        }
    }

    public final void superOnBackPressed() {
        super.onBackPressed();
    }

    public final Function0<Unit> getCallbackDismiss() {
        return this.callbackDismiss;
    }

    public final void setCallbackDismiss(Function0<Unit> function0) {
        this.callbackDismiss = function0;
    }

    public void dismiss() {
        if (this.isDismissed) {
            return;
        }
        this.isDismissed = true;
        Function0<Unit> function0 = this.callbackDismiss;
        if (function0 != null) {
            function0.invoke();
        } else {
            superDismiss();
        }
    }

    public final void superDismiss() {
        super.dismiss();
    }

    public final void enableImmersive(boolean enableImmersive) {
        this._enableImmersive = enableImmersive;
    }
}
