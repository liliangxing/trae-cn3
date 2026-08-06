package io.noties.markwon.core.spans.codeblock;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockSpan2Info;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.custom.TypingFreeSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeBlockSpan2.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002JH\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0002JH\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0002Jh\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0010H\u0016J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lio/noties/markwon/core/spans/codeblock/CodeBlockSpan2;", "Landroid/text/style/MetricAffectingSpan;", "Landroid/text/style/LeadingMarginSpan;", "Lio/noties/markwon/custom/TypingFreeSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "info", "Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockSpan2Info;", "(Lio/noties/markwon/core/MarkwonTheme;Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockSpan2Info;)V", "paint", "Landroid/graphics/Paint;", "rect", "Landroid/graphics/Rect;", "apply", "", "p", "Landroid/text/TextPaint;", "drawBackground", "start", "", "end", "textPaint", "c", "Landroid/graphics/Canvas;", AnimationConstant.PROP_STR_LEFT, AnimationConstant.PROP_STR_RIGHT, AnimationConstant.PROP_STR_TOP, AnimationConstant.PROP_STR_BOTTOM, "drawBorder", "drawLeadingMargin", "x", "dir", "baseline", "text", "", "first", "", "layout", "Landroid/text/Layout;", "getLeadingMargin", "updateDrawState", "ds", "updateMeasureState", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CodeBlockSpan2 extends MetricAffectingSpan implements LeadingMarginSpan, TypingFreeSpan {
    private final CodeBlockSpan2Info info;
    private final Paint paint;
    private final Rect rect;
    private final MarkwonTheme theme;

    public CodeBlockSpan2(MarkwonTheme markwonTheme, CodeBlockSpan2Info codeBlockSpan2Info) {
        Intrinsics.checkNotNullParameter(markwonTheme, "theme");
        Intrinsics.checkNotNullParameter(codeBlockSpan2Info, "info");
        this.theme = markwonTheme;
        this.info = codeBlockSpan2Info;
        this.rect = new Rect();
        this.paint = new Paint(1);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint p) {
        Intrinsics.checkNotNullParameter(p, "p");
        apply(p);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        apply(ds);
    }

    private final void apply(TextPaint p) {
        this.theme.applyCodeBlockTextStyle(p);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        return this.theme.getCodeBlockMargin();
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(layout, "layout");
        int width = layout.getWidth();
        if (dir > 0) {
            i2 = x;
            i = width;
        } else {
            i = x;
            i2 = x - width;
        }
        if (this.info.getEnableBackground()) {
            drawBackground(start, end, p, c, i2, i, top, bottom);
        }
        if (this.info.getBorderColor() != 0) {
            if (this.info.getBorderWidth() == 0.0f) {
                return;
            }
            drawBorder(start, end, p, c, i2, i, top, bottom);
        }
    }

    private final void drawBackground(int start, int end, Paint textPaint, Canvas c, int left, int right, int top, int bottom) {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.theme.getCodeBlockBackgroundColor(textPaint));
        Integer codeBlockStartIndex = this.info.getCodeBlockStartIndex();
        if (codeBlockStartIndex != null && start == codeBlockStartIndex.intValue()) {
            Path path = new Path();
            float f = right - left;
            float cornerRadius = this.info.getCornerRadius();
            path.moveTo(left + cornerRadius, top);
            path.rLineTo(f - (2 * cornerRadius), 0.0f);
            path.rQuadTo(cornerRadius, 0.0f, cornerRadius, cornerRadius);
            float f2 = (bottom - top) - cornerRadius;
            path.rLineTo(0.0f, f2);
            path.rLineTo(-f, 0.0f);
            path.rLineTo(0.0f, -f2);
            float f3 = -cornerRadius;
            path.rQuadTo(0.0f, f3, cornerRadius, f3);
            path.close();
            this.paint.setColor(this.info.getTitleBgColor());
            c.drawPath(path, this.paint);
            return;
        }
        Integer codeBlockEndIndex = this.info.getCodeBlockEndIndex();
        if (codeBlockEndIndex != null && end == codeBlockEndIndex.intValue()) {
            Path path2 = new Path();
            float f4 = right - left;
            float cornerRadius2 = this.info.getCornerRadius();
            path2.moveTo(left, top);
            path2.rLineTo(f4, 0.0f);
            float f5 = (bottom - top) - cornerRadius2;
            path2.rLineTo(0.0f, f5);
            float f6 = -cornerRadius2;
            path2.rQuadTo(0.0f, cornerRadius2, f6, cornerRadius2);
            path2.rLineTo(-(f4 - (2 * cornerRadius2)), 0.0f);
            path2.rQuadTo(f6, 0.0f, f6, f6);
            path2.rLineTo(0.0f, -f5);
            path2.close();
            c.drawPath(path2, this.paint);
            return;
        }
        this.rect.set(left, top, right, bottom);
        c.drawRect(this.rect, this.paint);
    }

    private final void drawBorder(int start, int end, Paint textPaint, Canvas c, int left, int right, int top, int bottom) {
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.info.getBorderWidth());
        this.paint.setColor(this.info.getBorderColor());
        Integer codeBlockStartIndex = this.info.getCodeBlockStartIndex();
        if (codeBlockStartIndex != null && start == codeBlockStartIndex.intValue()) {
            Path path = new Path();
            float f = right - left;
            float cornerRadius = this.info.getCornerRadius();
            path.moveTo(left, bottom);
            float f2 = (bottom - top) - cornerRadius;
            path.rLineTo(0.0f, -f2);
            float f3 = -cornerRadius;
            path.rQuadTo(0.0f, f3, cornerRadius, f3);
            path.rLineTo(f - (2 * cornerRadius), 0.0f);
            path.rQuadTo(cornerRadius, 0.0f, cornerRadius, cornerRadius);
            path.rLineTo(0.0f, f2);
            c.drawPath(path, this.paint);
            return;
        }
        Integer codeBlockEndIndex = this.info.getCodeBlockEndIndex();
        if (codeBlockEndIndex != null && end == codeBlockEndIndex.intValue()) {
            Path path2 = new Path();
            float f4 = right - left;
            float cornerRadius2 = this.info.getCornerRadius();
            path2.moveTo(left, top);
            float f5 = (bottom - top) - cornerRadius2;
            path2.rLineTo(0.0f, f5);
            path2.rQuadTo(0.0f, cornerRadius2, cornerRadius2, cornerRadius2);
            path2.rLineTo(f4 - (2 * cornerRadius2), 0.0f);
            path2.rQuadTo(cornerRadius2, 0.0f, cornerRadius2, -cornerRadius2);
            path2.rLineTo(0.0f, -f5);
            c.drawPath(path2, this.paint);
            return;
        }
        float f6 = left;
        float f7 = top;
        float f8 = bottom;
        c.drawLine(f6, f7, f6, f8, this.paint);
        float f9 = right;
        c.drawLine(f9, f7, f9, f8, this.paint);
    }
}
