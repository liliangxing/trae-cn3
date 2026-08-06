package com.bytedance.sync.p005v4.compensate;

import com.bytedance.sync.interfaze.ISettings;
import com.bytedance.sync.p005v4.net.NetTrace;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ICompensatorV4 extends NetTrace.TraceDepend {
    void destroy();

    void onSettingsUpdate(ISettings iSettings, boolean z);

    void resetPollingInterval(BsyncProtocol bsyncProtocol);

    void start(ISettings iSettings, boolean z);

    void switchToPoll();
}
