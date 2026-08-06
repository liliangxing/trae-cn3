package com.bytedance.android.anniex.detect;

import android.net.Uri;
import android.os.Build;
import android.view.View;
import com.bytedance.android.anniex.ability.service.AnnieXPitayaProvider;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.detect.detection.PartialBlankDetectionStep;
import com.bytedance.android.anniex.detect.detection.PureColorDetectionStep;
import com.bytedance.android.anniex.detect.schema.BDXBlankDetectModel;
import com.bytedance.android.anniex.detect.snapshot.PixelCopyStep;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.base.settings.ClientAiConfig;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.base.utils.Identifier;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* compiled from: AnnieXBlankDetectorManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0003J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0015H\u0003J\u001c\u0010#\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/android/anniex/detect/AnnieXBlankDetectorManager;", "", "()V", "BLANK_DETECTOR_TAG", "", "LRU_CACHE_MAX_SIZE", "", "blankDetectorConfig", "Lcom/bytedance/android/anniex/detect/BlankDetectorConfig;", "getBlankDetectorConfig", "()Lcom/bytedance/android/anniex/detect/BlankDetectorConfig;", "blankDetectorConfig$delegate", "Lkotlin/Lazy;", "enableBlankDetectConfig", "", "lastViewHashCodes", "", "", "urlLruCache", "", "getBlankDetect", "Lcom/bytedance/android/anniex/detect/BlankDetectorItemConfig;", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "getBlankDetections", "", "Lcom/bytedance/android/anniex/detect/DetectionStep;", "getEnableBlankDetect", "isBlankDetectEnable", "isOnlyPartialBlankDetect", "observeAViewResult", "", "view", "Landroid/view/View;", "config", "onPageBlankCheck", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXBlankDetectorManager {
    public static final String BLANK_DETECTOR_TAG = "AnnieXBlankDetect";
    private static final int LRU_CACHE_MAX_SIZE = 10;

    /* renamed from: blankDetectorConfig$delegate, reason: from kotlin metadata */
    private static final Lazy blankDetectorConfig;
    private static final Map<String, String> enableBlankDetectConfig;
    public static final AnnieXBlankDetectorManager INSTANCE = new AnnieXBlankDetectorManager();
    private static final Map<Integer, Boolean> lastViewHashCodes = new LinkedHashMap<Integer, Boolean>() { // from class: com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$lastViewHashCodes$1
        public /* bridge */ boolean containsKey(Integer num) {
            return super.containsKey((Object) num);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof Integer) {
                return containsKey((Integer) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(Boolean bool) {
            return super.containsValue((Object) bool);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof Boolean) {
                return containsValue((Boolean) obj);
            }
            return false;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<Integer, Boolean>> entrySet() {
            return getEntries();
        }

        public /* bridge */ Boolean get(Integer num) {
            return (Boolean) super.get((Object) num);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Boolean get(Object obj) {
            if (obj instanceof Integer) {
                return get((Integer) obj);
            }
            return null;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof Integer) {
                return get((Integer) obj);
            }
            return null;
        }

        public /* bridge */ Set<Map.Entry<Integer, Boolean>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<Integer> getKeys() {
            return super.keySet();
        }

        public /* bridge */ Boolean getOrDefault(Integer num, Boolean bool) {
            return (Boolean) super.getOrDefault((Object) num, (Integer) bool);
        }

        public final /* bridge */ Boolean getOrDefault(Object obj, Boolean bool) {
            return !(obj instanceof Integer) ? bool : getOrDefault((Integer) obj, bool);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof Integer) ? obj2 : getOrDefault((Integer) obj, (Boolean) obj2);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<Boolean> getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Integer> keySet() {
            return getKeys();
        }

        public /* bridge */ Boolean remove(Integer num) {
            return (Boolean) super.remove((Object) num);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Boolean remove(Object obj) {
            if (obj instanceof Integer) {
                return remove((Integer) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof Integer) {
                return remove((Integer) obj);
            }
            return null;
        }

        public /* bridge */ boolean remove(Integer num, Boolean bool) {
            return super.remove((Object) num, (Object) bool);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof Integer) && (obj2 instanceof Boolean)) {
                return remove((Integer) obj, (Boolean) obj2);
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<Boolean> values() {
            return getValues();
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Integer, Boolean> eldest) {
            Intrinsics.checkNotNullParameter(eldest, "eldest");
            return size() > 10;
        }
    };
    private static final Map<String, Long> urlLruCache = new LinkedHashMap<String, Long>() { // from class: com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$urlLruCache$1
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return containsKey((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsKey(String str) {
            return super.containsKey((Object) str);
        }

        public /* bridge */ boolean containsValue(Long l) {
            return super.containsValue((Object) l);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof Long) {
                return containsValue((Long) obj);
            }
            return false;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Long>> entrySet() {
            return getEntries();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Long get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public /* bridge */ Long get(String str) {
            return (Long) super.get((Object) str);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public /* bridge */ Set<Map.Entry<String, Long>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> getKeys() {
            return super.keySet();
        }

        public final /* bridge */ Long getOrDefault(Object obj, Long l) {
            return !(obj instanceof String) ? l : getOrDefault((String) obj, l);
        }

        public /* bridge */ Long getOrDefault(String str, Long l) {
            return (Long) super.getOrDefault((Object) str, (String) l);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (Long) obj2);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<Long> getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Long remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        public /* bridge */ Long remove(String str) {
            return (Long) super.remove((Object) str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof Long)) {
                return remove((String) obj, (Long) obj2);
            }
            return false;
        }

        public /* bridge */ boolean remove(String str, Long l) {
            return super.remove((Object) str, (Object) l);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<Long> values() {
            return getValues();
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, Long> eldest) {
            Intrinsics.checkNotNullParameter(eldest, "eldest");
            return size() > 10;
        }
    };

    private AnnieXBlankDetectorManager() {
    }

    static {
        ClientAiConfig clientAiConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        enableBlankDetectConfig = (iBulletSettingsService == null || (clientAiConfig = (ClientAiConfig) iBulletSettingsService.obtainSettings(ClientAiConfig.class)) == null) ? null : clientAiConfig.getEnableBlankDetectConfig();
        blankDetectorConfig = LazyKt.lazy(new Function0<BlankDetectorConfig>() { // from class: com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$blankDetectorConfig$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BlankDetectorConfig m3314invoke() {
                BulletSettings provideBulletSettings;
                BulletSettings provideBulletSettings2;
                BulletSettings provideBulletSettings3;
                BulletSettings provideBulletSettings4;
                BulletSettings provideBulletSettings5;
                BulletSettings provideBulletSettings6;
                BulletSettings provideBulletSettings7;
                BulletSettings provideBulletSettings8;
                BulletSettings provideBulletSettings9;
                BulletSettings provideBulletSettings10;
                ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
                boolean isCheckEnable = (iSettingService == null || (provideBulletSettings10 = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings10.isCheckEnable();
                ISettingService iSettingService2 = ServiceCenter.Companion.instance().get(ISettingService.class);
                boolean isPureBlankCheckEnable = (iSettingService2 == null || (provideBulletSettings9 = iSettingService2.provideBulletSettings()) == null) ? false : provideBulletSettings9.isPureBlankCheckEnable();
                ISettingService iSettingService3 = ServiceCenter.Companion.instance().get(ISettingService.class);
                boolean isPartialBlankCheckEnable = (iSettingService3 == null || (provideBulletSettings8 = iSettingService3.provideBulletSettings()) == null) ? false : provideBulletSettings8.isPartialBlankCheckEnable();
                ISettingService iSettingService4 = ServiceCenter.Companion.instance().get(ISettingService.class);
                long checkTimeoutMs = (iSettingService4 == null || (provideBulletSettings7 = iSettingService4.provideBulletSettings()) == null) ? 1500L : provideBulletSettings7.getCheckTimeoutMs();
                ISettingService iSettingService5 = ServiceCenter.Companion.instance().get(ISettingService.class);
                long snapShotTimeoutMs = (iSettingService5 == null || (provideBulletSettings6 = iSettingService5.provideBulletSettings()) == null) ? 500L : provideBulletSettings6.getSnapShotTimeoutMs();
                ISettingService iSettingService6 = ServiceCenter.Companion.instance().get(ISettingService.class);
                float snapShotMaxQuality = (iSettingService6 == null || (provideBulletSettings5 = iSettingService6.provideBulletSettings()) == null) ? 360.0f : provideBulletSettings5.getSnapShotMaxQuality();
                ISettingService iSettingService7 = ServiceCenter.Companion.instance().get(ISettingService.class);
                float pureColorCheckThreshold = (iSettingService7 == null || (provideBulletSettings4 = iSettingService7.provideBulletSettings()) == null) ? 0.9f : provideBulletSettings4.getPureColorCheckThreshold();
                ISettingService iSettingService8 = ServiceCenter.Companion.instance().get(ISettingService.class);
                long pureColorCheckTimeoutMs = (iSettingService8 == null || (provideBulletSettings3 = iSettingService8.provideBulletSettings()) == null) ? 500L : provideBulletSettings3.getPureColorCheckTimeoutMs();
                ISettingService iSettingService9 = ServiceCenter.Companion.instance().get(ISettingService.class);
                long partialBlankCheckTimeoutMs = (iSettingService9 == null || (provideBulletSettings2 = iSettingService9.provideBulletSettings()) == null) ? 500L : provideBulletSettings2.getPartialBlankCheckTimeoutMs();
                ISettingService iSettingService10 = ServiceCenter.Companion.instance().get(ISettingService.class);
                return new BlankDetectorConfig(isCheckEnable, isPureBlankCheckEnable, isPartialBlankCheckEnable, checkTimeoutMs, snapShotTimeoutMs, snapShotMaxQuality, pureColorCheckThreshold, pureColorCheckTimeoutMs, partialBlankCheckTimeoutMs, (iSettingService10 == null || (provideBulletSettings = iSettingService10.provideBulletSettings()) == null) ? 60 * 1000 : provideBulletSettings.getDetectFrequencyInternal());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BlankDetectorConfig getBlankDetectorConfig() {
        return (BlankDetectorConfig) blankDetectorConfig.getValue();
    }

    private final BlankDetectorItemConfig getEnableBlankDetect(ISchemaData schemaData) {
        String str;
        BooleanParam enableBlankDetect;
        BDXBlankDetectModel bDXBlankDetectModel = (BDXBlankDetectModel) SchemaService.Companion.getInstance().generateSchemaModel(schemaData, BDXBlankDetectModel.class);
        String str2 = (String) schemaData.getQueryItems().get(StreamTrafficObservable.STREAM_URL);
        if (str2 != null) {
            Uri parse = Uri.parse(str2);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(it)");
            Identifier bulletLoadUriIdentifier = new BulletLoadUriIdentifier(parse);
            String identifierUrl = bulletLoadUriIdentifier.getIdentifierUrl();
            if (((bDXBlankDetectModel == null || (enableBlankDetect = bDXBlankDetectModel.getEnableBlankDetect()) == null) ? false : Intrinsics.areEqual(true, enableBlankDetect.getValue())) && (str = (String) bDXBlankDetectModel.getBdhmBid().getValue()) != null) {
                return new BlankDetectorItemConfig(str, identifierUrl, bulletLoadUriIdentifier, schemaData.getOriginUrl());
            }
            Map<String, String> map = enableBlankDetectConfig;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (StringsKt.contains$default(identifierUrl, entry.getKey(), false, 2, (Object) null)) {
                        return new BlankDetectorItemConfig(entry.getValue(), identifierUrl, bulletLoadUriIdentifier, schemaData.getOriginUrl());
                    }
                }
            }
        }
        return null;
    }

    public final boolean isBlankDetectEnable(ISchemaData schemaData) {
        return getBlankDetect(schemaData) != null;
    }

    private final BlankDetectorItemConfig getBlankDetect(ISchemaData schemaData) {
        if (schemaData == null) {
            HybridLogger.i$default(HybridLogger.INSTANCE, BLANK_DETECTOR_TAG, "view  or schemaData is null", (Map) null, (LoggerContext) null, 12, (Object) null);
            return null;
        }
        if (!getBlankDetectorConfig().isCheckEnable()) {
            HybridLogger.i$default(HybridLogger.INSTANCE, BLANK_DETECTOR_TAG, "总开关关闭，无需白屏检测", (Map) null, (LoggerContext) null, 12, (Object) null);
            return null;
        }
        if (isOnlyPartialBlankDetect()) {
            AnnieXPitayaProvider annieXPitayaProvider = (AnnieXPitayaProvider) AnnieXServiceCenter.INSTANCE.getService("default_bid", AnnieXPitayaProvider.class);
            boolean z = false;
            if (annieXPitayaProvider != null && true == annieXPitayaProvider.isHostPitayaReady()) {
                z = true;
            }
            if (!z) {
                HybridLogger.i$default(HybridLogger.INSTANCE, BLANK_DETECTOR_TAG, "Pitaya 没有 Ready 时不开启，无需白屏检测", (Map) null, (LoggerContext) null, 12, (Object) null);
                return null;
            }
        }
        return getEnableBlankDetect(schemaData);
    }

    public final void onPageBlankCheck(View view, ISchemaData schemaData) {
        BlankDetectorItemConfig blankDetect = getBlankDetect(schemaData);
        if (blankDetect == null) {
            return;
        }
        Map<String, Long> map = urlLruCache;
        synchronized (map) {
            Long l = map.get(blankDetect.getUrlBase());
            long currentTimeMillis = System.currentTimeMillis();
            if (l != null && currentTimeMillis - l.longValue() < INSTANCE.getBlankDetectorConfig().getDetectFrequencyInternal()) {
                HybridLogger.d$default(HybridLogger.INSTANCE, BLANK_DETECTOR_TAG, "URL 检测过于频繁，跳过：" + blankDetect + ".urlBase", (Map) null, (LoggerContext) null, 12, (Object) null);
                return;
            }
            map.put(blankDetect.getUrlBase(), Long.valueOf(currentTimeMillis));
            Unit unit = Unit.INSTANCE;
            if (view != null) {
                int hashCode = view.hashCode();
                Map<Integer, Boolean> map2 = lastViewHashCodes;
                if (map2.containsKey(Integer.valueOf(hashCode))) {
                    HybridLogger.i$default(HybridLogger.INSTANCE, BLANK_DETECTOR_TAG, "View 已检测过，无需重复检测", (Map) null, (LoggerContext) null, 12, (Object) null);
                    return;
                }
                map2.put(Integer.valueOf(hashCode), true);
                if (Build.VERSION.SDK_INT >= 26) {
                    HybridLogger.d$default(HybridLogger.INSTANCE, BLANK_DETECTOR_TAG, "开启白屏检测, config: " + blankDetect, (Map) null, (LoggerContext) null, 12, (Object) null);
                    INSTANCE.observeAViewResult(view, blankDetect);
                }
            }
        }
    }

    private final void observeAViewResult(View view, BlankDetectorItemConfig config) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AnnieXBlankDetectorManager$observeAViewResult$1(new AnnieXBlankDetector(new SnapshotPipeline(CollectionsKt.listOf(new PixelCopyStep(getBlankDetectorConfig().getSnapShotTimeoutMs(), getBlankDetectorConfig().getSnapShotMaxQuality())), null, 2, null), new DetectionPipeline(getBlankDetections(), false, InterruptStrategies.INSTANCE.interruptOnHighConfidence(), 2, null)), view, config, null), 3, (Object) null);
    }

    private final boolean isOnlyPartialBlankDetect() {
        return getBlankDetectorConfig().isPartialBlankCheckEnable() && !getBlankDetectorConfig().isPureBlankCheckEnable();
    }

    private final List<DetectionStep> getBlankDetections() {
        ArrayList arrayList = new ArrayList();
        if (getBlankDetectorConfig().isPureBlankCheckEnable()) {
            arrayList.add(new PureColorDetectionStep(getBlankDetectorConfig().getPureColorCheckTimeoutMs(), getBlankDetectorConfig().getPureColorCheckThreshold()));
        }
        if (getBlankDetectorConfig().isPartialBlankCheckEnable()) {
            arrayList.add(new PartialBlankDetectionStep(getBlankDetectorConfig().getPartialBlankCheckTimeoutMs(), new AnnieXBlankDetectorManager$getBlankDetections$1(null)));
        }
        return arrayList;
    }
}
