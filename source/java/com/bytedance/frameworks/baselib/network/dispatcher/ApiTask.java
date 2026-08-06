package com.bytedance.frameworks.baselib.network.dispatcher;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsRunnable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class ApiTask extends IApiTask {
    private final boolean mIsDownload;
    private final String mName;
    private final IRequest.Priority mPriority;
    private final Runnable mRunnable;

    public ApiTask(String str, IRequest.Priority priority, int i, Runnable runnable, boolean z) {
        this.mPriority = priority;
        str = StringUtils.isEmpty(str) ? getClass().getSimpleName() : str;
        this.mDelayTime = i;
        this.mName = str;
        this.mRunnable = runnable;
        this.mIsDownload = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mRunnable == null || isCanceled()) {
            return;
        }
        this.mRunnable.run();
    }

    public String getName() {
        return this.mName;
    }

    public boolean isDownload() {
        return this.mIsDownload;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public IRequest.Priority getPriority() {
        return this.mPriority;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public int getSequence() {
        return this.mSequence;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IApiTask
    public ApiTask setSequence(int i) {
        this.mSequence = i;
        return this;
    }

    public void setBlockingQueueSize(int i) {
        RetrofitMetrics retrofitMetrics;
        SsRunnable ssRunnable = this.mRunnable;
        if (!(ssRunnable instanceof SsRunnable) || (retrofitMetrics = ssRunnable.getRetrofitMetrics()) == null) {
            return;
        }
        retrofitMetrics.setBlockingQueueSize(i);
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
