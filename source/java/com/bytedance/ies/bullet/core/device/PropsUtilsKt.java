package com.bytedance.ies.bullet.core.device;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.ies.bullet.base.constants.GlobalPropertiesConstants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.util.ContextUtil;
import com.bytedance.ies.bullet.p003ui.common.utils.BulletPadAdapterUtil;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceCenter;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: PropsUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a \u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007\u001a4\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007\u001a\u001e\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007\u001a&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0007H\u0007\u001a\u001e\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\u001a\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0014\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\u001a*\u0010\u0018\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002\"\u001d\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001d"}, d2 = {"cacheProps", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getCacheProps", "()Ljava/util/concurrent/ConcurrentHashMap;", "checkGLES30Support", "", "context", "Landroid/content/Context;", "getContainerProps", "", "getDeviceProps", "", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getPageCommonProps", "withSafeAreaHeight", "getPageDynamicProps", "getSlardarModelWithBrand", "initDeviceProps", "", "reportDeviceParamsCost", "startTime", "", "endTime", "enableGlobalPropsCacheOpt", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PropsUtilsKt {
    private static final ConcurrentHashMap<String, Object> cacheProps = new ConcurrentHashMap<>();

    public static final ConcurrentHashMap<String, Object> getCacheProps() {
        return cacheProps;
    }

    public static /* synthetic */ void initDeviceProps$default(Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        initDeviceProps(context);
    }

    public static final void initDeviceProps(Context context) {
        ConcurrentHashMap<String, Object> concurrentHashMap = cacheProps;
        if (concurrentHashMap.isEmpty()) {
            if (context == null) {
                context = BulletEnv.INSTANCE.getInstance().getApplication();
            }
            if (context != null) {
                boolean checkGLES30Support = checkGLES30Support(context);
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "getDeviceProps: isGLES3Support=" + checkGLES30Support, null, null, 6, null);
                concurrentHashMap.put("deviceModel", BulletDeviceUtils.INSTANCE.getModel());
                concurrentHashMap.put("os", "android");
                concurrentHashMap.put("osVersion", BulletDeviceUtils.INSTANCE.getSystem());
                concurrentHashMap.put("language", BulletDeviceUtils.INSTANCE.getLanguage());
                concurrentHashMap.put("deviceBrand", BulletDeviceUtils.INSTANCE.getBrand());
                concurrentHashMap.put("glesVer", Integer.valueOf(BulletDeviceUtils.INSTANCE.getGLESVersion(context)));
                concurrentHashMap.put("is32", Integer.valueOf(BulletDeviceUtils.INSTANCE.is32() ? 1 : 0));
                concurrentHashMap.put("density", Float.valueOf(BulletDeviceUtils.INSTANCE.getDensity(context)));
                concurrentHashMap.put("isAccessable", Integer.valueOf(BulletDeviceUtils.INSTANCE.isAccessible(context) ? 1 : 0));
                concurrentHashMap.put("deviceType", Build.MODEL);
                concurrentHashMap.put("isGLES3Support", Boolean.valueOf(checkGLES30Support));
                concurrentHashMap.put("slardarModel", getSlardarModelWithBrand());
                concurrentHashMap.put("isFoldableDevice", Integer.valueOf(AnnieXRuntime.INSTANCE.getDeviceDepend().isFold() ? 1 : 0));
                if (AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) {
                    String foldType = AnnieXRuntime.INSTANCE.getDeviceDepend().getFoldType();
                    if (!(foldType.length() > 0)) {
                        foldType = null;
                    }
                    if (foldType != null) {
                        concurrentHashMap.put("screenFoldType", foldType);
                    }
                }
            }
        }
    }

    public static /* synthetic */ Map getDeviceProps$default(KitType kitType, Context context, BulletContext bulletContext, int i, Object obj) {
        if ((i & 2) != 0) {
            context = BulletEnv.INSTANCE.getInstance().getApplication();
        }
        return getDeviceProps(kitType, context, bulletContext);
    }

    public static final Map<String, Object> getDeviceProps(KitType kitType, Context context, BulletContext bulletContext) {
        LinkedHashMap mutableMapOf;
        int i;
        int i2;
        BulletSettings provideBulletSettings;
        BulletSettings provideBulletSettings2;
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        if (context == null) {
            return null;
        }
        BulletDeviceUtils.INSTANCE.setCacheDensity(context.getResources().getDisplayMetrics().density);
        long currentTimeMillis = System.currentTimeMillis();
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        boolean enableGlobalPropsCacheOptimize = (iSettingService == null || (provideBulletSettings2 = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings2.getEnableGlobalPropsCacheOptimize();
        ISettingService iSettingService2 = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        boolean enableRemoveDouyinScreenInfoParams = (iSettingService2 == null || (provideBulletSettings = iSettingService2.provideBulletSettings()) == null) ? false : provideBulletSettings.getEnableRemoveDouyinScreenInfoParams();
        if (enableGlobalPropsCacheOptimize) {
            ConcurrentHashMap<String, Object> concurrentHashMap = cacheProps;
            if (concurrentHashMap.isEmpty()) {
                initDeviceProps$default(null, 1, null);
            }
            Pair<Integer, Integer> screenInfo = BulletDeviceUtils.INSTANCE.getScreenInfo(context);
            mutableMapOf = new LinkedHashMap();
            mutableMapOf.putAll(concurrentHashMap);
            if (enableRemoveDouyinScreenInfoParams && screenInfo != null) {
                mutableMapOf.put("screenWidth", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(((Number) screenInfo.getFirst()).intValue(), context)));
                mutableMapOf.put("screenHeight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(((Number) screenInfo.getSecond()).intValue(), context)));
                if (AnnieXRuntime.INSTANCE.getDeviceDepend().isFold() || AnnieXRuntime.INSTANCE.getDeviceDepend().isPad()) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("screenWidth", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(((Number) screenInfo.getFirst()).intValue(), context)));
                    linkedHashMap.put("screenHeight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(((Number) screenInfo.getSecond()).intValue(), context)));
                    if (BulletPadAdapterUtil.INSTANCE.getPadAdapterWidth() != null) {
                        i = com.bytedance.common.utility.UIUtils.px2dip(context, r8.intValue());
                    } else {
                        i = context.getResources().getConfiguration().screenWidthDp;
                    }
                    linkedHashMap.put(GlobalPropertiesConstants.CONTENT_WIDTH, Integer.valueOf(i));
                    if (BulletPadAdapterUtil.INSTANCE.getPadAdapterHeight() != null) {
                        i2 = com.bytedance.common.utility.UIUtils.px2dip(context, r8.intValue());
                    } else {
                        i2 = context.getResources().getConfiguration().screenHeightDp;
                    }
                    linkedHashMap.put(GlobalPropertiesConstants.CONTENT_HEIGHT, Integer.valueOf(i2));
                    Unit unit = Unit.INSTANCE;
                    mutableMapOf.put("windowSize", linkedHashMap);
                }
                HybridLogger.i$default(HybridLogger.INSTANCE, "getDeviceProps", "screeninfo, screenwidth: " + BulletDeviceUtils.INSTANCE.px2dp(((Number) screenInfo.getFirst()).intValue(), context) + "screenheight: " + BulletDeviceUtils.INSTANCE.px2dp(((Number) screenInfo.getSecond()).intValue(), context), null, null, 12, null);
            } else {
                mutableMapOf.put("screenWidth", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(BulletDeviceUtils.INSTANCE.getScreenWidth(context), context)));
                mutableMapOf.put("screenHeight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(BulletDeviceUtils.INSTANCE.getScreenHeight(context), context)));
            }
            mutableMapOf.put("statusBarHeight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(BulletDeviceUtils.INSTANCE.getStatusBarHeight(context), context)));
        } else {
            boolean checkGLES30Support = checkGLES30Support(context);
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "getDeviceProps: isGLES3Support=" + checkGLES30Support, null, null, 6, null);
            mutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("screenWidth", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(BulletDeviceUtils.INSTANCE.getScreenWidth(context), context))), TuplesKt.to("screenHeight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(BulletDeviceUtils.INSTANCE.getScreenHeight(context), context))), TuplesKt.to("statusBarHeight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(BulletDeviceUtils.INSTANCE.getStatusBarHeight(context), context))), TuplesKt.to("deviceModel", BulletDeviceUtils.INSTANCE.getModel()), TuplesKt.to("os", "android"), TuplesKt.to("osVersion", BulletDeviceUtils.INSTANCE.getSystem()), TuplesKt.to("language", BulletDeviceUtils.INSTANCE.getLanguage()), TuplesKt.to("deviceBrand", BulletDeviceUtils.INSTANCE.getBrand()), TuplesKt.to("glesVer", Integer.valueOf(BulletDeviceUtils.INSTANCE.getGLESVersion(context))), TuplesKt.to("is32", Integer.valueOf(BulletDeviceUtils.INSTANCE.is32() ? 1 : 0)), TuplesKt.to("density", Float.valueOf(BulletDeviceUtils.INSTANCE.getDensity(context))), TuplesKt.to("isAccessable", Integer.valueOf(BulletDeviceUtils.INSTANCE.isAccessible(context) ? 1 : 0)), TuplesKt.to("deviceType", Build.MODEL), TuplesKt.to("isGLES3Support", Boolean.valueOf(checkGLES30Support)), TuplesKt.to("slardarModel", getSlardarModelWithBrand()), TuplesKt.to("isFoldableDevice", Integer.valueOf(AnnieXRuntime.INSTANCE.getDeviceDepend().isFold() ? 1 : 0))});
            if (AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) {
                String foldType = AnnieXRuntime.INSTANCE.getDeviceDepend().getFoldType();
                if (!(foldType.length() > 0)) {
                    foldType = null;
                }
                if (foldType != null) {
                    mutableMapOf.put("screenFoldType", foldType);
                }
            }
        }
        if ((AnnieXRuntime.INSTANCE.getDeviceDepend().isFold() || AnnieXRuntime.INSTANCE.getDeviceDepend().isPad()) && (BulletPadAdapterUtil.INSTANCE.getPadAdapterWidth() != null || BulletPadAdapterUtil.INSTANCE.getPadAdapterHeight() != null)) {
            BulletPadAdapterUtil.INSTANCE.setPadAdapterWidth(null);
            BulletPadAdapterUtil.INSTANCE.setPadAdapterHeight(null);
        }
        BulletDeviceUtils.INSTANCE.setEnableCacheDensity(false);
        reportDeviceParamsCost(bulletContext, currentTimeMillis, System.currentTimeMillis(), enableGlobalPropsCacheOptimize);
        if (TypeIntrinsics.isMutableMap(mutableMapOf)) {
            return mutableMapOf;
        }
        return null;
    }

    private static final void reportDeviceParamsCost(BulletContext bulletContext, long j, long j2, boolean z) {
        String str;
        ReportInfo reportInfo = new ReportInfo(MetricConstant.BULLET_GLOBAL_PROPS_COST, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(bulletContext != null ? bulletContext.getUriIdentifier() : null);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MetricConstant.DEVICE_PROPS_COST, Math.max(0L, j2 - j));
        jSONObject.put(MetricConstant.GLOBAL_PROPS_CACHE_OPTIMIZE, z ? 1 : 0);
        reportInfo.setMetrics(jSONObject);
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        if (bulletContext == null || (str = bulletContext.getBid()) == null) {
            str = "default_bid";
        }
        IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(str, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public static final boolean checkGLES30Support(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) systemService).getDeviceConfigurationInfo();
            Intrinsics.checkNotNullExpressionValue(deviceConfigurationInfo, "am.getDeviceConfigurationInfo()");
            return deviceConfigurationInfo.reqGlEsVersion >= 196608;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final String getSlardarModelWithBrand() {
        String model = BulletDeviceUtils.INSTANCE.getModel();
        String brand = BulletDeviceUtils.INSTANCE.getBrand();
        return model == null ? brand : (brand == null || StringsKt.contains$default(model, brand, false, 2, (Object) null)) ? model : brand + ' ' + model;
    }

    public static final Map<String, Object> getPageCommonProps(Context context, boolean z) {
        if (!z) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(getPageCommonProps(context));
            linkedHashMap.remove(GlobalPropertiesConstants.SAFE_AREA_HEIGHT);
            return linkedHashMap;
        }
        return getPageCommonProps(context);
    }

    public static final Map<String, Object> getPageDynamicProps(Context context) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (context != null) {
            linkedHashMap.put("screenOrientation", context.getResources().getConfiguration().orientation == 2 ? "landscape" : "portrait");
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e A[Catch: all -> 0x0095, TryCatch #2 {all -> 0x0095, blocks: (B:14:0x003a, B:16:0x003e, B:19:0x0062, B:20:0x0063), top: B:13:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Map<String, Object> getPageCommonProps(Context context) {
        int i;
        int i2;
        Throwable th;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        Map<String, Object> containerProps;
        Map breakPoint;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (context != null) {
            boolean z2 = false;
            try {
                Result.Companion companion = Result.Companion;
                i = BulletDeviceUtils.INSTANCE.getScreenHeight(context);
                try {
                    i2 = BulletDeviceUtils.INSTANCE.getScreenWidth(context);
                    try {
                        Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion2 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                        Result.Companion companion3 = Result.Companion;
                        i5 = BulletDeviceUtils.INSTANCE.getStatusBarHeight(context);
                        try {
                            if (context instanceof Activity) {
                            }
                            Result.constructor-impl(Unit.INSTANCE);
                        } catch (Throwable th3) {
                            th = th3;
                            i3 = 0;
                            i4 = 0;
                            i6 = 0;
                        }
                        if (context.getResources().getConfiguration().orientation != 2) {
                        }
                        if (!z) {
                        }
                        linkedHashMap.put(GlobalPropertiesConstants.TOP_HEIGHT, Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i5, context)));
                        linkedHashMap.put(GlobalPropertiesConstants.BOTTOM_HEIGHT, Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i7, context)));
                        int px2dp = BulletDeviceUtils.INSTANCE.px2dp(i8, context);
                        int px2dp2 = BulletDeviceUtils.INSTANCE.px2dp(i11, context);
                        linkedHashMap.put(GlobalPropertiesConstants.CONTENT_HEIGHT, Integer.valueOf(px2dp));
                        linkedHashMap.put(GlobalPropertiesConstants.CONTENT_WIDTH, Integer.valueOf(px2dp2));
                        linkedHashMap.put(GlobalPropertiesConstants.SAFE_AREA_HEIGHT, Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i10, context)));
                        linkedHashMap.put("screenOrientation", !z ? "landscape" : "portrait");
                        if (AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) {
                        }
                        if (AnnieXRuntime.INSTANCE.getDeviceDepend().enableBreakPoint()) {
                        }
                        containerProps = getContainerProps(context);
                        if (containerProps != null) {
                        }
                        return linkedHashMap;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    i2 = 0;
                }
            } catch (Throwable th5) {
                th = th5;
                i = 0;
                i2 = 0;
            }
            try {
                Result.Companion companion32 = Result.Companion;
                i5 = BulletDeviceUtils.INSTANCE.getStatusBarHeight(context);
                if (context instanceof Activity) {
                    i9 = 0;
                    i8 = 0;
                    i7 = 0;
                } else {
                    Rect rect = new Rect();
                    View decorView = ((Activity) context).getWindow().getDecorView();
                    Intrinsics.checkNotNullExpressionValue(decorView, "it.window.decorView");
                    decorView.getWindowVisibleDisplayFrame(rect);
                    int height = decorView.getHeight();
                    int i12 = rect.top;
                    int i13 = rect.bottom;
                    if (height == 0 && i12 == 0) {
                        i13 += i5;
                    }
                    i6 = Math.max(i - i13, 0);
                    try {
                        i4 = Math.max((i - i6) - i5, 0);
                        try {
                            int height2 = rect.height();
                            if (i12 < i5) {
                                height2 -= i5;
                            }
                            i7 = i6;
                            i8 = i4;
                            i9 = height2;
                        } catch (Throwable th6) {
                            th = th6;
                            i3 = 0;
                            Result.Companion companion4 = Result.Companion;
                            Result.constructor-impl(ResultKt.createFailure(th));
                            i7 = i6;
                            i8 = i4;
                            i9 = i3;
                            if (context.getResources().getConfiguration().orientation != 2) {
                            }
                            if (!z) {
                            }
                            linkedHashMap.put(GlobalPropertiesConstants.TOP_HEIGHT, Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i5, context)));
                            linkedHashMap.put(GlobalPropertiesConstants.BOTTOM_HEIGHT, Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i7, context)));
                            int px2dp3 = BulletDeviceUtils.INSTANCE.px2dp(i8, context);
                            int px2dp22 = BulletDeviceUtils.INSTANCE.px2dp(i11, context);
                            linkedHashMap.put(GlobalPropertiesConstants.CONTENT_HEIGHT, Integer.valueOf(px2dp3));
                            linkedHashMap.put(GlobalPropertiesConstants.CONTENT_WIDTH, Integer.valueOf(px2dp22));
                            linkedHashMap.put(GlobalPropertiesConstants.SAFE_AREA_HEIGHT, Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i10, context)));
                            linkedHashMap.put("screenOrientation", !z ? "landscape" : "portrait");
                            if (AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) {
                            }
                            if (AnnieXRuntime.INSTANCE.getDeviceDepend().enableBreakPoint()) {
                            }
                            containerProps = getContainerProps(context);
                            if (containerProps != null) {
                            }
                            return linkedHashMap;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        i3 = 0;
                        i4 = 0;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
            }
            try {
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th9) {
                int i14 = i7;
                th = th9;
                i3 = i9;
                i4 = i8;
                i6 = i14;
                Result.Companion companion42 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                i7 = i6;
                i8 = i4;
                i9 = i3;
                if (context.getResources().getConfiguration().orientation != 2) {
                }
                if (!z) {
                }
                linkedHashMap.put(GlobalPropertiesConstants.TOP_HEIGHT, Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i5, context)));
                linkedHashMap.put(GlobalPropertiesConstants.BOTTOM_HEIGHT, Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i7, context)));
                int px2dp32 = BulletDeviceUtils.INSTANCE.px2dp(i8, context);
                int px2dp222 = BulletDeviceUtils.INSTANCE.px2dp(i11, context);
                linkedHashMap.put(GlobalPropertiesConstants.CONTENT_HEIGHT, Integer.valueOf(px2dp32));
                linkedHashMap.put(GlobalPropertiesConstants.CONTENT_WIDTH, Integer.valueOf(px2dp222));
                linkedHashMap.put(GlobalPropertiesConstants.SAFE_AREA_HEIGHT, Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i10, context)));
                linkedHashMap.put("screenOrientation", !z ? "landscape" : "portrait");
                if (AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) {
                }
                if (AnnieXRuntime.INSTANCE.getDeviceDepend().enableBreakPoint()) {
                }
                containerProps = getContainerProps(context);
                if (containerProps != null) {
                }
                return linkedHashMap;
            }
            z = context.getResources().getConfiguration().orientation != 2;
            if (!z) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("marginTop", 0);
                linkedHashMap2.put("marginBottom", 0);
                linkedHashMap2.put("marginLeft", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i5, context)));
                linkedHashMap2.put("marginRight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i7, context)));
                linkedHashMap.put("safeArea", linkedHashMap2);
                i10 = i9;
                i11 = i2;
            } else {
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                i10 = i9;
                linkedHashMap3.put("marginTop", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i5, context)));
                i11 = i2;
                linkedHashMap3.put("marginBottom", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i7, context)));
                z2 = false;
                linkedHashMap3.put("marginLeft", 0);
                linkedHashMap3.put("marginRight", 0);
                linkedHashMap.put("safeArea", linkedHashMap3);
            }
            linkedHashMap.put(GlobalPropertiesConstants.TOP_HEIGHT, Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i5, context)));
            linkedHashMap.put(GlobalPropertiesConstants.BOTTOM_HEIGHT, Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i7, context)));
            int px2dp322 = BulletDeviceUtils.INSTANCE.px2dp(i8, context);
            int px2dp2222 = BulletDeviceUtils.INSTANCE.px2dp(i11, context);
            linkedHashMap.put(GlobalPropertiesConstants.CONTENT_HEIGHT, Integer.valueOf(px2dp322));
            linkedHashMap.put(GlobalPropertiesConstants.CONTENT_WIDTH, Integer.valueOf(px2dp2222));
            linkedHashMap.put(GlobalPropertiesConstants.SAFE_AREA_HEIGHT, Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i10, context)));
            linkedHashMap.put("screenOrientation", !z ? "landscape" : "portrait");
            if (AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) {
                String foldStatus = AnnieXRuntime.INSTANCE.getDeviceDepend().getFoldStatus();
                if (!(foldStatus.length() > 0 ? true : z2)) {
                    foldStatus = null;
                }
                if (foldStatus != null) {
                    linkedHashMap.put("screenFoldState", foldStatus);
                }
            }
            if (AnnieXRuntime.INSTANCE.getDeviceDepend().enableBreakPoint()) {
                if (AnnieXRuntime.INSTANCE.getDeviceDepend().getBreakPointKey().length() > 0) {
                    z2 = true;
                }
                if (z2 && (breakPoint = AnnieXRuntime.INSTANCE.getDeviceDepend().getBreakPoint(px2dp2222, px2dp322)) != null) {
                    linkedHashMap.put(AnnieXRuntime.INSTANCE.getDeviceDepend().getBreakPointKey(), breakPoint);
                }
            }
            containerProps = getContainerProps(context);
            if (containerProps != null) {
                linkedHashMap.putAll(containerProps);
            }
        }
        return linkedHashMap;
    }

    public static final Map<String, Object> getContainerProps(Context context) {
        int i;
        int i2;
        Resources resources;
        DisplayMetrics displayMetrics;
        Window window;
        View decorView;
        if (IConditionCallKt.enableAnnieXPadGPContainerMigration() || context == null) {
            return null;
        }
        Activity ownerActivity = ContextUtil.INSTANCE.getOwnerActivity(context);
        if (ownerActivity == null || (window = ownerActivity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        if ((i2 <= 0 || i <= 0) && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("containerWidth", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i2, context))), TuplesKt.to("containerHeight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(i, context)))});
    }
}
