# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/DefaultCliListService;
.super Ljava/lang/Object;
.source "CliListRepository.kt"

.implements Lcom/bytedance/trae/conversation/CliListService;

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/DefaultCliListService;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/DefaultCliListService;
    invoke-direct v0, Lcom/bytedance/trae/conversation/DefaultCliListService;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/DefaultCliListService;->INSTANCE Lcom/bytedance/trae/conversation/DefaultCliListService;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getOnboardingState(kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/im/service/IListClisService;->Companion Lcom/bytedance/trae/im/service/IListClisService$Companion;
    new-instance v1, Lcom/bytedance/trae/conversation/DefaultCliListService$getOnboardingState$2;
    const/4 v2, 0
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/DefaultCliListService$getOnboardingState$2;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/im/service/IListClisService$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method

.method public listClis(com.bytedance.trae.im.service.CliListSource  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/im/service/IListClisService;->Companion Lcom/bytedance/trae/im/service/IListClisService$Companion;
    new-instance v1, Lcom/bytedance/trae/conversation/DefaultCliListService$listClis$2;
    const/4 v2, 0
    invoke-direct v1, v4, v2, Lcom/bytedance/trae/conversation/DefaultCliListService$listClis$2;-><init>(Lcom/bytedance/trae/im/service/CliListSource; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/im/service/IListClisService$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method

.method public renameCli(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/im/service/IListClisService;->Companion Lcom/bytedance/trae/im/service/IListClisService$Companion;
    new-instance v1, Lcom/bytedance/trae/conversation/DefaultCliListService$renameCli$2;
    const/4 v2, 0
    invoke-direct v1, v4, v5, v2, Lcom/bytedance/trae/conversation/DefaultCliListService$renameCli$2;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-virtual v0, v1, v6, Lcom/bytedance/trae/im/service/IListClisService$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method

.method public unregisterCli(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/im/service/IListClisService;->Companion Lcom/bytedance/trae/im/service/IListClisService$Companion;
    new-instance v1, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;
    const/4 v2, 0
    invoke-direct v1, v4, v2, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/im/service/IListClisService$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method
