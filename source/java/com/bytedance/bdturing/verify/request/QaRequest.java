package com.bytedance.bdturing.verify.request;

import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QaRequest.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0011\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0014\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/bdturing/verify/request/QaRequest;", "Lcom/bytedance/bdturing/verify/request/AbstractRequest;", "fullScreen", "", "(Z)V", "uid", "", "(ZLjava/lang/String;)V", "(Ljava/lang/String;)V", "getUid", "()Ljava/lang/String;", "setUid", "buildUrl", "", "queryBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEventLimits", "", "getServiceType", "getType", "getVerifyType", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class QaRequest extends AbstractRequest {
    private String uid;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QaRequest() {
        this(r0, 1, r0);
        String str = null;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    /* renamed from: getEventLimits */
    public int getMMaxEvents() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getServiceType() {
        return "qa";
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public int getType() {
        return 3;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getVerifyType() {
        return "qa";
    }

    public /* synthetic */ QaRequest(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getUid() {
        return this.uid;
    }

    public final void setUid(String str) {
        this.uid = str;
    }

    public QaRequest(String str) {
        this.uid = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QaRequest(boolean z) {
        this(r0, 1, r0);
        String str = null;
        setFullscreen(z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QaRequest(boolean z, String str) {
        this(r0, 1, r0);
        Intrinsics.checkNotNullParameter(str, "uid");
        String str2 = null;
        setFullscreen(z);
        this.uid = str;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public void buildUrl(StringBuilder queryBuilder) {
        Intrinsics.checkNotNullParameter(queryBuilder, "queryBuilder");
        UtilsKt.appendParams(queryBuilder, "isPop", !getFullscreen() ? 1 : 0);
        UtilsKt.appendParams(queryBuilder, "uid", this.uid);
        UtilsKt.appendParams(queryBuilder, "use_dialog_size_v2", SettingsManager.INSTANCE.getUseDialogSizeV2());
    }
}
