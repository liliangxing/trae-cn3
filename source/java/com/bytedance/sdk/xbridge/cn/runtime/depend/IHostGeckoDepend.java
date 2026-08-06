package com.bytedance.sdk.xbridge.cn.runtime.depend;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostGeckoDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J/\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostGeckoDepend;", "", "getGeckoInfo", "", "accessKey", "", "channel", "getGeckoInfoCallback", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IGetGeckoInfoCallback;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IGetGeckoInfoCallback;)Lkotlin/Unit;", "registerGeckoUpdateListener", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IGeckoUpdateListener;", "unRegisterGeckoUpdateListener", "updateGecko", "updateGeckoCallback", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IUpdateGeckoCallback;", "enableDownloadAutoRetry", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IUpdateGeckoCallback;Z)Lkotlin/Unit;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IHostGeckoDepend {

    /* compiled from: IHostGeckoDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static Unit getGeckoInfo(IHostGeckoDepend iHostGeckoDepend, String accessKey, String channel, IGetGeckoInfoCallback getGeckoInfoCallback) {
            Intrinsics.checkNotNullParameter(accessKey, "accessKey");
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(getGeckoInfoCallback, "getGeckoInfoCallback");
            return null;
        }

        public static void registerGeckoUpdateListener(IHostGeckoDepend iHostGeckoDepend, IBDXBridgeContext iBDXBridgeContext, IGeckoUpdateListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        public static void unRegisterGeckoUpdateListener(IHostGeckoDepend iHostGeckoDepend, IBDXBridgeContext bridgeContext) {
            Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        }

        public static Unit updateGecko(IHostGeckoDepend iHostGeckoDepend, String accessKey, String channel, IUpdateGeckoCallback updateGeckoCallback, boolean z) {
            Intrinsics.checkNotNullParameter(accessKey, "accessKey");
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(updateGeckoCallback, "updateGeckoCallback");
            return null;
        }
    }

    Unit getGeckoInfo(String accessKey, String channel, IGetGeckoInfoCallback getGeckoInfoCallback);

    void registerGeckoUpdateListener(IBDXBridgeContext bridgeContext, IGeckoUpdateListener listener);

    void unRegisterGeckoUpdateListener(IBDXBridgeContext bridgeContext);

    Unit updateGecko(String accessKey, String channel, IUpdateGeckoCallback updateGeckoCallback, boolean enableDownloadAutoRetry);
}
