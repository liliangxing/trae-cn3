package com.bytedance.ies.bullet.service.prefetch;

import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefetchBridge.kt */
@XBridgeMethod(biz = "bullet", name = "bullet.prefetch")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/service/prefetch/BulletPrefetchBridge;", "Lcom/bytedance/ies/bullet/service/prefetch/PrefetchBridge;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletPrefetchBridge extends PrefetchBridge {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BulletPrefetchBridge(ContextProviderFactory contextProviderFactory) {
        super(contextProviderFactory);
        Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
    }
}
