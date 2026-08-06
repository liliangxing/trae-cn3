package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.larus.business.markdown.api.view.text.IUnderlineTextView;
import com.larus.business.markdown.impl.C1327R;
import io.noties.markwon.core.spans.CustomLinkSpan;
import io.noties.markwon.image.AsyncDrawableSpan;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: UnderlineTextView.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/UnderlineTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/larus/business/markdown/api/view/text/IUnderlineTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawLine", "", "getDrawLine", "()Z", "setDrawLine", "(Z)V", "lineColor", "getLineColor", "()I", "setLineColor", "(I)V", "linePaint", "Landroid/graphics/Paint;", WebViewContainer.EVENT_onDraw, "", "canvas", "Landroid/graphics/Canvas;", "setBottomLineWeight", "weight", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class UnderlineTextView extends AppCompatTextView implements IUnderlineTextView {
    private boolean drawLine;
    private int lineColor;
    private final Paint linePaint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnderlineTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnderlineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ UnderlineTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnderlineTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.lineColor = ContextCompat.getColor(getContext(), C1327R.color.primary_transparent_4);
        this.linePaint = new Paint();
    }

    @Override // com.larus.business.markdown.api.view.text.IUnderlineTextView
    public int getLineColor() {
        return this.lineColor;
    }

    @Override // com.larus.business.markdown.api.view.text.IUnderlineTextView
    public void setLineColor(int i) {
        this.lineColor = i;
    }

    @Override // com.larus.business.markdown.api.view.text.IUnderlineTextView
    public boolean getDrawLine() {
        return this.drawLine;
    }

    @Override // com.larus.business.markdown.api.view.text.IUnderlineTextView
    public void setDrawLine(boolean z) {
        this.drawLine = z;
    }

    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Rect bounds;
        Integer valueOf;
        Rect bounds2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        int i6 = 0;
        if (getDrawLine()) {
            this.linePaint.setColor(getLineColor());
            Paint.FontMetricsInt fontMetricsInt = getPaint().getFontMetricsInt();
            int abs = (Math.abs((fontMetricsInt.bottom - fontMetricsInt.ascent) - getLineHeight()) - (fontMetricsInt.bottom - fontMetricsInt.descent)) + (Math.abs(fontMetricsInt.descent) / 2);
            int lineCount = getLineCount();
            while (i6 < lineCount) {
                float paddingLeft = getPaddingLeft() + layout.getLineLeft(i6);
                float lineRight = layout.getLineRight(i6) + getPaddingLeft();
                float lineBottom = (layout.getLineBottom(i6) + getPaddingTop()) - abs;
                canvas.drawLine(paddingLeft, lineBottom, lineRight, lineBottom, this.linePaint);
                i6++;
            }
            return;
        }
        CharSequence text = getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned != null) {
            this.linePaint.setColor(getLineColor());
            Object[] spans = spanned.getSpans(0, spanned.length(), CustomLinkSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(0, length, CustomLinkSpan::class.java)");
            ArrayList arrayList = new ArrayList();
            for (Object obj : spans) {
                if (((CustomLinkSpan) obj).getNeedUnderLine()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            Paint.FontMetricsInt fontMetricsInt2 = getPaint().getFontMetricsInt();
            int abs2 = (Math.abs((fontMetricsInt2.bottom - fontMetricsInt2.ascent) - getLineHeight()) - (fontMetricsInt2.bottom - fontMetricsInt2.descent)) + (Math.abs(fontMetricsInt2.descent) / 2);
            int size = arrayList2.size();
            int i7 = 0;
            while (i7 < size) {
                CustomLinkSpan customLinkSpan = (CustomLinkSpan) arrayList2.get(i7);
                int spanStart = spanned.getSpanStart(customLinkSpan);
                int spanEnd = spanned.getSpanEnd(customLinkSpan);
                int lineForOffset = layout.getLineForOffset(spanStart);
                int lineForOffset2 = layout.getLineForOffset(spanEnd);
                float primaryHorizontal = layout.getPrimaryHorizontal(spanStart);
                float primaryHorizontal2 = layout.getPrimaryHorizontal(spanEnd);
                int lineCount2 = getLineCount();
                int i8 = i6;
                while (i8 < lineCount2) {
                    if (i8 < lineForOffset || i8 > lineForOffset2) {
                        i = i8;
                        i2 = lineCount2;
                        i3 = lineForOffset2;
                        i4 = lineForOffset;
                        i5 = i7;
                    } else {
                        Object[] spans2 = spanned.getSpans(layout.getLineStart(i8), layout.getLineEnd(i8), AsyncDrawableSpan.class);
                        Intrinsics.checkNotNullExpressionValue(spans2, "getSpans(\n              …                        )");
                        int i9 = 1;
                        if (spans2.length == 0) {
                            i2 = lineCount2;
                            valueOf = null;
                        } else {
                            AsyncDrawableSpan asyncDrawableSpan = (AsyncDrawableSpan) spans2[0];
                            Drawable result = asyncDrawableSpan.getDrawable().getResult();
                            if (result == null || (bounds = result.getBounds()) == null) {
                                bounds = asyncDrawableSpan.getDrawable().getBounds();
                            }
                            valueOf = Integer.valueOf(bounds.height());
                            i2 = lineCount2;
                            int lastIndex = ArraysKt.getLastIndex(spans2);
                            if (1 <= lastIndex) {
                                while (true) {
                                    AsyncDrawableSpan asyncDrawableSpan2 = (AsyncDrawableSpan) spans2[i9];
                                    Drawable result2 = asyncDrawableSpan2.getDrawable().getResult();
                                    int height = (result2 == null || (bounds2 = result2.getBounds()) == null) ? asyncDrawableSpan2.getDrawable().getBounds().height() : bounds2.height();
                                    Object[] objArr = spans2;
                                    Integer valueOf2 = Integer.valueOf(height);
                                    if (valueOf.compareTo(valueOf2) < 0) {
                                        valueOf = valueOf2;
                                    }
                                    if (i9 == lastIndex) {
                                        break;
                                    }
                                    i9++;
                                    spans2 = objArr;
                                }
                            }
                        }
                        Integer num = valueOf;
                        float coerceAtLeast = RangesKt.coerceAtLeast(((num != null ? num.intValue() : 0) - (fontMetricsInt2.descent - fontMetricsInt2.ascent)) / 2, 0);
                        float paddingTop = getPaddingTop() + abs2 + layout.getLineBaseline(i8) + coerceAtLeast;
                        i = i8;
                        i3 = lineForOffset2;
                        i4 = lineForOffset;
                        i5 = i7;
                        canvas.drawLine(getPaddingLeft() + (i8 == lineForOffset ? primaryHorizontal : layout.getPrimaryHorizontal(layout.getLineStart(i8))), paddingTop, getPaddingLeft() + (i8 == lineForOffset2 ? primaryHorizontal2 : layout.getLineMax(i8)), paddingTop, this.linePaint);
                    }
                    i8 = i + 1;
                    lineForOffset = i4;
                    i7 = i5;
                    lineCount2 = i2;
                    lineForOffset2 = i3;
                }
                i7++;
                i6 = 0;
            }
        }
    }

    @Override // com.larus.business.markdown.api.view.text.IUnderlineTextView
    public void setBottomLineWeight(float weight) {
        this.linePaint.setStrokeWidth(weight);
    }
}
