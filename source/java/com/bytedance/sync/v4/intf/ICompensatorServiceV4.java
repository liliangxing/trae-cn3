package com.bytedance.sync.v4.intf;

import com.bytedance.sync.v4.protocal.BsyncProtocol;
import com.ss.android.ug.bus.IUgBusService;

/* loaded from: classes5.dex */
public interface ICompensatorServiceV4 extends IUgBusService {
    public static final String TAG = "[CompensatorV4] ";

    void onReceiveSyncMsg();

    void reset();

    void resetPollingInterval(BsyncProtocol bsyncProtocol);

    void startOnce();
}
