# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SiteMessageSettingsFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $card:Landroid/view/View;
.field final synthetic $item:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;
.field final synthetic $newValue:Z
.field final synthetic $previousPreferences:Ljava/util/Map;
.field final synthetic $toggle:Landroidx/appcompat/widget/SwitchCompat;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;


.method public static synthetic $r8$lambda$qL67jIjC3RhPNNGX_paIVyr3NZI(com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment  com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesTypeItem  androidx.appcompat.widget.SwitchCompat  android.view.View  android.widget.CompoundButton  boolean)void
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->invokeSuspend$lambda$0(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem; Landroidx/appcompat/widget/SwitchCompat; Landroid/view/View; Landroid/widget/CompoundButton; Z)V
    return-void 
.end method

.method constructor <init>(com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesTypeItem  boolean  com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment  java.util.Map  androidx.appcompat.widget.SwitchCompat  android.view.View  kotlin.coroutines.Continuation)void
    .registers 8
    # ins_size=8
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$item Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;
    iput-boolean v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$newValue Z
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$previousPreferences Ljava/util/Map;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$toggle Landroidx/appcompat/widget/SwitchCompat;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$card Landroid/view/View;
    const/4 v1, 2
    invoke-direct v0, v1, v7, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment  com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesTypeItem  androidx.appcompat.widget.SwitchCompat  android.view.View  android.widget.CompoundButton  boolean)void
    .registers 6
    # ins_size=6
    invoke-static v0, v1, v5, v2, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->access$onSwitchToggled(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem; Z Landroidx/appcompat/widget/SwitchCompat; Landroid/view/View;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 11
    # ins_size=3
    new-instance v9, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;
    iget-object v1, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$item Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;
    iget-boolean v2, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$newValue Z
    iget-object v3, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    iget-object v4, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$previousPreferences Ljava/util/Map;
    iget-object v5, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$toggle Landroidx/appcompat/widget/SwitchCompat;
    iget-object v6, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$card Landroid/view/View;
    move-object v0, v9
    move-object v7, v10
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem; Z Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Ljava/util/Map; Landroidx/appcompat/widget/SwitchCompat; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/coroutines/Continuation;
    return-object v9
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->label I
    const/4 v2, 1
    if-eqz v1, +016h
    if-ne v1, v2, +00ch
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +34h
    move-exception v7
    goto/16 +09dh
    move-exception v7
    goto/16 +099h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$item Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;->getKey()Ljava/lang/String;
    move-result-object v1
    iget-boolean v3, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$newValue Z
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v1
    move-object v3, v6
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->label I
    invoke-virtual v7, v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->updatePreferences(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    check-cast v7, Ljava/util/Map;
    if-eqz v7, +00ch
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    invoke-static v0, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->access$setPreferences$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Ljava/util/Map;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v0, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->save(Ljava/util/Map;)V
    sget-object v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$item Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;->getKey()Ljava/lang/String;
    move-result-object v0
    iget-boolean v1, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$newValue Z
    invoke-virtual v7, v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->trackSettingsToggle(Ljava/lang/String; Z)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$toggle Landroidx/appcompat/widget/SwitchCompat;
    invoke-virtual v7, v2, Landroidx/appcompat/widget/SwitchCompat;->setEnabled(Z)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$card Landroid/view/View;
    invoke-virtual v7, v2, Landroid/view/View;->setClickable(Z)V
    goto +42h
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$previousPreferences Ljava/util/Map;
    invoke-static v7, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->access$setPreferences$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Ljava/util/Map;)V
    sget-object v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$previousPreferences Ljava/util/Map;
    invoke-virtual v7, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->save(Ljava/util/Map;)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$toggle Landroidx/appcompat/widget/SwitchCompat;
    const/4 v0, 0
    invoke-virtual v7, v0, Landroidx/appcompat/widget/SwitchCompat;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$toggle Landroidx/appcompat/widget/SwitchCompat;
    iget-boolean v0, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$newValue Z
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v2
    goto +2h
    move v0, v1
    invoke-virtual v7, v0, Landroidx/appcompat/widget/SwitchCompat;->setChecked(Z)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$toggle Landroidx/appcompat/widget/SwitchCompat;
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    iget-object v3, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$item Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;
    iget-object v4, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$card Landroid/view/View;
    new-instance v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1$$ExternalSyntheticLambda0;
    invoke-direct v5, v0, v3, v7, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem; Landroidx/appcompat/widget/SwitchCompat; Landroid/view/View;)V
    invoke-virtual v7, v5, Landroidx/appcompat/widget/SwitchCompat;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v7
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_site_message_settings_update_failed I
    invoke-static v7, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v7
    invoke-virtual v7, Landroid/widget/Toast;->show()V
    goto -4bh
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    throw v7
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$toggle Landroidx/appcompat/widget/SwitchCompat;
    invoke-virtual v0, v2, Landroidx/appcompat/widget/SwitchCompat;->setEnabled(Z)V
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$onSwitchToggled$1;->$card Landroid/view/View;
    invoke-virtual v0, v2, Landroid/view/View;->setClickable(Z)V
    throw v7
    :try_start_0xb
    :try_start_0x20
    :try_start_0x68
    :try_start_0xac
.end method
