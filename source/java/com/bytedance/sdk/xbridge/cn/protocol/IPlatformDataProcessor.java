package com.bytedance.sdk.xbridge.cn.protocol;

import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseBridgeHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003JE\u0010\u0004\u001a\u00028\u00012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00062\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH&¢\u0006\u0002\u0010\rJ5\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00028\u00002\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH&¢\u0006\u0002\u0010\u000fJ#\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00062\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011J=\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00028\u00002\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/IPlatformDataProcessor;", "INPUT", "OUTPUT", "", "transformMapToPlatformData", "params", "", "", "clazz", "Ljava/lang/Class;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "(Ljava/util/Map;Ljava/lang/Class;Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;)Ljava/lang/Object;", "transformPlatformDataToMap", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/util/Map;", "transformPlatformDataToMapCompat", "(Ljava/lang/Object;)Ljava/util/Map;", "transformPlatformDataToMapWithNamespace", "nameSpace", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IPlatformDataProcessor<INPUT, OUTPUT> {
    OUTPUT transformMapToPlatformData(Map<String, ? extends Object> params, Class<? extends IDLXBridgeMethod> clazz, BaseBridgeCall<INPUT> call);

    Map<String, Object> transformPlatformDataToMap(INPUT params, Class<? extends IDLXBridgeMethod> clazz);

    Map<String, Object> transformPlatformDataToMapCompat(INPUT params);

    Map<String, Object> transformPlatformDataToMapWithNamespace(INPUT params, Class<? extends IDLXBridgeMethod> clazz, String nameSpace);

    /* compiled from: BaseBridgeHandler.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static <INPUT, OUTPUT> Map<String, Object> transformPlatformDataToMapWithNamespace(IPlatformDataProcessor<INPUT, OUTPUT> iPlatformDataProcessor, INPUT input, Class<? extends IDLXBridgeMethod> clazz, String nameSpace) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(nameSpace, "nameSpace");
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object transformMapToPlatformData$default(IPlatformDataProcessor iPlatformDataProcessor, Map map, Class cls, BaseBridgeCall baseBridgeCall, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transformMapToPlatformData");
            }
            if ((i & 4) != 0) {
                baseBridgeCall = null;
            }
            return iPlatformDataProcessor.transformMapToPlatformData(map, cls, baseBridgeCall);
        }
    }
}
