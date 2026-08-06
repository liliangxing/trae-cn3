package com.bytedance.ies.bullet.p003ui.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.anniex.R;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import com.bytedance.android.anniex.base.service.AnnieXActionService;
import com.bytedance.android.anniex.base.service.AnnieXMonitorService;
import com.bytedance.android.anniex.base.service.AnnieXPageLifecycleService;
import com.bytedance.android.anniex.base.service.AnnieXUIService;
import com.bytedance.android.anniex.container.ui.AnnieXSourceLabel;
import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.api.params.ArgusContainerCreateType;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.base.utils.AllScreenConfig;
import com.bytedance.ies.bullet.base.utils.OSUtil;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.container.FakeAnnieXContainer;
import com.bytedance.ies.bullet.container.api.ILongClickListenerProvider;
import com.bytedance.ies.bullet.core.BulletContainerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.BulletOptContext;
import com.bytedance.ies.bullet.core.BulletWebContext;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.container.BulletActivityWrapper;
import com.bytedance.ies.bullet.core.container.IActionModeProvider;
import com.bytedance.ies.bullet.core.container.IBulletActivityWrapper;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.p003ui.common.IBulletViewProvider;
import com.bytedance.ies.bullet.p003ui.common.container.IBulletEventInterceptor;
import com.bytedance.ies.bullet.p003ui.common.container.IFullScreenController;
import com.bytedance.ies.bullet.p003ui.common.utils.SoftKeyboardHelper;
import com.bytedance.ies.bullet.p003ui.common.utils.StatusBarUtil;
import com.bytedance.ies.bullet.p003ui.common.view.BulletTitleBar;
import com.bytedance.ies.bullet.p003ui.common.view.TitleBarConfig;
import com.bytedance.ies.bullet.schema.interceptor.WebStandardInterceptor;
import com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapterKt;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.CacheItem;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.IPreRenderService;
import com.bytedance.ies.bullet.service.base.IRouterAbilityProvider;
import com.bytedance.ies.bullet.service.base.IViewService;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate;
import com.bytedance.ies.bullet.service.base.router.config.StackManager;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.ies.bullet.service.monitor.reliability.ReliabilityReporter;
import com.bytedance.ies.bullet.service.monitor.utils.MonitorConstant;
import com.bytedance.ies.bullet.service.router.RouterService;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.interceptor.BundleInterceptor;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.schema.model.BDXPageModel;
import com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel;
import com.bytedance.ies.bullet.service.schema.utils.SchemaUtilsKt;
import com.bytedance.ies.bullet.service.sdk.SchemaConfig;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontMode;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontModeParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.push.interfaze.ISignalReportService;
import com.gyf.barlibrary.ImmersionBar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AbsBulletContainerActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 Ú\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002Ú\u0001B\u0005¢\u0006\u0002\u0010\bJ\u0012\u0010_\u001a\u0004\u0018\u00010\f2\u0006\u0010`\u001a\u00020\u000bH\u0016J\u0018\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020eH\u0016J\b\u0010f\u001a\u00020bH\u0016J\b\u0010g\u001a\u00020bH\u0002J\u0010\u0010h\u001a\u00020b2\u0006\u0010i\u001a\u00020\fH\u0017J\b\u0010j\u001a\u00020bH\u0017J\b\u0010k\u001a\u00020bH\u0002J\b\u0010l\u001a\u00020eH\u0016J\n\u0010m\u001a\u0004\u0018\u00010eH\u0016J\b\u0010n\u001a\u00020eH\u0016J\b\u0010o\u001a\u00020eH\u0016J\b\u0010p\u001a\u00020eH\u0016J\n\u0010q\u001a\u0004\u0018\u00010^H\u0004J\u0006\u0010r\u001a\u00020eJ\u0006\u0010s\u001a\u00020eJ\n\u0010t\u001a\u0004\u0018\u00010^H\u0016J\b\u0010u\u001a\u00020\"H\u0016J\b\u0010v\u001a\u00020bH\u0002J\u0010\u0010w\u001a\u00020\"2\u0006\u0010]\u001a\u00020^H\u0016J\b\u0010x\u001a\u00020bH\u0002J\b\u0010y\u001a\u00020bH\u0002J\u0012\u0010z\u001a\u00020b2\b\u0010{\u001a\u0004\u0018\u00010|H\u0002J\b\u0010}\u001a\u00020bH\u0002J(\u0010}\u001a\u00020b2\u0006\u0010]\u001a\u00020^2\n\b\u0002\u0010~\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\n\u0010\u007f\u001a\u0004\u0018\u00010VH\u0016J\t\u0010\u0080\u0001\u001a\u00020bH\u0016J'\u0010\u0081\u0001\u001a\u00020b2\u0007\u0010\u0082\u0001\u001a\u00020\u000b2\u0007\u0010\u0083\u0001\u001a\u00020\u000b2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0014J\t\u0010\u0086\u0001\u001a\u00020bH\u0016J\t\u0010\u0087\u0001\u001a\u00020bH\u0016J\t\u0010\u0088\u0001\u001a\u00020bH\u0016J\t\u0010\u0089\u0001\u001a\u00020bH\u0016J\u0013\u0010\u008a\u0001\u001a\u00020b2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016J\u0014\u0010\u008d\u0001\u001a\u00020b2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010 H\u0014J\t\u0010\u008f\u0001\u001a\u00020bH\u0014J\u0011\u0010\u0090\u0001\u001a\u00020b2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001J\u001b\u0010\u0093\u0001\u001a\u00020b2\u0006\u0010]\u001a\u00020^2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J\t\u0010\u0096\u0001\u001a\u00020bH\u0014J\u001b\u0010\u0097\u0001\u001a\u00020b2\u0006\u0010]\u001a\u00020^2\b\u0010{\u001a\u0004\u0018\u00010|H\u0016J'\u0010\u0098\u0001\u001a\u00020b2\u0006\u0010]\u001a\u00020^2\b\u0010{\u001a\u0004\u0018\u00010|2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0016J\u001b\u0010\u009a\u0001\u001a\u00020b2\u0006\u0010]\u001a\u00020^2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J%\u0010\u009b\u0001\u001a\u00020b2\u0006\u0010]\u001a\u00020^2\b\u0010{\u001a\u0004\u0018\u00010|2\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0016J\u001d\u0010\u009e\u0001\u001a\u00020b2\u0006\u0010]\u001a\u00020^2\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001H\u0016J\u001b\u0010¡\u0001\u001a\u00020b2\u0006\u0010]\u001a\u00020^2\b\u0010{\u001a\u0004\u0018\u00010|H\u0016J\t\u0010¢\u0001\u001a\u00020bH\u0016J\u0014\u0010£\u0001\u001a\u00020b2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010 H\u0002J\t\u0010¤\u0001\u001a\u00020bH\u0002J\t\u0010¥\u0001\u001a\u00020bH\u0002J\t\u0010¦\u0001\u001a\u00020bH\u0014J4\u0010§\u0001\u001a\u00020b2\u0007\u0010\u0082\u0001\u001a\u00020\u000b2\u0010\u0010¨\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020e0©\u00012\b\u0010ª\u0001\u001a\u00030«\u0001H\u0016¢\u0006\u0003\u0010¬\u0001J\u0012\u0010\u00ad\u0001\u001a\u00020b2\u0007\u0010\u008e\u0001\u001a\u00020 H\u0014J\t\u0010®\u0001\u001a\u00020bH\u0014J\u001b\u0010¯\u0001\u001a\u00020b2\u0006\u0010]\u001a\u00020^2\b\u0010{\u001a\u0004\u0018\u00010|H\u0016J\u0012\u0010°\u0001\u001a\u00020b2\u0007\u0010±\u0001\u001a\u00020 H\u0014J\t\u0010²\u0001\u001a\u00020bH\u0014J\t\u0010³\u0001\u001a\u00020bH\u0014J\u0012\u0010´\u0001\u001a\u00020b2\u0007\u0010µ\u0001\u001a\u00020\"H\u0016J\u000b\u0010¶\u0001\u001a\u0004\u0018\u00010\fH\u0017J\u000b\u0010·\u0001\u001a\u0004\u0018\u00010\fH\u0017J\f\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0017J\f\u0010º\u0001\u001a\u0005\u0018\u00010»\u0001H\u0016J\u001d\u0010¼\u0001\u001a\f\u0012\u0005\u0012\u00030¾\u0001\u0018\u00010½\u00012\b\u0010¿\u0001\u001a\u00030À\u0001H\u0016J\n\u0010Á\u0001\u001a\u00030Â\u0001H\u0016J\t\u0010Ã\u0001\u001a\u00020bH\u0016J\u0015\u0010Ä\u0001\u001a\u00020b2\n\b\u0002\u0010~\u001a\u0004\u0018\u00010*H\u0016J\t\u0010Å\u0001\u001a\u00020bH\u0004J\t\u0010Æ\u0001\u001a\u00020bH\u0002J\t\u0010Ç\u0001\u001a\u00020bH\u0002J\t\u0010È\u0001\u001a\u00020bH\u0014J\u0019\u0010É\u0001\u001a\u00020b2\u0006\u0010i\u001a\u00020\u00142\u0006\u0010]\u001a\u00020^H\u0002J\u0015\u0010Ê\u0001\u001a\u00020b2\n\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0016J\t\u0010Í\u0001\u001a\u00020\"H\u0016J\t\u0010Î\u0001\u001a\u00020\"H\u0016J\t\u0010Ï\u0001\u001a\u00020\"H\u0014J\t\u0010Ð\u0001\u001a\u00020\"H\u0016J\u0007\u0010Ñ\u0001\u001a\u00020bJ\u0010\u0010Ò\u0001\u001a\u00020b2\u0007\u0010Ó\u0001\u001a\u00020\"JL\u0010Ô\u0001\u001a\u00020b*\u00020\u00142=\u0010Õ\u0001\u001a8\u0012\u0015\u0012\u00130\u0014¢\u0006\u000e\b×\u0001\u0012\t\bØ\u0001\u0012\u0004\b\b(i\u0012\u0016\u0012\u00140Ù\u0001¢\u0006\u000e\b×\u0001\u0012\t\bØ\u0001\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020b0Ö\u0001H\u0002R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0004\u0018\u000107X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010<\u001a\u0004\u0018\u00010\"X\u0084\u000e¢\u0006\u0010\n\u0002\u0010A\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u000e\u0010B\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010E\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bG\u0010HR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010S\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\bT\u0010\bR\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010W\u001a\u0004\u0018\u00010XX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u000e\u0010]\u001a\u00020^X\u0082.¢\u0006\u0002\n\u0000¨\u0006Û\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/AbsBulletContainerActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "Lcom/bytedance/ies/bullet/ui/common/container/IBulletEventInterceptor;", "Lcom/bytedance/ies/bullet/ui/common/container/IFullScreenController;", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "Lcom/bytedance/ies/bullet/service/base/IRouterAbilityProvider;", "Lcom/bytedance/ies/bullet/core/container/IActionModeProvider;", "Lcom/bytedance/ies/bullet/container/api/ILongClickListenerProvider;", "()V", "_$_findViewCache", "", "", "Landroid/view/View;", "activityWrapper", "Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "getActivityWrapper", "()Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "annieXContainer", "Lcom/bytedance/ies/bullet/container/FakeAnnieXContainer;", "bulletContainerView", "Lcom/bytedance/ies/bullet/ui/common/BulletContainerView;", "getBulletContainerView", "()Lcom/bytedance/ies/bullet/ui/common/BulletContainerView;", "setBulletContainerView", "(Lcom/bytedance/ies/bullet/ui/common/BulletContainerView;)V", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getBulletContext", "()Lcom/bytedance/ies/bullet/core/BulletContext;", "setBulletContext", "(Lcom/bytedance/ies/bullet/core/BulletContext;)V", SchemaConstants.QUERY_KEY_BUNDLE, "Landroid/os/Bundle;", "canBack", "", "getCanBack", "()Z", "setCanBack", "(Z)V", "containerModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXContainerModel;", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getContextProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "setContextProviderFactory", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;)V", "hasShowKeyBoardAuto", "immersionBar", "Lcom/gyf/barlibrary/ImmersionBar;", "isFirstShow", "isPause", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isUseOuterContainer", "lynxClient", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "getLynxClient", "()Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "setLynxClient", "(Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;)V", "openPreRenderOpt", "getOpenPreRenderOpt", "()Ljava/lang/Boolean;", "setOpenPreRenderOpt", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "openReUseOpt", "openedPopup", "originalRequestOrientation", "poolService", "Lcom/bytedance/ies/bullet/service/base/IPreRenderService;", "getPoolService", "()Lcom/bytedance/ies/bullet/service/base/IPreRenderService;", "poolService$delegate", "Lkotlin/Lazy;", "rootLayout", "Landroid/view/ViewGroup;", "getRootLayout", "()Landroid/view/ViewGroup;", "setRootLayout", "(Landroid/view/ViewGroup;)V", "softKeyboardHelper", "Lcom/bytedance/ies/bullet/ui/common/utils/SoftKeyboardHelper;", "titleBar", "getTitleBar$annotations", "titleBarProvider", "Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBarProvider;", "uiModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "getUiModel", "()Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "setUiModel", "(Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;)V", "uri", "Landroid/net/Uri;", "_$_findCachedViewByID", "id", "callAction", "", "type", "extra", "", "close", "doBackPress", "enterFullScreen", "view", "exitFullScreen", "fixEMUINavBar", "getBid", "getBulletTag", "getBundle", "getChannel", "getContainerId", "getCurrentUri", "getIdentifierUrl", "getReactId", "getSchema", "hideLoading", "initActivityContainer", "initOuterContainer", "initStatusBar", "initUI", "initUIByParams", "kitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "loadUri", "providerFactory", "offerTitleBarProvider", "onActivityLoadUri", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBulletViewCreate", "onBulletViewRelease", "onClose", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onDestroy", "onEvent", ISignalReportService.BODY_KEY_EVENT, "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "onFallback", "e", "", "onInitUI", "onKitViewCreate", "onKitViewDestroy", "throwable", "onLoadFail", "onLoadModelSuccess", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "onLoadStart", "container", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "onLoadUriSuccess", "onOpen", "onPageCreate", "onPageDestroy", "onPageResume", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onRuntimeReady", "onSaveInstanceState", "outState", "onStart", "onStop", "onWindowFocusChanged", "hasFocus", "provideErrorView", "provideLoadingView", "provideLoadingViewLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "provideLongClickListener", "Landroid/view/View$OnLongClickListener;", "provideSelectMenuItemList", "", "Lcom/bytedance/ies/bullet/core/container/IActionModeProvider$CustomSelectMenuItem;", "menu", "Landroid/view/Menu;", "provideTitleBarText", "", "reCreateKitView", "reload", "removeRootPadding", "sendBackPressEvent", "setSecureInfo", "setStatusBarColor", "setStatusView", "setTitleBarStatus", "config", "Lcom/bytedance/ies/bullet/ui/common/view/TitleBarConfig;", "shouldInterceptBackgroundEvent", "shouldInterceptForegroundEvent", "shouldStatusBarUseDarkFontByDefault", "showLoading", "transStatusBar", "useDarkStatusBarFont", "useDarkMode", "useCacheIfNeeds", "resolve", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcom/bytedance/ies/bullet/service/base/CacheType;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsBulletContainerActivity extends AbsActivity implements IBulletEventInterceptor, IFullScreenController, IBulletLifeCycle, IRouterAbilityProvider, IActionModeProvider, ILongClickListenerProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_BULLET_BID = "bullet_bid_AbsBulletContainerActivity";
    private static boolean initializeDefaultBid;
    private BulletContainerView bulletContainerView;
    private BulletContext bulletContext;
    private Bundle bundle;
    private BDXContainerModel containerModel;
    private ContextProviderFactory contextProviderFactory;
    private boolean hasShowKeyBoardAuto;
    private ImmersionBar immersionBar;
    private boolean isFirstShow;
    private boolean isUseOuterContainer;
    private ILynxClientDelegate lynxClient;
    private Boolean openPreRenderOpt;
    private boolean openReUseOpt;
    private boolean openedPopup;
    private ViewGroup rootLayout;
    private View titleBar;
    private IBulletViewProvider.IBulletTitleBarProvider titleBarProvider;
    private BDXPageModel uiModel;
    private Uri uri;
    private Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final IBulletActivityWrapper activityWrapper = new BulletActivityWrapper() { // from class: com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity$activityWrapper$1
        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        {
            super((Activity) AbsBulletContainerActivity.this);
        }

        @Override // com.bytedance.ies.bullet.core.container.BulletActivityWrapper, com.bytedance.ies.bullet.core.container.IBulletActivityWrapper
        public void doBackPress() {
            AbsBulletContainerActivity.this.doBackPress();
        }
    };
    private boolean canBack = true;
    private AtomicBoolean isPause = new AtomicBoolean(false);

    /* renamed from: poolService$delegate, reason: from kotlin metadata */
    private final Lazy poolService = LazyKt.lazy(new Function0<IPreRenderService>() { // from class: com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity$poolService$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final IPreRenderService m593invoke() {
            return (IPreRenderService) StandardServiceManager.INSTANCE.get(AbsBulletContainerActivity.this.getBid(), IPreRenderService.class);
        }
    });
    private final SoftKeyboardHelper softKeyboardHelper = new SoftKeyboardHelper();
    private FakeAnnieXContainer annieXContainer = new FakeAnnieXContainer();
    private int originalRequestOrientation = 1;

    /* compiled from: AbsBulletContainerActivity.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StatusFontMode.values().length];
            try {
                iArr[StatusFontMode.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StatusFontMode.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(message = "use #titleBarProvider instead")
    private static /* synthetic */ void getTitleBar$annotations() {
    }

    @Override // com.bytedance.ies.bullet.core.container.IActionModeProvider
    public void callAction(int type, String extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
    }

    public String getBid() {
        return "default_bid";
    }

    public boolean initOuterContainer(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return false;
    }

    public void onActivityLoadUri() {
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onBulletViewCreate() {
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onBulletViewRelease() {
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onClose() {
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onFallback(Uri uri, Throwable e) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(e, "e");
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onKitViewDestroy(Uri uri, IKitViewService kitView, Throwable throwable) {
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadStart(Uri uri, IBulletContainer container) {
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    @Deprecated(message = "即将废弃的接口，请使用 IViewService 来定制 LoadingView")
    public View provideErrorView() {
        return null;
    }

    @Deprecated(message = "即将废弃的接口，请使用 IViewService 来定制 LoadingView")
    public View provideLoadingView() {
        return null;
    }

    @Deprecated(message = "即将废弃的接口，请使用 IViewService 来定制 LoadingView")
    public FrameLayout.LayoutParams provideLoadingViewLayoutParams() {
        return null;
    }

    public void setTitleBarStatus(TitleBarConfig config) {
    }

    @Override // com.bytedance.ies.bullet.p003ui.common.container.IBulletEventInterceptor
    public boolean shouldInterceptBackgroundEvent() {
        return false;
    }

    @Override // com.bytedance.ies.bullet.p003ui.common.container.IBulletEventInterceptor
    public boolean shouldInterceptForegroundEvent() {
        return false;
    }

    protected boolean shouldStatusBarUseDarkFontByDefault() {
        return true;
    }

    /* compiled from: AbsBulletContainerActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/AbsBulletContainerActivity$Companion;", "", "()V", "KEY_BULLET_BID", "", "initializeDefaultBid", "", "getInitializeDefaultBid", "()Z", "setInitializeDefaultBid", "(Z)V", "tryInitBulletIfNeed", "", "context", "Landroid/content/Context;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getInitializeDefaultBid() {
            return AbsBulletContainerActivity.initializeDefaultBid;
        }

        public final void setInitializeDefaultBid(boolean z) {
            AbsBulletContainerActivity.initializeDefaultBid = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void tryInitBulletIfNeed(Context context) {
            if (getInitializeDefaultBid()) {
                return;
            }
            setInitializeDefaultBid(true);
            try {
                BulletSdk.INSTANCE.ensureDefaultBidReady(context);
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "AbsBulletContainerActivity call BulletSdk.ensureDefaultBidReady success", null, "XView", 2, null);
            } catch (Throwable th) {
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "AbsBulletContainerActivity call BulletSdk.ensureDefaultBidReady failed, message = " + th.getMessage(), null, "XView", 2, null);
            }
        }
    }

    public final IBulletActivityWrapper getActivityWrapper() {
        return this.activityWrapper;
    }

    public final ContextProviderFactory getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    public final void setContextProviderFactory(ContextProviderFactory contextProviderFactory) {
        this.contextProviderFactory = contextProviderFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BulletContext getBulletContext() {
        return this.bulletContext;
    }

    protected final void setBulletContext(BulletContext bulletContext) {
        this.bulletContext = bulletContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BulletContainerView getBulletContainerView() {
        return this.bulletContainerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setBulletContainerView(BulletContainerView bulletContainerView) {
        this.bulletContainerView = bulletContainerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ViewGroup getRootLayout() {
        return this.rootLayout;
    }

    protected final void setRootLayout(ViewGroup viewGroup) {
        this.rootLayout = viewGroup;
    }

    protected final BDXPageModel getUiModel() {
        return this.uiModel;
    }

    protected final void setUiModel(BDXPageModel bDXPageModel) {
        this.uiModel = bDXPageModel;
    }

    protected final Boolean getOpenPreRenderOpt() {
        return this.openPreRenderOpt;
    }

    protected final void setOpenPreRenderOpt(Boolean bool) {
        this.openPreRenderOpt = bool;
    }

    public final boolean getCanBack() {
        return this.canBack;
    }

    public final void setCanBack(boolean z) {
        this.canBack = z;
    }

    private final IPreRenderService getPoolService() {
        return (IPreRenderService) this.poolService.getValue();
    }

    protected final Uri getCurrentUri() {
        Uri uri = this.uri;
        if (uri == null) {
            return null;
        }
        if (uri != null) {
            return uri;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uri");
        return null;
    }

    public final String getIdentifierUrl() {
        BulletLoadUriIdentifier uriIdentifier;
        String identifierUrl;
        BulletContext bulletContext = this.bulletContext;
        return (bulletContext == null || (uriIdentifier = bulletContext.getUriIdentifier()) == null || (identifierUrl = uriIdentifier.getIdentifierUrl()) == null || !LoaderUtil.INSTANCE.isNotNullOrEmpty(identifierUrl)) ? String.valueOf(getCurrentUri()) : identifierUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onCreate(Bundle savedInstanceState) {
        SchemaConfig schemaConfig;
        Uri uri;
        String str;
        String queryParameter;
        ISchemaData schemaData;
        AbsBulletMonitorCallback monitorCallback;
        Uri data;
        long currentTimeMillis = System.currentTimeMillis();
        supportRequestWindowFeature(10);
        super.onCreate(savedInstanceState);
        INSTANCE.tryInitBulletIfNeed((Context) this);
        if (ResourceLoader.INSTANCE.getApplication() != null) {
            Uri uri2 = null;
            if (ResourceLoader.containsBid$default(ResourceLoader.INSTANCE, "default_bid", null, 2, null)) {
                Intent intent = getIntent();
                if (intent != null && (data = intent.getData()) != null) {
                    this.uri = data;
                }
                if (this.uri == null) {
                    ReliabilityReporter.INSTANCE.reportLoadFail(AbsBulletMonitorCallback.ErrStage.Container, MonitorConstant.ERR_ACT_INVALID_URI, getBid(), (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
                    finish();
                    return;
                }
                String bid = getBid();
                HybridLogger.i$default(HybridLogger.INSTANCE, "XPage", "correctBid=" + bid, null, null, 12, null);
                if (savedInstanceState != null) {
                    String string = savedInstanceState.getString(KEY_BULLET_BID);
                    HybridLogger.i$default(HybridLogger.INSTANCE, "XPage", "savedBid=" + string, null, null, 12, null);
                    String str2 = string;
                    if (!(str2 == null || str2.length() == 0) && !Intrinsics.areEqual(bid, string)) {
                        BulletLogger.INSTANCE.printLog("AbsBulletContainerActivity.onCreate:correctBid=" + string, LogLevel.I, "XPage");
                        bid = string;
                    }
                }
                Intent intent2 = getIntent();
                this.bundle = intent2 != null ? intent2.getExtras() : null;
                if (IConditionCallKt.enableWebStandard()) {
                    SchemaConfig schemaConfig2 = new SchemaConfig();
                    Bundle bundle = this.bundle;
                    if (bundle != null) {
                        schemaConfig2.addInterceptor(new BundleInterceptor(bundle));
                    }
                    schemaConfig2.addInterceptor(new WebStandardInterceptor(bid));
                    schemaConfig = schemaConfig2;
                } else {
                    schemaConfig = null;
                }
                BulletContextManager companion = BulletContextManager.INSTANCE.getInstance();
                Uri uri3 = this.uri;
                if (uri3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uri");
                    uri = null;
                } else {
                    uri = uri3;
                }
                BulletContext orCreateContext = companion.getOrCreateContext(bid, uri, this.bundle, false, schemaConfig);
                if (savedInstanceState != null && Intrinsics.areEqual(orCreateContext.getBid(), "default_bid") && !Intrinsics.areEqual(bid, orCreateContext.getBid())) {
                    orCreateContext.setBid(bid);
                }
                orCreateContext.setRebuild(Boolean.valueOf(savedInstanceState != null));
                this.bulletContext = orCreateContext;
                setSecureInfo();
                HybridLogger hybridLogger = HybridLogger.INSTANCE;
                StringBuilder sb = new StringBuilder("bulletContext.bid=");
                BulletContext bulletContext = this.bulletContext;
                HybridLogger.i$default(hybridLogger, "XPage", sb.append(bulletContext != null ? bulletContext.getBid() : null).toString(), null, null, 12, null);
                BulletContext bulletContext2 = this.bulletContext;
                if (bulletContext2 != null && (monitorCallback = bulletContext2.getMonitorCallback()) != null) {
                    monitorCallback.onContainerCreated(Long.valueOf(currentTimeMillis));
                }
                HybridLogger hybridLogger2 = HybridLogger.INSTANCE;
                BulletContext bulletContext3 = this.bulletContext;
                Map<String, ? extends Object> mapOf = MapsKt.mapOf(TuplesKt.to("url", String.valueOf((bulletContext3 == null || (schemaData = bulletContext3.getSchemaData()) == null) ? null : schemaData.getInnerOriginUrl())));
                LoggerContext loggerContext = new LoggerContext();
                BulletContext bulletContext4 = this.bulletContext;
                String str3 = "";
                if (bulletContext4 == null || (str = bulletContext4.getSessionId()) == null) {
                    str = "";
                }
                loggerContext.pushStage(XConstant.SESSION_ID, str);
                Uri currentUri = getCurrentUri();
                if (currentUri != null && (queryParameter = currentUri.getQueryParameter(XConstant.BRIDGE_CALL_ID)) != null) {
                    str3 = queryParameter;
                }
                Intrinsics.checkNotNullExpressionValue(str3, "getCurrentUri()?.getQuer…stant.BRIDGE_CALL_ID)?:\"\"");
                loggerContext.pushStage(XConstant.CALL_ID, str3);
                Unit unit = Unit.INSTANCE;
                hybridLogger2.m11i("XPage", "page lifecycle onCreate", mapOf, loggerContext);
                onInitUI();
                loadUri();
                this.activityWrapper.onCreate((Activity) this, savedInstanceState);
                StackManager companion2 = StackManager.INSTANCE.getInstance();
                AbsBulletContainerActivity absBulletContainerActivity = this;
                BulletContext bulletContext5 = this.bulletContext;
                companion2.add(absBulletContainerActivity, bulletContext5 != null ? bulletContext5.getSessionId() : null);
                AnnieXJSWorkerManager annieXJSWorkerManager = AnnieXJSWorkerManager.INSTANCE;
                Context applicationContext = getApplicationContext();
                Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
                Application application = (Application) applicationContext;
                Uri uri4 = this.uri;
                if (uri4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uri");
                } else {
                    uri2 = uri4;
                }
                String uri5 = uri2.toString();
                Intrinsics.checkNotNullExpressionValue(uri5, "this.uri.toString()");
                annieXJSWorkerManager.initInPage$anniex_release(application, uri5);
                onPageCreate(savedInstanceState);
                return;
            }
        }
        finish();
    }

    private final void onPageCreate(Bundle savedInstanceState) {
        AnnieXPageLifecycleService annieXPageLifecycleService = ServiceCenter.INSTANCE.instance().get(getBid(), AnnieXPageLifecycleService.class);
        if (annieXPageLifecycleService != null) {
            annieXPageLifecycleService.onPageCreate(this.contextProviderFactory, this.annieXContainer, savedInstanceState);
        }
    }

    protected void onInitUI() {
        initUI();
    }

    private final void initUI() {
        BulletContext bulletContext = this.bulletContext;
        Uri uri = null;
        BulletWebContext webContext = bulletContext != null ? bulletContext.getWebContext() : null;
        if (webContext != null) {
            webContext.setActionModeProvider(this);
        }
        BulletContext bulletContext2 = this.bulletContext;
        BulletWebContext webContext2 = bulletContext2 != null ? bulletContext2.getWebContext() : null;
        if (webContext2 != null) {
            webContext2.setLongClickListenerProvider(this);
        }
        initActivityContainer();
        Uri uri2 = this.uri;
        if (uri2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uri");
        } else {
            uri = uri2;
        }
        boolean initOuterContainer = initOuterContainer(uri);
        this.isUseOuterContainer = initOuterContainer;
        if (!initOuterContainer) {
            setContentView(R.layout.bullet_activity_base_container);
            this.bulletContainerView = (BulletContainerView) _$_findCachedViewByID(R.id.bullet_container_view);
            this.rootLayout = (ViewGroup) _$_findCachedViewByID(R.id.root_layout);
        }
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            bulletContainerView.setMCurrentScene(Scenes.AbsActivity);
        }
        BulletContainerView bulletContainerView2 = this.bulletContainerView;
        if (bulletContainerView2 != null) {
            bulletContainerView2.onBulletViewCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setStatusView(final BulletContainerView view, Uri uri) {
        Object obj;
        IViewService iViewService;
        Context context;
        View constructUi;
        BulletContainerContext containerContext;
        BulletContainerView bulletContainerView;
        Unit unit;
        BulletOptContext optimizeContext;
        BulletContext bulletContext = this.bulletContext;
        if (!((bulletContext == null || (optimizeContext = bulletContext.getOptimizeContext()) == null || !optimizeContext.getSkipPageProvideView()) ? false : true)) {
            View provideLoadingView = provideLoadingView();
            if (provideLoadingView != null) {
                FrameLayout.LayoutParams provideLoadingViewLayoutParams = provideLoadingViewLayoutParams();
                if (provideLoadingViewLayoutParams != null) {
                    BulletContainerView bulletContainerView2 = this.bulletContainerView;
                    if (bulletContainerView2 != null) {
                        bulletContainerView2.setLoadingView(provideLoadingView, provideLoadingViewLayoutParams);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                }
                BulletContainerView bulletContainerView3 = this.bulletContainerView;
                if (bulletContainerView3 != null) {
                    IBulletContainer.DefaultImpls.setLoadingView$default(bulletContainerView3, provideLoadingView, 0, 0, 0, 0, 0, 62, null);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            View provideErrorView = provideErrorView();
            if (provideErrorView != null && (bulletContainerView = this.bulletContainerView) != null) {
                BulletContainerView.setErrorView$default(bulletContainerView, provideErrorView, null, 2, null);
            }
        }
        try {
            Result.Companion companion = Result.Companion;
            String safeGetQueryParameter = ExtKt.safeGetQueryParameter(uri, "url");
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
        BulletContext bulletContext2 = this.bulletContext;
        IViewService viewService = (bulletContext2 == null || (containerContext = bulletContext2.getContainerContext()) == null) ? null : containerContext.getViewService();
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "AbsBulletContainerActivity.setStatusView: viewService is null = " + (viewService == null), null, "XPage", 2, null);
        if (viewService == null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "AbsBulletContainerActivity.setStatusView: loadingBid = " + bid + ", errorBid = " + bid2, null, "XPage", 2, null);
            viewService = (IViewService) ServiceCenter.INSTANCE.instance().get(bid, IViewService.class);
            iViewService = (IViewService) ServiceCenter.INSTANCE.instance().get(bid2, IViewService.class);
        } else {
            iViewService = viewService;
        }
        if (IConditionCallKt.enableThirdPartyWebUi(this.bulletContext)) {
            AnnieXUIService annieXUIService = ServiceCenter.INSTANCE.instance().get(getBid(), AnnieXUIService.class);
            AnnieXUIService.LoadingView createLoadingView = annieXUIService != null ? annieXUIService.createLoadingView(this.annieXContainer) : null;
            ContextProviderFactory contextProviderFactory = this.contextProviderFactory;
            if (contextProviderFactory != null) {
                contextProviderFactory.registerHolder(AnnieXUIService.LoadingView.class, createLoadingView);
            }
            if (createLoadingView != null && (constructUi = createLoadingView.constructUi((context = (Context) this), this.annieXContainer)) != null) {
                view.setLoadingView(constructUi, new FrameLayout.LayoutParams(-1, UIUtils.dpToPx$anniex_release(2, context)));
            }
        } else if (viewService != null) {
            view.setLoadingView(viewService);
        }
        if (iViewService != null) {
            view.setErrorView(iViewService, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity$setStatusView$5$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m594invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m594invoke() {
                    AbsBulletContainerActivity.this.finish();
                }
            }, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity$setStatusView$5$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m595invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m595invoke() {
                    BulletContainerView.this.reLoadUri();
                }
            });
        }
    }

    private final void useCacheIfNeeds(BulletContainerView bulletContainerView, Function2<? super BulletContainerView, ? super CacheType, Unit> function2) {
        IPreRenderService poolService = getPoolService();
        CacheItem cacheItem = null;
        Uri uri = null;
        if (poolService != null) {
            Uri uri2 = this.uri;
            if (uri2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uri");
            } else {
                uri = uri2;
            }
            Boolean bool = this.openPreRenderOpt;
            cacheItem = poolService.fetch(uri, bool != null ? bool.booleanValue() : false, this.openReUseOpt, bulletContainerView);
        }
        if (cacheItem == null) {
            function2.invoke(bulletContainerView, CacheType.NONE);
            return;
        }
        View view = cacheItem.getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.bytedance.ies.bullet.ui.common.BulletContainerView");
        function2.invoke((BulletContainerView) view, cacheItem.getCacheType());
    }

    private final void loadUri() {
        AbsBulletMonitorCallback monitorCallback;
        AbsBulletMonitorCallback monitorCallback2;
        if (this.bulletContainerView == null) {
            BulletLogger.INSTANCE.printLog("Load uri failed: bulletContainerView has not been initialized, finish bullet activity", LogLevel.E, "XPage");
            BulletContext bulletContext = this.bulletContext;
            if (bulletContext != null && (monitorCallback2 = bulletContext.getMonitorCallback()) != null) {
                AbsBulletMonitorCallback.onLoadError$default(monitorCallback2, AbsBulletMonitorCallback.ErrStage.Container, MonitorConstant.ERR_ACT_UNINITED_VIEW, false, 4, null);
            }
            finish();
            return;
        }
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 != null && (monitorCallback = bulletContext2.getMonitorCallback()) != null) {
            AbsBulletMonitorCallback.onLoadEntryBullet$default(monitorCallback, System.currentTimeMillis(), false, 2, null);
        }
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            useCacheIfNeeds(bulletContainerView, new Function2<BulletContainerView, CacheType, Unit>() { // from class: com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity$loadUri$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((BulletContainerView) obj, (CacheType) obj2);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final void invoke(BulletContainerView bulletContainerView2, CacheType cacheType) {
                    Uri uri;
                    Uri uri2;
                    Bundle bundle;
                    FakeAnnieXContainer fakeAnnieXContainer;
                    AnnieXMonitorService.MonitorListener createMonitorListener;
                    FakeAnnieXContainer fakeAnnieXContainer2;
                    Intrinsics.checkNotNullParameter(bulletContainerView2, "view");
                    Intrinsics.checkNotNullParameter(cacheType, "type");
                    AbsBulletContainerActivity.this.setBulletContainerView(bulletContainerView2);
                    BulletContainerView bulletContainerView3 = AbsBulletContainerActivity.this.getBulletContainerView();
                    if (bulletContainerView3 != null) {
                        AbsBulletContainerActivity absBulletContainerActivity = AbsBulletContainerActivity.this;
                        if (IConditionCallKt.enableThirdPartyWebLogic(absBulletContainerActivity.getBulletContext())) {
                            fakeAnnieXContainer = absBulletContainerActivity.annieXContainer;
                            fakeAnnieXContainer.attach((Activity) absBulletContainerActivity, absBulletContainerActivity.getBulletContext(), absBulletContainerActivity.getBulletContainerView());
                            AnnieXMonitorService annieXMonitorService = ServiceCenter.INSTANCE.instance().get(AnnieXMonitorService.class);
                            if (annieXMonitorService != null && (createMonitorListener = annieXMonitorService.createMonitorListener()) != null) {
                                MonitorCenter instance = MonitorCenter.Companion.instance();
                                fakeAnnieXContainer2 = absBulletContainerActivity.annieXContainer;
                                instance.onContainerCreate(fakeAnnieXContainer2, createMonitorListener);
                            }
                        }
                        ContextProviderFactory contextProviderFactory = absBulletContainerActivity.getContextProviderFactory();
                        if (contextProviderFactory != null) {
                            bulletContainerView3.getProviderFactory().merge(contextProviderFactory);
                        }
                        absBulletContainerActivity.setContextProviderFactory(bulletContainerView3.getProviderFactory());
                        absBulletContainerActivity.onActivityLoadUri();
                        bulletContainerView3.getProviderFactory().registerWeakHolder(IFullScreenController.class, absBulletContainerActivity);
                        bulletContainerView3.getProviderFactory().registerWeakHolder(IBulletEventInterceptor.class, absBulletContainerActivity);
                        bulletContainerView3.getProviderFactory().registerWeakHolder(CacheType.class, cacheType);
                        bulletContainerView3.getProviderFactory().registerWeakHolder(Activity.class, absBulletContainerActivity);
                        bulletContainerView3.bind(absBulletContainerActivity.getBid());
                        bulletContainerView3.setActivityWrapper(absBulletContainerActivity.getActivityWrapper());
                        uri = absBulletContainerActivity.uri;
                        Uri uri3 = null;
                        if (uri == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("uri");
                            uri = null;
                        }
                        absBulletContainerActivity.setStatusView(bulletContainerView3, uri);
                        if (cacheType == CacheType.NONE) {
                            uri2 = absBulletContainerActivity.uri;
                            if (uri2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("uri");
                            } else {
                                uri3 = uri2;
                            }
                            ContextProviderFactory contextProviderFactory2 = absBulletContainerActivity.getContextProviderFactory();
                            bundle = absBulletContainerActivity.bundle;
                            absBulletContainerActivity.loadUri(uri3, contextProviderFactory2, bundle);
                            return;
                        }
                        if (cacheType == CacheType.PRE_RENDER) {
                            BulletLogger bulletLogger = BulletLogger.INSTANCE;
                            StringBuilder sb = new StringBuilder("Hit preRender, old ");
                            BulletContext bulletContext3 = absBulletContainerActivity.getBulletContext();
                            BulletLogger.printLog$default(bulletLogger, sb.append(bulletContext3 != null ? bulletContext3.getSessionId() : null).append(", new bullet").toString(), null, "XPage", 2, null);
                            BulletContext bulletContext4 = bulletContainerView3.getBulletContext();
                            if (bulletContext4 != null) {
                                bulletContext4.setContext((Context) absBulletContainerActivity);
                                bulletContext4.getWebContext().setActionModeProvider(absBulletContainerActivity);
                            }
                            bulletContainerView3.addLifeCycleListener(absBulletContainerActivity);
                            bulletContainerView3.onFetchFromPreRenderPool();
                        }
                    }
                }
            });
        }
    }

    public CharSequence provideTitleBarText() {
        return "";
    }

    public IBulletViewProvider.IBulletTitleBarProvider offerTitleBarProvider() {
        BulletContainerContext containerContext;
        IViewService viewService;
        BulletContainerContext containerContext2;
        BulletContext bulletContext = this.bulletContext;
        IBulletViewProvider.IBulletTitleBarProvider titleBarProvider = (bulletContext == null || (containerContext2 = bulletContext.getContainerContext()) == null) ? null : containerContext2.getTitleBarProvider();
        BulletContext bulletContext2 = this.bulletContext;
        IBulletViewProvider.IBulletTitleBarProvider titleBarProvider2 = (bulletContext2 == null || (containerContext = bulletContext2.getContainerContext()) == null || (viewService = containerContext.getViewService()) == null) ? null : viewService.getTitleBarProvider("page");
        IViewService iViewService = (IViewService) ServiceCenter.INSTANCE.instance().get(getBid(), IViewService.class);
        IBulletViewProvider.IBulletTitleBarProvider titleBarProvider3 = iViewService != null ? iViewService.getTitleBarProvider("page") : null;
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "AbsBulletContainerActivity.offerTitleBarProvider, titleBarProviderInBulletContext=" + titleBarProvider + ", titleBarProviderInContextViewProvider=" + titleBarProvider2 + ", titleBarProviderInBidViewProvider=" + titleBarProvider3, null, "XPage", 2, null);
        return titleBarProvider == null ? titleBarProvider2 == null ? titleBarProvider3 : titleBarProvider2 : titleBarProvider;
    }

    public boolean showLoading() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView == null) {
            return false;
        }
        if (bulletContainerView == null) {
            return true;
        }
        bulletContainerView.dispatchShowLoading();
        return true;
    }

    public boolean hideLoading() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView == null) {
            return false;
        }
        if (bulletContainerView == null) {
            return true;
        }
        bulletContainerView.dispatchHideLoading();
        return true;
    }

    public static /* synthetic */ void loadUri$default(AbsBulletContainerActivity absBulletContainerActivity, Uri uri, ContextProviderFactory contextProviderFactory, Bundle bundle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadUri");
        }
        if ((i & 2) != 0) {
            contextProviderFactory = null;
        }
        if ((i & 4) != 0) {
            bundle = null;
        }
        absBulletContainerActivity.loadUri(uri, contextProviderFactory, bundle);
    }

    public void loadUri(Uri uri, ContextProviderFactory providerFactory, Bundle bundle) {
        AbsBulletMonitorCallback monitorCallback;
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (this.bulletContainerView == null) {
            BulletLogger bulletLogger = BulletLogger.INSTANCE;
            BulletContext bulletContext = this.bulletContext;
            bulletLogger.printCoreLog(bulletContext != null ? bulletContext.getSessionId() : null, "load uri failed. reason: bulletContainerView is null, scheme: " + uri, "XPage", LogLevel.E);
            BulletContext bulletContext2 = this.bulletContext;
            if (bulletContext2 != null && (monitorCallback = bulletContext2.getMonitorCallback()) != null) {
                AbsBulletMonitorCallback.onLoadError$default(monitorCallback, AbsBulletMonitorCallback.ErrStage.Container, MonitorConstant.ERR_ACT_UNINITED_VIEW, false, 4, null);
            }
            finish();
            return;
        }
        BulletLogger bulletLogger2 = BulletLogger.INSTANCE;
        BulletContext bulletContext3 = this.bulletContext;
        BulletLogger.printCoreLog$default(bulletLogger2, bulletContext3 != null ? bulletContext3.getSessionId() : null, "load uri " + uri, "XPage", null, 8, null);
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            bulletContainerView.loadUri(uri, bundle, this.bulletContext, providerFactory, this);
        }
    }

    public static /* synthetic */ void reload$default(AbsBulletContainerActivity absBulletContainerActivity, ContextProviderFactory contextProviderFactory, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reload");
        }
        if ((i & 1) != 0) {
            contextProviderFactory = null;
        }
        absBulletContainerActivity.reload(contextProviderFactory);
    }

    public void reload(ContextProviderFactory providerFactory) {
        AbsBulletMonitorCallback monitorCallback;
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            if (bulletContainerView != null) {
                bulletContainerView.reload(providerFactory, this);
            }
        } else {
            BulletLogger.INSTANCE.printLog("Reload uri failed: bulletContainerView has not been initialized, finish bullet activity", LogLevel.E, "XPage");
            BulletContext bulletContext = this.bulletContext;
            if (bulletContext != null && (monitorCallback = bulletContext.getMonitorCallback()) != null) {
                AbsBulletMonitorCallback.onLoadError$default(monitorCallback, AbsBulletMonitorCallback.ErrStage.Container, MonitorConstant.ERR_ACT_UNINITED_VIEW, false, 4, null);
            }
            finish();
        }
    }

    public final void onEvent(IEvent event) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            bulletContainerView.onEvent(event);
        }
    }

    public final String getReactId() {
        String sessionId;
        BulletContainerView bulletContainerView = this.bulletContainerView;
        return (bulletContainerView == null || (sessionId = bulletContainerView.getSessionId()) == null) ? "" : sessionId;
    }

    private final void initActivityContainer() {
        Boolean bool = this.openPreRenderOpt;
        if (bool == null) {
            Bundle bundle = this.bundle;
            bool = Boolean.valueOf(Intrinsics.areEqual(bundle != null ? bundle.getString(SchemaConstants.QUERY_KEY_PRERENDER) : null, "1"));
        }
        this.openPreRenderOpt = bool;
        Bundle bundle2 = this.bundle;
        this.openReUseOpt = Intrinsics.areEqual(bundle2 != null ? bundle2.getString(SchemaConstants.QUERY_KEY_REUSE) : null, "1");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initUIByParams(IKitViewService kitView) {
        BooleanParam hideNavBar;
        View constructUi;
        ViewGroup viewGroup;
        BooleanParam isAdjustPan;
        BDXPageModel bDXPageModel = this.uiModel;
        if ((bDXPageModel == null || (isAdjustPan = bDXPageModel.isAdjustPan()) == null) ? false : Intrinsics.areEqual(isAdjustPan.getValue(), true)) {
            if ((kitView != null ? kitView.getKitType() : null) == KitType.WEB && (viewGroup = this.rootLayout) != null) {
                this.softKeyboardHelper.fixSoftKeyboardIssueForContainer(viewGroup, (Activity) this, 1);
            }
        }
        if (IConditionCallKt.enableThirdPartyWebUi(this.bulletContext)) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.title_bar_container);
            AnnieXUIService annieXUIService = ServiceCenter.INSTANCE.instance().get(getBid(), AnnieXUIService.class);
            r4 = annieXUIService != null ? annieXUIService.createTitleBar(this.contextProviderFactory, this.annieXContainer) : null;
            ContextProviderFactory contextProviderFactory = this.contextProviderFactory;
            if (contextProviderFactory != null) {
                contextProviderFactory.registerHolder(AnnieXSourceLabel.class, new AnnieXSourceLabel((Context) this, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null));
            }
            ContextProviderFactory contextProviderFactory2 = this.contextProviderFactory;
            if (contextProviderFactory2 != null) {
                contextProviderFactory2.registerHolder(AnnieXUIService.TitleBar.class, r4);
            }
            if (r4 != null && (constructUi = r4.constructUi((Context) this, this.annieXContainer)) != null && frameLayout != null) {
                frameLayout.addView(constructUi, -1, -2);
            }
            initStatusBar();
            return;
        }
        View findViewById = findViewById(R.id.title_bar_container);
        if (!this.isUseOuterContainer && findViewById != null) {
            BDXPageModel bDXPageModel2 = this.uiModel;
            if ((bDXPageModel2 == null || (hideNavBar = bDXPageModel2.getHideNavBar()) == null) ? false : Intrinsics.areEqual(hideNavBar.getValue(), true)) {
                ((FrameLayout) _$_findCachedViewByID(R.id.title_bar_container)).setVisibility(8);
            } else {
                if (this.titleBar == null) {
                    IBulletViewProvider.IBulletTitleBarProvider offerTitleBarProvider = offerTitleBarProvider();
                    this.titleBarProvider = offerTitleBarProvider;
                    if (offerTitleBarProvider == null) {
                        BulletTitleBar bulletTitleBar = new BulletTitleBar((Context) this, null, 0, 6, null);
                        bulletTitleBar.init(this.uiModel);
                        bulletTitleBar.setTitleIfMissing(provideTitleBarText());
                        bulletTitleBar.setBackListener(new View.OnClickListener() { // from class: com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity$initUIByParams$3$1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                AbsBulletContainerActivity.this.finish();
                            }
                        });
                        bulletTitleBar.setCloseAllListener(new View.OnClickListener() { // from class: com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity$initUIByParams$3$2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                AbsBulletContainerActivity.this.finish();
                            }
                        });
                        this.titleBar = bulletTitleBar;
                        ((FrameLayout) _$_findCachedViewByID(R.id.title_bar_container)).addView(this.titleBar, -1, -2);
                    } else {
                        if (offerTitleBarProvider != null) {
                            FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewByID(R.id.title_bar_container);
                            Context context = (Context) this;
                            AnnieXUIService.TitleBar titleBar = this.uri;
                            if (titleBar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("uri");
                            } else {
                                r4 = titleBar;
                            }
                            frameLayout2.addView(offerTitleBarProvider.initWithParams(context, r4, this.uiModel), -1, -2);
                            offerTitleBarProvider.setDefaultTitle(provideTitleBarText());
                            offerTitleBarProvider.setBackListener(new View.OnClickListener() { // from class: com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity$initUIByParams$4$1
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    AbsBulletContainerActivity.this.finish();
                                }
                            });
                            offerTitleBarProvider.setCloseAllListener(new View.OnClickListener() { // from class: com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity$initUIByParams$4$2
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    AbsBulletContainerActivity.this.finish();
                                }
                            });
                        }
                        ContextProviderFactory contextProviderFactory3 = this.contextProviderFactory;
                        if (contextProviderFactory3 != null) {
                            contextProviderFactory3.registerHolder(IBulletViewProvider.IBulletTitleBarProvider.class, this.titleBarProvider);
                        }
                    }
                } else if (((FrameLayout) _$_findCachedViewByID(R.id.title_bar_container)).getChildCount() == 0) {
                    ((FrameLayout) _$_findCachedViewByID(R.id.title_bar_container)).addView(this.titleBar, -1, -2);
                }
                ((FrameLayout) _$_findCachedViewByID(R.id.title_bar_container)).setVisibility(0);
            }
        }
        initStatusBar();
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity
    protected void setStatusBarColor() {
        ImmersionBar immersionBar = this.immersionBar;
        if (immersionBar != null) {
            immersionBar.destroy();
        }
        this.immersionBar = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d8, code lost:
    
        if (((r1 == null || (r1 = r1.getTransStatusBar()) == null) ? false : kotlin.jvm.internal.Intrinsics.areEqual(r1.getValue(), true)) != false) goto L54;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initStatusBar() {
        boolean z;
        boolean z2;
        BDXPageModel bDXPageModel;
        UIColorParam statusBarColor;
        Integer value;
        BooleanParam transStatusBar;
        BooleanParam hideStatusBar;
        BooleanParam transStatusBar2;
        StatusFontModeParam statusFontMode;
        BooleanParam isAdjustPan;
        if (StatusBarUtil.INSTANCE.isSupportImmersion$anniex_release()) {
            StatusBarUtil.INSTANCE.setFullScreenWindowLayoutInDisplayCutout$anniex_release(getWindow());
            Activity activity = (Activity) this;
            ImmersionBar with = ImmersionBar.with(activity);
            Window window = getWindow();
            boolean z3 = false;
            ImmersionBar statusBarColorInt = with.statusBarColorInt(window != null ? window.getStatusBarColor() : 0);
            BDXPageModel bDXPageModel2 = this.uiModel;
            ImmersionBar keyboardEnable = statusBarColorInt.keyboardEnable((bDXPageModel2 == null || (isAdjustPan = bDXPageModel2.isAdjustPan()) == null) ? false : Intrinsics.areEqual(isAdjustPan.getValue(), true));
            keyboardEnable.init();
            this.immersionBar = keyboardEnable;
            BDXPageModel bDXPageModel3 = this.uiModel;
            StatusFontMode value2 = (bDXPageModel3 == null || (statusFontMode = bDXPageModel3.getStatusFontMode()) == null) ? null : statusFontMode.getValue();
            int i = value2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[value2.ordinal()];
            if (i != 1) {
                z = i != 2 ? shouldStatusBarUseDarkFontByDefault() : false;
            } else {
                z = true;
            }
            StatusBarUtil.INSTANCE.trySetStatusBar$anniex_release(activity, getWindow(), z);
            BDXPageModel bDXPageModel4 = this.uiModel;
            if ((bDXPageModel4 == null || (transStatusBar2 = bDXPageModel4.getTransStatusBar()) == null) ? false : Intrinsics.areEqual(transStatusBar2.getValue(), true)) {
                transStatusBar();
            }
            BDXPageModel bDXPageModel5 = this.uiModel;
            if ((bDXPageModel5 == null || (hideStatusBar = bDXPageModel5.getHideStatusBar()) == null) ? false : Intrinsics.areEqual(hideStatusBar.getValue(), true)) {
                if (AllScreenConfig.isHaveBangs((Context) this)) {
                    BDXPageModel bDXPageModel6 = this.uiModel;
                }
                z2 = true;
                if (z2) {
                    StatusBarUtil.INSTANCE.hideStatusBar$anniex_release(activity);
                    removeRootPadding();
                }
                bDXPageModel = this.uiModel;
                if (bDXPageModel != null && (transStatusBar = bDXPageModel.getTransStatusBar()) != null) {
                    z3 = Intrinsics.areEqual(transStatusBar.getValue(), true);
                }
                if (!z3 || z2) {
                }
                Log.d("LandingPageKit", "AbsBulletContainerActivity initStatusBar()");
                final ViewGroup viewGroup = this.rootLayout;
                if (viewGroup != null) {
                    viewGroup.post(new Runnable() { // from class: com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity$initStatusBar$3$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            viewGroup.setPadding(0, StatusBarUtil.INSTANCE.getStatusBarHeight$anniex_release((Context) this), 0, 0);
                        }
                    });
                }
                BDXPageModel bDXPageModel7 = this.uiModel;
                if (bDXPageModel7 == null || (statusBarColor = bDXPageModel7.getStatusBarColor()) == null || (value = statusBarColor.getValue()) == null) {
                    return;
                }
                StatusBarUtil.INSTANCE.setStatusBarColor$anniex_release(activity, value.intValue());
                return;
            }
            z2 = false;
            if (z2) {
            }
            bDXPageModel = this.uiModel;
            if (bDXPageModel != null) {
                z3 = Intrinsics.areEqual(transStatusBar.getValue(), true);
            }
            if (z3) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void transStatusBar() {
        removeRootPadding();
        StatusBarUtil.INSTANCE.setStatusBarColor$anniex_release((Activity) this, 0);
    }

    private final void fixEMUINavBar() {
        Window window;
        if (!OSUtil.isEMUI3_x() || (window = getWindow()) == null) {
            return;
        }
        window.clearFlags(134217728);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onStart() {
        super.onStart();
        this.activityWrapper.onStart((Activity) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onResume() {
        String str;
        IKitViewService kitView;
        ISchemaData schemaData;
        String queryParameter;
        ISchemaData schemaData2;
        super.onResume();
        this.isPause.set(false);
        this.activityWrapper.onResume((Activity) this);
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            bulletContainerView.onOpen();
        }
        reCreateKitView();
        fixEMUINavBar();
        KitType kitType = null;
        if (IConditionCallKt.enableThirdPartyWebLogic(this.bulletContext)) {
            MonitorCenter instance = MonitorCenter.Companion.instance();
            BulletContext bulletContext = this.bulletContext;
            instance.onEnterForeground(bulletContext != null ? bulletContext.getSessionId() : null);
        }
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        BulletContext bulletContext2 = this.bulletContext;
        Map<String, ? extends Object> mapOf = MapsKt.mapOf(TuplesKt.to("url", String.valueOf((bulletContext2 == null || (schemaData2 = bulletContext2.getSchemaData()) == null) ? null : schemaData2.getInnerOriginUrl())));
        LoggerContext loggerContext = new LoggerContext();
        BulletContext bulletContext3 = this.bulletContext;
        String str2 = "";
        if (bulletContext3 == null || (str = bulletContext3.getSessionId()) == null) {
            str = "";
        }
        loggerContext.pushStage(XConstant.SESSION_ID, str);
        Uri currentUri = getCurrentUri();
        if (currentUri != null && (queryParameter = currentUri.getQueryParameter(XConstant.BRIDGE_CALL_ID)) != null) {
            str2 = queryParameter;
        }
        Intrinsics.checkNotNullExpressionValue(str2, "getCurrentUri()?.getQuer…stant.BRIDGE_CALL_ID)?:\"\"");
        loggerContext.pushStage(XConstant.CALL_ID, str2);
        Unit unit = Unit.INSTANCE;
        hybridLogger.m11i("XPage", "page lifecycle onResume", mapOf, loggerContext);
        onPageResume();
        if (this.isFirstShow) {
            return;
        }
        this.isFirstShow = true;
        BulletContext bulletContext4 = this.bulletContext;
        String valueOf = String.valueOf((bulletContext4 == null || (schemaData = bulletContext4.getSchemaData()) == null) ? null : schemaData.getInnerOriginUrl());
        BulletContainerView bulletContainerView2 = this.bulletContainerView;
        if (bulletContainerView2 != null && (kitView = bulletContainerView2.getCurrentKitView()) != null) {
            kitType = kitView.getKitType();
        }
        if (kitType != null) {
            AnnieXJSWorkerManager.INSTANCE.postFirstVisibleEvent$anniex_release(valueOf, getBid(), kitType);
        }
    }

    private final void onPageResume() {
        AnnieXPageLifecycleService annieXPageLifecycleService = ServiceCenter.INSTANCE.instance().get(getBid(), AnnieXPageLifecycleService.class);
        if (annieXPageLifecycleService != null) {
            annieXPageLifecycleService.onPageResume(this.contextProviderFactory, this.annieXContainer);
        }
    }

    public void reCreateKitView() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            if (!(!bulletContainerView.hasKitView() && bulletContainerView.isLoadSuccess())) {
                bulletContainerView = null;
            }
            if (bulletContainerView != null) {
                bulletContainerView.reLoadUri();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onPause() {
        super.onPause();
        this.isPause.set(true);
        this.activityWrapper.onPause((Activity) this);
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            bulletContainerView.onClose();
        }
        if (IConditionCallKt.enableThirdPartyWebLogic(this.bulletContext)) {
            MonitorCenter instance = MonitorCenter.Companion.instance();
            BulletContext bulletContext = this.bulletContext;
            instance.onEnterBackground(bulletContext != null ? bulletContext.getSessionId() : null);
        }
        BulletLogger bulletLogger = BulletLogger.INSTANCE;
        BulletContext bulletContext2 = this.bulletContext;
        BulletLogger.printCoreLog$default(bulletLogger, bulletContext2 != null ? bulletContext2.getSessionId() : null, "page lifecycle:onPause", "XPage", null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onStop() {
        super.onStop();
        this.activityWrapper.onStop((Activity) this);
        BulletLogger bulletLogger = BulletLogger.INSTANCE;
        BulletContext bulletContext = this.bulletContext;
        BulletLogger.printCoreLog$default(bulletLogger, bulletContext != null ? bulletContext.getSessionId() : null, "page lifecycle:onStop", "XPage", null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onDestroy() {
        String str;
        ISchemaData schemaData;
        String queryParameter;
        ISchemaData schemaData2;
        PoolResult poolResult;
        IPreRenderService poolService;
        super.onDestroy();
        onPageDestroy();
        StackManager companion = StackManager.INSTANCE.getInstance();
        AbsBulletContainerActivity absBulletContainerActivity = this;
        BulletContext bulletContext = this.bulletContext;
        Uri uri = null;
        companion.remove(absBulletContainerActivity, bulletContext != null ? bulletContext.getSessionId() : null);
        ImmersionBar immersionBar = this.immersionBar;
        if (immersionBar != null) {
            immersionBar.destroy();
        }
        if (IConditionCallKt.enableThirdPartyWebLogic(this.bulletContext)) {
            MonitorCenter instance = MonitorCenter.Companion.instance();
            BulletContext bulletContext2 = this.bulletContext;
            instance.onContainerDestroy(bulletContext2 != null ? bulletContext2.getSessionId() : null);
            this.annieXContainer.detach();
        }
        Activity activity = (Activity) this;
        this.softKeyboardHelper.reset(activity);
        this.activityWrapper.onDestroy(activity);
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            if (!this.openReUseOpt || (poolService = getPoolService()) == null) {
                poolResult = null;
            } else {
                Uri uri2 = this.uri;
                if (uri2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uri");
                    uri2 = null;
                }
                poolResult = poolService.reUse(uri2, bulletContainerView);
            }
            if (poolResult != PoolResult.SUCCESS) {
                bulletContainerView.release();
            }
        }
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        BulletContext bulletContext3 = this.bulletContext;
        Map<String, ? extends Object> mapOf = MapsKt.mapOf(TuplesKt.to("url", String.valueOf((bulletContext3 == null || (schemaData2 = bulletContext3.getSchemaData()) == null) ? null : schemaData2.getInnerOriginUrl())));
        LoggerContext loggerContext = new LoggerContext();
        BulletContext bulletContext4 = this.bulletContext;
        String str2 = "";
        if (bulletContext4 == null || (str = bulletContext4.getSessionId()) == null) {
            str = "";
        }
        loggerContext.pushStage(XConstant.SESSION_ID, str);
        Uri currentUri = getCurrentUri();
        if (currentUri != null && (queryParameter = currentUri.getQueryParameter(XConstant.BRIDGE_CALL_ID)) != null) {
            str2 = queryParameter;
        }
        Intrinsics.checkNotNullExpressionValue(str2, "getCurrentUri()?.getQuer…stant.BRIDGE_CALL_ID)?:\"\"");
        loggerContext.pushStage(XConstant.CALL_ID, str2);
        Unit unit = Unit.INSTANCE;
        hybridLogger.m11i("XPage", "page lifecycle onDestroy", mapOf, loggerContext);
        BulletContext bulletContext5 = this.bulletContext;
        if (bulletContext5 != null && (schemaData = bulletContext5.getSchemaData()) != null) {
            uri = schemaData.getInnerOriginUrl();
        }
        AnnieXJSWorkerManager.INSTANCE.postDestroyEvent$anniex_release(String.valueOf(uri));
        this.isFirstShow = false;
    }

    private final void onPageDestroy() {
        AnnieXPageLifecycleService annieXPageLifecycleService = ServiceCenter.INSTANCE.instance().get(getBid(), AnnieXPageLifecycleService.class);
        if (annieXPageLifecycleService != null) {
            annieXPageLifecycleService.onPageDestroy(this.contextProviderFactory, this.annieXContainer);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        this.activityWrapper.onSaveInstanceState((Activity) this, outState);
        String bid = getBid();
        HybridLogger.i$default(HybridLogger.INSTANCE, "XPage", "onSaveInstanceState: getBid()=" + bid, null, null, 12, null);
        outState.putString(KEY_BULLET_BID, bid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        this.activityWrapper.onRestoreInstanceState((Activity) this, savedInstanceState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.softKeyboardHelper.onConfigurationChanged(newConfig);
        this.activityWrapper.onConfigurationChanged((Activity) this, newConfig);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        this.activityWrapper.onRequestPermissionsResult((Activity) this, requestCode, permissions, grantResults);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onWindowFocusChanged(boolean hasFocus) {
        String str;
        StringParam nativeTriggerShowHideEvent;
        BooleanParam enableTriggerShowhide;
        Boolean value;
        super.onWindowFocusChanged(hasFocus);
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext == null) {
            return;
        }
        Intrinsics.checkNotNull(bulletContext);
        ISchemaModel containerModel = bulletContext.getSchemaModelUnion().getContainerModel();
        BDXContainerModel bDXContainerModel = containerModel instanceof BDXContainerModel ? (BDXContainerModel) containerModel : null;
        boolean booleanValue = (bDXContainerModel == null || (enableTriggerShowhide = bDXContainerModel.getEnableTriggerShowhide()) == null || (value = enableTriggerShowhide.getValue()) == null) ? true : value.booleanValue();
        BulletContext bulletContext2 = this.bulletContext;
        Intrinsics.checkNotNull(bulletContext2);
        ISchemaModel uiModel = bulletContext2.getSchemaModelUnion().getUiModel();
        BDXPageModel bDXPageModel = uiModel instanceof BDXPageModel ? (BDXPageModel) uiModel : null;
        if (bDXPageModel == null || (nativeTriggerShowHideEvent = bDXPageModel.getNativeTriggerShowHideEvent()) == null || (str = nativeTriggerShowHideEvent.getValue()) == null) {
            str = "none";
        }
        LoggerContext loggerContext = new LoggerContext();
        BulletContext bulletContext3 = this.bulletContext;
        Intrinsics.checkNotNull(bulletContext3);
        loggerContext.pushStage(XConstant.SESSION_ID, bulletContext3.getSessionId());
        if (!booleanValue && Intrinsics.areEqual(str, "none")) {
            HybridLogger.INSTANCE.m11i("XPage", "onWindowFocusChanged: ignore", MapsKt.mapOf(new Pair[]{TuplesKt.to("enableTriggerShowHide", Boolean.valueOf(booleanValue)), TuplesKt.to("nativeTriggerShowHideEvent", str)}), loggerContext);
            return;
        }
        this.activityWrapper.onWindowFocusChanged((Activity) this, hasFocus);
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "onWindowFocusChanged hasFocus == " + hasFocus + ", openedPopup == " + this.openedPopup, null, "XPage", 2, null);
        if (hasFocus) {
            if (this.openedPopup) {
                this.openedPopup = false;
                BulletContainerView bulletContainerView = this.bulletContainerView;
                if (bulletContainerView != null) {
                    bulletContainerView.onEnterForeground();
                }
                HybridLogger.i$default(HybridLogger.INSTANCE, "XPage", "onEnterForeground by close popup", null, loggerContext, 4, null);
                return;
            }
            return;
        }
        if (booleanValue && getSupportFragmentManager().getFragments().size() > 0) {
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "fragments isVisible == " + fragment.isVisible() + ", fragments tag == " + fragment.getTag(), null, "XPage", 2, null);
                if (fragment.isAdded() && !fragment.isHidden() && (Intrinsics.areEqual(fragment.getTag(), "BulletPopUp") || Intrinsics.areEqual(fragment.getTag(), "Annie Dialog"))) {
                    HybridLogger.i$default(HybridLogger.INSTANCE, "XPage", "onEnterBackground by open popup", null, loggerContext, 4, null);
                    this.openedPopup = true;
                    BulletContainerView bulletContainerView2 = this.bulletContainerView;
                    if (bulletContainerView2 != null) {
                        bulletContainerView2.onEnterBackground();
                        return;
                    }
                    return;
                }
            }
        }
        if (Intrinsics.areEqual(str, "none")) {
            return;
        }
        if (this.isPause.get() && Intrinsics.areEqual(str, "ignore_enter_background")) {
            return;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, "XPage", "onEnterBackground by native dialog", null, loggerContext, 4, null);
        this.openedPopup = true;
        BulletContainerView bulletContainerView3 = this.bulletContainerView;
        if (bulletContainerView3 != null) {
            bulletContainerView3.onEnterBackground();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.activityWrapper.onActivityResult((Activity) this, requestCode, resultCode, data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doBackPress() {
        if (this.canBack) {
            super.onBackPressed();
        } else {
            sendBackPressEvent();
            onEvent(new IEvent() { // from class: com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity$doBackPress$1
                private final String name = "systemBack";
                private final Object params;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", "button");
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
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        BooleanParam blockBackPress;
        SchemaModelUnion schemaModelUnion;
        IKitViewService kitView;
        AnnieXBlankDetectorManager annieXBlankDetectorManager = AnnieXBlankDetectorManager.INSTANCE;
        BulletContainerView bulletContainerView = this.bulletContainerView;
        ISchemaData iSchemaData = null;
        View realView = (bulletContainerView == null || (kitView = bulletContainerView.getCurrentKitView()) == null) ? null : kitView.realView();
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null && (schemaModelUnion = bulletContext.getSchemaModelUnion()) != null) {
            iSchemaData = schemaModelUnion.getSchemaData();
        }
        annieXBlankDetectorManager.onPageBlankCheck(realView, iSchemaData);
        AnnieXPageLifecycleService annieXPageLifecycleService = ServiceCenter.INSTANCE.instance().get(getBid(), AnnieXPageLifecycleService.class);
        if (annieXPageLifecycleService != null && annieXPageLifecycleService.isInterceptor(this.contextProviderFactory, this.annieXContainer)) {
            annieXPageLifecycleService.onBackPress(this.contextProviderFactory, this.annieXContainer);
            return;
        }
        BulletContainerView bulletContainerView2 = this.bulletContainerView;
        if (bulletContainerView2 != null) {
            BDXContainerModel bDXContainerModel = this.containerModel;
            if (((bDXContainerModel == null || (blockBackPress = bDXContainerModel.getBlockBackPress()) == null) ? false : Intrinsics.areEqual(blockBackPress.getValue(), true)) && bulletContainerView2.isLoadSuccess()) {
                sendBackPressEvent();
                return;
            }
        }
        if (IConditionCallKt.enableThirdPartyWebUi(this.bulletContext)) {
            doBackPress();
        } else {
            if (this.activityWrapper.shouldInterceptBackPressedEvent((Activity) this)) {
                return;
            }
            doBackPress();
        }
    }

    private final void sendBackPressEvent() {
        onEvent(new IEvent(this) { // from class: com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity$sendBackPressEvent$1
            private final String name = "bulletOnBackPressAction";
            private final Object params;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("containerID", this.getContainerId());
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
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.bullet.p003ui.common.container.IFullScreenController
    public void enterFullScreen(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.originalRequestOrientation = getRequestedOrientation();
        setRequestedOrientation(11);
        StatusBarUtil.INSTANCE.hideStatusBar$anniex_release((Activity) this);
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) decorView;
        View findViewById = viewGroup.findViewById(R.id.bullet_fullscreen_video_container);
        if (findViewById == null) {
            findViewById = new FrameLayout((Context) this);
            ((ViewGroup) findViewById).setId(R.id.bullet_fullscreen_video_container);
            viewGroup.addView(findViewById, new ViewGroup.LayoutParams(-1, -1));
        }
        ((ViewGroup) findViewById).setVisibility(0);
        try {
            Result.Companion companion = Result.Companion;
            ViewParent parent = view.getParent();
            FrameLayout frameLayout = parent instanceof FrameLayout ? (FrameLayout) parent : null;
            if (frameLayout != null) {
                frameLayout.removeView(view);
            }
            ((ViewGroup) findViewById).addView(view, new ViewGroup.LayoutParams(-1, -1));
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.bullet.p003ui.common.container.IFullScreenController
    public void exitFullScreen() {
        int requestedOrientation = getRequestedOrientation();
        int i = this.originalRequestOrientation;
        if (requestedOrientation != i) {
            setRequestedOrientation(i);
        }
        StatusBarUtil.INSTANCE.showStatusBar$anniex_release((Activity) this);
        initStatusBar();
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) decorView;
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.bullet_fullscreen_video_container);
        if (viewGroup2 != null) {
            viewGroup.removeView(viewGroup2);
            viewGroup2.removeAllViews();
            viewGroup2.setVisibility(8);
        }
    }

    protected final void removeRootPadding() {
        ViewGroup viewGroup = this.rootLayout;
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity$removeRootPadding$1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewGroup rootLayout = AbsBulletContainerActivity.this.getRootLayout();
                    if (rootLayout != null) {
                        rootLayout.setPadding(0, 0, 0, 0);
                    }
                }
            });
        }
    }

    public final void useDarkStatusBarFont(boolean useDarkMode) {
        BDXPageModel bDXPageModel = this.uiModel;
        if (bDXPageModel != null) {
            bDXPageModel.setStatusFontMode(useDarkMode ? new StatusFontModeParam(StatusFontMode.DARK) : new StatusFontModeParam(StatusFontMode.LIGHT));
        }
        initStatusBar();
    }

    @Override // com.bytedance.ies.bullet.service.base.IRouterAbilityProvider
    public String getBulletTag() {
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null) {
            return new StringParam(bulletContext.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_BDX_TAG, null).getValue();
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.IRouterAbilityProvider
    public String getChannel() {
        String value;
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null && (value = new StringParam(bulletContext.getSchemaModelUnion().getSchemaData(), "channel", null).getValue()) != null) {
            return value;
        }
        Bundle bundle = this.bundle;
        String string = bundle != null ? bundle.getString(XConstant.PARAM_KEY_CHANNEL) : null;
        return string == null ? "" : string;
    }

    @Override // com.bytedance.ies.bullet.service.base.IRouterAbilityProvider
    public String getBundle() {
        String value;
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null && (value = new StringParam(bulletContext.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_BUNDLE, null).getValue()) != null) {
            return value;
        }
        Bundle bundle = this.bundle;
        String string = bundle != null ? bundle.getString(XConstant.PARAM_KEY_BUNDLE) : null;
        return string == null ? "" : string;
    }

    @Override // com.bytedance.ies.bullet.service.base.IRouterAbilityProvider
    public void close() {
        String str;
        String sessionId;
        BulletLogger bulletLogger = BulletLogger.INSTANCE;
        Uri currentUri = getCurrentUri();
        Map mapOf = MapsKt.mapOf(TuplesKt.to("close page url", currentUri != null ? currentUri.toString() : null));
        BulletContext bulletContext = this.bulletContext;
        bulletLogger.printTridentLog("AbsBulletContainerActivity close", (r17 & 2) != 0 ? null : mapOf, (r17 & 4) != 0 ? LogLevel.I : null, (r17 & 8) != 0 ? "" : "XPage", bulletContext != null ? bulletContext.getSessionId() : null, (r17 & 32) != 0 ? "" : null, (r17 & 64) != 0 ? "" : null);
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Uri currentUri2 = getCurrentUri();
        String str2 = "";
        if (currentUri2 == null || (str = currentUri2.toString()) == null) {
            str = "";
        }
        Map<String, ? extends Object> mapOf2 = MapsKt.mapOf(TuplesKt.to("close page url", str));
        LoggerContext loggerContext = new LoggerContext();
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 != null && (sessionId = bulletContext2.getSessionId()) != null) {
            str2 = sessionId;
        }
        loggerContext.pushStage(XConstant.SESSION_ID, str2);
        Unit unit = Unit.INSTANCE;
        hybridLogger.m11i("XPage", "AbsBulletContainerActivity close", mapOf2, loggerContext);
        finish();
    }

    @Override // com.bytedance.ies.bullet.service.base.IRouterAbilityProvider
    public String getContainerId() {
        return getReactId();
    }

    @Override // com.bytedance.ies.bullet.service.base.IRouterAbilityProvider
    public Uri getSchema() {
        return getCurrentUri();
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onOpen() {
        RouterService routerService = (RouterService) StandardServiceManager.INSTANCE.get(getBid(), RouterService.class);
        if (routerService != null) {
            if (!(routerService instanceof RouterService)) {
                routerService = null;
            }
            if (routerService != null) {
                routerService.tryCloseAffinity(this.bulletContext, getChannel(), getBundle(), this);
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onRuntimeReady(Uri uri, IKitViewService kitView) {
        BulletContainerView bulletContainerView;
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (!this.isPause.get() || (bulletContainerView = this.bulletContainerView) == null) {
            return;
        }
        bulletContainerView.onEnterBackground();
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
        ISchemaModel uiModel = schemaModelUnion.getUiModel();
        BDXPageModel bDXPageModel = uiModel instanceof BDXPageModel ? (BDXPageModel) uiModel : null;
        if (bDXPageModel != null) {
            this.uiModel = bDXPageModel;
        }
        initUIByParams(kitView);
        fixEMUINavBar();
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onKitViewCreate(Uri uri, IKitViewService kitView) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "activity onLoadKitInstanceSuccess", null, "XPage", 2, null);
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadFail(Uri uri, Throwable e) {
        IBulletLifeCycle poolBulletLifeCycle;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(e, "e");
        if (IConditionCallKt.enableThirdPartyWebLogic(this.bulletContext)) {
            MonitorCenter instance = MonitorCenter.Companion.instance();
            BulletContext bulletContext = this.bulletContext;
            instance.onNavigateFail(bulletContext != null ? bulletContext.getSessionId() : null, e.toString());
        }
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null && (poolBulletLifeCycle = bulletContainerView.getPoolBulletLifeCycle()) != null) {
            poolBulletLifeCycle.onLoadFail(uri, e);
        }
        BulletContainerView bulletContainerView2 = this.bulletContainerView;
        if (bulletContainerView2 != null) {
            bulletContainerView2.removePoolBulletLifeCycle();
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "message:activity onLoadFail|e: " + e.getMessage(), null, "XPage", 2, null);
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadUriSuccess(Uri uri, IKitViewService kitView) {
        BooleanParam showKeyboard;
        IBulletLifeCycle poolBulletLifeCycle;
        Intrinsics.checkNotNullParameter(uri, "uri");
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null && (poolBulletLifeCycle = bulletContainerView.getPoolBulletLifeCycle()) != null) {
            poolBulletLifeCycle.onLoadUriSuccess(uri, kitView);
        }
        BulletContainerView bulletContainerView2 = this.bulletContainerView;
        if (bulletContainerView2 != null) {
            bulletContainerView2.removePoolBulletLifeCycle();
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "message:activity onLoadUriSuccess", null, "XPage", 2, null);
        BDXPageModel bDXPageModel = this.uiModel;
        if (!((bDXPageModel == null || (showKeyboard = bDXPageModel.getShowKeyboard()) == null) ? false : Intrinsics.areEqual(showKeyboard.getValue(), true)) || this.hasShowKeyBoardAuto) {
            return;
        }
        BulletContainerView bulletContainerView3 = this.bulletContainerView;
        if (bulletContainerView3 == null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "message:show soft key board failed! bullet container view hasn't been initialized!", null, "XPage", 2, null);
            return;
        }
        this.hasShowKeyBoardAuto = true;
        if (bulletContainerView3 != null) {
            this.softKeyboardHelper.showSoftKeyBoard(bulletContainerView3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.bullet.core.container.IActionModeProvider
    public List<IActionModeProvider.CustomSelectMenuItem> provideSelectMenuItemList(Menu menu) {
        String str;
        BooleanParam enableWebviewSelectSearch;
        Boolean value;
        BulletContext bulletContext;
        BulletLoadUriIdentifier uriIdentifier;
        Uri uri;
        SchemaModelUnion schemaModelUnion;
        Intrinsics.checkNotNullParameter(menu, "menu");
        BulletContext bulletContext2 = this.bulletContext;
        ISchemaModel kitModel = (bulletContext2 == null || (schemaModelUnion = bulletContext2.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getKitModel();
        BDXWebKitModel bDXWebKitModel = kitModel instanceof BDXWebKitModel ? (BDXWebKitModel) kitModel : null;
        BulletContext bulletContext3 = this.bulletContext;
        if (bulletContext3 == null || (str = bulletContext3.getBid()) == null) {
            str = "default_bid";
        }
        BulletContainerView bulletContainerView = this.bulletContainerView;
        String queryParameterSafely = (bulletContainerView == null || (bulletContext = bulletContainerView.getBulletContext()) == null || (uriIdentifier = bulletContext.getUriIdentifier()) == null || (uri = uriIdentifier.getUri()) == null) ? null : SchemaUtilsKt.getQueryParameterSafely(uri, "enter_from");
        AnnieXActionService annieXActionService = ServiceCenter.INSTANCE.instance().get(str, AnnieXActionService.class);
        if (annieXActionService == null) {
            return null;
        }
        Context context = (Context) this;
        BulletContext bulletContext4 = this.bulletContext;
        return annieXActionService.provideSelectMenuItemList(context, menu, new AnnieXActionService.SelectMenuConfig(bulletContext4 != null ? bulletContext4.getSessionId() : null, (bDXWebKitModel == null || (enableWebviewSelectSearch = bDXWebKitModel.getEnableWebviewSelectSearch()) == null || (value = enableWebviewSelectSearch.getValue()) == null) ? false : value.booleanValue(), queryParameterSafely, (String) null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.bullet.container.api.ILongClickListenerProvider
    public View.OnLongClickListener provideLongClickListener() {
        String str;
        BooleanParam disableSaveImage;
        Boolean value;
        BulletContext bulletContext;
        BulletLoadUriIdentifier uriIdentifier;
        Uri uri;
        SchemaModelUnion schemaModelUnion;
        BulletContext bulletContext2 = this.bulletContext;
        ISchemaModel kitModel = (bulletContext2 == null || (schemaModelUnion = bulletContext2.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getKitModel();
        BDXWebKitModel bDXWebKitModel = kitModel instanceof BDXWebKitModel ? (BDXWebKitModel) kitModel : null;
        BulletContext bulletContext3 = this.bulletContext;
        if (bulletContext3 == null || (str = bulletContext3.getBid()) == null) {
            str = "default_bid";
        }
        BulletContainerView bulletContainerView = this.bulletContainerView;
        String queryParameterSafely = (bulletContainerView == null || (bulletContext = bulletContainerView.getBulletContext()) == null || (uriIdentifier = bulletContext.getUriIdentifier()) == null || (uri = uriIdentifier.getUri()) == null) ? null : SchemaUtilsKt.getQueryParameterSafely(uri, "enter_from");
        AnnieXActionService annieXActionService = ServiceCenter.INSTANCE.instance().get(str, AnnieXActionService.class);
        if (annieXActionService == null) {
            return null;
        }
        Context context = (Context) this;
        BulletContext bulletContext4 = this.bulletContext;
        return annieXActionService.provideLongClickListener(context, new AnnieXActionService.LongClickConfig(bulletContext4 != null ? bulletContext4.getSessionId() : null, (bDXWebKitModel == null || (disableSaveImage = bDXWebKitModel.getDisableSaveImage()) == null || (value = disableSaveImage.getValue()) == null) ? false : value.booleanValue(), queryParameterSafely, (String) null));
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public ILynxClientDelegate getLynxClient() {
        return this.lynxClient;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void setLynxClient(ILynxClientDelegate iLynxClientDelegate) {
        this.lynxClient = iLynxClientDelegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setSecureInfo() {
        AbsBulletMonitorCallback monitorCallback;
        ArgusContainerDelegate argusContainerDelegate;
        AbsBulletMonitorCallback monitorCallback2;
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null && (monitorCallback2 = bulletContext.getMonitorCallback()) != null) {
            monitorCallback2.recordSecurityEventTime(MetricConstant.SEC_CONTAINER_CREATED_START);
        }
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 != null && (argusContainerDelegate = bulletContext2.getArgusContainerDelegate()) != null) {
            argusContainerDelegate.monitorContainerCreated((Activity) this, ArgusWebDelegateAdapterKt.initArgusContainerCreatedParams(this.bulletContext, ArgusContainerCreateType.Activity));
        }
        BulletContext bulletContext3 = this.bulletContext;
        if (bulletContext3 == null || (monitorCallback = bulletContext3.getMonitorCallback()) == null) {
            return;
        }
        monitorCallback.recordSecurityEventTime(MetricConstant.SEC_CONTAINER_CREATED_END);
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
}
