package com.bytedance.webx.core.webview;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.webx.ContainerConfig;
import com.bytedance.webx.WebX;
import com.bytedance.webx.WebXEnv;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class WebXWebView extends WebViewContainer {
    private static final String BACKUP_NAMESPACE = "WebXWebViewBackup";
    private static boolean sIsUseBackupNamespace;

    protected void onInit(ContainerConfig.Builder builder) {
    }

    private static Context tryInitWebX(Context context) {
        if (!WebViewExtendableSwitch.isEnable()) {
            return context;
        }
        if (WebXEnv.get("", WebviewManager.class) == null) {
            sIsUseBackupNamespace = true;
            if (WebXEnv.get(BACKUP_NAMESPACE, WebviewManager.class) == null) {
                WebXEnv.initGlobal(context.getApplicationContext());
                WebXEnv.initInstance(BACKUP_NAMESPACE, WebviewManager.class, new WebXEnv.InitBuilder() { // from class: com.bytedance.webx.core.webview.WebXWebView.1
                    @Override // com.bytedance.webx.WebXEnv.InitBuilder
                    protected void onInit(WebXEnv.Builder builder) {
                    }
                });
            }
        } else {
            sIsUseBackupNamespace = false;
        }
        return context;
    }

    public WebXWebView(Context context) {
        super(tryInitWebX(context));
        bindWebXExtensions(context);
    }

    public WebXWebView(Context context, AttributeSet attributeSet) {
        super(tryInitWebX(context), attributeSet);
        bindWebXExtensions(context);
    }

    public WebXWebView(Context context, AttributeSet attributeSet, int i) {
        super(tryInitWebX(context), attributeSet, i);
        bindWebXExtensions(context);
    }

    public WebXWebView(Context context, ContainerConfig.Builder builder) {
        super(tryInitWebX(context));
        bindWebXExtensions(context, builder);
    }

    private void bindWebXExtensions(Context context) {
        bindWebXExtensions(context, new ContainerConfig.Builder());
    }

    private void bindWebXExtensions(Context context, ContainerConfig.Builder builder) {
        if (WebViewExtendableSwitch.isEnable()) {
            onInit(builder);
            ((IWebviewManager) WebX.getContainerManager(sIsUseBackupNamespace ? BACKUP_NAMESPACE : "", WebviewManager.class)).createContainer(context, builder.assignContainer(this).build());
        }
    }
}
