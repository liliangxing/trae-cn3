package com.bytedance.news.common.settings.storage;

import com.bytedance.news.common.settings.api.Storage;
import com.bytedance.news.common.settings.api.StorageFactory;
import com.bytedance.news.common.settings.internal.GlobalConfig;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SharedFreferenceStorageFactory implements StorageFactory {
    private static final ConcurrentHashMap<String, SharedPreferenceStorage> CACHE = new ConcurrentHashMap<>();
    private static final String TAG = "SharedFreferenceStorage";

    @Override // com.bytedance.news.common.settings.api.StorageFactory
    public Storage create(String str) {
        return create(str, false);
    }

    @Override // com.bytedance.news.common.settings.api.StorageFactory
    public Storage create(String str, boolean z) {
        ConcurrentHashMap<String, SharedPreferenceStorage> concurrentHashMap = CACHE;
        SharedPreferenceStorage sharedPreferenceStorage = concurrentHashMap.get(str);
        if (sharedPreferenceStorage != null) {
            return sharedPreferenceStorage;
        }
        SharedPreferenceStorage sharedPreferenceStorage2 = new SharedPreferenceStorage(GlobalConfig.getContext(), str, z);
        concurrentHashMap.put(str, sharedPreferenceStorage2);
        return sharedPreferenceStorage2;
    }
}
