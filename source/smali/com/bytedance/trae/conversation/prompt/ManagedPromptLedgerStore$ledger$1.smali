# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore$ledger$1;
.super Ljava/lang/Object;
.source "ManagedPromptLedger.kt"

.implements Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStorage;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public read(java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    const-string/jumbo v0, userId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    invoke-static v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->access$repo(Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "account_"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const/4 v1, 0
    invoke-virtual v0, v4, v1, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    return-object v4
.end method

.method public write(java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, userId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, serializedState
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    invoke-static v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->access$repo(Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "account_"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, v5, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
