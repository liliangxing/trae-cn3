# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
.field public final synthetic f$1:Ljava/io/File;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Ljava/lang/String;
.field public final synthetic f$4:Lkotlinx/coroutines/CoroutineScope;
.field public final synthetic f$5:Lkotlin/jvm/functions/Function3;
.field public final synthetic f$6:J


.method public synthetic constructor <init>(com.bytedance.trae.conversation.products.FileDownloadHelper  java.io.File  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  long)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;->f$1 Ljava/io/File;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;->f$2 Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;->f$3 Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;->f$4 Lkotlinx/coroutines/CoroutineScope;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;->f$5 Lkotlin/jvm/functions/Function3;
    iput-wide v7, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;->f$6 J
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v1, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;->f$1 Ljava/io/File;
    iget-object v2, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;->f$2 Ljava/lang/String;
    iget-object v3, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;->f$3 Ljava/lang/String;
    iget-object v4, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;->f$4 Lkotlinx/coroutines/CoroutineScope;
    iget-object v5, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;->f$5 Lkotlin/jvm/functions/Function3;
    iget-wide v6, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda4;->f$6 J
    check-cast v10, Ljava/lang/Boolean;
    invoke-virtual v10, Ljava/lang/Boolean;->booleanValue()Z
    move-result v8
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->$r8$lambda$-FebZVsQd7tbvVfpbqFjd8pltsI(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; J Z)Lkotlin/Unit;
    move-result-object v10
    return-object v10
.end method
