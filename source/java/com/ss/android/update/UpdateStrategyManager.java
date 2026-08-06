package com.ss.android.update;

import com.bytedance.services.app.common.context.api.AppCommonContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateStrategyManager {
    private static final String KEY_CLICK_UPDATE_CANCEL = "click_update_cancel";
    private static final String KEY_CURRENT_STRATEGY = "current_Strategy";
    private static final String KEY_SHOW_UPDATE_DIALOG_VERSION = "show_update_dialog_version";
    private static final String KEY_VERSION_CODE = "version_code";
    private static final int STRATEGY_1 = 1;
    private static final int STRATEGY_2 = 2;
    private int currentVersionCode;
    private int intervalVersion;
    private boolean updateNewStrategyEnable;
    private UpdatePrefHelper updatePrefHelper;

    private UpdateStrategyManager() {
        this.currentVersionCode = -1;
        this.intervalVersion = 2;
        AppCommonContext appCommonContext = UpdateSDK.getAppCommonContext();
        this.updatePrefHelper = UpdatePrefHelper.getInstance(appCommonContext.getContext().getApplicationContext());
        this.currentVersionCode = appCommonContext.getVersionCode();
        IUpdateConfig config = UpdateSDK.getConfig();
        if (config == null || config.getUpdateConfig() == null || config.getUpdateConfig().getUpdateStrategyInfo() == null) {
            return;
        }
        this.updateNewStrategyEnable = config.getUpdateConfig().getUpdateStrategyInfo().updateNewStrategyEnable;
        this.intervalVersion = config.getUpdateConfig().getUpdateStrategyInfo().intervalVersion;
    }

    public static UpdateStrategyManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SingletonHolder {
        private static final UpdateStrategyManager INSTANCE = new UpdateStrategyManager();

        private SingletonHolder() {
        }
    }

    public void applyUpdateBySelf() {
        if (this.updateNewStrategyEnable) {
            int localUpdateStrategy = getLocalUpdateStrategy();
            boolean isUpdateCancel = isUpdateCancel();
            if (localUpdateStrategy == 2) {
                applyUpdateStrategy(1);
            }
            if (isUpdateCancel) {
                this.updatePrefHelper.setPref(KEY_CLICK_UPDATE_CANCEL, false);
            }
        }
    }

    public void applyUpdateCancel() {
        if (this.updateNewStrategyEnable) {
            int localVersionCode = getLocalVersionCode();
            boolean isUpdateCancel = isUpdateCancel();
            if (localVersionCode == this.currentVersionCode) {
                if (isUpdateCancel) {
                    return;
                }
                this.updatePrefHelper.setPref(KEY_CLICK_UPDATE_CANCEL, true);
            } else {
                if (isUpdateCancel) {
                    applyUpdateStrategy(2);
                } else {
                    this.updatePrefHelper.setPref(KEY_CLICK_UPDATE_CANCEL, true);
                }
                applyVersionCode();
            }
        }
    }

    private void applyVersionCode() {
        this.updatePrefHelper.setPref("version_code", this.currentVersionCode);
    }

    private void applyShownUpdateVersionCode() {
        this.updatePrefHelper.setPref(KEY_SHOW_UPDATE_DIALOG_VERSION, this.currentVersionCode);
    }

    private void applyUpdateStrategy(int i) {
        this.updatePrefHelper.setPref(KEY_CURRENT_STRATEGY, i);
    }

    public boolean isShowUpdateDialog() {
        if (this.updateNewStrategyEnable) {
            int localUpdateStrategy = getLocalUpdateStrategy();
            if (this.currentVersionCode == getLocalShownVersionCode()) {
                UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_NEW_STRATEGY_VERSION_IS_SAME);
                return false;
            }
            if (localUpdateStrategy == 1) {
                applyShownUpdateVersionCode();
                return true;
            }
            int localVersionCode = getLocalVersionCode();
            if (this.currentVersionCode - localVersionCode >= this.intervalVersion) {
                applyShownUpdateVersionCode();
                return true;
            }
            UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_NEW_STRATEGY_INTERVAL_VERSION + (this.currentVersionCode - localVersionCode));
            return false;
        }
        UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_NEW_STRATEGY_NOT_ENABLE);
        return false;
    }

    private int getLocalVersionCode() {
        return this.updatePrefHelper.getPref("version_code", 0);
    }

    private int getLocalShownVersionCode() {
        return this.updatePrefHelper.getPref(KEY_SHOW_UPDATE_DIALOG_VERSION, 0);
    }

    private int getLocalUpdateStrategy() {
        return this.updatePrefHelper.getPref(KEY_CURRENT_STRATEGY, 1);
    }

    private boolean isUpdateCancel() {
        return this.updatePrefHelper.getPref(KEY_CLICK_UPDATE_CANCEL, (Boolean) false);
    }

    public boolean isUpdateNewStrategyEnable() {
        return this.updateNewStrategyEnable;
    }
}
