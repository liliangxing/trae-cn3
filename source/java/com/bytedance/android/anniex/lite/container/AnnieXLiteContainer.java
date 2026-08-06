package com.bytedance.android.anniex.lite.container;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.builder.UIComponentBuilder;
import com.bytedance.android.anniex.base.container.BaseContainer;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.UIComponent;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.container.AnnieXLifecycleDispatcher;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.container.util.ResUtil;
import com.bytedance.android.anniex.lite.AnnieXProcessCenter;
import com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy;
import com.bytedance.android.anniex.lite.model.AnnieXContext;
import com.bytedance.android.anniex.lite.utils.AnnieXLiteUtilsKt;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.utils.AnnieXConstants;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputUtilKt;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.common.DebugConfig;
import com.bytedance.ies.bullet.core.common.DebugInfo;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.ILoadingView;
import com.bytedance.ies.bullet.service.base.api.IServiceContextKt;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.ies.bullet.service.sdk.param.LaunchModeParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import com.bytedance.ies.bullet.service.sdk.param.UrlParam;
import com.bytedance.ies.bullet.ui.common.DebugTagTextView;
import com.bytedance.ies.bullet.ui.common.utils.BulletPadAdapterUtil;
import com.bytedance.ies.bullet.ui.common.utils.ScreenInfo;
import com.bytedance.ies.bullet.ui.common.utils.ViewUtil;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
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
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: AnnieXLiteContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ù\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0006\b!\u0018\u0000 ²\u00012\u00020\u0001:\u0002²\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010G\u001a\u00020HH\u0014J\b\u0010I\u001a\u00020HH\u0002J\b\u0010J\u001a\u00020HH\u0002J\u0010\u0010K\u001a\u00020H2\u0006\u0010L\u001a\u00020\"H\u0002J\b\u0010M\u001a\u00020HH\u0016J,\u0010N\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020P\u0018\u00010O2\u0014\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020P\u0018\u00010OH\u0002J\u0010\u0010R\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010S\u001a\u00020&2\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010T\u001a\u00020HH\u0016J\b\u0010U\u001a\u00020HH\u0016J\u0010\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020 H\u0016J\b\u0010Y\u001a\u00020ZH\u0016J\n\u0010[\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\\\u001a\u00020 H\u0016J\b\u0010]\u001a\u00020 H\u0016J\u0012\u0010^\u001a\u0004\u0018\u00010$2\u0006\u0010_\u001a\u00020$H\u0002J\n\u0010`\u001a\u0004\u0018\u00010aH\u0016J\n\u0010b\u001a\u0004\u0018\u00010WH\u0016J\b\u0010c\u001a\u00020 H\u0016J\b\u0010d\u001a\u00020eH\u0016J\n\u0010f\u001a\u0004\u0018\u00010$H\u0016J\u0014\u0010g\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020h0OH\u0016J\b\u0010i\u001a\u00020jH\u0016J\n\u0010k\u001a\u0004\u0018\u00010WH\u0016J\b\u0010l\u001a\u00020\u001cH\u0016J\u0010\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020pH\u0002J\u0006\u0010q\u001a\u00020 J\b\u0010r\u001a\u00020 H\u0016J\u0010\u0010s\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0tH\u0016J\b\u0010u\u001a\u00020HH\u0016J\b\u0010v\u001a\u00020HH\u0002J\b\u0010w\u001a\u00020HH\u0004J\u0010\u0010x\u001a\u00020H2\u0006\u0010y\u001a\u00020\u0016H\u0016J\b\u0010.\u001a\u00020\u0016H\u0016J&\u0010z\u001a\u00020H2\u0006\u0010X\u001a\u00020 2\u0014\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020P\u0018\u00010OH\u0016J:\u0010z\u001a\u00020H2\u0006\u0010X\u001a\u00020 2\u0014\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020P\u0018\u00010O2\b\u0010{\u001a\u0004\u0018\u00010a2\b\u0010|\u001a\u0004\u0018\u00010}H\u0016J\u0012\u0010~\u001a\u00020a2\b\u0010{\u001a\u0004\u0018\u00010aH\u0002J\b\u0010\u007f\u001a\u00020\u0016H\u0002J\t\u0010\u0080\u0001\u001a\u00020HH\u0016J\u0013\u0010\u0081\u0001\u001a\u00020H2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J#\u0010\u0084\u0001\u001a\u00020H2\u0007\u0010\u0085\u0001\u001a\u00020\u00162\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0003\u0010\u0087\u0001J-\u0010\u0088\u0001\u001a\u00020H2\u0007\u0010\u0089\u0001\u001a\u00020\"2\u0007\u0010\u008a\u0001\u001a\u00020\"2\u0007\u0010\u008b\u0001\u001a\u00020\"2\u0007\u0010\u008c\u0001\u001a\u00020\"H\u0016J)\u0010\u008d\u0001\u001a\u00020H2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010$2\b\u0010\u008f\u0001\u001a\u00030\u0083\u00012\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010\u0091\u0001\u001a\u00020H2\u0007\u0010\u0092\u0001\u001a\u00020\"H\u0002J\u0011\u0010\u0093\u0001\u001a\u00020H2\u0006\u0010L\u001a\u00020\"H\u0002J1\u0010\u0094\u0001\u001a\u00020H\"\u0005\b\u0000\u0010\u0095\u00012\u000f\u0010\u0096\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0095\u00010\u0097\u00012\b\u0010\u0098\u0001\u001a\u0003H\u0095\u0001H\u0016¢\u0006\u0003\u0010\u0099\u0001J\t\u0010\u009a\u0001\u001a\u00020HH\u0016J\u001f\u0010\u009b\u0001\u001a\u00020H2\u0014\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020P\u0018\u00010OH\u0016J\u0013\u0010\u009c\u0001\u001a\u00020H2\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0016J\u001b\u0010\u009f\u0001\u001a\u00020H2\u0007\u0010 \u0001\u001a\u00020\u00162\u0007\u0010¡\u0001\u001a\u00020\"H\u0002J\t\u0010¢\u0001\u001a\u00020HH\u0002J\t\u0010£\u0001\u001a\u00020HH\u0002J\u0011\u0010¤\u0001\u001a\u00020H2\u0006\u0010C\u001a\u00020DH\u0004J\u0013\u0010¥\u0001\u001a\u00020\u00162\b\u0010¦\u0001\u001a\u00030§\u0001H\u0002J\t\u0010¨\u0001\u001a\u00020HH\u0016J\t\u0010©\u0001\u001a\u00020HH\u0016J\t\u0010ª\u0001\u001a\u00020HH\u0002J\u0012\u0010«\u0001\u001a\u00020H2\u0007\u0010¬\u0001\u001a\u00020 H\u0016J\u001e\u0010«\u0001\u001a\u00020H2\u0013\u0010¬\u0001\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020P0OH\u0016J\u001e\u0010\u00ad\u0001\u001a\u00020H2\u0013\u0010®\u0001\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020P0OH\u0016J\t\u0010¯\u0001\u001a\u00020HH\u0002J\u001b\u0010°\u0001\u001a\u00020H2\u0007\u0010±\u0001\u001a\u00020\"2\u0007\u0010¡\u0001\u001a\u00020\"H\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\r\u001a\u0004\b'\u0010(R\u0010\u0010*\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u000200X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u000e\u00103\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0004\n\u0002\u00109R\u0012\u0010:\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0004\n\u0002\u00109R\u001a\u0010;\u001a\u00020<X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020\"0BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006³\u0001"}, d2 = {"Lcom/bytedance/android/anniex/lite/container/AnnieXLiteContainer;", "Lcom/bytedance/android/anniex/base/container/BaseContainer;", "builder", "Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "(Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;)V", "annieLifeCycle", "com/bytedance/android/anniex/lite/container/AnnieXLiteContainer$annieLifeCycle$1", "Lcom/bytedance/android/anniex/lite/container/AnnieXLiteContainer$annieLifeCycle$1;", "annieXContext", "Lcom/bytedance/android/anniex/lite/model/AnnieXContext;", "getAnnieXContext", "()Lcom/bytedance/android/anniex/lite/model/AnnieXContext;", "annieXContext$delegate", "Lkotlin/Lazy;", "getBuilder", "()Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "containerModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXContainerModel;", "getContainerModel", "()Lcom/bytedance/ies/bullet/service/schema/model/BDXContainerModel;", "containerModel$delegate", "containerVisible", "", "getContainerVisible", "()Z", "setContainerVisible", "(Z)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "currentBid", "", "currentState", "", "denyView", "Landroid/view/View;", "engine", "Lcom/bytedance/android/anniex/lite/base/IAnnieXEngineProxy;", "getEngine", "()Lcom/bytedance/android/anniex/lite/base/IAnnieXEngineProxy;", "engine$delegate", "errorView", "isNotRelease", "isResuming", "isRuntimeReady", "isVisibility", "lifecycleDispatcher", "Lcom/bytedance/android/anniex/container/AnnieXLifecycleDispatcher;", "getLifecycleDispatcher", "()Lcom/bytedance/android/anniex/container/AnnieXLifecycleDispatcher;", "loadSuccess", "loadingView", "noticeView", "originBackground", "Landroid/graphics/drawable/Drawable;", "padAdapterHeight", "Ljava/lang/Integer;", "padAdapterWidth", "parentViewGroup", "Landroid/view/ViewGroup;", "getParentViewGroup", "()Landroid/view/ViewGroup;", "setParentViewGroup", "(Landroid/view/ViewGroup;)V", "stateBlockingQueue", "Ljava/util/concurrent/ArrayBlockingQueue;", "uiComponent", "Lcom/bytedance/android/anniex/base/container/UIComponent;", "usableHeightPrevious", "useCustomBackground", "addKitView", "", "addTagView", "bindWebOnScrollChangeListener", "changeState", StrategyConstants.STATE, "close", "completeRenderData", "", "", "renderData", "createAnnieXContext", "createEngine", "enterBackground", "enterForeground", "generateSchemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", StrategyConstants.SCHEMA, "getBDXLaunchMode", "Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "getBDXTag", "getBid", "getContainerId", "getContentView", "decorView", "getContextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getCurrentSchema", "getCurrentUrl", "getKitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitView", "getPerfMap", "", "getScenes", "Lcom/bytedance/ies/bullet/core/common/Scenes;", "getSchemaData", "getSystemContext", "getUriByBundle", "Landroid/net/Uri;", "bundle", "Landroid/os/Bundle;", "getUrl", "getViewType", "getWeakContext", "Ljava/lang/ref/WeakReference;", "hideLoading", "initContainerColor", "initUi", "interceptBackPress", StrategyConstants.ENABLE, "loadSchema", "contextProviderFactory", "lifecycle", "Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "mergeContext", "needAdapterKeyboard", "observerKeyboardStatusChange", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onVisibleChange", "visible", "hasReadySendVisibleEvent", "(ZLjava/lang/Boolean;)V", "onWebScrollChanged", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "padAdaptation", "view", "configuration", "isKitViewCreate", "possiblyResizeChildOfContent", "softHeight", "putState", "registerWeakHolder", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "item", "(Ljava/lang/Class;Ljava/lang/Object;)V", "release", "reload", "sendEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "sendKeyboardStatusChangeEvent", "isShowing", "height", "setBackgroundColor", "setContainerColor", "setUiComponent", "showContainerTag", "debugInfo", "Lcom/bytedance/ies/bullet/core/common/DebugInfo;", "showError", "showLoading", "transferToTargetState", "updateData", Constants.KEY_DATA, "updateGlobalProps", "globalProps", "updateLynxScreenMetrics", "updateScreenMetrics", "width", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class AnnieXLiteContainer extends BaseContainer {
    private static final int LOAD_STATUS_CREATE_KIT_VIEW = 2;
    private static final int LOAD_STATUS_DESTROY = 6;
    private static final int LOAD_STATUS_FINISH = 4;
    private static final int LOAD_STATUS_INIT_UI = 0;
    private static final int LOAD_STATUS_LOADING = 3;
    private static final int LOAD_STATUS_PARSE_SCHEMA = 1;
    private static final int LOAD_STATUS_RUNTIME_READY = 5;
    private static final int LOAD_STATUS_UNKNOWN = -1;
    private static final String TAG = "AnnieXContainer";
    private static final String VISIBLE_CHANGE_TYPE_APP = "app";
    private static final String VISIBLE_CHANGE_TYPE_PAGE = "page";
    private AnnieXLiteContainer$annieLifeCycle$1 annieLifeCycle;

    /* renamed from: annieXContext$delegate, reason: from kotlin metadata */
    private final Lazy annieXContext;
    private final UIComponentBuilder builder;

    /* renamed from: containerModel$delegate, reason: from kotlin metadata */
    private final Lazy containerModel;
    private volatile boolean containerVisible;
    private final Context context;
    private final String currentBid;
    private int currentState;
    private View denyView;

    /* renamed from: engine$delegate, reason: from kotlin metadata */
    private final Lazy engine;
    private View errorView;
    private boolean isNotRelease;
    private boolean isResuming;
    private boolean isRuntimeReady;
    private volatile boolean isVisibility;
    private final AnnieXLifecycleDispatcher lifecycleDispatcher;
    private boolean loadSuccess;
    private View loadingView;
    private View noticeView;
    private Drawable originBackground;
    private Integer padAdapterHeight;
    private Integer padAdapterWidth;
    protected ViewGroup parentViewGroup;
    private ArrayBlockingQueue<Integer> stateBlockingQueue;
    private UIComponent uiComponent;
    private int usableHeightPrevious;
    private boolean useCustomBackground;

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public String getViewType() {
        return AnnieX.CONTAINER_VIEW_TYPE_CARD;
    }

    public void onWebScrollChanged(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
    }

    public final UIComponentBuilder getBuilder() {
        return this.builder;
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [com.bytedance.android.anniex.lite.container.AnnieXLiteContainer$annieLifeCycle$1] */
    public AnnieXLiteContainer(UIComponentBuilder uIComponentBuilder) {
        Intrinsics.checkNotNullParameter(uIComponentBuilder, "builder");
        this.builder = uIComponentBuilder;
        AnnieXLifecycleDispatcher annieXLifecycleDispatcher = new AnnieXLifecycleDispatcher();
        AbsAnnieXLifecycle lifecycle = uIComponentBuilder.getLifecycle();
        if (lifecycle != null) {
            annieXLifecycleDispatcher.addLifecycle(lifecycle);
        }
        this.lifecycleDispatcher = annieXLifecycleDispatcher;
        this.containerModel = LazyKt.lazy(new Function0<BDXContainerModel>() { // from class: com.bytedance.android.anniex.lite.container.AnnieXLiteContainer$containerModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BDXContainerModel m3346invoke() {
                return SchemaService.Companion.getInstance().generateSchemaModel(AnnieXLiteContainer.this.getAnnieXContext().getSchemaModelUnion().getSchemaData(), BDXContainerModel.class);
            }
        });
        this.currentBid = uIComponentBuilder.getBid();
        this.context = uIComponentBuilder.getSystemContext$anniex_release();
        this.annieXContext = LazyKt.lazy(new Function0<AnnieXContext>() { // from class: com.bytedance.android.anniex.lite.container.AnnieXLiteContainer$annieXContext$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AnnieXContext m3345invoke() {
                AnnieXContext createAnnieXContext;
                AnnieXLiteContainer annieXLiteContainer = AnnieXLiteContainer.this;
                createAnnieXContext = annieXLiteContainer.createAnnieXContext(annieXLiteContainer.getBuilder());
                return createAnnieXContext;
            }
        });
        this.engine = LazyKt.lazy(new Function0<IAnnieXEngineProxy>() { // from class: com.bytedance.android.anniex.lite.container.AnnieXLiteContainer$engine$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final IAnnieXEngineProxy m3347invoke() {
                IAnnieXEngineProxy createEngine;
                AnnieXLiteContainer annieXLiteContainer = AnnieXLiteContainer.this;
                createEngine = annieXLiteContainer.createEngine(annieXLiteContainer.getAnnieXContext());
                return createEngine;
            }
        });
        this.currentState = -1;
        this.stateBlockingQueue = new ArrayBlockingQueue<>(10);
        this.isNotRelease = true;
        this.annieLifeCycle = new AbsAnnieXLifecycle() { // from class: com.bytedance.android.anniex.lite.container.AnnieXLiteContainer$annieLifeCycle$1
            @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
            public void onKitViewCreate(String schema, IContainer container) {
                UIColorParam contentBgColor;
                Integer num;
                UIColorParam webBgColor;
                Integer num2;
                Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
                Intrinsics.checkNotNullParameter(container, "container");
                HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieXContainer", "===onKitViewCreate:  " + schema, (Map) null, (LoggerContext) null, 12, (Object) null);
                AnnieXLiteContainer.this.putState(1);
                AnnieXLiteContainer.this.putState(2);
                View kitView = container.getKitView();
                if (kitView != null) {
                    AnnieXLiteContainer annieXLiteContainer = AnnieXLiteContainer.this;
                    BDXContainerModel containerModel = annieXLiteContainer.getContainerModel();
                    if (containerModel != null && (webBgColor = containerModel.getWebBgColor()) != null && (num2 = (Integer) webBgColor.getValue()) != null) {
                        kitView.setBackgroundColor(num2.intValue());
                    }
                    BDXContainerModel containerModel2 = annieXLiteContainer.getContainerModel();
                    if (containerModel2 != null && (contentBgColor = containerModel2.getContentBgColor()) != null && (num = (Integer) contentBgColor.getValue()) != null) {
                        kitView.setBackgroundColor(num.intValue());
                    }
                }
                AnnieXLiteContainer.this.getLifecycleDispatcher().onKitViewCreate(AnnieXLiteContainer.this.getUrl(), AnnieXLiteContainer.this);
                AnnieXLiteContainer.this.bindWebOnScrollChangeListener();
            }

            @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
            public void onLoadStart(String schema, IContainer container) {
                Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
                Intrinsics.checkNotNullParameter(container, "container");
                HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieXContainer", "===onLoadStart:  " + schema, (Map) null, (LoggerContext) null, 12, (Object) null);
                AnnieXLiteContainer.this.putState(3);
                super.onLoadStart(schema, container);
            }

            @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
            public void onRuntimeReady(String schema, IContainer container) {
                Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
                Intrinsics.checkNotNullParameter(container, "container");
                HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieXContainer", "===onRuntimeReady:  " + schema, (Map) null, (LoggerContext) null, 12, (Object) null);
                AnnieXLiteContainer.this.putState(5);
                AnnieXLiteContainer.this.getLifecycleDispatcher().onRuntimeReady(AnnieXLiteContainer.this.getUrl(), AnnieXLiteContainer.this);
            }

            @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
            public void onKitViewDestroy(String schema, IContainer container) {
                Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
                Intrinsics.checkNotNullParameter(container, "container");
                HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieXContainer", "kit_view_destroy", MapsKt.mapOf(TuplesKt.to(StreamTrafficObservable.STREAM_URL, schema)), (LoggerContext) null, 8, (Object) null);
                AnnieXLiteContainer.this.putState(6);
                AnnieXLiteContainer.this.getLifecycleDispatcher().onKitViewDestroy(AnnieXLiteContainer.this.getUrl(), AnnieXLiteContainer.this);
            }

            @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
            public void onLoadSuccess(String schema, IContainer container) {
                Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
                Intrinsics.checkNotNullParameter(container, "container");
                AnnieXLiteContainer.this.loadSuccess = true;
                AnnieXLiteContainer.this.putState(4);
                AnnieXLiteContainer.this.getLifecycleDispatcher().onLoadSuccess(AnnieXLiteContainer.this.getUrl(), AnnieXLiteContainer.this);
            }

            @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
            public void onLoadFail(String schema, IContainer container, Throwable throwable) {
                Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
                Intrinsics.checkNotNullParameter(container, "container");
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                AnnieXLiteContainer.this.loadSuccess = false;
                AnnieXLiteContainer.this.putState(4);
                AnnieXLiteContainer.this.getLifecycleDispatcher().onLoadFail(AnnieXLiteContainer.this.getUrl(), AnnieXLiteContainer.this, throwable);
            }

            @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
            public void onFirstScreen(String schema, IContainer container) {
                Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
                Intrinsics.checkNotNullParameter(container, "container");
                AnnieXLiteContainer.this.getLifecycleDispatcher().onFirstScreen(schema, container);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AnnieXLifecycleDispatcher getLifecycleDispatcher() {
        return this.lifecycleDispatcher;
    }

    public final String getUrl() {
        UrlParam url;
        Uri uri;
        BDXContainerModel containerModel = getContainerModel();
        String uri2 = (containerModel == null || (url = containerModel.getUrl()) == null || (uri = (Uri) url.getValue()) == null) ? null : uri.toString();
        return uri2 == null ? "unknown" : uri2;
    }

    public final BDXContainerModel getContainerModel() {
        return (BDXContainerModel) this.containerModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context getContext() {
        return this.context;
    }

    public final AnnieXContext getAnnieXContext() {
        return (AnnieXContext) this.annieXContext.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final IAnnieXEngineProxy getEngine() {
        return (IAnnieXEngineProxy) this.engine.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ViewGroup getParentViewGroup() {
        ViewGroup viewGroup = this.parentViewGroup;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setParentViewGroup(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.parentViewGroup = viewGroup;
    }

    public final boolean getContainerVisible() {
        return this.containerVisible;
    }

    public final void setContainerVisible(boolean z) {
        this.containerVisible = z;
    }

    public Scenes getScenes() {
        return Scenes.LitePage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnnieXContext createAnnieXContext(UIComponentBuilder builder) {
        Uri uriByBundle = getUriByBundle(builder.getBundle());
        String orCreateAnnieXSessionID = IServiceContextKt.getOrCreateAnnieXSessionID(uriByBundle, builder.getBundle());
        SchemaModelUnion orCreateSchemaData = AnnieXProcessCenter.INSTANCE.getOrCreateSchemaData(this.currentBid, uriByBundle, orCreateAnnieXSessionID);
        String str = (String) orCreateSchemaData.getSchemaData().getQueryItems().get(StreamTrafficObservable.STREAM_URL);
        if (str == null) {
            str = uriByBundle.toString();
            Intrinsics.checkNotNullExpressionValue(str, "uri.toString()");
        }
        String str2 = str;
        AnnieXJSWorkerManager annieXJSWorkerManager = AnnieXJSWorkerManager.INSTANCE;
        Context applicationContext = this.context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        String uri = uriByBundle.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
        annieXJSWorkerManager.initInPage$anniex_release((Application) applicationContext, uri);
        Scenes scenes = getScenes();
        String str3 = this.currentBid;
        Bundle bundle = builder.getBundle();
        Uri parse = Uri.parse(str2);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(realUrl)");
        AnnieXContext annieXContext = new AnnieXContext(scenes, orCreateAnnieXSessionID, str3, bundle, str2, AnnieXLiteUtilsKt.getKitTypeFromSchema(parse), orCreateSchemaData);
        annieXContext.setContext(builder.getSystemContext$anniex_release());
        return annieXContext;
    }

    private final Uri getUriByBundle(Bundle bundle) {
        String string = bundle.getString("__x_inner_schema");
        Uri parse = string != null ? Uri.parse(string) : null;
        if (parse != null) {
            return parse;
        }
        Uri uri = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(uri, "EMPTY");
        return uri;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setUiComponent(UIComponent uiComponent) {
        Intrinsics.checkNotNullParameter(uiComponent, "uiComponent");
        this.uiComponent = uiComponent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAnnieXEngineProxy createEngine(AnnieXContext annieXContext) {
        if (annieXContext.getKitType() == KitType.LYNX) {
            return new AnnieXLynxEngineProxy(annieXContext, this);
        }
        if (IConditionCallKt.enableAnnieXLoadEngineExpFix() && StringsKt.contains$default(annieXContext.getOriginSchema(), "template.js", false, 2, (Object) null)) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "===createEngine Web error:" + annieXContext.getSchemaModelUnion().getSchemaData().getOriginUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        }
        return new AnnieXWebEngineProxy(annieXContext, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void putState(final int state) {
        if (this.parentViewGroup != null) {
            Context context = this.context;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.bytedance.android.anniex.lite.container.AnnieXLiteContainer$putState$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnnieXLiteContainer.this.changeState(state);
                    }
                });
                return;
            }
            return;
        }
        this.stateBlockingQueue.put(Integer.valueOf(state));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeState(int state) {
        BooleanParam showLoading;
        Boolean bool;
        this.currentState = state;
        if (state == 0) {
            transferToTargetState();
            initContainerColor();
            return;
        }
        if (state == 1) {
            if (Intrinsics.areEqual(getViewType(), AnnieX.CONTAINER_VIEW_TYPE_POPUP)) {
                Set<Map.Entry<String, WeakReference<IContainer>>> entrySet = AnnieX.INSTANCE.getAllContainer().entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet, "AnnieX.getAllContainer().entries");
                Iterator<T> it = entrySet.iterator();
                while (it.hasNext()) {
                    IContainer iContainer = (IContainer) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
                    if (iContainer != null && Intrinsics.areEqual(iContainer.getWeakContext().get(), this.context)) {
                        Intrinsics.checkNotNullExpressionValue(iContainer, "_container");
                        IContainer.DefaultImpls.onVisibleChange$default(iContainer, false, null, 2, null);
                    }
                }
            }
            AnnieXContainerManager.INSTANCE.addContainer(this);
            return;
        }
        if (state != 2) {
            if (state != 4) {
                if (state != 5) {
                    return;
                }
                this.isRuntimeReady = true;
                if (this.isResuming) {
                    getEngine().enterForeground();
                    return;
                }
                return;
            }
            if (this.loadSuccess) {
                HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "load success", (Map) null, (LoggerContext) null, 12, (Object) null);
                setContainerColor();
            } else {
                HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "load fail", (Map) null, (LoggerContext) null, 12, (Object) null);
                showError();
            }
            hideLoading();
            addTagView();
            return;
        }
        addKitView();
        BDXContainerModel containerModel = getContainerModel();
        if (containerModel == null || (showLoading = containerModel.getShowLoading()) == null || (bool = (Boolean) showLoading.getValue()) == null) {
            return;
        }
        if (!bool.booleanValue()) {
            bool = null;
        }
        if (bool != null) {
            bool.booleanValue();
            UIComponent uIComponent = this.uiComponent;
            if (uIComponent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
                uIComponent = null;
            }
            View createLoadingView = uIComponent.createLoadingView();
            this.loadingView = createLoadingView;
            if (createLoadingView != null) {
                ViewGroup.LayoutParams layoutParams = createLoadingView.getLayoutParams();
                FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.gravity = 17;
                }
                getParentViewGroup().addView(createLoadingView);
            }
            showLoading();
        }
    }

    private final void transferToTargetState() {
        while (!this.stateBlockingQueue.isEmpty()) {
            Integer take = this.stateBlockingQueue.take();
            Intrinsics.checkNotNullExpressionValue(take, "statue");
            changeState(take.intValue());
        }
    }

    private final void initContainerColor() {
        Drawable.ConstantState constantState;
        BDXContainerModel containerModel = getContainerModel();
        if (containerModel != null) {
            Integer num = (Integer) containerModel.getLoadingBgColor().getValue();
            if (num == null) {
                num = (Integer) containerModel.getContainerBgColor().getValue();
            }
            if (num != null) {
                int intValue = num.intValue();
                Drawable background = getParentViewGroup().getBackground();
                this.originBackground = (background == null || (constantState = background.getConstantState()) == null) ? null : constantState.newDrawable();
                this.useCustomBackground = true;
                getParentViewGroup().setBackgroundColor(intValue);
            }
        }
    }

    protected void addKitView() {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===addKitView: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        getParentViewGroup().removeAllViews();
        View enginView = getEngine().getEnginView();
        if (enginView != null) {
            getParentViewGroup().addView(enginView);
            Configuration configuration = this.context.getResources().getConfiguration();
            Intrinsics.checkNotNullExpressionValue(configuration, "context.resources.configuration");
            padAdaptation(enginView, configuration, true);
            this.lifecycleDispatcher.onAttachView(getUrl(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void initUi() {
        Object obj;
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===initUi: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        try {
            Result.Companion companion = Result.Companion;
            AnnieXLiteContainer annieXLiteContainer = this;
            observerKeyboardStatusChange();
            putState(0);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "initUi===>" + th2.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void observerKeyboardStatusChange() {
        if (Intrinsics.areEqual(getViewType(), AnnieX.CONTAINER_VIEW_TYPE_CARD)) {
            return;
        }
        Context context = this.context;
        final Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            SoftInputKt.setWindowSoftInput$default(activity, (View) null, (View) null, (View) null, 0, false, new Function1<Boolean, Unit>() { // from class: com.bytedance.android.anniex.lite.container.AnnieXLiteContainer$observerKeyboardStatusChange$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    if (z) {
                        int softInputHeight = SoftInputUtilKt.getSoftInputHeight(activity);
                        int px2Dp = (int) ResUtil.INSTANCE.px2Dp(SoftInputUtilKt.getSoftInputHeight(activity));
                        AnnieXLiteContainer annieXLiteContainer = this;
                        try {
                            Result.Companion companion = Result.Companion;
                            annieXLiteContainer.possiblyResizeChildOfContent(softInputHeight);
                            Result.constructor-impl(Unit.INSTANCE);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        this.sendKeyboardStatusChangeEvent(true, px2Dp);
                        return;
                    }
                    AnnieXLiteContainer annieXLiteContainer2 = this;
                    try {
                        Result.Companion companion3 = Result.Companion;
                        annieXLiteContainer2.possiblyResizeChildOfContent(0);
                        Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    this.sendKeyboardStatusChangeEvent(false, 0);
                }
            }, 31, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void possiblyResizeChildOfContent(int softHeight) {
        View rootView;
        int height;
        int height2;
        if (needAdapterKeyboard() && (height2 = (height = (rootView = getParentViewGroup().getRootView()).getHeight()) - softHeight) != this.usableHeightPrevious) {
            Intrinsics.checkNotNullExpressionValue(rootView, "decorView");
            View contentView = getContentView(rootView);
            ViewGroup.LayoutParams layoutParams = contentView != null ? contentView.getLayoutParams() : null;
            if (layoutParams != null) {
                if (softHeight > height / 4) {
                    layoutParams.height = height2;
                } else {
                    layoutParams.height = height;
                }
                contentView.requestLayout();
                this.usableHeightPrevious = height2;
            }
        }
    }

    private final View getContentView(View decorView) {
        View findViewById = decorView.findViewById(R.id.content);
        return findViewById instanceof ViewGroup ? (ViewGroup) findViewById : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendKeyboardStatusChangeEvent(boolean isShowing, int height) {
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put("visible", isShowing);
        jSONObject.put("height", height);
        sendEvent(new IEvent(jSONObject) { // from class: com.bytedance.android.anniex.lite.container.AnnieXLiteContainer$sendKeyboardStatusChangeEvent$1
            private final String name = "H5_keyboardStatusChange";
            private final JSONObject params;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.params = jSONObject;
            }

            public String getName() {
                return this.name;
            }

            public JSONObject getParams() {
                return this.params;
            }
        });
        sendEvent(new IEvent(jSONObject) { // from class: com.bytedance.android.anniex.lite.container.AnnieXLiteContainer$sendKeyboardStatusChangeEvent$2
            private final String name = "keyboardStatusChange";
            private final JSONObject params;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.params = jSONObject;
            }

            public String getName() {
                return this.name;
            }

            public JSONObject getParams() {
                return this.params;
            }
        });
    }

    private final boolean needAdapterKeyboard() {
        BooleanParam transStatusBar;
        BooleanParam hideStatusBar;
        IntegerParam softInputMode;
        Integer num;
        if (getEngine().getEnginView() instanceof LynxView) {
            return false;
        }
        BDXContainerModel containerModel = getContainerModel();
        int intValue = (containerModel == null || (softInputMode = containerModel.getSoftInputMode()) == null || (num = (Integer) softInputMode.getValue()) == null) ? 0 : num.intValue();
        if (intValue > -1) {
            return false;
        }
        if (!Intrinsics.areEqual(getViewType(), "page")) {
            return Intrinsics.areEqual(getViewType(), AnnieX.CONTAINER_VIEW_TYPE_POPUP) && intValue == -1;
        }
        BDXContainerModel containerModel2 = getContainerModel();
        if (!((containerModel2 == null || (hideStatusBar = containerModel2.getHideStatusBar()) == null) ? false : Intrinsics.areEqual(hideStatusBar.getValue(), true))) {
            BDXContainerModel containerModel3 = getContainerModel();
            if (!((containerModel3 == null || (transStatusBar = containerModel3.getTransStatusBar()) == null) ? false : Intrinsics.areEqual(transStatusBar.getValue(), true))) {
                return false;
            }
        }
        return intValue == -2;
    }

    private final void addTagView() {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===addTagView: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        DebugInfo debugInfo = DebugConfig.INSTANCE.get(this.currentBid);
        if (!showContainerTag(debugInfo)) {
            debugInfo = null;
        }
        if (debugInfo != null) {
            View inflate = LayoutInflater.from(this.context).inflate(C0840R.layout.bullet_debug_tag_view, getParentViewGroup(), false);
            DebugTagTextView debugTagTextView = inflate instanceof DebugTagTextView ? (DebugTagTextView) inflate : null;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388661;
            getParentViewGroup().addView((View) debugTagTextView, layoutParams);
        }
    }

    private final boolean showContainerTag(DebugInfo debugInfo) {
        return BulletEnv.Companion.getInstance().getDebuggable() && BulletEnv.Companion.getInstance().getShowTag() && debugInfo.getShowDebugTagView();
    }

    private final void setContainerColor() {
        BDXContainerModel containerModel = getContainerModel();
        if (containerModel != null) {
            IHostContextDepend hostContextDepend = XBaseRuntime.INSTANCE.getHostContextDepend();
            Unit unit = null;
            String skinName = hostContextDepend != null ? hostContextDepend.getSkinName() : null;
            if (skinName != null) {
                String lowerCase = skinName.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (Intrinsics.areEqual(lowerCase, "light")) {
                    Integer num = (Integer) containerModel.getContainerLightBgColor().getValue();
                    if (num != null) {
                        getParentViewGroup().setBackgroundColor(num.intValue());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        setBackgroundColor();
                        return;
                    }
                    return;
                }
                Integer num2 = (Integer) containerModel.getContainerDarkBgColor().getValue();
                if (num2 != null) {
                    getParentViewGroup().setBackgroundColor(num2.intValue());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    setBackgroundColor();
                    return;
                }
                return;
            }
            setBackgroundColor();
        }
    }

    private final void setBackgroundColor() {
        Unit unit;
        BDXContainerModel containerModel = getContainerModel();
        Intrinsics.checkNotNull(containerModel);
        Integer num = (Integer) containerModel.getContainerBgColor().getValue();
        if (num != null) {
            getParentViewGroup().setBackgroundColor(num.intValue());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null && this.useCustomBackground) {
            getParentViewGroup().setBackground(this.originBackground);
            this.useCustomBackground = false;
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        padAdaptation$default(this, getEngine().getEnginView(), newConfig, false, 4, null);
        updateLynxScreenMetrics();
    }

    private final void updateLynxScreenMetrics() {
        View enginView = getEngine().getEnginView();
        if (enginView != null) {
            boolean enableAdapterPad = BulletPadAdapterUtil.INSTANCE.enableAdapterPad(getAnnieXContext().getSchemaModelUnion(), Intrinsics.areEqual(getViewType(), "page") ? Scenes.AbsActivity : Scenes.PopupFragment, true);
            Integer num = this.padAdapterWidth;
            Integer num2 = this.padAdapterHeight;
            if (enableAdapterPad && num != null && num2 != null) {
                updateScreenMetrics(num.intValue(), num2.intValue());
                HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "updateLynxScreenMetrics : enableIpadAdapter " + enableAdapterPad + " , width " + num + " , height " + num2, (Map) null, (LoggerContext) null, 12, (Object) null);
                return;
            }
            Context context = enginView.getContext();
            if (context != null) {
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ScreenInfo screenInfo = ViewUtil.INSTANCE.getScreenInfo(context);
                if (screenInfo != null) {
                    updateScreenMetrics(screenInfo.getWidth(), screenInfo.getHeight());
                    HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "updateLynxScreenMetrics : enableIpadAdapter " + enableAdapterPad + " , width " + screenInfo.getWidth() + " , height " + screenInfo.getHeight(), (Map) null, (LoggerContext) null, 12, (Object) null);
                }
            }
        }
    }

    static /* synthetic */ void padAdaptation$default(AnnieXLiteContainer annieXLiteContainer, View view, Configuration configuration, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: padAdaptation");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        annieXLiteContainer.padAdaptation(view, configuration, z);
    }

    private final void padAdaptation(View view, Configuration configuration, boolean isKitViewCreate) {
        if (view == null) {
            return;
        }
        Scenes scenes = Intrinsics.areEqual(getViewType(), "page") ? Scenes.AbsActivity : Scenes.PopupFragment;
        if (BulletPadAdapterUtil.INSTANCE.enableAdapterPad(getAnnieXContext().getSchemaModelUnion(), scenes, true)) {
            if (isKitViewCreate) {
                BulletPadAdapterUtil.logPadAdaption$default(BulletPadAdapterUtil.INSTANCE, this.currentBid, this.context, getAnnieXContext().getSchemaModelUnion(), scenes, configuration, false, 32, (Object) null);
            }
            Pair padKitViewInfo$default = BulletPadAdapterUtil.getPadKitViewInfo$default(BulletPadAdapterUtil.INSTANCE, this.currentBid, this.context, getAnnieXContext().getSchemaModelUnion(), scenes, configuration, false, 32, (Object) null);
            Integer num = (Integer) padKitViewInfo$default.component1();
            Integer num2 = (Integer) padKitViewInfo$default.component2();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                if (num != null) {
                    layoutParams2.width = num.intValue();
                }
                if (num2 != null) {
                    layoutParams2.height = num2.intValue();
                }
                if (BulletPadAdapterUtil.INSTANCE.enablePageUniformStyle(getAnnieXContext().getSchemaModelUnion().getSchemaData(), scenes) || BulletPadAdapterUtil.INSTANCE.enablePageChannelStyle(getAnnieXContext().getSchemaModelUnion().getSchemaData(), scenes)) {
                    layoutParams2.gravity = 1;
                } else {
                    layoutParams2.gravity = 17;
                }
                view.setLayoutParams(layoutParams2);
                HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "kitView set size : width=" + num + ",height=" + num2, (Map) null, (LoggerContext) null, 12, (Object) null);
            }
            this.padAdapterWidth = BulletPadAdapterUtil.INSTANCE.getPadAdapterWidth();
            this.padAdapterHeight = BulletPadAdapterUtil.INSTANCE.getPadAdapterHeight();
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "padAdaptation : current scenes=" + getViewType() + ",padAdapterWidth=" + this.padAdapterWidth + ",padAdapterHeight=" + this.padAdapterHeight, (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void onVisibleChange(final boolean visible, Boolean hasReadySendVisibleEvent) {
        if (visible == this.containerVisible) {
            return;
        }
        this.containerVisible = visible;
        sendEvent(new IEvent() { // from class: com.bytedance.android.anniex.lite.container.AnnieXLiteContainer$onVisibleChange$1
            public String getName() {
                return "pageVisibilityChange";
            }

            public Object getParams() {
                UIComponent uIComponent;
                JSONObject jSONObject = new JSONObject();
                boolean z = visible;
                AnnieXLiteContainer annieXLiteContainer = this;
                jSONObject.put("visible", z);
                if (!Intrinsics.areEqual(annieXLiteContainer.getViewType(), AnnieX.CONTAINER_VIEW_TYPE_CARD)) {
                    uIComponent = annieXLiteContainer.uiComponent;
                    if (uIComponent == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
                        uIComponent = null;
                    }
                    jSONObject.put("source", uIComponent.isAppBackground() ? "app" : "page");
                }
                return jSONObject;
            }
        });
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    /* renamed from: getBid */
    public String getCurrentBid() {
        return getAnnieXContext().getBid();
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public String getContainerId() {
        return getAnnieXContext().getSessionId();
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public KitType getKitType() {
        return getAnnieXContext().getKitType();
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    /* renamed from: getCurrentUrl */
    public String getCurrentSchema() {
        return getAnnieXContext().getOriginSchema();
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public ISchemaData getSchemaData() {
        return getAnnieXContext().getSchemaModelUnion().getSchemaData();
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void loadSchema(String schema, Map<String, ? extends Object> renderData) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        loadSchema(schema, renderData, null, this.annieLifeCycle);
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void loadSchema(String schema, Map<String, ? extends Object> renderData, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        String sessionId = getAnnieXContext().getSessionId();
        if (sessionId != null) {
            MonitorManager.INSTANCE.onContainerCreateEnd(sessionId);
            SLMonitorCompat.INSTANCE.reportPV(sessionId, schema, SLMonitorCompat.ViewType.Page.getValue());
        }
        getEngine().loadSchema(schema, completeRenderData(renderData), mergeContext(contextProviderFactory), this.annieLifeCycle);
    }

    private final Map<String, Object> completeRenderData(Map<String, ? extends Object> renderData) {
        Map<String, Object> timeStampMap$anniex_release;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String sessionId = getAnnieXContext().getSessionId();
        if (sessionId != null && (timeStampMap$anniex_release = MonitorManager.INSTANCE.getTimeStampMap$anniex_release(sessionId)) != null) {
            linkedHashMap.putAll(timeStampMap$anniex_release);
            Object obj = timeStampMap$anniex_release.get("open_time");
            if (obj != null) {
                if (Intrinsics.areEqual(this.builder.getBid(), "webcast")) {
                    linkedHashMap.put("initTimestamp", obj.toString());
                } else {
                    linkedHashMap.put("containerInitTime", obj);
                }
            }
        }
        linkedHashMap.put(AnnieXConstants.ANNIEX_PAGE_TYPE_OPT, AnnieXConstants.LITE_PAGE);
        if (renderData != null) {
            linkedHashMap.putAll(renderData);
        }
        return linkedHashMap;
    }

    private final ContextProviderFactory mergeContext(ContextProviderFactory contextProviderFactory) {
        ContextProviderFactory contextProviderFactory2 = getAnnieXContext().getContextProviderFactory();
        if (contextProviderFactory != null) {
            contextProviderFactory2.merge(contextProviderFactory);
        }
        return contextProviderFactory2;
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public Context getSystemContext() {
        return this.context;
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public ISchemaData generateSchemaData(String schema) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        return getAnnieXContext().getSchemaModelUnion().getSchemaData();
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public ISchemaData getCurrentSchema() {
        return getAnnieXContext().getSchemaModelUnion().getSchemaData();
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void sendEvent(IEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        getEngine().sendEvent(event);
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void enterForeground() {
        this.isVisibility = true;
        getEngine().enterForeground();
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void enterBackground() {
        this.isVisibility = false;
        getEngine().enterBackground();
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void reload(Map<String, ? extends Object> renderData) {
        int i;
        if (this.loadSuccess && ((i = this.currentState) == 5 || i == 4)) {
            getEngine().reload();
        } else {
            loadSchema(getUrl(), renderData);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void release() {
        if (this.isNotRelease) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===release: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
            getEngine().release();
            getAnnieXContext().release();
            this.errorView = null;
            this.loadingView = null;
            this.noticeView = null;
            this.denyView = null;
            this.isNotRelease = false;
        }
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public View getKitView() {
        return getEngine().getEnginView();
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public <T> void registerWeakHolder(Class<T> clazz, T item) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ContextProviderFactory contextProviderFactory = getAnnieXContext().getContextProviderFactory();
        if (contextProviderFactory != null) {
            contextProviderFactory.registerWeakHolder(clazz, item);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void updateGlobalProps(Map<String, ? extends Object> globalProps) {
        Intrinsics.checkNotNullParameter(globalProps, "globalProps");
        getAnnieXContext().getMidProperties().putAll(globalProps);
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void updateData(Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
        getEngine().updateData(data);
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void updateData(String data) {
        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
        getEngine().updateData(data);
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public ContextProviderFactory getContextProviderFactory() {
        return getAnnieXContext().getContextProviderFactory();
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void updateScreenMetrics(int width, int height) {
        getEngine().updateScreenMetrics(width, height);
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public Map<String, Long> getPerfMap() {
        return new LinkedHashMap();
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public WeakReference<Context> getWeakContext() {
        return new WeakReference<>(getAnnieXContext().getContext());
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    /* renamed from: isVisibility, reason: from getter */
    public boolean getIsVisibility() {
        return this.isVisibility;
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void interceptBackPress(boolean enable) {
        BDXContainerModel containerModel = getContainerModel();
        if (containerModel != null) {
            containerModel.setBlockBackPress(new BooleanParam(Boolean.valueOf(enable)));
        }
        UIComponent uIComponent = this.uiComponent;
        if (uIComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
            uIComponent = null;
        }
        uIComponent.interceptBackPress(enable);
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void showError() {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===showError: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        if (this.errorView == null && this.isNotRelease) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "create error view", (Map) null, (LoggerContext) null, 12, (Object) null);
            UIComponent uIComponent = this.uiComponent;
            if (uIComponent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
                uIComponent = null;
            }
            this.errorView = uIComponent.createErrorView();
        }
        View view = this.errorView;
        if (view != null) {
            getParentViewGroup().addView(view);
            view.setVisibility(0);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void showLoading() {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===showLoading: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        ILoadingView iLoadingView = this.loadingView;
        if (!(iLoadingView instanceof ILoadingView)) {
            if (iLoadingView == null) {
                return;
            }
            iLoadingView.setVisibility(0);
        } else {
            ILoadingView iLoadingView2 = iLoadingView instanceof ILoadingView ? iLoadingView : null;
            if (iLoadingView2 != null) {
                iLoadingView2.show();
            }
        }
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void hideLoading() {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===hideLoading: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        ILoadingView iLoadingView = this.loadingView;
        if (!(iLoadingView instanceof ILoadingView)) {
            if (iLoadingView == null) {
                return;
            }
            iLoadingView.setVisibility(8);
        } else {
            ILoadingView iLoadingView2 = iLoadingView instanceof ILoadingView ? iLoadingView : null;
            if (iLoadingView2 != null) {
                iLoadingView2.hide();
            }
        }
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void close() {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===close: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        if (this.isNotRelease) {
            UIComponent uIComponent = this.uiComponent;
            if (uIComponent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
                uIComponent = null;
            }
            uIComponent.close();
        }
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public String getBDXTag() {
        return (String) new StringParam(getAnnieXContext().getSchemaModelUnion().getSchemaData(), "bdx_tag", (String) null).getValue();
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public LaunchMode getBDXLaunchMode() {
        LaunchMode launchMode = (LaunchMode) new LaunchModeParam(getAnnieXContext().getSchemaModelUnion().getSchemaData(), "bdx_launch_mode", (LaunchMode) null).getValue();
        return launchMode == null ? LaunchMode.MODE_UNSPECIFIED : launchMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindWebOnScrollChangeListener() {
        if (getKitView() instanceof SSWebView) {
            SSWebView kitView = getKitView();
            Intrinsics.checkNotNull(kitView, "null cannot be cast to non-null type com.bytedance.ies.bullet.kit.web.SSWebView");
            kitView.setWebScrollListener(new SSWebView.WebScrollListener() { // from class: com.bytedance.android.anniex.lite.container.AnnieXLiteContainer$bindWebOnScrollChangeListener$1
                public void onScrollChanged(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    AnnieXLiteContainer.this.onWebScrollChanged(scrollX, scrollY, oldScrollX, oldScrollY);
                }
            });
        }
    }
}
