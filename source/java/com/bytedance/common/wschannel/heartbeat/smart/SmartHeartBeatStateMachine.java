package com.bytedance.common.wschannel.heartbeat.smart;

import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.p007ok.OkChannelImpl;
import com.bytedance.common.wschannel.heartbeat.HeartBeatReactListener;
import com.bytedance.common.wschannel.heartbeat.smart.state.ActiveHeartBeatState;
import com.bytedance.common.wschannel.heartbeat.smart.state.ISmartHeartBeatState;
import com.bytedance.common.wschannel.heartbeat.smart.state.IdleHeartBeatState;
import com.bytedance.common.wschannel.heartbeat.smart.state.PlumbHeartBeatState;
import com.bytedance.common.wschannel.heartbeat.smart.state.SecondaryActiveHeartBeatState;
import com.bytedance.common.wschannel.heartbeat.smart.state.StableHeartBeatState;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SmartHeartBeatStateMachine {
    private ISmartHeartBeatState activeState;
    private ISmartHeartBeatState idleState;
    private ISmartHeartBeatState plumbState;
    private SmartHeartBeatPolicy policy;
    private ISmartHeartBeatState secondaryActiveState;
    private ISmartHeartBeatState stableState;

    public void init(HeartBeatReactListener heartBeatReactListener, SmartHeartBeatPolicy smartHeartBeatPolicy, SmartHeartBeatMeta smartHeartBeatMeta, Handler handler) {
        this.policy = smartHeartBeatPolicy;
        this.activeState = new ActiveHeartBeatState(heartBeatReactListener, this, smartHeartBeatMeta, handler);
        this.secondaryActiveState = new SecondaryActiveHeartBeatState(heartBeatReactListener, this, smartHeartBeatMeta, handler);
        this.plumbState = new PlumbHeartBeatState(heartBeatReactListener, this, smartHeartBeatMeta, handler);
        this.stableState = new StableHeartBeatState(heartBeatReactListener, this, smartHeartBeatMeta, handler);
        this.idleState = new IdleHeartBeatState(this);
        onIdleState();
    }

    public void onActiveState() {
        Logger.m193e(OkChannelImpl.TAG, "enter active state");
        this.policy.setState(this.activeState);
    }

    public void onSecondaryActiveState() {
        Logger.m193e(OkChannelImpl.TAG, "enter secondary active state");
        this.policy.setState(this.secondaryActiveState);
    }

    public void onPlumbState() {
        Logger.m193e(OkChannelImpl.TAG, "emter plumb state");
        this.policy.setState(this.plumbState);
    }

    public void onStableState() {
        Logger.m193e(OkChannelImpl.TAG, "enter stable state");
        this.policy.setState(this.stableState);
    }

    public void onIdleState() {
        Logger.m193e(OkChannelImpl.TAG, "enter idle state");
        this.policy.setState(this.idleState);
    }
}
