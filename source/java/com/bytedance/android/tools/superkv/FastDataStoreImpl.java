package com.bytedance.android.tools.superkv;

import android.util.LruCache;
import com.bytedance.android.tools.superkv.IStorage;
import com.bytedance.android.tools.superkv.proto.KVProto;
import com.bytedance.applog.throttle.CongestionController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FastDataStoreImpl implements IDataStore, IStorage.DataInvalidCallback {
    static boolean USE_CACHE = true;
    private final LruCache<String, Object> cache;
    final boolean multiProcess;
    private final IStorage storage;

    private static <T> T getNonNull(T t, T t2) {
        return t == null ? t2 : t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FastDataStoreImpl(String str, int i, boolean z) throws IOException {
        this.multiProcess = z;
        this.cache = new LruCache<>(i);
        this.storage = new MappedStorage(str, z, this);
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public Boolean getBoolean(String str) {
        if (this.multiProcess) {
            this.storage.ensureUpToDate();
        }
        Object obj = this.cache.get(str);
        if (obj != null) {
            return (Boolean) obj;
        }
        KVProto fromStorage = getFromStorage(str, 3);
        if (fromStorage == null) {
            return null;
        }
        return Boolean.valueOf(fromStorage.booleanValue);
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public Integer getInteger(String str) {
        if (this.multiProcess) {
            this.storage.ensureUpToDate();
        }
        Object obj = this.cache.get(str);
        if (obj != null) {
            return (Integer) obj;
        }
        KVProto fromStorage = getFromStorage(str, 4);
        if (fromStorage == null) {
            return null;
        }
        return Integer.valueOf(fromStorage.intValue);
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public Long getLong(String str) {
        if (this.multiProcess) {
            this.storage.ensureUpToDate();
        }
        Object obj = this.cache.get(str);
        if (obj != null) {
            return (Long) obj;
        }
        KVProto fromStorage = getFromStorage(str, 5);
        if (fromStorage == null) {
            return null;
        }
        return Long.valueOf(fromStorage.longValue);
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public Float getFloat(String str) {
        if (this.multiProcess) {
            this.storage.ensureUpToDate();
        }
        Object obj = this.cache.get(str);
        if (obj != null) {
            return (Float) obj;
        }
        KVProto fromStorage = getFromStorage(str, 6);
        if (fromStorage == null) {
            return null;
        }
        return Float.valueOf(fromStorage.floatValue);
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public Double getDouble(String str) {
        if (this.multiProcess) {
            this.storage.ensureUpToDate();
        }
        Object obj = this.cache.get(str);
        if (obj != null) {
            return (Double) obj;
        }
        KVProto fromStorage = getFromStorage(str, 7);
        if (fromStorage == null) {
            return null;
        }
        return Double.valueOf(fromStorage.doubleValue);
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public String getString(String str) {
        if (this.multiProcess) {
            this.storage.ensureUpToDate();
        }
        Object obj = this.cache.get(str);
        if (obj != null) {
            return (String) obj;
        }
        KVProto fromStorage = getFromStorage(str, 8);
        if (fromStorage == null) {
            return null;
        }
        return fromStorage.stringValue;
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public byte[] getBytes(String str) {
        if (this.multiProcess) {
            this.storage.ensureUpToDate();
        }
        Object obj = this.cache.get(str);
        if (obj != null) {
            return (byte[]) obj;
        }
        KVProto fromStorage = getFromStorage(str, 9);
        if (fromStorage == null) {
            return null;
        }
        return fromStorage.bytesValue;
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public List<String> getStringList(String str) {
        if (this.multiProcess) {
            this.storage.ensureUpToDate();
        }
        Object obj = this.cache.get(str);
        if (obj != null) {
            return (List) obj;
        }
        KVProto fromStorage = getFromStorage(str, 10);
        if (fromStorage == null) {
            return null;
        }
        return fromStorage.stringListValue;
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public Boolean getBoolean(String str, boolean z) {
        return (Boolean) getNonNull(getBoolean(str), Boolean.valueOf(z));
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public Integer getInteger(String str, int i) {
        return (Integer) getNonNull(getInteger(str), Integer.valueOf(i));
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public Long getLong(String str, long j) {
        return (Long) getNonNull(getLong(str), Long.valueOf(j));
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public Float getFloat(String str, float f) {
        return (Float) getNonNull(getFloat(str), Float.valueOf(f));
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public Double getDouble(String str, double d) {
        return (Double) getNonNull(getDouble(str), Double.valueOf(d));
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public String getString(String str, String str2) {
        return (String) getNonNull(getString(str), str2);
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public List<String> getStringList(String str, List<String> list) {
        return (List) getNonNull(getStringList(str), list);
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public void putBoolean(String str, boolean z) {
        this.storage.put(str, z);
        this.cache.put(str, Boolean.valueOf(z));
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public void putInteger(String str, int i) {
        this.storage.put(str, i);
        this.cache.put(str, Integer.valueOf(i));
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public void putLong(String str, long j) {
        this.storage.put(str, j);
        this.cache.put(str, Long.valueOf(j));
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public void putFloat(String str, float f) {
        this.storage.put(str, f);
        this.cache.put(str, Float.valueOf(f));
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public void putDouble(String str, double d) {
        this.storage.put(str, d);
        this.cache.put(str, Double.valueOf(d));
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public void putString(String str, String str2) {
        this.storage.put(str, str2);
        this.cache.put(str, str2);
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public void putBytes(String str, byte[] bArr) {
        this.storage.put(str, bArr);
        this.cache.put(str, bArr);
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public void putStringList(String str, Collection<String> collection) {
        this.storage.put(str, new ArrayList(collection));
        this.cache.put(str, collection);
    }

    @Override // com.bytedance.android.tools.superkv.IDataStore
    public void remove(String str) {
        this.storage.remove(str);
        this.cache.remove(str);
    }

    @Override // com.bytedance.android.tools.superkv.IStorage.DataInvalidCallback
    public void onItemInvalid(String str) {
        this.cache.remove(str);
    }

    @Override // com.bytedance.android.tools.superkv.IStorage.DataInvalidCallback
    public void onAllInvalid() {
        this.cache.evictAll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        this.storage.release();
    }

    private KVProto getFromStorage(String str, int i) {
        KVProto kVProto = this.storage.get(str);
        if (kVProto == null) {
            return null;
        }
        if (kVProto.type == i) {
            return kVProto;
        }
        throw new IllegalStateException("Wrong type with key: " + str + ", expected: " + KVProto.getTypeString(Integer.valueOf(i)) + ", found: " + KVProto.getTypeString(Integer.valueOf(kVProto.type)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FastDataStoreImpl() {
        this.multiProcess = false;
        this.cache = new LruCache<>(CongestionController.MAX_REQUEST_FREQUENCY_REALTIME);
        this.storage = new IStorage() { // from class: com.bytedance.android.tools.superkv.FastDataStoreImpl.1
            @Override // com.bytedance.android.tools.superkv.IStorage
            public void ensureUpToDate() {
            }

            @Override // com.bytedance.android.tools.superkv.IStorage
            public KVProto get(String str) {
                return null;
            }

            @Override // com.bytedance.android.tools.superkv.IStorage
            public int put(String str, double d) {
                return 1;
            }

            @Override // com.bytedance.android.tools.superkv.IStorage
            public int put(String str, float f) {
                return 1;
            }

            @Override // com.bytedance.android.tools.superkv.IStorage
            public int put(String str, int i) {
                return 1;
            }

            @Override // com.bytedance.android.tools.superkv.IStorage
            public int put(String str, long j) {
                return 1;
            }

            @Override // com.bytedance.android.tools.superkv.IStorage
            public int put(String str, String str2) {
                return 1;
            }

            @Override // com.bytedance.android.tools.superkv.IStorage
            public int put(String str, List<String> list) {
                return 1;
            }

            @Override // com.bytedance.android.tools.superkv.IStorage
            public int put(String str, boolean z) {
                return 1;
            }

            @Override // com.bytedance.android.tools.superkv.IStorage
            public int put(String str, byte[] bArr) {
                return 1;
            }

            @Override // com.bytedance.android.tools.superkv.IStorage
            public void release() {
            }

            @Override // com.bytedance.android.tools.superkv.IStorage
            public void remove(String str) {
            }
        };
    }
}
