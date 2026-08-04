# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda12;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/design/compose/TraeDimens;
.field public final synthetic f$1:F
.field public final synthetic f$2:J
.field public final synthetic f$3:J


.method public synthetic constructor <init>(com.bytedance.trae.design.compose.TraeDimens  float  long  long)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda12;->f$0 Lcom/bytedance/trae/design/compose/TraeDimens;
    iput v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda12;->f$1 F
    iput-wide v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda12;->f$2 J
    iput-wide v5, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda12;->f$3 J
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda12;->f$0 Lcom/bytedance/trae/design/compose/TraeDimens;
    iget v1, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda12;->f$1 F
    iget-wide v2, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda12;->f$2 J
    iget-wide v4, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda12;->f$3 J
    move-object v6, v8
    check-cast v6, Landroidx/compose/ui/graphics/drawscope/DrawScope;
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->$r8$lambda$jh_5tKPAvamZIDeipWUWM1WqUZg(Lcom/bytedance/trae/design/compose/TraeDimens; F J J Landroidx/compose/ui/graphics/drawscope/DrawScope;)Lkotlin/Unit;
    move-result-object v8
    return-object v8
.end method
