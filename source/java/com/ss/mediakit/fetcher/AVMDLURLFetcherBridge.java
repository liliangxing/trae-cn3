package com.ss.mediakit.fetcher;

import android.text.TextUtils;
import com.ss.android.ugc.quota.tag.BDNetworkTagLaunchType;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AVMDLURLFetcherBridge implements AVMDLURLFetcherListener {
    private static final String TAG = "AVMDLURLFetcherBridge";
    private static AVMDLFetcherMakerInterface fetcherMaker = null;
    private static AVMDLNewFetcherMakerInterface newFetcherMaker = null;
    private static int sJniVersion = 2;
    private AVMDLURLFetcherInterface fetcherInstance;
    public String rawKey = null;
    public String fileKey = null;
    public String oldURL = null;
    String newURL = null;
    public String engineId = null;
    boolean isFinish = false;
    private Lock lock = new ReentrantLock();
    private long handle = 0;

    private static native void _notifyFetcherResult(long j, String str, String str2, String str3);

    private static native void _notifyFetcherResult(long j, String str, String str2, String str3, int i);

    public static void setFetcherMaker(AVMDLFetcherMakerInterface aVMDLFetcherMakerInterface) {
        if (aVMDLFetcherMakerInterface != null) {
            fetcherMaker = aVMDLFetcherMakerInterface;
        }
    }

    public static void setNewFetcherMaker(AVMDLNewFetcherMakerInterface aVMDLNewFetcherMakerInterface) {
        if (aVMDLNewFetcherMakerInterface != null) {
            newFetcherMaker = aVMDLNewFetcherMakerInterface;
        }
    }

    public int start(long j, String str, String str2, String str3) {
        final int i;
        AVMDLURLFetcherInterface fetcher;
        AVMDLLog.m226d(TAG, "----old api fallback retry Jni");
        AVMDLLog.m226d(TAG, "----start fetch rawkey:" + str);
        if (fetcherMaker == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            AVMDLLog.m226d(TAG, "****end fetch fail,fetcherMaker is null or rawky or filekey or originurl is null");
            return -1;
        }
        AVMDLLog.m226d(TAG, "----old api fallback retry engine");
        this.lock.lock();
        this.handle = j;
        try {
            try {
                fetcher = fetcherMaker.getFetcher(str, str2, str3);
                this.fetcherInstance = fetcher;
            } catch (Exception e) {
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.fetcher.AVMDLURLFetcherBridge$$ExternalSyntheticLambda0
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "****call start failed, get exception: %s", e.toString());
                        return format;
                    }
                });
                this.lock.unlock();
                i = BDNetworkTagLaunchType.UNSPECIFIED;
            }
            if (fetcher == null) {
                AVMDLLog.m226d(TAG, "****fail, get fetcher is null");
                return -1;
            }
            i = getNewUrl(fetcher, str, str2, str3);
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.fetcher.AVMDLURLFetcherBridge$$ExternalSyntheticLambda1
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****call start end, result:%d", Integer.valueOf(i));
                    return format;
                }
            });
            return i;
        } finally {
            this.lock.unlock();
        }
    }

    public int start(long j, String str, String str2, String str3, String str4) {
        final int i;
        AVMDLURLFetcherInterface fetcher;
        AVMDLLog.m226d(TAG, "----new api fallback retry Jni");
        AVMDLLog.m226d(TAG, "----start fetch rawkey:" + str);
        AVMDLLog.m226d(TAG, "----start fetch engineID is:" + str4);
        if (newFetcherMaker == null) {
            AVMDLLog.m226d(TAG, "----old api fallback retry engine");
            return start(j, str, str2, str3);
        }
        AVMDLLog.m226d(TAG, "----new api fallback retry engine");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            AVMDLLog.m226d(TAG, "****end fetch fail,fetcherMaker is null or rawky or filekey or originurl or engineId is null");
            return -1;
        }
        this.lock.lock();
        this.handle = j;
        try {
            try {
                this.engineId = str4;
                fetcher = newFetcherMaker.getFetcher(str, str2, str3, str4);
                this.fetcherInstance = fetcher;
            } catch (Exception e) {
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.fetcher.AVMDLURLFetcherBridge$$ExternalSyntheticLambda5
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "****call start failed, get exception: %s", e.toString());
                        return format;
                    }
                });
                this.lock.unlock();
                i = BDNetworkTagLaunchType.UNSPECIFIED;
            }
            if (fetcher == null) {
                AVMDLLog.m226d(TAG, "****fail, get fetcher is null");
                return -1;
            }
            i = getNewUrl(fetcher, str, str2, str3);
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.fetcher.AVMDLURLFetcherBridge$$ExternalSyntheticLambda6
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****call start end, result:%d", Integer.valueOf(i));
                    return format;
                }
            });
            return i;
        } finally {
            this.lock.unlock();
        }
    }

    int getNewUrl(AVMDLURLFetcherInterface aVMDLURLFetcherInterface, String str, String str2, String str3) {
        this.rawKey = str;
        this.fileKey = str2;
        this.oldURL = str3;
        final int start = aVMDLURLFetcherInterface.start(str, str2, str3, this);
        if (start <= 0) {
            return 0;
        }
        String[] uRLs = aVMDLURLFetcherInterface.getURLs();
        if (uRLs == null || uRLs.length == 0) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.fetcher.AVMDLURLFetcherBridge$$ExternalSyntheticLambda7
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****end fail start ret:%d, but getURLs null", Integer.valueOf(start));
                    return format;
                }
            });
            return -2;
        }
        if (this.handle == 0) {
            return 0;
        }
        this.newURL = uRLs[0];
        AVMDLLog.m226d(TAG, "start notify result");
        if (sJniVersion == 2) {
            try {
                _notifyFetcherResult(this.handle, str, str2, uRLs[0], 1);
            } catch (UnsatisfiedLinkError unused) {
                sJniVersion = 1;
            }
        }
        if (sJniVersion == 1) {
            _notifyFetcherResult(this.handle, str, str2, uRLs[0]);
        }
        AVMDLLog.m226d(TAG, "end notify result");
        return 1;
    }

    boolean isFinish() {
        return this.isFinish;
    }

    public String getResult() {
        this.lock.lock();
        try {
            String str = this.newURL;
            this.lock.unlock();
            AVMDLLog.m226d(TAG, "****get result:" + str);
            return str;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$release$5$com-ss-mediakit-fetcher-AVMDLURLFetcherBridge, reason: not valid java name */
    public /* synthetic */ String m4178lambda$release$5$comssmediakitfetcherAVMDLURLFetcherBridge() {
        return String.format(Locale.US, "----start release fetcher:%s", this);
    }

    public void release() {
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.fetcher.AVMDLURLFetcherBridge$$ExternalSyntheticLambda2
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                return AVMDLURLFetcherBridge.this.m4178lambda$release$5$comssmediakitfetcherAVMDLURLFetcherBridge();
            }
        });
        this.lock.lock();
        try {
            this.handle = 0L;
            this.lock.unlock();
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.fetcher.AVMDLURLFetcherBridge$$ExternalSyntheticLambda3
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    return AVMDLURLFetcherBridge.this.m4179lambda$release$6$comssmediakitfetcherAVMDLURLFetcherBridge();
                }
            });
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.fetcher.AVMDLURLFetcherBridge$$ExternalSyntheticLambda4
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    return AVMDLURLFetcherBridge.this.m4180lambda$release$7$comssmediakitfetcherAVMDLURLFetcherBridge();
                }
            });
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$release$6$com-ss-mediakit-fetcher-AVMDLURLFetcherBridge, reason: not valid java name */
    public /* synthetic */ String m4179lambda$release$6$comssmediakitfetcherAVMDLURLFetcherBridge() {
        return String.format(Locale.US, "remove fetcher rawkey:%s, fileKey:%s", this.rawKey, this.fileKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$release$7$com-ss-mediakit-fetcher-AVMDLURLFetcherBridge, reason: not valid java name */
    public /* synthetic */ String m4180lambda$release$7$comssmediakitfetcherAVMDLURLFetcherBridge() {
        return String.format(Locale.US, "****end call release:%s", this);
    }

    @Override // com.ss.mediakit.fetcher.AVMDLURLFetcherListener
    public void onCompletion(final int i, String str, String str2, String[] strArr) {
        this.lock.lock();
        try {
            if (!this.isFinish) {
                if (strArr != null && strArr.length > 0) {
                    this.newURL = strArr[0];
                }
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.fetcher.AVMDLURLFetcherBridge$$ExternalSyntheticLambda8
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        return AVMDLURLFetcherBridge.this.m223x4043ce89(i);
                    }
                });
                this.isFinish = true;
                if (this.handle != 0) {
                    AVMDLLog.m226d(TAG, "start notify result");
                    if (sJniVersion == 2) {
                        try {
                            _notifyFetcherResult(this.handle, str, str2, this.newURL, i);
                        } catch (UnsatisfiedLinkError unused) {
                            sJniVersion = 1;
                        }
                    }
                    if (sJniVersion == 1) {
                        _notifyFetcherResult(this.handle, str, str2, this.newURL);
                    }
                    AVMDLLog.m226d(TAG, "end notify result");
                }
            } else {
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.fetcher.AVMDLURLFetcherBridge$$ExternalSyntheticLambda9
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        return AVMDLURLFetcherBridge.this.m224xb5bdf4ca(i);
                    }
                });
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCompletion$8$com-ss-mediakit-fetcher-AVMDLURLFetcherBridge */
    public /* synthetic */ String m223x4043ce89(int i) {
        return String.format(Locale.US, "receive completion code:%d result:%s", Integer.valueOf(i), this.newURL);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCompletion$9$com-ss-mediakit-fetcher-AVMDLURLFetcherBridge */
    public /* synthetic */ String m224xb5bdf4ca(int i) {
        return String.format(Locale.US, "has fetch finished not need cur completion code:%d result:%s", Integer.valueOf(i), this.newURL);
    }
}
