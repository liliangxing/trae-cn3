package com.bytedance.trae.conversation.voice.subtask;

import android.content.res.Resources;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.ServiceType;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.TocCreditsPolicy;
import com.bytedance.trae.conversation.chat.error.AgentErrorCodeRegistry;
import com.bytedance.trae.conversation.model.QueryItem;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.conversation.voice.VoiceDiscussionMetrics;
import com.bytedance.trae.conversation.voice.network.VoiceSubTaskConfig;
import com.bytedance.trae.conversation.voice.subtitle.SubtitleBinaryProtocol;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedError;
import com.bytedance.trae.im.model.ParsedPlanItem;
import com.bytedance.trae.im.model.ParsedPlanItemMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.ConversationInfo;
import com.bytedance.trae.im.service.CreateTaskRawResult;
import com.bytedance.trae.im.service.CreateTaskRequest;
import com.bytedance.trae.im.service.CreateTaskResponse;
import com.bytedance.trae.im.service.ICancelTaskApi;
import com.bytedance.trae.im.service.IChatSessionApi;
import com.bytedance.trae.im.service.ICreateAgentTask;
import com.bytedance.trae.im.service.IMService;
import com.bytedance.trae.im.service.InitialMessage;
import com.bytedance.trae.im.service.Mode;
import com.bytedance.trae.im.service.ModelSelectionStrategy;
import com.bytedance.trae.im.service.Source;
import com.bytedance.trae.multilanguage.I18nTextProvider;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONObject;

