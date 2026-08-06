package com.bytedance.bdturing;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.cache.UrlInterceptor;
import com.bytedance.bdturing.methods.IVerifyInnerHandler;
import com.bytedance.bdturing.methods.JsBridgeModule;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.bdturing.methods.VerifyDialogHandler;
import com.bytedance.bdturing.sensor.MonitorManager;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.utils.JsonUtils;
import com.bytedance.bdturing.utils.UtilsKt;
import com.bytedance.bdturing.verify.RiskControlService;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import com.bytedance.bdturing.verify.request.SmarterVerifyRequest;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BdTuringVerifyActivity extends AppCompatActivity implements TuringVerifyInterface {
    private static final String TAG = "BdTuringVerifyActivity";
    private static final long TIME_OUT_TIME = 10000;
    protected ImageView loading;
    private BdTuringCallback mCallBack;
    private JsBridgeModule mJsBridge;
    private long mMaskTime;
    private MonitorManager mMonitorManager;
    protected AbstractRequest mRequest;
    private int mVerifyType;
    private CardView mWebContainer;
    protected TuringVerifyWebView mWebView;
    protected EventReport.CloseType mCloseReson = EventReport.CloseType.CLOSE_REASON_APP;
    private OnTouchReportListener mOnTouchReportListener = null;
    private boolean isPageLoadSuccess = false;
    private boolean isDismissing = false;
    private boolean mIsOrientationChange = false;
    private boolean isColseByH5 = false;
    private VerifyWebViewListener webViewListener = new VerifyWebViewListener() { // from class: com.bytedance.bdturing.BdTuringVerifyActivity.1
        @Override // com.bytedance.bdturing.VerifyWebViewListener
        public void onReceivedError(int i, String str, String str2) {
        }

        @Override // com.bytedance.bdturing.VerifyWebViewListener
        public void onLoadPageSuccess() {
            BdTuringVerifyActivity.this.isPageLoadSuccess = true;
            EventReport.turingH5LoadResult(0, System.currentTimeMillis() - BdTuringVerifyActivity.this.mMaskTime, BdTuringVerifyActivity.this.mRequest);
        }

        @Override // com.bytedance.bdturing.VerifyWebViewListener
        public void onLoadPageFail(int i, String str) {
            EventReport.turingH5LoadResult(1, System.currentTimeMillis() - BdTuringVerifyActivity.this.mMaskTime, BdTuringVerifyActivity.this.mRequest);
            BdTuringVerifyActivity.this.isPageLoadSuccess = false;
            BdTuringVerifyActivity.this.mCloseReson = EventReport.CloseType.CLOSE_REASON_PAGE_LOAD_FAILED;
            BdTuringVerifyActivity.this.dismiss();
        }
    };
    private IVerifyInnerHandler mVerifyHandler = new VerifyDialogHandler() { // from class: com.bytedance.bdturing.BdTuringVerifyActivity.2
        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void onVerify(String str, BdTuringCallback bdTuringCallback) {
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void onVerifyResult(int i, String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
            boolean z = i == 0;
            LogUtil.m162i(BdTuringVerifyActivity.TAG, "====> jsb onVerifyResult:" + i);
            EventReport.statisticVerifyResult(i, BdTuringVerifyActivity.this.mRequest);
            if (BdTuringVerifyActivity.this.mCallBack != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("token", str3);
                    jSONObject2.put("mobile", str4);
                    jSONObject2.put("decision", str5);
                    jSONObject2.put("query", jSONObject);
                } catch (JSONException e) {
                    LogUtil.printException(e);
                }
                if (z) {
                    BdTuringVerifyActivity.this.mCallBack.onSuccess(i, jSONObject2);
                } else {
                    BdTuringVerifyActivity.this.mCallBack.onFail(i, jSONObject2);
                }
                BdTuringVerifyActivity.this.mCallBack = null;
            }
            BdTuringVerifyActivity.this.isColseByH5 = true;
            BdTuringVerifyActivity.this.dismiss();
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void onSetDialogSize(int i, int i2, boolean z) {
            BdTuringVerifyActivity.this.changeDialog(i, i2, z);
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void onSetDialogSizeV2(int i, int i2, boolean z) {
            BdTuringVerifyActivity.this.changeDialogV2(i, i2, z);
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void clearDialogResource() {
            BdTuringVerifyActivity.this.clearResource();
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void getSettings(JsCallParser jsCallParser) {
            jsCallParser.response(1, BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getTheme(BdTuringVerifyActivity.this.mVerifyType) : null);
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void getSdkInfo(JsCallParser jsCallParser) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putValue(jSONObject, "maskTime", Long.valueOf(BdTuringVerifyActivity.this.mMaskTime));
            jsCallParser.response(1, jSONObject);
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void getSensorData(JsCallParser jsCallParser) {
            JSONObject sensorData = BdTuringVerifyActivity.this.mMonitorManager.getSensorData();
            System.currentTimeMillis();
            jsCallParser.response(1, sensorData);
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void uploadSmarterData() {
            JSONObject smarterData;
            if (!(BdTuringVerifyActivity.this.mRequest instanceof SmarterVerifyRequest) || (smarterData = ((SmarterVerifyRequest) BdTuringVerifyActivity.this.mRequest).getSmarterData()) == null) {
                return;
            }
            BdTuringVerifyActivity.this.callJsCode(JsCallParser.parseNativeCallJs(1, JsCallParser.VERIFY_DATA, JsCallParser.VALUE_CALL, smarterData, JsCallParser.VERIFY_DATA));
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void onH5Available() {
            if (BdTuringVerifyActivity.this.mWebView != null) {
                BdTuringVerifyActivity.this.mWebView.onH5Available();
            }
        }
    };
    private ComponentCallbacks mOrientationListener = new ComponentCallbacks() { // from class: com.bytedance.bdturing.BdTuringVerifyActivity.5
        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            if (configuration.orientation == 1 || configuration.orientation == 2) {
                int i = configuration.orientation == 1 ? 2 : 1;
                boolean z = BdTuringVerifyActivity.this.mRequest.getType() == 2;
                LogUtil.m160d(BdTuringVerifyActivity.TAG, "canOrientation: " + z);
                if (z) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(EventReport.SCREEN_ORIENTATION, i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String parseNativeCallJs = JsCallParser.parseNativeCallJs(1, "bytedcert.orientation_changing", JsCallParser.VALUE_CALL, jSONObject, "bytedcert.orientation_changing");
                    BdTuringVerifyActivity.this.mIsOrientationChange = true;
                    BdTuringVerifyActivity.this.callJsCode(parseNativeCallJs);
                    EventReport.statisticOrientationChange(i, BdTuringVerifyActivity.this.mRequest);
                }
            }
        }
    };

    @Override // com.bytedance.bdturing.TuringVerifyInterface
    public boolean isShowing() {
        return true;
    }

    public static void startActivity(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) BdTuringVerifyActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mRequest = RiskControlService.INSTANCE.getCurrentRequest();
        setContentView(C0603R.layout.bdturing_verify_activity);
        EventReport.verifyActivityOnCreate(getClass().getSimpleName(), this.mRequest);
        EventReport.statisticOrientation(UtilsKt.getCurrentOrientation(this), this.mRequest);
        this.mCallBack = RiskControlService.INSTANCE.getResultCallBack();
        if (this.mRequest == null) {
            finish();
            return;
        }
        initSensor();
        this.mVerifyType = this.mRequest.getType();
        RiskControlService.INSTANCE.bindVerifyInterface(this);
        registerComponentCallbacks(this.mOrientationListener);
        initView();
        startLoading();
        this.mMaskTime = System.currentTimeMillis();
        this.mJsBridge = new JsBridgeModule(this.mVerifyHandler, this.mWebView);
        String url = this.mRequest.getUrl();
        LogUtil.m162i(TAG, "loadUrl = " + url);
        this.mWebView.setInterceptor(new UrlInterceptor(1, url));
        this.mWebView.loadUrl(url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initSensor() {
        this.mMonitorManager = new MonitorManager(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        this.mMonitorManager.onResume();
        super.onResume();
    }

    protected void onPause() {
        this.mMonitorManager.onPause();
        super.onPause();
    }

    private void startLoading() {
        if (this.mRequest.getLoading()) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.loading.startAnimation(rotateAnimation);
            return;
        }
        this.loading.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLoading() {
        if (this.mRequest.getLoading()) {
            this.loading.clearAnimation();
            this.loading.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.loading = (ImageView) findViewById(C0603R.id.loading);
        this.mWebView = (TuringVerifyWebView) findViewById(C0603R.id.verify_webview);
        this.mWebContainer = findViewById(C0603R.id.web_container);
        if (this.mRequest.getFullscreen()) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            ViewGroup.LayoutParams layoutParams = this.mWebView.getLayoutParams();
            layoutParams.width = displayMetrics.widthPixels;
            layoutParams.height = displayMetrics.heightPixels;
            this.mWebView.setLayoutParams(layoutParams);
            this.mWebView.setVisibility(0);
        }
        this.mWebView.init(this.webViewListener, this.mRequest);
        OnTouchReportListener onTouchReportListener = new OnTouchReportListener(this.mRequest.getMMaxEvents());
        this.mOnTouchReportListener = onTouchReportListener;
        this.mWebView.setOnTouchListener(onTouchReportListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void changeDialogV2(int i, int i2, boolean z) {
        final int i3;
        final int i4;
        this.isPageLoadSuccess = true;
        this.mCloseReson = EventReport.CloseType.CLOSE_REASON_APP;
        if (this.isDismissing) {
            return;
        }
        final boolean z2 = this.mRequest.getFullscreen() || z;
        if (z2) {
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
            this.mWebView.post(new Runnable() { // from class: com.bytedance.bdturing.BdTuringVerifyActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BdTuringVerifyActivity.this.isDismissing || BdTuringVerifyActivity.this.mWebView == null) {
                        return;
                    }
                    BdTuringVerifyActivity.this.stopLoading();
                    if (BdTuringVerifyActivity.this.mWebContainer != null && z2) {
                        BdTuringVerifyActivity.this.mWebContainer.setRadius(0.0f);
                    }
                    layoutParams.width = i3;
                    layoutParams.height = i4;
                    BdTuringVerifyActivity.this.mWebView.setLayoutParams(layoutParams);
                    BdTuringVerifyActivity.this.mWebView.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void changeDialog(int i, int i2, boolean z) {
        final int i3;
        final int i4;
        this.isPageLoadSuccess = true;
        this.mCloseReson = EventReport.CloseType.CLOSE_REASON_APP;
        if (this.isDismissing) {
            return;
        }
        final boolean z2 = this.mRequest.getFullscreen() || z;
        if (z2) {
            Point availableScreenSize = UtilsKt.getAvailableScreenSize(this);
            int i5 = availableScreenSize.x;
            i4 = availableScreenSize.y;
            i3 = i5;
        } else {
            float density = UtilsKt.getDensity(this);
            if (i > 0 && i2 > 0) {
                i = Math.round(i * density);
                i2 = Math.round(density * i2);
            }
            i3 = i;
            i4 = i2;
        }
        final ViewGroup.LayoutParams layoutParams = this.mWebView.getLayoutParams();
        if (this.mIsOrientationChange && layoutParams.width > 0 && layoutParams.height > 0) {
            this.mWebView.startOrientationChangeAnimation(i3, i4, layoutParams.width, layoutParams.height);
            this.mIsOrientationChange = false;
        } else {
            this.mWebView.post(new Runnable() { // from class: com.bytedance.bdturing.BdTuringVerifyActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (BdTuringVerifyActivity.this.isDismissing) {
                        return;
                    }
                    BdTuringVerifyActivity.this.stopLoading();
                    if (z2 && BdTuringVerifyActivity.this.mWebContainer != null) {
                        BdTuringVerifyActivity.this.mWebContainer.setRadius(0.0f);
                    }
                    layoutParams.width = i3;
                    layoutParams.height = i4;
                    BdTuringVerifyActivity.this.mWebView.setLayoutParams(layoutParams);
                    BdTuringVerifyActivity.this.mWebView.setVisibility(0);
                }
            });
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnTouchReportListener onTouchReportListener = this.mOnTouchReportListener;
        if (onTouchReportListener != null) {
            onTouchReportListener.onTouch(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onBackPressed() {
        TuringVerifyWebView turingVerifyWebView = this.mWebView;
        if (turingVerifyWebView != null && turingVerifyWebView.canGoBack()) {
            this.mWebView.goBack();
        } else if (handleBackPress()) {
            this.mCloseReson = EventReport.CloseType.CLOSE_REASON_BACK;
            super.onBackPressed();
        }
    }

    protected boolean handleBackPress() {
        return SettingsManager.INSTANCE.getVerifyCancellable();
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

    @Override // com.bytedance.bdturing.TuringVerifyInterface
    public void dismiss() {
        finish();
    }

    private void notifyJsToClose(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("style", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callJsCode(JsCallParser.parseNativeCallJs(1, JsCallParser.GO_TO_CLOSE, JsCallParser.VALUE_CALL, jSONObject, JsCallParser.GO_TO_CLOSE));
    }

    @Override // com.bytedance.bdturing.TuringVerifyInterface
    public synchronized void clearResource() {
        LogUtil.m162i(TAG, "clearResource()");
        VerifyTaskHandler.getInstance().removeMessage(1);
        JsBridgeModule jsBridgeModule = this.mJsBridge;
        if (jsBridgeModule == null) {
            return;
        }
        jsBridgeModule.clearJsBridgeResources();
        this.mJsBridge = null;
    }

    @Override // com.bytedance.bdturing.TuringVerifyInterface
    public void cancelByConflict(int i) {
        BdTuringCallback bdTuringCallback = this.mCallBack;
        if (bdTuringCallback != null) {
            bdTuringCallback.onFail(i, null);
            this.mCallBack = null;
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        EventReport.statisticDialogBackground(this.mRequest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.m162i(TAG, "======>onDestroy");
        MonitorManager monitorManager = this.mMonitorManager;
        if (monitorManager != null) {
            monitorManager.release();
        }
        try {
            try {
                if (this.mWebView != null) {
                    getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.bdturing.BdTuringVerifyActivity.6
                        private WebView webView;

                        {
                            this.webView = BdTuringVerifyActivity.this.mWebView;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            ViewParent parent;
                            LogUtil.m163w(BdTuringVerifyActivity.TAG, "remove webview");
                            WebView webView = this.webView;
                            if (webView == null || (parent = webView.getParent()) == null || !(parent instanceof ViewGroup)) {
                                return;
                            }
                            ((ViewGroup) parent).removeView(this.webView);
                        }
                    });
                    this.mWebView = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.isDismissing) {
                return;
            }
            this.isDismissing = true;
            unregisterComponentCallbacks(this.mOrientationListener);
            if (this.isPageLoadSuccess) {
                if (!this.isColseByH5) {
                    notifyJsToClose(this.mCloseReson.getName());
                }
                VerifyTaskHandler.getInstance().sendMessageDelay(1, this, 10000L);
            } else {
                clearResource();
                EventReport.statisticCloseReason(this.mCloseReson, this.mRequest);
            }
            if (this.mCallBack != null) {
                int i = C05997.$SwitchMap$com$bytedance$bdturing$EventReport$CloseType[this.mCloseReson.ordinal()];
                if (i == 1) {
                    this.mCallBack.onFail(3, null);
                } else if (i == 2) {
                    this.mCallBack.onFail(5, null);
                } else if (i == 3) {
                    this.mCallBack.onFail(6, null);
                } else {
                    this.mCallBack.onFail(1, null);
                }
            }
        } finally {
            VerifyTaskHandler.getInstance().sendMessage(3, null);
            this.mCallBack = null;
            RiskControlService.INSTANCE.release();
            EventReport.turingVerifyActivityOnDestroy(System.currentTimeMillis() - this.mMaskTime, TAG, this.mRequest);
            this.mRequest = null;
        }
    }

    /* renamed from: com.bytedance.bdturing.BdTuringVerifyActivity$7 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    static /* synthetic */ class C05997 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bdturing$EventReport$CloseType;

        static {
            int[] iArr = new int[EventReport.CloseType.values().length];
            $SwitchMap$com$bytedance$bdturing$EventReport$CloseType = iArr;
            try {
                iArr[EventReport.CloseType.CLOSE_REASON_PAGE_LOAD_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$bdturing$EventReport$CloseType[EventReport.CloseType.CLOSE_REASON_BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$bdturing$EventReport$CloseType[EventReport.CloseType.CLOSE_REASON_APP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
