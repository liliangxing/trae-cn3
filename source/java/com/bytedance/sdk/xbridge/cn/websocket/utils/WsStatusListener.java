package com.bytedance.sdk.xbridge.cn.websocket.utils;

import kotlin.Metadata;

/* compiled from: WsStatusListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\tH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/WsStatusListener;", "", "onClosed", "", "needCallBack", "", "onConnected", "onFailed", "reason", "", "onMessage", "bytes", "", "text", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface WsStatusListener {
    void onClosed(boolean needCallBack);

    void onConnected();

    void onFailed(String reason);

    void onMessage(String text);

    void onMessage(byte[] bytes);
}
