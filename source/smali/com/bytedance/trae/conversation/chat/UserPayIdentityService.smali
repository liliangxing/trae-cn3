# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;
.super Ljava/lang/Object;
.source "UserPayIdentityService.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;
.field private static proxy:Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->INSTANCE Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final fetchBillingUpgradePreparation(com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchBillingUpgradePreparation$1;
    if-eqz v0, +012h
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchBillingUpgradePreparation$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchBillingUpgradePreparation$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v5, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchBillingUpgradePreparation$1;->label I
    sub-int/2addr v5, v2
    iput v5, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchBillingUpgradePreparation$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchBillingUpgradePreparation$1;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchBillingUpgradePreparation$1;-><init>(Lkotlin/coroutines/Continuation;)V
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchBillingUpgradePreparation$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchBillingUpgradePreparation$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +19h
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v5, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v5, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->proxy Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;
    if-eqz v5, +00fh
    iput v3, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchBillingUpgradePreparation$1;->label I
    invoke-interface v5, v4, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;->fetchBillingUpgradePreparation(Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v1, +003h
    return-object v1
    check-cast v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;
    if-nez v5, +007h
    sget-object v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;
    return-object v5
.end method

.method public static final fetchCreditsBalanceData(kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->proxy Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;
    if-eqz v0, +007h
    invoke-interface v0, v1, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;->fetchCreditsBalanceData(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
    const/4 v1, 0
    return-object v1
.end method

.method public static final fetchKnownUserPayIdentity(kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->proxy Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;
    if-eqz v0, +007h
    invoke-interface v0, v1, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;->fetchKnownUserPayIdentity(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
    const/4 v1, 0
    return-object v1
.end method

.method public static final fetchUserPayIdentity(kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=1
    instance-of v0, v4, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchUserPayIdentity$1;
    if-eqz v0, +012h
    move-object v0, v4
    check-cast v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchUserPayIdentity$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchUserPayIdentity$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v4, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchUserPayIdentity$1;->label I
    sub-int/2addr v4, v2
    iput v4, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchUserPayIdentity$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchUserPayIdentity$1;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchUserPayIdentity$1;-><init>(Lkotlin/coroutines/Continuation;)V
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchUserPayIdentity$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchUserPayIdentity$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +19h
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->proxy Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;
    if-eqz v4, +012h
    iput v3, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$fetchUserPayIdentity$1;->label I
    invoke-interface v4, v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;->fetchUserPayIdentity(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v1, +003h
    return-object v1
    check-cast v4, Ljava/lang/Number;
    invoke-virtual v4, Ljava/lang/Number;->intValue()I
    move-result v4
    goto +2h
    const/4 v4, 0
    invoke-static v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v4
    return-object v4
.end method

.method public static final fetchUserUsageQuotaData(kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->proxy Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;
    if-nez v0, +00eh
    new-instance v7, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;
    const-wide/16 v2, 0
    const-wide/16 v4, 0
    const/4 v6, 0
    move-object v1, v7
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;-><init>(J J Z)V
    return-object v7
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v0, v7, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;->fetchUserUsageQuotaData(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
.end method

.method public static final getCreditsBalanceData()com.bytedance.trae.conversation.chat.UserPayIdentityService$CreditsBalanceData
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->proxy Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;->getCreditsBalanceData()Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public static final getKnownUserPayIdentity()java.lang.Integer
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->proxy Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;->getKnownUserPayIdentity()Ljava/lang/Integer;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public static final getUserPayIdentity()int
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->proxy Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;->getUserPayIdentity()I
    move-result v0
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public static final getUserUsageQuotaData()com.bytedance.trae.conversation.chat.UserPayIdentityService$UsageQuotaData
    .registers 7
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->proxy Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;->getUserUsageQuotaData()Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;
    move-result-object v0
    if-nez v0, +00dh
    new-instance v0, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;
    const-wide/16 v2, 0
    const-wide/16 v4, 0
    const/4 v6, 0
    move-object v1, v0
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$UsageQuotaData;-><init>(J J Z)V
    return-object v0
.end method

.method public static final registerUserPayIdentityProxy(com.bytedance.trae.conversation.chat.UserPayIdentityService$IUserPayIdentityProxy)void
    .registers 2
    # ins_size=1
    const-string v0, "proxy"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v1, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->proxy Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$IUserPayIdentityProxy;
    return-void 
.end method
