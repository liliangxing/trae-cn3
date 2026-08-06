package com.ss.android.deviceregister.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.ss.android.deviceregister.LogUtils;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes7.dex */
final class ServiceBlockBinder<SERVICE, RESULT> {
    private final CountDownLatch latch = new CountDownLatch(1);
    private final Context mContext;
    private final Intent mIntent;
    private final ServiceBindedListener<SERVICE, RESULT> mListener;

    /* loaded from: classes7.dex */
    interface ServiceBindedListener<T, RESULT> {
        T asInterface(IBinder iBinder);

        RESULT fetchResult(T t) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceBlockBinder(Context context, Intent intent, ServiceBindedListener<SERVICE, RESULT> serviceBindedListener) {
        this.mContext = context;
        this.mIntent = intent;
        this.mListener = serviceBindedListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RESULT blockFetchResult() {
        ServiceBlockBinder<SERVICE, RESULT>.Conn conn;
        try {
            conn = new Conn(this.latch, this.mListener);
            this.mContext.bindService(this.mIntent, conn, 1);
            this.latch.await();
            try {
                return this.mListener.fetchResult(conn.service);
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    release(conn);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            conn = null;
        }
    }

    private void release(ServiceBlockBinder<SERVICE, RESULT>.Conn conn) {
        if (conn != null) {
            try {
                this.mContext.unbindService(conn);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    class Conn implements ServiceConnection {
        private final CountDownLatch latch;
        private final ServiceBindedListener<SERVICE, RESULT> mListener;
        SERVICE service;

        Conn(CountDownLatch countDownLatch, ServiceBindedListener<SERVICE, RESULT> serviceBindedListener) {
            this.latch = countDownLatch;
            this.mListener = serviceBindedListener;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogUtils.d(LogUtils.TAG, "ServiceBlockBinder#onServiceConnected " + componentName);
            try {
                try {
                    this.service = this.mListener.asInterface(iBinder);
                    this.latch.countDown();
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        LogUtils.d(LogUtils.TAG, "ServiceBlockBinder#onServiceConnected", th);
                        this.latch.countDown();
                    } catch (Throwable th2) {
                        try {
                            this.latch.countDown();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        throw th2;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtils.d(LogUtils.TAG, "ServiceBlockBinder#onServiceDisconnected" + componentName);
            try {
                this.latch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
