package com.bytedance.android.anniex.container;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import coil3.disk.DiskLruCache;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.ability.EventHelper;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.builder.UIComponentBuilder;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.UIComponent;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.base.depend.DeviceDepend;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.base.lifecycle.AnnieXLynxViewClientProxy;
import com.bytedance.android.anniex.base.lifecycle.AnnieXWebViewClientProxy;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.container.util.ResUtil;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompatKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.api.params.ArgusContainerCreateType;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputUtilKt;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletContainerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.core.common.DebugConfig;
import com.bytedance.ies.bullet.core.common.DebugInfo;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.device.BulletDeviceUtils;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.core.util.ContextUtil;
import com.bytedance.ies.bullet.deprecate.fake.ContainerBidParam;
import com.bytedance.ies.bullet.deprecate.fake.ForestSessionId;
import com.bytedance.ies.bullet.forest.ForestPreloadHelper;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapterKt;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IErrorView;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.ILoadingView;
import com.bytedance.ies.bullet.service.base.IPreRenderServiceKt;
import com.bytedance.ies.bullet.service.base.api.BaseServiceContext;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.api.IServiceCenter;
import com.bytedance.ies.bullet.service.base.api.IServiceContext;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaModelTransformer;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.sdk.SchemaConfig;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.ies.bullet.service.sdk.param.LaunchModeParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import com.bytedance.ies.bullet.ui.common.DebugTagTextView;
import com.bytedance.ies.bullet.ui.common.loader.BulletContainerLoader;
import com.bytedance.ies.bullet.ui.common.utils.BulletPadAdapterUtil;
import com.bytedance.ies.bullet.ui.common.utils.ScreenInfo;
import com.bytedance.ies.bullet.ui.common.utils.ViewUtil;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxInitDataWrapper;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.service.IContainerInstance;
import com.bytedance.ttwebview.TTWebPredictor;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.Deprecated;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: AnnieXContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ç\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0003\u0016\u001bA\b!\u0018\u0000 \u009c\u00022\u00020\u0001:\u0002\u009c\u0002B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0088\u0001\u001a\u00020`H\u0002J\t\u0010\u0089\u0001\u001a\u00020`H\u0002J\u0012\u0010\u008a\u0001\u001a\u00020`2\u0007\u0010\u008b\u0001\u001a\u00020\u0006H\u0016J\u001f\u0010\u008c\u0001\u001a\u00020`2\u0007\u0010\u008d\u0001\u001a\u0002082\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0014H\u0002J\t\u0010\u008f\u0001\u001a\u00020`H\u0002J\t\u0010\u0090\u0001\u001a\u00020$H\u0016J\u0012\u0010\u0091\u0001\u001a\u00020$2\u0007\u0010\u0092\u0001\u001a\u00020\u0006H\u0002J\t\u0010\u0093\u0001\u001a\u00020$H\u0016J\u0012\u0010\u0094\u0001\u001a\u00020`2\u0007\u0010\u0095\u0001\u001a\u000202H\u0002J\t\u0010\u0096\u0001\u001a\u00020`H\u0016J\t\u0010\u0097\u0001\u001a\u00020`H\u0002J\u0012\u0010\u0098\u0001\u001a\u00020`2\u0007\u0010\u008d\u0001\u001a\u000208H\u0002J\t\u0010\u0099\u0001\u001a\u00020`H\u0016J\t\u0010\u009a\u0001\u001a\u00020`H\u0016J\u0013\u0010\u009b\u0001\u001a\u00030\u009c\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u0006H\u0016J\f\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0002J\u0011\u0010 \u0001\u001a\u0004\u0018\u00010 H\u0000¢\u0006\u0003\b¡\u0001J\n\u0010¢\u0001\u001a\u00030£\u0001H\u0016J\u000b\u0010¤\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\t\u0010¥\u0001\u001a\u00020\u0006H\u0016J\t\u0010¦\u0001\u001a\u00020\u0006H\u0016J\u0013\u0010§\u0001\u001a\u0004\u0018\u00010:2\u0006\u00109\u001a\u00020:H\u0002J\u000b\u0010¨\u0001\u001a\u0004\u0018\u00010.H\u0016J\f\u0010©\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0016J\t\u0010ª\u0001\u001a\u00020\u0006H\u0016J\n\u0010«\u0001\u001a\u00030¬\u0001H\u0016J\n\u0010\u00ad\u0001\u001a\u00030¬\u0001H\u0002J\u000b\u0010®\u0001\u001a\u0004\u0018\u00010:H\u0016J\u0007\u0010¯\u0001\u001a\u000202J\t\u0010°\u0001\u001a\u000200H\u0002J\u0015\u0010±\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002000yH\u0017J\t\u0010²\u0001\u001a\u000202H\u0007J\f\u0010³\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0016J\t\u0010´\u0001\u001a\u00020\u0006H\u0002J\t\u0010µ\u0001\u001a\u00020\u0006H\u0002J\u0007\u0010¶\u0001\u001a\u000202J\t\u0010·\u0001\u001a\u00020*H\u0016J\u0007\u0010¸\u0001\u001a\u00020\u0006J\t\u0010¹\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010º\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010*0»\u0001H\u0016J\t\u0010¼\u0001\u001a\u00020`H\u0016J\u0007\u0010½\u0001\u001a\u00020$J\u0007\u0010¾\u0001\u001a\u00020$J\t\u0010¿\u0001\u001a\u00020`H\u0002J\t\u0010À\u0001\u001a\u00020`H\u0016J\t\u0010Á\u0001\u001a\u00020`H\u0017J\t\u0010Â\u0001\u001a\u00020`H\u0002J\t\u0010Ã\u0001\u001a\u00020`H\u0002J\u001b\u0010Ä\u0001\u001a\u00020\u000e2\u0007\u0010\u0092\u0001\u001a\u00020\u00062\u0007\u0010Å\u0001\u001a\u00020\u0006H\u0002J\t\u0010Æ\u0001\u001a\u00020`H\u0004J\u0012\u0010Ç\u0001\u001a\u00020`2\u0007\u0010È\u0001\u001a\u00020$H\u0016J\u001f\u0010É\u0001\u001a\u00020$2\u0014\u0010x\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020H\u0018\u00010GH\u0002J\u0007\u0010Ê\u0001\u001a\u00020$J\u0007\u0010Ë\u0001\u001a\u00020$J\b\u0010M\u001a\u00020$H\u0016J\t\u0010Ì\u0001\u001a\u00020$H\u0002J)\u0010Í\u0001\u001a\u00020`2\u0007\u0010\u009d\u0001\u001a\u00020\u00062\u0015\u0010Î\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020H\u0018\u00010yH\u0016J\t\u0010Ï\u0001\u001a\u00020$H\u0002J\t\u0010Ð\u0001\u001a\u00020`H\u0016J\t\u0010Ñ\u0001\u001a\u00020`H\u0002J\t\u0010Ò\u0001\u001a\u00020`H\u0002J\t\u0010Ó\u0001\u001a\u00020`H\u0016J\u0013\u0010Ô\u0001\u001a\u00020`2\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0016J'\u0010×\u0001\u001a\u00020`2\u0006\u0010E\u001a\u00020\u00062\u0014\u0010x\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020H\u0018\u00010GH\u0002J'\u0010Ø\u0001\u001a\u00020`2\u0006\u0010c\u001a\u0002022\u0014\u0010x\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020H\u0018\u00010GH\u0002JQ\u0010Ù\u0001\u001a\u00020`2\u0007\u0010Ú\u0001\u001a\u0002022\u0007\u0010Û\u0001\u001a\u0002022\u0007\u0010Ü\u0001\u001a\u0002022\u0007\u0010Ý\u0001\u001a\u0002022\u0007\u0010Þ\u0001\u001a\u0002022\u0007\u0010ß\u0001\u001a\u0002022\u0007\u0010à\u0001\u001a\u0002022\u0007\u0010á\u0001\u001a\u000202H\u0002J#\u0010â\u0001\u001a\u00020`2\u0007\u0010ã\u0001\u001a\u00020$2\t\u0010ä\u0001\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0003\u0010å\u0001J \u0010æ\u0001\u001a\u00020`2\n\u0010ç\u0001\u001a\u0005\u0018\u00010è\u00012\t\u0010é\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J-\u0010ê\u0001\u001a\u00020`2\u0007\u0010ë\u0001\u001a\u0002022\u0007\u0010ì\u0001\u001a\u0002022\u0007\u0010í\u0001\u001a\u0002022\u0007\u0010î\u0001\u001a\u000202H\u0016J)\u0010ï\u0001\u001a\u00020`2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00142\b\u0010ð\u0001\u001a\u00030Ö\u00012\t\b\u0002\u0010ñ\u0001\u001a\u00020$H\u0002J\t\u0010ò\u0001\u001a\u00020`H\u0014J\u0012\u0010ó\u0001\u001a\u00020`2\u0007\u0010ô\u0001\u001a\u000202H\u0002J\t\u0010õ\u0001\u001a\u00020`H\u0016J\u0012\u0010ö\u0001\u001a\u00020`2\u0007\u0010\u009d\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010÷\u0001\u001a\u00020`2\u0007\u0010\u0095\u0001\u001a\u000202H\u0002J1\u0010ø\u0001\u001a\u00020`\"\u0005\b\u0000\u0010ù\u00012\u000f\u0010ú\u0001\u001a\n\u0012\u0005\u0012\u0003Hù\u00010û\u00012\b\u0010ü\u0001\u001a\u0003Hù\u0001H\u0016¢\u0006\u0003\u0010ý\u0001J\t\u0010þ\u0001\u001a\u00020`H\u0016J \u0010ÿ\u0001\u001a\u00020`2\u0015\u0010Î\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020H\u0018\u00010yH\u0016J\"\u0010\u0080\u0002\u001a\u00020`2\u0017\u0010\u0081\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010H\u0018\u00010yH\u0016J\u0012\u0010\u0082\u0002\u001a\u00020`2\u0007\u0010\u0083\u0002\u001a\u00020pH\u0016J\u001b\u0010\u0084\u0002\u001a\u00020`2\u0007\u0010\u0085\u0002\u001a\u00020$2\u0007\u0010\u0086\u0002\u001a\u000202H\u0002J\t\u0010\u0087\u0002\u001a\u00020`H\u0002J\t\u0010\u0088\u0002\u001a\u00020`H\u0002J\t\u0010\u0089\u0002\u001a\u00020`H\u0002J\t\u0010\u008a\u0002\u001a\u00020`H\u0002J\t\u0010\u008b\u0002\u001a\u00020`H\u0002J\u0012\u0010\u008c\u0002\u001a\u00020`2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0004J\u0013\u0010\u008d\u0002\u001a\u00020$2\b\u0010\u008e\u0002\u001a\u00030\u008f\u0002H\u0002J\t\u0010\u0090\u0002\u001a\u00020`H\u0002J\t\u0010\u0091\u0002\u001a\u00020`H\u0016J\t\u0010\u0092\u0002\u001a\u00020`H\u0017J\t\u0010\u0093\u0002\u001a\u00020`H\u0002J\t\u0010\u0094\u0002\u001a\u00020$H\u0002J\t\u0010\u0095\u0002\u001a\u00020`H\u0002J\u0012\u0010\u0096\u0002\u001a\u00020`2\u0007\u0010\u0097\u0002\u001a\u00020\u0006H\u0016J\u001e\u0010\u0096\u0002\u001a\u00020`2\u0013\u0010\u0097\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020H0yH\u0016J\u001d\u0010\u0098\u0002\u001a\u00020`2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020H0yH\u0016J\t\u0010\u0099\u0002\u001a\u00020`H\u0002J\u001b\u0010\u009a\u0002\u001a\u00020`2\u0007\u0010\u009b\u0002\u001a\u0002022\u0007\u0010\u0086\u0002\u001a\u000202H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0004\n\u0002\u00103R\u0012\u00104\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0004\n\u0002\u00103R\u000e\u00105\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b;\u0010<R\u0010\u0010?\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010BR\u0010\u0010C\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020H0GX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010T\u001a\u0004\u0018\u00010:X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010<\"\u0004\bV\u0010WR\u001b\u0010X\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010>\u001a\u0004\bZ\u0010[R\u0010\u0010]\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010^\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020`0_X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u000e\u0010c\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u0004\u0018\u00010eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010f\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0004\n\u0002\u00103R\u0012\u0010g\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0004\n\u0002\u00103R\u001a\u0010h\u001a\u00020iX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR2\u0010n\u001a&\u0012\f\u0012\n q*\u0004\u0018\u00010p0p q*\u0012\u0012\f\u0012\n q*\u0004\u0018\u00010p0p\u0018\u00010r0oX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010s\u001a\u0004\u0018\u00010:X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010<\"\u0004\bu\u0010WR\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010x\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020H\u0018\u00010yX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020{X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010|\u001a\b\u0012\u0004\u0012\u0002020}X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u007f\u001a\u00030\u0080\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0087\u0001\u0010>\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006\u009d\u0002"}, d2 = {"Lcom/bytedance/android/anniex/container/AnnieXContainer;", "Lcom/bytedance/android/anniex/base/container/IContainer;", "builder", "Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "(Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;)V", "__containerId", "", "annieXLynxViewClientProxy", "Lcom/bytedance/android/anniex/base/lifecycle/AnnieXLynxViewClientProxy;", "annieXWebViewClientProxy", "Lcom/bytedance/android/anniex/base/lifecycle/AnnieXWebViewClientProxy;", "getBuilder", "()Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getBulletContext", "()Lcom/bytedance/ies/bullet/core/BulletContext;", "setBulletContext", "(Lcom/bytedance/ies/bullet/core/BulletContext;)V", "bulletKitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "bulletLifecycle", "com/bytedance/android/anniex/container/AnnieXContainer$bulletLifecycle$1", "Lcom/bytedance/android/anniex/container/AnnieXContainer$bulletLifecycle$1;", "bundle", "Landroid/os/Bundle;", "containerInstance", "com/bytedance/android/anniex/container/AnnieXContainer$containerInstance$1", "Lcom/bytedance/android/anniex/container/AnnieXContainer$containerInstance$1;", "containerLoader", "Lcom/bytedance/ies/bullet/ui/common/loader/BulletContainerLoader;", "containerModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXContainerModel;", "getContainerModel", "()Lcom/bytedance/ies/bullet/service/schema/model/BDXContainerModel;", "containerVisible", "", "getContainerVisible", "()Z", "setContainerVisible", "(Z)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "createViewTime", "", "curHorizontalBreakPoint", "", "Ljava/lang/Integer;", "curVerticalBreakPoint", "currentBid", "currentSchema", "currentUri", "Landroid/net/Uri;", "decorView", "Landroid/view/View;", "getDecorView", "()Landroid/view/View;", "decorView$delegate", "Lkotlin/Lazy;", "denyView", "deprecatedBulletContainer", "com/bytedance/android/anniex/container/AnnieXContainer$deprecatedBulletContainer$1", "Lcom/bytedance/android/anniex/container/AnnieXContainer$deprecatedBulletContainer$1;", "errorView", "errorViewAdded", "foldStatus", "globalProps", "", "", "isNotRelease", "isResuming", "isRootViewFirstLayout", "isRuntimeReady", "isVisibility", "isWebViewScrollReachTop", "kitViewHasBinded", "lifecycleDispatcher", "Lcom/bytedance/android/anniex/container/AnnieXLifecycleDispatcher;", "loadSuccess", "loadingView", "lynxWithScrollView", "getLynxWithScrollView$anniex_release", "setLynxWithScrollView$anniex_release", "(Landroid/view/View;)V", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "noticeView", "onSoftInputChangeListener", "Lkotlin/Function1;", "", "getOnSoftInputChangeListener$anniex_release", "()Lkotlin/jvm/functions/Function1;", "orientation", "originBackground", "Landroid/graphics/drawable/Drawable;", "padAdapterHeight", "padAdapterWidth", "parentViewGroup", "Landroid/view/ViewGroup;", "getParentViewGroup", "()Landroid/view/ViewGroup;", "setParentViewGroup", "(Landroid/view/ViewGroup;)V", "pendingEvent", "", "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "kotlin.jvm.PlatformType", "", "rootView", "getRootView", "setRootView", "rootViewLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "screenProps", "", "serviceContext", "Lcom/bytedance/ies/bullet/service/base/api/BaseServiceContext;", "stateBlockingQueue", "Ljava/util/concurrent/ArrayBlockingQueue;", "synchronizedObj", "uiComponent", "Lcom/bytedance/android/anniex/base/container/UIComponent;", "usableHeightPrevious", "useCustomBackground", "windowInsetsCompat", "Landroidx/core/view/WindowInsetsCompat;", "getWindowInsetsCompat", "()Landroidx/core/view/WindowInsetsCompat;", "windowInsetsCompat$delegate", "addKitView", "addTagView", "bindContainerId", "containerId", "bindKitView", "uri", "kitView", "bindWebOnScrollChangeListener", "canBackPress", "canCreateNormalBulletContext", "schemaUri", "canGoBack", "changeState", StrategyConstants.STATE, "close", "closeCurrentPageWhenAfterPageOpen", "createModel", "enterBackground", "enterForeground", "generateSchemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", StrategyConstants.SCHEMA, "getActivity", "Landroid/app/Activity;", "getAnnieXContainerModel", "getAnnieXContainerModel$anniex_release", "getBDXLaunchMode", "Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "getBDXTag", "getBid", "getContainerId", "getContentView", "getContextProviderFactory", "getCurrentSchema", "getCurrentUrl", "getKitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitTypeWithSchema", "getKitView", "getNavigationBarHeight", "getOpenTime", "getPerfMap", "getRealNavigationBarHeight", "getSchemaData", "getSchemaWithBundle", "getSessionIdWithBundle", "getStatusBarHeight", "getSystemContext", "getUrl", "getViewType", "getWeakContext", "Ljava/lang/ref/WeakReference;", "goBack", "hasStatusBar", "hasSystemNavBar", "hideDeny", "hideError", "hideLoading", "hideNotice", "initContainerColor", "initOrGetBulletContext", "sessionId", "initUi", "interceptBackPress", StrategyConstants.ENABLE, "isBreakPointChange", "isKitViewScrollReachTop", "isPadOrFold", "kitViewCreateOpt", "loadSchema", "renderData", "needAdapterKeyboard4Web", "observerKeyboardStatusChange", "observerKitViewLayoutChanged", "observerRootViewLayoutChanged", "onAttachToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onFoldStatusChanged", "onOrientationChanged", "onRootViewLayoutChanged", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onVisibleChange", "visible", "hasReadySendVisibleEvent", "(ZLjava/lang/Boolean;)V", "onWebPageFinish", "view", "Landroid/webkit/WebView;", StreamTrafficObservable.STREAM_URL, "onWebScrollChanged", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "padAdaptation", "configuration", "isKitViewCreate", "parseSchema", "possiblyResizeChildOfContent4Web", "softHeight", "postFirstVisibleEvent", "preloadSchema", "putState", "registerWeakHolder", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "item", "(Ljava/lang/Class;Ljava/lang/Object;)V", "release", "reload", "reloadTemplate", "templateData", "sendEvent", NotificationCompat.CATEGORY_EVENT, "sendKeyboardStatusChangeEvent", "isShowing", "height", "sendPendingEvent", "sendWindowSizeEvent", "setBackgroundColor", "setContainerColor", "setSecureInfo", "setUiComponent", "showContainerTag", "debugInfo", "Lcom/bytedance/ies/bullet/core/common/DebugInfo;", "showDeny", "showError", "showLoading", "showNotice", "supportScreenProps", "transferToTargetState", "updateData", Constants.KEY_DATA, "updateGlobalProps", "updateLynxScreenMetrics", "updateScreenMetrics", "width", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class AnnieXContainer implements IContainer {
    private static final String DEFAULT_UNKNOWN = "unknown";
    private static final int LOAD_RUNTIME_READY = 4;
    private static final int LOAD_STATUS_CREATE_KIT_VIEW = 2;
    private static final int LOAD_STATUS_FINISH = 3;
    private static final int LOAD_STATUS_INIT_UI = 0;
    private static final int LOAD_STATUS_PARSE_SCHEMA = 1;
    private static final int LOAD_STATUS_UNKNOWN = -1;
    private static final String TAG = "AnnieXContainer";
    private static final String VISIBLE_CHANGE_TYPE_APP = "app";
    private static final String VISIBLE_CHANGE_TYPE_PAGE = "page";
    private String __containerId;
    private final AnnieXLynxViewClientProxy annieXLynxViewClientProxy;
    private final AnnieXWebViewClientProxy annieXWebViewClientProxy;
    private final UIComponentBuilder builder;
    private BulletContext bulletContext;
    private IKitViewService bulletKitView;
    private AnnieXContainer$bulletLifecycle$1 bulletLifecycle;
    private final Bundle bundle;
    private final AnnieXContainer$containerInstance$1 containerInstance;
    private final BulletContainerLoader containerLoader;
    private volatile boolean containerVisible;
    private final Context context;
    private final ContextProviderFactory contextProviderFactory;
    private long createViewTime;
    private Integer curHorizontalBreakPoint;
    private Integer curVerticalBreakPoint;
    private String currentBid;
    private String currentSchema;
    private Uri currentUri;

    /* renamed from: decorView$delegate, reason: from kotlin metadata */
    private final Lazy decorView;
    private View denyView;
    private final AnnieXContainer$deprecatedBulletContainer$1 deprecatedBulletContainer;
    private View errorView;
    private boolean errorViewAdded;
    private String foldStatus;
    private final Map<String, Object> globalProps;
    private boolean isNotRelease;
    private boolean isResuming;
    private boolean isRootViewFirstLayout;
    private boolean isRuntimeReady;
    private volatile boolean isVisibility;
    private boolean isWebViewScrollReachTop;
    private boolean kitViewHasBinded;
    private final AnnieXLifecycleDispatcher lifecycleDispatcher;
    private boolean loadSuccess;
    private View loadingView;
    private View lynxWithScrollView;

    /* renamed from: mainHandler$delegate, reason: from kotlin metadata */
    private final Lazy mainHandler;
    private View noticeView;
    private final Function1<Boolean, Unit> onSoftInputChangeListener;
    private int orientation;
    private Drawable originBackground;
    private Integer padAdapterHeight;
    private Integer padAdapterWidth;
    protected ViewGroup parentViewGroup;
    private final List<IEvent> pendingEvent;
    private View rootView;
    private View.OnLayoutChangeListener rootViewLayoutListener;
    private Map<String, ? extends Object> screenProps;
    private final BaseServiceContext serviceContext;
    private ArrayBlockingQueue<Integer> stateBlockingQueue;
    private final Object synchronizedObj;
    private UIComponent uiComponent;
    private int usableHeightPrevious;
    private boolean useCustomBackground;

    /* renamed from: windowInsetsCompat$delegate, reason: from kotlin metadata */
    private final Lazy windowInsetsCompat;

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public String getViewType() {
        return AnnieX.CONTAINER_VIEW_TYPE_CARD;
    }

    public void onWebPageFinish(WebView view, String url) {
    }

    public void onWebScrollChanged(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
    }

    public void postFirstVisibleEvent() {
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [com.bytedance.android.anniex.container.AnnieXContainer$containerInstance$1] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.bytedance.android.anniex.container.AnnieXContainer$deprecatedBulletContainer$1] */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.bytedance.android.anniex.container.AnnieXContainer$bulletLifecycle$1] */
    public AnnieXContainer(UIComponentBuilder uIComponentBuilder) {
        Intrinsics.checkNotNullParameter(uIComponentBuilder, "builder");
        this.builder = uIComponentBuilder;
        this.bundle = uIComponentBuilder.getBundle();
        this.contextProviderFactory = uIComponentBuilder.getContextProviderFactory();
        this.globalProps = uIComponentBuilder.getGlobalProps$anniex_release();
        AnnieXLifecycleDispatcher annieXLifecycleDispatcher = new AnnieXLifecycleDispatcher();
        AbsAnnieXLifecycle lifecycle = uIComponentBuilder.getLifecycle();
        if (lifecycle != null) {
            annieXLifecycleDispatcher.addLifecycle(lifecycle);
        }
        this.lifecycleDispatcher = annieXLifecycleDispatcher;
        Context systemContext$anniex_release = uIComponentBuilder.getSystemContext$anniex_release();
        this.context = systemContext$anniex_release;
        this.currentBid = uIComponentBuilder.getBid();
        this.currentSchema = "";
        Uri uri = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(uri, "EMPTY");
        this.currentUri = uri;
        IServiceContext baseServiceContext = new BaseServiceContext(systemContext$anniex_release, BulletEnv.Companion.getInstance().getDebuggable());
        this.serviceContext = baseServiceContext;
        this.isWebViewScrollReachTop = true;
        this.bulletContext = initOrGetBulletContext(getSchemaWithBundle(), getSessionIdWithBundle());
        this.annieXLynxViewClientProxy = new AnnieXLynxViewClientProxy(this, uIComponentBuilder.getLynxViewClient());
        this.annieXWebViewClientProxy = new AnnieXWebViewClientProxy(this, uIComponentBuilder.getWebViewClient());
        this.containerInstance = new IContainerInstance() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$containerInstance$1
            public String sessionId() {
                return AnnieXContainer.this.getContainerId();
            }

            public Context context() {
                return AnnieXContainer.this.getContext();
            }

            public String bid() {
                String str;
                str = AnnieXContainer.this.currentBid;
                return str;
            }

            public View view() {
                IKitViewService iKitViewService;
                iKitViewService = AnnieXContainer.this.bulletKitView;
                if (iKitViewService != null) {
                    return iKitViewService.realView();
                }
                return null;
            }

            public Uri uri() {
                Uri uri2;
                uri2 = AnnieXContainer.this.currentUri;
                return uri2;
            }

            public void sendEvent(final String eventName, final Object params) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                AnnieXContainer.this.sendEvent(new IEvent(eventName, params) { // from class: com.bytedance.android.anniex.container.AnnieXContainer$containerInstance$1$sendEvent$1
                    private final String name;
                    private final Object params;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.name = eventName;
                        this.params = params;
                    }

                    public String getName() {
                        return this.name;
                    }

                    public Object getParams() {
                        return this.params;
                    }
                });
            }
        };
        this.deprecatedBulletContainer = new IBulletContainer.Base() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$deprecatedBulletContainer$1
            private final ContextProviderFactory providerFactory;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                ContextProviderFactory contextProviderFactory;
                contextProviderFactory = AnnieXContainer.this.contextProviderFactory;
                this.providerFactory = contextProviderFactory;
            }

            public ContextProviderFactory getProviderFactory() {
                return this.providerFactory;
            }

            public <T extends IBulletService> T getBulletService(Class<T> clazz) {
                String str;
                Intrinsics.checkNotNullParameter(clazz, "clazz");
                IServiceCenter instance = ServiceCenter.Companion.instance();
                str = AnnieXContainer.this.currentBid;
                return (T) instance.get(str, clazz);
            }

            public BulletContext getBulletContext() {
                return AnnieXContainer.this.getBulletContext();
            }

            public Uri getCurrentUri() {
                Uri uri2;
                uri2 = AnnieXContainer.this.currentUri;
                return uri2;
            }

            public Uri getProcessingUri() {
                Uri uri2;
                uri2 = AnnieXContainer.this.currentUri;
                return uri2;
            }

            public IKitViewService getKitView() {
                IKitViewService iKitViewService;
                iKitViewService = AnnieXContainer.this.bulletKitView;
                return iKitViewService;
            }

            public String getSessionId() {
                return AnnieXContainer.this.getContainerId();
            }

            public void onEvent(IEvent event) {
                Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
                AnnieXContainer.this.sendEvent(event);
            }
        };
        this.bulletLifecycle = new IBulletLifeCycle.Base() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$bulletLifecycle$1
            public void onLoadModelSuccess(Uri uri2, IKitViewService kitView, SchemaModelUnion schemaModelUnion) {
                Intrinsics.checkNotNullParameter(uri2, "uri");
                Intrinsics.checkNotNullParameter(schemaModelUnion, "schemaModelUnion");
                AnnieXContainer.this.getBulletContext().getMonitorCallback().getBulletCallback().onLoadModelSuccess(uri2, kitView, schemaModelUnion);
            }

            public void onKitViewCreate(Uri uri2, IKitViewService kitView) {
                Intrinsics.checkNotNullParameter(uri2, "uri");
                AnnieXContainer.this.bindKitView(uri2, kitView);
                AnnieXContainer.this.observerKitViewLayoutChanged();
            }

            public void onRuntimeReady(Uri uri2, IKitViewService kitView) {
                AnnieXLifecycleDispatcher annieXLifecycleDispatcher2;
                String str;
                Intrinsics.checkNotNullParameter(uri2, "uri");
                HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieXContainer", "===onRuntimeReady:  " + AnnieXContainer.this.getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
                AnnieXContainer.this.putState(4);
                annieXLifecycleDispatcher2 = AnnieXContainer.this.lifecycleDispatcher;
                str = AnnieXContainer.this.currentSchema;
                annieXLifecycleDispatcher2.onRuntimeReady(str, AnnieXContainer.this);
            }

            public void onKitViewDestroy(Uri uri2, IKitViewService kitView, Throwable throwable) {
                AnnieXLifecycleDispatcher annieXLifecycleDispatcher2;
                String str;
                Intrinsics.checkNotNullParameter(uri2, "uri");
                HybridLogger hybridLogger = HybridLogger.INSTANCE;
                Pair[] pairArr = new Pair[2];
                pairArr[0] = TuplesKt.to(StreamTrafficObservable.STREAM_URL, uri2.toString());
                pairArr[1] = TuplesKt.to("message", throwable != null ? throwable.getMessage() : null);
                hybridLogger.i("AnnieXContainer", "kit_view_destroy", MapsKt.mapOf(pairArr), AnnieXContainer.this.getBulletContext().getLogContext());
                annieXLifecycleDispatcher2 = AnnieXContainer.this.lifecycleDispatcher;
                str = AnnieXContainer.this.currentSchema;
                annieXLifecycleDispatcher2.onKitViewDestroy(str, AnnieXContainer.this);
                AnnieXContainer.this.getBulletContext().getMonitorCallback().getBulletCallback().onKitViewDestroy(uri2, kitView, throwable);
            }

            public void onLoadUriSuccess(Uri uri2, IKitViewService kitView) {
                AnnieXLifecycleDispatcher annieXLifecycleDispatcher2;
                String str;
                Intrinsics.checkNotNullParameter(uri2, "uri");
                HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieXContainer", "onLoadUriSuccess: " + AnnieXContainer.this.getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
                AnnieXContainer.this.sendWindowSizeEvent();
                AnnieXContainer.this.loadSuccess = true;
                AnnieXContainer.this.putState(3);
                annieXLifecycleDispatcher2 = AnnieXContainer.this.lifecycleDispatcher;
                str = AnnieXContainer.this.currentSchema;
                annieXLifecycleDispatcher2.onLoadSuccess(str, AnnieXContainer.this);
                AnnieXContainer.this.getBulletContext().getMonitorCallback().getBulletCallback().onLoadUriSuccess(uri2, kitView);
            }

            public void onLoadFail(Uri uri2, Throwable e) {
                AnnieXLifecycleDispatcher annieXLifecycleDispatcher2;
                String str;
                Intrinsics.checkNotNullParameter(uri2, "uri");
                Intrinsics.checkNotNullParameter(e, "e");
                HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieXContainer", "onLoadFail: schema===> " + AnnieXContainer.this.getUrl() + " error===> " + e.getMessage() + "  } ", (Map) null, (LoggerContext) null, 12, (Object) null);
                AnnieXContainer.this.loadSuccess = false;
                AnnieXContainer.this.putState(3);
                annieXLifecycleDispatcher2 = AnnieXContainer.this.lifecycleDispatcher;
                str = AnnieXContainer.this.currentSchema;
                annieXLifecycleDispatcher2.onLoadFail(str, AnnieXContainer.this, e);
                AnnieXContainer.this.getBulletContext().getMonitorCallback().getBulletCallback().onLoadFail(uri2, e);
            }

            public void onFallback(Uri uri2, Throwable e) {
                AnnieXLifecycleDispatcher annieXLifecycleDispatcher2;
                String str;
                Intrinsics.checkNotNullParameter(uri2, "uri");
                Intrinsics.checkNotNullParameter(e, "e");
                super.onFallback(uri2, e);
                annieXLifecycleDispatcher2 = AnnieXContainer.this.lifecycleDispatcher;
                str = AnnieXContainer.this.currentSchema;
                annieXLifecycleDispatcher2.onFallback(str, AnnieXContainer.this, e);
                AnnieXContainer.this.getBulletContext().getMonitorCallback().getBulletCallback().onFallback(uri2, e);
            }
        };
        this.isRootViewFirstLayout = true;
        this.foldStatus = "";
        this.decorView = LazyKt.lazy(new Function0<View>() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$decorView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final View m3297invoke() {
                Window window;
                Activity ownerActivity = ContextUtil.INSTANCE.getOwnerActivity(AnnieXContainer.this.getContext());
                if (ownerActivity == null || (window = ownerActivity.getWindow()) == null) {
                    return null;
                }
                return window.getDecorView();
            }
        });
        this.windowInsetsCompat = LazyKt.lazy(new Function0<WindowInsetsCompat>() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$windowInsetsCompat$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final WindowInsetsCompat m3301invoke() {
                View decorView;
                View decorView2;
                decorView = AnnieXContainer.this.getDecorView();
                if (decorView == null) {
                    return null;
                }
                decorView2 = AnnieXContainer.this.getDecorView();
                Intrinsics.checkNotNull(decorView2);
                return ViewCompat.getRootWindowInsets(decorView2);
            }
        });
        this.loadSuccess = true;
        this.stateBlockingQueue = new ArrayBlockingQueue<>(10);
        BulletContainerLoader bulletContainerLoader = new BulletContainerLoader(baseServiceContext, this.currentBid);
        this.containerLoader = bulletContainerLoader;
        this.bulletKitView = kitViewCreateOpt() ? bulletContainerLoader.getOrCreateKitViewService$anniex_release(getKitTypeWithSchema(), getSessionIdWithBundle()) : null;
        if (kitViewCreateOpt() && this.bulletKitView != null) {
            String schemaWithBundle = getSchemaWithBundle();
            IKitViewService iKitViewService = this.bulletKitView;
            if (iKitViewService != null) {
                iKitViewService.ensureViewCreated(schemaWithBundle);
            }
            Uri parse = Uri.parse(schemaWithBundle);
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
            bindKitView$default(this, parse, null, 2, null);
        }
        this.createViewTime = System.currentTimeMillis();
        this.pendingEvent = Collections.synchronizedList(new ArrayList());
        this.synchronizedObj = new Object();
        this.onSoftInputChangeListener = new Function1<Boolean, Unit>() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$onSoftInputChangeListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Activity activity;
                activity = AnnieXContainer.this.getActivity();
                if (activity != null) {
                    AnnieXContainer annieXContainer = AnnieXContainer.this;
                    if (z) {
                        int softInputHeight = SoftInputUtilKt.getSoftInputHeight(activity);
                        int px2Dp = (int) ResUtil.INSTANCE.px2Dp(SoftInputUtilKt.getSoftInputHeight(activity));
                        try {
                            Result.Companion companion = Result.Companion;
                            annieXContainer.possiblyResizeChildOfContent4Web(softInputHeight);
                            Result.constructor-impl(Unit.INSTANCE);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        annieXContainer.sendKeyboardStatusChangeEvent(true, px2Dp);
                        return;
                    }
                    try {
                        Result.Companion companion3 = Result.Companion;
                        annieXContainer.possiblyResizeChildOfContent4Web(0);
                        Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    annieXContainer.sendKeyboardStatusChangeEvent(false, 0);
                }
            }
        };
        this.isNotRelease = true;
        this.mainHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$mainHandler$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m3298invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void finish() {
        IContainer.DefaultImpls.finish(this);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void loadSchema(String str, Map<String, ? extends Object> map, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle absAnnieXLifecycle) {
        IContainer.DefaultImpls.loadSchema(this, str, map, contextProviderFactory, absAnnieXLifecycle);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void onEngineReady(ContextProviderFactory contextProviderFactory) {
        IContainer.DefaultImpls.onEngineReady(this, contextProviderFactory);
    }

    public final UIComponentBuilder getBuilder() {
        return this.builder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: getLynxWithScrollView$anniex_release, reason: from getter */
    public final View getLynxWithScrollView() {
        return this.lynxWithScrollView;
    }

    public final void setLynxWithScrollView$anniex_release(View view) {
        this.lynxWithScrollView = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BulletContext getBulletContext() {
        return this.bulletContext;
    }

    protected final void setBulletContext(BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(bulletContext, "<set-?>");
        this.bulletContext = bulletContext;
    }

    private final boolean canCreateNormalBulletContext(String schemaUri) {
        Object obj;
        Uri parse;
        try {
            Result.Companion companion = Result.Companion;
            AnnieXContainer annieXContainer = this;
            parse = Uri.parse(schemaUri);
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (parse.getHost() == null) {
            return false;
        }
        obj = Result.constructor-impl(Unit.INSTANCE);
        return Result.exceptionOrNull-impl(obj) == null;
    }

    private final BulletContext initOrGetBulletContext(String schemaUri, String sessionId) {
        BulletContext bulletContext;
        if (canCreateNormalBulletContext(schemaUri)) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "====init BulletContext with normal===", (Map) null, (LoggerContext) null, 12, (Object) null);
            Uri parse = Uri.parse(schemaUri);
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
            this.currentUri = parse;
            String queryParameter = parse.getQueryParameter("bid");
            if (queryParameter != null) {
                this.currentBid = queryParameter;
            }
            bulletContext = BulletContextManager.getOrCreateContext$default(BulletContextManager.Companion.getInstance(), this.currentBid, this.currentUri, this.bundle, false, (SchemaConfig) null, 24, (Object) null);
            bulletContext.setContext(this.context);
            if (!Intrinsics.areEqual(sessionId, "unknown")) {
                bulletContext.setSessionId(sessionId);
            }
            bulletContext.setBid(this.currentBid);
            bulletContext.getLynxContext().setLynxViewClient(this.annieXLynxViewClientProxy);
            bulletContext.getWebContext().setWebViewClient(this.annieXWebViewClientProxy);
            BulletContainerContext containerContext = bulletContext.getContainerContext();
            containerContext.setAnnieXGlobalProps(this.builder.getGlobalProps$anniex_release());
            containerContext.setAnnieXTemplateData(this.builder.getTemplateData());
            bulletContext.setServiceContext(this.serviceContext);
            bulletContext.getMonitorCallback().onBulletContextCreated(bulletContext);
        } else {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "====init BulletContext with default===", (Map) null, (LoggerContext) null, 12, (Object) null);
            bulletContext = new BulletContext();
            bulletContext.setContext(this.context);
            bulletContext.setSessionId("unknown");
            bulletContext.setBid(this.builder.getBid());
            bulletContext.getLynxContext().setLynxViewClient(this.annieXLynxViewClientProxy);
            bulletContext.getWebContext().setWebViewClient(this.annieXWebViewClientProxy);
            BulletContainerContext containerContext2 = bulletContext.getContainerContext();
            containerContext2.setAnnieXGlobalProps(this.builder.getGlobalProps$anniex_release());
            containerContext2.setAnnieXTemplateData(this.builder.getTemplateData());
            bulletContext.setServiceContext(this.serviceContext);
            bulletContext.getMonitorCallback().onBulletContextCreated(bulletContext);
        }
        bulletContext.getContainerContext().setGlobalProps(this.globalProps);
        return bulletContext;
    }

    static /* synthetic */ void bindKitView$default(AnnieXContainer annieXContainer, Uri uri, IKitViewService iKitViewService, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindKitView");
        }
        if ((i & 2) != 0) {
            iKitViewService = null;
        }
        annieXContainer.bindKitView(uri, iKitViewService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindKitView(Uri uri, IKitViewService kitView) {
        View realView;
        UIColorParam contentBgColor;
        Integer num;
        UIColorParam webBgColor;
        Integer num2;
        if (this.kitViewHasBinded) {
            return;
        }
        if (kitView != null && !kitViewCreateOpt()) {
            this.bulletKitView = kitView;
        }
        postFirstVisibleEvent();
        putState(2);
        IKitViewService iKitViewService = this.bulletKitView;
        if (iKitViewService != null && (realView = iKitViewService.realView()) != null) {
            BDXContainerModel containerModel = getContainerModel();
            if (containerModel != null && (webBgColor = containerModel.getWebBgColor()) != null && (num2 = (Integer) webBgColor.getValue()) != null) {
                realView.setBackgroundColor(num2.intValue());
            }
            BDXContainerModel containerModel2 = getContainerModel();
            if (containerModel2 != null && (contentBgColor = containerModel2.getContentBgColor()) != null && (num = (Integer) contentBgColor.getValue()) != null) {
                realView.setBackgroundColor(num.intValue());
            }
        }
        this.lifecycleDispatcher.onKitViewCreate(this.currentSchema, this);
        this.bulletContext.getMonitorCallback().getBulletCallback().onKitViewCreate(uri, this.bulletKitView);
        bindWebOnScrollChangeListener();
        this.kitViewHasBinded = true;
    }

    private final BDXContainerModel getContainerModel() {
        BDXContainerModel containerModel = this.bulletContext.getSchemaModelUnion().getContainerModel();
        if (containerModel instanceof BDXContainerModel) {
            return containerModel;
        }
        return null;
    }

    protected final ViewGroup getParentViewGroup() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final View getRootView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setRootView(View view) {
        this.rootView = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getDecorView() {
        return (View) this.decorView.getValue();
    }

    public final WindowInsetsCompat getWindowInsetsCompat() {
        return (WindowInsetsCompat) this.windowInsetsCompat.getValue();
    }

    public final boolean getContainerVisible() {
        return this.containerVisible;
    }

    public final void setContainerVisible(boolean z) {
        this.containerVisible = z;
    }

    public final BDXContainerModel getAnnieXContainerModel$anniex_release() {
        return getContainerModel();
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    /* renamed from: getBid, reason: from getter */
    public String getCurrentBid() {
        return this.currentBid;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public String getContainerId() {
        String str = this.__containerId;
        return str == null ? this.bulletContext.getSessionId() : str;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void bindContainerId(String containerId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        this.__containerId = containerId;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    /* renamed from: getCurrentUrl, reason: from getter */
    public String getCurrentSchema() {
        return this.currentSchema;
    }

    private final boolean kitViewCreateOpt() {
        Uri parse = Uri.parse(getSchemaWithBundle());
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        return Intrinsics.areEqual(parse.getQueryParameter("anniex_kitview_create_opt"), DiskLruCache.VERSION);
    }

    private final KitType getKitTypeWithSchema() {
        String schemaWithBundle = getSchemaWithBundle();
        if (StringsKt.contains$default(schemaWithBundle, "://lynxview", false, 2, (Object) null) || StringsKt.contains$default(schemaWithBundle, "://webcast_lynxview", false, 2, (Object) null)) {
            return KitType.LYNX;
        }
        if (StringsKt.contains$default(schemaWithBundle, "://webview", false, 2, (Object) null) || StringsKt.contains$default(schemaWithBundle, "://webcast_webview", false, 2, (Object) null)) {
            return KitType.WEB;
        }
        return KitType.UNKNOWN;
    }

    private final String getSessionIdWithBundle() {
        String string = this.bundle.getString("__x_session_id");
        return string == null ? "unknown" : string;
    }

    private final String getSchemaWithBundle() {
        String string = this.bundle.getString("annie_x_inner_bundle_schema");
        return string == null ? "unknown" : string;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void loadSchema(String schema, Map<String, ? extends Object> renderData) {
        String str;
        Map mutableMap;
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        long openTime = getOpenTime();
        Uri parse = Uri.parse(schema);
        if (!Intrinsics.areEqual(schema, this.currentSchema)) {
            this.currentSchema = schema;
            Intrinsics.checkNotNullExpressionValue(parse, "schemaUri");
            createModel(parse);
        }
        SLMonitorCompat.INSTANCE.reportPV(getContainerId(), schema);
        if (!IConditionCallKt.enablePreloadBeforeLoad()) {
            ForestPreloadHelper.preloadPage$default(ForestPreloadHelper.INSTANCE, this.bulletContext, (Uri) null, (String) null, false, 14, (Object) null);
        }
        TTWebPredictor tTWebPredictor = TTWebPredictor.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(parse, "schemaUri");
        tTWebPredictor.preconnect(parse);
        Application application = BulletEnv.Companion.getInstance().getApplication();
        if (application != null) {
            AnnieXJSWorkerManager.INSTANCE.initInPage$anniex_release(application, this.currentSchema);
        }
        closeCurrentPageWhenAfterPageOpen();
        this.bulletContext.setContext(this.context);
        if (renderData != null && (mutableMap = MapsKt.toMutableMap(renderData)) != null) {
            this.bulletContext.getLynxContext().setInitDataWrapper(LynxInitDataWrapper.Companion.fromMap(mutableMap));
        }
        setSecureInfo();
        this.contextProviderFactory.registerHolder(ContainerBidParam.class, new ContainerBidParam(this.currentBid));
        this.contextProviderFactory.registerWeakHolder(Context.class, this.context);
        this.contextProviderFactory.registerWeakHolder(BulletContext.class, this.bulletContext);
        this.contextProviderFactory.registerWeakHolder(IContainerInstance.class, this.containerInstance);
        this.contextProviderFactory.registerWeakHolder(IBulletContainer.class, this.deprecatedBulletContainer);
        this.contextProviderFactory.registerWeakHolder(IContainer.class, this);
        if (IConditionCallKt.enablePreloadBeforeLoad() && Intrinsics.areEqual(this.currentBid, "webcast") && (str = this.__containerId) != null) {
            this.contextProviderFactory.registerHolder(ForestSessionId.class, new ForestSessionId(str));
        }
        ContextProviderManager.INSTANCE.register(this.bulletContext.getSessionId(), this.contextProviderFactory);
        this.lifecycleDispatcher.onLoadStart(this.currentSchema, this);
        AbsBulletMonitorCallback.onLoadEntryBullet$default(this.bulletContext.getMonitorCallback(), openTime, false, 2, (Object) null);
        this.bulletContext.getMonitorCallback().onContainerCreated(Long.valueOf(this.createViewTime));
        this.bulletContext.getMonitorCallback().getBulletCallback().onLoadStart(this.currentUri, (IBulletContainer) null);
        BulletContext bulletContext = this.bulletContext;
        bulletContext.setBulletLoadLifeCycleListener(bulletContext.getMonitorCallback().getBulletCallback());
        this.serviceContext.putDependency(BulletContext.class, this.bulletContext);
        this.containerLoader.loadUri(this.bulletContext, this.currentUri, this.bundle, this.bulletLifecycle);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void preloadSchema(String schema) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        if (!Intrinsics.areEqual(schema, this.currentSchema)) {
            this.currentSchema = schema;
            Uri parse = Uri.parse(schema);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(schema)");
            createModel(parse);
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===preloadSchema: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    private final void createModel(Uri uri) {
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        this.bulletContext = initOrGetBulletContext(uri2, getSessionIdWithBundle());
        parseSchema();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseSchema() {
        ISchemaData schemaData = this.bulletContext.getSchemaData();
        if (schemaData != null) {
            SchemaModelTransformer.INSTANCE.generateContainerModel(this.bulletContext, schemaData);
        }
        putState(1);
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===parseSchema: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
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

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void enterForeground() {
        IKitViewService iKitViewService;
        this.isResuming = true;
        if (this.isRuntimeReady && (iKitViewService = this.bulletKitView) != null) {
            iKitViewService.onShow();
        }
        this.bulletContext.getMonitorCallback().getBulletCallback().onEnterForeground(Uri.parse(this.currentSchema), this.bulletKitView);
        this.isVisibility = true;
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===enterForeground: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void enterBackground() {
        IKitViewService iKitViewService = this.bulletKitView;
        if (iKitViewService != null) {
            iKitViewService.onHide();
        }
        this.bulletContext.getMonitorCallback().getBulletCallback().onEnterBackground(Uri.parse(this.currentSchema), this.bulletKitView);
        this.isVisibility = false;
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===enterBackground: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    /* renamed from: isVisibility, reason: from getter */
    public boolean getIsVisibility() {
        return this.isVisibility;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void reload(Map<String, ? extends Object> renderData) {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===reload: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        loadSchema(this.currentSchema, renderData);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void reloadTemplate(Map<String, ? extends Object> templateData) {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===reloadTemplate: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        LynxView lynxView = this.bulletKitView;
        LynxView lynxView2 = lynxView instanceof LynxView ? lynxView : null;
        if (lynxView2 != null) {
            AnnieXContainer annieXContainer = this;
            this.lifecycleDispatcher.onLoadStart(this.currentSchema, annieXContainer);
            TemplateData fromMap = TemplateData.fromMap(templateData != null ? AnnieXContainerKt.toNonNullValue(templateData) : null);
            fromMap.markReadOnly();
            lynxView2.reloadTemplate(fromMap);
            this.lifecycleDispatcher.onLoadSuccess(this.currentSchema, annieXContainer);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void goBack() {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===goBack: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        IKitViewService iKitViewService = this.bulletKitView;
        boolean z = false;
        if (iKitViewService != null && iKitViewService.onBackPressed()) {
            z = true;
        }
        if (z) {
            return;
        }
        close();
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void showError() {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===showError: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        if (this.errorView == null && this.isNotRelease) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "create error view", (Map) null, (LoggerContext) null, 12, (Object) null);
            UIComponent uIComponent = this.uiComponent;
            if (uIComponent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
                uIComponent = null;
            }
            View createErrorView = uIComponent.createErrorView();
            if (createErrorView != null) {
                this.errorView = createErrorView;
            }
        }
        IErrorView iErrorView = this.errorView;
        if (iErrorView != null) {
            if (!this.errorViewAdded) {
                getParentViewGroup().addView(iErrorView);
                this.errorViewAdded = true;
            }
            if (iErrorView instanceof IErrorView) {
                iErrorView.show();
            } else {
                iErrorView.setVisibility(0);
            }
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void hideError() {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===hideError: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        View view = this.errorView;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
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

    @Override // com.bytedance.android.anniex.base.container.IContainer
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

    @Override // com.bytedance.android.anniex.base.container.IContainer
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

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public ISchemaData generateSchemaData(String schema) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        if (!Intrinsics.areEqual(schema, this.currentSchema)) {
            this.currentSchema = schema;
            Uri parse = Uri.parse(schema);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(schema)");
            createModel(parse);
        }
        ISchemaData schemaData = this.bulletContext.getSchemaData();
        return schemaData == null ? SchemaService.Companion.getInstance().generateSchemaData(this.currentBid, this.currentUri, true) : schemaData;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public ISchemaData getSchemaData() {
        return this.bulletContext.getSchemaData();
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public ISchemaData getCurrentSchema() {
        return this.bulletContext.getSchemaData();
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public String getBDXTag() {
        ISchemaData schemaData = this.bulletContext.getSchemaData();
        if (schemaData != null) {
            return (String) new StringParam(schemaData, "bdx_tag", (String) null).getValue();
        }
        return null;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public LaunchMode getBDXLaunchMode() {
        LaunchMode launchMode;
        ISchemaData schemaData = this.bulletContext.getSchemaData();
        return (schemaData == null || (launchMode = (LaunchMode) new LaunchModeParam(schemaData, "bdx_launch_mode", (LaunchMode) null).getValue()) == null) ? LaunchMode.MODE_UNSPECIFIED : launchMode;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public View getKitView() {
        IKitViewService iKitViewService = this.bulletKitView;
        if (iKitViewService != null) {
            return iKitViewService.realView();
        }
        return null;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public KitType getKitType() {
        KitType kitType;
        IKitViewService iKitViewService = this.bulletKitView;
        return (iKitViewService == null || (kitType = iKitViewService.getKitType()) == null) ? KitType.LYNX : kitType;
    }

    private final void sendPendingEvent() {
        synchronized (this.synchronizedObj) {
            List<IEvent> list = this.pendingEvent;
            Intrinsics.checkNotNullExpressionValue(list, "pendingEvent");
            for (IEvent iEvent : list) {
                IKitViewService iKitViewService = this.bulletKitView;
                if (iKitViewService != null) {
                    iKitViewService.sendEvent(iEvent.getName(), iEvent.getParams());
                }
            }
            this.pendingEvent.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void sendEvent(IEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        IKitViewService iKitViewService = this.bulletKitView;
        if (iKitViewService != null) {
            if (iKitViewService != null) {
                iKitViewService.sendEvent(event.getName(), event.getParams());
            }
        } else {
            synchronized (this.synchronizedObj) {
                this.pendingEvent.add(event);
            }
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public boolean canBackPress() {
        BooleanParam blockBackPress;
        BDXContainerModel containerModel = getContainerModel();
        final boolean areEqual = (containerModel == null || (blockBackPress = containerModel.getBlockBackPress()) == null) ? false : Intrinsics.areEqual(blockBackPress.getValue(), true);
        final String str = areEqual ? "containerShouldClose" : "on_key_back";
        sendEvent(new IEvent() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$canBackPress$1
            /* renamed from: getName, reason: from getter */
            public String get$eventName() {
                return str;
            }

            public Object getParams() {
                JSONObject jSONObject = new JSONObject();
                if (areEqual) {
                    jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "systemBack");
                }
                return jSONObject;
            }
        });
        return !areEqual;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public boolean canGoBack() {
        IKitViewService iKitViewService = this.bulletKitView;
        if (iKitViewService != null) {
            return iKitViewService.onBackPressed();
        }
        return false;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public <T> void registerWeakHolder(Class<T> clazz, T item) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        this.contextProviderFactory.registerWeakHolder(clazz, item);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void updateGlobalProps(Map<String, ? extends Object> globalProps) {
        Intrinsics.checkNotNullParameter(globalProps, "globalProps");
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===updateGlobalProps: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        this.globalProps.putAll(globalProps);
        IKitViewService iKitViewService = this.bulletKitView;
        if (iKitViewService != null) {
            iKitViewService.updateGlobalProps(this.globalProps);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public ContextProviderFactory getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void updateData(Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===updateData: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        IKitViewService iKitViewService = this.bulletKitView;
        if (iKitViewService != null) {
            iKitViewService.updateData(data);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void updateData(String data) {
        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===updateData: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void updateScreenMetrics(int width, int height) {
        IKitViewService iKitViewService = this.bulletKitView;
        View realView = iKitViewService != null ? iKitViewService.realView() : null;
        LynxView lynxView = realView instanceof LynxView ? (LynxView) realView : null;
        if (lynxView != null) {
            lynxView.updateScreenMetrics(width, height);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public Map<String, Long> getPerfMap() {
        IKitViewService iKitViewService = this.bulletKitView;
        if (iKitViewService != null) {
            long j = (Intrinsics.areEqual(this.bulletContext.getResourceContext().getResFrom(), "unknown") || StringsKt.contains$default(this.bulletContext.getResourceContext().getResFrom(), "cdn", false, 2, (Object) null)) ? 1L : 0L;
            if (iKitViewService.getKitType() == KitType.LYNX) {
                long perfMetric = this.bulletContext.getMonitorCallback().getPerfMetric("prepare_template_start");
                long perfMetric2 = this.bulletContext.getMonitorCallback().getPerfMetric("read_template_end");
                long perfMetric3 = this.bulletContext.getMonitorCallback().getPerfMetric("read_template_end");
                long j2 = j;
                long perfMetric4 = this.bulletContext.getMonitorCallback().getPerfMetric("render_template_start");
                long perfMetric5 = this.bulletContext.getMonitorCallback().getPerfMetric("render_template_start");
                long perfMetric6 = this.bulletContext.getMonitorCallback().getPerfMetric("render_template_end");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("prepare_template_start", Long.valueOf(perfMetric));
                linkedHashMap.put("prepare_template_end", Long.valueOf(perfMetric2));
                linkedHashMap.put("prepare_engine_load_start", Long.valueOf(perfMetric5));
                linkedHashMap.put("prepare_engine_load_end", Long.valueOf(perfMetric6));
                linkedHashMap.put("prepare_render_data_start", Long.valueOf(perfMetric3));
                linkedHashMap.put("prepare_render_data_end", Long.valueOf(perfMetric4));
                linkedHashMap.put("res_from", Long.valueOf(j2));
                return linkedHashMap;
            }
            long j3 = j;
            long perfMetric7 = this.bulletContext.getMonitorCallback().getPerfMetric("prepare_template_start");
            long perfMetric8 = this.bulletContext.getMonitorCallback().getPerfMetric("prepare_template_end");
            long perfMetric9 = this.bulletContext.getMonitorCallback().getPerfMetric("prepare_component_end");
            long perfMetric10 = this.bulletContext.getMonitorCallback().getPerfMetric("page_load");
            long perfMetric11 = this.bulletContext.getMonitorCallback().getPerfMetric("page_load");
            long perfMetric12 = this.bulletContext.getMonitorCallback().getPerfMetric("page_finish");
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            if (perfMetric7 > 0) {
                linkedHashMap2.put("prepare_template_start", Long.valueOf(perfMetric7));
            }
            if (perfMetric8 > 0) {
                linkedHashMap2.put("prepare_template_end", Long.valueOf(perfMetric8));
            }
            linkedHashMap2.put("prepare_engine_load_start", Long.valueOf(perfMetric11));
            linkedHashMap2.put("prepare_engine_load_end", Long.valueOf(perfMetric12));
            linkedHashMap2.put("prepare_render_data_start", Long.valueOf(perfMetric9));
            linkedHashMap2.put("prepare_render_data_end", Long.valueOf(perfMetric10));
            linkedHashMap2.put("res_from", Long.valueOf(j3));
            return linkedHashMap2;
        }
        return MapsKt.emptyMap();
    }

    private final void showNotice() {
        if (this.noticeView == null && this.isNotRelease) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "create notice view", (Map) null, (LoggerContext) null, 12, (Object) null);
            UIComponent uIComponent = this.uiComponent;
            if (uIComponent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
                uIComponent = null;
            }
            this.noticeView = uIComponent.createNoticeView(this);
        }
        View view = this.noticeView;
        if (view != null) {
            getParentViewGroup().addView(view);
            view.setVisibility(0);
        }
    }

    private final void hideNotice() {
        View view = this.noticeView;
        if (view != null) {
            view.setVisibility(8);
            getParentViewGroup().removeView(view);
        }
    }

    private final void showDeny() {
        if (this.denyView == null && this.isNotRelease) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "create deny view", (Map) null, (LoggerContext) null, 12, (Object) null);
            UIComponent uIComponent = this.uiComponent;
            if (uIComponent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
                uIComponent = null;
            }
            this.denyView = uIComponent.createDenyView(this);
        }
        View view = this.denyView;
        if (view != null) {
            getParentViewGroup().addView(view);
            view.setVisibility(0);
        }
    }

    private final void hideDeny() {
        View view = this.denyView;
        if (view != null) {
            view.setVisibility(8);
            getParentViewGroup().removeView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setUiComponent(UIComponent uiComponent) {
        Intrinsics.checkNotNullParameter(uiComponent, "uiComponent");
        this.uiComponent = uiComponent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void initUi() {
        Object obj;
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===initUi: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        try {
            Result.Companion companion = Result.Companion;
            AnnieXContainer annieXContainer = this;
            observerKeyboardStatusChange();
            observerRootViewLayoutChanged();
            putState(0);
            this.bulletContext.getMonitorCallback().getBulletCallback().onBulletViewCreate();
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "initUi===>" + getUrl() + " error:" + th2.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
        }
    }

    private final boolean supportScreenProps() {
        return (this instanceof AnnieXPageContainer) || (this instanceof AnnieXPopupContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observerKitViewLayoutChanged() {
        IKitViewService iKitViewService;
        View realView;
        if (!IConditionCallKt.enableAnnieXPadGPContainerMigration() || !supportScreenProps() || (iKitViewService = this.bulletKitView) == null || (realView = iKitViewService.realView()) == null) {
            return;
        }
        realView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$observerKitViewLayoutChanged$1
            /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
            
                if (r3 != false) goto L36;
             */
            /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
            @Override // android.view.View.OnLayoutChangeListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                int i;
                Map map;
                IKitViewService iKitViewService2;
                View realView2;
                Map map2;
                boolean z;
                Map map3;
                Map map4;
                boolean z2;
                int i2 = right - left;
                if (i2 <= 0 || (i = bottom - top) <= 0) {
                    return;
                }
                int px2dp = BulletDeviceUtils.INSTANCE.px2dp(i2, AnnieXContainer.this.getContext());
                int px2dp2 = BulletDeviceUtils.INSTANCE.px2dp(i, AnnieXContainer.this.getContext());
                map = AnnieXContainer.this.screenProps;
                if (map != null) {
                    map2 = AnnieXContainer.this.screenProps;
                    if (map2 != null) {
                        Object obj = map2.get("containerWidth");
                        if ((obj instanceof Integer) && px2dp == ((Number) obj).intValue()) {
                            z = true;
                            if (z) {
                                map4 = AnnieXContainer.this.screenProps;
                                if (map4 != null) {
                                    Object obj2 = map4.get("containerHeight");
                                    if ((obj2 instanceof Integer) && px2dp2 == ((Number) obj2).intValue()) {
                                        z2 = true;
                                    }
                                }
                                z2 = false;
                            }
                            AnnieXContainer.this.updateGlobalProps(MapsKt.mapOf(new Pair[]{TuplesKt.to("containerWidth", Integer.valueOf(px2dp)), TuplesKt.to("containerHeight", Integer.valueOf(px2dp2))}));
                            map3 = AnnieXContainer.this.screenProps;
                            if (!TypeIntrinsics.isMutableMap(map3)) {
                                map3 = null;
                            }
                            if (map3 != null) {
                                map3.put("containerWidth", Integer.valueOf(px2dp));
                                map3.put("containerHeight", Integer.valueOf(px2dp2));
                            }
                        }
                    }
                    z = false;
                    if (z) {
                    }
                    AnnieXContainer.this.updateGlobalProps(MapsKt.mapOf(new Pair[]{TuplesKt.to("containerWidth", Integer.valueOf(px2dp)), TuplesKt.to("containerHeight", Integer.valueOf(px2dp2))}));
                    map3 = AnnieXContainer.this.screenProps;
                    if (!TypeIntrinsics.isMutableMap(map3)) {
                    }
                    if (map3 != null) {
                    }
                }
                iKitViewService2 = AnnieXContainer.this.bulletKitView;
                if (iKitViewService2 == null || (realView2 = iKitViewService2.realView()) == null) {
                    return;
                }
                realView2.removeOnLayoutChangeListener(this);
            }
        });
    }

    private final void observerRootViewLayoutChanged() {
        Configuration configuration;
        if (getDecorView() == null || !supportScreenProps()) {
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        View decorView = getDecorView();
        int i = 0;
        intRef.element = decorView != null ? decorView.getWidth() : 0;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        View decorView2 = getDecorView();
        intRef2.element = decorView2 != null ? decorView2.getHeight() : 0;
        if (AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) {
            this.foldStatus = AnnieXRuntime.INSTANCE.getDeviceDepend().getFoldStatus();
        }
        Resources resources = this.context.getResources();
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            i = configuration.orientation;
        }
        this.orientation = i;
        this.screenProps = BulletDeviceUtils.INSTANCE.getScreenProps(this.bulletContext.getContext(), this.orientation);
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$observerRootViewLayoutChanged$layoutChangeListener$1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                int i10;
                int i11 = i4 - i2;
                if (i11 <= 0 || (i10 = i5 - i3) <= 0) {
                    return;
                }
                if (intRef.element == i11 && intRef2.element == i10) {
                    return;
                }
                intRef.element = i11;
                intRef2.element = i10;
                this.onRootViewLayoutChanged(i2, i3, i4, i5, i6, i7, i8, i9);
            }
        };
        this.rootViewLayoutListener = onLayoutChangeListener;
        View decorView3 = getDecorView();
        if (decorView3 != null) {
            decorView3.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRootViewLayoutChanged(int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        IKitViewService iKitViewService;
        View realView;
        Configuration configuration;
        Resources resources = this.context.getResources();
        Integer valueOf = (resources == null || (configuration = resources.getConfiguration()) == null) ? null : Integer.valueOf(configuration.orientation);
        boolean z = isPadOrFold() && IConditionCallKt.enableOrientationGPFix();
        if (z) {
            if (valueOf != null && valueOf.intValue() == 1 && right - left > bottom - top) {
                valueOf = 2;
            } else if (valueOf != null && valueOf.intValue() == 2 && right - left < bottom - top) {
                valueOf = 1;
            }
        }
        Map<String, ? extends Object> screenProps = BulletDeviceUtils.INSTANCE.getScreenProps(this.bulletContext.getContext(), valueOf != null ? valueOf.intValue() : 0);
        if (IConditionCallKt.enableAnnieXPadGPContainerMigration() && screenProps != null && (iKitViewService = this.bulletKitView) != null && (realView = iKitViewService.realView()) != null && realView.getWidth() > 0 && realView.getHeight() > 0) {
            screenProps.put("containerWidth", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(realView.getWidth(), this.context)));
            screenProps.put("containerHeight", Integer.valueOf(BulletDeviceUtils.INSTANCE.px2dp(realView.getHeight(), this.context)));
        }
        if (z && screenProps != null) {
            screenProps.put("isLandscape", Integer.valueOf((valueOf != null && valueOf.intValue() == 2) ? 1 : 0));
        }
        if (!Intrinsics.areEqual(this.screenProps, screenProps)) {
            this.screenProps = screenProps;
            if (screenProps != null) {
                updateGlobalProps(screenProps);
            }
        }
        if (IConditionCallKt.enableAnnieXOrientationEvent() && valueOf != null) {
            if (valueOf.intValue() != this.orientation) {
                onOrientationChanged(valueOf.intValue(), screenProps);
            }
        }
        if (AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) {
            String foldStatus = AnnieXRuntime.INSTANCE.getDeviceDepend().getFoldStatus();
            if (!Intrinsics.areEqual(foldStatus, this.foldStatus)) {
                if (foldStatus.length() > 0) {
                    onFoldStatusChanged(foldStatus, screenProps);
                }
            }
        }
        if (AnnieXRuntime.INSTANCE.getDeviceDepend().enableBreakPoint() && isBreakPointChange(screenProps)) {
            DeviceDepend.onBreakPointChange$default(AnnieXRuntime.INSTANCE.getDeviceDepend(), this, null, screenProps, 2, null);
        }
    }

    private final void onFoldStatusChanged(String foldStatus, final Map<String, Object> screenProps) {
        this.foldStatus = foldStatus;
        if (screenProps != null) {
            sendEvent(new IEvent(screenProps) { // from class: com.bytedance.android.anniex.container.AnnieXContainer$onFoldStatusChanged$1$1
                private final String name = "screenFoldStateChange";
                private final Object params;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.params = new JSONObject(screenProps);
                }

                public String getName() {
                    return this.name;
                }

                public Object getParams() {
                    return this.params;
                }
            });
        }
    }

    private final boolean isBreakPointChange(Map<String, Object> screenProps) {
        Object obj = screenProps != null ? screenProps.get("aweBreakPoint") : null;
        Map map = obj instanceof Map ? (Map) obj : null;
        if (map == null) {
            return false;
        }
        Object obj2 = map.get("horizontal");
        Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
        Object obj3 = map.get("vertical");
        Integer num2 = obj3 instanceof Integer ? (Integer) obj3 : null;
        if (num == null || num2 == null) {
            return false;
        }
        if (Intrinsics.areEqual(num, this.curHorizontalBreakPoint) && Intrinsics.areEqual(num2, this.curVerticalBreakPoint)) {
            return false;
        }
        this.curHorizontalBreakPoint = num;
        this.curVerticalBreakPoint = num2;
        return true;
    }

    public final Function1<Boolean, Unit> getOnSoftInputChangeListener$anniex_release() {
        return this.onSoftInputChangeListener;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void observerKeyboardStatusChange() {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===observerKeyboardStatusChange====", (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void possiblyResizeChildOfContent4Web(int softHeight) {
        View rootView;
        int height;
        int height2;
        BooleanParam disableInputScroll;
        if (needAdapterKeyboard4Web()) {
            BDXContainerModel containerModel = getContainerModel();
            if (((containerModel == null || (disableInputScroll = containerModel.getDisableInputScroll()) == null) ? false : Intrinsics.areEqual(disableInputScroll.getValue(), true)) || (height2 = (height = (rootView = getParentViewGroup().getRootView()).getHeight()) - softHeight) == this.usableHeightPrevious) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rootView, "decorView");
            View contentView = getContentView(rootView);
            if (IConditionCallKt.enableAnnieXWebcastWebPopupSoftInputAdapter() && (this instanceof AnnieXPopupContainer) && AnnieXContainerManager.isTopContainer(this)) {
                if (softHeight == 0) {
                    if (contentView != null) {
                        contentView.scrollTo(0, 0);
                    }
                } else if (contentView != null) {
                    contentView.scrollBy(0, softHeight - getNavigationBarHeight());
                }
                this.usableHeightPrevious = height2;
                return;
            }
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

    private final boolean needAdapterKeyboard4Web() {
        BooleanParam transStatusBar;
        BooleanParam hideStatusBar;
        IntegerParam softInputMode;
        Integer num;
        IKitViewService iKitViewService = this.bulletKitView;
        if ((iKitViewService != null ? iKitViewService.realView() : null) instanceof LynxView) {
            return false;
        }
        BDXContainerModel containerModel = getContainerModel();
        int intValue = (containerModel == null || (softInputMode = containerModel.getSoftInputMode()) == null || (num = (Integer) softInputMode.getValue()) == null) ? -1 : num.intValue();
        if (intValue > -1) {
            return false;
        }
        if (!(this instanceof AnnieXPageContainer)) {
            return (this instanceof AnnieXPopupContainer) && intValue == -1;
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

    private final View getContentView(View decorView) {
        View findViewById = decorView.findViewById(R.id.content);
        return findViewById instanceof ViewGroup ? (ViewGroup) findViewById : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendKeyboardStatusChangeEvent(boolean isShowing, int height) {
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put("visible", isShowing);
        jSONObject.put("height", height);
        sendEvent(new IEvent(jSONObject) { // from class: com.bytedance.android.anniex.container.AnnieXContainer$sendKeyboardStatusChangeEvent$1
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
        sendEvent(new IEvent(jSONObject) { // from class: com.bytedance.android.anniex.container.AnnieXContainer$sendKeyboardStatusChangeEvent$2
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void putState(final int state) {
        if (this.parentViewGroup != null) {
            getMainHandler().post(new Runnable() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$putState$1
                @Override // java.lang.Runnable
                public final void run() {
                    AnnieXContainer.this.changeState(state);
                }
            });
        } else {
            this.stateBlockingQueue.put(Integer.valueOf(state));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeState(int state) {
        BooleanParam showLoading;
        Boolean bool;
        IKitViewService iKitViewService;
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
            if (state != 3) {
                if (state != 4) {
                    return;
                }
                this.isRuntimeReady = true;
                if (!this.isResuming || (iKitViewService = this.bulletKitView) == null) {
                    return;
                }
                iKitViewService.onShow();
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
        getParentViewGroup().removeAllViews();
        this.errorViewAdded = false;
        addKitView();
        IKitViewService iKitViewService2 = this.bulletKitView;
        Configuration configuration = this.context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "context.resources.configuration");
        padAdaptation(iKitViewService2, configuration, true);
        BDXContainerModel containerModel = getContainerModel();
        if (containerModel == null || (showLoading = containerModel.getShowLoading()) == null || (bool = (Boolean) showLoading.getValue()) == null) {
            return;
        }
        if (!bool.booleanValue()) {
            bool = null;
        }
        if (bool != null) {
            bool.booleanValue();
            if (this.loadingView == null && this.isNotRelease) {
                HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "create loading view", (Map) null, (LoggerContext) null, 12, (Object) null);
                UIComponent uIComponent = this.uiComponent;
                if (uIComponent == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
                    uIComponent = null;
                }
                this.loadingView = uIComponent.createLoadingView();
            }
            View view = this.loadingView;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.gravity = 17;
                }
                getParentViewGroup().addView(view);
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
        padAdaptation$default(this, this.bulletKitView, newConfig, false, 4, null);
        updateLynxScreenMetrics();
        sendWindowSizeEvent();
    }

    private final void onOrientationChanged(int orientation, final Map<String, Object> screenProps) {
        this.orientation = orientation;
        if (screenProps != null) {
            sendEvent(new IEvent(screenProps) { // from class: com.bytedance.android.anniex.container.AnnieXContainer$onOrientationChanged$1$1
                private final String name = EventHelper.SCREEN_ORIENTATION_CHANGE;
                private final Object params;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.params = new JSONObject(screenProps);
                }

                public String getName() {
                    return this.name;
                }

                public Object getParams() {
                    return this.params;
                }
            });
        }
    }

    static /* synthetic */ void padAdaptation$default(AnnieXContainer annieXContainer, IKitViewService iKitViewService, Configuration configuration, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: padAdaptation");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        annieXContainer.padAdaptation(iKitViewService, configuration, z);
    }

    private final void padAdaptation(IKitViewService kitView, Configuration configuration, boolean isKitViewCreate) {
        if (kitView == null) {
            return;
        }
        Scenes scenes = this instanceof AnnieXPageContainer ? Scenes.AbsActivity : Scenes.PopupFragment;
        if (BulletPadAdapterUtil.INSTANCE.enableAdapterPad(this.bulletContext.getSchemaModelUnion(), scenes, true)) {
            if (isKitViewCreate) {
                BulletPadAdapterUtil.logPadAdaption$default(BulletPadAdapterUtil.INSTANCE, this.bulletContext.getBid(), this.context, this.bulletContext.getSchemaModelUnion(), scenes, configuration, false, 32, (Object) null);
            }
            Pair padKitViewInfo$default = BulletPadAdapterUtil.getPadKitViewInfo$default(BulletPadAdapterUtil.INSTANCE, this.bulletContext.getBid(), this.context, this.bulletContext.getSchemaModelUnion(), scenes, configuration, false, 32, (Object) null);
            Integer num = (Integer) padKitViewInfo$default.component1();
            Integer num2 = (Integer) padKitViewInfo$default.component2();
            View realView = kitView.realView();
            if (realView != null) {
                ViewGroup.LayoutParams layoutParams = realView.getLayoutParams();
                FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    if (num != null) {
                        layoutParams2.width = num.intValue();
                    }
                    if (num2 != null) {
                        layoutParams2.height = num2.intValue();
                    }
                    if (BulletPadAdapterUtil.INSTANCE.enablePageUniformStyle(this.bulletContext.getSchemaData(), scenes) || BulletPadAdapterUtil.INSTANCE.enablePageChannelStyle(this.bulletContext.getSchemaData(), scenes)) {
                        layoutParams2.gravity = 1;
                    } else if (!IConditionCallKt.enableAnnieXPadAdapterGravityFix()) {
                        layoutParams2.gravity = 17;
                    } else {
                        Pair screenInfo = BulletDeviceUtils.INSTANCE.getScreenInfo(this.context);
                        if (num != null && screenInfo != null) {
                            if (num.intValue() < ((Number) screenInfo.getFirst()).intValue()) {
                                layoutParams2.gravity = 17;
                            } else {
                                layoutParams2.gravity = 8388659;
                            }
                        }
                    }
                    realView.setLayoutParams(layoutParams2);
                    HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "kitView set size : width=" + num + ",height=" + num2, (Map) null, (LoggerContext) null, 12, (Object) null);
                }
            }
            this.padAdapterWidth = BulletPadAdapterUtil.INSTANCE.getPadAdapterWidth();
            this.padAdapterHeight = BulletPadAdapterUtil.INSTANCE.getPadAdapterHeight();
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "padAdaptation : current scenes=" + this.bulletContext.getScene() + ",padAdapterWidth=" + this.padAdapterWidth + ",padAdapterHeight=" + this.padAdapterHeight, (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    public final boolean isPadOrFold() {
        return AnnieXRuntime.INSTANCE.getDeviceDepend().isPad() || AnnieXRuntime.INSTANCE.getDeviceDepend().isFold();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendWindowSizeEvent() {
        if ((AnnieXRuntime.INSTANCE.getDeviceDepend().isFold() || AnnieXRuntime.INSTANCE.getDeviceDepend().isPad()) && !(this instanceof AnnieXPopupContainer)) {
            final Ref.IntRef intRef = new Ref.IntRef();
            final Ref.IntRef intRef2 = new Ref.IntRef();
            if (Build.VERSION.SDK_INT >= 30) {
                Activity ownerActivity = ContextUtil.INSTANCE.getOwnerActivity(this.context);
                Display display = ownerActivity != null ? ownerActivity.getDisplay() : null;
                if (display != null) {
                    intRef2.element = display.getMode().getPhysicalHeight();
                    intRef.element = display.getMode().getPhysicalWidth();
                }
            } else {
                ScreenInfo screenInfo = ViewUtil.INSTANCE.getScreenInfo(this.context);
                if (screenInfo != null) {
                    intRef.element = screenInfo.getWidth();
                    intRef2.element = screenInfo.getHeight();
                }
            }
            try {
                Result.Companion companion = Result.Companion;
                sendEvent(new IEvent(this, intRef, intRef2) { // from class: com.bytedance.android.anniex.container.AnnieXContainer$sendWindowSizeEvent$1$1
                    private final String name = "windowResize";
                    private final Object params;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        Integer num;
                        int i;
                        Integer num2;
                        int i2;
                        JSONObject jSONObject = new JSONObject();
                        if (this.getContext().getResources().getConfiguration().orientation == 2) {
                            jSONObject.put("screenHeight", UIUtils.INSTANCE.px2dip(this.getContext(), Math.min(intRef.element, intRef2.element)));
                            jSONObject.put("screenWidth", UIUtils.INSTANCE.px2dip(this.getContext(), Math.max(intRef.element, intRef2.element)));
                        } else {
                            jSONObject.put("screenHeight", UIUtils.INSTANCE.px2dip(this.getContext(), Math.max(intRef.element, intRef2.element)));
                            jSONObject.put("screenWidth", UIUtils.INSTANCE.px2dip(this.getContext(), Math.min(intRef.element, intRef2.element)));
                        }
                        num = this.padAdapterHeight;
                        if (num != null) {
                            i = UIUtils.INSTANCE.px2dip(this.getContext(), num.intValue());
                        } else {
                            i = this.getContext().getResources().getConfiguration().screenHeightDp;
                        }
                        jSONObject.put("contentHeight", i);
                        num2 = this.padAdapterWidth;
                        if (num2 != null) {
                            i2 = UIUtils.INSTANCE.px2dip(this.getContext(), num2.intValue());
                        } else {
                            i2 = this.getContext().getResources().getConfiguration().screenWidthDp;
                        }
                        jSONObject.put("contentWidth", i2);
                        this.params = jSONObject;
                    }

                    public String getName() {
                        return this.name;
                    }

                    public Object getParams() {
                        return this.params;
                    }
                });
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
    }

    private final void updateLynxScreenMetrics() {
        ScreenInfo screenInfo;
        if (this.bulletKitView != null) {
            boolean enableAdapterPad = BulletPadAdapterUtil.INSTANCE.enableAdapterPad(this.bulletContext.getSchemaModelUnion(), this instanceof AnnieXPageContainer ? Scenes.AbsActivity : Scenes.PopupFragment, true);
            Integer num = this.padAdapterWidth;
            Integer num2 = this.padAdapterHeight;
            if (enableAdapterPad && num != null && num2 != null) {
                updateScreenMetrics(num.intValue(), num2.intValue());
                HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "updateLynxScreenMetrics : enableIpadAdapter " + enableAdapterPad + " , width " + num + " , height " + num2, (Map) null, (LoggerContext) null, 12, (Object) null);
                return;
            }
            Context context = this.bulletContext.getContext();
            if (context == null || (screenInfo = ViewUtil.INSTANCE.getScreenInfo(context)) == null) {
                return;
            }
            updateScreenMetrics(screenInfo.getWidth(), screenInfo.getHeight());
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "updateLynxScreenMetrics : enableIpadAdapter " + enableAdapterPad + " , width " + screenInfo.getWidth() + " , height " + screenInfo.getHeight(), (Map) null, (LoggerContext) null, 12, (Object) null);
        }
    }

    private final void addKitView() {
        View realView;
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===addKitView: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        IKitViewService iKitViewService = this.bulletKitView;
        if (iKitViewService != null && (realView = iKitViewService.realView()) != null) {
            getParentViewGroup().addView(realView);
            this.lifecycleDispatcher.onAttachView(this.currentSchema, this);
        }
        sendPendingEvent();
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void onAttachToWindow() {
        IContainer.DefaultImpls.onAttachToWindow(this);
        this.bulletContext.getMonitorCallback().onViewAttached(this.currentUri.getPath());
    }

    private final boolean showContainerTag(DebugInfo debugInfo) {
        return BulletEnv.Companion.getInstance().getDebuggable() && BulletEnv.Companion.getInstance().getShowTag() && debugInfo.getShowDebugTagView();
    }

    private final void addTagView() {
        KitType kitType;
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===addTagView: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        DebugInfo debugInfo = DebugConfig.INSTANCE.get(this.currentBid);
        String str = null;
        if (!showContainerTag(debugInfo)) {
            debugInfo = null;
        }
        if (debugInfo != null) {
            DebugTagTextView inflate = LayoutInflater.from(this.context).inflate(C0840R.layout.bullet_debug_tag_view, getParentViewGroup(), false);
            DebugTagTextView debugTagTextView = inflate instanceof DebugTagTextView ? inflate : null;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388661;
            getParentViewGroup().addView((View) debugTagTextView, layoutParams);
            if (debugTagTextView != null) {
                String viewType = getViewType();
                String debugTagPrefix = debugInfo.getDebugTagPrefix();
                String str2 = debugTagPrefix == null || debugTagPrefix.length() == 0 ? "" : debugInfo.getDebugTagPrefix() + " - ";
                String provideSuffix = IPreRenderServiceKt.provideSuffix(this.bulletContext.getContainerContext().getCacheType());
                HybridLogger hybridLogger = HybridLogger.INSTANCE;
                StringBuilder append = new StringBuilder("debug tag: ").append(viewType).append('_').append(str2);
                IKitViewService iKitViewService = this.bulletKitView;
                HybridLogger.i$default(hybridLogger, TAG, append.append(iKitViewService != null ? iKitViewService.getViewTag() : null).append(provideSuffix).toString(), (Map) null, (LoggerContext) null, 12, (Object) null);
                StringBuilder sb = new StringBuilder("x-");
                IKitViewService iKitViewService2 = this.bulletKitView;
                if (iKitViewService2 != null && (kitType = iKitViewService2.getKitType()) != null) {
                    str = kitType.getTag();
                }
                debugTagTextView.setText(sb.append(str).append('-').append(viewType).append('(').append(this.currentBid).append(')').toString());
                final Function1 onTagClickListener = BulletEnv.Companion.getInstance().getOnTagClickListener();
                if (onTagClickListener != null) {
                    debugTagTextView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$addTagView$2$1$1$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            IKitViewService iKitViewService3;
                            Function1<View, Unit> function1 = onTagClickListener;
                            iKitViewService3 = this.bulletKitView;
                            function1.invoke(iKitViewService3 != null ? iKitViewService3.realView() : null);
                        }
                    });
                }
            }
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public Context getSystemContext() {
        return this.context;
    }

    private final Handler getMainHandler() {
        return (Handler) this.mainHandler.getValue();
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void release() {
        if (this.isNotRelease) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===release: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
            this.lifecycleDispatcher.onRelease(this.currentSchema);
            this.bulletContext.getMonitorCallback().getBulletCallback().onBulletViewRelease();
            BulletContextManager.Companion.getInstance().removeContext(this.bulletContext);
            View.OnLayoutChangeListener onLayoutChangeListener = this.rootViewLayoutListener;
            if (onLayoutChangeListener != null) {
                View decorView = getDecorView();
                if (decorView != null) {
                    decorView.removeOnLayoutChangeListener(onLayoutChangeListener);
                }
                this.rootViewLayoutListener = null;
            }
            SLMonitorCompatKt.getSLMonitorManager().releaseMonitorWithSessionId(this.bulletContext.getSessionId());
            getMainHandler().postDelayed(new Runnable() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$release$2
                @Override // java.lang.Runnable
                public final void run() {
                    ContextProviderFactory contextProviderFactory;
                    AnnieXContainer.this.getBulletContext().release();
                    contextProviderFactory = AnnieXContainer.this.contextProviderFactory;
                    contextProviderFactory.removeAll();
                }
            }, 1000L);
            IKitViewService iKitViewService = this.bulletKitView;
            if (iKitViewService != null) {
                iKitViewService.destroy(true);
            }
            this.bulletKitView = null;
            this.containerLoader.release();
            this.rootView = null;
            this.errorView = null;
            this.loadingView = null;
            this.noticeView = null;
            this.denyView = null;
            this.isNotRelease = false;
        }
    }

    public final String getUrl() {
        String originSchema;
        BDXContainerModel containerModel = getContainerModel();
        return (containerModel == null || (originSchema = containerModel.getOriginSchema()) == null) ? "unknown" : originSchema;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void onVisibleChange(final boolean visible, Boolean hasReadySendVisibleEvent) {
        if (visible == this.containerVisible) {
            return;
        }
        this.containerVisible = visible;
        sendEvent(new IEvent() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$onVisibleChange$1
            public String getName() {
                return "pageVisibilityChange";
            }

            public Object getParams() {
                UIComponent uIComponent;
                JSONObject jSONObject = new JSONObject();
                boolean z = visible;
                AnnieXContainer annieXContainer = this;
                jSONObject.put("visible", z);
                if (!Intrinsics.areEqual(annieXContainer.getViewType(), AnnieX.CONTAINER_VIEW_TYPE_CARD)) {
                    uIComponent = annieXContainer.uiComponent;
                    if (uIComponent == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
                        uIComponent = null;
                    }
                    jSONObject.put("source", uIComponent.isAppBackground() ? "app" : "page");
                }
                return jSONObject;
            }
        });
        if (hasReadySendVisibleEvent == null || Intrinsics.areEqual(hasReadySendVisibleEvent, false)) {
            if (visible) {
                sendEvent(new IEvent() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$onVisibleChange$2
                    public String getName() {
                        return "viewAppeared";
                    }

                    public Object getParams() {
                        return new JSONObject();
                    }
                });
            } else {
                sendEvent(new IEvent() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$onVisibleChange$3
                    public String getName() {
                        return "viewDisappeared";
                    }

                    public Object getParams() {
                        return new JSONObject();
                    }
                });
            }
        }
    }

    private final void closeCurrentPageWhenAfterPageOpen() {
        BDXContainerModel containerModel;
        StringParam openContainerID;
        String str;
        BooleanParam closeAfterOpenSuccess;
        if ((!(this instanceof AnnieXPageContainer) && !(this instanceof AnnieXPopupContainer)) || (containerModel = getContainerModel()) == null || (openContainerID = containerModel.getOpenContainerID()) == null || (str = (String) openContainerID.getValue()) == null) {
            return;
        }
        BDXContainerModel containerModel2 = getContainerModel();
        if (!((containerModel2 == null || (closeAfterOpenSuccess = containerModel2.getCloseAfterOpenSuccess()) == null) ? false : Intrinsics.areEqual(closeAfterOpenSuccess.getValue(), true)) || Intrinsics.areEqual(str, "")) {
            return;
        }
        AnnieX.INSTANCE.closeContainerById(str);
    }

    private final long getOpenTime() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.bundle.getLong("open_time");
        if (j <= 0) {
            return currentTimeMillis;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "openTime:" + j + ", currentTime: " + currentTimeMillis, (Map) null, (LoggerContext) null, 12, (Object) null);
        return Math.min(j, currentTimeMillis);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public WeakReference<Context> getWeakContext() {
        return new WeakReference<>(this.context);
    }

    public final boolean isKitViewScrollReachTop() {
        if (getKitType() == KitType.WEB) {
            return this.isWebViewScrollReachTop;
        }
        View view = this.lynxWithScrollView;
        return !(view != null && view.canScrollVertically(-1));
    }

    private final void bindWebOnScrollChangeListener() {
        if (getKitView() == null || !(getKitView() instanceof SSWebView)) {
            return;
        }
        SSWebView kitView = getKitView();
        Intrinsics.checkNotNull(kitView, "null cannot be cast to non-null type com.bytedance.ies.bullet.kit.web.SSWebView");
        kitView.setWebScrollListener(new SSWebView.WebScrollListener() { // from class: com.bytedance.android.anniex.container.AnnieXContainer$bindWebOnScrollChangeListener$1
            public void onScrollChanged(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                AnnieXContainer annieXContainer = AnnieXContainer.this;
                boolean z = false;
                if (oldScrollX <= scrollY && scrollY < 1) {
                    z = true;
                }
                annieXContainer.isWebViewScrollReachTop = z;
                AnnieXContainer.this.onWebScrollChanged(scrollX, scrollY, oldScrollX, oldScrollY);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getActivity() {
        Context context = this.context;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextThemeWrapper) || !(((ContextThemeWrapper) context).getBaseContext() instanceof Activity)) {
            return null;
        }
        Context baseContext = ((ContextThemeWrapper) this.context).getBaseContext();
        Intrinsics.checkNotNull(baseContext, "null cannot be cast to non-null type android.app.Activity");
        return (Activity) baseContext;
    }

    public final boolean hasStatusBar() {
        WindowInsetsCompat windowInsetsCompat;
        return (getWindowInsetsCompat() == null || (windowInsetsCompat = getWindowInsetsCompat()) == null || !windowInsetsCompat.isVisible(WindowInsetsCompat.Type.statusBars())) ? false : true;
    }

    public final int getStatusBarHeight() {
        WindowInsetsCompat windowInsetsCompat;
        Insets insets;
        if (!hasStatusBar() || (windowInsetsCompat = getWindowInsetsCompat()) == null || (insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.statusBars())) == null) {
            return 0;
        }
        return insets.bottom;
    }

    public final boolean hasSystemNavBar() {
        WindowInsetsCompat windowInsetsCompat;
        return (getWindowInsetsCompat() == null || (windowInsetsCompat = getWindowInsetsCompat()) == null || !windowInsetsCompat.isVisible(WindowInsetsCompat.Type.navigationBars())) ? false : true;
    }

    public final int getNavigationBarHeight() {
        WindowInsetsCompat windowInsetsCompat;
        Insets insets;
        if (!hasSystemNavBar() || (windowInsetsCompat = getWindowInsetsCompat()) == null || (insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars())) == null) {
            return 0;
        }
        return insets.bottom;
    }

    @Deprecated(message = "该方法可能存在底部导航是否显示判断以及高度获取不准的问题，建议使用上面的getNavigationBarHeight()替代")
    public final int getRealNavigationBarHeight() {
        if (!hasSystemNavBar() || getActivity() == null) {
            return 0;
        }
        UIUtils uIUtils = UIUtils.INSTANCE;
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        return uIUtils.getRealNavigationBarHeight(activity);
    }

    private final void setSecureInfo() {
        this.bulletContext.getMonitorCallback().recordSecurityEventTime("on_container_created_start");
        ArgusContainerDelegate argusContainerDelegate = this.bulletContext.getArgusContainerDelegate();
        if (argusContainerDelegate != null) {
            argusContainerDelegate.monitorContainerCreated(getActivity(), ArgusWebDelegateAdapterKt.initArgusContainerCreatedParams(this.bulletContext, ArgusContainerCreateType.Activity));
        }
        this.bulletContext.getMonitorCallback().recordSecurityEventTime("on_container_created_end");
    }
}
