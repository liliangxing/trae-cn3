package io.noties.markwon.ext.onetex;

import android.app.Application;
import android.content.Context;
import android.text.Spanned;
import android.widget.TextView;
import com.edu.onetex.latex.LaTeXParam;
import com.edu.onetex.latex.icon.LaTeXIcon;
import com.edu.onetex.latex.icon.LaTeXIconBuilder;
import com.larus.business.markdown.api.common.FlowMarkdownReuseDrawablePool;
import com.larus.business.markdown.api.common.ReuseDrawablePoolNew;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManager;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManagerKt;
import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.depend.OnLatexUrlCallBack;
import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.ext.onetex.LaTexHelper;
import io.noties.markwon.ext.onetex.LatexMathBlockParser2;
import io.noties.markwon.ext.onetex.NewLatexMathBlockParser;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableSpan;
import io.noties.markwon.inlineparser.BackslashInlineProcessor;
import io.noties.markwon.inlineparser.MarkwonInlineParser;
import io.noties.markwon.inlineparser.MarkwonInlineParserPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* compiled from: ReusableLatexMathPlugin2.kt */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JB\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012:\b\u0002\u0010\f\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\r\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\"\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0016J\u001a\u0010(\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010(\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u000200H\u0016J\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u000eH\u0014JM\u00106\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u00162\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010\u00072\b\u0010;\u001a\u0004\u0018\u00010\u00072\b\u0010<\u001a\u0004\u0018\u00010=H\u0014¢\u0006\u0002\u0010>J\u0018\u0010?\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010@2\u0006\u0010A\u001a\u00020BH\u0014JE\u0010C\u001a\u00020D2\u0006\u00105\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u00162\b\u0010E\u001a\u0004\u0018\u0001092\b\u0010F\u001a\u0004\u0018\u00010\u00072\b\u0010;\u001a\u0004\u0018\u00010\u00072\b\u0010<\u001a\u0004\u0018\u00010=H\u0002¢\u0006\u0002\u0010GJ\u0012\u0010H\u001a\u00020\u00142\b\u0010I\u001a\u0004\u0018\u00010 H\u0002R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lio/noties/markwon/ext/onetex/ReusableLatexMathPlugin2;", "Lio/noties/markwon/ext/onetex/LatexMathPlugin;", "context", "Landroid/content/Context;", "config", "Lio/noties/markwon/ext/onetex/LatexConfig;", "markdownLatexPatternStrategy", "", "drawablePool", "Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "drawableLruPool", "Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawablePool;", "latexFallbackAbility", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "url", "Lcom/larus/business/markdown/api/depend/OnLatexUrlCallBack;", "callback", "", "texIconReuseEnable", "", "clearCachePoolAfterRender", "(Landroid/content/Context;Lio/noties/markwon/ext/onetex/LatexConfig;ILcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawablePool;Lkotlin/jvm/functions/Function2;ZZ)V", "latexFallbackLoader", "Lio/noties/markwon/ext/onetex/LatexFallbackLoader;", "addNewLatexInlineProcessor", "builder", "Lio/noties/markwon/inlineparser/MarkwonInlineParser$FactoryBuilder;", "afterRender", "reuseCharSequence", "", "node", "Lorg/commonmark/node/Node;", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "afterSetText", "textView", "Landroid/widget/TextView;", "beforeRender", "beforeSetText", "markdown", "Landroid/text/Spanned;", "configure", "registry", "Lio/noties/markwon/MarkwonPlugin$Registry;", "configureParser", "Lorg/commonmark/parser/Parser$Builder;", "createFallbackSpan", "Lio/noties/markwon/image/AsyncDrawableSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "latex", "createSpan", "isBlock", "texIcon", "Lcom/edu/onetex/latex/icon/LaTeXIcon;", "order", "textColor", "textSize", "", "(Lio/noties/markwon/core/MarkwonTheme;Ljava/lang/String;ZLcom/edu/onetex/latex/icon/LaTeXIcon;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)Lio/noties/markwon/image/AsyncDrawableSpan;", "getSplitTexIcons", "", "latexParam", "Lcom/edu/onetex/latex/LaTeXParam;", "obtainDrawable", "Lio/noties/markwon/ext/onetex/LatexAsyncDrawable;", "teX", "texOrder", "(Ljava/lang/String;ZLcom/edu/onetex/latex/icon/LaTeXIcon;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)Lio/noties/markwon/ext/onetex/LatexAsyncDrawable;", "recycleSpans", "cs", "Companion", "markdown-latex_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class ReusableLatexMathPlugin2 extends LatexMathPlugin {
    private static final String TAG = "ReusableLatexMathPlugin2";
    private static final ReuseTexIconPool pool = new ReuseTexIconPool();
    private final boolean clearCachePoolAfterRender;
    private LatexConfig config;
    private Context context;
    private final FlowMarkdownReuseDrawablePool drawableLruPool;
    private ReuseDrawablePoolNew drawablePool;
    private final Function2<String, OnLatexUrlCallBack, Unit> latexFallbackAbility;
    private final LatexFallbackLoader latexFallbackLoader;
    private int markdownLatexPatternStrategy;
    private final boolean texIconReuseEnable;

    public /* synthetic */ ReusableLatexMathPlugin2(Context context, LatexConfig latexConfig, int i, ReuseDrawablePoolNew reuseDrawablePoolNew, FlowMarkdownReuseDrawablePool flowMarkdownReuseDrawablePool, Function2 function2, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, latexConfig, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? null : reuseDrawablePoolNew, (i2 & 16) != 0 ? null : flowMarkdownReuseDrawablePool, (i2 & 32) != 0 ? null : function2, z, z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReusableLatexMathPlugin2(Context context, LatexConfig latexConfig, int i, ReuseDrawablePoolNew reuseDrawablePoolNew, FlowMarkdownReuseDrawablePool flowMarkdownReuseDrawablePool, Function2<? super String, ? super OnLatexUrlCallBack, Unit> function2, boolean z, boolean z2) {
        super(context, latexConfig);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(latexConfig, "config");
        this.context = context;
        this.config = latexConfig;
        this.markdownLatexPatternStrategy = i;
        this.drawablePool = reuseDrawablePoolNew;
        this.drawableLruPool = flowMarkdownReuseDrawablePool;
        this.latexFallbackAbility = function2;
        this.texIconReuseEnable = z;
        this.clearCachePoolAfterRender = z2;
        LatexFallbackLoader latexFallbackLoader = new LatexFallbackLoader(this.context);
        latexFallbackLoader.setBitmapAccessAbility(function2);
        this.latexFallbackLoader = latexFallbackLoader;
    }

    public void beforeRender(TextView textView, Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        recycleSpans(textView != null ? textView.getText() : null);
    }

    public void beforeRender(CharSequence reuseCharSequence, Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        recycleSpans(reuseCharSequence);
    }

    public void afterRender(Node node, MarkwonVisitor visitor) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        if (this.clearCachePoolAfterRender) {
            pool.clear();
        }
    }

    public void afterRender(CharSequence reuseCharSequence, Node node, MarkwonVisitor visitor) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        if (this.clearCachePoolAfterRender) {
            pool.clear();
        }
    }

    private final void recycleSpans(CharSequence cs) {
        Object obj;
        IMarkdownLogger markdownLoggerDelegate;
        try {
            Result.Companion companion = Result.Companion;
            Unit unit = null;
            Spanned spanned = cs instanceof Spanned ? (Spanned) cs : null;
            if (spanned != null) {
                LatexAsyncDrawableSpan[] latexAsyncDrawableSpanArr = (LatexAsyncDrawableSpan[]) spanned.getSpans(0, ((Spanned) cs).length(), LatexAsyncDrawableSpan.class);
                if (latexAsyncDrawableSpanArr != null) {
                    for (LatexAsyncDrawableSpan latexAsyncDrawableSpan : latexAsyncDrawableSpanArr) {
                        LatexAsyncDrawable drawable = latexAsyncDrawableSpan.drawable();
                        Intrinsics.checkNotNullExpressionValue(drawable, "span.drawable()");
                        pool.recycle(drawable.getDestination(), drawable.order, drawable.texIcon);
                    }
                    unit = Unit.INSTANCE;
                }
            }
            obj = Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 == null || (markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate()) == null) {
            return;
        }
        markdownLoggerDelegate.e(TAG, "crash, throwable:" + th2.getCause() + " message:" + th2.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.noties.markwon.ext.onetex.LatexMathPlugin
    public List<LaTeXIcon> getSplitTexIcons(final LaTeXParam latexParam) {
        Intrinsics.checkNotNullParameter(latexParam, "latexParam");
        Function0<List<? extends LaTeXIcon>> function0 = new Function0<List<? extends LaTeXIcon>>() { // from class: io.noties.markwon.ext.onetex.ReusableLatexMathPlugin2$getSplitTexIcons$createTexIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final List<LaTeXIcon> invoke() {
                LatexConfig latexConfig;
                LatexConfig latexConfig2;
                LaTeXIcon build = new LaTeXIconBuilder(latexParam).build();
                if (build == null) {
                    return null;
                }
                latexConfig = this.config;
                if (latexConfig.getLatexSplitOptimize()) {
                    int width = build.getWidth();
                    latexConfig2 = this.config;
                    if (width <= latexConfig2.getLatexMaxWidth()) {
                        return CollectionsKt.listOf(build);
                    }
                }
                return build.split();
            }
        };
        if (!this.texIconReuseEnable) {
            return (List) function0.invoke();
        }
        List<LaTeXIcon> obtain = pool.obtain(this.context, latexParam.getContent());
        List<LaTeXIcon> list = obtain;
        return list == null || list.isEmpty() ? (List) function0.invoke() : obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.noties.markwon.ext.onetex.LatexMathPlugin
    public AsyncDrawableSpan createSpan(MarkwonTheme theme, String latex, boolean isBlock, LaTeXIcon texIcon, Integer order, Integer textColor, Float textSize) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(latex, "latex");
        return new LatexAsyncDrawableSpan(theme, obtainDrawable(latex, isBlock, texIcon, order, textColor, textSize));
    }

    private final LatexAsyncDrawable obtainDrawable(final String latex, final boolean isBlock, LaTeXIcon teX, final Integer texOrder, final Integer textColor, final Float textSize) {
        AsyncDrawable obtain;
        ReuseDrawablePoolNew reuseDrawablePoolNew = this.drawablePool;
        AsyncDrawable obtain2 = reuseDrawablePoolNew != null ? reuseDrawablePoolNew.obtain(this.context, new Function1<AsyncDrawable, Boolean>() { // from class: io.noties.markwon.ext.onetex.ReusableLatexMathPlugin2$obtainDrawable$drawable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Boolean invoke(AsyncDrawable asyncDrawable) {
                boolean z;
                Intrinsics.checkNotNullParameter(asyncDrawable, "it");
                if (asyncDrawable instanceof LatexAsyncDrawable) {
                    LatexAsyncDrawable latexAsyncDrawable = (LatexAsyncDrawable) asyncDrawable;
                    if (Intrinsics.areEqual(latexAsyncDrawable.getDestination(), latex) && latexAsyncDrawable.getImageSize() == null && latexAsyncDrawable.isBlock() == isBlock && Intrinsics.areEqual(latexAsyncDrawable.order, texOrder) && Intrinsics.areEqual(latexAsyncDrawable.textColor, textColor) && Intrinsics.areEqual(latexAsyncDrawable.textSize, textSize)) {
                        z = true;
                        return Boolean.valueOf(z);
                    }
                }
                z = false;
                return Boolean.valueOf(z);
            }
        }) : null;
        LatexAsyncDrawable latexAsyncDrawable = obtain2 instanceof LatexAsyncDrawable ? (LatexAsyncDrawable) obtain2 : null;
        if (latexAsyncDrawable != null) {
            return latexAsyncDrawable;
        }
        FlowMarkdownReuseDrawablePool flowMarkdownReuseDrawablePool = this.drawableLruPool;
        if (flowMarkdownReuseDrawablePool != null && (obtain = flowMarkdownReuseDrawablePool.obtain(this.context, latex, texOrder)) != null) {
            if (obtain instanceof LatexAsyncDrawable) {
                LatexAsyncDrawable latexAsyncDrawable2 = (LatexAsyncDrawable) obtain;
                if (Intrinsics.areEqual(latexAsyncDrawable2.getDestination(), latex) && latexAsyncDrawable2.getImageSize() == null && latexAsyncDrawable2.isBlock() == isBlock && Intrinsics.areEqual(latexAsyncDrawable2.order, texOrder) && Intrinsics.areEqual(latexAsyncDrawable2.textColor, textColor) && Intrinsics.areEqual(latexAsyncDrawable2.textSize, textSize) && obtain.hasResult()) {
                    IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
                    if (markdownLoggerDelegate != null) {
                        markdownLoggerDelegate.d(TAG, "can find LatexAsyncDrawable " + latexAsyncDrawable2.getDestination());
                    }
                    return latexAsyncDrawable2;
                }
            }
            LatexAsyncDrawable latexAsyncDrawable3 = new LatexAsyncDrawable(latex, getLatexAsyncDrawableLoader(), isBlock ? getLatexBlockImageSizeResolver() : getInlineImageSizeResolver(), null, isBlock);
            latexAsyncDrawable3.texIcon = teX;
            latexAsyncDrawable3.order = texOrder;
            latexAsyncDrawable3.textColor = textColor;
            latexAsyncDrawable3.textSize = textSize;
            IMarkdownLogger markdownLoggerDelegate2 = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
            if (markdownLoggerDelegate2 != null) {
                markdownLoggerDelegate2.d(TAG, "can not find .. recycle " + latexAsyncDrawable3.getDestination());
            }
            if (!(this.context instanceof Application)) {
                ReuseDrawablePoolNew reuseDrawablePoolNew2 = this.drawablePool;
                if (reuseDrawablePoolNew2 != null) {
                    reuseDrawablePoolNew2.recycle(latexAsyncDrawable3);
                }
                this.drawableLruPool.recycle(latexAsyncDrawable3, texOrder);
            }
            return latexAsyncDrawable3;
        }
        LatexAsyncDrawable latexAsyncDrawable4 = new LatexAsyncDrawable(latex, getLatexAsyncDrawableLoader(), isBlock ? getLatexBlockImageSizeResolver() : getInlineImageSizeResolver(), null, isBlock);
        latexAsyncDrawable4.texIcon = teX;
        latexAsyncDrawable4.order = texOrder;
        latexAsyncDrawable4.textColor = textColor;
        latexAsyncDrawable4.textSize = textSize;
        IMarkdownLogger markdownLoggerDelegate3 = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
        if (markdownLoggerDelegate3 != null) {
            markdownLoggerDelegate3.d(TAG, "can not find ... " + latexAsyncDrawable4.getDestination());
        }
        if (!(this.context instanceof Application)) {
            ReuseDrawablePoolNew reuseDrawablePoolNew3 = this.drawablePool;
            if (reuseDrawablePoolNew3 != null) {
                reuseDrawablePoolNew3.recycle(latexAsyncDrawable4);
            }
            FlowMarkdownReuseDrawablePool flowMarkdownReuseDrawablePool2 = this.drawableLruPool;
            if (flowMarkdownReuseDrawablePool2 != null) {
                flowMarkdownReuseDrawablePool2.recycle(latexAsyncDrawable4, texOrder);
            }
        }
        return latexAsyncDrawable4;
    }

    @Override // io.noties.markwon.ext.onetex.LatexMathPlugin
    public void configureParser(Parser.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (this.config.getBlocksEnabled()) {
            int i = this.markdownLatexPatternStrategy;
            if (i == 1) {
                builder.customBlockParserFactory(new LatexMathBlockParser2.Factory());
                return;
            }
            if (i == 2) {
                builder.customBlockParserFactory(new NewLatexMathBlockParser.Factory());
            } else if (i != 3) {
                builder.customBlockParserFactory(new LatexMathBlockParser2.Factory());
                builder.customBlockParserFactory(new NewLatexMathBlockParser.Factory());
            }
        }
    }

    @Override // io.noties.markwon.ext.onetex.LatexMathPlugin
    public void configure(MarkwonPlugin.Registry registry) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        LaTexHelper.INSTANCE.tryInit(this.context, new LaTexHelper.LatexInitConfig(this.config.getSupportNewCommand()));
        if (this.config.getInlinesEnabled()) {
            MarkwonInlineParser.FactoryBuilder factoryBuilder = registry.require(MarkwonInlineParserPlugin.class).factoryBuilder();
            int i = this.markdownLatexPatternStrategy;
            if (i == 1) {
                factoryBuilder.addInlineProcessor(new LatexMathInlineProcessor2(this.config.getInlinesSingleDollarEnabled(), this.config.getCustomizedLatexPattern()));
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNullExpressionValue(factoryBuilder, "this");
                addNewLatexInlineProcessor(factoryBuilder);
            } else if (i != 3) {
                factoryBuilder.addInlineProcessor(new LatexMathInlineProcessor2(this.config.getInlinesSingleDollarEnabled(), this.config.getCustomizedLatexPattern()));
                Intrinsics.checkNotNullExpressionValue(factoryBuilder, "this");
                addNewLatexInlineProcessor(factoryBuilder);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.noties.markwon.ext.onetex.LatexMathPlugin
    public AsyncDrawableSpan createFallbackSpan(MarkwonTheme theme, final String latex) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(latex, "latex");
        ReuseDrawablePoolNew reuseDrawablePoolNew = this.drawablePool;
        AsyncDrawable obtain = reuseDrawablePoolNew != null ? reuseDrawablePoolNew.obtain(this.context, new Function1<AsyncDrawable, Boolean>() { // from class: io.noties.markwon.ext.onetex.ReusableLatexMathPlugin2$createFallbackSpan$drawable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Boolean invoke(AsyncDrawable asyncDrawable) {
                Intrinsics.checkNotNullParameter(asyncDrawable, "it");
                return Boolean.valueOf(Intrinsics.areEqual(asyncDrawable.getDestination(), latex) && Intrinsics.areEqual(asyncDrawable.getClass(), LatexFallbackAsyncDrawable.class));
            }
        }) : null;
        LatexFallbackAsyncDrawable latexFallbackAsyncDrawable = obtain instanceof LatexFallbackAsyncDrawable ? (LatexFallbackAsyncDrawable) obtain : null;
        if (latexFallbackAsyncDrawable == null) {
            latexFallbackAsyncDrawable = new LatexFallbackAsyncDrawable(latex, this.latexFallbackLoader, getInlineImageSizeResolver(), null);
        }
        return new LatexFallbackAsyncDrawableSpan(theme, latexFallbackAsyncDrawable, 2);
    }

    private final void addNewLatexInlineProcessor(MarkwonInlineParser.FactoryBuilder builder) {
        builder.excludeInlineProcessor(BackslashInlineProcessor.class);
        builder.addInlineProcessor(new NewLatexMathInlineProcessor());
        builder.addInlineProcessor(new BackslashInlineProcessor());
    }

    @Override // io.noties.markwon.ext.onetex.LatexMathPlugin
    public void beforeSetText(TextView textView, Spanned markdown) {
        Object obj;
        IMarkdownEnsureManager markdownEnsureManagerDelegate;
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        try {
            Result.Companion companion = Result.Companion;
            super.beforeSetText(textView, markdown);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 == null || (markdownEnsureManagerDelegate = IMarkdownEnsureManagerKt.getMarkdownEnsureManagerDelegate()) == null) {
            return;
        }
        markdownEnsureManagerDelegate.ensureNotReachHere(th2, "ReusableLatexMathPlugin2 beforeSetText");
    }

    @Override // io.noties.markwon.ext.onetex.LatexMathPlugin
    public void afterSetText(TextView textView) {
        Object obj;
        IMarkdownEnsureManager markdownEnsureManagerDelegate;
        Intrinsics.checkNotNullParameter(textView, "textView");
        try {
            Result.Companion companion = Result.Companion;
            super.afterSetText(textView);
            if (!this.clearCachePoolAfterRender) {
                pool.clear();
            }
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 == null || (markdownEnsureManagerDelegate = IMarkdownEnsureManagerKt.getMarkdownEnsureManagerDelegate()) == null) {
            return;
        }
        markdownEnsureManagerDelegate.ensureNotReachHere(th2, "ReusableLatexMathPlugin2 afterSetText");
    }
}
