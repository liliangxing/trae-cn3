package com.bytedance.trae.home.solo.sitemessage;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.common.apphost.AppHost;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SiteMessageReadTracker.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u00011B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bJ\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0006\u0010 \u001a\u00020\u0019J\u0016\u0010!\u001a\u00020\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0#H\u0002J\u000e\u0010$\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010%\u001a\u00020\u0019J\u0006\u0010&\u001a\u00020\u0019J\u0016\u0010'\u001a\u00020\u00192\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\b\u0010+\u001a\u00020\u0019H\u0002J\u001e\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0.H\u0002J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020*0#H\u0002J\u0016\u00100\u001a\u00020\u00192\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;", "", "<init>", "()V", "exposureDuration", "", "debounceInterval", "maxCachedEvents", "", "cacheExpirationDays", "pendingEventsKey", "", "handler", "Landroid/os/Handler;", "trackingStartTimes", "", "markedReadIds", "", "pendingReadIds", "tickRunnable", "Ljava/lang/Runnable;", "debounceRunnable", "gson", "Lcom/google/gson/Gson;", "startTracking", "", "messageId", "stopTracking", "tick", "ensureTickRunning", "stopTickIfNeeded", "scheduleDebounceFlush", "flushReadReport", "cachePendingReadEvents", "ids", "", "cachePendingDeleteEvent", "retryPendingEvents", "clearAll", "deduplicateAndSave", "events", "", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;", "cleanupStaleEvents", "removeEvents", DBData.FIELD_TYPE, "", "loadPendingEvents", "savePendingEvents", "PendingEvent", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SiteMessageReadTracker {
    public static final int $stable = 8;
    private Runnable debounceRunnable;
    private Runnable tickRunnable;
    private final long exposureDuration = 5000;
    private final long debounceInterval = 2000;
    private final int maxCachedEvents = 100;
    private final long cacheExpirationDays = 7;
    private final String pendingEventsKey = "SiteMessage.pendingEvents";
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Map<Integer, Long> trackingStartTimes = new LinkedHashMap();
    private final Set<Integer> markedReadIds = new LinkedHashSet();
    private final Set<Integer> pendingReadIds = new LinkedHashSet();
    private final Gson gson = new Gson();

    public final void startTracking(int messageId) {
        if (this.markedReadIds.contains(Integer.valueOf(messageId)) || this.trackingStartTimes.containsKey(Integer.valueOf(messageId))) {
            return;
        }
        this.trackingStartTimes.put(Integer.valueOf(messageId), Long.valueOf(System.currentTimeMillis()));
        ensureTickRunning();
    }

    public final void stopTracking(int messageId) {
        this.trackingStartTimes.remove(Integer.valueOf(messageId));
        stopTickIfNeeded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tick() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, Long> entry : this.trackingStartTimes.entrySet()) {
            int intValue = entry.getKey().intValue();
            if (currentTimeMillis - entry.getValue().longValue() >= this.exposureDuration) {
                arrayList.add(Integer.valueOf(intValue));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue2 = ((Number) it.next()).intValue();
            this.trackingStartTimes.remove(Integer.valueOf(intValue2));
            this.markedReadIds.add(Integer.valueOf(intValue2));
            this.pendingReadIds.add(Integer.valueOf(intValue2));
        }
        if (!arrayList.isEmpty()) {
            scheduleDebounceFlush();
        }
        stopTickIfNeeded();
    }

    private final void ensureTickRunning() {
        if (this.tickRunnable != null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker$ensureTickRunning$runnable$1
            @Override // java.lang.Runnable
            public void run() {
                Map map;
                Handler handler;
                SiteMessageReadTracker.this.tick();
                map = SiteMessageReadTracker.this.trackingStartTimes;
                if (!map.isEmpty()) {
                    handler = SiteMessageReadTracker.this.handler;
                    handler.postDelayed(this, 1000L);
                } else {
                    SiteMessageReadTracker.this.tickRunnable = null;
                }
            }
        };
        this.tickRunnable = runnable;
        this.handler.postDelayed(runnable, 1000L);
    }

    private final void stopTickIfNeeded() {
        if (this.trackingStartTimes.isEmpty()) {
            Runnable runnable = this.tickRunnable;
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
            this.tickRunnable = null;
        }
    }

    private final void scheduleDebounceFlush() {
        Runnable runnable = this.debounceRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                SiteMessageReadTracker.this.flushReadReport();
            }
        };
        this.debounceRunnable = runnable2;
        this.handler.postDelayed(runnable2, this.debounceInterval);
    }

    public final void flushReadReport() {
        Runnable runnable = this.debounceRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        this.debounceRunnable = null;
        final List list = CollectionsKt.toList(this.pendingReadIds);
        if (list.isEmpty()) {
            return;
        }
        this.pendingReadIds.clear();
        SiteMessageRepository.updateStatus$default(SiteMessageRepository.INSTANCE, list, "read", null, new Function0() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit flushReadReport$lambda$4;
                flushReadReport$lambda$4 = SiteMessageReadTracker.flushReadReport$lambda$4(SiteMessageReadTracker.this, list);
                return flushReadReport$lambda$4;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit flushReadReport$lambda$4(SiteMessageReadTracker siteMessageReadTracker, List list) {
        siteMessageReadTracker.cachePendingReadEvents(list);
        return Unit.INSTANCE;
    }

    private final void cachePendingReadEvents(List<Integer> ids) {
        List<PendingEvent> mutableList = CollectionsKt.toMutableList(loadPendingEvents());
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<T> it = ids.iterator();
        while (it.hasNext()) {
            mutableList.add(new PendingEvent(((Number) it.next()).intValue(), "read", currentTimeMillis));
        }
        deduplicateAndSave(mutableList);
    }

    public final void cachePendingDeleteEvent(int messageId) {
        List<PendingEvent> mutableList = CollectionsKt.toMutableList(loadPendingEvents());
        mutableList.add(new PendingEvent(messageId, "delete", System.currentTimeMillis()));
        deduplicateAndSave(mutableList);
    }

    public final void retryPendingEvents() {
        cleanupStaleEvents();
        List<PendingEvent> loadPendingEvents = loadPendingEvents();
        if (loadPendingEvents.isEmpty()) {
            return;
        }
        List<PendingEvent> list = loadPendingEvents;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((PendingEvent) obj).getEventType(), "read")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(Integer.valueOf(((PendingEvent) it.next()).getMessageId()));
        }
        final ArrayList arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : list) {
            if (Intrinsics.areEqual(((PendingEvent) obj2).getEventType(), "delete")) {
                arrayList5.add(obj2);
            }
        }
        ArrayList arrayList6 = arrayList5;
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
        Iterator it2 = arrayList6.iterator();
        while (it2.hasNext()) {
            arrayList7.add(Integer.valueOf(((PendingEvent) it2.next()).getMessageId()));
        }
        final ArrayList arrayList8 = arrayList7;
        if (!arrayList4.isEmpty()) {
            SiteMessageRepository.updateStatus$default(SiteMessageRepository.INSTANCE, arrayList4, "read", new Function0() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit retryPendingEvents$lambda$10;
                    retryPendingEvents$lambda$10 = SiteMessageReadTracker.retryPendingEvents$lambda$10(SiteMessageReadTracker.this, arrayList4);
                    return retryPendingEvents$lambda$10;
                }
            }, null, 8, null);
        }
        if (!arrayList8.isEmpty()) {
            SiteMessageRepository.updateStatus$default(SiteMessageRepository.INSTANCE, arrayList8, "delete", new Function0() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit retryPendingEvents$lambda$11;
                    retryPendingEvents$lambda$11 = SiteMessageReadTracker.retryPendingEvents$lambda$11(SiteMessageReadTracker.this, arrayList8);
                    return retryPendingEvents$lambda$11;
                }
            }, null, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit retryPendingEvents$lambda$10(SiteMessageReadTracker siteMessageReadTracker, List list) {
        siteMessageReadTracker.removeEvents("read", CollectionsKt.toSet(list));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit retryPendingEvents$lambda$11(SiteMessageReadTracker siteMessageReadTracker, List list) {
        siteMessageReadTracker.removeEvents("delete", CollectionsKt.toSet(list));
        return Unit.INSTANCE;
    }

    public final void clearAll() {
        this.trackingStartTimes.clear();
        this.markedReadIds.clear();
        this.pendingReadIds.clear();
        Runnable runnable = this.tickRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        this.tickRunnable = null;
        Runnable runnable2 = this.debounceRunnable;
        if (runnable2 != null) {
            this.handler.removeCallbacks(runnable2);
        }
        this.debounceRunnable = null;
        savePendingEvents(CollectionsKt.emptyList());
    }

    private final void deduplicateAndSave(List<PendingEvent> events) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List asReversedMutable = CollectionsKt.asReversedMutable(events);
        ArrayList arrayList = new ArrayList();
        for (Object obj : asReversedMutable) {
            PendingEvent pendingEvent = (PendingEvent) obj;
            if (linkedHashSet.add(pendingEvent.getMessageId() + '_' + pendingEvent.getEventType())) {
                arrayList.add(obj);
            }
        }
        List<PendingEvent> mutableList = CollectionsKt.toMutableList(CollectionsKt.reversed(arrayList));
        int size = mutableList.size();
        int i = this.maxCachedEvents;
        if (size > i) {
            savePendingEvents(CollectionsKt.takeLast(mutableList, i));
        } else {
            savePendingEvents(mutableList);
        }
    }

    private final void cleanupStaleEvents() {
        long currentTimeMillis = System.currentTimeMillis() - (this.cacheExpirationDays * 86400000);
        List<PendingEvent> loadPendingEvents = loadPendingEvents();
        ArrayList arrayList = new ArrayList();
        for (Object obj : loadPendingEvents) {
            if (((PendingEvent) obj).getTimestamp() >= currentTimeMillis) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() != loadPendingEvents.size()) {
            savePendingEvents(arrayList2);
        }
    }

    private final void removeEvents(String type, Set<Integer> ids) {
        List<PendingEvent> loadPendingEvents = loadPendingEvents();
        ArrayList arrayList = new ArrayList();
        for (Object obj : loadPendingEvents) {
            PendingEvent pendingEvent = (PendingEvent) obj;
            if ((Intrinsics.areEqual(pendingEvent.getEventType(), type) && ids.contains(Integer.valueOf(pendingEvent.getMessageId()))) ? false : true) {
                arrayList.add(obj);
            }
        }
        savePendingEvents(arrayList);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker$loadPendingEvents$1] */
    private final List<PendingEvent> loadPendingEvents() {
        String string = AppHost.INSTANCE.getApplication().getSharedPreferences("site_message", 0).getString(this.pendingEventsKey, null);
        if (string == null) {
            return CollectionsKt.emptyList();
        }
        try {
            Object fromJson = this.gson.fromJson(string, new TypeToken<List<? extends PendingEvent>>() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker$loadPendingEvents$1
            }.getType());
            Intrinsics.checkNotNull(fromJson);
            return (List) fromJson;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    private final void savePendingEvents(List<PendingEvent> events) {
        AppHost.INSTANCE.getApplication().getSharedPreferences("site_message", 0).edit().putString(this.pendingEventsKey, this.gson.toJson(events)).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SiteMessageReadTracker.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;", "", "messageId", "", "eventType", "", ReportConstant.COMMON_TIMESTAMP, "", "<init>", "(ILjava/lang/String;J)V", "getMessageId", "()I", "getEventType", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class PendingEvent {
        private final String eventType;
        private final int messageId;
        private final long timestamp;

        public static /* synthetic */ PendingEvent copy$default(PendingEvent pendingEvent, int i, String str, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = pendingEvent.messageId;
            }
            if ((i2 & 2) != 0) {
                str = pendingEvent.eventType;
            }
            if ((i2 & 4) != 0) {
                j = pendingEvent.timestamp;
            }
            return pendingEvent.copy(i, str, j);
        }

        /* renamed from: component1, reason: from getter */
        public final int getMessageId() {
            return this.messageId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getEventType() {
            return this.eventType;
        }

        /* renamed from: component3, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final PendingEvent copy(int messageId, String eventType, long timestamp) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            return new PendingEvent(messageId, eventType, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingEvent)) {
                return false;
            }
            PendingEvent pendingEvent = (PendingEvent) other;
            return this.messageId == pendingEvent.messageId && Intrinsics.areEqual(this.eventType, pendingEvent.eventType) && this.timestamp == pendingEvent.timestamp;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.messageId) * 31) + this.eventType.hashCode()) * 31) + Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "PendingEvent(messageId=" + this.messageId + ", eventType=" + this.eventType + ", timestamp=" + this.timestamp + ')';
        }

        public PendingEvent(int i, String str, long j) {
            Intrinsics.checkNotNullParameter(str, "eventType");
            this.messageId = i;
            this.eventType = str;
            this.timestamp = j;
        }

        public final int getMessageId() {
            return this.messageId;
        }

        public final String getEventType() {
            return this.eventType;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }
}
