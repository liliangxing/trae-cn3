package com.bytedance.trae.home.solo.task;

import android.app.Application;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.network.TaskPinCapability;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.solo.task.FilterOption;
import com.bytedance.trae.im.database.ConversationDao;
import com.bytedance.trae.im.database.ConversationDetailDao;
import com.bytedance.trae.im.database.DatabaseManager;
import com.bytedance.trae.im.database.DatabaseOpenHelper;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.repository.ConversationDetailCacheRepository;
import com.bytedance.trae.im.service.Cli;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.im.service.IMService;
import com.bytedance.trae.im.service.PinConversationResponse;
import com.bytedance.trae.im.service.SearchConversationItem;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.NetworkMonitor;
import com.bytedance.trae.utils.StringKt;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONObject;

/* compiled from: TaskViewModel.kt */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 ¡\u00012\u00020\u0001:\u0002¡\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010>\u001a\u0004\u0018\u0001082\u0006\u0010?\u001a\u00020\u0007J\b\u0010X\u001a\u00020YH\u0014J\b\u0010Z\u001a\u00020YH\u0002J\u000e\u0010[\u001a\u00020Y2\u0006\u0010\\\u001a\u00020!J\u0006\u0010]\u001a\u00020YJ\u000e\u0010^\u001a\u00020Y2\u0006\u0010_\u001a\u00020\u0007J\u0006\u0010`\u001a\u00020YJ\u0006\u0010a\u001a\u00020YJ\u0006\u0010b\u001a\u00020YJ\u0006\u0010c\u001a\u00020YJ\u0006\u0010d\u001a\u00020YJ\u0006\u0010e\u001a\u00020YJ\u0006\u0010f\u001a\u00020YJ\u0006\u0010g\u001a\u00020YJ\u0006\u0010h\u001a\u00020YJ\u0010\u0010i\u001a\u00020Y2\u0006\u0010_\u001a\u00020\u0007H\u0002J\b\u0010j\u001a\u00020YH\u0002J\u001c\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010_\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010lJ\u0010\u0010m\u001a\u00020Y2\u0006\u0010n\u001a\u000201H\u0002J\b\u0010o\u001a\u00020YH\u0002J\u0016\u0010p\u001a\u00020Y2\f\u0010q\u001a\b\u0012\u0004\u0012\u0002080\u0011H\u0002J\u0016\u0010r\u001a\u00020Y2\f\u0010q\u001a\b\u0012\u0004\u0012\u0002080\u0011H\u0002J\u0010\u0010s\u001a\u00020\u00142\u0006\u0010t\u001a\u000208H\u0002J\u0006\u0010u\u001a\u00020YJ\b\u0010v\u001a\u00020YH\u0002J\u0016\u0010w\u001a\u00020Y2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020y0\u0011H\u0002J\b\u0010z\u001a\u00020YH\u0002J\b\u0010{\u001a\u00020YH\u0002J\u0016\u0010|\u001a\u00020Y2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010}\u001a\u00020\u0007J\u000e\u0010~\u001a\u00020Y2\u0006\u0010?\u001a\u00020\u0007J\u000f\u0010\u007f\u001a\u00020Y2\u0007\u0010\u0080\u0001\u001a\u00020\u0012J\u0010\u0010\u0081\u0001\u001a\u00020Y2\u0007\u0010\u0080\u0001\u001a\u00020\u0012J\u001b\u0010\u0082\u0001\u001a\u00020Y2\u0007\u0010\u0080\u0001\u001a\u00020\u00122\u0007\u0010\u0083\u0001\u001a\u00020\u0014H\u0002J&\u0010\u0084\u0001\u001a\u00020Y2\u0006\u0010?\u001a\u00020\u00072\u0007\u0010\u0083\u0001\u001a\u00020\u00142\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0002J\u0012\u0010\u0087\u0001\u001a\u0002012\u0007\u0010\u0083\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010\u0088\u0001\u001a\u0002012\u0007\u0010\u0083\u0001\u001a\u00020\u0014H\u0002J\r\u0010\u0089\u0001\u001a\u00020\u0012*\u000208H\u0002J\u0019\u0010\u008a\u0001\u001a\u00020\u00072\u0007\u0010\u008b\u0001\u001a\u00020\u00072\u0007\u0010\u008c\u0001\u001a\u00020\u0007J'\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0012*\u00030\u008d\u00012\u0006\u0010_\u001a\u00020\u00072\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0002J\u0019\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011*\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u001d\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u001b\u0010\u0091\u0001\u001a\u0002012\u0007\u0010\u0092\u0001\u001a\u00020\u00072\u0007\u0010\u0093\u0001\u001a\u00020\u0007H\u0002J\u001c\u0010\u0094\u0001\u001a\u0004\u0018\u00010A2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010\u0096\u0001J3\u0010\u0097\u0001\u001a\u00020\u00072\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u009b\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010\u009d\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010\u009e\u0001\u001a\u00020\u00072\u0007\u0010\u009d\u0001\u001a\u00020\u0007H\u0002J\u0014\u0010\u009f\u0001\u001a\u00020\u00072\t\u0010 \u0001\u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00110\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0016¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0016¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u001a\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00110\u0016¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0017R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0017R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020100X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020103¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020807X\u0082\u0004¢\u0006\u0002\n\u0000R4\u00109\u001a&\u0012\f\u0012\n ;*\u0004\u0018\u00010\u00070\u0007 ;*\u0012\u0012\f\u0012\n ;*\u0004\u0018\u00010\u00070\u0007\u0018\u00010<0:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010=R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020AX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020AX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020AX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0017R\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¢\u0001"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "defaultTaskTitle", "", "userId", "dbHelper", "Lcom/bytedance/trae/im/database/DatabaseOpenHelper;", "conversationDao", "Lcom/bytedance/trae/im/database/ConversationDao;", "conversationDetailCacheRepository", "Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;", "_allTasks", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/bytedance/trae/home/solo/task/TaskModel;", "_isSearchMode", "", "isSearchMode", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "_searchQuery", "searchQuery", "getSearchQuery", "_searchResults", "searchResults", "getSearchResults", "_isSearchLoading", "isSearchLoading", "_selectedFilter", "Lcom/bytedance/trae/home/solo/task/FilterOption;", "selectedFilter", "getSelectedFilter", "tasks", "getTasks", "_devices", "Lcom/bytedance/trae/home/solo/task/DeviceInfo;", "devices", "getDevices", "_loadError", "loadError", "getLoadError", "_isRefreshing", "isRefreshing", "_toastMessage", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "toastMessage", "Lkotlinx/coroutines/flow/SharedFlow;", "getToastMessage", "()Lkotlinx/coroutines/flow/SharedFlow;", "conversationMap", "", "Lcom/bytedance/trae/im/service/Conversation;", "pendingDeleteIds", "", "kotlin.jvm.PlatformType", "", "Ljava/util/Set;", "getConversation", "conversationId", "lastLoadTime", "", "refreshIntervalMs", "minLoadIntervalMs", "pollingJob", "Lkotlinx/coroutines/Job;", "loadTasksJob", "searchDebouncer", "Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;", "pollingIntervalMs", "isLoadingTasks", "pendingReload", "isFirstLoadCompleted", "_contentReady", "contentReady", "getContentReady", "conversationChangeListener", "Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;", "cliStatusChangeListener", "Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;", "cliUnbindListener", "Lcom/bytedance/trae/im/service/IMService$CliUnbindListener;", "cliRegisterListener", "Lcom/bytedance/trae/im/service/IMService$CliRegisterListener;", "onCleared", "", "observeNetworkState", "setFilter", "filter", "enterSearchMode", "updateSearchQuery", "query", "clearSearchQuery", "exitSearchMode", "loadTasks", "loadTasksOnResume", "forceLoadTasks", "refreshTasks", "retry", "startPollingIfNeeded", "stopPolling", "scheduleSearch", "resetSearchResults", "searchLocalTasks", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportFirstLoadEvent", "taskCount", "loadCachedTasks", "replaceAllConversations", "conversations", "persistConversations", "isConversationDisplayable", "conversation", "loadDevices", "observeCliCache", "applyDevices", "clis", "Lcom/bytedance/trae/im/service/Cli;", "rebuildTasksFromConversations", "reconcileSelectedFilterWithDevices", "renameConversation", "newTitle", "deleteConversation", "pinConversation", "task", "unpinConversation", "performPinAction", "shouldPin", "applyPinSuccess", "data", "Lcom/bytedance/trae/im/service/PinConversationResponse;", "pinFailureString", "pinSuccessString", "toTaskModel", "extractIDELocation", "folderPath", "workspaceType", "Lcom/bytedance/trae/im/service/SearchConversationItem;", "highlightKeywords", "sortedForTaskList", "sortTasks", "compareTaskTime", "left", "right", "sortableTimeKey", "value", "(Ljava/lang/String;)Ljava/lang/Long;", "extractLocation", MessagePart.TYPE_WORKSPACE, "gitUri", "repoName", "isLocal", "lastPathComponent", "path", "lastTwoPathComponents", "formatTime", "updatedAt", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskViewModel extends AndroidViewModel {
    private static final long CODE_PIN_VERSION_INCOMPATIBLE = 2900104;
    private static final int LOCAL_SEARCH_MESSAGE_LIMIT = 2000;
    private static final String TAG = "TaskViewModel";
    private final MutableStateFlow<List<TaskModel>> _allTasks;
    private final MutableStateFlow<Boolean> _contentReady;
    private final MutableStateFlow<List<DeviceInfo>> _devices;
    private final MutableStateFlow<Boolean> _isRefreshing;
    private final MutableStateFlow<Boolean> _isSearchLoading;
    private final MutableStateFlow<Boolean> _isSearchMode;
    private final MutableStateFlow<Boolean> _loadError;
    private final MutableStateFlow<String> _searchQuery;
    private final MutableStateFlow<List<TaskModel>> _searchResults;
    private final MutableStateFlow<FilterOption> _selectedFilter;
    private final MutableSharedFlow<Integer> _toastMessage;
    private final IMService.CliRegisterListener cliRegisterListener;
    private final IMService.CliStatusChangeListener cliStatusChangeListener;
    private final IMService.CliUnbindListener cliUnbindListener;
    private final StateFlow<Boolean> contentReady;
    private final IMService.ConversationChangeListener conversationChangeListener;
    private final ConversationDao conversationDao;
    private final ConversationDetailCacheRepository conversationDetailCacheRepository;
    private final Map<String, Conversation> conversationMap;
    private final DatabaseOpenHelper dbHelper;
    private final String defaultTaskTitle;
    private final StateFlow<List<DeviceInfo>> devices;
    private volatile boolean isFirstLoadCompleted;
    private volatile boolean isLoadingTasks;
    private final StateFlow<Boolean> isRefreshing;
    private final StateFlow<Boolean> isSearchLoading;
    private final StateFlow<Boolean> isSearchMode;
    private long lastLoadTime;
    private final StateFlow<Boolean> loadError;
    private Job loadTasksJob;
    private final long minLoadIntervalMs;
    private final Set<String> pendingDeleteIds;
    private volatile boolean pendingReload;
    private final long pollingIntervalMs;
    private Job pollingJob;
    private final long refreshIntervalMs;
    private final TaskSearchDebouncer searchDebouncer;
    private final StateFlow<String> searchQuery;
    private final StateFlow<List<TaskModel>> searchResults;
    private final StateFlow<FilterOption> selectedFilter;
    private final StateFlow<List<TaskModel>> tasks;
    private final SharedFlow<Integer> toastMessage;
    private final String userId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final ThreadLocal<List<SimpleDateFormat>> parseDateFormats = new ThreadLocal<>();
    private static final ThreadLocal<SimpleDateFormat> timeOnlyFormat = new ThreadLocal<>();
    private static final ThreadLocal<SimpleDateFormat> zhSameYearFormat = new ThreadLocal<>();
    private static final ThreadLocal<SimpleDateFormat> jaSameYearFormat = new ThreadLocal<>();
    private static final ThreadLocal<SimpleDateFormat> enSameYearFormat = new ThreadLocal<>();
    private static final ThreadLocal<SimpleDateFormat> zhOtherYearFormat = new ThreadLocal<>();
    private static final ThreadLocal<SimpleDateFormat> jaOtherYearFormat = new ThreadLocal<>();
    private static final ThreadLocal<SimpleDateFormat> enOtherYearFormat = new ThreadLocal<>();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskViewModel(Application application) {
        super(application);
        AccountInfo accountInfo;
        Intrinsics.checkNotNullParameter(application, "application");
        String string = application.getString(C0820R.string.solo_task_new_task);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.defaultTaskTitle = string;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String str = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (str = accountInfo.getUserId()) == null) ? "anonymous" : str;
        this.userId = str;
        Application application2 = application;
        DatabaseOpenHelper database = DatabaseManager.INSTANCE.getDatabase(application2, str);
        this.dbHelper = database;
        this.conversationDao = new ConversationDao(database);
        this.conversationDetailCacheRepository = new ConversationDetailCacheRepository(new ConversationDetailDao(database));
        Flow MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._allTasks = MutableStateFlow;
        Flow MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._isSearchMode = MutableStateFlow2;
        this.isSearchMode = FlowKt.asStateFlow(MutableStateFlow2);
        Flow MutableStateFlow3 = StateFlowKt.MutableStateFlow("");
        this._searchQuery = MutableStateFlow3;
        this.searchQuery = FlowKt.asStateFlow(MutableStateFlow3);
        Flow MutableStateFlow4 = StateFlowKt.MutableStateFlow((Object) null);
        this._searchResults = MutableStateFlow4;
        this.searchResults = FlowKt.asStateFlow(MutableStateFlow4);
        MutableStateFlow<Boolean> MutableStateFlow5 = StateFlowKt.MutableStateFlow(false);
        this._isSearchLoading = MutableStateFlow5;
        this.isSearchLoading = FlowKt.asStateFlow(MutableStateFlow5);
        Flow MutableStateFlow6 = StateFlowKt.MutableStateFlow(FilterOption.All.INSTANCE);
        this._selectedFilter = MutableStateFlow6;
        this.selectedFilter = FlowKt.asStateFlow(MutableStateFlow6);
        Flow combine = FlowKt.combine(MutableStateFlow, MutableStateFlow6, MutableStateFlow2, MutableStateFlow3, MutableStateFlow4, new TaskViewModel$tasks$1(this, null));
        ViewModel viewModel = (ViewModel) this;
        this.tasks = FlowKt.stateIn(combine, ViewModelKt.getViewModelScope(viewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), CollectionsKt.emptyList());
        MutableStateFlow<List<DeviceInfo>> MutableStateFlow7 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._devices = MutableStateFlow7;
        this.devices = FlowKt.asStateFlow(MutableStateFlow7);
        MutableStateFlow<Boolean> MutableStateFlow8 = StateFlowKt.MutableStateFlow(false);
        this._loadError = MutableStateFlow8;
        this.loadError = FlowKt.asStateFlow(MutableStateFlow8);
        MutableStateFlow<Boolean> MutableStateFlow9 = StateFlowKt.MutableStateFlow(false);
        this._isRefreshing = MutableStateFlow9;
        this.isRefreshing = FlowKt.asStateFlow(MutableStateFlow9);
        MutableSharedFlow<Integer> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._toastMessage = MutableSharedFlow$default;
        this.toastMessage = FlowKt.asSharedFlow(MutableSharedFlow$default);
        this.conversationMap = new LinkedHashMap();
        this.pendingDeleteIds = Collections.newSetFromMap(new ConcurrentHashMap());
        this.refreshIntervalMs = 30000L;
        this.minLoadIntervalMs = 3000L;
        this.searchDebouncer = new TaskSearchDebouncer(ViewModelKt.getViewModelScope(viewModel), 0L, 2, null);
        this.pollingIntervalMs = 5000L;
        MutableStateFlow<Boolean> MutableStateFlow10 = StateFlowKt.MutableStateFlow(false);
        this._contentReady = MutableStateFlow10;
        this.contentReady = FlowKt.asStateFlow(MutableStateFlow10);
        IMService.ConversationChangeListener conversationChangeListener = new IMService.ConversationChangeListener() { // from class: com.bytedance.trae.home.solo.task.TaskViewModel$$ExternalSyntheticLambda2
            @Override // com.bytedance.trae.im.service.IMService.ConversationChangeListener
            public final void onConversationChanged(IMService.ConversationChangeEvent conversationChangeEvent) {
                TaskViewModel.conversationChangeListener$lambda$4(TaskViewModel.this, conversationChangeEvent);
            }
        };
        this.conversationChangeListener = conversationChangeListener;
        IMService.CliStatusChangeListener cliStatusChangeListener = new IMService.CliStatusChangeListener() { // from class: com.bytedance.trae.home.solo.task.TaskViewModel$$ExternalSyntheticLambda3
            @Override // com.bytedance.trae.im.service.IMService.CliStatusChangeListener
            public final void onCliStatusChanged(IMService.CliStatusChangePayload cliStatusChangePayload) {
                TaskViewModel.cliStatusChangeListener$lambda$5(TaskViewModel.this, cliStatusChangePayload);
            }
        };
        this.cliStatusChangeListener = cliStatusChangeListener;
        IMService.CliUnbindListener cliUnbindListener = new IMService.CliUnbindListener() { // from class: com.bytedance.trae.home.solo.task.TaskViewModel$$ExternalSyntheticLambda4
            @Override // com.bytedance.trae.im.service.IMService.CliUnbindListener
            public final void onCliUnbound(IMService.CliUnbindPayload cliUnbindPayload) {
                TaskViewModel.cliUnbindListener$lambda$6(TaskViewModel.this, cliUnbindPayload);
            }
        };
        this.cliUnbindListener = cliUnbindListener;
        IMService.CliRegisterListener cliRegisterListener = new IMService.CliRegisterListener() { // from class: com.bytedance.trae.home.solo.task.TaskViewModel$$ExternalSyntheticLambda5
            @Override // com.bytedance.trae.im.service.IMService.CliRegisterListener
            public final void onCliRegister(IMService.CliRegisterPayload cliRegisterPayload) {
                TaskViewModel.cliRegisterListener$lambda$7(TaskViewModel.this, cliRegisterPayload);
            }
        };
        this.cliRegisterListener = cliRegisterListener;
        NetworkMonitor.INSTANCE.init(application2);
        IMService.INSTANCE.init();
        IMService.INSTANCE.addConversationChangeListener(conversationChangeListener);
        IMService.INSTANCE.addCliStatusChangeListener(cliStatusChangeListener);
        IMService.INSTANCE.addCliUnbindListener(cliUnbindListener);
        IMService.INSTANCE.addCliRegisterListener(cliRegisterListener);
        observeCliCache();
        loadCachedTasks();
        loadTasks();
        loadDevices();
        observeNetworkState();
    }

    /* compiled from: TaskViewModel.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;", "", "<init>", "()V", "TAG", "", "LOCAL_SEARCH_MESSAGE_LIMIT", "", "CODE_PIN_VERSION_INCOMPATIBLE", "", "parseDateFormats", "Ljava/lang/ThreadLocal;", "", "Ljava/text/SimpleDateFormat;", "getParseDateFormats", "timeOnlyFormat", "zhSameYearFormat", "jaSameYearFormat", "enSameYearFormat", "zhOtherYearFormat", "jaOtherYearFormat", "enOtherYearFormat", "getTimeOnlyFormat", "getZhSameYearFormat", "getJaSameYearFormat", "getEnSameYearFormat", "getZhOtherYearFormat", "getJaOtherYearFormat", "getEnOtherYearFormat", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<SimpleDateFormat> getParseDateFormats() {
            List<SimpleDateFormat> list = (List) TaskViewModel.parseDateFormats.get();
            if (list != null) {
                return list;
            }
            List<SimpleDateFormat> listOf = CollectionsKt.listOf(new SimpleDateFormat[]{new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)});
            Iterator it = listOf.iterator();
            while (it.hasNext()) {
                ((SimpleDateFormat) it.next()).setTimeZone(TimeZone.getTimeZone("UTC"));
            }
            List<SimpleDateFormat> list2 = listOf;
            TaskViewModel.parseDateFormats.set(list2);
            return list2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SimpleDateFormat getTimeOnlyFormat() {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) TaskViewModel.timeOnlyFormat.get();
            if (simpleDateFormat != null) {
                return simpleDateFormat;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", Locale.US);
            TaskViewModel.timeOnlyFormat.set(simpleDateFormat2);
            return simpleDateFormat2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SimpleDateFormat getZhSameYearFormat() {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) TaskViewModel.zhSameYearFormat.get();
            if (simpleDateFormat != null) {
                return simpleDateFormat;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM月dd日 HH:mm", Locale.CHINESE);
            TaskViewModel.zhSameYearFormat.set(simpleDateFormat2);
            return simpleDateFormat2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SimpleDateFormat getJaSameYearFormat() {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) TaskViewModel.jaSameYearFormat.get();
            if (simpleDateFormat != null) {
                return simpleDateFormat;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM月dd日 HH:mm", Locale.JAPANESE);
            TaskViewModel.jaSameYearFormat.set(simpleDateFormat2);
            return simpleDateFormat2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SimpleDateFormat getEnSameYearFormat() {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) TaskViewModel.enSameYearFormat.get();
            if (simpleDateFormat != null) {
                return simpleDateFormat;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM dd, HH:mm", Locale.ENGLISH);
            TaskViewModel.enSameYearFormat.set(simpleDateFormat2);
            return simpleDateFormat2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SimpleDateFormat getZhOtherYearFormat() {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) TaskViewModel.zhOtherYearFormat.get();
            if (simpleDateFormat != null) {
                return simpleDateFormat;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm", Locale.CHINESE);
            TaskViewModel.zhOtherYearFormat.set(simpleDateFormat2);
            return simpleDateFormat2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SimpleDateFormat getJaOtherYearFormat() {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) TaskViewModel.jaOtherYearFormat.get();
            if (simpleDateFormat != null) {
                return simpleDateFormat;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm", Locale.JAPANESE);
            TaskViewModel.jaOtherYearFormat.set(simpleDateFormat2);
            return simpleDateFormat2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SimpleDateFormat getEnOtherYearFormat() {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) TaskViewModel.enOtherYearFormat.get();
            if (simpleDateFormat != null) {
                return simpleDateFormat;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.ENGLISH);
            TaskViewModel.enOtherYearFormat.set(simpleDateFormat2);
            return simpleDateFormat2;
        }
    }

    public final StateFlow<Boolean> isSearchMode() {
        return this.isSearchMode;
    }

    public final StateFlow<String> getSearchQuery() {
        return this.searchQuery;
    }

    public final StateFlow<List<TaskModel>> getSearchResults() {
        return this.searchResults;
    }

    public final StateFlow<Boolean> isSearchLoading() {
        return this.isSearchLoading;
    }

    public final StateFlow<FilterOption> getSelectedFilter() {
        return this.selectedFilter;
    }

    public final StateFlow<List<TaskModel>> getTasks() {
        return this.tasks;
    }

    public final StateFlow<List<DeviceInfo>> getDevices() {
        return this.devices;
    }

    public final StateFlow<Boolean> getLoadError() {
        return this.loadError;
    }

    public final StateFlow<Boolean> isRefreshing() {
        return this.isRefreshing;
    }

    public final SharedFlow<Integer> getToastMessage() {
        return this.toastMessage;
    }

    public final Conversation getConversation(String conversationId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        return this.conversationMap.get(conversationId);
    }

    public final StateFlow<Boolean> getContentReady() {
        return this.contentReady;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void conversationChangeListener$lambda$4(TaskViewModel taskViewModel, IMService.ConversationChangeEvent conversationChangeEvent) {
        Conversation conversation;
        String id;
        Conversation conversation2;
        String id2;
        Intrinsics.checkNotNullParameter(conversationChangeEvent, Fields.EVENT);
        TraeLogUtil.INSTANCE.d(TAG, "onConversationChanged: changeType=" + conversationChangeEvent.getChangeType() + ", conversationId=" + conversationChangeEvent.getConversationId() + ", isLoadingTasks=" + taskViewModel.isLoadingTasks);
        String changeType = conversationChangeEvent.getChangeType();
        if (changeType != null) {
            int hashCode = changeType.hashCode();
            boolean z = true;
            if (hashCode == -1352294148) {
                if (changeType.equals("create") && (conversation = conversationChangeEvent.getConversation()) != null && (id = conversation.getId()) != null && taskViewModel.isConversationDisplayable(conversation)) {
                    if (!Intrinsics.areEqual(conversation.getEnvironment(), CliType.REMOTE.getValue())) {
                        conversation.setEnvironment(CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId()));
                    }
                    taskViewModel.conversationMap.put(id, conversation);
                    taskViewModel.persistConversations(CollectionsKt.listOf(conversation));
                    if (!taskViewModel.isLoadingTasks) {
                        taskViewModel.loadTasks();
                        return;
                    } else {
                        taskViewModel.pendingReload = true;
                        return;
                    }
                }
                return;
            }
            if (hashCode == -1335458389) {
                if (changeType.equals("delete")) {
                    String conversationId = conversationChangeEvent.getConversationId();
                    if (conversationId != null) {
                        taskViewModel.pendingDeleteIds.add(conversationId);
                        taskViewModel.conversationMap.remove(conversationId);
                        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) taskViewModel), Dispatchers.getIO(), (CoroutineStart) null, new TaskViewModel$conversationChangeListener$1$3$1(taskViewModel, conversationId, null), 2, (Object) null);
                    }
                    MutableStateFlow<List<TaskModel>> mutableStateFlow = taskViewModel._allTasks;
                    Iterable iterable = (Iterable) mutableStateFlow.getValue();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : iterable) {
                        if (!Intrinsics.areEqual(((TaskModel) obj).getId(), conversationChangeEvent.getConversationId())) {
                            arrayList.add(obj);
                        }
                    }
                    mutableStateFlow.setValue(arrayList);
                    return;
                }
                return;
            }
            if (hashCode == -838846263 && changeType.equals("update") && (conversation2 = conversationChangeEvent.getConversation()) != null && (id2 = conversation2.getId()) != null) {
                if (taskViewModel.isConversationDisplayable(conversation2)) {
                    if (!Intrinsics.areEqual(conversation2.getEnvironment(), CliType.REMOTE.getValue())) {
                        conversation2.setEnvironment(CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation2.getCliId()));
                    }
                    taskViewModel.conversationMap.put(id2, conversation2);
                    taskViewModel.persistConversations(CollectionsKt.listOf(conversation2));
                    TaskModel taskModel = taskViewModel.toTaskModel(conversation2);
                    List<TaskModel> list = (List) taskViewModel._allTasks.getValue();
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics.areEqual(((TaskModel) it.next()).getId(), id2)) {
                                break;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        MutableStateFlow<List<TaskModel>> mutableStateFlow2 = taskViewModel._allTasks;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        for (TaskModel taskModel2 : list) {
                            if (Intrinsics.areEqual(taskModel2.getId(), id2)) {
                                taskModel2 = taskModel;
                            }
                            arrayList2.add(taskModel2);
                        }
                        mutableStateFlow2.setValue(taskViewModel.sortTasks(arrayList2));
                    } else if (!taskViewModel.isLoadingTasks) {
                        taskViewModel.loadTasks();
                    }
                } else if (!taskViewModel.isLoadingTasks) {
                    taskViewModel.loadTasks();
                }
                taskViewModel.startPollingIfNeeded();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cliStatusChangeListener$lambda$5(TaskViewModel taskViewModel, IMService.CliStatusChangePayload cliStatusChangePayload) {
        Intrinsics.checkNotNullParameter(cliStatusChangePayload, "payload");
        TraeLogUtil.INSTANCE.d(TAG, "cliStatusChange received: cliId=" + cliStatusChangePayload.getCliId() + ", available=" + cliStatusChangePayload.getAvailable());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) taskViewModel), Dispatchers.getMain(), (CoroutineStart) null, new TaskViewModel$cliStatusChangeListener$1$1(taskViewModel, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cliUnbindListener$lambda$6(TaskViewModel taskViewModel, IMService.CliUnbindPayload cliUnbindPayload) {
        Intrinsics.checkNotNullParameter(cliUnbindPayload, "payload");
        TraeLogUtil.INSTANCE.d(TAG, "cliUnbind received: cliId=" + cliUnbindPayload.getCliId());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) taskViewModel), Dispatchers.getMain(), (CoroutineStart) null, new TaskViewModel$cliUnbindListener$1$1(taskViewModel, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cliRegisterListener$lambda$7(TaskViewModel taskViewModel, IMService.CliRegisterPayload cliRegisterPayload) {
        Intrinsics.checkNotNullParameter(cliRegisterPayload, "payload");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) taskViewModel), Dispatchers.getMain(), (CoroutineStart) null, new TaskViewModel$cliRegisterListener$1$1(cliRegisterPayload, taskViewModel, null), 2, (Object) null);
    }

    protected void onCleared() {
        super.onCleared();
        stopPolling();
        IMService.INSTANCE.removeConversationChangeListener(this.conversationChangeListener);
        IMService.INSTANCE.removeCliStatusChangeListener(this.cliStatusChangeListener);
        IMService.INSTANCE.removeCliUnbindListener(this.cliUnbindListener);
        IMService.INSTANCE.removeCliRegisterListener(this.cliRegisterListener);
    }

    private final void observeNetworkState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new TaskViewModel$observeNetworkState$1(this, null), 3, (Object) null);
    }

    public final void setFilter(FilterOption filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        this._selectedFilter.setValue(filter);
    }

    public final void enterSearchMode() {
        this._isSearchMode.setValue(true);
    }

    public final void updateSearchQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        this._searchQuery.setValue(query);
        scheduleSearch(query);
    }

    public final void clearSearchQuery() {
        this._searchQuery.setValue("");
        resetSearchResults();
    }

    public final void exitSearchMode() {
        this._searchQuery.setValue("");
        this._isSearchMode.setValue(false);
        resetSearchResults();
    }

    public final void loadTasks() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.lastLoadTime < this.minLoadIntervalMs) {
            TraeLogUtil.INSTANCE.d(TAG, "loadTasks skipped: minLoadInterval not met, elapsed=" + (elapsedRealtime - this.lastLoadTime) + "ms");
        } else {
            if (this.isLoadingTasks) {
                TraeLogUtil.INSTANCE.d(TAG, "loadTasks skipped: already loading");
                return;
            }
            this.lastLoadTime = elapsedRealtime;
            this.isLoadingTasks = true;
            this.loadTasksJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new TaskViewModel$loadTasks$1(this, null), 3, (Object) null);
        }
    }

    public final void loadTasksOnResume() {
        if (SystemClock.elapsedRealtime() - this.lastLoadTime >= this.refreshIntervalMs) {
            loadTasks();
        }
    }

    public final void forceLoadTasks() {
        TraeLogUtil.INSTANCE.d(TAG, "forceLoadTasks called");
        this.lastLoadTime = 0L;
        loadTasks();
    }

    public final void refreshTasks() {
        this._isRefreshing.setValue(true);
        loadDevices();
        Job job = this.loadTasksJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.loadTasksJob = null;
        this.isLoadingTasks = false;
        this.pendingReload = false;
        this.lastLoadTime = 0L;
        this.loadTasksJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new TaskViewModel$refreshTasks$1(this, null), 3, (Object) null);
    }

    public final void retry() {
        this._loadError.setValue(false);
        forceLoadTasks();
    }

    public final void startPollingIfNeeded() {
        Job job = this.pollingJob;
        boolean z = true;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Iterable iterable = (Iterable) this._allTasks.getValue();
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (((TaskModel) it.next()).getStatus().getDisplayState() == TaskDisplayState.LOADING) {
                    break;
                }
            }
        }
        z = false;
        if (z) {
            this.pollingJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new TaskViewModel$startPollingIfNeeded$1(this, null), 3, (Object) null);
        }
    }

    public final void stopPolling() {
        Job job = this.pollingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.pollingJob = null;
    }

    private final void scheduleSearch(String query) {
        this.searchDebouncer.submit(query, ((Boolean) this._isSearchMode.getValue()).booleanValue(), new Function0() { // from class: com.bytedance.trae.home.solo.task.TaskViewModel$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit scheduleSearch$lambda$9;
                scheduleSearch$lambda$9 = TaskViewModel.scheduleSearch$lambda$9(TaskViewModel.this);
                return scheduleSearch$lambda$9;
            }
        }, new Function0() { // from class: com.bytedance.trae.home.solo.task.TaskViewModel$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit scheduleSearch$lambda$10;
                scheduleSearch$lambda$10 = TaskViewModel.scheduleSearch$lambda$10(TaskViewModel.this);
                return scheduleSearch$lambda$10;
            }
        }, new TaskViewModel$scheduleSearch$3(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit scheduleSearch$lambda$9(TaskViewModel taskViewModel) {
        taskViewModel.resetSearchResults();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit scheduleSearch$lambda$10(TaskViewModel taskViewModel) {
        taskViewModel._isSearchLoading.setValue(true);
        taskViewModel._searchResults.setValue((Object) null);
        return Unit.INSTANCE;
    }

    private final void resetSearchResults() {
        this.searchDebouncer.cancel();
        this._isSearchLoading.setValue(false);
        this._searchResults.setValue((Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object searchLocalTasks(String str, Continuation<? super List<TaskModel>> continuation) {
        TaskViewModel$searchLocalTasks$1 taskViewModel$searchLocalTasks$1;
        int i;
        TaskViewModel taskViewModel;
        if (continuation instanceof TaskViewModel$searchLocalTasks$1) {
            taskViewModel$searchLocalTasks$1 = (TaskViewModel$searchLocalTasks$1) continuation;
            if ((taskViewModel$searchLocalTasks$1.label & Integer.MIN_VALUE) != 0) {
                taskViewModel$searchLocalTasks$1.label -= Integer.MIN_VALUE;
                Object obj = taskViewModel$searchLocalTasks$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = taskViewModel$searchLocalTasks$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    List list = (List) this._allTasks.getValue();
                    CoroutineContext io = Dispatchers.getIO();
                    TaskViewModel$searchLocalTasks$2 taskViewModel$searchLocalTasks$2 = new TaskViewModel$searchLocalTasks$2(list, str, this, null);
                    taskViewModel$searchLocalTasks$1.L$0 = this;
                    taskViewModel$searchLocalTasks$1.label = 1;
                    obj = BuildersKt.withContext(io, taskViewModel$searchLocalTasks$2, taskViewModel$searchLocalTasks$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    taskViewModel = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    taskViewModel = (TaskViewModel) taskViewModel$searchLocalTasks$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return taskViewModel.sortedForTaskList((List) obj);
            }
        }
        taskViewModel$searchLocalTasks$1 = new TaskViewModel$searchLocalTasks$1(this, continuation);
        Object obj2 = taskViewModel$searchLocalTasks$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = taskViewModel$searchLocalTasks$1.label;
        if (i != 0) {
        }
        return taskViewModel.sortedForTaskList((List) obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportFirstLoadEvent(int taskCount) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("did", IApplog.INSTANCE.getDeviceId());
        jSONObject.put(NewTaskTracker.Param.TASK_COUNT, taskCount);
        jSONObject.put(ReportConstant.COMMON_TIMESTAMP, System.currentTimeMillis());
        IApplog.INSTANCE.reportEvent("first_load_tasks_completed", jSONObject);
        TraeLogUtil.INSTANCE.d(TAG, "reportFirstLoadEvent: " + jSONObject);
    }

    private final void loadCachedTasks() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new TaskViewModel$loadCachedTasks$1(this, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void replaceAllConversations(List<Conversation> conversations) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new TaskViewModel$replaceAllConversations$1(this, conversations, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void persistConversations(List<Conversation> conversations) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new TaskViewModel$persistConversations$1(this, conversations, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isConversationDisplayable(Conversation conversation) {
        if (StringsKt.equals(conversation.getDisplayEnvironment(), CliType.REMOTE.getValue(), true)) {
            return true;
        }
        CliListRepository companion = CliListRepository.INSTANCE.getInstance();
        String cliId = conversation.getCliId();
        if (cliId == null) {
            cliId = "";
        }
        return StringKt.isNotNullOrEmpty(companion.getCliTypeById(cliId));
    }

    public final void loadDevices() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new TaskViewModel$loadDevices$1(this, null), 3, (Object) null);
    }

    private final void observeCliCache() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new TaskViewModel$observeCliCache$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyDevices(List<Cli> clis) {
        String name;
        MutableStateFlow<List<DeviceInfo>> mutableStateFlow = this._devices;
        ArrayList arrayList = new ArrayList();
        for (Cli cli : clis) {
            String id = cli.getId();
            DeviceInfo deviceInfo = null;
            if (id != null && (name = cli.getName()) != null) {
                String type = cli.getType();
                if (type == null) {
                    type = "local";
                }
                deviceInfo = new DeviceInfo(id, name, type, Intrinsics.areEqual(cli.getStatus(), "online"), cli.getIdeVersion());
            }
            if (deviceInfo != null) {
                arrayList.add(deviceInfo);
            }
        }
        mutableStateFlow.setValue(arrayList);
        reconcileSelectedFilterWithDevices();
        rebuildTasksFromConversations();
        TraeLogUtil.INSTANCE.d(TAG, "loadDevices: loaded " + ((List) this._devices.getValue()).size() + " devices");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void rebuildTasksFromConversations() {
        boolean z;
        Conversation conversation;
        String location;
        TaskModel copy;
        Object obj;
        Object obj2;
        CliListRepository companion = CliListRepository.INSTANCE.getInstance();
        Iterator<Map.Entry<String, Conversation>> it = this.conversationMap.entrySet().iterator();
        while (it.hasNext()) {
            Conversation value = it.next().getValue();
            if (!Intrinsics.areEqual(value.getDisplayEnvironment(), CliType.REMOTE.getValue())) {
                value.setEnvironment(companion.getCliTypeById(value.getCliId()));
            }
        }
        List list = (List) this._allTasks.getValue();
        if (list.isEmpty()) {
            return;
        }
        MutableStateFlow<List<TaskModel>> mutableStateFlow = this._allTasks;
        List<TaskModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (TaskModel taskModel : list2) {
            String cliTypeById = companion.getCliTypeById(taskModel.getCliId());
            String str = cliTypeById == null ? "remote" : cliTypeById;
            boolean z2 = !StringsKt.equals(str, "remote", true);
            String str2 = null;
            if (z2) {
                Iterator it2 = ((Iterable) this._devices.getValue()).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj2 = it2.next();
                        if (Intrinsics.areEqual(((DeviceInfo) obj2).getCliId(), taskModel.getCliId())) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                DeviceInfo deviceInfo = (DeviceInfo) obj2;
                if (deviceInfo != null) {
                    z = deviceInfo.isOnline();
                    if (z2) {
                        Iterator it3 = ((Iterable) this._devices.getValue()).iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                obj = it3.next();
                                if (Intrinsics.areEqual(((DeviceInfo) obj).getCliId(), taskModel.getCliId())) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        DeviceInfo deviceInfo2 = (DeviceInfo) obj;
                        if (deviceInfo2 != null) {
                            str2 = deviceInfo2.getIdeVersion();
                        }
                    }
                    conversation = this.conversationMap.get(taskModel.getId());
                    if (conversation == null) {
                        if (StringsKt.equals(str, CliType.IDE.getValue(), true)) {
                            location = TaskLocationFormatter.INSTANCE.formatIdeLocation(conversation.getOwnerProjectAbsolutePath(), conversation.getOwnerProjectWorkSpaceStatus(), conversation.getDisplayWorkspace());
                        } else {
                            location = extractLocation(conversation.getDisplayWorkspace(), conversation.getDisplayGitUri(), conversation.getDisplayRepoName(), z2);
                        }
                    } else {
                        location = taskModel.getLocation();
                    }
                    copy = taskModel.copy((r40 & 1) != 0 ? taskModel.id : null, (r40 & 2) != 0 ? taskModel.initial : null, (r40 & 4) != 0 ? taskModel.title : null, (r40 & 8) != 0 ? taskModel.status : null, (r40 & 16) != 0 ? taskModel.tag : null, (r40 & 32) != 0 ? taskModel.location : location, (r40 & 64) != 0 ? taskModel.time : null, (r40 & 128) != 0 ? taskModel.updatedAt : null, (r40 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? taskModel.cliId : null, (r40 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? taskModel.mode : null, (r40 & 1024) != 0 ? taskModel.isUnread : false, (r40 & 2048) != 0 ? taskModel.isPinned : false, (r40 & 4096) != 0 ? taskModel.pinnedAt : null, (r40 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? taskModel.supportsPin : TaskPinCapability.INSTANCE.isSupported(z2, str2), (r40 & 16384) != 0 ? taskModel.isLocal : z2, (r40 & 32768) != 0 ? taskModel.isDeviceOnline : z, (r40 & 65536) != 0 ? taskModel.cliType : cliTypeById, (r40 & 131072) != 0 ? taskModel.iconType : null, (r40 & 262144) != 0 ? taskModel.searchSnippet : null, (r40 & FConstants.SLICE_SIZE) != 0 ? taskModel.searchQuery : null, (r40 & 1048576) != 0 ? taskModel.searchHighlightKeywords : null, (r40 & 2097152) != 0 ? taskModel.searchAnchorCreatedAtMs : null);
                    arrayList.add(copy);
                }
            }
            z = true;
            if (z2) {
            }
            conversation = this.conversationMap.get(taskModel.getId());
            if (conversation == null) {
            }
            copy = taskModel.copy((r40 & 1) != 0 ? taskModel.id : null, (r40 & 2) != 0 ? taskModel.initial : null, (r40 & 4) != 0 ? taskModel.title : null, (r40 & 8) != 0 ? taskModel.status : null, (r40 & 16) != 0 ? taskModel.tag : null, (r40 & 32) != 0 ? taskModel.location : location, (r40 & 64) != 0 ? taskModel.time : null, (r40 & 128) != 0 ? taskModel.updatedAt : null, (r40 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? taskModel.cliId : null, (r40 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? taskModel.mode : null, (r40 & 1024) != 0 ? taskModel.isUnread : false, (r40 & 2048) != 0 ? taskModel.isPinned : false, (r40 & 4096) != 0 ? taskModel.pinnedAt : null, (r40 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? taskModel.supportsPin : TaskPinCapability.INSTANCE.isSupported(z2, str2), (r40 & 16384) != 0 ? taskModel.isLocal : z2, (r40 & 32768) != 0 ? taskModel.isDeviceOnline : z, (r40 & 65536) != 0 ? taskModel.cliType : cliTypeById, (r40 & 131072) != 0 ? taskModel.iconType : null, (r40 & 262144) != 0 ? taskModel.searchSnippet : null, (r40 & FConstants.SLICE_SIZE) != 0 ? taskModel.searchQuery : null, (r40 & 1048576) != 0 ? taskModel.searchHighlightKeywords : null, (r40 & 2097152) != 0 ? taskModel.searchAnchorCreatedAtMs : null);
            arrayList.add(copy);
        }
        mutableStateFlow.setValue(arrayList);
    }

    private final void reconcileSelectedFilterWithDevices() {
        FilterOption.Device device;
        Object value = this._selectedFilter.getValue();
        Object obj = null;
        FilterOption.Device device2 = value instanceof FilterOption.Device ? (FilterOption.Device) value : null;
        if (device2 == null) {
            return;
        }
        Iterator it = ((Iterable) this._devices.getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((DeviceInfo) next).getCliId(), device2.getCliId())) {
                obj = next;
                break;
            }
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        MutableStateFlow<FilterOption> mutableStateFlow = this._selectedFilter;
        if (deviceInfo == null) {
            device = FilterOption.All.INSTANCE;
        } else {
            device = !Intrinsics.areEqual(deviceInfo.getName(), device2.getName()) ? new FilterOption.Device(deviceInfo.getCliId(), deviceInfo.getName()) : device2;
        }
        mutableStateFlow.setValue(device);
    }

    public final void renameConversation(String conversationId, String newTitle) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(newTitle, "newTitle");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new TaskViewModel$renameConversation$1(conversationId, newTitle, this, null), 3, (Object) null);
    }

    public final void deleteConversation(String conversationId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new TaskViewModel$deleteConversation$1(conversationId, this, null), 3, (Object) null);
    }

    public final void pinConversation(TaskModel task) {
        Intrinsics.checkNotNullParameter(task, "task");
        performPinAction(task, true);
    }

    public final void unpinConversation(TaskModel task) {
        Intrinsics.checkNotNullParameter(task, "task");
        performPinAction(task, false);
    }

    private final void performPinAction(TaskModel task, boolean shouldPin) {
        if (task.getSupportsPin()) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new TaskViewModel$performPinAction$1(shouldPin, task.getId(), this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void applyPinSuccess(String conversationId, boolean shouldPin, PinConversationResponse data) {
        String str;
        Conversation conversation;
        Conversation conversation2;
        MutableStateFlow<List<TaskModel>> mutableStateFlow;
        Conversation conversation3;
        ArrayList arrayList;
        Boolean isPinned;
        boolean booleanValue = (data == null || (isPinned = data.isPinned()) == null) ? shouldPin : isPinned.booleanValue();
        if (booleanValue) {
            String pinnedAt = data != null ? data.getPinnedAt() : null;
            str = pinnedAt == null ? "" : pinnedAt;
        } else {
            str = null;
        }
        Conversation conversation4 = data != null ? data.getConversation() : null;
        if (conversation4 == null) {
            Conversation conversation5 = this.conversationMap.get(conversationId);
            if (conversation5 != null) {
                conversation4 = conversation5.copy((r44 & 1) != 0 ? conversation5.id : null, (r44 & 2) != 0 ? conversation5.parentConversationId : null, (r44 & 4) != 0 ? conversation5.hiddenStatus : null, (r44 & 8) != 0 ? conversation5.cliConversationId : null, (r44 & 16) != 0 ? conversation5.userId : null, (r44 & 32) != 0 ? conversation5.cliId : null, (r44 & 64) != 0 ? conversation5.title : null, (r44 & 128) != 0 ? conversation5.workspace : null, (r44 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? conversation5.gitUri : null, (r44 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? conversation5.mode : null, (r44 & 1024) != 0 ? conversation5.status : null, (r44 & 2048) != 0 ? conversation5.environment : null, (r44 & 4096) != 0 ? conversation5.latestTaskId : null, (r44 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? conversation5.latestTaskStatus : null, (r44 & 16384) != 0 ? conversation5.latestTaskUpdateTime : null, (r44 & 32768) != 0 ? conversation5.createdAt : null, (r44 & 65536) != 0 ? conversation5.updatedAt : null, (r44 & 131072) != 0 ? conversation5.source : null, (r44 & 262144) != 0 ? conversation5.iconType : null, (r44 & FConstants.SLICE_SIZE) != 0 ? conversation5.cliConversationStatus : null, (r44 & 1048576) != 0 ? conversation5.ownerProjectId : null, (r44 & 2097152) != 0 ? conversation5.latestProjectId : null, (r44 & 4194304) != 0 ? conversation5.ownerProjectAbsolutePath : null, (r44 & 8388608) != 0 ? conversation5.ownerProjectWorkSpaceStatus : null, (r44 & 16777216) != 0 ? conversation5.isPinned : Boolean.valueOf(booleanValue), (r44 & 33554432) != 0 ? conversation5.pinnedAt : str);
            } else {
                conversation = null;
                if (!Intrinsics.areEqual(conversation != null ? conversation.getEnvironment() : null, CliType.REMOTE.getValue()) && conversation != null) {
                    conversation.setEnvironment(CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId()));
                }
                if (conversation != null) {
                    String id = conversation.getId();
                    if (id != null) {
                        this.conversationMap.put(id, conversation);
                    }
                    persistConversations(CollectionsKt.listOf(conversation));
                }
                MutableStateFlow<List<TaskModel>> mutableStateFlow2 = this._allTasks;
                Iterable<TaskModel> iterable = (Iterable) mutableStateFlow2.getValue();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (TaskModel taskModel : iterable) {
                    if (!Intrinsics.areEqual(taskModel.getId(), conversationId)) {
                        mutableStateFlow = mutableStateFlow2;
                        conversation3 = conversation;
                        arrayList = arrayList2;
                    } else if (conversation != null) {
                        taskModel = toTaskModel(conversation);
                        arrayList = arrayList2;
                        mutableStateFlow = mutableStateFlow2;
                        conversation3 = conversation;
                    } else {
                        mutableStateFlow = mutableStateFlow2;
                        conversation3 = conversation;
                        taskModel = taskModel.copy((r40 & 1) != 0 ? taskModel.id : null, (r40 & 2) != 0 ? taskModel.initial : null, (r40 & 4) != 0 ? taskModel.title : null, (r40 & 8) != 0 ? taskModel.status : null, (r40 & 16) != 0 ? taskModel.tag : null, (r40 & 32) != 0 ? taskModel.location : null, (r40 & 64) != 0 ? taskModel.time : null, (r40 & 128) != 0 ? taskModel.updatedAt : null, (r40 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? taskModel.cliId : null, (r40 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? taskModel.mode : null, (r40 & 1024) != 0 ? taskModel.isUnread : false, (r40 & 2048) != 0 ? taskModel.isPinned : booleanValue, (r40 & 4096) != 0 ? taskModel.pinnedAt : str == null ? "" : str, (r40 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? taskModel.supportsPin : false, (r40 & 16384) != 0 ? taskModel.isLocal : false, (r40 & 32768) != 0 ? taskModel.isDeviceOnline : false, (r40 & 65536) != 0 ? taskModel.cliType : null, (r40 & 131072) != 0 ? taskModel.iconType : null, (r40 & 262144) != 0 ? taskModel.searchSnippet : null, (r40 & FConstants.SLICE_SIZE) != 0 ? taskModel.searchQuery : null, (r40 & 1048576) != 0 ? taskModel.searchHighlightKeywords : null, (r40 & 2097152) != 0 ? taskModel.searchAnchorCreatedAtMs : null);
                        arrayList = arrayList2;
                    }
                    arrayList.add(taskModel);
                    arrayList2 = arrayList;
                    mutableStateFlow2 = mutableStateFlow;
                    conversation = conversation3;
                }
                conversation2 = conversation;
                mutableStateFlow2.setValue(sortTasks(arrayList2));
                if (conversation2 == null) {
                    IMService.INSTANCE.notifyConversationChanged(new IMService.ConversationChangeEvent("update", conversation2.getId(), conversation2));
                    return;
                }
                return;
            }
        }
        conversation = conversation4;
        if (!Intrinsics.areEqual(conversation != null ? conversation.getEnvironment() : null, CliType.REMOTE.getValue())) {
            conversation.setEnvironment(CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId()));
        }
        if (conversation != null) {
        }
        MutableStateFlow<List<TaskModel>> mutableStateFlow22 = this._allTasks;
        Iterable<TaskModel> iterable2 = (Iterable) mutableStateFlow22.getValue();
        ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        while (r29.hasNext()) {
        }
        conversation2 = conversation;
        mutableStateFlow22.setValue(sortTasks(arrayList22));
        if (conversation2 == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int pinFailureString(boolean shouldPin) {
        if (shouldPin) {
            return C0820R.string.solo_toast_pin_failed;
        }
        return C0820R.string.solo_toast_unpin_failed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int pinSuccessString(boolean shouldPin) {
        if (shouldPin) {
            return C0820R.string.solo_toast_pin_success;
        }
        return C0820R.string.solo_toast_unpin_success;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TaskModel toTaskModel(Conversation conversation) {
        String title;
        String str;
        String str2;
        String mode;
        String cliTypeById;
        boolean z;
        String extractLocation;
        boolean z2;
        Object obj;
        Object obj2;
        Integer intOrNull;
        String title2 = conversation.getTitle();
        if (title2 == null || StringsKt.isBlank(title2)) {
            title = this.defaultTaskTitle;
        } else {
            title = conversation.getTitle();
            if (title == null) {
                str = "";
                String valueOf = String.valueOf(Character.toUpperCase(StringsKt.first(str)));
                String formatTime = formatTime(conversation.getUpdatedAt());
                String status = conversation.getStatus();
                TaskStatus fromStatusCode = TaskStatus.INSTANCE.fromStatusCode((status != null || (intOrNull = StringsKt.toIntOrNull(status)) == null) ? 0 : intOrNull.intValue());
                boolean z3 = fromStatusCode.getDisplayState() != TaskDisplayState.ERROR;
                if (!StringsKt.equals(conversation.getMode(), "code", true)) {
                    mode = "Code";
                } else if (StringsKt.equals(conversation.getMode(), "work", true)) {
                    mode = "Work";
                } else {
                    String mode2 = conversation.getMode();
                    if (mode2 == null || StringsKt.isBlank(mode2)) {
                        str2 = "";
                        cliTypeById = CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId());
                        if (cliTypeById == null) {
                            cliTypeById = "remote";
                        }
                        z = !StringsKt.equals(cliTypeById, "remote", true);
                        if (StringsKt.equals(cliTypeById, CliType.IDE.getValue(), true)) {
                            extractLocation = TaskLocationFormatter.INSTANCE.formatIdeLocation(conversation.getOwnerProjectAbsolutePath(), conversation.getOwnerProjectWorkSpaceStatus(), conversation.getDisplayWorkspace());
                        } else {
                            extractLocation = extractLocation(conversation.getDisplayWorkspace(), conversation.getDisplayGitUri(), conversation.getDisplayRepoName(), z);
                        }
                        String str3 = extractLocation;
                        String str4 = null;
                        if (z) {
                            Iterator it = ((Iterable) this._devices.getValue()).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    obj2 = null;
                                    break;
                                }
                                obj2 = it.next();
                                if (Intrinsics.areEqual(((DeviceInfo) obj2).getCliId(), conversation.getCliId())) {
                                    break;
                                }
                            }
                            DeviceInfo deviceInfo = (DeviceInfo) obj2;
                            if (deviceInfo != null) {
                                z2 = deviceInfo.isOnline();
                                if (z) {
                                    Iterator it2 = ((Iterable) this._devices.getValue()).iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            obj = null;
                                            break;
                                        }
                                        obj = it2.next();
                                        if (Intrinsics.areEqual(((DeviceInfo) obj).getCliId(), conversation.getCliId())) {
                                            break;
                                        }
                                    }
                                    DeviceInfo deviceInfo2 = (DeviceInfo) obj;
                                    if (deviceInfo2 != null) {
                                        str4 = deviceInfo2.getIdeVersion();
                                    }
                                }
                                String id = conversation.getId();
                                String str5 = id != null ? "" : id;
                                String updatedAt = conversation.getUpdatedAt();
                                String str6 = updatedAt != null ? "" : updatedAt;
                                String cliId = conversation.getCliId();
                                String str7 = cliId != null ? "" : cliId;
                                String mode3 = conversation.getMode();
                                String str8 = mode3 != null ? "" : mode3;
                                boolean areEqual = Intrinsics.areEqual(conversation.isPinned(), true);
                                String pinnedAt = conversation.getPinnedAt();
                                return new TaskModel(str5, valueOf, str, fromStatusCode, str2, str3, formatTime, str6, str7, str8, z3, areEqual, pinnedAt != null ? "" : pinnedAt, TaskPinCapability.INSTANCE.isSupported(z, str4), z, z2, CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId()), TaskIconType.INSTANCE.fromString(conversation.getIconType()), null, null, null, null, 3932160, null);
                            }
                        }
                        z2 = true;
                        if (z) {
                        }
                        String id2 = conversation.getId();
                        if (id2 != null) {
                        }
                        String updatedAt2 = conversation.getUpdatedAt();
                        if (updatedAt2 != null) {
                        }
                        String cliId2 = conversation.getCliId();
                        if (cliId2 != null) {
                        }
                        String mode32 = conversation.getMode();
                        if (mode32 != null) {
                        }
                        boolean areEqual2 = Intrinsics.areEqual(conversation.isPinned(), true);
                        String pinnedAt2 = conversation.getPinnedAt();
                        return new TaskModel(str5, valueOf, str, fromStatusCode, str2, str3, formatTime, str6, str7, str8, z3, areEqual2, pinnedAt2 != null ? "" : pinnedAt2, TaskPinCapability.INSTANCE.isSupported(z, str4), z, z2, CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId()), TaskIconType.INSTANCE.fromString(conversation.getIconType()), null, null, null, null, 3932160, null);
                    }
                    mode = conversation.getMode();
                    Intrinsics.checkNotNull(mode);
                }
                str2 = mode;
                cliTypeById = CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId());
                if (cliTypeById == null) {
                }
                z = !StringsKt.equals(cliTypeById, "remote", true);
                if (StringsKt.equals(cliTypeById, CliType.IDE.getValue(), true)) {
                }
                String str32 = extractLocation;
                String str42 = null;
                if (z) {
                }
                z2 = true;
                if (z) {
                }
                String id22 = conversation.getId();
                if (id22 != null) {
                }
                String updatedAt22 = conversation.getUpdatedAt();
                if (updatedAt22 != null) {
                }
                String cliId22 = conversation.getCliId();
                if (cliId22 != null) {
                }
                String mode322 = conversation.getMode();
                if (mode322 != null) {
                }
                boolean areEqual22 = Intrinsics.areEqual(conversation.isPinned(), true);
                String pinnedAt22 = conversation.getPinnedAt();
                return new TaskModel(str5, valueOf, str, fromStatusCode, str2, str32, formatTime, str6, str7, str8, z3, areEqual22, pinnedAt22 != null ? "" : pinnedAt22, TaskPinCapability.INSTANCE.isSupported(z, str42), z, z2, CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId()), TaskIconType.INSTANCE.fromString(conversation.getIconType()), null, null, null, null, 3932160, null);
            }
        }
        str = title;
        String valueOf2 = String.valueOf(Character.toUpperCase(StringsKt.first(str)));
        String formatTime2 = formatTime(conversation.getUpdatedAt());
        String status2 = conversation.getStatus();
        TaskStatus fromStatusCode2 = TaskStatus.INSTANCE.fromStatusCode((status2 != null || (intOrNull = StringsKt.toIntOrNull(status2)) == null) ? 0 : intOrNull.intValue());
        if (fromStatusCode2.getDisplayState() != TaskDisplayState.ERROR) {
        }
        if (!StringsKt.equals(conversation.getMode(), "code", true)) {
        }
        str2 = mode;
        cliTypeById = CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId());
        if (cliTypeById == null) {
        }
        z = !StringsKt.equals(cliTypeById, "remote", true);
        if (StringsKt.equals(cliTypeById, CliType.IDE.getValue(), true)) {
        }
        String str322 = extractLocation;
        String str422 = null;
        if (z) {
        }
        z2 = true;
        if (z) {
        }
        String id222 = conversation.getId();
        if (id222 != null) {
        }
        String updatedAt222 = conversation.getUpdatedAt();
        if (updatedAt222 != null) {
        }
        String cliId222 = conversation.getCliId();
        if (cliId222 != null) {
        }
        String mode3222 = conversation.getMode();
        if (mode3222 != null) {
        }
        boolean areEqual222 = Intrinsics.areEqual(conversation.isPinned(), true);
        String pinnedAt222 = conversation.getPinnedAt();
        return new TaskModel(str5, valueOf2, str, fromStatusCode2, str2, str322, formatTime2, str6, str7, str8, z3, areEqual222, pinnedAt222 != null ? "" : pinnedAt222, TaskPinCapability.INSTANCE.isSupported(z, str422), z, z2, CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId()), TaskIconType.INSTANCE.fromString(conversation.getIconType()), null, null, null, null, 3932160, null);
    }

    public final String extractIDELocation(String folderPath, String workspaceType) {
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        Intrinsics.checkNotNullParameter(workspaceType, "workspaceType");
        return TaskLocationFormatter.INSTANCE.formatIdeLocation(folderPath, workspaceType, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
    
        if (r3 == null) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TaskModel toTaskModel(SearchConversationItem searchConversationItem, String str, List<String> list) {
        String str2;
        String str3;
        Conversation conversation;
        String messageCreatedAt;
        TaskModel copy;
        String conversationId = searchConversationItem.getConversationId();
        if (conversationId != null) {
            if (!(!StringsKt.isBlank(conversationId))) {
                conversationId = null;
            }
            if (conversationId != null) {
                Conversation conversation2 = this.conversationMap.get(conversationId);
                String conversationTitle = searchConversationItem.getConversationTitle();
                if (conversationTitle != null) {
                    if (!(!StringsKt.isBlank(conversationTitle))) {
                        conversationTitle = null;
                    }
                }
                if (conversation2 == null || (conversationTitle = conversation2.getTitle()) == null || !(!StringsKt.isBlank(conversationTitle))) {
                    conversationTitle = null;
                }
                if (conversationTitle == null) {
                    conversationTitle = this.defaultTaskTitle;
                }
                String conversationUpdatedAt = searchConversationItem.getConversationUpdatedAt();
                if (conversationUpdatedAt == null) {
                    conversationUpdatedAt = conversation2 != null ? conversation2.getUpdatedAt() : null;
                    if (conversationUpdatedAt == null && (conversationUpdatedAt = searchConversationItem.getMessageCreatedAt()) == null) {
                        str2 = "";
                        str3 = str2;
                        if (StringsKt.isBlank(str3)) {
                            str3 = conversation2 != null ? conversation2.getUpdatedAt() : null;
                            if (str3 == null) {
                                str3 = "";
                            }
                        }
                        String str4 = str3;
                        if (conversation2 != null || conversation == null) {
                            conversation = new Conversation(conversationId, null, null, null, null, searchConversationItem.getCliId(), conversationTitle, null, null, null, String.valueOf(TaskStatus.FINISHED.getStatusCode()), !TextUtils.isEmpty(searchConversationItem.getCliId()) ? CliType.REMOTE.getValue() : CliListRepository.INSTANCE.getInstance().getCliTypeById(searchConversationItem.getCliId()), null, null, null, null, str4, null, null, null, null, null, null, null, null, null, 67040158, null);
                        }
                        this.conversationMap.put(conversationId, conversation);
                        TaskModel taskModel = toTaskModel(conversation);
                        messageCreatedAt = searchConversationItem.getMessageCreatedAt();
                        if (messageCreatedAt == null) {
                            messageCreatedAt = str2;
                        }
                        String formatTime = formatTime(messageCreatedAt);
                        String messageContent = searchConversationItem.getMessageContent();
                        String str5 = messageContent != null ? "" : messageContent;
                        String messageCreatedAtMs = searchConversationItem.getMessageCreatedAtMs();
                        copy = taskModel.copy((r40 & 1) != 0 ? taskModel.id : null, (r40 & 2) != 0 ? taskModel.initial : null, (r40 & 4) != 0 ? taskModel.title : conversationTitle, (r40 & 8) != 0 ? taskModel.status : null, (r40 & 16) != 0 ? taskModel.tag : null, (r40 & 32) != 0 ? taskModel.location : null, (r40 & 64) != 0 ? taskModel.time : formatTime, (r40 & 128) != 0 ? taskModel.updatedAt : null, (r40 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? taskModel.cliId : null, (r40 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? taskModel.mode : null, (r40 & 1024) != 0 ? taskModel.isUnread : false, (r40 & 2048) != 0 ? taskModel.isPinned : false, (r40 & 4096) != 0 ? taskModel.pinnedAt : null, (r40 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? taskModel.supportsPin : false, (r40 & 16384) != 0 ? taskModel.isLocal : false, (r40 & 32768) != 0 ? taskModel.isDeviceOnline : false, (r40 & 65536) != 0 ? taskModel.cliType : null, (r40 & 131072) != 0 ? taskModel.iconType : null, (r40 & 262144) != 0 ? taskModel.searchSnippet : str5, (r40 & FConstants.SLICE_SIZE) != 0 ? taskModel.searchQuery : str, (r40 & 1048576) != 0 ? taskModel.searchHighlightKeywords : list, (r40 & 2097152) != 0 ? taskModel.searchAnchorCreatedAtMs : (messageCreatedAtMs == null && (StringsKt.isBlank(messageCreatedAtMs) ^ true)) ? messageCreatedAtMs : null);
                        return copy;
                    }
                }
                str2 = conversationUpdatedAt;
                str3 = str2;
                if (StringsKt.isBlank(str3)) {
                }
                String str42 = str3;
                if (conversation2 != null) {
                    conversation = conversation2.copy((r44 & 1) != 0 ? conversation2.id : null, (r44 & 2) != 0 ? conversation2.parentConversationId : null, (r44 & 4) != 0 ? conversation2.hiddenStatus : null, (r44 & 8) != 0 ? conversation2.cliConversationId : null, (r44 & 16) != 0 ? conversation2.userId : null, (r44 & 32) != 0 ? conversation2.cliId : null, (r44 & 64) != 0 ? conversation2.title : conversationTitle, (r44 & 128) != 0 ? conversation2.workspace : null, (r44 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? conversation2.gitUri : null, (r44 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? conversation2.mode : null, (r44 & 1024) != 0 ? conversation2.status : null, (r44 & 2048) != 0 ? conversation2.environment : null, (r44 & 4096) != 0 ? conversation2.latestTaskId : null, (r44 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? conversation2.latestTaskStatus : null, (r44 & 16384) != 0 ? conversation2.latestTaskUpdateTime : null, (r44 & 32768) != 0 ? conversation2.createdAt : null, (r44 & 65536) != 0 ? conversation2.updatedAt : str42, (r44 & 131072) != 0 ? conversation2.source : null, (r44 & 262144) != 0 ? conversation2.iconType : null, (r44 & FConstants.SLICE_SIZE) != 0 ? conversation2.cliConversationStatus : null, (r44 & 1048576) != 0 ? conversation2.ownerProjectId : null, (r44 & 2097152) != 0 ? conversation2.latestProjectId : null, (r44 & 4194304) != 0 ? conversation2.ownerProjectAbsolutePath : null, (r44 & 8388608) != 0 ? conversation2.ownerProjectWorkSpaceStatus : null, (r44 & 16777216) != 0 ? conversation2.isPinned : null, (r44 & 33554432) != 0 ? conversation2.pinnedAt : null);
                }
                conversation = new Conversation(conversationId, null, null, null, null, searchConversationItem.getCliId(), conversationTitle, null, null, null, String.valueOf(TaskStatus.FINISHED.getStatusCode()), !TextUtils.isEmpty(searchConversationItem.getCliId()) ? CliType.REMOTE.getValue() : CliListRepository.INSTANCE.getInstance().getCliTypeById(searchConversationItem.getCliId()), null, null, null, null, str42, null, null, null, null, null, null, null, null, null, 67040158, null);
                this.conversationMap.put(conversationId, conversation);
                TaskModel taskModel2 = toTaskModel(conversation);
                messageCreatedAt = searchConversationItem.getMessageCreatedAt();
                if (messageCreatedAt == null) {
                }
                String formatTime2 = formatTime(messageCreatedAt);
                String messageContent2 = searchConversationItem.getMessageContent();
                if (messageContent2 != null) {
                }
                String messageCreatedAtMs2 = searchConversationItem.getMessageCreatedAtMs();
                copy = taskModel2.copy((r40 & 1) != 0 ? taskModel2.id : null, (r40 & 2) != 0 ? taskModel2.initial : null, (r40 & 4) != 0 ? taskModel2.title : conversationTitle, (r40 & 8) != 0 ? taskModel2.status : null, (r40 & 16) != 0 ? taskModel2.tag : null, (r40 & 32) != 0 ? taskModel2.location : null, (r40 & 64) != 0 ? taskModel2.time : formatTime2, (r40 & 128) != 0 ? taskModel2.updatedAt : null, (r40 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? taskModel2.cliId : null, (r40 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? taskModel2.mode : null, (r40 & 1024) != 0 ? taskModel2.isUnread : false, (r40 & 2048) != 0 ? taskModel2.isPinned : false, (r40 & 4096) != 0 ? taskModel2.pinnedAt : null, (r40 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? taskModel2.supportsPin : false, (r40 & 16384) != 0 ? taskModel2.isLocal : false, (r40 & 32768) != 0 ? taskModel2.isDeviceOnline : false, (r40 & 65536) != 0 ? taskModel2.cliType : null, (r40 & 131072) != 0 ? taskModel2.iconType : null, (r40 & 262144) != 0 ? taskModel2.searchSnippet : str5, (r40 & FConstants.SLICE_SIZE) != 0 ? taskModel2.searchQuery : str, (r40 & 1048576) != 0 ? taskModel2.searchHighlightKeywords : list, (r40 & 2097152) != 0 ? taskModel2.searchAnchorCreatedAtMs : (messageCreatedAtMs2 == null && (StringsKt.isBlank(messageCreatedAtMs2) ^ true)) ? messageCreatedAtMs2 : null);
                return copy;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<TaskModel> sortedForTaskList(List<TaskModel> list) {
        return sortTasks(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<TaskModel> sortTasks(List<TaskModel> tasks) {
        final Function2 function2 = new Function2() { // from class: com.bytedance.trae.home.solo.task.TaskViewModel$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2) {
                int sortTasks$lambda$29;
                sortTasks$lambda$29 = TaskViewModel.sortTasks$lambda$29(TaskViewModel.this, (TaskModel) obj, (TaskModel) obj2);
                return Integer.valueOf(sortTasks$lambda$29);
            }
        };
        return CollectionsKt.sortedWith(tasks, new Comparator() { // from class: com.bytedance.trae.home.solo.task.TaskViewModel$$ExternalSyntheticLambda7
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int sortTasks$lambda$30;
                sortTasks$lambda$30 = TaskViewModel.sortTasks$lambda$30(function2, obj, obj2);
                return sortTasks$lambda$30;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sortTasks$lambda$30(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sortTasks$lambda$29(TaskViewModel taskViewModel, TaskModel taskModel, TaskModel taskModel2) {
        if (taskModel.isPinned() && taskModel2.isPinned()) {
            Integer valueOf = Integer.valueOf(taskViewModel.compareTaskTime(taskModel2.getPinnedAt(), taskModel.getPinnedAt()));
            if (!(valueOf.intValue() != 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                return valueOf.intValue();
            }
            return taskViewModel.compareTaskTime(taskModel2.getUpdatedAt(), taskModel.getUpdatedAt());
        }
        if (taskModel.isPinned() != taskModel2.isPinned()) {
            return taskModel.isPinned() ? -1 : 1;
        }
        return taskViewModel.compareTaskTime(taskModel2.getUpdatedAt(), taskModel.getUpdatedAt());
    }

    private final int compareTaskTime(String left, String right) {
        Long sortableTimeKey = sortableTimeKey(left);
        Long sortableTimeKey2 = sortableTimeKey(right);
        if (sortableTimeKey != null && sortableTimeKey2 != null) {
            return Intrinsics.compare(sortableTimeKey.longValue(), sortableTimeKey2.longValue());
        }
        if (sortableTimeKey != null) {
            return 1;
        }
        if (sortableTimeKey2 != null) {
            return -1;
        }
        return left.compareTo(right);
    }

    private final Long sortableTimeKey(String value) {
        Object obj;
        String str = value;
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        String obj2 = StringsKt.trim(str).toString();
        String str2 = obj2;
        int i = 0;
        while (true) {
            if (i >= str2.length()) {
                z = true;
                break;
            }
            if (!Character.isDigit(str2.charAt(i))) {
                break;
            }
            i++;
        }
        if (z) {
            Long longOrNull = StringsKt.toLongOrNull(obj2);
            if (longOrNull == null) {
                return null;
            }
            long longValue = longOrNull.longValue();
            if (longValue <= 1000000000000L) {
                longValue *= 1000;
            }
            return Long.valueOf(longValue);
        }
        try {
            Result.Companion companion = Result.Companion;
            TaskViewModel taskViewModel = this;
            obj = Result.constructor-impl(Long.valueOf(OffsetDateTime.parse(obj2).toInstant().toEpochMilli()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Long) (Result.isFailure-impl(obj) ? null : obj);
    }

    private final String extractLocation(String workspace, String gitUri, String repoName, boolean isLocal) {
        String lastTwoPathComponents;
        String str = null;
        if (!isLocal) {
            if (gitUri == null) {
                return "";
            }
            if (!(!StringsKt.isBlank(gitUri))) {
                gitUri = null;
            }
            return (gitUri == null || (lastTwoPathComponents = lastTwoPathComponents(gitUri)) == null) ? "" : lastTwoPathComponents;
        }
        if (workspace != null) {
            if (!(!StringsKt.isBlank(workspace))) {
                workspace = null;
            }
            if (workspace != null) {
                str = lastPathComponent(workspace);
            }
        }
        return str == null ? "" : str;
    }

    private final String lastPathComponent(String path) {
        if (StringsKt.endsWith$default(path, ".git", false, 2, (Object) null)) {
            path = StringsKt.dropLast(path, 4);
        }
        List split$default = StringsKt.split$default(StringsKt.trimEnd(path, new char[]{'/', '\\'}), new char[]{'/', '\\'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        String str = (String) CollectionsKt.lastOrNull(arrayList);
        return str == null ? "" : str;
    }

    private final String lastTwoPathComponents(String path) {
        List split$default = StringsKt.split$default(StringsKt.trimEnd(path, new char[]{'/', '\\'}), new char[]{'/', '\\'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() >= 2) {
            return CollectionsKt.joinToString$default(CollectionsKt.takeLast(arrayList2, 2), "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        String str = (String) CollectionsKt.lastOrNull(arrayList2);
        return str == null ? "" : str;
    }

    private final String formatTime(String updatedAt) {
        boolean z;
        String str;
        Long longOrNull;
        String str2 = updatedAt;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return "";
        }
        try {
            String obj = StringsKt.trim(updatedAt).toString();
            String str3 = obj;
            int i = 0;
            while (true) {
                if (i >= str3.length()) {
                    z = true;
                    break;
                }
                if (!Character.isDigit(str3.charAt(i))) {
                    z = false;
                    break;
                }
                i++;
            }
            Object date = (!z || (longOrNull = StringsKt.toLongOrNull(obj)) == null) ? null : longOrNull.longValue() > 1000000000000L ? new Date(longOrNull.longValue()) : new Date(longOrNull.longValue() * 1000);
            if (date == null) {
                for (SimpleDateFormat simpleDateFormat : INSTANCE.getParseDateFormats()) {
                    try {
                        Result.Companion companion = Result.Companion;
                        TaskViewModel taskViewModel = this;
                        date = Result.constructor-impl(simpleDateFormat.parse(obj));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        date = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.isFailure-impl(date)) {
                        date = null;
                    }
                    if (date != null) {
                        break;
                    }
                }
            }
            if (date == null) {
                return "";
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime((Date) date);
            String language = Locale.getDefault().getLanguage();
            Calendar calendar3 = Calendar.getInstance();
            calendar3.set(11, 0);
            calendar3.set(12, 0);
            calendar3.set(13, 0);
            calendar3.set(14, 0);
            Calendar calendar4 = Calendar.getInstance();
            calendar4.setTimeInMillis(calendar3.getTimeInMillis());
            calendar4.add(6, -1);
            Companion companion3 = INSTANCE;
            String format = companion3.getTimeOnlyFormat().format((Date) date);
            if (((Date) date).getTime() < calendar3.getTimeInMillis()) {
                if (((Date) date).getTime() >= calendar4.getTimeInMillis()) {
                    if (Intrinsics.areEqual(language, "zh")) {
                        str = "昨天";
                    } else {
                        str = Intrinsics.areEqual(language, "ja") ? "昨日" : "Yesterday";
                    }
                    format = str + ' ' + format;
                } else if (calendar2.get(1) == calendar.get(1)) {
                    format = Intrinsics.areEqual(language, "zh") ? companion3.getZhSameYearFormat().format((Date) date) : Intrinsics.areEqual(language, "ja") ? companion3.getJaSameYearFormat().format((Date) date) : companion3.getEnSameYearFormat().format((Date) date);
                } else {
                    format = Intrinsics.areEqual(language, "zh") ? companion3.getZhOtherYearFormat().format((Date) date) : Intrinsics.areEqual(language, "ja") ? companion3.getJaOtherYearFormat().format((Date) date) : companion3.getEnOtherYearFormat().format((Date) date);
                }
            }
            Intrinsics.checkNotNull(format);
            return format;
        } catch (Exception unused) {
            return "";
        }
    }
}
