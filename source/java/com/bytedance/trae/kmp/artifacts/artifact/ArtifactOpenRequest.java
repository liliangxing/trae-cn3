package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.xbridge.BridgeDataConverterHolder;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0002CDBe\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011B\u0087\u0001\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J}\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u00109\u001a\u00020\tH×\u0001J\t\u0010:\u001a\u00020\u0003H×\u0001J%\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0001¢\u0006\u0002\bBR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b%\u0010\u0017R\u0011\u0010&\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006E"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;", "", "artifactId", "", "kind", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;", "filePath", "lastFrameUri", "durationSeconds", "", "fileAction", "conversationId", "messageId", "cliConversationId", "cliType", "turnId", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getArtifactId", "()Ljava/lang/String;", "getKind", "()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;", "getFilePath", "getLastFrameUri", "getDurationSeconds", "()I", "getFileAction", "getConversationId", "getMessageId", "getCliConversationId", "getCliType", "getTurnId", SchemaConstants.QUERY_KEY_TITLE, "getTitle", EventConstants.PARAM_SOURCE, "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;", "getSource", "()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BridgeDataConverterHolder.TYPE_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$artifacts_mainlandRelease", "$serializer", "Companion", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class ArtifactOpenRequest {
    public static final int $stable = 0;
    private final String artifactId;
    private final String cliConversationId;
    private final String cliType;
    private final String conversationId;
    private final int durationSeconds;
    private final String fileAction;
    private final String filePath;
    private final ArtifactKind kind;
    private final String lastFrameUri;
    private final String messageId;
    private final String turnId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, ArtifactKind.INSTANCE.serializer(), null, null, null, null, null, null, null, null, null};

    /* renamed from: component1, reason: from getter */
    public final String getArtifactId() {
        return this.artifactId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getCliType() {
        return this.cliType;
    }

    /* renamed from: component11, reason: from getter */
    public final String getTurnId() {
        return this.turnId;
    }

    /* renamed from: component2, reason: from getter */
    public final ArtifactKind getKind() {
        return this.kind;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLastFrameUri() {
        return this.lastFrameUri;
    }

    /* renamed from: component5, reason: from getter */
    public final int getDurationSeconds() {
        return this.durationSeconds;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFileAction() {
        return this.fileAction;
    }

    /* renamed from: component7, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component8, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getCliConversationId() {
        return this.cliConversationId;
    }

    public final ArtifactOpenRequest copy(String artifactId, ArtifactKind kind, String filePath, String lastFrameUri, int durationSeconds, String fileAction, String conversationId, String messageId, String cliConversationId, String cliType, String turnId) {
        Intrinsics.checkNotNullParameter(artifactId, "artifactId");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(cliConversationId, "cliConversationId");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        return new ArtifactOpenRequest(artifactId, kind, filePath, lastFrameUri, durationSeconds, fileAction, conversationId, messageId, cliConversationId, cliType, turnId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArtifactOpenRequest)) {
            return false;
        }
        ArtifactOpenRequest artifactOpenRequest = (ArtifactOpenRequest) other;
        return Intrinsics.areEqual(this.artifactId, artifactOpenRequest.artifactId) && this.kind == artifactOpenRequest.kind && Intrinsics.areEqual(this.filePath, artifactOpenRequest.filePath) && Intrinsics.areEqual(this.lastFrameUri, artifactOpenRequest.lastFrameUri) && this.durationSeconds == artifactOpenRequest.durationSeconds && Intrinsics.areEqual(this.fileAction, artifactOpenRequest.fileAction) && Intrinsics.areEqual(this.conversationId, artifactOpenRequest.conversationId) && Intrinsics.areEqual(this.messageId, artifactOpenRequest.messageId) && Intrinsics.areEqual(this.cliConversationId, artifactOpenRequest.cliConversationId) && Intrinsics.areEqual(this.cliType, artifactOpenRequest.cliType) && Intrinsics.areEqual(this.turnId, artifactOpenRequest.turnId);
    }

    public int hashCode() {
        int hashCode = ((((this.artifactId.hashCode() * 31) + this.kind.hashCode()) * 31) + this.filePath.hashCode()) * 31;
        String str = this.lastFrameUri;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.durationSeconds)) * 31;
        String str2 = this.fileAction;
        int hashCode3 = (((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.conversationId.hashCode()) * 31) + this.messageId.hashCode()) * 31) + this.cliConversationId.hashCode()) * 31) + this.cliType.hashCode()) * 31;
        String str3 = this.turnId;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ArtifactOpenRequest(artifactId=");
        sb.append(this.artifactId).append(", kind=").append(this.kind).append(", filePath=").append(this.filePath).append(", lastFrameUri=").append(this.lastFrameUri).append(", durationSeconds=").append(this.durationSeconds).append(", fileAction=").append(this.fileAction).append(", conversationId=").append(this.conversationId).append(", messageId=").append(this.messageId).append(", cliConversationId=").append(this.cliConversationId).append(", cliType=").append(this.cliType).append(", turnId=").append(this.turnId).append(')');
        return sb.toString();
    }

    /* compiled from: ArtifactModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ArtifactOpenRequest> serializer() {
            return ArtifactOpenRequest$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ArtifactOpenRequest(int i, String str, ArtifactKind artifactKind, String str2, String str3, int i2, String str4, String str5, String str6, String str7, String str8, String str9, SerializationConstructorMarker serializationConstructorMarker) {
        if (2047 != (i & 2047)) {
            PluginExceptionsKt.throwMissingFieldException(i, 2047, ArtifactOpenRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.artifactId = str;
        this.kind = artifactKind;
        this.filePath = str2;
        this.lastFrameUri = str3;
        this.durationSeconds = i2;
        this.fileAction = str4;
        this.conversationId = str5;
        this.messageId = str6;
        this.cliConversationId = str7;
        this.cliType = str8;
        this.turnId = str9;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$artifacts_mainlandRelease(ArtifactOpenRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.artifactId);
        output.encodeSerializableElement(serialDesc, 1, serializationStrategyArr[1], self.kind);
        output.encodeStringElement(serialDesc, 2, self.filePath);
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.lastFrameUri);
        output.encodeIntElement(serialDesc, 4, self.durationSeconds);
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.fileAction);
        output.encodeStringElement(serialDesc, 6, self.conversationId);
        output.encodeStringElement(serialDesc, 7, self.messageId);
        output.encodeStringElement(serialDesc, 8, self.cliConversationId);
        output.encodeStringElement(serialDesc, 9, self.cliType);
        output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.turnId);
    }

    public ArtifactOpenRequest(String str, ArtifactKind artifactKind, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "artifactId");
        Intrinsics.checkNotNullParameter(artifactKind, "kind");
        Intrinsics.checkNotNullParameter(str2, "filePath");
        Intrinsics.checkNotNullParameter(str5, "conversationId");
        Intrinsics.checkNotNullParameter(str6, "messageId");
        Intrinsics.checkNotNullParameter(str7, "cliConversationId");
        Intrinsics.checkNotNullParameter(str8, "cliType");
        this.artifactId = str;
        this.kind = artifactKind;
        this.filePath = str2;
        this.lastFrameUri = str3;
        this.durationSeconds = i;
        this.fileAction = str4;
        this.conversationId = str5;
        this.messageId = str6;
        this.cliConversationId = str7;
        this.cliType = str8;
        this.turnId = str9;
    }

    public final String getArtifactId() {
        return this.artifactId;
    }

    public final ArtifactKind getKind() {
        return this.kind;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getLastFrameUri() {
        return this.lastFrameUri;
    }

    public final int getDurationSeconds() {
        return this.durationSeconds;
    }

    public final String getFileAction() {
        return this.fileAction;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getCliConversationId() {
        return this.cliConversationId;
    }

    public final String getCliType() {
        return this.cliType;
    }

    public final String getTurnId() {
        return this.turnId;
    }

    public final String getTitle() {
        String substringAfterLast$default = StringsKt.substringAfterLast$default(this.filePath, '/', (String) null, 2, (Object) null);
        if (StringsKt.isBlank(substringAfterLast$default)) {
            substringAfterLast$default = this.filePath;
        }
        return substringAfterLast$default;
    }

    public final ArtifactSource getSource() {
        if (StringsKt.equals(this.cliType, "remote", true)) {
            return ArtifactSource.Remote;
        }
        return ArtifactSource.Local;
    }
}
