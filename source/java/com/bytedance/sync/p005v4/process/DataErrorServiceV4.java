package com.bytedance.sync.p005v4.process;

import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.intf.IDataErrorServiceV4;
import com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4;
import com.ss.android.ug.bus.IUgBusService;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataErrorServiceV4.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sync/v4/process/DataErrorServiceV4;", "Lcom/bytedance/sync/v4/intf/IDataErrorServiceV4;", "()V", "clearLocalData", "", "syncId", "", "deleteFiles", "pollErrorSyncId", "", "pendingRetryPollSyncId", "", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DataErrorServiceV4 implements IDataErrorServiceV4 {
    @Override // com.bytedance.sync.p005v4.intf.IDataErrorServiceV4
    public boolean clearLocalData(String syncId, boolean deleteFiles) {
        Intrinsics.checkNotNullParameter(syncId, "syncId");
        IFileDataCacheService iFileDataCacheService = (IFileDataCacheService) UgBusFramework.getService(IFileDataCacheService.class);
        if (deleteFiles) {
            iFileDataCacheService.deleteAllFiles(Long.parseLong(syncId));
        }
        return ((IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class)).deleteLocalData(syncId);
    }

    @Override // com.bytedance.sync.p005v4.intf.IDataErrorServiceV4
    public void pollErrorSyncId(Set<String> pendingRetryPollSyncId) {
        Intrinsics.checkNotNullParameter(pendingRetryPollSyncId, "pendingRetryPollSyncId");
        IUgBusService service = UgBusFramework.getService(ISyncMsgSenderV4.class);
        Intrinsics.checkNotNullExpressionValue(service, "getService(ISyncMsgSenderV4::class.java)");
        ISyncMsgSenderV4.DefaultImpls.sendPollMsg$default((ISyncMsgSenderV4) service, false, 0, 3, null);
    }
}
