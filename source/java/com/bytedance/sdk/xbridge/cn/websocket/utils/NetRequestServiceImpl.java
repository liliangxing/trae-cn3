package com.bytedance.sdk.xbridge.cn.websocket.utils;

import android.content.Context;
import com.bytedance.sdk.xbridge.cn.websocket.utils.SocketRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetRequestServiceImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000fH\u0016J<\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\n\u001a\u00020\u000fH\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/NetRequestServiceImpl;", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/NetRequestService;", "()V", "addSocketRequest", "", "context", "Landroid/content/Context;", "containerID", "requestTask", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$RequestTask;", "callback", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$Callback;", "closeSocket", "", "socketTaskID", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$OperateTask$Callback;", "sendSocketData", "textData", "byteData", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NetRequestServiceImpl implements NetRequestService {
    public static final NetRequestServiceImpl INSTANCE = new NetRequestServiceImpl();

    private NetRequestServiceImpl() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.NetRequestService
    public String addSocketRequest(Context context, String containerID, SocketRequest.RequestTask requestTask, SocketRequest.Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(containerID, "containerID");
        Intrinsics.checkNotNullParameter(requestTask, "requestTask");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SocketManager.INSTANCE.getInstance().createTask(context, containerID, requestTask, callback);
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.NetRequestService
    public void sendSocketData(Context context, String containerID, String socketTaskID, String textData, byte[] byteData, SocketRequest.OperateTask.Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(containerID, "containerID");
        Intrinsics.checkNotNullParameter(socketTaskID, "socketTaskID");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = textData;
        if (!(str == null || str.length() == 0)) {
            String sendText = SocketManager.INSTANCE.getInstance().sendText(containerID, socketTaskID, textData);
            if (sendText != null) {
                callback.onOperateFail(sendText);
                return;
            }
            return;
        }
        if (byteData != null) {
            if (!(byteData.length == 0)) {
                String sendArrayBuffer = SocketManager.INSTANCE.getInstance().sendArrayBuffer(containerID, socketTaskID, byteData);
                if (sendArrayBuffer != null) {
                    callback.onOperateFail(sendArrayBuffer);
                    return;
                }
                return;
            }
        }
        callback.onOperateFail("unknown error");
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.NetRequestService
    public void closeSocket(String containerID, String socketTaskID, SocketRequest.OperateTask.Callback callback) {
        Intrinsics.checkNotNullParameter(containerID, "containerID");
        String closeSocket = SocketManager.INSTANCE.getInstance().closeSocket(containerID, socketTaskID);
        if (closeSocket == null) {
            if (callback != null) {
                callback.onOperateSuccess();
            }
        } else if (callback != null) {
            callback.onOperateFail(closeSocket);
        }
    }
}
