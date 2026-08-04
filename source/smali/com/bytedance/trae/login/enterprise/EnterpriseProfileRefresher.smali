# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;
.super Ljava/lang/Object;
.source "EnterpriseProfileRefresher.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;
.field public static final LOGIN_PLATFORM_ENTERPRISE:Ljava/lang/String;
.field private static refreshProvider:Lkotlin/jvm/functions/Function2;
.field private static updateProfileProvider:Lkotlin/jvm/functions/Function2;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getRefreshProvider()kotlin.jvm.functions.Function2
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->refreshProvider Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public final getUpdateProfileProvider()kotlin.jvm.functions.Function2
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->updateProfileProvider Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public final hasRefreshProvider()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->refreshProvider Lkotlin/jvm/functions/Function2;
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final isEnterpriseLogin()boolean
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getLoginPlatform()Ljava/lang/String;
    move-result-object v0
    const-string v1, "enterprise"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    return v0
.end method

.method public final refresh(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->refreshProvider Lkotlin/jvm/functions/Function2;
    if-eqz v0, +007h
    invoke-interface v0, v2, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
    const/4 v2, 0
    return-object v2
.end method

.method public final setRefreshProvider(kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->refreshProvider Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final setUpdateProfileProvider(kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->updateProfileProvider Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final updateUserProfile(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher$updateUserProfile$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher$updateUserProfile$1;
    iget v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher$updateUserProfile$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher$updateUserProfile$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher$updateUserProfile$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher$updateUserProfile$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher$updateUserProfile$1;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher$updateUserProfile$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher$updateUserProfile$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +010h
    if-ne v2, v4, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +19h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->updateProfileProvider Lkotlin/jvm/functions/Function2;
    if-eqz v7, +014h
    iput v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher$updateUserProfile$1;->label I
    invoke-interface v7, v6, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    check-cast v7, Ljava/lang/Boolean;
    invoke-virtual v7, Ljava/lang/Boolean;->booleanValue()Z
    move-result v6
    if-ne v6, v4, +003h
    move v3, v4
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v6
    return-object v6
.end method
