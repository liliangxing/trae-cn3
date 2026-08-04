# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
.super Ljava/lang/Object;
.source "AudioVisualizerView.kt"

.field private barHeight:F
.field private barType:I
.field private change:F
.field private curBarHeight:F
.field private groupType:I


.method public constructor <init>()void
    .registers 9
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 31
    const/4 v7, 0
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;-><init>(I I F F F I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(int  int  float  float  float)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barType I
    iput v2, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->groupType I
    iput v3, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barHeight F
    iput v4, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->curBarHeight F
    iput v5, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->change F
    return-void 
.end method

.method public synthetic constructor <init>(int  int  float  float  float  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    const/4 v0, 2
    if-eqz v10, +004h
    move v10, v0
    goto +2h
    move v10, v4
    and-int/lit8 v4, v9, 2
    if-eqz v4, +003h
    goto +2h
    move v0, v5
    and-int/lit8 v4, v9, 4
    const/4 v5, 0
    if-eqz v4, +004h
    move v1, v5
    goto +2h
    move v1, v6
    and-int/lit8 v4, v9, 8
    if-eqz v4, +004h
    move v2, v5
    goto +2h
    move v2, v7
    and-int/lit8 v4, v9, 16
    if-eqz v4, +004h
    move v9, v5
    goto +2h
    move v9, v8
    move-object v4, v3
    move v5, v10
    move v6, v0
    move v7, v1
    move v8, v2
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;-><init>(I I F F F)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.widget.AudioVisualizerView$BarParam  int  int  float  float  float  int  java.lang.Object)com.bytedance.trae.conversation.widget.AudioVisualizerView$BarParam
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget v4, v3, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barType I
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget v5, v3, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->groupType I
    move v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget v6, v3, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barHeight F
    move v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget v7, v3, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->curBarHeight F
    move v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget v8, v3, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->change F
    move v2, v8
    move-object v5, v3
    move v6, v4
    move v7, v10
    move v8, v0
    move v9, v1
    move v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->copy(I I F F F)Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
    move-result-object v3
    return-object v3
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barType I
    return v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->groupType I
    return v0
.end method

.method public final component3()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barHeight F
    return v0
.end method

.method public final component4()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->curBarHeight F
    return v0
.end method

.method public final component5()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->change F
    return v0
.end method

.method public final copy(int  int  float  float  float)com.bytedance.trae.conversation.widget.AudioVisualizerView$BarParam
    .registers 13
    # ins_size=6
    new-instance v6, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
    move-object v0, v6
    move v1, v8
    move v2, v9
    move v3, v10
    move v4, v11
    move v5, v12
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;-><init>(I I F F F)V
    return-object v6
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barType I
    iget v3, v5, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barType I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->groupType I
    iget v3, v5, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->groupType I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barHeight F
    iget v3, v5, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barHeight F
    invoke-static v1, v3, Ljava/lang/Float;->compare(F F)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->curBarHeight F
    iget v3, v5, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->curBarHeight F
    invoke-static v1, v3, Ljava/lang/Float;->compare(F F)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->change F
    iget v5, v5, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->change F
    invoke-static v1, v5, Ljava/lang/Float;->compare(F F)I
    move-result v5
    if-eqz v5, +003h
    return v2
    return v0
.end method

.method public final getBarHeight()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barHeight F
    return v0
.end method

.method public final getBarType()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barType I
    return v0
.end method

.method public final getChange()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->change F
    return v0
.end method

.method public final getCurBarHeight()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->curBarHeight F
    return v0
.end method

.method public final getGroupType()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->groupType I
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barType I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->groupType I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barHeight F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->curBarHeight F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->change F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final setBarHeight(float)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barHeight F
    return-void 
.end method

.method public final setBarType(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barType I
    return-void 
.end method

.method public final setChange(float)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->change F
    return-void 
.end method

.method public final setCurBarHeight(float)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->curBarHeight F
    return-void 
.end method

.method public final setGroupType(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->groupType I
    return-void 
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "BarParam(barType="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barType I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", groupType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->groupType I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", barHeight="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->barHeight F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", curBarHeight="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->curBarHeight F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", change="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;->change F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
