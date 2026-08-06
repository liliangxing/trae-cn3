package com.bytedance.ies.bullet.core;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.IReleasable;
import com.bytedance.ies.bullet.service.base.api.IServiceContext;
import com.bytedance.ies.bullet.service.base.api.IServiceContextKt;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.BulletMonitor;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.perf.monitor.ReportConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0010¢\u0006\u0002\u0010\u0002B\u0011\b\u0010\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u001d\b\u0010\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010«\u0001\u001a\u00030¬\u00012\u0007\u0010\u00ad\u0001\u001a\u00020>2\u0007\u0010®\u0001\u001a\u00020}J\u0011\u0010¯\u0001\u001a\u00030¬\u00012\u0007\u0010°\u0001\u001a\u00020>J\u0007\u0010±\u0001\u001a\u00020JJ\n\u0010²\u0001\u001a\u00030¬\u0001H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0005R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0011\u00109\u001a\u00020:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001b\u0010C\u001a\u00020D8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bE\u0010FR\u001a\u0010I\u001a\u00020JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001e\u0010O\u001a\u0004\u0018\u00010JX\u0086\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010T\u001a\u00020JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010L\"\u0004\bU\u0010NR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001b\u0010\\\u001a\u00020]8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b`\u0010H\u001a\u0004\b^\u0010_R\u0011\u0010a\u001a\u00020b¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020lX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u0011\u0010q\u001a\u00020r¢\u0006\b\n\u0000\u001a\u0004\bs\u0010tR\u001c\u0010u\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010Y\"\u0004\bw\u0010[R\u0011\u0010x\u001a\u00020y¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u001c\u0010|\u001a\u00020}X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R \u0010\u0086\u0001\u001a\u00030\u0087\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0015\u0010\u008c\u0001\u001a\u00030\u008d\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001c\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010\u0011\"\u0005\b\u0097\u0001\u0010\u0005R\"\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001d\u0010\u009e\u0001\u001a\u00020JX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010L\"\u0005\b \u0001\u0010NR\"\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R\u0015\u0010§\u0001\u001a\u00030¨\u0001¢\u0006\n\n\u0000\u001a\u0006\b©\u0001\u0010ª\u0001¨\u0006³\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletContext;", "Lcom/bytedance/ies/bullet/service/base/IReleasable;", "()V", "sessionId", "", "(Ljava/lang/String;)V", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "(Ljava/lang/String;Lcom/bytedance/ies/bullet/service/schema/ISchemaData;)V", "argusContainerDelegate", "Lcom/bytedance/ies/argus/api/ArgusContainerDelegate;", "getArgusContainerDelegate", "()Lcom/bytedance/ies/argus/api/ArgusContainerDelegate;", "setArgusContainerDelegate", "(Lcom/bytedance/ies/argus/api/ArgusContainerDelegate;)V", "bid", "getBid", "()Ljava/lang/String;", "setBid", "bridge3Registry", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridge3Registry;", "getBridge3Registry", "()Lcom/bytedance/ies/bullet/core/kit/bridge/IBridge3Registry;", "setBridge3Registry", "(Lcom/bytedance/ies/bullet/core/kit/bridge/IBridge3Registry;)V", "bridgeRegistry", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;", "getBridgeRegistry", "()Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;", "setBridgeRegistry", "(Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;)V", "bulletGlobalLifeCycleListenerList", "", "Lcom/bytedance/ies/bullet/core/IBulletLoadLifeCycle;", "getBulletGlobalLifeCycleListenerList", "()Ljava/util/List;", "setBulletGlobalLifeCycleListenerList", "(Ljava/util/List;)V", "bulletLoadLifeCycleListener", "getBulletLoadLifeCycleListener", "()Lcom/bytedance/ies/bullet/core/IBulletLoadLifeCycle;", "setBulletLoadLifeCycleListener", "(Lcom/bytedance/ies/bullet/core/IBulletLoadLifeCycle;)V", "bulletPerfMetric", "Lcom/bytedance/ies/bullet/core/BulletPerfMetric;", "getBulletPerfMetric", "()Lcom/bytedance/ies/bullet/core/BulletPerfMetric;", "callStackContext", "Lcom/bytedance/ies/bullet/core/BulletCallStackContext;", "getCallStackContext", "()Lcom/bytedance/ies/bullet/core/BulletCallStackContext;", "clientComponent", "Lcom/bytedance/ies/bullet/base/core/common/Components;", "getClientComponent", "()Lcom/bytedance/ies/bullet/base/core/common/Components;", "setClientComponent", "(Lcom/bytedance/ies/bullet/base/core/common/Components;)V", "containerContext", "Lcom/bytedance/ies/bullet/core/BulletContainerContext;", "getContainerContext", "()Lcom/bytedance/ies/bullet/core/BulletContainerContext;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "iBulletAbility", "Lcom/bytedance/ies/bullet/core/IBulletAbility;", "getIBulletAbility", "()Lcom/bytedance/ies/bullet/core/IBulletAbility;", "iBulletAbility$delegate", "Lkotlin/Lazy;", "ignoreOrientationChanged", "", "getIgnoreOrientationChanged", "()Z", "setIgnoreOrientationChanged", "(Z)V", "isRebuild", "()Ljava/lang/Boolean;", "setRebuild", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isSimpleCard", "setSimpleCard", "loadUri", "Landroid/net/Uri;", "getLoadUri", "()Landroid/net/Uri;", "setLoadUri", "(Landroid/net/Uri;)V", "logContext", "Lcom/bytedance/ies/bullet/base/utils/logger/LoggerContext;", "getLogContext", "()Lcom/bytedance/ies/bullet/base/utils/logger/LoggerContext;", "logContext$delegate", "lynxContext", "Lcom/bytedance/ies/bullet/core/BulletLynxContext;", "getLynxContext", "()Lcom/bytedance/ies/bullet/core/BulletLynxContext;", "monitorCallback", "Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback;", "getMonitorCallback", "()Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback;", "setMonitorCallback", "(Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback;)V", "monitorContext", "Lcom/bytedance/ies/bullet/core/BulletMonitorContext;", "getMonitorContext", "()Lcom/bytedance/ies/bullet/core/BulletMonitorContext;", "setMonitorContext", "(Lcom/bytedance/ies/bullet/core/BulletMonitorContext;)V", "optimizeContext", "Lcom/bytedance/ies/bullet/core/BulletOptContext;", "getOptimizeContext", "()Lcom/bytedance/ies/bullet/core/BulletOptContext;", "prefetchUri", "getPrefetchUri", "setPrefetchUri", "resourceContext", "Lcom/bytedance/ies/bullet/core/BulletRLContext;", "getResourceContext", "()Lcom/bytedance/ies/bullet/core/BulletRLContext;", ReportConst.KEY_SCENE, "Lcom/bytedance/ies/bullet/core/common/Scenes;", "getScene", "()Lcom/bytedance/ies/bullet/core/common/Scenes;", "setScene", "(Lcom/bytedance/ies/bullet/core/common/Scenes;)V", "getSchemaData", "()Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "setSchemaData", "(Lcom/bytedance/ies/bullet/service/schema/ISchemaData;)V", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "getSchemaModelUnion", "()Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "setSchemaModelUnion", "(Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;)V", "schemeContext", "Lcom/bytedance/ies/bullet/core/BulletSchemeContext;", "getSchemeContext", "()Lcom/bytedance/ies/bullet/core/BulletSchemeContext;", "serviceContext", "Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;", "getServiceContext", "()Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;", "setServiceContext", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;)V", "getSessionId", "setSessionId", "uriIdentifier", "Lcom/bytedance/ies/bullet/service/base/utils/BulletLoadUriIdentifier;", "getUriIdentifier", "()Lcom/bytedance/ies/bullet/service/base/utils/BulletLoadUriIdentifier;", "setUriIdentifier", "(Lcom/bytedance/ies/bullet/service/base/utils/BulletLoadUriIdentifier;)V", "useCardMode", "getUseCardMode", "setUseCardMode", "viewService", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "getViewService", "()Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "setViewService", "(Lcom/bytedance/ies/bullet/service/base/IKitViewService;)V", "webContext", "Lcom/bytedance/ies/bullet/core/BulletWebContext;", "getWebContext", "()Lcom/bytedance/ies/bullet/core/BulletWebContext;", "attachCallee", "", "callee", "scenes", "attachCaller", "caller", "isFallback", "release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletContext implements IReleasable {
    private ArgusContainerDelegate argusContainerDelegate;
    private String bid;
    private IBridge3Registry bridge3Registry;
    private IBridgeRegistry bridgeRegistry;
    private List<IBulletLoadLifeCycle> bulletGlobalLifeCycleListenerList;
    private IBulletLoadLifeCycle bulletLoadLifeCycleListener;
    private final BulletPerfMetric bulletPerfMetric;
    private final BulletCallStackContext callStackContext;
    private Components clientComponent;
    private final BulletContainerContext containerContext;
    private Context context;

    /* renamed from: iBulletAbility$delegate, reason: from kotlin metadata */
    private final Lazy iBulletAbility;
    private boolean ignoreOrientationChanged;
    private Boolean isRebuild;
    private boolean isSimpleCard;
    private Uri loadUri;

    /* renamed from: logContext$delegate, reason: from kotlin metadata */
    private final Lazy logContext;
    private final BulletLynxContext lynxContext;
    private AbsBulletMonitorCallback monitorCallback;
    private BulletMonitorContext monitorContext;
    private final BulletOptContext optimizeContext;
    private Uri prefetchUri;
    private final BulletRLContext resourceContext;
    private Scenes scene;
    private volatile ISchemaData schemaData;
    private SchemaModelUnion schemaModelUnion;
    private final BulletSchemeContext schemeContext;
    private IServiceContext serviceContext;
    public String sessionId;
    private volatile BulletLoadUriIdentifier uriIdentifier;
    private boolean useCardMode;
    private IKitViewService viewService;
    private final BulletWebContext webContext;

    public BulletContext() {
        this.logContext = LazyKt.lazy(new Function0<LoggerContext>() { // from class: com.bytedance.ies.bullet.core.BulletContext$logContext$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final LoggerContext m497invoke() {
                LoggerContext loggerContext = new LoggerContext();
                loggerContext.pushStage(XConstant.SESSION_ID, BulletContext.this.getSessionId());
                return loggerContext;
            }
        });
        this.monitorCallback = BulletMonitor.INSTANCE.generateMonitorCallback();
        String str = null;
        this.monitorContext = new BulletMonitorContext(str, 1, str);
        this.bid = "default_bid";
        ISchemaData iSchemaData = this.schemaData;
        if (iSchemaData == null) {
            SchemaService companion = SchemaService.INSTANCE.getInstance();
            String str2 = this.bid;
            Uri uri = Uri.EMPTY;
            Intrinsics.checkNotNullExpressionValue(uri, "EMPTY");
            iSchemaData = companion.generateSchemaData(str2, uri);
        }
        this.schemaModelUnion = new SchemaModelUnion(iSchemaData);
        this.scene = Scenes.Card;
        this.clientComponent = Components.View;
        this.bulletGlobalLifeCycleListenerList = new ArrayList();
        this.iBulletAbility = LazyKt.lazy(new Function0<BulletAbility>() { // from class: com.bytedance.ies.bullet.core.BulletContext$iBulletAbility$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BulletAbility m496invoke() {
                String bid = BulletContext.this.getBid();
                if (bid == null) {
                    bid = "default_bid";
                }
                return new BulletAbility(bid);
            }
        });
        this.schemeContext = new BulletSchemeContext();
        this.lynxContext = new BulletLynxContext();
        this.webContext = new BulletWebContext();
        this.containerContext = new BulletContainerContext();
        this.resourceContext = new BulletRLContext();
        this.bulletPerfMetric = new BulletPerfMetric(this);
        this.optimizeContext = new BulletOptContext();
        this.callStackContext = new BulletCallStackContext();
        this.argusContainerDelegate = BulletContextKt.access$initArgusSecureDelegate();
    }

    public BulletContext(String str) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        this.logContext = LazyKt.lazy(new Function0<LoggerContext>() { // from class: com.bytedance.ies.bullet.core.BulletContext$logContext$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final LoggerContext m497invoke() {
                LoggerContext loggerContext = new LoggerContext();
                loggerContext.pushStage(XConstant.SESSION_ID, BulletContext.this.getSessionId());
                return loggerContext;
            }
        });
        this.monitorCallback = BulletMonitor.INSTANCE.generateMonitorCallback();
        String str2 = null;
        this.monitorContext = new BulletMonitorContext(str2, 1, str2);
        this.bid = "default_bid";
        ISchemaData iSchemaData = this.schemaData;
        if (iSchemaData == null) {
            SchemaService companion = SchemaService.INSTANCE.getInstance();
            String str3 = this.bid;
            Uri uri = Uri.EMPTY;
            Intrinsics.checkNotNullExpressionValue(uri, "EMPTY");
            iSchemaData = companion.generateSchemaData(str3, uri);
        }
        this.schemaModelUnion = new SchemaModelUnion(iSchemaData);
        this.scene = Scenes.Card;
        this.clientComponent = Components.View;
        this.bulletGlobalLifeCycleListenerList = new ArrayList();
        this.iBulletAbility = LazyKt.lazy(new Function0<BulletAbility>() { // from class: com.bytedance.ies.bullet.core.BulletContext$iBulletAbility$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BulletAbility m496invoke() {
                String bid = BulletContext.this.getBid();
                if (bid == null) {
                    bid = "default_bid";
                }
                return new BulletAbility(bid);
            }
        });
        this.schemeContext = new BulletSchemeContext();
        this.lynxContext = new BulletLynxContext();
        this.webContext = new BulletWebContext();
        this.containerContext = new BulletContainerContext();
        this.resourceContext = new BulletRLContext();
        this.bulletPerfMetric = new BulletPerfMetric(this);
        this.optimizeContext = new BulletOptContext();
        this.callStackContext = new BulletCallStackContext();
        this.argusContainerDelegate = BulletContextKt.access$initArgusSecureDelegate();
        setSessionId(str);
    }

    public /* synthetic */ BulletContext(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? IServiceContextKt.createSessionID() : str);
    }

    public /* synthetic */ BulletContext(String str, ISchemaData iSchemaData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? IServiceContextKt.createSessionID() : str, (i & 2) != 0 ? null : iSchemaData);
    }

    public BulletContext(String str, ISchemaData iSchemaData) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        this.logContext = LazyKt.lazy(new Function0<LoggerContext>() { // from class: com.bytedance.ies.bullet.core.BulletContext$logContext$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final LoggerContext m497invoke() {
                LoggerContext loggerContext = new LoggerContext();
                loggerContext.pushStage(XConstant.SESSION_ID, BulletContext.this.getSessionId());
                return loggerContext;
            }
        });
        this.monitorCallback = BulletMonitor.INSTANCE.generateMonitorCallback();
        String str2 = null;
        this.monitorContext = new BulletMonitorContext(str2, 1, str2);
        this.bid = "default_bid";
        ISchemaData iSchemaData2 = this.schemaData;
        if (iSchemaData2 == null) {
            SchemaService companion = SchemaService.INSTANCE.getInstance();
            String str3 = this.bid;
            Uri uri = Uri.EMPTY;
            Intrinsics.checkNotNullExpressionValue(uri, "EMPTY");
            iSchemaData2 = companion.generateSchemaData(str3, uri);
        }
        this.schemaModelUnion = new SchemaModelUnion(iSchemaData2);
        this.scene = Scenes.Card;
        this.clientComponent = Components.View;
        this.bulletGlobalLifeCycleListenerList = new ArrayList();
        this.iBulletAbility = LazyKt.lazy(new Function0<BulletAbility>() { // from class: com.bytedance.ies.bullet.core.BulletContext$iBulletAbility$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BulletAbility m496invoke() {
                String bid = BulletContext.this.getBid();
                if (bid == null) {
                    bid = "default_bid";
                }
                return new BulletAbility(bid);
            }
        });
        this.schemeContext = new BulletSchemeContext();
        this.lynxContext = new BulletLynxContext();
        this.webContext = new BulletWebContext();
        this.containerContext = new BulletContainerContext();
        this.resourceContext = new BulletRLContext();
        this.bulletPerfMetric = new BulletPerfMetric(this);
        this.optimizeContext = new BulletOptContext();
        this.callStackContext = new BulletCallStackContext();
        this.argusContainerDelegate = BulletContextKt.access$initArgusSecureDelegate();
        setSessionId(str);
        this.schemaData = iSchemaData;
    }

    public final String getSessionId() {
        String str = this.sessionId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sessionId");
        return null;
    }

    public final void setSessionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    public final LoggerContext getLogContext() {
        return (LoggerContext) this.logContext.getValue();
    }

    public final AbsBulletMonitorCallback getMonitorCallback() {
        return this.monitorCallback;
    }

    public final void setMonitorCallback(AbsBulletMonitorCallback absBulletMonitorCallback) {
        Intrinsics.checkNotNullParameter(absBulletMonitorCallback, "<set-?>");
        this.monitorCallback = absBulletMonitorCallback;
    }

    public final BulletMonitorContext getMonitorContext() {
        return this.monitorContext;
    }

    public final void setMonitorContext(BulletMonitorContext bulletMonitorContext) {
        Intrinsics.checkNotNullParameter(bulletMonitorContext, "<set-?>");
        this.monitorContext = bulletMonitorContext;
    }

    public final ISchemaData getSchemaData() {
        return this.schemaData;
    }

    public final void setSchemaData(ISchemaData iSchemaData) {
        this.schemaData = iSchemaData;
    }

    public final String getBid() {
        return this.bid;
    }

    public final void setBid(String str) {
        this.bid = str;
    }

    public final SchemaModelUnion getSchemaModelUnion() {
        return this.schemaModelUnion;
    }

    public final void setSchemaModelUnion(SchemaModelUnion schemaModelUnion) {
        Intrinsics.checkNotNullParameter(schemaModelUnion, "<set-?>");
        this.schemaModelUnion = schemaModelUnion;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    public final Scenes getScene() {
        return this.scene;
    }

    public final void setScene(Scenes scenes) {
        Intrinsics.checkNotNullParameter(scenes, "<set-?>");
        this.scene = scenes;
    }

    public final Components getClientComponent() {
        return this.clientComponent;
    }

    public final void setClientComponent(Components components) {
        Intrinsics.checkNotNullParameter(components, "<set-?>");
        this.clientComponent = components;
    }

    public final Uri getLoadUri() {
        return this.loadUri;
    }

    public final void setLoadUri(Uri uri) {
        this.loadUri = uri;
    }

    public final IKitViewService getViewService() {
        return this.viewService;
    }

    public final void setViewService(IKitViewService iKitViewService) {
        this.viewService = iKitViewService;
    }

    public final IBulletLoadLifeCycle getBulletLoadLifeCycleListener() {
        return this.bulletLoadLifeCycleListener;
    }

    public final void setBulletLoadLifeCycleListener(IBulletLoadLifeCycle iBulletLoadLifeCycle) {
        this.bulletLoadLifeCycleListener = iBulletLoadLifeCycle;
    }

    public final List<IBulletLoadLifeCycle> getBulletGlobalLifeCycleListenerList() {
        return this.bulletGlobalLifeCycleListenerList;
    }

    public final void setBulletGlobalLifeCycleListenerList(List<IBulletLoadLifeCycle> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.bulletGlobalLifeCycleListenerList = list;
    }

    public final IBridgeRegistry getBridgeRegistry() {
        return this.bridgeRegistry;
    }

    public final void setBridgeRegistry(IBridgeRegistry iBridgeRegistry) {
        this.bridgeRegistry = iBridgeRegistry;
    }

    public final IBridge3Registry getBridge3Registry() {
        return this.bridge3Registry;
    }

    public final void setBridge3Registry(IBridge3Registry iBridge3Registry) {
        this.bridge3Registry = iBridge3Registry;
    }

    public final BulletLoadUriIdentifier getUriIdentifier() {
        return this.uriIdentifier;
    }

    public final void setUriIdentifier(BulletLoadUriIdentifier bulletLoadUriIdentifier) {
        this.uriIdentifier = bulletLoadUriIdentifier;
    }

    public final IServiceContext getServiceContext() {
        return this.serviceContext;
    }

    public final void setServiceContext(IServiceContext iServiceContext) {
        this.serviceContext = iServiceContext;
    }

    public final IBulletAbility getIBulletAbility() {
        return (IBulletAbility) this.iBulletAbility.getValue();
    }

    public final BulletSchemeContext getSchemeContext() {
        return this.schemeContext;
    }

    public final BulletLynxContext getLynxContext() {
        return this.lynxContext;
    }

    public final BulletWebContext getWebContext() {
        return this.webContext;
    }

    public final BulletContainerContext getContainerContext() {
        return this.containerContext;
    }

    public final BulletRLContext getResourceContext() {
        return this.resourceContext;
    }

    public final BulletPerfMetric getBulletPerfMetric() {
        return this.bulletPerfMetric;
    }

    public final BulletOptContext getOptimizeContext() {
        return this.optimizeContext;
    }

    public final BulletCallStackContext getCallStackContext() {
        return this.callStackContext;
    }

    public final Uri getPrefetchUri() {
        return this.prefetchUri;
    }

    public final void setPrefetchUri(Uri uri) {
        this.prefetchUri = uri;
    }

    public final boolean getUseCardMode() {
        return this.useCardMode;
    }

    public final void setUseCardMode(boolean z) {
        this.useCardMode = z;
    }

    /* renamed from: isSimpleCard, reason: from getter */
    public final boolean getIsSimpleCard() {
        return this.isSimpleCard;
    }

    public final void setSimpleCard(boolean z) {
        this.isSimpleCard = z;
    }

    public final ArgusContainerDelegate getArgusContainerDelegate() {
        return this.argusContainerDelegate;
    }

    public final void setArgusContainerDelegate(ArgusContainerDelegate argusContainerDelegate) {
        this.argusContainerDelegate = argusContainerDelegate;
    }

    public final boolean getIgnoreOrientationChanged() {
        return this.ignoreOrientationChanged;
    }

    public final void setIgnoreOrientationChanged(boolean z) {
        this.ignoreOrientationChanged = z;
    }

    /* renamed from: isRebuild, reason: from getter */
    public final Boolean getIsRebuild() {
        return this.isRebuild;
    }

    public final void setRebuild(Boolean bool) {
        this.isRebuild = bool;
    }

    public final boolean isFallback() {
        return this.containerContext.getFallbackInfo() != null;
    }

    public final void attachCaller(Context caller) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        this.callStackContext.attachCaller(caller, getSessionId());
    }

    public final void attachCallee(Context callee, Scenes scenes) {
        Intrinsics.checkNotNullParameter(callee, "callee");
        Intrinsics.checkNotNullParameter(scenes, "scenes");
        this.callStackContext.attachCallee(callee, getSessionId(), scenes);
    }

    @Override // com.bytedance.ies.bullet.service.base.IReleasable
    public void release() {
        this.bulletLoadLifeCycleListener = null;
        this.bulletGlobalLifeCycleListenerList.clear();
        this.lynxContext.setLynxGlobalConfig(null);
        this.webContext.setActionModeProvider(null);
        this.serviceContext = null;
        this.viewService = null;
        this.context = null;
        this.bridgeRegistry = null;
        this.bridge3Registry = null;
        ArgusContainerDelegate argusContainerDelegate = this.argusContainerDelegate;
        if (argusContainerDelegate != null) {
            argusContainerDelegate.clear();
        }
        this.argusContainerDelegate = null;
    }
}
