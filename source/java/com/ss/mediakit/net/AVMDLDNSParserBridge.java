package com.ss.mediakit.net;

import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AVMDLDNSParserBridge implements AVMDLDNSParserListener {
    private static final String TAG = "AVMDLDNSParserBridge";
    private static boolean v2Usable = true;
    public String host;
    String ipList = null;
    boolean isFinish = false;
    private Lock lock = new ReentrantLock();
    private long handle = 0;

    private static native void _notifyParserResult(long j, String str, String str2, long j2, String str3);

    private static native void _notifyParserResultV2(long j, String str, String str2, long j2, String str3, int i);

    public int start(long j, String str) {
        int parserResult = v2Usable ? parserResult(j, str, 2, -1, -1) : 0;
        return parserResult <= 0 ? parserResult(j, str, 1, -1, -1) : parserResult;
    }

    public int start(long j, String str, int i) {
        int parserResult = v2Usable ? parserResult(j, str, 2, i, -1) : 0;
        return parserResult <= 0 ? parserResult(j, str, 1, i, -1) : parserResult;
    }

    public int start(long j, String str, int i, int i2) {
        int parserResult = v2Usable ? parserResult(j, str, 2, i, i2) : 0;
        return parserResult <= 0 ? parserResult(j, str, 1, i, i2) : parserResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009a A[Catch: UnsatisfiedLinkError -> 0x00ef, all -> 0x00fb, TryCatch #0 {UnsatisfiedLinkError -> 0x00ef, blocks: (B:15:0x0092, B:17:0x009a, B:19:0x00c8, B:20:0x00d9), top: B:14:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int parserResult(long j, String str, int i, int i2, int i3) {
        boolean z;
        AVMDLLog.m226d(TAG, "----start parse host:" + str + ",preferDNSType:" + i2 + ",taskType:" + i3);
        if (TextUtils.isEmpty(str)) {
            AVMDLLog.m226d(TAG, "****end parse fail for host:" + str);
            return -1;
        }
        this.lock.lock();
        this.handle = j;
        boolean z2 = true;
        int i4 = 0;
        AVMDLDNSParserBridge aVMDLDNSParserBridge = null;
        try {
            try {
                this.host = str;
                final AVMDLDNSInfo aVMDLDNSInfo = IPCache.getInstance().get(str);
                if (aVMDLDNSInfo != null) {
                    this.ipList = aVMDLDNSInfo.mIpList;
                    final long currentTimeMillis = System.currentTimeMillis();
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParserBridge$$ExternalSyntheticLambda0
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "get result from cache expiredT:%d curT:%d ", Long.valueOf(AVMDLDNSInfo.this.mExpiredTime), Long.valueOf(currentTimeMillis));
                            return format;
                        }
                    });
                    try {
                        if (aVMDLDNSInfo.mExpiredTime <= currentTimeMillis) {
                            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParserBridge$$ExternalSyntheticLambda1
                                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                                public final String get() {
                                    String format;
                                    format = String.format(Locale.US, "cache has expired need try call but not need listener", new Object[0]);
                                    return format;
                                }
                            });
                        } else if (i2 < 0 || (i2 >= 0 && aVMDLDNSInfo.mType == i2)) {
                            z = false;
                            if (this.handle != 0) {
                                AVMDLLog.m226d(TAG, "get cache iplist, host = " + aVMDLDNSInfo.mHost + " type = " + aVMDLDNSInfo.mType + " iplist = " + aVMDLDNSInfo.mIpList);
                                if (i == 1) {
                                    v2Usable = false;
                                    _notifyParserResult(this.handle, str, this.ipList, aVMDLDNSInfo.mExpiredTime, aVMDLDNSInfo.mExtraInfo);
                                } else {
                                    v2Usable = true;
                                    _notifyParserResultV2(this.handle, str, this.ipList, aVMDLDNSInfo.mExpiredTime, aVMDLDNSInfo.mExtraInfo, aVMDLDNSInfo.mType);
                                }
                            }
                            i4 = 1;
                            z2 = z;
                        }
                        if (this.handle != 0) {
                        }
                        i4 = 1;
                        z2 = z;
                    } catch (UnsatisfiedLinkError e) {
                        e = e;
                        z2 = z;
                        AVMDLLog.m228e(TAG, e.toString());
                        if (v2Usable) {
                            v2Usable = false;
                        }
                        this.lock.unlock();
                        final AVMDLDNSParserBridge aVMDLDNSParserBridge2 = aVMDLDNSParserBridge;
                        if (!z2) {
                        }
                        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParserBridge$$ExternalSyntheticLambda3
                            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                            public final String get() {
                                String format;
                                format = String.format(Locale.US, "****call start end, listener:%s", AVMDLDNSParserListener.this);
                                return format;
                            }
                        });
                        return i4;
                    }
                    z = true;
                } else {
                    AVMDLLog.m226d(TAG, "not get result from cache, need this listener");
                    aVMDLDNSParserBridge = this;
                }
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        } catch (UnsatisfiedLinkError e2) {
            e = e2;
        }
        this.lock.unlock();
        final AVMDLDNSParserListener aVMDLDNSParserBridge22 = aVMDLDNSParserBridge;
        if (!z2) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParserBridge$$ExternalSyntheticLambda2
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "call add host to parser listener:%s", AVMDLDNSParserListener.this);
                    return format;
                }
            });
            AVMDLDNSParser.getInstance().addHost(str, aVMDLDNSParserBridge22, i2, i3);
        } else {
            AVMDLLog.m226d(TAG, "not need call add host to parser");
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParserBridge$$ExternalSyntheticLambda3
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "****call start end, listener:%s", AVMDLDNSParserListener.this);
                return format;
            }
        });
        return i4;
    }

    public void triggerRefresh(long j, String str, int i) {
        AVMDLDNSParser.getInstance().postDNSInfoRefreshMsg(str, i);
    }

    boolean isFinish() {
        return this.isFinish;
    }

    public String getResult() {
        this.lock.lock();
        try {
            String str = this.ipList;
            this.lock.unlock();
            AVMDLLog.m226d(TAG, "****get result:" + str);
            return str;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public String getBackUp(String str) {
        AVMDLDNSInfo backUpIp;
        String str2 = (AVMDLDNSParser.getIntValue(5) != 1 || (backUpIp = IPCache.getInstance().getBackUpIp(str)) == null) ? null : backUpIp.mIpList;
        AVMDLLog.m226d(TAG, "****get backup ip result:" + str2);
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$release$4$com-ss-mediakit-net-AVMDLDNSParserBridge, reason: not valid java name */
    public /* synthetic */ String m4182lambda$release$4$comssmediakitnetAVMDLDNSParserBridge() {
        return String.format(Locale.US, "----start release:%s", this);
    }

    public void release() {
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParserBridge$$ExternalSyntheticLambda7
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                return AVMDLDNSParserBridge.this.m4182lambda$release$4$comssmediakitnetAVMDLDNSParserBridge();
            }
        });
        this.lock.lock();
        try {
            this.handle = 0L;
            this.lock.unlock();
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParserBridge$$ExternalSyntheticLambda8
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    return AVMDLDNSParserBridge.this.m4183lambda$release$5$comssmediakitnetAVMDLDNSParserBridge();
                }
            });
            AVMDLDNSParser.getInstance().removeHost(this.host, this);
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParserBridge$$ExternalSyntheticLambda9
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    return AVMDLDNSParserBridge.this.m4184lambda$release$6$comssmediakitnetAVMDLDNSParserBridge();
                }
            });
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$release$5$com-ss-mediakit-net-AVMDLDNSParserBridge, reason: not valid java name */
    public /* synthetic */ String m4183lambda$release$5$comssmediakitnetAVMDLDNSParserBridge() {
        return String.format(Locale.US, "remove host:%s", this.host);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$release$6$com-ss-mediakit-net-AVMDLDNSParserBridge, reason: not valid java name */
    public /* synthetic */ String m4184lambda$release$6$comssmediakitnetAVMDLDNSParserBridge() {
        return String.format(Locale.US, "****end call release:%s", this);
    }

    @Override // com.ss.mediakit.net.AVMDLDNSParserListener
    public void onCompletion(int i, String str, String str2, long j, String str3, int i2) {
        if (!this.isFinish && v2Usable) {
            parserResult(i, str, str2, j, str3, i2, 2);
        }
        if (this.isFinish) {
            return;
        }
        parserResult(i, str, str2, j, str3, i2, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parserResult(final int i, String str, final String str2, final long j, String str3, int i2, int i3) {
        final int i4;
        long j2;
        String str4;
        int i5;
        long j3;
        this.lock.lock();
        try {
            try {
                if (!this.isFinish) {
                    if (AVMDLLog.isLogLevelEnabled(1)) {
                        final boolean isEmpty = TextUtils.isEmpty(str2);
                        i4 = i2;
                        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParserBridge$$ExternalSyntheticLambda4
                            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                            public final String get() {
                                return AVMDLDNSParserBridge.lambda$parserResult$7(i, isEmpty, str2, i4);
                            }
                        });
                    } else {
                        i4 = i2;
                    }
                    if (TextUtils.isEmpty(str2) && AVMDLDNSParser.getIntValue(5) == 1) {
                        AVMDLLog.m226d(TAG, "pare result is null, try get backupip");
                        AVMDLDNSInfo backUpIp = IPCache.getInstance().getBackUpIp(str);
                        if (backUpIp != null) {
                            final String str5 = backUpIp.mIpList;
                            final int i6 = backUpIp.mType;
                            if (AVMDLLog.isLogLevelEnabled(1)) {
                                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParserBridge$$ExternalSyntheticLambda5
                                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                                    public final String get() {
                                        String format;
                                        format = String.format(Locale.US, "get backup ip, result:%s type:%d", str5, Integer.valueOf(i6));
                                        return format;
                                    }
                                });
                            }
                            i5 = i6;
                            str4 = str5;
                            j2 = 0;
                            this.ipList = str4;
                            this.isFinish = true;
                            j3 = this.handle;
                            if (j3 != 0) {
                                if (i3 == 2) {
                                    v2Usable = true;
                                    _notifyParserResultV2(j3, str, str4, j2, str3, i5);
                                } else {
                                    v2Usable = false;
                                    _notifyParserResult(j3, str, str4, j2, str3);
                                }
                            }
                        }
                    }
                    j2 = j;
                    str4 = str2;
                    i5 = i4;
                    this.ipList = str4;
                    this.isFinish = true;
                    j3 = this.handle;
                    if (j3 != 0) {
                    }
                } else if (AVMDLLog.isLogLevelEnabled(1)) {
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParserBridge$$ExternalSyntheticLambda6
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "has finished not nedd cur completion code:%d result:%s expiredTime:%d", Integer.valueOf(i), str2, Long.valueOf(j));
                            return format;
                        }
                    });
                }
            } catch (UnsatisfiedLinkError e) {
                AVMDLLog.m226d(TAG, e.toString());
                if (v2Usable) {
                    v2Usable = false;
                }
                this.isFinish = false;
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$parserResult$7(int i, boolean z, String str, int i2) {
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        if (z) {
            str = "null";
        }
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i2);
        return String.format(locale, "receive completion code:%d result:%s type:%d", objArr);
    }
}
