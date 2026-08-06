package com.bytedance.android.anniex.ability.service;

import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXPiaMethodProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/IAnnieXPiaMethodProvider;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "providerMethod", "", "", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "bid", "providerPreHandleMethod", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnnieXPiaMethodProvider extends IBulletService {

    /* compiled from: IAnnieXPiaMethodProvider.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static Map<String, IDLXBridgeMethod> providerMethod(IAnnieXPiaMethodProvider iAnnieXPiaMethodProvider, String bid) {
            Intrinsics.checkNotNullParameter(bid, "bid");
            return null;
        }

        public static Map<String, IDLXBridgeMethod> providerPreHandleMethod(IAnnieXPiaMethodProvider iAnnieXPiaMethodProvider, String bid) {
            Intrinsics.checkNotNullParameter(bid, "bid");
            return null;
        }
    }

    Map<String, IDLXBridgeMethod> providerMethod(String bid);

    Map<String, IDLXBridgeMethod> providerPreHandleMethod(String bid);
}
