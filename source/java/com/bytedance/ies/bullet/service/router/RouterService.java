package com.bytedance.ies.bullet.service.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.android.anniex.ability.AnnieXRouterService;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.lite.LitePageService;
import com.bytedance.android.anniex.lite.base.ILitePageService;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.utils.AnnieXUrlExtKt;
import com.bytedance.android.anniex.utils.PageOptContainer;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.schema.interceptor.WebStandardInterceptor;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IPageService;
import com.bytedance.ies.bullet.service.base.IPopUpService;
import com.bytedance.ies.bullet.service.base.IPrefetchService;
import com.bytedance.ies.bullet.service.base.IPrefetchV2Service;
import com.bytedance.ies.bullet.service.base.IPrefetchV2ServiceKt;
import com.bytedance.ies.bullet.service.base.IRouterAbilityProvider;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.api.IBulletUIService;
import com.bytedance.ies.bullet.service.base.api.IServiceContextKt;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.api.UIShowConfig;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.router.config.RouterOpenConfig;
import com.bytedance.ies.bullet.service.base.router.config.StackManager;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.ies.bullet.service.monitor.utils.MonitorConstant;
import com.bytedance.ies.bullet.service.popup.PopUpService;
import com.bytedance.ies.bullet.service.popup.PopupConfig;
import com.bytedance.ies.bullet.service.router.interceptor.DisableAutoExposeInterceptor;
import com.bytedance.ies.bullet.service.schema.ISchemaInterceptor;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.interceptor.BundleInterceptor;
import com.bytedance.ies.bullet.service.schema.interceptor.PackagesInterceptor;
import com.bytedance.ies.bullet.service.schema.utils.SchemaUtilsKt;
import com.bytedance.ies.bullet.service.sdk.SchemaConfig;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.ies.bullet.service.sdk.param.LaunchModeParam;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxInitDataWrapper;
import com.bytedance.push.event.sync.ISignalReportConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: RouterService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u0001:\u0001=B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J3\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u00032!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00160\u0018H\u0002J3\u0010\u001d\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u00032!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0018H\u0002J3\u0010\u001f\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u00032!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0018H\u0002J3\u0010 \u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u00032!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0018H\u0002J \u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002J'\u0010'\u001a\u0004\u0018\u0001H(\"\b\b\u0000\u0010(*\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H(0+H\u0002¢\u0006\u0002\u0010,J'\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020#2\u0006\u0010/\u001a\u000200H\u0002¢\u0006\u0002\u00101J \u00102\u001a\u00020\f2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020#2\b\b\u0002\u0010/\u001a\u000200J$\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00032\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020\u0003H\u0002J\u0012\u0010;\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010#H\u0002J,\u0010<\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006>"}, d2 = {"Lcom/bytedance/ies/bullet/service/router/RouterService;", "", "bid", "", "interceptor", "Lcom/bytedance/ies/bullet/service/router/IRouterInterceptor;", "(Ljava/lang/String;Lcom/bytedance/ies/bullet/service/router/IRouterInterceptor;)V", "getBid", "()Ljava/lang/String;", "getInterceptor", "()Lcom/bytedance/ies/bullet/service/router/IRouterInterceptor;", "close", "", "containerId", "sessionId", "closeAffinityPage", "channel", SchemaConstants.QUERY_KEY_BUNDLE, "self", "Lcom/bytedance/ies/bullet/service/base/IRouterAbilityProvider;", "closeAffinityPopup", "closeAnnieXContainer", "", "callback", "Lkotlin/Function1;", "Lcom/bytedance/android/anniex/base/container/IContainer;", "Lkotlin/ParameterName;", "name", "schema", "closeSameDialogFragment", "item", "closeSamePage", "closeSamePopup", "doOptimiseTask", "bulletUri", "Landroid/net/Uri;", "hostUri", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getService", "T", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "mergeFlags", "", "config", "Lcom/bytedance/ies/bullet/service/base/router/config/RouterOpenConfig;", "(Ljava/lang/String;Landroid/net/Uri;Lcom/bytedance/ies/bullet/service/base/router/config/RouterOpenConfig;)Ljava/lang/Integer;", "open", "context", "Landroid/content/Context;", "uri", "printLog", "message", "logLevel", "Lcom/bytedance/ies/bullet/service/base/api/LogLevel;", "subModule", "shouldCloseAffinity", "tryCloseAffinity", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RouterService {
    private static final String MODULE = "XRouter";
    private final String bid;
    private final IRouterInterceptor interceptor;

    /* JADX WARN: Multi-variable type inference failed */
    public RouterService() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public RouterService(String str, IRouterInterceptor iRouterInterceptor) {
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(iRouterInterceptor, "interceptor");
        this.bid = str;
        this.interceptor = iRouterInterceptor;
    }

    public final String getBid() {
        return this.bid;
    }

    public /* synthetic */ RouterService(String str, DefaultRouterInterceptor defaultRouterInterceptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "default_bid" : str, (i & 2) != 0 ? new DefaultRouterInterceptor() : defaultRouterInterceptor);
    }

    public final IRouterInterceptor getInterceptor() {
        return this.interceptor;
    }

    public static /* synthetic */ boolean open$default(RouterService routerService, Context context, Uri uri, RouterOpenConfig routerOpenConfig, int i, Object obj) {
        if ((i & 4) != 0) {
            routerOpenConfig = new RouterOpenConfig();
        }
        return routerService.open(context, uri, routerOpenConfig);
    }

    public final boolean open(Context context, final Uri uri, final RouterOpenConfig config) {
        Triple triple;
        String str;
        Object obj;
        long j;
        String str2;
        Object obj2;
        boolean z;
        PopUpService popUpService;
        String str3;
        Context context2;
        Boolean bool;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(config, "config");
        long currentTimeMillis = System.currentTimeMillis();
        PageOptContainer pageOptContainer = new PageOptContainer((String) null);
        if (IConditionCallKt.disableAddSessionId()) {
            config.setBundle(new Bundle(config.getBundle()));
        }
        String type = AnnieXUrlExtKt.getType(uri);
        if (Intrinsics.areEqual(type, RouterConstants.TYPE_POPUP)) {
            String queryParameterSafely = SchemaUtilsKt.getQueryParameterSafely(uri, "popup_type_opt");
            triple = new Triple(true, queryParameterSafely, Boolean.valueOf(AnnieXUrlExtKt.enableFlowPopup(queryParameterSafely)));
        } else {
            String queryParameterSafely2 = SchemaUtilsKt.getQueryParameterSafely(uri, "page_type_opt");
            pageOptContainer.setPageOpt$anniex_release(queryParameterSafely2);
            triple = new Triple(false, queryParameterSafely2, Boolean.valueOf(AnnieXUrlExtKt.enableFlowPage(pageOptContainer, uri) || AnnieXUrlExtKt.enableLitePage(pageOptContainer, uri)));
        }
        boolean booleanValue = ((Boolean) triple.component1()).booleanValue();
        if (((Boolean) triple.component3()).booleanValue()) {
            String queryParameterSafely3 = SchemaUtilsKt.getQueryParameterSafely(uri, XConstant.BRIDGE_CALL_ID);
            obj = "uri";
            if (queryParameterSafely3 == null) {
                queryParameterSafely3 = "";
            }
            String orCreateAnnieXSessionID = IServiceContextKt.getOrCreateAnnieXSessionID(uri, config.getBundle());
            str2 = type;
            MonitorManager monitorManager = MonitorManager.INSTANCE;
            obj2 = RouterConstants.TYPE_POPUP;
            monitorManager.markOpenTime(orCreateAnnieXSessionID, Long.valueOf(currentTimeMillis));
            SLMonitorCompat.INSTANCE.reportPV(orCreateAnnieXSessionID, uri, SLMonitorCompat.ViewType.Page.getValue());
            j = currentTimeMillis;
            ILitePageService service = AnnieX.INSTANCE.getService(this.bid, ILitePageService.class);
            if (service != null) {
                String str4 = this.bid;
                UIShowConfig uIShowConfig = new UIShowConfig();
                uIShowConfig.setSessionId(orCreateAnnieXSessionID);
                Bundle bundle = config.getBundle();
                bundle.putString("__x_session_id", orCreateAnnieXSessionID);
                str = "__x_session_id";
                bundle.putString(XConstant.BUNDLE_KEY_INNER_SCHEMA, uri.toString());
                if (booleanValue) {
                    bundle.putString("popup_type_opt", pageOptContainer.getPageOpt$anniex_release());
                } else {
                    bundle.putString("page_type_opt", pageOptContainer.getPageOpt$anniex_release());
                }
                uIShowConfig.setBundle(bundle);
                uIShowConfig.setAnimationBundle(config.getAnimationBundle());
                uIShowConfig.setLifecycleListener(config.getUiLifecycleListener());
                uIShowConfig.setCallId(queryParameterSafely3);
                uIShowConfig.setInterceptors(config.getInterceptors());
                Object obj3 = config.getBundle().get(SchemaConstants.QUERY_KEY_BDX_ACT_REQUEST_CODE);
                uIShowConfig.setRequestCode(obj3 instanceof Integer ? (Integer) obj3 : null);
                Unit unit = Unit.INSTANCE;
                bool = Boolean.valueOf(service.show(context, str4, uri, uIShowConfig));
            } else {
                str = "__x_session_id";
                bool = null;
            }
            z = true;
            if (Intrinsics.areEqual(bool, true)) {
                return bool.booleanValue();
            }
        } else {
            str = "__x_session_id";
            obj = "uri";
            j = currentTimeMillis;
            str2 = type;
            obj2 = RouterConstants.TYPE_POPUP;
            z = true;
        }
        BulletContextManager companion = BulletContextManager.INSTANCE.getInstance();
        String str5 = this.bid;
        Bundle bundle2 = config.getBundle();
        SchemaConfig schemaConfig = new SchemaConfig();
        schemaConfig.addInterceptor(new BundleInterceptor(config.getBundle()));
        schemaConfig.addInterceptor(new PackagesInterceptor(config.getPackageNames()));
        schemaConfig.addInterceptor(new DisableAutoExposeInterceptor());
        schemaConfig.addInterceptor(new WebStandardInterceptor(this.bid));
        List<ISchemaInterceptor> interceptors = config.getInterceptors();
        if (interceptors != null) {
            schemaConfig.addInterceptors(interceptors);
        }
        Unit unit2 = Unit.INSTANCE;
        boolean z2 = z;
        String str6 = str;
        BulletContext orCreateContext = companion.getOrCreateContext(str5, uri, bundle2, true, schemaConfig);
        orCreateContext.attachCaller(context);
        String queryParameterSafely4 = SchemaUtilsKt.getQueryParameterSafely(uri, XConstant.BRIDGE_CALL_ID);
        if (queryParameterSafely4 == null) {
            queryParameterSafely4 = "";
        }
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(XConstant.SESSION_ID, orCreateContext.getSessionId());
        loggerContext.pushStage(XConstant.CALL_ID, queryParameterSafely4);
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("schema", uri.toString());
        pairArr[z2 ? 1 : 0] = TuplesKt.to("bid", this.bid);
        hybridLogger.m11i("XRouter", "start create container", MapsKt.mapOf(pairArr), loggerContext);
        Object obj4 = obj2;
        SLMonitorCompat.INSTANCE.reportPV(orCreateContext.getSessionId(), uri, (Intrinsics.areEqual(AnnieXUrlExtKt.getType(uri), obj4) ? SLMonitorCompat.ViewType.Popup : SLMonitorCompat.ViewType.Page).getValue());
        orCreateContext.getMonitorCallback().onLoadEntryBullet(j, true);
        if (!this.interceptor.onPrepare(uri)) {
            HybridLogger.INSTANCE.m9e("XRouter", "RouterService create container failed", MapsKt.mapOf(new Pair[]{TuplesKt.to(ISignalReportConstants.KEY_REASON, "cancelled by interceptor.onPrepare"), TuplesKt.to("schema", uri.toString()), TuplesKt.to("bid", this.bid)}), loggerContext);
            AbsBulletMonitorCallback.onLoadError$default(orCreateContext.getMonitorCallback(), AbsBulletMonitorCallback.ErrStage.Container, MonitorConstant.ERR_INVALID_URI, false, 4, null);
            return false;
        }
        String str7 = str2;
        if (Intrinsics.areEqual(str7, obj4)) {
            popUpService = (IBulletUIService) getService(IPopUpService.class);
        } else {
            popUpService = Intrinsics.areEqual(str7, RouterConstants.TYPE_PAGE) ? (IBulletUIService) getService(IPageService.class) : (IBulletUIService) getService(IPageService.class);
        }
        String str8 = queryParameterSafely4;
        HybridLogger hybridLogger2 = HybridLogger.INSTANCE;
        Pair[] pairArr2 = new Pair[2];
        pairArr2[0] = TuplesKt.to("getServiceSuccess", Boolean.valueOf(popUpService != null));
        pairArr2[1] = TuplesKt.to("uiType", str7);
        hybridLogger2.m11i("XRouter", "get bullet ui service", MapsKt.mapOf(pairArr2), loggerContext);
        if (IConditionCallKt.enableForceBindBulletPopupService() && popUpService == null && Intrinsics.areEqual(str7, obj4) && Intrinsics.areEqual(this.bid, "default_bid")) {
            popUpService = new PopUpService(new PopupConfig(null, 1, null));
            ServiceCenter.INSTANCE.instance().bind("default_bid", IPopUpService.class, popUpService);
            HybridLogger hybridLogger3 = HybridLogger.INSTANCE;
            String stackTraceString = Log.getStackTraceString(new RuntimeException("===match bullet force bind default_bid PopUpService trace==="));
            Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(Runt… PopUpService trace===\"))");
            HybridLogger.i$default(hybridLogger3, "XRouter", stackTraceString, null, null, 12, null);
        }
        if (popUpService == null) {
            HybridLogger.INSTANCE.m9e("XRouter", "bulletUiService is null,create container failed", MapsKt.mapOf(new Pair[]{TuplesKt.to(ISignalReportConstants.KEY_REASON, "page/popup service empty"), TuplesKt.to(obj, uri.toString())}), loggerContext);
            AbsBulletMonitorCallback.onLoadError$default(orCreateContext.getMonitorCallback(), AbsBulletMonitorCallback.ErrStage.Container, MonitorConstant.ERR_UNREGISTERED_SERVICE, false, 4, null);
            return false;
        }
        Object obj5 = obj;
        orCreateContext.getMonitorCallback().recordDuration(MetricConstant.ROUTER_PRE_OPEN, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.router.RouterService$open$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m586invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m586invoke() {
                RouterOpenConfig.this.getOpenListener().onPreOpen(uri);
            }
        });
        orCreateContext.getLynxContext().setInitDataWrapper(config.getLynxInitData());
        if (config.getLynxPreloadJsFileProvider() != null) {
            HybridLogger.i$default(HybridLogger.INSTANCE, "XRouter", "set lynx preload js files", null, null, 12, null);
            orCreateContext.getLynxContext().setLynxPreloadJsFileProvider(config.getLynxPreloadJsFileProvider());
        }
        orCreateContext.getContainerContext().setGlobalProps(config.getGlobalProps());
        orCreateContext.getContainerContext().setTitleBarProvider(config.getTitleBarProvider());
        orCreateContext.getContainerContext().setViewService(config.getViewService());
        orCreateContext.setBid(this.bid);
        HybridLogger hybridLogger4 = HybridLogger.INSTANCE;
        Pair[] pairArr3 = new Pair[2];
        LynxInitDataWrapper initDataWrapper = orCreateContext.getLynxContext().getInitDataWrapper();
        if (initDataWrapper == null || (str3 = initDataWrapper.getInitData()) == null) {
            str3 = "";
        }
        pairArr3[0] = TuplesKt.to("initData", str3);
        pairArr3[1] = TuplesKt.to(obj5, uri.toString());
        hybridLogger4.m11i("XRouter", "create bulletContext with schema", MapsKt.mapOf(pairArr3), loggerContext);
        Uri loadUri = orCreateContext.getLoadUri();
        Intrinsics.checkNotNull(loadUri);
        if (!this.interceptor.onRouter(loadUri)) {
            HybridLogger.INSTANCE.m9e("XRouter", "RouterService create container failed", MapsKt.mapOf(new Pair[]{TuplesKt.to(ISignalReportConstants.KEY_REASON, "cancelled by interceptor.onPrepare"), TuplesKt.to("schema", uri.toString()), TuplesKt.to("bid", this.bid)}), loggerContext);
            AbsBulletMonitorCallback.onLoadError$default(orCreateContext.getMonitorCallback(), AbsBulletMonitorCallback.ErrStage.Container, MonitorConstant.ERR_INVALID_URI, false, 4, null);
            return false;
        }
        NestingDollUtil nestingDollUtil = NestingDollUtil.INSTANCE;
        LoggerContext loggerContext2 = new LoggerContext();
        loggerContext2.pushStage(XConstant.SESSION_ID, orCreateContext.getSessionId());
        loggerContext2.pushStage(XConstant.CALL_ID, str8);
        Unit unit3 = Unit.INSTANCE;
        if (nestingDollUtil.clearTopActivity(orCreateContext, loggerContext2)) {
            HybridLogger.INSTANCE.m9e("XRouter", "RouterService clearTopActivity result", MapsKt.mapOf(TuplesKt.to("result", RouterConstants.TRUE)), loggerContext);
            return true;
        }
        doOptimiseTask(loadUri, uri, orCreateContext);
        ArgusContainerDelegate argusContainerDelegate = orCreateContext.getArgusContainerDelegate();
        if (argusContainerDelegate != null) {
            orCreateContext.getMonitorCallback().recordSecurityEventTime(MetricConstant.SEC_CREATE_CONTAINER_START);
            context2 = context;
            argusContainerDelegate.monitorCreateContainer(context2, config.getBundle());
            orCreateContext.getMonitorCallback().recordSecurityEventTime(MetricConstant.SEC_CREATE_CONTAINER_END);
        } else {
            context2 = context;
        }
        UIShowConfig uIShowConfig2 = new UIShowConfig();
        uIShowConfig2.setFlags(mergeFlags(orCreateContext.getSessionId(), uri, config));
        uIShowConfig2.setSessionId(orCreateContext.getSessionId());
        Bundle bundle3 = config.getBundle();
        bundle3.putString(str6, orCreateContext.getSessionId());
        uIShowConfig2.setBundle(bundle3);
        uIShowConfig2.setAnimationBundle(config.getAnimationBundle());
        uIShowConfig2.setLifecycleListener(config.getUiLifecycleListener());
        uIShowConfig2.setCallId(str8);
        Object obj6 = config.getBundle().get(SchemaConstants.QUERY_KEY_BDX_ACT_REQUEST_CODE);
        uIShowConfig2.setRequestCode(obj6 instanceof Integer ? (Integer) obj6 : null);
        Unit unit4 = Unit.INSTANCE;
        boolean show = popUpService.show(context2, loadUri, uIShowConfig2);
        HybridLogger.INSTANCE.m11i("XRouter", "BulletUIService show result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Boolean.valueOf(show)), TuplesKt.to("scheme", uri.toString())}), loggerContext);
        config.getOpenListener().onPostOpen(uri, loadUri, show);
        return show;
    }

    private final Integer mergeFlags(String sessionId, Uri schema, RouterOpenConfig config) {
        Object obj;
        int i;
        Integer intOrNull;
        try {
            Result.Companion companion = Result.Companion;
            String queryParameter = schema.getQueryParameter(RouterConstants.QUERY_KEY_FLAGS);
            if (Intrinsics.areEqual(queryParameter, "clear_top")) {
                i = 67108864;
            } else {
                i = 0;
                if (queryParameter != null && (intOrNull = StringsKt.toIntOrNull(queryParameter)) != null) {
                    i = 0 | intOrNull.intValue();
                }
            }
            LaunchModeParam launchMode = NestingDollUtil.INSTANCE.getLaunchMode(BulletContextManager.INSTANCE.getInstance().getContext(sessionId));
            if (LaunchMode.CLEAR_TOP_FLAG == (launchMode != null ? launchMode.getValue() : null)) {
                i |= 67108864;
            }
            Integer flags = config.getFlags();
            if (flags != null) {
                i |= flags.intValue();
            }
            obj = Result.constructor-impl(Integer.valueOf(i));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Integer) (Result.isFailure-impl(obj) ? null : obj);
    }

    public static /* synthetic */ boolean close$default(RouterService routerService, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return routerService.close(str, str2);
    }

    public final boolean close(String containerId, String sessionId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(XConstant.SESSION_ID, sessionId);
        HybridLogger.INSTANCE.m11i("XRouter", "routerService close start", MapsKt.mapOf(new Pair[]{TuplesKt.to("containerId", containerId), TuplesKt.to("bid", this.bid)}), loggerContext);
        if (containerId.length() == 0) {
            return false;
        }
        closeSamePage(containerId, new Function1<IRouterAbilityProvider, Unit>() { // from class: com.bytedance.ies.bullet.service.router.RouterService$close$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((IRouterAbilityProvider) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(IRouterAbilityProvider iRouterAbilityProvider) {
                Intrinsics.checkNotNullParameter(iRouterAbilityProvider, "it");
                HybridLogger.INSTANCE.m11i("XRouter", "routerService close page", MapsKt.mapOf(TuplesKt.to("page", String.valueOf(iRouterAbilityProvider.getSchema()))), LoggerContext.this);
                booleanRef.element = true;
            }
        });
        closeSamePopup(containerId, new Function1<IRouterAbilityProvider, Unit>() { // from class: com.bytedance.ies.bullet.service.router.RouterService$close$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((IRouterAbilityProvider) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(IRouterAbilityProvider iRouterAbilityProvider) {
                Intrinsics.checkNotNullParameter(iRouterAbilityProvider, "it");
                HybridLogger.INSTANCE.m11i("XRouter", "routerService close popup", MapsKt.mapOf(TuplesKt.to("popup", String.valueOf(iRouterAbilityProvider.getSchema()))), LoggerContext.this);
                booleanRef.element = true;
            }
        });
        closeSameDialogFragment(containerId, new Function1<IRouterAbilityProvider, Unit>() { // from class: com.bytedance.ies.bullet.service.router.RouterService$close$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((IRouterAbilityProvider) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(IRouterAbilityProvider iRouterAbilityProvider) {
                Intrinsics.checkNotNullParameter(iRouterAbilityProvider, "it");
                HybridLogger.INSTANCE.m11i("XRouter", "routerService close lite page", MapsKt.mapOf(TuplesKt.to("litePage", String.valueOf(iRouterAbilityProvider.getSchema()))), LoggerContext.this);
                booleanRef.element = true;
            }
        });
        closeAnnieXContainer(containerId, new Function1<IContainer, Unit>() { // from class: com.bytedance.ies.bullet.service.router.RouterService$close$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((IContainer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(IContainer iContainer) {
                Intrinsics.checkNotNullParameter(iContainer, "it");
                HybridLogger.INSTANCE.m11i("XRouter", "routerService close annieX " + iContainer.getViewType(), MapsKt.mapOf(TuplesKt.to("annieX", iContainer.getCurrentUrl())), LoggerContext.this);
                booleanRef.element = true;
            }
        });
        HybridLogger.INSTANCE.m11i("XRouter", "routerService close result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Boolean.valueOf(booleanRef.element)), TuplesKt.to("containerId", containerId)}), loggerContext);
        return booleanRef.element;
    }

    public final void tryCloseAffinity(BulletContext bulletContext, String channel, String bundle, IRouterAbilityProvider self) {
        String str;
        Intrinsics.checkNotNullParameter(self, "self");
        LoggerContext loggerContext = new LoggerContext();
        if (bulletContext == null || (str = bulletContext.getSessionId()) == null) {
            str = "";
        }
        loggerContext.pushStage(XConstant.SESSION_ID, str);
        HybridLogger.INSTANCE.m11i("XRouter", "start try close Affinity", MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", this.bid), TuplesKt.to("bulletTag", self.getBulletTag()), TuplesKt.to("url", String.valueOf(self.getSchema())), TuplesKt.to("channel", channel), TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, bundle)}), loggerContext);
        Uri schema = self.getSchema();
        if (NestingDollUtil.INSTANCE.shouldCloseAffinityV2(this.bid, bulletContext, self)) {
            HybridLogger.INSTANCE.m11i("XRouter", "Use shouldCloseAffinityV2 to close the view of affinity", MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", this.bid), TuplesKt.to("bulletTag", self.getBulletTag()), TuplesKt.to("url", String.valueOf(schema)), TuplesKt.to("channel", channel), TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, bundle)}), loggerContext);
            return;
        }
        if (!shouldCloseAffinity(schema)) {
            HybridLogger.INSTANCE.m7d("XRouter", "this RouterAbilityProvider never need to close the view of affinity", MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", this.bid), TuplesKt.to("bulletTag", self.getBulletTag()), TuplesKt.to("url", String.valueOf(schema)), TuplesKt.to("IRouterAbilityProvider", self), TuplesKt.to("channel", channel), TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, bundle)}), loggerContext);
            return;
        }
        printLog$default(this, "close affinity, curChannel:" + channel + ", curBundle:" + bundle, null, "XRouter", 2, null);
        String str2 = channel;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        String str3 = bundle;
        if (str3 == null || str3.length() == 0) {
            return;
        }
        HybridLogger.INSTANCE.m11i("XRouter", "try close affinity result", MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", this.bid), TuplesKt.to("bulletTag", self.getBulletTag()), TuplesKt.to("url", String.valueOf(schema)), TuplesKt.to("IRouterAbilityProvider", self), TuplesKt.to("channel", channel), TuplesKt.to(SchemaConstants.QUERY_KEY_BUNDLE, bundle), TuplesKt.to("result", Boolean.valueOf(self instanceof Activity ? closeAffinityPage(channel, bundle, self) : closeAffinityPopup(channel, bundle, self)))}), loggerContext);
    }

    private final boolean shouldCloseAffinity(Uri schema) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(schema != null ? schema.getQueryParameter(RouterConstants.QUERY_KEY_LAUNCH_MODE) : null, "1")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Boolean bool = (Boolean) (Result.isFailure-impl(obj) ? null : obj);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0012 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean closeAffinityPage(String channel, String bundle, IRouterAbilityProvider self) {
        boolean z;
        boolean z2 = false;
        for (IRouterAbilityProvider iRouterAbilityProvider : StackManager.INSTANCE.getInstance().getActivityList()) {
            String bid = iRouterAbilityProvider.getBid();
            String channel2 = iRouterAbilityProvider.getChannel();
            String bundle2 = iRouterAbilityProvider.getBundle();
            printLog$default(this, "closeAffinityPage, channel:" + channel2 + ", bundle:" + bundle2 + ", bid:" + bid, null, "XRouter", 2, null);
            if (!Intrinsics.areEqual(iRouterAbilityProvider, self) && Intrinsics.areEqual(bid, this.bid)) {
                if (Intrinsics.areEqual(channel2, channel)) {
                    if (Intrinsics.areEqual(bundle2, bundle)) {
                        z = true;
                        if (!z) {
                            iRouterAbilityProvider = null;
                        }
                        if (iRouterAbilityProvider == null) {
                            printLog$default(this, "do closeAffinityPage", null, "XRouter", 2, null);
                            iRouterAbilityProvider.close();
                            z2 = true;
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                    if (iRouterAbilityProvider == null) {
                    }
                }
                z = false;
                if (!z) {
                }
                if (iRouterAbilityProvider == null) {
                }
            }
            z = false;
            if (!z) {
            }
            if (iRouterAbilityProvider == null) {
            }
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x001a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean closeAffinityPopup(String channel, String bundle, IRouterAbilityProvider self) {
        List<IRouterAbilityProvider> popupStack;
        boolean z;
        IPopUpService iPopUpService = (IPopUpService) getService(IPopUpService.class);
        if (iPopUpService == null || (popupStack = iPopUpService.getPopupStack()) == null) {
            return false;
        }
        boolean z2 = false;
        for (IRouterAbilityProvider iRouterAbilityProvider : popupStack) {
            String bid = iRouterAbilityProvider.getBid();
            String channel2 = iRouterAbilityProvider.getChannel();
            String bundle2 = iRouterAbilityProvider.getBundle();
            printLog$default(this, "closeAffinityPopup, channel:" + channel2 + ", bundle:" + bundle2 + ", bid:" + bid, null, "XRouter", 2, null);
            if (!Intrinsics.areEqual(iRouterAbilityProvider, self) && Intrinsics.areEqual(bid, this.bid)) {
                if (Intrinsics.areEqual(channel2, channel) && Intrinsics.areEqual(bundle2, bundle)) {
                    z = true;
                    if (!z) {
                        iRouterAbilityProvider = null;
                    }
                    if (iRouterAbilityProvider == null) {
                        printLog$default(this, "do closeAffinityPopup", null, "XRouter", 2, null);
                        iRouterAbilityProvider.close();
                        z2 = true;
                    }
                }
            }
            z = false;
            if (!z) {
            }
            if (iRouterAbilityProvider == null) {
            }
        }
        return z2;
    }

    private final void closeSamePage(String containerId, Function1<? super IRouterAbilityProvider, Unit> callback) {
        for (IRouterAbilityProvider iRouterAbilityProvider : StackManager.INSTANCE.getInstance().getActivityList()) {
            if (!Intrinsics.areEqual(iRouterAbilityProvider.getContainerId(), containerId)) {
                iRouterAbilityProvider = null;
            }
            if (iRouterAbilityProvider != null) {
                callback.invoke(iRouterAbilityProvider);
                iRouterAbilityProvider.close();
                return;
            }
        }
    }

    private final void closeSamePopup(String containerId, Function1<? super IRouterAbilityProvider, Unit> callback) {
        IPopUpService iPopUpService = (IPopUpService) getService(IPopUpService.class);
        List<IRouterAbilityProvider> popupStack = iPopUpService != null ? iPopUpService.getPopupStack() : null;
        if (popupStack != null) {
            for (IRouterAbilityProvider iRouterAbilityProvider : popupStack) {
                if (!Intrinsics.areEqual(iRouterAbilityProvider.getContainerId(), containerId)) {
                    iRouterAbilityProvider = null;
                }
                if (iRouterAbilityProvider != null) {
                    callback.invoke(iRouterAbilityProvider);
                    iRouterAbilityProvider.close();
                    return;
                }
            }
        }
    }

    private final void closeSameDialogFragment(String containerId, Function1<? super IRouterAbilityProvider, Unit> callback) {
        IRouterAbilityProvider litePageByContainer = LitePageService.Companion.getLitePageByContainer(containerId);
        if (litePageByContainer != null) {
            callback.invoke(litePageByContainer);
            litePageByContainer.close();
        }
    }

    private final void closeAnnieXContainer(String containerId, Function1<? super IContainer, Unit> callback) {
        IContainer annieXContainer$anniex_release = AnnieXRouterService.INSTANCE.getAnnieXContainer$anniex_release(containerId);
        if (annieXContainer$anniex_release != null) {
            AnnieXContainerManager.INSTANCE.closeContainerById(containerId);
            callback.invoke(annieXContainer$anniex_release);
        }
    }

    private final void doOptimiseTask(Uri bulletUri, Uri hostUri, BulletContext bulletContext) {
        IPrefetchService iPrefetchService;
        BooleanParam booleanParam = new BooleanParam(bulletContext.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_DISABLE_PRE_FETCH, false);
        BooleanParam booleanParam2 = new BooleanParam(bulletContext.getSchemaModelUnion().getSchemaData(), SchemaConstants.ENABLE_PREFETCH_V2, false);
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "RouterService.doOptimiseTask, disablePrefetch=" + booleanParam.getValue(), null, null, 6, null);
        if (Intrinsics.areEqual(booleanParam.getValue(), false) && !Intrinsics.areEqual(booleanParam2.getValue(), true) && (iPrefetchService = (IPrefetchService) getService(IPrefetchService.class)) != null) {
            iPrefetchService.prefetchForRouter(bulletUri);
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "RouterService.doOptimiseTask, prefetchService.bid=" + iPrefetchService.getBid(), null, null, 6, null);
        }
        IPrefetchV2Service prefetchV2Service = IPrefetchV2ServiceKt.getPrefetchV2Service();
        if (prefetchV2Service != null) {
            prefetchV2Service.prefetch(hostUri, this.bid, bulletContext);
            bulletContext.setPrefetchUri(hostUri);
        }
    }

    private final <T extends IBulletService> T getService(Class<T> clazz) {
        return (T) ServiceCenter.INSTANCE.instance().get(this.bid, clazz);
    }

    static /* synthetic */ void printLog$default(RouterService routerService, String str, LogLevel logLevel, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            logLevel = LogLevel.I;
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        routerService.printLog(str, logLevel, str2);
    }

    private final void printLog(String message, LogLevel logLevel, String subModule) {
        BulletLogger.INSTANCE.printLog(message, logLevel, subModule);
    }
}
