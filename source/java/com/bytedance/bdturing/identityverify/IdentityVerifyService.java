package com.bytedance.bdturing.identityverify;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringCallback;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.VerifyProtector;
import com.bytedance.bdturing.VerifyTaskHandler;
import com.bytedance.bdturing.comonui.ActivityLifeCycleObserver;
import com.bytedance.bdturing.monitor.VerifyStateManager;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.theme.ThemeConfig;
import com.bytedance.bdturing.ttnet.HttpClient;
import com.bytedance.bdturing.utils.JsonUtils;
import com.bytedance.bdturing.verify.ITuringVerifyService;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import com.bytedance.bdturing.verify.request.IdentityVerifyRequest;
import com.bytedance.bdturing.verify.request.RiskInfoRequest;
import java.util.HashMap;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class IdentityVerifyService extends ActivityLifeCycleObserver implements ITuringVerifyService {
    private static final String MSG_SUCCESS = "certificate_success";
    private static final String TAG = "CertifyService";
    private static final String TWO_FACTOR_VERIFY_FLOW = "webcast_risk_auth";
    private static volatile IdentityVerifyService sInstance;
    private boolean isOnVerify;
    private IdentityVerifyDialog mDialog;
    private AbstractRequest mRequest;
    private String mSubType = "";
    private String mResultTicket = "";
    private DialogCallback mDialogCallback = null;

    @Override // com.bytedance.bdturing.verify.IVerifyService
    public boolean isProcess(int i) {
        return 14 == i;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public boolean isSenseless() {
        return false;
    }

    public static IdentityVerifyService getInstance() {
        if (sInstance == null) {
            synchronized (IdentityVerifyService.class) {
                if (sInstance == null) {
                    sInstance = new IdentityVerifyService();
                }
            }
        }
        return sInstance;
    }

    private IdentityVerifyService() {
    }

    @Override // com.bytedance.bdturing.verify.IVerifyService
    public boolean execute(AbstractRequest abstractRequest, final BdTuringCallback bdTuringCallback) {
        final AbstractRequest abstractRequest2;
        final boolean z;
        if (abstractRequest instanceof RiskInfoRequest) {
            z = abstractRequest.getSkipConfirm();
            abstractRequest2 = ((RiskInfoRequest) abstractRequest).getInnerRequest();
        } else {
            abstractRequest2 = null;
            z = false;
        }
        if (abstractRequest2 == null || !(abstractRequest2 instanceof IdentityVerifyRequest)) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putValue(jSONObject, "errorMsg", "request type is not CertifyRequest!");
            bdTuringCallback.onFail(BdTuring.VERIFY_FAIL_NOT_SUPPORT, jSONObject);
            return true;
        }
        if (isOnVerify()) {
            bdTuringCallback.onFail(BdTuring.VERIFY_FAIL_CONFLICT, null);
            VerifyStateManager.getInstance().verifyConflict(abstractRequest, "");
            EventReport.verifyConflict(abstractRequest, "IdentityVerifyService");
            return true;
        }
        final Activity activity = abstractRequest.getActivity();
        this.mRequest = abstractRequest;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.bytedance.bdturing.identityverify.IdentityVerifyService.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!((IdentityVerifyRequest) abstractRequest2).getShowDialog() || z) {
                        IdentityVerifyService.this.verifyWithOutDialog(activity, abstractRequest2, bdTuringCallback);
                    } else if (SettingsManager.INSTANCE.getIdentityUseDialogV2()) {
                        IdentityVerifyService.this.verifyWithDialogV2(activity, abstractRequest2, bdTuringCallback);
                    } else {
                        IdentityVerifyService.this.verifyWithDialog(activity, abstractRequest2, bdTuringCallback);
                    }
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
    public void verifyWithOutDialog(Activity activity, AbstractRequest abstractRequest, BdTuringCallback bdTuringCallback) {
        try {
            EventReport.identity_confirm_dialog_pop(2, this.mRequest);
            setVerifySate(true);
            doVerify((IdentityVerifyRequest) abstractRequest, activity, bdTuringCallback);
        } catch (Exception e) {
            e.printStackTrace();
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putValue(jSONObject, "errorMsg", "doVerify exception");
            noticeResult(false, jSONObject, bdTuringCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyWithDialog(final Activity activity, final AbstractRequest abstractRequest, final BdTuringCallback bdTuringCallback) {
        try {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            this.mDialog = new IdentityVerifyDialog(activity, new DialogCallback() { // from class: com.bytedance.bdturing.identityverify.IdentityVerifyService.2
                @Override // com.bytedance.bdturing.identityverify.DialogCallback
                public void onConfirm() {
                    EventReport.identity_confirm_dialog_agree(0, IdentityVerifyService.this.mRequest);
                    IdentityVerifyService.this.doVerify((IdentityVerifyRequest) abstractRequest, activity, bdTuringCallback);
                }

                @Override // com.bytedance.bdturing.identityverify.DialogCallback
                public void onCancel() {
                    LogUtil.m161e(IdentityVerifyService.TAG, "cert verify cancel by user");
                    EventReport.identity_confirm_dialog_agree(1, IdentityVerifyService.this.mRequest);
                    activity.getApplication().unregisterActivityLifecycleCallbacks(IdentityVerifyService.this);
                    IdentityVerifyService.this.setVerifySate(false);
                    JSONObject jSONObject = new JSONObject();
                    JsonUtils.putValue(jSONObject, "errorMsg", "cert verify cancel by user");
                    IdentityVerifyService.this.noticeResult(false, jSONObject, bdTuringCallback);
                }
            });
            if (activity.isFinishing() || this.mDialog.isShowing()) {
                return;
            }
            activity.getApplication().registerActivityLifecycleCallbacks(this);
            this.mDialog.show();
            EventReport.identity_confirm_dialog_pop(0, this.mRequest);
            setVerifySate(true);
        } catch (Exception e) {
            e.printStackTrace();
            EventReport.identity_confirm_dialog_pop(1, this.mRequest);
            if (activity != null) {
                activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            }
            if (bdTuringCallback != null) {
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putValue(jSONObject, "errorMsg", "hand cert verify fail");
                bdTuringCallback.onFail(1, jSONObject);
            }
        }
    }

    public DialogCallback getDialogCallback() {
        return this.mDialogCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyWithDialogV2(final Activity activity, final AbstractRequest abstractRequest, final BdTuringCallback bdTuringCallback) {
        try {
            this.mDialogCallback = new DialogCallback() { // from class: com.bytedance.bdturing.identityverify.IdentityVerifyService.3
                @Override // com.bytedance.bdturing.identityverify.DialogCallback
                public void onConfirm() {
                    LogUtil.m161e(IdentityVerifyService.TAG, "cert verify onConfirm  v2");
                    EventReport.identity_confirm_dialog_agree(0, IdentityVerifyService.this.mRequest);
                    IdentityVerifyService.this.doVerify((IdentityVerifyRequest) abstractRequest, activity, bdTuringCallback);
                }

                @Override // com.bytedance.bdturing.identityverify.DialogCallback
                public void onCancel() {
                    LogUtil.m161e(IdentityVerifyService.TAG, "cert verify onCancel  v2");
                    EventReport.identity_confirm_dialog_agree(1, IdentityVerifyService.this.mRequest);
                    activity.getApplication().unregisterActivityLifecycleCallbacks(IdentityVerifyService.this);
                    IdentityVerifyService.this.setVerifySate(false);
                    JSONObject jSONObject = new JSONObject();
                    JsonUtils.putValue(jSONObject, "errorMsg", "cert verify cancel by user");
                    IdentityVerifyService.this.noticeResult(false, jSONObject, bdTuringCallback);
                }
            };
            activity.startActivity(new Intent(activity, (Class<?>) IdentityDialogActivity.class));
            EventReport.identity_confirm_dialog_pop(0, this.mRequest);
            setVerifySate(true);
        } catch (Exception e) {
            e.printStackTrace();
            EventReport.identity_confirm_dialog_pop(1, this.mRequest);
            if (activity != null) {
                activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            }
            if (bdTuringCallback != null) {
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putValue(jSONObject, "errorMsg", "hand cert verify fail");
                bdTuringCallback.onFail(1, jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doVerify(final IdentityVerifyRequest identityVerifyRequest, Activity activity, final BdTuringCallback bdTuringCallback) {
        String appId;
        String scene = identityVerifyRequest.getScene();
        String source = identityVerifyRequest.getSource();
        String flow = identityVerifyRequest.getFlow();
        if (identityVerifyRequest.getCertAid() > 0) {
            appId = identityVerifyRequest.getCertAid() + "";
        } else {
            appId = BdTuring.getInstance().getConfig().getAppId();
        }
        this.mSubType = identityVerifyRequest.getSubType();
        IIdentityVerifyDepend identityVerifyDepend = BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getIdentityVerifyDepend() : null;
        if (identityVerifyDepend != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("scene", scene);
                hashMap.put("flow", flow);
                hashMap.put("cert_app_id", appId);
                hashMap.put("mode", "0");
                hashMap.put(DBHelper.BATTERY_COL_SOURCE, source);
                hashMap.put("use_new_api", "true");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("detail", identityVerifyRequest.getDetail());
                hashMap.put("biz_info", jSONObject.toString());
                if (!TextUtils.isEmpty(identityVerifyRequest.getTicket())) {
                    hashMap.put("ticket", identityVerifyRequest.getTicket());
                }
                IdentityVerifyParam identityVerifyParam = new IdentityVerifyParam(activity, hashMap, BdTuring.getInstance().getConfig().getRegionType() == BdTuringConfig.RegionType.REGION_BOE);
                ThemeConfig themeConfig = BdTuring.getInstance().getConfig().getThemeConfig();
                identityVerifyParam.setTheme(themeConfig != null ? themeConfig.getIdentityVerifyTheme() : null);
                identityVerifyDepend.onVerify(identityVerifyParam, new IdentityVerifyCallBack() { // from class: com.bytedance.bdturing.identityverify.IdentityVerifyService.4
                    @Override // com.bytedance.bdturing.identityverify.IdentityVerifyCallBack
                    public boolean onH5Close(JSONObject jSONObject2) {
                        JSONObject jSONObject3 = new JSONObject();
                        boolean isVerifySuccess = IdentityVerifyService.this.isVerifySuccess(jSONObject2, jSONObject3);
                        IdentityVerifyService.this.noticeResult(isVerifySuccess, jSONObject3, bdTuringCallback);
                        EventReport.identity_verify_result(isVerifySuccess, jSONObject2, IdentityVerifyService.this.mRequest);
                        IdentityVerifyService.this.reportVerifyResult(jSONObject2, identityVerifyRequest);
                        return isVerifySuccess;
                    }

                    @Override // com.bytedance.bdturing.identityverify.IdentityVerifyCallBack
                    public boolean progressFinish(int i, JSONObject jSONObject2) {
                        JSONObject jSONObject3 = new JSONObject();
                        boolean isVerifySuccess = IdentityVerifyService.this.isVerifySuccess(jSONObject2, jSONObject3);
                        IdentityVerifyService.this.noticeResult(isVerifySuccess, jSONObject3, bdTuringCallback);
                        JSONObject jSONObject4 = new JSONObject();
                        JsonUtils.putValue(jSONObject4, "mode", Integer.valueOf(i));
                        JsonUtils.putValue(jSONObject4, "data", jSONObject2);
                        EventReport.identity_verify_result(isVerifySuccess, jSONObject4, IdentityVerifyService.this.mRequest);
                        IdentityVerifyService.this.reportVerifyResult(jSONObject2, identityVerifyRequest);
                        return isVerifySuccess;
                    }

                    @Override // com.bytedance.bdturing.identityverify.IdentityVerifyCallBack
                    public void onOpenLoginPage() {
                        JSONObject jSONObject2 = new JSONObject();
                        JsonUtils.putValue(jSONObject2, "msg", "cert conflict");
                        IdentityVerifyService.this.noticeResult(false, jSONObject2, bdTuringCallback);
                        JSONObject jSONObject3 = new JSONObject();
                        JsonUtils.putValue(jSONObject3, "onOpenLoginPage", 1);
                        EventReport.identity_verify_result(false, jSONObject3, IdentityVerifyService.this.mRequest);
                        IdentityVerifyService.this.reportVerifyResult(null, identityVerifyRequest);
                    }
                });
                EventReport.identity_load_cert_sdk(0, this.mRequest);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                EventReport.identity_load_cert_sdk(1, this.mRequest);
                JSONObject jSONObject2 = new JSONObject();
                JsonUtils.putValue(jSONObject2, "msg", "load cert sdk failed");
                noticeResult(false, jSONObject2, bdTuringCallback);
                return;
            }
        }
        LogUtil.m162i(TAG, "certVerifyDepend is null");
        JSONObject jSONObject3 = new JSONObject();
        JsonUtils.putValue(jSONObject3, "msg", "certVerifyDepend is null");
        noticeResult(false, jSONObject3, bdTuringCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportVerifyResult(final JSONObject jSONObject, final IdentityVerifyRequest identityVerifyRequest) {
        VerifyTaskHandler.getInstance().postRunnable(new Runnable() { // from class: com.bytedance.bdturing.identityverify.IdentityVerifyService.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String url = identityVerifyRequest.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    String appId = BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getAppId() : null;
                    long j = 0;
                    try {
                        if (!TextUtils.isEmpty(appId)) {
                            j = Long.parseLong(appId);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    jSONObject2.put("aid", j);
                    jSONObject2.put("scene", identityVerifyRequest.getScene());
                    jSONObject2.put("detail", identityVerifyRequest.getDetail());
                    JSONObject jSONObject3 = jSONObject;
                    JSONObject optJSONObject = jSONObject3 != null ? jSONObject3.optJSONObject("ext_data") : null;
                    jSONObject2.put("ticket", optJSONObject != null ? optJSONObject.optString("ticket") : "");
                    byte[] bytes = jSONObject2.toString().getBytes(Charsets.UTF_8);
                    HttpClient httpClient = BdTuring.getInstance().getConfig().getHttpClient();
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json; charset=utf-8");
                    LogUtil.m162i(IdentityVerifyService.TAG, "===>reportVerifyResult finish stateCode:" + new JSONObject(new String(httpClient.post(url, hashMap, bytes), Charsets.UTF_8)).optInt("err_code", -1));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isVerifySuccess(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("error_code", -1);
            String optString = jSONObject.optString("error_msg");
            JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
            this.mResultTicket = optJSONObject != null ? optJSONObject.optString("ticket") : "";
            if (MSG_SUCCESS.equals(optString) && optInt == 0) {
                return true;
            }
            JsonUtils.putValue(jSONObject2, "errorCode", Integer.valueOf(optInt));
            JsonUtils.putValue(jSONObject2, "errorMsg", optString);
        }
        return false;
    }

    @Override // com.bytedance.bdturing.comonui.ActivityLifeCycleObserver, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        IdentityVerifyDialog identityVerifyDialog = this.mDialog;
        if (identityVerifyDialog != null && identityVerifyDialog.isShowing() && this.mDialog.getHostActivity() == activity) {
            setVerifySate(false);
            this.mDialog.dismiss();
            this.mDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setVerifySate(boolean z) {
        EventReport.VerifyStateChange(z, "IdentityVerifyService", this.mRequest);
        this.isOnVerify = z;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public synchronized boolean isOnVerify() {
        return this.isOnVerify;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void noticeResult(boolean z, JSONObject jSONObject, BdTuringCallback bdTuringCallback) {
        setVerifySate(false);
        this.mDialog = null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putValue(jSONObject2, "subtype", this.mSubType);
        JsonUtils.putValue(jSONObject2, "ticket", this.mResultTicket);
        JsonUtils.putValue(jSONObject, VerifyProtector.NOTIFY_DATA_KEY, jSONObject2);
        if (bdTuringCallback != null) {
            try {
                if (z) {
                    bdTuringCallback.onSuccess(0, jSONObject);
                } else {
                    bdTuringCallback.onFail(1, jSONObject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
