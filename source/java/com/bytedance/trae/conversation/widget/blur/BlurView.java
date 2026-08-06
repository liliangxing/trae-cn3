package com.bytedance.trae.conversation.widget.blur;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.ReducerConstants;
import com.bytedance.trae.common_ui.C0591R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: BlurView.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 32\u00020\u0001:\u00013B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0013H\u0007J\b\u0010!\u001a\u00020\u0013H\u0007J\u0012\u0010\"\u001a\u00020\u001e2\n\u0010#\u001a\u00020\u0016\"\u00020\u0007J\u0012\u0010$\u001a\u00020\u001e2\n\u0010#\u001a\u00020\u0016\"\u00020\u0007J\u0016\u0010\u0010\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0013J\u0006\u0010'\u001a\u00020\u001eJ(\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/H\u0014J\u0010\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u000202H\u0014R\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/trae/conversation/widget/blur/BlurView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "circleRectHeight", "getCircleRectHeight", "()I", "blurCircleDrawable", "Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;", "showHighlight", "", "highlightRadius", "", "blurCircleHighlight", "shadowColors", "", "coverColor", "radiusWidthRatio", "blurRadius", "initialCircleScale", "isHarmony", "useRenderEffect", "applyRenderEffectBlur", "", "setCircleScale", "scale", "getCircleScale", "setCircleColor", "colors", "setCircleColorWithoutCover", "centerX", "centerY", "dismissHighlight", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "verifyDrawable", "who", "Landroid/graphics/drawable/Drawable;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BlurView extends View {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BlurCircleDrawable blurCircleDrawable;
    private BlurCircleDrawable blurCircleHighlight;
    private float blurRadius;
    private int circleRectHeight;
    private int coverColor;
    private final float highlightRadius;
    private float initialCircleScale;
    private final boolean isHarmony;
    private float radiusWidthRatio;
    private int[] shadowColors;
    private boolean showHighlight;
    private final boolean useRenderEffect;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlurView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlurView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BlurView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlurView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        int color = ContextCompat.getColor(context, C0591R.color.trae_brand_brand_300);
        Companion companion = INSTANCE;
        this.shadowColors = new int[]{ContextCompat.getColor(context, C0591R.color.trae_bg_bg_brand), companion.colorWithAlpha(color, 0.6f), companion.colorWithAlpha(color, 0.0f)};
        this.coverColor = 654311423;
        this.radiusWidthRatio = 0.8f;
        this.blurRadius = getResources().getDisplayMetrics().density * 48.0f;
        this.initialCircleScale = 1.0f;
        this.useRenderEffect = Build.VERSION.SDK_INT >= 31;
        this.circleRectHeight = (int) (280 * getResources().getDisplayMetrics().density);
        this.highlightRadius = this.blurRadius;
        int[] iArr = this.shadowColors;
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(INSTANCE.calcMixedColor(i2, this.coverColor)));
        }
        BlurCircleDrawable blurCircleDrawable = new BlurCircleDrawable(CollectionsKt.toIntArray(arrayList), this.blurRadius, this.radiusWidthRatio, this.circleRectHeight, null, 0.0f, 0.0f, 0.0f, !this.useRenderEffect, this.isHarmony, 240, null);
        this.blurCircleDrawable = blurCircleDrawable;
        blurCircleDrawable.setCircleScale(this.initialCircleScale);
        blurCircleDrawable.setCallback(this);
        float f = this.highlightRadius;
        if (f > 0.0f) {
            int i3 = (int) (f * 2);
            BlurCircleDrawable blurCircleDrawable2 = new BlurCircleDrawable(new int[]{ContextCompat.getColor(context, C0591R.color.trae_bg_bg_brand)}, this.highlightRadius, 0.5f, i3, new PorterDuffXfermode(PorterDuff.Mode.SRC_IN), 0.0f, 0.0f, 0.0f, !this.useRenderEffect, this.isHarmony, 224, null);
            this.blurCircleHighlight = blurCircleDrawable2;
            blurCircleDrawable2.setBounds(0, 0, i3, i3);
        }
        if (this.useRenderEffect) {
            applyRenderEffectBlur();
        } else {
            setLayerType(1, null);
        }
    }

    public final int getCircleRectHeight() {
        return this.circleRectHeight;
    }

    private final void applyRenderEffectBlur() {
        if (Build.VERSION.SDK_INT >= 31) {
            float f = this.blurRadius;
            setRenderEffect(RenderEffect.createBlurEffect(f, f, Shader.TileMode.DECAL));
        }
    }

    public final void setCircleScale(float scale) {
        this.blurCircleDrawable.setCircleScale(scale);
        if (this.useRenderEffect) {
            float f = this.blurRadius * scale;
            if (Build.VERSION.SDK_INT < 31 || f <= 0.0f) {
                return;
            }
            setRenderEffect(RenderEffect.createBlurEffect(f, f, Shader.TileMode.DECAL));
        }
    }

    public final float getCircleScale() {
        return this.blurCircleDrawable.getCircleScale();
    }

    public final void setCircleColorWithoutCover(int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        if (!(colors.length == 0)) {
            this.blurCircleDrawable.setCircleColor(colors);
        }
    }

    public final void showHighlight(float centerX, float centerY) {
        BlurCircleDrawable blurCircleDrawable = this.blurCircleHighlight;
        if (blurCircleDrawable == null) {
            return;
        }
        this.showHighlight = true;
        if (blurCircleDrawable != null) {
            float f = this.highlightRadius;
            blurCircleDrawable.setBounds((int) (centerX - f), (int) (centerY - f), (int) (centerX + f), (int) (centerY + f));
        }
        BlurCircleDrawable blurCircleDrawable2 = this.blurCircleHighlight;
        if (blurCircleDrawable2 != null) {
            blurCircleDrawable2.invalidateSelf();
        }
    }

    public final void dismissHighlight() {
        if (this.blurCircleHighlight == null) {
            return;
        }
        this.showHighlight = false;
        invalidate();
        BlurCircleDrawable blurCircleDrawable = this.blurCircleHighlight;
        if (blurCircleDrawable != null) {
            blurCircleDrawable.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.blurCircleDrawable.setBounds(0, 0, w, h);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (!this.showHighlight || this.blurCircleHighlight == null) {
            this.blurCircleDrawable.draw(canvas);
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        this.blurCircleDrawable.draw(canvas);
        BlurCircleDrawable blurCircleDrawable = this.blurCircleHighlight;
        if (blurCircleDrawable != null) {
            blurCircleDrawable.draw(canvas);
        }
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        return super.verifyDrawable(who) || who == this.blurCircleDrawable || who == this.blurCircleHighlight;
    }

    /* compiled from: BlurView.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00020\u0007\"\u00020\u0005H\u0002J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;", "", "<init>", "()V", "calcMixedColor", "", "color", "", "colorWithAlpha", "alpha", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int calcMixedColor(int... color) {
            if (color.length == 0) {
                return 0;
            }
            if (color.length == 1) {
                return color[0];
            }
            int i = 0;
            for (int i2 : color) {
                if (i2 != 0) {
                    i = i == 0 ? i2 : ColorUtils.blendARGB(i, Color.rgb(Color.red(i2), Color.green(i2), Color.blue(i2)), Color.alpha(i2) / 255.0f);
                }
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int colorWithAlpha(int color, float alpha) {
            return ColorUtils.setAlphaComponent(color, MathKt.roundToInt(RangesKt.coerceIn(alpha, 0.0f, 1.0f) * ReducerConstants.REQUEST_CODE));
        }
    }

    public final void setCircleColor(int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        ArrayList arrayList = new ArrayList(colors.length);
        for (int i : colors) {
            arrayList.add(Integer.valueOf(INSTANCE.calcMixedColor(i, this.coverColor)));
        }
        int[] intArray = CollectionsKt.toIntArray(arrayList);
        if (!(intArray.length == 0)) {
            this.blurCircleDrawable.setCircleColor(intArray);
        }
    }
}
