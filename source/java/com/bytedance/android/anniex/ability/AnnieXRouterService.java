package com.bytedance.android.anniex.ability;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import coil3.disk.DiskLruCache;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.container.p025ui.AnnieXPageService;
import com.bytedance.android.anniex.container.popup.AnnieXPopUpService;
import com.bytedance.android.anniex.lite.base.ILitePageService;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.utils.AnnieXConstants;
import com.bytedance.android.anniex.utils.AnnieXUrlExtKt;
import com.bytedance.android.anniex.utils.PageOptContainer;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IPrefetchV2Service;
import com.bytedance.ies.bullet.service.base.IPrefetchV2ServiceKt;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.api.IBulletUIService;
import com.bytedance.ies.bullet.service.base.api.IServiceContextKt;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.api.UIShowConfig;
import com.bytedance.ies.bullet.service.base.router.config.RouterOpenConfig;
import com.bytedance.ies.bullet.service.schema.utils.SchemaUtilsKt;
import com.bytedance.ies.bullet.service.sdk.SchemaConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXRouterService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0017\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\fJ*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/anniex/ability/AnnieXRouterService;", "", "()V", "doOptimiseTask", "", "currentBid", "", "currentUri", "Landroid/net/Uri;", "getAnnieXContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "containerId", "getAnnieXContainer$anniex_release", "open", "", "context", "Landroid/content/Context;", "uri", "config", "Lcom/bytedance/ies/bullet/service/base/router/config/RouterOpenConfig;", "bid", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXRouterService {
    public static final AnnieXRouterService INSTANCE = new AnnieXRouterService();

    private AnnieXRouterService() {
    }

    public static /* synthetic */ boolean open$default(AnnieXRouterService annieXRouterService, Context context, Uri uri, RouterOpenConfig routerOpenConfig, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            routerOpenConfig = new RouterOpenConfig();
        }
        if ((i & 8) != 0) {
            str = "default_bid";
        }
        return annieXRouterService.open(context, uri, routerOpenConfig, str);
    }

    public final boolean open(Context context, Uri uri, RouterOpenConfig config, String bid) {
        Triple triple;
        Object obj;
        IBulletService iBulletService;
        Boolean bool;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(bid, "bid");
        long currentTimeMillis = System.currentTimeMillis();
        PageOptContainer pageOptContainer = new PageOptContainer(null);
        String type = AnnieXUrlExtKt.getType(uri);
        if (Intrinsics.areEqual(type, "_popup")) {
            String queryParameterSafely = SchemaUtilsKt.getQueryParameterSafely(uri, AnnieXConstants.ANNIEX_POPUP_TYPE_OPT);
            triple = new Triple(true, queryParameterSafely, Boolean.valueOf(AnnieXUrlExtKt.enableFlowPopup(queryParameterSafely)));
        } else {
            String queryParameterSafely2 = SchemaUtilsKt.getQueryParameterSafely(uri, AnnieXConstants.ANNIEX_PAGE_TYPE_OPT);
            pageOptContainer.setPageOpt$anniex_release(queryParameterSafely2);
            triple = new Triple(false, queryParameterSafely2, Boolean.valueOf(AnnieXUrlExtKt.enableFlowPage(pageOptContainer, uri) || AnnieXUrlExtKt.enableLitePage(pageOptContainer, uri)));
        }
        boolean booleanValue = ((Boolean) triple.component1()).booleanValue();
        if (((Boolean) triple.component3()).booleanValue()) {
            String queryParameterSafely3 = SchemaUtilsKt.getQueryParameterSafely(uri, "__bullet_trident_call_id");
            if (queryParameterSafely3 == null) {
                queryParameterSafely3 = "";
            }
            String orCreateAnnieXSessionID = IServiceContextKt.getOrCreateAnnieXSessionID(uri, config.getBundle());
            MonitorManager.INSTANCE.markOpenTime(orCreateAnnieXSessionID, Long.valueOf(currentTimeMillis));
            SLMonitorCompat.INSTANCE.reportPV(orCreateAnnieXSessionID, uri, SLMonitorCompat.ViewType.Page.getValue());
            ILitePageService iLitePageService = (ILitePageService) AnnieX.INSTANCE.getService(bid, ILitePageService.class);
            if (iLitePageService != null) {
                UIShowConfig uIShowConfig = new UIShowConfig();
                uIShowConfig.setSessionId(orCreateAnnieXSessionID);
                Bundle bundle = config.getBundle();
                obj = "_popup";
                bundle.putString("__x_session_id", orCreateAnnieXSessionID);
                bundle.putString("__x_inner_schema", uri.toString());
                if (booleanValue) {
                    bundle.putString(AnnieXConstants.ANNIEX_POPUP_TYPE_OPT, pageOptContainer.getPageOpt$anniex_release());
                } else {
                    bundle.putString(AnnieXConstants.ANNIEX_PAGE_TYPE_OPT, pageOptContainer.getPageOpt$anniex_release());
                }
                uIShowConfig.setBundle(bundle);
                uIShowConfig.setAnimationBundle(config.getAnimationBundle());
                uIShowConfig.setLifecycleListener(config.getUiLifecycleListener());
                uIShowConfig.setCallId(queryParameterSafely3);
                uIShowConfig.setInterceptors(config.getInterceptors());
                Object obj2 = config.getBundle().get("bdx_act_request_code");
                uIShowConfig.setRequestCode(obj2 instanceof Integer ? (Integer) obj2 : null);
                Unit unit = Unit.INSTANCE;
                bool = Boolean.valueOf(iLitePageService.show(context, bid, uri, uIShowConfig));
            } else {
                obj = "_popup";
                bool = null;
            }
            if (Intrinsics.areEqual(bool, true)) {
                return bool.booleanValue();
            }
        } else {
            obj = "_popup";
        }
        doOptimiseTask(bid, uri);
        if (Intrinsics.areEqual(bid, "liveSaaS")) {
            AnnieX.INSTANCE.getService(bid, IAnnieXBizPropsProvider.class);
        }
        if (Intrinsics.areEqual(type, "_page")) {
            IBulletService annieXPageService = new AnnieXPageService();
            annieXPageService.onRegister(bid);
            iBulletService = annieXPageService;
        } else if (Intrinsics.areEqual(type, obj)) {
            IBulletService annieXPopUpService = new AnnieXPopUpService();
            annieXPopUpService.onRegister(bid);
            iBulletService = annieXPopUpService;
        } else {
            IBulletService annieXPageService2 = new AnnieXPageService();
            annieXPageService2.onRegister(bid);
            iBulletService = annieXPageService2;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, "XRouter", "get annieX ui service", MapsKt.mapOf(TuplesKt.to("uiType", type)), (LoggerContext) null, 8, (Object) null);
        IBulletUIService iBulletUIService = (IBulletUIService) iBulletService;
        UIShowConfig uIShowConfig2 = new UIShowConfig();
        uIShowConfig2.setAnimationBundle(config.getAnimationBundle());
        Object obj3 = config.getBundle().get("bdx_act_request_code");
        uIShowConfig2.setRequestCode(obj3 instanceof Integer ? (Integer) obj3 : null);
        Unit unit2 = Unit.INSTANCE;
        boolean show = iBulletUIService.show(context, uri, uIShowConfig2);
        HybridLogger.i$default(HybridLogger.INSTANCE, "XRouter", "AnnieXUIService show result", MapsKt.mapOf(new Pair[]{TuplesKt.to(StrategyConstants.RESULT, Boolean.valueOf(show)), TuplesKt.to("scheme", uri.toString())}), (LoggerContext) null, 8, (Object) null);
        return show;
    }

    private final void doOptimiseTask(String currentBid, Uri currentUri) {
        String queryParameter = currentUri.getQueryParameter("enable_prefetch");
        if (Intrinsics.areEqual(queryParameter, DiskLruCache.VERSION) || Intrinsics.areEqual(queryParameter, "true")) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "AnnieXRouterService.doOptimiseTask, enablePrefetch, currentUri=" + currentUri, (LogLevel) null, (String) null, 6, (Object) null);
            BulletContext orCreateContext$default = BulletContextManager.getOrCreateContext$default(BulletContextManager.Companion.getInstance(), currentBid, currentUri, (Bundle) null, false, (SchemaConfig) null, 24, (Object) null);
            IPrefetchV2Service prefetchV2Service = IPrefetchV2ServiceKt.getPrefetchV2Service();
            if (prefetchV2Service != null) {
                prefetchV2Service.prefetch(currentUri, currentBid, orCreateContext$default);
                orCreateContext$default.setPrefetchUri(currentUri);
            }
        }
    }

    public final IContainer getAnnieXContainer$anniex_release(String containerId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        IContainer annieXPageContainer$anniex_release = AnnieXPageService.INSTANCE.getAnnieXPageContainer$anniex_release(containerId);
        return annieXPageContainer$anniex_release == null ? AnnieXPopUpService.INSTANCE.getAnnieXPopupContainer$anniex_release(containerId) : annieXPageContainer$anniex_release;
    }
}
