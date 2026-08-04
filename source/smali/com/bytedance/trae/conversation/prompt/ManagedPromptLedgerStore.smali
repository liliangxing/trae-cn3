# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
.super Ljava/lang/Object;
.source "ManagedPromptLedger.kt"

.field private static final ACCOUNT_KEY_PREFIX:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
.field private static final REPO_NAME:Ljava/lang/String;
.field private static final ledger:Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    invoke-direct v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    new-instance v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;
    new-instance v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore$ledger$1;
    invoke-direct v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore$ledger$1;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStorage;
    const/4 v2, 0
    const/4 v3, 2
    invoke-direct v0, v1, v2, v3, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStorage; Lcom/google/gson/Gson; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->ledger Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$repo(com.bytedance.trae.conversation.prompt.ManagedPromptLedgerStore)com.bytedance.keva.Keva
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->repo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic recordShown$default(com.bytedance.trae.conversation.prompt.ManagedPromptLedgerStore  java.lang.String  com.bytedance.trae.conversation.prompt.ManagedPromptCandidate  long  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 4
    if-eqz v5, +006h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->recordShown(Ljava/lang/String; Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate; J)V
    return-void 
.end method

.method private final repo()com.bytedance.keva.Keva
    .registers 3
    # ins_size=1
    const-string/jumbo v0, trae_managed_prompt_ledger
    invoke-static v0, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "getRepo(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public final clearAllForDebug()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->repo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/keva/Keva;->clear()V
    return-void 
.end method

.method public final clearPendingBilling(java.lang.String  int)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, userId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->ledger Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->clearPendingBilling(Ljava/lang/String; I)V
    return-void 
.end method

.method public final mergeExposureHistory(java.lang.String  java.util.Map  long)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, userId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, shownVersions
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->ledger Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;
    invoke-virtual v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->mergeExposureHistory(Ljava/lang/String; Ljava/util/Map; J)V
    return-void 
.end method

.method public final recordShown(java.lang.String  com.bytedance.trae.conversation.prompt.ManagedPromptCandidate  long)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, userId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "candidate"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->ledger Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;
    invoke-virtual v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->recordShown(Ljava/lang/String; Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate; J)V
    return-void 
.end method

.method public final savePendingBilling(java.lang.String  com.bytedance.trae.conversation.prompt.PendingBillingPromptRecord)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, userId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "pending"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->ledger Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->savePendingBilling(Ljava/lang/String; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;)V
    return-void 
.end method

.method public final snapshot(java.lang.String)com.bytedance.trae.conversation.prompt.ManagedPromptLedgerState
    .registers 3
    # ins_size=2
    const-string/jumbo v0, userId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->ledger Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->snapshot(Ljava/lang/String;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v2
    return-object v2
.end method
