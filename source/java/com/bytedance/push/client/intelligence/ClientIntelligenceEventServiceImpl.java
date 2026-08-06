package com.bytedance.push.client.intelligence;

import com.bytedance.common.push.BaseJson;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.support.service.IPushConfigurationService;
import com.bytedance.push.PushSupporter;
import com.ss.android.message.util.ToolUtils;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ClientIntelligenceEventServiceImpl extends BaseJson implements IClientIntelligenceEventService {
    @Override // com.bytedance.push.client.intelligence.IClientIntelligenceEventService
    public void onClientAiParalysisEvent() {
        IPushConfigurationService pushConfigurationService = PushCommonSupport.getInstance().getPushConfigurationService();
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "client_timestamp", System.currentTimeMillis());
        add(jSONObject, "process_alive_duration", System.currentTimeMillis() - pushConfigurationService.getCurProcessStartTimeStamp());
        add(jSONObject, "process", ToolUtils.getCurProcessNameSuffix(pushConfigurationService.getPushCommonConfiguration().mApplication));
        PushSupporter.get().getMultiProcessEventSenderService().onEventV3(IClientIntelligenceEventService.EVENT_NAME_CLIENT_AI_PARALYSIS, jSONObject);
    }
}
