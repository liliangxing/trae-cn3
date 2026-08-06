package com.bytedance.sdk.account.network.dispatcher;

import android.os.Process;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.sdk.account.network.dispatcher.IRequest;
import com.ss.android.LogHelper;
import com.ss.android.account.TTAccountInit;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ApiLocalDispatcher extends Thread {
    private static final String TAG = "ApiLocalDispatcher";
    private final BlockingQueue<IRequest> mLocalQueue;
    private final BlockingQueue<IRequest> mNetworkQueue;
    private volatile boolean mQuit;

    public ApiLocalDispatcher(BlockingQueue<IRequest> blockingQueue, BlockingQueue<IRequest> blockingQueue2) {
        super("ApiLocalDispatcher-Thread");
        this.mQuit = false;
        this.mLocalQueue = blockingQueue;
        this.mNetworkQueue = blockingQueue2;
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                IRequest take = this.mLocalQueue.take();
                ApiThread apiThread = take instanceof ApiThread ? (ApiThread) take : null;
                if (apiThread != null) {
                    String name = Thread.currentThread().getName();
                    String name2 = apiThread.getName();
                    try {
                    } catch (Throwable th) {
                        LogHelper.e(TAG, "run: ", th);
                    }
                    if (!apiThread.isCanceled()) {
                        if (!StringUtils.isEmpty(name2) && !StringUtils.isEmpty(name)) {
                            Thread.currentThread().setName("ApiLocalDispatcher-" + name2);
                        }
                        if (TTAccountInit.getConfig().isLocalTest()) {
                            LogHelper.d(TAG, "run4Local " + name2 + ", queue size: " + this.mLocalQueue.size() + " " + this.mNetworkQueue.size());
                        }
                        if (!apiThread.run4Local()) {
                            if (apiThread.getPriority() == IRequest.Priority.IMMEDIATE) {
                                ThreadPlus.submitRunnable(apiThread);
                            } else {
                                apiThread.sendEnQueueExpireMsg();
                                this.mNetworkQueue.add(apiThread);
                            }
                        }
                        if (!StringUtils.isEmpty(name2) && !StringUtils.isEmpty(name)) {
                            Thread.currentThread().setName(name);
                        }
                    }
                }
            } catch (InterruptedException unused) {
                if (this.mQuit) {
                    return;
                }
            }
        }
    }
}
