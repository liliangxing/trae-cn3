package com.bytedance.trae.login.traeauth;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import com.bytedance.apm.ApmAgent;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.service.monitor.fluency.FluencyHelper;
import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.lynx.scc.cloudservice.utils.SccUtils;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.DeviceOverLimitDialog;
import com.bytedance.trae.login.api.ForceLogoutUtils;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONObject;

/* compiled from: TraeAuthManager.kt */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\bX\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004É\u0001Ê\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010]\u001a\u0004\u0018\u00010\u00052\u0006\u0010^\u001a\u00020\u0005H\u0002J\u001c\u0010p\u001a\u00020q2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010s2\b\b\u0002\u0010^\u001a\u00020\u0005J\u001c\u0010t\u001a\u00020q2\b\b\u0002\u0010^\u001a\u00020\u00052\n\b\u0002\u0010r\u001a\u0004\u0018\u00010sJ\u0006\u0010u\u001a\u00020qJ\u001a\u0010x\u001a\u00020q2\u0006\u0010y\u001a\u00020z2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010sJ\u001a\u0010}\u001a\u00020q2\u0006\u0010j\u001a\u00020\u00052\b\u0010r\u001a\u0004\u0018\u00010sH\u0002J-\u0010~\u001a\u00020q2\u0006\u0010j\u001a\u00020\u00052\b\u0010r\u001a\u0004\u0018\u00010s2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0080@¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001JY\u0010\u0083\u0001\u001a\u0003H\u0084\u0001\"\u0005\b\u0000\u0010\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\n2\t\b\u0002\u0010\u0086\u0001\u001a\u00020\u00052\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u00052\u001f\u0010\u0087\u0001\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u0084\u00010\u0088\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010gH\u0082@¢\u0006\u0003\u0010\u0089\u0001J\u0014\u0010\u008a\u0001\u001a\u00030\u0080\u00012\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0002J\u0013\u0010\u008d\u0001\u001a\u00020\n2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0002J\u001d\u0010\u008e\u0001\u001a\u00020\u00052\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0003\u0010\u0090\u0001J\u001a\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u0005H\u0082@¢\u0006\u0003\u0010\u0090\u0001J\u0011\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0086@¢\u0006\u0003\u0010\u0096\u0001J\u001a\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u0099\u0001\u001a\u00020\u0005H\u0086@¢\u0006\u0003\u0010\u0090\u0001J!\u0010\u009a\u0001\u001a\u00020q2\u0018\b\u0002\u0010\u009b\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u009c\u0001\u0012\u0004\u0012\u00020q\u0018\u00010gJ1\u0010\u009d\u0001\u001a\u00030\u009c\u00012\u0006\u0010j\u001a\u00020\u00052\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\f\b\u0002\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0086@¢\u0006\u0003\u0010¢\u0001J\u0018\u0010£\u0001\u001a\u00020k2\u0006\u0010j\u001a\u00020\u0005H\u0082@¢\u0006\u0003\u0010\u0090\u0001J\u0018\u0010¤\u0001\u001a\u00020k2\u0006\u0010j\u001a\u00020\u0005H\u0082@¢\u0006\u0003\u0010\u0090\u0001J\u0016\u0010¥\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050¦\u0001H\u0002J\u001f\u0010§\u0001\u001a\u00020\u00052\u0014\u0010¨\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050¦\u0001H\u0002J\u0014\u0010©\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010ª\u0001\u001a\u00020\u0005H\u0002J(\u0010«\u0001\u001a\u0004\u0018\u00010\u00052\u0012\u0010¬\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00ad\u00012\u0007\u0010ª\u0001\u001a\u00020\u0005H\u0002J\u001d\u0010®\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010¯\u0001\u001a\u00020\u00052\u0007\u0010ª\u0001\u001a\u00020\u0005H\u0002J-\u0010°\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050±\u00012\u0012\u0010¬\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00ad\u00012\u0007\u0010²\u0001\u001a\u00020\u0005H\u0002J6\u0010³\u0001\u001a\f\u0012\u0005\u0012\u0003H\u0084\u0001\u0018\u00010´\u0001\"\u0005\b\u0000\u0010\u0084\u00012\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u00052\u000f\u0010¶\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0084\u00010·\u0001H\u0002J?\u0010³\u0001\u001a\f\u0012\u0005\u0012\u0003H\u0084\u0001\u0018\u00010¸\u0001\"\u0005\b\u0000\u0010\u0084\u00012\u0012\u0010¬\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00ad\u00012\u000f\u0010¶\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0084\u00010·\u0001H\u0002J\u0099\u0001\u0010¹\u0001\u001a\u00020q2\t\u0010º\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010^\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010»\u0001\u001a\u0004\u0018\u00010\u00072\u000b\b\u0002\u0010¼\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010½\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010¾\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010¿\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010À\u0001\u001a\u0004\u0018\u00010\n2\u000b\b\u0002\u0010Á\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010Â\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0003\u0010Ä\u0001J%\u0010Å\u0001\u001a\u00020q2\t\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010^\u001a\u0004\u0018\u00010\u00052\u0007\u0010»\u0001\u001a\u00020\u0007J6\u0010Ç\u0001\u001a\u00020q2\b\u0010È\u0001\u001a\u00030\u0080\u00012\u0007\u0010»\u0001\u001a\u00020\u00072\u000b\b\u0002\u0010½\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010¾\u0001\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010f\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bh\u0012\b\bi\u0012\u0004\b\b(j\u0012\u0004\u0012\u00020k\u0018\u00010gX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u000e\u0010v\u001a\u00020wX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020|X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Ë\u0001"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeAuthManager;", "", "<init>", "()V", "TAG", "", "TOKEN_REFRESH_THRESHOLD_MS", "", "AUTH_FLOW_TIMEOUT_MS", "STEP_MAX_RETRIES", "", "CHAIN_RETRY_BASE_DELAY_MS", "CHAIN_RETRY_MAX_DELAY_MS", "SESSION_NOT_FOUND_MAX_CHAIN_RETRIES", "ERROR_CODE_REFRESH_TOKEN_EXPIRED", "ERROR_CODE_DEVICE_LIMIT_REACHED", "ERROR_CODE_DEVICE_BIND_REQUIRED", "ERROR_CODE_NOT_LOGGED_IN", "ERROR_CODE_SESSION_NOT_FOUND", "STAGE_START", "STAGE_PASSPORT_DONE", "STAGE_PASSPORT_FAIL", "STAGE_BYTECLOUD_PASSPORT_DONE", "STAGE_BYTECLOUD_PASSPORT_FAIL", "STAGE_LOGIN_SUCCESS", "STAGE_LOGIN_SUCCESS_DEGRADED", "STAGE_LOGIN_FAILURE", "STAGE_LOGIN_BUTTON_CLICKED", "STAGE_AGREEMENT_DIALOG_SHOWN", "STAGE_AGREEMENT_ACCEPTED", "STAGE_AGREEMENT_REJECTED", "STAGE_LOGIN_METHOD_SELECTED", "STAGE_PHONE_LOGIN_CLICKED", "STAGE_ONE_CLICK_SWITCH_TO_PHONE", "STAGE_DEVICE_LIMIT", "STAGE_SMS_RESEND_ERROR", "STAGE_AUTH_RETRY_FAILURE", "STAGE_TRANSIENT_RETRY", "STAGE_DOUYIN_AUTH_SUCCESS_NO_BIND", "STAGE_DOUYIN_AUTH_NEED_BIND", "STAGE_DOUYIN_AUTH_CANCELLED", "STAGE_DOUYIN_AUTH_SERVICE_UNAVAILABLE", "STAGE_DOUYIN_AUTH_TRAE_AUTH_FAIL", "STAGE_DOUYIN_BIND_PHONE_SHOWN", "STAGE_DOUYIN_BIND_PHONE_EXIT", "STAGE_DOUYIN_BIND_PHONE_PAUSE", "STAGE_DOUYIN_BIND_PHONE_DESTROY", "STAGE_DOUYIN_BIND_SEND_CODE", "STAGE_DOUYIN_BIND_SEND_CODE_FAIL", "STAGE_DOUYIN_BIND_VERIFY_CODE_SHOWN", "STAGE_DOUYIN_BIND_VERIFY_CODE_EXIT", "STAGE_DOUYIN_BIND_VERIFY_CODE_PAUSE", "STAGE_DOUYIN_BIND_VERIFY_CODE_DESTROY", "STAGE_DOUYIN_BIND_VERIFY_CODE_ERROR", "STAGE_DOUYIN_BIND_RESEND_CODE", "STAGE_DOUYIN_BIND_RESEND_CODE_SUCCESS", "STAGE_DOUYIN_BIND_RESEND_CODE_FAIL", "STAGE_DOUYIN_BIND_PHONE_CONFLICT", "STAGE_DOUYIN_BIND_SUBMIT", "STAGE_DOUYIN_BIND_SUCCESS", "STAGE_DOUYIN_BIND_FAIL", "STAGE_DOUYIN_BIND_TRAE_AUTH_FAIL", "STAGE_DOUYIN_BIND_DEVICE_LIMIT", "STAGE_DEVICE_LIMIT_DISMISSED", "STAGE_ACCOUNT_DELETION_PENDING_SHOWN", "STAGE_ACCOUNT_RESTORE_CLICK", "STAGE_ACCOUNT_RESTORE_API_SUCCESS", "STAGE_ACCOUNT_RESTORE_SUCCESS", "STAGE_ACCOUNT_RESTORE_FAIL", "STAGE_ACCOUNT_RESTORE_EXIT", "STAGE_ENTERPRISE_PAGE_SHOWN", "STAGE_ENTERPRISE_EMAIL_SUBMITTED", "STAGE_ENTERPRISE_CHECK_CONFIG_RESULT", "STAGE_ENTERPRISE_CHECK_CONFIG_FAIL", "STAGE_ENTERPRISE_SSO_OPENED", "STAGE_ENTERPRISE_SSO_CALLBACK", "STAGE_ENTERPRISE_SSO_SESSION_FAIL", "STAGE_ENTERPRISE_PASSWORD_SUBMITTED", "STAGE_ENTERPRISE_PAGE_EXIT", "STAGE_PAGE_SOURCE", "STAGE_VIEW_SHOWN", "STAGE_PRELOAD_RESULT", "STAGE_PAGE_EXIT", "STAGE_PAGE_RESUME", "STAGE_PAGE_PAUSE", "PLATFORM_UNSELECTED", "PLATFORM_GITHUB", "PLATFORM_GOOGLE", "PLATFORM_EMAIL", "PLATFORM_PHONE", "PLATFORM_ONE_CLICK", "PLATFORM_BYTECLOUD", "PLATFORM_DOUYIN", "toLoginType", "loginPlatform", "EVENT_LOGIN_FUNNEL", "EVENT_STEP_DURATION", "EVENT_TOKEN_REFRESH", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "enterpriseExchangeProvider", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "refreshToken", "Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;", "getEnterpriseExchangeProvider", "()Lkotlin/jvm/functions/Function1;", "setEnterpriseExchangeProvider", "(Lkotlin/jvm/functions/Function1;)V", "onLoginContinueByDeviceLimit", "", "callback", "Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;", "onPassportLoginSuccess", "clearAuthData", "refreshMutex", "Lkotlinx/coroutines/sync/Mutex;", "refreshIDEAccessTokenIfNeeded", LynxMonitorService.KEY_TRIGGER, "Lcom/bytedance/trae/login/traeauth/TokenRefreshTrigger;", "isExchangeRequesting", "Ljava/util/concurrent/atomic/AtomicBoolean;", "performExchangeAndPersist", "exchangeTokenOrThrowIgnoreDevice", "isIgnoreDeviceLimit", "", "exchangeTokenOrThrowIgnoreDevice$impl_mainlandRelease", "(Ljava/lang/String;Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryOnTransient", "T", "maxRetries", "stepName", "block", "Lkotlin/coroutines/Continuation;", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isTransientError", "e", "", "extractHttpStatusCode", "doLoginOrThrow", "loginType", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doGetRefreshTokenOrThrow", "Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;", "cloudideSession", "listDevices", "Lcom/bytedance/trae/login/traeauth/ListDevicesResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearRefreshToken", "Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenResult;", "deviceId", "bindDeviceAsync", "onResult", "Lcom/bytedance/trae/login/traeauth/BindDeviceResult;", "bindDevice", "deviceInfo", "Lcom/bytedance/trae/login/traeauth/DeviceInfo;", "deviceProof", "Lcom/bytedance/trae/login/traeauth/DeviceProof;", "(Ljava/lang/String;Lcom/bytedance/trae/login/traeauth/DeviceInfo;Lcom/bytedance/trae/login/traeauth/DeviceProof;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doExchangeTokenOrThrow", "doEnterpriseExchangeTokenOrThrow", "buildDeviceHeaders", "", "buildCookieHeader", "values", "extractCookieFromCookieManager", "cookieName", "extractCookieFromResponse", "ssResponse", "Lcom/bytedance/retrofit2/SsResponse;", "extractCookieValue", "cookieString", "getHeaderValues", "", "headerName", "parseResponse", "Lcom/bytedance/trae/login/traeauth/TraeResponse;", "bodyStr", "clazz", "Ljava/lang/Class;", "Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeResponseWithRaw;", "reportLoginFunnel", FluencyHelper.STAGE, "durationMs", "failedStep", "errorCode", ISignalReportConstants.KEY_REASON, "bindStatus", "httpCode", "logId", "result", "bindStage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "reportStepDuration", "step", "reportTokenRefresh", "success", "TraeAuthCallback", "TraeResponseWithRaw", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeAuthManager {
    private static final long AUTH_FLOW_TIMEOUT_MS = 60000;
    private static final long CHAIN_RETRY_BASE_DELAY_MS = 2000;
    private static final long CHAIN_RETRY_MAX_DELAY_MS = 10000;
    private static final String ERROR_CODE_DEVICE_BIND_REQUIRED = "BINDING_REQUIRED";
    private static final String ERROR_CODE_DEVICE_LIMIT_REACHED = "040034";
    private static final String ERROR_CODE_NOT_LOGGED_IN = "20101";
    private static final String ERROR_CODE_REFRESH_TOKEN_EXPIRED = "20311";
    private static final String ERROR_CODE_SESSION_NOT_FOUND = "20310";
    private static final String EVENT_LOGIN_FUNNEL = "icube_login_funnel";
    private static final String EVENT_STEP_DURATION = "icube_login_step_duration";
    private static final String EVENT_TOKEN_REFRESH = "icube_token_refresh";
    public static final TraeAuthManager INSTANCE = new TraeAuthManager();
    public static final String PLATFORM_BYTECLOUD = "bytecloud";
    public static final String PLATFORM_DOUYIN = "douyin";
    public static final String PLATFORM_EMAIL = "email";
    public static final String PLATFORM_GITHUB = "github";
    public static final String PLATFORM_GOOGLE = "google";
    public static final String PLATFORM_ONE_CLICK = "one_click";
    public static final String PLATFORM_PHONE = "phone";
    public static final String PLATFORM_UNSELECTED = "unselected";
    private static final int SESSION_NOT_FOUND_MAX_CHAIN_RETRIES = 2;
    public static final String STAGE_ACCOUNT_DELETION_PENDING_SHOWN = "account_deletion_pending_shown";
    public static final String STAGE_ACCOUNT_RESTORE_API_SUCCESS = "account_restore_api_success";
    public static final String STAGE_ACCOUNT_RESTORE_CLICK = "account_restore_click";
    public static final String STAGE_ACCOUNT_RESTORE_EXIT = "account_restore_exit";
    public static final String STAGE_ACCOUNT_RESTORE_FAIL = "account_restore_fail";
    public static final String STAGE_ACCOUNT_RESTORE_SUCCESS = "account_restore_success";
    public static final String STAGE_AGREEMENT_ACCEPTED = "agreement_accepted";
    public static final String STAGE_AGREEMENT_DIALOG_SHOWN = "agreement_dialog_shown";
    public static final String STAGE_AGREEMENT_REJECTED = "agreement_rejected";
    public static final String STAGE_AUTH_RETRY_FAILURE = "auth_retry_failure";
    public static final String STAGE_BYTECLOUD_PASSPORT_DONE = "bytecloud_passport_done";
    public static final String STAGE_BYTECLOUD_PASSPORT_FAIL = "bytecloud_passport_fail";
    public static final String STAGE_DEVICE_LIMIT = "login_device_limit";
    public static final String STAGE_DEVICE_LIMIT_DISMISSED = "device_limit_dismissed";
    public static final String STAGE_DOUYIN_AUTH_CANCELLED = "douyin_auth_cancelled";
    public static final String STAGE_DOUYIN_AUTH_NEED_BIND = "douyin_auth_need_bind";
    public static final String STAGE_DOUYIN_AUTH_SERVICE_UNAVAILABLE = "douyin_auth_service_unavailable";
    public static final String STAGE_DOUYIN_AUTH_SUCCESS_NO_BIND = "douyin_auth_success_no_bind";
    public static final String STAGE_DOUYIN_AUTH_TRAE_AUTH_FAIL = "douyin_auth_trae_auth_fail";
    public static final String STAGE_DOUYIN_BIND_DEVICE_LIMIT = "douyin_bind_device_limit";
    public static final String STAGE_DOUYIN_BIND_FAIL = "douyin_bind_fail";
    public static final String STAGE_DOUYIN_BIND_PHONE_CONFLICT = "douyin_bind_phone_conflict";
    public static final String STAGE_DOUYIN_BIND_PHONE_DESTROY = "douyin_bind_phone_destroy";
    public static final String STAGE_DOUYIN_BIND_PHONE_EXIT = "douyin_bind_phone_exit";
    public static final String STAGE_DOUYIN_BIND_PHONE_PAUSE = "douyin_bind_phone_pause";
    public static final String STAGE_DOUYIN_BIND_PHONE_SHOWN = "douyin_bind_phone_shown";
    public static final String STAGE_DOUYIN_BIND_RESEND_CODE = "douyin_bind_resend_code";
    public static final String STAGE_DOUYIN_BIND_RESEND_CODE_FAIL = "douyin_bind_resend_code_fail";
    public static final String STAGE_DOUYIN_BIND_RESEND_CODE_SUCCESS = "douyin_bind_resend_code_success";
    public static final String STAGE_DOUYIN_BIND_SEND_CODE = "douyin_bind_send_code";
    public static final String STAGE_DOUYIN_BIND_SEND_CODE_FAIL = "douyin_bind_send_code_fail";
    public static final String STAGE_DOUYIN_BIND_SUBMIT = "douyin_bind_submit";
    public static final String STAGE_DOUYIN_BIND_SUCCESS = "douyin_bind_success";
    public static final String STAGE_DOUYIN_BIND_TRAE_AUTH_FAIL = "douyin_bind_trae_auth_fail";
    public static final String STAGE_DOUYIN_BIND_VERIFY_CODE_DESTROY = "douyin_bind_verify_code_destroy";
    public static final String STAGE_DOUYIN_BIND_VERIFY_CODE_ERROR = "douyin_bind_verify_code_error";
    public static final String STAGE_DOUYIN_BIND_VERIFY_CODE_EXIT = "douyin_bind_verify_code_exit";
    public static final String STAGE_DOUYIN_BIND_VERIFY_CODE_PAUSE = "douyin_bind_verify_code_pause";
    public static final String STAGE_DOUYIN_BIND_VERIFY_CODE_SHOWN = "douyin_bind_verify_code_shown";
    public static final String STAGE_ENTERPRISE_CHECK_CONFIG_FAIL = "enterprise_check_config_fail";
    public static final String STAGE_ENTERPRISE_CHECK_CONFIG_RESULT = "enterprise_check_config_result";
    public static final String STAGE_ENTERPRISE_EMAIL_SUBMITTED = "enterprise_email_submitted";
    public static final String STAGE_ENTERPRISE_PAGE_EXIT = "enterprise_page_exit";
    public static final String STAGE_ENTERPRISE_PAGE_SHOWN = "enterprise_page_shown";
    public static final String STAGE_ENTERPRISE_PASSWORD_SUBMITTED = "enterprise_password_submitted";
    public static final String STAGE_ENTERPRISE_SSO_CALLBACK = "enterprise_sso_callback";
    public static final String STAGE_ENTERPRISE_SSO_OPENED = "enterprise_sso_opened";
    public static final String STAGE_ENTERPRISE_SSO_SESSION_FAIL = "enterprise_sso_session_fail";
    public static final String STAGE_LOGIN_BUTTON_CLICKED = "login_button_clicked";
    public static final String STAGE_LOGIN_FAILURE = "login_failure";
    public static final String STAGE_LOGIN_METHOD_SELECTED = "login_method_selected";
    public static final String STAGE_LOGIN_SUCCESS = "login_success";
    public static final String STAGE_LOGIN_SUCCESS_DEGRADED = "login_success_degraded";
    public static final String STAGE_ONE_CLICK_SWITCH_TO_PHONE = "one_click_switch_to_phone";
    public static final String STAGE_PAGE_EXIT = "login_page_exit";
    public static final String STAGE_PAGE_PAUSE = "login_page_pause";
    public static final String STAGE_PAGE_RESUME = "login_page_resume";
    public static final String STAGE_PAGE_SOURCE = "login_page_source";
    public static final String STAGE_PASSPORT_DONE = "passport_done";
    public static final String STAGE_PASSPORT_FAIL = "passport_fail";
    public static final String STAGE_PHONE_LOGIN_CLICKED = "phone_login_clicked";
    public static final String STAGE_PRELOAD_RESULT = "one_key_preload_result";
    public static final String STAGE_SMS_RESEND_ERROR = "sms_resend_error";
    public static final String STAGE_START = "start";
    public static final String STAGE_TRANSIENT_RETRY = "transient_retry";
    public static final String STAGE_VIEW_SHOWN = "login_page_view_shown";
    private static final int STEP_MAX_RETRIES = 2;
    private static final String TAG = "TraeAuthManager";
    private static final long TOKEN_REFRESH_THRESHOLD_MS = 18000000;
    private static Function1<? super String, TraeExchangeTokenResult> enterpriseExchangeProvider;
    private static final CoroutineExceptionHandler exceptionHandler;
    private static final AtomicBoolean isExchangeRequesting;
    private static final Mutex refreshMutex;
    private static final CoroutineScope scope;

    /* compiled from: TraeAuthManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0006H&¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;", "", "onSuccess", "", "onFailure", "errorCode", "", "errorMessage", "deviceOverLimit", "token", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface TraeAuthCallback {
        void deviceOverLimit(String token);

        void onFailure(String errorCode, String errorMessage);

        void onSuccess();
    }

    /* compiled from: TraeAuthManager.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TokenRefreshTrigger.values().length];
            try {
                iArr[TokenRefreshTrigger.COLD_LAUNCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TokenRefreshTrigger.FOREGROUND_HEARTBEAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void reportLoginFunnel(String str, String str2) {
        reportLoginFunnel$default(this, str, str2, null, null, null, null, null, null, null, null, null, 2044, null);
    }

    public final void reportLoginFunnel(String str, String str2, Long l) {
        reportLoginFunnel$default(this, str, str2, l, null, null, null, null, null, null, null, null, 2040, null);
    }

    public final void reportLoginFunnel(String str, String str2, Long l, String str3) {
        reportLoginFunnel$default(this, str, str2, l, str3, null, null, null, null, null, null, null, 2032, null);
    }

    public final void reportLoginFunnel(String str, String str2, Long l, String str3, String str4) {
        reportLoginFunnel$default(this, str, str2, l, str3, str4, null, null, null, null, null, null, 2016, null);
    }

    public final void reportLoginFunnel(String str, String str2, Long l, String str3, String str4, String str5) {
        reportLoginFunnel$default(this, str, str2, l, str3, str4, str5, null, null, null, null, null, 1984, null);
    }

    public final void reportLoginFunnel(String str, String str2, Long l, String str3, String str4, String str5, String str6) {
        reportLoginFunnel$default(this, str, str2, l, str3, str4, str5, str6, null, null, null, null, 1920, null);
    }

    public final void reportLoginFunnel(String str, String str2, Long l, String str3, String str4, String str5, String str6, Integer num) {
        reportLoginFunnel$default(this, str, str2, l, str3, str4, str5, str6, num, null, null, null, 1792, null);
    }

    public final void reportLoginFunnel(String str, String str2, Long l, String str3, String str4, String str5, String str6, Integer num, String str7) {
        reportLoginFunnel$default(this, str, str2, l, str3, str4, str5, str6, num, str7, null, null, 1536, null);
    }

    public final void reportLoginFunnel(String str, String str2, Long l, String str3, String str4, String str5, String str6, Integer num, String str7, String str8) {
        reportLoginFunnel$default(this, str, str2, l, str3, str4, str5, str6, num, str7, str8, null, 1024, null);
    }

    private TraeAuthManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        if (r2.equals("email") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        if (r2.equals(com.bytedance.trae.login.traeauth.TraeAuthManager.PLATFORM_GOOGLE) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        if (r2.equals(com.bytedance.trae.login.traeauth.TraeAuthManager.PLATFORM_GITHUB) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r2.equals("douyin") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if (r2.equals(com.bytedance.trae.login.traeauth.TraeAuthManager.PLATFORM_PHONE) == false) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String toLoginType(String loginPlatform) {
        String str;
        switch (loginPlatform.hashCode()) {
            case -2047679955:
                if (loginPlatform.equals("bytecloud")) {
                    return "sso";
                }
                return null;
            case -1325936172:
                str = "douyin";
                break;
            case -1245635613:
                str = PLATFORM_GITHUB;
                break;
            case -1240244679:
                str = PLATFORM_GOOGLE;
                break;
            case 96619420:
                str = "email";
                break;
            case 106642798:
                str = PLATFORM_PHONE;
                break;
            case 1929704047:
                if (loginPlatform.equals(PLATFORM_ONE_CLICK)) {
                    return "one_tap";
                }
                break;
        }
    }

    public final Function1<String, TraeExchangeTokenResult> getEnterpriseExchangeProvider() {
        return enterpriseExchangeProvider;
    }

    public final void setEnterpriseExchangeProvider(Function1<? super String, TraeExchangeTokenResult> function1) {
        enterpriseExchangeProvider = function1;
    }

    public static /* synthetic */ void onLoginContinueByDeviceLimit$default(TraeAuthManager traeAuthManager, TraeAuthCallback traeAuthCallback, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            traeAuthCallback = null;
        }
        if ((i & 2) != 0) {
            str = "unknown";
        }
        traeAuthManager.onLoginContinueByDeviceLimit(traeAuthCallback, str);
    }

    public final void onLoginContinueByDeviceLimit(TraeAuthCallback callback, String loginPlatform) {
        Intrinsics.checkNotNullParameter(loginPlatform, "loginPlatform");
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new TraeAuthManager$onLoginContinueByDeviceLimit$1(loginPlatform, callback, null), 3, (Object) null);
    }

    public static /* synthetic */ void onPassportLoginSuccess$default(TraeAuthManager traeAuthManager, String str, TraeAuthCallback traeAuthCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            str = PLATFORM_UNSELECTED;
        }
        if ((i & 2) != 0) {
            traeAuthCallback = null;
        }
        traeAuthManager.onPassportLoginSuccess(str, traeAuthCallback);
    }

    public final void onPassportLoginSuccess(String loginPlatform, TraeAuthCallback callback) {
        Intrinsics.checkNotNullParameter(loginPlatform, "loginPlatform");
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new TraeAuthManager$onPassportLoginSuccess$1(loginPlatform, callback, null), 3, (Object) null);
    }

    public final void clearAuthData() {
        TraeAuthStorage.INSTANCE.clear();
    }

    public static /* synthetic */ void refreshIDEAccessTokenIfNeeded$default(TraeAuthManager traeAuthManager, TokenRefreshTrigger tokenRefreshTrigger, TraeAuthCallback traeAuthCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            traeAuthCallback = null;
        }
        traeAuthManager.refreshIDEAccessTokenIfNeeded(tokenRefreshTrigger, traeAuthCallback);
    }

    public final void refreshIDEAccessTokenIfNeeded(TokenRefreshTrigger trigger, TraeAuthCallback callback) {
        Intrinsics.checkNotNullParameter(trigger, LynxMonitorService.KEY_TRIGGER);
        String refreshToken = TraeAuthStorage.INSTANCE.getRefreshToken();
        if (refreshToken.length() == 0) {
            FLogger.INSTANCE.mo430w(TAG, "refreshIDEAccessTokenIfNeeded: no refresh token, skip");
            if (callback != null) {
                callback.onFailure(null, "No refresh token available");
                return;
            }
            return;
        }
        long jwtExpireAt = TraeAuthStorage.INSTANCE.getJwtExpireAt();
        long currentTimeMillis = jwtExpireAt - System.currentTimeMillis();
        if (DebugSettings.INSTANCE.getForceTokenRefresh()) {
            FLogger.INSTANCE.mo430w(TAG, "refreshIDEAccessTokenIfNeeded: forceTokenRefresh enabled, bypassing expiry check");
            performExchangeAndPersist(refreshToken, callback);
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[trigger.ordinal()];
        if (i == 1) {
            if (jwtExpireAt > 0 && currentTimeMillis > TOKEN_REFRESH_THRESHOLD_MS) {
                FLogger.INSTANCE.mo428i(TAG, "refreshIDEAccessTokenIfNeeded: cold launch skip, token still valid for " + (currentTimeMillis / BytePatchException.ErrorCode.paramsError) + 's');
                if (TraeAuthStorage.INSTANCE.isFirstAppUpgrade()) {
                    performExchangeAndPersist(refreshToken, callback);
                    return;
                } else {
                    if (callback != null) {
                        callback.onSuccess();
                        return;
                    }
                    return;
                }
            }
            FLogger.INSTANCE.mo428i(TAG, "refreshIDEAccessTokenIfNeeded: cold launch, token expiring soon (remaining=" + (currentTimeMillis / BytePatchException.ErrorCode.paramsError) + "s), performing exchange");
            performExchangeAndPersist(refreshToken, callback);
            return;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (jwtExpireAt > 0 && currentTimeMillis > TOKEN_REFRESH_THRESHOLD_MS) {
            FLogger.INSTANCE.mo428i(TAG, "refreshIDEAccessTokenIfNeeded: heartbeat skip, token still valid for " + (currentTimeMillis / BytePatchException.ErrorCode.paramsError) + 's');
            if (TraeAuthStorage.INSTANCE.isFirstAppUpgrade()) {
                performExchangeAndPersist(refreshToken, callback);
                return;
            } else {
                if (callback != null) {
                    callback.onSuccess();
                    return;
                }
                return;
            }
        }
        FLogger.INSTANCE.mo428i(TAG, "refreshIDEAccessTokenIfNeeded: heartbeat triggered, token expiring soon (remaining=" + (currentTimeMillis / BytePatchException.ErrorCode.paramsError) + "s), performing exchange");
        performExchangeAndPersist(refreshToken, callback);
    }

    private final void performExchangeAndPersist(String refreshToken, TraeAuthCallback callback) {
        if (isExchangeRequesting.compareAndSet(false, true)) {
            BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new TraeAuthManager$performExchangeAndPersist$1(refreshToken, callback, null), 3, (Object) null);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|191|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x00bd, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x00be, code lost:
    
        r25 = r41;
        r24 = com.bytedance.trae.login.traeauth.TraeAuthManager.TAG;
        r26 = "success";
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0106, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0107, code lost:
    
        r8 = com.bytedance.trae.login.traeauth.TraeAuthManager.TAG;
        r17 = r5;
        r5 = "performExchangeAndPersist: success, tokenExpireAt=";
        r9 = false;
        r11 = r41;
        r10 = "success";
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x00fb, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x00fc, code lost:
    
        r8 = com.bytedance.trae.login.traeauth.TraeAuthManager.TAG;
        r16 = r5;
        r5 = "performExchangeAndPersist: success, tokenExpireAt=";
        r9 = false;
        r11 = r41;
        r10 = "success";
        r2 = r2;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0039. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00fd: MOVE (r16 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:190:0x00fc */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0108: MOVE (r17 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:188:0x0107 */
    /* JADX WARN: Removed duplicated region for block: B:111:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x04cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x03de A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0242 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c  */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v29, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.Object, com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Object, com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v12, types: [long] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v7, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object exchangeTokenOrThrowIgnoreDevice$impl_mainlandRelease(String str, TraeAuthCallback traeAuthCallback, boolean z, Continuation<? super Unit> continuation) {
        TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1 traeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;
        final ?? r2;
        String str2;
        TraeAuthManager traeAuthManager;
        ?? r5;
        boolean z2;
        Continuation<? super Unit> continuation2;
        String str3;
        TraeAuthManager traeAuthManager2;
        ?? r52;
        Continuation<? super Unit> continuation3;
        String str4;
        String str5;
        long j;
        TraeAuthCallback traeAuthCallback2;
        long j2;
        TraeAuthCallback traeAuthCallback3;
        long j3;
        TraeAuthCallback traeAuthCallback4;
        String message;
        CoroutineContext main;
        TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$12 traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12;
        TraeAuthCallback traeAuthCallback5;
        String code;
        String message2;
        CoroutineContext main2;
        TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$10 traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10;
        boolean z3;
        Object retryOnTransient$default;
        TraeAuthManager traeAuthManager3;
        Object obj;
        boolean z4;
        TraeExchangeTokenResult traeExchangeTokenResult;
        IApplog.Companion companion;
        JSONObject jSONObject;
        Object obj2;
        Continuation continuation4;
        long j4;
        TraeAuthCallback traeAuthCallback6;
        CoroutineContext main3;
        TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3 traeAuthManager$exchangeTokenOrThrowIgnoreDevice$3;
        DeviceOverLimitDialogManager deviceOverLimitDialogManager;
        DeviceOverLimitDialog.Scene scene;
        DeviceOverLimitDialog.Callback callback;
        final String str6 = str;
        ?? r10 = "performExchangeAndPersist: success, tokenExpireAt=";
        if (continuation instanceof TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1) {
            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$1 = (TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1) continuation;
            if ((traeAuthManager$exchangeTokenOrThrowIgnoreDevice$1.label & Integer.MIN_VALUE) != 0) {
                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$1.label -= Integer.MIN_VALUE;
                TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1 traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13 = traeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;
                Object obj3 = traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                r2 = traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label;
                switch (r2) {
                    case 0:
                        ResultKt.throwOnFailure(obj3);
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$result$1 traeAuthManager$exchangeTokenOrThrowIgnoreDevice$result$1 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$result$1(str6, null);
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = this;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = str6;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = traeAuthCallback;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.Z$0 = z;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.J$0 = currentTimeMillis;
                            try {
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 1;
                                z3 = true;
                                str4 = TAG;
                                continuation3 = "icube_token_refresh_result";
                                str5 = "success";
                                z2 = false;
                                try {
                                    retryOnTransient$default = retryOnTransient$default(this, 2, "exchangeRefresh", null, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$result$1, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13, 4, null);
                                } catch (TraeAuthException e) {
                                    e = e;
                                    str2 = str4;
                                    continuation2 = continuation3;
                                    str3 = str5;
                                    traeAuthManager2 = this;
                                    traeAuthCallback5 = traeAuthCallback;
                                    r52 = currentTimeMillis;
                                    long currentTimeMillis2 = System.currentTimeMillis() - r52;
                                    FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist failed: [" + e.getCode() + "] " + e.getMessage());
                                    IApplog.Companion companion2 = IApplog.Companion;
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put(str3, z2);
                                    jSONObject2.put("duration_ms", currentTimeMillis2);
                                    code = e.getCode();
                                    if (code == null) {
                                    }
                                    jSONObject2.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                    message2 = e.getMessage();
                                    if (message2 == null) {
                                    }
                                    jSONObject2.put(ISignalReportConstants.KEY_REASON, message2);
                                    Unit unit = Unit.INSTANCE;
                                    companion2.reportEvent(continuation2, jSONObject2);
                                    traeAuthManager2.reportTokenRefresh(false, currentTimeMillis2, e.getCode(), e.getMessage());
                                    if ((!Intrinsics.areEqual(e.getCode(), ERROR_CODE_REFRESH_TOKEN_EXPIRED) || Intrinsics.areEqual(e.getCode(), ERROR_CODE_NOT_LOGGED_IN)) ? true : z2) {
                                    }
                                    main2 = Dispatchers.getMain();
                                    traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$10(traeAuthCallback5, e, null);
                                    traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                                    traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                                    traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                    traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 8;
                                    if (BuildersKt.withContext(main2, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                    }
                                    return Unit.INSTANCE;
                                } catch (Exception e2) {
                                    e = e2;
                                    str2 = str4;
                                    continuation2 = continuation3;
                                    str3 = str5;
                                    traeAuthManager = this;
                                    traeAuthCallback4 = traeAuthCallback;
                                    r5 = currentTimeMillis;
                                    long currentTimeMillis3 = System.currentTimeMillis() - r5;
                                    FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist exception: " + e.getMessage());
                                    IApplog.Companion companion3 = IApplog.Companion;
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(str3, z2);
                                    jSONObject3.put("duration_ms", currentTimeMillis3);
                                    message = e.getMessage();
                                    if (message == null) {
                                    }
                                    jSONObject3.put(ISignalReportConstants.KEY_REASON, message);
                                    Unit unit2 = Unit.INSTANCE;
                                    companion3.reportEvent(continuation2, jSONObject3);
                                    String message3 = e.getMessage();
                                    reportTokenRefresh$default(traeAuthManager, false, currentTimeMillis3, null, message3 == null ? "unexpected_exception" : message3, 4, null);
                                    main = Dispatchers.getMain();
                                    traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$12(traeAuthCallback4, e, null);
                                    traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                                    traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                                    traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                    traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 9;
                                    if (BuildersKt.withContext(main, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                    }
                                    return Unit.INSTANCE;
                                }
                            } catch (TraeAuthException e3) {
                                e = e3;
                                continuation2 = "icube_token_refresh_result";
                                str3 = "success";
                                str2 = TAG;
                                z2 = false;
                                traeAuthManager2 = this;
                                traeAuthCallback5 = traeAuthCallback;
                                r52 = currentTimeMillis;
                                long currentTimeMillis22 = System.currentTimeMillis() - r52;
                                FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist failed: [" + e.getCode() + "] " + e.getMessage());
                                IApplog.Companion companion22 = IApplog.Companion;
                                JSONObject jSONObject22 = new JSONObject();
                                jSONObject22.put(str3, z2);
                                jSONObject22.put("duration_ms", currentTimeMillis22);
                                code = e.getCode();
                                if (code == null) {
                                }
                                jSONObject22.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                message2 = e.getMessage();
                                if (message2 == null) {
                                }
                                jSONObject22.put(ISignalReportConstants.KEY_REASON, message2);
                                Unit unit3 = Unit.INSTANCE;
                                companion22.reportEvent(continuation2, jSONObject22);
                                traeAuthManager2.reportTokenRefresh(false, currentTimeMillis22, e.getCode(), e.getMessage());
                                if ((!Intrinsics.areEqual(e.getCode(), ERROR_CODE_REFRESH_TOKEN_EXPIRED) || Intrinsics.areEqual(e.getCode(), ERROR_CODE_NOT_LOGGED_IN)) ? true : z2) {
                                }
                                main2 = Dispatchers.getMain();
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$10(traeAuthCallback5, e, null);
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 8;
                                if (BuildersKt.withContext(main2, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            } catch (Exception e4) {
                                e = e4;
                                continuation2 = "icube_token_refresh_result";
                                str3 = "success";
                                str2 = TAG;
                                z2 = false;
                                traeAuthManager = this;
                                traeAuthCallback4 = traeAuthCallback;
                                r5 = currentTimeMillis;
                                long currentTimeMillis32 = System.currentTimeMillis() - r5;
                                FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist exception: " + e.getMessage());
                                IApplog.Companion companion32 = IApplog.Companion;
                                JSONObject jSONObject32 = new JSONObject();
                                jSONObject32.put(str3, z2);
                                jSONObject32.put("duration_ms", currentTimeMillis32);
                                message = e.getMessage();
                                if (message == null) {
                                }
                                jSONObject32.put(ISignalReportConstants.KEY_REASON, message);
                                Unit unit22 = Unit.INSTANCE;
                                companion32.reportEvent(continuation2, jSONObject32);
                                String message32 = e.getMessage();
                                reportTokenRefresh$default(traeAuthManager, false, currentTimeMillis32, null, message32 == null ? "unexpected_exception" : message32, 4, null);
                                main = Dispatchers.getMain();
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$12(traeAuthCallback4, e, null);
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 9;
                                if (BuildersKt.withContext(main, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            }
                        } catch (TraeAuthException e5) {
                            e = e5;
                            continuation2 = "icube_token_refresh_result";
                            str2 = TAG;
                            str3 = "success";
                            z2 = false;
                        } catch (Exception e6) {
                            e = e6;
                            continuation2 = "icube_token_refresh_result";
                            str2 = TAG;
                            str3 = "success";
                            z2 = false;
                        }
                        if (retryOnTransient$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        traeAuthManager3 = this;
                        r2 = traeAuthCallback;
                        obj = retryOnTransient$default;
                        j3 = currentTimeMillis;
                        z4 = z;
                        try {
                            traeExchangeTokenResult = (TraeExchangeTokenResult) obj;
                            try {
                            } catch (TraeAuthException e7) {
                                e = e7;
                                traeAuthManager2 = traeAuthManager3;
                                traeAuthCallback3 = r2;
                                j2 = j3;
                                str2 = str4;
                                continuation2 = continuation3;
                                str3 = str5;
                                traeAuthCallback5 = traeAuthCallback3;
                                r52 = j2;
                                long currentTimeMillis222 = System.currentTimeMillis() - r52;
                                FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist failed: [" + e.getCode() + "] " + e.getMessage());
                                IApplog.Companion companion222 = IApplog.Companion;
                                JSONObject jSONObject222 = new JSONObject();
                                jSONObject222.put(str3, z2);
                                jSONObject222.put("duration_ms", currentTimeMillis222);
                                code = e.getCode();
                                if (code == null) {
                                }
                                jSONObject222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                message2 = e.getMessage();
                                if (message2 == null) {
                                }
                                jSONObject222.put(ISignalReportConstants.KEY_REASON, message2);
                                Unit unit32 = Unit.INSTANCE;
                                companion222.reportEvent(continuation2, jSONObject222);
                                traeAuthManager2.reportTokenRefresh(false, currentTimeMillis222, e.getCode(), e.getMessage());
                                if ((!Intrinsics.areEqual(e.getCode(), ERROR_CODE_REFRESH_TOKEN_EXPIRED) || Intrinsics.areEqual(e.getCode(), ERROR_CODE_NOT_LOGGED_IN)) ? true : z2) {
                                }
                                main2 = Dispatchers.getMain();
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$10(traeAuthCallback5, e, null);
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 8;
                                if (BuildersKt.withContext(main2, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            } catch (Exception e8) {
                                e = e8;
                                traeAuthManager = traeAuthManager3;
                                traeAuthCallback2 = r2;
                                j = j3;
                                str2 = str4;
                                continuation2 = continuation3;
                                str3 = str5;
                                traeAuthCallback4 = traeAuthCallback2;
                                r5 = j;
                                long currentTimeMillis322 = System.currentTimeMillis() - r5;
                                FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist exception: " + e.getMessage());
                                IApplog.Companion companion322 = IApplog.Companion;
                                JSONObject jSONObject322 = new JSONObject();
                                jSONObject322.put(str3, z2);
                                jSONObject322.put("duration_ms", currentTimeMillis322);
                                message = e.getMessage();
                                if (message == null) {
                                }
                                jSONObject322.put(ISignalReportConstants.KEY_REASON, message);
                                Unit unit222 = Unit.INSTANCE;
                                companion322.reportEvent(continuation2, jSONObject322);
                                String message322 = e.getMessage();
                                reportTokenRefresh$default(traeAuthManager, false, currentTimeMillis322, null, message322 == null ? "unexpected_exception" : message322, 4, null);
                                main = Dispatchers.getMain();
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$12(traeAuthCallback4, e, null);
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 9;
                                if (BuildersKt.withContext(main, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            }
                        } catch (TraeAuthException e9) {
                            e = e9;
                            str2 = str4;
                        } catch (Exception e10) {
                            e = e10;
                            str2 = str4;
                        }
                        if (Intrinsics.areEqual(traeExchangeTokenResult.isDeviceLimit(), Boxing.boxBoolean(z3))) {
                            TraeAuthStorage.INSTANCE.clearFirstAppUpgrade();
                            TraeAuthStorage traeAuthStorage = TraeAuthStorage.INSTANCE;
                            String token = traeExchangeTokenResult.getToken();
                            Intrinsics.checkNotNull(token);
                            traeAuthStorage.saveJwtToken(token, traeExchangeTokenResult.getTokenExpireAt());
                            String refreshToken = traeExchangeTokenResult.getRefreshToken();
                            if (refreshToken != null) {
                                TraeAuthStorage.INSTANCE.saveRefreshToken(refreshToken, traeExchangeTokenResult.getRefreshExpireAt());
                            }
                            TraeAuthStorage.INSTANCE.saveLastExchangeSuccessAt(System.currentTimeMillis() / BytePatchException.ErrorCode.paramsError);
                            long currentTimeMillis4 = System.currentTimeMillis() - j3;
                            str2 = str4;
                            try {
                                FLogger.INSTANCE.mo428i(str2, "performExchangeAndPersist: success, tokenExpireAt=" + traeExchangeTokenResult.getTokenExpireAt());
                                companion = IApplog.Companion;
                                jSONObject = new JSONObject();
                                str3 = str5;
                                try {
                                    jSONObject.put(str3, z3);
                                    jSONObject.put("duration_ms", currentTimeMillis4);
                                    Unit unit4 = Unit.INSTANCE;
                                    continuation2 = continuation3;
                                } catch (TraeAuthException e11) {
                                    e = e11;
                                    continuation2 = continuation3;
                                } catch (Exception e12) {
                                    e = e12;
                                    continuation2 = continuation3;
                                }
                            } catch (TraeAuthException e13) {
                                e = e13;
                                continuation2 = continuation3;
                                str3 = str5;
                                traeAuthManager2 = traeAuthManager3;
                                traeAuthCallback5 = r2;
                                r52 = j3;
                                long currentTimeMillis2222 = System.currentTimeMillis() - r52;
                                FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist failed: [" + e.getCode() + "] " + e.getMessage());
                                IApplog.Companion companion2222 = IApplog.Companion;
                                JSONObject jSONObject2222 = new JSONObject();
                                jSONObject2222.put(str3, z2);
                                jSONObject2222.put("duration_ms", currentTimeMillis2222);
                                code = e.getCode();
                                if (code == null) {
                                    code = "";
                                }
                                jSONObject2222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                message2 = e.getMessage();
                                if (message2 == null) {
                                    message2 = "unknown";
                                }
                                jSONObject2222.put(ISignalReportConstants.KEY_REASON, message2);
                                Unit unit322 = Unit.INSTANCE;
                                companion2222.reportEvent(continuation2, jSONObject2222);
                                traeAuthManager2.reportTokenRefresh(false, currentTimeMillis2222, e.getCode(), e.getMessage());
                                if ((!Intrinsics.areEqual(e.getCode(), ERROR_CODE_REFRESH_TOKEN_EXPIRED) || Intrinsics.areEqual(e.getCode(), ERROR_CODE_NOT_LOGGED_IN)) ? true : z2) {
                                    FLogger.INSTANCE.mo430w(str2, "performExchangeAndPersist: token expired or not logged in (" + e.getCode() + "), forcing logout");
                                    CoroutineContext main4 = Dispatchers.getMain();
                                    TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$9 traeAuthManager$exchangeTokenOrThrowIgnoreDevice$9 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$9(null);
                                    traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = traeAuthCallback5;
                                    traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = e;
                                    traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                    traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 7;
                                    if (BuildersKt.withContext(main4, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$9, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                main2 = Dispatchers.getMain();
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$10(traeAuthCallback5, e, null);
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 8;
                                if (BuildersKt.withContext(main2, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            } catch (Exception e14) {
                                e = e14;
                                continuation2 = continuation3;
                                str3 = str5;
                                traeAuthManager = traeAuthManager3;
                                traeAuthCallback4 = r2;
                                r5 = j3;
                                long currentTimeMillis3222 = System.currentTimeMillis() - r5;
                                FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist exception: " + e.getMessage());
                                IApplog.Companion companion3222 = IApplog.Companion;
                                JSONObject jSONObject3222 = new JSONObject();
                                jSONObject3222.put(str3, z2);
                                jSONObject3222.put("duration_ms", currentTimeMillis3222);
                                message = e.getMessage();
                                if (message == null) {
                                    message = "unexpected_exception";
                                }
                                jSONObject3222.put(ISignalReportConstants.KEY_REASON, message);
                                Unit unit2222 = Unit.INSTANCE;
                                companion3222.reportEvent(continuation2, jSONObject3222);
                                String message3222 = e.getMessage();
                                reportTokenRefresh$default(traeAuthManager, false, currentTimeMillis3222, null, message3222 == null ? "unexpected_exception" : message3222, 4, null);
                                main = Dispatchers.getMain();
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$12(traeAuthCallback4, e, null);
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 9;
                                if (BuildersKt.withContext(main, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            try {
                                companion.reportEvent(continuation2, jSONObject);
                                reportTokenRefresh$default(traeAuthManager3, true, currentTimeMillis4, null, null, 12, null);
                                CoroutineContext main5 = Dispatchers.getMain();
                                TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$7 traeAuthManager$exchangeTokenOrThrowIgnoreDevice$7 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$7(r2, null);
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = traeAuthManager3;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = r2;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.J$0 = j3;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 6;
                                if (BuildersKt.withContext(main5, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$7, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } catch (TraeAuthException e15) {
                                e = e15;
                                traeAuthManager2 = traeAuthManager3;
                                traeAuthCallback5 = r2;
                                r52 = j3;
                                long currentTimeMillis22222 = System.currentTimeMillis() - r52;
                                FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist failed: [" + e.getCode() + "] " + e.getMessage());
                                IApplog.Companion companion22222 = IApplog.Companion;
                                JSONObject jSONObject22222 = new JSONObject();
                                jSONObject22222.put(str3, z2);
                                jSONObject22222.put("duration_ms", currentTimeMillis22222);
                                code = e.getCode();
                                if (code == null) {
                                }
                                jSONObject22222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                message2 = e.getMessage();
                                if (message2 == null) {
                                }
                                jSONObject22222.put(ISignalReportConstants.KEY_REASON, message2);
                                Unit unit3222 = Unit.INSTANCE;
                                companion22222.reportEvent(continuation2, jSONObject22222);
                                traeAuthManager2.reportTokenRefresh(false, currentTimeMillis22222, e.getCode(), e.getMessage());
                                if ((!Intrinsics.areEqual(e.getCode(), ERROR_CODE_REFRESH_TOKEN_EXPIRED) || Intrinsics.areEqual(e.getCode(), ERROR_CODE_NOT_LOGGED_IN)) ? true : z2) {
                                }
                                main2 = Dispatchers.getMain();
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$10(traeAuthCallback5, e, null);
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 8;
                                if (BuildersKt.withContext(main2, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            } catch (Exception e16) {
                                e = e16;
                                traeAuthManager = traeAuthManager3;
                                traeAuthCallback4 = r2;
                                r5 = j3;
                                long currentTimeMillis32222 = System.currentTimeMillis() - r5;
                                FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist exception: " + e.getMessage());
                                IApplog.Companion companion32222 = IApplog.Companion;
                                JSONObject jSONObject32222 = new JSONObject();
                                jSONObject32222.put(str3, z2);
                                jSONObject32222.put("duration_ms", currentTimeMillis32222);
                                message = e.getMessage();
                                if (message == null) {
                                }
                                jSONObject32222.put(ISignalReportConstants.KEY_REASON, message);
                                Unit unit22222 = Unit.INSTANCE;
                                companion32222.reportEvent(continuation2, jSONObject32222);
                                String message32222 = e.getMessage();
                                reportTokenRefresh$default(traeAuthManager, false, currentTimeMillis32222, null, message32222 == null ? "unexpected_exception" : message32222, 4, null);
                                main = Dispatchers.getMain();
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$12(traeAuthCallback4, e, null);
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 9;
                                if (BuildersKt.withContext(main, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        }
                        if (z4) {
                            CoroutineContext main6 = Dispatchers.getMain();
                            continuation4 = null;
                            TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$2 traeAuthManager$exchangeTokenOrThrowIgnoreDevice$2 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$2(null);
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = traeAuthManager3;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = r2;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.J$0 = j3;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 2;
                            if (BuildersKt.withContext(main6, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$2, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            j4 = j3;
                            traeAuthCallback6 = r2;
                            try {
                                main3 = Dispatchers.getMain();
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$3 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3(traeAuthCallback6, continuation4);
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = traeAuthManager3;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = traeAuthCallback6;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.J$0 = j4;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 3;
                                if (BuildersKt.withContext(main3, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$3, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } catch (TraeAuthException e17) {
                                e = e17;
                                traeAuthManager2 = traeAuthManager3;
                                j2 = j4;
                                traeAuthCallback3 = traeAuthCallback6;
                                str2 = str4;
                                continuation2 = continuation3;
                                str3 = str5;
                                traeAuthCallback5 = traeAuthCallback3;
                                r52 = j2;
                                long currentTimeMillis222222 = System.currentTimeMillis() - r52;
                                FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist failed: [" + e.getCode() + "] " + e.getMessage());
                                IApplog.Companion companion222222 = IApplog.Companion;
                                JSONObject jSONObject222222 = new JSONObject();
                                jSONObject222222.put(str3, z2);
                                jSONObject222222.put("duration_ms", currentTimeMillis222222);
                                code = e.getCode();
                                if (code == null) {
                                }
                                jSONObject222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                message2 = e.getMessage();
                                if (message2 == null) {
                                }
                                jSONObject222222.put(ISignalReportConstants.KEY_REASON, message2);
                                Unit unit32222 = Unit.INSTANCE;
                                companion222222.reportEvent(continuation2, jSONObject222222);
                                traeAuthManager2.reportTokenRefresh(false, currentTimeMillis222222, e.getCode(), e.getMessage());
                                if ((!Intrinsics.areEqual(e.getCode(), ERROR_CODE_REFRESH_TOKEN_EXPIRED) || Intrinsics.areEqual(e.getCode(), ERROR_CODE_NOT_LOGGED_IN)) ? true : z2) {
                                }
                                main2 = Dispatchers.getMain();
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$10(traeAuthCallback5, e, null);
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 8;
                                if (BuildersKt.withContext(main2, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            } catch (Exception e18) {
                                e = e18;
                                traeAuthManager = traeAuthManager3;
                                j = j4;
                                traeAuthCallback2 = traeAuthCallback6;
                                str2 = str4;
                                continuation2 = continuation3;
                                str3 = str5;
                                traeAuthCallback4 = traeAuthCallback2;
                                r5 = j;
                                long currentTimeMillis322222 = System.currentTimeMillis() - r5;
                                FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist exception: " + e.getMessage());
                                IApplog.Companion companion322222 = IApplog.Companion;
                                JSONObject jSONObject322222 = new JSONObject();
                                jSONObject322222.put(str3, z2);
                                jSONObject322222.put("duration_ms", currentTimeMillis322222);
                                message = e.getMessage();
                                if (message == null) {
                                }
                                jSONObject322222.put(ISignalReportConstants.KEY_REASON, message);
                                Unit unit222222 = Unit.INSTANCE;
                                companion322222.reportEvent(continuation2, jSONObject322222);
                                String message322222 = e.getMessage();
                                reportTokenRefresh$default(traeAuthManager, false, currentTimeMillis322222, null, message322222 == null ? "unexpected_exception" : message322222, 4, null);
                                main = Dispatchers.getMain();
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$12(traeAuthCallback4, e, null);
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 9;
                                if (BuildersKt.withContext(main, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        }
                        obj2 = null;
                        try {
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = traeAuthManager3;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = str6;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = r2;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.J$0 = j3;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 4;
                            obj3 = traeAuthManager3.listDevices(traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13);
                        } catch (Throwable th) {
                            th = th;
                            r10 = traeAuthManager3;
                            try {
                                Boxing.boxInt(Log.e("InitAppLog", "listDevices failed: " + th.getMessage()));
                            } catch (TraeAuthException e19) {
                                e = e19;
                                traeAuthManager2 = r10;
                                traeAuthCallback3 = r2;
                                j2 = j3;
                                str2 = str4;
                                continuation2 = continuation3;
                                str3 = str5;
                                traeAuthCallback5 = traeAuthCallback3;
                                r52 = j2;
                                long currentTimeMillis2222222 = System.currentTimeMillis() - r52;
                                FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist failed: [" + e.getCode() + "] " + e.getMessage());
                                IApplog.Companion companion2222222 = IApplog.Companion;
                                JSONObject jSONObject2222222 = new JSONObject();
                                jSONObject2222222.put(str3, z2);
                                jSONObject2222222.put("duration_ms", currentTimeMillis2222222);
                                code = e.getCode();
                                if (code == null) {
                                }
                                jSONObject2222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                message2 = e.getMessage();
                                if (message2 == null) {
                                }
                                jSONObject2222222.put(ISignalReportConstants.KEY_REASON, message2);
                                Unit unit322222 = Unit.INSTANCE;
                                companion2222222.reportEvent(continuation2, jSONObject2222222);
                                traeAuthManager2.reportTokenRefresh(false, currentTimeMillis2222222, e.getCode(), e.getMessage());
                                if ((!Intrinsics.areEqual(e.getCode(), ERROR_CODE_REFRESH_TOKEN_EXPIRED) || Intrinsics.areEqual(e.getCode(), ERROR_CODE_NOT_LOGGED_IN)) ? true : z2) {
                                }
                                main2 = Dispatchers.getMain();
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$10(traeAuthCallback5, e, null);
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 8;
                                if (BuildersKt.withContext(main2, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            } catch (Exception e20) {
                                e = e20;
                                traeAuthManager = r10;
                                traeAuthCallback2 = r2;
                                j = j3;
                                str2 = str4;
                                continuation2 = continuation3;
                                str3 = str5;
                                traeAuthCallback4 = traeAuthCallback2;
                                r5 = j;
                                long currentTimeMillis3222222 = System.currentTimeMillis() - r5;
                                FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist exception: " + e.getMessage());
                                IApplog.Companion companion3222222 = IApplog.Companion;
                                JSONObject jSONObject3222222 = new JSONObject();
                                jSONObject3222222.put(str3, z2);
                                jSONObject3222222.put("duration_ms", currentTimeMillis3222222);
                                message = e.getMessage();
                                if (message == null) {
                                }
                                jSONObject3222222.put(ISignalReportConstants.KEY_REASON, message);
                                Unit unit2222222 = Unit.INSTANCE;
                                companion3222222.reportEvent(continuation2, jSONObject3222222);
                                String message3222222 = e.getMessage();
                                reportTokenRefresh$default(traeAuthManager, false, currentTimeMillis3222222, null, message3222222 == null ? "unexpected_exception" : message3222222, 4, null);
                                main = Dispatchers.getMain();
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$12(traeAuthCallback4, e, null);
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                                traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 9;
                                if (BuildersKt.withContext(main, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        }
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        r10 = traeAuthManager3;
                        r2 = r2;
                        j3 = j3;
                        try {
                            TraeAuthStorage.INSTANCE.clearFirstAppUpgrade();
                            deviceOverLimitDialogManager = DeviceOverLimitDialogManager.INSTANCE;
                            scene = DeviceOverLimitDialog.Scene.EXCHANGE;
                            callback = new DeviceOverLimitDialog.Callback() { // from class: com.bytedance.trae.login.traeauth.TraeAuthManager$$ExternalSyntheticLambda1
                                @Override // com.bytedance.trae.login.DeviceOverLimitDialog.Callback
                                public final void onResult(boolean z5) {
                                    TraeAuthManager.exchangeTokenOrThrowIgnoreDevice$lambda$1(str6, r2, z5);
                                }
                            };
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = r10;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = r2;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = obj2;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.J$0 = j3;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 5;
                            r2 = r2;
                            j3 = j3;
                            r10 = r10;
                            if (deviceOverLimitDialogManager.showWhenReady((ListDevicesResult) obj3, scene, callback, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Unit unit5 = Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            Boxing.boxInt(Log.e("InitAppLog", "listDevices failed: " + th.getMessage()));
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        long j5 = traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.J$0;
                        boolean z5 = traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.Z$0;
                        TraeAuthCallback traeAuthCallback7 = (TraeAuthCallback) traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2;
                        String str7 = (String) traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1;
                        TraeAuthManager traeAuthManager4 = (TraeAuthManager) traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0;
                        try {
                            ResultKt.throwOnFailure(obj3);
                            continuation3 = "icube_token_refresh_result";
                            str4 = TAG;
                            str5 = "success";
                            z2 = false;
                            z3 = true;
                            traeAuthManager3 = traeAuthManager4;
                            obj = obj3;
                            z4 = z5;
                            str6 = str7;
                            r2 = traeAuthCallback7;
                            j3 = j5;
                            traeExchangeTokenResult = (TraeExchangeTokenResult) obj;
                            if (Intrinsics.areEqual(traeExchangeTokenResult.isDeviceLimit(), Boxing.boxBoolean(z3))) {
                            }
                        } catch (TraeAuthException e21) {
                            e = e21;
                            continuation2 = "icube_token_refresh_result";
                            traeAuthManager2 = traeAuthManager4;
                            str2 = TAG;
                            str3 = "success";
                            z2 = false;
                            traeAuthCallback5 = traeAuthCallback7;
                            r52 = j5;
                            long currentTimeMillis22222222 = System.currentTimeMillis() - r52;
                            FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist failed: [" + e.getCode() + "] " + e.getMessage());
                            IApplog.Companion companion22222222 = IApplog.Companion;
                            JSONObject jSONObject22222222 = new JSONObject();
                            jSONObject22222222.put(str3, z2);
                            jSONObject22222222.put("duration_ms", currentTimeMillis22222222);
                            code = e.getCode();
                            if (code == null) {
                            }
                            jSONObject22222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                            message2 = e.getMessage();
                            if (message2 == null) {
                            }
                            jSONObject22222222.put(ISignalReportConstants.KEY_REASON, message2);
                            Unit unit3222222 = Unit.INSTANCE;
                            companion22222222.reportEvent(continuation2, jSONObject22222222);
                            traeAuthManager2.reportTokenRefresh(false, currentTimeMillis22222222, e.getCode(), e.getMessage());
                            if ((!Intrinsics.areEqual(e.getCode(), ERROR_CODE_REFRESH_TOKEN_EXPIRED) || Intrinsics.areEqual(e.getCode(), ERROR_CODE_NOT_LOGGED_IN)) ? true : z2) {
                            }
                            main2 = Dispatchers.getMain();
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$10(traeAuthCallback5, e, null);
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 8;
                            if (BuildersKt.withContext(main2, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        } catch (Exception e22) {
                            e = e22;
                            continuation2 = "icube_token_refresh_result";
                            traeAuthManager = traeAuthManager4;
                            str2 = TAG;
                            str3 = "success";
                            z2 = false;
                            traeAuthCallback4 = traeAuthCallback7;
                            r5 = j5;
                            long currentTimeMillis32222222 = System.currentTimeMillis() - r5;
                            FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist exception: " + e.getMessage());
                            IApplog.Companion companion32222222 = IApplog.Companion;
                            JSONObject jSONObject32222222 = new JSONObject();
                            jSONObject32222222.put(str3, z2);
                            jSONObject32222222.put("duration_ms", currentTimeMillis32222222);
                            message = e.getMessage();
                            if (message == null) {
                            }
                            jSONObject32222222.put(ISignalReportConstants.KEY_REASON, message);
                            Unit unit22222222 = Unit.INSTANCE;
                            companion32222222.reportEvent(continuation2, jSONObject32222222);
                            String message32222222 = e.getMessage();
                            reportTokenRefresh$default(traeAuthManager, false, currentTimeMillis32222222, null, message32222222 == null ? "unexpected_exception" : message32222222, 4, null);
                            main = Dispatchers.getMain();
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$12(traeAuthCallback4, e, null);
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 9;
                            if (BuildersKt.withContext(main, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        }
                        break;
                    case 2:
                        j4 = traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.J$0;
                        TraeAuthCallback traeAuthCallback8 = (TraeAuthCallback) traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1;
                        TraeAuthManager traeAuthManager5 = (TraeAuthManager) traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0;
                        ResultKt.throwOnFailure(obj3);
                        continuation3 = "icube_token_refresh_result";
                        str4 = TAG;
                        traeAuthManager3 = traeAuthManager5;
                        str5 = "success";
                        continuation4 = null;
                        z2 = false;
                        traeAuthCallback6 = traeAuthCallback8;
                        main3 = Dispatchers.getMain();
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$3 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3(traeAuthCallback6, continuation4);
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = traeAuthManager3;
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = traeAuthCallback6;
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.J$0 = j4;
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 3;
                        if (BuildersKt.withContext(main3, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$3, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        long j6 = traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.J$0;
                        ResultKt.throwOnFailure(obj3);
                        return Unit.INSTANCE;
                    case 4:
                        long j7 = traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.J$0;
                        TraeAuthCallback traeAuthCallback9 = (TraeAuthCallback) traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2;
                        str6 = (String) traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1;
                        TraeAuthManager traeAuthManager6 = (TraeAuthManager) traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0;
                        ResultKt.throwOnFailure(obj3);
                        continuation3 = "icube_token_refresh_result";
                        str4 = TAG;
                        str5 = "success";
                        obj2 = null;
                        z2 = false;
                        r2 = traeAuthCallback9;
                        j3 = j7;
                        r10 = traeAuthManager6;
                        TraeAuthStorage.INSTANCE.clearFirstAppUpgrade();
                        deviceOverLimitDialogManager = DeviceOverLimitDialogManager.INSTANCE;
                        scene = DeviceOverLimitDialog.Scene.EXCHANGE;
                        callback = new DeviceOverLimitDialog.Callback() { // from class: com.bytedance.trae.login.traeauth.TraeAuthManager$$ExternalSyntheticLambda1
                            @Override // com.bytedance.trae.login.DeviceOverLimitDialog.Callback
                            public final void onResult(boolean z52) {
                                TraeAuthManager.exchangeTokenOrThrowIgnoreDevice$lambda$1(str6, r2, z52);
                            }
                        };
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = r10;
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = r2;
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = obj2;
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.J$0 = j3;
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 5;
                        r2 = r2;
                        j3 = j3;
                        r10 = r10;
                        if (deviceOverLimitDialogManager.showWhenReady((ListDevicesResult) obj3, scene, callback, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                        }
                        Unit unit52 = Unit.INSTANCE;
                        return Unit.INSTANCE;
                    case 5:
                        long j8 = traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.J$0;
                        TraeAuthCallback traeAuthCallback10 = (TraeAuthCallback) traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1;
                        TraeAuthManager traeAuthManager7 = (TraeAuthManager) traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0;
                        ResultKt.throwOnFailure(obj3);
                        continuation3 = "icube_token_refresh_result";
                        str4 = TAG;
                        str5 = "success";
                        z2 = false;
                        r2 = traeAuthCallback10;
                        j3 = j8;
                        r10 = traeAuthManager7;
                        Unit unit522 = Unit.INSTANCE;
                        return Unit.INSTANCE;
                    case 6:
                        long j9 = traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.J$0;
                        TraeAuthCallback traeAuthCallback11 = (TraeAuthCallback) traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1;
                        traeAuthManager = (TraeAuthManager) traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0;
                        try {
                            ResultKt.throwOnFailure(obj3);
                        } catch (TraeAuthException e23) {
                            e = e23;
                            str2 = TAG;
                            traeAuthManager2 = traeAuthManager;
                            z2 = false;
                            continuation2 = "icube_token_refresh_result";
                            str3 = "success";
                            r52 = j9;
                            traeAuthCallback5 = traeAuthCallback11;
                            long currentTimeMillis222222222 = System.currentTimeMillis() - r52;
                            FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist failed: [" + e.getCode() + "] " + e.getMessage());
                            IApplog.Companion companion222222222 = IApplog.Companion;
                            JSONObject jSONObject222222222 = new JSONObject();
                            jSONObject222222222.put(str3, z2);
                            jSONObject222222222.put("duration_ms", currentTimeMillis222222222);
                            code = e.getCode();
                            if (code == null) {
                            }
                            jSONObject222222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                            message2 = e.getMessage();
                            if (message2 == null) {
                            }
                            jSONObject222222222.put(ISignalReportConstants.KEY_REASON, message2);
                            Unit unit32222222 = Unit.INSTANCE;
                            companion222222222.reportEvent(continuation2, jSONObject222222222);
                            traeAuthManager2.reportTokenRefresh(false, currentTimeMillis222222222, e.getCode(), e.getMessage());
                            if ((!Intrinsics.areEqual(e.getCode(), ERROR_CODE_REFRESH_TOKEN_EXPIRED) || Intrinsics.areEqual(e.getCode(), ERROR_CODE_NOT_LOGGED_IN)) ? true : z2) {
                            }
                            main2 = Dispatchers.getMain();
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$10(traeAuthCallback5, e, null);
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 8;
                            if (BuildersKt.withContext(main2, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        } catch (Exception e24) {
                            e = e24;
                            str2 = TAG;
                            z2 = false;
                            continuation2 = "icube_token_refresh_result";
                            str3 = "success";
                            r5 = j9;
                            traeAuthCallback4 = traeAuthCallback11;
                            long currentTimeMillis322222222 = System.currentTimeMillis() - r5;
                            FLogger.INSTANCE.mo426e(str2, "performExchangeAndPersist exception: " + e.getMessage());
                            IApplog.Companion companion322222222 = IApplog.Companion;
                            JSONObject jSONObject322222222 = new JSONObject();
                            jSONObject322222222.put(str3, z2);
                            jSONObject322222222.put("duration_ms", currentTimeMillis322222222);
                            message = e.getMessage();
                            if (message == null) {
                            }
                            jSONObject322222222.put(ISignalReportConstants.KEY_REASON, message);
                            Unit unit222222222 = Unit.INSTANCE;
                            companion322222222.reportEvent(continuation2, jSONObject322222222);
                            String message322222222 = e.getMessage();
                            reportTokenRefresh$default(traeAuthManager, false, currentTimeMillis322222222, null, message322222222 == null ? "unexpected_exception" : message322222222, 4, null);
                            main = Dispatchers.getMain();
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$12(traeAuthCallback4, e, null);
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                            traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 9;
                            if (BuildersKt.withContext(main, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$12, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    case 7:
                        e = (TraeAuthException) traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1;
                        traeAuthCallback5 = (TraeAuthCallback) traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0;
                        ResultKt.throwOnFailure(obj3);
                        main2 = Dispatchers.getMain();
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$10(traeAuthCallback5, e, null);
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$0 = null;
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$1 = null;
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.L$2 = null;
                        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13.label = 8;
                        if (BuildersKt.withContext(main2, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$10, traeAuthManager$exchangeTokenOrThrowIgnoreDevice$13) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 8:
                    case 9:
                        ResultKt.throwOnFailure(obj3);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        traeAuthManager$exchangeTokenOrThrowIgnoreDevice$1 = new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1(this, continuation);
        TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$1 traeAuthManager$exchangeTokenOrThrowIgnoreDevice$132 = traeAuthManager$exchangeTokenOrThrowIgnoreDevice$1;
        Object obj32 = traeAuthManager$exchangeTokenOrThrowIgnoreDevice$132.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = traeAuthManager$exchangeTokenOrThrowIgnoreDevice$132.label;
        switch (r2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exchangeTokenOrThrowIgnoreDevice$lambda$1(String str, TraeAuthCallback traeAuthCallback, boolean z) {
        if (z) {
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1(str, traeAuthCallback, null), 3, (Object) null);
            return;
        }
        Activity currentActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
        if (currentActivity != null) {
            ForceLogoutUtils.INSTANCE.performForceLogout(currentActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x01e2 -> B:11:0x01e5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x01f5 -> B:12:0x020d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object retryOnTransient(int i, String str, String str2, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        TraeAuthManager$retryOnTransient$1 traeAuthManager$retryOnTransient$1;
        int i2;
        Ref.ObjectRef objectRef;
        TraeAuthManager$retryOnTransient$1 traeAuthManager$retryOnTransient$12;
        Object obj;
        int i3;
        int i4;
        int i5;
        String str3;
        String str4;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        String str5;
        String str6;
        Ref.ObjectRef objectRef2;
        int i6;
        int i7;
        int i8;
        TraeAuthException e;
        long j;
        int i9;
        if (continuation instanceof TraeAuthManager$retryOnTransient$1) {
            traeAuthManager$retryOnTransient$1 = (TraeAuthManager$retryOnTransient$1) continuation;
            if ((traeAuthManager$retryOnTransient$1.label & Integer.MIN_VALUE) != 0) {
                traeAuthManager$retryOnTransient$1.label -= Integer.MIN_VALUE;
                Object obj2 = traeAuthManager$retryOnTransient$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = traeAuthManager$retryOnTransient$1.label;
                char c = '/';
                String str7 = "retryOnTransient[";
                if (i2 == 0) {
                    if (i2 == 1) {
                        i8 = traeAuthManager$retryOnTransient$1.I$3;
                        int i10 = traeAuthManager$retryOnTransient$1.I$2;
                        int i11 = traeAuthManager$retryOnTransient$1.I$1;
                        int i12 = traeAuthManager$retryOnTransient$1.I$0;
                        Ref.ObjectRef objectRef3 = (Ref.ObjectRef) traeAuthManager$retryOnTransient$1.L$3;
                        Function1<? super Continuation<? super T>, ? extends Object> function13 = (Function1) traeAuthManager$retryOnTransient$1.L$2;
                        String str8 = (String) traeAuthManager$retryOnTransient$1.L$1;
                        String str9 = (String) traeAuthManager$retryOnTransient$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                        } catch (TraeAuthException e2) {
                            e = e2;
                            str5 = str9;
                            function12 = function13;
                            str6 = str8;
                            i4 = i10;
                            i7 = i11;
                            i6 = i12;
                            objectRef2 = objectRef3;
                            objectRef2.element = e;
                            Object obj3 = coroutine_suspended;
                            if (!e.getIsRetryable()) {
                            }
                            FLogger.INSTANCE.mo426e(TAG, str7 + str5 + "]: giving up after attempt #" + (i8 + 1) + ": [" + e.getCode() + "] " + e.getMessage() + ", isRetryable=" + e.getIsRetryable());
                            e.setStep(str5);
                            throw e;
                        }
                    }
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i13 = traeAuthManager$retryOnTransient$1.I$2;
                    int i14 = traeAuthManager$retryOnTransient$1.I$1;
                    i6 = traeAuthManager$retryOnTransient$1.I$0;
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) traeAuthManager$retryOnTransient$1.L$3;
                    Function1<? super Continuation<? super T>, ? extends Object> function14 = (Function1) traeAuthManager$retryOnTransient$1.L$2;
                    str6 = (String) traeAuthManager$retryOnTransient$1.L$1;
                    str5 = (String) traeAuthManager$retryOnTransient$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    String str10 = "retryOnTransient[";
                    function12 = function14;
                    Ref.ObjectRef objectRef5 = objectRef4;
                    char c2 = '/';
                    Object obj4 = coroutine_suspended;
                    str3 = str5;
                    int i15 = 1;
                    int i16 = i6;
                    traeAuthManager$retryOnTransient$12 = traeAuthManager$retryOnTransient$1;
                    i5 = i16;
                    Ref.ObjectRef objectRef6 = objectRef5;
                    int i17 = i13;
                    str4 = str6;
                    i3 = i14;
                    objectRef = objectRef6;
                    i4 = i17 + i15;
                    c = c2;
                    str7 = str10;
                    obj = obj4;
                    if (i4 >= i3) {
                        if (i4 > 0) {
                            try {
                            } catch (TraeAuthException e3) {
                                e = e3;
                                str5 = str3;
                                coroutine_suspended = obj;
                                objectRef2 = objectRef;
                                i7 = i3;
                                str6 = str4;
                                i8 = i4;
                                TraeAuthManager$retryOnTransient$1 traeAuthManager$retryOnTransient$13 = traeAuthManager$retryOnTransient$12;
                                i6 = i5;
                                traeAuthManager$retryOnTransient$1 = traeAuthManager$retryOnTransient$13;
                                objectRef2.element = e;
                                Object obj32 = coroutine_suspended;
                                if (!e.getIsRetryable() && i8 < i6) {
                                    int i18 = i7;
                                    if (i8 == 0) {
                                        i9 = i4;
                                        j = 0;
                                    } else {
                                        j = i8 * 500;
                                        i9 = i4;
                                    }
                                    Ref.ObjectRef objectRef7 = objectRef2;
                                    str10 = str7;
                                    int i19 = i8 + 1;
                                    c2 = '/';
                                    FLogger.INSTANCE.mo430w(TAG, str7 + str5 + "]: retry #" + i19 + '/' + i6 + ": [" + e.getCode() + "] " + e.getMessage() + ", isRetryable=" + e.getIsRetryable() + ", delay=" + j + "ms");
                                    reportLoginFunnel$default(INSTANCE, STAGE_TRANSIENT_RETRY, str6, null, str5, e.getCode(), "attempt_" + i19 + ": " + e.getMessage(), null, null, e.getLogId(), null, null, 1732, null);
                                    if (j > 0) {
                                        traeAuthManager$retryOnTransient$1.L$0 = str5;
                                        traeAuthManager$retryOnTransient$1.L$1 = str6;
                                        traeAuthManager$retryOnTransient$1.L$2 = function12;
                                        objectRef5 = objectRef7;
                                        traeAuthManager$retryOnTransient$1.L$3 = objectRef5;
                                        traeAuthManager$retryOnTransient$1.I$0 = i6;
                                        traeAuthManager$retryOnTransient$1.I$1 = i18;
                                        int i20 = i9;
                                        traeAuthManager$retryOnTransient$1.I$2 = i20;
                                        traeAuthManager$retryOnTransient$1.label = 2;
                                        if (DelayKt.delay(j, traeAuthManager$retryOnTransient$1) == obj32) {
                                            return obj32;
                                        }
                                        i14 = i18;
                                        coroutine_suspended = obj32;
                                        i13 = i20;
                                        Object obj42 = coroutine_suspended;
                                        str3 = str5;
                                        int i152 = 1;
                                        int i162 = i6;
                                        traeAuthManager$retryOnTransient$12 = traeAuthManager$retryOnTransient$1;
                                        i5 = i162;
                                        Ref.ObjectRef objectRef62 = objectRef5;
                                        int i172 = i13;
                                        str4 = str6;
                                        i3 = i14;
                                        objectRef = objectRef62;
                                        i4 = i172 + i152;
                                        c = c2;
                                        str7 = str10;
                                        obj = obj42;
                                        if (i4 >= i3) {
                                        }
                                    } else {
                                        objectRef = objectRef7;
                                        str3 = str5;
                                        i152 = 1;
                                        i172 = i9;
                                        String str11 = str6;
                                        i3 = i18;
                                        obj42 = obj32;
                                        str4 = str11;
                                        int i21 = i6;
                                        traeAuthManager$retryOnTransient$12 = traeAuthManager$retryOnTransient$1;
                                        i5 = i21;
                                        i4 = i172 + i152;
                                        c = c2;
                                        str7 = str10;
                                        obj = obj42;
                                        if (i4 >= i3) {
                                        }
                                    }
                                } else {
                                    FLogger.INSTANCE.mo426e(TAG, str7 + str5 + "]: giving up after attempt #" + (i8 + 1) + ": [" + e.getCode() + "] " + e.getMessage() + ", isRetryable=" + e.getIsRetryable());
                                    e.setStep(str5);
                                    throw e;
                                }
                            }
                            FLogger.INSTANCE.mo428i(TAG, str7 + str3 + "]: attempt #" + (i4 + 1) + c + (i5 + 1));
                        }
                        traeAuthManager$retryOnTransient$12.L$0 = str3;
                        traeAuthManager$retryOnTransient$12.L$1 = str4;
                        traeAuthManager$retryOnTransient$12.L$2 = function12;
                        traeAuthManager$retryOnTransient$12.L$3 = objectRef;
                        traeAuthManager$retryOnTransient$12.I$0 = i5;
                        traeAuthManager$retryOnTransient$12.I$1 = i3;
                        traeAuthManager$retryOnTransient$12.I$2 = i4;
                        traeAuthManager$retryOnTransient$12.I$3 = i4;
                        traeAuthManager$retryOnTransient$12.label = 1;
                        obj2 = function12.invoke(traeAuthManager$retryOnTransient$12);
                        return obj2 == obj ? obj : obj2;
                    }
                    Object obj5 = objectRef.element;
                    Intrinsics.checkNotNull(obj5);
                    ((TraeAuthException) obj5).setStep(str3);
                    throw ((Throwable) obj5);
                }
                ResultKt.throwOnFailure(obj2);
                objectRef = new Ref.ObjectRef();
                traeAuthManager$retryOnTransient$12 = traeAuthManager$retryOnTransient$1;
                obj = coroutine_suspended;
                i3 = i + 1;
                i4 = 0;
                i5 = i;
                str3 = str;
                str4 = str2;
                function12 = function1;
                if (i4 >= i3) {
                }
            }
        }
        traeAuthManager$retryOnTransient$1 = new TraeAuthManager$retryOnTransient$1(this, continuation);
        Object obj22 = traeAuthManager$retryOnTransient$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = traeAuthManager$retryOnTransient$1.label;
        char c3 = '/';
        String str72 = "retryOnTransient[";
        if (i2 == 0) {
        }
    }

    static /* synthetic */ Object retryOnTransient$default(TraeAuthManager traeAuthManager, int i, String str, String str2, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return traeAuthManager.retryOnTransient(i, str3, str2, function1, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r0 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isTransientError(Throwable e) {
        String str;
        String message = e.getMessage();
        if (message != null) {
            str = message.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        }
        str = "";
        if (!(e instanceof SocketException) && !(e instanceof SocketTimeoutException)) {
            String str2 = str;
            if (!StringsKt.contains$default(str2, "broken pipe", false, 2, (Object) null) && !StringsKt.contains$default(str2, "connection reset", false, 2, (Object) null) && !StringsKt.contains$default(str2, "connection abort", false, 2, (Object) null) && !StringsKt.contains$default(str2, EventConstants.PARAM_TIME_OUT, false, 2, (Object) null) && !StringsKt.contains$default(str2, "eof", false, 2, (Object) null) && !StringsKt.contains$default(str2, "stream was reset", false, 2, (Object) null) && !StringsKt.contains$default(str2, "err_name_not_resolved", false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    private final int extractHttpStatusCode(Throwable e) {
        while (e != null) {
            if (e instanceof CronetIOException) {
                return ((CronetIOException) e).getStatusCode();
            }
            if (e instanceof HttpResponseException) {
                return ((HttpResponseException) e).getStatusCode();
            }
            e = e.getCause();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doLoginOrThrow(String str, Continuation<? super String> continuation) throws TraeAuthException {
        TraeAuthManager$doLoginOrThrow$1 traeAuthManager$doLoginOrThrow$1;
        int i;
        TraeAuthManager traeAuthManager;
        long j;
        Integer boxInt;
        TraeResponseWithRaw parseResponse;
        String str2;
        if (continuation instanceof TraeAuthManager$doLoginOrThrow$1) {
            traeAuthManager$doLoginOrThrow$1 = (TraeAuthManager$doLoginOrThrow$1) continuation;
            if ((traeAuthManager$doLoginOrThrow$1.label & Integer.MIN_VALUE) != 0) {
                traeAuthManager$doLoginOrThrow$1.label -= Integer.MIN_VALUE;
                Object obj = traeAuthManager$doLoginOrThrow$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = traeAuthManager$doLoginOrThrow$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        String baseUrl = TraeAuthConfig.INSTANCE.getBaseUrl();
                        Map<String, String> buildDeviceHeaders = buildDeviceHeaders();
                        FLogger.INSTANCE.mo428i(TAG, "doLogin: requesting " + baseUrl + ", deviceId=" + buildDeviceHeaders.get("x-device-id") + ", machineId=" + buildDeviceHeaders.get("x-machine-id"));
                        TraeAuthApi traeAuthApi = (TraeAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "trae_auth", TraeAuthApi.class, null, baseUrl, buildDeviceHeaders, false, 36, null);
                        TraeLoginRequest traeLoginRequest = new TraeLoginRequest(TraeAuthConfig.INSTANCE.getLoginChannel(), TraeAuthConfig.INSTANCE.getPlatform(), null, null, null, null, null, null, null, null, null, null, null, null, null, 32764, null);
                        traeAuthManager$doLoginOrThrow$1.L$0 = this;
                        traeAuthManager$doLoginOrThrow$1.J$0 = currentTimeMillis;
                        traeAuthManager$doLoginOrThrow$1.label = 1;
                        obj = traeAuthApi.login(traeLoginRequest, str, traeAuthManager$doLoginOrThrow$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        traeAuthManager = this;
                        j = currentTimeMillis;
                    } catch (Exception e) {
                        e = e;
                        traeAuthManager = this;
                        j = currentTimeMillis;
                        Exception exc = e;
                        int extractHttpStatusCode = traeAuthManager.extractHttpStatusCode(exc);
                        FLogger.INSTANCE.mo426e(TAG, "doLogin network exception: " + e.getClass().getSimpleName() + ' ' + e.getMessage() + ", httpStatus=" + extractHttpStatusCode + ", elapsed=" + (System.currentTimeMillis() - j) + "ms");
                        boxInt = Boxing.boxInt(extractHttpStatusCode);
                        if (!(boxInt.intValue() > 0)) {
                        }
                        throw new TraeAuthException(boxInt == null ? boxInt.toString() : null, "doLogin network error: " + e.getMessage(), traeAuthManager.isTransientError(exc), exc, extractHttpStatusCode == 401 ? "登录受到安全策略限制，请稍后再试" : null, null, null, null, 224, null);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = traeAuthManager$doLoginOrThrow$1.J$0;
                    traeAuthManager = (TraeAuthManager) traeAuthManager$doLoginOrThrow$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e2) {
                        e = e2;
                        Exception exc2 = e;
                        int extractHttpStatusCode2 = traeAuthManager.extractHttpStatusCode(exc2);
                        FLogger.INSTANCE.mo426e(TAG, "doLogin network exception: " + e.getClass().getSimpleName() + ' ' + e.getMessage() + ", httpStatus=" + extractHttpStatusCode2 + ", elapsed=" + (System.currentTimeMillis() - j) + "ms");
                        boxInt = Boxing.boxInt(extractHttpStatusCode2);
                        if (!(boxInt.intValue() > 0)) {
                            boxInt = null;
                        }
                        throw new TraeAuthException(boxInt == null ? boxInt.toString() : null, "doLogin network error: " + e.getMessage(), traeAuthManager.isTransientError(exc2), exc2, extractHttpStatusCode2 == 401 ? "登录受到安全策略限制，请稍后再试" : null, null, null, null, 224, null);
                    }
                }
                SsResponse<String> ssResponse = (SsResponse) obj;
                FLogger.INSTANCE.mo428i(TAG, "doLogin: response received in " + (System.currentTimeMillis() - j) + "ms");
                String str3 = (String) CollectionsKt.firstOrNull(traeAuthManager.getHeaderValues(ssResponse, SccUtils.HEADER_LOG_ID));
                parseResponse = traeAuthManager.parseResponse(ssResponse, TraeLoginResult.class);
                if (parseResponse != null) {
                    FLogger.INSTANCE.mo426e(TAG, "doLogin: response body is null");
                    throw new TraeAuthException(null, "doLogin response body is null", true, null, null, null, null, str3, 120, null);
                }
                TraeResponseMetadata responseMetadata = parseResponse.getResponseMetadata();
                TraeResponseError error = responseMetadata != null ? responseMetadata.getError() : null;
                if (error != null) {
                    FLogger.INSTANCE.mo426e(TAG, "doLogin business error: [" + error.getCode() + "] " + error.getMessage());
                    throw new TraeAuthException(error.getCode(), "doLogin failed: " + error.getMessage(), false, null, error.getMessage(), null, null, str3, 104, null);
                }
                String extractCookieFromResponse = traeAuthManager.extractCookieFromResponse(parseResponse.getSsResponse(), "X-Cloudide-Session");
                String extractCookieFromCookieManager = extractCookieFromResponse == null ? traeAuthManager.extractCookieFromCookieManager("X-Cloudide-Session") : extractCookieFromResponse;
                if (extractCookieFromResponse == null) {
                    String str4 = extractCookieFromCookieManager;
                    FLogger.INSTANCE.mo430w(TAG, "doLogin: extractCookieFromResponse returned null, fallback to CookieManager (hasValue=" + (!(str4 == null || str4.length() == 0)) + "), logId=" + str3);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(FluencyHelper.STAGE, "session_cookie_fallback");
                    jSONObject.put("cookie_manager_has_value", !(str4 == null || str4.length() == 0));
                    jSONObject.put("log_id", str3 == null ? "" : str3);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("reason_detail", "extractCookieFromResponse returned null, used CookieManager fallback");
                    Unit unit = Unit.INSTANCE;
                    ApmAgent.monitorEvent(EVENT_LOGIN_FUNNEL, jSONObject, (JSONObject) null, jSONObject2);
                }
                FLogger fLogger = FLogger.INSTANCE;
                StringBuilder sb = new StringBuilder("cloudideSession: ");
                String str5 = extractCookieFromCookieManager;
                if (str5 == null || str5.length() == 0) {
                    str2 = "EMPTY";
                } else {
                    str2 = "obtained (" + extractCookieFromCookieManager.length() + " chars), fromResponse=" + (extractCookieFromResponse != null);
                }
                fLogger.mo428i(TAG, sb.append(str2).append(", logId=").append(str3).toString());
                if (str5 == null || str5.length() == 0) {
                    throw new TraeAuthException(null, "Failed to extract X-Cloudide-Session", true, null, null, null, null, str3, 120, null);
                }
                return extractCookieFromCookieManager;
            }
        }
        traeAuthManager$doLoginOrThrow$1 = new TraeAuthManager$doLoginOrThrow$1(this, continuation);
        Object obj2 = traeAuthManager$doLoginOrThrow$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = traeAuthManager$doLoginOrThrow$1.label;
        if (i != 0) {
        }
        SsResponse<String> ssResponse2 = (SsResponse) obj2;
        FLogger.INSTANCE.mo428i(TAG, "doLogin: response received in " + (System.currentTimeMillis() - j) + "ms");
        String str32 = (String) CollectionsKt.firstOrNull(traeAuthManager.getHeaderValues(ssResponse2, SccUtils.HEADER_LOG_ID));
        parseResponse = traeAuthManager.parseResponse(ssResponse2, TraeLoginResult.class);
        if (parseResponse != null) {
        }
    }

    static /* synthetic */ Object doLoginOrThrow$default(TraeAuthManager traeAuthManager, String str, Continuation continuation, int i, Object obj) throws TraeAuthException {
        if ((i & 1) != 0) {
            str = null;
        }
        return traeAuthManager.doLoginOrThrow(str, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doGetRefreshTokenOrThrow(String str, Continuation<? super TraeGetRefreshTokenResult> continuation) throws TraeAuthException {
        String str2;
        TraeGetRefreshTokenRequest traeGetRefreshTokenRequest;
        SsResponse<String> execute;
        int code;
        Object obj;
        String value;
        if (str.length() == 0) {
            throw new TraeAuthException(null, "doGetRefreshToken: cloudideSession is empty", false, null, null, null, null, null, 248, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String deviceId = IApplog.Companion.getDeviceId();
        if (DebugSettings.INSTANCE.isDeviceManagerMockDid()) {
            deviceId = "";
        }
        try {
            String baseUrl = TraeAuthConfig.INSTANCE.getBaseUrl();
            String buildCookieHeader = buildCookieHeader(MapsKt.mapOf(TuplesKt.to("X-Cloudide-Session", str)));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("Cookie", buildCookieHeader);
            linkedHashMap.put(XBridgeAPIRequestUtils.CONTENT_TYPE, "application/json");
            TraeAuthApi traeAuthApi = (TraeAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "trae_auth", TraeAuthApi.class, null, baseUrl, linkedHashMap, false, 36, null);
            RequestContext requestContext = new RequestContext();
            requestContext.force_handle_response = true;
            if (TextUtils.isEmpty(deviceId)) {
                traeGetRefreshTokenRequest = new TraeGetRefreshTokenRequest(TraeAuthConfig.INSTANCE.getClientId(), null, null, null, 14, null);
            } else {
                traeGetRefreshTokenRequest = new TraeGetRefreshTokenRequest(TraeAuthConfig.INSTANCE.getClientId(), deviceId, TraeAuthDeviceManager.INSTANCE.getDeviceInfo(), TraeAuthDeviceManager.getDeviceProof$default(TraeAuthDeviceManager.INSTANCE, "POST", "/trae/api/v3/oauth/GetRefreshToken", null, 4, null));
            }
            execute = traeAuthApi.getRefreshTokenRaw(traeGetRefreshTokenRequest, requestContext).execute();
            code = execute.code();
            List<Header> headers = execute.headers();
            Intrinsics.checkNotNullExpressionValue(headers, "headers(...)");
            Iterator<T> it = headers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (StringsKt.equals(((Header) obj).getName(), SccUtils.HEADER_LOG_ID, true)) {
                    break;
                }
            }
            Header header = (Header) obj;
            value = header != null ? header.getValue() : null;
        } catch (Exception e) {
            e = e;
            str2 = null;
        }
        try {
            String body = execute.body();
            if (body == null) {
                TraeAuthManager traeAuthManager = this;
                TypedInput errorBody = execute.errorBody();
                if (errorBody != null) {
                    InputStream mo349in = errorBody.mo349in();
                    Intrinsics.checkNotNullExpressionValue(mo349in, "in(...)");
                    Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    try {
                        String readText = TextStreamsKt.readText(bufferedReader);
                        CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                        body = readText;
                    } finally {
                    }
                } else {
                    body = null;
                }
            }
            FLogger.INSTANCE.mo428i(TAG, "doGetRefreshToken: response received in " + (System.currentTimeMillis() - currentTimeMillis) + "ms, logId=" + value);
            TraeResponse parseResponse = parseResponse(body, TraeGetRefreshTokenResult.class);
            if (parseResponse == null) {
                FLogger.INSTANCE.mo426e(TAG, "doGetRefreshToken: response body is null");
                throw new TraeAuthException(null, "doGetRefreshToken response body is null", true, null, null, null, Boxing.boxInt(code), value, 56, null);
            }
            TraeResponseMetadata responseMetadata = parseResponse.getResponseMetadata();
            TraeResponseError error = responseMetadata != null ? responseMetadata.getError() : null;
            if (error != null) {
                FLogger.INSTANCE.mo426e(TAG, "doGetRefreshToken business error: [" + error.getCode() + "] " + error.getMessage() + ' ' + error.getStandardCode());
                if (Intrinsics.areEqual(error.getStandardCode(), ERROR_CODE_DEVICE_LIMIT_REACHED)) {
                    TraeGetRefreshTokenResult traeGetRefreshTokenResult = new TraeGetRefreshTokenResult(null, null, null, null, null, null, 63, null);
                    traeGetRefreshTokenResult.setDeviceLimitReached(Boxing.boxBoolean(true));
                    return traeGetRefreshTokenResult;
                }
                throw new TraeAuthException(error.getCode(), "doGetRefreshToken failed: " + error.getMessage(), Intrinsics.areEqual(error.getCode(), ERROR_CODE_SESSION_NOT_FOUND), null, error.getMessage(), null, Boxing.boxInt(code), value, 40, null);
            }
            TraeGetRefreshTokenResult traeGetRefreshTokenResult2 = (TraeGetRefreshTokenResult) parseResponse.getResult();
            String refreshToken = traeGetRefreshTokenResult2 != null ? traeGetRefreshTokenResult2.getRefreshToken() : null;
            if (refreshToken == null || refreshToken.length() == 0) {
                FLogger.INSTANCE.mo426e(TAG, "doGetRefreshToken: refreshToken is empty");
                throw new TraeAuthException(null, "doGetRefreshToken returned empty refreshToken", true, null, null, null, Boxing.boxInt(code), value, 56, null);
            }
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("doGetRefreshToken: success, refreshExpireAt=");
            Intrinsics.checkNotNull(traeGetRefreshTokenResult2);
            fLogger.mo428i(TAG, sb.append(traeGetRefreshTokenResult2.getRefreshExpireAt()).toString());
            return traeGetRefreshTokenResult2;
        } catch (Exception e2) {
            e = e2;
            str2 = value;
            FLogger.INSTANCE.mo426e(TAG, "doGetRefreshToken network exception: " + e.getClass().getSimpleName() + ' ' + e.getMessage() + ", elapsed=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            String str3 = "doGetRefreshToken network error: " + e.getMessage();
            Exception exc = e;
            throw new TraeAuthException(null, str3, isTransientError(exc), exc, null, null, null, str2, 112, null);
        }
    }

    public final Object listDevices(Continuation<? super ListDevicesResult> continuation) throws TraeAuthException {
        String cloudideSession = TraeAuthStorage.INSTANCE.getCloudideSession();
        if (cloudideSession.length() == 0) {
            throw new TraeAuthException(null, "listDevices: cloudideSession is empty", false, null, null, null, null, null, 248, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String baseUrl = TraeAuthConfig.INSTANCE.getBaseUrl();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("Cookie", buildCookieHeader(MapsKt.mapOf(TuplesKt.to("X-Cloudide-Session", cloudideSession))));
            linkedHashMap.put(XBridgeAPIRequestUtils.CONTENT_TYPE, "application/json");
            RequestContext requestContext = new RequestContext();
            requestContext.force_handle_response = true;
            SsResponse<String> execute = ((TraeAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "trae_auth", TraeAuthApi.class, null, baseUrl, linkedHashMap, false, 36, null)).listDevicesRaw(new ListDevicesRequest(TraeAuthDeviceManager.INSTANCE.getDeviceInfo()), requestContext).execute();
            FLogger.INSTANCE.mo426e(TAG, "listDevicesRaw:response:" + execute.code());
            if (execute.code() == 401) {
                throw new TraeAuthException(ERROR_CODE_REFRESH_TOKEN_EXPIRED, "listDevices: HTTP 401 - session invalid", false, null, null, null, null, null, 248, null);
            }
            String body = execute.body();
            if (body == null) {
                TraeAuthManager traeAuthManager = this;
                TypedInput errorBody = execute.errorBody();
                if (errorBody != null) {
                    InputStream mo349in = errorBody.mo349in();
                    Intrinsics.checkNotNullExpressionValue(mo349in, "in(...)");
                    Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    try {
                        body = TextStreamsKt.readText(bufferedReader);
                        CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                    } finally {
                    }
                } else {
                    body = null;
                }
            }
            FLogger.INSTANCE.mo428i(TAG, "listDevices: response received in " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            TraeResponse parseResponse = parseResponse(body, ListDevicesResult.class);
            if (parseResponse == null) {
                FLogger.INSTANCE.mo426e(TAG, "listDevices: response body is null");
                throw new TraeAuthException(null, "listDevices response body is null", true, null, null, null, Boxing.boxInt(0), null, 184, null);
            }
            TraeResponseMetadata responseMetadata = parseResponse.getResponseMetadata();
            TraeResponseError error = responseMetadata != null ? responseMetadata.getError() : null;
            if (error != null) {
                FLogger.INSTANCE.mo426e(TAG, "listDevices business error: [" + error.getCode() + "] " + error.getMessage());
                throw new TraeAuthException(error.getCode(), "listDevices failed: " + error.getMessage(), false, null, error.getMessage(), null, Boxing.boxInt(0), null, 168, null);
            }
            ListDevicesResult listDevicesResult = (ListDevicesResult) parseResponse.getResult();
            return listDevicesResult == null ? new ListDevicesResult(null, null, 3, null) : listDevicesResult;
        } catch (Throwable th) {
            FLogger.INSTANCE.mo426e(TAG, "listDevices network exception: " + th.getClass().getSimpleName() + ' ' + th.getMessage() + ", elapsed=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            if (extractHttpStatusCode(th) == 401) {
                throw new TraeAuthException(ERROR_CODE_REFRESH_TOKEN_EXPIRED, "listDevices: HTTP 401 - session invalid", false, th, null, null, null, null, 240, null);
            }
            throw new TraeAuthException(null, "listDevices network error: " + th.getMessage(), isTransientError(th), th, null, null, null, null, 240, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearRefreshToken(String str, Continuation<? super ClearRefreshTokenResult> continuation) throws TraeAuthException {
        TraeAuthManager$clearRefreshToken$1 traeAuthManager$clearRefreshToken$1;
        int i;
        TraeAuthManager traeAuthManager;
        long j;
        Exception exc;
        TraeResponse response;
        String str2 = str;
        if (continuation instanceof TraeAuthManager$clearRefreshToken$1) {
            traeAuthManager$clearRefreshToken$1 = (TraeAuthManager$clearRefreshToken$1) continuation;
            if ((traeAuthManager$clearRefreshToken$1.label & Integer.MIN_VALUE) != 0) {
                traeAuthManager$clearRefreshToken$1.label -= Integer.MIN_VALUE;
                Object obj = traeAuthManager$clearRefreshToken$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = traeAuthManager$clearRefreshToken$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (str2.length() == 0) {
                        throw new TraeAuthException(null, "clearRefreshToken: deviceId is empty", false, null, null, null, null, null, 248, null);
                    }
                    String cloudideSession = TraeAuthStorage.INSTANCE.getCloudideSession();
                    if (cloudideSession.length() == 0) {
                        throw new TraeAuthException(null, "clearRefreshToken: cloudideSession is empty", false, null, null, null, null, null, 248, null);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        String baseUrl = TraeAuthConfig.INSTANCE.getBaseUrl();
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("Cookie", buildCookieHeader(MapsKt.mapOf(TuplesKt.to("X-Cloudide-Session", cloudideSession))));
                        linkedHashMap.put(XBridgeAPIRequestUtils.CONTENT_TYPE, "application/json");
                        TraeAuthApi traeAuthApi = (TraeAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "trae_auth", TraeAuthApi.class, null, baseUrl, linkedHashMap, false, 36, null);
                        ClearRefreshTokenRequest clearRefreshTokenRequest = new ClearRefreshTokenRequest(TraeAuthConfig.INSTANCE.getClientId(), str2);
                        traeAuthManager$clearRefreshToken$1.L$0 = this;
                        traeAuthManager$clearRefreshToken$1.L$1 = str2;
                        traeAuthManager$clearRefreshToken$1.J$0 = currentTimeMillis;
                        traeAuthManager$clearRefreshToken$1.label = 1;
                        obj = traeAuthApi.clearRefreshToken(clearRefreshTokenRequest, traeAuthManager$clearRefreshToken$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        traeAuthManager = this;
                        j = currentTimeMillis;
                    } catch (Exception e) {
                        e = e;
                        traeAuthManager = this;
                        j = currentTimeMillis;
                        FLogger.INSTANCE.mo426e(TAG, "clearRefreshToken network exception: " + e.getClass().getSimpleName() + ' ' + e.getMessage() + ", elapsed=" + (System.currentTimeMillis() - j) + "ms");
                        exc = e;
                        if (traeAuthManager.extractHttpStatusCode(exc) != 401) {
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = traeAuthManager$clearRefreshToken$1.J$0;
                    str2 = (String) traeAuthManager$clearRefreshToken$1.L$1;
                    traeAuthManager = (TraeAuthManager) traeAuthManager$clearRefreshToken$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e2) {
                        e = e2;
                        FLogger.INSTANCE.mo426e(TAG, "clearRefreshToken network exception: " + e.getClass().getSimpleName() + ' ' + e.getMessage() + ", elapsed=" + (System.currentTimeMillis() - j) + "ms");
                        exc = e;
                        if (traeAuthManager.extractHttpStatusCode(exc) != 401) {
                            throw new TraeAuthException(ERROR_CODE_REFRESH_TOKEN_EXPIRED, "clearRefreshToken: HTTP 401 - session invalid", false, exc, null, null, null, null, 240, null);
                        }
                        throw new TraeAuthException(null, "clearRefreshToken network error: " + e.getMessage(), traeAuthManager.isTransientError(exc), exc, null, null, null, null, 240, null);
                    }
                }
                SsResponse<String> ssResponse = (SsResponse) obj;
                FLogger.INSTANCE.mo428i(TAG, "clearRefreshToken: response received in " + (System.currentTimeMillis() - j) + "ms, deviceId=" + str2);
                TraeResponseWithRaw parseResponse = traeAuthManager.parseResponse(ssResponse, ClearRefreshTokenResult.class);
                response = parseResponse == null ? parseResponse.getResponse() : null;
                if (response != null) {
                    FLogger.INSTANCE.mo426e(TAG, "clearRefreshToken: response body is null");
                    throw new TraeAuthException(null, "clearRefreshToken response body is null", true, null, null, null, null, null, 248, null);
                }
                TraeResponseMetadata responseMetadata = response.getResponseMetadata();
                TraeResponseError error = responseMetadata != null ? responseMetadata.getError() : null;
                if (error != null) {
                    FLogger.INSTANCE.mo426e(TAG, "clearRefreshToken business error: [" + error.getCode() + "] " + error.getMessage());
                    throw new TraeAuthException(error.getCode(), "clearRefreshToken failed: " + error.getMessage(), false, null, error.getMessage(), null, null, null, 232, null);
                }
                ClearRefreshTokenResult clearRefreshTokenResult = (ClearRefreshTokenResult) response.getResult();
                return clearRefreshTokenResult == null ? new ClearRefreshTokenResult(Boxing.boxBoolean(false), null, null, 6, null) : clearRefreshTokenResult;
            }
        }
        traeAuthManager$clearRefreshToken$1 = new TraeAuthManager$clearRefreshToken$1(this, continuation);
        Object obj2 = traeAuthManager$clearRefreshToken$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = traeAuthManager$clearRefreshToken$1.label;
        if (i != 0) {
        }
        SsResponse<String> ssResponse2 = (SsResponse) obj2;
        FLogger.INSTANCE.mo428i(TAG, "clearRefreshToken: response received in " + (System.currentTimeMillis() - j) + "ms, deviceId=" + str2);
        TraeResponseWithRaw parseResponse2 = traeAuthManager.parseResponse(ssResponse2, ClearRefreshTokenResult.class);
        if (parseResponse2 == null) {
        }
        if (response != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void bindDeviceAsync$default(TraeAuthManager traeAuthManager, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        traeAuthManager.bindDeviceAsync(function1);
    }

    public final void bindDeviceAsync(Function1<? super BindDeviceResult, Unit> onResult) {
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new TraeAuthManager$bindDeviceAsync$1(onResult, null), 3, (Object) null);
    }

    public static /* synthetic */ Object bindDevice$default(TraeAuthManager traeAuthManager, String str, DeviceInfo deviceInfo, DeviceProof deviceProof, Continuation continuation, int i, Object obj) throws TraeAuthException {
        if ((i & 4) != 0) {
            deviceProof = null;
        }
        return traeAuthManager.bindDevice(str, deviceInfo, deviceProof, continuation);
    }

    public final Object bindDevice(String str, DeviceInfo deviceInfo, DeviceProof deviceProof, Continuation<? super BindDeviceResult> continuation) throws TraeAuthException {
        if (str.length() == 0) {
            throw new TraeAuthException(null, "bindDevice: refreshToken is empty", false, null, null, null, null, null, 248, null);
        }
        String cloudideSession = TraeAuthStorage.INSTANCE.getCloudideSession();
        if (cloudideSession.length() == 0) {
            throw new TraeAuthException(null, "bindDevice: cloudideSession is empty", false, null, null, null, null, null, 248, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String baseUrl = TraeAuthConfig.INSTANCE.getBaseUrl();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("Cookie", buildCookieHeader(MapsKt.mapOf(TuplesKt.to("X-Cloudide-Session", cloudideSession))));
            linkedHashMap.put(XBridgeAPIRequestUtils.CONTENT_TYPE, "application/json");
            TraeAuthApi traeAuthApi = (TraeAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "trae_auth", TraeAuthApi.class, null, baseUrl, linkedHashMap, false, 36, null);
            BindDeviceRequest bindDeviceRequest = new BindDeviceRequest(str, deviceInfo, deviceProof);
            RequestContext requestContext = new RequestContext();
            requestContext.force_handle_response = true;
            SsResponse<String> execute = traeAuthApi.bindDeviceRaw(bindDeviceRequest, requestContext).execute();
            execute.code();
            String body = execute.body();
            if (body == null) {
                TraeAuthManager traeAuthManager = this;
                TypedInput errorBody = execute.errorBody();
                if (errorBody != null) {
                    InputStream mo349in = errorBody.mo349in();
                    Intrinsics.checkNotNullExpressionValue(mo349in, "in(...)");
                    Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    try {
                        String readText = TextStreamsKt.readText(bufferedReader);
                        CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                        body = readText;
                    } finally {
                    }
                } else {
                    body = null;
                }
            }
            FLogger.INSTANCE.mo428i(TAG, "bindDevice: response received in " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            TraeResponse parseResponse = parseResponse(body, BindDeviceResult.class);
            if (parseResponse == null) {
                FLogger.INSTANCE.mo426e(TAG, "bindDevice: response body is null");
                throw new TraeAuthException(null, "bindDevice response body is null", true, null, null, null, null, null, 248, null);
            }
            TraeResponseMetadata responseMetadata = parseResponse.getResponseMetadata();
            TraeResponseError error = responseMetadata != null ? responseMetadata.getError() : null;
            if (error != null) {
                if (Intrinsics.areEqual(error.getStandardCode(), ERROR_CODE_DEVICE_LIMIT_REACHED)) {
                    return new BindDeviceResult(Boxing.boxBoolean(true), null, null, null, null, null, 62, null);
                }
                FLogger.INSTANCE.mo426e(TAG, "bindDevice business error: [" + error.getCode() + "] " + error.getMessage());
                throw new TraeAuthException(error.getCode(), "bindDevice failed: " + error.getMessage(), false, null, error.getMessage(), null, null, null, 232, null);
            }
            BindDeviceResult bindDeviceResult = (BindDeviceResult) parseResponse.getResult();
            return bindDeviceResult == null ? new BindDeviceResult(null, Boxing.boxBoolean(false), null, null, null, null, 61, null) : bindDeviceResult;
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "bindDevice network exception: " + e.getClass().getSimpleName() + ' ' + e.getMessage() + ", elapsed=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            Exception exc = e;
            if (extractHttpStatusCode(exc) == 401) {
                throw new TraeAuthException(ERROR_CODE_REFRESH_TOKEN_EXPIRED, "bindDevice: HTTP 401 - session invalid", false, exc, null, null, null, null, 240, null);
            }
            throw new TraeAuthException(null, "bindDevice network error: " + e.getMessage(), isTransientError(exc), exc, null, null, null, null, 240, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x032d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doExchangeTokenOrThrow(String str, Continuation<? super TraeExchangeTokenResult> continuation) throws TraeAuthException {
        String str2;
        String str3;
        Exception exc;
        String baseUrl;
        LinkedHashMap linkedHashMap;
        RequestContext requestContext;
        SsResponse<String> execute;
        int code;
        Object obj;
        String value;
        TraeResponseError traeResponseError;
        String str4;
        if (str.length() == 0) {
            throw new TraeAuthException(null, "doExchangeToken: refreshToken is empty", false, null, null, null, null, null, 248, null);
        }
        if (TraeAuthConfig.INSTANCE.getClientId().length() == 0) {
            throw new TraeAuthException(null, "doExchangeToken: clientId is empty", false, null, null, null, null, null, 248, null);
        }
        if (Intrinsics.areEqual(TraeAuthStorage.INSTANCE.getLoginPlatform(), "enterprise")) {
            return doEnterpriseExchangeTokenOrThrow(str, continuation);
        }
        String cloudideSession = TraeAuthStorage.INSTANCE.getCloudideSession();
        if (cloudideSession.length() == 0) {
            throw new TraeAuthException(null, "doExchangeToken: cloudideSession is empty", false, null, null, null, null, null, 248, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        FLogger.INSTANCE.mo428i(TAG, "doExchangeToken: requesting, refreshTokenLen=" + str.length() + ", sessionLen=" + cloudideSession.length());
        try {
            baseUrl = TraeAuthConfig.INSTANCE.getBaseUrl();
            linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("Cookie", buildCookieHeader(MapsKt.mapOf(TuplesKt.to("X-Cloudide-Session", cloudideSession))));
            linkedHashMap.put(XBridgeAPIRequestUtils.CONTENT_TYPE, "application/json");
            requestContext = new RequestContext();
            requestContext.force_handle_response = true;
        } catch (Exception e) {
            e = e;
            str2 = null;
        }
        try {
            execute = ((TraeAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "trae_auth", TraeAuthApi.class, null, baseUrl, linkedHashMap, false, 36, null)).exchangeTokenRaw(new TraeExchangeTokenRequest(TraeAuthConfig.INSTANCE.getClientId(), TraeAuthConfig.INSTANCE.getClientSecret(), str, null, TraeAuthDeviceManager.INSTANCE.getDeviceInfo(), TraeAuthDeviceManager.getDeviceProof$default(TraeAuthDeviceManager.INSTANCE, "POST", "/trae/api/v3/oauth/ExchangeToken", null, 4, null), 8, null), requestContext).execute();
            code = execute.code();
            List<Header> headers = execute.headers();
            Intrinsics.checkNotNullExpressionValue(headers, "headers(...)");
            Iterator<T> it = headers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                try {
                    obj = it.next();
                    if (StringsKt.equals(((Header) obj).getName(), SccUtils.HEADER_LOG_ID, true)) {
                        break;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str3 = null;
                    FLogger.INSTANCE.mo426e(TAG, "doExchangeToken network exception: " + e.getClass().getSimpleName() + ' ' + e.getMessage() + ", elapsed=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    exc = e;
                    if (extractHttpStatusCode(exc) == 401) {
                    }
                }
            }
            Header header = (Header) obj;
            value = header != null ? header.getValue() : null;
        } catch (Exception e3) {
            e = e3;
            str2 = null;
            str3 = str2;
            FLogger.INSTANCE.mo426e(TAG, "doExchangeToken network exception: " + e.getClass().getSimpleName() + ' ' + e.getMessage() + ", elapsed=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            exc = e;
            if (extractHttpStatusCode(exc) == 401) {
                throw new TraeAuthException(ERROR_CODE_REFRESH_TOKEN_EXPIRED, "doExchangeToken: HTTP 401 - refresh token invalid", false, exc, null, null, null, str3, 112, null);
            }
            throw new TraeAuthException(null, "doExchangeToken network error: " + e.getMessage(), isTransientError(exc), exc, null, null, null, str3, 112, null);
        }
        try {
            String body = execute.body();
            if (body == null) {
                TraeAuthManager traeAuthManager = this;
                TypedInput errorBody = execute.errorBody();
                if (errorBody != null) {
                    InputStream mo349in = errorBody.mo349in();
                    Intrinsics.checkNotNullExpressionValue(mo349in, "in(...)");
                    Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    try {
                        str4 = TextStreamsKt.readText(bufferedReader);
                        traeResponseError = null;
                        CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                    } finally {
                    }
                } else {
                    traeResponseError = null;
                    str4 = null;
                }
                body = str4;
            } else {
                traeResponseError = null;
            }
            FLogger.INSTANCE.mo428i(TAG, "doExchangeToken: response received in " + (System.currentTimeMillis() - currentTimeMillis) + "ms, logId=" + value);
            TraeResponse parseResponse = parseResponse(body, TraeExchangeTokenResult.class);
            if (parseResponse == null) {
                FLogger.INSTANCE.mo426e(TAG, "doExchangeToken: response body is null");
                throw new TraeAuthException(String.valueOf(code), "doExchangeToken response body is null", true, null, null, null, null, value, 120, null);
            }
            TraeResponseMetadata responseMetadata = parseResponse.getResponseMetadata();
            TraeResponseError error = responseMetadata != null ? responseMetadata.getError() : traeResponseError;
            if (error != null) {
                FLogger.INSTANCE.mo426e(TAG, "doExchangeToken business error: [" + error.getCode() + "] " + error.getMessage());
                if (Intrinsics.areEqual(error.getStandardCode(), ERROR_CODE_DEVICE_LIMIT_REACHED)) {
                    return new TraeExchangeTokenResult(Boxing.boxBoolean(true), null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
                }
                throw new TraeAuthException(error.getCode(), "doExchangeToken failed: " + error.getMessage(), false, null, error.getMessage(), null, null, value, 104, null);
            }
            TraeExchangeTokenResult traeExchangeTokenResult = (TraeExchangeTokenResult) parseResponse.getResult();
            CharSequence charSequence = (CharSequence) (traeExchangeTokenResult != null ? traeExchangeTokenResult.getToken() : traeResponseError);
            if (charSequence == null || charSequence.length() == 0) {
                FLogger.INSTANCE.mo426e(TAG, "doExchangeToken: token is empty");
                throw new TraeAuthException(null, "doExchangeToken returned empty token", true, null, null, null, null, value, 120, null);
            }
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("doExchangeToken: success, tokenExpireAt=");
            Intrinsics.checkNotNull(traeExchangeTokenResult);
            fLogger.mo428i(TAG, sb.append(traeExchangeTokenResult.getTokenExpireAt()).append(", hasNewRefreshToken=").append(traeExchangeTokenResult.getRefreshToken() != null).toString());
            return traeExchangeTokenResult;
        } catch (Exception e4) {
            e = e4;
            str3 = value;
            FLogger.INSTANCE.mo426e(TAG, "doExchangeToken network exception: " + e.getClass().getSimpleName() + ' ' + e.getMessage() + ", elapsed=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            exc = e;
            if (extractHttpStatusCode(exc) == 401) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doEnterpriseExchangeTokenOrThrow(String str, Continuation<? super TraeExchangeTokenResult> continuation) throws TraeAuthException {
        Function1<? super String, TraeExchangeTokenResult> function1 = enterpriseExchangeProvider;
        if (function1 == null) {
            throw new TraeAuthException(null, "doEnterpriseExchangeToken: provider not registered", false, null, null, null, null, null, 248, null);
        }
        FLogger.INSTANCE.mo428i(TAG, "doEnterpriseExchangeToken: requesting via provider, refreshTokenLen=" + str.length());
        return function1.invoke(str);
    }

    private final Map<String, String> buildDeviceHeaders() {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(XBridgeAPIRequestUtils.CONTENT_TYPE, "application/json");
        linkedHashMap.put("x-device-id", IApplog.Companion.getDeviceId());
        linkedHashMap.put("x-machine-id", IApplog.Companion.getClientDid());
        String str2 = Build.BRAND;
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("x-device-brand", str2);
        String str3 = Build.MODEL;
        if (str3 == null) {
            str3 = "";
        }
        linkedHashMap.put("x-device-type", str3);
        String str4 = Build.VERSION.RELEASE;
        if (str4 == null) {
            str4 = "";
        }
        linkedHashMap.put("x-os-version", str4);
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr == null || (str = ArraysKt.joinToString$default(strArr, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)) == null) {
            str = "";
        }
        linkedHashMap.put("x-device-cpu", str);
        String property = System.getProperty("http.agent");
        if (property == null) {
            property = "";
        }
        linkedHashMap.put("User-Agent", property);
        linkedHashMap.put("Referer", "");
        return linkedHashMap;
    }

    private final String buildCookieHeader(Map<String, String> values) {
        return CollectionsKt.joinToString$default(values.entrySet(), "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.login.traeauth.TraeAuthManager$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence buildCookieHeader$lambda$25;
                buildCookieHeader$lambda$25 = TraeAuthManager.buildCookieHeader$lambda$25((Map.Entry) obj);
                return buildCookieHeader$lambda$25;
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildCookieHeader$lambda$25(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "it");
        return ((String) entry.getKey()) + '=' + ((String) entry.getValue());
    }

    private final String extractCookieFromCookieManager(String cookieName) {
        String cookie = CookieManager.getInstance().getCookie(TraeAuthConfig.INSTANCE.getBaseUrl());
        if (cookie == null) {
            return null;
        }
        return extractCookieValue(cookie, cookieName);
    }

    private final String extractCookieFromResponse(SsResponse<String> ssResponse, String cookieName) {
        Iterator<T> it = getHeaderValues(ssResponse, "Set-Cookie").iterator();
        while (it.hasNext()) {
            String extractCookieValue = INSTANCE.extractCookieValue((String) it.next(), cookieName);
            String str = extractCookieValue;
            if (!(str == null || str.length() == 0)) {
                return extractCookieValue;
            }
        }
        return null;
    }

    private final String extractCookieValue(String cookieString, String cookieName) {
        Iterator it = StringsKt.split$default(cookieString, new String[]{";"}, false, 0, 6, (Object) null).iterator();
        while (it.hasNext()) {
            String obj = StringsKt.trim((String) it.next()).toString();
            if (StringsKt.startsWith$default(obj, cookieName + '=', false, 2, (Object) null)) {
                return StringsKt.substringAfter(obj, "=", "");
            }
        }
        return null;
    }

    private final List<String> getHeaderValues(SsResponse<String> ssResponse, String headerName) {
        if (ssResponse == null) {
            return CollectionsKt.emptyList();
        }
        List<Header> headers = ssResponse.headers();
        Intrinsics.checkNotNullExpressionValue(headers, "headers(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : headers) {
            if (StringsKt.equals(((Header) obj).getName(), headerName, true)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((Header) it.next()).getValue());
        }
        return arrayList3;
    }

    private final <T> TraeResponse<T> parseResponse(String bodyStr, Class<T> clazz) {
        if (bodyStr == null) {
            return null;
        }
        return (TraeResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(bodyStr, TypeToken.getParameterized(TraeResponse.class, new Type[]{clazz}).getType());
    }

    private final <T> TraeResponseWithRaw<T> parseResponse(SsResponse<String> ssResponse, Class<T> clazz) {
        String body;
        if (ssResponse == null || (body = ssResponse.body()) == null) {
            return null;
        }
        TraeResponse traeResponse = (TraeResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(body, TypeToken.getParameterized(TraeResponse.class, new Type[]{clazz}).getType());
        Intrinsics.checkNotNull(traeResponse);
        return new TraeResponseWithRaw<>(traeResponse, ssResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TraeAuthManager.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeResponseWithRaw;", "T", "", "response", "Lcom/bytedance/trae/login/traeauth/TraeResponse;", "ssResponse", "Lcom/bytedance/retrofit2/SsResponse;", "", "<init>", "(Lcom/bytedance/trae/login/traeauth/TraeResponse;Lcom/bytedance/retrofit2/SsResponse;)V", "getResponse", "()Lcom/bytedance/trae/login/traeauth/TraeResponse;", "getSsResponse", "()Lcom/bytedance/retrofit2/SsResponse;", "responseMetadata", "Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;", "getResponseMetadata", "()Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;", "result", "getResult", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class TraeResponseWithRaw<T> {
        private final TraeResponse<T> response;
        private final SsResponse<String> ssResponse;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TraeResponseWithRaw copy$default(TraeResponseWithRaw traeResponseWithRaw, TraeResponse traeResponse, SsResponse ssResponse, int i, Object obj) {
            if ((i & 1) != 0) {
                traeResponse = traeResponseWithRaw.response;
            }
            if ((i & 2) != 0) {
                ssResponse = traeResponseWithRaw.ssResponse;
            }
            return traeResponseWithRaw.copy(traeResponse, ssResponse);
        }

        public final TraeResponse<T> component1() {
            return this.response;
        }

        public final SsResponse<String> component2() {
            return this.ssResponse;
        }

        public final TraeResponseWithRaw<T> copy(TraeResponse<T> response, SsResponse<String> ssResponse) {
            Intrinsics.checkNotNullParameter(response, "response");
            return new TraeResponseWithRaw<>(response, ssResponse);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TraeResponseWithRaw)) {
                return false;
            }
            TraeResponseWithRaw traeResponseWithRaw = (TraeResponseWithRaw) other;
            return Intrinsics.areEqual(this.response, traeResponseWithRaw.response) && Intrinsics.areEqual(this.ssResponse, traeResponseWithRaw.ssResponse);
        }

        public int hashCode() {
            int hashCode = this.response.hashCode() * 31;
            SsResponse<String> ssResponse = this.ssResponse;
            return hashCode + (ssResponse == null ? 0 : ssResponse.hashCode());
        }

        public String toString() {
            return "TraeResponseWithRaw(response=" + this.response + ", ssResponse=" + this.ssResponse + ')';
        }

        public TraeResponseWithRaw(TraeResponse<T> traeResponse, SsResponse<String> ssResponse) {
            Intrinsics.checkNotNullParameter(traeResponse, "response");
            this.response = traeResponse;
            this.ssResponse = ssResponse;
        }

        public final TraeResponse<T> getResponse() {
            return this.response;
        }

        public final SsResponse<String> getSsResponse() {
            return this.ssResponse;
        }

        public final TraeResponseMetadata getResponseMetadata() {
            return this.response.getResponseMetadata();
        }

        public final T getResult() {
            return this.response.getResult();
        }
    }

    public static /* synthetic */ void reportLoginFunnel$default(TraeAuthManager traeAuthManager, String str, String str2, Long l, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, int i, Object obj) {
        traeAuthManager.reportLoginFunnel(str, str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? 0 : num, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005a A[Catch: all -> 0x0008, TryCatch #0 {all -> 0x0008, blocks: (B:7:0x0010, B:9:0x0022, B:11:0x0029, B:13:0x0030, B:15:0x0037, B:17:0x0042, B:18:0x0047, B:20:0x004e, B:25:0x005a, B:26:0x005f, B:28:0x0064, B:33:0x0070, B:34:0x0076, B:36:0x007b, B:39:0x0084, B:42:0x008c, B:44:0x0096, B:46:0x00a8, B:47:0x00b3), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0070 A[Catch: all -> 0x0008, TryCatch #0 {all -> 0x0008, blocks: (B:7:0x0010, B:9:0x0022, B:11:0x0029, B:13:0x0030, B:15:0x0037, B:17:0x0042, B:18:0x0047, B:20:0x004e, B:25:0x005a, B:26:0x005f, B:28:0x0064, B:33:0x0070, B:34:0x0076, B:36:0x007b, B:39:0x0084, B:42:0x008c, B:44:0x0096, B:46:0x00a8, B:47:0x00b3), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b A[Catch: all -> 0x0008, TryCatch #0 {all -> 0x0008, blocks: (B:7:0x0010, B:9:0x0022, B:11:0x0029, B:13:0x0030, B:15:0x0037, B:17:0x0042, B:18:0x0047, B:20:0x004e, B:25:0x005a, B:26:0x005f, B:28:0x0064, B:33:0x0070, B:34:0x0076, B:36:0x007b, B:39:0x0084, B:42:0x008c, B:44:0x0096, B:46:0x00a8, B:47:0x00b3), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0084 A[Catch: all -> 0x0008, TryCatch #0 {all -> 0x0008, blocks: (B:7:0x0010, B:9:0x0022, B:11:0x0029, B:13:0x0030, B:15:0x0037, B:17:0x0042, B:18:0x0047, B:20:0x004e, B:25:0x005a, B:26:0x005f, B:28:0x0064, B:33:0x0070, B:34:0x0076, B:36:0x007b, B:39:0x0084, B:42:0x008c, B:44:0x0096, B:46:0x00a8, B:47:0x00b3), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008c A[Catch: all -> 0x0008, TryCatch #0 {all -> 0x0008, blocks: (B:7:0x0010, B:9:0x0022, B:11:0x0029, B:13:0x0030, B:15:0x0037, B:17:0x0042, B:18:0x0047, B:20:0x004e, B:25:0x005a, B:26:0x005f, B:28:0x0064, B:33:0x0070, B:34:0x0076, B:36:0x007b, B:39:0x0084, B:42:0x008c, B:44:0x0096, B:46:0x00a8, B:47:0x00b3), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8 A[Catch: all -> 0x0008, TryCatch #0 {all -> 0x0008, blocks: (B:7:0x0010, B:9:0x0022, B:11:0x0029, B:13:0x0030, B:15:0x0037, B:17:0x0042, B:18:0x0047, B:20:0x004e, B:25:0x005a, B:26:0x005f, B:28:0x0064, B:33:0x0070, B:34:0x0076, B:36:0x007b, B:39:0x0084, B:42:0x008c, B:44:0x0096, B:46:0x00a8, B:47:0x00b3), top: B:6:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void reportLoginFunnel(String stage, String loginPlatform, Long durationMs, String failedStep, String errorCode, String reason, String bindStatus, Integer httpCode, String logId, String result, String bindStage) {
        boolean z;
        String str;
        boolean z2;
        String str2;
        JSONObject jSONObject;
        if (stage == null) {
            stage = "unknown_stage";
        }
        if (loginPlatform == null) {
            loginPlatform = "unknown_platform";
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(FluencyHelper.STAGE, stage);
            jSONObject2.put("login_platform", loginPlatform);
            if (failedStep != null) {
                jSONObject2.put("failed_step", failedStep);
            }
            if (errorCode != null) {
                jSONObject2.put(CDNLoader.DIAGNOSE_ERROR_CODE, errorCode);
            }
            if (bindStatus != null) {
                jSONObject2.put("bindStatus", bindStatus);
            }
            if (httpCode != null) {
                jSONObject2.put("httpCode", httpCode.intValue());
            }
            if (reason != null) {
                jSONObject2.put("fail_reason", reason);
            }
            String str3 = logId;
            if (str3 != null && str3.length() != 0) {
                z = false;
                if (!z) {
                    jSONObject2.put("log_id", logId);
                }
                str = result;
                if (str != null && str.length() != 0) {
                    z2 = false;
                    if (!z2) {
                        jSONObject2.put("result", result);
                    }
                    str2 = bindStage;
                    if (!(str2 != null || str2.length() == 0)) {
                        jSONObject2.put("bind_stage", bindStage);
                    }
                    JSONObject jSONObject3 = null;
                    if (durationMs != null || durationMs.longValue() < 0) {
                        jSONObject = null;
                    } else {
                        jSONObject = new JSONObject();
                        jSONObject.put("duration_ms", durationMs.longValue());
                    }
                    if (reason != null) {
                        jSONObject3 = new JSONObject();
                        jSONObject3.put("reason_detail", reason);
                    }
                    ApmAgent.monitorEvent(EVENT_LOGIN_FUNNEL, jSONObject2, jSONObject, jSONObject3);
                    IApplog.Companion.reportEvent(EVENT_LOGIN_FUNNEL, jSONObject2);
                }
                z2 = true;
                if (!z2) {
                }
                str2 = bindStage;
                if (!(str2 != null || str2.length() == 0)) {
                }
                JSONObject jSONObject32 = null;
                if (durationMs != null) {
                }
                jSONObject = null;
                if (reason != null) {
                }
                ApmAgent.monitorEvent(EVENT_LOGIN_FUNNEL, jSONObject2, jSONObject, jSONObject32);
                IApplog.Companion.reportEvent(EVENT_LOGIN_FUNNEL, jSONObject2);
            }
            z = true;
            if (!z) {
            }
            str = result;
            if (str != null) {
                z2 = false;
                if (!z2) {
                }
                str2 = bindStage;
                if (!(str2 != null || str2.length() == 0)) {
                }
                JSONObject jSONObject322 = null;
                if (durationMs != null) {
                }
                jSONObject = null;
                if (reason != null) {
                }
                ApmAgent.monitorEvent(EVENT_LOGIN_FUNNEL, jSONObject2, jSONObject, jSONObject322);
                IApplog.Companion.reportEvent(EVENT_LOGIN_FUNNEL, jSONObject2);
            }
            z2 = true;
            if (!z2) {
            }
            str2 = bindStage;
            if (!(str2 != null || str2.length() == 0)) {
            }
            JSONObject jSONObject3222 = null;
            if (durationMs != null) {
            }
            jSONObject = null;
            if (reason != null) {
            }
            ApmAgent.monitorEvent(EVENT_LOGIN_FUNNEL, jSONObject2, jSONObject, jSONObject3222);
            IApplog.Companion.reportEvent(EVENT_LOGIN_FUNNEL, jSONObject2);
        } catch (Throwable th) {
            FLogger.INSTANCE.mo430w(TAG, "reportLoginFunnel failed: " + th.getMessage());
        }
    }

    public final void reportStepDuration(String step, String loginPlatform, long durationMs) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (step == null) {
                step = "unknown_step";
            }
            jSONObject.put("step", step);
            if (loginPlatform == null) {
                loginPlatform = "unknown_platform";
            }
            jSONObject.put("login_platform", loginPlatform);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("duration_ms", RangesKt.coerceAtLeast(durationMs, 0L));
            ApmAgent.monitorEvent(EVENT_STEP_DURATION, jSONObject, jSONObject2, (JSONObject) null);
        } catch (Throwable th) {
            FLogger.INSTANCE.mo430w(TAG, "reportStepDuration failed: " + th.getMessage());
        }
    }

    static /* synthetic */ void reportTokenRefresh$default(TraeAuthManager traeAuthManager, boolean z, long j, String str, String str2, int i, Object obj) {
        traeAuthManager.reportTokenRefresh(z, j, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
    }

    private final void reportTokenRefresh(boolean success, long durationMs, String errorCode, String reason) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("result", success ? "success" : "failure");
            if (errorCode != null) {
                jSONObject2.put(CDNLoader.DIAGNOSE_ERROR_CODE, errorCode);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("duration_ms", RangesKt.coerceAtLeast(durationMs, 0L));
            if (reason != null) {
                jSONObject = new JSONObject();
                jSONObject.put("reason_detail", reason);
            } else {
                jSONObject = null;
            }
            ApmAgent.monitorEvent(EVENT_TOKEN_REFRESH, jSONObject2, jSONObject3, jSONObject);
        } catch (Throwable th) {
            FLogger.INSTANCE.mo430w(TAG, "reportTokenRefresh failed: " + th.getMessage());
        }
    }

    static {
        CoroutineContext coroutineContext = (CoroutineExceptionHandler) new TraeAuthManager$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
        exceptionHandler = coroutineContext;
        scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()).plus(coroutineContext));
        refreshMutex = MutexKt.Mutex$default(false, 1, (Object) null);
        isExchangeRequesting = new AtomicBoolean(false);
    }
}
