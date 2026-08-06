package com.bytedance.android.anniex.monitor;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import coil3.disk.DiskLruCache;
import com.bytedance.android.anniex.ability.service.AttachScene;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.scene.core.SceneManager;
import com.bytedance.android.anniex.scene.data.SceneDbContract;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.android.anniex.utils.AnnieXConstants;
import com.bytedance.android.monitorV2.entity.EngineInfo;
import com.bytedance.android.monitorV2.entity.UnifyErrorDomain;
import com.bytedance.android.monitorV2.standard.ContainerStandardApi;
import com.bytedance.android.monitorV2.standard.ContainerType;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.core.BulletMonitorContext;
import com.bytedance.ies.bullet.core.BulletRLContext;
import com.bytedance.ies.bullet.core.IBulletPerfClient;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.MonitorConfig;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.ContainerStandardMonitorWrapper;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import com.bytedance.ies.bullet.service.monitor.reliability.ReliabilityReporter;
import com.bytedance.ies.bullet.service.monitor.standard.ContainerStandardMonitor;
import com.bytedance.ies.bullet.service.monitor.timeline.DurationMap;
import com.bytedance.ies.bullet.service.monitor.timeline.TimeStampMap;
import com.bytedance.ies.bullet.service.monitor.timeline.TimelineHelper;
import com.bytedance.ies.bullet.service.monitor.timeline.TimelineReporter;
import com.bytedance.salamander.anniex.AccessLayerStringField;
import com.bytedance.salamander.anniex.SLAnnieXMonitor;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.TraceEvent;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* compiled from: MonitorManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u001e\u0010)\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0004J\u0010\u0010-\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0004H\u0002J$\u0010.\u001a\u00020\u00102\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010(\u001a\u00020\u0004H\u0002J\u0010\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u0002042\u0006\u0010(\u001a\u00020\u0004H\u0002J\u001d\u00105\u001a\u0004\u0018\u0001042\u0006\u0010(\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0004¢\u0006\u0002\u00107J#\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001092\u0006\u0010(\u001a\u00020\u0004H\u0000¢\u0006\u0002\b:J\u0006\u0010;\u001a\u00020'J\u0010\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020>H\u0002J\u001d\u0010?\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\b\u0010@\u001a\u0004\u0018\u000104¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u0004H\u0002J\u0018\u0010C\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010\u0004J\u0016\u0010E\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004J\u001e\u0010G\u001a\u00020'2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0004J\u000e\u0010J\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J-\u0010K\u001a\u00020'2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u00101\u001a\u0002022\u0006\u0010L\u001a\u00020\u0004H\u0000¢\u0006\u0002\bMJ\u000e\u0010N\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010O\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010P\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010Q\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u0016\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020T2\u0006\u0010(\u001a\u00020\u0004J0\u0010U\u001a\u00020'2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u00101\u001a\u0002022\u0006\u0010L\u001a\u00020\u00042\b\u0010V\u001a\u0004\u0018\u00010+J0\u0010U\u001a\u00020'2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u00101\u001a\u0002022\u0006\u0010L\u001a\u00020\u00042\b\u0010S\u001a\u0004\u0018\u00010TJ\u0016\u0010W\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010=\u001a\u00020>J\u000e\u0010X\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u0016\u0010Y\u001a\u00020'2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004J \u0010Y\u001a\u00020'2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\u0004J\u000e\u0010Z\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u0016\u0010[\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+J\u000e\u0010\\\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J6\u0010]\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\b\u0010^\u001a\u0004\u0018\u00010_2\b\b\u0002\u0010`\u001a\u00020\u00042\b\b\u0002\u0010a\u001a\u0002042\b\b\u0002\u0010b\u001a\u00020cJ\u000e\u0010d\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010e\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010f\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u0016\u0010g\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010h\u001a\u00020\u0012J\u001e\u0010i\u001a\u00020'2\u0006\u0010j\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010=\u001a\u00020>J\u000e\u0010k\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010l\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010m\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u0010\u0010n\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0002J.\u0010o\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0014\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\u0010q\u001a\u0004\u0018\u00010rJD\u0010s\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0014\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0014\u0010t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000204\u0018\u00010\u00072\b\u0010u\u001a\u0004\u0018\u00010\u0004J\u001a\u0010v\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\b\u0010u\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010w\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u0016\u0010x\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010=\u001a\u00020>J\u0016\u0010y\u001a\u00020'2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004J \u0010y\u001a\u00020'2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\u0004J\u000e\u0010z\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010{\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010|\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u0016\u0010}\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010~\u001a\u00020\"J\u0017\u0010\u007f\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0007\u0010\u0080\u0001\u001a\u000204J!\u0010\u0081\u0001\u001a\u00020'2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010@\u001a\u000204J\u000f\u0010\u0084\u0001\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004J\u001b\u0010\u0085\u0001\u001a\u00020'2\b\b\u0002\u0010H\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0002J!\u0010\u0086\u0001\u001a\u00020'2\b\b\u0002\u0010H\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0000¢\u0006\u0003\b\u0087\u0001J^\u0010\u0088\u0001\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u00122+\b\u0002\u0010\u008a\u0001\u001a$\u0012\u0017\u0012\u00150\u008c\u0001¢\u0006\u000f\b\u008d\u0001\u0012\n\b\u008e\u0001\u0012\u0005\b\b(\u008f\u0001\u0012\u0004\u0012\u00020'\u0018\u00010\u008b\u00012\n\b\u0002\u0010\u0090\u0001\u001a\u00030\u0091\u00012\t\b\u0002\u0010\u0085\u0001\u001a\u00020\u0012J\u0011\u0010\u0092\u0001\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u0004H\u0002J!\u0010\u0093\u0001\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u000e\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020'0\u0095\u0001H\u0002J%\u0010\u0096\u0001\u001a\u00020\u001c2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c0\u00072\u0006\u0010(\u001a\u00020\u0004H\u0002J\u0019\u0010\u0097\u0001\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020 0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009a\u0001"}, d2 = {"Lcom/bytedance/android/anniex/monitor/MonitorManager;", "", "()V", "CONTAINER_NAME", "", "TAG", "callbackCountMap", "", "Ljava/util/concurrent/atomic/AtomicInteger;", "devtoolReportFunction", "Ljava/lang/reflect/Method;", "getDevtoolReportFunction", "()Ljava/lang/reflect/Method;", "devtoolReportFunction$delegate", "Lkotlin/Lazy;", "durationMap", "Lcom/bytedance/ies/bullet/service/monitor/timeline/DurationMap;", "enableViewAttachStack", "", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "ignoreSession", "Ljava/util/concurrent/CopyOnWriteArraySet;", "lynxDurationMap", "lynxTimeStampMap", "Lcom/bytedance/ies/bullet/service/monitor/timeline/TimeStampMap;", "monitorContextMap", "Lcom/bytedance/ies/bullet/core/BulletMonitorContext;", "reportStateMap", "Lcom/bytedance/android/anniex/monitor/AnnieXMonitorContext;", "resourceContextMap", "Lcom/bytedance/ies/bullet/core/BulletRLContext;", "timeStampMap", "updateLynxDurationMap", "updateLynxTimeStampMap", "addIgnoreSession", "", "sessionId", "attachNewSessionId", "container", "Landroid/view/View;", "engineType", "callbackCountWithSessionId", "durationMapWithSessionId", "sourceMap", "getErrorStageMsg", "errStage", "Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback$ErrStage;", "getStayDuration", "", "getTimeStamp", "key", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "getTimeStampMap", "", "getTimeStampMap$anniex_release", "initMonitorManager", "isReloadScene", "annieXCardScene", "Lcom/bytedance/android/anniex/monitor/AnnieXCardScene;", "markOpenTime", "timeStamp", "(Ljava/lang/String;Ljava/lang/Long;)V", "monitorContextWithSessionId", "onAttachToWindow", StreamTrafficObservable.STREAM_URL, "onClientComponent", "viewType", "onContainerCreateBegin", "bid", "pageType", "onContainerCreateEnd", "onContainerError", "errMessage", "onContainerError$anniex_release", "onFirstScreen", "onJsbRegisterBegin", "onJsbRegisterEnd", "onKitViewCreateBegin", "onKitViewCreateEnd", "lynxView", "Lcom/lynx/tasm/LynxView;", "onLoadFail", "view", "onLoadStart", "onLoadSuccess", "onLynxModelCreateBegin", "onLynxModelCreateEnd", "onLynxMonitorInitSync", "onLynxReadTemplateBegin", "onLynxReadTemplateEnd", "response", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "customResFrom", "resVersion", "resSize", "", "onLynxRenderTemplateBegin", "onLynxRenderTemplateEnd", "onLynxViewAsyncLayoutBegin", "onLynxViewAsyncLayoutEnd", "success", "onLynxViewReused", "originalSessionId", "onPageStart", "onPrepareTemplateBegin", "onPrepareTemplateEnd", "onSetup", "onTimingSetup", "timingInfo", "lynxDevtool", "Lcom/lynx/devtoolwrapper/LynxDevtool;", "onTimingUpdate", "updateTiming", "flag", "onUpdate", "onWebLoadEnd", "onWebLoadStart", "onWebModelCreateBegin", "onWebModelCreateEnd", "onWebPageFinish", "onWebPageStart", "onWebPrepareTemplateEnd", "rlContext", "onWebViewCreateBegin", "createBegin", "onWebViewCreateEnd", "webView", "Landroid/webkit/WebView;", "removeMonitorInfo", "reportEndToEndTrace", "reportEndToEndTraceWithSafeAction", "reportEndToEndTraceWithSafeAction$anniex_release", "reportInfo", "forceReport", "customReport", "Lkotlin/Function1;", "Lcom/bytedance/ies/bullet/service/base/ReportInfo;", "Lkotlin/ParameterName;", StrategyConstants.NAME, "tracertTimeline", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "resourceContextWithSessionId", "safeAction", "block", "Lkotlin/Function0;", "timeStampMapWithSessionId", "updateUriIdentifier", "uri", "Landroid/net/Uri;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class MonitorManager {
    private static final String CONTAINER_NAME = "AnnieX";
    private static final String TAG = "AnnieXMonitorManager";
    public static final MonitorManager INSTANCE = new MonitorManager();
    private static final Map<String, TimeStampMap> timeStampMap = new LinkedHashMap();
    private static final Map<String, DurationMap> durationMap = new LinkedHashMap();
    private static final Map<String, TimeStampMap> lynxTimeStampMap = new LinkedHashMap();
    private static final Map<String, DurationMap> lynxDurationMap = new LinkedHashMap();
    private static final Map<String, TimeStampMap> updateLynxTimeStampMap = new LinkedHashMap();
    private static final Map<String, DurationMap> updateLynxDurationMap = new LinkedHashMap();
    private static final Map<String, AtomicInteger> callbackCountMap = new LinkedHashMap();
    private static final Map<String, BulletMonitorContext> monitorContextMap = new LinkedHashMap();
    private static final Map<String, BulletRLContext> resourceContextMap = new LinkedHashMap();
    private static final Map<String, AnnieXMonitorContext> reportStateMap = new LinkedHashMap();

    /* renamed from: handler$delegate, reason: from kotlin metadata */
    private static final Lazy handler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$handler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m3356invoke() {
            HandlerThread handlerThread = new HandlerThread("MonitorManagerThread", 0);
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    });
    private static final CopyOnWriteArraySet<String> ignoreSession = new CopyOnWriteArraySet<>();

    /* renamed from: devtoolReportFunction$delegate, reason: from kotlin metadata */
    private static final Lazy devtoolReportFunction = LazyKt.lazy(new Function0<Method>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$devtoolReportFunction$2
        public final Method invoke() {
            try {
                return LynxDevtool.class.getMethod("onPerfMetricsEvent", String.class, JSONObject.class);
            } catch (Throwable th) {
                Log.e("AnnieXMonitorManager", "Lynx devtool not support report with LynxDevtool.onPerfMetricsEvent, e: " + th);
                return null;
            }
        }
    });
    private static final boolean enableViewAttachStack = IConditionCallKt.enableViewAttachStack();

    /* compiled from: MonitorManager.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AbsBulletMonitorCallback.ErrStage.values().length];
            try {
                iArr[AbsBulletMonitorCallback.ErrStage.Container.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbsBulletMonitorCallback.ErrStage.Plugin.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbsBulletMonitorCallback.ErrStage.RL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbsBulletMonitorCallback.ErrStage.Engine.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MonitorManager() {
    }

    private final Handler getHandler() {
        return (Handler) handler.getValue();
    }

    public final void addIgnoreSession(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        ignoreSession.add(sessionId);
    }

    public final void initMonitorManager() {
        getHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Method getDevtoolReportFunction() {
        return (Method) devtoolReportFunction.getValue();
    }

    public final void onContainerCreateBegin(String bid, String sessionId, String pageType) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        long currentTimeMillis = System.currentTimeMillis();
        MonitorManager monitorManager = INSTANCE;
        BulletMonitorContext monitorContextWithSessionId = monitorManager.monitorContextWithSessionId(sessionId);
        if (!monitorContextWithSessionId.getInUse()) {
            monitorContextWithSessionId.init(sessionId, pageType, Long.valueOf(currentTimeMillis));
            monitorContextWithSessionId.setBid(bid);
        }
        monitorManager.timeStampMapWithSessionId(timeStampMap, sessionId).record("container_init_start", Long.valueOf(currentTimeMillis));
        ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "container_init_start", Long.valueOf(currentTimeMillis));
    }

    public final void onContainerCreateEnd(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.timeStampMapWithSessionId(timeStampMap, sessionId).record("container_init_end", Long.valueOf(currentTimeMillis));
        ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "container_init_end", Long.valueOf(currentTimeMillis));
    }

    public final void onLynxMonitorInitSync(String sessionId, View container) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(container, "container");
        ContainerStandardApi.INSTANCE.attach(sessionId, new ContainerType(container, "lynx"));
        ContainerStandardApi.INSTANCE.collectString(sessionId, "container_name", CONTAINER_NAME);
    }

    public final void onLynxModelCreateBegin(final String bid, final String sessionId, final String viewType) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        TraceEvent.beginSection("lynx_model_init");
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLynxModelCreateBegin$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3369invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3369invoke() {
                BulletMonitorContext monitorContextWithSessionId;
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                monitorContextWithSessionId = MonitorManager.INSTANCE.monitorContextWithSessionId(sessionId);
                if (!monitorContextWithSessionId.getInUse()) {
                    String str = sessionId;
                    long j = currentTimeMillis;
                    String str2 = bid;
                    monitorContextWithSessionId.init(str, AnnieXConstants.ANNIEX_CARD, Long.valueOf(j));
                    monitorContextWithSessionId.setBid(str2);
                }
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                long j2 = currentTimeMillis;
                String str3 = sessionId;
                timeStampMapWithSessionId.record("prepare_init_data_start", Long.valueOf(j2));
                ContainerStandardMonitorWrapper.INSTANCE.collect(str3, "prepare_init_data_start", Long.valueOf(j2));
                String str4 = sessionId;
                if (!TraceEvent.enableTrace()) {
                    Log.d("AnnieXMonitorManager", "create reportStateMap: " + str4 + ' ');
                }
                map2 = MonitorManager.reportStateMap;
                map2.put(sessionId, new AnnieXMonitorContext());
                String str5 = viewType;
                if (str5 != null) {
                    ContainerStandardMonitorWrapper.INSTANCE.addContext(sessionId, "annie_view_type", str5);
                }
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "container_name", "AnnieX");
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "biz", bid);
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "core_view_type", AnnieXConstants.ANNIEX_CARD);
                SLMonitorCompat sLMonitorCompat = SLMonitorCompat.INSTANCE;
                String str6 = sessionId;
                final String str7 = bid;
                sLMonitorCompat.collectContainerBaseStringField(str6, new Function1<SLAnnieXMonitor, Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLynxModelCreateBegin$1$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SLAnnieXMonitor) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SLAnnieXMonitor sLAnnieXMonitor) {
                        Intrinsics.checkNotNullParameter(sLAnnieXMonitor, "$this$collectContainerBaseStringField");
                        sLAnnieXMonitor.collectContainerBaseStringField(AccessLayerStringField.Biz, str7);
                        sLAnnieXMonitor.collectContainerBaseStringField(AccessLayerStringField.CoreViewType, AnnieXConstants.ANNIEX_CARD);
                    }
                });
                if (Intrinsics.areEqual(viewType, AnnieXConstants.ANNIEX_CARD)) {
                    ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "view_type", AnnieX.CONTAINER_VIEW_TYPE_CARD);
                    ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, SceneDbContract.Scenes.COLUMN_CLIENT_COMPONENT, Components.View.getTag());
                    SLMonitorCompat.INSTANCE.collectContainerBaseStringField(sessionId, new Function1<SLAnnieXMonitor, Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLynxModelCreateBegin$1$1.6
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SLAnnieXMonitor) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SLAnnieXMonitor sLAnnieXMonitor) {
                            Intrinsics.checkNotNullParameter(sLAnnieXMonitor, "$this$collectContainerBaseStringField");
                            sLAnnieXMonitor.collectContainerBaseStringField(AccessLayerStringField.ClientComponent, Components.View.getTag());
                        }
                    });
                }
            }
        });
    }

    public final void onLynxModelCreateBegin(String bid, String sessionId) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        onLynxModelCreateBegin(bid, sessionId, AnnieXConstants.ANNIEX_CARD);
    }

    public final void onWebModelCreateBegin(final String bid, final String sessionId, final String viewType) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        TraceEvent.beginSection("web_model_init");
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onWebModelCreateBegin$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3385invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3385invoke() {
                BulletMonitorContext monitorContextWithSessionId;
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                monitorContextWithSessionId = MonitorManager.INSTANCE.monitorContextWithSessionId(sessionId);
                if (!monitorContextWithSessionId.getInUse()) {
                    String str = sessionId;
                    long j = currentTimeMillis;
                    String str2 = bid;
                    monitorContextWithSessionId.init(str, AnnieXConstants.ANNIEX_CARD, Long.valueOf(j));
                    monitorContextWithSessionId.setBid(str2);
                }
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                long j2 = currentTimeMillis;
                String str3 = sessionId;
                timeStampMapWithSessionId.record("prepare_init_data_start", Long.valueOf(j2));
                ContainerStandardMonitorWrapper.INSTANCE.collect(str3, "prepare_init_data_start", Long.valueOf(j2));
                String str4 = sessionId;
                if (!TraceEvent.enableTrace()) {
                    Log.d("AnnieXMonitorManager", "create reportStateMap: " + str4 + ' ');
                }
                map2 = MonitorManager.reportStateMap;
                map2.put(sessionId, new AnnieXMonitorContext());
                String str5 = viewType;
                if (str5 != null) {
                    ContainerStandardMonitorWrapper.INSTANCE.addContext(sessionId, "annie_view_type", str5);
                }
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "container_name", "AnnieX");
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "biz", bid);
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "core_view_type", AnnieXConstants.ANNIEX_CARD);
                SLMonitorCompat sLMonitorCompat = SLMonitorCompat.INSTANCE;
                String str6 = sessionId;
                final String str7 = bid;
                sLMonitorCompat.collectContainerBaseStringField(str6, new Function1<SLAnnieXMonitor, Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onWebModelCreateBegin$1$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SLAnnieXMonitor) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SLAnnieXMonitor sLAnnieXMonitor) {
                        Intrinsics.checkNotNullParameter(sLAnnieXMonitor, "$this$collectContainerBaseStringField");
                        sLAnnieXMonitor.collectContainerBaseStringField(AccessLayerStringField.Biz, str7);
                        sLAnnieXMonitor.collectContainerBaseStringField(AccessLayerStringField.CoreViewType, AnnieXConstants.ANNIEX_CARD);
                    }
                });
                if (Intrinsics.areEqual(viewType, AnnieXConstants.ANNIEX_CARD)) {
                    ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "view_type", AnnieX.CONTAINER_VIEW_TYPE_CARD);
                    ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, SceneDbContract.Scenes.COLUMN_CLIENT_COMPONENT, Components.View.getTag());
                    SLMonitorCompat.INSTANCE.collectContainerBaseStringField(sessionId, new Function1<SLAnnieXMonitor, Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onWebModelCreateBegin$1$1.6
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SLAnnieXMonitor) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SLAnnieXMonitor sLAnnieXMonitor) {
                            Intrinsics.checkNotNullParameter(sLAnnieXMonitor, "$this$collectContainerBaseStringField");
                            sLAnnieXMonitor.collectContainerBaseStringField(AccessLayerStringField.ClientComponent, Components.View.getTag());
                        }
                    });
                }
            }
        });
    }

    public final void onAttachToWindow(final String sessionId, final String url) {
        String str;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        if (enableViewAttachStack) {
            final boolean enableViewAttachWithoutSessionId = SwitchCenter.INSTANCE.getEnableViewAttachWithoutSessionId();
            if (enableViewAttachWithoutSessionId) {
                SceneManager companion = SceneManager.INSTANCE.getInstance();
                if (url == null) {
                    BulletLoadUriIdentifier uriIdentifier = monitorContextWithSessionId(sessionId).getUriIdentifier();
                    str = String.valueOf(uriIdentifier != null ? uriIdentifier.getIdentifierUrl() : null);
                } else {
                    str = url;
                }
                companion.sendViewLoadEvent(sessionId, str);
            }
            safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onAttachToWindow$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m3357invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m3357invoke() {
                    AttachScene attachScene;
                    BulletMonitorContext monitorContextWithSessionId;
                    if (!enableViewAttachWithoutSessionId) {
                        SceneManager companion2 = SceneManager.INSTANCE.getInstance();
                        String str2 = sessionId;
                        String str3 = url;
                        if (str3 == null) {
                            monitorContextWithSessionId = MonitorManager.INSTANCE.monitorContextWithSessionId(sessionId);
                            BulletLoadUriIdentifier uriIdentifier2 = monitorContextWithSessionId.getUriIdentifier();
                            str3 = String.valueOf(uriIdentifier2 != null ? uriIdentifier2.getIdentifierUrl() : null);
                        }
                        companion2.sendViewLoadEvent(str2, str3);
                    }
                    ContainerStandardMonitorWrapper.INSTANCE.addContext(sessionId, "is_attached", DiskLruCache.VERSION);
                    IAnnieXContextProvider iAnnieXContextProvider = (IAnnieXContextProvider) AnnieX.INSTANCE.getService("default_bid", IAnnieXContextProvider.class);
                    if (iAnnieXContextProvider == null || (attachScene = iAnnieXContextProvider.getAttachScene()) == null) {
                        return;
                    }
                    ContainerStandardMonitorWrapper.INSTANCE.addContext(sessionId, SceneDbContract.Scenes.COLUMN_ATTACH_SCENE, attachScene.getScene());
                }
            });
        }
    }

    public final void onClientComponent(final String sessionId, final String viewType) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onClientComponent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3358invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3358invoke() {
                ContainerStandardMonitorWrapper.INSTANCE.addContext(sessionId, "annie_view_type", viewType);
                String str = viewType;
                if (Intrinsics.areEqual(str, Scenes.AnnieXPage.getTag())) {
                    ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "view_type", "page");
                    ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, SceneDbContract.Scenes.COLUMN_CLIENT_COMPONENT, Components.Activity.getTag());
                    SceneManager.INSTANCE.getInstance().markSceneType(sessionId, Components.Activity.getTag());
                    SLMonitorCompat.INSTANCE.collectContainerBaseStringField(sessionId, new Function1<SLAnnieXMonitor, Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onClientComponent$1.1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SLAnnieXMonitor) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SLAnnieXMonitor sLAnnieXMonitor) {
                            Intrinsics.checkNotNullParameter(sLAnnieXMonitor, "$this$collectContainerBaseStringField");
                            sLAnnieXMonitor.collectContainerBaseStringField(AccessLayerStringField.ClientComponent, Components.Activity.getTag());
                        }
                    });
                    return;
                }
                if (Intrinsics.areEqual(str, Scenes.LitePage.getTag())) {
                    ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "view_type", "page");
                    ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, SceneDbContract.Scenes.COLUMN_CLIENT_COMPONENT, Components.DialogFragment.getTag());
                    SceneManager.INSTANCE.getInstance().markSceneType(sessionId, Components.DialogFragment.getTag());
                    SLMonitorCompat.INSTANCE.collectContainerBaseStringField(sessionId, new Function1<SLAnnieXMonitor, Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onClientComponent$1.2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SLAnnieXMonitor) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SLAnnieXMonitor sLAnnieXMonitor) {
                            Intrinsics.checkNotNullParameter(sLAnnieXMonitor, "$this$collectContainerBaseStringField");
                            sLAnnieXMonitor.collectContainerBaseStringField(AccessLayerStringField.ClientComponent, Components.DialogFragment.getTag());
                        }
                    });
                }
            }
        });
    }

    public final void onWebModelCreateBegin(String bid, String sessionId) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        onWebModelCreateBegin(bid, sessionId, AnnieXConstants.ANNIEX_CARD);
    }

    public final void updateUriIdentifier(final String sessionId, final Uri uri) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(uri, "uri");
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$updateUriIdentifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3395invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3395invoke() {
                BulletMonitorContext monitorContextWithSessionId;
                monitorContextWithSessionId = MonitorManager.INSTANCE.monitorContextWithSessionId(sessionId);
                monitorContextWithSessionId.setUriIdentifier(new BulletLoadUriIdentifier(uri));
            }
        });
    }

    public final void onLynxModelCreateEnd(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLynxModelCreateEnd$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3370invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3370invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                DurationMap durationMapWithSessionId;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("prepare_init_data_end", Long.valueOf(currentTimeMillis));
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "prepare_init_data_end", Long.valueOf(currentTimeMillis));
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map2 = MonitorManager.durationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map2, sessionId);
                durationMapWithSessionId.record("schema_convert", Long.valueOf(timeStampMapWithSessionId.computeDuration("prepare_init_data_start", "prepare_init_data_end")));
            }
        });
        TraceEvent.endSection("lynx_model_init");
    }

    public final void onWebModelCreateEnd(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onWebModelCreateEnd$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3386invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3386invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                DurationMap durationMapWithSessionId;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("prepare_init_data_end", Long.valueOf(currentTimeMillis));
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "prepare_init_data_end", Long.valueOf(currentTimeMillis));
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map2 = MonitorManager.durationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map2, sessionId);
                durationMapWithSessionId.record("schema_convert", Long.valueOf(timeStampMapWithSessionId.computeDuration("prepare_init_data_start", "prepare_init_data_end")));
            }
        });
        TraceEvent.endSection("web_model_init");
    }

    public final Map<String, Object> getTimeStampMap$anniex_release(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        TimeStampMap timeStampMap2 = timeStampMap.get(sessionId);
        if (timeStampMap2 == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("open_time", Long.valueOf(timeStampMap2.get("open_time")));
        linkedHashMap.put("container_init_start", Long.valueOf(timeStampMap2.get("container_init_start")));
        linkedHashMap.put("container_init_end", Long.valueOf(timeStampMap2.get("container_init_end")));
        return linkedHashMap;
    }

    public final void onKitViewCreateBegin(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        TraceEvent.beginSection("create_lynxview");
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onKitViewCreateBegin$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3363invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3363invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                long j = currentTimeMillis;
                timeStampMapWithSessionId.record("containerInitTime", Long.valueOf(j));
                timeStampMapWithSessionId.record("prepare_component_start", Long.valueOf(j));
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "prepare_component_start", Long.valueOf(currentTimeMillis));
            }
        });
    }

    public final void markOpenTime(String sessionId, Long timeStamp) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        long longValue = timeStamp != null ? timeStamp.longValue() : System.currentTimeMillis();
        INSTANCE.timeStampMapWithSessionId(timeStampMap, sessionId).record("open_time", Long.valueOf(longValue));
        ContainerStandardApi.INSTANCE.collectLong(sessionId, "open_time", longValue);
    }

    public final void attachNewSessionId(String sessionId, View container, String engineType) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(engineType, "engineType");
        ContainerStandardApi.INSTANCE.attach(sessionId, new ContainerType(container, engineType));
    }

    public final void onWebViewCreateBegin(final String sessionId, final long createBegin) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        TraceEvent.beginSection("create_webview");
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onWebViewCreateBegin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3390invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3390invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                long j = createBegin;
                timeStampMapWithSessionId.record("containerInitTime", Long.valueOf(j));
                timeStampMapWithSessionId.record("prepare_component_start", Long.valueOf(j));
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "prepare_component_start", Long.valueOf(createBegin));
            }
        });
    }

    public final void onLoadStart(final String sessionId, final AnnieXCardScene annieXCardScene) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(annieXCardScene, "annieXCardScene");
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLoadStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3367invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3367invoke() {
                Map map;
                Map map2;
                Map map3;
                if (AnnieXCardScene.this == AnnieXCardScene.NEW || AnnieXCardScene.this == AnnieXCardScene.RELOAD || AnnieXCardScene.this == AnnieXCardScene.REUSE) {
                    map = MonitorManager.reportStateMap;
                    AnnieXMonitorContext annieXMonitorContext = (AnnieXMonitorContext) map.get(sessionId);
                    if (annieXMonitorContext != null) {
                        annieXMonitorContext.setLoadStatus("cancel");
                    }
                    map2 = MonitorManager.reportStateMap;
                    AnnieXMonitorContext annieXMonitorContext2 = (AnnieXMonitorContext) map2.get(sessionId);
                    if (annieXMonitorContext2 == null) {
                        return;
                    }
                    annieXMonitorContext2.setLoadStatus("load_template_start");
                    return;
                }
                if (AnnieXCardScene.this == AnnieXCardScene.RESET_DATA || AnnieXCardScene.this == AnnieXCardScene.UPDATE_DATA || AnnieXCardScene.this == AnnieXCardScene.SSR) {
                    map3 = MonitorManager.reportStateMap;
                    AnnieXMonitorContext annieXMonitorContext3 = (AnnieXMonitorContext) map3.get(sessionId);
                    if (annieXMonitorContext3 == null) {
                        return;
                    }
                    annieXMonitorContext3.setLoadStatus("success");
                }
            }
        });
    }

    public final void onWebLoadStart(final String sessionId, AnnieXCardScene annieXCardScene) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(annieXCardScene, "annieXCardScene");
        onLoadStart(sessionId, annieXCardScene);
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onWebLoadStart$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3384invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3384invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                Map map3;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("page_load", Long.valueOf(currentTimeMillis));
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "prepare_engine_load_start", Long.valueOf(currentTimeMillis));
                map2 = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext = (AnnieXMonitorContext) map2.get(sessionId);
                if (annieXMonitorContext != null) {
                    annieXMonitorContext.setLoadStatus("cancel");
                }
                map3 = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext2 = (AnnieXMonitorContext) map3.get(sessionId);
                if (annieXMonitorContext2 == null) {
                    return;
                }
                annieXMonitorContext2.setLoadStatus("load_template_start");
            }
        });
    }

    public final void onWebLoadEnd(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onWebLoadEnd$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3383invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3383invoke() {
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "prepare_engine_load_end", Long.valueOf(currentTimeMillis));
            }
        });
    }

    public final void onLynxViewReused(final String originalSessionId, final String sessionId, final AnnieXCardScene annieXCardScene) {
        Intrinsics.checkNotNullParameter(originalSessionId, "originalSessionId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(annieXCardScene, "annieXCardScene");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLynxViewReused$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3377invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3377invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                DurationMap durationMapWithSessionId;
                boolean isReloadScene;
                Map map3;
                Map map4;
                BulletRLContext resourceContextWithSessionId;
                BulletRLContext resourceContextWithSessionId2;
                String str = sessionId;
                AnnieXCardScene annieXCardScene2 = annieXCardScene;
                if (!TraceEvent.enableTrace()) {
                    Log.i("AnnieXMonitorManager", str + " onLynxViewReused. isReload: " + annieXCardScene2.getValue());
                }
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                long j = currentTimeMillis;
                AnnieXCardScene annieXCardScene3 = annieXCardScene;
                timeStampMapWithSessionId.record("containerInitTime", Long.valueOf(j));
                timeStampMapWithSessionId.record("prepare_component_start", Long.valueOf(j));
                timeStampMapWithSessionId.record("prepare_component_end", Long.valueOf(j));
                if (annieXCardScene3 != AnnieXCardScene.RELOAD) {
                    timeStampMapWithSessionId.record("read_template_end", Long.valueOf(j));
                }
                ContainerStandardMonitorWrapper containerStandardMonitorWrapper = ContainerStandardMonitorWrapper.INSTANCE;
                String str2 = sessionId;
                long j2 = currentTimeMillis;
                containerStandardMonitorWrapper.collect(str2, "prepare_component_start", Long.valueOf(j2));
                containerStandardMonitorWrapper.collect(str2, "prepare_component_end", Long.valueOf(j2));
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map2 = MonitorManager.durationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map2, sessionId);
                AnnieXCardScene annieXCardScene4 = annieXCardScene;
                durationMapWithSessionId.record("create_lynxview", 0L);
                durationMapWithSessionId.record("jsb_register", 0L);
                if (annieXCardScene4 != AnnieXCardScene.RELOAD) {
                    durationMapWithSessionId.record("download_template", 0L);
                    durationMapWithSessionId.record("read_template", 0L);
                }
                isReloadScene = MonitorManager.INSTANCE.isReloadScene(annieXCardScene);
                if (isReloadScene) {
                    map4 = MonitorManager.reportStateMap;
                    if (map4.containsKey(originalSessionId)) {
                        resourceContextWithSessionId = MonitorManager.INSTANCE.resourceContextWithSessionId(originalSessionId);
                        resourceContextWithSessionId2 = MonitorManager.INSTANCE.resourceContextWithSessionId(sessionId);
                        resourceContextWithSessionId2.setResFrom(resourceContextWithSessionId.getResFrom());
                        resourceContextWithSessionId2.setResVersion(resourceContextWithSessionId.getResVersion());
                        resourceContextWithSessionId2.setResMemory(resourceContextWithSessionId.getResMemory());
                    }
                }
                map3 = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext = (AnnieXMonitorContext) map3.get(sessionId);
                if (annieXMonitorContext != null) {
                    annieXMonitorContext.setScene(annieXCardScene.getValue());
                }
            }
        });
    }

    public final void onKitViewCreateEnd(final LynxView lynxView, final String sessionId) {
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onKitViewCreateEnd$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3364invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3364invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                DurationMap durationMapWithSessionId;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("prepare_component_end", Long.valueOf(currentTimeMillis));
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map2 = MonitorManager.durationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map2, sessionId);
                durationMapWithSessionId.record("create_lynxview", Long.valueOf(timeStampMapWithSessionId.computeDuration("prepare_component_start", "prepare_component_end")));
                ContainerStandardMonitorWrapper containerStandardMonitorWrapper = ContainerStandardMonitorWrapper.INSTANCE;
                String str = sessionId;
                long j = currentTimeMillis;
                View view = lynxView;
                containerStandardMonitorWrapper.collect(str, "prepare_component_end", Long.valueOf(j));
                containerStandardMonitorWrapper.attach(str, view, "lynx");
                SLMonitorCompat.INSTANCE.collectLynxBaseField(sessionId, lynxView);
            }
        });
        TraceEvent.endSection("create_lynxview");
    }

    public final void onWebViewCreateEnd(final WebView webView, final String sessionId, final long timeStamp) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onWebViewCreateEnd$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3391invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3391invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                DurationMap durationMapWithSessionId;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("prepare_component_end", Long.valueOf(timeStamp));
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map2 = MonitorManager.durationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map2, sessionId);
                durationMapWithSessionId.record("create_webview", Long.valueOf(timeStampMapWithSessionId.computeDuration("prepare_component_start", "prepare_component_end")));
                ContainerStandardMonitorWrapper containerStandardMonitorWrapper = ContainerStandardMonitorWrapper.INSTANCE;
                String str = sessionId;
                long j = timeStamp;
                WebView webView2 = webView;
                containerStandardMonitorWrapper.collect(str, "prepare_component_end", Long.valueOf(j));
                containerStandardMonitorWrapper.attach(str, webView2, "web");
                SLMonitorCompat.INSTANCE.collectWebBaseField(sessionId, webView);
            }
        });
        TraceEvent.endSection("create_webview");
    }

    public final void onJsbRegisterBegin(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onJsbRegisterBegin$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3361invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3361invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("jsb_register_start", Long.valueOf(currentTimeMillis));
            }
        });
    }

    public final void onJsbRegisterEnd(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onJsbRegisterEnd$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3362invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3362invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                DurationMap durationMapWithSessionId;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.recordWithOverride("jsb_register_end", Long.valueOf(currentTimeMillis));
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map2 = MonitorManager.durationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map2, sessionId);
                durationMapWithSessionId.record("jsb_register", Long.valueOf(timeStampMapWithSessionId.computeDuration("jsb_register_start", "jsb_register_end")));
            }
        });
    }

    public final void onPageStart(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onPageStart$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3378invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3378invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("lynx_page_start", Long.valueOf(currentTimeMillis));
            }
        });
    }

    public final void onWebPageStart(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onWebPageStart$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3388invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3388invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("page_start", Long.valueOf(currentTimeMillis));
            }
        });
    }

    public final void onWebPageFinish(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onWebPageFinish$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3387invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3387invoke() {
                Map map;
                Map map2;
                Map map3;
                TimeStampMap timeStampMapWithSessionId;
                map = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext = (AnnieXMonitorContext) map.get(sessionId);
                if (annieXMonitorContext != null) {
                    annieXMonitorContext.setLoadStatus("success");
                }
                map2 = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext2 = (AnnieXMonitorContext) map2.get(sessionId);
                if (annieXMonitorContext2 != null) {
                    annieXMonitorContext2.setLoadStage("load_success");
                }
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map3 = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map3, sessionId);
                timeStampMapWithSessionId.record("page_finish", Long.valueOf(currentTimeMillis));
            }
        });
    }

    public final void onLoadSuccess(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLoadSuccess$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3368invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3368invoke() {
                Map map;
                Map map2;
                Map map3;
                TimeStampMap timeStampMapWithSessionId;
                String str = sessionId;
                if (!TraceEvent.enableTrace()) {
                    Log.i("AnnieXMonitorManager", str + " onLoadSuccess");
                }
                map = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext = (AnnieXMonitorContext) map.get(sessionId);
                if (annieXMonitorContext != null) {
                    annieXMonitorContext.setLoadStatus("success");
                }
                map2 = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext2 = (AnnieXMonitorContext) map2.get(sessionId);
                if (annieXMonitorContext2 != null) {
                    annieXMonitorContext2.setLoadStage("load_success");
                }
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map3 = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map3, sessionId);
                timeStampMapWithSessionId.record("lynx_load_success", Long.valueOf(currentTimeMillis));
            }
        });
    }

    public final void onContainerError$anniex_release(final String bid, final String sessionId, final AbsBulletMonitorCallback.ErrStage errStage, final String errMessage) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(errStage, "errStage");
        Intrinsics.checkNotNullParameter(errMessage, "errMessage");
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onContainerError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3359invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3359invoke() {
                Map map;
                String errorStageMsg;
                map = MonitorManager.reportStateMap;
                String str = sessionId;
                AnnieXMonitorContext annieXMonitorContext = new AnnieXMonitorContext();
                AbsBulletMonitorCallback.ErrStage errStage2 = errStage;
                String str2 = errMessage;
                annieXMonitorContext.setLoadStatus("fail");
                annieXMonitorContext.setUnifyErrorDomain(UnifyErrorDomain.AnnieXUnifyErrorDomainContainerInit.getErrorDomain());
                errorStageMsg = MonitorManager.INSTANCE.getErrorStageMsg(errStage2);
                annieXMonitorContext.setLoadStage(errorStageMsg);
                annieXMonitorContext.setEndToEndErrorMessage(str2);
                map.put(str, annieXMonitorContext);
                MonitorManager.INSTANCE.reportEndToEndTrace(bid, sessionId);
            }
        });
    }

    public final void onFirstScreen(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onFirstScreen$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3360invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3360invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                DurationMap durationMapWithSessionId;
                AtomicInteger callbackCountWithSessionId;
                String str = sessionId;
                if (!TraceEvent.enableTrace()) {
                    Log.i("AnnieXMonitorManager", str + ":onFirstScreen");
                }
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("lynx_first_screen", Long.valueOf(currentTimeMillis));
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map2 = MonitorManager.durationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map2, sessionId);
                durationMapWithSessionId.record("lynx_render", Long.valueOf(timeStampMapWithSessionId.computeDuration("render_template_start", "lynx_first_screen")));
                durationMapWithSessionId.record("first_screen", Long.valueOf(timeStampMapWithSessionId.computeDuration("containerInitTime", "lynx_first_screen")));
                callbackCountWithSessionId = MonitorManager.INSTANCE.callbackCountWithSessionId(sessionId);
                callbackCountWithSessionId.addAndGet(2);
                MonitorManager.INSTANCE.onSetup(sessionId);
            }
        });
    }

    public final void onTimingSetup(final String sessionId, final Map<String, Object> timingInfo, final LynxDevtool lynxDevtool) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onTimingSetup$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3381invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3381invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                DurationMap durationMapWithSessionId;
                AtomicInteger callbackCountWithSessionId;
                BulletMonitorContext monitorContextWithSessionId;
                Method devtoolReportFunction2;
                String str = sessionId;
                if (!TraceEvent.enableTrace()) {
                    Log.i("AnnieXMonitorManager", str + " onTimingSetup");
                }
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.lynxTimeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map2 = MonitorManager.lynxDurationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map2, sessionId);
                TimelineHelper.INSTANCE.collectSetupLynxTiming(timingInfo, timeStampMapWithSessionId, durationMapWithSessionId);
                callbackCountWithSessionId = MonitorManager.INSTANCE.callbackCountWithSessionId(sessionId);
                callbackCountWithSessionId.addAndGet(1);
                MonitorManager.INSTANCE.onSetup(sessionId);
                monitorContextWithSessionId = MonitorManager.INSTANCE.monitorContextWithSessionId(sessionId);
                monitorContextWithSessionId.inject((JSONObject) null, TimelineHelper.INSTANCE.getTracertMetric(timeStampMapWithSessionId, durationMapWithSessionId));
                final LynxDevtool lynxDevtool2 = lynxDevtool;
                final String str2 = sessionId;
                if (TraceEvent.enableTrace() || lynxDevtool2 == null || lynxDevtool2.getBaseInspectorOwner() == null) {
                    return;
                }
                devtoolReportFunction2 = MonitorManager.INSTANCE.getDevtoolReportFunction();
                if (devtoolReportFunction2 != null) {
                    MonitorManager.reportInfo$default(MonitorManager.INSTANCE, str2, false, new Function1<ReportInfo, Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onTimingSetup$1$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ReportInfo) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ReportInfo reportInfo) {
                            Method devtoolReportFunction3;
                            Intrinsics.checkNotNullParameter(reportInfo, "tracertTimeline");
                            try {
                                JSONObject metrics = reportInfo.getMetrics();
                                if (metrics != null) {
                                    LynxDevtool lynxDevtool3 = lynxDevtool2;
                                    String str3 = str2;
                                    devtoolReportFunction3 = MonitorManager.INSTANCE.getDevtoolReportFunction();
                                    if (devtoolReportFunction3 != null) {
                                        devtoolReportFunction3.invoke(lynxDevtool3, reportInfo.getEventName(), metrics);
                                    }
                                    Log.d("AnnieXMonitorManager", "Report info to lynx devtool " + str3 + " : " + metrics);
                                }
                            } catch (Throwable th) {
                                Log.e("AnnieXMonitorManager", "Report with LynxDevtool.onPerfMetricsEvent failed, e: " + th);
                            }
                        }
                    }, null, false, 10, null);
                }
            }
        });
    }

    public final void onTimingUpdate(final String sessionId, final Map<String, Object> timingInfo, final Map<String, Long> updateTiming, final String flag) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onTimingUpdate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3382invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3382invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                DurationMap durationMapWithSessionId;
                AtomicInteger callbackCountWithSessionId;
                Map map3;
                BulletMonitorContext monitorContextWithSessionId;
                String str = sessionId;
                if (!TraceEvent.enableTrace()) {
                    Log.i("AnnieXMonitorManager", str + " onTimingUpdate");
                }
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.lynxTimeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map2 = MonitorManager.lynxDurationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map2, sessionId);
                TimelineHelper.INSTANCE.collectSetupLynxTiming(timingInfo, timeStampMapWithSessionId, durationMapWithSessionId);
                TimelineHelper.INSTANCE.collectUpdateLynxTiming(timingInfo, updateTiming, timeStampMapWithSessionId, durationMapWithSessionId);
                TimelineHelper.INSTANCE.collectUpdateLynxTimingForIBulletPerf(timingInfo, updateTiming, timeStampMapWithSessionId, durationMapWithSessionId);
                callbackCountWithSessionId = MonitorManager.INSTANCE.callbackCountWithSessionId(sessionId);
                callbackCountWithSessionId.addAndGet(1);
                MonitorManager.INSTANCE.onUpdate(sessionId, flag);
                map3 = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext = (AnnieXMonitorContext) map3.get(sessionId);
                if (annieXMonitorContext != null) {
                    annieXMonitorContext.setLoadStage("data_update");
                }
                MonitorManager.reportEndToEndTrace$default(MonitorManager.INSTANCE, null, sessionId, 1, null);
                monitorContextWithSessionId = MonitorManager.INSTANCE.monitorContextWithSessionId(sessionId);
                monitorContextWithSessionId.inject((JSONObject) null, TimelineHelper.INSTANCE.getTracertMetric(timeStampMapWithSessionId, durationMapWithSessionId));
            }
        });
    }

    public final void onPrepareTemplateBegin(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        TraceEvent.beginSection("resource_load");
        TraceEvent.beginSection("download_template");
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onPrepareTemplateBegin$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3379invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3379invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                Map map3;
                DurationMap durationMapWithSessionId;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("prepare_template_start", Long.valueOf(currentTimeMillis));
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "prepare_template_start", Long.valueOf(currentTimeMillis));
                ContainerStandardMonitorWrapper.INSTANCE.addContext(sessionId, "enableForest", DiskLruCache.VERSION);
                map2 = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext = (AnnieXMonitorContext) map2.get(sessionId);
                if (annieXMonitorContext != null) {
                    annieXMonitorContext.setLoadStage("load_template_start");
                }
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map3 = MonitorManager.durationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map3, sessionId);
                durationMapWithSessionId.record("kitcreate_to_rl", Long.valueOf(timeStampMapWithSessionId.computeDuration("prepare_component_end", "prepare_template_start")));
            }
        });
    }

    public final void onWebPrepareTemplateEnd(final String sessionId, final BulletRLContext rlContext) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(rlContext, "rlContext");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onWebPrepareTemplateEnd$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3389invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3389invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                BulletRLContext resourceContextWithSessionId;
                Map map3;
                DurationMap durationMapWithSessionId;
                BulletRLContext resourceContextWithSessionId2;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("prepare_template_end", Long.valueOf(currentTimeMillis));
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "prepare_template_end", Long.valueOf(currentTimeMillis));
                map2 = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext = (AnnieXMonitorContext) map2.get(sessionId);
                if (annieXMonitorContext != null) {
                    annieXMonitorContext.setLoadStage("load_template_end");
                }
                resourceContextWithSessionId = MonitorManager.INSTANCE.resourceContextWithSessionId(sessionId);
                resourceContextWithSessionId.setResFrom(rlContext.getResFrom());
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map3 = MonitorManager.durationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map3, sessionId);
                durationMapWithSessionId.record("download_template", Long.valueOf(timeStampMapWithSessionId.computeDuration("prepare_template_start", "prepare_template_end")));
                resourceContextWithSessionId2 = MonitorManager.INSTANCE.resourceContextWithSessionId(sessionId);
                SLMonitorCompat.INSTANCE.collectResourceField(sessionId, resourceContextWithSessionId2.getResVersion(), resourceContextWithSessionId2.getResFrom());
            }
        });
        TraceEvent.endSection("download_template");
    }

    public final void onPrepareTemplateEnd(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onPrepareTemplateEnd$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3380invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3380invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                Map map3;
                DurationMap durationMapWithSessionId;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("prepare_template_end", Long.valueOf(currentTimeMillis));
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "prepare_template_end", Long.valueOf(currentTimeMillis));
                map2 = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext = (AnnieXMonitorContext) map2.get(sessionId);
                if (annieXMonitorContext != null) {
                    annieXMonitorContext.setLoadStage("load_template_end");
                }
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map3 = MonitorManager.durationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map3, sessionId);
                durationMapWithSessionId.record("download_template", Long.valueOf(timeStampMapWithSessionId.computeDuration("prepare_template_start", "prepare_template_end")));
            }
        });
        TraceEvent.endSection("download_template");
    }

    public final void onLynxReadTemplateBegin(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLynxReadTemplateBegin$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3371invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3371invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("read_template_start", Long.valueOf(currentTimeMillis));
            }
        });
        TraceEvent.beginSection("read_template");
    }

    public final void onLynxReadTemplateEnd(final String sessionId, final ResourceInfo response, final String customResFrom, final long resVersion, final double resSize) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(customResFrom, "customResFrom");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLynxReadTemplateEnd$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3372invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3372invoke() {
                BulletRLContext resourceContextWithSessionId;
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                DurationMap durationMapWithSessionId;
                BulletRLContext resourceContextWithSessionId2;
                BulletRLContext resourceContextWithSessionId3;
                ResourceInfo resourceInfo = response;
                if (resourceInfo != null) {
                    String statisticFrom = resourceInfo.getStatisticFrom();
                    long version = response.getVersion();
                    boolean isFromMemory = response.isFromMemory();
                    ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "template_res_type", statisticFrom);
                    resourceContextWithSessionId3 = MonitorManager.INSTANCE.resourceContextWithSessionId(sessionId);
                    ResourceInfo resourceInfo2 = response;
                    resourceContextWithSessionId3.setResFrom(statisticFrom);
                    resourceContextWithSessionId3.setResVersion(version);
                    resourceContextWithSessionId3.setResMemory(isFromMemory);
                    resourceContextWithSessionId3.setResSize(resourceInfo2.provideByteArray() != null ? MathKt.roundToInt((r6.length / 1024.0d) * 100) / 100.0d : 0.0d);
                    if (!TraceEvent.enableTrace()) {
                        Log.i("onLynxReadTemplateEnd", "sourceUri: " + resourceInfo2.getSrcUri() + ", resFrom: " + statisticFrom + ", resVersion: " + version + ", resMemory: " + isFromMemory + "，resSize: " + resourceContextWithSessionId3.getResSize());
                    }
                } else {
                    ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "template_res_type", customResFrom);
                    resourceContextWithSessionId = MonitorManager.INSTANCE.resourceContextWithSessionId(sessionId);
                    String str = customResFrom;
                    long j = resVersion;
                    double d = resSize;
                    resourceContextWithSessionId.setResFrom(str);
                    resourceContextWithSessionId.setResVersion(j);
                    resourceContextWithSessionId.setResMemory(true);
                    resourceContextWithSessionId.setResSize(d);
                }
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("read_template_end", Long.valueOf(currentTimeMillis));
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map2 = MonitorManager.durationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map2, sessionId);
                durationMapWithSessionId.record("read_template", Long.valueOf(timeStampMapWithSessionId.computeDuration("prepare_template_end", "read_template_end")));
                durationMapWithSessionId.record("resource_load", Long.valueOf(timeStampMapWithSessionId.computeDuration("prepare_template_start", "read_template_end")));
                resourceContextWithSessionId2 = MonitorManager.INSTANCE.resourceContextWithSessionId(sessionId);
                SLMonitorCompat.INSTANCE.collectResourceField(sessionId, resourceContextWithSessionId2.getResVersion(), resourceContextWithSessionId2.getResFrom());
            }
        });
        TraceEvent.endSection("read_template");
        TraceEvent.endSection("resource_load");
        TraceEvent.beginSection("rl_to_render");
    }

    public final void onLynxViewAsyncLayoutBegin(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLynxViewAsyncLayoutBegin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3375invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3375invoke() {
                BulletMonitorContext monitorContextWithSessionId;
                monitorContextWithSessionId = MonitorManager.INSTANCE.monitorContextWithSessionId(sessionId);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lynx_is_async_layout", true);
                monitorContextWithSessionId.inject(jSONObject, (JSONObject) null);
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "lynx_is_async_layout", true);
            }
        });
    }

    public final void onLynxViewAsyncLayoutEnd(final String sessionId, final boolean success) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLynxViewAsyncLayoutEnd$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3376invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3376invoke() {
                BulletMonitorContext monitorContextWithSessionId;
                monitorContextWithSessionId = MonitorManager.INSTANCE.monitorContextWithSessionId(sessionId);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lynx_async_layout_result", success);
                monitorContextWithSessionId.inject(jSONObject, (JSONObject) null);
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "lynx_async_layout_result", Boolean.valueOf(success));
            }
        });
    }

    public final void onLynxRenderTemplateBegin(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLynxRenderTemplateBegin$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3373invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3373invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                DurationMap durationMapWithSessionId;
                AtomicInteger callbackCountWithSessionId;
                ContainerStandardMonitorWrapper.INSTANCE.collect(sessionId, "engineview_render_start", Long.valueOf(currentTimeMillis));
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("render_template_start", Long.valueOf(currentTimeMillis));
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map2 = MonitorManager.durationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map2, sessionId);
                durationMapWithSessionId.record("rl_to_render", Long.valueOf(timeStampMapWithSessionId.computeDuration("read_template_end", "render_template_start")));
                durationMapWithSessionId.record("create_to_start_render", Long.valueOf(timeStampMapWithSessionId.computeDuration("containerInitTime", "render_template_start")));
                callbackCountWithSessionId = MonitorManager.INSTANCE.callbackCountWithSessionId(sessionId);
                callbackCountWithSessionId.set(0);
            }
        });
        TraceEvent.endSection("rl_to_render");
    }

    public final void onLynxRenderTemplateEnd(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final long currentTimeMillis = System.currentTimeMillis();
        INSTANCE.safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLynxRenderTemplateEnd$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3374invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3374invoke() {
                Map map;
                TimeStampMap timeStampMapWithSessionId;
                Map map2;
                DurationMap durationMapWithSessionId;
                MonitorManager monitorManager = MonitorManager.INSTANCE;
                map = MonitorManager.timeStampMap;
                timeStampMapWithSessionId = monitorManager.timeStampMapWithSessionId(map, sessionId);
                timeStampMapWithSessionId.record("render_template_end", Long.valueOf(currentTimeMillis));
                MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                map2 = MonitorManager.durationMap;
                durationMapWithSessionId = monitorManager2.durationMapWithSessionId(map2, sessionId);
                durationMapWithSessionId.record("render_template_main", Long.valueOf(timeStampMapWithSessionId.computeDuration("render_template_start", "render_template_end")));
            }
        });
    }

    public static /* synthetic */ void reportInfo$default(MonitorManager monitorManager, String str, boolean z, Function1 function1, KitType kitType, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        boolean z3 = z;
        if ((i & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if ((i & 8) != 0) {
            kitType = KitType.LYNX;
        }
        KitType kitType2 = kitType;
        if ((i & 16) != 0) {
            z2 = true;
        }
        monitorManager.reportInfo(str, z3, function12, kitType2, z2);
    }

    public final void reportInfo(final String sessionId, final boolean forceReport, final Function1<? super ReportInfo, Unit> customReport, final KitType kitType, final boolean reportEndToEndTrace) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$reportInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3394invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3394invoke() {
                Map map;
                Map map2;
                BulletMonitorContext monitorContextWithSessionId;
                BulletRLContext resourceContextWithSessionId;
                BulletMonitorContext monitorContextWithSessionId2;
                BulletRLContext resourceContextWithSessionId2;
                Map map3;
                TimeStampMap timeStampMapWithSessionId;
                Map map4;
                DurationMap durationMapWithSessionId;
                Map map5;
                DurationMap durationMapWithSessionId2;
                map = MonitorManager.reportStateMap;
                if (!map.containsKey(sessionId)) {
                    String str = sessionId;
                    if (TraceEvent.enableTrace()) {
                        return;
                    }
                    Log.d("AnnieXMonitorManager", "onReport: " + str + " is Not existed");
                    return;
                }
                if (reportEndToEndTrace) {
                    MonitorManager.reportEndToEndTrace$default(MonitorManager.INSTANCE, null, sessionId, 1, null);
                }
                map2 = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext = (AnnieXMonitorContext) map2.get(sessionId);
                if (annieXMonitorContext != null) {
                    boolean z = forceReport;
                    String str2 = sessionId;
                    KitType kitType2 = kitType;
                    Function1<ReportInfo, Unit> function1 = customReport;
                    if (!TraceEvent.enableTrace()) {
                        Log.d("AnnieXMonitorManager", str2 + ": hasReported:" + annieXMonitorContext.getHasReported() + ", loadStatus:" + annieXMonitorContext.getLoadStatus() + ", forceReport: " + z);
                    }
                    if (annieXMonitorContext.getHasReported() || !Intrinsics.areEqual(annieXMonitorContext.getLoadStatus(), "success")) {
                        if (function1 == null) {
                            if (!annieXMonitorContext.getHasReported() && Intrinsics.areEqual(annieXMonitorContext.getLoadStatus(), "cancel")) {
                                ReliabilityReporter reliabilityReporter = ReliabilityReporter.INSTANCE;
                                monitorContextWithSessionId = MonitorManager.INSTANCE.monitorContextWithSessionId(str2);
                                resourceContextWithSessionId = MonitorManager.INSTANCE.resourceContextWithSessionId(str2);
                                reliabilityReporter.reportLoadCancel(monitorContextWithSessionId, resourceContextWithSessionId, AnnieXConstants.ANNIEX_CARD);
                            }
                            annieXMonitorContext.setHasReported(true);
                            return;
                        }
                        return;
                    }
                    if (annieXMonitorContext.getScene().equals("new") && !z) {
                        MonitorManager monitorManager = MonitorManager.INSTANCE;
                        map5 = MonitorManager.lynxDurationMap;
                        durationMapWithSessionId2 = monitorManager.durationMapWithSessionId(map5, str2);
                        if (!durationMapWithSessionId2.hasKey("layout") && !durationMapWithSessionId2.hasKey("layout_ssr")) {
                            if (TraceEvent.enableTrace()) {
                                return;
                            }
                            Log.d("AnnieXMonitorManager", str2 + ": has no timing info. report later");
                            return;
                        }
                    }
                    if (!TraceEvent.enableTrace()) {
                        Log.d("AnnieXMonitorManager", str2 + " reportInfo");
                    }
                    monitorContextWithSessionId2 = MonitorManager.INSTANCE.monitorContextWithSessionId(str2);
                    resourceContextWithSessionId2 = MonitorManager.INSTANCE.resourceContextWithSessionId(str2);
                    MonitorManager monitorManager2 = MonitorManager.INSTANCE;
                    map3 = MonitorManager.timeStampMap;
                    timeStampMapWithSessionId = monitorManager2.timeStampMapWithSessionId(map3, str2);
                    TimelineReporter timelineReporter = TimelineReporter.INSTANCE;
                    MonitorManager monitorManager3 = MonitorManager.INSTANCE;
                    map4 = MonitorManager.durationMap;
                    durationMapWithSessionId = monitorManager3.durationMapWithSessionId(map4, str2);
                    ReportInfo timelineInfo = timelineReporter.getTimelineInfo(monitorContextWithSessionId2, resourceContextWithSessionId2, timeStampMapWithSessionId, durationMapWithSessionId, AnnieXConstants.ANNIEX_CARD, annieXMonitorContext.getScene(), kitType2);
                    monitorContextWithSessionId2.inject(timelineInfo.getCategory(), timelineInfo.getMetrics());
                    ReportInfo userFirstScreenInfo = TimelineReporter.INSTANCE.getUserFirstScreenInfo(monitorContextWithSessionId2, resourceContextWithSessionId2, timeStampMapWithSessionId);
                    ReportInfo tracertTimelineInfo = TimelineReporter.INSTANCE.getTracertTimelineInfo(monitorContextWithSessionId2);
                    if (function1 == null) {
                        TimelineReporter.INSTANCE.reportTimeline(monitorContextWithSessionId2, timelineInfo, userFirstScreenInfo, tracertTimelineInfo);
                        annieXMonitorContext.setHasReported(true);
                    } else {
                        function1.invoke(tracertTimelineInfo);
                    }
                }
            }
        });
    }

    public final void removeMonitorInfo(final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$removeMonitorInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3392invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3392invoke() {
                Map map;
                Map map2;
                Map map3;
                Map map4;
                Map map5;
                Map map6;
                Map map7;
                Map map8;
                Log.d("AnnieXMonitorManager", sessionId + ":removeMonitorInfo");
                map = MonitorManager.timeStampMap;
                map.remove(sessionId);
                map2 = MonitorManager.durationMap;
                map2.remove(sessionId);
                map3 = MonitorManager.lynxTimeStampMap;
                map3.remove(sessionId);
                map4 = MonitorManager.lynxDurationMap;
                map4.remove(sessionId);
                map5 = MonitorManager.updateLynxTimeStampMap;
                map5.remove(sessionId);
                map6 = MonitorManager.callbackCountMap;
                map6.remove(sessionId);
                map7 = MonitorManager.monitorContextMap;
                map7.remove(sessionId);
                map8 = MonitorManager.reportStateMap;
                map8.remove(sessionId);
                SLMonitorCompat.INSTANCE.releaseMonitor(sessionId);
            }
        });
        CopyOnWriteArraySet<String> copyOnWriteArraySet = ignoreSession;
        if (copyOnWriteArraySet.contains(sessionId)) {
            ContainerStandardApi.INSTANCE.invalidateID(sessionId);
            copyOnWriteArraySet.remove(sessionId);
        }
    }

    public final Long getTimeStamp(String sessionId, String key) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(key, "key");
        TimeStampMap timeStampMap2 = timeStampMap.get(sessionId);
        if (timeStampMap2 != null) {
            return Long.valueOf(timeStampMap2.get(key));
        }
        return null;
    }

    public static /* synthetic */ void reportEndToEndTraceWithSafeAction$anniex_release$default(MonitorManager monitorManager, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        monitorManager.reportEndToEndTraceWithSafeAction$anniex_release(str, str2);
    }

    public final void reportEndToEndTraceWithSafeAction$anniex_release(final String bid, final String sessionId) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$reportEndToEndTraceWithSafeAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3393invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3393invoke() {
                Map map;
                map = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext = (AnnieXMonitorContext) map.get(sessionId);
                if (annieXMonitorContext != null) {
                    annieXMonitorContext.setLoadStage("data_update");
                }
                MonitorManager.INSTANCE.reportEndToEndTrace(bid, sessionId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void reportEndToEndTrace$default(MonitorManager monitorManager, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        monitorManager.reportEndToEndTrace(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportEndToEndTrace(String bid, String sessionId) {
        String str;
        MonitorManager monitorManager;
        String str2;
        int i;
        if (IConditionCallKt.enableAnnieXEndToEndReport()) {
            Map<String, AnnieXMonitorContext> map = reportStateMap;
            AnnieXMonitorContext annieXMonitorContext = map.get(sessionId);
            if (annieXMonitorContext != null && annieXMonitorContext.getEndToEndReported()) {
                return;
            }
            AnnieXMonitorContext annieXMonitorContext2 = map.get(sessionId);
            if (annieXMonitorContext2 != null) {
                annieXMonitorContext2.setEndToEndReported(true);
            }
            EngineInfo unifyInfo = ContainerStandardApi.INSTANCE.getUnifyInfo(sessionId);
            if (unifyInfo.getUnifyError().getUnifyErrorDomain() != UnifyErrorDomain.AnnieXUnifyErrorDomainReserved.getErrorDomain()) {
                i = unifyInfo.getUnifyError().getUnifyErrorCode();
                str2 = unifyInfo.getUnifyError().getUnifyErrorMsg();
                monitorManager = this;
            } else {
                AnnieXMonitorContext annieXMonitorContext3 = map.get(sessionId);
                int unifyErrorDomain = annieXMonitorContext3 != null ? annieXMonitorContext3.getUnifyErrorDomain() : 0;
                AnnieXMonitorContext annieXMonitorContext4 = map.get(sessionId);
                if (annieXMonitorContext4 == null || (str = annieXMonitorContext4.getEndToEndErrorMessage()) == null) {
                    str = "";
                }
                monitorManager = this;
                int i2 = unifyErrorDomain;
                str2 = str;
                i = i2;
            }
            BulletRLContext resourceContextWithSessionId = monitorManager.resourceContextWithSessionId(sessionId);
            ReportInfo reportInfo = new ReportInfo("bdx_monitor_end_to_end_trace", (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Boolean) null, (JSONObject) null, (JSONObject) null, 254, (DefaultConstructorMarker) null);
            MonitorManager monitorManager2 = INSTANCE;
            reportInfo.setPageIdentifier(monitorManager2.monitorContextWithSessionId(sessionId).getUriIdentifier());
            JSONObject jSONObject = new JSONObject();
            AnnieXMonitorContext annieXMonitorContext5 = map.get(sessionId);
            String loadStatus = annieXMonitorContext5 != null ? annieXMonitorContext5.getLoadStatus() : null;
            AnnieXMonitorContext annieXMonitorContext6 = map.get(sessionId);
            jSONObject.put("stage", annieXMonitorContext6 != null ? annieXMonitorContext6.getLoadStage() : null);
            jSONObject.put("status", loadStatus);
            jSONObject.put("error_message", str2);
            jSONObject.put("template_res_type", resourceContextWithSessionId.getResFrom());
            jSONObject.put("domain_error_code", i);
            reportInfo.setCategory(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("stay_duration", monitorManager2.getStayDuration(sessionId));
            jSONObject2.put("native_error_count", unifyInfo.getNativeErrorCount());
            jSONObject2.put("res_loader_error_count", unifyInfo.getResLoaderErrorTemplateCount());
            jSONObject2.put("res_loader_error_template_count", unifyInfo.getResLoaderErrorTemplateCount());
            jSONObject2.put("static_error_count", unifyInfo.getStaticCount());
            jSONObject2.put("fetch_error_count", unifyInfo.getFetchErrorCount());
            jSONObject2.put("jsb_error_count", unifyInfo.getJsbErrorCount());
            jSONObject2.put("js_exception_error_count", unifyInfo.getJsExceptionCount());
            reportInfo.setMetrics(jSONObject2);
            reportInfo.setMonitorId(sessionId);
            IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get("default_bid", IMonitorReportService.class);
            if (iMonitorReportService != null) {
                iMonitorReportService.report(reportInfo);
            }
        }
    }

    private final long getStayDuration(String sessionId) {
        long j = timeStampMapWithSessionId(timeStampMap, sessionId).get("open_time");
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getErrorStageMsg(AbsBulletMonitorCallback.ErrStage errStage) {
        int i = WhenMappings.$EnumSwitchMapping$0[errStage.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "load_fail" : "load_engine_fail" : "load_template_fail" : "load_plugin_fail" : "load_container_fail";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TimeStampMap timeStampMapWithSessionId(Map<String, TimeStampMap> sourceMap, String sessionId) {
        if (sourceMap.containsKey(sessionId)) {
            TimeStampMap timeStampMap2 = sourceMap.get(sessionId);
            Intrinsics.checkNotNull(timeStampMap2);
            return timeStampMap2;
        }
        TimeStampMap timeStampMap3 = new TimeStampMap();
        sourceMap.put(sessionId, timeStampMap3);
        return timeStampMap3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DurationMap durationMapWithSessionId(Map<String, DurationMap> sourceMap, String sessionId) {
        if (sourceMap.containsKey(sessionId)) {
            DurationMap durationMap2 = sourceMap.get(sessionId);
            Intrinsics.checkNotNull(durationMap2);
            return durationMap2;
        }
        DurationMap durationMap3 = new DurationMap();
        sourceMap.put(sessionId, durationMap3);
        return durationMap3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AtomicInteger callbackCountWithSessionId(String sessionId) {
        Map<String, AtomicInteger> map = callbackCountMap;
        if (map.containsKey(sessionId)) {
            AtomicInteger atomicInteger = map.get(sessionId);
            Intrinsics.checkNotNull(atomicInteger);
            return atomicInteger;
        }
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
        map.put(sessionId, atomicInteger2);
        return atomicInteger2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BulletMonitorContext monitorContextWithSessionId(String sessionId) {
        Map<String, BulletMonitorContext> map = monitorContextMap;
        if (map.containsKey(sessionId)) {
            BulletMonitorContext bulletMonitorContext = map.get(sessionId);
            Intrinsics.checkNotNull(bulletMonitorContext);
            return bulletMonitorContext;
        }
        BulletMonitorContext bulletMonitorContext2 = new BulletMonitorContext(sessionId);
        bulletMonitorContext2.setSessionId(sessionId);
        map.put(sessionId, bulletMonitorContext2);
        return bulletMonitorContext2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BulletRLContext resourceContextWithSessionId(String sessionId) {
        Map<String, BulletRLContext> map = resourceContextMap;
        if (map.containsKey(sessionId)) {
            BulletRLContext bulletRLContext = map.get(sessionId);
            Intrinsics.checkNotNull(bulletRLContext);
            return bulletRLContext;
        }
        BulletRLContext bulletRLContext2 = new BulletRLContext();
        map.put(sessionId, bulletRLContext2);
        return bulletRLContext2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSetup(String sessionId) {
        IBulletPerfClient iBulletPerfClient;
        if (callbackCountWithSessionId(sessionId).get() <= 2 || (iBulletPerfClient = (IBulletPerfClient) ContextProviderManager.INSTANCE.getProviderFactory(sessionId).provideInstance(IBulletPerfClient.class)) == null) {
            return;
        }
        TimelineHelper timelineHelper = TimelineHelper.INSTANCE;
        MonitorManager monitorManager = INSTANCE;
        JSONObject assemblePerfMetric = timelineHelper.assemblePerfMetric(monitorManager.timeStampMapWithSessionId(lynxTimeStampMap, sessionId), monitorManager.durationMapWithSessionId(lynxDurationMap, sessionId));
        JSONObject assemblePerfMetric2 = TimelineHelper.INSTANCE.assemblePerfMetric(monitorManager.timeStampMapWithSessionId(timeStampMap, sessionId), monitorManager.durationMapWithSessionId(durationMap, sessionId));
        iBulletPerfClient.onSetup(assemblePerfMetric, assemblePerfMetric2);
        if (TraceEvent.enableTrace()) {
            return;
        }
        Log.i(TAG, sessionId + " IBulletPerfClient onSetup: " + assemblePerfMetric);
        Log.i(TAG, sessionId + " IBulletPerfClient onSetup: " + assemblePerfMetric2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUpdate(String sessionId, String flag) {
        IBulletPerfClient iBulletPerfClient;
        AtomicInteger callbackCountWithSessionId = callbackCountWithSessionId(sessionId);
        if (!TraceEvent.enableTrace()) {
            Log.i(TAG, sessionId + " onUpdate " + callbackCountWithSessionId.get());
        }
        if (callbackCountWithSessionId.get() <= 2 || (iBulletPerfClient = (IBulletPerfClient) ContextProviderManager.INSTANCE.getProviderFactory(sessionId).provideInstance(IBulletPerfClient.class)) == null) {
            return;
        }
        TimelineHelper timelineHelper = TimelineHelper.INSTANCE;
        MonitorManager monitorManager = INSTANCE;
        JSONObject assemblePerfMetric = timelineHelper.assemblePerfMetric(monitorManager.timeStampMapWithSessionId(updateLynxTimeStampMap, sessionId), monitorManager.durationMapWithSessionId(updateLynxDurationMap, sessionId));
        JSONObject assemblePerfMetric2 = TimelineHelper.INSTANCE.assemblePerfMetric(monitorManager.timeStampMapWithSessionId(timeStampMap, sessionId), monitorManager.durationMapWithSessionId(durationMap, sessionId));
        iBulletPerfClient.onUpdate(assemblePerfMetric, assemblePerfMetric2, flag);
        if (TraceEvent.enableTrace()) {
            return;
        }
        Log.i(TAG, "IBulletPerfClient onUpdate: " + assemblePerfMetric);
        Log.i(TAG, "IBulletPerfClient onUpdate: " + assemblePerfMetric2);
    }

    private final void safeAction(String sessionId, final Function0<Unit> block) {
        if (ignoreSession.contains(sessionId)) {
            return;
        }
        getHandler().post(new Runnable() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$safeAction$1
            @Override // java.lang.Runnable
            public final void run() {
                block.invoke();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isReloadScene(AnnieXCardScene annieXCardScene) {
        return annieXCardScene == AnnieXCardScene.REUSE || annieXCardScene == AnnieXCardScene.UPDATE_DATA || annieXCardScene == AnnieXCardScene.RESET_DATA;
    }

    public final void onLoadFail(final String bid, final String sessionId, final AbsBulletMonitorCallback.ErrStage errStage, final String errMessage, final LynxView lynxView) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(errStage, "errStage");
        Intrinsics.checkNotNullParameter(errMessage, "errMessage");
        if (!TraceEvent.enableTrace()) {
            Log.e(TAG, sessionId + " onLoadError " + errStage + ", " + errMessage);
        }
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLoadFail$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3365invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3365invoke() {
                Map map;
                Map map2;
                BulletMonitorContext monitorContextWithSessionId;
                BulletRLContext resourceContextWithSessionId;
                String errorStageMsg;
                ContainerStandardMonitor containerStandardMonitor = ContainerStandardMonitor.INSTANCE;
                String str = bid;
                View view = lynxView;
                String str2 = sessionId;
                String str3 = errMessage;
                IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(str, IMonitorReportService.class);
                if (iMonitorReportService == null) {
                    iMonitorReportService = (IMonitorReportService) MonitorReportService.Companion.getFallbackDefault();
                }
                MonitorConfig monitorConfig = iMonitorReportService.getMonitorConfig();
                View view2 = view;
                String bizTag = monitorConfig.getBizTag();
                if (bizTag == null) {
                    bizTag = "";
                }
                String virtualAID = monitorConfig.getVirtualAID();
                containerStandardMonitor.reportError(view2, str2, -1, str3, bizTag, virtualAID != null ? virtualAID : "");
                map = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext = (AnnieXMonitorContext) map.get(sessionId);
                if (annieXMonitorContext != null) {
                    annieXMonitorContext.setLoadStatus("fail");
                }
                map2 = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext2 = (AnnieXMonitorContext) map2.get(sessionId);
                if (annieXMonitorContext2 != null) {
                    errorStageMsg = MonitorManager.INSTANCE.getErrorStageMsg(errStage);
                    annieXMonitorContext2.setLoadStage(errorStageMsg);
                }
                ReliabilityReporter reliabilityReporter = ReliabilityReporter.INSTANCE;
                monitorContextWithSessionId = MonitorManager.INSTANCE.monitorContextWithSessionId(sessionId);
                resourceContextWithSessionId = MonitorManager.INSTANCE.resourceContextWithSessionId(sessionId);
                reliabilityReporter.reportLoadFail(monitorContextWithSessionId, resourceContextWithSessionId, errStage, errMessage, false, AnnieXConstants.ANNIEX_CARD);
            }
        });
    }

    public final void onLoadFail(final String bid, final String sessionId, final AbsBulletMonitorCallback.ErrStage errStage, final String errMessage, final View view) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(errStage, "errStage");
        Intrinsics.checkNotNullParameter(errMessage, "errMessage");
        if (!TraceEvent.enableTrace()) {
            Log.e(TAG, sessionId + " onLoadError " + errStage + ", " + errMessage);
        }
        safeAction(sessionId, new Function0<Unit>() { // from class: com.bytedance.android.anniex.monitor.MonitorManager$onLoadFail$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3366invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3366invoke() {
                Map map;
                Map map2;
                BulletMonitorContext monitorContextWithSessionId;
                BulletRLContext resourceContextWithSessionId;
                String errorStageMsg;
                ContainerStandardMonitor containerStandardMonitor = ContainerStandardMonitor.INSTANCE;
                String str = bid;
                View view2 = view;
                String str2 = sessionId;
                String str3 = errMessage;
                IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(str, IMonitorReportService.class);
                if (iMonitorReportService == null) {
                    iMonitorReportService = (IMonitorReportService) MonitorReportService.Companion.getFallbackDefault();
                }
                MonitorConfig monitorConfig = iMonitorReportService.getMonitorConfig();
                String bizTag = monitorConfig.getBizTag();
                if (bizTag == null) {
                    bizTag = "";
                }
                String virtualAID = monitorConfig.getVirtualAID();
                containerStandardMonitor.reportError(view2, str2, -1, str3, bizTag, virtualAID != null ? virtualAID : "");
                map = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext = (AnnieXMonitorContext) map.get(sessionId);
                if (annieXMonitorContext != null) {
                    annieXMonitorContext.setLoadStatus("fail");
                }
                map2 = MonitorManager.reportStateMap;
                AnnieXMonitorContext annieXMonitorContext2 = (AnnieXMonitorContext) map2.get(sessionId);
                if (annieXMonitorContext2 != null) {
                    errorStageMsg = MonitorManager.INSTANCE.getErrorStageMsg(errStage);
                    annieXMonitorContext2.setLoadStage(errorStageMsg);
                }
                ReliabilityReporter reliabilityReporter = ReliabilityReporter.INSTANCE;
                monitorContextWithSessionId = MonitorManager.INSTANCE.monitorContextWithSessionId(sessionId);
                resourceContextWithSessionId = MonitorManager.INSTANCE.resourceContextWithSessionId(sessionId);
                reliabilityReporter.reportLoadFail(monitorContextWithSessionId, resourceContextWithSessionId, errStage, errMessage, false, AnnieXConstants.ANNIEX_CARD);
            }
        });
    }
}
