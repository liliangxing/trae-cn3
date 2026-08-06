package com.bytedance.sdk.account.network.dispatcher;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.LogHelper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ApiDispatcher extends Thread implements WeakHandler.IHandler {
    protected static final int MSG_SHRINK_DISPATCHER_EXPIRE = 0;
    public static final int SHRINK_EXPIRE = 2000;
    private static final String TAG = "ApiDispatcher";
    protected WeakHandler mHandler;
    private volatile boolean mIsRunning;
    private String mLogTag;
    private final BlockingQueue<IRequest> mQueue;
    private volatile boolean mQuit;
    protected static RequestQueue sRequestQueue = RequestQueue.getDefaultRequestQueue();
    protected static final AtomicInteger sCount = new AtomicInteger();

    public ApiDispatcher(BlockingQueue<IRequest> blockingQueue, String str, String str2) {
        super(TextUtils.isEmpty(str) ? "ApiDispatcher-Thread" : str);
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mQuit = false;
        this.mIsRunning = false;
        this.mQueue = blockingQueue;
        this.mLogTag = str2;
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                IRequest take = this.mQueue.take();
                cancelShrinkExpireMsg();
                if (take != null && (take instanceof ApiThread)) {
                    processLegacyApiThread((ApiThread) take);
                }
            } catch (InterruptedException unused) {
                if (this.mQuit) {
                    return;
                }
            }
        }
    }

    private void processLegacyApiThread(ApiThread apiThread) {
        String str;
        String str2 = null;
        try {
            this.mIsRunning = true;
            cancelEnQueueExpireMsg(apiThread);
        } catch (Throwable th) {
            th = th;
            str = null;
        }
        if (apiThread.isCanceled()) {
            this.mIsRunning = false;
            return;
        }
        String str3 = Thread.currentThread().getName();
        try {
            str2 = apiThread.getName();
            if (!StringUtils.isEmpty(str2) && !StringUtils.isEmpty(str3)) {
                Thread.currentThread().setName(str2);
            }
            LogHelper.d(this.mLogTag, "thread (inc) count: " + sCount.incrementAndGet());
            apiThread.run();
            sendShrinkExpireMsg();
        } catch (Throwable th2) {
            th = th2;
            str = str2;
            str2 = str3;
            LogHelper.e(this.mLogTag, "processLegacyApiThread: ", th);
            str3 = str2;
            str2 = str;
            this.mIsRunning = false;
            if (!StringUtils.isEmpty(str2)) {
                Thread.currentThread().setName(str3);
            }
            LogHelper.d(this.mLogTag, "thread (dec) count: " + sCount.decrementAndGet());
        }
        this.mIsRunning = false;
        if (!StringUtils.isEmpty(str2) && !StringUtils.isEmpty(str3)) {
            Thread.currentThread().setName(str3);
        }
        LogHelper.d(this.mLogTag, "thread (dec) count: " + sCount.decrementAndGet());
    }

    public void handleMsg(Message message) {
        if (message == null) {
            return;
        }
        try {
            if (message.what != 0) {
                return;
            }
            sRequestQueue.handleShrinkRequestQueueSize();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cancelEnQueueExpireMsg(ApiThread apiThread) {
        if (apiThread != null) {
            apiThread.cancelEnQueueExpireMsg();
        }
    }

    public void sendShrinkExpireMsg() {
        cancelShrinkExpireMsg();
        this.mHandler.sendEmptyMessageDelayed(0, 2000L);
    }

    public void cancelShrinkExpireMsg() {
        this.mHandler.removeMessages(0);
    }
}
