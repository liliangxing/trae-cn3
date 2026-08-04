# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;
.super Ljava/lang/Object;
.source "SettingsNetworkModels.kt"

.implements Lkotlinx/serialization/internal/GeneratedSerializer;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;
.field private static final descriptor:Lkotlinx/serialization/descriptors/SerialDescriptor;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;
    const/16 v1, 8
    sput v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;->$stable I
    new-instance v1, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;
    check-cast v0, Lkotlinx/serialization/internal/GeneratedSerializer;
    const/4 v2, 2
    const-string v3, "com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto.NestedDataDto"
    invoke-direct v1, v3, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;-><init>(Ljava/lang/String; Lkotlinx/serialization/internal/GeneratedSerializer; I)V
    const-string v0, "code"
    const/4 v2, 1
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string/jumbo v0, user_entitlement_pack_list
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    check-cast v1, Lkotlinx/serialization/descriptors/SerialDescriptor;
    sput-object v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
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
    invoke-static Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->access$get$childSerializers$cp()[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    const/4 v1, 2
    new-array v1, v1, [Lkotlinx/serialization/KSerializer;
    sget-object v2, Lkotlinx/serialization/internal/LongSerializer;->INSTANCE Lkotlinx/serialization/internal/LongSerializer;
    check-cast v2, Lkotlinx/serialization/KSerializer;
    invoke-static v2, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v2
    const/4 v3, 0
    aput-object v2, v1, v3
    const/4 v2, 1
    aget-object v0, v0, v2
    invoke-static v0, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v0
    aput-object v0, v1, v2
    return-object v1
.end method

.method public final deserialize(kotlinx.serialization.encoding.Decoder)com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$NestedDataDto
    .registers 13
    # ins_size=2
    const-string v0, "decoder"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v12, v0, Lkotlinx/serialization/encoding/Decoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;
    move-result-object v12
    invoke-static Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->access$get$childSerializers$cp()[Lkotlinx/serialization/KSerializer;
    move-result-object v1
    invoke-interface v12, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSequentially()Z
    move-result v2
    const/4 v3, 1
    const/4 v4, 0
    const/4 v5, 0
    if-eqz v2, +018h
    sget-object v2, Lkotlinx/serialization/internal/LongSerializer;->INSTANCE Lkotlinx/serialization/internal/LongSerializer;
    check-cast v2, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v12, v0, v4, v2, v5, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Long;
    aget-object v1, v1, v3
    check-cast v1, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v12, v0, v3, v1, v5, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    const/4 v3, 3
    goto +37h
    move v8, v3
    move v7, v4
    move-object v2, v5
    move-object v6, v2
    if-eqz v8, +02fh
    invoke-interface v12, v0, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeElementIndex(Lkotlinx/serialization/descriptors/SerialDescriptor;)I
    move-result v9
    const/4 v10, -1
    if-eq v9, v10, +026h
    if-eqz v9, +017h
    if-ne v9, v3, +00fh
    aget-object v9, v1, v3
    check-cast v9, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v12, v0, v3, v9, v2, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    or-int/lit8 v7, v7, 2
    goto -19h
    new-instance v12, Lkotlinx/serialization/UnknownFieldException;
    invoke-direct v12, v9, Lkotlinx/serialization/UnknownFieldException;-><init>(I)V
    throw v12
    sget-object v9, Lkotlinx/serialization/internal/LongSerializer;->INSTANCE Lkotlinx/serialization/internal/LongSerializer;
    check-cast v9, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v12, v0, v4, v9, v6, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/Long;
    or-int/lit8 v7, v7, 1
    goto -2ch
    move v8, v4
    goto -2eh
    move-object v1, v2
    move-object v2, v6
    move v3, v7
    invoke-interface v12, v0, Lkotlinx/serialization/encoding/CompositeDecoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    new-instance v12, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    invoke-direct v12, v3, v2, v1, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;-><init>(I Ljava/lang/Long; Ljava/util/List; Lkotlinx/serialization/internal/SerializationConstructorMarker;)V
    return-object v12
.end method

.method public bridge synthetic deserialize(kotlinx.serialization.encoding.Decoder)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;->deserialize(Lkotlinx/serialization/encoding/Decoder;)Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    move-result-object v1
    return-object v1
.end method

.method public final getDescriptor()kotlinx.serialization.descriptors.SerialDescriptor
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-object v0
.end method

.method public final serialize(kotlinx.serialization.encoding.Encoder  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$NestedDataDto)void
    .registers 4
    # ins_size=3
    const-string v0, "encoder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/Encoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;
    move-result-object v2
    invoke-static v3, v2, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->write$Self$impl_mainlandRelease(Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto; Lkotlinx/serialization/encoding/CompositeEncoder; Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    return-void 
.end method

.method public bridge synthetic serialize(kotlinx.serialization.encoding.Encoder  java.lang.Object)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;->serialize(Lkotlinx/serialization/encoding/Encoder; Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;)V
    return-void 
.end method

.method public typeParametersSerializers()kotlinx.serialization.KSerializer[]
    .registers 2
    # ins_size=1
    invoke-static v1, Lkotlinx/serialization/internal/GeneratedSerializer$DefaultImpls;->typeParametersSerializers(Lkotlinx/serialization/internal/GeneratedSerializer;)[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    return-object v0
.end method
