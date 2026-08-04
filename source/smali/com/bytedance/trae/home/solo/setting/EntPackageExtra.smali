# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;
.super Ljava/lang/Object;
.source "UserEntStatusApi.kt"

.field public static final $stable:I
.field private final duration:Ljava/lang/Long;
.field private final packageDurationType:Ljava/lang/Integer;
.field private final packageSourceType:Ljava/lang/Integer;
.field private final quota:Lcom/bytedance/trae/home/solo/setting/EntQuota;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 8
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 15
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;-><init>(Lcom/bytedance/trae/home/solo/setting/EntQuota; Ljava/lang/Integer; Ljava/lang/Long; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.setting.EntQuota  java.lang.Integer  java.lang.Long  java.lang.Integer)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageDurationType Ljava/lang/Integer;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->duration Ljava/lang/Long;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageSourceType Ljava/lang/Integer;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.EntQuota  java.lang.Integer  java.lang.Long  java.lang.Integer  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 1
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v2, v0
    and-int/lit8 v7, v6, 2
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;-><init>(Lcom/bytedance/trae/home/solo/setting/EntQuota; Ljava/lang/Integer; Ljava/lang/Long; Ljava/lang/Integer;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.EntPackageExtra  com.bytedance.trae.home.solo.setting.EntQuota  java.lang.Integer  java.lang.Long  java.lang.Integer  int  java.lang.Object)com.bytedance.trae.home.solo.setting.EntPackageExtra
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageDurationType Ljava/lang/Integer;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->duration Ljava/lang/Long;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageSourceType Ljava/lang/Integer;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->copy(Lcom/bytedance/trae/home/solo/setting/EntQuota; Ljava/lang/Integer; Ljava/lang/Long; Ljava/lang/Integer;)Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.home.solo.setting.EntQuota
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    return-object v0
.end method

.method public final component2()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageDurationType Ljava/lang/Integer;
    return-object v0
.end method

.method public final component3()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->duration Ljava/lang/Long;
    return-object v0
.end method

.method public final component4()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageSourceType Ljava/lang/Integer;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.home.solo.setting.EntQuota  java.lang.Integer  java.lang.Long  java.lang.Integer)com.bytedance.trae.home.solo.setting.EntPackageExtra
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;-><init>(Lcom/bytedance/trae/home/solo/setting/EntQuota; Ljava/lang/Integer; Ljava/lang/Long; Ljava/lang/Integer;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageDurationType Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageDurationType Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->duration Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->duration Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageSourceType Ljava/lang/Integer;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageSourceType Ljava/lang/Integer;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getDuration()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->duration Ljava/lang/Long;
    return-object v0
.end method

.method public final getPackageDurationType()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageDurationType Ljava/lang/Integer;
    return-object v0
.end method

.method public final getPackageSourceType()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageSourceType Ljava/lang/Integer;
    return-object v0
.end method

.method public final getQuota()com.bytedance.trae.home.solo.setting.EntQuota
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageDurationType Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->duration Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageSourceType Ljava/lang/Integer;
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
    const-string v1, "EntPackageExtra(quota="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", packageDurationType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageDurationType Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", duration="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->duration Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", packageSourceType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/EntPackageExtra;->packageSourceType Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
