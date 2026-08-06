package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.ies.xbridge.BridgeDataConverterHolder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÇ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0017\u001a\u00020\tH×\u0001J\t\u0010\u0018\u001a\u00020\u0019H×\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope;", "", "code", "", "data", "Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;", "<init>", "(JLcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()J", "getData", "()Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", BridgeDataConverterHolder.TYPE_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$artifacts_mainlandRelease", "$serializer", "Companion", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class ChatSessionEnvelope {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long code;
    private final ChatSessionDto data;

    public static /* synthetic */ ChatSessionEnvelope copy$default(ChatSessionEnvelope chatSessionEnvelope, long j, ChatSessionDto chatSessionDto, int i, Object obj) {
        if ((i & 1) != 0) {
            j = chatSessionEnvelope.code;
        }
        if ((i & 2) != 0) {
            chatSessionDto = chatSessionEnvelope.data;
        }
        return chatSessionEnvelope.copy(j, chatSessionDto);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final ChatSessionDto getData() {
        return this.data;
    }

    public final ChatSessionEnvelope copy(long code, ChatSessionDto data) {
        return new ChatSessionEnvelope(code, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatSessionEnvelope)) {
            return false;
        }
        ChatSessionEnvelope chatSessionEnvelope = (ChatSessionEnvelope) other;
        return this.code == chatSessionEnvelope.code && Intrinsics.areEqual(this.data, chatSessionEnvelope.data);
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.code) * 31;
        ChatSessionDto chatSessionDto = this.data;
        return hashCode + (chatSessionDto == null ? 0 : chatSessionDto.hashCode());
    }

    public String toString() {
        return "ChatSessionEnvelope(code=" + this.code + ", data=" + this.data + ')';
    }

    /* compiled from: ArtifactModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ChatSessionEnvelope> serializer() {
            return ChatSessionEnvelope$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ChatSessionEnvelope(int i, long j, ChatSessionDto chatSessionDto, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, ChatSessionEnvelope$$serializer.INSTANCE.getDescriptor());
        }
        this.code = j;
        if ((i & 2) == 0) {
            this.data = null;
        } else {
            this.data = chatSessionDto;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$artifacts_mainlandRelease(ChatSessionEnvelope self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.code);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.data != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, ChatSessionDto$$serializer.INSTANCE, self.data);
        }
    }

    public ChatSessionEnvelope(long j, ChatSessionDto chatSessionDto) {
        this.code = j;
        this.data = chatSessionDto;
    }

    public /* synthetic */ ChatSessionEnvelope(long j, ChatSessionDto chatSessionDto, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : chatSessionDto);
    }

    public final long getCode() {
        return this.code;
    }

    public final ChatSessionDto getData() {
        return this.data;
    }
}
