package com.bytedance.sdk.xbridge.cn.runtime.depend;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* compiled from: IHostNetworkDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDepend;", "", "createRetrofit", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/XIRetrofit;", "baseUrl", "", "isUseOkHttp", "", "getAPIParams", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IHostNetworkDepend {
    @Deprecated(message = "与网络库之前的参数传递不够通用", replaceWith = @ReplaceWith(expression = "please use the method include networkConfig", imports = {}))
    XIRetrofit createRetrofit(String baseUrl, boolean isUseOkHttp);

    Map<String, Object> getAPIParams();

    /* compiled from: IHostNetworkDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static Map<String, Object> getAPIParams(IHostNetworkDepend iHostNetworkDepend) {
            return null;
        }

        public static /* synthetic */ XIRetrofit createRetrofit$default(IHostNetworkDepend iHostNetworkDepend, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createRetrofit");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            return iHostNetworkDepend.createRetrofit(str, z);
        }
    }
}
