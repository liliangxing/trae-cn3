package com.bytedance.bdturing.verify;

import android.app.Activity;
import com.bytedance.bdturing.BdTuringCallback;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.setting.SettingUpdateRequest;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RiskControlService.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/bytedance/bdturing/verify/RiskControlService$execute$2", "Lcom/bytedance/bdturing/setting/SettingUpdateRequest$Callback;", "onResponse", "", "responseCode", "", "responseContent", "", "duration", "", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class RiskControlService$execute$2 implements SettingUpdateRequest.Callback {
    final /* synthetic */ BdTuringCallback $callback;
    final /* synthetic */ AbstractRequest $request;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RiskControlService$execute$2(AbstractRequest abstractRequest, BdTuringCallback bdTuringCallback) {
        this.$request = abstractRequest;
        this.$callback = bdTuringCallback;
    }

    @Override // com.bytedance.bdturing.setting.SettingUpdateRequest.Callback
    public void onResponse(int responseCode, String responseContent, long duration) {
        Activity activity;
        Activity activity2 = this.$request.getActivity();
        boolean z = false;
        if (activity2 != null && activity2.isFinishing()) {
            z = true;
        }
        if (z || (activity = this.$request.getActivity()) == null) {
            return;
        }
        final AbstractRequest abstractRequest = this.$request;
        final BdTuringCallback bdTuringCallback = this.$callback;
        activity.runOnUiThread(new Runnable() { // from class: com.bytedance.bdturing.verify.RiskControlService$execute$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RiskControlService$execute$2.m439onResponse$lambda0(AbstractRequest.this, bdTuringCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onResponse$lambda-0, reason: not valid java name */
    public static final void m439onResponse$lambda0(AbstractRequest abstractRequest, BdTuringCallback bdTuringCallback) {
        Intrinsics.checkNotNullParameter(abstractRequest, "$request");
        Intrinsics.checkNotNullParameter(bdTuringCallback, "$callback");
        EventReport.verifyStart(abstractRequest);
        RiskControlService.INSTANCE.doVerify(abstractRequest, bdTuringCallback);
    }
}
