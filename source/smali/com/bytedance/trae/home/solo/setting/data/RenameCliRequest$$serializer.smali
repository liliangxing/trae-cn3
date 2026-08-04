# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;
.super Ljava/lang/Object;
.source "DeviceManagementRepository.kt"

.implements Lkotlinx/serialization/internal/GeneratedSerializer;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;
.field private static final descriptor:Lkotlinx/serialization/descriptors/SerialDescriptor;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;
    const/16 v1, 8
    sput v1, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;->$stable I
    new-instance v1, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;
    check-cast v0, Lkotlinx/serialization/internal/GeneratedSerializer;
    const/4 v2, 2
    const-string v3, "com.bytedance.trae.home.solo.setting.data.RenameCliRequest"
    invoke-direct v1, v3, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;-><init>(Ljava/lang/String; Lkotlinx/serialization/internal/GeneratedSerializer; I)V
    const-string v0, "cli_id"
    const/4 v2, 0
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v0, "name"
    invoke-virtual v1, v0, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    check-cast v1, Lkotlinx/serialization/descriptors/SerialDescriptor;
    sput-object v1, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
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
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    aput-object v2, v0, v1
    return-object v0
.end method

.method public final deserialize(kotlinx.serialization.encoding.Decoder)com.bytedance.trae.home.solo.setting.data.RenameCliRequest
    .registers 12
    # ins_size=2
    const-string v0, "decoder"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v11, v0, Lkotlinx/serialization/encoding/Decoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;
    move-result-object v11
    invoke-interface v11, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSequentially()Z
    move-result v1
    const/4 v2, 1
    const/4 v3, 0
    const/4 v4, 0
    if-eqz v1, +00ch
    invoke-interface v11, v0, v3, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v1
    invoke-interface v11, v0, v2, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v2
    const/4 v3, 3
    goto +2ah
    move v7, v2
    move v6, v3
    move-object v1, v4
    move-object v5, v1
    if-eqz v7, +023h
    invoke-interface v11, v0, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeElementIndex(Lkotlinx/serialization/descriptors/SerialDescriptor;)I
    move-result v8
    const/4 v9, -1
    if-eq v8, v9, +01ah
    if-eqz v8, +011h
    if-ne v8, v2, +009h
    invoke-interface v11, v0, v2, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v5
    or-int/lit8 v6, v6, 2
    goto -13h
    new-instance v11, Lkotlinx/serialization/UnknownFieldException;
    invoke-direct v11, v8, Lkotlinx/serialization/UnknownFieldException;-><init>(I)V
    throw v11
    invoke-interface v11, v0, v3, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Ljava/lang/String;
    move-result-object v1
    or-int/lit8 v6, v6, 1
    goto -20h
    move v7, v3
    goto -22h
    move-object v2, v5
    move v3, v6
    invoke-interface v11, v0, Lkotlinx/serialization/encoding/CompositeDecoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    new-instance v11, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;
    invoke-direct v11, v3, v1, v2, v4, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;-><init>(I Ljava/lang/String; Ljava/lang/String; Lkotlinx/serialization/internal/SerializationConstructorMarker;)V
    return-object v11
.end method

.method public bridge synthetic deserialize(kotlinx.serialization.encoding.Decoder)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;->deserialize(Lkotlinx/serialization/encoding/Decoder;)Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;
    move-result-object v1
    return-object v1
.end method

.method public final getDescriptor()kotlinx.serialization.descriptors.SerialDescriptor
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-object v0
.end method

.method public final serialize(kotlinx.serialization.encoding.Encoder  com.bytedance.trae.home.solo.setting.data.RenameCliRequest)void
    .registers 4
    # ins_size=3
    const-string v0, "encoder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/Encoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;
    move-result-object v2
    invoke-static v3, v2, v0, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->write$Self$impl_mainlandRelease(Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest; Lkotlinx/serialization/encoding/CompositeEncoder; Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    return-void 
.end method

.method public bridge synthetic serialize(kotlinx.serialization.encoding.Encoder  java.lang.Object)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;->serialize(Lkotlinx/serialization/encoding/Encoder; Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;)V
    return-void 
.end method

.method public typeParametersSerializers()kotlinx.serialization.KSerializer[]
    .registers 2
    # ins_size=1
    invoke-static v1, Lkotlinx/serialization/internal/GeneratedSerializer$DefaultImpls;->typeParametersSerializers(Lkotlinx/serialization/internal/GeneratedSerializer;)[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    return-object v0
.end method
