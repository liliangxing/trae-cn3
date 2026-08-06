package com.bytedance.push.profile;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.interfaze.IProfileIdService;
import com.bytedance.push.third.BasePushAdapter;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.pushmanager.setting.PushSetting;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ProfileIdServiceImpl implements IProfileIdService {
    private final Boolean mAllowProfileId;
    private final IPushCommonConfiguration mIPushCommonConfiguration;
    private final String TAG = "ProfileIdServiceImpl";
    private final Context mContext = AppProvider.getApp();

    public ProfileIdServiceImpl() {
        Boolean valueOf = Boolean.valueOf(PushSetting.getInstance().allowProfileId());
        this.mAllowProfileId = valueOf;
        PushCommonConfiguration pushCommonConfiguration = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        if (pushCommonConfiguration != null) {
            this.mIPushCommonConfiguration = pushCommonConfiguration.mIPushCommonConfiguration;
        } else {
            this.mIPushCommonConfiguration = null;
        }
        Logger.m268d("ProfileIdServiceImpl", "[ProfileIdServiceImpl]mAllowProfileId is " + valueOf + " mIPushCommonConfiguration is " + this.mIPushCommonConfiguration);
    }

    @Override // com.bytedance.push.interfaze.IProfileIdService
    public String onLogIn(IPushAdapter iPushAdapter) {
        Logger.m268d("ProfileIdServiceImpl", "onLogIn");
        return setProfileId(iPushAdapter);
    }

    @Override // com.bytedance.push.interfaze.IProfileIdService
    public void onLogOut(IPushAdapter iPushAdapter) {
        Logger.m268d("ProfileIdServiceImpl", "onLogOut");
        removeProfileId(iPushAdapter, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String setProfileId(IPushAdapter iPushAdapter) {
        IPushCommonConfiguration iPushCommonConfiguration;
        if (this.mAllowProfileId.booleanValue() && (iPushAdapter instanceof BasePushAdapter) && (iPushCommonConfiguration = this.mIPushCommonConfiguration) != null) {
            String profileId = iPushCommonConfiguration.getProfileId();
            if (!TextUtils.isEmpty(profileId)) {
                String lastProfileId = PushSetting.getInstance().getLastProfileId();
                if (!TextUtils.isEmpty(lastProfileId)) {
                    if (TextUtils.equals(lastProfileId, profileId)) {
                        Logger.m268d("ProfileIdServiceImpl", "needn't set profile id because lastProfileId==profileIdFromHost");
                        return lastProfileId;
                    }
                    Logger.m268d("ProfileIdServiceImpl", "remove last profile id because lastProfileId!=profileIdFromHost");
                    removeProfileId(iPushAdapter, false);
                }
                Logger.m268d("ProfileIdServiceImpl", "setProfileId for " + iPushAdapter);
                if (((BasePushAdapter) iPushAdapter).setProfileId(this.mContext, profileId)) {
                    PushSetting.getInstance().setLastProfileId(profileId);
                    return profileId;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void removeProfileId(IPushAdapter iPushAdapter, boolean z) {
        if (iPushAdapter instanceof BasePushAdapter) {
            if (this.mAllowProfileId.booleanValue() || z) {
                String lastProfileId = PushSetting.getInstance().getLastProfileId();
                if (TextUtils.isEmpty(lastProfileId)) {
                    return;
                }
                Logger.m268d("ProfileIdServiceImpl", "removeProfileId for " + iPushAdapter);
                if (((BasePushAdapter) iPushAdapter).deleteProfileId(this.mContext, lastProfileId)) {
                    PushSetting.getInstance().setLastProfileId("");
                }
            }
        }
    }

    @Override // com.bytedance.push.interfaze.IProfileIdService
    public String onAccountSwitch(IPushAdapter iPushAdapter) {
        Logger.m268d("ProfileIdServiceImpl", "onAccountSwitch");
        removeProfileId(iPushAdapter, false);
        return setProfileId(iPushAdapter);
    }

    @Override // com.bytedance.push.interfaze.IProfileIdService
    public void onPushAdapterRegister(IPushAdapter iPushAdapter) {
        Logger.m268d("ProfileIdServiceImpl", "onPushAdapterRegister");
        if (!this.mAllowProfileId.booleanValue()) {
            removeProfileId(iPushAdapter, true);
        } else {
            setProfileId(iPushAdapter);
        }
    }

    @Override // com.bytedance.push.interfaze.IProfileIdService
    public void onPushAdapterUnregister(IPushAdapter iPushAdapter) {
        Logger.m268d("ProfileIdServiceImpl", "onPushAdapterUnregister");
        removeProfileId(iPushAdapter, false);
    }
}
