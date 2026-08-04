# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/applog/IBDAccountCallback;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function0;


.method public synthetic constructor <init>(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda5;->f$0 Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final getOdinUserInfo()android.util.Pair
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda5;->f$0 Lkotlin/jvm/functions/Function0;
    invoke-static v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->$r8$lambda$tHbIqWIzx95W0zNRqDlTRfTWMz4(Lkotlin/jvm/functions/Function0;)Landroid/util/Pair;
    move-result-object v0
    return-object v0
.end method
