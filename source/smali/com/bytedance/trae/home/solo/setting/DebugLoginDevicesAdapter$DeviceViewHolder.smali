# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "DebugLoginDevicesAdapter.kt"

.field public static final $stable:I
.field private final formatter:Ljava/text/SimpleDateFormat;
.field private final ivIcon:Landroid/widget/ImageView;
.field private final tvCurrent:Landroid/widget/TextView;
.field private final tvFirstBound:Landroid/widget/TextView;
.field private final tvLastActive:Landroid/widget/TextView;
.field private final tvMeta:Landroid/widget/TextView;
.field private final tvName:Landroid/widget/TextView;
.field private final tvProducts:Landroid/widget/TextView;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(android.view.View)void
    .registers 4
    # ins_size=2
    const-string v0, "itemView"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->iv_device_icon I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->ivIcon Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_device_name I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->tvName Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_current_device I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->tvCurrent Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_device_meta I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->tvMeta Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_bound_products I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->tvProducts Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_first_bound I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->tvFirstBound Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_last_active I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/TextView;
    iput-object v3, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->tvLastActive Landroid/widget/TextView;
    new-instance v3, Ljava/text/SimpleDateFormat;
    const-string/jumbo v0, yyyy-MM-dd HH:mm
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v1
    invoke-direct v3, v0, v1, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    iput-object v3, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->formatter Ljava/text/SimpleDateFormat;
    return-void 
.end method

.method private final formatTime(long)java.lang.String
    .registers 5
    # ins_size=3
    const-wide v0, 10000000000
    cmp-long v0, v3, v0
    if-gez v0, +006h
    const/16 v0, 1000
    int-to-long v0, v0
    mul-long/2addr v3, v0
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->formatter Ljava/text/SimpleDateFormat;
    new-instance v1, Ljava/util/Date;
    invoke-direct v1, v3, v4, Ljava/util/Date;-><init>(J)V
    invoke-virtual v0, v1, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v3
    const-string v4, "format(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method private final setOptionalText(android.widget.TextView  java.lang.String)void
    .registers 4
    # ins_size=3
    if-nez v3, +005h
    const-string v0, ""
    goto +2h
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v2, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v0, 0
    if-eqz v3, +00bh
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    move v3, v0
    goto +2h
    const/4 v3, 1
    if-eqz v3, +004h
    const/16 v0, 8
    invoke-virtual v2, v0, Landroid/widget/TextView;->setVisibility(I)V
    return-void 
.end method

