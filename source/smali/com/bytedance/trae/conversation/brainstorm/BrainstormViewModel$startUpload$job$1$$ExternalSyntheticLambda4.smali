# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Ljava/lang/Throwable;


.method public synthetic constructor <init>(java.lang.Throwable)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda4;->f$0 Ljava/lang/Throwable;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda4;->f$0 Ljava/lang/Throwable;
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$r8$lambda$i9qh-yF9pLo_LrLIeE5OQ6-gvFs(Ljava/lang/Throwable; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v2
    return-object v2
.end method
