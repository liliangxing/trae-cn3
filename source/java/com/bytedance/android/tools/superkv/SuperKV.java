package com.bytedance.android.tools.superkv;

import android.util.Base64;
import android.util.LruCache;
import java.io.File;
import java.io.IOException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SuperKV {
    private static final CachedProvider PROVIDER = new CachedProvider();
    private static transient boolean initialized = false;

    public static boolean isInitialized() {
        return initialized;
    }

    public static Configurator init() {
        return new Configurator();
    }

    public static IDataStore get(String str) {
        return get(str, false);
    }

    public static IDataStore get(String str, boolean z) {
        ensureInitialized();
        return PROVIDER.get(str, z);
    }

    public static void release() {
        PROVIDER.release();
        initialized = false;
    }

    private static void ensureInitialized() {
        if (!initialized) {
            throw new IllegalStateException("SuperKV must be initialized before using.");
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Configurator {
        private int cacheCapacity;
        private boolean debug;
        private String directory;
        private int initialMappedSize;
        private KVLogger logger;
        private int targetEntrySize;

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public interface KVLogger {
            public static final int LEVEL_ERROR = 3;
            public static final int LEVEL_INFO = 1;
            public static final int LEVEL_WARNING = 2;

            void onLog(int i, String str);

            void onLog(int i, String str, Throwable th);
        }

        private Configurator() {
            this.cacheCapacity = 64;
            this.initialMappedSize = MappedStorage.INITIAL_MAPPED_SIZE;
            this.targetEntrySize = MappedStorage.TARGET_ENTRY_SIZE;
            this.debug = false;
        }

        public Configurator setDirectory(String str) {
            this.directory = str;
            return this;
        }

        public Configurator setCacheCapacity(int i) {
            this.cacheCapacity = i;
            return this;
        }

        public Configurator setInitialMappedSize(int i) {
            this.initialMappedSize = i;
            return this;
        }

        public Configurator setTargetEntrySize(int i) {
            this.targetEntrySize = i;
            return this;
        }

        public Configurator setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Configurator setLogger(KVLogger kVLogger) {
            this.logger = kVLogger;
            return this;
        }

        public void apply() {
            if (SuperKV.initialized) {
                Debug.tryThrow(new IllegalStateException("SuperKV must not be initialized twice!"));
            }
            KVLogger kVLogger = this.logger;
            if (kVLogger != null) {
                Debug.logger = kVLogger;
            }
            if (this.cacheCapacity <= 0) {
                Debug.tryThrow(new IllegalArgumentException("Cache capacity must > 128"));
            }
            if (this.initialMappedSize <= 128) {
                Debug.tryThrow(new IllegalArgumentException("Initial file size must > 128"));
            }
            File file = new File(this.directory);
            if (!file.exists()) {
                file.mkdir();
            }
            SuperKV.PROVIDER.setup(this.directory, this.cacheCapacity);
            FastDataStoreImpl.USE_CACHE = this.cacheCapacity > 0;
            Debug.DEBUG = this.debug;
            MappedStorage.INITIAL_MAPPED_SIZE = this.initialMappedSize;
            MappedStorage.TARGET_ENTRY_SIZE = this.targetEntrySize;
            boolean unused = SuperKV.initialized = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class CachedProvider {
        private LruCache<String, FastDataStoreImpl> cache;
        private int capacity;
        private String directory;

        private CachedProvider() {
            this.cache = new LruCache<String, FastDataStoreImpl>(8) { // from class: com.bytedance.android.tools.superkv.SuperKV.CachedProvider.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.util.LruCache
                public void entryRemoved(boolean z, String str, FastDataStoreImpl fastDataStoreImpl, FastDataStoreImpl fastDataStoreImpl2) {
                    fastDataStoreImpl.release();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setup(String str, int i) {
            this.directory = str;
            this.capacity = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FastDataStoreImpl get(String str, boolean z) {
            FastDataStoreImpl fastDataStoreImpl = this.cache.get(str);
            if (fastDataStoreImpl != null) {
                if (fastDataStoreImpl.multiProcess == z) {
                    return fastDataStoreImpl;
                }
                fastDataStoreImpl.release();
            }
            try {
                fastDataStoreImpl = new FastDataStoreImpl(this.directory + File.separator + new String(Base64.encode(str.getBytes(), 2)), this.capacity, z);
            } catch (IOException e) {
                Debug.tryThrow(new IllegalStateException("Failed to create DataStore: " + str, e));
            }
            if (fastDataStoreImpl != null) {
                this.cache.put(str, fastDataStoreImpl);
                return fastDataStoreImpl;
            }
            return new FastDataStoreImpl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release() {
            this.cache.evictAll();
        }
    }
}
