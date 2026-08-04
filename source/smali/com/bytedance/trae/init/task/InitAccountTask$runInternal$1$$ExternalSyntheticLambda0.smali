# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroid/app/Activity;


.method public synthetic constructor <init>(android.app.Activity)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$1$$ExternalSyntheticLambda0;->f$0 Landroid/app/Activity;
    return-void 
.end method

.method public final run()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$1$$ExternalSyntheticLambda0;->f$0 Landroid/app/Activity;
    invoke-static v0, Lcom/bytedance/trae/init/task/InitAccountTask$runInternal$1;->$r8$lambda$JSPW4DpaYhXaKr_rAN8GPoLbnHM(Landroid/app/Activity;)V
    return-void 
.end method
