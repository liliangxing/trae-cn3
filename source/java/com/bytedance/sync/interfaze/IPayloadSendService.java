package com.bytedance.sync.interfaze;

import com.bytedance.sync.interfaze.ISyncClient;
import com.ss.android.ug.bus.IUgBusService;
import java.util.List;

/* loaded from: classes5.dex */
public interface IPayloadSendService extends IUgBusService {
    void trySendMsg(long j, List<ISyncClient.ReportItem> list);

    void trySendMsg(long j, byte[] bArr);
}
