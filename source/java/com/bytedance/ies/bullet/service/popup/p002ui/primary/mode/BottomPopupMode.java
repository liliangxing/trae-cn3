package com.bytedance.ies.bullet.service.popup.p002ui.primary.mode;

import android.animation.ObjectAnimator;
import com.bytedance.android.anniex.R;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupFragment;
import com.bytedance.ies.bullet.service.popup.p002ui.primary.PrimaryPopupMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomPopupMode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/primary/mode/BottomPopupMode;", "Lcom/bytedance/ies/bullet/service/popup/ui/primary/PrimaryPopupMode;", "fragment", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;", "(Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;)V", "getEnterAnim", "Landroid/animation/ObjectAnimator;", "getExitAnim", "getGravity", "", "getRadii", "", "getTitleBarBackImageRes", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BottomPopupMode extends PrimaryPopupMode {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomPopupMode(AbsPopupFragment absPopupFragment) {
        super(absPopupFragment);
        Intrinsics.checkNotNullParameter(absPopupFragment, "fragment");
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.primary.PrimaryPopupMode
    public int getGravity() {
        return isMeetUniformStyleAdapterCondition() ? 8388693 : 81;
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public ObjectAnimator getEnterAnim() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getFragment().getPopupContainerView(), "translationY", UIUtils.dpToPx$anniex_release(UIUtils.getDisplayMetrics$anniex_release(getFragment().getAct()).getHeight(), getFragment().getAct()), 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(fragment.popupCo…gment.act).toFloat(), 0f)");
        return ofFloat;
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public ObjectAnimator getExitAnim() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getFragment().getPopupContainerView(), "translationY", 0.0f, UIUtils.dpToPx$anniex_release(UIUtils.getDisplayMetrics$anniex_release(getFragment().getAct()).getHeight(), getFragment().getAct()));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(fragment.popupCo… fragment.act).toFloat())");
        return ofFloat;
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public float[] getRadii() {
        return getFragment().isConfigInitialized() ? new float[]{getFragment().getConfig().getRadius(), getFragment().getConfig().getRadius(), getFragment().getConfig().getRadius(), getFragment().getConfig().getRadius(), 0.0f, 0.0f, 0.0f, 0.0f} : new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public int getTitleBarBackImageRes() {
        return R.drawable.ic_title_bar_close_normal;
    }
}
