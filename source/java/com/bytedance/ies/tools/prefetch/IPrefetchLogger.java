package com.bytedance.ies.tools.prefetch;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;

/* compiled from: Interfaces.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/IPrefetchLogger;", "", "onLog", "", "level", "", "message", "", LynxError.LYNX_THROWABLE, "", "Companion", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public interface IPrefetchLogger {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int LEVEL_DEBUG = 0;
    public static final int LEVEL_ERROR = 3;
    public static final int LEVEL_INFO = 1;
    public static final int LEVEL_WARNING = 2;

    void onLog(int level, String message);

    void onLog(int level, String message, Throwable throwable);

    /* compiled from: Interfaces.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/IPrefetchLogger$Companion;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_INFO", "LEVEL_WARNING", "prefetch_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int LEVEL_DEBUG = 0;
        public static final int LEVEL_ERROR = 3;
        public static final int LEVEL_INFO = 1;
        public static final int LEVEL_WARNING = 2;

        private Companion() {
        }
    }
}
