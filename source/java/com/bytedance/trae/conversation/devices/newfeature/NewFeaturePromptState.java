package com.bytedance.trae.conversation.devices.newfeature;

import com.bytedance.trae.conversation.devices.DeviceProductType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NewFeaturePromptPolicy.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u0015\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J\t\u0010%\u001a\u00020\u000fHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J}\u0010'\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\rHÆ\u0001J\u0013\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u000bHÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001b¨\u0006-"}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;", "", "shownProductTypes", "", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "eligibleProductTypes", "registeredProductTypes", "shownRecords", "Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;", "highestShownVersions", "", "", "firstLoginObservedAtMillis", "", "hasConversation", "", "lastShownAtMillis", "<init>", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Map;JZJ)V", "getShownProductTypes", "()Ljava/util/Set;", "getEligibleProductTypes", "getRegisteredProductTypes", "getShownRecords", "getHighestShownVersions", "()Ljava/util/Map;", "getFirstLoginObservedAtMillis", "()J", "getHasConversation", "()Z", "getLastShownAtMillis", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class NewFeaturePromptState {
    private final Set<DeviceProductType> eligibleProductTypes;
    private final long firstLoginObservedAtMillis;
    private final boolean hasConversation;
    private final Map<DeviceProductType, Integer> highestShownVersions;
    private final long lastShownAtMillis;
    private final Set<DeviceProductType> registeredProductTypes;
    private final Set<DeviceProductType> shownProductTypes;
    private final Set<NewFeaturePromptRecord> shownRecords;

    public final Set<DeviceProductType> component1() {
        return this.shownProductTypes;
    }

    public final Set<DeviceProductType> component2() {
        return this.eligibleProductTypes;
    }

    public final Set<DeviceProductType> component3() {
        return this.registeredProductTypes;
    }

    public final Set<NewFeaturePromptRecord> component4() {
        return this.shownRecords;
    }

    public final Map<DeviceProductType, Integer> component5() {
        return this.highestShownVersions;
    }

    /* renamed from: component6, reason: from getter */
    public final long getFirstLoginObservedAtMillis() {
        return this.firstLoginObservedAtMillis;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getHasConversation() {
        return this.hasConversation;
    }

    /* renamed from: component8, reason: from getter */
    public final long getLastShownAtMillis() {
        return this.lastShownAtMillis;
    }

    public final NewFeaturePromptState copy(Set<? extends DeviceProductType> shownProductTypes, Set<? extends DeviceProductType> eligibleProductTypes, Set<? extends DeviceProductType> registeredProductTypes, Set<NewFeaturePromptRecord> shownRecords, Map<DeviceProductType, Integer> highestShownVersions, long firstLoginObservedAtMillis, boolean hasConversation, long lastShownAtMillis) {
        Intrinsics.checkNotNullParameter(shownProductTypes, "shownProductTypes");
        Intrinsics.checkNotNullParameter(eligibleProductTypes, "eligibleProductTypes");
        Intrinsics.checkNotNullParameter(registeredProductTypes, "registeredProductTypes");
        Intrinsics.checkNotNullParameter(shownRecords, "shownRecords");
        Intrinsics.checkNotNullParameter(highestShownVersions, "highestShownVersions");
        return new NewFeaturePromptState(shownProductTypes, eligibleProductTypes, registeredProductTypes, shownRecords, highestShownVersions, firstLoginObservedAtMillis, hasConversation, lastShownAtMillis);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewFeaturePromptState)) {
            return false;
        }
        NewFeaturePromptState newFeaturePromptState = (NewFeaturePromptState) other;
        return Intrinsics.areEqual(this.shownProductTypes, newFeaturePromptState.shownProductTypes) && Intrinsics.areEqual(this.eligibleProductTypes, newFeaturePromptState.eligibleProductTypes) && Intrinsics.areEqual(this.registeredProductTypes, newFeaturePromptState.registeredProductTypes) && Intrinsics.areEqual(this.shownRecords, newFeaturePromptState.shownRecords) && Intrinsics.areEqual(this.highestShownVersions, newFeaturePromptState.highestShownVersions) && this.firstLoginObservedAtMillis == newFeaturePromptState.firstLoginObservedAtMillis && this.hasConversation == newFeaturePromptState.hasConversation && this.lastShownAtMillis == newFeaturePromptState.lastShownAtMillis;
    }

    public int hashCode() {
        return (((((((((((((this.shownProductTypes.hashCode() * 31) + this.eligibleProductTypes.hashCode()) * 31) + this.registeredProductTypes.hashCode()) * 31) + this.shownRecords.hashCode()) * 31) + this.highestShownVersions.hashCode()) * 31) + Long.hashCode(this.firstLoginObservedAtMillis)) * 31) + Boolean.hashCode(this.hasConversation)) * 31) + Long.hashCode(this.lastShownAtMillis);
    }

    public String toString() {
        return "NewFeaturePromptState(shownProductTypes=" + this.shownProductTypes + ", eligibleProductTypes=" + this.eligibleProductTypes + ", registeredProductTypes=" + this.registeredProductTypes + ", shownRecords=" + this.shownRecords + ", highestShownVersions=" + this.highestShownVersions + ", firstLoginObservedAtMillis=" + this.firstLoginObservedAtMillis + ", hasConversation=" + this.hasConversation + ", lastShownAtMillis=" + this.lastShownAtMillis + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NewFeaturePromptState(Set<? extends DeviceProductType> set, Set<? extends DeviceProductType> set2, Set<? extends DeviceProductType> set3, Set<NewFeaturePromptRecord> set4, Map<DeviceProductType, Integer> map, long j, boolean z, long j2) {
        Intrinsics.checkNotNullParameter(set, "shownProductTypes");
        Intrinsics.checkNotNullParameter(set2, "eligibleProductTypes");
        Intrinsics.checkNotNullParameter(set3, "registeredProductTypes");
        Intrinsics.checkNotNullParameter(set4, "shownRecords");
        Intrinsics.checkNotNullParameter(map, "highestShownVersions");
        this.shownProductTypes = set;
        this.eligibleProductTypes = set2;
        this.registeredProductTypes = set3;
        this.shownRecords = set4;
        this.highestShownVersions = map;
        this.firstLoginObservedAtMillis = j;
        this.hasConversation = z;
        this.lastShownAtMillis = j2;
    }

    public final Set<DeviceProductType> getShownProductTypes() {
        return this.shownProductTypes;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ NewFeaturePromptState(Set set, Set set2, Set set3, Set set4, Map map, long j, boolean z, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, r1, r2, r3, r4, (i & 32) != 0 ? 0L : j, (i & 64) != 0 ? false : z, (i & 128) == 0 ? j2 : 0L);
        Set set5;
        LinkedHashMap linkedHashMap;
        Set set6 = (i & 2) != 0 ? ArraysKt.toSet(DeviceProductType.values()) : set2;
        Set emptySet = (i & 4) != 0 ? SetsKt.emptySet() : set3;
        if ((i & 8) != 0) {
            Set set7 = set;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set7, 10));
            Iterator it = set7.iterator();
            while (it.hasNext()) {
                arrayList.add(new NewFeaturePromptRecord((DeviceProductType) it.next(), 1));
            }
            set5 = CollectionsKt.toSet(arrayList);
        } else {
            set5 = set4;
        }
        if ((i & 16) != 0) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj : set5) {
                DeviceProductType productType = ((NewFeaturePromptRecord) obj).getProductType();
                Object obj2 = linkedHashMap2.get(productType);
                if (obj2 == null) {
                    obj2 = (List) new ArrayList();
                    linkedHashMap2.put(productType, obj2);
                }
                ((List) obj2).add(obj);
            }
            linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                Object key = entry.getKey();
                Iterator it2 = ((List) entry.getValue()).iterator();
                if (!it2.hasNext()) {
                    throw new NoSuchElementException();
                }
                int version = ((NewFeaturePromptRecord) it2.next()).getVersion();
                while (it2.hasNext()) {
                    int version2 = ((NewFeaturePromptRecord) it2.next()).getVersion();
                    if (version < version2) {
                        version = version2;
                    }
                }
                linkedHashMap.put(key, Integer.valueOf(version));
            }
        } else {
            linkedHashMap = map;
        }
    }

    public final Set<DeviceProductType> getEligibleProductTypes() {
        return this.eligibleProductTypes;
    }

    public final Set<DeviceProductType> getRegisteredProductTypes() {
        return this.registeredProductTypes;
    }

    public final Set<NewFeaturePromptRecord> getShownRecords() {
        return this.shownRecords;
    }

    public final Map<DeviceProductType, Integer> getHighestShownVersions() {
        return this.highestShownVersions;
    }

    public final long getFirstLoginObservedAtMillis() {
        return this.firstLoginObservedAtMillis;
    }

    public final boolean getHasConversation() {
        return this.hasConversation;
    }

    public final long getLastShownAtMillis() {
        return this.lastShownAtMillis;
    }
}
