package com.bytedance.trae.conversation.devices.newfeature;

import com.bytedance.keva.Keva;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.prompt.ManagedPromptLedgerState;
import com.bytedance.trae.conversation.prompt.ManagedPromptLedgerStore;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: NewFeaturePromptStore.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\fJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0012J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u000e\u001a\u00020\fJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0018H\u0002J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;", "", "<init>", "()V", "REPO_PREFIX", "", "KEY_FIRST_LOGIN_OBSERVED_AT", "KEY_SHOWN_PREFIX", "KEY_SHOWN_COUNT_PREFIX", "KEY_HIGHEST_SHOWN_VERSION_PREFIX", "KEY_LAST_SHOWN_AT", "recordLoginObserved", "", "userId", "nowMillis", IFileDataCacheService.TYPE_SNAPSHOT, "Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;", "config", "Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;", "markShown", "", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "legacyShownVersion", "", "repo", "Lcom/bytedance/keva/Keva;", "mergeLegacyExposureIntoUnifiedLedger", "legacyShownKey", "versionedShownKey", "version", "shownCountKey", "highestShownVersionKey", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NewFeaturePromptStore {
    public static final NewFeaturePromptStore INSTANCE = new NewFeaturePromptStore();
    private static final String KEY_FIRST_LOGIN_OBSERVED_AT = "first_login_observed_at";
    private static final String KEY_HIGHEST_SHOWN_VERSION_PREFIX = "highest_shown_version_";
    private static final String KEY_LAST_SHOWN_AT = "last_shown_at";
    private static final String KEY_SHOWN_COUNT_PREFIX = "shown_count_";
    private static final String KEY_SHOWN_PREFIX = "shown_";
    private static final String REPO_PREFIX = "trae_new_feature_prompt_";

    private NewFeaturePromptStore() {
    }

    public static /* synthetic */ long recordLoginObserved$default(NewFeaturePromptStore newFeaturePromptStore, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = System.currentTimeMillis();
        }
        return newFeaturePromptStore.recordLoginObserved(str, j);
    }

    public final synchronized long recordLoginObserved(String userId, long nowMillis) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (StringsKt.isBlank(userId)) {
            return 0L;
        }
        Keva repo = repo(userId);
        long j = repo.getLong(KEY_FIRST_LOGIN_OBSERVED_AT, 0L);
        if (j > 0) {
            nowMillis = j;
        } else {
            repo.storeLong(KEY_FIRST_LOGIN_OBSERVED_AT, nowMillis);
        }
        mergeLegacyExposureIntoUnifiedLedger(userId, repo);
        return nowMillis;
    }

    public static /* synthetic */ NewFeaturePromptState snapshot$default(NewFeaturePromptStore newFeaturePromptStore, String str, NewFeaturePromptConfig newFeaturePromptConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            newFeaturePromptConfig = new NewFeaturePromptConfig(false, 0, null, 0L, 15, null);
        }
        return newFeaturePromptStore.snapshot(str, newFeaturePromptConfig);
    }

    public final synchronized NewFeaturePromptState snapshot(String str, NewFeaturePromptConfig newFeaturePromptConfig) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(newFeaturePromptConfig, "config");
        if (StringsKt.isBlank(str)) {
            return new NewFeaturePromptState(SetsKt.emptySet(), null, null, null, null, 0L, false, 0L, 254, null);
        }
        Keva repo = repo(str);
        mergeLegacyExposureIntoUnifiedLedger(str, repo);
        ManagedPromptLedgerState snapshot = ManagedPromptLedgerStore.INSTANCE.snapshot(str);
        DeviceProductType[] values = DeviceProductType.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (DeviceProductType deviceProductType : values) {
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            NewFeaturePromptStore newFeaturePromptStore = INSTANCE;
            int i = repo.getInt(newFeaturePromptStore.highestShownVersionKey(deviceProductType), 0);
            int[] iArr = new int[3];
            iArr[0] = newFeaturePromptStore.legacyShownVersion(repo, deviceProductType);
            iArr[1] = repo.getBoolean(newFeaturePromptStore.versionedShownKey(deviceProductType, newFeaturePromptConfig.getVersion()), false) ? newFeaturePromptConfig.getVersion() : 0;
            Integer num = snapshot.getShownVersions().get(NewFeaturePromptPolicy.INSTANCE.managedCandidate$conversation_mainlandRelease(deviceProductType, newFeaturePromptConfig).getCampaignId());
            iArr[2] = num != null ? num.intValue() : 0;
            linkedHashMap2.put(deviceProductType, Integer.valueOf(ComparisonsKt.maxOf(i, iArr)));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((Number) entry.getValue()).intValue() > 0) {
                linkedHashMap3.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap4 = linkedHashMap3;
        ArrayList arrayList = new ArrayList(linkedHashMap4.size());
        for (Map.Entry entry2 : linkedHashMap4.entrySet()) {
            arrayList.add(new NewFeaturePromptRecord((DeviceProductType) entry2.getKey(), ((Number) entry2.getValue()).intValue()));
        }
        return new NewFeaturePromptState(linkedHashMap4.keySet(), null, null, CollectionsKt.toSet(arrayList), linkedHashMap4, repo.getLong(KEY_FIRST_LOGIN_OBSERVED_AT, 0L), false, Math.max(repo.getLong(KEY_LAST_SHOWN_AT, 0L), snapshot.getLastShownAtMillis()), 70, null);
    }

    public static /* synthetic */ void markShown$default(NewFeaturePromptStore newFeaturePromptStore, String str, DeviceProductType deviceProductType, NewFeaturePromptConfig newFeaturePromptConfig, long j, int i, Object obj) {
        newFeaturePromptStore.markShown(str, deviceProductType, (i & 4) != 0 ? new NewFeaturePromptConfig(false, 0, null, 0L, 15, null) : newFeaturePromptConfig, (i & 8) != 0 ? System.currentTimeMillis() : j);
    }

    public final synchronized void markShown(String userId, DeviceProductType productType, NewFeaturePromptConfig config, long nowMillis) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(config, "config");
        if (StringsKt.isBlank(userId)) {
            return;
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(config.getVersion(), 1);
        ManagedPromptLedgerStore.INSTANCE.recordShown(userId, NewFeaturePromptPolicy.INSTANCE.managedCandidate$conversation_mainlandRelease(productType, NewFeaturePromptConfig.copy$default(config, false, coerceAtLeast, null, 0L, 13, null)), nowMillis);
        Keva repo = repo(userId);
        repo.storeBoolean(legacyShownKey(productType), true);
        repo.storeBoolean(versionedShownKey(productType, coerceAtLeast), true);
        repo.storeInt(highestShownVersionKey(productType), Math.max(repo.getInt(highestShownVersionKey(productType), 0), coerceAtLeast));
        repo.storeLong(KEY_LAST_SHOWN_AT, nowMillis);
    }

    private final int legacyShownVersion(Keva repo, DeviceProductType productType) {
        return (repo.getBoolean(legacyShownKey(productType), false) || repo.getInt(shownCountKey(productType), 0) > 0) ? 1 : 0;
    }

    private final void mergeLegacyExposureIntoUnifiedLedger(String userId, Keva repo) {
        DeviceProductType[] values = DeviceProductType.values();
        ArrayList arrayList = new ArrayList();
        int length = values.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            DeviceProductType deviceProductType = values[i2];
            NewFeaturePromptStore newFeaturePromptStore = INSTANCE;
            int max = Math.max(newFeaturePromptStore.legacyShownVersion(repo, deviceProductType), repo.getInt(newFeaturePromptStore.highestShownVersionKey(deviceProductType), i));
            Pair pair = max > 0 ? TuplesKt.to(NewFeaturePromptPolicy.INSTANCE.managedCandidate$conversation_mainlandRelease(deviceProductType, new NewFeaturePromptConfig(false, max, null, 0L, 13, null)).getCampaignId(), Integer.valueOf(max)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
            i2++;
            i = 0;
        }
        Map<String, Integer> map = MapsKt.toMap(arrayList);
        long j = repo.getLong(KEY_LAST_SHOWN_AT, 0L);
        if ((!map.isEmpty()) || j > 0) {
            ManagedPromptLedgerStore.INSTANCE.mergeExposureHistory(userId, map, j);
        }
    }

    private final String legacyShownKey(DeviceProductType productType) {
        return KEY_SHOWN_PREFIX + productType.name();
    }

    private final String versionedShownKey(DeviceProductType productType, int version) {
        return KEY_SHOWN_PREFIX + productType.name() + "_v" + version;
    }

    private final String shownCountKey(DeviceProductType productType) {
        return KEY_SHOWN_COUNT_PREFIX + productType.name();
    }

    private final String highestShownVersionKey(DeviceProductType productType) {
        return KEY_HIGHEST_SHOWN_VERSION_PREFIX + productType.name();
    }

    private final Keva repo(String userId) {
        Keva repo = Keva.getRepo(REPO_PREFIX + userId, 0);
        Intrinsics.checkNotNullExpressionValue(repo, "getRepo(...)");
        return repo;
    }
}
