# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function3;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=4
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    check-cast v4, Ljava/lang/Integer;
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v4
    check-cast v5, Ljava/lang/String;
    check-cast v6, Ljava/lang/Long;
    invoke-virtual v6, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    invoke-static v0, v4, v5, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->$r8$lambda$2QtxCcQG6cw-EwTxI3Qnt6TPQik(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; I Ljava/lang/String; J)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
