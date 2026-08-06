package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace("cronet")
/* loaded from: classes7.dex */
public abstract class TTThreadConfigInfoProvider {
    public static final int INVALID_THREAD_PRIORITY = 20;

    /* loaded from: classes7.dex */
    public enum BindCore {
        DEFAULT,
        BIG_CORE,
        LITTLE_CORE,
        CANCEL_BIND
    }

    /* loaded from: classes7.dex */
    public interface Callback {
        void bindBigCore(int i);

        void bindLittleCore(int i);

        void resetCoreBind(int i);
    }

    /* loaded from: classes7.dex */
    public enum ThreadType {
        INIT_THREAD,
        NETWORK_THREAD,
        FILE_THREAD,
        THREAD_POOL_SERVICE_THREAD,
        WORKER_THREAD
    }

    /* loaded from: classes7.dex */
    public static class ThreadConfigInfo {
        private BindCore mBindCore;
        private int mThreadPriority = 20;
        private int mThreadStackSize;
        private ThreadType mThreadType;

        public void setThreadType(ThreadType threadType) {
            this.mThreadType = threadType;
        }

        public int getThreadType() {
            return this.mThreadType.ordinal();
        }

        public void setThreadPriority(int i) {
            this.mThreadPriority = i;
        }

        public int getThreadPriority() {
            return this.mThreadPriority;
        }

        public void setThreadStackSize(int i) {
            this.mThreadStackSize = i;
        }

        public int getThreadStackSize() {
            return this.mThreadStackSize;
        }
    }
}
