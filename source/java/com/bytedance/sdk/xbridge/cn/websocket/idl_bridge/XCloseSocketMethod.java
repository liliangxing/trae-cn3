package com.bytedance.sdk.xbridge.cn.websocket.idl_bridge;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.service.JSEventDelegate;
import com.bytedance.sdk.xbridge.cn.websocket.idl.AbsXCloseSocketMethodIDL;
import com.bytedance.sdk.xbridge.cn.websocket.utils.NetRequestServiceImpl;
import com.bytedance.sdk.xbridge.cn.websocket.utils.SocketRequest;
import com.bytedance.timonbase.scene.PageDataManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XCloseSocketMethod.kt */
@XBridgeMethod(name = "x.closeSocket")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/idl_bridge/XCloseSocketMethod;", "Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXCloseSocketMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "()V", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "handle", "", "params", "Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXCloseSocketMethodIDL$XCloseSocketParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXCloseSocketMethodIDL$XCloseSocketResultModel;", "release", "sendJsEvent", "jsEventDelegate", "Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", "socketTaskID", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XCloseSocketMethod extends AbsXCloseSocketMethodIDL implements StatefulMethod {
    private IBDXBridgeContext bridgeContext;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, final AbsXCloseSocketMethodIDL.XCloseSocketParamModel params, final CompletionBlock<AbsXCloseSocketMethodIDL.XCloseSocketResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final JSEventDelegate jsEventDelegate = bridgeContext.getJsEventDelegate();
        this.bridgeContext = bridgeContext;
        String containerID = params.getContainerID();
        if (containerID == null) {
            containerID = bridgeContext.getContainerID();
        }
        if (containerID.length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "ContainerID not provided in host", null, 4, null);
        } else {
            NetRequestServiceImpl.INSTANCE.closeSocket(containerID, params.getSocketTaskID(), new SocketRequest.OperateTask.Callback() { // from class: com.bytedance.sdk.xbridge.cn.websocket.idl_bridge.XCloseSocketMethod$handle$1
                @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.SocketRequest.OperateTask.Callback
                public void onOperateFail(String reason) {
                    Intrinsics.checkNotNullParameter(reason, "reason");
                    CompletionBlock.DefaultImpls.onFailure$default(callback, 0, reason, null, 4, null);
                }

                @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.SocketRequest.OperateTask.Callback
                public void onOperateSuccess() {
                    CompletionBlock<AbsXCloseSocketMethodIDL.XCloseSocketResultModel> completionBlock = callback;
                    XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXCloseSocketMethodIDL.XCloseSocketResultModel.class));
                    ((AbsXCloseSocketMethodIDL.XCloseSocketResultModel) createXModel).setCode((Number) 1);
                    CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
                    this.sendJsEvent(jsEventDelegate, params.getSocketTaskID());
                }
            });
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod
    public void release() {
        IBDXBridgeContext iBDXBridgeContext = this.bridgeContext;
        String containerID = iBDXBridgeContext != null ? iBDXBridgeContext.getContainerID() : null;
        String str = containerID;
        if (str == null || str.length() == 0) {
            return;
        }
        NetRequestServiceImpl.INSTANCE.closeSocket(containerID, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendJsEvent(JSEventDelegate jsEventDelegate, String socketTaskID) {
        HashMap hashMap = new HashMap();
        hashMap.put(PageDataManager.EXTRA_STATUS, "closed");
        if (socketTaskID != null) {
            hashMap.put("socketTaskID", socketTaskID);
        }
        if (jsEventDelegate != null) {
            jsEventDelegate.sendJSEvent("x.socketStatusChanged", hashMap);
        }
    }
}
