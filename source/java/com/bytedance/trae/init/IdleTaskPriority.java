package com.bytedance.trae.init;

import com.bytedance.ies.xbridge.XBridge;
import kotlin.Metadata;

/* compiled from: IdleTaskPriority.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/init/IdleTaskPriority;", "", "<init>", "()V", XBridge.DEFAULT_NAMESPACE, "", "LOW", "MIDDLE", "HIGH", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IdleTaskPriority {
    public static final int $stable = 0;
    public static final int DEFAULT = 0;
    public static final int HIGH = 100;
    public static final IdleTaskPriority INSTANCE = new IdleTaskPriority();
    public static final int LOW = 10;
    public static final int MIDDLE = 50;

    private IdleTaskPriority() {
    }
}
