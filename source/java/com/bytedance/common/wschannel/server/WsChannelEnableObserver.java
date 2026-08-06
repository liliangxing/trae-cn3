package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.server.IEnableObserver;

/* loaded from: classes3.dex */
class WsChannelEnableObserver implements IEnableObserver {
    private final Context mContext;
    private final Handler mHandler;
    private IEnableObserver.OnWsChannelEnableChangedObserver mObserver;
    private boolean mPushSdkEnabled;
    private ContentObserver mPushSdkEnabledObserver;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WsChannelEnableObserver(Context context, Handler handler) {
        this.mHandler = handler;
        this.mContext = context;
    }

    @Override // com.bytedance.common.wschannel.server.IEnableObserver
    public void startLoad() {
        loadPushSdkEnabled();
        this.mPushSdkEnabledObserver = new ContentObserver(this.mHandler) { // from class: com.bytedance.common.wschannel.server.WsChannelEnableObserver.1
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                if (Logger.debug()) {
                    Logger.d("WsChannelService", "KEY_FRONTIER_ENABLED");
                }
                WsChannelEnableObserver.this.handlePushSdkEnabled();
            }
        };
        registerContentObservers();
    }

    private void loadPushSdkEnabled() {
        try {
            boolean isEnable = WsChannelSettings.inst(this.mContext).isEnable();
            if (Logger.debug()) {
                Logger.d("WsChannelService", "pushSdkEnabled = " + isEnable);
            }
            if (isEnable != this.mPushSdkEnabled) {
                this.mPushSdkEnabled = isEnable;
            }
        } catch (Throwable unused) {
        }
    }

    private void registerContentObservers() {
        try {
            this.mContext.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, WsConstants.KEY_FRONTIER_ENABLED, "boolean"), true, this.mPushSdkEnabledObserver);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePushSdkEnabled() {
        IEnableObserver.OnWsChannelEnableChangedObserver onWsChannelEnableChangedObserver;
        try {
            boolean z = this.mPushSdkEnabled;
            loadPushSdkEnabled();
            boolean z2 = this.mPushSdkEnabled;
            if (z == z2 || (onWsChannelEnableChangedObserver = this.mObserver) == null) {
                return;
            }
            onWsChannelEnableChangedObserver.onWsChannelEnableChange(z2);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.common.wschannel.server.IEnableObserver
    public boolean isEnable() {
        return this.mPushSdkEnabled;
    }

    @Override // com.bytedance.common.wschannel.server.IEnableObserver
    public void setEnableListener(IEnableObserver.OnWsChannelEnableChangedObserver onWsChannelEnableChangedObserver) {
        this.mObserver = onWsChannelEnableChangedObserver;
    }
}
