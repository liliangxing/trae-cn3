# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;
.super Ljava/lang/Object;
.source "UserPayIdentityService.kt"

.field private final infinite:Z
.field private final remaining:J
.field private final total:J
.field private final used:J
.field private final userId:Ljava/lang/String;


.method public constructor <init>(java.lang.String  long  long  long  boolean)void
    .registers 10
    # ins_size=9
    const-string/jumbo v0, userId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->userId Ljava/lang/String;
    iput-wide v3, v1, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->total J
    iput-wide v5, v1, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->used J
    iput-wide v7, v1, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->remaining J
    iput-boolean v9, v1, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->infinite Z
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  long  long  long  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 21
    # ins_size=11
    and-int/lit8 v0, v19, 16
    if-eqz v0, +005h
    const/4 v0, 0
    move v9, v0
    goto +3h
    move/from16 v9, v18
    move-object v1, v10
    move-object v2, v11
    move-wide v3, v12
    move-wide v5, v14
    move-wide/from16 v7, v16
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;-><init>(Ljava/lang/String; J J J Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.UserPayIdentityService$CreditsBalanceData  java.lang.String  long  long  long  boolean  int  java.lang.Object)com.bytedance.trae.conversation.chat.UserPayIdentityService$CreditsBalanceData
    .registers 20
    # ins_size=11
    move-object v0, v9
    and-int/lit8 v1, v18, 1
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->userId Ljava/lang/String;
    goto +2h
    move-object v1, v10
    and-int/lit8 v2, v18, 2
    if-eqz v2, +005h
    iget-wide v2, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->total J
    goto +2h
    move-wide v2, v11
    and-int/lit8 v4, v18, 4
    if-eqz v4, +005h
    iget-wide v4, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->used J
    goto +2h
    move-wide v4, v13
    and-int/lit8 v6, v18, 8
    if-eqz v6, +005h
    iget-wide v6, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->remaining J
    goto +2h
    move-wide v6, v15
    and-int/lit8 v8, v18, 16
    if-eqz v8, +005h
    iget-boolean v8, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->infinite Z
    goto +3h
    move/from16 v8, v17
    move-object v10, v1
    move-wide v11, v2
    move-wide v13, v4
    move-wide v15, v6
    move/from16 v17, v8
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->copy(Ljava/lang/String; J J J Z)Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->userId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->total J
    return-wide v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->used J
    return-wide v0
.end method

.method public final component4()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->remaining J
    return-wide v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->infinite Z
    return v0
.end method

.method public final copy(java.lang.String  long  long  long  boolean)com.bytedance.trae.conversation.chat.UserPayIdentityService$CreditsBalanceData
    .registers 19
    # ins_size=9
    const-string/jumbo v0, userId
    move-object v2, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;
    move-object v1, v0
    move-wide v3, v12
    move-wide v5, v14
    move-wide/from16 v7, v16
    move/from16 v9, v18
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;-><init>(Ljava/lang/String; J J J Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->userId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->userId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->total J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->total J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->used J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->used J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->remaining J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->remaining J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->infinite Z
    iget-boolean v8, v8, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->infinite Z
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getInfinite()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->infinite Z
    return v0
.end method

.method public final getRemaining()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->remaining J
    return-wide v0
.end method

.method public final getTotal()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->total J
    return-wide v0
.end method

.method public final getUsed()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->used J
    return-wide v0
.end method

.method public final getUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->userId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->userId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->total J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->used J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->remaining J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->infinite Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CreditsBalanceData(userId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->userId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", total="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->total J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", used="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->used J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", remaining="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->remaining J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", infinite="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->infinite Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
