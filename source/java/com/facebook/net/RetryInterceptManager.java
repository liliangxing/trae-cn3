package com.facebook.net;

import android.net.Uri;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedance.vcloud.strategy.StrategyCenter;
import com.bytedance.webx.event.EventManager;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.exception.BDErrorCodeConst;
import com.ss.alog.middleware.ALogService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.OkHttpClient;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RetryInterceptManager {
    private static final String TAG = "RetryInterceptManager";
    private static volatile RetryInterceptManager sInstance;
    private volatile ArrayList<Integer> mConnectTimeOuts;
    private volatile boolean mContentLengthOpen;
    private volatile boolean mContentTypeOpen;
    private volatile ArrayList<Integer> mMDLConnectTimeOut;
    private volatile ArrayList<Integer> mMDLReadTimeOut;
    private volatile int mMaxRetryCount;
    private volatile boolean mMd5Open;
    private volatile ArrayList<OkHttpClient> mOkHttpClients;
    private volatile boolean mOpen;
    private volatile ArrayList<Integer> mReadTimeOuts;
    private volatile List<Interceptor> mRetrofitInterceptors;
    private volatile HashMap<String, Retrofit> sRetrofitCache;
    private final int CONNECT_TIME_OUT_CHECK = 1;
    private final int READ_TIME_OUT_CHECK = 2;
    private volatile int mMDLRetryCount = 3;

    private RetryInterceptManager() {
    }

    public static RetryInterceptManager inst() {
        if (sInstance == null) {
            synchronized (RetryInterceptManager.class) {
                if (sInstance == null) {
                    sInstance = new RetryInterceptManager();
                }
            }
        }
        return sInstance;
    }

    public synchronized void open(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        attachRetryTime(arrayList, arrayList2);
        initRetrofitRetryInterceptor();
        initCommonRetrofitMap(getDefaultCommonBaseUrl());
        this.mOpen = true;
    }

    public synchronized void openMd5(boolean z) {
        this.mMd5Open = z;
    }

    public synchronized void close() {
        this.mOpen = false;
    }

    public synchronized boolean isOpen() {
        return this.mOpen;
    }

    public synchronized boolean isMd5Open() {
        return this.mMd5Open;
    }

    public synchronized boolean isContentTypeOpen() {
        return this.mContentTypeOpen;
    }

    public synchronized void setContentTypeOpen(boolean z) {
        this.mContentTypeOpen = z;
    }

    public synchronized boolean isContentLengthOpen() {
        return this.mContentLengthOpen;
    }

    public synchronized void setContentLengthOpen(boolean z) {
        this.mContentLengthOpen = z;
    }

    public synchronized void setMDLRetryCount(int i, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        this.mMDLRetryCount = i;
        this.mMDLConnectTimeOut = arrayList;
        this.mMDLReadTimeOut = arrayList2;
    }

    public synchronized int getMaxRetryCount() {
        return this.mMaxRetryCount;
    }

    public synchronized int getMDLConnectTimeOut(int i) {
        if (this.mMDLConnectTimeOut == null) {
            this.mMDLConnectTimeOut = getDefaultConnectTimeOuts();
        }
        if (i < this.mMDLConnectTimeOut.size()) {
            return this.mMDLConnectTimeOut.get(i).intValue();
        }
        return this.mMDLConnectTimeOut.get(this.mMDLConnectTimeOut.size() - 1).intValue();
    }

    public synchronized int getMDLReadTimeOut(int i) {
        if (this.mMDLReadTimeOut == null) {
            this.mMDLReadTimeOut = getDefaultReadTimeOuts();
        }
        if (i < this.mMDLReadTimeOut.size()) {
            return this.mMDLReadTimeOut.get(i).intValue();
        }
        return this.mMDLReadTimeOut.get(this.mMDLReadTimeOut.size() - 1).intValue();
    }

    public synchronized int getMDLRetryCount() {
        return this.mMDLRetryCount;
    }

    public void attachCommonBaseUrl(List<String> list) {
        if (list == null) {
            list = getDefaultCommonBaseUrl();
        }
        initCommonRetrofitMap(list);
    }

    public <S> S getRetrofitService(String str, Class<S> cls) {
        if (!isOpen()) {
            ALogService.wSafely(TAG, "[getRetrofitService] is closed");
            return null;
        }
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        Retrofit retrofit = this.sRetrofitCache.get(str);
        if (retrofit == null) {
            retrofit = RetrofitUtils.createSsRetrofit(str, isOpen() ? this.mRetrofitInterceptors : null, (Converter.Factory) null, (CallAdapter.Factory) null);
        }
        return (S) RetrofitUtils.createService(retrofit, cls);
    }

    public boolean checkRetryNecessity(Exception exc) {
        if (exc == null) {
            return false;
        }
        String message = exc.getMessage();
        return (BDErrorCodeConst.BD_ERROR_MSG_REQUEST_CANCELED.equals(message) || "Canceled".equals(message) || "network not available".equals(message)) ? false : true;
    }

    private void attachRetryTime(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        this.mConnectTimeOuts = checkRetryTime(arrayList, 1);
        this.mReadTimeOuts = checkRetryTime(arrayList2, 2);
        this.mMaxRetryCount = Math.min(this.mConnectTimeOuts.size(), this.mReadTimeOuts.size());
    }

    private ArrayList<Integer> getDefaultConnectTimeOuts() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(3000);
        arrayList.add(Integer.valueOf(EventManager.REGION_IN_OUT_ADJUST));
        arrayList.add(15000);
        return arrayList;
    }

    private ArrayList<Integer> getDefaultReadTimeOuts() {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        Integer valueOf = Integer.valueOf(EventManager.REGION_IN_OUT_ADJUST);
        arrayList.add(valueOf);
        arrayList.add(valueOf);
        arrayList.add(15000);
        return arrayList;
    }

    private ArrayList<String> getDefaultCommonBaseUrl() {
        ArrayList<String> arrayList = new ArrayList<>(4);
        arrayList.add("p1.pstap.com");
        arrayList.add("p3.pstap.com");
        arrayList.add("p6.pstap.com");
        arrayList.add("p9.pstap.com");
        return arrayList;
    }

    private ArrayList<Integer> checkRetryTime(ArrayList<Integer> arrayList, int i) {
        boolean z = i == 1;
        if (arrayList == null || arrayList.size() > 5) {
            return z ? getDefaultConnectTimeOuts() : getDefaultReadTimeOuts();
        }
        if (z) {
            checkBoundary(arrayList, 0, 3000, StrategyCenter.GLOBAL_OPTION_END, 15000);
        } else {
            checkBoundary(arrayList, 0, 15000, StrategyCenter.GLOBAL_OPTION_END, 15000);
        }
        return arrayList;
    }

    private void checkBoundary(ArrayList<Integer> arrayList, int i, int i2, int i3, int i4) {
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            int intValue = arrayList.get(i5).intValue();
            if (intValue <= i) {
                arrayList.set(i5, Integer.valueOf(i2));
            } else if (intValue >= i3) {
                arrayList.set(i5, Integer.valueOf(i4));
            }
        }
    }

    private void initCommonRetrofitMap(List<String> list) {
        this.sRetrofitCache = new HashMap<>(list.size());
        for (String str : list) {
            this.sRetrofitCache.put(str, RetrofitUtils.createSsRetrofit(str, isOpen() ? this.mRetrofitInterceptors : null, (Converter.Factory) null, (CallAdapter.Factory) null));
        }
    }

    private void initRetrofitRetryInterceptor() {
        this.mRetrofitInterceptors = new ArrayList(1);
        this.mRetrofitInterceptors.add(new Interceptor() { // from class: com.facebook.net.RetryInterceptManager.1
            public SsResponse intercept(Interceptor.Chain chain) throws Exception {
                FrescoRequestContext frescoRequestContext;
                int i = 0;
                int i2 = 0;
                while (true) {
                    try {
                        Request request = chain.request();
                        if (RetryInterceptManager.this.isOpen()) {
                            Object extraInfo = request.getExtraInfo();
                            if (extraInfo instanceof FrescoRequestContext) {
                                frescoRequestContext = (FrescoRequestContext) extraInfo;
                            } else {
                                frescoRequestContext = new FrescoRequestContext();
                            }
                            if (i == 0) {
                                i2 += frescoRequestContext.getRetryCount();
                            }
                            Request createRequest = RetryInterceptManager.this.createRequest(chain, i2);
                            RetryInterceptManager retryInterceptManager = RetryInterceptManager.this;
                            frescoRequestContext.timeout_connect = retryInterceptManager.getTimeOut(retryInterceptManager.mConnectTimeOuts, i);
                            RetryInterceptManager retryInterceptManager2 = RetryInterceptManager.this;
                            frescoRequestContext.timeout_read = retryInterceptManager2.getTimeOut(retryInterceptManager2.mReadTimeOuts, i);
                            createRequest.setExtraInfo(frescoRequestContext);
                            request = createRequest;
                        }
                        SsResponse proceed = chain.proceed(request);
                        try {
                            if (proceed instanceof SsResponse) {
                                Object extraInfo2 = proceed.raw().getExtraInfo();
                                if (extraInfo2 instanceof HttpRequestInfo) {
                                    ((HttpRequestInfo) extraInfo2).extraInfo.put("retryCount", i);
                                }
                            }
                        } catch (Exception unused) {
                        }
                        return proceed;
                    } catch (Exception e) {
                        if (RetryInterceptManager.this.isOpen() && RetryInterceptManager.this.checkRetryNecessity(e)) {
                            i++;
                            i2++;
                            if (i2 >= RetryInterceptManager.this.mMaxRetryCount) {
                                throw new RetryWrapException(e, i);
                            }
                            ALogService.wSafely(RetryInterceptManager.TAG, "[intercept] retryNum: " + i);
                        } else {
                            throw e;
                        }
                    }
                }
                throw e;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Request createRequest(Interceptor.Chain chain, int i) {
        List<Uri> backupUris;
        Request request = chain.request();
        Object extraInfo = request.getExtraInfo();
        if ((extraInfo instanceof FrescoRequestContext) && (backupUris = ((FrescoRequestContext) extraInfo).getBackupUris()) != null && i > 0 && backupUris.size() >= i) {
            Uri uri = backupUris.get(i - 1);
            if (UriUtil.isNetworkUri(uri)) {
                return new Request(request.getMethod(), uri.toString(), request.getHeaders(), request.getBody(), request.getPriorityLevel(), request.isResponseStreaming(), request.getMaxLength(), request.isAddCommonParam(), request.getExtraInfo());
            }
        }
        return request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getTimeOut(ArrayList<Integer> arrayList, int i) {
        int intValue;
        if (arrayList == null || arrayList.isEmpty()) {
            arrayList = getDefaultConnectTimeOuts();
        }
        int size = arrayList.size();
        if (i < size) {
            intValue = arrayList.get(i).intValue();
        } else {
            intValue = arrayList.get(size - 1).intValue();
        }
        return intValue;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class RetryWrapException extends Exception {

        /* renamed from: e */
        public final Exception f367e;
        public final int retryCount;

        public RetryWrapException(Exception exc, int i) {
            this.f367e = exc;
            this.retryCount = i;
        }
    }
}
