package com.bytedance.android.live.core.setting.p027v2.cache;

import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingV2Monitor;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ICacheManger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u001e\u001fJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H&J1\u0010\u000e\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u0001H\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0002\u0010\u0013J9\u0010\u0014\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u0001H\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0002\u0010\u0015J,\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\fH&J\u001e\u0010\u001a\u001a\u00020\u001b2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH&J$\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\fH&¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger;", "", "clearAll", "", "clearAllTestKey", "containsKey", "key", "", "valueCacheType", "Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$CacheType;", "containsTestKey", "getCacheMap", "", "getTestOriginValue", "getTestValue", ExifInterface.GPS_DIRECTION_TRUE, "defaultValue", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "getValue", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$CacheType;)Ljava/lang/Object;", SettingV2Monitor.REPORT_TYPE_UPDATE, "operation", "Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$Operation;", "map", "updateCacheAllMap", "", "allCacheMap", "updateTest", "CacheType", "Operation", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface ICacheManger {

    /* compiled from: ICacheManger.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$CacheType;", "", "(Ljava/lang/String;I)V", "LOCAL_CACHE", "STICKY", "PRELOAD_CACHE", "TRANSIENT", "OBJECT", "live-setting_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public enum CacheType {
        LOCAL_CACHE,
        STICKY,
        PRELOAD_CACHE,
        TRANSIENT,
        OBJECT
    }

    /* compiled from: ICacheManger.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$Operation;", "", "(Ljava/lang/String;I)V", "PLUS", "MINUS", "live-setting_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public enum Operation {
        PLUS,
        MINUS
    }

    boolean clearAll();

    boolean clearAllTestKey();

    boolean containsKey(String key, CacheType valueCacheType);

    boolean containsTestKey(String key);

    Map<String, Object> getCacheMap();

    Object getTestOriginValue(String key);

    <T> Object getTestValue(String key, T defaultValue, Type type);

    <T> Object getValue(String key, T defaultValue, Type type, CacheType valueCacheType);

    boolean update(CacheType type, Operation operation, Map<String, ? extends Object> map);

    void updateCacheAllMap(Map<String, ? extends Object> allCacheMap);

    boolean updateTest(Operation operation, Map<String, ? extends Object> map);
}
