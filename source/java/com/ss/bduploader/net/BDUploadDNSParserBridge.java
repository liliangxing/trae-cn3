package com.ss.bduploader.net;

import android.text.TextUtils;
import com.ss.bduploader.BDUploadLog;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BDUploadDNSParserBridge implements BDUploadDNSParserListener {
    private static final String TAG = "BDUploadDNSParserBridge";
    public String host;
    String ipList = null;
    boolean isFinish = false;
    private Lock lock = new ReentrantLock();
    private long handle = 0;

    private static native void _notifyParserResult(long j, String str, String str2, long j2, String str3);

    public int start(long j, String str) {
        BDUploadLog.m161d(TAG, "----start parse host:" + str);
        if (TextUtils.isEmpty(str)) {
            BDUploadLog.m161d(TAG, "****end parse fail for host:" + str);
            return -1;
        }
        this.lock.lock();
        this.handle = j;
        try {
            this.host = str;
            BDUploadDNSInfo bDUploadDNSInfo = IPCache.getInstance().get(str);
            int i = 0;
            if (bDUploadDNSInfo != null) {
                this.ipList = bDUploadDNSInfo.mIpList;
                long currentTimeMillis = System.currentTimeMillis();
                BDUploadLog.m161d(TAG, String.format("get result from cache expiredT:%d curT:%d ", Long.valueOf(bDUploadDNSInfo.mExpiredTime), Long.valueOf(currentTimeMillis)));
                if (bDUploadDNSInfo.mExpiredTime <= currentTimeMillis) {
                    BDUploadLog.m161d(TAG, String.format("has expired try call parse:", new Object[0]));
                    BDUploadDNSParser.getInstance().addHost(str, null);
                }
                long j2 = this.handle;
                if (j2 != 0) {
                    _notifyParserResult(j2, str, this.ipList, bDUploadDNSInfo.mExpiredTime, null);
                }
                i = 1;
            } else {
                BDUploadLog.m161d(TAG, "****add host to parser");
                BDUploadDNSParser.getInstance().addHost(str, this);
            }
            return i;
        } finally {
            this.lock.unlock();
        }
    }

    boolean isFinish() {
        return this.isFinish;
    }

    public String getResult() {
        this.lock.lock();
        try {
            String str = this.ipList;
            this.lock.unlock();
            BDUploadLog.m161d(TAG, "****get result:" + str);
            return str;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public void release() {
        this.lock.lock();
        try {
            this.handle = 0L;
            BDUploadDNSParser.getInstance().removeHost(this.host, this);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.ss.bduploader.net.BDUploadDNSParserListener
    public void onCompletion(int i, String str, String str2, long j, String str3) {
        this.lock.lock();
        try {
            if (this.isFinish) {
                BDUploadLog.m161d(TAG, String.format("has finished not nedd cur completion code:%d result:%s expiredTime:%lld", Integer.valueOf(i), str2, Long.valueOf(j)));
            } else {
                BDUploadLog.m161d(TAG, String.format("receive completion code:%d result:%s", Integer.valueOf(i), str2));
                this.ipList = str2;
                this.isFinish = true;
                long j2 = this.handle;
                if (j2 != 0) {
                    _notifyParserResult(j2, str, str2, j, str3);
                }
            }
        } finally {
            this.lock.unlock();
        }
    }
}
