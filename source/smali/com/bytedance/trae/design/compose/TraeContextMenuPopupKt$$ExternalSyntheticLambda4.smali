# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/design/compose/TraeContextMenuItem;
.field public final synthetic f$1:F
.field public final synthetic f$2:F
.field public final synthetic f$3:F
.field public final synthetic f$4:F
.field public final synthetic f$5:F
.field public final synthetic f$6:F
.field public final synthetic f$7:J
.field public final synthetic f$8:I


.method public synthetic constructor <init>(com.bytedance.trae.design.compose.TraeContextMenuItem  float  float  float  float  float  float  long  int)void
    .registers 11
    # ins_size=11
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/design/compose/TraeContextMenuItem;
    iput v2, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$1 F
    iput v3, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$2 F
    iput v4, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$3 F
    iput v5, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$4 F
    iput v6, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$5 F
    iput v7, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$6 F
    iput-wide v8, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$7 J
    iput v10, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$8 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=3
    iget-object v0, v12, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/design/compose/TraeContextMenuItem;
    iget v1, v12, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$1 F
    iget v2, v12, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$2 F
    iget v3, v12, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$3 F
    iget v4, v12, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$4 F
    iget v5, v12, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$5 F
    iget v6, v12, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$6 F
    iget-wide v7, v12, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$7 J
    iget v9, v12, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;->f$8 I
    move-object v10, v13
    check-cast v10, Landroidx/compose/runtime/Composer;
    check-cast v14, Ljava/lang/Integer;
    invoke-virtual v14, Ljava/lang/Integer;->intValue()I
    move-result v11
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->$r8$lambda$p_IxrqEhCzodFA2QMyxbRwVA704(Lcom/bytedance/trae/design/compose/TraeContextMenuItem; F F F F F F J I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v13
    return-object v13
.end method
