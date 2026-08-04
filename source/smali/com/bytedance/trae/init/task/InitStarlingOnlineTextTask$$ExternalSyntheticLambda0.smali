# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Lcom/bytedance/trae/multilanguage/I18nLanguage;
.field public final synthetic f$2:Z
.field public final synthetic f$3:Ljava/lang/String;


.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.multilanguage.I18nLanguage  boolean  java.lang.String)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/multilanguage/I18nLanguage;
    iput-boolean v3, v0, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$$ExternalSyntheticLambda0;->f$2 Z
    iput-object v4, v0, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$$ExternalSyntheticLambda0;->f$3 Ljava/lang/String;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iget-object v1, v4, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/multilanguage/I18nLanguage;
    iget-boolean v2, v4, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$$ExternalSyntheticLambda0;->f$2 Z
    iget-object v3, v4, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$$ExternalSyntheticLambda0;->f$3 Ljava/lang/String;
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask;->$r8$lambda$MRPlf1tEhfU1j58QZOR1btZ_VYg(Ljava/lang/String; Lcom/bytedance/trae/multilanguage/I18nLanguage; Z Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
