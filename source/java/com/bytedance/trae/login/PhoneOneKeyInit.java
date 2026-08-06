package com.bytedance.trae.login;

import android.util.Log;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.onekey.IOnekeyMonitor;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginServiceIniter;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: PhoneOneKeyInit.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/login/PhoneOneKeyInit;", "", "<init>", "()V", "TAG", "", "initialized", "", EventConstants.PARAM_SOURCE_INIT, "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PhoneOneKeyInit {
    public static final PhoneOneKeyInit INSTANCE = new PhoneOneKeyInit();
    private static final String TAG = "PhoneOneKeyInit";
    private static volatile boolean initialized;

    private PhoneOneKeyInit() {
    }

    public final void init() {
        if (initialized) {
            return;
        }
        synchronized (this) {
            if (initialized) {
                return;
            }
            try {
                AuthorizeFramework.init(AppHost.Companion.getApplication(), new OnekeyLoginServiceIniter[]{new OnekeyLoginServiceIniter(new OnekeyLoginConfig(new IOnekeyMonitor() { // from class: com.bytedance.trae.login.PhoneOneKeyInit$$ExternalSyntheticLambda0
                    public final void onEvent(String str, JSONObject jSONObject) {
                        PhoneOneKeyInit.init$lambda$1$lambda$0(str, jSONObject);
                    }
                }).getDefault(false))});
                initialized = true;
                Log.i(TAG, "OneKey login SDK initialized successfully");
            } catch (Exception e) {
                Log.e(TAG, "OneKey login SDK init failed: " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1$lambda$0(String str, JSONObject jSONObject) {
        Log.i(TAG, str + ' ' + jSONObject);
    }
}
