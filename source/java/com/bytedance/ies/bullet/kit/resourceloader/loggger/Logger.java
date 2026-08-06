package com.bytedance.ies.bullet.kit.resourceloader.loggger;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: Logger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J2\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/loggger/Logger;", "", "core", "", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "msg", "", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "e", "tr", "", "tridentCore", "content", "", "w", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface Logger {
    void core(TaskConfig config, String msg);

    void d(String msg);

    void e(String msg);

    void e(String msg, Throwable tr);

    void tridentCore(TaskConfig config, String msg, Map<String, ? extends Object> content);

    void w(String msg);

    void w(String msg, Throwable tr);

    /* compiled from: Logger.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void tridentCore$default(Logger logger, TaskConfig taskConfig, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tridentCore");
            }
            if ((i & 4) != 0) {
                map = null;
            }
            logger.tridentCore(taskConfig, str, map);
        }
    }
}
