package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* loaded from: classes2.dex */
public class DroppedByThrottleControlException extends IOException {
    public DroppedByThrottleControlException() {
        super("Dropped by TTNet Throttle Control");
    }
}
