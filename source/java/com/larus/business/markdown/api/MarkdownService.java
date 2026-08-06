package com.larus.business.markdown.api;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.larus.business.markdown.api.depend.IMarkdownConfig;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManager;
import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.LinkResolverWithStyle;
import com.larus.business.markdown.api.model.CustomMarkDownInfo;
import com.larus.business.markdown.api.model.IMarkwonStruct;
import com.larus.business.markdown.api.model.MarkdownContent;
import com.larus.business.markdown.api.model.MarkwonPerformance;
import com.larus.business.markdown.api.view.text.IMarkdownTextView;
import com.larus.business.markdown.api.widget.IMarkdownWidgetHandler;
import com.lynx.tasm.DefaultLogicExecutor;
import io.noties.markwon.inject.IInjectParser;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;

/* compiled from: MarkdownService.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 D2\u00020\u0001:\u0001DJ\b\u0010\u0002\u001a\u00020\u0003H&JG\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H&¢\u0006\u0002\u0010\u0011J`\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH&JB\u0010\u0012\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH'Jx\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001eH'JR\u0010 \u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001eH'JN\u0010\"\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001c2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H'J\u0080\u0001\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0)2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010)2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\b\b\u0002\u0010/\u001a\u00020\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H'J\u0010\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u0013H&J\u0010\u00102\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0018\u00103\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u0002042\u0006\u00105\u001a\u000206H&J\u0012\u00107\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u000109H&JU\u0010:\u001a\u00020\u00032K\u0010;\u001aG\u0012\u0013\u0012\u00110=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u00030<H&J\u0010\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020CH&¨\u0006E"}, d2 = {"Lcom/larus/business/markdown/api/MarkdownService;", "", "clearMarkdownDrawableCachePool", "", "createCacheMarkwonStruct", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "context", "Landroid/content/Context;", "maxContentWidth", "", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "payload", "", "", "finished", "", "(Landroid/content/Context;Ljava/lang/Integer;Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;Ljava/util/Map;Z)Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "createMarkdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "text", "markwonStructCache", "reuseCharSequence", "", "textView", "Lcom/larus/business/markdown/api/view/text/IMarkdownTextView;", "createMarkdownContentFromNode", "node", "Lorg/commonmark/node/Node;", "callBack", "Lkotlin/Function1;", "Lcom/larus/business/markdown/api/model/MarkwonPerformance;", "createMarkdownNode", "content", "createMarkdownWidget", "isLastNode", "rootNode", "viewGroup", "Landroid/view/ViewGroup;", "lastNode", "widgetHandlerList", "", "Lcom/larus/business/markdown/api/widget/IMarkdownWidgetHandler;", "createMarkdownWidgets", "markdownRootNode", "lastFinishedStatus", "lastNodeList", "forceUpdateAndIgnoreNew", "formatCopyText", "markdownContent", "getNodeReportName", ReportUtil.Event.EVENT_INIT, "Landroid/app/Application;", "config", "Lcom/larus/business/markdown/api/depend/IMarkdownConfig;", "registerInjectParser", "injectParser", "Lio/noties/markwon/inject/IInjectParser;", "registerLinkResolver", "resolver", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "view", "link", "isFromWiki", "Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "Companion", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface MarkdownService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void clearMarkdownDrawableCachePool();

    IMarkwonStruct createCacheMarkwonStruct(Context context, Integer maxContentWidth, CustomMarkDownInfo customMarkDownInfo, Map<String, ? extends Object> payload, boolean finished);

    MarkdownContent createMarkdownContent(Context context, int maxContentWidth, String text, boolean finished, CustomMarkDownInfo customMarkDownInfo, IMarkwonStruct markwonStructCache, CharSequence reuseCharSequence, Map<String, ? extends Object> payload);

    @Deprecated(message = "尽量使用不包含TextView的同名类")
    MarkdownContent createMarkdownContent(IMarkdownTextView textView, String text, boolean finished, CustomMarkDownInfo customMarkDownInfo, Map<String, ? extends Object> payload);

    @ExperimentalMarkdownApi
    MarkdownContent createMarkdownContentFromNode(Context context, int maxContentWidth, Node node, boolean finished, CustomMarkDownInfo customMarkDownInfo, CharSequence reuseCharSequence, Map<String, ? extends Object> payload, IMarkwonStruct markwonStructCache, Function1<? super MarkwonPerformance, Unit> callBack);

    @ExperimentalMarkdownApi
    Node createMarkdownNode(Context context, String content, boolean finished, CustomMarkDownInfo customMarkDownInfo, IMarkwonStruct markwonStructCache, Function1<? super MarkwonPerformance, Unit> callBack);

    @ExperimentalMarkdownApi
    void createMarkdownWidget(Context context, int maxContentWidth, boolean isLastNode, Node rootNode, ViewGroup viewGroup, Node lastNode, List<? extends IMarkdownWidgetHandler> widgetHandlerList);

    @ExperimentalMarkdownApi
    List<Node> createMarkdownWidgets(Context context, int maxContentWidth, Node markdownRootNode, boolean finished, boolean lastFinishedStatus, CustomMarkDownInfo customMarkDownInfo, ViewGroup viewGroup, List<? extends Node> lastNodeList, List<? extends IMarkdownWidgetHandler> widgetHandlerList, boolean forceUpdateAndIgnoreNew, IMarkwonStruct markwonStructCache);

    String formatCopyText(MarkdownContent markdownContent);

    String getNodeReportName(Node node);

    void init(Application context, IMarkdownConfig config);

    void registerInjectParser(IInjectParser injectParser);

    void registerLinkResolver(LinkResolverWithStyle resolver);

    void registerLinkResolver(Function3<? super View, ? super String, ? super Boolean, Unit> resolver);

    /* compiled from: MarkdownService.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/larus/business/markdown/api/MarkdownService$Companion;", "", "()V", "CLASS_NAME_MARKDOWN_SERVICE_IMPL", "", "<set-?>", "Landroid/app/Application;", "application", "getApplication", "()Landroid/app/Application;", "instance", "Lcom/larus/business/markdown/api/MarkdownService;", "Lcom/larus/business/markdown/api/depend/IMarkdownEnsureManager;", "markdownEnsureManager", "getMarkdownEnsureManager", "()Lcom/larus/business/markdown/api/depend/IMarkdownEnsureManager;", "Lcom/larus/business/markdown/api/depend/IMarkdownLogger;", "markdownLogger", "getMarkdownLogger", "()Lcom/larus/business/markdown/api/depend/IMarkdownLogger;", "createService", "getService", "initContext", "", "context", "initEnsureManager", "ensureManager", "initLogger", "logger", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String CLASS_NAME_MARKDOWN_SERVICE_IMPL = "com.larus.business.markdown.impl.MarkdownServiceImpl";
        private static Application application;
        private static MarkdownService instance;
        private static IMarkdownEnsureManager markdownEnsureManager;
        private static IMarkdownLogger markdownLogger;

        private Companion() {
        }

        public final Application getApplication() {
            return application;
        }

        public final IMarkdownLogger getMarkdownLogger() {
            return markdownLogger;
        }

        public final IMarkdownEnsureManager getMarkdownEnsureManager() {
            return markdownEnsureManager;
        }

        public final MarkdownService getService() {
            MarkdownService markdownService = instance;
            MarkdownService markdownService2 = null;
            if (markdownService != null) {
                if (markdownService != null) {
                    return markdownService;
                }
                Intrinsics.throwUninitializedPropertyAccessException("instance");
                return null;
            }
            synchronized (CLASS_NAME_MARKDOWN_SERVICE_IMPL) {
                try {
                    Object newInstance = Class.forName(CLASS_NAME_MARKDOWN_SERVICE_IMPL).newInstance();
                    Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.larus.business.markdown.api.MarkdownService");
                    MarkdownService markdownService3 = (MarkdownService) newInstance;
                    instance = markdownService3;
                    if (markdownService3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("instance");
                    } else {
                        markdownService2 = markdownService3;
                    }
                } catch (Throwable unused) {
                    return null;
                }
            }
            return markdownService2;
        }

        public final MarkdownService createService() {
            try {
                Object newInstance = Class.forName(CLASS_NAME_MARKDOWN_SERVICE_IMPL).newInstance();
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.larus.business.markdown.api.MarkdownService");
                return (MarkdownService) newInstance;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final void initContext(Application context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (application != null) {
                return;
            }
            application = context;
        }

        public final void initLogger(IMarkdownLogger logger) {
            Intrinsics.checkNotNullParameter(logger, "logger");
            markdownLogger = logger;
        }

        public final void initEnsureManager(IMarkdownEnsureManager ensureManager) {
            Intrinsics.checkNotNullParameter(ensureManager, "ensureManager");
            markdownEnsureManager = ensureManager;
        }
    }

    /* compiled from: MarkdownService.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ MarkdownContent createMarkdownContent$default(MarkdownService markdownService, IMarkdownTextView iMarkdownTextView, String str, boolean z, CustomMarkDownInfo customMarkDownInfo, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMarkdownContent");
            }
            if ((i & 16) != 0) {
                map = null;
            }
            return markdownService.createMarkdownContent(iMarkdownTextView, str, z, customMarkDownInfo, map);
        }

        public static /* synthetic */ MarkdownContent createMarkdownContent$default(MarkdownService markdownService, Context context, int i, String str, boolean z, CustomMarkDownInfo customMarkDownInfo, IMarkwonStruct iMarkwonStruct, CharSequence charSequence, Map map, int i2, Object obj) {
            if (obj == null) {
                return markdownService.createMarkdownContent(context, i, str, z, customMarkDownInfo, (i2 & 32) != 0 ? null : iMarkwonStruct, (i2 & 64) != 0 ? null : charSequence, (i2 & 128) != 0 ? null : map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMarkdownContent");
        }

        public static /* synthetic */ Node createMarkdownNode$default(MarkdownService markdownService, Context context, String str, boolean z, CustomMarkDownInfo customMarkDownInfo, IMarkwonStruct iMarkwonStruct, Function1 function1, int i, Object obj) {
            if (obj == null) {
                return markdownService.createMarkdownNode(context, str, z, (i & 8) != 0 ? null : customMarkDownInfo, (i & 16) != 0 ? null : iMarkwonStruct, (i & 32) != 0 ? null : function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMarkdownNode");
        }

        public static /* synthetic */ MarkdownContent createMarkdownContentFromNode$default(MarkdownService markdownService, Context context, int i, Node node, boolean z, CustomMarkDownInfo customMarkDownInfo, CharSequence charSequence, Map map, IMarkwonStruct iMarkwonStruct, Function1 function1, int i2, Object obj) {
            if (obj == null) {
                return markdownService.createMarkdownContentFromNode(context, i, node, z, customMarkDownInfo, (i2 & 32) != 0 ? null : charSequence, (i2 & 64) != 0 ? null : map, (i2 & 128) != 0 ? null : iMarkwonStruct, (i2 & 256) != 0 ? null : function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMarkdownContentFromNode");
        }

        public static /* synthetic */ List createMarkdownWidgets$default(MarkdownService markdownService, Context context, int i, Node node, boolean z, boolean z2, CustomMarkDownInfo customMarkDownInfo, ViewGroup viewGroup, List list, List list2, boolean z3, IMarkwonStruct iMarkwonStruct, int i2, Object obj) {
            if (obj == null) {
                return markdownService.createMarkdownWidgets(context, i, node, z, z2, customMarkDownInfo, viewGroup, (i2 & 128) != 0 ? null : list, (i2 & 256) != 0 ? null : list2, (i2 & 512) != 0 ? false : z3, (i2 & 1024) != 0 ? null : iMarkwonStruct);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMarkdownWidgets");
        }

        public static /* synthetic */ void createMarkdownWidget$default(MarkdownService markdownService, Context context, int i, boolean z, Node node, ViewGroup viewGroup, Node node2, List list, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMarkdownWidget");
            }
            markdownService.createMarkdownWidget(context, i, z, node, viewGroup, (i2 & 32) != 0 ? null : node2, (i2 & 64) != 0 ? null : list);
        }

        public static /* synthetic */ IMarkwonStruct createCacheMarkwonStruct$default(MarkdownService markdownService, Context context, Integer num, CustomMarkDownInfo customMarkDownInfo, Map map, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createCacheMarkwonStruct");
            }
            if ((i & 2) != 0) {
                num = null;
            }
            return markdownService.createCacheMarkwonStruct(context, num, customMarkDownInfo, map, z);
        }
    }
}
