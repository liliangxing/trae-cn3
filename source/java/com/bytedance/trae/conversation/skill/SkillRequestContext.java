package com.bytedance.trae.conversation.skill;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SkillRequestPolicy.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/skill/SkillRequestContext;", "", "cliId", "", "workspaceFolder", "projectId", "configName", "agentType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCliId", "()Ljava/lang/String;", "getWorkspaceFolder", "getProjectId", "setProjectId", "(Ljava/lang/String;)V", "getConfigName", "getAgentType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SkillRequestContext {
    private final String agentType;
    private final String cliId;
    private final String configName;
    private String projectId;
    private final String workspaceFolder;

    public static /* synthetic */ SkillRequestContext copy$default(SkillRequestContext skillRequestContext, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = skillRequestContext.cliId;
        }
        if ((i & 2) != 0) {
            str2 = skillRequestContext.workspaceFolder;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = skillRequestContext.projectId;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = skillRequestContext.configName;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = skillRequestContext.agentType;
        }
        return skillRequestContext.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCliId() {
        return this.cliId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getWorkspaceFolder() {
        return this.workspaceFolder;
    }

    /* renamed from: component3, reason: from getter */
    public final String getProjectId() {
        return this.projectId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getConfigName() {
        return this.configName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAgentType() {
        return this.agentType;
    }

    public final SkillRequestContext copy(String cliId, String workspaceFolder, String projectId, String configName, String agentType) {
        return new SkillRequestContext(cliId, workspaceFolder, projectId, configName, agentType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillRequestContext)) {
            return false;
        }
        SkillRequestContext skillRequestContext = (SkillRequestContext) other;
        return Intrinsics.areEqual(this.cliId, skillRequestContext.cliId) && Intrinsics.areEqual(this.workspaceFolder, skillRequestContext.workspaceFolder) && Intrinsics.areEqual(this.projectId, skillRequestContext.projectId) && Intrinsics.areEqual(this.configName, skillRequestContext.configName) && Intrinsics.areEqual(this.agentType, skillRequestContext.agentType);
    }

    public int hashCode() {
        String str = this.cliId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.workspaceFolder;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.projectId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.configName;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.agentType;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "SkillRequestContext(cliId=" + this.cliId + ", workspaceFolder=" + this.workspaceFolder + ", projectId=" + this.projectId + ", configName=" + this.configName + ", agentType=" + this.agentType + ')';
    }

    public SkillRequestContext(String str, String str2, String str3, String str4, String str5) {
        this.cliId = str;
        this.workspaceFolder = str2;
        this.projectId = str3;
        this.configName = str4;
        this.agentType = str5;
    }

    public /* synthetic */ SkillRequestContext(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public final String getCliId() {
        return this.cliId;
    }

    public final String getWorkspaceFolder() {
        return this.workspaceFolder;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final void setProjectId(String str) {
        this.projectId = str;
    }

    public final String getConfigName() {
        return this.configName;
    }

    public final String getAgentType() {
        return this.agentType;
    }
}
