package com.ss.ttm.net;

import android.text.TextUtils;
import com.ss.ttm.player.AVThreadPool;
import com.ss.ttm.utils.AVLogger;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class AVResolver {
    public static int HOST_MAX_CACHE_TIME = 600000;
    private static final int MAX_CACHED = 128;
    private static final String TAG = "AVResolver";
    private static final Hashtable<String, HostInfo> mCacheHosts = new Hashtable<>();
    private HostInfo mHostInfo;
    private String mHostName;
    private String[] mIPStr;
    private boolean mRet = false;
    private Thread mThread = null;
    private String mError = null;

    public void getAddressInfo(String hostname) {
        this.mHostName = hostname;
        if (TextUtils.isEmpty(hostname)) {
            AVLogger.d(TAG, "getAddressInfo start.hostname is null:");
            this.mRet = true;
            return;
        }
        AVLogger.d(TAG, "getAddressInfo start.hostname:" + hostname);
        if (isIP(this.mHostName)) {
            AVLogger.d(TAG, "getAddressInfo is ip.ip:" + hostname);
            this.mIPStr = r9;
            String[] strArr = {this.mHostName};
            this.mRet = true;
            return;
        }
        Hashtable<String, HostInfo> hashtable = mCacheHosts;
        HostInfo hostInfo = hashtable.get(hostname);
        this.mHostInfo = hostInfo;
        if (hostInfo != null) {
            AVLogger.d(TAG, "getAddressInfo first find in cache.hostname:" + hostname);
            if (this.mHostInfo.ip != null && System.currentTimeMillis() - this.mHostInfo.time < HOST_MAX_CACHE_TIME) {
                this.mIPStr = r9;
                String[] strArr2 = {this.mHostInfo.ip};
                this.mRet = true;
                AVLogger.d(TAG, "getAddressInfo hit cached:ip:" + this.mHostInfo.ip + ",time:" + this.mHostInfo.time);
                return;
            }
            AVLogger.d(TAG, "getAddressInfo cache is to long.hostname:" + hostname);
            hashtable.remove(hostname);
            this.mHostInfo = null;
        }
        try {
            AVThreadPool.addTask(new ParserHost(this, this.mHostName));
        } catch (Exception e) {
            this.mRet = true;
            this.mError = e.getMessage();
        }
    }

    public int isSuccess() {
        if (!this.mRet) {
            return 0;
        }
        String[] strArr = this.mIPStr;
        return (strArr == null || strArr[0] == null) ? -1 : 1;
    }

    public String getAddress() {
        String[] strArr;
        if (this.mRet && (strArr = this.mIPStr) != null && strArr[0] != null) {
            AVLogger.d(TAG, "getAddress return ip:" + this.mIPStr[0]);
            return this.mIPStr[0];
        }
        return "parser host name: " + this.mHostName + " error.err msg:" + this.mError;
    }

    public void freeAddress() {
        AVLogger.d(TAG, "free address ctx start");
        if (this.mThread != null) {
            AVLogger.d(TAG, "mthread not null");
            try {
                this.mThread.interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class HostInfo {
        public String ip;
        public long time;

        HostInfo() {
        }
    }

    /* loaded from: classes7.dex */
    static class ParserHost implements Runnable {
        String mHostName;
        AVResolver mResolver;

        public ParserHost(AVResolver resolver, String hostName) {
            this.mResolver = resolver;
            this.mHostName = hostName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            InetAddress byName;
            AVLogger.d(AVResolver.TAG, "start ParserHost task");
            String str3 = null;
            try {
                AVLogger.d(AVResolver.TAG, "getAddressInfo thread start");
                byName = InetAddress.getByName(this.mHostName);
            } catch (Throwable th) {
                th = th;
                str = null;
            }
            try {
                str3 = byName.getHostAddress();
                AVLogger.d(AVResolver.TAG, "getAddressInfo thread ok");
                str2 = byName;
            } catch (Throwable th2) {
                th = th2;
                str = str3;
                str3 = byName;
                th.printStackTrace();
                this.mResolver.mError = th.getMessage();
                AVLogger.d(AVResolver.TAG, "getAddressInfo thread error");
                String str4 = str;
                str2 = str3;
                str3 = str4;
                this.mResolver.mRet = true;
                if (str2 != null) {
                    return;
                } else {
                    return;
                }
            }
            this.mResolver.mRet = true;
            if (str2 != null || str3 == null) {
                return;
            }
            this.mResolver.mIPStr = new String[1];
            this.mResolver.mIPStr[0] = str3;
            HostInfo hostInfo = new HostInfo();
            hostInfo.time = System.currentTimeMillis();
            hostInfo.ip = str3;
            AVResolver.putHostInfo(this.mHostName, hostInfo);
            hostInfo.time = System.currentTimeMillis();
        }
    }

    static synchronized void putHostInfo(String str, HostInfo hostInfo) {
        String str2;
        synchronized (AVResolver.class) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Hashtable<String, HostInfo> hashtable = mCacheHosts;
                HostInfo hostInfo2 = null;
                String str3 = null;
                if (hashtable.size() > 128) {
                    Iterator<Map.Entry<String, HostInfo>> it = hashtable.entrySet().iterator();
                    HostInfo hostInfo3 = null;
                    while (it.hasNext()) {
                        HostInfo value = it.next().getValue();
                        str3 = it.next().getKey();
                        if (value != null && value.time < currentTimeMillis) {
                            currentTimeMillis = value.time;
                            hostInfo3 = value;
                        }
                    }
                    str2 = str3;
                    hostInfo2 = hostInfo3;
                } else {
                    str2 = null;
                }
                if (hostInfo2 != null && str2 != null) {
                    AVLogger.d(TAG, "putHostInfo remove host cache" + hostInfo2.ip);
                    mCacheHosts.remove(str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
                AVLogger.d(TAG, "putHostInfo remove host cache error");
            }
            mCacheHosts.put(str, hostInfo);
        }
    }

    public static final boolean isIP(String addr) {
        if (addr.length() < 7 || addr.length() > 15) {
            return addr.charAt(0) == '[' && addr.charAt(addr.length() - 1) == ']';
        }
        try {
            return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(addr).find();
        } catch (Exception e) {
            e.printStackTrace();
            AVLogger.d(TAG, "ip match error");
            return false;
        }
    }
}
