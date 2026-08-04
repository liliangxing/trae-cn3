# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.field private static final $childSerializers:[Lkotlinx/serialization/KSerializer;
.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$Companion;
.field private final artifactId:Ljava/lang/String;
.field private final cliConversationId:Ljava/lang/String;
.field private final cliType:Ljava/lang/String;
.field private final conversationId:Ljava/lang/String;
.field private final durationSeconds:I
.field private final fileAction:Ljava/lang/String;
.field private final filePath:Ljava/lang/String;
.field private final kind:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;
.field private final lastFrameUri:Ljava/lang/String;
.field private final messageId:Ljava/lang/String;
.field private final turnId:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->Companion Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$Companion;
    const/16 v0, 11
    new-array v0, v0, [Lkotlinx/serialization/KSerializer;
    const/4 v2, 0
    aput-object v1, v0, v2
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;->Companion Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v2
    const/4 v3, 1
    aput-object v2, v0, v3
    const/4 v2, 2
    aput-object v1, v0, v2
    const/4 v2, 3
    aput-object v1, v0, v2
    const/4 v2, 4
    aput-object v1, v0, v2
    const/4 v2, 5
    aput-object v1, v0, v2
    const/4 v2, 6
    aput-object v1, v0, v2
    const/4 v2, 7
    aput-object v1, v0, v2
    const/16 v2, 8
    aput-object v1, v0, v2
    const/16 v2, 9
    aput-object v1, v0, v2
    const/16 v2, 10
    aput-object v1, v0, v2
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->$childSerializers [Lkotlinx/serialization/KSerializer;
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.String  com.bytedance.trae.kmp.artifacts.artifact.ArtifactKind  java.lang.String  java.lang.String  int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 15
    # ins_size=14
    and-int/lit16 v14, v2, 2047
    const/16 v0, 2047
    if-eq v0, v14, +00bh
    sget-object v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;
    invoke-virtual v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v14
    invoke-static v2, v0, v14, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->artifactId Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->kind Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;
    iput-object v5, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->filePath Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->lastFrameUri Ljava/lang/String;
    iput v7, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->durationSeconds I
    iput-object v8, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->fileAction Ljava/lang/String;
    iput-object v9, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->conversationId Ljava/lang/String;
    iput-object v10, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->messageId Ljava/lang/String;
    iput-object v11, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliConversationId Ljava/lang/String;
    iput-object v12, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliType Ljava/lang/String;
    iput-object v13, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->turnId Ljava/lang/String;
    return-void 
.end method

.method public constructor <init>(java.lang.String  com.bytedance.trae.kmp.artifacts.artifact.ArtifactKind  java.lang.String  java.lang.String  int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 13
    # ins_size=12
    const-string v0, "artifactId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "kind"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "filePath"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliConversationId"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->artifactId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->kind Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;
    iput-object v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->filePath Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->lastFrameUri Ljava/lang/String;
    iput v6, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->durationSeconds I
    iput-object v7, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->fileAction Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->conversationId Ljava/lang/String;
    iput-object v9, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->messageId Ljava/lang/String;
    iput-object v10, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliConversationId Ljava/lang/String;
    iput-object v11, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliType Ljava/lang/String;
    iput-object v12, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->turnId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$get$childSerializers$cp()kotlinx.serialization.KSerializer[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->$childSerializers [Lkotlinx/serialization/KSerializer;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest  java.lang.String  com.bytedance.trae.kmp.artifacts.artifact.ArtifactKind  java.lang.String  java.lang.String  int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest
    .registers 26
    # ins_size=14
    move-object v0, v12
    move/from16 v1, v24
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->artifactId Ljava/lang/String;
    goto +2h
    move-object v2, v13
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->kind Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;
    goto +2h
    move-object v3, v14
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->filePath Ljava/lang/String;
    goto +2h
    move-object v4, v15
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->lastFrameUri Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v16
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->durationSeconds I
    goto +3h
    move/from16 v6, v17
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->fileAction Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v18
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->conversationId Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v19
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->messageId Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v20
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliConversationId Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v21
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliType Ljava/lang/String;
    goto +3h
    move-object/from16 v11, v22
    and-int/lit16 v1, v1, 1024
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->turnId Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v23
    move-object v13, v2
    move-object v14, v3
    move-object v15, v4
    move-object/from16 v16, v5
    move/from16 v17, v6
    move-object/from16 v18, v7
    move-object/from16 v19, v8
    move-object/from16 v20, v9
    move-object/from16 v21, v10
    move-object/from16 v22, v11
    move-object/from16 v23, v1
    invoke-virtual/range v12 ... v23, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->copy(Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic write$Self$artifacts_mainlandRelease(com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 6
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->$childSerializers [Lkotlinx/serialization/KSerializer;
    const/4 v1, 0
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->artifactId Ljava/lang/String;
    invoke-interface v4, v5, v1, v2, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    const/4 v1, 1
    aget-object v0, v0, v1
    check-cast v0, Lkotlinx/serialization/SerializationStrategy;
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->kind Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;
    invoke-interface v4, v5, v1, v0, v2, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    const/4 v0, 2
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->filePath Ljava/lang/String;
    invoke-interface v4, v5, v0, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    sget-object v0, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v0, Lkotlinx/serialization/SerializationStrategy;
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->lastFrameUri Ljava/lang/String;
    const/4 v2, 3
    invoke-interface v4, v5, v2, v0, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    const/4 v0, 4
    iget v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->durationSeconds I
    invoke-interface v4, v5, v0, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeIntElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I I)V
    sget-object v0, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v0, Lkotlinx/serialization/SerializationStrategy;
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->fileAction Ljava/lang/String;
    const/4 v2, 5
    invoke-interface v4, v5, v2, v0, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    const/4 v0, 6
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->conversationId Ljava/lang/String;
    invoke-interface v4, v5, v0, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    const/4 v0, 7
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->messageId Ljava/lang/String;
    invoke-interface v4, v5, v0, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    const/16 v0, 8
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliConversationId Ljava/lang/String;
    invoke-interface v4, v5, v0, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    const/16 v0, 9
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliType Ljava/lang/String;
    invoke-interface v4, v5, v0, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    sget-object v0, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v0, Lkotlinx/serialization/SerializationStrategy;
    iget-object v3, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->turnId Ljava/lang/String;
    const/16 v1, 10
    invoke-interface v4, v5, v1, v0, v3, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    return-void 
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->artifactId Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliType Ljava/lang/String;
    return-object v0
.end method

.method public final component11()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->turnId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.kmp.artifacts.artifact.ArtifactKind
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->kind Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->filePath Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->lastFrameUri Ljava/lang/String;
    return-object v0
.end method

.method public final component5()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->durationSeconds I
    return v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->fileAction Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  com.bytedance.trae.kmp.artifacts.artifact.ArtifactKind  java.lang.String  java.lang.String  int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest
    .registers 25
    # ins_size=12
    const-string v0, "artifactId"
    move-object v2, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "kind"
    move-object v3, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "filePath"
    move-object/from16 v4, v16
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    move-object/from16 v8, v20
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    move-object/from16 v9, v21
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliConversationId"
    move-object/from16 v10, v22
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    move-object/from16 v11, v23
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    move-object v1, v0
    move-object/from16 v5, v17
    move/from16 v6, v18
    move-object/from16 v7, v19
    move-object/from16 v12, v24
    invoke-direct/range v1 ... v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;-><init>(Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->artifactId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->artifactId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->kind Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->kind Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->filePath Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->filePath Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->lastFrameUri Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->lastFrameUri Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->durationSeconds I
    iget v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->durationSeconds I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->fileAction Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->fileAction Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->conversationId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->conversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->messageId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->messageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliConversationId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliConversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->turnId Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->turnId Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getArtifactId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->artifactId Ljava/lang/String;
    return-object v0
.end method

.method public final getCliConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getCliType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliType Ljava/lang/String;
    return-object v0
.end method

.method public final getConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getDurationSeconds()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->durationSeconds I
    return v0
.end method

.method public final getFileAction()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->fileAction Ljava/lang/String;
    return-object v0
.end method

.method public final getFilePath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->filePath Ljava/lang/String;
    return-object v0
.end method

.method public final getKind()com.bytedance.trae.kmp.artifacts.artifact.ArtifactKind
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->kind Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;
    return-object v0
.end method

.method public final getLastFrameUri()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->lastFrameUri Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final getSource()com.bytedance.trae.kmp.artifacts.artifact.ArtifactSource
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliType Ljava/lang/String;
    const-string/jumbo v1, remote
    const/4 v2, 1
    invoke-static v0, v1, v2, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->Remote Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->Local Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    return-object v0
.end method

.method public final getTitle()java.lang.String
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->filePath Ljava/lang/String;
    const/4 v1, 0
    const/4 v2, 2
    const/16 v3, 47
    invoke-static v0, v3, v1, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +004h
    iget-object v0, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->filePath Ljava/lang/String;
    check-cast v0, Ljava/lang/String;
    return-object v0
.end method

.method public final getTurnId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->turnId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->artifactId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->kind Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->filePath Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->lastFrameUri Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->durationSeconds I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->fileAction Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->conversationId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->messageId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliConversationId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliType Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->turnId Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ArtifactOpenRequest(artifactId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->artifactId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", kind="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->kind Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", filePath="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->filePath Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", lastFrameUri="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->lastFrameUri Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", durationSeconds="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->durationSeconds I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", fileAction="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->fileAction Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", conversationId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->conversationId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", messageId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->messageId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cliConversationId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliConversationId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cliType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->cliType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", turnId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->turnId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
