package com.bytedance.push;

import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.interfaze.IMultiProcessEventSenderService;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.interfaze.IPushCommonEventSender;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.log.PushLog;
import com.ss.android.message.util.ToolUtils;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MultiProcessEventSenderService implements IMultiProcessEventSenderService {
    private final String TAG = "MultiProcessEventSenderService";

    public void onEventV3(String str, JSONObject jSONObject) {
        onEventV3(false, str, jSONObject);
    }

    public void onEventV3(boolean z, String str, JSONObject jSONObject) {
        PushCommonConfiguration pushCommonConfiguration = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        if (z) {
            Logger.m274i("MultiProcessEventSenderService", "report event by http: event name is " + str + " params is " + (jSONObject == null ? "" : jSONObject.toString()));
            PushServiceManager.get().getIAllianceService().onEventV3WithHttp(true, str, jSONObject);
        }
        if (ToolUtils.isMainProcess(pushCommonConfiguration.mApplication)) {
            IPushCommonEventSender iPushCommonEventSender = pushCommonConfiguration.mIPushCommonEventSender;
            if (iPushCommonEventSender != null) {
                Logger.m274i("MultiProcessEventSenderService", "report event by appLog: event name is " + str + " params is " + (jSONObject != null ? jSONObject.toString() : ""));
                iPushCommonEventSender.onEventV3(str, jSONObject);
                return;
            }
            return;
        }
        Logger.m274i("MultiProcessEventSenderService", "report event by pushLog: event name is " + str + " params is " + (jSONObject != null ? jSONObject.toString() : ""));
        PushLog.onEventV3(pushCommonConfiguration.mApplication, str, jSONObject);
    }
}
