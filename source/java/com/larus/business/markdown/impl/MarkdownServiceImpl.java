package com.larus.business.markdown.impl;

import android.app.Application;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.larus.business.markdown.api.ExperimentalMarkdownApi;
import com.larus.business.markdown.api.MarkdownService;
import com.larus.business.markdown.api.depend.IMarkdownConfig;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManager;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManagerKt;
import com.larus.business.markdown.api.depend.IMarkdownSettings;
import com.larus.business.markdown.api.depend.LinkResolverWithStyle;
import com.larus.business.markdown.api.model.CustomMarkDownInfo;
import com.larus.business.markdown.api.model.IMarkwonStruct;
import com.larus.business.markdown.api.model.MarkdownContent;
import com.larus.business.markdown.api.model.MarkwonPerformance;
import com.larus.business.markdown.api.view.text.IMarkdownTextView;
import com.larus.business.markdown.api.widget.IMarkdownWidgetHandler;
import com.larus.business.markdown.impl.common.MarkdownConfigManager;
import com.larus.business.markdown.impl.common.utils.MarkdownContentPredealHelper;
import com.larus.business.markdown.impl.markwon.JumpAnalyzer;
import com.larus.business.markdown.impl.markwon.MarkwonContent;
import com.larus.business.markdown.impl.markwon.MarkwonExtKt;
import com.larus.business.markdown.impl.widget.MarkdownMultiWidgetHelper;
import com.larus.business.markdown.impl.widget.MarkdownWidgetHelper;
import com.lynx.tasm.DefaultLogicExecutor;
import io.noties.markwon.core.spans.BulletListItemSpan2;
import io.noties.markwon.core.spans.OrderedListItemSpan2;
import io.noties.markwon.inject.IInjectParser;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.commonmark.node.Node;

