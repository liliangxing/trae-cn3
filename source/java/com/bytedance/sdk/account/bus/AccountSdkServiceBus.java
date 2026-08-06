package com.bytedance.sdk.account.bus;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountSdkServiceBus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0006R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/account/bus/AccountSdkServiceBus;", "", "()V", "infoService", "Ljava/util/HashMap;", "", "Lcom/bytedance/sdk/account/bus/IAccountSdkService;", "Lkotlin/collections/HashMap;", "getService", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Ljava/lang/String;)Ljava/lang/Object;", "registerService", "", "service", "account-sdk-bus_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class AccountSdkServiceBus {
    public static final AccountSdkServiceBus INSTANCE = new AccountSdkServiceBus();
    private static final HashMap<String, IAccountSdkService> infoService = new HashMap<>();

    private AccountSdkServiceBus() {
    }

    public final void registerService(String key, IAccountSdkService service) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(service, "service");
        if (key.length() == 0) {
            return;
        }
        infoService.put(key, service);
    }

    public final <T> T getService(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return (T) infoService.get(key);
    }
}
