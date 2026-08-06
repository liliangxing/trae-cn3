package com.bytedance.sdk.xbridge.cn.storage.bridge;

import android.app.Application;
import android.content.Context;
import android.view.View;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostExternalStorageDepend;
import com.bytedance.sdk.xbridge.cn.storage.bridge.AbsXSetStorageItemMethodIDL;
import com.bytedance.sdk.xbridge.cn.storage.utils.NativeProviderFactory;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XSetStorageItemMethod.kt */
@XBridgeMethod(name = "x.setStorageItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016JG\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/bridge/XSetStorageItemMethod;", "Lcom/bytedance/sdk/xbridge/cn/storage/bridge/AbsXSetStorageItemMethodIDL;", "()V", "methodName", "", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/storage/bridge/AbsXSetStorageItemMethodIDL$XSetStorageItemParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/storage/bridge/AbsXSetStorageItemMethodIDL$XSetStorageItemResultModel;", "setStorageItemWrapper", "context", "Landroid/content/Context;", "biz", "key", "data", "", "expectedTime", "", "sessionId", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/String;)Z", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XSetStorageItemMethod extends AbsXSetStorageItemMethodIDL {
    private final String methodName = "x.setStorageItem";

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXSetStorageItemMethodIDL.XSetStorageItemParamModel params, CompletionBlock<AbsXSetStorageItemMethodIDL.XSetStorageItemResultModel> callback) {
        Application application;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        View engineView = bridgeContext.getEngineView();
        if (engineView == null || (application = engineView.getContext()) == null) {
            application = BulletEnv.Companion.getInstance().getApplication();
        }
        Context context = application;
        String key = params.getKey();
        Object data = params.getData();
        String biz = params.getBiz();
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage("session_id", bridgeContext.getContainerID());
        loggerContext.pushStage(XBridgeInjectLogger.CALL_ID, bridgeContext.getCallId());
        HybridLogger.INSTANCE.i("BridgeParam", this.methodName + " param", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", key), TuplesKt.to("data", data), TuplesKt.to("biz", biz), TuplesKt.to("context", String.valueOf(context))}), loggerContext);
        if (context == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        if (key.length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "The key should not be empty.", null, 4, null);
            return;
        }
        boolean storageItemWrapper = setStorageItemWrapper(context, biz, key, data, null, bridgeContext.getContainerID());
        HybridLogger.INSTANCE.i("BridgeResult", this.methodName + " save storageValue", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", key), TuplesKt.to("data", data), TuplesKt.to("biz", biz), TuplesKt.to("success", Boolean.valueOf(storageItemWrapper))}), loggerContext);
        String str = biz;
        if ((str == null || str.length() == 0) && (data instanceof String)) {
            IHostExternalStorageDepend externalStorageDependInstance = RuntimeHelper.INSTANCE.getExternalStorageDependInstance();
            boolean storageValue = externalStorageDependInstance != null ? externalStorageDependInstance.setStorageValue(key, data) : false;
            HybridLogger.INSTANCE.i("BridgeResult", this.methodName + " save hostDepend storageValue", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", key), TuplesKt.to("data", data), TuplesKt.to("biz", biz), TuplesKt.to("localSuccess", Boolean.valueOf(storageValue))}), loggerContext);
            storageItemWrapper = storageValue || storageItemWrapper;
        }
        if (storageItemWrapper) {
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(AbsXSetStorageItemMethodIDL.XSetStorageItemResultModel.class), null, 2, null);
        } else {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "Illegal value type", null, 4, null);
        }
    }

    private final boolean setStorageItemWrapper(Context context, String biz, String key, Object data, Long expectedTime, String sessionId) {
        return INativeStorageExtensionsKt.trySetBizStorageItem(NativeProviderFactory.providerNativeStorage(context), biz, key, data, expectedTime, this.methodName, sessionId);
    }
}
