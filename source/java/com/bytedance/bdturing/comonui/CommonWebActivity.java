package com.bytedance.bdturing.comonui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.bdturing.C0603R;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.TuringVerifyWebView;
import com.bytedance.bdturing.VerifyWebViewListener;
import com.bytedance.bdturing.methods.IVerifyInnerHandler;
import com.bytedance.bdturing.methods.JsBridgeModule;
import com.bytedance.bdturing.methods.VerifyDialogHandler;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CommonWebActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String KEY_TITLE = "title";
    private static final String KEY_URL = "url";
    public static final String RESULT_KEY = "web_result";
    public static final int WEB_RESULT_CODE = 1;
    private JsBridgeModule mJsBridgeModule;
    private String mTitle;
    private String mUrl;
    private View titleContainer;
    private TextView tvTitle;
    private TuringVerifyWebView webView;
    private String mWebResult = "";
    private final IVerifyInnerHandler mJsbHandler = new VerifyDialogHandler() { // from class: com.bytedance.bdturing.comonui.CommonWebActivity.2
        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void onH5Available() {
            super.onH5Available();
            if (CommonWebActivity.this.webView != null) {
                CommonWebActivity.this.webView.onH5Available();
            }
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void closeWeb() {
            CommonWebActivity.this.closePage();
        }

        @Override // com.bytedance.bdturing.methods.VerifyDialogHandler
        public void onWebResult(String str) {
            CommonWebActivity.this.mWebResult = str;
        }
    };

    /* renamed from: com_bytedance_bdturing_comonui_CommonWebActivity__onStop$___twin___ */
    public void m166xff940408() {
        super.onStop();
    }

    protected void onStop() {
        m165x193012f3(this);
    }

    public static void startActivityForResult(Activity activity, int i, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) CommonWebActivity.class);
        intent.putExtra("url", str2);
        intent.putExtra(KEY_TITLE, str);
        activity.startActivityForResult(intent, i);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0603R.layout.activity_turing_common_web);
        initData();
        EventReport.commonWebShow(this.mTitle, this.mUrl, null);
        initView();
    }

    private void initView() {
        View findViewById = findViewById(C0603R.id.rl_title_container);
        this.titleContainer = findViewById;
        findViewById.setVisibility(TextUtils.isEmpty(this.mTitle) ? 8 : 0);
        findViewById(C0603R.id.iv_back).setOnClickListener(this);
        TextView textView = (TextView) findViewById(C0603R.id.tv_title);
        this.tvTitle = textView;
        textView.setText(!TextUtils.isEmpty(this.mTitle) ? this.mTitle : "");
        this.webView = (TuringVerifyWebView) findViewById(C0603R.id.web);
        final long currentTimeMillis = System.currentTimeMillis();
        this.webView.init(new VerifyWebViewListener() { // from class: com.bytedance.bdturing.comonui.CommonWebActivity.1
            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onLoadPageSuccess() {
                EventReport.commonWebLoadSuccess(System.currentTimeMillis() - currentTimeMillis, null);
            }

            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onReceivedError(int i, String str, String str2) {
                EventReport.commonWebError(i, str, str2, null);
            }

            @Override // com.bytedance.bdturing.VerifyWebViewListener
            public void onLoadPageFail(int i, String str) {
                EventReport.commonWebLoadFail(i, str, null);
            }
        }, false, null);
        this.mJsBridgeModule = new JsBridgeModule(this.mJsbHandler, this.webView);
        this.webView.loadUrl(this.mUrl);
    }

    private void initData() {
        this.mTitle = getIntent().getStringExtra(KEY_TITLE);
        this.mUrl = getIntent().getStringExtra("url");
    }

    public void onBackPressed() {
        closePage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closePage() {
        Intent intent = new Intent();
        intent.putExtra(RESULT_KEY, this.mWebResult);
        setResult(1, intent);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        EventReport.commonWebClose(this.mWebResult, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C0603R.id.iv_back) {
            closePage();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_bdturing_comonui_CommonWebActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m165x193012f3(CommonWebActivity commonWebActivity) {
        commonWebActivity.m166xff940408();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) commonWebActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
