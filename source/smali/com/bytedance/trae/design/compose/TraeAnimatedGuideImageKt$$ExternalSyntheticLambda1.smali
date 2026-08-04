# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lorg/jetbrains/compose/resources/DrawableResource;
.field public final synthetic f$1:Landroidx/compose/ui/Modifier;
.field public final synthetic f$2:F
.field public final synthetic f$3:I
.field public final synthetic f$4:I


.method public synthetic constructor <init>(org.jetbrains.compose.resources.DrawableResource  androidx.compose.ui.Modifier  float  int  int)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda1;->f$0 Lorg/jetbrains/compose/resources/DrawableResource;
    iput-object v2, v0, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda1;->f$1 Landroidx/compose/ui/Modifier;
    iput v3, v0, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda1;->f$2 F
    iput v4, v0, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda1;->f$3 I
    iput v5, v0, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda1;->f$4 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=3
    iget-object v0, v7, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda1;->f$0 Lorg/jetbrains/compose/resources/DrawableResource;
    iget-object v1, v7, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda1;->f$1 Landroidx/compose/ui/Modifier;
    iget v2, v7, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda1;->f$2 F
    iget v3, v7, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda1;->f$3 I
    iget v4, v7, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda1;->f$4 I
    move-object v5, v8
    check-cast v5, Landroidx/compose/runtime/Composer;
    check-cast v9, Ljava/lang/Integer;
    invoke-virtual v9, Ljava/lang/Integer;->intValue()I
    move-result v6
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt;->$r8$lambda$Z69jTO896fhfPDEyECRs5Z3ioro(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/Modifier; F I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v8
    return-object v8
.end method
