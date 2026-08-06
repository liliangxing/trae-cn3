package com.bytedance.bdturing.verify.request;

import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfoVerifyRequest.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/bdturing/verify/request/InfoVerifyRequest;", "Lcom/bytedance/bdturing/verify/request/AbstractRequest;", "()V", "buildUrl", "", "queryBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEventLimits", "", "getServiceType", "", "getType", "getVerifyType", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class InfoVerifyRequest extends AbstractRequest {
    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public int getEventLimits() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getServiceType() {
        return SettingsManager.TWICE_VERIFY_SERVICE;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public int getType() {
        return 10;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getVerifyType() {
        return "info_verify";
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public void buildUrl(StringBuilder queryBuilder) {
        Intrinsics.checkNotNullParameter(queryBuilder, "queryBuilder");
        UtilsKt.appendParams(queryBuilder, "decision_config", "block-info_verify");
        UtilsKt.appendParams(queryBuilder, "use_turing_bridge", 1);
    }
}
