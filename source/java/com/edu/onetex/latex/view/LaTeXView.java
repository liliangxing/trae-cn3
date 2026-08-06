package com.edu.onetex.latex.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.edu.onetex.latex.LaTeXParam;
import com.edu.onetex.latex.TexSize;
import com.edu.onetex.latex.graphic.Graphics2D;
import com.edu.onetex.latex.icon.LaTeXIcon;
import com.lynx.tasm.base.trace.TraceEventDef;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LatexView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0014R\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/edu/onetex/latex/view/LaTeXView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgPaint", "Landroid/graphics/Paint;", "getBgPaint", "()Landroid/graphics/Paint;", "g2", "Lcom/edu/onetex/latex/graphic/Graphics2D;", "getG2", "()Lcom/edu/onetex/latex/graphic/Graphics2D;", "teXIcon", "Lcom/edu/onetex/latex/icon/LaTeXIcon;", "getTeXIcon", "()Lcom/edu/onetex/latex/icon/LaTeXIcon;", "setTeXIcon", "(Lcom/edu/onetex/latex/icon/LaTeXIcon;)V", "bindTexIcon", "", "enableOnDraw", "measureHeight", "measureWidth", WebViewContainer.EVENT_onDraw, "canvas", "Landroid/graphics/Canvas;", WebViewContainer.EVENT_onMeasure, TraceEventDef.WIDTH_MEASURE_SPEC, TraceEventDef.HEIGHT_MEASURE_SPEC, "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LaTeXView extends FrameLayout {
    private HashMap _$_findViewCache;
    private final Paint bgPaint;
    private final Graphics2D g2;
    private LaTeXIcon teXIcon;

    public LaTeXView(Context context) {
        this(context, null, 0, 6, null);
    }

    public LaTeXView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

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

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LaTeXView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
        if ((i2 & 2) != 0) {
            attributeSet = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LaTeXView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.g2 = new Graphics2D(context, null, 2, null);
        this.bgPaint = new Paint(1);
        enableOnDraw();
    }

    protected final LaTeXIcon getTeXIcon() {
        return this.teXIcon;
    }

    protected final void setTeXIcon(LaTeXIcon laTeXIcon) {
        this.teXIcon = laTeXIcon;
    }

    protected final Graphics2D getG2() {
        return this.g2;
    }

    protected final Paint getBgPaint() {
        return this.bgPaint;
    }

    private final void enableOnDraw() {
        setWillNotDraw(false);
    }

    public final void bindTexIcon(LaTeXIcon teXIcon) {
        Intrinsics.checkNotNullParameter(teXIcon, "teXIcon");
        this.teXIcon = teXIcon;
        List<ILaTeXView> iTeXViewList = teXIcon.getITeXViewList();
        this.g2.setCustomViewList(iTeXViewList);
        removeAllViews();
        if (teXIcon.getCustomViewList().isEmpty() && (!iTeXViewList.isEmpty())) {
            LinkedList linkedList = new LinkedList();
            for (ILaTeXView iLaTeXView : iTeXViewList) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                linkedList.add(iLaTeXView.getAndroidView(context));
            }
            teXIcon.setCustomViewList(linkedList);
        }
        List<View> customViewList = teXIcon.getCustomViewList();
        List<View> list = customViewList;
        if ((!list.isEmpty()) && customViewList.size() == iTeXViewList.size()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = customViewList.get(i);
                ILaTeXView iLaTeXView2 = iTeXViewList.get(i);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) iLaTeXView2.getViewWidth(), (int) iLaTeXView2.getViewHeight());
                ViewParent parent = view.getParent();
                if (!(parent instanceof ViewGroup)) {
                    parent = null;
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
                addView(view, layoutParams);
                view.setVisibility(8);
            }
        }
        requestLayout();
    }

    private final int measureHeight() {
        LaTeXIcon laTeXIcon = this.teXIcon;
        return (laTeXIcon != null ? laTeXIcon.getHeight() : 0) + getPaddingTop() + getPaddingBottom();
    }

    private final int measureWidth() {
        LaTeXParam latexParam;
        TexSize texWidthSize;
        LaTeXIcon laTeXIcon = this.teXIcon;
        if (laTeXIcon == null || (latexParam = laTeXIcon.getLatexParam()) == null || (texWidthSize = latexParam.getTexWidthSize()) == null) {
            return 0;
        }
        return texWidthSize.toPx();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(), measureHeight());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        LaTeXIcon laTeXIcon = this.teXIcon;
        if (laTeXIcon != null) {
            canvas.save();
            if (laTeXIcon.getLatexParam().getBackgroundColor() != 0) {
                this.bgPaint.setColor(laTeXIcon.getLatexParam().getBackgroundColor());
                canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.bgPaint);
            }
            this.g2.setCanvas(canvas);
            laTeXIcon.setForeground(laTeXIcon.getLatexParam().getForegroundColor());
            laTeXIcon.paintIcon(this.g2, 0, 0);
            canvas.restore();
        }
    }
}
