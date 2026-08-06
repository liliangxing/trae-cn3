package com.bytedance.common.wschannel.heartbeat.smart.state;

import com.bytedance.common.wschannel.heartbeat.IHeartBeatPolicy;

/* loaded from: classes3.dex */
public interface ISmartHeartBeatState extends IHeartBeatPolicy {
    void onEnterThisState();

    StateType provideType();
}
