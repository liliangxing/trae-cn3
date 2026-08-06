package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.xbridge.cn.runtime.utils.JsonUtils;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeStorageImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J0\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0016J(\u0010\u0018\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016JG\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010 J?\u0010!\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\"J.\u0010#\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002J,\u0010&\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002J$\u0010&\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/NativeStorageImpl;", "Lcom/bytedance/sdk/xbridge/cn/storage/utils/IBizNativeStorage;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "sharedPreferences", "Landroid/content/SharedPreferences;", "getBizEditorInternal", "Landroid/content/SharedPreferences$Editor;", "biz", "", "getBizSharedPreferencesInternal", "getBizStorageInfo", "", "getBizStorageItem", "", "key", "methodName", "sessionId", "getEditorInternal", "getSharedPreferencesInternal", "getStorageInfo", "getStorageItem", "removeBizStorageItem", "", "removeStorageItem", "setBizStorageItem", "data", "expiredTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Z", "setStorageItem", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Z", "unwrapValue", "value", "bridgeName", "wrapValueWithType", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NativeStorageImpl implements IBizNativeStorage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;
    private final SharedPreferences sharedPreferences;

    /* compiled from: NativeStorageImpl.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[XReadableType.values().length];
            try {
                iArr[XReadableType.Boolean.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[XReadableType.Int.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[XReadableType.Long.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[XReadableType.Number.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[XReadableType.String.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[XReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[XReadableType.Map.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ NativeStorageImpl(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private NativeStorageImpl(Context context) {
        this.context = context;
        this.sharedPreferences = context != null ? context.getSharedPreferences(NativeStorageImplKt.XBRIDGE_PREFERENCE_NAME, 0) : null;
    }

    public final Context getContext() {
        return this.context;
    }

    /* compiled from: NativeStorageImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/NativeStorageImpl$Companion;", "Lcom/bytedance/sdk/xbridge/cn/storage/utils/SingletonHolder;", "Lcom/bytedance/sdk/xbridge/cn/storage/utils/NativeStorageImpl;", "Landroid/content/Context;", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion extends SingletonHolder<NativeStorageImpl, Context> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: NativeStorageImpl.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        /* renamed from: com.bytedance.sdk.xbridge.cn.storage.utils.NativeStorageImpl$Companion$1 */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        /* synthetic */ class C01631 extends FunctionReferenceImpl implements Function1<Context, NativeStorageImpl> {
            public static final C01631 INSTANCE = new C01631();

            C01631() {
                super(1, NativeStorageImpl.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
            }

            public final NativeStorageImpl invoke(Context context) {
                return new NativeStorageImpl(context, null);
            }
        }

        private Companion() {
            super(C01631.INSTANCE);
        }
    }

    /* renamed from: getSharedPreferencesInternal, reason: from getter */
    private final SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    private final SharedPreferences getBizSharedPreferencesInternal(String biz) {
        Context context = this.context;
        if (context != null) {
            return context.getSharedPreferences(biz + "-xbridge-storage", 0);
        }
        return null;
    }

    private final SharedPreferences.Editor getEditorInternal() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.edit();
        }
        return null;
    }

    private final SharedPreferences.Editor getBizEditorInternal(String biz) {
        SharedPreferences bizSharedPreferencesInternal = getBizSharedPreferencesInternal(biz);
        if (bizSharedPreferencesInternal != null) {
            return bizSharedPreferencesInternal.edit();
        }
        return null;
    }

    private final String wrapValueWithType(Object value, String bridgeName, String sessionId) {
        String json;
        new LinkedHashMap();
        if (value instanceof Boolean) {
            json = JsonUtils.INSTANCE.toJson(new StorageValue(XReadableType.Boolean.name(), value.toString(), null, 4, null));
        } else if (value instanceof Integer) {
            json = JsonUtils.INSTANCE.toJson(new StorageValue(XReadableType.Int.name(), value.toString(), null, 4, null));
        } else if (value instanceof Long) {
            json = JsonUtils.INSTANCE.toJson(new StorageValue(XReadableType.Long.name(), value.toString(), null, 4, null));
        } else if (value instanceof Double) {
            json = JsonUtils.INSTANCE.toJson(new StorageValue(XReadableType.Number.name(), value.toString(), null, 4, null));
        } else if (value instanceof String) {
            json = JsonUtils.INSTANCE.toJson(new StorageValue(XReadableType.String.name(), value.toString(), null, 4, null));
        } else if (value instanceof List) {
            json = JsonUtils.INSTANCE.toJson(new StorageValue(XReadableType.Array.name(), JsonUtils.INSTANCE.toJson(value), null, 4, null));
        } else {
            json = value instanceof Map ? JsonUtils.INSTANCE.toJson(new StorageValue(XReadableType.Map.name(), JsonUtils.INSTANCE.toJson(value), null, 4, null)) : "";
        }
        if (bridgeName == null) {
            bridgeName = "unknown";
        }
        XBridgeInjectLogger.m174i(bridgeName, "content:" + json, "BridgeProcessing", sessionId);
        return json;
    }

    private final String wrapValueWithType(Object value, long expiredTime, String methodName, String sessionId) {
        String json;
        long currentTimeMillis = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(expiredTime);
        new LinkedHashMap();
        if (value instanceof Boolean) {
            json = JsonUtils.INSTANCE.toJson(new StorageValue(XReadableType.Boolean.name(), value.toString(), Long.valueOf(currentTimeMillis)));
        } else if (value instanceof Integer) {
            json = JsonUtils.INSTANCE.toJson(new StorageValue(XReadableType.Int.name(), value.toString(), Long.valueOf(currentTimeMillis)));
        } else if (value instanceof Long) {
            json = JsonUtils.INSTANCE.toJson(new StorageValue(XReadableType.Long.name(), value.toString(), Long.valueOf(currentTimeMillis)));
        } else if (value instanceof Double) {
            json = JsonUtils.INSTANCE.toJson(new StorageValue(XReadableType.Number.name(), value.toString(), Long.valueOf(currentTimeMillis)));
        } else if (value instanceof String) {
            json = JsonUtils.INSTANCE.toJson(new StorageValue(XReadableType.String.name(), value.toString(), Long.valueOf(currentTimeMillis)));
        } else if (value instanceof List) {
            json = JsonUtils.INSTANCE.toJson(new StorageValue(XReadableType.Array.name(), JsonUtils.INSTANCE.toJson(value), Long.valueOf(currentTimeMillis)));
        } else {
            json = value instanceof Map ? JsonUtils.INSTANCE.toJson(new StorageValue(XReadableType.Map.name(), JsonUtils.INSTANCE.toJson(value), Long.valueOf(currentTimeMillis))) : "";
        }
        if (methodName == null) {
            methodName = "unknown";
        }
        XBridgeInjectLogger.m174i(methodName, "expiredTime:" + currentTimeMillis + "|content:" + json, "BridgeProcessing", sessionId);
        return json;
    }

    private final Object unwrapValue(String key, String value, String bridgeName, String sessionId) {
        StorageValue storageValue = (StorageValue) JsonUtils.INSTANCE.fromJson(value, StorageValue.class);
        Long expiredTime = storageValue.getExpiredTime();
        long currentTimeMillis = System.currentTimeMillis();
        if (bridgeName == null) {
            bridgeName = "unknown";
        }
        XBridgeInjectLogger.m174i(bridgeName, "expiredTime:" + (expiredTime == null ? "null" : expiredTime) + "|curTime:" + currentTimeMillis + "|storageVal:" + storageValue, "BridgeProcessing", sessionId);
        if (expiredTime != null && currentTimeMillis > expiredTime.longValue()) {
            removeStorageItem(key);
            return null;
        }
        String value2 = storageValue.getValue();
        switch (WhenMappings.$EnumSwitchMapping$0[XReadableType.valueOf(storageValue.getType()).ordinal()]) {
            case 1:
                return Boolean.valueOf(Boolean.parseBoolean(value2));
            case 2:
                return Integer.valueOf(Integer.parseInt(value2));
            case 3:
                return Long.valueOf(Long.parseLong(value2));
            case 4:
                return Double.valueOf(Double.parseDouble(value2));
            case 5:
                return value2;
            case 6:
                return JsonUtils.INSTANCE.fromJson(value2, List.class);
            case 7:
                return JsonUtils.INSTANCE.fromJson(value2, Map.class);
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.INativeStorage
    public boolean setStorageItem(String key, Object data, Long expiredTime, String methodName, String sessionId) {
        SharedPreferences.Editor putString;
        SharedPreferences.Editor putString2;
        if (key == null || data == null) {
            return false;
        }
        Unit unit = null;
        if (expiredTime != null) {
            SharedPreferences.Editor editorInternal = getEditorInternal();
            if (editorInternal != null && (putString2 = editorInternal.putString(key, wrapValueWithType(data, expiredTime.longValue(), methodName, sessionId))) != null) {
                putString2.apply();
                unit = Unit.INSTANCE;
            }
            return unit != null;
        }
        SharedPreferences.Editor editorInternal2 = getEditorInternal();
        if (editorInternal2 != null && (putString = editorInternal2.putString(key, wrapValueWithType(data, methodName, sessionId))) != null) {
            putString.apply();
            unit = Unit.INSTANCE;
        }
        return unit != null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.IBizNativeStorage
    public boolean setBizStorageItem(String biz, String key, Object data, Long expiredTime, String methodName, String sessionId) {
        SharedPreferences.Editor putString;
        SharedPreferences.Editor putString2;
        Intrinsics.checkNotNullParameter(biz, "biz");
        if (key == null || data == null) {
            return false;
        }
        Unit unit = null;
        if (expiredTime != null) {
            SharedPreferences.Editor bizEditorInternal = getBizEditorInternal(biz);
            if (bizEditorInternal != null && (putString2 = bizEditorInternal.putString(key, wrapValueWithType(data, expiredTime.longValue(), methodName, sessionId))) != null) {
                putString2.apply();
                unit = Unit.INSTANCE;
            }
            return unit != null;
        }
        SharedPreferences.Editor bizEditorInternal2 = getBizEditorInternal(biz);
        if (bizEditorInternal2 != null && (putString = bizEditorInternal2.putString(key, wrapValueWithType(data, methodName, sessionId))) != null) {
            putString.apply();
            unit = Unit.INSTANCE;
        }
        return unit != null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.INativeStorage
    public boolean removeStorageItem(String key) {
        SharedPreferences sharedPreferences;
        Unit unit;
        SharedPreferences.Editor remove;
        if (key == null || (sharedPreferences = getSharedPreferences()) == null || !sharedPreferences.contains(key)) {
            return false;
        }
        SharedPreferences.Editor editorInternal = getEditorInternal();
        if (editorInternal == null || (remove = editorInternal.remove(key)) == null) {
            unit = null;
        } else {
            remove.apply();
            unit = Unit.INSTANCE;
        }
        return unit != null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.IBizNativeStorage
    public boolean removeBizStorageItem(String biz, String key) {
        SharedPreferences bizSharedPreferencesInternal;
        Unit unit;
        SharedPreferences.Editor remove;
        Intrinsics.checkNotNullParameter(biz, "biz");
        if (key == null || (bizSharedPreferencesInternal = getBizSharedPreferencesInternal(biz)) == null || !bizSharedPreferencesInternal.contains(key)) {
            return false;
        }
        SharedPreferences.Editor bizEditorInternal = getBizEditorInternal(biz);
        if (bizEditorInternal == null || (remove = bizEditorInternal.remove(key)) == null) {
            unit = null;
        } else {
            remove.apply();
            unit = Unit.INSTANCE;
        }
        return unit != null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.INativeStorage
    public Object getStorageItem(String key, String methodName, String sessionId) {
        SharedPreferences sharedPreferences;
        if (key == null || (sharedPreferences = getSharedPreferences()) == null || !sharedPreferences.contains(key)) {
            return null;
        }
        String string = sharedPreferences.getString(key, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        Intrinsics.checkNotNull(string);
        return unwrapValue(key, string, methodName, sessionId);
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.IBizNativeStorage
    public Object getBizStorageItem(String biz, String key, String methodName, String sessionId) {
        SharedPreferences bizSharedPreferencesInternal;
        Intrinsics.checkNotNullParameter(biz, "biz");
        if (key == null || (bizSharedPreferencesInternal = getBizSharedPreferencesInternal(biz)) == null || !bizSharedPreferencesInternal.contains(key)) {
            return null;
        }
        String string = bizSharedPreferencesInternal.getString(key, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        Intrinsics.checkNotNull(string);
        return unwrapValue(key, string, methodName, sessionId);
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.INativeStorage
    public Set<String> getStorageInfo() {
        Map<String, ?> all;
        Set<String> keySet;
        SharedPreferences sharedPreferences = getSharedPreferences();
        return (sharedPreferences == null || (all = sharedPreferences.getAll()) == null || (keySet = all.keySet()) == null) ? SetsKt.emptySet() : keySet;
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.IBizNativeStorage
    public Set<String> getBizStorageInfo(String biz) {
        Map<String, ?> all;
        Set<String> keySet;
        Intrinsics.checkNotNullParameter(biz, "biz");
        SharedPreferences bizSharedPreferencesInternal = getBizSharedPreferencesInternal(biz);
        return (bizSharedPreferencesInternal == null || (all = bizSharedPreferencesInternal.getAll()) == null || (keySet = all.keySet()) == null) ? SetsKt.emptySet() : keySet;
    }
}
