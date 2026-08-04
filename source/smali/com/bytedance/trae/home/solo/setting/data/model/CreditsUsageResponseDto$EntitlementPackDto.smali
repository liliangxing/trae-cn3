# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;
.super Ljava/lang/Object;
.source "SettingsNetworkModels.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto$Companion;
.field private final entitlementBaseInfo:Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
.field private final usage:Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->Companion Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;-><init>(Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto; Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public synthetic constructor <init>(int  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntitlementBaseInfoDto  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntUsageDto  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v2, 0
    if-eqz v5, +00ch
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto$$serializer;
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v5
    const/4 v0, 0
    invoke-static v2, v0, v5, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    and-int/lit8 v5, v2, 1
    const/4 v0, 0
    if-nez v5, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->entitlementBaseInfo Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
    goto +3h
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->entitlementBaseInfo Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
    and-int/lit8 v2, v2, 2
    if-nez v2, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->usage Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    goto +3h
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->usage Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntitlementBaseInfoDto  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntUsageDto)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->entitlementBaseInfo Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->usage Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntitlementBaseInfoDto  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntUsageDto  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v4, 1
    const/4 v0, 0
    if-eqz v5, +003h
    move-object v2, v0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    move-object v3, v0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;-><init>(Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto; Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntitlementPackDto  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntitlementBaseInfoDto  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntUsageDto  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntitlementPackDto
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->entitlementBaseInfo Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->usage Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->copy(Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto; Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;)Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic getEntitlementBaseInfo$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getUsage$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$impl_mainlandRelease(com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntitlementPackDto  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 7
    # ins_size=3
    const/4 v0, 0
    invoke-interface v5, v6, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +004h
    move v1, v2
    goto +7h
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->entitlementBaseInfo Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
    if-eqz v1, +003h
    goto -6h
    move v1, v0
    if-eqz v1, +00bh
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto$$serializer;
    check-cast v1, Lkotlinx/serialization/SerializationStrategy;
    iget-object v3, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->entitlementBaseInfo Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
    invoke-interface v5, v6, v0, v1, v3, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    invoke-interface v5, v6, v2, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v1
    if-eqz v1, +004h
    move v0, v2
    goto +6h
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->usage Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    if-eqz v1, +003h
    goto -6h
    if-eqz v0, +00bh
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$$serializer;
    check-cast v0, Lkotlinx/serialization/SerializationStrategy;
    iget-object v4, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->usage Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    invoke-interface v5, v6, v2, v0, v4, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    return-void 
.end method

.method public final component1()com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntitlementBaseInfoDto
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->entitlementBaseInfo Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntUsageDto
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->usage Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntitlementBaseInfoDto  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntUsageDto)com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntitlementPackDto
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;-><init>(Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto; Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->entitlementBaseInfo Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->entitlementBaseInfo Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->usage Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->usage Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getEntitlementBaseInfo()com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntitlementBaseInfoDto
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->entitlementBaseInfo Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
    return-object v0
.end method

.method public final getUsage()com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$EntUsageDto
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->usage Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->entitlementBaseInfo Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->usage Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "EntitlementPackDto(entitlementBaseInfo="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->entitlementBaseInfo Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", usage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->usage Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
