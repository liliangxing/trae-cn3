# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$Companion;
.super Ljava/lang/Object;
.source "SkillsBottomSheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic newInstance$default(com.bytedance.trae.conversation.skill.SkillsBottomSheet$Companion  java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.skill.SkillsBottomSheet
    .registers 20
    # ins_size=10
    and-int/lit8 v0, v18, 4
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v13
    and-int/lit8 v0, v18, 8
    if-eqz v0, +005h
    const/4 v0, 0
    move v6, v0
    goto +2h
    move v6, v14
    and-int/lit8 v0, v18, 16
    if-eqz v0, +004h
    move-object v7, v1
    goto +2h
    move-object v7, v15
    and-int/lit8 v0, v18, 32
    if-eqz v0, +004h
    move-object v8, v1
    goto +3h
    move-object/from16 v8, v16
    and-int/lit8 v0, v18, 64
    if-eqz v0, +004h
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v17
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    invoke-virtual/range v2 ... v9, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$Companion;->newInstance(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
    move-result-object v0
    return-object v0
.end method

.method public final newInstance(java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.skill.SkillsBottomSheet
    .registers 11
    # ins_size=8
    new-instance v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    if-eqz v4, +007h
    const-string v2, "arg_cli_id"
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v5, +007h
    const-string v4, "arg_workspace_folder"
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v6, +007h
    const-string v4, "arg_project_id"
    invoke-virtual v1, v4, v6, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "arg_is_ide_skills"
    invoke-virtual v1, v4, v7, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    if-eqz v8, +007h
    const-string v4, "arg_conversation_id"
    invoke-virtual v1, v4, v8, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v9, +007h
    const-string v4, "arg_config_name"
    invoke-virtual v1, v4, v9, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v10, +007h
    const-string v4, "arg_agent_type"
    invoke-virtual v1, v4, v10, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
