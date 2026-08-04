# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
.super Ljava/lang/Object;
.source "SettingsNetworkModels.kt"

.field private static final $childSerializers:[Lkotlinx/serialization/KSerializer;
.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$Companion;
.field private final code:Ljava/lang/Long;
.field private final userEntitlementPackList:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->Companion Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->$stable I
    const/4 v0, 2
    new-array v0, v0, [Lkotlinx/serialization/KSerializer;
    const/4 v2, 0
    aput-object v1, v0, v2
    new-instance v1, Lkotlinx/serialization/internal/ArrayListSerializer;
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto$$serializer;
    check-cast v2, Lkotlinx/serialization/KSerializer;
    invoke-direct v1, v2, Lkotlinx/serialization/internal/ArrayListSerializer;-><init>(Lkotlinx/serialization/KSerializer;)V
    const/4 v2, 1
    aput-object v1, v0, v2
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->$childSerializers [Lkotlinx/serialization/KSerializer;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;-><init>(Ljava/lang/Long; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.Long  java.util.List  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v2, 0
    if-eqz v5, +00ch
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v5
    const/4 v0, 0
    invoke-static v2, v0, v5, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    and-int/lit8 v5, v2, 1
    const/4 v0, 0
    if-nez v5, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->code Ljava/lang/Long;
    goto +3h
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->code Ljava/lang/Long;
    and-int/lit8 v2, v2, 2
    if-nez v2, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->userEntitlementPackList Ljava/util/List;
    goto +3h
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->userEntitlementPackList Ljava/util/List;
    return-void 
.end method

.method public constructor <init>(java.lang.Long  java.util.List)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->code Ljava/lang/Long;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->userEntitlementPackList Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.Long  java.util.List  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v4, 1
    const/4 v0, 0
    if-eqz v5, +003h
    move-object v2, v0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    move-object v3, v0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;-><init>(Ljava/lang/Long; Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$get$childSerializers$cp()kotlinx.serialization.KSerializer[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->$childSerializers [Lkotlinx/serialization/KSerializer;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$NestedDataDto  java.lang.Long  java.util.List  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$NestedDataDto
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->code Ljava/lang/Long;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->userEntitlementPackList Ljava/util/List;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->copy(Ljava/lang/Long; Ljava/util/List;)Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic getCode$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getUserEntitlementPackList$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$impl_mainlandRelease(com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$NestedDataDto  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 8
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->$childSerializers [Lkotlinx/serialization/KSerializer;
    const/4 v1, 0
    invoke-interface v6, v7, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v2
    const/4 v3, 1
    if-eqz v2, +004h
    move v2, v3
    goto +7h
    iget-object v2, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->code Ljava/lang/Long;
    if-eqz v2, +003h
    goto -6h
    move v2, v1
    if-eqz v2, +00bh
    sget-object v2, Lkotlinx/serialization/internal/LongSerializer;->INSTANCE Lkotlinx/serialization/internal/LongSerializer;
    check-cast v2, Lkotlinx/serialization/SerializationStrategy;
    iget-object v4, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->code Ljava/lang/Long;
    invoke-interface v6, v7, v1, v2, v4, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    invoke-interface v6, v7, v3, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v2
    if-eqz v2, +004h
    move v1, v3
    goto +6h
    iget-object v2, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->userEntitlementPackList Ljava/util/List;
    if-eqz v2, +003h
    goto -6h
    if-eqz v1, +00bh
    aget-object v0, v0, v3
    check-cast v0, Lkotlinx/serialization/SerializationStrategy;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->userEntitlementPackList Ljava/util/List;
    invoke-interface v6, v7, v3, v0, v5, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    return-void 
.end method

.method public final component1()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->code Ljava/lang/Long;
    return-object v0
.end method

.method public final component2()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->userEntitlementPackList Ljava/util/List;
    return-object v0
.end method

.method public final copy(java.lang.Long  java.util.List)com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$NestedDataDto
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;-><init>(Ljava/lang/Long; Ljava/util/List;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->code Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->code Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->userEntitlementPackList Ljava/util/List;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->userEntitlementPackList Ljava/util/List;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCode()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->code Ljava/lang/Long;
    return-object v0
.end method

.method public final getUserEntitlementPackList()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->userEntitlementPackList Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->code Ljava/lang/Long;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->userEntitlementPackList Ljava/util/List;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "NestedDataDto(code="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->code Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", userEntitlementPackList="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->userEntitlementPackList Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
