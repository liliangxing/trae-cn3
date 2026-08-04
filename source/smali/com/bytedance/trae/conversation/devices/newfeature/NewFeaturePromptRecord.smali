# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;
.super Ljava/lang/Object;
.source "NewFeaturePromptPolicy.kt"

.field private final productType:Lcom/bytedance/trae/conversation/devices/DeviceProductType;
.field private final version:I


.method public constructor <init>(com.bytedance.trae.conversation.devices.DeviceProductType  int)void
    .registers 4
    # ins_size=3
    const-string v0, "productType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iput v3, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->version I
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptRecord  com.bytedance.trae.conversation.devices.DeviceProductType  int  int  java.lang.Object)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptRecord
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget v2, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->version I
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->copy(Lcom/bytedance/trae/conversation/devices/DeviceProductType; I)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->version I
    return v0
.end method

.method public final copy(com.bytedance.trae.conversation.devices.DeviceProductType  int)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptRecord
    .registers 4
    # ins_size=3
    const-string v0, "productType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->version I
    iget v5, v5, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->version I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getProductType()com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
.end method

.method public final getVersion()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->version I
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->version I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "NewFeaturePromptRecord(productType="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", version="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->version I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
