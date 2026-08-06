package com.ss.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLLog;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.Locale;
import java.util.concurrent.Future;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LocalDNSHosts {
    private static final String TAG = "BatchParseLocalDNSHosts";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    protected Handler mHandler;
    public String[] mHosts;
    public String mId;
    private boolean mRet = false;
    protected boolean mCancelled = false;
    protected AVMDLNetClient mNetClient = null;

    public LocalDNSHosts(String[] strArr, Handler handler) {
        this.mHosts = strArr;
        this.mHandler = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.mediakit.net.LocalDNSHosts$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class RunnableC09491 implements Runnable {
        RunnableC09491() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            AVMDLLog.m226d(LocalDNSHosts.TAG, "----call local dns batch parse");
            for (int i = 0; i < LocalDNSHosts.this.mHosts.length; i++) {
                if (!TextUtils.isEmpty(LocalDNSHosts.this.mHosts[i])) {
                    try {
                        LocalDNSHosts localDNSHosts = LocalDNSHosts.this;
                        localDNSHosts.mAddress = InetAddress.getAllByName(localDNSHosts.mHosts[i]);
                        final String str2 = "";
                        for (int i2 = 0; i2 < LocalDNSHosts.this.mAddress.length; i2++) {
                            String hostAddress = LocalDNSHosts.this.mAddress[i2].getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress)) {
                                if (TextUtils.isEmpty(str2)) {
                                    str = str2 + hostAddress;
                                } else {
                                    str = str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + hostAddress;
                                }
                                str2 = str;
                            }
                        }
                        if (AVMDLLog.isLogLevelEnabled(1)) {
                            final String str3 = LocalDNSHosts.this.mHosts[i];
                            AVMDLLog.m225d(LocalDNSHosts.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNSHosts$1$$ExternalSyntheticLambda1
                                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                                public final String get() {
                                    String format;
                                    format = String.format(Locale.US, "host:%s pasrse suc result:%s", str3, str2);
                                    return format;
                                }
                            });
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            AVMDLLog.m225d(LocalDNSHosts.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNSHosts$1$$ExternalSyntheticLambda2
                                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                                public final String get() {
                                    String format;
                                    format = String.format(Locale.US, "****default expiredtime:%d force expiredtime:%d ", Integer.valueOf(AVMDLDNSParser.mGlobalDefaultExpiredTime), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
                                    return format;
                                }
                            });
                            IPCache.getInstance().put(LocalDNSHosts.this.mHosts[i], new AVMDLDNSInfo(0, LocalDNSHosts.this.mHosts[i], str2, System.currentTimeMillis() + ((AVMDLDNSParser.mGlobalForceExpiredTime > 0 ? AVMDLDNSParser.mGlobalForceExpiredTime : AVMDLDNSParser.mGlobalDefaultExpiredTime) * 1000), LocalDNSHosts.this.mId, -1));
                        }
                    } catch (Throwable th) {
                        if (AVMDLLog.isLogLevelEnabled(1)) {
                            final String str4 = LocalDNSHosts.this.mHosts[i];
                            AVMDLLog.m225d(LocalDNSHosts.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNSHosts$1$$ExternalSyntheticLambda0
                                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                                public final String get() {
                                    String format;
                                    format = String.format(Locale.US, "host:%s pasrse err:%s", str4, th.getMessage());
                                    return format;
                                }
                            });
                        }
                    }
                }
            }
            LocalDNSHosts.this.mRet = true;
            AVMDLLog.m226d(LocalDNSHosts.TAG, "****end call local dns batch parse");
        }
    }

    public void start() {
        try {
            this.mFuture = AVMDLThreadPool.addExecuteTask(new RunnableC09491());
        } catch (Exception e) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNSHosts$$ExternalSyntheticLambda0
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****end call local dns, exception:%s", e);
                    return format;
                }
            });
        }
        this.mHandler.postDelayed(new MyRunnable(this), 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class MyRunnable implements Runnable {
        private final WeakReference<LocalDNSHosts> mLocalDNSRef;

        public MyRunnable(LocalDNSHosts localDNSHosts) {
            this.mLocalDNSRef = new WeakReference<>(localDNSHosts);
        }

        @Override // java.lang.Runnable
        public void run() {
            AVMDLLog.m225d(LocalDNSHosts.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNSHosts$MyRunnable$$ExternalSyntheticLambda0
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "----implement delayed check for local dns", new Object[0]);
                    return format;
                }
            });
            LocalDNSHosts localDNSHosts = this.mLocalDNSRef.get();
            if (localDNSHosts != null) {
                if (localDNSHosts.mRet) {
                    return;
                }
                localDNSHosts.cancel();
                AVMDLLog.m225d(LocalDNSHosts.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNSHosts$MyRunnable$$ExternalSyntheticLambda2
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "****end implement delayed check cancel local dns,", new Object[0]);
                        return format;
                    }
                });
                return;
            }
            AVMDLLog.m225d(LocalDNSHosts.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNSHosts$MyRunnable$$ExternalSyntheticLambda1
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****end implement delayed check for local dns, dns object null", new Object[0]);
                    return format;
                }
            });
        }
    }

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

    public void close() {
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    public boolean isRunning() {
        return this.mRet;
    }
}
