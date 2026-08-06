package com.bytedance.sdk.xbridge.cn.protocol;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.MethodRepository;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StatefulMethodRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethodRepository;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/MethodRepository;", "()V", "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class StatefulMethodRepository extends MethodRepository {
    public StatefulMethodRepository() {
        super(50);
    }

    public final void release() {
        Map<String, Map<String, IDLXBridgeMethod>> allMethods = getAllMethods();
        if (!allMethods.isEmpty()) {
            Iterator<Map.Entry<String, Map<String, IDLXBridgeMethod>>> it = allMethods.entrySet().iterator();
            while (it.hasNext()) {
                for (Map.Entry<String, IDLXBridgeMethod> entry : it.next().getValue().entrySet()) {
                    if (entry.getValue() instanceof StatefulMethod) {
                        IDLXBridgeMethod value = entry.getValue();
                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod");
                        ((StatefulMethod) value).release();
                    }
                }
            }
        }
        clear();
    }
}
