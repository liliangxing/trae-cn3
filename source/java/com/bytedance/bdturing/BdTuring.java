package com.bytedance.bdturing;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdturing.VerifyProtector;
import com.bytedance.bdturing.comonui.VerifyConfirmDialogActivity;
import com.bytedance.bdturing.domain.SettingsManager;
import com.bytedance.bdturing.identityverify.IdentityVerifyService;
import com.bytedance.bdturing.livedetect.ByteNNDependDefaultImp;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import com.bytedance.bdturing.livedetect.LiveFallbackStrategy;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.bytedance.bdturing.monitor.VerifyStateManager;
import com.bytedance.bdturing.senseless.PageTracer;
import com.bytedance.bdturing.senseless.SenselessVerifyService;
import com.bytedance.bdturing.sms.CheckCodeCallback;
import com.bytedance.bdturing.sms.SmsUtils;
import com.bytedance.bdturing.ttnet.TTNetHttpClient;
import com.bytedance.bdturing.ttnet.TTNetUtil;
import com.bytedance.bdturing.twiceverify.TwiceVerifyManager;
import com.bytedance.bdturing.uc_twiceverify.UCTwiceVerifyService;
import com.bytedance.bdturing.verify.ITuringVerifyService;
import com.bytedance.bdturing.verify.IVerifyService;
import com.bytedance.bdturing.verify.RiskControlService;
import com.bytedance.bdturing.verify.TuringVerifyType;
import com.bytedance.bdturing.verify.TwiceVerifyService;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import com.bytedance.bdturing.verify.request.IdentityRequest;
import com.bytedance.bdturing.verify.request.ImageRequest;
import com.bytedance.bdturing.verify.request.QaRequest;
import com.bytedance.bdturing.verify.request.RiskInfoRequest;
import com.bytedance.bdturing.verify.request.SmsRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BdTuring {
    public static final int BYTENN_LIVE_NOT_READY = 30008;
    public static final int CALL_TYPE_0 = 0;
    public static final int CALL_TYPE_1 = 1;
    public static final int CALL_TYPE_2 = 2;
    public static final int CALL_TYPE_3 = 3;
    public static final int CALL_TYPE_UNDEFINE = -1;
    public static final int LIVE_DISPATCH_VERIFY_FAIL = 30007;
    public static final int PTY_INIT_FAILED = 30001;
    public static final int PTY_INIT_NOT_FINISH = 30002;
    public static final int PTY_PKG_DOWNLOAD_FAIL = 30005;
    public static final int PTY_PKG_NOT_READY = 30004;
    public static final int PTY_RUN_ERROR = 30003;
    private static final String TAG = "BdTuring";
    public static final int TYPE_DOWNSMS = 7;
    public static final int TYPE_ECAF = 9;
    public static final int TYPE_EMAIL = 11;
    public static final int TYPE_IDENTIFY = 4;
    public static final int TYPE_IDENTITY_VERIFY = 14;
    public static final int TYPE_IMG = 2;
    public static final int TYPE_INFOVERIFY = 10;
    public static final int TYPE_LIVE_DETECT = 16;
    public static final int TYPE_LOGIN_VERIFY = 15;
    public static final int TYPE_PASSWORD = 8;
    public static final int TYPE_QA = 3;
    public static final int TYPE_RISK_INFO = 0;
    public static final int TYPE_SENSELESS_VERIFY = 18;
    public static final int TYPE_SMARTER = 5;
    public static final int TYPE_SMS = 1;
    public static final int TYPE_SMS_VOICE = 13;
    public static final int TYPE_UC_TWICE_VERIFY = 17;
    public static final int TYPE_UPSMS = 6;
    public static final int TYPE_VOICE = 12;
    public static final int VERIFY_FAIL = 1;
    public static final int VERIFY_FAIL_CLOSE = 2;
    public static final int VERIFY_FAIL_CLOSE_APP = 6;
    public static final int VERIFY_FAIL_CLOSE_BACK = 5;
    public static final int VERIFY_FAIL_CLOSE_FEEDBACK = 7;
    public static final int VERIFY_FAIL_CLOSE_MASK = 4;
    public static final int VERIFY_FAIL_CONFLICT = 998;
    public static final int VERIFY_FAIL_FREQUENT = 1000;
    public static final int VERIFY_FAIL_IDENTIFY = 10000;
    public static final int VERIFY_FAIL_IDENTITY_VERIFY = 20000;
    public static final int VERIFY_FAIL_LIVE_DETECT = 30000;
    public static final int VERIFY_FAIL_LOGIN_VERIFY_CONFLICT = 1001;
    public static final int VERIFY_FAIL_NETWORK = 3;
    public static final int VERIFY_FAIL_NOTIFY_FAILED = 1002;
    public static final int VERIFY_FAIL_NOT_SUPPORT = 996;
    public static final int VERIFY_FAIL_RISK_INFO = 997;
    public static final int VERIFY_FAIL_SYSTEM_TOO_LOW = 999;
    public static final int VERIFY_SUCCESS = 0;
    public static final int VERIFY_UP_GRADE = 10;
    private boolean isInitDone;
    private long lastVerifyTime;
    private BdTuringConfig mConfig;
    private RiskInfoRequest mConfirmVerifyRequest;
    private VerifyConfirmDialogActivity.StateListener mVerifyConfirmDlgListener;
    private RiskControlService riskControlService;
    private final HashMap<String, IVerifyService> services;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class InstanceHolder {
        private static BdTuring mInstance = new BdTuring();

        private InstanceHolder() {
        }
    }

    private BdTuring() {
        this.isInitDone = false;
        this.riskControlService = null;
        this.lastVerifyTime = 0L;
        this.services = new HashMap<>();
    }

    public static BdTuring getInstance() {
        return InstanceHolder.mInstance;
    }

    private void checkConfig(BdTuringConfig bdTuringConfig) {
        if (bdTuringConfig == null || bdTuringConfig.getApplicationContext() == null) {
            throw new RuntimeException("config or applicationContext is null");
        }
        if (bdTuringConfig.getHttpClient() == null) {
            bdTuringConfig.setHttpClient(new TTNetHttpClient(bdTuringConfig.getApplicationContext()));
        }
        if (bdTuringConfig.getHttpClient() == null || bdTuringConfig.getEventClient() == null) {
            throw new RuntimeException("httpClient or eventClient is null");
        }
        if (bdTuringConfig.getUcTwiceVerifyDepend() == null) {
            throw new RuntimeException("TwiceVerifyDepend is null");
        }
        if (bdTuringConfig.getLoginVerifyDepend() == null) {
            throw new RuntimeException("LoginVerifyDepend is null");
        }
        checkByteNN(bdTuringConfig);
        if (TextUtils.isEmpty(bdTuringConfig.getAppId())) {
            throw new RuntimeException("appId is null");
        }
        if (TextUtils.isEmpty(bdTuringConfig.getAppVersion())) {
            throw new RuntimeException("appVersion is null");
        }
        if (TextUtils.isEmpty(bdTuringConfig.getAppVersionCode())) {
            throw new RuntimeException("appVersionCode is null");
        }
        if (TextUtils.isEmpty(bdTuringConfig.getAppName())) {
            throw new RuntimeException("appName is null");
        }
    }

    private static void checkByteNN(BdTuringConfig bdTuringConfig) {
        if (bdTuringConfig.getByteNNDepend() != null) {
            return;
        }
        bdTuringConfig.setByteNNDepend(new ByteNNDependDefaultImp());
    }

    public synchronized BdTuring init(BdTuringConfig bdTuringConfig) {
        if (this.isInitDone) {
            return this;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mConfig = bdTuringConfig;
        checkConfig(bdTuringConfig);
        configTTNet();
        VerifyTaskHandler.getInstance().startHandleMessage();
        initService(bdTuringConfig);
        SettingsManager.init(bdTuringConfig);
        TwiceVerifyManager.getInstance().init(this.mConfig.getTwiceVerifyDepend());
        this.isInitDone = true;
        EventReport.statisticSdkInit(System.currentTimeMillis() - currentTimeMillis, bdTuringConfig);
        PageTracer.getInstance().init();
        return this;
    }

    private void configTTNet() {
        if (this.mConfig.getInjectHeader()) {
            TTNetUtil.addVersionHeaders();
        }
        if (this.mConfig.isTTNetProcessorEnable()) {
            TTNetUtil.setProcessorForTTNet();
        }
        if (this.mConfig.isBypassBdTuring()) {
            TTNetUtil.byPassBdTuring();
        }
    }

    public void showVerifyDialog(Activity activity, final AbstractRequest abstractRequest, final BdTuringCallback bdTuringCallback) {
        showVerifyDialog(activity, abstractRequest, new BdTuringCallback() { // from class: com.bytedance.bdturing.BdTuring.1
            @Override // com.bytedance.bdturing.BdTuringCallback
            public void onFail(int i, JSONObject jSONObject) {
                EventReport.finalVerifyResult(i, jSONObject, abstractRequest);
                BdTuringCallback bdTuringCallback2 = bdTuringCallback;
                if (bdTuringCallback2 != null) {
                    bdTuringCallback2.onFail(i, jSONObject);
                }
            }

            @Override // com.bytedance.bdturing.BdTuringCallback
            public void onSuccess(int i, JSONObject jSONObject) {
                EventReport.finalVerifyResult(i, jSONObject, abstractRequest);
                BdTuringCallback bdTuringCallback2 = bdTuringCallback;
                if (bdTuringCallback2 != null) {
                    bdTuringCallback2.onSuccess(i, jSONObject);
                }
            }
        }, true);
    }

    public void showVerifyDialog(final Activity activity, final AbstractRequest abstractRequest, final BdTuringCallback bdTuringCallback, boolean z) {
        if (abstractRequest == null) {
            if (bdTuringCallback != null) {
                bdTuringCallback.onFail(1, null);
                return;
            }
            return;
        }
        if (abstractRequest.getCallType() == -1) {
            if (abstractRequest instanceof RiskInfoRequest) {
                abstractRequest.setCallType(1);
            } else {
                abstractRequest.setCallType(2);
            }
        }
        EventReport.onVerifyParamReceive(abstractRequest);
        if (z) {
            Pair<Boolean, String> checkRequestSafety = checkRequestSafety(activity, abstractRequest, bdTuringCallback);
            if (!((Boolean) checkRequestSafety.first).booleanValue()) {
                VerifyStateManager.getInstance().verifyConflict(abstractRequest, (String) checkRequestSafety.second);
                EventReport.sdkStateError(abstractRequest, "BdTuring_" + ((String) checkRequestSafety.second));
                return;
            }
        }
        if (PreCreateManager.getInstance().showDialog(abstractRequest.getType())) {
            return;
        }
        EventReport.resetLogInfo(abstractRequest);
        LiveFallbackStrategy.getInstance().intercept(abstractRequest, bdTuringCallback, new LiveFallbackStrategy.InterceptCallBack() { // from class: com.bytedance.bdturing.BdTuring.2
            @Override // com.bytedance.bdturing.livedetect.LiveFallbackStrategy.InterceptCallBack
            public void onResult(boolean z2) {
                if (z2) {
                    return;
                }
                BdTuring.this.showVerifyDialogInner(activity, abstractRequest, new BdTuringCallback() { // from class: com.bytedance.bdturing.BdTuring.2.1
                    @Override // com.bytedance.bdturing.BdTuringCallback
                    public void onFail(int i, JSONObject jSONObject) {
                        if (i == 10 && jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("decision"))) {
                            BdTuring.this.verifyUpGrade(activity, jSONObject.optString("decision"), bdTuringCallback, jSONObject.optJSONObject("query"));
                            return;
                        }
                        bdTuringCallback.onFail(i, jSONObject);
                    }

                    @Override // com.bytedance.bdturing.BdTuringCallback
                    public void onSuccess(int i, JSONObject jSONObject) {
                        bdTuringCallback.onSuccess(i, jSONObject);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyUpGrade(Activity activity, String str, final BdTuringCallback bdTuringCallback, final JSONObject jSONObject) {
        this.lastVerifyTime = 0L;
        if (bdTuringCallback == null) {
            return;
        }
        if (activity == null || TextUtils.isEmpty(str)) {
            bdTuringCallback.onFail(1, null);
        }
        final RiskInfoRequest riskInfoRequest = new RiskInfoRequest(str);
        EventReport.verifyProtectStart(str, riskInfoRequest);
        riskInfoRequest.setCallType(3);
        showVerifyDialog(activity, riskInfoRequest, new BdTuringCallback() { // from class: com.bytedance.bdturing.BdTuring.3
            @Override // com.bytedance.bdturing.BdTuringCallback
            public void onFail(int i, JSONObject jSONObject2) {
                bdTuringCallback.onFail(i, jSONObject2);
                EventReport.verifyProtectResult(i, jSONObject2, riskInfoRequest);
            }

            @Override // com.bytedance.bdturing.BdTuringCallback
            public void onSuccess(final int i, final JSONObject jSONObject2) {
                EventReport.verifyProtectResult(i, jSONObject2, riskInfoRequest);
                JSONObject optJSONObject = jSONObject2 != null ? jSONObject2.optJSONObject(VerifyProtector.NOTIFY_DATA_KEY) : null;
                if (optJSONObject == null || TextUtils.isEmpty(optJSONObject.optString("subtype"))) {
                    bdTuringCallback.onSuccess(i, jSONObject2);
                } else {
                    VerifyProtector.getInstance().sendVerifyResult(optJSONObject, jSONObject, new VerifyProtector.NotifyCallBack() { // from class: com.bytedance.bdturing.BdTuring.3.1
                        @Override // com.bytedance.bdturing.VerifyProtector.NotifyCallBack
                        public void onSuccess() {
                            bdTuringCallback.onSuccess(i, jSONObject2);
                            EventReport.verifyProtectNotify(0, "", riskInfoRequest);
                        }

                        @Override // com.bytedance.bdturing.VerifyProtector.NotifyCallBack
                        public void onFail(int i2, String str2) {
                            bdTuringCallback.onFail(1002, jSONObject2);
                            EventReport.verifyProtectNotify(i2, str2, riskInfoRequest);
                        }
                    });
                }
            }
        }, true);
    }

    @Deprecated
    public void showVerifyDialog(final Activity activity, int i, final BdTuringCallback bdTuringCallback) {
        AbstractRequest abstractRequest = null;
        if (i == 0) {
            RiskInfoRequest riskInfoRequest = new RiskInfoRequest(getConfig().getRiskInfo());
            if (riskInfoRequest.getType() == 0) {
                bdTuringCallback.onFail(VERIFY_FAIL_RISK_INFO, null);
                return;
            }
            abstractRequest = riskInfoRequest;
        } else if (i == 1) {
            abstractRequest = new SmsRequest(getConfig().getScene(), getConfig().getShowToastSuccess());
        } else if (i == 2) {
            abstractRequest = new ImageRequest(getConfig().getChallengeCode());
        } else if (i == 3) {
            abstractRequest = new QaRequest(getConfig().getFullScreen());
        } else if (i == 4) {
            abstractRequest = new IdentityRequest(getConfig().getTicket(), getConfig().getScene());
        }
        if (abstractRequest != null && abstractRequest.getCallType() == -1) {
            abstractRequest.setCallType(2);
        }
        EventReport.onVerifyParamReceive(abstractRequest);
        Pair<Boolean, String> checkRequestSafety = checkRequestSafety(activity, abstractRequest, bdTuringCallback);
        if (!((Boolean) checkRequestSafety.first).booleanValue()) {
            VerifyStateManager.getInstance().verifyConflict(abstractRequest, (String) checkRequestSafety.second);
            EventReport.sdkStateError(abstractRequest, "BdTuring_v1_" + ((String) checkRequestSafety.second));
        } else {
            EventReport.resetLogInfo(abstractRequest);
            abstractRequest.setMaskCancel(getConfig().getMaskCancel());
            showVerifyDialogInner(activity, abstractRequest, new BdTuringCallback() { // from class: com.bytedance.bdturing.BdTuring.4
                @Override // com.bytedance.bdturing.BdTuringCallback
                public void onFail(int i2, JSONObject jSONObject) {
                    if (i2 == 10 && jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("decision"))) {
                        BdTuring.this.verifyUpGrade(activity, jSONObject.optString("decision"), bdTuringCallback, jSONObject.optJSONObject("query"));
                        return;
                    }
                    bdTuringCallback.onFail(i2, jSONObject);
                }

                @Override // com.bytedance.bdturing.BdTuringCallback
                public void onSuccess(int i2, JSONObject jSONObject) {
                    bdTuringCallback.onSuccess(i2, jSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showVerifyDialogInner(Activity activity, AbstractRequest abstractRequest, BdTuringCallback bdTuringCallback) {
        if (abstractRequest.getH5PopUp()) {
            popConfirmDialog(activity, abstractRequest, bdTuringCallback);
        } else {
            doVerify(abstractRequest, bdTuringCallback);
        }
    }

    public VerifyConfirmDialogActivity.StateListener getConfirmDlgListener() {
        return this.mVerifyConfirmDlgListener;
    }

    public RiskInfoRequest getConfirmVerifyRequest() {
        return this.mConfirmVerifyRequest;
    }

    public boolean isOnVerify() {
        boolean z;
        Iterator<IVerifyService> it = this.services.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IVerifyService next = it.next();
            if (next instanceof ITuringVerifyService) {
                ITuringVerifyService iTuringVerifyService = (ITuringVerifyService) next;
                if (iTuringVerifyService.isOnVerify() && !iTuringVerifyService.isSenseless()) {
                    z = true;
                }
            }
        }
        z = false;
        return z || this.mVerifyConfirmDlgListener != null;
    }

    private synchronized void popConfirmDialog(Activity activity, final AbstractRequest abstractRequest, final BdTuringCallback bdTuringCallback) {
        if (isOnVerify()) {
            if (bdTuringCallback != null) {
                bdTuringCallback.onFail(VERIFY_FAIL_CONFLICT, null);
            }
            EventReport.verifyConflict(abstractRequest, "popConfirmDialog");
            VerifyStateManager.getInstance().verifyConflict(abstractRequest, "ConfirmDialog is showing");
            return;
        }
        if (abstractRequest != null && (abstractRequest instanceof RiskInfoRequest)) {
            this.mConfirmVerifyRequest = (RiskInfoRequest) abstractRequest;
        }
        this.mVerifyConfirmDlgListener = new VerifyConfirmDialogActivity.StateListener() { // from class: com.bytedance.bdturing.BdTuring.5
            @Override // com.bytedance.bdturing.comonui.VerifyConfirmDialogActivity.StateListener
            public void onConfirm(String str) {
                abstractRequest.setSkipConfirm(true);
                abstractRequest.setCustomUrl(str);
                if (BdTuring.this.mConfirmVerifyRequest != null && BdTuring.this.mConfirmVerifyRequest.getInnerRequest() != null) {
                    BdTuring.this.mConfirmVerifyRequest.getInnerRequest().setSkipConfirm(true);
                }
                BdTuring.this.doVerify(abstractRequest, bdTuringCallback);
                BdTuring.this.mVerifyConfirmDlgListener = null;
            }

            @Override // com.bytedance.bdturing.comonui.VerifyConfirmDialogActivity.StateListener
            public void onFallback() {
                BdTuring.this.doVerify(abstractRequest, bdTuringCallback);
                BdTuring.this.mVerifyConfirmDlgListener = null;
            }

            @Override // com.bytedance.bdturing.comonui.VerifyConfirmDialogActivity.StateListener
            public void onCancel(int i) {
                BdTuringCallback bdTuringCallback2 = bdTuringCallback;
                if (bdTuringCallback2 != null) {
                    bdTuringCallback2.onFail(2, null);
                }
                BdTuring.this.mVerifyConfirmDlgListener = null;
            }
        };
        VerifyConfirmDialogActivity.startActivity(activity);
        EventReport.startActivity(true, VerifyConfirmDialogActivity.class.getName(), abstractRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doVerify(AbstractRequest abstractRequest, BdTuringCallback bdTuringCallback) {
        boolean z;
        boolean z2;
        IVerifyService iVerifyService;
        Iterator<IVerifyService> it = this.services.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                z2 = false;
                iVerifyService = null;
                break;
            } else {
                iVerifyService = it.next();
                if (iVerifyService.isProcess(abstractRequest.getType())) {
                    z = iVerifyService.execute(abstractRequest, bdTuringCallback);
                    z2 = true;
                    break;
                }
            }
        }
        EventReport.doVerify(z, iVerifyService, abstractRequest);
        if (z2) {
            return;
        }
        bdTuringCallback.onFail(VERIFY_FAIL_NOT_SUPPORT, null);
    }

    public void dismissVerifyDialog() {
        if (this.isInitDone) {
            this.riskControlService.dismissVerifyDialog();
        }
    }

    public BdTuringConfig getConfig() {
        return this.mConfig;
    }

    public void openLog(boolean z) {
        if (z) {
            LogUtil.openLog();
        } else {
            LogUtil.closeLog();
        }
    }

    public void addService(IVerifyService iVerifyService) {
        if (this.services.containsKey(iVerifyService.getClass().getName())) {
            return;
        }
        this.services.put(iVerifyService.getClass().getName(), iVerifyService);
    }

    public boolean isOnLoginVerify() {
        IVerifyService iVerifyService;
        HashMap<String, IVerifyService> hashMap = this.services;
        if (hashMap == null || (iVerifyService = hashMap.get(LoginVerifyService.class.getName())) == null || !(iVerifyService instanceof LoginVerifyService)) {
            return false;
        }
        return ((LoginVerifyService) iVerifyService).isOnVerify();
    }

    private boolean throttle() {
        boolean z = System.currentTimeMillis() - this.lastVerifyTime < 500;
        this.lastVerifyTime = System.currentTimeMillis();
        return z;
    }

    private void initService(BdTuringConfig bdTuringConfig) {
        RiskControlService riskControlService = RiskControlService.INSTANCE;
        this.riskControlService = riskControlService;
        addService(riskControlService);
        addService(new TwiceVerifyService());
        addService(new UCTwiceVerifyService());
        addService(IdentityVerifyService.getInstance());
        addService(new LoginVerifyService());
        addService(LiveDetectService.getInstance());
        addService(SenselessVerifyService.getInstance());
        LiveDetectService.getInstance().init(bdTuringConfig.getApplicationContext());
        try {
            addService((IVerifyService) Class.forName("com.bytedance.bdturing.verify.IdentityService").newInstance());
        } catch (ClassNotFoundException e) {
            LogUtil.printException(e);
        } catch (IllegalAccessException e2) {
            LogUtil.printException(e2);
        } catch (InstantiationException e3) {
            LogUtil.printException(e3);
        }
    }

    @Deprecated
    public boolean isInVerify() {
        return LiveDetectService.getInstance().detectPageShowing();
    }

    private Pair<Boolean, String> checkRequestSafety(Activity activity, AbstractRequest abstractRequest, BdTuringCallback bdTuringCallback) {
        if (bdTuringCallback == null) {
            LogUtil.m162i(TAG, "callback is null");
            return new Pair<>(false, "callBack is null");
        }
        if ((!this.isInitDone || activity == null) && (activity != null || abstractRequest == null || (!"nocaptcha".equals(abstractRequest.getVerifySubType()) && !TuringVerifyType.nocaptcha_collect.equals(abstractRequest.getVerifySubType())))) {
            bdTuringCallback.onFail(2, null);
            return new Pair<>(false, "isInitDone=" + this.isInitDone + ";activity=" + activity);
        }
        if (throttle()) {
            LogUtil.m162i(TAG, "invoke multi times, u should take a breath");
            bdTuringCallback.onFail(1000, null);
            return new Pair<>(false, "invoke multi times");
        }
        return new Pair<>(true, "");
    }

    public boolean isInitDone() {
        return this.isInitDone;
    }

    public void preloadVerifyDialog(Activity activity, AbstractRequest abstractRequest, BdTuringCallback bdTuringCallback) {
        PreCreateManager.getInstance().setDialog(activity, abstractRequest, bdTuringCallback);
    }

    public void sendSmsCode(String str, Activity activity, String str2, int i, int i2, int i3, int i4, BdTuringCallback bdTuringCallback) {
        sendSmsCode(str, activity, str2, i, i2, i3, i4, null, bdTuringCallback);
    }

    public void sendSmsCode(String str, Activity activity, String str2, int i, int i2, int i3, int i4, Map<String, Object> map, BdTuringCallback bdTuringCallback) {
        SmsUtils.sendCode(str, activity, str2, i, i2, i3, i4, map, bdTuringCallback);
    }

    public void checkSmsCode(String str, String str2, int i, String str3, CheckCodeCallback checkCodeCallback) {
        SmsUtils.checkCode(str, str2, i, str3, checkCodeCallback);
    }
}
