package com.bytedance.sync.p005v4.intf;

import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.ss.android.ug.bus.IUgBusService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ICompensatorServiceV4 extends IUgBusService {
    public static final String TAG = "[CompensatorV4] ";

    void onReceiveSyncMsg();

    void reset();

    void resetPollingInterval(BsyncProtocol bsyncProtocol);

    void startOnce();
}
