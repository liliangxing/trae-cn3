# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.implements Lkotlinx/serialization/internal/GeneratedSerializer;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;
.field private static final descriptor:Lkotlinx/serialization/descriptors/SerialDescriptor;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;
    const/16 v1, 8
    sput v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;->$stable I
    new-instance v1, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;
    check-cast v0, Lkotlinx/serialization/internal/GeneratedSerializer;
    const-string v2, "com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlDto"
    const/4 v3, 1
    invoke-direct v1, v2, v0, v3, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;-><init>(Ljava/lang/String; Lkotlinx/serialization/internal/GeneratedSerializer; I)V
    const-string/jumbo v0, url_map
    invoke-virtual v1, v0, v3, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    check-cast v1, Lkotlinx/serialization/descriptors/SerialDescriptor;
    sput-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
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
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->access$get$childSerializers$cp()[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    const/4 v1, 1
    new-array v1, v1, [Lkotlinx/serialization/KSerializer;
    const/4 v2, 0
    aget-object v0, v0, v2
    invoke-static v0, Lkotlinx/serialization/builtins/BuiltinSerializersKt;->getNullable(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v0
    aput-object v0, v1, v2
    return-object v1
.end method

.method public final deserialize(kotlinx.serialization.encoding.Decoder)com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlDto
    .registers 11
    # ins_size=2
    const-string v0, "decoder"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v10, v0, Lkotlinx/serialization/encoding/Decoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;
    move-result-object v10
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->access$get$childSerializers$cp()[Lkotlinx/serialization/KSerializer;
    move-result-object v1
    invoke-interface v10, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeSequentially()Z
    move-result v2
    const/4 v3, 1
    const/4 v4, 0
    const/4 v5, 0
    if-eqz v2, +00dh
    aget-object v1, v1, v4
    check-cast v1, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v10, v0, v4, v1, v5, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map;
    goto +25h
    move v6, v4
    move-object v2, v5
    if-eqz v3, +020h
    invoke-interface v10, v0, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeElementIndex(Lkotlinx/serialization/descriptors/SerialDescriptor;)I
    move-result v7
    const/4 v8, -1
    if-eq v7, v8, +017h
    if-nez v7, +00fh
    aget-object v7, v1, v4
    check-cast v7, Lkotlinx/serialization/DeserializationStrategy;
    invoke-interface v10, v0, v4, v7, v2, Lkotlinx/serialization/encoding/CompositeDecoder;->decodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Map;
    or-int/lit8 v6, v6, 1
    goto -17h
    new-instance v10, Lkotlinx/serialization/UnknownFieldException;
    invoke-direct v10, v7, Lkotlinx/serialization/UnknownFieldException;-><init>(I)V
    throw v10
    move v3, v4
    goto -1fh
    move-object v1, v2
    move v3, v6
    invoke-interface v10, v0, Lkotlinx/serialization/encoding/CompositeDecoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    new-instance v10, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    invoke-direct v10, v3, v1, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;-><init>(I Ljava/util/Map; Lkotlinx/serialization/internal/SerializationConstructorMarker;)V
    return-object v10
.end method

.method public bridge synthetic deserialize(kotlinx.serialization.encoding.Decoder)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;->deserialize(Lkotlinx/serialization/encoding/Decoder;)Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    move-result-object v1
    return-object v1
.end method

.method public final getDescriptor()kotlinx.serialization.descriptors.SerialDescriptor
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-object v0
.end method

.method public final serialize(kotlinx.serialization.encoding.Encoder  com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlDto)void
    .registers 4
    # ins_size=3
    const-string v0, "encoder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;->descriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/Encoder;->beginStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;
    move-result-object v2
    invoke-static v3, v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->write$Self$artifacts_mainlandRelease(Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto; Lkotlinx/serialization/encoding/CompositeEncoder; Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-interface v2, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->endStructure(Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    return-void 
.end method

.method public bridge synthetic serialize(kotlinx.serialization.encoding.Encoder  java.lang.Object)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;->serialize(Lkotlinx/serialization/encoding/Encoder; Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;)V
    return-void 
.end method

.method public typeParametersSerializers()kotlinx.serialization.KSerializer[]
    .registers 2
    # ins_size=1
    invoke-static v1, Lkotlinx/serialization/internal/GeneratedSerializer$DefaultImpls;->typeParametersSerializers(Lkotlinx/serialization/internal/GeneratedSerializer;)[Lkotlinx/serialization/KSerializer;
    move-result-object v0
    return-object v0
.end method
