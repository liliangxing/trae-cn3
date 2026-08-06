package com.bytedance.ies.bullet.lynx;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.view.View;
import bolts.Task;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.lynx.config.LynxViewMonitorConfig;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewProvider;
import com.bytedance.android.monitorV2.lynx_helper.LynxViewMonitorHelper;
import com.bytedance.crash.Npth;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.argus.api.interfaces.service.ArgusBaseBizService;
import com.bytedance.ies.bullet.IBulletKitViewService;
import com.bytedance.ies.bullet.base.constants.GlobalPropertiesConstants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContainerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextKt;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.BulletLynxContext;
import com.bytedance.ies.bullet.core.BulletRLContext;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.core.SSRConfig;
import com.bytedance.ies.bullet.deprecate.fake.ForestSessionId;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.ForestResourceInfo;
import com.bytedance.ies.bullet.forest.TemplateBundleProcessor;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.kit.web.WebKitView;
import com.bytedance.ies.bullet.lynx.element.LynxCanvasTTPlayer;
import com.bytedance.ies.bullet.lynx.impl.DefaultImageInterceptor;
import com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate;
import com.bytedance.ies.bullet.lynx.impl.DefaultLynxViewClient;
import com.bytedance.ies.bullet.lynx.impl.KTX2KryptonRuntimeServiceImpl;
import com.bytedance.ies.bullet.lynx.impl.PhysicsKryptonRuntimeServiceImpl;
import com.bytedance.ies.bullet.lynx.init.ILynxCanvasConfig;
import com.bytedance.ies.bullet.lynx.init.LynxConfig;
import com.bytedance.ies.bullet.lynx.init.LynxGroupHolder;
import com.bytedance.ies.bullet.lynx.model.LynxInitData;
import com.bytedance.ies.bullet.lynx.model.LynxModuleWrapper;
import com.bytedance.ies.bullet.lynx.resource.DefaultDynamicComponentFetcher;
import com.bytedance.ies.bullet.lynx.resource.DefaultLynxGenericResourceProvider;
import com.bytedance.ies.bullet.lynx.resource.DefaultMediaResourceProvider;
import com.bytedance.ies.bullet.lynx.resource.DefaultTemplateResourceProvider;
import com.bytedance.ies.bullet.lynx.resource.ExternalJSProvider;
import com.bytedance.ies.bullet.lynx.resource.FontResourceProvider;
import com.bytedance.ies.bullet.preloadv2.PreloadV2;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.TemplateMemCache;
import com.bytedance.ies.bullet.preloadv2.cache.TemplatePreloadItem;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadHelper;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IEventHandler;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.ILoadUriListener;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.ITestService;
import com.bytedance.ies.bullet.service.base.MonitorConfig;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.callbacks.KitViewCallback;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.lynx.ILynxKitService;
import com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService;
import com.bytedance.ies.bullet.service.base.resourceloader.config.CustomLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.test.TNativeEvent;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.ies.bullet.service.context.IContextProviderFactory;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.google.gson.Gson;
import com.lynx.canvas.KryptonVideoPlayerService;
import com.lynx.canvas.LynxKryptonUtils;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxGetDataCallback;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxLoadMeta;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.behavior.ImageInterceptor;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.lynx.tasm.navigator.LynxHolder;
import com.lynx.tasm.navigator.LynxNavigator;
import com.lynx.tasm.navigator.LynxRoute;
import com.lynx.tasm.navigator.LynxViewCreationListener;
import com.lynx.tasm.navigator.NavigationModule;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: LynxKitView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u009f\u00012\u00020\u00012\u00020\u0002:\u0002\u009f\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u0010\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010.J\u001c\u0010:\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u001a\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\u0010\u0010E\u001a\u00020;2\u0006\u0010F\u001a\u00020 H\u0016J\u0012\u0010G\u001a\u00020;2\b\u0010H\u001a\u0004\u0018\u000105H\u0016J\b\u0010I\u001a\u00020 H\u0016J\u0010\u0010I\u001a\u00020 2\u0006\u0010J\u001a\u00020\bH\u0016J\b\u0010K\u001a\u00020\bH\u0002J\b\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020\bH\u0016J\b\u0010O\u001a\u00020\bH\u0016J\u0017\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010SH\u0002¢\u0006\u0002\u0010TJ\u0018\u0010U\u001a\u00020V2\u0006\u0010B\u001a\u00020\b2\u0006\u0010W\u001a\u00020 H\u0002J\u0018\u0010X\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010Y2\u0006\u0010[\u001a\u00020\\H\u0002J\b\u0010]\u001a\u00020\bH\u0016J\u0010\u0010^\u001a\u00020;2\u0006\u0010_\u001a\u000205H\u0002J$\u0010`\u001a\u00020;2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020;0b2\u0006\u0010d\u001a\u00020 H\u0016J\u001a\u0010e\u001a\u00020;2\u0006\u0010f\u001a\u0002092\b\u0010g\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010e\u001a\u00020;2\u0006\u0010B\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010hH\u0016J\u0018\u0010e\u001a\u00020;2\u0006\u0010B\u001a\u00020\b2\u0006\u0010i\u001a\u00020ZH\u0002J2\u0010j\u001a\u00020;2\u0006\u0010B\u001a\u00020\b2\u0006\u0010W\u001a\u00020 2\u0006\u0010k\u001a\u00020 2\b\u0010l\u001a\u0004\u0018\u00010V2\u0006\u0010?\u001a\u00020mH\u0002J\u001a\u0010n\u001a\u00020;2\u0006\u0010o\u001a\u0002092\b\u0010g\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010p\u001a\u00020;2\u0006\u0010B\u001a\u00020\b2\u0006\u0010i\u001a\u00020ZH\u0002J \u0010q\u001a\u00020;2\u0006\u0010B\u001a\u00020\b2\u0006\u0010r\u001a\u00020m2\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010s\u001a\u00020;2\u0006\u0010t\u001a\u00020u2\u0006\u0010B\u001a\u00020\b2\u0006\u0010r\u001a\u00020mH\u0002J\b\u0010v\u001a\u00020 H\u0016J\b\u0010w\u001a\u00020;H\u0016J\b\u0010x\u001a\u00020;H\u0016J\b\u0010y\u001a\u00020;H\u0016J(\u0010z\u001a\u00020;2\u0006\u0010B\u001a\u00020\b2\u0006\u0010{\u001a\u0002072\u0006\u0010|\u001a\u00020V2\u0006\u0010?\u001a\u00020mH\u0002J\n\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u0010}\u001a\u00020;2\u0006\u0010~\u001a\u00020\u007fH\u0016J\t\u0010\u0080\u0001\u001a\u00020;H\u0016J\t\u0010\u0081\u0001\u001a\u00020;H\u0016J\t\u0010\u0082\u0001\u001a\u00020;H\u0016J\t\u0010\u0083\u0001\u001a\u00020;H\u0016J\u001f\u0010\u0083\u0001\u001a\u00020;2\u0014\u0010\u0084\u0001\u001a\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020c0\u0085\u0001H\u0016J0\u0010\u0086\u0001\u001a\u00020;2\u0007\u0010\u0087\u0001\u001a\u0002092\u0006\u0010g\u001a\u00020\b2\u0014\u0010\u0088\u0001\u001a\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020c0\u0085\u0001H\u0016J/\u0010\u0089\u0001\u001a\u00020;2\u0006\u0010f\u001a\u0002092\u0006\u0010g\u001a\u00020\b2\u0014\u0010\u0088\u0001\u001a\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020c0\u0085\u0001H\u0016J\t\u0010\u008a\u0001\u001a\u00020;H\u0016J\u0019\u0010\u008b\u0001\u001a\u00020;2\u000e\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00020;0\u008d\u0001H\u0002J\u001d\u0010\u008e\u0001\u001a\u00020;2\u0007\u0010\u008f\u0001\u001a\u00020\b2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010cH\u0016J%\u0010\u008e\u0001\u001a\u00020;2\u0007\u0010\u008f\u0001\u001a\u00020\b2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010c2\u0006\u0010F\u001a\u00020 H\u0016J\u0013\u0010\u0091\u0001\u001a\u00020;2\b\u0010B\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u0092\u0001\u001a\u00020;2\u0007\u0010\u0093\u0001\u001a\u00020 H\u0016J\u001e\u0010\u0094\u0001\u001a\u00020;2\b\u0010H\u001a\u0004\u0018\u0001052\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\bH\u0016J\t\u0010\u0096\u0001\u001a\u00020;H\u0016J\u001f\u0010\u0097\u0001\u001a\u00020;2\u0014\u0010\u0088\u0001\u001a\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020c0\u0085\u0001H\u0016J\u001f\u0010\u0098\u0001\u001a\u00020;2\u0014\u0010\u0099\u0001\u001a\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020c0\u0085\u0001H\u0016J\u001b\u0010\u009a\u0001\u001a\u00020;2\u0007\u0010\u009b\u0001\u001a\u00020S2\u0007\u0010\u009c\u0001\u001a\u00020SH\u0016J\u001b\u0010\u009d\u0001\u001a\u00030\u009e\u0001*\u00030\u009e\u00012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010.H\u0002R\u000e\u0010\u000b\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 \u0001"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/LynxKitView;", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxKitViewService;", "Lcom/lynx/tasm/navigator/LynxHolder;", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "kitService", "Lcom/bytedance/ies/bullet/lynx/LynxKitService;", "sessionId", "", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;Lcom/bytedance/ies/bullet/lynx/LynxKitService;Ljava/lang/String;)V", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;Lcom/bytedance/ies/bullet/lynx/LynxKitService;)V", "annieXContainerSessionId", "getContext", "()Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "setContext", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;)V", "contextProviderFactory", "Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;", "getContextProviderFactory", "()Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;", "setContextProviderFactory", "(Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;)V", "currentSessionId", "delegate", "Lcom/bytedance/ies/bullet/lynx/AbsLynxDelegate;", "getDelegate", "()Lcom/bytedance/ies/bullet/lynx/AbsLynxDelegate;", "setDelegate", "(Lcom/bytedance/ies/bullet/lynx/AbsLynxDelegate;)V", "eventHandler", "Lcom/bytedance/ies/bullet/service/base/IEventHandler;", "isViewFirstAppeared", "", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitType", "()Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "setKitType", "(Lcom/bytedance/ies/bullet/service/base/utils/KitType;)V", "kitViewCallback", "Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;", "getKitViewCallback", "()Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;", "setKitViewCallback", "(Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;)V", "lynxInitParams", "Lcom/bytedance/ies/bullet/lynx/LynxKitInitParams;", "lynxMonitorProvider", "Lcom/bytedance/android/monitorV2/lynx/jsb/LynxViewProvider;", "lynxViewClient", "Lcom/bytedance/ies/bullet/lynx/impl/DefaultLynxViewClient;", "rawUrl", "realView", "Lcom/lynx/tasm/LynxView;", "resourceInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "templateData", "", "createLynxView", "", "lynxKitInitParams", "route", "Lcom/lynx/tasm/navigator/LynxRoute;", "listener", "Lcom/lynx/tasm/navigator/LynxViewCreationListener;", "deleteResourceWhen100Error", "url", "error", "Lcom/lynx/tasm/LynxError;", "destroy", "useDelegate", "dismissLynxView", "view", "ensureViewCreated", "schemaUrl", "getForestSessionId", "getSccLevel", "Lcom/bytedance/ies/bullet/secure/SccConfig$SccLevel;", "getSdkVersion", "getSessionId", "getStrategyById", "Lcom/lynx/tasm/ThreadStrategyForRendering;", "id", "", "(Ljava/lang/Integer;)Lcom/lynx/tasm/ThreadStrategyForRendering;", "getTaskConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "useConfig", "getTemplateBundleResponse", "Lcom/bytedance/forest/postprocessor/ProcessedResponse;", "Lcom/lynx/tasm/TemplateBundle;", "response", "Lcom/bytedance/forest/model/Response;", "getViewTag", "initMonitorConfig", "lynxview", "listenPreserveDataChanged", "callback", "Lkotlin/Function1;", "", "onlyGetPreserveData", "load", "templateArray", "baseUrl", "Lcom/bytedance/ies/bullet/service/base/ILoadUriListener;", "templateBundle", "loadResource", "useForest", "inputTaskConfig", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "loadTemplate", "byteArray", "loadTemplateBundle", "loadUri", "lifeCycle", "loadUriInner", "uri", "Landroid/net/Uri;", "onBackPressed", "onHide", "onShow", "quit", "readTemplateData", "resInfo", "config", "registerSecureService", "service", "Lcom/bytedance/ies/argus/api/interfaces/service/ArgusBaseBizService;", "reload", "reloadCurrentUrl", "reloadTemplate", "reloadTemplateWithGlobalProps", "globalProps", "", "renderSSR", "template", "data", "renderSSRHydrate", "resetData", "runOnUiThread", "action", "Lkotlin/Function0;", "sendEvent", SchemaConstants.INNER_PARAM_EVENT_NAME, "params", "setNpthLastUrl", "setPreCreate", GlobalPropertiesConstants.IS_PRE_CREATE, "showLynxView", "name", "triggerBlankDetect", "updateData", "updateGlobalProps", "globalprops", "updateScreenMetrics", "width", "height", EventConstants.PARAM_SOURCE_INIT, "Lcom/lynx/tasm/LynxViewBuilder;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxKitView implements ILynxKitViewService, LynxHolder {
    private static int CONTAINER_ID = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "LynxKitView";
    private String annieXContainerSessionId;
    private IServiceToken context;
    private IContextProviderFactory contextProviderFactory;
    private String currentSessionId;
    private AbsLynxDelegate delegate;
    private IEventHandler eventHandler;
    private boolean isViewFirstAppeared;
    private final LynxKitService kitService;
    private KitType kitType;
    private KitViewCallback kitViewCallback;
    private LynxKitInitParams lynxInitParams;
    private final LynxViewProvider lynxMonitorProvider;
    private DefaultLynxViewClient lynxViewClient;
    private String rawUrl;
    private LynxView realView;
    private ResourceInfo resourceInfo;
    private byte[] templateData;

    public void dismissLynxView(LynxView view) {
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void reloadCurrentUrl() {
    }

    @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService
    public void setPreCreate(boolean isPreCreate) {
    }

    public void showLynxView(LynxView view, String name) {
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void triggerBlankDetect() {
    }

    public LynxKitView(IServiceToken iServiceToken, LynxKitService lynxKitService) {
        Intrinsics.checkNotNullParameter(iServiceToken, "context");
        Intrinsics.checkNotNullParameter(lynxKitService, "kitService");
        this.context = iServiceToken;
        this.kitService = lynxKitService;
        this.kitType = KitType.LYNX;
        this.lynxMonitorProvider = new LynxViewProvider((LynxView) null, 1, (DefaultConstructorMarker) null);
        AbsLynxDelegate provideDelegate = lynxKitService.provideDelegate(lynxKitService, getContext());
        provideDelegate.bindKitView(this);
        this.delegate = provideDelegate;
        this.eventHandler = provideDelegate.createEventHandler();
        this.currentSessionId = "";
        this.rawUrl = "";
        this.isViewFirstAppeared = true;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public IServiceToken getContext() {
        return this.context;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void setContext(IServiceToken iServiceToken) {
        Intrinsics.checkNotNullParameter(iServiceToken, "<set-?>");
        this.context = iServiceToken;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LynxKitView(IServiceToken iServiceToken, LynxKitService lynxKitService, String str) {
        this(iServiceToken, lynxKitService);
        Intrinsics.checkNotNullParameter(iServiceToken, "context");
        Intrinsics.checkNotNullParameter(lynxKitService, "kitService");
        Intrinsics.checkNotNullParameter(str, "sessionId");
        this.annieXContainerSessionId = str;
        AbsLynxDelegate provideDelegate = lynxKitService.provideDelegate(lynxKitService, iServiceToken, str);
        provideDelegate.bindKitView(this);
        this.delegate = provideDelegate;
        this.eventHandler = provideDelegate.createEventHandler();
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public KitType getKitType() {
        return this.kitType;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void setKitType(KitType kitType) {
        Intrinsics.checkNotNullParameter(kitType, "<set-?>");
        this.kitType = kitType;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public IContextProviderFactory getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void setContextProviderFactory(IContextProviderFactory iContextProviderFactory) {
        this.contextProviderFactory = iContextProviderFactory;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public KitViewCallback getKitViewCallback() {
        return this.kitViewCallback;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void setKitViewCallback(KitViewCallback kitViewCallback) {
        this.kitViewCallback = kitViewCallback;
    }

    public final AbsLynxDelegate getDelegate() {
        return this.delegate;
    }

    public final void setDelegate(AbsLynxDelegate absLynxDelegate) {
        Intrinsics.checkNotNullParameter(absLynxDelegate, "<set-?>");
        this.delegate = absLynxDelegate;
    }

    /* compiled from: LynxKitView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/LynxKitView$Companion;", "", "()V", "CONTAINER_ID", "", "getCONTAINER_ID", "()I", "setCONTAINER_ID", "(I)V", "TAG", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getCONTAINER_ID() {
            return LynxKitView.CONTAINER_ID;
        }

        public final void setCONTAINER_ID(int i) {
            LynxKitView.CONTAINER_ID = i;
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    /* renamed from: getSessionId, reason: from getter */
    public String getCurrentSessionId() {
        return this.currentSessionId;
    }

    private final String getForestSessionId() {
        ForestSessionId forestSessionId;
        String forestSessionId2;
        String currentSessionId = getCurrentSessionId();
        return (!IConditionCallKt.enablePreloadBeforeLoad() || !Intrinsics.areEqual(this.kitService.getBid(), BidConstants.WEBCAST) || (forestSessionId = (ForestSessionId) ContextProviderManager.INSTANCE.getProviderFactory(currentSessionId).provideInstance(ForestSessionId.class)) == null || (forestSessionId2 = forestSessionId.getForestSessionId()) == null) ? currentSessionId : forestSessionId2;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public String getViewTag() {
        return "Lynx View(" + LynxEnv.inst().getLynxVersion() + ')';
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public boolean ensureViewCreated() {
        createLynxView(this.delegate.provideLynxInitParams());
        return true;
    }

    @Override // com.bytedance.ies.bullet.IBulletKitViewService, com.bytedance.ies.bullet.service.base.IKitViewService
    public boolean ensureViewCreated(String schemaUrl) {
        Intrinsics.checkNotNullParameter(schemaUrl, "schemaUrl");
        String str = this.annieXContainerSessionId;
        if (str == null) {
            return false;
        }
        AbsLynxDelegate absLynxDelegate = this.delegate;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("annieXContainerSessionId");
            str = null;
        }
        absLynxDelegate.parseSchema(schemaUrl, str);
        createLynxView(this.delegate.provideLynxInitParams());
        return true;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public LynxView realView() {
        return this.realView;
    }

    @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService
    public void load(byte[] templateArray, String baseUrl) {
        TemplateData templateData;
        LynxLoadMeta.Builder lynxLoadMeta;
        LynxView lynxView;
        LynxLoadMeta.Builder lynxLoadMeta2;
        LynxInitData initData;
        Intrinsics.checkNotNullParameter(templateArray, "templateArray");
        if (baseUrl != null) {
            this.rawUrl = baseUrl;
        }
        this.templateData = templateArray;
        Map<String, Object> globalProps = this.delegate.getGlobalProps();
        LynxView lynxView2 = this.realView;
        if (lynxView2 != null) {
            lynxView2.updateGlobalProps(globalProps);
        }
        LynxKitInitParams lynxKitInitParams = this.lynxInitParams;
        if (lynxKitInitParams == null || (initData = lynxKitInitParams.getInitData()) == null || (templateData = initData.getMData()) == null) {
            LynxKitInitParams lynxKitInitParams2 = this.lynxInitParams;
            templateData = lynxKitInitParams2 != null ? lynxKitInitParams2.getTemplateData() : null;
        }
        LynxKitInitParams lynxKitInitParams3 = this.lynxInitParams;
        if (lynxKitInitParams3 != null && (lynxLoadMeta2 = lynxKitInitParams3.getLynxLoadMeta()) != null) {
            lynxLoadMeta2.setBinaryData(templateArray);
            lynxLoadMeta2.setInitialData(templateData);
            lynxLoadMeta2.setUrl(baseUrl);
        }
        LynxRenderCallback provideRenderCallback = this.delegate.provideRenderCallback();
        if (provideRenderCallback != null) {
            provideRenderCallback.beforeRender();
        }
        LynxKitInitParams lynxKitInitParams4 = this.lynxInitParams;
        if ((lynxKitInitParams4 != null ? lynxKitInitParams4.getLynxLoadMeta() : null) != null) {
            LynxKitInitParams lynxKitInitParams5 = this.lynxInitParams;
            if (lynxKitInitParams5 != null && (lynxLoadMeta = lynxKitInitParams5.getLynxLoadMeta()) != null && (lynxView = this.realView) != null) {
                lynxView.loadTemplate(lynxLoadMeta.build());
            }
        } else {
            LynxView lynxView3 = this.realView;
            if (lynxView3 != null) {
                lynxView3.renderTemplateWithBaseUrl(templateArray, templateData, baseUrl);
            }
        }
        LynxRenderCallback provideRenderCallback2 = this.delegate.provideRenderCallback();
        if (provideRenderCallback2 != null) {
            provideRenderCallback2.afterRender();
        }
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "load with template array", "XLynxKit", null, 8, null);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void load(final String url, final ILoadUriListener listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        IBulletKitViewService.DefaultImpls.loadUri$default(this, url, new IBulletLifeCycle.Base() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$load$5
            @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
            public void onLoadUriSuccess(Uri uri, IKitViewService kitView) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                ILoadUriListener iLoadUriListener = ILoadUriListener.this;
                if (iLoadUriListener != null) {
                    iLoadUriListener.onLoadSuccess(url, this);
                }
            }

            @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
            public void onLoadFail(Uri uri, Throwable e) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                Intrinsics.checkNotNullParameter(e, "e");
                ILoadUriListener iLoadUriListener = ILoadUriListener.this;
                if (iLoadUriListener != null) {
                    iLoadUriListener.onLoadFailed(url, this, e);
                }
            }
        }, null, 4, null);
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "load with url: " + url, "XLynxKit", null, 8, null);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void renderSSR(byte[] template, String baseUrl, Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(data, "data");
        this.rawUrl = baseUrl;
        LynxRenderCallback provideRenderCallback = this.delegate.provideRenderCallback();
        if (provideRenderCallback != null) {
            provideRenderCallback.beforeRender();
        }
        LynxView lynxView = this.realView;
        if (lynxView != null) {
            lynxView.renderSSR(template, baseUrl, data);
        }
        LynxRenderCallback provideRenderCallback2 = this.delegate.provideRenderCallback();
        if (provideRenderCallback2 != null) {
            provideRenderCallback2.afterRender();
        }
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "load with template array", "XLynxKit", null, 8, null);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void renderSSRHydrate(byte[] templateArray, String baseUrl, Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(templateArray, "templateArray");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(data, "data");
        this.rawUrl = baseUrl;
        Map<String, Object> globalProps = this.delegate.getGlobalProps();
        LynxView lynxView = this.realView;
        if (lynxView != null) {
            lynxView.updateGlobalProps(globalProps);
        }
        LynxView lynxView2 = this.realView;
        if (lynxView2 != null) {
            lynxView2.ssrHydrate(templateArray, baseUrl, data);
        }
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "load with template array", "XLynxKit", null, 8, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0085, code lost:
    
        if (r2.getUseCardMode() == true) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initMonitorConfig(LynxView lynxview) {
        String str;
        boolean z;
        Iterator<String> keys;
        BulletContext context = this.delegate.getContext();
        if (context == null || (str = context.getBid()) == null) {
            str = "default_bid";
        }
        MonitorReportService monitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(str, IMonitorReportService.class);
        if (monitorReportService == null) {
            monitorReportService = MonitorReportService.INSTANCE.getFallbackDefault();
        }
        MonitorConfig config = monitorReportService.getConfig();
        LynxViewMonitorConfig lynxViewMonitorConfig = new LynxViewMonitorConfig(config.getBizTag());
        lynxViewMonitorConfig.setVirtualAID(config.getVirtualAID());
        AbsLynxDelegate absLynxDelegate = this.delegate;
        DefaultLynxDelegate defaultLynxDelegate = absLynxDelegate instanceof DefaultLynxDelegate ? (DefaultLynxDelegate) absLynxDelegate : null;
        lynxViewMonitorConfig.setBlankDetectCallback(new DefaultLynxBlankCallback(new WeakReference(defaultLynxDelegate != null ? defaultLynxDelegate.getBulletContext() : null)));
        lynxViewMonitorConfig.setEnableMonitor(config.getLogSwitch());
        lynxViewMonitorConfig.setFallbackContainerName("bullet");
        lynxViewMonitorConfig.setSessionId(getForestSessionId());
        BulletContext context2 = BulletContextManager.INSTANCE.getInstance().getContext(getCurrentSessionId());
        if (context2 != null) {
            z = true;
        }
        z = false;
        if (z) {
            lynxViewMonitorConfig.setEnableBlankDetect(false);
        }
        LynxViewMonitorHelper.registerLynxMonitor(lynxview, lynxViewMonitorConfig);
        JSONObject category = config.getCategory();
        if (category == null || (keys = category.keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
            Intrinsics.checkNotNullExpressionValue(next, "it");
            JSONObject category2 = config.getCategory();
            Intrinsics.checkNotNull(category2);
            instance.addContext(lynxview, next, category2.get(next).toString());
        }
    }

    @Override // com.bytedance.ies.bullet.IBulletKitViewService
    public void loadUri(final String url, final IBulletLifeCycle lifeCycle, String sessionId) {
        String str;
        Unit loadAsync;
        StringParam loaderName;
        String value;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(lifeCycle, "lifeCycle");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        setContextProviderFactory(ContextProviderManager.INSTANCE.getProviderFactory(sessionId));
        this.delegate.onLoadStart(sessionId);
        final Uri parse = Uri.parse(url);
        final SchemaModelUnion parseSchema = this.delegate.parseSchema(url, sessionId);
        runOnUiThread(new Function0<Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadUri$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m511invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m511invoke() {
                IBulletLifeCycle iBulletLifeCycle = IBulletLifeCycle.this;
                Uri uri = parse;
                Intrinsics.checkNotNullExpressionValue(uri, "uri");
                iBulletLifeCycle.onLoadModelSuccess(uri, this, parseSchema);
            }
        });
        final String debugUrl = this.delegate.getDebugUrl();
        if (debugUrl != null) {
            ISchemaModel containerModel = parseSchema.getContainerModel();
            BDXContainerModel bDXContainerModel = containerModel instanceof BDXContainerModel ? (BDXContainerModel) containerModel : null;
            if (bDXContainerModel == null || (loaderName = bDXContainerModel.getLoaderName()) == null || (value = loaderName.getValue()) == null) {
                str = null;
            } else {
                str = value.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase()");
            }
            final boolean areEqual = Intrinsics.areEqual(str, "forest");
            final Function1<ResourceInfo, Unit> function1 = new Function1<ResourceInfo, Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadUri$2$onSuccess$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ResourceInfo) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(ResourceInfo resourceInfo) {
                    Intrinsics.checkNotNullParameter(resourceInfo, "it");
                    final InputStream provideInputStream = resourceInfo.provideInputStream();
                    if (provideInputStream != null) {
                        boolean z = areEqual;
                        final LynxKitView lynxKitView = this;
                        final Uri uri = parse;
                        final String str2 = url;
                        final IBulletLifeCycle iBulletLifeCycle = lifeCycle;
                        try {
                            BulletLogger.printLog$default(BulletLogger.INSTANCE, (z ? "Forest" : "RL").concat(" get initial data from debug url success"), null, "XLynxKit", 2, null);
                            Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadUri$2$onSuccess$1$1$1
                                @Override // java.util.concurrent.Callable
                                public /* bridge */ /* synthetic */ Object call() {
                                    call();
                                    return Unit.INSTANCE;
                                }

                                @Override // java.util.concurrent.Callable
                                public final void call() {
                                    LynxKitView.this.getDelegate().setDebugInitialData(new String(ByteStreamsKt.readBytes(provideInputStream), Charsets.UTF_8));
                                    LynxKitView lynxKitView2 = LynxKitView.this;
                                    Uri uri2 = uri;
                                    Intrinsics.checkNotNullExpressionValue(uri2, "uri");
                                    lynxKitView2.loadUriInner(uri2, str2, iBulletLifeCycle);
                                }
                            }, Task.UI_THREAD_EXECUTOR);
                        } catch (Throwable unused) {
                            BulletLogger.printLog$default(BulletLogger.INSTANCE, (z ? "Forest" : "RL").concat(" failed to get initial data from debug url"), null, "XLynxKit", 2, null);
                        }
                    }
                }
            };
            final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadUri$2$onFailed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "it");
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, (areEqual ? "Forest" : "RL").concat(" failed to get initial data from debug url"), null, "XLynxKit", 2, null);
                    final LynxKitView lynxKitView = this;
                    final Uri uri = parse;
                    final String str2 = url;
                    final IBulletLifeCycle iBulletLifeCycle = lifeCycle;
                    Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadUri$2$onFailed$1.1
                        @Override // java.util.concurrent.Callable
                        public /* bridge */ /* synthetic */ Object call() {
                            call();
                            return Unit.INSTANCE;
                        }

                        @Override // java.util.concurrent.Callable
                        public final void call() {
                            LynxKitView lynxKitView2 = LynxKitView.this;
                            Uri uri2 = uri;
                            Intrinsics.checkNotNullExpressionValue(uri2, "uri");
                            lynxKitView2.loadUriInner(uri2, str2, iBulletLifeCycle);
                        }
                    }, Task.UI_THREAD_EXECUTOR);
                }
            };
            TaskConfig taskConfig = new TaskConfig(null, 1, null);
            CustomLoaderConfig customLoaderConfig = new CustomLoaderConfig(true);
            customLoaderConfig.setLoaderSequence(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.CDN}));
            taskConfig.setLoaderConfig(customLoaderConfig);
            taskConfig.setTaskContext(TaskContext.INSTANCE.from(getContext().getAllDependency()));
            taskConfig.setResTag("lynx");
            if (areEqual) {
                ForestLoader forestLoader = ForestLoader.INSTANCE;
                LynxKitInitParams lynxKitInitParams = this.lynxInitParams;
                String forestDownloadEngine = lynxKitInitParams != null ? lynxKitInitParams.getForestDownloadEngine() : null;
                Scene scene = Scene.LYNX_TEMPLATE;
                String forestSessionId = getForestSessionId();
                if (taskConfig.getBid().length() == 0) {
                    this.kitService.getBid();
                }
                Unit unit = Unit.INSTANCE;
                forestLoader.loadAsync((r22 & 1) != 0 ? forestLoader.getDefault() : null, debugUrl, (r22 & 4) != 0 ? null : forestDownloadEngine, scene, forestSessionId, (r22 & 32) != 0 ? null : taskConfig, (r22 & 64) != 0 ? false : false, (r22 & 128) != 0 ? null : null, new Function1<Response, Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadUri$2$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Response) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Response response) {
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (response.isSucceed()) {
                            function1.invoke(new ForestResourceInfo(Uri.parse(debugUrl), response));
                        } else {
                            function12.invoke(new IllegalStateException("Forest load " + url + " failed, msg=" + response.getErrorInfo()));
                        }
                    }
                });
                loadAsync = Unit.INSTANCE;
            } else {
                loadAsync = ResourceLoader.with$default(ResourceLoader.INSTANCE, this.kitService.getBid(), null, 2, null).loadAsync(debugUrl, taskConfig, new Function1<ResourceInfo, Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadUri$2$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ResourceInfo) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ResourceInfo resourceInfo) {
                        Intrinsics.checkNotNullParameter(resourceInfo, "_resourceInfo");
                        function1.invoke(resourceInfo);
                    }
                }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadUri$2$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Throwable) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "it");
                        function12.invoke(th);
                    }
                });
            }
            if (loadAsync != null) {
                return;
            }
        }
        Intrinsics.checkNotNullExpressionValue(parse, "uri");
        loadUriInner(parse, url, lifeCycle);
        Unit unit2 = Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadUriInner(final Uri uri, final String url, final IBulletLifeCycle lifeCycle) {
        TaskConfig taskConfig;
        BulletContainerContext containerContext;
        AbsBulletMonitorCallback monitorCallback;
        BulletContext context = this.delegate.getContext();
        if (context != null && (monitorCallback = context.getMonitorCallback()) != null) {
            monitorCallback.onKitViewCreateBegin();
        }
        LynxKitInitParams provideLynxInitParams = this.delegate.provideLynxInitParams();
        createLynxView(provideLynxInitParams);
        LynxView lynxView = this.realView;
        if (lynxView == null) {
            runOnUiThread(new Function0<Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadUriInner$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m512invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m512invoke() {
                    IBulletLifeCycle.this.onLoadFail(uri, new Throwable("create lynx view fail"));
                }
            });
            return;
        }
        Intrinsics.checkNotNull(lynxView);
        initMonitorConfig(lynxView);
        SLMonitorCompat sLMonitorCompat = SLMonitorCompat.INSTANCE;
        String currentSessionId = getCurrentSessionId();
        LynxView lynxView2 = this.realView;
        Intrinsics.checkNotNull(lynxView2);
        sLMonitorCompat.collectLynxBaseField(currentSessionId, lynxView2);
        LynxView lynxView3 = this.realView;
        if (lynxView3 != null) {
            lynxView3.addLynxViewClient(new LynxViewClient() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadUriInner$2
                public void onLoadSuccess() {
                    IBulletLifeCycle.this.onLoadUriSuccess(uri, this);
                }

                public void onRuntimeReady() {
                    IBulletLifeCycle.this.onRuntimeReady(uri, this);
                }

                public void onReceivedError(LynxError error) {
                    this.deleteResourceWhen100Error(url, error);
                    boolean z = false;
                    if (error != null && error.isFatal()) {
                        z = true;
                    }
                    if (z) {
                        IBulletLifeCycle.this.onLoadFail(uri, new Throwable(error.toString()));
                    }
                }
            });
        }
        runOnUiThread(new Function0<Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadUriInner$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m513invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m513invoke() {
                IBulletLifeCycle.this.onKitViewCreate(uri, this);
            }
        });
        AbsLynxDelegate absLynxDelegate = this.delegate;
        LynxView lynxView4 = this.realView;
        Intrinsics.checkNotNull(lynxView4);
        absLynxDelegate.onLynxViewCreated((View) lynxView4);
        BulletContext context2 = this.delegate.getContext();
        SSRConfig ssrConfig = (context2 == null || (containerContext = context2.getContainerContext()) == null) ? null : containerContext.getSsrConfig();
        if (ssrConfig != null && ssrConfig.getEnabled()) {
            renderSSR(ssrConfig.getByteArray(), ssrConfig.getUrl(), ssrConfig.getData());
            return;
        }
        TemplateBundle templateBundle = provideLynxInitParams != null ? provideLynxInitParams.getTemplateBundle() : null;
        if (templateBundle == null && PreloadV2.INSTANCE.getEnablePreload()) {
            TaskConfig taskConfig2 = getTaskConfig(url, true);
            String generateKey = PreloadHelper.INSTANCE.generateKey(taskConfig2, null, url);
            HybridLogger.i$default(HybridLogger.INSTANCE, "XPreload", "get template from TemplateMemoryCache", null, null, 12, null);
            PreloadItem cache = TemplateMemCache.INSTANCE.getCache(generateKey);
            if (cache != null) {
                TemplatePreloadItem templatePreloadItem = cache instanceof TemplatePreloadItem ? (TemplatePreloadItem) cache : null;
                templateBundle = templatePreloadItem != null ? templatePreloadItem.getTemplateBundle() : null;
                if (templateBundle != null) {
                    BulletContext context3 = BulletContextManager.INSTANCE.getInstance().getContext(getCurrentSessionId());
                    BulletRLContext resourceContext = context3 != null ? context3.getResourceContext() : null;
                    if (resourceContext != null) {
                        resourceContext.setResMemory(true);
                    }
                    HybridLogger.i$default(HybridLogger.INSTANCE, "XPreload", "get templateBundle successfully", null, null, 12, null);
                    TemplateMemCache.INSTANCE.removeCache(generateKey);
                    HybridLogger.i$default(HybridLogger.INSTANCE, "XPreload", "remove templateBundle from cache", null, null, 12, null);
                }
            }
            taskConfig = taskConfig2;
        } else {
            taskConfig = null;
        }
        if (templateBundle != null && this.realView != null) {
            BulletContext context4 = BulletContextManager.INSTANCE.getInstance().getContext(getCurrentSessionId());
            BulletRLContext resourceContext2 = context4 != null ? context4.getResourceContext() : null;
            if (resourceContext2 != null) {
                resourceContext2.setResFrom("templateBundle");
            }
            loadTemplateBundle(url, templateBundle);
            return;
        }
        loadResource(url, true, provideLynxInitParams.getUseForest(), taskConfig, lifeCycle);
    }

    private final void loadTemplateBundle(final String url, final TemplateBundle templateBundle) {
        LynxKitInitParams lynxKitInitParams = this.lynxInitParams;
        boolean z = false;
        if (lynxKitInitParams != null && !lynxKitInitParams.getReadResourceInfoInMainThread()) {
            z = true;
        }
        if (z) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadTemplateBundle$1
                    @Override // java.util.concurrent.Callable
                    public /* bridge */ /* synthetic */ Object call() {
                        call();
                        return Unit.INSTANCE;
                    }

                    @Override // java.util.concurrent.Callable
                    public final void call() {
                        LynxKitView.this.load(url, templateBundle);
                    }
                });
                return;
            } else {
                load(url, templateBundle);
                return;
            }
        }
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            load(url, templateBundle);
        } else {
            Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadTemplateBundle$2
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    LynxKitView.this.load(url, templateBundle);
                }
            }, Task.UI_THREAD_EXECUTOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001a, code lost:
    
        if (r0 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void load(String url, TemplateBundle templateBundle) {
        String str;
        TemplateData templateData;
        LynxLoadMeta.Builder lynxLoadMeta;
        LynxView lynxView;
        LynxLoadMeta.Builder lynxLoadMeta2;
        LynxInitData initData;
        try {
            if (IConditionCallKt.fixLynxUrlOfHdt()) {
                Uri parse = Uri.parse(url);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
                str = ExtKt.getCDN(parse, this.kitService.getBid());
            }
            str = url;
            this.rawUrl = str;
            setNpthLastUrl(url);
            LynxKitInitParams lynxKitInitParams = this.lynxInitParams;
            if (lynxKitInitParams == null || (initData = lynxKitInitParams.getInitData()) == null || (templateData = initData.getMData()) == null) {
                LynxKitInitParams lynxKitInitParams2 = this.lynxInitParams;
                templateData = lynxKitInitParams2 != null ? lynxKitInitParams2.getTemplateData() : null;
            }
            LynxKitInitParams lynxKitInitParams3 = this.lynxInitParams;
            if (lynxKitInitParams3 != null && (lynxLoadMeta2 = lynxKitInitParams3.getLynxLoadMeta()) != null) {
                lynxLoadMeta2.setInitialData(templateData);
                lynxLoadMeta2.setUrl(str);
                lynxLoadMeta2.setTemplateBundle(templateBundle);
            }
            LynxRenderCallback provideRenderCallback = this.delegate.provideRenderCallback();
            if (provideRenderCallback != null) {
                provideRenderCallback.beforeRender();
            }
            Map<String, Object> globalProps = this.delegate.getGlobalProps();
            LynxView lynxView2 = this.realView;
            Intrinsics.checkNotNull(lynxView2);
            lynxView2.updateGlobalProps(globalProps);
            LynxKitInitParams lynxKitInitParams4 = this.lynxInitParams;
            if ((lynxKitInitParams4 != null ? lynxKitInitParams4.getLynxLoadMeta() : null) != null) {
                LynxKitInitParams lynxKitInitParams5 = this.lynxInitParams;
                if (lynxKitInitParams5 != null && (lynxLoadMeta = lynxKitInitParams5.getLynxLoadMeta()) != null && (lynxView = this.realView) != null) {
                    lynxView.loadTemplate(lynxLoadMeta.build());
                }
            } else {
                LynxView lynxView3 = this.realView;
                Intrinsics.checkNotNull(lynxView3);
                lynxView3.renderTemplateBundle(templateBundle, templateData, str);
            }
            LynxRenderCallback provideRenderCallback2 = this.delegate.provideRenderCallback();
            if (provideRenderCallback2 != null) {
                provideRenderCallback2.afterRender();
            }
            BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "load with templateBundle", "XLynxKit", null, 8, null);
        } catch (Throwable th) {
            BulletLogger.INSTANCE.printReject(th, "load with templateBundle", "XLynxKit");
        }
    }

    private final void runOnUiThread(final Function0<Unit> action) {
        BulletContext context = this.delegate.getContext();
        boolean z = false;
        if (context != null && BulletContextKt.forceLifeCycleOnUiThread(context)) {
            z = true;
        }
        if (z && !Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$runOnUiThread$1
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    action.invoke();
                }
            }, Task.UI_THREAD_EXECUTOR);
        } else {
            action.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteResourceWhen100Error(String url, LynxError error) {
        if (error == null || error.getErrorCode() != 102 || this.resourceInfo == null) {
            return;
        }
        Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$deleteResourceWhen100Error$1$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                LynxKitService lynxKitService;
                ArrayList arrayList;
                ResourceInfo resourceInfo;
                ResourceInfo resourceInfo2;
                ResourceInfo resourceInfo3;
                LynxKitService lynxKitService2;
                ResourceInfo resourceInfo4;
                InputStream provideInputStream;
                ResourceInfo resourceInfo5;
                BulletSettings provideBulletSettings;
                lynxKitService = LynxKitView.this.kitService;
                ISettingService iSettingService = (ISettingService) lynxKitService.getService(ISettingService.class);
                if (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null || (arrayList = provideBulletSettings.getDeleteWhen100ErrorList()) == null) {
                    arrayList = new ArrayList();
                }
                boolean isEmpty = arrayList.isEmpty();
                Iterator<String> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    resourceInfo5 = LynxKitView.this.resourceInfo;
                    if (StringsKt.contains$default(String.valueOf(resourceInfo5 != null ? resourceInfo5.getSrcUri() : null), next, false, 2, (Object) null)) {
                        isEmpty = true;
                        break;
                    }
                }
                resourceInfo = LynxKitView.this.resourceInfo;
                if (resourceInfo != null && (provideInputStream = resourceInfo.provideInputStream()) != null) {
                    try {
                        provideInputStream.reset();
                    } catch (Throwable th) {
                        BulletLogger.printLog$default(BulletLogger.INSTANCE, "lynx error, read file failed " + th.getMessage(), null, "XLynxKit", 2, null);
                    }
                }
                if (isEmpty) {
                    resourceInfo2 = LynxKitView.this.resourceInfo;
                    if (resourceInfo2 != null) {
                        BulletLogger bulletLogger = BulletLogger.INSTANCE;
                        StringBuilder sb = new StringBuilder("lynx error, 100 error,delete local resource url=");
                        resourceInfo3 = LynxKitView.this.resourceInfo;
                        BulletLogger.printLog$default(bulletLogger, sb.append(resourceInfo3 != null ? resourceInfo3.getSrcUri() : null).toString(), null, "XLynxKit", 2, null);
                        ResourceLoader resourceLoader = ResourceLoader.INSTANCE;
                        lynxKitService2 = LynxKitView.this.kitService;
                        ResourceLoaderService with$default = ResourceLoader.with$default(resourceLoader, lynxKitService2.getBid(), null, 2, null);
                        resourceInfo4 = LynxKitView.this.resourceInfo;
                        Intrinsics.checkNotNull(resourceInfo4);
                        with$default.deleteResource(resourceInfo4);
                    }
                }
            }
        }, Task.BACKGROUND_EXECUTOR);
    }

    @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService
    public void resetData() {
        LynxView lynxView = this.realView;
        if (lynxView != null) {
            TemplateData provideTemplateData = this.delegate.provideTemplateData();
            if (provideTemplateData != null) {
                provideTemplateData.put("bullet_update_type", 0);
            } else {
                provideTemplateData = null;
            }
            lynxView.resetData(provideTemplateData);
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService
    public void listenPreserveDataChanged(final Function1<Object, Unit> callback, boolean onlyGetPreserveData) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (onlyGetPreserveData) {
            LynxView lynxView = this.realView;
            Map pageDataByKey = lynxView != null ? lynxView.getPageDataByKey(new String[]{"preserve_data"}) : null;
            if (pageDataByKey != null) {
                callback.invoke(pageDataByKey);
                return;
            } else {
                BulletLogger.INSTANCE.printLog("getPageDataByKey Failed", LogLevel.E, "PreserveData");
                return;
            }
        }
        LynxView lynxView2 = this.realView;
        if (lynxView2 != null) {
            lynxView2.getCurrentData(new LynxGetDataCallback() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$listenPreserveDataChanged$1
                public void onSuccess(JavaOnlyMap p0) {
                    HashMap hashMap = p0 instanceof HashMap ? (HashMap) p0 : null;
                    if (hashMap != null) {
                        callback.invoke(hashMap);
                    }
                }

                public void onFail(String p0) {
                    BulletLogger.INSTANCE.printLog("getCurrentData Failed " + p0, LogLevel.E, "PreserveData");
                }
            });
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService
    public void reloadTemplate() {
        LynxView lynxView = this.realView;
        if (lynxView != null) {
            TemplateData provideTemplateData = this.delegate.provideTemplateData();
            if (provideTemplateData != null) {
                provideTemplateData.put("bullet_update_type", 0);
            } else {
                provideTemplateData = null;
            }
            lynxView.reloadTemplate(provideTemplateData);
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService
    public void reloadTemplateWithGlobalProps() {
        LynxView lynxView = this.realView;
        if (lynxView != null) {
            TemplateData provideTemplateData = this.delegate.provideTemplateData();
            if (provideTemplateData != null) {
                provideTemplateData.put("bullet_update_type", 0);
            } else {
                provideTemplateData = null;
            }
            lynxView.reloadTemplate(provideTemplateData, TemplateData.fromMap(this.delegate.getGlobalProps()));
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService
    public void reloadTemplateWithGlobalProps(Map<String, ? extends Object> globalProps) {
        Intrinsics.checkNotNullParameter(globalProps, "globalProps");
        Map<String, Object> globalProps2 = this.delegate.getGlobalProps();
        globalProps2.putAll(globalProps);
        LynxView lynxView = this.realView;
        if (lynxView != null) {
            TemplateData provideTemplateData = this.delegate.provideTemplateData();
            if (provideTemplateData != null) {
                provideTemplateData.put("bullet_update_type", 0);
            } else {
                provideTemplateData = null;
            }
            lynxView.reloadTemplate(provideTemplateData, TemplateData.fromMap(globalProps2));
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService
    public void updateScreenMetrics(int width, int height) {
        if (width <= 0 || height <= 0) {
            return;
        }
        LynxKitInitParams lynxKitInitParams = this.lynxInitParams;
        if (lynxKitInitParams != null) {
            width = (int) (width * lynxKitInitParams.getViewZoom());
            height = (int) (height * lynxKitInitParams.getViewZoom());
        }
        LynxView lynxView = this.realView;
        if (lynxView != null) {
            lynxView.updateScreenMetrics(width, height);
        }
        LynxView lynxView2 = this.realView;
        if (lynxView2 != null) {
            lynxView2.requestLayout();
        }
        BulletLogger.INSTANCE.printLog("updateScreenMetrics w:" + width + " h:" + height + " view:" + this.realView, LogLevel.I, "XLynxKit");
    }

    private final TaskConfig getTaskConfig(String url, boolean useConfig) {
        TaskConfig taskConfig;
        LynxRenderCallback provideRenderCallback = this.delegate.provideRenderCallback();
        Uri parse = Uri.parse(url);
        if (!useConfig) {
            TaskConfig taskConfig2 = new TaskConfig(null, 1, null);
            taskConfig2.setBid(this.kitService.getBid());
            taskConfig2.setResTag("template");
            taskConfig2.setTaskContext(TaskContext.INSTANCE.from(getContext().getAllDependency()));
            try {
                Intrinsics.checkNotNullExpressionValue(parse, "resourceUri");
                String cdn = ExtKt.getCDN(parse, this.kitService.getBid());
                if (cdn != null) {
                    taskConfig2.setCdnUrl(cdn);
                }
                String queryParameter = parse.getQueryParameter("channel");
                if (queryParameter != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter, "it");
                    taskConfig2.setChannel(queryParameter);
                }
                String queryParameter2 = parse.getQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE);
                if (queryParameter2 != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter2, "it");
                    taskConfig2.setBundle(queryParameter2);
                }
                taskConfig2.setDynamic(1);
                String queryParameter3 = parse.getQueryParameter("dynamic");
                if (queryParameter3 == null) {
                    return taskConfig2;
                }
                Intrinsics.checkNotNullExpressionValue(queryParameter3, "it");
                taskConfig2.setDynamic(Integer.valueOf(Integer.parseInt(queryParameter3)));
                return taskConfig2;
            } catch (Throwable th) {
                BulletLogger.INSTANCE.printReject(th, "lynxkit.load parse url error", "XLynxKit");
                return taskConfig2;
            }
        }
        if (provideRenderCallback == null || (taskConfig = provideRenderCallback.provideTaskConfig()) == null) {
            taskConfig = new TaskConfig(null, 1, null);
            taskConfig.setBid(this.kitService.getBid());
            taskConfig.setResTag("template");
            taskConfig.setTaskContext(TaskContext.INSTANCE.from(getContext().getAllDependency()));
            try {
                Uri parse2 = Uri.parse(url);
                Intrinsics.checkNotNullExpressionValue(parse2, "uri");
                String cdn2 = ExtKt.getCDN(parse2, this.kitService.getBid());
                if (cdn2 != null) {
                    taskConfig.setCdnUrl(cdn2);
                }
                String queryParameter4 = parse2.getQueryParameter("channel");
                if (queryParameter4 != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter4, "it");
                    taskConfig.setChannel(queryParameter4);
                }
                String queryParameter5 = parse2.getQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE);
                if (queryParameter5 != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter5, "it");
                    taskConfig.setBundle(queryParameter5);
                }
                taskConfig.setDynamic(1);
                String queryParameter6 = parse2.getQueryParameter("dynamic");
                if (queryParameter6 != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter6, "it");
                    taskConfig.setDynamic(Integer.valueOf(Integer.parseInt(queryParameter6)));
                }
            } catch (Throwable th2) {
                BulletLogger.INSTANCE.printReject(th2, "lynxkit.load parse url error", "XLynxKit");
            }
        }
        return taskConfig;
    }

    private final void loadResource(final String url, boolean useConfig, final boolean useForest, TaskConfig inputTaskConfig, final IBulletLifeCycle listener) {
        LynxRenderCallback provideRenderCallback = this.delegate.provideRenderCallback();
        if (provideRenderCallback != null) {
            provideRenderCallback.beforeLoadTemplate();
        }
        final Uri parse = Uri.parse(url);
        if (provideRenderCallback != null) {
            provideRenderCallback.beforeLoadTemplateWithUrl(url);
        }
        TaskConfig taskConfig = inputTaskConfig == null ? getTaskConfig(url, useConfig) : inputTaskConfig;
        final TaskConfig taskConfig2 = taskConfig;
        final Function2<ResourceInfo, Boolean, Unit> function2 = new Function2<ResourceInfo, Boolean, Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadResource$onSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((ResourceInfo) obj, ((Boolean) obj2).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final ResourceInfo resourceInfo, boolean z) {
                LynxKitService lynxKitService;
                String str;
                LynxView lynxView;
                Intrinsics.checkNotNullParameter(resourceInfo, "it");
                LynxKitView.this.resourceInfo = resourceInfo;
                lynxKitService = LynxKitView.this.kitService;
                ITestService iTestService = (ITestService) lynxKitService.getService(ITestService.class);
                if (iTestService != null) {
                    TNativeEvent tNativeEvent = new TNativeEvent("TemplateResourceLoadResult");
                    tNativeEvent.getExtra().put("result", "success");
                    tNativeEvent.getExtra().put("resInfo", resourceInfo);
                    iTestService.onEvent(tNativeEvent);
                }
                str = LynxKitView.this.currentSessionId;
                if (str.length() > 0) {
                    lynxView = LynxKitView.this.realView;
                    if (lynxView != null) {
                        LynxViewMonitor.Companion.getINSTANCE().addContext(lynxView, "geckoId", String.valueOf(resourceInfo.getVersion()));
                        LynxViewMonitor.Companion.getINSTANCE().addContext(lynxView, "channel", resourceInfo.getChannel());
                    }
                    BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, LynxKitView.this.getCurrentSessionId(), (useForest ? "Forest" : "RL") + " finish loading template url: " + url, "XLynxKit", null, 8, null);
                }
                LynxRenderCallback provideRenderCallback2 = LynxKitView.this.getDelegate().provideRenderCallback();
                if (provideRenderCallback2 != null) {
                    provideRenderCallback2.loadTemplateReady(resourceInfo);
                }
                boolean areEqual = Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread());
                if (z) {
                    if (areEqual) {
                        LynxKitView.this.readTemplateData(url, resourceInfo, taskConfig2, listener);
                        return;
                    }
                    final LynxKitView lynxKitView = LynxKitView.this;
                    final String str2 = url;
                    final TaskConfig taskConfig3 = taskConfig2;
                    final IBulletLifeCycle iBulletLifeCycle = listener;
                    Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadResource$onSuccess$1.4
                        @Override // java.util.concurrent.Callable
                        public /* bridge */ /* synthetic */ Object call() {
                            call();
                            return Unit.INSTANCE;
                        }

                        @Override // java.util.concurrent.Callable
                        public final void call() {
                            LynxKitView.this.readTemplateData(str2, resourceInfo, taskConfig3, iBulletLifeCycle);
                        }
                    }, Task.UI_THREAD_EXECUTOR);
                    return;
                }
                if (!areEqual) {
                    LynxKitView.this.readTemplateData(url, resourceInfo, taskConfig2, listener);
                    return;
                }
                final LynxKitView lynxKitView2 = LynxKitView.this;
                final String str3 = url;
                final TaskConfig taskConfig4 = taskConfig2;
                final IBulletLifeCycle iBulletLifeCycle2 = listener;
                Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadResource$onSuccess$1.3
                    @Override // java.util.concurrent.Callable
                    public /* bridge */ /* synthetic */ Object call() {
                        call();
                        return Unit.INSTANCE;
                    }

                    @Override // java.util.concurrent.Callable
                    public final void call() {
                        LynxKitView.this.readTemplateData(str3, resourceInfo, taskConfig4, iBulletLifeCycle2);
                    }
                });
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadResource$onFailed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "e");
                IBulletLifeCycle iBulletLifeCycle = IBulletLifeCycle.this;
                Uri parse2 = Uri.parse(url);
                Intrinsics.checkNotNullExpressionValue(parse2, "parse(url)");
                iBulletLifeCycle.onLoadFail(parse2, th);
                LynxRenderCallback provideRenderCallback2 = this.getDelegate().provideRenderCallback();
                if (provideRenderCallback2 != null) {
                    provideRenderCallback2.loadTemplateError(url, th);
                }
                BulletLogger.INSTANCE.printCoreReject(this.getCurrentSessionId(), (useForest ? "Forest" : "RL") + " load template error. url: " + url, "XLynxKit", th, LogLevel.E);
            }
        };
        getContext().getServiceContext().putDependency(CustomLoaderConfig.class, taskConfig.getLoaderConfig());
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), (useForest ? "Forest" : "RL") + " load template url: " + url, "XLynxKit", null, 8, null);
        if (useForest) {
            LynxKitInitParams lynxKitInitParams = this.lynxInitParams;
            if (lynxKitInitParams != null ? lynxKitInitParams.getEnableLynxPredecode() : false) {
                ForestLoader forestLoader = ForestLoader.INSTANCE;
                Scene scene = Scene.LYNX_TEMPLATE;
                String forestSessionId = getForestSessionId();
                if (taskConfig.getBid().length() == 0) {
                    taskConfig.setBid(this.kitService.getBid());
                }
                Unit unit = Unit.INSTANCE;
                forestLoader.loadAsyncWithProcessor((r24 & 1) != 0 ? forestLoader.getDefault() : null, url, (r24 & 4) != 0 ? null : null, scene, forestSessionId, (r24 & 32) != 0 ? null : taskConfig, (r24 & 64) != 0 ? false : false, new TemplateBundleProcessor(null, false, 3, null), (r24 & 256) != 0 ? null : null, new Function1<ProcessedResponse<TemplateBundle>, Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadResource$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ProcessedResponse<TemplateBundle>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ProcessedResponse<TemplateBundle> processedResponse) {
                        Response templateBundleResponse;
                        LynxKitInitParams lynxKitInitParams2;
                        LynxKitInitParams lynxKitInitParams3;
                        Intrinsics.checkNotNullParameter(processedResponse, "response");
                        if (processedResponse.isSucceed()) {
                            BulletContext context = LynxKitView.this.getDelegate().getContext();
                            BulletRLContext resourceContext = context != null ? context.getResourceContext() : null;
                            if (resourceContext != null) {
                                resourceContext.setResFrom(processedResponse.getSourceType(processedResponse.getFrom()));
                            }
                            Response response = (Response) processedResponse;
                            templateBundleResponse = LynxKitView.this.getTemplateBundleResponse(response);
                            if (templateBundleResponse != null) {
                                Function2<ResourceInfo, Boolean, Unit> function22 = function2;
                                ForestResourceInfo forestResourceInfo = new ForestResourceInfo(parse, templateBundleResponse);
                                lynxKitInitParams3 = LynxKitView.this.lynxInitParams;
                                function22.invoke(forestResourceInfo, Boolean.valueOf(lynxKitInitParams3 != null ? lynxKitInitParams3.getReadResourceInfoInMainThread() : true));
                                return;
                            }
                            Function2<ResourceInfo, Boolean, Unit> function23 = function2;
                            ForestResourceInfo forestResourceInfo2 = new ForestResourceInfo(parse, response);
                            lynxKitInitParams2 = LynxKitView.this.lynxInitParams;
                            function23.invoke(forestResourceInfo2, Boolean.valueOf(lynxKitInitParams2 != null ? lynxKitInitParams2.getReadResourceInfoInMainThread() : true));
                            return;
                        }
                        function1.invoke(new IllegalStateException("Forest load template failed, msg=" + processedResponse.getErrorInfo()));
                    }
                });
                return;
            }
            ForestLoader forestLoader2 = ForestLoader.INSTANCE;
            LynxKitInitParams lynxKitInitParams2 = this.lynxInitParams;
            String forestDownloadEngine = lynxKitInitParams2 != null ? lynxKitInitParams2.getForestDownloadEngine() : null;
            Scene scene2 = Scene.LYNX_TEMPLATE;
            String forestSessionId2 = getForestSessionId();
            if (taskConfig.getBid().length() == 0) {
                taskConfig.setBid(this.kitService.getBid());
            }
            Unit unit2 = Unit.INSTANCE;
            forestLoader2.loadAsync((r22 & 1) != 0 ? forestLoader2.getDefault() : null, url, (r22 & 4) != 0 ? null : forestDownloadEngine, scene2, forestSessionId2, (r22 & 32) != 0 ? null : taskConfig, (r22 & 64) != 0 ? false : false, (r22 & 128) != 0 ? null : null, new Function1<Response, Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadResource$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Response) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Response response) {
                    LynxKitInitParams lynxKitInitParams3;
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (response.isSucceed()) {
                        BulletContext context = LynxKitView.this.getDelegate().getContext();
                        BulletRLContext resourceContext = context != null ? context.getResourceContext() : null;
                        if (resourceContext != null) {
                            resourceContext.setResFrom(response.getSourceType(response.getFrom()));
                        }
                        Function2<ResourceInfo, Boolean, Unit> function22 = function2;
                        ForestResourceInfo forestResourceInfo = new ForestResourceInfo(parse, response);
                        lynxKitInitParams3 = LynxKitView.this.lynxInitParams;
                        function22.invoke(forestResourceInfo, Boolean.valueOf(lynxKitInitParams3 != null ? lynxKitInitParams3.getReadResourceInfoInMainThread() : true));
                        return;
                    }
                    function1.invoke(new IllegalStateException("Forest load template failed, msg=" + response.getErrorInfo()));
                }
            });
            return;
        }
        ResourceLoader.with$default(ResourceLoader.INSTANCE, this.kitService.getBid(), null, 2, null).loadAsync(url, taskConfig, new Function1<ResourceInfo, Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadResource$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ResourceInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ResourceInfo resourceInfo) {
                LynxKitInitParams lynxKitInitParams3;
                Intrinsics.checkNotNullParameter(resourceInfo, "it");
                BulletContext context = LynxKitView.this.getDelegate().getContext();
                BulletRLContext resourceContext = context != null ? context.getResourceContext() : null;
                if (resourceContext != null) {
                    resourceContext.setResFrom(resourceInfo.getStatisticFrom());
                }
                Function2<ResourceInfo, Boolean, Unit> function22 = function2;
                lynxKitInitParams3 = LynxKitView.this.lynxInitParams;
                function22.invoke(resourceInfo, Boolean.valueOf(lynxKitInitParams3 != null ? lynxKitInitParams3.getReadResourceInfoInMainThread() : false));
            }
        }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadResource$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                function1.invoke(th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProcessedResponse<TemplateBundle> getTemplateBundleResponse(Response response) {
        ProcessedResponse<TemplateBundle> processedResponse = response instanceof ProcessedResponse ? (ProcessedResponse) response : null;
        if (processedResponse == null) {
            return null;
        }
        if (processedResponse.isProcessSucceed() && processedResponse.provideProcessedData() != null) {
            return processedResponse;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00cb, code lost:
    
        if ((r0 != null && r0.getLynxCdnCacheHttpUrl()) != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0114, code lost:
    
        if (r0 != null) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void readTemplateData(String url, ResourceInfo resInfo, TaskConfig config, IBulletLifeCycle listener) {
        String cdn;
        String str;
        LynxRenderCallback provideRenderCallback;
        byte[] bArr;
        TemplateBundle templateBundle;
        byte[] bArr2;
        String filePath;
        AbsBulletMonitorCallback monitorCallback;
        LynxRenderCallback provideRenderCallback2;
        if (config.getCdnUrl().length() > 0) {
            cdn = config.getCdnUrl();
        } else {
            Uri parse = Uri.parse(url);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
            cdn = ExtKt.getCDN(parse, this.kitService.getBid());
            if (cdn == null) {
                str = url;
                provideRenderCallback = this.delegate.provideRenderCallback();
                if (provideRenderCallback != null) {
                    provideRenderCallback.beforeReadTemplate();
                }
                ForestResourceInfo forestResourceInfo = !(resInfo instanceof ForestResourceInfo) ? (ForestResourceInfo) resInfo : null;
                Object provideProcessedData = forestResourceInfo == null ? forestResourceInfo.provideProcessedData() : null;
                templateBundle = !(provideProcessedData instanceof TemplateBundle) ? (TemplateBundle) provideProcessedData : null;
                if (templateBundle == null) {
                    try {
                        Result.Companion companion = Result.Companion;
                        bArr2 = Result.constructor-impl(resInfo.provideByteArray());
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        bArr2 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    Throwable th2 = Result.exceptionOrNull-impl(bArr2);
                    if (th2 != null) {
                        Uri parse2 = Uri.parse(url);
                        Intrinsics.checkNotNullExpressionValue(parse2, "parse(url)");
                        listener.onLoadFail(parse2, th2);
                    }
                    bArr = Result.isFailure-impl(bArr2) ? null : bArr2;
                }
                if (bArr != null && templateBundle == null) {
                    Uri parse3 = Uri.parse(url);
                    Intrinsics.checkNotNullExpressionValue(parse3, "parse(url)");
                    listener.onLoadFail(parse3, new Throwable("neither byte array nor templateBundle are provided"));
                    return;
                }
                if (resInfo.getFrom() == ResourceFrom.CDN) {
                    if (!getContext().getServiceContext().getIsDebug()) {
                        LynxKitInitParams lynxKitInitParams = this.lynxInitParams;
                    }
                    HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===match sUrl:" + str + "===", null, null, 12, null);
                    filePath = str;
                    setNpthLastUrl(url);
                    if (bArr != null && (provideRenderCallback2 = this.delegate.provideRenderCallback()) != null) {
                        provideRenderCallback2.afterReadTemplate(url, bArr, listener);
                    }
                    if (templateBundle != null) {
                        BulletContext context = this.delegate.getContext();
                        if (context != null && (monitorCallback = context.getMonitorCallback()) != null) {
                            monitorCallback.onLynxReadTemplateEnd();
                        }
                        if (IConditionCallKt.enableChangeLynxUrl()) {
                            loadTemplateBundle(str, templateBundle);
                            return;
                        } else {
                            loadTemplateBundle(filePath, templateBundle);
                            return;
                        }
                    }
                    if (IConditionCallKt.enableChangeLynxUrl()) {
                        Intrinsics.checkNotNull(bArr);
                        loadTemplate(bArr, str);
                        return;
                    } else {
                        Intrinsics.checkNotNull(bArr);
                        loadTemplate(bArr, filePath);
                        return;
                    }
                }
                HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===match resInfo.filePath: $" + str + "===", null, null, 12, null);
                filePath = resInfo.getFilePath();
            }
        }
        str = cdn;
        provideRenderCallback = this.delegate.provideRenderCallback();
        if (provideRenderCallback != null) {
        }
        if (!(resInfo instanceof ForestResourceInfo)) {
        }
        if (forestResourceInfo == null) {
        }
        if (!(provideProcessedData instanceof TemplateBundle)) {
        }
        if (templateBundle == null) {
        }
        if (bArr != null) {
        }
        if (resInfo.getFrom() == ResourceFrom.CDN) {
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===match resInfo.filePath: $" + str + "===", null, null, 12, null);
        filePath = resInfo.getFilePath();
    }

    private final void loadTemplate(final byte[] byteArray, final String baseUrl) {
        LynxKitInitParams lynxKitInitParams = this.lynxInitParams;
        boolean z = false;
        if (lynxKitInitParams != null && !lynxKitInitParams.getRenderTemplateInMainThread()) {
            z = true;
        }
        if (z) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadTemplate$1
                    @Override // java.util.concurrent.Callable
                    public /* bridge */ /* synthetic */ Object call() {
                        call();
                        return Unit.INSTANCE;
                    }

                    @Override // java.util.concurrent.Callable
                    public final void call() {
                        LynxKitView.this.load(byteArray, baseUrl);
                    }
                });
                return;
            } else {
                load(byteArray, baseUrl);
                return;
            }
        }
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            load(byteArray, baseUrl);
        } else {
            Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$loadTemplate$2
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    LynxKitView.this.load(byteArray, baseUrl);
                }
            }, Task.UI_THREAD_EXECUTOR);
        }
    }

    private final void setNpthLastUrl(String url) {
        String str;
        List split$default;
        try {
            Result.Companion companion = Result.Companion;
            HashMap hashMap = new HashMap();
            if (url == null || (split$default = StringsKt.split$default(url, new String[]{"?"}, false, 0, 6, (Object) null)) == null || (str = (String) split$default.get(0)) == null) {
                str = "";
            }
            hashMap.put("last_lynx_url", str);
            String lynxVersion = LynxEnv.inst().getLynxVersion();
            Intrinsics.checkNotNullExpressionValue(lynxVersion, "inst().lynxVersion");
            hashMap.put("lynx_sdk_version", lynxVersion);
            Npth.addTags(hashMap);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public SccConfig.SccLevel getSccLevel() {
        return SccConfig.SccLevel.SAFE;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void reload() {
        if (BulletEnv.INSTANCE.getInstance().getDebuggable()) {
            BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "reset data", "XLynxKit", null, 8, null);
        } else {
            BulletLogger.printCoreReject$default(BulletLogger.INSTANCE, getCurrentSessionId(), "reset data", "XLynxKit", new Throwable(), null, 16, null);
        }
        TemplateData provideTemplateData = this.delegate.provideTemplateData();
        if (provideTemplateData != null) {
            LynxView lynxView = this.realView;
            if (lynxView != null) {
                lynxView.updateData(provideTemplateData);
                return;
            }
            return;
        }
        updateData(this.delegate.getGlobalProps());
        byte[] bArr = this.templateData;
        if (bArr != null) {
            Intrinsics.checkNotNull(bArr);
            load(bArr, this.rawUrl);
        } else {
            if (this.rawUrl.length() > 0) {
                IKitViewService.DefaultImpls.load$default(this, this.rawUrl, null, 2, null);
            }
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void sendEvent(String eventName, Object params) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        sendEvent(eventName, params, true);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void sendEvent(String eventName, Object params, boolean useDelegate) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        if (BulletEnv.INSTANCE.getInstance().getDebuggable()) {
            try {
                Result.Companion companion = Result.Companion;
                BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "send event: " + eventName + " with params: " + new Gson().toJson(params), "XLynxKit", null, 8, null);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        } else {
            BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "send even", "XLynxKit", null, 8, null);
        }
        IEventHandler iEventHandler = this.eventHandler;
        if (iEventHandler != null && useDelegate) {
            Intrinsics.checkNotNull(iEventHandler);
            iEventHandler.sendEvent(eventName, params, (View) this.realView);
            return;
        }
        if (params == null) {
            LynxView lynxView = this.realView;
            if (lynxView != null) {
                lynxView.sendGlobalEvent(eventName, JavaOnlyArray.from(new ArrayList()));
                return;
            }
            return;
        }
        boolean z = params instanceof List;
        if (z) {
            LynxView lynxView2 = this.realView;
            if (lynxView2 != null) {
                ArrayList arrayList = z ? (List) params : null;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                lynxView2.sendGlobalEvent(eventName, JavaOnlyArray.from(arrayList));
                return;
            }
            return;
        }
        LynxView lynxView3 = this.realView;
        if (lynxView3 != null) {
            lynxView3.sendGlobalEvent(eventName, JavaOnlyArray.of(new Object[]{params}));
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void updateData(Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        LynxView lynxView = this.realView;
        if (lynxView != null) {
            TemplateData fromMap = TemplateData.fromMap(data);
            fromMap.put("bullet_update_type", 1);
            lynxView.updateData(fromMap);
        }
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "update data", "XLynxKit", null, 8, null);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void updateGlobalProps(Map<String, ? extends Object> globalprops) {
        Intrinsics.checkNotNullParameter(globalprops, "globalprops");
        Map<String, Object> globalProps = this.delegate.getGlobalProps();
        globalProps.put("bullet_update_type", 1);
        globalProps.putAll(globalprops);
        LynxView lynxView = this.realView;
        if (lynxView != null) {
            TemplateData fromMap = TemplateData.fromMap(globalProps);
            fromMap.put("bullet_update_type", 1);
            lynxView.updateGlobalProps(fromMap);
        }
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "update updateGlobalProps", "XLynxKit", null, 8, null);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void onShow() {
        LynxView lynxView = this.realView;
        if (lynxView != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isViewFirstAppeared", this.isViewFirstAppeared);
            Unit unit = Unit.INSTANCE;
            sendEvent(WebKitView.EVENT_VIEW_APPEARED, jSONObject);
            lynxView.onEnterForeground();
            this.isViewFirstAppeared = false;
        }
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "kitView status:on show", "XLynxKit", null, 8, null);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void onHide() {
        LynxView lynxView = this.realView;
        if (lynxView != null) {
            lynxView.sendGlobalEvent(WebKitView.EVENT_VIEW_DISAPPEARED, new JavaOnlyArray());
            lynxView.onEnterBackground();
        }
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "kitView status:on hide", "XLynxKit", null, 8, null);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public boolean onBackPressed() {
        try {
            if (this.delegate.onBackPressed()) {
                return true;
            }
        } catch (Exception e) {
            BulletLogger.INSTANCE.printReject(e, "onBackPressed", "XLynxKit");
        }
        return LynxNavigator.inst().onBackPressed(this);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public void destroy(boolean useDelegate) {
        LynxKitInitParams lynxKitInitParams;
        String lynxGroupName;
        LynxKitInitParams lynxKitInitParams2;
        String storageGroupName;
        this.delegate.release(this);
        LynxKitInitParams lynxKitInitParams3 = this.lynxInitParams;
        if ((lynxKitInitParams3 != null ? Intrinsics.areEqual(lynxKitInitParams3.getUseStorageGroup(), true) : false) && (lynxKitInitParams2 = this.lynxInitParams) != null && (storageGroupName = lynxKitInitParams2.getStorageGroupName()) != null) {
            LynxGroupHolder.INSTANCE.removeLynxGroup(storageGroupName);
        }
        if (!IConditionCallKt.enableFixedLynxGroup() && (lynxKitInitParams = this.lynxInitParams) != null && (lynxGroupName = lynxKitInitParams.getLynxGroupName()) != null) {
            LynxGroupHolder.INSTANCE.removeLynxGroup(lynxGroupName);
        }
        ForestLoader.INSTANCE.release(getForestSessionId());
        LynxView lynxView = this.realView;
        if (lynxView != null) {
            lynxView.setAsyncImageInterceptor((ImageInterceptor) null);
        }
        LynxView lynxView2 = this.realView;
        if (lynxView2 != null) {
            lynxView2.destroy();
        }
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "kitView status:destroy", "XLynxKit", null, 8, null);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    public String getSdkVersion() {
        String lynxVersion = LynxEnv.inst().getLynxVersion();
        Intrinsics.checkNotNullExpressionValue(lynxVersion, "inst().lynxVersion");
        return lynxVersion;
    }

    public final void createLynxView(LynxKitInitParams lynxKitInitParams) {
        ILynxCanvasConfig canvasInitConfig;
        Map<Class<?>, Object> lynxCanvasServiceMap;
        BulletLynxContext lynxContext;
        LynxViewClient lynxViewClient;
        BooleanParam useKtx2Transcoder;
        Boolean value;
        SchemaModelUnion schemaModelUnion;
        BooleanParam useMotion;
        Boolean value2;
        SchemaModelUnion schemaModelUnion2;
        this.lynxInitParams = lynxKitInitParams;
        String sessionId = lynxKitInitParams != null ? lynxKitInitParams.getSessionId() : null;
        if (sessionId == null) {
            sessionId = "";
        }
        this.currentSessionId = sessionId;
        if (this.realView != null) {
            return;
        }
        Context context = getContext().getServiceContext().getContext();
        Intrinsics.checkNotNull(context);
        LynxViewBuilder lynxViewBuilder = new LynxViewBuilder();
        init(lynxViewBuilder, this.lynxInitParams);
        View build = lynxViewBuilder.build(context);
        BulletContext context2 = this.delegate.getContext();
        ISchemaModel containerModel = (context2 == null || (schemaModelUnion2 = context2.getSchemaModelUnion()) == null) ? null : schemaModelUnion2.getContainerModel();
        BDXContainerModel bDXContainerModel = containerModel instanceof BDXContainerModel ? (BDXContainerModel) containerModel : null;
        boolean z = false;
        boolean booleanValue = (bDXContainerModel == null || (useMotion = bDXContainerModel.getUseMotion()) == null || (value2 = useMotion.getValue()) == null) ? false : value2.booleanValue();
        BulletContext context3 = this.delegate.getContext();
        ISchemaModel containerModel2 = (context3 == null || (schemaModelUnion = context3.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getContainerModel();
        BDXContainerModel bDXContainerModel2 = containerModel2 instanceof BDXContainerModel ? (BDXContainerModel) containerModel2 : null;
        if (bDXContainerModel2 != null && (useKtx2Transcoder = bDXContainerModel2.getUseKtx2Transcoder()) != null && (value = useKtx2Transcoder.getValue()) != null) {
            z = value.booleanValue();
        }
        if (z) {
            KTX2KryptonRuntimeServiceImpl kTX2KryptonRuntimeServiceImpl = new KTX2KryptonRuntimeServiceImpl();
            LynxKryptonHelper lynxKryptonHelper = LynxKryptonUtils.getLynxKryptonHelper(build);
            if (lynxKryptonHelper != null) {
                lynxKryptonHelper.registerService(KTX2KryptonRuntimeServiceImpl.class, kTX2KryptonRuntimeServiceImpl);
            }
        }
        if (booleanValue) {
            PhysicsKryptonRuntimeServiceImpl physicsKryptonRuntimeServiceImpl = new PhysicsKryptonRuntimeServiceImpl();
            LynxKryptonHelper lynxKryptonHelper2 = LynxKryptonUtils.getLynxKryptonHelper(build);
            if (lynxKryptonHelper2 != null) {
                lynxKryptonHelper2.registerService(PhysicsKryptonRuntimeServiceImpl.class, physicsKryptonRuntimeServiceImpl);
            }
        }
        LynxKitInitParams lynxKitInitParams2 = this.lynxInitParams;
        List<LynxViewClient> lynxClientDelegate = lynxKitInitParams2 != null ? lynxKitInitParams2.lynxClientDelegate() : null;
        Intrinsics.checkNotNull(lynxClientDelegate);
        DefaultLynxViewClient defaultLynxViewClient = new DefaultLynxViewClient(lynxClientDelegate, getContext());
        this.lynxViewClient = defaultLynxViewClient;
        build.addLynxViewClient(defaultLynxViewClient);
        BulletContext context4 = BulletContextManager.INSTANCE.getInstance().getContext(getCurrentSessionId());
        if (context4 != null && (lynxContext = context4.getLynxContext()) != null && (lynxViewClient = lynxContext.getLynxViewClient()) != null) {
            build.addLynxViewClient(lynxViewClient);
        }
        build.setAsyncImageInterceptor(new DefaultImageInterceptor(new DefaultLynxViewClient(new ArrayList(), getContext())));
        this.lynxMonitorProvider.setView(build);
        if (BulletEnv.INSTANCE.getInstance().getDebuggable()) {
            BulletEnv companion = BulletEnv.INSTANCE.getInstance();
            Intrinsics.checkNotNullExpressionValue(build, "lynxView");
            companion.markBulletView(build);
            try {
                Result.Companion companion2 = Result.Companion;
                BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "lynxview create lynxKitInitParams: " + new Gson().toJson(lynxKitInitParams), "XLynxKit", null, 8, null);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        } else {
            BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getCurrentSessionId(), "lynxview create " + lynxKitInitParams, "XLynxKit", null, 8, null);
        }
        try {
            Class.forName("com.ss.ttvideoengine.TTVideoEngine");
            LynxKryptonHelper lynxKryptonHelper3 = LynxKryptonUtils.getLynxKryptonHelper(build);
            if (lynxKryptonHelper3 != null) {
                lynxKryptonHelper3.registerService(KryptonVideoPlayerService.class, new LynxCanvasTTPlayer.Companion.LynxCanvasPlayerService(context));
            }
            BulletLogger.INSTANCE.printLog("register LynxCanvasTTPlayer success", LogLevel.I, "XLynxKit");
        } catch (Throwable th2) {
            BulletLogger.INSTANCE.printReject(th2, "take it easy. just check ttvideoengine sdk is not exist", "XLynxKit");
        }
        ILynxKitService iLynxKitService = (ILynxKitService) ServiceCenter.INSTANCE.instance().get(ILynxKitService.class);
        Object kitConfig = iLynxKitService != null ? iLynxKitService.getKitConfig() : null;
        LynxConfig lynxConfig = kitConfig instanceof LynxConfig ? (LynxConfig) kitConfig : null;
        if (lynxConfig != null && (canvasInitConfig = lynxConfig.canvasInitConfig()) != null && (lynxCanvasServiceMap = canvasInitConfig.getLynxCanvasServiceMap()) != null) {
            try {
                for (Map.Entry<Class<?>, Object> entry : lynxCanvasServiceMap.entrySet()) {
                    Class<?> key = entry.getKey();
                    Object value3 = entry.getValue();
                    LynxKryptonHelper lynxKryptonHelper4 = LynxKryptonUtils.getLynxKryptonHelper(build);
                    if (lynxKryptonHelper4 != null) {
                        lynxKryptonHelper4.registerService(key, value3);
                    }
                    BulletLogger.INSTANCE.printLog("register canvas permission success", LogLevel.I, "XLynxKit");
                }
            } catch (Throwable th3) {
                BulletLogger.INSTANCE.printReject(th3, "take it easy. Krypton Player require Lynx >= 2.10", "XLynxKit");
            }
        }
        this.realView = build;
    }

    static /* synthetic */ LynxViewBuilder init$default(LynxKitView lynxKitView, LynxViewBuilder lynxViewBuilder, LynxKitInitParams lynxKitInitParams, int i, Object obj) {
        if ((i & 1) != 0) {
            lynxKitInitParams = null;
        }
        return lynxKitView.init(lynxViewBuilder, lynxKitInitParams);
    }

    private final LynxViewBuilder init(LynxViewBuilder lynxViewBuilder, LynxKitInitParams lynxKitInitParams) {
        DefaultDynamicComponentFetcher defaultDynamicComponentFetcher;
        Boolean disableAutoExpose;
        Function1<LynxViewBuilder, Unit> customInit;
        Boolean enableLynxGenericFetcher;
        Float fontScale;
        LynxAsyncLayoutParam asyncLayoutParam;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int makeMeasureSpec3;
        int makeMeasureSpec4;
        int makeMeasureSpec5;
        int makeMeasureSpec6;
        LynxGroup lynxGroup;
        if (lynxKitInitParams != null && (lynxGroup = lynxKitInitParams.getLynxGroup()) != null) {
            lynxViewBuilder.setLynxGroup(lynxGroup);
        }
        if (lynxKitInitParams != null) {
            if (Intrinsics.areEqual(this.kitService.getBid(), BidConstants.WEBCAST)) {
                if (lynxKitInitParams.getLynxInitWidth() != null || lynxKitInitParams.getLynxInitHeight() != null) {
                    Integer lynxInitWidth = lynxKitInitParams.getLynxInitWidth();
                    if (lynxInitWidth != null) {
                        int intValue = lynxInitWidth.intValue();
                        if (intValue > 0) {
                            makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(intValue, 1073741824);
                        } else {
                            makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(0, 0);
                        }
                    } else {
                        makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(0, 0);
                    }
                    Integer lynxInitHeight = lynxKitInitParams.getLynxInitHeight();
                    if (lynxInitHeight != null) {
                        int intValue2 = lynxInitHeight.intValue();
                        if (intValue2 > 0) {
                            makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(intValue2, 1073741824);
                        } else {
                            makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(0, 0);
                        }
                    } else {
                        makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(0, 0);
                    }
                    lynxViewBuilder.setPresetMeasuredSpec(makeMeasureSpec3, makeMeasureSpec4);
                }
                if (lynxKitInitParams.getLynxWidth() != null || lynxKitInitParams.getLynxHeight() != null) {
                    Integer lynxWidth = lynxKitInitParams.getLynxWidth();
                    if (lynxWidth != null) {
                        int intValue3 = lynxWidth.intValue();
                        makeMeasureSpec5 = intValue3 > 0 ? View.MeasureSpec.makeMeasureSpec(intValue3, 1073741824) : -1;
                    } else {
                        makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(0, 0);
                    }
                    Integer lynxHeight = lynxKitInitParams.getLynxHeight();
                    if (lynxHeight != null) {
                        int intValue4 = lynxHeight.intValue();
                        makeMeasureSpec6 = intValue4 > 0 ? View.MeasureSpec.makeMeasureSpec(intValue4, 1073741824) : -1;
                    } else {
                        makeMeasureSpec6 = View.MeasureSpec.makeMeasureSpec(0, 0);
                    }
                    if (makeMeasureSpec5 != -1 && makeMeasureSpec6 != -1) {
                        lynxViewBuilder.setPresetMeasuredSpec(makeMeasureSpec5, makeMeasureSpec6);
                    }
                    if (makeMeasureSpec5 != -1 && makeMeasureSpec6 == -1) {
                        lynxViewBuilder.setPresetMeasuredSpec(makeMeasureSpec5, View.MeasureSpec.makeMeasureSpec(0, 1073741824));
                    }
                    if (makeMeasureSpec5 == -1 && makeMeasureSpec6 != -1) {
                        lynxViewBuilder.setPresetMeasuredSpec(View.MeasureSpec.makeMeasureSpec(0, 1073741824), makeMeasureSpec6);
                    }
                }
                if (lynxKitInitParams.getPresetWidthSpec() != null) {
                    Integer presetWidthSpec = lynxKitInitParams.getPresetWidthSpec();
                    Intrinsics.checkNotNull(presetWidthSpec);
                    if (presetWidthSpec.intValue() > 0 && lynxKitInitParams.getPresetHeightSpec() != null) {
                        Integer presetHeightSpec = lynxKitInitParams.getPresetHeightSpec();
                        Intrinsics.checkNotNull(presetHeightSpec);
                        if (presetHeightSpec.intValue() > 0) {
                            Integer presetWidthSpec2 = lynxKitInitParams.getPresetWidthSpec();
                            Intrinsics.checkNotNull(presetWidthSpec2);
                            int intValue5 = presetWidthSpec2.intValue();
                            Integer presetHeightSpec2 = lynxKitInitParams.getPresetHeightSpec();
                            Intrinsics.checkNotNull(presetHeightSpec2);
                            lynxViewBuilder.setPresetMeasuredSpec(intValue5, presetHeightSpec2.intValue());
                        }
                    }
                }
                if (lynxKitInitParams.getScreenWidth() > 0 && lynxKitInitParams.getScreenHeight() > 0) {
                    lynxViewBuilder.setScreenSize((int) (lynxKitInitParams.getScreenWidth() * lynxKitInitParams.getViewZoom()), (int) (lynxKitInitParams.getScreenHeight() * lynxKitInitParams.getViewZoom()));
                }
            } else {
                if (lynxKitInitParams.getLynxWidth() != null || lynxKitInitParams.getLynxHeight() != null) {
                    Integer lynxWidth2 = lynxKitInitParams.getLynxWidth();
                    if (lynxWidth2 != null) {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(lynxWidth2.intValue(), 1073741824);
                    } else {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    }
                    Integer lynxHeight2 = lynxKitInitParams.getLynxHeight();
                    if (lynxHeight2 != null) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(lynxHeight2.intValue(), 1073741824);
                    } else {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                    }
                    lynxViewBuilder.setPresetMeasuredSpec(makeMeasureSpec, makeMeasureSpec2);
                }
                if (lynxKitInitParams.getPresetWidthSpec() != null && lynxKitInitParams.getPresetHeightSpec() != null) {
                    Integer presetWidthSpec3 = lynxKitInitParams.getPresetWidthSpec();
                    Intrinsics.checkNotNull(presetWidthSpec3);
                    int intValue6 = presetWidthSpec3.intValue();
                    Integer presetHeightSpec3 = lynxKitInitParams.getPresetHeightSpec();
                    Intrinsics.checkNotNull(presetHeightSpec3);
                    lynxViewBuilder.setPresetMeasuredSpec(intValue6, presetHeightSpec3.intValue());
                }
                if (lynxKitInitParams.getScreenWidth() > 0 && lynxKitInitParams.getScreenHeight() > 0) {
                    lynxViewBuilder.setScreenSize((int) (lynxKitInitParams.getScreenWidth() * lynxKitInitParams.getViewZoom()), (int) (lynxKitInitParams.getScreenHeight() * lynxKitInitParams.getViewZoom()));
                }
            }
        }
        if (lynxKitInitParams != null && (asyncLayoutParam = lynxKitInitParams.getAsyncLayoutParam()) != null) {
            Boolean presetSafePoint = asyncLayoutParam.getPresetSafePoint();
            lynxViewBuilder.setEnableLayoutSafepoint(presetSafePoint != null ? presetSafePoint.booleanValue() : false);
            lynxViewBuilder.setThreadStrategyForRendering(getStrategyById(asyncLayoutParam.getThreadStrategy()));
        }
        lynxViewBuilder.registerModule(NavigationModule.NAME, NavigationModule.class, (Object) null);
        lynxViewBuilder.registerModule("hybridMonitor", LynxViewMonitorModule.class, this.lynxMonitorProvider);
        for (Map.Entry<String, LynxModuleWrapper> entry : this.delegate.createLynxModule().entrySet()) {
            lynxViewBuilder.registerModule(entry.getKey(), entry.getValue().getClz(), entry.getValue().getModuleParams());
        }
        lynxViewBuilder.addBehaviors(this.delegate.provideBehavior());
        if (lynxKitInitParams != null && (fontScale = lynxKitInitParams.getFontScale()) != null) {
            float floatValue = fontScale.floatValue();
            if (floatValue > 0.0f) {
                lynxViewBuilder.setFontScale(floatValue);
            }
        }
        if (lynxKitInitParams == null || (defaultDynamicComponentFetcher = lynxKitInitParams.getDynamicComponentFetcher()) == null) {
            defaultDynamicComponentFetcher = new DefaultDynamicComponentFetcher(getContext());
        }
        lynxViewBuilder.setDynamicComponentFetcher(defaultDynamicComponentFetcher);
        if (lynxKitInitParams != null) {
            lynxViewBuilder.setEnableCreateViewAsync(lynxKitInitParams.getCreateViewAsync());
        }
        if (lynxKitInitParams != null) {
            lynxViewBuilder.setEnableSyncFlush(lynxKitInitParams.getEnableSyncFlush());
        }
        if (lynxKitInitParams != null) {
            lynxViewBuilder.setEnableVSyncAlignedMessageLoop(lynxKitInitParams.getEnableVSyncAlignedMessageLoop());
        }
        lynxViewBuilder.setResourceProvider("EXTERNAL_JS_SOURCE", new ExternalJSProvider(getContext(), this.kitService));
        lynxViewBuilder.setResourceProvider("FONT", new FontResourceProvider(getContext(), this.kitService));
        lynxViewBuilder.setGenericResourceFetcher(new DefaultLynxGenericResourceProvider(getContext(), this.kitService));
        lynxViewBuilder.setMediaResourceFetcher(new DefaultMediaResourceProvider(getContext()));
        lynxViewBuilder.setTemplateResourceFetcher(new DefaultTemplateResourceProvider(getContext()));
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "enableLynxGenericFetcher: " + (lynxKitInitParams != null ? lynxKitInitParams.getEnableLynxGenericFetcher() : null), null, null, 12, null);
        if (lynxKitInitParams != null && (enableLynxGenericFetcher = lynxKitInitParams.getEnableLynxGenericFetcher()) != null && enableLynxGenericFetcher.booleanValue()) {
            lynxViewBuilder.setEnableGenericResourceFetcher(LynxBooleanOption.TRUE);
        }
        if (lynxKitInitParams != null && (customInit = lynxKitInitParams.getCustomInit()) != null) {
            customInit.invoke(lynxViewBuilder);
        }
        if (lynxKitInitParams != null && (disableAutoExpose = lynxKitInitParams.getDisableAutoExpose()) != null) {
            lynxViewBuilder.enableAutoExpose(!disableAutoExpose.booleanValue());
        }
        this.delegate.injectLynxBuilder(lynxViewBuilder);
        return lynxViewBuilder;
    }

    private final ThreadStrategyForRendering getStrategyById(Integer id) {
        int id2 = ThreadStrategyForRendering.ALL_ON_UI.id();
        if (id != null && id.intValue() == id2) {
            return ThreadStrategyForRendering.ALL_ON_UI;
        }
        int id3 = ThreadStrategyForRendering.MOST_ON_TASM.id();
        if (id != null && id.intValue() == id3) {
            return ThreadStrategyForRendering.MOST_ON_TASM;
        }
        int id4 = ThreadStrategyForRendering.PART_ON_LAYOUT.id();
        if (id != null && id.intValue() == id4) {
            return ThreadStrategyForRendering.PART_ON_LAYOUT;
        }
        return (id != null && id.intValue() == ThreadStrategyForRendering.MULTI_THREADS.id()) ? ThreadStrategyForRendering.MULTI_THREADS : ThreadStrategyForRendering.ALL_ON_UI;
    }

    public void createLynxView(LynxRoute route, final LynxViewCreationListener listener) {
        LynxKitInitParams lynxKitInitParams;
        LynxRouterCallback lynxRouterCallback;
        try {
            LynxKitInitParams lynxKitInitParams2 = this.lynxInitParams;
            if (lynxKitInitParams2 == null || (lynxRouterCallback = lynxKitInitParams2.getLynxRouterCallback()) == null) {
                lynxKitInitParams = null;
            } else {
                Intrinsics.checkNotNull(route);
                String templateUrl = route.getTemplateUrl();
                Intrinsics.checkNotNullExpressionValue(templateUrl, "route!!.templateUrl");
                lynxKitInitParams = lynxRouterCallback.convertToLynxInitParams(templateUrl);
            }
            if (lynxKitInitParams == null) {
                if (listener != null) {
                    listener.onFailed();
                    return;
                }
                return;
            }
            LynxInitData.Companion companion = LynxInitData.INSTANCE;
            Intrinsics.checkNotNull(route);
            lynxKitInitParams.setInitData(companion.fromMap(route.getParam()));
            createLynxView(lynxKitInitParams);
            String templateUrl2 = route.getTemplateUrl();
            Intrinsics.checkNotNullExpressionValue(templateUrl2, "route!!.templateUrl");
            loadResource(templateUrl2, false, lynxKitInitParams.getUseForest(), null, new IBulletLifeCycle.Base() { // from class: com.bytedance.ies.bullet.lynx.LynxKitView$createLynxView$4
                @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
                public void onLoadUriSuccess(Uri uri, IKitViewService kitView) {
                    LynxView lynxView;
                    Intrinsics.checkNotNullParameter(uri, "uri");
                    LynxViewCreationListener lynxViewCreationListener = listener;
                    if (lynxViewCreationListener != null) {
                        lynxView = this.realView;
                        Intrinsics.checkNotNull(lynxView);
                        lynxViewCreationListener.onReady(lynxView);
                    }
                }

                @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
                public void onLoadFail(Uri uri, Throwable e) {
                    Intrinsics.checkNotNullParameter(uri, "uri");
                    Intrinsics.checkNotNullParameter(e, "e");
                    LynxViewCreationListener lynxViewCreationListener = listener;
                    if (lynxViewCreationListener != null) {
                        lynxViewCreationListener.onFailed();
                    }
                }
            });
        } catch (Exception unused) {
            if (listener != null) {
                listener.onFailed();
            }
        }
    }

    public void quit() {
        Context context = getContext().getServiceContext().getContext();
        if (context != null) {
            if (!((context instanceof Activity) && !((Activity) context).isFinishing())) {
                context = null;
            }
            if (context != null) {
                ((Activity) context).finish();
            }
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService
    public void registerSecureService(ArgusBaseBizService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.delegate.registerSecureService(service);
    }
}
