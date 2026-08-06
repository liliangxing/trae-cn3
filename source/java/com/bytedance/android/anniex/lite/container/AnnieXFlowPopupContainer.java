package com.bytedance.android.anniex.lite.container;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.builder.PopupBuilder;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.IPopupContainer;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.container.p025ui.AnnieXStatusAndNavImp;
import com.bytedance.android.anniex.container.popup.AnnieXLynxViewNestedScrollUtil;
import com.bytedance.android.anniex.container.popup.PopupCloseType;
import com.bytedance.android.anniex.container.popup.SheetBaseBehavior;
import com.bytedance.android.anniex.container.popup.SheetBaseDialog;
import com.bytedance.android.anniex.container.popup.SheetOutsideListener;
import com.bytedance.android.anniex.container.popup.SheetPullUpProcessor;
import com.bytedance.android.anniex.container.popup.SheetSlideProcessor;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.container.util.OrientationUtils;
import com.bytedance.android.anniex.container.util.ResUtil;
import com.bytedance.android.anniex.container.view.RadiusFrameLayout;
import com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.schema.AnnieXPopupModel;
import com.bytedance.android.anniex.schema.AnnieXStatusAndNavModel;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.schema.param.GravityParam;
import com.bytedance.ies.bullet.schema.param.GravityType;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.PopupType;
import com.bytedance.ies.bullet.service.sdk.param.PopupTypeParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import com.lynx.tasm.LynxView;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AnnieXFlowPopupContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ç\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b9*\u0001/\b\u0000\u0018\u0000 Â\u00012\u00020\u00012\u00020\u0002:\u0002Â\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\nH\u0002J\b\u0010<\u001a\u000209H\u0002J\b\u0010=\u001a\u000209H\u0002J\b\u0010>\u001a\u000209H\u0002J\b\u0010?\u001a\u000209H\u0002J\b\u0010@\u001a\u000209H\u0002J\b\u0010A\u001a\u000209H\u0002J\b\u0010B\u001a\u00020\u0007H\u0002J\b\u0010C\u001a\u000209H\u0002J\b\u0010D\u001a\u000209H\u0002J\b\u0010E\u001a\u000209H\u0002J\b\u0010F\u001a\u000209H\u0002J\b\u0010G\u001a\u00020\nH\u0002J\u000f\u0010H\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010IJ\b\u0010J\u001a\u00020KH\u0002J\b\u0010L\u001a\u00020\nH\u0002J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020\nH\u0002J\b\u0010P\u001a\u00020QH\u0016J\b\u0010R\u001a\u000209H\u0002J\b\u0010S\u001a\u000209H\u0016J\u0010\u0010T\u001a\u0002092\u0006\u0010U\u001a\u00020VH\u0002J\b\u0010W\u001a\u000209H\u0016J\u0018\u0010X\u001a\u0002092\u0006\u00104\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010Y\u001a\u000209J\b\u0010Z\u001a\u00020\u0007H\u0002J\b\u0010[\u001a\u00020\u0007H\u0002J\u0006\u0010\\\u001a\u00020\u0007J\b\u0010]\u001a\u00020\u0007H\u0002J\b\u0010^\u001a\u000209H\u0016J\u0012\u0010_\u001a\u0002092\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\"\u0010b\u001a\u0002092\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\u0010\u0010g\u001a\u0002092\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010h\u001a\u0002092\u0006\u0010i\u001a\u00020jH\u0016J\u0012\u0010k\u001a\u0002092\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0012\u0010l\u001a\u00020\u001c2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0012\u0010m\u001a\u0002092\b\u00104\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010n\u001a\u000209H\u0016J\b\u0010o\u001a\u000209H\u0016J\u000e\u0010p\u001a\u0002092\u0006\u0010q\u001a\u00020\nJ\u0016\u0010r\u001a\u0002092\u0006\u0010s\u001a\u00020\u00192\u0006\u0010t\u001a\u00020uJ\u0012\u0010v\u001a\u0002092\b\u0010w\u001a\u0004\u0018\u00010xH\u0016J\b\u0010y\u001a\u000209H\u0016J\b\u0010z\u001a\u000209H\u0016J\u0012\u0010{\u001a\u0002092\b\u0010w\u001a\u0004\u0018\u00010xH\u0016J\b\u0010|\u001a\u000209H\u0016J\b\u0010}\u001a\u000209H\u0016J\u001a\u0010~\u001a\u0002092\u0006\u0010\u007f\u001a\u00020\u00192\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0007\u0010\u0080\u0001\u001a\u000209J-\u0010\u0081\u0001\u001a\u0002092\u0007\u0010\u0082\u0001\u001a\u00020\n2\u0007\u0010\u0083\u0001\u001a\u00020\n2\u0007\u0010\u0084\u0001\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0016J\t\u0010\u0086\u0001\u001a\u000209H\u0002J\t\u0010\u0087\u0001\u001a\u000209H\u0002J\u0013\u0010\u0088\u0001\u001a\u0002092\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J\u0012\u0010\u008b\u0001\u001a\u0002092\u0007\u0010\u008c\u0001\u001a\u00020\nH\u0002J\u0018\u0010\u008d\u0001\u001a\u0002092\u0007\u0010\u008e\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\b\u008f\u0001J\u0011\u0010\u0090\u0001\u001a\u0002092\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0011\u0010\u0091\u0001\u001a\u0002092\u0006\u0010 \u001a\u00020\u0007H\u0016J\u0012\u0010\u0092\u0001\u001a\u0002092\u0007\u0010\u0093\u0001\u001a\u00020QH\u0016J\u0011\u0010\u0094\u0001\u001a\u0002092\u0006\u00101\u001a\u000202H\u0016J\u0012\u0010\u0095\u0001\u001a\u0002092\u0007\u0010\u0096\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010\u0097\u0001\u001a\u0002092\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0016J\u0010\u0010\u0099\u0001\u001a\u0002092\u0007\u0010\u009a\u0001\u001a\u00020uJ+\u0010\u0099\u0001\u001a\u0002092\u0007\u0010\u009b\u0001\u001a\u00020u2\u0007\u0010\u009c\u0001\u001a\u00020u2\u0007\u0010\u009d\u0001\u001a\u00020u2\u0007\u0010\u009e\u0001\u001a\u00020uJ\u0013\u0010\u009f\u0001\u001a\u0002092\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010 \u0001\u001a\u0002092\u0007\u0010¡\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010¢\u0001\u001a\u0002092\u0007\u0010£\u0001\u001a\u00020QH\u0016J\u0012\u0010¤\u0001\u001a\u0002092\u0007\u0010¥\u0001\u001a\u00020QH\u0016J\u0012\u0010¦\u0001\u001a\u0002092\u0007\u0010§\u0001\u001a\u00020QH\u0016J\u0012\u0010¨\u0001\u001a\u0002092\u0007\u0010©\u0001\u001a\u00020QH\u0016J\u0012\u0010ª\u0001\u001a\u0002092\u0007\u0010«\u0001\u001a\u00020\u0007H\u0016J\t\u0010¬\u0001\u001a\u000209H\u0002J\t\u0010\u00ad\u0001\u001a\u00020\u0007H\u0002J\t\u0010®\u0001\u001a\u00020\u0007H\u0002J\t\u0010¯\u0001\u001a\u00020\u0007H\u0002J\t\u0010°\u0001\u001a\u000209H\u0002J\t\u0010±\u0001\u001a\u000209H\u0016J\t\u0010²\u0001\u001a\u000209H\u0016J\t\u0010³\u0001\u001a\u00020\u0007H\u0002J\t\u0010´\u0001\u001a\u000209H\u0002J\u0012\u0010µ\u0001\u001a\u0002092\u0007\u0010¶\u0001\u001a\u00020\nH\u0002J$\u0010·\u0001\u001a\u0002092\u0007\u0010¸\u0001\u001a\u00020\n2\u0007\u0010¹\u0001\u001a\u00020\n2\u0007\u0010º\u0001\u001a\u00020\nH\u0002J\t\u0010»\u0001\u001a\u000209H\u0002J\u0015\u0010¼\u0001\u001a\u0002092\n\b\u0002\u0010i\u001a\u0004\u0018\u00010jH\u0002J\"\u0010¼\u0001\u001a\u0002092\u0006\u0010]\u001a\u00020\u00072\u0007\u0010½\u0001\u001a\u00020\n2\u0006\u0010;\u001a\u00020\nH\u0002J\t\u0010¾\u0001\u001a\u000209H\u0002J\t\u0010¿\u0001\u001a\u000209H\u0002J%\u0010À\u0001\u001a\u0002092\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0007\u0010¸\u0001\u001a\u00020\n2\u0007\u0010º\u0001\u001a\u00020\nH\u0002J.\u0010Á\u0001\u001a\u0002092\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0007\u0010¸\u0001\u001a\u00020\n2\u0007\u0010¹\u0001\u001a\u00020\n2\u0007\u0010º\u0001\u001a\u00020\nH\u0002R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0004\n\u0002\u00100R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ã\u0001"}, d2 = {"Lcom/bytedance/android/anniex/lite/container/AnnieXFlowPopupContainer;", "Lcom/bytedance/android/anniex/lite/container/AnnieXLiteContainer;", "Lcom/bytedance/android/anniex/base/container/IPopupContainer;", "builder", "Lcom/bytedance/android/anniex/base/builder/PopupBuilder;", "(Lcom/bytedance/android/anniex/base/builder/PopupBuilder;)V", "_entranceFlag", "", "Ljava/lang/Boolean;", "adjustBeforeHeight", "", "annieXContainer", "Landroid/widget/FrameLayout;", "annieXPopupModel", "Lcom/bytedance/android/anniex/schema/AnnieXPopupModel;", "getAnnieXPopupModel", "()Lcom/bytedance/android/anniex/schema/AnnieXPopupModel;", "annieXPopupModel$delegate", "Lkotlin/Lazy;", "annieXStatusAndNavModel", "Lcom/bytedance/android/anniex/schema/AnnieXStatusAndNavModel;", "getAnnieXStatusAndNavModel", "()Lcom/bytedance/android/anniex/schema/AnnieXStatusAndNavModel;", "annieXStatusAndNavModel$delegate", "barCloseView", "Landroid/view/View;", "defaultStatusBarColor", "dialog", "Landroid/app/Dialog;", "dialogFragment", "Landroidx/fragment/app/DialogFragment;", "enableToFull", "enableToHalf", "engineScrollView", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "indicatorView", "initLayoutParamsHeight", "Ljava/lang/Integer;", "isFold", "isPad", "mWebScrollY", "navigationBarHeight", "originalFlags", "originalStatusBarColor", "originalSystemUiVisibility", "popLifecycleListener", "com/bytedance/android/anniex/lite/container/AnnieXFlowPopupContainer$popLifecycleListener$1", "Lcom/bytedance/android/anniex/lite/container/AnnieXFlowPopupContainer$popLifecycleListener$1;", "popupComponent", "Lcom/bytedance/android/anniex/base/container/IPopupContainer$PopupComponent;", "pullUpState", "rootView", "statusBarAndNavImp", "Lcom/bytedance/android/anniex/container/ui/AnnieXStatusAndNavImp;", "upFullStatusBarBgColor", "adaptVoSizeParamOnPadOrFoldScreen", "", "adjustLandscapeParam", "screenHeight", "bindCloseEvent", "bindContainerClickEvent", "bindEvent", "bindPullUpProcessor", "bindSlideProcessor", "bindStateCallback", "canDisableDragDown", "checkIsValidDialog", "configDialogWindow", "configPullUp", "configViewByPopHybridParams", "getConfigOrientation", "getPopupInitHeight", "()Ljava/lang/Integer;", "getRealDisplayMetrics", "Landroid/util/DisplayMetrics;", "getRealNavigationBarHeight", "getScenes", "Lcom/bytedance/ies/bullet/core/common/Scenes;", "getScreenWidth", "getViewType", "", "hideMask", "hideNavBar", "hideNavigation", "window", "Landroid/view/Window;", "hidePopupClose", "initIndicatorNew", "initTitleBar", "isEngineViewReachTop", "isFullScreen", "isKitViewScrollReachTop", "isLandscape", "observerKeyboardStatusChange", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", Constants.KEY_DATA, "Landroid/content/Intent;", "onAttach", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onCreateDialog", "onCreateView", "onDestroy", "onDetach", "onDialogPullUpStateChange", StrategyConstants.STATE, "onDialogSlide", "bottomSheet", "slideOffset", "", "onDismiss", "dialogInterface", "Landroid/content/DialogInterface;", "onPause", "onResume", "onShow", "onStart", "onStop", "onViewCreated", "view", "onWebPageFinish", "onWebScrollChanged", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "recordOriginalStatusBar", "resetStatusBar", "sendCloseEvent", "popupCloseType", "Lcom/bytedance/android/anniex/container/popup/PopupCloseType;", "sendHalfFullStatus", "pullUpStatusFull", "setCancelable", "cancelable", "setCancelable$anniex_release", "setEnableToFull", "setEnableToHalf", "setNavBarColor", "navBarColor", "setPopupComponent", "setPullDownClose", "pullDownClose", "setPullDownHeight", "pullDownHeight", "setRadius", "radius", "topLeft", "topRight", "bottomRight", "bottomLeft", "setSheetStateCallback", "setShowTopClose", "showTopClose", "setStatusBarColor", "statusBarColor", "setStatusFontMode", "statusFontMode", "setTitle", "title", "setTitleColor", "titleColor", "setUserVisibleHint", "isVisibleToUser", "setWindowAttr", "shouldHideMask", "shouldLoadBackground", "shouldShowMask", "showMask", "showNavBar", "showPopupClose", "transStatusBar", "tryClearPopupAnim", "updateAnnieXContainerViewHeight", "height", "updateContainerSize", "widthInDp", "heightInDp", "gravity", "updateVoParamsByCustom", "updateVoSizeParam", "screenWidth", "updateVoSizeParamOnFoldScreen", "updateVoSizeParamOnPad", "updateWindowAttr", "updateWindowSize", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXFlowPopupContainer extends AnnieXLiteContainer implements IPopupContainer {
    public static final int BOTTOM_CLOSE_EXTRA_HEIGHT = 48;
    public static final int DEFAULT_HEIGHT_DP = 450;
    public static final int DEFAULT_HEIGHT_DP_HD = 700;
    public static final int DEFAULT_WIDTH_DP = 300;
    public static final int DEFAULT_WIDTH_DP_HD = 375;
    public static final int FULL_STATUS_DEFAULT_COLOR = 1580077;
    public static final int PULL_UP_HEIGHT_OFFSET = 2;
    public static final int PULL_UP_STATUS_CLOSE = 3;
    public static final int PULL_UP_STATUS_FULL = 2;
    public static final int PULL_UP_STATUS_HALF = 1;
    public static final String TAG = "AnnieXFlowPopupContainer";
    private Boolean _entranceFlag;
    private int adjustBeforeHeight;
    private FrameLayout annieXContainer;

    /* renamed from: annieXPopupModel$delegate, reason: from kotlin metadata */
    private final Lazy annieXPopupModel;

    /* renamed from: annieXStatusAndNavModel$delegate, reason: from kotlin metadata */
    private final Lazy annieXStatusAndNavModel;
    private View barCloseView;
    private int defaultStatusBarColor;
    private Dialog dialog;
    private DialogFragment dialogFragment;
    private boolean enableToFull;
    private boolean enableToHalf;
    private View engineScrollView;
    private final FragmentActivity fragmentActivity;
    private View indicatorView;
    private Integer initLayoutParamsHeight;
    private final boolean isFold;
    private final boolean isPad;
    private int mWebScrollY;
    private int navigationBarHeight;
    private int originalFlags;
    private int originalStatusBarColor;
    private int originalSystemUiVisibility;
    private AnnieXFlowPopupContainer$popLifecycleListener$1 popLifecycleListener;
    private IPopupContainer.PopupComponent popupComponent;
    private int pullUpState;
    private View rootView;
    private AnnieXStatusAndNavImp statusBarAndNavImp;
    private int upFullStatusBarBgColor;

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public String getViewType() {
        return AnnieX.CONTAINER_VIEW_TYPE_POPUP;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void observerKeyboardStatusChange() {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onActivityCreated(Bundle savedInstanceState) {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onDestroy() {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onDetach() {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onPause() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$popLifecycleListener$1] */
    public AnnieXFlowPopupContainer(PopupBuilder popupBuilder) {
        super(popupBuilder);
        Intrinsics.checkNotNullParameter(popupBuilder, "builder");
        this.fragmentActivity = popupBuilder.getFragmentActivity$anniex_release();
        this.isPad = AnnieXRuntime.INSTANCE.getDeviceDepend().isPad();
        this.isFold = AnnieXRuntime.INSTANCE.getDeviceDepend().isFold();
        this.defaultStatusBarColor = ViewCompat.MEASURED_STATE_MASK;
        this.enableToFull = true;
        this.enableToHalf = true;
        this.annieXPopupModel = LazyKt.lazy(new Function0<AnnieXPopupModel>() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$annieXPopupModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AnnieXPopupModel m3343invoke() {
                ISchemaModel generateSchemaModel = SchemaService.Companion.getInstance().generateSchemaModel(AnnieXFlowPopupContainer.this.getAnnieXContext().getSchemaModelUnion().getSchemaData(), AnnieXPopupModel.class);
                AnnieXFlowPopupContainer annieXFlowPopupContainer = AnnieXFlowPopupContainer.this;
                AnnieXPopupModel annieXPopupModel = (AnnieXPopupModel) generateSchemaModel;
                if (annieXPopupModel != null) {
                    annieXPopupModel.setModelContext(annieXFlowPopupContainer.getContext());
                }
                return annieXPopupModel;
            }
        });
        this.annieXStatusAndNavModel = LazyKt.lazy(new Function0<AnnieXStatusAndNavModel>() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$annieXStatusAndNavModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AnnieXStatusAndNavModel m3344invoke() {
                return (AnnieXStatusAndNavModel) SchemaService.Companion.getInstance().generateSchemaModel(AnnieXFlowPopupContainer.this.getAnnieXContext().getSchemaModelUnion().getSchemaData(), AnnieXStatusAndNavModel.class);
            }
        });
        this.adjustBeforeHeight = 400;
        this.navigationBarHeight = -1;
        this.pullUpState = -1;
        this.popLifecycleListener = new AbsAnnieXLifecycle() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$popLifecycleListener$1
            @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
            public void onLoadSuccess(String schema, IContainer container) {
                Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
                Intrinsics.checkNotNullParameter(container, "container");
                super.onLoadSuccess(schema, container);
                AnnieXFlowPopupContainer.this.onWebPageFinish();
            }
        };
        this.originalSystemUiVisibility = 1024;
        this.originalFlags = 2048;
        this.originalStatusBarColor = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnnieXPopupModel getAnnieXPopupModel() {
        return (AnnieXPopupModel) this.annieXPopupModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnnieXStatusAndNavModel getAnnieXStatusAndNavModel() {
        return (AnnieXStatusAndNavModel) this.annieXStatusAndNavModel.getValue();
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void setPopupComponent(IPopupContainer.PopupComponent popupComponent) {
        Intrinsics.checkNotNullParameter(popupComponent, "popupComponent");
        this.popupComponent = popupComponent;
        super.setUiComponent(popupComponent);
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void onAttach(DialogFragment dialogFragment) {
        Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
        this.dialogFragment = dialogFragment;
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void onCreate(Bundle savedInstanceState) {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "onCreate: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        getLifecycleDispatcher().addLifecycle(this.popLifecycleListener);
        setContainerVisible(true);
        DialogFragment dialogFragment = null;
        if (isLandscape()) {
            DialogFragment dialogFragment2 = this.dialogFragment;
            if (dialogFragment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
            } else {
                dialogFragment = dialogFragment2;
            }
            dialogFragment.setStyle(1, C0840R.style.annie_x_no_floating_dialog);
            return;
        }
        DialogFragment dialogFragment3 = this.dialogFragment;
        if (dialogFragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
        } else {
            dialogFragment = dialogFragment3;
        }
        dialogFragment.setStyle(1, C0840R.style.annie_x_floating_dialog);
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void hideNavBar() {
        AnnieXStatusAndNavImp annieXStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXStatusAndNavImp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            annieXStatusAndNavImp = null;
        }
        annieXStatusAndNavImp.hideNavBar();
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void showNavBar() {
        AnnieXStatusAndNavImp annieXStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXStatusAndNavImp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            annieXStatusAndNavImp = null;
        }
        annieXStatusAndNavImp.showNavBar();
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void setNavBarColor(String navBarColor) {
        Intrinsics.checkNotNullParameter(navBarColor, "navBarColor");
        AnnieXStatusAndNavImp annieXStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXStatusAndNavImp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            annieXStatusAndNavImp = null;
        }
        annieXStatusAndNavImp.setNavBarColor(navBarColor);
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        AnnieXStatusAndNavImp annieXStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXStatusAndNavImp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            annieXStatusAndNavImp = null;
        }
        annieXStatusAndNavImp.setTitle(title);
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void setTitleColor(String titleColor) {
        Intrinsics.checkNotNullParameter(titleColor, "titleColor");
        AnnieXStatusAndNavImp annieXStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXStatusAndNavImp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            annieXStatusAndNavImp = null;
        }
        annieXStatusAndNavImp.setTitleColor(titleColor);
    }

    @Override // com.bytedance.android.anniex.base.container.IStatusBarHost
    public void setStatusBarColor(String statusBarColor) {
        Intrinsics.checkNotNullParameter(statusBarColor, "statusBarColor");
        AnnieXStatusAndNavImp annieXStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXStatusAndNavImp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            annieXStatusAndNavImp = null;
        }
        annieXStatusAndNavImp.setStatusBarColor(statusBarColor);
    }

    @Override // com.bytedance.android.anniex.base.container.IStatusBarHost
    public void setStatusFontMode(String statusFontMode) {
        Intrinsics.checkNotNullParameter(statusFontMode, "statusFontMode");
        AnnieXStatusAndNavImp annieXStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXStatusAndNavImp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            annieXStatusAndNavImp = null;
        }
        annieXStatusAndNavImp.setStatusFontMode(statusFontMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog;
        BooleanParam abandonCoordinate;
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (((annieXPopupModel == null || (abandonCoordinate = annieXPopupModel.getAbandonCoordinate()) == null) ? false : Intrinsics.areEqual(abandonCoordinate.getValue(), true)) && !this.isPad && !this.isFold) {
            IPopupContainer.PopupComponent popupComponent = this.popupComponent;
            dialog = null;
            if (popupComponent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
                popupComponent = null;
            }
            Dialog onCreateDialog = popupComponent.onCreateDialog(savedInstanceState);
            if (onCreateDialog != null) {
                Window window = onCreateDialog.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                    window.addFlags(256);
                }
                dialog = onCreateDialog;
            }
        } else {
            SheetBaseDialog sheetBaseDialog = new SheetBaseDialog(getContext(), isLandscape(), this.isPad, transStatusBar(), false, 0, 48, null);
            Window window2 = sheetBaseDialog.getWindow();
            if (window2 != null) {
                window2.setBackgroundDrawable(new ColorDrawable(0));
                window2.addFlags(256);
            }
            dialog = (Dialog) sheetBaseDialog;
        }
        this.dialog = dialog;
        AnnieXPopupModel annieXPopupModel2 = getAnnieXPopupModel();
        setCancelable$anniex_release(annieXPopupModel2 != null ? annieXPopupModel2.getCanceledOnTouchOutside() : true);
        Dialog dialog2 = this.dialog;
        Intrinsics.checkNotNull(dialog2, "null cannot be cast to non-null type android.app.Dialog");
        return dialog2;
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onCreateView(View rootView) {
        this.rootView = rootView;
        AnnieXStatusAndNavImp annieXStatusAndNavImp = null;
        FrameLayout frameLayout = rootView != null ? (FrameLayout) rootView.findViewById(C0840R.id.annie_x_container_view) : null;
        if (frameLayout == null) {
            frameLayout = new FrameLayout((Context) this.fragmentActivity);
        }
        setParentViewGroup(frameLayout);
        recordOriginalStatusBar();
        View view = this.rootView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        this.statusBarAndNavImp = new AnnieXStatusAndNavImp((Activity) this.fragmentActivity, this, (ViewGroup) view);
        initUi();
        AnnieXStatusAndNavModel annieXStatusAndNavModel = getAnnieXStatusAndNavModel();
        if (annieXStatusAndNavModel != null) {
            AnnieXStatusAndNavImp annieXStatusAndNavImp2 = this.statusBarAndNavImp;
            if (annieXStatusAndNavImp2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
                annieXStatusAndNavImp2 = null;
            }
            Dialog dialog = this.dialog;
            annieXStatusAndNavImp2.initKeyboard(dialog != null ? dialog.getWindow() : null, annieXStatusAndNavModel);
            AnnieXStatusAndNavImp annieXStatusAndNavImp3 = this.statusBarAndNavImp;
            if (annieXStatusAndNavImp3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            } else {
                annieXStatusAndNavImp = annieXStatusAndNavImp3;
            }
            annieXStatusAndNavImp.initCommonTitleBar(annieXStatusAndNavModel);
        }
        initTitleBar();
        checkIsValidDialog();
        updateVoParamsByCustom();
        configPullUp();
        setWindowAttr();
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===onCreateView: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(view, "view");
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===onViewCreated: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        bindEvent();
        configViewByPopHybridParams();
        configDialogWindow();
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel != null) {
            initIndicatorNew(view, annieXPopupModel);
        }
        FrameLayout frameLayout = this.annieXContainer;
        this.initLayoutParamsHeight = (frameLayout == null || (layoutParams = frameLayout.getLayoutParams()) == null) ? null : Integer.valueOf(layoutParams.height);
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onStop() {
        enterBackground();
        onVisibleChange(false, true);
    }

    private final void tryClearPopupAnim() {
        AnnieXPopupModel annieXPopupModel;
        Dialog dialog = this.dialog;
        if (dialog == null) {
            return;
        }
        Window window = dialog != null ? dialog.getWindow() : null;
        if (Intrinsics.areEqual(this._entranceFlag, true) && window != null && (annieXPopupModel = getAnnieXPopupModel()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            BooleanParam openAnimate = annieXPopupModel.getOpenAnimate();
            if (openAnimate != null ? Intrinsics.areEqual(openAnimate.getValue(), true) : false) {
                if (getConfigOrientation() == 2) {
                    attributes.windowAnimations = C0840R.style.annie_x_popup_no_enter_anim_horizontal;
                } else {
                    PopupTypeParam popupType = annieXPopupModel.getPopupType();
                    if ((popupType != null ? (PopupType) popupType.getValue() : null) == PopupType.RIGHT) {
                        attributes.windowAnimations = C0840R.style.annie_x_popup_no_enter_anim_horizontal;
                    } else {
                        attributes.windowAnimations = C0840R.style.annie_x_popup_no_enter_anim_vertical;
                    }
                }
            }
            window.setAttributes(attributes);
        }
        if (this._entranceFlag == null) {
            this._entranceFlag = true;
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onStart() {
        try {
            Result.Companion companion = Result.Companion;
            AnnieXFlowPopupContainer annieXFlowPopupContainer = this;
            tryClearPopupAnim();
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onResume() {
        enterForeground();
        if (AnnieXContainerManager.isTopContainer(this)) {
            onVisibleChange(true, true);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser && getContainerVisible()) {
            setContainerVisible(false);
        }
        IContainer.DefaultImpls.onVisibleChange$default(this, isVisibleToUser, null, 2, null);
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onConfigurationChanged(Configuration newConfig) {
        GravityType gravityType;
        Integer num;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===onConfigurationChanged: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        updateVoSizeParamOnPad();
        if (this.isFold) {
            ISchemaData schemaData = getSchemaData();
            int i = 0;
            if (schemaData != null && (num = (Integer) new IntegerParam(schemaData, "is_already_adaptation_ui", 0).getValue()) != null) {
                i = num.intValue();
            }
            ISchemaData schemaData2 = getSchemaData();
            if (schemaData2 == null || (gravityType = (GravityType) new GravityParam(schemaData2, "gravity", GravityType.CENTER).getValue()) == null) {
                gravityType = GravityType.CENTER;
            }
            AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
            if (annieXPopupModel != null) {
                if (i == 0) {
                    annieXPopupModel.setWidth(newConfig.screenWidthDp);
                } else {
                    annieXPopupModel.setWidth(300);
                }
                annieXPopupModel.setHeight(this.adjustBeforeHeight);
                annieXPopupModel.setGravity(gravityType.getClientValue());
            }
            updateVoSizeParam(newConfig);
            updateVoSizeParamOnFoldScreen();
        }
        AnnieXPopupModel annieXPopupModel2 = getAnnieXPopupModel();
        if (annieXPopupModel2 != null) {
            updateWindowSize(this.dialog, annieXPopupModel2.getWidth(), annieXPopupModel2.getHeight(), annieXPopupModel2.getGravity());
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void hidePopupClose() {
        ImageView imageView;
        View view = this.rootView;
        if (view == null || (imageView = (ImageView) view.findViewById(C0840R.id.annie_x_dialog_btn_close)) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void showPopupClose() {
        ImageView imageView;
        View view = this.rootView;
        if (view == null || (imageView = (ImageView) view.findViewById(C0840R.id.annie_x_dialog_btn_close)) == null) {
            return;
        }
        imageView.setVisibility(0);
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void setEnableToFull(boolean enableToFull) {
        this.enableToFull = enableToFull;
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void setEnableToHalf(boolean enableToHalf) {
        this.enableToHalf = enableToHalf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        if (r2.getShowBack() == true) goto L17;
     */
    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setShowTopClose(boolean showTopClose) {
        boolean z;
        View view = this.rootView;
        ImageView imageView = view != null ? (ImageView) view.findViewById(C0840R.id.annie_x_dialog_btn_close) : null;
        View view2 = this.rootView;
        ImageView imageView2 = view2 != null ? (ImageView) view2.findViewById(C0840R.id.annie_x_activity_back) : null;
        if (canGoBack()) {
            AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
            if (annieXPopupModel != null) {
                z = true;
            }
            z = false;
            if (z) {
                if (imageView2 == null) {
                    return;
                }
                imageView2.setVisibility(showTopClose ? 0 : 8);
                return;
            }
        }
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(showTopClose ? 0 : 8);
    }

    private final void bindEvent() {
        bindCloseEvent();
        bindContainerClickEvent();
        bindPullUpProcessor();
        bindSlideProcessor();
        bindStateCallback();
    }

    private final void bindCloseEvent() {
        Object obj = this.dialog;
        SheetBaseDialog sheetBaseDialog = obj instanceof SheetBaseDialog ? (SheetBaseDialog) obj : null;
        if (sheetBaseDialog != null) {
            sheetBaseDialog.setLiveBottomSheetOutsideListener(new SheetOutsideListener() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$bindCloseEvent$1
                @Override // com.bytedance.android.anniex.container.popup.SheetOutsideListener
                public void onOutsideClick(boolean canDismiss) {
                }

                @Override // com.bytedance.android.anniex.container.popup.SheetOutsideListener
                public void onOutsideClickWithCloseType(boolean canDismiss, PopupCloseType popupCloseType) {
                    Intrinsics.checkNotNullParameter(popupCloseType, "popupCloseType");
                    if (canDismiss) {
                        return;
                    }
                    AnnieXFlowPopupContainer.this.sendEvent(new IEvent() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$bindCloseEvent$1$onOutsideClickWithCloseType$1
                        private final String name = "H5_tapWebMaskView";
                        private final Object params;

                        public String getName() {
                            return this.name;
                        }

                        public Object getParams() {
                            return this.params;
                        }
                    });
                    AnnieXFlowPopupContainer.this.sendCloseEvent(popupCloseType);
                }
            });
        }
    }

    private final void bindContainerClickEvent() {
        View view = this.rootView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$bindContainerClickEvent$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DialogFragment dialogFragment;
                    Dialog dialog;
                    dialogFragment = AnnieXFlowPopupContainer.this.dialogFragment;
                    if (dialogFragment == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
                        dialogFragment = null;
                    }
                    if (dialogFragment.isCancelable()) {
                        dialog = AnnieXFlowPopupContainer.this.dialog;
                        if (dialog != null) {
                            dialog.cancel();
                            return;
                        }
                        return;
                    }
                    AnnieXFlowPopupContainer.this.sendEvent(new IEvent() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$bindContainerClickEvent$1.1
                        private final String name = "H5_tapWebMaskView";
                        private final Object params;

                        public String getName() {
                            return this.name;
                        }

                        public Object getParams() {
                            return this.params;
                        }
                    });
                    AnnieXFlowPopupContainer.this.sendCloseEvent(PopupCloseType.CLICK_MASK);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendCloseEvent(final PopupCloseType popupCloseType) {
        sendEvent(new IEvent(popupCloseType) { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$sendCloseEvent$1
            private final String name = "containerShouldClose";
            private final Object params;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, PopupCloseType.getTag$default(popupCloseType, false, 1, null));
                this.params = jSONObject;
            }

            public String getName() {
                return this.name;
            }

            public Object getParams() {
                return this.params;
            }
        });
    }

    private final boolean shouldLoadBackground() {
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel != null) {
            return annieXPopupModel.getWidth() == 0 && annieXPopupModel.getHeight() == 0;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x012e, code lost:
    
        if (r1.isFullScreen() != false) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configDialogWindow() {
        int width;
        Dialog dialog = this.dialog;
        IPopupContainer.PopupComponent popupComponent = null;
        Window window = dialog != null ? dialog.getWindow() : null;
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel != null) {
            updateWindowSize(this.dialog, annieXPopupModel.getWidth(), annieXPopupModel.getHeight(), annieXPopupModel.getGravity());
            if (annieXPopupModel.getRadius() > 0) {
                setRadius(ResUtil.INSTANCE.dp2Px(annieXPopupModel.getRadius()));
            } else {
                setRadius(ResUtil.INSTANCE.dp2Px(annieXPopupModel.getRadiusTopLeft()), ResUtil.INSTANCE.dp2Px(annieXPopupModel.getRadiusTopRight()), ResUtil.INSTANCE.dp2Px(annieXPopupModel.getRadiusBottomRight()), ResUtil.INSTANCE.dp2Px(annieXPopupModel.getRadiusBottomLeft()));
            }
            if (window != null) {
                if (!annieXPopupModel.getWindowFloating()) {
                    window.setSoftInputMode(48);
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -1;
                BooleanParam openAnimate = annieXPopupModel.getOpenAnimate();
                if (openAnimate != null ? Intrinsics.areEqual(openAnimate.getValue(), true) : false) {
                    if (getConfigOrientation() == 2) {
                        attributes.windowAnimations = C0840R.style.annie_x_popup_anim_horizontal;
                    } else {
                        PopupTypeParam popupType = annieXPopupModel.getPopupType();
                        if ((popupType != null ? (PopupType) popupType.getValue() : null) == PopupType.RIGHT) {
                            attributes.windowAnimations = C0840R.style.annie_x_popup_anim_horizontal;
                        } else {
                            attributes.windowAnimations = C0840R.style.annie_x_popup_anim_vertical;
                        }
                    }
                } else {
                    attributes.windowAnimations = C0840R.style.annie_x_popup_no_anim;
                }
                try {
                    Result.Companion companion = Result.Companion;
                    window.setAttributes(attributes);
                    Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (shouldShowMask()) {
                    showMask();
                } else if (shouldHideMask()) {
                    hideMask();
                }
                try {
                    window.setBackgroundDrawable(new ColorDrawable(annieXPopupModel.getMaskBgColor()));
                } catch (Exception e) {
                    HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "maskBgColor: " + e.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
                }
                if (this.isPad) {
                    IPopupContainer.PopupComponent popupComponent2 = this.popupComponent;
                    if (popupComponent2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
                    } else {
                        popupComponent = popupComponent2;
                    }
                }
                if (!this.isFold) {
                    if (annieXPopupModel.getWidth() > 0) {
                        width = ResUtil.INSTANCE.dp2Px(annieXPopupModel.getWidth() + annieXPopupModel.getMarginRight());
                    } else {
                        width = annieXPopupModel.getWidth();
                    }
                    window.setLayout(width, -1);
                    if (!isFullScreen()) {
                        window.setFlags(1024, 1024);
                    }
                }
                if (shouldLoadBackground()) {
                    window.addFlags(32);
                    window.getAttributes().dimAmount = 0.0f;
                }
                if (annieXPopupModel.getUpFullScreen()) {
                    setSheetStateCallback(this.dialog);
                }
            }
        }
    }

    private final boolean shouldHideMask() {
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel == null) {
            return true;
        }
        BooleanParam showDim = annieXPopupModel.getShowDim();
        if (!(showDim != null ? Intrinsics.areEqual(showDim.getValue(), true) : false)) {
            BooleanParam showMask = annieXPopupModel.getShowMask();
            if (!(showMask != null ? Intrinsics.areEqual(showMask.getValue(), true) : false)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldShowMask() {
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        return annieXPopupModel != null && annieXPopupModel.getMaskAlpha() > ((float) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMask() {
        Window window;
        Window window2;
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel != null) {
            Dialog dialog = this.dialog;
            if (dialog != null && (window2 = dialog.getWindow()) != null) {
                window2.addFlags(2);
            }
            Dialog dialog2 = this.dialog;
            if (dialog2 == null || (window = dialog2.getWindow()) == null) {
                return;
            }
            window.setDimAmount(annieXPopupModel.getMaskAlpha());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideMask() {
        Window window;
        Window window2;
        Dialog dialog = this.dialog;
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.clearFlags(2);
        }
        Dialog dialog2 = this.dialog;
        if (dialog2 == null || (window = dialog2.getWindow()) == null) {
            return;
        }
        window.setDimAmount(0.0f);
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public void onWebScrollChanged(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        super.onWebScrollChanged(scrollX, scrollY, oldScrollX, oldScrollY);
        this.mWebScrollY = scrollY;
        if (scrollY > 0) {
            AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
            if (annieXPopupModel != null && annieXPopupModel.getAutoShowNavBar()) {
                if (this.pullUpState == 3 || isFullScreen()) {
                    showNavBar();
                    return;
                }
                return;
            }
        }
        if (scrollY == 0) {
            AnnieXPopupModel annieXPopupModel2 = getAnnieXPopupModel();
            if (annieXPopupModel2 != null && annieXPopupModel2.getAutoShowNavBar()) {
                hideNavBar();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canDisableDragDown() {
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel != null && annieXPopupModel.getEnableEngineViewScroll()) {
            if (this.mWebScrollY > 0 || !isEngineViewReachTop()) {
                return true;
            }
        } else if (this.mWebScrollY > 0) {
            return true;
        }
        return false;
    }

    private final boolean isEngineViewReachTop() {
        if (getKitView() == null || !(getKitView() instanceof LynxView)) {
            return false;
        }
        View kitView = getKitView();
        Intrinsics.checkNotNull(kitView);
        return !kitView.canScrollVertically(-1);
    }

    private final void bindSlideProcessor() {
        Object obj = this.dialog;
        SheetBaseDialog sheetBaseDialog = obj instanceof SheetBaseDialog ? (SheetBaseDialog) obj : null;
        if (sheetBaseDialog != null) {
            sheetBaseDialog.setSheetSlideProcessor(new SheetSlideProcessor() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$bindSlideProcessor$1$1
                @Override // com.bytedance.android.anniex.container.popup.SheetSlideProcessor
                public boolean disableDragDown() {
                    AnnieXPopupModel annieXPopupModel;
                    boolean isLandscape;
                    boolean canDisableDragDown;
                    AnnieXPopupModel annieXPopupModel2;
                    annieXPopupModel = AnnieXFlowPopupContainer.this.getAnnieXPopupModel();
                    if ((annieXPopupModel == null || annieXPopupModel.getPullDownClose()) ? false : true) {
                        annieXPopupModel2 = AnnieXFlowPopupContainer.this.getAnnieXPopupModel();
                        if ((annieXPopupModel2 != null ? annieXPopupModel2.getPullDownHeight() : 0) <= 0) {
                            return true;
                        }
                    }
                    isLandscape = AnnieXFlowPopupContainer.this.isLandscape();
                    if (isLandscape) {
                        return true;
                    }
                    canDisableDragDown = AnnieXFlowPopupContainer.this.canDisableDragDown();
                    return canDisableDragDown;
                }

                /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
                /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
                @Override // com.bytedance.android.anniex.container.popup.SheetSlideProcessor
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public boolean shouldInterceptSlide(int touchY) {
                    Object obj2;
                    AnnieXPopupModel annieXPopupModel;
                    FrameLayout frameLayout;
                    int height;
                    Integer valueOf;
                    FrameLayout frameLayout2;
                    AnnieXFlowPopupContainer annieXFlowPopupContainer = AnnieXFlowPopupContainer.this;
                    try {
                        Result.Companion companion = Result.Companion;
                        annieXPopupModel = annieXFlowPopupContainer.getAnnieXPopupModel();
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (annieXPopupModel != null) {
                        int pullDownHeight = annieXPopupModel.getPullDownHeight();
                        if (pullDownHeight == 0) {
                            frameLayout2 = annieXFlowPopupContainer.annieXContainer;
                            valueOf = frameLayout2 != null ? Integer.valueOf(frameLayout2.getHeight()) : null;
                        } else {
                            valueOf = Integer.valueOf(ResUtil.INSTANCE.dp2Px(pullDownHeight));
                        }
                        if (valueOf != null) {
                            height = valueOf.intValue();
                            obj2 = Result.constructor-impl(Boolean.valueOf(touchY > ResUtil.INSTANCE.getScreenHeight() - height));
                            if (!Result.isSuccess-impl(obj2)) {
                                return ((Boolean) obj2).booleanValue();
                            }
                            if (Result.exceptionOrNull-impl(obj2) != null) {
                                return SheetSlideProcessor.DefaultImpls.shouldInterceptSlide(this, touchY);
                            }
                            return SheetSlideProcessor.DefaultImpls.shouldInterceptSlide(this, touchY);
                        }
                    }
                    frameLayout = annieXFlowPopupContainer.annieXContainer;
                    height = frameLayout != null ? frameLayout.getHeight() : 0;
                    obj2 = Result.constructor-impl(Boolean.valueOf(touchY > ResUtil.INSTANCE.getScreenHeight() - height));
                    if (!Result.isSuccess-impl(obj2)) {
                    }
                }

                @Override // com.bytedance.android.anniex.container.popup.SheetSlideProcessor
                public boolean inIndicatorArea(MotionEvent event) {
                    View view;
                    Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
                    try {
                        view = AnnieXFlowPopupContainer.this.rootView;
                        FrameLayout frameLayout = view != null ? (FrameLayout) view.findViewById(C0840R.id.annie_x_pull_down_close_indicator_container) : null;
                        Rect rect = new Rect();
                        if (frameLayout != null) {
                            frameLayout.getGlobalVisibleRect(rect);
                        }
                        if (event.getRawX() < rect.left || event.getRawX() > rect.right || event.getRawY() < rect.top) {
                            return false;
                        }
                        return event.getRawY() <= ((float) rect.bottom);
                    } catch (Exception unused) {
                        return false;
                    }
                }
            });
        }
    }

    private final void bindStateCallback() {
        Object obj = this.dialog;
        SheetBaseDialog sheetBaseDialog = obj instanceof SheetBaseDialog ? (SheetBaseDialog) obj : null;
        if (sheetBaseDialog != null) {
            sheetBaseDialog.addStateCallback(new SheetBaseBehavior.SheetCallback() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$bindStateCallback$1
                @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.SheetCallback
                public void onStateChanged(View bottomSheet, int newState) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                }

                @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.SheetCallback
                public void onSlide(View bottomSheet, float slideOffset) {
                    IPopupContainer.PopupComponent popupComponent;
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                    popupComponent = AnnieXFlowPopupContainer.this.popupComponent;
                    if (popupComponent == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
                        popupComponent = null;
                    }
                    popupComponent.onSlide(slideOffset);
                }
            });
        }
    }

    private final void initIndicatorNew(View rootView, AnnieXPopupModel annieXPopupModel) {
        if ((!annieXPopupModel.getPullDownClose() && !annieXPopupModel.getUpFullScreen()) || annieXPopupModel.getPullDownIndicatorNotShow() || OrientationUtils.isLandscape((Context) this.fragmentActivity)) {
            return;
        }
        View findViewById = rootView.findViewById(C0840R.id.annie_x_pull_down_close_indicator_container);
        String indicatorColor = annieXPopupModel != null ? annieXPopupModel.getIndicatorColor() : null;
        this.indicatorView = rootView != null ? rootView.findViewById(C0840R.id.annie_x_pull_down_close_indicator) : null;
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        if (Intrinsics.areEqual("white", indicatorColor)) {
            View view = this.indicatorView;
            if (view != null) {
                view.setBackgroundResource(C0840R.drawable.annie_x_bg_pull_down_close_indicator_light);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual("dark", indicatorColor)) {
            View view2 = this.indicatorView;
            if (view2 != null) {
                view2.setBackgroundResource(C0840R.drawable.annie_x_bg_pull_down_close_indicator_dark);
                return;
            }
            return;
        }
        View view3 = this.indicatorView;
        if (view3 != null) {
            view3.setBackgroundResource(C0840R.drawable.annie_x_bg_pull_down_close_indicator_light);
        }
    }

    private final void bindPullUpProcessor() {
        Object obj = this.dialog;
        SheetBaseDialog sheetBaseDialog = obj instanceof SheetBaseDialog ? (SheetBaseDialog) obj : null;
        if (sheetBaseDialog != null) {
            sheetBaseDialog.setBottomSheetPullUpProcessor(new SheetPullUpProcessor() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$bindPullUpProcessor$1
                @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
                public boolean inIgnoreArea(MotionEvent event) {
                    Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
                    return false;
                }

                @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
                public boolean enablePullUp() {
                    boolean z;
                    AnnieXPopupModel annieXPopupModel;
                    z = AnnieXFlowPopupContainer.this.isPad;
                    if (z) {
                        return false;
                    }
                    annieXPopupModel = AnnieXFlowPopupContainer.this.getAnnieXPopupModel();
                    return annieXPopupModel != null && annieXPopupModel.getUpFullScreen();
                }

                @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
                public boolean enableToHalf() {
                    boolean z;
                    z = AnnieXFlowPopupContainer.this.enableToHalf;
                    return z;
                }

                @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
                public boolean enableToFull() {
                    boolean z;
                    z = AnnieXFlowPopupContainer.this.enableToFull;
                    return z;
                }

                @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
                public boolean isWebViewReachTop() {
                    return AnnieXFlowPopupContainer.this.isKitViewScrollReachTop();
                }

                @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
                public boolean disableNestedChildScroll() {
                    AnnieXPopupModel annieXPopupModel;
                    BooleanParam disableChildScroll;
                    annieXPopupModel = AnnieXFlowPopupContainer.this.getAnnieXPopupModel();
                    if (annieXPopupModel == null || (disableChildScroll = annieXPopupModel.getDisableChildScroll()) == null) {
                        return false;
                    }
                    return Intrinsics.areEqual(disableChildScroll.getValue(), true);
                }
            });
        }
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        boolean z = false;
        if (annieXPopupModel != null && annieXPopupModel.getUpFullScreen()) {
            z = true;
        }
        if (z) {
            sendHalfFullStatus(1);
        }
    }

    public final boolean isKitViewScrollReachTop() {
        IAnnieXEngineProxy engine;
        View enginView;
        if (this.engineScrollView == null && (engine = getEngine()) != null && (enginView = engine.getEnginView()) != null) {
            if (getKitType() != KitType.WEB) {
                enginView = AnnieXLynxViewNestedScrollUtil.INSTANCE.findViewByRecursive(enginView, new Function1<View, Boolean>() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$isKitViewScrollReachTop$1$1
                    public final Boolean invoke(View view) {
                        Intrinsics.checkNotNullParameter(view, "view");
                        return Boolean.valueOf(view instanceof RecyclerView);
                    }
                });
            }
            this.engineScrollView = enginView;
        }
        View view = this.engineScrollView;
        boolean z = false;
        if (view != null && view.canScrollVertically(-1)) {
            z = true;
        }
        return !z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setSheetStateCallback(Dialog dialog) {
        SheetBaseBehavior.SheetCallback sheetCallback = new SheetBaseBehavior.SheetCallback() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$setSheetStateCallback$sheetCallback$1
            @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.SheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                FragmentActivity fragmentActivity;
                int i;
                int i2;
                boolean shouldShowMask;
                AnnieXPopupModel annieXPopupModel;
                int i3;
                boolean shouldShowMask2;
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                fragmentActivity = AnnieXFlowPopupContainer.this.fragmentActivity;
                Window window = fragmentActivity.getWindow();
                if (window != null) {
                    AnnieXFlowPopupContainer.this.onDialogPullUpStateChange(newState);
                    if (newState == 1) {
                        int statusBarColor = window.getStatusBarColor();
                        i = AnnieXFlowPopupContainer.this.defaultStatusBarColor;
                        if (statusBarColor != i) {
                            i2 = AnnieXFlowPopupContainer.this.defaultStatusBarColor;
                            window.setStatusBarColor(i2);
                            return;
                        }
                        return;
                    }
                    if (newState != 3) {
                        if (newState != 4) {
                            if (newState != 5) {
                                return;
                            }
                            AnnieXFlowPopupContainer.this.sendHalfFullStatus(3);
                            return;
                        } else {
                            shouldShowMask2 = AnnieXFlowPopupContainer.this.shouldShowMask();
                            if (shouldShowMask2) {
                                AnnieXFlowPopupContainer.this.showMask();
                            }
                            AnnieXFlowPopupContainer.this.sendHalfFullStatus(1);
                            return;
                        }
                    }
                    shouldShowMask = AnnieXFlowPopupContainer.this.shouldShowMask();
                    if (shouldShowMask) {
                        AnnieXFlowPopupContainer.this.hideMask();
                    }
                    AnnieXFlowPopupContainer.this.sendHalfFullStatus(2);
                    annieXPopupModel = AnnieXFlowPopupContainer.this.getAnnieXPopupModel();
                    if ((annieXPopupModel == null || annieXPopupModel.getUpTransStatusBar()) ? false : true) {
                        i3 = AnnieXFlowPopupContainer.this.upFullStatusBarBgColor;
                        window.setStatusBarColor(i3);
                    }
                }
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.SheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                AnnieXFlowPopupContainer.this.onDialogSlide(bottomSheet, slideOffset);
            }
        };
        SheetBaseDialog sheetBaseDialog = dialog instanceof SheetBaseDialog ? (SheetBaseDialog) dialog : null;
        if (sheetBaseDialog != null) {
            sheetBaseDialog.setStateCallback(sheetCallback);
        }
    }

    private final void updateVoSizeParamOnPad() {
        AnnieXPopupModel annieXPopupModel;
        double height;
        int i;
        if (!this.isPad || (annieXPopupModel = getAnnieXPopupModel()) == null) {
            return;
        }
        BooleanParam padUsePhoneSize = annieXPopupModel.getPadUsePhoneSize();
        if (padUsePhoneSize != null ? Intrinsics.areEqual(padUsePhoneSize.getValue(), true) : false) {
            return;
        }
        if (!IConditionCallKt.annieXWebcastPadFoldPopupHeightSwitch()) {
            height = annieXPopupModel.getHeight() * ((375 * 1.0d) / annieXPopupModel.getWidth());
        } else {
            adaptVoSizeParamOnPadOrFoldScreen();
            height = annieXPopupModel.getHeight();
        }
        annieXPopupModel.setWidth(375);
        BooleanParam padUsePlayerBottomHeight = annieXPopupModel.getPadUsePlayerBottomHeight();
        if (padUsePlayerBottomHeight != null ? Intrinsics.areEqual(padUsePlayerBottomHeight.getValue(), true) : false) {
            if (isLandscape()) {
                annieXPopupModel.setHeight((int) ResUtil.INSTANCE.px2Dp((int) ((ResUtil.INSTANCE.getScreenHeight() * 2) / 3.0f)));
            } else {
                IPopupContainer.PopupComponent popupComponent = this.popupComponent;
                if (popupComponent == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
                    popupComponent = null;
                }
                Pair[] pairArr = new Pair[2];
                BooleanParam padUsePlayerBottomHeight2 = annieXPopupModel.getPadUsePlayerBottomHeight();
                pairArr[0] = TuplesKt.to("pad_use_player_bottom_height", String.valueOf(padUsePlayerBottomHeight2 != null ? (Boolean) padUsePlayerBottomHeight2.getValue() : null));
                pairArr[1] = TuplesKt.to("margin_bottom", Integer.valueOf(annieXPopupModel.getMarginBottom()));
                if (popupComponent.getBottomHeight(MapsKt.mapOf(pairArr)) != null) {
                    annieXPopupModel.setHeight((int) (ResUtil.INSTANCE.px2Dp(r1.intValue()) + 0.5d));
                    annieXPopupModel.setRadiusTopLeft(0);
                    annieXPopupModel.setRadiusTopRight(0);
                }
            }
        } else {
            BooleanParam landscapeCustomHeight = annieXPopupModel.getLandscapeCustomHeight();
            if (!(landscapeCustomHeight != null ? Intrinsics.areEqual(landscapeCustomHeight.getValue(), true) : false) && !IConditionCallKt.annieXWebcastPadFoldPopupHeightSwitch()) {
                if (0 >= height || height >= 480) {
                    i = isLandscape() ? -1 : 700;
                } else {
                    i = (int) height;
                }
                annieXPopupModel.setHeight(i);
            }
        }
        annieXPopupModel.setWidthPercent(0);
        annieXPopupModel.setHeightPercent(0);
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public Scenes getScenes() {
        return Scenes.PopupFragment;
    }

    private final void checkIsValidDialog() {
        if (!shouldLoadBackground()) {
            AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
            boolean z = false;
            if (annieXPopupModel != null && annieXPopupModel.getCanceledOnTouchOutside()) {
                z = true;
            }
            if (z) {
                setCancelable$anniex_release(true);
                return;
            }
        }
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public final void setCancelable$anniex_release(boolean cancelable) {
        DialogFragment dialogFragment = this.dialogFragment;
        if (dialogFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
            dialogFragment = null;
        }
        dialogFragment.setCancelable(cancelable);
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(cancelable);
        }
    }

    private final void adjustLandscapeParam(int screenHeight) {
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel != null) {
            if (isLandscape()) {
                BooleanParam landscapeCustomHeight = annieXPopupModel.getLandscapeCustomHeight();
                if (!(landscapeCustomHeight != null ? Intrinsics.areEqual(landscapeCustomHeight.getValue(), true) : false)) {
                    annieXPopupModel.setRadius(8);
                    annieXPopupModel.setHeight((int) ResUtil.INSTANCE.px2Dp(screenHeight - (annieXPopupModel.getMargin() * 2)));
                    annieXPopupModel.setWidth(300);
                }
                BooleanParam landscapeCustomGravity = annieXPopupModel.getLandscapeCustomGravity();
                if (landscapeCustomGravity != null ? Intrinsics.areEqual(landscapeCustomGravity.getValue(), false) : false) {
                    annieXPopupModel.setGravity(GravityCompat.END);
                } else if (annieXPopupModel.getGravity() == 80) {
                    annieXPopupModel.setGravity(8388693);
                }
                if (annieXPopupModel.getHorizontalWidth() > 0) {
                    annieXPopupModel.setWidth(annieXPopupModel.getHorizontalWidth());
                }
                if (annieXPopupModel.getHorizontalHeight() > 0) {
                    annieXPopupModel.setHeight(annieXPopupModel.getHorizontalHeight());
                }
                if (annieXPopupModel.getHorizontalHeightPercent() > 0) {
                    annieXPopupModel.setHeight((int) ResUtil.INSTANCE.px2Dp((ResUtil.INSTANCE.getRealScreenHeight((Activity) this.fragmentActivity) * annieXPopupModel.getHorizontalHeightPercent()) / 100));
                }
                annieXPopupModel.setUpFullScreen(false);
                if (UIUtils.INSTANCE.checkDeviceHasNavigationBar(getContext())) {
                    annieXPopupModel.setXOffset(UIUtils.INSTANCE.getRealNavigationBarHeight(getContext()));
                    return;
                }
                return;
            }
            if (UIUtils.INSTANCE.checkDeviceHasNavigationBar(getContext())) {
                annieXPopupModel.setYOffset(UIUtils.INSTANCE.getRealNavigationBarHeight(getContext()));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00de, code lost:
    
        if ((r6 != null ? kotlin.jvm.internal.Intrinsics.areEqual(r6.getValue(), true) : false) == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateVoSizeParam(boolean isLandscape, int screenWidth, int screenHeight) {
        int screenHeight2;
        Integer num;
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "screenHeight: " + screenHeight + "; screenWidth: " + screenWidth, (Map) null, (LoggerContext) null, 12, (Object) null);
        adjustLandscapeParam(screenHeight);
        Window window = this.fragmentActivity.getWindow();
        if (window != null) {
            this.defaultStatusBarColor = window.getStatusBarColor();
        }
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel != null) {
            annieXPopupModel.setWidth(RangesKt.coerceAtMost(annieXPopupModel.getWidth(), (int) ResUtil.INSTANCE.px2Dp(screenWidth)));
            if (annieXPopupModel.getRateHeight() > 0 && !isLandscape) {
                annieXPopupModel.setHeight((int) ResUtil.INSTANCE.px2Dp((int) ((annieXPopupModel.getRateHeight() * screenWidth) / 375.0d)));
                HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "rateHeight: " + annieXPopupModel.getRateHeight() + "; screenWidth: " + screenWidth + " ; this.height1: " + annieXPopupModel.getHeight(), (Map) null, (LoggerContext) null, 12, (Object) null);
            }
            if (isLandscape && annieXPopupModel.getHeight() > screenHeight) {
                annieXPopupModel.setHeight((int) ResUtil.INSTANCE.px2Dp(screenHeight - (annieXPopupModel.getMargin() * 2)));
            }
            if (isLandscape) {
                BooleanParam landscapeCustomHeight = annieXPopupModel.getLandscapeCustomHeight();
            }
            if (annieXPopupModel.getGravity() == 80) {
                int i = (int) (screenHeight * 0.85f);
                if (annieXPopupModel.getHeight() > ResUtil.INSTANCE.px2Dp(i)) {
                    annieXPopupModel.setHeight((int) ResUtil.INSTANCE.px2Dp(i));
                    HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "screenHeight: " + screenHeight + "; screenWidth: " + screenWidth + " ; this.height2: " + annieXPopupModel.getHeight(), (Map) null, (LoggerContext) null, 12, (Object) null);
                }
            }
            if (annieXPopupModel.getHeight() + annieXPopupModel.getMarginBottom() >= ((int) ResUtil.INSTANCE.px2Dp(screenHeight))) {
                annieXPopupModel.setHeight(annieXPopupModel.getHeight() - annieXPopupModel.getMarginBottom());
            }
            if (annieXPopupModel.getHeightPercent() > 0 && !isLandscape) {
                annieXPopupModel.setHeight((int) ResUtil.INSTANCE.px2Dp((int) (screenHeight * (annieXPopupModel.getHeightPercent() / 100.0f))));
            }
            if (!isLandscape && annieXPopupModel.getHeight() > screenHeight) {
                annieXPopupModel.setHeight((int) ResUtil.INSTANCE.px2Dp(screenHeight));
            }
            if (isFullScreen()) {
                annieXPopupModel.setHeight((int) ResUtil.INSTANCE.px2Dp(ResUtil.INSTANCE.getRealDisplayMetrics((Context) this.fragmentActivity).heightPixels - UIUtils.INSTANCE.getRealNavigationBarHeight((Context) this.fragmentActivity)));
            }
            if (annieXPopupModel.getWidthPercent() > 0 && !isLandscape) {
                annieXPopupModel.setWidth((int) ResUtil.INSTANCE.px2Dp((int) (screenWidth * (annieXPopupModel.getWidthPercent() / 100.0f))));
            }
            BooleanParam landscapeCustomWidth = annieXPopupModel.getLandscapeCustomWidth();
            if ((landscapeCustomWidth != null ? Intrinsics.areEqual(landscapeCustomWidth.getValue(), true) : false) && isLandscape) {
                annieXPopupModel.setWidth((int) ResUtil.INSTANCE.px2Dp(annieXPopupModel.getMargin() + screenHeight));
            }
            if (annieXPopupModel.getHeight() <= 0) {
                annieXPopupModel.setHeight(450);
            }
            if (annieXPopupModel.getWidth() <= 0) {
                annieXPopupModel.setWidth(300);
            }
            BooleanParam useBottomClose = annieXPopupModel.getUseBottomClose();
            if (useBottomClose != null ? Intrinsics.areEqual(useBottomClose.getValue(), true) : false) {
                annieXPopupModel.setHeight(annieXPopupModel.getHeight() + 48);
            }
            if (annieXPopupModel.getUpFullScreen()) {
                int realNavigationBarHeight = UIUtils.INSTANCE.getRealNavigationBarHeight(getContext());
                if (annieXPopupModel.getUseScreenHeight()) {
                    screenHeight2 = ResUtil.INSTANCE.getRealScreenHeight((Activity) this.fragmentActivity) - realNavigationBarHeight;
                } else {
                    screenHeight2 = ResUtil.INSTANCE.getScreenHeight();
                }
                annieXPopupModel.setHeight(((int) ResUtil.INSTANCE.px2Dp(screenHeight2)) + 2);
                if (annieXPopupModel.getUpHeightPercent() > 0) {
                    float coerceAtMost = 1 - RangesKt.coerceAtMost(annieXPopupModel.getUpHeightPercent() / 100.0f, 1.0f);
                    ResUtil resUtil = ResUtil.INSTANCE;
                    if (annieXPopupModel.getUseScreenHeight()) {
                        screenHeight2 += realNavigationBarHeight;
                    }
                    annieXPopupModel.setUpOffsetHeight((int) resUtil.px2Dp((int) ((screenHeight2 * coerceAtMost) - (annieXPopupModel.getUseScreenHeight() ? realNavigationBarHeight + 2 : 0))));
                }
                UIColorParam upStatusBarBgColor = annieXPopupModel.getUpStatusBarBgColor();
                this.upFullStatusBarBgColor = (upStatusBarBgColor == null || (num = (Integer) upStatusBarBgColor.getValue()) == null) ? 1580077 : num.intValue();
            }
            BooleanParam usePlayerBottomHeight = annieXPopupModel.getUsePlayerBottomHeight();
            if ((usePlayerBottomHeight != null ? Intrinsics.areEqual(usePlayerBottomHeight.getValue(), true) : false) && !isLandscape() && !this.isFold) {
                IPopupContainer.PopupComponent popupComponent = this.popupComponent;
                if (popupComponent == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
                    popupComponent = null;
                }
                if (popupComponent.getBottomHeight(MapsKt.emptyMap()) != null) {
                    annieXPopupModel.setHeight((int) (ResUtil.INSTANCE.px2Dp(r4.intValue()) + 0.5d));
                    annieXPopupModel.setRadiusTopLeft(0);
                    annieXPopupModel.setRadiusTopRight(0);
                }
            }
            if (annieXPopupModel.getRadius() < 0) {
                annieXPopupModel.setRadius(0);
            }
            if (annieXPopupModel.getRadiusTopLeft() < 0) {
                annieXPopupModel.setRadiusTopLeft(0);
            }
            if (annieXPopupModel.getRadiusTopRight() < 0) {
                annieXPopupModel.setRadiusTopRight(0);
            }
            if (annieXPopupModel.getRadiusBottomRight() < 0) {
                annieXPopupModel.setRadiusBottomRight(0);
            }
            if (annieXPopupModel.getRadiusBottomLeft() < 0) {
                annieXPopupModel.setRadiusBottomLeft(0);
            }
            if (isLandscape) {
                float coerceAtMost2 = RangesKt.coerceAtMost(annieXPopupModel.getHorizontalHeightPercent(), 100) / 100.0f;
                float f = 0;
                if (coerceAtMost2 > f) {
                    annieXPopupModel.setHeight((int) ResUtil.INSTANCE.px2Dp((int) (screenHeight * coerceAtMost2)));
                }
                float coerceAtMost3 = RangesKt.coerceAtMost(annieXPopupModel.getHorizontalWidthPercent(), 100) / 100.0f;
                if (coerceAtMost3 > f) {
                    annieXPopupModel.setWidth((int) ResUtil.INSTANCE.px2Dp((int) (screenWidth * coerceAtMost3)));
                }
                if (annieXPopupModel.getHorizontalRadius() > 0) {
                    annieXPopupModel.setRadius(annieXPopupModel.getHorizontalRadius());
                }
            }
        }
    }

    static /* synthetic */ void updateVoSizeParam$default(AnnieXFlowPopupContainer annieXFlowPopupContainer, Configuration configuration, int i, Object obj) {
        if ((i & 1) != 0) {
            configuration = null;
        }
        annieXFlowPopupContainer.updateVoSizeParam(configuration);
    }

    private final void updateVoSizeParam(Configuration newConfig) {
        int i;
        int realNavigationBarHeight;
        if (newConfig != null) {
            i = ResUtil.INSTANCE.dp2Px(newConfig.screenWidthDp);
        } else {
            i = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        int i2 = getRealDisplayMetrics().heightPixels;
        if (this.isFold) {
            if (this.navigationBarHeight == -1) {
                this.navigationBarHeight = getRealNavigationBarHeight();
            }
            realNavigationBarHeight = this.navigationBarHeight;
        } else {
            realNavigationBarHeight = getRealNavigationBarHeight();
        }
        int i3 = i2 - realNavigationBarHeight;
        if (this.isPad) {
            if (isLandscape() && i < i3) {
                updateVoSizeParam(false, i3, i);
                return;
            } else {
                updateVoSizeParam(false, i, i3);
                return;
            }
        }
        boolean isLandscape = isLandscape();
        if (!isLandscape) {
            i2 = i3;
        }
        updateVoSizeParam(isLandscape, i, i2);
    }

    private final void updateVoParamsByCustom() {
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel != null) {
            this.adjustBeforeHeight = annieXPopupModel.getHeight();
        }
        updateVoSizeParam$default(this, null, 1, null);
        updateVoSizeParamOnPad();
        updateVoSizeParamOnFoldScreen();
    }

    private final void updateVoSizeParamOnFoldScreen() {
        AnnieXPopupModel annieXPopupModel;
        int i;
        int i2;
        double height;
        int realScreenWidth;
        if (!this.isFold || (annieXPopupModel = getAnnieXPopupModel()) == null) {
            return;
        }
        BooleanParam padUsePhoneSize = annieXPopupModel.getPadUsePhoneSize();
        if (padUsePhoneSize != null ? Intrinsics.areEqual(padUsePhoneSize.getValue(), true) : false) {
            return;
        }
        ISchemaData schemaData = getSchemaData();
        if (schemaData != null) {
            Integer num = (Integer) new IntegerParam(schemaData, "margin_bottom", 0).getValue();
            i2 = num != null ? num.intValue() : 0;
            Integer num2 = (Integer) new IntegerParam(schemaData, "margin_right", 0).getValue();
            i = num2 != null ? num2.intValue() : 0;
        } else {
            i = 0;
            i2 = 0;
        }
        if (!IConditionCallKt.annieXWebcastPadFoldPopupHeightSwitch()) {
            height = annieXPopupModel.getHeight() * ((375 * 1.0d) / annieXPopupModel.getWidth());
        } else {
            adaptVoSizeParamOnPadOrFoldScreen();
            height = annieXPopupModel.getHeight();
        }
        HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "width: " + annieXPopupModel.getWidth() + ";  height: " + annieXPopupModel.getHeight() + "; isLandscape: " + isLandscape(), (Map) null, (LoggerContext) null, 12, (Object) null);
        if (isLandscape()) {
            realScreenWidth = ResUtil.INSTANCE.getRealScreenHeight((Activity) this.fragmentActivity);
        } else {
            realScreenWidth = ResUtil.INSTANCE.getRealScreenWidth((Activity) this.fragmentActivity);
        }
        int i3 = -1;
        if (ResUtil.INSTANCE.px2Dp(realScreenWidth) <= 395) {
            if (!isLandscape()) {
                annieXPopupModel.setWidth(-1);
            } else {
                annieXPopupModel.setHeight(-1);
            }
            BooleanParam padUsePlayerBottomHeight = annieXPopupModel.getPadUsePlayerBottomHeight();
            if (padUsePlayerBottomHeight != null ? Intrinsics.areEqual(padUsePlayerBottomHeight.getValue(), true) : false) {
                IPopupContainer.PopupComponent popupComponent = this.popupComponent;
                IPopupContainer.PopupComponent popupComponent2 = null;
                if (popupComponent == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
                    popupComponent = null;
                }
                popupComponent.getBottomHeight(MapsKt.emptyMap());
                IPopupContainer.PopupComponent popupComponent3 = this.popupComponent;
                if (popupComponent3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
                } else {
                    popupComponent2 = popupComponent3;
                }
                Integer bottomHeight = popupComponent2.getBottomHeight(MapsKt.emptyMap());
                if (bottomHeight != null) {
                    bottomHeight.intValue();
                    annieXPopupModel.setHeight((int) (ResUtil.INSTANCE.px2Dp(bottomHeight.intValue()) + 0.5d));
                    annieXPopupModel.setRadiusTopLeft(0);
                    annieXPopupModel.setRadiusTopRight(0);
                }
            }
            annieXPopupModel.setMarginBottom(0);
            annieXPopupModel.setMarginRight(0);
        } else {
            annieXPopupModel.setWidth(375);
            BooleanParam landscapeCustomHeight = annieXPopupModel.getLandscapeCustomHeight();
            if (!(landscapeCustomHeight != null ? Intrinsics.areEqual(landscapeCustomHeight.getValue(), true) : false) && !IConditionCallKt.annieXWebcastPadFoldPopupHeightSwitch()) {
                if (0 < height && height < 480) {
                    i3 = annieXPopupModel.getHeight();
                } else if (!isLandscape()) {
                    i3 = 700;
                }
                annieXPopupModel.setHeight(i3);
            }
            annieXPopupModel.setMarginBottom(i2);
            annieXPopupModel.setMarginRight(i);
        }
        annieXPopupModel.setWidthPercent(0);
        annieXPopupModel.setHeightPercent(0);
    }

    private final void adaptVoSizeParamOnPadOrFoldScreen() {
        AnnieXPopupModel annieXPopupModel;
        if (IConditionCallKt.annieXWebcastPadFoldPopupHeightSwitch() && (annieXPopupModel = getAnnieXPopupModel()) != null) {
            if (annieXPopupModel.getRateHeight() > 0) {
                int dp2Px = ResUtil.INSTANCE.dp2Px(375);
                annieXPopupModel.setHeight((int) ResUtil.INSTANCE.px2Dp((int) ((annieXPopupModel.getRateHeight() * dp2Px) / 375.0d)));
                HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "adaptVoSizeParamOnPadOrFoldScreen: rateHeight: " + annieXPopupModel.getRateHeight() + "; containerWidth: " + dp2Px + "; this.height1: " + annieXPopupModel.getHeight(), (Map) null, (LoggerContext) null, 12, (Object) null);
            }
            if (annieXPopupModel.getHeightPercent() <= 0 || !this.isPad) {
                return;
            }
            annieXPopupModel.setHeight((int) ResUtil.INSTANCE.px2Dp((int) (ResUtil.INSTANCE.dp2Px(700) * (annieXPopupModel.getHeightPercent() / 100.0f))));
        }
    }

    private final void configPullUp() {
        AnnieXPopupModel annieXPopupModel;
        if (getAnnieXPopupModel() == null || (annieXPopupModel = getAnnieXPopupModel()) == null) {
            return;
        }
        Object obj = this.dialog;
        SheetBaseDialog sheetBaseDialog = obj instanceof SheetBaseDialog ? (SheetBaseDialog) obj : null;
        if (sheetBaseDialog != null) {
            sheetBaseDialog.setEnablePullUp(annieXPopupModel.getUpFullScreen(), annieXPopupModel.getHeight(), annieXPopupModel.getUpOffsetHeight());
        }
    }

    public final void onDialogPullUpStateChange(int state) {
        this.pullUpState = state;
        IPopupContainer.PopupComponent popupComponent = null;
        if (state == 3) {
            View view = this.indicatorView;
            if (view != null) {
                view.setVisibility(8);
            }
            IPopupContainer.PopupComponent popupComponent2 = this.popupComponent;
            if (popupComponent2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
                popupComponent2 = null;
            }
            popupComponent2.onSheetDialogExpanded();
        } else if (state == 4) {
            View view2 = this.indicatorView;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            IPopupContainer.PopupComponent popupComponent3 = this.popupComponent;
            if (popupComponent3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
                popupComponent3 = null;
            }
            popupComponent3.onSheetDialogCollapsed();
        }
        IPopupContainer.PopupComponent popupComponent4 = this.popupComponent;
        if (popupComponent4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
        } else {
            popupComponent = popupComponent4;
        }
        popupComponent.onSheetStateChange(state);
    }

    public final void onDialogSlide(View bottomSheet, float slideOffset) {
        View view;
        BooleanParam showClosealways;
        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        AnnieXStatusAndNavModel annieXStatusAndNavModel = getAnnieXStatusAndNavModel();
        if (((annieXStatusAndNavModel == null || (showClosealways = annieXStatusAndNavModel.getShowClosealways()) == null) ? false : Intrinsics.areEqual(showClosealways.getValue(), true)) || (view = this.barCloseView) == null) {
            return;
        }
        view.setAlpha(slideOffset);
    }

    public final void initTitleBar() {
        ImageView findViewById;
        BooleanParam showCloseall;
        Boolean bool;
        View view;
        BooleanParam showClosealways;
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel != null && annieXPopupModel.getClosePositionRight()) {
            View view2 = this.rootView;
            findViewById = view2 != null ? (ImageView) view2.findViewById(C0840R.id.annie_x_activity_close) : null;
        } else {
            View view3 = this.rootView;
            findViewById = view3 != null ? view3.findViewById(C0840R.id.annie_x_activity_close_left) : null;
        }
        this.barCloseView = findViewById;
        AnnieXPopupModel annieXPopupModel2 = getAnnieXPopupModel();
        if (annieXPopupModel2 != null && annieXPopupModel2.getUpFullScreen()) {
            AnnieXStatusAndNavModel annieXStatusAndNavModel = getAnnieXStatusAndNavModel();
            if (!((annieXStatusAndNavModel == null || (showClosealways = annieXStatusAndNavModel.getShowClosealways()) == null) ? false : Intrinsics.areEqual(showClosealways.getValue(), true)) && (view = this.barCloseView) != null) {
                view.setAlpha(0.0f);
            }
        }
        AnnieXStatusAndNavModel annieXStatusAndNavModel2 = getAnnieXStatusAndNavModel();
        if (annieXStatusAndNavModel2 == null || (showCloseall = annieXStatusAndNavModel2.getShowCloseall()) == null || (bool = (Boolean) showCloseall.getValue()) == null) {
            return;
        }
        Boolean bool2 = bool.booleanValue() ? bool : null;
        if (bool2 != null) {
            bool2.booleanValue();
            View view4 = this.barCloseView;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            if (view4 != null) {
                view4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$initTitleBar$2$1$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view5) {
                        AnnieXPopupModel annieXPopupModel3;
                        int i;
                        annieXPopupModel3 = AnnieXFlowPopupContainer.this.getAnnieXPopupModel();
                        boolean z = false;
                        if (annieXPopupModel3 != null && annieXPopupModel3.getUpFullScreen()) {
                            z = true;
                        }
                        if (z) {
                            i = AnnieXFlowPopupContainer.this.pullUpState;
                            if (i != 3) {
                                return;
                            }
                        }
                        AnnieXFlowPopupContainer.this.close();
                    }
                });
            }
        }
    }

    public final void setRadius(float radius) {
        RadiusFrameLayout radiusFrameLayout;
        View view = this.rootView;
        if (view == null || (radiusFrameLayout = (RadiusFrameLayout) view.findViewById(C0840R.id.annie_x_container_view)) == null) {
            return;
        }
        radiusFrameLayout.setRadius(radius);
    }

    public final void setRadius(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        RadiusFrameLayout radiusFrameLayout;
        View view = this.rootView;
        if (view == null || (radiusFrameLayout = (RadiusFrameLayout) view.findViewById(C0840R.id.annie_x_container_view)) == null) {
            return;
        }
        radiusFrameLayout.setRadius(topLeft, topRight, bottomRight, bottomLeft);
    }

    private final void setWindowAttr() {
        Window window;
        Dialog dialog = this.dialog;
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
    }

    private final void updateWindowSize(Dialog dialog, int widthInDp, int heightInDp, int gravity) {
        updateWindowAttr(dialog, widthInDp, gravity);
        updateContainerSize(widthInDp, heightInDp, gravity);
    }

    private final void configViewByPopHybridParams() {
        View view;
        ImageView imageView;
        BooleanParam useBottomClose;
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (!((annieXPopupModel == null || (useBottomClose = annieXPopupModel.getUseBottomClose()) == null) ? false : Intrinsics.areEqual(useBottomClose.getValue(), true)) || (view = this.rootView) == null || (imageView = (ImageView) view.findViewById(C0840R.id.annie_x_dialog_btn_close)) == null) {
            return;
        }
        imageView.setVisibility(0);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$configViewByPopHybridParams$1$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Dialog dialog;
                dialog = AnnieXFlowPopupContainer.this.dialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
    }

    private final void updateWindowAttr(Dialog dialog, int widthInDp, int gravity) {
        Window window;
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        if (this.isPad) {
            IPopupContainer.PopupComponent popupComponent = this.popupComponent;
            if (popupComponent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
                popupComponent = null;
            }
            if (!popupComponent.isFullScreen()) {
                return;
            }
        }
        if (this.isFold || getAnnieXPopupModel() == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = gravity;
        if (widthInDp > 0) {
            attributes.width = ResUtil.INSTANCE.dp2Px(widthInDp);
        }
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel != null) {
            if (annieXPopupModel.getXOffset() > 0) {
                attributes.x = annieXPopupModel.getXOffset();
            }
            if (annieXPopupModel.getYOffset() > 0) {
                attributes.y = annieXPopupModel.getYOffset();
            }
            if (annieXPopupModel.getWidthPercent() > 0 && ResUtil.INSTANCE.getResources().getConfiguration().orientation != 2) {
                attributes.width = (int) (getScreenWidth() * (annieXPopupModel.getWidthPercent() / 100.0f));
            }
        }
        try {
            Result.Companion companion = Result.Companion;
            window.setAttributes(attributes);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final boolean isFullScreen() {
        if (this.isPad || this.isFold) {
            return false;
        }
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel != null && annieXPopupModel.getUpFullScreen()) {
            AnnieXPopupModel annieXPopupModel2 = getAnnieXPopupModel();
            if (annieXPopupModel2 == null || !annieXPopupModel2.getUpTransStatusBar()) {
                return false;
            }
        } else {
            if (RangesKt.coerceAtMost((getAnnieXPopupModel() != null ? r0.getHeightPercent() : 0) / 100.0f, 1.0f) < 1.0f) {
                return false;
            }
        }
        return true;
    }

    private final void updateContainerSize(int widthInDp, int heightInDp, int gravity) {
        View view = this.rootView;
        FrameLayout frameLayout = view != null ? (FrameLayout) view.findViewById(C0840R.id.annie_x_dialog_container_view) : null;
        this.annieXContainer = frameLayout;
        ViewGroup.LayoutParams layoutParams = frameLayout != null ? frameLayout.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (widthInDp > 0) {
            widthInDp = ResUtil.INSTANCE.dp2Px(widthInDp);
        }
        layoutParams2.width = widthInDp;
        if (heightInDp > 0) {
            heightInDp = ResUtil.INSTANCE.dp2Px(heightInDp);
        }
        layoutParams2.height = heightInDp;
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel != null) {
            if (ResUtil.INSTANCE.getResources().getConfiguration().orientation != 2) {
                if (isFullScreen()) {
                    layoutParams2.height = getRealDisplayMetrics().heightPixels - getRealNavigationBarHeight();
                } else if (!annieXPopupModel.getUseScreenHeight()) {
                    if (annieXPopupModel.getHeightPercent() > 0) {
                        BooleanParam usePlayerBottomHeight = annieXPopupModel.getUsePlayerBottomHeight();
                        if (!(usePlayerBottomHeight != null ? Intrinsics.areEqual(usePlayerBottomHeight.getValue(), true) : false)) {
                            layoutParams2.height = (int) (ResUtil.INSTANCE.getScreenHeight() * RangesKt.coerceAtMost(annieXPopupModel.getHeightPercent() / 100.0f, 1.0f));
                        }
                    }
                } else if (annieXPopupModel.getHeightPercent() > 0) {
                    layoutParams2.height = (int) (ResUtil.INSTANCE.getRealDisplayMetrics(getContext()).heightPixels * RangesKt.coerceAtMost(annieXPopupModel.getHeightPercent() / 100.0f, 1.0f));
                }
            }
            if (annieXPopupModel.getMarginBottom() > 0) {
                layoutParams2.bottomMargin = ResUtil.INSTANCE.dp2Px(annieXPopupModel.getMarginBottom() * 1.0f);
            }
            if (annieXPopupModel.getMarginRight() > 0) {
                layoutParams2.rightMargin = ResUtil.INSTANCE.dp2Px(annieXPopupModel.getMarginRight() * 1.0f);
            }
            if (this.isFold) {
                if (annieXPopupModel.getMarginBottom() == 0) {
                    layoutParams2.bottomMargin = 0;
                }
                if (annieXPopupModel.getMarginRight() == 0) {
                    layoutParams2.rightMargin = 0;
                    layoutParams2.setMarginEnd(0);
                }
            }
        }
        if (gravity == 0 || (gravity & 17) == 17) {
            layoutParams2.addRule(13);
        } else if ((gravity & 80) == 80) {
            layoutParams2.addRule(12);
            layoutParams2.addRule(11);
        } else if ((gravity & 5) == 5) {
            layoutParams2.addRule(11);
        } else if ((gravity & GravityCompat.END) == 8388613) {
            layoutParams2.addRule(21);
        }
        FrameLayout frameLayout2 = this.annieXContainer;
        if (frameLayout2 != null) {
            frameLayout2.setLayoutParams(layoutParams2);
        }
        updateAnnieXContainerViewHeight(layoutParams2.height);
        FrameLayout frameLayout3 = this.annieXContainer;
        if (frameLayout3 != null) {
            frameLayout3.requestLayout();
        }
    }

    private final void updateAnnieXContainerViewHeight(int height) {
        if (IConditionCallKt.enableAnnieXPopupLoopMeasureFix()) {
            AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
            if (annieXPopupModel != null && annieXPopupModel.getGravity() == 80) {
                AnnieXPopupModel annieXPopupModel2 = getAnnieXPopupModel();
                if ((annieXPopupModel2 == null || annieXPopupModel2.getUpFullScreen()) ? false : true) {
                    View view = this.rootView;
                    View findViewById = view != null ? view.findViewById(C0840R.id.annie_x_container_view) : null;
                    ViewGroup.LayoutParams layoutParams = findViewById != null ? findViewById.getLayoutParams() : null;
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.height = height;
                    findViewById.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void setPullDownClose(boolean pullDownClose) {
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel == null) {
            return;
        }
        annieXPopupModel.setPullDownClose(pullDownClose);
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void setPullDownHeight(int pullDownHeight) {
        AnnieXPopupModel annieXPopupModel = getAnnieXPopupModel();
        if (annieXPopupModel == null) {
            return;
        }
        annieXPopupModel.setPullDownHeight(pullDownHeight);
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void onShow(DialogInterface dialogInterface) {
        Dialog dialog;
        Window window;
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===onShow: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        if (!isLandscape() || (dialog = this.dialog) == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.clearFlags(8);
        hideNavigation(window);
    }

    private final void recordOriginalStatusBar() {
        Window window = this.fragmentActivity.getWindow();
        this.originalSystemUiVisibility = window.getDecorView().getSystemUiVisibility();
        this.originalFlags = window.getAttributes().flags;
        this.originalStatusBarColor = window.getStatusBarColor();
    }

    private final void resetStatusBar() {
        BooleanParam transStatusBar;
        BooleanParam hideStatusBar;
        AnnieXStatusAndNavModel annieXStatusAndNavModel = getAnnieXStatusAndNavModel();
        boolean z = false;
        if (!((annieXStatusAndNavModel == null || (hideStatusBar = annieXStatusAndNavModel.getHideStatusBar()) == null) ? false : Intrinsics.areEqual(hideStatusBar.getValue(), true))) {
            AnnieXStatusAndNavModel annieXStatusAndNavModel2 = getAnnieXStatusAndNavModel();
            if (annieXStatusAndNavModel2 != null && (transStatusBar = annieXStatusAndNavModel2.getTransStatusBar()) != null) {
                z = Intrinsics.areEqual(transStatusBar.getValue(), true);
            }
            if (!z) {
                return;
            }
        }
        Window window = this.fragmentActivity.getWindow();
        window.clearFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(this.originalSystemUiVisibility);
        window.addFlags(this.originalFlags);
        window.setStatusBarColor(this.originalStatusBarColor);
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void onDismiss(DialogInterface dialogInterface) {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===onDismiss: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        resetStatusBar();
        Window window = this.fragmentActivity.getWindow();
        if (window != null) {
            int statusBarColor = window.getStatusBarColor();
            int i = this.defaultStatusBarColor;
            if (statusBarColor != i) {
                window.setStatusBarColor(i);
            }
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public Integer getPopupInitHeight() {
        Integer collapsedPxHeight;
        Object obj = this.dialog;
        SheetBaseDialog sheetBaseDialog = obj instanceof SheetBaseDialog ? (SheetBaseDialog) obj : null;
        return (sheetBaseDialog == null || (collapsedPxHeight = sheetBaseDialog.getCollapsedPxHeight()) == null) ? this.initLayoutParamsHeight : collapsedPxHeight;
    }

    private final void hideNavigation(Window window) {
        window.getDecorView().setSystemUiVisibility(5894);
    }

    private final int getConfigOrientation() {
        return ResUtil.INSTANCE.getResources().getConfiguration().orientation;
    }

    private final DisplayMetrics getRealDisplayMetrics() {
        return ResUtil.INSTANCE.getRealDisplayMetrics((Context) this.fragmentActivity);
    }

    private final int getRealNavigationBarHeight() {
        return UIUtils.INSTANCE.getRealNavigationBarHeight((Context) this.fragmentActivity);
    }

    private final int getScreenWidth() {
        return UIUtils.INSTANCE.getScreenWidth((Context) this.fragmentActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isLandscape() {
        return OrientationUtils.isLandscape((Context) this.fragmentActivity);
    }

    private final boolean transStatusBar() {
        boolean isLandscape = isLandscape();
        if (!isFullScreen() || isLandscape || this.isPad) {
            return isLandscape;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendHalfFullStatus(int pullUpStatusFull) {
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", pullUpStatusFull);
            sendEvent(new IEvent(jSONObject) { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$sendHalfFullStatus$1
                private final String name = "H5_halfFullStatusChange";
                private final Object params;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.params = jSONObject;
                }

                public String getName() {
                    return this.name;
                }

                public Object getParams() {
                    return this.params;
                }
            });
        } catch (JSONException unused) {
        }
    }

    public final void onWebPageFinish() {
        final View kitView = getKitView();
        if (kitView == null || !(kitView instanceof WebView)) {
            return;
        }
        this.fragmentActivity.runOnUiThread(new Runnable() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer$onWebPageFinish$1$1
            @Override // java.lang.Runnable
            public final void run() {
                AnnieXStatusAndNavImp annieXStatusAndNavImp;
                AnnieXStatusAndNavModel annieXStatusAndNavModel;
                AnnieXStatusAndNavImp annieXStatusAndNavImp2;
                AnnieXStatusAndNavModel annieXStatusAndNavModel2;
                AnnieXStatusAndNavImp annieXStatusAndNavImp3 = null;
                if (((WebView) kitView).canGoBack()) {
                    annieXStatusAndNavImp2 = this.statusBarAndNavImp;
                    if (annieXStatusAndNavImp2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
                    } else {
                        annieXStatusAndNavImp3 = annieXStatusAndNavImp2;
                    }
                    annieXStatusAndNavModel2 = this.getAnnieXStatusAndNavModel();
                    annieXStatusAndNavImp3.setPopupBackViewVisibility(annieXStatusAndNavModel2, 0);
                    return;
                }
                annieXStatusAndNavImp = this.statusBarAndNavImp;
                if (annieXStatusAndNavImp == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
                } else {
                    annieXStatusAndNavImp3 = annieXStatusAndNavImp;
                }
                annieXStatusAndNavModel = this.getAnnieXStatusAndNavModel();
                annieXStatusAndNavImp3.setPopupBackViewVisibility(annieXStatusAndNavModel, 8);
            }
        });
    }
}
