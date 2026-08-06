package com.bytedance.bdturing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BdTuringWebLiveActivity extends BdTuringVerifyActivity {
    private long mEnterTime;
    private boolean mWebLiveAvailable = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdturing.BdTuringVerifyActivity
    public void onStop() {
        m158xb4c28fa2(this);
    }

    public static void startActivity(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) BdTuringWebLiveActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdturing.BdTuringVerifyActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mEnterTime = System.currentTimeMillis();
        getWindow().setFlags(8192, 8192);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdturing.BdTuringVerifyActivity
    public void initView() {
        super.initView();
        this.loading.setImageResource(C0603R.drawable.bdturing_loading_black);
        this.mWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.bdturing.BdTuringWebLiveActivity.1
            @Override // android.webkit.WebChromeClient
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                boolean z = true;
                if (!BdTuringWebLiveActivity.this.mWebLiveAvailable) {
                    long currentTimeMillis = System.currentTimeMillis() - BdTuringWebLiveActivity.this.mEnterTime;
                    BdTuringWebLiveActivity.this.mWebLiveAvailable = true;
                    EventReport.webLiveAvailable(BdTuringWebLiveActivity.this.mRequest, currentTimeMillis);
                }
                String uri = permissionRequest.getOrigin().toString();
                String[] resources = permissionRequest.getResources();
                String str = (resources == null || resources.length != 1) ? "" : resources[0];
                if ("android.webkit.resource.VIDEO_CAPTURE".equals(str)) {
                    if (BdTuringWebLiveActivity.this.isUriInWhiteHost(permissionRequest.getOrigin())) {
                        BdTuringWebLiveActivity.this.changeScreenBrightness(1.0f);
                        permissionRequest.grant(permissionRequest.getResources());
                    } else {
                        super.onPermissionRequest(permissionRequest);
                        z = false;
                    }
                    EventReport.webLiveRequestPermission(uri, str, z, BdTuringWebLiveActivity.this.mRequest);
                    return;
                }
                permissionRequest.deny();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUriInWhiteHost(Uri uri) {
        String host = uri.getHost();
        String webLiveUrl = getWebLiveUrl();
        if (TextUtils.isEmpty(webLiveUrl) || TextUtils.isEmpty(host)) {
            return false;
        }
        return host.equals(Uri.parse(webLiveUrl).getHost());
    }

    private String getWebLiveUrl() {
        return this.mRequest != null ? this.mRequest.getCustomUrl() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeScreenBrightness(float f) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f;
        window.setAttributes(attributes);
    }

    @Override // com.bytedance.bdturing.BdTuringVerifyActivity
    protected boolean handleBackPress() {
        return this.mRequest == null || this.mRequest.cancelAble();
    }

    private void noticeVisibilityChange(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("visibility", z ? 0 : 1);
            callJsCode(JsCallParser.parseNativeCallJs(1, "bytedcert.visibility_change", JsCallParser.VALUE_CALL, jSONObject, "bytedcert.visibility_change"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com_bytedance_bdturing_BdTuringWebLiveActivity__onStop$___twin___ */
    public void m159x112019f9() {
        super.onStop();
        noticeVisibilityChange(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdturing.BdTuringVerifyActivity
    public void onResume() {
        super.onResume();
        noticeVisibilityChange(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_bdturing_BdTuringWebLiveActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m158xb4c28fa2(BdTuringWebLiveActivity bdTuringWebLiveActivity) {
        bdTuringWebLiveActivity.m159x112019f9();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) bdTuringWebLiveActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
