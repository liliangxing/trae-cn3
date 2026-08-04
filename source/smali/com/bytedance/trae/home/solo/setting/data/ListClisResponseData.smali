# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;
.super Ljava/lang/Object;
.source "DeviceManagementRepository.kt"

.field private static final $childSerializers:[Lkotlinx/serialization/KSerializer;
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData$Companion;
.field private final clis:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->Companion Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData$Companion;
    const/4 v0, 1
    new-array v0, v0, [Lkotlinx/serialization/KSerializer;
    new-instance v1, Lkotlinx/serialization/internal/ArrayListSerializer;
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;
    check-cast v2, Lkotlinx/serialization/KSerializer;
    invoke-direct v1, v2, Lkotlinx/serialization/internal/ArrayListSerializer;-><init>(Lkotlinx/serialization/KSerializer;)V
    const/4 v2, 0
    aput-object v1, v0, v2
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->$childSerializers [Lkotlinx/serialization/KSerializer;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;-><init>(Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public synthetic constructor <init>(int  java.util.List  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 5
    # ins_size=4
    and-int/lit8 v4, v2, 0
    if-eqz v4, +00ch
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData$$serializer;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v4
    const/4 v0, 0
    invoke-static v2, v0, v4, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    and-int/lit8 v2, v2, 1
    if-nez v2, +009h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->clis Ljava/util/List;
    goto +3h
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->clis Ljava/util/List;
    return-void 
.end method

.method public constructor <init>(java.util.List)void
    .registers 3
    # ins_size=2
    const-string v0, "clis"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->clis Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;-><init>(Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$get$childSerializers$cp()kotlinx.serialization.KSerializer[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->$childSerializers [Lkotlinx/serialization/KSerializer;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.ListClisResponseData  java.util.List  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.ListClisResponseData
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->clis Ljava/util/List;
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->copy(Ljava/util/List;)Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic getClis$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$impl_mainlandRelease(com.bytedance.trae.home.solo.setting.data.ListClisResponseData  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 8
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->$childSerializers [Lkotlinx/serialization/KSerializer;
    const/4 v1, 0
    invoke-interface v6, v7, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v2
    const/4 v3, 1
    if-eqz v2, +003h
    goto +fh
    iget-object v2, v5, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->clis Ljava/util/List;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +2h
    move v3, v1
    if-eqz v3, +00bh
    aget-object v0, v0, v1
    check-cast v0, Lkotlinx/serialization/SerializationStrategy;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->clis Ljava/util/List;
    invoke-interface v6, v7, v1, v0, v5, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    return-void 
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->clis Ljava/util/List;
    return-object v0
.end method

.method public final copy(java.util.List)com.bytedance.trae.home.solo.setting.data.ListClisResponseData
    .registers 3
    # ins_size=2
    const-string v0, "clis"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;-><init>(Ljava/util/List;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->clis Ljava/util/List;
    iget-object v4, v4, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->clis Ljava/util/List;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getClis()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->clis Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->clis Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ListClisResponseData(clis="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->clis Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
