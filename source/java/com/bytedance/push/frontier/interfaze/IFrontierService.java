package com.bytedance.push.frontier.interfaze;

import com.bytedance.common.wschannel.app.OnMessageReceiveListener;

/* loaded from: classes4.dex */
public interface IFrontierService {
    void registerFrontierPush(OnMessageReceiveListener onMessageReceiveListener);

    void unRegisterFrontierPush();
}
