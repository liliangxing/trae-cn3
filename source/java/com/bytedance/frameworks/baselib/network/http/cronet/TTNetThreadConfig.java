package com.bytedance.frameworks.baselib.network.http.cronet;

/* loaded from: classes2.dex */
public class TTNetThreadConfig {
    private static final int INVALID_THREAD_PRIORITY = 20;
    public int mThreadPriority = 20;
    public int mThreadStackSize = 0;
    public ThreadType mThreadType;

    /* loaded from: classes2.dex */
    public interface Callback {
        void bindBigCore(int i);

        void bindLittleCore(int i);

        void resetCoreBind(int i);
    }

    /* loaded from: classes2.dex */
    public enum ThreadStackInitReason {
        CALLED_MULIT_TIMES,
        PROCESS_NAME_NULL,
        TNC_DISABLED,
        CRASH_HAPPENED,
        OPT_EFFECTIVE,
        FALLBACK_FIX,
        HAS_EXCEPTION
    }

    /* loaded from: classes2.dex */
    public enum ThreadType {
        INIT_THREAD,
        NETWORK_THREAD,
        FILE_THREAD,
        THREAD_POOL_SERVICE_THREAD,
        WORKER_THREAD
    }
}
