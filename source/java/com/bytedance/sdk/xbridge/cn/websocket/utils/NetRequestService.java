package com.bytedance.sdk.xbridge.cn.websocket.utils;

import android.content.Context;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.sdk.xbridge.cn.websocket.utils.SocketRequest;
import kotlin.Metadata;

/* compiled from: NetRequestService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u000eH&J<\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\u000eH&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/NetRequestService;", "", "addSocketRequest", "", "context", "Landroid/content/Context;", "containerID", "requestTask", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$RequestTask;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$Callback;", "closeSocket", "", "socketTaskID", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$OperateTask$Callback;", "sendSocketData", "textData", "byteData", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface NetRequestService {
    String addSocketRequest(Context context, String containerID, SocketRequest.RequestTask requestTask, SocketRequest.Callback callback);

    void closeSocket(String containerID, String socketTaskID, SocketRequest.OperateTask.Callback callback);

    void sendSocketData(Context context, String containerID, String socketTaskID, String textData, byte[] byteData, SocketRequest.OperateTask.Callback callback);
}
