# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$scan$2$1;
.super Ljava/lang/Object;
.source "AndroidKmpMediaLibraryHandler.kt"

.implements Landroid/media/MediaScannerConnection$OnScanCompletedListener;

.field final synthetic $continuation:Lkotlinx/coroutines/CancellableContinuation;
.field final synthetic $file:Ljava/io/File;


.method constructor <init>(kotlinx.coroutines.CancellableContinuation  java.io.File)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$scan$2$1;->$continuation Lkotlinx/coroutines/CancellableContinuation;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$scan$2$1;->$file Ljava/io/File;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final onScanCompleted(java.lang.String  android.net.Uri)void
    .registers 6
    # ins_size=3
    iget-object v4, v3, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$scan$2$1;->$continuation Lkotlinx/coroutines/CancellableContinuation;
    invoke-interface v4, Lkotlinx/coroutines/CancellableContinuation;->isActive()Z
    move-result v4
    if-nez v4, +003h
    return-void 
    iget-object v4, v3, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$scan$2$1;->$continuation Lkotlinx/coroutines/CancellableContinuation;
    check-cast v4, Lkotlin/coroutines/Continuation;
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    if-eqz v5, +00bh
    new-instance v5, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;
    const/4 v0, 1
    const/4 v1, 2
    const/4 v2, 0
    invoke-direct v5, v0, v2, v1, v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;-><init>(Z Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +eh
    iget-object v5, v3, Lcom/bytedance/trae/kmp/host/AndroidKmpMediaLibraryHandler$scan$2$1;->$file Ljava/io/File;
    invoke-virtual v5, Ljava/io/File;->delete()Z
    new-instance v5, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;
    const/4 v0, 0
    const-string v1, "Failed to publish media library file"
    invoke-direct v5, v0, v1, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;-><init>(Z Ljava/lang/String;)V
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    invoke-interface v4, v5, Lkotlin/coroutines/Continuation;->resumeWith(Ljava/lang/Object;)V
    return-void 
.end method
