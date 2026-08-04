# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;
.super Ljava/lang/Object;
.source "PureShowWidgetInlineView.kt"

.field private final heightCss:F
.field private final viewportWidthCss:F


.method public constructor <init>(float  float)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->heightCss F
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->viewportWidthCss F
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.renderer.HeightMeasurement  float  float  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.renderer.HeightMeasurement
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->heightCss F
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->viewportWidthCss F
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->copy(F F)Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;
    move-result-object v0
    return-object v0
.end method

.method public final component1()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->heightCss F
    return v0
.end method

.method public final component2()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->viewportWidthCss F
    return v0
.end method

.method public final copy(float  float)com.bytedance.trae.conversation.chat.block.renderer.HeightMeasurement
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;-><init>(F F)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->heightCss F
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->heightCss F
    invoke-static v1, v3, Ljava/lang/Float;->compare(F F)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->viewportWidthCss F
    iget v5, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->viewportWidthCss F
    invoke-static v1, v5, Ljava/lang/Float;->compare(F F)I
    move-result v5
    if-eqz v5, +003h
    return v2
    return v0
.end method

.method public final getHeightCss()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->heightCss F
    return v0
.end method

.method public final getViewportWidthCss()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->viewportWidthCss F
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->heightCss F
    invoke-static v0, Ljava/lang/Float;->hashCode(F)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->viewportWidthCss F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "HeightMeasurement(heightCss="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->heightCss F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", viewportWidthCss="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->viewportWidthCss F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
