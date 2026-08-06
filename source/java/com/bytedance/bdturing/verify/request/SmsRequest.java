package com.bytedance.bdturing.verify.request;

import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SmsRequest.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/bdturing/verify/request/SmsRequest;", "Lcom/bytedance/bdturing/verify/request/AbstractRequest;", "scene", "", "showToastSuccess", "", "(Ljava/lang/String;Z)V", "uid", "(Ljava/lang/String;ZLjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getShowToastSuccess", "()Z", "setShowToastSuccess", "(Z)V", "getUid", "setUid", "buildUrl", "", "queryBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEventLimits", "", "getServiceType", "getType", "getVerifyType", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class SmsRequest extends AbstractRequest {
    private String scene;
    private boolean showToastSuccess;
    private String uid;

    public SmsRequest() {
        this(null, false, null, 7, null);
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    /* renamed from: getEventLimits */
    public int getMMaxEvents() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getServiceType() {
        return "sms";
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public int getType() {
        return 1;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getVerifyType() {
        return "sms";
    }

    public /* synthetic */ SmsRequest(String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str2);
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setScene(String str) {
        this.scene = str;
    }

    public final boolean getShowToastSuccess() {
        return this.showToastSuccess;
    }

    public final void setShowToastSuccess(boolean z) {
        this.showToastSuccess = z;
    }

    public final String getUid() {
        return this.uid;
    }

    public final void setUid(String str) {
        this.uid = str;
    }

    public SmsRequest(String str, boolean z, String str2) {
        this.scene = str;
        this.showToastSuccess = z;
        this.uid = str2;
        setFullscreen(true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmsRequest(String str, boolean z) {
        this(null, false, null, 7, null);
        Intrinsics.checkNotNullParameter(str, "scene");
        this.scene = str;
        this.showToastSuccess = z;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public void buildUrl(StringBuilder queryBuilder) {
        Intrinsics.checkNotNullParameter(queryBuilder, "queryBuilder");
        UtilsKt.appendParams(queryBuilder, "scene", this.scene);
        UtilsKt.appendParams(queryBuilder, "show_success_toast", this.showToastSuccess ? 1 : 0);
        UtilsKt.appendParams(queryBuilder, "uid", this.uid);
        UtilsKt.appendParams(queryBuilder, "use_dialog_size_v2", SettingsManager.INSTANCE.getUseDialogSizeV2());
    }
}
