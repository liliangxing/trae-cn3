# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lkotlin/jvm/internal/Ref$IntRef;


.method public synthetic constructor <init>(kotlin.jvm.internal.Ref$IntRef)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/internal/Ref$IntRef;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/internal/Ref$IntRef;
    check-cast v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->$r8$lambda$m3swkqZLmd-sz9xraLj2ICruh-E(Lkotlin/jvm/internal/Ref$IntRef; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v2
    return-object v2
.end method
