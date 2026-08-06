package com.bytedance.lego.init;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: IdleTaskDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lego/init/IdleTaskConfig;", "", "uiThreadTaskNum", "", "nonUIThreadTaskNum", "autoIdleTask", "", "bootFinishTimeOut", "", "(IIZJ)V", "getAutoIdleTask", "()Z", "getBootFinishTimeOut", "()J", "getNonUIThreadTaskNum", "()I", "getUiThreadTaskNum", "Companion", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class IdleTaskConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final IdleTaskConfig DEFAULT_IDLETASK_CONFIG = new IdleTaskConfig(0, 0, false, 0, 15, null);
    private static final long IDLE_START_TIME_OUT = 15000;
    private final boolean autoIdleTask;
    private final long bootFinishTimeOut;
    private final int nonUIThreadTaskNum;
    private final int uiThreadTaskNum;

    public IdleTaskConfig() {
        this(0, 0, false, 0L, 15, null);
    }

    /* compiled from: IdleTaskDispatcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/lego/init/IdleTaskConfig$Companion;", "", "()V", "DEFAULT_IDLETASK_CONFIG", "Lcom/bytedance/lego/init/IdleTaskConfig;", "getDEFAULT_IDLETASK_CONFIG$initscheduler_release", "()Lcom/bytedance/lego/init/IdleTaskConfig;", "IDLE_START_TIME_OUT", "", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IdleTaskConfig getDEFAULT_IDLETASK_CONFIG$initscheduler_release() {
            return IdleTaskConfig.DEFAULT_IDLETASK_CONFIG;
        }
    }

    public IdleTaskConfig(int i, int i2, boolean z, long j) {
        this.uiThreadTaskNum = i;
        this.nonUIThreadTaskNum = i2;
        this.autoIdleTask = z;
        this.bootFinishTimeOut = j;
    }

    public /* synthetic */ IdleTaskConfig(int i, int i2, boolean z, long j, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, (i3 & 2) == 0 ? i2 : 1, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? 15000L : j);
    }

    public final boolean getAutoIdleTask() {
        return this.autoIdleTask;
    }

    public final long getBootFinishTimeOut() {
        return this.bootFinishTimeOut;
    }

    public final int getNonUIThreadTaskNum() {
        return this.nonUIThreadTaskNum;
    }

    public final int getUiThreadTaskNum() {
        return this.uiThreadTaskNum;
    }
}
