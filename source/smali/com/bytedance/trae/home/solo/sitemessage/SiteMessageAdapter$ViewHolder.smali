# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "SiteMessageAdapter.kt"

.field private final btnCta:Landroid/widget/TextView;
.field private final btnDelete:Landroid/view/View;
.field private currentItem:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
.field private final layoutContent:Landroid/view/View;
.field private final layoutSwipeActions:Landroid/view/View;
.field private final swipeReveal:Lcom/bytedance/trae/common/widget/SwipeRevealController;
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
.field private final tvBody:Landroid/widget/TextView;
.field private final tvTime:Landroid/widget/TextView;
.field private final tvTitle:Landroid/widget/TextView;
.field private final unreadDot:Landroid/view/View;


.method public static synthetic $r8$lambda$1YnsSTAlyEiLzhjlr8aRDL8mzQ4(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->swipeReveal$lambda$2(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$DeZ6VnQ8pcMuL2gfTYumq_fgql0(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->swipeReveal$lambda$0(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$DfW_8d1bnanRw1cCWpP6tdqK4yo(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder  com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->bind$lambda$9(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$MLXttbv7IKduhBIZroYxVDfjym8(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->bind$lambda$5(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$YvWYxwUA32hY07txUKORBJ4GQEo(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder  com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->bind$lambda$7(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$d_tTPxaUfJ9ynyZX5G42t2XdR34(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->swipeReveal$lambda$1(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ytiO1cwvF_xAD6VdgdX0zOdBY7Q(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder  com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  com.bytedance.trae.common.widget.SwipeRevealController$LongPressTouch)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->_init_$lambda$4(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  android.view.View)void
    .registers 21
    # ins_size=3
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    move-object/from16 v2, v20
    const-string v3, "itemView"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    invoke-direct v0, v2, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v3, Lcom/bytedance/trae/home/R$id;->layout_content I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    const-string v3, "findViewById(...)"
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->layoutContent Landroid/view/View;
    sget v4, Lcom/bytedance/trae/home/R$id;->layout_swipe_actions I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->layoutSwipeActions Landroid/view/View;
    sget v4, Lcom/bytedance/trae/home/R$id;->btn_delete I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->btnDelete Landroid/view/View;
    sget v4, Lcom/bytedance/trae/home/R$id;->tv_title I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->tvTitle Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/home/R$id;->tv_body I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->tvBody Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/home/R$id;->tv_time I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->tvTime Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/home/R$id;->btn_cta I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->btnCta Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/home/R$id;->v_unread_dot I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->unreadDot Landroid/view/View;
    new-instance v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;
    const/4 v7, 0
    const-wide/16 v8, 0
    const/4 v10, 0
    const/4 v11, 0
    new-instance v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda3;
    invoke-direct v12, v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;)V
    const/4 v13, 0
    new-instance v14, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda4;
    invoke-direct v14, v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;)V
    new-instance v15, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda5;
    invoke-direct v15, v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;)V
    const/16 v16, 188
    const/16 v17, 0
    move-object v4, v2
    invoke-direct/range v4 ... v17, Lcom/bytedance/trae/common/widget/SwipeRevealController;-><init>(Landroid/view/View; Landroid/view/View; I J F F Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->swipeReveal Lcom/bytedance/trae/common/widget/SwipeRevealController;
    new-instance v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda6;
    invoke-direct v3, v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/common/widget/SwipeRevealController;->attachToContentWithTouch(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final _init_$lambda$4(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder  com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  com.bytedance.trae.common.widget.SwipeRevealController$LongPressTouch)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string/jumbo v0, touch
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->getAdapterPosition()I
    move-result v3
    const/4 v0, -1
    if-ne v3, v0, +005h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->currentItem Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    if-eqz v0, +011h
    invoke-static v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$getOnLongClick$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)Lkotlin/jvm/functions/Function3;
    move-result-object v2
    if-eqz v2, +00bh
    iget-object v1, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->layoutContent Landroid/view/View;
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v2, v1, v0, v3, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final bind$lambda$5(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$getOnCtaClick$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)Lkotlin/jvm/functions/Function1;
    move-result-object v0
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bind$lambda$7(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder  com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  android.view.View)void
    .registers 4
    # ins_size=3
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->getAdapterPosition()I
    move-result v3
    const/4 v0, -1
    if-ne v3, v0, +003h
    return-void 
    iget-object v1, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->currentItem Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    if-eqz v1, +00dh
    invoke-static v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$getOnDeleteClick$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)Lkotlin/jvm/functions/Function2;
    move-result-object v2
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v2, v1, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bind$lambda$9(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder  com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  android.view.View)void
    .registers 4
    # ins_size=3
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->getAdapterPosition()I
    move-result v3
    const/4 v0, -1
    if-ne v3, v0, +003h
    return-void 
    iget-object v1, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->currentItem Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    if-eqz v1, +00fh
    invoke-static v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$getOnItemClick$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)Lkotlin/jvm/functions/Function2;
    move-result-object v2
    if-eqz v2, +009h
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v2, v1, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final formatRelativeTime(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    const-string v3, ""
    if-eqz v0, +003h
    return-object v3
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    invoke-static v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$getIsoDateFormat$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)Ljava/text/SimpleDateFormat;
    move-result-object v0
    invoke-virtual v0, v6, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;
    move-result-object v6
    goto +2h
    const/4 v6, 0
    if-nez v6, +003h
    return-object v3
    invoke-static Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;
    move-result-object v0
    invoke-static Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;
    move-result-object v3
    invoke-virtual v0, v6, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v5, v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->isSameDay(Ljava/util/Calendar; Ljava/util/Calendar;)Z
    move-result v4
    if-eqz v4, +012h
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    invoke-static v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$getTimeFormat$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)Ljava/text/SimpleDateFormat;
    move-result-object v0
    invoke-virtual v0, v6, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v6
    const-string v0, "format(...)"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +4ah
    invoke-direct v5, v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->isYesterday(Ljava/util/Calendar; Ljava/util/Calendar;)Z
    move-result v4
    if-eqz v4, +020h
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_site_message_yesterday I
    new-array v2, v2, [Ljava/lang/Object;
    iget-object v4, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    invoke-static v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$getTimeFormat$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)Ljava/text/SimpleDateFormat;
    move-result-object v4
    invoke-virtual v4, v6, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v6
    aput-object v6, v2, v1
    invoke-virtual v0, v3, v2, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    goto +26h
    invoke-virtual v0, v2, Ljava/util/Calendar;->get(I)I
    move-result v0
    invoke-virtual v3, v2, Ljava/util/Calendar;->get(I)I
    move-result v1
    if-ne v0, v1, +010h
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    invoke-static v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$getMonthDayFormat$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)Ljava/text/SimpleDateFormat;
    move-result-object v0
    invoke-virtual v0, v6, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    goto +eh
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    invoke-static v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$getFullDateFormat$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)Ljava/text/SimpleDateFormat;
    move-result-object v0
    invoke-virtual v0, v6, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v6
    :try_start_0x16
.end method

.method private final isSameDay(java.util.Calendar  java.util.Calendar)boolean
    .registers 6
    # ins_size=3
    const/4 v0, 1
    invoke-virtual v4, v0, Ljava/util/Calendar;->get(I)I
    move-result v1
    invoke-virtual v5, v0, Ljava/util/Calendar;->get(I)I
    move-result v2
    if-ne v1, v2, +00eh
    const/4 v1, 6
    invoke-virtual v4, v1, Ljava/util/Calendar;->get(I)I
    move-result v4
    invoke-virtual v5, v1, Ljava/util/Calendar;->get(I)I
    move-result v5
    if-ne v4, v5, +003h
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private final isYesterday(java.util.Calendar  java.util.Calendar)boolean
    .registers 5
    # ins_size=3
    invoke-virtual v4, Ljava/util/Calendar;->clone()Ljava/lang/Object;
    move-result-object v4
    const-string v0, "null cannot be cast to non-null type java.util.Calendar"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/util/Calendar;
    const/4 v0, 6
    const/4 v1, -1
    invoke-virtual v4, v0, v1, Ljava/util/Calendar;->add(I I)V
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->isSameDay(Ljava/util/Calendar; Ljava/util/Calendar;)Z
    move-result v3
    return v3
.end method

.method private static final swipeReveal$lambda$0(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder)kotlin.Unit
    .registers 3
    # ins_size=2
    invoke-static v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$getOpenViewHolder$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
    move-result-object v0
    if-eqz v0, +015h
    invoke-static v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$getOpenViewHolder$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
    move-result-object v0
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00bh
    invoke-static v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$getOpenViewHolder$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->animateClose()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final swipeReveal$lambda$1(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$setOpenViewHolder$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final swipeReveal$lambda$2(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder)kotlin.Unit
    .registers 3
    # ins_size=2
    invoke-static v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$getOpenViewHolder$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
    move-result-object v0
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +006h
    const/4 v2, 0
    invoke-static v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->access$setOpenViewHolder$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final animateClose()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->swipeReveal Lcom/bytedance/trae/common/widget/SwipeRevealController;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animateClose()V
    return-void 
.end method

.method public final bind(com.bytedance.trae.home.solo.sitemessage.SiteMessageItem  int)void
    .registers 6
    # ins_size=3
    const-string v5, "item"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->currentItem Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->tvTitle Landroid/widget/TextView;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getTitle()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v5, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->tvBody Landroid/widget/TextView;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getBody()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v5, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->tvTime Landroid/widget/TextView;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getEffectiveTime()Ljava/lang/String;
    move-result-object v0
    invoke-direct v3, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->formatRelativeTime(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v5, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->unreadDot Landroid/view/View;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->isRead()Ljava/lang/Boolean;
    move-result-object v0
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const/16 v2, 8
    if-eqz v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    invoke-virtual v5, v0, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getActionTitle()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    const/4 v0, 1
    if-nez v0, +019h
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->btnCta Landroid/widget/TextView;
    invoke-virtual v0, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->btnCta Landroid/widget/TextView;
    invoke-virtual v5, v1, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->btnCta Landroid/widget/TextView;
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    new-instance v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;)V
    invoke-virtual v5, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +ch
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->btnCta Landroid/widget/TextView;
    invoke-virtual v4, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->btnCta Landroid/widget/TextView;
    const/4 v5, 0
    invoke-virtual v4, v5, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->swipeReveal Lcom/bytedance/trae/common/widget/SwipeRevealController;
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/SwipeRevealController;->reset()V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->btnDelete Landroid/view/View;
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v0, v3, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)V
    invoke-virtual v4, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->layoutContent Landroid/view/View;
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda2;
    invoke-direct v0, v3, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;)V
    invoke-virtual v4, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
