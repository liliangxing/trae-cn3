package com.ss.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLLog;
import com.ss.mediakit.net.CustomHTTPDNS;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.Locale;
import java.util.concurrent.Future;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CustomHTTPDNS extends BaseDNS {
    private static final String TAG = "CustomHTTPDNS";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    private boolean mRet;

    public CustomHTTPDNS(String str, Handler handler, int i) {
        super(str, handler, i);
        this.mRet = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.mediakit.net.CustomHTTPDNS$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class RunnableC09431 implements Runnable {
        RunnableC09431() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$0$com-ss-mediakit-net-CustomHTTPDNS$1, reason: not valid java name */
        public /* synthetic */ String m4191lambda$run$0$comssmediakitnetCustomHTTPDNS$1() {
            Locale locale = Locale.US;
            Object[] objArr = new Object[2];
            objArr[0] = CustomHTTPDNS.this.mHostname;
            objArr[1] = Integer.valueOf(AVMDLDNSParser.mCustomHttpDNSParser != null ? 1 : 0);
            return String.format(locale, "----call custom httpdns, host:%s custom parser:%d", objArr);
        }

        @Override // java.lang.Runnable
        public void run() {
            AVMDLLog.m225d(CustomHTTPDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.CustomHTTPDNS$1$$ExternalSyntheticLambda0
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    return CustomHTTPDNS.RunnableC09431.this.m4191lambda$run$0$comssmediakitnetCustomHTTPDNS$1();
                }
            });
            AVMDLCustomHTTPDNSParserResult parseHost = AVMDLDNSParser.mCustomHttpDNSParser != null ? AVMDLDNSParser.mCustomHttpDNSParser.parseHost(CustomHTTPDNS.this.mHostname) : null;
            CustomHTTPDNS.this.mRet = true;
            if (parseHost == null || TextUtils.isEmpty(parseHost.mIPList)) {
                AVMDLLog.m225d(CustomHTTPDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.CustomHTTPDNS$1$$ExternalSyntheticLambda1
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        return CustomHTTPDNS.RunnableC09431.this.m4192lambda$run$1$comssmediakitnetCustomHTTPDNS$1();
                    }
                });
                CustomHTTPDNS.this.notifyError(new AVMDLDNSInfo(4, CustomHTTPDNS.this.mHostname, (String) null, 0L, CustomHTTPDNS.this.mId, CustomHTTPDNS.this.mTaskType));
                return;
            }
            AVMDLLog.m225d(CustomHTTPDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.CustomHTTPDNS$1$$ExternalSyntheticLambda2
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****default expiredtime:%d force expiredtime:%d ", Integer.valueOf(AVMDLDNSParser.mGlobalDefaultExpiredTime), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
                    return format;
                }
            });
            AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(4, CustomHTTPDNS.this.mHostname, parseHost.mIPList, System.currentTimeMillis() + ((AVMDLDNSParser.mGlobalForceExpiredTime > 0 ? AVMDLDNSParser.mGlobalForceExpiredTime : parseHost.mTTL) * 1000), CustomHTTPDNS.this.mId, -1);
            IPCache.getInstance().put(CustomHTTPDNS.this.mHostname, aVMDLDNSInfo);
            CustomHTTPDNS.this.notifySuccess(aVMDLDNSInfo);
            if (AVMDLLog.isLogLevelEnabled(1)) {
                final String str = parseHost.mIPList;
                AVMDLLog.m225d(CustomHTTPDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.CustomHTTPDNS$1$$ExternalSyntheticLambda3
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        return CustomHTTPDNS.RunnableC09431.this.m4193lambda$run$3$comssmediakitnetCustomHTTPDNS$1(str);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$1$com-ss-mediakit-net-CustomHTTPDNS$1, reason: not valid java name */
        public /* synthetic */ String m4192lambda$run$1$comssmediakitnetCustomHTTPDNS$1() {
            return String.format(Locale.US, "****end call custom httpdns, result null or iplist null host:%s", CustomHTTPDNS.this.mHostname);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$3$com-ss-mediakit-net-CustomHTTPDNS$1, reason: not valid java name */
        public /* synthetic */ String m4193lambda$run$3$comssmediakitnetCustomHTTPDNS$1(String str) {
            return String.format(Locale.US, "****end call custom httpdns, suc iplist:%s host:%s", str, CustomHTTPDNS.this.mHostname);
        }
    }

    @Override // com.ss.mediakit.net.BaseDNS
    public void start() {
        try {
            this.mFuture = AVMDLThreadPool.addExecuteTask(new RunnableC09431());
        } catch (Exception e) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.CustomHTTPDNS$$ExternalSyntheticLambda0
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    return CustomHTTPDNS.this.m4190lambda$start$0$comssmediakitnetCustomHTTPDNS(e);
                }
            });
            notifyError(new AVMDLDNSInfo(4, this.mHostname, (String) null, 0L, this.mId, this.mTaskType));
        }
        this.mHandler.postDelayed(new MyRunnable(this), 10000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$start$0$com-ss-mediakit-net-CustomHTTPDNS, reason: not valid java name */
    public /* synthetic */ String m4190lambda$start$0$comssmediakitnetCustomHTTPDNS(Exception exc) {
        return String.format(Locale.US, "****end call custom httpdns, exception:%s host:%s", exc, this.mHostname);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class MyRunnable implements Runnable {
        private final WeakReference<CustomHTTPDNS> mCustomHTTPDNSRef;

        public MyRunnable(CustomHTTPDNS customHTTPDNS) {
            this.mCustomHTTPDNSRef = new WeakReference<>(customHTTPDNS);
        }

        @Override // java.lang.Runnable
        public void run() {
            AVMDLLog.m225d(CustomHTTPDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.CustomHTTPDNS$MyRunnable$$ExternalSyntheticLambda0
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "----implement delayed check for custom httpdns", new Object[0]);
                    return format;
                }
            });
            CustomHTTPDNS customHTTPDNS = this.mCustomHTTPDNSRef.get();
            if (customHTTPDNS != null) {
                if (customHTTPDNS.mRet) {
                    return;
                }
                customHTTPDNS.cancel();
                AVMDLLog.m225d(CustomHTTPDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.CustomHTTPDNS$MyRunnable$$ExternalSyntheticLambda2
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "****end implement delayed check cancel custom httpdns,", new Object[0]);
                        return format;
                    }
                });
                customHTTPDNS.notifyError(new AVMDLDNSInfo(4, customHTTPDNS.mHostname, (String) null, 0L, customHTTPDNS.mId, -1));
                return;
            }
            AVMDLLog.m225d(CustomHTTPDNS.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.CustomHTTPDNS$MyRunnable$$ExternalSyntheticLambda1
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****end implement delayed check for custom httpdns, dns object null", new Object[0]);
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
