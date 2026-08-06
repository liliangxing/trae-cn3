package com.ss.mediakit.net;

import android.net.Network;
import android.os.Handler;
import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLLog;
import com.ss.mediakit.net.LocalDNS;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.Locale;
import java.util.concurrent.Future;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LocalDNS extends BaseDNS {
    private static final String TAG = "LocalDNS";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    private int mLocalDNSType;
    private boolean mRet;

    public LocalDNS(int i, String str, Handler handler, int i2) {
        super(str, handler, i2);
        this.mRet = false;
        this.mLocalDNSType = i;
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNS$$ExternalSyntheticLambda0
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                return LocalDNS.this.m4199lambda$new$0$comssmediakitnetLocalDNS();
            }
        });
        AVMDLLog.m226d(TAG, "DNS use LocalDNS");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-ss-mediakit-net-LocalDNS, reason: not valid java name */
    public /* synthetic */ String m4199lambda$new$0$comssmediakitnetLocalDNS() {
        return String.format(Locale.US, "host:%s, use LocalDNS type:%d", this.mHostname, Integer.valueOf(this.mLocalDNSType));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.mediakit.net.LocalDNS$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class RunnableC09481 implements Runnable {
        RunnableC09481() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$0$com-ss-mediakit-net-LocalDNS$1, reason: not valid java name */
        public /* synthetic */ String m4201lambda$run$0$comssmediakitnetLocalDNS$1() {
            return String.format(Locale.US, "----call local dns, host:%s", LocalDNS.this.mHostname);
        }

        @Override // java.lang.Runnable
        public void run() {
            AVMDLLog.m225d(LocalDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNS$1$$ExternalSyntheticLambda0
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    return LocalDNS.RunnableC09481.this.m4201lambda$run$0$comssmediakitnetLocalDNS$1();
                }
            });
            try {
                Network curNetwork = AVMDLMultiNetwork.getCurNetwork();
                if (curNetwork != null) {
                    AVMDLLog.m225d(LocalDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNS$1$$ExternalSyntheticLambda1
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "do local by cellular network", new Object[0]);
                            return format;
                        }
                    });
                    LocalDNS localDNS = LocalDNS.this;
                    localDNS.mAddress = curNetwork.getAllByName(localDNS.mHostname);
                } else {
                    AVMDLLog.m225d(LocalDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNS$1$$ExternalSyntheticLambda2
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "do local by default network", new Object[0]);
                            return format;
                        }
                    });
                    LocalDNS localDNS2 = LocalDNS.this;
                    localDNS2.mAddress = InetAddress.getAllByName(localDNS2.mHostname);
                }
                LocalDNS.this.mRet = true;
                if (LocalDNS.this.mAddress != null) {
                    final String str = "";
                    for (int i = 0; i < LocalDNS.this.mAddress.length; i++) {
                        String hostAddress = LocalDNS.this.mAddress[i].getHostAddress();
                        if (!TextUtils.isEmpty(hostAddress)) {
                            if (TextUtils.isEmpty(str)) {
                                str = str + hostAddress;
                            } else {
                                str = str + Constants.ACCEPT_TIME_SEPARATOR_SP + hostAddress;
                            }
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        AVMDLLog.m225d(LocalDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNS$1$$ExternalSyntheticLambda5
                            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                            public final String get() {
                                return LocalDNS.RunnableC09481.this.m4204lambda$run$5$comssmediakitnetLocalDNS$1();
                            }
                        });
                        LocalDNS.this.notifyError(new AVMDLDNSInfo(LocalDNS.this.mLocalDNSType, LocalDNS.this.mHostname, (String) null, 0L, LocalDNS.this.mId, LocalDNS.this.mTaskType));
                        return;
                    }
                    AVMDLLog.m225d(LocalDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNS$1$$ExternalSyntheticLambda6
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "****default expiredtime:%d force expiredtime:%d ", Integer.valueOf(AVMDLDNSParser.mGlobalDefaultExpiredTime), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
                            return format;
                        }
                    });
                    int i2 = AVMDLDNSParser.mGlobalForceExpiredTime > 0 ? AVMDLDNSParser.mGlobalForceExpiredTime : AVMDLDNSParser.mGlobalDefaultExpiredTime;
                    AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(LocalDNS.this.mLocalDNSType, LocalDNS.this.mHostname, str, System.currentTimeMillis() + (i2 * 1000), LocalDNS.this.mId, LocalDNS.this.mTaskType);
                    aVMDLDNSInfo.setDnsExtInfo("ttl", i2);
                    IPCache.getInstance().put(LocalDNS.this.mHostname, aVMDLDNSInfo);
                    LocalDNS.this.notifySuccess(aVMDLDNSInfo);
                    if (AVMDLLog.isLogLevelEnabled(1)) {
                        AVMDLLog.m225d(LocalDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNS$1$$ExternalSyntheticLambda7
                            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                            public final String get() {
                                return LocalDNS.RunnableC09481.this.m4205lambda$run$7$comssmediakitnetLocalDNS$1(str);
                            }
                        });
                        return;
                    }
                    return;
                }
                AVMDLLog.m225d(LocalDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNS$1$$ExternalSyntheticLambda4
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        return LocalDNS.RunnableC09481.this.m4203lambda$run$4$comssmediakitnetLocalDNS$1();
                    }
                });
                LocalDNS.this.notifyError(new AVMDLDNSInfo(LocalDNS.this.mLocalDNSType, LocalDNS.this.mHostname, (String) null, 0L, LocalDNS.this.mId, LocalDNS.this.mTaskType));
            } catch (Throwable th) {
                th.printStackTrace();
                LocalDNS.this.mRet = true;
                AVMDLLog.m225d(LocalDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNS$1$$ExternalSyntheticLambda3
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        return LocalDNS.RunnableC09481.this.m4202lambda$run$3$comssmediakitnetLocalDNS$1(th);
                    }
                });
                LocalDNS.this.notifyError(new AVMDLDNSInfo(LocalDNS.this.mLocalDNSType, LocalDNS.this.mHostname, (String) null, 0L, LocalDNS.this.mId, LocalDNS.this.mTaskType));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$3$com-ss-mediakit-net-LocalDNS$1, reason: not valid java name */
        public /* synthetic */ String m4202lambda$run$3$comssmediakitnetLocalDNS$1(Throwable th) {
            return String.format(Locale.US, "****end call local dns, end exception:%s host:%s", th, LocalDNS.this.mHostname);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$4$com-ss-mediakit-net-LocalDNS$1, reason: not valid java name */
        public /* synthetic */ String m4203lambda$run$4$comssmediakitnetLocalDNS$1() {
            return String.format(Locale.US, "****end call local dns, not get address host:%s", LocalDNS.this.mHostname);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$5$com-ss-mediakit-net-LocalDNS$1, reason: not valid java name */
        public /* synthetic */ String m4204lambda$run$5$comssmediakitnetLocalDNS$1() {
            return String.format(Locale.US, "****end call local dns, iplist null host:%s", LocalDNS.this.mHostname);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$7$com-ss-mediakit-net-LocalDNS$1, reason: not valid java name */
        public /* synthetic */ String m4205lambda$run$7$comssmediakitnetLocalDNS$1(String str) {
            return String.format(Locale.US, "****end call local dns, suc iplist:%s host:%s", str, LocalDNS.this.mHostname);
        }
    }

    @Override // com.ss.mediakit.net.BaseDNS
    public void start() {
        try {
            this.mFuture = AVMDLThreadPool.addExecuteTask(new RunnableC09481());
        } catch (Exception e) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNS$$ExternalSyntheticLambda1
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    return LocalDNS.this.m4200lambda$start$1$comssmediakitnetLocalDNS(e);
                }
            });
            notifyError(new AVMDLDNSInfo(this.mLocalDNSType, this.mHostname, (String) null, 0L, this.mId, this.mTaskType));
        }
        this.mHandler.postDelayed(new MyRunnable(this), 10000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$start$1$com-ss-mediakit-net-LocalDNS, reason: not valid java name */
    public /* synthetic */ String m4200lambda$start$1$comssmediakitnetLocalDNS(Exception exc) {
        return String.format(Locale.US, "****end call local dns, exception:%s host:%s", exc, this.mHostname);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class MyRunnable implements Runnable {
        private final WeakReference<LocalDNS> mLocalDNSRef;

        public MyRunnable(LocalDNS localDNS) {
            this.mLocalDNSRef = new WeakReference<>(localDNS);
        }

        @Override // java.lang.Runnable
        public void run() {
            AVMDLLog.m225d(LocalDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNS$MyRunnable$$ExternalSyntheticLambda0
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "----implement delayed check for local dns", new Object[0]);
                    return format;
                }
            });
            LocalDNS localDNS = this.mLocalDNSRef.get();
            if (localDNS != null) {
                if (localDNS.mRet) {
                    return;
                }
                localDNS.cancel();
                AVMDLLog.m225d(LocalDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNS$MyRunnable$$ExternalSyntheticLambda2
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "****end implement delayed check cancel local dns,", new Object[0]);
                        return format;
                    }
                });
                localDNS.notifyError(new AVMDLDNSInfo(localDNS.mLocalDNSType, localDNS.mHostname, (String) null, 0L, localDNS.mId, -1));
                return;
            }
            AVMDLLog.m225d(LocalDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.LocalDNS$MyRunnable$$ExternalSyntheticLambda1
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****end implement delayed check for local dns, dns object null", new Object[0]);
                    return format;
                }
            });
        }
    }

    @Override // com.ss.mediakit.net.BaseDNS
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

    @Override // com.ss.mediakit.net.BaseDNS
    public void close() {
        super.close();
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    @Override // com.ss.mediakit.net.BaseDNS
    public boolean isRunning() {
        return this.mRet;
    }
}
