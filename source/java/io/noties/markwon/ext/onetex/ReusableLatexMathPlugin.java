package io.noties.markwon.ext.onetex;

import android.content.Context;
import android.text.Spanned;
import android.widget.TextView;
import com.edu.onetex.latex.icon.LaTeXIcon;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableSpan;
import io.noties.markwon.pool.ReuseDrawablePool;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReusableLatexMathPlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016JM\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014¢\u0006\u0002\u0010\u001fJE\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u00192\b\u0010#\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010$R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lio/noties/markwon/ext/onetex/ReusableLatexMathPlugin;", "Lio/noties/markwon/ext/onetex/LatexMathPlugin;", "context", "Landroid/content/Context;", "config", "Lio/noties/markwon/ext/onetex/LatexConfig;", "drawablePool", "Lio/noties/markwon/pool/ReuseDrawablePool;", "(Landroid/content/Context;Lio/noties/markwon/ext/onetex/LatexConfig;Lio/noties/markwon/pool/ReuseDrawablePool;)V", "afterSetText", "", "textView", "Landroid/widget/TextView;", "beforeSetText", "markdown", "Landroid/text/Spanned;", "createSpan", "Lio/noties/markwon/image/AsyncDrawableSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "latex", "", "isBlock", "", "texIcon", "Lcom/edu/onetex/latex/icon/LaTeXIcon;", "order", "", "textColor", "textSize", "", "(Lio/noties/markwon/core/MarkwonTheme;Ljava/lang/String;ZLcom/edu/onetex/latex/icon/LaTeXIcon;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)Lio/noties/markwon/image/AsyncDrawableSpan;", "obtainDrawable", "Lio/noties/markwon/ext/onetex/LatexAsyncDrawable;", "teX", "texOrder", "(Ljava/lang/String;ZLcom/edu/onetex/latex/icon/LaTeXIcon;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)Lio/noties/markwon/ext/onetex/LatexAsyncDrawable;", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class ReusableLatexMathPlugin extends LatexMathPlugin {
    private final ReuseDrawablePool drawablePool;

    @Override // io.noties.markwon.ext.onetex.LatexMathPlugin
    public void afterSetText(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
    }

    @Override // io.noties.markwon.ext.onetex.LatexMathPlugin
    public void beforeSetText(TextView textView, Spanned markdown) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        Intrinsics.checkParameterIsNotNull(markdown, "markdown");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ReusableLatexMathPlugin(Context context, LatexConfig latexConfig, ReuseDrawablePool reuseDrawablePool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, latexConfig, reuseDrawablePool);
        if ((i & 4) != 0) {
            reuseDrawablePool = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReusableLatexMathPlugin(Context context, LatexConfig latexConfig, ReuseDrawablePool reuseDrawablePool) {
        super(context, latexConfig);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(latexConfig, "config");
        this.drawablePool = reuseDrawablePool;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.noties.markwon.ext.onetex.LatexMathPlugin
    public AsyncDrawableSpan createSpan(MarkwonTheme theme, String latex, boolean isBlock, LaTeXIcon texIcon, Integer order, Integer textColor, Float textSize) {
        Intrinsics.checkParameterIsNotNull(theme, "theme");
        Intrinsics.checkParameterIsNotNull(latex, "latex");
        return new LatexAsyncDrawableSpan(theme, obtainDrawable(latex, isBlock, texIcon, order, textColor, textSize));
    }

    private final LatexAsyncDrawable obtainDrawable(final String latex, final boolean isBlock, LaTeXIcon teX, final Integer texOrder, final Integer textColor, final Float textSize) {
        ReuseDrawablePool reuseDrawablePool = this.drawablePool;
        AsyncDrawable obtain = reuseDrawablePool != null ? reuseDrawablePool.obtain(new Function1<AsyncDrawable, Boolean>() { // from class: io.noties.markwon.ext.onetex.ReusableLatexMathPlugin$obtainDrawable$drawable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Boolean.valueOf(invoke((AsyncDrawable) obj));
            }

            public final boolean invoke(AsyncDrawable asyncDrawable) {
                Intrinsics.checkParameterIsNotNull(asyncDrawable, "it");
                if (asyncDrawable instanceof LatexAsyncDrawable) {
                    LatexAsyncDrawable latexAsyncDrawable = (LatexAsyncDrawable) asyncDrawable;
                    if (Intrinsics.areEqual(latexAsyncDrawable.getDestination(), latex) && latexAsyncDrawable.getImageSize() == null && latexAsyncDrawable.isBlock() == isBlock && Intrinsics.areEqual(latexAsyncDrawable.order, texOrder) && Intrinsics.areEqual(latexAsyncDrawable.textColor, textColor) && Intrinsics.areEqual(latexAsyncDrawable.textSize, textSize)) {
                        return true;
                    }
                }
                return false;
            }
        }) : null;
        if (obtain instanceof LatexAsyncDrawable) {
            return (LatexAsyncDrawable) obtain;
        }
        LatexAsyncDrawable latexAsyncDrawable = new LatexAsyncDrawable(latex, getLatexAsyncDrawableLoader(), isBlock ? getLatexBlockImageSizeResolver() : getInlineImageSizeResolver(), null, isBlock);
        latexAsyncDrawable.texIcon = teX;
        latexAsyncDrawable.order = texOrder;
        latexAsyncDrawable.textColor = textColor;
        latexAsyncDrawable.textSize = textSize;
        return latexAsyncDrawable;
    }
}
