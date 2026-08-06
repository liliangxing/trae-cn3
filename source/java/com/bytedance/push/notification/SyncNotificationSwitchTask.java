package com.bytedance.push.notification;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.support.impl.PushNetworkClient;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.interfaze.ISupport;
import com.bytedance.push.interfaze.OnSwitcherSyncListener;
import com.bytedance.push.model.SwitcherStatus;
import com.bytedance.push.settings.LocalFrequencySettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.MessageConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SyncNotificationSwitchTask extends BaseJson implements Runnable {
    private final Context mContext;
    private final boolean mInnerEnable;
    private final OnSwitcherSyncListener mListener;
    private String mReportingTiming;
    private final ISupport mSupport;
    private final SwitcherStatus mSwitcherStatus;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SyncNotificationSwitchTask(Context context, ISupport iSupport, boolean z, SwitcherStatus switcherStatus, OnSwitcherSyncListener onSwitcherSyncListener) {
        this.mReportingTiming = "";
        this.mContext = context;
        this.mSupport = iSupport;
        this.mInnerEnable = z;
        this.mSwitcherStatus = switcherStatus;
        this.mListener = onSwitcherSyncListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SyncNotificationSwitchTask(Context context, ISupport iSupport, boolean z, SwitcherStatus switcherStatus, OnSwitcherSyncListener onSwitcherSyncListener, String str) {
        this.mContext = context;
        this.mSupport = iSupport;
        this.mInnerEnable = z;
        this.mSwitcherStatus = switcherStatus;
        this.mListener = onSwitcherSyncListener;
        this.mReportingTiming = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        LocalFrequencySettings localFrequencySettings = (LocalFrequencySettings) SettingsManager.obtain(this.mContext, LocalFrequencySettings.class);
        int areNotificationsEnabled = ToolUtils.areNotificationsEnabled(this.mContext);
        Map<String, String> commonParams = this.mSupport.getCommonParams();
        commonParams.put(SccResult.LABEL_NOTICE, this.mInnerEnable ? ViewVisibleBridge.INVISIBLE : "1");
        commonParams.put("system_notify_status", areNotificationsEnabled + "");
        if (!TextUtils.isEmpty(this.mReportingTiming)) {
            commonParams.put("reporting_timing", this.mReportingTiming);
            Logger.m268d("Polling", "report switch status with timing = " + this.mReportingTiming);
            this.mReportingTiming = "";
        } else {
            Logger.m268d("Polling", "report switch status without timing,using original");
        }
        String addUrlParam = ToolUtils.addUrlParam(MessageConstants.getSendNotifyEnableUrl(), commonParams);
        try {
            JSONArray notificationChannels = NotificationCompat.get().getNotificationChannels(this.mContext);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("out_app_channel_notify", notificationChannels.toString()));
            JSONObject jSONObject = new JSONObject();
            int systemPushEnable = localFrequencySettings.getSystemPushEnable();
            add(jSONObject, "last_status", systemPushEnable < 0 ? -1L : systemPushEnable);
            add(jSONObject, "current_status", areNotificationsEnabled);
            JSONObject jSONObject2 = new JSONObject();
            add(jSONObject2, "last_status", localFrequencySettings.getInnerPushEnable());
            add(jSONObject2, "current_status", this.mInnerEnable ? 1L : 0L);
            arrayList.add(new Pair("out_app_status_change_info", jSONObject.toString()));
            arrayList.add(new Pair("in_app_status_change_info", jSONObject2.toString()));
            arrayList.add(new Pair("live_activity_notify_status", String.valueOf(ToolUtils.hasFocusPermission(this.mContext))));
            SwitcherStatus switcherStatus = this.mSwitcherStatus;
            if (switcherStatus != null) {
                String extraToJson = switcherStatus.extraToJson();
                if (!TextUtils.isEmpty(extraToJson)) {
                    arrayList.add(new Pair("scene_status_extra", extraToJson));
                }
                String switcherToJson = this.mSwitcherStatus.switcherToJson();
                if (!TextUtils.isEmpty(switcherToJson)) {
                    arrayList.add(new Pair("scene_status_list", switcherToJson));
                }
            }
            NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
            reqContext.addCommonParams = false;
            String post = PushNetworkClient.getDefault().post(addUrlParam, arrayList, ToolUtils.addNetworkTagToHeader((Map) null), reqContext);
            Logger.m268d("NoticeSync", "sendPushEnableToServer response = " + post);
            if (!TextUtils.isEmpty(post)) {
                String optString = new JSONObject(post).optString("message");
                if ("success".equals(optString)) {
                    int i = 1;
                    localFrequencySettings.setLastSendNotifyEnableSucc(true);
                    localFrequencySettings.setSystemPushEnable(areNotificationsEnabled);
                    if (!this.mInnerEnable) {
                        i = 0;
                    }
                    localFrequencySettings.setInnerPushEnable(i);
                    localFrequencySettings.setLastNotificationChannelStatus(notificationChannels.toString());
                    localFrequencySettings.setUploadSwitchTs(ToolUtils.currentTimeMillis());
                    PushSupporter.monitor().markOuterSwitchUploadSuccess();
                    callSuccess();
                    return;
                }
                this.mSupport.getMonitor().markOuterSwitchUploadFailed(302, post);
                callFailed(1001, optString);
            } else {
                this.mSupport.getMonitor().markOuterSwitchUploadFailed(304, post);
                callFailed(1001, "server return empty");
            }
            localFrequencySettings.setLastSendNotifyEnableSucc(false);
        } catch (Exception e) {
            localFrequencySettings.setLastSendNotifyEnableSucc(false);
            PushSupporter.monitor().markOuterSwitchUploadFailed(301, Log.getStackTraceString(e));
            e.printStackTrace();
            if (e instanceof IOException) {
                callFailed(1002, "network error : " + e.getMessage());
            } else {
                callFailed(1003, "unknown error: " + e.getMessage());
            }
        }
    }

    private void callSuccess() {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.push.notification.SyncNotificationSwitchTask.1
                @Override // java.lang.Runnable
                public void run() {
                    SyncNotificationSwitchTask.this.mListener.onSuccess();
                }
            });
        }
    }

    private void callFailed(final int i, final String str) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.push.notification.SyncNotificationSwitchTask.2
                @Override // java.lang.Runnable
                public void run() {
                    SyncNotificationSwitchTask.this.mListener.onFailed(i, str);
                }
            });
        }
    }
}