/* compiled from: VoiceSubTaskCoordinator.kt */
@Metadata(d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0012\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006º\u0002»\u0002¼\u0002B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010m\u001a\u00020\t2\u0006\u0010,\u001a\u00020-2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007J\u0010\u0010n\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010/J\u0014\u0010o\u001a\u00020%2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020r0qJ'\u0010s\u001a\u00020\f2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020r0q2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\buJ-\u0010v\u001a\b\u0012\u0004\u0012\u00020w0q2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020r0q2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\bxJ\u0018\u0010y\u001a\u00020%2\u0006\u0010z\u001a\u0002072\b\u0010{\u001a\u0004\u0018\u00010\fJ\u0018\u0010|\u001a\u00020%2\u0006\u0010z\u001a\u0002072\b\u0010{\u001a\u0004\u0018\u00010\fJ\u0018\u0010}\u001a\u00020%2\u0006\u0010z\u001a\u0002072\u0006\u0010~\u001a\u000209H\u0002J\n\u0010\u007f\u001a\u0004\u0018\u00010\fH\u0002J-\u0010\u0080\u0001\u001a\u00020\t2\u0007\u0010\u0081\u0001\u001a\u00020\u001b2\u0006\u0010z\u001a\u0002072\u0006\u0010~\u001a\u0002092\t\b\u0002\u0010\u0082\u0001\u001a\u00020%H\u0002J$\u0010\u0083\u0001\u001a\u00020\t2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010z\u001a\u0002072\u0006\u0010~\u001a\u000209H\u0002J\u0019\u0010\u0084\u0001\u001a\u00020\t2\u0006\u0010z\u001a\u0002072\u0006\u0010~\u001a\u000209H\u0002J\u001b\u0010\u0085\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\f2\u0007\u0010\u0087\u0001\u001a\u00020\fH\u0002J$\u0010\u0088\u0001\u001a\u00020@2\u0007\u0010\u0089\u0001\u001a\u00020\u001b2\t\u0010\u008a\u0001\u001a\u0004\u0018\u000104H\u0082@¢\u0006\u0003\u0010\u008b\u0001J?\u0010\u008c\u0001\u001a\u00020@2\u0007\u0010\u008d\u0001\u001a\u00020\f2\u0007\u0010\u008e\u0001\u001a\u00020\f2\u0007\u0010\u0086\u0001\u001a\u00020\f2\u0007\u0010\u0087\u0001\u001a\u00020\f2\t\b\u0002\u0010\u008f\u0001\u001a\u00020!H\u0082@¢\u0006\u0003\u0010\u0090\u0001J:\u0010\u0091\u0001\u001a\u00020@2\r\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020@0?2\u0007\u0010\u008e\u0001\u001a\u00020\f2\u0007\u0010\u0086\u0001\u001a\u00020\f2\u0007\u0010\u008f\u0001\u001a\u00020!H\u0082@¢\u0006\u0003\u0010\u0093\u0001J+\u0010\u0094\u0001\u001a\u00020%2\u0007\u0010\u008d\u0001\u001a\u00020\f2\u0007\u0010\u008e\u0001\u001a\u00020\f2\u0007\u0010\u0087\u0001\u001a\u00020\fH\u0082@¢\u0006\u0003\u0010\u0095\u0001J\u0013\u0010\u0096\u0001\u001a\u00020%2\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0002J%\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020@0?2\u0007\u0010\u008e\u0001\u001a\u00020\f2\u000b\b\u0002\u0010\u0086\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\u009a\u0001\u001a\u00020%2\u0007\u0010\u008e\u0001\u001a\u00020\fH\u0002JB\u0010\u009b\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\f2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010\u009d\u0001\u001a\u00020%2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010#2\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0003\u0010 \u0001J\u001d\u0010¡\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\f2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010¢\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\fH\u0002J\u001a\u0010£\u0001\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?2\u0007\u0010\u008e\u0001\u001a\u00020\fH\u0002J\u001a\u0010¤\u0001\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?2\u0007\u0010\u008e\u0001\u001a\u00020\fH\u0002J\u001b\u0010¥\u0001\u001a\u00020\t2\u0007\u0010¦\u0001\u001a\u00020\u001b2\u0007\u0010§\u0001\u001a\u00020\fH\u0002J$\u0010¨\u0001\u001a\u00020\t2\u0007\u0010©\u0001\u001a\u00020\f2\u0007\u0010ª\u0001\u001a\u00020\f2\u0007\u0010§\u0001\u001a\u00020\fH\u0002J\u0012\u0010«\u0001\u001a\u00020\f2\u0007\u0010¬\u0001\u001a\u00020\fH\u0002J$\u0010\u00ad\u0001\u001a\u00020\t2\u0007\u0010¦\u0001\u001a\u00020\u001b2\u0007\u0010\u0087\u0001\u001a\u00020\f2\u0007\u0010§\u0001\u001a\u00020\fH\u0002J\u0014\u0010®\u0001\u001a\u00020\t2\t\u0010¯\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0011\u0010°\u0001\u001a\u00020\t2\u0006\u0010z\u001a\u000207H\u0002JB\u0010±\u0001\u001a\u00020\t2\u0007\u0010¦\u0001\u001a\u00020\u001b2\u0007\u0010\u009c\u0001\u001a\u00020\f2\t\u0010²\u0001\u001a\u0004\u0018\u00010\f2\t\u0010³\u0001\u001a\u0004\u0018\u00010!2\t\b\u0002\u0010´\u0001\u001a\u00020%H\u0002¢\u0006\u0003\u0010µ\u0001J\u0011\u0010¶\u0001\u001a\u00020\t2\u0006\u0010z\u001a\u000207H\u0002J\u0011\u0010·\u0001\u001a\u00020\t2\u0006\u0010z\u001a\u000207H\u0002J\u0011\u0010¸\u0001\u001a\u00020\t2\b\u0010¹\u0001\u001a\u00030º\u0001J\u0013\u0010»\u0001\u001a\u00020\t2\b\u0010¹\u0001\u001a\u00030º\u0001H\u0002J\u001b\u0010¼\u0001\u001a\u00020\t2\b\u0010¹\u0001\u001a\u00030½\u00012\b\u0010{\u001a\u0004\u0018\u00010\fJ\u0011\u0010¾\u0001\u001a\u00020%2\b\u0010¹\u0001\u001a\u00030¿\u0001J\u0013\u0010À\u0001\u001a\u00020%2\b\u0010¹\u0001\u001a\u00030¿\u0001H\u0002J'\u0010Á\u0001\u001a\u00020%2\u0007\u0010\u0081\u0001\u001a\u00020\u001b2\b\u0010¹\u0001\u001a\u00030¿\u00012\t\u0010²\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010Â\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\fH\u0002J\u0012\u0010Ã\u0001\u001a\u00020\t2\u0007\u0010Ä\u0001\u001a\u00020\fH\u0002J\u0012\u0010Å\u0001\u001a\u00020\t2\u0007\u0010\u0081\u0001\u001a\u00020\u001bH\u0002J\u0015\u0010Æ\u0001\u001a\u0004\u0018\u00010\f2\b\u0010¹\u0001\u001a\u00030¿\u0001H\u0002J\u001b\u0010Ç\u0001\u001a\u00020\t2\u0007\u0010\u0087\u0001\u001a\u00020\f2\t\b\u0002\u0010È\u0001\u001a\u00020%J\u001d\u0010É\u0001\u001a\u00020\t2\t\b\u0002\u0010Ê\u0001\u001a\u00020%2\t\b\u0002\u0010\u0087\u0001\u001a\u00020\fJ\u0012\u0010Ë\u0001\u001a\u00020\t2\u0007\u0010\u0087\u0001\u001a\u00020\fH\u0002J$\u0010Ì\u0001\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0007\u0010\u0087\u0001\u001a\u00020\fH\u0002J\u0012\u0010Í\u0001\u001a\u0004\u0018\u00010\fH\u0086@¢\u0006\u0003\u0010Î\u0001J\u001b\u0010Ï\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ð\u0001\u001a\u00020-H\u0082@¢\u0006\u0003\u0010Ñ\u0001J\u001b\u0010Ò\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ð\u0001\u001a\u00020-H\u0082@¢\u0006\u0003\u0010Ñ\u0001J,\u0010Ó\u0001\u001a\u00020\t2\u0007\u0010Ð\u0001\u001a\u00020-2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\f2\u0006\u0010z\u001a\u000207H\u0082@¢\u0006\u0003\u0010Ô\u0001J$\u0010Õ\u0001\u001a\u00030Ö\u00012\b\u0010×\u0001\u001a\u00030Ø\u00012\u0007\u0010\u0086\u0001\u001a\u00020\fH\u0082@¢\u0006\u0003\u0010Ù\u0001J\u0017\u0010Ú\u0001\u001a\u00020\f2\u0006\u0010z\u001a\u000207H\u0000¢\u0006\u0003\bÛ\u0001J\u001d\u0010Ü\u0001\u001a\b\u0012\u0004\u0012\u00020w0q2\u0006\u0010z\u001a\u000207H\u0000¢\u0006\u0003\bÝ\u0001J&\u0010Þ\u0001\u001a\b\u0012\u0004\u0012\u00020w0q2\u000f\u0010ß\u0001\u001a\n\u0012\u0004\u0012\u00020w\u0018\u00010qH\u0000¢\u0006\u0003\bà\u0001J\u0018\u0010á\u0001\u001a\u00020\f2\u0007\u0010â\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\bã\u0001J\u0012\u0010ä\u0001\u001a\u00020\f2\u0007\u0010â\u0001\u001a\u00020\fH\u0002J1\u0010å\u0001\u001a\u0004\u0018\u00010\f2\t\u0010æ\u0001\u001a\u0004\u0018\u00010\u00012\u0013\u0010ç\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0T\"\u00020\fH\u0002¢\u0006\u0003\u0010è\u0001J1\u0010é\u0001\u001a\u0004\u0018\u00010!2\t\u0010æ\u0001\u001a\u0004\u0018\u00010\u00012\u0013\u0010ç\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0T\"\u00020\fH\u0002¢\u0006\u0003\u0010ê\u0001J\u0017\u0010ë\u0001\u001a\u0005\u0018\u00010ì\u00012\t\u0010æ\u0001\u001a\u0004\u0018\u00010\u0001H\u0002J\u001b\u0010í\u0001\u001a\u00020\t2\u0007\u0010î\u0001\u001a\u00020!2\u0007\u0010\u0086\u0001\u001a\u00020\fH\u0002J\t\u0010ï\u0001\u001a\u00020\tH\u0002J\u0012\u0010ð\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\fH\u0002J\t\u0010ñ\u0001\u001a\u00020\tH\u0002J\u001b\u0010ò\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\f2\u0007\u0010\u0087\u0001\u001a\u00020\fH\u0002J(\u0010ó\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\f2\u0007\u0010\u0087\u0001\u001a\u00020\f2\u000b\b\u0002\u0010ô\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u001b\u0010õ\u0001\u001a\u00020%2\u0007\u0010ö\u0001\u001a\u00020\f2\u0007\u0010÷\u0001\u001a\u00020#H\u0002J\u0012\u0010ø\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\fH\u0002JN\u0010ù\u0001\u001a\u00020\t2\u0007\u0010¬\u0001\u001a\u00020\f2\u0007\u0010\u009c\u0001\u001a\u00020\f2\u0007\u0010ú\u0001\u001a\u00020\f2\u0007\u0010³\u0001\u001a\u00020!2\t\b\u0002\u0010\u009e\u0001\u001a\u00020\f2\u000b\b\u0002\u0010ô\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010§\u0001\u001a\u00020\fH\u0002J\u0012\u0010û\u0001\u001a\u00020%2\u0007\u0010¬\u0001\u001a\u00020\fH\u0002J\u0012\u0010ü\u0001\u001a\u00020\t2\u0007\u0010¬\u0001\u001a\u00020\fH\u0002J\u0012\u0010ý\u0001\u001a\u00020\t2\u0007\u0010¬\u0001\u001a\u00020\fH\u0002J\u0012\u0010þ\u0001\u001a\u00020\t2\u0007\u0010¬\u0001\u001a\u00020\fH\u0002J\u001b\u0010ÿ\u0001\u001a\u00020%2\u0007\u0010\u0086\u0001\u001a\u00020\f2\u0007\u0010\u0080\u0002\u001a\u00020!H\u0002J\u0012\u0010\u0081\u0002\u001a\u00020%2\u0007\u0010¬\u0001\u001a\u00020\fH\u0002Jn\u0010\u0082\u0002\u001a\u00030Ø\u00012\u0007\u0010Ð\u0001\u001a\u00020-2\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\f2\t\u0010\u0084\u0002\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\u000b\b\u0002\u0010\u0085\u0002\u001a\u0004\u0018\u00010\f2\f\b\u0002\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u0087\u00022\u000b\b\u0002\u0010\u0088\u0002\u001a\u0004\u0018\u00010/2\t\b\u0002\u0010\u0089\u0002\u001a\u00020%H\u0000¢\u0006\u0003\b\u008a\u0002J\u0013\u0010\u008b\u0002\u001a\u00020\f2\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0002J&\u0010\u008c\u0002\u001a\u0005\u0018\u00010ì\u00012\b\u0010,\u001a\u0004\u0018\u00010/2\b\u0010\u008d\u0002\u001a\u00030\u008e\u0002H\u0000¢\u0006\u0003\b\u008f\u0002J\u001e\u0010\u0090\u0002\u001a\u0005\u0018\u00010ì\u00012\n\u0010\u0091\u0002\u001a\u0005\u0018\u00010ì\u0001H\u0000¢\u0006\u0003\b\u0092\u0002J \u0010\u0093\u0002\u001a\u0004\u0018\u00010\f2\n\u0010\u0094\u0002\u001a\u0005\u0018\u00010ì\u00012\u0007\u0010\u0095\u0002\u001a\u00020\fH\u0002JZ\u0010\u0096\u0002\u001a\u00030\u0097\u00022\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\t\u0010\u0098\u0002\u001a\u0004\u0018\u00010\f23\b\u0002\u0010\u0099\u0002\u001a,\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0007\u0012\u0005\u0018\u00010ì\u0001\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u009a\u0002H\u0000¢\u0006\u0003\b\u009b\u0002J.\u0010\u009c\u0002\u001a\u00030\u0097\u00022\b\u0010â\u0001\u001a\u00030Ö\u00012\u0007\u0010\u009d\u0002\u001a\u00020\f2\t\b\u0002\u0010\u009e\u0002\u001a\u00020%H\u0000¢\u0006\u0003\b\u009f\u0002J\u0018\u0010 \u0002\u001a\u00020%2\u0007\u0010¡\u0002\u001a\u00020!H\u0000¢\u0006\u0003\b¢\u0002J&\u0010£\u0002\u001a\u00020\f2\u0007\u0010¤\u0002\u001a\u00020\f2\u0007\u0010\u0080\u0002\u001a\u00020!2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u008c\u0001\u0010¥\u0002\u001a\u0004\u0018\u00010\f2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\t\u0010¦\u0002\u001a\u0004\u0018\u00010#2\t\u0010§\u0002\u001a\u0004\u0018\u00010\f2\n\u0010¨\u0002\u001a\u0005\u0018\u00010ì\u00012\t\u0010\u0098\u0002\u001a\u0004\u0018\u00010\f2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\f23\b\u0002\u0010\u0099\u0002\u001a,\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0007\u0012\u0005\u0018\u00010ì\u0001\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u009a\u0002H\u0000¢\u0006\u0006\b©\u0002\u0010ª\u0002J\u0017\u0010«\u0002\u001a\u0004\u0018\u00010\f2\n\u0010æ\u0001\u001a\u0005\u0018\u00010ì\u0001H\u0002J6\u0010¬\u0002\u001a\u0004\u0018\u00010\f2\u0007\u0010¡\u0002\u001a\u00020#2\t\u0010§\u0002\u001a\u0004\u0018\u00010\f2\n\u0010æ\u0001\u001a\u0005\u0018\u00010ì\u00012\t\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010®\u0002\u001a\u0004\u0018\u00010\f2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0014\u0010¯\u0002\u001a\u0004\u0018\u00010\f2\u0007\u0010°\u0002\u001a\u00020#H\u0002J*\u0010±\u0002\u001a\u0004\u0018\u00010\f2\u0017\u0010²\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0T\"\u0004\u0018\u00010\fH\u0002¢\u0006\u0003\u0010³\u0002J*\u0010´\u0002\u001a\u0004\u0018\u00010\f2\u0017\u0010²\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0T\"\u0004\u0018\u00010\fH\u0002¢\u0006\u0003\u0010³\u0002J&\u0010µ\u0002\u001a\u0004\u0018\u00010!2\u0007\u0010¶\u0002\u001a\u00020#2\u0007\u0010·\u0002\u001a\u00020!H\u0000¢\u0006\u0006\b¸\u0002\u0010¹\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020#0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020%0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001b0)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010=\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0?0>X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\f0Dj\b\u0012\u0004\u0012\u00020\f`EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\f0Dj\b\u0012\u0004\u0012\u00020\f`EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020\f0TX\u0082\u0004¢\u0006\u0004\n\u0002\u0010UR\u000e\u0010V\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010f\u001a\b\u0012\u0004\u0012\u00020\f0gX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010h\u001a\b\u0012\u0004\u0012\u00020i0gX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010j\u001a\b\u0012\u0004\u0012\u00020\f0gX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020lX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006½\u0002"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;", "", "<init>", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "sendAckToBot", "Lkotlin/Function1;", "", "", "_proxyConversationId", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "proxyConversationId", "Lkotlinx/coroutines/flow/StateFlow;", "getProxyConversationId", "()Lkotlinx/coroutines/flow/StateFlow;", "_proxyChatSessionId", "proxyChatSessionId", "getProxyChatSessionId", "_parentConversationId", "parentConversationId", "getParentConversationId", "_parentChatSessionId", "parentChatSessionId", "getParentChatSessionId", "_activeTask", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;", "activeTask", "getActiveTask", "latestRoomIdForMetrics", "subTaskMetricStartedAtMs", "Ljava/util/concurrent/ConcurrentHashMap;", "", "subTaskMetricFileCounts", "", "subTaskMetricEndedTaskIds", "", "_parallelTerminalToolResults", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "parallelTerminalToolResults", "Lkotlinx/coroutines/flow/SharedFlow;", "getParallelTerminalToolResults", "()Lkotlinx/coroutines/flow/SharedFlow;", "config", "Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;", "subTaskConfig", "Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;", "deviceOnline", "cliStatusListener", "Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;", "parentCreateJob", "Lkotlinx/coroutines/Job;", "taskCreateJob", "pendingClientProxyRequest", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;", "pendingClientProxyExecutor", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;", "pendingClientProxyStartJob", "cancelingClientProxyTaskId", "cancelWaiterLock", "cancelWaiters", "", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;", "cancelWaiterSourceToLocal", "subTaskResultReportLock", "subTaskResultReportedTaskIds", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "createTaskBizErrorSuppressLock", "createTaskBizErrorSuppressedTaskIds", "resultAliasLock", "resultTaskIdAlias", "timeoutJob", "longRunningJob", "started", "TAG", "ORIGIN", "HIDDEN_STATUS_VOICE_DISCUSSION", "SUB_TASK_AGENT_TYPE", "TRAE_RES_PREFIX", "REMOTE_RESOURCE_PREFIX", "CHAT_SESSION_ID_KEYS", "", "[Ljava/lang/String;", "STATUS_COMPLETED", "STATUS_IN_PROGRESS", "SUB_TASK_FAILURE_REASON_INTERRUPTED", "ERROR_CODE_DEVICE_OFFLINE_NUMERIC", "CREATE_TASK_RETRYABLE_BIZ_CODE", "CREATE_TASK_LEGACY_SUCCESS_BIZ_CODE", "CREATE_TASK_MAX_RETRIES", "CREATE_TASK_RETRY_MAX_DELAY_MS", "CREATE_TASK_RETRY_BASE_DELAY_MS", "CREATE_TASK_RETRY_DELAY_CAP_MS", "CANCEL_REMOTE_TERMINAL_WAIT_MS", "RESULT_REPORT_CACHE_LIMIT", "DROP_REASON_BUSY", "SUPERSEDE_REASON_CANCEL_PREVIOUS_FAILED", "TOOL_NAME_TASK_CREATE", "SUPERSEDED_RESULT_NOTE", "COMPLETED_STATUSES", "", "IN_FLIGHT_STATES", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;", "FINISH_TOOLS", "streamingListener", "Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;", "start", "updateSubTaskConfig", "notifyAttachmentsToBot", "items", "", "Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;", "buildNotifyAttachmentQueryJson", "chatSessionId", "buildNotifyAttachmentQueryJson$conversation_mainlandRelease", "buildNotifyAttachmentParts", "Lcom/bytedance/trae/conversation/model/QueryItem;", "buildNotifyAttachmentParts$conversation_mainlandRelease", "handleSubTaskRequest", "req", "currentRoomId", "handleSubTaskUpdate", "rejectIfPrecheckFailed", "executor", "evaluatePrechecks", "queueSubTaskSupersede", "current", "silentForServer", "replaceSwitchingPending", "showPendingTask", "failPendingClientProxyTask", "sourceTaskId", "reason", "cancelPreviousTaskForSwitch", "previous", "previousCreateJob", "(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelClientProxyTaskForReuse", "proxyConvId", "localTaskId", "waitRemoteTerminalMs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCancelRemoteTerminal", "waiter", "(Lkotlinx/coroutines/CompletableDeferred;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelRemoteClientProxyTask", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isTerminalStreamingMessage", "message", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "registerCancelWaiter", "hasCancelWaiter", "completeCancelWaiterIfNeeded", PageDataManager.EXTRA_STATUS, "isHistory", AccountMonitorConstants.CommonParameter.ERROR, "errorMessage", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;)V", "completeCancelWaiterBySourceTaskId", "clearCancelWaiter", "removeCancelWaiterLocked", "removeCancelWaiterInternal", "emitParallelTerminal", "ui", "scene", "registerUpdateChainAlias", "previousTaskId", "newTaskId", "resolveReportTaskId", "taskId", "reportClientProxyFailureOnce", "rememberMetricsRoom", "roomId", "reportLocalSubtaskStart", "reportLocalSubtaskEnd", "failureReason", "durationMs", "isCancelled", "(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)V", "startClientProxyTask", "startServerClosedLoopTask", "handleTaskStart", "msg", "Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;", "startTaskStartUi", "handleTaskStop", "Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;", "handleToolResult", "Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;", "isServerToolResultCandidate", "shouldFailPendingClientProxyTask", "clearPendingClientProxyIfCurrent", "clearSwitchingPendingForStop", "activeSourceTaskId", "maybeCancelClientProxyTask", "resolveToolResultFailureReason", "cancelActiveTask", "reportClientProxyResult", "release", "deleteEmptyRemoteParentSession", "maybeDeleteEmptyRemoteParentSession", "deleteHubConversationAsync", "awaitParentChatSessionId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createRemoteParentSession", "cfg", "(Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveParentConversationIdForSubTask", "createSubTask", "(Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;Ljava/lang/String;Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTaskWithRetry", "Lcom/bytedance/trae/im/service/CreateTaskRawResult;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/CreateTaskRequest;", "(Lcom/bytedance/trae/im/service/CreateTaskRequest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildSubTaskQueryJson", "buildSubTaskQueryJson$conversation_mainlandRelease", "buildSubTaskQueryParts", "buildSubTaskQueryParts$conversation_mainlandRelease", "normalizeSubTaskFilesForCreate", "files", "normalizeSubTaskFilesForCreate$conversation_mainlandRelease", "normalizeImageIdForCreate", AccountMonitorConstants.CommonParameter.RAW, "normalizeImageIdForCreate$conversation_mainlandRelease", "normalizeAttachmentUriForCreate", "dataString", "data", "keys", "(Ljava/lang/Object;[Ljava/lang/String;)Ljava/lang/String;", "dataLong", "(Ljava/lang/Object;[Ljava/lang/String;)Ljava/lang/Long;", "dataJsonObject", "Lcom/google/gson/JsonObject;", "startTimer", "timeoutMs", "cancelTimer", "startLongRunningJob", "cancelLongRunningJob", "failActiveTask", "failActiveTaskAndReport", "error", "postToBotLLM", "messageJson", "interruptMode", "markCreatePostStart", "postSubTaskResultOnceAsync", "result", "markSubTaskResultReportStarted", "clearSubTaskResultReportStarted", "markCreateTaskRetryableBizErrorSuppressed", "clearCreateTaskRetryableBizErrorSuppressed", "shouldSuppressCreateTaskBizError", "bizCode", "isSubTaskResultReported", "createTaskRequest", "conversationId", "queryJson", "hiddenStatus", TimonPipeline.KEY_SOURCE, "Lcom/bytedance/trae/im/service/Source;", "runtimeSubTaskConfig", "creditsFeatureEnabled", "createTaskRequest$conversation_mainlandRelease", "extractContent", "resolveSubTaskModelConfig", "mode", "Lcom/bytedance/trae/im/service/Mode;", "resolveSubTaskModelConfig$conversation_mainlandRelease", "buildSubTaskCustomModel", "modelConfig", "buildSubTaskCustomModel$conversation_mainlandRelease", "readStringProperty", "obj", "key", "buildSseFailureReport", "Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;", "fallbackReason", "displayMessageResolver", "Lkotlin/Function4;", "buildSseFailureReport$conversation_mainlandRelease", "buildCreateTaskFailureReport", "fallbackCode", "suppressBizError", "buildCreateTaskFailureReport$conversation_mainlandRelease", "isCreateTaskBizSuccess", "code", "isCreateTaskBizSuccess$conversation_mainlandRelease", "buildCreateTaskMissingFieldError", "fieldName", "resolveSubTaskFailureMessage", "numericErrorCode", "originMessage", "errorData", "resolveSubTaskFailureMessage$conversation_mainlandRelease", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function4;)Ljava/lang/String;", "resolveAgentErrorDataType", "resolveAgentErrorDisplayMessage", "dataType", "resolveLocalSubTaskErrorMessage", "localizedString", "resId", "firstNonBlankErrorMessage", "values", "([Ljava/lang/String;)Ljava/lang/String;", "firstNonBlank", "calculateCreateTaskRetryDelayMs", "retryIndex", "elapsedDelayMs", "calculateCreateTaskRetryDelayMs$conversation_mainlandRelease", "(IJ)Ljava/lang/Long;", "CancelOutcome", "NotifyAttachmentItem", "CreateTaskFailureReport", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSubTaskCoordinator {
    private static final long CANCEL_REMOTE_TERMINAL_WAIT_MS = 15000;
    private static final String[] CHAT_SESSION_ID_KEYS;
    private static final Set<String> COMPLETED_STATUSES;
    private static final long CREATE_TASK_LEGACY_SUCCESS_BIZ_CODE = 200;
    private static final int CREATE_TASK_MAX_RETRIES = 15;
    private static final long CREATE_TASK_RETRYABLE_BIZ_CODE = 995000;
    private static final long CREATE_TASK_RETRY_BASE_DELAY_MS = 5000;
    private static final long CREATE_TASK_RETRY_DELAY_CAP_MS = 60000;
    private static final long CREATE_TASK_RETRY_MAX_DELAY_MS = 300000;
    private static final String DROP_REASON_BUSY = "dropped_busy";
    private static final String ERROR_CODE_DEVICE_OFFLINE_NUMERIC = "2900101";
    private static final Set<String> FINISH_TOOLS;
    private static final String HIDDEN_STATUS_VOICE_DISCUSSION = "voice_discussion";
    private static final Set<SubTaskRenderState> IN_FLIGHT_STATES;
    private static final String ORIGIN = "mobile";
    private static final String REMOTE_RESOURCE_PREFIX = "trae-res://remote_resource/";
    private static final int RESULT_REPORT_CACHE_LIMIT = 256;
    private static final String STATUS_COMPLETED = "completed";
    private static final String STATUS_IN_PROGRESS = "in_progress";
    public static final String SUB_TASK_AGENT_TYPE = "voice_chat";
    private static final String SUB_TASK_FAILURE_REASON_INTERRUPTED = "local_sub_task_superseded";
    private static final String SUPERSEDED_RESULT_NOTE = "该任务已被用户的最新需求取代，由客户端主动取消，属于正常的任务切换，不是执行失败；更新后的新任务正在启动中。请不要向用户播报任务失败，简短确认正在按新需求处理即可。";
    private static final String SUPERSEDE_REASON_CANCEL_PREVIOUS_FAILED = "local_sub_task_cancel_previous_failed";
    private static final String TAG = "VoiceSubTaskCoord";
    private static final String TOOL_NAME_TASK_CREATE = "task_create";
    private static final String TRAE_RES_PREFIX = "trae-res://";
    private static final MutableStateFlow<SubTaskUiState> _activeTask;
    private static final MutableSharedFlow<SubTaskUiState> _parallelTerminalToolResults;
    private static final MutableStateFlow<String> _parentChatSessionId;
    private static final MutableStateFlow<String> _parentConversationId;
    private static final MutableStateFlow<String> _proxyChatSessionId;
    private static final MutableStateFlow<String> _proxyConversationId;
    private static final StateFlow<SubTaskUiState> activeTask;
    private static final Object cancelWaiterLock;
    private static final Map<String, String> cancelWaiterSourceToLocal;
    private static final Map<String, CompletableDeferred<CancelOutcome>> cancelWaiters;
    private static volatile String cancelingClientProxyTaskId;
    private static final IMService.CliStatusChangeListener cliStatusListener;
    private static volatile ProxyConversationConfig config;
    private static final Object createTaskBizErrorSuppressLock;
    private static final LinkedHashSet<String> createTaskBizErrorSuppressedTaskIds;
    private static volatile boolean deviceOnline;
    private static volatile String latestRoomIdForMetrics;
    private static volatile Job longRunningJob;
    private static final SharedFlow<SubTaskUiState> parallelTerminalToolResults;
    private static final StateFlow<String> parentChatSessionId;
    private static final StateFlow<String> parentConversationId;
    private static volatile Job parentCreateJob;
    private static volatile SubTaskExecutor pendingClientProxyExecutor;
    private static volatile SubTaskRequestMessage pendingClientProxyRequest;
    private static volatile Job pendingClientProxyStartJob;
    private static final StateFlow<String> proxyChatSessionId;
    private static final StateFlow<String> proxyConversationId;
    private static final Object resultAliasLock;
    private static final Map<String, String> resultTaskIdAlias;
    private static volatile Function1<? super byte[], Unit> sendAckToBot;
    private static volatile boolean started;
    private static final IMService.StreamingMessageListener streamingListener;
    private static volatile VoiceSubTaskConfig subTaskConfig;
    private static final ConcurrentHashMap<String, Boolean> subTaskMetricEndedTaskIds;
    private static final ConcurrentHashMap<String, Integer> subTaskMetricFileCounts;
    private static final ConcurrentHashMap<String, Long> subTaskMetricStartedAtMs;
    private static final Object subTaskResultReportLock;
    private static final LinkedHashSet<String> subTaskResultReportedTaskIds;
    private static volatile Job taskCreateJob;
    private static volatile Job timeoutJob;
    public static final VoiceSubTaskCoordinator INSTANCE = new VoiceSubTaskCoordinator();
    private static final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));

    /* compiled from: VoiceSubTaskCoordinator.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SubTaskExecutor.values().length];
            try {
                iArr[SubTaskExecutor.ClientProxy.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SubTaskExecutor.ServerClosedLoop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean isCreateTaskBizSuccess$conversation_mainlandRelease(long code) {
        return code == 0 || code == 200;
    }

    private VoiceSubTaskCoordinator() {
    }

    static {
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow((Object) null);
        _proxyConversationId = MutableStateFlow;
        proxyConversationId = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow((Object) null);
        _proxyChatSessionId = MutableStateFlow2;
        proxyChatSessionId = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow((Object) null);
        _parentConversationId = MutableStateFlow3;
        parentConversationId = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<String> MutableStateFlow4 = StateFlowKt.MutableStateFlow((Object) null);
        _parentChatSessionId = MutableStateFlow4;
        parentChatSessionId = FlowKt.asStateFlow(MutableStateFlow4);
        MutableStateFlow<SubTaskUiState> MutableStateFlow5 = StateFlowKt.MutableStateFlow((Object) null);
        _activeTask = MutableStateFlow5;
        activeTask = FlowKt.asStateFlow(MutableStateFlow5);
        subTaskMetricStartedAtMs = new ConcurrentHashMap<>();
        subTaskMetricFileCounts = new ConcurrentHashMap<>();
        subTaskMetricEndedTaskIds = new ConcurrentHashMap<>();
        MutableSharedFlow<SubTaskUiState> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(0, 16, BufferOverflow.DROP_OLDEST);
        _parallelTerminalToolResults = MutableSharedFlow;
        parallelTerminalToolResults = FlowKt.asSharedFlow(MutableSharedFlow);
        deviceOnline = true;
        cliStatusListener = new IMService.CliStatusChangeListener() { // from class: com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$$ExternalSyntheticLambda0
            @Override // com.bytedance.trae.im.service.IMService.CliStatusChangeListener
            public final void onCliStatusChanged(IMService.CliStatusChangePayload cliStatusChangePayload) {
                VoiceSubTaskCoordinator.cliStatusListener$lambda$0(cliStatusChangePayload);
            }
        };
        cancelWaiterLock = new Object();
        cancelWaiters = new LinkedHashMap();
        cancelWaiterSourceToLocal = new LinkedHashMap();
        subTaskResultReportLock = new Object();
        subTaskResultReportedTaskIds = new LinkedHashSet<>();
        createTaskBizErrorSuppressLock = new Object();
        createTaskBizErrorSuppressedTaskIds = new LinkedHashSet<>();
        resultAliasLock = new Object();
        resultTaskIdAlias = new LinkedHashMap();
        CHAT_SESSION_ID_KEYS = new String[]{"chat_session_id", "chatSessionId", "cli_conversation_id", "cliConversationId", "parent_chat_session_id", "parentChatSessionId", "voice_conversation_id", "voiceConversationId", "session_id", "sessionId", "session"};
        COMPLETED_STATUSES = SetsKt.setOf(new String[]{STATUS_COMPLETED, "failed", ConfirmInfo.STATUS_CANCELED});
        IN_FLIGHT_STATES = SetsKt.setOf(new SubTaskRenderState[]{SubTaskRenderState.Creating, SubTaskRenderState.Thinking, SubTaskRenderState.Streaming});
        FINISH_TOOLS = SetsKt.setOf(new String[]{"finish", "Finish", "agent_finish", "AgentFinish", "response_to_user", "ResponseToUser", "Task"});
        streamingListener = new IMService.StreamingMessageListener() { // from class: com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$$ExternalSyntheticLambda1
            @Override // com.bytedance.trae.im.service.IMService.StreamingMessageListener
            public final void onStreamingMessage(ParsedChatMessage parsedChatMessage, boolean z) {
                VoiceSubTaskCoordinator.streamingListener$lambda$1(parsedChatMessage, z);
            }
        };
    }

    public final StateFlow<String> getProxyConversationId() {
        return proxyConversationId;
    }

    public final StateFlow<String> getProxyChatSessionId() {
        return proxyChatSessionId;
    }

    public final StateFlow<String> getParentConversationId() {
        return parentConversationId;
    }

    public final StateFlow<String> getParentChatSessionId() {
        return parentChatSessionId;
    }

    public final StateFlow<SubTaskUiState> getActiveTask() {
        return activeTask;
    }

    public final SharedFlow<SubTaskUiState> getParallelTerminalToolResults() {
        return parallelTerminalToolResults;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cliStatusListener$lambda$0(IMService.CliStatusChangePayload cliStatusChangePayload) {
        Intrinsics.checkNotNullParameter(cliStatusChangePayload, "payload");
        ProxyConversationConfig proxyConversationConfig = config;
        if (proxyConversationConfig != null && proxyConversationConfig.getCliType() == CliType.LOCAL) {
            String cliId = proxyConversationConfig.getCliId();
            if ((cliId == null || cliId.length() == 0) || !Intrinsics.areEqual(proxyConversationConfig.getCliId(), cliStatusChangePayload.getCliId())) {
                return;
            }
            deviceOnline = cliStatusChangePayload.getAvailable();
            FLogger.INSTANCE.d(TAG, "cliStatus: cliId=" + cliStatusChangePayload.getCliId() + ", online=" + cliStatusChangePayload.getAvailable());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VoiceSubTaskCoordinator.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;", "", "<init>", "()V", "LocalOnly", "RemoteAccepted", "RemoteTerminalObserved", "Failed", "Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$Failed;", "Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$LocalOnly;", "Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteAccepted;", "Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteTerminalObserved;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static abstract class CancelOutcome {
        public /* synthetic */ CancelOutcome(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: VoiceSubTaskCoordinator.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$LocalOnly;", "Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class LocalOnly extends CancelOutcome {
            public static final LocalOnly INSTANCE = new LocalOnly();

            private LocalOnly() {
                super(null);
            }
        }

        private CancelOutcome() {
        }

        /* compiled from: VoiceSubTaskCoordinator.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteAccepted;", "Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class RemoteAccepted extends CancelOutcome {
            public static final RemoteAccepted INSTANCE = new RemoteAccepted();

            private RemoteAccepted() {
                super(null);
            }
        }

        /* compiled from: VoiceSubTaskCoordinator.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$RemoteTerminalObserved;", "Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class RemoteTerminalObserved extends CancelOutcome {
            public static final RemoteTerminalObserved INSTANCE = new RemoteTerminalObserved();

            private RemoteTerminalObserved() {
                super(null);
            }
        }

        /* compiled from: VoiceSubTaskCoordinator.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome$Failed;", "Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CancelOutcome;", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Failed extends CancelOutcome {
            private final String reason;

            public static /* synthetic */ Failed copy$default(Failed failed, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = failed.reason;
                }
                return failed.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getReason() {
                return this.reason;
            }

            public final Failed copy(String reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new Failed(reason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Failed) && Intrinsics.areEqual(this.reason, ((Failed) other).reason);
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            public String toString() {
                return "Failed(reason=" + this.reason + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "reason");
                this.reason = str;
            }

            public final String getReason() {
                return this.reason;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void streamingListener$lambda$1(ParsedChatMessage parsedChatMessage, boolean z) {
        String str;
        String localTaskId;
        SubTaskRenderState subTaskRenderState;
        SubTaskRenderState subTaskRenderState2;
        MutableStateFlow<SubTaskUiState> mutableStateFlow;
        String str2;
        String str3;
        String str4;
        String str5;
        SubTaskUiState copy;
        Integer code;
        Intrinsics.checkNotNullParameter(parsedChatMessage, "message");
        if (started && (str = (String) _proxyConversationId.getValue()) != null && Intrinsics.areEqual(parsedChatMessage.getSessionId(), str)) {
            ParsedTaskContent taskContent = parsedChatMessage.getTaskContent();
            String taskId = taskContent != null ? taskContent.getTaskId() : null;
            VoiceSubTaskCoordinator voiceSubTaskCoordinator = INSTANCE;
            boolean isTerminalStreamingMessage = voiceSubTaskCoordinator.isTerminalStreamingMessage(parsedChatMessage);
            String str6 = taskId;
            if (!(str6 == null || str6.length() == 0) && voiceSubTaskCoordinator.hasCancelWaiter(taskId)) {
                FLogger fLogger = FLogger.INSTANCE;
                StringBuilder append = new StringBuilder("cancelForReuse[streaming-frame]: localTaskId=").append(taskId).append(", status=").append(parsedChatMessage.getStatus()).append(", isHistory=").append(parsedChatMessage.isHistory()).append(", errorCode=");
                ParsedError error = parsedChatMessage.getError();
                StringBuilder append2 = append.append(error != null ? error.getCode() : null).append(", errorMsg=");
                ParsedError error2 = parsedChatMessage.getError();
                fLogger.w(TAG, append2.append(error2 != null ? error2.getMessage() : null).append(", terminal=").append(isTerminalStreamingMessage).toString());
            }
            if (!(str6 == null || str6.length() == 0) && isTerminalStreamingMessage) {
                String status = parsedChatMessage.getStatus();
                boolean isHistory = parsedChatMessage.isHistory();
                ParsedError error3 = parsedChatMessage.getError();
                Integer code2 = error3 != null ? error3.getCode() : null;
                ParsedError error4 = parsedChatMessage.getError();
                voiceSubTaskCoordinator.completeCancelWaiterIfNeeded(taskId, status, isHistory, code2, error4 != null ? error4.getMessage() : null);
            }
            MutableStateFlow<SubTaskUiState> mutableStateFlow2 = _activeTask;
            SubTaskUiState subTaskUiState = (SubTaskUiState) mutableStateFlow2.getValue();
            if (subTaskUiState != null && subTaskUiState.getExecutor() == SubTaskExecutor.ClientProxy && (localTaskId = subTaskUiState.getLocalTaskId()) != null && Intrinsics.areEqual(taskId, localTaskId) && IN_FLIGHT_STATES.contains(subTaskUiState.getState())) {
                String extractContent = voiceSubTaskCoordinator.extractContent(parsedChatMessage);
                if (isTerminalStreamingMessage && (Intrinsics.areEqual(parsedChatMessage.getStatus(), STATUS_COMPLETED) || (Intrinsics.areEqual(parsedChatMessage.getStatus(), STATUS_IN_PROGRESS) && parsedChatMessage.isHistory()))) {
                    subTaskRenderState = SubTaskRenderState.Done;
                } else if (isTerminalStreamingMessage) {
                    subTaskRenderState = SubTaskRenderState.Failed;
                } else {
                    subTaskRenderState = extractContent.length() > 0 ? SubTaskRenderState.Streaming : SubTaskRenderState.Thinking;
                }
                SubTaskRenderState subTaskRenderState3 = subTaskRenderState;
                if (subTaskRenderState3 == SubTaskRenderState.Failed) {
                    String failureReason = subTaskUiState.getFailureReason();
                    if (failureReason == null) {
                        ParsedError error5 = parsedChatMessage.getError();
                        String num = (error5 == null || (code = error5.getCode()) == null) ? null : code.toString();
                        ParsedError error6 = parsedChatMessage.getError();
                        Integer code3 = error6 != null ? error6.getCode() : null;
                        ParsedError error7 = parsedChatMessage.getError();
                        String message = error7 != null ? error7.getMessage() : null;
                        ParsedError error8 = parsedChatMessage.getError();
                        JsonObject data = error8 != null ? error8.getData() : null;
                        String status2 = parsedChatMessage.getStatus();
                        subTaskRenderState2 = subTaskRenderState3;
                        str2 = TAG;
                        str3 = ", status=";
                        str4 = ", isHistory=";
                        String m858xbacc5332 = m858xbacc5332(voiceSubTaskCoordinator, num, code3, message, data, null, status2, null, 64, null);
                        if (m858xbacc5332 == null) {
                            m858xbacc5332 = "task_failed";
                        }
                        str5 = m858xbacc5332;
                        mutableStateFlow = mutableStateFlow2;
                    } else {
                        subTaskRenderState2 = subTaskRenderState3;
                        str2 = TAG;
                        str3 = ", status=";
                        str4 = ", isHistory=";
                        str5 = failureReason;
                        mutableStateFlow = mutableStateFlow2;
                    }
                } else {
                    subTaskRenderState2 = subTaskRenderState3;
                    mutableStateFlow = mutableStateFlow2;
                    str2 = TAG;
                    str3 = ", status=";
                    str4 = ", isHistory=";
                    str5 = null;
                }
                String str7 = extractContent;
                copy = subTaskUiState.copy((r28 & 1) != 0 ? subTaskUiState.sourceTaskId : null, (r28 & 2) != 0 ? subTaskUiState.taskDescription : null, (r28 & 4) != 0 ? subTaskUiState.localTaskId : null, (r28 & 8) != 0 ? subTaskUiState.proxyConversationId : null, (r28 & 16) != 0 ? subTaskUiState.proxyChatSessionId : null, (r28 & 32) != 0 ? subTaskUiState.state : subTaskRenderState2, (r28 & 64) != 0 ? subTaskUiState.content : str7.length() > 0 ? extractContent : subTaskUiState.getContent(), (r28 & 128) != 0 ? subTaskUiState.failureReason : str5, (r28 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? subTaskUiState.createStartedAtMs : 0L, (r28 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? subTaskUiState.longRunning : false, (r28 & 1024) != 0 ? subTaskUiState.executor : null, (r28 & 2048) != 0 ? subTaskUiState.toolName : null);
                mutableStateFlow.setValue(copy);
                if (isTerminalStreamingMessage) {
                    SubTaskRenderState subTaskRenderState4 = subTaskRenderState2;
                    FLogger.INSTANCE.d(str2, "streamingListener[sse-terminal]: sourceTaskId=" + subTaskUiState.getSourceTaskId() + ", next=" + subTaskRenderState4 + str3 + parsedChatMessage.getStatus() + str4 + parsedChatMessage.isHistory() + ", contentLen=" + (str7.length() > 0 ? extractContent.length() : subTaskUiState.getContent().length()));
                    voiceSubTaskCoordinator.cancelTimer();
                    voiceSubTaskCoordinator.cancelLongRunningJob();
                    long currentTimeMillis = subTaskUiState.getCreateStartedAtMs() > 0 ? System.currentTimeMillis() - subTaskUiState.getCreateStartedAtMs() : 0L;
                    if (subTaskRenderState4 != SubTaskRenderState.Done) {
                        CreateTaskFailureReport buildSseFailureReport$conversation_mainlandRelease$default = buildSseFailureReport$conversation_mainlandRelease$default(voiceSubTaskCoordinator, parsedChatMessage, str5, null, 4, null);
                        reportLocalSubtaskEnd$default(voiceSubTaskCoordinator, subTaskUiState, "failed", str5, null, false, 16, null);
                        voiceSubTaskCoordinator.postSubTaskResultOnceAsync(subTaskUiState.getSourceTaskId(), "failed", str5 == null ? "" : str5, currentTimeMillis, buildSseFailureReport$conversation_mainlandRelease$default.getErrorCode(), buildSseFailureReport$conversation_mainlandRelease$default.getError(), "sse-terminal-failed");
                    } else {
                        reportLocalSubtaskEnd$default(voiceSubTaskCoordinator, subTaskUiState, "success", "", null, false, 16, null);
                        if (!(str7.length() > 0)) {
                            extractContent = subTaskUiState.getContent();
                        }
                        postSubTaskResultOnceAsync$default(voiceSubTaskCoordinator, subTaskUiState.getSourceTaskId(), "success", extractContent, currentTimeMillis, null, null, "sse-terminal-success", 48, null);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void start$default(VoiceSubTaskCoordinator voiceSubTaskCoordinator, ProxyConversationConfig proxyConversationConfig, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        voiceSubTaskCoordinator.start(proxyConversationConfig, function1);
    }

    public final void start(ProxyConversationConfig config2, Function1<? super byte[], Unit> sendAckToBot2) {
        Intrinsics.checkNotNullParameter(config2, "config");
        config = config2;
        sendAckToBot = sendAckToBot2;
        if (!started) {
            started = true;
            deviceOnline = true;
            IMService.INSTANCE.addStreamingMessageListener(streamingListener);
            IMService.INSTANCE.addCliStatusChangeListener(cliStatusListener);
            FLogger.INSTANCE.d(TAG, "start: voiceConvId=" + config2.getVoiceConversationId() + ", parent=" + config2.getParentConversationId() + ", createRemoteParent=" + config2.getCreateRemoteParentSession() + ", parentAgentType=" + config2.getParentAgentType());
        } else {
            FLogger.INSTANCE.d(TAG, "start: re-arm config, voiceConvId=" + config2.getVoiceConversationId());
        }
        MutableStateFlow<String> mutableStateFlow = _parentConversationId;
        String parentConversationId2 = config2.getParentConversationId();
        if (parentConversationId2 == null || !(!StringsKt.isBlank(parentConversationId2))) {
            parentConversationId2 = null;
        }
        mutableStateFlow.setValue(parentConversationId2);
        _parentChatSessionId.setValue((Object) null);
        if (config2.getCliType() == CliType.REMOTE && config2.getCreateRemoteParentSession()) {
            CharSequence charSequence = (CharSequence) mutableStateFlow.getValue();
            if (charSequence == null || charSequence.length() == 0) {
                Job job = parentCreateJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                parentCreateJob = BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VoiceSubTaskCoordinator$start$2(config2, null), 3, (Object) null);
            }
        }
    }

    public final void updateSubTaskConfig(VoiceSubTaskConfig config2) {
        ArrayList arrayList;
        List<JsonObject> models;
        subTaskConfig = config2;
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("updateSubTaskConfig: models=");
        if (config2 == null || (models = config2.getModels()) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = models.iterator();
            while (it.hasNext()) {
                String readStringProperty = INSTANCE.readStringProperty((JsonObject) it.next(), "name");
                if (readStringProperty != null) {
                    arrayList2.add(readStringProperty);
                }
            }
            arrayList = arrayList2;
        }
        fLogger.d(TAG, sb.append(arrayList).toString());
    }

    public final boolean notifyAttachmentsToBot(List<NotifyAttachmentItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (items.isEmpty()) {
            return false;
        }
        if (!started) {
            FLogger.INSTANCE.w(TAG, "notifyAttachmentsToBot: coordinator not started, drop count=" + items.size());
            return false;
        }
        String str = (String) _parentChatSessionId.getValue();
        if (str == null || !(!StringsKt.isBlank(str))) {
            str = null;
        }
        String buildNotifyAttachmentQueryJson$conversation_mainlandRelease = buildNotifyAttachmentQueryJson$conversation_mainlandRelease(items, str);
        FLogger.INSTANCE.d(TAG, "notifyAttachmentsToBot: count=" + items.size() + ", query=" + buildNotifyAttachmentQueryJson$conversation_mainlandRelease);
        return postToBotLLM(buildNotifyAttachmentQueryJson$conversation_mainlandRelease, 2);
    }

    /* renamed from: buildNotifyAttachmentQueryJson$conversation_mainlandRelease$default */
    public static /* synthetic */ String m857x351a73f2(VoiceSubTaskCoordinator voiceSubTaskCoordinator, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return voiceSubTaskCoordinator.buildNotifyAttachmentQueryJson$conversation_mainlandRelease(list, str);
    }

    public final String buildNotifyAttachmentQueryJson$conversation_mainlandRelease(List<NotifyAttachmentItem> items, String chatSessionId) {
        Intrinsics.checkNotNullParameter(items, "items");
        String json = new Gson().toJson(buildNotifyAttachmentParts$conversation_mainlandRelease(items, chatSessionId));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public static /* synthetic */ List buildNotifyAttachmentParts$conversation_mainlandRelease$default(VoiceSubTaskCoordinator voiceSubTaskCoordinator, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return voiceSubTaskCoordinator.buildNotifyAttachmentParts$conversation_mainlandRelease(list, str);
    }

    public final List<QueryItem> buildNotifyAttachmentParts$conversation_mainlandRelease(List<NotifyAttachmentItem> items, String chatSessionId) {
        QueryItem attachment;
        Intrinsics.checkNotNullParameter(items, "items");
        if (chatSessionId == null || !(!StringsKt.isBlank(chatSessionId))) {
            chatSessionId = null;
        }
        List<NotifyAttachmentItem> list = items;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (NotifyAttachmentItem notifyAttachmentItem : list) {
            if (notifyAttachmentItem.getUseImageUpload()) {
                attachment = QueryItem.INSTANCE.imageUri(notifyAttachmentItem.getUploadedRef(), notifyAttachmentItem.getDisplayName(), notifyAttachmentItem.getSizeBytes());
            } else {
                attachment = QueryItem.INSTANCE.attachment(REMOTE_RESOURCE_PREFIX + notifyAttachmentItem.getUploadedRef(), notifyAttachmentItem.getDisplayName(), notifyAttachmentItem.getSizeBytes(), chatSessionId);
            }
            arrayList.add(attachment);
        }
        return arrayList;
    }

    /* compiled from: VoiceSubTaskCoordinator.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$NotifyAttachmentItem;", "", "attachmentId", "", "uploadedRef", "displayName", "useImageUpload", "", "sizeBytes", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJ)V", "getAttachmentId", "()Ljava/lang/String;", "getUploadedRef", "getDisplayName", "getUseImageUpload", "()Z", "getSizeBytes", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class NotifyAttachmentItem {
        private final String attachmentId;
        private final String displayName;
        private final long sizeBytes;
        private final String uploadedRef;
        private final boolean useImageUpload;

        public static /* synthetic */ NotifyAttachmentItem copy$default(NotifyAttachmentItem notifyAttachmentItem, String str, String str2, String str3, boolean z, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = notifyAttachmentItem.attachmentId;
            }
            if ((i & 2) != 0) {
                str2 = notifyAttachmentItem.uploadedRef;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                str3 = notifyAttachmentItem.displayName;
            }
            String str5 = str3;
            if ((i & 8) != 0) {
                z = notifyAttachmentItem.useImageUpload;
            }
            boolean z2 = z;
            if ((i & 16) != 0) {
                j = notifyAttachmentItem.sizeBytes;
            }
            return notifyAttachmentItem.copy(str, str4, str5, z2, j);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAttachmentId() {
            return this.attachmentId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getUploadedRef() {
            return this.uploadedRef;
        }

        /* renamed from: component3, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getUseImageUpload() {
            return this.useImageUpload;
        }

        /* renamed from: component5, reason: from getter */
        public final long getSizeBytes() {
            return this.sizeBytes;
        }

        public final NotifyAttachmentItem copy(String attachmentId, String uploadedRef, String displayName, boolean useImageUpload, long sizeBytes) {
            Intrinsics.checkNotNullParameter(attachmentId, "attachmentId");
            Intrinsics.checkNotNullParameter(uploadedRef, "uploadedRef");
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            return new NotifyAttachmentItem(attachmentId, uploadedRef, displayName, useImageUpload, sizeBytes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotifyAttachmentItem)) {
                return false;
            }
            NotifyAttachmentItem notifyAttachmentItem = (NotifyAttachmentItem) other;
            return Intrinsics.areEqual(this.attachmentId, notifyAttachmentItem.attachmentId) && Intrinsics.areEqual(this.uploadedRef, notifyAttachmentItem.uploadedRef) && Intrinsics.areEqual(this.displayName, notifyAttachmentItem.displayName) && this.useImageUpload == notifyAttachmentItem.useImageUpload && this.sizeBytes == notifyAttachmentItem.sizeBytes;
        }

        public int hashCode() {
            return (((((((this.attachmentId.hashCode() * 31) + this.uploadedRef.hashCode()) * 31) + this.displayName.hashCode()) * 31) + Boolean.hashCode(this.useImageUpload)) * 31) + Long.hashCode(this.sizeBytes);
        }

        public String toString() {
            return "NotifyAttachmentItem(attachmentId=" + this.attachmentId + ", uploadedRef=" + this.uploadedRef + ", displayName=" + this.displayName + ", useImageUpload=" + this.useImageUpload + ", sizeBytes=" + this.sizeBytes + ')';
        }

        public NotifyAttachmentItem(String str, String str2, String str3, boolean z, long j) {
            Intrinsics.checkNotNullParameter(str, "attachmentId");
            Intrinsics.checkNotNullParameter(str2, "uploadedRef");
            Intrinsics.checkNotNullParameter(str3, "displayName");
            this.attachmentId = str;
            this.uploadedRef = str2;
            this.displayName = str3;
            this.useImageUpload = z;
            this.sizeBytes = j;
        }

        public /* synthetic */ NotifyAttachmentItem(String str, String str2, String str3, boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, z, (i & 16) != 0 ? 0L : j);
        }

        public final String getAttachmentId() {
            return this.attachmentId;
        }

        public final String getUploadedRef() {
            return this.uploadedRef;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final boolean getUseImageUpload() {
            return this.useImageUpload;
        }

        public final long getSizeBytes() {
            return this.sizeBytes;
        }
    }

    public final boolean handleSubTaskRequest(SubTaskRequestMessage req, String currentRoomId) {
        Intrinsics.checkNotNullParameter(req, "req");
        SubTaskExecutor fromProtocol = SubTaskExecutor.INSTANCE.fromProtocol(req.getExecutor());
        rememberMetricsRoom(currentRoomId == null ? req.getRoomId() : currentRoomId);
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder append = new StringBuilder("handleSubTaskRequest[enter]: taskId=").append(req.getTaskId()).append(", executor=").append(fromProtocol).append('(').append(req.getExecutor()).append("), descLen=").append(req.getTaskDescription().length()).append(", files=");
        List<QueryItem> files = req.getFiles();
        fLogger.d(TAG, append.append(files != null ? files.size() : 0).append(", room=").append(req.getRoomId()).append(", currentRoom=").append(currentRoomId).append(", timeoutMs=").append(req.getTimeoutMs()).toString());
        if (!started) {
            FLogger.INSTANCE.w(TAG, "handleSubTaskRequest[drop-not-started]: taskId=" + req.getTaskId());
            return false;
        }
        if (currentRoomId != null) {
            if ((currentRoomId.length() > 0) && !Intrinsics.areEqual(req.getRoomId(), currentRoomId)) {
                FLogger.INSTANCE.w(TAG, "handleSubTaskRequest[drop-room-mismatch]: req=" + req.getRoomId() + ", current=" + currentRoomId + ", taskId=" + req.getTaskId());
                return false;
            }
        }
        SubTaskUiState subTaskUiState = (SubTaskUiState) _activeTask.getValue();
        if (subTaskUiState != null && Intrinsics.areEqual(subTaskUiState.getSourceTaskId(), req.getTaskId()) && !IN_FLIGHT_STATES.contains(subTaskUiState.getState())) {
            FLogger.INSTANCE.d(TAG, "handleSubTaskRequest[drop-terminal-arrived]: taskId=" + req.getTaskId() + ", state=" + subTaskUiState.getState());
            return false;
        }
        if (subTaskUiState != null && Intrinsics.areEqual(subTaskUiState.getSourceTaskId(), req.getTaskId())) {
            FLogger.INSTANCE.d(TAG, "handleSubTaskRequest[drop-duplicate]: taskId=" + req.getTaskId());
            return false;
        }
        if (subTaskUiState == null || !IN_FLIGHT_STATES.contains(subTaskUiState.getState())) {
            if (rejectIfPrecheckFailed(req, fromProtocol)) {
                return false;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[fromProtocol.ordinal()];
            if (i == 1) {
                startClientProxyTask(req);
                return true;
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            startServerClosedLoopTask(req);
            return false;
        }
        if (subTaskUiState.getExecutor() == SubTaskExecutor.ClientProxy && fromProtocol == SubTaskExecutor.ClientProxy) {
            if (rejectIfPrecheckFailed(req, fromProtocol)) {
                return false;
            }
            queueSubTaskSupersede$default(this, subTaskUiState, req, fromProtocol, false, 8, null);
            return true;
        }
        FLogger fLogger2 = FLogger.INSTANCE;
        StringBuilder append2 = new StringBuilder("handleSubTaskRequest[drop-busy]: currId=").append(subTaskUiState.getSourceTaskId()).append('(').append(subTaskUiState.getState()).append(", ").append(subTaskUiState.getExecutor()).append("), dropTaskId=").append(req.getTaskId()).append(", dropExecutor=").append(fromProtocol).append(", files=");
        List<QueryItem> files2 = req.getFiles();
        fLogger2.w(TAG, append2.append(files2 != null ? files2.size() : 0).append(", descLen=").append(req.getTaskDescription().length()).append(" → emit local Failed(dropped_busy)").toString());
        if (!_parallelTerminalToolResults.tryEmit(new SubTaskUiState(req.getTaskId(), req.getTaskDescription(), null, null, null, SubTaskRenderState.Failed, null, DROP_REASON_BUSY, 0L, false, fromProtocol, null, 2908, null))) {
            FLogger.INSTANCE.w(TAG, "handleSubTaskRequest[drop-busy]: parallelTerminal buffer overflow, dropped taskId=" + req.getTaskId());
        }
        if (fromProtocol == SubTaskExecutor.ClientProxy) {
            postSubTaskResultOnceAsync$default(this, req.getTaskId(), "failed", "", 0L, DROP_REASON_BUSY, null, "drop-busy", 32, null);
        }
        return false;
    }

    public final boolean handleSubTaskUpdate(SubTaskRequestMessage req, String currentRoomId) {
        Intrinsics.checkNotNullParameter(req, "req");
        SubTaskExecutor fromProtocol = SubTaskExecutor.INSTANCE.fromProtocol(req.getExecutor());
        rememberMetricsRoom(currentRoomId == null ? req.getRoomId() : currentRoomId);
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder append = new StringBuilder("handleSubTaskUpdate[enter]: taskId=").append(req.getTaskId()).append(", executor=").append(fromProtocol).append('(').append(req.getExecutor()).append("), descLen=").append(req.getTaskDescription().length()).append(", files=");
        List<QueryItem> files = req.getFiles();
        fLogger.d(TAG, append.append(files != null ? files.size() : 0).append(", room=").append(req.getRoomId()).append(", currentRoom=").append(currentRoomId).append(", timeoutMs=").append(req.getTimeoutMs()).toString());
        if (!started) {
            FLogger.INSTANCE.w(TAG, "handleSubTaskUpdate[drop-not-started]: taskId=" + req.getTaskId());
            return false;
        }
        if (currentRoomId != null) {
            if ((currentRoomId.length() > 0) && !Intrinsics.areEqual(req.getRoomId(), currentRoomId)) {
                FLogger.INSTANCE.w(TAG, "handleSubTaskUpdate[drop-room-mismatch]: req=" + req.getRoomId() + ", current=" + currentRoomId + ", taskId=" + req.getTaskId());
                return false;
            }
        }
        SubTaskUiState subTaskUiState = (SubTaskUiState) _activeTask.getValue();
        if (cancelingClientProxyTaskId != null && pendingClientProxyRequest != null) {
            if (Intrinsics.areEqual(subTaskUiState != null ? subTaskUiState.getSourceTaskId() : null, req.getTaskId())) {
                FLogger.INSTANCE.d(TAG, "handleSubTaskUpdate[drop-same-pending]: taskId=" + req.getTaskId() + ", state=" + subTaskUiState.getState());
                return false;
            }
            if (rejectIfPrecheckFailed(req, fromProtocol)) {
                return false;
            }
            replaceSwitchingPending(subTaskUiState, req, fromProtocol);
            return fromProtocol == SubTaskExecutor.ClientProxy;
        }
        if (subTaskUiState != null && Intrinsics.areEqual(subTaskUiState.getSourceTaskId(), req.getTaskId())) {
            FLogger.INSTANCE.d(TAG, "handleSubTaskUpdate[drop-same-taskId]: taskId=" + req.getTaskId() + ", state=" + subTaskUiState.getState() + ", executor=" + subTaskUiState.getExecutor());
            return false;
        }
        if (rejectIfPrecheckFailed(req, fromProtocol)) {
            return false;
        }
        if (subTaskUiState != null && IN_FLIGHT_STATES.contains(subTaskUiState.getState())) {
            if (subTaskUiState.getExecutor() == SubTaskExecutor.ClientProxy && fromProtocol == SubTaskExecutor.ClientProxy) {
                FLogger.INSTANCE.w(TAG, "handleSubTaskUpdate[queue-client-supersede]: prevId=" + subTaskUiState.getSourceTaskId() + '(' + subTaskUiState.getState() + "), newId=" + req.getTaskId());
                queueSubTaskSupersede(subTaskUiState, req, fromProtocol, true);
                return true;
            }
            FLogger.INSTANCE.w(TAG, "handleSubTaskUpdate[supersede]: cancel prevId=" + subTaskUiState.getSourceTaskId() + '(' + subTaskUiState.getState() + ", " + subTaskUiState.getExecutor() + "), newId=" + req.getTaskId());
            if (subTaskUiState.getExecutor() == SubTaskExecutor.ClientProxy) {
                queueSubTaskSupersede(subTaskUiState, req, fromProtocol, true);
                return fromProtocol == SubTaskExecutor.ClientProxy;
            }
            cancelActiveTask$default(this, "task_update_supersede", false, 2, null);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[fromProtocol.ordinal()];
        if (i == 1) {
            markCreateTaskRetryableBizErrorSuppressed(req.getTaskId());
            startClientProxyTask(req);
            return true;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        startServerClosedLoopTask(req);
        return false;
    }

    private final boolean rejectIfPrecheckFailed(SubTaskRequestMessage req, SubTaskExecutor executor) {
        String evaluatePrechecks;
        if (executor != SubTaskExecutor.ClientProxy || (evaluatePrechecks = evaluatePrechecks()) == null) {
            return false;
        }
        FLogger.INSTANCE.w(TAG, "precheck-reject: taskId=" + req.getTaskId() + ", executor=" + executor + ", code=" + evaluatePrechecks);
        postSubTaskResultOnceAsync$default(this, req.getTaskId(), "failed", "", 0L, evaluatePrechecks, null, "precheck-reject", 32, null);
        return true;
    }

    private final String evaluatePrechecks() {
        ProxyConversationConfig proxyConversationConfig = config;
        if (proxyConversationConfig == null || proxyConversationConfig.getCliType() != CliType.LOCAL) {
            return null;
        }
        String cliId = proxyConversationConfig.getCliId();
        if ((cliId == null || cliId.length() == 0) || deviceOnline) {
            return null;
        }
        return SubTaskErrorCode.DEVICE_OFFLINE;
    }

    static /* synthetic */ void queueSubTaskSupersede$default(VoiceSubTaskCoordinator voiceSubTaskCoordinator, SubTaskUiState subTaskUiState, SubTaskRequestMessage subTaskRequestMessage, SubTaskExecutor subTaskExecutor, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        voiceSubTaskCoordinator.queueSubTaskSupersede(subTaskUiState, subTaskRequestMessage, subTaskExecutor, z);
    }

    private final void queueSubTaskSupersede(SubTaskUiState current, SubTaskRequestMessage req, SubTaskExecutor executor, boolean silentForServer) {
        SubTaskUiState copy;
        SubTaskUiState subTaskUiState;
        SubTaskUiState copy2;
        SubTaskRequestMessage subTaskRequestMessage = pendingClientProxyRequest;
        if (cancelingClientProxyTaskId != null && subTaskRequestMessage != null && Intrinsics.areEqual(current.getSourceTaskId(), subTaskRequestMessage.getTaskId()) && current.getLocalTaskId() == null && current.getCreateStartedAtMs() == 0) {
            FLogger.INSTANCE.w(TAG, "switching[replace-pending]: canceling=" + cancelingClientProxyTaskId + ", oldPending=" + subTaskRequestMessage.getTaskId() + ", newPending=" + req.getTaskId() + ", executor=" + executor + ", silent=" + silentForServer);
            copy2 = current.copy((r28 & 1) != 0 ? current.sourceTaskId : null, (r28 & 2) != 0 ? current.taskDescription : null, (r28 & 4) != 0 ? current.localTaskId : null, (r28 & 8) != 0 ? current.proxyConversationId : null, (r28 & 16) != 0 ? current.proxyChatSessionId : null, (r28 & 32) != 0 ? current.state : SubTaskRenderState.Failed, (r28 & 64) != 0 ? current.content : null, (r28 & 128) != 0 ? current.failureReason : SUB_TASK_FAILURE_REASON_INTERRUPTED, (r28 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? current.createStartedAtMs : 0L, (r28 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? current.longRunning : false, (r28 & 1024) != 0 ? current.executor : null, (r28 & 2048) != 0 ? current.toolName : null);
            emitParallelTerminal(copy2, "replace-pending");
            reportLocalSubtaskEnd$default(this, current, "failed", SUB_TASK_FAILURE_REASON_INTERRUPTED, null, false, 16, null);
            if (silentForServer) {
                registerUpdateChainAlias(current.getSourceTaskId(), req.getTaskId(), "replace-pending");
            } else {
                reportClientProxyFailureOnce(current, SUB_TASK_FAILURE_REASON_INTERRUPTED, "replace-pending");
            }
            pendingClientProxyRequest = req;
            pendingClientProxyExecutor = executor;
            showPendingTask(req, executor);
            return;
        }
        String sourceTaskId = current.getSourceTaskId();
        Job job = taskCreateJob;
        pendingClientProxyRequest = req;
        pendingClientProxyExecutor = executor;
        cancelingClientProxyTaskId = sourceTaskId;
        FLogger.INSTANCE.w(TAG, "switching[start]: prevId=" + sourceTaskId + '(' + current.getState() + ", " + current.getExecutor() + "), localTaskId=" + current.getLocalTaskId() + ", newId=" + req.getTaskId() + ", newExecutor=" + executor + ", silent=" + silentForServer);
        cancelTimer();
        copy = current.copy((r28 & 1) != 0 ? current.sourceTaskId : null, (r28 & 2) != 0 ? current.taskDescription : null, (r28 & 4) != 0 ? current.localTaskId : null, (r28 & 8) != 0 ? current.proxyConversationId : null, (r28 & 16) != 0 ? current.proxyChatSessionId : null, (r28 & 32) != 0 ? current.state : SubTaskRenderState.Failed, (r28 & 64) != 0 ? current.content : null, (r28 & 128) != 0 ? current.failureReason : SUB_TASK_FAILURE_REASON_INTERRUPTED, (r28 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? current.createStartedAtMs : 0L, (r28 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? current.longRunning : false, (r28 & 1024) != 0 ? current.executor : null, (r28 & 2048) != 0 ? current.toolName : null);
        emitParallelTerminal(copy, "cancel-previous");
        reportLocalSubtaskEnd$default(this, current, "failed", SUB_TASK_FAILURE_REASON_INTERRUPTED, null, false, 16, null);
        if (silentForServer) {
            registerUpdateChainAlias(sourceTaskId, req.getTaskId(), "cancel-previous");
            subTaskUiState = current;
        } else {
            subTaskUiState = current;
            reportClientProxyFailureOnce(subTaskUiState, SUB_TASK_FAILURE_REASON_INTERRUPTED, "cancel-previous");
        }
        showPendingTask(req, executor);
        Job job2 = pendingClientProxyStartJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        pendingClientProxyStartJob = BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VoiceSubTaskCoordinator$queueSubTaskSupersede$1(subTaskUiState, job, sourceTaskId, null), 3, (Object) null);
    }

    private final void replaceSwitchingPending(SubTaskUiState current, SubTaskRequestMessage req, SubTaskExecutor executor) {
        String str;
        String taskId;
        SubTaskUiState copy;
        SubTaskRequestMessage subTaskRequestMessage = pendingClientProxyRequest;
        FLogger.INSTANCE.w(TAG, "switching[replace-pending-active]: canceling=" + cancelingClientProxyTaskId + ", oldPending=" + (subTaskRequestMessage != null ? subTaskRequestMessage.getTaskId() : null) + ", newPending=" + req.getTaskId() + ", executor=" + executor);
        if (current != null) {
            VoiceSubTaskCoordinator voiceSubTaskCoordinator = INSTANCE;
            copy = current.copy((r28 & 1) != 0 ? current.sourceTaskId : null, (r28 & 2) != 0 ? current.taskDescription : null, (r28 & 4) != 0 ? current.localTaskId : null, (r28 & 8) != 0 ? current.proxyConversationId : null, (r28 & 16) != 0 ? current.proxyChatSessionId : null, (r28 & 32) != 0 ? current.state : SubTaskRenderState.Failed, (r28 & 64) != 0 ? current.content : null, (r28 & 128) != 0 ? current.failureReason : SUB_TASK_FAILURE_REASON_INTERRUPTED, (r28 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? current.createStartedAtMs : 0L, (r28 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? current.longRunning : false, (r28 & 1024) != 0 ? current.executor : null, (r28 & 2048) != 0 ? current.toolName : null);
            str = "replace-pending-active";
            voiceSubTaskCoordinator.emitParallelTerminal(copy, str);
        } else {
            str = "replace-pending-active";
        }
        if (current == null || (taskId = current.getSourceTaskId()) == null) {
            taskId = subTaskRequestMessage != null ? subTaskRequestMessage.getTaskId() : null;
        }
        if (taskId != null) {
            registerUpdateChainAlias(taskId, req.getTaskId(), str);
        }
        pendingClientProxyRequest = req;
        pendingClientProxyExecutor = executor;
        showPendingTask(req, executor);
    }

    private final void showPendingTask(SubTaskRequestMessage req, SubTaskExecutor executor) {
        String str = (String) _proxyConversationId.getValue();
        String str2 = (String) _proxyChatSessionId.getValue();
        _activeTask.setValue(new SubTaskUiState(req.getTaskId(), req.getTaskDescription(), null, executor == SubTaskExecutor.ClientProxy ? str : null, executor == SubTaskExecutor.ClientProxy ? str2 : null, SubTaskRenderState.Creating, null, null, 0L, false, executor, null, 3012, null));
        startLongRunningJob(req.getTaskId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void failPendingClientProxyTask(String sourceTaskId, String reason) {
        SubTaskUiState copy;
        MutableStateFlow<SubTaskUiState> mutableStateFlow = _activeTask;
        SubTaskUiState subTaskUiState = (SubTaskUiState) mutableStateFlow.getValue();
        if (subTaskUiState != null && Intrinsics.areEqual(subTaskUiState.getSourceTaskId(), sourceTaskId)) {
            Long valueOf = Long.valueOf(subTaskUiState.getCreateStartedAtMs());
            if (!(valueOf.longValue() > 0)) {
                valueOf = null;
            }
            long coerceAtLeast = valueOf != null ? RangesKt.coerceAtLeast(System.currentTimeMillis() - valueOf.longValue(), 0L) : 0L;
            cancelLongRunningJob();
            copy = subTaskUiState.copy((r28 & 1) != 0 ? subTaskUiState.sourceTaskId : null, (r28 & 2) != 0 ? subTaskUiState.taskDescription : null, (r28 & 4) != 0 ? subTaskUiState.localTaskId : null, (r28 & 8) != 0 ? subTaskUiState.proxyConversationId : null, (r28 & 16) != 0 ? subTaskUiState.proxyChatSessionId : null, (r28 & 32) != 0 ? subTaskUiState.state : SubTaskRenderState.Failed, (r28 & 64) != 0 ? subTaskUiState.content : null, (r28 & 128) != 0 ? subTaskUiState.failureReason : reason, (r28 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? subTaskUiState.createStartedAtMs : 0L, (r28 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? subTaskUiState.longRunning : false, (r28 & 1024) != 0 ? subTaskUiState.executor : null, (r28 & 2048) != 0 ? subTaskUiState.toolName : null);
            mutableStateFlow.setValue(copy);
            if (subTaskUiState.getExecutor() == SubTaskExecutor.ClientProxy) {
                reportLocalSubtaskEnd$default(this, subTaskUiState, "failed", reason, null, false, 16, null);
                postSubTaskResultOnceAsync$default(this, sourceTaskId, "failed", "", coerceAtLeast, reason, null, "fail-pending-client-proxy", 32, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cancelPreviousTaskForSwitch(SubTaskUiState subTaskUiState, Job job, Continuation<? super CancelOutcome> continuation) {
        VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1 voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1;
        int i;
        if (continuation instanceof VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1) {
            voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1 = (VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1) continuation;
            if ((voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1.label & Integer.MIN_VALUE) != 0) {
                voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1.label -= Integer.MIN_VALUE;
                VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1 voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$12 = voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1;
                Object obj = voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$12.label;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return CancelOutcome.RemoteAccepted.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                if (subTaskUiState.getExecutor() != SubTaskExecutor.ClientProxy) {
                    FLogger.INSTANCE.d(TAG, "cancelForReuse[local-only]: sourceTaskId=" + subTaskUiState.getSourceTaskId() + ", executor=" + subTaskUiState.getExecutor());
                    return CancelOutcome.LocalOnly.INSTANCE;
                }
                String proxyConversationId2 = subTaskUiState.getProxyConversationId();
                String localTaskId = subTaskUiState.getLocalTaskId();
                String str = proxyConversationId2;
                if (!(str == null || str.length() == 0)) {
                    String str2 = localTaskId;
                    if (!(str2 == null || str2.length() == 0)) {
                        String sourceTaskId = subTaskUiState.getSourceTaskId();
                        voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$12.label = 1;
                        obj = cancelClientProxyTaskForReuse$default(this, proxyConversationId2, localTaskId, sourceTaskId, SUB_TASK_FAILURE_REASON_INTERRUPTED, 0L, voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$12, 16, null);
                        return obj == coroutine_suspended ? coroutine_suspended : obj;
                    }
                }
                if (job != null && job.isActive()) {
                    FLogger.INSTANCE.d(TAG, "cancelForReuse[wait-create]: sourceTaskId=" + subTaskUiState.getSourceTaskId());
                    voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$12.label = 2;
                    if (job.join(voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return CancelOutcome.RemoteAccepted.INSTANCE;
                }
                FLogger.INSTANCE.d(TAG, "cancelForReuse[no-local-task]: sourceTaskId=" + subTaskUiState.getSourceTaskId());
                return CancelOutcome.LocalOnly.INSTANCE;
            }
        }
        voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1 = new VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1(this, continuation);
        VoiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1 voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$122 = voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$1;
        Object obj2 = voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = voiceSubTaskCoordinator$cancelPreviousTaskForSwitch$122.label;
        if (i == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cancelClientProxyTaskForReuse(String str, String str2, String str3, String str4, long j, Continuation<? super CancelOutcome> continuation) {
        VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1 voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1;
        int i;
        VoiceSubTaskCoordinator voiceSubTaskCoordinator;
        String str5;
        String str6;
        long j2;
        String str7;
        CompletableDeferred<CancelOutcome> completableDeferred;
        HttpDataResult.Success success;
        if (continuation instanceof VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1) {
            voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1 = (VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1) continuation;
            if ((voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.label & Integer.MIN_VALUE) != 0) {
                voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.label -= Integer.MIN_VALUE;
                Object obj = voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    FLogger.INSTANCE.d(TAG, "cancelForReuse[start]: sourceTaskId=" + str3 + ", localTaskId=" + str2 + ", reason=" + str4);
                    CompletableDeferred<CancelOutcome> registerCancelWaiter = registerCancelWaiter(str2, str3);
                    CoroutineContext coroutineContext = NonCancellable.INSTANCE;
                    VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$result$1 voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$result$1 = new VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$result$1(str, str2, null);
                    voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$0 = this;
                    voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$1 = str2;
                    voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$2 = str3;
                    voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$3 = str4;
                    voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$4 = registerCancelWaiter;
                    voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.J$0 = j;
                    voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.label = 1;
                    Object withContext = BuildersKt.withContext(coroutineContext, voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$result$1, voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1);
                    if (withContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    voiceSubTaskCoordinator = this;
                    str5 = str2;
                    str6 = str3;
                    j2 = j;
                    str7 = str4;
                    completableDeferred = registerCancelWaiter;
                    obj = withContext;
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j2 = voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.J$0;
                    completableDeferred = (CompletableDeferred) voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$4;
                    str7 = (String) voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$3;
                    str6 = (String) voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$2;
                    str5 = (String) voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$1;
                    voiceSubTaskCoordinator = (VoiceSubTaskCoordinator) voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if (!(success instanceof HttpDataResult.Success)) {
                    String str8 = str6;
                    FLogger.INSTANCE.d(TAG, "cancelForReuse[api-success]: sourceTaskId=" + str6 + ", localTaskId=" + str5 + ", bizCode=" + success.getBizResp().getCode() + ", reason=" + str7);
                    if (j2 <= 0) {
                        voiceSubTaskCoordinator.clearCancelWaiter(str5);
                        return CancelOutcome.RemoteAccepted.INSTANCE;
                    }
                    voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$0 = null;
                    voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$1 = null;
                    voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$2 = null;
                    voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$3 = null;
                    voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.L$4 = null;
                    voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.label = 2;
                    obj = voiceSubTaskCoordinator.awaitCancelRemoteTerminal(completableDeferred, str5, str8, j2, voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1);
                    return obj == coroutine_suspended ? coroutine_suspended : obj;
                }
                String str9 = str6;
                if (!(success instanceof HttpDataResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                voiceSubTaskCoordinator.clearCancelWaiter(str5);
                HttpDataResult.Error error = (HttpDataResult.Error) success;
                FLogger.INSTANCE.w(TAG, "cancelForReuse[api-failed]: sourceTaskId=" + str9 + ", localTaskId=" + str5 + ", code=" + error.getCode() + ", msg=" + error.getMsg() + ", reason=" + str7, error.getThrowable());
                String msg = error.getMsg();
                if (msg.length() == 0) {
                    msg = "cancel_api_failed";
                }
                return new CancelOutcome.Failed(msg);
            }
        }
        voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1 = new VoiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1(this, continuation);
        Object obj2 = voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = voiceSubTaskCoordinator$cancelClientProxyTaskForReuse$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (!(success instanceof HttpDataResult.Success)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object cancelClientProxyTaskForReuse$default(VoiceSubTaskCoordinator voiceSubTaskCoordinator, String str, String str2, String str3, String str4, long j, Continuation continuation, int i, Object obj) {
        return voiceSubTaskCoordinator.cancelClientProxyTaskForReuse(str, str2, str3, str4, (i & 16) != 0 ? 15000L : j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(8:5|6|(1:(4:9|10|11|12)(2:35|36))(4:37|38|39|(1:41)(1:42))|13|14|15|16|(2:18|19)(2:21|22)))|46|6|(0)(0)|13|14|15|16|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00af, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x014d, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitCancelRemoteTerminal(CompletableDeferred<CancelOutcome> completableDeferred, String str, String str2, long j, Continuation<? super CancelOutcome> continuation) {
        VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1 voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;
        int i;
        CancelOutcome cancelOutcome;
        long currentTimeMillis;
        VoiceSubTaskCoordinator voiceSubTaskCoordinator;
        Job job;
        String str3 = str;
        String str4 = str2;
        long j2 = j;
        if (continuation instanceof VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1) {
            voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1 = (VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1) continuation;
            if ((voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.label & Integer.MIN_VALUE) != 0) {
                voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.label -= Integer.MIN_VALUE;
                Object obj = voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.label;
                cancelOutcome = null;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    FLogger.INSTANCE.w(TAG, "cancelForReuse[await-terminal]: sourceTaskId=" + str4 + ", localTaskId=" + str3 + ", waitMs=" + j2);
                    currentTimeMillis = System.currentTimeMillis();
                    try {
                        VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$terminal$1 voiceSubTaskCoordinator$awaitCancelRemoteTerminal$terminal$1 = new VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$terminal$1(completableDeferred, null);
                        voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.L$0 = this;
                        voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.L$1 = str3;
                        voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.L$2 = str4;
                        voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.J$0 = j2;
                        voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.J$1 = currentTimeMillis;
                        voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.label = 1;
                        obj = TimeoutKt.withTimeoutOrNull(j2, voiceSubTaskCoordinator$awaitCancelRemoteTerminal$terminal$1, voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        voiceSubTaskCoordinator = this;
                    } catch (CancellationException e) {
                        e = e;
                        voiceSubTaskCoordinator = this;
                        job = voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.getContext().get(Job.Key);
                        if (job != null) {
                        }
                        z = false;
                        if (!z) {
                        }
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (cancelOutcome != null) {
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j3 = voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.J$1;
                    j2 = voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.J$0;
                    String str5 = (String) voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.L$2;
                    String str6 = (String) voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.L$1;
                    VoiceSubTaskCoordinator voiceSubTaskCoordinator2 = (VoiceSubTaskCoordinator) voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        str4 = str5;
                        str3 = str6;
                        voiceSubTaskCoordinator = voiceSubTaskCoordinator2;
                        currentTimeMillis = j3;
                    } catch (CancellationException e2) {
                        e = e2;
                        str4 = str5;
                        str3 = str6;
                        voiceSubTaskCoordinator = voiceSubTaskCoordinator2;
                        currentTimeMillis = j3;
                        job = voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.getContext().get(Job.Key);
                        if (job != null) {
                        }
                        z = false;
                        if (!z) {
                        }
                        long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                        if (cancelOutcome != null) {
                        }
                    }
                }
                cancelOutcome = (CancelOutcome) obj;
                long currentTimeMillis222 = System.currentTimeMillis() - currentTimeMillis;
                if (cancelOutcome != null) {
                    FLogger.INSTANCE.w(TAG, "cancelForReuse[await-terminal-done]: sourceTaskId=" + str4 + ", localTaskId=" + str3 + ", elapsedMs=" + currentTimeMillis222 + ", outcome=" + cancelOutcome.getClass().getSimpleName());
                    return CancelOutcome.RemoteTerminalObserved.INSTANCE;
                }
                voiceSubTaskCoordinator.clearCancelWaiter(str3);
                FLogger.INSTANCE.w(TAG, "cancelForReuse[await-terminal-timeout]: sourceTaskId=" + str4 + ", localTaskId=" + str3 + ", elapsedMs=" + currentTimeMillis222 + ", waitMs=" + j2 + ", proceed with create-retry fallback");
                return CancelOutcome.RemoteAccepted.INSTANCE;
            }
        }
        voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1 = new VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1(this, continuation);
        Object obj2 = voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = voiceSubTaskCoordinator$awaitCancelRemoteTerminal$1.label;
        cancelOutcome = null;
        boolean z2 = true;
        if (i != 0) {
        }
        cancelOutcome = (CancelOutcome) obj2;
        long currentTimeMillis2222 = System.currentTimeMillis() - currentTimeMillis;
        if (cancelOutcome != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cancelRemoteClientProxyTask(String str, String str2, String str3, Continuation<? super Boolean> continuation) {
        VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1 voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1;
        int i;
        HttpDataResult.Success success;
        if (continuation instanceof VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1) {
            voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1 = (VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1) continuation;
            if ((voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1.label & Integer.MIN_VALUE) != 0) {
                voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1.label -= Integer.MIN_VALUE;
                Object obj = voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1.label;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    FLogger.INSTANCE.d(TAG, "cancelRemoteClientProxyTask: localTaskId=" + str2 + ", reason=" + str3);
                    ICancelTaskApi.Companion companion = ICancelTaskApi.INSTANCE;
                    VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$result$1 voiceSubTaskCoordinator$cancelRemoteClientProxyTask$result$1 = new VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$result$1(str, str2, null);
                    voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1.L$0 = str2;
                    voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1.L$1 = str3;
                    voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1.label = 1;
                    obj = companion.safeCall(voiceSubTaskCoordinator$cancelRemoteClientProxyTask$result$1, voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str3 = (String) voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1.L$1;
                    str2 = (String) voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if (!(success instanceof HttpDataResult.Success)) {
                    FLogger.INSTANCE.d(TAG, "cancelRemoteClientProxyTask: ok localTaskId=" + str2 + ", bizCode=" + success.getBizResp().getCode() + ", reason=" + str3);
                } else {
                    if (!(success instanceof HttpDataResult.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    HttpDataResult.Error error = (HttpDataResult.Error) success;
                    FLogger.INSTANCE.w(TAG, "cancelRemoteClientProxyTask: failed localTaskId=" + str2 + ", code=" + error.getCode() + ", msg=" + error.getMsg() + ", reason=" + str3, error.getThrowable());
                    z = false;
                }
                return Boxing.boxBoolean(z);
            }
        }
        voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1 = new VoiceSubTaskCoordinator$cancelRemoteClientProxyTask$1(this, continuation);
        Object obj2 = voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = voiceSubTaskCoordinator$cancelRemoteClientProxyTask$1.label;
        boolean z2 = true;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (!(success instanceof HttpDataResult.Success)) {
        }
        return Boxing.boxBoolean(z2);
    }

    private final boolean isTerminalStreamingMessage(ParsedChatMessage message) {
        return CollectionsKt.contains(COMPLETED_STATUSES, message.getStatus()) || (Intrinsics.areEqual(message.getStatus(), STATUS_IN_PROGRESS) && message.isHistory());
    }

    static /* synthetic */ CompletableDeferred registerCancelWaiter$default(VoiceSubTaskCoordinator voiceSubTaskCoordinator, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return voiceSubTaskCoordinator.registerCancelWaiter(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015 A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:11:0x0015, B:12:0x001a, B:14:0x0022, B:15:0x002a), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0022 A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:11:0x0015, B:12:0x001a, B:14:0x0022, B:15:0x002a), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final CompletableDeferred<CancelOutcome> registerCancelWaiter(String localTaskId, String sourceTaskId) {
        boolean z;
        CompletableDeferred<CancelOutcome> completableDeferred;
        CompletableDeferred<CancelOutcome> completableDeferred2;
        synchronized (cancelWaiterLock) {
            String str = sourceTaskId;
            if (str != null && str.length() != 0) {
                z = false;
                if (!z) {
                    cancelWaiterSourceToLocal.put(sourceTaskId, localTaskId);
                }
                Map<String, CompletableDeferred<CancelOutcome>> map = cancelWaiters;
                completableDeferred = map.get(localTaskId);
                if (completableDeferred == null) {
                    completableDeferred = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
                    map.put(localTaskId, completableDeferred);
                }
                completableDeferred2 = completableDeferred;
            }
            z = true;
            if (!z) {
            }
            Map<String, CompletableDeferred<CancelOutcome>> map2 = cancelWaiters;
            completableDeferred = map2.get(localTaskId);
            if (completableDeferred == null) {
            }
            completableDeferred2 = completableDeferred;
        }
        return completableDeferred2;
    }

    private final boolean hasCancelWaiter(String localTaskId) {
        boolean containsKey;
        synchronized (cancelWaiterLock) {
            containsKey = cancelWaiters.containsKey(localTaskId);
        }
        return containsKey;
    }

    private final void completeCancelWaiterIfNeeded(String localTaskId, String status, boolean isHistory, Integer errorCode, String errorMessage) {
        CompletableDeferred<CancelOutcome> removeCancelWaiterLocked = removeCancelWaiterLocked(localTaskId);
        if (removeCancelWaiterLocked == null) {
            return;
        }
        FLogger.INSTANCE.w(TAG, "cancelForReuse[remote-terminal]: localTaskId=" + localTaskId + ", status=" + status + ", isHistory=" + isHistory + ", errorCode=" + errorCode + ", errorMsg=" + errorMessage);
        removeCancelWaiterLocked.complete(CancelOutcome.RemoteTerminalObserved.INSTANCE);
    }

    private final void completeCancelWaiterBySourceTaskId(String sourceTaskId, String status) {
        synchronized (cancelWaiterLock) {
            String str = cancelWaiterSourceToLocal.get(sourceTaskId);
            if (str == null) {
                return;
            }
            Pair pair = TuplesKt.to(str, INSTANCE.removeCancelWaiterInternal(str));
            String str2 = (String) pair.component1();
            CompletableDeferred completableDeferred = (CompletableDeferred) pair.component2();
            if (completableDeferred == null) {
                return;
            }
            FLogger.INSTANCE.w(TAG, "cancelForReuse[task-result-terminal]: sourceTaskId=" + sourceTaskId + ", localTaskId=" + str2 + ", status=" + status);
            completableDeferred.complete(CancelOutcome.RemoteTerminalObserved.INSTANCE);
        }
    }

    private final void clearCancelWaiter(String localTaskId) {
        Job removeCancelWaiterLocked = removeCancelWaiterLocked(localTaskId);
        if (removeCancelWaiterLocked != null) {
            FLogger.INSTANCE.w(TAG, "cancelForReuse[clear-waiter]: localTaskId=" + localTaskId);
            Job.DefaultImpls.cancel$default(removeCancelWaiterLocked, (CancellationException) null, 1, (Object) null);
        }
    }

    private final CompletableDeferred<CancelOutcome> removeCancelWaiterLocked(String localTaskId) {
        CompletableDeferred<CancelOutcome> removeCancelWaiterInternal;
        synchronized (cancelWaiterLock) {
            removeCancelWaiterInternal = INSTANCE.removeCancelWaiterInternal(localTaskId);
        }
        return removeCancelWaiterInternal;
    }

    private final CompletableDeferred<CancelOutcome> removeCancelWaiterInternal(final String localTaskId) {
        CollectionsKt.removeAll(cancelWaiterSourceToLocal.entrySet(), new Function1() { // from class: com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                boolean removeCancelWaiterInternal$lambda$16;
                removeCancelWaiterInternal$lambda$16 = VoiceSubTaskCoordinator.removeCancelWaiterInternal$lambda$16(localTaskId, (Map.Entry) obj);
                return Boolean.valueOf(removeCancelWaiterInternal$lambda$16);
            }
        });
        return cancelWaiters.remove(localTaskId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeCancelWaiterInternal$lambda$16(String str, Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "it");
        return Intrinsics.areEqual(entry.getValue(), str);
    }

    private final void emitParallelTerminal(SubTaskUiState ui, String scene) {
        if (_parallelTerminalToolResults.tryEmit(ui)) {
            return;
        }
        FLogger.INSTANCE.w(TAG, "emitParallelTerminal[" + scene + "]: buffer overflow, taskId=" + ui.getSourceTaskId() + ", state=" + ui.getState());
    }

    private final void registerUpdateChainAlias(String previousTaskId, String newTaskId, String scene) {
        String remove;
        synchronized (resultAliasLock) {
            Map<String, String> map = resultTaskIdAlias;
            remove = map.remove(previousTaskId);
            if (remove == null) {
                remove = previousTaskId;
            }
            map.put(newTaskId, remove);
        }
        FLogger.INSTANCE.w(TAG, "updateChain[" + scene + "]: newTaskId=" + newTaskId + " reportAs=" + remove + ", prevId=" + previousTaskId + " silent");
    }

    private final String resolveReportTaskId(String taskId) {
        synchronized (resultAliasLock) {
            String str = resultTaskIdAlias.get(taskId);
            if (str != null) {
                taskId = str;
            }
        }
        return taskId;
    }

    private final void reportClientProxyFailureOnce(SubTaskUiState ui, String reason, String scene) {
        if (ui.getExecutor() != SubTaskExecutor.ClientProxy) {
            return;
        }
        Long valueOf = Long.valueOf(ui.getCreateStartedAtMs());
        if (!(valueOf.longValue() > 0)) {
            valueOf = null;
        }
        long coerceAtLeast = valueOf != null ? RangesKt.coerceAtLeast(System.currentTimeMillis() - valueOf.longValue(), 0L) : 0L;
        reportLocalSubtaskEnd$default(this, ui, "failed", reason, null, false, 16, null);
        postSubTaskResultOnceAsync$default(this, ui.getSourceTaskId(), "failed", Intrinsics.areEqual(reason, SUB_TASK_FAILURE_REASON_INTERRUPTED) ? SUPERSEDED_RESULT_NOTE : "", coerceAtLeast, reason, null, scene, 32, null);
    }

    private final void rememberMetricsRoom(String roomId) {
        String str = roomId;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        latestRoomIdForMetrics = roomId;
    }

    private final void reportLocalSubtaskStart(SubTaskRequestMessage req) {
        ProxyConversationConfig proxyConversationConfig = config;
        if (proxyConversationConfig == null) {
            return;
        }
        String taskId = req.getTaskId();
        if (!(!StringsKt.isBlank(taskId))) {
            taskId = null;
        }
        String str = taskId;
        if (str == null) {
            return;
        }
        subTaskMetricStartedAtMs.put(str, Long.valueOf(System.currentTimeMillis()));
        ConcurrentHashMap<String, Integer> concurrentHashMap = subTaskMetricFileCounts;
        List<QueryItem> files = req.getFiles();
        concurrentHashMap.put(str, Integer.valueOf(files != null ? files.size() : 0));
        subTaskMetricEndedTaskIds.remove(str);
        VoiceDiscussionMetrics voiceDiscussionMetrics = VoiceDiscussionMetrics.INSTANCE;
        CliType cliType = proxyConversationConfig.getCliType();
        Mode mode = proxyConversationConfig.getMode();
        String voiceConversationId = proxyConversationConfig.getVoiceConversationId();
        String str2 = latestRoomIdForMetrics;
        if (str2 == null) {
            str2 = req.getRoomId();
        }
        String str3 = str2;
        String taskDescription = req.getTaskDescription();
        List<QueryItem> files2 = req.getFiles();
        voiceDiscussionMetrics.reportSubtaskStart(cliType, mode, voiceConversationId, str3, str, taskDescription, files2 != null ? files2.size() : 0);
    }

    static /* synthetic */ void reportLocalSubtaskEnd$default(VoiceSubTaskCoordinator voiceSubTaskCoordinator, SubTaskUiState subTaskUiState, String str, String str2, Long l, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        voiceSubTaskCoordinator.reportLocalSubtaskEnd(subTaskUiState, str, str2, l, z);
    }

    private final void reportLocalSubtaskEnd(SubTaskUiState ui, String status, String failureReason, Long durationMs, boolean isCancelled) {
        ProxyConversationConfig proxyConversationConfig;
        long longValue;
        if (ui.getExecutor() == SubTaskExecutor.ClientProxy && (proxyConversationConfig = config) != null && subTaskMetricEndedTaskIds.putIfAbsent(ui.getSourceTaskId(), true) == null) {
            Long remove = subTaskMetricStartedAtMs.remove(ui.getSourceTaskId());
            Integer remove2 = subTaskMetricFileCounts.remove(ui.getSourceTaskId());
            int intValue = remove2 != null ? remove2.intValue() : 0;
            if (remove == null && ui.getCreateStartedAtMs() <= 0 && durationMs == null) {
                return;
            }
            if (durationMs != null) {
                longValue = durationMs.longValue();
            } else {
                Long valueOf = remove != null ? Long.valueOf(RangesKt.coerceAtLeast(System.currentTimeMillis() - remove.longValue(), 0L)) : null;
                longValue = valueOf != null ? valueOf.longValue() : RangesKt.coerceAtLeast(System.currentTimeMillis() - ui.getCreateStartedAtMs(), 0L);
            }
            VoiceDiscussionMetrics.INSTANCE.reportSubtaskEnd(proxyConversationConfig.getCliType(), proxyConversationConfig.getMode(), proxyConversationConfig.getVoiceConversationId(), latestRoomIdForMetrics, ui.getSourceTaskId(), status, failureReason, longValue, intValue, isCancelled);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startClientProxyTask(SubTaskRequestMessage req) {
        ProxyConversationConfig proxyConversationConfig = config;
        String str = (String) _proxyConversationId.getValue();
        String str2 = (String) _proxyChatSessionId.getValue();
        if (proxyConversationConfig == null) {
            FLogger.INSTANCE.w(TAG, "startClientProxyTask[drop-config-not-ready]: taskId=" + req.getTaskId());
            return;
        }
        _activeTask.setValue(new SubTaskUiState(req.getTaskId(), req.getTaskDescription(), null, str, str2, SubTaskRenderState.Creating, null, null, 0L, false, SubTaskExecutor.ClientProxy, null, 3012, null));
        reportLocalSubtaskStart(req);
        FLogger.INSTANCE.d(TAG, "startClientProxyTask: taskId=" + req.getTaskId() + ", proxyConvId=" + str + ", timeoutMs=" + req.getTimeoutMs());
        startLongRunningJob(req.getTaskId());
        Job job = taskCreateJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        taskCreateJob = BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VoiceSubTaskCoordinator$startClientProxyTask$1(proxyConversationConfig, str, req, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startServerClosedLoopTask(SubTaskRequestMessage req) {
        _activeTask.setValue(new SubTaskUiState(req.getTaskId(), req.getTaskDescription(), null, null, null, SubTaskRenderState.Thinking, null, null, 0L, false, SubTaskExecutor.ServerClosedLoop, null, 3036, null));
        startLongRunningJob(req.getTaskId());
        startTimer(req.getTimeoutMs(), req.getTaskId());
        FLogger.INSTANCE.d(TAG, "startServerClosedLoopTask: task_id=" + req.getTaskId() + ", timeoutMs=" + req.getTimeoutMs());
    }

    public final void handleTaskStart(TaskStartMessage msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (!started) {
            FLogger.INSTANCE.w(TAG, "handleTaskStart: ignored, coordinator not started");
            return;
        }
        SubTaskUiState subTaskUiState = (SubTaskUiState) _activeTask.getValue();
        boolean z = subTaskUiState != null && Intrinsics.areEqual(subTaskUiState.getSourceTaskId(), msg.getTaskId());
        boolean z2 = subTaskUiState != null && IN_FLIGHT_STATES.contains(subTaskUiState.getState());
        if (z) {
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder append = new StringBuilder("handleTaskStart[drop-duplicate]: taskId=").append(msg.getTaskId()).append(", state=");
            Intrinsics.checkNotNull(subTaskUiState);
            fLogger.d(TAG, append.append(subTaskUiState.getState()).append(", tool=").append(msg.getToolName()).toString());
            return;
        }
        if (z2) {
            FLogger fLogger2 = FLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("handleTaskStart[parallel]: currId=");
            Intrinsics.checkNotNull(subTaskUiState);
            fLogger2.w(TAG, sb.append(subTaskUiState.getSourceTaskId()).append('(').append(subTaskUiState.getState()).append(", ").append(subTaskUiState.getExecutor()).append("), taskId=").append(msg.getTaskId()).append(", tool=").append(msg.getToolName()).append("; wait task_result for parallel terminal").toString());
            return;
        }
        if (subTaskUiState != null) {
            FLogger.INSTANCE.d(TAG, "handleTaskStart[overwrite-terminal]: prevId=" + subTaskUiState.getSourceTaskId() + '(' + subTaskUiState.getState() + "), taskId=" + msg.getTaskId() + ", tool=" + msg.getToolName());
            startTaskStartUi(msg);
        } else {
            FLogger.INSTANCE.d(TAG, "handleTaskStart[start]: taskId=" + msg.getTaskId() + ", tool=" + msg.getToolName());
            startTaskStartUi(msg);
        }
    }

    private final void startTaskStartUi(TaskStartMessage msg) {
        _activeTask.setValue(new SubTaskUiState(msg.getTaskId(), "", null, null, null, SubTaskRenderState.Thinking, null, null, 0L, false, SubTaskExecutor.ServerClosedLoop, msg.getToolName(), 988, null));
        startLongRunningJob(msg.getTaskId());
        startTimer(600000L, msg.getTaskId());
    }

    public final void handleTaskStop(TaskStopMessage msg, String currentRoomId) {
        SubTaskUiState copy;
        Intrinsics.checkNotNullParameter(msg, "msg");
        FLogger.INSTANCE.d(TAG, "handleTaskStop[enter]: taskId=" + msg.getTaskId() + ", room=" + msg.getRoomId() + ", currentRoom=" + currentRoomId + ", timeoutMs=" + msg.getTimeoutMs());
        if (!started) {
            FLogger.INSTANCE.w(TAG, "handleTaskStop[drop-not-started]: taskId=" + msg.getTaskId());
            return;
        }
        boolean z = true;
        if (currentRoomId != null) {
            if ((currentRoomId.length() > 0) && !Intrinsics.areEqual(msg.getRoomId(), currentRoomId)) {
                FLogger.INSTANCE.w(TAG, "handleTaskStop[drop-room-mismatch]: req=" + msg.getRoomId() + ", current=" + currentRoomId + ", taskId=" + msg.getTaskId());
                return;
            }
        }
        MutableStateFlow<SubTaskUiState> mutableStateFlow = _activeTask;
        SubTaskUiState subTaskUiState = (SubTaskUiState) mutableStateFlow.getValue();
        if (subTaskUiState == null) {
            FLogger.INSTANCE.w(TAG, "handleTaskStop[ack-no-active]: taskId=" + msg.getTaskId());
            postSubTaskResultOnceAsync$default(this, msg.getTaskId(), "success", "", 0L, null, null, "task-stop-no-active", 48, null);
            return;
        }
        if (!Intrinsics.areEqual(subTaskUiState.getSourceTaskId(), msg.getTaskId()) && !Intrinsics.areEqual(subTaskUiState.getLocalTaskId(), msg.getTaskId())) {
            z = false;
        }
        if (!z) {
            FLogger.INSTANCE.w(TAG, "handleTaskStop[task-id-mismatch-cancel-current]: req=" + msg.getTaskId() + ", active=" + subTaskUiState.getSourceTaskId() + '(' + subTaskUiState.getState() + "), localTaskId=" + subTaskUiState.getLocalTaskId() + ", canceling=" + cancelingClientProxyTaskId);
        }
        if (!IN_FLIGHT_STATES.contains(subTaskUiState.getState())) {
            FLogger.INSTANCE.w(TAG, "handleTaskStop[ack-stale-terminal]: taskId=" + msg.getTaskId() + ", active=" + subTaskUiState.getSourceTaskId() + '(' + subTaskUiState.getState() + "), matched=" + z);
            postSubTaskResultOnceAsync$default(this, msg.getTaskId(), "success", "", 0L, null, null, "task-stop-stale-terminal", 48, null);
            return;
        }
        long currentTimeMillis = subTaskUiState.getCreateStartedAtMs() > 0 ? System.currentTimeMillis() - subTaskUiState.getCreateStartedAtMs() : 0L;
        if (subTaskUiState.getExecutor() != SubTaskExecutor.ClientProxy) {
            clearSwitchingPendingForStop(subTaskUiState.getSourceTaskId());
            cancelActiveTask$default(this, TaskStopMessage.TYPE, false, 2, null);
            postSubTaskResultOnceAsync$default(this, msg.getTaskId(), "success", "", currentTimeMillis, null, null, "task-stop-server-closed-loop", 48, null);
            return;
        }
        cancelTimer();
        cancelLongRunningJob();
        clearSwitchingPendingForStop(subTaskUiState.getSourceTaskId());
        copy = subTaskUiState.copy((r28 & 1) != 0 ? subTaskUiState.sourceTaskId : null, (r28 & 2) != 0 ? subTaskUiState.taskDescription : null, (r28 & 4) != 0 ? subTaskUiState.localTaskId : null, (r28 & 8) != 0 ? subTaskUiState.proxyConversationId : null, (r28 & 16) != 0 ? subTaskUiState.proxyChatSessionId : null, (r28 & 32) != 0 ? subTaskUiState.state : SubTaskRenderState.Failed, (r28 & 64) != 0 ? subTaskUiState.content : null, (r28 & 128) != 0 ? subTaskUiState.failureReason : TaskStopMessage.TYPE, (r28 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? subTaskUiState.createStartedAtMs : 0L, (r28 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? subTaskUiState.longRunning : false, (r28 & 1024) != 0 ? subTaskUiState.executor : null, (r28 & 2048) != 0 ? subTaskUiState.toolName : null);
        mutableStateFlow.setValue(copy);
        reportLocalSubtaskEnd(subTaskUiState, "failed", TaskStopMessage.TYPE, null, true);
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VoiceSubTaskCoordinator$handleTaskStop$1(subTaskUiState, msg, currentTimeMillis, null), 3, (Object) null);
    }

    public final boolean handleToolResult(ToolResultMessage msg) {
        SubTaskUiState copy;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (!started) {
            FLogger.INSTANCE.w(TAG, "handleToolResult: ignored, coordinator not started");
            return false;
        }
        completeCancelWaiterBySourceTaskId(msg.getTaskId(), msg.getStatus());
        String resolveToolResultFailureReason = resolveToolResultFailureReason(msg);
        SubTaskRenderState subTaskRenderState = resolveToolResultFailureReason == null ? SubTaskRenderState.Done : SubTaskRenderState.Failed;
        String result = msg.getResult();
        String str = result == null ? "" : result;
        String str2 = resolveToolResultFailureReason == null ? "Done" : "Failed(" + resolveToolResultFailureReason + ')';
        MutableStateFlow<SubTaskUiState> mutableStateFlow = _activeTask;
        SubTaskUiState subTaskUiState = (SubTaskUiState) mutableStateFlow.getValue();
        boolean z = subTaskUiState != null && Intrinsics.areEqual(subTaskUiState.getSourceTaskId(), msg.getTaskId());
        boolean z2 = subTaskUiState != null && IN_FLIGHT_STATES.contains(subTaskUiState.getState());
        if (z && z2) {
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("handleToolResult[advance]: sourceTaskId=");
            Intrinsics.checkNotNull(subTaskUiState);
            fLogger.d(TAG, sb.append(subTaskUiState.getSourceTaskId()).append(", executor=").append(subTaskUiState.getExecutor()).append(", tool=").append(msg.getToolName()).append(", resultLen=").append(str.length()).append(", status=").append(msg.getStatus()).append(", error=").append(msg.getError()).append(", terminal=").append(str2).toString());
            cancelTimer();
            cancelLongRunningJob();
            Job job = taskCreateJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            taskCreateJob = null;
            String toolName = subTaskUiState.getToolName();
            if (toolName == null) {
                toolName = msg.getToolName();
            }
            copy = subTaskUiState.copy((r28 & 1) != 0 ? subTaskUiState.sourceTaskId : null, (r28 & 2) != 0 ? subTaskUiState.taskDescription : null, (r28 & 4) != 0 ? subTaskUiState.localTaskId : null, (r28 & 8) != 0 ? subTaskUiState.proxyConversationId : null, (r28 & 16) != 0 ? subTaskUiState.proxyChatSessionId : null, (r28 & 32) != 0 ? subTaskUiState.state : subTaskRenderState, (r28 & 64) != 0 ? subTaskUiState.content : str, (r28 & 128) != 0 ? subTaskUiState.failureReason : resolveToolResultFailureReason, (r28 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? subTaskUiState.createStartedAtMs : 0L, (r28 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? subTaskUiState.longRunning : false, (r28 & 1024) != 0 ? subTaskUiState.executor : null, (r28 & 2048) != 0 ? subTaskUiState.toolName : toolName);
            mutableStateFlow.setValue(copy);
            reportLocalSubtaskEnd$default(this, subTaskUiState, subTaskRenderState == SubTaskRenderState.Done ? "success" : "failed", resolveToolResultFailureReason == null ? "" : resolveToolResultFailureReason, null, false, 16, null);
            maybeCancelClientProxyTask(subTaskUiState);
            return subTaskUiState.getExecutor() == SubTaskExecutor.ServerClosedLoop && isServerToolResultCandidate(msg);
        }
        if (z) {
            FLogger fLogger2 = FLogger.INSTANCE;
            StringBuilder append = new StringBuilder("handleToolResult[skip-duplicate]: sourceTaskId=").append(msg.getTaskId()).append(", currState=");
            Intrinsics.checkNotNull(subTaskUiState);
            fLogger2.d(TAG, append.append(subTaskUiState.getState()).append(", executor=").append(subTaskUiState.getExecutor()).toString());
            return false;
        }
        if (!z2) {
            if (subTaskUiState != null) {
                FLogger.INSTANCE.d(TAG, "handleToolResult[lazy-init-overwrite]: prevId=" + subTaskUiState.getSourceTaskId() + '(' + subTaskUiState.getState() + "), newId=" + msg.getTaskId() + ", tool=" + msg.getToolName() + ", resultLen=" + str.length() + ", status=" + msg.getStatus() + ", terminal=" + str2);
                mutableStateFlow.setValue(new SubTaskUiState(msg.getTaskId(), "", null, null, null, subTaskRenderState, str, resolveToolResultFailureReason, 0L, false, SubTaskExecutor.ServerClosedLoop, msg.getToolName(), 796, null));
                return isServerToolResultCandidate(msg);
            }
            FLogger.INSTANCE.d(TAG, "handleToolResult[lazy-init]: taskId=" + msg.getTaskId() + ", tool=" + msg.getToolName() + ", resultLen=" + str.length() + ", status=" + msg.getStatus() + ", terminal=" + str2);
            mutableStateFlow.setValue(new SubTaskUiState(msg.getTaskId(), "", null, null, null, subTaskRenderState, str, resolveToolResultFailureReason, 0L, false, SubTaskExecutor.ServerClosedLoop, msg.getToolName(), 796, null));
            return isServerToolResultCandidate(msg);
        }
        FLogger fLogger3 = FLogger.INSTANCE;
        StringBuilder sb2 = new StringBuilder("handleToolResult[skip-busy]: currState=");
        Intrinsics.checkNotNull(subTaskUiState);
        fLogger3.w(TAG, sb2.append(subTaskUiState.getState()).append(", currId=").append(subTaskUiState.getSourceTaskId()).append(", executor=").append(subTaskUiState.getExecutor()).append(", dropMsgId=").append(msg.getTaskId()).append(", dropTool=").append(msg.getToolName()).append(", terminal=").append(str2).append(" → emit parallel terminal").toString());
        boolean shouldFailPendingClientProxyTask = shouldFailPendingClientProxyTask(subTaskUiState, msg, resolveToolResultFailureReason);
        if (shouldFailPendingClientProxyTask) {
            FLogger.INSTANCE.w(TAG, "handleToolResult[consume-local-pending]: currId=" + subTaskUiState.getSourceTaskId() + ", msgId=" + msg.getTaskId() + ", tool=" + msg.getToolName() + ", reason=" + resolveToolResultFailureReason);
            failPendingClientProxyTask(subTaskUiState.getSourceTaskId(), resolveToolResultFailureReason == null ? "task_create_failed" : resolveToolResultFailureReason);
            clearPendingClientProxyIfCurrent(subTaskUiState.getSourceTaskId());
        }
        if (!_parallelTerminalToolResults.tryEmit(new SubTaskUiState(msg.getTaskId(), "", null, null, null, subTaskRenderState, str, resolveToolResultFailureReason, 0L, false, SubTaskExecutor.ServerClosedLoop, msg.getToolName(), 796, null))) {
            FLogger.INSTANCE.w(TAG, "handleToolResult[skip-busy]: parallelTerminal buffer overflow, dropped taskId=" + msg.getTaskId());
        }
        return !shouldFailPendingClientProxyTask && isServerToolResultCandidate(msg);
    }

    private final boolean isServerToolResultCandidate(ToolResultMessage msg) {
        return !StringsKt.equals(msg.getToolName(), TOOL_NAME_TASK_CREATE, true);
    }

    private final boolean shouldFailPendingClientProxyTask(SubTaskUiState current, ToolResultMessage msg, String failureReason) {
        if (failureReason == null || current.getExecutor() != SubTaskExecutor.ClientProxy || current.getLocalTaskId() != null || current.getCreateStartedAtMs() != 0 || !StringsKt.equals(msg.getToolName(), TOOL_NAME_TASK_CREATE, true)) {
            return false;
        }
        String str = cancelingClientProxyTaskId;
        if (str != null && Intrinsics.areEqual(msg.getTaskId(), str)) {
            FLogger.INSTANCE.w(TAG, "handleToolResult[skip-superseded-echo]: msgId=" + msg.getTaskId() + " is the task being canceled for supersede, keep pending currId=" + current.getSourceTaskId());
            return false;
        }
        if (isSubTaskResultReported(msg.getTaskId())) {
            FLogger.INSTANCE.w(TAG, "handleToolResult[skip-self-reported-echo]: msgId=" + msg.getTaskId() + " terminal already reported by client itself, keep pending currId=" + current.getSourceTaskId());
            return false;
        }
        String resolveReportTaskId = resolveReportTaskId(current.getSourceTaskId());
        if (Intrinsics.areEqual(resolveReportTaskId, current.getSourceTaskId()) || !Intrinsics.areEqual(msg.getTaskId(), resolveReportTaskId)) {
            return true;
        }
        FLogger.INSTANCE.w(TAG, "handleToolResult[skip-update-chain-echo]: msgId=" + msg.getTaskId() + " is the silenced origin of update chain, keep pending currId=" + current.getSourceTaskId());
        return false;
    }

    private final void clearPendingClientProxyIfCurrent(String sourceTaskId) {
        SubTaskRequestMessage subTaskRequestMessage = pendingClientProxyRequest;
        if (Intrinsics.areEqual(subTaskRequestMessage != null ? subTaskRequestMessage.getTaskId() : null, sourceTaskId)) {
            Job job = pendingClientProxyStartJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            pendingClientProxyStartJob = null;
            pendingClientProxyRequest = null;
            pendingClientProxyExecutor = null;
            cancelingClientProxyTaskId = null;
        }
    }

    private final void clearSwitchingPendingForStop(String activeSourceTaskId) {
        SubTaskRequestMessage subTaskRequestMessage = pendingClientProxyRequest;
        if (subTaskRequestMessage == null) {
            return;
        }
        FLogger.INSTANCE.w(TAG, "handleTaskStop[clear-pending]: active=" + activeSourceTaskId + ", pending=" + subTaskRequestMessage.getTaskId() + ", canceling=" + cancelingClientProxyTaskId);
        Job job = pendingClientProxyStartJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        pendingClientProxyStartJob = null;
        pendingClientProxyRequest = null;
        pendingClientProxyExecutor = null;
        cancelingClientProxyTaskId = null;
    }

    private final void maybeCancelClientProxyTask(SubTaskUiState current) {
        if (current.getExecutor() != SubTaskExecutor.ClientProxy) {
            return;
        }
        String proxyConversationId2 = current.getProxyConversationId();
        String localTaskId = current.getLocalTaskId();
        String str = proxyConversationId2;
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = localTaskId;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1(proxyConversationId2, localTaskId, null), 3, (Object) null);
    }

    private final String resolveToolResultFailureReason(ToolResultMessage msg) {
        String status = msg.getStatus();
        String error = msg.getError();
        if (error == null || !(!StringsKt.isBlank(error))) {
            error = null;
        }
        if (((status == null || StringsKt.equals(status, "success", true)) ? false : true) || error != null) {
            return error == null ? status == null ? "task_result_failed" : status : error;
        }
        return null;
    }

    public static /* synthetic */ void cancelActiveTask$default(VoiceSubTaskCoordinator voiceSubTaskCoordinator, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        voiceSubTaskCoordinator.cancelActiveTask(str, z);
    }

    public final void cancelActiveTask(String reason, boolean reportClientProxyResult) {
        SubTaskUiState copy;
        Intrinsics.checkNotNullParameter(reason, "reason");
        MutableStateFlow<SubTaskUiState> mutableStateFlow = _activeTask;
        SubTaskUiState subTaskUiState = (SubTaskUiState) mutableStateFlow.getValue();
        if (subTaskUiState != null && IN_FLIGHT_STATES.contains(subTaskUiState.getState())) {
            Long valueOf = Long.valueOf(subTaskUiState.getCreateStartedAtMs());
            boolean z = true;
            if (!(valueOf.longValue() > 0)) {
                valueOf = null;
            }
            long coerceAtLeast = valueOf != null ? RangesKt.coerceAtLeast(System.currentTimeMillis() - valueOf.longValue(), 0L) : 0L;
            FLogger.INSTANCE.w(TAG, "cancelActiveTask: sourceTaskId=" + subTaskUiState.getSourceTaskId() + ", prev=" + subTaskUiState.getState() + ", executor=" + subTaskUiState.getExecutor() + ", reason=" + reason + ", reportClientProxyResult=" + reportClientProxyResult);
            cancelTimer();
            cancelLongRunningJob();
            copy = subTaskUiState.copy((r28 & 1) != 0 ? subTaskUiState.sourceTaskId : null, (r28 & 2) != 0 ? subTaskUiState.taskDescription : null, (r28 & 4) != 0 ? subTaskUiState.localTaskId : null, (r28 & 8) != 0 ? subTaskUiState.proxyConversationId : null, (r28 & 16) != 0 ? subTaskUiState.proxyChatSessionId : null, (r28 & 32) != 0 ? subTaskUiState.state : SubTaskRenderState.Failed, (r28 & 64) != 0 ? subTaskUiState.content : null, (r28 & 128) != 0 ? subTaskUiState.failureReason : reason, (r28 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? subTaskUiState.createStartedAtMs : 0L, (r28 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? subTaskUiState.longRunning : false, (r28 & 1024) != 0 ? subTaskUiState.executor : null, (r28 & 2048) != 0 ? subTaskUiState.toolName : null);
            mutableStateFlow.setValue(copy);
            reportLocalSubtaskEnd$default(this, subTaskUiState, "failed", reason, null, false, 16, null);
            if (subTaskUiState.getExecutor() != SubTaskExecutor.ClientProxy) {
                FLogger.INSTANCE.d(TAG, "cancelActiveTask: skip remote cancel (executor=" + subTaskUiState.getExecutor() + "), reason=" + reason);
                return;
            }
            if (reportClientProxyResult) {
                postSubTaskResultOnceAsync$default(this, subTaskUiState.getSourceTaskId(), "failed", "", coerceAtLeast, reason, null, "cancel-active-" + reason, 32, null);
            }
            String proxyConversationId2 = subTaskUiState.getProxyConversationId();
            String localTaskId = subTaskUiState.getLocalTaskId();
            String str = proxyConversationId2;
            if (!(str == null || str.length() == 0)) {
                String str2 = localTaskId;
                if (str2 != null && str2.length() != 0) {
                    z = false;
                }
                if (!z) {
                    BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VoiceSubTaskCoordinator$cancelActiveTask$1(proxyConversationId2, localTaskId, null), 3, (Object) null);
                    return;
                }
            }
            FLogger.INSTANCE.d(TAG, "cancelActiveTask: skip remote cancel (no localTaskId), reason=" + reason);
        }
    }

    public static /* synthetic */ void release$default(VoiceSubTaskCoordinator voiceSubTaskCoordinator, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = "released";
        }
        voiceSubTaskCoordinator.release(z, str);
    }

    public final void release(boolean deleteEmptyRemoteParentSession, String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (started) {
            if (deleteEmptyRemoteParentSession) {
                maybeDeleteEmptyRemoteParentSession(reason);
            }
            cancelActiveTask$default(this, "released", false, 2, null);
            Job job = parentCreateJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            parentCreateJob = null;
            Job job2 = taskCreateJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            taskCreateJob = null;
            Job job3 = pendingClientProxyStartJob;
            if (job3 != null) {
                Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
            }
            pendingClientProxyStartJob = null;
            pendingClientProxyRequest = null;
            pendingClientProxyExecutor = null;
            cancelingClientProxyTaskId = null;
            latestRoomIdForMetrics = null;
            subTaskMetricStartedAtMs.clear();
            subTaskMetricFileCounts.clear();
            subTaskMetricEndedTaskIds.clear();
            VoiceDiscussionMetrics.INSTANCE.clearServerToolTracking();
            synchronized (cancelWaiterLock) {
                Iterator<T> it = cancelWaiters.values().iterator();
                while (it.hasNext()) {
                    Job.DefaultImpls.cancel$default((CompletableDeferred) it.next(), (CancellationException) null, 1, (Object) null);
                }
                cancelWaiters.clear();
                cancelWaiterSourceToLocal.clear();
                Unit unit = Unit.INSTANCE;
            }
            synchronized (subTaskResultReportLock) {
                subTaskResultReportedTaskIds.clear();
                Unit unit2 = Unit.INSTANCE;
            }
            synchronized (createTaskBizErrorSuppressLock) {
                createTaskBizErrorSuppressedTaskIds.clear();
                Unit unit3 = Unit.INSTANCE;
            }
            synchronized (resultAliasLock) {
                resultTaskIdAlias.clear();
                Unit unit4 = Unit.INSTANCE;
            }
            cancelTimer();
            cancelLongRunningJob();
            IMService.INSTANCE.removeStreamingMessageListener(streamingListener);
            IMService.INSTANCE.removeCliStatusChangeListener(cliStatusListener);
            _proxyConversationId.setValue((Object) null);
            _proxyChatSessionId.setValue((Object) null);
            _parentConversationId.setValue((Object) null);
            _parentChatSessionId.setValue((Object) null);
            _activeTask.setValue((Object) null);
            config = null;
            subTaskConfig = null;
            sendAckToBot = null;
            deviceOnline = true;
            started = false;
            FLogger.INSTANCE.d(TAG, "release: done");
        }
    }

    private final void maybeDeleteEmptyRemoteParentSession(String reason) {
        ProxyConversationConfig proxyConversationConfig = config;
        String str = (String) _parentChatSessionId.getValue();
        boolean z = true;
        if (str == null || !(!StringsKt.isBlank(str))) {
            str = null;
        }
        String str2 = (String) _parentConversationId.getValue();
        if (str2 == null || !(!StringsKt.isBlank(str2))) {
            str2 = null;
        }
        String str3 = (String) _proxyConversationId.getValue();
        if (str3 == null || !(!StringsKt.isBlank(str3))) {
            str3 = null;
        }
        if ((proxyConversationConfig != null ? proxyConversationConfig.getCliType() : null) != CliType.REMOTE || !proxyConversationConfig.getCreateRemoteParentSession()) {
            FLogger.INSTANCE.d(TAG, "skip delete empty parent: not remote home, reason=" + reason);
            return;
        }
        String str4 = str2;
        if (str4 == null || StringsKt.isBlank(str4)) {
            FLogger.INSTANCE.d(TAG, "skip delete empty parent: parentConversationId empty, parentChatSessionId=" + str + ", reason=" + reason);
            return;
        }
        String str5 = str3;
        if (str5 != null && !StringsKt.isBlank(str5)) {
            z = false;
        }
        if (!z) {
            FLogger.INSTANCE.d(TAG, "skip delete empty parent: proxy exists, parentConversationId=" + str2 + ", parentChatSessionId=" + str + ", proxyConversationId=" + str3 + ", reason=" + reason);
        } else {
            deleteHubConversationAsync(str2, str, reason);
        }
    }

    private final void deleteHubConversationAsync(String parentConversationId2, String parentChatSessionId2, String reason) {
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VoiceSubTaskCoordinator$deleteHubConversationAsync$1(parentConversationId2, parentChatSessionId2, reason, null), 3, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitParentChatSessionId(Continuation<? super String> continuation) {
        VoiceSubTaskCoordinator$awaitParentChatSessionId$1 voiceSubTaskCoordinator$awaitParentChatSessionId$1;
        int i;
        String str;
        if (continuation instanceof VoiceSubTaskCoordinator$awaitParentChatSessionId$1) {
            voiceSubTaskCoordinator$awaitParentChatSessionId$1 = (VoiceSubTaskCoordinator$awaitParentChatSessionId$1) continuation;
            if ((voiceSubTaskCoordinator$awaitParentChatSessionId$1.label & Integer.MIN_VALUE) != 0) {
                voiceSubTaskCoordinator$awaitParentChatSessionId$1.label -= Integer.MIN_VALUE;
                Object obj = voiceSubTaskCoordinator$awaitParentChatSessionId$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = voiceSubTaskCoordinator$awaitParentChatSessionId$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String str2 = (String) _parentChatSessionId.getValue();
                    if (str2 != null) {
                        if (!(!StringsKt.isBlank(str2))) {
                            str2 = null;
                        }
                        if (str2 != null) {
                            return str2;
                        }
                    }
                    Job job = parentCreateJob;
                    if (job != null) {
                        voiceSubTaskCoordinator$awaitParentChatSessionId$1.label = 1;
                        if (job.join(voiceSubTaskCoordinator$awaitParentChatSessionId$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                str = (String) _parentChatSessionId.getValue();
                if (str == null && (!StringsKt.isBlank(str))) {
                    return str;
                }
            }
        }
        voiceSubTaskCoordinator$awaitParentChatSessionId$1 = new VoiceSubTaskCoordinator$awaitParentChatSessionId$1(this, continuation);
        Object obj2 = voiceSubTaskCoordinator$awaitParentChatSessionId$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = voiceSubTaskCoordinator$awaitParentChatSessionId$1.label;
        if (i != 0) {
        }
        str = (String) _parentChatSessionId.getValue();
        return str == null ? null : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object createRemoteParentSession(ProxyConversationConfig proxyConversationConfig, Continuation<? super String> continuation) {
        VoiceSubTaskCoordinator$createRemoteParentSession$1 voiceSubTaskCoordinator$createRemoteParentSession$1;
        int i;
        String str;
        boolean z;
        Object createAgentTaskRawCall;
        HttpDataResult.Success result;
        String str2;
        String str3;
        ConversationInfo task;
        ConversationInfo task2;
        HttpDataResult.Error error;
        if (continuation instanceof VoiceSubTaskCoordinator$createRemoteParentSession$1) {
            voiceSubTaskCoordinator$createRemoteParentSession$1 = (VoiceSubTaskCoordinator$createRemoteParentSession$1) continuation;
            if ((voiceSubTaskCoordinator$createRemoteParentSession$1.label & Integer.MIN_VALUE) != 0) {
                voiceSubTaskCoordinator$createRemoteParentSession$1.label -= Integer.MIN_VALUE;
                Object obj = voiceSubTaskCoordinator$createRemoteParentSession$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = voiceSubTaskCoordinator$createRemoteParentSession$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Source source = proxyConversationConfig.getSource();
                    str = TAG;
                    z = true;
                    CreateTaskRequest createTaskRequest$conversation_mainlandRelease$default = createTaskRequest$conversation_mainlandRelease$default(this, proxyConversationConfig, null, null, null, null, source, null, false, 216, null);
                    FLogger.INSTANCE.d(str, "createRemoteParentSession: posting empty parent, voiceConvId=" + proxyConversationConfig.getVoiceConversationId());
                    ICreateAgentTask.Companion companion = ICreateAgentTask.INSTANCE;
                    voiceSubTaskCoordinator$createRemoteParentSession$1.label = 1;
                    createAgentTaskRawCall = companion.createAgentTaskRawCall(createTaskRequest$conversation_mainlandRelease$default, voiceSubTaskCoordinator$createRemoteParentSession$1);
                    if (createAgentTaskRawCall == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        str3 = (String) voiceSubTaskCoordinator$createRemoteParentSession$1.L$1;
                        str2 = (String) voiceSubTaskCoordinator$createRemoteParentSession$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        str = TAG;
                        error = (HttpDataResult) obj;
                        if (!(error instanceof HttpDataResult.Success)) {
                            FLogger.INSTANCE.d(str, "createRemoteParentSession: wakeup ok, chatSessionId=" + str3);
                        } else {
                            if (!(error instanceof HttpDataResult.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            HttpDataResult.Error error2 = error;
                            FLogger.INSTANCE.w(str, "createRemoteParentSession: wakeup failed, chatSessionId=" + str3 + ", parentConversationId=" + str2 + ", code=" + error2.getCode() + ", msg=" + error2.getMsg(), error2.getThrowable());
                        }
                        return str2;
                    }
                    ResultKt.throwOnFailure(obj);
                    createAgentTaskRawCall = obj;
                    str = TAG;
                    z = true;
                }
                result = ((CreateTaskRawResult) createAgentTaskRawCall).getResult();
                if (result instanceof HttpDataResult.Success) {
                    FLogger.INSTANCE.w(str, "createRemoteParentSession: create failed, result=" + result);
                    return null;
                }
                BizResponse bizResp = result.getBizResp();
                CreateTaskResponse createTaskResponse = (CreateTaskResponse) bizResp.getData();
                String id = (createTaskResponse == null || (task2 = createTaskResponse.getTask()) == null) ? null : task2.getId();
                CreateTaskResponse createTaskResponse2 = (CreateTaskResponse) bizResp.getData();
                String cliConversationId = (createTaskResponse2 == null || (task = createTaskResponse2.getTask()) == null) ? null : task.getCliConversationId();
                String str4 = id;
                if ((str4 == null || str4.length() == 0) ? z : false) {
                    FLogger.INSTANCE.w(str, "createRemoteParentSession: bizCode=" + bizResp.getCode() + ", conversationId empty");
                    return null;
                }
                String str5 = cliConversationId;
                if ((str5 == null || str5.length() == 0) ? z : false) {
                    FLogger.INSTANCE.w(str, "createRemoteParentSession: bizCode=" + bizResp.getCode() + ", chatSessionId empty, parentConversationId=" + id);
                    return null;
                }
                if (!started) {
                    FLogger.INSTANCE.d(str, "createRemoteParentSession: released before create completed, drop convId=" + id);
                    return null;
                }
                _parentConversationId.setValue(id);
                _parentChatSessionId.setValue(cliConversationId);
                FLogger.INSTANCE.d(str, "createRemoteParentSession: parent ok, parentConversationId=" + id + ", chatSessionId=" + cliConversationId);
                IChatSessionApi.Companion companion2 = IChatSessionApi.INSTANCE;
                voiceSubTaskCoordinator$createRemoteParentSession$1.L$0 = id;
                voiceSubTaskCoordinator$createRemoteParentSession$1.L$1 = cliConversationId;
                voiceSubTaskCoordinator$createRemoteParentSession$1.label = 2;
                obj = companion2.wakeupSandboxRawCall(cliConversationId, voiceSubTaskCoordinator$createRemoteParentSession$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str2 = id;
                str3 = cliConversationId;
                error = (HttpDataResult) obj;
                if (!(error instanceof HttpDataResult.Success)) {
                }
                return str2;
            }
        }
        voiceSubTaskCoordinator$createRemoteParentSession$1 = new VoiceSubTaskCoordinator$createRemoteParentSession$1(this, continuation);
        Object obj2 = voiceSubTaskCoordinator$createRemoteParentSession$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = voiceSubTaskCoordinator$createRemoteParentSession$1.label;
        if (i != 0) {
        }
        result = ((CreateTaskRawResult) createAgentTaskRawCall).getResult();
        if (result instanceof HttpDataResult.Success) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveParentConversationIdForSubTask(ProxyConversationConfig proxyConversationConfig, Continuation<? super String> continuation) {
        VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1 voiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1;
        int i;
        String str;
        String parentConversationId2;
        if (continuation instanceof VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1) {
            voiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1 = (VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1) continuation;
            if ((voiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1.label & Integer.MIN_VALUE) != 0) {
                voiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1.label -= Integer.MIN_VALUE;
                Object obj = voiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = voiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (proxyConversationConfig.getCliType() != CliType.REMOTE) {
                        return null;
                    }
                    String str2 = (String) _parentConversationId.getValue();
                    if (str2 != null) {
                        if (!(!StringsKt.isBlank(str2))) {
                            str2 = null;
                        }
                        if (str2 != null) {
                            return str2;
                        }
                    }
                    Job job = parentCreateJob;
                    if (job != null) {
                        voiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1.L$0 = proxyConversationConfig;
                        voiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1.label = 1;
                        if (job.join(voiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    proxyConversationConfig = (ProxyConversationConfig) voiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                str = (String) _parentConversationId.getValue();
                if (str != null) {
                    if (!(!StringsKt.isBlank(str))) {
                        str = null;
                    }
                    if (str != null) {
                        return str;
                    }
                }
                parentConversationId2 = proxyConversationConfig.getParentConversationId();
                if (parentConversationId2 == null && (!StringsKt.isBlank(parentConversationId2))) {
                    return parentConversationId2;
                }
            }
        }
        voiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1 = new VoiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1(this, continuation);
        Object obj2 = voiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = voiceSubTaskCoordinator$resolveParentConversationIdForSubTask$1.label;
        if (i != 0) {
        }
        str = (String) _parentConversationId.getValue();
        if (str != null) {
        }
        parentConversationId2 = proxyConversationConfig.getParentConversationId();
        return parentConversationId2 == null ? null : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object createSubTask(ProxyConversationConfig proxyConversationConfig, String str, SubTaskRequestMessage subTaskRequestMessage, Continuation<? super Unit> continuation) {
        VoiceSubTaskCoordinator$createSubTask$1 voiceSubTaskCoordinator$createSubTask$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        String str2;
        ProxyConversationConfig proxyConversationConfig2;
        String str3;
        VoiceSubTaskCoordinator voiceSubTaskCoordinator;
        VoiceSubTaskCoordinator voiceSubTaskCoordinator2;
        SubTaskRequestMessage subTaskRequestMessage2;
        String str4;
        SubTaskUiState copy;
        ConversationInfo task;
        ConversationInfo task2;
        SubTaskRequestMessage subTaskRequestMessage3 = subTaskRequestMessage;
        if (continuation instanceof VoiceSubTaskCoordinator$createSubTask$1) {
            voiceSubTaskCoordinator$createSubTask$1 = (VoiceSubTaskCoordinator$createSubTask$1) continuation;
            if ((voiceSubTaskCoordinator$createSubTask$1.label & Integer.MIN_VALUE) != 0) {
                voiceSubTaskCoordinator$createSubTask$1.label -= Integer.MIN_VALUE;
                obj = voiceSubTaskCoordinator$createSubTask$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = voiceSubTaskCoordinator$createSubTask$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String buildSubTaskQueryJson$conversation_mainlandRelease = buildSubTaskQueryJson$conversation_mainlandRelease(subTaskRequestMessage3);
                    voiceSubTaskCoordinator$createSubTask$1.L$0 = this;
                    voiceSubTaskCoordinator$createSubTask$1.L$1 = proxyConversationConfig;
                    str2 = str;
                    voiceSubTaskCoordinator$createSubTask$1.L$2 = str2;
                    voiceSubTaskCoordinator$createSubTask$1.L$3 = subTaskRequestMessage3;
                    voiceSubTaskCoordinator$createSubTask$1.L$4 = buildSubTaskQueryJson$conversation_mainlandRelease;
                    voiceSubTaskCoordinator$createSubTask$1.label = 1;
                    Object resolveParentConversationIdForSubTask = resolveParentConversationIdForSubTask(proxyConversationConfig, voiceSubTaskCoordinator$createSubTask$1);
                    if (resolveParentConversationIdForSubTask == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    proxyConversationConfig2 = proxyConversationConfig;
                    str3 = buildSubTaskQueryJson$conversation_mainlandRelease;
                    obj = resolveParentConversationIdForSubTask;
                    voiceSubTaskCoordinator = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            if (i != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        subTaskRequestMessage2 = (SubTaskRequestMessage) voiceSubTaskCoordinator$createSubTask$1.L$2;
                        str4 = (String) voiceSubTaskCoordinator$createSubTask$1.L$1;
                        voiceSubTaskCoordinator2 = (VoiceSubTaskCoordinator) voiceSubTaskCoordinator$createSubTask$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        CreateTaskRawResult createTaskRawResult = (CreateTaskRawResult) obj;
                        if (started) {
                            return Unit.INSTANCE;
                        }
                        HttpDataResult.Success result = createTaskRawResult.getResult();
                        if (!(result instanceof HttpDataResult.Success)) {
                            voiceSubTaskCoordinator2.clearCreateTaskRetryableBizErrorSuppressed(subTaskRequestMessage2.getTaskId());
                            CreateTaskFailureReport m856x235a44b9 = m856x235a44b9(voiceSubTaskCoordinator2, createTaskRawResult, "create_failed", false, 4, null);
                            FLogger.INSTANCE.w(TAG, "createSubTask: failed, sourceTaskId=" + subTaskRequestMessage2.getTaskId() + ", result=" + result);
                            voiceSubTaskCoordinator2.failActiveTaskAndReport(subTaskRequestMessage2.getTaskId(), m856x235a44b9.getErrorCode(), m856x235a44b9.getError());
                            return Unit.INSTANCE;
                        }
                        BizResponse bizResp = result.getBizResp();
                        if (!voiceSubTaskCoordinator2.isCreateTaskBizSuccess$conversation_mainlandRelease(bizResp.getCode())) {
                            boolean shouldSuppressCreateTaskBizError = voiceSubTaskCoordinator2.shouldSuppressCreateTaskBizError(subTaskRequestMessage2.getTaskId(), bizResp.getCode());
                            CreateTaskFailureReport buildCreateTaskFailureReport$conversation_mainlandRelease = voiceSubTaskCoordinator2.buildCreateTaskFailureReport$conversation_mainlandRelease(createTaskRawResult, "create_failed", shouldSuppressCreateTaskBizError);
                            FLogger.INSTANCE.w(TAG, "createSubTask: biz failed, sourceTaskId=" + subTaskRequestMessage2.getTaskId() + ", bizCode=" + bizResp.getCode() + ", suppressBizError=" + shouldSuppressCreateTaskBizError + ", error=" + buildCreateTaskFailureReport$conversation_mainlandRelease.getError());
                            voiceSubTaskCoordinator2.failActiveTaskAndReport(subTaskRequestMessage2.getTaskId(), buildCreateTaskFailureReport$conversation_mainlandRelease.getErrorCode(), buildCreateTaskFailureReport$conversation_mainlandRelease.getError());
                            return Unit.INSTANCE;
                        }
                        voiceSubTaskCoordinator2.clearCreateTaskRetryableBizErrorSuppressed(subTaskRequestMessage2.getTaskId());
                        CreateTaskResponse createTaskResponse = (CreateTaskResponse) bizResp.getData();
                        String taskId = createTaskResponse != null ? createTaskResponse.getTaskId() : null;
                        CreateTaskResponse createTaskResponse2 = (CreateTaskResponse) bizResp.getData();
                        String id = (createTaskResponse2 == null || (task2 = createTaskResponse2.getTask()) == null) ? null : task2.getId();
                        CreateTaskResponse createTaskResponse3 = (CreateTaskResponse) bizResp.getData();
                        String cliConversationId = (createTaskResponse3 == null || (task = createTaskResponse3.getTask()) == null) ? null : task.getCliConversationId();
                        if (str4 != null) {
                            String str5 = str4.length() > 0 ? str4 : null;
                            if (str5 != null) {
                                id = str5;
                            }
                        }
                        MutableStateFlow<String> mutableStateFlow = _proxyChatSessionId;
                        String str6 = (String) mutableStateFlow.getValue();
                        if (str6 != null) {
                            if (!(str6.length() > 0)) {
                                str6 = null;
                            }
                            if (str6 != null) {
                                cliConversationId = str6;
                            }
                        }
                        String str7 = taskId;
                        if (str7 == null || str7.length() == 0) {
                            FLogger.INSTANCE.w(TAG, "createSubTask: empty taskId, bizCode=" + bizResp.getCode());
                            voiceSubTaskCoordinator2.failActiveTaskAndReport(subTaskRequestMessage2.getTaskId(), "no_local_task_id", voiceSubTaskCoordinator2.buildCreateTaskMissingFieldError(NewTaskTracker.Param.TASK_ID, bizResp.getCode(), voiceSubTaskCoordinator2.firstNonBlankErrorMessage(bizResp.getMessage(), bizResp.getMsg())));
                            return Unit.INSTANCE;
                        }
                        String str8 = id;
                        if (str8 == null || str8.length() == 0) {
                            FLogger.INSTANCE.w(TAG, "createSubTask: empty hidden conversationId, bizCode=" + bizResp.getCode() + ", taskId=" + taskId);
                            voiceSubTaskCoordinator2.failActiveTaskAndReport(subTaskRequestMessage2.getTaskId(), SubTaskErrorCode.CONTAINER_NOT_READY, voiceSubTaskCoordinator2.buildCreateTaskMissingFieldError("conversation_id", bizResp.getCode(), voiceSubTaskCoordinator2.firstNonBlankErrorMessage(bizResp.getMessage(), bizResp.getMsg())));
                            return Unit.INSTANCE;
                        }
                        String str9 = str4;
                        if (str9 == null || str9.length() == 0) {
                            _proxyConversationId.setValue(id);
                            FLogger.INSTANCE.d(TAG, "createSubTask: hidden session created, proxyConversationId=" + id + ", proxyChatSessionId=" + cliConversationId);
                        }
                        String str10 = cliConversationId;
                        if (!(str10 == null || str10.length() == 0)) {
                            CharSequence charSequence = (CharSequence) mutableStateFlow.getValue();
                            if (charSequence == null || charSequence.length() == 0) {
                                mutableStateFlow.setValue(cliConversationId);
                            }
                        }
                        MutableStateFlow<SubTaskUiState> mutableStateFlow2 = _activeTask;
                        SubTaskUiState subTaskUiState = (SubTaskUiState) mutableStateFlow2.getValue();
                        if (!Intrinsics.areEqual(subTaskUiState != null ? subTaskUiState.getSourceTaskId() : null, subTaskRequestMessage2.getTaskId())) {
                            FLogger.INSTANCE.w(TAG, "createSubTask: active task changed during create, cancel server task=" + taskId);
                            voiceSubTaskCoordinator$createSubTask$1.L$0 = null;
                            voiceSubTaskCoordinator$createSubTask$1.L$1 = null;
                            voiceSubTaskCoordinator$createSubTask$1.L$2 = null;
                            voiceSubTaskCoordinator$createSubTask$1.label = 3;
                            if (voiceSubTaskCoordinator2.cancelRemoteClientProxyTask(id, taskId, "active_changed_during_create", voiceSubTaskCoordinator$createSubTask$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        if (IN_FLIGHT_STATES.contains(subTaskUiState.getState())) {
                            copy = subTaskUiState.copy((r28 & 1) != 0 ? subTaskUiState.sourceTaskId : null, (r28 & 2) != 0 ? subTaskUiState.taskDescription : null, (r28 & 4) != 0 ? subTaskUiState.localTaskId : taskId, (r28 & 8) != 0 ? subTaskUiState.proxyConversationId : id, (r28 & 16) != 0 ? subTaskUiState.proxyChatSessionId : cliConversationId, (r28 & 32) != 0 ? subTaskUiState.state : SubTaskRenderState.Thinking, (r28 & 64) != 0 ? subTaskUiState.content : null, (r28 & 128) != 0 ? subTaskUiState.failureReason : null, (r28 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? subTaskUiState.createStartedAtMs : 0L, (r28 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? subTaskUiState.longRunning : false, (r28 & 1024) != 0 ? subTaskUiState.executor : null, (r28 & 2048) != 0 ? subTaskUiState.toolName : null);
                            mutableStateFlow2.setValue(copy);
                            voiceSubTaskCoordinator2.startTimer(subTaskRequestMessage2.getTimeoutMs(), subTaskRequestMessage2.getTaskId());
                            return Unit.INSTANCE;
                        }
                        FLogger.INSTANCE.w(TAG, "createSubTask: active task already in terminal state=" + subTaskUiState.getState() + ", cancel server task=" + taskId);
                        voiceSubTaskCoordinator$createSubTask$1.L$0 = null;
                        voiceSubTaskCoordinator$createSubTask$1.L$1 = null;
                        voiceSubTaskCoordinator$createSubTask$1.L$2 = null;
                        voiceSubTaskCoordinator$createSubTask$1.label = 4;
                        if (voiceSubTaskCoordinator2.cancelRemoteClientProxyTask(id, taskId, "active_terminal_during_create", voiceSubTaskCoordinator$createSubTask$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    String str11 = (String) voiceSubTaskCoordinator$createSubTask$1.L$4;
                    subTaskRequestMessage3 = (SubTaskRequestMessage) voiceSubTaskCoordinator$createSubTask$1.L$3;
                    str2 = (String) voiceSubTaskCoordinator$createSubTask$1.L$2;
                    ProxyConversationConfig proxyConversationConfig3 = (ProxyConversationConfig) voiceSubTaskCoordinator$createSubTask$1.L$1;
                    VoiceSubTaskCoordinator voiceSubTaskCoordinator3 = (VoiceSubTaskCoordinator) voiceSubTaskCoordinator$createSubTask$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str3 = str11;
                    proxyConversationConfig2 = proxyConversationConfig3;
                    voiceSubTaskCoordinator = voiceSubTaskCoordinator3;
                }
                String str12 = (String) obj;
                if (proxyConversationConfig2.getCliType() == CliType.REMOTE) {
                    String str13 = str2;
                    if (str13 == null || str13.length() == 0) {
                        String str14 = str12;
                        if (str14 == null || str14.length() == 0) {
                            FLogger.INSTANCE.w(TAG, "createSubTask: remote parent conversation is empty, taskId=" + subTaskRequestMessage3.getTaskId());
                            failActiveTaskAndReport$default(voiceSubTaskCoordinator, subTaskRequestMessage3.getTaskId(), SubTaskErrorCode.CONTAINER_NOT_READY, null, 4, null);
                            return Unit.INSTANCE;
                        }
                    }
                }
                String str15 = str2;
                boolean z = str15 != null || str15.length() == 0;
                CreateTaskRequest createTaskRequest$conversation_mainlandRelease$default = createTaskRequest$conversation_mainlandRelease$default(voiceSubTaskCoordinator, proxyConversationConfig2, str2, str3, (z || proxyConversationConfig2.getCliType() != CliType.REMOTE) ? null : str12, !z ? HIDDEN_STATUS_VOICE_DISCUSSION : null, null, null, false, 224, null);
                FLogger fLogger = FLogger.INSTANCE;
                StringBuilder append = new StringBuilder("createSubTask: posting, sourceTaskId=").append(subTaskRequestMessage3.getTaskId()).append(", proxyConvId=").append(str2).append(", parentConversationId=").append(createTaskRequest$conversation_mainlandRelease$default.getParentConversationId()).append(", hiddenStatus=").append(createTaskRequest$conversation_mainlandRelease$default.getHiddenStatus()).append(", files=");
                List<QueryItem> files = subTaskRequestMessage3.getFiles();
                fLogger.d(TAG, append.append(files == null ? files.size() : 0).append(", descLen=").append(subTaskRequestMessage3.getTaskDescription().length()).toString());
                voiceSubTaskCoordinator.markCreatePostStart(subTaskRequestMessage3.getTaskId());
                String taskId2 = subTaskRequestMessage3.getTaskId();
                voiceSubTaskCoordinator$createSubTask$1.L$0 = voiceSubTaskCoordinator;
                voiceSubTaskCoordinator$createSubTask$1.L$1 = str2;
                voiceSubTaskCoordinator$createSubTask$1.L$2 = subTaskRequestMessage3;
                voiceSubTaskCoordinator$createSubTask$1.L$3 = null;
                voiceSubTaskCoordinator$createSubTask$1.L$4 = null;
                voiceSubTaskCoordinator$createSubTask$1.label = 2;
                obj = voiceSubTaskCoordinator.createTaskWithRetry(createTaskRequest$conversation_mainlandRelease$default, taskId2, voiceSubTaskCoordinator$createSubTask$1);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                String str16 = str2;
                voiceSubTaskCoordinator2 = voiceSubTaskCoordinator;
                subTaskRequestMessage2 = subTaskRequestMessage3;
                str4 = str16;
                CreateTaskRawResult createTaskRawResult2 = (CreateTaskRawResult) obj;
                if (started) {
                }
            }
        }
        voiceSubTaskCoordinator$createSubTask$1 = new VoiceSubTaskCoordinator$createSubTask$1(this, continuation);
        obj = voiceSubTaskCoordinator$createSubTask$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = voiceSubTaskCoordinator$createSubTask$1.label;
        if (i != 0) {
        }
        String str122 = (String) obj;
        if (proxyConversationConfig2.getCliType() == CliType.REMOTE) {
        }
        String str152 = str2;
        if (str152 != null) {
        }
        CreateTaskRequest createTaskRequest$conversation_mainlandRelease$default2 = createTaskRequest$conversation_mainlandRelease$default(voiceSubTaskCoordinator, proxyConversationConfig2, str2, str3, (z || proxyConversationConfig2.getCliType() != CliType.REMOTE) ? null : str122, !z ? HIDDEN_STATUS_VOICE_DISCUSSION : null, null, null, false, 224, null);
        FLogger fLogger2 = FLogger.INSTANCE;
        StringBuilder append2 = new StringBuilder("createSubTask: posting, sourceTaskId=").append(subTaskRequestMessage3.getTaskId()).append(", proxyConvId=").append(str2).append(", parentConversationId=").append(createTaskRequest$conversation_mainlandRelease$default2.getParentConversationId()).append(", hiddenStatus=").append(createTaskRequest$conversation_mainlandRelease$default2.getHiddenStatus()).append(", files=");
        List<QueryItem> files2 = subTaskRequestMessage3.getFiles();
        fLogger2.d(TAG, append2.append(files2 == null ? files2.size() : 0).append(", descLen=").append(subTaskRequestMessage3.getTaskDescription().length()).toString());
        voiceSubTaskCoordinator.markCreatePostStart(subTaskRequestMessage3.getTaskId());
        String taskId22 = subTaskRequestMessage3.getTaskId();
        voiceSubTaskCoordinator$createSubTask$1.L$0 = voiceSubTaskCoordinator;
        voiceSubTaskCoordinator$createSubTask$1.L$1 = str2;
        voiceSubTaskCoordinator$createSubTask$1.L$2 = subTaskRequestMessage3;
        voiceSubTaskCoordinator$createSubTask$1.L$3 = null;
        voiceSubTaskCoordinator$createSubTask$1.L$4 = null;
        voiceSubTaskCoordinator$createSubTask$1.label = 2;
        obj = voiceSubTaskCoordinator.createTaskWithRetry(createTaskRequest$conversation_mainlandRelease$default2, taskId22, voiceSubTaskCoordinator$createSubTask$1);
        if (obj != coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x016f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0160 -> B:11:0x016b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object createTaskWithRetry(CreateTaskRequest createTaskRequest, String str, Continuation<? super CreateTaskRawResult> continuation) {
        VoiceSubTaskCoordinator$createTaskWithRetry$1 voiceSubTaskCoordinator$createTaskWithRetry$1;
        VoiceSubTaskCoordinator voiceSubTaskCoordinator;
        int i;
        VoiceSubTaskCoordinator voiceSubTaskCoordinator2;
        Object obj;
        Ref.LongRef longRef;
        Ref.IntRef intRef;
        VoiceSubTaskCoordinator$createTaskWithRetry$1 voiceSubTaskCoordinator$createTaskWithRetry$12;
        CreateTaskRequest createTaskRequest2;
        String str2;
        VoiceSubTaskCoordinator voiceSubTaskCoordinator3;
        CreateTaskRequest createTaskRequest3;
        Ref.IntRef intRef2;
        Ref.LongRef longRef2;
        String str3;
        CreateTaskRawResult createTaskRawResult;
        HttpDataResult.Success boxLong;
        Long calculateCreateTaskRetryDelayMs$conversation_mainlandRelease;
        BizResponse bizResp;
        Object createAgentTaskRawCall;
        if (continuation instanceof VoiceSubTaskCoordinator$createTaskWithRetry$1) {
            voiceSubTaskCoordinator$createTaskWithRetry$1 = (VoiceSubTaskCoordinator$createTaskWithRetry$1) continuation;
            if ((voiceSubTaskCoordinator$createTaskWithRetry$1.label & Integer.MIN_VALUE) != 0) {
                voiceSubTaskCoordinator$createTaskWithRetry$1.label -= Integer.MIN_VALUE;
                voiceSubTaskCoordinator = this;
                Object obj2 = voiceSubTaskCoordinator$createTaskWithRetry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = voiceSubTaskCoordinator$createTaskWithRetry$1.label;
                HttpDataResult.Success success = null;
                int i2 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    voiceSubTaskCoordinator2 = voiceSubTaskCoordinator;
                    obj = coroutine_suspended;
                    longRef = new Ref.LongRef();
                    intRef = intRef3;
                    voiceSubTaskCoordinator$createTaskWithRetry$12 = voiceSubTaskCoordinator$createTaskWithRetry$1;
                    createTaskRequest2 = createTaskRequest;
                    str2 = str;
                    ICreateAgentTask.Companion companion = ICreateAgentTask.INSTANCE;
                    voiceSubTaskCoordinator$createTaskWithRetry$12.L$0 = voiceSubTaskCoordinator2;
                    voiceSubTaskCoordinator$createTaskWithRetry$12.L$1 = createTaskRequest2;
                    voiceSubTaskCoordinator$createTaskWithRetry$12.L$2 = str2;
                    voiceSubTaskCoordinator$createTaskWithRetry$12.L$3 = intRef;
                    voiceSubTaskCoordinator$createTaskWithRetry$12.L$4 = longRef;
                    voiceSubTaskCoordinator$createTaskWithRetry$12.L$5 = success;
                    voiceSubTaskCoordinator$createTaskWithRetry$12.label = i2;
                    createAgentTaskRawCall = companion.createAgentTaskRawCall(createTaskRequest2, voiceSubTaskCoordinator$createTaskWithRetry$12);
                    if (createAgentTaskRawCall != obj) {
                    }
                } else {
                    if (i == 1) {
                        Ref.LongRef longRef3 = (Ref.LongRef) voiceSubTaskCoordinator$createTaskWithRetry$1.L$4;
                        Ref.IntRef intRef4 = (Ref.IntRef) voiceSubTaskCoordinator$createTaskWithRetry$1.L$3;
                        String str4 = (String) voiceSubTaskCoordinator$createTaskWithRetry$1.L$2;
                        createTaskRequest3 = (CreateTaskRequest) voiceSubTaskCoordinator$createTaskWithRetry$1.L$1;
                        VoiceSubTaskCoordinator voiceSubTaskCoordinator4 = (VoiceSubTaskCoordinator) voiceSubTaskCoordinator$createTaskWithRetry$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        voiceSubTaskCoordinator3 = voiceSubTaskCoordinator4;
                        longRef2 = longRef3;
                        str3 = str4;
                        intRef2 = intRef4;
                        createTaskRawResult = (CreateTaskRawResult) obj2;
                        HttpDataResult.Success result = createTaskRawResult.getResult();
                        if (!(result instanceof HttpDataResult.Success)) {
                        }
                        if (r11 != null) {
                        }
                        if (boxLong == null) {
                            calculateCreateTaskRetryDelayMs$conversation_mainlandRelease = voiceSubTaskCoordinator3.calculateCreateTaskRetryDelayMs$conversation_mainlandRelease(intRef2.element, longRef2.element);
                            if (calculateCreateTaskRetryDelayMs$conversation_mainlandRelease != null) {
                            }
                        }
                        return createTaskRawResult;
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    CreateTaskRawResult createTaskRawResult2 = (CreateTaskRawResult) voiceSubTaskCoordinator$createTaskWithRetry$1.L$5;
                    Ref.LongRef longRef4 = (Ref.LongRef) voiceSubTaskCoordinator$createTaskWithRetry$1.L$4;
                    Ref.IntRef intRef5 = (Ref.IntRef) voiceSubTaskCoordinator$createTaskWithRetry$1.L$3;
                    String str5 = (String) voiceSubTaskCoordinator$createTaskWithRetry$1.L$2;
                    CreateTaskRequest createTaskRequest4 = (CreateTaskRequest) voiceSubTaskCoordinator$createTaskWithRetry$1.L$1;
                    VoiceSubTaskCoordinator voiceSubTaskCoordinator5 = (VoiceSubTaskCoordinator) voiceSubTaskCoordinator$createTaskWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    char c = 2;
                    createTaskRequest2 = createTaskRequest4;
                    CreateTaskRawResult createTaskRawResult3 = createTaskRawResult2;
                    voiceSubTaskCoordinator$createTaskWithRetry$12 = voiceSubTaskCoordinator$createTaskWithRetry$1;
                    str2 = str5;
                    voiceSubTaskCoordinator2 = voiceSubTaskCoordinator5;
                    obj = coroutine_suspended;
                    intRef = intRef5;
                    longRef = longRef4;
                    if (started) {
                        return createTaskRawResult3;
                    }
                    success = null;
                    i2 = 1;
                    ICreateAgentTask.Companion companion2 = ICreateAgentTask.INSTANCE;
                    voiceSubTaskCoordinator$createTaskWithRetry$12.L$0 = voiceSubTaskCoordinator2;
                    voiceSubTaskCoordinator$createTaskWithRetry$12.L$1 = createTaskRequest2;
                    voiceSubTaskCoordinator$createTaskWithRetry$12.L$2 = str2;
                    voiceSubTaskCoordinator$createTaskWithRetry$12.L$3 = intRef;
                    voiceSubTaskCoordinator$createTaskWithRetry$12.L$4 = longRef;
                    voiceSubTaskCoordinator$createTaskWithRetry$12.L$5 = success;
                    voiceSubTaskCoordinator$createTaskWithRetry$12.label = i2;
                    createAgentTaskRawCall = companion2.createAgentTaskRawCall(createTaskRequest2, voiceSubTaskCoordinator$createTaskWithRetry$12);
                    if (createAgentTaskRawCall != obj) {
                        return obj;
                    }
                    voiceSubTaskCoordinator3 = voiceSubTaskCoordinator2;
                    createTaskRequest3 = createTaskRequest2;
                    obj2 = createAgentTaskRawCall;
                    VoiceSubTaskCoordinator$createTaskWithRetry$1 voiceSubTaskCoordinator$createTaskWithRetry$13 = voiceSubTaskCoordinator$createTaskWithRetry$12;
                    str3 = str2;
                    voiceSubTaskCoordinator$createTaskWithRetry$1 = voiceSubTaskCoordinator$createTaskWithRetry$13;
                    Ref.LongRef longRef5 = longRef;
                    intRef2 = intRef;
                    coroutine_suspended = obj;
                    longRef2 = longRef5;
                    createTaskRawResult = (CreateTaskRawResult) obj2;
                    HttpDataResult.Success result2 = createTaskRawResult.getResult();
                    HttpDataResult.Success success2 = !(result2 instanceof HttpDataResult.Success) ? result2 : success;
                    boxLong = (success2 != null || (bizResp = success2.getBizResp()) == null) ? success : Boxing.boxLong(bizResp.getCode());
                    if (boxLong == null || boxLong.longValue() != CREATE_TASK_RETRYABLE_BIZ_CODE) {
                        return createTaskRawResult;
                    }
                    calculateCreateTaskRetryDelayMs$conversation_mainlandRelease = voiceSubTaskCoordinator3.calculateCreateTaskRetryDelayMs$conversation_mainlandRelease(intRef2.element, longRef2.element);
                    if (calculateCreateTaskRetryDelayMs$conversation_mainlandRelease != null) {
                        FLogger.INSTANCE.w(TAG, "createTaskWithRetry[exhausted]: sourceTaskId=" + str3 + ", bizCode=" + boxLong + ", retries=" + intRef2.element + ", elapsedDelayMs=" + longRef2.element);
                        return createTaskRawResult;
                    }
                    long longValue = calculateCreateTaskRetryDelayMs$conversation_mainlandRelease.longValue();
                    intRef2.element += i2;
                    Object obj3 = coroutine_suspended;
                    longRef2.element += longValue;
                    FLogger.INSTANCE.w(TAG, "createTaskWithRetry[retry]: sourceTaskId=" + str3 + ", bizCode=" + boxLong + ", retry=" + intRef2.element + "/15, delayMs=" + longValue + ", elapsedDelayMs=" + longRef2.element);
                    voiceSubTaskCoordinator$createTaskWithRetry$1.L$0 = voiceSubTaskCoordinator3;
                    voiceSubTaskCoordinator$createTaskWithRetry$1.L$1 = createTaskRequest3;
                    voiceSubTaskCoordinator$createTaskWithRetry$1.L$2 = str3;
                    voiceSubTaskCoordinator$createTaskWithRetry$1.L$3 = intRef2;
                    voiceSubTaskCoordinator$createTaskWithRetry$1.L$4 = longRef2;
                    voiceSubTaskCoordinator$createTaskWithRetry$1.L$5 = createTaskRawResult;
                    c = 2;
                    voiceSubTaskCoordinator$createTaskWithRetry$1.label = 2;
                    if (DelayKt.delay(longValue, voiceSubTaskCoordinator$createTaskWithRetry$1) == obj3) {
                        return obj3;
                    }
                    intRef = intRef2;
                    longRef = longRef2;
                    obj = obj3;
                    createTaskRawResult3 = createTaskRawResult;
                    createTaskRequest2 = createTaskRequest3;
                    voiceSubTaskCoordinator2 = voiceSubTaskCoordinator3;
                    String str6 = str3;
                    voiceSubTaskCoordinator$createTaskWithRetry$12 = voiceSubTaskCoordinator$createTaskWithRetry$1;
                    str2 = str6;
                    if (started) {
                    }
                }
            }
        }
        voiceSubTaskCoordinator = this;
        voiceSubTaskCoordinator$createTaskWithRetry$1 = new VoiceSubTaskCoordinator$createTaskWithRetry$1(voiceSubTaskCoordinator, continuation);
        Object obj22 = voiceSubTaskCoordinator$createTaskWithRetry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = voiceSubTaskCoordinator$createTaskWithRetry$1.label;
        HttpDataResult.Success success3 = null;
        int i22 = 1;
        if (i != 0) {
        }
    }

    public final String buildSubTaskQueryJson$conversation_mainlandRelease(SubTaskRequestMessage req) {
        Intrinsics.checkNotNullParameter(req, "req");
        String json = new Gson().toJson(buildSubTaskQueryParts$conversation_mainlandRelease(req));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public final List<QueryItem> buildSubTaskQueryParts$conversation_mainlandRelease(SubTaskRequestMessage req) {
        Intrinsics.checkNotNullParameter(req, "req");
        ArrayList arrayList = new ArrayList();
        if (!StringsKt.isBlank(req.getTaskDescription())) {
            arrayList.add(QueryItem.INSTANCE.text(req.getTaskDescription()));
        }
        arrayList.addAll(INSTANCE.normalizeSubTaskFilesForCreate$conversation_mainlandRelease(req.getFiles()));
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0024 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<QueryItem> normalizeSubTaskFilesForCreate$conversation_mainlandRelease(List<QueryItem> files) {
        String normalizeAttachmentUriForCreate;
        String normalizeImageIdForCreate$conversation_mainlandRelease;
        List<QueryItem> list = files;
        if (list == null || list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (QueryItem queryItem : files) {
            String type = queryItem.getType();
            QueryItem queryItem2 = null;
            if (Intrinsics.areEqual(type, "image")) {
                VoiceSubTaskCoordinator voiceSubTaskCoordinator = INSTANCE;
                String dataString = voiceSubTaskCoordinator.dataString(queryItem.getData(), "image_id", "imageId", "uri");
                if (dataString != null && (normalizeImageIdForCreate$conversation_mainlandRelease = voiceSubTaskCoordinator.normalizeImageIdForCreate$conversation_mainlandRelease(dataString)) != null) {
                    if (!(!StringsKt.isBlank(normalizeImageIdForCreate$conversation_mainlandRelease))) {
                        normalizeImageIdForCreate$conversation_mainlandRelease = null;
                    }
                    if (normalizeImageIdForCreate$conversation_mainlandRelease != null) {
                        queryItem = QueryItem.Companion.image$default(QueryItem.INSTANCE, normalizeImageIdForCreate$conversation_mainlandRelease, null, 2, null);
                        queryItem2 = queryItem;
                    }
                }
                if (queryItem2 != null) {
                    arrayList.add(queryItem2);
                }
            } else {
                if (Intrinsics.areEqual(type, "attachment")) {
                    VoiceSubTaskCoordinator voiceSubTaskCoordinator2 = INSTANCE;
                    String dataString2 = voiceSubTaskCoordinator2.dataString(queryItem.getData(), "uri", "tos_oid", "tosOid");
                    if (dataString2 != null && (normalizeAttachmentUriForCreate = voiceSubTaskCoordinator2.normalizeAttachmentUriForCreate(dataString2)) != null) {
                        String str = StringsKt.isBlank(normalizeAttachmentUriForCreate) ^ true ? normalizeAttachmentUriForCreate : null;
                        if (str != null) {
                            QueryItem.Companion companion = QueryItem.INSTANCE;
                            String dataString3 = voiceSubTaskCoordinator2.dataString(queryItem.getData(), "filename", "file_name", "name");
                            if (dataString3 == null) {
                                dataString3 = "";
                            }
                            String str2 = dataString3;
                            Long dataLong = voiceSubTaskCoordinator2.dataLong(queryItem.getData(), "file_size", "fileSize");
                            long longValue = dataLong != null ? dataLong.longValue() : 0L;
                            Object data = queryItem.getData();
                            String[] strArr = CHAT_SESSION_ID_KEYS;
                            queryItem = companion.attachment(str, str2, longValue, voiceSubTaskCoordinator2.dataString(data, (String[]) Arrays.copyOf(strArr, strArr.length)));
                        }
                    }
                    if (queryItem2 != null) {
                    }
                }
                queryItem2 = queryItem;
                if (queryItem2 != null) {
                }
            }
        }
        return arrayList;
    }

    public final String normalizeImageIdForCreate$conversation_mainlandRelease(String raw) {
        Intrinsics.checkNotNullParameter(raw, AccountMonitorConstants.CommonParameter.RAW);
        return StringsKt.removePrefix(StringsKt.trim(raw).toString(), TRAE_RES_PREFIX);
    }

    private final String normalizeAttachmentUriForCreate(String raw) {
        String obj = StringsKt.trim(raw).toString();
        return (!StringsKt.startsWith$default(obj, TRAE_RES_PREFIX, false, 2, (Object) null) && StringsKt.startsWith$default(obj, "tos-", false, 2, (Object) null)) ? REMOTE_RESOURCE_PREFIX + obj : obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if ((!kotlin.text.StringsKt.isBlank(r3)) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String dataString(Object data, String... keys) {
        String str;
        JsonObject dataJsonObject = dataJsonObject(data);
        if (dataJsonObject == null) {
            return null;
        }
        for (String str2 : keys) {
            JsonElement jsonElement = dataJsonObject.get(str2);
            if (jsonElement != null) {
                if (!jsonElement.isJsonPrimitive()) {
                    jsonElement = null;
                }
                if (jsonElement != null) {
                    str = jsonElement.getAsString();
                    if (str != null) {
                    }
                }
            }
            str = null;
            if (str != null) {
                return str;
            }
        }
        return null;
    }

    private final Long dataLong(Object data, String... keys) {
        JsonPrimitive asJsonPrimitive;
        Long l;
        JsonObject dataJsonObject = dataJsonObject(data);
        if (dataJsonObject == null) {
            return null;
        }
        for (String str : keys) {
            JsonElement jsonElement = dataJsonObject.get(str);
            if (jsonElement != null) {
                if (!jsonElement.isJsonPrimitive()) {
                    jsonElement = null;
                }
                if (jsonElement != null && (asJsonPrimitive = jsonElement.getAsJsonPrimitive()) != null) {
                    if (asJsonPrimitive.isNumber()) {
                        l = Long.valueOf(asJsonPrimitive.getAsLong());
                    } else if (asJsonPrimitive.isString()) {
                        String asString = asJsonPrimitive.getAsString();
                        Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
                        l = StringsKt.toLongOrNull(asString);
                    } else {
                        l = null;
                    }
                    if (l != null) {
                        return l;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JsonObject dataJsonObject(Object data) {
        Object obj;
        JsonElement jsonTree;
        JsonObject jsonObject;
        if (data instanceof JsonObject) {
            return (JsonObject) data;
        }
        if (data == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            VoiceSubTaskCoordinator voiceSubTaskCoordinator = this;
            jsonTree = new Gson().toJsonTree(data);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (jsonTree != null) {
            if (!jsonTree.isJsonObject()) {
                jsonTree = null;
            }
            if (jsonTree != null) {
                jsonObject = jsonTree.getAsJsonObject();
                obj = Result.constructor-impl(jsonObject);
                return (JsonObject) (Result.isFailure-impl(obj) ? null : obj);
            }
        }
        jsonObject = null;
        obj = Result.constructor-impl(jsonObject);
        return (JsonObject) (Result.isFailure-impl(obj) ? null : obj);
    }

    private final void startTimer(long timeoutMs, String sourceTaskId) {
        cancelTimer();
        FLogger.INSTANCE.d(TAG, "startTimer: sourceTaskId=" + sourceTaskId + ", timeoutMs=" + timeoutMs);
        timeoutJob = BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VoiceSubTaskCoordinator$startTimer$1(timeoutMs, sourceTaskId, null), 3, (Object) null);
    }

    private final void cancelTimer() {
        if (timeoutJob != null) {
            FLogger.INSTANCE.d(TAG, "cancelTimer");
        }
        Job job = timeoutJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        timeoutJob = null;
    }

    private final void startLongRunningJob(String sourceTaskId) {
        cancelLongRunningJob();
        longRunningJob = BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VoiceSubTaskCoordinator$startLongRunningJob$1(sourceTaskId, null), 3, (Object) null);
    }

    private final void cancelLongRunningJob() {
        if (longRunningJob != null) {
            FLogger.INSTANCE.d(TAG, "cancelLongRunningJob");
        }
        Job job = longRunningJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        longRunningJob = null;
    }

    private final void failActiveTask(String sourceTaskId, String reason) {
        SubTaskUiState copy;
        MutableStateFlow<SubTaskUiState> mutableStateFlow = _activeTask;
        SubTaskUiState subTaskUiState = (SubTaskUiState) mutableStateFlow.getValue();
        if (subTaskUiState != null && Intrinsics.areEqual(subTaskUiState.getSourceTaskId(), sourceTaskId)) {
            FLogger.INSTANCE.w(TAG, "failActiveTask: sourceTaskId=" + sourceTaskId + ", prev=" + subTaskUiState.getState() + ", executor=" + subTaskUiState.getExecutor() + ", reason=" + reason);
            cancelTimer();
            cancelLongRunningJob();
            copy = subTaskUiState.copy((r28 & 1) != 0 ? subTaskUiState.sourceTaskId : null, (r28 & 2) != 0 ? subTaskUiState.taskDescription : null, (r28 & 4) != 0 ? subTaskUiState.localTaskId : null, (r28 & 8) != 0 ? subTaskUiState.proxyConversationId : null, (r28 & 16) != 0 ? subTaskUiState.proxyChatSessionId : null, (r28 & 32) != 0 ? subTaskUiState.state : SubTaskRenderState.Failed, (r28 & 64) != 0 ? subTaskUiState.content : null, (r28 & 128) != 0 ? subTaskUiState.failureReason : reason, (r28 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? subTaskUiState.createStartedAtMs : 0L, (r28 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? subTaskUiState.longRunning : false, (r28 & 1024) != 0 ? subTaskUiState.executor : null, (r28 & 2048) != 0 ? subTaskUiState.toolName : null);
            mutableStateFlow.setValue(copy);
        }
    }

    static /* synthetic */ void failActiveTaskAndReport$default(VoiceSubTaskCoordinator voiceSubTaskCoordinator, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        voiceSubTaskCoordinator.failActiveTaskAndReport(str, str2, str3);
    }

    private final void failActiveTaskAndReport(String sourceTaskId, String reason, String error) {
        SubTaskUiState subTaskUiState = (SubTaskUiState) _activeTask.getValue();
        if (subTaskUiState != null && Intrinsics.areEqual(subTaskUiState.getSourceTaskId(), sourceTaskId)) {
            Long valueOf = Long.valueOf(subTaskUiState.getCreateStartedAtMs());
            if (!(valueOf.longValue() > 0)) {
                valueOf = null;
            }
            long coerceAtLeast = valueOf != null ? RangesKt.coerceAtLeast(System.currentTimeMillis() - valueOf.longValue(), 0L) : 0L;
            boolean z = subTaskUiState.getExecutor() == SubTaskExecutor.ClientProxy;
            failActiveTask(sourceTaskId, reason);
            if (z) {
                reportLocalSubtaskEnd$default(this, subTaskUiState, "failed", reason, null, false, 16, null);
                postSubTaskResultOnceAsync(sourceTaskId, "failed", "", coerceAtLeast, reason, error, "fail-active-task");
            }
        }
    }

    private final boolean postToBotLLM(String messageJson, int interruptMode) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Command", "ExternalTextToLLM");
        jSONObject.put(ServiceType.f1279IM, messageJson);
        jSONObject.put("InterruptMode", interruptMode);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        byte[] buildBinaryMessage = SubtitleBinaryProtocol.INSTANCE.buildBinaryMessage("ctrl", jSONObject2);
        Function1<? super byte[], Unit> function1 = sendAckToBot;
        if (function1 == null) {
            FLogger.INSTANCE.d(TAG, "postToBotLLM: no callback (P1), would send=" + jSONObject2);
            return false;
        }
        try {
            function1.invoke(buildBinaryMessage);
            FLogger.INSTANCE.d(TAG, "postToBotLLM: sent, payloadLen=" + messageJson.length() + ", interruptMode=" + interruptMode);
            return true;
        } catch (Throwable th) {
            FLogger.INSTANCE.w(TAG, "postToBotLLM: failed", th);
            return false;
        }
    }

    private final void markCreatePostStart(String sourceTaskId) {
        SubTaskUiState copy;
        long currentTimeMillis = System.currentTimeMillis();
        MutableStateFlow<SubTaskUiState> mutableStateFlow = _activeTask;
        SubTaskUiState subTaskUiState = (SubTaskUiState) mutableStateFlow.getValue();
        if (subTaskUiState != null && Intrinsics.areEqual(subTaskUiState.getSourceTaskId(), sourceTaskId) && subTaskUiState.getCreateStartedAtMs() <= 0) {
            copy = subTaskUiState.copy((r28 & 1) != 0 ? subTaskUiState.sourceTaskId : null, (r28 & 2) != 0 ? subTaskUiState.taskDescription : null, (r28 & 4) != 0 ? subTaskUiState.localTaskId : null, (r28 & 8) != 0 ? subTaskUiState.proxyConversationId : null, (r28 & 16) != 0 ? subTaskUiState.proxyChatSessionId : null, (r28 & 32) != 0 ? subTaskUiState.state : null, (r28 & 64) != 0 ? subTaskUiState.content : null, (r28 & 128) != 0 ? subTaskUiState.failureReason : null, (r28 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? subTaskUiState.createStartedAtMs : currentTimeMillis, (r28 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? subTaskUiState.longRunning : false, (r28 & 1024) != 0 ? subTaskUiState.executor : null, (r28 & 2048) != 0 ? subTaskUiState.toolName : null);
            mutableStateFlow.setValue(copy);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void postSubTaskResultOnceAsync$default(VoiceSubTaskCoordinator voiceSubTaskCoordinator, String str, String str2, String str3, long j, String str4, String str5, String str6, int i, Object obj) {
        voiceSubTaskCoordinator.postSubTaskResultOnceAsync(str, str2, str3, j, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? null : str5, str6);
    }

    private final void postSubTaskResultOnceAsync(String taskId, String status, String result, long durationMs, String errorCode, String error, String scene) {
        if (StringsKt.isBlank(taskId)) {
            FLogger.INSTANCE.w(TAG, "postSubTaskResult[" + scene + "]: skip blank taskId status=" + status);
            return;
        }
        String resolveReportTaskId = resolveReportTaskId(taskId);
        if (!Intrinsics.areEqual(resolveReportTaskId, taskId)) {
            FLogger.INSTANCE.w(TAG, "postSubTaskResult[" + scene + "]: alias taskId=" + taskId + " reportAs=" + resolveReportTaskId);
        }
        boolean markSubTaskResultReportStarted = markSubTaskResultReportStarted(resolveReportTaskId);
        String firstNonBlank = firstNonBlank(error, m858xbacc5332(this, errorCode, StringsKt.toIntOrNull(errorCode), null, null, null, null, null, 64, null));
        if (!markSubTaskResultReportStarted) {
            FLogger.INSTANCE.w(TAG, "postSubTaskResult[" + scene + "]: skip-duplicate taskId=" + resolveReportTaskId + " status=" + status + " durationMs=" + durationMs + " errorCode=" + errorCode + " resultLen=" + result.length() + " errorLen=" + (firstNonBlank != null ? firstNonBlank.length() : 0));
        } else {
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1(resolveReportTaskId, result, status, errorCode, durationMs, firstNonBlank, scene, null), 3, (Object) null);
        }
    }

    private final boolean markSubTaskResultReportStarted(String taskId) {
        boolean z;
        String str;
        synchronized (subTaskResultReportLock) {
            LinkedHashSet<String> linkedHashSet = subTaskResultReportedTaskIds;
            if (linkedHashSet.contains(taskId)) {
                z = false;
            } else {
                linkedHashSet.add(taskId);
                while (true) {
                    LinkedHashSet<String> linkedHashSet2 = subTaskResultReportedTaskIds;
                    if (linkedHashSet2.size() <= 256 || (str = (String) CollectionsKt.firstOrNull(linkedHashSet2)) == null) {
                        break;
                    }
                    linkedHashSet2.remove(str);
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearSubTaskResultReportStarted(String taskId) {
        synchronized (subTaskResultReportLock) {
            subTaskResultReportedTaskIds.remove(taskId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markCreateTaskRetryableBizErrorSuppressed(String taskId) {
        String str;
        if (StringsKt.isBlank(taskId)) {
            return;
        }
        synchronized (createTaskBizErrorSuppressLock) {
            createTaskBizErrorSuppressedTaskIds.add(taskId);
            while (true) {
                LinkedHashSet<String> linkedHashSet = createTaskBizErrorSuppressedTaskIds;
                if (linkedHashSet.size() <= 256 || (str = (String) CollectionsKt.firstOrNull(linkedHashSet)) == null) {
                    break;
                } else {
                    linkedHashSet.remove(str);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void clearCreateTaskRetryableBizErrorSuppressed(String taskId) {
        synchronized (createTaskBizErrorSuppressLock) {
            createTaskBizErrorSuppressedTaskIds.remove(taskId);
        }
    }

    private final boolean shouldSuppressCreateTaskBizError(String sourceTaskId, long bizCode) {
        boolean remove;
        if (bizCode != CREATE_TASK_RETRYABLE_BIZ_CODE) {
            return false;
        }
        synchronized (createTaskBizErrorSuppressLock) {
            remove = createTaskBizErrorSuppressedTaskIds.remove(sourceTaskId);
        }
        return remove || (Intrinsics.areEqual(resolveReportTaskId(sourceTaskId), sourceTaskId) ^ true);
    }

    private final boolean isSubTaskResultReported(String taskId) {
        boolean contains;
        synchronized (subTaskResultReportLock) {
            contains = subTaskResultReportedTaskIds.contains(taskId);
        }
        return contains;
    }

    public static /* synthetic */ CreateTaskRequest createTaskRequest$conversation_mainlandRelease$default(VoiceSubTaskCoordinator voiceSubTaskCoordinator, ProxyConversationConfig proxyConversationConfig, String str, String str2, String str3, String str4, Source source, VoiceSubTaskConfig voiceSubTaskConfig, boolean z, int i, Object obj) {
        return voiceSubTaskCoordinator.createTaskRequest$conversation_mainlandRelease(proxyConversationConfig, str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : source, (i & 64) != 0 ? subTaskConfig : voiceSubTaskConfig, (i & 128) != 0 ? TocCreditsPolicy.INSTANCE.isEnabled() : z);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CreateTaskRequest createTaskRequest$conversation_mainlandRelease(ProxyConversationConfig cfg, String conversationId, String queryJson, String parentConversationId2, String hiddenStatus, Source source, VoiceSubTaskConfig runtimeSubTaskConfig, boolean creditsFeatureEnabled) {
        ModelSelectionStrategy modelSelectionStrategy;
        String str;
        String str2;
        List list;
        ArrayList arrayList;
        List<JsonObject> models;
        Intrinsics.checkNotNullParameter(cfg, "cfg");
        JsonObject resolveSubTaskModelConfig$conversation_mainlandRelease = resolveSubTaskModelConfig$conversation_mainlandRelease(runtimeSubTaskConfig, cfg.getMode());
        InitialMessage initialMessage = null;
        if (resolveSubTaskModelConfig$conversation_mainlandRelease == null) {
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder append = new StringBuilder("createTaskRequest: sub_task_config.models missing current mode=").append(cfg.getMode().getValue()).append(", available=");
            if (runtimeSubTaskConfig == null || (models = runtimeSubTaskConfig.getModels()) == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = models.iterator();
                while (it.hasNext()) {
                    String readStringProperty = INSTANCE.readStringProperty((JsonObject) it.next(), "name");
                    if (readStringProperty != null) {
                        arrayList2.add(readStringProperty);
                    }
                }
                arrayList = arrayList2;
            }
            fLogger.w(TAG, append.append(arrayList).toString());
        }
        String readStringProperty2 = readStringProperty(resolveSubTaskModelConfig$conversation_mainlandRelease, "name");
        String str3 = (readStringProperty2 == null || !(StringsKt.isBlank(readStringProperty2) ^ true)) ? null : readStringProperty2;
        if (str3 == null) {
            modelSelectionStrategy = ModelSelectionStrategy.AUTO;
        } else {
            modelSelectionStrategy = ModelSelectionStrategy.MANUAL;
        }
        ModelSelectionStrategy modelSelectionStrategy2 = modelSelectionStrategy;
        String cliId = cfg.getCliId();
        if (cliId != null) {
            String str4 = cliId;
            if (str4.length() == 0) {
                str4 = null;
            }
            str = str4;
        } else {
            str = null;
        }
        CliType cliType = cfg.getCliType();
        String value = cfg.getMode().getValue();
        String workspaceDir = cfg.getWorkspaceDir();
        if (workspaceDir != null) {
            String str5 = workspaceDir;
            if (str5.length() == 0) {
                str5 = null;
            }
            str2 = str5;
        } else {
            str2 = null;
        }
        String workspaceDir2 = cfg.getWorkspaceDir();
        if (workspaceDir2 != null) {
            if (!(workspaceDir2.length() > 0)) {
                workspaceDir2 = null;
            }
            if (workspaceDir2 != null) {
                list = CollectionsKt.listOf(workspaceDir2);
                if (queryJson != null) {
                    List emptyList = CollectionsKt.emptyList();
                    JsonObject buildSubTaskCustomModel$conversation_mainlandRelease = INSTANCE.buildSubTaskCustomModel$conversation_mainlandRelease(resolveSubTaskModelConfig$conversation_mainlandRelease);
                    Boolean bool = false;
                    bool.booleanValue();
                    initialMessage = new InitialMessage(emptyList, null, str3, SUB_TASK_AGENT_TYPE, queryJson, modelSelectionStrategy2, buildSubTaskCustomModel$conversation_mainlandRelease, null, creditsFeatureEnabled ? bool : null, 130, null);
                }
                return new CreateTaskRequest(conversationId, parentConversationId2, null, hiddenStatus, str, cliType, value, null, str2, list, false, initialMessage, source, "mobile", null, null, 50308, null);
            }
        }
        list = null;
        if (queryJson != null) {
        }
        return new CreateTaskRequest(conversationId, parentConversationId2, null, hiddenStatus, str, cliType, value, null, str2, list, false, initialMessage, source, "mobile", null, null, 50308, null);
    }

    private final String extractContent(ParsedChatMessage message) {
        List<ParsedPlanItemMessage> messages;
        String str;
        ParsedTaskContent taskContent = message.getTaskContent();
        if (taskContent == null || (messages = taskContent.getMessages()) == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = messages.iterator();
        while (it.hasNext()) {
            ParsedPlanItem planItem = ((ParsedPlanItemMessage) it.next()).getPlanItem();
            if (planItem != null) {
                arrayList.add(planItem);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return "";
        }
        String str2 = (String) SequencesKt.lastOrNull(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(arrayList2), new Function1() { // from class: com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean extractContent$lambda$73;
                extractContent$lambda$73 = VoiceSubTaskCoordinator.extractContent$lambda$73((ParsedPlanItem) obj);
                return Boolean.valueOf(extractContent$lambda$73);
            }
        }), new Function1() { // from class: com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                String extractContent$lambda$76;
                extractContent$lambda$76 = VoiceSubTaskCoordinator.extractContent$lambda$76((ParsedPlanItem) obj);
                return extractContent$lambda$76;
            }
        }));
        String str3 = str2;
        if (!(str3 == null || str3.length() == 0)) {
            return str2;
        }
        Iterator it2 = CollectionsKt.asReversed(arrayList2).iterator();
        do {
            str = null;
            if (!it2.hasNext()) {
                break;
            }
            String thought = ((ParsedPlanItem) it2.next()).getThought();
            if (thought != null && (!StringsKt.isBlank(thought))) {
                str = thought;
            }
        } while (str == null);
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean extractContent$lambda$73(ParsedPlanItem parsedPlanItem) {
        Intrinsics.checkNotNullParameter(parsedPlanItem, "it");
        Set<String> set = FINISH_TOOLS;
        ParsedToolCallInfo toolCallInfo = parsedPlanItem.getToolCallInfo();
        return CollectionsKt.contains(set, toolCallInfo != null ? toolCallInfo.getName() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractContent$lambda$76(ParsedPlanItem parsedPlanItem) {
        JsonObject params;
        JsonElement jsonElement;
        String asString;
        Intrinsics.checkNotNullParameter(parsedPlanItem, "it");
        ParsedToolCallInfo toolCallInfo = parsedPlanItem.getToolCallInfo();
        if (toolCallInfo == null || (params = toolCallInfo.getParams()) == null || (jsonElement = params.get("summary")) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null || (asString = jsonElement.getAsString()) == null || !(!StringsKt.isBlank(asString))) {
            return null;
        }
        return asString;
    }

    public final JsonObject resolveSubTaskModelConfig$conversation_mainlandRelease(VoiceSubTaskConfig config2, Mode mode) {
        List<JsonObject> models;
        Intrinsics.checkNotNullParameter(mode, "mode");
        String value = mode.getValue();
        Object obj = null;
        if (config2 == null || (models = config2.getModels()) == null) {
            return null;
        }
        Iterator<T> it = models.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String readStringProperty = INSTANCE.readStringProperty((JsonObject) next, "name");
            boolean z = false;
            if (readStringProperty != null && StringsKt.equals(readStringProperty, value, true)) {
                z = true;
            }
            if (z) {
                obj = next;
                break;
            }
        }
        return (JsonObject) obj;
    }

    public final JsonObject buildSubTaskCustomModel$conversation_mainlandRelease(JsonObject modelConfig) {
        String str = null;
        if (modelConfig == null) {
            return null;
        }
        JsonObject asJsonObject = modelConfig.deepCopy().getAsJsonObject();
        String readStringProperty = readStringProperty(asJsonObject, "name");
        boolean z = true;
        if (readStringProperty != null && (!StringsKt.isBlank(readStringProperty))) {
            str = readStringProperty;
        }
        if (str != null) {
            asJsonObject.addProperty("config_name", str);
            String readStringProperty2 = readStringProperty(asJsonObject, "model_name");
            if (readStringProperty2 != null && !StringsKt.isBlank(readStringProperty2)) {
                z = false;
            }
            if (z) {
                asJsonObject.addProperty("model_name", str);
            }
        }
        if (!asJsonObject.has("is_preset") || asJsonObject.get("is_preset").isJsonNull()) {
            asJsonObject.addProperty("is_preset", false);
        }
        return asJsonObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String readStringProperty(JsonObject obj, String key) {
        Object obj2;
        String str;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            VoiceSubTaskCoordinator voiceSubTaskCoordinator = this;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (obj != null && (jsonElement = obj.get(key)) != null) {
            if (jsonElement.isJsonNull()) {
                jsonElement = null;
            }
            if (jsonElement != null && (str = jsonElement.getAsString()) != null && (!StringsKt.isBlank(str))) {
                obj2 = Result.constructor-impl(str);
                return (String) (Result.isFailure-impl(obj2) ? null : obj2);
            }
        }
        str = null;
        obj2 = Result.constructor-impl(str);
        return (String) (Result.isFailure-impl(obj2) ? null : obj2);
    }

    /* compiled from: VoiceSubTaskCoordinator.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$CreateTaskFailureReport;", "", AccountMonitorConstants.CommonParameter.ERROR, "", "error", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/String;", "getError", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class CreateTaskFailureReport {
        private final String error;
        private final String errorCode;

        public static /* synthetic */ CreateTaskFailureReport copy$default(CreateTaskFailureReport createTaskFailureReport, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = createTaskFailureReport.errorCode;
            }
            if ((i & 2) != 0) {
                str2 = createTaskFailureReport.error;
            }
            return createTaskFailureReport.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: component2, reason: from getter */
        public final String getError() {
            return this.error;
        }

        public final CreateTaskFailureReport copy(String errorCode, String error) {
            Intrinsics.checkNotNullParameter(errorCode, AccountMonitorConstants.CommonParameter.ERROR);
            return new CreateTaskFailureReport(errorCode, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateTaskFailureReport)) {
                return false;
            }
            CreateTaskFailureReport createTaskFailureReport = (CreateTaskFailureReport) other;
            return Intrinsics.areEqual(this.errorCode, createTaskFailureReport.errorCode) && Intrinsics.areEqual(this.error, createTaskFailureReport.error);
        }

        public int hashCode() {
            int hashCode = this.errorCode.hashCode() * 31;
            String str = this.error;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "CreateTaskFailureReport(errorCode=" + this.errorCode + ", error=" + this.error + ')';
        }

        public CreateTaskFailureReport(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, AccountMonitorConstants.CommonParameter.ERROR);
            this.errorCode = str;
            this.error = str2;
        }

        public final String getErrorCode() {
            return this.errorCode;
        }

        public final String getError() {
            return this.error;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreateTaskFailureReport buildSseFailureReport$conversation_mainlandRelease$default(VoiceSubTaskCoordinator voiceSubTaskCoordinator, ParsedChatMessage parsedChatMessage, String str, Function4 function4, int i, Object obj) {
        if ((i & 4) != 0) {
            function4 = null;
        }
        return voiceSubTaskCoordinator.buildSseFailureReport$conversation_mainlandRelease(parsedChatMessage, str, function4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        if (r0 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CreateTaskFailureReport buildSseFailureReport$conversation_mainlandRelease(ParsedChatMessage message, String fallbackReason, Function4<? super Integer, ? super String, ? super JsonObject, ? super String, String> displayMessageResolver) {
        String firstNonBlank;
        Integer code;
        Intrinsics.checkNotNullParameter(message, "message");
        ParsedError error = message.getError();
        if (error != null && (code = error.getCode()) != null && (firstNonBlank = code.toString()) != null) {
            if (!(!StringsKt.isBlank(firstNonBlank))) {
                firstNonBlank = null;
            }
        }
        firstNonBlank = firstNonBlank(message.getStatus(), fallbackReason);
        if (firstNonBlank == null) {
            firstNonBlank = "task_failed";
        }
        ParsedError error2 = message.getError();
        Integer code2 = error2 != null ? error2.getCode() : null;
        ParsedError error3 = message.getError();
        String message2 = error3 != null ? error3.getMessage() : null;
        ParsedError error4 = message.getError();
        String resolveSubTaskFailureMessage$conversation_mainlandRelease = resolveSubTaskFailureMessage$conversation_mainlandRelease(firstNonBlank, code2, message2, error4 != null ? error4.getData() : null, fallbackReason, message.getStatus(), displayMessageResolver);
        if (resolveSubTaskFailureMessage$conversation_mainlandRelease == null) {
            resolveSubTaskFailureMessage$conversation_mainlandRelease = firstNonBlank;
        }
        return new CreateTaskFailureReport(firstNonBlank, resolveSubTaskFailureMessage$conversation_mainlandRelease);
    }

    /* renamed from: buildCreateTaskFailureReport$conversation_mainlandRelease$default */
    public static /* synthetic */ CreateTaskFailureReport m856x235a44b9(VoiceSubTaskCoordinator voiceSubTaskCoordinator, CreateTaskRawResult createTaskRawResult, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return voiceSubTaskCoordinator.buildCreateTaskFailureReport$conversation_mainlandRelease(createTaskRawResult, str, z);
    }

    public final CreateTaskFailureReport buildCreateTaskFailureReport$conversation_mainlandRelease(CreateTaskRawResult raw, String fallbackCode, boolean suppressBizError) {
        CreateTaskFailureReport createTaskFailureReport;
        Intrinsics.checkNotNullParameter(raw, AccountMonitorConstants.CommonParameter.RAW);
        Intrinsics.checkNotNullParameter(fallbackCode, "fallbackCode");
        HttpDataResult.Success result = raw.getResult();
        if (result instanceof HttpDataResult.Success) {
            BizResponse bizResp = result.getBizResp();
            boolean z = (suppressBizError || isCreateTaskBizSuccess$conversation_mainlandRelease(bizResp.getCode())) ? false : true;
            String valueOf = z ? String.valueOf(bizResp.getCode()) : fallbackCode;
            if (z) {
                String firstNonBlankErrorMessage = firstNonBlankErrorMessage(bizResp.getMessage(), bizResp.getMsg(), bizResp.getActivityMessage(), bizResp.getPayload());
                if (firstNonBlankErrorMessage != null) {
                    fallbackCode = firstNonBlankErrorMessage;
                }
            } else {
                fallbackCode = null;
            }
            createTaskFailureReport = new CreateTaskFailureReport(valueOf, fallbackCode);
        } else {
            if (!(result instanceof HttpDataResult.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            String[] strArr = new String[2];
            HttpDataResult.Error error = (HttpDataResult.Error) result;
            strArr[0] = error.getMsg();
            Throwable throwable = error.getThrowable();
            strArr[1] = throwable != null ? throwable.getMessage() : null;
            String firstNonBlank = firstNonBlank(strArr);
            if (firstNonBlank == null) {
                firstNonBlank = fallbackCode;
            }
            createTaskFailureReport = new CreateTaskFailureReport(fallbackCode, firstNonBlank);
        }
        return createTaskFailureReport;
    }

    private final String buildCreateTaskMissingFieldError(String fieldName, long bizCode, String message) {
        StringBuilder sb = new StringBuilder("tasks/create response missing ");
        sb.append(fieldName);
        sb.append("; biz_code=");
        sb.append(bizCode);
        boolean z = true;
        if (message == null || StringsKt.equals(message, "success", true)) {
            message = null;
        }
        String str = message;
        if (str != null && !StringsKt.isBlank(str)) {
            z = false;
        }
        if (!z) {
            sb.append("; message=");
            sb.append(message);
        }
        return sb.toString();
    }

    /* renamed from: resolveSubTaskFailureMessage$conversation_mainlandRelease$default */
    public static /* synthetic */ String m858xbacc5332(VoiceSubTaskCoordinator voiceSubTaskCoordinator, String str, Integer num, String str2, JsonObject jsonObject, String str3, String str4, Function4 function4, int i, Object obj) {
        return voiceSubTaskCoordinator.resolveSubTaskFailureMessage$conversation_mainlandRelease(str, num, str2, jsonObject, str3, str4, (i & 64) != 0 ? null : function4);
    }

    public final String resolveSubTaskFailureMessage$conversation_mainlandRelease(String errorCode, Integer numericErrorCode, String originMessage, JsonObject errorData, String fallbackReason, String status, Function4<? super Integer, ? super String, ? super JsonObject, ? super String, String> displayMessageResolver) {
        String resolveAgentErrorDisplayMessage;
        String num;
        String firstNonBlank = firstNonBlank(originMessage);
        if (firstNonBlank != null) {
            return firstNonBlank;
        }
        String[] strArr = new String[2];
        strArr[0] = resolveLocalSubTaskErrorMessage(errorCode);
        strArr[1] = (numericErrorCode == null || (num = numericErrorCode.toString()) == null) ? null : INSTANCE.resolveLocalSubTaskErrorMessage(num);
        String firstNonBlank2 = firstNonBlank(strArr);
        if (firstNonBlank2 != null) {
            return firstNonBlank2;
        }
        if (numericErrorCode != null) {
            String resolveAgentErrorDataType = resolveAgentErrorDataType(errorData);
            if (displayMessageResolver == null || (resolveAgentErrorDisplayMessage = (String) displayMessageResolver.invoke(numericErrorCode, originMessage, errorData, resolveAgentErrorDataType)) == null) {
                resolveAgentErrorDisplayMessage = resolveAgentErrorDisplayMessage(numericErrorCode.intValue(), originMessage, errorData, resolveAgentErrorDataType);
            }
            String firstNonBlank3 = firstNonBlank(resolveAgentErrorDisplayMessage);
            if (firstNonBlank3 != null) {
                return firstNonBlank3;
            }
        }
        String firstNonBlank4 = firstNonBlank(resolveLocalSubTaskErrorMessage(fallbackReason), fallbackReason, status);
        if (firstNonBlank4 != null) {
            return firstNonBlank4;
        }
        return null;
    }

    private final String resolveAgentErrorDataType(JsonObject data) {
        Object obj;
        String str;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            VoiceSubTaskCoordinator voiceSubTaskCoordinator = this;
            if (data == null || (jsonElement = data.get(DBData.FIELD_TYPE)) == null || (str = jsonElement.getAsString()) == null || !(!StringsKt.isBlank(str))) {
                str = null;
            }
            obj = Result.constructor-impl(str);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (String) (Result.isFailure-impl(obj) ? null : obj);
    }

    private final String resolveAgentErrorDisplayMessage(int code, String originMessage, JsonObject data, String dataType) {
        Object obj;
        AgentErrorCodeRegistry.DisplayResult displayMessage;
        try {
            Result.Companion companion = Result.Companion;
            VoiceSubTaskCoordinator voiceSubTaskCoordinator = this;
            AgentErrorCodeRegistry agentErrorCodeRegistry = AgentErrorCodeRegistry.INSTANCE;
            Resources resources = AppHost.INSTANCE.getApplication().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            displayMessage = agentErrorCodeRegistry.displayMessage(resources, Integer.valueOf(code), (r16 & 4) != 0 ? null : originMessage, (r16 & 8) != 0 ? null : data, (r16 & 16) != 0 ? null : dataType, (r16 & 32) != 0 ? TocCreditsPolicy.INSTANCE.isEnabled() : false);
            obj = Result.constructor-impl(displayMessage.getMessage());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null || !(!StringsKt.isBlank(str))) {
            return null;
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        if (r3.equals(com.bytedance.trae.conversation.voice.subtask.SubTaskErrorCode.DEVICE_OFFLINE) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:?, code lost:
    
        return localizedString(com.bytedance.trae.multilanguage.R.string.trae_conversation_device_offline);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        if (r3.equals(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator.ERROR_CODE_DEVICE_OFFLINE_NUMERIC) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String resolveLocalSubTaskErrorMessage(String errorCode) {
        if (errorCode != null) {
            int hashCode = errorCode.hashCode();
            if (hashCode != -1191786997) {
                if (hashCode != 430710010) {
                    if (hashCode == 784373497 && errorCode.equals(SubTaskErrorCode.CONTAINER_NOT_READY)) {
                        return localizedString(R.string.imkit_error_remote_storage_error);
                    }
                }
            }
        }
        return null;
    }

    private final String localizedString(int resId) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            VoiceSubTaskCoordinator voiceSubTaskCoordinator = this;
            I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
            Resources resources = AppHost.INSTANCE.getApplication().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            obj = Result.constructor-impl(i18nTextProvider.getString(resources, resId, new Object[0]));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null || !(!StringsKt.isBlank(str))) {
            return null;
        }
        return str;
    }

    private final String firstNonBlankErrorMessage(String... values) {
        String firstNonBlank = firstNonBlank((String[]) Arrays.copyOf(values, values.length));
        if (firstNonBlank == null || StringsKt.equals(firstNonBlank, "success", true)) {
            return null;
        }
        return firstNonBlank;
    }

    public final Long calculateCreateTaskRetryDelayMs$conversation_mainlandRelease(int retryIndex, long elapsedDelayMs) {
        if (retryIndex >= 15) {
            return null;
        }
        long j = 300000 - elapsedDelayMs;
        if (j <= 0) {
            return null;
        }
        return Long.valueOf(Math.min((1 << RangesKt.coerceAtMost(retryIndex, 30)) * 5000, Math.min(60000L, j)));
    }

    private final String firstNonBlank(String... values) {
        String str;
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = null;
                break;
            }
            str = values[i];
            String str2 = str;
            if (!(str2 == null || StringsKt.isBlank(str2))) {
                break;
            }
            i++;
        }
        if (str != null) {
            return StringsKt.trim(str).toString();
        }
        return null;
    }
}
