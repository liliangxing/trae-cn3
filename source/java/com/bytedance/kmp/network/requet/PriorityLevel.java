package com.bytedance.kmp.network.requet;

import kotlin.Metadata;

/* compiled from: RequestContext.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/kmp/network/requet/PriorityLevel;", "", "()V", "HIGH", "", "IMMEDIATE", "INVALID", "LOW", "LOWEST", "NORMAL", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PriorityLevel {
    public static final int HIGH = 2;
    public static final int IMMEDIATE = 3;
    public static final PriorityLevel INSTANCE = new PriorityLevel();
    public static final int INVALID = -999;
    public static final int LOW = 0;
    public static final int LOWEST = -1;
    public static final int NORMAL = 1;

    private PriorityLevel() {
    }
}
