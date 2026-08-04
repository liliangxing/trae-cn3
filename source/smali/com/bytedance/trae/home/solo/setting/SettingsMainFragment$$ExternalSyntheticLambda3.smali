# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;
.field public final synthetic f$2:Landroid/widget/TextView;
.field public final synthetic f$3:Landroid/widget/TextView;
.field public final synthetic f$4:Landroid/widget/ImageView;


.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.home.solo.setting.SettingsMainFragment  android.widget.TextView  android.widget.TextView  android.widget.ImageView)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda3;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda3;->f$1 Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda3;->f$2 Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda3;->f$3 Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda3;->f$4 Landroid/widget/ImageView;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda3;->f$0 Ljava/lang/String;
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda3;->f$1 Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;
    iget-object v2, v6, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda3;->f$2 Landroid/widget/TextView;
    iget-object v3, v6, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda3;->f$3 Landroid/widget/TextView;
    iget-object v4, v6, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda3;->f$4 Landroid/widget/ImageView;
    move-object v5, v7
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;->$r8$lambda$vaKtwbIhTjKAciR84YwZY3C-iHM(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/ImageView; Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;)Lkotlin/Unit;
    move-result-object v7
    return-object v7
.end method
