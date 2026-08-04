# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;
.super Ljava/lang/Object;
.source "ActionBarPopupWindow.kt"

.field private final contextMenuPopupWindow:Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
.field private final listener:Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$OnMenuClickListener;
.field private final showRetry:Z


.method public constructor <init>(android.content.Context  com.bytedance.trae.conversation.chat.menu.ActionBarPopupWindow$OnMenuClickListener  boolean)void
    .registers 29
    # ins_size=4
    move-object/from16 v0, v25
    move-object/from16 v2, v26
    move-object/from16 v1, v27
    move/from16 v3, v28
    const-string v4, "context"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "listener"
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v25, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;->listener Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$OnMenuClickListener;
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;->showRetry Z
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v1
    const-string v4, "getString(...)"
    if-eqz v3, +025h
    new-instance v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    sget v6, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_retry I
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_message_menu_retry I
    invoke-virtual v2, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v7, v5
    check-cast v7, Ljava/lang/CharSequence;
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    new-instance v12, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$$ExternalSyntheticLambda0;
    invoke-direct v12, v0, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;)V
    const/16 v13, 60
    const/4 v14, 0
    move-object v5, v3
    invoke-direct/range v5 ... v14, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(I Ljava/lang/CharSequence; Z Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    sget v16, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_report I
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_message_menu_report I
    invoke-virtual v2, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v17, v5
    check-cast v17, Ljava/lang/CharSequence;
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    new-instance v4, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$$ExternalSyntheticLambda1;
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;)V
    const/16 v23, 60
    const/16 v24, 0
    move-object v15, v3
    move-object/from16 v22, v4
    invoke-direct/range v15 ... v24, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(I Ljava/lang/CharSequence; Z Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    new-instance v7, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    move-object v1, v7
    move-object/from16 v2, v26
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;-><init>(Landroid/content/Context; Ljava/util/List; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;->contextMenuPopupWindow Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  com.bytedance.trae.conversation.chat.menu.ActionBarPopupWindow$OnMenuClickListener  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 1
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;-><init>(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$OnMenuClickListener; Z)V
    return-void 
.end method

.method static final lambda$2$lambda$0(com.bytedance.trae.conversation.chat.menu.ActionBarPopupWindow)kotlin.Unit
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;->listener Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$OnMenuClickListener;
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$OnMenuClickListener;->onRetryClick()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method static final lambda$2$lambda$1(com.bytedance.trae.conversation.chat.menu.ActionBarPopupWindow)kotlin.Unit
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;->listener Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$OnMenuClickListener;
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$OnMenuClickListener;->onReportClick()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static synthetic showAbove$default(com.bytedance.trae.conversation.chat.menu.ActionBarPopupWindow  android.view.View  android.view.View  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    move-object v2, v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;->showAbove(Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public final dismiss()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;->contextMenuPopupWindow Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->dismiss()V
    return-void 
.end method

.method public final isShowing()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;->contextMenuPopupWindow Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->isShowing()Z
    move-result v0
    return v0
.end method

.method public final setOnDismissListener(android.widget.PopupWindow$OnDismissListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;->contextMenuPopupWindow Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    invoke-virtual v0, v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V
    return-void 
.end method

.method public final showAbove(android.view.View  android.view.View)void
    .registers 4
    # ins_size=3
    const-string v0, "anchor"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "horizontalAnchor"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;->contextMenuPopupWindow Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->showAbove(Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method
