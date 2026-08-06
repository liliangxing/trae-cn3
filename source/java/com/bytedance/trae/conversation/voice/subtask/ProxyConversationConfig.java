package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Mode;
import com.bytedance.trae.im.service.Source;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubTaskProtocol.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;", "", "voiceConversationId", "", "parentConversationId", "createRemoteParentSession", "", "cliId", "cliType", "Lcom/bytedance/trae/im/service/CliType;", "mode", "Lcom/bytedance/trae/im/service/Mode;", "parentAgentType", "workspaceDir", TimonPipeline.KEY_SOURCE, "Lcom/bytedance/trae/im/service/Source;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/bytedance/trae/im/service/CliType;Lcom/bytedance/trae/im/service/Mode;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/Source;)V", "getVoiceConversationId", "()Ljava/lang/String;", "getParentConversationId", "getCreateRemoteParentSession", "()Z", "getCliId", "getCliType", "()Lcom/bytedance/trae/im/service/CliType;", "getMode", "()Lcom/bytedance/trae/im/service/Mode;", "getParentAgentType", "getWorkspaceDir", "getSource", "()Lcom/bytedance/trae/im/service/Source;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ProxyConversationConfig {
    private final String cliId;
    private final CliType cliType;
    private final boolean createRemoteParentSession;
    private final Mode mode;
    private final String parentAgentType;
    private final String parentConversationId;
    private final Source source;
    private final String voiceConversationId;
    private final String workspaceDir;

    /* renamed from: component1, reason: from getter */
    public final String getVoiceConversationId() {
        return this.voiceConversationId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getParentConversationId() {
        return this.parentConversationId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCreateRemoteParentSession() {
        return this.createRemoteParentSession;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCliId() {
        return this.cliId;
    }

    /* renamed from: component5, reason: from getter */
    public final CliType getCliType() {
        return this.cliType;
    }

    /* renamed from: component6, reason: from getter */
    public final Mode getMode() {
        return this.mode;
    }

    /* renamed from: component7, reason: from getter */
    public final String getParentAgentType() {
        return this.parentAgentType;
    }

    /* renamed from: component8, reason: from getter */
    public final String getWorkspaceDir() {
        return this.workspaceDir;
    }

    /* renamed from: component9, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    public final ProxyConversationConfig copy(String voiceConversationId, String parentConversationId, boolean createRemoteParentSession, String cliId, CliType cliType, Mode mode, String parentAgentType, String workspaceDir, Source source) {
        Intrinsics.checkNotNullParameter(voiceConversationId, "voiceConversationId");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new ProxyConversationConfig(voiceConversationId, parentConversationId, createRemoteParentSession, cliId, cliType, mode, parentAgentType, workspaceDir, source);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProxyConversationConfig)) {
            return false;
        }
        ProxyConversationConfig proxyConversationConfig = (ProxyConversationConfig) other;
        return Intrinsics.areEqual(this.voiceConversationId, proxyConversationConfig.voiceConversationId) && Intrinsics.areEqual(this.parentConversationId, proxyConversationConfig.parentConversationId) && this.createRemoteParentSession == proxyConversationConfig.createRemoteParentSession && Intrinsics.areEqual(this.cliId, proxyConversationConfig.cliId) && this.cliType == proxyConversationConfig.cliType && this.mode == proxyConversationConfig.mode && Intrinsics.areEqual(this.parentAgentType, proxyConversationConfig.parentAgentType) && Intrinsics.areEqual(this.workspaceDir, proxyConversationConfig.workspaceDir) && Intrinsics.areEqual(this.source, proxyConversationConfig.source);
    }

    public int hashCode() {
        int hashCode = this.voiceConversationId.hashCode() * 31;
        String str = this.parentConversationId;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.createRemoteParentSession)) * 31;
        String str2 = this.cliId;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.cliType.hashCode()) * 31) + this.mode.hashCode()) * 31;
        String str3 = this.parentAgentType;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.workspaceDir;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Source source = this.source;
        return hashCode5 + (source != null ? source.hashCode() : 0);
    }

    public String toString() {
        return "ProxyConversationConfig(voiceConversationId=" + this.voiceConversationId + ", parentConversationId=" + this.parentConversationId + ", createRemoteParentSession=" + this.createRemoteParentSession + ", cliId=" + this.cliId + ", cliType=" + this.cliType + ", mode=" + this.mode + ", parentAgentType=" + this.parentAgentType + ", workspaceDir=" + this.workspaceDir + ", source=" + this.source + ')';
    }

    public ProxyConversationConfig(String str, String str2, boolean z, String str3, CliType cliType, Mode mode, String str4, String str5, Source source) {
        Intrinsics.checkNotNullParameter(str, "voiceConversationId");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.voiceConversationId = str;
        this.parentConversationId = str2;
        this.createRemoteParentSession = z;
        this.cliId = str3;
        this.cliType = cliType;
        this.mode = mode;
        this.parentAgentType = str4;
        this.workspaceDir = str5;
        this.source = source;
    }

    public /* synthetic */ ProxyConversationConfig(String str, String str2, boolean z, String str3, CliType cliType, Mode mode, String str4, String str5, Source source, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z, str3, cliType, mode, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : source);
    }

    public final String getVoiceConversationId() {
        return this.voiceConversationId;
    }

    public final String getParentConversationId() {
        return this.parentConversationId;
    }

    public final boolean getCreateRemoteParentSession() {
        return this.createRemoteParentSession;
    }

    public final String getCliId() {
        return this.cliId;
    }

    public final CliType getCliType() {
        return this.cliType;
    }

    public final Mode getMode() {
        return this.mode;
    }

    public final String getParentAgentType() {
        return this.parentAgentType;
    }

    public final String getWorkspaceDir() {
        return this.workspaceDir;
    }

    public final Source getSource() {
        return this.source;
    }
}
