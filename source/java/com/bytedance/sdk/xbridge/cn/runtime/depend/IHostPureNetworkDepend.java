package com.bytedance.sdk.xbridge.cn.runtime.depend;

import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IHostPureNetworkDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostPureNetworkDepend;", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDepend;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IHostPureNetworkDepend extends IHostNetworkDepend {

    /* compiled from: IHostPureNetworkDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static Map<String, Object> getAPIParams(IHostPureNetworkDepend iHostPureNetworkDepend) {
            return IHostNetworkDepend.DefaultImpls.getAPIParams(iHostPureNetworkDepend);
        }
    }
}
