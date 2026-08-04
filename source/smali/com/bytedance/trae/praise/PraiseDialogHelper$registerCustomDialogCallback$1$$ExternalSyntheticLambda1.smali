# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;


.method public synthetic constructor <init>(com.bytedance.praisedialoglib.callback.IPraiseDialogCallback)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;
    invoke-static v0, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1;->$r8$lambda$msReLjYk9ZPI-jL4DfEdUO4p2-k(Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
