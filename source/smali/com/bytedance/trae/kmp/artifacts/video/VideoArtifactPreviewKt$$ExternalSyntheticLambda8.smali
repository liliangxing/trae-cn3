# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda8;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Landroidx/compose/ui/unit/Density;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$2:Lcom/bytedance/trae/design/compose/TraeDimens;


.method public synthetic constructor <init>(androidx.compose.ui.unit.Density  kotlin.jvm.functions.Function1  com.bytedance.trae.design.compose.TraeDimens)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda8;->f$0 Landroidx/compose/ui/unit/Density;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda8;->f$1 Lkotlin/jvm/functions/Function1;
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda8;->f$2 Lcom/bytedance/trae/design/compose/TraeDimens;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda8;->f$0 Landroidx/compose/ui/unit/Density;
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda8;->f$1 Lkotlin/jvm/functions/Function1;
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda8;->f$2 Lcom/bytedance/trae/design/compose/TraeDimens;
    check-cast v4, Landroidx/compose/ui/layout/LayoutCoordinates;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->$r8$lambda$fVzGa4CjdvsbzRNc4n7qZB2taCU(Landroidx/compose/ui/unit/Density; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/design/compose/TraeDimens; Landroidx/compose/ui/layout/LayoutCoordinates;)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
