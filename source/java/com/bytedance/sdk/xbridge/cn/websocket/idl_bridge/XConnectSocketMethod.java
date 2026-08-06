package com.bytedance.sdk.xbridge.cn.websocket.idl_bridge;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.IDLJSONUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.service.JSEventDelegate;
import com.bytedance.sdk.xbridge.cn.websocket.idl.AbsXConnectSocketMethodIDL;
import com.bytedance.sdk.xbridge.cn.websocket.utils.NetRequestServiceImpl;
import com.bytedance.sdk.xbridge.cn.websocket.utils.SocketRequest;
import com.bytedance.sdk.xbridge.cn.websocket.utils.WebSocketConsts;
import com.bytedance.timonbase.scene.PageDataManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* compiled from: XConnectSocketMethod.kt */
@XBridgeMethod(name = "x.connectSocket")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/idl_bridge/XConnectSocketMethod;", "Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXConnectSocketMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXConnectSocketMethodIDL$XConnectSocketParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXConnectSocketMethodIDL$XConnectSocketResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XConnectSocketMethod extends AbsXConnectSocketMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXConnectSocketMethodIDL.XConnectSocketParamModel params, CompletionBlock<AbsXConnectSocketMethodIDL.XConnectSocketResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        String containerID = bridgeContext.getContainerID();
        String str = containerID;
        if (str == null || str.length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "ContainerID not provided in host", null, 4, null);
            return;
        }
        final JSEventDelegate jsEventDelegate = bridgeContext.getJsEventDelegate();
        NetRequestServiceImpl netRequestServiceImpl = NetRequestServiceImpl.INSTANCE;
        Activity activity = ownerActivity;
        String url = params.getUrl();
        Map<String, Object> header = params.getHeader();
        Unit unit = null;
        JSONObject jSONObject = header != null ? IDLJSONUtils.toJSONObject(header) : null;
        List<String> protocols = params.getProtocols();
        String addSocketRequest = netRequestServiceImpl.addSocketRequest(activity, containerID, new SocketRequest.RequestTask(url, jSONObject, protocols != null ? IDLJSONUtils.toJSONArray(protocols) : null), new SocketRequest.Callback() { // from class: com.bytedance.sdk.xbridge.cn.websocket.idl_bridge.XConnectSocketMethod$handle$socketTaskID$3
            @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.SocketRequest.Callback
            public void onStateChanged(SocketRequest.RequestState requestState) {
                Intrinsics.checkNotNullParameter(requestState, "requestState");
                String str2 = requestState.status;
                switch (str2.hashCode()) {
                    case -1987107780:
                        if (str2.equals(WebSocketConsts.StateType_ONMESSAGED)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("socketTaskID", requestState.socketTaskID);
                            String str3 = requestState.textData;
                            if (str3 != null) {
                            }
                            String str4 = requestState.dataType;
                            if (str4 != null) {
                                hashMap.put("dataType", str4);
                            }
                            JSEventDelegate.this.sendJSEvent("x.socketDataReceived", hashMap);
                            return;
                        }
                        return;
                    case -1357520532:
                        if (str2.equals("closed")) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put(PageDataManager.EXTRA_STATUS, "closed");
                            hashMap2.put("socketTaskID", requestState.socketTaskID);
                            JSEventDelegate.this.sendJSEvent("x.socketStatusChanged", hashMap2);
                            return;
                        }
                        return;
                    case -1281977283:
                        if (str2.equals("failed")) {
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put(PageDataManager.EXTRA_STATUS, "failed");
                            hashMap3.put("message", requestState.message);
                            hashMap3.put("socketTaskID", requestState.socketTaskID);
                            JSEventDelegate.this.sendJSEvent("x.socketStatusChanged", hashMap3);
                            return;
                        }
                        return;
                    case -579210487:
                        if (str2.equals(WebSocketConsts.StateType_CONNECTED)) {
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put(PageDataManager.EXTRA_STATUS, WebSocketConsts.StateType_CONNECTED);
                            hashMap4.put("socketTaskID", requestState.socketTaskID);
                            JSEventDelegate.this.sendJSEvent("x.socketStatusChanged", hashMap4);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
        if (addSocketRequest != null) {
            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXConnectSocketMethodIDL.XConnectSocketResultModel.class));
            ((AbsXConnectSocketMethodIDL.XConnectSocketResultModel) createXModel).setSocketTaskID(addSocketRequest);
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "can not get the socketTaskID", null, 4, null);
        }
    }
}
