# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/CreditsBalanceManager;
.super Ljava/lang/Object;
.source "CreditsBalanceManager.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/CreditsBalanceManager;
.field public static final KEY_LOW_BALANCE_CLOSE_TIME:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static final isFetching:Ljava/util/concurrent/atomic/AtomicBoolean;
.field private static final isInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;
.field private static final listeners:Ljava/util/concurrent/CopyOnWriteArraySet;
.field private static final refreshPending:Ljava/util/concurrent/atomic/AtomicBoolean;
.field private static final scope:Lkotlinx/coroutines/CoroutineScope;
.field private static final streamingMessageListener:Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;


.method public static synthetic $r8$lambda$8ZEpKgJiF2mVCva_1WaPtHRaV_8(com.bytedance.trae.im.model.ParsedChatMessage  boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->streamingMessageListener$lambda$0(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;
    invoke-direct v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->INSTANCE Lcom/bytedance/trae/conversation/CreditsBalanceManager;
    const/4 v0, 0
    const/4 v1, 1
    invoke-static v0, v1, v0, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v1, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->scope Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->listeners Ljava/util/concurrent/CopyOnWriteArraySet;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    sput-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->isFetching Ljava/util/concurrent/atomic/AtomicBoolean;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    sput-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->refreshPending Ljava/util/concurrent/atomic/AtomicBoolean;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    sput-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->isInitialized Ljava/util/concurrent/atomic/AtomicBoolean;
    new-instance v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager$$ExternalSyntheticLambda0;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->streamingMessageListener Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$belongsToCurrentUser(com.bytedance.trae.conversation.CreditsBalanceManager  com.bytedance.trae.conversation.chat.UserPayIdentityService$CreditsBalanceData)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->belongsToCurrentUser(Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$getListeners$p()java.util.concurrent.CopyOnWriteArraySet
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->listeners Ljava/util/concurrent/CopyOnWriteArraySet;
    return-object v0
.end method

.method public static final synthetic access$getRefreshPending$p()java.util.concurrent.atomic.AtomicBoolean
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->refreshPending Ljava/util/concurrent/atomic/AtomicBoolean;
    return-object v0
.end method

.method public static final synthetic access$isFetching$p()java.util.concurrent.atomic.AtomicBoolean
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->isFetching Ljava/util/concurrent/atomic/AtomicBoolean;
    return-object v0
.end method

.method private final belongsToCurrentUser(com.bytedance.trae.conversation.chat.UserPayIdentityService$CreditsBalanceData)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v3
    check-cast v1, Lcom/bytedance/trae/conversation/CreditsBalanceManager;
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v1, +00dh
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v0
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    check-cast v0, Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/conversation/CreditsBalancePolicy;->INSTANCE Lcom/bytedance/trae/conversation/CreditsBalancePolicy;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;->getUserId()Ljava/lang/String;
    move-result-object v4
    sget-object v2, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v2
    invoke-virtual v1, v4, v0, v2, Lcom/bytedance/trae/conversation/CreditsBalancePolicy;->belongsToCurrentUser(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v4
    return v4
    :try_start_0x1
.end method

.method private static final streamingMessageListener$lambda$0(com.bytedance.trae.im.model.ParsedChatMessage  boolean)void
    .registers 3
    # ins_size=2
    const-string v0, "<unused var>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v2, +007h
    sget-object v1, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->INSTANCE Lcom/bytedance/trae/conversation/CreditsBalanceManager;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->refresh()V
    return-void 
.end method

.method public final addListener(com.bytedance.trae.conversation.CreditsBalanceManager$OnBalanceChangedListener)void
    .registers 4
    # ins_size=2
    const-string v0, "listener"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->listeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v3, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    invoke-static Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->getCreditsBalanceData()Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;
    move-result-object v0
    if-eqz v0, +00fh
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->belongsToCurrentUser(Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +005h
    invoke-interface v3, v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager$OnBalanceChangedListener;->onBalanceChanged(Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;)V
    return-void 
.end method

.method public final init()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->isInitialized Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(Z Z)Z
    move-result v0
    if-eqz v0, +009h
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    sget-object v1, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->streamingMessageListener Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/IMService;->addStreamingMessageListener(Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;)V
    return-void 
.end method

.method public final refresh()void
    .registers 10
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v9, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->init()V
    sget-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->isFetching Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(Z Z)Z
    move-result v0
    if-nez v0, +008h
    sget-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->refreshPending Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-virtual v0, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    return-void 
    sget-object v3, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager$refresh$1;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/CreditsBalanceManager$refresh$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final removeListener(com.bytedance.trae.conversation.CreditsBalanceManager$OnBalanceChangedListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/CreditsBalanceManager;->listeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    return-void 
.end method
