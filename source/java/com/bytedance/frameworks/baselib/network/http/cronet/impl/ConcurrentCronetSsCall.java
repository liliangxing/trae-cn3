package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.net.Uri;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import coil3.disk.DiskLruCache;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.dispatcher.ApiTask;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.frameworks.baselib.network.dispatcher.RequestQueue;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetSsCallConfig;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.utils.ReflectWrap;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeInfo;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class ConcurrentCronetSsCall extends BaseCronetSsCall implements WeakHandler.IHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String API_SOURCE_5XX_CODE = "tt-api-source-5xx";
    private static final String CANCELED_EXCEPTION_MESSAGE = "request canceled";
    private static final int CANCELED_INTERNAL = -999;
    private static final String CRONET_EXCEPTION_CLASS_NAME = "com.ttnet.org.chromium.net.impl.NetworkExceptionImpl";
    private static final int MSG_API_DELAY = 0;
    private static final int MSG_API_IMMEDIATE = 1;
    private static final String REQUEST_HEADERS_BYPASS_ROUTE_SELECTION = "x-tt-bp-rs";
    private static final String REQUEST_HEADERS_TRANSACTION_ID = "transaction-id";
    private static final String TAG = "ConcurrentCronetSsCall";
    private static final int TIME_DELTA = 1;
    private static boolean mRetryForNot2xxCode;
    private static Class sCronetExceptionCls;
    private boolean mBypassRouteSelectionEnabled;
    private CountDownLatch mCallExecuteLatch;
    private volatile boolean mCleanUpDone;
    private long mConnectTimeInterval;
    private List<ConnectionAttempts> mConnectionAttempts;
    private final Object mConnectionLock;
    private volatile AtomicInteger mCurrentUrlIndex;
    private boolean mEnableRequestReportFix;
    private volatile int mFailedTimes;
    private ConnectionAttempts mFirstAttempt;
    private volatile HttpURLConnection mFirstFailedConnection;
    private volatile BaseHttpRequestInfo mFirstFailedRequestInfo;
    private String mFirstUrl;
    private WeakHandler mHandler;
    private String mOriginUrl;
    private List<HttpURLConnection> mPendingURLConnections;
    private long mRequestMaxWaitTime;
    private String mRsName;
    private String mRuleId;
    private Set<String> mSentHosts;
    private long mTNCRequestMaxWaitTime;
    private String mTransactionId;
    private List<String> mUrlList;
    private volatile HttpURLConnection mWinnerConnection;
    private volatile int mWinnerIndex;
    private volatile BaseHttpRequestInfo mWinnerRequestInfo;
    private static HandlerThread mHandlerThread = new HandlerThread("Concurrent-Handler");
    private static String mCallFailureMessage = null;

    static {
        try {
            sCronetExceptionCls = Class.forName(CRONET_EXCEPTION_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        mHandlerThread.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class ConnectionAttempts {
        String mDomain;
        long mEndTime;
        IOException mException;
        BaseHttpRequestInfo taskRequestInfo;
        int mId = -1;
        long mStartTime = System.currentTimeMillis();
        int mNetError = 0;
        int mResponseCode = -1;
        String mDispatchedHost = "";
        long mDispatchTime = -1;
        Boolean sentAlready = false;
        long mCleanUpTime = -1;

        ConnectionAttempts(String str) {
            this.mDomain = str;
        }

        JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("host", this.mDomain);
                jSONObject.put("start", this.mStartTime);
                jSONObject.put("end", this.mEndTime);
                jSONObject.put("net_error", this.mNetError);
                jSONObject.put("code", this.mResponseCode);
                IOException iOException = this.mException;
                if (iOException != null) {
                    String message = iOException.getMessage();
                    if (!TextUtils.isEmpty(message) && message.length() > 64) {
                        message = message.substring(0, 64);
                    }
                    jSONObject.put("exception", message);
                }
                jSONObject.put("dispatch", this.mDispatchTime);
                jSONObject.put("dpHost", this.mDispatchedHost);
                if (this.sentAlready.booleanValue()) {
                    jSONObject.put("sentAlready", true);
                }
                long j = this.mCleanUpTime;
                if (j > 0) {
                    jSONObject.put("cleanUpTime", j);
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public ConcurrentCronetSsCall(Request request, CronetSsCallConfig.UrlMatchRule urlMatchRule) {
        super(request);
        this.mSentHosts = new CopyOnWriteArraySet();
        this.mFirstUrl = "";
        this.mFirstAttempt = null;
        this.mUrlList = new ArrayList();
        this.mConnectionLock = new Object();
        int i = 0;
        this.mCurrentUrlIndex = new AtomicInteger(0);
        this.mPendingURLConnections = new CopyOnWriteArrayList();
        this.mCleanUpDone = false;
        this.mWinnerConnection = null;
        this.mWinnerIndex = -1;
        this.mWinnerRequestInfo = null;
        this.mFirstFailedConnection = null;
        this.mFirstFailedRequestInfo = null;
        this.mConnectionAttempts = new CopyOnWriteArrayList();
        this.mFailedTimes = 0;
        this.mCallExecuteLatch = new CountDownLatch(1);
        this.mHandler = new WeakHandler(mHandlerThread.getLooper(), this);
        this.mEnableRequestReportFix = false;
        this.mTNCRequestMaxWaitTime = 0L;
        String url = request.getUrl();
        this.mOriginUrl = url;
        Uri parse = Uri.parse(url);
        String scheme = parse.getScheme();
        String str = scheme + "://" + parse.getHost();
        String query = parse.getQuery();
        Iterator<String> it = urlMatchRule.getDomainList().iterator();
        while (it.hasNext()) {
            String replaceFirst = this.mOriginUrl.replaceFirst(str, scheme + "://" + it.next());
            if (!TextUtils.isEmpty(query)) {
                replaceFirst = query.contains("concurrent=") ? replaceFirst : replaceFirst + "&concurrent=" + i;
                if (i > 0 && !query.contains("is_retry=")) {
                    replaceFirst = replaceFirst + "&is_retry=1";
                }
            }
            i++;
            this.mUrlList.add(replaceFirst);
        }
        this.mTransactionId = UUID.randomUUID().toString();
        this.mRuleId = urlMatchRule.mRuleId;
        this.mRsName = urlMatchRule.mRefineRsName;
        this.mConnectTimeInterval = urlMatchRule.mConnectTimeInterval;
        mRetryForNot2xxCode = urlMatchRule.mRetryForNot2xxCode;
        this.mBypassRouteSelectionEnabled = urlMatchRule.mBypassRouteSelectionEnabled;
        this.mTNCRequestMaxWaitTime = urlMatchRule.mTNCRequestMaxWaitTime;
        this.mEnableRequestReportFix = urlMatchRule.mEnableRequestReportFix;
        computeRequestMaxWaitTime(request);
        if (Logger.debug()) {
            Logger.d(TAG, "Request max wait time milliseconds: " + this.mRequestMaxWaitTime + ", user max wait time: " + this.mTNCRequestMaxWaitTime + ", connect interval milliseconds: " + this.mConnectTimeInterval);
        }
        this.requestInfo.metrics.transactionId = this.mTransactionId;
        this.requestInfo.metrics.isConcurrent = true;
    }

    private void computeRequestMaxWaitTime(Request request) {
        this.mRequestMaxWaitTime = NetworkParams.getConnectTimeout() + NetworkParams.getIoTimeout();
        if (request.getExtraInfo() instanceof BaseRequestContext) {
            BaseRequestContext baseRequestContext = (BaseRequestContext) request.getExtraInfo();
            if (baseRequestContext.protect_timeout > 0) {
                this.mRequestMaxWaitTime = baseRequestContext.protect_timeout;
            } else if (baseRequestContext.timeout_connect > 0 && baseRequestContext.timeout_read > 0) {
                this.mRequestMaxWaitTime = baseRequestContext.timeout_connect + baseRequestContext.timeout_read;
            }
        }
        this.mRequestMaxWaitTime += 1000;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall
    public HttpURLConnection connection() {
        return this.mWinnerConnection != null ? this.mWinnerConnection : this.mFirstFailedConnection;
    }

    public void handleMsg(Message message) {
        if (message == null || !(message.obj instanceof Pair)) {
            return;
        }
        try {
            Pair pair = (Pair) message.obj;
            ConcurrentCronetSsCall concurrentCronetSsCall = (ConcurrentCronetSsCall) pair.first;
            BaseHttpRequestInfo baseHttpRequestInfo = (BaseHttpRequestInfo) pair.second;
            int i = message.what;
            if (i == 0) {
                concurrentCronetSsCall.doApiTask(baseHttpRequestInfo);
            } else if (i == 1) {
                concurrentCronetSsCall.doApiTaskAndCancelDelayedTask(baseHttpRequestInfo);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean shouldRetryApiTaskFromHttpCode(int i, String str, String str2) {
        if (i >= 200 && i < 300) {
            return false;
        }
        if (str == null || !str.equals(DiskLruCache.VERSION)) {
            return (i < 300 || i >= 600 || mRetryForNot2xxCode) && !CronetSsCallConfig.inst().inBlockErrorCode(i, str2);
        }
        return false;
    }

    private BaseHttpRequestInfo copyRequestInfo(BaseHttpRequestInfo baseHttpRequestInfo) {
        BaseHttpRequestInfo createHttpRequestInfo = BaseHttpRequestInfo.createHttpRequestInfo();
        if (baseHttpRequestInfo.metrics != null) {
            createHttpRequestInfo.attachMetrics(baseHttpRequestInfo.metrics.deepCopy());
        }
        createHttpRequestInfo.downloadFile = baseHttpRequestInfo.downloadFile;
        createHttpRequestInfo.reqContext = baseHttpRequestInfo.reqContext;
        if (baseHttpRequestInfo.rotationHostPathRetryHandler != null) {
            createHttpRequestInfo.rotationHostPathRetryHandler = baseHttpRequestInfo.rotationHostPathRetryHandler.deepCopy();
        }
        createHttpRequestInfo.httpClientType = baseHttpRequestInfo.httpClientType;
        try {
            if (createHttpRequestInfo.extraInfo != null) {
                createHttpRequestInfo.extraInfo = new JSONObject(createHttpRequestInfo.extraInfo.toString());
            }
        } catch (Exception unused) {
        }
        return createHttpRequestInfo;
    }

    private void updateGlobalRequestInfo(BaseHttpRequestInfo baseHttpRequestInfo) {
        if (baseHttpRequestInfo == null) {
            return;
        }
        baseHttpRequestInfo.metrics.copyTo(this.requestInfo.metrics);
        baseHttpRequestInfo.metrics = this.requestInfo.metrics;
        this.requestInfo = baseHttpRequestInfo;
    }

    private void doApiTask(final BaseHttpRequestInfo baseHttpRequestInfo) {
        final BaseHttpRequestInfo copyRequestInfo = copyRequestInfo(baseHttpRequestInfo);
        BaseHttpRequestInfo copyRequestInfo2 = copyRequestInfo(baseHttpRequestInfo);
        RequestQueue.getDefaultRequestQueue().add(new ApiTask("Concurrent-Call", IRequest.Priority.IMMEDIATE, 0, new Runnable() { // from class: com.bytedance.frameworks.baselib.network.http.cronet.impl.ConcurrentCronetSsCall$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ConcurrentCronetSsCall.this.m1290x9b991af3(baseHttpRequestInfo, copyRequestInfo);
            }
        }, this.requestInfo.downloadFile));
        scheduleApiTask(this.mConnectTimeInterval, copyRequestInfo2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0176, code lost:
    
        if (r7 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0178, code lost:
    
        r7.disconnect();
        r18.mPendingURLConnections.remove(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0186, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0187, code lost:
    
        r13 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0208, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x020d, code lost:
    
        r13 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x01ff, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0200, code lost:
    
        r19.metrics.executeConnectionEnd(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0207, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x020a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x011b, code lost:
    
        r2 = r19.metrics.executeConnectionStart();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0121, code lost:
    
        r18.responseCode = executeConnection(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0127, code lost:
    
        r19.metrics.executeConnectionEnd(r2);
        r15.mResponseCode = r18.responseCode;
        r15.mEndTime = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0145, code lost:
    
        if (shouldRetryApiTaskFromHttpCode(r18.responseCode, r7.getHeaderField(com.bytedance.frameworks.baselib.network.http.cronet.impl.ConcurrentCronetSsCall.API_SOURCE_5XX_CODE), r18.mRuleId) != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x018a, code lost:
    
        r16 = r7.getResponseMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x018e, code lost:
    
        r4 = r18.retrofitRequest.getMaxLength();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0194, code lost:
    
        r0 = r7.getInputStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x019a, code lost:
    
        r0 = r7.getErrorStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01c9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0147, code lost:
    
        r2 = r18.mConnectionLock;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0149, code lost:
    
        monitor-enter(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x014c, code lost:
    
        if (r18.mWinnerConnection != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x014e, code lost:
    
        r18.mWinnerConnection = r7;
        r18.mWinnerIndex = r4;
        r18.mWinnerRequestInfo = r19;
        r18.mOriginUrl = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x015a, code lost:
    
        if (com.bytedance.common.utility.Logger.debug() == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x015c, code lost:
    
        com.bytedance.common.utility.Logger.d(com.bytedance.frameworks.baselib.network.http.cronet.impl.ConcurrentCronetSsCall.TAG, "winnerindex is " + r18.mWinnerIndex);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0170, code lost:
    
        r18.mCallExecuteLatch.countDown();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0180, code lost:
    
        monitor-exit(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0232  */
    /* renamed from: lambda$doApiTask$0$com-bytedance-frameworks-baselib-network-http-cronet-impl-ConcurrentCronetSsCall */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void m1290x9b991af3(BaseHttpRequestInfo baseHttpRequestInfo, BaseHttpRequestInfo baseHttpRequestInfo2) {
        String str;
        ConnectionAttempts connectionAttempts;
        HttpURLConnection constructConnection;
        String responseMessage;
        int maxLength;
        InputStream errorStream;
        long uptimeMillis = SystemClock.uptimeMillis();
        HttpURLConnection httpURLConnection = null;
        String str2 = null;
        httpURLConnection = null;
        httpURLConnection = null;
        httpURLConnection = null;
        try {
            try {
                synchronized (this.mConnectionLock) {
                    try {
                        if (this.mCurrentUrlIndex.get() < this.mUrlList.size() && this.mWinnerConnection == null && this.mCallExecuteLatch.getCount() != 0 && !this.canceled) {
                            int i = this.mCurrentUrlIndex.get();
                            String str3 = this.mUrlList.get(i);
                            try {
                                if (this.mRsName != null && i > 0) {
                                    UrlBuilder urlBuilder = new UrlBuilder(str3);
                                    urlBuilder.addParam("bypass_rs", DiskLruCache.VERSION);
                                    str3 = urlBuilder.build();
                                }
                                str = str3;
                                try {
                                    connectionAttempts = new ConnectionAttempts(new URL(str).getHost());
                                    connectionAttempts.taskRequestInfo = baseHttpRequestInfo;
                                    this.mConnectionAttempts.add(connectionAttempts);
                                    if (this.mRsName != null && dropIfDuplicate(str, connectionAttempts).booleanValue() && i > 0) {
                                        this.mFailedTimes++;
                                        if (this.mFailedTimes >= this.mUrlList.size()) {
                                            if (Logger.debug()) {
                                                Logger.d(TAG, "Try all urls failed countdown.");
                                            }
                                            this.mCallExecuteLatch.countDown();
                                            return;
                                        } else {
                                            this.mCurrentUrlIndex.incrementAndGet();
                                            accelerateNextTaskWhenFailed(baseHttpRequestInfo2);
                                            return;
                                        }
                                    }
                                    if (Logger.debug()) {
                                        Logger.d(TAG, "ConstructURLConnection and execute index: " + this.mCurrentUrlIndex.get() + " url: " + str);
                                    }
                                    baseHttpRequestInfo.metrics.prepareConnectionStart();
                                    constructConnection = constructConnection(str, baseHttpRequestInfo);
                                    try {
                                        configureConnection(this.retrofitRequest, baseHttpRequestInfo, constructConnection, null);
                                        baseHttpRequestInfo.metrics.prepareConnectionEnd();
                                        if (this.mBypassRouteSelectionEnabled) {
                                            try {
                                                if (this.mRsName == null) {
                                                    constructConnection.setRequestProperty(REQUEST_HEADERS_BYPASS_ROUTE_SELECTION, DiskLruCache.VERSION);
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                httpURLConnection = constructConnection;
                                            }
                                        }
                                        constructConnection.setRequestProperty(REQUEST_HEADERS_TRANSACTION_ID, this.mTransactionId);
                                        this.mCurrentUrlIndex.incrementAndGet();
                                        this.mPendingURLConnections.add(constructConnection);
                                        connectionAttempts.mId = constructConnection.hashCode();
                                    } catch (Throwable th2) {
                                        th = th2;
                                        httpURLConnection = constructConnection;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    connectionAttempts = null;
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                str = str3;
                            }
                        }
                        this.mHandler.removeCallbacksAndMessages((Object) null);
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        str = null;
                        connectionAttempts = null;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e) {
            e = e;
            str = null;
            connectionAttempts = null;
        }
        try {
            throw th;
            InputStream inputStream = errorStream;
            String headerField = constructConnection.getHeaderField("Content-Type");
            if (TextUtils.isEmpty(headerField)) {
                headerField = constructConnection.getHeaderField("Content-Type".toLowerCase());
            }
            try {
                str2 = processHttpErrorResponse(baseHttpRequestInfo, constructConnection.getHeaderFields(), maxLength, inputStream, headerField, false);
            } catch (Throwable th7) {
                th = th7;
                th.printStackTrace();
                StringBuilder sb = new StringBuilder("reason = ");
                if (responseMessage == null) {
                    responseMessage = "";
                }
                responseMessage = sb.append(responseMessage).append("  exception = ").append(th.getMessage()).toString();
                throw new HttpResponseException(this.responseCode, responseMessage, this.retrofitRequest.getPath(), str2);
            }
            throw new HttpResponseException(this.responseCode, responseMessage, this.retrofitRequest.getPath(), str2);
        } catch (IOException e2) {
            e = e2;
            synchronized (this.mConnectionLock) {
                int i2 = -1;
                try {
                    Class cls = sCronetExceptionCls;
                    if (cls != null && cls.isInstance(e)) {
                        i2 = ((Integer) ReflectWrap.m1296on(e).call("getCronetInternalErrorCode").get()).intValue();
                        if (Logger.debug()) {
                            Logger.d(TAG, "cronet error code: " + i2);
                        }
                    }
                } catch (Throwable unused) {
                }
                if (this.mFirstFailedConnection == null) {
                    if (Logger.debug()) {
                        Logger.d(TAG, "Get first failed connection " + httpURLConnection.getURL().toString());
                    }
                    this.mFirstFailedConnection = httpURLConnection;
                    this.mFirstFailedRequestInfo = baseHttpRequestInfo;
                } else if (Logger.debug()) {
                    Logger.d(TAG, "Get non first failed connection " + httpURLConnection.getURL().toString());
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    if (connectionAttempts != null) {
                        connectionAttempts.mException = handleException(e, str, httpURLConnection, false);
                        connectionAttempts.mNetError = i2;
                        connectionAttempts.mEndTime = System.currentTimeMillis();
                    }
                    this.mPendingURLConnections.remove(httpURLConnection);
                }
                int i3 = this.mFailedTimes + 1;
                this.mFailedTimes = i3;
                if (i3 >= this.mUrlList.size()) {
                    if (Logger.debug()) {
                        Logger.d(TAG, "Try all urls failed countdown.");
                    }
                    this.mCallExecuteLatch.countDown();
                } else if (this.mEnableRequestReportFix && this.canceled) {
                    if (Logger.debug()) {
                        Logger.d(TAG, "User canceled.");
                    }
                    this.mCallExecuteLatch.countDown();
                } else if (!CronetSsCallConfig.inst().inBlockErrorCode(i2, this.mRuleId)) {
                    if (SystemClock.uptimeMillis() - uptimeMillis < this.mConnectTimeInterval) {
                        accelerateNextTaskWhenFailed(baseHttpRequestInfo2);
                    }
                } else {
                    if (Logger.debug()) {
                        Logger.d(TAG, "inBlockErrorCode countdown.");
                    }
                    this.mCallExecuteLatch.countDown();
                }
            }
        }
    }

    private void accelerateNextTaskWhenFailed(BaseHttpRequestInfo baseHttpRequestInfo) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = new Pair(this, baseHttpRequestInfo);
        this.mHandler.sendMessage(obtain);
    }

    private void doApiTaskAndCancelDelayedTask(BaseHttpRequestInfo baseHttpRequestInfo) {
        if (this.mHandler.obtainMessage(0) != null) {
            this.mHandler.removeMessages(0);
            doApiTask(baseHttpRequestInfo);
        }
    }

    private void scheduleApiTask(long j, BaseHttpRequestInfo baseHttpRequestInfo) {
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = new Pair(this, baseHttpRequestInfo);
        this.mHandler.sendMessageDelayed(obtain, j);
    }

    private void cleanupMessagesAndPendingConnections() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
        synchronized (this.mConnectionLock) {
            if (this.mCleanUpDone) {
                return;
            }
            for (HttpURLConnection httpURLConnection : this.mPendingURLConnections) {
                if (httpURLConnection != null) {
                    Iterator<ConnectionAttempts> it = this.mConnectionAttempts.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ConnectionAttempts next = it.next();
                        if (next.mId == httpURLConnection.hashCode()) {
                            next.mEndTime = System.currentTimeMillis();
                            if (this.mEnableRequestReportFix) {
                                next.mCleanUpTime = System.currentTimeMillis();
                            } else {
                                next.mNetError = CANCELED_INTERNAL;
                                next.mException = new IOException("cleanupMessagesAndPendingConnections");
                            }
                        }
                    }
                    httpURLConnection.disconnect();
                    this.mPendingURLConnections.remove(httpURLConnection);
                }
            }
            this.requestInfo.metrics.concurrentRequest = reportConcurrentRequestMetrics();
            this.mCleanUpDone = true;
        }
    }

    private JSONObject reportConcurrentRequestMetrics() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("concurrent", this.mConnectionAttempts.size() - 1);
            jSONObject.put(DowngradeInfo.FIELD_DURATION, System.currentTimeMillis() - this.requestInfo.requestStart);
            if (this.mEnableRequestReportFix && !TextUtils.isEmpty(mCallFailureMessage)) {
                jSONObject.put("call_msg", mCallFailureMessage);
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<ConnectionAttempts> it = this.mConnectionAttempts.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            jSONObject.put("tasks", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public Response execute() throws IOException {
        if (this.canceled) {
            throw new IOException(CANCELED_EXCEPTION_MESSAGE);
        }
        tryNecessaryInit(this.retrofitRequest, this.requestInfo);
        checkNetworkAvailableBeforeRequest();
        doApiTask(copyRequestInfo(this.requestInfo));
        try {
            try {
                long j = this.mRequestMaxWaitTime;
                if (this.mEnableRequestReportFix) {
                    j = Math.max(j, this.mTNCRequestMaxWaitTime);
                }
                this.mCallExecuteLatch.await(j, TimeUnit.MILLISECONDS);
                this.mCallExecuteLatch.countDown();
                synchronized (this.mConnectionLock) {
                    if (!this.mEnableRequestReportFix && this.canceled) {
                        throw new IOException(CANCELED_EXCEPTION_MESSAGE);
                    }
                    if (this.mWinnerConnection == null) {
                        updateGlobalRequestInfo(this.mFirstFailedRequestInfo);
                        CronetSsCallConfig.inst().notifyConcurrentRequestFinished(this.mRuleId, false);
                        if (this.mConnectionAttempts.size() > 0 && this.mConnectionAttempts.get(0).mException != null) {
                            updateGlobalRequestInfo(this.mConnectionAttempts.get(0).taskRequestInfo);
                            throw this.mConnectionAttempts.get(0).mException;
                        }
                        if (this.mEnableRequestReportFix) {
                            mCallFailureMessage = "All urls have been tried and timed out by max wait time.";
                        } else {
                            throw handleException(new IOException("All urls have been tried and timed out by max wait time."), this.mOriginUrl, this.mWinnerConnection, false);
                        }
                    } else {
                        updateGlobalRequestInfo(this.mWinnerRequestInfo);
                        this.mPendingURLConnections.remove(this.mWinnerConnection);
                    }
                }
                cleanupMessagesAndPendingConnections();
                try {
                    try {
                        if (this.mWinnerIndex > 0 && !TextUtils.isEmpty(this.mRsName)) {
                            if (Logger.debug()) {
                                Logger.e(TAG, "winner is " + this.mWinnerIndex + " url is " + this.mWinnerConnection.getURL().getHost());
                            }
                            setRouteSelectionBestHost(new URL(this.mUrlList.get(this.mWinnerIndex)).getHost(), this.mRsName);
                        }
                        CronetSsCallConfig.inst().notifyConcurrentRequestFinished(this.mRuleId, true);
                        List<String> retryRequestOnceIfNeeded = retryRequestOnceIfNeeded(this.retrofitRequest, this.requestInfo, this, true, true);
                        onFinalResponseHeaderReceived(this.requestInfo, this);
                        TypedInput processResponseBody = processResponseBody(this.mOriginUrl, this.retrofitRequest, this.requestInfo, this, this);
                        onResponseBodyProcessed(processResponseBody);
                        Response response = new Response(this.mOriginUrl, this.responseCode, this.mWinnerConnection.getResponseMessage(), createHeaders(this, retryRequestOnceIfNeeded), processResponseBody);
                        response.setExtraInfo(this.requestInfo);
                        if (!this.retrofitRequest.isResponseStreaming()) {
                            safeClose();
                        }
                        return response;
                    } catch (Throwable th) {
                        if (!this.retrofitRequest.isResponseStreaming() || 0 != 0) {
                            safeClose();
                        }
                        throw th;
                    }
                } catch (Exception e) {
                    throw handleException(e, this.mOriginUrl, this.mWinnerConnection, true);
                }
            } catch (Exception e2) {
                cleanupMessagesAndPendingConnections();
                if (this.mWinnerConnection == null && this.mFirstFailedConnection != null) {
                    throw handleException(e2, this.mOriginUrl, this.mFirstFailedConnection, true);
                }
                throw handleException(e2, this.mOriginUrl, this.mWinnerConnection, true);
            }
        } finally {
            if (0 != 0) {
                updateRequestInfoWithException(this.requestInfo, this, null);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r9v3, types: [com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException, java.io.IOException] */
    private IOException handleException(Exception exc, String str, HttpURLConnection httpURLConnection, boolean z) {
        if (!this.mEnableRequestReportFix && (exc instanceof IOException) && exc.getMessage() != null && exc.getMessage().startsWith(CANCELED_EXCEPTION_MESSAGE)) {
            return (IOException) exc;
        }
        int cronetInternalErrorCode = (CRONET_EXCEPTION_CLASS_NAME.equals(exc.getClass().getName()) || "com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(exc.getClass().getName())) ? SsCronetHttpClient.getCronetInternalErrorCode(httpURLConnection) : 0;
        if (TextUtils.isEmpty(str)) {
            str = this.mOriginUrl;
        }
        String str2 = str;
        if (!z && httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        try {
            checkNetworkAvailableAfterRequest(this.retrofitRequest, exc);
            ?? cronetIOException = new CronetIOException(exc, this.requestInfo, cronetInternalErrorCode);
            cronetIOException.setInfo(false, z, str2, this.requestInfo.traceCode, this.requestInfo);
            return cronetIOException;
        } catch (NetworkNotAvailabeException e) {
            return e;
        }
    }

    public void cancel() {
        if (Logger.debug()) {
            Logger.d(TAG, "cancel countdown.");
        }
        synchronized (this.mConnectionLock) {
            if (!this.mEnableRequestReportFix) {
                this.mCallExecuteLatch.countDown();
            }
            cleanupMessagesAndPendingConnections();
            cancelInner(this.mWinnerConnection);
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall
    public boolean setThrottleNetSpeed(long j) {
        super.setThrottleNetSpeed(j);
        if (this.mWinnerConnection != null) {
            try {
                if (NetworkParams.getOptReflection()) {
                    ReflectWrap.m1296on(this.mWinnerConnection).call("configureConnection", new Class[]{String.class, Object[].class}, "setThrottleNetSpeed", new Object[]{Long.valueOf(j)});
                } else {
                    ReflectWrap.m1296on(this.mWinnerConnection).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, Long.valueOf(j));
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public Boolean dropIfDuplicate(String str, ConnectionAttempts connectionAttempts) {
        if (!TTNetInitMetrics.isCronetInitSuccess() || connectionAttempts == null) {
            if (Logger.debug()) {
                Logger.e(TAG, "cronet did not init, dispatch fail");
            }
            return true;
        }
        try {
            new URL(str).toURI();
            if (this.mCurrentUrlIndex.get() == 0) {
                this.mFirstUrl = str;
                this.mFirstAttempt = connectionAttempts;
                return false;
            }
            if (this.mCurrentUrlIndex.get() == 1) {
                this.mSentHosts.add(dispatch(this.mFirstUrl, this.mFirstAttempt));
            }
            dispatch(str, connectionAttempts);
            if (this.mSentHosts.contains(connectionAttempts.mDispatchedHost)) {
                connectionAttempts.sentAlready = true;
                return true;
            }
            this.mSentHosts.add(connectionAttempts.mDispatchedHost);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private String dispatch(String str, ConnectionAttempts connectionAttempts) {
        if (connectionAttempts == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String finalUrl = SsCronetHttpClient.ttUrlDispatch(str, -1, true).getFinalUrl();
            connectionAttempts.mDispatchTime = System.currentTimeMillis() - currentTimeMillis;
            try {
                connectionAttempts.mDispatchedHost = new URI(finalUrl).getHost();
                if (Logger.debug()) {
                    Logger.e(TAG, "url is " + str + " dispatchedUrl is " + finalUrl);
                }
                return connectionAttempts.mDispatchedHost;
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private void setRouteSelectionBestHost(String str, String str2) {
        try {
            SsCronetHttpClient.setBestHostWithRouteSelectionName(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
