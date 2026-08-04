# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.field private static final $childSerializers:[Lkotlinx/serialization/KSerializer;
.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$Companion;
.field private final urlMap:Ljava/util/Map;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->Companion Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->$stable I
    const/4 v0, 1
    new-array v0, v0, [Lkotlinx/serialization/KSerializer;
    new-instance v1, Lkotlinx/serialization/internal/LinkedHashMapSerializer;
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v2, Lkotlinx/serialization/KSerializer;
    sget-object v3, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v3, Lkotlinx/serialization/KSerializer;
    invoke-direct v1, v2, v3, Lkotlinx/serialization/internal/LinkedHashMapSerializer;-><init>(Lkotlinx/serialization/KSerializer; Lkotlinx/serialization/KSerializer;)V
    const/4 v2, 0
    aput-object v1, v0, v2
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->$childSerializers [Lkotlinx/serialization/KSerializer;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;-><init>(Ljava/util/Map; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public synthetic constructor <init>(int  java.util.Map  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 5
    # ins_size=4
    and-int/lit8 v4, v2, 0
    if-eqz v4, +00ch
    sget-object v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;
    invoke-virtual v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v4
    const/4 v0, 0
    invoke-static v2, v0, v4, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    and-int/lit8 v2, v2, 1
    if-nez v2, +006h
    const/4 v2, 0
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->urlMap Ljava/util/Map;
    goto +3h
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->urlMap Ljava/util/Map;
    return-void 
.end method

.method public constructor <init>(java.util.Map)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->urlMap Ljava/util/Map;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.Map  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;-><init>(Ljava/util/Map;)V
    return-void 
.end method

.method public static final synthetic access$get$childSerializers$cp()kotlinx.serialization.KSerializer[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->$childSerializers [Lkotlinx/serialization/KSerializer;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlDto  java.util.Map  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlDto
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->urlMap Ljava/util/Map;
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->copy(Ljava/util/Map;)Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic getUrlMap$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$artifacts_mainlandRelease(com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlDto  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 7
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->$childSerializers [Lkotlinx/serialization/KSerializer;
    const/4 v1, 0
    invoke-interface v5, v6, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v2
    const/4 v3, 1
    if-eqz v2, +003h
    goto +7h
    iget-object v2, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->urlMap Ljava/util/Map;
    if-eqz v2, +003h
    goto +2h
    move v3, v1
    if-eqz v3, +00bh
    aget-object v0, v0, v1
    check-cast v0, Lkotlinx/serialization/SerializationStrategy;
    iget-object v4, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->urlMap Ljava/util/Map;
    invoke-interface v5, v6, v1, v0, v4, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    return-void 
.end method

.method public final component1()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->urlMap Ljava/util/Map;
    return-object v0
.end method

.method public final copy(java.util.Map)com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlDto
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    invoke-direct v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;-><init>(Ljava/util/Map;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->urlMap Ljava/util/Map;
    iget-object v4, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->urlMap Ljava/util/Map;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getUrlMap()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->urlMap Ljava/util/Map;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->urlMap Ljava/util/Map;
    if-nez v0, +004h
    const/4 v0, 0
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DownloadUrlDto(urlMap="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->urlMap Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
