# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "DeviceOverLimitDeviceAdapter.kt"

.field private final devices:Ljava/util/List;
.field private final onLogoutClick:Lkotlin/jvm/functions/Function1;


.method public constructor <init>(java.util.List  kotlin.jvm.functions.Function1)void
    .registers 4
    # ins_size=3
    const-string v0, "devices"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onLogoutClick
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->onLogoutClick Lkotlin/jvm/functions/Function1;
    check-cast v2, Ljava/util/Collection;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->devices Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$formatTime(com.bytedance.trae.login.DeviceOverLimitDeviceAdapter  java.lang.Long)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->formatTime(Ljava/lang/Long;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getOnLogoutClick$p(com.bytedance.trae.login.DeviceOverLimitDeviceAdapter)kotlin.jvm.functions.Function1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->onLogoutClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public static final synthetic access$resolveDeviceIcon(com.bytedance.trae.login.DeviceOverLimitDeviceAdapter  com.bytedance.trae.login.traeauth.DeviceSummary)int
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->resolveDeviceIcon(Lcom/bytedance/trae/login/traeauth/DeviceSummary;)I
    move-result v0
    return v0
.end method

.method private final formatTime(java.lang.Long)java.lang.String
    .registers 7
    # ins_size=2
    const-string v0, "--"
    if-eqz v6, +028h
    invoke-virtual v6, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    const-wide/16 v3, 0
    cmp-long v6, v1, v3
    if-gtz v6, +003h
    return-object v0
    new-instance v6, Ljava/text/SimpleDateFormat;
    const-string/jumbo v0, yyyy/MM/dd HH:mm:ss
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v3
    invoke-direct v6, v0, v3, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    new-instance v0, Ljava/util/Date;
    invoke-direct v0, v1, v2, Ljava/util/Date;-><init>(J)V
    invoke-virtual v6, v0, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v6
    const-string v0, "format(...)"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v6
    return-object v0
.end method

.method private final resolveDeviceIcon(com.bytedance.trae.login.traeauth.DeviceSummary)int
    .registers 14
    # ins_size=2
    const/4 v0, 3
    new-array v0, v0, [Ljava/lang/String;
    invoke-virtual v13, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getDeviceType()Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    const/4 v1, 1
    invoke-virtual v13, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getPlatformCode()Ljava/lang/String;
    move-result-object v3
    aput-object v3, v0, v1
    invoke-virtual v13, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getDeviceModel()Ljava/lang/String;
    move-result-object v13
    const/4 v1, 2
    aput-object v13, v0, v1
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v13
    move-object v3, v13
    check-cast v3, Ljava/lang/Iterable;
    const-string v13, " "
    move-object v4, v13
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 62
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v3, "ROOT"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v13, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v13
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v13, Ljava/lang/CharSequence;
    const-string/jumbo v0, phone
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v3, 0
    invoke-static v13, v0, v2, v1, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +02eh
    const-string v0, "mobile"
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v13, v0, v2, v1, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +024h
    const-string v0, "android"
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v13, v0, v2, v1, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +01ah
    const-string v0, "ios"
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v13, v0, v2, v1, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +010h
    const-string v0, "iphone"
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v13, v0, v2, v1, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, +003h
    goto +4h
    sget v13, Lcom/bytedance/trae/login/R$drawable;->ic_device_manager_computer I
    goto +3h
    sget v13, Lcom/bytedance/trae/login/R$drawable;->ic_device_manager_computer_mobile I
    return v13
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->devices Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->onBindViewHolder(Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.login.DeviceOverLimitDeviceAdapter$DeviceViewHolder  int)void
    .registers 6
    # ins_size=3
    const-string v0, "holder"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->devices Ljava/util/List;
    invoke-interface v0, v5, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/traeauth/DeviceSummary;
    iget-object v1, v3, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->devices Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    const/4 v2, 1
    sub-int/2addr v1, v2
    if-ne v5, v1, +003h
    goto +2h
    const/4 v2, 0
    invoke-virtual v4, v0, v2, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;->bind(Lcom/bytedance/trae/login/traeauth/DeviceSummary; Z)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.login.DeviceOverLimitDeviceAdapter$DeviceViewHolder
    .registers 4
    # ins_size=3
    const-string/jumbo v3, parent
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v3
    invoke-static v3, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v3
    const/4 v0, 0
    invoke-static v3, v2, v0, Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;
    move-result-object v2
    const-string v3, "inflate(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;
    invoke-direct v3, v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter$DeviceViewHolder;-><init>(Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter; Lcom/bytedance/trae/login/databinding/TraeItemDeviceOverLimitBinding;)V
    return-object v3
.end method

.method public final removeDevice(java.lang.String)void
    .registers 6
    # ins_size=2
    const-string v0, "deviceId"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->devices Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v1, 0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    const/4 v3, -1
    if-eqz v2, +016h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/traeauth/DeviceSummary;
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getDeviceId()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +5h
    add-int/lit8 v1, v1, 1
    goto -1ah
    move v1, v3
    if-eq v1, v3, +00ah
    iget-object v5, v4, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->devices Ljava/util/List;
    invoke-interface v5, v1, Ljava/util/List;->remove(I)Ljava/lang/Object;
    invoke-virtual v4, v1, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->notifyItemRemoved(I)V
    return-void 
.end method
