package io.noties.markwon.core.spans;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.TextView;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.larus.business.markdown.api.citation.ICitationHandler;
import com.larus.business.markdown.api.model.ICustomCitationSpan;
import com.larus.business.markdown.impl.C1327R;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.LinkResolver;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.movement.IHandlerTouchSpan;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CustomCitationSpan.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJR\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0018H\u0016J4\u0010.\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u000e\u00101\u001a\u00020\"2\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u00020\"2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020\"2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00108\u001a\u00020\"2\u0006\u00105\u001a\u000206H\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\u001e\u001a\n \u0019*\u0004\u0018\u00010\u001f0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n \u0019*\u0004\u0018\u00010\u001f0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lio/noties/markwon/core/spans/CustomCitationSpan;", "Landroid/text/style/ReplacementSpan;", "Lcom/larus/business/markdown/api/model/ICustomCitationSpan;", "Lio/noties/markwon/movement/IHandlerTouchSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "mTitle", "", "mLink", "linkResolver", "Lio/noties/markwon/LinkResolver;", "handler", "Lcom/larus/business/markdown/api/citation/ICitationHandler;", "(Lio/noties/markwon/core/MarkwonTheme;Ljava/lang/String;Ljava/lang/String;Lio/noties/markwon/LinkResolver;Lcom/larus/business/markdown/api/citation/ICitationHandler;)V", "completeTouchProgress", "", "dp10", "", "dp26", "dp8", "link", "getLink", "()Ljava/lang/String;", "paint", "Landroid/graphics/Paint;", "kotlin.jvm.PlatformType", "getTheme", "()Lio/noties/markwon/core/MarkwonTheme;", "title", "getTitle", "touchDownAnimator", "Landroid/animation/ValueAnimator;", "touchUpAnimator", WebViewContainer.EVENT_draw, "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", AnimationConstant.PROP_STR_TOP, "y", AnimationConstant.PROP_STR_BOTTOM, "pt", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "onClick", "view", "Landroid/view/View;", "onTouchCancel", "widget", "Landroid/widget/TextView;", "onTouchDown", "onTouchUp", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomCitationSpan extends ReplacementSpan implements ICustomCitationSpan, IHandlerTouchSpan {
    private float completeTouchProgress;
    private final int dp10;
    private final int dp26;
    private final int dp8;
    private final ICitationHandler handler;
    private final String link;
    private final LinkResolver linkResolver;
    private final Paint paint;
    private final MarkwonTheme theme;
    private final String title;
    private final ValueAnimator touchDownAnimator;
    private final ValueAnimator touchUpAnimator;

    public /* synthetic */ CustomCitationSpan(MarkwonTheme markwonTheme, String str, String str2, LinkResolver linkResolver, ICitationHandler iCitationHandler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(markwonTheme, str, str2, linkResolver, (i & 16) != 0 ? null : iCitationHandler);
    }

    public final MarkwonTheme getTheme() {
        return this.theme;
    }

    public CustomCitationSpan(MarkwonTheme markwonTheme, String str, String str2, LinkResolver linkResolver, ICitationHandler iCitationHandler) {
        Intrinsics.checkNotNullParameter(markwonTheme, "theme");
        Intrinsics.checkNotNullParameter(str, "mTitle");
        Intrinsics.checkNotNullParameter(str2, "mLink");
        Intrinsics.checkNotNullParameter(linkResolver, "linkResolver");
        this.theme = markwonTheme;
        this.linkResolver = linkResolver;
        this.handler = iCitationHandler;
        this.title = str;
        this.link = str2;
        this.paint = ObjectsPool.paint();
        this.dp26 = MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_26);
        this.dp10 = MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_10);
        this.dp8 = MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_8);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(60L);
        ofFloat.setInterpolator(new CubicBezierInterpolator(0.25f, 1.0f, 0.25f, 1.0f));
        this.touchDownAnimator = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setDuration(60L);
        ofFloat2.setInterpolator(new CubicBezierInterpolator(0.25f, 1.0f, 0.25f, 1.0f));
        this.touchUpAnimator = ofFloat2;
    }

    @Override // com.larus.business.markdown.api.model.ICustomCitationSpan
    public String getTitle() {
        return this.title;
    }

    @Override // com.larus.business.markdown.api.model.ICustomCitationSpan
    public String getLink() {
        return this.link;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        ICitationHandler iCitationHandler = this.handler;
        return iCitationHandler != null ? iCitationHandler.getSize(paint, text, start, end, fm, new ICitationHandler.Companion.CitationInfo(getTitle(), getLink())) : this.dp26;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(final Canvas canvas, CharSequence text, int start, int end, final float x, int top, final int y, int bottom, Paint pt) {
        Integer num;
        ICitationHandler iCitationHandler;
        MarkdownSpanInfo[] markdownSpanInfoArr;
        MarkdownSpanInfo markdownSpanInfo;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(pt, "pt");
        this.paint.set(pt);
        Unit unit = null;
        SpannableString spannableString = text instanceof SpannableString ? (SpannableString) text : null;
        if (spannableString != null && (markdownSpanInfoArr = (MarkdownSpanInfo[]) spannableString.getSpans(start, end, MarkdownSpanInfo.class)) != null && (markdownSpanInfo = (MarkdownSpanInfo) ArraysKt.firstOrNull(markdownSpanInfoArr)) != null) {
            num = Integer.valueOf(markdownSpanInfo.getAlpha());
            if (num != null) {
                this.paint.setAlpha(num.intValue());
            }
            Function0<Unit> function0 = new Function0<Unit>() { // from class: io.noties.markwon.core.spans.CustomCitationSpan$draw$defaultHandler$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2937invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2937invoke() {
                    Paint paint;
                    Paint paint2;
                    int i;
                    Paint paint3;
                    Paint paint4;
                    Paint paint5;
                    Paint paint6;
                    int i2;
                    int i3;
                    Paint paint7;
                    String trim = StringsKt.trim(CustomCitationSpan.this.getTitle(), new char[]{'[', ']'});
                    paint = CustomCitationSpan.this.paint;
                    paint.setTypeface(Typeface.DEFAULT_BOLD);
                    paint2 = CustomCitationSpan.this.paint;
                    paint2.setTextSize(MarkdownDimensExtKt.getDp_12());
                    i = CustomCitationSpan.this.dp26;
                    paint3 = CustomCitationSpan.this.paint;
                    float f = 2;
                    float measureText = (i - paint3.measureText(trim)) / f;
                    paint4 = CustomCitationSpan.this.paint;
                    Paint.FontMetrics fontMetrics = paint4.getFontMetrics();
                    float f2 = ((fontMetrics.descent - fontMetrics.ascent) / f) - fontMetrics.descent;
                    float f3 = 3;
                    paint5 = CustomCitationSpan.this.paint;
                    canvas.drawText(trim, x + measureText, y - f3, paint5);
                    MarkwonTheme theme = CustomCitationSpan.this.getTheme();
                    paint6 = CustomCitationSpan.this.paint;
                    theme.applyThematicBreakStyle(paint6);
                    Canvas canvas2 = canvas;
                    float f4 = x;
                    i2 = CustomCitationSpan.this.dp26;
                    float f5 = f4 + (i2 / 2.0f);
                    float f6 = (y - f2) - f3;
                    i3 = CustomCitationSpan.this.dp10;
                    paint7 = CustomCitationSpan.this.paint;
                    canvas2.drawCircle(f5, f6, i3, paint7);
                }
            };
            iCitationHandler = this.handler;
            if (iCitationHandler != null) {
                Paint paint = this.paint;
                Intrinsics.checkNotNullExpressionValue(paint, "paint");
                iCitationHandler.draw(canvas, text, start, end, x, top, y, bottom, pt, paint, this.theme, new ICitationHandler.Companion.CitationInfo(getTitle(), getLink()), this.completeTouchProgress);
                unit = Unit.INSTANCE;
            }
            if (unit != null) {
                function0.invoke();
                return;
            }
            return;
        }
        num = null;
        if (num != null) {
        }
        Function0<Unit> function02 = new Function0<Unit>() { // from class: io.noties.markwon.core.spans.CustomCitationSpan$draw$defaultHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2937invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2937invoke() {
                Paint paint2;
                Paint paint22;
                int i;
                Paint paint3;
                Paint paint4;
                Paint paint5;
                Paint paint6;
                int i2;
                int i3;
                Paint paint7;
                String trim = StringsKt.trim(CustomCitationSpan.this.getTitle(), new char[]{'[', ']'});
                paint2 = CustomCitationSpan.this.paint;
                paint2.setTypeface(Typeface.DEFAULT_BOLD);
                paint22 = CustomCitationSpan.this.paint;
                paint22.setTextSize(MarkdownDimensExtKt.getDp_12());
                i = CustomCitationSpan.this.dp26;
                paint3 = CustomCitationSpan.this.paint;
                float f = 2;
                float measureText = (i - paint3.measureText(trim)) / f;
                paint4 = CustomCitationSpan.this.paint;
                Paint.FontMetrics fontMetrics = paint4.getFontMetrics();
                float f2 = ((fontMetrics.descent - fontMetrics.ascent) / f) - fontMetrics.descent;
                float f3 = 3;
                paint5 = CustomCitationSpan.this.paint;
                canvas.drawText(trim, x + measureText, y - f3, paint5);
                MarkwonTheme theme = CustomCitationSpan.this.getTheme();
                paint6 = CustomCitationSpan.this.paint;
                theme.applyThematicBreakStyle(paint6);
                Canvas canvas2 = canvas;
                float f4 = x;
                i2 = CustomCitationSpan.this.dp26;
                float f5 = f4 + (i2 / 2.0f);
                float f6 = (y - f2) - f3;
                i3 = CustomCitationSpan.this.dp10;
                paint7 = CustomCitationSpan.this.paint;
                canvas2.drawCircle(f5, f6, i3, paint7);
            }
        };
        iCitationHandler = this.handler;
        if (iCitationHandler != null) {
        }
        if (unit != null) {
        }
    }

    public void onTouchDown(final TextView widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        this.touchDownAnimator.cancel();
        this.touchDownAnimator.removeAllUpdateListeners();
        this.touchDownAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: io.noties.markwon.core.spans.CustomCitationSpan$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CustomCitationSpan.onTouchDown$lambda$3(CustomCitationSpan.this, widget, valueAnimator);
            }
        });
        this.touchDownAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchDown$lambda$3(CustomCitationSpan customCitationSpan, TextView textView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(customCitationSpan, "this$0");
        Intrinsics.checkNotNullParameter(textView, "$widget");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Float f = animatedValue instanceof Float ? (Float) animatedValue : null;
        customCitationSpan.completeTouchProgress = f != null ? f.floatValue() : 0.0f;
        textView.invalidate();
    }

    public void onTouchUp(final TextView widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        this.touchDownAnimator.end();
        this.touchUpAnimator.cancel();
        this.touchUpAnimator.removeAllUpdateListeners();
        this.touchUpAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: io.noties.markwon.core.spans.CustomCitationSpan$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CustomCitationSpan.onTouchUp$lambda$4(CustomCitationSpan.this, widget, valueAnimator);
            }
        });
        this.touchUpAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchUp$lambda$4(CustomCitationSpan customCitationSpan, TextView textView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(customCitationSpan, "this$0");
        Intrinsics.checkNotNullParameter(textView, "$widget");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Float f = animatedValue instanceof Float ? (Float) animatedValue : null;
        customCitationSpan.completeTouchProgress = f != null ? f.floatValue() : 0.0f;
        textView.invalidate();
    }

    public void onTouchCancel(final TextView widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        this.touchDownAnimator.end();
        this.touchUpAnimator.cancel();
        this.touchUpAnimator.removeAllUpdateListeners();
        this.touchUpAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: io.noties.markwon.core.spans.CustomCitationSpan$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CustomCitationSpan.onTouchCancel$lambda$5(CustomCitationSpan.this, widget, valueAnimator);
            }
        });
        this.touchUpAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouchCancel$lambda$5(CustomCitationSpan customCitationSpan, TextView textView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(customCitationSpan, "this$0");
        Intrinsics.checkNotNullParameter(textView, "$widget");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Float f = animatedValue instanceof Float ? (Float) animatedValue : null;
        customCitationSpan.completeTouchProgress = f != null ? f.floatValue() : 0.0f;
        textView.invalidate();
    }

    public final void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.linkResolver.resolve(view, getLink());
    }
}
