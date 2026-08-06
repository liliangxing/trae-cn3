package com.bytedance.sdk.xbridge.cn.runtime.depend;

import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostNetworkDependV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ4\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0017¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDependV2;", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDepend;", "createRetrofit", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/XIRetrofit;", "baseUrl", "", "isUseOkHttp", "", "networkConfig", "", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IHostNetworkDependV2 extends IHostNetworkDepend {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String IS_CUSTOMIZED_COOKIE = "isCustomizedCookie";
    public static final String IS_NEED_COMMON_PARAM = "needAddCommonParams";

    XIRetrofit createRetrofit(String baseUrl, boolean isUseOkHttp, Map<String, ? extends Object> networkConfig);

    /* compiled from: IHostNetworkDependV2.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static Map<String, Object> getAPIParams(IHostNetworkDependV2 iHostNetworkDependV2) {
            return IHostNetworkDepend.DefaultImpls.getAPIParams(iHostNetworkDependV2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ XIRetrofit createRetrofit$default(IHostNetworkDependV2 iHostNetworkDependV2, String str, boolean z, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createRetrofit");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return iHostNetworkDependV2.createRetrofit(str, z, map);
        }

        public static XIRetrofit createRetrofit(IHostNetworkDependV2 iHostNetworkDependV2, String baseUrl, boolean z, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
            return iHostNetworkDependV2.createRetrofit(baseUrl, z);
        }
    }

    /* compiled from: IHostNetworkDependV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDependV2$Companion;", "", "()V", "IS_CUSTOMIZED_COOKIE", "", "IS_NEED_COMMON_PARAM", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String IS_CUSTOMIZED_COOKIE = "isCustomizedCookie";
        public static final String IS_NEED_COMMON_PARAM = "needAddCommonParams";

        private Companion() {
        }
    }
}
