package com.bytedance.apm6.frequency;

import java.util.ArrayList;

/* loaded from: classes3.dex */
class RecordItemCache {
    private static ThreadLocal<ArrayList<RecordItem>> listCache = new ThreadLocal<ArrayList<RecordItem>>() { // from class: com.bytedance.apm6.frequency.RecordItemCache.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ArrayList<RecordItem> initialValue() {
            ArrayList<RecordItem> arrayList = new ArrayList<>();
            arrayList.add(new RecordItem());
            arrayList.add(new RecordItem());
            return arrayList;
        }
    };

    RecordItemCache() {
    }

    public static RecordItem getCacheItem() {
        ArrayList<RecordItem> arrayList = listCache.get();
        if (!arrayList.get(0).isUsing()) {
            return arrayList.get(0);
        }
        if (arrayList.get(1).isUsing()) {
            return null;
        }
        return arrayList.get(1);
    }
}