/* compiled from: MarkdownServiceImpl.kt */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016JE\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001bJZ\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010!2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016H\u0016J@\u0010\u001c\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016H\u0016Jp\u0010$\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000b\u0018\u00010(H\u0017JL\u0010*\u001a\u0004\u0018\u00010&2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000b\u0018\u00010(H\u0017JJ\u0010,\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010&2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u000103H\u0017Jx\u00105\u001a\b\u0012\u0004\u0012\u00020&032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00106\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010/\u001a\u0002002\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020&\u0018\u0001032\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001032\u0006\u00109\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0017J\u0010\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010=\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016J\u0012\u0010A\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016JU\u0010D\u001a\u00020\u000b2K\u0010E\u001aG\u0012\u0013\u0012\u00110G¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\u0017¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0004\u0012\u00020\u000b0FH\u0016J\u0010\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020MH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/larus/business/markdown/impl/MarkdownServiceImpl;", "Lcom/larus/business/markdown/api/MarkdownService;", "()V", "markdownConfigManager", "Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;", "getMarkdownConfigManager", "()Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;", "markdownConfigManager$delegate", "Lkotlin/Lazy;", "prepareDeferred", "Lkotlinx/coroutines/Deferred;", "", "clearMarkdownDrawableCachePool", "createCacheMarkwonStruct", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "context", "Landroid/content/Context;", "maxContentWidth", "", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "payload", "", "", "", "finished", "", "(Landroid/content/Context;Ljava/lang/Integer;Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;Ljava/util/Map;Z)Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "createMarkdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "text", "markwonStructCache", "reuseCharSequence", "", "textView", "Lcom/larus/business/markdown/api/view/text/IMarkdownTextView;", "createMarkdownContentFromNode", "node", "Lorg/commonmark/node/Node;", "callBack", "Lkotlin/Function1;", "Lcom/larus/business/markdown/api/model/MarkwonPerformance;", "createMarkdownNode", "content", "createMarkdownWidget", "isLastNode", "rootNode", "viewGroup", "Landroid/view/ViewGroup;", "lastNode", "widgetHandlerList", "", "Lcom/larus/business/markdown/api/widget/IMarkdownWidgetHandler;", "createMarkdownWidgets", "markdownRootNode", "lastFinishedStatus", "lastNodeList", "forceUpdateAndIgnoreNew", "formatCopyText", "markdownContent", "getNodeReportName", ReportUtil.Event.EVENT_INIT, "Landroid/app/Application;", "config", "Lcom/larus/business/markdown/api/depend/IMarkdownConfig;", "registerInjectParser", "injectParser", "Lio/noties/markwon/inject/IInjectParser;", "registerLinkResolver", "resolver", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "view", "link", "isFromWiki", "Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkdownServiceImpl implements MarkdownService {

    /* renamed from: markdownConfigManager$delegate, reason: from kotlin metadata */
    private final Lazy markdownConfigManager = LazyKt.lazy(new Function0<MarkdownConfigManager>() { // from class: com.larus.business.markdown.impl.MarkdownServiceImpl$markdownConfigManager$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MarkdownConfigManager m2816invoke() {
            return new MarkdownConfigManager();
        }
    });
    private Deferred<Unit> prepareDeferred;

    /* JADX INFO: Access modifiers changed from: private */
    public final MarkdownConfigManager getMarkdownConfigManager() {
        return (MarkdownConfigManager) this.markdownConfigManager.getValue();
    }

    @Override // com.larus.business.markdown.api.MarkdownService
    public void init(Application context, IMarkdownConfig config) {
        Object obj;
        IMarkdownEnsureManager markdownEnsureManager;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        MarkdownService.INSTANCE.initContext(context);
        getMarkdownConfigManager().init(config);
        MarkdownContentPredealHelper markdownContentPredealHelper = MarkdownContentPredealHelper.INSTANCE;
        IMarkdownSettings markdownSettings = config.getMarkdownSettings();
        markdownContentPredealHelper.setConfig(markdownSettings != null ? markdownSettings.getSyntaxErrorCoverConfig() : null);
        if (this.prepareDeferred != null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            this.prepareDeferred = BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new MarkdownServiceImpl$init$1$1(context, config, this, null), 3, (Object) null);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 == null || (markdownEnsureManager = MarkdownService.INSTANCE.getMarkdownEnsureManager()) == null) {
            return;
        }
        markdownEnsureManager.ensureNotReachHere(th2, "latexPluginDelegate init");
    }

    @Override // com.larus.business.markdown.api.MarkdownService
    public void registerLinkResolver(Function3<? super View, ? super String, ? super Boolean, Unit> resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        getMarkdownConfigManager().registerLinkResolver(resolver);
    }

    @Override // com.larus.business.markdown.api.MarkdownService
    public void registerInjectParser(IInjectParser injectParser) {
        getMarkdownConfigManager().registerInjectMarkdownParser(injectParser);
    }

    @Override // com.larus.business.markdown.api.MarkdownService
    public void registerLinkResolver(LinkResolverWithStyle resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        getMarkdownConfigManager().registerLinkResolver(resolver);
    }

    @Override // com.larus.business.markdown.api.MarkdownService
    public MarkdownContent createMarkdownContent(IMarkdownTextView textView, String text, boolean finished, CustomMarkDownInfo customMarkDownInfo, Map<String, ? extends Object> payload) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
        try {
            Deferred<Unit> deferred = this.prepareDeferred;
            boolean z = false;
            if (deferred != null && !deferred.isCompleted()) {
                z = true;
            }
            if (z) {
                BuildersKt.runBlocking$default((CoroutineContext) null, new MarkdownServiceImpl$createMarkdownContent$1(deferred, null), 1, (Object) null);
            }
            return MarkwonContent.INSTANCE.create(getMarkdownConfigManager(), textView, text, finished, customMarkDownInfo, payload);
        } catch (Exception e) {
            IMarkdownEnsureManager markdownEnsureManagerDelegate = IMarkdownEnsureManagerKt.getMarkdownEnsureManagerDelegate();
            if (markdownEnsureManagerDelegate != null) {
                markdownEnsureManagerDelegate.ensureNotReachHere(e, "[ErrorParseMd]text: " + text);
            }
            return MarkwonContent.INSTANCE.raw(getMarkdownConfigManager(), text);
        }
    }

    @Override // com.larus.business.markdown.api.MarkdownService
    public MarkdownContent createMarkdownContent(Context context, int maxContentWidth, String text, boolean finished, CustomMarkDownInfo customMarkDownInfo, IMarkwonStruct markwonStructCache, CharSequence reuseCharSequence, Map<String, ? extends Object> payload) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
        try {
            Deferred<Unit> deferred = this.prepareDeferred;
            boolean z = false;
            if (deferred != null && !deferred.isCompleted()) {
                z = true;
            }
            if (z) {
                BuildersKt.runBlocking$default((CoroutineContext) null, new MarkdownServiceImpl$createMarkdownContent$2(deferred, null), 1, (Object) null);
            }
            return MarkwonContent.INSTANCE.create(context, getMarkdownConfigManager(), maxContentWidth, text, finished, customMarkDownInfo, markwonStructCache, reuseCharSequence, payload);
        } catch (Exception e) {
            IMarkdownEnsureManager markdownEnsureManagerDelegate = IMarkdownEnsureManagerKt.getMarkdownEnsureManagerDelegate();
            if (markdownEnsureManagerDelegate != null) {
                markdownEnsureManagerDelegate.ensureNotReachHere(e, "[ErrorParseMd]text: " + text);
            }
            return MarkwonContent.INSTANCE.raw(getMarkdownConfigManager(), text);
        }
    }

    @Override // com.larus.business.markdown.api.MarkdownService
    @ExperimentalMarkdownApi
    public Node createMarkdownNode(Context context, String content, boolean finished, CustomMarkDownInfo customMarkDownInfo, IMarkwonStruct markwonStructCache, Function1<? super MarkwonPerformance, Unit> callBack) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            Deferred<Unit> deferred = this.prepareDeferred;
            boolean z = false;
            if (deferred != null && !deferred.isCompleted()) {
                z = true;
            }
            if (z) {
                BuildersKt.runBlocking$default((CoroutineContext) null, new MarkdownServiceImpl$createMarkdownNode$1(deferred, null), 1, (Object) null);
            }
            return MarkwonContent.INSTANCE.createNode(context, getMarkdownConfigManager(), MarkdownContentPredealHelper.INSTANCE.predealContentForSyntaxErrorCover(content, finished), finished, customMarkDownInfo, markwonStructCache, callBack);
        } catch (Exception e) {
            IMarkdownEnsureManager markdownEnsureManagerDelegate = IMarkdownEnsureManagerKt.getMarkdownEnsureManagerDelegate();
            if (markdownEnsureManagerDelegate != null) {
                markdownEnsureManagerDelegate.ensureNotReachHere(e, "createMarkdownNode");
            }
            return null;
        }
    }

    @Override // com.larus.business.markdown.api.MarkdownService
    @ExperimentalMarkdownApi
    public List<Node> createMarkdownWidgets(Context context, int maxContentWidth, Node markdownRootNode, boolean finished, boolean lastFinishedStatus, CustomMarkDownInfo customMarkDownInfo, ViewGroup viewGroup, List<? extends Node> lastNodeList, List<? extends IMarkdownWidgetHandler> widgetHandlerList, boolean forceUpdateAndIgnoreNew, IMarkwonStruct markwonStructCache) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(markdownRootNode, "markdownRootNode");
        Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        List<? extends Node> cutIntoNodeListFromFirstDeep = MarkdownWidgetHelper.INSTANCE.cutIntoNodeListFromFirstDeep(markdownRootNode, customMarkDownInfo);
        MarkdownWidgetHelper.INSTANCE.generateMarkdownWidgets(getMarkdownConfigManager(), context, maxContentWidth, cutIntoNodeListFromFirstDeep, lastNodeList, finished, lastFinishedStatus, customMarkDownInfo, viewGroup, widgetHandlerList, forceUpdateAndIgnoreNew, markwonStructCache, markdownRootNode.originText);
        return cutIntoNodeListFromFirstDeep;
    }

    @Override // com.larus.business.markdown.api.MarkdownService
    @ExperimentalMarkdownApi
    public void createMarkdownWidget(Context context, int maxContentWidth, boolean isLastNode, Node rootNode, ViewGroup viewGroup, Node lastNode, List<? extends IMarkdownWidgetHandler> widgetHandlerList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootNode, "rootNode");
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        MarkdownMultiWidgetHelper.INSTANCE.generateMarkdownWidget(context, maxContentWidth, isLastNode, rootNode, viewGroup, lastNode, widgetHandlerList);
    }

    @Override // com.larus.business.markdown.api.MarkdownService
    @ExperimentalMarkdownApi
    public MarkdownContent createMarkdownContentFromNode(Context context, int maxContentWidth, Node node, boolean finished, CustomMarkDownInfo customMarkDownInfo, CharSequence reuseCharSequence, Map<String, ? extends Object> payload, IMarkwonStruct markwonStructCache, Function1<? super MarkwonPerformance, Unit> callBack) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
        try {
            Deferred<Unit> deferred = this.prepareDeferred;
            boolean z = false;
            if (deferred != null && !deferred.isCompleted()) {
                z = true;
            }
            if (z) {
                BuildersKt.runBlocking$default((CoroutineContext) null, new MarkdownServiceImpl$createMarkdownContentFromNode$1(deferred, null), 1, (Object) null);
            }
            return MarkwonContent.INSTANCE.createFromNode(context, getMarkdownConfigManager(), maxContentWidth, node, finished, customMarkDownInfo, reuseCharSequence, payload, markwonStructCache, callBack);
        } catch (Exception e) {
            IMarkdownEnsureManager markdownEnsureManagerDelegate = IMarkdownEnsureManagerKt.getMarkdownEnsureManagerDelegate();
            if (markdownEnsureManagerDelegate != null) {
                markdownEnsureManagerDelegate.ensureNotReachHere(e, "[ErrorParseMd]node: " + node);
            }
            return MarkwonContent.INSTANCE.raw(getMarkdownConfigManager(), "");
        }
    }

    @Override // com.larus.business.markdown.api.MarkdownService
    public String getNodeReportName(Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        return JumpAnalyzer.INSTANCE.getReportName(node);
    }

    @Override // com.larus.business.markdown.api.MarkdownService
    public void clearMarkdownDrawableCachePool() {
        getMarkdownConfigManager().getDrawablePool().clear();
        getMarkdownConfigManager().getDrawableLruPool().clear();
    }

    @Override // com.larus.business.markdown.api.MarkdownService
    public String formatCopyText(MarkdownContent markdownContent) {
        Intrinsics.checkNotNullParameter(markdownContent, "markdownContent");
        SpannableStringBuilder markdown = markdownContent.getMarkdown();
        int length = markdown.length();
        StringBuilder sb = new StringBuilder(markdown.subSequence(0, length));
        final MarkwonContent markwonContent = markdownContent instanceof MarkwonContent ? (MarkwonContent) markdownContent : null;
        if (markwonContent != null) {
            Object[] spans = markwonContent.getMarkdown().getSpans(0, markdown.length(), LeadingMarginSpan.class);
            Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
            for (LeadingMarginSpan leadingMarginSpan : CollectionsKt.sortedWith(ArraysKt.toList(spans), new Comparator<T>() { // from class: com.larus.business.markdown.impl.MarkdownServiceImpl$formatCopyText$lambda$4$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(MarkwonContent.this.getMarkdown().getSpanStart((LeadingMarginSpan) t2)), Integer.valueOf(MarkwonContent.this.getMarkdown().getSpanStart((LeadingMarginSpan) t)));
                }
            })) {
                if (leadingMarginSpan instanceof OrderedListItemSpan2) {
                    int spanStart = markwonContent.getMarkdown().getSpanStart(leadingMarginSpan);
                    if (spanStart >= 0 && spanStart < length) {
                        sb.insert(spanStart + 0, ((OrderedListItemSpan2) leadingMarginSpan).orderNumber);
                    }
                } else if (leadingMarginSpan instanceof BulletListItemSpan2) {
                    int spanStart2 = markwonContent.getMarkdown().getSpanStart(leadingMarginSpan);
                    if (spanStart2 >= 0 && spanStart2 < length) {
                        sb.insert(spanStart2 + 0, "- ");
                    }
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "copyText.toString()");
        return StringsKt.trim(sb2).toString();
    }

    @Override // com.larus.business.markdown.api.MarkdownService
    public IMarkwonStruct createCacheMarkwonStruct(Context context, Integer maxContentWidth, CustomMarkDownInfo customMarkDownInfo, Map<String, ? extends Object> payload, boolean finished) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
        if (finished) {
            return MarkwonExtKt.createMarkwonStruct(context, getMarkdownConfigManager(), maxContentWidth, customMarkDownInfo, payload);
        }
        return MarkwonExtKt.createStreamMarkwonStruct(context, getMarkdownConfigManager(), maxContentWidth, customMarkDownInfo, payload);
    }
}
