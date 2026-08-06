package com.bytedance.ies.bullet.base.utils.logger;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggerContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/base/utils/logger/LoggerContext;", "", "()V", "stages", "", "Lcom/bytedance/ies/bullet/base/utils/logger/Stage;", "getStages", "()Ljava/util/List;", "popStage", "", "pushStage", "name", "", "sessionId", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class LoggerContext {
    private final List<Stage> stages = new ArrayList();

    public final List<Stage> getStages() {
        return this.stages;
    }

    public final void pushStage(String name, String sessionId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.stages.add(new Stage(name, sessionId));
    }

    public final void popStage() {
        if (this.stages.isEmpty()) {
            return;
        }
        this.stages.remove(r0.size() - 1);
    }
}
