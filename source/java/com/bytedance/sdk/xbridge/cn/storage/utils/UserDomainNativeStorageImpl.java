package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.sdk.xbridge.cn.runtime.utils.JsonUtils;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserDomainNativeStorageImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J@\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0016J2\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\nJ$\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150!2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016JG\u0010\"\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010\u00162\b\u0010$\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010%J]\u0010&\u001a\u00020\n2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b2\b\u0010+\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010,R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006."}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/UserDomainNativeStorageImpl;", "Lcom/bytedance/sdk/xbridge/cn/storage/utils/IUserDomainNativeStorage;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getCreateTime", "", "storageName", "", "key", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "getUserDomainSPInternal", "Landroid/content/SharedPreferences;", "getUserDomainStorageEditorInternal", "Landroid/content/SharedPreferences$Editor;", "getUserDomainStorageInfo", "", "getUserDomainStorageItem", "Lkotlin/Triple;", "", "", "methodName", "sessionId", "getUserDomainStorageName", "appId", "userId", "modifyLastAccessTime", "", "userDomainStorageValue", "Lcom/bytedance/sdk/xbridge/cn/storage/utils/UserDomainStorageValue;", "removeUserDomainStorageItem", "Lkotlin/Pair;", "setUserDomainStorageItem", "data", "expiredTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Z", "wrapValueWithType", "value", "create_time", "last_access_time", "last_modified_time", "bridgeName", "(Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserDomainNativeStorageImpl implements IUserDomainNativeStorage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;

    /* compiled from: UserDomainNativeStorageImpl.kt */
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

    public /* synthetic */ UserDomainNativeStorageImpl(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private UserDomainNativeStorageImpl(Context context) {
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    /* compiled from: UserDomainNativeStorageImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/UserDomainNativeStorageImpl$Companion;", "Lcom/bytedance/sdk/xbridge/cn/storage/utils/SingletonHolder;", "Lcom/bytedance/sdk/xbridge/cn/storage/utils/UserDomainNativeStorageImpl;", "Landroid/content/Context;", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion extends SingletonHolder<UserDomainNativeStorageImpl, Context> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: UserDomainNativeStorageImpl.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        /* renamed from: com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainNativeStorageImpl$Companion$1 */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        /* synthetic */ class C01641 extends FunctionReferenceImpl implements Function1<Context, UserDomainNativeStorageImpl> {
            public static final C01641 INSTANCE = new C01641();

            C01641() {
                super(1, UserDomainNativeStorageImpl.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
            }

            public final UserDomainNativeStorageImpl invoke(Context context) {
                return new UserDomainNativeStorageImpl(context, null);
            }
        }

        private Companion() {
            super(C01641.INSTANCE);
        }
    }

    private final SharedPreferences getUserDomainSPInternal(String storageName) {
        Context context = this.context;
        if (context != null) {
            return context.getSharedPreferences(storageName + "_xbridge_storage", 0);
        }
        return null;
    }

    private final SharedPreferences.Editor getUserDomainStorageEditorInternal(String storageName) {
        SharedPreferences userDomainSPInternal = getUserDomainSPInternal(storageName);
        if (userDomainSPInternal != null) {
            return userDomainSPInternal.edit();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String wrapValueWithType(Object value, Long create_time, Long last_access_time, Long last_modified_time, Long expiredTime, String bridgeName, String sessionId) {
        String str;
        String str2;
        String name;
        String json;
        Long l = null;
        if (expiredTime != null) {
            long longValue = expiredTime.longValue();
            if (longValue > 0) {
                l = Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(longValue));
            }
        }
        if (value instanceof Boolean) {
            name = XReadableType.Boolean.name();
            json = String.valueOf(((Boolean) value).booleanValue());
        } else if (value instanceof Integer) {
            name = XReadableType.Int.name();
            json = String.valueOf(((Number) value).intValue());
        } else if (value instanceof Long) {
            name = XReadableType.Long.name();
            json = String.valueOf(((Number) value).longValue());
        } else if (value instanceof Double) {
            name = XReadableType.Number.name();
            json = String.valueOf(((Number) value).doubleValue());
        } else if (value instanceof String) {
            name = XReadableType.String.name();
            json = value.toString();
        } else if (value instanceof List) {
            name = XReadableType.Array.name();
            json = JsonUtils.INSTANCE.toJson(value);
        } else if (value instanceof Map) {
            name = XReadableType.Map.name();
            json = JsonUtils.INSTANCE.toJson(value);
        } else {
            str = "";
            str2 = str;
            String json2 = JsonUtils.INSTANCE.toJson(new UserDomainStorageValue(str, str2, create_time, last_access_time, last_modified_time, l));
            if (bridgeName == null) {
                bridgeName = "unknown";
            }
            XBridgeInjectLogger.m174i(bridgeName, "createTime:" + create_time + ",last_access_time:" + last_access_time + ",last_modified_time:" + last_modified_time + ",expiredTime:" + l + "|content:" + json2, "BridgeProcessing", sessionId);
            return json2;
        }
        str2 = json;
        str = name;
        String json22 = JsonUtils.INSTANCE.toJson(new UserDomainStorageValue(str, str2, create_time, last_access_time, last_modified_time, l));
        if (bridgeName == null) {
        }
        XBridgeInjectLogger.m174i(bridgeName, "createTime:" + create_time + ",last_access_time:" + last_access_time + ",last_modified_time:" + last_modified_time + ",expiredTime:" + l + "|content:" + json22, "BridgeProcessing", sessionId);
        return json22;
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.IUserDomainNativeStorage
    public boolean setUserDomainStorageItem(String storageName, String key, Object data, Long expiredTime, String methodName, String sessionId) {
        Unit unit;
        SharedPreferences.Editor putString;
        Intrinsics.checkNotNullParameter(storageName, "storageName");
        if (key == null || data == null) {
            return false;
        }
        Long createTime = getCreateTime(storageName, key);
        String wrapValueWithType = wrapValueWithType(data, Long.valueOf(createTime != null ? createTime.longValue() : System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()), expiredTime, methodName, sessionId);
        if (wrapValueWithType.length() == 0) {
            return false;
        }
        SharedPreferences.Editor userDomainStorageEditorInternal = getUserDomainStorageEditorInternal(storageName);
        if (userDomainStorageEditorInternal == null || (putString = userDomainStorageEditorInternal.putString(key, wrapValueWithType)) == null) {
            unit = null;
        } else {
            putString.apply();
            unit = Unit.INSTANCE;
        }
        return unit != null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.IUserDomainNativeStorage
    public Triple<Boolean, Boolean, Object> getUserDomainStorageItem(String storageName, String key, String methodName, String sessionId) {
        boolean z;
        Object valueOf;
        Intrinsics.checkNotNullParameter(storageName, "storageName");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences userDomainSPInternal = getUserDomainSPInternal(storageName);
        if (userDomainSPInternal == null) {
            XBridgeInjectLogger.m174i(methodName != null ? methodName : "unknown", "The storage of uid is not exist. So data is not exist.", "BridgeProcessing", sessionId);
            return new Triple<>(false, false, (Object) null);
        }
        if (!userDomainSPInternal.contains(key)) {
            XBridgeInjectLogger.m174i(methodName != null ? methodName : "unknown", "Data is not exist.", "BridgeProcessing", sessionId);
            return new Triple<>(false, false, (Object) null);
        }
        String str = "";
        String string = userDomainSPInternal.getString(key, "");
        String str2 = string;
        if (str2 == null || str2.length() == 0) {
            XBridgeInjectLogger.m174i(methodName != null ? methodName : "unknown", "key:" + key + ", Data is not exist.", "BridgeProcessing", sessionId);
            return new Triple<>(false, false, (Object) null);
        }
        try {
            JsonUtils jsonUtils = JsonUtils.INSTANCE;
            if (string != null) {
                str = string;
            }
            UserDomainStorageValue userDomainStorageValue = (UserDomainStorageValue) jsonUtils.fromJson(str, UserDomainStorageValue.class);
            Long expiredTime = userDomainStorageValue.getExpiredTime();
            long currentTimeMillis = System.currentTimeMillis();
            XBridgeInjectLogger.m174i(methodName == null ? "unknown" : methodName, "expiredTime:" + (expiredTime == null ? "null" : expiredTime) + "|curTime:" + currentTimeMillis + "|storageVal:" + userDomainStorageValue, "BridgeProcessing", sessionId);
            if (expiredTime != null && currentTimeMillis > expiredTime.longValue()) {
                try {
                    XBridgeInjectLogger.m174i(methodName == null ? "unknown" : methodName, "The data is expired. expiredTime:" + expiredTime + "|curTime:" + currentTimeMillis + "|storageVal:" + userDomainStorageValue, "BridgeProcessing", sessionId);
                    Pair<Boolean, Boolean> removeUserDomainStorageItem = removeUserDomainStorageItem(storageName, key);
                    ((Boolean) removeUserDomainStorageItem.component1()).booleanValue();
                    ((Boolean) removeUserDomainStorageItem.component2()).booleanValue();
                    return new Triple<>(true, true, (Object) null);
                } catch (Exception e) {
                    e = e;
                    z = true;
                    XBridgeInjectLogger.m174i(methodName != null ? methodName : "unknown", "JSON deserialization failed.Error:" + e, "BridgeProcessing", sessionId);
                    return new Triple<>(true, Boolean.valueOf(z), (Object) null);
                }
            }
            String value = userDomainStorageValue.getValue();
            String type = userDomainStorageValue.getType();
            if (type == null) {
                return new Triple<>(true, false, (Object) null);
            }
            if (value != null) {
                modifyLastAccessTime(storageName, key, userDomainStorageValue, methodName, sessionId);
                switch (WhenMappings.$EnumSwitchMapping$0[XReadableType.valueOf(type).ordinal()]) {
                    case 1:
                        valueOf = Boolean.valueOf(Boolean.parseBoolean(value));
                        break;
                    case 2:
                        valueOf = Integer.valueOf(Integer.parseInt(value));
                        break;
                    case 3:
                        valueOf = Long.valueOf(Long.parseLong(value));
                        break;
                    case 4:
                        valueOf = Double.valueOf(Double.parseDouble(value));
                        break;
                    case 5:
                        valueOf = value;
                        break;
                    case 6:
                        valueOf = JsonUtils.INSTANCE.fromJson(value, List.class);
                        break;
                    case 7:
                        valueOf = JsonUtils.INSTANCE.fromJson(value, Map.class);
                        break;
                    default:
                        valueOf = null;
                        break;
                }
                return new Triple<>(true, false, valueOf);
            }
            return new Triple<>(true, false, (Object) null);
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.IUserDomainNativeStorage
    public Pair<Boolean, Boolean> removeUserDomainStorageItem(String storageName, String key) {
        Unit unit;
        SharedPreferences.Editor remove;
        Intrinsics.checkNotNullParameter(storageName, "storageName");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences userDomainSPInternal = getUserDomainSPInternal(storageName);
        if (userDomainSPInternal == null) {
            return new Pair<>(false, false);
        }
        if (!userDomainSPInternal.contains(key)) {
            return new Pair<>(false, false);
        }
        SharedPreferences.Editor userDomainStorageEditorInternal = getUserDomainStorageEditorInternal(storageName);
        if (userDomainStorageEditorInternal == null || (remove = userDomainStorageEditorInternal.remove(key)) == null) {
            unit = null;
        } else {
            remove.apply();
            unit = Unit.INSTANCE;
        }
        return unit == null ? new Pair<>(true, false) : new Pair<>(true, true);
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.IUserDomainNativeStorage
    public Set<String> getUserDomainStorageInfo(String storageName) {
        Map<String, ?> all;
        Set<String> keySet;
        Intrinsics.checkNotNullParameter(storageName, "storageName");
        SharedPreferences userDomainSPInternal = getUserDomainSPInternal(storageName);
        return (userDomainSPInternal == null || (all = userDomainSPInternal.getAll()) == null || (keySet = all.keySet()) == null) ? SetsKt.emptySet() : keySet;
    }

    @Override // com.bytedance.sdk.xbridge.cn.storage.utils.IUserDomainNativeStorage
    public String getUserDomainStorageName(String appId, String userId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (appId.length() == 0) {
            return "";
        }
        return userId.length() == 0 ? "" : userId + "appId_" + appId;
    }

    public final Long getCreateTime(String storageName, String key) {
        Intrinsics.checkNotNullParameter(storageName, "storageName");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences userDomainSPInternal = getUserDomainSPInternal(storageName);
        String string = userDomainSPInternal != null ? userDomainSPInternal.getString(key, "") : null;
        String str = string;
        if (str == null || str.length() == 0) {
            return null;
        }
        JsonUtils jsonUtils = JsonUtils.INSTANCE;
        Intrinsics.checkNotNull(string);
        return ((UserDomainStorageValue) jsonUtils.fromJson(string, UserDomainStorageValue.class)).getCreated_name();
    }

    public final void modifyLastAccessTime(String storageName, String key, UserDomainStorageValue userDomainStorageValue, String methodName, String sessionId) {
        SharedPreferences.Editor putString;
        Intrinsics.checkNotNullParameter(storageName, "storageName");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(userDomainStorageValue, "userDomainStorageValue");
        String json = JsonUtils.INSTANCE.toJson(new UserDomainStorageValue(userDomainStorageValue.getType(), userDomainStorageValue.getValue(), userDomainStorageValue.getCreated_name(), Long.valueOf(System.currentTimeMillis()), userDomainStorageValue.getLastModifiedTime(), userDomainStorageValue.getExpiredTime()));
        XBridgeInjectLogger.m174i(methodName == null ? "unknown" : methodName, "modify: key:" + key + ",content:" + json, "BridgeProcessing", sessionId);
        SharedPreferences.Editor userDomainStorageEditorInternal = getUserDomainStorageEditorInternal(storageName);
        if (userDomainStorageEditorInternal == null || (putString = userDomainStorageEditorInternal.putString(key, json)) == null) {
            return;
        }
        putString.apply();
    }
}
