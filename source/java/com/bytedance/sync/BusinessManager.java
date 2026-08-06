package com.bytedance.sync;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sync.SyncBusiness;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.interfaze.SyncClientCreator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BusinessManager implements Handler.Callback {
    private final Map<Long, SyncBusiness> mBusinesses = new ConcurrentHashMap();
    private final SyncBusiness.DataListenerAddCallback mDataListenerAddCallback;
    private final SyncClientCreator mSyncClientCreator;

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    public BusinessManager(SyncBusiness.DataListenerAddCallback dataListenerAddCallback, SyncClientCreator syncClientCreator) {
        this.mDataListenerAddCallback = dataListenerAddCallback;
        this.mSyncClientCreator = syncClientCreator;
    }

    public ISyncClient registerBusiness(SyncBiz syncBiz) {
        ISyncClient iSyncClient;
        synchronized (this) {
            SyncBusiness syncBusiness = this.mBusinesses.get(Long.valueOf(syncBiz.bizId));
            if (syncBusiness != null) {
                syncBusiness.addOnDataUpdateListeners(syncBiz.listeners);
                iSyncClient = this.mBusinesses.get(Long.valueOf(syncBiz.bizId)).getSyncClient();
            } else {
                ISyncClient create = this.mSyncClientCreator.create(Long.valueOf(syncBiz.bizId));
                SyncBusiness syncBusiness2 = new SyncBusiness(syncBiz, create, this.mDataListenerAddCallback);
                syncBusiness2.addOnDataUpdateListeners(syncBiz.listeners);
                syncBusiness2.addOnSendDataListeners(syncBiz.mSendListeners);
                this.mBusinesses.put(Long.valueOf(syncBiz.bizId), syncBusiness2);
                iSyncClient = create;
            }
        }
        return iSyncClient;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove(long j) {
        this.mBusinesses.remove(Long.valueOf(j));
    }

    public SyncBusiness getBusinessById(long j) {
        return this.mBusinesses.get(Long.valueOf(j));
    }

    public Collection<SyncBusiness> getBusinesses() {
        return new ArrayList(this.mBusinesses.values());
    }
}
