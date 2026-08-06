package com.bytedance.bdturing.senseless;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringCallback;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.C0603R;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.comonui.AlertDialogParam;
import com.bytedance.bdturing.comonui.TuringAlertDialog;
import com.bytedance.bdturing.comonui.TuringAlertDialogCallBack;
import com.bytedance.bdturing.monitor.VerifyStateManager;
import com.bytedance.bdturing.senseless.TimeOutWatchDog;
import com.bytedance.bdturing.senseless.TraceDataManager;
import com.bytedance.bdturing.utils.JsonUtils;
import com.bytedance.bdturing.verify.ITuringVerifyService;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import com.bytedance.bdturing.verify.request.RiskInfoRequest;
import com.bytedance.bdturing.verify.request.SenselessVerifyRequest;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SenselessVerifyService implements ITuringVerifyService {
    private static final String SEC_REPORT_SCENE = "verify_center";
    private static volatile SenselessVerifyService sInstance;
    private TuringAlertDialog mDlg;
    private TimeOutWatchDog mReportDog;
    private AbstractRequest mRequest;
    private boolean preReportRunning = false;
    private boolean asyncReportRunning = false;

    @Override // com.bytedance.bdturing.verify.IVerifyService
    public boolean isProcess(int i) {
        return 18 == i;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public boolean isSenseless() {
        return true;
    }

    public static SenselessVerifyService getInstance() {
        if (sInstance == null) {
            synchronized (SenselessVerifyService.class) {
                if (sInstance == null) {
                    sInstance = new SenselessVerifyService();
                }
            }
        }
        return sInstance;
    }

    private SenselessVerifyService() {
    }

    @Override // com.bytedance.bdturing.verify.IVerifyService
    public boolean execute(AbstractRequest abstractRequest, BdTuringCallback bdTuringCallback) {
        AbstractRequest innerRequest = abstractRequest instanceof RiskInfoRequest ? ((RiskInfoRequest) abstractRequest).getInnerRequest() : null;
        if (innerRequest == null || !(innerRequest instanceof SenselessVerifyRequest)) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putValue(jSONObject, "errorMsg", "request type is not available!");
            bdTuringCallback.onFail(BdTuring.VERIFY_FAIL_NOT_SUPPORT, jSONObject);
            return true;
        }
        if (isOnVerify()) {
            bdTuringCallback.onFail(BdTuring.VERIFY_FAIL_CONFLICT, null);
            VerifyStateManager.getInstance().verifyConflict(abstractRequest, "");
            EventReport.verifyConflict(abstractRequest, "SenselessVerifyService");
            return true;
        }
        this.mRequest = abstractRequest;
        SenselessVerifyRequest senselessVerifyRequest = (SenselessVerifyRequest) innerRequest;
        doVerify(senselessVerifyRequest.isSyncMode(), senselessVerifyRequest.getLogId(), senselessVerifyRequest.getVerifyType(), senselessVerifyRequest.getDetail(), bdTuringCallback);
        return true;
    }

    private void doVerify(boolean z, String str, String str2, String str3, BdTuringCallback bdTuringCallback) {
        doSecReport();
        if (!z && bdTuringCallback != null) {
            bdTuringCallback.onFail(1, null);
        }
        reportPreCollectData(z, str, str2, str3, bdTuringCallback);
        startAsyncReport(str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopWatchDog() {
        TimeOutWatchDog timeOutWatchDog = this.mReportDog;
        if (timeOutWatchDog != null) {
            timeOutWatchDog.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportPreCollectData(final boolean z, final String str, final String str2, final String str3, final BdTuringCallback bdTuringCallback) {
        this.preReportRunning = true;
        if (z) {
            TimeOutWatchDog timeOutWatchDog = this.mReportDog;
            if (timeOutWatchDog != null) {
                timeOutWatchDog.cancel();
            }
            this.mReportDog = new TimeOutWatchDog(new TimeOutWatchDog.Listener() { // from class: com.bytedance.bdturing.senseless.SenselessVerifyService.1
                @Override // com.bytedance.bdturing.senseless.TimeOutWatchDog.Listener
                public void onTimeOut() {
                    EventReport.senselessReportTimeOut(SenselessVerifyService.this.mRequest);
                    SenselessVerifyService.this.showFailDlg("", "", z, str, str2, str3, bdTuringCallback);
                }
            });
            this.mReportDog.start(NoCaptchaSetting.reportTimeOut());
        }
        TraceDataManager.getInstance().reportPreCollectData(str2, str3, new TraceDataManager.VerifyResultCallBack() { // from class: com.bytedance.bdturing.senseless.SenselessVerifyService.2
            @Override // com.bytedance.bdturing.senseless.TraceDataManager.VerifyResultCallBack
            public void onSuccess(int i, JSONObject jSONObject) {
                SenselessVerifyService.this.stopWatchDog();
                SenselessVerifyService.this.preReportRunning = false;
                EventReport.senselessReportResult(SenselessVerifyService.this.mRequest, 0, TraceDataManager.DATA_TYPE_PRE, "");
                if (z) {
                    bdTuringCallback.onSuccess(0, jSONObject);
                }
            }

            @Override // com.bytedance.bdturing.senseless.TraceDataManager.VerifyResultCallBack
            public void onFail(int i, JSONObject jSONObject) {
                EventReport.senselessReportResult(SenselessVerifyService.this.mRequest, i, TraceDataManager.DATA_TYPE_PRE, jSONObject != null ? jSONObject.toString() : "");
                SenselessVerifyService.this.stopWatchDog();
                if (!z) {
                    SenselessVerifyService.this.preReportRunning = false;
                    return;
                }
                if (i == 10) {
                    SenselessVerifyService.this.preReportRunning = false;
                    bdTuringCallback.onFail(10, jSONObject);
                } else {
                    SenselessVerifyService.this.showFailDlg(jSONObject != null ? jSONObject.optString("message") : "", jSONObject != null ? jSONObject.optString("sec_message") : "", z, str, str2, str3, bdTuringCallback);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFailDlg(String str, String str2, final boolean z, final String str3, final String str4, final String str5, final BdTuringCallback bdTuringCallback) {
        if (this.mDlg != null) {
            return;
        }
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        Activity topActivity = config != null ? config.getTopActivity() : null;
        if (topActivity != null) {
            AlertDialogParam alertDialogParam = new AlertDialogParam();
            alertDialogParam.title = TextUtils.isEmpty(str) ? topActivity.getString(C0603R.string.turing_net_error_title) : str;
            StringBuilder sb = new StringBuilder();
            sb.append(TextUtils.isEmpty(str2) ? topActivity.getString(C0603R.string.turing_net_error_content) : str2);
            sb.append("\n\n").append(str3);
            alertDialogParam.contentText = sb.toString();
            alertDialogParam.lefBtnText = topActivity.getString(C0603R.string.turing_net_error_close);
            alertDialogParam.rightBtnText = topActivity.getString(C0603R.string.turing_net_error_retry);
            TuringAlertDialog turingAlertDialog = new TuringAlertDialog(topActivity, alertDialogParam, true, new TuringAlertDialogCallBack() { // from class: com.bytedance.bdturing.senseless.SenselessVerifyService.3
                @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
                public void onLeftBtnClick() {
                    EventReport.senselessDialogClose(1, "", SenselessVerifyService.this.mRequest);
                    SenselessVerifyService.this.mDlg.dismiss();
                    SenselessVerifyService.this.mDlg = null;
                    SenselessVerifyService.this.preReportRunning = false;
                    BdTuringCallback bdTuringCallback2 = bdTuringCallback;
                    if (bdTuringCallback2 != null) {
                        bdTuringCallback2.onFail(1, null);
                    }
                }

                @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
                public void onRightBtnClick() {
                    SenselessVerifyService.this.mDlg.dismiss();
                    SenselessVerifyService.this.mDlg = null;
                    EventReport.senselessDialogClose(0, "", SenselessVerifyService.this.mRequest);
                    SenselessVerifyService.this.reportPreCollectData(z, str3, str4, str5, bdTuringCallback);
                }

                @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
                public void onCancel() {
                    EventReport.senselessDialogClose(1, "", SenselessVerifyService.this.mRequest);
                    SenselessVerifyService.this.mDlg.dismiss();
                    SenselessVerifyService.this.mDlg = null;
                    SenselessVerifyService.this.preReportRunning = false;
                    BdTuringCallback bdTuringCallback2 = bdTuringCallback;
                    if (bdTuringCallback2 != null) {
                        bdTuringCallback2.onFail(1, null);
                    }
                }
            });
            this.mDlg = turingAlertDialog;
            turingAlertDialog.show();
            EventReport.senselessDialogDisplay("", this.mRequest);
            return;
        }
        this.preReportRunning = false;
        if (bdTuringCallback != null) {
            bdTuringCallback.onFail(1, null);
        }
    }

    private void startAsyncReport(String str, String str2) {
        this.asyncReportRunning = true;
        if (NoCaptchaSetting.collectTouchEvent()) {
            PageTracer.getInstance().startWatchTouchEvent();
        }
        if (NoCaptchaSetting.collectPageHistory()) {
            PageTracer.getInstance().startRecordPageHistory();
        }
        TraceDataManager.getInstance().startAsyncReport(str, str2, new TraceDataManager.VerifyResultCallBack() { // from class: com.bytedance.bdturing.senseless.SenselessVerifyService.4
            @Override // com.bytedance.bdturing.senseless.TraceDataManager.VerifyResultCallBack
            public void onSuccess(int i, JSONObject jSONObject) {
                EventReport.senselessReportResult(SenselessVerifyService.this.mRequest, 0, TraceDataManager.DATA_TYPE_ASYNC, jSONObject != null ? jSONObject.toString() : "");
                SenselessVerifyService.this.asyncReportRunning = false;
            }

            @Override // com.bytedance.bdturing.senseless.TraceDataManager.VerifyResultCallBack
            public void onFail(int i, JSONObject jSONObject) {
                EventReport.senselessReportResult(SenselessVerifyService.this.mRequest, i, TraceDataManager.DATA_TYPE_ASYNC, jSONObject != null ? jSONObject.toString() : "");
                SenselessVerifyService.this.asyncReportRunning = false;
            }
        });
    }

    private void doSecReport() {
        BdTuringConfig config;
        String message;
        boolean z;
        if (!NoCaptchaSetting.triggerSecSdk() || (config = BdTuring.getInstance().getConfig()) == null || config.getSecDepend() == null) {
            return;
        }
        String appId = config.getAppId();
        String installId = config.getInstallId();
        String deviceId = config.getDeviceId();
        if (TextUtils.isEmpty(appId) || TextUtils.isEmpty(installId) || TextUtils.isEmpty(deviceId)) {
            return;
        }
        try {
            z = config.getSecDepend().secReport(SEC_REPORT_SCENE, appId, deviceId, installId);
            message = "";
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
            z = false;
        }
        EventReport.triggerSec(z, message, this.mRequest);
    }

    public AbstractRequest getRiskRequest() {
        return this.mRequest;
    }

    @Override // com.bytedance.bdturing.verify.ITuringVerifyService
    public synchronized boolean isOnVerify() {
        boolean z;
        if (!this.preReportRunning) {
            z = this.asyncReportRunning;
        }
        return z;
    }
}
