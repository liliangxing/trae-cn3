# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Z


.method public synthetic constructor <init>(java.lang.String  boolean)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda3;->f$0 Ljava/lang/String;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda3;->f$1 Z
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda3;->f$0 Ljava/lang/String;
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1$$ExternalSyntheticLambda3;->f$1 Z
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$startUpload$job$1;->$r8$lambda$t7ESWVTpINP28t3naiR_D2p-Mxc(Ljava/lang/String; Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v3
    return-object v3
.end method
