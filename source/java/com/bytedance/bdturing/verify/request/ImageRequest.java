package com.bytedance.bdturing.verify.request;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.livedetect.LiveAuthConfig;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.utils.UtilsKt;
import com.bytedance.bdturing.verify.TuringVerifyType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageRequest.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/bdturing/verify/request/ImageRequest;", "Lcom/bytedance/bdturing/verify/request/AbstractRequest;", "challengeCode", "", "(I)V", "getChallengeCode", "()I", "setChallengeCode", "subType", "", "getSubType", "()Ljava/lang/String;", "setSubType", "(Ljava/lang/String;)V", "buildUrl", "", "queryBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "cancelAble", "", "getEventLimits", "getServiceType", "getType", "getVerifyType", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ImageRequest extends AbstractRequest {
    private int challengeCode;
    private String subType;

    public ImageRequest() {
        this(0, 1, null);
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    /* renamed from: getEventLimits */
    public int getMMaxEvents() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getServiceType() {
        return SettingsManager.VERIFY_SERVICE;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public int getType() {
        return 2;
    }

    public ImageRequest(int i) {
        this.challengeCode = i;
        this.subType = "";
    }

    public /* synthetic */ ImageRequest(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getChallengeCode() {
        return this.challengeCode;
    }

    public final void setChallengeCode(int i) {
        this.challengeCode = i;
    }

    public final String getSubType() {
        return this.subType;
    }

    public final void setSubType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subType = str;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public String getVerifyType() {
        if (TextUtils.isEmpty(this.subType)) {
            return String.valueOf(this.challengeCode);
        }
        return this.subType;
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public boolean cancelAble() {
        if (Intrinsics.areEqual(TuringVerifyType.LIVE_H5, getVerifySubType())) {
            return LiveAuthConfig.liveDetectCancellable();
        }
        return SettingsManager.INSTANCE.getVerifyCancellable();
    }

    @Override // com.bytedance.bdturing.verify.request.AbstractRequest
    public void buildUrl(StringBuilder queryBuilder) {
        Intrinsics.checkNotNullParameter(queryBuilder, "queryBuilder");
        int i = this.challengeCode;
        if (i != 0) {
            UtilsKt.appendParams(queryBuilder, "challenge_code", i);
        }
        UtilsKt.appendParams(queryBuilder, "use_dialog_size_v2", SettingsManager.INSTANCE.getUseDialogSizeV2());
    }
}
