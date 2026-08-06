package com.bytedance.android.anniex.p026ui;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import bolts.Task;
import com.bytedance.android.anniex.ability.EventHelper;
import com.bytedance.android.anniex.ability.GlobalPropsHelper;
import com.bytedance.android.anniex.ability.XBridgeHelper;
import com.bytedance.android.anniex.api.AnnieXLynxModelBuilder;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient;
import com.bytedance.android.anniex.engine.AnnieXLynxEngine;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.monitor.AnnieXCardScene;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.p026ui.IAnnieXLifeCycle;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.scene.data.SceneDbContract;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.android.anniex.solutions.card.AirSolution;
import com.bytedance.android.anniex.solutions.card.AirSolutionContext;
import com.bytedance.android.anniex.solutions.card.AirSolutionHelper;
import com.bytedance.android.anniex.solutions.card.data.DataCenter;
import com.bytedance.android.anniex.solutions.card.dispatcher.AirSolutionLynxViewClient;
import com.bytedance.android.anniex.utils.DebugTagDrawable;
import com.bytedance.android.anniex.utils.IAnnieXLatchService;
import com.bytedance.android.anniex.utils.LynxViexExtKt;
import com.bytedance.android.anniex.utils.UrlExtKt;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.crash.Npth;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.argus.api.ArgusLynxDelegate;
import com.bytedance.ies.argus.api.interfaces.service.ArgusBaseBizService;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.common.DebugConfig;
import com.bytedance.ies.bullet.core.common.DebugInfo;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.deprecate.fake.ContainerBidParam;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.ForestLynxSSRProcessor;
import com.bytedance.ies.bullet.forest.ForestResourceInfo;
import com.bytedance.ies.bullet.forest.LynxSSRData;
import com.bytedance.ies.bullet.forest.TemplateBundleProcessor;
import com.bytedance.ies.bullet.lynx.impl.DefaultImageInterceptor;
import com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate;
import com.bytedance.ies.bullet.lynx.init.LynxGroupHolder;
import com.bytedance.ies.bullet.secure.ArgusLynxDelegateAdapter;
import com.bytedance.ies.bullet.secure.SecureProviderFactory;
import com.bytedance.ies.bullet.service.base.BulletPageUrl;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.ui.common.Orientation;
import com.bytedance.ies.bullet.ui.common.utils.OnScreenCaptureListener;
import com.bytedance.ies.bullet.ui.common.utils.ScreenCaptureUtils;
import com.bytedance.ies.bullet.ui.common.utils.ScreenInfo;
import com.bytedance.ies.bullet.ui.common.utils.ViewUtil;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.optimize.RuntimeConfig;
import com.bytedance.sdk.xbridge.cn.optimize.ThreadOptConfig;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeContext;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.RefType;
import com.google.gson.Gson;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxLoadMeta;
import com.lynx.tasm.LynxLoadMode;
import com.lynx.tasm.LynxLoadOption;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxUpdateMeta;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ImageInterceptor;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: AnnieXLynxView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 È\u00012\u00020\u0001:\u0002È\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001d\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010(¢\u0006\u0002\u00106J\u0018\u00107\u001a\u0002022\u0010\u00108\u001a\f\u0012\u0004\u0012\u00020209j\u0002`:J\u0012\u0010;\u001a\u0002022\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0006\u0010>\u001a\u000202J\u000e\u0010?\u001a\u0002022\u0006\u0010\u0006\u001a\u00020\u0005J2\u0010@\u001a\u0002022\u0006\u0010A\u001a\u00020B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010F\u001a\u00020GH\u0002J8\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010A\u001a\u00020B2\u0006\u0010J\u001a\u00020\u001d2\u0006\u0010K\u001a\u00020\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010L2\b\b\u0002\u0010M\u001a\u00020\u001dH\u0002J\u001c\u0010N\u001a\u0004\u0018\u00010I2\u0006\u0010A\u001a\u00020B2\b\b\u0002\u0010J\u001a\u00020\u001dH\u0002J\b\u0010O\u001a\u000202H\u0016J$\u0010P\u001a\u0002022\u0006\u0010Q\u001a\u00020\u00052\u0014\b\u0002\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150SJ$\u0010T\u001a\u0002022\b\u0010E\u001a\u0004\u0018\u00010\u00172\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010A\u001a\u00020BH\u0007J\b\u0010U\u001a\u00020=H\u0002J\u0014\u0010V\u001a\u0004\u0018\u00010\u00102\b\u0010A\u001a\u0004\u0018\u00010BH\u0002J\u0006\u0010W\u001a\u00020\u0005J\u000f\u0010X\u001a\u0004\u0018\u00010DH\u0000¢\u0006\u0002\bYJ!\u0010Z\u001a\u0004\u0018\u0001H[\"\u0004\b\u0000\u0010[2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002H[0]¢\u0006\u0002\u0010^J\u001e\u0010_\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0015\u0018\u00010S2\u0006\u0010A\u001a\u00020BH\u0002J\u0006\u0010`\u001a\u00020\u001dJ\u000f\u0010a\u001a\u0004\u0018\u00010*H\u0000¢\u0006\u0002\bbJ\u0006\u0010c\u001a\u00020\u0005J:\u0010d\u001a\u0002022\f\u0010e\u001a\b\u0012\u0004\u0012\u00020g0f2\u0006\u0010A\u001a\u00020B2\u0006\u0010h\u001a\u00020i2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00172\u0006\u0010J\u001a\u00020\u001dH\u0002J4\u0010j\u001a\u0002022\u0006\u0010e\u001a\u00020k2\u0006\u0010A\u001a\u00020B2\u0006\u0010h\u001a\u00020i2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00172\u0006\u0010J\u001a\u00020\u001dH\u0002J\u001d\u0010l\u001a\u0004\u0018\u0001022\u0006\u0010#\u001a\u00020$2\u0006\u0010m\u001a\u00020B¢\u0006\u0002\u0010nJ\u0018\u0010o\u001a\u0002022\u0006\u0010#\u001a\u00020$2\u0006\u0010m\u001a\u00020BH\u0002J\u0016\u0010p\u001a\u0002022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010q\u001a\u0002022\u0006\u0010r\u001a\u00020I2\b\b\u0002\u0010M\u001a\u00020\u001dH\u0002J&\u0010s\u001a\u0002022\u0006\u0010A\u001a\u00020B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0017J0\u0010s\u001a\u0002022\u0006\u0010A\u001a\u00020B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010J\u001a\u00020\u001dJ,\u0010t\u001a\u0002022\u0006\u0010A\u001a\u00020B2\u0006\u0010h\u001a\u00020i2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00172\u0006\u0010J\u001a\u00020\u001dH\u0002J4\u0010u\u001a\u0002022\u0006\u0010A\u001a\u00020B2\u0006\u0010v\u001a\u00020w2\u0006\u0010h\u001a\u00020i2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00172\u0006\u0010J\u001a\u00020\u001dH\u0002J>\u0010x\u001a\u0002022\u0006\u0010A\u001a\u00020B2\b\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010)\u001a\u00020L2\u0006\u0010h\u001a\u00020i2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00172\u0006\u0010J\u001a\u00020\u001dH\u0002JB\u0010{\u001a\u0002022\u0006\u0010A\u001a\u00020B2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020w0f2\u0006\u0010)\u001a\u00020L2\u0006\u0010h\u001a\u00020i2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00172\u0006\u0010J\u001a\u00020\u001dH\u0002J,\u0010}\u001a\u0002022\u0006\u0010A\u001a\u00020B2\u0006\u0010h\u001a\u00020i2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00172\u0006\u0010J\u001a\u00020\u001dH\u0002J\b\u0010~\u001a\u000202H\u0002J\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001J!\u0010\u0081\u0001\u001a\u0002022\u0006\u0010A\u001a\u00020B2\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001¢\u0006\u0003\u0010\u0084\u0001J\u0019\u0010\u0085\u0001\u001a\u0002022\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001¢\u0006\u0003\u0010\u0086\u0001J\u0010\u0010\u0087\u0001\u001a\u0002022\u0007\u0010\u0088\u0001\u001a\u00020(J\t\u0010\u0089\u0001\u001a\u000202H\u0014J\u0015\u0010\u008a\u0001\u001a\u0002022\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0014J\t\u0010\u008d\u0001\u001a\u000202H\u0014J\u0007\u0010\u008e\u0001\u001a\u000202J7\u0010\u008f\u0001\u001a\u0002022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0007\u0010\u0090\u0001\u001a\u00020(2\u0007\u0010\u0091\u0001\u001a\u00020\u00052\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0017H\u0002J\u0013\u0010\u0092\u0001\u001a\u0002022\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0002J\u0007\u0010\u0093\u0001\u001a\u000202J\u0011\u0010\u0094\u0001\u001a\u0002022\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001J6\u0010\u0097\u0001\u001a\u000202\"\u0004\b\u0000\u0010[2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002H[0]2\u0007\u0010\u0098\u0001\u001a\u0002H[2\n\b\u0002\u0010\u0099\u0001\u001a\u00030\u009a\u0001¢\u0006\u0003\u0010\u009b\u0001J'\u0010\u009c\u0001\u001a\u0002022\u0006\u0010A\u001a\u00020B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0017J1\u0010\u009c\u0001\u001a\u0002022\u0006\u0010A\u001a\u00020B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010J\u001a\u00020\u001dJ\t\u0010\u009d\u0001\u001a\u000202H\u0002J\u000f\u0010\u009e\u0001\u001a\u0002022\u0006\u0010A\u001a\u00020BJ'\u0010\u009f\u0001\u001a\u0002022\u0007\u0010 \u0001\u001a\u00020w2\b\u0010r\u001a\u0004\u0018\u00010I2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u0005H\u0017J)\u0010¢\u0001\u001a\u0002022\t\u0010£\u0001\u001a\u0004\u0018\u00010z2\b\u0010r\u001a\u0004\u0018\u00010I2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J6\u0010¤\u0001\u001a\u0002022\u0006\u0010A\u001a\u00020B2\u0006\u0010h\u001a\u00020i2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00172\u0006\u0010J\u001a\u00020\u001d2\u0007\u0010¥\u0001\u001a\u00020\u001dH\u0002J,\u0010¦\u0001\u001a\u0002022\u0006\u0010)\u001a\u00020L2\u0006\u0010A\u001a\u00020B2\b\u0010E\u001a\u0004\u0018\u00010\u00172\u0007\u0010§\u0001\u001a\u00020\u0005H\u0002J'\u0010¨\u0001\u001a\u0002022\u0006\u0010A\u001a\u00020B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0017J\u0014\u0010¨\u0001\u001a\u0002022\t\u0010©\u0001\u001a\u0004\u0018\u00010IH\u0016J\u001e\u0010¨\u0001\u001a\u0002022\u0015\u0010©\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00150SJ\u0018\u0010ª\u0001\u001a\u0002022\r\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020209H\u0002J&\u0010¬\u0001\u001a\u0002022\u0007\u0010\u00ad\u0001\u001a\u00020\u00052\t\u0010®\u0001\u001a\u0004\u0018\u00010\u00152\t\b\u0002\u0010¯\u0001\u001a\u00020\u001dJ \u0010°\u0001\u001a\u0002022\u0015\u0010±\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\u000f\u0010²\u0001\u001a\u0002022\u0006\u0010\u001b\u001a\u00020\u0005J\u0014\u0010³\u0001\u001a\u0002022\t\u0010´\u0001\u001a\u0004\u0018\u00010\u0005H\u0002J\u0019\u0010µ\u0001\u001a\u0002022\b\u0010)\u001a\u0004\u0018\u00010*H\u0000¢\u0006\u0003\b¶\u0001J#\u0010·\u0001\u001a\u0002022\u0007\u0010¸\u0001\u001a\u00020\u001d2\u0011\u0010¹\u0001\u001a\f\u0012\u0005\u0012\u00030»\u0001\u0018\u00010º\u0001J\u0017\u0010¼\u0001\u001a\u0002022\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0003\b½\u0001J\u000f\u0010¾\u0001\u001a\u0002022\u0006\u0010/\u001a\u000200J\u0010\u0010¿\u0001\u001a\u0002022\u0007\u0010À\u0001\u001a\u00020\u0005J\u001b\u0010Á\u0001\u001a\u000202\"\u0004\b\u0000\u0010[2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002H[0]J'\u0010Â\u0001\u001a\u0002022\u0006\u0010A\u001a\u00020B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0017J\u0014\u0010Â\u0001\u001a\u0002022\t\u0010©\u0001\u001a\u0004\u0018\u00010IH\u0016J \u0010Â\u0001\u001a\u0002022\u0015\u0010©\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00150SH\u0016J\u0012\u0010Ã\u0001\u001a\u0002022\u0007\u0010±\u0001\u001a\u00020IH\u0016J\u001e\u0010Ã\u0001\u001a\u0002022\u0013\u0010±\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150SH\u0016J'\u0010Ä\u0001\u001a\u0002022\u0006\u0010A\u001a\u00020B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0017J\u001b\u0010Å\u0001\u001a\u0002022\u0007\u0010Æ\u0001\u001a\u00020(2\u0007\u0010Ç\u0001\u001a\u00020(H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006É\u0001"}, d2 = {"Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "Lcom/lynx/tasm/LynxView;", "context", "Landroid/content/Context;", "sessionId", "", "bid", "builder", "Lcom/lynx/tasm/LynxViewBuilder;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/lynx/tasm/LynxViewBuilder;)V", "annieXLynxEngine", "Lcom/bytedance/android/anniex/engine/AnnieXLynxEngine;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/anniex/engine/AnnieXLynxEngine;)V", "airSolution", "Lcom/bytedance/android/anniex/solutions/card/AirSolution;", "argusAdapter", "Lcom/bytedance/ies/bullet/secure/ArgusLynxDelegateAdapter;", "asyncImageClient", "Lcom/bytedance/android/anniex/ui/AnnieXDefaultLynxViewClient;", "cacheGlobalProps", "", "", "currentLifeCycle", "Lcom/bytedance/android/anniex/ui/IAnnieXLifeCycle;", "currentLifeCycleRef", "Ljava/lang/ref/WeakReference;", "debugTag", "groupName", "isColdStart", "", "isFromEngine", "isViewFirstAppeared", "lastOrientation", "Lcom/bytedance/ies/bullet/ui/common/Orientation;", "lastUrl", "lynxBDXBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;", "lynxViewClient", "optLokiDestroy", "optimizeFlag", "", "resourceInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "scene", "Lcom/bytedance/ies/bullet/core/common/Scenes;", "screenCaptureListener", "Lcom/bytedance/ies/bullet/ui/common/utils/OnScreenCaptureListener;", "viewZoom", "", "addCustomMethodFinder", "", "finder", "Lcom/bytedance/sdk/xbridge/cn/protocol/MethodFinder;", "index", "(Lcom/bytedance/sdk/xbridge/cn/protocol/MethodFinder;Ljava/lang/Integer;)V", "addDelayExecuteBlock", "block", "Lkotlin/Function0;", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBridgeDelayExecuteBlock;", "addLynxViewClient", "client", "Lcom/lynx/tasm/LynxViewClient;", "addScreenCaptureListener", "addTagView", "beforeLoadTemplate", "annieXLynxModel", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "annieXLifeCycle", "annieXCardScene", "Lcom/bytedance/android/anniex/monitor/AnnieXCardScene;", "completeGlobalPropsForLoad", "Lcom/lynx/tasm/TemplateData;", "modelGlobalPropsFirst", "resFrom", "Lcom/bytedance/ies/bullet/forest/ForestResourceInfo;", "saveToCache", "completeGlobalPropsForReload", "destroy", "dispatchAirSolutionAction", "actionName", "realArguments", "", "flushAllStickyEvents", "getAirSolutionLynxViewClient", "getArgusSecureAdapter", "getBid", "getBridgeContextProviderFactory", "getBridgeContextProviderFactory$anniex_release", "getBridgeContextService", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getGlobalPropsByActivityInternal", "getIsFromEngine", "getResourceInfo", "getResourceInfo$anniex_release", "getSessionId", "handleLynxSSRResponse", "response", "Lcom/bytedance/forest/postprocessor/ProcessedResponse;", "Lcom/bytedance/ies/bullet/forest/LynxSSRData;", "loadMode", "Lcom/lynx/tasm/LynxLoadMode;", "handleResponseWithLoadTemplateWithUrl", "Lcom/bytedance/forest/model/Response;", "initBridge", "lynxViewModel", "(Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;Lcom/bytedance/android/anniex/model/AnnieXLynxModel;)Lkotlin/Unit;", "initBridgeSecureDep", "initialize", "injectGlobalProps", "templateData", "load", "loadTemplateWithExternalTemplateArray", "loadTemplateWithExternalTemplateBundle", "templateBundle", "Lcom/lynx/tasm/TemplateBundle;", "loadTemplateWithInternalTemplateArray", "byteArray", "", "loadTemplateWithInternalTemplateBundle", "templateBundleResponse", "loadTemplateWithUrl", "lokiDestroy", "lynxDevTool", "Lcom/lynx/devtoolwrapper/LynxDevtool;", "markOpenTime", SceneDbContract.Scenes.COLUMN_TIMESTAMP, "", "(Lcom/bytedance/android/anniex/model/AnnieXLynxModel;Ljava/lang/Long;)V", "markOpenTimeForReload", "(Ljava/lang/Long;)V", "markOptimizeFlag", "flag", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "onHide", "onLoadFail", "errorCode", "errorMessage", "onOrientationChanged", "onShow", "registerSecureService", "service", "Lcom/bytedance/ies/argus/api/interfaces/service/ArgusBaseBizService;", "registerService", "t", "refType", "Lcom/bytedance/sdk/xbridge/cn/registry/core/RefType;", "(Ljava/lang/Class;Ljava/lang/Object;Lcom/bytedance/sdk/xbridge/cn/registry/core/RefType;)V", "reloadTemplate", "removeScreenCaptureListener", "renderSSRHydrate", "renderTemplateBundle", "bundle", "baseUrl", "renderTemplateWithBaseUrl", "template", "requestLynxSSRData", "preDecode", "requestLynxSSRHydrate", "baseErrorMessage", "resetData", Constants.KEY_DATA, "runOnUiThread", StrategyConstants.ACTION, "sendEvent", "eventName", "params", "compatible", "setGlobalProps", "props", "setGroupName", "setNpthLastUrl", StreamTrafficObservable.STREAM_URL, "setResourceInfo", "setResourceInfo$anniex_release", "setThreadOpt", "isThreadOptEnable", "config", "", "Lcom/bytedance/sdk/xbridge/cn/optimize/ThreadOptConfig;", "setViewScene", "setViewScene$anniex_release", "setViewZoom", "showLynxRedError", "errorMsg", "unRegisterService", "updateData", "updateGlobalProps", "updateMetaData", "updateScreenMetrics", "width", "height", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxView extends LynxView {
    private static final String BULLET_UPDATE_TYPE = "bullet_update_type";
    public static final int ERROR_AUTH_TEMPLATE_FAILED = -1;
    public static final int ERROR_BYTE_ARRAY_IS_EMPTY = -2;
    public static final int ERROR_LOAD_TEMPLATE_FAILED = -3;
    private static final String TAG = "AnnieXLynxView===";
    private AirSolution airSolution;
    private ArgusLynxDelegateAdapter argusAdapter;
    private AnnieXDefaultLynxViewClient asyncImageClient;
    private String bid;
    private Map<String, Object> cacheGlobalProps;
    private IAnnieXLifeCycle currentLifeCycle;
    private WeakReference<IAnnieXLifeCycle> currentLifeCycleRef;
    private String debugTag;
    private String groupName;
    private boolean isColdStart;
    private boolean isFromEngine;
    private boolean isViewFirstAppeared;
    private Orientation lastOrientation;
    private String lastUrl;
    private LynxBDXBridge lynxBDXBridge;
    private AnnieXDefaultLynxViewClient lynxViewClient;
    private boolean optLokiDestroy;
    private int optimizeFlag;
    private ResourceInfo resourceInfo;
    private Scenes scene;
    private OnScreenCaptureListener screenCaptureListener;
    private String sessionId;
    private float viewZoom;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean SHOW_DEBUG_TAG = true;

    /* compiled from: AnnieXLynxView.kt */
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

    /* compiled from: AnnieXLynxView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/ui/AnnieXLynxView$Companion;", "", "()V", "BULLET_UPDATE_TYPE", "", "ERROR_AUTH_TEMPLATE_FAILED", "", "ERROR_BYTE_ARRAY_IS_EMPTY", "ERROR_LOAD_TEMPLATE_FAILED", "SHOW_DEBUG_TAG", "", "getSHOW_DEBUG_TAG", "()Z", "setSHOW_DEBUG_TAG", "(Z)V", "TAG", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getSHOW_DEBUG_TAG() {
            return AnnieXLynxView.SHOW_DEBUG_TAG;
        }

        public final void setSHOW_DEBUG_TAG(boolean z) {
            AnnieXLynxView.SHOW_DEBUG_TAG = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXLynxView(Context context, String str, String str2, LynxViewBuilder lynxViewBuilder) {
        super(context, lynxViewBuilder);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "bid");
        Intrinsics.checkNotNullParameter(lynxViewBuilder, "builder");
        this.sessionId = "";
        this.bid = "";
        this.debugTag = "";
        this.scene = Scenes.Card;
        this.cacheGlobalProps = new LinkedHashMap();
        this.lastOrientation = Orientation.UNKNOWN;
        this.viewZoom = 1.0f;
        this.isViewFirstAppeared = true;
        initialize(str, str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXLynxView(Context context, String str, String str2, AnnieXLynxEngine annieXLynxEngine) {
        super(context, annieXLynxEngine.getImpl());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "bid");
        Intrinsics.checkNotNullParameter(annieXLynxEngine, "annieXLynxEngine");
        this.sessionId = "";
        this.bid = "";
        this.debugTag = "";
        this.scene = Scenes.Card;
        this.cacheGlobalProps = new LinkedHashMap();
        this.lastOrientation = Orientation.UNKNOWN;
        this.viewZoom = 1.0f;
        this.isViewFirstAppeared = true;
        this.lynxViewClient = annieXLynxEngine.getLynxEngineClient();
        this.isFromEngine = true;
        this.debugTag = "engine";
        ArgusLynxDelegateAdapter argusDelegate$anniex_release = annieXLynxEngine.getArgusDelegate$anniex_release();
        this.argusAdapter = argusDelegate$anniex_release != null ? argusDelegate$anniex_release.attachView(this) : null;
        initialize(str, str2);
    }

    public final void initialize(String sessionId, String bid) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(bid, "bid");
        TraceEvent.beginSection("AnnieXLynxView:init_block");
        if (!TraceEvent.enableTrace()) {
            Log.d(TAG, "===init===: " + this);
        }
        this.sessionId = sessionId;
        this.bid = bid;
        if (!Intrinsics.areEqual("Loki", bid)) {
            if (!this.isFromEngine) {
                AnnieXDefaultLynxViewClient annieXDefaultLynxViewClient = new AnnieXDefaultLynxViewClient(this, sessionId, bid);
                this.lynxViewClient = annieXDefaultLynxViewClient;
                addLynxViewClient((LynxViewClient) annieXDefaultLynxViewClient);
            }
            this.asyncImageClient = new AnnieXDefaultLynxViewClient(this, sessionId, bid);
            LynxViewClient lynxViewClient = this.asyncImageClient;
            Intrinsics.checkNotNull(lynxViewClient);
            setAsyncImageInterceptor((ImageInterceptor) new DefaultImageInterceptor(lynxViewClient));
            addLynxViewClient(getAirSolutionLynxViewClient());
        }
        TraceEvent.endSection("AnnieXLynxView:init_block");
    }

    public void addLynxViewClient(LynxViewClient client) {
        if (this.isFromEngine) {
            AnnieXDefaultLynxViewClient annieXDefaultLynxViewClient = this.lynxViewClient;
            if (annieXDefaultLynxViewClient != null) {
                annieXDefaultLynxViewClient.addClient(client);
                return;
            }
            return;
        }
        super.addLynxViewClient(client);
    }

    public final boolean getIsFromEngine() {
        return this.isFromEngine;
    }

    /* renamed from: getResourceInfo$anniex_release, reason: from getter */
    public final ResourceInfo getResourceInfo() {
        return this.resourceInfo;
    }

    public final void setResourceInfo$anniex_release(ResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    public final ContextProviderFactory getBridgeContextProviderFactory$anniex_release() {
        LynxBridgeContext lynxBridgeContext;
        LynxBDXBridge lynxBDXBridge = this.lynxBDXBridge;
        if (lynxBDXBridge == null || (lynxBridgeContext = lynxBDXBridge.getLynxBridgeContext()) == null) {
            return null;
        }
        return (ContextProviderFactory) lynxBridgeContext.getService(ContextProviderFactory.class);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getBid() {
        return this.bid;
    }

    public final void setThreadOpt(boolean isThreadOptEnable, List<ThreadOptConfig> config) {
        LynxBDXBridge lynxBDXBridge = this.lynxBDXBridge;
        if (lynxBDXBridge != null) {
            lynxBDXBridge.setThreadOpt(isThreadOptEnable, config);
        }
    }

    public final void addDelayExecuteBlock(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        LynxBDXBridge lynxBDXBridge = this.lynxBDXBridge;
        if (lynxBDXBridge != null) {
            lynxBDXBridge.addDelayExecuteBlock(block);
        }
    }

    public static /* synthetic */ void registerService$default(AnnieXLynxView annieXLynxView, Class cls, Object obj, RefType refType, int i, Object obj2) {
        if ((i & 4) != 0) {
            refType = RefType.WEAK;
        }
        annieXLynxView.registerService(cls, obj, refType);
    }

    public final <T> void registerService(Class<T> clazz, T t, RefType refType) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(refType, "refType");
        LynxBDXBridge lynxBDXBridge = this.lynxBDXBridge;
        if (lynxBDXBridge != null) {
            lynxBDXBridge.registerService(clazz, t, refType);
        }
    }

    public final <T> T getBridgeContextService(Class<T> clazz) {
        LynxBridgeContext lynxBridgeContext;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        LynxBDXBridge lynxBDXBridge = this.lynxBDXBridge;
        if (lynxBDXBridge == null || (lynxBridgeContext = lynxBDXBridge.getLynxBridgeContext()) == null) {
            return null;
        }
        return (T) lynxBridgeContext.getService(clazz);
    }

    public final <T> void unRegisterService(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        LynxBDXBridge lynxBDXBridge = this.lynxBDXBridge;
        if (lynxBDXBridge != null) {
            lynxBDXBridge.unRegisterService(clazz);
        }
    }

    public final void addCustomMethodFinder(MethodFinder finder, Integer index) {
        Intrinsics.checkNotNullParameter(finder, "finder");
        if (Intrinsics.areEqual(this.bid, "annie_ecommerce") && IConditionCallKt.fixAnnieXMethodFinder()) {
            LynxBDXBridge lynxBDXBridge = this.lynxBDXBridge;
            if (lynxBDXBridge != null) {
                lynxBDXBridge.addCustomMethodFinder(finder, 0);
                return;
            }
            return;
        }
        LynxBDXBridge lynxBDXBridge2 = this.lynxBDXBridge;
        if (lynxBDXBridge2 != null) {
            lynxBDXBridge2.addCustomMethodFinder(finder, index);
        }
    }

    public static /* synthetic */ void sendEvent$default(AnnieXLynxView annieXLynxView, String str, Object obj, boolean z, int i, Object obj2) {
        if ((i & 4) != 0) {
            z = true;
        }
        annieXLynxView.sendEvent(str, obj, z);
    }

    public final void markOptimizeFlag(int flag) {
        this.optimizeFlag = flag | this.optimizeFlag;
    }

    public final void setViewScene$anniex_release(Scenes scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.scene = scene;
    }

    static /* synthetic */ void injectGlobalProps$default(AnnieXLynxView annieXLynxView, TemplateData templateData, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        annieXLynxView.injectGlobalProps(templateData, z);
    }

    private final void injectGlobalProps(TemplateData templateData, boolean saveToCache) {
        AirSolutionContext airSolutionContext;
        DataCenter dataCenter;
        Map<String, Object> globalProps;
        int i = this.optimizeFlag;
        boolean z = (i & 1) > 0;
        boolean z2 = (i & 2) > 0;
        if (saveToCache) {
            this.cacheGlobalProps.put("isColdStart", Boolean.valueOf(this.isColdStart));
            this.cacheGlobalProps.put("isPreCreate", Boolean.valueOf(z));
            this.cacheGlobalProps.put("isAsyncLayout", Boolean.valueOf(z2));
        }
        templateData.put("isColdStart", Boolean.valueOf(this.isColdStart));
        templateData.put("isPreCreate", Boolean.valueOf(z));
        templateData.put("isAsyncLayout", Boolean.valueOf(z2));
        templateData.put("isFromEngine", Boolean.valueOf(this.isFromEngine));
        AirSolution airSolution = this.airSolution;
        if (airSolution == null || (airSolutionContext = airSolution.getAirSolutionContext()) == null || (dataCenter = airSolutionContext.getDataCenter()) == null || (globalProps = dataCenter.getGlobalProps()) == null) {
            return;
        }
        globalProps.putAll(this.cacheGlobalProps);
    }

    public static /* synthetic */ void load$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle iAnnieXLifeCycle, int i, Object obj) {
        if ((i & 2) != 0) {
            contextProviderFactory = null;
        }
        if ((i & 4) != 0) {
            iAnnieXLifeCycle = null;
        }
        annieXLynxView.load(annieXLynxModel, contextProviderFactory, iAnnieXLifeCycle);
    }

    public static /* synthetic */ void load$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle iAnnieXLifeCycle, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            contextProviderFactory = null;
        }
        if ((i & 4) != 0) {
            iAnnieXLifeCycle = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        annieXLynxView.load(annieXLynxModel, contextProviderFactory, iAnnieXLifeCycle, z);
    }

    public static /* synthetic */ void reloadTemplate$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle iAnnieXLifeCycle, int i, Object obj) {
        if ((i & 2) != 0) {
            contextProviderFactory = null;
        }
        if ((i & 4) != 0) {
            iAnnieXLifeCycle = null;
        }
        annieXLynxView.reloadTemplate(annieXLynxModel, contextProviderFactory, iAnnieXLifeCycle);
    }

    public static /* synthetic */ void reloadTemplate$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle iAnnieXLifeCycle, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            contextProviderFactory = null;
        }
        if ((i & 4) != 0) {
            iAnnieXLifeCycle = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        annieXLynxView.reloadTemplate(annieXLynxModel, contextProviderFactory, iAnnieXLifeCycle, z);
    }

    public static /* synthetic */ void resetData$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle iAnnieXLifeCycle, int i, Object obj) {
        if ((i & 2) != 0) {
            contextProviderFactory = null;
        }
        if ((i & 4) != 0) {
            iAnnieXLifeCycle = null;
        }
        annieXLynxView.resetData(annieXLynxModel, contextProviderFactory, iAnnieXLifeCycle);
    }

    public static /* synthetic */ void updateData$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle iAnnieXLifeCycle, int i, Object obj) {
        if ((i & 2) != 0) {
            contextProviderFactory = null;
        }
        if ((i & 4) != 0) {
            iAnnieXLifeCycle = null;
        }
        annieXLynxView.updateData(annieXLynxModel, contextProviderFactory, iAnnieXLifeCycle);
    }

    public static /* synthetic */ void updateMetaData$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle iAnnieXLifeCycle, int i, Object obj) {
        if ((i & 2) != 0) {
            contextProviderFactory = null;
        }
        if ((i & 4) != 0) {
            iAnnieXLifeCycle = null;
        }
        annieXLynxView.updateMetaData(annieXLynxModel, contextProviderFactory, iAnnieXLifeCycle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void markOpenTime(AnnieXLynxModel annieXLynxModel, Long r4) {
        Intrinsics.checkNotNullParameter(annieXLynxModel, "annieXLynxModel");
        MonitorManager.INSTANCE.markOpenTime(annieXLynxModel.getSessionId(), r4);
        if (Intrinsics.areEqual(annieXLynxModel.getSessionId(), this.sessionId)) {
            return;
        }
        MonitorManager.INSTANCE.attachNewSessionId(annieXLynxModel.getSessionId(), (View) this, "lynx");
    }

    public final void markOpenTimeForReload(Long r3) {
        setExtraTiming(MapsKt.mapOf(TuplesKt.to("open_time", Long.valueOf(r3 != null ? r3.longValue() : System.currentTimeMillis()))));
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MonitorManager.INSTANCE.onAttachToWindow(this.sessionId, this.lastUrl);
    }

    public final void onShow() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isViewFirstAppeared", this.isViewFirstAppeared);
        Unit unit = Unit.INSTANCE;
        sendEvent$default(this, "viewAppeared", jSONObject, false, 4, null);
        onEnterForeground();
        this.isViewFirstAppeared = false;
        ScreenCaptureUtils.INSTANCE.setIsAppInBackground(false);
        AirSolution airSolution = this.airSolution;
        if (airSolution != null) {
            airSolution.dispatchLifecycle(AirActionConstant.AirSolutionLifecycle.OnShow);
        }
    }

    public final void onHide() {
        sendEvent$default(this, "viewDisappeared", null, false, 4, null);
        onEnterBackground();
        LynxBDXBridge lynxBDXBridge = this.lynxBDXBridge;
        RuntimeConfig runtimeConfig = lynxBDXBridge != null ? lynxBDXBridge.getRuntimeConfig() : null;
        if (runtimeConfig != null) {
            runtimeConfig.setAllowUseCache(false);
        }
        ScreenCaptureUtils.INSTANCE.setIsAppInBackground(true);
        AirSolution airSolution = this.airSolution;
        if (airSolution != null) {
            airSolution.dispatchLifecycle(AirActionConstant.AirSolutionLifecycle.OnHide);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void dispatchAirSolutionAction$default(AnnieXLynxView annieXLynxView, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        annieXLynxView.dispatchAirSolutionAction(str, map);
    }

    public final void dispatchAirSolutionAction(String actionName, Map<String, ? extends Object> realArguments) {
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(realArguments, "realArguments");
        AirSolution airSolution = this.airSolution;
        if (airSolution != null) {
            airSolution.dispatchAction(actionName, realArguments);
        }
    }

    public final void addScreenCaptureListener() {
        if (this.screenCaptureListener == null) {
            this.screenCaptureListener = new OnScreenCaptureListener() { // from class: com.bytedance.android.anniex.ui.AnnieXLynxView$addScreenCaptureListener$1
                public void onCapture(int responseType) {
                    HybridLogger.d$default(HybridLogger.INSTANCE, "AnnieX", "onUserCaptureScreen onCapture, responseType=" + responseType, (Map) null, (LoggerContext) null, 12, (Object) null);
                    if (responseType == 0) {
                        Handler handler = new Handler(Looper.getMainLooper());
                        final AnnieXLynxView annieXLynxView = AnnieXLynxView.this;
                        handler.post(new Runnable() { // from class: com.bytedance.android.anniex.ui.AnnieXLynxView$addScreenCaptureListener$1$onCapture$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                AnnieXLynxView.sendEvent$default(AnnieXLynxView.this, EventHelper.ON_USER_CAPTURE_SCREEN, null, false, 4, null);
                            }
                        });
                    }
                }
            };
            Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.ui.AnnieXLynxView$addScreenCaptureListener$2
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    OnScreenCaptureListener onScreenCaptureListener;
                    ScreenCaptureUtils screenCaptureUtils = ScreenCaptureUtils.INSTANCE;
                    Context applicationContext = AnnieXLynxView.this.getContext().getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                    onScreenCaptureListener = AnnieXLynxView.this.screenCaptureListener;
                    screenCaptureUtils.addScreenCaptureListener(applicationContext, onScreenCaptureListener);
                }
            });
        }
    }

    public void updateScreenMetrics(int width, int height) {
        if (width <= 0 || height <= 0) {
            return;
        }
        float f = this.viewZoom;
        int i = (int) (width * f);
        int i2 = (int) (height * f);
        super.updateScreenMetrics(i, i2);
        requestLayout();
        HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", "updateScreenMetrics w:" + i + " h:" + i2 + " view:" + this, (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    public void setGlobalProps(Map<String, Object> props) {
        if (props != null && Intrinsics.areEqual(this.bid, "Loki")) {
            Object obj = props.get("opt_loki_destroy");
            if (obj == null) {
                obj = false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.optLokiDestroy = ((Boolean) obj).booleanValue();
        }
        super.setGlobalProps(props);
    }

    public final void lokiDestroy() {
        MonitorManager.INSTANCE.removeMonitorInfo(this.sessionId);
        XBridgeHelper.INSTANCE.releaseContext(this.bid, this.lynxBDXBridge);
        ContextProviderManager.INSTANCE.unRegister(this.sessionId);
        AnnieXDefaultLynxViewClient annieXDefaultLynxViewClient = this.lynxViewClient;
        if (annieXDefaultLynxViewClient != null) {
            removeLynxViewClient((LynxViewClient) annieXDefaultLynxViewClient);
        }
        setAsyncImageInterceptor(null);
        this.cacheGlobalProps.clear();
        LynxBDXBridge lynxBDXBridge = this.lynxBDXBridge;
        if (lynxBDXBridge != null) {
            lynxBDXBridge.release();
        }
        String str = this.groupName;
        if (str != null) {
            LynxGroupHolder.INSTANCE.removeLynxGroup(str);
        }
        this.currentLifeCycle = null;
        ArgusLynxDelegateAdapter argusSecureAdapter = getArgusSecureAdapter(null);
        if (argusSecureAdapter != null) {
            argusSecureAdapter.onViewDestroy();
        }
        if (IConditionCallKt.enableFixDestroyWithOutForestRelease()) {
            ForestLoader.INSTANCE.release(this.sessionId);
        }
        super.destroy();
    }

    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig == null) {
            return;
        }
        onOrientationChanged(newConfig);
    }

    public final void setViewZoom(float viewZoom) {
        this.viewZoom = viewZoom;
    }

    public final void setGroupName(String groupName) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        this.groupName = groupName;
    }

    static /* synthetic */ void beforeLoadTemplate$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle iAnnieXLifeCycle, AnnieXCardScene annieXCardScene, int i, Object obj) {
        if ((i & 2) != 0) {
            contextProviderFactory = null;
        }
        if ((i & 4) != 0) {
            iAnnieXLifeCycle = null;
        }
        if ((i & 8) != 0) {
            annieXCardScene = AnnieXCardScene.NEW;
        }
        annieXLynxView.beforeLoadTemplate(annieXLynxModel, contextProviderFactory, iAnnieXLifeCycle, annieXCardScene);
    }

    public final void beforeLoadTemplate(AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle annieXLifeCycle, AnnieXCardScene annieXCardScene) {
        LynxBridgeContext lynxBridgeContext;
        if (!Intrinsics.areEqual(this.sessionId, annieXLynxModel.getSessionId())) {
            AnnieXCardScene annieXCardScene2 = annieXCardScene == AnnieXCardScene.NEW ? AnnieXCardScene.RELOAD : annieXCardScene;
            if (!TraceEvent.enableTrace()) {
                Log.d("AnnieXMonitorManager", "oldSession:" + this.sessionId + ", new:" + annieXLynxModel.getSessionId());
            }
            MonitorManager.INSTANCE.onLynxViewReused(this.sessionId, annieXLynxModel.getSessionId(), annieXCardScene2);
            this.debugTag = annieXCardScene2.getValue();
            MonitorManager.reportInfo$default(MonitorManager.INSTANCE, this.sessionId, true, null, null, false, 28, null);
            MonitorManager.INSTANCE.removeMonitorInfo(this.sessionId);
            ContextProviderManager.INSTANCE.unRegister(this.sessionId);
        } else {
            this.debugTag = annieXCardScene.getValue();
        }
        this.sessionId = annieXLynxModel.getSessionId();
        AnnieXDefaultLynxViewClient annieXDefaultLynxViewClient = this.lynxViewClient;
        if (annieXDefaultLynxViewClient != null) {
            annieXDefaultLynxViewClient.setSessionId(annieXLynxModel.getSessionId());
            annieXDefaultLynxViewClient.setBid(annieXLynxModel.getBid());
            annieXDefaultLynxViewClient.setCurrentLifeCycle(annieXLifeCycle);
        }
        AnnieXDefaultLynxViewClient annieXDefaultLynxViewClient2 = this.asyncImageClient;
        if (annieXDefaultLynxViewClient2 != null) {
            annieXDefaultLynxViewClient2.setSessionId(annieXLynxModel.getSessionId());
            annieXDefaultLynxViewClient2.setBid(annieXLynxModel.getBid());
        }
        this.lastUrl = annieXLynxModel.getUrl();
        MonitorManager.INSTANCE.onLoadStart(this.sessionId, annieXCardScene);
        LynxBDXBridge lynxBDXBridge = this.lynxBDXBridge;
        ContextProviderFactory contextProviderFactory2 = (lynxBDXBridge == null || (lynxBridgeContext = lynxBDXBridge.getLynxBridgeContext()) == null) ? null : (ContextProviderFactory) lynxBridgeContext.getService(ContextProviderFactory.class);
        if (contextProviderFactory != null && contextProviderFactory2 != null) {
            contextProviderFactory2.merge(contextProviderFactory);
        }
        if (contextProviderFactory2 != null) {
            String uri = annieXLynxModel.getOriginalUri().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "annieXLynxModel.originalUri.toString()");
            contextProviderFactory2.registerHolder(BulletPageUrl.class, new BulletPageUrl(uri));
        }
        if (IConditionCallKt.enableCardBidParamRegister() && contextProviderFactory2 != null) {
            contextProviderFactory2.registerHolder(ContainerBidParam.class, new ContainerBidParam(this.bid));
        }
        ContextProviderManager.INSTANCE.register(this.sessionId, contextProviderFactory);
        if (annieXLifeCycle != null) {
            this.currentLifeCycleRef = new WeakReference<>(annieXLifeCycle);
            if (IConditionCallKt.enableLynxCardLifeCycleFix()) {
                this.currentLifeCycle = annieXLifeCycle;
            }
            annieXLifeCycle.onLoadStart(annieXLynxModel.getOriginalUri(), this);
        }
    }

    static /* synthetic */ void onLoadFail$default(AnnieXLynxView annieXLynxView, String str, String str2, int i, String str3, IAnnieXLifeCycle iAnnieXLifeCycle, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            iAnnieXLifeCycle = null;
        }
        annieXLynxView.onLoadFail(str, str2, i, str3, iAnnieXLifeCycle);
    }

    static /* synthetic */ void loadTemplateWithExternalTemplateArray$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, LynxLoadMode lynxLoadMode, IAnnieXLifeCycle iAnnieXLifeCycle, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            iAnnieXLifeCycle = null;
        }
        annieXLynxView.loadTemplateWithExternalTemplateArray(annieXLynxModel, lynxLoadMode, iAnnieXLifeCycle, z);
    }

    public final void loadTemplateWithExternalTemplateArray(AnnieXLynxModel annieXLynxModel, LynxLoadMode loadMode, IAnnieXLifeCycle annieXLifeCycle, boolean modelGlobalPropsFirst) {
        if (annieXLynxModel.getTemplate() != null) {
            if (!(annieXLynxModel.getTemplate().getTemplateJS().length == 0)) {
                MonitorManager.INSTANCE.onPrepareTemplateBegin(annieXLynxModel.getSessionId());
                MonitorManager.INSTANCE.onPrepareTemplateEnd(annieXLynxModel.getSessionId());
                MonitorManager.INSTANCE.onLynxReadTemplateBegin(annieXLynxModel.getSessionId());
                MonitorManager.INSTANCE.onLynxReadTemplateEnd(annieXLynxModel.getSessionId(), null, (r17 & 4) != 0 ? "userInput" : "custom", (r17 & 8) != 0 ? 0L : 0L, (r17 & 16) != 0 ? 0.0d : 0.0d);
                setNpthLastUrl(annieXLynxModel.getUrl());
                if (annieXLynxModel.isSSR()) {
                    MonitorManager.INSTANCE.onLynxRenderTemplateBegin(annieXLynxModel.getSessionId());
                    TraceEvent.beginSection("AnnieXLynxView:renderSSR");
                    renderSSR(annieXLynxModel.getTemplate().getTemplateJS(), annieXLynxModel.getUrl(), annieXLynxModel.getTemplateData());
                    TraceEvent.endSection("AnnieXLynxView:renderSSR");
                    addTagView(this.bid);
                    MonitorManager.INSTANCE.onLynxRenderTemplateEnd(annieXLynxModel.getSessionId());
                    return;
                }
                if (annieXLifeCycle != null) {
                    annieXLifeCycle.onTemplateReady("custom", true);
                }
                TemplateData completeGlobalPropsForLoad = !annieXLynxModel.isCompactMode() ? completeGlobalPropsForLoad(annieXLynxModel, modelGlobalPropsFirst, "custom", null, false) : null;
                LynxLoadMeta.Builder builder = new LynxLoadMeta.Builder();
                builder.setUrl(annieXLynxModel.getUrl());
                builder.setBinaryData(annieXLynxModel.getTemplate().getTemplateJS());
                builder.setInitialData(annieXLynxModel.getTemplateData());
                if (completeGlobalPropsForLoad != null) {
                    builder.setGlobalProps(completeGlobalPropsForLoad);
                }
                builder.setLoadMode(loadMode);
                LynxLoadMeta build = builder.build();
                MonitorManager.INSTANCE.onLynxRenderTemplateBegin(annieXLynxModel.getSessionId());
                loadTemplate(build);
                MonitorManager.INSTANCE.onLynxRenderTemplateEnd(annieXLynxModel.getSessionId());
            }
        }
    }

    static /* synthetic */ void loadTemplateWithExternalTemplateBundle$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, TemplateBundle templateBundle, LynxLoadMode lynxLoadMode, IAnnieXLifeCycle iAnnieXLifeCycle, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            iAnnieXLifeCycle = null;
        }
        annieXLynxView.loadTemplateWithExternalTemplateBundle(annieXLynxModel, templateBundle, lynxLoadMode, iAnnieXLifeCycle, z);
    }

    public final void loadTemplateWithExternalTemplateBundle(AnnieXLynxModel annieXLynxModel, TemplateBundle templateBundle, LynxLoadMode loadMode, IAnnieXLifeCycle annieXLifeCycle, boolean modelGlobalPropsFirst) {
        MonitorManager.INSTANCE.onPrepareTemplateBegin(annieXLynxModel.getSessionId());
        MonitorManager.INSTANCE.onPrepareTemplateEnd(annieXLynxModel.getSessionId());
        MonitorManager.INSTANCE.onLynxReadTemplateBegin(annieXLynxModel.getSessionId());
        if (annieXLifeCycle != null) {
            annieXLifeCycle.onTemplateReady("externalTemplateBundle", true);
        }
        MonitorManager.INSTANCE.onLynxReadTemplateEnd(annieXLynxModel.getSessionId(), null, (r17 & 4) != 0 ? "userInput" : "externalTemplateBundle", (r17 & 8) != 0 ? 0L : 0L, (r17 & 16) != 0 ? 0.0d : 0.0d);
        setNpthLastUrl(annieXLynxModel.getUrl());
        TemplateData completeGlobalPropsForLoad = !annieXLynxModel.isCompactMode() ? completeGlobalPropsForLoad(annieXLynxModel, modelGlobalPropsFirst, "externalTemplateBundle", null, false) : null;
        LynxLoadMeta.Builder builder = new LynxLoadMeta.Builder();
        builder.setUrl(annieXLynxModel.getUrl());
        builder.setInitialData(annieXLynxModel.getTemplateData());
        if (completeGlobalPropsForLoad != null) {
            builder.setGlobalProps(completeGlobalPropsForLoad);
        }
        builder.setTemplateBundle(templateBundle);
        if (annieXLynxModel.getEnableElementTreeReuse() && templateBundle.isValid() && !templateBundle.isElementBundleValid()) {
            builder.addLoadOption(LynxLoadOption.DUMP_ELEMENT);
        }
        builder.setLoadMode(loadMode);
        LynxLoadMeta build = builder.build();
        MonitorManager.INSTANCE.onLynxRenderTemplateBegin(annieXLynxModel.getSessionId());
        loadTemplate(build);
        MonitorManager.INSTANCE.onLynxRenderTemplateEnd(annieXLynxModel.getSessionId());
    }

    static /* synthetic */ void loadTemplateWithInternalTemplateBundle$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, ProcessedResponse processedResponse, ForestResourceInfo forestResourceInfo, LynxLoadMode lynxLoadMode, IAnnieXLifeCycle iAnnieXLifeCycle, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            iAnnieXLifeCycle = null;
        }
        annieXLynxView.loadTemplateWithInternalTemplateBundle(annieXLynxModel, processedResponse, forestResourceInfo, lynxLoadMode, iAnnieXLifeCycle, z);
    }

    private final void loadTemplateWithInternalTemplateBundle(AnnieXLynxModel annieXLynxModel, ProcessedResponse<TemplateBundle> templateBundleResponse, ForestResourceInfo resourceInfo, LynxLoadMode loadMode, IAnnieXLifeCycle annieXLifeCycle, boolean modelGlobalPropsFirst) {
        String url = annieXLynxModel.getUrl();
        setNpthLastUrl(annieXLynxModel.getUrl());
        TemplateData completeGlobalPropsForLoad = completeGlobalPropsForLoad(annieXLynxModel, modelGlobalPropsFirst, "internalTemplateBundle", resourceInfo, true);
        LynxLoadMeta.Builder builder = new LynxLoadMeta.Builder();
        builder.setUrl(url);
        TemplateBundle templateBundle = (TemplateBundle) templateBundleResponse.provideProcessedData();
        builder.setTemplateBundle(templateBundle);
        if (annieXLynxModel.getEnableElementTreeReuse()) {
            boolean z = false;
            if (templateBundle != null && templateBundle.isValid()) {
                z = true;
            }
            if (z && !templateBundle.isElementBundleValid()) {
                builder.addLoadOption(LynxLoadOption.DUMP_ELEMENT);
            }
        }
        builder.setInitialData(annieXLynxModel.getTemplateData());
        if (completeGlobalPropsForLoad != null) {
            builder.setGlobalProps(completeGlobalPropsForLoad);
        }
        builder.setLoadMode(loadMode);
        LynxLoadMeta build = builder.build();
        MonitorManager.INSTANCE.onLynxRenderTemplateBegin(annieXLynxModel.getSessionId());
        loadTemplate(build);
        MonitorManager.INSTANCE.onLynxRenderTemplateEnd(annieXLynxModel.getSessionId());
    }

    static /* synthetic */ void loadTemplateWithInternalTemplateArray$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, byte[] bArr, ForestResourceInfo forestResourceInfo, LynxLoadMode lynxLoadMode, IAnnieXLifeCycle iAnnieXLifeCycle, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            iAnnieXLifeCycle = null;
        }
        annieXLynxView.loadTemplateWithInternalTemplateArray(annieXLynxModel, bArr, forestResourceInfo, lynxLoadMode, iAnnieXLifeCycle, z);
    }

    private final void loadTemplateWithInternalTemplateArray(AnnieXLynxModel annieXLynxModel, byte[] byteArray, ForestResourceInfo resourceInfo, LynxLoadMode loadMode, IAnnieXLifeCycle annieXLifeCycle, boolean modelGlobalPropsFirst) {
        String filePath;
        if (byteArray == null) {
            onLoadFail(annieXLynxModel.getBid(), annieXLynxModel.getSessionId(), -2, "byte array is null. url: " + annieXLynxModel.getOriginalUri(), annieXLifeCycle);
            return;
        }
        if (resourceInfo.getFrom() == ResourceFrom.CDN) {
            filePath = annieXLynxModel.getUrl();
        } else {
            filePath = resourceInfo.getFilePath();
            if (filePath == null) {
                filePath = annieXLynxModel.getUrl();
            }
        }
        setNpthLastUrl(annieXLynxModel.getUrl());
        TemplateData completeGlobalPropsForLoad = completeGlobalPropsForLoad(annieXLynxModel, modelGlobalPropsFirst, resourceInfo.getStatisticFrom(), resourceInfo, true);
        if (annieXLynxModel.isSSR()) {
            if (completeGlobalPropsForLoad != null) {
                updateGlobalProps(completeGlobalPropsForLoad);
            }
            MonitorManager.INSTANCE.onLynxRenderTemplateBegin(annieXLynxModel.getSessionId());
            renderSSR(byteArray, annieXLynxModel.getUrl(), annieXLynxModel.getTemplateData());
        } else {
            ArgusLynxDelegateAdapter argusSecureAdapter = getArgusSecureAdapter(annieXLynxModel);
            if (argusSecureAdapter != null) {
                argusSecureAdapter.onLoadTemplate((ResourceInfo) resourceInfo, true, "AnnieXLynxView");
            }
            LynxLoadMeta.Builder builder = new LynxLoadMeta.Builder();
            builder.setUrl(filePath);
            builder.setBinaryData(byteArray);
            builder.setInitialData(annieXLynxModel.getTemplateData());
            if (completeGlobalPropsForLoad != null) {
                builder.setGlobalProps(completeGlobalPropsForLoad);
            }
            builder.setLoadMode(loadMode);
            LynxLoadMeta build = builder.build();
            MonitorManager.INSTANCE.onLynxRenderTemplateBegin(annieXLynxModel.getSessionId());
            loadTemplate(build);
        }
        MonitorManager.INSTANCE.onLynxRenderTemplateEnd(annieXLynxModel.getSessionId());
    }

    static /* synthetic */ void loadTemplateWithUrl$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, LynxLoadMode lynxLoadMode, IAnnieXLifeCycle iAnnieXLifeCycle, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            iAnnieXLifeCycle = null;
        }
        annieXLynxView.loadTemplateWithUrl(annieXLynxModel, lynxLoadMode, iAnnieXLifeCycle, z);
    }

    static /* synthetic */ void handleResponseWithLoadTemplateWithUrl$default(AnnieXLynxView annieXLynxView, Response response, AnnieXLynxModel annieXLynxModel, LynxLoadMode lynxLoadMode, IAnnieXLifeCycle iAnnieXLifeCycle, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            iAnnieXLifeCycle = null;
        }
        annieXLynxView.handleResponseWithLoadTemplateWithUrl(response, annieXLynxModel, lynxLoadMode, iAnnieXLifeCycle, z);
    }

    public final void handleResponseWithLoadTemplateWithUrl(Response response, AnnieXLynxModel annieXLynxModel, LynxLoadMode loadMode, IAnnieXLifeCycle annieXLifeCycle, boolean modelGlobalPropsFirst) {
        AnnieXLynxModel copy;
        Object obj;
        byte[] provideByteArray;
        String str = "Failed to load template. url: " + annieXLynxModel.getOriginalUri() + ", error message: ";
        if (response.isSucceed()) {
            MonitorManager.INSTANCE.onPrepareTemplateEnd(annieXLynxModel.getSessionId());
            MonitorManager.INSTANCE.onLynxReadTemplateBegin(annieXLynxModel.getSessionId());
            ResourceInfo forestResourceInfo = new ForestResourceInfo(Uri.parse(annieXLynxModel.getUrl()), response);
            ResourceInfo resourceInfo = forestResourceInfo;
            this.resourceInfo = resourceInfo;
            AnnieXLynxView annieXLynxView = this;
            LynxViewMonitor.Companion.getINSTANCE().addContext(annieXLynxView, "geckoId", String.valueOf(forestResourceInfo.getVersion()));
            LynxViewMonitor.Companion.getINSTANCE().addContext(annieXLynxView, "channel", forestResourceInfo.getChannel());
            IAnnieXLifeCycle.AnnieXLynxLifeCycle annieXLynxLifeCycle = annieXLifeCycle instanceof IAnnieXLifeCycle.AnnieXLynxLifeCycle ? (IAnnieXLifeCycle.AnnieXLynxLifeCycle) annieXLifeCycle : null;
            if (annieXLynxLifeCycle != null) {
                annieXLynxLifeCycle.onTemplateReady(response);
            }
            Object provideProcessedData = forestResourceInfo.provideProcessedData();
            if (provideProcessedData instanceof TemplateBundle) {
                if (annieXLifeCycle != null) {
                    annieXLifeCycle.onTemplateReady("internalTemplateBundle", forestResourceInfo.isFromMemory());
                }
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                String sessionId = annieXLynxModel.getSessionId();
                long version = forestResourceInfo.getVersion();
                Intrinsics.checkNotNull(response, "null cannot be cast to non-null type com.bytedance.forest.postprocessor.ProcessedResponse<*>");
                monitorManager.onLynxReadTemplateEnd(sessionId, null, "internalTemplateBundle", version, r3.processedDataSize());
                loadTemplateWithInternalTemplateBundle(annieXLynxModel, (ProcessedResponse) response, forestResourceInfo, loadMode, annieXLifeCycle, modelGlobalPropsFirst);
                return;
            }
            if (provideProcessedData instanceof LynxSSRData) {
                copy = annieXLynxModel.copy((r32 & 1) != 0 ? annieXLynxModel.url : response.getRequest().getOriginUrl(), (r32 & 2) != 0 ? annieXLynxModel.originalUri : null, (r32 & 4) != 0 ? annieXLynxModel.bid : null, (r32 & 8) != 0 ? annieXLynxModel.globalProps : null, (r32 & 16) != 0 ? annieXLynxModel.extra : null, (r32 & 32) != 0 ? annieXLynxModel.lynxViewBuilderParams : null, (r32 & 64) != 0 ? annieXLynxModel.sessionId : null, (r32 & 128) != 0 ? annieXLynxModel.templateData : null, (r32 & 256) != 0 ? annieXLynxModel.template : null, (r32 & 512) != 0 ? annieXLynxModel.isSSR : true, (r32 & 1024) != 0 ? annieXLynxModel.isCompactMode : false, (r32 & 2048) != 0 ? annieXLynxModel.ssrHydrateConfig : null, (r32 & 4096) != 0 ? annieXLynxModel.enterFrom : null, (r32 & 8192) != 0 ? annieXLynxModel.useXBridge3 : false, (r32 & 16384) != 0 ? annieXLynxModel.compactConfig : null);
                copy.setLynxSSRViaSchemaConfig$anniex_release(annieXLynxModel.getIsLynxSSRViaSchemaConfig());
                copy.setSsrMode$anniex_release(annieXLynxModel.getSsrMode());
            } else {
                String uri = annieXLynxModel.getOriginalUri().toString();
                Intrinsics.checkNotNullExpressionValue(uri, "toString()");
                copy = annieXLynxModel.copy((r32 & 1) != 0 ? annieXLynxModel.url : uri, (r32 & 2) != 0 ? annieXLynxModel.originalUri : null, (r32 & 4) != 0 ? annieXLynxModel.bid : null, (r32 & 8) != 0 ? annieXLynxModel.globalProps : null, (r32 & 16) != 0 ? annieXLynxModel.extra : null, (r32 & 32) != 0 ? annieXLynxModel.lynxViewBuilderParams : null, (r32 & 64) != 0 ? annieXLynxModel.sessionId : null, (r32 & 128) != 0 ? annieXLynxModel.templateData : null, (r32 & 256) != 0 ? annieXLynxModel.template : null, (r32 & 512) != 0 ? annieXLynxModel.isSSR : false, (r32 & 1024) != 0 ? annieXLynxModel.isCompactMode : false, (r32 & 2048) != 0 ? annieXLynxModel.ssrHydrateConfig : null, (r32 & 4096) != 0 ? annieXLynxModel.enterFrom : null, (r32 & 8192) != 0 ? annieXLynxModel.useXBridge3 : false, (r32 & 16384) != 0 ? annieXLynxModel.compactConfig : null);
            }
            AnnieXLynxModel annieXLynxModel2 = copy;
            try {
                Result.Companion companion = Result.Companion;
                if (provideProcessedData instanceof LynxSSRData) {
                    provideByteArray = ((LynxSSRData) provideProcessedData).getSsrResult();
                } else {
                    provideByteArray = forestResourceInfo.provideByteArray();
                }
                obj = Result.constructor-impl(provideByteArray);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                onLoadFail(annieXLynxModel.getBid(), annieXLynxModel.getSessionId(), -3, str + th2.getMessage(), annieXLifeCycle);
            }
            byte[] bArr = (byte[]) (Result.isFailure-impl(obj) ? null : obj);
            if (annieXLifeCycle != null) {
                annieXLifeCycle.onTemplateReady(forestResourceInfo.getStatisticFrom(), forestResourceInfo.isFromMemory());
            }
            MonitorManager.INSTANCE.onLynxReadTemplateEnd(annieXLynxModel.getSessionId(), resourceInfo, (r17 & 4) != 0 ? "userInput" : null, (r17 & 8) != 0 ? 0L : 0L, (r17 & 16) != 0 ? 0.0d : 0.0d);
            loadTemplateWithInternalTemplateArray(annieXLynxModel2, bArr, forestResourceInfo, loadMode, annieXLifeCycle, modelGlobalPropsFirst);
            if (!(annieXLynxModel2.isSSR() && annieXLynxModel2.getIsLynxSSRViaSchemaConfig()) || bArr == null) {
                return;
            }
            requestLynxSSRHydrate(forestResourceInfo, annieXLynxModel2, annieXLifeCycle, str);
            return;
        }
        onLoadFail(annieXLynxModel.getBid(), annieXLynxModel.getSessionId(), -3, str + response.getErrorInfo(), annieXLifeCycle);
    }

    static /* synthetic */ void requestLynxSSRData$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, LynxLoadMode lynxLoadMode, IAnnieXLifeCycle iAnnieXLifeCycle, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            iAnnieXLifeCycle = null;
        }
        annieXLynxView.requestLynxSSRData(annieXLynxModel, lynxLoadMode, iAnnieXLifeCycle, z, z2);
    }

    public final void requestLynxSSRData(final AnnieXLynxModel annieXLynxModel, final LynxLoadMode loadMode, final IAnnieXLifeCycle annieXLifeCycle, final boolean modelGlobalPropsFirst, boolean preDecode) {
        ArgusLynxDelegateAdapter argusSecureAdapter = getArgusSecureAdapter(annieXLynxModel);
        if ((argusSecureAdapter == null || argusSecureAdapter.inSSRUrlAllowList(annieXLynxModel.getUrl())) ? false : true) {
            onLoadFail(annieXLynxModel.getBid(), annieXLynxModel.getSessionId(), -3, "[argus security check] ssr url " + annieXLynxModel.getUrl() + " is not allowed", annieXLifeCycle);
            return;
        }
        ForestLoader forestLoader = ForestLoader.INSTANCE;
        String uri = annieXLynxModel.getOriginalUri().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "annieXLynxModel.originalUri.toString()");
        Scene scene = Scene.LYNX_TEMPLATE;
        String sessionId = annieXLynxModel.getSessionId();
        Integer num = null;
        TaskConfig taskConfig = new TaskConfig((String) null, 1, (DefaultConstructorMarker) null);
        taskConfig.setCdnUrl(annieXLynxModel.getUrl());
        taskConfig.setBid(annieXLynxModel.getBid());
        taskConfig.setLoadToMemory(false);
        taskConfig.setInjectedHttpHeaders(MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Accept-Engine-Version", LynxEnv.inst().getSSRApiVersion()), TuplesKt.to("X-Lynx-Ssr-Accept-Type", "binary_v1")}));
        String queryParameter = annieXLynxModel.getOriginalUri().getQueryParameter("dynamic");
        if (queryParameter != null) {
            Intrinsics.checkNotNullExpressionValue(queryParameter, "getQueryParameter(\"dynamic\")");
            num = StringsKt.toIntOrNull(queryParameter);
        }
        taskConfig.setDynamic(num);
        Unit unit = Unit.INSTANCE;
        ForestLoader.loadAsyncWithProcessor$default(forestLoader, (Forest) null, uri, "ttnet", scene, sessionId, taskConfig, false, new ForestLynxSSRProcessor(annieXLynxModel.getSessionId(), annieXLynxModel.getBid(), false, false, false, 28, (DefaultConstructorMarker) null), (Function1) null, new Function1<ProcessedResponse<LynxSSRData>, Unit>() { // from class: com.bytedance.android.anniex.ui.AnnieXLynxView$requestLynxSSRData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ProcessedResponse<LynxSSRData>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ProcessedResponse<LynxSSRData> processedResponse) {
                Intrinsics.checkNotNullParameter(processedResponse, "response");
                AnnieXLynxView.this.handleLynxSSRResponse(processedResponse, annieXLynxModel, loadMode, annieXLifeCycle, modelGlobalPropsFirst);
            }
        }, 321, (Object) null);
    }

    static /* synthetic */ void handleLynxSSRResponse$default(AnnieXLynxView annieXLynxView, ProcessedResponse processedResponse, AnnieXLynxModel annieXLynxModel, LynxLoadMode lynxLoadMode, IAnnieXLifeCycle iAnnieXLifeCycle, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            iAnnieXLifeCycle = null;
        }
        annieXLynxView.handleLynxSSRResponse(processedResponse, annieXLynxModel, lynxLoadMode, iAnnieXLifeCycle, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if (r3 == null) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleLynxSSRResponse(ProcessedResponse<LynxSSRData> response, AnnieXLynxModel annieXLynxModel, LynxLoadMode loadMode, IAnnieXLifeCycle annieXLifeCycle, boolean modelGlobalPropsFirst) {
        AnnieXLynxModel copy;
        AnnieXLynxModel copy2;
        boolean z = response.isProcessSucceed() && response.provideProcessedData() != null;
        com.bytedance.forest.model.ResourceFrom from = response.getFrom();
        if (from != null) {
            if (!(from != com.bytedance.forest.model.ResourceFrom.MEMORY)) {
                from = null;
            }
        }
        from = response.getOriginFrom();
        if (from == null) {
            from = com.bytedance.forest.model.ResourceFrom.CDN;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", "ssr request ".concat(z ? "failed" : "success"), MapsKt.mapOf(new Pair[]{TuplesKt.to("ssr_url", annieXLynxModel.getUrl()), TuplesKt.to("res_from", from)}), (LoggerContext) null, 8, (Object) null);
        if (z) {
            handleResponseWithLoadTemplateWithUrl((Response) response, annieXLynxModel, loadMode, annieXLifeCycle, modelGlobalPropsFirst);
            return;
        }
        if (response.isSucceed() && (from == com.bytedance.forest.model.ResourceFrom.GECKO || from == com.bytedance.forest.model.ResourceFrom.BUILTIN)) {
            copy2 = annieXLynxModel.copy((r32 & 1) != 0 ? annieXLynxModel.url : null, (r32 & 2) != 0 ? annieXLynxModel.originalUri : null, (r32 & 4) != 0 ? annieXLynxModel.bid : null, (r32 & 8) != 0 ? annieXLynxModel.globalProps : null, (r32 & 16) != 0 ? annieXLynxModel.extra : null, (r32 & 32) != 0 ? annieXLynxModel.lynxViewBuilderParams : null, (r32 & 64) != 0 ? annieXLynxModel.sessionId : null, (r32 & 128) != 0 ? annieXLynxModel.templateData : null, (r32 & 256) != 0 ? annieXLynxModel.template : null, (r32 & 512) != 0 ? annieXLynxModel.isSSR : false, (r32 & 1024) != 0 ? annieXLynxModel.isCompactMode : false, (r32 & 2048) != 0 ? annieXLynxModel.ssrHydrateConfig : null, (r32 & 4096) != 0 ? annieXLynxModel.enterFrom : null, (r32 & 8192) != 0 ? annieXLynxModel.useXBridge3 : false, (r32 & 16384) != 0 ? annieXLynxModel.compactConfig : null);
            handleResponseWithLoadTemplateWithUrl((Response) response, copy2, loadMode, annieXLifeCycle, modelGlobalPropsFirst);
            return;
        }
        String subUrl = UrlExtKt.getSubUrl(annieXLynxModel.getOriginalUri());
        if (subUrl == null) {
            subUrl = annieXLynxModel.getOriginalUri().toString();
            Intrinsics.checkNotNullExpressionValue(subUrl, "annieXLynxModel.originalUri.toString()");
        }
        copy = annieXLynxModel.copy((r32 & 1) != 0 ? annieXLynxModel.url : subUrl, (r32 & 2) != 0 ? annieXLynxModel.originalUri : null, (r32 & 4) != 0 ? annieXLynxModel.bid : null, (r32 & 8) != 0 ? annieXLynxModel.globalProps : null, (r32 & 16) != 0 ? annieXLynxModel.extra : null, (r32 & 32) != 0 ? annieXLynxModel.lynxViewBuilderParams : null, (r32 & 64) != 0 ? annieXLynxModel.sessionId : null, (r32 & 128) != 0 ? annieXLynxModel.templateData : null, (r32 & 256) != 0 ? annieXLynxModel.template : null, (r32 & 512) != 0 ? annieXLynxModel.isSSR : false, (r32 & 1024) != 0 ? annieXLynxModel.isCompactMode : false, (r32 & 2048) != 0 ? annieXLynxModel.ssrHydrateConfig : null, (r32 & 4096) != 0 ? annieXLynxModel.enterFrom : null, (r32 & 8192) != 0 ? annieXLynxModel.useXBridge3 : false, (r32 & 16384) != 0 ? annieXLynxModel.compactConfig : null);
        loadTemplateWithUrl(copy, loadMode, annieXLifeCycle, modelGlobalPropsFirst);
        SLMonitorCompat.INSTANCE.reportReusePV(this.sessionId, annieXLynxModel.getOriginalUri().toString(), UrlExtKt.getSubUrl(annieXLynxModel.getOriginalUri()));
    }

    private final void requestLynxSSRHydrate(ForestResourceInfo resourceInfo, final AnnieXLynxModel annieXLynxModel, final IAnnieXLifeCycle annieXLifeCycle, final String baseErrorMessage) {
        Object provideProcessedData = resourceInfo.provideProcessedData();
        LynxSSRData lynxSSRData = provideProcessedData instanceof LynxSSRData ? (LynxSSRData) provideProcessedData : null;
        if (lynxSSRData == null) {
            onLoadFail(annieXLynxModel.getBid(), annieXLynxModel.getSessionId(), -3, baseErrorMessage + "can not get ssrData from forest response, ssr_url:" + annieXLynxModel.getUrl(), annieXLifeCycle);
            return;
        }
        if (!(lynxSSRData.getInitData().length() == 0)) {
            if (!(lynxSSRData.getHydrateUrl().length() == 0)) {
                ForestLoader forestLoader = ForestLoader.INSTANCE;
                String hydrateUrl = lynxSSRData.getHydrateUrl();
                Scene scene = Scene.LYNX_TEMPLATE;
                String sessionId = annieXLynxModel.getSessionId();
                TaskConfig taskConfig = new TaskConfig((String) null, 1, (DefaultConstructorMarker) null);
                taskConfig.setBid(annieXLynxModel.getBid());
                taskConfig.setCdnUrl(lynxSSRData.getHydrateUrl());
                taskConfig.setLoadToMemory(true);
                Unit unit = Unit.INSTANCE;
                final LynxSSRData lynxSSRData2 = lynxSSRData;
                ForestLoader.loadAsync$default(forestLoader, (Forest) null, hydrateUrl, "ttnet", scene, sessionId, taskConfig, false, (Function1) null, new Function1<Response, Unit>() { // from class: com.bytedance.android.anniex.ui.AnnieXLynxView$requestLynxSSRHydrate$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Response) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Response response) {
                        Object obj;
                        AnnieXLynxModel copy;
                        Intrinsics.checkNotNullParameter(response, "hydrateResp");
                        if (!response.isSucceed()) {
                            this.onLoadFail(annieXLynxModel.getBid(), annieXLynxModel.getSessionId(), -3, baseErrorMessage + "ssr hydrate template request failed, cause by:" + response.getErrorInfo() + ". ssr_url:" + annieXLynxModel.getUrl() + ", hydrate_url:" + lynxSSRData2.getHydrateUrl(), annieXLifeCycle);
                            return;
                        }
                        try {
                            Result.Companion companion = Result.Companion;
                            obj = Result.constructor-impl(response.provideBytes());
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        AnnieXLynxView annieXLynxView = this;
                        AnnieXLynxModel annieXLynxModel2 = annieXLynxModel;
                        String str = baseErrorMessage;
                        LynxSSRData lynxSSRData3 = lynxSSRData2;
                        IAnnieXLifeCycle iAnnieXLifeCycle = annieXLifeCycle;
                        Throwable th2 = Result.exceptionOrNull-impl(obj);
                        if (th2 != null) {
                            annieXLynxView.onLoadFail(annieXLynxModel2.getBid(), annieXLynxModel2.getSessionId(), -3, str + "fetch ssr hydrate template bytes failed, cause by:" + th2.getMessage() + ". ssr_url:" + annieXLynxModel2.getUrl() + ", hydrate_url:" + lynxSSRData3.getHydrateUrl(), iAnnieXLifeCycle);
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        byte[] bArr = (byte[]) obj;
                        if (bArr == null) {
                            return;
                        }
                        ArgusLynxDelegateAdapter argusSecureAdapter = this.getArgusSecureAdapter(annieXLynxModel);
                        if (argusSecureAdapter != null) {
                            argusSecureAdapter.onLoadTemplate(new ForestResourceInfo(annieXLynxModel.getOriginalUri(), response), true, "AnnieXSSR");
                        }
                        copy = r6.copy((r32 & 1) != 0 ? r6.url : lynxSSRData2.getHydrateUrl(), (r32 & 2) != 0 ? r6.originalUri : null, (r32 & 4) != 0 ? r6.bid : null, (r32 & 8) != 0 ? r6.globalProps : null, (r32 & 16) != 0 ? r6.extra : null, (r32 & 32) != 0 ? r6.lynxViewBuilderParams : null, (r32 & 64) != 0 ? r6.sessionId : null, (r32 & 128) != 0 ? r6.templateData : null, (r32 & 256) != 0 ? r6.template : null, (r32 & 512) != 0 ? r6.isSSR : false, (r32 & 1024) != 0 ? r6.isCompactMode : false, (r32 & 2048) != 0 ? r6.ssrHydrateConfig : new AnnieXLynxModel.SSRHydrateConfig(new AnnieXLynxModel.ComparableByteArray(bArr), lynxSSRData2.getHydrateUrl(), TemplateData.fromString(lynxSSRData2.getInitData())), (r32 & 4096) != 0 ? r6.enterFrom : null, (r32 & 8192) != 0 ? r6.useXBridge3 : false, (r32 & 16384) != 0 ? annieXLynxModel.compactConfig : null);
                        this.renderSSRHydrate(copy);
                    }
                }, 193, (Object) null);
                return;
            }
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", baseErrorMessage + "initData or hydrateUrl is empty, ssr_url:" + annieXLynxModel.getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    public void updateData(TemplateData r5) {
        AirSolution airSolution = this.airSolution;
        if (airSolution != null) {
            AirSolution.updateInitData$default(airSolution, r5, false, 2, (Object) null);
        }
        super.updateData(r5);
    }

    public final void removeScreenCaptureListener() {
        HybridLogger.d$default(HybridLogger.INSTANCE, "AnnieX", "removeScreenCaptureListener", (Map) null, (LoggerContext) null, 12, (Object) null);
        final OnScreenCaptureListener onScreenCaptureListener = this.screenCaptureListener;
        if (onScreenCaptureListener != null) {
            Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.ui.AnnieXLynxView$removeScreenCaptureListener$1
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    ScreenCaptureUtils screenCaptureUtils = ScreenCaptureUtils.INSTANCE;
                    Context applicationContext = AnnieXLynxView.this.getContext().getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                    screenCaptureUtils.removeScreenCaptureListener(applicationContext, onScreenCaptureListener);
                }
            });
            this.screenCaptureListener = null;
        }
    }

    private final void onOrientationChanged(Configuration newConfig) {
        Orientation orientation;
        Orientation[] values = Orientation.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                orientation = null;
                break;
            }
            orientation = values[i];
            if (orientation.ordinal() == newConfig.orientation) {
                break;
            } else {
                i++;
            }
        }
        if (orientation == null) {
            orientation = Orientation.UNKNOWN;
        }
        if (orientation != this.lastOrientation) {
            ViewUtil viewUtil = ViewUtil.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ScreenInfo screenInfo = viewUtil.getScreenInfo(context);
            JSONObject jSONObject = new JSONObject();
            String name = orientation.name();
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
            if (name == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            jSONObject.put("screenOrientation", lowerCase);
            if (screenInfo != null) {
                UIUtils uIUtils = UIUtils.INSTANCE;
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                int px2dip = uIUtils.px2dip(context2, screenInfo.getHeight());
                UIUtils uIUtils2 = UIUtils.INSTANCE;
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                int px2dip2 = uIUtils2.px2dip(context3, screenInfo.getWidth());
                if (orientation == Orientation.LANDSCAPE) {
                    jSONObject.put("screenHeight", Math.min(px2dip2, px2dip));
                    jSONObject.put("screenWidth", Math.max(px2dip2, px2dip));
                } else {
                    jSONObject.put("screenHeight", Math.max(px2dip2, px2dip));
                    jSONObject.put("screenWidth", Math.min(px2dip2, px2dip));
                }
                jSONObject.put("kitViewHeight", (Object) null);
                jSONObject.put("kitViewWidth", (Object) null);
            }
            Unit unit = Unit.INSTANCE;
            sendEvent$default(this, EventHelper.SCREEN_ORIENTATION_CHANGE, jSONObject, false, 4, null);
            if (screenInfo != null) {
                updateScreenMetrics(screenInfo.getWidth(), screenInfo.getHeight());
                HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", "updateLynxScreenMetrics: width " + screenInfo.getWidth() + " , height " + screenInfo.getHeight(), (Map) null, (LoggerContext) null, 12, (Object) null);
            }
            this.lastOrientation = orientation;
            GlobalPropsHelper.INSTANCE.removeGlobalPropsByActivity(getContext());
        }
    }

    private final LynxViewClient getAirSolutionLynxViewClient() {
        return new AirSolutionLynxViewClient(new Function0<Unit>() { // from class: com.bytedance.android.anniex.ui.AnnieXLynxView$getAirSolutionLynxViewClient$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3458invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3458invoke() {
                AirSolutionHelper airSolutionHelper = AirSolutionHelper.INSTANCE;
                AnnieXLynxView annieXLynxView = AnnieXLynxView.this;
                airSolutionHelper.setUpAirSolution(annieXLynxView, annieXLynxView.airSolution);
                AirSolution airSolution = AnnieXLynxView.this.airSolution;
                if (airSolution != null) {
                    airSolution.dispatchLifecycle(AirActionConstant.AirSolutionLifecycle.OnViewLoad);
                }
            }
        }, new Function0<Unit>() { // from class: com.bytedance.android.anniex.ui.AnnieXLynxView$getAirSolutionLynxViewClient$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3459invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3459invoke() {
                AirSolutionHelper airSolutionHelper = AirSolutionHelper.INSTANCE;
                AnnieXLynxView annieXLynxView = AnnieXLynxView.this;
                airSolutionHelper.setTapHandler(annieXLynxView, annieXLynxView.airSolution);
            }
        });
    }

    public final void runOnUiThread(final Function0<Unit> r3) {
        if (IConditionCallKt.enableLoadFailedOnUIThread() && !Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            Task.call(new Callable() { // from class: com.bytedance.android.anniex.ui.AnnieXLynxView$runOnUiThread$1
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    r3.invoke();
                }
            }, Task.UI_THREAD_EXECUTOR);
        } else {
            r3.invoke();
        }
    }

    static /* synthetic */ TemplateData completeGlobalPropsForLoad$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, boolean z, String str, ForestResourceInfo forestResourceInfo, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            forestResourceInfo = null;
        }
        ForestResourceInfo forestResourceInfo2 = forestResourceInfo;
        if ((i & 16) != 0) {
            z2 = false;
        }
        return annieXLynxView.completeGlobalPropsForLoad(annieXLynxModel, z, str, forestResourceInfo2, z2);
    }

    private final TemplateData completeGlobalPropsForLoad(AnnieXLynxModel annieXLynxModel, boolean modelGlobalPropsFirst, String resFrom, ForestResourceInfo resourceInfo, boolean saveToCache) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("res_from", resFrom);
        if (resourceInfo != null) {
            linkedHashMap.put("geckoId", String.valueOf(resourceInfo.getVersion()));
            linkedHashMap.put("geckoChannel", resourceInfo.getChannel());
        }
        if (saveToCache) {
            this.cacheGlobalProps.putAll(linkedHashMap);
        }
        if (modelGlobalPropsFirst) {
            TemplateData globalProps = annieXLynxModel.getGlobalProps();
            if (globalProps == null) {
                return null;
            }
            TemplateData empty = TemplateData.empty();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                empty.put((String) entry.getKey(), entry.getValue());
            }
            Intrinsics.checkNotNullExpressionValue(empty, "this@apply");
            injectGlobalProps(empty, saveToCache);
            Map<String, Object> globalPropsByActivityInternal = getGlobalPropsByActivityInternal(annieXLynxModel);
            if (globalPropsByActivityInternal != null) {
                for (Map.Entry<String, Object> entry2 : globalPropsByActivityInternal.entrySet()) {
                    empty.put(entry2.getKey(), entry2.getValue());
                    if (saveToCache) {
                        this.cacheGlobalProps.put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
            Map map = globalProps.toMap();
            Map map2 = map instanceof Map ? map : null;
            if (map2 != null) {
                empty.updateData(map2);
            }
            Intrinsics.checkNotNullExpressionValue(empty, "empty().apply {\n        …      }\n                }");
            empty.markConcurrent();
            return empty;
        }
        TemplateData globalProps2 = annieXLynxModel.getGlobalProps();
        if (globalProps2 == null) {
            return null;
        }
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            globalProps2.put((String) entry3.getKey(), entry3.getValue());
        }
        injectGlobalProps(globalProps2, saveToCache);
        Map<String, Object> globalPropsByActivityInternal2 = getGlobalPropsByActivityInternal(annieXLynxModel);
        if (globalPropsByActivityInternal2 != null) {
            for (Map.Entry<String, Object> entry4 : globalPropsByActivityInternal2.entrySet()) {
                globalProps2.put(entry4.getKey(), entry4.getValue());
                if (saveToCache) {
                    this.cacheGlobalProps.put(entry4.getKey(), entry4.getValue());
                }
            }
        }
        globalProps2.markConcurrent();
        return globalProps2;
    }

    public final Map<String, Object> getGlobalPropsByActivityInternal(AnnieXLynxModel annieXLynxModel) {
        Map<String, Object> pageGlobalPropsByActivity = GlobalPropsHelper.INSTANCE.getPageGlobalPropsByActivity(getContext());
        if (pageGlobalPropsByActivity == null) {
            return null;
        }
        AnnieXLynxModel.CompactConfig compactConfig = annieXLynxModel.getCompactConfig();
        boolean z = false;
        if (compactConfig != null && compactConfig.getTrimGlobalProps()) {
            z = true;
        }
        if (!z) {
            return pageGlobalPropsByActivity;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(pageGlobalPropsByActivity);
        linkedHashMap.remove("bottomHeight");
        linkedHashMap.remove("contentHeight");
        linkedHashMap.remove("contentWidth");
        linkedHashMap.remove("safeAreaHeight");
        linkedHashMap.remove("topHeight");
        return linkedHashMap;
    }

    static /* synthetic */ TemplateData completeGlobalPropsForReload$default(AnnieXLynxView annieXLynxView, AnnieXLynxModel annieXLynxModel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return annieXLynxView.completeGlobalPropsForReload(annieXLynxModel, z);
    }

    public final TemplateData completeGlobalPropsForReload(AnnieXLynxModel annieXLynxModel, boolean modelGlobalPropsFirst) {
        if (modelGlobalPropsFirst) {
            TemplateData globalProps = annieXLynxModel.getGlobalProps();
            if (globalProps == null) {
                return null;
            }
            TemplateData empty = TemplateData.empty();
            empty.markConcurrent();
            empty.updateData(this.cacheGlobalProps);
            Map map = globalProps.toMap();
            Map map2 = map instanceof Map ? map : null;
            if (map2 != null) {
                empty.updateData(map2);
            }
            empty.markConcurrent();
            return empty;
        }
        TemplateData globalProps2 = annieXLynxModel.getGlobalProps();
        if (globalProps2 == null) {
            return null;
        }
        globalProps2.markConcurrent();
        globalProps2.updateData(this.cacheGlobalProps);
        globalProps2.markConcurrent();
        return globalProps2;
    }

    public final LynxDevtool lynxDevTool() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.getDevTool();
        }
        return null;
    }

    public final void showLynxRedError(final String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        if (BulletEnv.Companion.getInstance().getDebuggable()) {
            final String stackTraceStringTrimmed = CallStackUtil.getStackTraceStringTrimmed(new Throwable("Fetch template resource failed"));
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.bytedance.android.anniex.ui.AnnieXLynxView$showLynxRedError$1
                @Override // java.lang.Runnable
                public void run() {
                    LynxError lynxError = new LynxError(10203, "Error occurred while fetching app bundle resource");
                    lynxError.setRootCause(errorMsg);
                    lynxError.setCallStack(stackTraceStringTrimmed);
                    LynxDevtool lynxDevTool = this.lynxDevTool();
                    if (lynxDevTool != null) {
                        lynxDevTool.showErrorMessage(lynxError);
                    }
                }
            });
        }
    }

    public final void registerSecureService(ArgusBaseBizService service) {
        ArgusLynxDelegate delegate;
        Intrinsics.checkNotNullParameter(service, "service");
        ArgusLynxDelegateAdapter argusSecureAdapter = getArgusSecureAdapter(null);
        if (argusSecureAdapter == null || (delegate = argusSecureAdapter.getDelegate()) == null) {
            return;
        }
        delegate.setBizContext(service);
    }

    public final void initBridgeSecureDep(LynxBDXBridge lynxBDXBridge, AnnieXLynxModel lynxViewModel) {
        ArgusLynxDelegate delegate;
        ArgusLynxDelegateAdapter argusSecureAdapter = getArgusSecureAdapter(lynxViewModel);
        if (argusSecureAdapter == null || (delegate = argusSecureAdapter.getDelegate()) == null) {
            return;
        }
        lynxBDXBridge.setAuthDelegate(delegate);
    }

    public final ArgusLynxDelegateAdapter getArgusSecureAdapter(AnnieXLynxModel annieXLynxModel) {
        AnnieXLynxModel.CompactConfig compactConfig;
        boolean z = false;
        if (annieXLynxModel != null && (compactConfig = annieXLynxModel.getCompactConfig()) != null && compactConfig.getDisableSignVerify()) {
            z = true;
        }
        if (z) {
            return null;
        }
        if (this.argusAdapter == null) {
            this.argusAdapter = ArgusLynxDelegateAdapter.Companion.build((SecureProviderFactory) null, this);
            Unit unit = Unit.INSTANCE;
        }
        return this.argusAdapter;
    }

    public final void flushAllStickyEvents(IAnnieXLifeCycle annieXLifeCycle, ContextProviderFactory contextProviderFactory, AnnieXLynxModel annieXLynxModel) {
        LynxBridgeContext lynxBridgeContext;
        Intrinsics.checkNotNullParameter(annieXLynxModel, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:flushAllStickyEvents");
        try {
            if (this.isFromEngine) {
                LynxBDXBridge lynxBDXBridge = this.lynxBDXBridge;
                ContextProviderFactory contextProviderFactory2 = (lynxBDXBridge == null || (lynxBridgeContext = lynxBDXBridge.getLynxBridgeContext()) == null) ? null : (ContextProviderFactory) lynxBridgeContext.getService(ContextProviderFactory.class);
                if (contextProviderFactory != null && contextProviderFactory2 != null) {
                    contextProviderFactory2.merge(contextProviderFactory);
                }
                if (contextProviderFactory2 != null) {
                    String uri = annieXLynxModel.getOriginalUri().toString();
                    Intrinsics.checkNotNullExpressionValue(uri, "annieXLynxModel.originalUri.toString()");
                    contextProviderFactory2.registerHolder(BulletPageUrl.class, new BulletPageUrl(uri));
                }
                if (IConditionCallKt.enableCardBidParamRegister() && contextProviderFactory2 != null) {
                    contextProviderFactory2.registerHolder(ContainerBidParam.class, new ContainerBidParam(this.bid));
                }
                ContextProviderManager.INSTANCE.register(this.sessionId, contextProviderFactory);
                if (annieXLifeCycle != null) {
                    this.currentLifeCycleRef = new WeakReference(annieXLifeCycle);
                    if (IConditionCallKt.enableContextFreeLifeCycleFix()) {
                        this.currentLifeCycle = annieXLifeCycle;
                    }
                }
                if (IConditionCallKt.enableAttachEngineToUiThread() && annieXLynxModel.getOriginalUri().getBooleanQueryParameter("is_attach_engine_to_ui_thread", true)) {
                    attachEngineToUIThread();
                }
                AnnieXDefaultLynxViewClient annieXDefaultLynxViewClient = this.lynxViewClient;
                Intrinsics.checkNotNull(annieXDefaultLynxViewClient, "null cannot be cast to non-null type com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient");
                ((AnnieXDefaultLynxEngineClient) annieXDefaultLynxViewClient).setLifeCycle(annieXLifeCycle);
                AnnieXDefaultLynxViewClient annieXDefaultLynxViewClient2 = this.lynxViewClient;
                Intrinsics.checkNotNull(annieXDefaultLynxViewClient2, "null cannot be cast to non-null type com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient");
                ((AnnieXDefaultLynxEngineClient) annieXDefaultLynxViewClient2).setLynxView(this);
                processRender();
                startLynxRuntime();
                AnnieXDefaultLynxViewClient annieXDefaultLynxViewClient3 = this.lynxViewClient;
                Intrinsics.checkNotNull(annieXDefaultLynxViewClient3, "null cannot be cast to non-null type com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient");
                ((AnnieXDefaultLynxEngineClient) annieXDefaultLynxViewClient3).flushAllStickyEvent();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:flushAllStickyEvents");
        }
    }

    protected void onDetachedFromWindow() {
        TraceEvent.beginSection("AnnieXLynxView:onDetachedFromWindow");
        try {
            super.onDetachedFromWindow();
            if (!TraceEvent.enableTrace()) {
                Log.d(TAG, this.sessionId + ": onViewDetachedFromWindow: " + this);
            }
            WeakReference weakReference = this.currentLifeCycleRef;
            Object obj = weakReference != null ? (IAnnieXLifeCycle) weakReference.get() : null;
            IAnnieXLifeCycle.AnnieXLynxLifeCycle annieXLynxLifeCycle = obj instanceof IAnnieXLifeCycle.AnnieXLynxLifeCycle ? (IAnnieXLifeCycle.AnnieXLynxLifeCycle) obj : null;
            if (annieXLynxLifeCycle != null) {
                annieXLynxLifeCycle.onViewDetached(this);
            }
            MonitorManager.reportInfo$default(MonitorManager.INSTANCE, this.sessionId, false, null, null, false, 30, null);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:onDetachedFromWindow");
        }
    }

    public final Unit initBridge(LynxBDXBridge lynxBDXBridge, AnnieXLynxModel lynxViewModel) {
        Unit unit;
        Intrinsics.checkNotNullParameter(lynxBDXBridge, "lynxBDXBridge");
        Intrinsics.checkNotNullParameter(lynxViewModel, "lynxViewModel");
        TraceEvent.beginSection("AnnieXLynxView:initBridge");
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(OptimizeConfigKt.getLOKI_JSB_OPT_SWITCH(), Boolean.valueOf(IConditionCallKt.lokiJsbOptSwitch()));
            linkedHashMap.put(OptimizeConfigKt.getLOKI_JSB_LOG_DROP_SWITCH(), Boolean.valueOf(IConditionCallKt.lokiJsbLogDropSwitch()));
            linkedHashMap.put(OptimizeConfigKt.getCAN_RUN_IN_BACKGROUND_FIX(), Boolean.valueOf(IConditionCallKt.enableBridgeCanRunInBackgroundFix()));
            linkedHashMap.put(OptimizeConfigKt.getXBRIDGE_MODEL_PROXY_ENHANCEMENT(), Boolean.valueOf(IConditionCallKt.enableXBridgeParamProxyEnhancement()));
            lynxBDXBridge.addSettings(linkedHashMap);
            this.lynxBDXBridge = lynxBDXBridge;
            XBridge.INSTANCE.setEnableAnnieXJsbParamInNumberAdapterFix(IConditionCallKt.enableAnnieXJsbParamInNumberAdapterFix());
            XBridgeHelper.INSTANCE.initBridge(lynxBDXBridge, this, lynxViewModel);
            initBridgeSecureDep(lynxBDXBridge, lynxViewModel);
            AirSolution airSolution = AirSolutionHelper.INSTANCE.getAirSolution(this, lynxBDXBridge, lynxViewModel);
            if (airSolution != null) {
                this.airSolution = airSolution;
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            return unit;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:initBridge");
        }
    }

    public final void sendEvent(String eventName, Object params, boolean compatible) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        TraceEvent.beginSection("AnnieXLynxView:sendEvent");
        try {
            if (compatible) {
                EventHelper.INSTANCE.sendEventCompatible(eventName, params, this, this.bid, this.sessionId);
            } else {
                if (BulletEnv.Companion.getInstance().getDebuggable()) {
                    try {
                        Result.Companion companion = Result.Companion;
                        HybridLogger.d$default(HybridLogger.INSTANCE, "AnnieX", "send event: " + eventName + " with params: " + new Gson().toJson(params), (Map) null, (LoggerContext) null, 12, (Object) null);
                        Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                    }
                } else {
                    HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", "send event: " + eventName, (Map) null, (LoggerContext) null, 12, (Object) null);
                }
                if (params == null) {
                    JavaOnlyArray from = JavaOnlyArray.from(new ArrayList());
                    Intrinsics.checkNotNullExpressionValue(from, "from(mutableListOf<Any>())");
                    LynxViexExtKt.sendGlobalEventInternal(this, eventName, from);
                } else if (params instanceof List) {
                    AnnieXLynxView annieXLynxView = this;
                    ArrayList arrayList = params instanceof List ? (List) params : null;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    JavaOnlyArray from2 = JavaOnlyArray.from(arrayList);
                    Intrinsics.checkNotNullExpressionValue(from2, "from(params as? List<Any… ?: mutableListOf<Any>())");
                    LynxViexExtKt.sendGlobalEventInternal(annieXLynxView, eventName, from2);
                } else {
                    JavaOnlyArray of = JavaOnlyArray.of(new Object[]{params});
                    Intrinsics.checkNotNullExpressionValue(of, "of(params)");
                    LynxViexExtKt.sendGlobalEventInternal(this, eventName, of);
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:sendEvent");
        }
    }

    public final void load(AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle annieXLifeCycle) {
        Intrinsics.checkNotNullParameter(annieXLynxModel, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:load");
        try {
            load(annieXLynxModel, contextProviderFactory, annieXLifeCycle, false);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:load");
        }
    }

    public final void load(AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle annieXLifeCycle, boolean modelGlobalPropsFirst) {
        AnnieXCardScene annieXCardScene;
        LynxLoadMode lynxLoadMode;
        Intrinsics.checkNotNullParameter(annieXLynxModel, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:load");
        try {
            if (!TraceEvent.enableTrace()) {
                Log.d(TAG, "load: " + this);
            }
            if (DefaultLynxDelegate.Companion.getGlobalColdStart()) {
                this.isColdStart = true;
                DefaultLynxDelegate.Companion.setGlobalColdStart(false);
            }
            if (annieXLynxModel.isSSR()) {
                annieXCardScene = AnnieXCardScene.SSR;
            } else {
                annieXCardScene = AnnieXCardScene.NEW;
            }
            beforeLoadTemplate(annieXLynxModel, contextProviderFactory, annieXLifeCycle, annieXCardScene);
            SLMonitorCompat.INSTANCE.reportPV(this.sessionId, annieXLynxModel.getOriginalUri(), SLMonitorCompat.ContainerType.Lynx.getValue(), null);
            TemplateBundle templateBundle = contextProviderFactory != null ? (TemplateBundle) contextProviderFactory.provideInstance(TemplateBundle.class) : null;
            if (contextProviderFactory == null || (lynxLoadMode = (LynxLoadMode) contextProviderFactory.provideInstance(LynxLoadMode.class)) == null) {
                lynxLoadMode = LynxLoadMode.NORMAL;
            }
            LynxLoadMode lynxLoadMode2 = lynxLoadMode;
            AirSolution airSolution = this.airSolution;
            if (airSolution != null) {
                AirSolution.updateInitData$default(airSolution, annieXLynxModel.getTemplateData(), false, 2, (Object) null);
            }
            if (templateBundle != null) {
                loadTemplateWithExternalTemplateBundle(annieXLynxModel, templateBundle, lynxLoadMode2, annieXLifeCycle, modelGlobalPropsFirst);
            } else {
                if (annieXLynxModel.getTemplate() != null) {
                    if (!(annieXLynxModel.getTemplate().getTemplateJS().length == 0)) {
                        loadTemplateWithExternalTemplateArray(annieXLynxModel, lynxLoadMode2, annieXLifeCycle, modelGlobalPropsFirst);
                    }
                }
                loadTemplateWithUrl(annieXLynxModel, lynxLoadMode2, annieXLifeCycle, modelGlobalPropsFirst);
            }
            AnnieXJSWorkerManager annieXJSWorkerManager = AnnieXJSWorkerManager.INSTANCE;
            Context applicationContext = getContext().getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            annieXJSWorkerManager.initInCard((Application) applicationContext);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:load");
        }
    }

    public final void reloadTemplate(AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle annieXLifeCycle) {
        Intrinsics.checkNotNullParameter(annieXLynxModel, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:reloadTemplate");
        try {
            reloadTemplate(annieXLynxModel, contextProviderFactory, annieXLifeCycle, false);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:reloadTemplate");
        }
    }

    public final void reloadTemplate(AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle annieXLifeCycle, boolean modelGlobalPropsFirst) {
        Intrinsics.checkNotNullParameter(annieXLynxModel, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:reloadTemplate");
        try {
            if (!TraceEvent.enableTrace()) {
                Log.d(TAG, "reloadTemplate: " + this);
            }
            beforeLoadTemplate(annieXLynxModel, contextProviderFactory, annieXLifeCycle, AnnieXCardScene.REUSE);
            setNpthLastUrl(annieXLynxModel.getUrl());
            MonitorManager.INSTANCE.onLynxRenderTemplateBegin(annieXLynxModel.getSessionId());
            TemplateData completeGlobalPropsForReload = completeGlobalPropsForReload(annieXLynxModel, modelGlobalPropsFirst);
            TemplateData templateData = annieXLynxModel.getTemplateData();
            if (templateData != null) {
                templateData.put(BULLET_UPDATE_TYPE, 0);
            } else {
                templateData = null;
            }
            super.reloadTemplate(templateData, completeGlobalPropsForReload);
            MonitorManager.INSTANCE.onLynxRenderTemplateEnd(annieXLynxModel.getSessionId());
            SLMonitorCompat.reportReusePV$default(SLMonitorCompat.INSTANCE, this.sessionId, annieXLynxModel.getUrl(), null, 4, null);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:reloadTemplate");
        }
    }

    public void renderTemplateBundle(TemplateBundle bundle, TemplateData templateData, String baseUrl) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        TraceEvent.beginSection("AnnieXLynxView:renderTemplateBundle");
        try {
            super.renderTemplateBundle(bundle, templateData, baseUrl);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:renderTemplateBundle");
        }
    }

    public void resetData(TemplateData r4) {
        TraceEvent.beginSection("AnnieXLynxView:resetData");
        try {
            AirSolution airSolution = this.airSolution;
            if (airSolution != null) {
                airSolution.updateInitData(r4, true);
            }
            if (r4 != null) {
                r4.put(BULLET_UPDATE_TYPE, 0);
            } else {
                r4 = null;
            }
            super.resetData((AnnieXLynxView) r4);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:resetData");
        }
    }

    public final void resetData(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, Constants.KEY_DATA);
        TraceEvent.beginSection("AnnieXLynxView:resetData");
        try {
            AirSolution airSolution = this.airSolution;
            if (airSolution != null) {
                airSolution.updateInitData(r4, true);
            }
            TemplateData fromMap = TemplateData.fromMap(r4);
            fromMap.put(BULLET_UPDATE_TYPE, 0);
            super.resetData((AnnieXLynxView) fromMap);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:resetData");
        }
    }

    public final void renderSSRHydrate(AnnieXLynxModel annieXLynxModel) {
        Intrinsics.checkNotNullParameter(annieXLynxModel, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:renderSSRHydrate");
        try {
            if (annieXLynxModel.isSSR() && annieXLynxModel.getSsrHydrateConfig() != null) {
                TemplateData globalProps = annieXLynxModel.getGlobalProps();
                if (globalProps != null) {
                    Map globalPropsByActivityInternal = getGlobalPropsByActivityInternal(annieXLynxModel);
                    if (globalPropsByActivityInternal != null) {
                        for (Map.Entry entry : globalPropsByActivityInternal.entrySet()) {
                            globalProps.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    injectGlobalProps$default(this, globalProps, false, 2, null);
                    globalProps.markConcurrent();
                    updateGlobalProps(globalProps);
                }
                AnnieXLynxModel.SSRHydrateConfig ssrHydrateConfig = annieXLynxModel.getSsrHydrateConfig();
                if (!TraceEvent.enableTrace()) {
                    Log.d(TAG, "ssrHydrate: " + this);
                }
                AnnieXLynxModel.ComparableByteArray template = ssrHydrateConfig.getTemplate();
                if ((template != null ? template.getTemplateJS() : null) != null) {
                    ssrHydrate(ssrHydrateConfig.getTemplate().getTemplateJS(), annieXLynxModel.getUrl(), ssrHydrateConfig.getTemplateData());
                } else if (ssrHydrateConfig.getBaseUrl() != null) {
                    ssrHydrateUrl(ssrHydrateConfig.getBaseUrl(), ssrHydrateConfig.getTemplateData());
                } else {
                    HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieX", "invalid params in ssrHydrateConfig. check if template or baseUrl is NULL", (Map) null, (LoggerContext) null, 12, (Object) null);
                }
                SLMonitorCompat.INSTANCE.reportPV(this.sessionId, annieXLynxModel.getOriginalUri(), SLMonitorCompat.ContainerType.Lynx.getValue(), null);
            } else {
                HybridLogger.e$default(HybridLogger.INSTANCE, "AnnieX", "invalid params in renderSSRHydrate. isSSR: " + annieXLynxModel.isSSR() + ", check if ssrHydrateConfig is NULL: " + (annieXLynxModel.getSsrHydrateConfig() == null), (Map) null, (LoggerContext) null, 12, (Object) null);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:renderSSRHydrate");
        }
    }

    public final void resetData(AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle annieXLifeCycle) {
        Intrinsics.checkNotNullParameter(annieXLynxModel, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:resetData");
        try {
            if (!TraceEvent.enableTrace()) {
                Log.d(TAG, "resetData: " + this);
            }
            beforeLoadTemplate(annieXLynxModel, contextProviderFactory, annieXLifeCycle, AnnieXCardScene.RESET_DATA);
            addTagView(this.bid);
            setNpthLastUrl(annieXLynxModel.getUrl());
            MonitorManager.INSTANCE.onLynxRenderTemplateBegin(annieXLynxModel.getSessionId());
            TemplateData templateData = annieXLynxModel.getTemplateData();
            if (templateData != null) {
                templateData.put(BULLET_UPDATE_TYPE, 1);
            } else {
                templateData = null;
            }
            resetData(templateData);
            MonitorManager.INSTANCE.onLynxRenderTemplateEnd(annieXLynxModel.getSessionId());
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:resetData");
        }
    }

    public final void updateData(AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle annieXLifeCycle) {
        Intrinsics.checkNotNullParameter(annieXLynxModel, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:updateData");
        try {
            if (!TraceEvent.enableTrace()) {
                Log.d(TAG, "updateData: " + this);
            }
            beforeLoadTemplate(annieXLynxModel, contextProviderFactory, annieXLifeCycle, AnnieXCardScene.UPDATE_DATA);
            addTagView(this.bid);
            setNpthLastUrl(annieXLynxModel.getUrl());
            MonitorManager.INSTANCE.onLynxRenderTemplateBegin(annieXLynxModel.getSessionId());
            TemplateData templateData = annieXLynxModel.getTemplateData();
            if (templateData != null) {
                templateData.put(BULLET_UPDATE_TYPE, 1);
            } else {
                templateData = null;
            }
            updateData(templateData);
            MonitorManager.INSTANCE.onLynxRenderTemplateEnd(annieXLynxModel.getSessionId());
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:updateData");
        }
    }

    public final void updateMetaData(AnnieXLynxModel annieXLynxModel, ContextProviderFactory contextProviderFactory, IAnnieXLifeCycle annieXLifeCycle) {
        Intrinsics.checkNotNullParameter(annieXLynxModel, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:updateData");
        try {
            if (!TraceEvent.enableTrace()) {
                Log.d(TAG, "updateData: " + this);
            }
            beforeLoadTemplate(annieXLynxModel, contextProviderFactory, annieXLifeCycle, AnnieXCardScene.UPDATE_DATA);
            addTagView(this.bid);
            setNpthLastUrl(annieXLynxModel.getUrl());
            MonitorManager.INSTANCE.onLynxRenderTemplateBegin(annieXLynxModel.getSessionId());
            LynxUpdateMeta.Builder builder = new LynxUpdateMeta.Builder();
            TemplateData templateData = annieXLynxModel.getTemplateData();
            if (templateData != null) {
                templateData.put(BULLET_UPDATE_TYPE, 1);
                Unit unit = Unit.INSTANCE;
            } else {
                templateData = null;
            }
            updateMetaData(builder.setUpdatedData(templateData).setUpdatedGlobalProps(annieXLynxModel.getGlobalProps()).build());
            MonitorManager.INSTANCE.onLynxRenderTemplateEnd(annieXLynxModel.getSessionId());
            Unit unit2 = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:updateData");
        }
    }

    public void updateData(Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r6, Constants.KEY_DATA);
        TraceEvent.beginSection("AnnieXLynxView:updateData");
        try {
            AirSolution airSolution = this.airSolution;
            if (airSolution != null) {
                AirSolution.updateInitData$default(airSolution, (Map) r6, false, 2, (Object) null);
            }
            TemplateData fromMap = TemplateData.fromMap(r6);
            fromMap.put(BULLET_UPDATE_TYPE, 1);
            fromMap.markReadOnly();
            super.updateData((AnnieXLynxView) fromMap);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:updateData");
        }
    }

    public void destroy() {
        TraceEvent.beginSection("AnnieXLynxView:destroy");
        try {
            if (Intrinsics.areEqual(this.bid, "Loki") && this.optLokiDestroy) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.android.anniex.ui.AnnieXLynxView$destroy$1$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnnieXLynxView.this.lokiDestroy();
                    }
                }, 20L);
            } else {
                if (!TraceEvent.enableTrace()) {
                    Log.d(TAG, "===destroy===: " + this);
                }
                MonitorManager.reportInfo$default(MonitorManager.INSTANCE, this.sessionId, true, null, null, false, 28, null);
                MonitorManager.INSTANCE.removeMonitorInfo(this.sessionId);
                XBridgeHelper.INSTANCE.releaseContext(this.bid, this.lynxBDXBridge);
                ContextProviderManager.INSTANCE.unRegister(this.sessionId);
                AnnieXDefaultLynxViewClient annieXDefaultLynxViewClient = this.lynxViewClient;
                if (annieXDefaultLynxViewClient != null) {
                    removeLynxViewClient((LynxViewClient) annieXDefaultLynxViewClient);
                }
                setAsyncImageInterceptor(null);
                this.cacheGlobalProps.clear();
                LynxBDXBridge lynxBDXBridge = this.lynxBDXBridge;
                if (lynxBDXBridge != null) {
                    lynxBDXBridge.release();
                }
                if (IConditionCallKt.enableJsbBridgeReleaseOpt()) {
                    this.lynxBDXBridge = null;
                }
                String str = this.groupName;
                if (str != null) {
                    LynxGroupHolder.INSTANCE.removeLynxGroup(str);
                }
                this.currentLifeCycle = null;
                removeScreenCaptureListener();
                ArgusLynxDelegateAdapter argusSecureAdapter = getArgusSecureAdapter(null);
                if (argusSecureAdapter != null) {
                    argusSecureAdapter.onViewDestroy();
                }
                IAnnieXLatchService iAnnieXLatchService = (IAnnieXLatchService) AnnieX.INSTANCE.getService(this.bid, IAnnieXLatchService.class);
                if (iAnnieXLatchService != null) {
                    iAnnieXLatchService.releaseLatchProcess(this.sessionId);
                }
                if (IConditionCallKt.enableFixDestroyWithOutForestRelease()) {
                    ForestLoader.INSTANCE.release(this.sessionId);
                }
                super.destroy();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:destroy");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addTagView(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        TraceEvent.beginSection("AnnieXLynxView:addTagView");
        try {
            DebugInfo debugInfo = DebugConfig.INSTANCE.get(bid);
            if (!(BulletEnv.Companion.getInstance().getDebuggable() && BulletEnv.Companion.getInstance().getShowTag() && debugInfo.getShowDebugTagView())) {
                debugInfo = null;
            }
            if (debugInfo != null) {
                String str = WhenMappings.$EnumSwitchMapping$0[this.scene.ordinal()] == 1 ? "annieX_card" : "annieX_card_" + this.scene.getTag();
                String debugTagPrefix = debugInfo.getDebugTagPrefix();
                String str2 = str + '_' + (debugTagPrefix == null || debugTagPrefix.length() == 0 ? "" : debugInfo.getDebugTagPrefix() + " - ") + this.debugTag;
                if (getForeground() == null) {
                    TraceEvent.beginSection("AnnieXLynxView:init_debug_tag");
                    try {
                        setForeground(new DebugTagDrawable(null, 1, null));
                        Unit unit = Unit.INSTANCE;
                        TraceEvent.endSection("AnnieXLynxView:init_debug_tag");
                    } catch (Throwable th) {
                        TraceEvent.endSection("AnnieXLynxView:init_debug_tag");
                        throw th;
                    }
                }
                Drawable foreground = getForeground();
                DebugTagDrawable debugTagDrawable = foreground instanceof DebugTagDrawable ? (DebugTagDrawable) foreground : null;
                if (debugTagDrawable != null) {
                    debugTagDrawable.setText(str2);
                    Function1<? super View, Unit> onTagClickListener = BulletEnv.Companion.getInstance().getOnTagClickListener();
                    if (onTagClickListener != null) {
                        debugTagDrawable.setClickListener((View) this, onTagClickListener);
                    }
                }
            }
            Unit unit2 = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:addTagView");
        }
    }

    public final void onLoadFail(String bid, String sessionId, final int errorCode, final String errorMessage, final IAnnieXLifeCycle annieXLifeCycle) {
        TraceEvent.beginSection("AnnieXLynxView:onLoadFail");
        try {
            showLynxRedError(errorMessage);
            runOnUiThread(new Function0<Unit>() { // from class: com.bytedance.android.anniex.ui.AnnieXLynxView$onLoadFail$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m3460invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m3460invoke() {
                    IAnnieXLifeCycle iAnnieXLifeCycle = IAnnieXLifeCycle.this;
                    if (iAnnieXLifeCycle != null) {
                        iAnnieXLifeCycle.onLoadFailed(this, errorMessage);
                    }
                    IAnnieXLifeCycle iAnnieXLifeCycle2 = IAnnieXLifeCycle.this;
                    IAnnieXLifeCycle.AnnieXLynxLifeCycle annieXLynxLifeCycle = iAnnieXLifeCycle2 instanceof IAnnieXLifeCycle.AnnieXLynxLifeCycle ? (IAnnieXLifeCycle.AnnieXLynxLifeCycle) iAnnieXLifeCycle2 : null;
                    if (annieXLynxLifeCycle != null) {
                        annieXLynxLifeCycle.onLoadFailed(this, errorCode, errorMessage);
                    }
                }
            });
            HybridLogger.e$default(HybridLogger.INSTANCE, "XResourceLoader", errorMessage, (Map) null, (LoggerContext) null, 12, (Object) null);
            MonitorManager.INSTANCE.onLoadFail(bid, sessionId, AbsBulletMonitorCallback.ErrStage.RL, errorMessage, this);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:onLoadFail");
        }
    }

    public final void setNpthLastUrl(String r10) {
        String str;
        List split$default;
        TraceEvent.beginSection("AnnieXLynxView:setNpthLastUrl");
        try {
            Result.Companion companion = Result.Companion;
            HashMap hashMap = new HashMap();
            if (r10 == null || (split$default = StringsKt.split$default(r10, new String[]{"?"}, false, 0, 6, (Object) null)) == null || (str = (String) split$default.get(0)) == null) {
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
        } finally {
        }
        Unit unit = Unit.INSTANCE;
    }

    public final void loadTemplateWithUrl(final AnnieXLynxModel annieXLynxModel, final LynxLoadMode loadMode, final IAnnieXLifeCycle annieXLifeCycle, final boolean modelGlobalPropsFirst) {
        Integer num;
        TraceEvent.beginSection("AnnieXLynxView:loadTemplateWithUrl");
        try {
            MonitorManager.INSTANCE.onPrepareTemplateBegin(annieXLynxModel.getSessionId());
            final boolean booleanQueryParameter = annieXLynxModel.getOriginalUri().getBooleanQueryParameter("enable_lynx_predecode", false);
            final boolean z = annieXLynxModel.isSSR() && annieXLynxModel.getIsLynxSSRViaSchemaConfig();
            final boolean z2 = z;
            Function1<Response, Unit> function1 = new Function1<Response, Unit>() { // from class: com.bytedance.android.anniex.ui.AnnieXLynxView$loadTemplateWithUrl$1$callback$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Response) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Response response) {
                    Intrinsics.checkNotNullParameter(response, "resp");
                    if (!z2 || (response instanceof ProcessedResponse) || response.isSucceed()) {
                        this.handleResponseWithLoadTemplateWithUrl(response, annieXLynxModel, loadMode, annieXLifeCycle, modelGlobalPropsFirst);
                    } else {
                        this.requestLynxSSRData(annieXLynxModel, loadMode, annieXLifeCycle, modelGlobalPropsFirst, booleanQueryParameter);
                    }
                }
            };
            TaskConfig taskConfig = new TaskConfig((String) null, 1, (DefaultConstructorMarker) null);
            String queryParameter = annieXLynxModel.getOriginalUri().getQueryParameter("dynamic");
            if (queryParameter != null) {
                Intrinsics.checkNotNullExpressionValue(queryParameter, "getQueryParameter(\"dynamic\")");
                num = StringsKt.toIntOrNull(queryParameter);
            } else {
                num = null;
            }
            taskConfig.setDynamic(num);
            Function1<RequestParams, Unit> function12 = new Function1<RequestParams, Unit>() { // from class: com.bytedance.android.anniex.ui.AnnieXLynxView$loadTemplateWithUrl$1$onRequestParamsBuilt$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((RequestParams) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(RequestParams requestParams) {
                    Intrinsics.checkNotNullParameter(requestParams, "params");
                    requestParams.setDisableCdn(z);
                }
            };
            if (Intrinsics.areEqual(annieXLynxModel.getSsrMode(), AnnieXLynxModelBuilder.SSR_MODE_SSR_ONLY)) {
                requestLynxSSRData(annieXLynxModel, loadMode, annieXLifeCycle, modelGlobalPropsFirst, booleanQueryParameter);
            } else if (!booleanQueryParameter) {
                ForestLoader forestLoader = ForestLoader.INSTANCE;
                String uri = annieXLynxModel.getOriginalUri().toString();
                Intrinsics.checkNotNullExpressionValue(uri, "annieXLynxModel.originalUri.toString()");
                ForestLoader.loadAsync$default(forestLoader, (Forest) null, uri, "ttnet", Scene.LYNX_TEMPLATE, annieXLynxModel.getSessionId(), taskConfig, false, function12, function1, 65, (Object) null);
            } else {
                if (!TraceEvent.enableTrace()) {
                    Log.d(TAG, "==========loadAsyncWithProcessor========");
                }
                ForestLoader forestLoader2 = ForestLoader.INSTANCE;
                String uri2 = annieXLynxModel.getOriginalUri().toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "annieXLynxModel.originalUri.toString()");
                ForestLoader.loadAsyncWithProcessor$default(forestLoader2, (Forest) null, uri2, "ttnet", Scene.LYNX_TEMPLATE, annieXLynxModel.getSessionId(), taskConfig, false, new TemplateBundleProcessor((String) null, false, 3, (DefaultConstructorMarker) null), function12, function1, 65, (Object) null);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("AnnieXLynxView:loadTemplateWithUrl");
        }
    }

    public void updateGlobalProps(TemplateData props) {
        Intrinsics.checkNotNullParameter(props, "props");
        TraceEvent.beginSection("LynxView:updateGlobalProps");
        try {
            super.updateGlobalProps((AnnieXLynxView) props);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("LynxView:updateGlobalProps");
        }
    }

    public void updateGlobalProps(Map<String, ? extends Object> props) {
        Intrinsics.checkNotNullParameter(props, "props");
        TraceEvent.beginSection("LynxView:updateGlobalProps");
        try {
            super.updateGlobalProps((AnnieXLynxView) props);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("LynxView:updateGlobalProps");
        }
    }

    public void renderTemplateWithBaseUrl(byte[] template, TemplateData templateData, String baseUrl) {
        TraceEvent.beginSection("LynxView:renderTemplateWithBaseUrl");
        try {
            AirSolution airSolution = this.airSolution;
            if (airSolution != null) {
                AirSolution.updateInitData$default(airSolution, templateData, false, 2, (Object) null);
            }
            super.renderTemplateWithBaseUrl(template, templateData, baseUrl);
            Unit unit = Unit.INSTANCE;
        } finally {
            TraceEvent.endSection("LynxView:renderTemplateWithBaseUrl");
        }
    }
}
