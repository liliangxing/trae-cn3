# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "UpgradeReminderViewHolder.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;
.field private static final TAG_VIEW_HOLDER:Ljava/lang/String;
.field private final bodyView:Landroid/widget/TextView;
.field private final buttonView:Landroid/widget/TextView;
.field private final card:Landroid/widget/LinearLayout;
.field private final titleView:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$U1Gd4OwMMkVq4c31JhBW29O8sUY(kotlin.jvm.functions.Function1  java.lang.String  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->bind$lambda$0(Lkotlin/jvm/functions/Function1; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->Companion Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;
    return-void 
.end method

.method private constructor <init>(android.view.View  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 6
    # ins_size=6
    invoke-direct v0, v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->card Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->titleView Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->bodyView Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->buttonView Landroid/widget/TextView;
    return-void 
.end method

.method public synthetic constructor <init>(android.view.View  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.TextView  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;-><init>(Landroid/view/View; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-void 
.end method

.method private static final bind$lambda$0(kotlin.jvm.functions.Function1  java.lang.String  android.view.View)void
    .registers 3
    # ins_size=3
    if-eqz v0, +005h
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final bind(java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 6
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->titleView Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_upgrade_reminder_title I
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->bodyView Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_upgrade_reminder_body I
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->buttonView Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_upgrade_reminder_button I
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->buttonView Landroid/widget/TextView;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v1, v5, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function1; Ljava/lang/String;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
