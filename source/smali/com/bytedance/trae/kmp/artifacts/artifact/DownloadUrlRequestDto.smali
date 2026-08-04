# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.field private static final $childSerializers:[Lkotlinx/serialization/KSerializer;
.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$Companion;
.field private final checkExist:Z
.field private final conversationId:Ljava/lang/String;
.field private final messageId:Ljava/lang/String;
.field private final targets:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->Companion Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->$stable I
    const/4 v0, 4
    new-array v0, v0, [Lkotlinx/serialization/KSerializer;
    new-instance v2, Lkotlinx/serialization/internal/ArrayListSerializer;
    sget-object v3, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v3, Lkotlinx/serialization/KSerializer;
    invoke-direct v2, v3, Lkotlinx/serialization/internal/ArrayListSerializer;-><init>(Lkotlinx/serialization/KSerializer;)V
    const/4 v3, 0
    aput-object v2, v0, v3
    const/4 v2, 1
    aput-object v1, v0, v2
    const/4 v2, 2
    aput-object v1, v0, v2
    const/4 v2, 3
    aput-object v1, v0, v2
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->$childSerializers [Lkotlinx/serialization/KSerializer;
    return-void 
.end method

.method public synthetic constructor <init>(int  java.util.List  java.lang.String  java.lang.String  boolean  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v2, 7
    const/4 v0, 7
    if-eq v0, v7, +00bh
    sget-object v7, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;
    invoke-virtual v7, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v7
    invoke-static v2, v0, v7, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->targets Ljava/util/List;
    iput-object v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->conversationId Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->messageId Ljava/lang/String;
    and-int/lit8 v2, v2, 8
    if-nez v2, +006h
    const/4 v2, 1
    iput-boolean v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->checkExist Z
    goto +3h
    iput-boolean v6, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->checkExist Z
    return-void 
.end method

.method public constructor <init>(java.util.List  java.lang.String  java.lang.String  boolean)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, targets
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->targets Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->conversationId Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->messageId Ljava/lang/String;
    iput-boolean v5, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->checkExist Z
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  java.lang.String  java.lang.String  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 1
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Z)V
    return-void 
.end method

.method public static final synthetic access$get$childSerializers$cp()kotlinx.serialization.KSerializer[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->$childSerializers [Lkotlinx/serialization/KSerializer;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlRequestDto  java.util.List  java.lang.String  java.lang.String  boolean  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlRequestDto
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->targets Ljava/util/List;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->conversationId Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->messageId Ljava/lang/String;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-boolean v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->checkExist Z
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->copy(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Z)Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic getCheckExist$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getConversationId$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getMessageId$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$artifacts_mainlandRelease(com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlRequestDto  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 7
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->$childSerializers [Lkotlinx/serialization/KSerializer;
    const/4 v1, 0
    aget-object v0, v0, v1
    check-cast v0, Lkotlinx/serialization/SerializationStrategy;
    iget-object v2, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->targets Ljava/util/List;
    invoke-interface v5, v6, v1, v0, v2, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    iget-object v0, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->conversationId Ljava/lang/String;
    const/4 v2, 1
    invoke-interface v5, v6, v2, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    const/4 v0, 2
    iget-object v3, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->messageId Ljava/lang/String;
    invoke-interface v5, v6, v0, v3, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    const/4 v0, 3
    invoke-interface v5, v6, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v3
    if-eqz v3, +004h
    move v1, v2
    goto +6h
    iget-boolean v3, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->checkExist Z
    if-eq v3, v2, +003h
    goto -6h
    if-eqz v1, +007h
    iget-boolean v4, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->checkExist Z
    invoke-interface v5, v6, v0, v4, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeBooleanElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Z)V
    return-void 
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->targets Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->checkExist Z
    return v0
.end method

.method public final copy(java.util.List  java.lang.String  java.lang.String  boolean)com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlRequestDto
    .registers 6
    # ins_size=5
    const-string/jumbo v0, targets
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->targets Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->targets Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->conversationId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->conversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->messageId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->messageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->checkExist Z
    iget-boolean v5, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->checkExist Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getCheckExist()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->checkExist Z
    return v0
.end method

.method public final getConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final getTargets()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->targets Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->targets Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->conversationId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->messageId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->checkExist Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DownloadUrlRequestDto(targets="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->targets Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", conversationId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->messageId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", checkExist="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->checkExist Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
