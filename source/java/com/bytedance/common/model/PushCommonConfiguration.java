package com.bytedance.common.model;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.common.push.interfaze.AbProvider;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.push.interfaze.IPushCommonEventSender;
import com.bytedance.push.interfaze.I18nCommonParams;
import com.bytedance.push.interfaze.ICommonParams;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;

/* loaded from: classes3.dex */
public class PushCommonConfiguration {
    public static final String DEFAULT_NOTIFICATION_ID = "push";
    public AbProvider mAbProvider;
    public int mAid;
    public String mAppName;
    public Application mApplication;
    public String mChannel;
    public ClientDisplayFeature mClientDisplayFeature;
    public boolean mEnableAlog;
    public boolean mEnableLazy;
    public boolean mEnableRealTimeReportEvent;
    public ICommonParams mExtraParams;
    public String mHost;
    public I18nCommonParams mI18nCommonParams;
    public IPushCommonEventSender mIPushCommonEventSender;
    public boolean mIsBoe;
    public boolean mIsLaunchFromIcon;
    public boolean mIsThroughMsgEncrypt;
    public String mProcess;
    public String mSelfAid;
    public int mUpdateVersionCode;
    public int mVersionCode;
    public String mVersionName;
    public boolean mIsDebugMode = false;
    public IPushCommonConfiguration mIPushCommonConfiguration = new IPushCommonConfiguration() { // from class: com.bytedance.common.model.PushCommonConfiguration.1
        @Override // com.bytedance.common.push.interfaze.IPushCommonConfiguration
        public boolean hasAgreedForPrivacyDialog() {
            return !TextUtils.isEmpty(ToolUtils.getDeviceId(AppProvider.getApp()));
        }
    };
}
