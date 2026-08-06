package com.bytedance.android.anniex.scene.settings;

import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: SwitchCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u001f\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0017\u0010\u0011R\u001b\u0010\u0019\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\b\u001a\u0004\b\u001a\u0010\u0011R\u001b\u0010\u001c\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001d\u0010\u0011R\u001b\u0010\u001f\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b \u0010\u0006R\u001b\u0010\"\u001a\u00020#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\b\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\b\u001a\u0004\b(\u0010\fR#\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\b\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u00020#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\b\u001a\u0004\b1\u0010%R#\u00103\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\b\u001a\u0004\b4\u0010.R\u001b\u00106\u001a\u00020#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\b\u001a\u0004\b7\u0010%R\u001b\u00109\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\b\u001a\u0004\b:\u0010\u0006R\u001b\u0010<\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\b\u001a\u0004\b=\u0010\u0006R\u001b\u0010?\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\b\u001a\u0004\b@\u0010\u0006R\u001b\u0010B\u001a\u00020#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\b\u001a\u0004\bC\u0010%R\u001b\u0010E\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\b\u001a\u0004\bF\u0010\u0006R\u001b\u0010H\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\b\u001a\u0004\bI\u0010\u0006¨\u0006K"}, d2 = {"Lcom/bytedance/android/anniex/scene/settings/SwitchCenter;", "", "()V", "bcmChainLength", "", "getBcmChainLength", "()I", "bcmChainLength$delegate", "Lkotlin/Lazy;", "cosineThreshold", "", "getCosineThreshold", "()D", "cosineThreshold$delegate", "domainStandard", "", "getDomainStandard", "()Z", "domainStandard$delegate", "enableNaStackStore", "getEnableNaStackStore", "enableNaStackStore$delegate", "enableScene", "getEnableScene", "enableScene$delegate", "enableSceneBcmChainInfo", "getEnableSceneBcmChainInfo", "enableSceneBcmChainInfo$delegate", "enableViewAttachWithoutSessionId", "getEnableViewAttachWithoutSessionId", "enableViewAttachWithoutSessionId$delegate", "hotUrlCacheMaxSize", "getHotUrlCacheMaxSize", "hotUrlCacheMaxSize$delegate", "hybridViewWindowDurationMs", "", "getHybridViewWindowDurationMs", "()J", "hybridViewWindowDurationMs$delegate", "jaccardThreshold", "getJaccardThreshold", "jaccardThreshold$delegate", "pageStackBlackList", "", "", "getPageStackBlackList", "()Ljava/util/Set;", "pageStackBlackList$delegate", "pageStackSubscribeDelay", "getPageStackSubscribeDelay", "pageStackSubscribeDelay$delegate", "pageStackWhiteList", "getPageStackWhiteList", "pageStackWhiteList$delegate", "pageStackWindowDurationMs", "getPageStackWindowDurationMs", "pageStackWindowDurationMs$delegate", "recentSceneLruCacheMaxSize", "getRecentSceneLruCacheMaxSize", "recentSceneLruCacheMaxSize$delegate", "sceneTableMaxCount", "getSceneTableMaxCount", "sceneTableMaxCount$delegate", "sqliteCleanThreshold", "getSqliteCleanThreshold", "sqliteCleanThreshold$delegate", "sqliteDataExpireMs", "getSqliteDataExpireMs", "sqliteDataExpireMs$delegate", "sqliteTransFlushThreshold", "getSqliteTransFlushThreshold", "sqliteTransFlushThreshold$delegate", "transitionTableMaxCount", "getTransitionTableMaxCount", "transitionTableMaxCount$delegate", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SwitchCenter {
    public static final SwitchCenter INSTANCE = new SwitchCenter();

    /* renamed from: enableScene$delegate, reason: from kotlin metadata */
    private static final Lazy enableScene = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$enableScene$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m3433invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Boolean.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings.getEnableSceneRecognize());
        }
    });

    /* renamed from: pageStackSubscribeDelay$delegate, reason: from kotlin metadata */
    private static final Lazy pageStackSubscribeDelay = LazyKt.lazy(new Function0<Long>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$pageStackSubscribeDelay$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m3440invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Long.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? 60000L : provideBulletSettings.getPageStackSubscribeDelay());
        }
    });

    /* renamed from: enableNaStackStore$delegate, reason: from kotlin metadata */
    private static final Lazy enableNaStackStore = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$enableNaStackStore$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m3432invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Boolean.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings.getEnableNaStackStore());
        }
    });

    /* renamed from: enableViewAttachWithoutSessionId$delegate, reason: from kotlin metadata */
    private static final Lazy enableViewAttachWithoutSessionId = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$enableViewAttachWithoutSessionId$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m3435invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Boolean.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings.getEnableViewAttachWithoutSessionId());
        }
    });

    /* renamed from: enableSceneBcmChainInfo$delegate, reason: from kotlin metadata */
    private static final Lazy enableSceneBcmChainInfo = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$enableSceneBcmChainInfo$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m3434invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Boolean.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings.getEnableSceneBcmChainInfo());
        }
    });

    /* renamed from: bcmChainLength$delegate, reason: from kotlin metadata */
    private static final Lazy bcmChainLength = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$bcmChainLength$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m3429invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Integer.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? 3 : provideBulletSettings.getBcmChainLength());
        }
    });

    /* renamed from: domainStandard$delegate, reason: from kotlin metadata */
    private static final Lazy domainStandard = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$domainStandard$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m3431invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Boolean.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings.isDomainStandard());
        }
    });

    /* renamed from: pageStackBlackList$delegate, reason: from kotlin metadata */
    private static final Lazy pageStackBlackList = LazyKt.lazy(new Function0<Set<? extends String>>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$pageStackBlackList$2
        public final Set<String> invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
                return null;
            }
            return provideBulletSettings.getPageStackBlackList();
        }
    });

    /* renamed from: pageStackWhiteList$delegate, reason: from kotlin metadata */
    private static final Lazy pageStackWhiteList = LazyKt.lazy(new Function0<Set<? extends String>>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$pageStackWhiteList$2
        public final Set<String> invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) {
                return null;
            }
            return provideBulletSettings.getPageStackWhiteList();
        }
    });

    /* renamed from: hybridViewWindowDurationMs$delegate, reason: from kotlin metadata */
    private static final Lazy hybridViewWindowDurationMs = LazyKt.lazy(new Function0<Long>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$hybridViewWindowDurationMs$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m3437invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Long.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? 3000L : provideBulletSettings.getHybridViewWindowDurationMs());
        }
    });

    /* renamed from: pageStackWindowDurationMs$delegate, reason: from kotlin metadata */
    private static final Lazy pageStackWindowDurationMs = LazyKt.lazy(new Function0<Long>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$pageStackWindowDurationMs$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m3442invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Long.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? 2000L : provideBulletSettings.getPageStackWindowDurationMs());
        }
    });

    /* renamed from: hotUrlCacheMaxSize$delegate, reason: from kotlin metadata */
    private static final Lazy hotUrlCacheMaxSize = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$hotUrlCacheMaxSize$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m3436invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Integer.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? 100 : provideBulletSettings.getHotUrlCacheMaxSize());
        }
    });

    /* renamed from: jaccardThreshold$delegate, reason: from kotlin metadata */
    private static final Lazy jaccardThreshold = LazyKt.lazy(new Function0<Double>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$jaccardThreshold$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Double m3438invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Double.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? 0.7d : provideBulletSettings.getSceneRecognizeJaccardThreshold());
        }
    });

    /* renamed from: cosineThreshold$delegate, reason: from kotlin metadata */
    private static final Lazy cosineThreshold = LazyKt.lazy(new Function0<Double>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$cosineThreshold$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Double m3430invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Double.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? 0.7d : provideBulletSettings.getSceneRecognizeCosineThreshold());
        }
    });

    /* renamed from: recentSceneLruCacheMaxSize$delegate, reason: from kotlin metadata */
    private static final Lazy recentSceneLruCacheMaxSize = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$recentSceneLruCacheMaxSize$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m3443invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Integer.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? 5 : provideBulletSettings.getRecentSceneLruCacheMaxSize());
        }
    });

    /* renamed from: sceneTableMaxCount$delegate, reason: from kotlin metadata */
    private static final Lazy sceneTableMaxCount = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$sceneTableMaxCount$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m3444invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Integer.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? 1000 : provideBulletSettings.getSceneTableMaxCount());
        }
    });

    /* renamed from: transitionTableMaxCount$delegate, reason: from kotlin metadata */
    private static final Lazy transitionTableMaxCount = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$transitionTableMaxCount$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m3448invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Integer.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? 1000 : provideBulletSettings.getTransitionTableMaxCount());
        }
    });

    /* renamed from: sqliteDataExpireMs$delegate, reason: from kotlin metadata */
    private static final Lazy sqliteDataExpireMs = LazyKt.lazy(new Function0<Long>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$sqliteDataExpireMs$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m3446invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Long.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? 24 * 30 * 3600 * 1000 : provideBulletSettings.getSqliteDataExpireMs());
        }
    });

    /* renamed from: sqliteCleanThreshold$delegate, reason: from kotlin metadata */
    private static final Lazy sqliteCleanThreshold = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$sqliteCleanThreshold$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m3445invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Integer.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? 5 : provideBulletSettings.getSqliteCleanThreshold());
        }
    });

    /* renamed from: sqliteTransFlushThreshold$delegate, reason: from kotlin metadata */
    private static final Lazy sqliteTransFlushThreshold = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.android.anniex.scene.settings.SwitchCenter$sqliteTransFlushThreshold$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m3447invoke() {
            BulletSettings provideBulletSettings;
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            return Integer.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? 5 : provideBulletSettings.getSqliteTransFlushThreshold());
        }
    });

    private SwitchCenter() {
    }

    public final boolean getEnableScene() {
        return ((Boolean) enableScene.getValue()).booleanValue();
    }

    public final long getPageStackSubscribeDelay() {
        return ((Number) pageStackSubscribeDelay.getValue()).longValue();
    }

    public final boolean getEnableNaStackStore() {
        return ((Boolean) enableNaStackStore.getValue()).booleanValue();
    }

    public final boolean getEnableViewAttachWithoutSessionId() {
        return ((Boolean) enableViewAttachWithoutSessionId.getValue()).booleanValue();
    }

    public final boolean getEnableSceneBcmChainInfo() {
        return ((Boolean) enableSceneBcmChainInfo.getValue()).booleanValue();
    }

    public final int getBcmChainLength() {
        return ((Number) bcmChainLength.getValue()).intValue();
    }

    public final boolean getDomainStandard() {
        return ((Boolean) domainStandard.getValue()).booleanValue();
    }

    public final Set<String> getPageStackBlackList() {
        return (Set) pageStackBlackList.getValue();
    }

    public final Set<String> getPageStackWhiteList() {
        return (Set) pageStackWhiteList.getValue();
    }

    public final long getHybridViewWindowDurationMs() {
        return ((Number) hybridViewWindowDurationMs.getValue()).longValue();
    }

    public final long getPageStackWindowDurationMs() {
        return ((Number) pageStackWindowDurationMs.getValue()).longValue();
    }

    public final int getHotUrlCacheMaxSize() {
        return ((Number) hotUrlCacheMaxSize.getValue()).intValue();
    }

    public final double getJaccardThreshold() {
        return ((Number) jaccardThreshold.getValue()).doubleValue();
    }

    public final double getCosineThreshold() {
        return ((Number) cosineThreshold.getValue()).doubleValue();
    }

    public final int getRecentSceneLruCacheMaxSize() {
        return ((Number) recentSceneLruCacheMaxSize.getValue()).intValue();
    }

    public final int getSceneTableMaxCount() {
        return ((Number) sceneTableMaxCount.getValue()).intValue();
    }

    public final int getTransitionTableMaxCount() {
        return ((Number) transitionTableMaxCount.getValue()).intValue();
    }

    public final long getSqliteDataExpireMs() {
        return ((Number) sqliteDataExpireMs.getValue()).longValue();
    }

    public final int getSqliteCleanThreshold() {
        return ((Number) sqliteCleanThreshold.getValue()).intValue();
    }

    public final int getSqliteTransFlushThreshold() {
        return ((Number) sqliteTransFlushThreshold.getValue()).intValue();
    }
}
