package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.ies.xbridge.BridgeDataConverterHolder;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.bytedance.trae.push.api.PushConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 -2\u00020\u0001:\u0002,-B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nBG\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J7\u0010\u001f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bHÇ\u0001J\u0013\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\"\u001a\u00020\fH×\u0001J\t\u0010#\u001a\u00020\u0004H×\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a¨\u0006."}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;", "", "targets", "", "", "conversationId", "messageId", "checkExist", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTargets", "()Ljava/util/List;", "getConversationId$annotations", "()V", "getConversationId", "()Ljava/lang/String;", "getMessageId$annotations", "getMessageId", "getCheckExist$annotations", "getCheckExist", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", BridgeDataConverterHolder.TYPE_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$artifacts_mainlandRelease", "$serializer", "Companion", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class DownloadUrlRequestDto {
    private final boolean checkExist;
    private final String conversationId;
    private final String messageId;
    private final List<String> targets;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DownloadUrlRequestDto copy$default(DownloadUrlRequestDto downloadUrlRequestDto, List list, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = downloadUrlRequestDto.targets;
        }
        if ((i & 2) != 0) {
            str = downloadUrlRequestDto.conversationId;
        }
        if ((i & 4) != 0) {
            str2 = downloadUrlRequestDto.messageId;
        }
        if ((i & 8) != 0) {
            z = downloadUrlRequestDto.checkExist;
        }
        return downloadUrlRequestDto.copy(list, str, str2, z);
    }

    @SerialName("check_exist")
    public static /* synthetic */ void getCheckExist$annotations() {
    }

    @SerialName(PushConst.PUSH_KEY_CONVERSATION_ID)
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName(MultiProcessPushMessageDatabaseHelper.COL_MESSAGE_ID)
    public static /* synthetic */ void getMessageId$annotations() {
    }

    public final List<String> component1() {
        return this.targets;
    }

    /* renamed from: component2, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getCheckExist() {
        return this.checkExist;
    }

    public final DownloadUrlRequestDto copy(List<String> targets, String conversationId, String messageId, boolean checkExist) {
        Intrinsics.checkNotNullParameter(targets, "targets");
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        return new DownloadUrlRequestDto(targets, conversationId, messageId, checkExist);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadUrlRequestDto)) {
            return false;
        }
        DownloadUrlRequestDto downloadUrlRequestDto = (DownloadUrlRequestDto) other;
        return Intrinsics.areEqual(this.targets, downloadUrlRequestDto.targets) && Intrinsics.areEqual(this.conversationId, downloadUrlRequestDto.conversationId) && Intrinsics.areEqual(this.messageId, downloadUrlRequestDto.messageId) && this.checkExist == downloadUrlRequestDto.checkExist;
    }

    public int hashCode() {
        return (((((this.targets.hashCode() * 31) + this.conversationId.hashCode()) * 31) + this.messageId.hashCode()) * 31) + Boolean.hashCode(this.checkExist);
    }

    public String toString() {
        return "DownloadUrlRequestDto(targets=" + this.targets + ", conversationId=" + this.conversationId + ", messageId=" + this.messageId + ", checkExist=" + this.checkExist + ')';
    }

    /* compiled from: ArtifactModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<DownloadUrlRequestDto> serializer() {
            return DownloadUrlRequestDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DownloadUrlRequestDto(int i, List list, String str, String str2, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, DownloadUrlRequestDto$$serializer.INSTANCE.getDescriptor());
        }
        this.targets = list;
        this.conversationId = str;
        this.messageId = str2;
        if ((i & 8) == 0) {
            this.checkExist = true;
        } else {
            this.checkExist = z;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$artifacts_mainlandRelease(DownloadUrlRequestDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.targets);
        output.encodeStringElement(serialDesc, 1, self.conversationId);
        output.encodeStringElement(serialDesc, 2, self.messageId);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !self.checkExist) {
            output.encodeBooleanElement(serialDesc, 3, self.checkExist);
        }
    }

    public DownloadUrlRequestDto(List<String> list, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(list, "targets");
        Intrinsics.checkNotNullParameter(str, "conversationId");
        Intrinsics.checkNotNullParameter(str2, "messageId");
        this.targets = list;
        this.conversationId = str;
        this.messageId = str2;
        this.checkExist = z;
    }

    public /* synthetic */ DownloadUrlRequestDto(List list, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, str2, (i & 8) != 0 ? true : z);
    }

    public final List<String> getTargets() {
        return this.targets;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final boolean getCheckExist() {
        return this.checkExist;
    }
}
