package com.bytedance.ies.bullet.service.popup.p002ui.primary;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.R;
import com.bytedance.android.anniex.container.view.RadiusFrameLayout;
import com.bytedance.ies.bullet.core.device.BulletDeviceUtils;
import com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupFragment;
import com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrimaryPopupMode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH&J\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\bH\u0016J\u0006\u0010\u000e\u001a\u00020\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/primary/PrimaryPopupMode;", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupMode;", "fragment", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;", "(Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;)V", "adapterStatusBar", "", "constructUIBody", "", "dismissForever", "getGravity", "", "getStatusBarHeight", "hideAndWaitResume", "isStatusBarVisible", "onCreateDialog", "Lcom/bytedance/ies/bullet/service/popup/ui/primary/PrimaryDialog;", "resumeWhenBack", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class PrimaryPopupMode extends AbsPopupMode {
    public abstract int getGravity();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimaryPopupMode(AbsPopupFragment absPopupFragment) {
        super(absPopupFragment);
        Intrinsics.checkNotNullParameter(absPopupFragment, "fragment");
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public PrimaryDialog onCreateDialog() {
        Context requireContext = getFragment().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
        return new PrimaryDialog(requireContext);
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public void constructUIBody() {
        RadiusFrameLayout findViewById;
        if (getFragment().isContainerViewInitialized() && (findViewById = getFragment().getPopupContainerView().findViewById(R.id.bullet_popup_round)) != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.width = getFragment().getConfig().getWidth();
            layoutParams.height = getFragment().getConfig().getHeight();
            findViewById.setRadius(getRadii());
            if (adapterStatusBar()) {
                findViewById.setPadding(0, getStatusBarHeight(), 0, 0);
            }
            ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
            FrameLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams2 : null;
            if (layoutParams3 != null) {
                layoutParams3.gravity = getGravity();
            }
            if (getFragment().getConfig().getUniformStyleAdapter()) {
                findViewById.requestLayout();
            }
        }
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public void dismissForever() {
        Dialog dialog = getFragment().getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public void hideAndWaitResume() {
        Dialog dialog = getFragment().getDialog();
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public void resumeWhenBack() {
        Dialog dialog = getFragment().getDialog();
        if (dialog != null) {
            dialog.show();
        }
    }

    public final boolean adapterStatusBar() {
        return isStatusBarVisible() && !getFragment().getConfig().getHideStatusBar() && getFragment().getConfig().getHeightPercent() == 100;
    }

    public final int getStatusBarHeight() {
        try {
            Result.Companion companion = Result.Companion;
            return BulletDeviceUtils.INSTANCE.getStatusBarHeight(getFragment().getAct());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            return 0;
        }
    }

    public final boolean isStatusBarVisible() {
        View decorView = getFragment().getAct().getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "fragment.act.window.decorView");
        return (decorView.getSystemUiVisibility() & 4) == 0;
    }
}
