# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "SiteMessageAdapter.kt"

.field public static final $stable:I
.field private final fullDateFormat:Ljava/text/SimpleDateFormat;
.field private final isoDateFormat:Ljava/text/SimpleDateFormat;
.field private final items:Ljava/util/List;
.field private final monthDayFormat:Ljava/text/SimpleDateFormat;
.field private final onCtaClick:Lkotlin/jvm/functions/Function1;
.field private final onDeleteClick:Lkotlin/jvm/functions/Function2;
.field private final onItemClick:Lkotlin/jvm/functions/Function2;
.field private final onLongClick:Lkotlin/jvm/functions/Function3;
.field private openViewHolder:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
.field private final timeFormat:Ljava/text/SimpleDateFormat;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function3  kotlin.jvm.functions.Function2)void
    .registers 6
    # ins_size=5
    const-string v0, "onCtaClick"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onDeleteClick"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->onCtaClick Lkotlin/jvm/functions/Function1;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->onDeleteClick Lkotlin/jvm/functions/Function2;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->onLongClick Lkotlin/jvm/functions/Function3;
    iput-object v5, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->onItemClick Lkotlin/jvm/functions/Function2;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->items Ljava/util/List;
    new-instance v2, Ljava/text/SimpleDateFormat;
    const-string/jumbo v3, yyyy-MM-dd'T'HH:mm:ss'Z'
    sget-object v4, Ljava/util/Locale;->US Ljava/util/Locale;
    invoke-direct v2, v3, v4, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    const-string v3, "UTC"
    invoke-static v3, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->isoDateFormat Ljava/text/SimpleDateFormat;
    new-instance v2, Ljava/text/SimpleDateFormat;
    const-string v3, "HH:mm"
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v4
    invoke-direct v2, v3, v4, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->timeFormat Ljava/text/SimpleDateFormat;
    new-instance v2, Ljava/text/SimpleDateFormat;
    const-string v3, "MM/dd"
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v4
    invoke-direct v2, v3, v4, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->monthDayFormat Ljava/text/SimpleDateFormat;
    new-instance v2, Ljava/text/SimpleDateFormat;
    const-string/jumbo v3, yyyy/MM/dd
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v4
    invoke-direct v2, v3, v4, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->fullDateFormat Ljava/text/SimpleDateFormat;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function3  kotlin.jvm.functions.Function2  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 4
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method public static final synthetic access$getFullDateFormat$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter)java.text.SimpleDateFormat
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->fullDateFormat Ljava/text/SimpleDateFormat;
    return-object v0
.end method

.method public static final synthetic access$getIsoDateFormat$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter)java.text.SimpleDateFormat
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->isoDateFormat Ljava/text/SimpleDateFormat;
    return-object v0
.end method

.method public static final synthetic access$getMonthDayFormat$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter)java.text.SimpleDateFormat
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->monthDayFormat Ljava/text/SimpleDateFormat;
    return-object v0
.end method

.method public static final synthetic access$getOnCtaClick$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter)kotlin.jvm.functions.Function1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->onCtaClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public static final synthetic access$getOnDeleteClick$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter)kotlin.jvm.functions.Function2
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->onDeleteClick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public static final synthetic access$getOnItemClick$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter)kotlin.jvm.functions.Function2
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->onItemClick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public static final synthetic access$getOnLongClick$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter)kotlin.jvm.functions.Function3
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->onLongClick Lkotlin/jvm/functions/Function3;
    return-object v0
.end method

.method public static final synthetic access$getOpenViewHolder$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter)com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->openViewHolder Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
    return-object v0
.end method

.method public static final synthetic access$getTimeFormat$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter)java.text.SimpleDateFormat
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->timeFormat Ljava/text/SimpleDateFormat;
    return-object v0
.end method

.method public static final synthetic access$setOpenViewHolder$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->openViewHolder Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
    return-void 
.end method

.method public final appendData(java.util.List)void
    .registers 5
    # ins_size=2
    const-string v0, "list"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->items Ljava/util/List;
    move-object v2, v4
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, v2, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->notifyItemRangeInserted(I I)V
    return-void 
.end method

.method public final closeOpenItem()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->openViewHolder Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->animateClose()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->openViewHolder Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
    return-void 
.end method

.method public final getItem(int)com.bytedance.trae.home.solo.sitemessage.SiteMessageItem
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->items Ljava/util/List;
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    return-object v2
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public final isEmpty()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v0
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->onBindViewHolder(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->items Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    invoke-virtual v2, v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->bind(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem; I)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/home/R$layout;->item_site_message I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v2, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Landroid/view/View;)V
    return-object v4
.end method

.method public final removeAt(int)com.bytedance.trae.home.solo.sitemessage.SiteMessageItem
    .registers 3
    # ins_size=2
    if-ltz v2, +017h
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    if-lt v2, v0, +003h
    goto +dh
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->items Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->remove(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->notifyItemRemoved(I)V
    return-object v0
    const/4 v2, 0
    return-object v2
.end method

.method public final setData(java.util.List)void
    .registers 4
    # ins_size=2
    const-string v0, "list"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->items Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->items Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->clear()V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->items Ljava/util/List;
    check-cast v3, Ljava/util/Collection;
    invoke-interface v1, v3, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    new-instance v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageDiffCallback;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->items Ljava/util/List;
    invoke-direct v3, v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageDiffCallback;-><init>(Ljava/util/List; Ljava/util/List;)V
    check-cast v3, Landroidx/recyclerview/widget/DiffUtil$Callback;
    invoke-static v3, Landroidx/recyclerview/widget/DiffUtil;->calculateDiff(Landroidx/recyclerview/widget/DiffUtil$Callback;)Landroidx/recyclerview/widget/DiffUtil$DiffResult;
    move-result-object v3
    move-object v0, v2
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v3, v0, Landroidx/recyclerview/widget/DiffUtil$DiffResult;->dispatchUpdatesTo(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    return-void 
.end method
