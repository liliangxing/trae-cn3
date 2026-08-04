# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;
.super Ljava/lang/Object;
.source "ConnectComputerGuideContentPolicy.kt"

.field private final heroRes:I
.field private final step1Res:I
.field private final step2Res:I


.method public constructor <init>(int  int  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->heroRes I
    iput v2, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step1Res I
    iput v3, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step2Res I
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.ConnectComputerGuideContent  int  int  int  int  java.lang.Object)com.bytedance.trae.conversation.devices.ConnectComputerGuideContent
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget v1, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->heroRes I
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget v2, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step1Res I
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget v3, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step2Res I
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->copy(I I I)Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->heroRes I
    return v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step1Res I
    return v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step2Res I
    return v0
.end method

.method public final copy(int  int  int)com.bytedance.trae.conversation.devices.ConnectComputerGuideContent
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;-><init>(I I I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;
    iget v1, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->heroRes I
    iget v3, v5, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->heroRes I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step1Res I
    iget v3, v5, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step1Res I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step2Res I
    iget v5, v5, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step2Res I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getHeroRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->heroRes I
    return v0
.end method

.method public final getStep1Res()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step1Res I
    return v0
.end method

.method public final getStep2Res()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step2Res I
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->heroRes I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step1Res I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step2Res I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ConnectComputerGuideContent(heroRes="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->heroRes I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", step1Res="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step1Res I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", step2Res="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->step2Res I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
