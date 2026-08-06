package com.bytedance.sdk.xbridge.cn.storage.utils;

import java.util.Set;
import kotlin.Metadata;

/* compiled from: INativeStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J(\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&J?\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/INativeStorage;", "", "getStorageInfo", "", "", "getStorageItem", "key", "methodName", "sessionId", "removeStorageItem", "", "setStorageItem", "data", "expiredTime", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Z", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface INativeStorage {
    Set<String> getStorageInfo();

    Object getStorageItem(String key, String methodName, String sessionId);

    boolean removeStorageItem(String key);

    boolean setStorageItem(String key, Object data, Long expiredTime, String methodName, String sessionId);
}
