package com.bytedance.common.wschannel.server;

import com.bytedance.common.wschannel.app.IWsApp;
import java.util.Map;

/* loaded from: classes3.dex */
public interface IWsChannelSaver {
    Map<Integer, IWsApp> loadWsChannels();

    void saveWsChannels(Map<Integer, IWsApp> map);
}
