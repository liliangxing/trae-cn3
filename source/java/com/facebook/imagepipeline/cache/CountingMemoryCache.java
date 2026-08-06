package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.HWClosableReleaser;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CountingMemoryCache<K, V> implements MemoryCache<K, V>, MemoryTrimmable {
    static final long PARAMS_INTERCHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5);
    public static boolean isForceRunInSubThread;
    private final CacheTrimStrategy mCacheTrimStrategy;
    final CountingLruMap<K, Entry<K, V>> mCachedEntries;
    final CountingLruMap<K, Entry<K, V>> mExclusiveEntries;
    protected MemoryCacheParams mMemoryCacheParams;
    private final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
    private final ValueDescriptor<V> mValueDescriptor;
    final Map<Bitmap, Object> mOtherEntries = new WeakHashMap();
    private long mLastCacheParamsCheck = SystemClock.uptimeMillis();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface CacheTrimStrategy {
        double getTrimRatio(MemoryTrimType memoryTrimType);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface EntryStateObserver<K> {
        void onExclusivityChanged(K k, boolean z);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class Entry<K, V> {
        public int clientCount = 0;
        public boolean isOrphan = false;
        public final K key;

        @Nullable
        public final EntryStateObserver<K> observer;
        public final CloseableReference<V> valueRef;

        private Entry(K k, CloseableReference<V> closeableReference, @Nullable EntryStateObserver<K> entryStateObserver) {
            this.key = (K) Preconditions.checkNotNull(k);
            this.valueRef = (CloseableReference) Preconditions.checkNotNull(CloseableReference.cloneOrNull(closeableReference));
            this.observer = entryStateObserver;
        }

        /* renamed from: of */
        static <K, V> Entry<K, V> m500of(K k, CloseableReference<V> closeableReference, @Nullable EntryStateObserver<K> entryStateObserver) {
            return new Entry<>(k, closeableReference, entryStateObserver);
        }
    }

    public CountingMemoryCache(ValueDescriptor<V> valueDescriptor, CacheTrimStrategy cacheTrimStrategy, Supplier<MemoryCacheParams> supplier) {
        this.mValueDescriptor = valueDescriptor;
        this.mExclusiveEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCachedEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCacheTrimStrategy = cacheTrimStrategy;
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = supplier.get();
    }

    public CountingLruMap<K, Entry<K, V>> getCachedEntries() {
        return this.mCachedEntries;
    }

    private ValueDescriptor<Entry<K, V>> wrapValueDescriptor(final ValueDescriptor<V> valueDescriptor) {
        return new ValueDescriptor<Entry<K, V>>() { // from class: com.facebook.imagepipeline.cache.CountingMemoryCache.1
            @Override // com.facebook.imagepipeline.cache.ValueDescriptor
            public int getSizeInBytes(Entry<K, V> entry) {
                return valueDescriptor.getSizeInBytes(entry.valueRef.get());
            }
        };
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference) {
        return cache(k, closeableReference, null);
    }

    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver) {
        Entry<K, V> remove;
        CloseableReference<V> closeableReference2;
        CloseableReference<V> closeableReference3;
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(closeableReference);
        maybeUpdateCacheParams();
        synchronized (this) {
            remove = this.mExclusiveEntries.remove(k);
            Entry<K, V> remove2 = this.mCachedEntries.remove(k);
            closeableReference2 = null;
            if (remove2 != null) {
                makeOrphan(remove2);
                closeableReference3 = referenceToClose(remove2);
            } else {
                closeableReference3 = null;
            }
            int sizeInBytes = this.mValueDescriptor.getSizeInBytes(closeableReference.get());
            if (canCacheNewValue(closeableReference.get())) {
                Entry<K, V> m500of = Entry.m500of(k, closeableReference, entryStateObserver);
                this.mCachedEntries.put(k, m500of);
                closeableReference2 = newClientReference(m500of);
            } else if (this.mMemoryCacheParams.mMemoryCacheOpt && sizeInBytes < Math.min(Math.min(this.mMemoryCacheParams.getMaxCacheSize(), this.mMemoryCacheParams.maxCacheEntrySize), this.mMemoryCacheParams.maxOptEntrySize)) {
                while (!canCacheNewValue(closeableReference.get())) {
                    K firstKey = this.mCachedEntries.getFirstKey();
                    releaseClientReferenceNew(this.mCachedEntries.get(firstKey));
                    this.mCachedEntries.remove(firstKey);
                    if (this.mMemoryCacheParams.mOptReuseMemoryCache && firstKey != null) {
                        MemoryCacheUtil.removeReuseBitmapCache(firstKey.toString());
                    }
                }
                Entry<K, V> m500of2 = Entry.m500of(k, closeableReference, entryStateObserver);
                this.mCachedEntries.put(k, m500of2);
                closeableReference2 = newClientReference(m500of2);
            }
        }
        CloseableReference.closeSafely((CloseableReference<?>) closeableReference3);
        maybeNotifyExclusiveEntryRemoval(remove);
        maybeEvictEntries();
        return closeableReference2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        if (getInUseSizeInBytes() <= (r3.mMemoryCacheParams.getMaxCacheSize() - r4)) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean canCacheNewValue(V v) {
        boolean z;
        int sizeInBytes = this.mValueDescriptor.getSizeInBytes(v);
        if (sizeInBytes <= this.mMemoryCacheParams.maxCacheEntrySize) {
            z = true;
            if (getInUseCount() <= this.mMemoryCacheParams.maxCacheEntries - 1) {
            }
        }
        z = false;
        return z;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @Nullable
    public CloseableReference<V> get(K k) {
        Entry<K, V> remove;
        CloseableReference<V> newClientReference;
        Preconditions.checkNotNull(k);
        synchronized (this) {
            remove = this.mExclusiveEntries.remove(k);
            Entry<K, V> entry = this.mCachedEntries.get(k);
            newClientReference = entry != null ? newClientReference(entry) : null;
        }
        maybeNotifyExclusiveEntryRemoval(remove);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return newClientReference;
    }

    private synchronized CloseableReference<V> newClientReference(final Entry<K, V> entry) {
        increaseClientCount(entry);
        return CloseableReference.m497of(entry.valueRef.get(), new ResourceReleaser<V>() { // from class: com.facebook.imagepipeline.cache.CountingMemoryCache.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(V v) {
                if (v instanceof CloseableStaticBitmap) {
                    HWClosableReleaser.getInstance().release(((CloseableStaticBitmap) v).getUnderlyingBitmap());
                }
                CountingMemoryCache.this.releaseClientReference(entry);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseClientReference(final Entry<K, V> entry) {
        boolean maybeAddToExclusives;
        CloseableReference<V> referenceToClose;
        boolean maybeAddToExclusives2;
        CloseableReference<V> referenceToClose2;
        if (!this.mMemoryCacheParams.mMemoryCacheOpt) {
            Preconditions.checkNotNull(entry);
        }
        if (isForceRunInSubThread) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                synchronized (this) {
                    decreaseClientCount(entry);
                    maybeAddToExclusives2 = maybeAddToExclusives(entry);
                    referenceToClose2 = referenceToClose(entry);
                }
                CloseableReference.closeSafely((CloseableReference<?>) referenceToClose2);
                if (!maybeAddToExclusives2) {
                    entry = null;
                }
                maybeNotifyExclusiveEntryInsertion(entry);
                maybeUpdateCacheParams();
                maybeEvictEntries();
                return;
            }
            DealCacheHelper.getIOExecutor().execute(new Runnable() { // from class: com.facebook.imagepipeline.cache.CountingMemoryCache.3
                @Override // java.lang.Runnable
                public void run() {
                    boolean maybeAddToExclusives3;
                    CloseableReference referenceToClose3;
                    synchronized (this) {
                        CountingMemoryCache.this.decreaseClientCount(entry);
                        maybeAddToExclusives3 = CountingMemoryCache.this.maybeAddToExclusives(entry);
                        referenceToClose3 = CountingMemoryCache.this.referenceToClose(entry);
                    }
                    CloseableReference.closeSafely((CloseableReference<?>) referenceToClose3);
                    CountingMemoryCache.maybeNotifyExclusiveEntryInsertion(maybeAddToExclusives3 ? entry : null);
                    CountingMemoryCache.this.maybeUpdateCacheParams();
                    CountingMemoryCache.this.maybeEvictEntries();
                }
            });
            return;
        }
        synchronized (this) {
            decreaseClientCount(entry);
            maybeAddToExclusives = maybeAddToExclusives(entry);
            referenceToClose = referenceToClose(entry);
        }
        CloseableReference.closeSafely((CloseableReference<?>) referenceToClose);
        if (!maybeAddToExclusives) {
            entry = null;
        }
        maybeNotifyExclusiveEntryInsertion(entry);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private void releaseClientReferenceNew(final Entry<K, V> entry) {
        boolean maybeAddToExclusives;
        CloseableReference<V> referenceToClose;
        boolean maybeAddToExclusives2;
        CloseableReference<V> referenceToClose2;
        if (!this.mMemoryCacheParams.mMemoryCacheOpt) {
            Preconditions.checkNotNull(entry);
        }
        if (isForceRunInSubThread) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                synchronized (this) {
                    decreaseClientCountNew(entry);
                    maybeAddToExclusives2 = maybeAddToExclusives(entry);
                    referenceToClose2 = referenceToClose(entry);
                }
                CloseableReference.closeSafely((CloseableReference<?>) referenceToClose2);
                if (!maybeAddToExclusives2) {
                    entry = null;
                }
                maybeNotifyExclusiveEntryInsertion(entry);
                maybeUpdateCacheParams();
                maybeEvictEntries();
                return;
            }
            DealCacheHelper.getIOExecutor().execute(new Runnable() { // from class: com.facebook.imagepipeline.cache.CountingMemoryCache.4
                @Override // java.lang.Runnable
                public void run() {
                    boolean maybeAddToExclusives3;
                    CloseableReference referenceToClose3;
                    synchronized (this) {
                        CountingMemoryCache.this.decreaseClientCountNew(entry);
                        maybeAddToExclusives3 = CountingMemoryCache.this.maybeAddToExclusives(entry);
                        referenceToClose3 = CountingMemoryCache.this.referenceToClose(entry);
                    }
                    CloseableReference.closeSafely((CloseableReference<?>) referenceToClose3);
                    CountingMemoryCache.maybeNotifyExclusiveEntryInsertion(maybeAddToExclusives3 ? entry : null);
                    CountingMemoryCache.this.maybeUpdateCacheParams();
                    CountingMemoryCache.this.maybeEvictEntries();
                }
            });
            return;
        }
        synchronized (this) {
            decreaseClientCountNew(entry);
            maybeAddToExclusives = maybeAddToExclusives(entry);
            referenceToClose = referenceToClose(entry);
        }
        CloseableReference.closeSafely((CloseableReference<?>) referenceToClose);
        if (!maybeAddToExclusives) {
            entry = null;
        }
        maybeNotifyExclusiveEntryInsertion(entry);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean maybeAddToExclusives(Entry<K, V> entry) {
        if (entry == null) {
            return false;
        }
        if (entry.isOrphan || entry.clientCount != 0) {
            return false;
        }
        this.mExclusiveEntries.put(entry.key, entry);
        return true;
    }

    @Nullable
    public CloseableReference<V> reuse(K k) {
        Entry<K, V> remove;
        CloseableReference<V> closeableReference;
        boolean z;
        Preconditions.checkNotNull(k);
        synchronized (this) {
            remove = this.mExclusiveEntries.remove(k);
            if (remove != null) {
                Entry<K, V> remove2 = this.mCachedEntries.remove(k);
                if (this.mMemoryCacheParams.mOptReuseMemoryCache) {
                    MemoryCacheUtil.removeReuseBitmapCache(k.toString());
                }
                if (!this.mMemoryCacheParams.mMemoryCacheOpt) {
                    Preconditions.checkNotNull(remove2);
                    Preconditions.checkState(remove2.clientCount == 0);
                }
                closeableReference = remove2 != null ? remove2.valueRef : null;
                z = true;
            }
        }
        if (z) {
            maybeNotifyExclusiveEntryRemoval(remove);
        }
        return closeableReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate<K> predicate) {
        ArrayList<Entry<K, V>> removeAll;
        ArrayList<Entry<K, V>> removeAll2;
        synchronized (this) {
            removeAll = this.mExclusiveEntries.removeAll(predicate);
            removeAll2 = this.mCachedEntries.removeAll(predicate);
            makeOrphans(removeAll2);
        }
        maybeClose(removeAll2);
        maybeNotifyExclusiveEntryRemoval(removeAll);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        if (this.mMemoryCacheParams.mOptReuseMemoryCache) {
            MemoryCacheUtil.clearReuseBitmapCacheMap();
        }
        return removeAll2.size();
    }

    public int removeAllForExclusive(Predicate<K> predicate) {
        ArrayList<Entry<K, V>> removeAll;
        ArrayList<Entry<K, V>> arrayList = new ArrayList<>();
        synchronized (this) {
            removeAll = this.mExclusiveEntries.removeAll(predicate);
            for (int i = 0; i < removeAll.size(); i++) {
                Entry<K, V> entry = removeAll.get(i);
                arrayList.add(this.mCachedEntries.remove(entry.key));
                if (this.mMemoryCacheParams.mOptReuseMemoryCache && entry.key != null) {
                    MemoryCacheUtil.removeReuseBitmapCache(entry.key.toString());
                }
            }
        }
        maybeClose(arrayList);
        maybeNotifyExclusiveEntryRemoval(removeAll);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return arrayList.size();
    }

    public void clear() {
        ArrayList<Entry<K, V>> clear;
        ArrayList<Entry<K, V>> clear2;
        synchronized (this) {
            clear = this.mExclusiveEntries.clear();
            clear2 = this.mCachedEntries.clear();
            makeOrphans(clear2);
        }
        maybeClose(clear2);
        maybeNotifyExclusiveEntryRemoval(clear);
        maybeUpdateCacheParams();
        if (this.mMemoryCacheParams.mOptReuseMemoryCache) {
            MemoryCacheUtil.clearReuseBitmapCacheMap();
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(Predicate<K> predicate) {
        return !this.mCachedEntries.getMatchingEntries(predicate).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.mCachedEntries.contains(k);
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        double trimRatio = this.mCacheTrimStrategy.getTrimRatio(memoryTrimType);
        synchronized (this) {
            trimExclusivelyOwnedEntries(Integer.MAX_VALUE, Math.max(0, ((int) (this.mCachedEntries.getSizeInBytes() * (1.0d - trimRatio))) - getInUseSizeInBytes()));
        }
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    public void clearByPercentage(Double d) {
        double doubleValue = d.doubleValue();
        synchronized (this) {
            int max = Math.max(0, (int) (this.mCachedEntries.getSizeInBytes() * (1.0d - doubleValue)));
            while (this.mCachedEntries.getSizeInBytes() > max) {
                K firstKey = this.mCachedEntries.getFirstKey();
                if (firstKey == null) {
                    return;
                }
                Entry<K, V> remove = this.mCachedEntries.remove(firstKey);
                Entry<K, V> remove2 = this.mExclusiveEntries.remove(firstKey);
                if (this.mMemoryCacheParams.mOptReuseMemoryCache) {
                    MemoryCacheUtil.removeReuseBitmapCache(firstKey.toString());
                }
                if (remove != null) {
                    makeOrphan(remove);
                    CloseableReference.closeSafely((CloseableReference<?>) referenceToClose(remove));
                }
                if (remove2 != null) {
                    maybeNotifyExclusiveEntryRemoval(remove2);
                }
            }
            maybeUpdateCacheParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void maybeUpdateCacheParams() {
        if (this.mLastCacheParamsCheck + PARAMS_INTERCHECK_INTERVAL_MS > SystemClock.uptimeMillis()) {
            return;
        }
        this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
        this.mMemoryCacheParams = this.mMemoryCacheParamsSupplier.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeEvictEntries() {
        synchronized (this) {
            trimExclusivelyOwnedEntries(Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount()), Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.getMaxCacheSize() - getInUseSizeInBytes()));
        }
    }

    @Nullable
    private synchronized void trimExclusivelyOwnedEntries(int i, int i2) {
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.mExclusiveEntries.getCount() <= max && this.mExclusiveEntries.getSizeInBytes() <= max2) {
            return;
        }
        while (true) {
            if (this.mExclusiveEntries.getCount() <= max && this.mExclusiveEntries.getSizeInBytes() <= max2) {
                return;
            }
            K firstKey = this.mExclusiveEntries.getFirstKey();
            if (firstKey == null) {
                return;
            }
            this.mExclusiveEntries.remove(firstKey);
            Entry<K, V> remove = this.mCachedEntries.remove(firstKey);
            if (this.mMemoryCacheParams.mOptReuseMemoryCache) {
                MemoryCacheUtil.removeReuseBitmapCache(firstKey.toString());
            }
            if (remove != null) {
                makeOrphan(remove);
                CloseableReference.closeSafely((CloseableReference<?>) referenceToClose(remove));
                maybeNotifyExclusiveEntryRemoval(remove);
            }
        }
    }

    private void maybeClose(@Nullable ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.closeSafely((CloseableReference<?>) referenceToClose(it.next()));
            }
        }
    }

    private void maybeNotifyExclusiveEntryRemoval(@Nullable ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                maybeNotifyExclusiveEntryRemoval(it.next());
            }
        }
    }

    private static <K, V> void maybeNotifyExclusiveEntryRemoval(@Nullable Entry<K, V> entry) {
        if (entry == null || entry.observer == null) {
            return;
        }
        entry.observer.onExclusivityChanged(entry.key, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void maybeNotifyExclusiveEntryInsertion(@Nullable Entry<K, V> entry) {
        if (entry == null || entry.observer == null) {
            return;
        }
        entry.observer.onExclusivityChanged(entry.key, true);
    }

    private synchronized void makeOrphans(@Nullable ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                makeOrphan(it.next());
            }
        }
    }

    private synchronized void makeOrphan(Entry<K, V> entry) {
        if (!this.mMemoryCacheParams.mMemoryCacheOpt) {
            Preconditions.checkNotNull(entry);
            Preconditions.checkState(!entry.isOrphan);
        }
        if (entry != null) {
            entry.isOrphan = true;
        }
    }

    private synchronized void increaseClientCount(Entry<K, V> entry) {
        if (!this.mMemoryCacheParams.mMemoryCacheOpt) {
            Preconditions.checkNotNull(entry);
            Preconditions.checkState(!entry.isOrphan);
        }
        if (entry != null) {
            entry.clientCount++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void decreaseClientCount(Entry<K, V> entry) {
        if (!this.mMemoryCacheParams.mMemoryCacheOpt) {
            Preconditions.checkNotNull(entry);
            Preconditions.checkState(entry.clientCount > 0);
        }
        if (entry != null) {
            entry.clientCount--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void decreaseClientCountNew(Entry<K, V> entry) {
        Preconditions.checkNotNull(entry);
        if (!this.mMemoryCacheParams.mMemoryCacheOpt) {
            Preconditions.checkState(entry.clientCount > 0);
            entry.clientCount = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public synchronized CloseableReference<V> referenceToClose(Entry<K, V> entry) {
        if (!this.mMemoryCacheParams.mMemoryCacheOpt) {
            Preconditions.checkNotNull(entry);
        }
        return (entry != null && entry.isOrphan && entry.clientCount == 0) ? entry.valueRef : null;
    }

    public synchronized int getCount() {
        return this.mCachedEntries.getCount();
    }

    public synchronized int getSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes();
    }

    public synchronized int getInUseCount() {
        return this.mCachedEntries.getCount() - this.mExclusiveEntries.getCount();
    }

    public synchronized int getInUseSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes() - this.mExclusiveEntries.getSizeInBytes();
    }

    public synchronized int getEvictionQueueCount() {
        return this.mExclusiveEntries.getCount();
    }

    public synchronized int getEvictionQueueSizeInBytes() {
        return this.mExclusiveEntries.getSizeInBytes();
    }
}
