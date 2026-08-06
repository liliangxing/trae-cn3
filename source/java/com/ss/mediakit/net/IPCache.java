package com.ss.mediakit.net;

import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class IPCache {
    private static final String TAG = "AVMDLIPCache";
    private static volatile IPCache mInstance = null;
    private static String mNetExtraInfo = null;
    private static int mNetType = -1;
    private ConcurrentHashMap<String, AVMDLDNSInfo> mDNSRecord = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, AVMDLDNSInfo> mBackUps = new ConcurrentHashMap<>();
    private Lock lock = new ReentrantLock();
    private Lock backUplock = new ReentrantLock();

    public static IPCache getInstance() {
        if (mInstance == null) {
            synchronized (IPCache.class) {
                if (mInstance == null) {
                    mInstance = new IPCache();
                }
            }
        }
        return mInstance;
    }

    public static void setCurNetExtraInfo(String str) {
        mNetExtraInfo = str;
    }

    private IPCache() {
    }

    public AVMDLDNSInfo get(final String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.lock.lock();
        try {
            ConcurrentHashMap<String, AVMDLDNSInfo> concurrentHashMap = this.mDNSRecord;
            AVMDLDNSInfo aVMDLDNSInfo = concurrentHashMap != null ? concurrentHashMap.get(str) : null;
            if (aVMDLDNSInfo != null && !TextUtils.isEmpty(aVMDLDNSInfo.mIpList) && AVMDLDNSParser.mGlobalEnableBackUpIp > 0) {
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.IPCache$$ExternalSyntheticLambda0
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "enable backup try get backup ip for:%s", str);
                        return format;
                    }
                });
                final AVMDLDNSInfo backUpIp = getBackUpIp(str);
                if (backUpIp != null && !TextUtils.isEmpty(backUpIp.mIpList)) {
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.IPCache$$ExternalSyntheticLambda1
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "succ get backup ip:%s", AVMDLDNSInfo.this.mIpList);
                            return format;
                        }
                    });
                    aVMDLDNSInfo.mIpList += Constants.ACCEPT_TIME_SEPARATOR_SP + backUpIp.mIpList;
                }
            }
            return aVMDLDNSInfo;
        } finally {
            this.lock.unlock();
        }
    }

    public void put(final String str, final AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.lock.lock();
        try {
            ConcurrentHashMap<String, AVMDLDNSInfo> concurrentHashMap = this.mDNSRecord;
            if (concurrentHashMap != null) {
                final AVMDLDNSInfo aVMDLDNSInfo2 = concurrentHashMap.get(str);
                if (AVMDLDNSParser.mGlobalEnableParallel > 0 && aVMDLDNSInfo2 != null && aVMDLDNSInfo.mType == 0 && aVMDLDNSInfo2.mType > aVMDLDNSInfo.mType && aVMDLDNSInfo2.mExpiredTime > System.currentTimeMillis()) {
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.IPCache$$ExternalSyntheticLambda3
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "put for host:%s enable parallel info.type:%d info.expiredT:%d cache.type:%d cache.expiredT:%d curT:%d info can not replace cache", str, Integer.valueOf(r1.mType), Long.valueOf(aVMDLDNSInfo.mExpiredTime), Integer.valueOf(r2.mType), Long.valueOf(aVMDLDNSInfo2.mExpiredTime), Long.valueOf(System.currentTimeMillis()));
                            return format;
                        }
                    });
                    return;
                } else {
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.IPCache$$ExternalSyntheticLambda4
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "put for host:%s type:%d ip:%s", r0.mHost, Integer.valueOf(r0.mType), AVMDLDNSInfo.this.mIpList);
                            return format;
                        }
                    });
                    this.mDNSRecord.put(str, aVMDLDNSInfo);
                }
            }
            this.lock.unlock();
            AVMDLLog.m226d(TAG, "update dns info to native");
            AVMDLDataLoader.getInstance().updateDNSInfo(str, aVMDLDNSInfo.mIpList, aVMDLDNSInfo.mExpiredTime, aVMDLDNSInfo.mExtraInfo, aVMDLDNSInfo.mType);
        } finally {
            this.lock.unlock();
        }
    }

    public int getRecordSize() {
        this.lock.lock();
        try {
            ConcurrentHashMap<String, AVMDLDNSInfo> concurrentHashMap = this.mDNSRecord;
            return concurrentHashMap != null ? concurrentHashMap.size() : -1;
        } finally {
            this.lock.unlock();
        }
    }

    public void clear() {
        this.lock.lock();
        try {
            ConcurrentHashMap<String, AVMDLDNSInfo> concurrentHashMap = this.mDNSRecord;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
        } finally {
            this.lock.unlock();
        }
    }

    public int getCurNetType() {
        return mNetType;
    }

    public void setCurNetType(int i) {
        mNetType = i;
    }

    public String getCurNetExtraInfo() {
        return mNetExtraInfo;
    }

    public void putBackUpIp(String str, final AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.backUplock.lock();
        try {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.IPCache$$ExternalSyntheticLambda2
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "put backupip for host:%s type:%d ip:%s", r0.mHost, Integer.valueOf(r0.mType), AVMDLDNSInfo.this.mIpList);
                    return format;
                }
            });
            this.mBackUps.put(str, aVMDLDNSInfo);
        } finally {
            this.backUplock.unlock();
        }
    }

    public AVMDLDNSInfo getBackUpIp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.backUplock.lock();
        try {
            return this.mBackUps.get(str);
        } finally {
            this.backUplock.unlock();
        }
    }
}
