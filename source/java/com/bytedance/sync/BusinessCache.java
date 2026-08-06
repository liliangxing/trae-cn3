package com.bytedance.sync;

import android.content.Context;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.sync.interfaze.ISendInterceptor;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.interfaze.OnDataUpdateListener;
import com.bytedance.sync.logger.LogUtils;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BusinessCache {
    private final DelayTaskExecutor mDelayTasks = new DelayTaskExecutor();

    public void doAfterInit() {
        if (this.mDelayTasks.hasDelayTask()) {
            TTExecutors.getCPUThreadPool().submit(new Runnable() { // from class: com.bytedance.sync.BusinessCache.1
                @Override // java.lang.Runnable
                public void run() {
                    BusinessCache.this.mDelayTasks.onReady();
                }
            });
        }
    }

    public ISyncClient addToCache(final SyncBiz syncBiz) {
        final BeforeInitSyncClient beforeInitSyncClient = new BeforeInitSyncClient(syncBiz);
        this.mDelayTasks.runAfterReady(new Runnable() { // from class: com.bytedance.sync.BusinessCache.2
            @Override // java.lang.Runnable
            public void run() {
                if (beforeInitSyncClient.isValid()) {
                    beforeInitSyncClient.setImpl(SyncSDK.registerBusiness(syncBiz));
                }
            }
        });
        return beforeInitSyncClient;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class BeforeInitSyncClient implements ISyncClient {
        private final SyncBiz mBiz;
        private volatile ISyncClient mRealClient;
        private volatile boolean mValid;

        private BeforeInitSyncClient(SyncBiz syncBiz) {
            this.mValid = true;
            this.mBiz = syncBiz;
        }

        @Override // com.bytedance.sync.interfaze.ISyncClient
        public void remove() {
            this.mValid = false;
            if (this.mRealClient != null) {
                this.mRealClient.remove();
            }
        }

        @Override // com.bytedance.sync.interfaze.ISyncClient
        public void removeOnDataUpdateListener(OnDataUpdateListener onDataUpdateListener) {
            if (this.mRealClient == null) {
                this.mBiz.listeners.remove(onDataUpdateListener);
            } else {
                this.mRealClient.removeOnDataUpdateListener(onDataUpdateListener);
            }
        }

        @Override // com.bytedance.sync.interfaze.ISyncClient
        public void addOnDataUpdateListener(OnDataUpdateListener onDataUpdateListener) {
            if (this.mRealClient == null) {
                this.mBiz.listeners.add(onDataUpdateListener);
            } else {
                this.mRealClient.addOnDataUpdateListener(onDataUpdateListener);
            }
        }

        @Override // com.bytedance.sync.interfaze.ISyncClient
        public void removeOnSendInterceptor(ISendInterceptor iSendInterceptor) {
            if (this.mRealClient == null) {
                this.mBiz.mSendListeners.remove(iSendInterceptor);
            } else {
                this.mRealClient.removeOnSendInterceptor(iSendInterceptor);
            }
        }

        @Override // com.bytedance.sync.interfaze.ISyncClient
        public void addOnSendInterceptor(ISendInterceptor iSendInterceptor) {
            if (this.mRealClient == null) {
                this.mBiz.mSendListeners.add(iSendInterceptor);
            } else {
                this.mRealClient.addOnSendInterceptor(iSendInterceptor);
            }
        }

        @Override // com.bytedance.sync.interfaze.ISyncClient
        public ISyncClient.Result sendMsg(Context context, byte[] bArr) {
            if (this.mRealClient != null) {
                return this.mRealClient.sendMsg(context, bArr);
            }
            LogUtils.m186e("sdk not init yet");
            return new ISyncClient.Result(false, "sdk not init yet");
        }

        @Override // com.bytedance.sync.interfaze.ISyncClient
        public ISyncClient.Result sendMsg(Context context, List<ISyncClient.ReportItem> list) {
            if (this.mRealClient != null) {
                return this.mRealClient.sendMsg(context, list);
            }
            LogUtils.m186e("sdk not init yet");
            return new ISyncClient.Result(false, "sdk not init yet");
        }

        public void setImpl(ISyncClient iSyncClient) {
            this.mRealClient = iSyncClient;
        }

        public boolean isValid() {
            return this.mValid;
        }
    }
}
