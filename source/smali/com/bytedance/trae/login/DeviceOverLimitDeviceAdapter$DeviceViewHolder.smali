# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "DeviceOverLimitDeviceAdapter.kt"

.field private final binding:Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;
.field final synthetic this$0:Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;


.method public static synthetic $r8$lambda$C3Uzsz-Y6-thSMIhjPikNbqndhk(com.bytedance.trae.login.DeviceOverLimitDeviceAdapter  com.bytedance.trae.login.traeauth.DeviceSummary  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->bind$lambda$3(Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter; Lcom/bytedance/trae/login/traeauth/DeviceSummary; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.login.DeviceOverLimitDeviceAdapter  com.bytedance.trae.login.databinding.TraeItemDeviceOverLimitBinding)void
    .registers 4
    # ins_size=3
    const-string v0, "binding"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->this$0 Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    invoke-virtual v3, Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v2
    check-cast v2, Landroid/view/View;
    invoke-direct v1, v2, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v3, v1, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->binding Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;
    return-void 
.end method

.method private static final bind$lambda$3(com.bytedance.trae.login.DeviceOverLimitDeviceAdapter  com.bytedance.trae.login.traeauth.DeviceSummary  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->access$getOnLogoutClick$p(Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;)Lkotlin/jvm/functions/Function1;
    move-result-object v0
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final bind(com.bytedance.trae.login.traeauth.DeviceSummary  boolean)void
    .registers 13
    # ins_size=3
    const-string v12, "device"
    invoke-static v11, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v12, v10, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->binding Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;
    invoke-virtual v12, Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v12
    invoke-virtual v12, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v12
    invoke-virtual v11, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getBoundProducts()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +017h
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    const-string v0, ","
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 62
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    const-string v1, ""
    if-nez v0, +003h
    move-object v0, v1
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    const-string v3, "getString(...)"
    if-eqz v2, +00bh
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit_unknown_os I
    invoke-virtual v12, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/String;
    iget-object v2, v10, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->binding Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;
    iget-object v2, v2, Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;->tvDeviceName Landroid/widget/TextView;
    invoke-virtual v11, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getDeviceName()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +003h
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +00bh
    invoke-virtual v11, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getDeviceModel()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +003h
    goto +2h
    move-object v1, v4
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +00bh
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit_unknown_device I
    invoke-virtual v12, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v2, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v1, v10, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->binding Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;
    iget-object v1, v1, Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;->tvOsVersion Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit_app I
    const/4 v3, 1
    new-array v4, v3, [Ljava/lang/Object;
    const/4 v5, 0
    aput-object v0, v4, v5
    invoke-virtual v12, v2, v4, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v10, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->binding Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;->tvLoginTime Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit_login_time I
    new-array v2, v3, [Ljava/lang/Object;
    iget-object v4, v10, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->this$0 Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    invoke-virtual v11, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getLastActiveAt()Ljava/lang/Long;
    move-result-object v6
    invoke-static v4, v6, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->access$formatTime(Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter; Ljava/lang/Long;)Ljava/lang/String;
    move-result-object v4
    aput-object v4, v2, v5
    invoke-virtual v12, v1, v2, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v12
    check-cast v12, Ljava/lang/CharSequence;
    invoke-virtual v0, v12, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v12, v10, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->binding Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;
    iget-object v12, v12, Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;->ivDeviceIcon Landroid/widget/ImageView;
    iget-object v0, v10, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->this$0 Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    invoke-static v0, v11, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->access$resolveDeviceIcon(Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter; Lcom/bytedance/trae/login/traeauth/DeviceSummary;)I
    move-result v0
    invoke-virtual v12, v0, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v12, v10, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->binding Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;
    iget-object v12, v12, Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;->btnLogoutDevice Landroid/widget/TextView;
    invoke-virtual v11, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getCurrentDevice()Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v5, 4
    invoke-virtual v12, v5, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v12, v10, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->binding Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;
    iget-object v12, v12, Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;->btnLogoutDevice Landroid/widget/TextView;
    iget-object v0, v10, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->this$0 Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    new-instance v1, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, v11, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter; Lcom/bytedance/trae/login/traeauth/DeviceSummary;)V
    invoke-virtual v12, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
