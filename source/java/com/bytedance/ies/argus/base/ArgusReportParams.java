package com.bytedance.ies.argus.base;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ArgusMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusReportParams;", "", "useView", "", "forceHighFrequency", "addReportDataBlock", "Lkotlin/Function0;", "Lorg/json/JSONObject;", "reportPlatform", "Lcom/bytedance/ies/argus/base/ArgusReportPlatform;", "(ZZLkotlin/jvm/functions/Function0;Lcom/bytedance/ies/argus/base/ArgusReportPlatform;)V", "getAddReportDataBlock", "()Lkotlin/jvm/functions/Function0;", "setAddReportDataBlock", "(Lkotlin/jvm/functions/Function0;)V", "getForceHighFrequency", "()Z", "setForceHighFrequency", "(Z)V", "needReport", "getNeedReport", "getReportPlatform", "()Lcom/bytedance/ies/argus/base/ArgusReportPlatform;", "setReportPlatform", "(Lcom/bytedance/ies/argus/base/ArgusReportPlatform;)V", "shouldReportSlardar", "getShouldReportSlardar", "shouldReportTea", "getShouldReportTea", "getUseView", "setUseView", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ArgusReportParams {
    private Function0<? extends JSONObject> addReportDataBlock;
    private boolean forceHighFrequency;
    private ArgusReportPlatform reportPlatform;
    private boolean useView;

    public ArgusReportParams() {
        this(false, false, null, null, 15, null);
    }

    public ArgusReportParams(boolean z, boolean z2, Function0<? extends JSONObject> function0, ArgusReportPlatform reportPlatform) {
        Intrinsics.checkNotNullParameter(reportPlatform, "reportPlatform");
        this.useView = z;
        this.forceHighFrequency = z2;
        this.addReportDataBlock = function0;
        this.reportPlatform = reportPlatform;
    }

    public final boolean getUseView() {
        return this.useView;
    }

    public final void setUseView(boolean z) {
        this.useView = z;
    }

    public final boolean getForceHighFrequency() {
        return this.forceHighFrequency;
    }

    public final void setForceHighFrequency(boolean z) {
        this.forceHighFrequency = z;
    }

    public final Function0<JSONObject> getAddReportDataBlock() {
        return this.addReportDataBlock;
    }

    public final void setAddReportDataBlock(Function0<? extends JSONObject> function0) {
        this.addReportDataBlock = function0;
    }

    public /* synthetic */ ArgusReportParams(boolean z, boolean z2, Function0 function0, ArgusReportPlatform argusReportPlatform, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : function0, (i & 8) != 0 ? ArgusReportPlatform.ONLY_SLARDAR : argusReportPlatform);
    }

    public final ArgusReportPlatform getReportPlatform() {
        return this.reportPlatform;
    }

    public final void setReportPlatform(ArgusReportPlatform argusReportPlatform) {
        Intrinsics.checkNotNullParameter(argusReportPlatform, "<set-?>");
        this.reportPlatform = argusReportPlatform;
    }

    public final boolean getNeedReport() {
        return this.reportPlatform != ArgusReportPlatform.NONE;
    }

    public final boolean getShouldReportTea() {
        return this.reportPlatform == ArgusReportPlatform.ALL || this.reportPlatform == ArgusReportPlatform.ONLY_TEA;
    }

    public final boolean getShouldReportSlardar() {
        return this.reportPlatform == ArgusReportPlatform.ALL || this.reportPlatform == ArgusReportPlatform.ONLY_SLARDAR;
    }
}
