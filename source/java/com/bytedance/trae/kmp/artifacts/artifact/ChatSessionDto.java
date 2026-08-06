package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.ies.xbridge.BridgeDataConverterHolder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0018\u001a\u00020\bH×\u0001J\t\u0010\u0019\u001a\u00020\u0003H×\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006$"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;", "", "explorerUrl", "", "workspacePath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getExplorerUrl$annotations", "()V", "getExplorerUrl", "()Ljava/lang/String;", "getWorkspacePath$annotations", "getWorkspacePath", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BridgeDataConverterHolder.TYPE_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$artifacts_mainlandRelease", "$serializer", "Companion", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class ChatSessionDto {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String explorerUrl;
    private final String workspacePath;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatSessionDto() {
        this(r0, r0, 3, (DefaultConstructorMarker) r0);
        String str = null;
    }

    public static /* synthetic */ ChatSessionDto copy$default(ChatSessionDto chatSessionDto, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatSessionDto.explorerUrl;
        }
        if ((i & 2) != 0) {
            str2 = chatSessionDto.workspacePath;
        }
        return chatSessionDto.copy(str, str2);
    }

    @SerialName("explorer_url")
    public static /* synthetic */ void getExplorerUrl$annotations() {
    }

    @SerialName("workspace_path")
    public static /* synthetic */ void getWorkspacePath$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getExplorerUrl() {
        return this.explorerUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getWorkspacePath() {
        return this.workspacePath;
    }

    public final ChatSessionDto copy(String explorerUrl, String workspacePath) {
        return new ChatSessionDto(explorerUrl, workspacePath);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatSessionDto)) {
            return false;
        }
        ChatSessionDto chatSessionDto = (ChatSessionDto) other;
        return Intrinsics.areEqual(this.explorerUrl, chatSessionDto.explorerUrl) && Intrinsics.areEqual(this.workspacePath, chatSessionDto.workspacePath);
    }

    public int hashCode() {
        String str = this.explorerUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.workspacePath;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ChatSessionDto(explorerUrl=" + this.explorerUrl + ", workspacePath=" + this.workspacePath + ')';
    }

    /* compiled from: ArtifactModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ChatSessionDto> serializer() {
            return ChatSessionDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ChatSessionDto(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, ChatSessionDto$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.explorerUrl = null;
        } else {
            this.explorerUrl = str;
        }
        if ((i & 2) == 0) {
            this.workspacePath = null;
        } else {
            this.workspacePath = str2;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$artifacts_mainlandRelease(ChatSessionDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.explorerUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.explorerUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.workspacePath != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.workspacePath);
        }
    }

    public ChatSessionDto(String str, String str2) {
        this.explorerUrl = str;
        this.workspacePath = str2;
    }

    public /* synthetic */ ChatSessionDto(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getExplorerUrl() {
        return this.explorerUrl;
    }

    public final String getWorkspacePath() {
        return this.workspacePath;
    }
}
