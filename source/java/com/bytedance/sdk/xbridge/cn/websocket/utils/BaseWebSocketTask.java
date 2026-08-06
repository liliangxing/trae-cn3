package com.bytedance.sdk.xbridge.cn.websocket.utils;

import android.content.Context;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.websocket.utils.SocketRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseWebSocketTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\nH\u0014J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0014J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0010H\u0014J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0010H\u0014J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\nH\u0014J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u0013H$J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0013H$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/BaseWebSocketTask;", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/IWebSocketTask;", "context", "Landroid/content/Context;", "requestTask", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$RequestTask;", "(Landroid/content/Context;Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$RequestTask;)V", "getContext", "()Landroid/content/Context;", "mCurrentStatus", "", "mStatusListener", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/WsStatusListener;", "getRequestTask", "()Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$RequestTask;", IWeixinService.ResponseConstants.URL, "", "getCurrentStatus", "onClosed", "", "needCallBack", "", "onConnected", "onFailed", "reason", "onReceivedMessage", "msg", "", "setCurrentStatus", "currentStatus", "setStatusListener", "listener", "startConnect", "startConnectReal", "stopConnect", "stopConnectReal", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class BaseWebSocketTask implements IWebSocketTask {
    private final Context context;
    private int mCurrentStatus;
    private WsStatusListener mStatusListener;
    private final SocketRequest.RequestTask requestTask;
    private final String url;

    protected abstract void startConnectReal();

    protected abstract void stopConnectReal();

    public BaseWebSocketTask(Context context, SocketRequest.RequestTask requestTask) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestTask, "requestTask");
        this.context = context;
        this.requestTask = requestTask;
        this.mCurrentStatus = -1;
        this.url = requestTask.url;
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SocketRequest.RequestTask getRequestTask() {
        return this.requestTask;
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.IWebSocketTask
    public void setStatusListener(WsStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mStatusListener = listener;
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.IWebSocketTask
    public void startConnect() {
        if (!TTNetWebSocketUtil.isConnect(this.context)) {
            XBridge.log("net error, url = " + this.url);
            onFailed("net error");
        } else {
            startConnectReal();
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.IWebSocketTask
    public void stopConnect() {
        if (getCurrentStatus() != -1) {
            stopConnectReal();
            setCurrentStatus(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onConnected() {
        WsStatusListener wsStatusListener = this.mStatusListener;
        if (wsStatusListener != null) {
            wsStatusListener.onConnected();
        }
        setCurrentStatus(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onClosed(boolean needCallBack) {
        WsStatusListener wsStatusListener = this.mStatusListener;
        if (wsStatusListener != null) {
            wsStatusListener.onClosed(needCallBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFailed(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        WsStatusListener wsStatusListener = this.mStatusListener;
        if (wsStatusListener != null) {
            wsStatusListener.onFailed(reason);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReceivedMessage(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        WsStatusListener wsStatusListener = this.mStatusListener;
        if (wsStatusListener != null) {
            wsStatusListener.onMessage(msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReceivedMessage(byte[] msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        WsStatusListener wsStatusListener = this.mStatusListener;
        if (wsStatusListener != null) {
            wsStatusListener.onMessage(msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized int getCurrentStatus() {
        return this.mCurrentStatus;
    }

    protected synchronized void setCurrentStatus(int currentStatus) {
        this.mCurrentStatus = currentStatus;
    }
}
