package com.ss.bduploader.net;

import android.os.Handler;
import android.text.TextUtils;
import com.ss.bduploader.BDUploadLog;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.concurrent.Future;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LocalDNS extends BaseDNS {
    private static final String TAG = "LocalDNS";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    private boolean mRet;

    public LocalDNS(String str, Handler handler) {
        super(str, handler);
        this.mRet = false;
    }

    @Override // com.ss.bduploader.net.BaseDNS
    public void start() {
        try {
            this.mFuture = BDUploadThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.bduploader.net.LocalDNS.1
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    BDUploadLog.m161d(LocalDNS.TAG, String.format("----call local dns, host:%s", LocalDNS.this.mHostname));
                    try {
                        LocalDNS localDNS = LocalDNS.this;
                        localDNS.mAddress = InetAddress.getAllByName(localDNS.mHostname);
                        LocalDNS.this.mRet = true;
                        if (LocalDNS.this.mAddress != null) {
                            String str2 = "";
                            for (int i = 0; i < LocalDNS.this.mAddress.length; i++) {
                                String hostAddress = LocalDNS.this.mAddress[i].getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress)) {
                                    if (TextUtils.isEmpty(str2)) {
                                        str = str2 + hostAddress;
                                    } else {
                                        str = str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + hostAddress;
                                    }
                                    str2 = str;
                                }
                            }
                            if (TextUtils.isEmpty(str2)) {
                                BDUploadLog.m161d(LocalDNS.TAG, String.format("****end call local dns, iplist null host:%s", LocalDNS.this.mHostname));
                                LocalDNS.this.notifyError(new BDUploadDNSInfo(0, LocalDNS.this.mHostname, null, 0L, LocalDNS.this.mId));
                                return;
                            } else {
                                BDUploadLog.m161d(LocalDNS.TAG, String.format("****end call local dns, suc iplist:%s host:%s", str2, LocalDNS.this.mHostname));
                                BDUploadDNSInfo bDUploadDNSInfo = new BDUploadDNSInfo(0, LocalDNS.this.mHostname, str2, System.currentTimeMillis() + (BDUploadDNSParser.mGlobalDefaultExpiredTime * 1000), LocalDNS.this.mId);
                                IPCache.getInstance().put(LocalDNS.this.mHostname, bDUploadDNSInfo);
                                LocalDNS.this.notifySuccess(bDUploadDNSInfo);
                                return;
                            }
                        }
                        BDUploadLog.m161d(LocalDNS.TAG, String.format("****end call local dns, not get address host:%s", LocalDNS.this.mHostname));
                        LocalDNS.this.notifyError(new BDUploadDNSInfo(0, LocalDNS.this.mHostname, null, 0L, LocalDNS.this.mId));
                    } catch (Throwable th) {
                        th.printStackTrace();
                        LocalDNS.this.mRet = true;
                        BDUploadLog.m161d(LocalDNS.TAG, String.format("****end call local dns, end exception:%s host:%s", th, LocalDNS.this.mHostname));
                        LocalDNS.this.notifyError(new BDUploadDNSInfo(0, LocalDNS.this.mHostname, null, 0L, LocalDNS.this.mId));
                    }
                }
            });
        } catch (Exception e) {
            BDUploadLog.m161d(TAG, String.format("****end call local dns, exception:%s host:%s", e, this.mHostname));
            notifyError(new BDUploadDNSInfo(0, this.mHostname, null, 0L, this.mId));
        }
        this.mHandler.postDelayed(new MyRunnable(this), 10000L);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class MyRunnable implements Runnable {
        private final WeakReference<LocalDNS> mLocalDNSRef;

        public MyRunnable(LocalDNS localDNS) {
            this.mLocalDNSRef = new WeakReference<>(localDNS);
        }

        @Override // java.lang.Runnable
        public void run() {
            BDUploadLog.m161d(LocalDNS.TAG, String.format("----implement delayed check for local dns", new Object[0]));
            LocalDNS localDNS = this.mLocalDNSRef.get();
            if (localDNS != null) {
                if (localDNS.mRet) {
                    return;
                }
                localDNS.cancel();
                BDUploadLog.m161d(LocalDNS.TAG, String.format("****end implement delayed check cancel local dns,", new Object[0]));
                localDNS.notifyError(new BDUploadDNSInfo(0, localDNS.mHostname, null, 0L, localDNS.mId));
                return;
            }
            BDUploadLog.m161d(LocalDNS.TAG, String.format("****end implement delayed check for local dns, dns object null", new Object[0]));
        }
    }

    @Override // com.ss.bduploader.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    @Override // com.ss.bduploader.net.BaseDNS
    public void close() {
        super.close();
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    @Override // com.ss.bduploader.net.BaseDNS
    public boolean isRunning() {
        return this.mRet;
    }
}
