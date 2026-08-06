package com.bytedance.common.support.impl;

import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.support.service.ISecurityService;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.log.PushLog;
import com.ss.android.message.util.ToolUtils;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SecurityService extends BaseJson implements ISecurityService, IBinder.DeathRecipient {
    private final String TAG = "SecurityService";
    private String mCurProcess;
    private boolean mNeedKillAllIfMainProcessDied;
    private List<String> mNotAllowAliveProcessList;

    @Override // com.bytedance.common.support.service.ISecurityService
    public void onHoldMainProcessBinder(IBinder iBinder) {
        Logger.d("SecurityService", "on hold main process binder");
        try {
            if (this.mNotAllowAliveProcessList == null) {
                PushOnlineSettings pushOnlineSettings = (PushOnlineSettings) SettingsManager.obtain(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication, PushOnlineSettings.class);
                String notAllowAliveWhenNoMainProcessList = pushOnlineSettings.getNotAllowAliveWhenNoMainProcessList();
                if (TextUtils.isEmpty(notAllowAliveWhenNoMainProcessList)) {
                    return;
                }
                this.mNotAllowAliveProcessList = Arrays.asList(notAllowAliveWhenNoMainProcessList.split(","));
                this.mNeedKillAllIfMainProcessDied = pushOnlineSettings.needKillAllIfMainProcessDied();
            }
            if (this.mCurProcess == null) {
                this.mCurProcess = ToolUtils.getCurProcessNameSuffix(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication);
            }
            if (this.mNotAllowAliveProcessList.contains(this.mCurProcess)) {
                Logger.d("SecurityService", this.mCurProcess + " is in notAllowAliveProcessList, monitor main process died");
                iBinder.linkToDeath(this, 0);
            } else {
                Logger.d("SecurityService", this.mCurProcess + " is not in notAllowAliveProcessList, not monitor main process died");
            }
        } catch (RemoteException e) {
            Logger.e("SecurityService", "linkToDeath RemoteException ", e);
            binderDied();
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        String str;
        Logger.d("SecurityService", "on  main process died");
        List<String> list = this.mNotAllowAliveProcessList;
        if (list != null && (str = this.mCurProcess) != null) {
            if (list.contains(str)) {
                JSONObject jSONObject = new JSONObject();
                add(jSONObject, "cur_process", this.mCurProcess);
                if (this.mNeedKillAllIfMainProcessDied) {
                    Logger.d("SecurityService", "mNeedKillAllIfMainProcessDied is true, kill all");
                    add(jSONObject, "kill_all", true);
                    PushLog.onEventV3(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication, "bdpush_self_kill", jSONObject);
                    ToolUtils.killAll(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication);
                    return;
                }
                Logger.d("SecurityService", this.mCurProcess + " is in notAllowAliveProcessList, kill self");
                PushLog.onEventV3(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication, "bdpush_self_kill", jSONObject);
                ToolUtils.killSelf();
                return;
            }
            Logger.d("SecurityService", this.mCurProcess + " is not in notAllowAliveProcessList, do nothing");
            return;
        }
        Logger.e("SecurityService", " mNotAllowAliveProcessList or mCurProcess is null, mCurProcess is " + this.mCurProcess);
    }
}
