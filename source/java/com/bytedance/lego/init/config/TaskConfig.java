package com.bytedance.lego.init.config;

import android.content.Context;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.lego.init.IdleTaskConfig;
import com.bytedance.lego.init.util.InitLogger;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001:\u00012Bw\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0002\u0010\u0018J\b\u0010/\u001a\u00020\tH\u0002J\b\u00100\u001a\u00020\u000bH\u0002J\b\u00101\u001a\u00020\u000bH\u0002R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/bytedance/lego/init/config/TaskConfig;", "", "isDebug", "", TraceStatsConsts.STATS_BASE_MODULE, "Landroid/content/Context;", "mode", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "coreThreadNum", "", "isMainProcess", "processName", "", EventConstants.PARAM_TIME_OUT, "catchException", "applicationStartTime", "", "idleTaskConfig", "Lcom/bytedance/lego/init/IdleTaskConfig;", "agreePrivacyPopupWindow", "(ZLandroid/content/Context;Lcom/bytedance/lego/init/config/ProcessMatchMode;Ljava/util/concurrent/ThreadPoolExecutor;Ljava/util/concurrent/ThreadFactory;IZLjava/lang/String;IZJLcom/bytedance/lego/init/IdleTaskConfig;Z)V", "getAgreePrivacyPopupWindow", "()Z", "setAgreePrivacyPopupWindow", "(Z)V", "getApplicationStartTime", "()J", "getBase", "()Landroid/content/Context;", "getCatchException", "getIdleTaskConfig", "()Lcom/bytedance/lego/init/IdleTaskConfig;", "getMode", "()Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessName", "()Ljava/lang/String;", "taskExecutor", "getTaskExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "setTaskExecutor", "(Ljava/util/concurrent/ThreadPoolExecutor;)V", "getTimeout", "()I", "getDefaultExecutor", "getDefaultThreadFactory", "getThreadFactory", "Builder", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class TaskConfig {
    private boolean agreePrivacyPopupWindow;
    private final long applicationStartTime;
    private final Context base;
    private final boolean catchException;
    private final int coreThreadNum;
    private final ThreadPoolExecutor executor;
    private final IdleTaskConfig idleTaskConfig;
    private final boolean isDebug;
    private final boolean isMainProcess;
    private final ProcessMatchMode mode;
    private final String processName;
    private ThreadPoolExecutor taskExecutor;
    private final ThreadFactory threadFactory;
    private final int timeout;

    private TaskConfig(boolean z, Context context, ProcessMatchMode processMatchMode, ThreadPoolExecutor threadPoolExecutor, ThreadFactory threadFactory, int i, boolean z2, String str, int i2, boolean z3, long j, IdleTaskConfig idleTaskConfig, boolean z4) {
        this.isDebug = z;
        this.base = context;
        this.mode = processMatchMode;
        this.executor = threadPoolExecutor;
        this.threadFactory = threadFactory;
        this.coreThreadNum = i;
        this.isMainProcess = z2;
        this.processName = str;
        this.timeout = i2;
        this.catchException = z3;
        this.applicationStartTime = j;
        this.idleTaskConfig = idleTaskConfig;
        this.agreePrivacyPopupWindow = z4;
    }

    public /* synthetic */ TaskConfig(boolean z, Context context, ProcessMatchMode processMatchMode, ThreadPoolExecutor threadPoolExecutor, ThreadFactory threadFactory, int i, boolean z2, String str, int i2, boolean z3, long j, IdleTaskConfig idleTaskConfig, boolean z4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, context, processMatchMode, threadPoolExecutor, threadFactory, i, z2, str, i2, z3, j, idleTaskConfig, z4);
    }

    public final Context getBase() {
        return this.base;
    }

    public final ProcessMatchMode getMode() {
        return this.mode;
    }

    /* renamed from: isDebug, reason: from getter */
    public final boolean getIsDebug() {
        return this.isDebug;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    /* synthetic */ TaskConfig(boolean z, Context context, ProcessMatchMode processMatchMode, ThreadPoolExecutor threadPoolExecutor, ThreadFactory threadFactory, int i, boolean z2, String str, int i2, boolean z3, long j, IdleTaskConfig idleTaskConfig, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, context, processMatchMode, r6, r7, i, z2, str, i2, z3, j, idleTaskConfig, z4);
        ThreadPoolExecutor threadPoolExecutor2;
        ThreadFactory threadFactory2;
        if ((i3 & 8) != 0) {
            threadPoolExecutor2 = null;
        } else {
            threadPoolExecutor2 = threadPoolExecutor;
        }
        if ((i3 & 16) != 0) {
            threadFactory2 = null;
        } else {
            threadFactory2 = threadFactory;
        }
    }

    public final boolean getCatchException() {
        return this.catchException;
    }

    public final String getProcessName() {
        return this.processName;
    }

    public final int getTimeout() {
        return this.timeout;
    }

    /* renamed from: isMainProcess, reason: from getter */
    public final boolean getIsMainProcess() {
        return this.isMainProcess;
    }

    public final long getApplicationStartTime() {
        return this.applicationStartTime;
    }

    public final IdleTaskConfig getIdleTaskConfig() {
        return this.idleTaskConfig;
    }

    public final boolean getAgreePrivacyPopupWindow() {
        return this.agreePrivacyPopupWindow;
    }

    public final void setAgreePrivacyPopupWindow(boolean z) {
        this.agreePrivacyPopupWindow = z;
    }

    /* compiled from: TaskConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0015J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/lego/init/config/TaskConfig$Builder;", "", TraceStatsConsts.STATS_BASE_MODULE, "Landroid/content/Context;", "isMainProcess", "", "processName", "", "(Landroid/content/Context;ZLjava/lang/String;)V", "agreePrivacyPopupWindow", "applicationStartTime", "", "catchException", "coreThreadNum", "", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "idleTaskConfig", "Lcom/bytedance/lego/init/IdleTaskConfig;", "isDebug", "processMatchMode", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", EventConstants.PARAM_TIME_OUT, "build", "Lcom/bytedance/lego/init/config/TaskConfig;", "enableCatchException", "enable", "setApplicationStartTime", "setCoreThreadNum", "setExecutorService", "setIdleTaskConfig", "setProcessMatchMode", "mode", "setThreadFactory", "setTimeOut", "millis", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
    /* loaded from: classes4.dex */
    public static final class Builder {
        private boolean agreePrivacyPopupWindow;
        private long applicationStartTime;
        private final Context base;
        private boolean catchException;
        private int coreThreadNum;
        private ThreadPoolExecutor executor;
        private IdleTaskConfig idleTaskConfig;
        private boolean isDebug;
        private final boolean isMainProcess;
        private ProcessMatchMode processMatchMode;
        private final String processName;
        private ThreadFactory threadFactory;
        private int timeout;

        public Builder(Context base, boolean z, String processName) {
            Intrinsics.checkParameterIsNotNull(base, "base");
            Intrinsics.checkParameterIsNotNull(processName, "processName");
            this.base = base;
            this.isMainProcess = z;
            this.processName = processName;
            this.processMatchMode = ProcessMatchMode.CONTAIN;
            this.coreThreadNum = Runtime.getRuntime().availableProcessors();
            this.timeout = 8000;
            this.idleTaskConfig = IdleTaskConfig.INSTANCE.getDEFAULT_IDLETASK_CONFIG$initscheduler_release();
            this.applicationStartTime = System.currentTimeMillis();
            this.agreePrivacyPopupWindow = true;
        }

        public final Builder isDebug(boolean isDebug) {
            this.isDebug = isDebug;
            return this;
        }

        public final Builder setExecutorService(ThreadPoolExecutor executor) {
            Intrinsics.checkParameterIsNotNull(executor, "executor");
            this.executor = executor;
            return this;
        }

        public final Builder setProcessMatchMode(ProcessMatchMode mode) {
            Intrinsics.checkParameterIsNotNull(mode, "mode");
            this.processMatchMode = mode;
            return this;
        }

        public final Builder setThreadFactory(ThreadFactory threadFactory) {
            Intrinsics.checkParameterIsNotNull(threadFactory, "threadFactory");
            this.threadFactory = threadFactory;
            return this;
        }

        public final Builder setCoreThreadNum(int coreThreadNum) {
            this.coreThreadNum = coreThreadNum;
            return this;
        }

        public final Builder setTimeOut(int millis) {
            if (millis < 3000) {
                InitLogger.e$default(InitLogger.INSTANCE, null, "TaskConfig.timeout must not be less than 3*1000", 1, null);
                this.timeout = 3000;
            } else {
                this.timeout = millis;
            }
            return this;
        }

        public final Builder enableCatchException(boolean enable) {
            this.catchException = enable;
            return this;
        }

        public final Builder setIdleTaskConfig(IdleTaskConfig idleTaskConfig) {
            Intrinsics.checkParameterIsNotNull(idleTaskConfig, "idleTaskConfig");
            this.idleTaskConfig = idleTaskConfig;
            return this;
        }

        public final Builder setApplicationStartTime(long applicationStartTime) {
            this.applicationStartTime = applicationStartTime;
            return this;
        }

        public final Builder agreePrivacyPopupWindow(boolean agreePrivacyPopupWindow) {
            this.agreePrivacyPopupWindow = agreePrivacyPopupWindow;
            return this;
        }

        public final TaskConfig build() {
            boolean z = this.isDebug;
            Context context = this.base;
            ThreadPoolExecutor threadPoolExecutor = this.executor;
            return new TaskConfig(z, context, this.processMatchMode, threadPoolExecutor, this.threadFactory, this.coreThreadNum, this.isMainProcess, this.processName, this.timeout, this.catchException, this.applicationStartTime, this.idleTaskConfig, this.agreePrivacyPopupWindow, null);
        }
    }

    public final void setTaskExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.taskExecutor = threadPoolExecutor;
    }

    public final ThreadPoolExecutor getTaskExecutor() {
        ThreadPoolExecutor threadPoolExecutor = this.taskExecutor;
        if (threadPoolExecutor == null) {
            threadPoolExecutor = this.executor;
        }
        return threadPoolExecutor != null ? threadPoolExecutor : getDefaultExecutor();
    }

    private final ThreadPoolExecutor getDefaultExecutor() {
        int i = this.coreThreadNum;
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), getThreadFactory());
    }

    private final ThreadFactory getThreadFactory() {
        ThreadFactory threadFactory = this.threadFactory;
        return threadFactory != null ? threadFactory : getDefaultThreadFactory();
    }

    private final ThreadFactory getDefaultThreadFactory() {
        return new ThreadFactory() { // from class: com.bytedance.lego.init.config.TaskConfig$getDefaultThreadFactory$1
            private final AtomicInteger mCount = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable r) {
                Intrinsics.checkParameterIsNotNull(r, "r");
                return new Thread(r, "AA InitThread#" + this.mCount.getAndIncrement());
            }
        };
    }
}
