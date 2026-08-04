# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;
.super Ljava/lang/Object;
.source "SettingsNetworkModels.kt"

.field private static final $childSerializers:[Lkotlinx/serialization/KSerializer;
.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$Companion;
.field private final code:Ljava/lang/Long;
.field private final data:Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
.field private final rawMessage:Ljava/lang/String;
.field private final rawMsg:Ljava/lang/String;
.field private final userEntitlementPackList:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->Companion Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->$stable I
    const/4 v0, 5
    new-array v0, v0, [Lkotlinx/serialization/KSerializer;
    const/4 v2, 0
    aput-object v1, v0, v2
    const/4 v2, 1
    aput-object v1, v0, v2
    const/4 v2, 2
    aput-object v1, v0, v2
    new-instance v2, Lkotlinx/serialization/internal/ArrayListSerializer;
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto$$serializer;
    check-cast v3, Lkotlinx/serialization/KSerializer;
    invoke-direct v2, v3, Lkotlinx/serialization/internal/ArrayListSerializer;-><init>(Lkotlinx/serialization/KSerializer;)V
    const/4 v3, 3
    aput-object v2, v0, v3
    const/4 v2, 4
    aput-object v1, v0, v2
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->$childSerializers [Lkotlinx/serialization/KSerializer;
    return-void 
.end method

.method public constructor <init>()void
    .registers 9
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 31
    const/4 v7, 0
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;-><init>(Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.Long  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$NestedDataDto  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 9
    # ins_size=8
    and-int/lit8 v8, v2, 0
    if-eqz v8, +00ch
    sget-object v8, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v8
    const/4 v0, 0
    invoke-static v2, v0, v8, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    and-int/lit8 v8, v2, 1
    const/4 v0, 0
    if-nez v8, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->code Ljava/lang/Long;
    goto +3h
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->code Ljava/lang/Long;
    and-int/lit8 v3, v2, 2
    if-nez v3, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMsg Ljava/lang/String;
    goto +3h
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMsg Ljava/lang/String;
    and-int/lit8 v3, v2, 4
    if-nez v3, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMessage Ljava/lang/String;
    goto +3h
    iput-object v5, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMessage Ljava/lang/String;
    and-int/lit8 v3, v2, 8
    if-nez v3, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->userEntitlementPackList Ljava/util/List;
    goto +3h
    iput-object v6, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->userEntitlementPackList Ljava/util/List;
    and-int/lit8 v2, v2, 16
    if-nez v2, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    goto +3h
    iput-object v7, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    return-void 
.end method

.method public constructor <init>(java.lang.Long  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$NestedDataDto)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->code Ljava/lang/Long;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMsg Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMessage Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->userEntitlementPackList Ljava/util/List;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.Long  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$NestedDataDto  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 12
    # ins_size=8
    and-int/lit8 v11, v10, 1
    const/4 v0, 0
    if-eqz v11, +004h
    move-object v11, v0
    goto +2h
    move-object v11, v5
    and-int/lit8 v5, v10, 2
    if-eqz v5, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v6
    and-int/lit8 v5, v10, 4
    if-eqz v5, +004h
    move-object v2, v0
    goto +2h
    move-object v2, v7
    and-int/lit8 v5, v10, 8
    if-eqz v5, +004h
    move-object v3, v0
    goto +2h
    move-object v3, v8
    and-int/lit8 v5, v10, 16
    if-eqz v5, +004h
    move-object v10, v0
    goto +2h
    move-object v10, v9
    move-object v5, v4
    move-object v6, v11
    move-object v7, v1
    move-object v8, v2
    move-object v9, v3
    invoke-direct/range v5 ... v10, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;-><init>(Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;)V
    return-void 
.end method

.method public static final synthetic access$get$childSerializers$cp()kotlinx.serialization.KSerializer[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->$childSerializers [Lkotlinx/serialization/KSerializer;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto  java.lang.Long  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$NestedDataDto  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->code Ljava/lang/Long;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMsg Ljava/lang/String;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMessage Ljava/lang/String;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v7, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->userEntitlementPackList Ljava/util/List;
    move-object v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-object v8, v0
    move-object v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->copy(Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;)Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;
    move-result-object v3
    return-object v3
.end method

.method public static synthetic getCode$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getData$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getRawMessage$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getRawMsg$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getUserEntitlementPackList$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$impl_mainlandRelease(com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 9
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->$childSerializers [Lkotlinx/serialization/KSerializer;
    const/4 v1, 0
    invoke-interface v7, v8, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v2
    const/4 v3, 1
    if-eqz v2, +004h
    move v2, v3
    goto +7h
    iget-object v2, v6, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->code Ljava/lang/Long;
    if-eqz v2, +003h
    goto -6h
    move v2, v1
    if-eqz v2, +00bh
    sget-object v2, Lkotlinx/serialization/internal/LongSerializer;->INSTANCE Lkotlinx/serialization/internal/LongSerializer;
    check-cast v2, Lkotlinx/serialization/SerializationStrategy;
    iget-object v4, v6, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->code Ljava/lang/Long;
    invoke-interface v7, v8, v1, v2, v4, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    invoke-interface v7, v8, v3, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v2
    if-eqz v2, +004h
    move v2, v3
    goto +7h
    iget-object v2, v6, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMsg Ljava/lang/String;
    if-eqz v2, +003h
    goto -6h
    move v2, v1
    if-eqz v2, +00bh
    sget-object v2, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v2, Lkotlinx/serialization/SerializationStrategy;
    iget-object v4, v6, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMsg Ljava/lang/String;
    invoke-interface v7, v8, v3, v2, v4, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    const/4 v2, 2
    invoke-interface v7, v8, v2, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v4
    if-eqz v4, +004h
    move v4, v3
    goto +7h
    iget-object v4, v6, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMessage Ljava/lang/String;
    if-eqz v4, +003h
    goto -6h
    move v4, v1
    if-eqz v4, +00bh
    sget-object v4, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v4, Lkotlinx/serialization/SerializationStrategy;
    iget-object v5, v6, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMessage Ljava/lang/String;
    invoke-interface v7, v8, v2, v4, v5, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    const/4 v2, 3
    invoke-interface v7, v8, v2, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v4
    if-eqz v4, +004h
    move v4, v3
    goto +7h
    iget-object v4, v6, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->userEntitlementPackList Ljava/util/List;
    if-eqz v4, +003h
    goto -6h
    move v4, v1
    if-eqz v4, +00bh
    aget-object v0, v0, v2
    check-cast v0, Lkotlinx/serialization/SerializationStrategy;
    iget-object v4, v6, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->userEntitlementPackList Ljava/util/List;
    invoke-interface v7, v8, v2, v0, v4, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    const/4 v0, 4
    invoke-interface v7, v8, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v2
    if-eqz v2, +004h
    move v1, v3
    goto +6h
    iget-object v2, v6, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    if-eqz v2, +003h
    goto -6h
    if-eqz v1, +00bh
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$$serializer;
    check-cast v1, Lkotlinx/serialization/SerializationStrategy;
    iget-object v6, v6, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    invoke-interface v7, v8, v0, v1, v6, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    return-void 
.end method

.method public final component1()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->code Ljava/lang/Long;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMsg Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMessage Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->userEntitlementPackList Ljava/util/List;
    return-object v0
.end method

.method public final component5()com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$NestedDataDto
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    return-object v0
.end method

.method public final copy(java.lang.Long  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$NestedDataDto)com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto
    .registers 13
    # ins_size=6
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;
    move-object v0, v6
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;-><init>(Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;)V
    return-object v6
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->code Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->code Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMsg Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMsg Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMessage Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMessage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->userEntitlementPackList Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->userEntitlementPackList Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCode()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->code Ljava/lang/Long;
    return-object v0
.end method

.method public final getData()com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto$NestedDataDto
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    return-object v0
.end method

.method public final getEffectiveCode()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->code Ljava/lang/Long;
    if-nez v0, +00ch
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->getCode()Ljava/lang/Long;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public final getEffectiveEntitlementPacks()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->userEntitlementPackList Ljava/util/List;
    if-nez v0, +00ch
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->getUserEntitlementPackList()Ljava/util/List;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public final getRawMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMessage Ljava/lang/String;
    return-object v0
.end method

.method public final getRawMsg()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMsg Ljava/lang/String;
    return-object v0
.end method

.method public final getUserEntitlementPackList()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->userEntitlementPackList Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->code Ljava/lang/Long;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMsg Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMessage Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->userEntitlementPackList Ljava/util/List;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CreditsUsageResponseDto(code="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->code Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rawMsg="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMsg Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rawMessage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->rawMessage Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", userEntitlementPackList="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->userEntitlementPackList Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