.method public final bind(com.bytedance.trae.login.api.LoginDeviceInfo)void
    .registers 16
    # ins_size=2
    const-string v0, "item"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->tvName Landroid/widget/TextView;
    invoke-virtual v15, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->getDeviceName()Ljava/lang/String;
    move-result-object v1
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +013h
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v2
    if-eqz v4, +003h
    goto +2h
    move-object v1, v3
    if-eqz v1, +005h
    check-cast v1, Ljava/lang/CharSequence;
    goto +14h
    iget-object v1, v14, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v4, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_login_devices_unknown I
    invoke-virtual v1, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    const-string v4, "getString(...)"
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->tvCurrent Landroid/widget/TextView;
    invoke-virtual v15, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->getCurrentDevice()Z
    move-result v1
    const/4 v4, 0
    if-eqz v1, +004h
    move v1, v4
    goto +3h
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->ivIcon Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/home/R$drawable;->ic_setting_computer_screen I
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    const/4 v0, 5
    new-array v0, v0, [Ljava/lang/String;
    invoke-virtual v15, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->getDeviceType()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00dh
    move-object v5, v1
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v2
    if-eqz v5, +003h
    goto +2h
    move-object v1, v3
    aput-object v1, v0, v4
    invoke-virtual v15, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->getPlatformCode()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00dh
    move-object v5, v1
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v2
    if-eqz v5, +003h
    goto +2h
    move-object v1, v3
    aput-object v1, v0, v2
    invoke-virtual v15, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->getDeviceModel()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00dh
    move-object v5, v1
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v2
    if-eqz v5, +003h
    goto +2h
    move-object v1, v3
    const/4 v5, 2
    aput-object v1, v0, v5
    invoke-virtual v15, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->getOsVersion()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00dh
    move-object v5, v1
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v2
    if-eqz v5, +003h
    goto +2h
    move-object v1, v3
    const/4 v5, 3
    aput-object v1, v0, v5
    invoke-virtual v15, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->getClientVersion()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +021h
    move-object v5, v1
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v2
    if-eqz v5, +003h
    goto +2h
    move-object v1, v3
    if-eqz v1, +013h
    iget-object v5, v14, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->itemView Landroid/view/View;
    invoke-virtual v5, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v5
    sget v6, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_login_devices_version I
    new-array v7, v2, [Ljava/lang/Object;
    aput-object v1, v7, v4
    invoke-virtual v5, v6, v7, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v3
    const/4 v5, 4
    aput-object v1, v0, v5
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOfNotNull([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    iget-object v1, v14, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->tvMeta Landroid/widget/TextView;
    move-object v5, v0
    check-cast v5, Ljava/lang/Iterable;
    const-string v0, " · "
    move-object v6, v0
    check-cast v6, Ljava/lang/CharSequence;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 62
    const/4 v13, 0
    invoke-static/range v5 ... v13, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    invoke-direct v14, v1, v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->setOptionalText(Landroid/widget/TextView; Ljava/lang/String;)V
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->tvProducts Landroid/widget/TextView;
    invoke-virtual v15, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->getBoundProducts()Ljava/util/List;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    xor-int/2addr v5, v2
    if-eqz v5, +003h
    goto +2h
    move-object v1, v3
    if-eqz v1, +029h
    move-object v5, v1
    check-cast v5, Ljava/lang/Iterable;
    const-string v1, ", "
    move-object v6, v1
    check-cast v6, Ljava/lang/CharSequence;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 62
    const/4 v13, 0
    invoke-static/range v5 ... v13, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +013h
    iget-object v5, v14, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->itemView Landroid/view/View;
    invoke-virtual v5, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v5
    sget v6, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_login_devices_products I
    new-array v7, v2, [Ljava/lang/Object;
    aput-object v1, v7, v4
    invoke-virtual v5, v6, v7, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v3
    invoke-direct v14, v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->setOptionalText(Landroid/widget/TextView; Ljava/lang/String;)V
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->tvFirstBound Landroid/widget/TextView;
    invoke-virtual v15, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->getFirstBoundAt()Ljava/lang/Long;
    move-result-object v1
    const-wide/16 v5, 0
    if-eqz v1, +031h
    move-object v7, v1
    check-cast v7, Ljava/lang/Number;
    invoke-virtual v7, Ljava/lang/Number;->longValue()J
    move-result-wide v7
    cmp-long v7, v7, v5
    if-lez v7, +004h
    move v7, v2
    goto +2h
    move v7, v4
    if-eqz v7, +003h
    goto +2h
    move-object v1, v3
    if-eqz v1, +01dh
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->longValue()J
    move-result-wide v7
    iget-object v1, v14, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v9, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_login_devices_first_bound I
    new-array v10, v2, [Ljava/lang/Object;
    invoke-direct v14, v7, v8, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->formatTime(J)Ljava/lang/String;
    move-result-object v7
    aput-object v7, v10, v4
    invoke-virtual v1, v9, v10, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v3
    invoke-direct v14, v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->setOptionalText(Landroid/widget/TextView; Ljava/lang/String;)V
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->tvLastActive Landroid/widget/TextView;
    invoke-virtual v15, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->getLastActiveAt()Ljava/lang/Long;
    move-result-object v15
    if-eqz v15, +030h
    move-object v1, v15
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->longValue()J
    move-result-wide v7
    cmp-long v1, v7, v5
    if-lez v1, +004h
    move v1, v2
    goto +2h
    move v1, v4
    if-eqz v1, +003h
    goto +2h
    move-object v15, v3
    if-eqz v15, +01ch
    check-cast v15, Ljava/lang/Number;
    invoke-virtual v15, Ljava/lang/Number;->longValue()J
    move-result-wide v5
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->itemView Landroid/view/View;
    invoke-virtual v15, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v15
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_login_devices_last_active I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-direct v14, v5, v6, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->formatTime(J)Ljava/lang/String;
    move-result-object v3
    aput-object v3, v2, v4
    invoke-virtual v15, v1, v2, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-direct v14, v0, v3, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->setOptionalText(Landroid/widget/TextView; Ljava/lang/String;)V
    return-void 
.end method
