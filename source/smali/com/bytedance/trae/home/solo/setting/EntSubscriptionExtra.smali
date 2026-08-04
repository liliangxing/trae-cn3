# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;
.super Ljava/lang/Object;
.source "UserEntStatusApi.kt"

.field public static final $stable:I
.field private final periodType:Ljava/lang/Integer;
.field private final quota:Lcom/bytedance/trae/home/solo/setting/EntQuota;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;-><init>(Ljava/lang/Integer; Lcom/bytedance/trae/home/solo/setting/EntQuota; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.Integer  com.bytedance.trae.home.solo.setting.EntQuota)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->periodType Ljava/lang/Integer;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.Integer  com.bytedance.trae.home.solo.setting.EntQuota  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v4, 1
    const/4 v0, 0
    if-eqz v5, +003h
    move-object v2, v0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    move-object v3, v0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;-><init>(Ljava/lang/Integer; Lcom/bytedance/trae/home/solo/setting/EntQuota;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.EntSubscriptionExtra  java.lang.Integer  com.bytedance.trae.home.solo.setting.EntQuota  int  java.lang.Object)com.bytedance.trae.home.solo.setting.EntSubscriptionExtra
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->periodType Ljava/lang/Integer;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->copy(Ljava/lang/Integer; Lcom/bytedance/trae/home/solo/setting/EntQuota;)Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->periodType Ljava/lang/Integer;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.home.solo.setting.EntQuota
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    return-object v0
.end method

.method public final copy(java.lang.Integer  com.bytedance.trae.home.solo.setting.EntQuota)com.bytedance.trae.home.solo.setting.EntSubscriptionExtra
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;-><init>(Ljava/lang/Integer; Lcom/bytedance/trae/home/solo/setting/EntQuota;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->periodType Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->periodType Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getPeriodType()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->periodType Ljava/lang/Integer;
    return-object v0
.end method

.method public final getQuota()com.bytedance.trae.home.solo.setting.EntQuota
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->periodType Ljava/lang/Integer;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/EntQuota;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "EntSubscriptionExtra(periodType="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->periodType Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", quota="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/EntSubscriptionExtra;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
