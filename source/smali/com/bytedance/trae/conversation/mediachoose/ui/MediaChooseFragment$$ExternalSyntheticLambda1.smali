# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    check-cast v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->$r8$lambda$JGeoRI5E433g4nSIy5Dc6pKZvUY(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
