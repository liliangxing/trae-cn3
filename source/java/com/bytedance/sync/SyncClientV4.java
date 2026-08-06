package com.bytedance.sync;

import android.content.Context;
import com.bytedance.sync.interfaze.ISendInterceptor;
import com.bytedance.sync.interfaze.ISettings;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.interfaze.OnDataUpdateListener;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.IPayloadSendServiceV4;
import com.bytedance.sync.settings.SyncSettings;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SyncClientV4 implements ISyncClient {
    private final String TAG = "[SyncClientV4] ";
    private boolean isValidClient = true;
    private final Long mBusinessId;
    private final BusinessManager mBusinessMngr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SyncClientV4(Long l, BusinessManager businessManager) {
        this.mBusinessId = l;
        this.mBusinessMngr = businessManager;
    }

    @Override // com.bytedance.sync.interfaze.ISyncClient
    public void remove() {
        this.mBusinessMngr.remove(this.mBusinessId.longValue());
        this.isValidClient = false;
    }

    @Override // com.bytedance.sync.interfaze.ISyncClient
    public void removeOnDataUpdateListener(OnDataUpdateListener onDataUpdateListener) {
        SyncBusiness businessById = this.mBusinessMngr.getBusinessById(this.mBusinessId.longValue());
        if (businessById != null) {
            businessById.removeOnDataUpdateListener(onDataUpdateListener);
        }
    }

    @Override // com.bytedance.sync.interfaze.ISyncClient
    public void addOnDataUpdateListener(OnDataUpdateListener onDataUpdateListener) {
        SyncBusiness businessById = this.mBusinessMngr.getBusinessById(this.mBusinessId.longValue());
        if (businessById != null) {
            businessById.addOnDataUpdateListener(onDataUpdateListener);
        }
    }

    @Override // com.bytedance.sync.interfaze.ISyncClient
    public void addOnSendInterceptor(ISendInterceptor iSendInterceptor) {
        SyncBusiness businessById = this.mBusinessMngr.getBusinessById(this.mBusinessId.longValue());
        if (businessById != null) {
            businessById.addOnSendDataListener(iSendInterceptor);
        }
    }

    @Override // com.bytedance.sync.interfaze.ISyncClient
    public void removeOnSendInterceptor(ISendInterceptor iSendInterceptor) {
        SyncBusiness businessById = this.mBusinessMngr.getBusinessById(this.mBusinessId.longValue());
        if (businessById != null) {
            businessById.removeOnSendDataListener(iSendInterceptor);
        }
    }

    @Override // com.bytedance.sync.interfaze.ISyncClient
    public ISyncClient.Result sendMsg(Context context, byte[] bArr) {
        if (!this.isValidClient) {
            return new ISyncClient.Result(false, "[SyncClientV4] client has be removed");
        }
        if (bArr == null) {
            return new ISyncClient.Result(false, "[SyncClientV4] data is null");
        }
        ISettings settings = SyncSettings.inst(context).getSettings();
        if (bArr.length > settings.submitSizeLimit()) {
            LogUtils.m186e("[SyncClientV4] data size is too large or null, size = " + bArr.length + ", limit = " + settings.submitSizeLimit());
            return new ISyncClient.Result(false, "data size is too large. limit = " + settings.submitSizeLimit() + ", target size = " + bArr.length);
        }
        ((IPayloadSendServiceV4) UgBusFramework.getService(IPayloadSendServiceV4.class)).trySendMsg(this.mBusinessId.longValue(), bArr);
        return new ISyncClient.Result(true, "");
    }

    @Override // com.bytedance.sync.interfaze.ISyncClient
    public ISyncClient.Result sendMsg(Context context, List<ISyncClient.ReportItem> list) {
        if (!this.isValidClient) {
            return new ISyncClient.Result(false, "client has be removed");
        }
        if (list == null) {
            return new ISyncClient.Result(false, "data is null");
        }
        ISettings settings = SyncSettings.inst(context).getSettings();
        for (ISyncClient.ReportItem reportItem : list) {
            if (reportItem.data != null && reportItem.data.length > settings.submitSizeLimit()) {
                LogUtils.m186e("[SyncClientV4] data size is too large or null, size = " + reportItem.data.length + ", limit = " + settings.submitSizeLimit());
                return new ISyncClient.Result(false, "data size is too large. limit = " + settings.submitSizeLimit() + ", target size = " + reportItem.data.length);
            }
        }
        ((IPayloadSendServiceV4) UgBusFramework.getService(IPayloadSendServiceV4.class)).trySendMsg(this.mBusinessId.longValue(), list);
        return new ISyncClient.Result(true, "");
    }
}
