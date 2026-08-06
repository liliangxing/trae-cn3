package com.larus.bussiness.markdown.latex;

import android.content.Context;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.edu.onetex.latex.LaTeXEngine;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.larus.business.markdown.api.common.FlowMarkdownReuseDrawablePool;
import com.larus.business.markdown.api.common.ReuseDrawablePoolNew;
import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.extplugin.latex.ILatexPlugin;
import com.larus.business.markdown.api.extplugin.latex.IOnLatexParseErrorListener;
import com.larus.business.markdown.api.model.latex.LatexGlobalConfig;
import com.larus.business.markdown.api.model.latex.LatexSingleConfig;
import com.larus.bussiness.markdown.latex.LatexPluginImpl$internalOnParseErrorListener$2;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.ext.onetex.LaTexHelper;
import io.noties.markwon.ext.onetex.LatexCallback;
import io.noties.markwon.ext.onetex.LatexConfig;
import io.noties.markwon.ext.onetex.LatexMathTheme;
import io.noties.markwon.ext.onetex.ReusableLatexMathPlugin2;
import io.noties.markwon.onetex.LatexMathBlock;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;

/* compiled from: LatexPluginImpl.kt */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0004\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u001c\u0010\u0012\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u0013H\u0016J@\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u001a\u0010'\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0016H\u0016J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\r¨\u0006-"}, d2 = {"Lcom/larus/bussiness/markdown/latex/LatexPluginImpl;", "Lcom/larus/business/markdown/api/extplugin/latex/ILatexPlugin;", "()V", "internalOnParseErrorListener", "com/larus/bussiness/markdown/latex/LatexPluginImpl$internalOnParseErrorListener$2$1", "getInternalOnParseErrorListener", "()Lcom/larus/bussiness/markdown/latex/LatexPluginImpl$internalOnParseErrorListener$2$1;", "internalOnParseErrorListener$delegate", "Lkotlin/Lazy;", "onParseErrorListeners", "", "Lcom/larus/business/markdown/api/extplugin/latex/IOnLatexParseErrorListener;", "getOnParseErrorListeners", "()Ljava/util/List;", "onParseErrorListeners$delegate", "addOnParseErrorListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getNodeReportMap", "", "Ljava/lang/Class;", "Lorg/commonmark/node/Node;", "", "getPlugin", "Lio/noties/markwon/AbstractMarkwonPlugin;", "context", "Landroid/content/Context;", "latexGlobalConfig", "Lcom/larus/business/markdown/api/model/latex/LatexGlobalConfig;", "latexSingleConfig", "Lcom/larus/business/markdown/api/model/latex/LatexSingleConfig;", "latexMaxWidth", "", "drawablePool", "Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "drawableLruPool", "Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawablePool;", "clearDrawablePoolAfterRender", "", ReportUtil.Event.EVENT_INIT, "modifyLatexMathBlockContent", "node", "latex", "removeOnParseErrorListener", "Companion", "markdown-latex_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class LatexPluginImpl implements ILatexPlugin {
    public static final String TAG = "LatexPlugin-impl";

    /* renamed from: internalOnParseErrorListener$delegate, reason: from kotlin metadata */
    private final Lazy internalOnParseErrorListener = LazyKt.lazy(new Function0<LatexPluginImpl$internalOnParseErrorListener$2.C13331>() { // from class: com.larus.bussiness.markdown.latex.LatexPluginImpl$internalOnParseErrorListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.bussiness.markdown.latex.LatexPluginImpl$internalOnParseErrorListener$2$1] */
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final C13331 m2903invoke() {
            final LatexPluginImpl latexPluginImpl = LatexPluginImpl.this;
            return new LaTeXEngine.OnParseErrorListener() { // from class: com.larus.bussiness.markdown.latex.LatexPluginImpl$internalOnParseErrorListener$2.1
                @Override // com.edu.onetex.latex.LaTeXEngine.OnParseErrorListener
                public void onParseError(String parseContent, String errorMsg, int errorCode) {
                    List onParseErrorListeners;
                    List onParseErrorListeners2;
                    List list;
                    Intrinsics.checkNotNullParameter(parseContent, "parseContent");
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    onParseErrorListeners = LatexPluginImpl.this.getOnParseErrorListeners();
                    LatexPluginImpl latexPluginImpl2 = LatexPluginImpl.this;
                    synchronized (onParseErrorListeners) {
                        onParseErrorListeners2 = latexPluginImpl2.getOnParseErrorListeners();
                        list = CollectionsKt.toList(onParseErrorListeners2);
                    }
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((IOnLatexParseErrorListener) it.next()).onParseError(parseContent, errorMsg, errorCode);
                    }
                }
            };
        }
    });

    /* renamed from: onParseErrorListeners$delegate, reason: from kotlin metadata */
    private final Lazy onParseErrorListeners = LazyKt.lazy(new Function0<List<IOnLatexParseErrorListener>>() { // from class: com.larus.bussiness.markdown.latex.LatexPluginImpl$onParseErrorListeners$2
        public final List<IOnLatexParseErrorListener> invoke() {
            return new ArrayList();
        }
    });

    private final LatexPluginImpl$internalOnParseErrorListener$2.C13331 getInternalOnParseErrorListener() {
        return (LatexPluginImpl$internalOnParseErrorListener$2.C13331) this.internalOnParseErrorListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<IOnLatexParseErrorListener> getOnParseErrorListeners() {
        return (List) this.onParseErrorListeners.getValue();
    }

    @Override // com.larus.business.markdown.api.extplugin.latex.ILatexPlugin
    public AbstractMarkwonPlugin getPlugin(Context context, LatexGlobalConfig latexGlobalConfig, LatexSingleConfig latexSingleConfig, int latexMaxWidth, ReuseDrawablePoolNew drawablePool, FlowMarkdownReuseDrawablePool drawableLruPool, boolean clearDrawablePoolAfterRender) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(latexGlobalConfig, "latexGlobalConfig");
        Intrinsics.checkNotNullParameter(latexSingleConfig, "latexSingleConfig");
        Intrinsics.checkNotNullParameter(drawablePool, "drawablePool");
        Intrinsics.checkNotNullParameter(drawableLruPool, "drawableLruPool");
        return new ReusableLatexMathPlugin2(context, new LatexConfig.Builder(LatexMathTheme.Companion.builder(latexSingleConfig.getLatexTextSize()).textColor(latexSingleConfig.getLatexTextColor()).blockFitCanvas(latexGlobalConfig.getDisableLatexSplit()).build()).inlinesSingleDollarEnable(true).isLatexFallbackEnable(latexGlobalConfig.getEnableLatexFallback()).getUnSupportLatexCommandList(latexGlobalConfig.getUnSupportLatexCommandList()).blocksEnabled(latexGlobalConfig.getEnableBlockLatex()).inlinesEnabled(true).isDisableLatexSplit(latexGlobalConfig.getDisableLatexSplit()).configLatexSplitOptimize(latexGlobalConfig.getEnableLatexSplitOptimize(), latexMaxWidth).getCustomizedLatexPattern(latexGlobalConfig.getCustomizedSingleDollarLatexPattern()).enableSupportNewCommand(latexGlobalConfig.getEnableLatexNewCommand()).configLatexBitmapCache(latexGlobalConfig.getEnableUseLatexBitmapCache(), latexGlobalConfig.getLatexBitmapCacheSize()).build(), latexGlobalConfig.getMarkdownLatexPatternStrategy(), drawablePool, drawableLruPool, latexGlobalConfig.getLatexFallbackAbility(), true, clearDrawablePoolAfterRender);
    }

    @Override // com.larus.business.markdown.api.extplugin.latex.ILatexPlugin
    public void init(Context context, LatexGlobalConfig latexGlobalConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        LaTexHelper.INSTANCE.tryInit(context, new LaTexHelper.LatexInitConfig(latexGlobalConfig != null ? latexGlobalConfig.getEnableLatexNewCommand() : false));
        LaTeXEngine.INSTANCE.addOnParseErrorListener(getInternalOnParseErrorListener());
        LaTexHelper.INSTANCE.setLatexCallback(new LatexCallback() { // from class: com.larus.bussiness.markdown.latex.LatexPluginImpl$init$1
            public void onBuild(long timeConsume) {
            }

            public void onParse(String latex) {
                IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
                if (markdownLoggerDelegate != null) {
                    markdownLoggerDelegate.mo2528d(LatexPluginImpl.TAG, "onParse==>" + latex);
                }
            }

            public void onRender(String latex) {
                IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
                if (markdownLoggerDelegate != null) {
                    markdownLoggerDelegate.mo2528d(LatexPluginImpl.TAG, "onRender==>" + latex);
                }
            }
        });
    }

    @Override // com.larus.business.markdown.api.extplugin.latex.ILatexPlugin
    public void modifyLatexMathBlockContent(Node node, String latex) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(latex, "latex");
        LatexMathBlock latexMathBlock = node instanceof LatexMathBlock ? (LatexMathBlock) node : null;
        if (latexMathBlock != null) {
            latexMathBlock.latex(latex);
        }
    }

    @Override // com.larus.business.markdown.api.extplugin.latex.ILatexPlugin
    public Map<Class<? extends Node>, String> getNodeReportMap() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(LatexMathBlock.class, "math_block"), TuplesKt.to(LatexMathNode.class, "inline_math")});
    }

    @Override // com.larus.business.markdown.api.extplugin.latex.ILatexPlugin
    public void addOnParseErrorListener(IOnLatexParseErrorListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (getOnParseErrorListeners()) {
            if (getOnParseErrorListeners().contains(listener)) {
                return;
            }
            getOnParseErrorListeners().add(listener);
        }
    }

    @Override // com.larus.business.markdown.api.extplugin.latex.ILatexPlugin
    public void removeOnParseErrorListener(IOnLatexParseErrorListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (getOnParseErrorListeners()) {
            getOnParseErrorListeners().remove(listener);
        }
    }
}
