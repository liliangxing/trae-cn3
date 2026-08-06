package com.bytedance.iesgurd.core;

import kotlin.Metadata;

/* compiled from: Constants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/iesgurd/core/Constants;", "", "()V", "BUFFER_SIZE", "", "TimerTaskType", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final class Constants {
    public static final int BUFFER_SIZE = 8192;
    public static final Constants INSTANCE = new Constants();

    private Constants() {
    }

    /* compiled from: Constants.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/iesgurd/core/Constants$TimerTaskType;", "", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes4.dex */
    public interface TimerTaskType {
        public static final int CHECK_RETRY = 1;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int DELAY_TASK = 7;
        public static final int DELAY_TASK_RESUME = 8;
        public static final int EBR = 2;
        public static final int LOOP = 3;
        public static final int META_DATA = 5;
        public static final int SETTINGS = 0;
        public static final int UPLOAD_ONLINE_STATS = 10;

        /* compiled from: Constants.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/iesgurd/core/Constants$TimerTaskType$Companion;", "", "()V", "CHECK_RETRY", "", "DELAY_TASK", "DELAY_TASK_RESUME", "EBR", "LOOP", "META_DATA", "SETTINGS", "UPLOAD_ONLINE_STATS", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
        /* loaded from: classes4.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int CHECK_RETRY = 1;
            public static final int DELAY_TASK = 7;
            public static final int DELAY_TASK_RESUME = 8;
            public static final int EBR = 2;
            public static final int LOOP = 3;
            public static final int META_DATA = 5;
            public static final int SETTINGS = 0;
            public static final int UPLOAD_ONLINE_STATS = 10;

            private Companion() {
            }
        }
    }
}
