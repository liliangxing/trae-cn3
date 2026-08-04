# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroid/view/Window;
.field public final synthetic f$1:I


.method public synthetic constructor <init>(android.view.Window  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda0;->f$0 Landroid/view/Window;
    iput v2, v0, Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda0;->f$1 I
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda0;->f$0 Landroid/view/Window;
    iget v1, v2, Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda0;->f$1 I
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AgreementDialog;->$r8$lambda$I-Nk0SThe1Pjr8yvqjxuetIvWus(Landroid/view/Window; I)V
    return-void 
.end method
