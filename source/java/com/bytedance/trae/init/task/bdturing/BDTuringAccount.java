package com.bytedance.trae.init.task.bdturing;

import android.app.Activity;
import com.bytedance.bdturing.AppInfoProvider;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventClient;
import com.bytedance.bdturing.IBdTuringDepend;
import com.bytedance.bdturing.loginverify.ILoginVerifyDepend;
import com.bytedance.bdturing.loginverify.LoginVerifyCallBack;
import com.bytedance.bdturing.uc_twiceverify.UCTwiceVerifyDepend;
import com.bytedance.bdturing.uc_twiceverify.UCTwiceVerifyResultCallback;
import com.bytedance.sdk.account.twiceverify.TwiceVerifyManager;
import com.bytedance.sdk.account.twiceverify.TwiceVerifyResultCallback;
import com.bytedance.sdk.account.utils.ActivityStack;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.utils.AppLocaleUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BDTuringAccount.kt */
@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003*\u0001\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;", "", "<init>", "()V", "init", "", "loginVerifyDepend", "Lcom/bytedance/bdturing/loginverify/ILoginVerifyDepend;", "ucTwiceVerifyDepend", "Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyDepend;", "appInfoProvider", "com/bytedance/trae/init/task/bdturing/BDTuringAccount$appInfoProvider$1", "Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$appInfoProvider$1;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BDTuringAccount {
    public static final BDTuringAccount INSTANCE = new BDTuringAccount();
    private static final ILoginVerifyDepend loginVerifyDepend = new ILoginVerifyDepend() { // from class: com.bytedance.trae.init.task.bdturing.BDTuringAccount$$ExternalSyntheticLambda0
        public final void startLogin(Activity activity, JSONObject jSONObject, LoginVerifyCallBack loginVerifyCallBack) {
            BDTuringAccount.loginVerifyDepend$lambda$3(activity, jSONObject, loginVerifyCallBack);
        }
    };
    private static final UCTwiceVerifyDepend ucTwiceVerifyDepend = new UCTwiceVerifyDepend() { // from class: com.bytedance.trae.init.task.bdturing.BDTuringAccount$$ExternalSyntheticLambda1
        public final boolean startTwiceVerify(JSONObject jSONObject, UCTwiceVerifyResultCallback uCTwiceVerifyResultCallback) {
            boolean ucTwiceVerifyDepend$lambda$4;
            ucTwiceVerifyDepend$lambda$4 = BDTuringAccount.ucTwiceVerifyDepend$lambda$4(jSONObject, uCTwiceVerifyResultCallback);
            return ucTwiceVerifyDepend$lambda$4;
        }
    };
    private static final BDTuringAccount$appInfoProvider$1 appInfoProvider = new AppInfoProvider() { // from class: com.bytedance.trae.init.task.bdturing.BDTuringAccount$appInfoProvider$1
        public String getDeviceId() {
            return IApplog.INSTANCE.getDeviceId();
        }

        public String getInstallId() {
            return IApplog.INSTANCE.getInstallId();
        }

        public String getOpenUDid() {
            return IApplog.INSTANCE.getOpenUDid();
        }
    };
    public static final int $stable = 8;

    private BDTuringAccount() {
    }

    public final void init() {
        BdTuring.getInstance().init(new BdTuringConfig.Builder().appId(String.valueOf(AppHost.INSTANCE.getAppId())).appVersionCode(AppHost.INSTANCE.getVersionName()).appName(AppHost.INSTANCE.getAppName()).language(AppLocaleUtils.INSTANCE.getAppLocale().getLanguage()).eventClient(new EventClient() { // from class: com.bytedance.trae.init.task.bdturing.BDTuringAccount$$ExternalSyntheticLambda2
            public final void onEvent(String str, JSONObject jSONObject) {
                BDTuringAccount.init$lambda$0(str, jSONObject);
            }
        }).appVersion(AppHost.INSTANCE.getVersionName()).channel(AppHost.INSTANCE.getBuildChannel()).twiceVerifyDepend(new DefaultTwiceVerifyDepend()).smsDigits(6).appInfoProvider(appInfoProvider).bdTuringDepend(new IBdTuringDepend() { // from class: com.bytedance.trae.init.task.bdturing.BDTuringAccount$$ExternalSyntheticLambda3
            public final Activity getActivity() {
                Activity init$lambda$1;
                init$lambda$1 = BDTuringAccount.init$lambda$1();
                return init$lambda$1;
            }
        }).ucTwiceVerifyDepend(ucTwiceVerifyDepend).loginVerifyDepend(loginVerifyDepend).build(AppHost.INSTANCE.getApplication()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(String str, JSONObject jSONObject) {
        IApplog.Companion companion = IApplog.INSTANCE;
        Intrinsics.checkNotNull(str);
        companion.reportEvent(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Activity init$lambda$1() {
        return ActivityStack.getTopActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loginVerifyDepend$lambda$3(Activity activity, JSONObject jSONObject, LoginVerifyCallBack loginVerifyCallBack) {
        Intrinsics.checkNotNullParameter(activity, "<unused var>");
        Intrinsics.checkNotNullParameter(jSONObject, "data");
        Intrinsics.checkNotNullParameter(loginVerifyCallBack, "callBack");
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
        if (xTToken == null) {
            xTToken = "";
        }
        if (xTToken.length() > 0) {
            loginVerifyCallBack.onSuccess(xTToken);
            return;
        }
        jSONObject.put("reason", "bdturing login fail");
        Unit unit = Unit.INSTANCE;
        loginVerifyCallBack.onFail(-1, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ucTwiceVerifyDepend$lambda$4(JSONObject jSONObject, final UCTwiceVerifyResultCallback uCTwiceVerifyResultCallback) {
        return TwiceVerifyManager.getInstance().startTwiceVerify(jSONObject, new TwiceVerifyResultCallback() { // from class: com.bytedance.trae.init.task.bdturing.BDTuringAccount$ucTwiceVerifyDepend$1$1
            @Override // com.bytedance.sdk.account.twiceverify.TwiceVerifyResultCallback
            public void onSuccess(String verifyWay, String verifyTicket, Map<String, String> bizParams, Map<String, Object> verifyExtraParams) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("verifyWay", verifyWay);
                jSONObject2.put("verifyTicket", verifyTicket);
                jSONObject2.put("bizParams", bizParams);
                jSONObject2.put("verifyExtraParams", verifyExtraParams);
                UCTwiceVerifyResultCallback uCTwiceVerifyResultCallback2 = uCTwiceVerifyResultCallback;
                if (uCTwiceVerifyResultCallback2 != null) {
                    uCTwiceVerifyResultCallback2.onResult(0, jSONObject2);
                }
            }

            @Override // com.bytedance.sdk.account.twiceverify.TwiceVerifyResultCallback
            public void onFail() {
                UCTwiceVerifyResultCallback uCTwiceVerifyResultCallback2 = uCTwiceVerifyResultCallback;
                if (uCTwiceVerifyResultCallback2 != null) {
                    uCTwiceVerifyResultCallback2.onResult(1, (JSONObject) null);
                }
            }
        });
    }
}
