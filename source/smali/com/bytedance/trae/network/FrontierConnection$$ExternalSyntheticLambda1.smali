# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/network/FrontierConnection$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/common/wschannel/MsgSendListener;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/FrontierConnection$$ExternalSyntheticLambda1;->f$0 Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final onSendResult(com.bytedance.common.wschannel.model.WsChannelMsg  boolean)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/network/FrontierConnection$$ExternalSyntheticLambda1;->f$0 Lkotlin/jvm/functions/Function1;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/network/FrontierConnection;->$r8$lambda$dkIKqWGDKbx_I4YtbGvNjErePmE(Lkotlin/jvm/functions/Function1; Lcom/bytedance/common/wschannel/model/WsChannelMsg; Z)V
    return-void 
.end method
