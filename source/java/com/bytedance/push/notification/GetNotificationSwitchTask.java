package com.bytedance.push.notification;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.push.interfaze.ISupport;
import com.bytedance.push.interfaze.OnSwitcherServerListener;
import com.bytedance.push.model.SwitcherStatus;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.MessageConstants;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GetNotificationSwitchTask implements Runnable {
    private final Context mContext;
    private final boolean mInnerEnable;
    private final ISupport mSupport;
    private final OnSwitcherServerListener mSwitcherServerListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetNotificationSwitchTask(Context context, boolean z, ISupport iSupport, OnSwitcherServerListener onSwitcherServerListener) {
        this.mContext = context;
        this.mInnerEnable = z;
        this.mSupport = iSupport;
        this.mSwitcherServerListener = onSwitcherServerListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            int areNotificationsEnabled = ToolUtils.areNotificationsEnabled(this.mContext);
            Map<String, String> commonParams = this.mSupport.getCommonParams();
            commonParams.put(SccResult.LABEL_NOTICE, this.mInnerEnable ? ViewVisibleBridge.INVISIBLE : "1");
            commonParams.put("system_notify_status", areNotificationsEnabled + "");
            String addUrlParam = ToolUtils.addUrlParam(MessageConstants.getNotifyStatusUrl(), commonParams);
            new ArrayList().add(new Pair("out_app_channel_notify", NotificationCompat.get().getNotificationChannels(this.mContext).toString()));
            NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
            reqContext.addCommonParams = false;
            String str = NetworkClient.getDefault().get(addUrlParam, ToolUtils.addNetworkTagToHeader((Map) null), reqContext);
            SwitcherStatus switcherStatus = new SwitcherStatus();
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("message");
                if (!"success".equals(string)) {
                    callListener(false, switcherStatus);
                    this.mSupport.getMonitor().markOuterSwitchStatusFailed(1001, string);
                    return;
                }
                JSONArray jSONArray = jSONObject.getJSONArray("statuses");
                if (jSONArray == null) {
                    callListener(true, switcherStatus);
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    boolean z = jSONObject2.getInt("is_close") == 0;
                    String string2 = jSONObject2.getString("name");
                    if (!TextUtils.isEmpty(string2)) {
                        switcherStatus.addSwitcher(new SwitcherStatus.ChildSwitcher(string2, z, null));
                    }
                }
                callListener(true, switcherStatus);
                return;
            }
            this.mSupport.getMonitor().markOuterSwitchStatusFailed(304, str);
            callListener(false, null);
        } catch (Throwable th) {
            this.mSupport.getMonitor().markOuterSwitchStatusFailed(301, Log.getStackTraceString(th));
            callListener(false, null);
        }
    }

    private void callListener(final boolean z, final SwitcherStatus switcherStatus) {
        if (this.mSwitcherServerListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.push.notification.GetNotificationSwitchTask.1
                @Override // java.lang.Runnable
                public void run() {
                    GetNotificationSwitchTask.this.mSwitcherServerListener.onSwitcherStatus(z, switcherStatus);
                }
            });
        }
    }
}
