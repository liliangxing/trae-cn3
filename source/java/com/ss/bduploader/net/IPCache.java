package com.ss.bduploader.net;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes7.dex */
public class IPCache {
    private static IPCache mInstance = null;
    private static String mNetExtraInfo = null;
    private static int mNetType = -1;
    private ConcurrentHashMap<String, BDUploadDNSInfo> mDNSRecord = new ConcurrentHashMap<>();
    private Lock lock = new ReentrantLock();

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

    private IPCache() {
    }

    public BDUploadDNSInfo get(String str) {
        this.lock.lock();
        try {
            ConcurrentHashMap<String, BDUploadDNSInfo> concurrentHashMap = this.mDNSRecord;
            return concurrentHashMap != null ? concurrentHashMap.get(str) : null;
        } finally {
            this.lock.unlock();
        }
    }

    public void put(String str, BDUploadDNSInfo bDUploadDNSInfo) {
        this.lock.lock();
        try {
            ConcurrentHashMap<String, BDUploadDNSInfo> concurrentHashMap = this.mDNSRecord;
            if (concurrentHashMap != null) {
                concurrentHashMap.put(str, bDUploadDNSInfo);
            }
        } finally {
            this.lock.unlock();
        }
    }

    public int getRecordSize() {
        this.lock.lock();
        try {
            ConcurrentHashMap<String, BDUploadDNSInfo> concurrentHashMap = this.mDNSRecord;
            return concurrentHashMap != null ? concurrentHashMap.size() : -1;
        } finally {
            this.lock.unlock();
        }
    }

    public void clear() {
        this.lock.lock();
        try {
            ConcurrentHashMap<String, BDUploadDNSInfo> concurrentHashMap = this.mDNSRecord;
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

    public void setCurNetExtraInfo(String str) {
        mNetExtraInfo = str;
    }
}
