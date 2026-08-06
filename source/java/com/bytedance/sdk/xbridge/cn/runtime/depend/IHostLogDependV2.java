package com.bytedance.sdk.xbridge.cn.runtime.depend;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostLogDependV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostLogDependV2;", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostLogDepend;", "onEventV3Map", "", "eventName", "", "map", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IHostLogDependV2 extends IHostLogDepend {
    void onEventV3Map(String eventName, Map<String, String> map, IBDXBridgeContext bridgeContext);

    /* compiled from: IHostLogDependV2.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static Unit reportJSBError(IHostLogDependV2 iHostLogDependV2, IBDXBridgeContext iBDXBridgeContext, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "params");
            return IHostLogDepend.DefaultImpls.reportJSBError(iHostLogDependV2, iBDXBridgeContext, map);
        }

        public static Unit reportJSBFetchError(IHostLogDependV2 iHostLogDependV2, IBDXBridgeContext iBDXBridgeContext, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "params");
            return IHostLogDepend.DefaultImpls.reportJSBFetchError(iHostLogDependV2, iBDXBridgeContext, map);
        }
    }
}
