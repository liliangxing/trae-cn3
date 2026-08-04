# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "CodeChangedListActivity.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$Companion;
.field private static final EXTRA_CHANGED_FILE_DATA_JSON:Ljava/lang/String;
.field private static final EXTRA_CHAT_SESSION_ID:Ljava/lang/String;
.field private static final EXTRA_CLI_TYPE:Ljava/lang/String;
.field private static final EXTRA_CONVERSATION_ID:Ljava/lang/String;
.field private static final EXTRA_CREATED_TIME:Ljava/lang/String;
.field private static final EXTRA_MESSAGE_ID:Ljava/lang/String;
.field private static final EXTRA_TURN_ID:Ljava/lang/String;


.method public static synthetic $r8$lambda$0OzVgBxe9yxlkos1A6HeRUz98kA(com.bytedance.trae.conversation.products.CodeChangedListActivity  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  com.bytedance.trae.im.model.FileDiffInfo)kotlin.Unit
    .registers 9
    # ins_size=9
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->onCreate$lambda$1(Lcom/bytedance/trae/conversation/products/CodeChangedListActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/bytedance/trae/im/model/FileDiffInfo;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$IfZHzhLC4_LL-jZUsM2Hm4humyE(com.bytedance.trae.conversation.products.CodeChangedListActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->onCreate$lambda$0(Lcom/bytedance/trae/conversation/products/CodeChangedListActivity; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->Companion Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    return-void 
.end method

.method public static com_bytedance_trae_conversation_products_CodeChangedListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.products.CodeChangedListActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->com_bytedance_trae_conversation_products_CodeChangedListActivity__onStop$___twin___()V
    invoke-static Lcom/bytedance/sysoptimizer/EnterTransitionCrashOptimizer;->getContext()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, +013h
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewTreeObserver;->dispatchOnPreDraw()Z
    return-void 
    :try_start_0xb
.end method

.method private static final onCreate$lambda$0(com.bytedance.trae.conversation.products.CodeChangedListActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->finish()V
    return-void 
.end method

.method private static final onCreate$lambda$1(com.bytedance.trae.conversation.products.CodeChangedListActivity  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  com.bytedance.trae.im.model.FileDiffInfo)kotlin.Unit
    .registers 19
    # ins_size=9
    const-string v0, "file"
    move-object/from16 v2, v18
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v1, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-object v6, v14
    move-object v7, v15
    move-wide/from16 v8, v16
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->onFileItemClick(Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final onFileItemClick(com.bytedance.trae.im.model.FileDiffInfo  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long)void
    .registers 22
    # ins_size=9
    invoke-virtual v14, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    const/4 v1, 1
    if-eqz v1, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    move-object/from16 v9, v18
    invoke-virtual v1, v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactClick(Ljava/lang/String; Ljava/lang/String;)V
    goto +3h
    move-object/from16 v9, v18
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    move-object/from16 v7, v17
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +023h
    const/4 v1, 2
    const/4 v3, 0
    const-string v4, "/"
    invoke-static v0, v4, v2, v1, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00ah
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "files"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    goto +8h
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "files/"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v8, v0
    sget-object v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;
    move-object v4, v13
    check-cast v4, Landroid/content/Context;
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    move-object/from16 v9, v18
    move-object/from16 v10, v19
    move-wide/from16 v11, v20
    invoke-virtual/range v3 ... v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J)V
    return-void 
    :try_start_0x17
    :try_start_0x1b
.end method

.method public com_bytedance_trae_conversation_products_CodeChangedListActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 14
    # ins_size=2
    invoke-super v12, v13, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v13, Lcom/bytedance/trae/conversation/R$layout;->trae_activity_code_changed_list I
    invoke-virtual v12, v13, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->setContentView(I)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->getIntent()Landroid/content/Intent;
    move-result-object v13
    const-string v0, "extra_changed_file_data_json"
    invoke-virtual v13, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    const-string v0, ""
    if-nez v13, +003h
    move-object v13, v0
    invoke-virtual v12, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v2, "extra_chat_session_id"
    invoke-virtual v1, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v1
    invoke-virtual v12, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v2, "extra_turn_id"
    invoke-virtual v1, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v1
    invoke-virtual v12, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v2, "extra_cli_type"
    invoke-virtual v1, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v1
    invoke-virtual v12, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v2, "extra_message_id"
    invoke-virtual v1, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v7, v0
    goto +2h
    move-object v7, v1
    invoke-virtual v12, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v2, "extra_conversation_id"
    invoke-virtual v1, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v8, v0
    goto +2h
    move-object v8, v1
    invoke-virtual v12, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v1, "extra_created_time"
    const-wide/16 v2, 0
    invoke-virtual v0, v1, v2, v3, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v9
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v1, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/im/model/ChangedFileData;
    invoke-virtual v1, v13, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/im/model/ChangedFileData;
    goto +2h
    move-object v13, v0
    if-eqz v13, +006h
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v13
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_back I
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->findViewById(I)Landroid/view/View;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda0;
    invoke-direct v2, v12, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;)V
    invoke-virtual v1, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_code_files I
    const/4 v3, 1
    new-array v3, v3, [Ljava/lang/Object;
    const/4 v11, 0
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    aput-object v13, v3, v11
    invoke-virtual v12, v2, v3, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-virtual v1, v13, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v13, Lcom/bytedance/trae/conversation/R$id;->rv_code_changed_list I
    invoke-virtual v12, v13, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->findViewById(I)Landroid/view/View;
    move-result-object v13
    check-cast v13, Landroidx/recyclerview/widget/RecyclerView;
    new-instance v1, Landroidx/recyclerview/widget/LinearLayoutManager;
    move-object v2, v12
    check-cast v2, Landroid/content/Context;
    invoke-direct v1, v2, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v13, v1, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    new-instance v1, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;
    new-instance v11, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;
    move-object v2, v11
    move-object v3, v12
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/products/CodeChangedListActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J)V
    invoke-direct v1, v11, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;-><init>(Lkotlin/jvm/functions/Function1;)V
    move-object v2, v1
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v13, v2, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->submitList(Ljava/util/List;)V
    return-void 
    :try_start_0x6f
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->com_bytedance_trae_conversation_products_CodeChangedListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;)V
    return-void 
.end method
