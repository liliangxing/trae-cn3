# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig;
.field public final synthetic f$1:Lcom/bytedance/trae/multilanguage/I18nLanguage;
.field public final synthetic f$2:Landroid/content/Context;
.field public final synthetic f$3:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$4:Lkotlin/jvm/functions/Function2;


.method public synthetic constructor <init>(com.bytedance.trae.multilanguage.StarlingOnlineTextConfig  com.bytedance.trae.multilanguage.I18nLanguage  android.content.Context  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig;
    iput-object v2, v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/multilanguage/I18nLanguage;
    iput-object v3, v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda0;->f$2 Landroid/content/Context;
    iput-object v4, v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda0;->f$3 Lkotlin/jvm/functions/Function1;
    iput-object v5, v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda0;->f$4 Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final run()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig;
    iget-object v1, v5, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/multilanguage/I18nLanguage;
    iget-object v2, v5, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda0;->f$2 Landroid/content/Context;
    iget-object v3, v5, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda0;->f$3 Lkotlin/jvm/functions/Function1;
    iget-object v4, v5, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda0;->f$4 Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->$r8$lambda$Ov00CKzgmTXxXfVqUbOFRjLaxd4(Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig; Lcom/bytedance/trae/multilanguage/I18nLanguage; Landroid/content/Context; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method
