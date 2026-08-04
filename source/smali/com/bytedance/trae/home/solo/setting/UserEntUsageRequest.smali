# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;
.super Ljava/lang/Object;
.source "UserEntStatusApi.kt"

.field public static final $stable:I
.field private final reqSource:I
.field private final requireUsage:Z


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 4
    # ins_size=1
    const/4 v0, 3
    const/4 v1, 0
    const/4 v2, 0
    invoke-direct v3, v2, v2, v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;-><init>(Z I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(boolean  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->requireUsage Z
    iput v2, v0, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->reqSource I
    return-void 
.end method

.method public synthetic constructor <init>(boolean  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +003h
    const/4 v1, 1
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 5
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;-><init>(Z I)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.UserEntUsageRequest  boolean  int  int  java.lang.Object)com.bytedance.trae.home.solo.setting.UserEntUsageRequest
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-boolean v1, v0, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->requireUsage Z
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget v2, v0, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->reqSource I
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->copy(Z I)Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;
    move-result-object v0
    return-object v0
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->requireUsage Z
    return v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->reqSource I
    return v0
.end method

.method public final copy(boolean  int)com.bytedance.trae.home.solo.setting.UserEntUsageRequest
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;-><init>(Z I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->requireUsage Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->requireUsage Z
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->reqSource I
    iget v5, v5, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->reqSource I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getReqSource()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->reqSource I
    return v0
.end method

.method public final getRequireUsage()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->requireUsage Z
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->requireUsage Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->reqSource I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "UserEntUsageRequest(requireUsage="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->requireUsage Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", reqSource="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;->reqSource I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
