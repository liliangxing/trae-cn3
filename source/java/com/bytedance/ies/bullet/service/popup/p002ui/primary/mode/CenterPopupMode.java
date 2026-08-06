package com.bytedance.ies.bullet.service.popup.p002ui.primary.mode;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.R;
import com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupFragment;
import com.bytedance.ies.bullet.service.popup.p002ui.primary.PrimaryPopupMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CenterPopupMode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J'\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/primary/mode/CenterPopupMode;", "Lcom/bytedance/ies/bullet/service/popup/ui/primary/PrimaryPopupMode;", "fragment", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;", "(Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;)V", "getEnterAnim", "Landroid/animation/ObjectAnimator;", "getExitAnim", "getGravity", "", "getRadii", "", "getTitleBarBackImageRes", "onKeyBoardChange", "", "keyboardVisible", "", "keyboardHeight", "windowVisibleHeight", "(ZILjava/lang/Integer;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class CenterPopupMode extends PrimaryPopupMode {
    @Override // com.bytedance.ies.bullet.service.popup.p002ui.primary.PrimaryPopupMode
    public int getGravity() {
        return 17;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CenterPopupMode(AbsPopupFragment absPopupFragment) {
        super(absPopupFragment);
        Intrinsics.checkNotNullParameter(absPopupFragment, "fragment");
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public ObjectAnimator getEnterAnim() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getFragment().getPopupContainerView(), "alpha", 0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(fragment.popupCo…nerView, \"alpha\", 0f, 1f)");
        return ofFloat;
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public ObjectAnimator getExitAnim() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getFragment().getPopupContainerView(), "alpha", 1.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(fragment.popupCo…nerView, \"alpha\", 1f, 0f)");
        return ofFloat;
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public float[] getRadii() {
        return getFragment().isConfigInitialized() ? new float[]{getFragment().getConfig().getRadius(), getFragment().getConfig().getRadius(), getFragment().getConfig().getRadius(), getFragment().getConfig().getRadius(), getFragment().getConfig().getRadius(), getFragment().getConfig().getRadius(), getFragment().getConfig().getRadius(), getFragment().getConfig().getRadius()} : new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public int getTitleBarBackImageRes() {
        return R.drawable.ic_title_bar_close_normal;
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public void onKeyBoardChange(boolean keyboardVisible, int keyboardHeight, Integer windowVisibleHeight) {
        if (!getFragment().isContainerViewInitialized()) {
            super.onKeyBoardChange(keyboardVisible, keyboardHeight, windowVisibleHeight);
            return;
        }
        Dialog dialog = getFragment().getDialog();
        FrameLayout frameLayout = dialog != null ? (FrameLayout) dialog.findViewById(android.R.id.content) : null;
        if (!(frameLayout instanceof FrameLayout)) {
            frameLayout = null;
        }
        if (frameLayout != null) {
            ViewGroup.LayoutParams layoutParams = getFragment().getPopupContainerView().findViewById(R.id.bullet_popup_round).getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.gravity = keyboardVisible ? 81 : getGravity();
            }
            if (keyboardVisible) {
                keyboardHeight += frameLayout.getBottom() - getFragment().getPopupContainerView().getBottom();
            }
            super.onKeyBoardChange(keyboardVisible, keyboardHeight, windowVisibleHeight);
        }
    }
}
