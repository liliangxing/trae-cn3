package com.bytedance.ies.bullet.service.popup.p002ui;

import android.R;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbsPopupMode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\bH&J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0015H&J'\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\bH&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupMode;", "", "fragment", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;", "(Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;)V", "getFragment$anniex_release", "()Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;", "constructUIBody", "", "dismissForever", "getEnterAnim", "Landroid/animation/ObjectAnimator;", "getExitAnim", "getRadii", "", "getTitleBarBackImageRes", "", "hideAndWaitResume", "isMeetUniformStyleAdapterCondition", "", "onCreateDialog", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupDialog;", "onKeyBoardChange", "keyboardVisible", "keyboardHeight", "windowVisibleHeight", "(ZILjava/lang/Integer;)V", "resumeWhenBack", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsPopupMode {
    private final AbsPopupFragment fragment;

    public abstract void constructUIBody();

    public abstract void dismissForever();

    public abstract ObjectAnimator getEnterAnim();

    public abstract ObjectAnimator getExitAnim();

    public abstract float[] getRadii();

    public abstract int getTitleBarBackImageRes();

    public abstract void hideAndWaitResume();

    public abstract AbsPopupDialog onCreateDialog();

    public abstract void resumeWhenBack();

    public AbsPopupMode(AbsPopupFragment absPopupFragment) {
        Intrinsics.checkNotNullParameter(absPopupFragment, "fragment");
        this.fragment = absPopupFragment;
    }

    /* renamed from: getFragment$anniex_release, reason: from getter */
    public final AbsPopupFragment getFragment() {
        return this.fragment;
    }

    public void onKeyBoardChange(boolean keyboardVisible, int keyboardHeight, Integer windowVisibleHeight) {
        Dialog dialog = this.fragment.getDialog();
        FrameLayout frameLayout = dialog != null ? (FrameLayout) dialog.findViewById(R.id.content) : null;
        FrameLayout frameLayout2 = frameLayout instanceof FrameLayout ? frameLayout : null;
        if (frameLayout2 != null) {
            frameLayout2.setPadding(0, 0, 0, keyboardHeight);
            frameLayout2.requestLayout();
        }
    }

    public final boolean isMeetUniformStyleAdapterCondition() {
        Configuration configuration;
        if (!this.fragment.getConfig().getUniformStyleAdapter()) {
            return false;
        }
        Resources resources = this.fragment.getAct().getResources();
        return ((resources == null || (configuration = resources.getConfiguration()) == null) ? 0 : configuration.screenWidthDp) >= 480;
    }
}
