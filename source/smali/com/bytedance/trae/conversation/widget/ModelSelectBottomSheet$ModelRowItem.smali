# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;
.super Ljava/lang/Object;
.source "ModelSelectBottomSheet.kt"

.field private final model:Lcom/bytedance/trae/conversation/network/RemoteModelItem;
.field private final pricing:Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;


.method public constructor <init>(com.bytedance.trae.conversation.network.RemoteModelItem  com.bytedance.trae.conversation.network.ModelPricingPresentation)void
    .registers 4
    # ins_size=3
    const-string v0, "model"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "pricing"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->model Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->pricing Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.network.RemoteModelItem  com.bytedance.trae.conversation.network.ModelPricingPresentation  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +009h
    new-instance v2, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    const/4 v3, 3
    const/4 v4, 0
    invoke-direct v2, v4, v4, v3, v4, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;-><init>(Ljava/math/BigDecimal; Lcom/bytedance/trae/conversation/network/ModelDiscountTag; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;-><init>(Lcom/bytedance/trae/conversation/network/RemoteModelItem; Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.widget.ModelSelectBottomSheet$ModelRowItem  com.bytedance.trae.conversation.network.RemoteModelItem  com.bytedance.trae.conversation.network.ModelPricingPresentation  int  java.lang.Object)com.bytedance.trae.conversation.widget.ModelSelectBottomSheet$ModelRowItem
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->model Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->pricing Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->copy(Lcom/bytedance/trae/conversation/network/RemoteModelItem; Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;)Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.network.RemoteModelItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->model Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.network.ModelPricingPresentation
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->pricing Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.network.RemoteModelItem  com.bytedance.trae.conversation.network.ModelPricingPresentation)com.bytedance.trae.conversation.widget.ModelSelectBottomSheet$ModelRowItem
    .registers 4
    # ins_size=3
    const-string v0, "model"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "pricing"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;-><init>(Lcom/bytedance/trae/conversation/network/RemoteModelItem; Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->model Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->model Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->pricing Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->pricing Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getModel()com.bytedance.trae.conversation.network.RemoteModelItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->model Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    return-object v0
.end method

.method public final getPricing()com.bytedance.trae.conversation.network.ModelPricingPresentation
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->pricing Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->model Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->pricing Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ModelRowItem(model="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->model Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", pricing="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->pricing Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
