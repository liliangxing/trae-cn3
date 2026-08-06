package com.bytedance.trae.conversation.prompt;

import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ManagedPromptLedger.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017J*\u0010\u0018\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00170\u001a2\u0006\u0010\u001b\u001a\u00020\u0011J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;", "", "storage", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStorage;", "gson", "Lcom/google/gson/Gson;", "<init>", "(Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStorage;Lcom/google/gson/Gson;)V", IFileDataCacheService.TYPE_SNAPSHOT, "Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;", "userId", "", "recordShown", "", "candidate", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;", "shownAtMillis", "", "savePendingBilling", "pending", "Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;", "clearPendingBilling", "expectedCampaignVersion", "", "mergeExposureHistory", "shownVersions", "", "lastShownAtMillis", "write", "state", "PersistedState", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ManagedPromptLedger {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String LEGACY_IMPORTED_CAMPAIGN_KEY = "legacy_import";
    private final Gson gson;
    private final ManagedPromptLedgerStorage storage;

    public ManagedPromptLedger(ManagedPromptLedgerStorage managedPromptLedgerStorage, Gson gson) {
        Intrinsics.checkNotNullParameter(managedPromptLedgerStorage, "storage");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.storage = managedPromptLedgerStorage;
        this.gson = gson;
    }

    public /* synthetic */ ManagedPromptLedger(ManagedPromptLedgerStorage managedPromptLedgerStorage, Gson gson, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(managedPromptLedgerStorage, (i & 2) != 0 ? new Gson() : gson);
    }

    public final synchronized ManagedPromptLedgerState snapshot(String userId) {
        Object obj;
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (StringsKt.isBlank(userId)) {
            return new ManagedPromptLedgerState(0L, null, null, null, 15, null);
        }
        String read = this.storage.read(userId);
        if (read != null) {
            if (!(!StringsKt.isBlank(read))) {
                read = null;
            }
            if (read != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    ManagedPromptLedger managedPromptLedger = this;
                    PersistedState persistedState = (PersistedState) this.gson.fromJson(read, PersistedState.class);
                    long lastShownAtMillis = persistedState.getLastShownAtMillis();
                    String lastShownCampaignKey = persistedState.getLastShownCampaignKey();
                    Map<String, Integer> shownVersions = persistedState.getShownVersions();
                    if (shownVersions == null) {
                        shownVersions = MapsKt.emptyMap();
                    }
                    obj = Result.constructor-impl(new ManagedPromptLedgerState(lastShownAtMillis, lastShownCampaignKey, shownVersions, persistedState.getPendingBilling()));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                ManagedPromptLedgerState managedPromptLedgerState = new ManagedPromptLedgerState(0L, null, null, null, 15, null);
                if (Result.isFailure-impl(obj)) {
                    obj = managedPromptLedgerState;
                }
                return (ManagedPromptLedgerState) obj;
            }
        }
        return new ManagedPromptLedgerState(0L, null, null, null, 15, null);
    }

    public final synchronized void recordShown(String userId, ManagedPromptCandidate candidate, long shownAtMillis) {
        String lastShownCampaignKey;
        PendingBillingPromptRecord pendingBillingPromptRecord;
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(candidate, "candidate");
        if (StringsKt.isBlank(userId)) {
            return;
        }
        ManagedPromptLedgerState snapshot = snapshot(userId);
        Integer num = snapshot.getShownVersions().get(candidate.getCampaignId());
        boolean z = false;
        int intValue = num != null ? num.intValue() : 0;
        long max = Math.max(snapshot.getLastShownAtMillis(), shownAtMillis);
        if (shownAtMillis >= snapshot.getLastShownAtMillis()) {
            lastShownCampaignKey = candidate.getStableKey();
        } else {
            lastShownCampaignKey = snapshot.getLastShownCampaignKey();
        }
        Map<String, Integer> plus = MapsKt.plus(snapshot.getShownVersions(), TuplesKt.to(candidate.getCampaignId(), Integer.valueOf(Math.max(intValue, candidate.getCampaignVersion()))));
        PendingBillingPromptRecord pendingBilling = snapshot.getPendingBilling();
        if (pendingBilling != null) {
            if (candidate.getType() == ManagedPromptType.BillingUpgrade && pendingBilling.getCampaignVersion() <= candidate.getCampaignVersion()) {
                z = true;
            }
            if (!z) {
                pendingBillingPromptRecord = pendingBilling;
                write(userId, snapshot.copy(max, lastShownCampaignKey, plus, pendingBillingPromptRecord));
            }
        }
        pendingBillingPromptRecord = null;
        write(userId, snapshot.copy(max, lastShownCampaignKey, plus, pendingBillingPromptRecord));
    }

    public final synchronized void savePendingBilling(String userId, PendingBillingPromptRecord pending) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(pending, "pending");
        if (StringsKt.isBlank(userId)) {
            return;
        }
        ManagedPromptLedgerState snapshot = snapshot(userId);
        PendingBillingPromptRecord pendingBilling = snapshot.getPendingBilling();
        if (pendingBilling == null || pendingBilling.getCampaignVersion() <= pending.getCampaignVersion()) {
            write(userId, ManagedPromptLedgerState.copy$default(snapshot, 0L, null, null, pending, 7, null));
        }
    }

    public final synchronized void clearPendingBilling(String userId, int expectedCampaignVersion) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (StringsKt.isBlank(userId)) {
            return;
        }
        ManagedPromptLedgerState snapshot = snapshot(userId);
        PendingBillingPromptRecord pendingBilling = snapshot.getPendingBilling();
        boolean z = false;
        if (pendingBilling != null && pendingBilling.getCampaignVersion() == expectedCampaignVersion) {
            z = true;
        }
        if (z) {
            write(userId, ManagedPromptLedgerState.copy$default(snapshot, 0L, null, null, null, 7, null));
        }
    }

    public final synchronized void mergeExposureHistory(String userId, Map<String, Integer> shownVersions, long lastShownAtMillis) {
        boolean z;
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(shownVersions, "shownVersions");
        if (StringsKt.isBlank(userId)) {
            return;
        }
        ManagedPromptLedgerState snapshot = snapshot(userId);
        Map mutableMap = MapsKt.toMutableMap(snapshot.getShownVersions());
        Iterator<Map.Entry<String, Integer>> it = shownVersions.entrySet().iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Integer> next = it.next();
            String key = next.getKey();
            int intValue = next.getValue().intValue();
            if ((true ^ StringsKt.isBlank(key)) && intValue > 0) {
                Integer num = (Integer) mutableMap.get(key);
                mutableMap.put(key, Integer.valueOf(Math.max(num != null ? num.intValue() : 0, intValue)));
            }
        }
        if (lastShownAtMillis <= snapshot.getLastShownAtMillis()) {
            z = false;
        }
        if (!Intrinsics.areEqual(mutableMap, snapshot.getShownVersions()) || z) {
            if (!z) {
                lastShownAtMillis = snapshot.getLastShownAtMillis();
            }
            write(userId, ManagedPromptLedgerState.copy$default(snapshot, lastShownAtMillis, z ? LEGACY_IMPORTED_CAMPAIGN_KEY : snapshot.getLastShownCampaignKey(), mutableMap, null, 8, null));
        }
    }

    private final void write(String userId, ManagedPromptLedgerState state) {
        ManagedPromptLedgerStorage managedPromptLedgerStorage = this.storage;
        String json = this.gson.toJson(new PersistedState(state.getLastShownAtMillis(), state.getLastShownCampaignKey(), state.getShownVersions(), state.getPendingBilling()));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        managedPromptLedgerStorage.write(userId, json);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ManagedPromptLedger.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger$PersistedState;", "", "lastShownAtMillis", "", "lastShownCampaignKey", "", "shownVersions", "", "", "pendingBilling", "Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;", "<init>", "(JLjava/lang/String;Ljava/util/Map;Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;)V", "getLastShownAtMillis", "()J", "getLastShownCampaignKey", "()Ljava/lang/String;", "getShownVersions", "()Ljava/util/Map;", "getPendingBilling", "()Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class PersistedState {
        private final long lastShownAtMillis;
        private final String lastShownCampaignKey;
        private final PendingBillingPromptRecord pendingBilling;
        private final Map<String, Integer> shownVersions;

        public PersistedState() {
            this(0L, null, null, null, 15, null);
        }

        public static /* synthetic */ PersistedState copy$default(PersistedState persistedState, long j, String str, Map map, PendingBillingPromptRecord pendingBillingPromptRecord, int i, Object obj) {
            if ((i & 1) != 0) {
                j = persistedState.lastShownAtMillis;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = persistedState.lastShownCampaignKey;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                map = persistedState.shownVersions;
            }
            Map map2 = map;
            if ((i & 8) != 0) {
                pendingBillingPromptRecord = persistedState.pendingBilling;
            }
            return persistedState.copy(j2, str2, map2, pendingBillingPromptRecord);
        }

        /* renamed from: component1, reason: from getter */
        public final long getLastShownAtMillis() {
            return this.lastShownAtMillis;
        }

        /* renamed from: component2, reason: from getter */
        public final String getLastShownCampaignKey() {
            return this.lastShownCampaignKey;
        }

        public final Map<String, Integer> component3() {
            return this.shownVersions;
        }

        /* renamed from: component4, reason: from getter */
        public final PendingBillingPromptRecord getPendingBilling() {
            return this.pendingBilling;
        }

        public final PersistedState copy(long lastShownAtMillis, String lastShownCampaignKey, Map<String, Integer> shownVersions, PendingBillingPromptRecord pendingBilling) {
            return new PersistedState(lastShownAtMillis, lastShownCampaignKey, shownVersions, pendingBilling);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PersistedState)) {
                return false;
            }
            PersistedState persistedState = (PersistedState) other;
            return this.lastShownAtMillis == persistedState.lastShownAtMillis && Intrinsics.areEqual(this.lastShownCampaignKey, persistedState.lastShownCampaignKey) && Intrinsics.areEqual(this.shownVersions, persistedState.shownVersions) && Intrinsics.areEqual(this.pendingBilling, persistedState.pendingBilling);
        }

        public int hashCode() {
            int hashCode = Long.hashCode(this.lastShownAtMillis) * 31;
            String str = this.lastShownCampaignKey;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Map<String, Integer> map = this.shownVersions;
            int hashCode3 = (hashCode2 + (map == null ? 0 : map.hashCode())) * 31;
            PendingBillingPromptRecord pendingBillingPromptRecord = this.pendingBilling;
            return hashCode3 + (pendingBillingPromptRecord != null ? pendingBillingPromptRecord.hashCode() : 0);
        }

        public String toString() {
            return "PersistedState(lastShownAtMillis=" + this.lastShownAtMillis + ", lastShownCampaignKey=" + this.lastShownCampaignKey + ", shownVersions=" + this.shownVersions + ", pendingBilling=" + this.pendingBilling + ')';
        }

        public PersistedState(long j, String str, Map<String, Integer> map, PendingBillingPromptRecord pendingBillingPromptRecord) {
            this.lastShownAtMillis = j;
            this.lastShownCampaignKey = str;
            this.shownVersions = map;
            this.pendingBilling = pendingBillingPromptRecord;
        }

        public /* synthetic */ PersistedState(long j, String str, Map map, PendingBillingPromptRecord pendingBillingPromptRecord, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : pendingBillingPromptRecord);
        }

        public final long getLastShownAtMillis() {
            return this.lastShownAtMillis;
        }

        public final String getLastShownCampaignKey() {
            return this.lastShownCampaignKey;
        }

        public final Map<String, Integer> getShownVersions() {
            return this.shownVersions;
        }

        public final PendingBillingPromptRecord getPendingBilling() {
            return this.pendingBilling;
        }
    }

    /* compiled from: ManagedPromptLedger.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger$Companion;", "", "<init>", "()V", "LEGACY_IMPORTED_CAMPAIGN_KEY", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
