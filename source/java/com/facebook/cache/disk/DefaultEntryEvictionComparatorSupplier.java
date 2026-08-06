package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskStorage;

/* loaded from: classes6.dex */
public class DefaultEntryEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {
    @Override // com.facebook.cache.disk.EntryEvictionComparatorSupplier
    public EntryEvictionComparator get() {
        return new EntryEvictionComparator() { // from class: com.facebook.cache.disk.DefaultEntryEvictionComparatorSupplier.1
            @Override // java.util.Comparator
            public int compare(DiskStorage.Entry entry, DiskStorage.Entry entry2) {
                long timestamp = entry.getTimestamp();
                long timestamp2 = entry2.getTimestamp();
                if (!DiskCacheUtil.isOptDiskCacheLRU()) {
                    if (timestamp < timestamp2) {
                        return -1;
                    }
                    return timestamp2 == timestamp ? 0 : 1;
                }
                int visitCount = entry.getVisitCount();
                int visitCount2 = entry2.getVisitCount();
                if (visitCount != visitCount2) {
                    return visitCount < visitCount2 ? -1 : 1;
                }
                if (timestamp < timestamp2) {
                    return -1;
                }
                return timestamp2 == timestamp ? 0 : 1;
            }
        };
    }
}
