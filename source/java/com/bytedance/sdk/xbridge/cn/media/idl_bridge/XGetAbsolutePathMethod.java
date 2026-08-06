package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.media.idl.AbsXGetAbsolutePathMethodIDL;
import com.bytedance.sdk.xbridge.cn.media.utils.AppFileUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XGetAbsolutePathMethod.kt */
@XBridgeMethod(name = "x.getAbsolutePath")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XGetAbsolutePathMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXGetAbsolutePathMethodIDL;", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXGetAbsolutePathMethodIDL$XGetAbsolutePathParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXGetAbsolutePathMethodIDL$XGetAbsolutePathResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XGetAbsolutePathMethod extends AbsXGetAbsolutePathMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXGetAbsolutePathMethodIDL.XGetAbsolutePathParamModel params, CompletionBlock<AbsXGetAbsolutePathMethodIDL.XGetAbsolutePathResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (bridgeContext.getOwnerActivity() == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "invalid bridgeContext， owner activity is null", null, 4, null);
            return;
        }
        String relativePath = params.getRelativePath();
        AppFileUtils appFileUtils = AppFileUtils.INSTANCE;
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        String absoluteFilePath = appFileUtils.getAbsoluteFilePath(ownerActivity, relativePath);
        String str = absoluteFilePath;
        boolean z = false;
        if (!(str == null || str.length() == 0)) {
            AppFileUtils appFileUtils2 = AppFileUtils.INSTANCE;
            Activity ownerActivity2 = bridgeContext.getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity2);
            z = appFileUtils2.isFileExists(ownerActivity2, absoluteFilePath);
        }
        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetAbsolutePathMethodIDL.XGetAbsolutePathResultModel.class));
        AbsXGetAbsolutePathMethodIDL.XGetAbsolutePathResultModel xGetAbsolutePathResultModel = (AbsXGetAbsolutePathMethodIDL.XGetAbsolutePathResultModel) createXModel;
        xGetAbsolutePathResultModel.setFileExist(Boolean.valueOf(z));
        xGetAbsolutePathResultModel.setAbsolutePath(absoluteFilePath);
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
    }
}
