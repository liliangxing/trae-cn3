# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
.super Landroidx/recyclerview/widget/ListAdapter;
.source "ChatMessageAdapter.kt"

.implements Lcom/bytedance/trae/conversation/chat/IMessageListener;

.field private static final AGENT_FLOW_TAG:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$Companion;
.field private static final DIFF_CALLBACK:Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$Companion$DIFF_CALLBACK$1;
.field private static final PAYLOAD_STREAMING_UPDATE:Ljava/lang/String;
.field private static final VIEW_TYPE_AGENT:I
.field private static final VIEW_TYPE_FOOTER:I
.field private static final VIEW_TYPE_USER:I
.field private final context:Landroid/content/Context;
.field private conversation:Lcom/bytedance/trae/im/service/Conversation;
.field private currentDebugDialog:Landroidx/appcompat/app/AlertDialog;
.field private isSubmitInFlight:Z
.field private onContentChanged:Lkotlin/jvm/functions/Function0;
.field private onCopyClick:Lkotlin/jvm/functions/Function1;
.field private onFeedbackClick:Lkotlin/jvm/functions/Function2;
.field private onPureShowWidgetInlineViewCreated:Lkotlin/jvm/functions/Function1;
.field private onReportClick:Lkotlin/jvm/functions/Function2;
.field private onRetryClick:Lkotlin/jvm/functions/Function1;
.field private onUpgradeReminderClick:Lkotlin/jvm/functions/Function1;
.field private onUseExpressPassClick:Lkotlin/jvm/functions/Function1;
.field private final pendingSubmitOps:Lkotlin/collections/ArrayDeque;
.field private upgradeReminderConversationId:Ljava/lang/String;


