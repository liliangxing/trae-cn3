package com.bytedance.bdturing.uc_twiceverify;

import android.app.Activity;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringCallback;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.VerifyProtector;
import com.bytedance.bdturing.monitor.VerifyStateManager;
import com.bytedance.bdturing.utils.JsonUtils;
import com.bytedance.bdturing.verify.ITuringVerifyService;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import com.bytedance.bdturing.verify.request.RiskInfoRequest;
import com.bytedance.bdturing.verify.request.UCTwiceVerifyRequest;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class UCTwiceVerifyService implements ITuringVerifyService {
    private static final String TAG = "UCTwiceVerifyService";
    private boolean isOnVerify;
    private AbstractRequest mRequest;

    @Override // com.bytedance.bdturing.verify.IVerifyService
    public boolean isProcess(int i) {
        return 17 == i;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public boolean isSenseless() {
        return false;
    }

    @Override // com.bytedance.bdturing.verify.IVerifyService
    public boolean execute(AbstractRequest abstractRequest, final BdTuringCallback bdTuringCallback) {
        final AbstractRequest innerRequest = abstractRequest instanceof RiskInfoRequest ? ((RiskInfoRequest) abstractRequest).getInnerRequest() : null;
        EventReport.ucTwiceParamReceive(abstractRequest);
        if (innerRequest == null || !(innerRequest instanceof UCTwiceVerifyRequest)) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putValue(jSONObject, "errorMsg", "request type is not UCTwiceVerifyRequest!");
            bdTuringCallback.onFail(BdTuring.VERIFY_FAIL_NOT_SUPPORT, jSONObject);
            return true;
        }
        if (isOnVerify()) {
            bdTuringCallback.onFail(BdTuring.VERIFY_FAIL_CONFLICT, null);
            VerifyStateManager.getInstance().verifyConflict(abstractRequest, "");
            EventReport.verifyConflict(abstractRequest, "UC_Twice_Verify");
            return true;
        }
        this.mRequest = abstractRequest;
        Activity activity = abstractRequest.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.bytedance.bdturing.uc_twiceverify.UCTwiceVerifyService.1
                @Override // java.lang.Runnable
                public void run() {
                    UCTwiceVerifyService.this.doVerify((UCTwiceVerifyRequest) innerRequest, bdTuringCallback);
                }
            });
        } else {
            LogUtil.m161e(TAG, "topActivity is null");
            JSONObject jSONObject2 = new JSONObject();
            JsonUtils.putValue(jSONObject2, "errorMsg", "topActivity is null");
            noticeResult(false, jSONObject2, bdTuringCallback);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doVerify(UCTwiceVerifyRequest uCTwiceVerifyRequest, final BdTuringCallback bdTuringCallback) {
        final String str;
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        UCTwiceVerifyDepend ucTwiceVerifyDepend = BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getUcTwiceVerifyDepend() : null;
        try {
            jSONObject = new JSONObject(uCTwiceVerifyRequest.getDecision());
        } catch (Exception e) {
            e = e;
        }
        try {
            str = uCTwiceVerifyRequest.getVerifyType();
        } catch (Exception e2) {
            e = e2;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            str = "";
            jSONObject = jSONObject2;
            if (ucTwiceVerifyDepend == null) {
            }
            LogUtil.m162i(TAG, "depend is null or decision is null");
            JSONObject jSONObject3 = new JSONObject();
            JsonUtils.putValue(jSONObject3, "msg", "depend is null or decision is null");
            noticeResult(false, jSONObject3, bdTuringCallback);
        }
        if (ucTwiceVerifyDepend == null && jSONObject != null) {
            setOnVerify(true);
            boolean startTwiceVerify = ucTwiceVerifyDepend.startTwiceVerify(jSONObject, new UCTwiceVerifyResultCallback() { // from class: com.bytedance.bdturing.uc_twiceverify.UCTwiceVerifyService.2
                @Override // com.bytedance.bdturing.uc_twiceverify.UCTwiceVerifyResultCallback
                public void onResult(int i, JSONObject jSONObject4) {
                    EventReport.ucTwiceVerifyEnd(i, jSONObject4, UCTwiceVerifyService.this.mRequest);
                    if (jSONObject4 == null) {
                        jSONObject4 = new JSONObject();
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    JsonUtils.putValue(jSONObject5, "subtype", str);
                    JsonUtils.putValue(jSONObject4, VerifyProtector.NOTIFY_DATA_KEY, jSONObject5);
                    UCTwiceVerifyService.this.noticeResult(i == 0, jSONObject4, bdTuringCallback);
                }
            });
            EventReport.ucTwiceVerifyStart(!startTwiceVerify ? 1 : 0, this.mRequest);
            if (startTwiceVerify) {
                return;
            }
            LogUtil.m162i(TAG, "UCTwiceVerify start failed");
            JSONObject jSONObject4 = new JSONObject();
            JsonUtils.putValue(jSONObject4, "msg", "UCTwiceVerify start failed");
            noticeResult(false, jSONObject4, bdTuringCallback);
            return;
        }
        LogUtil.m162i(TAG, "depend is null or decision is null");
        JSONObject jSONObject32 = new JSONObject();
        JsonUtils.putValue(jSONObject32, "msg", "depend is null or decision is null");
        noticeResult(false, jSONObject32, bdTuringCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void noticeResult(boolean z, JSONObject jSONObject, BdTuringCallback bdTuringCallback) {
        setOnVerify(false);
        if (bdTuringCallback != null) {
            if (z) {
                bdTuringCallback.onSuccess(0, jSONObject);
            } else {
                bdTuringCallback.onFail(1, jSONObject);
            }
        }
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public synchronized boolean isOnVerify() {
        return this.isOnVerify;
    }

    public synchronized void setOnVerify(boolean z) {
        EventReport.VerifyStateChange(z, "UCTwiceVerify", this.mRequest);
        this.isOnVerify = z;
    }
}
