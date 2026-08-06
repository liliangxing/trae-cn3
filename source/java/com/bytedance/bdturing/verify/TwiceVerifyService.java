package com.bytedance.bdturing.verify;

import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringCallback;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.VerifyProtector;
import com.bytedance.bdturing.monitor.VerifyStateManager;
import com.bytedance.bdturing.twiceverify.TwiceVerifyManager;
import com.bytedance.bdturing.utils.JsonUtils;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TwiceVerifyService implements ITuringVerifyService {
    private boolean isOnVerify;

    @Override // com.bytedance.bdturing.verify.IVerifyService
    public boolean isProcess(int i) {
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
                return true;
            case 12:
            default:
                return false;
        }
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public boolean isSenseless() {
        return false;
    }

    @Override // com.bytedance.bdturing.verify.IVerifyService
    public boolean execute(final AbstractRequest abstractRequest, final BdTuringCallback bdTuringCallback) {
        if (!TwiceVerifyManager.getInstance().checkInit()) {
            return false;
        }
        if (isOnVerify()) {
            bdTuringCallback.onFail(BdTuring.VERIFY_FAIL_CONFLICT, null);
            VerifyStateManager.getInstance().verifyConflict(abstractRequest, "");
            EventReport.verifyConflict(abstractRequest, "TwiceVerifyService");
            return true;
        }
        setOnVerify(true);
        EventReport.twiceVerifyStart(abstractRequest);
        TwiceVerifyManager.getInstance().startVerify(abstractRequest, null, new TwiceVerifyManager.VerifyCallBack() { // from class: com.bytedance.bdturing.verify.TwiceVerifyService.1
            @Override // com.bytedance.bdturing.twiceverify.TwiceVerifyManager.VerifyCallBack
            public void onSuccess() {
                TwiceVerifyService.this.setOnVerify(false);
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JsonUtils.putValue(jSONObject2, "subtype", abstractRequest.getVerifyType());
                JsonUtils.putValue(jSONObject, VerifyProtector.NOTIFY_DATA_KEY, jSONObject2);
                EventReport.twiceVerifyResult(true, null, abstractRequest);
                bdTuringCallback.onSuccess(0, null);
            }

            @Override // com.bytedance.bdturing.twiceverify.TwiceVerifyManager.VerifyCallBack
            public void onError(int i, String str) {
                TwiceVerifyService.this.setOnVerify(false);
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putValue(jSONObject, AlogMonitor.ALOG_RESULT_CODE, Integer.valueOf(i));
                JsonUtils.putValue(jSONObject, "message", str);
                EventReport.twiceVerifyResult(false, jSONObject, abstractRequest);
                bdTuringCallback.onFail(i, null);
            }
        });
        return true;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public synchronized boolean isOnVerify() {
        return this.isOnVerify;
    }

    public synchronized void setOnVerify(boolean z) {
        this.isOnVerify = z;
    }
}
