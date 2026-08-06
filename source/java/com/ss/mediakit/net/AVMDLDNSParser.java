package com.ss.mediakit.net;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.Base64;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AVMDLDNSParser {
    public static final int AVMDL_DNS_BACKUP_TYPE = 1;
    public static final int AVMDL_DNS_DEFAULT_EXPIRED_TIME = 2;
    public static final int AVMDL_DNS_DISABLE_PARALLEL_FOR_EXPIRED_CACHE = 11;
    public static final int AVMDL_DNS_ENABLE_BACKUP_IP = 5;
    public static final int AVMDL_DNS_ENABLE_DNS_LOG = 7;
    public static final int AVMDL_DNS_ENABLE_PARALLEL = 4;
    public static final int AVMDL_DNS_ENABLE_REFRESH = 6;
    public static final int AVMDL_DNS_FORCE_EXPIRED_TIME = 10;
    public static final int AVMDL_DNS_GOOGLE_PARSE_HOST = 9;
    public static final int AVMDL_DNS_HTTPDNS_NEED_RANK = 16;
    public static final int AVMDL_DNS_HTTPDNS_NEW_CACHE = 18;
    public static final int AVMDL_DNS_MAIN_DELAYED_USE_BACKUP_FOR_EXPIRED_CACHE_TIME = 12;
    public static final int AVMDL_DNS_MAIN_DELAYED_USE_BACKUP_TIME = 3;
    public static final int AVMDL_DNS_MAIN_TYPE = 0;
    public static final int AVMDL_DNS_OWN_PARSE_HOST = 8;
    public static final int AVMDL_HTTPDNS_ACCOUNT_ID = 13;
    public static final int AVMDL_HTTPDNS_DISABLE_AUTHENTICATION = 17;
    public static final int AVMDL_HTTPDNS_ENABLE_AUTHENTICATION = 15;
    public static final int AVMDL_HTTPDNS_SECRET_KEY = 14;
    public static final int DNS_TYPE_BACKUP_IP = 11;
    public static final int DNS_TYPE_FEED_DNS = 12;
    public static final int DNS_TYPE_HTTP_ALI = 1;
    public static final int DNS_TYPE_HTTP_CUSTOM = 4;
    public static final int DNS_TYPE_HTTP_GOOGLE = 3;
    public static final int DNS_TYPE_HTTP_OWN = 2;
    public static final int DNS_TYPE_HTTP_OWN_HASH = 5;
    public static final int DNS_TYPE_HTTP_SERVER = 10;
    public static final int DNS_TYPE_LOCAL = 0;
    public static final int DNS_TYPE_LOCAL_PRIORITY = 6;
    public static final int PARSER_IS_BACKUP = 1;
    public static final int PARSER_IS_MAIN = 0;
    private static final String TAG = "AVMDLDNSParser";
    public static AVMDLCustomHTTPDNSParser mCustomHttpDNSParser = null;
    public static int mGloabalDisableParallelForExpiredCache = 0;
    public static int mGlobalBackType = 2;
    public static int mGlobalBackUpDelayedTime = 0;
    public static int mGlobalBackUpDelayedTimeForExpiredCache = 0;
    public static int mGlobalDefaultExpiredTime = 60;
    public static int mGlobalDisableAuthentication = 0;
    public static int mGlobalEnableAuthentication = 0;
    public static int mGlobalEnableBackUpIp = 0;
    public static int mGlobalEnableDNSLog = 0;
    public static int mGlobalEnableParallel = 0;
    public static int mGlobalEnableRefresh = 0;
    public static int mGlobalForceExpiredTime = 0;
    public static String mGlobalGoogleDNSParseHost = "";
    public static int mGlobalHTTPDNSNeedRank = 0;
    public static int mGlobalHTTPDNSNewCache = 0;
    public static String mGlobalHttpDNSAccountId = "";
    public static String mGlobalHttpDNSSecretKey = "";
    public static String mGlobalHttpDNSTimeStamp = "2524579199000";
    public static int mGlobalMainType = 0;
    public static String mGlobalOwnDNSParseHost = "";
    private static volatile AVMDLDNSParser mInstance;
    public static AVMDLNetClientMaker mNetClientMaker;
    private Handler mHandler;
    private int mRefCount;
    private int mState;
    private HandlerThread mThread;
    private int mType;
    private int mTimeOut = 5;
    private Lock mLock = new ReentrantLock();
    private Map<String, AVMDLHostProcessor> mProcessors = new HashMap();

    public void release() {
    }

    public static AVMDLDNSParser getInstance() {
        if (mInstance == null) {
            synchronized (AVMDLDNSParser.class) {
                if (mInstance == null) {
                    mInstance = new AVMDLDNSParser();
                }
            }
        }
        return mInstance;
    }

    public static void setIntValue(final int i, final int i2) {
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda41
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "****set value:%d for key:%d", Integer.valueOf(i2), Integer.valueOf(i));
                return format;
            }
        });
        synchronized (AVMDLDNSParser.class) {
            switch (i) {
                case 0:
                    mGlobalMainType = i2;
                    break;
                case 1:
                    mGlobalBackType = i2;
                    break;
                case 2:
                    mGlobalDefaultExpiredTime = i2;
                    break;
                case 3:
                    mGlobalBackUpDelayedTime = i2;
                    break;
                case 4:
                    mGlobalEnableParallel = i2;
                    break;
                case 5:
                    mGlobalEnableBackUpIp = i2;
                    break;
                case 6:
                    mGlobalEnableRefresh = i2;
                    break;
                case 7:
                    mGlobalEnableDNSLog = i2;
                    break;
                case 10:
                    mGlobalForceExpiredTime = i2;
                    break;
                case 11:
                    mGloabalDisableParallelForExpiredCache = i2;
                    break;
                case 12:
                    mGlobalBackUpDelayedTimeForExpiredCache = i2;
                    break;
                case 15:
                    mGlobalEnableAuthentication = i2;
                    break;
                case 16:
                    mGlobalHTTPDNSNeedRank = i2;
                    break;
                case 17:
                    mGlobalDisableAuthentication = i2;
                    break;
                case 18:
                    mGlobalHTTPDNSNewCache = i2;
                    break;
            }
        }
    }

    public static int getIntValue(final int i) {
        final int i2;
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda46
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "----get value for key:%d", Integer.valueOf(i));
                return format;
            }
        });
        synchronized (AVMDLDNSParser.class) {
            switch (i) {
                case 0:
                    i2 = mGlobalMainType;
                    break;
                case 1:
                    i2 = mGlobalBackType;
                    break;
                case 2:
                    i2 = mGlobalDefaultExpiredTime;
                    break;
                case 3:
                    i2 = mGlobalBackUpDelayedTime;
                    break;
                case 4:
                    i2 = mGlobalEnableParallel;
                    break;
                case 5:
                    i2 = mGlobalEnableBackUpIp;
                    break;
                case 6:
                    i2 = mGlobalEnableRefresh;
                    break;
                case 7:
                    i2 = mGlobalEnableDNSLog;
                    break;
                case 8:
                case 9:
                default:
                    i2 = Integer.MIN_VALUE;
                    break;
                case 10:
                    i2 = mGlobalForceExpiredTime;
                    break;
                case 11:
                    i2 = mGloabalDisableParallelForExpiredCache;
                    break;
                case 12:
                    i2 = mGlobalBackUpDelayedTimeForExpiredCache;
                    break;
            }
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda47
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "****get value:%d for key:%d", Integer.valueOf(i2), Integer.valueOf(i));
                return format;
            }
        });
        return i2;
    }

    public static void setStringValue(final int i, final String str) {
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda32
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "****set value:%s for key:%d", str, Integer.valueOf(i));
                return format;
            }
        });
        synchronized (AVMDLDNSParser.class) {
            if (i != 8) {
                if (i != 9) {
                    if (i != 13) {
                        if (i == 14 && !TextUtils.isEmpty(str)) {
                            mGlobalHttpDNSSecretKey = decodeBase64(str);
                        }
                    } else if (!TextUtils.isEmpty(str)) {
                        mGlobalHttpDNSAccountId = str;
                    }
                } else if (!TextUtils.isEmpty(str)) {
                    mGlobalGoogleDNSParseHost = str;
                }
            } else if (!TextUtils.isEmpty(str)) {
                mGlobalOwnDNSParseHost = str;
            }
        }
    }

    public static void processHijack() {
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda43
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "----process hijack old dnsmain:%d back:%d", Integer.valueOf(AVMDLDNSParser.mGlobalMainType), Integer.valueOf(AVMDLDNSParser.mGlobalBackType));
                return format;
            }
        });
        int i = mGlobalMainType;
        if (i == 0) {
            mGlobalMainType = mGlobalBackType;
            mGlobalBackType = i;
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda45
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "****process hijack new dnsmain:%d back:%d", Integer.valueOf(AVMDLDNSParser.mGlobalMainType), Integer.valueOf(AVMDLDNSParser.mGlobalBackType));
                return format;
            }
        });
    }

    public static void updateDNSInfo(String str, String str2, long j) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AVMDLLog.m226d(TAG, "ip direct info invalid");
            return;
        }
        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(10, str, str2, (j + mGlobalDefaultExpiredTime) * 1000, (String) null, -1);
        AVMDLLog.m226d(TAG, "server iplist, host = " + str + " type = 10 iplist = " + str2);
        IPCache.getInstance().put(str, aVMDLDNSInfo);
    }

    public static void updateFeedDNS(String str, String str2, long j) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AVMDLLog.m226d(TAG, "input host or ipList is empty");
            return;
        }
        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(12, str, str2, j, (String) null, -1);
        AVMDLLog.m226d(TAG, "feed iplist, host = " + str + " type = 12 iplist = " + str2);
        IPCache.getInstance().put(str, aVMDLDNSInfo);
    }

    public AVMDLDNSParser() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mThread = handlerThread;
        handlerThread.start();
        this.mHandler = new HandlerC09361(this.mThread.getLooper());
    }

    /* renamed from: com.ss.mediakit.net.AVMDLDNSParser$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class HandlerC09361 extends Handler {
        HandlerC09361(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            final AVMDLDNSInfo aVMDLDNSInfo = message.obj != null ? (AVMDLDNSInfo) message.obj : null;
            if (AVMDLLog.isLogLevelEnabled(1)) {
                final int i = message.what;
                AVMDLLog.m225d(AVMDLDNSParser.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$1$$ExternalSyntheticLambda0
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "----receive msg what:%d info:%s", Integer.valueOf(i), aVMDLDNSInfo);
                        return format;
                    }
                });
            }
            int i2 = message.what;
            if (i2 == 2) {
                AVMDLDNSParser.this.proccessFailMsg(message.what, aVMDLDNSInfo);
            } else if (i2 == 3) {
                AVMDLDNSParser.this.proccessSucMsg(message.what, aVMDLDNSInfo);
            } else if (i2 == 4) {
                AVMDLDNSParser.this.proccessPreParseMsg(message.what, aVMDLDNSInfo);
            } else if (i2 == 6) {
                AVMDLDNSParser.this.processBackupParseMsg(message.what, aVMDLDNSInfo);
            } else if (i2 == 7) {
                AVMDLDNSParser.this.processBatchParseMsg(message.what, aVMDLDNSInfo);
            } else if (i2 == 8) {
                AVMDLDNSParser.this.processDNSTypeChangedParseMsg(message.what, aVMDLDNSInfo);
            }
            if (AVMDLLog.isLogLevelEnabled(1)) {
                final int i3 = message.what;
                AVMDLLog.m225d(AVMDLDNSParser.TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$1$$ExternalSyntheticLambda1
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "****end proc msg what:%d info:%s", Integer.valueOf(i3), aVMDLDNSInfo);
                        return format;
                    }
                });
            }
        }
    }

    public static void setClientMaker(AVMDLNetClientMaker aVMDLNetClientMaker) {
        synchronized (AVMDLDNSParser.class) {
            if (aVMDLNetClientMaker != null) {
                mNetClientMaker = aVMDLNetClientMaker;
            }
        }
    }

    public static void setCustomHttpDNSParser(final AVMDLCustomHTTPDNSParser aVMDLCustomHTTPDNSParser) {
        synchronized (AVMDLDNSParser.class) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda13
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    return AVMDLDNSParser.lambda$setCustomHttpDNSParser$6(AVMDLCustomHTTPDNSParser.this);
                }
            });
            if (aVMDLCustomHTTPDNSParser != null) {
                mCustomHttpDNSParser = aVMDLCustomHTTPDNSParser;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$setCustomHttpDNSParser$6(AVMDLCustomHTTPDNSParser aVMDLCustomHTTPDNSParser) {
        Locale locale = Locale.US;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(aVMDLCustomHTTPDNSParser == null ? 0 : 1);
        return String.format(locale, "set custom http dns parser:%d", objArr);
    }

    public static AVMDLNetClient getNetClient() {
        AVMDLNetClient netClient;
        synchronized (AVMDLDNSParser.class) {
            AVMDLNetClientMaker aVMDLNetClientMaker = mNetClientMaker;
            netClient = aVMDLNetClientMaker != null ? aVMDLNetClientMaker.getNetClient() : null;
        }
        return netClient == null ? new AVMDLHTTPNetwork() : netClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processBackupParseMsg(final int i, final AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHost == null) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda48
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "proc parser msg  fail, info or host is null", new Object[0]);
                    return format;
                }
            });
            return;
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda49
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "----proc parser msg what:%d host:%s", Integer.valueOf(i), aVMDLDNSInfo.mHost);
                return format;
            }
        });
        this.mLock.lock();
        try {
            final AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(aVMDLDNSInfo.mHost);
            if (aVMDLHostProcessor != null) {
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda50
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "----get processor:%s host:%s", AVMDLHostProcessor.this, aVMDLDNSInfo.mHost);
                        return format;
                    }
                });
                aVMDLHostProcessor.processMsg(i, aVMDLDNSInfo);
            } else {
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda1
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "****get processor null for host:%s", AVMDLDNSInfo.this.mHost);
                        return format;
                    }
                });
            }
            this.mLock.unlock();
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda2
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****end proc parser msg", new Object[0]);
                    return format;
                }
            });
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processBatchParseMsg(final int i, AVMDLDNSInfo aVMDLDNSInfo) {
        int i2;
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHosts == null || aVMDLDNSInfo.mHosts.length == 0) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda3
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "proc parser msg  fail, info or host is null", new Object[0]);
                    return format;
                }
            });
            return;
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda4
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "----proc batch parse msg what:%d", Integer.valueOf(i));
                return format;
            }
        });
        if (mGlobalEnableParallel > 0 || (i2 = mGlobalMainType) == 2 || i2 == 5) {
            try {
                new HTTPDNSHosts(aVMDLDNSInfo.mHosts, null, mGlobalMainType == 5 ? 5 : 2, this.mHandler).start();
                return;
            } catch (Exception e) {
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda5
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "parse end create httpdnshosts fail" + e, new Object[0]);
                        return format;
                    }
                });
                return;
            }
        }
        new LocalDNSHosts(aVMDLDNSInfo.mHosts, this.mHandler).start();
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda6
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "****end proc batch parser msg", new Object[0]);
                return format;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proccessSucMsg(final int i, final AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHost == null) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda25
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "proc suc msg  fail, info or host is null", new Object[0]);
                    return format;
                }
            });
            return;
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda26
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "----proc suc msg what:%d host:%s", Integer.valueOf(i), aVMDLDNSInfo.mHost);
                return format;
            }
        });
        this.mLock.lock();
        try {
            final AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(aVMDLDNSInfo.mHost);
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda27
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "get processor:%s host:%s", AVMDLHostProcessor.this, aVMDLDNSInfo.mHost);
                    return format;
                }
            });
            if (aVMDLHostProcessor != null && aVMDLHostProcessor.mListeners != null) {
                for (final AVMDLDNSParserListener aVMDLDNSParserListener : aVMDLHostProcessor.mListeners.keySet()) {
                    if (aVMDLDNSParserListener != null) {
                        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda28
                            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                            public final String get() {
                                String format;
                                format = String.format(Locale.US, "listener:%s oncompletion suc", AVMDLDNSParserListener.this);
                                return format;
                            }
                        });
                        aVMDLDNSParserListener.onCompletion(0, aVMDLDNSInfo.mHost, aVMDLDNSInfo.mIpList, aVMDLDNSInfo.mExpiredTime, aVMDLDNSInfo.mExtraInfo, aVMDLDNSInfo.mType);
                    }
                }
                aVMDLHostProcessor.mListeners.clear();
                this.mProcessors.remove(aVMDLDNSInfo.mHost);
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda29
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "remove all listeners and remove host", new Object[0]);
                        return format;
                    }
                });
            }
            sendPreParseMsg(aVMDLDNSInfo.mType, aVMDLDNSInfo.mHost, aVMDLDNSInfo.mExpiredTime - System.currentTimeMillis(), aVMDLDNSInfo.mTaskType);
            reportLog(aVMDLDNSInfo);
            this.mLock.unlock();
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda30
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****end proc suc msg", new Object[0]);
                    return format;
                }
            });
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDNSTypeChangedParseMsg(final int i, final AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHost == null) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda0
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "proc main parse msg  fail, info or host is null", new Object[0]);
                    return format;
                }
            });
            return;
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda11
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "----proc dnstype change parse msg what:%d host:%s", Integer.valueOf(i), aVMDLDNSInfo.mHost);
                return format;
            }
        });
        this.mLock.lock();
        try {
            getInstance().addHost(aVMDLDNSInfo.mHost, null, aVMDLDNSInfo.mType, aVMDLDNSInfo.mTaskType);
            this.mLock.unlock();
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda22
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****end proc main parse msg", new Object[0]);
                    return format;
                }
            });
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    private void reportLog(AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || TextUtils.isEmpty(aVMDLDNSInfo.mIpList) || mGlobalEnableDNSLog <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FrescoMonitorConst.LOG_TYPE, "mdl_dns_log");
            jSONObject.put("dns_type", aVMDLDNSInfo.mType);
            jSONObject.put("ip_list", aVMDLDNSInfo.mIpList);
            AVMDLDataLoader.getInstance().onLogInfo(15, 0, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proccessPreParseMsg(final int i, final AVMDLDNSInfo aVMDLDNSInfo) {
        if (mGlobalEnableRefresh <= 0) {
            AVMDLLog.m226d(TAG, "not support preparse");
            return;
        }
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHost == null) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda14
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "proc pre msg  fail, info or host is null", new Object[0]);
                    return format;
                }
            });
            return;
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda15
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "----proc pre parse msg what:%d host:%s", Integer.valueOf(i), aVMDLDNSInfo.mHost);
                return format;
            }
        });
        final AVMDLDNSInfo aVMDLDNSInfo2 = IPCache.getInstance().get(aVMDLDNSInfo.mHost);
        long currentTimeMillis = System.currentTimeMillis();
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda16
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                return AVMDLDNSParser.lambda$proccessPreParseMsg$27(AVMDLDNSInfo.this);
            }
        });
        if (aVMDLDNSInfo2 == null || aVMDLDNSInfo2.mExpiredTime < currentTimeMillis) {
            AVMDLLog.m226d(TAG, "add host for preparse");
            addListenerInternal(aVMDLDNSInfo.mHost, null, aVMDLDNSInfo.mType, aVMDLDNSInfo.mTaskType);
        }
        AVMDLLog.m226d(TAG, "****proc pre parse msg what:%d host:%s");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$proccessPreParseMsg$27(AVMDLDNSInfo aVMDLDNSInfo) {
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = aVMDLDNSInfo;
        objArr[1] = Long.valueOf(aVMDLDNSInfo == null ? -1L : aVMDLDNSInfo.mExpiredTime);
        return String.format(locale, "cache:%s expiredT:%d", objArr);
    }

    private void sendPreParseMsg(int i, String str, final long j, int i2) {
        if (TextUtils.isEmpty(str) || j <= 0) {
            AVMDLLog.m226d(TAG, "host is null or delayTimeMs invalid,not support preparse");
            return;
        }
        if (mGlobalEnableRefresh > 0) {
            final AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(i, str, (String) null, 0L, (String) null, i2);
            Message message = new Message();
            message.obj = aVMDLDNSInfo;
            message.what = 4;
            message.obj = aVMDLDNSInfo;
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda42
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "send preparse for host:%s delayTime:%d", AVMDLDNSInfo.this.mHost, Long.valueOf(j + 3000));
                    return format;
                }
            });
            this.mHandler.sendMessageDelayed(message, j + 3000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proccessFailMsg(final int i, final AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHost == null) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda34
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "proc fail msg  fail, info or host is null", new Object[0]);
                    return format;
                }
            });
            return;
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda35
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "----proc fail msg what:%d host:%s", Integer.valueOf(i), aVMDLDNSInfo.mHost);
                return format;
            }
        });
        this.mLock.lock();
        try {
            final AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(aVMDLDNSInfo.mHost);
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda36
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "get processor:%s host:%s", AVMDLHostProcessor.this, aVMDLDNSInfo.mHost);
                    return format;
                }
            });
            if (aVMDLHostProcessor != null && aVMDLHostProcessor.isValidSourceId(aVMDLDNSInfo.mId)) {
                aVMDLHostProcessor.processResult(i, aVMDLDNSInfo);
                if (aVMDLHostProcessor.isEnd()) {
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda37
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "processor end, notify result", new Object[0]);
                            return format;
                        }
                    });
                    for (final AVMDLDNSParserListener aVMDLDNSParserListener : aVMDLHostProcessor.mListeners.keySet()) {
                        if (aVMDLDNSParserListener != null) {
                            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda38
                                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                                public final String get() {
                                    String format;
                                    format = String.format(Locale.US, "listener:%s oncompletion fail", AVMDLDNSParserListener.this);
                                    return format;
                                }
                            });
                            aVMDLDNSParserListener.onCompletion(0, aVMDLDNSInfo.mHost, null, 0L, null, aVMDLDNSInfo.mType);
                        }
                    }
                    aVMDLHostProcessor.mListeners.clear();
                    this.mProcessors.remove(aVMDLDNSInfo.mHost);
                } else {
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda39
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "processor is not end", new Object[0]);
                            return format;
                        }
                    });
                }
            }
            this.mLock.unlock();
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda40
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****end proc fail msg what", new Object[0]);
                    return format;
                }
            });
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public void addHost(String str, AVMDLDNSParserListener aVMDLDNSParserListener, int i, int i2) {
        addListenerInternal(str, aVMDLDNSParserListener, i, i2);
    }

    public void removeHost(String str, AVMDLDNSParserListener aVMDLDNSParserListener) {
        removeListenerInternal(str, aVMDLDNSParserListener);
    }

    public void postParseHostMsg(String str, int i, int i2) {
        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(i, str, (String) null, 0L, (String) null, i2);
        Message message = new Message();
        message.what = 5;
        message.obj = aVMDLDNSInfo;
        this.mHandler.sendMessage(message);
    }

    public void postDNSInfoRefreshMsg(String str, int i) {
        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(i, str, (String) null, 0L, (String) null, -1);
        Message message = new Message();
        message.what = 8;
        message.obj = aVMDLDNSInfo;
        this.mHandler.sendMessage(message);
    }

    public void doParseHosts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            AVMDLLog.m226d(TAG, "hosts is null, not need do batch host parse");
            return;
        }
        int length = strArr.length;
        for (int i = 0; i < strArr.length; i++) {
            if (!TextUtils.isEmpty(strArr[i])) {
                if (IPCache.getInstance().get(strArr[i]) != null) {
                    if (AVMDLLog.isLogLevelEnabled(1)) {
                        final String str = strArr[i];
                        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda33
                            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                            public final String get() {
                                String format;
                                format = String.format(Locale.US, "for host:%s has dns info not need do batch parse", str);
                                return format;
                            }
                        });
                    }
                    strArr[i] = null;
                    length--;
                } else {
                    this.mLock.lock();
                    try {
                        if (this.mProcessors.get(strArr[i]) != null) {
                            if (AVMDLLog.isLogLevelEnabled(1)) {
                                final String str2 = strArr[i];
                                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda44
                                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                                    public final String get() {
                                        String format;
                                        format = String.format(Locale.US, "for host:%s has processor not need do batch parse", str2);
                                        return format;
                                    }
                                });
                            }
                            strArr[i] = null;
                            length--;
                        }
                    } finally {
                        this.mLock.unlock();
                    }
                }
            }
        }
        if (length == 0) {
            AVMDLLog.m226d(TAG, "has no hosts need do batch parse");
        } else {
            sendBatchParseMsg(strArr);
        }
    }

    public void setBackUpIP(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        IPCache.getInstance().putBackUpIp(str, new AVMDLDNSInfo(11, str, str2, 0L, (String) null, -1));
    }

    private void sendBatchParseMsg(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            AVMDLLog.m226d(TAG, "hosts null not need do batch parse");
            return;
        }
        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(mGlobalMainType, strArr, (String) null, 0L, (String) null, -1);
        Message message = new Message();
        message.what = 7;
        message.obj = aVMDLDNSInfo;
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda31
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "send msg for batch parse", new Object[0]);
                return format;
            }
        });
        this.mHandler.sendMessage(message);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[Catch: all -> 0x00cf, TryCatch #0 {all -> 0x00cf, blocks: (B:7:0x001e, B:16:0x004d, B:18:0x0058, B:20:0x0077, B:22:0x007f, B:23:0x0090, B:25:0x0097, B:28:0x00b4, B:29:0x00ba, B:30:0x00be), top: B:6:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097 A[Catch: all -> 0x00cf, TryCatch #0 {all -> 0x00cf, blocks: (B:7:0x001e, B:16:0x004d, B:18:0x0058, B:20:0x0077, B:22:0x007f, B:23:0x0090, B:25:0x0097, B:28:0x00b4, B:29:0x00ba, B:30:0x00be), top: B:6:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void addListenerInternal(final String str, final AVMDLDNSParserListener aVMDLDNSParserListener, final int i, int i2) {
        final int i3;
        int i4;
        final int i5;
        final AVMDLHostProcessor aVMDLHostProcessor;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda17
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "---add listener:%s for host:%s dnstype:%d", AVMDLDNSParserListener.this, str, Integer.valueOf(i));
                return format;
            }
        });
        this.mLock.lock();
        try {
            final AVMDLHostProcessor aVMDLHostProcessor2 = this.mProcessors.get(str);
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda18
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "get processor:%s", AVMDLHostProcessor.this);
                    return format;
                }
            });
            int i6 = mGlobalMainType;
            int i7 = mGlobalBackType;
            int i8 = mGlobalEnableParallel;
            boolean z = false;
            if (i != 2 && i != 3 && i != 5) {
                if (i == 6) {
                    i3 = i;
                    i5 = 2;
                    i4 = 0;
                } else {
                    i3 = i6;
                    i4 = i8;
                    i5 = i7;
                }
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda19
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "mainType:%d backType:%d", Integer.valueOf(i3), Integer.valueOf(i5));
                        return format;
                    }
                });
                if (aVMDLHostProcessor2 != null) {
                    aVMDLHostProcessor = new AVMDLHostProcessor(str, this.mHandler, i3, i5, mGlobalBackUpDelayedTime, i4, mGlobalBackUpDelayedTimeForExpiredCache);
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda20
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "create processor:%s", AVMDLHostProcessor.this);
                            return format;
                        }
                    });
                    z = true;
                } else {
                    aVMDLHostProcessor = aVMDLHostProcessor2;
                }
                if (aVMDLDNSParserListener != null && !aVMDLHostProcessor.mListeners.containsKey(aVMDLDNSParserListener)) {
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda21
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "add listener", new Object[0]);
                            return format;
                        }
                    });
                    aVMDLHostProcessor.mListeners.put(aVMDLDNSParserListener, 1);
                }
                this.mProcessors.put(str, aVMDLHostProcessor);
                if (z) {
                    AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda23
                        @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                        public final String get() {
                            String format;
                            format = String.format(Locale.US, "new processor implement parse", new Object[0]);
                            return format;
                        }
                    });
                    AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(i3, str, (String) null, 0L, (String) null, i2);
                    if (mGloabalDisableParallelForExpiredCache <= 0) {
                        aVMDLHostProcessor.processMsg(5, aVMDLDNSInfo);
                    } else if (aVMDLDNSParserListener == null) {
                        aVMDLHostProcessor.processMsg(9, aVMDLDNSInfo);
                    } else {
                        aVMDLHostProcessor.processMsg(5, aVMDLDNSInfo);
                    }
                }
                this.mLock.unlock();
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda24
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "****end add listener", new Object[0]);
                        return format;
                    }
                });
            }
            i3 = i;
            i4 = i8;
            i5 = 0;
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda19
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "mainType:%d backType:%d", Integer.valueOf(i3), Integer.valueOf(i5));
                    return format;
                }
            });
            if (aVMDLHostProcessor2 != null) {
            }
            if (aVMDLDNSParserListener != null) {
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda21
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "add listener", new Object[0]);
                        return format;
                    }
                });
                aVMDLHostProcessor.mListeners.put(aVMDLDNSParserListener, 1);
            }
            this.mProcessors.put(str, aVMDLHostProcessor);
            if (z) {
            }
            this.mLock.unlock();
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda24
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****end add listener", new Object[0]);
                    return format;
                }
            });
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    private void removeListenerInternal(final String str, final AVMDLDNSParserListener aVMDLDNSParserListener) {
        if (TextUtils.isEmpty(str) || aVMDLDNSParserListener == null) {
            return;
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda7
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "---remove listener:%s for host:%s", AVMDLDNSParserListener.this, str);
                return format;
            }
        });
        this.mLock.lock();
        try {
            final AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(str);
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda8
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "get processor:%s", AVMDLHostProcessor.this);
                    return format;
                }
            });
            if (aVMDLHostProcessor != null) {
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda9
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "remove listener", new Object[0]);
                        return format;
                    }
                });
                aVMDLHostProcessor.mListeners.remove(aVMDLDNSParserListener);
            }
            if (aVMDLHostProcessor != null && aVMDLHostProcessor.mListeners.size() == 0) {
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda10
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "listeners empty for processors", new Object[0]);
                        return format;
                    }
                });
            }
            this.mLock.unlock();
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.AVMDLDNSParser$$ExternalSyntheticLambda12
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "****end remove listener", new Object[0]);
                    return format;
                }
            });
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    private static String decodeBase64(String str) {
        return new String(Base64.getDecoder().decode(str));
    }
}
