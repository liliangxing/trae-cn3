package com.bytedance.salamander.anniex;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorCoreSLMonitorContainerConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/salamander/anniex/SLMonitorContainerConfig;", "", "containerBid", "", "enableJSBParamsReport", "", "(Ljava/lang/String;Z)V", "getContainerBid", "()Ljava/lang/String;", "setContainerBid", "(Ljava/lang/String;)V", "getEnableJSBParamsReport", "()Z", "setEnableJSBParamsReport", "(Z)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class SLMonitorContainerConfig {
    private String containerBid;
    private boolean enableJSBParamsReport;

    public String getContainerBid() {
        return this.containerBid;
    }

    public void setContainerBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.containerBid = str;
    }

    public boolean getEnableJSBParamsReport() {
        return this.enableJSBParamsReport;
    }

    public void setEnableJSBParamsReport(boolean z) {
        this.enableJSBParamsReport = z;
    }

    public SLMonitorContainerConfig(String containerBid, boolean z) {
        Intrinsics.checkNotNullParameter(containerBid, "containerBid");
        this.containerBid = "bullet_custom_bid";
        this.enableJSBParamsReport = true;
        setContainerBid(containerBid);
        setEnableJSBParamsReport(z);
    }

    public /* synthetic */ SLMonitorContainerConfig(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "bullet_custom_bid" : str, (i & 2) != 0 ? true : z);
    }
}