.method public static synthetic $r8$lambda$2aMCnOhBMVvlNAjsnLQycQHGLX4(com.bytedance.trae.conversation.chat.ChatMessageAdapter  java.lang.String  java.lang.Runnable)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->submitMessages$lambda$13(Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter; Ljava/lang/String; Ljava/lang/Runnable;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$JLvXHz8h7JzqTT7LNqq3V73t8-8(com.bytedance.trae.conversation.chat.ChatMessageAdapter  android.content.DialogInterface  int)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->showDebugDialog$lambda$11(Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter; Landroid/content/DialogInterface; I)V
    return-void 
.end method

.method public static synthetic $r8$lambda$MYpiezSnQ35Vo9A3fbeDwY9B870(com.bytedance.trae.conversation.chat.ChatMessageAdapter  com.bytedance.trae.im.model.ParsedChatMessage  int  android.view.View)boolean
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onBindViewHolder$lambda$4(Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter; Lcom/bytedance/trae/im/model/ParsedChatMessage; I Landroid/view/View;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$XBdfbBDTWWL7I75EoxeUSKtOlhE(android.content.Context  java.lang.String  com.bytedance.trae.conversation.chat.ChatMessageAdapter  android.content.DialogInterface  int)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->showDebugDialog$lambda$10(Landroid/content/Context; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter; Landroid/content/DialogInterface; I)V
    return-void 
.end method

.method public static synthetic $r8$lambda$artdIf77H2dONZ4vqQjxQWbFaD4(com.bytedance.trae.conversation.chat.ChatMessageAdapter  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->showDebugDialog$lambda$12(Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$cd8LKvRrhkYzK4Bo6drDwqeKhko(com.bytedance.trae.conversation.chat.ChatMessageAdapter  java.util.List  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->enqueueSubmitList$lambda$18(Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter; Ljava/util/List; Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$j5dKMFMaBEKOxehwNSMhSfYe3dw(kotlin.jvm.functions.Function0  com.bytedance.trae.conversation.chat.ChatMessageAdapter)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->enqueueSubmitList$lambda$18$lambda$17(Lkotlin/jvm/functions/Function0; Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->Companion Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$Companion$DIFF_CALLBACK$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$Companion$DIFF_CALLBACK$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->DIFF_CALLBACK Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$Companion$DIFF_CALLBACK$1;
    return-void 
.end method

.method public constructor <init>(android.content.Context)void
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->DIFF_CALLBACK Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$Companion$DIFF_CALLBACK$1;
    check-cast v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/ListAdapter;-><init>(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->context Landroid/content/Context;
    new-instance v2, Lkotlin/collections/ArrayDeque;
    invoke-direct v2, Lkotlin/collections/ArrayDeque;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->pendingSubmitOps Lkotlin/collections/ArrayDeque;
    return-void 
.end method

.method private final drainSubmitQueue()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->pendingSubmitOps Lkotlin/collections/ArrayDeque;
    invoke-virtual v0, Lkotlin/collections/ArrayDeque;->removeFirstOrNull()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lkotlin/jvm/functions/Function0;
    if-nez v0, +003h
    return-void 
    const/4 v1, 1
    iput-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->isSubmitInFlight Z
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final enqueueSubmitList(java.util.List  kotlin.jvm.functions.Function0)void
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->pendingSubmitOps Lkotlin/collections/ArrayDeque;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda5;
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter; Ljava/util/List; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v0, v1, Lkotlin/collections/ArrayDeque;->addLast(Ljava/lang/Object;)V
    iget-boolean v3, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->isSubmitInFlight Z
    if-nez v3, +005h
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->drainSubmitQueue()V
    return-void 
.end method

.method static synthetic enqueueSubmitList$default(com.bytedance.trae.conversation.chat.ChatMessageAdapter  java.util.List  kotlin.jvm.functions.Function0  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->enqueueSubmitList(Ljava/util/List; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final enqueueSubmitList$lambda$18(com.bytedance.trae.conversation.chat.ChatMessageAdapter  java.util.List  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function0; Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;)V
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->submitList(Ljava/util/List; Ljava/lang/Runnable;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final enqueueSubmitList$lambda$18$lambda$17(kotlin.jvm.functions.Function0  com.bytedance.trae.conversation.chat.ChatMessageAdapter)void
    .registers 2
    # ins_size=2
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->isSubmitInFlight Z
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->drainSubmitQueue()V
    return-void 
.end method

.method private final isLatestAgentMsg(int)boolean
    .registers 4
    # ins_size=2
    invoke-super v2, Landroidx/recyclerview/widget/ListAdapter;->getItemCount()I
    move-result v0
    const/4 v1, 1
    sub-int/2addr v0, v1
    if-ne v3, v0, +00fh
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    const/4 v1, 0
    return v1
.end method

.method private final isLatestAgentTurn(int)boolean
    .registers 4
    # ins_size=2
    invoke-super v2, Landroidx/recyclerview/widget/ListAdapter;->getItemCount()I
    move-result v0
    const/4 v1, 1
    sub-int/2addr v0, v1
    if-ne v3, v0, +003h
    goto +2h
    const/4 v1, 0
    return v1
.end method

.method private final notifyUpgradeReminderTargetChanged(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const/4 v0, 2
    new-array v0, v0, [Ljava/lang/String;
    const/4 v1, 0
    aput-object v3, v0, v1
    const/4 v3, 1
    aput-object v4, v0, v3
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOfNotNull([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +012h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->positionOfMessage(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v0
    if-eqz v0, -010h
    invoke-interface v4, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v4, Ljava/util/List;
    check-cast v4, Ljava/lang/Iterable;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +010h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/Number;
    invoke-virtual v4, Ljava/lang/Number;->intValue()I
    move-result v4
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->notifyItemChanged(I)V
    goto -13h
    return-void 
.end method

.method private static final onBindViewHolder$lambda$4(com.bytedance.trae.conversation.chat.ChatMessageAdapter  com.bytedance.trae.im.model.ParsedChatMessage  int  android.view.View)boolean
    .registers 6
    # ins_size=4
    invoke-virtual v5, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v5
    const-string v0, "getContext(...)"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Debug Message ("
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v0, 41
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v2, v5, v3, v4, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->showDebugDialog(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String;)V
    const/4 v2, 1
    return v2
.end method

.method private final positionOfMessage(java.lang.String)java.lang.Integer
    .registers 5
    # ins_size=2
    invoke-super v3, Landroidx/recyclerview/widget/ListAdapter;->getItemCount()I
    move-result v0
    const/4 v1, 0
    if-ge v1, v0, +01ah
    invoke-virtual v3, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +007h
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    return-object v4
    add-int/lit8 v1, v1, 1
    goto -19h
    const/4 v4, 0
    return-object v4
.end method

.method private final showDebugDialog(android.content.Context  com.bytedance.trae.im.model.ParsedChatMessage  java.lang.String)void
    .registers 12
    # ins_size=4
    const-string v0, "
Message JSON:
"
    const-string v1, "DID: "
    const-string v2, "Title: "
    const-string v3, "Failed to serialize: "
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v4
    if-eqz v4, +0e1h
    iget-object v4, v8, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->currentDebugDialog Landroidx/appcompat/app/AlertDialog;
    const/4 v5, 0
    const/4 v6, 1
    if-eqz v4, +009h
    invoke-virtual v4, Landroidx/appcompat/app/AlertDialog;->isShowing()Z
    move-result v4
    if-ne v4, v6, +003h
    move v5, v6
    if-eqz v5, +003h
    return-void 
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v4
    new-instance v5, Lcom/google/gson/GsonBuilder;
    invoke-direct v5, Lcom/google/gson/GsonBuilder;-><init>()V
    invoke-virtual v5, Lcom/google/gson/GsonBuilder;->setPrettyPrinting()Lcom/google/gson/GsonBuilder;
    move-result-object v5
    invoke-virtual v5, Lcom/google/gson/GsonBuilder;->serializeNulls()Lcom/google/gson/GsonBuilder;
    move-result-object v5
    invoke-virtual v5, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;
    move-result-object v5
    invoke-virtual v5, v10, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    goto +13h
    move-exception v5
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, Ljava/lang/StringBuilder;-><init>()V
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v5, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const/16 v2, 10
    invoke-virtual v11, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v5, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    move-object v1, v11
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/16 v1, 32
    const/16 v2, 48
    invoke-virtual v0, v2, v1, v2, v1, Landroid/widget/TextView;->setPadding(I I I I)V
    invoke-virtual v0, v6, Landroid/widget/TextView;->setTextIsSelectable(Z)V
    const/high16 v1, 1094713344
    invoke-virtual v0, v1, Landroid/widget/TextView;->setTextSize(F)V
    new-instance v1, Landroid/widget/ScrollView;
    invoke-direct v1, v9, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V
    check-cast v0, Landroid/view/View;
    invoke-virtual v1, v0, Landroid/widget/ScrollView;->addView(Landroid/view/View;)V
    new-instance v0, Landroidx/appcompat/app/AlertDialog$Builder;
    invoke-direct v0, v9, Landroidx/appcompat/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V
    const-string v2, "Debug Message Info"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroidx/appcompat/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroidx/appcompat/app/AlertDialog$Builder;
    move-result-object v0
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroidx/appcompat/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroidx/appcompat/app/AlertDialog$Builder;
    move-result-object v0
    const-string v1, "Copy"
    check-cast v1, Ljava/lang/CharSequence;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda1;
    invoke-direct v2, v9, v11, v8, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda1;-><init>(Landroid/content/Context; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;)V
    invoke-virtual v0, v1, v2, Landroidx/appcompat/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence; Landroid/content/DialogInterface$OnClickListener;)Landroidx/appcompat/app/AlertDialog$Builder;
    move-result-object v9
    const-string v11, "Close"
    check-cast v11, Ljava/lang/CharSequence;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda2;
    invoke-direct v0, v8, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;)V
    invoke-virtual v9, v11, v0, Landroidx/appcompat/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence; Landroid/content/DialogInterface$OnClickListener;)Landroidx/appcompat/app/AlertDialog$Builder;
    move-result-object v9
    new-instance v11, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda3;
    invoke-direct v11, v8, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;)V
    invoke-virtual v9, v11, Landroidx/appcompat/app/AlertDialog$Builder;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)Landroidx/appcompat/app/AlertDialog$Builder;
    move-result-object v9
    invoke-virtual v9, Landroidx/appcompat/app/AlertDialog$Builder;->show()Landroidx/appcompat/app/AlertDialog;
    move-result-object v9
    iput-object v9, v8, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->currentDebugDialog Landroidx/appcompat/app/AlertDialog;
    sget-object v9, Lcom/bytedance/trae/im/log/IMLog;->INSTANCE Lcom/bytedance/trae/im/log/IMLog;
    const-string v11, "ChatMessageAdapter.showDebugDialog"
    invoke-virtual v9, v11, v10, Lcom/bytedance/trae/im/log/IMLog;->logParsedChatMessage(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    goto +4h
    const/4 v9, 0
    iput-object v9, v8, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->currentDebugDialog Landroidx/appcompat/app/AlertDialog;
    return-void 
    :try_start_0x10
    :try_start_0x37
    :try_start_0x3d
.end method

.method private static final showDebugDialog$lambda$10(android.content.Context  java.lang.String  com.bytedance.trae.conversation.chat.ChatMessageAdapter  android.content.DialogInterface  int)void
    .registers 6
    # ins_size=5
    const-string v5, "clipboard"
    invoke-virtual v1, v5, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v5
    const-string v0, "null cannot be cast to non-null type android.content.ClipboardManager"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/content/ClipboardManager;
    const-string v0, "debug_message"
    check-cast v0, Ljava/lang/CharSequence;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v0, v2, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Landroid/content/ClipData;
    move-result-object v2
    invoke-virtual v5, v2, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_copied I
    invoke-static v1, v2, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; I)V
    invoke-interface v4, Landroid/content/DialogInterface;->dismiss()V
    const/4 v1, 0
    iput-object v1, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->currentDebugDialog Landroidx/appcompat/app/AlertDialog;
    return-void 
.end method

.method private static final showDebugDialog$lambda$11(com.bytedance.trae.conversation.chat.ChatMessageAdapter  android.content.DialogInterface  int)void
    .registers 3
    # ins_size=3
    invoke-interface v1, Landroid/content/DialogInterface;->dismiss()V
    const/4 v1, 0
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->currentDebugDialog Landroidx/appcompat/app/AlertDialog;
    return-void 
.end method

.method private static final showDebugDialog$lambda$12(com.bytedance.trae.conversation.chat.ChatMessageAdapter  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    const/4 v1, 0
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->currentDebugDialog Landroidx/appcompat/app/AlertDialog;
    return-void 
.end method

.method public static synthetic submitMessages$default(com.bytedance.trae.conversation.chat.ChatMessageAdapter  java.util.List  java.lang.Runnable  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->submitMessages(Ljava/util/List; Ljava/lang/Runnable;)V
    return-void 
.end method

.method private static final submitMessages$lambda$13(com.bytedance.trae.conversation.chat.ChatMessageAdapter  java.lang.String  java.lang.Runnable)kotlin.Unit
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->upgradeReminderTargetMessageId()Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->notifyUpgradeReminderTargetChanged(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v3, +005h
    invoke-interface v3, Ljava/lang/Runnable;->run()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final upgradeReminderTargetMessageId()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->upgradeReminderTargetPosition()Ljava/lang/Integer;
    move-result-object v0
    if-eqz v0, +013h
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method private final upgradeReminderTargetPosition()java.lang.Integer
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->upgradeReminderConversationId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    invoke-super v3, Landroidx/recyclerview/widget/ListAdapter;->getItemCount()I
    move-result v0
    add-int/lit8 v0, v0, -1
    const/4 v2, -1
    if-ge v2, v0, +016h
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v2
    if-eqz v2, +007h
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    return-object v0
    add-int/lit8 v0, v0, -1
    goto -16h
    return-object v1
.end method

.method public getAllMessages()java.util.List
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v0
    const-string v1, "getCurrentList(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public final getConversation()com.bytedance.trae.im.service.Conversation
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->conversation Lcom/bytedance/trae/im/service/Conversation;
    return-object v0
.end method

.method public getCurrentConversation()com.bytedance.trae.im.service.Conversation
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->conversation Lcom/bytedance/trae/im/service/Conversation;
    return-object v0
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/recyclerview/widget/ListAdapter;->getItemCount()I
    move-result v0
    if-gtz v0, +004h
    const/4 v0, 0
    return v0
    add-int/lit8 v0, v0, 1
    return v0
.end method

.method public getItemViewType(int)int
    .registers 3
    # ins_size=2
    invoke-super v1, Landroidx/recyclerview/widget/ListAdapter;->getItemCount()I
    move-result v0
    if-lt v2, v0, +004h
    const/4 v2, 2
    return v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    return v2
.end method

.method public final getOnContentChanged()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onContentChanged Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnCopyClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onCopyClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnFeedbackClick()kotlin.jvm.functions.Function2
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onFeedbackClick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public final getOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnReportClick()kotlin.jvm.functions.Function2
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onReportClick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public final getOnRetryClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onRetryClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnUpgradeReminderClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onUpgradeReminderClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnUseExpressPassClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onUseExpressPassClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public isStreaming()boolean
    .registers 6
    # ins_size=1
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v0
    const-string v1, "getCurrentList(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    instance-of v1, v0, Ljava/util/Collection;
    const/4 v2, 0
    if-eqz v1, +00ch
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +2ah
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +021h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v3
    const/4 v4, 1
    if-nez v3, +010h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v3
    if-nez v3, +00ah
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected()Z
    move-result v1
    if-nez v1, +004h
    move v1, v4
    goto +2h
    move v1, v2
    if-eqz v1, -022h
    move v2, v4
    return v2
.end method

.method public onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 12
    # ins_size=3
    const-string v0, "holder"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, v11, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getItemViewType(I)I
    move-result v0
    const/4 v1, 2
    if-ne v0, v1, +003h
    return-void 
    invoke-virtual v9, v11, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    instance-of v1, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    if-eqz v1, +00dh
    move-object v1, v10
    check-cast v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->bind(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    goto/16 +0bah
    instance-of v1, v10, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
    if-eqz v1, +0b6h
    move-object v1, v10
    check-cast v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
    move-object v2, v9
    check-cast v2, Lcom/bytedance/trae/conversation/chat/IMessageListener;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->setMessageLister(Lcom/bytedance/trae/conversation/chat/IMessageListener;)V
    iget-object v2, v9, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->setOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease(Lkotlin/jvm/functions/Function1;)V
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v2
    const/4 v3, 0
    const/4 v4, 0
    if-eqz v2, +074h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContent()Ljava/lang/Object;
    move-result-object v2
    instance-of v5, v2, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    if-eqz v5, +005h
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    goto +2h
    move-object v2, v4
    if-eqz v2, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +007h
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    goto +2h
    move v2, v3
    sget-object v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "[Node5] onBind: pos="
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v11, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", role="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getRole()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", planItemCount="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v6, ", status="
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v6, ", isInterjected="
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected()Z
    move-result v6
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v6, ", isLatest="
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-direct v9, v11, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->isLatestAgentTurn(I)Z
    move-result v6
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v6, "AgentDataFlow"
    invoke-virtual v5, v6, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v9, v11, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->isLatestAgentTurn(I)Z
    move-result v5
    invoke-direct v9, v11, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->isLatestAgentMsg(I)Z
    move-result v6
    iget-object v2, v9, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->upgradeReminderConversationId Ljava/lang/String;
    invoke-direct v9, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->upgradeReminderTargetPosition()Ljava/lang/Integer;
    move-result-object v7
    if-nez v7, +003h
    goto +8h
    invoke-virtual v7, Ljava/lang/Integer;->intValue()I
    move-result v7
    if-ne v11, v7, +003h
    const/4 v3, 1
    if-eqz v3, +004h
    move-object v7, v2
    goto +2h
    move-object v7, v4
    iget-object v8, v9, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onUpgradeReminderClick Lkotlin/jvm/functions/Function1;
    move-object v2, v0
    move v3, v5
    move v4, v6
    move-object v5, v7
    move-object v6, v8
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->bind(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z Z Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v1
    if-eqz v1, +00ch
    iget-object v10, v10, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;->itemView Landroid/view/View;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda4;
    invoke-direct v1, v9, v0, v11, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter; Lcom/bytedance/trae/im/model/ParsedChatMessage; I)V
    invoke-virtual v10, v1, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V
    return-void 
.end method

.method public onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int  java.util.List)void
    .registers 12
    # ins_size=4
    const-string v0, "holder"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "payloads"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, v10, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getItemViewType(I)I
    move-result v0
    const/4 v1, 2
    if-ne v0, v1, +003h
    return-void 
    move-object v0, v11
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    const/4 v1, 1
    xor-int/2addr v0, v1
    if-eqz v0, +0abh
    instance-of v0, v9, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
    if-eqz v0, +0a7h
    invoke-virtual v8, v10, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object v2, v9
    check-cast v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
    iget-object v9, v8, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    invoke-virtual v2, v9, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->setOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease(Lkotlin/jvm/functions/Function1;)V
    sget-object v9, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v9
    const/4 v0, 0
    const/4 v4, 0
    if-eqz v9, +066h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContent()Ljava/lang/Object;
    move-result-object v9
    instance-of v5, v9, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    if-eqz v5, +005h
    check-cast v9, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    goto +2h
    move-object v9, v4
    if-eqz v9, +00dh
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v9
    if-eqz v9, +007h
    invoke-interface v9, Ljava/util/List;->size()I
    move-result v9
    goto +2h
    move v9, v0
    sget-object v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "[Node5] onBindStreaming: pos="
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v10, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", payload="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-static v11, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v11
    invoke-virtual v6, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v6, ", planItemCount="
    invoke-virtual v11, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v11, ", status="
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v11, ", isInterjected="
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected()Z
    move-result v11
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    const-string v11, "AgentDataFlow"
    invoke-virtual v5, v11, v9, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v8, v10, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->isLatestAgentTurn(I)Z
    move-result v9
    invoke-direct v8, v10, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->isLatestAgentMsg(I)Z
    move-result v5
    iget-object v11, v8, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->upgradeReminderConversationId Ljava/lang/String;
    invoke-direct v8, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->upgradeReminderTargetPosition()Ljava/lang/Integer;
    move-result-object v6
    if-nez v6, +003h
    goto +8h
    invoke-virtual v6, Ljava/lang/Integer;->intValue()I
    move-result v6
    if-ne v10, v6, +003h
    goto +2h
    move v1, v0
    if-eqz v1, +004h
    move-object v6, v11
    goto +2h
    move-object v6, v4
    iget-object v7, v8, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onUpgradeReminderClick Lkotlin/jvm/functions/Function1;
    move v4, v9
    invoke-virtual/range v2 ... v7, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->bindStreaming(Lcom/bytedance/trae/im/model/ParsedChatMessage; Z Z Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    goto +4h
    invoke-super v8, v9, v10, v11, Landroidx/recyclerview/widget/ListAdapter;->onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder; I Ljava/util/List;)V
    return-void 
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 5
    # ins_size=3
    const-string v0, "parent"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v4, +068h
    const/4 v0, 2
    if-eq v4, v0, +033h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->Companion Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$Companion;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->conversation Lcom/bytedance/trae/im/service/Conversation;
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/conversation/chat/IMessageListener;
    invoke-virtual v4, v3, v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$Companion;->create(Landroid/view/ViewGroup; Lcom/bytedance/trae/im/service/Conversation; Lcom/bytedance/trae/conversation/chat/IMessageListener;)Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
    move-result-object v3
    iget-object v4, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onRetryClick Lkotlin/jvm/functions/Function1;
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->setOnRetryClick(Lkotlin/jvm/functions/Function1;)V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onFeedbackClick Lkotlin/jvm/functions/Function2;
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->setOnFeedbackClick(Lkotlin/jvm/functions/Function2;)V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onUseExpressPassClick Lkotlin/jvm/functions/Function1;
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->setOnUseExpressPassClick(Lkotlin/jvm/functions/Function1;)V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onCopyClick Lkotlin/jvm/functions/Function1;
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->setOnCopyClick(Lkotlin/jvm/functions/Function1;)V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onReportClick Lkotlin/jvm/functions/Function2;
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->setOnReportClick(Lkotlin/jvm/functions/Function2;)V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onContentChanged Lkotlin/jvm/functions/Function0;
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->setOnContentChanged(Lkotlin/jvm/functions/Function0;)V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->setOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    goto +3eh
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-virtual v4, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    iget v4, v4, Landroid/util/DisplayMetrics;->density F
    new-instance v0, Landroid/view/View;
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v3
    invoke-direct v0, v3, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v3, Landroid/view/ViewGroup$LayoutParams;
    const/16 v1, 8
    int-to-float v1, v1
    mul-float/2addr v4, v1
    float-to-int v4, v4
    const/4 v1, 1
    invoke-static v4, v1, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v4
    const/4 v1, -1
    invoke-direct v3, v1, v4, Landroid/view/ViewGroup$LayoutParams;-><init>(I I)V
    invoke-virtual v0, v3, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$onCreateViewHolder$1;
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$onCreateViewHolder$1;-><init>(Landroid/view/View;)V
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    goto +ch
    sget-object v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->Companion Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;
    invoke-virtual v4, v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$Companion;->create(Landroid/view/ViewGroup; Lcom/bytedance/trae/conversation/chat/IMessageListener;)Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    move-result-object v3
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v3
.end method

.method public onViewRecycled(androidx.recyclerview.widget.RecyclerView$ViewHolder)void
    .registers 3
    # ins_size=2
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, Landroidx/recyclerview/widget/ListAdapter;->onViewRecycled(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V
    instance-of v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
    if-eqz v0, +007h
    check-cast v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;->resetState()V
    return-void 
.end method

.method public final setConversation(com.bytedance.trae.im.service.Conversation)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->conversation Lcom/bytedance/trae/im/service/Conversation;
    return-void 
.end method

.method public final setOnContentChanged(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onContentChanged Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnCopyClick(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onCopyClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnFeedbackClick(kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onFeedbackClick Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final setOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnReportClick(kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onReportClick Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final setOnRetryClick(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onRetryClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnUpgradeReminderClick(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onUpgradeReminderClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnUseExpressPassClick(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->onUseExpressPassClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setUpgradeReminder(java.lang.String  boolean)void
    .registers 7
    # ins_size=3
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->upgradeReminderTargetPosition()Ljava/lang/Integer;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v5, +014h
    if-eqz v6, +00eh
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/2addr v6, v3
    if-eqz v6, +004h
    move v6, v3
    goto +2h
    move v6, v1
    if-eqz v6, +003h
    goto +2h
    move-object v5, v2
    iput-object v5, v4, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->upgradeReminderConversationId Ljava/lang/String;
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->upgradeReminderTargetPosition()Ljava/lang/Integer;
    move-result-object v5
    const/4 v6, 2
    new-array v6, v6, [Ljava/lang/Integer;
    aput-object v0, v6, v1
    aput-object v5, v6, v3
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOfNotNull([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    invoke-static v5, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +010h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/Number;
    invoke-virtual v6, Ljava/lang/Number;->intValue()I
    move-result v6
    invoke-virtual v4, v6, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->notifyItemChanged(I)V
    goto -13h
    return-void 
.end method

.method public final submitMessages(java.util.List  java.lang.Runnable)void
    .registers 5
    # ins_size=3
    const-string v0, "messages"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->upgradeReminderTargetMessageId()Ljava/lang/String;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda6;
    invoke-direct v1, v2, v0, v4, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter; Ljava/lang/String; Ljava/lang/Runnable;)V
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->enqueueSubmitList(Ljava/util/List; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
