# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;
.super Ljava/lang/Object;
.source "SettingsNetworkModels.kt"

.implements Lkotlinx/serialization/internal/GeneratedSerializer;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;
.field private static final descriptor:Lkotlinx/serialization/descriptors/SerialDescriptor;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;
    const/16 v1, 8
    sput v1, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;->$stable I
    new-instance v1, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;
    check-cast v0, Lkotlinx/serialization/internal/GeneratedSerializer;
    const-string v2, "com.bytedance.trae.home.solo.setting.data.model.UnreadCountDto.CountData"
    const/4 v3, 1
    invoke-direct v1, v2, v0, v3, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;-><init>(Ljava/lang/String; Lkotlinx/serialization/internal/GeneratedSerializer; I)V
    const-string v0, "count"
    invoke-virtual v1, v0, v3, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    check-cast v1, Lkotlinx/serialization/descriptors/SerialDescriptor;
    sput-object v1, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
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
    const/4 v1, 0
    sget-object v2, Lkotlinx/serialization/internal/IntSerializer;->INSTANCE Lkotlinx/serialization/internal/IntSerializer;
    aput-object v2, v0, v1
    return-object v0
.end method

.method public final deserialize(kotlinx.serialization.encoding.Decoder)com.bytedance.trae.home.solo.setting.data.model.UnreadCountDto$CountData
    .registers 9
    # ins_size=2
    const-string v0, "decoder"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v8, v0, Lkotlinx/serialization/encoding/Decoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;
    move-result-object v8
    invoke-interface v8, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSequentially()Z
    move-result v1
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +007h
    invoke-interface v8, v0, v3, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeIntElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)I
    move-result v1
    goto +1eh
    move v1, v3
    move v4, v1
    if-eqz v2, +01ah
    invoke-interface v8, v0, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeElementIndex(Lkotlinx/serialization/descriptors/SerialDescriptor;)I
    move-result v5
    const/4 v6, -1
    if-eq v5, v6, +011h
    if-nez v5, +009h
    invoke-interface v8, v0, v3, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeIntElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I)I
    move-result v1
    or-int/lit8 v4, v4, 1
    goto -11h
    new-instance v8, Lkotlinx/serialization/UnknownFieldException;
    invoke-direct v8, v5, Lkotlinx/serialization/UnknownFieldException;-><init>(I)V
    throw v8
    move v2, v3
    goto -19h
    move v2, v4
    invoke-interface v8, v0, Lkotlinx/serialization/encoding/CompositeDecoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    new-instance v8, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;
    const/4 v0, 0
    invoke-direct v8, v2, v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;-><init>(I I Lkotlinx/serialization/internal/SerializationConstructorMarker;)V
    return-object v8
.end method

.method public bridge synthetic deserialize(kotlinx.serialization.encoding.Decoder)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;->deserialize(Lkotlinx/serialization/encoding/Decoder;)Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;
    move-result-object v1
    return-object v1
.end method

.method public final getDescriptor()kotlinx.serialization.descriptors.SerialDescriptor
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-object v0
.end method

.method public final serialize(kotlinx.serialization.encoding.Encoder  com.bytedance.trae.home.solo.setting.data.model.UnreadCountDto$CountData)void
    .registers 4
    # ins_size=3
    const-string v0, "encoder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/Encoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;
    move-result-object v2
    invoke-static v3, v2, v0, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->write$Self$impl_mainlandRelease(Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData; Lkotlinx/serialization/encoding/CompositeEncoder; Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    return-void 
.end method

.method public bridge synthetic serialize(kotlinx.serialization.encoding.Encoder  java.lang.Object)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;->serialize(Lkotlinx/serialization/encoding/Encoder; Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;)V
    return-void 
.end method

.method public typeParametersSerializers()kotlinx.serialization.KSerializer[]
    .registers 2
    # ins_size=1
    invoke-static v1, Lkotlinx/serialization/internal/GeneratedSerializer$DefaultImpls;->typeParametersSerializers(Lkotlinx/serialization/internal/GeneratedSerializer;)[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    return-object v0
.end method
