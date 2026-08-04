# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "FileTreeAdapter.kt"

.field private final flatItems:Ljava/util/List;
.field private final onFileClick:Lkotlin/jvm/functions/Function1;
.field private rootNode:Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;


.method public static synthetic $r8$lambda$OH5VGWLhB4ZOZTkwKg6Bch9eHuc(com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode  com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->onBindViewHolder$lambda$2(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode; Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ndTbdGtsO3MjssVJmayh32PxW8w(com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode  com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->onBindViewHolder$lambda$1(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode; Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;-><init>(Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->onFileClick Lkotlin/jvm/functions/Function1;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->flatItems Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function1  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;-><init>(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private final buildTree(java.util.List)com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode
    .registers 23
    # ins_size=2
    new-instance v10, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    const-string v1, ""
    const/4 v2, 1
    const/4 v3, 0
    const/4 v4, -1
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 116
    const/4 v9, 0
    move-object v0, v10
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;-><init>(Ljava/lang/String; Z Ljava/lang/String; I Z Ljava/lang/String; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface/range v22, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +0b4h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto -12h
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    const-string v4, "/"
    filled-new-array v4, [Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Ljava/lang/Iterable;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    move v15, v5
    move-object v6, v10
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, -031h
    add-int/lit8 v7, v15, 1
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    move-object v12, v8
    check-cast v12, Ljava/lang/String;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->getLastIndex(Ljava/util/List;)I
    move-result v8
    const/4 v9, 1
    if-ne v15, v8, +004h
    move v8, v9
    goto +2h
    move v8, v5
    if-eqz v8, +020h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getChildren()Ljava/util/List;
    move-result-object v8
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    const/4 v13, 0
    invoke-virtual v1, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFileAction()Ljava/lang/String;
    move-result-object v14
    const/16 v16, 0
    const/16 v18, 0
    const/16 v19, 80
    const/16 v20, 0
    move-object v11, v9
    move-object/from16 v17, v2
    invoke-direct/range v11 ... v20, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;-><init>(Ljava/lang/String; Z Ljava/lang/String; I Z Ljava/lang/String; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v8, v9, Ljava/util/List;->add(Ljava/lang/Object;)Z
    move v15, v7
    goto -38h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getChildren()Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/lang/Iterable;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +01fh
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    move-object v13, v11
    check-cast v13, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getName()Ljava/lang/String;
    move-result-object v14
    invoke-static v14, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, +00ah
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->isFolder()Z
    move-result v13
    if-eqz v13, +004h
    move v13, v9
    goto +2h
    move v13, v5
    if-eqz v13, -020h
    goto +2h
    const/4 v11, 0
    check-cast v11, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    if-eqz v11, +005h
    move v15, v7
    move-object v6, v11
    goto -6dh
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    const/4 v13, 1
    const/4 v14, 0
    const/16 v16, 1
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 100
    const/16 v20, 0
    move-object v11, v8
    invoke-direct/range v11 ... v20, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;-><init>(Ljava/lang/String; Z Ljava/lang/String; I Z Ljava/lang/String; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getChildren()Ljava/util/List;
    move-result-object v6
    invoke-interface v6, v8, Ljava/util/List;->add(Ljava/lang/Object;)Z
    move v15, v7
    move-object v6, v8
    goto/16 -089h
    move-object/from16 v1, v21
    invoke-direct v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->hoistSingleChildFolders(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;)Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    move-result-object v0
    return-object v0
.end method

.method private final flattenNode(com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode  int)void
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->flatItems Ljava/util/List;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode; I)V
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->isFolder()Z
    move-result v0
    if-eqz v0, +022h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getExpanded()Z
    move-result v0
    if-eqz v0, +01ch
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getChildren()Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00eh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    add-int/lit8 v1, v4, 1
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->flattenNode(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode; I)V
    goto -11h
    return-void 
.end method

.method private final getFileActionIcon(java.lang.String)int
    .registers 3
    # ins_size=2
    if-eqz v2, +00fh
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v2, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    const/4 v2, 0
    if-eqz v2, +05ch
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v0
    sparse-switch v0, +000005ah
    goto +53h
    const-string v0, "edit"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +031h
    goto +4ah
    const-string v0, "new"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +040h
    goto +41h
    const-string v0, "add"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +037h
    goto +38h
    const-string/jumbo v0, update
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +015h
    goto +2eh
    const-string v0, "remove"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +018h
    goto +25h
    const-string v0, "modify"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +1ch
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_diff_edit I
    goto +1bh
    const-string v0, "delete"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +10h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_diff_delete I
    goto +fh
    const-string v0, "create"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +4h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_diff_add I
    goto +3h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_diff_add I
    return v2
    nop 
    sparse-switch-payload -509a5f04 -4f997a55 -3fb48746 -37b5077c -31ffc737 178a1 1a9a0 2f6e0a
.end method

.method private final hoistSingleChildFolders(com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode)com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode
    .registers 13
    # ins_size=2
    new-instance v10, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->isFolder()Z
    move-result v2
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getFileAction()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getIndentLevel()I
    move-result v4
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getExpanded()Z
    move-result v5
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getFilePath()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    const/16 v8, 64
    const/4 v9, 0
    move-object v0, v10
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;-><init>(Ljava/lang/String; Z Ljava/lang/String; I Z Ljava/lang/String; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getChildren()Ljava/util/List;
    move-result-object v12
    invoke-interface v12, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +014h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getChildren()Ljava/util/List;
    move-result-object v1
    invoke-direct v11, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->hoistSingleChildFolders(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;)Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    move-result-object v0
    invoke-interface v1, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -17h
    return-object v10
.end method

.method private static final onBindViewHolder$lambda$1(com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode  com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getExpanded()Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->setExpanded(Z)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->rebuildFlatList()V
    return-void 
.end method

.method private static final onBindViewHolder$lambda$2(com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode  com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getFilePath()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +009h
    iget-object v1, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->onFileClick Lkotlin/jvm/functions/Function1;
    if-eqz v1, +005h
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final rebuildFlatList()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->flatItems Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->clear()V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->rootNode Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getChildren()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00dh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    const/4 v2, 0
    invoke-direct v3, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->flattenNode(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode; I)V
    goto -10h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->notifyDataSetChanged()V
    return-void 
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->flatItems Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$ViewHolder  int)void
    .registers 6
    # ins_size=3
    const-string v0, "holder"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->flatItems Ljava/util/List;
    invoke-interface v0, v5, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->getNode()Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;->getTvFilename()Landroid/widget/TextView;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getName()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->isFolder()Z
    move-result v1
    if-eqz v1, +028h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;->getIvIcon()Landroid/widget/ImageView;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_explorer_folder I
    invoke-virtual v1, v2, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;->getIvIndicator()Landroid/widget/ImageView;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_explorer_down I
    invoke-virtual v1, v2, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;->getTvFilename()Landroid/widget/TextView;
    move-result-object v1
    const/high16 v2, 1095761920
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTextSize(F)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;->itemView Landroid/view/View;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$$ExternalSyntheticLambda0;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode; Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;)V
    invoke-virtual v1, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +2ch
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;->getIvIcon()Landroid/widget/ImageView;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->getFileAction()Ljava/lang/String;
    move-result-object v2
    invoke-direct v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->getFileActionIcon(Ljava/lang/String;)I
    move-result v2
    invoke-virtual v1, v2, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;->getIvIndicator()Landroid/widget/ImageView;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_explorer_dot I
    invoke-virtual v1, v2, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;->getTvFilename()Landroid/widget/TextView;
    move-result-object v1
    const/high16 v2, 1097859072
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTextSize(F)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;->itemView Landroid/view/View;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$$ExternalSyntheticLambda1;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode; Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;)V
    invoke-virtual v1, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->getIndentLevel()I
    move-result v0
    if-lez v0, +031h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;->getLlIndent()Landroid/widget/LinearLayout;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;->getLlIndent()Landroid/widget/LinearLayout;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->getIndentLevel()I
    move-result v5
    mul-int/lit8 v5, v5, 14
    int-to-float v5, v5
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v5, v1
    float-to-int v5, v5
    iput v5, v0, Landroid/view/ViewGroup$LayoutParams;->width I
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;->getLlIndent()Landroid/widget/LinearLayout;
    move-result-object v4
    invoke-virtual v4, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    goto +ah
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;->getLlIndent()Landroid/widget/LinearLayout;
    move-result-object v4
    const/16 v5, 8
    invoke-virtual v4, v5, Landroid/widget/LinearLayout;->setVisibility(I)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$ViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_file_tree I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$ViewHolder;-><init>(Landroid/view/View;)V
    return-object v4
.end method

.method public final setDiffFiles(java.util.List)void
    .registers 3
    # ins_size=2
    const-string v0, "diffFiles"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->buildTree(Ljava/util/List;)Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->rootNode Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->rebuildFlatList()V
    return-void 
.end method
