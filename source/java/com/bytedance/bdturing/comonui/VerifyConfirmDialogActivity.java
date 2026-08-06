package com.bytedance.bdturing.comonui;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.C0603R;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.TuringVerifyWebView;
import com.bytedance.bdturing.VerifyWebViewListener;
import com.bytedance.bdturing.domain.UrlBuilder;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity;
import com.bytedance.bdturing.methods.IVerifyInnerHandler;
import com.bytedance.bdturing.methods.JsBridgeModule;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.bdturing.methods.VerifyDialogHandler;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.utils.UtilsKt;
import com.bytedance.bdturing.verify.TuringVerifyType;
import com.bytedance.bdturing.verify.request.LiveDetectRequest;
import com.bytedance.bdturing.verify.request.RiskInfoRequest;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class VerifyConfirmDialogActivity extends TuringBaseLiveDetectActivity implements TuringBaseLiveDetectActivity.CameraPermissionCallBack {
    private static final int REQUEST_CODE_NEW_WEB = 9999;
    public static final int RESULT_BACK_CANCEL = 3;
    public static final int RESULT_CANCEL = 1;
    public static final int RESULT_CONFIRM = 0;
    public static final int RESULT_FALL_BACK = 2;
    public static final int RESULT_LOAD_FAIL = 4;
    public static final int RESULT_PERMISSION_CANCEL = 5;
    private static final String TAG = "VerifyConfirmDialog";
    public static final int WEB_LIVE_URL_EMPTY = 6;
    private static int mConfirmResult = 3;
    private boolean backFromSetting;
    private boolean isDismissing;
    private PermissionAlertDialog mDialog;
    private JsBridgeModule mJsBridge;
    private String mNewBizUrl;
    private RiskInfoRequest mRiskRequest;
    private CardView mWebContainer;
    private TuringVerifyWebView mWebView;
    private boolean mIsOrientationChange = false;
    private IVerifyInnerHandler mVerifyHandler = new VerifyDialogHandler() { // from class: com.bytedance.bdturing.comonui.VerifyConfirmDialogActivity.1
        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void onSetDialogSize(int i, int i2, boolean z) {
            super.onSetDialogSize(i, i2, z);
            VerifyConfirmDialogActivity.this.changeDialogSize(i, i2, z);
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void verifyConfirmResult(int i, String str) {
            VerifyConfirmDialogActivity.this.handleConfirmResult(i, str);
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void openNewWeb(String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            CommonWebActivity.startActivityForResult(VerifyConfirmDialogActivity.this, VerifyConfirmDialogActivity.REQUEST_CODE_NEW_WEB, str, str2);
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void closeWeb() {
            VerifyConfirmDialogActivity.this.finish();
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void onH5Available() {
            if (VerifyConfirmDialogActivity.this.mWebView != null) {
                VerifyConfirmDialogActivity.this.mWebView.onH5Available();
            }
        }
    };
    private int mCurrentOrientation = -1;
    private ComponentCallbacks mOrientationListener = new ComponentCallbacks() { // from class: com.bytedance.bdturing.comonui.VerifyConfirmDialogActivity.5
        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            if (configuration.orientation == 1 || configuration.orientation == 2 || configuration.orientation == VerifyConfirmDialogActivity.this.mCurrentOrientation) {
                VerifyConfirmDialogActivity.this.mCurrentOrientation = configuration.orientation;
                int i = configuration.orientation != 1 ? 1 : 2;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(EventReport.SCREEN_ORIENTATION, i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String parseNativeCallJs = JsCallParser.parseNativeCallJs(1, "bytedcert.orientation_changing", JsCallParser.VALUE_CALL, jSONObject, "bytedcert.orientation_changing");
                VerifyConfirmDialogActivity.this.mIsOrientationChange = true;
                VerifyConfirmDialogActivity.this.callJsCode(parseNativeCallJs);
                EventReport.statisticOrientationChange(i, VerifyConfirmDialogActivity.this.mRiskRequest);
            }
        }
    };

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface StateListener {
        void onCancel(int i);

        void onConfirm(String str);

        void onFallback();
    }

    /* renamed from: com_bytedance_bdturing_comonui_VerifyConfirmDialogActivity__onStop$___twin___ */
    public void m168xa36e8f42() {
        super.onStop();
    }

    protected void onStop() {
        m167x9d57e3f9(this);
    }

    public static void startActivity(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) VerifyConfirmDialogActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0603R.layout.bdturing_confirm_dialog_activity);
        initData();
        initView();
        registerComponentCallbacks(this.mOrientationListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initData() {
        this.mRiskRequest = BdTuring.getInstance().getConfirmVerifyRequest();
        if (isLiveVerify()) {
            EventReport.confirmDialogShow(LiveDetectService.getInstance().preInit(this, getClass().getName()), this.mRiskRequest);
        } else {
            EventReport.confirmDialogShow(true, this.mRiskRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConfirmResult(int i, String str) {
        this.mNewBizUrl = str;
        if (i == 0 && isLiveVerify()) {
            checkCameraPermission(this);
        } else {
            mConfirmResult = i;
            finish();
        }
    }

    private boolean isLiveVerify() {
        return isNativeLiveVerify() || isWebLiveVerify();
    }

    private boolean isNativeLiveVerify() {
        RiskInfoRequest riskInfoRequest = this.mRiskRequest;
        return (riskInfoRequest == null || riskInfoRequest.getInnerRequest() == null || !(this.mRiskRequest.getInnerRequest() instanceof LiveDetectRequest)) ? false : true;
    }

    private boolean isWebLiveVerify() {
        RiskInfoRequest riskInfoRequest = this.mRiskRequest;
        return riskInfoRequest != null && riskInfoRequest.getVerifyTypeCode() == GWorker.INTERVAL && TuringVerifyType.LIVE_H5.equals(this.mRiskRequest.getVerifySubType());
    }

    private void dispatchResult(int i, String str) {
        EventReport.confirmResult(i, str, this.mRiskRequest);
        StateListener confirmDlgListener = BdTuring.getInstance().getConfirmDlgListener();
        if (confirmDlgListener != null) {
            if (i == 0) {
                if (isWebLiveVerify() && TextUtils.isEmpty(str)) {
                    confirmDlgListener.onCancel(6);
                    return;
                } else {
                    confirmDlgListener.onConfirm(str);
                    return;
                }
            }
            if (i == 2) {
                if (isWebLiveVerify()) {
                    confirmDlgListener.onCancel(i);
                    return;
                } else {
                    confirmDlgListener.onFallback();
                    return;
                }
            }
            confirmDlgListener.onCancel(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void changeDialogSize(int i, int i2, final boolean z) {
        final int i3;
        final int i4;
        if (this.isDismissing) {
            return;
        }
        if (z) {
            Point availableScreenSize = UtilsKt.getAvailableScreenSize(this);
            int i5 = availableScreenSize.x;
            i4 = availableScreenSize.y;
            i3 = i5;
        } else {
            i3 = i;
            i4 = i2;
        }
        final ViewGroup.LayoutParams layoutParams = this.mWebView.getLayoutParams();
        if (this.mIsOrientationChange && layoutParams.width > 0 && layoutParams.height > 0) {
            this.mWebView.startOrientationChangeAnimation(i3, i4, layoutParams.width, layoutParams.height);
            this.mIsOrientationChange = false;
        } else {
            this.mWebView.post(new Runnable() { // from class: com.bytedance.bdturing.comonui.VerifyConfirmDialogActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (VerifyConfirmDialogActivity.this.isDismissing || VerifyConfirmDialogActivity.this.mWebView == null) {
                        return;
                    }
                    VerifyConfirmDialogActivity.this.stopLoading();
                    if (z && VerifyConfirmDialogActivity.this.mWebContainer != null) {
                        VerifyConfirmDialogActivity.this.mWebContainer.setRadius(0.0f);
                    }
                    layoutParams.width = i3;
                    layoutParams.height = i4;
                    VerifyConfirmDialogActivity.this.mWebView.setLayoutParams(layoutParams);
                    VerifyConfirmDialogActivity.this.mWebView.setVisibility(0);
                }
            });
        }
    }

    private void initView() {
        this.mWebView = (TuringVerifyWebView) findViewById(C0603R.id.verify_webview);
        this.mWebContainer = findViewById(C0603R.id.web_container);
        this.ivLoading = (ImageView) findViewById(C0603R.id.loading);
        final long currentTimeMillis = System.currentTimeMillis();
        this.mWebView.init(new VerifyWebViewListener() { // from class: com.bytedance.bdturing.comonui.VerifyConfirmDialogActivity.3
            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onLoadPageSuccess() {
                EventReport.confirmDialogLoadSuccess(System.currentTimeMillis() - currentTimeMillis, VerifyConfirmDialogActivity.this.mRiskRequest);
            }

            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onReceivedError(int i, String str, String str2) {
                EventReport.confirmDialogError(i, str, str2, VerifyConfirmDialogActivity.this.mRiskRequest);
            }

            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onLoadPageFail(int i, String str) {
                EventReport.confirmDialogLoadFail(i, str, VerifyConfirmDialogActivity.this.mRiskRequest);
                int unused = VerifyConfirmDialogActivity.mConfirmResult = 2;
                VerifyConfirmDialogActivity.this.finish();
            }
        }, this.mRiskRequest);
        this.mJsBridge = new JsBridgeModule(this.mVerifyHandler, this.mWebView);
        String buildUrl = buildUrl();
        if (TextUtils.isEmpty(buildUrl)) {
            finish();
        } else {
            this.mWebView.loadUrl(buildUrl);
            startLoading();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String buildUrl() {
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        String name = config != null ? config.getRegionType().getName() : "";
        StringBuilder sb = new StringBuilder();
        String popUrl = SettingsManager.INSTANCE.getPopUrl(name);
        EventReport.popH5Url(popUrl, name, this.mRiskRequest);
        if (TextUtils.isEmpty(popUrl)) {
            return sb.toString();
        }
        String host = SettingsManager.INSTANCE.getHost(SettingsManager.VERIFY_SERVICE);
        sb.append(popUrl + "?");
        UtilsKt.appendFirstParam(sb, "verify_host", host);
        UrlBuilder.INSTANCE.appendCommon(this, sb);
        UtilsKt.appendParams(sb, "use_dialog_size_v2", 1);
        RiskInfoRequest riskInfoRequest = this.mRiskRequest;
        UtilsKt.appendParams(sb, "verify_data", riskInfoRequest != null ? riskInfoRequest.getRiskInfo() : "");
        return sb.toString();
    }

    private void startLiveDetect() {
        mConfirmResult = 0;
        finish();
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.CameraPermissionCallBack
    public void onGRanted(int i) {
        EventReport.LiveCameraPermission(i == 2 ? 1 : 0, this.mRiskRequest);
        EventReport.liveDetectStartBtnClick(true, this.mRiskRequest);
        startLiveDetect();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.CameraPermissionCallBack
    public void onDenied(int i) {
        if (this.backFromSetting) {
            return;
        }
        if (i == 1) {
            Toast.makeText((Context) this, (CharSequence) getString(C0603R.string.turing_live_camera_permission_tip_1), 0).show();
        } else if (i == 2) {
            Toast.makeText((Context) this, (CharSequence) getString(C0603R.string.turing_live_camera_permission_tip_2), 0).show();
        }
        EventReport.LiveCameraPermission(i == 2 ? 3 : 2, this.mRiskRequest);
        mConfirmResult = 5;
        finish();
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.CameraPermissionCallBack
    public void onForbidden() {
        EventReport.LiveCameraPermission(4, this.mRiskRequest);
        EventReport.liveDetectStartBtnClick(false, this.mRiskRequest);
        showPermissionDlg();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showPermissionDlg() {
        String string = getString(C0603R.string.truing_live_camera_permission_dlg_title);
        String string2 = getString(C0603R.string.truing_live_camera_permission_dlg_content);
        AlertDialogParam alertDialogParam = new AlertDialogParam();
        alertDialogParam.title = string;
        alertDialogParam.contentText = string2;
        alertDialogParam.lefBtnText = getString(C0603R.string.truing_live_camera_permission_dlg_left_btn_text);
        alertDialogParam.rightBtnText = getString(C0603R.string.truing_live_camera_permission_dlg_right_btn_text);
        PermissionAlertDialog permissionAlertDialog = new PermissionAlertDialog(this, alertDialogParam, false, new TuringAlertDialogCallBack() { // from class: com.bytedance.bdturing.comonui.VerifyConfirmDialogActivity.4
            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onLeftBtnClick() {
                int unused = VerifyConfirmDialogActivity.mConfirmResult = 5;
                VerifyConfirmDialogActivity.this.finish();
            }

            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onRightBtnClick() {
                VerifyConfirmDialogActivity.this.mDialog.dismiss();
                VerifyConfirmDialogActivity.this.turn2Setting();
            }

            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onCancel() {
                int unused = VerifyConfirmDialogActivity.mConfirmResult = 5;
                VerifyConfirmDialogActivity.this.finish();
            }
        });
        this.mDialog = permissionAlertDialog;
        permissionAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turn2Setting() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        startActivityForResult(intent, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (1 != i) {
            if (i != REQUEST_CODE_NEW_WEB || intent == null) {
                return;
            }
            sendResultDataToWeb(intent.getStringExtra(CommonWebActivity.RESULT_KEY));
            return;
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            startLiveDetect();
        } else {
            this.backFromSetting = true;
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 1);
        }
    }

    private void sendResultDataToWeb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            callJsCode(JsCallParser.parseNativeCallJs(1, VerifyDialogHandler.OPEN_NEW_WEB_RESULT, JsCallParser.VALUE_CALL, new JSONObject(str), VerifyDialogHandler.OPEN_NEW_WEB_RESULT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity
    public void onDestroy() {
        super.onDestroy();
        EventReport.confirmDialogClose(mConfirmResult, this.mRiskRequest, this.mNewBizUrl);
        this.isDismissing = true;
        dispatchResult(mConfirmResult, this.mNewBizUrl);
    }

    public void finish() {
        super.finish();
        PermissionAlertDialog permissionAlertDialog = this.mDialog;
        if (permissionAlertDialog != null) {
            permissionAlertDialog.dismiss();
            this.mDialog = null;
        }
        overridePendingTransition(0, 0);
    }

    public void onBackPressed() {
        if (isBackEnable()) {
            mConfirmResult = 3;
            super.onBackPressed();
        }
    }

    private boolean isBackEnable() {
        if (this.mRiskRequest == null || !isLiveVerify()) {
            return true;
        }
        return this.mRiskRequest.cancelAble();
    }

    public boolean callJsCode(String str) {
        JsBridgeModule jsBridgeModule = this.mJsBridge;
        if (jsBridgeModule == null) {
            LogUtil.m161e(TAG, "(mJsBridge == null) ");
            return false;
        }
        jsBridgeModule.callJsCode(str);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_bdturing_comonui_VerifyConfirmDialogActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m167x9d57e3f9(VerifyConfirmDialogActivity verifyConfirmDialogActivity) {
        verifyConfirmDialogActivity.m168xa36e8f42();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) verifyConfirmDialogActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
