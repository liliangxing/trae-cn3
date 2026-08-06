package com.bytedance.lego.init.util;

import androidx.core.os.TraceCompat;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.model.InitTaskInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitTraceUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\f"}, d2 = {"Lcom/bytedance/lego/init/util/InitTraceUtil;", "", "()V", "beginSection", "", "message", "", "beginTask", "taskInfo", "Lcom/bytedance/lego/init/model/InitTaskInfo;", "endSection", "endTask", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InitTraceUtil {
    public static final InitTraceUtil INSTANCE = new InitTraceUtil();

    private InitTraceUtil() {
    }

    public final void beginTask(InitTaskInfo taskInfo) {
        Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release()) {
            TraceCompat.beginSection("Task:" + taskInfo.taskId);
        }
    }

    public final void endTask() {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release()) {
            TraceCompat.endSection();
        }
    }

    public final void beginSection(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release()) {
            TraceCompat.beginSection("Task:" + message);
        }
    }

    public final void endSection() {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release()) {
            TraceCompat.endSection();
        }
    }
}
