package com.bytedance.frameworks.baselib.network.dispatcher;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;

/* loaded from: classes2.dex */
public abstract class ApiThread extends IApiTask {
    protected static RequestQueue sRequestQueue;
    private final String mName;
    protected final IRequest.Priority mPriority;

    public boolean isDownload() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    public static void setRequestQueue(RequestQueue requestQueue) {
        sRequestQueue = requestQueue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ApiThread(String str, IRequest.Priority priority) {
        this.mPriority = priority;
        this.mName = StringUtils.isEmpty(str) ? getClass().getSimpleName() : str;
    }

    public String getName() {
        return this.mName;
    }

    public final void start() {
        if (this.mStarted.compareAndSet(false, true)) {
            if (sRequestQueue == null) {
                sRequestQueue = RequestQueue.getDefaultRequestQueue();
            }
            if (isDownload()) {
                sRequestQueue.addDownload(this);
            } else {
                sRequestQueue.add(this);
            }
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public IRequest.Priority getPriority() {
        return this.mPriority;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public int getSequence() {
        return this.mSequence;
    }

    @Override // java.lang.Comparable
    public int compareTo(IRequest iRequest) {
        IRequest.Priority priority = getPriority();
        IRequest.Priority priority2 = iRequest.getPriority();
        if (priority == null) {
            priority = IRequest.Priority.NORMAL;
        }
        if (priority2 == null) {
            priority2 = IRequest.Priority.NORMAL;
        }
        return priority == priority2 ? getSequence() - iRequest.getSequence() : priority2.ordinal() - priority.ordinal();
    }
}
