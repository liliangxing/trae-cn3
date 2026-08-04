# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$onViewCreated$9$1;
.super Ljava/lang/Object;
.source "SettingsMainFragment.kt"

.implements Lkotlinx/coroutines/flow/FlowCollector;

.field final synthetic $tvMessageBadge:Landroid/widget/TextView;


.method constructor <init>(android.widget.TextView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$onViewCreated$9$1;->$tvMessageBadge Landroid/widget/TextView;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final emit(int  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=3
    if-lez v2, +01bh
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$onViewCreated$9$1;->$tvMessageBadge Landroid/widget/TextView;
    const/16 v0, 99
    if-le v2, v0, +005h
    const-string v2, "99+"
    goto +5h
    invoke-static v2, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v3, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$onViewCreated$9$1;->$tvMessageBadge Landroid/widget/TextView;
    const/4 v3, 0
    invoke-virtual v2, v3, Landroid/widget/TextView;->setVisibility(I)V
    goto +8h
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$onViewCreated$9$1;->$tvMessageBadge Landroid/widget/TextView;
    const/16 v3, 8
    invoke-virtual v2, v3, Landroid/widget/TextView;->setVisibility(I)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method public bridge synthetic emit(java.lang.Object  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$onViewCreated$9$1;->emit(I Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method
