# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/praise/PraiseRatingConfig;
.super Ljava/lang/Object;
.source "PraiseDialogTrigger.kt"

.field public static final Companion:Lcom/bytedance/trae/praise/PraiseRatingConfig$Companion;
.field private static final DEFAULT:Lcom/bytedance/trae/praise/PraiseRatingConfig;
.field private final enable:Z
.field private final ignoreUgRule:Z
.field private final leastChatTimesBeforeTrigger:I
.field private final maxCount:I
.field private final refuseBlockTimeHours:J


.method static constructor <clinit>()void
    .registers 9
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/praise/PraiseRatingConfig$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/praise/PraiseRatingConfig$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->Companion Lcom/bytedance/trae/praise/PraiseRatingConfig$Companion;
    new-instance v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;
    const/4 v3, 0
    const/4 v4, 3
    const/4 v5, 2
    const-wide/16 v6, 168
    const/4 v8, 1
    move-object v2, v0
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/praise/PraiseRatingConfig;-><init>(Z I I J Z)V
    sput-object v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->DEFAULT Lcom/bytedance/trae/praise/PraiseRatingConfig;
    return-void 
.end method

.method public constructor <init>(boolean  int  int  long  boolean)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->enable Z
    iput v2, v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->leastChatTimesBeforeTrigger I
    iput v3, v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->maxCount I
    iput-wide v4, v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->refuseBlockTimeHours J
    iput-boolean v6, v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->ignoreUgRule Z
    return-void 
.end method

.method public static final synthetic access$getDEFAULT$cp()com.bytedance.trae.praise.PraiseRatingConfig
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/praise/PraiseRatingConfig;->DEFAULT Lcom/bytedance/trae/praise/PraiseRatingConfig;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.praise.PraiseRatingConfig  boolean  int  int  long  boolean  int  java.lang.Object)com.bytedance.trae.praise.PraiseRatingConfig
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-boolean v5, v4, Lcom/bytedance/trae/praise/PraiseRatingConfig;->enable Z
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget v6, v4, Lcom/bytedance/trae/praise/PraiseRatingConfig;->leastChatTimesBeforeTrigger I
    move v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget v7, v4, Lcom/bytedance/trae/praise/PraiseRatingConfig;->maxCount I
    move v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-wide v8, v4, Lcom/bytedance/trae/praise/PraiseRatingConfig;->refuseBlockTimeHours J
    move-wide v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-boolean v10, v4, Lcom/bytedance/trae/praise/PraiseRatingConfig;->ignoreUgRule Z
    move v3, v10
    move-object v6, v4
    move v7, v5
    move v8, v12
    move v9, v0
    move-wide v10, v1
    move v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/praise/PraiseRatingConfig;->copy(Z I I J Z)Lcom/bytedance/trae/praise/PraiseRatingConfig;
    move-result-object v4
    return-object v4
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/praise/PraiseRatingConfig;->enable Z
    return v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/praise/PraiseRatingConfig;->leastChatTimesBeforeTrigger I
    return v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/praise/PraiseRatingConfig;->maxCount I
    return v0
.end method

.method public final component4()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/praise/PraiseRatingConfig;->refuseBlockTimeHours J
    return-wide v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/praise/PraiseRatingConfig;->ignoreUgRule Z
    return v0
.end method

.method public final copy(boolean  int  int  long  boolean)com.bytedance.trae.praise.PraiseRatingConfig
    .registers 15
    # ins_size=7
    new-instance v7, Lcom/bytedance/trae/praise/PraiseRatingConfig;
    move-object v0, v7
    move v1, v9
    move v2, v10
    move v3, v11
    move-wide v4, v12
    move v6, v14
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/praise/PraiseRatingConfig;-><init>(Z I I J Z)V
    return-object v7
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/praise/PraiseRatingConfig;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/praise/PraiseRatingConfig;
    iget-boolean v1, v7, Lcom/bytedance/trae/praise/PraiseRatingConfig;->enable Z
    iget-boolean v3, v8, Lcom/bytedance/trae/praise/PraiseRatingConfig;->enable Z
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/praise/PraiseRatingConfig;->leastChatTimesBeforeTrigger I
    iget v3, v8, Lcom/bytedance/trae/praise/PraiseRatingConfig;->leastChatTimesBeforeTrigger I
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/praise/PraiseRatingConfig;->maxCount I
    iget v3, v8, Lcom/bytedance/trae/praise/PraiseRatingConfig;->maxCount I
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/praise/PraiseRatingConfig;->refuseBlockTimeHours J
    iget-wide v5, v8, Lcom/bytedance/trae/praise/PraiseRatingConfig;->refuseBlockTimeHours J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/praise/PraiseRatingConfig;->ignoreUgRule Z
    iget-boolean v8, v8, Lcom/bytedance/trae/praise/PraiseRatingConfig;->ignoreUgRule Z
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getEnable()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/praise/PraiseRatingConfig;->enable Z
    return v0
.end method

.method public final getIgnoreUgRule()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/praise/PraiseRatingConfig;->ignoreUgRule Z
    return v0
.end method

.method public final getLeastChatTimesBeforeTrigger()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/praise/PraiseRatingConfig;->leastChatTimesBeforeTrigger I
    return v0
.end method

.method public final getMaxCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/praise/PraiseRatingConfig;->maxCount I
    return v0
.end method

.method public final getRefuseBlockTimeHours()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/praise/PraiseRatingConfig;->refuseBlockTimeHours J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/praise/PraiseRatingConfig;->enable Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/praise/PraiseRatingConfig;->leastChatTimesBeforeTrigger I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/praise/PraiseRatingConfig;->maxCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/praise/PraiseRatingConfig;->refuseBlockTimeHours J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/praise/PraiseRatingConfig;->ignoreUgRule Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "PraiseRatingConfig(enable="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v3, Lcom/bytedance/trae/praise/PraiseRatingConfig;->enable Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", leastChatTimesBeforeTrigger="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/praise/PraiseRatingConfig;->leastChatTimesBeforeTrigger I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", maxCount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/praise/PraiseRatingConfig;->maxCount I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", refuseBlockTimeHours="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/praise/PraiseRatingConfig;->refuseBlockTimeHours J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", ignoreUgRule="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/praise/PraiseRatingConfig;->ignoreUgRule Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
