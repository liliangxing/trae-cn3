# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda16;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/widget/AdapterView$OnItemClickListener;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$1:[Ljava/lang/String;
.field public final synthetic f$2:Landroid/widget/ListPopupWindow;


.method public synthetic constructor <init>(kotlin.jvm.functions.Function1  java.lang.String[]  android.widget.ListPopupWindow)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda16;->f$0 Lkotlin/jvm/functions/Function1;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda16;->f$1 [Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda16;->f$2 Landroid/widget/ListPopupWindow;
    return-void 
.end method

.method public final onItemClick(android.widget.AdapterView  android.view.View  int  long)void
    .registers 14
    # ins_size=6
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda16;->f$0 Lkotlin/jvm/functions/Function1;
    iget-object v1, v8, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda16;->f$1 [Ljava/lang/String;
    iget-object v2, v8, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda16;->f$2 Landroid/widget/ListPopupWindow;
    move-object v3, v9
    move-object v4, v10
    move v5, v11
    move-wide v6, v12
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;->$r8$lambda$0bHdS5DcbSe07UIsMnNTyhIhhhc(Lkotlin/jvm/functions/Function1; [Ljava/lang/String; Landroid/widget/ListPopupWindow; Landroid/widget/AdapterView; Landroid/view/View; I J)V
    return-void 
.end method
