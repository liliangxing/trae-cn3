# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/CreditsBalancePolicy;
.super Ljava/lang/Object;
.source "CreditsBalancePolicy.kt"

.field public static final DEFAULT_CLOSE_INTERVAL_MILLIS:J
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/CreditsBalancePolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/CreditsBalancePolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/CreditsBalancePolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/CreditsBalancePolicy;->INSTANCE Lcom/bytedance/trae/conversation/CreditsBalancePolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic shouldShowReminder$default(com.bytedance.trae.conversation.CreditsBalancePolicy  long  long  long  long  int  java.lang.Object)boolean
    .registers 22
    # ins_size=11
    and-int/lit8 v0, v20, 8
    if-eqz v0, +007h
    const-wide/32 v0, 259200000
    move-wide v9, v0
    goto +3h
    move-wide/from16 v9, v18
    move-object v2, v11
    move-wide v3, v12
    move-wide v5, v14
    move-wide/from16 v7, v16
    invoke-virtual/range v2 ... v10, Lcom/bytedance/trae/conversation/CreditsBalancePolicy;->shouldShowReminder(J J J J)Z
    move-result v0
    return v0
.end method

.method public final belongsToCurrentUser(java.lang.String  java.lang.String  boolean)boolean
    .registers 5
    # ins_size=4
    const-string v0, "ownerUserId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v4, +014h
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    const/4 v0, 1
    xor-int/2addr v4, v0
    if-eqz v4, +009h
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final from(java.lang.Long  java.lang.Long)com.bytedance.trae.conversation.CreditsBalance
    .registers 19
    # ins_size=3
    const/4 v0, 0
    if-eqz v17, +04dh
    move-object/from16 v1, v17
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->longValue()J
    move-result-wide v1
    const-wide/16 v3, 0
    cmp-long v1, v1, v3
    const/4 v2, 1
    const/4 v5, 0
    if-ltz v1, +004h
    move v1, v2
    goto +2h
    move v1, v5
    if-eqz v1, +005h
    move-object/from16 v1, v17
    goto +2h
    move-object v1, v0
    if-eqz v1, +032h
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v7
    if-eqz v18, +02ch
    move-object/from16 v1, v18
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->longValue()J
    move-result-wide v9
    cmp-long v1, v9, v3
    if-ltz v1, +003h
    goto +2h
    move v2, v5
    if-eqz v2, +005h
    move-object/from16 v1, v18
    goto +2h
    move-object v1, v0
    if-eqz v1, +016h
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v9
    new-instance v0, Lcom/bytedance/trae/conversation/CreditsBalance;
    sub-long v1, v7, v9
    invoke-static v1, v2, v3, v4, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v11
    const/4 v13, 0
    const/16 v14, 8
    const/4 v15, 0
    move-object v6, v0
    invoke-direct/range v6 ... v15, Lcom/bytedance/trae/conversation/CreditsBalance;-><init>(J J J Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method

.method public final isLowBalance(long)boolean
    .registers 7
    # ins_size=3
    const-wide/16 v0, 1
    cmp-long v0, v0, v5
    const/4 v1, 0
    if-gtz v0, +009h
    const-wide/16 v2, 11
    cmp-long v5, v5, v2
    if-gez v5, +003h
    const/4 v1, 1
    return v1
.end method

.method public final shouldShowReminder(long  long  long  long)boolean
    .registers 11
    # ins_size=9
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/conversation/CreditsBalancePolicy;->isLowBalance(J)Z
    move-result v3
    const/4 v4, 0
    if-nez v3, +003h
    return v4
    const-wide/16 v0, 0
    cmp-long v3, v5, v0
    const/4 v0, 1
    if-gtz v3, +003h
    return v0
    sub-long/2addr v7, v5
    cmp-long v3, v7, v9
    if-ltz v3, +003h
    move v4, v0
    return v4
.end method
