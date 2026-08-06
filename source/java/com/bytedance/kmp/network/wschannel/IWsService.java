package com.bytedance.kmp.network.wschannel;

import com.bytedance.kmp.spi.IKmpService;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: IWsService.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/kmp/network/wschannel/IWsService;", "Lcom/bytedance/kmp/spi/IKmpService;", "isConnected", "", "id", "", "register", "info", "Lcom/bytedance/kmp/network/wschannel/ChannelInfo;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/kmp/network/wschannel/IWsEventListener;", "sendMsg", "", "msg", "Lcom/bytedance/kmp/network/wschannel/WsChannelMsg;", "setNewParams", "startConnection", "stopConnection", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IWsService extends IKmpService {
    boolean isConnected(int id);

    int register(ChannelInfo info, IWsEventListener listener);

    void sendMsg(int id, WsChannelMsg msg);

    void setNewParams(int id, ChannelInfo info);

    void startConnection(int id);

    void stopConnection(int id);
}
