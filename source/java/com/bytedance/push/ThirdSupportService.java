package com.bytedance.push;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.push.interfaze.IPushMsgHandler;
import com.bytedance.push.interfaze.ISenderService;
import com.bytedance.push.interfaze.IThirdSupportService;
import com.bytedance.push.settings.AliveOnlineSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.task.SendTokenTask;
import com.bytedance.push.third.ISendTokenCallBack;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.utils.JobHandlerHelper;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.MessageUtils;
import com.bytedance.push.utils.OpenUrlUtils;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.push.Triple;
import com.ss.android.pushmanager.setting.PushSetting;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ThirdSupportService implements IThirdSupportService {
    private final Configuration mConfiguration;
    private final IPushMsgHandler mPushHandler;
    private final ISenderService mSenderService;

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public void sendMonitor(Context context, String str, JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThirdSupportService(ISenderService iSenderService, IPushMsgHandler iPushMsgHandler, Configuration configuration) {
        this.mSenderService = iSenderService;
        this.mPushHandler = iPushMsgHandler;
        this.mConfiguration = configuration;
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public boolean canKeepPackageAlive(Context context, String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(context.getPackageName(), str)) {
            return true;
        }
        List<String> allowList = ((AliveOnlineSettings) SettingsManager.obtain(context, AliveOnlineSettings.class)).getAllowList();
        return allowList != null && allowList.contains(str);
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public JSONObject getMessage(byte[] bArr, boolean z) throws DataFormatException, IOException {
        return MessageUtils.getMessage(bArr, z);
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public String getMessageV2(int i, byte[] bArr, boolean z) throws DataFormatException, IOException {
        return MessageUtils.getMessageV2(i, bArr, z);
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public Pair<String, String> getPushConfig(int i) {
        Logger.m274i("ThirdSupportService", "[getPushConfig]pushType:" + i + " mConfiguration:" + this.mConfiguration);
        return PushChannelHelper.inst(AppProvider.getApp()).getPushConfig(i, this.mConfiguration);
    }

    public void setAlias(Context context, int i) {
        String alias = PushSetting.getInstance().getAlias();
        if (TextUtils.isEmpty(alias)) {
            alias = PushSetting.getInstance().getDeviceId();
        }
        if (TextUtils.isEmpty(alias)) {
            return;
        }
        this.mSenderService.setAlias(context.getApplicationContext(), alias, i);
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public void sendToken(Context context, ISendTokenCallBack iSendTokenCallBack) {
        SendTokenTask.doSendToken(context, iSendTokenCallBack);
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public String getToken(Context context, int i) {
        return SendTokenTask.getToken(context, i);
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public void hackJobHandler(Service service) {
        JobHandlerHelper.tryHackJobHandler(service);
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public void onClickNotPassThroughNotification(Context context, String str, int i, String str2) {
        this.mPushHandler.onClickMsg(context, str, i, OpenUrlUtils.getOpenUrl(str));
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public void registerSenderSuccessAndUploadToken(Context context, final int i, final String str) {
        if (ToolUtils.isMainProcess(context) || ToolUtils.isSmpProcess(context)) {
            PushSupporter.thirdService().sendToken(context, new ISendTokenCallBack() { // from class: com.bytedance.push.ThirdSupportService.1
                @Override // com.bytedance.push.third.ISendTokenCallBack
                public String getToken(Context context2) {
                    return str;
                }

                @Override // com.bytedance.push.third.ISendTokenCallBack
                public int getType() {
                    return i;
                }
            });
        }
        if (this.mConfiguration.getRegisterResultCallback() != null) {
            this.mConfiguration.getRegisterResultCallback().onResult(true, i);
        }
        if (((PushOnlineSettings) SettingsManager.obtain(AppProvider.getApp(), PushOnlineSettings.class)).forbidSetAlias() > 0) {
            Logger.m267d("forbid set alias. pushType = " + i + ", token = " + str);
        } else {
            setAlias(AppProvider.getApp(), i);
        }
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public void registerSenderFailed(int i, String str, String str2) {
        if (this.mConfiguration.getRegisterResultCallback() != null) {
            this.mConfiguration.getRegisterResultCallback().onResult(false, i);
        }
        PushSupporter.logger().mo246e("registerSenderFailed: pushType=" + i + " ,errorId=" + str + " ,msg=" + str2);
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public boolean isMainProcess(Context context) {
        return ToolUtils.isMainProcess(context);
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public Triple<String, String, String> getUmConfig() {
        return this.mConfiguration.mKeyConfiguration.getUmPushConfig();
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public boolean shouldShowUpgradeDialog(Activity activity) {
        if (this.mConfiguration.mHMSCallback != null) {
            return this.mConfiguration.mHMSCallback.shouldShowUpgradeDialog(activity);
        }
        return false;
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public String getFcmPayloadName() {
        Configuration configuration = this.mConfiguration;
        return (configuration == null || TextUtils.isEmpty(configuration.mFcmPayloadName)) ? "payload" : this.mConfiguration.mFcmPayloadName;
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public boolean allowPullUp(String str) {
        PushSupporter.logger().mo245d("AgooFactory", "Um try pull up:" + str);
        return TextUtils.equals(this.mConfiguration.mApplication.getPackageName(), str);
    }

    @Override // com.bytedance.push.interfaze.IThirdSupportService
    public String getAdmPayloadName() {
        Configuration configuration = this.mConfiguration;
        return (configuration == null || TextUtils.isEmpty(configuration.mAdmPayloadName)) ? "payload" : this.mConfiguration.mAdmPayloadName;
    }
}
