package com.bytedance.bdturing.livedetect;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringCallback;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.VerifyProtector;
import com.bytedance.bdturing.livedetect.net.CommonResponse;
import com.bytedance.bdturing.livedetect.pty.PTYInitCallBack;
import com.bytedance.bdturing.livedetect.pty.TuringPTYManager;
import com.bytedance.bdturing.ttnet.ITuringNetworkCallBack;
import com.bytedance.bdturing.ttnet.TuringCommonRequest;
import com.bytedance.bdturing.utils.JsonUtils;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import com.bytedance.bdturing.verify.request.LiveDetectRequest;
import com.bytedance.bdturing.verify.request.RiskInfoRequest;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LiveFallbackStrategy {
    private static volatile LiveFallbackStrategy sInstance;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface InterceptCallBack {
        void onResult(boolean z);
    }

    private LiveFallbackStrategy() {
    }

    public static LiveFallbackStrategy getInstance() {
        if (sInstance == null) {
            synchronized (LiveFallbackStrategy.class) {
                if (sInstance == null) {
                    sInstance = new LiveFallbackStrategy();
                }
            }
        }
        return sInstance;
    }

    public void intercept(AbstractRequest abstractRequest, BdTuringCallback bdTuringCallback, InterceptCallBack interceptCallBack) {
        if (abstractRequest == null || bdTuringCallback == null) {
            interceptCallBack.onResult(false);
            return;
        }
        if (!(abstractRequest instanceof RiskInfoRequest)) {
            interceptCallBack.onResult(false);
            return;
        }
        if (!(((RiskInfoRequest) abstractRequest).getInnerRequest() instanceof LiveDetectRequest)) {
            interceptCallBack.onResult(false);
            return;
        }
        try {
            if (LiveDetectService.getInstance().useByteNN()) {
                dispatchFromByteNN(abstractRequest, bdTuringCallback, interceptCallBack);
            } else {
                dispatchFromPitaya(abstractRequest, bdTuringCallback, interceptCallBack);
            }
        } catch (Exception e) {
            EventReport.liveDispatchResult(false, "_1", "errorMessage:" + e, abstractRequest);
            interceptCallBack.onResult(false);
            e.printStackTrace();
        }
    }

    private void dispatchFromByteNN(AbstractRequest abstractRequest, BdTuringCallback bdTuringCallback, InterceptCallBack interceptCallBack) {
        if (!LiveDetectService.getInstance().byteNNDispatchEnable()) {
            interceptCallBack.onResult(false);
            return;
        }
        Pair<Boolean, String> liveDetectState = LiveDetectService.getInstance().liveDetectState();
        if (((Boolean) liveDetectState.first).booleanValue()) {
            interceptCallBack.onResult(false);
        } else {
            doLiveDispatchVerify((RiskInfoRequest) abstractRequest, bdTuringCallback, interceptCallBack, (String) liveDetectState.second);
        }
    }

    private void dispatchFromPitaya(final AbstractRequest abstractRequest, final BdTuringCallback bdTuringCallback, final InterceptCallBack interceptCallBack) {
        Pair<Boolean, String> isPTYReady = isPTYReady();
        final String str = (String) isPTYReady.second;
        EventReport.liveAvailableCheck(((Boolean) isPTYReady.first).booleanValue(), (String) isPTYReady.second, abstractRequest);
        if (!((Boolean) isPTYReady.first).booleanValue()) {
            interceptCallBack.onResult(false);
        } else if (TuringPTYManager.getInstance().isPTYAvailable() && !TuringPTYManager.getInstance().isPkgLoaded()) {
            TuringPTYManager.getInstance().queryPkg("live_fall_back_strategy", new TuringPTYManager.TuringPtyPkgCallBack() { // from class: com.bytedance.bdturing.livedetect.LiveFallbackStrategy.1
                @Override // com.bytedance.bdturing.livedetect.pty.TuringPTYManager.TuringPtyPkgCallBack
                public void onResult(boolean z) {
                    if (!z) {
                        LiveFallbackStrategy.this.doLiveDispatchVerify((RiskInfoRequest) abstractRequest, bdTuringCallback, interceptCallBack, str);
                    } else {
                        interceptCallBack.onResult(false);
                    }
                }
            });
        } else {
            doLiveDispatchVerify((RiskInfoRequest) abstractRequest, bdTuringCallback, interceptCallBack, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLiveDispatchVerify(final RiskInfoRequest riskInfoRequest, final BdTuringCallback bdTuringCallback, final InterceptCallBack interceptCallBack, final String str) {
        try {
            initPTY();
            String detail = ((LiveDetectRequest) riskInfoRequest.getInnerRequest()).getDetail();
            String liveDispatchUrl = LiveAuthConfig.getLiveDispatchUrl();
            HashMap hashMap = new HashMap();
            hashMap.put("detail", detail);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("Content-Type", "application/json; charset=utf-8");
            new TuringCommonRequest(liveDispatchUrl, hashMap, null, hashMap2).doPost(new ITuringNetworkCallBack() { // from class: com.bytedance.bdturing.livedetect.LiveFallbackStrategy.2
                @Override // com.bytedance.bdturing.ttnet.ITuringNetworkCallBack
                public void onResponse(CommonResponse commonResponse) {
                    final String str2;
                    String optString = commonResponse.data != null ? commonResponse.data.optString("decision") : "";
                    if (TextUtils.isEmpty(optString)) {
                        String str3 = "live verify dispatch fail:decision_is_null," + commonResponse;
                        JsonUtils.putValue(new JSONObject(), "errorMessage", str3);
                        EventReport.liveDispatch(false, str, "", str3, riskInfoRequest);
                        InterceptCallBack interceptCallBack2 = interceptCallBack;
                        if (interceptCallBack2 != null) {
                            interceptCallBack2.onResult(false);
                            return;
                        }
                        return;
                    }
                    try {
                        str2 = new JSONObject(optString).optString("detail");
                    } catch (Exception e) {
                        e.printStackTrace();
                        str2 = "";
                    }
                    Activity topActivity = BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getTopActivity() : null;
                    RiskInfoRequest riskInfoRequest2 = new RiskInfoRequest(optString);
                    EventReport.liveDispatch(true, str, riskInfoRequest2.getVerifyType(), "", riskInfoRequest);
                    final String verifyType = riskInfoRequest2.getVerifyType();
                    BdTuring.getInstance().showVerifyDialog(topActivity, riskInfoRequest2, new BdTuringCallback() { // from class: com.bytedance.bdturing.livedetect.LiveFallbackStrategy.2.1
                        @Override // com.bytedance.bdturing.BdTuringCallback
                        public void onFail(int i, JSONObject jSONObject) {
                            bdTuringCallback.onFail(i, jSONObject);
                            EventReport.liveDispatchResult(false, verifyType, "verify_fail", riskInfoRequest);
                        }

                        @Override // com.bytedance.bdturing.BdTuringCallback
                        public void onSuccess(int i, JSONObject jSONObject) {
                            JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject(VerifyProtector.NOTIFY_DATA_KEY) : null;
                            if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.optString("subtype"))) {
                                LiveFallbackStrategy.this.reportVerifyResult(riskInfoRequest, i, optJSONObject, jSONObject, verifyType, str2, bdTuringCallback);
                            } else {
                                EventReport.liveDispatchResult(true, verifyType, "", riskInfoRequest);
                                bdTuringCallback.onSuccess(i, jSONObject);
                            }
                        }
                    }, false);
                }

                @Override // com.bytedance.bdturing.ttnet.ITuringNetworkCallBack
                public void onError(Throwable th) {
                    String str2 = "live verify dispatch fail net_work_error:" + th;
                    JsonUtils.putValue(new JSONObject(), "errorMessage", str2);
                    EventReport.liveDispatch(false, str, "", str2, riskInfoRequest);
                    InterceptCallBack interceptCallBack2 = interceptCallBack;
                    if (interceptCallBack2 != null) {
                        interceptCallBack2.onResult(false);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            String str2 = "live verify dispatch fail exception:" + e;
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putValue(jSONObject, "errorMessage", str2);
            EventReport.liveDispatch(false, str, "", str2, riskInfoRequest);
            bdTuringCallback.onFail(1, jSONObject);
        }
    }

    private static void initPTY() {
        TuringPTYManager.getInstance().initPTY(BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getApplicationContext() : null, new PTYInitCallBack() { // from class: com.bytedance.bdturing.livedetect.LiveFallbackStrategy.3
            @Override // com.bytedance.bdturing.livedetect.pty.PTYInitCallBack
            public void onResult(boolean z) {
                EventReport.initPTY(z, "live_fall_back_strategy");
            }
        }, "live_fall_back_strategy");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportVerifyResult(final RiskInfoRequest riskInfoRequest, final int i, JSONObject jSONObject, final JSONObject jSONObject2, final String str, String str2, final BdTuringCallback bdTuringCallback) {
        String pathLiveDispatchNotify = LiveAuthConfig.getPathLiveDispatchNotify();
        HashMap hashMap = new HashMap();
        hashMap.put("detail", str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Content-Type", "application/json; charset=utf-8");
        new TuringCommonRequest(pathLiveDispatchNotify, hashMap, JsonUtils.jsonToMap(jSONObject), hashMap2).doPost(new ITuringNetworkCallBack() { // from class: com.bytedance.bdturing.livedetect.LiveFallbackStrategy.4
            @Override // com.bytedance.bdturing.ttnet.ITuringNetworkCallBack
            public void onResponse(CommonResponse commonResponse) {
                if (commonResponse != null && commonResponse.code == 200) {
                    if (bdTuringCallback != null) {
                        EventReport.liveDispatchResult(true, str, "", riskInfoRequest);
                        bdTuringCallback.onSuccess(i, jSONObject2);
                        return;
                    }
                    return;
                }
                if (bdTuringCallback != null) {
                    JSONObject jSONObject3 = jSONObject2;
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    JsonUtils.putValue(jSONObject3, "errorMessage", "live dispatch verify report result failed");
                    EventReport.liveDispatchResult(false, str, "send_result_fail", riskInfoRequest);
                    bdTuringCallback.onFail(BdTuring.LIVE_DISPATCH_VERIFY_FAIL, jSONObject3);
                }
            }

            @Override // com.bytedance.bdturing.ttnet.ITuringNetworkCallBack
            public void onError(Throwable th) {
                if (bdTuringCallback != null) {
                    JSONObject jSONObject3 = jSONObject2;
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    JsonUtils.putValue(jSONObject3, "errorMessage", "live dispatch verify report result failed");
                    EventReport.liveDispatchResult(false, str, "send_result_fail", riskInfoRequest);
                    bdTuringCallback.onFail(BdTuring.LIVE_DISPATCH_VERIFY_FAIL, jSONObject3);
                }
            }
        });
    }

    private Pair<Boolean, String> isPTYReady() {
        String str;
        boolean isPTYReady = TuringPTYManager.getInstance().isPTYReady();
        if (isPTYReady) {
            str = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("PTY init not finish:pkg_load=" + TuringPTYManager.getInstance().isPkgLoaded() + ":mInitSate=" + TuringPTYManager.getInstance().getInitState() + ":PTY Env_Available=" + TuringPTYManager.getInstance().isPTYAvailable() + ":appFirstLaunch=" + LiveAuthConfig.isAppFirstLaunch() + ":ptyHostEnable=" + LiveAuthConfig.mPtyHostEnable);
            str = sb.toString();
        }
        return new Pair<>(Boolean.valueOf(!isPTYReady), str);
    }
}
