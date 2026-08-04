# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;
.super Ljava/lang/Object;
.source "SettingsNetworkModels.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto$Companion;
.field private final data:Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;
.field private final userPayIdentityStr:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->Companion Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.String  com.bytedance.trae.home.solo.setting.data.model.PayStatusDto  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v2, 0
    if-eqz v5, +00ch
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto$$serializer;
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v5
    const/4 v0, 0
    invoke-static v2, v0, v5, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    and-int/lit8 v5, v2, 1
    const/4 v0, 0
    if-nez v5, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->userPayIdentityStr Ljava/lang/String;
    goto +3h
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->userPayIdentityStr Ljava/lang/String;
    and-int/lit8 v2, v2, 2
    if-nez v2, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;
    goto +3h
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;
    return-void 
.end method

.method public constructor <init>(java.lang.String  com.bytedance.trae.home.solo.setting.data.model.PayStatusDto)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->userPayIdentityStr Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.home.solo.setting.data.model.PayStatusDto  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v4, 1
    const/4 v0, 0
    if-eqz v5, +003h
    move-object v2, v0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    move-object v3, v0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.model.PayStatusResponseDto  java.lang.String  com.bytedance.trae.home.solo.setting.data.model.PayStatusDto  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.model.PayStatusResponseDto
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->userPayIdentityStr Ljava/lang/String;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->copy(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;)Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic getData$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getUserPayIdentityStr$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$impl_mainlandRelease(com.bytedance.trae.home.solo.setting.data.model.PayStatusResponseDto  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 7
    # ins_size=3
    const/4 v0, 0
    invoke-interface v5, v6, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +004h
    move v1, v2
    goto +7h
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->userPayIdentityStr Ljava/lang/String;
    if-eqz v1, +003h
    goto -6h
    move v1, v0
    if-eqz v1, +00bh
    sget-object v1, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v1, Lkotlinx/serialization/SerializationStrategy;
    iget-object v3, v4, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->userPayIdentityStr Ljava/lang/String;
    invoke-interface v5, v6, v0, v1, v3, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    invoke-interface v5, v6, v2, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v1
    if-eqz v1, +004h
    move v0, v2
    goto +6h
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;
    if-eqz v1, +003h
    goto -6h
    if-eqz v0, +00bh
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto$$serializer;
    check-cast v0, Lkotlinx/serialization/SerializationStrategy;
    iget-object v4, v4, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;
    invoke-interface v5, v6, v2, v0, v4, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    return-void 
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->userPayIdentityStr Ljava/lang/String;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.home.solo.setting.data.model.PayStatusDto
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;
    return-object v0
.end method

.method public final copy(java.lang.String  com.bytedance.trae.home.solo.setting.data.model.PayStatusDto)com.bytedance.trae.home.solo.setting.data.model.PayStatusResponseDto
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->userPayIdentityStr Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->userPayIdentityStr Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getData()com.bytedance.trae.home.solo.setting.data.model.PayStatusDto
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;
    return-object v0
.end method

.method public final getEffectiveUserPayIdentityStr()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->userPayIdentityStr Ljava/lang/String;
    if-nez v0, +00ch
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;->getUserPayIdentityStr()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public final getUserPayIdentityStr()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->userPayIdentityStr Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->userPayIdentityStr Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "PayStatusResponseDto(userPayIdentityStr="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->userPayIdentityStr Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->data Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
