# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;
.field public final synthetic f$2:Landroidx/appcompat/widget/SwitchCompat;
.field public final synthetic f$3:Landroid/view/View;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment  com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesTypeItem  androidx.appcompat.widget.SwitchCompat  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1$$ExternalSyntheticLambda0;->f$2 Landroidx/appcompat/widget/SwitchCompat;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1$$ExternalSyntheticLambda0;->f$3 Landroid/view/View;
    return-void 
.end method

.method public final onCheckedChanged(android.widget.CompoundButton  boolean)void
    .registers 9
    # ins_size=3
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;
    iget-object v2, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1$$ExternalSyntheticLambda0;->f$2 Landroidx/appcompat/widget/SwitchCompat;
    iget-object v3, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1$$ExternalSyntheticLambda0;->f$3 Landroid/view/View;
    move-object v4, v7
    move v5, v8
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$r8$lambda$qL67jIjC3RhPNNGX_paIVyr3NZI(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem; Landroidx/appcompat/widget/SwitchCompat; Landroid/view/View; Landroid/widget/CompoundButton; Z)V
    return-void 
.end method
