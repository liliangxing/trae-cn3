package io.noties.markwon.ext.onetex;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.edu.onetex.latex.LaTeXParam;
import com.edu.onetex.latex.TexAlignment;
import com.edu.onetex.latex.TexSize;
import com.edu.onetex.latex.TextSplitStyle;
import com.edu.onetex.latex.icon.LaTeXIcon;
import com.edu.onetex.latex.icon.LaTeXIconBuilder;
import com.lynx.tasm.behavior.PropsConstants;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.ext.onetex.LaTexHelper;
import io.noties.markwon.ext.onetex.LatexConfig;
import io.noties.markwon.ext.onetex.LatexMathBlockParser;
import io.noties.markwon.ext.onetex.LatexMathBlockParserLegacy;
import io.noties.markwon.ext.onetex.LatexMathPlugin;
import io.noties.markwon.ext.onetex.LatexMathTheme;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableLoader;
import io.noties.markwon.image.AsyncDrawableScheduler;
import io.noties.markwon.image.AsyncDrawableSpan;
import io.noties.markwon.image.DrawableUtils;
import io.noties.markwon.inlineparser.MarkwonInlineParserPlugin;
import io.noties.markwon.onetex.LatexMathBlock;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* compiled from: LatexMathPlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020 H\u0014JM\u0010.\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010/\u001a\u00020\u001e2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0002\u00105J\u0018\u00106\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001072\u0006\u00108\u001a\u000209H\u0014J\u0010\u0010:\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006="}, d2 = {"Lio/noties/markwon/ext/onetex/LatexMathPlugin;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "context", "Landroid/content/Context;", "textSize", "", "(Landroid/content/Context;F)V", "config", "Lio/noties/markwon/ext/onetex/LatexConfig;", "(Landroid/content/Context;Lio/noties/markwon/ext/onetex/LatexConfig;)V", "inlineImageSizeResolver", "Lio/noties/markwon/ext/onetex/LatexInlineImageSizeResolver;", "getInlineImageSizeResolver", "()Lio/noties/markwon/ext/onetex/LatexInlineImageSizeResolver;", "latexAsyncDrawableLoader", "Lio/noties/markwon/ext/onetex/LatexMathPlugin$LatexLoader;", "getLatexAsyncDrawableLoader", "()Lio/noties/markwon/ext/onetex/LatexMathPlugin$LatexLoader;", "latexBlockImageSizeResolver", "Lio/noties/markwon/ext/onetex/LatexBlockImageSizeResolver;", "getLatexBlockImageSizeResolver", "()Lio/noties/markwon/ext/onetex/LatexBlockImageSizeResolver;", "afterSetText", "", "textView", "Landroid/widget/TextView;", "beforeSetText", "markdown", "Landroid/text/Spanned;", "commandSupportEnable", "", "latex", "", "configVisitorWithSplit", "builder", "Lio/noties/markwon/MarkwonVisitor$Builder;", "configure", "registry", "Lio/noties/markwon/MarkwonPlugin$Registry;", "configureParser", "Lorg/commonmark/parser/Parser$Builder;", "configureVisitor", "createFallbackSpan", "Lio/noties/markwon/image/AsyncDrawableSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "createSpan", "isBlock", "texIcon", "Lcom/edu/onetex/latex/icon/LaTeXIcon;", "order", "", "textColor", "(Lio/noties/markwon/core/MarkwonTheme;Ljava/lang/String;ZLcom/edu/onetex/latex/icon/LaTeXIcon;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)Lio/noties/markwon/image/AsyncDrawableSpan;", "getSplitTexIcons", "", "latexParam", "Lcom/edu/onetex/latex/LaTeXParam;", "prepareLatexTextPlaceholder", "Companion", "LatexLoader", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LatexMathPlugin extends AbstractMarkwonPlugin {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LatexConfig config;
    private final Context context;
    private final LatexInlineImageSizeResolver inlineImageSizeResolver;
    private final LatexLoader latexAsyncDrawableLoader;
    private final LatexBlockImageSizeResolver latexBlockImageSizeResolver;

    /* JADX INFO: Access modifiers changed from: protected */
    public AsyncDrawableSpan createFallbackSpan(MarkwonTheme theme, String latex) {
        Intrinsics.checkParameterIsNotNull(theme, "theme");
        Intrinsics.checkParameterIsNotNull(latex, "latex");
        return null;
    }

    public LatexMathPlugin(Context context, LatexConfig latexConfig) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(latexConfig, "config");
        this.context = context;
        this.config = latexConfig;
        this.latexAsyncDrawableLoader = new LatexLoader(latexConfig, context);
        this.latexBlockImageSizeResolver = new LatexBlockImageSizeResolver(latexConfig.getTheme().getBlockFitCanvas());
        this.inlineImageSizeResolver = new LatexInlineImageSizeResolver(latexConfig.getTheme().getBlockFitCanvas());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LatexMathPlugin(Context context, float f) {
        this(context, INSTANCE.builder(f).build());
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LatexLoader getLatexAsyncDrawableLoader() {
        return this.latexAsyncDrawableLoader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LatexBlockImageSizeResolver getLatexBlockImageSizeResolver() {
        return this.latexBlockImageSizeResolver;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LatexInlineImageSizeResolver getInlineImageSizeResolver() {
        return this.inlineImageSizeResolver;
    }

    public void configure(MarkwonPlugin.Registry registry) {
        Intrinsics.checkParameterIsNotNull(registry, "registry");
        LaTexHelper.INSTANCE.tryInit(this.context, new LaTexHelper.LatexInitConfig(this.config.getSupportNewCommand()));
        if (this.config.getInlinesEnabled()) {
            registry.require(MarkwonInlineParserPlugin.class).factoryBuilder().addInlineProcessor(new LatexMathInlineProcessor(this.config.getInlinesSingleDollarEnabled()));
        }
    }

    public void configureParser(Parser.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        if (this.config.getBlocksEnabled()) {
            if (this.config.getBlocksLegacy()) {
                builder.customBlockParserFactory(new LatexMathBlockParserLegacy.Factory());
            } else {
                builder.customBlockParserFactory(new LatexMathBlockParser.Factory());
            }
        }
    }

    public void configureVisitor(MarkwonVisitor.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        if (this.config.getIsDisableLatexSplit()) {
            if (this.config.getBlocksEnabled()) {
                builder.on(LatexMathBlock.class, new MarkwonVisitor.NodeVisitor<LatexMathBlock>() { // from class: io.noties.markwon.ext.onetex.LatexMathPlugin$configureVisitor$1
                    public final void visit(MarkwonVisitor markwonVisitor, LatexMathBlock latexMathBlock) {
                        LatexConfig latexConfig;
                        LatexConfig latexConfig2;
                        Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                        Intrinsics.checkParameterIsNotNull(latexMathBlock, "jLatexMathBlock");
                        Node node = (Node) latexMathBlock;
                        markwonVisitor.blockStart(node);
                        String latex = latexMathBlock.latex();
                        Intrinsics.checkExpressionValueIsNotNull(latex, "jLatexMathBlock.latex()");
                        int length = markwonVisitor.length();
                        markwonVisitor.builder().append(LatexMathPlugin.this.prepareLatexTextPlaceholder(latex));
                        LatexMathPlugin latexMathPlugin = LatexMathPlugin.this;
                        MarkwonTheme theme = markwonVisitor.configuration().theme();
                        Intrinsics.checkExpressionValueIsNotNull(theme, "visitor.configuration().theme()");
                        latexConfig = LatexMathPlugin.this.config;
                        Integer valueOf = Integer.valueOf(latexConfig.getTheme().getBlockTextColor());
                        latexConfig2 = LatexMathPlugin.this.config;
                        markwonVisitor.setSpans(length, latexMathPlugin.createSpan(theme, latex, true, null, null, valueOf, Float.valueOf(latexConfig2.getTheme().getBlockTextSize())));
                        markwonVisitor.blockEnd(node);
                    }
                });
            }
            if (this.config.getInlinesEnabled()) {
                builder.on(LatexMathNode.class, new MarkwonVisitor.NodeVisitor<LatexMathNode>() { // from class: io.noties.markwon.ext.onetex.LatexMathPlugin$configureVisitor$2
                    public final void visit(MarkwonVisitor markwonVisitor, LatexMathNode latexMathNode) {
                        LatexConfig latexConfig;
                        LatexConfig latexConfig2;
                        Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                        Intrinsics.checkParameterIsNotNull(latexMathNode, "jLatexMathNode");
                        String latex = latexMathNode.latex();
                        Intrinsics.checkExpressionValueIsNotNull(latex, "jLatexMathNode.latex()");
                        int length = markwonVisitor.length();
                        markwonVisitor.builder().append(LatexMathPlugin.this.prepareLatexTextPlaceholder(latex));
                        LatexMathPlugin latexMathPlugin = LatexMathPlugin.this;
                        MarkwonTheme theme = markwonVisitor.configuration().theme();
                        Intrinsics.checkExpressionValueIsNotNull(theme, "visitor.configuration().theme()");
                        latexConfig = LatexMathPlugin.this.config;
                        Integer valueOf = Integer.valueOf(latexConfig.getTheme().getInlineTextColor());
                        latexConfig2 = LatexMathPlugin.this.config;
                        markwonVisitor.setSpans(length, latexMathPlugin.createSpan(theme, latex, false, null, null, valueOf, Float.valueOf(latexConfig2.getTheme().getInlineTextSize())));
                    }
                });
                return;
            }
            return;
        }
        configVisitorWithSplit(builder);
    }

    private final void configVisitorWithSplit(MarkwonVisitor.Builder builder) {
        if (this.config.getBlocksEnabled()) {
            builder.on(LatexMathBlock.class, new MarkwonVisitor.NodeVisitor<LatexMathBlock>() { // from class: io.noties.markwon.ext.onetex.LatexMathPlugin$configVisitorWithSplit$1
                public final void visit(MarkwonVisitor markwonVisitor, LatexMathBlock latexMathBlock) {
                    LatexConfig latexConfig;
                    LatexConfig latexConfig2;
                    LatexConfig latexConfig3;
                    Context context;
                    LatexConfig latexConfig4;
                    boolean commandSupportEnable;
                    Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                    Intrinsics.checkParameterIsNotNull(latexMathBlock, "jLatexMathBlock");
                    Node node = (Node) latexMathBlock;
                    markwonVisitor.blockStart(node);
                    String latex = latexMathBlock.latex();
                    Intrinsics.checkExpressionValueIsNotNull(latex, "jLatexMathBlock.latex()");
                    latexConfig = LatexMathPlugin.this.config;
                    if (latexConfig.getLatexFallbackEnable()) {
                        commandSupportEnable = LatexMathPlugin.this.commandSupportEnable(latex);
                        if (!commandSupportEnable) {
                            int length = markwonVisitor.length();
                            markwonVisitor.builder().append(LatexMathPlugin.this.prepareLatexTextPlaceholder(latex));
                            LatexMathPlugin latexMathPlugin = LatexMathPlugin.this;
                            MarkwonTheme theme = markwonVisitor.configuration().theme();
                            Intrinsics.checkExpressionValueIsNotNull(theme, "visitor.configuration().theme()");
                            markwonVisitor.setSpans(length, latexMathPlugin.createFallbackSpan(theme, latex));
                            markwonVisitor.blockEnd(node);
                            return;
                        }
                    }
                    latexConfig2 = LatexMathPlugin.this.config;
                    float blockTextSize = latexConfig2.getTheme().getBlockTextSize();
                    latexConfig3 = LatexMathPlugin.this.config;
                    int blockTextColor = latexConfig3.getTheme().getBlockTextColor();
                    context = LatexMathPlugin.this.context;
                    Resources resources = context.getResources();
                    Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
                    List<LaTeXIcon> splitTexIcons = LatexMathPlugin.this.getSplitTexIcons(new LaTeXParam(latex, new TexSize(Float.MAX_VALUE, 0), new TexSize(blockTextSize, 0), resources.getDisplayMetrics().density, 0, 0.0d, (TexAlignment) null, blockTextColor != 0 ? blockTextColor : -16777216, 0, false, false, (TextSplitStyle) null, false, 8048, (DefaultConstructorMarker) null));
                    if (splitTexIcons == null) {
                        latexConfig4 = LatexMathPlugin.this.config;
                        if (latexConfig4.getLatexFallbackEnable()) {
                            int length2 = markwonVisitor.length();
                            markwonVisitor.builder().append(LatexMathPlugin.this.prepareLatexTextPlaceholder(latex));
                            LatexMathPlugin latexMathPlugin2 = LatexMathPlugin.this;
                            MarkwonTheme theme2 = markwonVisitor.configuration().theme();
                            Intrinsics.checkExpressionValueIsNotNull(theme2, "visitor.configuration().theme()");
                            markwonVisitor.setSpans(length2, latexMathPlugin2.createFallbackSpan(theme2, latex));
                            markwonVisitor.blockEnd(node);
                            return;
                        }
                        return;
                    }
                    int size = splitTexIcons.size();
                    for (int i = 0; i < size; i++) {
                        int length3 = markwonVisitor.length();
                        LatexMathPlugin latexMathPlugin3 = LatexMathPlugin.this;
                        MarkwonTheme theme3 = markwonVisitor.configuration().theme();
                        Intrinsics.checkExpressionValueIsNotNull(theme3, "visitor.configuration().theme()");
                        AsyncDrawableSpan createSpan = latexMathPlugin3.createSpan(theme3, latex, false, splitTexIcons.get(i), Integer.valueOf(i), Integer.valueOf(blockTextColor), Float.valueOf(blockTextSize));
                        markwonVisitor.builder().append(" ");
                        markwonVisitor.setSpans(length3, createSpan);
                    }
                    markwonVisitor.blockEnd(node);
                }
            });
        }
        if (this.config.getInlinesEnabled()) {
            builder.on(LatexMathNode.class, new MarkwonVisitor.NodeVisitor<LatexMathNode>() { // from class: io.noties.markwon.ext.onetex.LatexMathPlugin$configVisitorWithSplit$2
                public final void visit(MarkwonVisitor markwonVisitor, LatexMathNode latexMathNode) {
                    LatexConfig latexConfig;
                    LatexConfig latexConfig2;
                    Context context;
                    LatexConfig latexConfig3;
                    LatexConfig latexConfig4;
                    boolean commandSupportEnable;
                    Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                    Intrinsics.checkParameterIsNotNull(latexMathNode, "jLatexMathNode");
                    String latex = latexMathNode.latex();
                    Intrinsics.checkExpressionValueIsNotNull(latex, "jLatexMathNode.latex()");
                    latexConfig = LatexMathPlugin.this.config;
                    float inlineTextSize = latexConfig.getTheme().getInlineTextSize();
                    latexConfig2 = LatexMathPlugin.this.config;
                    int inlineTextColor = latexConfig2.getTheme().getInlineTextColor();
                    context = LatexMathPlugin.this.context;
                    Resources resources = context.getResources();
                    Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    latexConfig3 = LatexMathPlugin.this.config;
                    if (latexConfig3.getLatexFallbackEnable()) {
                        commandSupportEnable = LatexMathPlugin.this.commandSupportEnable(latex);
                        if (!commandSupportEnable) {
                            int length = markwonVisitor.length();
                            markwonVisitor.builder().append(LatexMathPlugin.this.prepareLatexTextPlaceholder(latex));
                            LatexMathPlugin latexMathPlugin = LatexMathPlugin.this;
                            MarkwonTheme theme = markwonVisitor.configuration().theme();
                            Intrinsics.checkExpressionValueIsNotNull(theme, "visitor.configuration().theme()");
                            markwonVisitor.setSpans(length, latexMathPlugin.createFallbackSpan(theme, latex));
                            return;
                        }
                    }
                    LaTeXParam laTeXParam = new LaTeXParam(latex, new TexSize(Float.MAX_VALUE, 0), new TexSize(inlineTextSize, 0), displayMetrics.density, 0, 0.0d, (TexAlignment) null, inlineTextColor != 0 ? inlineTextColor : -16777216, 0, false, false, (TextSplitStyle) null, false, 8048, (DefaultConstructorMarker) null);
                    long currentTimeMillis = System.currentTimeMillis();
                    List<LaTeXIcon> splitTexIcons = LatexMathPlugin.this.getSplitTexIcons(laTeXParam);
                    LaTexHelper.INSTANCE.onBuild(System.currentTimeMillis() - currentTimeMillis);
                    if (splitTexIcons == null) {
                        latexConfig4 = LatexMathPlugin.this.config;
                        if (latexConfig4.getLatexFallbackEnable()) {
                            int length2 = markwonVisitor.length();
                            markwonVisitor.builder().append(LatexMathPlugin.this.prepareLatexTextPlaceholder(latex));
                            LatexMathPlugin latexMathPlugin2 = LatexMathPlugin.this;
                            MarkwonTheme theme2 = markwonVisitor.configuration().theme();
                            Intrinsics.checkExpressionValueIsNotNull(theme2, "visitor.configuration().theme()");
                            markwonVisitor.setSpans(length2, latexMathPlugin2.createFallbackSpan(theme2, latex));
                            return;
                        }
                        return;
                    }
                    int size = splitTexIcons.size();
                    for (int i = 0; i < size; i++) {
                        int length3 = markwonVisitor.length();
                        LatexMathPlugin latexMathPlugin3 = LatexMathPlugin.this;
                        MarkwonTheme theme3 = markwonVisitor.configuration().theme();
                        Intrinsics.checkExpressionValueIsNotNull(theme3, "visitor.configuration().theme()");
                        AsyncDrawableSpan createSpan = latexMathPlugin3.createSpan(theme3, latex, false, splitTexIcons.get(i), Integer.valueOf(i), Integer.valueOf(inlineTextColor), Float.valueOf(inlineTextSize));
                        markwonVisitor.builder().append(" ");
                        markwonVisitor.setSpans(length3, createSpan);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<LaTeXIcon> getSplitTexIcons(LaTeXParam latexParam) {
        Intrinsics.checkParameterIsNotNull(latexParam, "latexParam");
        long currentTimeMillis = System.currentTimeMillis();
        LaTexHelper.INSTANCE.onParse(latexParam.getContent());
        LaTeXIcon build = new LaTeXIconBuilder(latexParam).build();
        List<LaTeXIcon> split = build != null ? build.split() : null;
        LaTexHelper.INSTANCE.onBuild(System.currentTimeMillis() - currentTimeMillis);
        return split;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String prepareLatexTextPlaceholder(String latex) {
        Intrinsics.checkParameterIsNotNull(latex, "latex");
        String replace$default = StringsKt.replace$default(latex, '\n', ' ', false, 4, (Object) null);
        int length = replace$default.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = replace$default.charAt(!z ? i : length) <= ' ';
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        return replace$default.subSequence(i, length + 1).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean commandSupportEnable(String latex) {
        List<String> unSupportLatexCommandList = this.config.getUnSupportLatexCommandList();
        if (unSupportLatexCommandList.isEmpty()) {
            return true;
        }
        Iterator<T> it = unSupportLatexCommandList.iterator();
        while (it.hasNext()) {
            if (StringsKt.contains$default(latex, (String) it.next(), false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AsyncDrawableSpan createSpan(MarkwonTheme theme, String latex, boolean isBlock, LaTeXIcon texIcon, Integer order, Integer textColor, Float textSize) {
        Intrinsics.checkParameterIsNotNull(theme, "theme");
        Intrinsics.checkParameterIsNotNull(latex, "latex");
        LatexAsyncDrawable latexAsyncDrawable = new LatexAsyncDrawable(latex, this.latexAsyncDrawableLoader, isBlock ? this.latexBlockImageSizeResolver : this.inlineImageSizeResolver, null, isBlock);
        latexAsyncDrawable.texIcon = texIcon;
        latexAsyncDrawable.order = order;
        return new LatexAsyncDrawableSpan(theme, latexAsyncDrawable);
    }

    public void beforeSetText(TextView textView, Spanned markdown) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        Intrinsics.checkParameterIsNotNull(markdown, "markdown");
        AsyncDrawableScheduler.unschedule(textView);
    }

    public void afterSetText(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        AsyncDrawableScheduler.schedule(textView);
    }

    /* compiled from: LatexMathPlugin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0014\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexMathPlugin$LatexLoader;", "Lio/noties/markwon/image/AsyncDrawableLoader;", "config", "Lio/noties/markwon/ext/onetex/LatexConfig;", "context", "Landroid/content/Context;", "(Lio/noties/markwon/ext/onetex/LatexConfig;Landroid/content/Context;)V", "handler", "Landroid/os/Handler;", "loading", "", "Lio/noties/markwon/image/AsyncDrawable;", "Ljava/util/concurrent/Future;", "cancel", "", "drawable", "load", PropsConstants.PLACEHOLDER, "Landroid/graphics/drawable/Drawable;", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    protected static class LatexLoader extends AsyncDrawableLoader {
        private final LatexConfig config;
        private final Context context;
        private final Handler handler;
        private final Map<AsyncDrawable, Future<?>> loading;

        public Drawable placeholder(AsyncDrawable drawable) {
            Intrinsics.checkParameterIsNotNull(drawable, "drawable");
            return null;
        }

        public LatexLoader(LatexConfig latexConfig, Context context) {
            Intrinsics.checkParameterIsNotNull(latexConfig, "config");
            Intrinsics.checkParameterIsNotNull(context, "context");
            this.config = latexConfig;
            this.context = context;
            this.handler = new Handler(Looper.getMainLooper());
            this.loading = new LinkedHashMap();
        }

        public void load(final AsyncDrawable drawable) {
            Intrinsics.checkParameterIsNotNull(drawable, "drawable");
            LatexAsyncDrawable latexAsyncDrawable = (LatexAsyncDrawable) (!(drawable instanceof LatexAsyncDrawable) ? null : drawable);
            final boolean z = true;
            if (latexAsyncDrawable != null && latexAsyncDrawable.isBlock()) {
                z = false;
            }
            Future<?> submit = this.config.getExecutorService().submit(new Runnable() { // from class: io.noties.markwon.ext.onetex.LatexMathPlugin$LatexLoader$load$task$1
                @Override // java.lang.Runnable
                public final void run() {
                    LatexConfig latexConfig;
                    Handler handler;
                    LatexConfig latexConfig2;
                    int blockTextColor;
                    LatexConfig latexConfig3;
                    final LatexMathTheme.BackgroundProvider blockBackgroundProvider;
                    LatexConfig latexConfig4;
                    final LatexMathTheme.Padding blockPadding;
                    LatexConfig latexConfig5;
                    float blockTextSize;
                    Context context;
                    final LaTeXIcon build;
                    Handler handler2;
                    LatexConfig latexConfig6;
                    LatexConfig latexConfig7;
                    LatexConfig latexConfig8;
                    LatexConfig latexConfig9;
                    final Drawable drawable2 = null;
                    try {
                        if (z) {
                            latexConfig9 = LatexMathPlugin.LatexLoader.this.config;
                            blockTextColor = latexConfig9.getTheme().getInlineTextColor();
                        } else {
                            latexConfig2 = LatexMathPlugin.LatexLoader.this.config;
                            blockTextColor = latexConfig2.getTheme().getBlockTextColor();
                        }
                        if (z) {
                            latexConfig8 = LatexMathPlugin.LatexLoader.this.config;
                            blockBackgroundProvider = latexConfig8.getTheme().getInlineBackgroundProvider();
                        } else {
                            latexConfig3 = LatexMathPlugin.LatexLoader.this.config;
                            blockBackgroundProvider = latexConfig3.getTheme().getBlockBackgroundProvider();
                        }
                        if (z) {
                            latexConfig7 = LatexMathPlugin.LatexLoader.this.config;
                            blockPadding = latexConfig7.getTheme().getInlinePadding();
                        } else {
                            latexConfig4 = LatexMathPlugin.LatexLoader.this.config;
                            blockPadding = latexConfig4.getTheme().getBlockPadding();
                        }
                        if (z) {
                            latexConfig6 = LatexMathPlugin.LatexLoader.this.config;
                            blockTextSize = latexConfig6.getTheme().getInlineTextSize();
                        } else {
                            latexConfig5 = LatexMathPlugin.LatexLoader.this.config;
                            blockTextSize = latexConfig5.getTheme().getBlockTextSize();
                        }
                        context = LatexMathPlugin.LatexLoader.this.context;
                        Resources resources = context.getResources();
                        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
                        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                        String destination = drawable.getDestination();
                        Intrinsics.checkExpressionValueIsNotNull(destination, "drawable.destination");
                        TexSize texSize = new TexSize(Float.MAX_VALUE, 0);
                        TexSize texSize2 = new TexSize(blockTextSize, 0);
                        if (blockTextColor == 0) {
                            blockTextColor = -16777216;
                        }
                        LaTeXParam laTeXParam = new LaTeXParam(destination, texSize, texSize2, displayMetrics.density, 0, 0.0d, (TexAlignment) null, blockTextColor, 0, false, false, (TextSplitStyle) null, false, 8048, (DefaultConstructorMarker) null);
                        long currentTimeMillis = System.currentTimeMillis();
                        AsyncDrawable asyncDrawable = drawable;
                        if (!(asyncDrawable instanceof LatexAsyncDrawable)) {
                            asyncDrawable = null;
                        }
                        LatexAsyncDrawable latexAsyncDrawable2 = (LatexAsyncDrawable) asyncDrawable;
                        if (latexAsyncDrawable2 == null || (build = latexAsyncDrawable2.texIcon) == null) {
                            build = new LaTeXIconBuilder(laTeXParam).build();
                            LaTexHelper.INSTANCE.onParse(laTeXParam.getContent());
                            LaTexHelper.INSTANCE.onBuild(System.currentTimeMillis() - currentTimeMillis);
                        }
                        if (build != null) {
                            handler2 = LatexMathPlugin.LatexLoader.this.handler;
                            handler2.post(new Runnable() { // from class: io.noties.markwon.ext.onetex.LatexMathPlugin$LatexLoader$load$task$1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Context context2;
                                    LatexConfig latexConfig10;
                                    LatexConfig latexConfig11;
                                    LatexConfig latexConfig12;
                                    LatexConfig latexConfig13;
                                    Map map;
                                    Integer num;
                                    context2 = LatexMathPlugin.LatexLoader.this.context;
                                    AsyncDrawable asyncDrawable2 = drawable;
                                    if (!(asyncDrawable2 instanceof LatexAsyncDrawable)) {
                                        asyncDrawable2 = null;
                                    }
                                    LatexAsyncDrawable latexAsyncDrawable3 = (LatexAsyncDrawable) asyncDrawable2;
                                    int intValue = (latexAsyncDrawable3 == null || (num = latexAsyncDrawable3.order) == null) ? 0 : num.intValue();
                                    LatexMathTheme.BackgroundProvider backgroundProvider = blockBackgroundProvider;
                                    Drawable provide = backgroundProvider != null ? backgroundProvider.provide() : null;
                                    LatexMathTheme.Padding padding = blockPadding;
                                    latexConfig10 = LatexMathPlugin.LatexLoader.this.config;
                                    int blockHorizontalAlignment = latexConfig10.getTheme().getBlockHorizontalAlignment();
                                    LaTeXIcon laTeXIcon = build;
                                    latexConfig11 = LatexMathPlugin.LatexLoader.this.config;
                                    int latexMaxWidth = latexConfig11.getLatexMaxWidth();
                                    latexConfig12 = LatexMathPlugin.LatexLoader.this.config;
                                    boolean useLatexBitmapCache = latexConfig12.getUseLatexBitmapCache();
                                    latexConfig13 = LatexMathPlugin.LatexLoader.this.config;
                                    LatexDrawable latexDrawable = new LatexDrawable(context2, intValue, provide, padding, blockHorizontalAlignment, laTeXIcon, latexMaxWidth, useLatexBitmapCache, latexConfig13.getLatexBitmapCacheSize());
                                    DrawableUtils.applyIntrinsicBoundsIfEmpty(latexDrawable);
                                    drawable.setResult(latexDrawable);
                                    map = LatexMathPlugin.LatexLoader.this.loading;
                                    map.remove(drawable);
                                }
                            });
                        }
                    } catch (Throwable th) {
                        latexConfig = LatexMathPlugin.LatexLoader.this.config;
                        LatexConfig.ErrorHandler errorHandler = latexConfig.getErrorHandler();
                        if (errorHandler != null) {
                            String destination2 = drawable.getDestination();
                            Intrinsics.checkExpressionValueIsNotNull(destination2, "drawable.destination");
                            drawable2 = errorHandler.handleError(destination2, th);
                        }
                        if (drawable2 != null) {
                            handler = LatexMathPlugin.LatexLoader.this.handler;
                            handler.post(new Runnable() { // from class: io.noties.markwon.ext.onetex.LatexMathPlugin$LatexLoader$load$task$1.2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Map map;
                                    DrawableUtils.applyIntrinsicBoundsIfEmpty(drawable2);
                                    drawable.setErrorResult(drawable2);
                                    map = LatexMathPlugin.LatexLoader.this.loading;
                                    map.remove(drawable);
                                }
                            });
                        }
                    }
                }
            });
            Map<AsyncDrawable, Future<?>> map = this.loading;
            Intrinsics.checkExpressionValueIsNotNull(submit, "task");
            map.put(drawable, submit);
        }

        public void cancel(AsyncDrawable drawable) {
            Intrinsics.checkParameterIsNotNull(drawable, "drawable");
            Future<?> remove = this.loading.remove(drawable);
            if (remove != null) {
                remove.cancel(true);
            }
        }
    }

    /* compiled from: LatexMathPlugin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexMathPlugin$Companion;", "", "()V", "builder", "Lio/noties/markwon/ext/onetex/LatexConfig$Builder;", "textSize", "", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LatexConfig.Builder builder(float textSize) {
            return new LatexConfig.Builder(LatexMathTheme.INSTANCE.builder(textSize).build());
        }
    }
}
