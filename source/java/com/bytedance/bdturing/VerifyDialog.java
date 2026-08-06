package com.bytedance.bdturing;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.methods.IVerifyInnerHandler;
import com.bytedance.bdturing.methods.JsBridgeModule;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.bdturing.methods.VerifyDialogHandler;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.utils.JsonUtils;
import com.bytedance.bdturing.utils.UtilsKt;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import com.bytedance.bdturing.verify.request.RiskInfoRequest;
import com.bytedance.bdturing.verify.request.SmarterVerifyRequest;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class VerifyDialog extends Dialog implements TuringVerifyInterface {
    private static final int MASK_COLOR = -2013265920;
    private static final String TAG = "VerifyDialog";
    private static final long TIME_OUT_TIME = 10000;
    private Context context;
    private boolean isColseByH5;
    private boolean isDismissing;
    private boolean isPageLoadSuccess;
    private ImageView loading;
    private BdTuringCallback mCallback;
    private Button mCloseBtn;
    private EventReport.CloseType mCloseReson;
    private FrameLayout mDialogLayout;
    private String mErrorText;
    private Button mFeedbackBtn;
    private TextView mFeedbackContent;
    private ViewGroup mFeedbackGroup;
    private boolean mIsOrientationChange;
    private JsBridgeModule mJsBridge;
    private long mMaskTime;
    private OnDialogBackgroundListener mOnDialogBackgroundListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private OnTouchReportListener mOnTouchReportListener;
    private ComponentCallbacks mOrientationListener;
    private String mUrl;
    private IVerifyInnerHandler mVerifyHandler;
    private int mVerifyType;
    private CardView mWebContainer;
    private VerifyWebView mWebView;
    private AbstractRequest request;
    private VerifyWebViewListener webViewListener;

    public VerifyDialog(AbstractRequest abstractRequest, BdTuringCallback bdTuringCallback) {
        super(abstractRequest.getActivity(), C0603R.style.VerifyDialogTheme);
        this.isPageLoadSuccess = false;
        this.isColseByH5 = false;
        this.isDismissing = false;
        this.mIsOrientationChange = false;
        this.mErrorText = null;
        this.mOnTouchReportListener = null;
        this.mCloseReson = EventReport.CloseType.CLOSE_REASON_APP;
        this.mVerifyHandler = new VerifyDialogHandler() { // from class: com.bytedance.bdturing.VerifyDialog.5
            @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
            public void onVerifyResult(int i, String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
                boolean z = i == 0;
                EventReport.statisticVerifyResult(i, VerifyDialog.this.request);
                if (VerifyDialog.this.mCallback != null) {
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
                        VerifyDialog.this.mCallback.onSuccess(i, jSONObject2);
                    } else {
                        VerifyDialog.this.mCallback.onFail(i, jSONObject2);
                    }
                    VerifyDialog.this.mCallback = null;
                }
                VerifyDialog.this.isColseByH5 = true;
                VerifyDialog.this.dismiss();
            }

            @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
            public void onSetDialogSize(int i, int i2, boolean z) {
                VerifyDialog.this.changeDialog(i, i2, z);
            }

            @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
            public void onSetDialogSizeV2(int i, int i2, boolean z) {
                VerifyDialog.this.changeDialogV2(i, i2, z);
            }

            @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
            public void clearDialogResource() {
                VerifyDialog.this.clearResource();
            }

            @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
            public void getSettings(JsCallParser jsCallParser) {
                jsCallParser.response(1, BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getTheme(VerifyDialog.this.mVerifyType) : null);
            }

            @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
            public void getSdkInfo(JsCallParser jsCallParser) {
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putValue(jSONObject, "maskTime", Long.valueOf(VerifyDialog.this.mMaskTime));
                jsCallParser.response(1, jSONObject);
            }

            @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
            public void onVerify(String str, BdTuringCallback bdTuringCallback2) {
                RiskInfoRequest riskInfoRequest = new RiskInfoRequest(str);
                riskInfoRequest.setLoading(false);
                riskInfoRequest.setMask(false);
                VerifyDialog.this.mOnDismissListener.onDismiss(VerifyDialog.this);
                BdTuring.getInstance().showVerifyDialog(VerifyDialog.this.request.getActivity(), riskInfoRequest, bdTuringCallback2);
            }

            @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
            public void uploadSmarterData() {
                JSONObject smarterData;
                if (!(VerifyDialog.this.request instanceof SmarterVerifyRequest) || (smarterData = ((SmarterVerifyRequest) VerifyDialog.this.request).getSmarterData()) == null) {
                    return;
                }
                VerifyDialog.this.callJsCode(JsCallParser.parseNativeCallJs(1, JsCallParser.VERIFY_DATA, JsCallParser.VALUE_CALL, smarterData, JsCallParser.VERIFY_DATA));
            }
        };
        this.webViewListener = new VerifyWebViewListener() { // from class: com.bytedance.bdturing.VerifyDialog.7
            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onReceivedError(int i, String str, String str2) {
            }

            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onLoadPageSuccess() {
                VerifyDialog.this.isPageLoadSuccess = true;
            }

            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onLoadPageFail(int i, String str) {
                VerifyDialog.this.isPageLoadSuccess = false;
                if (!VerifyDialog.this.isDismissing) {
                    VerifyDialog verifyDialog = VerifyDialog.this;
                    verifyDialog.mErrorText = verifyDialog.getFeedbackContent(i);
                }
                VerifyDialog.this.mCloseReson = EventReport.CloseType.CLOSE_REASON_PAGE_LOAD_FAILED;
                VerifyDialog.this.dismiss();
            }
        };
        this.mOrientationListener = new ComponentCallbacks() { // from class: com.bytedance.bdturing.VerifyDialog.8
            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                if (configuration.orientation == 1 || configuration.orientation == 2) {
                    int i = configuration.orientation == 1 ? 2 : 1;
                    boolean z = VerifyDialog.this.request.getType() == 2;
                    LogUtil.m160d(VerifyDialog.TAG, "canOrientation: " + z);
                    if (z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(EventReport.SCREEN_ORIENTATION, i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String parseNativeCallJs = JsCallParser.parseNativeCallJs(1, "bytedcert.orientation_changing", JsCallParser.VALUE_CALL, jSONObject, "bytedcert.orientation_changing");
                        VerifyDialog.this.mIsOrientationChange = true;
                        VerifyDialog.this.callJsCode(parseNativeCallJs);
                        EventReport.statisticOrientationChange(i, VerifyDialog.this.request);
                    }
                }
            }
        };
        this.request = abstractRequest;
        this.mVerifyType = abstractRequest.getType();
        this.mUrl = this.request.getUrl();
        this.mCallback = bdTuringCallback;
        this.mOnDialogBackgroundListener = new OnDialogBackgroundListener(this.request.getActivity());
        this.context = abstractRequest.getActivity();
        setListeners();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(LayoutInflater.from(this.context).inflate(C0603R.layout.layout_verify_dialog, (ViewGroup) null));
        initWindow();
        initViews();
        startLoading();
        if (this.request.getActivity() != null) {
            this.request.getActivity().registerComponentCallbacks(this.mOrientationListener);
            EventReport.statisticOrientation(UtilsKt.getCurrentOrientation(this.request.getActivity()), this.request);
        }
        this.mOnDialogBackgroundListener.registerListener();
        setCanceledOnTouchOutside(this.request.getMaskCancel());
        setCancelable(SettingsManager.INSTANCE.getVerifyCancellable());
        this.mJsBridge = new JsBridgeModule(this.mVerifyHandler, this.mWebView);
        LogUtil.m162i(TAG, "loadUrl = " + this.mUrl);
        this.mWebView.loadUrl(this.mUrl);
        if (this.request.getFullscreen()) {
            DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
            ViewGroup.LayoutParams layoutParams = this.mWebView.getLayoutParams();
            layoutParams.width = displayMetrics.widthPixels;
            layoutParams.height = displayMetrics.heightPixels;
            this.mWebView.setLayoutParams(layoutParams);
            this.mWebView.setVisibility(0);
        }
    }

    private void initWindow() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
    }

    private void startLoading() {
        if (this.request.getLoading()) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.loading.startAnimation(rotateAnimation);
            this.mDialogLayout.setBackgroundColor(MASK_COLOR);
            return;
        }
        this.loading.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLoading() {
        if (this.request.getLoading()) {
            this.loading.clearAnimation();
            this.loading.setVisibility(8);
        }
        if (this.request.getMask()) {
            this.mDialogLayout.setBackgroundColor(MASK_COLOR);
        }
    }

    private void initViews() {
        this.mFeedbackGroup = (ViewGroup) findViewById(C0603R.id.view_feedback);
        this.mFeedbackContent = (TextView) findViewById(C0603R.id.text_feedback_content);
        this.mFeedbackBtn = (Button) findViewById(C0603R.id.btn_feedback);
        this.mCloseBtn = (Button) findViewById(C0603R.id.btn_feedback_close);
        this.loading = (ImageView) findViewById(C0603R.id.loading);
        this.mWebView = (VerifyWebView) findViewById(C0603R.id.verify_webview);
        this.mWebContainer = findViewById(C0603R.id.web_container);
        this.mDialogLayout = (FrameLayout) findViewById(C0603R.id.dialog_framelayout);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.bdturing.VerifyDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int id = view.getId();
                if (id == C0603R.id.btn_feedback_close) {
                    VerifyDialog.this.mCloseReson = EventReport.CloseType.CLOSE_FB_CLOSE;
                } else if (id == C0603R.id.btn_feedback) {
                    VerifyDialog.this.mCloseReson = EventReport.CloseType.CLOSE_FB_FEEDBACK;
                }
                VerifyDialog.this.dismiss();
            }
        };
        this.mFeedbackBtn.setOnClickListener(onClickListener);
        this.mCloseBtn.setOnClickListener(onClickListener);
        this.mWebView.init(this.webViewListener);
        OnTouchReportListener onTouchReportListener = new OnTouchReportListener(this.request.getMMaxEvents());
        this.mOnTouchReportListener = onTouchReportListener;
        this.mWebView.setOnTouchListener(onTouchReportListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeDialog(int i, int i2, boolean z) {
        final int i3;
        final int i4;
        LogUtil.m160d(TAG, "changeDialog width = " + i + ", height = " + i2);
        if (this.isDismissing || !isShowing()) {
            return;
        }
        final boolean z2 = this.request.getFullscreen() || z;
        Context context = this.mWebView.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (z2 && activity != null) {
            Point availableScreenSize = UtilsKt.getAvailableScreenSize(activity);
            int i5 = availableScreenSize.x;
            i4 = availableScreenSize.y;
            i3 = i5;
        } else {
            float density = UtilsKt.getDensity(this.context);
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
            this.mWebView.post(new Runnable() { // from class: com.bytedance.bdturing.VerifyDialog.2
                @Override // java.lang.Runnable
                public void run() {
                    if (VerifyDialog.this.isDismissing) {
                        return;
                    }
                    VerifyDialog.this.stopLoading();
                    if (z2 && VerifyDialog.this.mWebContainer != null) {
                        VerifyDialog.this.mWebContainer.setRadius(0.0f);
                    }
                    layoutParams.width = i3;
                    layoutParams.height = i4;
                    VerifyDialog.this.mWebView.setLayoutParams(layoutParams);
                    VerifyDialog.this.mWebView.setVisibility(0);
                }
            });
        }
    }

    @Override // com.bytedance.bdturing.TuringVerifyInterface
    public synchronized void clearResource() {
        LogUtil.m162i(TAG, "clearResource()");
        if (this.context == null && this.mJsBridge == null) {
            return;
        }
        this.context = null;
        this.mJsBridge.clearJsBridgeResources();
        this.mJsBridge = null;
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

    private void notifyJsToClose(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("style", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callJsCode(JsCallParser.parseNativeCallJs(1, JsCallParser.GO_TO_CLOSE, JsCallParser.VALUE_CALL, jSONObject, JsCallParser.GO_TO_CLOSE));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.mMaskTime = System.currentTimeMillis();
    }

    @Override // android.app.Dialog, android.content.DialogInterface, com.bytedance.bdturing.TuringVerifyInterface
    public void dismiss() {
        if (this.mWebView != null) {
            getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.bdturing.VerifyDialog.3
                private WebView webView;

                {
                    this.webView = VerifyDialog.this.mWebView;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ViewParent parent;
                    LogUtil.m163w(VerifyDialog.TAG, "remove webview");
                    WebView webView = this.webView;
                    if (webView == null || (parent = webView.getParent()) == null || !(parent instanceof ViewGroup)) {
                        return;
                    }
                    ((ViewGroup) parent).removeView(this.webView);
                }
            });
            this.mWebView = null;
        }
        if (this.isDismissing) {
            return;
        }
        this.isDismissing = true;
        if (isShowing()) {
            try {
                super.dismiss();
            } catch (Exception unused) {
                LogUtil.m163w("BdTuring", "an exception caught in the stage of VerifyDialog dismissing.");
            }
        }
        if (this.request.getActivity() != null) {
            this.request.getActivity().unregisterComponentCallbacks(this.mOrientationListener);
        }
        OnDialogBackgroundListener onDialogBackgroundListener = this.mOnDialogBackgroundListener;
        if (onDialogBackgroundListener != null) {
            onDialogBackgroundListener.unregisterListener();
            this.mOnDialogBackgroundListener = null;
        }
        DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
        VerifyTaskHandler.getInstance().sendMessageDelay(1, this, 10000L);
        BdTuringCallback bdTuringCallback = this.mCallback;
        if (bdTuringCallback != null && !this.isPageLoadSuccess) {
            bdTuringCallback.onFail(3, null);
            this.mCallback = null;
        }
        if (!this.isColseByH5) {
            notifyJsToClose(this.mCloseReson.getName());
        }
        if (!this.isPageLoadSuccess) {
            EventReport.statisticCloseReason(this.mCloseReson, this.request);
            clearResource();
        }
        VerifyTaskHandler.getInstance().sendMessage(3, null);
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mOnTouchReportListener.onTouch(motionEvent);
        if (this.request.getMaskCancel()) {
            if (this.mFeedbackGroup.getVisibility() == 0) {
                this.mCloseReson = EventReport.CloseType.CLOSE_FB_MASK;
            } else {
                this.mCloseReson = EventReport.CloseType.CLOSE_REASON_MASK;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void setListeners() {
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bytedance.bdturing.VerifyDialog.4
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                int keyCode = keyEvent.getKeyCode();
                int action = keyEvent.getAction();
                if (keyCode != 4 || action != 1) {
                    return false;
                }
                if (VerifyDialog.this.mFeedbackGroup.getVisibility() != 0) {
                    if (VerifyDialog.this.mWebView != null && VerifyDialog.this.mWebView.canGoBack()) {
                        VerifyDialog.this.mWebView.goBack();
                        return true;
                    }
                    VerifyDialog.this.mCloseReson = EventReport.CloseType.CLOSE_REASON_BACK;
                    return false;
                }
                VerifyDialog.this.mCloseReson = EventReport.CloseType.CLOSE_FB_SYSTEM;
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeDialogV2(int i, int i2, boolean z) {
        final int i3;
        final int i4;
        LogUtil.m160d(TAG, "changeDialogV2 webContentWidth = " + i + ", webContentHeight = " + i2);
        if (this.isDismissing || !isShowing()) {
            return;
        }
        final boolean z2 = this.request.getFullscreen() || z;
        Context context = this.mWebView.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (!z2 || activity == null) {
            i3 = i;
            i4 = i2;
        } else {
            Point availableScreenSize = UtilsKt.getAvailableScreenSize(activity);
            int i5 = availableScreenSize.x;
            i4 = availableScreenSize.y;
            i3 = i5;
        }
        final ViewGroup.LayoutParams layoutParams = this.mWebView.getLayoutParams();
        if (this.mIsOrientationChange && layoutParams.width > 0 && layoutParams.height > 0) {
            this.mWebView.startOrientationChangeAnimation(i3, i4, layoutParams.width, layoutParams.height);
            this.mIsOrientationChange = false;
        } else {
            this.mWebView.post(new Runnable() { // from class: com.bytedance.bdturing.VerifyDialog.6
                @Override // java.lang.Runnable
                public void run() {
                    if (VerifyDialog.this.isDismissing || VerifyDialog.this.mWebView == null) {
                        return;
                    }
                    VerifyDialog.this.stopLoading();
                    if (VerifyDialog.this.mWebContainer != null && z2) {
                        VerifyDialog.this.mWebContainer.setRadius(0.0f);
                    }
                    layoutParams.width = i3;
                    layoutParams.height = i4;
                    VerifyDialog.this.mWebView.setLayoutParams(layoutParams);
                    VerifyDialog.this.mWebView.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFeedbackContent(int i) {
        return "Service error" + i + ", Please feed back to us";
    }

    public AbstractRequest getRequest() {
        return this.request;
    }

    @Override // com.bytedance.bdturing.TuringVerifyInterface
    public void cancelByConflict(int i) {
        BdTuringCallback bdTuringCallback = this.mCallback;
        if (bdTuringCallback != null) {
            bdTuringCallback.onFail(i, null);
            this.mCallback = null;
        }
        dismiss();
    }
}
