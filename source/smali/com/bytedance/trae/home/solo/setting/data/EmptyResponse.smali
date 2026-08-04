# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;
.super Ljava/lang/Object;
.source "DeviceManagementRepository.kt"

.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse$Companion;
.field private final ok:Ljava/lang/Boolean;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->Companion Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;-><init>(Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.Boolean  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 5
    # ins_size=4
    and-int/lit8 v4, v2, 0
    if-eqz v4, +00ch
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse$$serializer;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v4
    const/4 v0, 0
    invoke-static v2, v0, v4, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    and-int/lit8 v2, v2, 1
    if-nez v2, +006h
    const/4 v2, 0
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->ok Ljava/lang/Boolean;
    goto +3h
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->ok Ljava/lang/Boolean;
    return-void 
.end method

.method public constructor <init>(java.lang.Boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->ok Ljava/lang/Boolean;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.Boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;-><init>(Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.EmptyResponse  java.lang.Boolean  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.EmptyResponse
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->ok Ljava/lang/Boolean;
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->copy(Ljava/lang/Boolean;)Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic getOk$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$impl_mainlandRelease(com.bytedance.trae.home.solo.setting.data.EmptyResponse  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 6
    # ins_size=3
    const/4 v0, 0
    invoke-interface v4, v5, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +003h
    goto +7h
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->ok Ljava/lang/Boolean;
    if-eqz v1, +003h
    goto +2h
    move v2, v0
    if-eqz v2, +00bh
    sget-object v1, Lkotlinx/serialization/internal/BooleanSerializer;->INSTANCE Lkotlinx/serialization/internal/BooleanSerializer;
    check-cast v1, Lkotlinx/serialization/SerializationStrategy;
    iget-object v3, v3, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->ok Ljava/lang/Boolean;
    invoke-interface v4, v5, v0, v1, v3, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    return-void 
.end method

.method public final component1()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->ok Ljava/lang/Boolean;
    return-object v0
.end method

.method public final copy(java.lang.Boolean)com.bytedance.trae.home.solo.setting.data.EmptyResponse
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;-><init>(Ljava/lang/Boolean;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->ok Ljava/lang/Boolean;
    iget-object v4, v4, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->ok Ljava/lang/Boolean;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getOk()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->ok Ljava/lang/Boolean;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->ok Ljava/lang/Boolean;
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
    const-string v1, "EmptyResponse(ok="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->ok Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
