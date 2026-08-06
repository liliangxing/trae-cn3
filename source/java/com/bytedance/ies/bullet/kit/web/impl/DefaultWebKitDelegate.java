package com.bytedance.ies.bullet.kit.web.impl;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import bolts.Task;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.base.constants.GlobalPropertiesConstants;
import com.bytedance.ies.bullet.base.settings.JSBAuthStrategySetting;
import com.bytedance.ies.bullet.base.settings.SecuritySettingConfig;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.HybridLoggerConst;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextKt;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.BulletWebContext;
import com.bytedance.ies.bullet.core.IBulletLoadLifeCycle;
import com.bytedance.ies.bullet.core.IEngineGlobalConfig;
import com.bytedance.ies.bullet.core.device.PropsUtilsKt;
import com.bytedance.ies.bullet.core.kit.bridge.BridgeMethodKt;
import com.bytedance.ies.bullet.core.kit.bridge.BridgePerfData;
import com.bytedance.ies.bullet.core.kit.bridge.Callback;
import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry;
import com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod;
import com.bytedance.ies.bullet.core.kit.service.BaseBridgeService;
import com.bytedance.ies.bullet.core.kit.service.IBridgeService;
import com.bytedance.ies.bullet.core.kit.setting.IPropertySetter;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.deprecate.fake.ForestSessionId;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.ForestWebInfoHelper;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderUtils;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.kit.web.CustomWebSettings;
import com.bytedance.ies.bullet.kit.web.IJavascriptInterfaceDelegate;
import com.bytedance.ies.bullet.kit.web.IWebSecureDelegate;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.kit.web.WebEngineGlobalConfig;
import com.bytedance.ies.bullet.kit.web.WebKitView;
import com.bytedance.ies.bullet.kit.web.WebKitViewInitParams;
import com.bytedance.ies.bullet.kit.web.download.WebResourceDownloader;
import com.bytedance.ies.bullet.kit.web.export.BulletWebChromeClient;
import com.bytedance.ies.bullet.kit.web.export.BulletWebViewClient;
import com.bytedance.ies.bullet.kit.web.impl.util.WebViewUtils;
import com.bytedance.ies.bullet.kit.web.jsbridge.CancelWebContentMethod;
import com.bytedance.ies.bullet.kit.web.jsbridge.DownloadWebContentMethod;
import com.bytedance.ies.bullet.kit.web.jsbridge.IShouldBlockJsbCallListener;
import com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig;
import com.bytedance.ies.bullet.kit.web.jsbridge.WebJsBridge;
import com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService;
import com.bytedance.ies.bullet.p003ui.common.IBulletViewProvider;
import com.bytedance.ies.bullet.p003ui.common.container.IFullScreenController;
import com.bytedance.ies.bullet.p003ui.common.utils.BaseStatusBarUtil;
import com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapter;
import com.bytedance.ies.bullet.secure.HybridSecureConfig;
import com.bytedance.ies.bullet.secure.HybridSecureUtil;
import com.bytedance.ies.bullet.secure.SecureProviderFactory;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletPageUrl;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IEventHandler;
import com.bytedance.ies.bullet.service.base.IGlobalPropsInjectService;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.IPrefetchService;
import com.bytedance.ies.bullet.service.base.IPrefetchV2Service;
import com.bytedance.ies.bullet.service.base.IPrefetchV2ServiceKt;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.PrefetchV2Data;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.api.IServiceCenter;
import com.bytedance.ies.bullet.service.base.api.IServiceContext;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.bridge.IBulletBridgeProviderService;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.resourceloader.config.CustomLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.MonitorSettingsConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.web.IGlobalPropsHandler;
import com.bytedance.ies.bullet.service.base.web.IWebResourceRequest;
import com.bytedance.ies.bullet.service.base.web.IWebViewDelegate;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDelegate;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDispatcher;
import com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate;
import com.bytedance.ies.bullet.service.base.web.WebViewClientDispatcher;
import com.bytedance.ies.bullet.service.base.web.WebViewDelegateConfig;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelTransformer;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.schema.model.BDXPageModel;
import com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate;
import com.bytedance.ies.bullet.service.webkit.WebKitService;
import com.bytedance.ies.bullet.web.pia.PiaHelper;
import com.bytedance.ies.bullet.web.pia.PiaLifeCycle;
import com.bytedance.ies.web.jsbridge.IESJsBridge;
import com.bytedance.ies.web.jsbridge.ISupportJavaMethod;
import com.bytedance.ies.web.jsbridge.JsMsg;
import com.bytedance.ies.web.jsbridge2.IMethodInvocationListener;
import com.bytedance.ies.web.jsbridge2.JsBridge2IESSupport;
import com.bytedance.ies.xbridge.BridgeDataConverterHolder;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.notification.Constants;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.sdk.xbridge.cn.auth.WebAuthVerifierWrapper;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthErrorCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthResult;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthSuccessCode;
import com.bytedance.sdk.xbridge.cn.auth.depend.AuthReportInfo;
import com.bytedance.sdk.xbridge.cn.auth.depend.ILogDepend;
import com.bytedance.sdk.xbridge.cn.auth.depend.IReportDepend;
import com.bytedance.sdk.xbridge.cn.auth.repository.AuthStrategyRepository;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.optimize.ThreadOptConfig;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBDXBridge;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeCall;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol;
import com.bytedance.sdk.xbridge.cn.platform.web.protocol.IESJSBridgeSupport;
import com.bytedance.sdk.xbridge.cn.platform.web.protocol.JSB2Impl;
import com.bytedance.sdk.xbridge.cn.platform.web.protocol.JSB3Impl;
import com.bytedance.sdk.xbridge.cn.platform.web.protocol.JSB4Impl;
import com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthPriority;
import com.bytedance.sdk.xbridge.cn.protocol.auth.Authenticator;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.service.IAnnieProSupport;
import com.bytedance.trae.network.FrontierIdGenerator;
import com.bytedance.webx.monitor.jsb2.MonitorJSBListener;
import com.bytedance.webx.precreate.util.PreCreateUtil;
import com.google.gson.Gson;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DefaultWebKitDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0002\r\u0019\b\u0016\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u0002:\u0002\u0095\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\b\u0010D\u001a\u00020\"H\u0016J\b\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020M2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J0\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020M2\b\u0010Q\u001a\u0004\u0018\u00010\u00062\u0014\u0010R\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010SH\u0016J\u0010\u0010T\u001a\u00020O2\u0006\u0010U\u001a\u00020VH\u0002J\u0010\u0010W\u001a\u00020O2\u0006\u0010U\u001a\u00020VH\u0002J\b\u0010X\u001a\u00020\u0013H\u0016J\b\u0010Y\u001a\u00020\u0006H\u0002J\u001c\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010[\u001a\u00020\\H\u0002J\b\u0010]\u001a\u00020\u0006H\u0002J&\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010[\u001a\u00020\\2\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J&\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010[\u001a\u00020\\2\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J(\u0010b\u001a\u00020O2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u00062\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0010\u0010e\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u0006H\u0016J\u0012\u0010f\u001a\u00020\"2\b\u0010Q\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010g\u001a\u0004\u0018\u00010h2\u0006\u0010i\u001a\u00020jH\u0016J\u0012\u0010k\u001a\u0004\u0018\u00010h2\u0006\u0010i\u001a\u00020jH\u0017J\u0012\u0010k\u001a\u0004\u0018\u00010h2\u0006\u0010Q\u001a\u00020\u0006H\u0017J\b\u0010l\u001a\u00020OH\u0016J\u0018\u0010m\u001a\u00020O2\u0006\u0010Q\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010n\u001a\u00020OH\u0016J\b\u0010o\u001a\u00020OH\u0016J\u0018\u0010p\u001a\u00020O2\u0006\u0010q\u001a\u00020\u00062\u0006\u0010r\u001a\u00020sH\u0002J\u0018\u0010t\u001a\u00020O2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020xH\u0016J\u0018\u0010y\u001a\u00020z2\u0006\u0010Q\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010{\u001a\u0004\u0018\u00010|H\u0016J\u0010\u0010}\u001a\u00020~2\u0006\u0010P\u001a\u00020MH\u0002J\t\u0010\u007f\u001a\u00030\u0080\u0001H\u0016J\u001c\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0006\u0010_\u001a\u00020`2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J3\u0010\u0085\u0001\u001a\u0004\u0018\u00010h2\u0006\u0010Q\u001a\u00020\u00062\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0088\u0001\u001a\u00020\"2\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010jH\u0003J\u0013\u0010\u008a\u0001\u001a\u00020O2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016J\u0011\u0010\u008d\u0001\u001a\u00020O2\u0006\u0010P\u001a\u00020MH\u0002J\u0019\u0010\u008e\u0001\u001a\u00020O2\u0006\u0010[\u001a\u00020\\2\u0006\u0010u\u001a\u00020vH\u0016J(\u0010\u008e\u0001\u001a\u00020O2\b\u0010u\u001a\u0004\u0018\u00010v2\u0013\u0010\u008f\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0SH\u0016J\r\u0010\u0090\u0001\u001a\u00020O*\u00020MH\u0002J\r\u0010\u0091\u0001\u001a\u00020O*\u00020MH\u0002J\r\u0010\u0092\u0001\u001a\u00020O*\u00020KH\u0003J\u0015\u0010\u0093\u0001\u001a\u00020O*\u00020M2\u0006\u0010w\u001a\u00020xH\u0002J\r\u0010\u0094\u0001\u001a\u00020O*\u00020KH\u0002R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020-X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010@\u001a\u0004\u0018\u00010A8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006\u0096\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/impl/DefaultWebKitDelegate;", "Lcom/bytedance/ies/bullet/service/webkit/AbsWebKitDelegate;", "Lcom/bytedance/ies/bullet/forest/ForestWebInfoHelper;", "kitService", "Lcom/bytedance/ies/bullet/service/webkit/WebKitService;", "sessionId", "", "(Lcom/bytedance/ies/bullet/service/webkit/WebKitService;Ljava/lang/String;)V", "(Lcom/bytedance/ies/bullet/service/webkit/WebKitService;)V", "aliasGlobalProps", "", "", "annieProSupport", "com/bytedance/ies/bullet/kit/web/impl/DefaultWebKitDelegate$annieProSupport$1", "Lcom/bytedance/ies/bullet/kit/web/impl/DefaultWebKitDelegate$annieProSupport$1;", "annieXContainerSessionId", "argusAdapter", "Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter;", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getBulletContext", "()Lcom/bytedance/ies/bullet/core/BulletContext;", "setBulletContext", "(Lcom/bytedance/ies/bullet/core/BulletContext;)V", "eventHandler", "com/bytedance/ies/bullet/kit/web/impl/DefaultWebKitDelegate$eventHandler$1", "Lcom/bytedance/ies/bullet/kit/web/impl/DefaultWebKitDelegate$eventHandler$1;", "iFullScreenController", "Lcom/bytedance/ies/bullet/ui/common/container/IFullScreenController;", "getIFullScreenController", "()Lcom/bytedance/ies/bullet/ui/common/container/IFullScreenController;", "setIFullScreenController", "(Lcom/bytedance/ies/bullet/ui/common/container/IFullScreenController;)V", GlobalPropertiesConstants.IS_COLD_START, "", "isFirstScreen", "javascriptInterfaceDelegates", "", "Lcom/bytedance/ies/bullet/kit/web/IJavascriptInterfaceDelegate;", "mUrl", "mWebJsBridge", "Lcom/bytedance/ies/bullet/kit/web/jsbridge/WebJsBridge;", "piaLifeCycle", "Lcom/bytedance/ies/bullet/web/pia/PiaLifeCycle;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "setProviderFactory", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;)V", "uiModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "getUiModel", "()Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "useXBridge3", "userAgent", "webBDXBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBDXBridge;", "webViewDelegate", "Lcom/bytedance/ies/bullet/service/base/web/IWebViewDelegate;", "getWebViewDelegate", "()Lcom/bytedance/ies/bullet/service/base/web/IWebViewDelegate;", "setWebViewDelegate", "(Lcom/bytedance/ies/bullet/service/base/web/IWebViewDelegate;)V", "webkitModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXWebKitModel;", "getWebkitModel", "()Lcom/bytedance/ies/bullet/service/schema/model/BDXWebKitModel;", "bulletContextIsInitialized", "createBusinessChromeClient", "Lcom/bytedance/ies/bullet/kit/web/export/BulletWebChromeClient;", "createBusinessClient", "Lcom/bytedance/ies/bullet/kit/web/export/BulletWebViewClient;", "createWebJsBridge", "webview", "Landroid/webkit/WebView;", "createWebView", "Lcom/bytedance/ies/bullet/kit/web/SSWebView;", "delegateLoadUrl", "", "webView", "url", "additionalHttpHeaders", "", "generateSchemaModel", "data", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "generateSchemaModelOpt", "getContext", "getForestSessionId", "getGlobalProps", "uri", "Landroid/net/Uri;", "getNamespace", "getStorageGlobalProps", "context", "Landroid/content/Context;", "getUserDomainStorageGlobalProps", "globalPropsAdapterWithBid", "bid", "constants", "injectUrl", "isDelegateLoadUrl", "loadPiaResource", "Landroid/webkit/WebResourceResponse;", "request", "Landroid/webkit/WebResourceRequest;", "loadResource", "onLoadFail", "onLoadStart", "onLoadSuccess", "onPageStarted", "onPerfDataReady", "methodName", "perfData", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;", "onWebViewCreate", "view", "Landroid/view/View;", "kitView", "Lcom/bytedance/ies/bullet/kit/web/WebKitView;", "parseSchema", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "provideEventHandler", "Lcom/bytedance/ies/bullet/service/base/IEventHandler;", "provideMonitorJSBListener", "Lcom/bytedance/webx/monitor/jsb2/MonitorJSBListener;", "provideWebKitInitParams", "Lcom/bytedance/ies/bullet/kit/web/WebKitViewInitParams;", "px2dip", "", "pxValue", "", "realLoadResource", ReportConst.KEY_SCENE, "Lcom/bytedance/forest/model/Scene;", "useForest", "webRequest", "release", "kitViewService", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "setupPia", "updateGlobalProps", "globalProps", "createXBridge3", "setJsBridge", "setOtherDelegates", "setWebSecureDelegate", "setWebSettings", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DefaultWebKitDelegate extends AbsWebKitDelegate implements ForestWebInfoHelper {
    public static final String TAG = "DefaultWebKitDelegate";
    private Map<String, Object> aliasGlobalProps;
    private final DefaultWebKitDelegate$annieProSupport$1 annieProSupport;
    private String annieXContainerSessionId;
    private ArgusWebDelegateAdapter argusAdapter;
    public BulletContext bulletContext;
    private final DefaultWebKitDelegate$eventHandler$1 eventHandler;
    private IFullScreenController iFullScreenController;
    private boolean isColdStart;
    private boolean isFirstScreen;
    private final List<IJavascriptInterfaceDelegate> javascriptInterfaceDelegates;
    private final WebKitService kitService;
    private String mUrl;
    private WebJsBridge mWebJsBridge;
    private PiaLifeCycle piaLifeCycle;
    public ContextProviderFactory providerFactory;
    private boolean useXBridge3;
    private String userAgent;
    private WebBDXBridge webBDXBridge;
    private IWebViewDelegate webViewDelegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile boolean globalColdStart = true;

    /* compiled from: DefaultWebKitDelegate.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResourceType.values().length];
            try {
                iArr[ResourceType.DISK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResourceType.ASSET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public void delegateLoadUrl(SSWebView webView, String url, Map<String, String> additionalHttpHeaders) {
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public boolean isDelegateLoadUrl(String url) {
        return false;
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public void onLoadSuccess() {
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public void onPageStarted() {
    }

    /* compiled from: DefaultWebKitDelegate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/impl/DefaultWebKitDelegate$Companion;", "", "()V", "TAG", "", "globalColdStart", "", "getGlobalColdStart", "()Z", "setGlobalColdStart", "(Z)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getGlobalColdStart() {
            return DefaultWebKitDelegate.globalColdStart;
        }

        public final void setGlobalColdStart(boolean z) {
            DefaultWebKitDelegate.globalColdStart = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$eventHandler$1] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$annieProSupport$1] */
    public DefaultWebKitDelegate(WebKitService webKitService) {
        super(webKitService);
        Intrinsics.checkNotNullParameter(webKitService, "kitService");
        this.kitService = webKitService;
        this.webViewDelegate = webKitService.createWebDelegate(new WebViewDelegateConfig());
        this.javascriptInterfaceDelegates = new ArrayList();
        this.eventHandler = new IEventHandler() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$eventHandler$1
            @Override // com.bytedance.ies.bullet.service.base.IEventHandler
            public void sendEvent(String eventName, Object params, View view) {
                boolean z;
                WebJsBridge webJsBridge;
                WebBDXBridge webBDXBridge;
                Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
                Object jSONObject = new JSONObject();
                if (params != null) {
                    if (!(params instanceof JSONObject)) {
                        params = jSONObject;
                    }
                    jSONObject = params;
                }
                z = DefaultWebKitDelegate.this.useXBridge3;
                if (z) {
                    webBDXBridge = DefaultWebKitDelegate.this.webBDXBridge;
                    if (webBDXBridge != null) {
                        webBDXBridge.sendJSEventToWeb(eventName, (JSONObject) jSONObject);
                        return;
                    }
                    return;
                }
                webJsBridge = DefaultWebKitDelegate.this.mWebJsBridge;
                if (webJsBridge != null) {
                    webJsBridge.sendJsEvent(eventName, (JSONObject) jSONObject);
                }
            }
        };
        this.annieProSupport = new IAnnieProSupport() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$annieProSupport$1
            public String getAnnieAppID() {
                String value = new StringParam(DefaultWebKitDelegate.this.getBulletContext().getSchemaModelUnion().getSchemaData(), "app_id", "").getValue();
                return value == null ? "" : value;
            }
        };
    }

    @Override // com.bytedance.ies.bullet.forest.ForestWebInfoHelper
    public Pair<Boolean, Scene> canInterceptByForest(WebResourceRequest webResourceRequest, IServiceToken iServiceToken, BulletContext bulletContext, SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.canInterceptByForest(this, webResourceRequest, iServiceToken, bulletContext, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestWebInfoHelper
    public Pair<Boolean, Scene> canInterceptByForest(String str, boolean z, IServiceToken iServiceToken, BulletContext bulletContext, SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.canInterceptByForest(this, str, z, iServiceToken, bulletContext, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.delayPreload(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.delayPreload(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.delayPreload(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.forestDownloadEngine(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String getResTag(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestWebInfoHelper.DefaultImpls.getResTag(this, lynxResourceType);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public Scene getSceneType(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestWebInfoHelper.DefaultImpls.getSceneType(this, lynxResourceType);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public ProcessedResponse<TemplateBundle> getTemplateBundleResponse(Response response) {
        return ForestWebInfoHelper.DefaultImpls.getTemplateBundleResponse(this, response);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.hasGeckoModelInfo(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.hasGeckoModelInfo(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.hasGeckoModelInfo(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.preloadScope(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.preloadScope(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.preloadScope(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String sessionID(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.sessionID(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String sessionID(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.sessionID(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(Uri uri) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(BulletContext bulletContext) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(IServiceToken iServiceToken) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(SchemaModelUnion schemaModelUnion) {
        return ForestWebInfoHelper.DefaultImpls.useForest(this, schemaModelUnion);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultWebKitDelegate(WebKitService webKitService, String str) {
        this(webKitService);
        Object obj;
        Intrinsics.checkNotNullParameter(webKitService, "kitService");
        Intrinsics.checkNotNullParameter(str, "sessionId");
        this.annieXContainerSessionId = str;
        try {
            Result.Companion companion = Result.Companion;
            DefaultWebKitDelegate defaultWebKitDelegate = this;
            BulletContext context = BulletContextManager.INSTANCE.getInstance().getContext(str);
            Intrinsics.checkNotNull(context);
            setBulletContext(context);
            this.useXBridge3 = BulletContextKt.useXBride3(getBulletContext());
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "constructor failure:" + th2.getMessage(), null, null, 12, null);
        }
    }

    public final BulletContext getBulletContext() {
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null) {
            return bulletContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bulletContext");
        return null;
    }

    public final void setBulletContext(BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(bulletContext, "<set-?>");
        this.bulletContext = bulletContext;
    }

    public final ContextProviderFactory getProviderFactory() {
        ContextProviderFactory contextProviderFactory = this.providerFactory;
        if (contextProviderFactory != null) {
            return contextProviderFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("providerFactory");
        return null;
    }

    public final void setProviderFactory(ContextProviderFactory contextProviderFactory) {
        Intrinsics.checkNotNullParameter(contextProviderFactory, "<set-?>");
        this.providerFactory = contextProviderFactory;
    }

    public final IWebViewDelegate getWebViewDelegate() {
        return this.webViewDelegate;
    }

    public final void setWebViewDelegate(IWebViewDelegate iWebViewDelegate) {
        Intrinsics.checkNotNullParameter(iWebViewDelegate, "<set-?>");
        this.webViewDelegate = iWebViewDelegate;
    }

    public final IFullScreenController getIFullScreenController() {
        return this.iFullScreenController;
    }

    public final void setIFullScreenController(IFullScreenController iFullScreenController) {
        this.iFullScreenController = iFullScreenController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BDXPageModel getUiModel() {
        ISchemaModel uiModel = getBulletContext().getSchemaModelUnion().getUiModel();
        if (uiModel instanceof BDXPageModel) {
            return (BDXPageModel) uiModel;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BDXWebKitModel getWebkitModel() {
        ISchemaModel kitModel = getBulletContext().getSchemaModelUnion().getKitModel();
        if (kitModel instanceof BDXWebKitModel) {
            return (BDXWebKitModel) kitModel;
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public IEventHandler provideEventHandler() {
        return this.eventHandler;
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public SSWebView createWebView(String sessionId) {
        SSWebView createWebView;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        if (this.bulletContext == null) {
            BulletContext context = BulletContextManager.INSTANCE.getInstance().getContext(sessionId);
            Intrinsics.checkNotNull(context);
            setBulletContext(context);
        }
        IWebViewDelegate iWebViewDelegate = this.webViewDelegate;
        Context context2 = getBulletContext().getContext();
        Intrinsics.checkNotNull(context2);
        Object webView = IWebViewDelegate.DefaultImpls.createWebView$default(iWebViewDelegate, context2, null, 2, null).getWebView();
        if (webView instanceof SSWebView) {
            createWebView = (SSWebView) webView;
        } else {
            WebViewUtils webViewUtils = WebViewUtils.INSTANCE;
            Context context3 = getBulletContext().getContext();
            Intrinsics.checkNotNull(context3);
            createWebView = webViewUtils.createWebView(context3);
        }
        WebView webView2 = (WebView) createWebView;
        this.webViewDelegate.setWebView(webView2);
        getBulletContext().getContainerContext().setPreCreate(PreCreateUtil.isPreCreate(webView2));
        if (this.providerFactory == null) {
            setProviderFactory(ContextProviderManager.INSTANCE.getProviderFactory(getBulletContext().getSessionId()));
        }
        getProviderFactory().registerWeakHolder(WebView.class, this.webViewDelegate.getWebView());
        return createWebView;
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public WebKitViewInitParams provideWebKitInitParams() {
        JSBAuthStrategySetting jSBAuthStrategySetting;
        SecuritySettingConfig securitySettingConfig;
        WebChromeClientDispatcher webChromeClientDispatcher;
        WebViewClientDispatcher webViewClientDispatcher;
        WebKitViewInitParams webKitViewInitParams = new WebKitViewInitParams();
        HybridSecureConfig secureConfig = BulletContextKt.getSecureConfig(getBulletContext());
        if (secureConfig != null) {
            webKitViewInitParams.setNetworkDepend(secureConfig.getNetworkDepend());
            webKitViewInitParams.setSccConfig(secureConfig.getSccConfig());
        }
        webKitViewInitParams.setWebViewDelegate(this.webViewDelegate);
        if (getBulletContext().getWebContext().getWebGlobalConfig() instanceof WebEngineGlobalConfig) {
            IEngineGlobalConfig webGlobalConfig = getBulletContext().getWebContext().getWebGlobalConfig();
            WebEngineGlobalConfig webEngineGlobalConfig = webGlobalConfig instanceof WebEngineGlobalConfig ? (WebEngineGlobalConfig) webGlobalConfig : null;
            if (webEngineGlobalConfig != null) {
                for (WebViewClientDelegate webViewClientDelegate : webEngineGlobalConfig.getWebViewClientList()) {
                    IWebViewDelegate webViewDelegate = webKitViewInitParams.getWebViewDelegate();
                    if (webViewDelegate != null && (webViewClientDispatcher = webViewDelegate.getWebViewClientDispatcher()) != null) {
                        webViewClientDispatcher.addWebViewClient(webViewClientDelegate);
                    }
                }
                for (WebChromeClientDelegate webChromeClientDelegate : webEngineGlobalConfig.getWebChromeClientList()) {
                    IWebViewDelegate webViewDelegate2 = webKitViewInitParams.getWebViewDelegate();
                    if (webViewDelegate2 != null && (webChromeClientDispatcher = webViewDelegate2.getWebChromeClientDispatcher()) != null) {
                        webChromeClientDispatcher.addWebChromeClient(webChromeClientDelegate);
                    }
                }
                Iterator<T> it = webEngineGlobalConfig.getJsInterfaceList().iterator();
                while (it.hasNext()) {
                    this.javascriptInterfaceDelegates.add((IJavascriptInterfaceDelegate) it.next());
                }
                webKitViewInitParams.setUrlInterceptorDelegate(webEngineGlobalConfig.getWebViewLoadUrlInterface());
            }
        }
        ISchemaModel uiModel = getBulletContext().getSchemaModelUnion().getUiModel();
        webKitViewInitParams.setUiModel(uiModel instanceof BDXPageModel ? (BDXPageModel) uiModel : null);
        ISchemaModel kitModel = getBulletContext().getSchemaModelUnion().getKitModel();
        webKitViewInitParams.setWebkitModel(kitModel instanceof BDXWebKitModel ? (BDXWebKitModel) kitModel : null);
        CacheType cacheType = getBulletContext().getContainerContext().getCacheType();
        webKitViewInitParams.setCachedView((cacheType == null || cacheType == CacheType.NONE) ? false : true);
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (securitySettingConfig = (SecuritySettingConfig) iBulletSettingsService.obtainSettings(SecuritySettingConfig.class)) == null || (jSBAuthStrategySetting = securitySettingConfig.getJsbAuthStrategySettingConfig()) == null) {
            jSBAuthStrategySetting = new JSBAuthStrategySetting();
        }
        webKitViewInitParams.setEnableSafeWebJSBAuth(jSBAuthStrategySetting.getEnableSafeWebJSBAuth());
        return webKitViewInitParams;
    }

    private final void setOtherDelegates(WebView webView) {
        Iterator<T> it = this.javascriptInterfaceDelegates.iterator();
        while (it.hasNext()) {
            for (Map.Entry<String, Object> entry : ((IJavascriptInterfaceDelegate) it.next()).createJavascriptInterface().entrySet()) {
                webView.addJavascriptInterface(entry.getValue(), entry.getKey());
            }
        }
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public SchemaModelUnion parseSchema(String url, String sessionId) {
        BooleanParam enableVideoLandscape;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        ISchemaData schemaData = getBulletContext().getSchemaModelUnion().getSchemaData();
        if (IConditionCallKt.enableMixLogic()) {
            generateSchemaModelOpt(schemaData);
        } else {
            generateSchemaModel(schemaData);
        }
        BDXWebKitModel webkitModel = getWebkitModel();
        this.iFullScreenController = (webkitModel == null || (enableVideoLandscape = webkitModel.getEnableVideoLandscape()) == null) ? false : Intrinsics.areEqual(enableVideoLandscape.getValue(), true) ? (IFullScreenController) getProviderFactory().provideInstance(IFullScreenController.class) : null;
        return getBulletContext().getSchemaModelUnion();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public void onWebViewCreate(View view, WebKitView kitView) {
        WebJsBridge webJsBridge;
        BooleanParam disableWebviewSelectMenus;
        Boolean value;
        BooleanParam enableWebviewSelectSearch;
        Boolean value2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(kitView, "kitView");
        if (view instanceof SSWebView) {
            WebView webView = (WebView) view;
            setWebSettings(webView);
            SSWebView sSWebView = (SSWebView) view;
            setWebSecureDelegate(sSWebView, kitView);
            setupPia(sSWebView);
            getBulletContext().getMonitorCallback().onJsbRegisterBegin();
            if (this.useXBridge3) {
                IEngineGlobalConfig webGlobalConfig = getBulletContext().getWebContext().getWebGlobalConfig();
                if (webGlobalConfig != null) {
                    IEngineGlobalConfig.DefaultImpls.updateBridgeRegister$default(webGlobalConfig, false, KitType.WEB, 1, null);
                }
                createXBridge3(sSWebView);
            } else {
                setJsBridge(sSWebView);
                kitView.setMWebJsBridge(this.mWebJsBridge);
            }
            getBulletContext().getMonitorCallback().onJsbRegisterEnd();
            setOtherDelegates(webView);
            BDXWebKitModel webkitModel = getWebkitModel();
            sSWebView.showSearchMode((webkitModel == null || (enableWebviewSelectSearch = webkitModel.getEnableWebviewSelectSearch()) == null || (value2 = enableWebviewSelectSearch.getValue()) == null) ? false : value2.booleanValue(), getBulletContext().getWebContext().getActionModeProvider());
            sSWebView.attachSessionId(getBulletContext().getSessionId());
            sSWebView.enableNewCustomSelectMenu(IConditionCallKt.enableThirdPartyWebLogic(getBulletContext()));
            BDXWebKitModel webkitModel2 = getWebkitModel();
            sSWebView.disableShowSelectMenus((webkitModel2 == null || (disableWebviewSelectMenus = webkitModel2.getDisableWebviewSelectMenus()) == null || (value = disableWebviewSelectMenus.getValue()) == null) ? false : value.booleanValue());
            this.webViewDelegate.getWebViewClientDispatcher().addWebViewClient(0, createBusinessClient());
            this.webViewDelegate.getWebChromeClientDispatcher().addWebChromeClient(createBusinessChromeClient());
            this.webViewDelegate.mo589getGlobalPropsHandler().injectGlobalProps(webView);
            IEngineGlobalConfig webGlobalConfig2 = getBulletContext().getWebContext().getWebGlobalConfig();
            WebEngineGlobalConfig webEngineGlobalConfig = webGlobalConfig2 instanceof WebEngineGlobalConfig ? (WebEngineGlobalConfig) webGlobalConfig2 : null;
            if (webEngineGlobalConfig != null) {
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "DefaultWebKitDelegate disablePermissionCheck", null, "XWebKit", 2, null);
                if (webEngineGlobalConfig.disableAllPermissionCheck(this.mUrl) && (webJsBridge = this.mWebJsBridge) != null) {
                    webJsBridge.disablePermissionCheck();
                }
            }
            ArgusWebDelegateAdapter argusWebDelegateAdapter = this.argusAdapter;
            if (argusWebDelegateAdapter != null) {
                argusWebDelegateAdapter.verifyOnWebViewCreated(sSWebView);
            }
            this.userAgent = sSWebView.getSettings().getUserAgentString();
        }
    }

    private final String getNamespace() {
        return Intrinsics.areEqual(getBulletContext().getBid(), BidConstants.WEBCAST) ? BidConstants.WEBCAST : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void createXBridge3(SSWebView sSWebView) {
        WebBDXBridge webBDXBridge;
        IShouldBlockJsbCallListener shouldBlockJsbCallListener;
        IWebJsBridgeConfig provideWebJsBridgeConfig;
        IShouldBlockJsbCallListener shouldBlockJsbCallListener2;
        List<IDLXBridgeMethod> createStatefulBridges;
        WebBDXBridge webBDXBridge2;
        WebBDXBridge webBDXBridge3;
        BulletSettings provideBulletSettings;
        WebBDXBridge webBDXBridge4;
        BulletSettings provideBulletSettings2;
        if (getBulletContext().getContext() == null) {
            return;
        }
        Context context = getBulletContext().getContext();
        Intrinsics.checkNotNull(context);
        String sessionId = getBulletContext().getSessionId();
        WebView webView = (WebView) sSWebView;
        String namespace = getNamespace();
        ArgusWebDelegateAdapter argusWebDelegateAdapter = this.argusAdapter;
        this.webBDXBridge = new WebBDXBridge(context, sessionId, webView, namespace, argusWebDelegateAdapter != null ? argusWebDelegateAdapter.getInnerDelegate() : null);
        IPrefetchService iPrefetchService = (IPrefetchService) this.kitService.getService(IPrefetchService.class);
        if (iPrefetchService != null) {
            IPrefetchService.DefaultImpls.providePrefetchBridge$default(iPrefetchService, getProviderFactory(), null, 2, null);
        }
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        boolean useBDXbridge = (iSettingService == null || (provideBulletSettings2 = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings2.getUseBDXbridge();
        IBulletService iBulletService = ServiceCenter.INSTANCE.instance().get("default_bid", IBridgeService.class);
        BaseBridgeService baseBridgeService = iBulletService instanceof BaseBridgeService ? (BaseBridgeService) iBulletService : null;
        boolean useJsb3 = baseBridgeService != null ? baseBridgeService.useJsb3() : false;
        if (useBDXbridge) {
            WebBDXBridge webBDXBridge5 = this.webBDXBridge;
            if (webBDXBridge5 != null) {
                webBDXBridge5.setup(new WebBridgeProtocol[]{new IESJSBridgeSupport(getNamespace()), new JSB2Impl(getNamespace()), new JSB4Impl(getNamespace())});
            }
        } else if (useJsb3) {
            WebBDXBridge webBDXBridge6 = this.webBDXBridge;
            if (webBDXBridge6 != null) {
                webBDXBridge6.setup(new WebBridgeProtocol[]{new IESJSBridgeSupport(getNamespace()), new JSB2Impl(getNamespace()), new JSB3Impl(getNamespace())});
            }
        } else {
            WebBDXBridge webBDXBridge7 = this.webBDXBridge;
            if (webBDXBridge7 != null) {
                webBDXBridge7.setup(new WebBridgeProtocol[]{new IESJSBridgeSupport(getNamespace()), new JSB2Impl(getNamespace())});
            }
        }
        ISettingService iSettingService2 = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService2 != null && (provideBulletSettings = iSettingService2.provideBulletSettings()) != null && (webBDXBridge4 = this.webBDXBridge) != null) {
            webBDXBridge4.setThreadOpt(provideBulletSettings.getIsJSBThreadOptEnable(), provideBulletSettings.getJsbThreadOptConfig());
        }
        if (IConditionCallKt.enableAnnieXBridgeThreadOpt() && Intrinsics.areEqual(getBulletContext().getBid(), BidConstants.WEBCAST) && (webBDXBridge3 = this.webBDXBridge) != null) {
            ArrayList arrayList = new ArrayList();
            ThreadOptConfig threadOptConfig = new ThreadOptConfig((HashSet) null, (HashSet) null, (HashSet) null, (HashSet) null, (HashSet) null, 31, (DefaultConstructorMarker) null);
            threadOptConfig.setThreadOptSchemas(SetsKt.hashSetOf(new String[]{"bdx_thread_opt_all_schema"}));
            HashSet hashSet = new HashSet();
            hashSet.add("sendLogV3");
            hashSet.add("setStorage");
            threadOptConfig.setAsyncMethods(hashSet);
            arrayList.add(threadOptConfig);
            Unit unit = Unit.INSTANCE;
            webBDXBridge3.setThreadOpt(true, arrayList);
        }
        WebBDXBridge webBDXBridge8 = this.webBDXBridge;
        if (webBDXBridge8 != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(OptimizeConfigKt.getCAN_RUN_IN_BACKGROUND_FIX(), Boolean.valueOf(IConditionCallKt.enableBridgeCanRunInBackgroundFix()));
            linkedHashMap.put(OptimizeConfigKt.getXBRIDGE_MODEL_PROXY_ENHANCEMENT(), Boolean.valueOf(IConditionCallKt.enableXBridgeParamProxyEnhancement()));
            webBDXBridge8.addSettings(linkedHashMap);
        }
        IBridgeService iBridgeService = (IBridgeService) ServiceCenter.INSTANCE.instance().get("default_bid", IBridgeService.class);
        if (iBridgeService != null) {
            for (MethodFinder methodFinder : iBridgeService.createMethodFinder(getProviderFactory())) {
                WebBDXBridge webBDXBridge9 = this.webBDXBridge;
                if (webBDXBridge9 != null) {
                    webBDXBridge9.addCustomMethodFinder(methodFinder);
                }
            }
            if (iBridgeService instanceof BaseBridgeService) {
                MethodFinder createFirstFinder = ((BaseBridgeService) iBridgeService).createFirstFinder(getProviderFactory());
                if (createFirstFinder != null && (webBDXBridge2 = this.webBDXBridge) != null) {
                    webBDXBridge2.addCustomMethodFinder(createFirstFinder, 0);
                }
                ISchemaData schemaData = getBulletContext().getSchemaData();
                Uri innerOriginUrl = schemaData != null ? schemaData.getInnerOriginUrl() : null;
                if (Intrinsics.areEqual(innerOriginUrl != null ? innerOriginUrl.getQueryParameter(SchemaConstants.ENABLE_ANNIE_JSB_FOR_COMMON) : null, "1")) {
                    new WebcastContainerInitializer().initializeWithBulletContextInWeb(getBulletContext(), this.webViewDelegate.getWebView(), this.webBDXBridge, getProviderFactory(), this.eventHandler);
                }
            }
        }
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        String bid = getBulletContext().getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        IBridgeService iBridgeService2 = (IBridgeService) instance.get(bid, IBridgeService.class);
        BaseBridgeService baseBridgeService2 = iBridgeService2 instanceof BaseBridgeService ? (BaseBridgeService) iBridgeService2 : null;
        if (baseBridgeService2 != null) {
            baseBridgeService2.beforePageRender(getProviderFactory());
        }
        IServiceCenter instance2 = ServiceCenter.INSTANCE.instance();
        String bid2 = getBulletContext().getBid();
        IBridgeService iBridgeService3 = (IBridgeService) instance2.get(bid2 != null ? bid2 : "default_bid", IBridgeService.class);
        BaseBridgeService baseBridgeService3 = iBridgeService3 instanceof BaseBridgeService ? (BaseBridgeService) iBridgeService3 : null;
        if (baseBridgeService3 != null && (createStatefulBridges = baseBridgeService3.createStatefulBridges(getProviderFactory())) != null) {
            for (IDLXBridgeMethod iDLXBridgeMethod : createStatefulBridges) {
                WebBDXBridge webBDXBridge10 = this.webBDXBridge;
                if (webBDXBridge10 != null) {
                    webBDXBridge10.registerStatefulMethod(iDLXBridgeMethod);
                }
            }
        }
        WebBDXBridge webBDXBridge11 = this.webBDXBridge;
        if (webBDXBridge11 != null) {
            webBDXBridge11.registerService(ContextProviderFactory.class, getProviderFactory());
        }
        BulletContext bulletContext = getBulletContext();
        WebBDXBridge webBDXBridge12 = this.webBDXBridge;
        if (webBDXBridge12 != null) {
            webBDXBridge12.registerService(BulletContext.class, bulletContext);
        }
        WebBDXBridge webBDXBridge13 = this.webBDXBridge;
        if (webBDXBridge13 != null) {
            webBDXBridge13.registerService(IAnnieProSupport.class, this.annieProSupport);
        }
        if (!AuthStrategyRepository.INSTANCE.getEnableAuthV3()) {
            HybridLogger.i$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_JSB_AUTH, "add legacy jsb2 auth", null, null, 12, null);
            WebBDXBridge webBDXBridge14 = this.webBDXBridge;
            if (webBDXBridge14 != null) {
                webBDXBridge14.addAuthenticator(new Authenticator() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$createXBridge3$10
                    public AuthResult doAuth(BaseBridgeCall<?> call, IDLXBridgeMethod method) {
                        List<String> ignoreGeckoSafeHost;
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(method, "method");
                        if (DefaultWebKitDelegate.this.bulletContext == null) {
                            return new AuthResult(true, false, (String) null, (AuthErrorCode) null, (AuthSuccessCode) null, false, 62, (DefaultConstructorMarker) null);
                        }
                        IEngineGlobalConfig webGlobalConfig = DefaultWebKitDelegate.this.getBulletContext().getWebContext().getWebGlobalConfig();
                        WebEngineGlobalConfig webEngineGlobalConfig = webGlobalConfig instanceof WebEngineGlobalConfig ? (WebEngineGlobalConfig) webGlobalConfig : null;
                        if (webEngineGlobalConfig != null) {
                            List<String> publicFunc = webEngineGlobalConfig.getPublicFunc();
                            if (webEngineGlobalConfig.getIgnoreGeckoSafeHost().isEmpty()) {
                                ignoreGeckoSafeHost = webEngineGlobalConfig.getSafeHost();
                            } else {
                                ignoreGeckoSafeHost = webEngineGlobalConfig.getIgnoreGeckoSafeHost();
                            }
                            if ((!publicFunc.isEmpty()) && publicFunc.contains(method.getName())) {
                                return new AuthResult(true, true, (String) null, (AuthErrorCode) null, AuthSuccessCode.LEGACY_PUBLIC_METHOD, false, 44, (DefaultConstructorMarker) null);
                            }
                            String host = Uri.parse(call.getUrl()).getHost();
                            if (host != null && method.getAccess() != IDLXBridgeMethod.Access.SECURE && (!ignoreGeckoSafeHost.isEmpty())) {
                                for (String str : ignoreGeckoSafeHost) {
                                    if (Intrinsics.areEqual(host, str) || StringsKt.endsWith$default(host, LibrarianImpl.Constants.DOT + str, false, 2, (Object) null)) {
                                        return new AuthResult(true, true, (String) null, (AuthErrorCode) null, AuthSuccessCode.LEGACY_PRIVATE_DOMAINS, false, 44, (DefaultConstructorMarker) null);
                                    }
                                }
                            }
                        }
                        return new AuthResult(true, false, (String) null, (AuthErrorCode) null, (AuthSuccessCode) null, false, 62, (DefaultConstructorMarker) null);
                    }
                }, AuthPriority.HIGH);
            }
        }
        final WebBDXBridge webBDXBridge15 = this.webBDXBridge;
        if (webBDXBridge15 != null) {
            getBulletContext().setBridge3Registry(new IBridge3Registry() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$createXBridge3$11$1
                @Override // com.bytedance.ies.bullet.service.base.IReleasable
                public void release() {
                }

                @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry
                public void handle(String methodName, JSONObject params, final Callback callBack) {
                    String str;
                    Intrinsics.checkNotNullParameter(methodName, "methodName");
                    if (params == null) {
                        params = new JSONObject();
                    }
                    str = DefaultWebKitDelegate.this.mUrl;
                    if (str == null) {
                        str = "";
                    }
                    final BaseBridgeCall webBridgeCall = new WebBridgeCall(methodName, params, str);
                    webBDXBridge15.handleCall(webBridgeCall, new BridgeResultCallback<JSONObject>(webBridgeCall, callBack) { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$createXBridge3$11$1$handle$callback$1
                        final /* synthetic */ Callback $callBack;
                        private JSONObject data;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super((BaseBridgeCall) webBridgeCall);
                            this.$callBack = callBack;
                        }

                        public void dispatchPlatformInvoke(JSONObject data) {
                            Intrinsics.checkNotNullParameter(data, "data");
                            this.data = data;
                            Callback callback = this.$callBack;
                            if (callback != null) {
                                callback.invoke(data);
                            }
                        }

                        public JSONObject convertDataToJSONObject() {
                            JSONObject jSONObject = this.data;
                            return jSONObject == null ? super.convertDataToJSONObject() : jSONObject;
                        }
                    });
                }
            });
            WebAuthVerifierWrapper webAuthVerifierWrapper = webBDXBridge15.getWebAuthVerifierWrapper();
            webAuthVerifierWrapper.addReportDepend(new IReportDepend() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$createXBridge3$11$2$1
                public void report(AuthReportInfo reportInfo) {
                    Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
                    WebViewMonitorHelper.getInstance().customReport(DefaultWebKitDelegate.this.getWebViewDelegate().getWebView(), new CustomInfo.Builder(reportInfo.getEventName()).setUrl(reportInfo.getUrl()).setCategory(reportInfo.getCategory()).setMetric(reportInfo.getMetrics()).setSample(reportInfo.getHighFrequency() ? 2 : 0).build());
                }
            });
            webAuthVerifierWrapper.addLogDepend(new ILogDepend() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$createXBridge3$11$2$2
                public void log(String tag, String msg) {
                    Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    HybridLogger.i$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_JSB_AUTH, msg, null, null, 12, null);
                }
            });
        }
        IEngineGlobalConfig webGlobalConfig = getBulletContext().getWebContext().getWebGlobalConfig();
        WebEngineGlobalConfig webEngineGlobalConfig = webGlobalConfig instanceof WebEngineGlobalConfig ? (WebEngineGlobalConfig) webGlobalConfig : null;
        if (webEngineGlobalConfig != null) {
            Log.d("auth", "DefaultWebKitDelegate disablePermissionCheck");
            for (Map.Entry<Authenticator, AuthPriority> entry : webEngineGlobalConfig.getCustomAuthenticators().entrySet()) {
                WebBDXBridge webBDXBridge16 = this.webBDXBridge;
                if (webBDXBridge16 != null) {
                    webBDXBridge16.addAuthenticator(entry.getKey(), entry.getValue());
                }
            }
        }
        IEngineGlobalConfig webGlobalConfig2 = getBulletContext().getWebContext().getWebGlobalConfig();
        WebEngineGlobalConfig webEngineGlobalConfig2 = webGlobalConfig2 instanceof WebEngineGlobalConfig ? (WebEngineGlobalConfig) webGlobalConfig2 : null;
        if (webEngineGlobalConfig2 != null) {
            ArrayList arrayList2 = new ArrayList();
            IWebGlobalConfigService defaultGlobalWebConfigService = webEngineGlobalConfig2.getDefaultGlobalWebConfigService();
            if (defaultGlobalWebConfigService != null && (provideWebJsBridgeConfig = defaultGlobalWebConfigService.provideWebJsBridgeConfig(getProviderFactory())) != null && (shouldBlockJsbCallListener2 = provideWebJsBridgeConfig.getShouldBlockJsbCallListener()) != null) {
                arrayList2.add(shouldBlockJsbCallListener2);
            }
            Iterator<T> it = webEngineGlobalConfig2.getWebGlobalConfigServiceList().iterator();
            while (it.hasNext()) {
                IWebJsBridgeConfig provideWebJsBridgeConfig2 = ((IWebGlobalConfigService) it.next()).provideWebJsBridgeConfig(getProviderFactory());
                if (provideWebJsBridgeConfig2 != null && (shouldBlockJsbCallListener = provideWebJsBridgeConfig2.getShouldBlockJsbCallListener()) != null) {
                    arrayList2.add(shouldBlockJsbCallListener);
                }
            }
            if (!(!arrayList2.isEmpty()) || (webBDXBridge = this.webBDXBridge) == null) {
                return;
            }
            webBDXBridge.setCustomBlockJsbCallAuthenticator$anniex_release(arrayList2);
        }
    }

    private final BulletWebChromeClient createBusinessChromeClient() {
        return new BulletWebChromeClient() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$createBusinessChromeClient$1
            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                BDXWebKitModel webkitModel;
                BDXPageModel uiModel;
                IBulletViewProvider.IBulletTitleBarProvider iBulletTitleBarProvider;
                StringParam title2;
                BooleanParam useWebviewTitle;
                super.onReceivedTitle(view, title);
                webkitModel = DefaultWebKitDelegate.this.getWebkitModel();
                if ((webkitModel == null || (useWebviewTitle = webkitModel.getUseWebviewTitle()) == null) ? false : Intrinsics.areEqual(useWebviewTitle.getValue(), true)) {
                    uiModel = DefaultWebKitDelegate.this.getUiModel();
                    if (((uiModel == null || (title2 = uiModel.getTitle()) == null) ? null : title2.getValue()) != null || title == null || (iBulletTitleBarProvider = (IBulletViewProvider.IBulletTitleBarProvider) DefaultWebKitDelegate.this.getProviderFactory().provideInstance(IBulletViewProvider.IBulletTitleBarProvider.class)) == null) {
                        return;
                    }
                    iBulletTitleBarProvider.setDefaultTitle(title);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                IFullScreenController iFullScreenController;
                super.onShowCustomView(view, callback);
                if (view == null || (iFullScreenController = DefaultWebKitDelegate.this.getIFullScreenController()) == null) {
                    return;
                }
                iFullScreenController.enterFullScreen(view);
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                super.onHideCustomView();
                IFullScreenController iFullScreenController = DefaultWebKitDelegate.this.getIFullScreenController();
                if (iFullScreenController != null) {
                    iFullScreenController.exitFullScreen();
                }
            }
        };
    }

    private final BulletWebViewClient createBusinessClient() {
        return new BulletWebViewClient() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$createBusinessClient$1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Map map;
                Map map2;
                PiaLifeCycle piaLifeCycle;
                if (url != null) {
                    DefaultWebKitDelegate defaultWebKitDelegate = DefaultWebKitDelegate.this;
                    defaultWebKitDelegate.getProviderFactory().registerHolder(BulletPageUrl.class, new BulletPageUrl(url));
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, "onPageStart url: " + url, null, "XWebKit", 2, null);
                    piaLifeCycle = defaultWebKitDelegate.piaLifeCycle;
                    if (piaLifeCycle != null) {
                        piaLifeCycle.onPageStarted(url);
                    }
                } else {
                    DefaultWebKitDelegate.this.getProviderFactory().removeProvider(BulletPageUrl.class);
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, "onPageStart url: empty", null, "XWebKit", 2, null);
                }
                map = DefaultWebKitDelegate.this.aliasGlobalProps;
                if (map == null || !Intrinsics.areEqual(DefaultWebKitDelegate.this.getBulletContext().getBid(), BidConstants.WEBCAST)) {
                    return;
                }
                Gson gson = new Gson();
                map2 = DefaultWebKitDelegate.this.aliasGlobalProps;
                String str = "window.__globalProps=" + gson.toJson(map2) + ';';
                if (view != null) {
                    view.evaluateJavascript(str, null);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
            
                r1 = r0.this$0.piaLifeCycle;
             */
            @Override // android.webkit.WebViewClient
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onPageFinished(WebView view, String url) {
                PiaLifeCycle piaLifeCycle;
                if (url == null || piaLifeCycle == null) {
                    return;
                }
                piaLifeCycle.onPageFinished(url);
            }

            @Override // com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                boolean z;
                WebJsBridge webJsBridge;
                IESJsBridge iesJsBridge;
                ArgusWebDelegateAdapter argusWebDelegateAdapter;
                WebBDXBridge webBDXBridge;
                z = DefaultWebKitDelegate.this.useXBridge3;
                if (z) {
                    webBDXBridge = DefaultWebKitDelegate.this.webBDXBridge;
                    if (webBDXBridge != null) {
                        webBDXBridge.shouldOverrideUrlLoading(url);
                    }
                } else {
                    webJsBridge = DefaultWebKitDelegate.this.mWebJsBridge;
                    if (webJsBridge != null && (iesJsBridge = webJsBridge.getIesJsBridge()) != null) {
                        Boolean valueOf = Boolean.valueOf(iesJsBridge.invokeJavaMethod(url));
                        if (!valueOf.booleanValue()) {
                            valueOf = null;
                        }
                        if (valueOf != null) {
                            return valueOf.booleanValue();
                        }
                    }
                }
                if (view != null) {
                    argusWebDelegateAdapter = DefaultWebKitDelegate.this.argusAdapter;
                    boolean z2 = false;
                    if (argusWebDelegateAdapter != null && argusWebDelegateAdapter.shouldOverrideUrlLoading(view, url)) {
                        z2 = true;
                    }
                    if (z2) {
                        return true;
                    }
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
            
                r1 = r3.this$0.piaLifeCycle;
             */
            @Override // com.bytedance.ies.bullet.service.base.web.WebViewClientDelegate
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean shouldOverrideUrlLoading(WebView view, IWebResourceRequest request) {
                ArgusWebDelegateAdapter argusWebDelegateAdapter;
                Uri url;
                PiaLifeCycle piaLifeCycle;
                if (request != null && (url = request.getUrl()) != null && piaLifeCycle != null) {
                    String uri = url.toString();
                    Intrinsics.checkNotNullExpressionValue(uri, "it.toString()");
                    piaLifeCycle.shouldOverrideUrlLoading(uri);
                }
                if (view != null) {
                    argusWebDelegateAdapter = DefaultWebKitDelegate.this.argusAdapter;
                    if (Intrinsics.areEqual(argusWebDelegateAdapter != null ? Boolean.valueOf(argusWebDelegateAdapter.shouldOverrideUrlLoading(view, request)) : null, true)) {
                        return true;
                    }
                }
                return super.shouldOverrideUrlLoading(view, request);
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
            
                r2 = r1.this$0.webBDXBridge;
             */
            @Override // android.webkit.WebViewClient
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onLoadResource(WebView view, String url) {
                boolean z;
                WebJsBridge webJsBridge;
                WebBDXBridge webBDXBridge;
                super.onLoadResource(view, url);
                z = DefaultWebKitDelegate.this.useXBridge3;
                if (z) {
                    if (url == null || webBDXBridge == null) {
                        return;
                    }
                    webBDXBridge.onLoadResource(url);
                    return;
                }
                webJsBridge = DefaultWebKitDelegate.this.mWebJsBridge;
                Intrinsics.checkNotNull(webJsBridge, "null cannot be cast to non-null type com.bytedance.ies.bullet.kit.web.jsbridge.WebJsBridge");
                IESJsBridge iesJsBridge = webJsBridge.getIesJsBridge();
                if (iesJsBridge != null) {
                    iesJsBridge.checkBridgeSchema(url);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPerfDataReady(final String methodName, final BridgePerfData perfData) {
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$onPerfDataReady$1
            @Override // java.util.concurrent.Callable
            public final IMonitorReportService call() {
                WebKitService webKitService;
                webKitService = DefaultWebKitDelegate.this.kitService;
                IMonitorReportService iMonitorReportService = (IMonitorReportService) webKitService.getService(IMonitorReportService.class);
                if (iMonitorReportService == null) {
                    return null;
                }
                DefaultWebKitDelegate defaultWebKitDelegate = DefaultWebKitDelegate.this;
                BridgePerfData bridgePerfData = perfData;
                String str = methodName;
                ReportInfo reportInfo = new ReportInfo("bdx_monitor_bridge_duration", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
                if (defaultWebKitDelegate.bulletContext != null) {
                    reportInfo.setPageIdentifier(defaultWebKitDelegate.getBulletContext().getUriIdentifier());
                }
                reportInfo.setMetrics(bridgePerfData.toJSON());
                JSONObject jSONObject = new JSONObject();
                try {
                    Result.Companion companion = Result.Companion;
                    Result.constructor-impl(jSONObject.put("method_name", str));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
                reportInfo.setCategory(jSONObject);
                reportInfo.setPlatform("web");
                reportInfo.setHighFrequency(true);
                iMonitorReportService.report(reportInfo);
                return iMonitorReportService;
            }
        });
    }

    private final WebJsBridge createWebJsBridge(WebView webview) {
        WebJsBridge create = WebJsBridge.INSTANCE.create(webview);
        create.setPerfDataReadyHandler(new DefaultWebKitDelegate$createWebJsBridge$1$1(this));
        return create;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final MonitorJSBListener provideMonitorJSBListener(SSWebView webView) {
        return new MonitorJSBListener((WebView) webView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setJsBridge(SSWebView sSWebView) {
        final ArrayList arrayList;
        final ArrayList arrayList2;
        String str;
        String str2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        Boolean jsBridgeDebug;
        if (this.mWebJsBridge == null) {
            IEngineGlobalConfig webGlobalConfig = getBulletContext().getWebContext().getWebGlobalConfig();
            final WebEngineGlobalConfig webEngineGlobalConfig = webGlobalConfig instanceof WebEngineGlobalConfig ? (WebEngineGlobalConfig) webGlobalConfig : null;
            if (webEngineGlobalConfig == null || (arrayList = webEngineGlobalConfig.getPublicFunc()) == null) {
                arrayList = new ArrayList();
            }
            if (webEngineGlobalConfig == null || (arrayList2 = webEngineGlobalConfig.getProtectedFunc()) == null) {
                arrayList2 = new ArrayList();
            }
            WebJsBridge debug = createWebJsBridge((WebView) sSWebView).setDebug((webEngineGlobalConfig == null || (jsBridgeDebug = webEngineGlobalConfig.getJsBridgeDebug()) == null) ? AnnieX.isDebug() : jsBridgeDebug.booleanValue());
            if (webEngineGlobalConfig == null || (str = webEngineGlobalConfig.getJsObjectName()) == null) {
                str = WebJsBridge.JS_OBJECT_NAME;
            }
            WebJsBridge jsObjectName = debug.setJsObjectName(str);
            if (webEngineGlobalConfig == null || (str2 = webEngineGlobalConfig.getBridgeScheme()) == null) {
                str2 = WebJsBridge.BRIDGE_SCHEME;
            }
            WebJsBridge bridgeScheme = jsObjectName.setBridgeScheme(str2);
            if (webEngineGlobalConfig == null || (arrayList3 = webEngineGlobalConfig.getSafeHost()) == null) {
                arrayList3 = new ArrayList();
            }
            WebJsBridge safeHost = bridgeScheme.setSafeHost(arrayList3);
            if (webEngineGlobalConfig == null || (arrayList4 = webEngineGlobalConfig.getIgnoreGeckoSafeHost()) == null) {
                arrayList4 = new ArrayList();
            }
            this.mWebJsBridge = safeHost.setIgnoreGeckoSafeHost(arrayList4).setPublicFunc(arrayList).setProtectedFunc(arrayList2).setMethodInvocationListener((IMethodInvocationListener) provideMonitorJSBListener(sSWebView)).setPermissionCheckingListener(webEngineGlobalConfig != null ? webEngineGlobalConfig.getPermissionCheckingListener() : null);
            IBridgeRegistry bridgeRegistry = getBulletContext().getBridgeRegistry();
            if (bridgeRegistry != null) {
                bridgeRegistry.iterateWithFuncName(new Function2<String, IGenericBridgeMethod, Unit>() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$setJsBridge$1$1

                    /* compiled from: DefaultWebKitDelegate.kt */
                    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[IBridgeMethod.Access.values().length];
                            try {
                                iArr[IBridgeMethod.Access.PUBLIC.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[IBridgeMethod.Access.PROTECT.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr[IBridgeMethod.Access.PRIVATE.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((String) obj, (IGenericBridgeMethod) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str3, IGenericBridgeMethod iGenericBridgeMethod) {
                        List<String> publicFunc;
                        Intrinsics.checkNotNullParameter(str3, "s");
                        Intrinsics.checkNotNullParameter(iGenericBridgeMethod, "iBridge");
                        int i = WhenMappings.$EnumSwitchMapping$0[iGenericBridgeMethod.getAccess().ordinal()];
                        if (i == 1) {
                            WebEngineGlobalConfig webEngineGlobalConfig2 = WebEngineGlobalConfig.this;
                            publicFunc = true ^ arrayList.contains(str3) ? webEngineGlobalConfig2 != null ? webEngineGlobalConfig2.getPublicFunc() : null : null;
                            if (publicFunc != null) {
                                publicFunc.add(str3);
                                return;
                            }
                            return;
                        }
                        if (i != 2) {
                            return;
                        }
                        WebEngineGlobalConfig webEngineGlobalConfig3 = WebEngineGlobalConfig.this;
                        publicFunc = true ^ arrayList2.contains(str3) ? webEngineGlobalConfig3 != null ? webEngineGlobalConfig3.getProtectedFunc() : null : null;
                        if (publicFunc != null) {
                            publicFunc.add(str3);
                        }
                    }
                });
            }
            WebJsBridge webJsBridge = this.mWebJsBridge;
            this.mWebJsBridge = webJsBridge != null ? webJsBridge.build() : null;
            ContextProviderFactory providerFactory = getProviderFactory();
            WebJsBridge webJsBridge2 = this.mWebJsBridge;
            Intrinsics.checkNotNull(webJsBridge2);
            providerFactory.registerHolder(IESJsBridge.class, webJsBridge2.getIesJsBridge());
            ContextProviderFactory providerFactory2 = getProviderFactory();
            WebJsBridge webJsBridge3 = this.mWebJsBridge;
            Intrinsics.checkNotNull(webJsBridge3);
            providerFactory2.registerHolder(JsBridge2IESSupport.class, webJsBridge3.getJsBridge2Support());
        }
        IEngineGlobalConfig webGlobalConfig2 = getBulletContext().getWebContext().getWebGlobalConfig();
        if (webGlobalConfig2 != null) {
            IEngineGlobalConfig.DefaultImpls.updateBridgeRegister$default(webGlobalConfig2, false, KitType.WEB, 1, null);
        }
        WebJsBridge webJsBridge4 = this.mWebJsBridge;
        if (webJsBridge4 != null) {
            webJsBridge4.bindWebChromeClient(this.webViewDelegate.getWebChromeClientDispatcher());
            webJsBridge4.bindWebViewClient(this.webViewDelegate.getWebViewClientDispatcher());
            webJsBridge4.setup();
        }
        IPrefetchService iPrefetchService = (IPrefetchService) this.kitService.getService(IPrefetchService.class);
        if (iPrefetchService != null) {
            IBridgeRegistry bridgeRegistry2 = getBulletContext().getBridgeRegistry();
            if (bridgeRegistry2 != null) {
                Object providePrefetchBridge$default = IPrefetchService.DefaultImpls.providePrefetchBridge$default(iPrefetchService, getProviderFactory(), null, 2, null);
                Intrinsics.checkNotNull(providePrefetchBridge$default, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod");
                bridgeRegistry2.addBridge((IGenericBridgeMethod) providePrefetchBridge$default);
            }
            IBridgeRegistry bridgeRegistry3 = getBulletContext().getBridgeRegistry();
            if (bridgeRegistry3 != null) {
                Object providePrefetchBridge = iPrefetchService.providePrefetchBridge(getProviderFactory(), "bullet.prefetch");
                Intrinsics.checkNotNull(providePrefetchBridge, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod");
                bridgeRegistry3.addBridge((IGenericBridgeMethod) providePrefetchBridge);
            }
        }
        IBridgeRegistry bridgeRegistry4 = getBulletContext().getBridgeRegistry();
        if (bridgeRegistry4 != null) {
            bridgeRegistry4.addBridge(new DownloadWebContentMethod(getProviderFactory()));
            bridgeRegistry4.addBridge(new CancelWebContentMethod(getProviderFactory()));
        }
        IBulletBridgeProviderService iBulletBridgeProviderService = (IBulletBridgeProviderService) StandardServiceManager.INSTANCE.get(IBulletBridgeProviderService.class);
        if (iBulletBridgeProviderService != null) {
            ContextProviderFactory providerFactory3 = getProviderFactory();
            String bid = getBulletContext().getBid();
            if (bid == null) {
                bid = "default_bid";
            }
            for (Object obj : iBulletBridgeProviderService.provideBridgeList(providerFactory3, null, bid, getBulletContext().getSessionId())) {
                IBridgeRegistry bridgeRegistry5 = getBulletContext().getBridgeRegistry();
                if (bridgeRegistry5 != null) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod");
                    bridgeRegistry5.addBridge((IGenericBridgeMethod) obj);
                }
            }
        }
        IBridgeRegistry bridgeRegistry6 = getBulletContext().getBridgeRegistry();
        if (bridgeRegistry6 != null) {
            bridgeRegistry6.iterateWithFuncName(new Function2<String, IGenericBridgeMethod, Unit>() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$setJsBridge$6
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((String) obj2, (IGenericBridgeMethod) obj3);
                    return Unit.INSTANCE;
                }

                public final void invoke(String str3, final IGenericBridgeMethod iGenericBridgeMethod) {
                    WebJsBridge webJsBridge5;
                    Intrinsics.checkNotNullParameter(str3, "name");
                    Intrinsics.checkNotNullParameter(iGenericBridgeMethod, "iBridge");
                    webJsBridge5 = DefaultWebKitDelegate.this.mWebJsBridge;
                    if (webJsBridge5 != null) {
                        final DefaultWebKitDelegate defaultWebKitDelegate = DefaultWebKitDelegate.this;
                        webJsBridge5.registerJavaMethod(str3, new ISupportJavaMethod() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$setJsBridge$6.1
                            private final Map<String, Object> internalMetaMap = new LinkedHashMap();

                            @Override // com.bytedance.ies.web.jsbridge.IJavaMethod
                            public void call(final JsMsg msg, JSONObject res) {
                                JSONObject jSONObject;
                                WebJsBridge webJsBridge6;
                                Intrinsics.checkNotNullParameter(msg, "msg");
                                Intrinsics.checkNotNullParameter(res, "res");
                                if (msg.params != null) {
                                    jSONObject = msg.params;
                                } else {
                                    jSONObject = new JSONObject();
                                }
                                try {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("type", msg.type);
                                    jSONObject2.put("func", msg.func);
                                    jSONObject2.put("callback_id", msg.callback_id);
                                    jSONObject2.put(IPiaCacheProvider.CacheConfig.FIELD_VERSION, msg.version);
                                    jSONObject2.put("needCallback", msg.needCallback);
                                    jSONObject2.put("permissionGroup", msg.permissionGroup);
                                    jSONObject.put("jsMsg", jSONObject2);
                                    jSONObject.put("res", res);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                if (IGenericBridgeMethod.this instanceof IBridgeMethod) {
                                    this.internalMetaMap.put(ISupportJavaMethod.BRIDGE_TYPE, "BULLET_BRIDGE");
                                    IGenericBridgeMethod iGenericBridgeMethod2 = IGenericBridgeMethod.this;
                                    IBridgeMethod iBridgeMethod = iGenericBridgeMethod2 instanceof IBridgeMethod ? (IBridgeMethod) iGenericBridgeMethod2 : null;
                                    if (iBridgeMethod != null) {
                                        Intrinsics.checkNotNullExpressionValue(jSONObject, "params");
                                        final IGenericBridgeMethod iGenericBridgeMethod3 = IGenericBridgeMethod.this;
                                        final DefaultWebKitDelegate defaultWebKitDelegate2 = defaultWebKitDelegate;
                                        iBridgeMethod.handle(jSONObject, new IBridgeMethod.ICallback() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$setJsBridge$6$1$call$2
                                            @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod.ICallback
                                            public void onComplete(JSONObject data) {
                                                WebJsBridge webJsBridge7;
                                                Intrinsics.checkNotNullParameter(data, "data");
                                                IGenericBridgeMethod iGenericBridgeMethod4 = IGenericBridgeMethod.this;
                                                DefaultWebKitDelegate defaultWebKitDelegate3 = defaultWebKitDelegate2;
                                                JsMsg jsMsg = msg;
                                                IBridgeMethod iBridgeMethod2 = (IBridgeMethod) iGenericBridgeMethod4;
                                                webJsBridge7 = defaultWebKitDelegate3.mWebJsBridge;
                                                if (webJsBridge7 != null) {
                                                    webJsBridge7.invokeJsCallback(iBridgeMethod2, jsMsg.callback_id, data);
                                                }
                                            }

                                            @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod.ICallback
                                            public void onError(int code, String message) {
                                                WebJsBridge webJsBridge7;
                                                Intrinsics.checkNotNullParameter(message, "message");
                                                try {
                                                    JSONObject jSONObject3 = new JSONObject();
                                                    jSONObject3.put("code", code);
                                                    jSONObject3.put("msg", message);
                                                    webJsBridge7 = defaultWebKitDelegate2.mWebJsBridge;
                                                    if (webJsBridge7 != null) {
                                                        webJsBridge7.invokeJsCallback(IGenericBridgeMethod.this, msg.callback_id, jSONObject3);
                                                    }
                                                } catch (JSONException e2) {
                                                    e2.printStackTrace();
                                                }
                                            }

                                            @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod.ICallback
                                            public void onError(int code, String message, JSONObject data) {
                                                WebJsBridge webJsBridge7;
                                                Intrinsics.checkNotNullParameter(message, "message");
                                                Intrinsics.checkNotNullParameter(data, "data");
                                                try {
                                                    JSONObject jSONObject3 = new JSONObject();
                                                    jSONObject3.put("code", code);
                                                    jSONObject3.put("msg", message);
                                                    jSONObject3.put("data", data);
                                                    IGenericBridgeMethod iGenericBridgeMethod4 = IGenericBridgeMethod.this;
                                                    DefaultWebKitDelegate defaultWebKitDelegate3 = defaultWebKitDelegate2;
                                                    JsMsg jsMsg = msg;
                                                    IBridgeMethod iBridgeMethod2 = (IBridgeMethod) iGenericBridgeMethod4;
                                                    webJsBridge7 = defaultWebKitDelegate3.mWebJsBridge;
                                                    if (webJsBridge7 != null) {
                                                        webJsBridge7.invokeJsCallback(iBridgeMethod2, jsMsg.callback_id, jSONObject3);
                                                    }
                                                } catch (JSONException e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                        });
                                    }
                                } else {
                                    this.internalMetaMap.put(ISupportJavaMethod.BRIDGE_TYPE, "IDL_XBRIDGE");
                                    IGenericBridgeMethod iGenericBridgeMethod4 = IGenericBridgeMethod.this;
                                    Intrinsics.checkNotNull(iGenericBridgeMethod4, "null cannot be cast to non-null type com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod<org.json.JSONObject, org.json.JSONObject>");
                                    final IIDLGenericBridgeMethod iIDLGenericBridgeMethod = (IIDLGenericBridgeMethod) iGenericBridgeMethod4;
                                    final Function2<Object, Class<?>, Object> provideTypeConverter = BridgeDataConverterHolder.provideTypeConverter(JSONObject.class, Map.class);
                                    final Function2<Object, Class<?>, Object> provideTypeConverter2 = BridgeDataConverterHolder.provideTypeConverter(Map.class, JSONObject.class);
                                    iIDLGenericBridgeMethod.setLocalInputConverter(new Function1<Object, Object>() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$setJsBridge$6$1$call$3
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        public final Object invoke(Object obj2) {
                                            Intrinsics.checkNotNullParameter(obj2, "it");
                                            Function2<Object, Class<?>, Object> function2 = provideTypeConverter;
                                            if (function2 != null) {
                                                Class<?> innerClassType = iIDLGenericBridgeMethod.getInnerClassType();
                                                if (innerClassType == null) {
                                                    innerClassType = Object.class;
                                                }
                                                Object invoke = function2.invoke(obj2, innerClassType);
                                                if (invoke != null) {
                                                    return invoke;
                                                }
                                            }
                                            return MapsKt.emptyMap();
                                        }
                                    });
                                    iIDLGenericBridgeMethod.setLocalOutputConverter(new Function1<Object, Object>() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$setJsBridge$6$1$call$4
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        public final Object invoke(Object obj2) {
                                            Intrinsics.checkNotNullParameter(obj2, "it");
                                            Function2<Object, Class<?>, Object> function2 = provideTypeConverter2;
                                            if (function2 != null) {
                                                Class<?> innerClassType = iIDLGenericBridgeMethod.getInnerClassType();
                                                if (innerClassType == null) {
                                                    innerClassType = Object.class;
                                                }
                                                Object invoke = function2.invoke(obj2, innerClassType);
                                                if (invoke != null) {
                                                    return invoke;
                                                }
                                            }
                                            return MapsKt.emptyMap();
                                        }
                                    });
                                    try {
                                        Intrinsics.checkNotNullExpressionValue(jSONObject, "params");
                                        final DefaultWebKitDelegate defaultWebKitDelegate3 = defaultWebKitDelegate;
                                        BridgeMethodKt.actualHandle(iIDLGenericBridgeMethod, jSONObject, new IIDLGenericBridgeMethod.ICallback<JSONObject>() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$setJsBridge$6$1$call$5
                                            @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
                                            public void onComplete(JSONObject data) {
                                                WebJsBridge webJsBridge7;
                                                Intrinsics.checkNotNullParameter(data, "data");
                                                IIDLGenericBridgeMethod<JSONObject, JSONObject> iIDLGenericBridgeMethod2 = iIDLGenericBridgeMethod;
                                                DefaultWebKitDelegate defaultWebKitDelegate4 = defaultWebKitDelegate3;
                                                JsMsg jsMsg = msg;
                                                webJsBridge7 = defaultWebKitDelegate4.mWebJsBridge;
                                                if (webJsBridge7 != null) {
                                                    webJsBridge7.invokeJsCallback(iIDLGenericBridgeMethod2, jsMsg.callback_id, data);
                                                }
                                            }

                                            @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
                                            public void onError(int code, String message) {
                                                WebJsBridge webJsBridge7;
                                                Intrinsics.checkNotNullParameter(message, "message");
                                                try {
                                                    JSONObject jSONObject3 = new JSONObject();
                                                    jSONObject3.put("code", code);
                                                    jSONObject3.put("msg", message);
                                                    IIDLGenericBridgeMethod<JSONObject, JSONObject> iIDLGenericBridgeMethod2 = iIDLGenericBridgeMethod;
                                                    DefaultWebKitDelegate defaultWebKitDelegate4 = defaultWebKitDelegate3;
                                                    JsMsg jsMsg = msg;
                                                    webJsBridge7 = defaultWebKitDelegate4.mWebJsBridge;
                                                    if (webJsBridge7 != null) {
                                                        webJsBridge7.invokeJsCallback(iIDLGenericBridgeMethod2, jsMsg.callback_id, jSONObject3);
                                                    }
                                                } catch (JSONException e2) {
                                                    e2.printStackTrace();
                                                }
                                            }

                                            @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
                                            public void onError(int code, String message, JSONObject data) {
                                                WebJsBridge webJsBridge7;
                                                Intrinsics.checkNotNullParameter(message, "message");
                                                Intrinsics.checkNotNullParameter(data, "data");
                                                try {
                                                    JSONObject jSONObject3 = new JSONObject();
                                                    jSONObject3.put("code", code);
                                                    jSONObject3.put("msg", message);
                                                    jSONObject3.put("data", data);
                                                    IIDLGenericBridgeMethod<JSONObject, JSONObject> iIDLGenericBridgeMethod2 = iIDLGenericBridgeMethod;
                                                    DefaultWebKitDelegate defaultWebKitDelegate4 = defaultWebKitDelegate3;
                                                    JsMsg jsMsg = msg;
                                                    webJsBridge7 = defaultWebKitDelegate4.mWebJsBridge;
                                                    if (webJsBridge7 != null) {
                                                        webJsBridge7.invokeJsCallback(iIDLGenericBridgeMethod2, jsMsg.callback_id, jSONObject3);
                                                    }
                                                } catch (JSONException e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                        });
                                    } catch (Throwable th) {
                                        try {
                                            JSONObject jSONObject3 = new JSONObject();
                                            jSONObject3.put("code", 0);
                                            jSONObject3.put("msg", th.toString());
                                            webJsBridge6 = defaultWebKitDelegate.mWebJsBridge;
                                            if (webJsBridge6 != null) {
                                                webJsBridge6.invokeJsCallback(iIDLGenericBridgeMethod, msg.callback_id, jSONObject3);
                                            }
                                        } catch (JSONException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                }
                                msg.needCallback = IGenericBridgeMethod.this.getNeedCallback();
                            }

                            @Override // com.bytedance.ies.web.jsbridge.ISupportJavaMethod
                            public Map<String, Object> getMetaInfo() {
                                return this.internalMetaMap;
                            }
                        }, iGenericBridgeMethod.getAccess());
                    }
                }
            });
        }
    }

    private final void setWebSettings(WebView webView) {
        BulletSettings provideBulletSettings;
        CommonConfig commonConfig;
        String str;
        Boolean property;
        Boolean property2;
        if (getBulletContext().getWebContext().getWebGlobalConfig() instanceof WebEngineGlobalConfig) {
            IEngineGlobalConfig webGlobalConfig = getBulletContext().getWebContext().getWebGlobalConfig();
            WebEngineGlobalConfig webEngineGlobalConfig = webGlobalConfig instanceof WebEngineGlobalConfig ? (WebEngineGlobalConfig) webGlobalConfig : null;
            if (webEngineGlobalConfig != null) {
                IWebGlobalConfigService defaultGlobalWebConfigService = webEngineGlobalConfig.getDefaultGlobalWebConfigService();
                if (defaultGlobalWebConfigService != null) {
                    WebSettings settings = webView.getSettings();
                    Intrinsics.checkNotNullExpressionValue(settings, ErrorType.SETTINGS);
                    defaultGlobalWebConfigService.applySettings(settings, webView, getProviderFactory());
                }
                for (IWebGlobalConfigService iWebGlobalConfigService : CollectionsKt.reversed(webEngineGlobalConfig.getWebGlobalConfigServiceList())) {
                    WebSettings settings2 = webView.getSettings();
                    Intrinsics.checkNotNullExpressionValue(settings2, ErrorType.SETTINGS);
                    iWebGlobalConfigService.applySettings(settings2, webView, getProviderFactory());
                }
                PiaHelper piaHelper = PiaHelper.INSTANCE;
                BulletContext bulletContext = webEngineGlobalConfig.getBulletContext();
                if (bulletContext == null || (str = bulletContext.getBid()) == null) {
                    str = "default_bid";
                }
                String userAgentString = webView.getSettings().getUserAgentString();
                Intrinsics.checkNotNullExpressionValue(userAgentString, "settings.userAgentString");
                piaHelper.updateUserAgent(str, userAgentString);
                WebSettings settings3 = webView.getSettings();
                settings3.setUserAgentString(settings3.getUserAgentString() + " IsPreInstallApp/" + (AnnieXRuntime.INSTANCE.getApplicationDepend().isPreInstallApp() ? 1 : 0));
                CustomWebSettings customWebSettings = webEngineGlobalConfig.getCustomWebSettings();
                if (customWebSettings != null) {
                    IPropertySetter<Boolean> hardwareAccelerationProperty = customWebSettings.getHardwareAccelerationProperty();
                    if (!hardwareAccelerationProperty.getLocalIsSet()) {
                        hardwareAccelerationProperty = null;
                    }
                    if (hardwareAccelerationProperty != null && (property2 = hardwareAccelerationProperty.getProperty()) != null && !property2.booleanValue()) {
                        webView.setLayerType(1, null);
                    }
                    IPropertySetter<Boolean> longClickableProperty = customWebSettings.getLongClickableProperty();
                    if (!longClickableProperty.getLocalIsSet()) {
                        longClickableProperty = null;
                    }
                    if (longClickableProperty != null && (property = longClickableProperty.getProperty()) != null) {
                        webView.setLongClickable(property.booleanValue());
                    }
                }
            }
        }
        BDXWebKitModel webkitModel = getWebkitModel();
        if (webkitModel != null) {
            IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
            if (Intrinsics.areEqual((iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) ? null : Boolean.valueOf(commonConfig.getSchemaIgnoreCachePolicyEnable()), true)) {
                webView.getSettings().setCacheMode(Intrinsics.areEqual(webkitModel.getIgnoreCachePolicy().getValue(), true) ? 2 : -1);
            } else if (!Intrinsics.areEqual(webkitModel.getBundleLoadNoCache().getValue(), true)) {
                webView.getSettings().setCacheMode(Intrinsics.areEqual(webkitModel.getBundleEnableAppCache().getValue(), true) ? 1 : -1);
            } else {
                webView.getSettings().setCacheMode(2);
            }
            ISettingService iSettingService = (ISettingService) this.kitService.getService(ISettingService.class);
            if (((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings.getEnableAutoPlayBGMParam()) && Intrinsics.areEqual(webkitModel.getAutoPlayBgm().getValue(), true)) {
                webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
            }
            if (Intrinsics.areEqual(webkitModel.getDisableHardwareAccelerate().getValue(), true)) {
                webView.setLayerType(1, null);
            }
            if (Intrinsics.areEqual(webkitModel.getDisableAllLocations().getValue(), true)) {
                webView.getSettings().setGeolocationEnabled(false);
            }
        }
        webView.setFocusable(true);
        webView.setFocusableInTouchMode(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setWebSecureDelegate(SSWebView sSWebView, WebKitView webKitView) {
        StringParam secureLinkScene;
        BDXWebKitModel webkitModel = getWebkitModel();
        final String value = (webkitModel == null || (secureLinkScene = webkitModel.getSecureLinkScene()) == null) ? null : secureLinkScene.getValue();
        final boolean enablePia = getBulletContext().getWebContext().getEnablePia();
        if (!enablePia) {
            sSWebView.setSecureLinkScene(value);
        }
        ArgusWebDelegateAdapter build = ArgusWebDelegateAdapter.INSTANCE.build(new SecureProviderFactory() { // from class: com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate$setWebSecureDelegate$adapter$1
            @Override // com.bytedance.ies.bullet.secure.SecureProviderFactory
            public BulletContext getContext() {
                return DefaultWebKitDelegate.this.getBulletContext();
            }

            @Override // com.bytedance.ies.bullet.secure.SecureProviderFactory
            public String getSchema() {
                String str;
                str = DefaultWebKitDelegate.this.mUrl;
                return str;
            }

            @Override // com.bytedance.ies.bullet.secure.SecureProviderFactory
            /* renamed from: getSecLinkScene, reason: from getter */
            public String get$scene() {
                return value;
            }

            @Override // com.bytedance.ies.bullet.secure.SecureProviderFactory
            public IWebSecureDelegate getExternDelegate() {
                IEngineGlobalConfig webGlobalConfig = DefaultWebKitDelegate.this.getBulletContext().getWebContext().getWebGlobalConfig();
                WebEngineGlobalConfig webEngineGlobalConfig = webGlobalConfig instanceof WebEngineGlobalConfig ? (WebEngineGlobalConfig) webGlobalConfig : null;
                if (webEngineGlobalConfig == null) {
                    return null;
                }
                DefaultWebKitDelegate defaultWebKitDelegate = DefaultWebKitDelegate.this;
                IWebGlobalConfigService defaultGlobalWebConfigService = webEngineGlobalConfig.getDefaultGlobalWebConfigService();
                if (defaultGlobalWebConfigService != null) {
                    return defaultGlobalWebConfigService.createWebSecureDelegate(defaultWebKitDelegate.getProviderFactory());
                }
                return null;
            }

            @Override // com.bytedance.ies.bullet.secure.SecureProviderFactory
            public Boolean enablePIA() {
                return Boolean.valueOf(enablePia);
            }
        }, (WebView) sSWebView);
        this.argusAdapter = build;
        sSWebView.setArgusAdapter$anniex_release(build);
        webKitView.setArgusAdapter$anniex_release(build);
    }

    private final void setupPia(SSWebView webView) {
        if (getBulletContext().getWebContext().getEnablePia()) {
            PiaHelper piaHelper = PiaHelper.INSTANCE;
            String bid = getBulletContext().getBid();
            if (bid == null) {
                bid = "default_bid";
            }
            PiaLifeCycle createPiaLifeCycle = piaHelper.createPiaLifeCycle(bid);
            if (createPiaLifeCycle != null) {
                createPiaLifeCycle.bindContext(webView, getBulletContext());
                webView.setPiaLifeCycle$anniex_release(createPiaLifeCycle);
            } else {
                createPiaLifeCycle = null;
            }
            this.piaLifeCycle = createPiaLifeCycle;
        }
    }

    private final void generateSchemaModelOpt(ISchemaData data) {
        String str;
        Class<? extends ISchemaModel> cls;
        List<Class<? extends ISchemaModel>> extraModelType;
        ArrayList arrayList = new ArrayList();
        SchemaModelTransformer.INSTANCE.generateContainerModel(getBulletContext(), data);
        SchemaModelTransformer.INSTANCE.generateUiModel(getBulletContext(), data);
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        List<String> packages = getBulletContext().getSchemeContext().getPackages();
        if (packages == null || (str = (String) CollectionsKt.firstOrNull(packages)) == null) {
            str = "default_bid";
        }
        IWebGlobalConfigService iWebGlobalConfigService = (IWebGlobalConfigService) instance.get(str, IWebGlobalConfigService.class);
        if (iWebGlobalConfigService == null || (cls = iWebGlobalConfigService.getModelType()) == null) {
            cls = BDXWebKitModel.class;
        }
        getBulletContext().getSchemaModelUnion().setKitModel(SchemaService.INSTANCE.getInstance().generateSchemaModel(data, cls));
        List<String> packages2 = getBulletContext().getSchemeContext().getPackages();
        if (packages2 != null) {
            Iterator<T> it = packages2.iterator();
            while (it.hasNext()) {
                IWebGlobalConfigService iWebGlobalConfigService2 = (IWebGlobalConfigService) ServiceCenter.INSTANCE.instance().get((String) it.next(), IWebGlobalConfigService.class);
                if (iWebGlobalConfigService2 != null && (extraModelType = iWebGlobalConfigService2.getExtraModelType()) != null) {
                    Iterator<T> it2 = extraModelType.iterator();
                    while (it2.hasNext()) {
                        ISchemaModel generateSchemaModel = SchemaService.INSTANCE.getInstance().generateSchemaModel(data, (Class) it2.next());
                        if (generateSchemaModel != null) {
                            arrayList.add(generateSchemaModel);
                        }
                    }
                }
            }
        }
        getBulletContext().getSchemeContext().setExtraSchemaModelList(arrayList);
        this.useXBridge3 = BulletContextKt.useWebXBridge3(getBulletContext());
    }

    private final void generateSchemaModel(ISchemaData data) {
        String str;
        Class<? extends ISchemaModel> cls;
        List<Class<? extends ISchemaModel>> extraModelType;
        ArrayList arrayList = new ArrayList();
        BDXContainerModel bDXContainerModel = (BDXContainerModel) SchemaService.INSTANCE.getInstance().generateSchemaModel(data, BDXContainerModel.class);
        if (bDXContainerModel != null) {
            SchemaModelTransformer.INSTANCE.transform(bDXContainerModel);
        }
        BDXPageModel bDXPageModel = (BDXPageModel) SchemaService.INSTANCE.getInstance().generateSchemaModel(data, BDXPageModel.class);
        if (bDXPageModel != null) {
            SchemaModelTransformer.INSTANCE.transform(bDXPageModel);
        }
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        List<String> packages = getBulletContext().getSchemeContext().getPackages();
        if (packages == null || (str = (String) CollectionsKt.firstOrNull(packages)) == null) {
            str = "default_bid";
        }
        IWebGlobalConfigService iWebGlobalConfigService = (IWebGlobalConfigService) instance.get(str, IWebGlobalConfigService.class);
        if (iWebGlobalConfigService == null || (cls = iWebGlobalConfigService.getModelType()) == null) {
            cls = BDXWebKitModel.class;
        }
        ISchemaModel generateSchemaModel = SchemaService.INSTANCE.getInstance().generateSchemaModel(data, cls);
        getBulletContext().setSchemaModelUnion(new SchemaModelUnion(data));
        getBulletContext().getSchemaModelUnion().setContainerModel(bDXContainerModel);
        getBulletContext().getSchemaModelUnion().setUiModel(bDXPageModel);
        getBulletContext().getSchemaModelUnion().setKitModel(generateSchemaModel);
        List<String> packages2 = getBulletContext().getSchemeContext().getPackages();
        if (packages2 != null) {
            Iterator<T> it = packages2.iterator();
            while (it.hasNext()) {
                IWebGlobalConfigService iWebGlobalConfigService2 = (IWebGlobalConfigService) ServiceCenter.INSTANCE.instance().get((String) it.next(), IWebGlobalConfigService.class);
                if (iWebGlobalConfigService2 != null && (extraModelType = iWebGlobalConfigService2.getExtraModelType()) != null) {
                    Iterator<T> it2 = extraModelType.iterator();
                    while (it2.hasNext()) {
                        ISchemaModel generateSchemaModel2 = SchemaService.INSTANCE.getInstance().generateSchemaModel(data, (Class) it2.next());
                        if (generateSchemaModel2 != null) {
                            arrayList.add(generateSchemaModel2);
                        }
                    }
                }
            }
        }
        getBulletContext().getSchemeContext().setExtraSchemaModelList(arrayList);
        this.useXBridge3 = BulletContextKt.useWebXBridge3(getBulletContext());
    }

    private final int px2dip(Context context, float pxValue) {
        return (int) ((pxValue / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public WebResourceResponse loadResource(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!Uri.parse(url).isHierarchical()) {
            return super.loadResource(url);
        }
        Pair canInterceptByForest$default = ForestWebInfoHelper.DefaultImpls.canInterceptByForest$default(this, url, false, null, getBulletContext(), null, 22, null);
        boolean booleanValue = ((Boolean) canInterceptByForest$default.component1()).booleanValue();
        Scene scene = (Scene) canInterceptByForest$default.component2();
        if (!useForest(getBulletContext()) || !booleanValue) {
        }
        WebResourceResponse realLoadResource$default = realLoadResource$default(this, url, scene, false, null, 8, null);
        return realLoadResource$default == null ? super.loadResource(url) : realLoadResource$default;
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public WebResourceResponse loadResource(WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Uri url = request.getUrl();
        if (!(url != null && url.isHierarchical())) {
            return super.loadResource(request);
        }
        Pair canInterceptByForest$default = ForestWebInfoHelper.DefaultImpls.canInterceptByForest$default(this, request, null, getBulletContext(), null, 10, null);
        boolean booleanValue = ((Boolean) canInterceptByForest$default.component1()).booleanValue();
        Scene scene = (Scene) canInterceptByForest$default.component2();
        boolean z = useForest(getBulletContext()) && booleanValue;
        String uri = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "request.url.toString()");
        WebResourceResponse realLoadResource = realLoadResource(uri, scene, z, request);
        return realLoadResource == null ? super.loadResource(request) : realLoadResource;
    }

    static /* synthetic */ WebResourceResponse realLoadResource$default(DefaultWebKitDelegate defaultWebKitDelegate, String str, Scene scene, boolean z, WebResourceRequest webResourceRequest, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: realLoadResource");
        }
        if ((i & 8) != 0) {
            webResourceRequest = null;
        }
        return defaultWebKitDelegate.realLoadResource(str, scene, z, webResourceRequest);
    }

    private final WebResourceResponse realLoadResource(String url, Scene scene, boolean useForest, WebResourceRequest webRequest) {
        String str;
        WebResourceResponse loadLocalDiskResponse;
        Response loadSync;
        WebView webView;
        MonitorSettingsConfig monitorSettingsConfig;
        if (Intrinsics.areEqual(getBulletContext().getBid(), BidConstants.WEBCAST) && !useForest) {
            return super.loadResource(url);
        }
        if (scene == Scene.WEB_MAIN_DOCUMENT) {
            getBulletContext().getMonitorCallback().onPrepareTemplateBegin();
        }
        WebResourceResponse webResourceResponse = null;
        webResourceResponse = null;
        TaskConfig taskConfig = new TaskConfig(null, 1, null);
        taskConfig.setWebRequest(webRequest);
        taskConfig.setInjectedUserAgent(this.userAgent);
        CustomLoaderConfig from = CustomLoaderConfig.INSTANCE.from(getBulletContext().getResourceContext().getCustomLoaderConfig());
        if (from == null) {
            from = new CustomLoaderConfig(false);
        }
        from.setLoaderSequence(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO, LoaderType.BUILTIN}));
        taskConfig.setLoaderConfig(from);
        TaskContext.Companion companion = TaskContext.INSTANCE;
        IServiceContext serviceContext = getBulletContext().getServiceContext();
        taskConfig.setTaskContext(companion.from(serviceContext != null ? serviceContext.getAllDependency() : null));
        taskConfig.setBid(this.kitService.getBid());
        taskConfig.setResTag("web");
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (((iBulletSettingsService == null || (monitorSettingsConfig = (MonitorSettingsConfig) iBulletSettingsService.obtainSettings(MonitorSettingsConfig.class)) == null) ? false : monitorSettingsConfig.getWebSSPReport()) && (webView = (WebView) getProviderFactory().provideInstance(WebView.class)) != null) {
            taskConfig.setEngineViewHash(String.valueOf(webView.hashCode()));
            taskConfig.setEngineUrl(this.mUrl);
        }
        if (useForest) {
            loadSync = r1.loadSync((r17 & 1) != 0 ? ForestLoader.INSTANCE.getDefault() : null, url, (r17 & 4) != 0 ? null : forestDownloadEngine(getBulletContext()), scene, getForestSessionId(), (r17 & 32) != 0 ? null : taskConfig, (r17 & 64) != 0 ? null : null);
            if (loadSync != null) {
                HybridLogger.d$default(HybridLogger.INSTANCE, "forest-web", "forest resp: " + loadSync, null, null, 12, null);
                String sourceType = loadSync.getSourceType(loadSync.getFrom());
                webResourceResponse = loadSync.provideWebResourceResponse();
                str = sourceType;
            }
            str = null;
        } else {
            WebResourceResponse cacheResource = WebResourceDownloader.INSTANCE.getInstance().getCacheResource(url);
            if (cacheResource == null) {
                ResourceInfo loadSync2 = ResourceLoader.with$default(ResourceLoader.INSTANCE, this.kitService.getBid(), null, 2, null).loadSync(url, taskConfig);
                if (loadSync2 != null) {
                    String filePath = loadSync2.getFilePath();
                    if (!(!(filePath == null || filePath.length() == 0))) {
                        loadSync2 = null;
                    }
                    if (loadSync2 != null) {
                        WebResourceResponse webResourceResponse2 = loadSync2.getWebResourceResponse();
                        if (webResourceResponse2 == null) {
                            ResourceType type = loadSync2.getType();
                            int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                            if (i == 1) {
                                loadLocalDiskResponse = ResourceLoaderUtils.INSTANCE.loadLocalDiskResponse(loadSync2.getFilePath());
                            } else if (i == 2) {
                                ResourceLoaderUtils resourceLoaderUtils = ResourceLoaderUtils.INSTANCE;
                                Application application = BulletEnv.INSTANCE.getInstance().getApplication();
                                loadLocalDiskResponse = resourceLoaderUtils.loadLocalAssetResponse(application != null ? application.getAssets() : null, loadSync2.getFilePath());
                            }
                            webResourceResponse = loadLocalDiskResponse;
                        } else {
                            webResourceResponse = webResourceResponse2;
                        }
                        str = loadSync2.getStatisticFrom();
                    }
                }
                str = null;
            } else {
                str = null;
                webResourceResponse = cacheResource;
            }
        }
        if (scene == Scene.WEB_MAIN_DOCUMENT && webResourceResponse != null) {
            if (str != null) {
                getBulletContext().getResourceContext().setResFrom(str);
            }
            getBulletContext().getMonitorCallback().onPrepareTemplateEnd();
        }
        return webResourceResponse;
    }

    private final String getForestSessionId() {
        String forestSessionId;
        if (IConditionCallKt.enablePreloadBeforeLoad() && Intrinsics.areEqual(getBulletContext().getBid(), BidConstants.WEBCAST)) {
            ForestSessionId forestSessionId2 = (ForestSessionId) getProviderFactory().provideInstance(ForestSessionId.class);
            return (forestSessionId2 == null || (forestSessionId = forestSessionId2.getForestSessionId()) == null) ? getBulletContext().getSessionId() : forestSessionId;
        }
        return getBulletContext().getSessionId();
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public WebResourceResponse loadPiaResource(WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        PiaLifeCycle piaLifeCycle = this.piaLifeCycle;
        if (piaLifeCycle != null) {
            return piaLifeCycle.shouldInterceptRequest(request);
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public void updateGlobalProps(Uri uri, View view) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof WebView) {
            IGlobalPropsHandler mo589getGlobalPropsHandler = this.webViewDelegate.mo589getGlobalPropsHandler();
            mo589getGlobalPropsHandler.injectContextProvider(ContextProviderManager.INSTANCE.getProviderFactory(getBulletContext().getSessionId()));
            mo589getGlobalPropsHandler.updateGlobalProps(getGlobalProps(uri));
            mo589getGlobalPropsHandler.injectGlobalProps((WebView) view);
        }
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public void updateGlobalProps(View view, Map<String, ? extends Object> globalProps) {
        Intrinsics.checkNotNullParameter(globalProps, "globalProps");
        if (IConditionCallKt.enableWebKitViewUpdateGlobalProps() && (view instanceof WebView)) {
            IGlobalPropsHandler mo589getGlobalPropsHandler = this.webViewDelegate.mo589getGlobalPropsHandler();
            Map<String, ? extends Object> map = this.aliasGlobalProps;
            if (map != null) {
                map.putAll(globalProps);
                mo589getGlobalPropsHandler.updateGlobalProps(map);
                mo589getGlobalPropsHandler.injectGlobalProps((WebView) view);
            }
        }
    }

    private final Map<String, Object> getGlobalProps(Uri uri) {
        Map<String, Object> emptyMap;
        String str;
        Uri prefetchUri;
        Boolean isH5CoverGlobalProps;
        if (this.aliasGlobalProps != null) {
            HybridLogger.i$default(HybridLogger.INSTANCE, "XWebKit", "already getGlobalProps", null, null, 12, null);
            Map<String, Object> map = this.aliasGlobalProps;
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
            return TypeIntrinsics.asMutableMap(map);
        }
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        BulletSettings provideBulletSettings = iSettingService != null ? iSettingService.provideBulletSettings() : null;
        boolean booleanValue = (provideBulletSettings == null || (isH5CoverGlobalProps = provideBulletSettings.getIsH5CoverGlobalProps()) == null) ? false : isH5CoverGlobalProps.booleanValue();
        this.webViewDelegate.mo589getGlobalPropsHandler();
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        if (booleanValue) {
            HybridLogger.i$default(HybridLogger.INSTANCE, "XWebKit", "cover global props", null, null, 12, null);
            Map<? extends String, ? extends Object> deviceProps = PropsUtilsKt.getDeviceProps(KitType.WEB, getBulletContext().getContext(), getBulletContext());
            if (deviceProps != null) {
                linkedHashMap.putAll(deviceProps);
            }
            linkedHashMap.putAll(PropsUtilsKt.getPageCommonProps(getBulletContext().getContext(), IConditionCallKt.enableSafeAreaHeight()));
        }
        linkedHashMap.put("containerVersion", "9.0.0");
        linkedHashMap.put("containerType", "bullet");
        IEngineGlobalConfig webGlobalConfig = getBulletContext().getWebContext().getWebGlobalConfig();
        if (webGlobalConfig != null) {
            webGlobalConfig.updateGlobalProps();
        }
        IEngineGlobalConfig webGlobalConfig2 = getBulletContext().getWebContext().getWebGlobalConfig();
        if (webGlobalConfig2 == null || (emptyMap = webGlobalConfig2.getGlobalProps()) == null) {
            emptyMap = MapsKt.emptyMap();
        }
        linkedHashMap.putAll(emptyMap);
        linkedHashMap.putAll(getBulletContext().getMonitorCallback().generatePerfMapForGlobalProps());
        Boolean isRebuild = getBulletContext().getIsRebuild();
        if (isRebuild != null) {
            linkedHashMap.put("isRebuild", Integer.valueOf(isRebuild.booleanValue() ? 1 : 0));
        }
        linkedHashMap.put(GlobalPropertiesConstants.IS_PRE_CREATE, Integer.valueOf(getBulletContext().getContainerContext().getIsPreCreate() ? 1 : 0));
        linkedHashMap.put("isPreload", Integer.valueOf(Intrinsics.areEqual(getBulletContext().getContainerContext().getIsPreload(), true) ? 1 : 0));
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Intrinsics.checkNotNullExpressionValue(queryParameterNames, "uri.queryParameterNames");
        for (String str2 : queryParameterNames) {
            String queryParameter = uri.getQueryParameter(str2);
            if (queryParameter != null) {
                Intrinsics.checkNotNullExpressionValue(str2, "key");
                linkedHashMap2.put(str2, queryParameter);
            }
        }
        linkedHashMap.put("queryItems", linkedHashMap2);
        BulletLoadUriIdentifier uriIdentifier = getBulletContext().getUriIdentifier();
        if (uriIdentifier == null || (str = uriIdentifier.getIdentifierUrl()) == null) {
            str = "";
        }
        linkedHashMap.put("resolvedUrl", str);
        linkedHashMap.put("useXBridge3", Boolean.valueOf(this.useXBridge3));
        linkedHashMap.put("bulletStorageValues", getStorageGlobalProps(uri, getBulletContext().getContext()));
        linkedHashMap.put("userDomainStorageValues", getUserDomainStorageGlobalProps(uri, getBulletContext().getContext()));
        IPrefetchV2Service prefetchV2Service = IPrefetchV2ServiceKt.getPrefetchV2Service();
        if (prefetchV2Service != null && (prefetchUri = getBulletContext().getPrefetchUri()) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            BulletLoadUriIdentifier uriIdentifier2 = getBulletContext().getUriIdentifier();
            Collection<PrefetchV2Data> cacheBySchemeV2 = prefetchV2Service.getCacheBySchemeV2(prefetchUri, uriIdentifier2 != null ? uriIdentifier2.getIdentifierUrl() : null, true, getBulletContext());
            if (true ^ cacheBySchemeV2.isEmpty()) {
                for (PrefetchV2Data prefetchV2Data : cacheBySchemeV2) {
                    String globalPropsName = prefetchV2Data.getGlobalPropsName();
                    if (globalPropsName != null && LoaderUtil.INSTANCE.isNotNullOrEmpty(globalPropsName) && prefetchV2Data.getBody() != null) {
                        Object jSONObject = prefetchV2Data.getBody().toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "item.body.toString()");
                        linkedHashMap.put(globalPropsName, jSONObject);
                    }
                }
            }
            prefetchV2Service.log("Prefetch数据注入props耗时" + (System.currentTimeMillis() - currentTimeMillis) + " ms, uri: " + prefetchUri + ", Props数量: " + cacheBySchemeV2.size());
        }
        if (!booleanValue) {
            Map<? extends String, ? extends Object> deviceProps2 = PropsUtilsKt.getDeviceProps(KitType.WEB, getBulletContext().getContext(), getBulletContext());
            if (deviceProps2 != null) {
                linkedHashMap.putAll(deviceProps2);
            }
            linkedHashMap.putAll(PropsUtilsKt.getPageCommonProps(getBulletContext().getContext(), IConditionCallKt.enableSafeAreaHeight()));
        }
        Map<String, Object> globalProps = getBulletContext().getContainerContext().getGlobalProps();
        if (globalProps != null) {
            linkedHashMap.putAll(globalProps);
        }
        linkedHashMap.put(GlobalPropertiesConstants.IS_COLD_START, Boolean.valueOf(this.isColdStart));
        PiaHelper piaHelper = PiaHelper.INSTANCE;
        String bid = getBulletContext().getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        piaHelper.updateGlobalProps(bid, linkedHashMap);
        globalPropsAdapterWithBid(getBulletContext().getBid(), linkedHashMap);
        this.aliasGlobalProps = linkedHashMap;
        return linkedHashMap;
    }

    static /* synthetic */ void globalPropsAdapterWithBid$default(DefaultWebKitDelegate defaultWebKitDelegate, String str, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: globalPropsAdapterWithBid");
        }
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        defaultWebKitDelegate.globalPropsAdapterWithBid(str, map);
    }

    private final void globalPropsAdapterWithBid(String bid, Map<String, Object> constants) {
        if (Intrinsics.areEqual(bid, BidConstants.WEBCAST)) {
            constants.put("os", FrontierIdGenerator.APP_RUNTIME_TYPE_ANDROID);
        }
    }

    private final Map<String, Object> getStorageGlobalProps(Uri uri, Context context) {
        Map<String, Object> storageValues;
        IGlobalPropsInjectService iGlobalPropsInjectService = (IGlobalPropsInjectService) StandardServiceManager.INSTANCE.get(IGlobalPropsInjectService.class);
        if (context != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (iGlobalPropsInjectService != null && (storageValues = iGlobalPropsInjectService.getStorageValues(uri, context)) != null) {
                linkedHashMap.putAll(storageValues);
            }
            return linkedHashMap;
        }
        return new LinkedHashMap();
    }

    private final Map<String, Object> getUserDomainStorageGlobalProps(Uri uri, Context context) {
        Map<String, Object> userDomainStorageValues;
        IGlobalPropsInjectService iGlobalPropsInjectService = (IGlobalPropsInjectService) StandardServiceManager.INSTANCE.get(IGlobalPropsInjectService.class);
        if (context != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (iGlobalPropsInjectService != null && (userDomainStorageValues = iGlobalPropsInjectService.getUserDomainStorageValues(uri, context)) != null) {
                linkedHashMap.putAll(userDomainStorageValues);
            }
            return linkedHashMap;
        }
        return new LinkedHashMap();
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public void onLoadStart(String url, String sessionId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.mUrl = url;
        BulletContext context = BulletContextManager.INSTANCE.getInstance().getContext(sessionId);
        if (context == null) {
            return;
        }
        setBulletContext(context);
        setProviderFactory(ContextProviderManager.INSTANCE.getProviderFactory(getBulletContext().getSessionId()));
        this.isFirstScreen = true;
        if (globalColdStart) {
            HybridLogger.i$default(HybridLogger.INSTANCE, "XWebKit", "cold start this time", null, null, 12, null);
            this.isColdStart = true;
            globalColdStart = false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getBulletContext().getBulletGlobalLifeCycleListenerList());
        IBulletLoadLifeCycle bulletLoadLifeCycleListener = getBulletContext().getBulletLoadLifeCycleListener();
        if (bulletLoadLifeCycleListener != null) {
            arrayList.add(bulletLoadLifeCycleListener);
        }
        BulletContext bulletContext = getBulletContext();
        BulletWebContext webContext = bulletContext.getWebContext();
        WebEngineGlobalConfig webEngineGlobalConfig = new WebEngineGlobalConfig();
        List<String> packages = bulletContext.getSchemeContext().getPackages();
        if (packages == null) {
            packages = CollectionsKt.emptyList();
        }
        webEngineGlobalConfig.config(bulletContext, packages);
        webContext.setWebGlobalConfig(webEngineGlobalConfig);
        this.webViewDelegate.getWebViewClientDispatcher().clear();
        this.webViewDelegate.getWebChromeClientDispatcher().clear();
        this.javascriptInterfaceDelegates.clear();
        IJavascriptInterfaceDelegate iJavascriptInterfaceDelegate = (IJavascriptInterfaceDelegate) getProviderFactory().provideInstance(IJavascriptInterfaceDelegate.class);
        if (iJavascriptInterfaceDelegate != null) {
            this.javascriptInterfaceDelegates.add(iJavascriptInterfaceDelegate);
        }
        BulletWebViewClient bulletWebViewClient = (BulletWebViewClient) getProviderFactory().provideInstance(BulletWebViewClient.class);
        if (bulletWebViewClient != null) {
            this.webViewDelegate.getWebViewClientDispatcher().addWebViewClient(bulletWebViewClient);
        }
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public BulletContext getContext() {
        return getBulletContext();
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public void onLoadFail() {
        BulletLogger.INSTANCE.printCoreLog(getBulletContext().getSessionId(), "load failed", "XWebKit", LogLevel.E);
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public void release(IKitViewService kitViewService) {
        Intrinsics.checkNotNullParameter(kitViewService, "kitViewService");
        getProviderFactory().removeProvider(IESJsBridge.class);
        getProviderFactory().removeProvider(JsBridge2IESSupport.class);
        WebJsBridge webJsBridge = this.mWebJsBridge;
        if (webJsBridge != null) {
            webJsBridge.onDestroy();
        }
        this.mWebJsBridge = null;
        WebBDXBridge webBDXBridge = this.webBDXBridge;
        if (webBDXBridge != null) {
            webBDXBridge.release();
        }
        this.webViewDelegate.destroy();
        IBulletLoadLifeCycle bulletLoadLifeCycleListener = getBulletContext().getBulletLoadLifeCycleListener();
        if (bulletLoadLifeCycleListener != null) {
            Uri loadUri = getBulletContext().getLoadUri();
            if (loadUri == null) {
                loadUri = Uri.EMPTY;
            }
            Intrinsics.checkNotNullExpressionValue(loadUri, "bulletContext.loadUri ?: Uri.EMPTY");
            bulletLoadLifeCycleListener.onKitViewDestroy(loadUri, kitViewService, null);
        }
        IBridge3Registry bridge3Registry = getBulletContext().getBridge3Registry();
        if (bridge3Registry != null) {
            bridge3Registry.release();
        }
        IBridgeRegistry bridgeRegistry = getBulletContext().getBridgeRegistry();
        if (bridgeRegistry != null) {
            bridgeRegistry.release();
        }
        this.argusAdapter = null;
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public boolean bulletContextIsInitialized() {
        return this.bulletContext != null;
    }

    @Override // com.bytedance.ies.bullet.service.webkit.AbsWebKitDelegate
    public String injectUrl(String url) {
        StringListParam appendGlobalProps;
        Object obj;
        StringListParam appendGlobalProps2;
        List<? extends String> value;
        Context context;
        BooleanParam statusBar;
        BooleanParam needContainerId;
        Intrinsics.checkNotNullParameter(url, "url");
        Uri parse = Uri.parse(url);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        Uri.Builder buildUpon = parse.buildUpon();
        BDXWebKitModel webkitModel = getWebkitModel();
        boolean z = false;
        if ((webkitModel == null || (needContainerId = webkitModel.getNeedContainerId()) == null) ? false : Intrinsics.areEqual(needContainerId.getValue(), true)) {
            buildUpon.appendQueryParameter("container_id", getBulletContext().getSessionId());
        }
        BDXWebKitModel webkitModel2 = getWebkitModel();
        if (((webkitModel2 == null || (statusBar = webkitModel2.getStatusBar()) == null) ? false : Intrinsics.areEqual(statusBar.getValue(), true)) && (context = getBulletContext().getContext()) != null) {
            buildUpon.appendQueryParameter("status_bar_height", String.valueOf(px2dip(context, BaseStatusBarUtil.INSTANCE.getStatusBarHeight(context) + 0.0f)));
        }
        BDXWebKitModel webkitModel3 = getWebkitModel();
        if (webkitModel3 != null && (appendGlobalProps2 = webkitModel3.getAppendGlobalProps()) != null && (value = appendGlobalProps2.getValue()) != null && (!value.isEmpty())) {
            z = true;
        }
        if (z && HybridSecureUtil.INSTANCE.inCommonParamsAllowList(parse)) {
            this.aliasGlobalProps = null;
            getGlobalProps(parse);
            BDXWebKitModel webkitModel4 = getWebkitModel();
            if (webkitModel4 != null && (appendGlobalProps = webkitModel4.getAppendGlobalProps()) != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                List<? extends String> value2 = appendGlobalProps.getValue();
                if (value2 != null) {
                    for (String str : value2) {
                        Map<String, Object> map = this.aliasGlobalProps;
                        if (map != null && (obj = map.get(str)) != null) {
                            linkedHashMap.put(str, obj);
                        }
                    }
                }
                buildUpon.appendQueryParameter(SchemaConstants.APPENDED_GLOBAL_PROPS, new JSONObject(linkedHashMap).toString());
            }
        }
        String uri = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uri.build().toString()");
        return uri;
    }
}
