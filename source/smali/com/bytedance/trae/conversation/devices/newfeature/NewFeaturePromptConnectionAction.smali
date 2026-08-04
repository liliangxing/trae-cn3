# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;
.super Ljava/lang/Object;
.source "NewFeaturePromptConnectionPolicy.kt"

.field private final destinationMode:Lcom/bytedance/trae/conversation/widget/ChatMode;
.field private final openDeviceSelection:Z
.field private final selectedCliType:Lcom/bytedance/trae/im/service/CliType;


.method public constructor <init>(com.bytedance.trae.conversation.widget.ChatMode  com.bytedance.trae.im.service.CliType  boolean)void
    .registers 5
    # ins_size=4
    const-string v0, "destinationMode"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, selectedCliType
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->destinationMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->selectedCliType Lcom/bytedance/trae/im/service/CliType;
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->openDeviceSelection Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConnectionAction  com.bytedance.trae.conversation.widget.ChatMode  com.bytedance.trae.im.service.CliType  boolean  int  java.lang.Object)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConnectionAction
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->destinationMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->selectedCliType Lcom/bytedance/trae/im/service/CliType;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->openDeviceSelection Z
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->copy(Lcom/bytedance/trae/conversation/widget/ChatMode; Lcom/bytedance/trae/im/service/CliType; Z)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.widget.ChatMode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->destinationMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.im.service.CliType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->selectedCliType Lcom/bytedance/trae/im/service/CliType;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->openDeviceSelection Z
    return v0
.end method

.method public final copy(com.bytedance.trae.conversation.widget.ChatMode  com.bytedance.trae.im.service.CliType  boolean)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConnectionAction
    .registers 5
    # ins_size=4
    const-string v0, "destinationMode"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, selectedCliType
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;-><init>(Lcom/bytedance/trae/conversation/widget/ChatMode; Lcom/bytedance/trae/im/service/CliType; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->destinationMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->destinationMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->selectedCliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->selectedCliType Lcom/bytedance/trae/im/service/CliType;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->openDeviceSelection Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->openDeviceSelection Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getDestinationMode()com.bytedance.trae.conversation.widget.ChatMode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->destinationMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-object v0
.end method

.method public final getOpenDeviceSelection()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->openDeviceSelection Z
    return v0
.end method

.method public final getSelectedCliType()com.bytedance.trae.im.service.CliType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->selectedCliType Lcom/bytedance/trae/im/service/CliType;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->destinationMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->selectedCliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->openDeviceSelection Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "NewFeaturePromptConnectionAction(destinationMode="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->destinationMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", selectedCliType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->selectedCliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", openDeviceSelection="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->openDeviceSelection Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
