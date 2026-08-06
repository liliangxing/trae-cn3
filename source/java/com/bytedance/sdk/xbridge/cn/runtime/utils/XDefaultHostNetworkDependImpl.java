package com.bytedance.sdk.xbridge.cn.runtime.utils;

import com.bytedance.retrofit2.Retrofit;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit;
import com.bytedance.sdk.xbridge.cn.runtime.network.RetrofitFactory;
import com.bytedance.tracing.internal.TracingConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XDefaultHostNetworkDependImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/utils/XDefaultHostNetworkDependImpl;", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDepend;", "()V", "createRetrofit", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/XIRetrofit;", "baseUrl", "", "isUseOkHttp", "", "XDefaultRetrofitImpl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XDefaultHostNetworkDependImpl implements IHostNetworkDepend {
    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend
    public Map<String, Object> getAPIParams() {
        return IHostNetworkDepend.DefaultImpls.getAPIParams(this);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend
    public XIRetrofit createRetrofit(String baseUrl, boolean isUseOkHttp) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        return new XDefaultRetrofitImpl(this, RetrofitFactory.INSTANCE.createRetrofit(baseUrl, isUseOkHttp));
    }

    /* compiled from: XDefaultHostNetworkDependImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0016¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/utils/XDefaultHostNetworkDependImpl$XDefaultRetrofitImpl;", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/XIRetrofit;", "retrofit", "Lcom/bytedance/retrofit2/Retrofit;", "(Lcom/bytedance/sdk/xbridge/cn/runtime/utils/XDefaultHostNetworkDependImpl;Lcom/bytedance/retrofit2/Retrofit;)V", "create", "T", TracingConstants.KEY_TRACE_NAME, "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private final class XDefaultRetrofitImpl implements XIRetrofit {
        private final Retrofit retrofit;
        final /* synthetic */ XDefaultHostNetworkDependImpl this$0;

        public XDefaultRetrofitImpl(XDefaultHostNetworkDependImpl xDefaultHostNetworkDependImpl, Retrofit retrofit) {
            Intrinsics.checkNotNullParameter(retrofit, "retrofit");
            this.this$0 = xDefaultHostNetworkDependImpl;
            this.retrofit = retrofit;
        }

        @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit
        public <T> T create(Class<T> service) {
            Intrinsics.checkNotNullParameter(service, TracingConstants.KEY_TRACE_NAME);
            return (T) this.retrofit.create(service);
        }
    }
}
