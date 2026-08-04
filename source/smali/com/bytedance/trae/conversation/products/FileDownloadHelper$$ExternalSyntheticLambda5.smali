# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Ljava/lang/String;
.field public final synthetic f$4:Lkotlinx/coroutines/CoroutineScope;
.field public final synthetic f$5:Lkotlin/jvm/functions/Function3;
.field public final synthetic f$6:Z
.field public final synthetic f$7:J


.method public synthetic constructor <init>(com.bytedance.trae.conversation.products.FileDownloadHelper  java.lang.String  java.lang.String  java.lang.String  kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function3  boolean  long)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$2 Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$3 Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$4 Lkotlinx/coroutines/CoroutineScope;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$5 Lkotlin/jvm/functions/Function3;
    iput-boolean v7, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$6 Z
    iput-wide v8, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$7 J
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v1, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$1 Ljava/lang/String;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$2 Ljava/lang/String;
    iget-object v3, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$3 Ljava/lang/String;
    iget-object v4, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$4 Lkotlinx/coroutines/CoroutineScope;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$5 Lkotlin/jvm/functions/Function3;
    iget-boolean v6, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$6 Z
    iget-wide v7, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$$ExternalSyntheticLambda5;->f$7 J
    check-cast v11, Ljava/lang/Boolean;
    invoke-virtual v11, Ljava/lang/Boolean;->booleanValue()Z
    move-result v9
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->$r8$lambda$3UsG7s2EdR7bYAaJm-HMDhD0pGs(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J Z)Lkotlin/Unit;
    move-result-object v11
    return-object v11
.end method
