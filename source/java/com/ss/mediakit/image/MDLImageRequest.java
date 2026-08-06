package com.ss.mediakit.image;

import android.util.Log;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes7.dex */
public class MDLImageRequest {
    static final String TAG = "Image.MDLRequest";
    static AtomicLong mTaskCnt = new AtomicLong(0);
    private MDLCallback mCallback;
    private final LoaderConfig mConfig;
    private final ImageLoader mImageLoader;
    private final AVMDLDataLoader mInnerDataLoader;
    private AVMDLDataLoader.MDLDownloader.MDLDownloadTask mMDLTask;
    private final ScheduledExecutorService mScheduledExecutorService;
    private ScheduledFuture<?> mScheduledTask;
    final long mTaskId = mTaskCnt.getAndIncrement();
    private final AtomicBoolean mIsCanceled = new AtomicBoolean(false);
    private final AtomicBoolean mIsStopped = new AtomicBoolean(false);

    public MDLImageRequest() {
        ImageLoader imageLoader = ImageLoader.get();
        this.mImageLoader = imageLoader;
        this.mInnerDataLoader = imageLoader.getInnerDataLoader();
        this.mScheduledExecutorService = imageLoader.getScheduledExecutorService();
        this.mConfig = imageLoader.getConfig();
    }

    public synchronized void start(final String str, final Map<String, String> map, final Map<String, String> map2, final String str2, final MDLCallback mDLCallback) {
        Log.i(TAG, "[TaskId:" + this.mTaskId + "] call start");
        if (mDLCallback == null) {
            Log.e(TAG, "[TaskId:" + this.mTaskId + "] Callback is null.");
            return;
        }
        this.mCallback = mDLCallback;
        if (this.mIsCanceled.get() && markAsStopped()) {
            Log.i(TAG, "[TaskId:" + this.mTaskId + "] request has been canceled, stop request.");
            stop(0);
            this.mCallback.onFailure(-2, -999, "User cancelled", null);
            return;
        }
        int retryCount = this.mImageLoader.getRetryCount(map2);
        int connectTimeOut = this.mConfig.getConnectTimeOut(retryCount);
        int readTimeOut = this.mConfig.getReadTimeOut(retryCount);
        map2.put("task:connect_timeout", String.valueOf(connectTimeOut));
        map2.put("read:timeout", String.valueOf(readTimeOut));
        if (retryCount > 0) {
            long delayMs = this.mImageLoader.getDelayMs(retryCount);
            Log.i(TAG, "[TaskId:" + this.mTaskId + "] retryCount:" + retryCount + ", set delay mdl task, delay time:" + delayMs + "ms");
            this.mScheduledTask = this.mScheduledExecutorService.schedule(new Runnable() { // from class: com.ss.mediakit.image.MDLImageRequest$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MDLImageRequest.this.m9486lambda$start$0$comssmediakitimageMDLImageRequest(str, map, map2, str2, mDLCallback);
                }
            }, delayMs, TimeUnit.MILLISECONDS);
        } else {
            mdlRequestStart(str, map, map2, str2, mDLCallback);
        }
    }

    public synchronized void cancel() {
        Log.i(TAG, "[TaskId:" + this.mTaskId + "] call cancel");
        this.mIsCanceled.set(true);
        if (this.mCallback != null && markAsStopped()) {
            stop(0);
            this.mCallback.onFailure(-2, -999, "User cancelled", null);
        }
    }

    public boolean isCanceled() {
        return this.mIsCanceled.get();
    }

    private void mdlRequestStart(String str, Map<String, String> map, Map<String, String> map2, String str2, MDLCallback mDLCallback) {
        Log.i(TAG, "[TaskId:" + this.mTaskId + "] mdl request start.");
        if (this.mInnerDataLoader == null) {
            Log.e(TAG, "[TaskId:" + this.mTaskId + "] AVMDLDataLoader is null, start error!");
            return;
        }
        int bid = this.mImageLoader.getBid(str);
        AVMDLDataLoader.MDLDownloader downloader = this.mInnerDataLoader.getDownloader(bid, null);
        AVMDLDataLoader.MDLDownloader.MDLDownloadTask createTask = downloader.createTask(bid, str, map, map2, str2);
        this.mMDLTask = createTask;
        downloader.getClass();
        createTask.asyncStart(new AnonymousClass1(downloader));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.mediakit.image.MDLImageRequest$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass1 extends AVMDLDataLoader.MDLDownloader.MDLTaskCallback {
        int errcode;

        @Override // com.ss.mediakit.medialoader.AVMDLDataLoader.MDLDownloader.MDLTaskCallback
        public int onData(int i, long j, long j2, byte[] bArr) {
            return 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AVMDLDataLoader.MDLDownloader mDLDownloader) {
            super();
            mDLDownloader.getClass();
            this.errcode = 0;
        }

        @Override // com.ss.mediakit.medialoader.AVMDLDataLoader.MDLDownloader.MDLTaskCallback
        public int onInfos(int i, String str, String str2) {
            if (MDLImageRequest.this.mIsStopped.get() || MDLImageRequest.this.mCallback == null) {
                return 0;
            }
            MDLImageRequest.this.mCallback.onInfos(i, str, str2);
            return 0;
        }

        @Override // com.ss.mediakit.medialoader.AVMDLDataLoader.MDLDownloader.MDLTaskCallback
        public int onResponse(final int i, final int i2, final long j, final String str) {
            Log.i(MDLImageRequest.TAG, "[TaskId:" + MDLImageRequest.this.mTaskId + "] code:" + i + ", httpCode:" + i2 + ", fileLen: " + j);
            MDLImageRequest.this.mScheduledExecutorService.execute(new Runnable() { // from class: com.ss.mediakit.image.MDLImageRequest.1.1
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap = new HashMap();
                    for (String str2 : str.split("\r\n")) {
                        String[] split = str2.split(": ", 2);
                        if (split.length == 2) {
                            hashMap.put(split[0], split[1]);
                        }
                    }
                    MDLImageRequest.this.mCallback.onHeaders(i, i2, hashMap);
                    MDLImageRequest.this.mCallback.onResponse(i2, new InputStream() { // from class: com.ss.mediakit.image.MDLImageRequest.1.1.1
                        final int fileLength;
                        int timeout = 2000;
                        int offset = 0;

                        @Override // java.io.InputStream
                        public int available() throws IOException {
                            return 1000;
                        }

                        @Override // java.io.InputStream
                        public long skip(long j2) throws IOException {
                            return -1L;
                        }

                        {
                            this.fileLength = (int) j;
                        }

                        @Override // java.io.InputStream
                        public int read() throws IOException {
                            if (MDLImageRequest.this.markAsStopped()) {
                                MDLImageRequest.this.stop(0);
                            }
                            throw new IOException("MDL not support");
                        }

                        @Override // java.io.InputStream
                        public int read(byte[] bArr, int i3, int i4) throws IOException {
                            if (MDLImageRequest.this.markAsStopped()) {
                                MDLImageRequest.this.stop(0);
                            }
                            throw new IOException("MDL not support");
                        }

                        @Override // java.io.InputStream
                        public int read(byte[] bArr) throws IOException {
                            if (MDLImageRequest.this.mIsStopped.get() || MDLImageRequest.this.mMDLTask == null) {
                                if (MDLImageRequest.this.markAsStopped()) {
                                    MDLImageRequest.this.stop(0);
                                }
                                throw new IOException("MDL Stream is closed. mIsStopped:" + MDLImageRequest.this.mIsStopped.get());
                            }
                            if (bArr == null) {
                                if (MDLImageRequest.this.markAsStopped()) {
                                    MDLImageRequest.this.stop(0);
                                }
                                throw new NullPointerException("Buffer cannot be null.");
                            }
                            if (bArr.length == 0) {
                                if (MDLImageRequest.this.markAsStopped()) {
                                    MDLImageRequest.this.stop(0);
                                }
                                throw new IOException("Invalid buffer length:" + bArr.length);
                            }
                            if (AnonymousClass1.this.errcode != 0) {
                                if (MDLImageRequest.this.markAsStopped()) {
                                    MDLImageRequest.this.stop(0);
                                }
                                throw new IOException("Download error: " + AnonymousClass1.this.errcode);
                            }
                            if (j <= 0) {
                                if (MDLImageRequest.this.markAsStopped()) {
                                    MDLImageRequest.this.stop(0);
                                }
                                throw new IOException("Unexpected HTTP file length: " + j);
                            }
                            if (this.offset < this.fileLength) {
                                int read = MDLImageRequest.this.mMDLTask.read(this.offset, bArr.length, bArr, this.timeout);
                                if (read < 0) {
                                    Log.i(MDLImageRequest.TAG, "[TaskId:" + MDLImageRequest.this.mTaskId + "] read fail, errCode=" + read + ", offset:" + this.offset + ", fileLength: " + this.fileLength);
                                    if (MDLImageRequest.this.markAsStopped()) {
                                        MDLImageRequest.this.stop(0);
                                    }
                                    throw new IOException("MDL read data failed. read err: " + read + ", error code:" + (AnonymousClass1.this.errcode != 0 ? AnonymousClass1.this.errcode : -1));
                                }
                                this.offset += read;
                                return read;
                            }
                            Log.i(MDLImageRequest.TAG, "[TaskId:" + MDLImageRequest.this.mTaskId + "] read finished. offset:" + this.offset + ", fileLength: " + this.fileLength);
                            if (MDLImageRequest.this.markAsStopped()) {
                                MDLImageRequest.this.stop(0);
                            }
                            return -1;
                        }
                    }, (int) j);
                }
            });
            return 0;
        }

        @Override // com.ss.mediakit.medialoader.AVMDLDataLoader.MDLDownloader.MDLTaskCallback
        public int onError(int i, int i2, String str) {
            Log.e(MDLImageRequest.TAG, "[TaskId:" + MDLImageRequest.this.mTaskId + "] onError, type:" + i + ", code:" + i2 + ", msg:" + str);
            this.errcode = i2;
            if (MDLImageRequest.this.markAsStopped()) {
                MDLImageRequest.this.stop(0);
                if (MDLImageRequest.this.mCallback != null) {
                    MDLImageRequest.this.mCallback.onFailure(i, i2, str, null);
                }
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: mdlRequestStartWithLock, reason: merged with bridge method [inline-methods] */
    public synchronized void m9486lambda$start$0$comssmediakitimageMDLImageRequest(String str, Map<String, String> map, Map<String, String> map2, String str2, MDLCallback mDLCallback) {
        Log.i(TAG, "[TaskId:" + this.mTaskId + "] start delay mdl task.");
        if (this.mIsCanceled.get() && markAsStopped()) {
            stop(0);
            MDLCallback mDLCallback2 = this.mCallback;
            if (mDLCallback2 != null) {
                mDLCallback2.onFailure(-2, -999, "User cancelled", null);
            }
        } else {
            mdlRequestStart(str, map, map2, str2, mDLCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean markAsStopped() {
        return this.mIsStopped.compareAndSet(false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop(final int i) {
        Log.i(TAG, "[TaskId:" + this.mTaskId + "] do stop");
        ScheduledFuture<?> scheduledFuture = this.mScheduledTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.mScheduledTask = null;
        }
        if (this.mMDLTask != null) {
            this.mScheduledExecutorService.execute(new Runnable() { // from class: com.ss.mediakit.image.MDLImageRequest.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.i(MDLImageRequest.TAG, "[TaskId:" + MDLImageRequest.this.mTaskId + "] mMDLTask do real stop.");
                    MDLImageRequest.this.mMDLTask.stop(i);
                }
            });
        }
    }
}
