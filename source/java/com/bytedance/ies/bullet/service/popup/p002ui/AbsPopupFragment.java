package com.bytedance.ies.bullet.service.popup.p002ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.R;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.container.popup.p001ui.draggable.BottomSheetBehavior;
import com.bytedance.ies.bullet.container.popup.p001ui.draggable.DraggablePopupMode;
import com.bytedance.ies.bullet.core.BulletContainerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.container.BulletActivityWrapper;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.p003ui.common.BulletContainerView;
import com.bytedance.ies.bullet.p003ui.common.IBulletViewProvider;
import com.bytedance.ies.bullet.p003ui.common.view.AutoRTLImageView;
import com.bytedance.ies.bullet.p003ui.common.view.BulletTitleBar;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.CacheItem;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.IBulletPopupFragment;
import com.bytedance.ies.bullet.service.base.IErrorView;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.IPreRenderService;
import com.bytedance.ies.bullet.service.base.IRouterAbilityProvider;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.IViewService;
import com.bytedance.ies.bullet.service.base.api.IBulletUIComponent;
import com.bytedance.ies.bullet.service.base.api.IBulletUILifecycleListener;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.popup.PopUpService;
import com.bytedance.ies.bullet.service.popup.PopupFragmentConfig;
import com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupFragment;
import com.bytedance.ies.bullet.service.popup.p002ui.AnimController;
import com.bytedance.ies.bullet.service.popup.p002ui.primary.mode.BottomPopupMode;
import com.bytedance.ies.bullet.service.popup.p002ui.primary.mode.CenterPopupMode;
import com.bytedance.ies.bullet.service.popup.p002ui.primary.mode.RightInPopupMode;
import com.bytedance.ies.bullet.service.popup.utils.KeyboardUtils;
import com.bytedance.ies.bullet.service.router.RouterService;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.PopupTriggerType;
import com.bytedance.ies.bullet.service.sdk.param.PopupType;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AbsPopupFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 ¾\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0004½\u0001¾\u0001B\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PJ\u001e\u0010Q\u001a\u00020!2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020!JI\u0010Q\u001a\u00020!2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020!2)\u0010O\u001a%\u0012\u0013\u0012\u00110!¢\u0006\f\bW\u0012\b\bX\u0012\u0004\b\b(Y\u0012\u0004\u0012\u00020N\u0018\u00010Vj\u0004\u0018\u0001`ZJ\b\u0010[\u001a\u00020NH\u0002J\b\u0010\\\u001a\u00020NH\u0014J\b\u0010]\u001a\u00020!H\u0002J\b\u0010^\u001a\u00020NH\u0016J\b\u0010_\u001a\u00020NH\u0002J\b\u0010`\u001a\u00020:H\u0016J\b\u0010a\u001a\u00020NH\u0002J\b\u0010b\u001a\u00020cH\u0016J\b\u0010d\u001a\u00020NH\u0016J\u0010\u0010e\u001a\u00020N2\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\b\u0010f\u001a\u00020NH\u0002J\u001a\u0010g\u001a\u00020N2\u0006\u0010h\u001a\u00020i2\b\b\u0002\u0010j\u001a\u00020!H\u0002J\b\u0010k\u001a\u00020NH\u0002J\b\u0010l\u001a\u00020cH\u0016J\b\u0010m\u001a\u0004\u0018\u00010nJ\n\u0010o\u001a\u0004\u0018\u00010cH\u0016J\b\u0010p\u001a\u00020cH\u0016J\b\u0010q\u001a\u00020cH\u0016J\b\u0010r\u001a\u00020cH\u0016J\u0010\u0010s\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010tH\u0002J\n\u0010u\u001a\u0004\u0018\u00010vH\u0016J\b\u0010w\u001a\u00020NH\u0002J\b\u0010x\u001a\u00020NH\u0002J\u0010\u0010y\u001a\u00020N2\u0006\u0010z\u001a\u00020{H\u0002J\b\u0010|\u001a\u00020NH\u0016J\u001a\u0010|\u001a\u00020N2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0006\u0010}\u001a\u00020!J\u0006\u0010~\u001a\u00020!J\u0011\u0010\u007f\u001a\u00020N2\u0007\u0010\u0080\u0001\u001a\u00020vH\u0016J\t\u0010\u0081\u0001\u001a\u00020NH\u0002J\u000b\u0010\u0082\u0001\u001a\u0004\u0018\u00010IH\u0016J\u0015\u0010\u0083\u0001\u001a\u00020N2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016J\t\u0010\u0086\u0001\u001a\u00020NH\u0016J\t\u0010\u0087\u0001\u001a\u00020NH\u0016J\u0014\u0010\u0088\u0001\u001a\u00020N2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010:H\u0016J\t\u0010\u008a\u0001\u001a\u00020NH\u0016J\u0015\u0010\u008b\u0001\u001a\u00020N2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016J\u0016\u0010\u008c\u0001\u001a\u00030\u008d\u00012\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016J\t\u0010\u008e\u0001\u001a\u00020NH\u0016J\t\u0010\u008f\u0001\u001a\u00020NH\u0016J\u001c\u0010\u0090\u0001\u001a\u00020N2\u0007\u0010\u0080\u0001\u001a\u00020v2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0016J\u0014\u0010\u0093\u0001\u001a\u00020N2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010:H\u0002J\u001e\u0010\u0095\u0001\u001a\u00020N2\u0007\u0010\u0080\u0001\u001a\u00020v2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J*\u0010\u0098\u0001\u001a\u00020N2\u0007\u0010\u0080\u0001\u001a\u00020v2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00012\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0092\u0001H\u0016J\u001c\u0010\u009a\u0001\u001a\u00020N2\u0007\u0010\u0080\u0001\u001a\u00020v2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0016J(\u0010\u009b\u0001\u001a\u00020N2\u0007\u0010\u0080\u0001\u001a\u00020v2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00012\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0016J\u001d\u0010\u009e\u0001\u001a\u00020N2\u0007\u0010\u0080\u0001\u001a\u00020v2\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0013H\u0016J\u001e\u0010 \u0001\u001a\u00020N2\u0007\u0010\u0080\u0001\u001a\u00020v2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J\t\u0010¡\u0001\u001a\u00020NH\u0016J\t\u0010¢\u0001\u001a\u00020NH\u0016J\t\u0010£\u0001\u001a\u00020NH\u0016J\u001e\u0010¤\u0001\u001a\u00020N2\u0007\u0010\u0080\u0001\u001a\u00020v2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J\u0013\u0010¥\u0001\u001a\u00020N2\b\u0010¦\u0001\u001a\u00030\u0085\u0001H\u0016J\t\u0010§\u0001\u001a\u00020NH\u0016J\n\u0010¨\u0001\u001a\u00030©\u0001H\u0016J\u000b\u0010ª\u0001\u001a\u0004\u0018\u00010:H\u0016J\f\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0016J\f\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0016J\t\u0010®\u0001\u001a\u00020NH\u0002J\t\u0010¯\u0001\u001a\u00020NH\u0016J\u001b\u0010°\u0001\u001a\u00020N2\u0006\u0010X\u001a\u00020c2\b\u0010±\u0001\u001a\u00030²\u0001H\u0016J\t\u0010³\u0001\u001a\u00020NH\u0002J\u0012\u0010´\u0001\u001a\u00020!2\u0007\u0010µ\u0001\u001a\u00020\u0017H\u0002J\u0011\u0010¶\u0001\u001a\u00020N2\b\u0010\u0094\u0001\u001a\u00030·\u0001J\u001e\u0010¶\u0001\u001a\u00020N2\b\u0010\u0094\u0001\u001a\u00030·\u00012\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010vJQ\u0010¸\u0001\u001a\u00020N2\b\u0010\u0094\u0001\u001a\u00030·\u00012<\u0010¹\u0001\u001a7\u0012\u0015\u0012\u00130·\u0001¢\u0006\r\bW\u0012\t\bX\u0012\u0005\b\b(\u0094\u0001\u0012\u0015\u0012\u00130»\u0001¢\u0006\r\bW\u0012\t\bX\u0012\u0005\b\b(¼\u0001\u0012\u0004\u0012\u00020N0º\u0001H\u0002R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001d\u00103\u001a\u0004\u0018\u0001048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u001a\u00109\u001a\u00020:X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020:X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¿\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lcom/bytedance/ies/bullet/service/base/IBulletPopupFragment;", "Lcom/bytedance/ies/bullet/service/base/IRouterAbilityProvider;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletUIComponent;", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "Landroid/view/View$OnClickListener;", "()V", "act", "Landroid/app/Activity;", "getAct", "()Landroid/app/Activity;", "setAct", "(Landroid/app/Activity;)V", "animController", "Lcom/bytedance/ies/bullet/service/popup/ui/AnimController;", "getAnimController$anniex_release", "()Lcom/bytedance/ies/bullet/service/popup/ui/AnimController;", "bulletContainer", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "bulletSettings", "Lcom/bytedance/ies/bullet/service/base/BulletSettings;", "closeReason", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment$CloseReason;", "config", "Lcom/bytedance/ies/bullet/service/popup/PopupFragmentConfig;", "getConfig", "()Lcom/bytedance/ies/bullet/service/popup/PopupFragmentConfig;", "setConfig", "(Lcom/bytedance/ies/bullet/service/popup/PopupFragmentConfig;)V", "containerModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXContainerModel;", "isDestroy", "", "isLoaded", "isResuming", "isRuntimeReady", "lifecycleListener", "Lcom/bytedance/ies/bullet/service/base/api/IBulletUILifecycleListener;", "logContext", "Lcom/bytedance/ies/bullet/base/utils/logger/LoggerContext;", "getLogContext", "()Lcom/bytedance/ies/bullet/base/utils/logger/LoggerContext;", "setLogContext", "(Lcom/bytedance/ies/bullet/base/utils/logger/LoggerContext;)V", "lynxClient", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "getLynxClient", "()Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "setLynxClient", "(Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;)V", "poolService", "Lcom/bytedance/ies/bullet/service/base/IPreRenderService;", "getPoolService", "()Lcom/bytedance/ies/bullet/service/base/IPreRenderService;", "poolService$delegate", "Lkotlin/Lazy;", "popupContainerView", "Landroid/view/View;", "getPopupContainerView", "()Landroid/view/View;", "setPopupContainerView", "(Landroid/view/View;)V", "popupContentView", "getPopupContentView", "setPopupContentView", "popupMode", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupMode;", "getPopupMode", "()Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupMode;", "setPopupMode", "(Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupMode;)V", "titleBarProvider", "Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBarProvider;", "titleBarView", "windowLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "addPopupDragCallback", "", "callback", "Lcom/bytedance/ies/bullet/container/popup/ui/draggable/BottomSheetBehavior$BottomSheetCallback;", "adjustHeight", "heightPercent", "", "animated", "draggable", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Lcom/bytedance/ies/bullet/service/base/DragPopupCallback;", "callbackDialogDismiss", "callbackDialogOnBackPressed", "callbackIfMaskCancel", "close", "configKeyboard", "constructContentView", "constructUIBody", "containerID", "", "dismiss", "dismissAllowingStateLossWithReason", "dismissSafely", "dispatchAnimProgress", "value", "", "out", "dispatchDismissedCallback", "getBid", "getBulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getBulletTag", "getBundle", "getChannel", "getContainerId", "getPopupDragCallback", "", "getSchema", "Landroid/net/Uri;", "handleTriggerPopupOnCreate", "handleTriggerPopupOnDestroy", "hideSoftInput", "window", "Landroid/view/Window;", EventConstants.PARAM_SOURCE_INIT, "isConfigInitialized", "isContainerViewInitialized", "load", "uri", "observerWindowSizeChange", "offerTitleBarProvider", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onBulletViewCreate", "onBulletViewRelease", "onClick", "v", "onClose", "onCreate", "onCreateDialog", "Landroid/app/Dialog;", "onDestroy", "onDestroyView", "onFallback", "e", "", "onFeJsRuntimeReady", "view", "onKitViewCreate", "kitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "onKitViewDestroy", "throwable", "onLoadFail", "onLoadModelSuccess", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "onLoadStart", "container", "onLoadUriSuccess", "onOpen", "onPause", "onResume", "onRuntimeReady", "onSaveInstanceState", "outState", "onStop", "provideTitleBarText", "", "providerAnimMask", "providerEnterAnim", "Landroid/animation/ObjectAnimator;", "providerExitAnim", "releaseResources", "reload", "sendEventToFE", "params", "Lorg/json/JSONObject;", "sendNotificationOnDestroy", "setCloseReason", ISignalReportConstants.KEY_REASON, "setStatusView", "Lcom/bytedance/ies/bullet/ui/common/BulletContainerView;", "useCacheIfNeeds", "resolve", "Lkotlin/Function2;", "Lcom/bytedance/ies/bullet/service/base/CacheType;", "type", "CloseReason", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AbsPopupFragment extends AppCompatDialogFragment implements IBulletPopupFragment, IRouterAbilityProvider, IBulletUIComponent, IBulletLifeCycle, View.OnClickListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_CONTAINER_ID = "containerID";
    public static final String MODULE = "popup";
    public Activity act;
    private IBulletContainer bulletContainer;
    private BulletSettings bulletSettings;
    public PopupFragmentConfig config;
    private BDXContainerModel containerModel;
    private volatile boolean isDestroy;
    private boolean isLoaded;
    private boolean isResuming;
    private boolean isRuntimeReady;
    private IBulletUILifecycleListener lifecycleListener;
    private LoggerContext logContext;
    private ILynxClientDelegate lynxClient;
    public View popupContainerView;
    public View popupContentView;
    private AbsPopupMode popupMode;
    private IBulletViewProvider.IBulletTitleBarProvider titleBarProvider;
    private View titleBarView;
    private View.OnLayoutChangeListener windowLayoutChangeListener;
    private CloseReason closeReason = CloseReason.UNKNOWN;
    private final AnimController animController = new AnimController();

    /* renamed from: poolService$delegate, reason: from kotlin metadata */
    private final Lazy poolService = LazyKt.lazy(new Function0<IPreRenderService>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$poolService$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final IPreRenderService m569invoke() {
            return (IPreRenderService) StandardServiceManager.INSTANCE.get(AbsPopupFragment.this.getBid(), IPreRenderService.class);
        }
    });

    /* compiled from: AbsPopupFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment$CloseReason;", "", "(Ljava/lang/String;I)V", NetworkStackConstant.UNKNOWN_TYPE, "TAP_MASK", "GESTURE", "JSB", "TITLE_BAR", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum CloseReason {
        UNKNOWN,
        TAP_MASK,
        GESTURE,
        JSB,
        TITLE_BAR
    }

    /* compiled from: AbsPopupFragment.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PopupType.values().length];
            try {
                iArr[PopupType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PopupType.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PopupType.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PopupType.DRAGGABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PopupTriggerType.values().length];
            try {
                iArr2[PopupTriggerType.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[PopupTriggerType.HIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public String getBid() {
        return "default_bid";
    }

    @Override // com.bytedance.ies.bullet.service.base.IBulletPopupFragment
    public void init() {
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onBulletViewCreate() {
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onBulletViewRelease() {
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onFallback(Uri uri, Throwable e) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(e, "e");
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onKitViewCreate(Uri uri, IKitViewService kitView) {
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onKitViewDestroy(Uri uri, IKitViewService kitView, Throwable throwable) {
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    public ObjectAnimator providerEnterAnim() {
        return null;
    }

    public ObjectAnimator providerExitAnim() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean setCloseReason(CloseReason reason) {
        if (this.closeReason != CloseReason.UNKNOWN) {
            return false;
        }
        this.closeReason = reason;
        return true;
    }

    /* compiled from: AbsPopupFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment$Companion;", "", "()V", "KEY_CONTAINER_ID", "", "MODULE", "createFragment", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;", "config", "Lcom/bytedance/ies/bullet/service/popup/PopupFragmentConfig;", "lifecycleListener", "Lcom/bytedance/ies/bullet/service/base/api/IBulletUILifecycleListener;", "fragmentClazz", "Ljava/lang/Class;", "Lcom/bytedance/ies/bullet/service/base/IBulletPopupFragment;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {

        /* compiled from: AbsPopupFragment.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PopupType.values().length];
                try {
                    iArr[PopupType.CENTER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PopupType.RIGHT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PopupType.BOTTOM.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[PopupType.DRAGGABLE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AbsPopupFragment createFragment$default(Companion companion, PopupFragmentConfig popupFragmentConfig, IBulletUILifecycleListener iBulletUILifecycleListener, Class cls, int i, Object obj) {
            if ((i & 4) != 0) {
                cls = null;
            }
            return companion.createFragment(popupFragmentConfig, iBulletUILifecycleListener, cls);
        }

        public final AbsPopupFragment createFragment(PopupFragmentConfig config, IBulletUILifecycleListener lifecycleListener, Class<? extends IBulletPopupFragment> fragmentClazz) {
            AbsPopupFragment absPopupFragment;
            CenterPopupMode centerPopupMode;
            Intrinsics.checkNotNullParameter(config, "config");
            if (fragmentClazz == null) {
                absPopupFragment = new AbsPopupFragment();
            } else {
                IBulletPopupFragment newInstance = fragmentClazz.newInstance();
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment");
                absPopupFragment = (AbsPopupFragment) newInstance;
            }
            absPopupFragment.init();
            absPopupFragment.init(config, lifecycleListener);
            int i = WhenMappings.$EnumSwitchMapping$0[config.getType().ordinal()];
            if (i == 1) {
                centerPopupMode = new CenterPopupMode(absPopupFragment);
            } else if (i == 2) {
                centerPopupMode = new RightInPopupMode(absPopupFragment);
            } else if (i == 3) {
                centerPopupMode = new BottomPopupMode(absPopupFragment);
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                centerPopupMode = new DraggablePopupMode(absPopupFragment);
            }
            absPopupFragment.setPopupMode(centerPopupMode);
            return absPopupFragment;
        }
    }

    public final Activity getAct() {
        Activity activity = this.act;
        if (activity != null) {
            return activity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("act");
        return null;
    }

    public final void setAct(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.act = activity;
    }

    public final PopupFragmentConfig getConfig() {
        PopupFragmentConfig popupFragmentConfig = this.config;
        if (popupFragmentConfig != null) {
            return popupFragmentConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    public final void setConfig(PopupFragmentConfig popupFragmentConfig) {
        Intrinsics.checkNotNullParameter(popupFragmentConfig, "<set-?>");
        this.config = popupFragmentConfig;
    }

    public final AbsPopupMode getPopupMode() {
        return this.popupMode;
    }

    public final void setPopupMode(AbsPopupMode absPopupMode) {
        this.popupMode = absPopupMode;
    }

    public final LoggerContext getLogContext() {
        return this.logContext;
    }

    public final void setLogContext(LoggerContext loggerContext) {
        this.logContext = loggerContext;
    }

    public final boolean isConfigInitialized() {
        return this.config != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void init(PopupFragmentConfig config, IBulletUILifecycleListener lifecycleListener) {
        String str;
        setConfig(config);
        this.lifecycleListener = lifecycleListener;
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(XConstant.SESSION_ID, config.getSessionId());
        Uri schema = getSchema();
        if (schema == null || (str = schema.getQueryParameter(XConstant.BRIDGE_CALL_ID)) == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "getSchema()?.getQueryPar…stant.BRIDGE_CALL_ID)?:\"\"");
        loggerContext.pushStage(XConstant.CALL_ID, str);
        this.logContext = loggerContext;
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "init " + getClass(), null, "XPopup", 2, null);
    }

    public final View getPopupContainerView() {
        View view = this.popupContainerView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("popupContainerView");
        return null;
    }

    public final void setPopupContainerView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.popupContainerView = view;
    }

    public final View getPopupContentView() {
        View view = this.popupContentView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("popupContentView");
        return null;
    }

    public final void setPopupContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.popupContentView = view;
    }

    /* renamed from: getAnimController$anniex_release, reason: from getter */
    public final AnimController getAnimController() {
        return this.animController;
    }

    public final boolean isContainerViewInitialized() {
        return this.popupContainerView != null;
    }

    private final IPreRenderService getPoolService() {
        return (IPreRenderService) this.poolService.getValue();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.config != null) {
            AbsBulletMonitorCallback.onContainerCreated$default(getConfig().getBulletContext().getMonitorCallback(), null, 1, null);
            if (getConfig().getUniformStyleAdapter()) {
                observerWindowSizeChange();
            }
        }
    }

    private final void observerWindowSizeChange() {
        Window window;
        View decorView;
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$observerWindowSizeChange$listener$1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (i3 - i == i7 - i5 && i4 - i2 == i8 - i6) {
                    return;
                }
                Context activity = AbsPopupFragment.this.getActivity();
                if (activity != null) {
                    AbsPopupFragment.this.getConfig().updateWithContext(activity);
                }
                AbsPopupMode popupMode = AbsPopupFragment.this.getPopupMode();
                if (popupMode != null) {
                    popupMode.constructUIBody();
                }
            }
        };
        this.windowLayoutChangeListener = onLayoutChangeListener;
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (setCloseReason(CloseReason.TITLE_BAR)) {
            dismiss();
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AppCompatDialog onCreateDialog;
        CenterPopupMode centerPopupMode;
        if (this.popupMode == null && this.config != null) {
            Log.e("liucheng", "onCreateDialog: pop mode is " + getConfig() + ".type");
            int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getType().ordinal()];
            if (i == 1) {
                centerPopupMode = new CenterPopupMode(this);
            } else if (i == 2) {
                centerPopupMode = new RightInPopupMode(this);
            } else if (i == 3) {
                centerPopupMode = new BottomPopupMode(this);
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                centerPopupMode = new DraggablePopupMode(this);
            }
            this.popupMode = centerPopupMode;
        }
        AbsPopupMode absPopupMode = this.popupMode;
        if (absPopupMode != null && (onCreateDialog = absPopupMode.onCreateDialog()) != null) {
            return (Dialog) onCreateDialog;
        }
        Dialog onCreateDialog2 = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog2, "super.onCreateDialog(savedInstanceState)");
        return onCreateDialog2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityCreated(Bundle savedInstanceState) {
        ObjectAnimator objectAnimator;
        SchemaModelUnion schemaModelUnion;
        ISchemaData schemaData;
        Window window;
        View decorView;
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            setAct((Activity) activity);
        }
        if (this.act == null || this.config == null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "act and config is not init, dismiss dialog fragment", null, "XPopup", 2, null);
            Dialog dialog = getDialog();
            AbsPopupDialog absPopupDialog = dialog instanceof AbsPopupDialog ? (AbsPopupDialog) dialog : null;
            if (absPopupDialog != null) {
                absPopupDialog.supportRequestWindowFeature(1);
            }
            super.dismissAllowingStateLoss();
            return;
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setOwnerActivity(getAct());
        }
        if (getConfig().getDisableImmersive()) {
            Dialog dialog3 = getDialog();
            AbsPopupDialog absPopupDialog2 = dialog3 instanceof AbsPopupDialog ? (AbsPopupDialog) dialog3 : null;
            if (absPopupDialog2 != null) {
                absPopupDialog2.enableImmersive(false);
            }
        }
        Dialog dialog4 = getDialog();
        if (dialog4 != null && (window = dialog4.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            decorView.setBackgroundColor(getConfig().getMaskColor());
        }
        this.isDestroy = false;
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        BulletContext bulletContext = getBulletContext();
        hybridLogger.m11i("XPopup", "popup status onActivityCreated", MapsKt.mapOf(TuplesKt.to("popup schema", String.valueOf((bulletContext == null || (schemaModelUnion = bulletContext.getSchemaModelUnion()) == null || (schemaData = schemaModelUnion.getSchemaData()) == null) ? null : schemaData.getInnerOriginUrl()))), this.logContext);
        View inflate = LayoutInflater.from(getAct()).inflate(R.layout.bullet_popup_container, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(act).inflate(R.layo…et_popup_container, null)");
        setPopupContainerView(inflate);
        AnimController animController = this.animController;
        View providerAnimMask = providerAnimMask();
        ObjectAnimator providerEnterAnim = providerEnterAnim();
        if (providerEnterAnim == null) {
            AbsPopupMode absPopupMode = this.popupMode;
            objectAnimator = absPopupMode != null ? absPopupMode.getEnterAnim() : null;
        } else {
            objectAnimator = providerEnterAnim;
        }
        animController.doEnterAnim(providerAnimMask, objectAnimator, getConfig().getResizeDuration(), new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$onActivityCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m568invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m568invoke() {
                if (AbsPopupFragment.this.isContainerViewInitialized()) {
                    AbsPopupFragment.this.getPopupContainerView().requestLayout();
                }
            }
        }, new Function1<Float, Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$onActivityCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                AbsPopupFragment.this.dispatchAnimProgress(f, false);
            }
        });
        constructUIBody();
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "created " + getBid(), null, "XPopup", 2, null);
        configKeyboard();
        handleTriggerPopupOnCreate();
        onOpen();
    }

    private final void constructUIBody() {
        if (!getConfig().getHideNavBar()) {
            IBulletViewProvider.IBulletTitleBarProvider offerTitleBarProvider = offerTitleBarProvider();
            this.titleBarProvider = offerTitleBarProvider;
            if (offerTitleBarProvider == null) {
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "this.requireContext()");
                BulletTitleBar bulletTitleBar = new BulletTitleBar(requireContext, null, 0, 6, null);
                Integer navBarColor = getConfig().getNavBarColor();
                if (navBarColor != null) {
                    ((FrameLayout) bulletTitleBar.getTitleBarRootView().findViewById(R.id.titlebar_root_view)).setBackgroundColor(navBarColor.intValue());
                }
                AutoRTLImageView autoRTLImageView = (AutoRTLImageView) bulletTitleBar.getTitleBarRootView().findViewById(R.id.iv_back);
                AbsPopupMode absPopupMode = this.popupMode;
                if (absPopupMode != null) {
                    autoRTLImageView.setImageResource(absPopupMode.getTitleBarBackImageRes());
                }
                Integer titleColor = getConfig().getTitleColor();
                if (titleColor != null) {
                    autoRTLImageView.setColorFilter(titleColor.intValue(), PorterDuff.Mode.SRC_ATOP);
                }
                autoRTLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$constructUIBody$1$2$3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        boolean closeReason;
                        closeReason = AbsPopupFragment.this.setCloseReason(AbsPopupFragment.CloseReason.TITLE_BAR);
                        if (closeReason) {
                            AbsPopupFragment.this.dismiss();
                        }
                    }
                });
                TextView textView = (TextView) bulletTitleBar.getTitleBarRootView().findViewById(R.id.tv_title);
                textView.setText(getConfig().getTitle());
                Integer titleColor2 = getConfig().getTitleColor();
                if (titleColor2 != null) {
                    textView.setTextColor(titleColor2.intValue());
                }
                ((AutoRTLImageView) bulletTitleBar.getTitleBarRootView().findViewById(R.id.iv_close_all)).setVisibility(8);
                this.titleBarView = bulletTitleBar;
            } else if (offerTitleBarProvider != null) {
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "this@AbsPopupFragment.requireActivity()");
                this.titleBarView = offerTitleBarProvider.initWithParams((Context) requireActivity, getConfig().getSchema(), null);
                offerTitleBarProvider.setDefaultTitle(provideTitleBarText());
                AbsPopupFragment absPopupFragment = this;
                offerTitleBarProvider.setBackListener(absPopupFragment);
                offerTitleBarProvider.setCloseAllListener(absPopupFragment);
            }
            View view = this.titleBarView;
            if (view != null) {
                ((LinearLayout) getPopupContainerView().findViewById(R.id.bullet_popup_linear)).addView(view, -1, -2);
            }
        }
        setPopupContentView(constructContentView());
        ((LinearLayout) getPopupContainerView().findViewById(R.id.bullet_popup_linear)).addView(getPopupContentView(), new ViewGroup.LayoutParams(-1, -1));
        onBulletViewCreate();
        load(getConfig().getSchema());
        Object dialog = getDialog();
        AbsPopupDialog absPopupDialog = dialog instanceof AbsPopupDialog ? (AbsPopupDialog) dialog : null;
        if (absPopupDialog != null) {
            absPopupDialog.setContentView(getPopupContainerView());
            absPopupDialog.setClickThroughMask(getConfig().getClickThroughMask());
            absPopupDialog.setCallbackIfMaskCancel(new Function0<Boolean>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$constructUIBody$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m563invoke() {
                    boolean callbackIfMaskCancel;
                    callbackIfMaskCancel = AbsPopupFragment.this.callbackIfMaskCancel();
                    return Boolean.valueOf(callbackIfMaskCancel);
                }
            });
            absPopupDialog.setCallbackOnBackPressed(new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$constructUIBody$4$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m564invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m564invoke() {
                    AbsPopupFragment.this.callbackDialogOnBackPressed();
                }
            });
            absPopupDialog.setCallbackDismiss(new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$constructUIBody$4$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m565invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m565invoke() {
                    AbsPopupFragment.this.callbackDialogDismiss();
                }
            });
        }
        AbsPopupMode absPopupMode2 = this.popupMode;
        if (absPopupMode2 != null) {
            absPopupMode2.constructUIBody();
        }
    }

    public void onResume() {
        SchemaModelUnion schemaModelUnion;
        ISchemaData schemaData;
        super.onResume();
        this.isResuming = true;
        if (this.isRuntimeReady) {
            HybridLogger.INSTANCE.m11i("XPopup", "AbsPopupFragment onResume call onEnterForeground", MapsKt.mapOf(TuplesKt.to("popup url", String.valueOf(getSchema()))), this.logContext);
            IBulletContainer iBulletContainer = this.bulletContainer;
            if (iBulletContainer != null) {
                iBulletContainer.onEnterForeground();
            }
        }
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        BulletContext bulletContext = getBulletContext();
        hybridLogger.m11i("XPopup", "popup status onResume", MapsKt.mapOf(TuplesKt.to("popup schema", String.valueOf((bulletContext == null || (schemaModelUnion = bulletContext.getSchemaModelUnion()) == null || (schemaData = schemaModelUnion.getSchemaData()) == null) ? null : schemaData.getInnerOriginUrl()))), this.logContext);
    }

    public void onPause() {
        IBulletContainer iBulletContainer;
        super.onPause();
        this.isResuming = false;
        if (this.isRuntimeReady && (iBulletContainer = this.bulletContainer) != null) {
            iBulletContainer.onEnterBackground();
        }
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getConfig().getSessionId(), "popup status:onPause", "XPopup", null, 8, null);
    }

    public void onStop() {
        super.onStop();
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getConfig().getSessionId(), "popup status:onStop", "XPopup", null, 8, null);
    }

    public void onDestroyView() {
        Window window;
        View decorView;
        Object dialog = getDialog();
        AbsPopupDialog absPopupDialog = dialog instanceof AbsPopupDialog ? (AbsPopupDialog) dialog : null;
        if (absPopupDialog != null) {
            absPopupDialog.superDismiss();
        }
        this.isDestroy = true;
        View.OnLayoutChangeListener onLayoutChangeListener = this.windowLayoutChangeListener;
        if (onLayoutChangeListener != null) {
            FragmentActivity activity = getActivity();
            if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                decorView.removeOnLayoutChangeListener(onLayoutChangeListener);
            }
            this.windowLayoutChangeListener = null;
        }
        super.onDestroyView();
    }

    public void onDestroy() {
        SchemaModelUnion schemaModelUnion;
        ISchemaData schemaData;
        super.onDestroy();
        if (this.act == null || this.config == null) {
            return;
        }
        sendNotificationOnDestroy();
        onClose();
        releaseResources();
        PopUpService.INSTANCE.destroyBulletPopup(this, getConfig().getSessionId());
        handleTriggerPopupOnDestroy();
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("closeReason", this.closeReason);
        BulletContext bulletContext = getBulletContext();
        pairArr[1] = TuplesKt.to("popup schema", String.valueOf((bulletContext == null || (schemaModelUnion = bulletContext.getSchemaModelUnion()) == null || (schemaData = schemaModelUnion.getSchemaData()) == null) ? null : schemaData.getInnerOriginUrl()));
        hybridLogger.m11i("XPopup", "popup status onDestroy", MapsKt.mapOf(pairArr), this.logContext);
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        if (this.animController.getExitAnimProcessType() != AnimController.AnimProcessType.NONE) {
            super.dismissAllowingStateLoss();
            this.isDestroy = true;
            super.onSaveInstanceState(outState);
            return;
        }
        super.onSaveInstanceState(outState);
    }

    private final void sendNotificationOnDestroy() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("containerID", getContainerId());
        Unit unit = Unit.INSTANCE;
        jSONObject.put("data", jSONObject2);
        jSONObject.put(SchemaConstants.INNER_PARAM_EVENT_NAME, "onClosePanel");
        Unit unit2 = Unit.INSTANCE;
        sendEventToFE("notification", jSONObject);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("status", "destroy");
        Unit unit3 = Unit.INSTANCE;
        sendEventToFE("popupStatusChange", jSONObject3);
    }

    private final void releaseResources() {
        new Handler().postDelayed(new Runnable() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$releaseResources$1
            @Override // java.lang.Runnable
            public final void run() {
                View popupContentView = AbsPopupFragment.this.getPopupContentView();
                BulletContainerView bulletContainerView = popupContentView instanceof BulletContainerView ? (BulletContainerView) popupContentView : null;
                if (bulletContainerView != null) {
                    bulletContainerView.onPopupDestroy$anniex_release();
                    bulletContainerView.release();
                }
                PopUpService.INSTANCE.destroyBulletPopupThoroughly(AbsPopupFragment.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissSafely() {
        if (getFragmentManager() == null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "dismissSafely found fragmentManager=null", LogLevel.E, null, 4, null);
        } else if (this.act != null && getAct().isFinishing()) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "dismissSafely found act finishing", LogLevel.E, null, 4, null);
        } else {
            super.dismissAllowingStateLoss();
        }
    }

    public void dismiss() {
        ObjectAnimator objectAnimator;
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            hideSoftInput(window);
        }
        if (!isContainerViewInitialized()) {
            dismissSafely();
            return;
        }
        if (this.isDestroy) {
            return;
        }
        Object dialog2 = getDialog();
        if ((dialog2 instanceof AbsPopupDialog ? (AbsPopupDialog) dialog2 : null) != null) {
            AnimController animController = this.animController;
            View providerAnimMask = providerAnimMask();
            ObjectAnimator providerExitAnim = providerExitAnim();
            if (providerExitAnim == null) {
                AbsPopupMode absPopupMode = this.popupMode;
                objectAnimator = absPopupMode != null ? absPopupMode.getExitAnim() : null;
            } else {
                objectAnimator = providerExitAnim;
            }
            animController.doExitAnim(providerAnimMask, objectAnimator, getConfig().getResizeDuration(), new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$dismiss$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m566invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m566invoke() {
                    boolean z;
                    z = AbsPopupFragment.this.isDestroy;
                    if (!z) {
                        AbsPopupFragment.this.dismissSafely();
                    }
                    AbsPopupFragment.this.dispatchDismissedCallback();
                }
            }, new Function1<Float, Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$dismiss$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f) {
                    AbsPopupFragment.dispatchAnimProgress$default(AbsPopupFragment.this, f, false, 2, null);
                }
            });
            return;
        }
        dismissSafely();
    }

    public static /* synthetic */ void dismissAllowingStateLossWithReason$default(AbsPopupFragment absPopupFragment, CloseReason closeReason, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismissAllowingStateLossWithReason");
        }
        if ((i & 1) != 0) {
            closeReason = CloseReason.UNKNOWN;
        }
        absPopupFragment.dismissAllowingStateLossWithReason(closeReason);
    }

    public final void dismissAllowingStateLossWithReason(CloseReason closeReason) {
        ObjectAnimator objectAnimator;
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        if (setCloseReason(CloseReason.JSB) && isContainerViewInitialized() && !this.isDestroy) {
            Object dialog = getDialog();
            if ((dialog instanceof AbsPopupDialog ? (AbsPopupDialog) dialog : null) != null) {
                AnimController animController = this.animController;
                View providerAnimMask = providerAnimMask();
                ObjectAnimator providerExitAnim = providerExitAnim();
                if (providerExitAnim == null) {
                    AbsPopupMode absPopupMode = this.popupMode;
                    objectAnimator = absPopupMode != null ? absPopupMode.getExitAnim() : null;
                } else {
                    objectAnimator = providerExitAnim;
                }
                animController.doExitAnim(providerAnimMask, objectAnimator, getConfig().getResizeDuration(), new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$dismissAllowingStateLossWithReason$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m567invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m567invoke() {
                        boolean z;
                        z = AbsPopupFragment.this.isDestroy;
                        if (!z) {
                            AbsPopupFragment.this.dismissSafely();
                        }
                        AbsPopupFragment.this.dispatchDismissedCallback();
                    }
                }, new Function1<Float, Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$dismissAllowingStateLossWithReason$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f) {
                        AbsPopupFragment.dispatchAnimProgress$default(AbsPopupFragment.this, f, false, 2, null);
                    }
                });
                return;
            }
            dismissSafely();
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IBulletPopupFragment
    public View constructContentView() {
        BulletContainerView bulletContainerView = new BulletContainerView(getAct(), null, 0, 6, null);
        bulletContainerView.bind(getBid());
        setStatusView(bulletContainerView);
        bulletContainerView.setMCurrentScene(Scenes.PopupFragment);
        setPopupContentView(bulletContainerView);
        return getPopupContentView();
    }

    private final void useCacheIfNeeds(BulletContainerView view, Function2<? super BulletContainerView, ? super CacheType, Unit> resolve) {
        boolean areEqual = Intrinsics.areEqual(getConfig().getBundle().getString(SchemaConstants.QUERY_KEY_PRERENDER), "1");
        IPreRenderService poolService = getPoolService();
        CacheItem fetch = poolService != null ? poolService.fetch(getConfig().getSchema(), areEqual, false, view) : null;
        if (fetch == null) {
            resolve.invoke(view, CacheType.NONE);
            return;
        }
        View view2 = fetch.getView();
        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.bytedance.ies.bullet.ui.common.BulletContainerView");
        resolve.invoke((BulletContainerView) view2, fetch.getCacheType());
    }

    public static /* synthetic */ void setStatusView$default(AbsPopupFragment absPopupFragment, BulletContainerView bulletContainerView, Uri uri, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStatusView");
        }
        if ((i & 2) != 0) {
            uri = null;
        }
        absPopupFragment.setStatusView(bulletContainerView, uri);
    }

    public final void setStatusView(final BulletContainerView view, Uri uri) {
        Object obj;
        IViewService iViewService;
        Unit unit;
        BulletContainerContext containerContext;
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            Result.Companion companion = Result.Companion;
            String safeGetQueryParameter = uri != null ? ExtKt.safeGetQueryParameter(uri, "url") : null;
            if (safeGetQueryParameter == null) {
                safeGetQueryParameter = "";
            }
            obj = Result.constructor-impl(Uri.parse(safeGetQueryParameter));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Uri uri2 = (Uri) obj;
        boolean areEqual = Intrinsics.areEqual(uri2 != null ? ExtKt.safeGetQueryParameter(uri2, SchemaConstants.QUERY_KEY_LOADING_STYLE) : null, "host");
        boolean areEqual2 = Intrinsics.areEqual(uri2 != null ? ExtKt.safeGetQueryParameter(uri2, SchemaConstants.QUERY_KEY_ERROR_PAGE_STYLE) : null, "host");
        String bid = areEqual ? "default_bid" : getBid();
        String bid2 = areEqual2 ? "default_bid" : getBid();
        BulletContext bulletContext = getBulletContext();
        IViewService viewService = (bulletContext == null || (containerContext = bulletContext.getContainerContext()) == null) ? null : containerContext.getViewService();
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "AbsPopupFragment.setStatusView: viewService is null = " + (viewService == null), null, "XPopup", 2, null);
        if (viewService == null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "AbsPopupFragment.setStatusView: loadingBid = " + bid + ", errorBid = " + bid2, null, "XPopup", 2, null);
            viewService = (IViewService) ServiceCenter.INSTANCE.instance().get(bid, IViewService.class);
            iViewService = (IViewService) ServiceCenter.INSTANCE.instance().get(bid2, IViewService.class);
        } else {
            iViewService = viewService;
        }
        if (viewService != null) {
            view.setLoadingView(viewService);
        }
        if (iViewService != null) {
            view.setErrorView(iViewService, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$setStatusView$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m570invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m570invoke() {
                    AbsPopupFragment.this.dismiss();
                }
            }, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$setStatusView$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m571invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m571invoke() {
                    BulletContainerView.this.reLoadUri();
                }
            });
            IErrorView createErrorView = iViewService.createErrorView(getAct(), "popup");
            if (createErrorView != null) {
                View view2 = createErrorView.getView(new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$setStatusView$2$3$errorView$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m572invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m572invoke() {
                        AbsPopupFragment.this.dismiss();
                    }
                }, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$setStatusView$2$3$errorView$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m573invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m573invoke() {
                        BulletContainerView.this.reLoadUri();
                    }
                });
                LinearLayout linearLayout = view2 instanceof LinearLayout ? (LinearLayout) view2 : null;
                if (linearLayout != null) {
                    linearLayout.setGravity(17);
                }
                FrameLayout.LayoutParams errorViewLayoutParams = iViewService.getErrorViewLayoutParams("popup");
                if (errorViewLayoutParams != null) {
                    view.setErrorView(view2, errorViewLayoutParams);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    BulletContainerView.setErrorView$default(view, view2, null, 2, null);
                }
            }
        }
    }

    public final void setStatusView(BulletContainerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        setStatusView(view, null);
    }

    @Override // com.bytedance.ies.bullet.service.base.IBulletPopupFragment
    public void load(final Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        final Bundle bundle = getConfig().getBundle();
        if (getConfig().isFullScreen()) {
            bundle.putInt(SchemaConstants.QUERY_KEY_LYNX_PRESET_WIDTH, getConfig().getScreenWidth());
            bundle.putInt(SchemaConstants.QUERY_KEY_LYNX_PRESET_HEIGHT, getConfig().getScreenHeight());
        }
        try {
            Bundle extraBundle = getConfig().getExtraBundle();
            if (extraBundle != null) {
                bundle.putAll(extraBundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        AbsBulletMonitorCallback.onLoadEntryBullet$default(getConfig().getBulletContext().getMonitorCallback(), System.currentTimeMillis(), false, 2, null);
        View popupContentView = getPopupContentView();
        BulletContainerView bulletContainerView = popupContentView instanceof BulletContainerView ? (BulletContainerView) popupContentView : null;
        if (bulletContainerView != null) {
            useCacheIfNeeds(bulletContainerView, new Function2<BulletContainerView, CacheType, Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$load$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((BulletContainerView) obj, (CacheType) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(BulletContainerView bulletContainerView2, CacheType cacheType) {
                    Intrinsics.checkNotNullParameter(bulletContainerView2, "view");
                    Intrinsics.checkNotNullParameter(cacheType, "type");
                    AbsPopupFragment.this.setPopupContentView(bulletContainerView2);
                    AbsPopupFragment.this.setStatusView(bulletContainerView2, uri);
                    if (cacheType == CacheType.NONE) {
                        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, AbsPopupFragment.this.getConfig().getSessionId(), "load uri. schema: " + uri, "XPopup", null, 8, null);
                        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
                        CommonConfig commonConfig = iBulletSettingsService != null ? (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class) : null;
                        boolean z = false;
                        if (commonConfig != null && commonConfig.getEnableBulletPopupActivity()) {
                            z = true;
                        }
                        if (z) {
                            Activity activity = AbsPopupFragment.this.getActivity();
                            bulletContainerView2.setActivityWrapper(activity != null ? new BulletActivityWrapper(activity) : null);
                        }
                        bulletContainerView2.loadUri(uri, bundle, AbsPopupFragment.this.getConfig().getBulletContext(), ContextProviderManager.INSTANCE.getProviderFactory(AbsPopupFragment.this.getConfig().getSessionId()), AbsPopupFragment.this);
                        return;
                    }
                    BulletLogger bulletLogger = BulletLogger.INSTANCE;
                    StringBuilder sb = new StringBuilder("Hit preRender, old ");
                    PopupFragmentConfig config = AbsPopupFragment.this.getConfig();
                    StringBuilder append = sb.append(config != null ? config.getSessionId() : null).append(", new ");
                    BulletContext bulletContext = bulletContainerView2.getBulletContext();
                    BulletLogger.printLog$default(bulletLogger, append.append(bulletContext != null ? bulletContext.getSessionId() : null).toString(), null, "XPopup", 2, null);
                    bulletContainerView2.addLifeCycleListener(AbsPopupFragment.this);
                    bulletContainerView2.onFetchFromPreRenderPool();
                }
            });
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IBulletPopupFragment
    public void reload() {
        View popupContentView = getPopupContentView();
        BulletContainerView bulletContainerView = popupContentView instanceof BulletContainerView ? (BulletContainerView) popupContentView : null;
        if (bulletContainerView != null) {
            bulletContainerView.reLoadUri();
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IBulletPopupFragment
    public String containerID() {
        IBulletContainer iBulletContainer = this.bulletContainer;
        String sessionId = iBulletContainer != null ? iBulletContainer.getSessionId() : null;
        return sessionId == null ? "" : sessionId;
    }

    @Override // com.bytedance.ies.bullet.service.base.IBulletPopupFragment
    public void sendEventToFE(final String name, final JSONObject params) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(params, "params");
        IBulletContainer iBulletContainer = this.bulletContainer;
        if (iBulletContainer != null) {
            iBulletContainer.onEvent(new IEvent(name, params) { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$sendEventToFE$1
                private final String name;
                private final Object params;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.name = name;
                    this.params = params;
                }

                @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                public String getName() {
                    return this.name;
                }

                @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
                public Object getParams() {
                    return this.params;
                }
            });
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IBulletPopupFragment
    public CharSequence provideTitleBarText() {
        return "";
    }

    public final BulletContext getBulletContext() {
        if (this.config == null) {
            return null;
        }
        return getConfig().getBulletContext();
    }

    private final void handleTriggerPopupOnCreate() {
        AbsPopupMode absPopupMode;
        AbsPopupFragment bulletPopup;
        AbsPopupMode absPopupMode2;
        if (this.bulletSettings == null) {
            ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
            this.bulletSettings = iSettingService != null ? iSettingService.provideBulletSettings() : null;
        }
        if (this.bulletSettings != null) {
            int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getTriggerOrigin().ordinal()];
            if (i == 1) {
                AbsPopupFragment bulletPopup2 = PopUpService.INSTANCE.getBulletPopup(getConfig().getOriginContainerId());
                if (bulletPopup2 != null && (absPopupMode = bulletPopup2.popupMode) != null) {
                    absPopupMode.dismissForever();
                }
            } else if (i == 2 && (bulletPopup = PopUpService.INSTANCE.getBulletPopup(getConfig().getOriginContainerId())) != null && (absPopupMode2 = bulletPopup.popupMode) != null) {
                absPopupMode2.hideAndWaitResume();
            }
            HybridLogger.INSTANCE.m11i("XPopup", "handleTriggerPopupOnCreate", MapsKt.mapOf(new Pair[]{TuplesKt.to("popup url", String.valueOf(getSchema())), TuplesKt.to("handleTriggerPopupOnCreate", getConfig().getTriggerOrigin().name())}), this.logContext);
        }
    }

    private final void handleTriggerPopupOnDestroy() {
        AbsPopupFragment bulletPopup;
        AbsPopupMode absPopupMode;
        if (this.bulletSettings == null) {
            ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
            this.bulletSettings = iSettingService != null ? iSettingService.provideBulletSettings() : null;
        }
        if (this.bulletSettings == null || getConfig().getTriggerOrigin() != PopupTriggerType.RESUME || (bulletPopup = PopUpService.INSTANCE.getBulletPopup(getConfig().getOriginContainerId())) == null || (absPopupMode = bulletPopup.popupMode) == null) {
            return;
        }
        absPopupMode.resumeWhenBack();
    }

    private final void configKeyboard() {
        final Window window;
        Window window2;
        Window window3;
        Window window4;
        if ((getConfig().getListenKeyboard() || getConfig().getKeyboardAdjust()) && isConfigInitialized()) {
            Dialog dialog = getDialog();
            if (dialog != null && (window2 = dialog.getWindow()) != null) {
                window2.setSoftInputMode(16);
            }
            Dialog dialog2 = getDialog();
            if (dialog2 == null || (window = dialog2.getWindow()) == null) {
                return;
            }
            KeyboardUtils keyboardUtils = KeyboardUtils.INSTANCE;
            Context context = window.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            keyboardUtils.registerSoftInputChangedListener$anniex_release(window, context, new KeyboardUtils.OnSoftInputChangedListener() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$configKeyboard$1$1
                @Override // com.bytedance.ies.bullet.service.popup.utils.KeyboardUtils.OnSoftInputChangedListener
                public void onSoftInputChanged(int height) {
                    AbsPopupMode popupMode;
                    if (!AbsPopupFragment.this.getConfig().getIgnoreKeyboardPadding() && (popupMode = AbsPopupFragment.this.getPopupMode()) != null) {
                        boolean z = height > 0;
                        Window window5 = window;
                        Intrinsics.checkNotNullExpressionValue(window5, "this@apply");
                        popupMode.onKeyBoardChange(z, height, Integer.valueOf(UIUtils.getDecorViewVisibleHeight$anniex_release(window5)));
                    }
                    AbsPopupFragment absPopupFragment = AbsPopupFragment.this;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("containerID", AbsPopupFragment.this.getContainerId());
                    jSONObject.put("keyboardShow", height > 0);
                    Unit unit = Unit.INSTANCE;
                    absPopupFragment.sendEventToFE("bulletOnSoftInputChangedAction", jSONObject);
                }
            });
            return;
        }
        if (getConfig().getIsAdjustPan()) {
            Dialog dialog3 = getDialog();
            if (dialog3 == null || (window4 = dialog3.getWindow()) == null) {
                return;
            }
            window4.setSoftInputMode(32);
            return;
        }
        Dialog dialog4 = getDialog();
        if (dialog4 == null || (window3 = dialog4.getWindow()) == null) {
            return;
        }
        window3.setSoftInputMode(48);
    }

    private final void hideSoftInput(Window window) {
        View currentFocus = window.getCurrentFocus();
        if (currentFocus == null) {
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            EditText findViewWithTag = decorView.findViewWithTag("keyboardTagView");
            if (findViewWithTag == null) {
                findViewWithTag = new EditText(window.getContext());
                findViewWithTag.setTag("keyboardTagView");
                ((ViewGroup) decorView).addView(findViewWithTag, 0, 0);
            }
            currentFocus = findViewWithTag;
            currentFocus.requestFocus();
        }
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean callbackIfMaskCancel() {
        if (getConfig().getCloseByMask() && getConfig().getMaskCloseUntilLoaded()) {
            return this.isLoaded;
        }
        return getConfig().getCloseByMask();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void callbackDialogOnBackPressed() {
        BooleanParam blockBackPress;
        if (getConfig().getAllowClosed()) {
            BDXContainerModel bDXContainerModel = this.containerModel;
            if (((bDXContainerModel == null || (blockBackPress = bDXContainerModel.getBlockBackPress()) == null) ? false : Intrinsics.areEqual(blockBackPress.getValue(), true)) && this.popupContentView != null) {
                View popupContentView = getPopupContentView();
                BulletContainerView bulletContainerView = popupContentView instanceof BulletContainerView ? (BulletContainerView) popupContentView : null;
                if (bulletContainerView != null && bulletContainerView.isLoadSuccess()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("containerID", getContainerId());
                    Unit unit = Unit.INSTANCE;
                    sendEventToFE("bulletOnBackPressAction", jSONObject);
                    return;
                }
            }
            if (setCloseReason(CloseReason.GESTURE)) {
                dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void callbackDialogDismiss() {
        ObjectAnimator objectAnimator;
        if (!isContainerViewInitialized()) {
            Dialog dialog = getDialog();
            AbsPopupDialog absPopupDialog = dialog instanceof AbsPopupDialog ? (AbsPopupDialog) dialog : null;
            if (absPopupDialog != null) {
                absPopupDialog.superDismiss();
            }
            dispatchDismissedCallback();
            return;
        }
        AnimController animController = this.animController;
        View providerAnimMask = providerAnimMask();
        ObjectAnimator providerExitAnim = providerExitAnim();
        if (providerExitAnim == null) {
            AbsPopupMode absPopupMode = this.popupMode;
            objectAnimator = absPopupMode != null ? absPopupMode.getExitAnim() : null;
        } else {
            objectAnimator = providerExitAnim;
        }
        animController.doExitAnim(providerAnimMask, objectAnimator, getConfig().getResizeDuration(), new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$callbackDialogDismiss$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m562invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m562invoke() {
                Object dialog2 = AbsPopupFragment.this.getDialog();
                AbsPopupDialog absPopupDialog2 = dialog2 instanceof AbsPopupDialog ? (AbsPopupDialog) dialog2 : null;
                if (absPopupDialog2 != null) {
                    absPopupDialog2.superDismiss();
                }
                AbsPopupFragment.this.dispatchDismissedCallback();
            }
        }, new Function1<Float, Unit>() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$callbackDialogDismiss$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                AbsPopupFragment.dispatchAnimProgress$default(AbsPopupFragment.this, f, false, 2, null);
            }
        });
    }

    public final boolean adjustHeight(int heightPercent, boolean animated, boolean draggable) {
        AbsPopupMode absPopupMode = this.popupMode;
        DraggablePopupMode draggablePopupMode = absPopupMode instanceof DraggablePopupMode ? (DraggablePopupMode) absPopupMode : null;
        if (draggablePopupMode != null) {
            return DraggablePopupMode.adjustHeight$default(draggablePopupMode, heightPercent, animated, draggable, null, 8, null);
        }
        return false;
    }

    public final boolean adjustHeight(int heightPercent, boolean animated, boolean draggable, Function1<? super Boolean, Unit> callback) {
        AbsPopupMode absPopupMode = this.popupMode;
        DraggablePopupMode draggablePopupMode = absPopupMode instanceof DraggablePopupMode ? (DraggablePopupMode) absPopupMode : null;
        if ((draggablePopupMode != null ? Boolean.valueOf(draggablePopupMode.adjustHeight(heightPercent, animated, draggable, callback)) : null) != null) {
            return true;
        }
        if (callback == null) {
            return false;
        }
        callback.invoke(false);
        return false;
    }

    public final void addPopupDragCallback(BottomSheetBehavior.BottomSheetCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AbsPopupMode absPopupMode = this.popupMode;
        DraggablePopupMode draggablePopupMode = absPopupMode instanceof DraggablePopupMode ? (DraggablePopupMode) absPopupMode : null;
        if (draggablePopupMode != null) {
            draggablePopupMode.addCallback(callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void dispatchAnimProgress$default(AbsPopupFragment absPopupFragment, float f, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchAnimProgress");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        absPopupFragment.dispatchAnimProgress(f, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchAnimProgress(float value, boolean out) {
        List<BottomSheetBehavior.BottomSheetCallback> popupDragCallback = getPopupDragCallback();
        if (popupDragCallback != null) {
            for (BottomSheetBehavior.BottomSheetCallback bottomSheetCallback : popupDragCallback) {
                if (out) {
                    bottomSheetCallback.onExitOutProgressUpdate(value);
                } else {
                    bottomSheetCallback.onEnterInProgressUpdate(value);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchDismissedCallback() {
        List<BottomSheetBehavior.BottomSheetCallback> popupDragCallback = getPopupDragCallback();
        if (popupDragCallback != null) {
            Iterator<T> it = popupDragCallback.iterator();
            while (it.hasNext()) {
                ((BottomSheetBehavior.BottomSheetCallback) it.next()).onBottomSheetDismissed();
            }
        }
    }

    private final List<BottomSheetBehavior.BottomSheetCallback> getPopupDragCallback() {
        AbsPopupMode absPopupMode = this.popupMode;
        DraggablePopupMode draggablePopupMode = absPopupMode instanceof DraggablePopupMode ? (DraggablePopupMode) absPopupMode : null;
        if (draggablePopupMode != null) {
            return draggablePopupMode.getCallbacks();
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.IRouterAbilityProvider
    public String getBulletTag() {
        if (this.config == null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "popup config is not initialized", null, "XPopup", 2, null);
            return null;
        }
        return new StringParam(getConfig().getBulletContext().getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_BDX_TAG, null).getValue();
    }

    @Override // com.bytedance.ies.bullet.service.base.IRouterAbilityProvider
    public String getChannel() {
        if (this.config == null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "popup config is not initialized", null, "XPopup", 2, null);
            return "";
        }
        String value = new StringParam(getConfig().getBulletContext().getSchemaModelUnion().getSchemaData(), "channel", null).getValue();
        return (value == null && (value = getConfig().getBundle().getString(XConstant.PARAM_KEY_CHANNEL)) == null) ? "" : value;
    }

    @Override // com.bytedance.ies.bullet.service.base.IRouterAbilityProvider
    public String getBundle() {
        if (this.config == null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "popup config is not initialized", null, "XPopup", 2, null);
            return "";
        }
        String value = new StringParam(getConfig().getBulletContext().getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_BUNDLE, null).getValue();
        return (value == null && (value = getConfig().getBundle().getString(XConstant.PARAM_KEY_BUNDLE)) == null) ? "" : value;
    }

    @Override // com.bytedance.ies.bullet.service.base.IRouterAbilityProvider
    public void close() {
        HybridLogger.INSTANCE.m11i("XPopup", "AbsPopupFragment close", MapsKt.mapOf(TuplesKt.to("close popup url", String.valueOf(getSchema()))), this.logContext);
        dismissAllowingStateLossWithReason$default(this, null, 1, null);
    }

    @Override // com.bytedance.ies.bullet.service.base.IRouterAbilityProvider
    public String getContainerId() {
        return containerID();
    }

    @Override // com.bytedance.ies.bullet.service.base.IRouterAbilityProvider
    public Uri getSchema() {
        return getConfig().getSchema();
    }

    public IBulletViewProvider.IBulletTitleBarProvider offerTitleBarProvider() {
        BulletContainerContext containerContext;
        IViewService viewService;
        BulletContainerContext containerContext2;
        BulletContext context = BulletContextManager.INSTANCE.getInstance().getContext(getConfig().getSessionId());
        IBulletViewProvider.IBulletTitleBarProvider titleBarProvider = (context == null || (containerContext2 = context.getContainerContext()) == null) ? null : containerContext2.getTitleBarProvider();
        IBulletViewProvider.IBulletTitleBarProvider titleBarProvider2 = (context == null || (containerContext = context.getContainerContext()) == null || (viewService = containerContext.getViewService()) == null) ? null : viewService.getTitleBarProvider("popup");
        IViewService iViewService = (IViewService) ServiceCenter.INSTANCE.instance().get(getBid(), IViewService.class);
        IBulletViewProvider.IBulletTitleBarProvider titleBarProvider3 = iViewService != null ? iViewService.getTitleBarProvider("popup") : null;
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "AbsPopupFragment.offerTitleBarProvider, titleBarProviderInBulletContext=" + titleBarProvider + ", titleBarProviderInContextViewProvider=" + titleBarProvider2 + ", titleBarProviderInBidViewProvider=" + titleBarProvider3, null, "XPopup", 2, null);
        return titleBarProvider == null ? titleBarProvider2 == null ? titleBarProvider3 : titleBarProvider2 : titleBarProvider;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public ILynxClientDelegate getLynxClient() {
        return this.lynxClient;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void setLynxClient(ILynxClientDelegate iLynxClientDelegate) {
        this.lynxClient = iLynxClientDelegate;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadStart(Uri uri, IBulletContainer container) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.bulletContainer = container;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadModelSuccess(Uri uri, IKitViewService kitView, SchemaModelUnion schemaModelUnion) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(schemaModelUnion, "schemaModelUnion");
        ISchemaModel containerModel = schemaModelUnion.getContainerModel();
        BDXContainerModel bDXContainerModel = containerModel instanceof BDXContainerModel ? (BDXContainerModel) containerModel : null;
        if (bDXContainerModel != null) {
            this.containerModel = bDXContainerModel;
        }
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onOpen() {
        IBulletUILifecycleListener iBulletUILifecycleListener = this.lifecycleListener;
        if (iBulletUILifecycleListener != null) {
            iBulletUILifecycleListener.onOpen(this);
        }
        RouterService routerService = (RouterService) StandardServiceManager.INSTANCE.get(getBid(), RouterService.class);
        if (routerService != null) {
            if (!(routerService instanceof RouterService)) {
                routerService = null;
            }
            if (routerService != null) {
                routerService.tryCloseAffinity(getConfig().getBulletContext(), getChannel(), getBundle(), this);
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onRuntimeReady(Uri uri, IKitViewService kitView) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        onFeJsRuntimeReady(getPopupContainerView());
    }

    private final void onFeJsRuntimeReady(View view) {
        if (view != null) {
            view.post(new Runnable() { // from class: com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment$onFeJsRuntimeReady$1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z;
                    IBulletContainer iBulletContainer;
                    z = AbsPopupFragment.this.isResuming;
                    if (z) {
                        iBulletContainer = AbsPopupFragment.this.bulletContainer;
                        if (iBulletContainer != null) {
                            iBulletContainer.onEnterForeground();
                        }
                        HybridLogger.INSTANCE.m11i("XPopup", "AbsPopupFragment.onFeJsRuntimeReady: call onEnterForeground", MapsKt.mapOf(TuplesKt.to("popup url", String.valueOf(AbsPopupFragment.this.getSchema()))), AbsPopupFragment.this.getLogContext());
                    }
                    AbsPopupFragment.this.isRuntimeReady = true;
                }
            });
        }
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadUriSuccess(Uri uri, IKitViewService kitView) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "onLoadUriSuccess", null, "XPopup", 2, null);
        this.isLoaded = true;
        PopUpService.INSTANCE.createBulletPopup(this, getConfig().getSessionId());
        IBulletUILifecycleListener iBulletUILifecycleListener = this.lifecycleListener;
        if (iBulletUILifecycleListener != null) {
            iBulletUILifecycleListener.onLoadSuccess(this);
        }
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadFail(Uri uri, Throwable e) {
        BooleanParam showError;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(e, "e");
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "onLoadUriFailed " + e, null, "XPopup", 2, null);
        this.isLoaded = true;
        IBulletUILifecycleListener iBulletUILifecycleListener = this.lifecycleListener;
        if (iBulletUILifecycleListener != null) {
            iBulletUILifecycleListener.onLoadFailed(this, e);
        }
        BDXContainerModel bDXContainerModel = this.containerModel;
        if ((bDXContainerModel == null || (showError = bDXContainerModel.getShowError()) == null) ? false : Intrinsics.areEqual(showError.getValue(), true)) {
            return;
        }
        dismiss();
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onClose() {
        IBulletUILifecycleListener iBulletUILifecycleListener = this.lifecycleListener;
        if (iBulletUILifecycleListener != null) {
            iBulletUILifecycleListener.onClose(this);
        }
    }

    public View providerAnimMask() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return null;
        }
        return window.getDecorView();
    }
}
