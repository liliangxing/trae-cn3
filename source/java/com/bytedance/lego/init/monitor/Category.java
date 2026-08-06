package com.bytedance.lego.init.monitor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lego/init/monitor/Category;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHECK_PERIOD_EXCEPTION", "ON_PERIOD_TIMEOUT", "ON_PERIOD_EXCEPTION", "INIT_TASK_IN_MAIN", "INSTANCE_CLASS_EXCEPTION", "TASK_COUNT_EXCEPTION", "RUN_TAK_EXCEPTION", "PERIOD_TIMEOUT_EXCEPTION", "TASK_TIMEOUT_EXCEPTION", "TASK_TIMEOUT_EXCEPTION_REAL", "OTHER_EXCEPTION", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public enum Category {
    CHECK_PERIOD_EXCEPTION("check_period_exception"),
    ON_PERIOD_TIMEOUT("on_period_timeout"),
    ON_PERIOD_EXCEPTION("on_period_exception"),
    INIT_TASK_IN_MAIN("init_tasks_in_main"),
    INSTANCE_CLASS_EXCEPTION("instance_class_exception"),
    TASK_COUNT_EXCEPTION("task_count_exception"),
    RUN_TAK_EXCEPTION("run_task_exception"),
    PERIOD_TIMEOUT_EXCEPTION("period_timeout_exception"),
    TASK_TIMEOUT_EXCEPTION("task_timeout_exception"),
    TASK_TIMEOUT_EXCEPTION_REAL("task_timeout_exception_real"),
    OTHER_EXCEPTION("other_exception");

    private final String value;

    Category(String value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.value = value;
    }

    public final String getValue() {
        return this.value;
    }
}
