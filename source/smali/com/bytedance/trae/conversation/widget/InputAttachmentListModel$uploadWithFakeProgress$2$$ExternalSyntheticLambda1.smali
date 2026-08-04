# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lkotlin/jvm/internal/Ref$IntRef;
.field public final synthetic f$1:Lkotlin/jvm/internal/Ref$IntRef;
.field public final synthetic f$2:Lkotlin/jvm/internal/Ref$IntRef;
.field public final synthetic f$3:Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
.field public final synthetic f$4:Landroid/net/Uri;


.method public synthetic constructor <init>(kotlin.jvm.internal.Ref$IntRef  kotlin.jvm.internal.Ref$IntRef  kotlin.jvm.internal.Ref$IntRef  com.bytedance.trae.conversation.widget.InputAttachmentListModel  android.net.Uri)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda1;->f$0 Lkotlin/jvm/internal/Ref$IntRef;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda1;->f$1 Lkotlin/jvm/internal/Ref$IntRef;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda1;->f$2 Lkotlin/jvm/internal/Ref$IntRef;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda1;->f$3 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda1;->f$4 Landroid/net/Uri;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda1;->f$0 Lkotlin/jvm/internal/Ref$IntRef;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda1;->f$1 Lkotlin/jvm/internal/Ref$IntRef;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda1;->f$2 Lkotlin/jvm/internal/Ref$IntRef;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda1;->f$3 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda1;->f$4 Landroid/net/Uri;
    check-cast v7, Ljava/lang/Integer;
    invoke-virtual v7, Ljava/lang/Integer;->intValue()I
    move-result v5
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->$r8$lambda$Mk6JgJRvG8ZQNkDqaDNn63N5ZPs(Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; I)Lkotlin/Unit;
    move-result-object v7
    return-object v7
.end method
