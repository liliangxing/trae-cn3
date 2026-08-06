package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.ies.bullet.service.base.utils.Identifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefetchReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001f\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchReportInfo;", "", "bid", "", "identifier", "Lcom/bytedance/ies/bullet/service/base/utils/Identifier;", "prefetchApi", "requestSuccess", "", "prefetchStatus", "", "prefetchFrom", "errorMsg", "duration", "", "configFrom", "(Ljava/lang/String;Lcom/bytedance/ies/bullet/service/base/utils/Identifier;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getBid", "()Ljava/lang/String;", "setBid", "(Ljava/lang/String;)V", "getConfigFrom", "setConfigFrom", "getDuration", "()J", "setDuration", "(J)V", "getErrorMsg", "setErrorMsg", "getIdentifier", "()Lcom/bytedance/ies/bullet/service/base/utils/Identifier;", "setIdentifier", "(Lcom/bytedance/ies/bullet/service/base/utils/Identifier;)V", "getPrefetchApi", "setPrefetchApi", "getPrefetchFrom", "setPrefetchFrom", "getPrefetchStatus", "()I", "setPrefetchStatus", "(I)V", "getRequestSuccess", "()Z", "setRequestSuccess", "(Z)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PrefetchReportInfo {
    private String bid;
    private String configFrom;
    private long duration;
    private String errorMsg;
    private Identifier identifier;
    private String prefetchApi;
    private String prefetchFrom;
    private int prefetchStatus;
    private boolean requestSuccess;

    public PrefetchReportInfo(String bid, Identifier identifier, String prefetchApi, boolean z, int i, String prefetchFrom, String errorMsg, long j, String str) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(prefetchApi, "prefetchApi");
        Intrinsics.checkNotNullParameter(prefetchFrom, "prefetchFrom");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.bid = bid;
        this.identifier = identifier;
        this.prefetchApi = prefetchApi;
        this.requestSuccess = z;
        this.prefetchStatus = i;
        this.prefetchFrom = prefetchFrom;
        this.errorMsg = errorMsg;
        this.duration = j;
        this.configFrom = str;
    }

    public /* synthetic */ PrefetchReportInfo(String str, Identifier identifier, String str2, boolean z, int i, String str3, String str4, long j, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "default_bid" : str, identifier, str2, z, i, str3, str4, j, str5);
    }

    public final String getBid() {
        return this.bid;
    }

    public final void setBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bid = str;
    }

    public final Identifier getIdentifier() {
        return this.identifier;
    }

    public final void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public final String getPrefetchApi() {
        return this.prefetchApi;
    }

    public final void setPrefetchApi(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.prefetchApi = str;
    }

    public final boolean getRequestSuccess() {
        return this.requestSuccess;
    }

    public final void setRequestSuccess(boolean z) {
        this.requestSuccess = z;
    }

    public final int getPrefetchStatus() {
        return this.prefetchStatus;
    }

    public final void setPrefetchStatus(int i) {
        this.prefetchStatus = i;
    }

    public final String getPrefetchFrom() {
        return this.prefetchFrom;
    }

    public final void setPrefetchFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.prefetchFrom = str;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final void setErrorMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorMsg = str;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final String getConfigFrom() {
        return this.configFrom;
    }

    public final void setConfigFrom(String str) {
        this.configFrom = str;
    }
}
