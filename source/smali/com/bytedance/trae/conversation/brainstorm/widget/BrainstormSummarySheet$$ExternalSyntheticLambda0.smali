# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Landroid/content/Context;


.method public synthetic constructor <init>(android.content.Context)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$$ExternalSyntheticLambda0;->f$0 Landroid/content/Context;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$$ExternalSyntheticLambda0;->f$0 Landroid/content/Context;
    check-cast v2, Ljava/lang/String;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;->$r8$lambda$5Em9N1Tq58S-03vq1RnAhWPuFjM(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/CharSequence;
    move-result-object v2
    return-object v2
.end method
