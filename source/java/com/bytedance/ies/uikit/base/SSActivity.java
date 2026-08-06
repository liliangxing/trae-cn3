package com.bytedance.ies.uikit.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.common.utility.ICustomToast;
import com.bytedance.ies.uikit.toast.CustomToast;
import com.bytedance.ies.uikit.toast.CustomToastHandler;
import com.bytedance.ies.uikit.toast.ICustomViewToast;
import com.bytedance.ies.uikit.toast.IDurationToast;
import com.bytedance.ies.uikit.toast.IToastType;
import com.bytedance.ies.uikit.toast.IViewInflatedListener;
import com.bytedance.ies.uikit.toast.ToastAnimation;
import com.bytedance.platform.thread.Constants;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.ugc.uikit.C1158R;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SSActivity extends AbsActivity implements IDurationToast, ICustomToast, IToastType, ICustomViewToast {
    private static WindowFocusChangeListener mWindowFocusLisenter;
    protected int mActivityAnimType = 0;
    private boolean mHideCustomToastStatusBar;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface WindowFocusChangeListener {
        void onWindowFocusChanged(Activity activity, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onStop() {
        m60x40346206(this);
    }

    public void overridePendingTransition(int i, int i2) {
    }

    @Override // com.bytedance.ies.uikit.toast.IToastType
    public int showToastType() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHideCustomToastStatusBar = false;
        ActivityTransUtils.startActivityAnim(this, this.mActivityAnimType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_bytedance_ies_uikit_base_SSActivity__onStop$___twin___() {
        super.onStop();
        CustomToastHandler.getInstance().onStop(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onPause() {
        CustomToastHandler.getInstance().onPause(this);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onResume() {
        super.onResume();
        CustomToastHandler.getInstance().onResume(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        CustomToastHandler.getInstance().onResume(this);
        super.onActivityResult(i, i2, intent);
    }

    public void superOverridePendingTransition(int i, int i2) {
        super.overridePendingTransition(i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super.finish();
        ActivityTransUtils.finishActivityAnim(this, this.mActivityAnimType);
    }

    public void showCustomToast(String str) {
        if (isViewValid()) {
            ensureCustomToast().showToast(str);
        }
    }

    @Override // com.bytedance.ies.uikit.toast.IDurationToast
    public void showCustomToast(String str, long j) {
        if (isViewValid()) {
            ensureCustomToast().setDuration(j).showToast(str);
        }
    }

    public void showCustomLongToast(int i, String str) {
        if (isViewValid()) {
            ensureCustomToast().showToast(str, i);
        }
    }

    public void showCustomToast(String str, int i, int i2) {
        if (isViewValid()) {
            ensureCustomToast().setGravity(i2).setDuration(i).showToast(str);
        }
    }

    public void showCustomToast(int i, String str) {
        if (isViewValid()) {
            ensureCustomToast().showToast(str, i);
        }
    }

    public void showCustomToast(int i, String str, int i2, int i3) {
        if (isViewValid()) {
            ensureCustomToast().setDuration(i2).setGravity(i3).showToast(str, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.toast.ICustomViewToast
    public void showCustomViewToast(int i, IViewInflatedListener iViewInflatedListener) {
        if (isViewValid()) {
            new CustomToast(this).setGravity(48).setLightMode(true).setSwipeToDismiss(true).setDuration(Constants.TASK_RUN_THRESHOLD).setScalable(true).showToast(i, iViewInflatedListener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.toast.ICustomViewToast
    public void showCustomViewToast(int i, IViewInflatedListener iViewInflatedListener, int i2) {
        if (isViewValid()) {
            if (i2 <= 0) {
                i2 = 5000;
            }
            new CustomToast(this).setGravity(48).setLightMode(true).setSwipeToDismiss(true).setDuration(i2).setScalable(true).showToast(i, iViewInflatedListener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CustomToast ensureCustomToast() {
        if (showToastType() == 0) {
            CustomToast customToast = new CustomToast(this);
            customToast.setGravity(48).setScalable(false).setLightMode(false).setSwipeToDismiss(true);
            return customToast;
        }
        if (showToastType() == 2) {
            CustomToast customToast2 = new CustomToast(this);
            customToast2.setGravity(48).setScalable(false).setLightMode(true).setSwipeToDismiss(true);
            return customToast2;
        }
        CustomToast customToast3 = new CustomToast((Context) this, C1158R.layout.custom_system_toast_new);
        customToast3.setGravity(17).setScalable(false).setSwipeToDismiss(false).setShowAndHideAnimatorSet(ToastAnimation.showAlpha(customToast3.getContentView()), ToastAnimation.hideAlpha(customToast3.getContentView()));
        return customToast3;
    }

    @Override // com.bytedance.ies.uikit.toast.ICustomViewToast
    public void dismissCustomToast() {
        CustomToastHandler.getInstance().dismiss();
    }

    protected void setToastQueueLength(int i) {
        CustomToastHandler.getInstance().setQueueLength(i);
    }

    public void hideCustomToastStatusBar() {
        this.mHideCustomToastStatusBar = true;
    }

    public void showCustomToastStatusBar() {
        this.mHideCustomToastStatusBar = false;
    }

    @Override // com.bytedance.ies.uikit.toast.IToastType
    public int titleToastMargin() {
        return getResources().getDimensionPixelSize(C1158R.dimen.title_bar_height);
    }

    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        WindowFocusChangeListener windowFocusChangeListener = mWindowFocusLisenter;
        if (windowFocusChangeListener != null) {
            windowFocusChangeListener.onWindowFocusChanged(this, z);
        }
    }

    public static void setWindowFocusLisenter(WindowFocusChangeListener windowFocusChangeListener) {
        mWindowFocusLisenter = windowFocusChangeListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_ies_uikit_base_SSActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m60x40346206(SSActivity sSActivity) {
        sSActivity.com_bytedance_ies_uikit_base_SSActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) sSActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
