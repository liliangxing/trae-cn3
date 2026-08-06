package com.bytedance.bdturing.loginverify;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringCallback;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.VerifyProtector;
import com.bytedance.bdturing.VerifyTaskHandler;
import com.bytedance.bdturing.monitor.VerifyStateManager;
import com.bytedance.bdturing.utils.JsonUtils;
import com.bytedance.bdturing.verify.ITuringVerifyService;
import com.bytedance.bdturing.verify.TuringVerifyType;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import com.bytedance.bdturing.verify.request.LoginVerifyRequest;
import com.bytedance.bdturing.verify.request.RiskInfoRequest;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LoginVerifyService implements ITuringVerifyService {
    private static final String TAG = "LoginVerifyService";
    private static final long VERIFY_TIME_OUT = 600000;
    public static final String X_TT_TOKEN = "X-Tt-Token";
    private boolean isOnVerify;
    private AbstractRequest mRequest;
    private TimeOutWatchDog mTimeOutWatchDog;

    @Override // com.bytedance.bdturing.verify.IVerifyService
    public boolean isProcess(int i) {
        return 15 == i;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public boolean isSenseless() {
        return false;
    }

    @Override // com.bytedance.bdturing.verify.IVerifyService
    public boolean execute(AbstractRequest abstractRequest, final BdTuringCallback bdTuringCallback) {
        EventReport.loginVerifyStart(abstractRequest);
        final AbstractRequest innerRequest = abstractRequest instanceof RiskInfoRequest ? ((RiskInfoRequest) abstractRequest).getInnerRequest() : null;
        if (innerRequest == null || !(innerRequest instanceof LoginVerifyRequest)) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putValue(jSONObject, "errorMsg", "request type is not LoginVerifyRequest!");
            bdTuringCallback.onFail(BdTuring.VERIFY_FAIL_NOT_SUPPORT, jSONObject);
            EventReport.loginVerifyResult(false, abstractRequest);
            return true;
        }
        if (isOnVerify()) {
            bdTuringCallback.onFail(BdTuring.VERIFY_FAIL_CONFLICT, null);
            VerifyStateManager.getInstance().verifyConflict(abstractRequest, "");
            EventReport.verifyConflict(abstractRequest, TAG);
            EventReport.loginVerifyResult(false, abstractRequest);
            return true;
        }
        this.mRequest = abstractRequest;
        final Activity activity = abstractRequest.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.bytedance.bdturing.loginverify.LoginVerifyService.1
                @Override // java.lang.Runnable
                public void run() {
                    LoginVerifyService.this.doLoginVerify(activity, (LoginVerifyRequest) innerRequest, bdTuringCallback);
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
    public void doLoginVerify(Activity activity, LoginVerifyRequest loginVerifyRequest, final BdTuringCallback bdTuringCallback) {
        ILoginVerifyDepend loginVerifyDepend = BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getLoginVerifyDepend() : null;
        if (loginVerifyDepend != null) {
            try {
                setVerifySate(true);
                startWatchDog(bdTuringCallback);
                if (!TextUtils.isEmpty(loginVerifyRequest.getToastContent())) {
                    Toast.makeText(activity, loginVerifyRequest.getToastContent(), 0).show();
                }
                loginVerifyDepend.startLogin(activity, new JSONObject(), new LoginVerifyCallBack() { // from class: com.bytedance.bdturing.loginverify.LoginVerifyService.2
                    @Override // com.bytedance.bdturing.loginverify.LoginVerifyCallBack
                    public void onSuccess(String str) {
                        LogUtil.m162i(LoginVerifyService.TAG, "login success:" + str);
                        JSONObject jSONObject = new JSONObject();
                        if (!TextUtils.isEmpty(str)) {
                            JsonUtils.putValue(jSONObject, LoginVerifyService.X_TT_TOKEN, str);
                        }
                        LoginVerifyService.this.noticeResult(true, jSONObject, bdTuringCallback);
                    }

                    @Override // com.bytedance.bdturing.loginverify.LoginVerifyCallBack
                    public void onFail(int i, JSONObject jSONObject) {
                        LogUtil.m162i(LoginVerifyService.TAG, "login fail");
                        LoginVerifyService.this.noticeResult(false, jSONObject, bdTuringCallback);
                    }
                });
                return;
            } catch (Exception e) {
                e.printStackTrace();
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putValue(jSONObject, "msg", "start login failed");
                noticeResult(false, jSONObject, bdTuringCallback);
                return;
            }
        }
        LogUtil.m162i(TAG, "LoginVerifyDepend is null");
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putValue(jSONObject2, "msg", "LoginVerifyDepend is null");
        noticeResult(false, jSONObject2, bdTuringCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class TimeOutWatchDog implements Runnable {
        private BdTuringCallback mCallBack;
        private boolean mCancel;

        public TimeOutWatchDog(BdTuringCallback bdTuringCallback) {
            this.mCallBack = bdTuringCallback;
        }

        public void cancel() {
            this.mCancel = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mCancel) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putValue(jSONObject, "errorMsg", "login verify timeOut");
            LoginVerifyService.this.noticeResult(false, jSONObject, this.mCallBack);
        }
    }

    private void startWatchDog(BdTuringCallback bdTuringCallback) {
        stopWatchDog();
        this.mTimeOutWatchDog = new TimeOutWatchDog(bdTuringCallback);
        VerifyTaskHandler.getInstance().postRunnableDelay(this.mTimeOutWatchDog, 600000L);
    }

    private void stopWatchDog() {
        TimeOutWatchDog timeOutWatchDog = this.mTimeOutWatchDog;
        if (timeOutWatchDog != null) {
            timeOutWatchDog.cancel();
            VerifyTaskHandler.getInstance().removeRunnable(this.mTimeOutWatchDog);
            this.mTimeOutWatchDog = null;
        }
    }

    private synchronized void setVerifySate(boolean z) {
        EventReport.VerifyStateChange(z, TAG, this.mRequest);
        this.isOnVerify = z;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public synchronized boolean isOnVerify() {
        return this.isOnVerify;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void noticeResult(boolean z, JSONObject jSONObject, BdTuringCallback bdTuringCallback) {
        stopWatchDog();
        noticeLoginResult(z, jSONObject, bdTuringCallback);
    }

    private void noticeLoginResult(boolean z, JSONObject jSONObject, BdTuringCallback bdTuringCallback) {
        setVerifySate(false);
        EventReport.loginVerifyResult(z, this.mRequest);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putValue(jSONObject2, "subtype", TuringVerifyType.login);
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
