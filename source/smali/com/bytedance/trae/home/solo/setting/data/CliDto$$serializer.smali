# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;
.super Ljava/lang/Object;
.source "DeviceManagementRepository.kt"

.implements Lkotlinx/serialization/internal/GeneratedSerializer;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;
.field private static final descriptor:Lkotlinx/serialization/descriptors/SerialDescriptor;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;
    const/16 v1, 8
    sput v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;->$stable I
    new-instance v1, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;
    check-cast v0, Lkotlinx/serialization/internal/GeneratedSerializer;
    const/4 v2, 5
    const-string v3, "com.bytedance.trae.home.solo.setting.data.CliDto"
    invoke-direct v1, v3, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;-><init>(Ljava/lang/String; Lkotlinx/serialization/internal/GeneratedSerializer; I)V
    const-string v0, "id"
    const/4 v2, 1
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "name"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string/jumbo v0, status
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string/jumbo v0, type
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "ide_version"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    check-cast v1, Lkotlinx/serialization/descriptors/SerialDescriptor;
    sput-object v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
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
    const/4 v0, 5
    new-array v0, v0, [Lkotlinx/serialization/KSerializer;
    const/4 v1, 0
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v2, v0, v1
    return-object v0
.end method

.method public final deserialize(kotlinx.serialization.encoding.Decoder)com.bytedance.trae.home.solo.setting.data.CliDto
    .registers 24
    # ins_size=2
    move-object/from16 v0, v23
    const-string v1, "decoder"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v0, v1, Lkotlinx/serialization/encoding/Decoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;
    move-result-object v0
    invoke-interface v0, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSequentially()Z
    move-result v2
    const/4 v3, 3
    const/4 v4, 4
    const/4 v5, 2
    const/4 v6, 1
    const/4 v7, 0
    if-eqz v2, +024h
    invoke-interface v0, v1, v7, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v2
    invoke-interface v0, v1, v6, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v6
    invoke-interface v0, v1, v5, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v5
    invoke-interface v0, v1, v3, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v3
    invoke-interface v0, v1, v4, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v4
    const/16 v7, 31
    move-object/from16 v16, v2
    move-object/from16 v19, v3
    move-object/from16 v20, v4
    move-object/from16 v18, v5
    move-object/from16 v17, v6
    move v15, v7
    goto +51h
    const/4 v2, 0
    move-object v8, v2
    move-object v9, v8
    move-object v10, v9
    move-object v11, v10
    move v13, v6
    move v12, v7
    if-eqz v13, +03eh
    invoke-interface v0, v1, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeElementIndex(Lkotlinx/serialization/descriptors/SerialDescriptor;)I
    move-result v14
    const/4 v15, -1
    if-eq v14, v15, +035h
    if-eqz v14, +02ch
    if-eq v14, v6, +023h
    if-eq v14, v5, +01ah
    if-eq v14, v3, +011h
    if-ne v14, v4, +009h
    invoke-interface v0, v1, v4, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v9
    or-int/lit8 v12, v12, 16
    goto -19h
    new-instance v0, Lkotlinx/serialization/UnknownFieldException;
    invoke-direct v0, v14, Lkotlinx/serialization/UnknownFieldException;-><init>(I)V
    throw v0
    invoke-interface v0, v1, v3, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v8
    or-int/lit8 v12, v12, 8
    goto -26h
    invoke-interface v0, v1, v5, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v10
    or-int/lit8 v12, v12, 4
    goto -2dh
    invoke-interface v0, v1, v6, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v11
    or-int/lit8 v12, v12, 2
    goto -34h
    invoke-interface v0, v1, v7, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v2
    or-int/lit8 v12, v12, 1
    goto -3bh
    move v13, v7
    goto -3dh
    move-object/from16 v16, v2
    move-object/from16 v19, v8
    move-object/from16 v20, v9
    move-object/from16 v18, v10
    move-object/from16 v17, v11
    move v15, v12
    invoke-interface v0, v1, Lkotlinx/serialization/encoding/CompositeDecoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/CliDto;
    const/16 v21, 0
    move-object v14, v0
    invoke-direct/range v14 ... v21, Lcom/bytedance/trae/home/solo/setting/data/CliDto;-><init>(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/serialization/internal/SerializationConstructorMarker;)V
    return-object v0
.end method

.method public bridge synthetic deserialize(kotlinx.serialization.encoding.Decoder)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;->deserialize(Lkotlinx/serialization/encoding/Decoder;)Lcom/bytedance/trae/home/solo/setting/data/CliDto;
    move-result-object v1
    return-object v1
.end method

.method public final getDescriptor()kotlinx.serialization.descriptors.SerialDescriptor
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-object v0
.end method

.method public final serialize(kotlinx.serialization.encoding.Encoder  com.bytedance.trae.home.solo.setting.data.CliDto)void
    .registers 4
    # ins_size=3
    const-string v0, "encoder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/Encoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;
    move-result-object v2
    invoke-static v3, v2, v0, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->write$Self$impl_mainlandRelease(Lcom/bytedance/trae/home/solo/setting/data/CliDto; Lkotlinx/serialization/encoding/CompositeEncoder; Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    return-void 
.end method

.method public bridge synthetic serialize(kotlinx.serialization.encoding.Encoder  java.lang.Object)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/CliDto;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;->serialize(Lkotlinx/serialization/encoding/Encoder; Lcom/bytedance/trae/home/solo/setting/data/CliDto;)V
    return-void 
.end method

.method public typeParametersSerializers()kotlinx.serialization.KSerializer[]
    .registers 2
    # ins_size=1
    invoke-static v1, Lkotlinx/serialization/internal/GeneratedSerializer$DefaultImpls;->typeParametersSerializers(Lkotlinx/serialization/internal/GeneratedSerializer;)[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    return-object v0
.end method
