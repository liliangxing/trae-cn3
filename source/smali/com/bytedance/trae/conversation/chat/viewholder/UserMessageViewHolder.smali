# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "UserMessageViewHolder.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$Companion;
.field private final attachmentAdapter:Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
.field private currentMessage:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field private expandedTextPopupWindow:Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;
.field private final gradientMask:Landroid/view/View;
.field private final imageUploadApi$delegate:Lkotlin/Lazy;
.field private isExpanded:Z
.field private final maxCount:I
.field private final messageContainer:Landroid/view/View;
.field private final messageListener:Lcom/bytedance/trae/conversation/chat/IMessageListener;
.field private messagePopupWindow:Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;
.field private resolveJob:Lkotlinx/coroutines/Job;
.field private final resourceUploadApi$delegate:Lkotlin/Lazy;
.field private final rvImages:Landroidx/recyclerview/widget/RecyclerView;
.field private final textContainer:Landroid/widget/FrameLayout;
.field private final tvContent:Landroid/widget/TextView;
.field private final tvShowMore:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$95piRekkOZlNjgRVarTEHf-1CSo(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  int  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.conversation.tracker.SoloChatMode)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->handleDeleteClick$lambda$1(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; I Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$G2S5aBz5zIaf17oQbvlzPzYEZ6o(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  android.view.View)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->_init_$lambda$7(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Landroid/view/View;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$K5O-jbz-Uom8sgsRIsuxykVZAw0(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  android.view.View  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->_init_$lambda$9(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$PyiHeJRcXOladLoGAgPNWMnhHvc()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->resourceUploadApi_delegate$lambda$5()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$V6K5hhxTLrCqRXO5u76oJj6tQ4I()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->resourceUploadApi_delegate$lambda$5$lambda$4()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$exVP0piAgtCXITBNxLoC6gVFbdY()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->imageUploadApi_delegate$lambda$3$lambda$2()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$hP0sAixxQ1KYBF7GLBi6zQozEqY()com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->imageUploadApi_delegate$lambda$3()Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$jDLThPLnCO0VpqGeAAyLmA5i5d4(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->applyCollapseState$lambda$35(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->Companion Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$Companion;
    return-void 
.end method

.method public constructor <init>(android.view.View  com.bytedance.trae.conversation.chat.IMessageListener)void
    .registers 9
    # ins_size=3
    const-string v0, "itemView"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, v7, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v8, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageListener Lcom/bytedance/trae/conversation/chat/IMessageListener;
    sget v8, Lcom/bytedance/trae/conversation/R$id;->tv_message I
    invoke-virtual v7, v8, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v8
    const-string v0, "findViewById(...)"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Landroid/widget/TextView;
    iput-object v8, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->rv_images I
    invoke-virtual v7, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView;
    iput-object v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->rvImages Landroidx/recyclerview/widget/RecyclerView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->ll_message_container I
    invoke-virtual v7, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageContainer Landroid/view/View;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->fl_text_container I
    invoke-virtual v7, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/FrameLayout;
    iput-object v2, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->textContainer Landroid/widget/FrameLayout;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->v_gradient_mask I
    invoke-virtual v7, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->gradientMask Landroid/view/View;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_show_more I
    invoke-virtual v7, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/TextView;
    iput-object v2, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvShowMore Landroid/widget/TextView;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;-><init>()V
    iput-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->attachmentAdapter Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    const/4 v3, 6
    iput v3, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->maxCount I
    new-instance v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda4;
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda4;-><init>()V
    invoke-static v3, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v3
    iput-object v3, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->imageUploadApi$delegate Lkotlin/Lazy;
    new-instance v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda5;
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda5;-><init>()V
    invoke-static v3, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v3
    iput-object v3, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->resourceUploadApi$delegate Lkotlin/Lazy;
    new-instance v3, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v7, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v4
    const/4 v5, 0
    invoke-direct v3, v4, v5, v5, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context; I Z)V
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v1, v3, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v1, v0, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    const/16 v0, 12
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->dp(I)I
    move-result v0
    new-instance v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$1;
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$1;-><init>(I)V
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;
    invoke-virtual v1, v3, Landroidx/recyclerview/widget/RecyclerView;->addItemDecoration(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda6;
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)V
    invoke-virtual v8, v0, Landroid/widget/TextView;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->setupGradientMask()V
    new-instance v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda7;
    invoke-direct v8, v6, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Landroid/view/View;)V
    invoke-virtual v2, v8, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final _init_$lambda$7(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  android.view.View)boolean
    .registers 9
    # ins_size=2
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->currentMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->startsWithAgentReviewMarker(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v8
    const/4 v0, 1
    if-eqz v8, +003h
    return v0
    invoke-direct v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->isExecutionCompleted()Z
    move-result v8
    const/4 v1, 0
    if-nez v8, +012h
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->currentMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v8, +00ah
    invoke-static v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->isBrainstormMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v8
    if-ne v8, v0, +004h
    move v8, v0
    goto +2h
    move v8, v1
    if-eqz v8, +003h
    return v0
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messagePopupWindow Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;
    if-eqz v8, +005h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->dismiss()V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->expandedTextPopupWindow Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;
    if-eqz v8, +005h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->dismiss()V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->currentMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v8, +009h
    invoke-static v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->isBrainstormMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v8
    if-ne v8, v0, +003h
    move v1, v0
    if-eqz v1, +005h
    sget-object v8, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;->Brainstorm Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;
    goto +ch
    invoke-direct v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->isExecutionCompleted()Z
    move-result v8
    if-nez v8, +005h
    sget-object v8, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;->Event Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;
    goto +3h
    sget-object v8, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;->Message Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1;
    invoke-direct v1, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$2$menuListener$1;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)V
    new-instance v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda8;
    invoke-direct v2, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)V
    iget-boolean v3, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->isExpanded Z
    const-string v4, "getContext(...)"
    if-eqz v3, +02eh
    new-instance v3, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    invoke-virtual v5, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v5
    invoke-static v5, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    invoke-virtual v4, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;
    move-result-object v4
    const-string v6, "getText(...)"
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;
    invoke-direct v3, v5, v4, v1, v8, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;-><init>(Landroid/content/Context; Ljava/lang/CharSequence; Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener; Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;)V
    iput-object v3, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->expandedTextPopupWindow Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->expandedTextPopupWindow Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;
    if-eqz v8, +02ah
    iget-object v7, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    check-cast v7, Landroid/view/View;
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->showBelow(Landroid/view/View;)V
    goto +21h
    new-instance v3, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    invoke-virtual v5, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v5
    invoke-static v5, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;
    invoke-direct v3, v5, v1, v8, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;-><init>(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener; Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;)V
    iput-object v3, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messagePopupWindow Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messagePopupWindow Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;
    if-eqz v8, +009h
    iget-object v7, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    check-cast v7, Landroid/view/View;
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->showBelow(Landroid/view/View;)V
    return v0
.end method

.method private static final _init_$lambda$9(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  android.view.View  android.view.View)void
    .registers 6
    # ins_size=3
    const/4 v5, 1
    iput-boolean v5, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->isExpanded Z
    invoke-virtual v4, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v5
    instance-of v0, v5, Landroidx/recyclerview/widget/RecyclerView;
    const/4 v1, 0
    if-eqz v0, +005h
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView;
    goto +2h
    move-object v5, v1
    if-eqz v5, +007h
    invoke-virtual v5, Landroidx/recyclerview/widget/RecyclerView;->getLayoutManager()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    move-result-object v0
    goto +2h
    move-object v0, v1
    instance-of v2, v0, Landroidx/recyclerview/widget/LinearLayoutManager;
    if-eqz v2, +005h
    move-object v1, v0
    check-cast v1, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->getBindingAdapterPosition()I
    move-result v0
    invoke-virtual v4, Landroid/view/View;->getTop()I
    move-result v4
    if-eqz v5, +007h
    invoke-virtual v5, Landroidx/recyclerview/widget/RecyclerView;->getPaddingTop()I
    move-result v2
    goto +2h
    const/4 v2, 0
    sub-int/2addr v4, v2
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->applyExpandedState()V
    if-eqz v1, +00dh
    const/4 v3, -1
    if-eq v0, v3, +00ah
    new-instance v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda2;
    invoke-direct v3, v1, v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda2;-><init>(Landroidx/recyclerview/widget/LinearLayoutManager; I I)V
    invoke-virtual v5, v3, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public static final synthetic access$getAttachmentAdapter$p(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder)com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$AttachmentListAdapter
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->attachmentAdapter Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    return-object v0
.end method

.method public static final synthetic access$getCurrentMessage$p(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->currentMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-object v0
.end method

.method public static final synthetic access$getImageUploadApi(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder)com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->getImageUploadApi()Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getResourceUploadApi(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder)com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->getResourceUploadApi()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getTvContent$p(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$handleDeleteClick(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->handleDeleteClick()V
    return-void 
.end method

.method public static final synthetic access$resolveChatMode(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder)com.bytedance.trae.conversation.tracker.SoloChatMode
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->resolveChatMode()Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-result-object v0
    return-object v0
.end method

.method private final applyCollapseState()void
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->isExpanded Z
    if-eqz v0, +006h
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->applyExpandedState()V
    return-void 
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageContainer Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v1
    const/4 v2, -2
    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->width I
    invoke-virtual v0, v1, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->textContainer Landroid/widget/FrameLayout;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v1
    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    iget v1, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->maxCount I
    invoke-virtual v0, v1, Landroid/widget/TextView;->setMaxLines(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->gradientMask Landroid/view/View;
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvShowMore Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final applyCollapseState$lambda$35(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder)void
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->isExpanded Z
    if-eqz v0, +003h
    return-void 
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    invoke-virtual v0, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Landroid/text/Layout;->getLineCount()I
    move-result v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->maxCount I
    if-le v0, v1, +00dh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->gradientMask Landroid/view/View;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v2, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvShowMore Landroid/widget/TextView;
    invoke-virtual v2, v1, Landroid/widget/TextView;->setVisibility(I)V
    return-void 
.end method

.method private final applyExpandedState()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageContainer Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v1
    const/4 v2, -2
    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->width I
    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v0, v1, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->textContainer Landroid/widget/FrameLayout;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v1
    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    const v1, 2147483647
    invoke-virtual v0, v1, Landroid/widget/TextView;->setMaxLines(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->gradientMask Landroid/view/View;
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvShowMore Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    return-void 
.end method

.method private final dp(int)int
    .registers 3
    # ins_size=2
    int-to-float v2, v2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v2, v0
    float-to-int v2, v2
    return v2
.end method

.method private final getAgentReviewMarkerDescription(com.bytedance.trae.im.model.MessagePart)java.lang.String
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v4
    const/4 v0, 0
    if-eqz v4, +019h
    const-string/jumbo v1, scene
    invoke-virtual v4, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +010h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v4, v0
    if-eqz v4, +006h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v4, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v4
    if-eqz v0, +044h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v1
    const-string v2, "getString(...)"
    sparse-switch v1, +0000040h
    goto +39h
    const-string v1, "check_pr_resolve"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +028h
    goto +30h
    const-string v1, "create_pr_review"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00ch
    goto +27h
    const-string v1, "check_pr_review"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +1eh
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_agent_review_desc_review I
    invoke-virtual v4, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +16h
    const-string v1, "create_pr_resolve"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +bh
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_agent_review_desc_resolve I
    invoke-virtual v4, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +3h
    const-string v4, ""
    return-object v4
    nop 
    sparse-switch-payload -40d96c2e 225b5be 273410b2 42699046
.end method

.method private final getAgentReviewMarkerTagText(com.bytedance.trae.im.model.MessagePart)java.lang.String
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v4
    const/4 v0, 0
    if-eqz v4, +019h
    const-string/jumbo v1, scene
    invoke-virtual v4, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +010h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v4, v0
    if-eqz v4, +006h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v4, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v4
    const-string v1, "check_pr_review"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    const-string v2, "getString(...)"
    if-nez v1, +015h
    const-string v1, "check_pr_resolve"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +bh
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_agent_review_create_pr I
    invoke-virtual v4, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +ah
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_agent_review_check_pr I
    invoke-virtual v4, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
.end method

.method private final getImageUploadApi()com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->imageUploadApi$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    return-object v0
.end method

.method private final getResourceUploadApi()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->resourceUploadApi$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    return-object v0
.end method

.method private final handleDeleteClick()void
    .registers 24
    # ins_size=1
    move-object/from16 v0, v23
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->currentMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-nez v1, +003h
    return-void 
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    invoke-virtual v2, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v4
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageListener Lcom/bytedance/trae/conversation/chat/IMessageListener;
    if-eqz v2, +00dh
    invoke-interface v2, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-nez v2, +004h
    const-string v2, ""
    move-object v7, v2
    invoke-direct/range v23, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->resolveChatMode()Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    const/4 v6, 0
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v8
    const/4 v9, 0
    const/16 v10, 9
    const/4 v11, 0
    move-object v5, v3
    invoke-direct/range v5 ... v11, Lcom/bytedance/trae/conversation/tracker/AIEventContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v5, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    invoke-virtual v5, v3, v2, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackDeleteClick(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageListener Lcom/bytedance/trae/conversation/chat/IMessageListener;
    if-eqz v3, +008h
    invoke-interface v3, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getAllMessages()Ljava/util/List;
    move-result-object v3
    if-nez v3, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    instance-of v5, v3, Ljava/util/Collection;
    const/4 v6, 0
    if-eqz v5, +00dh
    move-object v5, v3
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +004h
    move v15, v6
    goto +1fh
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, -00ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v5
    if-eqz v5, -010h
    add-int/lit8 v6, v6, 1
    if-gez v6, -014h
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -19h
    const/4 v3, 1
    if-ne v15, v3, +005h
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_delete_last_message_desc I
    goto +3h
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_delete_message_desc I
    move v6, v3
    sget-object v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_delete_message_title I
    invoke-virtual v4, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    move-object v5, v7
    const-string v9, "getString(...)"
    invoke-static v7, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    move-object v6, v7
    invoke-static v7, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v7, 0
    sget v8, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_btn_delete I
    invoke-virtual v4, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v10
    move-object v8, v10
    invoke-static v10, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    move v7, v15
    move-object/from16 v15, v16
    const/16 v17, 0
    const/16 v18, 0
    new-instance v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda3;
    move-object/from16 v19, v9
    invoke-direct v9, v0, v7, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; I Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    const/16 v20, 0
    const v21, 98280
    const/16 v22, 0
    const/4 v7, 0
    const/4 v9, 0
    invoke-static/range v3 ... v22, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->delete$default(Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method

.method private static final handleDeleteClick$lambda$1(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  int  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.conversation.tracker.SoloChatMode)kotlin.Unit
    .registers 14
    # ins_size=4
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;
    const/4 v9, 0
    move-object v4, v0
    move-object v5, v10
    move v6, v11
    move-object v7, v12
    move-object v8, v13
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$handleDeleteClick$1$1;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; I Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/conversation/tracker/SoloChatMode; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
.end method

.method private static final imageUploadApi_delegate$lambda$3()com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi
    .registers 7
    # ins_size=0
    new-instance v6, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda9;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda9;-><init>()V
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v6
.end method

.method private static final imageUploadApi_delegate$lambda$3$lambda$2()java.lang.String
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final isExecutionCompleted()boolean
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->currentMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageListener Lcom/bytedance/trae/conversation/chat/IMessageListener;
    if-eqz v0, +014h
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getAllMessages()Ljava/util/List;
    move-result-object v0
    if-nez v0, +003h
    goto +ch
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageListener Lcom/bytedance/trae/conversation/chat/IMessageListener;
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->isStreaming()Z
    move-result v0
    if-eqz v0, +003h
    return v1
    const/4 v0, 1
    return v0
    return v1
.end method

.method static final lambda$7$lambda$6(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder)void
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->isExpanded Z
    if-nez v0, +00fh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageContainer Landroid/view/View;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_chat_bubble_sent I
    invoke-virtual v0, v1, Landroid/view/View;->setBackgroundResource(I)V
    iget-object v2, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageContainer Landroid/view/View;
    const/4 v0, 0
    invoke-static v2, v0, Landroidx/core/view/ViewCompat;->setElevation(Landroid/view/View; F)V
    return-void 
.end method

.method static final lambda$9$lambda$8(androidx.recyclerview.widget.LinearLayoutManager  int  int)void
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Landroidx/recyclerview/widget/LinearLayoutManager;->scrollToPositionWithOffset(I I)V
    return-void 
.end method

.method private final resolveChatMode()com.bytedance.trae.conversation.tracker.SoloChatMode
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageListener Lcom/bytedance/trae/conversation/chat/IMessageListener;
    if-eqz v0, +00dh
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    const-string/jumbo v1, work
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->WORK Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    goto +eh
    const-string v1, "code"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->CODE Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    return-object v0
.end method

.method private static final resourceUploadApi_delegate$lambda$5()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 7
    # ins_size=0
    new-instance v6, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$$ExternalSyntheticLambda1;-><init>()V
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v6
.end method

.method private static final resourceUploadApi_delegate$lambda$5$lambda$4()java.lang.String
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final setupGradientMask()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_chat_user_bubble_gradient I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-static v0, Landroid/graphics/Color;->red(I)I
    move-result v1
    invoke-static v0, Landroid/graphics/Color;->green(I)I
    move-result v2
    invoke-static v0, Landroid/graphics/Color;->blue(I)I
    move-result v3
    const/4 v4, 0
    invoke-static v4, v1, v2, v3, Landroid/graphics/Color;->argb(I I I I)I
    move-result v1
    new-instance v2, Landroid/graphics/drawable/PaintDrawable;
    invoke-direct v2, Landroid/graphics/drawable/PaintDrawable;-><init>()V
    new-instance v3, Landroid/graphics/drawable/shapes/RectShape;
    invoke-direct v3, Landroid/graphics/drawable/shapes/RectShape;-><init>()V
    check-cast v3, Landroid/graphics/drawable/shapes/Shape;
    invoke-virtual v2, v3, Landroid/graphics/drawable/PaintDrawable;->setShape(Landroid/graphics/drawable/shapes/Shape;)V
    new-instance v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$setupGradientMask$1;
    invoke-direct v3, v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$setupGradientMask$1;-><init>(I I)V
    check-cast v3, Landroid/graphics/drawable/ShapeDrawable$ShaderFactory;
    invoke-virtual v2, v3, Landroid/graphics/drawable/PaintDrawable;->setShaderFactory(Landroid/graphics/drawable/ShapeDrawable$ShaderFactory;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->gradientMask Landroid/view/View;
    check-cast v2, Landroid/graphics/drawable/Drawable;
    invoke-virtual v0, v2, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    return-void 
.end method

.method private final startsWithAgentReviewMarker(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 5
    # ins_size=2
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQuery()Ljava/util/List;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    move-object v0, v4
    check-cast v0, Ljava/util/Collection;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v1
    if-nez v0, +015h
    invoke-interface v4, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v4
    const-string v0, "agent_review_marker"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move v1, v2
    return v1
.end method

.method public final bind(com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 45
    # ins_size=2
    move-object/from16 v6, v43
    move-object/from16 v0, v44
    const-string v1, "message"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->resolveJob Lkotlinx/coroutines/Job;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +007h
    invoke-static v1, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    iput-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->currentMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageListener Lcom/bytedance/trae/conversation/chat/IMessageListener;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v1
    goto +2h
    move-object v1, v3
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->attachmentAdapter Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v3
    const-string v7, ""
    if-nez v5, +003h
    move-object v5, v7
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->setConversationId(Ljava/lang/String;)V
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->attachmentAdapter Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v3
    if-nez v5, +003h
    move-object v5, v7
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->setChatSessionId(Ljava/lang/String;)V
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->attachmentAdapter Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v3
    if-nez v5, +003h
    move-object v5, v7
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->setCliType(Ljava/lang/String;)V
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->attachmentAdapter Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v3
    if-nez v1, +003h
    move-object v1, v7
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->setMode(Ljava/lang/String;)V
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->attachmentAdapter Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    invoke-virtual/range v44, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->setMessageId(Ljava/lang/String;)V
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->attachmentAdapter Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageListener Lcom/bytedance/trae/conversation/chat/IMessageListener;
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->setMessageListener(Lcom/bytedance/trae/conversation/chat/IMessageListener;)V
    const/4 v1, 0
    iput-boolean v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->isExpanded Z
    invoke-virtual/range v44, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQuery()Ljava/util/List;
    move-result-object v4
    if-nez v4, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    const-string/jumbo v8, slash_command
    const-string/jumbo v9, text
    const-string v10, "image"
    const-string v11, "attachment"
    const-string v12, "folder"
    const-string v13, "code"
    const-string/jumbo v14, terminal
    const-string/jumbo v15, web_page
    const-string v16, "file"
    const-string v17, "agent_review_marker"
    filled-new-array/range v8 ... v17, [Ljava/lang/String;
    move-result-object v5
    invoke-static v5, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v5
    move-object v8, v4
    check-cast v8, Ljava/lang/Iterable;
    instance-of v9, v8, Ljava/util/Collection;
    if-eqz v9, +00dh
    move-object v10, v8
    check-cast v10, Ljava/util/Collection;
    invoke-interface v10, Ljava/util/Collection;->isEmpty()Z
    move-result v10
    if-eqz v10, +004h
    move v5, v1
    goto +20h
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, -00ah
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/im/model/MessagePart;
    move-object v12, v5
    check-cast v12, Ljava/lang/Iterable;
    invoke-virtual v11, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v11
    invoke-static v12, v11, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v11
    xor-int/2addr v11, v2
    if-eqz v11, -018h
    move v5, v2
    const/16 v10, 8
    if-eqz v5, +02dh
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageContainer Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_unsupported_message_format I
    invoke-virtual v1, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->rvImages Landroidx/recyclerview/widget/RecyclerView;
    invoke-virtual v0, v10, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->attachmentAdapter Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->submitList(Ljava/util/List; Ljava/util/Map;)V
    return-void 
    const-string v5, "file"
    const-string/jumbo v11, terminal
    const-string v12, "code"
    const-string v13, "folder"
    const-string/jumbo v14, slash_command
    const-string v15, "agent_review_marker"
    if-eqz v9, +00dh
    move-object v9, v8
    check-cast v9, Ljava/util/Collection;
    invoke-interface v9, Ljava/util/Collection;->isEmpty()Z
    move-result v9
    if-eqz v9, +004h
    move v3, v1
    goto +57h
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, -00ah
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v9, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +037h
    invoke-virtual v9, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +02dh
    invoke-virtual v9, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +023h
    invoke-virtual v9, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v11, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +019h
    invoke-virtual v9, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +00fh
    invoke-virtual v9, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v15, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    move v3, v1
    goto +2h
    move v3, v2
    if-eqz v3, +004h
    move v3, v2
    goto +3h
    const/4 v3, 0
    goto -51h
    const-string/jumbo v8, url
    const-string/jumbo v9, web_page
    const-string/jumbo v10, text
    if-eqz v3, +43dh
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageContainer Landroid/view/View;
    invoke-virtual v3, v1, Landroid/view/View;->setVisibility(I)V
    new-instance v3, Landroid/text/SpannableStringBuilder;
    invoke-direct v3, Landroid/text/SpannableStringBuilder;-><init>()V
    invoke-interface v4, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v18
    if-eqz v18, +420h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v18
    move-object/from16 v1, v18
    check-cast v1, Lcom/bytedance/trae/im/model/MessagePart;
    sget-object v2, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->Companion Lcom/bytedance/trae/conversation/widget/CustomTagStyle$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/widget/CustomTagStyle$Companion;->fromMessagePartType(Ljava/lang/String; Lcom/bytedance/trae/im/model/MessagePart;)Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    move-result-object v0
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +037h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-eqz v0, +019h
    const-string v1, "content"
    invoke-virtual v0, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-nez v1, +005h
    invoke-virtual v3, v0, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    move-object/from16 v0, v44
    goto/16 +3cbh
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +032h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-eqz v0, +017h
    invoke-virtual v0, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-nez v1, -038h
    invoke-virtual v3, v0, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    goto -3dh
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    move-object/from16 v19, v4
    const-string/jumbo v4,  
    const-string v21, " "
    if-eqz v2, +241h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-eqz v0, +01bh
    const-string v2, "command_type"
    invoke-virtual v0, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +013h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +009h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +003h
    goto +2h
    move-object v0, v7
    const-string/jumbo v2, skill
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    move-object/from16 v22, v7
    const-string v7, "command"
    move-object/from16 v23, v14
    const-string v14, "display_name"
    move-object/from16 v24, v8
    const-string v8, "plugin"
    if-nez v2, +0cch
    invoke-static v0, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    goto/16 +0c4h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-eqz v0, +017h
    invoke-virtual v0, v14, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v1
    if-eqz v1, +019h
    invoke-virtual v1, v7, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +013h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    const/4 v1, 0
    if-eqz v1, +009h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +003h
    goto +3h
    move-object/from16 v1, v22
    sget-object v2, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->Companion Lcom/bytedance/trae/conversation/widget/CustomTagStyle$Companion;
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/widget/CustomTagStyle$Companion;->fromSlashCommandPartType(Ljava/lang/String;)Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    move-result-object v2
    if-eqz v0, +014h
    move-object v7, v0
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-lez v7, +004h
    const/4 v7, 1
    goto +2h
    const/4 v7, 0
    if-eqz v7, +003h
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    move-object v0, v1
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +194h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v4, 160
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, Landroid/text/SpannableStringBuilder;->length()I
    move-result v4
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v3, v1, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    invoke-virtual v3, Landroid/text/SpannableStringBuilder;->length()I
    move-result v1
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v7, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v7
    new-instance v8, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->getIconRes()I
    move-result v28
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    invoke-virtual v2, v7, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->getBgColor(Landroid/content/Context;)I
    move-result v34
    invoke-virtual v2, v7, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->getTextColor(Landroid/content/Context;)I
    move-result v35
    const/16 v36, 0
    const/16 v37, 1272
    const/16 v38, 0
    move-object/from16 v25, v8
    move-object/from16 v26, v7
    move-object/from16 v27, v0
    invoke-direct/range v25 ... v38, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;-><init>(Landroid/content/Context; Ljava/lang/String; I F F F F F I I F I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/16 v0, 33
    invoke-virtual v3, v8, v4, v1, v0, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    move-object/from16 v0, v21
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v3, v0, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    goto/16 +136h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +017h
    invoke-virtual v2, v14, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +011h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v14
    if-eqz v14, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v14
    if-eqz v14, +019h
    invoke-virtual v14, v7, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v7
    if-eqz v7, +013h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v14
    if-eqz v14, +003h
    goto +2h
    const/4 v7, 0
    if-eqz v7, +009h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v7
    if-eqz v7, +003h
    goto +3h
    move-object/from16 v7, v22
    invoke-static v0, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, +016h
    if-eqz v2, +014h
    move-object v14, v2
    check-cast v14, Ljava/lang/CharSequence;
    invoke-interface v14, Ljava/lang/CharSequence;->length()I
    move-result v14
    if-lez v14, +004h
    const/4 v14, 1
    goto +2h
    const/4 v14, 0
    if-eqz v14, +003h
    goto +2h
    const/4 v2, 0
    if-nez v2, +003h
    move-object v2, v7
    move-object v14, v2
    check-cast v14, Ljava/lang/CharSequence;
    invoke-interface v14, Ljava/lang/CharSequence;->length()I
    move-result v14
    if-lez v14, +004h
    const/4 v14, 1
    goto +2h
    const/4 v14, 0
    if-eqz v14, +0d2h
    new-instance v14, Ljava/lang/StringBuilder;
    invoke-direct v14, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v14, 160
    invoke-virtual v4, v14, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, Landroid/text/SpannableStringBuilder;->length()I
    move-result v14
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v3, v4, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    invoke-virtual v3, Landroid/text/SpannableStringBuilder;->length()I
    move-result v4
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v1
    move-object/from16 v42, v9
    if-eqz v1, +019h
    const-string v9, "icon_url"
    invoke-virtual v1, v9, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +011h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v9
    if-eqz v9, +003h
    goto +2h
    const/4 v1, 0
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    invoke-static v0, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +005h
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->ic_chat_attachment_plugins I
    goto +3h
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_skill I
    invoke-static v0, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +045h
    new-instance v0, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    move-object/from16 v25, v0
    iget-object v8, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v8, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v8
    move-object/from16 v26, v8
    move-object/from16 v20, v0
    const-string v0, "getContext(...)"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/PluginTagItem;
    move-object/from16 v29, v0
    invoke-direct v0, v7, v2, v9, v1, Lcom/bytedance/trae/conversation/widget/PluginTagItem;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String;)V
    new-instance v0, Ljava/lang/ref/WeakReference;
    move-object/from16 v31, v0
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    invoke-direct v0, v7, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 0
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 0
    const/16 v39, 0
    const/16 v40, 16320
    const/16 v41, 0
    move-object/from16 v27, v2
    move/from16 v28, v9
    move-object/from16 v30, v1
    invoke-direct/range v25 ... v41, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;-><init>(Landroid/content/Context; Ljava/lang/String; I Lcom/bytedance/trae/conversation/widget/PluginTagItem; Ljava/lang/String; Ljava/lang/ref/WeakReference; F F F F F I I F I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v0, v20
    goto +2fh
    new-instance v0, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    const-string v7, "getContext(...)"
    invoke-static v1, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 0
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 4088
    const/16 v39, 0
    move-object/from16 v25, v0
    move-object/from16 v26, v1
    move-object/from16 v27, v2
    move/from16 v28, v9
    invoke-direct/range v25 ... v39, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;-><init>(Landroid/content/Context; Ljava/lang/String; I Lcom/bytedance/trae/conversation/widget/SkillItem; F F F F F I I F I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/16 v1, 33
    invoke-virtual v3, v0, v14, v4, v1, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    move-object/from16 v0, v21
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v3, v0, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    goto/16 +141h
    move-object/from16 v0, v44
    move-object/from16 v4, v19
    move-object/from16 v7, v22
    move-object/from16 v14, v23
    move-object/from16 v8, v24
    goto/16 +141h
    move-object/from16 v22, v7
    move-object/from16 v24, v8
    move-object/from16 v42, v9
    move-object/from16 v23, v14
    if-eqz v0, +12bh
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +091h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v7
    const-string v8, "name"
    sparse-switch v7, +000038ah
    goto/16 +086h
    invoke-virtual v2, v5, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +07eh
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +078h
    invoke-virtual v2, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +072h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +068h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +062h
    goto/16 +062h
    invoke-virtual v2, v12, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +58h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +053h
    invoke-virtual v2, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +04dh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +043h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +03dh
    goto +3dh
    invoke-virtual v2, v11, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +34h
    const-string v2, "Terminal"
    goto +33h
    invoke-virtual v2, v13, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +2ah
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +025h
    invoke-virtual v2, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +01fh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +015h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +00fh
    goto +fh
    invoke-virtual v2, v15, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +6h
    invoke-direct v6, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->getAgentReviewMarkerTagText(Lcom/bytedance/trae/im/model/MessagePart;)Ljava/lang/String;
    move-result-object v2
    goto +3h
    move-object/from16 v2, v22
    move-object v7, v2
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-lez v7, +004h
    const/4 v7, 1
    goto +2h
    const/4 v7, 0
    if-eqz v7, +086h
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v7, 160
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, Landroid/text/SpannableStringBuilder;->length()I
    move-result v7
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v3, v4, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    invoke-virtual v3, Landroid/text/SpannableStringBuilder;->length()I
    move-result v4
    iget-object v8, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v8, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v8
    new-instance v9, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->getIconRes()I
    move-result v28
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    invoke-virtual v0, v8, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->getBgColor(Landroid/content/Context;)I
    move-result v34
    invoke-virtual v0, v8, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->getTextColor(Landroid/content/Context;)I
    move-result v35
    const/16 v36, 0
    const/16 v37, 1272
    const/16 v38, 0
    move-object/from16 v25, v9
    move-object/from16 v26, v8
    move-object/from16 v27, v2
    invoke-direct/range v25 ... v38, Lcom/bytedance/trae/conversation/widget/CustomTagSpan;-><init>(Landroid/content/Context; Ljava/lang/String; I F F F F F I I F I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/16 v0, 33
    invoke-virtual v3, v9, v7, v4, v0, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v15, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +020h
    invoke-direct v6, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->getAgentReviewMarkerDescription(Lcom/bytedance/trae/im/model/MessagePart;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +00ch
    move-object/from16 v1, v21
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v3, v1, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    invoke-virtual v3, v0, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +8h
    move-object/from16 v0, v21
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v3, v0, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    move-object/from16 v0, v44
    move-object/from16 v4, v19
    move-object/from16 v7, v22
    move-object/from16 v14, v23
    move-object/from16 v8, v24
    move-object/from16 v9, v42
    const/4 v1, 0
    const/4 v2, 1
    goto/16 -422h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto/16 +0c8h
    move-object/from16 v22, v7
    move-object/from16 v24, v8
    move-object/from16 v42, v9
    if-eqz v4, +098h
    move-object v0, v4
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    const/4 v1, 1
    xor-int/2addr v0, v1
    if-eqz v0, +08dh
    new-instance v0, Landroid/text/SpannableStringBuilder;
    invoke-direct v0, Landroid/text/SpannableStringBuilder;-><init>()V
    invoke-interface v4, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +079h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +022h
    sget-object v3, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->INSTANCE Lcom/bytedance/trae/im/model/MessagePartNormalizer;
    invoke-virtual v3, v2, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->extractText(Lcom/bytedance/trae/im/model/MessagePart;)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    const/4 v3, 1
    if-nez v3, +005h
    invoke-virtual v0, v2, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object/from16 v3, v24
    move-object/from16 v4, v42
    goto +43h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v3
    move-object/from16 v4, v42
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +036h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v2
    move-object/from16 v3, v24
    if-eqz v2, +017h
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +011h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    const/4 v5, 0
    goto +2h
    const/4 v5, 1
    if-nez v5, +005h
    invoke-virtual v0, v2, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +3h
    move-object/from16 v3, v24
    move-object/from16 v24, v3
    move-object/from16 v42, v4
    goto -7ch
    invoke-virtual v0, Landroid/text/SpannableStringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    goto +5h
    invoke-virtual/range v44, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getUserContent()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +00ah
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageContainer Landroid/view/View;
    const/16 v2, 8
    invoke-virtual v1, v2, Landroid/view/View;->setVisibility(I)V
    goto +7h
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageContainer Landroid/view/View;
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->tvContent Landroid/widget/TextView;
    if-nez v0, +005h
    move-object/from16 v7, v22
    goto +2h
    move-object v7, v0
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v1, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct/range v43, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->applyCollapseState()V
    invoke-virtual/range v44, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQuery()Ljava/util/List;
    move-result-object v0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +02bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v4
    const-string v5, "image"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +011h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v3
    const-string v4, "attachment"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    const/4 v3, 1
    if-eqz v3, -029h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2eh
    check-cast v1, Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +017h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->rvImages Landroidx/recyclerview/widget/RecyclerView;
    const/16 v1, 8
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->attachmentAdapter Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->submitList(Ljava/util/List; Ljava/util/Map;)V
    return-void 
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->rvImages Landroidx/recyclerview/widget/RecyclerView;
    const/4 v2, 0
    invoke-virtual v0, v2, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    move-object v0, v1
    check-cast v0, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +012h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-static v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->previewImageItemFromData(Lcom/bytedance/trae/im/model/MessagePart;)Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    move-result-object v3
    if-eqz v3, -010h
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v2, Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +00ch
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->attachmentAdapter Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->submitList(Ljava/util/List; Ljava/util/Map;)V
    return-void 
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->attachmentAdapter Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->getChatSessionId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +008h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->attachmentAdapter Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->getConversationId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    move-object v3, v2
    check-cast v3, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +061h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getKind()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    move-result-object v8
    sget-object v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->LOCAL_ARTIFACT Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    if-ne v8, v9, +037h
    sget-object v8, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;->INSTANCE Lcom/bytedance/trae/conversation/products/LocalArtifactPath;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;->requestTarget(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    new-instance v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-direct v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;-><init>()V
    sget-object v10, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v10
    invoke-virtual v10, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;
    move-result-object v10
    const-string v11, "getApplicationContext(...)"
    invoke-static v10, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, v10, v0, v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getCachedFile(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Ljava/io/File;
    move-result-object v8
    if-eqz v8, +028h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v7
    invoke-static v8, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;
    move-result-object v8
    invoke-virtual v8, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-static v7, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    goto +17h
    sget-object v8, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->get(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +00bh
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    goto +2h
    const/4 v7, 0
    if-eqz v7, -05fh
    invoke-interface v4, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -64h
    check-cast v4, Ljava/util/List;
    check-cast v4, Ljava/lang/Iterable;
    invoke-static v4, Lkotlin/collections/MapsKt;->toMap(Ljava/lang/Iterable;)Ljava/util/Map;
    move-result-object v4
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +019h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v7, v5
    check-cast v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v7
    invoke-interface v4, v7, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v7
    const/4 v8, 1
    xor-int/2addr v7, v8
    if-eqz v7, -017h
    invoke-interface v0, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ch
    move-object v5, v0
    check-cast v5, Ljava/util/List;
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->attachmentAdapter Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->submitList(Ljava/util/List; Ljava/util/Map;)V
    invoke-interface v5, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v7
    const/4 v8, 0
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;
    const/4 v11, 0
    move-object v0, v10
    move-object v1, v2
    move-object/from16 v2, v43
    move-object v3, v4
    move-object v4, v5
    move-object v5, v11
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;-><init>(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Ljava/util/Map; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    check-cast v10, Lkotlin/jvm/functions/Function2;
    const/4 v11, 3
    const/4 v12, 0
    invoke-static/range v7 ... v12, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->resolveJob Lkotlinx/coroutines/Job;
    return-void 
    sparse-switch-payload -76b1f0b9 -4ba2e392 -46686d84 2eaded 2ff57c
.end method

.method public final getMessageListener()com.bytedance.trae.conversation.chat.IMessageListener
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->messageListener Lcom/bytedance/trae/conversation/chat/IMessageListener;
    return-object v0
.end method
