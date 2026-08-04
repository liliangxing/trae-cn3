# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/functions/Function1;
    check-cast v2, Ljava/lang/Integer;
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$retryUpload$2$2;->$r8$lambda$MGughME2XICEyfLBn8JBQPfeXDI(Lkotlin/jvm/functions/Function1; I)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
