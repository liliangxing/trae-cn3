# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/network/FrontierConnection$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
.field public final synthetic f$1:Lcom/bytedance/trae/network/FrontierConnection;


.method public synthetic constructor <init>(com.bytedance.common.wschannel.ChannelInfo$Builder  com.bytedance.trae.network.FrontierConnection)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/FrontierConnection$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    iput-object v2, v0, Lcom/bytedance/trae/network/FrontierConnection$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/network/FrontierConnection;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/network/FrontierConnection$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/common/wschannel/ChannelInfo$Builder;
    iget-object v1, v2, Lcom/bytedance/trae/network/FrontierConnection$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/network/FrontierConnection;
    invoke-static v0, v1, Lcom/bytedance/trae/network/FrontierConnection;->$r8$lambda$HeSXrJ-5MZMDUJB2XdevA9nmhJA(Lcom/bytedance/common/wschannel/ChannelInfo$Builder; Lcom/bytedance/trae/network/FrontierConnection;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
