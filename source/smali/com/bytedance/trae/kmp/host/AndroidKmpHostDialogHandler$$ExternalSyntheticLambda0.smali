# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/content/DialogInterface$OnDismissListener;

.field public final synthetic f$0:Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function0;


.method public synthetic constructor <init>(com.bytedance.trae.kmp.host.AndroidKmpHostDialogHandler  kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final onDismiss(android.content.DialogInterface)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;
    iget-object v1, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/functions/Function0;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->$r8$lambda$YW8a3QCQlBReMYmypEGEUceBYNg(Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler; Lkotlin/jvm/functions/Function0; Landroid/content/DialogInterface;)V
    return-void 
.end method
