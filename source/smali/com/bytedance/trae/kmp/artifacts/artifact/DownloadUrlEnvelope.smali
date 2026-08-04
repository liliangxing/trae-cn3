# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope$Companion;
.field private final code:J
.field private final data:Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->Companion Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->$stable I
    return-void 
.end method

.method public synthetic constructor <init>(int  long  com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlDto  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v2, 1
    const/4 v0, 1
    if-eq v0, v6, +00bh
    sget-object v6, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope$$serializer;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope$$serializer;
    invoke-virtual v6, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v6
    invoke-static v2, v0, v6, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-wide v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->code J
    and-int/lit8 v2, v2, 2
    if-nez v2, +006h
    const/4 v2, 0
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->data Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    goto +3h
    iput-object v5, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->data Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    return-void 
.end method

.method public constructor <init>(long  com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlDto)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->code J
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->data Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    return-void 
.end method

.method public synthetic constructor <init>(long  com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlDto  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;-><init>(J Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlEnvelope  long  com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlDto  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlEnvelope
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-wide v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->code J
    and-int/lit8 v4, v4, 2
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->data Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->copy(J Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;)Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic write$Self$artifacts_mainlandRelease(com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlEnvelope  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 6
    # ins_size=3
    iget-wide v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->code J
    const/4 v2, 0
    invoke-interface v4, v5, v2, v0, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeLongElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I J)V
    const/4 v0, 1
    invoke-interface v4, v5, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v1
    if-eqz v1, +004h
    move v2, v0
    goto +6h
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->data Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    if-eqz v1, +003h
    goto -6h
    if-eqz v2, +00bh
    sget-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;
    check-cast v1, Lkotlinx/serialization/SerializationStrategy;
    iget-object v3, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->data Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    invoke-interface v4, v5, v0, v1, v3, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    return-void 
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->code J
    return-wide v0
.end method

.method public final component2()com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlDto
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->data Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    return-object v0
.end method

.method public final copy(long  com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlDto)com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlEnvelope
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;-><init>(J Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->code J
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->code J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->data Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    iget-object v8, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->data Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getCode()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->code J
    return-wide v0
.end method

.method public final getData()com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlDto
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->data Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->code J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->data Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DownloadUrlEnvelope(code="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->code J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;->data Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
