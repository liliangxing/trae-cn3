# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final synthetic Lcom/bytedance/trae/conversation/ConversationActivity$observeManagedPrompts$1;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function1;
.implements Lkotlin/coroutines/jvm/internal/SuspendFunction;


.method constructor <init>(java.lang.Object)void
    .registers 9
    # ins_size=2
    const/4 v1, 1
    const-class v3, Lcom/bytedance/trae/conversation/ConversationActivity;
    const-string/jumbo v4, resolveManagedPromptsWhileResumed
    const-string/jumbo v5, resolveManagedPromptsWhileResumed(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    const/4 v6, 0
    move-object v0, v7
    move-object v2, v8
    invoke-direct/range v0 ... v6, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Object; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeManagedPrompts$1;->invoke(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeManagedPrompts$1;->receiver Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->access$resolveManagedPromptsWhileResumed(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method
