package com.bytedance.bdturing;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.bytedance.bdturing.OnTouchSmarterListener;
import com.bytedance.bdturing.methods.IVerifyInnerHandler;
import com.bytedance.bdturing.methods.JsBridgeModule;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.bdturing.methods.VerifyDialogHandler;
import com.bytedance.bdturing.setting.SettingUpdateRequest;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.utils.UtilsKt;
import com.bytedance.bdturing.verify.request.RiskInfoRequest;
import com.bytedance.bdturing.verify.request.SmarterVerifyRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SmarterVerifyButton extends VerifyWebView {
    public static final String TAG = "SmarterVerifyButton";
    private BdTuringCallback mCallback;
    private boolean mIsVerifySuccess;
    private JsBridgeModule mJsBridge;
    private long mLoadSuccessTime;
    private OnTouchSmarterListener mSmarterListener;
    private IVerifyInnerHandler mVerifyHandler;
    private VerifyWebViewListener webViewListener;

    public SmarterVerifyButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSmarterListener = new OnTouchSmarterListener();
        this.mVerifyHandler = new VerifyDialogHandler() { // from class: com.bytedance.bdturing.SmarterVerifyButton.1
            @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
            public void onVerifyResult(int i, String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
                if (SmarterVerifyButton.this.mCallback != null) {
                    if (i == 0) {
                        SmarterVerifyButton.this.mIsVerifySuccess = true;
                        SmarterVerifyButton.this.mCallback.onSuccess(i, null);
                    } else {
                        SmarterVerifyButton.this.mCallback.onFail(i, null);
                    }
                }
            }

            @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
            public void getSettings(JsCallParser jsCallParser) {
                jsCallParser.response(1, BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getTheme(5) : null);
            }

            @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
            public void onVerify(String str, BdTuringCallback bdTuringCallback) {
                BdTuring bdTuring = BdTuring.getInstance();
                Activity findActivity = UtilsKt.findActivity(SmarterVerifyButton.this.getContext());
                RiskInfoRequest riskInfoRequest = new RiskInfoRequest(str);
                riskInfoRequest.setLoading(false);
                bdTuring.showVerifyDialog(findActivity, riskInfoRequest, bdTuringCallback);
            }
        };
        this.webViewListener = new VerifyWebViewListener() { // from class: com.bytedance.bdturing.SmarterVerifyButton.2
            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onLoadPageFail(int i, String str) {
            }

            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onReceivedError(int i, String str, String str2) {
            }

            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onLoadPageSuccess() {
                SmarterVerifyButton.this.mLoadSuccessTime = System.currentTimeMillis();
                SmarterVerifyButton.this.mIsPageFinished = true;
            }
        };
    }

    public SmarterVerifyButton(Context context) {
        super(context);
        this.mSmarterListener = new OnTouchSmarterListener();
        this.mVerifyHandler = new VerifyDialogHandler() { // from class: com.bytedance.bdturing.SmarterVerifyButton.1
            @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
            public void onVerifyResult(int i, String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
                if (SmarterVerifyButton.this.mCallback != null) {
                    if (i == 0) {
                        SmarterVerifyButton.this.mIsVerifySuccess = true;
                        SmarterVerifyButton.this.mCallback.onSuccess(i, null);
                    } else {
                        SmarterVerifyButton.this.mCallback.onFail(i, null);
                    }
                }
            }

            @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
            public void getSettings(JsCallParser jsCallParser) {
                jsCallParser.response(1, BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getTheme(5) : null);
            }

            @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
            public void onVerify(String str, BdTuringCallback bdTuringCallback) {
                BdTuring bdTuring = BdTuring.getInstance();
                Activity findActivity = UtilsKt.findActivity(SmarterVerifyButton.this.getContext());
                RiskInfoRequest riskInfoRequest = new RiskInfoRequest(str);
                riskInfoRequest.setLoading(false);
                bdTuring.showVerifyDialog(findActivity, riskInfoRequest, bdTuringCallback);
            }
        };
        this.webViewListener = new VerifyWebViewListener() { // from class: com.bytedance.bdturing.SmarterVerifyButton.2
            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onLoadPageFail(int i, String str) {
            }

            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onReceivedError(int i, String str, String str2) {
            }

            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onLoadPageSuccess() {
                SmarterVerifyButton.this.mLoadSuccessTime = System.currentTimeMillis();
                SmarterVerifyButton.this.mIsPageFinished = true;
            }
        };
    }

    public void init() {
        this.mJsBridge = new JsBridgeModule(this.mVerifyHandler, this);
        this.mIsPageFinished = false;
        this.mIsVerifySuccess = false;
        SettingsManager.INSTANCE.requestSettings(true, new SettingUpdateRequest.Callback() { // from class: com.bytedance.bdturing.SmarterVerifyButton.3
            @Override // com.bytedance.bdturing.setting.SettingUpdateRequest.Callback
            public void onResponse(int i, String str, long j) {
                UtilsKt.findActivity(SmarterVerifyButton.this.getContext()).runOnUiThread(new Runnable() { // from class: com.bytedance.bdturing.SmarterVerifyButton.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SmarterVerifyButton.super.init(SmarterVerifyButton.this.webViewListener);
                        SmarterVerifyButton.this.loadUrl(new SmarterVerifyRequest(SettingsManager.SMARTER_BUTTON_SERVICE, null).getUrl());
                    }
                });
            }
        });
    }

    @Override // com.bytedance.bdturing.VerifyWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!BdTuring.getInstance().isInitDone() || !this.mIsPageFinished || this.mIsVerifySuccess) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mSmarterListener.onActionDownEvent();
        } else if (action == 1) {
            this.mSmarterListener.onActionUpEvent(motionEvent, new OnTouchSmarterListener.SmarterCallback() { // from class: com.bytedance.bdturing.SmarterVerifyButton.4
                @Override // com.bytedance.bdturing.OnTouchSmarterListener.SmarterCallback
                public void execute(JSONObject jSONObject) {
                    try {
                        jSONObject.put("operate_duration", SmarterVerifyButton.this.mSmarterListener.getActionDownTime() - SmarterVerifyButton.this.mLoadSuccessTime);
                        JSONArray jSONArray = jSONObject.getJSONArray("click_coordinate");
                        jSONArray.put(SmarterVerifyButton.this.getWidth());
                        jSONArray.put(SmarterVerifyButton.this.getHeight());
                        Log.i(SmarterVerifyButton.TAG, "data = " + jSONObject);
                        SmarterVerifyButton.this.callJsCode(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callJsCode(JSONObject jSONObject) {
        this.mJsBridge.callJsCode(JsCallParser.parseNativeCallJs(1, JsCallParser.VERIFY_DATA, JsCallParser.VALUE_CALL, jSONObject, JsCallParser.VERIFY_DATA));
    }

    public void setCallback(BdTuringCallback bdTuringCallback) {
        this.mCallback = bdTuringCallback;
    }
}
