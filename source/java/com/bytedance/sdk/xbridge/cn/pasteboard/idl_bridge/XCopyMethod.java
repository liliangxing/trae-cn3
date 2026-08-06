package com.bytedance.sdk.xbridge.cn.pasteboard.idl_bridge;

import android.app.Activity;
import android.content.ClipData;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.pasteboard.idl.AbsXCopyMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCacheDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostSystemActionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XCopyMethod.kt */
@XBridgeMethod(name = XCopyMethod.METHOD_NAME)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/pasteboard/idl_bridge/XCopyMethod;", "Lcom/bytedance/sdk/xbridge/cn/pasteboard/idl/AbsXCopyMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/pasteboard/idl/AbsXCopyMethodIDL$XCopyParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/pasteboard/idl/AbsXCopyMethodIDL$XCopyResultModel;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XCopyMethod extends AbsXCopyMethodIDL {
    public static final String METHOD_NAME = "x.copy";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXCopyMethodIDL.XCopyParamModel params, CompletionBlock<AbsXCopyMethodIDL.XCopyResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean z = false;
        if (params.getContent().length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "The content parameter should not be empty.", null, 4, null);
            return;
        }
        String content = params.getContent();
        try {
            Activity ownerActivity = bridgeContext.getOwnerActivity();
            if (ownerActivity == null) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "context is null", null, 4, null);
                return;
            }
            IHostSystemActionDepend hostSystemActionDepend = XBaseRuntime.INSTANCE.getHostSystemActionDepend();
            if (hostSystemActionDepend != null) {
                String name = getName();
                ClipData newPlainText = ClipData.newPlainText(content, content);
                Intrinsics.checkNotNullExpressionValue(newPlainText, "newPlainText(content, content)");
                hostSystemActionDepend.setPrimaryClip(ownerActivity, bridgeContext, name, newPlainText);
            }
            if (hostSystemActionDepend != null && hostSystemActionDepend.hasPrimaryClip(ownerActivity, bridgeContext, getName())) {
                z = true;
            }
            if (!z) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "no permission to copy", null, 4, null);
                return;
            }
            callback.onSuccess((XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(AbsXCopyMethodIDL.XCopyResultModel.class), "success");
            Boolean isCached = params.isCached();
            if (Intrinsics.areEqual(isCached, true)) {
                IHostCacheDepend cacheDependInstance = RuntimeHelper.INSTANCE.getCacheDependInstance();
                if (cacheDependInstance == null) {
                    XBridge.log(METHOD_NAME, "cacheDepend is null", "BridgeProcessing", bridgeContext.getContainerID());
                } else {
                    cacheDependInstance.onSaveText(ownerActivity, isCached.booleanValue(), content);
                    XBridge.log(METHOD_NAME, "trigger cacheDepend.onSaveText with isCached=" + isCached + ", content=" + content, "BridgeProcessing", bridgeContext.getContainerID());
                }
            }
        } catch (Exception e) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, String.valueOf(e.getMessage()), null, 4, null);
        }
    }
}
