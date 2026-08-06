package com.bytedance.android.anniex.lite.utils;

import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.base.service.AnnieXSettingsService;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* compiled from: AnnieXSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0004H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/anniex/lite/utils/AnnieXSettings;", "", "()V", "optimizeBulletInit", "", "getOptimizeBulletInit", "()Z", "optimizeBulletInit$delegate", "Lkotlin/Lazy;", "optimizeWebcastInit", "getOptimizeWebcastInit", "optimizeWebcastInit$delegate", "getBoolean", StrategyConstants.NAME, "", "key", "defaultValue", "getSettingsValue", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXSettings {
    public static final AnnieXSettings INSTANCE = new AnnieXSettings();

    /* renamed from: optimizeBulletInit$delegate, reason: from kotlin metadata */
    private static final Lazy optimizeBulletInit = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.android.anniex.lite.utils.AnnieXSettings$optimizeBulletInit$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m3353invoke() {
            return Boolean.valueOf(AnnieXSettings.getBoolean$default(AnnieXSettings.INSTANCE, "hybrid_optimize_initialization_config", "optimize_bullet_init", false, 4, null));
        }
    });

    /* renamed from: optimizeWebcastInit$delegate, reason: from kotlin metadata */
    private static final Lazy optimizeWebcastInit = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.android.anniex.lite.utils.AnnieXSettings$optimizeWebcastInit$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m3354invoke() {
            return Boolean.valueOf(AnnieXSettings.getBoolean$default(AnnieXSettings.INSTANCE, "hybrid_optimize_initialization_config", "optimize_webcast_init", false, 4, null));
        }
    });

    private AnnieXSettings() {
    }

    public final boolean getOptimizeBulletInit() {
        return ((Boolean) optimizeBulletInit.getValue()).booleanValue();
    }

    public final boolean getOptimizeWebcastInit() {
        return ((Boolean) optimizeWebcastInit.getValue()).booleanValue();
    }

    private final JSONObject getSettingsValue(String name) {
        AnnieXSettingsService annieXSettingsService = (AnnieXSettingsService) AnnieXServiceCenter.INSTANCE.getService("default_bid", AnnieXSettingsService.class);
        if (annieXSettingsService != null) {
            return annieXSettingsService.getSettingsValue(name);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean getBoolean$default(AnnieXSettings annieXSettings, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return annieXSettings.getBoolean(str, str2, z);
    }

    private final boolean getBoolean(String name, String key, boolean defaultValue) {
        JSONObject settingsValue = getSettingsValue(name);
        return settingsValue != null ? settingsValue.optBoolean(key, defaultValue) : defaultValue;
    }
}
