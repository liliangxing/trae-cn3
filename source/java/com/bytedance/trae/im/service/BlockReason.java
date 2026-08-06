package com.bytedance.trae.im.service;

import kotlin.Metadata;

/* compiled from: ICreateAgentTask.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/im/service/BlockReason;", "", "<init>", "()V", "UNKNOWN", "", "NO_SOLO_ENT", "PARALLEL_LIMITED", "NOT_IN_ACTIVITY_TIME", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BlockReason {
    public static final BlockReason INSTANCE = new BlockReason();
    public static final int NOT_IN_ACTIVITY_TIME = 3;
    public static final int NO_SOLO_ENT = 1;
    public static final int PARALLEL_LIMITED = 2;
    public static final int UNKNOWN = 0;

    private BlockReason() {
    }
}
