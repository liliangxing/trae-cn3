package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bytedance.bdinstall.DrLog;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
final class ServiceBlockBinder<SERVICE, RESULT> {
    private final CountDownLatch latch = new CountDownLatch(1);
    private final Context mContext;
    private final Intent mIntent;
    private final ServiceBindedListener<SERVICE, RESULT> mListener;

    /* loaded from: classes3.dex */
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
        } catch (Throwable th) {
            th = th;
            conn = null;
        }
        if (!this.mContext.bindService(this.mIntent, conn, 1)) {
            release(null);
            return null;
        }
        this.latch.await();
        try {
            return this.mListener.fetchResult(conn.service);
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                return null;
            } finally {
                release(conn);
            }
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

    /* loaded from: classes3.dex */
    class Conn implements ServiceConnection {
        private final CountDownLatch latch;
        private final ServiceBindedListener<SERVICE, RESULT> mListener;
        SERVICE service;

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }

        Conn(CountDownLatch countDownLatch, ServiceBindedListener<SERVICE, RESULT> serviceBindedListener) {
            this.latch = countDownLatch;
            this.mListener = serviceBindedListener;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            DrLog.d("Oaid#ServiceBlockBinder#onServiceConnected " + componentName);
            try {
                try {
                    this.service = this.mListener.asInterface(iBinder);
                    this.latch.countDown();
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        DrLog.d("Oaid#ServiceBlockBinder#onServiceConnected #Throwable " + th);
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
            DrLog.d("Oaid#ServiceBlockBinder#onServiceDisconnected" + componentName);
            try {
                this.latch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
