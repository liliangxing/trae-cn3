# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Landroidx/activity/ComponentActivity;
.field public final synthetic f$1:Landroid/app/Dialog;
.field public final synthetic f$2:Lkotlin/jvm/functions/Function0;


.method public synthetic constructor <init>(androidx.activity.ComponentActivity  android.app.Dialog  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$$ExternalSyntheticLambda0;->f$0 Landroidx/activity/ComponentActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$$ExternalSyntheticLambda0;->f$1 Landroid/app/Dialog;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$$ExternalSyntheticLambda0;->f$2 Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$$ExternalSyntheticLambda0;->f$0 Landroidx/activity/ComponentActivity;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$$ExternalSyntheticLambda0;->f$1 Landroid/app/Dialog;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$$ExternalSyntheticLambda0;->f$2 Lkotlin/jvm/functions/Function0;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;->$r8$lambda$koH2gPBuAgByM_-bSJDnZz4CnRA(Landroidx/activity/ComponentActivity; Landroid/app/Dialog; Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method
