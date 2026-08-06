package com.bytedance.android.live.core.setting.v2;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ISettingV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H&J1\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u0001H\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u0011J1\u0010\u0012\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0014JM\u0010\u0015\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u0002H\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0018J$\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/ISettingV2;", "", "clearAllTestKey", "", "containsTestKey", "", "key", "", "getCacheMap", "", "getOriginValue", "getTestOriginValue", "getTestUpdateValue", ExifInterface.GPS_DIRECTION_TRUE, "defaultValue", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "getTransientValue", "isLocalTest", "(Ljava/lang/String;Ljava/lang/reflect/Type;Z)Ljava/lang/Object;", "getValue", "isSticky", "isPreloadCache", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;ZZZ)Ljava/lang/Object;", "updateTestLocal", "value", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public interface ISettingV2 {
    void clearAllTestKey();

    boolean containsTestKey(String key);

    Map<String, Object> getCacheMap();

    Object getOriginValue(String key);

    Object getTestOriginValue(String key);

    <T> T getTestUpdateValue(String key, T defaultValue, Type type);

    <T> T getTransientValue(String key, Type type, boolean isLocalTest);

    <T> T getValue(String key, T defaultValue, Type type, boolean isSticky, boolean isLocalTest, boolean isPreloadCache);

    boolean updateTestLocal(String key, String value, Type type);

    /* compiled from: ISettingV2.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getValue$default(ISettingV2 iSettingV2, String str, Object obj, Type type, boolean z, boolean z2, boolean z3, int i, Object obj2) {
            if (obj2 == null) {
                return iSettingV2.getValue(str, obj, type, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getValue");
        }

        public static /* synthetic */ Object getTransientValue$default(ISettingV2 iSettingV2, String str, Type type, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTransientValue");
            }
            if ((i & 4) != 0) {
                z = false;
            }
            return iSettingV2.getTransientValue(str, type, z);
        }
    }
}
