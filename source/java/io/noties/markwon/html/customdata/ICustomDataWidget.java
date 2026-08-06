package io.noties.markwon.html.customdata;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICustomDataWidget.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J>\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH&Ji\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010\u001fJi\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\b\u0010!\u001a\u00020\"H\u0016J0\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0016¨\u0006$"}, d2 = {"Lio/noties/markwon/html/customdata/ICustomDataWidget;", "", "asView", "Landroid/view/View;", "bindData", "Landroid/util/Size;", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "maxWidth", "", "payload", "", "", "onDrawOffsetX", "widgetSize", "canvas", "Landroid/graphics/Canvas;", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "(Landroid/util/Size;Landroid/widget/TextView;Landroid/graphics/Canvas;Ljava/lang/CharSequence;IIFIIILandroid/graphics/Paint;)Ljava/lang/Integer;", "onDrawOffsetY", "onRecycle", "", "onReuse", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public interface ICustomDataWidget {

    /* compiled from: ICustomDataWidget.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static Integer onDrawOffsetX(ICustomDataWidget iCustomDataWidget, Size widgetSize, TextView textView, Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Intrinsics.checkParameterIsNotNull(widgetSize, "widgetSize");
            Intrinsics.checkParameterIsNotNull(textView, "textView");
            Intrinsics.checkParameterIsNotNull(canvas, "canvas");
            Intrinsics.checkParameterIsNotNull(paint, "paint");
            return null;
        }

        public static Integer onDrawOffsetY(ICustomDataWidget iCustomDataWidget, Size widgetSize, TextView textView, Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Intrinsics.checkParameterIsNotNull(widgetSize, "widgetSize");
            Intrinsics.checkParameterIsNotNull(textView, "textView");
            Intrinsics.checkParameterIsNotNull(canvas, "canvas");
            Intrinsics.checkParameterIsNotNull(paint, "paint");
            return null;
        }

        public static void onRecycle(ICustomDataWidget iCustomDataWidget) {
        }

        public static Size onReuse(ICustomDataWidget iCustomDataWidget, TextView textView, ICustomDataSpan span, Map<String, ? extends Object> map) {
            Intrinsics.checkParameterIsNotNull(textView, "textView");
            Intrinsics.checkParameterIsNotNull(span, "span");
            return null;
        }
    }

    View asView();

    Size bindData(TextView textView, Spanned text, ICustomDataSpan span, int maxWidth, Map<String, ? extends Object> payload);

    Integer onDrawOffsetX(Size widgetSize, TextView textView, Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint);

    Integer onDrawOffsetY(Size widgetSize, TextView textView, Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint);

    void onRecycle();

    Size onReuse(TextView textView, ICustomDataSpan span, Map<String, ? extends Object> payload);
}
