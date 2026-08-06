package com.bytedance.pia.nsr;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pia.core.utils.Logger;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecordsCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001eB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u000bJ\u0006\u0010\u001c\u001a\u00020\u0003J\"\u0010\u001d\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/pia/nsr/RecordsCache;", "", "capacity", "", "(I)V", "getCapacity", "()I", "expiredTimes", "Ljava/util/PriorityQueue;", "Lkotlin/Pair;", "", "Lcom/bytedance/pia/nsr/RecordEntry;", "records", "", "Lcom/bytedance/pia/nsr/RecordsCache$Record;", "add", "", "url", "", IPiaCacheProvider.CacheConfig.FIELD_EXPIRE, "once", "", "result", "clearExpiredRecords", "contains", PrefetchRequestConfig.METHOD_GET, "remove", "entry", "size", "tryUpdateExistRecord", "Record", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RecordsCache {
    private final int capacity;
    private final PriorityQueue<Pair<Long, RecordEntry>> expiredTimes;
    private final Map<RecordEntry, Record> records;

    public RecordsCache() {
        this(0, 1, null);
    }

    public RecordsCache(int i) {
        this.capacity = i;
        this.records = new HashMap(i);
        this.expiredTimes = new PriorityQueue<>(i, new Comparator() { // from class: com.bytedance.pia.nsr.RecordsCache$expiredTimes$1
            @Override // java.util.Comparator
            public final int compare(Pair<Long, RecordEntry> pair, Pair<Long, RecordEntry> pair2) {
                return Intrinsics.compare(((Number) pair.getFirst()).longValue(), ((Number) pair2.getFirst()).longValue());
            }
        });
    }

    public /* synthetic */ RecordsCache(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10 : i);
    }

    public final int getCapacity() {
        return this.capacity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RecordsCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/pia/nsr/RecordsCache$Record;", "", "once", "", "result", "", "(ZLjava/lang/String;)V", "getOnce", "()Z", "setOnce", "(Z)V", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class Record {
        private boolean once;
        private String result;

        public static /* synthetic */ Record copy$default(Record record, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = record.once;
            }
            if ((i & 2) != 0) {
                str = record.result;
            }
            return record.copy(z, str);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getOnce() {
            return this.once;
        }

        /* renamed from: component2, reason: from getter */
        public final String getResult() {
            return this.result;
        }

        public final Record copy(boolean once, String result) {
            Intrinsics.checkNotNullParameter(result, "result");
            return new Record(once, result);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Record)) {
                return false;
            }
            Record record = (Record) other;
            return this.once == record.once && Intrinsics.areEqual(this.result, record.result);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.once) * 31) + this.result.hashCode();
        }

        public String toString() {
            return "Record(once=" + this.once + ", result=" + this.result + ')';
        }

        public Record(boolean z, String str) {
            Intrinsics.checkNotNullParameter(str, "result");
            this.once = z;
            this.result = str;
        }

        public final boolean getOnce() {
            return this.once;
        }

        public final void setOnce(boolean z) {
            this.once = z;
        }

        public final String getResult() {
            return this.result;
        }

        public final void setResult(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.result = str;
        }
    }

    private final void clearExpiredRecords() {
        long currentTimeMillis = System.currentTimeMillis();
        while ((!this.expiredTimes.isEmpty()) && ((Number) this.expiredTimes.peek().getFirst()).longValue() <= currentTimeMillis) {
            this.records.remove(this.expiredTimes.poll().getSecond());
        }
    }

    public final void add(String url, long expire, boolean once, String result) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        RecordEntry parse = RecordEntry.INSTANCE.parse(url);
        if (parse == null) {
            return;
        }
        clearExpiredRecords();
        if (this.records.containsKey(parse)) {
            remove(parse);
        }
        if (this.expiredTimes.size() == this.capacity) {
            this.records.remove(this.expiredTimes.poll().getSecond());
        }
        this.expiredTimes.add(new Pair<>(Long.valueOf(System.currentTimeMillis() + expire), parse));
        this.records.put(parse, new Record(once, result));
    }

    public final String get(String url) {
        Object obj;
        clearExpiredRecords();
        RecordEntry parse = RecordEntry.INSTANCE.parse(url);
        if (parse == null) {
            return null;
        }
        Iterator<T> it = this.records.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((RecordEntry) obj).match(parse)) {
                break;
            }
        }
        RecordEntry recordEntry = (RecordEntry) obj;
        if (recordEntry == null) {
            return null;
        }
        Record record = this.records.get(recordEntry);
        boolean z = false;
        if (record != null && record.getOnce()) {
            z = true;
        }
        if (z) {
            remove(recordEntry);
        }
        if (record != null) {
            return record.getResult();
        }
        return null;
    }

    public final boolean contains(String url) {
        String str;
        Object obj;
        Record record;
        clearExpiredRecords();
        RecordEntry parse = RecordEntry.INSTANCE.parse(url);
        if (parse == null) {
            return false;
        }
        Iterator<T> it = this.records.keySet().iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((RecordEntry) obj).match(parse)) {
                break;
            }
        }
        RecordEntry recordEntry = (RecordEntry) obj;
        if (recordEntry != null && (record = this.records.get(recordEntry)) != null) {
            str = record.getResult();
        }
        return str != null;
    }

    public final String tryUpdateExistRecord(String url, boolean once, long expire) {
        Object obj;
        Record record;
        clearExpiredRecords();
        RecordEntry parse = RecordEntry.INSTANCE.parse(url);
        if (parse == null) {
            return null;
        }
        Iterator<T> it = this.records.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((RecordEntry) obj).match(parse)) {
                break;
            }
        }
        final RecordEntry recordEntry = (RecordEntry) obj;
        if (recordEntry == null || (record = this.records.get(recordEntry)) == null) {
            return null;
        }
        CollectionsKt.removeAll(this.expiredTimes, new Function1<Pair<? extends Long, ? extends RecordEntry>, Boolean>() { // from class: com.bytedance.pia.nsr.RecordsCache$tryUpdateExistRecord$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Boolean invoke(Pair<Long, RecordEntry> pair) {
                return Boolean.valueOf(Intrinsics.areEqual(pair.getSecond(), RecordEntry.this));
            }
        });
        record.setOnce(once);
        this.expiredTimes.add(new Pair<>(Long.valueOf(System.currentTimeMillis() + expire), recordEntry));
        Logger.i$default("Update nsr record, url=" + url + ", once=" + once + ", expire=" + expire, null, null, 6, null);
        return record.getResult();
    }

    public final void remove(final RecordEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.records.remove(entry);
        CollectionsKt.removeAll(this.expiredTimes, new Function1<Pair<? extends Long, ? extends RecordEntry>, Boolean>() { // from class: com.bytedance.pia.nsr.RecordsCache$remove$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Boolean invoke(Pair<Long, RecordEntry> pair) {
                return Boolean.valueOf(Intrinsics.areEqual(pair.getSecond(), RecordEntry.this));
            }
        });
    }

    public final int size() {
        return this.expiredTimes.size();
    }
}
