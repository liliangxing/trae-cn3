package com.bytedance.trae.conversation;

import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Mode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AgentResolver.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/AgentResolver;", "", "<init>", "()V", "resolveDefaultAgentType", "", "mode", "Lcom/bytedance/trae/im/service/Mode;", "cliType", "Lcom/bytedance/trae/im/service/CliType;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AgentResolver {
    public static final AgentResolver INSTANCE = new AgentResolver();

    private AgentResolver() {
    }

    public final String resolveDefaultAgentType(Mode mode, CliType cliType) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        return cliType == CliType.REMOTE ? Mode.CODE == mode ? "solo_agent_remote" : "solo_work_remote" : cliType == CliType.IDE ? "solo_agent" : Mode.CODE == mode ? "solo_agent_lite" : "solo_work_lite";
    }
}
