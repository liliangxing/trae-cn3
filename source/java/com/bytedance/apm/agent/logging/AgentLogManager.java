package com.bytedance.apm.agent.logging;

/* loaded from: classes3.dex */
public class AgentLogManager {
    private static DefaultAgentLog instance = new DefaultAgentLog();

    public static AgentLog getAgentLog() {
        return instance;
    }

    public static void setAgentLog(AgentLog agentLog) {
        instance.setImpl(agentLog);
    }
}
