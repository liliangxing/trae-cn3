# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "DeviceItemAdapter.kt"

.field private final ivIcon:Landroid/widget/ImageView;
.field private final ivRadio:Landroid/widget/ImageView;
.field private final llProductType:Landroid/widget/LinearLayout;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;
.field private final tvName:Landroid/widget/TextView;
.field private final tvProductType:Landroid/widget/TextView;
.field private final tvStatus:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$zTzpiO9LQjc2IqUYQdOhhoWSAms(com.bytedance.trae.conversation.devices.DeviceItemAdapter$LocationViewHolder  com.bytedance.trae.conversation.devices.DeviceItemAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->_init_$lambda$0(Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder; Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.devices.DeviceItemAdapter  android.view.View)void
    .registers 5
    # ins_size=3
    const-string v0, "itemView"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;
    invoke-direct v2, v4, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_icon I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->ivIcon Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_name I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvName Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->ll_product_type I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/LinearLayout;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->llProductType Landroid/widget/LinearLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_product_type I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvProductType Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_status I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvStatus Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_radio I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->ivRadio Landroid/widget/ImageView;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder; Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;)V
    invoke-virtual v4, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final _init_$lambda$0(com.bytedance.trae.conversation.devices.DeviceItemAdapter$LocationViewHolder  com.bytedance.trae.conversation.devices.DeviceItemAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->getAdapterPosition()I
    move-result v0
    const/4 v2, -1
    if-eq v0, v2, +012h
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;->access$getOnLocationClick$p(Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;)Lkotlin/jvm/functions/Function1;
    move-result-object v2
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;->access$getItem(Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter; I)Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v0
    const-string v1, "access$getItem(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.devices.DeviceItem)void
    .registers 7
    # ins_size=2
    const-string v0, "location"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->itemView Landroid/view/View;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->ll_container I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isSelected()Z
    move-result v1
    if-eqz v1, +008h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_task_location_item_selected I
    invoke-virtual v0, v1, Landroid/view/View;->setBackgroundResource(I)V
    goto +6h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_task_location_item_unselected I
    invoke-virtual v0, v1, Landroid/view/View;->setBackgroundResource(I)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isSelected()Z
    move-result v0
    if-eqz v0, +005h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->ic_device_selected I
    goto +15h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-eq v0, v1, +00ch
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline()Z
    move-result v0
    if-eqz v0, +003h
    goto +4h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->ic_device_offline I
    goto +3h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->ic_device_online I
    iget-object v1, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->ivRadio Landroid/widget/ImageView;
    invoke-virtual v1, v0, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v1, +00bh
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline()Z
    move-result v0
    if-eqz v0, +005h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->ic_device_computer_online I
    goto +14h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v1, +00bh
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline()Z
    move-result v0
    if-nez v0, +005h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->ic_device_comptuer_offline I
    goto +3h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->ic_device_select_remote I
    iget-object v1, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->ivIcon Landroid/widget/ImageView;
    invoke-virtual v1, v0, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvName Landroid/widget/TextView;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getName()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;->getShowProductType()Z
    move-result v0
    const/4 v1, 0
    const/16 v2, 8
    if-nez v0, +008h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->llProductType Landroid/widget/LinearLayout;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    goto +3ch
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v0
    aget v0, v3, v0
    const/4 v3, 1
    if-ne v0, v3, +029h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->llProductType Landroid/widget/LinearLayout;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvProductType Landroid/widget/TextView;
    const-string v3, "TRAE Work"
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvProductType Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_trae_work I
    invoke-virtual v0, v3, Landroid/widget/TextView;->setBackgroundResource(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvProductType Landroid/widget/TextView;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->itemView Landroid/view/View;
    invoke-virtual v3, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/conversation/R$color;->trae_product_type_work_text I
    invoke-static v3, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v0, v3, Landroid/widget/TextView;->setTextColor(I)V
    goto +6h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->llProductType Landroid/widget/LinearLayout;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v3, +075h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvStatus Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvStatus Landroid/widget/TextView;
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabelPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceStatusLabelPolicy;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline()Z
    move-result v2
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired()Z
    move-result v3
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabelPolicy;->resolve(Z Z)Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->getTextRes()I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(I)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired()Z
    move-result v0
    if-nez v0, +01bh
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvStatus Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_task_location_status_unpaired I
    invoke-virtual v6, v0, Landroid/widget/TextView;->setBackgroundResource(I)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvStatus Landroid/widget/TextView;
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_special_white I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v6, v0, Landroid/widget/TextView;->setTextColor(I)V
    goto +3eh
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline()Z
    move-result v6
    if-eqz v6, +01bh
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvStatus Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_task_location_status_online I
    invoke-virtual v6, v0, Landroid/widget/TextView;->setBackgroundResource(I)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvStatus Landroid/widget/TextView;
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_white I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v6, v0, Landroid/widget/TextView;->setTextColor(I)V
    goto +1fh
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvStatus Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_task_location_status_offline I
    invoke-virtual v6, v0, Landroid/widget/TextView;->setBackgroundResource(I)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvStatus Landroid/widget/TextView;
    iget-object v0, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v6, v0, Landroid/widget/TextView;->setTextColor(I)V
    goto +6h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->tvStatus Landroid/widget/TextView;
    invoke-virtual v6, v2, Landroid/widget/TextView;->setVisibility(I)V
    return-void 
.end method
