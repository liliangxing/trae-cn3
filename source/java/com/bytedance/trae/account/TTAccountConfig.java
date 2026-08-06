package com.bytedance.trae.account;

import android.content.Context;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringCallback;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import com.bytedance.bdturing.verify.request.RiskInfoRequest;
import com.bytedance.sdk.account.INetWork;
import com.bytedance.sdk.account.utils.ActivityStack;
import com.bytedance.sdk.account.utils.IMonitor;
import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.AbsTTAccountConfig;
import com.ss.android.account.adapter.MonitorAdapter;
import com.ss.android.account.adapter.NetworkAdapter;
import com.ss.android.account.dbtring.AbsBdTuringImpl;
import com.ss.android.account.dbtring.IBdTruing;
import com.ss.android.account.sec.IAccountSec;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: TTAccountConfig.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/account/TTAccountConfig;", "Lcom/ss/android/AbsTTAccountConfig;", "<init>", "()V", "getMonitor", "Lcom/bytedance/sdk/account/utils/IMonitor;", "getNetwork", "Lcom/bytedance/sdk/account/INetWork;", PermissionConfigParser.WEBCAST_HOST_NAMESPACE, "", "getApplicationContext", "Landroid/content/Context;", "isSupportMultiLogin", "", "isSaveLoginInfo", "getIBdTruing", "Lcom/ss/android/account/dbtring/IBdTruing;", "getISec", "Lcom/ss/android/account/sec/IAccountSec;", "isLocalTest", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TTAccountConfig extends AbsTTAccountConfig {
    public static final int $stable = 0;
    private static final String TAG = "TTAccountConfig";

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getISec$lambda$0(Context context) {
        return true;
    }

    public boolean isLocalTest() {
        return false;
    }

    public boolean isSaveLoginInfo() {
        return true;
    }

    public boolean isSupportMultiLogin() {
        return true;
    }

    public IMonitor getMonitor() {
        return new MonitorAdapter();
    }

    public INetWork getNetwork() {
        return new NetworkAdapter();
    }

    public String host() {
        return HostResolver.INSTANCE.getHost(HostType.PASSPORT);
    }

    public Context getApplicationContext() {
        return AppHost.INSTANCE.getApplication();
    }

    public IBdTruing getIBdTruing() {
        return new AbsBdTuringImpl() { // from class: com.bytedance.trae.account.TTAccountConfig$getIBdTruing$1
            public boolean forceDisable() {
                return false;
            }

            public boolean init(Context context) {
                return true;
            }

            public void showVerifyDialog(int challengeCode, String decisionConf, final IBdTruing.IAccountBdTuringCallback callback) {
                BdTuring.getInstance().showVerifyDialog(ActivityStack.getTopActivity(), (AbstractRequest) (decisionConf != null ? new RiskInfoRequest(decisionConf) : null), new BdTuringCallback() { // from class: com.bytedance.trae.account.TTAccountConfig$getIBdTruing$1$showVerifyDialog$2
                    public void onFail(int result, JSONObject extras) {
                        FLogger.INSTANCE.d("TTAccountConfig", "BdTuring onFail: result=" + result + ", extras=" + extras);
                        IBdTruing.IAccountBdTuringCallback iAccountBdTuringCallback = callback;
                        if (iAccountBdTuringCallback != null) {
                            iAccountBdTuringCallback.onFail();
                        }
                    }

                    public void onSuccess(int result, JSONObject extras) {
                        FLogger.INSTANCE.d("TTAccountConfig", "BdTuring onSuccess: result=" + result + ", extras=" + extras);
                        IBdTruing.IAccountBdTuringCallback iAccountBdTuringCallback = callback;
                        if (iAccountBdTuringCallback != null) {
                            iAccountBdTuringCallback.onSuccess();
                        }
                    }
                });
            }
        };
    }

    public IAccountSec getISec() {
        return new IAccountSec() { // from class: com.bytedance.trae.account.TTAccountConfig$$ExternalSyntheticLambda0
            public final boolean init(Context context) {
                boolean iSec$lambda$0;
                iSec$lambda$0 = TTAccountConfig.getISec$lambda$0(context);
                return iSec$lambda$0;
            }
        };
    }
}
