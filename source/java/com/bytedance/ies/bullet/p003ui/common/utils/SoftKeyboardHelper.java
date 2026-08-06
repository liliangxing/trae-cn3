package com.bytedance.ies.bullet.p003ui.common.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.container.util.ResUtil;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SoftKeyboardHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/utils/SoftKeyboardHelper;", "", "()V", "DEFAULT_SOFT_KEYBOARD_HEIGHT_DP", "", "lastMargin", "lastVisibleFrameBottom", "listener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "fixSoftKeyboardIssueForContainer", "", "container", "Landroid/view/View;", "hostActivity", "Landroid/app/Activity;", "mode", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "reset", "showSoftKeyBoard", "view", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SoftKeyboardHelper {
    public static final int MODE_ADJUST = 1;
    public static final int MODE_DEFAULT = 0;
    public static final String TAG = "SoftKeyboardHelper";
    private final int DEFAULT_SOFT_KEYBOARD_HEIGHT_DP = 100;
    private int lastMargin;
    private int lastVisibleFrameBottom;
    private ViewTreeObserver.OnGlobalLayoutListener listener;

    public final void fixSoftKeyboardIssueForContainer(final View container, Activity hostActivity, final int mode) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(hostActivity, "hostActivity");
        final View decorView = hostActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "hostActivity.window.decorView");
        final Rect rect = new Rect();
        if (this.listener != null) {
            decorView.getViewTreeObserver().removeOnGlobalLayoutListener(this.listener);
        }
        this.listener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.ies.bullet.ui.common.utils.SoftKeyboardHelper$fixSoftKeyboardIssueForContainer$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                int i6;
                int i7;
                decorView.getWindowVisibleDisplayFrame(rect);
                i = this.lastVisibleFrameBottom;
                if (i == 0) {
                    this.lastVisibleFrameBottom = rect.bottom;
                }
                if (mode == 1) {
                    i2 = this.lastVisibleFrameBottom;
                    int abs = Math.abs(i2 - rect.bottom);
                    ResUtil resUtil = ResUtil.INSTANCE;
                    i3 = this.DEFAULT_SOFT_KEYBOARD_HEIGHT_DP;
                    int dp2Px = resUtil.dp2Px(i3);
                    int i8 = 0;
                    if (abs > dp2Px) {
                        i7 = this.lastVisibleFrameBottom;
                        i8 = RangesKt.coerceAtLeast(i7 - rect.bottom, 0);
                    }
                    i4 = this.lastMargin;
                    if (i4 != i8) {
                        HybridLogger hybridLogger = HybridLogger.INSTANCE;
                        StringBuilder append = new StringBuilder("visibleFrameRect.bottom: ").append(rect.bottom).append(" lastVisibleFrameBottom: ");
                        i5 = this.lastVisibleFrameBottom;
                        StringBuilder append2 = append.append(i5).append("; margin: ").append(i8).append("; lastMargin: ");
                        i6 = this.lastMargin;
                        HybridLogger.i$default(hybridLogger, SoftKeyboardHelper.TAG, append2.append(i6).toString(), null, null, 12, null);
                        this.lastMargin = i8;
                        ViewGroup.LayoutParams layoutParams = container.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.bottomMargin = i8;
                        container.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        };
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(this.listener);
    }

    public final void onConfigurationChanged(Configuration newConfig) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (this.lastVisibleFrameBottom != 0) {
            if ((AnnieXRuntime.INSTANCE.getDeviceDepend().isPad() || AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) && IConditionCallKt.enablePadUpdateFrameBottomFix()) {
                Application application = BulletEnv.INSTANCE.getInstance().getApplication();
                if (application == null || (applicationContext = application.getApplicationContext()) == null) {
                    return;
                }
                this.lastVisibleFrameBottom = UIUtils.dpToPx$anniex_release(newConfig.screenHeightDp, applicationContext);
                return;
            }
            this.lastVisibleFrameBottom = ResUtil.INSTANCE.getScreenHeight();
        }
    }

    public final void reset(Activity hostActivity) {
        Intrinsics.checkNotNullParameter(hostActivity, "hostActivity");
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.listener;
        if (onGlobalLayoutListener != null) {
            hostActivity.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public final void showSoftKeyBoard(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.requestFocus();
        Object systemService = view.getContext().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(0, 2);
        }
    }
}
