package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeProviderFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/NativeProviderFactory;", "", "()V", "providerBizNativeStorage", "Lcom/bytedance/sdk/xbridge/cn/storage/utils/IBizNativeStorage;", "context", "Landroid/content/Context;", "providerNativeStorage", "Lcom/bytedance/sdk/xbridge/cn/storage/utils/INativeStorage;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NativeProviderFactory {
    public static final NativeProviderFactory INSTANCE = new NativeProviderFactory();

    private NativeProviderFactory() {
    }

    @JvmStatic
    public static final INativeStorage providerNativeStorage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return NativeStorageImpl.INSTANCE.getInstance(context.getApplicationContext());
    }

    @JvmStatic
    public static final IBizNativeStorage providerBizNativeStorage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return NativeStorageImpl.INSTANCE.getInstance(context.getApplicationContext());
    }
}
