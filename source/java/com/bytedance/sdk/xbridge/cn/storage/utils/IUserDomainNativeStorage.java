package com.bytedance.sdk.xbridge.cn.storage.utils;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;

/* compiled from: IUserDomainNativeStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H&J@\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H&J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H&J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&JG\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/IUserDomainNativeStorage;", "", "getUserDomainStorageInfo", "", "", "storageName", "getUserDomainStorageItem", "Lkotlin/Triple;", "", "key", "methodName", "sessionId", "getUserDomainStorageName", "appId", "userId", "removeUserDomainStorageItem", "Lkotlin/Pair;", "setUserDomainStorageItem", "data", "expiredTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Z", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IUserDomainNativeStorage {
    Set<String> getUserDomainStorageInfo(String storageName);

    Triple<Boolean, Boolean, Object> getUserDomainStorageItem(String storageName, String key, String methodName, String sessionId);

    String getUserDomainStorageName(String appId, String userId);

    Pair<Boolean, Boolean> removeUserDomainStorageItem(String storageName, String key);

    boolean setUserDomainStorageItem(String storageName, String key, Object data, Long expiredTime, String methodName, String sessionId);
}
