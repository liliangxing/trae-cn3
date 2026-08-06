package com.bytedance.common.wschannel.heartbeat.model;

import com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta;

/* loaded from: classes3.dex */
public interface IHeartBeatMeta<T extends IHeartBeatMeta> {
    T provideDefaultMeta();
}
