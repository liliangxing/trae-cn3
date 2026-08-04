# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:J


.method public synthetic constructor <init>(long)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda0;->f$0 J
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-wide v0, v2, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda0;->f$0 J
    check-cast v3, Landroidx/compose/ui/graphics/drawscope/DrawScope;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt;->$r8$lambda$F4AEyUovVmxOQG1wvxLxkN4X55w(J Landroidx/compose/ui/graphics/drawscope/DrawScope;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
