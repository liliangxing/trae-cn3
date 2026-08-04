# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Landroidx/compose/ui/Modifier;
.field public final synthetic f$1:J
.field public final synthetic f$2:I
.field public final synthetic f$3:I


.method public synthetic constructor <init>(androidx.compose.ui.Modifier  long  int  int)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda1;->f$0 Landroidx/compose/ui/Modifier;
    iput-wide v2, v0, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda1;->f$1 J
    iput v4, v0, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda1;->f$2 I
    iput v5, v0, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda1;->f$3 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=3
    iget-object v0, v7, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda1;->f$0 Landroidx/compose/ui/Modifier;
    iget-wide v1, v7, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda1;->f$1 J
    iget v3, v7, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda1;->f$2 I
    iget v4, v7, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda1;->f$3 I
    move-object v5, v8
    check-cast v5, Landroidx/compose/runtime/Composer;
    check-cast v9, Ljava/lang/Integer;
    invoke-virtual v9, Ljava/lang/Integer;->intValue()I
    move-result v6
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt;->$r8$lambda$xWswRpXUUlf9pV2pZ0LbhG1wR84(Landroidx/compose/ui/Modifier; J I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v8
    return-object v8
.end method
