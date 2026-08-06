package com.bytedance.android.livesdk.pannel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.pannel.utils.UIUtils;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.tasm.base.trace.TraceEventDef;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RadiusLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0014J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\tR\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/view/RadiusLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxHeight", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "roundRadius", "", "rounds", "", WebViewContainer.EVENT_dispatchDraw, "", "canvas", "Landroid/graphics/Canvas;", WebViewContainer.EVENT_onMeasure, TraceEventDef.WIDTH_MEASURE_SPEC, TraceEventDef.HEIGHT_MEASURE_SPEC, "setRoundDp", "radius", "panel_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class RadiusLayout extends FrameLayout {
    private HashMap _$_findViewCache;
    private int maxHeight;
    private float roundRadius;
    private float[] rounds;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }

    public final void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadiusLayout(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        float dip2Px = UIUtils.dip2Px(getContext(), 8);
        this.roundRadius = dip2Px;
        this.rounds = new float[]{dip2Px, dip2Px, dip2Px, dip2Px, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadiusLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        float dip2Px = UIUtils.dip2Px(getContext(), 8);
        this.roundRadius = dip2Px;
        this.rounds = new float[]{dip2Px, dip2Px, dip2Px, dip2Px, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadiusLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        float dip2Px = UIUtils.dip2Px(getContext(), 8);
        this.roundRadius = dip2Px;
        this.rounds = new float[]{dip2Px, dip2Px, dip2Px, dip2Px, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public final void setRoundDp(int radius) {
        float dip2Px = UIUtils.dip2Px(getContext(), radius);
        this.rounds = new float[]{dip2Px, dip2Px, dip2Px, dip2Px, dip2Px, dip2Px, dip2Px, dip2Px};
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        int i = this.maxHeight;
        if (1 <= i && size > i) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
