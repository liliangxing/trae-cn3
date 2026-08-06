package com.bytedance.sdk.xbridge.cn.websocket.idl_bridge;

import android.app.Activity;
import android.util.Base64;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.websocket.idl.AbsXSendSocketDataMethodIDL;
import com.bytedance.sdk.xbridge.cn.websocket.utils.NetRequestServiceImpl;
import com.bytedance.sdk.xbridge.cn.websocket.utils.SocketRequest;
import com.bytedance.timonbase.scene.PageDataManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XSendSocketDataMethod.kt */
@XBridgeMethod(name = "x.sendSocketData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/idl_bridge/XSendSocketDataMethod;", "Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXSendSocketDataMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXSendSocketDataMethodIDL$XSendSocketDataParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXSendSocketDataMethodIDL$XSendSocketDataResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XSendSocketDataMethod extends AbsXSendSocketDataMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(final IBDXBridgeContext bridgeContext, final AbsXSendSocketDataMethodIDL.XSendSocketDataParamModel params, CompletionBlock<AbsXSendSocketDataMethodIDL.XSendSocketDataResultModel> callback) {
        String str;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        String containerID = bridgeContext.getContainerID();
        String str2 = containerID;
        if (str2 == null || str2.length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "ContainerID not provided in host", null, 4, null);
            return;
        }
        String dataType = params.getDataType();
        if (Intrinsics.areEqual(dataType, "string")) {
            Object data = params.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.String");
            str = (String) data;
            bArr = null;
        } else if (Intrinsics.areEqual(dataType, "base64")) {
            Object data2 = params.getData();
            Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type kotlin.String");
            bArr = Base64.decode((String) data2, 0);
            str = null;
        } else {
            str = null;
            bArr = null;
        }
        NetRequestServiceImpl.INSTANCE.sendSocketData(ownerActivity, containerID, params.getSocketTaskID(), str, bArr, new SocketRequest.OperateTask.Callback() { // from class: com.bytedance.sdk.xbridge.cn.websocket.idl_bridge.XSendSocketDataMethod$handle$1
            @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.SocketRequest.OperateTask.Callback
            public void onOperateSuccess() {
            }

            @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.SocketRequest.OperateTask.Callback
            public void onOperateFail(String reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                HashMap hashMap = new HashMap();
                AbsXSendSocketDataMethodIDL.XSendSocketDataParamModel xSendSocketDataParamModel = params;
                hashMap.put(PageDataManager.EXTRA_STATUS, "failed");
                hashMap.put("message", reason);
                String socketTaskID = xSendSocketDataParamModel.getSocketTaskID();
                if (socketTaskID != null) {
                    hashMap.put("socketTaskID", socketTaskID);
                }
                IBDXBridgeContext.this.sendEvent("x.socketStatusChanged", hashMap);
            }
        });
    }
}
