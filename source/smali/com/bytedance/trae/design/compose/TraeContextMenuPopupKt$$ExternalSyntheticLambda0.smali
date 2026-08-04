# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Landroidx/compose/runtime/MutableState;


.method public synthetic constructor <init>(androidx.compose.runtime.MutableState)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda0;->f$0 Landroidx/compose/runtime/MutableState;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda0;->f$0 Landroidx/compose/runtime/MutableState;
    check-cast v2, Landroidx/compose/ui/layout/LayoutCoordinates;
    invoke-static v0, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->$r8$lambda$iW_sA3f_nA-IZz-hnYzf5suoXik(Landroidx/compose/runtime/MutableState; Landroidx/compose/ui/layout/LayoutCoordinates;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
