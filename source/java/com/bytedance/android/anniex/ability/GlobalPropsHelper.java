package com.bytedance.android.anniex.ability;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.MessageQueue;
import android.util.LruCache;
import androidx.webkit.ProxyConfig;
import bolts.Task;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXPropsProvider;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.utils.AnnieXSettings;
import com.bytedance.android.anniex.monitor.AnnieXCardErrorMonitor;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.device.BulletDeviceUtils;
import com.bytedance.ies.bullet.core.device.PropsUtilsKt;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.prefetchv2.PrefetchResult;
import com.bytedance.ies.bullet.prefetchv2.PrefetchV2;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IGlobalPropsInjectService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.schema.utils.SchemaUtilsKt;
import com.bytedance.sdk.xbridge.cn.info.ScreenUtils;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.TraceEvent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: GlobalPropsHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001=B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0007J&\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013H\u0003J \u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J,\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J6\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001d2\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013H\u0002J6\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002J\u001e\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J.\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J%\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0000¢\u0006\u0002\b&J+\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u001c\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010*\u001a\u00020+H\u0002J\u001c\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010$\u001a\u00020%H\u0002J4\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u0007J<\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u00072\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001dJ<\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\b\b\u0002\u0010/\u001a\u000200J\u0016\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013H\u0002J\b\u00102\u001a\u000203H\u0002J\u0012\u00104\u001a\u0002002\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0012\u00104\u001a\u0002002\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0006\u00105\u001a\u000203J\u0010\u00106\u001a\u0002032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J \u00107\u001a\u000203*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\"\u00108\u001a\u0004\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u00109\u001a\u00020\u001bH\u0002J\"\u0010:\u001a\u0004\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J1\u0010;\u001a\u0004\u0018\u000103*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010<R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/bytedance/android/anniex/ability/GlobalPropsHelper;", "", "()V", "activityLruCache", "Landroid/util/LruCache;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "", "commonPropsCache", "devicePropsCache", "taskIdleHandler", "Lcom/bytedance/android/anniex/ability/GlobalPropsHelper$GlobalPropsIdleHandler;", "urlPropsCache", "getCommonAppProps", "", "bid", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getCommonGlobalProps", "", "getCommonPageProps", "getDeviceProps", "getDevicePropsWithContext", "context", "Landroid/content/Context;", "getGlobalPropsForAppend", "uri", "Landroid/net/Uri;", "appendGlobalProps", "", "getKitType", "getLynxCommonProps", "getPageDynamicProps", "sessionId", "getPageGlobalPropsByActivity", "getPageGlobalPropsByApplication", "application", "Landroid/app/Application;", "getPageGlobalPropsByApplication$anniex_release", "getPropsProvider", "Lcom/bytedance/android/anniex/ability/service/IAnnieXPropsProvider;", "getScreenSize", "activity", "Landroid/app/Activity;", "getStaticGlobalProps", "getStaticGlobalPropsForAppend", "getUriGlobalProps", "useCache", "", "getWebCommonProps", "initBaseProps", "", "isLandscape", "postInitBaseProps", "removeGlobalPropsByActivity", "putPrefetchData", "putQueryItems", "input", "putSchemeItems", "putStorageGlobalProps", "(Ljava/util/Map;Landroid/net/Uri;Landroid/content/Context;)Lkotlin/Unit;", "GlobalPropsIdleHandler", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class GlobalPropsHelper {
    public static final GlobalPropsHelper INSTANCE = new GlobalPropsHelper();
    private static final ConcurrentHashMap<String, Object> devicePropsCache = new ConcurrentHashMap<>();
    private static final LruCache<String, ConcurrentHashMap<String, Object>> commonPropsCache = new LruCache<>(1024);
    private static final LruCache<Integer, ConcurrentHashMap<String, Object>> activityLruCache = new LruCache<>(1024);
    private static final LruCache<String, ConcurrentHashMap<String, Object>> urlPropsCache = new LruCache<>(1024);
    private static final GlobalPropsIdleHandler taskIdleHandler = new GlobalPropsIdleHandler();

    private GlobalPropsHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initBaseProps() {
        PropsUtilsKt.initDeviceProps$default((Context) null, 1, (Object) null);
        getCommonGlobalProps(KitType.LYNX, "default_bid");
        getCommonGlobalProps(KitType.WEB, "default_bid");
    }

    public static /* synthetic */ Map getStaticGlobalProps$default(GlobalPropsHelper globalPropsHelper, Uri uri, KitType kitType, String str, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = "";
        }
        return globalPropsHelper.getStaticGlobalProps(uri, kitType, str, str2);
    }

    public final Map<String, Object> getStaticGlobalProps(Uri uri, KitType kitType, String bid, String sessionId) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        initBaseProps();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        GlobalPropsHelper globalPropsHelper = INSTANCE;
        Map<String, Object> globalPropsForAppend = globalPropsHelper.getGlobalPropsForAppend(kitType, bid, uri);
        Map uriGlobalProps$default = getUriGlobalProps$default(globalPropsHelper, kitType, uri, bid, sessionId, false, 16, null);
        linkedHashMap.putAll(globalPropsForAppend);
        linkedHashMap.putAll(uriGlobalProps$default);
        return linkedHashMap;
    }

    public static /* synthetic */ Map getGlobalPropsForAppend$default(GlobalPropsHelper globalPropsHelper, String str, List list, Uri uri, int i, Object obj) {
        if ((i & 4) != 0) {
            uri = Uri.EMPTY;
            Intrinsics.checkNotNullExpressionValue(uri, "EMPTY");
        }
        return globalPropsHelper.getGlobalPropsForAppend(str, (List<String>) list, uri);
    }

    @Deprecated(message = "Use getStaticGlobalPropsForAppend instead")
    public final Map<String, String> getGlobalPropsForAppend(String bid, List<String> appendGlobalProps, Uri uri) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(uri, "uri");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, Object> globalPropsForAppend = getGlobalPropsForAppend(getKitType(uri), bid, uri);
        if (appendGlobalProps != null) {
            for (String str : appendGlobalProps) {
                Object obj = globalPropsForAppend.get(str);
                if (obj != null) {
                    linkedHashMap.put(str, obj.toString());
                }
            }
        }
        return linkedHashMap;
    }

    public static /* synthetic */ Map getStaticGlobalPropsForAppend$default(GlobalPropsHelper globalPropsHelper, Uri uri, String str, String str2, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return globalPropsHelper.getStaticGlobalPropsForAppend(uri, str, str2, list);
    }

    public final Map<String, Object> getStaticGlobalPropsForAppend(Uri uri, String bid, String sessionId, List<String> appendGlobalProps) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, Object> staticGlobalProps = getStaticGlobalProps(uri, getKitType(uri), bid, sessionId);
        if (appendGlobalProps != null) {
            for (String str : appendGlobalProps) {
                Object obj = staticGlobalProps.get(str);
                if (obj != null) {
                    linkedHashMap.put(str, obj);
                }
            }
        }
        return linkedHashMap;
    }

    private final KitType getKitType(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme != null) {
            int hashCode = scheme.hashCode();
            if (hashCode != -1772600516) {
                if (hashCode != 3213448) {
                    if (hashCode == 99617003 && scheme.equals(ProxyConfig.MATCH_HTTPS)) {
                        return KitType.WEB;
                    }
                } else if (scheme.equals("http")) {
                    return KitType.WEB;
                }
            } else if (scheme.equals("lynxview")) {
                return KitType.LYNX;
            }
        }
        return KitType.UNKNOWN;
    }

    private final Map<String, Object> getGlobalPropsForAppend(KitType kitType, String bid, Uri uri) {
        Object obj;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        GlobalPropsHelper globalPropsHelper = INSTANCE;
        linkedHashMap.putAll(globalPropsHelper.getCommonGlobalProps(kitType, bid));
        IAnnieXBizPropsProvider iAnnieXBizPropsProvider = (IAnnieXBizPropsProvider) AnnieX.INSTANCE.getService(bid, IAnnieXBizPropsProvider.class);
        if (iAnnieXBizPropsProvider != null) {
            iAnnieXBizPropsProvider.assembleBizProps(linkedHashMap, kitType, bid, uri);
        }
        Map<String, Object> pageGlobalPropsByApplication$anniex_release = globalPropsHelper.getPageGlobalPropsByApplication$anniex_release(BulletEnv.Companion.getInstance().getApplication());
        if (pageGlobalPropsByApplication$anniex_release != null) {
            linkedHashMap.putAll(pageGlobalPropsByApplication$anniex_release);
            if (Intrinsics.areEqual(bid, "webcast") && (obj = pageGlobalPropsByApplication$anniex_release.get("statusBarHeight")) != null) {
                linkedHashMap.put("status_bar_height", obj);
            }
        }
        return linkedHashMap;
    }

    public static /* synthetic */ Map getUriGlobalProps$default(GlobalPropsHelper globalPropsHelper, KitType kitType, Uri uri, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        return globalPropsHelper.getUriGlobalProps(kitType, uri, str, str2, z);
    }

    public final void postInitBaseProps() {
        Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.ability.GlobalPropsHelper$postInitBaseProps$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                TraceEvent.beginSection("GlobalPropsIdleHandler:queueIdle");
                try {
                    GlobalPropsHelper.INSTANCE.initBaseProps();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    TraceEvent.endSection("GlobalPropsIdleHandler:queueIdle");
                }
            }
        });
    }

    public final void removeGlobalPropsByActivity(Context context) {
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        activityLruCache.remove(Integer.valueOf(context.hashCode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getScreenSize(Activity activity) {
        int min;
        int max;
        Activity activity2 = activity;
        int screenWidth = BulletDeviceUtils.INSTANCE.getScreenWidth(activity2);
        int screenHeight = BulletDeviceUtils.INSTANCE.getScreenHeight(activity2);
        if (screenWidth == 0 || screenHeight == 0) {
            HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", "getScreenSize exp width:" + screenWidth + ", height: " + screenHeight, (Map) null, (LoggerContext) null, 12, (Object) null);
            Boolean valueOf = Boolean.valueOf(activity.getResources().getConfiguration().orientation == 2);
            int screenWidth2 = ScreenUtils.INSTANCE.getScreenWidth(activity2);
            int screenHeight2 = ScreenUtils.INSTANCE.getScreenHeight(activity2);
            if (Intrinsics.areEqual(valueOf, true)) {
                min = Math.max(screenWidth2, screenHeight2);
                max = Math.min(screenWidth2, screenHeight2);
            } else {
                min = Math.min(screenWidth2, screenHeight2);
                max = Math.max(screenWidth2, screenHeight2);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("screenWidth", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(min, activity2)));
            linkedHashMap.put("screenHeight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(max, activity2)));
            linkedHashMap.put("screenWidthPx", Integer.valueOf(min));
            linkedHashMap.put("screenHeightPx", Integer.valueOf(max));
            linkedHashMap.put("orientation", Integer.valueOf(INSTANCE.isLandscape(activity) ? 1 : 0));
            return linkedHashMap;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("screenWidth", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(screenWidth, activity2)));
        linkedHashMap2.put("screenHeight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(screenHeight, activity2)));
        linkedHashMap2.put("screenWidthPx", Integer.valueOf(screenWidth));
        linkedHashMap2.put("screenHeightPx", Integer.valueOf(screenHeight));
        linkedHashMap2.put("orientation", Integer.valueOf(INSTANCE.isLandscape(activity) ? 1 : 0));
        return linkedHashMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getScreenSize(Application application) {
        int min;
        int max;
        Application application2 = application;
        int screenWidth = BulletDeviceUtils.INSTANCE.getScreenWidth(application2);
        int screenHeight = BulletDeviceUtils.INSTANCE.getScreenHeight(application2);
        if (screenWidth == 0 || screenHeight == 0) {
            HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", "getScreenSize exp width:" + screenWidth + ", height: " + screenHeight, (Map) null, (LoggerContext) null, 12, (Object) null);
            Boolean valueOf = Boolean.valueOf(application.getResources().getConfiguration().orientation == 2);
            int screenWidth2 = ScreenUtils.INSTANCE.getScreenWidth(application2);
            int screenHeight2 = ScreenUtils.INSTANCE.getScreenHeight(application2);
            if (Intrinsics.areEqual(valueOf, true)) {
                min = Math.max(screenWidth2, screenHeight2);
                max = Math.min(screenWidth2, screenHeight2);
            } else {
                min = Math.min(screenWidth2, screenHeight2);
                max = Math.max(screenWidth2, screenHeight2);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("screenWidth", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(min, application2)));
            linkedHashMap.put("screenHeight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(max, application2)));
            linkedHashMap.put("screenWidthPx", Integer.valueOf(min));
            linkedHashMap.put("screenHeightPx", Integer.valueOf(max));
            linkedHashMap.put("orientation", Integer.valueOf(INSTANCE.isLandscape(application) ? 1 : 0));
            return linkedHashMap;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("screenWidth", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(screenWidth, application2)));
        linkedHashMap2.put("screenHeight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(screenHeight, application2)));
        linkedHashMap2.put("screenWidthPx", Integer.valueOf(screenWidth));
        linkedHashMap2.put("screenHeightPx", Integer.valueOf(screenHeight));
        linkedHashMap2.put("orientation", Integer.valueOf(INSTANCE.isLandscape(application) ? 1 : 0));
        return linkedHashMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAnnieXPropsProvider getPropsProvider(String bid) {
        if (AnnieXSettings.INSTANCE.getOptimizeBulletInit()) {
            return (IAnnieXPropsProvider) AnnieXServiceCenter.INSTANCE.getService(bid, IAnnieXPropsProvider.class);
        }
        IAnnieXPropsProvider iAnnieXPropsProvider = (IAnnieXPropsProvider) AnnieX.INSTANCE.getService(bid, IAnnieXPropsProvider.class);
        return iAnnieXPropsProvider == null ? (IAnnieXPropsProvider) ServiceCenter.Companion.instance().get(bid, IAnnieXPropsProvider.class) : iAnnieXPropsProvider;
    }

    private final boolean isLandscape(Activity activity) {
        Integer valueOf = activity != null ? Integer.valueOf(activity.getRequestedOrientation()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            return true;
        }
        if (valueOf != null && valueOf.intValue() == 8) {
            return true;
        }
        return valueOf != null && valueOf.intValue() == 6;
    }

    private final boolean isLandscape(Application application) {
        Resources resources;
        Configuration configuration;
        Integer valueOf = (application == null || (resources = application.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? null : Integer.valueOf(configuration.orientation);
        if (valueOf != null && valueOf.intValue() == 0) {
            return true;
        }
        if (valueOf != null && valueOf.intValue() == 8) {
            return true;
        }
        return valueOf != null && valueOf.intValue() == 6;
    }

    /* compiled from: GlobalPropsHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anniex/ability/GlobalPropsHelper$GlobalPropsIdleHandler;", "Landroid/os/MessageQueue$IdleHandler;", "()V", "queueIdle", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private static final class GlobalPropsIdleHandler implements MessageQueue.IdleHandler {
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            TraceEvent.beginSection("GlobalPropsIdleHandler:queueIdle");
            try {
                GlobalPropsHelper.INSTANCE.initBaseProps();
                TraceEvent.endSection("GlobalPropsIdleHandler:queueIdle");
                return false;
            } catch (Throwable th) {
                TraceEvent.endSection("GlobalPropsIdleHandler:queueIdle");
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005d A[Catch: all -> 0x00dc, TryCatch #0 {all -> 0x00dc, blocks: (B:3:0x000f, B:5:0x0051, B:10:0x005d, B:12:0x007c, B:13:0x007f, B:15:0x0085, B:16:0x0088, B:19:0x0097, B:21:0x00a4, B:22:0x00a7, B:24:0x00ab, B:26:0x00b1, B:27:0x00c2, B:28:0x00b5, B:30:0x00b9, B:32:0x00bf, B:33:0x00c7), top: B:2:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, Object> getCommonGlobalProps(KitType kitType, String bid) {
        boolean z;
        Map webCommonProps;
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        Intrinsics.checkNotNullParameter(bid, "bid");
        TraceEvent.beginSection("GlobalPropsHelper:getCommonGlobalProps");
        try {
            String str = bid + '_' + kitType.getTag();
            Map map = (Map) commonPropsCache.get(bid + '_' + kitType.getTag());
            if (map != null && !map.isEmpty()) {
                z = false;
                if (z) {
                    LruCache lruCache = commonPropsCache;
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", "getCommonGlobalProps withoutCache", (Map) null, (LoggerContext) null, 12, (Object) null);
                    GlobalPropsHelper globalPropsHelper = INSTANCE;
                    Map deviceProps = globalPropsHelper.getDeviceProps();
                    if (deviceProps != null) {
                        concurrentHashMap.putAll(deviceProps);
                    }
                    Map commonAppProps = globalPropsHelper.getCommonAppProps(bid, kitType);
                    if (commonAppProps != null) {
                        concurrentHashMap.putAll(commonAppProps);
                    }
                    concurrentHashMap.put("isPreInstallApp", Integer.valueOf(AnnieXRuntime.INSTANCE.getApplicationDepend().isPreInstallApp() ? 1 : 0));
                    Map commonPageProps = globalPropsHelper.getCommonPageProps(bid, kitType);
                    if (commonPageProps != null) {
                        concurrentHashMap.putAll(commonPageProps);
                    }
                    if (kitType == KitType.LYNX) {
                        Map lynxCommonProps = globalPropsHelper.getLynxCommonProps();
                        if (lynxCommonProps != null) {
                            concurrentHashMap.putAll(lynxCommonProps);
                        }
                    } else if (kitType == KitType.WEB && (webCommonProps = globalPropsHelper.getWebCommonProps()) != null) {
                        concurrentHashMap.putAll(webCommonProps);
                    }
                    Unit unit = Unit.INSTANCE;
                    lruCache.put(str, concurrentHashMap);
                }
                Object obj = commonPropsCache.get(str);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
                return TypeIntrinsics.asMutableMap(obj);
            }
            z = true;
            if (z) {
            }
            Object obj2 = commonPropsCache.get(str);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
            return TypeIntrinsics.asMutableMap(obj2);
        } finally {
            TraceEvent.endSection("GlobalPropsHelper:getCommonGlobalProps");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[Catch: all -> 0x009a, TryCatch #0 {all -> 0x009a, blocks: (B:3:0x001b, B:5:0x0031, B:12:0x0040, B:16:0x004b, B:18:0x0058, B:19:0x005b, B:21:0x007f, B:23:0x0087), top: B:2:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f A[Catch: all -> 0x009a, TryCatch #0 {all -> 0x009a, blocks: (B:3:0x001b, B:5:0x0031, B:12:0x0040, B:16:0x004b, B:18:0x0058, B:19:0x005b, B:21:0x007f, B:23:0x0087), top: B:2:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0087 A[Catch: all -> 0x009a, TRY_LEAVE, TryCatch #0 {all -> 0x009a, blocks: (B:3:0x001b, B:5:0x0031, B:12:0x0040, B:16:0x004b, B:18:0x0058, B:19:0x005b, B:21:0x007f, B:23:0x0087), top: B:2:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, Object> getUriGlobalProps(KitType kitType, Uri uri, String bid, String sessionId, boolean useCache) {
        boolean z;
        Map pageDynamicProps;
        ConcurrentHashMap concurrentHashMap;
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        TraceEvent.beginSection("GlobalPropsHelper:getUriGlobalProps");
        try {
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            Map map = (Map) urlPropsCache.get(uri2);
            if (map != null && !map.isEmpty()) {
                z = false;
                if (!z && useCache) {
                    concurrentHashMap = (ConcurrentHashMap) urlPropsCache.get(uri2);
                    TraceEvent.endSection("GlobalPropsHelper:getUriGlobalProps");
                    Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "lynxTrace(GET_URI_GLOBAL….get(key)\n        }\n    }");
                    return concurrentHashMap;
                }
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                GlobalPropsHelper globalPropsHelper = INSTANCE;
                pageDynamicProps = globalPropsHelper.getPageDynamicProps(kitType, uri, bid, sessionId);
                if (pageDynamicProps != null) {
                    concurrentHashMap2.putAll(pageDynamicProps);
                }
                globalPropsHelper.putSchemeItems(concurrentHashMap2, uri);
                globalPropsHelper.putQueryItems(concurrentHashMap2, uri);
                globalPropsHelper.putStorageGlobalProps(concurrentHashMap2, uri, BulletEnv.Companion.getInstance().getApplication());
                if (IConditionCallKt.enablePrefetchDataGlobalProps()) {
                    globalPropsHelper.putPrefetchData(concurrentHashMap2, uri);
                }
                if (useCache) {
                    urlPropsCache.put(uri2, concurrentHashMap2);
                }
                concurrentHashMap = concurrentHashMap2;
                TraceEvent.endSection("GlobalPropsHelper:getUriGlobalProps");
                Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "lynxTrace(GET_URI_GLOBAL….get(key)\n        }\n    }");
                return concurrentHashMap;
            }
            z = true;
            if (!z) {
                concurrentHashMap = (ConcurrentHashMap) urlPropsCache.get(uri2);
                TraceEvent.endSection("GlobalPropsHelper:getUriGlobalProps");
                Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "lynxTrace(GET_URI_GLOBAL….get(key)\n        }\n    }");
                return concurrentHashMap;
            }
            ConcurrentHashMap concurrentHashMap22 = new ConcurrentHashMap();
            GlobalPropsHelper globalPropsHelper2 = INSTANCE;
            pageDynamicProps = globalPropsHelper2.getPageDynamicProps(kitType, uri, bid, sessionId);
            if (pageDynamicProps != null) {
            }
            globalPropsHelper2.putSchemeItems(concurrentHashMap22, uri);
            globalPropsHelper2.putQueryItems(concurrentHashMap22, uri);
            globalPropsHelper2.putStorageGlobalProps(concurrentHashMap22, uri, BulletEnv.Companion.getInstance().getApplication());
            if (IConditionCallKt.enablePrefetchDataGlobalProps()) {
            }
            if (useCache) {
            }
            concurrentHashMap = concurrentHashMap22;
            TraceEvent.endSection("GlobalPropsHelper:getUriGlobalProps");
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "lynxTrace(GET_URI_GLOBAL….get(key)\n        }\n    }");
            return concurrentHashMap;
        } catch (Throwable th) {
            TraceEvent.endSection("GlobalPropsHelper:getUriGlobalProps");
            throw th;
        }
    }

    public final Map<String, Object> getPageGlobalPropsByActivity(String bid, KitType kitType, Context context) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        TraceEvent.beginSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        try {
            IAnnieXPropsProvider propsProvider = INSTANCE.getPropsProvider(bid);
            return propsProvider != null ? propsProvider.getPropsByActivity(bid, kitType, context) : null;
        } finally {
            TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, Object> getPageGlobalPropsByActivity(Context context) {
        ConcurrentHashMap concurrentHashMap;
        Map devicePropsWithContext;
        TraceEvent.beginSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        if (context != null) {
            try {
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    int i = 1;
                    boolean z = true;
                    if (activityLruCache.get(Integer.valueOf(activity.hashCode())) != null) {
                        concurrentHashMap = (ConcurrentHashMap) activityLruCache.get(Integer.valueOf(activity.hashCode()));
                    } else {
                        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                        GlobalPropsHelper globalPropsHelper = INSTANCE;
                        concurrentHashMap2.putAll(globalPropsHelper.getScreenSize(activity));
                        concurrentHashMap2.put("statusBarHeight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(BulletDeviceUtils.INSTANCE.getStatusBarHeight(activity), activity)));
                        concurrentHashMap2.putAll(PropsUtilsKt.getPageCommonProps(activity));
                        if ((activity.getResources().getConfiguration().orientation == 2) == false) {
                            i = 0;
                        }
                        concurrentHashMap2.put("isLandscape", Integer.valueOf(i));
                        if (IConditionCallKt.enableDevicePropsRollBack() && (devicePropsWithContext = globalPropsHelper.getDevicePropsWithContext(context)) != null) {
                            concurrentHashMap2.putAll(devicePropsWithContext);
                        }
                        activityLruCache.put(Integer.valueOf(activity.hashCode()), concurrentHashMap2);
                        concurrentHashMap = concurrentHashMap2;
                        z = false;
                    }
                    if (IConditionCallKt.annieXFixActivityDynamicProps()) {
                        concurrentHashMap.putAll(PropsUtilsKt.getPageDynamicProps(context));
                    }
                    if (concurrentHashMap.get("screenWidth") == null || Intrinsics.areEqual(concurrentHashMap.get("screenWidth"), 0)) {
                        String str = "getScreenWidth exp, is by cache :" + z;
                        HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", str, (Map) null, (LoggerContext) null, 12, (Object) null);
                        AnnieXCardErrorMonitor.INSTANCE.reportGlobalPropsError(str);
                    }
                    TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
                    return concurrentHashMap;
                }
            } catch (Throwable th) {
                TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
                throw th;
            }
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", "getPageGlobalPropsByActivity exp: context is not activity", (Map) null, (LoggerContext) null, 12, (Object) null);
        AnnieXCardErrorMonitor.INSTANCE.reportGlobalPropsError("getPageGlobalPropsByActivity exp: context is not activity");
        concurrentHashMap = null;
        TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        return concurrentHashMap;
    }

    public final Map<String, Object> getPageGlobalPropsByApplication$anniex_release(String bid, Application application) {
        LinkedHashMap pageGlobalPropsByApplication$anniex_release;
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(application, "application");
        TraceEvent.beginSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        try {
            if (Intrinsics.areEqual(bid, "webcast")) {
                Map<String, Object> pageGlobalPropsByApplication$anniex_release2 = INSTANCE.getPageGlobalPropsByApplication$anniex_release(application);
                if (pageGlobalPropsByApplication$anniex_release2 != null) {
                    Object obj = pageGlobalPropsByApplication$anniex_release2.get("statusBarHeight");
                    Object obj2 = pageGlobalPropsByApplication$anniex_release2.get("screenWidth");
                    Object obj3 = pageGlobalPropsByApplication$anniex_release2.get("screenHeight");
                    Object obj4 = pageGlobalPropsByApplication$anniex_release2.get("safeAreaHeight");
                    pageGlobalPropsByApplication$anniex_release = new LinkedHashMap();
                    pageGlobalPropsByApplication$anniex_release.putAll(pageGlobalPropsByApplication$anniex_release2);
                    if (obj != null) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                        pageGlobalPropsByApplication$anniex_release.put("statusBarHeight", Float.valueOf(((Integer) obj).intValue()));
                        pageGlobalPropsByApplication$anniex_release.put("status_bar_height", Float.valueOf(((Integer) obj).intValue()));
                    }
                    if (obj2 != null) {
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                        pageGlobalPropsByApplication$anniex_release.put("screenWidth", Float.valueOf(((Integer) obj2).intValue()));
                    }
                    if (obj3 != null) {
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                        pageGlobalPropsByApplication$anniex_release.put("screenHeight", Float.valueOf(((Integer) obj3).intValue()));
                    }
                    if (obj4 != null) {
                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
                        pageGlobalPropsByApplication$anniex_release.put("safeAreaHeight", Float.valueOf(((Integer) obj4).intValue()));
                    }
                } else {
                    pageGlobalPropsByApplication$anniex_release = null;
                }
            } else {
                pageGlobalPropsByApplication$anniex_release = INSTANCE.getPageGlobalPropsByApplication$anniex_release(application);
            }
            return pageGlobalPropsByApplication$anniex_release;
        } finally {
            TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, Object> getPageGlobalPropsByApplication$anniex_release(Application application) {
        ConcurrentHashMap concurrentHashMap;
        Map devicePropsWithContext;
        TraceEvent.beginSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        try {
            if (application != null) {
                int i = 1;
                boolean z = true;
                if (activityLruCache.get(Integer.valueOf(application.hashCode())) != null) {
                    concurrentHashMap = (ConcurrentHashMap) activityLruCache.get(Integer.valueOf(application.hashCode()));
                } else {
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    GlobalPropsHelper globalPropsHelper = INSTANCE;
                    concurrentHashMap2.putAll(globalPropsHelper.getScreenSize(application));
                    concurrentHashMap2.put("statusBarHeight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(BulletDeviceUtils.INSTANCE.getStatusBarHeight(application), application)));
                    concurrentHashMap2.putAll(PropsUtilsKt.getPageCommonProps(application));
                    Object obj = concurrentHashMap2.get("contentHeight");
                    if (obj != null) {
                        concurrentHashMap2.put("safeAreaHeight", obj);
                    }
                    if ((application.getResources().getConfiguration().orientation == 2) == false) {
                        i = 0;
                    }
                    concurrentHashMap2.put("isLandscape", Integer.valueOf(i));
                    if (IConditionCallKt.enableDevicePropsRollBack() && (devicePropsWithContext = globalPropsHelper.getDevicePropsWithContext(application)) != null) {
                        concurrentHashMap2.putAll(devicePropsWithContext);
                    }
                    activityLruCache.put(Integer.valueOf(application.hashCode()), concurrentHashMap2);
                    concurrentHashMap = concurrentHashMap2;
                    z = false;
                }
                if (concurrentHashMap.get("screenWidth") == null || Intrinsics.areEqual(concurrentHashMap.get("screenWidth"), 0)) {
                    String str = "getScreenWidth exp, is by cache :" + z;
                    HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", str, (Map) null, (LoggerContext) null, 12, (Object) null);
                    AnnieXCardErrorMonitor.INSTANCE.reportGlobalPropsError(str);
                }
            } else {
                HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", "getPageGlobalPropsByActivity exp: context is not activity", (Map) null, (LoggerContext) null, 12, (Object) null);
                AnnieXCardErrorMonitor.INSTANCE.reportGlobalPropsError("getPageGlobalPropsByActivity exp: context is not activity");
                concurrentHashMap = null;
            }
            TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
            return concurrentHashMap;
        } catch (Throwable th) {
            TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated(message = "废弃", replaceWith = @ReplaceWith(expression = "getDeviceProps(context)", imports = {}))
    public final Map<String, Object> getDeviceProps() {
        ConcurrentHashMap concurrentHashMap;
        TraceEvent.beginSection("GlobalPropsHelper:getDeviceProps");
        try {
            if (!devicePropsCache.isEmpty()) {
                concurrentHashMap = devicePropsCache;
            } else {
                PropsUtilsKt.initDeviceProps$default((Context) null, 1, (Object) null);
                if (BulletEnv.Companion.getInstance().getApplication() != null) {
                    ConcurrentHashMap concurrentHashMap2 = devicePropsCache;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.putAll(PropsUtilsKt.getCacheProps());
                    concurrentHashMap2.putAll(linkedHashMap);
                }
                concurrentHashMap = devicePropsCache;
            }
            TraceEvent.endSection("GlobalPropsHelper:getDeviceProps");
            return concurrentHashMap;
        } catch (Throwable th) {
            TraceEvent.endSection("GlobalPropsHelper:getDeviceProps");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getDevicePropsWithContext(Context context) {
        ConcurrentHashMap concurrentHashMap;
        TraceEvent.beginSection("GlobalPropsHelper:getDeviceProps");
        try {
            if (!devicePropsCache.isEmpty()) {
                concurrentHashMap = devicePropsCache;
            } else {
                PropsUtilsKt.initDeviceProps(context);
                if (context != null) {
                    ConcurrentHashMap concurrentHashMap2 = devicePropsCache;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.putAll(PropsUtilsKt.getCacheProps());
                    concurrentHashMap2.putAll(linkedHashMap);
                }
                concurrentHashMap = devicePropsCache;
            }
            TraceEvent.endSection("GlobalPropsHelper:getDeviceProps");
            return concurrentHashMap;
        } catch (Throwable th) {
            TraceEvent.endSection("GlobalPropsHelper:getDeviceProps");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getCommonAppProps(String bid, KitType kitType) {
        LinkedHashMap linkedHashMap;
        TraceEvent.beginSection("GlobalPropsHelper:getCommonAppProps");
        try {
            IAnnieXPropsProvider propsProvider = INSTANCE.getPropsProvider(bid);
            if (propsProvider != null) {
                linkedHashMap = propsProvider.getAppCommonProps(bid, kitType);
            } else {
                linkedHashMap = new LinkedHashMap();
            }
            return linkedHashMap;
        } finally {
            TraceEvent.endSection("GlobalPropsHelper:getCommonAppProps");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getCommonPageProps(String bid, KitType kitType) {
        LinkedHashMap linkedHashMap;
        int min;
        int max;
        TraceEvent.beginSection("GlobalPropsHelper:getCommonPageProps");
        try {
            IAnnieXPropsProvider propsProvider = INSTANCE.getPropsProvider(bid);
            if (propsProvider != null) {
                HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", "getCommonPageProps by provider bid:" + bid + ", kitType:" + kitType.getTag(), (Map) null, (LoggerContext) null, 12, (Object) null);
                linkedHashMap = new LinkedHashMap();
                Application application = BulletEnv.Companion.getInstance().getApplication();
                if (application != null) {
                    linkedHashMap.put("isLandscape", Integer.valueOf(application.getResources().getConfiguration().orientation == 2 ? 1 : 0));
                }
                Map<String, Object> pageCommonProps = propsProvider.getPageCommonProps(bid, kitType);
                if (pageCommonProps != null) {
                    linkedHashMap.putAll(pageCommonProps);
                }
            } else {
                HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", "getCommonPageProps by reveal bid:" + bid + ", kitType:" + kitType.getTag(), (Map) null, (LoggerContext) null, 12, (Object) null);
                linkedHashMap = new LinkedHashMap();
                Application application2 = BulletEnv.Companion.getInstance().getApplication();
                if (application2 != null) {
                    linkedHashMap.putAll(PropsUtilsKt.getPageCommonProps(BulletEnv.Companion.getInstance().getApplication()));
                    int px2dip = UIUtils.INSTANCE.px2dip(application2, ScreenUtils.INSTANCE.getStatusBarHeight());
                    Boolean valueOf = Boolean.valueOf(application2.getResources().getConfiguration().orientation == 2);
                    int px2dip2 = UIUtils.INSTANCE.px2dip(application2, ScreenUtils.INSTANCE.getScreenWidth(application2));
                    int px2dip3 = UIUtils.INSTANCE.px2dip(application2, ScreenUtils.INSTANCE.getScreenHeight(application2));
                    if (Intrinsics.areEqual(valueOf, true)) {
                        min = Math.max(px2dip2, px2dip3);
                        max = Math.min(px2dip2, px2dip3);
                    } else {
                        min = Math.min(px2dip2, px2dip3);
                        max = Math.max(px2dip2, px2dip3);
                    }
                    linkedHashMap.put("screenWidth", Integer.valueOf(min));
                    linkedHashMap.put("screenHeight", Integer.valueOf(max));
                    linkedHashMap.put("statusBarHeight", Integer.valueOf(px2dip));
                    linkedHashMap.put("topHeight", Integer.valueOf(px2dip));
                    linkedHashMap.put("isLandscape", Integer.valueOf(valueOf.booleanValue() ? 1 : 0));
                }
            }
            return linkedHashMap;
        } finally {
            TraceEvent.endSection("GlobalPropsHelper:getCommonPageProps");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getPageDynamicProps(KitType kitType, Uri uri, String bid, String sessionId) {
        LinkedHashMap linkedHashMap;
        TraceEvent.beginSection("GlobalPropsHelper:getPageDynamicProps");
        try {
            IAnnieXPropsProvider propsProvider = INSTANCE.getPropsProvider(bid);
            if (propsProvider != null) {
                linkedHashMap = propsProvider.getPageDynamicProps(bid, kitType, uri, sessionId);
            } else {
                linkedHashMap = new LinkedHashMap();
            }
            return linkedHashMap;
        } finally {
            TraceEvent.endSection("GlobalPropsHelper:getPageDynamicProps");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Unit putStorageGlobalProps(Map<String, Object> map, Uri uri, Context context) {
        Map userDomainStorageValues;
        Map<? extends String, ? extends Object> map2;
        Map storageValues;
        Map<? extends String, ? extends Object> map3;
        TraceEvent.beginSection("GlobalPropsHelper:putStorageGlobalProps");
        Unit unit = null;
        if (context != null) {
            try {
                IGlobalPropsInjectService iGlobalPropsInjectService = (IGlobalPropsInjectService) StandardServiceManager.INSTANCE.get(IGlobalPropsInjectService.class);
                if (iGlobalPropsInjectService != null && (storageValues = iGlobalPropsInjectService.getStorageValues(uri, context)) != null && (map3 = MapsKt.toMap(storageValues)) != null) {
                    map.put("bulletStorageValues", map3);
                    map.putAll(map3);
                }
                if (iGlobalPropsInjectService != null && (userDomainStorageValues = iGlobalPropsInjectService.getUserDomainStorageValues(uri, context)) != null && (map2 = MapsKt.toMap(userDomainStorageValues)) != null) {
                    map.put("userDomainStorageValues", map2);
                    map.putAll(map2);
                    unit = Unit.INSTANCE;
                }
            } finally {
                TraceEvent.endSection("GlobalPropsHelper:putStorageGlobalProps");
            }
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object putSchemeItems(Map<String, Object> map, Uri uri) {
        TraceEvent.beginSection("GlobalPropsHelper:putSchemeItems");
        try {
            String queryParameterSafely = SchemaUtilsKt.getQueryParameterSafely(uri, "font_scale");
            if (queryParameterSafely != null) {
                map.put("fontScale", Float.valueOf(Float.parseFloat(queryParameterSafely)));
                map.put("font_scale", Float.valueOf(Float.parseFloat(queryParameterSafely)));
            }
            String queryParameterSafely2 = SchemaUtilsKt.getQueryParameterSafely(uri, "view_zoom");
            return queryParameterSafely2 != null ? map.put("viewZoom", Float.valueOf(Float.parseFloat(queryParameterSafely2))) : null;
        } finally {
            TraceEvent.endSection("GlobalPropsHelper:putSchemeItems");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object putQueryItems(Map<String, Object> map, Uri uri) {
        TraceEvent.beginSection("GlobalPropsHelper:putQueryItems");
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            Intrinsics.checkNotNullExpressionValue(queryParameterNames, "input.queryParameterNames");
            for (String str : queryParameterNames) {
                Intrinsics.checkNotNullExpressionValue(str, "key");
                linkedHashMap.put(str, uri.getQueryParameter(str));
            }
            return map.put("queryItems", linkedHashMap);
        } finally {
            TraceEvent.endSection("GlobalPropsHelper:putQueryItems");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getLynxCommonProps() {
        TraceEvent.beginSection("GlobalPropsHelper:getLynxCommonProps");
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String lynxVersion = LynxEnv.inst().getLynxVersion();
            Intrinsics.checkNotNullExpressionValue(lynxVersion, "inst().lynxVersion");
            linkedHashMap.put("lynxSdkVersion", lynxVersion);
            return linkedHashMap;
        } finally {
            TraceEvent.endSection("GlobalPropsHelper:getLynxCommonProps");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getWebCommonProps() {
        TraceEvent.beginSection("GlobalPropsHelper:getWebCommonProps");
        try {
            return new LinkedHashMap();
        } finally {
            TraceEvent.endSection("GlobalPropsHelper:getWebCommonProps");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void putPrefetchData(Map<String, Object> map, Uri uri) {
        TraceEvent.beginSection("GlobalPropsHelper:putGlobalProps");
        try {
            boolean z = false;
            List<PrefetchResult> cacheBySchemaUri$default = PrefetchV2.getCacheBySchemaUri$default(PrefetchV2.INSTANCE, uri, false, 2, (Object) null);
            if (cacheBySchemaUri$default != null && (!cacheBySchemaUri$default.isEmpty())) {
                z = true;
            }
            if (z) {
                for (PrefetchResult prefetchResult : cacheBySchemaUri$default) {
                    String globalPropsName = prefetchResult.getGlobalPropsName();
                    if (globalPropsName != null && LoaderUtil.INSTANCE.isNotNullOrEmpty(globalPropsName) && prefetchResult.getBody() != null) {
                        map.put(globalPropsName, String.valueOf(prefetchResult.getBody()));
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("GlobalPropsHelper:putGlobalProps");
        }
    }
}
