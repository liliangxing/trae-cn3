package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.android.monitorV2.constant.ReportConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefetchException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", ReportConst.ValidationReport.MODULE, "getModule", "()Ljava/lang/String;", "setModule", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PrefetchException extends Exception {
    private String module;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrefetchException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public final String getModule() {
        return this.module;
    }

    public final void setModule(String str) {
        this.module = str;
    }
}
