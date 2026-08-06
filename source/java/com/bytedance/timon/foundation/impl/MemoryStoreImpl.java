package com.bytedance.timon.foundation.impl;

import android.content.Context;
import com.bytedance.timon.foundation.interfaces.IStore;
import com.bytedance.timon.foundation.interfaces.IStoreRepo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryStoreImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/timon/foundation/impl/MemoryStoreImpl;", "Lcom/bytedance/timon/foundation/interfaces/IStore;", "()V", "stores", "", "", "Lcom/bytedance/timon/foundation/interfaces/IStoreRepo;", "getRepo", "context", "Landroid/content/Context;", "repoName", "mode", "", "MemoryStoreRepo", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class MemoryStoreImpl implements IStore {
    private final Map<String, IStoreRepo> stores = new LinkedHashMap();

    @Override // com.bytedance.timon.foundation.interfaces.IStore
    public IStoreRepo getRepo(Context context, String repoName, int mode) {
        Intrinsics.checkParameterIsNotNull(repoName, "repoName");
        IStoreRepo iStoreRepo = this.stores.get(repoName);
        if (iStoreRepo != null) {
            return iStoreRepo;
        }
        MemoryStoreRepo memoryStoreRepo = new MemoryStoreRepo();
        this.stores.put(repoName, memoryStoreRepo);
        return memoryStoreRepo;
    }

    /* compiled from: MemoryStoreImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\rH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J-\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001a2\u0006\u0010\u000b\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010\u001bJ(\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001d2\u0006\u0010\u000b\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0015H\u0016J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J\u0018\u0010$\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J#\u0010%\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0016¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dH\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/timon/foundation/impl/MemoryStoreImpl$MemoryStoreRepo;", "Lcom/bytedance/timon/foundation/interfaces/IStoreRepo;", "()V", "cache", "", "", "", "clear", "", "contains", "", "key", "getAll", "", "getBoolean", "defValue", "getBytes", "", "getFloat", "", "getInt", "", "getLong", "", "getString", "getStringArray", "", "(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;", "getStringSet", "", "putBoolean", "value", "putBytes", "putFloat", "putInt", "putLong", "putString", "putStringArray", "(Ljava/lang/String;[Ljava/lang/String;)V", "putStringSet", "remove", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes5.dex */
    private static final class MemoryStoreRepo implements IStoreRepo {
        private final Map<String, Object> cache = new LinkedHashMap();

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public void putString(String key, String value) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            Intrinsics.checkParameterIsNotNull(value, "value");
            this.cache.put(key, value);
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public void putInt(String key, int value) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            this.cache.put(key, Integer.valueOf(value));
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public void putLong(String key, long value) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            this.cache.put(key, Long.valueOf(value));
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public void putFloat(String key, float value) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            this.cache.put(key, Float.valueOf(value));
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public void putBoolean(String key, boolean value) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            this.cache.put(key, Boolean.valueOf(value));
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public void putStringSet(String key, Set<String> value) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            Intrinsics.checkParameterIsNotNull(value, "value");
            this.cache.put(key, value);
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public void putStringArray(String key, String[] value) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            Intrinsics.checkParameterIsNotNull(value, "value");
            this.cache.put(key, value);
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public void putBytes(String key, byte[] value) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            Intrinsics.checkParameterIsNotNull(value, "value");
            this.cache.put(key, value);
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public String getString(String key, String defValue) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return this.cache.containsKey(key) ? String.valueOf(this.cache.get(key)) : defValue;
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public int getInt(String key, int defValue) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            if (!this.cache.containsKey(key)) {
                return defValue;
            }
            Object obj = this.cache.get(key);
            if (obj != null) {
                return ((Integer) obj).intValue();
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public long getLong(String key, long defValue) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            if (!this.cache.containsKey(key)) {
                return defValue;
            }
            Object obj = this.cache.get(key);
            if (obj != null) {
                return ((Long) obj).longValue();
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public float getFloat(String key, float defValue) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            if (!this.cache.containsKey(key)) {
                return defValue;
            }
            Object obj = this.cache.get(key);
            if (obj != null) {
                return ((Float) obj).floatValue();
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public boolean getBoolean(String key, boolean defValue) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            if (!this.cache.containsKey(key)) {
                return defValue;
            }
            Object obj = this.cache.get(key);
            if (obj != null) {
                return ((Boolean) obj).booleanValue();
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public Set<String> getStringSet(String key, Set<String> defValue) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            if (!this.cache.containsKey(key)) {
                return defValue;
            }
            Object obj = this.cache.get(key);
            if (obj != null) {
                return (Set) obj;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public String[] getStringArray(String key, String[] defValue) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            if (!this.cache.containsKey(key)) {
                return defValue;
            }
            Object obj = this.cache.get(key);
            if (obj != null) {
                return (String[]) obj;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public byte[] getBytes(String key, byte[] defValue) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            Intrinsics.checkParameterIsNotNull(defValue, "defValue");
            Object obj = this.cache.get(key);
            if (!(obj instanceof byte[])) {
                obj = null;
            }
            byte[] bArr = (byte[]) obj;
            return bArr != null ? bArr : defValue;
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public Map<String, ?> getAll() {
            return this.cache;
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public void clear() {
            this.cache.clear();
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public void remove(String key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            this.cache.remove(key);
        }

        @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
        public boolean contains(String key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return this.cache.containsKey(key);
        }
    }
}
