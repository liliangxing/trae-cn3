package com.bytedance.sync.v4.intf;

import com.ss.android.ug.bus.IUgBusService;
import kotlin.Metadata;

/* compiled from: ISyncStatus.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H&J \u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sync/v4/intf/ISyncStatus;", "Lcom/ss/android/ug/bus/IUgBusService;", "getLastConnectStatus", "", "getLastSendSyncMethod", "", "onReceiveSyncMsg", "", "updateLastConnectStatus", "status", "updateLastSendSyncMethod", "method", "sendResult", "timeStamp", "", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface ISyncStatus extends IUgBusService {
    boolean getLastConnectStatus();

    int getLastSendSyncMethod();

    void onReceiveSyncMsg();

    void updateLastConnectStatus(boolean status);

    void updateLastSendSyncMethod(int method, int sendResult, long timeStamp);
}
