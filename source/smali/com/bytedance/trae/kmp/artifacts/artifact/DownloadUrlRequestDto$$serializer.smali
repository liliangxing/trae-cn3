# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.implements Lkotlinx/serialization/internal/GeneratedSerializer;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;
.field private static final descriptor:Lkotlinx/serialization/descriptors/SerialDescriptor;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;
    const/16 v1, 8
    sput v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;->$stable I
    new-instance v1, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;
    check-cast v0, Lkotlinx/serialization/internal/GeneratedSerializer;
    const/4 v2, 4
    const-string v3, "com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlRequestDto"
    invoke-direct v1, v3, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;-><init>(Ljava/lang/String; Lkotlinx/serialization/internal/GeneratedSerializer; I)V
    const-string/jumbo v0, targets
    const/4 v2, 0
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "conversation_id"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "message_id"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "check_exist"
    const/4 v2, 1
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    check-cast v1, Lkotlinx/serialization/descriptors/SerialDescriptor;
    sput-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final childSerializers()kotlinx.serialization.KSerializer[]
    .registers 4
    # ins_size=1
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->access$get$childSerializers$cp()[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    const/4 v1, 4
    new-array v1, v1, [Lkotlinx/serialization/KSerializer;
    const/4 v2, 0
    aget-object v0, v0, v2
    aput-object v0, v1, v2
    const/4 v0, 1
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v2, v1, v0
    const/4 v0, 2
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v2, v1, v0
    const/4 v0, 3
    sget-object v2, Lkotlinx/serialization/internal/BooleanSerializer;->INSTANCE Lkotlinx/serialization/internal/BooleanSerializer;
    aput-object v2, v1, v0
    return-object v1
.end method

.method public final deserialize(kotlinx.serialization.encoding.Decoder)com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlRequestDto
    .registers 22
    # ins_size=2
    move-object/from16 v0, v21
    const-string v1, "decoder"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v0, v1, Lkotlinx/serialization/encoding/Decoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;
    move-result-object v0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->access$get$childSerializers$cp()[Lkotlinx/serialization/KSerializer;
    move-result-object v2
    invoke-interface v0, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSequentially()Z
    move-result v3
    const/4 v4, 3
    const/4 v5, 2
    const/4 v6, 1
    const/4 v7, 0
    const/4 v8, 0
    if-eqz v3, +023h
    aget-object v2, v2, v7
    check-cast v2, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v7, v2, v8, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    invoke-interface v0, v1, v6, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v3
    invoke-interface v0, v1, v5, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v5
    invoke-interface v0, v1, v4, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeBooleanElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v4
    const/16 v6, 15
    move-object v15, v2
    move-object/from16 v16, v3
    move/from16 v18, v4
    move-object/from16 v17, v5
    move v14, v6
    goto +4ah
    move v12, v6
    move v3, v7
    move-object v9, v8
    move-object v10, v9
    move-object v11, v10
    move v8, v3
    if-eqz v12, +03bh
    invoke-interface v0, v1, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeElementIndex(Lkotlinx/serialization/descriptors/SerialDescriptor;)I
    move-result v13
    const/4 v14, -1
    if-eq v13, v14, +032h
    if-eqz v13, +023h
    if-eq v13, v6, +01ah
    if-eq v13, v5, +011h
    if-ne v13, v4, +009h
    invoke-interface v0, v1, v4, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeBooleanElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v3
    or-int/lit8 v8, v8, 8
    goto -17h
    new-instance v0, Lkotlinx/serialization/UnknownFieldException;
    invoke-direct v0, v13, Lkotlinx/serialization/UnknownFieldException;-><init>(I)V
    throw v0
    invoke-interface v0, v1, v5, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v11
    or-int/lit8 v8, v8, 4
    goto -24h
    invoke-interface v0, v1, v6, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v10
    or-int/lit8 v8, v8, 2
    goto -2bh
    aget-object v13, v2, v7
    check-cast v13, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v7, v13, v9, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/util/List;
    or-int/lit8 v8, v8, 1
    goto -38h
    move v12, v7
    goto -3ah
    move/from16 v18, v3
    move v14, v8
    move-object v15, v9
    move-object/from16 v16, v10
    move-object/from16 v17, v11
    invoke-interface v0, v1, Lkotlinx/serialization/encoding/CompositeDecoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;
    const/16 v19, 0
    move-object v13, v0
    invoke-direct/range v13 ... v19, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;-><init>(I Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Z Lkotlinx/serialization/internal/SerializationConstructorMarker;)V
    return-object v0
.end method

.method public bridge synthetic deserialize(kotlinx.serialization.encoding.Decoder)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;->deserialize(Lkotlinx/serialization/encoding/Decoder;)Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;
    move-result-object v1
    return-object v1
.end method

.method public final getDescriptor()kotlinx.serialization.descriptors.SerialDescriptor
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-object v0
.end method

.method public final serialize(kotlinx.serialization.encoding.Encoder  com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlRequestDto)void
    .registers 4
    # ins_size=3
    const-string v0, "encoder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/Encoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;
    move-result-object v2
    invoke-static v3, v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;->write$Self$artifacts_mainlandRelease(Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto; Lkotlinx/serialization/encoding/CompositeEncoder; Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    return-void 
.end method

.method public bridge synthetic serialize(kotlinx.serialization.encoding.Encoder  java.lang.Object)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto$$serializer;->serialize(Lkotlinx/serialization/encoding/Encoder; Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;)V
    return-void 
.end method

.method public typeParametersSerializers()kotlinx.serialization.KSerializer[]
    .registers 2
    # ins_size=1
    invoke-static v1, Lkotlinx/serialization/internal/GeneratedSerializer$DefaultImpls;->typeParametersSerializers(Lkotlinx/serialization/internal/GeneratedSerializer;)[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    return-object v0
.end method
