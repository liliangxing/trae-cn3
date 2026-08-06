package com.bytedance.trae.conversation.widget.blur;

import android.content.Context;
import android.util.AttributeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: BlurCircleWithAmplitude.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0011J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\fJ\b\u0010\u001d\u001a\u00020\u0013H\u0014J\b\u0010\u001e\u001a\u00020\fH\u0002J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;", "Lcom/bytedance/trae/conversation/widget/blur/BlurView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "amplitudeList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "amplitudeCapacity", "animHelper", "Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;", "pendingStartAnim", "", "onSizeChanged", "", "w", "h", "oldw", "oldh", "startWaveAnim", "stopWaveAnim", "isAnimating", "updateVolumeData", "volume", "onDetachedFromWindow", "getMaxAmplitude", "optAmplitude", "before", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BlurCircleWithAmplitude extends BlurView {
    private final int amplitudeCapacity;
    private final CopyOnWriteArrayList<Float> amplitudeList;
    private final BlurCircleAnimHelper animHelper;
    private boolean pendingStartAnim;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlurCircleWithAmplitude(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlurCircleWithAmplitude(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BlurCircleWithAmplitude(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlurCircleWithAmplitude(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.amplitudeList = new CopyOnWriteArrayList<>();
        this.amplitudeCapacity = 10;
        this.animHelper = new BlurCircleAnimHelper(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.conversation.widget.blur.BlurView, android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        boolean isAnimating = isAnimating();
        if (isAnimating) {
            stopWaveAnim();
        }
        super.onSizeChanged(w, h, oldw, oldh);
        if (isAnimating || this.pendingStartAnim) {
            this.pendingStartAnim = false;
            this.animHelper.startAnim(new BlurCircleWithAmplitude$onSizeChanged$1(this));
        }
    }

    public final void startWaveAnim() {
        if (isAnimating() || this.pendingStartAnim) {
            return;
        }
        if (getWidth() == 0 || getHeight() == 0) {
            this.pendingStartAnim = true;
        } else {
            this.animHelper.startAnim(new BlurCircleWithAmplitude$startWaveAnim$1(this));
        }
    }

    public final void stopWaveAnim() {
        this.pendingStartAnim = false;
        this.animHelper.stopAnim();
    }

    public final boolean isAnimating() {
        return this.animHelper.isAnimating() || this.pendingStartAnim;
    }

    public final void updateVolumeData(float volume) {
        if (isAnimating()) {
            float optAmplitude = optAmplitude(volume);
            if (this.amplitudeList.size() >= this.amplitudeCapacity) {
                this.amplitudeList.remove(0);
            }
            this.amplitudeList.add(Float.valueOf(optAmplitude));
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopWaveAnim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getMaxAmplitude() {
        Float maxOrNull = CollectionsKt.maxOrNull(this.amplitudeList);
        if (maxOrNull != null) {
            return maxOrNull.floatValue();
        }
        return 0.0f;
    }

    private final float optAmplitude(double before) {
        return RangesKt.coerceAtMost(((float) (before > 0.5d ? 1.0d : Math.sin(before * 3.141592653589793d))) * 2.5f, 1.0f);
    }
}
