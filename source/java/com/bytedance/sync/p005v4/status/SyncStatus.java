package com.bytedance.sync.p005v4.status;

import com.bytedance.sync.SyncMonitor;
import com.bytedance.sync.p005v4.intf.ISyncStatus;
import com.bytedance.timonbase.scene.PageDataManager;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

/* compiled from: SyncStatus.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0016J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sync/v4/status/SyncStatus;", "Lcom/bytedance/sync/v4/intf/ISyncStatus;", "()V", "lastConnectStatus", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastSendSyncTimeStamp", "Ljava/util/concurrent/atomic/AtomicLong;", "lastSyncMethod", "Ljava/util/concurrent/atomic/AtomicInteger;", "getLastConnectStatus", "", "getLastSendSyncMethod", "", "onReceiveSyncMsg", "", "updateLastConnectStatus", PageDataManager.EXTRA_STATUS, "updateLastSendSyncMethod", "method", "sendResult", "timeStamp", "", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SyncStatus implements ISyncStatus {
    private volatile AtomicInteger lastSyncMethod = new AtomicInteger(1);
    private volatile AtomicBoolean lastConnectStatus = new AtomicBoolean(true);
    private volatile AtomicLong lastSendSyncTimeStamp = new AtomicLong(0);

    @Override // com.bytedance.sync.p005v4.intf.ISyncStatus
    public void updateLastSendSyncMethod(int method, int sendResult, long timeStamp) {
        this.lastSyncMethod.set(method);
        this.lastSendSyncTimeStamp.set(timeStamp);
    }

    @Override // com.bytedance.sync.p005v4.intf.ISyncStatus
    public int getLastSendSyncMethod() {
        return this.lastSyncMethod.get();
    }

    @Override // com.bytedance.sync.p005v4.intf.ISyncStatus
    public void updateLastConnectStatus(boolean status) {
        this.lastConnectStatus.set(status);
    }

    @Override // com.bytedance.sync.p005v4.intf.ISyncStatus
    public boolean getLastConnectStatus() {
        return this.lastConnectStatus.get();
    }

    @Override // com.bytedance.sync.p005v4.intf.ISyncStatus
    public void onReceiveSyncMsg() {
        SyncMonitor.monitorSyncCost(this.lastSendSyncTimeStamp.get());
    }
}
