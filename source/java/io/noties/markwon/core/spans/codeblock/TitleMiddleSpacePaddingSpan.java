package io.noties.markwon.core.spans.codeblock;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.text.style.ReplacementSpan;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.larus.business.markdown.impl.common.utils.MarkdownUnitExtKt;
import com.larus.business.markdown.impl.markwon.custom.title.TableTitleSpan;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.core.spans.CodeBlockSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: TitleMiddleSpacePaddingSpan.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJP\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J2\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lio/noties/markwon/core/spans/codeblock/TitleMiddleSpacePaddingSpan;", "Landroid/text/style/ReplacementSpan;", "titleStr", "", "contentMaxWidth", "", "toDeleteSpaceList", "", "Lkotlin/Pair;", "horizontalExtraSpace", "verticalPadding", "(Ljava/lang/CharSequence;ILjava/util/List;II)V", "fixChCenter", WebViewContainer.EVENT_draw, "", "canvas", "Landroid/graphics/Canvas;", "text", "start", "end", "x", "", AnimationConstant.PROP_STR_TOP, "y", AnimationConstant.PROP_STR_BOTTOM, "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class TitleMiddleSpacePaddingSpan extends ReplacementSpan {
    private final int contentMaxWidth;
    private final int fixChCenter;
    private final int horizontalExtraSpace;
    private final CharSequence titleStr;
    private final List<Pair<Integer, Integer>> toDeleteSpaceList;
    private final int verticalPadding;

    public TitleMiddleSpacePaddingSpan(CharSequence charSequence, int i, List<Pair<Integer, Integer>> list, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "titleStr");
        Intrinsics.checkNotNullParameter(list, "toDeleteSpaceList");
        this.titleStr = charSequence;
        this.contentMaxWidth = i;
        this.toDeleteSpaceList = list;
        this.horizontalExtraSpace = i2;
        this.verticalPadding = i3;
        this.fixChCenter = MarkdownUnitExtKt.dp2px((Number) 2);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        if (fm != null) {
            fm.ascent -= this.verticalPadding + this.fixChCenter;
            fm.top -= this.verticalPadding + this.fixChCenter;
            fm.descent += this.verticalPadding - this.fixChCenter;
            fm.bottom += this.verticalPadding - this.fixChCenter;
        }
        float f = this.horizontalExtraSpace;
        Iterator<T> it = this.toDeleteSpaceList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            f += paint.measureText(this.titleStr, ((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue());
        }
        SpannableString spannableString = text instanceof SpannableString ? (SpannableString) text : null;
        if (spannableString != null) {
            Object[] spans = spannableString.getSpans(start, end, LeadingMarginSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "sb.getSpans(start, end, …ngMarginSpan::class.java)");
            ArrayList arrayList = new ArrayList();
            for (Object obj : spans) {
                LeadingMarginSpan leadingMarginSpan = (LeadingMarginSpan) obj;
                if (((leadingMarginSpan instanceof CodeBlockSpan) || (leadingMarginSpan instanceof CodeBlockSpan2) || (leadingMarginSpan instanceof TableTitleSpan)) ? false : true) {
                    arrayList.add(obj);
                }
            }
            Iterator it2 = arrayList.iterator();
            int i = 0;
            while (it2.hasNext()) {
                i += ((LeadingMarginSpan) it2.next()).getLeadingMargin(false);
            }
            f += i;
        }
        return (int) RangesKt.coerceAtLeast(this.contentMaxWidth - f, 0.0f);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawText(text, start, end, x, y, paint);
    }
}
