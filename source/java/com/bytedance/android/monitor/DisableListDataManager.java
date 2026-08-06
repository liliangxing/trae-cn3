package com.bytedance.android.monitor;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class DisableListDataManager {
    private static volatile DisableListDataManager instance;
    private Map<String, Set<String>> data = new ConcurrentHashMap();

    public static DisableListDataManager get() {
        if (instance == null) {
            synchronized (DisableListDataManager.class) {
                if (instance == null) {
                    instance = new DisableListDataManager();
                }
            }
        }
        return instance;
    }

    private DisableListDataManager() {
    }

    public void registerDisableReportInfo(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return;
        }
        Set<String> set = this.data.get(str);
        if (set == null) {
            set = Collections.synchronizedSet(new HashSet());
            this.data.put(str, set);
        }
        synchronized (this) {
            set.addAll(list);
        }
    }

    public boolean isMatchDisable(String str, String str2) {
        Set<String> set;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (set = this.data.get(str)) == null) {
            return false;
        }
        if (set.contains("all")) {
            return true;
        }
        return set.contains(str2);
    }

    public void clear(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.data.remove(str);
    }

    public void clearAll() {
        this.data.clear();
    }
}
