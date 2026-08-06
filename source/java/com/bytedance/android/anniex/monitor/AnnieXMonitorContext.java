package com.bytedance.android.anniex.monitor;

import com.bytedance.android.monitorV2.entity.UnifyErrorDomain;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/android/anniex/monitor/AnnieXMonitorContext;", "", "()V", "endToEndErrorMessage", "", "getEndToEndErrorMessage", "()Ljava/lang/String;", "setEndToEndErrorMessage", "(Ljava/lang/String;)V", "endToEndReported", "", "getEndToEndReported", "()Z", "setEndToEndReported", "(Z)V", "hasReported", "getHasReported", "setHasReported", "loadStage", "getLoadStage", "setLoadStage", "loadStatus", "getLoadStatus", "setLoadStatus", "scene", "getScene", "setScene", "unifyErrorDomain", "", "getUnifyErrorDomain", "()I", "setUnifyErrorDomain", "(I)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class AnnieXMonitorContext {
    private boolean endToEndReported;
    private boolean hasReported;
    private String loadStatus = "init";
    private String scene = "new";
    private String loadStage = "begin";
    private String endToEndErrorMessage = "unknown";
    private int unifyErrorDomain = UnifyErrorDomain.AnnieXUnifyErrorDomainReserved.getErrorDomain();

    public final boolean getHasReported() {
        return this.hasReported;
    }

    public final void setHasReported(boolean z) {
        this.hasReported = z;
    }

    public final boolean getEndToEndReported() {
        return this.endToEndReported;
    }

    public final void setEndToEndReported(boolean z) {
        this.endToEndReported = z;
    }

    public final String getLoadStatus() {
        return this.loadStatus;
    }

    public final void setLoadStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.loadStatus = str;
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setScene(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scene = str;
    }

    public final String getLoadStage() {
        return this.loadStage;
    }

    public final void setLoadStage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.loadStage = str;
    }

    public final String getEndToEndErrorMessage() {
        return this.endToEndErrorMessage;
    }

    public final void setEndToEndErrorMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endToEndErrorMessage = str;
    }

    public final int getUnifyErrorDomain() {
        return this.unifyErrorDomain;
    }

    public final void setUnifyErrorDomain(int i) {
        this.unifyErrorDomain = i;
    }
}
