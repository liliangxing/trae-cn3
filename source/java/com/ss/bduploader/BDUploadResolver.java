package com.ss.bduploader;

import com.ss.bduploader.net.BDUploadDNSInfo;
import com.ss.bduploader.net.BDUploadDNSParser;
import com.ss.bduploader.net.BDUploadDNSParserListener;
import com.ss.bduploader.net.BDUploadThreadPool;
import com.ss.bduploader.net.HTTPDNS;
import com.ss.bduploader.net.IPCache;
import com.xiaomi.mipush.sdk.Constants;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BDUploadResolver implements BDUploadDNSParserListener {
    public static final int DNS_TYPE_IS_VERSION_1 = 1;
    public static final int DNS_TYPE_IS_VERSION_2 = 2;
    public static int HOST_MAX_CACHE_TIME = 60000;
    private static final int MAX_CACHED = 128;
    private static final String TAG = "BDUploadResolver";
    public static volatile int mDNSVersion = 1;
    public static volatile int mIsUseTTnetDNS;
    private String mError;
    private HostInfo mHostInfo;
    private volatile String mHostName;
    private volatile String[] mIPStr;
    private static final Hashtable<String, HostInfo> mCacheHosts = new Hashtable<>();
    private static int mEnableThreadPool = 1;
    private volatile boolean mRet = false;
    private Thread mThread = null;
    private Future mFuture = null;
    private int mUseDNSType = mDNSVersion;

    private native void _notifyParserResult(String str, String str2, long j, String str3);

    public static void setEnableDNSParserThreadPool(int i) {
        mEnableThreadPool = i;
    }

    public static void setEnableTTNetDNS(int i) {
        mIsUseTTnetDNS = i;
    }

    public static void setDNSType(int i, int i2, int i3, int i4, int i5) {
        if (i == 1 || i == 2) {
            BDUploadDNSParser.setIntValue(0, i2);
            BDUploadDNSParser.setIntValue(1, i3);
            BDUploadDNSParser.setIntValue(3, i4);
            BDUploadDNSParser.setIntValue(2, i5);
            mDNSVersion = i;
        }
    }

    public static void setDNSServer(String str, String str2) {
        HTTPDNS.setDNSServerHost(str, str2);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008f -> B:26:0x009a). Please report as a decompilation issue!!! */
    private void getAddressInfoVersion_1(String str) {
        this.mHostName = str;
        if (str != null && str.length() >= 1 && !"".equals(str)) {
            if (isIP(this.mHostName)) {
                this.mIPStr = new String[1];
                this.mIPStr[0] = this.mHostName;
                this.mRet = true;
                return;
            }
            Hashtable<String, HostInfo> hashtable = mCacheHosts;
            HostInfo hostInfo = hashtable.get(str);
            this.mHostInfo = hostInfo;
            if (hostInfo != null) {
                if (hostInfo.f84ip != null && System.currentTimeMillis() - this.mHostInfo.time < HOST_MAX_CACHE_TIME) {
                    this.mIPStr = new String[1];
                    this.mIPStr[0] = this.mHostInfo.f84ip;
                    this.mRet = true;
                    return;
                }
                hashtable.remove(str);
                this.mHostInfo = null;
            }
            try {
                if (mEnableThreadPool > 0) {
                    BDUploadLog.m161d(TAG, "----enable dns parser thread pool");
                    this.mFuture = BDUploadThreadPool.addExecuteTask(new ParserHost(this, this.mHostName));
                } else {
                    BDUploadLog.m161d(TAG, "----disable dns parser thread pool");
                    Thread thread = new Thread(new ParserHost(this, this.mHostName));
                    this.mThread = thread;
                    thread.start();
                }
            } catch (Exception e) {
                this.mRet = true;
                this.mError = e.getMessage();
            }
            return;
        }
        this.mRet = true;
    }

    private void getAddressInfoVersion_2(String str) {
        BDUploadLog.m161d(TAG, "----add host to parser");
        this.mHostName = str;
        BDUploadDNSInfo bDUploadDNSInfo = IPCache.getInstance().get(str);
        if (bDUploadDNSInfo != null && bDUploadDNSInfo.mIpList != null) {
            long currentTimeMillis = System.currentTimeMillis();
            BDUploadLog.m161d(TAG, String.format("get result from cache expiredT:%d curT:%d ", Long.valueOf(bDUploadDNSInfo.mExpiredTime), Long.valueOf(currentTimeMillis)));
            if (bDUploadDNSInfo.mExpiredTime <= currentTimeMillis) {
                BDUploadLog.m161d(TAG, String.format("has expired try call parse:", new Object[0]));
                BDUploadDNSParser.getInstance().addHost(str, null);
            }
            String[] split = bDUploadDNSInfo.mIpList.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split != null && split.length > 0) {
                this.mIPStr = new String[1];
                this.mIPStr[0] = split[0];
                this.mRet = true;
                BDUploadLog.m161d(TAG, String.format("get result from cache suc, ip:%s ", split[0]));
            }
        }
        if (this.mRet) {
            return;
        }
        BDUploadLog.m161d(TAG, "****add host to parser");
        BDUploadDNSParser.getInstance().addHost(str, this);
    }

    @Override // com.ss.bduploader.net.BDUploadDNSParserListener
    public void onCompletion(int i, String str, String str2, long j, String str3) {
        String[] split;
        BDUploadLog.m161d(TAG, String.format("notify result host:%s iplist:%s ", str, str2));
        if (this.mRet) {
            return;
        }
        if (str2 != null && str != null && str.equals(this.mHostName) && (split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length > 0) {
            this.mIPStr = new String[1];
            this.mIPStr[0] = split[0];
        }
        this.mRet = true;
    }

    public void getAddressInfo(String str) {
        int i = this.mUseDNSType;
        if (i == 1) {
            getAddressInfoVersion_1(str);
        } else if (i == 2) {
            getAddressInfoVersion_2(str);
        } else {
            getAddressInfoVersion_1(str);
        }
    }

    public int isSuccess() {
        if (this.mRet) {
            return (this.mIPStr == null || this.mIPStr[0] == null) ? -1 : 1;
        }
        return 0;
    }

    public String getAddress() {
        if (!this.mRet || this.mIPStr == null || this.mIPStr[0] == null) {
            return null;
        }
        return this.mIPStr[0];
    }

    public void freeAddress() {
        if (this.mUseDNSType == 1) {
            Future future = this.mFuture;
            if (future != null) {
                try {
                    future.cancel(true);
                    this.mFuture = null;
                    BDUploadLog.m161d(TAG, "----cancel parser thread");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Thread thread = this.mThread;
            if (thread != null) {
                try {
                    thread.interrupt();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (this.mUseDNSType == 2) {
            try {
                BDUploadDNSParser.getInstance().removeHost(this.mHostName, this);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static synchronized void putHostInfo(String str, HostInfo hostInfo) {
        String str2;
        synchronized (BDUploadResolver.class) {
            long currentTimeMillis = System.currentTimeMillis();
            Hashtable<String, HostInfo> hashtable = mCacheHosts;
            String str3 = null;
            if (hashtable.size() > 128) {
                Iterator<Map.Entry<String, HostInfo>> it = hashtable.entrySet().iterator();
                String str4 = null;
                while (it.hasNext()) {
                    HostInfo value = it.next().getValue();
                    str3 = it.next().getKey();
                    if (value != 0 && value.time < currentTimeMillis) {
                        currentTimeMillis = value.time;
                        str4 = value;
                    }
                }
                str2 = str3;
                str3 = str4;
            } else {
                str2 = null;
            }
            if (str3 != null && str2 != null) {
                mCacheHosts.remove(str2);
            }
            mCacheHosts.put(str, hostInfo);
        }
    }

    public static final boolean isIP(String str) {
        try {
            if (str.length() < 7 || str.length() > 15) {
                return str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']';
            }
            return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ParserHost implements Runnable {
        String mHostName;
        BDUploadResolver mResolver;

        public ParserHost(BDUploadResolver bDUploadResolver, String str) {
            this.mResolver = bDUploadResolver;
            this.mHostName = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:6:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x006c  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            List<InetAddress> dnsLookup;
            boolean z;
            InetAddress inetAddress = null;
            if (BDUploadResolver.mIsUseTTnetDNS == 1) {
                try {
                    dnsLookup = TTNetWrapper.dnsLookup(this.mHostName);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (dnsLookup != null && dnsLookup.get(0) != null) {
                    inetAddress = dnsLookup.get(0);
                    z = true;
                    if (!z) {
                        try {
                            inetAddress = InetAddress.getByName(this.mHostName);
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                            this.mResolver.mError = e.getMessage();
                        }
                    }
                    if (inetAddress != null) {
                        this.mResolver.mRet = true;
                        return;
                    }
                    String hostAddress = inetAddress.getHostAddress();
                    this.mResolver.mIPStr = new String[1];
                    this.mResolver.mIPStr[0] = hostAddress;
                    HostInfo hostInfo = new HostInfo();
                    hostInfo.time = System.currentTimeMillis();
                    hostInfo.f84ip = hostAddress;
                    BDUploadResolver.putHostInfo(this.mHostName, hostInfo);
                    hostInfo.time = System.currentTimeMillis();
                    this.mResolver.mRet = true;
                    return;
                }
            }
            z = false;
            if (!z) {
            }
            if (inetAddress != null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class HostInfo {

        /* renamed from: ip */
        public String f84ip;
        public long time;

        HostInfo() {
        }
    }
}
