package com.bytedance.sync.v4.model;

import com.bytedance.sync.v4.net.NetTrace;
import com.bytedance.sync.v4.protocal.BsyncProtocol;

/* loaded from: classes5.dex */
public class PayloadEntry {
    public boolean canFallback;
    public boolean forceHttps;
    public BsyncProtocol msg;
    public int sendReason;
    public NetTrace trace;
}
