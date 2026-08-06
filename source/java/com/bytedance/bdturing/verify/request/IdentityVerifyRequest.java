package com.bytedance.bdturing.verify.request;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.setting.SettingsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: IdentityVerifyRequest.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\u0014\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006#"}, d2 = {"Lcom/bytedance/bdturing/verify/request/IdentityVerifyRequest;", "Lcom/bytedance/bdturing/verify/request/AbstractRequest;", "certAid", "", "scene", "", "flow", DBHelper.BATTERY_COL_SOURCE, "detail", "ticket", "showDialog", "", "subType", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getCertAid", "()J", "getDetail", "()Ljava/lang/String;", "getFlow", "getScene", "getShowDialog", "()Z", "getSource", "getSubType", "getTicket", "buildUrl", "", "queryBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEventLimits", "", "getServiceType", "getType", "getVerifyType", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class IdentityVerifyRequest extends AbstractRequest {
    private final long certAid;
    private final String detail;
    private final String flow;
    private final String scene;
    private final boolean showDialog;
    private final String source;
    private final String subType;
    private final String ticket;

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    /* renamed from: getEventLimits */
    public int getMMaxEvents() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getServiceType() {
        return SettingsManager.IDENTITY_VERIFY_SERVICE;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public int getType() {
        return 14;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getVerifyType() {
        return "identity_two_elements_face";
    }

    public final long getCertAid() {
        return this.certAid;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getFlow() {
        return this.flow;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final boolean getShowDialog() {
        return this.showDialog;
    }

    public final String getSubType() {
        return this.subType;
    }

    public IdentityVerifyRequest(long j, String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "flow");
        Intrinsics.checkNotNullParameter(str3, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.checkNotNullParameter(str4, "detail");
        Intrinsics.checkNotNullParameter(str5, "ticket");
        Intrinsics.checkNotNullParameter(str6, "subType");
        this.certAid = j;
        this.scene = str;
        this.flow = str2;
        this.source = str3;
        this.detail = str4;
        this.ticket = str5;
        this.showDialog = z;
        this.subType = str6;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public void buildUrl(StringBuilder queryBuilder) {
        Intrinsics.checkNotNullParameter(queryBuilder, "queryBuilder");
        StringsKt.clear(queryBuilder);
        queryBuilder.append(SettingsManager.INSTANCE.getDataWithFallback(getServiceType(), "report_url"));
    }
}
