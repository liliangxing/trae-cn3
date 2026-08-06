package com.bytedance.ies.bullet.p003ui.common;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import bolts.Task;
import com.bytedance.android.anniex.R;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.base.depend.DeviceDepend;
import com.bytedance.android.anniex.container.ui.AnnieXSourceLabel;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.base.constants.GlobalPropertiesConstants;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.container.view.BulletBaseContainer;
import com.bytedance.ies.bullet.core.BulletContainerContext;
import com.bytedance.ies.bullet.core.BulletContainerManager;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.BulletLifeCycleManager;
import com.bytedance.ies.bullet.core.BulletLynxContext;
import com.bytedance.ies.bullet.core.BulletRLContext;
import com.bytedance.ies.bullet.core.BulletSchemeContext;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.core.IBulletLifeCycleV2;
import com.bytedance.ies.bullet.core.IBulletLoadLifeCycle;
import com.bytedance.ies.bullet.core.PoolBulletLifeCycle;
import com.bytedance.ies.bullet.core.common.DebugConfig;
import com.bytedance.ies.bullet.core.common.DebugInfo;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.container.IBulletActivityWrapper;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.device.BulletDeviceUtils;
import com.bytedance.ies.bullet.core.event.KitActionType;
import com.bytedance.ies.bullet.core.event.MiddlewareEvent;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.kit.bridge.IEventListener;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.core.util.ContextUtil;
import com.bytedance.ies.bullet.forest.ForestPreloadHelper;
import com.bytedance.ies.bullet.interaction.predefine.PredefineManager;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.p003ui.common.container.IBulletEventInterceptor;
import com.bytedance.ies.bullet.p003ui.common.loader.BulletContainerLoader;
import com.bytedance.ies.bullet.p003ui.common.utils.BulletPadAdapterUtil;
import com.bytedance.ies.bullet.p003ui.common.utils.OnScreenCaptureListener;
import com.bytedance.ies.bullet.p003ui.common.utils.ScreenCaptureUtils;
import com.bytedance.ies.bullet.p003ui.common.utils.ScreenInfo;
import com.bytedance.ies.bullet.p003ui.common.utils.ViewUtil;
import com.bytedance.ies.bullet.prefetchv2.PrefetchSessionManager;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.IPreRenderServiceKt;
import com.bytedance.ies.bullet.service.base.IPrefetchService;
import com.bytedance.ies.bullet.service.base.IPrefetchV2Service;
import com.bytedance.ies.bullet.service.base.IPrefetchV2ServiceKt;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.ies.bullet.service.base.api.BaseServiceContext;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.api.IServiceContext;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate;
import com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService;
import com.bytedance.ies.bullet.service.base.lynx.LynxError;
import com.bytedance.ies.bullet.service.base.resourceloader.config.CustomLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.RLOptimiseConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.MonitorSettingsConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.deviceperf.ScrollInfo;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.interceptor.BundleInterceptor;
import com.bytedance.ies.bullet.service.sdk.SchemaConfig;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxInitDataWrapper;
import com.bytedance.notification.Constants;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.trae.login.activity.PhoneBindActivity;
import com.bytedance.ttwebview.TTWebPredictor;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.transform.Transformer;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: BulletCardView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ù\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b+\n\u0002\u0010\u0012\n\u0002\b\u0013*\u0001\u0019\b\u0016\u0018\u0000 ú\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002ú\u0001B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010q\u001a\u0004\u0018\u00010\u00102\u0006\u0010r\u001a\u00020\nH\u0016J\u000e\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u000207J.\u0010v\u001a\u00020t2\u0006\u0010w\u001a\u00020\r2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\r0y2\u000e\u0010z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010{0yH\u0016J\u0010\u0010|\u001a\u00020t2\b\u0010}\u001a\u0004\u0018\u00010\u0003J\b\u0010~\u001a\u00020tH\u0002J\b\u0010\u007f\u001a\u00020tH\u0002J\u0012\u0010\u0080\u0001\u001a\u00020t2\u0007\u0010\u0081\u0001\u001a\u00020\rH\u0016J&\u0010\u0082\u0001\u001a\u00020t2\u001a\u0010\u0083\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020t0\u0084\u0001¢\u0006\u0003\b\u0085\u0001H\u0082\bJ'\u0010\u0086\u0001\u001a\u00020t2\u001b\u0010\u0083\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0087\u0001\u0012\u0004\u0012\u00020t0\u0084\u0001¢\u0006\u0003\b\u0085\u0001H\u0082\bJ\u0013\u0010\u0088\u0001\u001a\u00020t2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J/\u0010\u008b\u0001\u001a\u0005\u0018\u0001H\u008c\u0001\"\n\b\u0000\u0010\u008c\u0001*\u00030\u008d\u00012\u000f\u0010\u008e\u0001\u001a\n\u0012\u0005\u0012\u0003H\u008c\u00010\u008f\u0001H\u0016¢\u0006\u0003\u0010\u0090\u0001J\t\u0010\u0091\u0001\u001a\u00020\rH\u0016J\u000b\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u001eH\u0016J/\u0010\u0093\u0001\u001a\u0005\u0018\u0001H\u008c\u0001\"\n\b\u0000\u0010\u008c\u0001*\u00030\u0094\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u0003H\u008c\u00010\u008f\u0001H\u0016¢\u0006\u0003\u0010\u0096\u0001J\u000b\u0010\u0097\u0001\u001a\u0004\u0018\u00010lH\u0016J\u000b\u0010\u0098\u0001\u001a\u0004\u0018\u00010'H\u0016J\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0003J\u000b\u0010\u009a\u0001\u001a\u0004\u0018\u00010lH\u0016J\f\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0016J?\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u0001\"\n\b\u0000\u0010\u008c\u0001*\u00030\u008d\u00012\b\u0010k\u001a\u0004\u0018\u00010l2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u00012\u000f\u0010\u008e\u0001\u001a\n\u0012\u0005\u0012\u0003H\u008c\u00010\u008f\u0001H\u0016J\t\u0010 \u0001\u001a\u00020\rH\u0016J\t\u0010¡\u0001\u001a\u00020 H\u0016J\u0006\u00109\u001a\u00020 J\u001f\u0010¢\u0001\u001a\u00020 2\u0014\u0010c\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020e\u0018\u00010\u000fH\u0002J\u0007\u0010£\u0001\u001a\u00020 J\u0007\u0010¤\u0001\u001a\u00020 J\u0007\u0010¥\u0001\u001a\u00020 J=\u0010¦\u0001\u001a\u00020t2\u0006\u0010k\u001a\u00020l2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\t\u0010§\u0001\u001a\u0004\u0018\u00010J2\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010¦\u0001\u001a\u00020t2\u0006\u0010k\u001a\u00020l2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u00012\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u0003H\u0016J1\u0010¦\u0001\u001a\u00020t2\u0006\u0010k\u001a\u00020l2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u00012\t\u0010§\u0001\u001a\u0004\u0018\u00010J2\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u0003J+\u0010©\u0001\u001a\u00020t2\u0006\u0010k\u001a\u00020l2\f\b\u0002\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u00012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010JH\u0002J\t\u0010ª\u0001\u001a\u00020tH\u0002J\t\u0010«\u0001\u001a\u00020tH\u0002J\u0011\u0010¬\u0001\u001a\u00020t2\u0006\u0010k\u001a\u00020lH\u0002J\t\u0010\u00ad\u0001\u001a\u00020tH\u0014J\t\u0010®\u0001\u001a\u00020tH\u0016J\t\u0010¯\u0001\u001a\u00020tH\u0016J\t\u0010°\u0001\u001a\u00020tH\u0016J\u0015\u0010±\u0001\u001a\u00020t2\n\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001H\u0014J\t\u0010´\u0001\u001a\u00020tH\u0014J\t\u0010µ\u0001\u001a\u00020tH\u0016J\t\u0010¶\u0001\u001a\u00020tH\u0016J\u0013\u0010·\u0001\u001a\u00020t2\b\u0010¸\u0001\u001a\u00030¹\u0001H\u0016J\u001b\u0010º\u0001\u001a\u00020t2\u0006\u0010k\u001a\u00020l2\b\u0010»\u0001\u001a\u00030¼\u0001H\u0016J\u0007\u0010½\u0001\u001a\u00020tJ'\u0010¾\u0001\u001a\u00020t2\u0006\u00108\u001a\u00020\r2\u0014\u0010c\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020e\u0018\u00010\u000fH\u0002J\u001c\u0010¿\u0001\u001a\u00020t2\u0006\u0010k\u001a\u00020l2\t\u0010À\u0001\u001a\u0004\u0018\u00010'H\u0016J(\u0010Á\u0001\u001a\u00020t2\u0006\u0010k\u001a\u00020l2\t\u0010À\u0001\u001a\u0004\u0018\u00010'2\n\u0010Â\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0016J\u001b\u0010Ã\u0001\u001a\u00020t2\u0006\u0010k\u001a\u00020l2\b\u0010»\u0001\u001a\u00030¼\u0001H\u0016J&\u0010Ä\u0001\u001a\u00020t2\u0006\u0010k\u001a\u00020l2\t\u0010À\u0001\u001a\u0004\u0018\u00010'2\b\u0010Å\u0001\u001a\u00030\u009c\u0001H\u0016J\u001c\u0010Æ\u0001\u001a\u00020t2\u0006\u0010k\u001a\u00020l2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010È\u0001\u001a\u00020t2\u0006\u0010k\u001a\u00020l2\t\u0010À\u0001\u001a\u0004\u0018\u00010'H\u0016J\t\u0010É\u0001\u001a\u00020tH\u0016J\u000f\u0010Ê\u0001\u001a\u00020tH\u0000¢\u0006\u0003\bË\u0001JQ\u0010Ì\u0001\u001a\u00020t2\u0007\u0010Í\u0001\u001a\u00020\n2\u0007\u0010Î\u0001\u001a\u00020\n2\u0007\u0010Ï\u0001\u001a\u00020\n2\u0007\u0010Ð\u0001\u001a\u00020\n2\u0007\u0010Ñ\u0001\u001a\u00020\n2\u0007\u0010Ò\u0001\u001a\u00020\n2\u0007\u0010Ó\u0001\u001a\u00020\n2\u0007\u0010Ô\u0001\u001a\u00020\nH\u0002J\u001c\u0010Õ\u0001\u001a\u00020t2\u0006\u0010k\u001a\u00020l2\t\u0010À\u0001\u001a\u0004\u0018\u00010'H\u0016J)\u0010Ö\u0001\u001a\u00020t2\t\u0010À\u0001\u001a\u0004\u0018\u00010'2\b\u0010×\u0001\u001a\u00030³\u00012\t\b\u0002\u0010Ø\u0001\u001a\u00020 H\u0002J\t\u0010Ù\u0001\u001a\u00020tH\u0016J\t\u0010Ú\u0001\u001a\u00020tH\u0016J\u001f\u0010Û\u0001\u001a\u00020t2\t\u0010§\u0001\u001a\u0004\u0018\u00010J2\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010Ü\u0001\u001a\u00020t2\t\u0010§\u0001\u001a\u0004\u0018\u00010J2\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u00032\t\b\u0002\u0010Ý\u0001\u001a\u00020 J2\u0010Þ\u0001\u001a\u00020t2\t\u0010§\u0001\u001a\u0004\u0018\u00010J2\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u00032\u0013\u0010ß\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020e0dJ\u001d\u0010à\u0001\u001a\u00020t2\t\u0010§\u0001\u001a\u0004\u0018\u00010J2\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u0003J\u0007\u0010á\u0001\u001a\u00020tJ\u0011\u0010â\u0001\u001a\u00020t2\b\u0010}\u001a\u0004\u0018\u00010\u0003J\t\u0010ã\u0001\u001a\u00020tH\u0002J\u0007\u0010ä\u0001\u001a\u00020tJ\t\u0010å\u0001\u001a\u00020tH\u0002J/\u0010æ\u0001\u001a\u00020t2\b\u0010ç\u0001\u001a\u00030è\u00012\u0007\u0010é\u0001\u001a\u00020\r2\u0013\u0010ê\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020e0dJ1\u0010æ\u0001\u001a\u00020t2\u0007\u0010ë\u0001\u001a\u00020\r2\u0013\u0010ê\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020e0d2\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u0003J(\u0010ì\u0001\u001a\u00020t2\u0014\u0010c\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020e\u0018\u00010\u000f2\u0007\u0010í\u0001\u001a\u00020\nH\u0002J*\u0010î\u0001\u001a\u00020t2\u0007\u0010ï\u0001\u001a\u00020\n2\u0016\b\u0002\u0010c\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020e\u0018\u00010dH\u0002J\t\u0010ð\u0001\u001a\u00020tH\u0002J?\u0010ñ\u0001\u001a\u00020t2\u0007\u0010ò\u0001\u001a\u00020\u00102\u0007\u0010ó\u0001\u001a\u00020\n2\u0007\u0010ô\u0001\u001a\u00020\n2\u0007\u0010õ\u0001\u001a\u00020\n2\u0007\u0010ö\u0001\u001a\u00020\n2\u0007\u0010÷\u0001\u001a\u00020\nH\u0016J\u0011\u0010ø\u0001\u001a\u00020t2\u0006\u0010r\u001a\u00020\rH\u0007J\t\u0010ù\u0001\u001a\u00020tH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010$R\u0012\u0010%\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010*\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00105\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00030FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u000e\u0010Q\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\u00020SX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0014\u0010X\u001a\b\u0012\u0004\u0012\u00020Y06X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010Z\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010$R\u0012\u0010[\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010$R\u0014\u0010\\\u001a\u00020JX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010c\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020e\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010f\u001a\u00020g8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bj\u0010.\u001a\u0004\bh\u0010iR\u001c\u0010k\u001a\u0004\u0018\u00010lX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010p¨\u0006û\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/BulletCardView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ON_USER_CAPTURE_SCREEN", "", "_$_findViewCache", "", "Landroid/view/View;", "value", "Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "activityWrapper", "getActivityWrapper", "()Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "setActivityWrapper", "(Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;)V", "bulletActivityDelegate", "com/bytedance/ies/bullet/ui/common/BulletCardView$bulletActivityDelegate$1", "Lcom/bytedance/ies/bullet/ui/common/BulletCardView$bulletActivityDelegate$1;", "bulletContainerLoader", "Lcom/bytedance/ies/bullet/ui/common/loader/BulletContainerLoader;", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "changeOrientationEventToLayoutChange", "", "createViewTime", "", "curHorizontalBreakPoint", "Ljava/lang/Integer;", "curVerticalBreakPoint", "currentKitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "debugInfo", "Lcom/bytedance/ies/bullet/core/common/DebugInfo;", "decorView", "getDecorView", "()Landroid/view/View;", "decorView$delegate", "Lkotlin/Lazy;", "eventInterceptor", "Lcom/bytedance/ies/bullet/ui/common/container/IBulletEventInterceptor;", "getEventInterceptor", "()Lcom/bytedance/ies/bullet/ui/common/container/IBulletEventInterceptor;", "setEventInterceptor", "(Lcom/bytedance/ies/bullet/ui/common/container/IBulletEventInterceptor;)V", "eventListeners", "", "Lcom/bytedance/ies/bullet/core/kit/bridge/IEventListener;", "foldStatus", "hasKitView", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isAutoReleasableWhenDetached", "()Z", "setAutoReleasableWhenDetached", "(Z)V", "isJsRuntimeReady", "isReleased", "isResuming", "isRootViewFirstLayout", "lastOrientation", "Lcom/bytedance/ies/bullet/ui/common/Orientation;", "lifeCycleListeners", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "loadStatus", "Ljava/util/concurrent/atomic/AtomicInteger;", "localContextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "lynxClient", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "getLynxClient", "()Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "setLynxClient", "(Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;)V", "mBid", "mCurrentScene", "Lcom/bytedance/ies/bullet/core/common/Scenes;", "getMCurrentScene", "()Lcom/bytedance/ies/bullet/core/common/Scenes;", "setMCurrentScene", "(Lcom/bytedance/ies/bullet/core/common/Scenes;)V", "middlewareEvents", "Lcom/bytedance/ies/bullet/core/event/MiddlewareEvent;", "padAdapterHeight", "padAdapterWidth", "providerFactory", "getProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "rootViewLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "screenCaptureListener", "Lcom/bytedance/ies/bullet/ui/common/utils/OnScreenCaptureListener;", "screenProps", "", "", "serviceContext", "Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;", "getServiceContext", "()Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;", "serviceContext$delegate", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "_$_findCachedViewByID", "id", "addEventListener", "", "listener", "addEventObserver", "actionType", "name", "", "params", "Lorg/json/JSONObject;", "addLifeCycleListener", "iBulletLifeCycle", "addScreenCaptureListener", "addTagView", PhoneBindActivity.MODE_BIND, "bid", "bulletLifeCycleRun", "handler", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "bulletLoadLifeCycleRun", "Lcom/bytedance/ies/bullet/core/IBulletLoadLifeCycle;", "dealWithAction", "action", "Lcom/bytedance/ies/bullet/core/event/KitActionType;", "extraSchemaModelOfType", "T", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "getBid", "getBulletContext", "getBulletService", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "clazz", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "getCurrentUri", "getKitView", "getPoolBulletLifeCycle", "getProcessingUri", "getSchemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "getSchemaModelUnionBeforeLoad", SchemaConstants.QUERY_KEY_BUNDLE, "Landroid/os/Bundle;", "getSessionId", "hasErrorView", "isBreakPointChange", "isLoadFail", "isLoadSuccess", "isLoading", "loadUri", "contextProviderFactory", "lifeCycle", "loadUriInner", "markScene", "observerKitViewLayoutChanged", "observerRootViewLayoutChanged", "onAttachedToWindow", "onBulletViewCreate", "onBulletViewRelease", "onClose", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "onEnterBackground", "onEnterForeground", "onEvent", ISignalReportService.BODY_KEY_EVENT, "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "onFallback", "e", "", "onFetchFromPreRenderPool", "onFoldStatusChanged", "onKitViewCreate", "kitView", "onKitViewDestroy", "throwable", "onLoadFail", "onLoadModelSuccess", "schemaModelUnion", "onLoadStart", "container", "onLoadUriSuccess", "onOpen", "onPopupDestroy", "onPopupDestroy$anniex_release", "onRootViewLayoutChanged", "left", "top", "right", Constants.NOTIFICATION_GIF_POSITION_BOTTOM, "oldLeft", "oldTop", "oldRight", "oldBottom", "onRuntimeReady", "padAdaptation", "configuration", "isKitViewCreate", "reLoadUri", "release", "reload", "reloadTemplate", "withGlobalProps", "reloadTemplateWithGlobalProps", "globalProps", "reloadWithReset", "removeKitView", "removeLifeCycleListener", "removeManagerWithSessionId", "removePoolBulletLifeCycle", "removeScreenCaptureListener", "renderSSRHydrate", "templateArray", "", "baseUrl", "data", "url", "sendEvents", "newOrientation", "sendOrientationEvent", "orientation", "sendWindowSizeEvent", "setLoadingView", "loadingView", SchemaConstants.QUERY_KEY_GRAVITY, "marginLeft", "marginTop", "marginRight", "marginBottom", "setSessionId", "updateLynxScreenMetrics", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BulletCardView extends FrameLayout implements IBulletContainer, IBulletLifeCycle, IServiceToken {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String VIEWINVISIBLE = "0";
    private static final String VIEWVISIBLE = "1";
    private static boolean initializeDefaultBid;
    private final String ON_USER_CAPTURE_SCREEN;
    private Map<Integer, View> _$_findViewCache;
    private IBulletActivityWrapper activityWrapper;
    private BulletCardView$bulletActivityDelegate$1 bulletActivityDelegate;
    private BulletContainerLoader bulletContainerLoader;
    private BulletContext bulletContext;
    private boolean changeOrientationEventToLayoutChange;
    private long createViewTime;
    private Integer curHorizontalBreakPoint;
    private Integer curVerticalBreakPoint;
    private IKitViewService currentKitView;
    private DebugInfo debugInfo;

    /* renamed from: decorView$delegate, reason: from kotlin metadata */
    private final Lazy decorView;
    private IBulletEventInterceptor eventInterceptor;
    private List<IEventListener> eventListeners;
    private String foldStatus;
    private AtomicBoolean hasKitView;
    private boolean isAutoReleasableWhenDetached;
    private AtomicBoolean isJsRuntimeReady;
    private boolean isReleased;
    private AtomicBoolean isResuming;
    private boolean isRootViewFirstLayout;
    private Orientation lastOrientation;
    private ConcurrentLinkedQueue<IBulletLifeCycle> lifeCycleListeners;
    private final AtomicInteger loadStatus;
    private ContextProviderFactory localContextProviderFactory;
    private ILynxClientDelegate lynxClient;
    private String mBid;
    private Scenes mCurrentScene;
    private final List<MiddlewareEvent> middlewareEvents;
    private Integer padAdapterHeight;
    private Integer padAdapterWidth;
    private final ContextProviderFactory providerFactory;
    private View.OnLayoutChangeListener rootViewLayoutListener;
    private OnScreenCaptureListener screenCaptureListener;
    private Map<String, ? extends Object> screenProps;

    /* renamed from: serviceContext$delegate, reason: from kotlin metadata */
    private final Lazy serviceContext;
    private Uri uri;

    /* compiled from: BulletCardView.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scenes.values().length];
            try {
                iArr[Scenes.AbsActivity.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Scenes.PopupFragment.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BulletCardView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BulletCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean hasErrorView() {
        return false;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void setLoadingView(View loadingView, int gravity, int marginLeft, int marginTop, int marginRight, int marginBottom) {
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
    }

    public /* synthetic */ BulletCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    public Map<Class<?>, Object> getAllDependency() {
        return IServiceToken.DefaultImpls.getAllDependency(this);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    public <T> T getDependency(Class<T> cls) {
        return (T) IServiceToken.DefaultImpls.getDependency(this, cls);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    public <T extends IBulletService> T getService(Class<T> cls) {
        return (T) IServiceToken.DefaultImpls.getService(this, cls);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.bytedance.ies.bullet.ui.common.BulletCardView$bulletActivityDelegate$1] */
    public BulletCardView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        if (!initializeDefaultBid) {
            initializeDefaultBid = true;
            try {
                BulletSdk.INSTANCE.ensureDefaultBidReady(context);
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletCardView call BulletSdk.ensureDefaultBidReady success", null, "XView", 2, null);
            } catch (Throwable th) {
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletCardView call BulletSdk.ensureDefaultBidReady failed, message = " + th.getMessage(), null, "XView", 2, null);
            }
        }
        ContextProviderFactory contextProviderFactory = new ContextProviderFactory();
        contextProviderFactory.registerHolder(Context.class, context);
        this.providerFactory = contextProviderFactory;
        this.createViewTime = System.currentTimeMillis();
        this.mCurrentScene = Scenes.Card;
        this.mBid = "default_bid";
        this.middlewareEvents = new ArrayList();
        this.lastOrientation = Orientation.UNKNOWN;
        this.ON_USER_CAPTURE_SCREEN = "onUserCaptureScreen";
        this.lynxClient = new ILynxClientDelegate() { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$lynxClient$1
            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onPageStart(IKitViewService viewService, String url) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onPageStart(viewService, url);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onLoadSuccess(IKitViewService viewService) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onLoadSuccess(viewService);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onFirstScreen(IKitViewService viewService) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onFirstScreen(viewService);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onPageUpdate(IKitViewService viewService) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onPageUpdate(viewService);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onDataUpdated(IKitViewService viewService) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onDataUpdated(viewService);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onLoadFailed(IKitViewService viewService, String errorMsg) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onLoadFailed(viewService, errorMsg);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onReceivedError(IKitViewService viewService, String errorMsg) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onReceivedError(viewService, errorMsg);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onReceivedError(IKitViewService viewService, LynxError error) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onReceivedError(viewService, error);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onFirstLoadPerfReady(IKitViewService viewService, final JSONObject pref) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                BulletCardView.this.onEvent(new IEvent(pref) { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$lynxClient$1$onFirstLoadPerfReady$1
                    private final String name = "perf";
                    private final Object params;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("perfBaseTimeStamp", String.valueOf(System.currentTimeMillis()));
                        jSONObject.put("perf", pref);
                        this.params = jSONObject;
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
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onFirstLoadPerfReady(viewService, pref);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onUpdatePerfReady(IKitViewService viewService, JSONObject pref) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onUpdatePerfReady(viewService, pref);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onRuntimeReady(IKitViewService viewService) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onRuntimeReady(viewService);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onScrollStart(ScrollInfo info) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onScrollStart(info);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onScrollStop(ScrollInfo info) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onScrollStop(info);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onTimingSetup(Map<String, Object> timingInfo) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onTimingSetup(timingInfo);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void onTimingUpdate(Map<String, Object> timingInfo, Map<String, Long> updateTiming, String flag) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.onTimingUpdate(timingInfo, updateTiming, flag);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public void loadImage(IKitViewService viewService, Context context2, String cacheKey, String src, float width, float height, Transformer transformer, Function2<Object, ? super Throwable, Unit> handler) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(handler, "handler");
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        lynxClient.loadImage(viewService, context2, cacheKey, src, width, height, transformer, handler);
                    }
                }
            }

            @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
            public String shouldRedirectImageUrl(String url) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                String str;
                concurrentLinkedQueue = BulletCardView.this.lifeCycleListeners;
                Iterator it = concurrentLinkedQueue.iterator();
                do {
                    str = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    ILynxClientDelegate lynxClient = ((IBulletLifeCycle) it.next()).getLynxClient();
                    if (lynxClient != null) {
                        str = lynxClient.shouldRedirectImageUrl(url);
                    }
                } while (str == null);
                return str;
            }
        };
        this.hasKitView = new AtomicBoolean(false);
        this.isRootViewFirstLayout = true;
        this.foldStatus = "";
        this.decorView = LazyKt.lazy(new Function0<View>() { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$decorView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final View m596invoke() {
                Window window;
                Activity ownerActivity = ContextUtil.INSTANCE.getOwnerActivity(context);
                if (ownerActivity == null || (window = ownerActivity.getWindow()) == null) {
                    return null;
                }
                return window.getDecorView();
            }
        });
        try {
            Result.Companion companion = Result.Companion;
            addView(new BulletBaseContainer(context, null, 0, 6, null));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th2));
        }
        this.loadStatus = new AtomicInteger(LoadStatus.INIT.ordinal());
        this.isResuming = new AtomicBoolean(false);
        this.isJsRuntimeReady = new AtomicBoolean(false);
        this.serviceContext = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<BaseServiceContext>() { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$serviceContext$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BaseServiceContext m597invoke() {
                return new BaseServiceContext(context, BulletEnv.INSTANCE.getInstance().getDebuggable());
            }
        });
        this.lifeCycleListeners = new ConcurrentLinkedQueue<>();
        this.bulletContainerLoader = new BulletContainerLoader(getServiceContext(), this.mBid);
        this.bulletActivityDelegate = new BaseBulletActivityDelegate() { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$bulletActivityDelegate$1
            @Override // com.bytedance.ies.bullet.p003ui.common.BaseBulletActivityDelegate, com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
            public boolean shouldInterceptBackPressedEvent(Activity activity) {
                IKitViewService iKitViewService;
                Intrinsics.checkNotNullParameter(activity, "activity");
                iKitViewService = BulletCardView.this.currentKitView;
                if (iKitViewService != null) {
                    return iKitViewService.onBackPressed();
                }
                return false;
            }

            @Override // com.bytedance.ies.bullet.p003ui.common.BaseBulletActivityDelegate, com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
            public void onResume(Activity activity) {
                AtomicBoolean atomicBoolean;
                AtomicBoolean atomicBoolean2;
                Intrinsics.checkNotNullParameter(activity, "activity");
                atomicBoolean = BulletCardView.this.isResuming;
                atomicBoolean.getAndSet(true);
                atomicBoolean2 = BulletCardView.this.isJsRuntimeReady;
                if (atomicBoolean2.compareAndSet(true, true)) {
                    BulletLogger bulletLogger = BulletLogger.INSTANCE;
                    LogLevel logLevel = LogLevel.I;
                    BulletContext bulletContext = BulletCardView.this.getBulletContext();
                    bulletLogger.printTridentLog("BulletCardView.bulletActivityDelegate.onResume: call onEnterForeground", (r17 & 2) != 0 ? null : null, (r17 & 4) != 0 ? LogLevel.I : logLevel, (r17 & 8) != 0 ? "" : "XPopup", bulletContext != null ? bulletContext.getSessionId() : null, (r17 & 32) != 0 ? "" : null, (r17 & 64) != 0 ? "" : null);
                    BulletCardView.this.onEnterForeground();
                }
            }

            @Override // com.bytedance.ies.bullet.p003ui.common.BaseBulletActivityDelegate, com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
            public void onPause(Activity activity) {
                AtomicBoolean atomicBoolean;
                AtomicBoolean atomicBoolean2;
                Intrinsics.checkNotNullParameter(activity, "activity");
                atomicBoolean = BulletCardView.this.isResuming;
                atomicBoolean.getAndSet(false);
                atomicBoolean2 = BulletCardView.this.isJsRuntimeReady;
                if (atomicBoolean2.compareAndSet(true, true)) {
                    BulletCardView.this.onEnterBackground();
                }
            }

            @Override // com.bytedance.ies.bullet.p003ui.common.BaseBulletActivityDelegate, com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
            public void onDestroy(Activity activity) {
                IKitViewService iKitViewService;
                BulletContainerLoader bulletContainerLoader;
                BulletContext bulletContext;
                Intrinsics.checkNotNullParameter(activity, "activity");
                BulletCardView.this.dealWithAction(KitActionType.Closed);
                iKitViewService = BulletCardView.this.currentKitView;
                if (iKitViewService != null) {
                    iKitViewService.destroy(true);
                }
                BulletCardView.this.currentKitView = null;
                bulletContainerLoader = BulletCardView.this.bulletContainerLoader;
                bulletContainerLoader.release();
                BulletLogger bulletLogger = BulletLogger.INSTANCE;
                bulletContext = BulletCardView.this.bulletContext;
                BulletLogger.printCoreLog$default(bulletLogger, bulletContext != null ? bulletContext.getSessionId() : null, "onDestroy", "XView", null, 8, null);
            }

            @Override // com.bytedance.ies.bullet.p003ui.common.BaseBulletActivityDelegate, com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
            public void onConfigurationChanged(Activity activity, Configuration newConfig) {
                BulletContext bulletContext;
                IKitViewService iKitViewService;
                SchemaModelUnion schemaModelUnion;
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (newConfig != null) {
                    bulletContext = BulletCardView.this.bulletContext;
                    boolean z = false;
                    if (bulletContext != null && (schemaModelUnion = bulletContext.getSchemaModelUnion()) != null) {
                        if (BulletPadAdapterUtil.INSTANCE.enableAdapterPad(schemaModelUnion, BulletCardView.this.getMCurrentScene(), false)) {
                            z = true;
                        }
                    }
                    if (z) {
                        BulletCardView bulletCardView = BulletCardView.this;
                        iKitViewService = bulletCardView.currentKitView;
                        BulletCardView.padAdaptation$default(bulletCardView, iKitViewService, newConfig, false, 4, null);
                    }
                }
                super.onConfigurationChanged(activity, newConfig);
            }
        };
    }

    /* compiled from: BulletCardView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/BulletCardView$Companion;", "", "()V", "VIEWINVISIBLE", "", "VIEWVISIBLE", "initializeDefaultBid", "", "getInitializeDefaultBid", "()Z", "setInitializeDefaultBid", "(Z)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getInitializeDefaultBid() {
            return BulletCardView.initializeDefaultBid;
        }

        public final void setInitializeDefaultBid(boolean z) {
            BulletCardView.initializeDefaultBid = z;
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public ContextProviderFactory getProviderFactory() {
        return this.providerFactory;
    }

    public final Scenes getMCurrentScene() {
        return this.mCurrentScene;
    }

    public final void setMCurrentScene(Scenes scenes) {
        Intrinsics.checkNotNullParameter(scenes, "<set-?>");
        this.mCurrentScene = scenes;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public ILynxClientDelegate getLynxClient() {
        return this.lynxClient;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void setLynxClient(ILynxClientDelegate iLynxClientDelegate) {
        this.lynxClient = iLynxClientDelegate;
    }

    protected final Uri getUri() {
        return this.uri;
    }

    protected final void setUri(Uri uri) {
        this.uri = uri;
    }

    private final View getDecorView() {
        return (View) this.decorView.getValue();
    }

    /* renamed from: isAutoReleasableWhenDetached, reason: from getter */
    public final boolean getIsAutoReleasableWhenDetached() {
        return this.isAutoReleasableWhenDetached;
    }

    public final void setAutoReleasableWhenDetached(boolean z) {
        this.isAutoReleasableWhenDetached = z;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    public IServiceContext getServiceContext() {
        return (IServiceContext) this.serviceContext.getValue();
    }

    public final void addLifeCycleListener(IBulletLifeCycle iBulletLifeCycle) {
        if (iBulletLifeCycle == null || this.lifeCycleListeners.contains(iBulletLifeCycle) || Intrinsics.areEqual(this, iBulletLifeCycle)) {
            return;
        }
        this.lifeCycleListeners.add(iBulletLifeCycle);
    }

    public final void removeLifeCycleListener(IBulletLifeCycle iBulletLifeCycle) {
        this.lifeCycleListeners.remove(iBulletLifeCycle);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    /* renamed from: getBid, reason: from getter */
    public String getMBid() {
        return this.mBid;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public BulletContext getBulletContext() {
        return this.bulletContext;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public Uri getCurrentUri() {
        BulletContext bulletContext = getBulletContext();
        if (bulletContext != null) {
            return bulletContext.getLoadUri();
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public Uri getProcessingUri() {
        BulletContext bulletContext = getBulletContext();
        if (bulletContext != null) {
            return bulletContext.getLoadUri();
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public IBulletActivityWrapper getActivityWrapper() {
        return this.activityWrapper;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void setActivityWrapper(IBulletActivityWrapper iBulletActivityWrapper) {
        ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
        BulletContext bulletContext = this.bulletContext;
        contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null).registerHolder(IBulletActivityWrapper.class, iBulletActivityWrapper);
        if (iBulletActivityWrapper != null) {
            iBulletActivityWrapper.unregisterDelegate(this.bulletActivityDelegate);
        }
        if (iBulletActivityWrapper != null) {
            iBulletActivityWrapper.registerDelegate(this.bulletActivityDelegate);
        }
        this.activityWrapper = iBulletActivityWrapper;
    }

    public final IBulletEventInterceptor getEventInterceptor() {
        return this.eventInterceptor;
    }

    public final void setEventInterceptor(IBulletEventInterceptor iBulletEventInterceptor) {
        this.eventInterceptor = iBulletEventInterceptor;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public <T extends IBulletService> T getBulletService(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) ServiceCenter.INSTANCE.instance().get(getMBid(), clazz);
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public <T extends ISchemaModel> T extraSchemaModelOfType(Class<T> type) {
        BulletSchemeContext schemeContext;
        List<ISchemaModel> extraSchemaModelList;
        Object obj;
        Intrinsics.checkNotNullParameter(type, "type");
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext == null || (schemeContext = bulletContext.getSchemeContext()) == null || (extraSchemaModelList = schemeContext.getExtraSchemaModelList()) == null) {
            return null;
        }
        Iterator<T> it = extraSchemaModelList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (type.isAssignableFrom(((ISchemaModel) obj).getClass())) {
                break;
            }
        }
        T t = (T) obj;
        if (t == null || !(t instanceof ISchemaModel)) {
            return null;
        }
        return t;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void bind(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        this.isReleased = false;
        this.mBid = bid;
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null) {
            bulletContext.setBid(bid);
        }
        this.bulletContainerLoader.setBid(bid);
        this.debugInfo = DebugConfig.INSTANCE.get(bid);
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void loadUri(Uri uri, Bundle bundle, IBulletLifeCycle lifeCycle) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        loadUri(uri, bundle, null, lifeCycle);
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    /* renamed from: getKitView, reason: from getter */
    public IKitViewService getCurrentKitView() {
        return this.currentKitView;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public SchemaModelUnion getSchemaModelUnion() {
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null) {
            return bulletContext.getSchemaModelUnion();
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void addEventObserver(String actionType, List<String> name, List<? extends JSONObject> params) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(params, "params");
        this.middlewareEvents.clear();
        int i = 0;
        for (Object obj : name) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            this.middlewareEvents.add(new MiddlewareEvent(actionType, name.get(i), params.get(i), this.bulletContext));
            i = i2;
        }
    }

    private final void removeManagerWithSessionId() {
        String sessionId;
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext == null || (sessionId = bulletContext.getSessionId()) == null) {
            return;
        }
        BulletContext bulletContext2 = this.bulletContext;
        Intrinsics.checkNotNull(bulletContext2);
        removeLifeCycleListener(bulletContext2.getMonitorCallback().getBulletCallback());
        BulletContextManager.INSTANCE.getInstance().removeContext(sessionId);
        ContextProviderManager.INSTANCE.unRegister(sessionId);
        PrefetchSessionManager.INSTANCE.destroy(sessionId);
    }

    public final void loadUri(Uri uri, Bundle bundle, ContextProviderFactory contextProviderFactory, IBulletLifeCycle lifeCycle) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        loadUri(uri, bundle, null, contextProviderFactory, lifeCycle);
    }

    public void loadUri(Uri uri, Bundle bundle, BulletContext bulletContext, ContextProviderFactory contextProviderFactory, IBulletLifeCycle lifeCycle) {
        Boolean value;
        IPrefetchService iPrefetchService;
        AbsBulletMonitorCallback monitorCallback;
        MonitorSettingsConfig monitorSettingsConfig;
        String uri2;
        Uri loadUri;
        ISchemaData schemaData;
        Uri innerOriginUrl;
        Intrinsics.checkNotNullParameter(uri, "uri");
        long currentTimeMillis = System.currentTimeMillis();
        PredefineManager.INSTANCE.predefine(uri);
        removeManagerWithSessionId();
        if (bulletContext == null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletContainerView.loadUri, sessionId=" + (bundle != null ? bundle.getString("__x_session_id") : null), null, "XPreRender", 2, null);
            this.bulletContext = BulletContextManager.getOrCreateContext$default(BulletContextManager.INSTANCE.getInstance(), getMBid(), uri, bundle, false, null, 24, null);
        } else {
            this.bulletContext = bulletContext;
            BulletContextManager.INSTANCE.getInstance().addContext(bulletContext);
        }
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 != null) {
            SLMonitorCompat sLMonitorCompat = SLMonitorCompat.INSTANCE;
            String sessionId = getSessionId();
            if (bulletContext == null || (schemaData = bulletContext.getSchemaData()) == null || (innerOriginUrl = schemaData.getInnerOriginUrl()) == null || (uri2 = innerOriginUrl.toString()) == null) {
                uri2 = (bulletContext == null || (loadUri = bulletContext.getLoadUri()) == null) ? null : loadUri.toString();
                if (uri2 == null) {
                    uri2 = "";
                }
            }
            Intrinsics.checkNotNullExpressionValue(uri2, "bulletContext?.schemaDat…loadUri?.toString() ?: \"\"");
            sLMonitorCompat.reportPV(sessionId, uri2, (String) null);
            if (!bulletContext2.getUseCardMode() && Intrinsics.areEqual(new BooleanParam(bulletContext2.getSchemaModelUnion().getSchemaData(), SchemaConstants.USE_CARD_MODE, false).getValue(), true)) {
                bulletContext2.setUseCardMode(true);
                HybridLogger.i$default(HybridLogger.INSTANCE, "XInit", "useCardMode is true", null, null, 12, null);
            }
            bulletContext2.setBid(this.mBid);
            AbsBulletMonitorCallback monitorCallback2 = bulletContext2.getMonitorCallback();
            if (monitorCallback2 != null) {
                AbsBulletMonitorCallback.onLoadEntryBullet$default(monitorCallback2, currentTimeMillis, false, 2, null);
            }
            AbsBulletMonitorCallback monitorCallback3 = bulletContext2.getMonitorCallback();
            if (monitorCallback3 != null) {
                monitorCallback3.onContainerCreated(Long.valueOf(this.createViewTime));
            }
            if (!bulletContext2.getUseCardMode()) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "this@BulletCardView.context");
                bulletContext2.attachCallee(context, this.mCurrentScene);
            }
            bulletContext2.setIgnoreOrientationChanged(bundle != null && bundle.getBoolean("ignore_orientation_change", false));
        }
        this.uri = uri;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (!((iBulletSettingsService == null || (monitorSettingsConfig = (MonitorSettingsConfig) iBulletSettingsService.obtainSettings(MonitorSettingsConfig.class)) == null || monitorSettingsConfig.getLogSwitch()) ? false : true)) {
            BulletContext bulletContext3 = this.bulletContext;
            addLifeCycleListener((bulletContext3 == null || (monitorCallback = bulletContext3.getMonitorCallback()) == null) ? null : monitorCallback.getBulletCallback());
        } else {
            BulletLogger bulletLogger = BulletLogger.INSTANCE;
            BulletContext bulletContext4 = this.bulletContext;
            bulletLogger.printCoreLog(bulletContext4 != null ? bulletContext4.getSessionId() : null, "Missing monitor callback", "XView", LogLevel.W);
        }
        addLifeCycleListener(lifeCycle);
        BulletContext bulletContext5 = this.bulletContext;
        if (bulletContext5 != null) {
            ForestPreloadHelper.preloadPage$default(ForestPreloadHelper.INSTANCE, bulletContext5, (Uri) null, (String) null, false, 14, (Object) null);
            if (bulletContext5.getUseCardMode()) {
                value = true;
            } else {
                value = new BooleanParam(bulletContext5.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_DISABLE_PRE_FETCH, false).getValue();
            }
            BooleanParam booleanParam = new BooleanParam(bulletContext5.getSchemaModelUnion().getSchemaData(), SchemaConstants.ENABLE_PREFETCH_V2, false);
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletCardView.loadUri, disablePrefetch=" + value, null, null, 6, null);
            if (Intrinsics.areEqual(value, false) && !Intrinsics.areEqual(booleanParam.getValue(), true) && (iPrefetchService = (IPrefetchService) ServiceCenter.INSTANCE.instance().get(this.mBid, IPrefetchService.class)) != null) {
                iPrefetchService.prefetchForView(bulletContext5.getSchemaModelUnion().getSchemaData().getUrl());
            }
            IPrefetchV2Service prefetchV2Service = IPrefetchV2ServiceKt.getPrefetchV2Service();
            if (prefetchV2Service != null && bulletContext5.getPrefetchUri() == null) {
                prefetchV2Service.prefetch(uri, this.mBid, bulletContext5);
                bulletContext5.setPrefetchUri(uri);
            }
            String value2 = new StringParam(bulletContext5.getSchemaModelUnion().getSchemaData(), SchemaConstants.SUB_RES_PREFIX, null).getValue();
            if (value2 != null) {
                String str = value2;
                if (str.length() > 0) {
                    RLOptimiseConfig rLOptimiseConfig = new RLOptimiseConfig();
                    rLOptimiseConfig.setSpecifiedPrefix(CollectionsKt.toList(StringsKt.split$default(str, new String[]{","}, false, 0, 6, (Object) null)));
                    Log.d("TAG", "sub res prefix: " + rLOptimiseConfig.getSpecifiedPrefix());
                    getServiceContext().putDependency(RLOptimiseConfig.class, rLOptimiseConfig);
                }
            }
        }
        TTWebPredictor.INSTANCE.preconnect(uri);
        BulletContainerContext containerContext = bulletContext != null ? bulletContext.getContainerContext() : null;
        if (containerContext != null) {
            containerContext.setReload(false);
        }
        loadUriInner(uri, bundle, contextProviderFactory);
    }

    public final void renderSSRHydrate(byte[] templateArray, String baseUrl, Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(templateArray, "templateArray");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(data, "data");
        IKitViewService iKitViewService = this.currentKitView;
        if (iKitViewService != null) {
            iKitViewService.renderSSRHydrate(templateArray, baseUrl, data);
        }
    }

    public static /* synthetic */ void renderSSRHydrate$default(BulletCardView bulletCardView, String str, Map map, IBulletLifeCycle iBulletLifeCycle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderSSRHydrate");
        }
        if ((i & 4) != 0) {
            iBulletLifeCycle = null;
        }
        bulletCardView.renderSSRHydrate(str, (Map<String, ? extends Object>) map, iBulletLifeCycle);
    }

    public final void renderSSRHydrate(final String url, final Map<String, ? extends Object> data, final IBulletLifeCycle listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(data, "data");
        TaskConfig taskConfig = new TaskConfig(null, 1, null);
        taskConfig.setBid(getMBid());
        taskConfig.setResTag("template");
        try {
            Uri parse = Uri.parse(url);
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            String cdn = ExtKt.getCDN(parse, getMBid());
            if (cdn != null) {
                taskConfig.setCdnUrl(cdn);
            }
            String queryParameter = parse.getQueryParameter("channel");
            if (queryParameter != null) {
                Intrinsics.checkNotNullExpressionValue(queryParameter, "it");
                taskConfig.setChannel(queryParameter);
            }
            String queryParameter2 = parse.getQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE);
            if (queryParameter2 != null) {
                Intrinsics.checkNotNullExpressionValue(queryParameter2, "it");
                taskConfig.setBundle(queryParameter2);
            }
            taskConfig.setDynamic(1);
            String queryParameter3 = parse.getQueryParameter("dynamic");
            if (queryParameter3 != null) {
                Intrinsics.checkNotNullExpressionValue(queryParameter3, "it");
                taskConfig.setDynamic(Integer.valueOf(Integer.parseInt(queryParameter3)));
            }
        } catch (Throwable th) {
            BulletLogger.INSTANCE.printReject(th, "lynxkit.load parse url error", "XLynxKit");
        }
        final String sessionId = getSessionId();
        ResourceLoader.with$default(ResourceLoader.INSTANCE, getMBid(), null, 2, null).loadAsync(url, taskConfig, new Function1<ResourceInfo, Unit>() { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$renderSSRHydrate$1
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
                if (Intrinsics.areEqual(sessionId, this.getSessionId())) {
                    InputStream provideInputStream = resourceInfo.provideInputStream();
                    byte[] readBytes = provideInputStream != null ? ByteStreamsKt.readBytes(provideInputStream) : null;
                    if (readBytes == null) {
                        IBulletLifeCycle iBulletLifeCycle = listener;
                        if (iBulletLifeCycle != null) {
                            Uri parse2 = Uri.parse(url);
                            Intrinsics.checkNotNullExpressionValue(parse2, "parse(url)");
                            iBulletLifeCycle.onLoadFail(parse2, new Throwable("byte array is null"));
                            return;
                        }
                        return;
                    }
                    BulletContext bulletContext = this.getBulletContext();
                    BulletRLContext resourceContext = bulletContext != null ? bulletContext.getResourceContext() : null;
                    if (resourceContext != null) {
                        resourceContext.setResFrom(resourceInfo.getStatisticFrom());
                    }
                    this.renderSSRHydrate(readBytes, url, data);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$renderSSRHydrate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "it");
                if (Intrinsics.areEqual(sessionId, this.getSessionId())) {
                    IBulletLifeCycle iBulletLifeCycle = listener;
                    if (iBulletLifeCycle != null) {
                        Uri parse2 = Uri.parse(url);
                        Intrinsics.checkNotNullExpressionValue(parse2, "parse(url)");
                        iBulletLifeCycle.onLoadFail(parse2, th2);
                    }
                    BulletLogger.INSTANCE.printCoreReject(this.getSessionId(), "load template error. url: " + url, "XLynxKit", th2, LogLevel.E);
                }
            }
        });
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void reLoadUri() {
        String sessionId;
        BulletSchemeContext schemeContext;
        AbsBulletMonitorCallback monitorCallback;
        if (isLoading()) {
            return;
        }
        if (this.uri != null) {
            BulletContext bulletContext = this.bulletContext;
            Bundle bundle = null;
            BulletContainerContext containerContext = bulletContext != null ? bulletContext.getContainerContext() : null;
            if (containerContext != null) {
                containerContext.setReload(true);
            }
            BulletContext bulletContext2 = this.bulletContext;
            if (bulletContext2 != null && (monitorCallback = bulletContext2.getMonitorCallback()) != null) {
                monitorCallback.onReload(this);
            }
            Uri uri = this.uri;
            Intrinsics.checkNotNull(uri);
            BulletContext bulletContext3 = this.bulletContext;
            if (bulletContext3 != null && (schemeContext = bulletContext3.getSchemeContext()) != null) {
                bundle = schemeContext.getBundle();
            }
            loadUriInner(uri, bundle, this.localContextProviderFactory);
        }
        BulletContext bulletContext4 = this.bulletContext;
        if (bulletContext4 == null || (sessionId = bulletContext4.getSessionId()) == null) {
            return;
        }
        SLMonitorCompat.reportReusePV$default(SLMonitorCompat.INSTANCE, sessionId, (String) null, (String) null, 6, (Object) null);
    }

    static /* synthetic */ void loadUriInner$default(BulletCardView bulletCardView, Uri uri, Bundle bundle, ContextProviderFactory contextProviderFactory, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadUriInner");
        }
        if ((i & 2) != 0) {
            bundle = null;
        }
        if ((i & 4) != 0) {
            contextProviderFactory = null;
        }
        bulletCardView.loadUriInner(uri, bundle, contextProviderFactory);
    }

    private final void loadUriInner(Uri uri, Bundle bundle, ContextProviderFactory providerFactory) {
        AbsBulletMonitorCallback monitorCallback;
        markScene();
        onLoadStart(uri, this);
        if (providerFactory == null) {
            providerFactory = new ContextProviderFactory();
        }
        providerFactory.merge(getProviderFactory());
        providerFactory.registerWeakHolder(BulletContext.class, this.bulletContext);
        this.localContextProviderFactory = providerFactory;
        ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
        BulletContext bulletContext = this.bulletContext;
        contextProviderManager.register(bulletContext != null ? bulletContext.getSessionId() : null, this.localContextProviderFactory);
        getServiceContext().putDependency(BulletContext.class, this.bulletContext);
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 != null) {
            bulletContext2.setContext(getContext());
            bulletContext2.setLoadUri(uri);
            bulletContext2.getSchemeContext().setBundle(bundle);
            bulletContext2.setBulletLoadLifeCycleListener(this);
            CustomLoaderConfig customLoaderConfig = (CustomLoaderConfig) providerFactory.provideInstance(CustomLoaderConfig.class);
            if (customLoaderConfig != null) {
                bulletContext2.getResourceContext().setCustomLoaderConfig(customLoaderConfig);
            }
            CacheType cacheType = (CacheType) providerFactory.provideInstance(CacheType.class);
            if (cacheType != null) {
                bulletContext2.getContainerContext().setCacheType(cacheType);
            }
            LynxInitDataWrapper lynxInitDataWrapper = (LynxInitDataWrapper) providerFactory.provideInstance(LynxInitDataWrapper.class);
            if (lynxInitDataWrapper != null) {
                bulletContext2.getLynxContext().setInitDataWrapper(lynxInitDataWrapper);
            }
            bulletContext2.setServiceContext(getServiceContext());
        }
        if (bundle != null) {
            providerFactory.registerHolder(Bundle.class, bundle);
        }
        providerFactory.registerHolder(Context.class, getContext());
        providerFactory.registerHolder(IBulletContainer.class, this);
        IBulletActivityWrapper activityWrapper = getActivityWrapper();
        if (activityWrapper != null) {
            providerFactory.registerHolder(IBulletActivityWrapper.class, activityWrapper);
        }
        this.loadStatus.getAndSet(LoadStatus.LOADING.ordinal());
        this.middlewareEvents.clear();
        providerFactory.registerHolder(Uri.class, uri);
        providerFactory.registerWeakHolder(BulletCardView.class, this);
        this.eventInterceptor = (IBulletEventInterceptor) providerFactory.provideInstance(IBulletEventInterceptor.class);
        BulletContext bulletContext3 = this.bulletContext;
        if (bulletContext3 != null && (monitorCallback = bulletContext3.getMonitorCallback()) != null) {
            monitorCallback.onContainerLoaderStart();
        }
        getServiceContext().putDependency(BulletContext.class, this.bulletContext);
        removeKitView();
        BulletContainerLoader bulletContainerLoader = this.bulletContainerLoader;
        BulletContext bulletContext4 = this.bulletContext;
        Intrinsics.checkNotNull(bulletContext4);
        bulletContainerLoader.loadUri(bulletContext4, uri, bundle, this);
    }

    private final void markScene() {
        Components components;
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null) {
            bulletContext.setScene(this.mCurrentScene);
        }
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.mCurrentScene.ordinal()];
        if (i == 1) {
            components = Components.Activity;
        } else if (i == 2) {
            components = Components.DialogFragment;
        } else {
            components = Components.View;
        }
        bulletContext2.setClientComponent(components);
    }

    @Override // com.bytedance.ies.bullet.service.base.IReleasable
    public void release() {
        String sessionId;
        BulletSettings provideBulletSettings;
        ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
        BulletContext bulletContext = this.bulletContext;
        contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null).removeProvider(IBulletActivityWrapper.class);
        onBulletViewRelease();
        IKitViewService iKitViewService = this.currentKitView;
        if (iKitViewService != null) {
            iKitViewService.destroy(true);
        }
        this.currentKitView = null;
        if (IConditionCallKt.enableBulletContextRelease()) {
            BulletContext bulletContext2 = this.bulletContext;
            if (bulletContext2 != null) {
                bulletContext2.release();
            }
        } else {
            BulletContext bulletContext3 = this.bulletContext;
            if (bulletContext3 != null) {
                bulletContext3.setContext(null);
            }
        }
        View.OnLayoutChangeListener onLayoutChangeListener = this.rootViewLayoutListener;
        if (onLayoutChangeListener != null) {
            View decorView = getDecorView();
            if (decorView != null) {
                decorView.removeOnLayoutChangeListener(onLayoutChangeListener);
            }
            this.rootViewLayoutListener = null;
        }
        BulletContainerManager.INSTANCE.getInstance().unBind(getMBid(), this);
        this.eventListeners = null;
        this.isReleased = true;
        BulletContext bulletContext4 = this.bulletContext;
        BulletContainerContext containerContext = bulletContext4 != null ? bulletContext4.getContainerContext() : null;
        if (containerContext != null) {
            containerContext.setRelease(true);
        }
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (!((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings.getEnableMemLeakExperiment())) {
            if (this.bulletContext != null) {
                getProviderFactory().removeAll();
                ContextProviderManager contextProviderManager2 = ContextProviderManager.INSTANCE;
                BulletContext bulletContext5 = this.bulletContext;
                contextProviderManager2.getProviderFactory(bulletContext5 != null ? bulletContext5.getSessionId() : null).removeAll();
            }
            removeManagerWithSessionId();
        } else {
            removeManagerWithSessionId();
            if (this.bulletContext != null) {
                getProviderFactory().removeProvider(IBulletContainer.class);
                getProviderFactory().removeProvider(Context.class);
            }
        }
        BulletContext bulletContext6 = this.bulletContext;
        if (bulletContext6 != null && (sessionId = bulletContext6.getSessionId()) != null) {
            SLMonitorCompat.INSTANCE.releaseMonitor(sessionId);
        }
        this.bulletContainerLoader.release();
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadStart(Uri uri, IBulletContainer container) {
        String str;
        ISchemaData schemaData;
        Intrinsics.checkNotNullParameter(uri, "uri");
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        BulletContext bulletContext = this.bulletContext;
        Map<String, ? extends Object> mapOf = MapsKt.mapOf(TuplesKt.to("url", String.valueOf((bulletContext == null || (schemaData = bulletContext.getSchemaData()) == null) ? null : schemaData.getInnerOriginUrl())));
        LoggerContext loggerContext = new LoggerContext();
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 == null || (str = bulletContext2.getSessionId()) == null) {
            str = "";
        }
        loggerContext.pushStage(XConstant.SESSION_ID, str);
        Unit unit = Unit.INSTANCE;
        hybridLogger.m11i("XView", "tridentMsg onLoadStart", mapOf, loggerContext);
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                Uri uri2 = this.uri;
                Intrinsics.checkNotNull(uri2);
                iBulletLifeCycle.onLoadStart(uri2, this);
            }
        } catch (YieldError unused) {
        }
    }

    private final void addScreenCaptureListener() {
        BulletLogger bulletLogger = BulletLogger.INSTANCE;
        String str = "onUserCaptureScreen addScreenCaptureListener， isBaseMode：" + AnnieXRuntime.INSTANCE.getApplicationDepend().isBaseMode() + "isPrivacyDialogShow：" + AnnieXRuntime.INSTANCE.getApplicationDepend().isPrivacyDialogShow();
        BulletContext bulletContext = this.bulletContext;
        bulletLogger.printTridentLog(str, (r17 & 2) != 0 ? null : null, (r17 & 4) != 0 ? LogLevel.I : null, (r17 & 8) != 0 ? "" : null, bulletContext != null ? bulletContext.getSessionId() : null, (r17 & 32) != 0 ? "" : null, (r17 & 64) != 0 ? "" : null);
        if (AnnieXRuntime.INSTANCE.getApplicationDepend().isBaseMode() || AnnieXRuntime.INSTANCE.getApplicationDepend().isPrivacyDialogShow() || this.screenCaptureListener != null) {
            return;
        }
        this.screenCaptureListener = new OnScreenCaptureListener() { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$addScreenCaptureListener$1
            @Override // com.bytedance.ies.bullet.p003ui.common.utils.OnScreenCaptureListener
            public void onCapture(int responseType) {
                BulletContext bulletContext2;
                BulletLogger bulletLogger2 = BulletLogger.INSTANCE;
                String str2 = "onUserCaptureScreen onCapture, responseType=" + responseType;
                bulletContext2 = BulletCardView.this.bulletContext;
                bulletLogger2.printTridentLog(str2, (r17 & 2) != 0 ? null : null, (r17 & 4) != 0 ? LogLevel.I : null, (r17 & 8) != 0 ? "" : null, bulletContext2 != null ? bulletContext2.getSessionId() : null, (r17 & 32) != 0 ? "" : null, (r17 & 64) != 0 ? "" : null);
                if (responseType == 0) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    final BulletCardView bulletCardView = BulletCardView.this;
                    handler.post(new Runnable() { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$addScreenCaptureListener$1$onCapture$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            BulletCardView.this.onEvent(new IEvent(BulletCardView.this) { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$addScreenCaptureListener$1$onCapture$1.1
                                private final String name;
                                private final Object params;

                                {
                                    String str3;
                                    str3 = r1.ON_USER_CAPTURE_SCREEN;
                                    this.name = str3;
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
                    });
                }
            }
        };
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$addScreenCaptureListener$2
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                OnScreenCaptureListener onScreenCaptureListener;
                ScreenCaptureUtils screenCaptureUtils = ScreenCaptureUtils.INSTANCE;
                Context applicationContext = BulletCardView.this.getContext().getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                onScreenCaptureListener = BulletCardView.this.screenCaptureListener;
                screenCaptureUtils.addScreenCaptureListener(applicationContext, onScreenCaptureListener);
            }
        });
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onKitViewCreate(Uri uri, IKitViewService kitView) {
        List<IBulletLoadLifeCycle> bulletGlobalLifeCycleListenerList;
        SchemaModelUnion schemaModelUnion;
        Integer value;
        ContextProviderFactory contextProviderFactory;
        AnnieXSourceLabel annieXSourceLabel;
        Intrinsics.checkNotNullParameter(uri, "uri");
        BulletLogger bulletLogger = BulletLogger.INSTANCE;
        BulletContext bulletContext = getBulletContext();
        BulletLogger.printCoreLog$default(bulletLogger, bulletContext != null ? bulletContext.getSessionId() : null, "kitView create kitType: " + (kitView != null ? kitView.getKitType() : null), "XView", null, 8, null);
        this.currentKitView = kitView;
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 != null) {
            bulletContext2.setViewService(kitView);
        }
        ((FrameLayout) _$_findCachedViewByID(R.id.bullet_container)).removeAllViews();
        if (IConditionCallKt.enableThirdPartyWebUi(this.bulletContext) && (contextProviderFactory = this.localContextProviderFactory) != null && (annieXSourceLabel = (AnnieXSourceLabel) contextProviderFactory.provideInstance(AnnieXSourceLabel.class)) != null) {
            annieXSourceLabel.attachToRoot$anniex_release((FrameLayout) _$_findCachedViewByID(R.id.bullet_container));
        }
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewByID(R.id.bullet_container);
        Intrinsics.checkNotNull(kitView);
        frameLayout.addView(kitView.realView());
        Configuration configuration = getContext().getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "context.resources.configuration");
        padAdaptation(kitView, configuration, true);
        BulletContext bulletContext3 = this.bulletContext;
        if (bulletContext3 != null && (schemaModelUnion = bulletContext3.getSchemaModelUnion()) != null && (value = new UIColorParam(schemaModelUnion.getSchemaData(), "content_bg_color", null).getValue()) != null) {
            int intValue = value.intValue();
            View realView = kitView.realView();
            if (realView != null) {
                realView.setBackgroundColor(intValue);
            }
        }
        this.hasKitView.set(true);
        observerRootViewLayoutChanged(uri);
        observerKitViewLayoutChanged();
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                iBulletLifeCycle.onKitViewCreate(uri, kitView);
            }
            BulletContext bulletContext4 = this.bulletContext;
            if (bulletContext4 == null || (bulletGlobalLifeCycleListenerList = bulletContext4.getBulletGlobalLifeCycleListenerList()) == null) {
                return;
            }
            Iterator<T> it = bulletGlobalLifeCycleListenerList.iterator();
            while (it.hasNext()) {
                ((IBulletLoadLifeCycle) it.next()).onKitViewCreate(uri, kitView);
            }
        } catch (YieldError unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void padAdaptation$default(BulletCardView bulletCardView, IKitViewService iKitViewService, Configuration configuration, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: padAdaptation");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        bulletCardView.padAdaptation(iKitViewService, configuration, z);
    }

    private final void padAdaptation(IKitViewService kitView, Configuration configuration, boolean isKitViewCreate) {
        ContextProviderFactory contextProviderFactory;
        AnnieXSourceLabel annieXSourceLabel;
        SchemaModelUnion schemaModelUnion;
        if (kitView == null) {
            return;
        }
        BulletContext bulletContext = this.bulletContext;
        boolean z = false;
        if (bulletContext != null && (schemaModelUnion = bulletContext.getSchemaModelUnion()) != null) {
            z = BulletPadAdapterUtil.INSTANCE.enableAdapterPad(schemaModelUnion, this.mCurrentScene, false);
        }
        if (z) {
            if (isKitViewCreate) {
                BulletPadAdapterUtil bulletPadAdapterUtil = BulletPadAdapterUtil.INSTANCE;
                BulletContext bulletContext2 = this.bulletContext;
                String bid = bulletContext2 != null ? bulletContext2.getBid() : null;
                Context context = getContext();
                BulletContext bulletContext3 = this.bulletContext;
                SchemaModelUnion schemaModelUnion2 = bulletContext3 != null ? bulletContext3.getSchemaModelUnion() : null;
                BulletContext bulletContext4 = this.bulletContext;
                bulletPadAdapterUtil.logPadAdaption(bid, context, schemaModelUnion2, bulletContext4 != null ? bulletContext4.getScene() : null, configuration, true);
            }
            BulletPadAdapterUtil bulletPadAdapterUtil2 = BulletPadAdapterUtil.INSTANCE;
            BulletContext bulletContext5 = this.bulletContext;
            String bid2 = bulletContext5 != null ? bulletContext5.getBid() : null;
            Context context2 = getContext();
            BulletContext bulletContext6 = this.bulletContext;
            SchemaModelUnion schemaModelUnion3 = bulletContext6 != null ? bulletContext6.getSchemaModelUnion() : null;
            BulletContext bulletContext7 = this.bulletContext;
            Pair<Integer, Integer> padKitViewInfo = bulletPadAdapterUtil2.getPadKitViewInfo(bid2, context2, schemaModelUnion3, bulletContext7 != null ? bulletContext7.getScene() : null, configuration, true);
            Integer num = (Integer) padKitViewInfo.component1();
            Integer num2 = (Integer) padKitViewInfo.component2();
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
                    BulletPadAdapterUtil bulletPadAdapterUtil3 = BulletPadAdapterUtil.INSTANCE;
                    BulletContext bulletContext8 = this.bulletContext;
                    ISchemaData schemaData = bulletContext8 != null ? bulletContext8.getSchemaData() : null;
                    BulletContext bulletContext9 = this.bulletContext;
                    if (!bulletPadAdapterUtil3.enablePageUniformStyle(schemaData, bulletContext9 != null ? bulletContext9.getScene() : null)) {
                        BulletPadAdapterUtil bulletPadAdapterUtil4 = BulletPadAdapterUtil.INSTANCE;
                        BulletContext bulletContext10 = this.bulletContext;
                        ISchemaData schemaData2 = bulletContext10 != null ? bulletContext10.getSchemaData() : null;
                        BulletContext bulletContext11 = this.bulletContext;
                        if (!bulletPadAdapterUtil4.enablePageChannelStyle(schemaData2, bulletContext11 != null ? bulletContext11.getScene() : null)) {
                            layoutParams2.gravity = 17;
                            realView.setLayoutParams(layoutParams2);
                            BulletLogger.printLog$default(BulletLogger.INSTANCE, "kitView set size : width=" + num + ",height=" + num2, null, null, 6, null);
                        }
                    }
                    layoutParams2.gravity = 1;
                    realView.setLayoutParams(layoutParams2);
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, "kitView set size : width=" + num + ",height=" + num2, null, null, 6, null);
                }
            }
            if (num != null && (contextProviderFactory = this.localContextProviderFactory) != null && (annieXSourceLabel = (AnnieXSourceLabel) contextProviderFactory.provideInstance(AnnieXSourceLabel.class)) != null) {
                ViewGroup.LayoutParams layoutParams3 = annieXSourceLabel.getLayoutParams();
                FrameLayout.LayoutParams layoutParams4 = layoutParams3 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams3 : null;
                if (layoutParams4 != null) {
                    layoutParams4.gravity = 1;
                    layoutParams4.width = num.intValue();
                    annieXSourceLabel.setLayoutParams(layoutParams4);
                }
            }
            this.padAdapterWidth = BulletPadAdapterUtil.INSTANCE.getPadAdapterWidth();
            this.padAdapterHeight = BulletPadAdapterUtil.INSTANCE.getPadAdapterHeight();
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "padAdaptation : current scenes=" + this.mCurrentScene.name() + ",padAdapterWidth=" + this.padAdapterWidth + ",padAdapterHeight=" + this.padAdapterHeight, null, null, 6, null);
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onKitViewDestroy(Uri uri, IKitViewService kitView, Throwable throwable) {
        String str;
        List<IBulletLoadLifeCycle> bulletGlobalLifeCycleListenerList;
        ISchemaData schemaData;
        Intrinsics.checkNotNullParameter(uri, "uri");
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        BulletContext bulletContext = this.bulletContext;
        Map<String, ? extends Object> mapOf = MapsKt.mapOf(TuplesKt.to("url", String.valueOf((bulletContext == null || (schemaData = bulletContext.getSchemaData()) == null) ? null : schemaData.getInnerOriginUrl())));
        LoggerContext loggerContext = new LoggerContext();
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 == null || (str = bulletContext2.getSessionId()) == null) {
            str = "";
        }
        loggerContext.pushStage(XConstant.SESSION_ID, str);
        Unit unit = Unit.INSTANCE;
        hybridLogger.m11i("XView", "tridentMsg onKitViewDestroy", mapOf, loggerContext);
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                iBulletLifeCycle.onKitViewDestroy(uri, kitView, throwable);
            }
            BulletContext bulletContext3 = this.bulletContext;
            if (bulletContext3 != null && (bulletGlobalLifeCycleListenerList = bulletContext3.getBulletGlobalLifeCycleListenerList()) != null) {
                Iterator<T> it = bulletGlobalLifeCycleListenerList.iterator();
                while (it.hasNext()) {
                    ((IBulletLoadLifeCycle) it.next()).onKitViewDestroy(uri, kitView, throwable);
                }
            }
        } catch (YieldError unused) {
        }
        this.isJsRuntimeReady.getAndSet(false);
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadUriSuccess(Uri uri, IKitViewService kitView) {
        List<IBulletLoadLifeCycle> bulletGlobalLifeCycleListenerList;
        Intrinsics.checkNotNullParameter(uri, "uri");
        sendWindowSizeEvent();
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                iBulletLifeCycle.onLoadUriSuccess(uri, kitView);
            }
            BulletContext bulletContext = this.bulletContext;
            if (bulletContext != null && (bulletGlobalLifeCycleListenerList = bulletContext.getBulletGlobalLifeCycleListenerList()) != null) {
                Iterator<T> it = bulletGlobalLifeCycleListenerList.iterator();
                while (it.hasNext()) {
                    ((IBulletLoadLifeCycle) it.next()).onLoadUriSuccess(uri, kitView);
                }
            }
        } catch (YieldError unused) {
        }
        this.loadStatus.getAndSet(LoadStatus.SUCCESS.ordinal());
        addTagView();
        BulletLifeCycleManager.INSTANCE.dispatchOnLoadUriSuccess(uri, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.bytedance.ies.bullet.ui.common.DebugTagTextView] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    private final void addTagView() {
        BulletContainerContext containerContext;
        Scenes scene;
        DebugInfo debugInfo = DebugConfig.INSTANCE.get(getMBid());
        this.debugInfo = debugInfo;
        if (debugInfo != null) {
            if (!(BulletEnv.INSTANCE.getInstance().getDebuggable() && BulletEnv.INSTANCE.getInstance().getShowTag() && debugInfo.getShowDebugTagView())) {
                debugInfo = null;
            }
            if (debugInfo != null) {
                int childCount = getChildCount();
                int i = 1;
                View view = 0;
                while (i < childCount) {
                    Object childAt = getChildAt(i);
                    view = view;
                    if (childAt != null) {
                        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                        view = childAt instanceof DebugTagTextView ? (DebugTagTextView) childAt : null;
                    }
                    if (view != 0) {
                        break;
                    }
                    i++;
                    view = view;
                }
                if (view == 0) {
                    Object inflate = LayoutInflater.from(getContext()).inflate(R.layout.bullet_debug_tag_view, (ViewGroup) null);
                    view = inflate instanceof DebugTagTextView ? (DebugTagTextView) inflate : 0;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 8388691;
                    int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.bullet_debug_tab_view_margin);
                    layoutParams.leftMargin = dimensionPixelSize;
                    layoutParams.bottomMargin = dimensionPixelSize;
                    addView(view, layoutParams);
                }
                if (view != 0) {
                    BulletContext bulletContext = this.bulletContext;
                    String tag = (bulletContext == null || (scene = bulletContext.getScene()) == null) ? null : scene.getTag();
                    String debugTagPrefix = debugInfo.getDebugTagPrefix();
                    String str = debugTagPrefix == null || debugTagPrefix.length() == 0 ? "" : debugInfo.getDebugTagPrefix() + " - ";
                    BulletContext bulletContext2 = this.bulletContext;
                    String provideSuffix = IPreRenderServiceKt.provideSuffix((bulletContext2 == null || (containerContext = bulletContext2.getContainerContext()) == null) ? null : containerContext.getCacheType());
                    StringBuilder append = new StringBuilder().append(tag).append('_').append(str);
                    IKitViewService iKitViewService = this.currentKitView;
                    view.setText(append.append(iKitViewService != null ? iKitViewService.getViewTag() : null).append(provideSuffix).toString());
                    final Function1<View, Unit> onTagClickListener = BulletEnv.INSTANCE.getInstance().getOnTagClickListener();
                    if (onTagClickListener != null) {
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$addTagView$2$2$1$1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                IKitViewService iKitViewService2;
                                Function1<View, Unit> function1 = onTagClickListener;
                                iKitViewService2 = this.currentKitView;
                                function1.invoke(iKitViewService2 != null ? iKitViewService2.realView() : null);
                            }
                        });
                    }
                }
            }
        }
    }

    private final void removeScreenCaptureListener() {
        BulletLogger bulletLogger = BulletLogger.INSTANCE;
        BulletContext bulletContext = this.bulletContext;
        bulletLogger.printTridentLog("onUserCaptureScreen removeScreenCaptureListener", (r17 & 2) != 0 ? null : null, (r17 & 4) != 0 ? LogLevel.I : null, (r17 & 8) != 0 ? "" : null, bulletContext != null ? bulletContext.getSessionId() : null, (r17 & 32) != 0 ? "" : null, (r17 & 64) != 0 ? "" : null);
        final OnScreenCaptureListener onScreenCaptureListener = this.screenCaptureListener;
        if (onScreenCaptureListener != null) {
            Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$removeScreenCaptureListener$1
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    ScreenCaptureUtils screenCaptureUtils = ScreenCaptureUtils.INSTANCE;
                    Context applicationContext = BulletCardView.this.getContext().getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                    screenCaptureUtils.removeScreenCaptureListener(applicationContext, onScreenCaptureListener);
                }
            });
            this.screenCaptureListener = null;
        }
    }

    public final void addEventListener(IEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.eventListeners == null) {
            this.eventListeners = new ArrayList();
        }
        List<IEventListener> list = this.eventListeners;
        if (list != null) {
            list.add(listener);
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void onEvent(IEvent event) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        IKitViewService iKitViewService = this.currentKitView;
        if (iKitViewService != null) {
            iKitViewService.sendEvent(event.getName(), event.getParams());
        }
        List<IEventListener> list = this.eventListeners;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((IEventListener) it.next()).onCallBack(event);
            }
        }
    }

    @Deprecated(message = "unused, to be deleted")
    public final void setSessionId(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext == null) {
            return;
        }
        bulletContext.setSessionId(id);
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public String getSessionId() {
        String str;
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext == null || (str = bulletContext.getSessionId()) == null) {
            str = "";
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "getSessionId:" + str, null, "XView", 2, null);
        return str;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public <T extends ISchemaModel> SchemaModelUnion getSchemaModelUnionBeforeLoad(Uri uri, Bundle bundle, Class<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (uri == null) {
            return null;
        }
        if (bundle != null) {
            SchemaConfig schemaConfig = new SchemaConfig();
            schemaConfig.addInterceptor(new BundleInterceptor(bundle));
            SchemaService.INSTANCE.getInstance().bindConfig(uri, schemaConfig);
        }
        return new SchemaModelUnion(SchemaService.INSTANCE.getInstance().generateSchemaData(this.mBid, uri));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        AbsBulletMonitorCallback monitorCallback;
        AbsBulletMonitorCallback monitorCallback2;
        super.onAttachedToWindow();
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null && (monitorCallback2 = bulletContext.getMonitorCallback()) != null) {
            Uri uri = this.uri;
            monitorCallback2.onViewAttached(uri != null ? uri.getPath() : null);
        }
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 != null && (monitorCallback = bulletContext2.getMonitorCallback()) != null) {
            monitorCallback.onBulletViewAttached(this);
        }
        if (this.bulletContext != null) {
            BulletContextManager companion = BulletContextManager.INSTANCE.getInstance();
            BulletContext bulletContext3 = this.bulletContext;
            Intrinsics.checkNotNull(bulletContext3);
            companion.addContext(bulletContext3);
            ContextProviderManager.INSTANCE.register(getSessionId(), this.localContextProviderFactory);
        }
        IBulletActivityWrapper activityWrapper = getActivityWrapper();
        if (activityWrapper != null) {
            activityWrapper.registerDelegate(this.bulletActivityDelegate);
        }
        BulletContainerManager.INSTANCE.getInstance().bind(getMBid(), this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AbsBulletMonitorCallback monitorCallback;
        super.onDetachedFromWindow();
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null && (monitorCallback = bulletContext.getMonitorCallback()) != null) {
            monitorCallback.onBulletViewDetached();
        }
        IBulletActivityWrapper activityWrapper = getActivityWrapper();
        if (activityWrapper != null) {
            activityWrapper.unregisterDelegate(this.bulletActivityDelegate);
        }
        BulletContainerManager.INSTANCE.getInstance().unBind(getMBid(), this);
        if (this.isAutoReleasableWhenDetached) {
            release();
        }
        removeManagerWithSessionId();
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void reload(ContextProviderFactory contextProviderFactory, IBulletLifeCycle lifeCycle) {
        String sessionId;
        BulletSettings provideBulletSettings;
        if (this.uri == null || lifeCycle == null) {
            return;
        }
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService != null && (provideBulletSettings = iSettingService.provideBulletSettings()) != null) {
            provideBulletSettings.setReloadWithReset(false);
            if (contextProviderFactory != null) {
                contextProviderFactory.registerHolder(BulletSettings.class, provideBulletSettings);
            }
        }
        addLifeCycleListener(lifeCycle);
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                Uri uri = this.uri;
                Intrinsics.checkNotNull(uri);
                iBulletLifeCycle.onLoadStart(uri, this);
            }
        } catch (YieldError unused) {
        }
        if (contextProviderFactory != null) {
            ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
            BulletContext bulletContext = this.bulletContext;
            contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null).merge(contextProviderFactory);
        }
        BulletContextManager companion = BulletContextManager.INSTANCE.getInstance();
        BulletContext bulletContext2 = this.bulletContext;
        Intrinsics.checkNotNull(bulletContext2);
        BulletContext context = companion.getContext(bulletContext2.getSessionId());
        if (context != null && !Intrinsics.areEqual(context, this.bulletContext)) {
            this.bulletContext = context;
        }
        BulletContext bulletContext3 = this.bulletContext;
        BulletLynxContext lynxContext = bulletContext3 != null ? bulletContext3.getLynxContext() : null;
        if (lynxContext != null) {
            lynxContext.setInitDataWrapper(contextProviderFactory != null ? (LynxInitDataWrapper) contextProviderFactory.provideInstance(LynxInitDataWrapper.class) : null);
        }
        IKitViewService iKitViewService = this.currentKitView;
        Intrinsics.checkNotNull(iKitViewService);
        iKitViewService.reload();
        BulletContext bulletContext4 = this.bulletContext;
        if (bulletContext4 == null || (sessionId = bulletContext4.getSessionId()) == null) {
            return;
        }
        SLMonitorCompat.reportReusePV$default(SLMonitorCompat.INSTANCE, sessionId, (String) null, (String) null, 6, (Object) null);
    }

    public final void reloadWithReset(ContextProviderFactory contextProviderFactory, IBulletLifeCycle lifeCycle) {
        BulletSettings provideBulletSettings;
        BulletSettings provideBulletSettings2;
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "reload with reset " + this.uri, null, "XView", 2, null);
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService != null && (provideBulletSettings2 = iSettingService.provideBulletSettings()) != null) {
            provideBulletSettings2.setReloadWithReset(false);
            if (contextProviderFactory != null) {
                contextProviderFactory.registerHolder(BulletSettings.class, provideBulletSettings2);
            }
        }
        addLifeCycleListener(lifeCycle);
        ISettingService iSettingService2 = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService2 != null && (provideBulletSettings = iSettingService2.provideBulletSettings()) != null) {
            provideBulletSettings.setReloadWithReset(true);
            if (contextProviderFactory != null) {
                contextProviderFactory.registerHolder(BulletSettings.class, provideBulletSettings);
            }
        }
        if (contextProviderFactory != null) {
            ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
            BulletContext bulletContext = this.bulletContext;
            contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null).merge(contextProviderFactory);
        }
        BulletContextManager companion = BulletContextManager.INSTANCE.getInstance();
        BulletContext bulletContext2 = this.bulletContext;
        Intrinsics.checkNotNull(bulletContext2);
        BulletContext context = companion.getContext(bulletContext2.getSessionId());
        if (context != null && !Intrinsics.areEqual(context, this.bulletContext)) {
            this.bulletContext = context;
        }
        BulletContext bulletContext3 = this.bulletContext;
        BulletLynxContext lynxContext = bulletContext3 != null ? bulletContext3.getLynxContext() : null;
        if (lynxContext != null) {
            lynxContext.setInitDataWrapper(contextProviderFactory != null ? (LynxInitDataWrapper) contextProviderFactory.provideInstance(LynxInitDataWrapper.class) : null);
        }
        IKitViewService iKitViewService = this.currentKitView;
        if (iKitViewService instanceof ILynxKitViewService) {
            Intrinsics.checkNotNull(iKitViewService, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService");
            ((ILynxKitViewService) iKitViewService).resetData();
        }
    }

    public static /* synthetic */ void reloadTemplate$default(BulletCardView bulletCardView, ContextProviderFactory contextProviderFactory, IBulletLifeCycle iBulletLifeCycle, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reloadTemplate");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        bulletCardView.reloadTemplate(contextProviderFactory, iBulletLifeCycle, z);
    }

    public final void reloadTemplate(ContextProviderFactory contextProviderFactory, IBulletLifeCycle lifeCycle, boolean withGlobalProps) {
        String sessionId;
        BulletSettings provideBulletSettings;
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "reloadTemplate " + this.uri, null, "XView", 2, null);
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService != null && (provideBulletSettings = iSettingService.provideBulletSettings()) != null) {
            provideBulletSettings.setReloadWithReset(false);
            if (contextProviderFactory != null) {
                contextProviderFactory.registerHolder(BulletSettings.class, provideBulletSettings);
            }
        }
        addLifeCycleListener(lifeCycle);
        if (contextProviderFactory != null) {
            ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
            BulletContext bulletContext = this.bulletContext;
            contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null).merge(contextProviderFactory);
            if (IConditionCallKt.enableReloadContextMerge()) {
                HybridLogger.i$default(HybridLogger.INSTANCE, "XView", "merge context when reload", null, null, 12, null);
                ContextProviderFactory contextProviderFactory2 = this.localContextProviderFactory;
                if (contextProviderFactory2 != null) {
                    contextProviderFactory2.merge(contextProviderFactory);
                }
            }
        }
        BulletContextManager companion = BulletContextManager.INSTANCE.getInstance();
        BulletContext bulletContext2 = this.bulletContext;
        Intrinsics.checkNotNull(bulletContext2);
        BulletContext context = companion.getContext(bulletContext2.getSessionId());
        if (context != null && !Intrinsics.areEqual(context, this.bulletContext)) {
            this.bulletContext = context;
        }
        BulletContext bulletContext3 = this.bulletContext;
        BulletLynxContext lynxContext = bulletContext3 != null ? bulletContext3.getLynxContext() : null;
        if (lynxContext != null) {
            lynxContext.setInitDataWrapper(contextProviderFactory != null ? (LynxInitDataWrapper) contextProviderFactory.provideInstance(LynxInitDataWrapper.class) : null);
        }
        IKitViewService iKitViewService = this.currentKitView;
        if (iKitViewService instanceof ILynxKitViewService) {
            Intrinsics.checkNotNull(iKitViewService, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService");
            ILynxKitViewService iLynxKitViewService = (ILynxKitViewService) iKitViewService;
            if (withGlobalProps) {
                iLynxKitViewService.reloadTemplateWithGlobalProps();
            } else {
                iLynxKitViewService.reloadTemplate();
            }
            BulletContext bulletContext4 = this.bulletContext;
            if (bulletContext4 == null || (sessionId = bulletContext4.getSessionId()) == null) {
                return;
            }
            SLMonitorCompat.reportReusePV$default(SLMonitorCompat.INSTANCE, sessionId, (String) null, (String) null, 6, (Object) null);
        }
    }

    public final void reloadTemplateWithGlobalProps(ContextProviderFactory contextProviderFactory, IBulletLifeCycle lifeCycle, Map<String, ? extends Object> globalProps) {
        String sessionId;
        BulletSettings provideBulletSettings;
        Intrinsics.checkNotNullParameter(globalProps, "globalProps");
        HybridLogger.i$default(HybridLogger.INSTANCE, "XView", "reloadTemplateWithGlobalProps " + this.uri, null, null, 12, null);
        ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
        if (iSettingService != null && (provideBulletSettings = iSettingService.provideBulletSettings()) != null) {
            provideBulletSettings.setReloadWithReset(false);
            if (contextProviderFactory != null) {
                contextProviderFactory.registerHolder(BulletSettings.class, provideBulletSettings);
            }
        }
        addLifeCycleListener(lifeCycle);
        if (contextProviderFactory != null) {
            ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
            BulletContext bulletContext = this.bulletContext;
            contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null).merge(contextProviderFactory);
            if (IConditionCallKt.enableReloadContextMerge()) {
                HybridLogger.i$default(HybridLogger.INSTANCE, "XView", "merge context when reload", null, null, 12, null);
                ContextProviderFactory contextProviderFactory2 = this.localContextProviderFactory;
                if (contextProviderFactory2 != null) {
                    contextProviderFactory2.merge(contextProviderFactory);
                }
            }
        }
        BulletContextManager companion = BulletContextManager.INSTANCE.getInstance();
        BulletContext bulletContext2 = this.bulletContext;
        Intrinsics.checkNotNull(bulletContext2);
        BulletContext context = companion.getContext(bulletContext2.getSessionId());
        if (context != null && !Intrinsics.areEqual(context, this.bulletContext)) {
            this.bulletContext = context;
        }
        BulletContext bulletContext3 = this.bulletContext;
        BulletLynxContext lynxContext = bulletContext3 != null ? bulletContext3.getLynxContext() : null;
        if (lynxContext != null) {
            lynxContext.setInitDataWrapper(contextProviderFactory != null ? (LynxInitDataWrapper) contextProviderFactory.provideInstance(LynxInitDataWrapper.class) : null);
        }
        IKitViewService iKitViewService = this.currentKitView;
        ILynxKitViewService iLynxKitViewService = iKitViewService instanceof ILynxKitViewService ? (ILynxKitViewService) iKitViewService : null;
        if (iLynxKitViewService != null) {
            iLynxKitViewService.reloadTemplateWithGlobalProps(globalProps);
        }
        BulletContext bulletContext4 = this.bulletContext;
        if (bulletContext4 == null || (sessionId = bulletContext4.getSessionId()) == null) {
            return;
        }
        SLMonitorCompat.reportReusePV$default(SLMonitorCompat.INSTANCE, sessionId, (String) null, (String) null, 6, (Object) null);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        SchemaModelUnion schemaModelUnion;
        SchemaModelUnion schemaModelUnion2;
        super.onConfigurationChanged(newConfig);
        if (newConfig == null) {
            return;
        }
        if (getActivityWrapper() == null) {
            BulletContext bulletContext = this.bulletContext;
            if ((bulletContext == null || (schemaModelUnion2 = bulletContext.getSchemaModelUnion()) == null || !BulletPadAdapterUtil.INSTANCE.enableAdapterPad(schemaModelUnion2, this.mCurrentScene, false)) ? false : true) {
                BulletPadAdapterUtil bulletPadAdapterUtil = BulletPadAdapterUtil.INSTANCE;
                BulletContext bulletContext2 = this.bulletContext;
                if (bulletPadAdapterUtil.enablePageChannelStyle((bulletContext2 == null || (schemaModelUnion = bulletContext2.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getSchemaData(), this.mCurrentScene)) {
                    padAdaptation$default(this, this.currentKitView, newConfig, false, 4, null);
                }
            }
        }
        if (!this.changeOrientationEventToLayoutChange) {
            sendOrientationEvent$default(this, newConfig.orientation, null, 2, null);
        }
        sendWindowSizeEvent();
        BulletContext bulletContext3 = this.bulletContext;
        if (bulletContext3 != null && bulletContext3.getIgnoreOrientationChanged()) {
            return;
        }
        updateLynxScreenMetrics();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void sendOrientationEvent$default(BulletCardView bulletCardView, int i, Map map, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendOrientationEvent");
        }
        if ((i2 & 2) != 0) {
            map = null;
        }
        bulletCardView.sendOrientationEvent(i, map);
    }

    private final void sendOrientationEvent(int orientation, final Map<String, ? extends Object> screenProps) {
        final Orientation orientation2;
        Orientation[] values = Orientation.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                orientation2 = null;
                break;
            }
            orientation2 = values[i];
            if (orientation2.ordinal() == orientation) {
                break;
            } else {
                i++;
            }
        }
        if (orientation2 == null) {
            orientation2 = Orientation.UNKNOWN;
        }
        if (orientation2 != this.lastOrientation) {
            onEvent(new IEvent(screenProps, orientation2, this) { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$sendOrientationEvent$1
                private final String name = "screenOrientationChange";
                private final Object params;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    Integer num;
                    Integer num2;
                    JSONObject jSONObject = screenProps != null ? new JSONObject(screenProps) : new JSONObject();
                    String name = orientation2.name();
                    Locale locale = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                    if (name == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase = name.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    jSONObject.put("screenOrientation", lowerCase);
                    ViewUtil viewUtil = ViewUtil.INSTANCE;
                    Context context = this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    if (viewUtil.getScreenInfo(context) != null) {
                        int px2dip = UIUtils.px2dip(this.getContext(), r6.getHeight());
                        int px2dip2 = UIUtils.px2dip(this.getContext(), r6.getWidth());
                        if (orientation2 == Orientation.LANDSCAPE) {
                            jSONObject.put("screenHeight", Math.min(px2dip2, px2dip));
                            jSONObject.put("screenWidth", Math.max(px2dip2, px2dip));
                        } else {
                            jSONObject.put("screenHeight", Math.max(px2dip2, px2dip));
                            jSONObject.put("screenWidth", Math.min(px2dip2, px2dip));
                        }
                        num = this.padAdapterHeight;
                        jSONObject.put("kitViewHeight", num != null ? Integer.valueOf(UIUtils.px2dip(this.getContext(), num.intValue())) : null);
                        num2 = this.padAdapterWidth;
                        jSONObject.put("kitViewWidth", num2 != null ? Integer.valueOf(UIUtils.px2dip(this.getContext(), num2.intValue())) : null);
                    }
                    this.params = jSONObject;
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
            this.lastOrientation = orientation2;
        }
    }

    private final void sendWindowSizeEvent() {
        if ((AnnieXRuntime.INSTANCE.getDeviceDepend().isFold() || AnnieXRuntime.INSTANCE.getDeviceDepend().isPad()) && this.mCurrentScene != Scenes.PopupFragment) {
            final Ref.IntRef intRef = new Ref.IntRef();
            final Ref.IntRef intRef2 = new Ref.IntRef();
            if (Build.VERSION.SDK_INT >= 30) {
                ContextUtil contextUtil = ContextUtil.INSTANCE;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Activity ownerActivity = contextUtil.getOwnerActivity(context);
                Display display = ownerActivity != null ? ownerActivity.getDisplay() : null;
                if (display != null) {
                    intRef2.element = display.getMode().getPhysicalHeight();
                    intRef.element = display.getMode().getPhysicalWidth();
                }
            } else {
                ViewUtil viewUtil = ViewUtil.INSTANCE;
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                ScreenInfo screenInfo = viewUtil.getScreenInfo(context2);
                if (screenInfo != null) {
                    intRef.element = screenInfo.getWidth();
                    intRef2.element = screenInfo.getHeight();
                }
            }
            try {
                Result.Companion companion = Result.Companion;
                onEvent(new IEvent(this, intRef, intRef2) { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$sendWindowSizeEvent$1$1
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
                            jSONObject.put("screenHeight", UIUtils.px2dip(this.getContext(), Math.min(intRef.element, intRef2.element)));
                            jSONObject.put("screenWidth", UIUtils.px2dip(this.getContext(), Math.max(intRef.element, intRef2.element)));
                        } else {
                            jSONObject.put("screenHeight", UIUtils.px2dip(this.getContext(), Math.max(intRef.element, intRef2.element)));
                            jSONObject.put("screenWidth", UIUtils.px2dip(this.getContext(), Math.min(intRef.element, intRef2.element)));
                        }
                        num = this.padAdapterHeight;
                        if (num != null) {
                            i = UIUtils.px2dip(this.getContext(), num.intValue());
                        } else {
                            i = this.getContext().getResources().getConfiguration().screenHeightDp;
                        }
                        jSONObject.put(GlobalPropertiesConstants.CONTENT_HEIGHT, i);
                        num2 = this.padAdapterWidth;
                        if (num2 != null) {
                            i2 = UIUtils.px2dip(this.getContext(), num2.intValue());
                        } else {
                            i2 = this.getContext().getResources().getConfiguration().screenWidthDp;
                        }
                        jSONObject.put(GlobalPropertiesConstants.CONTENT_WIDTH, i2);
                        this.params = jSONObject;
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
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
    }

    private final void updateLynxScreenMetrics() {
        SchemaModelUnion schemaModelUnion;
        IKitViewService currentKitView = getCurrentKitView();
        if (currentKitView != null) {
            Boolean bool = null;
            ILynxKitViewService iLynxKitViewService = currentKitView instanceof ILynxKitViewService ? (ILynxKitViewService) currentKitView : null;
            if (iLynxKitViewService != null) {
                BulletContext bulletContext = this.bulletContext;
                if (bulletContext != null && (schemaModelUnion = bulletContext.getSchemaModelUnion()) != null) {
                    bool = Boolean.valueOf(BulletPadAdapterUtil.INSTANCE.enableAdapterPad(schemaModelUnion, this.mCurrentScene, false));
                }
                Integer num = this.padAdapterWidth;
                Integer num2 = this.padAdapterHeight;
                if (Intrinsics.areEqual(bool, true) && num != null && num2 != null) {
                    iLynxKitViewService.updateScreenMetrics(num.intValue(), num2.intValue());
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletCardView updateLynxScreenMetrics : enableIpadAdapter " + bool + " , width " + num + " , height " + num2, null, null, 6, null);
                    return;
                }
                ViewUtil viewUtil = ViewUtil.INSTANCE;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                ScreenInfo screenInfo = viewUtil.getScreenInfo(context);
                if (screenInfo != null) {
                    iLynxKitViewService.updateScreenMetrics(screenInfo.getWidth(), screenInfo.getHeight());
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletCardView updateLynxScreenMetrics : enableIpadAdapter " + bool + " , width " + screenInfo.getWidth() + " , height " + screenInfo.getHeight(), null, null, 6, null);
                }
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void onEnterBackground() {
        List<IBulletLoadLifeCycle> bulletGlobalLifeCycleListenerList;
        IBulletContainer.DefaultImpls.onEnterBackground(this);
        BulletContext bulletContext = this.bulletContext;
        BulletContainerContext containerContext = bulletContext != null ? bulletContext.getContainerContext() : null;
        if (containerContext != null) {
            containerContext.setVisibleState("0");
        }
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                IBulletLifeCycle iBulletLifeCycle2 = iBulletLifeCycle;
                if (iBulletLifeCycle2 instanceof IBulletLifeCycleV2) {
                    ((IBulletLifeCycleV2) iBulletLifeCycle2).onEnterBackground(this.uri, this.currentKitView);
                }
            }
            BulletContext bulletContext2 = this.bulletContext;
            if (bulletContext2 != null && (bulletGlobalLifeCycleListenerList = bulletContext2.getBulletGlobalLifeCycleListenerList()) != null) {
                for (IBulletLoadLifeCycle iBulletLoadLifeCycle : bulletGlobalLifeCycleListenerList) {
                    if (iBulletLoadLifeCycle instanceof IBulletLifeCycleV2) {
                        ((IBulletLifeCycleV2) iBulletLoadLifeCycle).onEnterBackground(this.uri, this.currentKitView);
                    }
                }
            }
        } catch (YieldError unused) {
        }
        IBulletEventInterceptor iBulletEventInterceptor = this.eventInterceptor;
        boolean z = false;
        if (iBulletEventInterceptor != null && iBulletEventInterceptor.shouldInterceptForegroundEvent()) {
            z = true;
        }
        if (z) {
            BulletLogger bulletLogger = BulletLogger.INSTANCE;
            BulletContext bulletContext3 = this.bulletContext;
            bulletLogger.printCoreLog(bulletContext3 != null ? bulletContext3.getSessionId() : null, "onEnterBackground is intercepted", "XView", LogLevel.W);
            return;
        }
        BulletLogger bulletLogger2 = BulletLogger.INSTANCE;
        BulletContext bulletContext4 = this.bulletContext;
        BulletLogger.printCoreLog$default(bulletLogger2, bulletContext4 != null ? bulletContext4.getSessionId() : null, "onEnterBackground", "XView", null, 8, null);
        IKitViewService iKitViewService = this.currentKitView;
        if (iKitViewService != null) {
            iKitViewService.onHide();
        }
        ScreenCaptureUtils.INSTANCE.setIsAppInBackground(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0076, code lost:
    
        if (r0.shouldInterceptBackgroundEvent() == true) goto L32;
     */
    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onEnterForeground() {
        List<IBulletLoadLifeCycle> bulletGlobalLifeCycleListenerList;
        IBulletContainer.DefaultImpls.onEnterForeground(this);
        BulletContext bulletContext = this.bulletContext;
        BulletContainerContext containerContext = bulletContext != null ? bulletContext.getContainerContext() : null;
        if (containerContext != null) {
            containerContext.setVisibleState("1");
        }
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                IBulletLifeCycle iBulletLifeCycle2 = iBulletLifeCycle;
                if (iBulletLifeCycle2 instanceof IBulletLifeCycleV2) {
                    ((IBulletLifeCycleV2) iBulletLifeCycle2).onEnterForeground(this.uri, this.currentKitView);
                }
            }
            BulletContext bulletContext2 = this.bulletContext;
            if (bulletContext2 != null && (bulletGlobalLifeCycleListenerList = bulletContext2.getBulletGlobalLifeCycleListenerList()) != null) {
                for (IBulletLoadLifeCycle iBulletLoadLifeCycle : bulletGlobalLifeCycleListenerList) {
                    if (iBulletLoadLifeCycle instanceof IBulletLifeCycleV2) {
                        ((IBulletLifeCycleV2) iBulletLoadLifeCycle).onEnterForeground(this.uri, this.currentKitView);
                    }
                }
            }
        } catch (YieldError unused) {
        }
        IBulletEventInterceptor iBulletEventInterceptor = this.eventInterceptor;
        boolean z = iBulletEventInterceptor != null;
        if (z) {
            BulletLogger bulletLogger = BulletLogger.INSTANCE;
            BulletContext bulletContext3 = this.bulletContext;
            bulletLogger.printCoreLog(bulletContext3 != null ? bulletContext3.getSessionId() : null, "onEnterForeground is intercepted", "XView", LogLevel.W);
            return;
        }
        BulletLogger bulletLogger2 = BulletLogger.INSTANCE;
        BulletContext bulletContext4 = this.bulletContext;
        BulletLogger.printCoreLog$default(bulletLogger2, bulletContext4 != null ? bulletContext4.getSessionId() : null, "onEnterForeground", "XView", null, 8, null);
        IKitViewService iKitViewService = this.currentKitView;
        if (iKitViewService != null) {
            iKitViewService.onShow();
        }
        ScreenCaptureUtils.INSTANCE.setIsAppInBackground(false);
    }

    public final void onPopupDestroy$anniex_release() {
        dealWithAction(KitActionType.Closed);
        IKitViewService iKitViewService = this.currentKitView;
        if (iKitViewService != null) {
            iKitViewService.destroy(true);
        }
        this.currentKitView = null;
        this.bulletContainerLoader.release();
    }

    public final void onFetchFromPreRenderPool() {
        IBulletLifeCycle poolBulletLifeCycle = getPoolBulletLifeCycle();
        PoolBulletLifeCycle poolBulletLifeCycle2 = poolBulletLifeCycle instanceof PoolBulletLifeCycle ? (PoolBulletLifeCycle) poolBulletLifeCycle : null;
        if (poolBulletLifeCycle2 != null) {
            if (poolBulletLifeCycle2.getHasCallback().get()) {
                removePoolBulletLifeCycle();
            }
            poolBulletLifeCycle2.onFetchFromPreRenderPool(this.lifeCycleListeners);
        }
    }

    public final IBulletLifeCycle getPoolBulletLifeCycle() {
        Iterator<IBulletLifeCycle> it = this.lifeCycleListeners.iterator();
        while (it.hasNext()) {
            IBulletLifeCycle next = it.next();
            if (next instanceof PoolBulletLifeCycle) {
                return next;
            }
        }
        return null;
    }

    public final void removePoolBulletLifeCycle() {
        IBulletLifeCycle poolBulletLifeCycle = getPoolBulletLifeCycle();
        PoolBulletLifeCycle poolBulletLifeCycle2 = poolBulletLifeCycle instanceof PoolBulletLifeCycle ? (PoolBulletLifeCycle) poolBulletLifeCycle : null;
        if (poolBulletLifeCycle2 != null) {
            removeLifeCycleListener(poolBulletLifeCycle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealWithAction(KitActionType action) {
        List<MiddlewareEvent> list = this.middlewareEvents;
        ArrayList<MiddlewareEvent> arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((MiddlewareEvent) obj).getActionType(), action.getActionType())) {
                arrayList.add(obj);
            }
        }
        for (MiddlewareEvent middlewareEvent : arrayList) {
            BulletContext bulletContext = this.bulletContext;
            middlewareEvent.onEvent(bulletContext != null ? bulletContext.getBridgeRegistry() : null);
        }
        this.middlewareEvents.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void removeKitView() {
        Object obj;
        Throwable th;
        IKitViewService iKitViewService;
        Unit unit;
        View realView;
        if (!this.hasKitView.get()) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "kit view has been removed: " + this.uri, null, "XView", 2, null);
            return;
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "remove kit view: " + this.uri, null, "XView", 2, null);
        try {
            Result.Companion companion = Result.Companion;
            IKitViewService iKitViewService2 = this.currentKitView;
            if (iKitViewService2 != null) {
                iKitViewService2.destroy(true);
            }
            iKitViewService = this.currentKitView;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        if (iKitViewService != null && (realView = iKitViewService.realView()) != null) {
            ViewParent parent = realView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(realView);
                unit = Unit.INSTANCE;
                obj = Result.constructor-impl(unit);
                th = Result.exceptionOrNull-impl(obj);
                if (th != null) {
                    BulletLogger.INSTANCE.printReject(th, "remove kit view for " + this.uri + " failed.", "XView");
                }
                this.currentKitView = null;
                this.bulletContainerLoader.release();
                if (IConditionCallKt.fixLynxKitViewLeak()) {
                    BulletContext bulletContext = this.bulletContext;
                    if (bulletContext != null) {
                        bulletContext.setViewService(null);
                    }
                    BulletContext bulletContext2 = this.bulletContext;
                    if (bulletContext2 != null) {
                        bulletContext2.setBridgeRegistry(null);
                    }
                    BulletContext bulletContext3 = this.bulletContext;
                    if (bulletContext3 != null) {
                        bulletContext3.setBridge3Registry(null);
                    }
                }
                this.hasKitView.set(false);
            }
        }
        unit = null;
        obj = Result.constructor-impl(unit);
        th = Result.exceptionOrNull-impl(obj);
        if (th != null) {
        }
        this.currentKitView = null;
        this.bulletContainerLoader.release();
        if (IConditionCallKt.fixLynxKitViewLeak()) {
        }
        this.hasKitView.set(false);
    }

    public final boolean hasKitView() {
        return this.hasKitView.get();
    }

    public final boolean isLoadSuccess() {
        return this.loadStatus.get() == LoadStatus.SUCCESS.ordinal();
    }

    public final boolean isLoadFail() {
        return this.loadStatus.get() == LoadStatus.FAIL.ordinal();
    }

    public final boolean isLoading() {
        return this.loadStatus.get() == LoadStatus.LOADING.ordinal();
    }

    public View _$_findCachedViewByID(int id) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new LinkedHashMap();
        }
        View view = this._$_findViewCache.get(Integer.valueOf(id));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(id);
        if (findViewById == null) {
            return null;
        }
        this._$_findViewCache.put(Integer.valueOf(id), findViewById);
        return findViewById;
    }

    private final void observerRootViewLayoutChanged(Uri uri) {
        Configuration configuration;
        if ((this.mCurrentScene == Scenes.PopupFragment || this.mCurrentScene == Scenes.AbsActivity) && getDecorView() != null) {
            final Ref.IntRef intRef = new Ref.IntRef();
            View decorView = getDecorView();
            int i = 0;
            intRef.element = decorView != null ? decorView.getWidth() : 0;
            final Ref.IntRef intRef2 = new Ref.IntRef();
            View decorView2 = getDecorView();
            intRef2.element = decorView2 != null ? decorView2.getHeight() : 0;
            this.changeOrientationEventToLayoutChange = IConditionCallKt.enableOrientationOnLayoutChange(uri);
            if (AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) {
                this.foldStatus = AnnieXRuntime.INSTANCE.getDeviceDepend().getFoldStatus();
            }
            BulletDeviceUtils bulletDeviceUtils = BulletDeviceUtils.INSTANCE;
            BulletContext bulletContext = this.bulletContext;
            Context context = bulletContext != null ? bulletContext.getContext() : null;
            Resources resources = getContext().getResources();
            if (resources != null && (configuration = resources.getConfiguration()) != null) {
                i = configuration.orientation;
            }
            this.screenProps = bulletDeviceUtils.getScreenProps(context, i);
            View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$observerRootViewLayoutChanged$layoutChangeListener$1
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRootViewLayoutChanged(int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        View realView;
        Configuration configuration;
        final Ref.IntRef intRef = new Ref.IntRef();
        Resources resources = getContext().getResources();
        intRef.element = (resources == null || (configuration = resources.getConfiguration()) == null) ? 0 : configuration.orientation;
        boolean z = (AnnieXRuntime.INSTANCE.getDeviceDepend().isPad() || AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) && IConditionCallKt.enableOrientationGPFix();
        if (z) {
            if (intRef.element == 1 && right - left > bottom - top) {
                intRef.element = 2;
            } else if (intRef.element == 2 && right - left < bottom - top) {
                intRef.element = 1;
            }
        }
        BulletDeviceUtils bulletDeviceUtils = BulletDeviceUtils.INSTANCE;
        BulletContext bulletContext = this.bulletContext;
        final Map<String, Object> screenProps = bulletDeviceUtils.getScreenProps(bulletContext != null ? bulletContext.getContext() : null, intRef.element);
        if (z && screenProps != null) {
            screenProps.put("isLandscape", Integer.valueOf(intRef.element == 2 ? 1 : 0));
        }
        if (IConditionCallKt.enableAnnieXPadGPContainerMigration()) {
            IKitViewService iKitViewService = this.currentKitView;
            if (iKitViewService == null || (realView = iKitViewService.realView()) == null) {
                return;
            }
            realView.post(new Runnable() { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$onRootViewLayoutChanged$1
                @Override // java.lang.Runnable
                public final void run() {
                    IKitViewService iKitViewService2;
                    View realView2;
                    iKitViewService2 = BulletCardView.this.currentKitView;
                    if (iKitViewService2 != null && (realView2 = iKitViewService2.realView()) != null) {
                        Map<String, Object> map = screenProps;
                        BulletCardView bulletCardView = BulletCardView.this;
                        if (realView2.getWidth() > 0 && realView2.getHeight() > 0 && map != null) {
                            BulletDeviceUtils bulletDeviceUtils2 = BulletDeviceUtils.INSTANCE;
                            double width = realView2.getWidth();
                            Context context = bulletCardView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "context");
                            map.put("containerWidth", Integer.valueOf(bulletDeviceUtils2.px2dp(width, context)));
                            BulletDeviceUtils bulletDeviceUtils3 = BulletDeviceUtils.INSTANCE;
                            double height = realView2.getHeight();
                            Context context2 = bulletCardView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "context");
                            map.put("containerHeight", Integer.valueOf(bulletDeviceUtils3.px2dp(height, context2)));
                        }
                    }
                    BulletCardView.this.sendEvents(screenProps, intRef.element);
                }
            });
            return;
        }
        sendEvents(screenProps, intRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendEvents(Map<String, Object> screenProps, int newOrientation) {
        IKitViewService iKitViewService;
        if (Intrinsics.areEqual(screenProps, this.screenProps)) {
            return;
        }
        this.screenProps = screenProps;
        if (screenProps != null && (iKitViewService = this.currentKitView) != null) {
            iKitViewService.updateGlobalProps(screenProps);
        }
        if (this.changeOrientationEventToLayoutChange) {
            sendOrientationEvent(newOrientation, screenProps);
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
            DeviceDepend.onBreakPointChange$default(AnnieXRuntime.INSTANCE.getDeviceDepend(), (IContainer) null, this, screenProps, 1, (Object) null);
        }
    }

    private final void observerKitViewLayoutChanged() {
        IKitViewService iKitViewService;
        View realView;
        if (IConditionCallKt.enableAnnieXPadGPContainerMigration()) {
            if ((this.mCurrentScene != Scenes.PopupFragment && this.mCurrentScene != Scenes.AbsActivity) || (iKitViewService = this.currentKitView) == null || (realView = iKitViewService.realView()) == null) {
                return;
            }
            realView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$observerKitViewLayoutChanged$1
                /* JADX WARN: Code restructure failed: missing block: B:23:0x0072, code lost:
                
                    if (r3 != false) goto L39;
                 */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
                /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x00aa  */
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
                    IKitViewService iKitViewService3;
                    Map map3;
                    Map map4;
                    boolean z2;
                    int i2 = right - left;
                    if (i2 <= 0 || (i = bottom - top) <= 0) {
                        return;
                    }
                    BulletDeviceUtils bulletDeviceUtils = BulletDeviceUtils.INSTANCE;
                    double d = i2;
                    Context context = BulletCardView.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    int px2dp = bulletDeviceUtils.px2dp(d, context);
                    BulletDeviceUtils bulletDeviceUtils2 = BulletDeviceUtils.INSTANCE;
                    double d2 = i;
                    Context context2 = BulletCardView.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    int px2dp2 = bulletDeviceUtils2.px2dp(d2, context2);
                    map = BulletCardView.this.screenProps;
                    if (map != null) {
                        map2 = BulletCardView.this.screenProps;
                        if (map2 != null) {
                            Object obj = map2.get("containerWidth");
                            if ((obj instanceof Integer) && px2dp == ((Number) obj).intValue()) {
                                z = true;
                                if (z) {
                                    map4 = BulletCardView.this.screenProps;
                                    if (map4 != null) {
                                        Object obj2 = map4.get("containerHeight");
                                        if ((obj2 instanceof Integer) && px2dp2 == ((Number) obj2).intValue()) {
                                            z2 = true;
                                        }
                                    }
                                    z2 = false;
                                }
                                iKitViewService3 = BulletCardView.this.currentKitView;
                                if (iKitViewService3 != null) {
                                    iKitViewService3.updateGlobalProps(MapsKt.mapOf(new Pair[]{TuplesKt.to("containerWidth", Integer.valueOf(px2dp)), TuplesKt.to("containerHeight", Integer.valueOf(px2dp2))}));
                                }
                                map3 = BulletCardView.this.screenProps;
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
                        iKitViewService3 = BulletCardView.this.currentKitView;
                        if (iKitViewService3 != null) {
                        }
                        map3 = BulletCardView.this.screenProps;
                        if (!TypeIntrinsics.isMutableMap(map3)) {
                        }
                        if (map3 != null) {
                        }
                    }
                    iKitViewService2 = BulletCardView.this.currentKitView;
                    if (iKitViewService2 == null || (realView2 = iKitViewService2.realView()) == null) {
                        return;
                    }
                    realView2.removeOnLayoutChangeListener(this);
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

    private final void onFoldStatusChanged(String foldStatus, final Map<String, Object> screenProps) {
        this.foldStatus = foldStatus;
        if (screenProps != null) {
            onEvent(new IEvent(screenProps) { // from class: com.bytedance.ies.bullet.ui.common.BulletCardView$onFoldStatusChanged$1$1
                private final String name = "screenFoldStateChange";
                private final Object params;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.params = new JSONObject(screenProps);
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

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onOpen() {
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                iBulletLifeCycle.onOpen();
            }
        } catch (YieldError unused) {
        }
        addScreenCaptureListener();
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onBulletViewCreate() {
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                iBulletLifeCycle.onBulletViewCreate();
            }
        } catch (YieldError unused) {
        }
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadModelSuccess(Uri uri, IKitViewService kitView, SchemaModelUnion schemaModelUnion) {
        List<IBulletLoadLifeCycle> bulletGlobalLifeCycleListenerList;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(schemaModelUnion, "schemaModelUnion");
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                iBulletLifeCycle.onLoadModelSuccess(uri, kitView, schemaModelUnion);
            }
            BulletContext bulletContext = this.bulletContext;
            if (bulletContext == null || (bulletGlobalLifeCycleListenerList = bulletContext.getBulletGlobalLifeCycleListenerList()) == null) {
                return;
            }
            Iterator<T> it = bulletGlobalLifeCycleListenerList.iterator();
            while (it.hasNext()) {
                ((IBulletLoadLifeCycle) it.next()).onLoadModelSuccess(uri, kitView, schemaModelUnion);
            }
        } catch (YieldError unused) {
        }
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onRuntimeReady(Uri uri, IKitViewService kitView) {
        List<IBulletLoadLifeCycle> bulletGlobalLifeCycleListenerList;
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                iBulletLifeCycle.onRuntimeReady(uri, kitView);
            }
            BulletContext bulletContext = this.bulletContext;
            if (bulletContext != null && (bulletGlobalLifeCycleListenerList = bulletContext.getBulletGlobalLifeCycleListenerList()) != null) {
                Iterator<T> it = bulletGlobalLifeCycleListenerList.iterator();
                while (it.hasNext()) {
                    ((IBulletLoadLifeCycle) it.next()).onRuntimeReady(uri, kitView);
                }
            }
        } catch (YieldError unused) {
        }
        this.isJsRuntimeReady.getAndSet(true);
        if (this.isResuming.get()) {
            BulletLogger bulletLogger = BulletLogger.INSTANCE;
            LogLevel logLevel = LogLevel.I;
            BulletContext bulletContext2 = getBulletContext();
            bulletLogger.printTridentLog("BulletCardView.onRuntimeReady: call onEnterForeground", (r17 & 2) != 0 ? null : null, (r17 & 4) != 0 ? LogLevel.I : logLevel, (r17 & 8) != 0 ? "" : "XPopup", bulletContext2 != null ? bulletContext2.getSessionId() : null, (r17 & 32) != 0 ? "" : null, (r17 & 64) != 0 ? "" : null);
            onEnterForeground();
        }
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onFallback(Uri uri, Throwable e) {
        List<IBulletLoadLifeCycle> bulletGlobalLifeCycleListenerList;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(e, "e");
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                iBulletLifeCycle.onFallback(uri, e);
            }
            BulletContext bulletContext = this.bulletContext;
            if (bulletContext == null || (bulletGlobalLifeCycleListenerList = bulletContext.getBulletGlobalLifeCycleListenerList()) == null) {
                return;
            }
            Iterator<T> it = bulletGlobalLifeCycleListenerList.iterator();
            while (it.hasNext()) {
                ((IBulletLoadLifeCycle) it.next()).onFallback(uri, e);
            }
        } catch (YieldError unused) {
        }
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadFail(Uri uri, Throwable e) {
        List<IBulletLoadLifeCycle> bulletGlobalLifeCycleListenerList;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(e, "e");
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                iBulletLifeCycle.onLoadFail(uri, e);
            }
            BulletContext bulletContext = this.bulletContext;
            if (bulletContext != null && (bulletGlobalLifeCycleListenerList = bulletContext.getBulletGlobalLifeCycleListenerList()) != null) {
                Iterator<T> it = bulletGlobalLifeCycleListenerList.iterator();
                while (it.hasNext()) {
                    ((IBulletLoadLifeCycle) it.next()).onLoadFail(uri, e);
                }
            }
        } catch (YieldError unused) {
        }
        this.loadStatus.getAndSet(LoadStatus.FAIL.ordinal());
        removeScreenCaptureListener();
        BulletLifeCycleManager.INSTANCE.dispatchOnLoadUriFail(uri, this);
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onBulletViewRelease() {
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                iBulletLifeCycle.onBulletViewRelease();
            }
        } catch (YieldError unused) {
        }
        removeScreenCaptureListener();
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onClose() {
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                iBulletLifeCycle.onClose();
            }
        } catch (YieldError unused) {
        }
        removeScreenCaptureListener();
    }

    private final void bulletLoadLifeCycleRun(Function1<? super IBulletLoadLifeCycle, Unit> handler) {
        List<IBulletLoadLifeCycle> bulletGlobalLifeCycleListenerList;
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                handler.invoke(iBulletLifeCycle);
            }
            BulletContext bulletContext = this.bulletContext;
            if (bulletContext == null || (bulletGlobalLifeCycleListenerList = bulletContext.getBulletGlobalLifeCycleListenerList()) == null) {
                return;
            }
            Iterator<T> it = bulletGlobalLifeCycleListenerList.iterator();
            while (it.hasNext()) {
                handler.invoke((IBulletLoadLifeCycle) it.next());
            }
        } catch (YieldError unused) {
        }
    }

    private final void bulletLifeCycleRun(Function1<? super IBulletLifeCycle, Unit> handler) {
        try {
            BulletCardView bulletCardView = this;
            for (IBulletLifeCycle iBulletLifeCycle : this.lifeCycleListeners) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                handler.invoke(iBulletLifeCycle);
            }
        } catch (YieldError unused) {
        }
    }
}
