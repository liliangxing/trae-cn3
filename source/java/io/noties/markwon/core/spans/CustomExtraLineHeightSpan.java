package io.noties.markwon.core.spans;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.larus.business.markdown.api.NormalLineHeight;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: CustomExtraLineHeightSpan.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007JF\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/noties/markwon/core/spans/CustomExtraLineHeightSpan;", "Lio/noties/markwon/core/spans/ExtraLineHeightSpan;", "blankLineMulti", "", "textLineMulti", "loading", "", "(FFZ)V", "chooseHeight", "", "text", "", "start", "", "end", "spanstartv", "lineHeight", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "paint", "Landroid/text/TextPaint;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class CustomExtraLineHeightSpan extends ExtraLineHeightSpan {
    private final float blankLineMulti;
    private final boolean loading;
    private final float textLineMulti;

    public CustomExtraLineHeightSpan(float f, float f2, boolean z) {
        super(f, f2);
        this.blankLineMulti = f;
        this.textLineMulti = f2;
        this.loading = z;
    }

    @Override // io.noties.markwon.core.spans.ExtraLineHeightSpan, android.text.style.LineHeightSpan.WithDensity
    public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int lineHeight, Paint.FontMetricsInt fm, TextPaint paint) {
        ArrayList arrayList;
        if (paint == null || fm == null || text == null) {
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        if (fontMetricsInt.descent - fontMetricsInt.ascent <= 0) {
            return;
        }
        if (text instanceof Spanned) {
            ReplacementSpan[] replacementSpanArr = (ReplacementSpan[]) ((Spanned) text).getSpans(start, end, ReplacementSpan.class);
            if (replacementSpanArr != null) {
                ArrayList arrayList2 = new ArrayList();
                for (ReplacementSpan replacementSpan : replacementSpanArr) {
                    if (!(replacementSpan instanceof NormalLineHeight)) {
                        arrayList2.add(replacementSpan);
                    }
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            ArrayList arrayList3 = arrayList;
            if (!(arrayList3 == null || arrayList3.isEmpty())) {
                return;
            }
        }
        float f = (!ExtraLineHeightSpan.isBlank(text.subSequence(start, end)) || (this.loading && text.length() == end - 1)) ? this.textLineMulti : this.blankLineMulti;
        fm.ascent = Math.round(fontMetricsInt.ascent * f);
        fm.descent = Math.round(fontMetricsInt.descent * f);
        fm.top = Math.round(fontMetricsInt.top * f);
        fm.bottom = Math.round(fontMetricsInt.bottom * f);
    }
}
