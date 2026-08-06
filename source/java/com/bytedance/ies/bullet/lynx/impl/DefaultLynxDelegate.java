package com.bytedance.ies.bullet.lynx.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import com.bytedance.ies.argus.api.ArgusLynxDelegate;
import com.bytedance.ies.argus.api.interfaces.service.ArgusBaseBizService;
import com.bytedance.ies.bullet.base.constants.GlobalPropertiesConstants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.HybridLoggerConst;
import com.bytedance.ies.bullet.core.BulletContainerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextKt;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.BulletLynxContext;
import com.bytedance.ies.bullet.core.BulletRLContext;
import com.bytedance.ies.bullet.core.BulletSchemeContext;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.core.IBulletLifeCycleV2;
import com.bytedance.ies.bullet.core.IBulletLoadLifeCycle;
import com.bytedance.ies.bullet.core.IEngineGlobalConfig;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.device.BulletDeviceUtils;
import com.bytedance.ies.bullet.core.device.PropsUtilsKt;
import com.bytedance.ies.bullet.core.event.UpdateDataEvent;
import com.bytedance.ies.bullet.core.event.UpdateGlobalPropsEvent;
import com.bytedance.ies.bullet.core.event.UpdateTemplateDataEvent;
import com.bytedance.ies.bullet.core.kit.bridge.Callback;
import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.kit.service.BaseBridgeService;
import com.bytedance.ies.bullet.core.kit.service.IBridgeService;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.core.model.context.IContextProvider;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.interaction.predefine.PredefineManager;
import com.bytedance.ies.bullet.kit.lynx.service.ILynxGlobalConfigService;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.kit.web.IWebSecureDelegate;
import com.bytedance.ies.bullet.lynx.AbsLynxDelegate;
import com.bytedance.ies.bullet.lynx.DefaultLynxParams;
import com.bytedance.ies.bullet.lynx.LynxAsyncLayoutParam;
import com.bytedance.ies.bullet.lynx.LynxClientDelegateChain;
import com.bytedance.ies.bullet.lynx.LynxImageInfo;
import com.bytedance.ies.bullet.lynx.LynxKitInitParams;
import com.bytedance.ies.bullet.lynx.LynxRenderCallback;
import com.bytedance.ies.bullet.lynx.LynxRouterCallback;
import com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule;
import com.bytedance.ies.bullet.lynx.element.LynxAnimaXHelper;
import com.bytedance.ies.bullet.lynx.init.LynxKitBase;
import com.bytedance.ies.bullet.lynx.model.LynxCommonData;
import com.bytedance.ies.bullet.lynx.model.LynxCommonDataKt;
import com.bytedance.ies.bullet.lynx.model.LynxModuleWrapper;
import com.bytedance.ies.bullet.lynx.util.JsonConvertHelper;
import com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactory;
import com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactoryKt;
import com.bytedance.ies.bullet.p003ui.common.utils.BulletPadAdapterUtil;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadHelper;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadLogger;
import com.bytedance.ies.bullet.secure.ArgusLynxDelegateAdapter;
import com.bytedance.ies.bullet.secure.SecureProviderFactory;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletPageUrl;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IEventHandler;
import com.bytedance.ies.bullet.service.base.IGlobalPropsInjectService;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.IPrefetchService;
import com.bytedance.ies.bullet.service.base.IPrefetchV2Service;
import com.bytedance.ies.bullet.service.base.IPrefetchV2ServiceKt;
import com.bytedance.ies.bullet.service.base.IPreloadV2Service;
import com.bytedance.ies.bullet.service.base.IPreloadV2ServiceKt;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.ITestService;
import com.bytedance.ies.bullet.service.base.PrefetchV2Data;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.api.IServiceCenter;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate;
import com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService;
import com.bytedance.ies.bullet.service.base.resourceloader.config.CustomLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.test.TNativeEvent;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.ies.bullet.service.monitor.deviceperf.ScrollInfo;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelTransformer;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.schema.model.BDXLynxKitModel;
import com.bytedance.ies.bullet.service.schema.model.BDXPageModel;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.FloatParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UrlParam;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxBehaviorWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxInitDataWrapper;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.optimize.ThreadOptConfig;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxConvertUtils;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxIDLCallbackWrapper;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.service.IAnnieProSupport;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxLoadMeta;
import com.lynx.tasm.LynxPerfMetric;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.behavior.ImageInterceptor;
import com.lynx.tasm.component.DynamicComponentFetcher;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.transform.Transformer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DefaultLynxDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0003\u000b\"6\b\u0016\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0081\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\n\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u00020%H\u0002J\b\u0010A\u001a\u00020%H\u0002J\b\u0010B\u001a\u00020CH\u0002J\u0014\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020E0;H\u0016J\u0014\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020<0GH\u0014J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0004J\u0010\u0010L\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010M\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010N\u001a\u0004\u0018\u00010OH\u0002J\b\u0010P\u001a\u0004\u0018\u00010-J\n\u0010Q\u001a\u0004\u0018\u00010RH\u0002J\b\u0010S\u001a\u00020\u0007H\u0002J\u0012\u0010T\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\n\u0010U\u001a\u0004\u0018\u00010\u000fH\u0002J\u001a\u0010V\u001a\u00020I2\u0006\u0010W\u001a\u00020X2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0010\u0010Y\u001a\u00020I2\u0006\u0010Z\u001a\u00020[H\u0016J\"\u0010\\\u001a\u00020I2\u0017\u0010]\u001a\u0013\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020I0^¢\u0006\u0002\b`H\u0082\bJ\b\u0010a\u001a\u00020'H\u0016J\u0016\u0010b\u001a\u00020I2\u0006\u0010W\u001a\u00020X2\u0006\u0010c\u001a\u00020dJ\u0010\u0010e\u001a\u00020I2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010f\u001a\u00020I2\u0006\u0010W\u001a\u00020gH\u0016J\u0018\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010k\u001a\b\u0012\u0004\u0012\u00020m0lH\u0016J\b\u0010n\u001a\u00020%H\u0016J\b\u0010o\u001a\u00020pH\u0016J\n\u0010q\u001a\u0004\u0018\u00010rH\u0016J\u0010\u0010s\u001a\u00020I2\u0006\u0010\u0002\u001a\u00020tH\u0016J\u0010\u0010u\u001a\u00020I2\u0006\u0010v\u001a\u00020wH\u0016J\u0010\u0010x\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0007H\u0016J\u0018\u0010y\u001a\u00020I2\u000e\u0010z\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030GH\u0002J \u0010{\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020<0;2\u0006\u0010|\u001a\u00020}H\u0002J+\u0010~\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020<0;2\u0006\u0010\u007f\u001a\u00020}2\t\u0010\u0004\u001a\u0005\u0018\u00010\u0080\u0001H\u0002R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00102\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0010\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0004\n\u0002\u00107R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020<\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/impl/DefaultLynxDelegate;", "Lcom/bytedance/ies/bullet/lynx/AbsLynxDelegate;", "service", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "sessionId", "", "(Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;Ljava/lang/String;)V", "(Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;)V", "annieProSupport", "com/bytedance/ies/bullet/lynx/impl/DefaultLynxDelegate$annieProSupport$1", "Lcom/bytedance/ies/bullet/lynx/impl/DefaultLynxDelegate$annieProSupport$1;", "annieXContainerSessionId", "argusAdapter", "Lcom/bytedance/ies/bullet/secure/ArgusLynxDelegateAdapter;", "getArgusAdapter", "()Lcom/bytedance/ies/bullet/secure/ArgusLynxDelegateAdapter;", "argusAdapter$delegate", "Lkotlin/Lazy;", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getBulletContext", "()Lcom/bytedance/ies/bullet/core/BulletContext;", "setBulletContext", "(Lcom/bytedance/ies/bullet/core/BulletContext;)V", "containerModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXContainerModel;", "getContainerModel", "()Lcom/bytedance/ies/bullet/service/schema/model/BDXContainerModel;", "getContext", "()Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "debugInitialData", "eventHandler", "com/bytedance/ies/bullet/lynx/impl/DefaultLynxDelegate$eventHandler$1", "Lcom/bytedance/ies/bullet/lynx/impl/DefaultLynxDelegate$eventHandler$1;", "innerLynxKitInitParams", "Lcom/bytedance/ies/bullet/lynx/LynxKitInitParams;", GlobalPropertiesConstants.IS_COLD_START, "", "kitModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXLynxKitModel;", "getKitModel", "()Lcom/bytedance/ies/bullet/service/schema/model/BDXLynxKitModel;", "lynxBDXBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;", "getLynxBDXBridge", "()Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;", "setLynxBDXBridge", "(Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;)V", "lynxInitParams", "getLynxInitParams", "()Lcom/bytedance/ies/bullet/lynx/LynxKitInitParams;", "lynxRenderCallback", "com/bytedance/ies/bullet/lynx/impl/DefaultLynxDelegate$lynxRenderCallback$1", "Lcom/bytedance/ies/bullet/lynx/impl/DefaultLynxDelegate$lynxRenderCallback$1;", "resourceInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "rootPageGlobalProps", "", "", "useXBridge3", "createEventHandler", "Lcom/bytedance/ies/bullet/service/base/IEventHandler;", "createInitParams", "createInitParamsMiddle", "createLynxClientDelegate", "Lcom/lynx/tasm/LynxViewClient;", "createLynxModule", "Lcom/bytedance/ies/bullet/lynx/model/LynxModuleWrapper;", "generateGlobalProps", "", "generateSchemaModel", "", "data", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "generateSchemaModelOpt", "getDebugUrl", "getDynamicComponentFetcher", "Lcom/lynx/tasm/component/DynamicComponentFetcher;", "getLynxBDXBridgeApi", "getLynxEngineConfig", "Lcom/bytedance/ies/bullet/lynx/impl/LynxEngineGlobalConfig;", "getNamespace", "getSourceUrl", "initSecureDelegate", "initSecureDep", "view", "Lcom/lynx/tasm/LynxView;", "injectLynxBuilder", "viewBuilder", "Lcom/lynx/tasm/LynxViewBuilder;", "lynxClientRunSafe", "handler", "Lkotlin/Function1;", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "Lkotlin/ExtensionFunctionType;", "onBackPressed", "onEvent", ISignalReportService.BODY_KEY_EVENT, "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "onLoadStart", "onLynxViewCreated", "Landroid/view/View;", "parseSchema", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "url", "provideBehavior", "", "Lcom/lynx/tasm/behavior/Behavior;", "provideLynxInitParams", "provideRenderCallback", "Lcom/bytedance/ies/bullet/lynx/LynxRenderCallback;", "provideTemplateData", "Lcom/lynx/tasm/TemplateData;", "registerSecureService", "Lcom/bytedance/ies/argus/api/interfaces/service/ArgusBaseBizService;", "release", "kitViewService", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "setDebugInitialData", "updateGlobalPropsByDiff", "diffProps", "putQueryItems", "input", "Landroid/net/Uri;", "putStorageGlobalProps", "uri", "Landroid/content/Context;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DefaultLynxDelegate extends AbsLynxDelegate {
    public static final String POSTFIX_CANVAS = "_canvas";
    private final DefaultLynxDelegate$annieProSupport$1 annieProSupport;
    private String annieXContainerSessionId;

    /* renamed from: argusAdapter$delegate, reason: from kotlin metadata */
    private final Lazy argusAdapter;
    private BulletContext bulletContext;
    private final IServiceToken context;
    private String debugInitialData;
    private final DefaultLynxDelegate$eventHandler$1 eventHandler;
    private LynxKitInitParams innerLynxKitInitParams;
    private boolean isColdStart;
    private LynxBDXBridge lynxBDXBridge;
    private final DefaultLynxDelegate$lynxRenderCallback$1 lynxRenderCallback;
    private ResourceInfo resourceInfo;
    private Map<String, Object> rootPageGlobalProps;
    private boolean useXBridge3;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile boolean globalColdStart = true;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$eventHandler$1] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$annieProSupport$1] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$lynxRenderCallback$1] */
    public DefaultLynxDelegate(final BaseBulletService baseBulletService, IServiceToken iServiceToken) {
        super(baseBulletService);
        Intrinsics.checkNotNullParameter(baseBulletService, "service");
        Intrinsics.checkNotNullParameter(iServiceToken, "context");
        this.context = iServiceToken;
        this.eventHandler = new IEventHandler() { // from class: com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$eventHandler$1
            @Override // com.bytedance.ies.bullet.service.base.IEventHandler
            public void sendEvent(final String eventName, final Object params, View view) {
                Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
                if (view instanceof LynxView) {
                    DefaultLynxDelegate.this.onEvent((LynxView) view, new IEvent(eventName, params) { // from class: com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$eventHandler$1$sendEvent$1
                        private final String name;
                        private final Object params;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.name = eventName;
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
        };
        this.annieProSupport = new IAnnieProSupport() { // from class: com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$annieProSupport$1
            public String getAnnieAppID() {
                String value;
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                return (bulletContext == null || (value = new StringParam(bulletContext.getSchemaModelUnion().getSchemaData(), "app_id", "").getValue()) == null) ? "" : value;
            }
        };
        this.argusAdapter = LazyKt.lazy(new Function0<ArgusLynxDelegateAdapter>() { // from class: com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$argusAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ArgusLynxDelegateAdapter m518invoke() {
                ArgusLynxDelegateAdapter initSecureDelegate;
                initSecureDelegate = DefaultLynxDelegate.this.initSecureDelegate();
                return initSecureDelegate;
            }
        });
        this.lynxRenderCallback = new LynxRenderCallback() { // from class: com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$lynxRenderCallback$1
            @Override // com.bytedance.ies.bullet.lynx.LynxRenderCallback
            public TaskConfig provideTaskConfig() {
                BDXLynxKitModel kitModel;
                String str;
                BDXLynxKitModel kitModel2;
                BDXLynxKitModel kitModel3;
                String sourceUrl;
                BDXLynxKitModel kitModel4;
                Integer num;
                String str2;
                IntegerParam dynamic;
                StringParam bundlePath;
                String value;
                StringParam channel;
                BulletRLContext resourceContext;
                CustomLoaderConfig customLoaderConfig = null;
                TaskConfig taskConfig = new TaskConfig(null, 1, null);
                DefaultLynxDelegate defaultLynxDelegate = DefaultLynxDelegate.this;
                CustomLoaderConfig.Companion companion = CustomLoaderConfig.INSTANCE;
                BulletContext bulletContext = defaultLynxDelegate.getBulletContext();
                if (bulletContext != null && (resourceContext = bulletContext.getResourceContext()) != null) {
                    customLoaderConfig = resourceContext.getCustomLoaderConfig();
                }
                CustomLoaderConfig from = companion.from(customLoaderConfig);
                if (from == null) {
                    from = new CustomLoaderConfig(false);
                }
                taskConfig.setLoaderConfig(from);
                kitModel = defaultLynxDelegate.getKitModel();
                String str3 = "";
                if (kitModel == null || (channel = kitModel.getChannel()) == null || (str = channel.getValue()) == null) {
                    str = "";
                }
                taskConfig.setChannel(str);
                kitModel2 = defaultLynxDelegate.getKitModel();
                if (kitModel2 != null && (bundlePath = kitModel2.getBundlePath()) != null && (value = bundlePath.getValue()) != null) {
                    str3 = value;
                }
                taskConfig.setBundle(str3);
                kitModel3 = defaultLynxDelegate.getKitModel();
                sourceUrl = defaultLynxDelegate.getSourceUrl(kitModel3);
                taskConfig.setCdnUrl(sourceUrl);
                taskConfig.setTaskContext(TaskContext.INSTANCE.from(defaultLynxDelegate.getContext().getAllDependency()));
                kitModel4 = defaultLynxDelegate.getKitModel();
                if (kitModel4 == null || (dynamic = kitModel4.getDynamic()) == null || (num = dynamic.getValue()) == null) {
                    num = 0;
                }
                taskConfig.setDynamic(num);
                BulletContext bulletContext2 = defaultLynxDelegate.getBulletContext();
                if (bulletContext2 == null || (str2 = bulletContext2.getBid()) == null) {
                    str2 = "default_bid";
                }
                taskConfig.setMonitorBid(str2);
                taskConfig.setResTag("template");
                return taskConfig;
            }

            @Override // com.bytedance.ies.bullet.lynx.LynxRenderCallback
            public void beforeLoadTemplate() {
                AbsBulletMonitorCallback monitorCallback;
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                if (bulletContext == null || (monitorCallback = bulletContext.getMonitorCallback()) == null) {
                    return;
                }
                monitorCallback.onPrepareTemplateBegin();
            }

            @Override // com.bytedance.ies.bullet.lynx.LynxRenderCallback
            public void beforeLoadTemplateWithUrl(String url) {
                IBulletLifeCycleV2 iBulletLifeCycleV2;
                Intrinsics.checkNotNullParameter(url, "url");
                super.beforeLoadTemplateWithUrl(url);
                ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                IContextProvider provider = contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null).getProvider(IBulletLifeCycleV2.class);
                if (provider == null || (iBulletLifeCycleV2 = (IBulletLifeCycleV2) provider.provideInstance()) == null) {
                    return;
                }
                iBulletLifeCycleV2.beforeLoadTemplateWithUrl(url);
            }

            @Override // com.bytedance.ies.bullet.lynx.LynxRenderCallback
            public void loadTemplateReady(ResourceInfo resourceInfo) {
                IBridgeRegistry bridgeRegistry;
                IBridgeRegistry bridgeRegistry2;
                IBulletLifeCycleV2 iBulletLifeCycleV2;
                AbsBulletMonitorCallback monitorCallback;
                Intrinsics.checkNotNullParameter(resourceInfo, "resourceInfo");
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                BulletRLContext resourceContext = bulletContext != null ? bulletContext.getResourceContext() : null;
                if (resourceContext != null) {
                    resourceContext.setResFrom(resourceInfo.getStatisticFrom());
                }
                if (LoaderUtil.INSTANCE.isNotNullOrEmpty(resourceInfo.getFilePath())) {
                    BulletContext bulletContext2 = DefaultLynxDelegate.this.getBulletContext();
                    BulletRLContext resourceContext2 = bulletContext2 != null ? bulletContext2.getResourceContext() : null;
                    if (resourceContext2 != null) {
                        LoaderUtil loaderUtil = LoaderUtil.INSTANCE;
                        String filePath = resourceInfo.getFilePath();
                        Intrinsics.checkNotNull(filePath);
                        resourceContext2.setResSize(loaderUtil.getFileSize(new File(filePath)) / 1024.0f);
                    }
                }
                BulletContext bulletContext3 = DefaultLynxDelegate.this.getBulletContext();
                BulletRLContext resourceContext3 = bulletContext3 != null ? bulletContext3.getResourceContext() : null;
                if (resourceContext3 != null) {
                    resourceContext3.setResVersion(resourceInfo.getVersion());
                }
                BulletContext bulletContext4 = DefaultLynxDelegate.this.getBulletContext();
                BulletRLContext resourceContext4 = bulletContext4 != null ? bulletContext4.getResourceContext() : null;
                if (resourceContext4 != null) {
                    resourceContext4.setResMemory(resourceInfo.getIsFromMemory());
                }
                BulletContext bulletContext5 = DefaultLynxDelegate.this.getBulletContext();
                if (bulletContext5 != null && (monitorCallback = bulletContext5.getMonitorCallback()) != null) {
                    monitorCallback.onPrepareTemplateEnd();
                }
                ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
                BulletContext bulletContext6 = DefaultLynxDelegate.this.getBulletContext();
                IContextProvider provider = contextProviderManager.getProviderFactory(bulletContext6 != null ? bulletContext6.getSessionId() : null).getProvider(IBulletLifeCycleV2.class);
                if (provider != null && (iBulletLifeCycleV2 = (IBulletLifeCycleV2) provider.provideInstance()) != null) {
                    iBulletLifeCycleV2.loadTemplateReady(resourceInfo);
                }
                DefaultLynxDelegate.this.resourceInfo = resourceInfo;
                ContextProviderManager contextProviderManager2 = ContextProviderManager.INSTANCE;
                BulletContext bulletContext7 = DefaultLynxDelegate.this.getBulletContext();
                ContextProviderFactory providerFactory = contextProviderManager2.getProviderFactory(bulletContext7 != null ? bulletContext7.getSessionId() : null);
                IPrefetchService iPrefetchService = (IPrefetchService) baseBulletService.getService(IPrefetchService.class);
                if (iPrefetchService != null) {
                    DefaultLynxDelegate defaultLynxDelegate = DefaultLynxDelegate.this;
                    Object providePrefetchBridge$default = IPrefetchService.DefaultImpls.providePrefetchBridge$default(iPrefetchService, providerFactory, null, 2, null);
                    Intrinsics.checkNotNull(providePrefetchBridge$default, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod");
                    IGenericBridgeMethod iGenericBridgeMethod = (IGenericBridgeMethod) providePrefetchBridge$default;
                    if (BulletContextKt.useXBride3(defaultLynxDelegate.getBulletContext())) {
                        return;
                    }
                    BulletContext bulletContext8 = defaultLynxDelegate.getBulletContext();
                    if (bulletContext8 != null && (bridgeRegistry2 = bulletContext8.getBridgeRegistry()) != null) {
                        bridgeRegistry2.addBridge(iGenericBridgeMethod);
                    }
                    BulletContext bulletContext9 = defaultLynxDelegate.getBulletContext();
                    if (bulletContext9 == null || (bridgeRegistry = bulletContext9.getBridgeRegistry()) == null) {
                        return;
                    }
                    Object providePrefetchBridge = iPrefetchService.providePrefetchBridge(providerFactory, "bullet.prefetch");
                    Intrinsics.checkNotNull(providePrefetchBridge, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod");
                    bridgeRegistry.addBridge((IGenericBridgeMethod) providePrefetchBridge);
                }
            }

            @Override // com.bytedance.ies.bullet.lynx.LynxRenderCallback
            public void loadTemplateError(Throwable error) {
                Uri loadUri;
                BulletContext bulletContext;
                IBulletLoadLifeCycle bulletLoadLifeCycleListener;
                IBulletLifeCycleV2 iBulletLifeCycleV2;
                ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
                BulletContext bulletContext2 = DefaultLynxDelegate.this.getBulletContext();
                IContextProvider provider = contextProviderManager.getProviderFactory(bulletContext2 != null ? bulletContext2.getSessionId() : null).getProvider(IBulletLifeCycleV2.class);
                if (provider != null && (iBulletLifeCycleV2 = (IBulletLifeCycleV2) provider.provideInstance()) != null) {
                    iBulletLifeCycleV2.loadTemplateError(error);
                }
                BulletContext bulletContext3 = DefaultLynxDelegate.this.getBulletContext();
                if (bulletContext3 == null || (loadUri = bulletContext3.getLoadUri()) == null || (bulletContext = DefaultLynxDelegate.this.getBulletContext()) == null || (bulletLoadLifeCycleListener = bulletContext.getBulletLoadLifeCycleListener()) == null) {
                    return;
                }
                if (error == null) {
                    error = new Throwable("loadTemplateError");
                }
                bulletLoadLifeCycleListener.onLoadFail(loadUri, error);
            }

            @Override // com.bytedance.ies.bullet.lynx.LynxRenderCallback
            public void loadTemplateError(String url, Throwable error) {
                IBulletLifeCycleV2 iBulletLifeCycleV2;
                Intrinsics.checkNotNullParameter(url, "url");
                super.loadTemplateError(url, error);
                ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                IContextProvider provider = contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null).getProvider(IBulletLifeCycleV2.class);
                if (provider == null || (iBulletLifeCycleV2 = (IBulletLifeCycleV2) provider.provideInstance()) == null) {
                    return;
                }
                iBulletLifeCycleV2.loadTemplateError(error);
            }

            @Override // com.bytedance.ies.bullet.lynx.LynxRenderCallback
            public void beforeReadTemplate() {
                AbsBulletMonitorCallback monitorCallback;
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                if (bulletContext == null || (monitorCallback = bulletContext.getMonitorCallback()) == null) {
                    return;
                }
                monitorCallback.onLynxReadTemplateBegin();
            }

            @Override // com.bytedance.ies.bullet.lynx.LynxRenderCallback
            public void afterReadTemplate(String url, byte[] lynxFile, IBulletLifeCycle listener) {
                ArgusLynxDelegateAdapter argusAdapter;
                ResourceInfo resourceInfo;
                AbsBulletMonitorCallback monitorCallback;
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(lynxFile, "lynxFile");
                Intrinsics.checkNotNullParameter(listener, "listener");
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                if (bulletContext != null && (monitorCallback = bulletContext.getMonitorCallback()) != null) {
                    monitorCallback.onLynxReadTemplateEnd();
                }
                argusAdapter = DefaultLynxDelegate.this.getArgusAdapter();
                if (argusAdapter != null) {
                    resourceInfo = DefaultLynxDelegate.this.resourceInfo;
                    argusAdapter.onLoadTemplate(resourceInfo, true, DefaultLynxParams.DEFAULT_LYNX_GROUP_NAME);
                }
            }

            @Override // com.bytedance.ies.bullet.lynx.LynxRenderCallback
            public void beforeRender() {
                AbsBulletMonitorCallback monitorCallback;
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                if (bulletContext == null || (monitorCallback = bulletContext.getMonitorCallback()) == null) {
                    return;
                }
                monitorCallback.onLynxRenderTemplateBegin();
            }

            @Override // com.bytedance.ies.bullet.lynx.LynxRenderCallback
            public void afterRender() {
                AbsBulletMonitorCallback monitorCallback;
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                if (bulletContext == null || (monitorCallback = bulletContext.getMonitorCallback()) == null) {
                    return;
                }
                monitorCallback.onLynxRenderTemplateEnd();
            }
        };
    }

    public final IServiceToken getContext() {
        return this.context;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultLynxDelegate(BaseBulletService baseBulletService, IServiceToken iServiceToken, String str) {
        this(baseBulletService, iServiceToken);
        Intrinsics.checkNotNullParameter(baseBulletService, "service");
        Intrinsics.checkNotNullParameter(iServiceToken, "context");
        Intrinsics.checkNotNullParameter(str, "sessionId");
        this.annieXContainerSessionId = str;
        BulletContext context = BulletContextManager.INSTANCE.getInstance().getContext(str);
        this.bulletContext = context;
        this.useXBridge3 = context != null ? BulletContextKt.useXBride3(context) : false;
    }

    public LynxBDXBridge getLynxBDXBridge() {
        return this.lynxBDXBridge;
    }

    public void setLynxBDXBridge(LynxBDXBridge lynxBDXBridge) {
        this.lynxBDXBridge = lynxBDXBridge;
    }

    private final LynxKitInitParams getLynxInitParams() {
        return createInitParamsMiddle();
    }

    public final BulletContext getBulletContext() {
        return this.bulletContext;
    }

    public final void setBulletContext(BulletContext bulletContext) {
        this.bulletContext = bulletContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BDXLynxKitModel getKitModel() {
        SchemaModelUnion schemaModelUnion;
        BulletContext bulletContext = this.bulletContext;
        ISchemaModel kitModel = (bulletContext == null || (schemaModelUnion = bulletContext.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getKitModel();
        if (kitModel instanceof BDXLynxKitModel) {
            return (BDXLynxKitModel) kitModel;
        }
        return null;
    }

    private final BDXContainerModel getContainerModel() {
        SchemaModelUnion schemaModelUnion;
        BulletContext bulletContext = this.bulletContext;
        ISchemaModel containerModel = (bulletContext == null || (schemaModelUnion = bulletContext.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getContainerModel();
        if (containerModel instanceof BDXContainerModel) {
            return (BDXContainerModel) containerModel;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArgusLynxDelegateAdapter getArgusAdapter() {
        return (ArgusLynxDelegateAdapter) this.argusAdapter.getValue();
    }

    /* compiled from: DefaultLynxDelegate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/impl/DefaultLynxDelegate$Companion;", "", "()V", "POSTFIX_CANVAS", "", "globalColdStart", "", "getGlobalColdStart", "()Z", "setGlobalColdStart", "(Z)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getGlobalColdStart() {
            return DefaultLynxDelegate.globalColdStart;
        }

        public final void setGlobalColdStart(boolean z) {
            DefaultLynxDelegate.globalColdStart = z;
        }
    }

    private final String getNamespace() {
        BulletContext bulletContext = this.bulletContext;
        return Intrinsics.areEqual(bulletContext != null ? bulletContext.getBid() : null, BidConstants.WEBCAST) ? BidConstants.WEBCAST : "";
    }

    public final LynxBDXBridge getLynxBDXBridgeApi() {
        return getLynxBDXBridge();
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public SchemaModelUnion parseSchema(String url, String sessionId) {
        ISchemaData generateSchemaData;
        SchemaModelUnion schemaModelUnion;
        SchemaModelUnion schemaModelUnion2;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext == null || (schemaModelUnion2 = bulletContext.getSchemaModelUnion()) == null || (generateSchemaData = schemaModelUnion2.getSchemaData()) == null) {
            SchemaService companion = SchemaService.INSTANCE.getInstance();
            String bid = getService().getBid();
            Uri parse = Uri.parse(url);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
            generateSchemaData = companion.generateSchemaData(bid, parse);
        }
        if (IConditionCallKt.enableMixLogic()) {
            generateSchemaModelOpt(generateSchemaData);
        } else {
            generateSchemaModel(generateSchemaData);
        }
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 != null && (schemaModelUnion = bulletContext2.getSchemaModelUnion()) != null) {
            return schemaModelUnion;
        }
        SchemaService companion2 = SchemaService.INSTANCE.getInstance();
        String bid2 = getService().getBid();
        Uri parse2 = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(parse2, "parse(url)");
        return new SchemaModelUnion(companion2.generateSchemaData(bid2, parse2));
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public LynxKitInitParams provideLynxInitParams() {
        return getLynxInitParams();
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public List<Behavior> provideBehavior() {
        List<Object> behaviors;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        LynxEngineGlobalConfig lynxEngineConfig = getLynxEngineConfig();
        if (lynxEngineConfig != null && (behaviors = lynxEngineConfig.getBehaviors()) != null) {
            for (Object obj : behaviors) {
                if (obj instanceof Behavior) {
                    arrayList.add(obj);
                } else if (obj instanceof LynxBehaviorWrapper) {
                    arrayList.add(LynxBehaviorFactory.INSTANCE.createLynxBehavior((LynxBehaviorWrapper) obj));
                } else {
                    arrayList2.add(String.valueOf(obj));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public LynxRenderCallback provideRenderCallback() {
        return this.lynxRenderCallback;
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public TemplateData provideTemplateData() {
        JSONObject jSONObject;
        BulletLoadUriIdentifier uriIdentifier;
        JSONObject jSONObject2;
        Uri uri;
        Boolean value;
        String str;
        BDXLynxKitModel kitModel;
        StringParam initData;
        String value2;
        BulletLynxContext lynxContext;
        LynxInitDataWrapper initDataWrapper;
        BulletContext bulletContext = this.bulletContext;
        TemplateData templateData = (bulletContext == null || (lynxContext = bulletContext.getLynxContext()) == null || (initDataWrapper = lynxContext.getInitDataWrapper()) == null) ? null : LynxBehaviorFactoryKt.toTemplateData(initDataWrapper);
        if (templateData == null && (kitModel = getKitModel()) != null && (initData = kitModel.getInitData()) != null && (value2 = initData.getValue()) != null) {
            templateData = LynxBehaviorFactoryKt.toTemplateData(LynxInitDataWrapper.INSTANCE.fromString(value2));
        }
        if (templateData == null && (str = this.debugInitialData) != null) {
            templateData = LynxBehaviorFactoryKt.toTemplateData(LynxInitDataWrapper.INSTANCE.fromString(str));
        }
        BulletContext bulletContext2 = this.bulletContext;
        boolean z = !((bulletContext2 == null || (value = new BooleanParam(bulletContext2.getSchemaModelUnion().getSchemaData(), SchemaConstants.ENABLE_PREFETCH_V2, false).getValue()) == null) ? false : value.booleanValue());
        if (templateData != null || !z) {
            return templateData;
        }
        IPrefetchService iPrefetchService = (IPrefetchService) getService().getService(IPrefetchService.class);
        if (iPrefetchService != null) {
            BulletContext bulletContext3 = this.bulletContext;
            if (bulletContext3 == null || (uri = bulletContext3.getLoadUri()) == null) {
                uri = Uri.EMPTY;
            }
            Intrinsics.checkNotNullExpressionValue(uri, "bulletContext?.loadUri ?: Uri.EMPTY");
            jSONObject = iPrefetchService.getCacheByScheme(uri);
        } else {
            jSONObject = null;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject != null) {
            jSONObject3.put("prefetchInitData", jSONObject);
        }
        BulletContext bulletContext4 = this.bulletContext;
        if (bulletContext4 != null && (uriIdentifier = bulletContext4.getUriIdentifier()) != null) {
            Uri parse = Uri.parse(uriIdentifier.getIdentifierUrl());
            IPrefetchService iPrefetchService2 = (IPrefetchService) getService().getService(IPrefetchService.class);
            if (iPrefetchService2 != null) {
                Intrinsics.checkNotNullExpressionValue(parse, "uri");
                jSONObject2 = iPrefetchService2.getCacheByScheme(parse);
            } else {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "using localInitData", null, null, 6, null);
                ExtKt.merge$default(jSONObject3, jSONObject2, false, 2, null);
            }
        }
        return LynxBehaviorFactoryKt.toTemplateData(LynxInitDataWrapper.INSTANCE.fromString(String.valueOf(jSONObject3)));
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public void onLynxViewCreated(View view) {
        String str;
        String str2;
        AbsBulletMonitorCallback monitorCallback;
        LynxBDXBridge lynxBDXBridge;
        IBridgeService iBridgeService;
        ISchemaData schemaData;
        List<IDLXBridgeMethod> createStatefulBridges;
        MethodFinder createFirstFinder;
        LynxBDXBridge lynxBDXBridge2;
        AbsBulletMonitorCallback monitorCallback2;
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.useXBridge3 && (view instanceof LynxView)) {
            BulletContext bulletContext = this.bulletContext;
            if (bulletContext != null && (monitorCallback2 = bulletContext.getMonitorCallback()) != null) {
                monitorCallback2.onJsbRegisterBegin();
            }
            ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
            BulletContext bulletContext2 = this.bulletContext;
            ContextProviderFactory providerFactory = contextProviderManager.getProviderFactory(bulletContext2 != null ? bulletContext2.getSessionId() : null);
            IBridgeService iBridgeService2 = (IBridgeService) ServiceCenter.INSTANCE.instance().get("default_bid", IBridgeService.class);
            if (iBridgeService2 != null) {
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "DefaultLynxDelegate.onLynxViewCreated, createMethodFinder from " + iBridgeService2.getClass().getName(), null, null, 6, null);
                for (MethodFinder methodFinder : iBridgeService2.createMethodFinder(providerFactory)) {
                    LynxBDXBridge lynxBDXBridge3 = getLynxBDXBridge();
                    if (lynxBDXBridge3 != null) {
                        lynxBDXBridge3.addCustomMethodFinder(methodFinder);
                    }
                }
                if ((iBridgeService2 instanceof BaseBridgeService) && (createFirstFinder = ((BaseBridgeService) iBridgeService2).createFirstFinder(providerFactory)) != null && (lynxBDXBridge2 = getLynxBDXBridge()) != null) {
                    lynxBDXBridge2.addCustomMethodFinder(createFirstFinder, 0);
                }
            }
            IServiceCenter instance = ServiceCenter.INSTANCE.instance();
            BulletContext bulletContext3 = this.bulletContext;
            if (bulletContext3 == null || (str = bulletContext3.getBid()) == null) {
                str = "default_bid";
            }
            IBridgeService iBridgeService3 = (IBridgeService) instance.get(str, IBridgeService.class);
            BaseBridgeService baseBridgeService = iBridgeService3 instanceof BaseBridgeService ? (BaseBridgeService) iBridgeService3 : null;
            if (baseBridgeService != null) {
                baseBridgeService.beforePageRender(providerFactory);
            }
            IServiceCenter instance2 = ServiceCenter.INSTANCE.instance();
            BulletContext bulletContext4 = this.bulletContext;
            if (bulletContext4 == null || (str2 = bulletContext4.getBid()) == null) {
                str2 = "default_bid";
            }
            IBridgeService iBridgeService4 = (IBridgeService) instance2.get(str2, IBridgeService.class);
            BaseBridgeService baseBridgeService2 = iBridgeService4 instanceof BaseBridgeService ? (BaseBridgeService) iBridgeService4 : null;
            if (baseBridgeService2 != null && (createStatefulBridges = baseBridgeService2.createStatefulBridges(providerFactory)) != null) {
                for (IDLXBridgeMethod iDLXBridgeMethod : createStatefulBridges) {
                    LynxBDXBridge lynxBDXBridge4 = getLynxBDXBridge();
                    if (lynxBDXBridge4 != null) {
                        lynxBDXBridge4.registerStatefulMethod(iDLXBridgeMethod);
                    }
                }
            }
            providerFactory.registerWeakHolder(LynxView.class, view);
            LynxBDXBridge lynxBDXBridge5 = getLynxBDXBridge();
            if (lynxBDXBridge5 != null) {
                lynxBDXBridge5.init((LynxView) view);
            }
            BulletContext bulletContext5 = this.bulletContext;
            Uri innerOriginUrl = (bulletContext5 == null || (schemaData = bulletContext5.getSchemaData()) == null) ? null : schemaData.getInnerOriginUrl();
            if (Intrinsics.areEqual(innerOriginUrl != null ? innerOriginUrl.getQueryParameter(SchemaConstants.ENABLE_ANNIE_JSB_FOR_COMMON) : null, "1") && (iBridgeService = (IBridgeService) ServiceCenter.INSTANCE.instance().get("default_bid", IBridgeService.class)) != null && (iBridgeService instanceof BaseBridgeService)) {
                WebcastContainerInitializer webcastContainerInitializer = new WebcastContainerInitializer();
                BulletContext bulletContext6 = this.bulletContext;
                Intrinsics.checkNotNull(bulletContext6);
                LynxBDXBridge lynxBDXBridge6 = getLynxBDXBridge();
                Intrinsics.checkNotNull(lynxBDXBridge6);
                webcastContainerInitializer.initializeWithBulletContextInLynx(bulletContext6, view, lynxBDXBridge6, providerFactory, this.eventHandler);
            }
            LynxBDXBridge lynxBDXBridge7 = getLynxBDXBridge();
            if (lynxBDXBridge7 != null) {
                lynxBDXBridge7.registerService(ContextProviderFactory.class, providerFactory);
            }
            BulletContext bulletContext7 = this.bulletContext;
            if (bulletContext7 != null && (lynxBDXBridge = getLynxBDXBridge()) != null) {
                lynxBDXBridge.registerService(BulletContext.class, bulletContext7);
            }
            LynxBDXBridge lynxBDXBridge8 = getLynxBDXBridge();
            if (lynxBDXBridge8 != null) {
                lynxBDXBridge8.registerService(IAnnieProSupport.class, this.annieProSupport);
            }
            BulletContext bulletContext8 = this.bulletContext;
            if (bulletContext8 != null) {
                bulletContext8.setBridge3Registry(new IBridge3Registry() { // from class: com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$onLynxViewCreated$7
                    @Override // com.bytedance.ies.bullet.service.base.IReleasable
                    public void release() {
                    }

                    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry
                    public void handle(String methodName, JSONObject params, final Callback callBack) {
                        String str3;
                        Intrinsics.checkNotNullParameter(methodName, "methodName");
                        LynxBDXBridge lynxBDXBridge9 = DefaultLynxDelegate.this.getLynxBDXBridge();
                        if (lynxBDXBridge9 != null) {
                            if (params == null) {
                                params = new JSONObject();
                            }
                            ReadableMap convertJsonToJavaOnlyMap$default = LynxConvertUtils.convertJsonToJavaOnlyMap$default(params, 0, 2, (Object) null);
                            LynxView lynxView = lynxBDXBridge9.getLynxBridgeContext().getLynxView();
                            if (lynxView == null || (str3 = lynxView.getTemplateUrl()) == null) {
                                str3 = "";
                            }
                            Intrinsics.checkNotNullExpressionValue(str3, "it.lynxBridgeContext.get…View()?.templateUrl ?: \"\"");
                            BaseBridgeCall lynxBridgeCall = new LynxBridgeCall(methodName, convertJsonToJavaOnlyMap$default, str3);
                            lynxBDXBridge9.handleCall(lynxBridgeCall, new LynxIDLCallbackWrapper(new com.lynx.react.bridge.Callback() { // from class: com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$onLynxViewCreated$7$handle$1$1
                                public void invoke(Object... args) {
                                    Intrinsics.checkNotNullParameter(args, "args");
                                    Callback callback = Callback.this;
                                    if (callback != null) {
                                        callback.invoke(args);
                                    }
                                }
                            }, lynxBridgeCall, lynxBDXBridge9.getLynxBridgeContext()));
                        }
                    }
                });
            }
            initSecureDep((LynxView) view, getLynxBDXBridge());
            BulletContext bulletContext9 = this.bulletContext;
            if (bulletContext9 == null || (monitorCallback = bulletContext9.getMonitorCallback()) == null) {
                return;
            }
            monitorCallback.onJsbRegisterEnd();
        }
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public void injectLynxBuilder(LynxViewBuilder viewBuilder) {
        BooleanParam enableLynxAir;
        BooleanParam enableAnimaX;
        BooleanParam enablePendingJsTask;
        BulletLoadUriIdentifier uriIdentifier;
        String identifierUrl;
        BooleanParam useCodeCache;
        SchemaModelUnion schemaModelUnion;
        String str;
        Object obj;
        LynxBDXBridge lynxBDXBridge;
        BulletSettings provideBulletSettings;
        LynxBDXBridge lynxBDXBridge2;
        LynxBDXBridge lynxBDXBridge3;
        Context context;
        Intrinsics.checkNotNullParameter(viewBuilder, "viewBuilder");
        Boolean bool = null;
        if (this.useXBridge3) {
            BulletContext bulletContext = this.bulletContext;
            if (bulletContext == null || (str = bulletContext.getSessionId()) == null) {
                str = "";
            }
            HybridLogger hybridLogger = HybridLogger.INSTANCE;
            StringBuilder append = new StringBuilder("sessionId = ").append(str).append(", context = ");
            BulletContext bulletContext2 = this.bulletContext;
            if (bulletContext2 == null || (obj = bulletContext2.getContext()) == null) {
                obj = "null";
            }
            HybridLogger.i$default(hybridLogger, "XLynxKit", append.append(obj).toString(), null, null, 12, null);
            BulletContext bulletContext3 = this.bulletContext;
            setLynxBDXBridge((bulletContext3 == null || (context = bulletContext3.getContext()) == null) ? null : new LynxBDXBridge(context, str, getNamespace()));
            BulletContext bulletContext4 = this.bulletContext;
            if (Intrinsics.areEqual(bulletContext4 != null ? bulletContext4.getBid() : null, BidConstants.WEBCAST) && (lynxBDXBridge3 = getLynxBDXBridge()) != null) {
                lynxBDXBridge3.setUnSupportNamespace("host");
            }
            ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
            if (iSettingService != null && (provideBulletSettings = iSettingService.provideBulletSettings()) != null && (lynxBDXBridge2 = getLynxBDXBridge()) != null) {
                lynxBDXBridge2.setThreadOpt(provideBulletSettings.getIsJSBThreadOptEnable(), provideBulletSettings.getJsbThreadOptConfig());
            }
            BulletContext bulletContext5 = this.bulletContext;
            if (Intrinsics.areEqual(bulletContext5 != null ? bulletContext5.getBid() : null, BidConstants.WEBCAST) && (lynxBDXBridge = getLynxBDXBridge()) != null) {
                ArrayList arrayList = new ArrayList();
                ThreadOptConfig threadOptConfig = new ThreadOptConfig((HashSet) null, (HashSet) null, (HashSet) null, (HashSet) null, (HashSet) null, 31, (DefaultConstructorMarker) null);
                threadOptConfig.setThreadOptSchemas(SetsKt.hashSetOf(new String[]{"bdx_thread_opt_all_schema"}));
                HashSet hashSet = new HashSet();
                hashSet.add("sendLogV3");
                hashSet.add("setStorage");
                threadOptConfig.setAsyncMethods(hashSet);
                arrayList.add(threadOptConfig);
                Unit unit = Unit.INSTANCE;
                lynxBDXBridge.setThreadOpt(true, arrayList);
            }
            LynxBDXBridge lynxBDXBridge4 = getLynxBDXBridge();
            if (lynxBDXBridge4 != null) {
                lynxBDXBridge4.setup(viewBuilder);
            }
            LynxBDXBridge lynxBDXBridge5 = getLynxBDXBridge();
            if (lynxBDXBridge5 != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(OptimizeConfigKt.getLATCH_SKIP_BPEA(), Boolean.valueOf(IConditionCallKt.latchSkipBpea()));
                linkedHashMap.put(OptimizeConfigKt.getLATCH_SKIP_AUTH(), Boolean.valueOf(IConditionCallKt.latchSkipAuth()));
                linkedHashMap.put(OptimizeConfigKt.getMIX_JSB_OPT_SWITCH(), Boolean.valueOf(IConditionCallKt.mixJsbSwitch()));
                linkedHashMap.put(OptimizeConfigKt.getCAN_RUN_IN_BACKGROUND_FIX(), Boolean.valueOf(IConditionCallKt.enableBridgeCanRunInBackgroundFix()));
                linkedHashMap.put(OptimizeConfigKt.getXBRIDGE_MODEL_PROXY_ENHANCEMENT(), Boolean.valueOf(IConditionCallKt.enableXBridgeParamProxyEnhancement()));
                lynxBDXBridge5.addSettings(linkedHashMap);
            }
            XBridge.INSTANCE.setEnableAnnieXJsbParamInNumberAdapterFix(IConditionCallKt.enableAnnieXJsbParamInNumberAdapterFix());
            LynxBDXBridge lynxBDXBridge6 = getLynxBDXBridge();
            if (lynxBDXBridge6 != null) {
                BulletContext bulletContext6 = this.bulletContext;
                lynxBDXBridge6.setUsePiperData(bulletContext6 != null ? BulletContextKt.usePiperData(bulletContext6) : false);
            }
        }
        BulletContext bulletContext7 = this.bulletContext;
        ISchemaModel kitModel = (bulletContext7 == null || (schemaModelUnion = bulletContext7.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getKitModel();
        BDXLynxKitModel bDXLynxKitModel = kitModel instanceof BDXLynxKitModel ? (BDXLynxKitModel) kitModel : null;
        if (Intrinsics.areEqual((bDXLynxKitModel == null || (useCodeCache = bDXLynxKitModel.getUseCodeCache()) == null) ? null : useCodeCache.getValue(), true)) {
            PreloadHelper preloadHelper = PreloadHelper.INSTANCE;
            BulletContext bulletContext8 = this.bulletContext;
            if (preloadHelper.disableCodeCache(bulletContext8 != null ? bulletContext8.getBid() : null)) {
                BulletLogger.printXDBLog$default(BulletLogger.INSTANCE, "BulletOptimize CodeCache disable by settings", null, null, 6, null);
            } else {
                BulletContext bulletContext9 = this.bulletContext;
                if (bulletContext9 != null && (uriIdentifier = bulletContext9.getUriIdentifier()) != null && (identifierUrl = uriIdentifier.getIdentifierUrl()) != null) {
                    PreloadLogger.INSTANCE.m41d("code cache: " + identifierUrl);
                    viewBuilder.setEnableUserCodeCache(true);
                    viewBuilder.setCodeCacheSourceUrl(identifierUrl);
                }
            }
        }
        if (Intrinsics.areEqual((bDXLynxKitModel == null || (enablePendingJsTask = bDXLynxKitModel.getEnablePendingJsTask()) == null) ? null : enablePendingJsTask.getValue(), true)) {
            viewBuilder.setEnablePendingJsTask(true);
        }
        if ((bDXLynxKitModel == null || (enableAnimaX = bDXLynxKitModel.getEnableAnimaX()) == null) ? false : Intrinsics.areEqual(enableAnimaX.getValue(), true)) {
            LynxAnimaXHelper lynxAnimaXHelper = LynxAnimaXHelper.INSTANCE;
            BulletContext bulletContext10 = this.bulletContext;
            lynxAnimaXHelper.mapLottieToAnimaX(viewBuilder, bulletContext10 != null ? bulletContext10.getContext() : null);
        }
        if (bDXLynxKitModel != null && (enableLynxAir = bDXLynxKitModel.getEnableLynxAir()) != null) {
            bool = enableLynxAir.getValue();
        }
        if (Intrinsics.areEqual(bool, true)) {
            viewBuilder.setEnableAirStrictMode(bool.booleanValue());
        }
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public void onLoadStart(String sessionId) {
        List<IBulletLoadLifeCycle> bulletGlobalLifeCycleListenerList;
        Uri parse;
        IBulletLoadLifeCycle bulletLoadLifeCycleListener;
        ILynxClientDelegate lynxClient;
        LynxEngineGlobalConfig lynxEngineConfig;
        List<ILynxClientDelegate> lynxClientDelegates;
        List<ILynxClientDelegate> lynxClientDelegates2;
        IBulletLoadLifeCycle bulletLoadLifeCycleListener2;
        List<IBulletLoadLifeCycle> bulletGlobalLifeCycleListenerList2;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        if (globalColdStart) {
            HybridLogger.i$default(HybridLogger.INSTANCE, "XLynxKit", "cold start this time", null, null, 12, null);
            this.isColdStart = true;
            globalColdStart = false;
        }
        BulletContext context = BulletContextManager.INSTANCE.getInstance().getContext(sessionId);
        this.bulletContext = context;
        if (context == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null && (bulletGlobalLifeCycleListenerList2 = bulletContext.getBulletGlobalLifeCycleListenerList()) != null) {
            arrayList.addAll(bulletGlobalLifeCycleListenerList2);
        }
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 != null && (bulletLoadLifeCycleListener2 = bulletContext2.getBulletLoadLifeCycleListener()) != null) {
            arrayList.add(bulletLoadLifeCycleListener2);
        }
        BulletContext bulletContext3 = this.bulletContext;
        if (bulletContext3 != null) {
            BulletLynxContext lynxContext = bulletContext3.getLynxContext();
            LynxEngineGlobalConfig lynxEngineGlobalConfig = new LynxEngineGlobalConfig();
            ArrayList packages = bulletContext3.getSchemeContext().getPackages();
            if (packages == null) {
                packages = new ArrayList();
            }
            lynxEngineGlobalConfig.config(bulletContext3, packages);
            lynxContext.setLynxGlobalConfig(lynxEngineGlobalConfig);
        }
        BulletContext bulletContext4 = this.bulletContext;
        if (bulletContext4 != null && (bulletLoadLifeCycleListener = bulletContext4.getBulletLoadLifeCycleListener()) != null && (lynxClient = bulletLoadLifeCycleListener.getLynxClient()) != null) {
            LynxEngineGlobalConfig lynxEngineConfig2 = getLynxEngineConfig();
            if (((lynxEngineConfig2 == null || (lynxClientDelegates2 = lynxEngineConfig2.getLynxClientDelegates()) == null || lynxClientDelegates2.contains(lynxClient)) ? false : true) && (lynxEngineConfig = getLynxEngineConfig()) != null && (lynxClientDelegates = lynxEngineConfig.getLynxClientDelegates()) != null) {
                lynxClientDelegates.add(lynxClient);
            }
        }
        BulletContext bulletContext5 = this.bulletContext;
        if (bulletContext5 == null || (bulletGlobalLifeCycleListenerList = bulletContext5.getBulletGlobalLifeCycleListenerList()) == null) {
            return;
        }
        for (IBulletLoadLifeCycle iBulletLoadLifeCycle : bulletGlobalLifeCycleListenerList) {
            try {
                Result.Companion companion = Result.Companion;
                BulletContext bulletContext6 = this.bulletContext;
                if (bulletContext6 == null || (parse = bulletContext6.getLoadUri()) == null) {
                    parse = Uri.parse("");
                }
                Intrinsics.checkNotNullExpressionValue(parse, "this@DefaultLynxDelegate….loadUri ?: Uri.parse(\"\")");
                BulletContext bulletContext7 = this.bulletContext;
                Object bulletLoadLifeCycleListener3 = bulletContext7 != null ? bulletContext7.getBulletLoadLifeCycleListener() : null;
                iBulletLoadLifeCycle.onLoadStart(parse, bulletLoadLifeCycleListener3 instanceof IBulletContainer ? (IBulletContainer) bulletLoadLifeCycleListener3 : null);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public void release(IKitViewService kitViewService) {
        IBulletLoadLifeCycle bulletLoadLifeCycleListener;
        Uri uri;
        Intrinsics.checkNotNullParameter(kitViewService, "kitViewService");
        BulletLogger bulletLogger = BulletLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("lynxview was destroy, currentUri: ");
        BulletContext bulletContext = this.bulletContext;
        BulletLogger.printLog$default(bulletLogger, sb.append(bulletContext != null ? bulletContext.getLoadUri() : null).toString(), null, "XLynxKit", 2, null);
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 != null && (bulletLoadLifeCycleListener = bulletContext2.getBulletLoadLifeCycleListener()) != null) {
            BulletContext bulletContext3 = this.bulletContext;
            if (bulletContext3 == null || (uri = bulletContext3.getLoadUri()) == null) {
                uri = Uri.EMPTY;
            }
            Intrinsics.checkNotNullExpressionValue(uri, "bulletContext?.loadUri ?: Uri.EMPTY");
            bulletLoadLifeCycleListener.onKitViewDestroy(uri, kitViewService, null);
        }
        ArgusLynxDelegateAdapter argusAdapter = getArgusAdapter();
        if (argusAdapter != null) {
            argusAdapter.onViewDestroy();
        }
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public Map<String, LynxModuleWrapper> createLynxModule() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!this.useXBridge3) {
            linkedHashMap.put("bridge", new LynxModuleWrapper(LynxBridgeModule.class, this.bulletContext));
        }
        return linkedHashMap;
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public boolean onBackPressed() {
        BDXLynxKitModel kitModel;
        BooleanParam closeByBack;
        try {
            kitModel = getKitModel();
        } catch (Exception e) {
            BulletLogger bulletLogger = BulletLogger.INSTANCE;
            Exception exc = e;
            StringBuilder sb = new StringBuilder(" on uri ");
            BulletContext bulletContext = this.bulletContext;
            bulletLogger.printReject(exc, sb.append(bulletContext != null ? bulletContext.getLoadUri() : null).toString(), "XLynxKit");
        }
        return (kitModel == null || (closeByBack = kitModel.getCloseByBack()) == null) ? false : Intrinsics.areEqual(closeByBack.getValue(), false);
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public IEventHandler createEventHandler() {
        return this.eventHandler;
    }

    public final void onEvent(LynxView view, IEvent event) {
        String str;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        String fromMap;
        String valueOf;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        if (Intrinsics.areEqual(event.getName(), UpdateDataEvent.EVENT_NAME_UPDATE_DATA)) {
            Object params = event.getParams();
            if (params != null) {
                if (params instanceof CharSequence) {
                    valueOf = String.valueOf(params);
                } else if (params instanceof JSONObject) {
                    valueOf = String.valueOf(((JSONObject) params).put("bullet_update_type", 1));
                } else if (params instanceof JSONArray) {
                    valueOf = String.valueOf(params);
                } else if (params instanceof ReadableMap) {
                    valueOf = String.valueOf(JsonConvertHelper.INSTANCE.reactToJSON((ReadableMap) params).put("bullet_update_type", 1));
                } else if (params instanceof ReadableArray) {
                    valueOf = String.valueOf(JsonConvertHelper.INSTANCE.reactToJSON((ReadableArray) params));
                }
                r2 = valueOf;
            }
            if (r2 != null) {
                view.updateData(r2);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(event.getName(), UpdateGlobalPropsEvent.EVENT_NAME_UPDATE_GLOBAL_PROPS) && this.rootPageGlobalProps != null) {
            Object params2 = event.getParams();
            if (params2 == null || !(params2 instanceof Map)) {
                return;
            }
            Map<?, ?> map = (Map) params2;
            if (map.isEmpty()) {
                return;
            }
            updateGlobalPropsByDiff(map);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map<String, Object> map2 = this.rootPageGlobalProps;
            Intrinsics.checkNotNull(map2);
            linkedHashMap.put("__globalProps", map2);
            linkedHashMap.put("bullet_update_type", 1);
            view.updateData(linkedHashMap);
            return;
        }
        if (Intrinsics.areEqual(UpdateTemplateDataEvent.EVENT_NAME_UPDATE_TEMPLATE_DATA, event.getName())) {
            Object params3 = event.getParams();
            if (params3 != null && (params3 instanceof LynxInitDataWrapper)) {
                LynxInitDataWrapper lynxInitDataWrapper = (LynxInitDataWrapper) params3;
                if (lynxInitDataWrapper.getInitData() != null) {
                    fromMap = TemplateData.fromString(lynxInitDataWrapper.getInitData());
                    for (Map.Entry<String, Object> entry : lynxInitDataWrapper.getDataProxy().entrySet()) {
                        if (fromMap != null) {
                            fromMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                } else {
                    fromMap = TemplateData.fromMap(lynxInitDataWrapper.getDataProxy());
                }
                if (lynxInitDataWrapper.getReadOnly() && fromMap != null) {
                    fromMap.markReadOnly();
                }
                r2 = fromMap;
            }
            if (r2 != null) {
                r2.put("bullet_update_type", 1);
            }
            view.updateData(r2);
            return;
        }
        String name = event.getName();
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        JSONObject jSONObject = new JSONObject();
        Object params4 = event.getParams();
        if (params4 != null) {
            if (params4 instanceof CharSequence ? true : params4 instanceof JSONObject ? true : params4 instanceof JSONArray) {
                jSONObject.put("data", params4);
            } else if (params4 instanceof JsonObject) {
                try {
                    Result.Companion companion = Result.Companion;
                    obj2 = Result.constructor-impl(jSONObject.put("data", new JSONObject(params4.toString())));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj2) != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("error", "JsonObject convert JSONObject error");
                    Unit unit = Unit.INSTANCE;
                    jSONObject.put("data", jSONObject2);
                }
                Result.box-impl(obj2);
            } else if (params4 instanceof JsonArray) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    obj3 = Result.constructor-impl(jSONObject.put("data", new JSONArray(params4.toString())));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th2));
                }
                if (Result.exceptionOrNull-impl(obj3) != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("error", "JsonArray convert JSONObject error");
                    Unit unit2 = Unit.INSTANCE;
                    jSONObject.put("data", jSONObject3);
                }
                Result.box-impl(obj3);
            } else if (params4 instanceof Map) {
                try {
                    Result.Companion companion5 = Result.Companion;
                    obj4 = Result.constructor-impl(jSONObject.put("data", new JSONObject((Map) params4)));
                } catch (Throwable th3) {
                    Result.Companion companion6 = Result.Companion;
                    obj4 = Result.constructor-impl(ResultKt.createFailure(th3));
                }
                if (Result.exceptionOrNull-impl(obj4) != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("error", "Map convert JSONObject error");
                    Unit unit3 = Unit.INSTANCE;
                    jSONObject.put("data", jSONObject4);
                }
                Result.box-impl(obj4);
            } else if (params4 instanceof ReadableMap) {
                jSONObject.put("data", JsonConvertHelper.INSTANCE.reactToJSON((ReadableMap) params4));
            } else if (params4 instanceof ReadableArray) {
                jSONObject.put("data", JsonConvertHelper.INSTANCE.reactToJSON((ReadableArray) params4));
            } else {
                jSONObject.put("data", new JSONObject());
            }
        }
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext == null || (str = bulletContext.getSessionId()) == null) {
            str = "";
        }
        LynxCommonDataKt.wrapLynxCommonData(jSONObject, new LynxCommonData(str, null, 2, null));
        BulletContext bulletContext2 = this.bulletContext;
        if (Intrinsics.areEqual(bulletContext2 != null ? bulletContext2.getBid() : null, BidConstants.WEBCAST)) {
            jSONObject.put("code", 1);
        }
        try {
            Result.Companion companion7 = Result.Companion;
            javaOnlyArray.pushMap(JsonConvertHelper.INSTANCE.jsonToReact(jSONObject));
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th4) {
            Result.Companion companion8 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th4));
        }
        Throwable th5 = Result.exceptionOrNull-impl(obj);
        if (th5 != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "DefaultLynxDelegate", "error===>" + th5.getMessage(), null, null, 12, null);
        }
        Unit unit4 = Unit.INSTANCE;
        view.sendGlobalEvent(name, javaOnlyArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    protected Map<String, Object> generateGlobalProps() {
        Map<String, Object> emptyMap;
        BulletRLContext resourceContext;
        BulletContainerContext containerContext;
        Map<String, Object> globalProps;
        BulletContainerContext containerContext2;
        BulletContext bulletContext;
        Uri prefetchUri;
        BulletLoadUriIdentifier uriIdentifier;
        UrlParam url;
        Uri value;
        String sessionId;
        String str;
        BulletLynxContext lynxContext;
        IEngineGlobalConfig lynxGlobalConfig;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        BulletContext bulletContext2 = this.bulletContext;
        linkedHashMap.putAll(PropsUtilsKt.getPageCommonProps(bulletContext2 != null ? bulletContext2.getContext() : null, IConditionCallKt.enableSafeAreaHeight()));
        this.rootPageGlobalProps = linkedHashMap;
        linkedHashMap.put("containerVersion", "9.0.0");
        linkedHashMap.put("containerType", "bullet");
        LynxEngineGlobalConfig lynxEngineConfig = getLynxEngineConfig();
        if (lynxEngineConfig != null) {
            lynxEngineConfig.updateGlobalProps();
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        BulletContext bulletContext3 = this.bulletContext;
        if (bulletContext3 == null || (lynxContext = bulletContext3.getLynxContext()) == null || (lynxGlobalConfig = lynxContext.getLynxGlobalConfig()) == null || (emptyMap = lynxGlobalConfig.getGlobalProps()) == null) {
            emptyMap = MapsKt.emptyMap();
        }
        linkedHashMap2.putAll(emptyMap);
        linkedHashMap2.put(SchemaConstants.INNER_PARAM_PROTOCOL_VERSION, "1.0");
        BulletContext bulletContext4 = this.bulletContext;
        int i = 0;
        i = 0;
        if (bulletContext4 != null && (sessionId = bulletContext4.getSessionId()) != null) {
            if (!(sessionId.length() > 0)) {
                sessionId = null;
            }
            if (sessionId != null) {
                BulletContext bulletContext5 = this.bulletContext;
                if (bulletContext5 == null || (str = bulletContext5.getSessionId()) == null) {
                    str = "";
                }
                LynxCommonDataKt.wrapLynxCommonData(linkedHashMap, new LynxCommonData(str, null, 2, null));
            }
        }
        BDXContainerModel containerModel = getContainerModel();
        if (containerModel != null && (url = containerModel.getUrl()) != null && (value = url.getValue()) != null) {
            putQueryItems(linkedHashMap, value);
            BulletContext bulletContext6 = this.bulletContext;
            putStorageGlobalProps(linkedHashMap, value, bulletContext6 != null ? bulletContext6.getContext() : null);
        }
        for (Map.Entry entry : MapsKt.toMap(linkedHashMap2).entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        IPrefetchV2Service prefetchV2Service = IPrefetchV2ServiceKt.getPrefetchV2Service();
        if (prefetchV2Service != null && (bulletContext = this.bulletContext) != null && (prefetchUri = bulletContext.getPrefetchUri()) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            BulletContext bulletContext7 = this.bulletContext;
            Collection<PrefetchV2Data> cacheBySchemeV2 = prefetchV2Service.getCacheBySchemeV2(prefetchUri, (bulletContext7 == null || (uriIdentifier = bulletContext7.getUriIdentifier()) == null) ? null : uriIdentifier.getIdentifierUrl(), true, bulletContext);
            if (!cacheBySchemeV2.isEmpty()) {
                for (PrefetchV2Data prefetchV2Data : cacheBySchemeV2) {
                    String globalPropsName = prefetchV2Data.getGlobalPropsName();
                    if (globalPropsName != null && LoaderUtil.INSTANCE.isNotNullOrEmpty(globalPropsName) && prefetchV2Data.getBody() != null) {
                        String jSONObject = prefetchV2Data.getBody().toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "item.body.toString()");
                        linkedHashMap.put(globalPropsName, jSONObject);
                    }
                }
            }
            prefetchV2Service.log("Prefetch数据注入props耗时" + (System.currentTimeMillis() - currentTimeMillis) + " ms, uri: " + prefetchUri + ", Props数量: " + cacheBySchemeV2.size());
        }
        try {
            Result.Companion companion = Result.Companion;
            if (BulletEnv.INSTANCE.getInstance().getDebuggable()) {
                BulletLogger bulletLogger = BulletLogger.INSTANCE;
                BulletContext bulletContext8 = this.bulletContext;
                BulletLogger.printCoreLog$default(bulletLogger, bulletContext8 != null ? bulletContext8.getSessionId() : null, "inject global props: " + new Gson().toJson(linkedHashMap), "XLynxKit", null, 8, null);
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        ResourceInfo resourceInfo = this.resourceInfo;
        if (resourceInfo != null) {
            linkedHashMap.put("geckoId", String.valueOf(resourceInfo.getVersion()));
            linkedHashMap.put("geckoChannel", resourceInfo.getChannel());
        }
        BDXContainerModel containerModel2 = getContainerModel();
        if (containerModel2 != null) {
            Float value2 = containerModel2.getFontScale().getValue();
            if (value2 != null) {
                float floatValue = value2.floatValue();
                if (containerModel2.getFontScale().get_isSet()) {
                    linkedHashMap.put("fontScale", Float.valueOf(floatValue));
                    linkedHashMap.put("font_scale", Float.valueOf(floatValue));
                }
            }
            Float value3 = containerModel2.getViewZoom().getValue();
            if (value3 != null) {
                float floatValue2 = value3.floatValue();
                if (containerModel2.getViewZoom().get_isSet()) {
                    linkedHashMap.put("viewZoom", Float.valueOf(floatValue2));
                }
            }
        }
        linkedHashMap.put(GlobalPropertiesConstants.IS_COLD_START, Boolean.valueOf(this.isColdStart));
        linkedHashMap.put("useXBridge3", Boolean.valueOf(this.useXBridge3));
        BulletContext bulletContext9 = this.bulletContext;
        linkedHashMap.put("usePiperData", Boolean.valueOf(bulletContext9 != null ? BulletContextKt.usePiperData(bulletContext9) : false));
        if (IConditionCallKt.enableBulletPrerenderLynxPropsFix()) {
            BulletContext bulletContext10 = this.bulletContext;
            if (bulletContext10 != null && (containerContext2 = bulletContext10.getContainerContext()) != null) {
                i = Intrinsics.areEqual(containerContext2.getIsPreload(), true);
            }
            linkedHashMap.put("isPreload", Integer.valueOf(i));
        }
        BulletContext bulletContext11 = this.bulletContext;
        if (bulletContext11 != null && (containerContext = bulletContext11.getContainerContext()) != null && (globalProps = containerContext.getGlobalProps()) != null) {
            linkedHashMap.putAll(globalProps);
        }
        BulletContext bulletContext12 = this.bulletContext;
        if (bulletContext12 != null && (resourceContext = bulletContext12.getResourceContext()) != null) {
            linkedHashMap.put("res_from", resourceContext.getResFrom());
        }
        return linkedHashMap;
    }

    private final void putStorageGlobalProps(Map<String, Object> map, Uri uri, Context context) {
        Map<String, Object> userDomainStorageValues;
        Map map2;
        Map<String, Object> storageValues;
        Map map3;
        if (context != null) {
            IGlobalPropsInjectService iGlobalPropsInjectService = (IGlobalPropsInjectService) StandardServiceManager.INSTANCE.get(IGlobalPropsInjectService.class);
            if (iGlobalPropsInjectService != null && (storageValues = iGlobalPropsInjectService.getStorageValues(uri, context)) != null && (map3 = MapsKt.toMap(storageValues)) != null) {
                map.put("bulletStorageValues", map3);
            }
            if (iGlobalPropsInjectService == null || (userDomainStorageValues = iGlobalPropsInjectService.getUserDomainStorageValues(uri, context)) == null || (map2 = MapsKt.toMap(userDomainStorageValues)) == null) {
                return;
            }
            map.put("userDomainStorageValues", map2);
        }
    }

    private final void putQueryItems(Map<String, Object> map, Uri uri) {
        Map<? extends String, ? extends Object> linkedHashMap;
        AbsBulletMonitorCallback monitorCallback;
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext == null || (monitorCallback = bulletContext.getMonitorCallback()) == null || (linkedHashMap = monitorCallback.generatePerfMapForGlobalProps()) == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        String valueOf = String.valueOf(linkedHashMap.get(MetricConstant.BULLET_INIT));
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Intrinsics.checkNotNullExpressionValue(queryParameterNames, "input.queryParameterNames");
        for (String str : queryParameterNames) {
            Intrinsics.checkNotNullExpressionValue(str, "key");
            linkedHashMap2.put(str, uri.getQueryParameter(str));
        }
        linkedHashMap2.put(MetricConstant.BULLET_INIT, valueOf);
        map.put("queryItems", linkedHashMap2);
        map.putAll(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LynxKitInitParams createInitParamsMiddle() {
        if (IConditionCallKt.enableAnnieXLiveLynxInitDataFix()) {
            BulletContext bulletContext = this.bulletContext;
            if (Intrinsics.areEqual(bulletContext != null ? bulletContext.getBid() : null, BidConstants.WEBCAST)) {
                return createInitParams();
            }
        }
        LynxKitInitParams lynxKitInitParams = this.innerLynxKitInitParams;
        if (lynxKitInitParams != null) {
            Intrinsics.checkNotNull(lynxKitInitParams);
            return lynxKitInitParams;
        }
        LynxKitInitParams createInitParams = createInitParams();
        this.innerLynxKitInitParams = createInitParams;
        Intrinsics.checkNotNull(createInitParams);
        return createInitParams;
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x034e A[Catch: Exception -> 0x0467, TryCatch #0 {Exception -> 0x0467, blocks: (B:181:0x0343, B:183:0x034e, B:184:0x0355, B:186:0x0359, B:188:0x035f, B:190:0x0365, B:191:0x036b, B:193:0x036f, B:194:0x0375, B:195:0x0386, B:197:0x0390, B:199:0x0396, B:200:0x039f, B:202:0x03a3, B:203:0x03ac, B:205:0x03b0, B:206:0x03b9, B:208:0x03bd, B:209:0x03c6, B:212:0x03ef, B:214:0x03f7, B:215:0x0400, B:217:0x040b, B:218:0x0414, B:219:0x0410, B:220:0x03fc, B:221:0x0422, B:223:0x0426, B:225:0x042c, B:227:0x0432, B:229:0x043b, B:230:0x043e, B:236:0x0418, B:240:0x0352), top: B:180:0x0343 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0390 A[Catch: Exception -> 0x0467, TryCatch #0 {Exception -> 0x0467, blocks: (B:181:0x0343, B:183:0x034e, B:184:0x0355, B:186:0x0359, B:188:0x035f, B:190:0x0365, B:191:0x036b, B:193:0x036f, B:194:0x0375, B:195:0x0386, B:197:0x0390, B:199:0x0396, B:200:0x039f, B:202:0x03a3, B:203:0x03ac, B:205:0x03b0, B:206:0x03b9, B:208:0x03bd, B:209:0x03c6, B:212:0x03ef, B:214:0x03f7, B:215:0x0400, B:217:0x040b, B:218:0x0414, B:219:0x0410, B:220:0x03fc, B:221:0x0422, B:223:0x0426, B:225:0x042c, B:227:0x0432, B:229:0x043b, B:230:0x043e, B:236:0x0418, B:240:0x0352), top: B:180:0x0343 }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0418 A[Catch: Exception -> 0x0467, TryCatch #0 {Exception -> 0x0467, blocks: (B:181:0x0343, B:183:0x034e, B:184:0x0355, B:186:0x0359, B:188:0x035f, B:190:0x0365, B:191:0x036b, B:193:0x036f, B:194:0x0375, B:195:0x0386, B:197:0x0390, B:199:0x0396, B:200:0x039f, B:202:0x03a3, B:203:0x03ac, B:205:0x03b0, B:206:0x03b9, B:208:0x03bd, B:209:0x03c6, B:212:0x03ef, B:214:0x03f7, B:215:0x0400, B:217:0x040b, B:218:0x0414, B:219:0x0410, B:220:0x03fc, B:221:0x0422, B:223:0x0426, B:225:0x042c, B:227:0x0432, B:229:0x043b, B:230:0x043e, B:236:0x0418, B:240:0x0352), top: B:180:0x0343 }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0352 A[Catch: Exception -> 0x0467, TryCatch #0 {Exception -> 0x0467, blocks: (B:181:0x0343, B:183:0x034e, B:184:0x0355, B:186:0x0359, B:188:0x035f, B:190:0x0365, B:191:0x036b, B:193:0x036f, B:194:0x0375, B:195:0x0386, B:197:0x0390, B:199:0x0396, B:200:0x039f, B:202:0x03a3, B:203:0x03ac, B:205:0x03b0, B:206:0x03b9, B:208:0x03bd, B:209:0x03c6, B:212:0x03ef, B:214:0x03f7, B:215:0x0400, B:217:0x040b, B:218:0x0414, B:219:0x0410, B:220:0x03fc, B:221:0x0422, B:223:0x0426, B:225:0x042c, B:227:0x0432, B:229:0x043b, B:230:0x043e, B:236:0x0418, B:240:0x0352), top: B:180:0x0343 }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0536 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x064f  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x067d  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x02c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final LynxKitInitParams createInitParams() {
        String str;
        Float value;
        FloatParam fontScale;
        BDXContainerModel containerModel;
        Float value2;
        FloatParam viewZoom;
        BulletContext bulletContext;
        String value3;
        LoaderUtil loaderUtil;
        BDXLynxKitModel kitModel;
        String[] strArr;
        BDXLynxKitModel kitModel2;
        BooleanParam enableCanvasOptimization;
        StringParam group;
        TemplateBundle templateBundle;
        LynxLoadMeta.Builder builder;
        BooleanParam useStorageGroup;
        Boolean value4;
        BooleanParam useStorageGroup2;
        StringParam predefine;
        BooleanParam shareGroup;
        Boolean value5;
        BooleanParam enableCanvasOptimization2;
        Boolean value6;
        BooleanParam enableDynamicV8;
        Boolean value7;
        BooleanParam enableCanvas;
        Boolean value8;
        StringParam group2;
        Context context;
        Display display;
        BulletContext bulletContext2;
        Boolean bool;
        BulletContext bulletContext3;
        BulletSchemeContext schemeContext;
        Bundle bundle;
        int i;
        SchemaModelUnion schemaModelUnion;
        FloatParam viewZoom2;
        BooleanParam enableViewZoom;
        BooleanParam renderTempInMain;
        Boolean value9;
        BooleanParam readResInfoInMain;
        Boolean value10;
        BooleanParam enableVSyncAlignedMessageLoop;
        Boolean value11;
        BooleanParam enableSyncFlush;
        Boolean value12;
        BooleanParam createViewAsync;
        Boolean value13;
        FloatParam fontScale2;
        BooleanParam enableFontScale;
        StringParam preloadFonts;
        BooleanParam presetSafePoint;
        IntegerParam threadStrategy;
        BooleanParam enableLynxGenericFetcher;
        BooleanParam disableAutoExpose;
        IntegerParam lynxPresetHeightSpec;
        IntegerParam lynxPresetWidthSpec;
        IntegerParam lynxInitHeight;
        IntegerParam lynxPresetHeight;
        IntegerParam lynxInitWidth;
        IntegerParam lynxPresetWidth;
        BooleanParam enableLynxPredecode;
        Boolean value14;
        String str2;
        String str3;
        StringParam forestDownloadEngine;
        StringParam forestPreloadScope;
        StringParam loaderName;
        String value15;
        CommonConfig commonConfig;
        Boolean lynxCdnCacheHttpUrl;
        LynxKitInitParams lynxKitInitParams = new LynxKitInitParams();
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        boolean z = false;
        lynxKitInitParams.setLynxCdnCacheHttpUrl((iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (lynxCdnCacheHttpUrl = commonConfig.getLynxCdnCacheHttpUrl()) == null) ? false : lynxCdnCacheHttpUrl.booleanValue());
        BDXContainerModel containerModel2 = getContainerModel();
        if (containerModel2 == null || (loaderName = containerModel2.getLoaderName()) == null || (value15 = loaderName.getValue()) == null) {
            str = null;
        } else {
            str = value15.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase()");
        }
        lynxKitInitParams.setUseForest(Intrinsics.areEqual(str, "forest"));
        if (lynxKitInitParams.getUseForest()) {
            BDXContainerModel containerModel3 = getContainerModel();
            if (containerModel3 == null || (forestPreloadScope = containerModel3.getForestPreloadScope()) == null || (str2 = forestPreloadScope.getValue()) == null) {
                str2 = ForestLoader.PRELOAD_SCOPE_DISABLE;
            }
            lynxKitInitParams.setForestPreloadScope(str2);
            BDXContainerModel containerModel4 = getContainerModel();
            if (containerModel4 == null || (forestDownloadEngine = containerModel4.getForestDownloadEngine()) == null || (str3 = forestDownloadEngine.getValue()) == null) {
                str3 = ForestLoader.DOWNLOAD_ENGINE_TTNET;
            }
            lynxKitInitParams.setForestDownloadEngine(str3);
        }
        BDXContainerModel containerModel5 = getContainerModel();
        lynxKitInitParams.setEnableLynxPredecode((containerModel5 == null || (enableLynxPredecode = containerModel5.getEnableLynxPredecode()) == null || (value14 = enableLynxPredecode.getValue()) == null) ? false : value14.booleanValue());
        BDXLynxKitModel kitModel3 = getKitModel();
        lynxKitInitParams.setLynxWidth((kitModel3 == null || (lynxPresetWidth = kitModel3.getLynxPresetWidth()) == null) ? null : lynxPresetWidth.getValue());
        BDXLynxKitModel kitModel4 = getKitModel();
        lynxKitInitParams.setLynxInitWidth((kitModel4 == null || (lynxInitWidth = kitModel4.getLynxInitWidth()) == null) ? null : lynxInitWidth.getValue());
        BDXLynxKitModel kitModel5 = getKitModel();
        lynxKitInitParams.setLynxHeight((kitModel5 == null || (lynxPresetHeight = kitModel5.getLynxPresetHeight()) == null) ? null : lynxPresetHeight.getValue());
        BDXLynxKitModel kitModel6 = getKitModel();
        lynxKitInitParams.setLynxInitHeight((kitModel6 == null || (lynxInitHeight = kitModel6.getLynxInitHeight()) == null) ? null : lynxInitHeight.getValue());
        BDXLynxKitModel kitModel7 = getKitModel();
        lynxKitInitParams.setPresetWidthSpec((kitModel7 == null || (lynxPresetWidthSpec = kitModel7.getLynxPresetWidthSpec()) == null) ? null : lynxPresetWidthSpec.getValue());
        BDXLynxKitModel kitModel8 = getKitModel();
        lynxKitInitParams.setPresetHeightSpec((kitModel8 == null || (lynxPresetHeightSpec = kitModel8.getLynxPresetHeightSpec()) == null) ? null : lynxPresetHeightSpec.getValue());
        BDXLynxKitModel kitModel9 = getKitModel();
        lynxKitInitParams.setDisableAutoExpose((kitModel9 == null || (disableAutoExpose = kitModel9.getDisableAutoExpose()) == null) ? null : disableAutoExpose.getValue());
        BDXLynxKitModel kitModel10 = getKitModel();
        lynxKitInitParams.setEnableLynxGenericFetcher((kitModel10 == null || (enableLynxGenericFetcher = kitModel10.getEnableLynxGenericFetcher()) == null) ? null : enableLynxGenericFetcher.getValue());
        BDXLynxKitModel kitModel11 = getKitModel();
        Integer value16 = (kitModel11 == null || (threadStrategy = kitModel11.getThreadStrategy()) == null) ? null : threadStrategy.getValue();
        if (!(value16 == null || value16.intValue() != 0)) {
            value16 = null;
        }
        if (value16 != null) {
            int intValue = value16.intValue();
            LynxAsyncLayoutParam lynxAsyncLayoutParam = new LynxAsyncLayoutParam();
            BDXLynxKitModel kitModel12 = getKitModel();
            lynxAsyncLayoutParam.setPresetSafePoint((kitModel12 == null || (presetSafePoint = kitModel12.getPresetSafePoint()) == null) ? null : presetSafePoint.getValue());
            lynxAsyncLayoutParam.setThreadStrategy(Integer.valueOf(intValue));
            lynxKitInitParams.setAsyncLayoutParam(lynxAsyncLayoutParam);
        }
        lynxKitInitParams.setDynamicComponentFetcher(getDynamicComponentFetcher());
        lynxKitInitParams.setTemplateData(provideTemplateData());
        BDXLynxKitModel kitModel13 = getKitModel();
        lynxKitInitParams.setPreloadFonts((kitModel13 == null || (preloadFonts = kitModel13.getPreloadFonts()) == null) ? null : preloadFonts.getValue());
        BDXContainerModel containerModel6 = getContainerModel();
        if ((containerModel6 == null || (enableFontScale = containerModel6.getEnableFontScale()) == null) ? false : Intrinsics.areEqual(enableFontScale.getValue(), true)) {
            BDXContainerModel containerModel7 = getContainerModel();
            if ((containerModel7 == null || (fontScale2 = containerModel7.getFontScale()) == null || fontScale2.get_isSet()) ? false : true) {
                value = LynxKitBase.INSTANCE.getFontScale();
                lynxKitInitParams.setFontScale(value);
                BDXLynxKitModel kitModel14 = getKitModel();
                lynxKitInitParams.setCreateViewAsync((kitModel14 != null || (createViewAsync = kitModel14.getCreateViewAsync()) == null || (value13 = createViewAsync.getValue()) == null) ? false : value13.booleanValue());
                BDXLynxKitModel kitModel15 = getKitModel();
                lynxKitInitParams.setEnableSyncFlush((kitModel15 != null || (enableSyncFlush = kitModel15.getEnableSyncFlush()) == null || (value12 = enableSyncFlush.getValue()) == null) ? false : value12.booleanValue());
                BDXLynxKitModel kitModel16 = getKitModel();
                lynxKitInitParams.setEnableVSyncAlignedMessageLoop((kitModel16 != null || (enableVSyncAlignedMessageLoop = kitModel16.getEnableVSyncAlignedMessageLoop()) == null || (value11 = enableVSyncAlignedMessageLoop.getValue()) == null) ? false : value11.booleanValue());
                BDXLynxKitModel kitModel17 = getKitModel();
                lynxKitInitParams.setReadResourceInfoInMainThread((kitModel17 != null || (readResInfoInMain = kitModel17.getReadResInfoInMain()) == null || (value10 = readResInfoInMain.getValue()) == null) ? true : value10.booleanValue());
                BDXLynxKitModel kitModel18 = getKitModel();
                lynxKitInitParams.setRenderTemplateInMainThread((kitModel18 != null || (renderTempInMain = kitModel18.getRenderTempInMain()) == null || (value9 = renderTempInMain.getValue()) == null) ? true : value9.booleanValue());
                BulletContext bulletContext4 = this.bulletContext;
                lynxKitInitParams.setSessionId(bulletContext4 == null ? bulletContext4.getSessionId() : null);
                lynxKitInitParams.setLynxRouterCallback(new LynxRouterCallback() { // from class: com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$createInitParams$1$3
                    @Override // com.bytedance.ies.bullet.lynx.LynxRouterCallback
                    public LynxKitInitParams convertToLynxInitParams(String url) {
                        LynxKitInitParams createInitParamsMiddle;
                        Intrinsics.checkNotNullParameter(url, "url");
                        SchemaService companion = SchemaService.INSTANCE.getInstance();
                        String bid = DefaultLynxDelegate.this.getService().getBid();
                        Uri parse = Uri.parse(url);
                        Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
                        ISchemaData generateSchemaData = companion.generateSchemaData(bid, parse);
                        if (IConditionCallKt.enableMixLogic()) {
                            DefaultLynxDelegate.this.generateSchemaModelOpt(generateSchemaData);
                        } else {
                            DefaultLynxDelegate.this.generateSchemaModel(generateSchemaData);
                        }
                        createInitParamsMiddle = DefaultLynxDelegate.this.createInitParamsMiddle();
                        return createInitParamsMiddle;
                    }
                });
                containerModel = getContainerModel();
                if ((containerModel != null || (enableViewZoom = containerModel.getEnableViewZoom()) == null) ? false : Intrinsics.areEqual(enableViewZoom.getValue(), true)) {
                    BDXContainerModel containerModel8 = getContainerModel();
                    if ((containerModel8 == null || (viewZoom2 = containerModel8.getViewZoom()) == null || viewZoom2.get_isSet()) ? false : true) {
                        value2 = LynxKitBase.INSTANCE.getViewZoom();
                        lynxKitInitParams.setViewZoom(value2 != null ? value2.floatValue() : 1.0f);
                        bulletContext = this.bulletContext;
                        if (bulletContext != null && (context = bulletContext.getContext()) != null && (display = BulletDeviceUtils.INSTANCE.getDisplay(context)) != null) {
                            try {
                                Point point = new Point();
                                if (!IConditionCallKt.enableAnnieXRealScreenSizeFix()) {
                                    display.getRealSize(point);
                                } else {
                                    display.getSize(point);
                                }
                                bulletContext2 = this.bulletContext;
                                if (bulletContext2 != null || (schemaModelUnion = bulletContext2.getSchemaModelUnion()) == null) {
                                    bool = null;
                                } else {
                                    BulletPadAdapterUtil bulletPadAdapterUtil = BulletPadAdapterUtil.INSTANCE;
                                    BulletContext bulletContext5 = this.bulletContext;
                                    Scenes scene = bulletContext5 != null ? bulletContext5.getScene() : null;
                                    BulletContext bulletContext6 = this.bulletContext;
                                    bool = Boolean.valueOf(bulletPadAdapterUtil.enableAdapterPad(schemaModelUnion, scene, Intrinsics.areEqual(bulletContext6 != null ? bulletContext6.getBid() : null, BidConstants.WEBCAST)));
                                }
                                if (!Intrinsics.areEqual(bool, true)) {
                                    BulletPadAdapterUtil bulletPadAdapterUtil2 = BulletPadAdapterUtil.INSTANCE;
                                    BulletContext bulletContext7 = this.bulletContext;
                                    String bid = bulletContext7 != null ? bulletContext7.getBid() : null;
                                    BulletContext bulletContext8 = this.bulletContext;
                                    Context context2 = bulletContext8 != null ? bulletContext8.getContext() : null;
                                    BulletContext bulletContext9 = this.bulletContext;
                                    SchemaModelUnion schemaModelUnion2 = bulletContext9 != null ? bulletContext9.getSchemaModelUnion() : null;
                                    BulletContext bulletContext10 = this.bulletContext;
                                    Scenes scene2 = bulletContext10 != null ? bulletContext10.getScene() : null;
                                    Configuration configuration = context.getResources().getConfiguration();
                                    Intrinsics.checkNotNullExpressionValue(configuration, "_context.resources.configuration");
                                    Pair padKitViewInfo$default = BulletPadAdapterUtil.getPadKitViewInfo$default(bulletPadAdapterUtil2, bid, context2, schemaModelUnion2, scene2, configuration, false, 32, null);
                                    Integer num = (Integer) padKitViewInfo$default.component1();
                                    Integer num2 = (Integer) padKitViewInfo$default.component2();
                                    if (num != null && num2 != null) {
                                        Integer padAdapterWidth = BulletPadAdapterUtil.INSTANCE.getPadAdapterWidth();
                                        lynxKitInitParams.setScreenWidth(padAdapterWidth != null ? padAdapterWidth.intValue() : num.intValue());
                                        Integer padAdapterHeight = BulletPadAdapterUtil.INSTANCE.getPadAdapterHeight();
                                        lynxKitInitParams.setScreenHeight(padAdapterHeight != null ? padAdapterHeight.intValue() : num2.intValue());
                                    }
                                } else {
                                    lynxKitInitParams.setScreenWidth(point.x);
                                    lynxKitInitParams.setScreenHeight(point.y);
                                }
                                bulletContext3 = this.bulletContext;
                                if (bulletContext3 != null && (schemeContext = bulletContext3.getSchemeContext()) != null && (bundle = schemeContext.getBundle()) != null && (i = bundle.getInt("split_width")) > 0) {
                                    lynxKitInitParams.setScreenWidth(i);
                                }
                                BulletLogger.printLog$default(BulletLogger.INSTANCE, "DefaultLynxDelegate: screenWidth=" + lynxKitInitParams.getScreenWidth() + ",screenHeight=" + lynxKitInitParams.getScreenHeight(), null, null, 6, null);
                            } catch (Exception e) {
                                BulletLogger bulletLogger = BulletLogger.INSTANCE;
                                Exception exc = e;
                                StringBuilder sb = new StringBuilder(" on uri ");
                                BulletContext bulletContext11 = this.bulletContext;
                                bulletLogger.printReject(exc, sb.append(bulletContext11 != null ? bulletContext11.getLoadUri() : null).toString(), "XLynxKit");
                            }
                        }
                        BDXLynxKitModel kitModel19 = getKitModel();
                        value3 = (kitModel19 != null || (group2 = kitModel19.getGroup()) == null) ? null : group2.getValue();
                        if (value3 == null) {
                            value3 = "";
                        }
                        BDXLynxKitModel kitModel20 = getKitModel();
                        boolean booleanValue = (kitModel20 != null || (enableCanvas = kitModel20.getEnableCanvas()) == null || (value8 = enableCanvas.getValue()) == null) ? false : value8.booleanValue();
                        BDXLynxKitModel kitModel21 = getKitModel();
                        boolean booleanValue2 = (kitModel21 != null || (enableDynamicV8 = kitModel21.getEnableDynamicV8()) == null || (value7 = enableDynamicV8.getValue()) == null) ? false : value7.booleanValue();
                        BDXLynxKitModel kitModel22 = getKitModel();
                        boolean booleanValue3 = (kitModel22 != null || (enableCanvasOptimization2 = kitModel22.getEnableCanvasOptimization()) == null || (value6 = enableCanvasOptimization2.getValue()) == null) ? false : value6.booleanValue();
                        BDXLynxKitModel kitModel23 = getKitModel();
                        boolean booleanValue4 = (kitModel23 != null || (shareGroup = kitModel23.getShareGroup()) == null || (value5 = shareGroup.getValue()) == null) ? true : value5.booleanValue();
                        BulletContext bulletContext12 = this.bulletContext;
                        Uri loadUri = bulletContext12 != null ? bulletContext12.getLoadUri() : null;
                        loaderUtil = LoaderUtil.INSTANCE;
                        kitModel = getKitModel();
                        if (!loaderUtil.isNotNullOrEmpty((kitModel != null || (predefine = kitModel.getPredefine()) == null) ? null : predefine.getValue()) && loadUri != null) {
                            ArrayList<String> targetJsFiles = PredefineManager.INSTANCE.getTargetJsFiles(loadUri);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(DefaultLynxParams.BDLYNX_CORE_JS);
                            if (targetJsFiles != null) {
                                arrayList.addAll(targetJsFiles);
                            }
                            Object[] array = arrayList.toArray(new String[0]);
                            if (array == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                            strArr = (String[]) array;
                        } else {
                            strArr = new String[]{DefaultLynxParams.BDLYNX_CORE_JS};
                        }
                        String[] strArr2 = strArr;
                        HybridLogger.i$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "show preloadJsFiles", MapsKt.mapOf(TuplesKt.to("preloadJSFiles", strArr2)), null, 8, null);
                        kitModel2 = getKitModel();
                        if ((kitModel2 != null || (useStorageGroup2 = kitModel2.getUseStorageGroup()) == null) ? false : Intrinsics.areEqual(useStorageGroup2.getValue(), true)) {
                            lynxKitInitParams.setStorageGroupName(value3);
                            BDXLynxKitModel kitModel24 = getKitModel();
                            lynxKitInitParams.setLynxGroup(value3, booleanValue4, booleanValue, strArr2, booleanValue2, booleanValue3, (r21 & 64) != 0 ? false : (kitModel24 == null || (useStorageGroup = kitModel24.getUseStorageGroup()) == null || (value4 = useStorageGroup.getValue()) == null) ? false : value4.booleanValue(), (r21 & 128) != 0 ? false : null);
                        } else if (IConditionCallKt.enableFixedLynxGroup()) {
                            BDXLynxKitModel kitModel25 = getKitModel();
                            if (kitModel25 != null && (group = kitModel25.getGroup()) != null && group.get_isSet()) {
                                z = true;
                            }
                            if (!z && booleanValue) {
                                value3 = value3 + POSTFIX_CANVAS;
                            }
                            lynxKitInitParams.setLynxGroup(value3, booleanValue4, booleanValue, strArr2, booleanValue2, booleanValue3, (r17 & 64) != 0 ? false : null);
                        } else {
                            if (booleanValue) {
                                value3 = value3 + POSTFIX_CANVAS;
                            }
                            BDXLynxKitModel kitModel26 = getKitModel();
                            if (kitModel26 != null && (enableCanvasOptimization = kitModel26.getEnableCanvasOptimization()) != null && enableCanvasOptimization.get_isSet()) {
                                z = true;
                            }
                            if (z) {
                                lynxKitInitParams.setLynxGroup(value3, booleanValue4, booleanValue, strArr2, booleanValue2, booleanValue3, (r17 & 64) != 0 ? false : null);
                            } else {
                                lynxKitInitParams.setLynxGroup(value3, booleanValue4, booleanValue, strArr2, booleanValue2);
                            }
                        }
                        ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
                        BulletContext bulletContext13 = this.bulletContext;
                        ContextProviderFactory providerFactory = contextProviderManager.getProviderFactory(bulletContext13 != null ? bulletContext13.getSessionId() : null);
                        templateBundle = (TemplateBundle) providerFactory.provideInstance(TemplateBundle.class);
                        if (templateBundle != null) {
                            HybridLogger.d$default(HybridLogger.INSTANCE, "XLynxKit", "templateBundle from providerFactory", null, null, 12, null);
                            lynxKitInitParams.setTemplateBundle(templateBundle);
                        }
                        builder = (LynxLoadMeta.Builder) providerFactory.provideInstance(LynxLoadMeta.Builder.class);
                        if (builder != null) {
                            HybridLogger.d$default(HybridLogger.INSTANCE, "XLynxKit", "LynxLoadMeta from providerFactory", null, null, 12, null);
                            lynxKitInitParams.setLynxLoadMeta(builder);
                        }
                        lynxKitInitParams.addLynxClientDelegate(createLynxClientDelegate());
                        return lynxKitInitParams;
                    }
                }
                BDXContainerModel containerModel9 = getContainerModel();
                value2 = (containerModel9 != null || (viewZoom = containerModel9.getViewZoom()) == null) ? null : viewZoom.getValue();
                lynxKitInitParams.setViewZoom(value2 != null ? value2.floatValue() : 1.0f);
                bulletContext = this.bulletContext;
                if (bulletContext != null) {
                    Point point2 = new Point();
                    if (!IConditionCallKt.enableAnnieXRealScreenSizeFix()) {
                    }
                    bulletContext2 = this.bulletContext;
                    if (bulletContext2 != null) {
                    }
                    bool = null;
                    if (!Intrinsics.areEqual(bool, true)) {
                    }
                    bulletContext3 = this.bulletContext;
                    if (bulletContext3 != null) {
                        lynxKitInitParams.setScreenWidth(i);
                    }
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, "DefaultLynxDelegate: screenWidth=" + lynxKitInitParams.getScreenWidth() + ",screenHeight=" + lynxKitInitParams.getScreenHeight(), null, null, 6, null);
                }
                BDXLynxKitModel kitModel192 = getKitModel();
                if (kitModel192 != null) {
                }
                if (value3 == null) {
                }
                BDXLynxKitModel kitModel202 = getKitModel();
                if (kitModel202 != null) {
                }
                BDXLynxKitModel kitModel212 = getKitModel();
                if (kitModel212 != null) {
                }
                BDXLynxKitModel kitModel222 = getKitModel();
                if (kitModel222 != null) {
                }
                BDXLynxKitModel kitModel232 = getKitModel();
                if (kitModel232 != null) {
                }
                BulletContext bulletContext122 = this.bulletContext;
                if (bulletContext122 != null) {
                }
                loaderUtil = LoaderUtil.INSTANCE;
                kitModel = getKitModel();
                if (!loaderUtil.isNotNullOrEmpty((kitModel != null || (predefine = kitModel.getPredefine()) == null) ? null : predefine.getValue())) {
                }
                strArr = new String[]{DefaultLynxParams.BDLYNX_CORE_JS};
                String[] strArr22 = strArr;
                HybridLogger.i$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "show preloadJsFiles", MapsKt.mapOf(TuplesKt.to("preloadJSFiles", strArr22)), null, 8, null);
                kitModel2 = getKitModel();
                if ((kitModel2 != null || (useStorageGroup2 = kitModel2.getUseStorageGroup()) == null) ? false : Intrinsics.areEqual(useStorageGroup2.getValue(), true)) {
                }
                ContextProviderManager contextProviderManager2 = ContextProviderManager.INSTANCE;
                BulletContext bulletContext132 = this.bulletContext;
                ContextProviderFactory providerFactory2 = contextProviderManager2.getProviderFactory(bulletContext132 != null ? bulletContext132.getSessionId() : null);
                templateBundle = (TemplateBundle) providerFactory2.provideInstance(TemplateBundle.class);
                if (templateBundle != null) {
                }
                builder = (LynxLoadMeta.Builder) providerFactory2.provideInstance(LynxLoadMeta.Builder.class);
                if (builder != null) {
                }
                lynxKitInitParams.addLynxClientDelegate(createLynxClientDelegate());
                return lynxKitInitParams;
            }
        }
        BDXContainerModel containerModel10 = getContainerModel();
        value = (containerModel10 == null || (fontScale = containerModel10.getFontScale()) == null) ? null : fontScale.getValue();
        lynxKitInitParams.setFontScale(value);
        BDXLynxKitModel kitModel142 = getKitModel();
        lynxKitInitParams.setCreateViewAsync((kitModel142 != null || (createViewAsync = kitModel142.getCreateViewAsync()) == null || (value13 = createViewAsync.getValue()) == null) ? false : value13.booleanValue());
        BDXLynxKitModel kitModel152 = getKitModel();
        lynxKitInitParams.setEnableSyncFlush((kitModel152 != null || (enableSyncFlush = kitModel152.getEnableSyncFlush()) == null || (value12 = enableSyncFlush.getValue()) == null) ? false : value12.booleanValue());
        BDXLynxKitModel kitModel162 = getKitModel();
        lynxKitInitParams.setEnableVSyncAlignedMessageLoop((kitModel162 != null || (enableVSyncAlignedMessageLoop = kitModel162.getEnableVSyncAlignedMessageLoop()) == null || (value11 = enableVSyncAlignedMessageLoop.getValue()) == null) ? false : value11.booleanValue());
        BDXLynxKitModel kitModel172 = getKitModel();
        lynxKitInitParams.setReadResourceInfoInMainThread((kitModel172 != null || (readResInfoInMain = kitModel172.getReadResInfoInMain()) == null || (value10 = readResInfoInMain.getValue()) == null) ? true : value10.booleanValue());
        BDXLynxKitModel kitModel182 = getKitModel();
        lynxKitInitParams.setRenderTemplateInMainThread((kitModel182 != null || (renderTempInMain = kitModel182.getRenderTempInMain()) == null || (value9 = renderTempInMain.getValue()) == null) ? true : value9.booleanValue());
        BulletContext bulletContext42 = this.bulletContext;
        lynxKitInitParams.setSessionId(bulletContext42 == null ? bulletContext42.getSessionId() : null);
        lynxKitInitParams.setLynxRouterCallback(new LynxRouterCallback() { // from class: com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$createInitParams$1$3
            @Override // com.bytedance.ies.bullet.lynx.LynxRouterCallback
            public LynxKitInitParams convertToLynxInitParams(String url) {
                LynxKitInitParams createInitParamsMiddle;
                Intrinsics.checkNotNullParameter(url, "url");
                SchemaService companion = SchemaService.INSTANCE.getInstance();
                String bid2 = DefaultLynxDelegate.this.getService().getBid();
                Uri parse = Uri.parse(url);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
                ISchemaData generateSchemaData = companion.generateSchemaData(bid2, parse);
                if (IConditionCallKt.enableMixLogic()) {
                    DefaultLynxDelegate.this.generateSchemaModelOpt(generateSchemaData);
                } else {
                    DefaultLynxDelegate.this.generateSchemaModel(generateSchemaData);
                }
                createInitParamsMiddle = DefaultLynxDelegate.this.createInitParamsMiddle();
                return createInitParamsMiddle;
            }
        });
        containerModel = getContainerModel();
        if ((containerModel != null || (enableViewZoom = containerModel.getEnableViewZoom()) == null) ? false : Intrinsics.areEqual(enableViewZoom.getValue(), true)) {
        }
        BDXContainerModel containerModel92 = getContainerModel();
        if (containerModel92 != null) {
        }
        lynxKitInitParams.setViewZoom(value2 != null ? value2.floatValue() : 1.0f);
        bulletContext = this.bulletContext;
        if (bulletContext != null) {
        }
        BDXLynxKitModel kitModel1922 = getKitModel();
        if (kitModel1922 != null) {
        }
        if (value3 == null) {
        }
        BDXLynxKitModel kitModel2022 = getKitModel();
        if (kitModel2022 != null) {
        }
        BDXLynxKitModel kitModel2122 = getKitModel();
        if (kitModel2122 != null) {
        }
        BDXLynxKitModel kitModel2222 = getKitModel();
        if (kitModel2222 != null) {
        }
        BDXLynxKitModel kitModel2322 = getKitModel();
        if (kitModel2322 != null) {
        }
        BulletContext bulletContext1222 = this.bulletContext;
        if (bulletContext1222 != null) {
        }
        loaderUtil = LoaderUtil.INSTANCE;
        kitModel = getKitModel();
        if (!loaderUtil.isNotNullOrEmpty((kitModel != null || (predefine = kitModel.getPredefine()) == null) ? null : predefine.getValue())) {
        }
        strArr = new String[]{DefaultLynxParams.BDLYNX_CORE_JS};
        String[] strArr222 = strArr;
        HybridLogger.i$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "show preloadJsFiles", MapsKt.mapOf(TuplesKt.to("preloadJSFiles", strArr222)), null, 8, null);
        kitModel2 = getKitModel();
        if ((kitModel2 != null || (useStorageGroup2 = kitModel2.getUseStorageGroup()) == null) ? false : Intrinsics.areEqual(useStorageGroup2.getValue(), true)) {
        }
        ContextProviderManager contextProviderManager22 = ContextProviderManager.INSTANCE;
        BulletContext bulletContext1322 = this.bulletContext;
        ContextProviderFactory providerFactory22 = contextProviderManager22.getProviderFactory(bulletContext1322 != null ? bulletContext1322.getSessionId() : null);
        templateBundle = (TemplateBundle) providerFactory22.provideInstance(TemplateBundle.class);
        if (templateBundle != null) {
        }
        builder = (LynxLoadMeta.Builder) providerFactory22.provideInstance(LynxLoadMeta.Builder.class);
        if (builder != null) {
        }
        lynxKitInitParams.addLynxClientDelegate(createLynxClientDelegate());
        return lynxKitInitParams;
    }

    private final LynxViewClient createLynxClientDelegate() {
        return new LynxViewClient() { // from class: com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$createLynxClientDelegate$1
            private Uri uri;

            public final Uri getUri() {
                return this.uri;
            }

            public final void setUri(Uri uri) {
                this.uri = uri;
            }

            public void onPageStart(String url) {
                ISchemaData schemaData;
                ILynxKitViewService kitView;
                DefaultLynxDelegate defaultLynxDelegate = DefaultLynxDelegate.this;
                try {
                    LynxEngineGlobalConfig lynxEngineConfig = defaultLynxDelegate.getLynxEngineConfig();
                    if (lynxEngineConfig != null) {
                        for (ILynxClientDelegate iLynxClientDelegate : lynxEngineConfig.getLynxClientDelegates()) {
                            kitView = defaultLynxDelegate.getKitView();
                            iLynxClientDelegate.onPageStart(kitView, url);
                        }
                    }
                } catch (YieldError unused) {
                }
                Unit unit = null;
                this.uri = url != null ? Uri.parse(url) : null;
                ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                ContextProviderFactory providerFactory = contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null);
                BulletContext bulletContext2 = DefaultLynxDelegate.this.getBulletContext();
                if (bulletContext2 != null && (schemaData = bulletContext2.getSchemaData()) != null) {
                    String uri = schemaData.getInnerOriginUrl().toString();
                    Intrinsics.checkNotNullExpressionValue(uri, "it.originUrl.toString()");
                    providerFactory.registerHolder(BulletPageUrl.class, new BulletPageUrl(uri));
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, "onPageStart url: " + uri, null, "XLynxKit", 2, null);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    providerFactory.removeProvider(BulletPageUrl.class);
                }
            }

            public void onLoadSuccess() {
                ILynxKitViewService kitView;
                DefaultLynxDelegate defaultLynxDelegate = DefaultLynxDelegate.this;
                try {
                    LynxEngineGlobalConfig lynxEngineConfig = defaultLynxDelegate.getLynxEngineConfig();
                    if (lynxEngineConfig != null) {
                        for (ILynxClientDelegate iLynxClientDelegate : lynxEngineConfig.getLynxClientDelegates()) {
                            kitView = defaultLynxDelegate.getKitView();
                            iLynxClientDelegate.onLoadSuccess(kitView);
                        }
                    }
                } catch (YieldError unused) {
                }
                BulletLogger bulletLogger = BulletLogger.INSTANCE;
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                BulletLogger.printCoreLog$default(bulletLogger, bulletContext != null ? bulletContext.getSessionId() : null, "load success", "XLynxKit", null, 8, null);
            }

            public void onFirstScreen() {
                ILynxKitViewService kitView;
                DefaultLynxDelegate defaultLynxDelegate = DefaultLynxDelegate.this;
                try {
                    LynxEngineGlobalConfig lynxEngineConfig = defaultLynxDelegate.getLynxEngineConfig();
                    if (lynxEngineConfig != null) {
                        for (ILynxClientDelegate iLynxClientDelegate : lynxEngineConfig.getLynxClientDelegates()) {
                            kitView = defaultLynxDelegate.getKitView();
                            iLynxClientDelegate.onFirstScreen(kitView);
                        }
                    }
                } catch (YieldError unused) {
                }
                ITestService iTestService = (ITestService) DefaultLynxDelegate.this.getService().getService(ITestService.class);
                if (iTestService != null) {
                    iTestService.onEvent(new TNativeEvent("LynxFirstScreen"));
                }
                BulletLogger bulletLogger = BulletLogger.INSTANCE;
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                BulletLogger.printCoreLog$default(bulletLogger, bulletContext != null ? bulletContext.getSessionId() : null, "first screen", "XLynxKit", null, 8, null);
            }

            public void onPageUpdate() {
                ILynxKitViewService kitView;
                DefaultLynxDelegate defaultLynxDelegate = DefaultLynxDelegate.this;
                try {
                    LynxEngineGlobalConfig lynxEngineConfig = defaultLynxDelegate.getLynxEngineConfig();
                    if (lynxEngineConfig != null) {
                        for (ILynxClientDelegate iLynxClientDelegate : lynxEngineConfig.getLynxClientDelegates()) {
                            kitView = defaultLynxDelegate.getKitView();
                            iLynxClientDelegate.onPageUpdate(kitView);
                        }
                    }
                } catch (YieldError unused) {
                }
            }

            public void onDataUpdated() {
                ILynxKitViewService kitView;
                DefaultLynxDelegate defaultLynxDelegate = DefaultLynxDelegate.this;
                try {
                    LynxEngineGlobalConfig lynxEngineConfig = defaultLynxDelegate.getLynxEngineConfig();
                    if (lynxEngineConfig != null) {
                        for (ILynxClientDelegate iLynxClientDelegate : lynxEngineConfig.getLynxClientDelegates()) {
                            kitView = defaultLynxDelegate.getKitView();
                            iLynxClientDelegate.onDataUpdated(kitView);
                        }
                    }
                } catch (YieldError unused) {
                }
            }

            public void onLoadFailed(String errorMsg) {
                ILynxKitViewService kitView;
                DefaultLynxDelegate defaultLynxDelegate = DefaultLynxDelegate.this;
                try {
                    LynxEngineGlobalConfig lynxEngineConfig = defaultLynxDelegate.getLynxEngineConfig();
                    if (lynxEngineConfig != null) {
                        for (ILynxClientDelegate iLynxClientDelegate : lynxEngineConfig.getLynxClientDelegates()) {
                            kitView = defaultLynxDelegate.getKitView();
                            iLynxClientDelegate.onLoadFailed(kitView, errorMsg);
                        }
                    }
                } catch (YieldError unused) {
                }
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                BulletLynxContext lynxContext = bulletContext != null ? bulletContext.getLynxContext() : null;
                if (lynxContext == null) {
                    return;
                }
                lynxContext.setLynxFailReason(errorMsg);
            }

            public void onScrollStart(LynxViewClient.ScrollInfo info) {
                ScrollInfo scrollInfo;
                Uri uri = this.uri;
                String uri2 = uri != null ? uri.toString() : null;
                if (info != null) {
                    try {
                        LynxEngineGlobalConfig lynxEngineConfig = DefaultLynxDelegate.this.getLynxEngineConfig();
                        if (lynxEngineConfig != null) {
                            for (ILynxClientDelegate iLynxClientDelegate : lynxEngineConfig.getLynxClientDelegates()) {
                                if (uri2 != null) {
                                    View view = info.mView;
                                    Intrinsics.checkNotNullExpressionValue(view, "info.mView");
                                    String str = info.mTagName;
                                    Intrinsics.checkNotNullExpressionValue(str, "info.mTagName");
                                    scrollInfo = new ScrollInfo(view, str, info.mScrollMonitorTag, uri2);
                                } else {
                                    scrollInfo = null;
                                }
                                iLynxClientDelegate.onScrollStart(scrollInfo);
                            }
                        }
                    } catch (YieldError unused) {
                    }
                }
            }

            public void onScrollStop(LynxViewClient.ScrollInfo info) {
                ScrollInfo scrollInfo;
                Uri uri = this.uri;
                String uri2 = uri != null ? uri.toString() : null;
                if (info != null) {
                    try {
                        LynxEngineGlobalConfig lynxEngineConfig = DefaultLynxDelegate.this.getLynxEngineConfig();
                        if (lynxEngineConfig != null) {
                            for (ILynxClientDelegate iLynxClientDelegate : lynxEngineConfig.getLynxClientDelegates()) {
                                if (uri2 != null) {
                                    View view = info.mView;
                                    Intrinsics.checkNotNullExpressionValue(view, "info.mView");
                                    String str = info.mTagName;
                                    Intrinsics.checkNotNullExpressionValue(str, "info.mTagName");
                                    scrollInfo = new ScrollInfo(view, str, info.mScrollMonitorTag, uri2);
                                } else {
                                    scrollInfo = null;
                                }
                                iLynxClientDelegate.onScrollStop(scrollInfo);
                            }
                        }
                    } catch (YieldError unused) {
                    }
                }
            }

            public void onTimingSetup(Map<String, Object> timingInfo) {
                try {
                    LynxEngineGlobalConfig lynxEngineConfig = DefaultLynxDelegate.this.getLynxEngineConfig();
                    if (lynxEngineConfig != null) {
                        Iterator<T> it = lynxEngineConfig.getLynxClientDelegates().iterator();
                        while (it.hasNext()) {
                            ((ILynxClientDelegate) it.next()).onTimingSetup(timingInfo);
                        }
                    }
                } catch (YieldError unused) {
                }
            }

            public void onTimingUpdate(Map<String, Object> timingInfo, Map<String, Long> updateTiming, String flag) {
                try {
                    LynxEngineGlobalConfig lynxEngineConfig = DefaultLynxDelegate.this.getLynxEngineConfig();
                    if (lynxEngineConfig != null) {
                        Iterator<T> it = lynxEngineConfig.getLynxClientDelegates().iterator();
                        while (it.hasNext()) {
                            ((ILynxClientDelegate) it.next()).onTimingUpdate(timingInfo, updateTiming, flag);
                        }
                    }
                } catch (YieldError unused) {
                }
            }

            public void onReceivedError(LynxError error) {
                ArrayList arrayList;
                BulletContext bulletContext;
                IBulletLoadLifeCycle bulletLoadLifeCycleListener;
                ResourceInfo resourceInfo;
                BulletSettings provideBulletSettings;
                ILynxKitViewService kitView;
                if (error != null) {
                    DefaultLynxDelegate defaultLynxDelegate = DefaultLynxDelegate.this;
                    try {
                        LynxEngineGlobalConfig lynxEngineConfig = defaultLynxDelegate.getLynxEngineConfig();
                        if (lynxEngineConfig != null) {
                            for (ILynxClientDelegate iLynxClientDelegate : lynxEngineConfig.getLynxClientDelegates()) {
                                kitView = defaultLynxDelegate.getKitView();
                                iLynxClientDelegate.onReceivedError(kitView, new com.bytedance.ies.bullet.service.base.lynx.LynxError(error.getMsg(), error.getErrorCode()));
                            }
                        }
                    } catch (YieldError unused) {
                    }
                    ISettingService iSettingService = (ISettingService) defaultLynxDelegate.getService().getService(ISettingService.class);
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
                        resourceInfo = defaultLynxDelegate.resourceInfo;
                        if (StringsKt.contains$default(String.valueOf(resourceInfo != null ? resourceInfo.getSrcUri() : null), next, false, 2, (Object) null)) {
                            isEmpty = true;
                            break;
                        }
                    }
                    BulletLogger bulletLogger = BulletLogger.INSTANCE;
                    BulletContext bulletContext2 = defaultLynxDelegate.getBulletContext();
                    bulletLogger.printCoreLog(bulletContext2 != null ? bulletContext2.getSessionId() : null, "receive error. error_code: " + error.getErrorCode() + ", error_message: " + error + ", deleteWhen100Error: " + isEmpty, "XLynxKit", LogLevel.E);
                    if (error.getErrorCode() != 107 || (bulletContext = defaultLynxDelegate.getBulletContext()) == null || (bulletLoadLifeCycleListener = bulletContext.getBulletLoadLifeCycleListener()) == null) {
                        return;
                    }
                    Uri parse = Uri.parse("");
                    Intrinsics.checkNotNullExpressionValue(parse, "parse(\"\")");
                    bulletLoadLifeCycleListener.onLoadFail(parse, new Throwable(error.getMsg()));
                }
            }

            public void onFirstLoadPerfReady(LynxPerfMetric metric) {
                ILynxKitViewService kitView;
                Intrinsics.checkNotNullParameter(metric, "metric");
                JSONObject jSONObject = metric.toJSONObject();
                DefaultLynxDelegate defaultLynxDelegate = DefaultLynxDelegate.this;
                try {
                    LynxEngineGlobalConfig lynxEngineConfig = defaultLynxDelegate.getLynxEngineConfig();
                    if (lynxEngineConfig != null) {
                        for (ILynxClientDelegate iLynxClientDelegate : lynxEngineConfig.getLynxClientDelegates()) {
                            kitView = defaultLynxDelegate.getKitView();
                            iLynxClientDelegate.onFirstLoadPerfReady(kitView, jSONObject);
                        }
                    }
                } catch (YieldError unused) {
                }
            }

            public void onUpdatePerfReady(LynxPerfMetric metric) {
                ILynxKitViewService kitView;
                Intrinsics.checkNotNullParameter(metric, "metric");
                JSONObject jSONObject = metric.toJSONObject();
                DefaultLynxDelegate defaultLynxDelegate = DefaultLynxDelegate.this;
                try {
                    LynxEngineGlobalConfig lynxEngineConfig = defaultLynxDelegate.getLynxEngineConfig();
                    if (lynxEngineConfig != null) {
                        for (ILynxClientDelegate iLynxClientDelegate : lynxEngineConfig.getLynxClientDelegates()) {
                            kitView = defaultLynxDelegate.getKitView();
                            iLynxClientDelegate.onUpdatePerfReady(kitView, jSONObject);
                        }
                    }
                } catch (YieldError unused) {
                }
            }

            public void onRuntimeReady() {
                ILynxKitViewService kitView;
                DefaultLynxDelegate defaultLynxDelegate = DefaultLynxDelegate.this;
                try {
                    LynxEngineGlobalConfig lynxEngineConfig = defaultLynxDelegate.getLynxEngineConfig();
                    if (lynxEngineConfig != null) {
                        for (ILynxClientDelegate iLynxClientDelegate : lynxEngineConfig.getLynxClientDelegates()) {
                            kitView = defaultLynxDelegate.getKitView();
                            iLynxClientDelegate.onRuntimeReady(kitView);
                        }
                    }
                } catch (YieldError unused) {
                }
                BulletLogger bulletLogger = BulletLogger.INSTANCE;
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                BulletLogger.printCoreLog$default(bulletLogger, bulletContext != null ? bulletContext.getSessionId() : null, "js runtime ready", "XLynxKit", null, 8, null);
            }

            public void loadImage(Context context, String cacheKey, String src, float width, float height, Transformer transformer, final ImageInterceptor.CompletionHandler handler) {
                ILynxKitViewService kitView;
                List<ILynxClientDelegate> lynxClientDelegates;
                String str;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(handler, "handler");
                if (src != null) {
                    DefaultLynxDelegate defaultLynxDelegate = DefaultLynxDelegate.this;
                    IPreloadV2Service preloadV2Service = IPreloadV2ServiceKt.getPreloadV2Service();
                    if (preloadV2Service != null) {
                        BulletContext bulletContext = defaultLynxDelegate.getBulletContext();
                        if (bulletContext == null || (str = bulletContext.getBid()) == null) {
                            str = "default_bid";
                        }
                        Object cacheImage = preloadV2Service.getCacheImage(str, src);
                        if (cacheImage != null) {
                            handler.imageLoadCompletion(cacheImage, (Throwable) null);
                            return;
                        }
                    }
                }
                if (DefaultLynxDelegate.this.getLynxEngineConfig() != null) {
                    LynxEngineGlobalConfig lynxEngineConfig = DefaultLynxDelegate.this.getLynxEngineConfig();
                    boolean z = false;
                    if (lynxEngineConfig != null && (lynxClientDelegates = lynxEngineConfig.getLynxClientDelegates()) != null && lynxClientDelegates.isEmpty()) {
                        z = true;
                    }
                    if (!z) {
                        kitView = DefaultLynxDelegate.this.getKitView();
                        ILynxKitViewService iLynxKitViewService = kitView;
                        LynxEngineGlobalConfig lynxEngineConfig2 = DefaultLynxDelegate.this.getLynxEngineConfig();
                        List<ILynxClientDelegate> lynxClientDelegates2 = lynxEngineConfig2 != null ? lynxEngineConfig2.getLynxClientDelegates() : null;
                        Intrinsics.checkNotNull(lynxClientDelegates2);
                        new LynxClientDelegateChain(iLynxKitViewService, lynxClientDelegates2).loadImage(new LynxImageInfo(context, cacheKey, src, width, height, transformer), new Function1<Object, Unit>() { // from class: com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$createLynxClientDelegate$1$loadImage$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                m519invoke(obj);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m519invoke(Object obj) {
                                handler.imageLoadCompletion(obj, (Throwable) null);
                            }
                        }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$createLynxClientDelegate$1$loadImage$3
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
                                handler.imageLoadCompletion((Object) null, th);
                            }
                        });
                        return;
                    }
                }
                super.loadImage(context, cacheKey, src, width, height, transformer, handler);
            }

            public String shouldRedirectImageUrl(String url) {
                String str = null;
                try {
                    LynxEngineGlobalConfig lynxEngineConfig = DefaultLynxDelegate.this.getLynxEngineConfig();
                    if (lynxEngineConfig != null) {
                        Iterator<T> it = lynxEngineConfig.getLynxClientDelegates().iterator();
                        while (it.hasNext()) {
                            str = ((ILynxClientDelegate) it.next()).shouldRedirectImageUrl(url);
                        }
                    }
                } catch (YieldError unused) {
                }
                return str;
            }

            public void onLynxViewAndJSRuntimeDestroy() {
                boolean z;
                IBridge3Registry bridge3Registry;
                IBridgeRegistry bridgeRegistry;
                BulletLogger bulletLogger = BulletLogger.INSTANCE;
                BulletContext bulletContext = DefaultLynxDelegate.this.getBulletContext();
                BulletLogger.printCoreLog$default(bulletLogger, bulletContext != null ? bulletContext.getSessionId() : null, "onLynxViewAndJSRuntimeDestroy", "XLynxKit", null, 8, null);
                BulletContext bulletContext2 = DefaultLynxDelegate.this.getBulletContext();
                if (bulletContext2 != null && (bridgeRegistry = bulletContext2.getBridgeRegistry()) != null) {
                    bridgeRegistry.release();
                }
                z = DefaultLynxDelegate.this.useXBridge3;
                if (z) {
                    LynxBDXBridge lynxBDXBridge = DefaultLynxDelegate.this.getLynxBDXBridge();
                    if (lynxBDXBridge != null) {
                        lynxBDXBridge.release();
                    }
                    BulletContext bulletContext3 = DefaultLynxDelegate.this.getBulletContext();
                    if (bulletContext3 != null && (bridge3Registry = bulletContext3.getBridge3Registry()) != null) {
                        bridge3Registry.release();
                    }
                }
                if (IConditionCallKt.enableJsbBridgeReleaseOpt()) {
                    DefaultLynxDelegate.this.setLynxBDXBridge(null);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void generateSchemaModelOpt(ISchemaData data) {
        String str;
        Class<? extends ISchemaModel> cls;
        BulletSchemeContext schemeContext;
        List<String> packages;
        List<Class<? extends ISchemaModel>> extraModelType;
        BulletSchemeContext schemeContext2;
        List<String> packages2;
        ArrayList arrayList = new ArrayList();
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null) {
            SchemaModelTransformer.INSTANCE.generateContainerModel(bulletContext, data);
            SchemaModelTransformer.INSTANCE.generateUiModel(bulletContext, data);
        }
        IServiceCenter instance = ServiceCenter.INSTANCE.instance();
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 == null || (schemeContext2 = bulletContext2.getSchemeContext()) == null || (packages2 = schemeContext2.getPackages()) == null || (str = (String) CollectionsKt.firstOrNull(packages2)) == null) {
            str = "default_bid";
        }
        ILynxGlobalConfigService iLynxGlobalConfigService = (ILynxGlobalConfigService) instance.get(str, ILynxGlobalConfigService.class);
        if (iLynxGlobalConfigService == null || (cls = iLynxGlobalConfigService.getModelType()) == null) {
            cls = BDXLynxKitModel.class;
        }
        ISchemaModel generateSchemaModel = SchemaService.INSTANCE.getInstance().generateSchemaModel(data, cls);
        BulletContext bulletContext3 = this.bulletContext;
        SchemaModelUnion schemaModelUnion = bulletContext3 != null ? bulletContext3.getSchemaModelUnion() : null;
        if (schemaModelUnion != null) {
            schemaModelUnion.setKitModel(generateSchemaModel);
        }
        BulletContext bulletContext4 = this.bulletContext;
        if (bulletContext4 != null && (schemeContext = bulletContext4.getSchemeContext()) != null && (packages = schemeContext.getPackages()) != null) {
            Iterator<T> it = packages.iterator();
            while (it.hasNext()) {
                ILynxGlobalConfigService iLynxGlobalConfigService2 = (ILynxGlobalConfigService) ServiceCenter.INSTANCE.instance().get((String) it.next(), ILynxGlobalConfigService.class);
                if (iLynxGlobalConfigService2 != null && (extraModelType = iLynxGlobalConfigService2.getExtraModelType()) != null) {
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
        BulletContext bulletContext5 = this.bulletContext;
        BulletSchemeContext schemeContext3 = bulletContext5 != null ? bulletContext5.getSchemeContext() : null;
        if (schemeContext3 != null) {
            schemeContext3.setExtraSchemaModelList(arrayList);
        }
        BulletContext bulletContext6 = this.bulletContext;
        this.useXBridge3 = bulletContext6 != null ? BulletContextKt.useXBride3(bulletContext6) : false;
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "DefaultLynxDelegate.generateSchemaModel, useXBridge3=" + this.useXBridge3, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void generateSchemaModel(ISchemaData data) {
        String str;
        Class<? extends ISchemaModel> cls;
        BulletSchemeContext schemeContext;
        List<String> packages;
        List<Class<? extends ISchemaModel>> extraModelType;
        BulletSchemeContext schemeContext2;
        List<String> packages2;
        Intrinsics.checkNotNullParameter(data, "data");
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
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext == null || (schemeContext2 = bulletContext.getSchemeContext()) == null || (packages2 = schemeContext2.getPackages()) == null || (str = (String) CollectionsKt.firstOrNull(packages2)) == null) {
            str = "default_bid";
        }
        ILynxGlobalConfigService iLynxGlobalConfigService = (ILynxGlobalConfigService) instance.get(str, ILynxGlobalConfigService.class);
        if (iLynxGlobalConfigService == null || (cls = iLynxGlobalConfigService.getModelType()) == null) {
            cls = BDXLynxKitModel.class;
        }
        ISchemaModel generateSchemaModel = SchemaService.INSTANCE.getInstance().generateSchemaModel(data, cls);
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 != null) {
            bulletContext2.setSchemaModelUnion(new SchemaModelUnion(data));
        }
        BulletContext bulletContext3 = this.bulletContext;
        SchemaModelUnion schemaModelUnion = bulletContext3 != null ? bulletContext3.getSchemaModelUnion() : null;
        if (schemaModelUnion != null) {
            schemaModelUnion.setContainerModel(bDXContainerModel);
        }
        BulletContext bulletContext4 = this.bulletContext;
        SchemaModelUnion schemaModelUnion2 = bulletContext4 != null ? bulletContext4.getSchemaModelUnion() : null;
        if (schemaModelUnion2 != null) {
            schemaModelUnion2.setUiModel(bDXPageModel);
        }
        BulletContext bulletContext5 = this.bulletContext;
        SchemaModelUnion schemaModelUnion3 = bulletContext5 != null ? bulletContext5.getSchemaModelUnion() : null;
        if (schemaModelUnion3 != null) {
            schemaModelUnion3.setKitModel(generateSchemaModel);
        }
        BulletContext bulletContext6 = this.bulletContext;
        if (bulletContext6 != null && (schemeContext = bulletContext6.getSchemeContext()) != null && (packages = schemeContext.getPackages()) != null) {
            Iterator<T> it = packages.iterator();
            while (it.hasNext()) {
                ILynxGlobalConfigService iLynxGlobalConfigService2 = (ILynxGlobalConfigService) ServiceCenter.INSTANCE.instance().get((String) it.next(), ILynxGlobalConfigService.class);
                if (iLynxGlobalConfigService2 != null && (extraModelType = iLynxGlobalConfigService2.getExtraModelType()) != null) {
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
        BulletContext bulletContext7 = this.bulletContext;
        BulletSchemeContext schemeContext3 = bulletContext7 != null ? bulletContext7.getSchemeContext() : null;
        if (schemeContext3 != null) {
            schemeContext3.setExtraSchemaModelList(arrayList);
        }
        BulletContext bulletContext8 = this.bulletContext;
        this.useXBridge3 = bulletContext8 != null ? BulletContextKt.useXBride3(bulletContext8) : false;
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "DefaultLynxDelegate.generateSchemaModel, useXBridge3=" + this.useXBridge3, null, null, 6, null);
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public String getDebugUrl() {
        BDXLynxKitModel kitModel;
        UrlParam durl;
        Uri value;
        if (!BulletEnv.INSTANCE.getInstance().getDebuggable() || (kitModel = getKitModel()) == null || (durl = kitModel.getDurl()) == null || (value = durl.getValue()) == null) {
            return null;
        }
        return value.toString();
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public void setDebugInitialData(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.debugInitialData = data;
    }

    private final DynamicComponentFetcher getDynamicComponentFetcher() {
        ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
        BulletContext bulletContext = this.bulletContext;
        return (DynamicComponentFetcher) contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null).provideInstance(DynamicComponentFetcher.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getSourceUrl(BDXLynxKitModel kitModel) {
        Uri value;
        UrlParam surl;
        UrlParam aSurl;
        UrlParam url;
        Uri value2;
        String uri;
        UrlParam resUrl;
        String str = null;
        if (kitModel == null || (resUrl = kitModel.getResUrl()) == null || (value = resUrl.getValue()) == null) {
            value = (kitModel == null || (aSurl = kitModel.getASurl()) == null) ? null : aSurl.getValue();
            if (value == null) {
                value = (kitModel == null || (surl = kitModel.getSurl()) == null) ? null : surl.getValue();
            }
        }
        if (value == null || (uri = value.toString()) == null) {
            BDXContainerModel containerModel = getContainerModel();
            if (containerModel != null && (url = containerModel.getUrl()) != null && (value2 = url.getValue()) != null) {
                str = ExtKt.safeGetQueryParameter(value2, "url");
            }
        } else {
            str = uri;
        }
        return str == null ? "" : str;
    }

    private final void updateGlobalPropsByDiff(Map<?, ?> diffProps) {
        boolean z;
        Map<String, Object> map = this.rootPageGlobalProps;
        if (map != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<?, ?> entry : diffProps.entrySet()) {
                Object key = entry.getKey();
                String str = null;
                if (key != null) {
                    boolean z2 = key instanceof String;
                    Object obj = key;
                    if (!z2) {
                        obj = null;
                    }
                    if (obj != null) {
                        str = (String) obj;
                    }
                }
                if (str != null) {
                    if (str.length() > 0) {
                        z = true;
                        if (z && entry.getValue() != null) {
                            linkedHashMap.put("key", MapsKt.mapOf(new Pair[]{TuplesKt.to("old_value", String.valueOf(map.get(str))), TuplesKt.to("new_value", String.valueOf(entry.getValue()))}));
                            Object value = entry.getValue();
                            Intrinsics.checkNotNull(value);
                            map.put(str, value);
                        }
                    }
                }
                z = false;
                if (z) {
                    linkedHashMap.put("key", MapsKt.mapOf(new Pair[]{TuplesKt.to("old_value", String.valueOf(map.get(str))), TuplesKt.to("new_value", String.valueOf(entry.getValue()))}));
                    Object value2 = entry.getValue();
                    Intrinsics.checkNotNull(value2);
                    map.put(str, value2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LynxEngineGlobalConfig getLynxEngineConfig() {
        BulletLynxContext lynxContext;
        BulletLynxContext lynxContext2;
        BulletContext bulletContext = this.bulletContext;
        IEngineGlobalConfig iEngineGlobalConfig = null;
        if (!(((bulletContext == null || (lynxContext2 = bulletContext.getLynxContext()) == null) ? null : lynxContext2.getLynxGlobalConfig()) instanceof LynxEngineGlobalConfig)) {
            return null;
        }
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 != null && (lynxContext = bulletContext2.getLynxContext()) != null) {
            iEngineGlobalConfig = lynxContext.getLynxGlobalConfig();
        }
        Intrinsics.checkNotNull(iEngineGlobalConfig, "null cannot be cast to non-null type com.bytedance.ies.bullet.lynx.impl.LynxEngineGlobalConfig");
        return (LynxEngineGlobalConfig) iEngineGlobalConfig;
    }

    private final void initSecureDep(LynxView view, LynxBDXBridge lynxBDXBridge) {
        ArgusLynxDelegateAdapter attachView;
        ArgusLynxDelegate delegate;
        ArgusLynxDelegateAdapter argusAdapter = getArgusAdapter();
        if (argusAdapter == null || (attachView = argusAdapter.attachView(view)) == null || (delegate = attachView.getDelegate()) == null || lynxBDXBridge == null) {
            return;
        }
        lynxBDXBridge.setAuthDelegate(delegate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArgusLynxDelegateAdapter initSecureDelegate() {
        return ArgusLynxDelegateAdapter.INSTANCE.build(new SecureProviderFactory() { // from class: com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate$initSecureDelegate$provider$1
            @Override // com.bytedance.ies.bullet.secure.SecureProviderFactory
            public Boolean enablePIA() {
                return SecureProviderFactory.DefaultImpls.enablePIA(this);
            }

            @Override // com.bytedance.ies.bullet.secure.SecureProviderFactory
            public IWebSecureDelegate getExternDelegate() {
                return SecureProviderFactory.DefaultImpls.getExternDelegate(this);
            }

            @Override // com.bytedance.ies.bullet.secure.SecureProviderFactory
            public String getSchema() {
                return SecureProviderFactory.DefaultImpls.getSchema(this);
            }

            @Override // com.bytedance.ies.bullet.secure.SecureProviderFactory
            /* renamed from: getSecLinkScene */
            public String get$scene() {
                return SecureProviderFactory.DefaultImpls.getSecLinkScene(this);
            }

            @Override // com.bytedance.ies.bullet.secure.SecureProviderFactory
            public BulletContext getContext() {
                return DefaultLynxDelegate.this.getBulletContext();
            }
        }, null);
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public void registerSecureService(ArgusBaseBizService service) {
        ArgusLynxDelegate delegate;
        Intrinsics.checkNotNullParameter(service, "service");
        ArgusLynxDelegateAdapter argusAdapter = getArgusAdapter();
        if (argusAdapter == null || (delegate = argusAdapter.getDelegate()) == null) {
            return;
        }
        delegate.setBizContext(service);
    }

    @Override // com.bytedance.ies.bullet.lynx.AbsLynxDelegate
    public BulletContext getContext() {
        return this.bulletContext;
    }

    private final void lynxClientRunSafe(Function1<? super ILynxClientDelegate, Unit> handler) {
        try {
            DefaultLynxDelegate defaultLynxDelegate = this;
            LynxEngineGlobalConfig lynxEngineConfig = getLynxEngineConfig();
            if (lynxEngineConfig != null) {
                Iterator<T> it = lynxEngineConfig.getLynxClientDelegates().iterator();
                while (it.hasNext()) {
                    handler.invoke((ILynxClientDelegate) it.next());
                }
            }
        } catch (YieldError unused) {
        }
    }
}
