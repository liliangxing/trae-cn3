# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;
.super Ljava/lang/Object;
.source "KmpBusinessResponse.kt"

.implements Lkotlinx/serialization/internal/GeneratedSerializer;

.field public static final $stable:I
.field private final descriptor:Lkotlinx/serialization/descriptors/SerialDescriptor;
.field private final synthetic typeSerial0:Lkotlinx/serialization/KSerializer;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method private constructor <init>()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Ljava/lang/Object;-><init>()V
    new-instance v0, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;
    move-object v1, v4
    check-cast v1, Lkotlinx/serialization/internal/GeneratedSerializer;
    const/4 v2, 4
    const-string v3, "com.bytedance.trae.kmp.network.KmpBusinessResponse"
    invoke-direct v0, v3, v1, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;-><init>(Ljava/lang/String; Lkotlinx/serialization/internal/GeneratedSerializer; I)V
    const-string v1, "code"
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v1, "msg"
    invoke-virtual v0, v1, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v1, "message"
    invoke-virtual v0, v1, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v1, "data"
    invoke-virtual v0, v1, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    check-cast v0, Lkotlinx/serialization/descriptors/SerialDescriptor;
    iput-object v0, v4, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-void 
.end method

.method public constructor <init>(kotlinx.serialization.KSerializer)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, typeSerial0
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;->typeSerial0 Lkotlinx/serialization/KSerializer;
    return-void 
.end method

.method private final synthetic getTypeSerial0()kotlinx.serialization.KSerializer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;->typeSerial0 Lkotlinx/serialization/KSerializer;
    return-object v0
.end method

.method public final childSerializers()kotlinx.serialization.KSerializer[]
    .registers 4
    # ins_size=1
    const/4 v0, 4
    new-array v0, v0, [Lkotlinx/serialization/KSerializer;
    const/4 v1, 0
    sget-object v2, Lkotlinx/serialization/internal/LongSerializer;->INSTANCE Lkotlinx/serialization/internal/LongSerializer;
    aput-object v2, v0, v1
    sget-object v1, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v1, Lkotlinx/serialization/KSerializer;
    invoke-static v1, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v1
    const/4 v2, 1
    aput-object v1, v0, v2
    sget-object v1, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v1, Lkotlinx/serialization/KSerializer;
    invoke-static v1, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v1
    const/4 v2, 2
    aput-object v1, v0, v2
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;->typeSerial0 Lkotlinx/serialization/KSerializer;
    invoke-static v1, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v1
    const/4 v2, 3
    aput-object v1, v0, v2
    return-object v0
.end method

.method public final deserialize(kotlinx.serialization.encoding.Decoder)com.bytedance.trae.kmp.network.KmpBusinessResponse
    .registers 24
    # ins_size=2
    move-object/from16 v0, v22
    move-object/from16 v1, v23
    const-string v2, "decoder"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v1, v2, Lkotlinx/serialization/encoding/Decoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;
    move-result-object v1
    invoke-interface v1, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSequentially()Z
    move-result v3
    const/4 v4, 3
    const/4 v5, 2
    const/4 v6, 1
    const/4 v7, 0
    const/4 v8, 0
    if-eqz v3, +02eh
    invoke-interface v1, v2, v7, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeLongElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)J
    move-result-wide v9
    sget-object v3, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v3, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v1, v2, v6, v3, v8, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    sget-object v6, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v6, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v1, v2, v5, v6, v8, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    iget-object v6, v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;->typeSerial0 Lkotlinx/serialization/KSerializer;
    check-cast v6, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v1, v2, v4, v6, v8, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    const/16 v6, 15
    move-object/from16 v18, v3
    move-object/from16 v20, v4
    move-object/from16 v19, v5
    move v15, v6
    move-wide/from16 v16, v9
    goto +56h
    const-wide/16 v9, 0
    move v13, v6
    move v3, v7
    move-wide v11, v9
    move-object v9, v8
    move-object v10, v9
    if-eqz v13, +045h
    invoke-interface v1, v2, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeElementIndex(Lkotlinx/serialization/descriptors/SerialDescriptor;)I
    move-result v14
    const/4 v15, -1
    if-eq v14, v15, +03ch
    if-eqz v14, +033h
    if-eq v14, v6, +024h
    if-eq v14, v5, +015h
    if-ne v14, v4, +00dh
    iget-object v14, v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;->typeSerial0 Lkotlinx/serialization/KSerializer;
    check-cast v14, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v1, v2, v4, v14, v10, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    or-int/lit8 v3, v3, 8
    goto -1bh
    new-instance v1, Lkotlinx/serialization/UnknownFieldException;
    invoke-direct v1, v14, Lkotlinx/serialization/UnknownFieldException;-><init>(I)V
    throw v1
    sget-object v14, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v14, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v1, v2, v5, v14, v9, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/String;
    or-int/lit8 v3, v3, 4
    goto -2eh
    sget-object v14, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v14, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v1, v2, v6, v14, v8, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/String;
    or-int/lit8 v3, v3, 2
    goto -3bh
    invoke-interface v1, v2, v7, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeLongElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)J
    move-result-wide v11
    or-int/lit8 v3, v3, 1
    goto -42h
    move v13, v7
    goto -44h
    move v15, v3
    move-object/from16 v18, v8
    move-object/from16 v19, v9
    move-object/from16 v20, v10
    move-wide/from16 v16, v11
    invoke-interface v1, v2, Lkotlinx/serialization/encoding/CompositeDecoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    new-instance v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;
    const/16 v21, 0
    move-object v14, v1
    invoke-direct/range v14 ... v21, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;-><init>(I J Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Lkotlinx/serialization/internal/SerializationConstructorMarker;)V
    return-object v1
.end method

.method public bridge synthetic deserialize(kotlinx.serialization.encoding.Decoder)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;->deserialize(Lkotlinx/serialization/encoding/Decoder;)Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;
    move-result-object v1
    return-object v1
.end method

.method public final getDescriptor()kotlinx.serialization.descriptors.SerialDescriptor
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-object v0
.end method

.method public final serialize(kotlinx.serialization.encoding.Encoder  com.bytedance.trae.kmp.network.KmpBusinessResponse)void
    .registers 5
    # ins_size=3
    const-string v0, "encoder"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v3, v0, Lkotlinx/serialization/encoding/Encoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;
    move-result-object v3
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;->typeSerial0 Lkotlinx/serialization/KSerializer;
    invoke-static v4, v3, v0, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->write$Self$base_mainlandRelease(Lcom/bytedance/trae/kmp/network/KmpBusinessResponse; Lkotlinx/serialization/encoding/CompositeEncoder; Lkotlinx/serialization/descriptors/SerialDescriptor; Lkotlinx/serialization/KSerializer;)V
    invoke-interface v3, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    return-void 
.end method

.method public bridge synthetic serialize(kotlinx.serialization.encoding.Encoder  java.lang.Object)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;->serialize(Lkotlinx/serialization/encoding/Encoder; Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;)V
    return-void 
.end method

.method public final typeParametersSerializers()kotlinx.serialization.KSerializer[]
    .registers 4
    # ins_size=1
    const/4 v0, 1
    new-array v0, v0, [Lkotlinx/serialization/KSerializer;
    const/4 v1, 0
    iget-object v2, v3, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;->typeSerial0 Lkotlinx/serialization/KSerializer;
    aput-object v2, v0, v1
    return-object v0
.end method
