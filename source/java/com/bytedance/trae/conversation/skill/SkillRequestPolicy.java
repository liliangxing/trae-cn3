package com.bytedance.trae.conversation.skill;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SkillRequestPolicy.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/skill/SkillRequestPolicy;", "", "<init>", "()V", "shouldUseHubApi", "", "context", "Lcom/bytedance/trae/conversation/skill/SkillRequestContext;", "buildQuery", "", "", "pageToken", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SkillRequestPolicy {
    public static final SkillRequestPolicy INSTANCE = new SkillRequestPolicy();

    private SkillRequestPolicy() {
    }

    public final boolean shouldUseHubApi(SkillRequestContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String cliId = context.getCliId();
        return !(cliId == null || StringsKt.isBlank(cliId));
    }

    public static /* synthetic */ Map buildQuery$default(SkillRequestPolicy skillRequestPolicy, SkillRequestContext skillRequestContext, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return skillRequestPolicy.buildQuery(skillRequestContext, str);
    }

    public final Map<String, String> buildQuery(SkillRequestContext context, String pageToken) {
        Intrinsics.checkNotNullParameter(context, "context");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = pageToken;
        if (!(str == null || StringsKt.isBlank(str))) {
            linkedHashMap.put("page_token", pageToken);
        }
        String cliId = context.getCliId();
        if (cliId == null || !(!StringsKt.isBlank(cliId))) {
            cliId = null;
        }
        if (cliId != null) {
            linkedHashMap.put("cli_id", cliId);
            String projectId = context.getProjectId();
            if (projectId != null) {
                if (!(!StringsKt.isBlank(projectId))) {
                    projectId = null;
                }
                if (projectId != null) {
                    linkedHashMap.put("project_id", projectId);
                }
            }
            String workspaceFolder = context.getWorkspaceFolder();
            if (workspaceFolder != null) {
                if (!(!StringsKt.isBlank(workspaceFolder))) {
                    workspaceFolder = null;
                }
                if (workspaceFolder != null) {
                    linkedHashMap.put("workspace_folder", workspaceFolder);
                }
            }
            String configName = context.getConfigName();
            if (configName != null) {
                if (!(!StringsKt.isBlank(configName))) {
                    configName = null;
                }
                if (configName != null) {
                    linkedHashMap.put("config_name", configName);
                }
            }
            String agentType = context.getAgentType();
            if (agentType != null) {
                String str2 = StringsKt.isBlank(agentType) ^ true ? agentType : null;
                if (str2 != null) {
                    linkedHashMap.put("agent_type", str2);
                }
            }
        }
        return linkedHashMap;
    }
}
