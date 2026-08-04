# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Ljava/lang/String;
.field public final synthetic f$4:Ljava/lang/String;
.field public final synthetic f$5:Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;->f$2 Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;->f$3 Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;->f$4 Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;->f$5 Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;->f$0 Ljava/lang/String;
    iget-object v1, v7, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;->f$1 Ljava/lang/String;
    iget-object v2, v7, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;->f$2 Ljava/lang/String;
    iget-object v3, v7, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;->f$3 Ljava/lang/String;
    iget-object v4, v7, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;->f$4 Ljava/lang/String;
    iget-object v5, v7, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;->f$5 Lkotlin/jvm/functions/Function1;
    move-object v6, v8
    check-cast v6, Landroid/app/Activity;
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->$r8$lambda$Ce5amtT-DKeikCqov11i72TkXbQ(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Landroid/app/Activity;)Landroid/app/Dialog;
    move-result-object v8
    return-object v8
.end method
