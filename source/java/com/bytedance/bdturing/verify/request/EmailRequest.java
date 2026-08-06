package com.bytedance.bdturing.verify.request;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.utils.UtilsKt;
import com.bytedance.bdturing.verify.TuringVerifyType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmailRequest.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/bytedance/bdturing/verify/request/EmailRequest;", "Lcom/bytedance/bdturing/verify/request/AbstractRequest;", "verifyTicket", "", "(Ljava/lang/String;)V", "getVerifyTicket", "()Ljava/lang/String;", "setVerifyTicket", "buildUrl", "", "queryBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEventLimits", "", "getServiceType", "getType", "getVerifyType", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class EmailRequest extends AbstractRequest {
    private String verifyTicket;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EmailRequest() {
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
        return SettingsManager.TWICE_VERIFY_SERVICE;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public int getType() {
        return 11;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getVerifyType() {
        return TuringVerifyType.email_verify;
    }

    public EmailRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "verifyTicket");
        this.verifyTicket = str;
    }

    public /* synthetic */ EmailRequest(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getVerifyTicket() {
        return this.verifyTicket;
    }

    public final void setVerifyTicket(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.verifyTicket = str;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public void buildUrl(StringBuilder queryBuilder) {
        Intrinsics.checkNotNullParameter(queryBuilder, "queryBuilder");
        UtilsKt.appendParams(queryBuilder, "decision_config", TuringVerifyType.email_verify);
        if (!TextUtils.isEmpty(this.verifyTicket)) {
            UtilsKt.appendParams(queryBuilder, "verify_ticket", this.verifyTicket);
        }
        UtilsKt.appendParams(queryBuilder, "is_turing", 1);
        UtilsKt.appendParams(queryBuilder, "use_turing_bridge", 1);
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        UtilsKt.appendParams(queryBuilder, "use_email_mode", config != null ? config.getEmailDigits() : 0);
    }
}
