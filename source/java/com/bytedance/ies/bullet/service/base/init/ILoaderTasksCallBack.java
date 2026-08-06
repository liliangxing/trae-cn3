package com.bytedance.ies.bullet.service.base.init;

import kotlin.Metadata;

/* compiled from: ILoaderTasksCallBack.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/init/ILoaderTasksCallBack;", "", "onInitFailed", "", "code", "", "taskStatus", "Lcom/bytedance/ies/bullet/service/base/init/TaskStatus;", "onInitSuccess", "onStateChange", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ILoaderTasksCallBack {
    public static final int ALL_TASK_READY = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int FINISH_BY_INTERCEPT = -3;
    public static final int SYNC_TASK_RUN_FAILED = -1;
    public static final int SYNC_TASK_RUN_TIMEOUT = -2;

    /* compiled from: ILoaderTasksCallBack.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void onStateChange(ILoaderTasksCallBack iLoaderTasksCallBack, int i) {
        }
    }

    void onInitFailed(int code, TaskStatus taskStatus);

    void onInitSuccess();

    void onStateChange(int code);

    /* compiled from: ILoaderTasksCallBack.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/init/ILoaderTasksCallBack$Companion;", "", "()V", "ALL_TASK_READY", "", "FINISH_BY_INTERCEPT", "SYNC_TASK_RUN_FAILED", "SYNC_TASK_RUN_TIMEOUT", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ALL_TASK_READY = 1;
        public static final int FINISH_BY_INTERCEPT = -3;
        public static final int SYNC_TASK_RUN_FAILED = -1;
        public static final int SYNC_TASK_RUN_TIMEOUT = -2;

        private Companion() {
        }
    }
}
