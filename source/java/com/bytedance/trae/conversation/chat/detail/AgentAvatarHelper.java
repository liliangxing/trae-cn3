package com.bytedance.trae.conversation.chat.detail;

import com.bytedance.trae.conversation.R;
import kotlin.Metadata;

/* compiled from: AgentAvatarHelper.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/AgentAvatarHelper;", "", "<init>", "()V", "AGENT_ID_SEARCH", "", "AGENT_ID_EXPLORE", "AGENT_ID_GENERAL_PURPOSE", "AGENT_ID_PLAN", "getAvatarResId", "", "agentId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AgentAvatarHelper {
    private static final String AGENT_ID_EXPLORE = "Explore";
    private static final String AGENT_ID_GENERAL_PURPOSE = "general_purpose_task";
    private static final String AGENT_ID_PLAN = "Plan";
    private static final String AGENT_ID_SEARCH = "search";
    public static final AgentAvatarHelper INSTANCE = new AgentAvatarHelper();

    private AgentAvatarHelper() {
    }

    public final int getAvatarResId(String agentId) {
        if (agentId != null) {
            switch (agentId.hashCode()) {
                case -906336856:
                    if (agentId.equals(AGENT_ID_SEARCH)) {
                        return R.drawable.avatar_agent_search;
                    }
                    break;
                case 2490185:
                    if (agentId.equals(AGENT_ID_PLAN)) {
                        return R.drawable.avatar_agent_plan;
                    }
                    break;
                case 355504755:
                    if (agentId.equals(AGENT_ID_EXPLORE)) {
                        return R.drawable.avatar_agent_explore;
                    }
                    break;
                case 2081328637:
                    if (agentId.equals(AGENT_ID_GENERAL_PURPOSE)) {
                        return R.drawable.avatar_agent_general_purpose;
                    }
                    break;
            }
        }
        return R.drawable.avatar_coder;
    }
}
