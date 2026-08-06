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

/* compiled from: UpSmsRequest.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0014\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/bdturing/verify/request/UpSmsRequest;", "Lcom/bytedance/bdturing/verify/request/AbstractRequest;", "verifyTicket", "", "channelMobile", "smsContent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelMobile", "()Ljava/lang/String;", "setChannelMobile", "(Ljava/lang/String;)V", "getSmsContent", "setSmsContent", "getVerifyTicket", "setVerifyTicket", "buildUrl", "", "queryBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEventLimits", "", "getServiceType", "getType", "getVerifyType", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class UpSmsRequest extends AbstractRequest {
    private String channelMobile;
    private String smsContent;
    private String verifyTicket;

    public UpSmsRequest() {
        this(null, null, null, 7, null);
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
        return 6;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getVerifyType() {
        return TuringVerifyType.mobile_up_sms_verify;
    }

    public UpSmsRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "verifyTicket");
        Intrinsics.checkNotNullParameter(str2, "channelMobile");
        Intrinsics.checkNotNullParameter(str3, "smsContent");
        this.verifyTicket = str;
        this.channelMobile = str2;
        this.smsContent = str3;
    }

    public /* synthetic */ UpSmsRequest(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getChannelMobile() {
        return this.channelMobile;
    }

    public final String getSmsContent() {
        return this.smsContent;
    }

    public final String getVerifyTicket() {
        return this.verifyTicket;
    }

    public final void setChannelMobile(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelMobile = str;
    }

    public final void setSmsContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.smsContent = str;
    }

    public final void setVerifyTicket(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.verifyTicket = str;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public void buildUrl(StringBuilder queryBuilder) {
        Intrinsics.checkNotNullParameter(queryBuilder, "queryBuilder");
        UtilsKt.appendParams(queryBuilder, "decision_config", "block-upsms");
        UtilsKt.appendParams(queryBuilder, "is_turing", 1);
        if (!TextUtils.isEmpty(this.verifyTicket)) {
            UtilsKt.appendParams(queryBuilder, "verify_ticket", this.verifyTicket);
        }
        UtilsKt.appendParams(queryBuilder, "channel_mobile", this.channelMobile);
        UtilsKt.appendParams(queryBuilder, "sms_content", this.smsContent);
        UtilsKt.appendParams(queryBuilder, "use_turing_bridge", 1);
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        UtilsKt.appendParams(queryBuilder, "use_sms_mode", config != null ? config.getSmsDigits() : 0);
    }
}
