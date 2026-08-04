# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;
.super Ljava/lang/Object;
.source "DeviceManagementRepository.kt"

.implements Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event;

.field public static final $stable:I
.field private final cliId:Ljava/lang/String;
.field private final result:Lkotlinx/coroutines/CompletableDeferred;
.field private final type:Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String  com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$MutationType  kotlinx.coroutines.CompletableDeferred)void
    .registers 5
    # ins_size=4
    const-string v0, "cliId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, type
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, result
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->cliId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->result Lkotlinx/coroutines/CompletableDeferred;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Event$MutationRequested  java.lang.String  com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$MutationType  kotlinx.coroutines.CompletableDeferred  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Event$MutationRequested
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->cliId Ljava/lang/String;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->result Lkotlinx/coroutines/CompletableDeferred;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->copy(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType; Lkotlinx/coroutines/CompletableDeferred;)Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$MutationType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    return-object v0
.end method

.method public final component3()kotlinx.coroutines.CompletableDeferred
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->result Lkotlinx/coroutines/CompletableDeferred;
    return-object v0
.end method

.method public final copy(java.lang.String  com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$MutationType  kotlinx.coroutines.CompletableDeferred)com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Event$MutationRequested
    .registers 5
    # ins_size=4
    const-string v0, "cliId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, type
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, result
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType; Lkotlinx/coroutines/CompletableDeferred;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->cliId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->cliId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->result Lkotlinx/coroutines/CompletableDeferred;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->result Lkotlinx/coroutines/CompletableDeferred;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCliId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final getResult()kotlinx.coroutines.CompletableDeferred
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->result Lkotlinx/coroutines/CompletableDeferred;
    return-object v0
.end method

.method public final getType()com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$MutationType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->cliId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->result Lkotlinx/coroutines/CompletableDeferred;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "MutationRequested(cliId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->cliId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", type="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", result="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->result Lkotlinx/coroutines/CompletableDeferred;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
