package com.bytedance.common.wschannel.server;

import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.SocketState;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
final class ChannelKeeper {
    Map<Integer, IWsApp> mWsAppMap = new ConcurrentHashMap();
    Map<Integer, IWsChannelClient> mWsChannelClientMap = new ConcurrentHashMap();
    Map<Integer, SocketState> mChannelState = new ConcurrentHashMap();
}
