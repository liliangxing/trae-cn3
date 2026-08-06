package com.bytedance.platform.settingsx.map;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public class MapCacheIndex {
    private static final Set<Integer> cacheNodePtrIndex = new HashSet();
    private static boolean isInit;

    private static List<Integer> getInjectList() {
        return null;
    }

    private static synchronized void checkInit() {
        synchronized (MapCacheIndex.class) {
            if (isInit) {
                return;
            }
            isInit = true;
            List<Integer> injectList = getInjectList();
            if (injectList != null) {
                cacheNodePtrIndex.addAll(injectList);
            }
        }
    }

    public static boolean needCache(int i) {
        checkInit();
        return cacheNodePtrIndex.contains(Integer.valueOf(i));
    }
}
