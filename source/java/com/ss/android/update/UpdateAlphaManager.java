package com.ss.android.update;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import com.lynx.tasm.utils.LynxConstants;
import com.ss.android.common.util.NetworkUtils;
import com.ss.android.common.util.ToolUtils;
import com.vivo.push.PushClient;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateAlphaManager {
    private static final int DEFAULT_MAX_THREAD_NUM_IN_POOL = 3;
    private static final String KEY_BG_DOWNLOAD_CHECK = "show_alpha_dialog_bg_download_check";
    private static final String KEY_BG_DOWNLOAD_IGNORE_THIS_VERSION = "bg_dl_ignore_";
    private static final String KEY_SHOW_ALPHA_DIALOG_COUNT = "show_alpha_dialog_count_";
    public static final String NOT_IN_BYTEDANCE_NET = "not_in_bytedance_net";
    private static final String PING_URL = "http://app-alpha.bytedance.net/ping";
    private static final String RESULT_PONG = "pong";
    private static final String TAG = "UpdateAlphaManager";
    public String alphaDialogDesc;
    public String alphaDialogInstallText;
    private int alphaDialogMaxCount;
    public String alphaDialogOpenText;
    public String alphaDialogTitle;
    private ExecutorService exec;
    private boolean forceOpenAlphaEnable;
    private boolean isFormalAppUser;
    private boolean isLocalAppUser;
    private boolean isOpenUpdateFormalStrategy;
    private boolean isOpenUpdateLocalStrategy;
    private boolean isUpdateNormalEnabled;
    private String mAlphaPackageName;
    private IUpdateConfig mUpdateConfig;
    private UpdatePrefHelper mUpdatePrefHelper;
    private int mUpdateVersionCode;
    private List<String> mWifiList;
    Callable<String> pingInHouse;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Holder {
        static final UpdateAlphaManager INSTANCE = new UpdateAlphaManager();

        private Holder() {
        }
    }

    public static UpdateAlphaManager inst() {
        return Holder.INSTANCE;
    }

    private UpdateAlphaManager() {
        this.isUpdateNormalEnabled = true;
        this.pingInHouse = new Callable<String>() { // from class: com.ss.android.update.UpdateAlphaManager.1
            @Override // java.util.concurrent.Callable
            public String call() throws Exception {
                return NetworkUtils.executeGet(-1, UpdateAlphaManager.PING_URL);
            }
        };
        AppCommonContext appCommonContext = UpdateSDK.getAppCommonContext();
        this.mUpdatePrefHelper = UpdatePrefHelper.getInstance(appCommonContext.getContext().getApplicationContext());
        this.mUpdateVersionCode = appCommonContext.getUpdateVersionCode();
        IUpdateConfig config = UpdateSDK.getConfig();
        this.mUpdateConfig = config;
        if (config == null || config.getUpdateConfig() == null || this.mUpdateConfig.getUpdateConfig().getUpdateLocalStrategy() == null) {
            return;
        }
        UpdateLocalStrategy updateLocalStrategy = this.mUpdateConfig.getUpdateConfig().getUpdateLocalStrategy();
        this.isOpenUpdateLocalStrategy = updateLocalStrategy.updateLocalStrategyEnable;
        this.isOpenUpdateFormalStrategy = updateLocalStrategy.updateFormalStrategyEnable;
        this.isUpdateNormalEnabled = updateLocalStrategy.updateNormalEnable;
        this.isLocalAppUser = this.mUpdateConfig.getUpdateConfig().isLocalApp();
        this.isFormalAppUser = true ^ this.isFormalAppUser;
        this.mAlphaPackageName = this.mUpdateConfig.getUpdateConfig().getLocalAppPackageName();
        this.mWifiList = this.mUpdateConfig.getUpdateConfig().getUpdateLocalStrategy().wifiList;
        this.forceOpenAlphaEnable = this.mUpdateConfig.getUpdateConfig().getUpdateLocalStrategy().forceOpenAlphaEnable;
        this.alphaDialogMaxCount = this.mUpdateConfig.getUpdateConfig().getUpdateLocalStrategy().alphaDialogMaxCount;
        this.alphaDialogDesc = this.mUpdateConfig.getUpdateConfig().getUpdateLocalStrategy().alphaDialogDesc;
        this.alphaDialogTitle = this.mUpdateConfig.getUpdateConfig().getUpdateLocalStrategy().alphaDialogTitle;
        this.alphaDialogInstallText = this.mUpdateConfig.getUpdateConfig().getUpdateLocalStrategy().alphaDialogInstallText;
        this.alphaDialogOpenText = this.mUpdateConfig.getUpdateConfig().getUpdateLocalStrategy().alphaDialogOpenText;
        if (this.mUpdateConfig.getUpdateConfig().getExecutorService() != null) {
            this.exec = this.mUpdateConfig.getUpdateConfig().getExecutorService();
        } else {
            this.exec = Executors.newFixedThreadPool(3);
        }
    }

    public boolean localUpdateEnable() {
        if (isInBytedanceNet()) {
            return pingBytedanceNet();
        }
        return true;
    }

    private boolean pingBytedanceNet() {
        try {
            String str = (String) this.exec.submit(this.pingInHouse).get(1000L, TimeUnit.MILLISECONDS);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return TextUtils.equals(RESULT_PONG, new JSONObject(str).optString("message", ""));
        } catch (TimeoutException unused) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isInBytedanceNet() {
        Context context;
        AppCommonContext appCommonContext = UpdateSDK.getAppCommonContext();
        return appCommonContext != null && (context = appCommonContext.getContext()) != null && com.bytedance.common.utility.NetworkUtils.isNetworkAvailable(context) && this.isLocalAppUser && this.isOpenUpdateLocalStrategy;
    }

    public boolean isInstallAlphaApp() {
        Context context;
        AppCommonContext appCommonContext = UpdateSDK.getAppCommonContext();
        if (appCommonContext == null || (context = appCommonContext.getContext()) == null || TextUtils.isEmpty(this.mAlphaPackageName)) {
            return false;
        }
        return ToolUtils.isInstalledApp(context, this.mAlphaPackageName);
    }

    @Deprecated
    public boolean formalUpdateEnable() {
        if (isBuildDebug() || TextUtils.isEmpty(this.alphaDialogDesc) || TextUtils.isEmpty(this.alphaDialogInstallText) || TextUtils.isEmpty(this.alphaDialogOpenText) || TextUtils.isEmpty(this.alphaDialogTitle) || !isFormalInBytedanceNet()) {
            return false;
        }
        return pingBytedanceNet();
    }

    public boolean openAlphaAppEnable() {
        if (isInstallAlphaApp()) {
            return isNetworkInHouse();
        }
        return false;
    }

    public String getWifiListInfo() {
        Context context;
        AppCommonContext appCommonContext = UpdateSDK.getAppCommonContext();
        String str = LynxConstants.LYNX_DEFAULT_COMPONENT_ID;
        if (appCommonContext != null && (context = appCommonContext.getContext()) != null && com.bytedance.common.utility.NetworkUtils.isNetworkAvailable(context) && com.bytedance.common.utility.NetworkUtils.isWifi(context)) {
            String ssid = UpdateWifiUtils.getSSID(context);
            if (!TextUtils.isEmpty(ssid)) {
                if (ssid.startsWith("\"")) {
                    ssid = ssid.replace("\"", "");
                }
                str = "0";
            }
            List<String> list = this.mWifiList;
            if (list != null && list.contains(ssid)) {
                str = PushClient.DEFAULT_REQUEST_ID;
            }
        }
        UpdateEventUtils.reportWifiListState(Integer.parseInt(str));
        return str;
    }

    public boolean isNetworkAvailable() {
        AppCommonContext appCommonContext = UpdateSDK.getAppCommonContext();
        return (appCommonContext == null || appCommonContext.getContext() == null || !com.bytedance.common.utility.NetworkUtils.isNetworkAvailable(appCommonContext.getContext())) ? false : true;
    }

    public boolean isNetworkWifi() {
        AppCommonContext appCommonContext = UpdateSDK.getAppCommonContext();
        return (appCommonContext == null || appCommonContext.getContext() == null || !com.bytedance.common.utility.NetworkUtils.isWifi(appCommonContext.getContext())) ? false : true;
    }

    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public boolean isNetworkInHouse() {
        ?? r0;
        if (this.isLocalAppUser) {
            r0 = pingBytedanceNet();
        } else {
            r0 = getWifiListInfo().equals(PushClient.DEFAULT_REQUEST_ID) ? pingBytedanceNet() : 0;
        }
        UpdateEventUtils.reportInHouseNetState(r0);
        return r0;
    }

    private boolean isFormalInBytedanceNet() {
        Context context;
        AppCommonContext appCommonContext = UpdateSDK.getAppCommonContext();
        if (appCommonContext != null && (context = appCommonContext.getContext()) != null && com.bytedance.common.utility.NetworkUtils.isNetworkAvailable(context) && this.isFormalAppUser && this.isOpenUpdateFormalStrategy && currentAppOpenAlphaEnable() && this.mWifiList != null && com.bytedance.common.utility.NetworkUtils.isWifi(context)) {
            String ssid = UpdateWifiUtils.getSSID(context);
            if (!TextUtils.isEmpty(ssid) && ssid.startsWith("\"")) {
                ssid = ssid.replace("\"", "");
            }
            if (this.mWifiList.contains(ssid)) {
                return true;
            }
        }
        return false;
    }

    public boolean isForceOpenAlphaEnable() {
        return this.forceOpenAlphaEnable;
    }

    public boolean currentAppOpenAlphaEnable() {
        if (this.alphaDialogMaxCount <= 0) {
            return true;
        }
        int pref = this.mUpdatePrefHelper.getPref(KEY_SHOW_ALPHA_DIALOG_COUNT + this.mUpdateVersionCode, 0);
        return UpdateHelper.getInstance().isUpdating() ? pref <= this.alphaDialogMaxCount : pref < this.alphaDialogMaxCount;
    }

    public void markAlphaDialogShown() {
        if (this.alphaDialogMaxCount <= 0) {
            return;
        }
        this.mUpdatePrefHelper.setPref(KEY_SHOW_ALPHA_DIALOG_COUNT + this.mUpdateVersionCode, this.mUpdatePrefHelper.getPref(KEY_SHOW_ALPHA_DIALOG_COUNT + this.mUpdateVersionCode, 0) + 1);
    }

    private boolean isBuildDebug() {
        Context context;
        AppCommonContext appCommonContext = UpdateSDK.getAppCommonContext();
        return (appCommonContext == null || (context = appCommonContext.getContext()) == null || context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    public String getAlphaDialogTitle() {
        return this.alphaDialogTitle;
    }

    public String getAlphaDialogDesc() {
        return this.alphaDialogDesc;
    }

    public String getAlphaDialogInstallText() {
        return this.alphaDialogInstallText;
    }

    public String getAlphaDialogOpenText() {
        return this.alphaDialogOpenText;
    }

    public boolean isOpenUpdateFormalStrategy() {
        return this.isOpenUpdateFormalStrategy;
    }

    public boolean isUpdateNormalEnabled() {
        return this.isUpdateNormalEnabled;
    }

    public boolean alphaBgAutoDownloadEnable() {
        IUpdateConfig iUpdateConfig = this.mUpdateConfig;
        return iUpdateConfig != null && iUpdateConfig.getUpdateConfig() != null && this.mUpdateConfig.getUpdateConfig().canAlphaBgDownload() && this.mUpdateConfig.getUpdateConfig().isLocalApp();
    }

    public void setUserAgreeBgDownload(boolean z) {
        this.mUpdatePrefHelper.setPref(KEY_BG_DOWNLOAD_CHECK, z ? 1 : 2);
    }

    public int getUserAgreeBgDownloadRaw() {
        return this.mUpdatePrefHelper.getPref(KEY_BG_DOWNLOAD_CHECK, 0);
    }

    public boolean getUserAgreeBgDownload() {
        return this.mUpdatePrefHelper.getPref(KEY_BG_DOWNLOAD_CHECK, 0) == 1;
    }

    public boolean getUserRefuseBgDownload() {
        return this.mUpdatePrefHelper.getPref(KEY_BG_DOWNLOAD_CHECK, 0) == 2;
    }

    public void setBgDownloadIgnoreThisVersion(int i) {
        this.mUpdatePrefHelper.setPref(KEY_BG_DOWNLOAD_IGNORE_THIS_VERSION + i, true);
    }

    public boolean getBgDownloadIgnoreThisVersion(int i) {
        return this.mUpdatePrefHelper.getPref(KEY_BG_DOWNLOAD_IGNORE_THIS_VERSION + i, (Boolean) false);
    }

    public String getBgDownloadCheckboxText() {
        IUpdateConfig iUpdateConfig = this.mUpdateConfig;
        if (iUpdateConfig == null || iUpdateConfig.getUpdateConfig() == null || this.mUpdateConfig.getUpdateConfig().getUpdateLocalStrategy() == null) {
            return null;
        }
        return this.mUpdateConfig.getUpdateConfig().getUpdateLocalStrategy().updateDialogBgDownloadCheckboxText;
    }
}
