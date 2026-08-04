# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;
.super Ljava/lang/Object;
.source "DeviceManagementRepository.kt"

.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest$Companion;
.field private final cliId:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;->Companion Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest$Companion;
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.String  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 5
    # ins_size=4
    and-int/lit8 v4, v2, 1
    const/4 v0, 1
    if-eq v0, v4, +00bh
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest$$serializer;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v4
    invoke-static v2, v0, v4, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;->cliId Ljava/lang/String;
    return-void 
.end method

.method public constructor <init>(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "cliId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;->cliId Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.DeleteCliRequest  java.lang.String  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.DeleteCliRequest
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;->cliId Ljava/lang/String;
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;->copy(Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic getCliId$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$impl_mainlandRelease(com.bytedance.trae.home.solo.setting.data.DeleteCliRequest  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 4
    # ins_size=3
    const/4 v0, 0
    iget-object v1, v1, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;->cliId Ljava/lang/String;
    invoke-interface v2, v3, v0, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    return-void 
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String)com.bytedance.trae.home.solo.setting.data.DeleteCliRequest
    .registers 3
    # ins_size=2
    const-string v0, "cliId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;-><init>(Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;->cliId Ljava/lang/String;
    iget-object v4, v4, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;->cliId Ljava/lang/String;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getCliId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;->cliId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DeleteCliRequest(cliId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;->cliId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
