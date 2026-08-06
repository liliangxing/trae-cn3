package com.bytedance.android.live.core.setting.p027v2.cache;

import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger;
import com.bytedance.android.live.core.setting.p027v2.storage.LocalUpdateManger;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingV2Monitor;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CacheManger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0016\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0015H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J1\u0010\u0017\u001a\u0004\u0018\u00010\b\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u0001H\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010\u001cJ9\u0010\u001d\u001a\u0004\u0018\u00010\b\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u0001H\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u001eJ,\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0015H\u0016J\u001e\u0010#\u001a\u00020$2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0015H\u0016J$\u0010&\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0015H\u0002J$\u0010'\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0015H\u0002J$\u0010(\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0015H\u0002J$\u0010)\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0015H\u0016J$\u0010*\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/cache/CacheManger;", "Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger;", "()V", "mLocalUpdateManger", "Lcom/bytedance/android/live/core/setting/v2/storage/LocalUpdateManger;", "mObjectCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "mOnlyRemoteCache", "mPreloadCache", "mStickyCache", "clearAll", "", "clearAllTestKey", "containsKey", "key", "valueCacheType", "Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$CacheType;", "containsTestKey", "getCacheMap", "", "getTestOriginValue", "getTestValue", ExifInterface.GPS_DIRECTION_TRUE, "defaultValue", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "getValue", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$CacheType;)Ljava/lang/Object;", SettingV2Monitor.REPORT_TYPE_UPDATE, "operation", "Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$Operation;", "map", "updateCacheAllMap", "", "allCacheMap", "updateObject", "updatePreloadCache", "updateSticky", "updateTest", "updateTransient", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class CacheManger implements ICacheManger {
    private LocalUpdateManger mLocalUpdateManger = new LocalUpdateManger();
    private ConcurrentHashMap<String, Object> mStickyCache = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> mOnlyRemoteCache = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> mObjectCache = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> mPreloadCache = new ConcurrentHashMap<>();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        static {
            int[] iArr = new int[ICacheManger.CacheType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ICacheManger.CacheType.LOCAL_CACHE.ordinal()] = 1;
            iArr[ICacheManger.CacheType.TRANSIENT.ordinal()] = 2;
            iArr[ICacheManger.CacheType.STICKY.ordinal()] = 3;
            iArr[ICacheManger.CacheType.OBJECT.ordinal()] = 4;
            iArr[ICacheManger.CacheType.PRELOAD_CACHE.ordinal()] = 5;
            int[] iArr2 = new int[ICacheManger.CacheType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ICacheManger.CacheType.LOCAL_CACHE.ordinal()] = 1;
            iArr2[ICacheManger.CacheType.TRANSIENT.ordinal()] = 2;
            iArr2[ICacheManger.CacheType.STICKY.ordinal()] = 3;
            iArr2[ICacheManger.CacheType.OBJECT.ordinal()] = 4;
            iArr2[ICacheManger.CacheType.PRELOAD_CACHE.ordinal()] = 5;
            int[] iArr3 = new int[ICacheManger.CacheType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[ICacheManger.CacheType.STICKY.ordinal()] = 1;
            iArr3[ICacheManger.CacheType.TRANSIENT.ordinal()] = 2;
            iArr3[ICacheManger.CacheType.OBJECT.ordinal()] = 3;
            iArr3[ICacheManger.CacheType.PRELOAD_CACHE.ordinal()] = 4;
            int[] iArr4 = new int[ICacheManger.Operation.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[ICacheManger.Operation.MINUS.ordinal()] = 1;
            iArr4[ICacheManger.Operation.PLUS.ordinal()] = 2;
            int[] iArr5 = new int[ICacheManger.Operation.values().length];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[ICacheManger.Operation.MINUS.ordinal()] = 1;
            iArr5[ICacheManger.Operation.PLUS.ordinal()] = 2;
            int[] iArr6 = new int[ICacheManger.Operation.values().length];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[ICacheManger.Operation.MINUS.ordinal()] = 1;
            iArr6[ICacheManger.Operation.PLUS.ordinal()] = 2;
            int[] iArr7 = new int[ICacheManger.Operation.values().length];
            $EnumSwitchMapping$6 = iArr7;
            iArr7[ICacheManger.Operation.MINUS.ordinal()] = 1;
            iArr7[ICacheManger.Operation.PLUS.ordinal()] = 2;
        }
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger
    public boolean update(ICacheManger.CacheType type, ICacheManger.Operation operation, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(type, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(map, "map");
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            return this.mLocalUpdateManger.update(operation, map);
        }
        if (i == 2) {
            return updateTransient(operation, map);
        }
        if (i == 3) {
            return updateSticky(operation, map);
        }
        if (i == 4) {
            return updateObject(operation, map);
        }
        if (i == 5) {
            return updatePreloadCache(operation, map);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger
    public boolean updateTest(ICacheManger.Operation operation, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(map, "map");
        return this.mLocalUpdateManger.updateTest(operation, map);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger
    public <T> Object getTestValue(String key, T defaultValue, Type type) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mLocalUpdateManger.getTestValue(key, defaultValue, type);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger
    public boolean containsTestKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mLocalUpdateManger.containsTestKey(key);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger
    public boolean clearAllTestKey() {
        return this.mLocalUpdateManger.clearAllTestKeys();
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger
    public Object getTestOriginValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mLocalUpdateManger.getTestOriginValue(key);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger
    public <T> Object getValue(String key, T defaultValue, Type type, ICacheManger.CacheType valueCacheType) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(valueCacheType, "valueCacheType");
        int i = WhenMappings.$EnumSwitchMapping$1[valueCacheType.ordinal()];
        if (i == 1) {
            return this.mLocalUpdateManger.getValue(key, defaultValue, type);
        }
        if (i == 2) {
            return this.mOnlyRemoteCache.get(key);
        }
        if (i == 3) {
            return this.mStickyCache.get(key);
        }
        if (i == 4) {
            return this.mObjectCache.get(key);
        }
        if (i == 5) {
            return this.mPreloadCache.get(key);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger
    public boolean containsKey(String key, ICacheManger.CacheType valueCacheType) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(valueCacheType, "valueCacheType");
        int i = WhenMappings.$EnumSwitchMapping$2[valueCacheType.ordinal()];
        if (i == 1) {
            return this.mStickyCache.containsKey(key);
        }
        if (i == 2) {
            return this.mOnlyRemoteCache.containsKey(key);
        }
        if (i == 3) {
            return this.mObjectCache.containsKey(key);
        }
        if (i != 4) {
            return false;
        }
        return this.mPreloadCache.containsKey(key);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger
    public Map<String, Object> getCacheMap() {
        return this.mLocalUpdateManger.getLocalMap();
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger
    public void updateCacheAllMap(Map<String, ? extends Object> allCacheMap) {
        Intrinsics.checkNotNullParameter(allCacheMap, "allCacheMap");
        this.mLocalUpdateManger.updateAllCacheMap(allCacheMap);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger
    public boolean clearAll() {
        this.mStickyCache.clear();
        this.mObjectCache.clear();
        this.mPreloadCache.clear();
        return this.mLocalUpdateManger.clear();
    }

    private final boolean updateTransient(ICacheManger.Operation operation, Map<String, ? extends Object> map) {
        int i = WhenMappings.$EnumSwitchMapping$3[operation.ordinal()];
        if (i == 1) {
            Iterator<Map.Entry<String, ? extends Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                this.mOnlyRemoteCache.remove(it.next().getKey());
            }
        } else if (i == 2) {
            this.mOnlyRemoteCache.putAll(map);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return true;
    }

    private final boolean updateSticky(ICacheManger.Operation operation, Map<String, ? extends Object> map) {
        int i = WhenMappings.$EnumSwitchMapping$4[operation.ordinal()];
        if (i == 1) {
            Iterator<Map.Entry<String, ? extends Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                this.mStickyCache.remove(it.next().getKey());
            }
        } else if (i == 2) {
            this.mStickyCache.putAll(map);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return true;
    }

    private final boolean updateObject(ICacheManger.Operation operation, Map<String, ? extends Object> map) {
        int i = WhenMappings.$EnumSwitchMapping$5[operation.ordinal()];
        if (i == 1) {
            Iterator<Map.Entry<String, ? extends Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                this.mObjectCache.remove(it.next().getKey());
            }
        } else if (i == 2) {
            this.mObjectCache.putAll(map);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return true;
    }

    private final boolean updatePreloadCache(ICacheManger.Operation operation, Map<String, ? extends Object> map) {
        int i = WhenMappings.$EnumSwitchMapping$6[operation.ordinal()];
        if (i == 1) {
            Iterator<Map.Entry<String, ? extends Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                this.mPreloadCache.remove(it.next().getKey());
            }
        } else if (i == 2) {
            this.mPreloadCache.putAll(map);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return true;
    }
}
