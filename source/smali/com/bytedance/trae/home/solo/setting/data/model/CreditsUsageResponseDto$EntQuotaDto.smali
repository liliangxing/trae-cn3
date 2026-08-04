# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;
.super Ljava/lang/Object;
.source "SettingsNetworkModels.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto$Companion;
.field private final creditsLimit:Ljava/lang/Long;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->Companion Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;-><init>(Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.Long  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 5
    # ins_size=4
    and-int/lit8 v4, v2, 0
    if-eqz v4, +00ch
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto$$serializer;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v4
    const/4 v0, 0
    invoke-static v2, v0, v4, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    and-int/lit8 v2, v2, 1
    if-nez v2, +006h
    const/4 v2, 0
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->creditsLimit Ljava/lang/Long;
    goto +3h
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->creditsLimit Ljava/lang/Long;
    return-void 
.end method

.method public constructor <init>(java.lang.Long)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->creditsLimit Ljava/lang/Long;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.Long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;-><init>(Ljava/lang/Long;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntQuotaDto  java.lang.Long  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntQuotaDto
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->creditsLimit Ljava/lang/Long;
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->copy(Ljava/lang/Long;)Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic getCreditsLimit$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$impl_mainlandRelease(com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntQuotaDto  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 6
    # ins_size=3
    const/4 v0, 0
    invoke-interface v4, v5, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +003h
    goto +7h
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->creditsLimit Ljava/lang/Long;
    if-eqz v1, +003h
    goto +2h
    move v2, v0
    if-eqz v2, +00bh
    sget-object v1, Lkotlinx/serialization/internal/LongSerializer;->INSTANCE Lkotlinx/serialization/internal/LongSerializer;
    check-cast v1, Lkotlinx/serialization/SerializationStrategy;
    iget-object v3, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->creditsLimit Ljava/lang/Long;
    invoke-interface v4, v5, v0, v1, v3, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    return-void 
.end method

.method public final component1()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->creditsLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final copy(java.lang.Long)com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntQuotaDto
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;-><init>(Ljava/lang/Long;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->creditsLimit Ljava/lang/Long;
    iget-object v4, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->creditsLimit Ljava/lang/Long;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getCreditsLimit()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->creditsLimit Ljava/lang/Long;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->creditsLimit Ljava/lang/Long;
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
    const-string v1, "EntQuotaDto(creditsLimit="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->creditsLimit Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
