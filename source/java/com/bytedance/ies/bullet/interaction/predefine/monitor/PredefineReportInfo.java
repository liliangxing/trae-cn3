package com.bytedance.ies.bullet.interaction.predefine.monitor;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PredefineRecordInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/monitor/PredefineReportInfo;", "", "()V", "clientMetaFetch", "", "getClientMetaFetch", "()Z", "setClientMetaFetch", "(Z)V", "clientPredefineEnable", "getClientPredefineEnable", "setClientPredefineEnable", "predefineRecords", "Ljava/util/ArrayList;", "Lcom/bytedance/ies/bullet/interaction/predefine/monitor/PredefineRecordInfo;", "Lkotlin/collections/ArrayList;", "getPredefineRecords", "()Ljava/util/ArrayList;", "setPredefineRecords", "(Ljava/util/ArrayList;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PredefineReportInfo {
    private boolean clientMetaFetch;
    private boolean clientPredefineEnable;
    private ArrayList<PredefineRecordInfo> predefineRecords = new ArrayList<>();

    public final boolean getClientMetaFetch() {
        return this.clientMetaFetch;
    }

    public final void setClientMetaFetch(boolean z) {
        this.clientMetaFetch = z;
    }

    public final boolean getClientPredefineEnable() {
        return this.clientPredefineEnable;
    }

    public final void setClientPredefineEnable(boolean z) {
        this.clientPredefineEnable = z;
    }

    public final ArrayList<PredefineRecordInfo> getPredefineRecords() {
        return this.predefineRecords;
    }

    public final void setPredefineRecords(ArrayList<PredefineRecordInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.predefineRecords = arrayList;
    }
}
