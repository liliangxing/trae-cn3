# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;
.super Ljava/lang/Object;
.source "SettingsNetworkModels.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$Companion;
.field private final count:I


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->Companion Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    const/4 v1, 0
    const/4 v2, 0
    invoke-direct v3, v2, v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;-><init>(I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(int)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->count I
    return-void 
.end method

.method public synthetic constructor <init>(int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;-><init>(I)V
    return-void 
.end method

.method public synthetic constructor <init>(int  int  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 5
    # ins_size=4
    and-int/lit8 v4, v2, 0
    const/4 v0, 0
    if-eqz v4, +00bh
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v4
    invoke-static v2, v0, v4, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    and-int/lit8 v2, v2, 1
    if-nez v2, +005h
    iput v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->count I
    goto +3h
    iput v3, v1, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->count I
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.model.UnreadCountDto$CountData  int  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.model.UnreadCountDto$CountData
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->count I
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->copy(I)Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic getCount$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$impl_mainlandRelease(com.bytedance.trae.home.solo.setting.data.model.UnreadCountDto$CountData  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 6
    # ins_size=3
    const/4 v0, 0
    invoke-interface v4, v5, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +003h
    goto +7h
    iget v1, v3, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->count I
    if-eqz v1, +003h
    goto +2h
    move v2, v0
    if-eqz v2, +007h
    iget v3, v3, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->count I
    invoke-interface v4, v5, v0, v3, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeIntElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I I)V
    return-void 
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->count I
    return v0
.end method

.method public final copy(int)com.bytedance.trae.home.solo.setting.data.model.UnreadCountDto$CountData
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;-><init>(I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;
    iget v1, v3, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->count I
    iget v4, v4, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->count I
    if-eq v1, v4, +003h
    return v2
    return v0
.end method

.method public final getCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->count I
    return v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->count I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CountData(count="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;->count I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
