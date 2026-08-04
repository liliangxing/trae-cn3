# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Landroid/widget/TextView;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;


.method public synthetic constructor <init>(android.widget.TextView  com.bytedance.trae.home.solo.setting.EditAvatarFragment)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$$ExternalSyntheticLambda2;->f$0 Landroid/widget/TextView;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$$ExternalSyntheticLambda2;->f$0 Landroid/widget/TextView;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;
    check-cast v3, Ljava/lang/Boolean;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->$r8$lambda$CyfoRNOH-9amXcz95iRNbuBQuQo(Landroid/widget/TextView; Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment; Z)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
