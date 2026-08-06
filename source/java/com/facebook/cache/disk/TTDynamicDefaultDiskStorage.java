package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DynamicDefaultDiskStorage;
import com.facebook.common.file.FileTree;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.io.File;
import java.io.IOException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class TTDynamicDefaultDiskStorage extends DynamicDefaultDiskStorage implements TTDiskStorage {
    private final String mBaseDirectoryName;
    private final Supplier<File> mBaseDirectoryPathSupplier;
    private final CacheErrorLogger mCacheErrorLogger;
    private final String mConfigBaseDirectoryName;
    private final Supplier<File> mConfigBaseDirectoryPathSupplier;
    private final int mVersion;

    public TTDynamicDefaultDiskStorage(int i, Supplier<File> supplier, String str, CacheErrorLogger cacheErrorLogger, Supplier<File> supplier2, String str2) {
        super(i, supplier, str, supplier2, str2, cacheErrorLogger);
        this.mVersion = i;
        this.mCacheErrorLogger = cacheErrorLogger;
        this.mBaseDirectoryPathSupplier = supplier;
        this.mBaseDirectoryName = str;
        this.mConfigBaseDirectoryPathSupplier = supplier2;
        this.mConfigBaseDirectoryName = str2;
    }

    @Override // com.facebook.cache.disk.TTDiskStorage
    public BinaryResource getTempResource(String str, Object obj) throws IOException {
        if (get() instanceof TTDiskStorage) {
            return ((TTDiskStorage) get()).getTempResource(str, obj);
        }
        return null;
    }

    @Override // com.facebook.cache.disk.TTDiskStorage
    public DiskStorage.Inserter insertTemp(String str, int i, Object obj) throws IOException {
        if (get() instanceof TTDiskStorage) {
            return ((TTDiskStorage) get()).insertTemp(str, i, obj);
        }
        return null;
    }

    @Override // com.facebook.cache.disk.DynamicDefaultDiskStorage
    synchronized DiskStorage get() throws IOException {
        if (shouldCreateNewStorage()) {
            deleteOldStorageIfNecessary();
            createStorage();
        }
        return (DiskStorage) Preconditions.checkNotNull(this.mCurrentState.delegate);
    }

    private void createStorage() throws IOException {
        File file = new File(this.mBaseDirectoryPathSupplier.get(), this.mBaseDirectoryName);
        File file2 = new File(this.mConfigBaseDirectoryPathSupplier.get(), this.mConfigBaseDirectoryName);
        createRootDirectoryIfNecessary(file);
        createConfigRootDirectoryIfNecessary(file2);
        this.mCurrentState = new DynamicDefaultDiskStorage.State(file, new TTDefaultDiskStorage(file, file2, this.mVersion, this.mCacheErrorLogger));
    }

    private boolean shouldCreateNewStorage() {
        DynamicDefaultDiskStorage.State state = this.mCurrentState;
        return state.delegate == null || state.rootDirectory == null || !state.rootDirectory.exists();
    }

    @Override // com.facebook.cache.disk.DynamicDefaultDiskStorage
    void deleteOldStorageIfNecessary() {
        if (this.mCurrentState.delegate == null || this.mCurrentState.rootDirectory == null) {
            return;
        }
        FileTree.deleteRecursively(this.mCurrentState.rootDirectory);
    }
}
