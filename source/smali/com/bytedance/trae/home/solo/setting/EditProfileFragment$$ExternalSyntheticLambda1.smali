# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Landroid/widget/TextView;
.field public final synthetic f$1:Lcom/facebook/drawee/view/SimpleDraweeView;
.field public final synthetic f$2:Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;
.field public final synthetic f$3:Landroid/widget/TextView;
.field public final synthetic f$4:Landroid/view/View;
.field public final synthetic f$5:Landroid/view/View;


.method public synthetic constructor <init>(android.widget.TextView  com.facebook.drawee.view.SimpleDraweeView  com.bytedance.trae.home.solo.setting.EditProfileFragment  android.widget.TextView  android.view.View  android.view.View)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;->f$0 Landroid/widget/TextView;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;->f$1 Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;->f$3 Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;->f$4 Landroid/view/View;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;->f$5 Landroid/view/View;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;->f$0 Landroid/widget/TextView;
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;->f$1 Lcom/facebook/drawee/view/SimpleDraweeView;
    iget-object v2, v7, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;
    iget-object v3, v7, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;->f$3 Landroid/widget/TextView;
    iget-object v4, v7, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;->f$4 Landroid/view/View;
    iget-object v5, v7, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$$ExternalSyntheticLambda1;->f$5 Landroid/view/View;
    move-object v6, v8
    check-cast v6, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->$r8$lambda$BzWsWCqu2bU8jUP2sul1DvRpG3Q(Landroid/widget/TextView; Lcom/facebook/drawee/view/SimpleDraweeView; Lcom/bytedance/trae/home/solo/setting/EditProfileFragment; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lcom/bytedance/trae/home/solo/setting/UserProfileState;)Lkotlin/Unit;
    move-result-object v8
    return-object v8
.end method
