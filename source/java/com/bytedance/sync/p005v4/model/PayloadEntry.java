package com.bytedance.sync.p005v4.model;

import com.bytedance.sync.p005v4.net.NetTrace;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class PayloadEntry {
    public boolean canFallback;
    public boolean forceHttps;
    public BsyncProtocol msg;
    public int sendReason;
    public NetTrace trace;
}
