package com.bytedance.sdk.xbridge.cn.storage.bridge;

import com.bytedance.sdk.xbridge.cn.storage.utils.IBizNativeStorage;
import com.bytedance.sdk.xbridge.cn.storage.utils.INativeStorage;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INativeStorageExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0000\u001a6\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0000\u001a \u0010\n\u001a\u00020\u000b*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0000\u001aM\u0010\f\u001a\u00020\u000b*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"tryGetBizStorageInfo", "", "", "Lcom/bytedance/sdk/xbridge/cn/storage/utils/INativeStorage;", "biz", "tryGetBizStorageItem", "", "key", "methodName", "sessionId", "tryRemoveBizStorageItem", "", "trySetBizStorageItem", "data", "expiredTime", "", "(Lcom/bytedance/sdk/xbridge/cn/storage/utils/INativeStorage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Z", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class INativeStorageExtensionsKt {
    public static final boolean trySetBizStorageItem(INativeStorage iNativeStorage, String str, String str2, Object obj, Long l, String str3, String str4) {
        Intrinsics.checkNotNullParameter(iNativeStorage, "<this>");
        String str5 = str;
        if (!(str5 == null || str5.length() == 0) && (iNativeStorage instanceof IBizNativeStorage)) {
            Intrinsics.checkNotNull(str);
            return ((IBizNativeStorage) iNativeStorage).setBizStorageItem(str, str2, obj, l, str3, str4);
        }
        return iNativeStorage.setStorageItem(str2, obj, l, str3, str4);
    }

    public static final Object tryGetBizStorageItem(INativeStorage iNativeStorage, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(iNativeStorage, "<this>");
        String str5 = str;
        if (!(str5 == null || str5.length() == 0) && (iNativeStorage instanceof IBizNativeStorage)) {
            Intrinsics.checkNotNull(str);
            return ((IBizNativeStorage) iNativeStorage).getBizStorageItem(str, str2, str3, str4);
        }
        return iNativeStorage.getStorageItem(str2, str3, str4);
    }

    public static final boolean tryRemoveBizStorageItem(INativeStorage iNativeStorage, String str, String str2) {
        Intrinsics.checkNotNullParameter(iNativeStorage, "<this>");
        String str3 = str;
        if (!(str3 == null || str3.length() == 0) && (iNativeStorage instanceof IBizNativeStorage)) {
            Intrinsics.checkNotNull(str);
            return ((IBizNativeStorage) iNativeStorage).removeBizStorageItem(str, str2);
        }
        return iNativeStorage.removeStorageItem(str2);
    }

    public static final Set<String> tryGetBizStorageInfo(INativeStorage iNativeStorage, String str) {
        Intrinsics.checkNotNullParameter(iNativeStorage, "<this>");
        String str2 = str;
        if (!(str2 == null || str2.length() == 0) && (iNativeStorage instanceof IBizNativeStorage)) {
            Intrinsics.checkNotNull(str);
            return ((IBizNativeStorage) iNativeStorage).getBizStorageInfo(str);
        }
        return iNativeStorage.getStorageInfo();
    }
}
