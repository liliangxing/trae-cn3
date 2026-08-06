package com.bytedance.trae.init.task.base;

import com.bytedance.lego.init.TaskCollectorManager;
import com.bytedance.lego.init.model.InitTaskInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskCollector.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/init/task/base/TaskCollector;", "", "<init>", "()V", "latch", "Ljava/util/concurrent/CountDownLatch;", "start", "", "markTaskInitialized", "getInitTaskIndexs", "", "", "Lcom/bytedance/lego/init/model/InitTaskInfo;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskCollector {
    public static final TaskCollector INSTANCE = new TaskCollector();
    private static final CountDownLatch latch = new CountDownLatch(1);
    public static final int $stable = 8;

    public final void start() {
    }

    private TaskCollector() {
    }

    public final void markTaskInitialized() {
        latch.countDown();
    }

    public final Map<String, InitTaskInfo> getInitTaskIndexs() {
        LinkedHashMap emptyMap;
        try {
            if (latch.await(10L, TimeUnit.SECONDS)) {
                emptyMap = new LinkedHashMap();
                Map<? extends String, ? extends InitTaskInfo> initTaskIndexs = TaskCollectorManager.getInitTaskIndexs();
                Intrinsics.checkNotNullExpressionValue(initTaskIndexs, "getInitTaskIndexs(...)");
                emptyMap.putAll(initTaskIndexs);
            } else {
                emptyMap = MapsKt.emptyMap();
            }
            return emptyMap;
        } catch (Exception unused) {
            return MapsKt.emptyMap();
        }
    }
}
