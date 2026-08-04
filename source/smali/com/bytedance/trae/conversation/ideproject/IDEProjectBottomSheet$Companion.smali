# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion;
.super Ljava/lang/Object;
.source "IDEProjectBottomSheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic newInstance$default(com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet$Companion  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion;->newInstance(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    move-result-object v0
    return-object v0
.end method

.method public final newInstance(java.lang.String  java.lang.String)com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet
    .registers 6
    # ins_size=3
    const-string v0, "cliId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "arg_cli_id"
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v5, +007h
    const-string v4, "arg_project_id"
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
