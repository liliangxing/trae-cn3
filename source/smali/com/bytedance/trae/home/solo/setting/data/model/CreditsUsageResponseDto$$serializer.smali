# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;
.super Ljava/lang/Object;
.source "SettingsNetworkModels.kt"

.implements Lkotlinx/serialization/internal/GeneratedSerializer;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;
.field private static final descriptor:Lkotlinx/serialization/descriptors/SerialDescriptor;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;
    const/16 v1, 8
    sput v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;->$stable I
    new-instance v1, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;
    check-cast v0, Lkotlinx/serialization/internal/GeneratedSerializer;
    const/4 v2, 5
    const-string v3, "com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto"
    invoke-direct v1, v3, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;-><init>(Ljava/lang/String; Lkotlinx/serialization/internal/GeneratedSerializer; I)V
    const-string v0, "code"
    const/4 v2, 1
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "msg"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "message"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string/jumbo v0, user_entitlement_pack_list
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "data"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    check-cast v1, Lkotlinx/serialization/descriptors/SerialDescriptor;
    sput-object v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
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
    invoke-static Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->access$get$childSerializers$cp()[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    const/4 v1, 5
    new-array v1, v1, [Lkotlinx/serialization/KSerializer;
    sget-object v2, Lkotlinx/serialization/internal/LongSerializer;->INSTANCE Lkotlinx/serialization/internal/LongSerializer;
    check-cast v2, Lkotlinx/serialization/KSerializer;
    invoke-static v2, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v2
    const/4 v3, 0
    aput-object v2, v1, v3
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v2, Lkotlinx/serialization/KSerializer;
    invoke-static v2, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v2
    const/4 v3, 1
    aput-object v2, v1, v3
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v2, Lkotlinx/serialization/KSerializer;
    invoke-static v2, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v2
    const/4 v3, 2
    aput-object v2, v1, v3
    const/4 v2, 3
    aget-object v0, v0, v2
    invoke-static v0, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v0
    aput-object v0, v1, v2
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;
    check-cast v0, Lkotlinx/serialization/KSerializer;
    invoke-static v0, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v0
    const/4 v2, 4
    aput-object v0, v1, v2
    return-object v1
.end method

.method public final deserialize(kotlinx.serialization.encoding.Decoder)com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto
    .registers 26
    # ins_size=2
    move-object/from16 v0, v25
    const-string v1, "decoder"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v0, v1, Lkotlinx/serialization/encoding/Decoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;
    move-result-object v0
    invoke-static Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->access$get$childSerializers$cp()[Lkotlinx/serialization/KSerializer;
    move-result-object v2
    invoke-interface v0, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSequentially()Z
    move-result v3
    const/4 v4, 4
    const/4 v5, 2
    const/4 v6, 3
    const/4 v7, 1
    const/4 v8, 0
    const/4 v9, 0
    if-eqz v3, +044h
    sget-object v3, Lkotlinx/serialization/internal/LongSerializer;->INSTANCE Lkotlinx/serialization/internal/LongSerializer;
    check-cast v3, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v8, v3, v9, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Long;
    sget-object v8, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v8, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v7, v8, v9, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    sget-object v8, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v8, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v5, v8, v9, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    aget-object v2, v2, v6
    check-cast v2, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v6, v2, v9, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;
    check-cast v6, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v4, v6, v9, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    const/16 v6, 31
    move-object/from16 v21, v2
    move-object/from16 v18, v3
    move-object/from16 v22, v4
    move-object/from16 v20, v5
    move/from16 v17, v6
    move-object/from16 v19, v7
    goto/16 +07ah
    move v14, v7
    move v3, v8
    move-object v10, v9
    move-object v11, v10
    move-object v12, v11
    move-object v13, v12
    if-eqz v14, +066h
    invoke-interface v0, v1, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeElementIndex(Lkotlinx/serialization/descriptors/SerialDescriptor;)I
    move-result v15
    const/4 v8, -1
    if-eq v15, v8, +05bh
    if-eqz v15, +049h
    if-eq v15, v7, +038h
    if-eq v15, v5, +028h
    if-eq v15, v6, +018h
    if-ne v15, v4, +010h
    sget-object v8, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;
    check-cast v8, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v4, v8, v13, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    move-object v13, v8
    check-cast v13, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    or-int/lit8 v3, v3, 16
    goto +30h
    new-instance v0, Lkotlinx/serialization/UnknownFieldException;
    invoke-direct v0, v15, Lkotlinx/serialization/UnknownFieldException;-><init>(I)V
    throw v0
    aget-object v8, v2, v6
    check-cast v8, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v6, v8, v12, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    move-object v12, v8
    check-cast v12, Ljava/util/List;
    or-int/lit8 v3, v3, 8
    goto +1ch
    sget-object v8, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v8, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v5, v8, v11, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    move-object v11, v8
    check-cast v11, Ljava/lang/String;
    or-int/lit8 v3, v3, 4
    goto +eh
    sget-object v8, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v8, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v0, v1, v7, v8, v10, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    move-object v10, v8
    check-cast v10, Ljava/lang/String;
    or-int/lit8 v3, v3, 2
    const/4 v8, 0
    goto -51h
    sget-object v8, Lkotlinx/serialization/internal/LongSerializer;->INSTANCE Lkotlinx/serialization/internal/LongSerializer;
    check-cast v8, Lkotlinx/serialization/DeserializationStrategy;
    const/4 v15, 0
    invoke-interface v0, v1, v15, v8, v9, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    move-object v9, v8
    check-cast v9, Ljava/lang/Long;
    or-int/lit8 v3, v3, 1
    move v8, v15
    goto -61h
    const/4 v15, 0
    move v8, v15
    move v14, v8
    goto -65h
    move/from16 v17, v3
    move-object/from16 v18, v9
    move-object/from16 v19, v10
    move-object/from16 v20, v11
    move-object/from16 v21, v12
    move-object/from16 v22, v13
    invoke-interface v0, v1, Lkotlinx/serialization/encoding/CompositeDecoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;
    const/16 v23, 0
    move-object/from16 v16, v0
    invoke-direct/range v16 ... v23, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;-><init>(I Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto; Lkotlinx/serialization/internal/SerializationConstructorMarker;)V
    return-object v0
.end method

.method public bridge synthetic deserialize(kotlinx.serialization.encoding.Decoder)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;->deserialize(Lkotlinx/serialization/encoding/Decoder;)Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;
    move-result-object v1
    return-object v1
.end method

.method public final getDescriptor()kotlinx.serialization.descriptors.SerialDescriptor
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-object v0
.end method

.method public final serialize(kotlinx.serialization.encoding.Encoder  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto)void
    .registers 4
    # ins_size=3
    const-string v0, "encoder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/Encoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;
    move-result-object v2
    invoke-static v3, v2, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->write$Self$impl_mainlandRelease(Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto; Lkotlinx/serialization/encoding/CompositeEncoder; Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    return-void 
.end method

.method public bridge synthetic serialize(kotlinx.serialization.encoding.Encoder  java.lang.Object)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;->serialize(Lkotlinx/serialization/encoding/Encoder; Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;)V
    return-void 
.end method

.method public typeParametersSerializers()kotlinx.serialization.KSerializer[]
    .registers 2
    # ins_size=1
    invoke-static v1, Lkotlinx/serialization/internal/GeneratedSerializer$DefaultImpls;->typeParametersSerializers(Lkotlinx/serialization/internal/GeneratedSerializer;)[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    return-object v0
.end method
