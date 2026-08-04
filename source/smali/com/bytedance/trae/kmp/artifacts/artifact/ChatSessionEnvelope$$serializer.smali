# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$$serializer;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.implements Lkotlinx/serialization/internal/GeneratedSerializer;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$$serializer;
.field private static final descriptor:Lkotlinx/serialization/descriptors/SerialDescriptor;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$$serializer;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$$serializer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$$serializer;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$$serializer;
    const/16 v1, 8
    sput v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$$serializer;->$stable I
    new-instance v1, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;
    check-cast v0, Lkotlinx/serialization/internal/GeneratedSerializer;
    const/4 v2, 2
    const-string v3, "com.bytedance.trae.kmp.artifacts.artifact.ChatSessionEnvelope"
    invoke-direct v1, v3, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;-><init>(Ljava/lang/String; Lkotlinx/serialization/internal/GeneratedSerializer; I)V
    const-string v0, "code"
    const/4 v2, 0
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "data"
    const/4 v2, 1
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    check-cast v1, Lkotlinx/serialization/descriptors/SerialDescriptor;
    sput-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
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
    const/4 v0, 2
    new-array v0, v0, [Lkotlinx/serialization/KSerializer;
    const/4 v1, 0
    sget-object v2, Lkotlinx/serialization/internal/LongSerializer;->INSTANCE Lkotlinx/serialization/internal/LongSerializer;
    aput-object v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto$$serializer;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto$$serializer;
    check-cast v1, Lkotlinx/serialization/KSerializer;
    invoke-static v1, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v1
    const/4 v2, 1
    aput-object v1, v0, v2
    return-object v0
.end method

.method public final deserialize(kotlinx.serialization.encoding.Decoder)com.bytedance.trae.kmp.artifacts.artifact.ChatSessionEnvelope
    .registers 16
    # ins_size=2
    const-string v0, "decoder"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v15, v0, Lkotlinx/serialization/encoding/Decoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;
    move-result-object v15
    invoke-interface v15, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSequentially()Z
    move-result v1
    const/4 v2, 1
    const/4 v3, 0
    const/4 v4, 0
    if-eqz v1, +014h
    invoke-interface v15, v0, v3, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeLongElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)J
    move-result-wide v5
    sget-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto$$serializer;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto$$serializer;
    check-cast v1, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v15, v0, v2, v1, v4, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;
    const/4 v2, 3
    move-object v12, v1
    move v9, v2
    goto +30h
    const-wide/16 v5, 0
    move v7, v2
    move v1, v3
    if-eqz v7, +029h
    invoke-interface v15, v0, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeElementIndex(Lkotlinx/serialization/descriptors/SerialDescriptor;)I
    move-result v8
    const/4 v9, -1
    if-eq v8, v9, +020h
    if-eqz v8, +017h
    if-ne v8, v2, +00fh
    sget-object v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto$$serializer;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto$$serializer;
    check-cast v8, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v15, v0, v2, v8, v4, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;
    or-int/lit8 v1, v1, 2
    goto -19h
    new-instance v15, Lkotlinx/serialization/UnknownFieldException;
    invoke-direct v15, v8, Lkotlinx/serialization/UnknownFieldException;-><init>(I)V
    throw v15
    invoke-interface v15, v0, v3, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeLongElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)J
    move-result-wide v5
    or-int/lit8 v1, v1, 1
    goto -26h
    move v7, v3
    goto -28h
    move v9, v1
    move-object v12, v4
    move-wide v10, v5
    invoke-interface v15, v0, Lkotlinx/serialization/encoding/CompositeDecoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    new-instance v15, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope;
    const/4 v13, 0
    move-object v8, v15
    invoke-direct/range v8 ... v13, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope;-><init>(I J Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto; Lkotlinx/serialization/internal/SerializationConstructorMarker;)V
    return-object v15
.end method

.method public bridge synthetic deserialize(kotlinx.serialization.encoding.Decoder)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$$serializer;->deserialize(Lkotlinx/serialization/encoding/Decoder;)Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope;
    move-result-object v1
    return-object v1
.end method

.method public final getDescriptor()kotlinx.serialization.descriptors.SerialDescriptor
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-object v0
.end method

.method public final serialize(kotlinx.serialization.encoding.Encoder  com.bytedance.trae.kmp.artifacts.artifact.ChatSessionEnvelope)void
    .registers 4
    # ins_size=3
    const-string v0, "encoder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/Encoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;
    move-result-object v2
    invoke-static v3, v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope;->write$Self$artifacts_mainlandRelease(Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope; Lkotlinx/serialization/encoding/CompositeEncoder; Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    return-void 
.end method

.method public bridge synthetic serialize(kotlinx.serialization.encoding.Encoder  java.lang.Object)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope$$serializer;->serialize(Lkotlinx/serialization/encoding/Encoder; Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionEnvelope;)V
    return-void 
.end method

.method public typeParametersSerializers()kotlinx.serialization.KSerializer[]
    .registers 2
    # ins_size=1
    invoke-static v1, Lkotlinx/serialization/internal/GeneratedSerializer$DefaultImpls;->typeParametersSerializers(Lkotlinx/serialization/internal/GeneratedSerializer;)[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    return-object v0
.end method
