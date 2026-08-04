# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroid/view/Window;
.field public final synthetic f$1:I
.field public final synthetic f$2:Landroidx/activity/ComponentActivity;


.method public synthetic constructor <init>(android.view.Window  int  androidx.activity.ComponentActivity)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda0;->f$0 Landroid/view/Window;
    iput v2, v0, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda0;->f$1 I
    iput-object v3, v0, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda0;->f$2 Landroidx/activity/ComponentActivity;
    return-void 
.end method

.method public final run()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda0;->f$0 Landroid/view/Window;
    iget v1, v3, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda0;->f$1 I
    iget-object v2, v3, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda0;->f$2 Landroidx/activity/ComponentActivity;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->$r8$lambda$suGfvvZ0PRGYwqbR9AeTdqPlWAk(Landroid/view/Window; I Landroidx/activity/ComponentActivity;)V
    return-void 
.end method
