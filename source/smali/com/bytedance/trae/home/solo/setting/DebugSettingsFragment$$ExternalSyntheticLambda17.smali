# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda17;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
.field public final synthetic f$1:Landroid/content/Context;
.field public final synthetic f$2:Landroid/widget/TextView;


.method public synthetic constructor <init>(com.bytedance.trae.settings.api.feature.IFeatureCapabilityService  android.content.Context  android.widget.TextView)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda17;->f$0 Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda17;->f$1 Landroid/content/Context;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda17;->f$2 Landroid/widget/TextView;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda17;->f$0 Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda17;->f$1 Landroid/content/Context;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda17;->f$2 Landroid/widget/TextView;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->$r8$lambda$HmhhSUx37RTx6O1zR4bmNQz_xMk(Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService; Landroid/content/Context; Landroid/widget/TextView; Landroid/view/View;)V
    return-void 
.end method
