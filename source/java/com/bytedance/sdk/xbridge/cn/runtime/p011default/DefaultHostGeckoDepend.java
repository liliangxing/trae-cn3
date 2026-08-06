package com.bytedance.sdk.xbridge.cn.runtime.p011default;

import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoClientManager;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.policy.lazy.LazyUpdateManager;
import com.bytedance.ies.xbridge.utils.XLog;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.GeckoInfoBean;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IGeckoUpdateListener;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IGetGeckoInfoCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostGeckoDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IUpdateGeckoCallback;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultHostGeckoDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J/\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/default/DefaultHostGeckoDepend;", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostGeckoDepend;", "()V", "getGeckoInfo", "", "accessKey", "", Constant.KEY_CHANNEL, "getGeckoInfoCallback", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IGetGeckoInfoCallback;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IGetGeckoInfoCallback;)Lkotlin/Unit;", "registerGeckoUpdateListener", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "listener", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IGeckoUpdateListener;", "unRegisterGeckoUpdateListener", "updateGecko", "updateGeckoCallback", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IUpdateGeckoCallback;", "enableDownloadAutoRetry", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IUpdateGeckoCallback;Z)Lkotlin/Unit;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultHostGeckoDepend implements IHostGeckoDepend {
    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostGeckoDepend
    public Unit updateGecko(String accessKey, String channel, IUpdateGeckoCallback updateGeckoCallback, boolean enableDownloadAutoRetry) {
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        Intrinsics.checkNotNullParameter(channel, Constant.KEY_CHANNEL);
        Intrinsics.checkNotNullParameter(updateGeckoCallback, "updateGeckoCallback");
        GeckoClient geckoClientFromRegister = GeckoClientManager.INSTANCE.getGeckoClientFromRegister(accessKey);
        if (geckoClientFromRegister == null) {
            return null;
        }
        OptionCheckUpdateParams channelUpdatePriority = new OptionCheckUpdateParams().setLazyUpdate(true).setListener(new DefaultGeckoUpdateListener(updateGeckoCallback, channel, accessKey)).setEnableDownloadAutoRetry(enableDownloadAutoRetry).setChannelUpdatePriority(3);
        Map mapOf = MapsKt.mapOf(TuplesKt.to(accessKey, CollectionsKt.listOf(new CheckRequestBodyModel.TargetChannel(channel))));
        XLog.INSTANCE.info("updateGecko channelMap:" + mapOf);
        geckoClientFromRegister.checkUpdateMulti((String) null, mapOf, channelUpdatePriority);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostGeckoDepend
    public Unit getGeckoInfo(String accessKey, String channel, IGetGeckoInfoCallback getGeckoInfoCallback) {
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        Intrinsics.checkNotNullParameter(channel, Constant.KEY_CHANNEL);
        Intrinsics.checkNotNullParameter(getGeckoInfoCallback, "getGeckoInfoCallback");
        Triple lazyUpdateStoreGeckoInfo = LazyUpdateManager.getLazyUpdateStoreGeckoInfo(accessKey, channel);
        Boolean bool = (Boolean) lazyUpdateStoreGeckoInfo.getFirst();
        if (!bool.booleanValue()) {
            Intrinsics.checkNotNullExpressionValue(bool, "needUpdate");
            getGeckoInfoCallback.onResult(new GeckoInfoBean(bool.booleanValue()));
        } else {
            Long l = (Long) lazyUpdateStoreGeckoInfo.getSecond();
            String valueOf = String.valueOf(lazyUpdateStoreGeckoInfo.getThird());
            Intrinsics.checkNotNullExpressionValue(bool, "needUpdate");
            GeckoInfoBean geckoInfoBean = new GeckoInfoBean(bool.booleanValue());
            geckoInfoBean.setTotalSize(l);
            geckoInfoBean.setVersion(valueOf);
            getGeckoInfoCallback.onResult(geckoInfoBean);
        }
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostGeckoDepend
    public void registerGeckoUpdateListener(IBDXBridgeContext bridgeContext, IGeckoUpdateListener listener) {
        String containerID;
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (bridgeContext == null || (containerID = bridgeContext.getContainerID()) == null) {
            return;
        }
        GeckoUpdateCenterV2.INSTANCE.register(containerID, listener);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostGeckoDepend
    public void unRegisterGeckoUpdateListener(IBDXBridgeContext bridgeContext) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        String containerID = bridgeContext.getContainerID();
        if (containerID != null) {
            GeckoUpdateCenterV2.INSTANCE.unRegister(containerID);
        }
    }
}
