package com.bytedance.push.frontier.wschannel;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.wschannel.ChannelInfo;
import com.bytedance.common.wschannel.WsChannel;
import com.bytedance.common.wschannel.WsChannelSdk2;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.push.Configuration;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.frontier.FrontierSupporter;
import com.bytedance.push.frontier.interfaze.IFrontierService;
import com.bytedance.push.frontier.interfaze.ISettingService;
import com.bytedance.push.frontier.interfaze.OnFrontierSettingUpdateListener;
import com.bytedance.push.frontier.setting.FrontierSetting;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.ss.android.pushmanager.setting.PushSetting;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WsChannelManager implements IFrontierService {
    public static final int CHANNEL_ID = 10006;
    private static volatile WsChannelManager wsChannelManager;
    private Context mContext;
    private FrontierSetting mFrontierSetting;
    private String mSessionId;
    private WsChannel mWsChannel;

    private WsChannelManager(Context context, String str) {
        this.mContext = context;
        this.mSessionId = str;
    }

    public static WsChannelManager getIns(Context context, String str) {
        if (wsChannelManager == null) {
            synchronized (WsChannelManager.class) {
                if (wsChannelManager == null) {
                    wsChannelManager = new WsChannelManager(context, str);
                }
            }
        }
        return wsChannelManager;
    }

    @Override // com.bytedance.push.frontier.interfaze.IFrontierService
    public synchronized void registerFrontierPush(final OnMessageReceiveListener onMessageReceiveListener) {
        FrontierSetting frontierSetting = this.mFrontierSetting;
        if (frontierSetting != null) {
            registerWsChannelInternal(frontierSetting, onMessageReceiveListener);
        } else {
            ISettingService settingService = FrontierSupporter.get().getSettingService();
            if (settingService == null) {
            } else {
                settingService.getFrontierSetting(this.mContext, new OnFrontierSettingUpdateListener() { // from class: com.bytedance.push.frontier.wschannel.WsChannelManager.1
                    @Override // com.bytedance.push.frontier.interfaze.OnFrontierSettingUpdateListener
                    public void onFrontierSettingUpdate(FrontierSetting frontierSetting2) {
                        WsChannelManager.this.registerWsChannelInternal(frontierSetting2, onMessageReceiveListener);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.push.frontier.interfaze.IFrontierService
    public void unRegisterFrontierPush() {
        WsChannel wsChannel = this.mWsChannel;
        if (wsChannel != null) {
            wsChannel.unregister();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerWsChannelInternal(FrontierSetting frontierSetting, OnMessageReceiveListener onMessageReceiveListener) {
        ChannelInfo buildChannelInfo = buildChannelInfo(frontierSetting);
        if (buildChannelInfo == null) {
            return;
        }
        WsChannel wsChannel = this.mWsChannel;
        if (wsChannel != null) {
            wsChannel.onParamChanged(buildChannelInfo);
        } else {
            this.mWsChannel = WsChannelSdk2.registerChannel(this.mContext, buildChannelInfo, onMessageReceiveListener);
        }
    }

    public void onSessionIdUpdated(String str) {
        ChannelInfo buildChannelInfo;
        if (TextUtils.equals(this.mSessionId, str)) {
            return;
        }
        this.mSessionId = str;
        if (this.mWsChannel == null || (buildChannelInfo = buildChannelInfo(this.mFrontierSetting)) == null) {
            return;
        }
        this.mWsChannel.onParamChanged(buildChannelInfo);
    }

    private ChannelInfo buildChannelInfo(FrontierSetting frontierSetting) {
        if (frontierSetting != null && frontierSetting.isValid()) {
            this.mFrontierSetting = frontierSetting;
            HashMap hashMap = new HashMap();
            PushSetting.getInstance().getSSIDs(hashMap);
            String str = (String) hashMap.get("install_id");
            String str2 = (String) hashMap.get(CommonConstants.KEY_DID);
            Configuration configuration = PushSupporter.get().getConfiguration();
            if (configuration == null) {
                return null;
            }
            try {
                return ChannelInfo.Builder.create(10006).setAid(frontierSetting.aid).setDeviceId(str2).setInstallId(str).setFPID(frontierSetting.pid).setAppKey(frontierSetting.appKey).setAppVersion(30919).urls(frontierSetting.urls).extra("host_aid", String.valueOf(configuration.mAid)).extra("host_version", String.valueOf(configuration.mVersionCode)).extra("sid", this.mSessionId).builder();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
