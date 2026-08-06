package com.bytedance.push.client.intelligence;

/* loaded from: classes4.dex */
interface IClientIntelligenceEventService {
    public static final String EVENT_NAME_CLIENT_AI_PARALYSIS = "bdpush_client_ai_paralysis";

    void onClientAiParalysisEvent();
}
