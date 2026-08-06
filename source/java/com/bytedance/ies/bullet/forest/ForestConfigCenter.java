package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.model.ForestConfig;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.utils.LogUtils;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ResourceLoaderConfig;
import com.bytedance.notification.Constants;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ForestConfigCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J*\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestConfigCenter;", "", "()V", "ANNIE_GECKO_DEFAULT_DIR_NAME", "", "TAG", "bidDefaultGeckoConfigs", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/forest/model/GeckoConfig;", "forestConfig", "Lcom/bytedance/forest/model/ForestConfig;", "getForestConfig", "()Lcom/bytedance/forest/model/ForestConfig;", "initForestConfig", "", "rlConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;", "majorGeckoConfigByBid", "bid", "register", "registerMinorGeckoConfig", "rlGeckoConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/GeckoConfig;", "overlay", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestConfigCenter {
    private static final String ANNIE_GECKO_DEFAULT_DIR_NAME = "offlineX";
    private static final String TAG = "ForestConfigHelper";
    public static final ForestConfigCenter INSTANCE = new ForestConfigCenter();
    private static final ForestConfig forestConfig = new ForestConfig("", (GeckoConfig) null, (Map) null, 6, (DefaultConstructorMarker) null);
    private static final ConcurrentHashMap<String, GeckoConfig> bidDefaultGeckoConfigs = new ConcurrentHashMap<>();

    private ForestConfigCenter() {
    }

    public final ForestConfig getForestConfig() {
        return forestConfig;
    }

    public final GeckoConfig majorGeckoConfigByBid(String bid) {
        ConcurrentHashMap<String, GeckoConfig> concurrentHashMap = bidDefaultGeckoConfigs;
        if (bid == null) {
            bid = "default_bid";
        }
        return concurrentHashMap.get(bid);
    }

    public final synchronized void register(String bid, ResourceLoaderConfig rlConfig) throws IllegalStateException {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(rlConfig, "rlConfig");
        if (Intrinsics.areEqual(bid, "default_bid")) {
            ForestConfig forestConfig2 = forestConfig;
            if (forestConfig2.getGeckoConfig() != null) {
                LogUtils.d$default(LogUtils.INSTANCE, TAG, "Default gecko config already exists! Config is " + forestConfig2.getGeckoConfig(), false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
            } else {
                initForestConfig(rlConfig);
                GeckoConfig forestGeckoConfig = ForestConfigCenterKt.toForestGeckoConfig(rlConfig.getDftGeckoCfg(), rlConfig.getAppId(), rlConfig.getAppVersion(), rlConfig.getDid(), rlConfig.getRegion());
                forestConfig2.setGeckoConfig(forestGeckoConfig);
                bidDefaultGeckoConfigs.put(bid, forestGeckoConfig);
                LogUtils.d$default(LogUtils.INSTANCE, TAG, "Register default gecko config=" + forestConfig2.getGeckoConfig(), false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
            }
            for (String str : AnnieGeckoConfigHelper.INSTANCE.getAks()) {
                Long longOrNull = StringsKt.toLongOrNull(rlConfig.getAppId());
                GeckoConfig geckoConfig = new GeckoConfig(str, "offlineX", longOrNull != null ? longOrNull.longValue() : 0L, rlConfig.getAppVersion(), rlConfig.getDid(), rlConfig.getRegion(), true);
                ForestConfig forestConfig3 = forestConfig;
                forestConfig3.getGeckoConfigs().put(str, geckoConfig);
                LogUtils.d$default(LogUtils.INSTANCE, TAG, "Register annie gecko config=" + forestConfig3.getGeckoConfigs().get(str) + " when register default bid", false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
            }
        } else {
            com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig dftGeckoCfg = rlConfig.getDftGeckoCfg();
            if (!Intrinsics.areEqual(bid, BidConstants.WEBCAST) && !Intrinsics.areEqual(bid, BidConstants.LIVE_SDK_REGISTER_BID)) {
                z = false;
                registerMinorGeckoConfig(bid, dftGeckoCfg, rlConfig, z);
            }
            z = true;
            registerMinorGeckoConfig(bid, dftGeckoCfg, rlConfig, z);
        }
        Iterator<T> it = rlConfig.getGeckoConfigs().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ForestConfigCenter forestConfigCenter = INSTANCE;
            com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig geckoConfig2 = (com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig) entry.getValue();
            if (!Intrinsics.areEqual(bid, BidConstants.WEBCAST) && !Intrinsics.areEqual(bid, BidConstants.LIVE_SDK_REGISTER_BID)) {
                z2 = false;
                forestConfigCenter.registerMinorGeckoConfig(bid, geckoConfig2, rlConfig, z2);
            }
            z2 = true;
            forestConfigCenter.registerMinorGeckoConfig(bid, geckoConfig2, rlConfig, z2);
        }
    }

    private final void initForestConfig(ResourceLoaderConfig rlConfig) {
        ForestConfig forestConfig2 = forestConfig;
        forestConfig2.setEnableNegotiation(true);
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        BulletSettings provideBulletSettings = iSettingService != null ? iSettingService.provideBulletSettings() : null;
        forestConfig2.setMaxNormalMemorySize((provideBulletSettings != null ? provideBulletSettings.getForestNormalPoolSize() : 5) * 1024 * 1024);
        forestConfig2.setMaxPreloadMemorySize((provideBulletSettings != null ? provideBulletSettings.getForestPreloadPoolSize() : 5) * 1024 * 1024);
        forestConfig2.setALog(new Function3<Integer, String, Map<String, ? extends Object>, Unit>() { // from class: com.bytedance.ies.bullet.forest.ForestConfigCenter$initForestConfig$1$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke(((Number) obj).intValue(), (String) obj2, (Map<String, ? extends Object>) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(int i, String str, Map<String, ? extends Object> map) {
                Intrinsics.checkNotNullParameter(str, Constants.NOTIFICATION_TAG);
                HybridLogger.INSTANCE.log(i, str, map);
            }
        });
    }

    static /* synthetic */ void registerMinorGeckoConfig$default(ForestConfigCenter forestConfigCenter, String str, com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig geckoConfig, ResourceLoaderConfig resourceLoaderConfig, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        forestConfigCenter.registerMinorGeckoConfig(str, geckoConfig, resourceLoaderConfig, z);
    }

    private final void registerMinorGeckoConfig(String bid, com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig rlGeckoConfig, ResourceLoaderConfig rlConfig, boolean overlay) {
        String accessKey = rlGeckoConfig.getAccessKey();
        ForestConfig forestConfig2 = forestConfig;
        GeckoConfig geckoConfig = (GeckoConfig) forestConfig2.getGeckoConfigs().get(accessKey);
        if (overlay || geckoConfig == null) {
            geckoConfig = ForestConfigCenterKt.toForestGeckoConfig(rlGeckoConfig, rlConfig.getAppId(), rlConfig.getAppVersion(), rlConfig.getDid(), rlConfig.getRegion());
            forestConfig2.getGeckoConfigs().put(accessKey, geckoConfig);
            LogUtils.d$default(LogUtils.INSTANCE, TAG, "Register minor gecko config=" + forestConfig2.getGeckoConfigs().get(accessKey) + " for " + accessKey, false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
        } else {
            LogUtils.d$default(LogUtils.INSTANCE, TAG, "Gecko config of " + accessKey + " already exists! Config is " + forestConfig2.getGeckoConfigs().get(accessKey), false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
        }
        if (bidDefaultGeckoConfigs.putIfAbsent(bid, geckoConfig) == null) {
            LogUtils.d$default(LogUtils.INSTANCE, TAG, "Register minor gecko config=" + forestConfig2.getGeckoConfigs().get(accessKey) + " for " + bid, false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
        } else {
            LogUtils.d$default(LogUtils.INSTANCE, TAG, "Gecko config of " + bid + " already exists! Config is " + forestConfig2.getGeckoConfigs().get(accessKey), false, (Function3) null, (String) null, (Map) null, 60, (Object) null);
        }
    }
}
