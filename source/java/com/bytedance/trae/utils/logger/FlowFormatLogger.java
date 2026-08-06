package com.bytedance.trae.utils.logger;

import com.bytedance.memory.api.MemoryApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FormatLogBuilder.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/utils/logger/FlowFormatLogger;", "", "module", "", "subModule", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "logger", "Lcom/bytedance/trae/utils/logger/Logger;", MemoryApi.DEBUG, "Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;", "what", "info", "warn", "error", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FlowFormatLogger {
    private final Logger logger;

    public FlowFormatLogger(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "module");
        Intrinsics.checkNotNullParameter(str2, "subModule");
        this.logger = new Logger(str + '-' + str2);
    }

    public final FlowFormatLogBuilder debug(String what) {
        Intrinsics.checkNotNullParameter(what, "what");
        return new FlowFormatLogBuilder(this.logger, LogLevel.DEBUG, what);
    }

    public final FlowFormatLogBuilder info(String what) {
        Intrinsics.checkNotNullParameter(what, "what");
        return new FlowFormatLogBuilder(this.logger, LogLevel.INFO, what);
    }

    public final FlowFormatLogBuilder warn(String what) {
        Intrinsics.checkNotNullParameter(what, "what");
        return new FlowFormatLogBuilder(this.logger, LogLevel.WARN, what);
    }

    public final FlowFormatLogBuilder error(String what) {
        Intrinsics.checkNotNullParameter(what, "what");
        return new FlowFormatLogBuilder(this.logger, LogLevel.ERROR, what);
    }
}
