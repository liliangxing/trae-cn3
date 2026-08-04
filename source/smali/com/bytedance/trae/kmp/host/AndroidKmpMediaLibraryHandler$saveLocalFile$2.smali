# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "AndroidKmpMediaLibraryHandler.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $displayName:Ljava/lang/String;
.field final synthetic $localUri:Ljava/lang/String;
.field final synthetic $mimeType:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;


.method constructor <init>(com.bytedance.trae.kmp.host.AndroidKmpMediaLibraryHandler  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->this$0 Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->$localUri Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->$displayName Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->$mimeType Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;
    iget-object v1, v6, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->this$0 Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;
    iget-object v2, v6, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->$localUri Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->$displayName Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->$mimeType Ljava/lang/String;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;-><init>(Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->label I
    const/4 v2, 1
    if-eqz v1, +014h
    if-ne v1, v2, +00ah
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +5bh
    move-exception v7
    goto +68h
    move-exception v7
    goto +72h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->this$0 Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;
    iget-object v1, v6, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->$localUri Ljava/lang/String;
    invoke-static v7, v1, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->access$resolveLocalFile(Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler; Ljava/lang/String;)Ljava/io/File;
    move-result-object v7
    invoke-virtual v7, Ljava/io/File;->isFile()Z
    move-result v1
    if-eqz v1, +042h
    iget-object v1, v6, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->$displayName Ljava/lang/String;
    const/16 v3, 47
    const/4 v4, 2
    const/4 v5, 0
    invoke-static v1, v3, v5, v4, v5, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +006h
    invoke-virtual v7, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    sget v3, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v4, 29
    if-lt v3, v4, +00eh
    iget-object v0, v6, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->this$0 Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    iget-object v2, v6, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->$mimeType Ljava/lang/String;
    invoke-static v0, v7, v1, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->access$saveWithMediaStore(Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler; Ljava/io/File; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;
    move-result-object v7
    goto +2eh
    iget-object v3, v6, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->this$0 Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    iget-object v4, v6, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->$mimeType Ljava/lang/String;
    move-object v5, v6
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$saveLocalFile$2;->label I
    invoke-static v3, v7, v1, v4, v5, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler;->access$saveWithFileApi(Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    check-cast v7, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;
    goto +18h
    const-string v7, "Local file does not exist"
    new-instance v0, Ljava/lang/IllegalStateException;
    invoke-virtual v7, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v0, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    new-instance v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;
    const/4 v1, 0
    invoke-virtual v7, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v7
    invoke-direct v0, v1, v7, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;-><init>(Z Ljava/lang/String;)V
    move-object v7, v0
    return-object v7
    throw v7
    :try_start_0xb
    :try_start_0x1e
.end method
