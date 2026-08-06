package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserDomainNativeProviderFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/UserDomainNativeProviderFactory;", "", "()V", "providerUserDomainNativeStorage", "Lcom/bytedance/sdk/xbridge/cn/storage/utils/IUserDomainNativeStorage;", "context", "Landroid/content/Context;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserDomainNativeProviderFactory {
    public static final UserDomainNativeProviderFactory INSTANCE = new UserDomainNativeProviderFactory();

    private UserDomainNativeProviderFactory() {
    }

    @JvmStatic
    public static final IUserDomainNativeStorage providerUserDomainNativeStorage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UserDomainNativeStorageImpl.INSTANCE.getInstance(context.getApplicationContext());
    }
}
