package com.bytedance.bdturing.twiceverify;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.bdturing.C0603R;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.TuringVerifyWebView;
import com.bytedance.bdturing.VerifyWebViewListener;
import com.bytedance.bdturing.methods.JsBridgeModule;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.bdturing.methods.TwiceVerifyHandler;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.twiceverify.TwiceVerifyManager;
import com.bytedance.bdturing.utils.JsonUtils;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import com.bytedance.bdturing.verify.request.DownSmsRequest;
import com.bytedance.bdturing.verify.request.PasswordRequest;
import com.bytedance.bdturing.verify.request.UpSmsRequest;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TwiceVerifyWebActivityV2 extends AppCompatActivity {
    private static final String TAG = "TwiceVerifyWebActivityV2";
    private JsBridgeModule jsBridgeModule;
    private TwiceVerifyManager.VerifyCallBack mCallBack;
    private long mMaskTime;
    private AbstractRequest mRequest;
    private TuringVerifyWebView mWebView = null;
    private View mTobBgView = null;
    private EventReport.CloseType mCloseReson = EventReport.CloseType.CLOSE_REASON_APP;
    private boolean mReceiveError = false;
    private TwiceVerifyHandler mJsbHandler = new TwiceVerifyHandler(this) { // from class: com.bytedance.bdturing.twiceverify.TwiceVerifyWebActivityV2.1
        @Override // com.bytedance.bdturing.methods.TwiceVerifyHandler
        public void getSdkInfo(JsCallParser jsCallParser) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putValue(jSONObject, "maskTime", Long.valueOf(TwiceVerifyWebActivityV2.this.mMaskTime));
            jsCallParser.response(1, jSONObject);
        }

        @Override // com.bytedance.bdturing.methods.TwiceVerifyHandler
        public void onH5Available() {
            LogUtil.m162i(TwiceVerifyWebActivityV2.TAG, "===>onH5Available");
            if (TwiceVerifyWebActivityV2.this.mWebView != null) {
                TwiceVerifyWebActivityV2.this.mWebView.onH5Available();
            }
        }

        @Override // com.bytedance.bdturing.methods.TwiceVerifyHandler
        public void onClose(int i, String str) {
            if (TwiceVerifyWebActivityV2.this.mCallBack != null) {
                if (i == 0) {
                    TwiceVerifyWebActivityV2.this.mCallBack.onSuccess();
                } else {
                    TwiceVerifyWebActivityV2.this.mCallBack.onError(i, str);
                }
                TwiceVerifyWebActivityV2.this.mCallBack = null;
            }
            TwiceVerifyWebActivityV2.this.finish();
        }
    };
    private VerifyWebViewListener webViewListener = new VerifyWebViewListener() { // from class: com.bytedance.bdturing.twiceverify.TwiceVerifyWebActivityV2.2
        @Override // com.bytedance.bdturing.VerifyWebViewListener
        public void onLoadPageSuccess() {
            TwiceVerifyWebActivityV2.this.mReceiveError = false;
            TwiceVerifyWebActivityV2.this.showContentView();
        }

        @Override // com.bytedance.bdturing.VerifyWebViewListener
        public void onReceivedError(int i, String str, String str2) {
            TwiceVerifyWebActivityV2.this.mReceiveError = true;
        }

        @Override // com.bytedance.bdturing.VerifyWebViewListener
        public void onLoadPageFail(int i, String str) {
            Toast.makeText((Context) TwiceVerifyWebActivityV2.this, (CharSequence) ("ERROR:" + i + ";MSG:" + str), 1).show();
            if (TwiceVerifyManager.getInstance().getDepend() != null) {
                TwiceVerifyManager.getInstance().getDepend().dismissLoading();
            }
            TwiceVerifyWebActivityV2.this.mCloseReson = EventReport.CloseType.CLOSE_REASON_PAGE_LOAD_FAILED;
            TwiceVerifyWebActivityV2.this.finish();
        }
    };

    /* renamed from: com_bytedance_bdturing_twiceverify_TwiceVerifyWebActivityV2__onStop$___twin___ */
    public void m182x8434d05() {
        super.onStop();
    }

    protected void onStop() {
        m181x8c929416(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0603R.layout.bdturing_twice_verify_activity_web_v2);
        this.mCallBack = TwiceVerifyManager.getInstance().getVerifyCallBack();
        showLoading();
        this.mRequest = TwiceVerifyManager.getInstance().getRequest();
        this.mTobBgView = findViewById(C0603R.id.tob_bg_view);
        initWebView();
        EventReport.statisticDialogPop(this.mRequest);
        if (TwiceVerifyManager.getInstance().getConfig() != null) {
            Drawable wrap = DrawableCompat.wrap(getResources().getDrawable(C0603R.drawable.bdturing_twice_verify_top_radius_bg));
            DrawableCompat.setTint(wrap, TwiceVerifyManager.getInstance().getConfig().getBackgroundColor());
            this.mTobBgView.setBackgroundDrawable(wrap);
        }
        this.mMaskTime = System.currentTimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showLoading() {
        if (TwiceVerifyManager.getInstance().getDepend() != null) {
            TwiceVerifyManager.getInstance().getDepend().showLoading(this, "");
        }
    }

    void initWebView() {
        if (this.mWebView == null) {
            TuringVerifyWebView turingVerifyWebView = (TuringVerifyWebView) findViewById(C0603R.id.bdturing_webview);
            this.mWebView = turingVerifyWebView;
            turingVerifyWebView.init(this.webViewListener, this.mRequest);
        }
        hideContentView();
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.jsBridgeModule = new JsBridgeModule(this.mJsbHandler, this.mWebView);
        AbstractRequest abstractRequest = this.mRequest;
        this.mWebView.loadUrl(abstractRequest != null ? abstractRequest.getUrl() : "");
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mCallBack != null) {
            int i = C07653.$SwitchMap$com$bytedance$bdturing$EventReport$CloseType[this.mCloseReson.ordinal()];
            if (i == 1) {
                this.mCallBack.onError(2, "user close");
            } else if (i == 2) {
                this.mCallBack.onError(3, "web page load failed");
            } else if (i == 3) {
                this.mCallBack.onError(6, "closed by app");
            } else {
                this.mCallBack.onError(1, "closed by unknown reason");
            }
        }
        this.mWebView = null;
        this.mCallBack = null;
        TwiceVerifyManager.getInstance().onDestroy();
    }

    /* renamed from: com.bytedance.bdturing.twiceverify.TwiceVerifyWebActivityV2$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    static /* synthetic */ class C07653 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bdturing$EventReport$CloseType;

        static {
            int[] iArr = new int[EventReport.CloseType.values().length];
            $SwitchMap$com$bytedance$bdturing$EventReport$CloseType = iArr;
            try {
                iArr[EventReport.CloseType.CLOSE_REASON_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$bdturing$EventReport$CloseType[EventReport.CloseType.CLOSE_REASON_PAGE_LOAD_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$bdturing$EventReport$CloseType[EventReport.CloseType.CLOSE_REASON_APP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void onBackPressed() {
        if (this.mReceiveError || SettingsManager.INSTANCE.getVerifyCancellable()) {
            this.mCloseReson = EventReport.CloseType.CLOSE_REASON_BACK;
            super.onBackPressed();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View decorView = getWindow().getDecorView();
        setFinishOnTouchOutside(false);
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) decorView.getLayoutParams();
        layoutParams.gravity = 80;
        layoutParams.width = UIUtils.getScreenWidth(this);
        if (TwiceVerifyManager.getInstance().getConfig() != null && TwiceVerifyManager.getInstance().getConfig().getWindowHeight() > 0) {
            layoutParams.height = TwiceVerifyManager.getInstance().getConfig().getWindowHeight();
        } else {
            layoutParams.height = (int) UIUtils.dip2Px(this, 304.0f);
            AbstractRequest abstractRequest = this.mRequest;
            if (abstractRequest != null) {
                if (abstractRequest instanceof DownSmsRequest) {
                    layoutParams.height = (int) UIUtils.dip2Px(this, 290.0f);
                } else if (abstractRequest instanceof UpSmsRequest) {
                    layoutParams.height = (int) UIUtils.dip2Px(this, 304.0f);
                } else if (abstractRequest instanceof PasswordRequest) {
                    layoutParams.height = (int) UIUtils.dip2Px(this, 272.0f);
                }
            }
        }
        getWindowManager().updateViewLayout(decorView, layoutParams);
    }

    private void hideContentView() {
        TuringVerifyWebView turingVerifyWebView = this.mWebView;
        if (turingVerifyWebView != null) {
            turingVerifyWebView.setVisibility(4);
        }
        View view = this.mTobBgView;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showContentView() {
        TuringVerifyWebView turingVerifyWebView = this.mWebView;
        if (turingVerifyWebView != null) {
            turingVerifyWebView.setVisibility(0);
        }
        View view = this.mTobBgView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_bdturing_twiceverify_TwiceVerifyWebActivityV2_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m181x8c929416(TwiceVerifyWebActivityV2 twiceVerifyWebActivityV2) {
        twiceVerifyWebActivityV2.m182x8434d05();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) twiceVerifyWebActivityV2).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
