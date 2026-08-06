package com.bytedance.bdturing.livedetect;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.bdturing.C0603R;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.comonui.AlertDialogParam;
import com.bytedance.bdturing.comonui.TuringAlertDialog;
import com.bytedance.bdturing.comonui.TuringAlertDialogCallBack;
import com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity;
import com.bytedance.bdturing.livedetect.net.INetWorkCallBack;
import com.bytedance.bdturing.livedetect.pty.FrameDetectResult;
import com.bytedance.bdturing.livedetect.view.LiveDetectMaskView;
import com.bytedance.bdturing.livedetect.view.LiveDetectView;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TuringLiveDetectActivity extends TuringBaseLiveDetectActivity {
    private static final int CAMERA_MAX_OPEN_COUNT = 2;
    protected static final String DETAIL = "detail";
    protected static final int DIALOG_STATE_BACK_CANCEL = 3;
    protected static final int DIALOG_STATE_CANCEL_CLICK = 1;
    protected static final int DIALOG_STATE_CONFIRM_CLICK = 2;
    protected static final int DIALOG_STATE_SHOW = 0;
    protected static final int DIALOG_TYPE_FAIL_TIP = 2;
    protected static final int DIALOG_TYPE_MODEL_LOAD_ERROR = 3;
    protected static final int DIALOG_TYPE_NET_ERROR = 1;
    private static final long TIPS_DURATION = 500;
    private static final int TIPS_GAP = 30;
    private String mDecisionDetail;
    protected TuringAlertDialog mDialog;
    private LiveDetectView mLiveDetectView;
    private long mPageShowTime;
    protected AbstractRequest mRequest;
    private String mSalt;
    private String mTicket;
    private long mTimeStart;
    private Handler mUiHandler;
    private TextView tvDetectError;
    private TextView tvDetectState;
    private TextView tvDetectTips;
    private TextView tvTimeInfo;
    private boolean isDestroy = false;
    private long mLastTipsTime = 0;
    private Map<Integer, String> mTipsMap = new HashMap();
    private int mResult = 1;
    private boolean mDetectFinish = false;
    private int currentNum = 0;
    INetWorkCallBack mSessionCallBack = new INetWorkCallBack() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.1
        @Override // com.bytedance.bdturing.livedetect.net.INetWorkCallBack
        public void onResponse(final int i, final JSONObject jSONObject, final String... strArr) {
            TuringLiveDetectActivity.this.runTaskOnUIThread(new Runnable() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    TuringLiveDetectActivity.this.dismissLoadingDlg();
                    int i2 = i;
                    if (i2 != 200) {
                        if (i2 == -9999) {
                            EventReport.createSessionResult(false, "show NetFailDlg", TuringLiveDetectActivity.this.mRequest);
                            TuringLiveDetectActivity.this.showNetFailDlg();
                            return;
                        } else {
                            EventReport.createSessionResult(false, "show FailDlg:", TuringLiveDetectActivity.this.mRequest);
                            TuringLiveDetectActivity.this.showFailDlg(strArr);
                            return;
                        }
                    }
                    TuringLiveDetectActivity turingLiveDetectActivity = TuringLiveDetectActivity.this;
                    JSONObject jSONObject2 = jSONObject;
                    turingLiveDetectActivity.mTicket = jSONObject2 != null ? jSONObject2.optString("ticket") : "";
                    TuringLiveDetectActivity turingLiveDetectActivity2 = TuringLiveDetectActivity.this;
                    JSONObject jSONObject3 = jSONObject;
                    turingLiveDetectActivity2.mSalt = jSONObject3 != null ? jSONObject3.optString("salt") : "";
                    EventReport.createSessionResult(true, "ticket=" + TuringLiveDetectActivity.this.mTicket + ":salt=" + TuringLiveDetectActivity.this.mSalt, TuringLiveDetectActivity.this.mRequest);
                    TuringLiveDetectActivity.this.checkPermission();
                }
            });
        }

        @Override // com.bytedance.bdturing.livedetect.net.INetWorkCallBack
        public void onError(final Throwable th) {
            TuringLiveDetectActivity.this.runTaskOnUIThread(new Runnable() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.1.2
                @Override // java.lang.Runnable
                public void run() {
                    EventReport.createSessionResult(false, "on Error:" + th, TuringLiveDetectActivity.this.mRequest);
                    TuringLiveDetectActivity.this.dismissLoadingDlg();
                    TuringLiveDetectActivity.this.showNetFailDlg();
                }
            });
        }
    };
    private INetWorkCallBack mVerifyCallBack = new INetWorkCallBack() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.7
        @Override // com.bytedance.bdturing.livedetect.net.INetWorkCallBack
        public void onResponse(final int i, final JSONObject jSONObject, final String... strArr) {
            TuringLiveDetectActivity.this.runTaskOnUIThread(new Runnable() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.7.1
                @Override // java.lang.Runnable
                public void run() {
                    TuringLiveDetectActivity.this.stopLoading();
                    if (i == 200) {
                        TuringLiveDetectActivity.this.mResult = 0;
                        EventReport.LiveRemoteVerifyResult(true, "", TuringLiveDetectActivity.this.mRequest);
                        TuringLiveDetectActivity.this.showSuccessStateAndFinish();
                        return;
                    }
                    TuringLiveDetectActivity.this.mLiveDetectView.setDetectResult(false);
                    JSONObject jSONObject2 = jSONObject;
                    boolean optBoolean = jSONObject2 != null ? jSONObject2.optBoolean("retryable", false) : true;
                    EventReport.LiveRemoteVerifyResult(false, "retryable:" + optBoolean, TuringLiveDetectActivity.this.mRequest);
                    if (optBoolean) {
                        TuringLiveDetectActivity.this.showRetryDlg(strArr);
                    } else {
                        TuringLiveDetectActivity.this.showFailDlg(strArr);
                    }
                }
            });
        }

        @Override // com.bytedance.bdturing.livedetect.net.INetWorkCallBack
        public void onError(Throwable th) {
            TuringLiveDetectActivity.this.runTaskOnUIThread(new Runnable() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.7.2
                @Override // java.lang.Runnable
                public void run() {
                    TuringLiveDetectActivity.this.stopLoading();
                    TuringLiveDetectActivity.this.showRetryDlg(null);
                }
            });
        }
    };

    protected void initEngine() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(8192, 8192);
        this.mDecisionDetail = getIntent().getStringExtra("detail");
        this.mRequest = LiveDetectService.getInstance().getRequest();
        setContentView(C0603R.layout.activity_turing_live_detect);
        initView();
        this.mPageShowTime = System.currentTimeMillis();
        this.mUiHandler = new Handler();
        LiveDetectService.getInstance().setOnVerify(true);
        initEngine();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createSession() {
        EventReport.startCreateSession("mDecisionDetail:", this.mRequest);
        if (TextUtils.isEmpty(this.mDecisionDetail)) {
            finish();
        } else {
            showLoadingDlg();
            LiveDetectService.getInstance().createSession(this.mDecisionDetail, this.mSessionCallBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void initTipsMap() {
        this.mTipsMap = FrameDetectResult.buildTipsMap(this);
    }

    private void initView() {
        this.ivLoading = (ImageView) findViewById(C0603R.id.loading);
        LiveDetectView liveDetectView = (LiveDetectView) findViewById(C0603R.id.turing_ldv);
        this.mLiveDetectView = liveDetectView;
        liveDetectView.setBoxStateListener(new LiveDetectMaskView.BoxStateListener() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.2
            @Override // com.bytedance.bdturing.livedetect.view.LiveDetectMaskView.BoxStateListener
            public void onBoxSizeChange(Rect rect) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TuringLiveDetectActivity.this.ivLoading.getLayoutParams();
                marginLayoutParams.topMargin = rect.centerY() - (TuringLiveDetectActivity.this.ivLoading.getMeasuredHeight() / 2);
                marginLayoutParams.leftMargin = rect.centerX() - (TuringLiveDetectActivity.this.ivLoading.getMeasuredWidth() / 2);
                TuringLiveDetectActivity.this.ivLoading.setLayoutParams(marginLayoutParams);
            }
        });
        this.tvDetectTips = (TextView) findViewById(C0603R.id.tv_detect_state);
        this.tvDetectState = (TextView) findViewById(C0603R.id.tv_test_img_detect_state);
        this.tvDetectError = (TextView) findViewById(C0603R.id.tv_test_img_detect_error);
        this.tvTimeInfo = (TextView) findViewById(C0603R.id.tv_test_time_use);
        initDetectView();
    }

    private void initDetectView() {
        this.mLiveDetectView.setDetectTimeOut(LiveAuthConfig.liveDetectTimeOut());
        displayDebugInfo();
        this.mLiveDetectView.setDetectStateCallBack(new LiveDetectView.DetectStateCallback() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.3
            @Override // com.bytedance.bdturing.livedetect.view.LiveDetectView.DetectStateCallback
            public void onStateChange(int i) {
            }

            @Override // com.bytedance.bdturing.livedetect.view.LiveDetectView.DetectStateCallback
            public void onFrameImageDetectResult(FrameDetectResult frameDetectResult) {
                if (TuringLiveDetectActivity.this.mDetectFinish) {
                    return;
                }
                TuringLiveDetectActivity.this.handleDetectResult(frameDetectResult);
            }

            @Override // com.bytedance.bdturing.livedetect.view.LiveDetectView.DetectStateCallback
            public void onError(int i, String str) {
                if (40001 == i) {
                    TuringLiveDetectActivity.this.tryOpenCamera();
                }
                EventReport.liveDetectError(i, str, TuringLiveDetectActivity.this.mRequest);
            }

            @Override // com.bytedance.bdturing.livedetect.view.LiveDetectView.DetectStateCallback
            public void onDetectTimeOut() {
                TuringLiveDetectActivity.this.stopLiveDetect();
                EventReport.LiveLocalVerifyResult(false, System.currentTimeMillis() - TuringLiveDetectActivity.this.mTimeStart, "timeOut", TuringLiveDetectActivity.this.mRequest);
                TuringLiveDetectActivity.this.showRetryDlg(null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryOpenCamera() {
        int i = this.currentNum;
        if (i < 2) {
            this.currentNum = i + 1;
            this.mUiHandler.postDelayed(new Runnable() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (TuringLiveDetectActivity.this.isDestroy) {
                        return;
                    }
                    try {
                        TuringLiveDetectActivity.this.stopLiveDetect();
                        TuringLiveDetectActivity.this.startLiveDetect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, this.currentNum * 500);
        } else {
            runTaskOnUIThread(new Runnable() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.5
                /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, com.bytedance.bdturing.livedetect.TuringLiveDetectActivity] */
                @Override // java.lang.Runnable
                public void run() {
                    ?? r0 = TuringLiveDetectActivity.this;
                    Toast.makeText((Context) r0, r0.getString(C0603R.string.turing_live_camera_in_use), 1).show();
                }
            });
        }
    }

    private void displayDebugInfo() {
        this.mLiveDetectView.setDebugInfoCallBack(new DebugInfoCallBack() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.6
            @Override // com.bytedance.bdturing.livedetect.DebugInfoCallBack
            public void debugInfo(JSONObject jSONObject) {
                if (jSONObject != null) {
                    boolean optBoolean = jSONObject.optBoolean("success");
                    TuringLiveDetectActivity.this.tvDetectState.setText("PTY运行正常:" + optBoolean);
                    StringBuilder sb = new StringBuilder("totalTime:");
                    long optLong = jSONObject.optLong("convert_camera_data_time_use");
                    long optLong2 = jSONObject.optLong("pty_time_use");
                    int optInt = jSONObject.optInt("status", -1);
                    String optString = jSONObject.optString("debugInfo", "");
                    sb.append(optLong + optLong2).append("\ncameraTime:");
                    sb.append(optLong).append("\nptyTime:");
                    sb.append(optLong2).append("\n---------\nstatus:");
                    sb.append(optInt).append("\ndebug:");
                    sb.append(optString).append("\n");
                    TuringLiveDetectActivity.this.tvTimeInfo.setText(sb.toString());
                    if (optBoolean) {
                        TuringLiveDetectActivity.this.tvDetectError.setText("");
                        return;
                    }
                    String obj = jSONObject.opt("ptyError") != null ? jSONObject.opt("ptyError").toString() : "";
                    if (TextUtils.isEmpty(obj) || obj.contains("Continuous 3 exceptions")) {
                        return;
                    }
                    TuringLiveDetectActivity.this.tvDetectError.setText("PTYError:\n" + obj);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDetectResult(FrameDetectResult frameDetectResult) {
        if (frameDetectResult != null) {
            showTips(this.mTipsMap.get(Integer.valueOf(frameDetectResult.status)));
            if (frameDetectResult.isSuccess()) {
                EventReport.LiveLocalVerifyResult(true, System.currentTimeMillis() - this.mTimeStart, "", this.mRequest);
                stopLiveDetect();
                doServerDetect(frameDetectResult);
            }
        }
    }

    private void showTips(String str) {
        if (System.currentTimeMillis() - this.mLastTipsTime < 500) {
            return;
        }
        if (str == null) {
            str = "";
        }
        this.mLastTipsTime = System.currentTimeMillis();
        this.tvDetectTips.setText(str);
    }

    private void doServerDetect(FrameDetectResult frameDetectResult) {
        startLoading();
        this.tvDetectTips.setText(C0603R.string.turing_live_detect_server_detecting);
        LiveDetectService.getInstance().verify(this.mDecisionDetail, this.mTicket, this.mSalt, frameDetectResult, this.mVerifyCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSuccessStateAndFinish() {
        this.mLiveDetectView.setDetectResult(true);
        Handler handler = this.mUiHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    TuringLiveDetectActivity.this.finish();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void showFailDlg(String[] strArr) {
        TuringAlertDialog turingAlertDialog = this.mDialog;
        if (turingAlertDialog != null) {
            turingAlertDialog.dismiss();
        }
        String str = (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(strArr[0])) ? "" : strArr[0];
        String str2 = (strArr == null || strArr.length <= 1 || TextUtils.isEmpty(strArr[1])) ? "" : strArr[1];
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            str = getString(C0603R.string.turing_live_detect_dlg_fail_title);
            str2 = getString(C0603R.string.turing_live_detect_dlg_fail_content);
        }
        AlertDialogParam alertDialogParam = new AlertDialogParam();
        alertDialogParam.title = str;
        alertDialogParam.contentText = str2;
        alertDialogParam.lefBtnText = getString(C0603R.string.turing_live_detect_dlg_fail_left_text);
        alertDialogParam.rightBtnText = getString(C0603R.string.turing_live_detect_dlg_fail_right_text);
        TuringAlertDialog turingAlertDialog2 = new TuringAlertDialog(this, alertDialogParam, false, new TuringAlertDialogCallBack() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.9
            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onLeftBtnClick() {
                TuringLiveDetectActivity.this.turn2Help();
                EventReport.liveDialogState(2, 2, "liveDetectPage", "", TuringLiveDetectActivity.this.mRequest);
            }

            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onRightBtnClick() {
                TuringLiveDetectActivity.this.finish();
                EventReport.liveDialogState(2, 1, "liveDetectPage", "", TuringLiveDetectActivity.this.mRequest);
            }

            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onCancel() {
                TuringLiveDetectActivity.this.finish();
                EventReport.liveDialogState(2, 3, "liveDetectPage", "", TuringLiveDetectActivity.this.mRequest);
            }
        });
        this.mDialog = turingAlertDialog2;
        turingAlertDialog2.show();
        EventReport.liveDialogState(2, 0, "liveDetectPage", "", this.mRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showNetFailDlg() {
        TuringAlertDialog turingAlertDialog = this.mDialog;
        if (turingAlertDialog != null) {
            turingAlertDialog.dismiss();
        }
        String string = getString(C0603R.string.turing_net_error_dlg_fail_title);
        String string2 = getString(C0603R.string.turing_net_error_dlg_fail_content);
        AlertDialogParam alertDialogParam = new AlertDialogParam();
        alertDialogParam.title = string;
        alertDialogParam.contentText = string2;
        alertDialogParam.lefBtnText = getString(C0603R.string.turing_net_error_dlg_left_text);
        alertDialogParam.rightBtnText = getString(C0603R.string.turing_net_error_dlg_right_text);
        TuringAlertDialog turingAlertDialog2 = new TuringAlertDialog(this, alertDialogParam, false, new TuringAlertDialogCallBack() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.10
            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onLeftBtnClick() {
                EventReport.liveDialogState(1, 1, "liveDetectPage", "", TuringLiveDetectActivity.this.mRequest);
                TuringLiveDetectActivity.this.finish();
            }

            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onRightBtnClick() {
                if (TuringLiveDetectActivity.this.mDialog != null) {
                    TuringLiveDetectActivity.this.mDialog.dismiss();
                }
                EventReport.liveDialogState(1, 2, "liveDetectPage", "", TuringLiveDetectActivity.this.mRequest);
                TuringLiveDetectActivity.this.createSession();
            }

            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onCancel() {
                EventReport.liveDialogState(1, 3, "liveDetectPage", "", TuringLiveDetectActivity.this.mRequest);
                TuringLiveDetectActivity.this.finish();
            }
        });
        this.mDialog = turingAlertDialog2;
        turingAlertDialog2.show();
        EventReport.liveDialogState(1, 0, "liveDetectPage", "", this.mRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showRetryDlg(String[] strArr) {
        TuringAlertDialog turingAlertDialog = this.mDialog;
        if (turingAlertDialog != null) {
            turingAlertDialog.dismiss();
        }
        AlertDialogParam alertDialogParam = new AlertDialogParam();
        String str = "";
        String str2 = (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(strArr[0])) ? "" : strArr[0];
        if (strArr != null && strArr.length > 1 && !TextUtils.isEmpty(strArr[1])) {
            str = strArr[1];
        }
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
            str2 = getResources().getString(C0603R.string.turing_live_detect_dlg_timeout_title);
            str = getResources().getString(C0603R.string.turing_live_detect_dlg_timeout_content);
        }
        alertDialogParam.title = str2;
        alertDialogParam.contentText = str;
        alertDialogParam.lefBtnText = getResources().getString(C0603R.string.turing_live_detect_dlg_timeout_left_text);
        alertDialogParam.rightBtnText = getResources().getString(C0603R.string.turing_live_detect_dlg_timeout_right_text);
        TuringAlertDialog turingAlertDialog2 = new TuringAlertDialog(this, alertDialogParam, LiveAuthConfig.liveDetectCancellable(), new TuringAlertDialogCallBack() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.11
            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onLeftBtnClick() {
                TuringLiveDetectActivity.this.turn2Help();
            }

            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onRightBtnClick() {
                if (TuringLiveDetectActivity.this.mDialog != null) {
                    TuringLiveDetectActivity.this.mDialog.dismiss();
                }
                TuringLiveDetectActivity.this.createSession();
            }

            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onCancel() {
                TuringLiveDetectActivity.this.finish();
            }
        });
        this.mDialog = turingAlertDialog2;
        turingAlertDialog2.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void turn2Help() {
        TuringLiveDetectWebActivity.startActivity(this, LiveAuthConfig.getHelpH5Url(), getString(C0603R.string.turing_live_detect_help));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPermission() {
        checkCameraPermission(new TuringBaseLiveDetectActivity.CameraPermissionCallBack() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity.12
            @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.CameraPermissionCallBack
            public void onGRanted(int i) {
                TuringLiveDetectActivity.this.startLiveDetect();
            }

            @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.CameraPermissionCallBack
            public void onDenied(int i) {
                if (i == 1) {
                    Toast.makeText((Context) TuringLiveDetectActivity.this, (CharSequence) "为确保功能正常，请授予摄像头权限", 0).show();
                } else if (i == 2) {
                    Toast.makeText((Context) TuringLiveDetectActivity.this, (CharSequence) "为确保功能正常，请到设置中开启摄像头权限", 0).show();
                }
                TuringLiveDetectActivity.this.finish();
            }

            @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.CameraPermissionCallBack
            public void onForbidden() {
                TuringLiveDetectActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLiveDetect() {
        this.mTimeStart = System.currentTimeMillis();
        this.mDetectFinish = false;
        EventReport.LiveStartDetect(this.mRequest);
        changeScreenBrightness(1.0f);
        showTips(this.mTipsMap.get(20));
        this.mLiveDetectView.startDetect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLiveDetect() {
        this.mDetectFinish = true;
        showTips("");
        this.mLiveDetectView.stopDetect();
    }

    private void changeScreenBrightness(float f) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f;
        window.setAttributes(attributes);
    }

    protected void onResume() {
        super.onResume();
        if (this.mDetectFinish) {
            return;
        }
        this.mLiveDetectView.resumeDetect();
    }

    protected void onPause() {
        super.onPause();
        if (this.mDetectFinish) {
            return;
        }
        this.mLiveDetectView.stopDetect();
    }

    public void onBackPressed() {
        if (LiveAuthConfig.liveDetectCancellable()) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runTaskOnUIThread(Runnable runnable) {
        Handler handler;
        if (runnable == null || (handler = this.mUiHandler) == null) {
            return;
        }
        handler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity
    public void onDestroy() {
        super.onDestroy();
        this.isDestroy = true;
        TuringAlertDialog turingAlertDialog = this.mDialog;
        if (turingAlertDialog != null && turingAlertDialog.isShowing()) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        LiveDetectView liveDetectView = this.mLiveDetectView;
        if (liveDetectView != null) {
            liveDetectView.release();
        }
        this.mUiHandler.removeCallbacksAndMessages(null);
        this.mUiHandler = null;
        EventReport.onLivePageClose(TuringLiveDetectActivity.class.getName(), this.mResult, this.mRequest);
        EventReport.liveDetectResult(this.mResult, System.currentTimeMillis() - this.mPageShowTime, this.mRequest);
        LiveDetectService.getInstance().onResult(this.mResult, null);
        this.mRequest = null;
    }
}
