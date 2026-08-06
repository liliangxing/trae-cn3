package com.bytedance.sync.p005v4.intf;

import com.ss.android.ug.bus.IUgBusService;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: IDataErrorServiceV4.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sync/v4/intf/IDataErrorServiceV4;", "Lcom/ss/android/ug/bus/IUgBusService;", "clearLocalData", "", "syncId", "", "deleteFiles", "pollErrorSyncId", "", "pendingRetryPollSyncId", "", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IDataErrorServiceV4 extends IUgBusService {
    boolean clearLocalData(String syncId, boolean deleteFiles);

    void pollErrorSyncId(Set<String> pendingRetryPollSyncId);
}
