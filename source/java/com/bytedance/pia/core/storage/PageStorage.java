package com.bytedance.pia.core.storage;

import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.storage.PageStorage;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.google.gson.JsonObject;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PageStorage implements IPageStorage {
    public static final String TAG = "[PageStorage]";
    private final JsonObject info;
    private final String pageName;

    public static void clearAll() {
        Storage.getInstance().clearAll();
    }

    public PageStorage(String str) {
        JsonObject jsonObject;
        this.pageName = str;
        String str2 = Storage.getInstance().get(str);
        try {
            if (TextUtils.isEmpty(str2)) {
                jsonObject = new JsonObject();
            } else {
                jsonObject = GsonUtils.getParser().parse(str2).getAsJsonObject();
            }
        } catch (Throwable th) {
            Logger.m179e("[PageStorage]The info is invalid, fallback to empty: ", th);
            jsonObject = new JsonObject();
        }
        this.info = jsonObject;
    }

    @Override // com.bytedance.pia.core.storage.IPageStorage
    public <T> void put(String str, T t) {
        synchronized (this.info) {
            try {
                this.info.add(str, GsonUtils.getGson().toJsonTree(t));
                Storage.getInstance().put(this.pageName, this.info.toString());
            } finally {
            }
        }
    }

    @Override // com.bytedance.pia.core.storage.IPageStorage
    public <T> T get(String str, Class<? extends T> cls) {
        try {
            return (T) GsonUtils.getGson().fromJson(this.info.get(str), cls);
        } catch (Throwable th) {
            Logger.m179e("[PageStorage]Get page info error:", th);
            return null;
        }
    }

    @Override // com.bytedance.pia.core.storage.IPageStorage
    public void remove(String str) {
        if (this.info.has(str)) {
            synchronized (this.info) {
                try {
                    this.info.remove(str);
                    Storage.getInstance().put(this.pageName, this.info.toString());
                } finally {
                }
            }
        }
    }

    public String toString() {
        return this.info.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Storage {
        private static final String PAGES_INFO_LAST_ACCESS_TIME_REPO_NAME = "pia_pages_info_last_access_time";
        private static final String PAGES_INFO_REPO_NAME = "pia_pages_info";
        private final int capacity;
        private final AtomicBoolean isClearing;
        private final Keva lastAccess;
        private final Keva pagesInfo;

        private Storage(int i) {
            this.isClearing = new AtomicBoolean(false);
            this.capacity = i;
            this.pagesInfo = Keva.getRepo(PAGES_INFO_REPO_NAME);
            this.lastAccess = Keva.getRepo(PAGES_INFO_LAST_ACCESS_TIME_REPO_NAME);
        }

        public void clearAll() {
            this.pagesInfo.clear();
            this.lastAccess.clear();
        }

        public String get(String str) {
            if (this.pagesInfo.contains(str)) {
                this.lastAccess.storeLong(str, System.currentTimeMillis());
                return this.pagesInfo.getString(str, "");
            }
            this.lastAccess.storeLong(str, System.currentTimeMillis());
            this.pagesInfo.storeString(str, "");
            clearIfNeed();
            return "";
        }

        public void put(String str, String str2) {
            this.lastAccess.storeLong(str, System.currentTimeMillis());
            this.pagesInfo.storeString(str, str2);
            clearIfNeed();
        }

        private void clearIfNeed() {
            if (this.lastAccess.count() < this.capacity) {
                return;
            }
            ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.storage.PageStorage$Storage$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    PageStorage.Storage.this.m174xd316300a();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$clearIfNeed$1$com-bytedance-pia-core-storage-PageStorage$Storage */
        public /* synthetic */ void m174xd316300a() {
            if (this.isClearing.compareAndSet(false, true)) {
                Set<Map.Entry<String, ?>> entrySet = this.lastAccess.getAll().entrySet();
                int i = (int) (this.capacity * 0.25d);
                PriorityQueue priorityQueue = new PriorityQueue(i, new Comparator() { // from class: com.bytedance.pia.core.storage.PageStorage$Storage$$ExternalSyntheticLambda0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return PageStorage.Storage.lambda$clearIfNeed$0((Map.Entry) obj, (Map.Entry) obj2);
                    }
                });
                SafeEntry safeEntry = new SafeEntry();
                Iterator<Map.Entry<String, ?>> it = entrySet.iterator();
                while (it.hasNext()) {
                    safeEntry.setEntry(it.next());
                    if (priorityQueue.size() < i) {
                        priorityQueue.offer(safeEntry);
                    } else {
                        Map.Entry entry = (Map.Entry) priorityQueue.peek();
                        if (entry != null && ((Long) entry.getValue()).longValue() > safeEntry.getValue().longValue()) {
                            priorityQueue.poll();
                            priorityQueue.offer(safeEntry);
                        }
                    }
                }
                Iterator it2 = priorityQueue.iterator();
                while (it2.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it2.next();
                    this.pagesInfo.erase((String) entry2.getKey());
                    this.lastAccess.erase((String) entry2.getKey());
                }
                this.isClearing.set(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ int lambda$clearIfNeed$0(Map.Entry entry, Map.Entry entry2) {
            return (int) (((Long) entry2.getValue()).longValue() - ((Long) entry.getValue()).longValue());
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        private static class SafeEntry implements Map.Entry<String, Long> {
            private Map.Entry<String, ?> entry;

            @Override // java.util.Map.Entry
            public Long setValue(Long l) {
                return null;
            }

            private SafeEntry() {
                this.entry = null;
            }

            public void setEntry(Map.Entry<String, ?> entry) {
                this.entry = entry;
            }

            @Override // java.util.Map.Entry
            public String getKey() {
                Map.Entry<String, ?> entry = this.entry;
                if (entry == null) {
                    return null;
                }
                return entry.getKey();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Map.Entry
            public Long getValue() {
                Map.Entry<String, ?> entry = this.entry;
                if (entry == null || !(entry.getValue() instanceof Long)) {
                    return -1L;
                }
                return (Long) this.entry.getValue();
            }
        }

        public static Storage getInstance() {
            return InstanceHolder.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static class InstanceHolder {
            private static final Storage INSTANCE = new Storage(Settings.get().getPageStorageCapacity());

            private InstanceHolder() {
            }
        }
    }
}
