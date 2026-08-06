package com.bytedance.news.common.settings.storage;

import com.bytedance.news.common.settings.api.Storage;
import com.bytedance.news.common.settings.api.StorageFactory;
import com.bytedance.news.common.settings.internal.MetaInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class LocalSettingsStorageFactory implements StorageFactory {
    private static final ConcurrentHashMap<String, LocalSettingsStorage> CACHE = new ConcurrentHashMap<>();
    private static LocalSettingsStorageFactory INSTANCE;
    private StorageFactory mOriginalFactory;

    private LocalSettingsStorageFactory(StorageFactory storageFactory) {
        this.mOriginalFactory = storageFactory;
    }

    public static LocalSettingsStorageFactory getInstance(StorageFactory storageFactory) {
        if (INSTANCE == null) {
            synchronized (MetaInfo.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalSettingsStorageFactory(storageFactory);
                }
            }
        }
        return INSTANCE;
    }

    @Override // com.bytedance.news.common.settings.api.StorageFactory
    public Storage create(String str) {
        return create(str, false);
    }

    @Override // com.bytedance.news.common.settings.api.StorageFactory
    public Storage create(String str, boolean z) {
        ConcurrentHashMap<String, LocalSettingsStorage> concurrentHashMap = CACHE;
        LocalSettingsStorage localSettingsStorage = concurrentHashMap.get(str);
        if (localSettingsStorage != null) {
            return localSettingsStorage;
        }
        LocalSettingsStorage localSettingsStorage2 = new LocalSettingsStorage(str, this.mOriginalFactory.create(str));
        concurrentHashMap.put(str, localSettingsStorage2);
        return localSettingsStorage2;
    }
}
