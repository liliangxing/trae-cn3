# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/CreditsBalance;
.super Ljava/lang/Object;
.source "CreditsBalancePolicy.kt"

.field private final infinite:Z
.field private final remaining:J
.field private final total:J
.field private final used:J


.method public constructor <init>(long  long  long  boolean)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/CreditsBalance;->total J
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/CreditsBalance;->used J
    iput-wide v5, v0, Lcom/bytedance/trae/conversation/CreditsBalance;->remaining J
    iput-boolean v7, v0, Lcom/bytedance/trae/conversation/CreditsBalance;->infinite Z
    return-void 
.end method

.method public synthetic constructor <init>(long  long  long  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 8
    if-eqz v0, +005h
    const/4 v0, 0
    move v8, v0
    goto +3h
    move/from16 v8, v16
    move-object v1, v9
    move-wide v2, v10
    move-wide v4, v12
    move-wide v6, v14
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/CreditsBalance;-><init>(J J J Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.CreditsBalance  long  long  long  boolean  int  java.lang.Object)com.bytedance.trae.conversation.CreditsBalance
    .registers 18
    # ins_size=10
    move-object v0, v8
    and-int/lit8 v1, v16, 1
    if-eqz v1, +005h
    iget-wide v1, v0, Lcom/bytedance/trae/conversation/CreditsBalance;->total J
    goto +2h
    move-wide v1, v9
    and-int/lit8 v3, v16, 2
    if-eqz v3, +005h
    iget-wide v3, v0, Lcom/bytedance/trae/conversation/CreditsBalance;->used J
    goto +2h
    move-wide v3, v11
    and-int/lit8 v5, v16, 4
    if-eqz v5, +005h
    iget-wide v5, v0, Lcom/bytedance/trae/conversation/CreditsBalance;->remaining J
    goto +2h
    move-wide v5, v13
    and-int/lit8 v7, v16, 8
    if-eqz v7, +005h
    iget-boolean v7, v0, Lcom/bytedance/trae/conversation/CreditsBalance;->infinite Z
    goto +2h
    move v7, v15
    move-wide v9, v1
    move-wide v11, v3
    move-wide v13, v5
    move v15, v7
    invoke-virtual/range v8 ... v15, Lcom/bytedance/trae/conversation/CreditsBalance;->copy(J J J Z)Lcom/bytedance/trae/conversation/CreditsBalance;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/CreditsBalance;->total J
    return-wide v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/CreditsBalance;->used J
    return-wide v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/CreditsBalance;->remaining J
    return-wide v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/CreditsBalance;->infinite Z
    return v0
.end method

.method public final copy(long  long  long  boolean)com.bytedance.trae.conversation.CreditsBalance
    .registers 17
    # ins_size=8
    new-instance v8, Lcom/bytedance/trae/conversation/CreditsBalance;
    move-object v0, v8
    move-wide v1, v10
    move-wide v3, v12
    move-wide v5, v14
    move/from16 v7, v16
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/CreditsBalance;-><init>(J J J Z)V
    return-object v8
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/CreditsBalance;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/CreditsBalance;
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/CreditsBalance;->total J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/CreditsBalance;->total J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/CreditsBalance;->used J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/CreditsBalance;->used J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/CreditsBalance;->remaining J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/CreditsBalance;->remaining J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/CreditsBalance;->infinite Z
    iget-boolean v8, v8, Lcom/bytedance/trae/conversation/CreditsBalance;->infinite Z
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getInfinite()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/CreditsBalance;->infinite Z
    return v0
.end method

.method public final getRemaining()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/CreditsBalance;->remaining J
    return-wide v0
.end method

.method public final getTotal()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/CreditsBalance;->total J
    return-wide v0
.end method

.method public final getUsed()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/CreditsBalance;->used J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/conversation/CreditsBalance;->total J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/CreditsBalance;->used J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/CreditsBalance;->remaining J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/CreditsBalance;->infinite Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CreditsBalance(total="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/CreditsBalance;->total J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", used="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/CreditsBalance;->used J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", remaining="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/CreditsBalance;->remaining J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", infinite="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/CreditsBalance;->infinite Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
