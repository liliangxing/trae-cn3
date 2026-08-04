# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
.super Ljava/lang/Object;
.source "UserPayIdentityCache.kt"

.field public static final $stable:I
.field private final infinite:Z
.field private final remaining:J
.field private final total:J


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(long  long  boolean)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->remaining J
    iput-wide v3, v0, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->total J
    iput-boolean v5, v0, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->infinite Z
    return-void 
.end method

.method public synthetic constructor <init>(long  long  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=8
    and-int/lit8 v12, v12, 4
    if-eqz v12, +003h
    const/4 v11, 0
    move v5, v11
    move-object v0, v6
    move-wide v1, v7
    move-wide v3, v9
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;-><init>(J J Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.UsageQuotaData  long  long  boolean  int  java.lang.Object)com.bytedance.trae.home.solo.setting.UsageQuotaData
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 1
    if-eqz v13, +004h
    iget-wide v7, v6, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->remaining J
    move-wide v1, v7
    and-int/lit8 v7, v12, 2
    if-eqz v7, +004h
    iget-wide v9, v6, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->total J
    move-wide v3, v9
    and-int/lit8 v7, v12, 4
    if-eqz v7, +004h
    iget-boolean v11, v6, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->infinite Z
    move v5, v11
    move-object v0, v6
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->copy(J J Z)Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    move-result-object v6
    return-object v6
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->remaining J
    return-wide v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->total J
    return-wide v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->infinite Z
    return v0
.end method

.method public final copy(long  long  boolean)com.bytedance.trae.home.solo.setting.UsageQuotaData
    .registers 13
    # ins_size=6
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    move-object v0, v6
    move-wide v1, v8
    move-wide v3, v10
    move v5, v12
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;-><init>(J J Z)V
    return-object v6
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->remaining J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->remaining J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->total J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->total J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->infinite Z
    iget-boolean v8, v8, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->infinite Z
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getInfinite()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->infinite Z
    return v0
.end method

.method public final getRemaining()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->remaining J
    return-wide v0
.end method

.method public final getTotal()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->total J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->remaining J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->total J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->infinite Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "UsageQuotaData(remaining="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->remaining J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", total="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->total J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", infinite="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/home/solo/setting/UsageQuotaData;->infinite Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
