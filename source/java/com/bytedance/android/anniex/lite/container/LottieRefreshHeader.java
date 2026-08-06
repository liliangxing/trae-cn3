package com.bytedance.android.anniex.lite.container;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.lottie.LottieAnimationView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: LottieRefreshHeader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J \u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J \u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J0\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J \u0010#\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J \u0010$\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J \u0010%\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0016J\u0014\u0010)\u001a\u00020\u000f2\n\u0010*\u001a\u00020+\"\u00020\u0011H\u0016J\f\u0010,\u001a\u00020\u0011*\u00020\u0017H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/android/anniex/lite/container/LottieRefreshHeader;", "Landroid/widget/FrameLayout;", "Lcom/scwang/smartrefresh/layout/api/RefreshHeader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lottieView", "Lcom/bytedance/lottie/LottieAnimationView;", "getSpinnerStyle", "Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;", "getView", "Landroid/view/View;", "isSupportHorizontalDrag", "", "onDetachedFromWindow", "", "onFinish", "", "refreshLayout", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "success", "onHorizontalDrag", "percentX", "", "offsetX", "offsetMax", "onInitialized", "kernel", "Lcom/scwang/smartrefresh/layout/api/RefreshKernel;", "height", "maxDragHeight", "onMoving", "isDragging", "percent", "offset", "onReleased", "onStartAnimator", "onStateChanged", "oldState", "Lcom/scwang/smartrefresh/layout/constant/RefreshState;", "newState", "setPrimaryColors", "colors", "", "dpToPx", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LottieRefreshHeader extends FrameLayout implements RefreshHeader {
    private static final float LOTTIE_SIZE_DP = 32.0f;
    private final LottieAnimationView lottieView;

    /* compiled from: LottieRefreshHeader.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RefreshState.values().length];
            try {
                iArr[RefreshState.PullDownToRefresh.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RefreshState.ReleaseToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
    }

    public void onInitialized(RefreshKernel kernel, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
    }

    public void onReleased(RefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
    }

    public void onStartAnimator(RefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
    }

    public void setPrimaryColors(int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieRefreshHeader(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx(LOTTIE_SIZE_DP), dpToPx(LOTTIE_SIZE_DP));
        layoutParams.gravity = 17;
        lottieAnimationView.setLayoutParams(layoutParams);
        lottieAnimationView.setAnimation("redblueballs-32x32-60fps-const.json");
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        lottieAnimationView.enableMergePathsForKitKatAndAbove(true);
        this.lottieView = lottieAnimationView;
        addView((View) lottieAnimationView);
    }

    private final int dpToPx(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public View getView() {
        return this;
    }

    public SpinnerStyle getSpinnerStyle() {
        SpinnerStyle spinnerStyle = SpinnerStyle.Translate;
        Intrinsics.checkNotNullExpressionValue(spinnerStyle, "Translate");
        return spinnerStyle;
    }

    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
        this.lottieView.setProgress(RangesKt.coerceIn(offset / maxDragHeight, 0.0f, 1.0f));
    }

    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        int i = WhenMappings.$EnumSwitchMapping$0[newState.ordinal()];
        if (i == 1) {
            this.lottieView.setSpeed(1.0f);
            return;
        }
        if (i == 2) {
            this.lottieView.setSpeed(2.0f);
        } else if (i == 3) {
            this.lottieView.playAnimation();
            this.lottieView.setSpeed(1.0f);
        } else {
            this.lottieView.cancelAnimation();
        }
    }

    public int onFinish(RefreshLayout refreshLayout, boolean success) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        this.lottieView.setProgress(0.0f);
        return 200;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lottieView.cancelAnimation();
    }
}
