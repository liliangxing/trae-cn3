package com.bytedance.android.monitorV2.exception;

import com.bytedance.android.monitorV2.util.ExceptionUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MonitorRunnable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/monitorV2/exception/MonitorRunnable;", "Ljava/lang/Runnable;", "realRunnable", "(Ljava/lang/Runnable;)V", "run", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class MonitorRunnable implements Runnable {
    private final Runnable realRunnable;

    public MonitorRunnable(Runnable realRunnable) {
        Intrinsics.checkNotNullParameter(realRunnable, "realRunnable");
        this.realRunnable = realRunnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.realRunnable.run();
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }
}
