package com.bytedance.trae.conversation.brainstorm.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ies.bullet.base.constants.GlobalPropertiesConstants;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.tasm.base.trace.TraceEventDef;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormActionShadowView.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ.\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "rect", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", GlobalPropertiesConstants.CONTENT_WIDTH, GlobalPropertiesConstants.CONTENT_HEIGHT, "shadowRadius", "", "contentInsetTop", "configure", "", "shadowColor", "backgroundColor", "shadowDy", "setContentSize", "width", "height", WebViewContainer.EVENT_onMeasure, TraceEventDef.WIDTH_MEASURE_SPEC, TraceEventDef.HEIGHT_MEASURE_SPEC, WebViewContainer.EVENT_onDraw, "canvas", "Landroid/graphics/Canvas;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BrainstormActionShadowView extends View {
    private int contentHeight;
    private float contentInsetTop;
    private int contentWidth;
    private final Paint paint;
    private final RectF rect;
    private float shadowRadius;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrainstormActionShadowView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrainstormActionShadowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BrainstormActionShadowView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormActionShadowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rect = new RectF();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.paint = paint;
        setClickable(false);
        setFocusable(false);
        setImportantForAccessibility(2);
        setLayerType(1, null);
    }

    public final void configure(int shadowColor, int backgroundColor, float shadowRadius, float shadowDy, float contentInsetTop) {
        this.shadowRadius = shadowRadius;
        this.contentInsetTop = contentInsetTop;
        this.paint.setColor(backgroundColor);
        this.paint.setShadowLayer(shadowRadius, 0.0f, shadowDy, shadowColor);
    }

    public final void setContentSize(int width, int height) {
        if (this.contentWidth == width && this.contentHeight == height) {
            return;
        }
        this.contentWidth = width;
        this.contentHeight = height;
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int i2 = this.contentWidth;
        if (i2 <= 0 || (i = this.contentHeight) <= 0) {
            return;
        }
        RectF rectF = this.rect;
        float f = this.shadowRadius;
        float f2 = this.contentInsetTop;
        rectF.set(f, f2, i2 + f, i + f2);
        float f3 = this.contentHeight / 2.0f;
        canvas.drawRoundRect(this.rect, f3, f3, this.paint);
    }
}
