# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Ljava/lang/String;
.field public final synthetic f$4:Ljava/lang/String;
.field public final synthetic f$5:Ljava/lang/String;
.field public final synthetic f$6:J


.method public synthetic constructor <init>(com.bytedance.trae.conversation.products.CodeChangedListActivity  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;->f$2 Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;->f$3 Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;->f$4 Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;->f$5 Ljava/lang/String;
    iput-wide v7, v0, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;->f$6 J
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;
    iget-object v1, v9, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iget-object v2, v9, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;->f$2 Ljava/lang/String;
    iget-object v3, v9, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;->f$3 Ljava/lang/String;
    iget-object v4, v9, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;->f$4 Ljava/lang/String;
    iget-object v5, v9, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;->f$5 Ljava/lang/String;
    iget-wide v6, v9, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;->f$6 J
    move-object v8, v10
    check-cast v8, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->$r8$lambda$0OzVgBxe9yxlkos1A6HeRUz98kA(Lcom/bytedance/trae/conversation/products/CodeChangedListActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/bytedance/trae/im/model/FileDiffInfo;)Lkotlin/Unit;
    move-result-object v10
    return-object v10
.end method
