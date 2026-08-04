# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.implements Lkotlinx/serialization/internal/GeneratedSerializer;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;
.field private static final descriptor:Lkotlinx/serialization/descriptors/SerialDescriptor;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;
    const/16 v1, 8
    sput v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;->$stable I
    new-instance v1, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;
    check-cast v0, Lkotlinx/serialization/internal/GeneratedSerializer;
    const/16 v2, 11
    const-string v3, "com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest"
    invoke-direct v1, v3, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;-><init>(Ljava/lang/String; Lkotlinx/serialization/internal/GeneratedSerializer; I)V
    const-string v0, "artifactId"
    const/4 v2, 0
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "kind"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "filePath"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "lastFrameUri"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "durationSeconds"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "fileAction"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "conversationId"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "messageId"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "cliConversationId"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "cliType"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string/jumbo v0, turnId
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    check-cast v1, Lkotlinx/serialization/descriptors/SerialDescriptor;
    sput-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final childSerializers()kotlinx.serialization.KSerializer[]
    .registers 5
    # ins_size=1
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->access$get$childSerializers$cp()[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    const/16 v1, 11
    new-array v1, v1, [Lkotlinx/serialization/KSerializer;
    const/4 v2, 0
    sget-object v3, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v3, v1, v2
    const/4 v2, 1
    aget-object v0, v0, v2
    aput-object v0, v1, v2
    const/4 v0, 2
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v2, v1, v0
    sget-object v0, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v0, Lkotlinx/serialization/KSerializer;
    invoke-static v0, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v0
    const/4 v2, 3
    aput-object v0, v1, v2
    const/4 v0, 4
    sget-object v2, Lkotlinx/serialization/internal/IntSerializer;->INSTANCE Lkotlinx/serialization/internal/IntSerializer;
    aput-object v2, v1, v0
    sget-object v0, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v0, Lkotlinx/serialization/KSerializer;
    invoke-static v0, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v0
    const/4 v2, 5
    aput-object v0, v1, v2
    const/4 v0, 6
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v2, v1, v0
    const/4 v0, 7
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v2, v1, v0
    const/16 v0, 8
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v2, v1, v0
    const/16 v0, 9
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v2, v1, v0
    sget-object v0, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v0, Lkotlinx/serialization/KSerializer;
    invoke-static v0, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v0
    const/16 v2, 10
    aput-object v0, v1, v2
    return-object v1
.end method

.method public final deserialize(kotlinx.serialization.encoding.Decoder)com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest
    .registers 30
    # ins_size=2
    move-object/from16 v0, v29
    const-string v1, "decoder"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v0, v1, Lkotlinx/serialization/encoding/Decoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;
    move-result-object v0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->access$get$childSerializers$cp()[Lkotlinx/serialization/KSerializer;
    move-result-object v2
    invoke-interface v0, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSequentially()Z
    move-result v3
    const/16 v4, 10
    const/16 v5, 9
    const/4 v6, 7
    const/4 v7, 6
    const/4 v8, 5
    const/4 v9, 3
    const/16 v10, 8
    const/4 v11, 4
    const/4 v12, 2
    const/4 v13, 1
    const/4 v14, 0
    const/4 v15, 0
    if-eqz v3, +05eh
    invoke-interface v0, v1, v14, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v3
    aget-object v2, v2, v13
    check-cast v2, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v13, v2, v15, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;
    invoke-interface v0, v1, v12, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v12
    sget-object v13, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v13, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v9, v13, v15, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/String;
    invoke-interface v0, v1, v11, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeIntElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)I
    move-result v11
    sget-object v13, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v13, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v8, v13, v15, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/String;
    invoke-interface v0, v1, v7, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v7
    invoke-interface v0, v1, v6, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v6
    invoke-interface v0, v1, v10, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v10
    invoke-interface v0, v1, v5, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v5
    sget-object v13, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v13, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v4, v13, v15, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    const/16 v13, 2047
    move-object v15, v2
    move-object v14, v3
    move-object/from16 v24, v4
    move-object/from16 v23, v5
    move-object/from16 v21, v6
    move-object/from16 v20, v7
    move-object/from16 v19, v8
    move-object/from16 v17, v9
    move-object/from16 v22, v10
    move/from16 v18, v11
    move-object/from16 v16, v12
    goto/16 +0b9h
    move/from16 v25, v13
    move v3, v14
    move-object v9, v15
    move-object v12, v9
    move-object v13, v12
    move-object/from16 v16, v13
    move-object/from16 v17, v16
    move-object/from16 v20, v17
    move-object/from16 v21, v20
    move-object/from16 v22, v21
    move-object/from16 v23, v22
    move-object/from16 v14, v23
    move v15, v3
    if-eqz v25, +092h
    invoke-interface v0, v1, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeElementIndex(Lkotlinx/serialization/descriptors/SerialDescriptor;)I
    move-result v11
    packed-switch v11, +00000a9h
    new-instance v0, Lkotlinx/serialization/UnknownFieldException;
    invoke-direct v0, v11, Lkotlinx/serialization/UnknownFieldException;-><init>(I)V
    throw v0
    sget-object v11, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v11, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v4, v11, v9, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/String;
    or-int/lit16 v15, v15, 1024
    goto +2ah
    invoke-interface v0, v1, v5, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v23
    or-int/lit16 v15, v15, 512
    goto +23h
    invoke-interface v0, v1, v10, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v22
    or-int/lit16 v15, v15, 256
    goto +1ch
    invoke-interface v0, v1, v6, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v21
    or-int/lit16 v15, v15, 128
    goto +15h
    invoke-interface v0, v1, v7, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v20
    or-int/lit8 v15, v15, 64
    goto +eh
    sget-object v11, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v11, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v8, v11, v12, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    move-object v12, v11
    check-cast v12, Ljava/lang/String;
    or-int/lit8 v15, v15, 32
    const/4 v11, 4
    goto -46h
    const/4 v11, 4
    invoke-interface v0, v1, v11, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeIntElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)I
    move-result v3
    or-int/lit8 v15, v15, 16
    goto -4eh
    const/4 v11, 4
    sget-object v26, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    move-object/from16 v4, v26
    check-cast v4, Lkotlinx/serialization/DeserializationStrategy;
    const/4 v5, 3
    invoke-interface v0, v1, v5, v4, v13, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    move-object v13, v4
    check-cast v13, Ljava/lang/String;
    or-int/lit8 v15, v15, 8
    goto +27h
    const/4 v4, 2
    const/4 v5, 3
    const/4 v11, 4
    invoke-interface v0, v1, v4, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v17
    or-int/lit8 v15, v15, 4
    goto +1dh
    const/4 v4, 1
    const/4 v5, 3
    const/4 v11, 4
    aget-object v18, v2, v4
    move-object/from16 v5, v18
    check-cast v5, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v4, v5, v14, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    move-object v14, v5
    check-cast v14, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;
    or-int/lit8 v15, v15, 2
    goto +ah
    const/4 v4, 1
    const/4 v5, 0
    const/4 v11, 4
    invoke-interface v0, v1, v5, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v16
    or-int/lit8 v15, v15, 1
    const/16 v4, 10
    goto +5h
    const/4 v5, 0
    const/4 v11, 4
    move/from16 v25, v5
    const/16 v5, 9
    goto/16 -090h
    move/from16 v18, v3
    move-object/from16 v24, v9
    move-object/from16 v19, v12
    move-object/from16 v27, v17
    move-object/from16 v17, v13
    move v13, v15
    move-object v15, v14
    move-object/from16 v14, v16
    move-object/from16 v16, v27
    invoke-interface v0, v1, Lkotlinx/serialization/encoding/CompositeDecoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    const/16 v25, 0
    move-object v12, v0
    invoke-direct/range v12 ... v25, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;-><init>(I Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/serialization/internal/SerializationConstructorMarker;)V
    return-object v0
    nop 
    packed-switch-payload -1 0 1 2 3 4 5 6 7 8 9 a
.end method

.method public bridge synthetic deserialize(kotlinx.serialization.encoding.Decoder)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;->deserialize(Lkotlinx/serialization/encoding/Decoder;)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    move-result-object v1
    return-object v1
.end method

.method public final getDescriptor()kotlinx.serialization.descriptors.SerialDescriptor
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-object v0
.end method

.method public final serialize(kotlinx.serialization.encoding.Encoder  com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest)void
    .registers 4
    # ins_size=3
    const-string v0, "encoder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/Encoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;
    move-result-object v2
    invoke-static v3, v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->write$Self$artifacts_mainlandRelease(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest; Lkotlinx/serialization/encoding/CompositeEncoder; Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    return-void 
.end method

.method public bridge synthetic serialize(kotlinx.serialization.encoding.Encoder  java.lang.Object)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$$serializer;->serialize(Lkotlinx/serialization/encoding/Encoder; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;)V
    return-void 
.end method

.method public typeParametersSerializers()kotlinx.serialization.KSerializer[]
    .registers 2
    # ins_size=1
    invoke-static v1, Lkotlinx/serialization/internal/GeneratedSerializer$DefaultImpls;->typeParametersSerializers(Lkotlinx/serialization/internal/GeneratedSerializer;)[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    return-object v0
.end method
