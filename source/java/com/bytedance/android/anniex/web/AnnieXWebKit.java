package com.bytedance.android.anniex.web;

import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.ability.GlobalPropsHelper;
import com.bytedance.android.anniex.ability.XBridgeWebHelper;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.container.INavBarHost;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.container.IStickWebLifeCycle;
import com.bytedance.android.anniex.lite.utils.AnnieXSettings;
import com.bytedance.android.anniex.monitor.AnnieXCardScene;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.scene.data.SceneDbContract;
import com.bytedance.android.anniex.utils.AnnieXConstants;
import com.bytedance.android.anniex.web.api.AnnieXWebModelBuilderKt;
import com.bytedance.android.anniex.web.api.IAnnieXWebLifecycle;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.android.anniex.web.monitor.DefaultAnnieXWebBlankCallback;
import com.bytedance.android.anniex.web.webKitDelegateWrapper.KitViewLifecycleDelegateWrapper;
import com.bytedance.android.anniex.web.webKitDelegateWrapper.WebKitDelegateWrapper;
import com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.common.util.LollipopV21Compat;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.argus.api.params.ArgusWebResourceRequestRewritePayload;
import com.bytedance.ies.bullet.base.depend.INetworkDepend;
import com.bytedance.ies.bullet.base.settings.JSBAuthStrategySetting;
import com.bytedance.ies.bullet.base.settings.SecuritySettingConfig;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.BulletRLContext;
import com.bytedance.ies.bullet.core.common.DebugConfig;
import com.bytedance.ies.bullet.core.common.DebugInfo;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.deprecate.fake.ContainerBidParam;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.ForestPreloadHelper;
import com.bytedance.ies.bullet.forest.ForestWebInfoHelper;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.kit.web.IWebSecureDelegate;
import com.bytedance.ies.bullet.kit.web.IWebViewLoadUrlInterceptorDelegate;
import com.bytedance.ies.bullet.kit.web.MonitorChromeClient;
import com.bytedance.ies.bullet.kit.web.MonitorWebViewClient;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.kit.web.WebEngineGlobalConfig;
import com.bytedance.ies.bullet.kit.web.WebLoadError;
import com.bytedance.ies.bullet.kit.web.export.BulletWebChromeClient;
import com.bytedance.ies.bullet.kit.web.export.BulletWebViewClient;
import com.bytedance.ies.bullet.kit.web.impl.AnnieXWebController;
import com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate;
import com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService;
import com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapter;
import com.bytedance.ies.bullet.secure.HybridSecureConfig;
import com.bytedance.ies.bullet.secure.HybridSecureManager;
import com.bytedance.ies.bullet.secure.HybridSecureUtil;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.secure.SecureProviderFactory;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IKitConfig;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.MonitorConfig;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.MonitorSettingsConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.web.IWebKitService;
import com.bytedance.ies.bullet.service.base.web.IWebResourceRequest;
import com.bytedance.ies.bullet.service.base.web.IWebViewDelegate;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDelegate;
import com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.model.BDXPageModel;
import com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import com.bytedance.ies.bullet.service.webkit.GlobalPropsHandler;
import com.bytedance.ies.bullet.service.webkit.IWebKitDelegateProvider;
import com.bytedance.ies.bullet.service.webkit.WebKitService;
import com.bytedance.ies.bullet.ui.common.DebugTagTextView;
import com.bytedance.ies.bullet.ui.common.IBulletViewProvider;
import com.bytedance.ies.bullet.web.pia.PiaHelper;
import com.bytedance.ies.bullet.web.pia.PiaLifeCycle;
import com.bytedance.ies.bullet.web.scc.SccDelegate;
import com.bytedance.sdk.xbridge.cn.optimize.RuntimeConfig;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBDXBridge;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeContext;
import com.bytedance.sdk.xbridge.cn.service.IContainerInstance;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: AnnieXWebKit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 \u0097\u00012\u00020\u0001:\u0002\u0097\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010G\u001a\u00020H2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010I\u001a\u00020HH\u0002J\"\u0010J\u001a\u00020H2\u0006\u0010E\u001a\u00020F2\u0006\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010N\u001a\u00020H2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0006\u0010O\u001a\u00020\nJ\u0010\u0010P\u001a\u00020H2\u0006\u0010K\u001a\u00020LH\u0007J\u0012\u0010Q\u001a\u00020H2\b\u0010R\u001a\u0004\u0018\u00010(H\u0002J\u0006\u0010S\u001a\u00020HJ\r\u0010T\u001a\u00020HH\u0000¢\u0006\u0002\bUJ\u0012\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010X\u001a\u0004\u0018\u00010FJ\b\u0010Y\u001a\u0004\u0018\u00010\u0016J0\u0010Z\u001a\u00020\u00162\u0006\u0010[\u001a\u00020\u00162\b\u0010\\\u001a\u0004\u0018\u00010]2\u0014\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020_\u0018\u00010\bH\u0002J\u0012\u0010`\u001a\u0004\u0018\u00010/2\u0006\u0010K\u001a\u00020LH\u0002J\u0006\u0010a\u001a\u000205J\u0006\u0010b\u001a\u00020\u0003J\b\u0010c\u001a\u0004\u0018\u00010\u0003J\u0012\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010F0h0gH\u0002J\b\u0010i\u001a\u0004\u0018\u00010/J\u0018\u0010j\u001a\u00020H2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020FH\u0002J\b\u0010n\u001a\u00020HH\u0002J\b\u0010o\u001a\u00020\nH\u0002J\u0018\u0010p\u001a\u00020\n2\u0006\u0010q\u001a\u00020r2\u0006\u0010m\u001a\u00020FH\u0002J*\u0010s\u001a\u00020H2\u0006\u0010[\u001a\u00020\u00162\u0006\u0010t\u001a\u00020\n2\b\u0010R\u001a\u0004\u0018\u00010(2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J*\u0010u\u001a\u00020H2\u0006\u0010K\u001a\u00020L2\b\u0010R\u001a\u0004\u0018\u00010(2\u0006\u0010E\u001a\u00020F2\b\b\u0002\u0010M\u001a\u00020\u0010J\u001d\u0010v\u001a\u00020H2\u0006\u0010m\u001a\u00020F2\b\u0010w\u001a\u0004\u0018\u00010B¢\u0006\u0002\u0010xJ\b\u0010y\u001a\u00020zH\u0007J\u0014\u0010y\u001a\u0004\u0018\u00010z2\b\u0010{\u001a\u0004\u0018\u00010|H\u0007J\u0006\u0010}\u001a\u00020\nJ\u0006\u0010~\u001a\u00020HJ\u0006\u0010\u007f\u001a\u00020HJ\u0019\u0010\u0080\u0001\u001a\u00020H2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020FH\u0002J\u0013\u0010\u0081\u0001\u001a\u00020H2\b\u0010[\u001a\u0004\u0018\u00010\u0016H\u0002J\u0007\u0010\u0082\u0001\u001a\u00020HJ\u0007\u0010\u0083\u0001\u001a\u00020HJ\u001b\u0010\u0084\u0001\u001a\u00020H2\u0007\u0010\u0085\u0001\u001a\u00020\u00032\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010_J\t\u0010\u0087\u0001\u001a\u00020HH\u0002J\u0011\u0010\u0088\u0001\u001a\u00020H2\u0006\u0010K\u001a\u00020LH\u0002J\u0011\u0010\u0089\u0001\u001a\u00020H2\u0006\u0010k\u001a\u00020/H\u0002J\u0017\u0010\u008a\u0001\u001a\u00020H2\u0006\u00106\u001a\u000207H\u0000¢\u0006\u0003\b\u008b\u0001J\t\u0010\u008c\u0001\u001a\u00020HH\u0002J\u001c\u0010\u008d\u0001\u001a\u00020H2\u0007\u0010\u008e\u0001\u001a\u00020\u00032\b\u0010R\u001a\u0004\u0018\u00010(H\u0002J\u001f\u0010\u008f\u0001\u001a\u00020H2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010l2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0003H\u0002J\u001e\u0010\u0092\u0001\u001a\u00020H2\u0015\u0010\u0093\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020_\u0018\u00010\bJ\r\u0010\u0094\u0001\u001a\u00020H*\u00020lH\u0002J\r\u0010\u0095\u0001\u001a\u00020H*\u00020lH\u0002J\u0015\u0010\u0096\u0001\u001a\u00020H*\u00020/2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u001c\u001a\u0004\u0018\u00010(@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0004\n\u0002\u0010CR\u0012\u0010D\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0004\n\u0002\u0010CR\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0098\u0001"}, d2 = {"Lcom/bytedance/android/anniex/web/AnnieXWebKit;", "Lcom/bytedance/ies/bullet/forest/ForestWebInfoHelper;", "bid", "", "kitService", "Lcom/bytedance/ies/bullet/service/webkit/WebKitService;", "(Ljava/lang/String;Lcom/bytedance/ies/bullet/service/webkit/WebKitService;)V", "additionalHttpHeaders", "", "allowAdBlock", "", "annieXWebController", "Lcom/bytedance/ies/bullet/kit/web/impl/AnnieXWebController;", "argusAdapter", "Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter;", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getContextProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "setContextProviderFactory", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;)V", "currentUri", "Landroid/net/Uri;", "enableSafeWebJSBAuth", "globalConfig", "Lcom/bytedance/ies/bullet/kit/web/WebEngineGlobalConfig;", "globalPropsHandler", "Lcom/bytedance/ies/bullet/service/webkit/GlobalPropsHandler;", "<set-?>", "isFromPreload", "()Z", "isPageFinished", "isViewFirstAppeared", "isWebViewCreate", "kitViewLifecycleDelegateWrapper", "Lcom/bytedance/android/anniex/web/webKitDelegateWrapper/KitViewLifecycleDelegateWrapper;", "networkDepend", "Lcom/bytedance/ies/bullet/base/depend/INetworkDepend;", "piaLifeCycle", "Lcom/bytedance/ies/bullet/web/pia/PiaLifeCycle;", "Lcom/bytedance/android/anniex/web/api/IAnnieXWebLifecycle;", "preloadStickLifeCycle", "getPreloadStickLifeCycle", "()Lcom/bytedance/android/anniex/web/api/IAnnieXWebLifecycle;", "reUsePageViewed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "realView", "Lcom/bytedance/ies/bullet/kit/web/SSWebView;", "sccConfig", "Lcom/bytedance/ies/bullet/secure/SccConfig;", "sccDelegate", "Lcom/bytedance/ies/bullet/web/scc/SccDelegate;", "sccLevel", "Lcom/bytedance/ies/bullet/secure/SccConfig$SccLevel;", "scene", "Lcom/bytedance/ies/bullet/core/common/Scenes;", "shouldResetPageStartUrlWhenReceivedError", "webBdxBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBDXBridge;", "getWebBdxBridge", "()Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBDXBridge;", "setWebBdxBridge", "(Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBDXBridge;)V", "webKitDelegateWrapper", "Lcom/bytedance/android/anniex/web/webKitDelegateWrapper/WebKitDelegateWrapper;", "webViewCreateBegin", "", "Ljava/lang/Long;", "webViewCreateEnd", "webViewModel", "Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", "addTagView", "", "buildWebView", "buildWebViewByModel", "context", "Landroid/content/Context;", "providerFactory", "clearContextProvider", "createByPreCreate", "createWebView", "dealWithPreload", "lifeCycle", "destroy", "flushStatus", "flushStatus$anniex_release", "getContextProvider", "Lcom/bytedance/android/anniex/ability/service/IAnnieXContextProvider;", "getCurrentModel", "getCurrentUri", "getInjectUri", "uri", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "allGlobalProps", "", "getPreCreateWebView", "getSccLevel", "getSdkVersion", "getSessionId", "getUrlInterceptorDelegate", "Lcom/bytedance/ies/bullet/kit/web/IWebViewLoadUrlInterceptorDelegate;", "getWeakReference", "Lkotlin/Function0;", "Ljava/lang/ref/WeakReference;", "getWebView", "initMonitorConfig", "webView", "Landroid/webkit/WebView;", "annieXWebModel", "injectGlobalProps", "isCachedView", "isJsSdkEnable", "monitorConfig", "Lcom/bytedance/ies/bullet/service/base/MonitorConfig;", "loadInner", "isReload", "loadUri", "markOpenTime", SceneDbContract.Scenes.COLUMN_TIMESTAMP, "(Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;Ljava/lang/Long;)V", "onAdFilter", "Landroid/webkit/WebResourceResponse;", "request", "Landroid/webkit/WebResourceRequest;", "onBackPressed", "onHide", "onShow", "onViewCreate", "performForestDelayPreload", "reload", "reloadCurrentUrl", "sendEvent", "eventName", "params", "setAdBlock", "setClientListbyGlobalConfig", "setSccDelegate", "setViewScene", "setViewScene$anniex_release", "setWebChromeClientDelegate", "setWebViewClient", "loadUrl", "showCloseAll", "view", StreamTrafficObservable.STREAM_URL, "updateGlobalProps", Constants.KEY_DATA, "setLongClickable", "setWebParams", "setWebSecureDelegate", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXWebKit implements ForestWebInfoHelper {
    public static final int ERR_SSL_ERROR = -100;
    public static final String EVENT_VIEW_APPEARED = "viewAppeared";
    public static final String EVENT_VIEW_CLOSED = "pageClosed";
    public static final String EVENT_VIEW_DISAPPEARED = "viewDisappeared";
    public static final String EVENT_VIEW_REUSED = "pageReused";
    public static final int NO_PERMISSION_FAIL_REASON = 1;
    private Map<String, String> additionalHttpHeaders;
    private boolean allowAdBlock;
    private AnnieXWebController annieXWebController;
    private ArgusWebDelegateAdapter argusAdapter;
    private final String bid;
    private ContextProviderFactory contextProviderFactory;
    private Uri currentUri;
    private boolean enableSafeWebJSBAuth;
    private WebEngineGlobalConfig globalConfig;
    private GlobalPropsHandler globalPropsHandler;
    private boolean isFromPreload;
    private boolean isPageFinished;
    private boolean isViewFirstAppeared;
    private volatile boolean isWebViewCreate;
    private final WebKitService kitService;
    private KitViewLifecycleDelegateWrapper kitViewLifecycleDelegateWrapper;
    private INetworkDepend networkDepend;
    private PiaLifeCycle piaLifeCycle;
    private IAnnieXWebLifecycle preloadStickLifeCycle;
    private final AtomicBoolean reUsePageViewed;
    private volatile SSWebView realView;
    private SccConfig sccConfig;
    private SccDelegate sccDelegate;
    private SccConfig.SccLevel sccLevel;
    private Scenes scene;
    private final boolean shouldResetPageStartUrlWhenReceivedError;
    private WebBDXBridge webBdxBridge;
    private WebKitDelegateWrapper webKitDelegateWrapper;
    private Long webViewCreateBegin;
    private Long webViewCreateEnd;
    private AnnieXWebModel webViewModel;

    /* compiled from: AnnieXWebKit.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scenes.values().length];
            try {
                iArr[Scenes.Card.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final boolean isCachedView() {
        return false;
    }

    public final String getSdkVersion() {
        return "";
    }

    public AnnieXWebKit(String str, WebKitService webKitService) {
        SecuritySettingConfig securitySettingConfig;
        JSBAuthStrategySetting jsbAuthStrategySettingConfig;
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(webKitService, "kitService");
        this.bid = str;
        this.kitService = webKitService;
        this.annieXWebController = new AnnieXWebController(webKitService);
        this.isViewFirstAppeared = true;
        this.reUsePageViewed = new AtomicBoolean(false);
        this.scene = Scenes.Card;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        this.enableSafeWebJSBAuth = ((iBulletSettingsService == null || (securitySettingConfig = (SecuritySettingConfig) iBulletSettingsService.obtainSettings(SecuritySettingConfig.class)) == null || (jsbAuthStrategySettingConfig = securitySettingConfig.getJsbAuthStrategySettingConfig()) == null) ? new JSBAuthStrategySetting() : jsbAuthStrategySettingConfig).getEnableSafeWebJSBAuth();
        this.globalPropsHandler = new GlobalPropsHandler(webKitService);
        this.sccLevel = SccConfig.SccLevel.SAFE;
        this.contextProviderFactory = new ContextProviderFactory();
        ISettingService service = webKitService.getService(ISettingService.class);
        this.shouldResetPageStartUrlWhenReceivedError = service != null ? service.provideBulletSettings().getShouldResetPageStartUrlWhenReceivedError() : false;
    }

    public Pair<Boolean, Scene> canInterceptByForest(WebResourceRequest webResourceRequest, IServiceToken iServiceToken, BulletContext bulletContext, SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.canInterceptByForest(this, webResourceRequest, iServiceToken, bulletContext, schemaModelUnion);
    }

    public Pair<Boolean, Scene> canInterceptByForest(String str, boolean z, IServiceToken iServiceToken, BulletContext bulletContext, SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.canInterceptByForest(this, str, z, iServiceToken, bulletContext, schemaModelUnion);
    }

    public boolean delayPreload(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.delayPreload(this, uri);
    }

    public boolean delayPreload(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.delayPreload(this, bulletContext);
    }

    public boolean delayPreload(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.delayPreload(this, schemaModelUnion);
    }

    public String forestDownloadEngine(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, uri);
    }

    public String forestDownloadEngine(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, bulletContext);
    }

    public String forestDownloadEngine(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, iServiceToken);
    }

    public String forestDownloadEngine(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, schemaModelUnion);
    }

    public String getResTag(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestWebInfoHelper.DefaultImpls.getResTag(this, lynxResourceType);
    }

    public Scene getSceneType(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestWebInfoHelper.DefaultImpls.getSceneType(this, lynxResourceType);
    }

    public ProcessedResponse<TemplateBundle> getTemplateBundleResponse(Response response) {
        return ForestWebInfoHelper.DefaultImpls.getTemplateBundleResponse(this, response);
    }

    public boolean hasGeckoModelInfo(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.hasGeckoModelInfo(this, bulletContext);
    }

    public boolean hasGeckoModelInfo(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.hasGeckoModelInfo(this, iServiceToken);
    }

    public boolean hasGeckoModelInfo(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.hasGeckoModelInfo(this, schemaModelUnion);
    }

    public String preloadScope(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.preloadScope(this, uri);
    }

    public String preloadScope(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.preloadScope(this, bulletContext);
    }

    public String preloadScope(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.preloadScope(this, schemaModelUnion);
    }

    public String sessionID(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.sessionID(this, bulletContext);
    }

    public String sessionID(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.sessionID(this, iServiceToken);
    }

    public boolean useForest(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, uri);
    }

    public boolean useForest(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, bulletContext);
    }

    public boolean useForest(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, iServiceToken);
    }

    public boolean useForest(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, schemaModelUnion);
    }

    public /* synthetic */ AnnieXWebKit(String str, WebKitService webKitService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new WebKitService((IKitConfig) null, (IWebKitDelegateProvider) null, 3, (DefaultConstructorMarker) null) : webKitService);
    }

    public final WebBDXBridge getWebBdxBridge() {
        return this.webBdxBridge;
    }

    public final void setWebBdxBridge(WebBDXBridge webBDXBridge) {
        this.webBdxBridge = webBDXBridge;
    }

    /* renamed from: isFromPreload, reason: from getter */
    public final boolean getIsFromPreload() {
        return this.isFromPreload;
    }

    public final ContextProviderFactory getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    public final void setContextProviderFactory(ContextProviderFactory contextProviderFactory) {
        Intrinsics.checkNotNullParameter(contextProviderFactory, "<set-?>");
        this.contextProviderFactory = contextProviderFactory;
    }

    private final IWebViewLoadUrlInterceptorDelegate getUrlInterceptorDelegate(ContextProviderFactory contextProviderFactory) {
        String businessId;
        AnnieXWebModel annieXWebModel = this.webViewModel;
        IWebGlobalConfigService iWebGlobalConfigService = (annieXWebModel == null || (businessId = annieXWebModel.getBusinessId()) == null) ? null : (IWebGlobalConfigService) ServiceCenter.Companion.instance().get(businessId, IWebGlobalConfigService.class);
        if (iWebGlobalConfigService != null) {
            return iWebGlobalConfigService.createWebViewLoadUrlInterceptorDelegate(contextProviderFactory);
        }
        return null;
    }

    /* renamed from: getCurrentModel, reason: from getter */
    public final AnnieXWebModel getWebViewModel() {
        return this.webViewModel;
    }

    public final boolean createByPreCreate() {
        WebView webView = this.realView;
        if (webView != null) {
            return this.annieXWebController.isPreCreate(webView);
        }
        return false;
    }

    public final IAnnieXWebLifecycle getPreloadStickLifeCycle() {
        return this.preloadStickLifeCycle;
    }

    public final void flushStatus$anniex_release() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.android.anniex.web.AnnieXWebKit$flushStatus$1
            @Override // java.lang.Runnable
            public final void run() {
                String str;
                AnnieXWebKit annieXWebKit = AnnieXWebKit.this;
                str = annieXWebKit.bid;
                annieXWebKit.addTagView(str);
            }
        });
    }

    public final void createWebView(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        this.webViewCreateBegin = Long.valueOf(System.currentTimeMillis());
        if (this.isWebViewCreate) {
            return;
        }
        WebView preCreateWebView = getPreCreateWebView(context);
        if (preCreateWebView != null) {
            if (IConditionCallKt.enableAnnieXWebKitKeyboardFix()) {
                try {
                    Result.Companion companion = Result.Companion;
                    preCreateWebView.setFocusable(true);
                    preCreateWebView.setFocusableInTouchMode(true);
                    obj = Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                Throwable th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    HybridLogger.e$default(HybridLogger.INSTANCE, "XWebKit", "setFocusable error...message is " + th2.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
                }
            }
            LollipopV21Compat.setAcceptThirdPartyCookies(preCreateWebView, true);
        }
        buildWebView();
        this.webViewCreateEnd = Long.valueOf(System.currentTimeMillis());
    }

    public final void setViewScene$anniex_release(Scenes scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.scene = scene;
    }

    private final SSWebView getPreCreateWebView(Context context) {
        if (this.realView != null) {
            SSWebView sSWebView = this.realView;
            Intrinsics.checkNotNull(sSWebView, "null cannot be cast to non-null type com.bytedance.ies.bullet.kit.web.SSWebView");
            return sSWebView;
        }
        this.realView = this.annieXWebController.createWebView(context);
        return this.realView;
    }

    private final void buildWebView() {
        HybridSecureConfig secureConfig$anniex_release = HybridSecureManager.Companion.getInstance().getSecureConfig$anniex_release(this.bid);
        this.networkDepend = secureConfig$anniex_release != null ? secureConfig$anniex_release.getNetworkDepend$anniex_release() : null;
        HybridSecureConfig secureConfig$anniex_release2 = HybridSecureManager.Companion.getInstance().getSecureConfig$anniex_release(this.bid);
        this.sccConfig = secureConfig$anniex_release2 != null ? secureConfig$anniex_release2.getSccConfig$anniex_release() : null;
        SSWebView sSWebView = this.realView;
        if (sSWebView != null) {
            PiaHelper piaHelper = PiaHelper.INSTANCE;
            String str = this.bid;
            String userAgentString = sSWebView.getSettings().getUserAgentString();
            Intrinsics.checkNotNullExpressionValue(userAgentString, "it.settings.userAgentString");
            piaHelper.updateUserAgent(str, userAgentString);
        }
        WebEngineGlobalConfig webEngineGlobalConfig = new WebEngineGlobalConfig();
        BulletContext bulletContext = new BulletContext();
        bulletContext.setSimpleCard(true);
        bulletContext.setBid(this.bid);
        webEngineGlobalConfig.config(bulletContext, CollectionsKt.emptyList());
        this.globalConfig = webEngineGlobalConfig;
        this.isWebViewCreate = true;
    }

    private final void buildWebViewByModel(AnnieXWebModel webViewModel, Context context, ContextProviderFactory providerFactory) {
        ArgusWebDelegateAdapter argusWebDelegateAdapter;
        List webGlobalConfigServiceList;
        List<IWebGlobalConfigService> reversed;
        IWebGlobalConfigService defaultGlobalWebConfigService;
        SSWebView sSWebView = this.realView;
        if (sSWebView != null) {
            WebView webView = (WebView) sSWebView;
            initMonitorConfig(webView, webViewModel);
            WebViewMonitorHelper.getInstance().handleViewCreate(webView);
        }
        if (providerFactory != null) {
            this.contextProviderFactory.merge(providerFactory);
        }
        WebView webView2 = this.realView;
        if (webView2 != null) {
            this.webBdxBridge = XBridgeWebHelper.INSTANCE.getWebBridge(context, webViewModel, webView2, this, this.contextProviderFactory);
        }
        SSWebView sSWebView2 = this.realView;
        if (sSWebView2 != null) {
            setWebSecureDelegate(sSWebView2, this.contextProviderFactory);
        }
        SSWebView sSWebView3 = this.realView;
        if (sSWebView3 != null && webViewModel.getEnablePIA()) {
            PiaLifeCycle createPiaLifeCycle = PiaHelper.INSTANCE.createPiaLifeCycle(webViewModel.getBusinessId());
            if (createPiaLifeCycle != null) {
                createPiaLifeCycle.bindContext(sSWebView3, webViewModel.getBulletContext());
                sSWebView3.setPiaLifeCycle$anniex_release(createPiaLifeCycle);
            } else {
                createPiaLifeCycle = null;
            }
            this.piaLifeCycle = createPiaLifeCycle;
        }
        WebView webView3 = this.realView;
        if (webView3 != null) {
            WebEngineGlobalConfig webEngineGlobalConfig = this.globalConfig;
            if (webEngineGlobalConfig != null && (defaultGlobalWebConfigService = webEngineGlobalConfig.getDefaultGlobalWebConfigService()) != null) {
                WebSettings settings = webView3.getSettings();
                Intrinsics.checkNotNullExpressionValue(settings, "_webView.settings");
                defaultGlobalWebConfigService.applySettings(settings, webView3, this.contextProviderFactory);
            }
            WebEngineGlobalConfig webEngineGlobalConfig2 = this.globalConfig;
            if (webEngineGlobalConfig2 != null && (webGlobalConfigServiceList = webEngineGlobalConfig2.getWebGlobalConfigServiceList()) != null && (reversed = CollectionsKt.reversed(webGlobalConfigServiceList)) != null) {
                for (IWebGlobalConfigService iWebGlobalConfigService : reversed) {
                    WebSettings settings2 = webView3.getSettings();
                    Intrinsics.checkNotNullExpressionValue(settings2, "_webView.settings");
                    iWebGlobalConfigService.applySettings(settings2, webView3, this.contextProviderFactory);
                }
            }
        }
        SSWebView sSWebView4 = this.realView;
        if (sSWebView4 != null) {
            onViewCreate((WebView) sSWebView4, webViewModel);
        }
        SSWebView sSWebView5 = this.realView;
        if (sSWebView5 == null || (argusWebDelegateAdapter = this.argusAdapter) == null) {
            return;
        }
        argusWebDelegateAdapter.verifyOnWebViewCreated(sSWebView5);
    }

    private final void onViewCreate(WebView webView, AnnieXWebModel annieXWebModel) {
        SchemaModelUnion schemaModelUnion = annieXWebModel.getSchemaModelUnion();
        if (schemaModelUnion != null) {
            Integer num = (Integer) new UIColorParam(schemaModelUnion.getSchemaData(), "content_bg_color", (Integer) null).getValue();
            Integer num2 = (Integer) new UIColorParam(schemaModelUnion.getSchemaData(), "web_bg_color", (Integer) null).getValue();
            if (num != null) {
                webView.setBackgroundColor(num.intValue());
            }
            if (num2 != null) {
                webView.setBackgroundColor(num2.intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addTagView(String bid) {
        SSWebView sSWebView = this.realView;
        if (sSWebView != null) {
            DebugInfo debugInfo = DebugConfig.INSTANCE.get(bid);
            if (!(BulletEnv.Companion.getInstance().getDebuggable() && BulletEnv.Companion.getInstance().getShowTag() && debugInfo.getShowDebugTagView())) {
                debugInfo = null;
            }
            if (debugInfo == null) {
                return;
            }
            int childCount = sSWebView.getChildCount();
            DebugTagTextView debugTagTextView = null;
            for (int i = 1; i < childCount; i++) {
                View childAt = sSWebView.getChildAt(i);
                if (childAt != null) {
                    Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                    debugTagTextView = childAt instanceof DebugTagTextView ? (DebugTagTextView) childAt : null;
                }
                if (debugTagTextView != null) {
                    break;
                }
            }
            if (debugTagTextView == null) {
                DebugTagTextView inflate = LayoutInflater.from(sSWebView.getContext()).inflate(C0840R.layout.bullet_debug_tag_view, (ViewGroup) null);
                debugTagTextView = inflate instanceof DebugTagTextView ? inflate : null;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 8388691;
                int dimensionPixelSize = sSWebView.getContext().getResources().getDimensionPixelSize(C0840R.dimen.bullet_debug_tab_view_margin);
                layoutParams.leftMargin = dimensionPixelSize;
                layoutParams.bottomMargin = dimensionPixelSize;
                sSWebView.addView((View) debugTagTextView, layoutParams);
            }
            if (debugTagTextView != null) {
                String str = WhenMappings.$EnumSwitchMapping$0[this.scene.ordinal()] == 1 ? "annieX_card" : "annieX_card_" + this.scene.getTag();
                String str2 = this.isFromPreload ? "engine" : "";
                AnnieXWebModel annieXWebModel = this.webViewModel;
                if (Intrinsics.areEqual(annieXWebModel != null ? annieXWebModel.getEnterFrom() : null, AnnieXConstants.ANNIEX_CARD)) {
                    debugTagTextView.setText(str + "_web_" + str2);
                } else {
                    StringBuilder append = new StringBuilder().append(str).append("_web_");
                    AnnieXWebModel annieXWebModel2 = this.webViewModel;
                    debugTagTextView.setText(append.append(annieXWebModel2 != null ? annieXWebModel2.getEnterFrom() : null).append('_').append(str2).toString());
                }
                final Function1 onTagClickListener = BulletEnv.Companion.getInstance().getOnTagClickListener();
                if (onTagClickListener != null) {
                    debugTagTextView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.web.AnnieXWebKit$addTagView$1$2$1$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SSWebView sSWebView2;
                            Function1<View, Unit> function1 = onTagClickListener;
                            sSWebView2 = this.realView;
                            function1.invoke(sSWebView2);
                        }
                    });
                }
            }
        }
    }

    private final void initMonitorConfig(WebView webView, AnnieXWebModel annieXWebModel) {
        Iterator<String> keys;
        IWebViewMonitorHelper webViewMonitorHelper = WebViewMonitorHelper.getInstance();
        IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(this.bid, IMonitorReportService.class);
        if (iMonitorReportService == null) {
            iMonitorReportService = (IMonitorReportService) MonitorReportService.Companion.getFallbackDefault();
        }
        MonitorConfig monitorConfig = iMonitorReportService.getMonitorConfig();
        IWebViewMonitorHelper.Config buildConfig = webViewMonitorHelper.buildConfig();
        buildConfig.setVirtualAID(monitorConfig.getVirtualAID());
        buildConfig.setBid(monitorConfig.getBizTag());
        buildConfig.setIsNeedMonitor(monitorConfig.getLogSwitch());
        buildConfig.setIsNeedInjectBrowser(Boolean.valueOf(isJsSdkEnable(monitorConfig, annieXWebModel)));
        buildConfig.setWebViewObjKeys(new WebView[]{webView});
        buildConfig.setPerformanceReportAfterDetach();
        buildConfig.setBlankDetectCallback(new DefaultAnnieXWebBlankCallback(getWeakReference()));
        buildConfig.setFallbackContainerName("AnnieXWeb");
        buildConfig.setSessionId(annieXWebModel.getSessionId());
        webViewMonitorHelper.addConfig(buildConfig);
        JSONObject category = monitorConfig.getCategory();
        if (category == null || (keys = category.keys()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(keys, "keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject category2 = monitorConfig.getCategory();
            Intrinsics.checkNotNull(category2);
            webViewMonitorHelper.addContext(webView, next, category2.get(next).toString());
        }
    }

    private final boolean isJsSdkEnable(MonitorConfig monitorConfig, AnnieXWebModel annieXWebModel) {
        MonitorSettingsConfig monitorSettingsConfig;
        String[] jsSdkDisallowList;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService != null && (monitorSettingsConfig = (MonitorSettingsConfig) iBulletSettingsService.obtainSettings(MonitorSettingsConfig.class)) != null && (jsSdkDisallowList = monitorSettingsConfig.getJsSdkDisallowList()) != null) {
            for (String str : jsSdkDisallowList) {
                if (StringsKt.contains$default(annieXWebModel.getUrl(), str, false, 2, (Object) null)) {
                    return false;
                }
            }
        }
        return monitorConfig.getInjectBrowser();
    }

    private final Function0<WeakReference<AnnieXWebModel>> getWeakReference() {
        return new Function0<WeakReference<AnnieXWebModel>>() { // from class: com.bytedance.android.anniex.web.AnnieXWebKit$getWeakReference$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final WeakReference<AnnieXWebModel> invoke() {
                AnnieXWebModel annieXWebModel;
                annieXWebModel = AnnieXWebKit.this.webViewModel;
                return new WeakReference<>(annieXWebModel);
            }
        };
    }

    private final void setWebSecureDelegate(SSWebView sSWebView, final ContextProviderFactory contextProviderFactory) {
        StringParam secureLinkScene;
        SchemaModelUnion schemaModelUnion;
        AnnieXWebModel annieXWebModel = this.webViewModel;
        final String str = null;
        ISchemaModel kitModel = (annieXWebModel == null || (schemaModelUnion = annieXWebModel.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getKitModel();
        BDXWebKitModel bDXWebKitModel = kitModel instanceof BDXWebKitModel ? (BDXWebKitModel) kitModel : null;
        if (bDXWebKitModel != null && (secureLinkScene = bDXWebKitModel.getSecureLinkScene()) != null) {
            str = (String) secureLinkScene.getValue();
        }
        AnnieXWebModel annieXWebModel2 = this.webViewModel;
        final boolean z = false;
        if (annieXWebModel2 != null && annieXWebModel2.getEnablePIA()) {
            z = true;
        }
        if (!z) {
            sSWebView.setSecureLinkScene(str);
        }
        ArgusWebDelegateAdapter build = ArgusWebDelegateAdapter.Companion.build(new SecureProviderFactory() { // from class: com.bytedance.android.anniex.web.AnnieXWebKit$setWebSecureDelegate$adapter$1
            public BulletContext getContext() {
                AnnieXWebModel annieXWebModel3;
                annieXWebModel3 = AnnieXWebKit.this.webViewModel;
                if (annieXWebModel3 != null) {
                    return annieXWebModel3.getBulletContext();
                }
                return null;
            }

            public String getSchema() {
                Uri uri;
                uri = AnnieXWebKit.this.currentUri;
                if (uri != null) {
                    return uri.toString();
                }
                return null;
            }

            /* renamed from: getSecLinkScene, reason: from getter */
            public String get$scene() {
                return str;
            }

            public IWebSecureDelegate getExternDelegate() {
                WebEngineGlobalConfig webEngineGlobalConfig;
                IWebGlobalConfigService defaultGlobalWebConfigService;
                webEngineGlobalConfig = AnnieXWebKit.this.globalConfig;
                if (webEngineGlobalConfig == null || (defaultGlobalWebConfigService = webEngineGlobalConfig.getDefaultGlobalWebConfigService()) == null) {
                    return null;
                }
                return defaultGlobalWebConfigService.createWebSecureDelegate(contextProviderFactory);
            }

            public Boolean enablePIA() {
                return Boolean.valueOf(z);
            }
        }, (WebView) sSWebView);
        this.argusAdapter = build;
        sSWebView.setArgusAdapter$anniex_release(build);
    }

    public final void markOpenTime(AnnieXWebModel annieXWebModel, Long timestamp) {
        View view;
        Intrinsics.checkNotNullParameter(annieXWebModel, "annieXWebModel");
        MonitorManager.INSTANCE.markOpenTime(annieXWebModel.getSessionId(), timestamp);
        String sessionId = getSessionId();
        if (sessionId == null || Intrinsics.areEqual(annieXWebModel.getSessionId(), sessionId) || (view = this.realView) == null) {
            return;
        }
        MonitorManager.INSTANCE.attachNewSessionId(annieXWebModel.getSessionId(), view, "web");
    }

    public static /* synthetic */ void loadUri$default(AnnieXWebKit annieXWebKit, Context context, IAnnieXWebLifecycle iAnnieXWebLifecycle, AnnieXWebModel annieXWebModel, ContextProviderFactory contextProviderFactory, int i, Object obj) {
        if ((i & 8) != 0) {
            contextProviderFactory = new ContextProviderFactory();
        }
        annieXWebKit.loadUri(context, iAnnieXWebLifecycle, annieXWebModel, contextProviderFactory);
    }

    public final void loadUri(final Context context, IAnnieXWebLifecycle lifeCycle, final AnnieXWebModel webViewModel, ContextProviderFactory providerFactory) {
        WebBridgeContext webBridgeContext;
        ContextProviderFactory contextProviderFactory;
        IAnnieXBizPropsProvider iAnnieXBizPropsProvider;
        Map<String, Object> commonExtByContext;
        Map<String, Object> pageGlobalPropsByApplication$anniex_release;
        BulletContext bulletContext;
        WebBDXBridge webBDXBridge;
        WebBridgeContext webBridgeContext2;
        WebBridgeContext webBridgeContext3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webViewModel, "webViewModel");
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        MonitorManager.INSTANCE.onWebLoadStart(webViewModel.getSessionId(), AnnieXCardScene.NEW);
        if (DefaultWebKitDelegate.Companion.getGlobalColdStart()) {
            HybridLogger.i$default(HybridLogger.INSTANCE, "XWebKit", "cold start this time", (Map) null, (LoggerContext) null, 12, (Object) null);
            DefaultWebKitDelegate.Companion.setGlobalColdStart(false);
        }
        dealWithPreload(lifeCycle);
        Long l = this.webViewCreateBegin;
        if (l != null) {
            MonitorManager.INSTANCE.onWebViewCreateBegin(webViewModel.getSessionId(), l.longValue());
        }
        Long l2 = this.webViewCreateEnd;
        if (l2 != null) {
            long longValue = l2.longValue();
            WebView webView = this.realView;
            if (webView != null) {
                MonitorManager.INSTANCE.onWebViewCreateEnd(webView, webViewModel.getSessionId(), longValue);
            }
        }
        buildWebViewByModel(webViewModel, context, providerFactory);
        this.contextProviderFactory.merge(providerFactory);
        this.webViewModel = webViewModel;
        if (IConditionCallKt.enableLitePageBidExpand()) {
            if (ServiceCenter.Companion.instance().get(this.bid, IWebKitService.class) != null) {
                this.webKitDelegateWrapper = new WebKitDelegateWrapper(webViewModel, this.kitService);
            }
            if (ServiceCenter.Companion.instance().get(this.bid, IWebGlobalConfigService.class) != null) {
                this.kitViewLifecycleDelegateWrapper = new KitViewLifecycleDelegateWrapper(this.contextProviderFactory, this.bid);
            }
        }
        if (!webViewModel.getAppendQueryMap().isEmpty()) {
            Uri.Builder buildUpon = webViewModel.getOriginalUri().buildUpon();
            for (Map.Entry<String, String> entry : webViewModel.getAppendQueryMap().entrySet()) {
                buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            this.currentUri = buildUpon.build();
        } else {
            AnnieXWebModel annieXWebModel = this.webViewModel;
            this.currentUri = annieXWebModel != null ? annieXWebModel.getOriginalUri() : null;
        }
        WebBDXBridge webBDXBridge2 = this.webBdxBridge;
        if (((webBDXBridge2 == null || (webBridgeContext3 = webBDXBridge2.getWebBridgeContext()) == null) ? null : (ContextProviderFactory) webBridgeContext3.getService(ContextProviderFactory.class)) == null && (webBDXBridge = this.webBdxBridge) != null && (webBridgeContext2 = webBDXBridge.getWebBridgeContext()) != null) {
            webBridgeContext2.registerService(ContextProviderFactory.class, this.contextProviderFactory);
        }
        AnnieXWebModel annieXWebModel2 = this.webViewModel;
        if (annieXWebModel2 != null && (bulletContext = annieXWebModel2.getBulletContext()) != null) {
            bulletContext.setContext(context);
        }
        WebBDXBridge webBDXBridge3 = this.webBdxBridge;
        if (webBDXBridge3 != null && (webBridgeContext = webBDXBridge3.getWebBridgeContext()) != null && (contextProviderFactory = (ContextProviderFactory) webBridgeContext.getService(ContextProviderFactory.class)) != null) {
            this.globalPropsHandler.injectContextProvider(contextProviderFactory);
            Map<String, Object> globalProps = webViewModel.getGlobalProps();
            if (globalProps != null) {
                globalProps.put("containerID", webViewModel.getSessionId());
                globalProps.put("forestSessionId", webViewModel.getSessionId());
                Uri uri = this.currentUri;
                if (uri != null) {
                    String uri2 = uri.toString();
                    Intrinsics.checkNotNullExpressionValue(uri2, "it1.toString()");
                    globalProps.put("location", uri2);
                }
                if ((context instanceof Application) && (pageGlobalPropsByApplication$anniex_release = GlobalPropsHelper.INSTANCE.getPageGlobalPropsByApplication$anniex_release(webViewModel.getBusinessId(), (Application) context)) != null) {
                    globalProps.putAll(pageGlobalPropsByApplication$anniex_release);
                }
                Map<String, Object> pageGlobalPropsByActivity = GlobalPropsHelper.INSTANCE.getPageGlobalPropsByActivity(webViewModel.getBusinessId(), KitType.WEB, context);
                if (pageGlobalPropsByActivity != null) {
                    globalProps.putAll(pageGlobalPropsByActivity);
                }
                if (AnnieXWebModelBuilderKt.isCompactMode(webViewModel.getSchemaModelUnion()) && IConditionCallKt.enableAnnieXLiveCompactMode() && (iAnnieXBizPropsProvider = (IAnnieXBizPropsProvider) AnnieX.INSTANCE.getService(this.bid, IAnnieXBizPropsProvider.class)) != null && (commonExtByContext = iAnnieXBizPropsProvider.getCommonExtByContext(this.bid, KitType.WEB, context)) != null) {
                    webViewModel.getGlobalProps().putAll(commonExtByContext);
                }
                GlobalPropsHelper globalPropsHelper = GlobalPropsHelper.INSTANCE;
                KitType kitType = KitType.WEB;
                Uri uri3 = this.currentUri;
                if (uri3 == null) {
                    uri3 = webViewModel.getOriginalUri();
                }
                globalProps.putAll(GlobalPropsHelper.getUriGlobalProps$default(globalPropsHelper, kitType, uri3, webViewModel.getBusinessId(), webViewModel.getSessionId(), false, 16, null));
                this.globalPropsHandler.updateGlobalProps(globalProps);
            }
            WebView webView2 = this.realView;
            if (webView2 != null) {
                this.globalPropsHandler.injectGlobalProps(webView2);
            }
        }
        Uri uri4 = this.currentUri;
        if (uri4 == null) {
            uri4 = webViewModel.getOriginalUri();
        }
        this.currentUri = getInjectUri(uri4, webViewModel.getSchemaModelUnion(), webViewModel.getGlobalProps());
        final SSWebView sSWebView = this.realView;
        if (sSWebView != null) {
            IContainerInstance iContainerInstance = new IContainerInstance() { // from class: com.bytedance.android.anniex.web.AnnieXWebKit$loadUri$9$containerInstance$1
                public String sessionId() {
                    return AnnieXWebModel.this.getSessionId();
                }

                public String bid() {
                    return AnnieXWebModel.this.getBusinessId();
                }

                public Context context() {
                    Context context2 = context;
                    if (!(context2 instanceof MutableContextWrapper)) {
                        return context2;
                    }
                    Context baseContext = ((MutableContextWrapper) context2).getBaseContext();
                    Intrinsics.checkNotNullExpressionValue(baseContext, "{\n                      …ext\n                    }");
                    return baseContext;
                }

                public View view() {
                    return sSWebView;
                }

                public Uri uri() {
                    return AnnieXWebModel.this.getOriginalUri();
                }

                public void sendEvent(String eventName, Object params) {
                    Intrinsics.checkNotNullParameter(eventName, "eventName");
                    this.sendEvent(eventName, params);
                }
            };
            sSWebView.attachSessionId(webViewModel.getSessionId());
            this.contextProviderFactory.registerWeakHolder(IContainerInstance.class, iContainerInstance);
            if (IConditionCallKt.enableCardBidParamRegister()) {
                this.contextProviderFactory.registerHolder(ContainerBidParam.class, new ContainerBidParam(this.bid));
            }
            IAnnieXContextProvider contextProvider = getContextProvider(webViewModel.getBusinessId());
            if (contextProvider != null) {
                IContainerInstance iContainerInstance2 = iContainerInstance;
                ContextProviderFactory contextProviderFactory2 = this.contextProviderFactory;
                if (contextProviderFactory2 == null) {
                    contextProviderFactory2 = new ContextProviderFactory();
                }
                contextProvider.completeContextProvider(iContainerInstance2, context, contextProviderFactory2);
            }
        }
        if (lifeCycle != null) {
            lifeCycle.onLoadStart(String.valueOf(this.currentUri), (WebView) this.realView);
        }
        Uri uri5 = this.currentUri;
        if (uri5 == null) {
            uri5 = webViewModel.getOriginalUri();
        }
        loadInner(uri5, false, lifeCycle, this.contextProviderFactory);
        MonitorManager.INSTANCE.onWebLoadEnd(webViewModel.getSessionId());
        SLMonitorCompat sLMonitorCompat = SLMonitorCompat.INSTANCE;
        String sessionId = webViewModel.getSessionId();
        Uri uri6 = this.currentUri;
        if (uri6 == null) {
            uri6 = webViewModel.getOriginalUri();
        }
        sLMonitorCompat.reportPV(sessionId, uri6, SLMonitorCompat.ContainerType.Web.getValue(), null);
    }

    private final void dealWithPreload(IAnnieXWebLifecycle lifeCycle) {
        if (lifeCycle instanceof IStickWebLifeCycle) {
            this.preloadStickLifeCycle = lifeCycle;
            this.isFromPreload = true;
        }
    }

    public final void updateGlobalProps(Map<String, ? extends Object> data) {
        Map<String, Object> globalProps;
        Map<String, Object> globalProps2;
        Map<String, Object> injectData;
        if (data != null) {
            AnnieXWebModel annieXWebModel = this.webViewModel;
            if (annieXWebModel != null && (injectData = annieXWebModel.getInjectData()) != null) {
                injectData.putAll(data);
            }
            AnnieXWebModel annieXWebModel2 = this.webViewModel;
            if (annieXWebModel2 != null && (globalProps2 = annieXWebModel2.getGlobalProps()) != null) {
                globalProps2.putAll(data);
            }
        }
        AnnieXWebModel annieXWebModel3 = this.webViewModel;
        if (annieXWebModel3 != null && (globalProps = annieXWebModel3.getGlobalProps()) != null) {
            this.globalPropsHandler.updateGlobalProps(globalProps);
        }
        WebView webView = this.realView;
        if (webView != null) {
            this.globalPropsHandler.injectGlobalProps(webView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void injectGlobalProps() {
        StringBuilder sb = new StringBuilder("window.injectInitData=");
        Gson gson = new Gson();
        AnnieXWebModel annieXWebModel = this.webViewModel;
        String sb2 = sb.append(gson.toJson(annieXWebModel != null ? annieXWebModel.getInjectData() : null)).append(';').toString();
        SSWebView sSWebView = this.realView;
        if (sSWebView != null) {
            sSWebView.evaluateJavascript(sb2, (ValueCallback) null);
        }
    }

    private final Uri getInjectUri(Uri uri, SchemaModelUnion schemaModelUnion, Map<String, ? extends Object> allGlobalProps) {
        ISchemaModel kitModel;
        Object obj;
        Object obj2;
        if (LoaderUtil.INSTANCE.isNotNullOrEmpty(uri.getQueryParameter("appended_global_props"))) {
            return uri;
        }
        if (IConditionCallKt.enableCardAppendPropsFix()) {
            kitModel = schemaModelUnion != null ? schemaModelUnion.getKitModel() : null;
            Intrinsics.checkNotNull(kitModel, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel");
            List<String> list = (List) ((BDXWebKitModel) kitModel).getAppendGlobalProps().getValue();
            if (list == null || !HybridSecureUtil.INSTANCE.inCommonParamsAllowList(uri)) {
                return uri;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : list) {
                if (allGlobalProps != null && (obj2 = allGlobalProps.get(str)) != null) {
                    linkedHashMap.put(str, obj2);
                }
            }
            Uri build = uri.buildUpon().appendQueryParameter("appended_global_props", new JSONObject(linkedHashMap).toString()).build();
            Intrinsics.checkNotNullExpressionValue(build, "uri.buildUpon().appendQu…     .toString()).build()");
            return build;
        }
        kitModel = schemaModelUnion != null ? schemaModelUnion.getKitModel() : null;
        Intrinsics.checkNotNull(kitModel, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel");
        StringListParam appendGlobalProps = ((BDXWebKitModel) kitModel).getAppendGlobalProps();
        if (!HybridSecureUtil.INSTANCE.inCommonParamsAllowList(uri)) {
            return uri;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        List<String> list2 = (List) appendGlobalProps.getValue();
        if (list2 != null) {
            for (String str2 : list2) {
                if (allGlobalProps != null && (obj = allGlobalProps.get(str2)) != null) {
                    linkedHashMap2.put(str2, obj);
                }
            }
        }
        Uri build2 = uri.buildUpon().appendQueryParameter("appended_global_props", new JSONObject(linkedHashMap2).toString()).build();
        Intrinsics.checkNotNullExpressionValue(build2, "uri.buildUpon().appendQu…     .toString()).build()");
        return build2;
    }

    public final String getSessionId() {
        AnnieXWebModel annieXWebModel = this.webViewModel;
        if (annieXWebModel != null) {
            return annieXWebModel.getSessionId();
        }
        return null;
    }

    /* renamed from: getWebView, reason: from getter */
    public final SSWebView getRealView() {
        return this.realView;
    }

    private final void loadInner(Uri uri, boolean isReload, IAnnieXWebLifecycle lifeCycle, ContextProviderFactory contextProviderFactory) {
        final SSWebView sSWebView = this.realView;
        if (sSWebView != null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            objectRef.element = uri2;
            boolean z = false;
            this.isPageFinished = false;
            if (!isReload) {
                setWebViewClient((String) objectRef.element, lifeCycle);
                setWebChromeClientDelegate();
                setAdBlock();
                if (IConditionCallKt.enableLitePageBidExpand()) {
                    Context context = sSWebView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    setClientListbyGlobalConfig(context);
                }
                AnnieXWebModel annieXWebModel = this.webViewModel;
                if (annieXWebModel != null && annieXWebModel.getNeedSccDelegate()) {
                    setSccDelegate(sSWebView);
                }
                WebView webView = (WebView) sSWebView;
                setWebParams(webView);
                setLongClickable(webView);
                sSWebView.setEnableSafeWebJSBAuth(Boolean.valueOf(this.enableSafeWebJSBAuth));
            }
            IWebViewLoadUrlInterceptorDelegate urlInterceptorDelegate = getUrlInterceptorDelegate(contextProviderFactory);
            Function4 provideWebViewLoadUrlInterceptor = urlInterceptorDelegate != null ? urlInterceptorDelegate.provideWebViewLoadUrlInterceptor() : null;
            if (provideWebViewLoadUrlInterceptor != null) {
                String url = sSWebView.getUrl();
                Map<String, String> map = this.additionalHttpHeaders;
                provideWebViewLoadUrlInterceptor.invoke(sSWebView, url, map != null ? MapsKt.toMutableMap(map) : null, new Function2<String, Map<String, String>, Unit>() { // from class: com.bytedance.android.anniex.web.AnnieXWebKit$loadInner$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((String) obj, (Map<String, String>) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str, Map<String, String> map2) {
                        WebKitDelegateWrapper webKitDelegateWrapper;
                        WebKitDelegateWrapper webKitDelegateWrapper2;
                        if (str != null) {
                            objectRef.element = str;
                        }
                        this.performForestDelayPreload(Uri.parse((String) objectRef.element));
                        webKitDelegateWrapper = this.webKitDelegateWrapper;
                        boolean z2 = true;
                        if (webKitDelegateWrapper != null && webKitDelegateWrapper.isDelegateLoadUrl$anniex_release((String) objectRef.element)) {
                            webKitDelegateWrapper2 = this.webKitDelegateWrapper;
                            if (webKitDelegateWrapper2 != null) {
                                webKitDelegateWrapper2.delegateLoadUrl$anniex_release(sSWebView, (String) objectRef.element, map2);
                                return;
                            }
                            return;
                        }
                        if (map2 != null && !map2.isEmpty()) {
                            z2 = false;
                        }
                        if (z2) {
                            sSWebView.loadUrl((String) objectRef.element);
                        } else {
                            sSWebView.loadUrl((String) objectRef.element, map2);
                        }
                    }
                });
                return;
            }
            if (this.additionalHttpHeaders != null) {
                performForestDelayPreload(Uri.parse((String) objectRef.element));
                WebKitDelegateWrapper webKitDelegateWrapper = this.webKitDelegateWrapper;
                if (webKitDelegateWrapper != null && webKitDelegateWrapper.isDelegateLoadUrl$anniex_release((String) objectRef.element)) {
                    z = true;
                }
                if (z) {
                    WebKitDelegateWrapper webKitDelegateWrapper2 = this.webKitDelegateWrapper;
                    if (webKitDelegateWrapper2 != null) {
                        WebKitDelegateWrapper.delegateLoadUrl$anniex_release$default(webKitDelegateWrapper2, sSWebView, (String) objectRef.element, null, 4, null);
                        return;
                    }
                    return;
                }
                String str = (String) objectRef.element;
                Map<String, String> map2 = this.additionalHttpHeaders;
                Intrinsics.checkNotNull(map2);
                sSWebView.loadUrl(str, map2);
                return;
            }
            performForestDelayPreload(Uri.parse((String) objectRef.element));
            WebKitDelegateWrapper webKitDelegateWrapper3 = this.webKitDelegateWrapper;
            if (webKitDelegateWrapper3 != null && webKitDelegateWrapper3.isDelegateLoadUrl$anniex_release((String) objectRef.element)) {
                z = true;
            }
            if (z) {
                WebKitDelegateWrapper webKitDelegateWrapper4 = this.webKitDelegateWrapper;
                if (webKitDelegateWrapper4 != null) {
                    WebKitDelegateWrapper.delegateLoadUrl$anniex_release$default(webKitDelegateWrapper4, sSWebView, (String) objectRef.element, null, 4, null);
                    return;
                }
                return;
            }
            sSWebView.loadUrl((String) objectRef.element);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performForestDelayPreload(Uri uri) {
        String str;
        WebSettings settings;
        if (uri == null) {
            return;
        }
        ForestPreloadHelper forestPreloadHelper = ForestPreloadHelper.INSTANCE;
        AnnieXWebModel annieXWebModel = this.webViewModel;
        String str2 = null;
        SchemaModelUnion schemaModelUnion = annieXWebModel != null ? annieXWebModel.getSchemaModelUnion() : null;
        AnnieXWebModel annieXWebModel2 = this.webViewModel;
        if (annieXWebModel2 == null || (str = annieXWebModel2.getSessionId()) == null) {
            str = "";
        }
        AnnieXWebModel annieXWebModel3 = this.webViewModel;
        String businessId = annieXWebModel3 != null ? annieXWebModel3.getBusinessId() : null;
        PreloadType preloadType = PreloadType.WEB;
        SSWebView sSWebView = this.realView;
        if (sSWebView != null && (settings = sSWebView.getSettings()) != null) {
            str2 = settings.getUserAgentString();
        }
        forestPreloadHelper.preloadPage(schemaModelUnion, uri, str, businessId, preloadType, str2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCloseAll(WebView view, String url) {
        IBulletViewProvider.IBulletTitleBarProvider iBulletTitleBarProvider;
        IBulletViewProvider.IBulletTitleBar provideTitleBar;
        ImageView closeAllView;
        BooleanParam showCloseall;
        SchemaModelUnion schemaModelUnion;
        String str = url;
        if ((str == null || str.length() == 0) || Intrinsics.areEqual("about:blank", url)) {
            return;
        }
        ContextProviderFactory contextProviderFactory = this.contextProviderFactory;
        if (!(contextProviderFactory instanceof ContextProviderFactory)) {
            contextProviderFactory = null;
        }
        if (contextProviderFactory == null || (iBulletTitleBarProvider = (IBulletViewProvider.IBulletTitleBarProvider) contextProviderFactory.provideInstance(IBulletViewProvider.IBulletTitleBarProvider.class)) == null || (provideTitleBar = iBulletTitleBarProvider.provideTitleBar()) == null || (closeAllView = provideTitleBar.getCloseAllView()) == null) {
            return;
        }
        AnnieXWebModel annieXWebModel = this.webViewModel;
        ISchemaModel uiModel = (annieXWebModel == null || (schemaModelUnion = annieXWebModel.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getUiModel();
        BDXPageModel bDXPageModel = uiModel instanceof BDXPageModel ? (BDXPageModel) uiModel : null;
        if (!((bDXPageModel == null || (showCloseall = bDXPageModel.getShowCloseall()) == null) ? false : Intrinsics.areEqual(showCloseall.getValue(), true))) {
            if (!(view != null && view.canGoBack())) {
                closeAllView.setVisibility(8);
                return;
            }
        }
        closeAllView.setVisibility(0);
    }

    private final void setClientListbyGlobalConfig(Context context) {
        SchemaModelUnion schemaModelUnion;
        BulletContext bulletContext = new BulletContext();
        bulletContext.setSimpleCard(false);
        bulletContext.setBid(this.bid);
        AnnieXWebModel annieXWebModel = this.webViewModel;
        bulletContext.setSchemaData((annieXWebModel == null || (schemaModelUnion = annieXWebModel.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getSchemaData());
        AnnieXWebModel annieXWebModel2 = this.webViewModel;
        bulletContext.setSessionId(String.valueOf(annieXWebModel2 != null ? annieXWebModel2.getSessionId() : null));
        bulletContext.setContext(context);
        this.contextProviderFactory.registerHolder(BulletContext.class, bulletContext);
        IWebGlobalConfigService iWebGlobalConfigService = ServiceCenter.Companion.instance().get(this.bid, IWebGlobalConfigService.class);
        if (iWebGlobalConfigService != null) {
            IWebViewDelegate webViewDelegate = this.annieXWebController.getWebViewDelegate();
            WebViewClientDelegate createWebViewClientDelegate = iWebGlobalConfigService.createWebViewClientDelegate(this.contextProviderFactory);
            if (createWebViewClientDelegate != null) {
                webViewDelegate.getWebViewClientDispatcher().addWebViewClient(createWebViewClientDelegate);
            }
            WebChromeClientDelegate createWebChromeClientDelegate = iWebGlobalConfigService.createWebChromeClientDelegate(this.contextProviderFactory);
            if (createWebChromeClientDelegate != null) {
                webViewDelegate.getWebChromeClientDispatcher().addWebChromeClient(createWebChromeClientDelegate);
            }
        }
    }

    private final void setWebViewClient(final String loadUrl, final IAnnieXWebLifecycle lifeCycle) {
        this.annieXWebController.getWebViewDelegate().getWebViewClientDispatcher().addWebViewClient(0, new BulletWebViewClient() { // from class: com.bytedance.android.anniex.web.AnnieXWebKit$setWebViewClient$webViewClient$1
            private boolean errorOccurred;

            public final boolean getErrorOccurred() {
                return this.errorOccurred;
            }

            public final void setErrorOccurred(boolean z) {
                this.errorOccurred = z;
            }

            /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
            
                r0 = r2.this$0.piaLifeCycle;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onPageFinished(WebView view, String url) {
                AnnieXWebModel annieXWebModel;
                boolean z;
                String str;
                PiaLifeCycle piaLifeCycle;
                super.onPageFinished(view, url);
                annieXWebModel = AnnieXWebKit.this.webViewModel;
                if (annieXWebModel != null) {
                    MonitorManager.INSTANCE.onWebPageFinish(annieXWebModel.getSessionId());
                }
                if (Build.VERSION.SDK_INT <= 28) {
                    AnnieXWebKit.this.injectGlobalProps();
                }
                if (url != null && piaLifeCycle != null) {
                    piaLifeCycle.onPageFinished(url);
                }
                AnnieXWebKit.this.showCloseAll(view, url);
                if (!this.errorOccurred) {
                    z = AnnieXWebKit.this.isPageFinished;
                    if (!z) {
                        IAnnieXWebLifecycle iAnnieXWebLifecycle = lifeCycle;
                        if (iAnnieXWebLifecycle != null) {
                            iAnnieXWebLifecycle.onLoadUriSuccess(url, view);
                        }
                        if (!AnnieXWebKit.this.getIsFromPreload()) {
                            AnnieXWebKit annieXWebKit = AnnieXWebKit.this;
                            str = annieXWebKit.bid;
                            annieXWebKit.addTagView(str);
                        }
                        AnnieXWebKit.this.isPageFinished = true;
                    }
                }
                this.errorOccurred = false;
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                boolean unused;
                unused = AnnieXWebKit.this.shouldResetPageStartUrlWhenReceivedError;
                this.errorOccurred = true;
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            
                r2 = r9.this$0.realView;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                AnnieXWebModel annieXWebModel;
                SSWebView sSWebView;
                SSWebView sSWebView2;
                boolean z;
                SSWebView sSWebView3;
                if (request != null && request.isForMainFrame()) {
                    z = AnnieXWebKit.this.shouldResetPageStartUrlWhenReceivedError;
                    if (z && sSWebView3 != null) {
                        sSWebView3.setPageStartUrl("about:blank");
                    }
                    this.errorOccurred = true;
                }
                super.onReceivedError(view, request, error);
                if (request != null && request.isForMainFrame()) {
                    annieXWebModel = AnnieXWebKit.this.webViewModel;
                    if (annieXWebModel != null) {
                        AnnieXWebKit annieXWebKit = AnnieXWebKit.this;
                        MonitorManager monitorManager = MonitorManager.INSTANCE;
                        String businessId = annieXWebModel.getBusinessId();
                        String sessionId = annieXWebModel.getSessionId();
                        AbsBulletMonitorCallback.ErrStage errStage = AbsBulletMonitorCallback.ErrStage.Engine;
                        String valueOf = String.valueOf(error != null ? error.getDescription() : null);
                        sSWebView2 = annieXWebKit.realView;
                        monitorManager.onLoadFail(businessId, sessionId, errStage, valueOf, (View) sSWebView2);
                    }
                    IAnnieXWebLifecycle iAnnieXWebLifecycle = lifeCycle;
                    if (iAnnieXWebLifecycle != null) {
                        String str = loadUrl;
                        sSWebView = AnnieXWebKit.this.realView;
                        WebView webView = (WebView) sSWebView;
                        int errorCode = error != null ? error.getErrorCode() : 0;
                        CharSequence description = error != null ? error.getDescription() : null;
                        Uri url = request.getUrl();
                        iAnnieXWebLifecycle.onLoadFail(str, webView, (Throwable) new WebLoadError(errorCode, description, url != null ? url.toString() : null));
                    }
                }
            }

            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                String url;
                SSWebView sSWebView;
                super.onReceivedHttpError(view, request, errorResponse);
                boolean z = false;
                if (request != null && request.isForMainFrame()) {
                    z = true;
                }
                if (z) {
                    if (IConditionCallKt.shouldIgnoreHttpStatusCode(errorResponse != null ? Integer.valueOf(errorResponse.getStatusCode()) : null)) {
                        return;
                    }
                    this.errorOccurred = true;
                    if (view == null || (url = view.getUrl()) == null) {
                        return;
                    }
                    Uri url2 = request.getUrl();
                    if (!Intrinsics.areEqual(url, url2 != null ? url2.toString() : null)) {
                        url = null;
                    }
                    if (url != null) {
                        IAnnieXWebLifecycle iAnnieXWebLifecycle = lifeCycle;
                        String str = loadUrl;
                        AnnieXWebKit annieXWebKit = AnnieXWebKit.this;
                        if (iAnnieXWebLifecycle != null) {
                            sSWebView = annieXWebKit.realView;
                            iAnnieXWebLifecycle.onLoadFail(str, (WebView) sSWebView, (Throwable) new WebLoadError(errorResponse != null ? errorResponse.getStatusCode() : HttpStatus.SC_NOT_FOUND, errorResponse != null ? errorResponse.getReasonPhrase() : null, url));
                        }
                    }
                }
            }

            public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
                super.onReceivedHttpAuthRequest(view, handler, host, realm);
            }

            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                String url;
                SSWebView sSWebView;
                String path;
                boolean z = true;
                this.errorOccurred = true;
                super.onReceivedSslError(view, handler, error);
                String url2 = error != null ? error.getUrl() : null;
                if (url2 == null) {
                    url2 = "";
                }
                Uri parse = Uri.parse(url2);
                if (parse != null && (path = parse.getPath()) != null) {
                    z = StringsKt.contains$default(path, ".html", false, 2, (Object) null);
                }
                if (!z || view == null || (url = view.getUrl()) == null) {
                    return;
                }
                IAnnieXWebLifecycle iAnnieXWebLifecycle = lifeCycle;
                String str = loadUrl;
                AnnieXWebKit annieXWebKit = AnnieXWebKit.this;
                if (iAnnieXWebLifecycle != null) {
                    sSWebView = annieXWebKit.realView;
                    iAnnieXWebLifecycle.onLoadFail(str, (WebView) sSWebView, (Throwable) new WebLoadError(-100, error != null ? error.toString() : null, url));
                }
            }

            public void onPageCommitVisible(WebView view, String url) {
                SSWebView sSWebView;
                super.onPageCommitVisible(view, url);
                sSWebView = AnnieXWebKit.this.realView;
                if (sSWebView != null) {
                    sSWebView.setPageCommitVisibleUrl(url);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
            
                r11 = r8.this$0.piaLifeCycle;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                AnnieXWebModel annieXWebModel;
                SSWebView sSWebView;
                String str;
                AnnieXWebModel annieXWebModel2;
                SccDelegate sccDelegate;
                SccConfig.SccLevel syncSecureLevel;
                SSWebView sSWebView2;
                PiaLifeCycle piaLifeCycle;
                super.onPageStarted(view, url, favicon);
                annieXWebModel = AnnieXWebKit.this.webViewModel;
                if (annieXWebModel != null) {
                    MonitorManager.INSTANCE.onWebPageStart(annieXWebModel.getSessionId());
                    SLMonitorCompat.reportReusePV$default(SLMonitorCompat.INSTANCE, annieXWebModel.getSessionId(), null, url == null ? "" : url, 2, null);
                }
                sSWebView = AnnieXWebKit.this.realView;
                if (sSWebView != null) {
                    sSWebView.setPageStartUrl(url);
                }
                AnnieXWebKit.this.injectGlobalProps();
                if (url != null && piaLifeCycle != null) {
                    piaLifeCycle.onPageStarted(url);
                }
                if (url != null) {
                    AnnieXWebKit annieXWebKit = AnnieXWebKit.this;
                    IAnnieXWebLifecycle iAnnieXWebLifecycle = lifeCycle;
                    sccDelegate = annieXWebKit.sccDelegate;
                    if (sccDelegate != null && (syncSecureLevel = sccDelegate.syncSecureLevel(url)) != null) {
                        annieXWebKit.sccLevel = syncSecureLevel;
                        if (syncSecureLevel != SccConfig.SccLevel.SAFE && iAnnieXWebLifecycle != null) {
                            sSWebView2 = annieXWebKit.realView;
                            iAnnieXWebLifecycle.onLoadFail(url, (WebView) sSWebView2, (Throwable) new WebLoadError(HttpStatus.SC_FORBIDDEN, "scc check failed", url));
                        }
                    }
                }
                str = AnnieXWebKit.this.bid;
                if (Intrinsics.areEqual(str, "webcast")) {
                    Gson gson = new Gson();
                    annieXWebModel2 = AnnieXWebKit.this.webViewModel;
                    String str2 = "window.__globalProps=" + gson.toJson(annieXWebModel2 != null ? annieXWebModel2.getGlobalProps() : null) + ';';
                    if (view != null) {
                        view.evaluateJavascript(str2, null);
                    }
                }
            }

            public void onLoadResource(WebView view, String url) {
                WebBDXBridge webBdxBridge;
                super.onLoadResource(view, url);
                if (url == null || (webBdxBridge = AnnieXWebKit.this.getWebBdxBridge()) == null) {
                    return;
                }
                webBdxBridge.onLoadResource(url);
            }

            /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
            
                r0 = r3.this$0.sccDelegate;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                ArgusWebDelegateAdapter argusWebDelegateAdapter;
                SccDelegate sccDelegate;
                if (url != null && sccDelegate != null) {
                    sccDelegate.doCheck(url);
                }
                WebBDXBridge webBdxBridge = AnnieXWebKit.this.getWebBdxBridge();
                if (webBdxBridge != null) {
                    webBdxBridge.shouldOverrideUrlLoading(url);
                }
                if (view != null) {
                    argusWebDelegateAdapter = AnnieXWebKit.this.argusAdapter;
                    boolean z = false;
                    if (argusWebDelegateAdapter != null && argusWebDelegateAdapter.shouldOverrideUrlLoading(view, url)) {
                        z = true;
                    }
                    if (z) {
                        return true;
                    }
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
            
                r1 = r3.this$0.sccDelegate;
             */
            /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
            
                r1 = r3.this$0.piaLifeCycle;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean shouldOverrideUrlLoading(WebView view, IWebResourceRequest request) {
                ArgusWebDelegateAdapter argusWebDelegateAdapter;
                Uri url;
                String uri;
                SccDelegate sccDelegate;
                Uri url2;
                PiaLifeCycle piaLifeCycle;
                if (request != null && (url2 = request.getUrl()) != null && piaLifeCycle != null) {
                    String uri2 = url2.toString();
                    Intrinsics.checkNotNullExpressionValue(uri2, "it.toString()");
                    piaLifeCycle.shouldOverrideUrlLoading(uri2);
                }
                if (request != null && (url = request.getUrl()) != null && (uri = url.toString()) != null && sccDelegate != null) {
                    sccDelegate.doCheck(uri);
                }
                if (view != null) {
                    argusWebDelegateAdapter = AnnieXWebKit.this.argusAdapter;
                    if (Intrinsics.areEqual(argusWebDelegateAdapter != null ? Boolean.valueOf(argusWebDelegateAdapter.shouldOverrideUrlLoading(view, request)) : null, true)) {
                        return true;
                    }
                }
                return super.shouldOverrideUrlLoading(view, request);
            }

            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                boolean z;
                AnnieXWebModel annieXWebModel;
                AnnieXWebModel annieXWebModel2;
                SccDelegate sccDelegate;
                WebResourceResponse shouldInterceptRequest;
                AnnieXWebController annieXWebController;
                BooleanParam skipIntercept;
                Boolean bool;
                SchemaModelUnion schemaModelUnion;
                String str = url;
                boolean z2 = false;
                if (!(str == null || str.length() == 0)) {
                    WebResourceResponse shouldSecureDelegate = shouldSecureDelegate(view, url);
                    if (shouldSecureDelegate != null) {
                        return shouldSecureDelegate;
                    }
                    annieXWebModel = AnnieXWebKit.this.webViewModel;
                    ISchemaModel kitModel = (annieXWebModel == null || (schemaModelUnion = annieXWebModel.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getKitModel();
                    BDXWebKitModel bDXWebKitModel = kitModel instanceof BDXWebKitModel ? (BDXWebKitModel) kitModel : null;
                    if (bDXWebKitModel != null && (skipIntercept = bDXWebKitModel.getSkipIntercept()) != null && (bool = (Boolean) skipIntercept.getValue()) != null) {
                        z2 = bool.booleanValue();
                    }
                    if (!z2) {
                        annieXWebModel2 = AnnieXWebKit.this.webViewModel;
                        if (annieXWebModel2 != null) {
                            annieXWebController = AnnieXWebKit.this.annieXWebController;
                            WebResourceResponse loadResource = annieXWebController.loadResource(url, annieXWebModel2);
                            if (loadResource != null) {
                                return loadResource;
                            }
                        }
                        sccDelegate = AnnieXWebKit.this.sccDelegate;
                        if (sccDelegate != null && (shouldInterceptRequest = sccDelegate.shouldInterceptRequest(url)) != null) {
                            return shouldInterceptRequest;
                        }
                    }
                }
                z = AnnieXWebKit.this.allowAdBlock;
                if (z) {
                    return AnnieXWebKit.this.onAdFilter();
                }
                return super.shouldInterceptRequest(view, url);
            }

            /* JADX WARN: Code restructure failed: missing block: B:34:0x0082, code lost:
            
                r6 = (r5 = r11.this$0).piaLifeCycle;
             */
            /* JADX WARN: Code restructure failed: missing block: B:57:0x0101, code lost:
            
                r1 = r5.webKitDelegateWrapper;
             */
            /* JADX WARN: Code restructure failed: missing block: B:64:0x0110, code lost:
            
                r3 = (r1 = r11.this$0).webViewModel;
             */
            /* JADX WARN: Code restructure failed: missing block: B:72:0x0129, code lost:
            
                r0 = r1.piaLifeCycle;
             */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0047 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                AnnieXWebModel annieXWebModel;
                boolean z;
                WebResourceResponse shouldSecureDelegate;
                AnnieXWebModel annieXWebModel2;
                boolean z2;
                AnnieXWebModel annieXWebModel3;
                boolean booleanValue;
                BooleanParam interceptRequest;
                Boolean bool;
                SchemaModelUnion schemaModelUnion;
                SccDelegate sccDelegate;
                PiaLifeCycle piaLifeCycle;
                WebResourceResponse shouldInterceptRequest;
                AnnieXWebModel annieXWebModel4;
                BulletContext bulletContext;
                AnnieXWebKit annieXWebKit;
                AnnieXWebModel annieXWebModel5;
                AnnieXWebController annieXWebController;
                WebKitDelegateWrapper webKitDelegateWrapper;
                WebKitDelegateWrapper webKitDelegateWrapper2;
                WebResourceResponse loadResource$anniex_release;
                AnnieXWebKit annieXWebKit2;
                PiaLifeCycle piaLifeCycle2;
                WebResourceResponse shouldInterceptRequest2;
                AnnieXWebModel annieXWebModel6;
                BulletContext bulletContext2;
                BooleanParam skipIntercept;
                Boolean bool2;
                SchemaModelUnion schemaModelUnion2;
                AnnieXWebModel annieXWebModel7;
                AnnieXWebKit annieXWebKit3 = AnnieXWebKit.this;
                annieXWebModel = annieXWebKit3.webViewModel;
                BulletRLContext bulletRLContext = null;
                if (annieXWebKit3.useForest(annieXWebModel != null ? annieXWebModel.getSchemaModelUnion() : null)) {
                    AnnieXWebKit annieXWebKit4 = AnnieXWebKit.this;
                    AnnieXWebKit annieXWebKit5 = annieXWebKit4;
                    annieXWebModel7 = annieXWebKit4.webViewModel;
                    if (((Boolean) ForestWebInfoHelper.DefaultImpls.canInterceptByForest$default(annieXWebKit5, request, (IServiceToken) null, (BulletContext) null, annieXWebModel7 != null ? annieXWebModel7.getSchemaModelUnion() : null, 6, (Object) null).getFirst()).booleanValue()) {
                        z = true;
                        shouldSecureDelegate = shouldSecureDelegate(view, request, z);
                        if (shouldSecureDelegate == null) {
                            return shouldSecureDelegate;
                        }
                        annieXWebModel2 = AnnieXWebKit.this.webViewModel;
                        ISchemaModel kitModel = (annieXWebModel2 == null || (schemaModelUnion2 = annieXWebModel2.getSchemaModelUnion()) == null) ? null : schemaModelUnion2.getKitModel();
                        BDXWebKitModel bDXWebKitModel = kitModel instanceof BDXWebKitModel ? (BDXWebKitModel) kitModel : null;
                        if (!((bDXWebKitModel == null || (skipIntercept = bDXWebKitModel.getSkipIntercept()) == null || (bool2 = (Boolean) skipIntercept.getValue()) == null) ? false : bool2.booleanValue())) {
                            if (z && request != null && piaLifeCycle2 != null && (shouldInterceptRequest2 = piaLifeCycle2.shouldInterceptRequest(request)) != null) {
                                if (request.isForMainFrame()) {
                                    annieXWebModel6 = annieXWebKit2.webViewModel;
                                    if (annieXWebModel6 != null && (bulletContext2 = annieXWebModel6.getBulletContext()) != null) {
                                        bulletRLContext = bulletContext2.getResourceContext();
                                    }
                                    if (bulletRLContext != null) {
                                        bulletRLContext.setResFrom("pia");
                                    }
                                }
                                return shouldInterceptRequest2;
                            }
                            if (z) {
                                booleanValue = true;
                            } else {
                                annieXWebModel3 = AnnieXWebKit.this.webViewModel;
                                ISchemaModel kitModel2 = (annieXWebModel3 == null || (schemaModelUnion = annieXWebModel3.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getKitModel();
                                BDXWebKitModel bDXWebKitModel2 = kitModel2 instanceof BDXWebKitModel ? (BDXWebKitModel) kitModel2 : null;
                                booleanValue = (bDXWebKitModel2 == null || (interceptRequest = bDXWebKitModel2.getInterceptRequest()) == null || (bool = (Boolean) interceptRequest.getValue()) == null) ? false : bool.booleanValue();
                            }
                            if (booleanValue) {
                                if (request != null) {
                                    AnnieXWebKit annieXWebKit6 = AnnieXWebKit.this;
                                    webKitDelegateWrapper = annieXWebKit6.webKitDelegateWrapper;
                                    if ((webKitDelegateWrapper != null && webKitDelegateWrapper.isDelegateLoadResource$anniex_release(request.getUrl().toString())) && webKitDelegateWrapper2 != null && (loadResource$anniex_release = webKitDelegateWrapper2.loadResource$anniex_release(request)) != null) {
                                        return loadResource$anniex_release;
                                    }
                                }
                                if (request != null && annieXWebModel5 != null) {
                                    annieXWebController = annieXWebKit.annieXWebController;
                                    WebResourceResponse loadResource = annieXWebController.loadResource(annieXWebModel5, request);
                                    if (loadResource != null) {
                                        return loadResource;
                                    }
                                }
                            }
                            if (request != null) {
                                AnnieXWebKit annieXWebKit7 = AnnieXWebKit.this;
                                if (z || piaLifeCycle == null || (shouldInterceptRequest = piaLifeCycle.shouldInterceptRequest(request)) == null) {
                                    sccDelegate = annieXWebKit7.sccDelegate;
                                    if (sccDelegate != null) {
                                        String uri = request.getUrl().toString();
                                        Intrinsics.checkNotNullExpressionValue(uri, "_request.url.toString()");
                                        WebResourceResponse shouldInterceptRequest3 = sccDelegate.shouldInterceptRequest(uri);
                                        if (shouldInterceptRequest3 != null) {
                                            return shouldInterceptRequest3;
                                        }
                                    }
                                } else {
                                    if (request.isForMainFrame()) {
                                        annieXWebModel4 = annieXWebKit7.webViewModel;
                                        if (annieXWebModel4 != null && (bulletContext = annieXWebModel4.getBulletContext()) != null) {
                                            bulletRLContext = bulletContext.getResourceContext();
                                        }
                                        if (bulletRLContext != null) {
                                            bulletRLContext.setResFrom("pia");
                                        }
                                    }
                                    return shouldInterceptRequest;
                                }
                            }
                        }
                        z2 = AnnieXWebKit.this.allowAdBlock;
                        if (z2) {
                            return AnnieXWebKit.this.onAdFilter(request);
                        }
                        return super.shouldInterceptRequest(view, request);
                    }
                }
                z = false;
                shouldSecureDelegate = shouldSecureDelegate(view, request, z);
                if (shouldSecureDelegate == null) {
                }
            }

            public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "onRenderProcessGone: detail=" + detail, (LogLevel) null, "XWebKit", 2, (Object) null);
                return super.onRenderProcessGone(view, detail);
            }

            /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
            
                r1 = r7.this$0.argusAdapter;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private final WebResourceResponse shouldSecureDelegate(WebView view, String url) {
                ArgusWebDelegateAdapter argusWebDelegateAdapter;
                ArgusWebResourceRequestRewritePayload verifyShouldInterceptRequest$anniex_release;
                SccDelegate sccDelegate;
                boolean z;
                WebResourceResponse shouldInterceptRequest;
                if (url == null || argusWebDelegateAdapter == null || (verifyShouldInterceptRequest$anniex_release = argusWebDelegateAdapter.verifyShouldInterceptRequest$anniex_release(view, url, (WebResourceRequest) null, false, true)) == null) {
                    return null;
                }
                AnnieXWebKit annieXWebKit = AnnieXWebKit.this;
                WebResourceResponse response = verifyShouldInterceptRequest$anniex_release.getResponse();
                if (response != null) {
                    return response;
                }
                if (!Intrinsics.areEqual(verifyShouldInterceptRequest$anniex_release.getForceUseOriginNetwork(), true)) {
                    return null;
                }
                sccDelegate = annieXWebKit.sccDelegate;
                if (sccDelegate != null && (shouldInterceptRequest = sccDelegate.shouldInterceptRequest(url)) != null) {
                    return shouldInterceptRequest;
                }
                z = annieXWebKit.allowAdBlock;
                if (z) {
                    return annieXWebKit.onAdFilter();
                }
                return super.shouldInterceptRequest(view, url);
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
            
                r2 = r8.this$0.argusAdapter;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private final WebResourceResponse shouldSecureDelegate(WebView view, WebResourceRequest request, boolean useForest) {
                ArgusWebDelegateAdapter argusWebDelegateAdapter;
                ArgusWebResourceRequestRewritePayload verifyShouldInterceptRequest$anniex_release;
                SccDelegate sccDelegate;
                boolean z;
                WebResourceResponse shouldInterceptRequest;
                Uri url;
                String uri = (request == null || (url = request.getUrl()) == null) ? null : url.toString();
                if (uri != null && argusWebDelegateAdapter != null && (verifyShouldInterceptRequest$anniex_release = argusWebDelegateAdapter.verifyShouldInterceptRequest$anniex_release(view, uri, request, useForest, false)) != null) {
                    AnnieXWebKit annieXWebKit = AnnieXWebKit.this;
                    WebResourceResponse response = verifyShouldInterceptRequest$anniex_release.getResponse();
                    if (response != null) {
                        return response;
                    }
                    if (Intrinsics.areEqual(verifyShouldInterceptRequest$anniex_release.getForceUseOriginNetwork(), true)) {
                        sccDelegate = annieXWebKit.sccDelegate;
                        if (sccDelegate != null && (shouldInterceptRequest = sccDelegate.shouldInterceptRequest(uri)) != null) {
                            return shouldInterceptRequest;
                        }
                        z = annieXWebKit.allowAdBlock;
                        if (z) {
                            return annieXWebKit.onAdFilter(request);
                        }
                        return super.shouldInterceptRequest(view, request);
                    }
                }
                return null;
            }
        });
        this.annieXWebController.getWebViewDelegate().getWebViewClientDispatcher().addWebViewClient(new MonitorWebViewClient());
    }

    private final void setWebChromeClientDelegate() {
        this.annieXWebController.getWebViewDelegate().getWebChromeClientDispatcher().addWebChromeClient(0, new BulletWebChromeClient() { // from class: com.bytedance.android.anniex.web.AnnieXWebKit$setWebChromeClientDelegate$webChromeClient$1
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            public Bitmap getDefaultVideoPoster() {
                AnnieXWebModel annieXWebModel;
                BooleanParam hideSystemVideoPoster;
                SchemaModelUnion schemaModelUnion;
                annieXWebModel = AnnieXWebKit.this.webViewModel;
                ISchemaModel kitModel = (annieXWebModel == null || (schemaModelUnion = annieXWebModel.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getKitModel();
                BDXWebKitModel bDXWebKitModel = kitModel instanceof BDXWebKitModel ? (BDXWebKitModel) kitModel : null;
                if ((bDXWebKitModel == null || (hideSystemVideoPoster = bDXWebKitModel.getHideSystemVideoPoster()) == null) ? false : Intrinsics.areEqual(hideSystemVideoPoster.getValue(), true)) {
                    return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                }
                return super.getDefaultVideoPoster();
            }

            public void onReceivedTitle(WebView view, String title) {
                AnnieXWebModel annieXWebModel;
                INavBarHost iNavBarHost;
                BooleanParam useWebviewTitle;
                SchemaModelUnion schemaModelUnion;
                if (title != null) {
                    AnnieXWebKit annieXWebKit = AnnieXWebKit.this;
                    annieXWebModel = annieXWebKit.webViewModel;
                    ISchemaModel kitModel = (annieXWebModel == null || (schemaModelUnion = annieXWebModel.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getKitModel();
                    BDXWebKitModel bDXWebKitModel = kitModel instanceof BDXWebKitModel ? (BDXWebKitModel) kitModel : null;
                    if ((bDXWebKitModel == null || (useWebviewTitle = bDXWebKitModel.getUseWebviewTitle()) == null) ? false : Intrinsics.areEqual(useWebviewTitle.getValue(), true)) {
                        ContextProviderFactory contextProviderFactory = annieXWebKit.getContextProviderFactory();
                        ContextProviderFactory contextProviderFactory2 = contextProviderFactory instanceof ContextProviderFactory ? contextProviderFactory : null;
                        if (contextProviderFactory2 != null && (iNavBarHost = (INavBarHost) contextProviderFactory2.provideInstance(INavBarHost.class)) != null) {
                            iNavBarHost.setTitle(title);
                        }
                    }
                }
                super.onReceivedTitle(view, title);
            }
        });
        this.annieXWebController.getWebViewDelegate().getWebChromeClientDispatcher().addWebChromeClient(new MonitorChromeClient());
    }

    public final SccConfig.SccLevel getSccLevel() {
        return this.sccLevel;
    }

    public final void reloadCurrentUrl() {
        SccDelegate sccDelegate;
        SSWebView sSWebView = this.realView;
        if (sSWebView != null) {
            String url = sSWebView.getUrl();
            if (url != null && (sccDelegate = this.sccDelegate) != null) {
                sccDelegate.onUserAllow(url);
            }
            sSWebView.reload();
        }
    }

    public final void reload() {
        Uri uri = this.currentUri;
        if (uri != null) {
            ContextProviderFactory contextProviderFactory = this.contextProviderFactory;
            Intrinsics.checkNotNull(contextProviderFactory, "null cannot be cast to non-null type com.bytedance.ies.bullet.core.model.context.ContextProviderFactory");
            loadInner(uri, true, null, contextProviderFactory);
        }
    }

    public final Uri getCurrentUri() {
        return this.currentUri;
    }

    public final void sendEvent(String eventName, Object params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (BulletEnv.Companion.getInstance().getDebuggable()) {
            try {
                Result.Companion companion = Result.Companion;
                BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getSessionId(), "send event: " + eventName + " with " + new Gson().toJson(params), "XWebKit", (LogLevel) null, 8, (Object) null);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        } else {
            BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getSessionId(), "send event.", "XWebKit", (LogLevel) null, 8, (Object) null);
        }
        Object jSONObject = new JSONObject();
        if (params != null) {
            if (!(params instanceof JSONObject)) {
                params = jSONObject;
            }
            jSONObject = params;
        }
        WebBDXBridge webBDXBridge = this.webBdxBridge;
        if (webBDXBridge != null) {
            webBDXBridge.sendJSEventToWeb(eventName, (JSONObject) jSONObject);
        }
    }

    public final void onShow() {
        Uri originalUri;
        if (isCachedView() && this.reUsePageViewed.compareAndSet(false, true)) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "send pageReused event for reused view", (LogLevel) null, "XWebKit", 2, (Object) null);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            AnnieXWebModel annieXWebModel = this.webViewModel;
            if (annieXWebModel != null && (originalUri = annieXWebModel.getOriginalUri()) != null) {
                Set<String> queryParameterNames = originalUri.getQueryParameterNames();
                Intrinsics.checkNotNullExpressionValue(queryParameterNames, "uri.queryParameterNames");
                for (String str : queryParameterNames) {
                    jSONObject2.put(str, originalUri.getQueryParameter(str));
                }
            }
            Unit unit = Unit.INSTANCE;
            jSONObject.put("queryItems", jSONObject2);
            Unit unit2 = Unit.INSTANCE;
            sendEvent(EVENT_VIEW_REUSED, jSONObject);
        }
        SSWebView sSWebView = this.realView;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("isViewFirstAppeared", this.isViewFirstAppeared);
        Unit unit3 = Unit.INSTANCE;
        jSONObject3.put(Constants.KEY_DATA, jSONObject4);
        Unit unit4 = Unit.INSTANCE;
        sendEvent("viewAppeared", jSONObject3);
        this.isViewFirstAppeared = false;
        KitViewLifecycleDelegateWrapper kitViewLifecycleDelegateWrapper = this.kitViewLifecycleDelegateWrapper;
        if (kitViewLifecycleDelegateWrapper != null) {
            kitViewLifecycleDelegateWrapper.onOpen$anniex_release();
        }
        KitViewLifecycleDelegateWrapper kitViewLifecycleDelegateWrapper2 = this.kitViewLifecycleDelegateWrapper;
        if (kitViewLifecycleDelegateWrapper2 != null) {
            Uri uri = this.currentUri;
            WebKitService webKitService = this.kitService;
            kitViewLifecycleDelegateWrapper2.onEnterForeground$anniex_release(uri, webKitService instanceof IKitViewService ? (IKitViewService) webKitService : null);
        }
    }

    private final void setLongClickable(WebView webView) {
        SchemaModelUnion schemaModelUnion;
        AnnieXWebModel annieXWebModel = this.webViewModel;
        ISchemaModel kitModel = (annieXWebModel == null || (schemaModelUnion = annieXWebModel.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getKitModel();
        BDXWebKitModel bDXWebKitModel = kitModel instanceof BDXWebKitModel ? (BDXWebKitModel) kitModel : null;
        if (bDXWebKitModel != null) {
            Boolean bool = (Boolean) bDXWebKitModel.getDisableSaveImage().getValue();
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            webView.setLongClickable(!booleanValue);
            if (booleanValue) {
                webView.setOnLongClickListener(null);
            }
        }
    }

    private final void setWebParams(WebView webView) {
        StringParam webBgColor;
        SchemaModelUnion schemaModelUnion;
        AnnieXWebModel annieXWebModel = this.webViewModel;
        String str = null;
        ISchemaModel kitModel = (annieXWebModel == null || (schemaModelUnion = annieXWebModel.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getKitModel();
        BDXWebKitModel bDXWebKitModel = kitModel instanceof BDXWebKitModel ? (BDXWebKitModel) kitModel : null;
        if (bDXWebKitModel != null && (webBgColor = bDXWebKitModel.getWebBgColor()) != null) {
            str = (String) webBgColor.getValue();
        }
        if (str == null) {
            webView.setBackgroundColor(0);
        }
    }

    public final void onHide() {
        SSWebView sSWebView = this.realView;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        sendEvent("viewDisappeared", null);
        WebBDXBridge webBDXBridge = this.webBdxBridge;
        RuntimeConfig runtimeConfig = webBDXBridge != null ? webBDXBridge.getRuntimeConfig() : null;
        if (runtimeConfig != null) {
            runtimeConfig.setAllowUseCache(false);
        }
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, getSessionId(), "kitView status:on hide", "XWebKit", (LogLevel) null, 8, (Object) null);
        KitViewLifecycleDelegateWrapper kitViewLifecycleDelegateWrapper = this.kitViewLifecycleDelegateWrapper;
        if (kitViewLifecycleDelegateWrapper != null) {
            kitViewLifecycleDelegateWrapper.onClose$anniex_release();
        }
        KitViewLifecycleDelegateWrapper kitViewLifecycleDelegateWrapper2 = this.kitViewLifecycleDelegateWrapper;
        if (kitViewLifecycleDelegateWrapper2 != null) {
            Uri uri = this.currentUri;
            WebKitService webKitService = this.kitService;
            kitViewLifecycleDelegateWrapper2.onEnterBackground$anniex_release(uri, webKitService instanceof IKitViewService ? (IKitViewService) webKitService : null);
        }
    }

    public final boolean onBackPressed() {
        if (this.sccLevel != SccConfig.SccLevel.SAFE) {
            return false;
        }
        SSWebView sSWebView = this.realView;
        if (!(sSWebView != null && sSWebView.canGoBack())) {
            return false;
        }
        SSWebView sSWebView2 = this.realView;
        if (sSWebView2 != null) {
            sSWebView2.goBack();
        }
        return true;
    }

    public final void destroy() {
        AnnieXWebModel annieXWebModel = this.webViewModel;
        if (annieXWebModel != null) {
            annieXWebModel.getBulletContext().release();
            MonitorManager.reportInfo$default(MonitorManager.INSTANCE, annieXWebModel.getSessionId(), true, null, KitType.WEB, false, 20, null);
            MonitorManager.INSTANCE.removeMonitorInfo(annieXWebModel.getSessionId());
            ForestLoader.INSTANCE.release(annieXWebModel.getSessionId());
        }
        SSWebView sSWebView = this.realView;
        if (sSWebView != null) {
            sSWebView.setWebChromeClient((WebChromeClient) null);
            sSWebView.setWebViewClient(new WebViewClient());
            try {
                sSWebView.destroy();
            } catch (Throwable unused) {
            }
        }
        clearContextProvider(this.bid, this.contextProviderFactory);
        this.annieXWebController.release();
        WebBDXBridge webBDXBridge = this.webBdxBridge;
        if (webBDXBridge != null) {
            webBDXBridge.release();
        }
        WebViewMonitorHelper.getInstance().removeConfig(new String[]{SSWebView.class.getName()});
        this.contextProviderFactory.removeAll();
        this.argusAdapter = null;
    }

    private final void setAdBlock() {
        Uri originalUri;
        BulletSettings provideBulletSettings;
        BooleanParam adBlock;
        SchemaModelUnion schemaModelUnion;
        if (this.kitService.isTTWeb()) {
            AnnieXWebModel annieXWebModel = this.webViewModel;
            ISchemaModel kitModel = (annieXWebModel == null || (schemaModelUnion = annieXWebModel.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getKitModel();
            BDXWebKitModel bDXWebKitModel = kitModel instanceof BDXWebKitModel ? (BDXWebKitModel) kitModel : null;
            if ((bDXWebKitModel == null || (adBlock = bDXWebKitModel.getAdBlock()) == null) ? false : Intrinsics.areEqual(adBlock.getValue(), true)) {
                this.allowAdBlock = true;
                return;
            }
            ISettingService service = this.kitService.getService(ISettingService.class);
            List<String> webViewAdBlockList = (service == null || (provideBulletSettings = service.provideBulletSettings()) == null) ? null : provideBulletSettings.getWebViewAdBlockList();
            if (webViewAdBlockList != null) {
                for (String str : webViewAdBlockList) {
                    AnnieXWebModel annieXWebModel2 = this.webViewModel;
                    if (Intrinsics.areEqual((annieXWebModel2 == null || (originalUri = annieXWebModel2.getOriginalUri()) == null) ? null : originalUri.getHost(), str)) {
                        this.allowAdBlock = true;
                    }
                }
            }
        }
    }

    private final void setSccDelegate(SSWebView webView) {
        SccConfig sccConfig;
        JsonObject jsonObject$anniex_release;
        INetworkDepend iNetworkDepend;
        if (this.kitService.isTTWeb() || (sccConfig = this.sccConfig) == null || (jsonObject$anniex_release = sccConfig.toJsonObject$anniex_release()) == null || (iNetworkDepend = this.networkDepend) == null) {
            return;
        }
        SccDelegate sccDelegate = new SccDelegate(jsonObject$anniex_release, iNetworkDepend);
        this.sccDelegate = sccDelegate;
        webView.setSccDelegate$anniex_release(sccDelegate);
    }

    public final WebResourceResponse onAdFilter() {
        WebResourceResponse webResourceResponse = new WebResourceResponse("text/plain", UrlUtils.UTF_8, new ByteArrayInputStream(new byte[0]));
        HashMap hashMap = new HashMap();
        hashMap.put("ttweb_adblock", "");
        webResourceResponse.setResponseHeaders(hashMap);
        return webResourceResponse;
    }

    public final WebResourceResponse onAdFilter(WebResourceRequest request) {
        Map<String, String> requestHeaders = request != null ? request.getRequestHeaders() : null;
        if (requestHeaders == null || !requestHeaders.containsKey("ttweb_adblock") || !Intrinsics.areEqual(requestHeaders.get("ttweb_adblock"), "true")) {
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse("text/plain", UrlUtils.UTF_8, new ByteArrayInputStream(new byte[0]));
        HashMap hashMap = new HashMap();
        hashMap.put("ttweb_adblock", "");
        webResourceResponse.setResponseHeaders(hashMap);
        return webResourceResponse;
    }

    private final IAnnieXContextProvider getContextProvider(String bid) {
        if (AnnieXSettings.INSTANCE.getOptimizeBulletInit()) {
            return (IAnnieXContextProvider) AnnieXServiceCenter.INSTANCE.getService(bid, IAnnieXContextProvider.class);
        }
        IAnnieXContextProvider iAnnieXContextProvider = (IAnnieXContextProvider) AnnieX.INSTANCE.getService(bid, IAnnieXContextProvider.class);
        return iAnnieXContextProvider == null ? (IAnnieXContextProvider) ServiceCenter.Companion.instance().get(bid, IAnnieXContextProvider.class) : iAnnieXContextProvider;
    }

    private final void clearContextProvider(String bid, ContextProviderFactory contextProviderFactory) {
        IAnnieXContextProvider iAnnieXContextProvider;
        IAnnieXContextProvider iAnnieXContextProvider2 = (IAnnieXContextProvider) AnnieX.INSTANCE.getService(bid, IAnnieXContextProvider.class);
        if (iAnnieXContextProvider2 != null) {
            iAnnieXContextProvider2.clearContextProvider(bid, contextProviderFactory);
        }
        if (AnnieXSettings.INSTANCE.getOptimizeBulletInit() || (iAnnieXContextProvider = (IAnnieXContextProvider) ServiceCenter.Companion.instance().get(bid, IAnnieXContextProvider.class)) == null) {
            return;
        }
        iAnnieXContextProvider.clearContextProvider(bid, contextProviderFactory);
    }
}
