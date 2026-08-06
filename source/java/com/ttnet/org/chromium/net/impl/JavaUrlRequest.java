package com.ttnet.org.chromium.net.impl;

import android.net.TrafficStats;
import android.os.Build;
import android.util.Log;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import com.ttnet.org.chromium.net.ThreadStatsUid;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import com.ttnet.org.chromium.net.impl.CronetLogger;
import com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils;
import com.ttnet.org.chromium.net.impl.VersionSafeCallbacks;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.time.Duration;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class JavaUrlRequest extends UrlRequestBase {
    private static final int DEFAULT_CHUNK_LENGTH = 8192;
    private static final String TAG = "JavaUrlRequest";
    private static final String USER_AGENT = "User-Agent";
    private static final String X_ANDROID = "X-Android";
    private static final String X_ANDROID_SELECTED_TRANSPORT = "X-Android-Selected-Transport";
    private final boolean mAllowDirectExecutor;
    private final AsyncUrlRequestCallback mCallbackAsync;
    private final int mCronetEngineId;
    private String mCurrentUrl;
    private HttpURLConnection mCurrentUrlConnection;
    private final Executor mExecutor;
    private String mInitialMethod;
    private final CronetLogger mLogger;
    private OutputStreamDataSink mOutputStreamDataSink;
    private String mPendingRedirectUrl;
    private ReadableByteChannel mResponseChannel;
    private VersionSafeCallbacks.UploadDataProviderWrapper mUploadDataProvider;
    private Executor mUploadExecutor;
    private UrlResponseInfoImpl mUrlResponseInfo;
    private final String mUserAgent;
    private final Map<String, String> mRequestHeaders = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private final List<String> mUrlChain = new ArrayList();
    private final AtomicInteger mState = new AtomicInteger(0);
    private final AtomicBoolean mUploadProviderClosed = new AtomicBoolean(false);
    private volatile int mAdditionalStatusDetails = -1;

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void AddRequestCookieHeader(String str, String str2) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void RemoveRequestCookieHeader() {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public String getFinalUrl() {
        return "";
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setAddCookieCostUs(long j) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setAuthCredentials(String str, String str2) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestCookieSource(int i) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setRequestTimeout(int i) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestTypeFlags(int i) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setSaveCookieCostUs(long j) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketConnectTimeout(int i) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketReadTimeout(int i) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketWriteTimeout(int i) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setThrottleNetSpeed(long j) {
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static final class SerializingExecutor implements Executor {
        private boolean mRunning;
        private final Executor mUnderlyingExecutor;
        private final Runnable mRunTasks = new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.SerializingExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (SerializingExecutor.this.mTaskQueue) {
                    if (SerializingExecutor.this.mRunning) {
                        return;
                    }
                    Runnable runnable = (Runnable) SerializingExecutor.this.mTaskQueue.pollFirst();
                    SerializingExecutor.this.mRunning = runnable != null;
                    while (runnable != null) {
                        try {
                            runnable.run();
                            synchronized (SerializingExecutor.this.mTaskQueue) {
                                runnable = (Runnable) SerializingExecutor.this.mTaskQueue.pollFirst();
                                SerializingExecutor.this.mRunning = runnable != null;
                            }
                        } catch (Throwable th) {
                            synchronized (SerializingExecutor.this.mTaskQueue) {
                                SerializingExecutor.this.mRunning = false;
                                try {
                                    SerializingExecutor.this.mUnderlyingExecutor.execute(SerializingExecutor.this.mRunTasks);
                                } catch (RejectedExecutionException unused) {
                                }
                                throw th;
                            }
                        }
                    }
                }
            }
        };
        private final ArrayDeque<Runnable> mTaskQueue = new ArrayDeque<>();

        SerializingExecutor(Executor executor) {
            this.mUnderlyingExecutor = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            synchronized (this.mTaskQueue) {
                this.mTaskQueue.addLast(runnable);
                try {
                    this.mUnderlyingExecutor.execute(this.mRunTasks);
                } catch (RejectedExecutionException unused) {
                    this.mTaskQueue.removeLast();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JavaUrlRequest(JavaCronetEngine javaCronetEngine, UrlRequest.Callback callback, final Executor executor, Executor executor2, String str, String str2, boolean z, boolean z2, int i, final boolean z3, final int i2) {
        if (str == null) {
            throw new NullPointerException("URL is required");
        }
        if (callback == null) {
            throw new NullPointerException("Listener is required");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required");
        }
        if (executor2 == null) {
            throw new NullPointerException("userExecutor is required");
        }
        this.mAllowDirectExecutor = z;
        this.mCallbackAsync = new AsyncUrlRequestCallback(callback, executor2);
        final int threadStatsTag = z2 ? i : TrafficStats.getThreadStatsTag();
        this.mExecutor = new SerializingExecutor(new Executor() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.1
            @Override // java.util.concurrent.Executor
            public void execute(final Runnable runnable) {
                executor.execute(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int threadStatsTag2 = TrafficStats.getThreadStatsTag();
                        TrafficStats.setThreadStatsTag(threadStatsTag);
                        if (z3) {
                            ThreadStatsUid.set(i2);
                        }
                        try {
                            runnable.run();
                        } finally {
                            if (z3) {
                                ThreadStatsUid.clear();
                            }
                            TrafficStats.setThreadStatsTag(threadStatsTag2);
                        }
                    }
                });
            }
        });
        this.mCronetEngineId = javaCronetEngine.getCronetEngineId();
        this.mLogger = javaCronetEngine.getCronetLogger();
        this.mCurrentUrl = str;
        this.mUserAgent = str2;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setHttpMethod(String str) {
        checkNotStarted();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        if ("OPTIONS".equalsIgnoreCase(str) || "GET".equalsIgnoreCase(str) || "HEAD".equalsIgnoreCase(str) || "POST".equalsIgnoreCase(str) || "PUT".equalsIgnoreCase(str) || "DELETE".equalsIgnoreCase(str) || "TRACE".equalsIgnoreCase(str) || "PATCH".equalsIgnoreCase(str)) {
            this.mInitialMethod = str;
            return;
        }
        throw new IllegalArgumentException("Invalid http method " + str);
    }

    private void checkNotStarted() {
        int i = this.mState.get();
        if (i != 0) {
            throw new IllegalStateException("Request is already started. State is: " + i);
        }
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void addHeader(String str, String str2) {
        checkNotStarted();
        if (!isValidHeaderName(str) || str2.contains("\r\n")) {
            throw new IllegalArgumentException("Invalid header " + str + "=" + str2);
        }
        if (this.mRequestHeaders.containsKey(str)) {
            this.mRequestHeaders.remove(str);
        }
        this.mRequestHeaders.put(str, str2);
    }

    private boolean isValidHeaderName(String str) {
        int i;
        for (0; i < str.length(); i + 1) {
            char charAt = str.charAt(i);
            if (charAt != ',' && charAt != '/' && charAt != '{' && charAt != '}') {
                switch (charAt) {
                    case '\'':
                    case '(':
                    case ')':
                        break;
                    default:
                        switch (charAt) {
                            case ':':
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                            case '?':
                            case '@':
                                break;
                            default:
                                switch (charAt) {
                                    case '[':
                                    case '\\':
                                    case ']':
                                        break;
                                    default:
                                        i = (Character.isISOControl(charAt) || Character.isWhitespace(charAt)) ? 0 : i + 1;
                                        break;
                                }
                        }
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (!this.mRequestHeaders.containsKey("Content-Type")) {
            throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
        }
        checkNotStarted();
        if (this.mInitialMethod == null) {
            this.mInitialMethod = "POST";
        }
        this.mUploadDataProvider = new VersionSafeCallbacks.UploadDataProviderWrapper(uploadDataProvider);
        if (this.mAllowDirectExecutor) {
            this.mUploadExecutor = executor;
        } else {
            this.mUploadExecutor = new JavaUrlRequestUtils.DirectPreventingExecutor(executor);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private final class OutputStreamDataSink extends JavaUploadDataSinkBase {
        private WritableByteChannel mOutputChannel;
        private final AtomicBoolean mOutputChannelClosed;
        private final HttpURLConnection mUrlConnection;
        private OutputStream mUrlConnectionOutputStream;

        OutputStreamDataSink(Executor executor, Executor executor2, HttpURLConnection httpURLConnection, VersionSafeCallbacks.UploadDataProviderWrapper uploadDataProviderWrapper) {
            super(executor, executor2, uploadDataProviderWrapper);
            this.mOutputChannelClosed = new AtomicBoolean(false);
            this.mUrlConnection = httpURLConnection;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void initializeRead() throws IOException {
            if (this.mOutputChannel == null) {
                JavaUrlRequest.this.mAdditionalStatusDetails = 10;
                this.mUrlConnection.setDoOutput(true);
                this.mUrlConnection.connect();
                JavaUrlRequest.this.mAdditionalStatusDetails = 12;
                OutputStream outputStream = this.mUrlConnection.getOutputStream();
                this.mUrlConnectionOutputStream = outputStream;
                this.mOutputChannel = Channels.newChannel(outputStream);
            }
        }

        void closeOutputChannel() throws IOException {
            if (this.mOutputChannel == null || !this.mOutputChannelClosed.compareAndSet(false, true)) {
                return;
            }
            this.mOutputChannel.close();
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void finish() throws IOException {
            closeOutputChannel();
            JavaUrlRequest.this.fireGetHeaders();
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void initializeStart(long j) {
            if (j > 0) {
                this.mUrlConnection.setFixedLengthStreamingMode(j);
            } else {
                this.mUrlConnection.setChunkedStreamingMode(8192);
            }
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected int processSuccessfulRead(ByteBuffer byteBuffer) throws IOException {
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                i += this.mOutputChannel.write(byteBuffer);
            }
            this.mUrlConnectionOutputStream.flush();
            return i;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected Runnable getErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable checkedRunnable) {
            return JavaUrlRequest.this.errorSetting(checkedRunnable);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected Runnable getUploadErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable checkedRunnable) {
            return JavaUrlRequest.this.uploadErrorSetting(checkedRunnable);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void processUploadError(Throwable th) {
            JavaUrlRequest.this.enterUploadErrorState(th);
        }
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void start() {
        this.mAdditionalStatusDetails = 10;
        transitionStates(0, 1, new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.2
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest.this.mUrlChain.add(JavaUrlRequest.this.mCurrentUrl);
                JavaUrlRequest.this.fireOpenConnection();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterErrorState(CronetException cronetException) {
        if (setTerminalState(6)) {
            fireDisconnect();
            fireCloseUploadDataProvider();
            this.mCallbackAsync.onFailed(this.mUrlResponseInfo, cronetException);
        }
    }

    private boolean setTerminalState(int i) {
        int i2;
        do {
            i2 = this.mState.get();
            if (i2 == 0) {
                throw new IllegalStateException("Can't enter error state before start");
            }
            if (i2 == 6 || i2 == 7 || i2 == 8) {
                return false;
            }
        } while (!this.mState.compareAndSet(i2, i));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterUserErrorState(Throwable th) {
        enterErrorState(new CallbackExceptionImpl("Exception received from UrlRequest.Callback", th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterUploadErrorState(Throwable th) {
        enterErrorState(new CallbackExceptionImpl("Exception received from UploadDataProvider", th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterCronetErrorState(Throwable th) {
        enterErrorState(new CronetExceptionImpl("System error", th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transitionStates(int i, int i2, Runnable runnable) {
        if (!this.mState.compareAndSet(i, i2)) {
            int i3 = this.mState.get();
            if (i3 != 8 && i3 != 6) {
                throw new IllegalStateException("Invalid state transition - expected " + i + " but was " + i3);
            }
            return;
        }
        runnable.run();
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void followRedirect() {
        transitionStates(3, 1, new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest javaUrlRequest = JavaUrlRequest.this;
                javaUrlRequest.mCurrentUrl = javaUrlRequest.mPendingRedirectUrl;
                JavaUrlRequest.this.mPendingRedirectUrl = null;
                JavaUrlRequest.this.fireOpenConnection();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireGetHeaders() {
        this.mAdditionalStatusDetails = 13;
        this.mExecutor.execute(errorSetting(new JavaUrlRequestUtils.CheckedRunnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.4
            @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
            public void run() throws Exception {
                List<String> list;
                if (JavaUrlRequest.this.mCurrentUrlConnection == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                String str = "http/1.1";
                int i = 0;
                while (true) {
                    String headerFieldKey = JavaUrlRequest.this.mCurrentUrlConnection.getHeaderFieldKey(i);
                    if (headerFieldKey == null) {
                        break;
                    }
                    if (JavaUrlRequest.X_ANDROID_SELECTED_TRANSPORT.equalsIgnoreCase(headerFieldKey)) {
                        str = JavaUrlRequest.this.mCurrentUrlConnection.getHeaderField(i);
                    }
                    if (!headerFieldKey.startsWith(JavaUrlRequest.X_ANDROID)) {
                        arrayList.add(new AbstractMap.SimpleEntry(headerFieldKey, JavaUrlRequest.this.mCurrentUrlConnection.getHeaderField(i)));
                    }
                    i++;
                }
                int responseCode = JavaUrlRequest.this.mCurrentUrlConnection.getResponseCode();
                JavaUrlRequest.this.mUrlResponseInfo = new UrlResponseInfoImpl(new ArrayList(JavaUrlRequest.this.mUrlChain), responseCode, JavaUrlRequest.this.mCurrentUrlConnection.getResponseMessage(), Collections.unmodifiableList(arrayList), false, str, "", 0L);
                if (responseCode < 300 || responseCode >= 400 || (list = JavaUrlRequest.this.mUrlResponseInfo.getAllHeaders().get("location")) == null) {
                    JavaUrlRequest.this.fireCloseUploadDataProvider();
                    if (responseCode >= 400) {
                        InputStream errorStream = JavaUrlRequest.this.mCurrentUrlConnection.getErrorStream();
                        JavaUrlRequest.this.mResponseChannel = errorStream == null ? null : InputStreamChannel.wrap(errorStream);
                        JavaUrlRequest.this.mCallbackAsync.onResponseStarted(JavaUrlRequest.this.mUrlResponseInfo);
                        return;
                    }
                    JavaUrlRequest javaUrlRequest = JavaUrlRequest.this;
                    javaUrlRequest.mResponseChannel = InputStreamChannel.wrap(javaUrlRequest.mCurrentUrlConnection.getInputStream());
                    JavaUrlRequest.this.mCallbackAsync.onResponseStarted(JavaUrlRequest.this.mUrlResponseInfo);
                    return;
                }
                JavaUrlRequest.this.fireRedirectReceived(list.get(0));
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireCloseUploadDataProvider() {
        if (this.mUploadDataProvider == null || !this.mUploadProviderClosed.compareAndSet(false, true)) {
            return;
        }
        try {
            this.mUploadExecutor.execute(uploadErrorSetting(new JavaUrlRequestUtils.CheckedRunnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.5
                @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
                public void run() throws Exception {
                    JavaUrlRequest.this.mUploadDataProvider.close();
                }
            }));
        } catch (RejectedExecutionException e) {
            Log.e(TAG, "Exception when closing uploadDataProvider", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireRedirectReceived(final String str) {
        transitionStates(1, 2, new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest javaUrlRequest = JavaUrlRequest.this;
                javaUrlRequest.mPendingRedirectUrl = URI.create(javaUrlRequest.mCurrentUrl).resolve(str).toString();
                JavaUrlRequest.this.mUrlChain.add(JavaUrlRequest.this.mPendingRedirectUrl);
                JavaUrlRequest.this.transitionStates(2, 3, new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JavaUrlRequest.this.mCallbackAsync.onRedirectReceived(JavaUrlRequest.this.mUrlResponseInfo, JavaUrlRequest.this.mPendingRedirectUrl);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOpenConnection() {
        this.mExecutor.execute(errorSetting(new JavaUrlRequestUtils.CheckedRunnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.7
            @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
            public void run() throws Exception {
                if (JavaUrlRequest.this.mState.get() == 8) {
                    return;
                }
                URL url = new URL(JavaUrlRequest.this.mCurrentUrl);
                if (JavaUrlRequest.this.mCurrentUrlConnection != null) {
                    JavaUrlRequest.this.mCurrentUrlConnection.disconnect();
                    JavaUrlRequest.this.mCurrentUrlConnection = null;
                }
                JavaUrlRequest.this.mCurrentUrlConnection = (HttpURLConnection) url.openConnection();
                JavaUrlRequest.this.mCurrentUrlConnection.setInstanceFollowRedirects(false);
                if (!JavaUrlRequest.this.mRequestHeaders.containsKey("User-Agent")) {
                    JavaUrlRequest.this.mRequestHeaders.put("User-Agent", JavaUrlRequest.this.mUserAgent);
                }
                for (Map.Entry entry : JavaUrlRequest.this.mRequestHeaders.entrySet()) {
                    JavaUrlRequest.this.mCurrentUrlConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (JavaUrlRequest.this.mInitialMethod == null) {
                    JavaUrlRequest.this.mInitialMethod = "GET";
                }
                JavaUrlRequest.this.mCurrentUrlConnection.setRequestMethod(JavaUrlRequest.this.mInitialMethod);
                if (JavaUrlRequest.this.mUploadDataProvider == null) {
                    JavaUrlRequest.this.mAdditionalStatusDetails = 10;
                    JavaUrlRequest.this.mCurrentUrlConnection.connect();
                    JavaUrlRequest.this.fireGetHeaders();
                } else {
                    JavaUrlRequest javaUrlRequest = JavaUrlRequest.this;
                    JavaUrlRequest javaUrlRequest2 = JavaUrlRequest.this;
                    javaUrlRequest.mOutputStreamDataSink = new OutputStreamDataSink(javaUrlRequest2.mUploadExecutor, JavaUrlRequest.this.mExecutor, JavaUrlRequest.this.mCurrentUrlConnection, JavaUrlRequest.this.mUploadDataProvider);
                    JavaUrlRequest.this.mOutputStreamDataSink.start(JavaUrlRequest.this.mUrlChain.size() == 1);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable errorSetting(final JavaUrlRequestUtils.CheckedRunnable checkedRunnable) {
        return new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    checkedRunnable.run();
                } catch (Throwable th) {
                    JavaUrlRequest.this.enterCronetErrorState(th);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable userErrorSetting(final JavaUrlRequestUtils.CheckedRunnable checkedRunnable) {
        return new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    checkedRunnable.run();
                } catch (Throwable th) {
                    JavaUrlRequest.this.enterUserErrorState(th);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable uploadErrorSetting(final JavaUrlRequestUtils.CheckedRunnable checkedRunnable) {
        return new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    checkedRunnable.run();
                } catch (Throwable th) {
                    JavaUrlRequest.this.enterUploadErrorState(th);
                }
            }
        };
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void read(final ByteBuffer byteBuffer) {
        Preconditions.checkDirect(byteBuffer);
        Preconditions.checkHasRemaining(byteBuffer);
        transitionStates(4, 5, new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.11
            @Override // java.lang.Runnable
            public void run() {
                JavaUrlRequest.this.mExecutor.execute(JavaUrlRequest.this.errorSetting(new JavaUrlRequestUtils.CheckedRunnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.11.1
                    @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
                    public void run() throws Exception {
                        JavaUrlRequest.this.processReadResult(JavaUrlRequest.this.mResponseChannel == null ? -1 : JavaUrlRequest.this.mResponseChannel.read(byteBuffer), byteBuffer);
                    }
                }));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processReadResult(int i, ByteBuffer byteBuffer) throws IOException {
        if (i != -1) {
            this.mCallbackAsync.onReadCompleted(this.mUrlResponseInfo, byteBuffer);
            return;
        }
        ReadableByteChannel readableByteChannel = this.mResponseChannel;
        if (readableByteChannel != null) {
            readableByteChannel.close();
        }
        if (this.mState.compareAndSet(5, 7)) {
            fireDisconnect();
            this.mCallbackAsync.onSucceeded(this.mUrlResponseInfo);
        }
    }

    private void fireDisconnect() {
        this.mExecutor.execute(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.12
            @Override // java.lang.Runnable
            public void run() {
                if (JavaUrlRequest.this.mOutputStreamDataSink != null) {
                    try {
                        JavaUrlRequest.this.mOutputStreamDataSink.closeOutputChannel();
                    } catch (IOException e) {
                        Log.e(JavaUrlRequest.TAG, "Exception when closing OutputChannel", e);
                    }
                }
                if (JavaUrlRequest.this.mCurrentUrlConnection != null) {
                    JavaUrlRequest.this.mCurrentUrlConnection.disconnect();
                    JavaUrlRequest.this.mCurrentUrlConnection = null;
                }
            }
        });
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void cancel() {
        int andSet = this.mState.getAndSet(8);
        if (andSet == 1 || andSet == 2 || andSet == 3 || andSet == 4 || andSet == 5) {
            fireDisconnect();
            fireCloseUploadDataProvider();
            this.mCallbackAsync.onCanceled(this.mUrlResponseInfo);
        }
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public boolean isDone() {
        int i = this.mState.get();
        return i == 7 || i == 6 || i == 8;
    }

    static long estimateHeadersSizeInBytesList(Map<String, List<String>> map) {
        long j = 0;
        if (map == null) {
            return 0L;
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                j += r3.length();
            }
            if (entry.getValue() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    if (it.next() != null) {
                        j += r3.length();
                    }
                }
            }
        }
        return j;
    }

    static long estimateHeadersSizeInBytes(Map<String, String> map) {
        long j = 0;
        if (map == null) {
            return 0L;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                j += r3.length();
            }
            if (entry.getValue() != null) {
                j += r2.length();
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long parseContentLengthString(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void getStatus(UrlRequest.StatusListener statusListener) {
        int i = this.mState.get();
        int i2 = this.mAdditionalStatusDetails;
        switch (i) {
            case 0:
            case 6:
            case 7:
            case 8:
                i2 = -1;
                break;
            case 1:
                break;
            case 2:
            case 3:
            case 4:
                i2 = 0;
                break;
            case 5:
                i2 = 14;
                break;
            default:
                throw new IllegalStateException("Switch is exhaustive: " + i);
        }
        this.mCallbackAsync.sendStatus(new VersionSafeCallbacks.UrlRequestStatusListener(statusListener), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public final class AsyncUrlRequestCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final VersionSafeCallbacks.UrlRequestCallback mCallback;
        final Executor mFallbackExecutor;
        final Executor mUserExecutor;

        AsyncUrlRequestCallback(UrlRequest.Callback callback, Executor executor) {
            this.mCallback = new VersionSafeCallbacks.UrlRequestCallback(callback);
            if (JavaUrlRequest.this.mAllowDirectExecutor) {
                this.mUserExecutor = executor;
                this.mFallbackExecutor = null;
            } else {
                this.mUserExecutor = new JavaUrlRequestUtils.DirectPreventingExecutor(executor);
                this.mFallbackExecutor = executor;
            }
        }

        void sendStatus(final VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener, final int i) {
            this.mUserExecutor.execute(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    urlRequestStatusListener.onStatus(i);
                }
            });
        }

        void execute(JavaUrlRequestUtils.CheckedRunnable checkedRunnable) {
            try {
                this.mUserExecutor.execute(JavaUrlRequest.this.userErrorSetting(checkedRunnable));
            } catch (RejectedExecutionException e) {
                JavaUrlRequest.this.enterErrorState(new CronetExceptionImpl("Exception posting task to executor", e));
            }
        }

        void onRedirectReceived(final UrlResponseInfo urlResponseInfo, final String str) {
            execute(new JavaUrlRequestUtils.CheckedRunnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.2
                @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
                public void run() throws Exception {
                    AsyncUrlRequestCallback.this.mCallback.onRedirectReceived(JavaUrlRequest.this, urlResponseInfo, str, "");
                }
            });
        }

        void onResponseStarted(UrlResponseInfo urlResponseInfo) {
            execute(new JavaUrlRequestUtils.CheckedRunnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.3
                @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
                public void run() throws Exception {
                    if (JavaUrlRequest.this.mState.compareAndSet(1, 4)) {
                        AsyncUrlRequestCallback.this.mCallback.onResponseStarted(JavaUrlRequest.this, JavaUrlRequest.this.mUrlResponseInfo, "");
                    }
                }
            });
        }

        void onReadCompleted(final UrlResponseInfo urlResponseInfo, final ByteBuffer byteBuffer) {
            execute(new JavaUrlRequestUtils.CheckedRunnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.4
                @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
                public void run() throws Exception {
                    if (JavaUrlRequest.this.mState.compareAndSet(5, 4)) {
                        AsyncUrlRequestCallback.this.mCallback.onReadCompleted(JavaUrlRequest.this, urlResponseInfo, byteBuffer);
                    }
                }
            });
        }

        private CronetLogger.CronetTrafficInfo buildCronetTrafficInfo() {
            Map<String, List<String>> emptyMap;
            boolean z;
            int i;
            String str;
            long estimateHeadersSizeInBytes;
            long j;
            long estimateHeadersSizeInBytesList;
            long parseContentLengthString;
            if (JavaUrlRequest.this.mUrlResponseInfo != null) {
                emptyMap = JavaUrlRequest.this.mUrlResponseInfo.getAllHeaders();
                String negotiatedProtocol = JavaUrlRequest.this.mUrlResponseInfo.getNegotiatedProtocol();
                int httpStatusCode = JavaUrlRequest.this.mUrlResponseInfo.getHttpStatusCode();
                z = JavaUrlRequest.this.mUrlResponseInfo.wasCached();
                str = negotiatedProtocol;
                i = httpStatusCode;
            } else {
                emptyMap = Collections.emptyMap();
                z = false;
                i = 0;
                str = "";
            }
            if (z) {
                estimateHeadersSizeInBytes = 0;
                j = 0;
            } else {
                estimateHeadersSizeInBytes = JavaUrlRequest.estimateHeadersSizeInBytes(JavaUrlRequest.this.mRequestHeaders);
                j = -1;
            }
            if (z) {
                parseContentLengthString = 0;
                estimateHeadersSizeInBytesList = 0;
            } else {
                estimateHeadersSizeInBytesList = JavaUrlRequest.estimateHeadersSizeInBytesList(emptyMap);
                parseContentLengthString = emptyMap.containsKey("Content-Length") ? JavaUrlRequest.parseContentLengthString(emptyMap.get("Content-Length").get(0)) : -1L;
            }
            return new CronetLogger.CronetTrafficInfo(estimateHeadersSizeInBytes, j, estimateHeadersSizeInBytesList, parseContentLengthString, i, Duration.ofSeconds(0L), Duration.ofSeconds(0L), str, false, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void maybeReportMetrics() {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    JavaUrlRequest.this.mLogger.logCronetTrafficInfo(JavaUrlRequest.this.mCronetEngineId, buildCronetTrafficInfo());
                } catch (RuntimeException e) {
                    Log.e(JavaUrlRequest.TAG, "Error while trying to log CronetTrafficInfo: ", e);
                }
            }
        }

        void onCanceled(final UrlResponseInfo urlResponseInfo) {
            JavaUrlRequest.this.closeResponseChannel();
            this.mUserExecutor.execute(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AsyncUrlRequestCallback.this.mCallback.onCanceled(JavaUrlRequest.this, urlResponseInfo);
                        AsyncUrlRequestCallback.this.maybeReportMetrics();
                    } catch (Exception e) {
                        Log.e(JavaUrlRequest.TAG, "Exception in onCanceled method", e);
                    }
                }
            });
        }

        void onSucceeded(final UrlResponseInfo urlResponseInfo) {
            this.mUserExecutor.execute(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AsyncUrlRequestCallback.this.mCallback.onSucceeded(JavaUrlRequest.this, urlResponseInfo);
                        AsyncUrlRequestCallback.this.maybeReportMetrics();
                    } catch (Exception e) {
                        Log.e(JavaUrlRequest.TAG, "Exception in onSucceeded method", e);
                    }
                }
            });
        }

        void onFailed(final UrlResponseInfo urlResponseInfo, final CronetException cronetException) {
            JavaUrlRequest.this.closeResponseChannel();
            Runnable runnable = new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.AsyncUrlRequestCallback.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AsyncUrlRequestCallback.this.mCallback.onFailed(JavaUrlRequest.this, urlResponseInfo, cronetException);
                        AsyncUrlRequestCallback.this.maybeReportMetrics();
                    } catch (Exception e) {
                        Log.e(JavaUrlRequest.TAG, "Exception in onFailed method", e);
                    }
                }
            };
            try {
                this.mUserExecutor.execute(runnable);
            } catch (InlineExecutionProhibitedException unused) {
                Executor executor = this.mFallbackExecutor;
                if (executor != null) {
                    executor.execute(runnable);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeResponseChannel() {
        this.mExecutor.execute(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.JavaUrlRequest.13
            @Override // java.lang.Runnable
            public void run() {
                if (JavaUrlRequest.this.mResponseChannel != null) {
                    try {
                        JavaUrlRequest.this.mResponseChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    JavaUrlRequest.this.mResponseChannel = null;
                }
            }
        });
    }
}
