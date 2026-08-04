# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/share/ShareUtils$createChooserWithChosenComponentCallback$1;
.super Landroid/content/BroadcastReceiver;
.source "ShareUtils.kt"

.field final synthetic $onComponentChosen:Lkotlin/jvm/functions/Function1;
.field final synthetic $unregister:Lkotlin/jvm/functions/Function0;


.method constructor <init>(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/share/ShareUtils$createChooserWithChosenComponentCallback$1;->$unregister Lkotlin/jvm/functions/Function0;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/share/ShareUtils$createChooserWithChosenComponentCallback$1;->$onComponentChosen Lkotlin/jvm/functions/Function1;
    invoke-direct v0, Landroid/content/BroadcastReceiver;-><init>()V
    return-void 
.end method

.method public onReceive(android.content.Context  android.content.Intent)void
    .registers 3
    # ins_size=3
    if-eqz v2, +009h
    sget-object v1, Lcom/bytedance/trae/conversation/share/ShareUtils;->INSTANCE Lcom/bytedance/trae/conversation/share/ShareUtils;
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/share/ShareUtils;->access$chosenComponent(Lcom/bytedance/trae/conversation/share/ShareUtils; Landroid/content/Intent;)Landroid/content/ComponentName;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    iget-object v2, v0, Lcom/bytedance/trae/conversation/share/ShareUtils$createChooserWithChosenComponentCallback$1;->$unregister Lkotlin/jvm/functions/Function0;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    if-eqz v1, +007h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/share/ShareUtils$createChooserWithChosenComponentCallback$1;->$onComponentChosen Lkotlin/jvm/functions/Function1;
    invoke-interface v2, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
