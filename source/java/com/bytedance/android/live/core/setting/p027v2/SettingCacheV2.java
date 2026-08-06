package com.bytedance.android.live.core.setting.p027v2;

import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.live.core.setting.LiveSettingOldContext;
import com.bytedance.android.live.core.setting.p027v2.cache.CacheManger;
import com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger;
import com.bytedance.android.live.core.setting.p027v2.helper.ConvertHelper;
import com.bytedance.android.live.core.setting.p027v2.helper.SettingGsonHelper;
import com.bytedance.android.live.core.setting.p027v2.helper.SettingOptConfig;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingReportMonitor;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingV2Monitor;
import com.bytedance.android.live.core.setting.p027v2.update.SettingIncStrategy;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingCacheV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\"\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0016\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cH\u0016J/\u0010\u001e\u001a\u0004\u0018\u0001H\u001f\"\u0004\b\u0000\u0010\u001f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0018\u001a\u0002H\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010 J/\u0010!\u001a\u0004\u0018\u00010\u001d\"\u0004\b\u0000\u0010\u001f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0018\u001a\u0002H\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010 J\u0012\u0010\"\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0013\u001a\u00020\fH\u0016J\"\u0010#\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0013\u001a\u00020\fH\u0016J1\u0010%\u001a\u0004\u0018\u0001H\u001f\"\u0004\b\u0000\u0010\u001f2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u0001H\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010 J/\u0010&\u001a\u0004\u0018\u0001H\u001f\"\u0004\b\u0000\u0010\u001f2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010'\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010(JG\u0010)\u001a\u0004\u0018\u0001H\u001f\"\u0004\b\u0000\u0010\u001f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0018\u001a\u0002H\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010*\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010,J9\u0010)\u001a\u0004\u0018\u00010\u001d\"\u0004\b\u0000\u0010\u001f2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u0001H\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010-J.\u0010.\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J$\u00102\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\b\u00103\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/SettingCacheV2;", "Lcom/bytedance/android/live/core/setting/v2/ISettingV2;", "()V", "BOOLEAN_TYPE", "", "DEFAULT_LONG_VALUE", "", "DEFAULT_TYPE", "JSON_ARRAY_TYPE", "JSON_OBJECT_TYPE", "LONG_TYPE", "PREFIX", "", "STRING_TYPE", "TAG", "clearAllTestKey", "", "containsKey", "", "key", "valueCacheType", "Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$CacheType;", "containsTestKey", "getBoolean", "defaultValue", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Ljava/lang/reflect/Type;", "getCacheMap", "", "", "getCacheObject", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "getNumber", "getOriginValue", "getString", "getTestOriginValue", "getTestUpdateValue", "getTransientValue", "isLocalTest", "(Ljava/lang/String;Ljava/lang/reflect/Type;Z)Ljava/lang/Object;", "getValue", "isSticky", "isPreloadCache", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;ZZZ)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$CacheType;)Ljava/lang/Object;", SettingV2Monitor.REPORT_TYPE_UPDATE, "operation", "Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$Operation;", "map", "updateTestLocal", StrategyConstants.VALUE, "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SettingCacheV2 implements ISettingV2 {
    public static final int BOOLEAN_TYPE = 4;
    public static final long DEFAULT_LONG_VALUE = -100;
    public static final int DEFAULT_TYPE = -1;
    public static final SettingCacheV2 INSTANCE = new SettingCacheV2();
    public static final int JSON_ARRAY_TYPE = 1;
    public static final int JSON_OBJECT_TYPE = 0;
    public static final int LONG_TYPE = 2;
    public static final String PREFIX = "__origin_Type__";
    public static final int STRING_TYPE = 3;
    private static final String TAG = "SettingCacheV2";

    private SettingCacheV2() {
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.ISettingV2
    public <T> T getTransientValue(String key, Type type, boolean isLocalTest) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        if (isLocalTest && SettingIncStrategy.INSTANCE.getMCacheManger().containsTestKey(key)) {
            Object testUpdateValue = getTestUpdateValue(key, null, type);
            SettingReportMonitor.printLog(SettingReportMonitor.TAG_TEST, "getValue 从test开始获取值，key=" + key + ", value = " + testUpdateValue);
            if (testUpdateValue != null) {
                return (T) SettingGsonHelper.INSTANCE.convertGson(testUpdateValue, type);
            }
            return null;
        }
        if (containsKey(key, ICacheManger.CacheType.TRANSIENT)) {
            Object value = getValue(key, null, type, ICacheManger.CacheType.TRANSIENT);
            if (value != null) {
                return (T) SettingGsonHelper.INSTANCE.convertGson(value, type);
            }
            return null;
        }
        if (!getCacheMap().containsKey(key) || (obj = getCacheMap().get(key)) == null) {
            return null;
        }
        SettingCacheV2 settingCacheV2 = INSTANCE;
        ICacheManger.CacheType cacheType = ICacheManger.CacheType.TRANSIENT;
        ICacheManger.Operation operation = ICacheManger.Operation.PLUS;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(key, obj);
        Unit unit = Unit.INSTANCE;
        settingCacheV2.update(cacheType, operation, linkedHashMap);
        return (T) SettingGsonHelper.INSTANCE.convertGson(obj, type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.setting.p027v2.ISettingV2
    public <T> T getValue(String key, T defaultValue, Type type, boolean isSticky, boolean isLocalTest, boolean isPreloadCache) {
        Object cacheObject;
        Intrinsics.checkNotNullParameter(key, "key");
        if (isLocalTest) {
            try {
                if (SettingIncStrategy.INSTANCE.getMCacheManger().containsTestKey(key)) {
                    T t = (T) getTestUpdateValue(key, defaultValue, type);
                    SettingReportMonitor.printLog(SettingReportMonitor.TAG_TEST, "getValue 从test开始获取值，key=" + key + ", value = " + t);
                    return t;
                }
            } catch (Exception e) {
                LiveSettingOldContext.m1270e(TAG, e);
                SettingV2Monitor settingV2Monitor = SettingV2Monitor.INSTANCE;
                String obj = type != null ? type.toString() : null;
                String obj2 = defaultValue != 0 ? defaultValue.toString() : null;
                Object originValue = getOriginValue(key);
                settingV2Monitor.reportGetValueException(1, key, obj, obj2, originValue != null ? originValue.toString() : null, e.getMessage());
                return defaultValue;
            }
        }
        if (defaultValue == 0) {
            return (T) getTransientValue(key, type, isLocalTest);
        }
        if (isSticky && containsKey(key, ICacheManger.CacheType.STICKY)) {
            Object value = getValue(key, defaultValue, type, ICacheManger.CacheType.STICKY);
            if (value instanceof Object) {
                r1 = value;
            }
            return r1 != null ? (T) r1 : defaultValue;
        }
        if (isPreloadCache && containsKey(key, ICacheManger.CacheType.PRELOAD_CACHE)) {
            Object value2 = getValue(key, defaultValue, type, ICacheManger.CacheType.PRELOAD_CACHE);
            if (value2 instanceof Object) {
                r1 = value2;
            }
            return r1 != null ? (T) r1 : defaultValue;
        }
        if (Intrinsics.areEqual(type, Boolean.class)) {
            cacheObject = Boolean.valueOf(getBoolean(key, ((Boolean) defaultValue).booleanValue(), type));
        } else if (Intrinsics.areEqual(type, String.class)) {
            cacheObject = getString(key, (String) defaultValue, type);
        } else if (Intrinsics.areEqual(type, Integer.class)) {
            cacheObject = getNumber(key, defaultValue, type);
            Long l = (Long) (!(cacheObject instanceof Long) ? null : cacheObject);
            if (l != null) {
                cacheObject = Integer.valueOf((int) l.longValue());
            }
        } else if (Intrinsics.areEqual(type, Float.class)) {
            Object number = getNumber(key, defaultValue, type);
            cacheObject = Float.valueOf(ConvertHelper.safeConvertFloat(number != null ? number.toString() : null, ((Float) defaultValue).floatValue()));
        } else if (Intrinsics.areEqual(type, Long.class)) {
            cacheObject = getNumber(key, defaultValue, type);
        } else {
            cacheObject = getCacheObject(key, defaultValue, type);
        }
        if (!(cacheObject instanceof Object)) {
            cacheObject = null;
        }
        if (isSticky && cacheObject != null) {
            ICacheManger.CacheType cacheType = ICacheManger.CacheType.STICKY;
            ICacheManger.Operation operation = ICacheManger.Operation.PLUS;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(key, cacheObject);
            Unit unit = Unit.INSTANCE;
            update(cacheType, operation, linkedHashMap);
        }
        if (isPreloadCache && cacheObject != null) {
            ICacheManger.CacheType cacheType2 = ICacheManger.CacheType.PRELOAD_CACHE;
            ICacheManger.Operation operation2 = ICacheManger.Operation.PLUS;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put(key, cacheObject);
            Unit unit2 = Unit.INSTANCE;
            update(cacheType2, operation2, linkedHashMap2);
        }
        return cacheObject != null ? (T) cacheObject : defaultValue;
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.ISettingV2
    public Object getOriginValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getCacheMap().get(key);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.ISettingV2
    public Map<String, Object> getCacheMap() {
        return SettingIncStrategy.INSTANCE.getMCacheManger().getCacheMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x009d, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r7, java.lang.Long.TYPE) != false) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Long] */
    @Override // com.bytedance.android.live.core.setting.p027v2.ISettingV2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean updateTestLocal(String key, String value, Type type) {
        String str;
        Intrinsics.checkNotNullParameter(key, "key");
        String str2 = value;
        if (str2 == null || str2.length() == 0) {
            CacheManger mCacheManger = SettingIncStrategy.INSTANCE.getMCacheManger();
            ICacheManger.Operation operation = ICacheManger.Operation.MINUS;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(key, "");
            Unit unit = Unit.INSTANCE;
            return mCacheManger.updateTest(operation, linkedHashMap);
        }
        CacheManger mCacheManger2 = SettingIncStrategy.INSTANCE.getMCacheManger();
        ICacheManger.Operation operation2 = ICacheManger.Operation.PLUS;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (Intrinsics.areEqual(type, Boolean.class) || Intrinsics.areEqual(type, Boolean.TYPE)) {
            str = Boolean.valueOf(Boolean.parseBoolean(value));
        } else if (Intrinsics.areEqual(type, Integer.class) || Intrinsics.areEqual(type, Integer.TYPE)) {
            str = Integer.valueOf(Integer.parseInt(value));
        } else if (Intrinsics.areEqual(type, Float.class) || Intrinsics.areEqual(type, Float.TYPE)) {
            str = Float.valueOf(Float.parseFloat(value));
        } else {
            if (!Intrinsics.areEqual(type, Long.class)) {
                str = value;
            }
            str = Long.valueOf(Long.parseLong(value));
        }
        linkedHashMap2.put(key, str);
        Unit unit2 = Unit.INSTANCE;
        return mCacheManger2.updateTest(operation2, linkedHashMap2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.setting.p027v2.ISettingV2
    public <T> T getTestUpdateValue(String key, T defaultValue, Type type) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            if (SettingIncStrategy.INSTANCE.getMCacheManger().containsTestKey(key)) {
                Object testValue = SettingIncStrategy.INSTANCE.getMCacheManger().getTestValue(key, defaultValue, type);
                r1 = testValue instanceof Object ? testValue : null;
                if (r1 == null) {
                    return defaultValue;
                }
            }
            return r1;
        } catch (Exception e) {
            SettingReportMonitor.INSTANCE.printELog("key = " + key + e.getLocalizedMessage());
            return defaultValue;
        }
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.ISettingV2
    public Object getTestOriginValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return SettingIncStrategy.INSTANCE.getMCacheManger().getTestOriginValue(key);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.ISettingV2
    public boolean containsTestKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return SettingIncStrategy.INSTANCE.getMCacheManger().containsTestKey(key);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.ISettingV2
    public void clearAllTestKey() {
        SettingIncStrategy.INSTANCE.getMCacheManger().clearAllTestKey();
    }

    private final boolean getBoolean(String key, boolean defaultValue, Type type) {
        Object value = getValue(key, Boolean.valueOf(defaultValue), type, ICacheManger.CacheType.LOCAL_CACHE);
        return value != null ? ConvertHelper.convertBoolean(value, defaultValue) : defaultValue;
    }

    private final String getString(String key, String defaultValue, Type type) {
        Object value = getValue(key, defaultValue, type, ICacheManger.CacheType.LOCAL_CACHE);
        if (value instanceof String) {
            return (String) value;
        }
        if (value != null) {
            defaultValue = SettingGsonHelper.INSTANCE.getMGson().toJson(value);
        }
        Intrinsics.checkNotNullExpressionValue(defaultValue, "if (value != null) {\n   …ltValue\n                }");
        return defaultValue;
    }

    private final <T> Object getNumber(String key, T defaultValue, Type type) {
        Object value = getValue(key, defaultValue, type, ICacheManger.CacheType.LOCAL_CACHE);
        return value != null ? value : defaultValue;
    }

    private final <T> T getCacheObject(String key, T defaultValue, Type type) {
        if (containsKey(key, ICacheManger.CacheType.OBJECT)) {
            T t = (T) getValue(key, defaultValue, type, ICacheManger.CacheType.OBJECT);
            Class<?> cls = (Class) (!(type instanceof Class) ? null : type);
            if (cls != null && t != null && t.getClass().isAssignableFrom(cls)) {
                return t != null ? t : defaultValue;
            }
        }
        Object value = getValue(key, defaultValue, type, ICacheManger.CacheType.LOCAL_CACHE);
        if (SettingOptConfig.INSTANCE.isOptV2()) {
            if (value != null) {
                defaultValue = (T) value;
            }
        } else if (value != null) {
            defaultValue = (T) SettingGsonHelper.INSTANCE.getMGson().fromJson(SettingGsonHelper.INSTANCE.getMGson().toJson(value), type);
        }
        if (defaultValue == null) {
            ICacheManger.CacheType cacheType = ICacheManger.CacheType.OBJECT;
            ICacheManger.Operation operation = ICacheManger.Operation.MINUS;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(key, "");
            Unit unit = Unit.INSTANCE;
            update(cacheType, operation, linkedHashMap);
        } else {
            ICacheManger.CacheType cacheType2 = ICacheManger.CacheType.OBJECT;
            ICacheManger.Operation operation2 = ICacheManger.Operation.PLUS;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put(key, defaultValue);
            Unit unit2 = Unit.INSTANCE;
            update(cacheType2, operation2, linkedHashMap2);
        }
        return defaultValue;
    }

    private final <T> Object getValue(String key, T defaultValue, Type type, ICacheManger.CacheType valueCacheType) {
        return SettingIncStrategy.INSTANCE.getMCacheManger().getValue(key, defaultValue, type, valueCacheType);
    }

    private final Object update(ICacheManger.CacheType type, ICacheManger.Operation operation, Map<String, ? extends Object> map) {
        return Boolean.valueOf(SettingIncStrategy.INSTANCE.getMCacheManger().update(type, operation, map));
    }

    private final boolean containsKey(String key, ICacheManger.CacheType valueCacheType) {
        return SettingIncStrategy.INSTANCE.getMCacheManger().containsKey(key, valueCacheType);
    }
}
