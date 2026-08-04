# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/AccountStatusManager;
.super Ljava/lang/Object;
.source "AccountStatusManager.kt"

.field private static final ACCOUNT_STATUS_STICKY:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/login/service/AccountStatusManager;
.field private static mAccountStatusList:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/service/AccountStatusManager;
    invoke-direct v0, Lcom/bytedance/trae/login/service/AccountStatusManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/service/AccountStatusManager;->INSTANCE Lcom/bytedance/trae/login/service/AccountStatusManager;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sput-object v0, Lcom/bytedance/trae/login/service/AccountStatusManager;->mAccountStatusList Ljava/util/List;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final addAccountStatusCallback(com.bytedance.trae.login.api.IAccountStatusListener  boolean)void
    .registers 4
    # ins_size=3
    const-string v0, "callback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/service/AccountStatusManager;->mAccountStatusList Ljava/util/List;
    if-eqz v0, +005h
    invoke-interface v0, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    if-eqz v3, +01fh
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getJwtToken()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_IN Lcom/bytedance/trae/login/api/AccountStatus;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_OUT Lcom/bytedance/trae/login/api/AccountStatus;
    const-string v0, "get_account_status_siticky"
    invoke-interface v2, v3, v0, Lcom/bytedance/trae/login/api/IAccountStatusListener;->onAccountStatusChanged(Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String;)V
    return-void 
.end method

.method public final loginStatusChanged(com.bytedance.trae.login.api.AccountStatus  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, status
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "businessScene"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/service/AccountStatusManager;->mAccountStatusList Ljava/util/List;
    if-eqz v0, +018h
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/IAccountStatusListener;
    invoke-interface v1, v3, v4, Lcom/bytedance/trae/login/api/IAccountStatusListener;->onAccountStatusChanged(Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String;)V
    goto -fh
    return-void 
.end method

.method public final removeAccountStatusCallback(com.bytedance.trae.login.api.IAccountStatusListener)void
    .registers 3
    # ins_size=2
    const-string v0, "callback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/service/AccountStatusManager;->mAccountStatusList Ljava/util/List;
    if-eqz v0, +005h
    invoke-interface v0, v2, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    return-void 
.end method
