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
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostExternalStorageDepend;
import com.bytedance.sdk.xbridge.cn.storage.bridge.AbsXGetStorageItemMethodIDL;
import com.bytedance.sdk.xbridge.cn.storage.utils.NativeProviderFactory;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XGetStorageItemMethod.kt */
@XBridgeMethod(name = "x.getStorageItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J,\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/bridge/XGetStorageItemMethod;", "Lcom/bytedance/sdk/xbridge/cn/storage/bridge/AbsXGetStorageItemMethodIDL;", "()V", "methodName", "", "getMethodName", "()Ljava/lang/String;", "ugLogContext", "Lcom/bytedance/ies/bullet/base/utils/logger/LoggerContext;", "getUgLogContext", "()Lcom/bytedance/ies/bullet/base/utils/logger/LoggerContext;", "setUgLogContext", "(Lcom/bytedance/ies/bullet/base/utils/logger/LoggerContext;)V", "canRunInBackground", "", "getBizStorage", "", "context", "Landroid/content/Context;", "key", "biz", "sessionId", "getStorage", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/storage/bridge/AbsXGetStorageItemMethodIDL$XGetStorageItemParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/storage/bridge/AbsXGetStorageItemMethodIDL$XGetStorageItemResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XGetStorageItemMethod extends AbsXGetStorageItemMethodIDL {
    private final String methodName = "x.getStorageItem";
    private LoggerContext ugLogContext;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final LoggerContext getUgLogContext() {
        return this.ugLogContext;
    }

    public final void setUgLogContext(LoggerContext loggerContext) {
        this.ugLogContext = loggerContext;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXGetStorageItemMethodIDL.XGetStorageItemParamModel params, CompletionBlock<AbsXGetStorageItemMethodIDL.XGetStorageItemResultModel> callback) {
        Application application;
        Object storage;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String key = params.getKey();
        String biz = params.getBiz();
        View engineView = bridgeContext.getEngineView();
        if (engineView == null || (application = engineView.getContext()) == null) {
            application = BulletEnv.Companion.getInstance().getApplication();
        }
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage("session_id", bridgeContext.getContainerID());
        loggerContext.pushStage(XBridgeInjectLogger.CALL_ID, bridgeContext.getCallId());
        this.ugLogContext = loggerContext;
        HybridLogger.INSTANCE.i("BridgeParam", "x.getStorageItem param", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", key), TuplesKt.to("biz", biz), TuplesKt.to("context", application)}), this.ugLogContext);
        if (application == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        if (key.length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "", null, 4, null);
            return;
        }
        String str = biz;
        if (!(str == null || str.length() == 0)) {
            Intrinsics.checkNotNull(biz);
            storage = getBizStorage(application, key, biz, bridgeContext.getContainerID());
        } else {
            storage = getStorage(application, key, bridgeContext.getContainerID());
        }
        HybridLogger.INSTANCE.i("BridgeResult", "x.getStorageItem storageValue", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", key), TuplesKt.to("storageValue", storage)}), this.ugLogContext);
        if (storage == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Key not found in certain storage", null, 4, null);
            return;
        }
        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetStorageItemMethodIDL.XGetStorageItemResultModel.class));
        ((AbsXGetStorageItemMethodIDL.XGetStorageItemResultModel) createXModel).setData(XBridgeKTXKt.assignX(storage));
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
    }

    private final Object getStorage(Context context, String key, String sessionId) {
        Object storageItem = NativeProviderFactory.providerNativeStorage(context).getStorageItem(key, this.methodName, sessionId);
        HybridLogger.INSTANCE.i("BridgeProcessing", "x.getStorageItem StorageValue", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", key), TuplesKt.to("result", storageItem)}), this.ugLogContext);
        if (storageItem == null) {
            IHostExternalStorageDepend externalStorageDependInstance = RuntimeHelper.INSTANCE.getExternalStorageDependInstance();
            storageItem = externalStorageDependInstance != null ? externalStorageDependInstance.readStorageValue(key) : null;
            HybridLogger.INSTANCE.i("BridgeProcessing", "x.getStorageItem hostDepend StorageValue", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", key), TuplesKt.to("result", storageItem)}), this.ugLogContext);
        }
        return storageItem;
    }

    private final Object getBizStorage(Context context, String key, String biz, String sessionId) {
        Object tryGetBizStorageItem = INativeStorageExtensionsKt.tryGetBizStorageItem(NativeProviderFactory.providerNativeStorage(context), biz, key, this.methodName, sessionId);
        HybridLogger.INSTANCE.i("BridgeProcessing", "x.getStorageItem biz StorageValue", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", key), TuplesKt.to("biz", biz), TuplesKt.to("result", tryGetBizStorageItem)}), this.ugLogContext);
        return tryGetBizStorageItem;
    }
}
