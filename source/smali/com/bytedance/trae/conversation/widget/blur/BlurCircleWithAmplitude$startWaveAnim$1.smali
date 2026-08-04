# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final synthetic Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude$startWaveAnim$1;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "BlurCircleWithAmplitude.kt"

.implements Lkotlin/jvm/functions/Function0;


.method constructor <init>(java.lang.Object)void
    .registers 9
    # ins_size=2
    const/4 v1, 0
    const-class v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    const-string v4, "getMaxAmplitude"
    const-string v5, "getMaxAmplitude()F"
    const/4 v6, 0
    move-object v0, v7
    move-object v2, v8
    invoke-direct/range v0 ... v6, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Object; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public final invoke()java.lang.Float
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude$startWaveAnim$1;->receiver Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->access$getMaxAmplitude(Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;)F
    move-result v0
    invoke-static v0, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v0
    return-object v0
.end method

.method public bridge synthetic invoke()java.lang.Object
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude$startWaveAnim$1;->invoke()Ljava/lang/Float;
    move-result-object v0
    return-object v0
.end method
