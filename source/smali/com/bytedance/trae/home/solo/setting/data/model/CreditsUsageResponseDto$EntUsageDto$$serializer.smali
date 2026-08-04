# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;
.super Ljava/lang/Object;
.source "SettingsNetworkModels.kt"

.implements Lkotlinx/serialization/internal/GeneratedSerializer;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;
.field private static final descriptor:Lkotlinx/serialization/descriptors/SerialDescriptor;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;
    const/16 v1, 8
    sput v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;->$stable I
    new-instance v1, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;
    check-cast v0, Lkotlinx/serialization/internal/GeneratedSerializer;
    const-string v2, "com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto.EntUsageDto"
    const/4 v3, 1
    invoke-direct v1, v2, v0, v3, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;-><init>(Ljava/lang/String; Lkotlinx/serialization/internal/GeneratedSerializer; I)V
    const-string v0, "credits_amount"
    invoke-virtual v1, v0, v3, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    check-cast v1, Lkotlinx/serialization/descriptors/SerialDescriptor;
    sput-object v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
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
    const/4 v0, 1
    new-array v0, v0, [Lkotlinx/serialization/KSerializer;
    sget-object v1, Lkotlinx/serialization/internal/DoubleSerializer;->INSTANCE Lkotlinx/serialization/internal/DoubleSerializer;
    check-cast v1, Lkotlinx/serialization/KSerializer;
    invoke-static v1, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    return-object v0
.end method

.method public final deserialize(kotlinx.serialization.encoding.Decoder)com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntUsageDto
    .registers 10
    # ins_size=2
    const-string v0, "decoder"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v9, v0, Lkotlinx/serialization/encoding/Decoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;
    move-result-object v9
    invoke-interface v9, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSequentially()Z
    move-result v1
    const/4 v2, 1
    const/4 v3, 0
    const/4 v4, 0
    if-eqz v1, +00dh
    sget-object v1, Lkotlinx/serialization/internal/DoubleSerializer;->INSTANCE Lkotlinx/serialization/internal/DoubleSerializer;
    check-cast v1, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v9, v0, v3, v1, v4, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Double;
    goto +24h
    move v5, v3
    move-object v1, v4
    if-eqz v2, +020h
    invoke-interface v9, v0, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeElementIndex(Lkotlinx/serialization/descriptors/SerialDescriptor;)I
    move-result v6
    const/4 v7, -1
    if-eq v6, v7, +017h
    if-nez v6, +00fh
    sget-object v6, Lkotlinx/serialization/internal/DoubleSerializer;->INSTANCE Lkotlinx/serialization/internal/DoubleSerializer;
    check-cast v6, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v9, v0, v3, v6, v1, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Double;
    or-int/lit8 v5, v5, 1
    goto -17h
    new-instance v9, Lkotlinx/serialization/UnknownFieldException;
    invoke-direct v9, v6, Lkotlinx/serialization/UnknownFieldException;-><init>(I)V
    throw v9
    move v2, v3
    goto -1fh
    move v2, v5
    invoke-interface v9, v0, Lkotlinx/serialization/encoding/CompositeDecoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    new-instance v9, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    invoke-direct v9, v2, v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;-><init>(I Ljava/lang/Double; Lkotlinx/serialization/internal/SerializationConstructorMarker;)V
    return-object v9
.end method

.method public bridge synthetic deserialize(kotlinx.serialization.encoding.Decoder)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;->deserialize(Lkotlinx/serialization/encoding/Decoder;)Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    move-result-object v1
    return-object v1
.end method

.method public final getDescriptor()kotlinx.serialization.descriptors.SerialDescriptor
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-object v0
.end method

.method public final serialize(kotlinx.serialization.encoding.Encoder  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntUsageDto)void
    .registers 4
    # ins_size=3
    const-string v0, "encoder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/Encoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;
    move-result-object v2
    invoke-static v3, v2, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;->write$Self$impl_mainlandRelease(Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto; Lkotlinx/serialization/encoding/CompositeEncoder; Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    return-void 
.end method

.method public bridge synthetic serialize(kotlinx.serialization.encoding.Encoder  java.lang.Object)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;->serialize(Lkotlinx/serialization/encoding/Encoder; Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;)V
    return-void 
.end method

.method public typeParametersSerializers()kotlinx.serialization.KSerializer[]
    .registers 2
    # ins_size=1
    invoke-static v1, Lkotlinx/serialization/internal/GeneratedSerializer$DefaultImpls;->typeParametersSerializers(Lkotlinx/serialization/internal/GeneratedSerializer;)[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    return-object v0
.end method
