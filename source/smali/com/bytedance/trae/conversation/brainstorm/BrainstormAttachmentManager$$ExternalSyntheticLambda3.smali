# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function3;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda3;->f$0 Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=4
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager$$ExternalSyntheticLambda3;->f$0 Lkotlin/jvm/functions/Function1;
    check-cast v7, Ljava/lang/Integer;
    invoke-virtual v7, Ljava/lang/Integer;->intValue()I
    move-result v1
    check-cast v8, Ljava/lang/Long;
    invoke-virtual v8, Ljava/lang/Long;->longValue()J
    move-result-wide v2
    check-cast v9, Ljava/lang/Long;
    invoke-virtual v9, Ljava/lang/Long;->longValue()J
    move-result-wide v4
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;->$r8$lambda$GyT9i6U4vr4TXTyyicTmBSokEXI(Lkotlin/jvm/functions/Function1; I J J)Lkotlin/Unit;
    move-result-object v7
    return-object v7
.end method
