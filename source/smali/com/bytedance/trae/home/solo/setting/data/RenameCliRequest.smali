# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;
.super Ljava/lang/Object;
.source "DeviceManagementRepository.kt"

.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$Companion;
.field private final cliId:Ljava/lang/String;
.field private final name:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->Companion Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$Companion;
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.String  java.lang.String  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v2, 3
    const/4 v0, 3
    if-eq v0, v5, +00bh
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v5
    invoke-static v2, v0, v5, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->cliId Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->name Ljava/lang/String;
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "cliId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->cliId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->name Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.RenameCliRequest  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.RenameCliRequest
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->cliId Ljava/lang/String;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->name Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->copy(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic getCliId$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getName$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$impl_mainlandRelease(com.bytedance.trae.home.solo.setting.data.RenameCliRequest  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 5
    # ins_size=3
    const/4 v0, 0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->cliId Ljava/lang/String;
    invoke-interface v3, v4, v0, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    const/4 v0, 1
    iget-object v2, v2, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->name Ljava/lang/String;
    invoke-interface v3, v4, v0, v2, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    return-void 
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->name Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String)com.bytedance.trae.home.solo.setting.data.RenameCliRequest
    .registers 4
    # ins_size=3
    const-string v0, "cliId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->cliId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->cliId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->name Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->name Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCliId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->name Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->cliId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->name Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "RenameCliRequest(cliId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->cliId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", name="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->name Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
