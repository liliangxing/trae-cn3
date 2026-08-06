package com.ttnet.org.chromium.net.impl;

import android.os.Build;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.impl.CronetLogger;
import com.ttnet.org.chromium.net.impl.VersionSafeCallbacks;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

@JNINamespace("cronet")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class CronetUrlRequest extends UrlRequestBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long mAddCookieCostUs;
    private final boolean mAllowDirectExecutor;
    private String mAuthCertPassword;
    private String mAuthCertUsername;
    private long mBizReadResponseBodyInterval;
    private final VersionSafeCallbacks.UrlRequestCallback mCallback;
    private final int mCronetEngineId;
    private String mCronetMapKey;
    private long mCurrentReadResponseBodyStart;
    private final boolean mDisableCache;
    private final boolean mDisableConnectionMigration;
    private CronetException mException;
    private final Executor mExecutor;
    private String mFinalUrl;
    private int mFinishedReason;
    private long mFirstReadResponseBodyStart;
    private final int mIdempotency;
    private String mInitialMethod;
    private final String mInitialUrl;
    private long mLastReadResponseBodyEnd;
    private final CronetLogger mLogger;
    private CronetMetrics mMetrics;
    private final long mNetworkHandle;
    private Runnable mOnDestroyedCallbackForTesting;
    private OnReadCompletedRunnable mOnReadCompletedTask;
    private final int mPriority;
    private boolean mQuicConnectionMigrationAttempted;
    private boolean mQuicConnectionMigrationSuccessful;
    private long mReadResponseBodyDuration;
    private final Collection<Object> mRequestAnnotations;
    private final CronetUrlRequestContext mRequestContext;
    private int mRequestCookieSource;
    private final VersionSafeCallbacks.RequestFinishedInfoListener mRequestFinishedListener;
    private int mRequestFlag;
    private final HeadersList mRequestHeaders;
    private int mRequestTimeout;
    private int mRequestTypeFlags;
    private long mResponseBodyReadTimes;
    private UrlResponseInfoImpl mResponseInfo;
    private long mSaveCookieCostUs;
    private int mSocketConnectTimeout;
    private int mSocketReadTimeout;
    private int mSocketWriteTimeout;
    private boolean mStarted;
    private long mThrottleNetSpeed;
    private final int mTrafficStatsTag;
    private final boolean mTrafficStatsTagSet;
    private final int mTrafficStatsUid;
    private final boolean mTrafficStatsUidSet;
    private CronetUploadDataStream mUploadDataStream;
    private final List<String> mUrlChain;
    private long mUrlRequestAdapter;
    private final Object mUrlRequestAdapterLock = new Object();
    private boolean mWaitingOnRead;
    private boolean mWaitingOnRedirect;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface Natives {
        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void abortWhenUploadException(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void addRequestCookieHeader(long j, CronetUrlRequest cronetUrlRequest, String str, String str2);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean addRequestHeader(long j, CronetUrlRequest cronetUrlRequest, String str, String str2);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void appTimeout(long j, CronetUrlRequest cronetUrlRequest);

        long createRequestAdapter(CronetUrlRequest cronetUrlRequest, long j, String str, int i, int i2, boolean z, boolean z2, boolean z3, int i3, boolean z4, int i4, int i5, long j2);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void destroy(long j, CronetUrlRequest cronetUrlRequest, boolean z);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void followDeferredRedirect(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void getStatus(long j, CronetUrlRequest cronetUrlRequest, VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean readData(long j, CronetUrlRequest cronetUrlRequest, ByteBuffer byteBuffer, int i, int i2);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void removeRequestCookieHeader(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setAuthCredentials(long j, CronetUrlRequest cronetUrlRequest, String str, String str2);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean setHttpMethod(long j, CronetUrlRequest cronetUrlRequest, String str);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setRequestTimeout(long j, CronetUrlRequest cronetUrlRequest, int i);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setRequestTypeFlags(long j, CronetUrlRequest cronetUrlRequest, int i);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setSocketTimeout(long j, CronetUrlRequest cronetUrlRequest, int i, int i2, int i3);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setThrottleNetSpeed(long j, CronetUrlRequest cronetUrlRequest, long j2);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void start(long j, CronetUrlRequest cronetUrlRequest);
    }

    private static int convertIdempotency(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    private static int convertRequestPriority(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 4 ? 4 : 5;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        HeadersList() {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private final class OnReadCompletedRunnable implements Runnable {
        ByteBuffer mByteBuffer;

        private OnReadCompletedRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.checkCallingThread();
            ByteBuffer byteBuffer = this.mByteBuffer;
            this.mByteBuffer = null;
            try {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (CronetUrlRequest.this.isDoneLocked()) {
                        return;
                    }
                    CronetUrlRequest.this.mWaitingOnRead = true;
                    VersionSafeCallbacks.UrlRequestCallback urlRequestCallback = CronetUrlRequest.this.mCallback;
                    CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                    urlRequestCallback.onReadCompleted(cronetUrlRequest, cronetUrlRequest.mResponseInfo, byteBuffer);
                }
            } catch (Exception e) {
                CronetUrlRequest.this.onCallbackException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CronetUrlRequest(CronetUrlRequestContext cronetUrlRequestContext, String str, int i, UrlRequest.Callback callback, Executor executor, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, RequestFinishedInfo.Listener listener, int i4, long j) {
        ArrayList arrayList = new ArrayList();
        this.mUrlChain = arrayList;
        this.mRequestHeaders = new HeadersList();
        this.mResponseBodyReadTimes = 0L;
        this.mFirstReadResponseBodyStart = -1L;
        this.mCurrentReadResponseBodyStart = -1L;
        this.mLastReadResponseBodyEnd = -1L;
        this.mReadResponseBodyDuration = -1L;
        this.mBizReadResponseBodyInterval = -1L;
        if (str == null) {
            throw new NullPointerException("URL is required");
        }
        if (callback == null) {
            throw new NullPointerException("Listener is required");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required");
        }
        this.mAllowDirectExecutor = z3;
        this.mRequestContext = cronetUrlRequestContext;
        this.mCronetEngineId = cronetUrlRequestContext.getCronetEngineId();
        this.mLogger = cronetUrlRequestContext.getCronetLogger();
        this.mInitialUrl = str;
        arrayList.add(str);
        this.mPriority = convertRequestPriority(i);
        this.mCallback = new VersionSafeCallbacks.UrlRequestCallback(callback);
        this.mExecutor = executor;
        this.mRequestAnnotations = collection;
        this.mDisableCache = z;
        this.mDisableConnectionMigration = z2;
        this.mTrafficStatsTagSet = z4;
        this.mTrafficStatsTag = i2;
        this.mTrafficStatsUidSet = z5;
        this.mTrafficStatsUid = i3;
        this.mRequestFinishedListener = listener != null ? new VersionSafeCallbacks.RequestFinishedInfoListener(listener) : null;
        this.mIdempotency = convertIdempotency(i4);
        this.mNetworkHandle = j;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setHttpMethod(String str) {
        checkNotStarted();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.mInitialMethod = str;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void addHeader(String str, String str2) {
        checkNotStarted();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        this.mRequestHeaders.add(new AbstractMap.SimpleImmutableEntry(str, str2));
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.mInitialMethod == null) {
            this.mInitialMethod = "POST";
        }
        this.mUploadDataStream = new CronetUploadDataStream(uploadDataProvider, executor, this);
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketConnectTimeout(int i) {
        this.mSocketConnectTimeout = i;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketReadTimeout(int i) {
        this.mSocketReadTimeout = i;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketWriteTimeout(int i) {
        this.mSocketWriteTimeout = i;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setRequestTimeout(int i) {
        this.mRequestTimeout = i;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setThrottleNetSpeed(long j) {
        synchronized (this.mUrlRequestAdapterLock) {
            this.mThrottleNetSpeed = j;
            if (this.mUrlRequestAdapter != 0) {
                CronetUrlRequestJni.get().setThrottleNetSpeed(this.mUrlRequestAdapter, this, j);
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestTypeFlags(int i) {
        this.mRequestTypeFlags = i | this.mRequestTypeFlags;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public String getFinalUrl() {
        return this.mFinalUrl;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void AddRequestCookieHeader(String str, String str2) {
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mUrlRequestAdapter == 0) {
                return;
            }
            CronetUrlRequestJni.get().addRequestCookieHeader(this.mUrlRequestAdapter, this, str, str2);
        }
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void RemoveRequestCookieHeader() {
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mUrlRequestAdapter == 0) {
                return;
            }
            CronetUrlRequestJni.get().removeRequestCookieHeader(this.mUrlRequestAdapter, this);
        }
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void appTimeout() {
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mUrlRequestAdapter == 0) {
                return;
            }
            CronetUrlRequestJni.get().appTimeout(this.mUrlRequestAdapter, this);
        }
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestFlag(int i) {
        this.mRequestFlag = i;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setAddCookieCostUs(long j) {
        this.mAddCookieCostUs = j;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setSaveCookieCostUs(long j) {
        this.mSaveCookieCostUs = j;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestCookieSource(int i) {
        this.mRequestCookieSource = i;
    }

    private RequestFinishedInfo getRequestFinishedInfo() {
        return new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, this.mFinishedReason, this.mResponseInfo, this.mException);
    }

    private String[] addSecurityFactor(String str, String[] strArr) {
        HashMap hashMap = new HashMap();
        int i = 0;
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            hashMap.put(strArr[i2].toLowerCase(Locale.US), strArr[i2 + 1]);
        }
        Map<String, String> onCallToAddSecurityFactor = this.mRequestContext.onCallToAddSecurityFactor(str, hashMap);
        if (onCallToAddSecurityFactor == null) {
            return null;
        }
        String[] strArr2 = new String[onCallToAddSecurityFactor.size() * 2];
        for (Map.Entry<String, String> entry : onCallToAddSecurityFactor.entrySet()) {
            strArr2[i] = entry.getKey();
            strArr2[i + 1] = entry.getValue();
            i += 2;
        }
        return strArr2;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setAuthCredentials(String str, String str2) {
        this.mAuthCertUsername = str;
        this.mAuthCertPassword = str2;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void cancelWithException(String str, Throwable th) {
        failWithException(new CronetExceptionImpl(str, th));
    }

    private void RecordReadResponseBodyStart() {
        this.mResponseBodyReadTimes++;
        long nanoTime = System.nanoTime();
        this.mCurrentReadResponseBodyStart = nanoTime;
        if (this.mFirstReadResponseBodyStart == -1) {
            this.mFirstReadResponseBodyStart = nanoTime;
        }
        long j = this.mLastReadResponseBodyEnd;
        if (j != -1) {
            if (this.mBizReadResponseBodyInterval == -1) {
                this.mBizReadResponseBodyInterval = 0L;
            }
            this.mBizReadResponseBodyInterval += nanoTime - j;
        }
    }

    private void MaybeRecordReadResponseBodyEnd() {
        if (this.mCurrentReadResponseBodyStart != -1) {
            long nanoTime = System.nanoTime();
            this.mLastReadResponseBodyEnd = nanoTime;
            if (this.mReadResponseBodyDuration == -1) {
                this.mReadResponseBodyDuration = 0L;
            }
            this.mReadResponseBodyDuration += nanoTime - this.mCurrentReadResponseBodyStart;
            this.mCurrentReadResponseBodyStart = -1L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void start() {
        Object obj;
        CronetUrlRequest cronetUrlRequest;
        int i;
        Object obj2 = this.mUrlRequestAdapterLock;
        synchronized (obj2) {
            try {
                try {
                    checkNotStarted();
                    try {
                        try {
                            obj = obj2;
                            try {
                                cronetUrlRequest = this;
                                try {
                                    cronetUrlRequest.mUrlRequestAdapter = CronetUrlRequestJni.get().createRequestAdapter(this, this.mRequestContext.getUrlRequestContextAdapter(), this.mInitialUrl, this.mPriority, this.mRequestFlag, this.mDisableCache, this.mDisableConnectionMigration, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mIdempotency, this.mNetworkHandle);
                                    cronetUrlRequest.mRequestContext.onRequestStarted();
                                    if (cronetUrlRequest.mInitialMethod != null && !CronetUrlRequestJni.get().setHttpMethod(cronetUrlRequest.mUrlRequestAdapter, cronetUrlRequest, cronetUrlRequest.mInitialMethod)) {
                                        throw new IllegalArgumentException("Invalid http method " + cronetUrlRequest.mInitialMethod);
                                    }
                                    Iterator<Map.Entry<String, String>> it = cronetUrlRequest.mRequestHeaders.iterator();
                                    boolean z = false;
                                    while (it.hasNext()) {
                                        Map.Entry<String, String> next = it.next();
                                        if (next.getKey().equalsIgnoreCase("Content-Type") && !next.getValue().isEmpty()) {
                                            z = true;
                                        }
                                        if (next.getKey().equalsIgnoreCase("Tt-Map-Key") && !next.getValue().isEmpty()) {
                                            cronetUrlRequest.mCronetMapKey = next.getValue();
                                        }
                                        if (!CronetUrlRequestJni.get().addRequestHeader(cronetUrlRequest.mUrlRequestAdapter, this, next.getKey(), next.getValue())) {
                                            throw new IllegalArgumentException("Invalid header " + next.getKey() + "=" + next.getValue());
                                        }
                                    }
                                    CronetUrlRequestJni.get().setSocketTimeout(cronetUrlRequest.mUrlRequestAdapter, this, cronetUrlRequest.mSocketConnectTimeout, cronetUrlRequest.mSocketReadTimeout, cronetUrlRequest.mSocketWriteTimeout);
                                    Natives natives = CronetUrlRequestJni.get();
                                    long j = cronetUrlRequest.mUrlRequestAdapter;
                                    natives.setRequestTimeout(j, cronetUrlRequest, cronetUrlRequest.mRequestTimeout);
                                    int i2 = j;
                                    if (cronetUrlRequest.mThrottleNetSpeed > 0) {
                                        Natives natives2 = CronetUrlRequestJni.get();
                                        natives2.setThrottleNetSpeed(cronetUrlRequest.mUrlRequestAdapter, this, cronetUrlRequest.mThrottleNetSpeed);
                                        i2 = natives2;
                                    }
                                    int i3 = i2;
                                    if (cronetUrlRequest.mRequestTypeFlags > 0) {
                                        Natives natives3 = CronetUrlRequestJni.get();
                                        long j2 = cronetUrlRequest.mUrlRequestAdapter;
                                        natives3.setRequestTypeFlags(j2, cronetUrlRequest, cronetUrlRequest.mRequestTypeFlags);
                                        i3 = j2;
                                    }
                                    i = i3;
                                    if (cronetUrlRequest.mAuthCertUsername != null) {
                                        i = i3;
                                        if (cronetUrlRequest.mAuthCertPassword != null) {
                                            Natives natives4 = CronetUrlRequestJni.get();
                                            natives4.setAuthCredentials(cronetUrlRequest.mUrlRequestAdapter, this, cronetUrlRequest.mAuthCertUsername, cronetUrlRequest.mAuthCertPassword);
                                            i = natives4;
                                        }
                                    }
                                    CronetUploadDataStream cronetUploadDataStream = cronetUrlRequest.mUploadDataStream;
                                    if (cronetUploadDataStream != null) {
                                        try {
                                            if (!z) {
                                                throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                                            }
                                            cronetUrlRequest.mStarted = true;
                                            cronetUploadDataStream.postTaskToExecutor(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequest.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    CronetUrlRequest.this.mUploadDataStream.initializeWithRequest();
                                                    synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                                                        if (CronetUrlRequest.this.isDoneLocked()) {
                                                            return;
                                                        }
                                                        CronetUrlRequest.this.mUploadDataStream.attachNativeAdapterToRequest(CronetUrlRequest.this.mUrlRequestAdapter);
                                                        CronetUrlRequest.this.startInternalLocked();
                                                    }
                                                }
                                            });
                                            return;
                                        } catch (RuntimeException e) {
                                            e = e;
                                            cronetUrlRequest.destroyRequestAdapterLocked(i);
                                            throw e;
                                        }
                                    }
                                    cronetUrlRequest.mStarted = true;
                                    startInternalLocked();
                                } catch (RuntimeException e2) {
                                    e = e2;
                                    cronetUrlRequest = cronetUrlRequest;
                                    i = 1;
                                    cronetUrlRequest.destroyRequestAdapterLocked(i);
                                    throw e;
                                }
                            } catch (RuntimeException e3) {
                                e = e3;
                                i = 1;
                                cronetUrlRequest = this;
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (RuntimeException e4) {
                            e = e4;
                            cronetUrlRequest = this;
                        } catch (Throwable th2) {
                            th = th2;
                            obj = obj2;
                        }
                    } catch (RuntimeException e5) {
                        e = e5;
                        cronetUrlRequest = this;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                obj = obj2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInternalLocked() {
        String str = this.mCronetMapKey;
        if (str != null) {
            CronetUrlRequestMapping.AddRequest(str, this);
        }
        CronetUrlRequestJni.get().start(this.mUrlRequestAdapter, this);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void followRedirect() {
        synchronized (this.mUrlRequestAdapterLock) {
            if (!this.mWaitingOnRedirect) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.mWaitingOnRedirect = false;
            if (isDoneLocked()) {
                return;
            }
            CronetUrlRequestJni.get().followDeferredRedirect(this.mUrlRequestAdapter, this);
        }
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void read(ByteBuffer byteBuffer) {
        Preconditions.checkHasRemaining(byteBuffer);
        Preconditions.checkDirect(byteBuffer);
        synchronized (this.mUrlRequestAdapterLock) {
            if (!this.mWaitingOnRead) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.mWaitingOnRead = false;
            if (isDoneLocked()) {
                return;
            }
            RecordReadResponseBodyStart();
            if (CronetUrlRequestJni.get().readData(this.mUrlRequestAdapter, this, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                return;
            }
            this.mWaitingOnRead = true;
            MaybeRecordReadResponseBodyEnd();
            throw new IllegalArgumentException("Unable to call native read");
        }
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void cancel() {
        synchronized (this.mUrlRequestAdapterLock) {
            if (!isDoneLocked() && this.mStarted) {
                destroyRequestAdapterLocked(2);
            }
        }
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public boolean isDone() {
        boolean isDoneLocked;
        synchronized (this.mUrlRequestAdapterLock) {
            isDoneLocked = isDoneLocked();
        }
        return isDoneLocked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDoneLocked() {
        return this.mStarted && this.mUrlRequestAdapter == 0;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void getStatus(UrlRequest.StatusListener statusListener) {
        final VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener = new VersionSafeCallbacks.UrlRequestStatusListener(statusListener);
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mUrlRequestAdapter != 0) {
                CronetUrlRequestJni.get().getStatus(this.mUrlRequestAdapter, this, urlRequestStatusListener);
            } else {
                postTaskToExecutor(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequest.2
                    @Override // java.lang.Runnable
                    public void run() {
                        urlRequestStatusListener.onStatus(-1);
                    }
                });
            }
        }
    }

    public void setOnDestroyedCallbackForTesting(Runnable runnable) {
        synchronized (this.mUrlRequestAdapterLock) {
            this.mOnDestroyedCallbackForTesting = runnable;
        }
    }

    public void setOnDestroyedUploadCallbackForTesting(Runnable runnable) {
        this.mUploadDataStream.setOnDestroyedCallbackForTesting(runnable);
    }

    public long getUrlRequestAdapterForTesting() {
        long j;
        synchronized (this.mUrlRequestAdapterLock) {
            j = this.mUrlRequestAdapter;
        }
        return j;
    }

    private void postTaskToExecutor(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            Log.m282e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e);
            failWithException(new CronetExceptionImpl("Exception posting task to executor", e));
        }
    }

    static long estimateHeadersSizeInBytes(Map<String, List<String>> map) {
        long j = 0;
        if (map == null) {
            return 0L;
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                j += r3.length();
            }
            if (entry.getValue() != null) {
                while (entry.getValue().iterator().hasNext()) {
                    j += r2.next().length();
                }
            }
        }
        return j;
    }

    static long estimateHeadersSizeInBytes(HeadersList headersList) {
        long j = 0;
        if (headersList == null) {
            return 0L;
        }
        Iterator<Map.Entry<String, String>> it = headersList.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (next.getKey() != null) {
                j += r3.length();
            }
            if (next.getValue() != null) {
                j += next.getValue().length();
            }
        }
        return j;
    }

    private UrlResponseInfoImpl prepareResponseInfoOnNetworkThread(int i, String str, String[] strArr, boolean z, String str2, String str3, long j) {
        HeadersList headersList = new HeadersList();
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            headersList.add(new AbstractMap.SimpleImmutableEntry(strArr[i2], strArr[i2 + 1]));
        }
        return new UrlResponseInfoImpl(new ArrayList(this.mUrlChain), i, str, headersList, z, str2, str3, j);
    }

    private void checkNotStarted() {
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mStarted || isDoneLocked()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyRequestAdapterLocked(int i) {
        this.mFinishedReason = i;
        if (this.mUrlRequestAdapter == 0) {
            return;
        }
        this.mRequestContext.onRequestDestroyed();
        CronetUrlRequestJni.get().destroy(this.mUrlRequestAdapter, this, i == 2);
        this.mUrlRequestAdapter = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCallbackException(Exception exc) {
        CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("Exception received from UrlRequest.Callback", exc);
        Log.m282e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", exc);
        failWithException(callbackExceptionImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onUploadException(Throwable th) {
        Log.m282e(CronetUrlRequestContext.LOG_TAG, "Exception in upload method", th);
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mUrlRequestAdapter == 0) {
                return;
            }
            CronetUrlRequestJni.get().abortWhenUploadException(this.mUrlRequestAdapter, this);
        }
    }

    private void failWithException(CronetException cronetException) {
        synchronized (this.mUrlRequestAdapterLock) {
            if (isDoneLocked()) {
                return;
            }
            this.mException = cronetException;
            destroyRequestAdapterLocked(1);
        }
    }

    private void onRedirectReceived(final String str, int i, String str2, String[] strArr, boolean z, String str3, String str4, long j, final String str5) {
        final UrlResponseInfoImpl prepareResponseInfoOnNetworkThread = prepareResponseInfoOnNetworkThread(i, str2, strArr, z, str3, str4, j);
        this.mResponseInfo = prepareResponseInfoOnNetworkThread;
        this.mUrlChain.add(str);
        postTaskToExecutor(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                CronetUrlRequest.this.checkCallingThread();
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (CronetUrlRequest.this.isDoneLocked()) {
                        return;
                    }
                    CronetUrlRequest.this.mWaitingOnRedirect = true;
                    try {
                        CronetUrlRequest.this.mCallback.onRedirectReceived(CronetUrlRequest.this, prepareResponseInfoOnNetworkThread, str, str5);
                    } catch (Exception e) {
                        CronetUrlRequest.this.onCallbackException(e);
                    }
                }
            }
        });
    }

    private void onResponseStarted(int i, String str, String[] strArr, boolean z, String str2, String str3, long j, final String str4) {
        this.mResponseInfo = prepareResponseInfoOnNetworkThread(i, str, strArr, z, str2, str3, j);
        postTaskToExecutor(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                CronetUrlRequest.this.checkCallingThread();
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (CronetUrlRequest.this.isDoneLocked()) {
                        return;
                    }
                    CronetUrlRequest.this.mWaitingOnRead = true;
                    try {
                        VersionSafeCallbacks.UrlRequestCallback urlRequestCallback = CronetUrlRequest.this.mCallback;
                        CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                        urlRequestCallback.onResponseStarted(cronetUrlRequest, cronetUrlRequest.mResponseInfo, str4);
                    } catch (Exception e) {
                        CronetUrlRequest.this.onCallbackException(e);
                    }
                }
            }
        });
    }

    private void onReadCompleted(ByteBuffer byteBuffer, int i, int i2, int i3, long j) {
        this.mResponseInfo.setReceivedByteCount(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
            return;
        }
        if (this.mOnReadCompletedTask == null) {
            this.mOnReadCompletedTask = new OnReadCompletedRunnable();
        }
        byteBuffer.position(i2 + i);
        this.mOnReadCompletedTask.mByteBuffer = byteBuffer;
        MaybeRecordReadResponseBodyEnd();
        postTaskToExecutor(this.mOnReadCompletedTask);
    }

    private void onSucceeded(long j) {
        this.mResponseInfo.setReceivedByteCount(j);
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        Runnable runnable = new Runnable() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (CronetUrlRequest.this.isDoneLocked()) {
                        return;
                    }
                    CronetUrlRequest.this.destroyRequestAdapterLocked(0);
                    try {
                        VersionSafeCallbacks.UrlRequestCallback urlRequestCallback = CronetUrlRequest.this.mCallback;
                        CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                        urlRequestCallback.onSucceeded(cronetUrlRequest, cronetUrlRequest.mResponseInfo);
                        CronetUrlRequest.this.maybeReportMetrics();
                    } catch (Exception e) {
                        Log.m282e(CronetUrlRequestContext.LOG_TAG, "Exception in onSucceeded method", e);
                    }
                }
            }
        };
        MaybeRecordReadResponseBodyEnd();
        postTaskToExecutor(runnable);
    }

    private void onError(int i, int i2, int i3, String str, long j) {
        UrlResponseInfoImpl urlResponseInfoImpl = this.mResponseInfo;
        if (urlResponseInfoImpl != null) {
            urlResponseInfoImpl.setReceivedByteCount(j);
        }
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        if (i == 10 || i == 3) {
            failWithException(new QuicExceptionImpl("Exception in CronetUrlRequest: " + str, i, i2, i3));
        } else {
            failWithException(new NetworkExceptionImpl("Exception in CronetUrlRequest: " + str, mapUrlRequestErrorToApiErrorCode(i), i2));
        }
    }

    private void onCanceled() {
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        Runnable runnable = new Runnable() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    VersionSafeCallbacks.UrlRequestCallback urlRequestCallback = CronetUrlRequest.this.mCallback;
                    CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                    urlRequestCallback.onCanceled(cronetUrlRequest, cronetUrlRequest.mResponseInfo);
                    CronetUrlRequest.this.maybeReportMetrics();
                } catch (Exception e) {
                    Log.m282e(CronetUrlRequestContext.LOG_TAG, "Exception in onCanceled method", e);
                }
            }
        };
        MaybeRecordReadResponseBodyEnd();
        postTaskToExecutor(runnable);
    }

    private void onStatus(final VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener, final int i) {
        postTaskToExecutor(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequest.7
            @Override // java.lang.Runnable
            public void run() {
                urlRequestStatusListener.onStatus(UrlRequestBase.convertLoadState(i));
            }
        });
    }

    private void onMetricsCollected(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15, String str, long j16, long j17, String str2, String str3, String str4, String str5, boolean z2, boolean z3, int i, boolean z4, boolean z5) {
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mMetrics != null) {
                throw new IllegalStateException("Metrics collection should only happen once.");
            }
            CronetMetrics cronetMetrics = new CronetMetrics(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, z, j14, j15, str, j16, j17, str2, str3, this.mAddCookieCostUs, this.mSaveCookieCostUs, this.mRequestCookieSource, z2, z3, i);
            this.mMetrics = cronetMetrics;
            cronetMetrics.setRequestLog(str5);
            this.mFinalUrl = str4;
            this.mQuicConnectionMigrationAttempted = z4;
            this.mQuicConnectionMigrationSuccessful = z5;
        }
    }

    private void onNativeAdapterDestroyed() {
        synchronized (this.mUrlRequestAdapterLock) {
            Runnable runnable = this.mOnDestroyedCallbackForTesting;
            if (runnable != null) {
                runnable.run();
            }
            if (this.mException == null) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequest.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        VersionSafeCallbacks.UrlRequestCallback urlRequestCallback = CronetUrlRequest.this.mCallback;
                        CronetUrlRequest cronetUrlRequest = CronetUrlRequest.this;
                        urlRequestCallback.onFailed(cronetUrlRequest, cronetUrlRequest.mResponseInfo, CronetUrlRequest.this.mException);
                        CronetUrlRequest.this.maybeReportMetrics();
                    } catch (Exception e) {
                        Log.m282e(CronetUrlRequestContext.LOG_TAG, "Exception in onFailed method", e);
                    }
                }
            };
            try {
                MaybeRecordReadResponseBodyEnd();
                this.mExecutor.execute(runnable2);
            } catch (RejectedExecutionException e) {
                Log.m282e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkCallingThread() {
        if (!this.mAllowDirectExecutor && this.mRequestContext.isNetworkThread(Thread.currentThread())) {
            throw new InlineExecutionProhibitedException();
        }
    }

    private int mapUrlRequestErrorToApiErrorCode(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 10;
            case 11:
                return 11;
            default:
                Log.m282e(CronetUrlRequestContext.LOG_TAG, "Unknown error code: " + i, new Object[0]);
                return i;
        }
    }

    private CronetLogger.CronetTrafficInfo buildCronetTrafficInfo() {
        Map<String, List<String>> emptyMap;
        String str;
        boolean z;
        int i;
        long estimateHeadersSizeInBytes;
        long max;
        long estimateHeadersSizeInBytes2;
        long max2;
        Duration ofSeconds;
        Duration ofSeconds2;
        UrlResponseInfoImpl urlResponseInfoImpl = this.mResponseInfo;
        if (urlResponseInfoImpl != null) {
            emptyMap = urlResponseInfoImpl.getAllHeaders();
            String negotiatedProtocol = this.mResponseInfo.getNegotiatedProtocol();
            int httpStatusCode = this.mResponseInfo.getHttpStatusCode();
            z = this.mResponseInfo.wasCached();
            str = negotiatedProtocol;
            i = httpStatusCode;
        } else {
            emptyMap = Collections.emptyMap();
            str = "";
            z = false;
            i = 0;
        }
        long longValue = this.mMetrics.getSentByteCount().longValue();
        if (z && longValue == 0) {
            estimateHeadersSizeInBytes = 0;
            max = 0;
        } else {
            estimateHeadersSizeInBytes = estimateHeadersSizeInBytes(this.mRequestHeaders);
            max = Math.max(0L, longValue - estimateHeadersSizeInBytes);
        }
        long longValue2 = this.mMetrics.getReceivedByteCount().longValue();
        if (z && longValue2 == 0) {
            estimateHeadersSizeInBytes2 = 0;
            max2 = 0;
        } else {
            estimateHeadersSizeInBytes2 = estimateHeadersSizeInBytes(emptyMap);
            max2 = Math.max(0L, longValue2 - estimateHeadersSizeInBytes2);
        }
        if (this.mMetrics.getRequestStart() != null && this.mMetrics.getResponseStart() != null) {
            ofSeconds = Duration.ofMillis(this.mMetrics.getResponseStart().getTime() - this.mMetrics.getRequestStart().getTime());
        } else {
            ofSeconds = Duration.ofSeconds(0L);
        }
        if (this.mMetrics.getRequestStart() != null && this.mMetrics.getRequestEnd() != null) {
            ofSeconds2 = Duration.ofMillis(this.mMetrics.getRequestEnd().getTime() - this.mMetrics.getRequestStart().getTime());
        } else {
            ofSeconds2 = Duration.ofSeconds(0L);
        }
        return new CronetLogger.CronetTrafficInfo(estimateHeadersSizeInBytes, max, estimateHeadersSizeInBytes2, max2, i, ofSeconds, ofSeconds2, str, this.mQuicConnectionMigrationAttempted, this.mQuicConnectionMigrationSuccessful);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeReportMetrics() {
        if (this.mMetrics != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    this.mLogger.logCronetTrafficInfo(this.mCronetEngineId, buildCronetTrafficInfo());
                } catch (RuntimeException e) {
                    Log.m282e(CronetUrlRequestContext.LOG_TAG, "Error while trying to log CronetTrafficInfo: ", e);
                }
            }
            this.mMetrics.setReadResponseBodyMetrics(this.mResponseBodyReadTimes, this.mFirstReadResponseBodyStart, this.mLastReadResponseBodyEnd, this.mReadResponseBodyDuration, this.mBizReadResponseBodyInterval);
            final RequestFinishedInfoImpl requestFinishedInfoImpl = new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, this.mFinishedReason, this.mResponseInfo, this.mException);
            this.mRequestContext.reportRequestFinished(requestFinishedInfoImpl);
            VersionSafeCallbacks.RequestFinishedInfoListener requestFinishedInfoListener = this.mRequestFinishedListener;
            if (requestFinishedInfoListener != null) {
                try {
                    requestFinishedInfoListener.getExecutor().execute(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.CronetUrlRequest.9
                        @Override // java.lang.Runnable
                        public void run() {
                            CronetUrlRequest.this.mRequestFinishedListener.onRequestFinished(requestFinishedInfoImpl);
                        }
                    });
                } catch (RejectedExecutionException e2) {
                    Log.m282e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e2);
                }
            }
        }
    }
}
