package com.bytedance.sync;

import com.bytedance.sync.interfaze.ISendInterceptor;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.interfaze.OnDataUpdateListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SyncBusiness {
    private final DataListenerAddCallback mDataListenerAddCallback;
    private final List<OnDataUpdateListener> mListener = new ArrayList();
    private final List<ISendInterceptor> mSendListener = new ArrayList();
    private final SyncBiz mSyncBiz;
    private final ISyncClient mSyncClient;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface DataListenerAddCallback {
        void onAdd(long j);
    }

    public SyncBusiness(SyncBiz syncBiz, ISyncClient iSyncClient, DataListenerAddCallback dataListenerAddCallback) {
        this.mSyncBiz = syncBiz;
        this.mSyncClient = iSyncClient;
        this.mDataListenerAddCallback = dataListenerAddCallback;
    }

    public long getBusiness() {
        return this.mSyncBiz.bizId;
    }

    public ISyncClient getSyncClient() {
        return this.mSyncClient;
    }

    public Object[] connectOnDataUpdateListener() {
        Object[] array;
        synchronized (this.mListener) {
            array = this.mListener.size() > 0 ? this.mListener.toArray() : null;
        }
        return array;
    }

    public Object[] connectOnSendDataListener() {
        Object[] array;
        synchronized (this.mSendListener) {
            array = this.mSendListener.size() > 0 ? this.mSendListener.toArray() : null;
        }
        return array;
    }

    public void addOnDataUpdateListener(OnDataUpdateListener onDataUpdateListener) {
        if (onDataUpdateListener == null) {
            return;
        }
        addOnDataUpdateListeners(Collections.singletonList(onDataUpdateListener));
    }

    public void removeOnDataUpdateListener(OnDataUpdateListener onDataUpdateListener) {
        synchronized (this.mListener) {
            this.mListener.remove(onDataUpdateListener);
        }
    }

    public void addOnDataUpdateListeners(List<OnDataUpdateListener> list) {
        boolean z;
        DataListenerAddCallback dataListenerAddCallback;
        synchronized (this.mListener) {
            ArrayList<OnDataUpdateListener> arrayList = new ArrayList(list);
            synchronized (this.mListener) {
                z = false;
                for (OnDataUpdateListener onDataUpdateListener : arrayList) {
                    if (onDataUpdateListener != null && !this.mListener.contains(onDataUpdateListener)) {
                        this.mListener.add(onDataUpdateListener);
                        z = true;
                    }
                }
            }
        }
        if (!z || (dataListenerAddCallback = this.mDataListenerAddCallback) == null) {
            return;
        }
        dataListenerAddCallback.onAdd(this.mSyncBiz.bizId);
    }

    public void addOnSendDataListener(ISendInterceptor iSendInterceptor) {
        if (iSendInterceptor == null) {
            return;
        }
        addOnSendDataListeners(Collections.singletonList(iSendInterceptor));
    }

    public void removeOnSendDataListener(ISendInterceptor iSendInterceptor) {
        synchronized (this.mSendListener) {
            this.mSendListener.remove(iSendInterceptor);
        }
    }

    public void addOnSendDataListeners(List<ISendInterceptor> list) {
        synchronized (this.mSendListener) {
            ArrayList<ISendInterceptor> arrayList = new ArrayList(list);
            synchronized (this.mSendListener) {
                for (ISendInterceptor iSendInterceptor : arrayList) {
                    if (iSendInterceptor != null && !this.mSendListener.contains(iSendInterceptor)) {
                        this.mSendListener.add(iSendInterceptor);
                    }
                }
            }
        }
    }

    public ICommonParamProvider getCommonParamProvider() {
        return this.mSyncBiz.commonParamProvider;
    }
}
