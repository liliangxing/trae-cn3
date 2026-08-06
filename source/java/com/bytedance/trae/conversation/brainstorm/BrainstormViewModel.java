package com.bytedance.trae.conversation.brainstorm;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager;
import com.bytedance.trae.conversation.brainstorm.BrainstormViewModel;
import com.bytedance.trae.conversation.brainstorm.MinimizeResult;
import com.bytedance.trae.conversation.brainstorm.audio.AudioDeviceManager;
import com.bytedance.trae.conversation.brainstorm.health.VoiceHealthMonitor;
import com.bytedance.trae.conversation.brainstorm.health.VoicePrompt;
import com.bytedance.trae.conversation.brainstorm.model.AiReplyState;
import com.bytedance.trae.conversation.brainstorm.model.AttachmentState;
import com.bytedance.trae.conversation.brainstorm.model.AudioDevice;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormEndData;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormMessageKt;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormPhase;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormSummaryEligibilityKt;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState;
import com.bytedance.trae.conversation.brainstorm.model.MessageRole;
import com.bytedance.trae.conversation.brainstorm.model.ParsedSubTaskTag;
import com.bytedance.trae.conversation.brainstorm.model.ParticipantState;
import com.bytedance.trae.conversation.brainstorm.model.RecordingState;
import com.bytedance.trae.conversation.brainstorm.model.TimeoutState;
import com.bytedance.trae.conversation.debug.ConversationDebugInfoCopier;
import com.bytedance.trae.conversation.debug.ConversationDebugLogInfo;
import com.bytedance.trae.conversation.debug.VoiceDiscussionDebugLogInfo;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.ConversationStateMessage;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptContext;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptSignal;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptStage;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker;
import com.bytedance.trae.conversation.voice.VoiceDiscussionMetrics;
import com.bytedance.trae.conversation.voice.network.StartVoiceChatData;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig;
import com.bytedance.trae.conversation.voice.subtask.SubTaskProtocolKt;
import com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState;
import com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage;
import com.bytedance.trae.conversation.voice.subtask.SubTaskUiState;
import com.bytedance.trae.conversation.voice.subtask.TaskStartMessage;
import com.bytedance.trae.conversation.voice.subtask.TaskStopMessage;
import com.bytedance.trae.conversation.voice.subtask.ToolResultMessage;
import com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator;
import com.bytedance.trae.conversation.widget.ChatMode;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Mode;
import com.bytedance.trae.im.service.Source;
import com.bytedance.trae.platform.service.ApmService;
import com.bytedance.trae.utils.logger.FLogger;
import java.lang.Character;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONObject;

/* compiled from: BrainstormViewModel.kt */
@Metadata(d1 = {"\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0004*\u0002\u0093\u0001\u0018\u0000 \u0086\u00022\u00020\u0001:\u0006\u0086\u0002\u0087\u0002\u0088\u0002B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J:\u0010w\u001a\u00020V2\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020\u00072\u0006\u0010{\u001a\u00020\u00072\u0006\u0010|\u001a\u00020:2\u0006\u0010}\u001a\u00020&2\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\u0007J\u000f\u0010\u007f\u001a\u00020V2\u0007\u0010\u0080\u0001\u001a\u00020\u0007J\u0010\u0010\u0081\u0001\u001a\u00020V2\u0007\u0010\u0080\u0001\u001a\u00020\u0007J\u0010\u0010\u0082\u0001\u001a\u00020V2\u0007\u0010\u0080\u0001\u001a\u00020\u0007J3\u0010\u0083\u0001\u001a\u00020V2\u0007\u0010\u0080\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0084\u0001\u001a\u00020&2\u0016\u0010\u0085\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0087\u0001\u0012\u0005\u0012\u00030\u0087\u00010\u0086\u0001J\u001c\u0010\u0088\u0001\u001a\u00020V2\b\u0010\u0089\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u008a\u0001\u001a\u00020yH\u0002J\u0012\u0010\u008b\u0001\u001a\u00020V2\u0007\u0010\u008c\u0001\u001a\u00020&H\u0002J\u0012\u0010\u008d\u0001\u001a\u00020V2\u0007\u0010\u0080\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u008e\u0001\u001a\u00020VH\u0002J\u0012\u0010\u008f\u0001\u001a\u00020V2\u0007\u0010\u0090\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010\u0091\u0001\u001a\u00020V2\u0007\u0010\u0090\u0001\u001a\u00020\u0007H\u0002J%\u0010\u0095\u0001\u001a\u00020V2\u0007\u0010\u0096\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\t\b\u0002\u0010\u0097\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010\u0098\u0001\u001a\u00020V2\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0002J\u0089\u0001\u0010\u009b\u0001\u001a\u00020V2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00072\u000b\b\u0002\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00072\t\b\u0002\u0010 \u0001\u001a\u00020&2\u000b\b\u0002\u0010¡\u0001\u001a\u0004\u0018\u00010\u00072\t\b\u0002\u0010¢\u0001\u001a\u00020-2\t\b\u0002\u0010£\u0001\u001a\u00020(2\u000b\b\u0002\u0010¤\u0001\u001a\u0004\u0018\u00010\u00072\u000b\b\u0002\u0010¥\u0001\u001a\u0004\u0018\u00010\u00072\f\b\u0002\u0010¦\u0001\u001a\u0005\u0018\u00010§\u00012\b\b\u0002\u00102\u001a\u00020&J=\u0010¨\u0001\u001a\u00020V2\u0007\u0010©\u0001\u001a\u00020\u00072\u0007\u0010ª\u0001\u001a\u00020:2\u0007\u0010«\u0001\u001a\u00020&2\u0007\u0010¬\u0001\u001a\u00020:2\u0007\u0010\u00ad\u0001\u001a\u00020:2\u0007\u0010®\u0001\u001a\u00020:J\u0011\u0010¯\u0001\u001a\u00020&2\b\u0010°\u0001\u001a\u00030±\u0001J'\u0010²\u0001\u001a\u00020&2\b\u0010³\u0001\u001a\u00030´\u00012\t\b\u0002\u0010µ\u0001\u001a\u00020\u00072\t\b\u0002\u0010¶\u0001\u001a\u00020CJ\t\u0010·\u0001\u001a\u00020VH\u0002J\u0019\u0010¸\u0001\u001a\u00020V2\u0007\u0010¹\u0001\u001a\u00020:2\u0007\u0010º\u0001\u001a\u00020:J\u0007\u0010»\u0001\u001a\u00020VJ\u0012\u0010¼\u0001\u001a\u00020V2\t\b\u0002\u0010½\u0001\u001a\u00020&J\u0007\u0010¾\u0001\u001a\u00020VJ\u0012\u0010¿\u0001\u001a\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0003\u0010À\u0001J\u0007\u0010Á\u0001\u001a\u00020VJ\u0007\u0010Â\u0001\u001a\u00020\u0007J\t\u0010Ã\u0001\u001a\u00020VH\u0002J\u0007\u0010Ä\u0001\u001a\u00020VJ\u0007\u0010Å\u0001\u001a\u00020VJ\u0012\u0010Æ\u0001\u001a\u00020V2\u0007\u0010\u0097\u0001\u001a\u00020\u0007H\u0002J\t\u0010Ç\u0001\u001a\u00020VH\u0002J\u0012\u0010È\u0001\u001a\u00020V2\u0007\u0010\u0097\u0001\u001a\u00020\u0007H\u0002J\u0007\u0010É\u0001\u001a\u00020VJ\u0012\u0010Ê\u0001\u001a\u00020V2\t\b\u0002\u0010Ë\u0001\u001a\u00020&J\t\u0010Ì\u0001\u001a\u00020VH\u0002J\t\u0010Í\u0001\u001a\u00020VH\u0002J\t\u0010Î\u0001\u001a\u00020VH\u0002J\u000b\u0010Ï\u0001\u001a\u0004\u0018\u00010LH\u0002J\t\u0010Ð\u0001\u001a\u00020VH\u0002J\t\u0010Ñ\u0001\u001a\u00020VH\u0002J\u0014\u0010Ò\u0001\u001a\u00020V2\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0007H\u0002J\u0013\u0010Ô\u0001\u001a\u00020V2\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0002J9\u0010×\u0001\u001a\u00020V2\b\u0010\u0089\u0001\u001a\u00030\u0087\u00012\u0007\u0010Ø\u0001\u001a\u00020:2\u0007\u0010Ù\u0001\u001a\u00020:2\u0007\u0010Ú\u0001\u001a\u00020\u00072\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u0007H\u0002J\u0019\u0010Û\u0001\u001a\u00020V2\u0007\u0010Ü\u0001\u001a\u00020\u00072\u0007\u0010Ý\u0001\u001a\u00020\u0007J\u0012\u0010Þ\u0001\u001a\u00020V2\u0007\u0010ß\u0001\u001a\u00020\u0007H\u0002J\u001b\u0010à\u0001\u001a\u00020V2\u0007\u0010á\u0001\u001a\u00020L2\u0007\u0010â\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010ã\u0001\u001a\u00020V2\u0007\u0010ä\u0001\u001a\u00020LH\u0002J\u0012\u0010å\u0001\u001a\u00020V2\u0007\u0010æ\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010ë\u0001\u001a\u00030ì\u00012\t\u0010í\u0001\u001a\u0004\u0018\u00010\u0007J\u0011\u0010î\u0001\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0003\bï\u0001J\u0018\u0010ð\u0001\u001a\u00020V2\u0007\u0010ñ\u0001\u001a\u00020\u0018H\u0000¢\u0006\u0003\bò\u0001J\u000f\u0010ó\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0003\bô\u0001J\u0018\u0010õ\u0001\u001a\u00020V2\u0007\u0010ö\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0003\b÷\u0001J\b\u0010ø\u0001\u001a\u00030ù\u0001J\u0010\u0010ú\u0001\u001a\u00030û\u0001H\u0000¢\u0006\u0003\bü\u0001J\u0019\u0010ý\u0001\u001a\u00020V2\b\u0010ú\u0001\u001a\u00030û\u0001H\u0000¢\u0006\u0003\bþ\u0001J\u0014\u0010ÿ\u0001\u001a\u00020:*\t\u0012\u0004\u0012\u00020:0\u0080\u0002H\u0002J\u0014\u0010\u0081\u0002\u001a\u00020:*\t\u0012\u0004\u0012\u00020:0\u0080\u0002H\u0002J\t\u0010\u0082\u0002\u001a\u00020VH\u0014J\u0013\u0010\u0083\u0002\u001a\u00020&2\b\u0010\u0084\u0002\u001a\u00030\u0085\u0002H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\"\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010)\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020-8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u001e\u00102\u001a\u00020&2\u0006\u00101\u001a\u00020&@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u0002068F¢\u0006\u0006\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020:0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020:0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020L0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010O\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0004\n\u0002\u0010PR\u0012\u0010Q\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0004\n\u0002\u0010PR\u0012\u0010R\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0004\n\u0002\u0010PR\u000e\u0010S\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020V0UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020X0UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0Z¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0017\u0010]\u001a\b\u0012\u0004\u0012\u00020V0Z¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\\R\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020V0UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010`\u001a\b\u0012\u0004\u0012\u00020V0Z¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\\R\u0014\u0010b\u001a\b\u0012\u0004\u0012\u00020c0UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020c0Z¢\u0006\b\n\u0000\u001a\u0004\be\u0010\\R\u0014\u0010f\u001a\b\u0012\u0004\u0012\u00020V0UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020V0Z¢\u0006\b\n\u0000\u001a\u0004\bh\u0010\\R\u0014\u0010i\u001a\b\u0012\u0004\u0012\u00020j0UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010k\u001a\b\u0012\u0004\u0012\u00020j0Z¢\u0006\b\n\u0000\u001a\u0004\bl\u0010\\R\u0012\u0010m\u001a\u00060nj\u0002`oX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010p\u001a\u00060nj\u0002`oX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010q\u001a\u00060nj\u0002`oX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010r\u001a\u00060nj\u0002`oX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010u\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150vX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0092\u0001\u001a\u00030\u0093\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0094\u0001R\u0018\u0010ç\u0001\u001a\u00030è\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bé\u0001\u0010ê\u0001¨\u0006\u0089\u0002"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "rtcDiag", "", "message", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "summaryRepository", "Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;", "audioDeviceManager", "Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;", "aiReplyJob", "Lkotlinx/coroutines/Job;", "sessionTimerJob", "voiceChatSession", "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;", "voiceDiscussionAttemptTracker", "Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;", "voiceHealthMonitor", "Lcom/bytedance/trae/conversation/brainstorm/health/VoiceHealthMonitor;", "startRecordingJob", "outputVolumeMonitorJob", "originConversationId", "parentConversationIdForVoice", "_cliConversationId", "cliConversationId", "getCliConversationId", "()Ljava/lang/String;", "needRemoteParentChatSessionForVoice", "", "_voiceMode", "Lcom/bytedance/trae/im/service/Mode;", "voiceMode", "getVoiceMode", "()Lcom/bytedance/trae/im/service/Mode;", "_voiceCliType", "Lcom/bytedance/trae/im/service/CliType;", "voiceCliType", "getVoiceCliType", "()Lcom/bytedance/trae/im/service/CliType;", "value", "attachmentSubTaskEnabled", "getAttachmentSubTaskEnabled", "()Z", "currentChatMode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "getCurrentChatMode", "()Lcom/bytedance/trae/conversation/widget/ChatMode;", "perfMicCheckStartMs", "", "perfMicCheckEndMs", "perfApiRequestStartMs", "perfJoinRoomStartMs", "perfJoinRoomSuccessMs", "perfBotJoinedMs", "perfIsNewSession", "discussionStartPerfReported", "sessionUserMessageCount", "", "sessionBotMessageCount", "sessionUserSpeakEndTimestamps", "", "sessionBotSpeakStartTimestamps", "sessionUserCharCount", "sessionBotCharCount", "sessionHasEverEnabledSubtitle", "sessionRoundDelays", "Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;", "roundIndexSeq", "awaitingBotFirstChar", "pendingUserSpeakStartMs", "Ljava/lang/Long;", "pendingUserSubtitleFirstCharMs", "pendingUserSubtitleLastCharMs", "userVadActive", "_summaryReady", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "_localAudioVolume", "", "localAudioVolume", "Lkotlinx/coroutines/flow/SharedFlow;", "getLocalAudioVolume", "()Lkotlinx/coroutines/flow/SharedFlow;", "summaryReady", "getSummaryReady", "_summaryFailed", "summaryFailed", "getSummaryFailed", "_brainstormEnded", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormEndData;", "brainstormEnded", "getBrainstormEnded", "_minimizeRequested", "minimizeRequested", "getMinimizeRequested", "_voicePromptEvents", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;", "voicePromptEvents", "getVoicePromptEvents", "_botSubtitleBuffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "_userSubtitleBuffer", "_botWordAggregateBuffer", "_userWordAggregateBuffer", "attachmentManager", "Lcom/bytedance/trae/conversation/brainstorm/BrainstormAttachmentManager;", "attachmentUploadJobs", "Ljava/util/concurrent/ConcurrentHashMap;", "pickAndUpload", "uri", "Landroid/net/Uri;", "mime", "displayName", "sizeBytes", "isImage", "groupId", "retryAttachment", "attachmentId", "cancelAttachment", "removeAttachment", "updateAttachment", "moveToEnd", "updater", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "startUpload", "attachment", "sourceUri", "cancelAllPendingUploads", "markUploadingAsCancelled", "onAttachmentUploadDone", "maybeNotifyPendingAttachments", "handleUserFinalText", "text", "handleBotFinalText", "voiceChatListener", "com/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1", "Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$voiceChatListener$1;", "logUnrecognizedRtcFrame", "uid", "reason", "applySubTaskTerminal", "finished", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;", "initVoiceSession", "context", "Landroid/content/Context;", "cliCnvId", "parentConversationId", "createRemoteParentSession", "cliId", "cliType", "mode", "parentAgentType", "workspaceDir", TimonPipeline.KEY_SOURCE, "Lcom/bytedance/trae/im/service/Source;", "initVoiceAttempt", "attemptId", "startedAtElapsedMs", "hasSeenIntro", "clickElapsedMs", "eligibilityPassedElapsedMs", "activityLaunchRequestedElapsedMs", "recordVoiceAttemptStage", "stage", "Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;", "recordVoiceAttemptSignal", "signal", "Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;", "failureReason", AccountMonitorConstants.CommonParameter.ERROR, "refreshVoiceAttemptContext", "setPerfMicCheckTimestamps", "startMs", "endMs", "startBrainstorm", "skipIntroAndStartBrainstorm", "autoStartRecording", "startRecording", "resolveVoiceConversationIdForRecording", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleMic", "drainBotSubtitleChars", "flushSubtitleBuffers", "toggleSpeaker", "onHostResumed", "restartOutputVolumeMonitoring", "stopOutputVolumeMonitoring", "emitOutputVolumePromptIfNeeded", "toggleSubtitleMode", "endBrainstorm", "isAbort", "startSessionTimer", "stopSessionTimer", "reportDiscussionStartPerfIfNeeded", "currentRound", "markCurrentRoundHasSubtask", "markCurrentRoundUpload", "markCurrentRoundServerTool", "toolName", "reportServerToolEnd", "msg", "Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;", "reportVoiceFileUploadEnd", "fileSizeBytes", "uploadStartMs", PageDataManager.EXTRA_STATUS, "reportWindowStateClick", "action", "windowStateBeforeClick", "closeLastRoundAsInterruptedIfNeeded", "triggerReason", "tryReportRoundIfFinal", "record", "finalReason", "reportRoundPerf", "r", "reportDiscussionSessionPerf", "endType", "voiceChatListenerForHolder", "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;", "getVoiceChatListenerForHolder$conversation_mainlandRelease", "()Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;", "minimize", "Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult;", "ownerConversationId", "detachVoiceSession", "detachVoiceSession$conversation_mainlandRelease", "attachVoiceSession", "session", "attachVoiceSession$conversation_mainlandRelease", "detachAudioDeviceManager", "detachAudioDeviceManager$conversation_mainlandRelease", "attachAudioDeviceManager", "mgr", "attachAudioDeviceManager$conversation_mainlandRelease", "buildDiscussionDebugLogInfo", "Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;", IFileDataCacheService.TYPE_SNAPSHOT, "Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;", "snapshot$conversation_mainlandRelease", "restore", "restore$conversation_mainlandRelease", "avgOrMissing", "", "maxOrMissing", "onCleared", "isCjkChar", "ch", "", "Companion", "InterruptPhase", "RoundDelayRecord", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormViewModel extends AndroidViewModel {
    private static final String EVENT_DISCUSSION_ROUND_PERF = "voice_discussion_round_perf";
    private static final String EVENT_DISCUSSION_SESSION_END = "voice_discussion_session_end";
    private static final String EVENT_DISCUSSION_SESSION_PERF = "voice_discussion_session_perf";
    private static final String EVENT_DISCUSSION_START_PERF = "rtc_voice_discussion_start_perf";
    private static final long MAX_ATTACHMENT_SIZE_BYTES = 157286400;
    private static final long MAX_TOTAL_ATTACHMENT_SIZE_BYTES = 209715200;
    private static final long OUTPUT_VOLUME_CHECK_INTERVAL_MS = 2000;
    private static final long OUTPUT_VOLUME_ROUTE_SETTLE_DELAY_MS = 800;
    private static final long PERF_MISSING_VALUE = -1;
    private static final String TAG = "BrainstormViewModel";
    private static final int TIMEOUT_COUNTDOWN_SECONDS = 60;
    private static final long TIMEOUT_WARNING_THRESHOLD_MS = 1800000;
    private static final float USER_SPEAK_VAD_THRESHOLD = 0.05f;
    private final StringBuilder _botSubtitleBuffer;
    private final StringBuilder _botWordAggregateBuffer;
    private final MutableSharedFlow<BrainstormEndData> _brainstormEnded;
    private String _cliConversationId;
    private final MutableSharedFlow<Float> _localAudioVolume;
    private final MutableSharedFlow<Unit> _minimizeRequested;
    private final MutableSharedFlow<Unit> _summaryFailed;
    private final MutableSharedFlow<Unit> _summaryReady;
    private final MutableStateFlow<BrainstormUiState> _uiState;
    private final StringBuilder _userSubtitleBuffer;
    private final StringBuilder _userWordAggregateBuffer;
    private volatile CliType _voiceCliType;
    private volatile Mode _voiceMode;
    private final MutableSharedFlow<VoicePrompt> _voicePromptEvents;
    private Job aiReplyJob;
    private final BrainstormAttachmentManager attachmentManager;
    private boolean attachmentSubTaskEnabled;
    private final ConcurrentHashMap<String, Job> attachmentUploadJobs;
    private AudioDeviceManager audioDeviceManager;
    private boolean awaitingBotFirstChar;
    private final SharedFlow<BrainstormEndData> brainstormEnded;
    private boolean discussionStartPerfReported;
    private final SharedFlow<Float> localAudioVolume;
    private final SharedFlow<Unit> minimizeRequested;
    private boolean needRemoteParentChatSessionForVoice;
    private String originConversationId;
    private Job outputVolumeMonitorJob;
    private String parentConversationIdForVoice;
    private Long pendingUserSpeakStartMs;
    private Long pendingUserSubtitleFirstCharMs;
    private Long pendingUserSubtitleLastCharMs;
    private long perfApiRequestStartMs;
    private long perfBotJoinedMs;
    private boolean perfIsNewSession;
    private long perfJoinRoomStartMs;
    private long perfJoinRoomSuccessMs;
    private long perfMicCheckEndMs;
    private long perfMicCheckStartMs;
    private int roundIndexSeq;
    private int sessionBotCharCount;
    private int sessionBotMessageCount;
    private final List<Long> sessionBotSpeakStartTimestamps;
    private boolean sessionHasEverEnabledSubtitle;
    private final List<RoundDelayRecord> sessionRoundDelays;
    private Job sessionTimerJob;
    private int sessionUserCharCount;
    private int sessionUserMessageCount;
    private final List<Long> sessionUserSpeakEndTimestamps;
    private Job startRecordingJob;
    private final SharedFlow<Unit> summaryFailed;
    private final SharedFlow<Unit> summaryReady;
    private final BrainstormSummaryRepository summaryRepository;
    private final StateFlow<BrainstormUiState> uiState;
    private boolean userVadActive;
    private final BrainstormViewModel$voiceChatListener$1 voiceChatListener;
    private BMVoiceChatSessionManager voiceChatSession;
    private VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker;
    private final VoiceHealthMonitor voiceHealthMonitor;
    private final SharedFlow<VoicePrompt> voicePromptEvents;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<SubTaskRenderState> TERMINAL_SUB_TASK_STATES = SetsKt.setOf(new SubTaskRenderState[]{SubTaskRenderState.Done, SubTaskRenderState.Failed});

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrainstormAttachment retryAttachment$lambda$5(BrainstormAttachment brainstormAttachment, BrainstormAttachment brainstormAttachment2) {
        Intrinsics.checkNotNullParameter(brainstormAttachment2, "it");
        return brainstormAttachment;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$voiceChatListener$1] */
    public BrainstormViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        MutableStateFlow<BrainstormUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(new BrainstormUiState(null, null, null, null, null, null, null, null, null, false, false, false, null, 0L, 0L, null, 0, null, false, null, null, null, 4194303, null));
        this._uiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
        this.summaryRepository = new BrainstormSummaryRepository();
        Application application2 = application;
        this.audioDeviceManager = new AudioDeviceManager(application2);
        this.voiceHealthMonitor = new VoiceHealthMonitor(application2);
        this._voiceMode = Mode.WORK;
        this._voiceCliType = CliType.LOCAL;
        this.attachmentSubTaskEnabled = true;
        this.perfIsNewSession = true;
        this.sessionUserSpeakEndTimestamps = new ArrayList();
        this.sessionBotSpeakStartTimestamps = new ArrayList();
        this.sessionRoundDelays = new ArrayList();
        MutableSharedFlow<Unit> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 6, (Object) null);
        this._summaryReady = MutableSharedFlow$default;
        MutableSharedFlow<Float> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 1, (BufferOverflow) null, 4, (Object) null);
        this._localAudioVolume = MutableSharedFlow$default2;
        this.localAudioVolume = FlowKt.asSharedFlow(MutableSharedFlow$default2);
        this.summaryReady = FlowKt.asSharedFlow(MutableSharedFlow$default);
        MutableSharedFlow<Unit> MutableSharedFlow$default3 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 6, (Object) null);
        this._summaryFailed = MutableSharedFlow$default3;
        this.summaryFailed = FlowKt.asSharedFlow(MutableSharedFlow$default3);
        MutableSharedFlow<BrainstormEndData> MutableSharedFlow$default4 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 6, (Object) null);
        this._brainstormEnded = MutableSharedFlow$default4;
        this.brainstormEnded = FlowKt.asSharedFlow(MutableSharedFlow$default4);
        MutableSharedFlow<Unit> MutableSharedFlow$default5 = SharedFlowKt.MutableSharedFlow$default(0, 1, (BufferOverflow) null, 4, (Object) null);
        this._minimizeRequested = MutableSharedFlow$default5;
        this.minimizeRequested = FlowKt.asSharedFlow(MutableSharedFlow$default5);
        MutableSharedFlow<VoicePrompt> MutableSharedFlow$default6 = SharedFlowKt.MutableSharedFlow$default(0, 8, (BufferOverflow) null, 4, (Object) null);
        this._voicePromptEvents = MutableSharedFlow$default6;
        this.voicePromptEvents = FlowKt.asSharedFlow(MutableSharedFlow$default6);
        this._botSubtitleBuffer = new StringBuilder();
        this._userSubtitleBuffer = new StringBuilder();
        this._botWordAggregateBuffer = new StringBuilder();
        this._userWordAggregateBuffer = new StringBuilder();
        this.attachmentManager = new BrainstormAttachmentManager(application);
        this.attachmentUploadJobs = new ConcurrentHashMap<>();
        this.audioDeviceManager.init();
        this.voiceChatListener = new BMVoiceChatSessionManager.Listener() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$voiceChatListener$1

            /* compiled from: BrainstormViewModel.kt */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;
                public static final /* synthetic */ int[] $EnumSwitchMapping$1;
                public static final /* synthetic */ int[] $EnumSwitchMapping$2;

                static {
                    int[] iArr = new int[BMVoiceChatSessionManager.Status.values().length];
                    try {
                        iArr[BMVoiceChatSessionManager.Status.Starting.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[BMVoiceChatSessionManager.Status.JoiningRoom.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[BMVoiceChatSessionManager.Status.JoinedRoom.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[BMVoiceChatSessionManager.Status.Stopped.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                    int[] iArr2 = new int[BMVoiceChatSessionManager.MessageRole.values().length];
                    try {
                        iArr2[BMVoiceChatSessionManager.MessageRole.USER.ordinal()] = 1;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr2[BMVoiceChatSessionManager.MessageRole.BOT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused6) {
                    }
                    $EnumSwitchMapping$1 = iArr2;
                    int[] iArr3 = new int[BMVoiceChatSessionManager.PerfEvent.values().length];
                    try {
                        iArr3[BMVoiceChatSessionManager.PerfEvent.API_REQUEST_START.ordinal()] = 1;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr3[BMVoiceChatSessionManager.PerfEvent.API_REQUEST_END_JOIN_ROOM_START.ordinal()] = 2;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr3[BMVoiceChatSessionManager.PerfEvent.JOIN_ROOM_SUCCESS.ordinal()] = 3;
                    } catch (NoSuchFieldError unused9) {
                    }
                    try {
                        iArr3[BMVoiceChatSessionManager.PerfEvent.BOT_JOINED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused10) {
                    }
                    $EnumSwitchMapping$2 = iArr3;
                }
            }

            @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
            public void onStatus(BMVoiceChatSessionManager.Status status) {
                String rtcDiag;
                Object value;
                BrainstormUiState copy;
                Object value2;
                BrainstormUiState copy2;
                VoiceHealthMonitor voiceHealthMonitor;
                Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
                int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
                if (i != 1 && i != 2) {
                    if (i == 3) {
                        MutableStateFlow mutableStateFlow = BrainstormViewModel.this._uiState;
                        do {
                            value = mutableStateFlow.getValue();
                            copy = r4.copy((r42 & 1) != 0 ? r4.phase : null, (r42 & 2) != 0 ? r4.subtitleHistory : null, (r42 & 4) != 0 ? r4.recordingState : null, (r42 & 8) != 0 ? r4.aiReplyState : null, (r42 & 16) != 0 ? r4.aiParticipantState : null, (r42 & 32) != 0 ? r4.userParticipantState : null, (r42 & 64) != 0 ? r4.currentTranscript : null, (r42 & 128) != 0 ? r4.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r4.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r4.isSpeakerOn : false, (r42 & 1024) != 0 ? r4.isMicMuted : false, (r42 & 2048) != 0 ? r4.isSubtitleMode : false, (r42 & 4096) != 0 ? r4.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r4.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r4.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r4.timeoutState : null, (65536 & r42) != 0 ? r4.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r4.aiStageDescription : null, (r42 & 262144) != 0 ? r4.isRtcJoined : true, (r42 & FConstants.SLICE_SIZE) != 0 ? r4.subTask : null, (r42 & 1048576) != 0 ? r4.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value).attachments : null);
                        } while (!mutableStateFlow.compareAndSet(value, copy));
                        BrainstormViewModel.this.recordVoiceAttemptStage(VoiceDiscussionAttemptStage.RTC_JOINED);
                        BrainstormViewModel.this.startSessionTimer();
                    } else if (i == 4) {
                        MutableStateFlow mutableStateFlow2 = BrainstormViewModel.this._uiState;
                        do {
                            value2 = mutableStateFlow2.getValue();
                            copy2 = r4.copy((r42 & 1) != 0 ? r4.phase : null, (r42 & 2) != 0 ? r4.subtitleHistory : null, (r42 & 4) != 0 ? r4.recordingState : null, (r42 & 8) != 0 ? r4.aiReplyState : null, (r42 & 16) != 0 ? r4.aiParticipantState : null, (r42 & 32) != 0 ? r4.userParticipantState : null, (r42 & 64) != 0 ? r4.currentTranscript : null, (r42 & 128) != 0 ? r4.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r4.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r4.isSpeakerOn : false, (r42 & 1024) != 0 ? r4.isMicMuted : false, (r42 & 2048) != 0 ? r4.isSubtitleMode : false, (r42 & 4096) != 0 ? r4.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r4.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r4.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r4.timeoutState : null, (65536 & r42) != 0 ? r4.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r4.aiStageDescription : null, (r42 & 262144) != 0 ? r4.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r4.subTask : null, (r42 & 1048576) != 0 ? r4.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value2).attachments : null);
                        } while (!mutableStateFlow2.compareAndSet(value2, copy2));
                        voiceHealthMonitor = BrainstormViewModel.this.voiceHealthMonitor;
                        voiceHealthMonitor.resetRuntime();
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                BrainstormUiState brainstormUiState = (BrainstormUiState) BrainstormViewModel.this._uiState.getValue();
                FLogger fLogger = FLogger.INSTANCE;
                rtcDiag = BrainstormViewModel.this.rtcDiag("voiceChat.onStatus: status=" + status + ", isRtcJoined=" + brainstormUiState.isRtcJoined());
                fLogger.d("BrainstormViewModel", rtcDiag);
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0034, code lost:
            
                r5 = r34.this$0.currentRound();
             */
            @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onRecognizedText(String text, BMVoiceChatSessionManager.MessageRole role) {
                BrainstormUiState copy;
                VoiceHealthMonitor voiceHealthMonitor;
                Long l;
                BrainstormViewModel.RoundDelayRecord currentRound;
                BrainstormViewModel.RoundDelayRecord roundDelayRecord;
                Object value;
                BrainstormUiState copy2;
                BrainstormViewModel.RoundDelayRecord currentRound2;
                boolean z;
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(role, "role");
                int i = WhenMappings.$EnumSwitchMapping$1[role.ordinal()];
                boolean z2 = false;
                if (i != 1) {
                    if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    String cleanedText = BrainstormMessageKt.parseAttachedSubTaskId(text).getCleanedText();
                    if ((!StringsKt.isBlank(cleanedText)) && currentRound2 != null) {
                        roundDelayRecord = true ^ currentRound2.getReported() ? currentRound2 : null;
                        if (roundDelayRecord != null) {
                            BrainstormViewModel brainstormViewModel = BrainstormViewModel.this;
                            long currentTimeMillis = System.currentTimeMillis();
                            z = brainstormViewModel.awaitingBotFirstChar;
                            if (z) {
                                roundDelayRecord.setBotFirstCharMs(Long.valueOf(currentTimeMillis));
                                brainstormViewModel.awaitingBotFirstChar = false;
                            }
                            roundDelayRecord.setBotLatestCharMs(Long.valueOf(currentTimeMillis));
                            roundDelayRecord.setBotCurrentParagraphChars(cleanedText.length());
                        }
                    }
                    MutableStateFlow mutableStateFlow = BrainstormViewModel.this._uiState;
                    do {
                        value = mutableStateFlow.getValue();
                        copy2 = r5.copy((r42 & 1) != 0 ? r5.phase : null, (r42 & 2) != 0 ? r5.subtitleHistory : null, (r42 & 4) != 0 ? r5.recordingState : null, (r42 & 8) != 0 ? r5.aiReplyState : null, (r42 & 16) != 0 ? r5.aiParticipantState : ParticipantState.Speaking, (r42 & 32) != 0 ? r5.userParticipantState : null, (r42 & 64) != 0 ? r5.currentTranscript : null, (r42 & 128) != 0 ? r5.botTranscript : cleanedText, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r5.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r5.isSpeakerOn : false, (r42 & 1024) != 0 ? r5.isMicMuted : false, (r42 & 2048) != 0 ? r5.isSubtitleMode : false, (r42 & 4096) != 0 ? r5.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r5.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r5.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r5.timeoutState : null, (65536 & r42) != 0 ? r5.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r5.aiStageDescription : null, (r42 & 262144) != 0 ? r5.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r5.subTask : null, (r42 & 1048576) != 0 ? r5.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value).attachments : null);
                    } while (!mutableStateFlow.compareAndSet(value, copy2));
                    return;
                }
                if (!StringsKt.isBlank(text)) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    voiceHealthMonitor = BrainstormViewModel.this.voiceHealthMonitor;
                    voiceHealthMonitor.markUserSubtitle(currentTimeMillis2);
                    l = BrainstormViewModel.this.pendingUserSubtitleFirstCharMs;
                    if (l == null) {
                        BrainstormViewModel.this.pendingUserSubtitleFirstCharMs = Long.valueOf(currentTimeMillis2);
                    }
                    BrainstormViewModel.this.pendingUserSubtitleLastCharMs = Long.valueOf(currentTimeMillis2);
                    currentRound = BrainstormViewModel.this.currentRound();
                    if (currentRound != null) {
                        if (!currentRound.getReported() && !currentRound.getUserFinalReceived()) {
                            z2 = true;
                        }
                        roundDelayRecord = z2 ? currentRound : null;
                        if (roundDelayRecord != null) {
                            if (roundDelayRecord.getUserSubtitleFirstCharMs() == null) {
                                roundDelayRecord.setUserSubtitleFirstCharMs(Long.valueOf(currentTimeMillis2));
                            }
                            roundDelayRecord.setUserSubtitleLastCharMs(Long.valueOf(currentTimeMillis2));
                        }
                    }
                }
                MutableStateFlow mutableStateFlow2 = BrainstormViewModel.this._uiState;
                while (true) {
                    Object value2 = mutableStateFlow2.getValue();
                    MutableStateFlow mutableStateFlow3 = mutableStateFlow2;
                    copy = r1.copy((r42 & 1) != 0 ? r1.phase : null, (r42 & 2) != 0 ? r1.subtitleHistory : null, (r42 & 4) != 0 ? r1.recordingState : null, (r42 & 8) != 0 ? r1.aiReplyState : null, (r42 & 16) != 0 ? r1.aiParticipantState : null, (r42 & 32) != 0 ? r1.userParticipantState : ParticipantState.Speaking, (r42 & 64) != 0 ? r1.currentTranscript : text, (r42 & 128) != 0 ? r1.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r1.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r1.isSpeakerOn : false, (r42 & 1024) != 0 ? r1.isMicMuted : false, (r42 & 2048) != 0 ? r1.isSubtitleMode : false, (r42 & 4096) != 0 ? r1.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r1.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r1.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r1.timeoutState : null, (65536 & r42) != 0 ? r1.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r1.aiStageDescription : null, (r42 & 262144) != 0 ? r1.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r1.subTask : null, (r42 & 1048576) != 0 ? r1.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value2).attachments : null);
                    if (mutableStateFlow3.compareAndSet(value2, copy)) {
                        return;
                    } else {
                        mutableStateFlow2 = mutableStateFlow3;
                    }
                }
            }

            @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
            public void onSubtitleText(String text, BMVoiceChatSessionManager.MessageRole role) {
                boolean isCjkChar;
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(role, "role");
                StringBuilder sb = role == BMVoiceChatSessionManager.MessageRole.BOT ? BrainstormViewModel.this._botSubtitleBuffer : BrainstormViewModel.this._userSubtitleBuffer;
                StringBuilder sb2 = role == BMVoiceChatSessionManager.MessageRole.BOT ? BrainstormViewModel.this._botWordAggregateBuffer : BrainstormViewModel.this._userWordAggregateBuffer;
                int length = text.length();
                for (int i = 0; i < length; i++) {
                    char charAt = text.charAt(i);
                    isCjkChar = BrainstormViewModel.this.isCjkChar(charAt);
                    if (isCjkChar) {
                        sb2.append(charAt);
                        sb.append((CharSequence) sb2);
                        StringsKt.clear(sb2);
                    } else if (charAt == ' ' || charAt == '\n') {
                        sb2.append(charAt);
                        sb.append((CharSequence) sb2);
                        StringsKt.clear(sb2);
                    } else {
                        sb2.append(charAt);
                    }
                }
            }

            @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
            public void onFinalText(String text, BMVoiceChatSessionManager.MessageRole role) {
                BrainstormViewModel.RoundDelayRecord currentRound;
                Long l;
                int i;
                int i2;
                BrainstormViewModel.RoundDelayRecord currentRound2;
                int i3;
                int i4;
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(role, "role");
                String str = text;
                if (!StringsKt.isBlank(str)) {
                    int i5 = WhenMappings.$EnumSwitchMapping$1[role.ordinal()];
                    if (i5 == 1) {
                        i = BrainstormViewModel.this.sessionUserMessageCount;
                        BrainstormViewModel.this.sessionUserMessageCount = i + 1;
                        BrainstormViewModel brainstormViewModel = BrainstormViewModel.this;
                        i2 = brainstormViewModel.sessionUserCharCount;
                        brainstormViewModel.sessionUserCharCount = i2 + text.length();
                    } else if (i5 == 2) {
                        i3 = BrainstormViewModel.this.sessionBotMessageCount;
                        BrainstormViewModel.this.sessionBotMessageCount = i3 + 1;
                        BrainstormViewModel brainstormViewModel2 = BrainstormViewModel.this;
                        i4 = brainstormViewModel2.sessionBotCharCount;
                        brainstormViewModel2.sessionBotCharCount = i4 + text.length();
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    currentRound2 = BrainstormViewModel.this.currentRound();
                    if (currentRound2 != null) {
                        if (!(!currentRound2.getReported())) {
                            currentRound2 = null;
                        }
                        if (currentRound2 != null) {
                            int i6 = WhenMappings.$EnumSwitchMapping$1[role.ordinal()];
                            if (i6 == 1) {
                                currentRound2.setUserCharCount(currentRound2.getUserCharCount() + text.length());
                            } else {
                                if (i6 != 2) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                currentRound2.setBotCharCount(currentRound2.getBotCharCount() + text.length());
                                currentRound2.setBotCurrentParagraphChars(0);
                            }
                        }
                    }
                }
                if (role == BMVoiceChatSessionManager.MessageRole.USER) {
                    if (!StringsKt.isBlank(str)) {
                        BrainstormViewModel.this.recordVoiceAttemptStage(VoiceDiscussionAttemptStage.USER_FINAL_RECEIVED);
                    }
                    currentRound = BrainstormViewModel.this.currentRound();
                    if (currentRound != null) {
                        if (!(!currentRound.getReported())) {
                            currentRound = null;
                        }
                        if (currentRound != null) {
                            BrainstormViewModel brainstormViewModel3 = BrainstormViewModel.this;
                            currentRound.setUserFinalReceived(true);
                            l = brainstormViewModel3.pendingUserSubtitleLastCharMs;
                            if (l != null) {
                                long longValue = l.longValue();
                                Long userSubtitleLastCharMs = currentRound.getUserSubtitleLastCharMs();
                                if (userSubtitleLastCharMs == null || longValue > userSubtitleLastCharMs.longValue()) {
                                    currentRound.setUserSubtitleLastCharMs(Long.valueOf(longValue));
                                }
                            }
                        }
                    }
                    BrainstormViewModel.this.pendingUserSpeakStartMs = null;
                    BrainstormViewModel.this.pendingUserSubtitleFirstCharMs = null;
                    BrainstormViewModel.this.pendingUserSubtitleLastCharMs = null;
                    BrainstormViewModel.this.userVadActive = false;
                }
                int i7 = WhenMappings.$EnumSwitchMapping$1[role.ordinal()];
                if (i7 == 1) {
                    BrainstormViewModel.this.handleUserFinalText(text);
                } else {
                    if (i7 == 2) {
                        BrainstormViewModel.this.handleBotFinalText(text);
                        return;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }

            @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
            public void onError(Throwable error) {
                String rtcDiag;
                Object value;
                BrainstormUiState copy;
                VoicePrompt.Runtime.RtcError rtcError;
                String str;
                VoiceDiscussionAttemptSignal voiceDiscussionAttemptSignal;
                MutableSharedFlow mutableSharedFlow;
                Intrinsics.checkNotNullParameter(error, "error");
                FLogger fLogger = FLogger.INSTANCE;
                rtcDiag = BrainstormViewModel.this.rtcDiag("voiceChat.onError: " + error.getMessage());
                fLogger.w("BrainstormViewModel", rtcDiag, error);
                BrainstormViewModel.this.stopSessionTimer();
                MutableStateFlow mutableStateFlow = BrainstormViewModel.this._uiState;
                do {
                    value = mutableStateFlow.getValue();
                    copy = r4.copy((r42 & 1) != 0 ? r4.phase : null, (r42 & 2) != 0 ? r4.subtitleHistory : null, (r42 & 4) != 0 ? r4.recordingState : RecordingState.Idle, (r42 & 8) != 0 ? r4.aiReplyState : null, (r42 & 16) != 0 ? r4.aiParticipantState : ParticipantState.Idle, (r42 & 32) != 0 ? r4.userParticipantState : ParticipantState.Idle, (r42 & 64) != 0 ? r4.currentTranscript : "", (r42 & 128) != 0 ? r4.botTranscript : "", (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r4.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r4.isSpeakerOn : false, (r42 & 1024) != 0 ? r4.isMicMuted : false, (r42 & 2048) != 0 ? r4.isSubtitleMode : false, (r42 & 4096) != 0 ? r4.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r4.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r4.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r4.timeoutState : null, (65536 & r42) != 0 ? r4.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r4.aiStageDescription : null, (r42 & 262144) != 0 ? r4.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r4.subTask : null, (r42 & 1048576) != 0 ? r4.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value).attachments : null);
                } while (!mutableStateFlow.compareAndSet(value, copy));
                String message = error.getMessage();
                if (message == null) {
                    message = "";
                }
                boolean z = error instanceof IllegalStateException;
                if (z) {
                    rtcError = VoicePrompt.Runtime.StartFailed.INSTANCE;
                } else if (error instanceof IllegalArgumentException) {
                    rtcError = VoicePrompt.Runtime.StartFailed.INSTANCE;
                } else {
                    rtcError = StringsKt.startsWith$default(message, "startVoiceChat", false, 2, (Object) null) ? VoicePrompt.Runtime.StartFailed.INSTANCE : VoicePrompt.Runtime.RtcError.INSTANCE;
                }
                if (z) {
                    str = "voice_session_conflict";
                } else if (error instanceof IllegalArgumentException) {
                    str = "voice_chat_invalid_argument";
                } else if (StringsKt.startsWith$default(message, "startVoiceChat failed", false, 2, (Object) null)) {
                    str = "start_voice_chat_request_failed";
                } else if (StringsKt.startsWith$default(message, "startVoiceChat returns invalid data", false, 2, (Object) null)) {
                    str = "start_voice_chat_invalid_data";
                } else {
                    str = Intrinsics.areEqual(rtcError, VoicePrompt.Runtime.StartFailed.INSTANCE) ? "voice_discussion_start_failed" : "rtc_runtime_error";
                }
                String str2 = str;
                BrainstormViewModel brainstormViewModel = BrainstormViewModel.this;
                if (Intrinsics.areEqual(rtcError, VoicePrompt.Runtime.StartFailed.INSTANCE)) {
                    voiceDiscussionAttemptSignal = VoiceDiscussionAttemptSignal.START_API_FAILED;
                } else {
                    voiceDiscussionAttemptSignal = VoiceDiscussionAttemptSignal.RTC_ERROR;
                }
                BrainstormViewModel.recordVoiceAttemptSignal$default(brainstormViewModel, voiceDiscussionAttemptSignal, str2, 0, 4, null);
                mutableSharedFlow = BrainstormViewModel.this._voicePromptEvents;
                mutableSharedFlow.tryEmit(rtcError);
            }

            @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
            public void onConversationStateChanged(ConversationStateMessage state) {
                String rtcDiag;
                VoiceHealthMonitor voiceHealthMonitor;
                Object value;
                BrainstormUiState copy;
                String rtcDiag2;
                VoiceHealthMonitor voiceHealthMonitor2;
                Object value2;
                BrainstormUiState copy2;
                VoiceHealthMonitor voiceHealthMonitor3;
                Object value3;
                BrainstormUiState copy3;
                List list;
                List list2;
                int i;
                Long l;
                Long l2;
                Long l3;
                VoiceHealthMonitor voiceHealthMonitor4;
                Object value4;
                BrainstormUiState copy4;
                BrainstormViewModel.RoundDelayRecord currentRound;
                List list3;
                VoiceHealthMonitor voiceHealthMonitor5;
                Object value5;
                BrainstormUiState copy5;
                BrainstormViewModel.RoundDelayRecord currentRound2;
                VoiceHealthMonitor voiceHealthMonitor6;
                Object value6;
                BrainstormUiState copy6;
                BrainstormViewModel.RoundDelayRecord currentRound3;
                Intrinsics.checkNotNullParameter(state, "state");
                FLogger fLogger = FLogger.INSTANCE;
                BrainstormViewModel brainstormViewModel = BrainstormViewModel.this;
                StringBuilder append = new StringBuilder("onConversationStateChanged: stage=").append(state.getStage().getCode()).append('-').append(state.getStage().getDescription()).append(", roundId=").append(state.getRoundID()).append(", errorCode=");
                ConversationStateMessage.ErrorDetail errorInfo = state.getErrorInfo();
                StringBuilder append2 = append.append(errorInfo != null ? Integer.valueOf(errorInfo.getErrorCode()) : null).append(", errorReasonHash=");
                ConversationStateMessage.ErrorDetail errorInfo2 = state.getErrorInfo();
                String reason = errorInfo2 != null ? errorInfo2.getReason() : null;
                if (reason == null) {
                    reason = "";
                }
                rtcDiag = brainstormViewModel.rtcDiag(append2.append(reason.hashCode()).toString());
                fLogger.d("BrainstormViewModel", rtcDiag);
                String description = state.getStage().getDescription();
                int code = state.getStage().getCode();
                if (code == 0) {
                    voiceHealthMonitor = BrainstormViewModel.this.voiceHealthMonitor;
                    voiceHealthMonitor.setAiListening(false);
                    BrainstormViewModel.this.stopOutputVolumeMonitoring();
                    ConversationStateMessage.ErrorDetail errorInfo3 = state.getErrorInfo();
                    String reason2 = errorInfo3 != null ? errorInfo3.getReason() : null;
                    String str = reason2 != null ? reason2 : "";
                    BrainstormViewModel brainstormViewModel2 = BrainstormViewModel.this;
                    VoiceDiscussionAttemptSignal voiceDiscussionAttemptSignal = VoiceDiscussionAttemptSignal.CONVERSATION_ERROR;
                    StringBuilder sb = new StringBuilder("conversation_error_");
                    ConversationStateMessage.ErrorDetail errorInfo4 = state.getErrorInfo();
                    String sb2 = sb.append(errorInfo4 != null ? Integer.valueOf(errorInfo4.getErrorCode()) : null).toString();
                    ConversationStateMessage.ErrorDetail errorInfo5 = state.getErrorInfo();
                    brainstormViewModel2.recordVoiceAttemptSignal(voiceDiscussionAttemptSignal, sb2, errorInfo5 != null ? errorInfo5.getErrorCode() : 0);
                    MutableStateFlow mutableStateFlow = BrainstormViewModel.this._uiState;
                    do {
                        value = mutableStateFlow.getValue();
                        copy = r8.copy((r42 & 1) != 0 ? r8.phase : null, (r42 & 2) != 0 ? r8.subtitleHistory : null, (r42 & 4) != 0 ? r8.recordingState : null, (r42 & 8) != 0 ? r8.aiReplyState : AiReplyState.Idle, (r42 & 16) != 0 ? r8.aiParticipantState : ParticipantState.Idle, (r42 & 32) != 0 ? r8.userParticipantState : null, (r42 & 64) != 0 ? r8.currentTranscript : null, (r42 & 128) != 0 ? r8.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r8.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r8.isSpeakerOn : false, (r42 & 1024) != 0 ? r8.isMicMuted : false, (r42 & 2048) != 0 ? r8.isSubtitleMode : false, (r42 & 4096) != 0 ? r8.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r8.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r8.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r8.timeoutState : null, (65536 & r42) != 0 ? r8.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r8.aiStageDescription : "error: " + str, (r42 & 262144) != 0 ? r8.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r8.subTask : null, (r42 & 1048576) != 0 ? r8.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value).attachments : null);
                    } while (!mutableStateFlow.compareAndSet(value, copy));
                    FLogger fLogger2 = FLogger.INSTANCE;
                    BrainstormViewModel brainstormViewModel3 = BrainstormViewModel.this;
                    StringBuilder sb3 = new StringBuilder("AI error stage: code=");
                    ConversationStateMessage.ErrorDetail errorInfo6 = state.getErrorInfo();
                    rtcDiag2 = brainstormViewModel3.rtcDiag(sb3.append(errorInfo6 != null ? Integer.valueOf(errorInfo6.getErrorCode()) : null).append(", reasonLength=").append(str.length()).append(", reasonHash=").append(str.hashCode()).toString());
                    fLogger2.w("BrainstormViewModel", rtcDiag2);
                    return;
                }
                if (code == 1) {
                    voiceHealthMonitor2 = BrainstormViewModel.this.voiceHealthMonitor;
                    voiceHealthMonitor2.setAiListening(true);
                    BrainstormViewModel.this.stopOutputVolumeMonitoring();
                    MutableStateFlow mutableStateFlow2 = BrainstormViewModel.this._uiState;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        copy2 = r8.copy((r42 & 1) != 0 ? r8.phase : null, (r42 & 2) != 0 ? r8.subtitleHistory : null, (r42 & 4) != 0 ? r8.recordingState : null, (r42 & 8) != 0 ? r8.aiReplyState : null, (r42 & 16) != 0 ? r8.aiParticipantState : ParticipantState.Idle, (r42 & 32) != 0 ? r8.userParticipantState : null, (r42 & 64) != 0 ? r8.currentTranscript : null, (r42 & 128) != 0 ? r8.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r8.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r8.isSpeakerOn : false, (r42 & 1024) != 0 ? r8.isMicMuted : false, (r42 & 2048) != 0 ? r8.isSubtitleMode : false, (r42 & 4096) != 0 ? r8.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r8.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r8.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r8.timeoutState : null, (65536 & r42) != 0 ? r8.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r8.aiStageDescription : description, (r42 & 262144) != 0 ? r8.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r8.subTask : null, (r42 & 1048576) != 0 ? r8.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value2).attachments : null);
                    } while (!mutableStateFlow2.compareAndSet(value2, copy2));
                    return;
                }
                if (code == 2) {
                    BrainstormViewModel.this.recordVoiceAttemptStage(VoiceDiscussionAttemptStage.THINKING_RECEIVED);
                    voiceHealthMonitor3 = BrainstormViewModel.this.voiceHealthMonitor;
                    voiceHealthMonitor3.setAiListening(false);
                    BrainstormViewModel.this.stopOutputVolumeMonitoring();
                    MutableStateFlow mutableStateFlow3 = BrainstormViewModel.this._uiState;
                    do {
                        value3 = mutableStateFlow3.getValue();
                        copy3 = r8.copy((r42 & 1) != 0 ? r8.phase : null, (r42 & 2) != 0 ? r8.subtitleHistory : null, (r42 & 4) != 0 ? r8.recordingState : null, (r42 & 8) != 0 ? r8.aiReplyState : null, (r42 & 16) != 0 ? r8.aiParticipantState : ParticipantState.Thinking, (r42 & 32) != 0 ? r8.userParticipantState : null, (r42 & 64) != 0 ? r8.currentTranscript : null, (r42 & 128) != 0 ? r8.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r8.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r8.isSpeakerOn : false, (r42 & 1024) != 0 ? r8.isMicMuted : false, (r42 & 2048) != 0 ? r8.isSubtitleMode : false, (r42 & 4096) != 0 ? r8.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r8.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r8.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r8.timeoutState : null, (65536 & r42) != 0 ? r8.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r8.aiStageDescription : description, (r42 & 262144) != 0 ? r8.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r8.subTask : null, (r42 & 1048576) != 0 ? r8.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value3).attachments : null);
                    } while (!mutableStateFlow3.compareAndSet(value3, copy3));
                    BrainstormViewModel.this.closeLastRoundAsInterruptedIfNeeded("new_thinking");
                    long currentTimeMillis = System.currentTimeMillis();
                    list = BrainstormViewModel.this.sessionUserSpeakEndTimestamps;
                    list.add(Long.valueOf(currentTimeMillis));
                    list2 = BrainstormViewModel.this.sessionRoundDelays;
                    i = BrainstormViewModel.this.roundIndexSeq;
                    BrainstormViewModel.this.roundIndexSeq = i + 1;
                    l = BrainstormViewModel.this.pendingUserSpeakStartMs;
                    l2 = BrainstormViewModel.this.pendingUserSubtitleFirstCharMs;
                    l3 = BrainstormViewModel.this.pendingUserSubtitleLastCharMs;
                    list2.add(new BrainstormViewModel.RoundDelayRecord(i, state.getRoundID(), currentTimeMillis, null, null, null, null, 0, 0, 0, l, l2, l3, false, false, null, false, false, false, false, 0, null, 4187128, null));
                    BrainstormViewModel.this.awaitingBotFirstChar = true;
                    return;
                }
                if (code == 3) {
                    voiceHealthMonitor4 = BrainstormViewModel.this.voiceHealthMonitor;
                    voiceHealthMonitor4.setAiListening(false);
                    MutableStateFlow mutableStateFlow4 = BrainstormViewModel.this._uiState;
                    do {
                        value4 = mutableStateFlow4.getValue();
                        copy4 = r8.copy((r42 & 1) != 0 ? r8.phase : null, (r42 & 2) != 0 ? r8.subtitleHistory : null, (r42 & 4) != 0 ? r8.recordingState : null, (r42 & 8) != 0 ? r8.aiReplyState : null, (r42 & 16) != 0 ? r8.aiParticipantState : ParticipantState.Speaking, (r42 & 32) != 0 ? r8.userParticipantState : null, (r42 & 64) != 0 ? r8.currentTranscript : null, (r42 & 128) != 0 ? r8.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r8.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r8.isSpeakerOn : false, (r42 & 1024) != 0 ? r8.isMicMuted : false, (r42 & 2048) != 0 ? r8.isSubtitleMode : false, (r42 & 4096) != 0 ? r8.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r8.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r8.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r8.timeoutState : null, (65536 & r42) != 0 ? r8.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r8.aiStageDescription : description, (r42 & 262144) != 0 ? r8.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r8.subTask : null, (r42 & 1048576) != 0 ? r8.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value4).attachments : null);
                    } while (!mutableStateFlow4.compareAndSet(value4, copy4));
                    BrainstormViewModel.this.restartOutputVolumeMonitoring("answering");
                    currentRound = BrainstormViewModel.this.currentRound();
                    if (currentRound != null) {
                        BrainstormViewModel brainstormViewModel4 = BrainstormViewModel.this;
                        if (currentRound.getBotAnsweringMs() == null) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            currentRound.setBotAnsweringMs(Long.valueOf(currentTimeMillis2));
                            list3 = brainstormViewModel4.sessionBotSpeakStartTimestamps;
                            list3.add(Long.valueOf(currentTimeMillis2));
                        }
                    }
                    BrainstormViewModel.this.reportDiscussionStartPerfIfNeeded();
                    return;
                }
                if (code == 4) {
                    voiceHealthMonitor5 = BrainstormViewModel.this.voiceHealthMonitor;
                    voiceHealthMonitor5.setAiListening(false);
                    BrainstormViewModel.this.stopOutputVolumeMonitoring();
                    MutableStateFlow mutableStateFlow5 = BrainstormViewModel.this._uiState;
                    do {
                        value5 = mutableStateFlow5.getValue();
                        copy5 = r8.copy((r42 & 1) != 0 ? r8.phase : null, (r42 & 2) != 0 ? r8.subtitleHistory : null, (r42 & 4) != 0 ? r8.recordingState : null, (r42 & 8) != 0 ? r8.aiReplyState : AiReplyState.Idle, (r42 & 16) != 0 ? r8.aiParticipantState : ParticipantState.Idle, (r42 & 32) != 0 ? r8.userParticipantState : null, (r42 & 64) != 0 ? r8.currentTranscript : null, (r42 & 128) != 0 ? r8.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r8.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r8.isSpeakerOn : false, (r42 & 1024) != 0 ? r8.isMicMuted : false, (r42 & 2048) != 0 ? r8.isSubtitleMode : false, (r42 & 4096) != 0 ? r8.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r8.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r8.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r8.timeoutState : null, (65536 & r42) != 0 ? r8.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r8.aiStageDescription : description, (r42 & 262144) != 0 ? r8.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r8.subTask : null, (r42 & 1048576) != 0 ? r8.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value5).attachments : null);
                    } while (!mutableStateFlow5.compareAndSet(value5, copy5));
                    currentRound2 = BrainstormViewModel.this.currentRound();
                    if (currentRound2 == null || currentRound2.getReported()) {
                        return;
                    }
                    currentRound2.setInterrupted(true);
                    currentRound2.setInterruptPhase(currentRound2.getBotFirstCharMs() != null ? BrainstormViewModel.InterruptPhase.DURING_ANSWERING : currentRound2.getBotAnsweringMs() == null ? BrainstormViewModel.InterruptPhase.BEFORE_ANSWERING : BrainstormViewModel.InterruptPhase.BEFORE_FIRST_CHAR);
                    BrainstormViewModel.this.awaitingBotFirstChar = false;
                    BrainstormViewModel.this.tryReportRoundIfFinal(currentRound2, "interrupted_stage");
                    return;
                }
                if (code != 5) {
                    return;
                }
                voiceHealthMonitor6 = BrainstormViewModel.this.voiceHealthMonitor;
                voiceHealthMonitor6.setAiListening(false);
                BrainstormViewModel.this.stopOutputVolumeMonitoring();
                MutableStateFlow mutableStateFlow6 = BrainstormViewModel.this._uiState;
                do {
                    value6 = mutableStateFlow6.getValue();
                    copy6 = r8.copy((r42 & 1) != 0 ? r8.phase : null, (r42 & 2) != 0 ? r8.subtitleHistory : null, (r42 & 4) != 0 ? r8.recordingState : null, (r42 & 8) != 0 ? r8.aiReplyState : AiReplyState.Idle, (r42 & 16) != 0 ? r8.aiParticipantState : ParticipantState.Idle, (r42 & 32) != 0 ? r8.userParticipantState : null, (r42 & 64) != 0 ? r8.currentTranscript : null, (r42 & 128) != 0 ? r8.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r8.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r8.isSpeakerOn : false, (r42 & 1024) != 0 ? r8.isMicMuted : false, (r42 & 2048) != 0 ? r8.isSubtitleMode : false, (r42 & 4096) != 0 ? r8.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r8.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r8.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r8.timeoutState : null, (65536 & r42) != 0 ? r8.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r8.aiStageDescription : description, (r42 & 262144) != 0 ? r8.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r8.subTask : null, (r42 & 1048576) != 0 ? r8.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value6).attachments : null);
                } while (!mutableStateFlow6.compareAndSet(value6, copy6));
                currentRound3 = BrainstormViewModel.this.currentRound();
                if (currentRound3 != null) {
                    BrainstormViewModel brainstormViewModel5 = BrainstormViewModel.this;
                    if (currentRound3.getBotFinishMs() == null) {
                        currentRound3.setBotFinishMs(Long.valueOf(System.currentTimeMillis()));
                    }
                    brainstormViewModel5.tryReportRoundIfFinal(currentRound3, "answer_finish");
                }
            }

            @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
            public void onLocalAudioVolume(float volume) {
                MutableSharedFlow mutableSharedFlow;
                VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker;
                boolean z;
                Long l;
                BrainstormViewModel.RoundDelayRecord currentRound;
                Long l2;
                mutableSharedFlow = BrainstormViewModel.this._localAudioVolume;
                mutableSharedFlow.tryEmit(Float.valueOf(volume));
                boolean z2 = false;
                if (volume >= 0.05f) {
                    voiceDiscussionAttemptTracker = BrainstormViewModel.this.voiceDiscussionAttemptTracker;
                    if (voiceDiscussionAttemptTracker != null) {
                        BrainstormViewModel brainstormViewModel = BrainstormViewModel.this;
                        VoiceDiscussionAttemptState snapshot = voiceDiscussionAttemptTracker.snapshot();
                        if (!snapshot.getTerminalReported() && !snapshot.getStageElapsedMs().containsKey(VoiceDiscussionAttemptStage.FIRST_VOICE_DETECTED.getValue())) {
                            brainstormViewModel.refreshVoiceAttemptContext();
                            voiceDiscussionAttemptTracker.onLocalAudioVolume(volume);
                        }
                    }
                    z = BrainstormViewModel.this.userVadActive;
                    if (z) {
                        return;
                    }
                    BrainstormViewModel.this.userVadActive = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    l = BrainstormViewModel.this.pendingUserSpeakStartMs;
                    if (l == null) {
                        BrainstormViewModel.this.pendingUserSpeakStartMs = Long.valueOf(currentTimeMillis);
                    }
                    currentRound = BrainstormViewModel.this.currentRound();
                    if (currentRound != null) {
                        if (!currentRound.getReported() && !currentRound.getUserFinalReceived() && currentRound.getUserSpeakStartMs() == null) {
                            z2 = true;
                        }
                        if (!z2) {
                            currentRound = null;
                        }
                        if (currentRound != null) {
                            l2 = BrainstormViewModel.this.pendingUserSpeakStartMs;
                            currentRound.setUserSpeakStartMs(l2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                BrainstormViewModel.this.userVadActive = false;
            }

            @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
            public void onRtcAudioProperties(VolcRtcClient.RtcLocalAudioProperties properties) {
                VoiceHealthMonitor voiceHealthMonitor;
                MutableSharedFlow mutableSharedFlow;
                Intrinsics.checkNotNullParameter(properties, "properties");
                voiceHealthMonitor = BrainstormViewModel.this.voiceHealthMonitor;
                VoicePrompt.Health onRtcAudioProperties = voiceHealthMonitor.onRtcAudioProperties(properties, (BrainstormUiState) BrainstormViewModel.this._uiState.getValue());
                if (onRtcAudioProperties != null) {
                    mutableSharedFlow = BrainstormViewModel.this._voicePromptEvents;
                    mutableSharedFlow.tryEmit(onRtcAudioProperties);
                }
            }

            @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
            public void onRtcNetworkQuality(VolcRtcClient.RtcNetworkQuality local, List<VolcRtcClient.RtcNetworkQuality> remotes) {
                VoiceHealthMonitor voiceHealthMonitor;
                MutableSharedFlow mutableSharedFlow;
                Intrinsics.checkNotNullParameter(local, "local");
                Intrinsics.checkNotNullParameter(remotes, "remotes");
                voiceHealthMonitor = BrainstormViewModel.this.voiceHealthMonitor;
                List<VoicePrompt.Health> onRtcNetworkQuality = voiceHealthMonitor.onRtcNetworkQuality(local, (BrainstormUiState) BrainstormViewModel.this._uiState.getValue());
                BrainstormViewModel brainstormViewModel = BrainstormViewModel.this;
                for (VoicePrompt.Health health : onRtcNetworkQuality) {
                    mutableSharedFlow = brainstormViewModel._voicePromptEvents;
                    mutableSharedFlow.tryEmit(health);
                }
            }

            @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
            public void onRtcAudioInputDeviceStateChanged(String deviceId, int state, int error) {
                VoiceHealthMonitor voiceHealthMonitor;
                MutableSharedFlow mutableSharedFlow;
                Intrinsics.checkNotNullParameter(deviceId, "deviceId");
                voiceHealthMonitor = BrainstormViewModel.this.voiceHealthMonitor;
                VoicePrompt.Health onRtcAudioInputDeviceStateChanged = voiceHealthMonitor.onRtcAudioInputDeviceStateChanged(state, error, (BrainstormUiState) BrainstormViewModel.this._uiState.getValue());
                if (onRtcAudioInputDeviceStateChanged != null) {
                    mutableSharedFlow = BrainstormViewModel.this._voicePromptEvents;
                    mutableSharedFlow.tryEmit(onRtcAudioInputDeviceStateChanged);
                }
            }

            @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
            public void onPerfTimestamp(BMVoiceChatSessionManager.PerfEvent event, long timestampMs) {
                Intrinsics.checkNotNullParameter(event, Fields.EVENT);
                int i = WhenMappings.$EnumSwitchMapping$2[event.ordinal()];
                if (i == 1) {
                    BrainstormViewModel.this.perfApiRequestStartMs = timestampMs;
                    return;
                }
                if (i == 2) {
                    BrainstormViewModel.this.perfJoinRoomStartMs = timestampMs;
                } else if (i == 3) {
                    BrainstormViewModel.this.perfJoinRoomSuccessMs = timestampMs;
                } else {
                    if (i == 4) {
                        BrainstormViewModel.this.perfBotJoinedMs = timestampMs;
                        return;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }

            @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
            public void onVoiceChatDataReady(StartVoiceChatData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                VoiceSubTaskCoordinator.INSTANCE.updateSubTaskConfig(data.getSubTaskConfig());
            }

            @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
            public void onRtcTextMessage(String uid, String message) {
                BMVoiceChatSessionManager bMVoiceChatSessionManager;
                String str;
                BMVoiceChatSessionManager bMVoiceChatSessionManager2;
                BMVoiceChatSessionManager bMVoiceChatSessionManager3;
                BMVoiceChatSessionManager bMVoiceChatSessionManager4;
                BMVoiceChatSessionManager bMVoiceChatSessionManager5;
                BMVoiceChatSessionManager bMVoiceChatSessionManager6;
                Intrinsics.checkNotNullParameter(uid, "uid");
                Intrinsics.checkNotNullParameter(message, "message");
                String peekSubTaskMessageType = SubTaskProtocolKt.peekSubTaskMessageType(message);
                if (peekSubTaskMessageType != null) {
                    switch (peekSubTaskMessageType.hashCode()) {
                        case -906867340:
                            if (peekSubTaskMessageType.equals(SubTaskRequestMessage.TYPE)) {
                                SubTaskRequestMessage parseSubTaskRequest = SubTaskProtocolKt.parseSubTaskRequest(message);
                                if (parseSubTaskRequest == null) {
                                    BrainstormViewModel.this.logUnrecognizedRtcFrame(uid, message, "invalid sub_task_request");
                                    return;
                                }
                                bMVoiceChatSessionManager4 = BrainstormViewModel.this.voiceChatSession;
                                String roomId = bMVoiceChatSessionManager4 != null ? bMVoiceChatSessionManager4.getRoomId() : null;
                                str = roomId != null ? roomId : "";
                                if (VoiceSubTaskCoordinator.INSTANCE.handleSubTaskRequest(parseSubTaskRequest, str.length() > 0 ? str : null)) {
                                    BrainstormViewModel.this.markCurrentRoundHasSubtask();
                                    return;
                                }
                                return;
                            }
                            break;
                        case 180893308:
                            if (peekSubTaskMessageType.equals(TaskStopMessage.TYPE)) {
                                TaskStopMessage parseTaskStop = SubTaskProtocolKt.parseTaskStop(message);
                                if (parseTaskStop == null) {
                                    BrainstormViewModel.this.logUnrecognizedRtcFrame(uid, message, "invalid task_stop");
                                    return;
                                }
                                bMVoiceChatSessionManager5 = BrainstormViewModel.this.voiceChatSession;
                                String roomId2 = bMVoiceChatSessionManager5 != null ? bMVoiceChatSessionManager5.getRoomId() : null;
                                str = roomId2 != null ? roomId2 : "";
                                VoiceSubTaskCoordinator.INSTANCE.handleTaskStop(parseTaskStop, str.length() > 0 ? str : null);
                                return;
                            }
                            break;
                        case 1312711976:
                            if (peekSubTaskMessageType.equals(TaskStartMessage.TYPE)) {
                                TaskStartMessage parseTaskStart = SubTaskProtocolKt.parseTaskStart(message);
                                if (parseTaskStart == null) {
                                    BrainstormViewModel.this.logUnrecognizedRtcFrame(uid, message, "invalid task_start");
                                    return;
                                }
                                BrainstormViewModel.this.markCurrentRoundServerTool(parseTaskStart.getToolName());
                                VoiceDiscussionMetrics.INSTANCE.recordServerToolStart(parseTaskStart);
                                VoiceSubTaskCoordinator.INSTANCE.handleTaskStart(parseTaskStart);
                                return;
                            }
                            break;
                        case 1997422615:
                            if (peekSubTaskMessageType.equals(ToolResultMessage.TYPE)) {
                                ToolResultMessage parseToolResult = SubTaskProtocolKt.parseToolResult(message);
                                if (parseToolResult == null) {
                                    BrainstormViewModel.this.logUnrecognizedRtcFrame(uid, message, "invalid task_result");
                                    return;
                                } else {
                                    if (VoiceSubTaskCoordinator.INSTANCE.handleToolResult(parseToolResult)) {
                                        BrainstormViewModel.this.markCurrentRoundServerTool(parseToolResult.getToolName());
                                        BrainstormViewModel.this.reportServerToolEnd(parseToolResult);
                                        return;
                                    }
                                    return;
                                }
                            }
                            break;
                        case 2093002947:
                            if (peekSubTaskMessageType.equals(SubTaskRequestMessage.TYPE_UPDATE)) {
                                SubTaskRequestMessage parseSubTaskUpdate = SubTaskProtocolKt.parseSubTaskUpdate(message);
                                if (parseSubTaskUpdate == null) {
                                    BrainstormViewModel.this.logUnrecognizedRtcFrame(uid, message, "invalid task_update");
                                    return;
                                }
                                bMVoiceChatSessionManager6 = BrainstormViewModel.this.voiceChatSession;
                                String roomId3 = bMVoiceChatSessionManager6 != null ? bMVoiceChatSessionManager6.getRoomId() : null;
                                str = roomId3 != null ? roomId3 : "";
                                if (VoiceSubTaskCoordinator.INSTANCE.handleSubTaskUpdate(parseSubTaskUpdate, str.length() > 0 ? str : null)) {
                                    BrainstormViewModel.this.markCurrentRoundHasSubtask();
                                    return;
                                }
                                return;
                            }
                            break;
                    }
                }
                SubTaskRequestMessage parseSubTaskRequest2 = SubTaskProtocolKt.parseSubTaskRequest(message);
                if (parseSubTaskRequest2 != null) {
                    BrainstormViewModel brainstormViewModel = BrainstormViewModel.this;
                    bMVoiceChatSessionManager3 = brainstormViewModel.voiceChatSession;
                    String roomId4 = bMVoiceChatSessionManager3 != null ? bMVoiceChatSessionManager3.getRoomId() : null;
                    str = roomId4 != null ? roomId4 : "";
                    if (VoiceSubTaskCoordinator.INSTANCE.handleSubTaskRequest(parseSubTaskRequest2, str.length() > 0 ? str : null)) {
                        brainstormViewModel.markCurrentRoundHasSubtask();
                        return;
                    }
                    return;
                }
                SubTaskRequestMessage parseSubTaskUpdate2 = SubTaskProtocolKt.parseSubTaskUpdate(message);
                if (parseSubTaskUpdate2 != null) {
                    BrainstormViewModel brainstormViewModel2 = BrainstormViewModel.this;
                    bMVoiceChatSessionManager2 = brainstormViewModel2.voiceChatSession;
                    String roomId5 = bMVoiceChatSessionManager2 != null ? bMVoiceChatSessionManager2.getRoomId() : null;
                    str = roomId5 != null ? roomId5 : "";
                    if (VoiceSubTaskCoordinator.INSTANCE.handleSubTaskUpdate(parseSubTaskUpdate2, str.length() > 0 ? str : null)) {
                        brainstormViewModel2.markCurrentRoundHasSubtask();
                        return;
                    }
                    return;
                }
                TaskStartMessage parseTaskStart2 = SubTaskProtocolKt.parseTaskStart(message);
                if (parseTaskStart2 != null) {
                    BrainstormViewModel.this.markCurrentRoundServerTool(parseTaskStart2.getToolName());
                    VoiceDiscussionMetrics.INSTANCE.recordServerToolStart(parseTaskStart2);
                    VoiceSubTaskCoordinator.INSTANCE.handleTaskStart(parseTaskStart2);
                    return;
                }
                TaskStopMessage parseTaskStop2 = SubTaskProtocolKt.parseTaskStop(message);
                if (parseTaskStop2 != null) {
                    bMVoiceChatSessionManager = BrainstormViewModel.this.voiceChatSession;
                    String roomId6 = bMVoiceChatSessionManager != null ? bMVoiceChatSessionManager.getRoomId() : null;
                    str = roomId6 != null ? roomId6 : "";
                    VoiceSubTaskCoordinator.INSTANCE.handleTaskStop(parseTaskStop2, str.length() > 0 ? str : null);
                    return;
                }
                ToolResultMessage parseToolResult2 = SubTaskProtocolKt.parseToolResult(message);
                if (parseToolResult2 == null) {
                    BrainstormViewModel.logUnrecognizedRtcFrame$default(BrainstormViewModel.this, uid, message, null, 4, null);
                    return;
                }
                BrainstormViewModel brainstormViewModel3 = BrainstormViewModel.this;
                if (VoiceSubTaskCoordinator.INSTANCE.handleToolResult(parseToolResult2)) {
                    brainstormViewModel3.markCurrentRoundServerTool(parseToolResult2.getToolName());
                    brainstormViewModel3.reportServerToolEnd(parseToolResult2);
                }
            }
        };
        ViewModel viewModel = (ViewModel) this;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(viewModel), (CoroutineContext) null, (CoroutineStart) null, new C06561(null), 3, (Object) null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(viewModel), (CoroutineContext) null, (CoroutineStart) null, new C06572(null), 3, (Object) null);
    }

    /* compiled from: BrainstormViewModel.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$Companion;", "", "<init>", "()V", "TAG", "", "TIMEOUT_WARNING_THRESHOLD_MS", "", "TIMEOUT_COUNTDOWN_SECONDS", "", "EVENT_DISCUSSION_START_PERF", "EVENT_DISCUSSION_SESSION_PERF", "EVENT_DISCUSSION_ROUND_PERF", "EVENT_DISCUSSION_SESSION_END", "PERF_MISSING_VALUE", "USER_SPEAK_VAD_THRESHOLD", "", "OUTPUT_VOLUME_ROUTE_SETTLE_DELAY_MS", "OUTPUT_VOLUME_CHECK_INTERVAL_MS", "MAX_ATTACHMENT_SIZE_BYTES", "MAX_TOTAL_ATTACHMENT_SIZE_BYTES", "TERMINAL_SUB_TASK_STATES", "", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;", "formatDuration", "ms", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String formatDuration(long ms) {
            long j = ms / 1000;
            long j2 = 3600;
            long j3 = j / j2;
            long j4 = 60;
            long j5 = (j % j2) / j4;
            long j6 = j % j4;
            if (j3 > 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j3), Long.valueOf(j5), Long.valueOf(j6)}, 3));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                return format;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j5), Long.valueOf(j6)}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String rtcDiag(String message) {
        return "RTC_DIAG " + message;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BrainstormViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BEFORE_ANSWERING", "BEFORE_FIRST_CHAR", "DURING_ANSWERING", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class InterruptPhase {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ InterruptPhase[] $VALUES;
        public static final InterruptPhase BEFORE_ANSWERING = new InterruptPhase("BEFORE_ANSWERING", 0, "before_answering");
        public static final InterruptPhase BEFORE_FIRST_CHAR = new InterruptPhase("BEFORE_FIRST_CHAR", 1, "before_first_char");
        public static final InterruptPhase DURING_ANSWERING = new InterruptPhase("DURING_ANSWERING", 2, "during_answering");
        private final String value;

        private static final /* synthetic */ InterruptPhase[] $values() {
            return new InterruptPhase[]{BEFORE_ANSWERING, BEFORE_FIRST_CHAR, DURING_ANSWERING};
        }

        public static EnumEntries<InterruptPhase> getEntries() {
            return $ENTRIES;
        }

        private InterruptPhase(String str, int i, String str2) {
            this.value = str2;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            InterruptPhase[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static InterruptPhase valueOf(String str) {
            return (InterruptPhase) Enum.valueOf(InterruptPhase.class, str);
        }

        public static InterruptPhase[] values() {
            return (InterruptPhase[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BrainstormViewModel.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\bR\b\u0082\b\u0018\u00002\u00020\u0001Bó\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010&J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010&J\t\u0010`\u001a\u00020\u0012HÆ\u0003J\t\u0010a\u001a\u00020\u0012HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010c\u001a\u00020\u0012HÆ\u0003J\t\u0010d\u001a\u00020\u0012HÆ\u0003J\t\u0010e\u001a\u00020\u0012HÆ\u0003J\t\u0010f\u001a\u00020\u0012HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\u000f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cHÆ\u0003J\u0080\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00032\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cHÆ\u0001¢\u0006\u0002\u0010jJ\u0013\u0010k\u001a\u00020\u00122\b\u0010l\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010m\u001a\u00020\u0003HÖ\u0001J\t\u0010n\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b,\u0010&\"\u0004\b-\u0010(R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b.\u0010&\"\u0004\b/\u0010(R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010!\"\u0004\b1\u00102R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010!\"\u0004\b4\u00102R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010!\"\u0004\b6\u00102R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b7\u0010&\"\u0004\b8\u0010(R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b;\u0010&\"\u0004\b<\u0010(R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010>\"\u0004\bB\u0010@R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010\u0016\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010>\"\u0004\bH\u0010@R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010>\"\u0004\bJ\u0010@R\u001a\u0010\u0018\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R\u001a\u0010\u0019\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010>\"\u0004\bN\u0010@R\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010!\"\u0004\bP\u00102R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010R¨\u0006o"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;", "", "roundIndex", "", "convRoundId", "", "userSpeakEndMs", "botAnsweringMs", "botFirstCharMs", "botLatestCharMs", "botFinishMs", "userCharCount", "botCharCount", "botCurrentParagraphChars", "userSpeakStartMs", "userSubtitleFirstCharMs", "userSubtitleLastCharMs", "userFinalReceived", "", "interrupted", "interruptPhase", "Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;", "reported", "hasSearch", "hasSubtask", "hasUpload", "attachmentCount", "toolNames", "", "", "<init>", "(IJJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;IIILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;ZZLcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;ZZZZILjava/util/Set;)V", "getRoundIndex", "()I", "getConvRoundId", "()J", "getUserSpeakEndMs", "getBotAnsweringMs", "()Ljava/lang/Long;", "setBotAnsweringMs", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getBotFirstCharMs", "setBotFirstCharMs", "getBotLatestCharMs", "setBotLatestCharMs", "getBotFinishMs", "setBotFinishMs", "getUserCharCount", "setUserCharCount", "(I)V", "getBotCharCount", "setBotCharCount", "getBotCurrentParagraphChars", "setBotCurrentParagraphChars", "getUserSpeakStartMs", "setUserSpeakStartMs", "getUserSubtitleFirstCharMs", "setUserSubtitleFirstCharMs", "getUserSubtitleLastCharMs", "setUserSubtitleLastCharMs", "getUserFinalReceived", "()Z", "setUserFinalReceived", "(Z)V", "getInterrupted", "setInterrupted", "getInterruptPhase", "()Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;", "setInterruptPhase", "(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;)V", "getReported", "setReported", "getHasSearch", "setHasSearch", "getHasSubtask", "setHasSubtask", "getHasUpload", "setHasUpload", "getAttachmentCount", "setAttachmentCount", "getToolNames", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(IJJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;IIILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;ZZLcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$InterruptPhase;ZZZZILjava/util/Set;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$RoundDelayRecord;", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class RoundDelayRecord {
        private int attachmentCount;
        private Long botAnsweringMs;
        private int botCharCount;
        private int botCurrentParagraphChars;
        private Long botFinishMs;
        private Long botFirstCharMs;
        private Long botLatestCharMs;
        private final long convRoundId;
        private boolean hasSearch;
        private boolean hasSubtask;
        private boolean hasUpload;
        private InterruptPhase interruptPhase;
        private boolean interrupted;
        private boolean reported;
        private final int roundIndex;
        private final Set<String> toolNames;
        private int userCharCount;
        private boolean userFinalReceived;
        private final long userSpeakEndMs;
        private Long userSpeakStartMs;
        private Long userSubtitleFirstCharMs;
        private Long userSubtitleLastCharMs;

        /* renamed from: component1, reason: from getter */
        public final int getRoundIndex() {
            return this.roundIndex;
        }

        /* renamed from: component10, reason: from getter */
        public final int getBotCurrentParagraphChars() {
            return this.botCurrentParagraphChars;
        }

        /* renamed from: component11, reason: from getter */
        public final Long getUserSpeakStartMs() {
            return this.userSpeakStartMs;
        }

        /* renamed from: component12, reason: from getter */
        public final Long getUserSubtitleFirstCharMs() {
            return this.userSubtitleFirstCharMs;
        }

        /* renamed from: component13, reason: from getter */
        public final Long getUserSubtitleLastCharMs() {
            return this.userSubtitleLastCharMs;
        }

        /* renamed from: component14, reason: from getter */
        public final boolean getUserFinalReceived() {
            return this.userFinalReceived;
        }

        /* renamed from: component15, reason: from getter */
        public final boolean getInterrupted() {
            return this.interrupted;
        }

        /* renamed from: component16, reason: from getter */
        public final InterruptPhase getInterruptPhase() {
            return this.interruptPhase;
        }

        /* renamed from: component17, reason: from getter */
        public final boolean getReported() {
            return this.reported;
        }

        /* renamed from: component18, reason: from getter */
        public final boolean getHasSearch() {
            return this.hasSearch;
        }

        /* renamed from: component19, reason: from getter */
        public final boolean getHasSubtask() {
            return this.hasSubtask;
        }

        /* renamed from: component2, reason: from getter */
        public final long getConvRoundId() {
            return this.convRoundId;
        }

        /* renamed from: component20, reason: from getter */
        public final boolean getHasUpload() {
            return this.hasUpload;
        }

        /* renamed from: component21, reason: from getter */
        public final int getAttachmentCount() {
            return this.attachmentCount;
        }

        public final Set<String> component22() {
            return this.toolNames;
        }

        /* renamed from: component3, reason: from getter */
        public final long getUserSpeakEndMs() {
            return this.userSpeakEndMs;
        }

        /* renamed from: component4, reason: from getter */
        public final Long getBotAnsweringMs() {
            return this.botAnsweringMs;
        }

        /* renamed from: component5, reason: from getter */
        public final Long getBotFirstCharMs() {
            return this.botFirstCharMs;
        }

        /* renamed from: component6, reason: from getter */
        public final Long getBotLatestCharMs() {
            return this.botLatestCharMs;
        }

        /* renamed from: component7, reason: from getter */
        public final Long getBotFinishMs() {
            return this.botFinishMs;
        }

        /* renamed from: component8, reason: from getter */
        public final int getUserCharCount() {
            return this.userCharCount;
        }

        /* renamed from: component9, reason: from getter */
        public final int getBotCharCount() {
            return this.botCharCount;
        }

        public final RoundDelayRecord copy(int roundIndex, long convRoundId, long userSpeakEndMs, Long botAnsweringMs, Long botFirstCharMs, Long botLatestCharMs, Long botFinishMs, int userCharCount, int botCharCount, int botCurrentParagraphChars, Long userSpeakStartMs, Long userSubtitleFirstCharMs, Long userSubtitleLastCharMs, boolean userFinalReceived, boolean interrupted, InterruptPhase interruptPhase, boolean reported, boolean hasSearch, boolean hasSubtask, boolean hasUpload, int attachmentCount, Set<String> toolNames) {
            Intrinsics.checkNotNullParameter(toolNames, "toolNames");
            return new RoundDelayRecord(roundIndex, convRoundId, userSpeakEndMs, botAnsweringMs, botFirstCharMs, botLatestCharMs, botFinishMs, userCharCount, botCharCount, botCurrentParagraphChars, userSpeakStartMs, userSubtitleFirstCharMs, userSubtitleLastCharMs, userFinalReceived, interrupted, interruptPhase, reported, hasSearch, hasSubtask, hasUpload, attachmentCount, toolNames);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoundDelayRecord)) {
                return false;
            }
            RoundDelayRecord roundDelayRecord = (RoundDelayRecord) other;
            return this.roundIndex == roundDelayRecord.roundIndex && this.convRoundId == roundDelayRecord.convRoundId && this.userSpeakEndMs == roundDelayRecord.userSpeakEndMs && Intrinsics.areEqual(this.botAnsweringMs, roundDelayRecord.botAnsweringMs) && Intrinsics.areEqual(this.botFirstCharMs, roundDelayRecord.botFirstCharMs) && Intrinsics.areEqual(this.botLatestCharMs, roundDelayRecord.botLatestCharMs) && Intrinsics.areEqual(this.botFinishMs, roundDelayRecord.botFinishMs) && this.userCharCount == roundDelayRecord.userCharCount && this.botCharCount == roundDelayRecord.botCharCount && this.botCurrentParagraphChars == roundDelayRecord.botCurrentParagraphChars && Intrinsics.areEqual(this.userSpeakStartMs, roundDelayRecord.userSpeakStartMs) && Intrinsics.areEqual(this.userSubtitleFirstCharMs, roundDelayRecord.userSubtitleFirstCharMs) && Intrinsics.areEqual(this.userSubtitleLastCharMs, roundDelayRecord.userSubtitleLastCharMs) && this.userFinalReceived == roundDelayRecord.userFinalReceived && this.interrupted == roundDelayRecord.interrupted && this.interruptPhase == roundDelayRecord.interruptPhase && this.reported == roundDelayRecord.reported && this.hasSearch == roundDelayRecord.hasSearch && this.hasSubtask == roundDelayRecord.hasSubtask && this.hasUpload == roundDelayRecord.hasUpload && this.attachmentCount == roundDelayRecord.attachmentCount && Intrinsics.areEqual(this.toolNames, roundDelayRecord.toolNames);
        }

        public int hashCode() {
            int hashCode = ((((Integer.hashCode(this.roundIndex) * 31) + Long.hashCode(this.convRoundId)) * 31) + Long.hashCode(this.userSpeakEndMs)) * 31;
            Long l = this.botAnsweringMs;
            int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.botFirstCharMs;
            int hashCode3 = (hashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.botLatestCharMs;
            int hashCode4 = (hashCode3 + (l3 == null ? 0 : l3.hashCode())) * 31;
            Long l4 = this.botFinishMs;
            int hashCode5 = (((((((hashCode4 + (l4 == null ? 0 : l4.hashCode())) * 31) + Integer.hashCode(this.userCharCount)) * 31) + Integer.hashCode(this.botCharCount)) * 31) + Integer.hashCode(this.botCurrentParagraphChars)) * 31;
            Long l5 = this.userSpeakStartMs;
            int hashCode6 = (hashCode5 + (l5 == null ? 0 : l5.hashCode())) * 31;
            Long l6 = this.userSubtitleFirstCharMs;
            int hashCode7 = (hashCode6 + (l6 == null ? 0 : l6.hashCode())) * 31;
            Long l7 = this.userSubtitleLastCharMs;
            int hashCode8 = (((((hashCode7 + (l7 == null ? 0 : l7.hashCode())) * 31) + Boolean.hashCode(this.userFinalReceived)) * 31) + Boolean.hashCode(this.interrupted)) * 31;
            InterruptPhase interruptPhase = this.interruptPhase;
            return ((((((((((((hashCode8 + (interruptPhase != null ? interruptPhase.hashCode() : 0)) * 31) + Boolean.hashCode(this.reported)) * 31) + Boolean.hashCode(this.hasSearch)) * 31) + Boolean.hashCode(this.hasSubtask)) * 31) + Boolean.hashCode(this.hasUpload)) * 31) + Integer.hashCode(this.attachmentCount)) * 31) + this.toolNames.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("RoundDelayRecord(roundIndex=");
            sb.append(this.roundIndex).append(", convRoundId=").append(this.convRoundId).append(", userSpeakEndMs=").append(this.userSpeakEndMs).append(", botAnsweringMs=").append(this.botAnsweringMs).append(", botFirstCharMs=").append(this.botFirstCharMs).append(", botLatestCharMs=").append(this.botLatestCharMs).append(", botFinishMs=").append(this.botFinishMs).append(", userCharCount=").append(this.userCharCount).append(", botCharCount=").append(this.botCharCount).append(", botCurrentParagraphChars=").append(this.botCurrentParagraphChars).append(", userSpeakStartMs=").append(this.userSpeakStartMs).append(", userSubtitleFirstCharMs=");
            sb.append(this.userSubtitleFirstCharMs).append(", userSubtitleLastCharMs=").append(this.userSubtitleLastCharMs).append(", userFinalReceived=").append(this.userFinalReceived).append(", interrupted=").append(this.interrupted).append(", interruptPhase=").append(this.interruptPhase).append(", reported=").append(this.reported).append(", hasSearch=").append(this.hasSearch).append(", hasSubtask=").append(this.hasSubtask).append(", hasUpload=").append(this.hasUpload).append(", attachmentCount=").append(this.attachmentCount).append(", toolNames=").append(this.toolNames).append(')');
            return sb.toString();
        }

        public RoundDelayRecord(int i, long j, long j2, Long l, Long l2, Long l3, Long l4, int i2, int i3, int i4, Long l5, Long l6, Long l7, boolean z, boolean z2, InterruptPhase interruptPhase, boolean z3, boolean z4, boolean z5, boolean z6, int i5, Set<String> set) {
            Intrinsics.checkNotNullParameter(set, "toolNames");
            this.roundIndex = i;
            this.convRoundId = j;
            this.userSpeakEndMs = j2;
            this.botAnsweringMs = l;
            this.botFirstCharMs = l2;
            this.botLatestCharMs = l3;
            this.botFinishMs = l4;
            this.userCharCount = i2;
            this.botCharCount = i3;
            this.botCurrentParagraphChars = i4;
            this.userSpeakStartMs = l5;
            this.userSubtitleFirstCharMs = l6;
            this.userSubtitleLastCharMs = l7;
            this.userFinalReceived = z;
            this.interrupted = z2;
            this.interruptPhase = interruptPhase;
            this.reported = z3;
            this.hasSearch = z4;
            this.hasSubtask = z5;
            this.hasUpload = z6;
            this.attachmentCount = i5;
            this.toolNames = set;
        }

        public final int getRoundIndex() {
            return this.roundIndex;
        }

        public final long getConvRoundId() {
            return this.convRoundId;
        }

        public final long getUserSpeakEndMs() {
            return this.userSpeakEndMs;
        }

        public final Long getBotAnsweringMs() {
            return this.botAnsweringMs;
        }

        public final void setBotAnsweringMs(Long l) {
            this.botAnsweringMs = l;
        }

        public final Long getBotFirstCharMs() {
            return this.botFirstCharMs;
        }

        public final void setBotFirstCharMs(Long l) {
            this.botFirstCharMs = l;
        }

        public final Long getBotLatestCharMs() {
            return this.botLatestCharMs;
        }

        public final void setBotLatestCharMs(Long l) {
            this.botLatestCharMs = l;
        }

        public final Long getBotFinishMs() {
            return this.botFinishMs;
        }

        public final void setBotFinishMs(Long l) {
            this.botFinishMs = l;
        }

        public final int getUserCharCount() {
            return this.userCharCount;
        }

        public final void setUserCharCount(int i) {
            this.userCharCount = i;
        }

        public final int getBotCharCount() {
            return this.botCharCount;
        }

        public final void setBotCharCount(int i) {
            this.botCharCount = i;
        }

        public final int getBotCurrentParagraphChars() {
            return this.botCurrentParagraphChars;
        }

        public final void setBotCurrentParagraphChars(int i) {
            this.botCurrentParagraphChars = i;
        }

        public final Long getUserSpeakStartMs() {
            return this.userSpeakStartMs;
        }

        public final void setUserSpeakStartMs(Long l) {
            this.userSpeakStartMs = l;
        }

        public final Long getUserSubtitleFirstCharMs() {
            return this.userSubtitleFirstCharMs;
        }

        public final void setUserSubtitleFirstCharMs(Long l) {
            this.userSubtitleFirstCharMs = l;
        }

        public final Long getUserSubtitleLastCharMs() {
            return this.userSubtitleLastCharMs;
        }

        public final void setUserSubtitleLastCharMs(Long l) {
            this.userSubtitleLastCharMs = l;
        }

        public final boolean getUserFinalReceived() {
            return this.userFinalReceived;
        }

        public final void setUserFinalReceived(boolean z) {
            this.userFinalReceived = z;
        }

        public final boolean getInterrupted() {
            return this.interrupted;
        }

        public final void setInterrupted(boolean z) {
            this.interrupted = z;
        }

        public final InterruptPhase getInterruptPhase() {
            return this.interruptPhase;
        }

        public final void setInterruptPhase(InterruptPhase interruptPhase) {
            this.interruptPhase = interruptPhase;
        }

        public final boolean getReported() {
            return this.reported;
        }

        public final void setReported(boolean z) {
            this.reported = z;
        }

        public final boolean getHasSearch() {
            return this.hasSearch;
        }

        public final void setHasSearch(boolean z) {
            this.hasSearch = z;
        }

        public final boolean getHasSubtask() {
            return this.hasSubtask;
        }

        public final void setHasSubtask(boolean z) {
            this.hasSubtask = z;
        }

        public final boolean getHasUpload() {
            return this.hasUpload;
        }

        public final void setHasUpload(boolean z) {
            this.hasUpload = z;
        }

        public final int getAttachmentCount() {
            return this.attachmentCount;
        }

        public final void setAttachmentCount(int i) {
            this.attachmentCount = i;
        }

        public /* synthetic */ RoundDelayRecord(int i, long j, long j2, Long l, Long l2, Long l3, Long l4, int i2, int i3, int i4, Long l5, Long l6, Long l7, boolean z, boolean z2, InterruptPhase interruptPhase, boolean z3, boolean z4, boolean z5, boolean z6, int i5, Set set, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, j, j2, (i6 & 8) != 0 ? null : l, (i6 & 16) != 0 ? null : l2, (i6 & 32) != 0 ? null : l3, (i6 & 64) != 0 ? null : l4, (i6 & 128) != 0 ? 0 : i2, (i6 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? 0 : i3, (i6 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? 0 : i4, (i6 & 1024) != 0 ? null : l5, (i6 & 2048) != 0 ? null : l6, (i6 & 4096) != 0 ? null : l7, (i6 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? false : z, (i6 & 16384) != 0 ? false : z2, (32768 & i6) != 0 ? null : interruptPhase, (65536 & i6) != 0 ? false : z3, (131072 & i6) != 0 ? false : z4, (262144 & i6) != 0 ? false : z5, (524288 & i6) != 0 ? false : z6, (1048576 & i6) != 0 ? 0 : i5, (i6 & 2097152) != 0 ? new LinkedHashSet() : set);
        }

        public final Set<String> getToolNames() {
            return this.toolNames;
        }
    }

    public final StateFlow<BrainstormUiState> getUiState() {
        return this.uiState;
    }

    /* renamed from: getCliConversationId, reason: from getter */
    public final String get_cliConversationId() {
        return this._cliConversationId;
    }

    /* renamed from: getVoiceMode, reason: from getter */
    public final Mode get_voiceMode() {
        return this._voiceMode;
    }

    /* renamed from: getVoiceCliType, reason: from getter */
    public final CliType get_voiceCliType() {
        return this._voiceCliType;
    }

    public final boolean getAttachmentSubTaskEnabled() {
        return this.attachmentSubTaskEnabled;
    }

    public final ChatMode getCurrentChatMode() {
        return this._voiceMode == Mode.CODE ? ChatMode.CODE : ChatMode.MTC;
    }

    public final SharedFlow<Float> getLocalAudioVolume() {
        return this.localAudioVolume;
    }

    public final SharedFlow<Unit> getSummaryReady() {
        return this.summaryReady;
    }

    public final SharedFlow<Unit> getSummaryFailed() {
        return this.summaryFailed;
    }

    public final SharedFlow<BrainstormEndData> getBrainstormEnded() {
        return this.brainstormEnded;
    }

    public final SharedFlow<Unit> getMinimizeRequested() {
        return this.minimizeRequested;
    }

    public final SharedFlow<VoicePrompt> getVoicePromptEvents() {
        return this.voicePromptEvents;
    }

    public final void pickAndUpload(Uri uri, String mime, String displayName, long sizeBytes, boolean isImage, String groupId) {
        BrainstormUiState copy;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mime, "mime");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        if (!this.attachmentSubTaskEnabled) {
            FLogger.INSTANCE.i(TAG, "pickAndUpload: attachment/subtask disabled, ignore");
            return;
        }
        if ((1 <= sizeBytes && sizeBytes < Long.MAX_VALUE) && sizeBytes > MAX_ATTACHMENT_SIZE_BYTES) {
            this._voicePromptEvents.tryEmit(VoicePrompt.Runtime.AttachmentTooLarge.INSTANCE);
            return;
        }
        List<BrainstormAttachment> attachments = ((BrainstormUiState) this._uiState.getValue()).getAttachments();
        ArrayList<BrainstormAttachment> arrayList = new ArrayList();
        for (Object obj : attachments) {
            BrainstormAttachment brainstormAttachment = (BrainstormAttachment) obj;
            if ((brainstormAttachment.getState() == AttachmentState.Failed || brainstormAttachment.getState() == AttachmentState.Cancelled) ? false : true) {
                arrayList.add(obj);
            }
        }
        long j = 0;
        for (BrainstormAttachment brainstormAttachment2 : arrayList) {
            j += brainstormAttachment2.getSizeBytes() > 0 ? brainstormAttachment2.getSizeBytes() : 0L;
        }
        if (sizeBytes > 0 && j + sizeBytes > MAX_TOTAL_ATTACHMENT_SIZE_BYTES) {
            this._voicePromptEvents.tryEmit(VoicePrompt.Runtime.AttachmentTotalTooLarge.INSTANCE);
            return;
        }
        boolean shouldUseVoiceDiscussionImageUpload = BrainstormViewModelKt.shouldUseVoiceDiscussionImageUpload(getCurrentChatMode(), isImage);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
        BrainstormAttachment brainstormAttachment3 = r7;
        BrainstormAttachment brainstormAttachment4 = new BrainstormAttachment(uuid, displayName, mime, sizeBytes, uri2, isImage, shouldUseVoiceDiscussionImageUpload, AttachmentState.Uploading, 0, null, null, false, System.currentTimeMillis(), groupId, 3584, null);
        if (!((BrainstormUiState) this._uiState.getValue()).isSubtitleMode()) {
            this.sessionHasEverEnabledSubtitle = true;
        }
        MutableStateFlow<BrainstormUiState> mutableStateFlow = this._uiState;
        while (true) {
            Object value = mutableStateFlow.getValue();
            BrainstormUiState brainstormUiState = (BrainstormUiState) value;
            BrainstormAttachment brainstormAttachment5 = brainstormAttachment3;
            copy = brainstormUiState.copy((r42 & 1) != 0 ? brainstormUiState.phase : null, (r42 & 2) != 0 ? brainstormUiState.subtitleHistory : null, (r42 & 4) != 0 ? brainstormUiState.recordingState : null, (r42 & 8) != 0 ? brainstormUiState.aiReplyState : null, (r42 & 16) != 0 ? brainstormUiState.aiParticipantState : null, (r42 & 32) != 0 ? brainstormUiState.userParticipantState : null, (r42 & 64) != 0 ? brainstormUiState.currentTranscript : null, (r42 & 128) != 0 ? brainstormUiState.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormUiState.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormUiState.isSpeakerOn : false, (r42 & 1024) != 0 ? brainstormUiState.isMicMuted : false, (r42 & 2048) != 0 ? brainstormUiState.isSubtitleMode : true, (r42 & 4096) != 0 ? brainstormUiState.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormUiState.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? brainstormUiState.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? brainstormUiState.timeoutState : null, (65536 & r42) != 0 ? brainstormUiState.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? brainstormUiState.aiStageDescription : null, (r42 & 262144) != 0 ? brainstormUiState.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? brainstormUiState.subTask : null, (r42 & 1048576) != 0 ? brainstormUiState.finishedSubTasks : null, (r42 & 2097152) != 0 ? brainstormUiState.attachments : CollectionsKt.plus(brainstormUiState.getAttachments(), brainstormAttachment5));
            if (mutableStateFlow.compareAndSet(value, copy)) {
                startUpload(brainstormAttachment5, uri);
                return;
            }
            brainstormAttachment3 = brainstormAttachment5;
        }
    }

    public final void retryAttachment(String attachmentId) {
        Object obj;
        Object obj2;
        final BrainstormAttachment copy;
        Intrinsics.checkNotNullParameter(attachmentId, "attachmentId");
        Iterator<T> it = ((BrainstormUiState) this._uiState.getValue()).getAttachments().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((BrainstormAttachment) obj).getAttachmentId(), attachmentId)) {
                    break;
                }
            }
        }
        BrainstormAttachment brainstormAttachment = (BrainstormAttachment) obj;
        if (brainstormAttachment != null && brainstormAttachment.getState() == AttachmentState.Failed) {
            try {
                Result.Companion companion = Result.Companion;
                BrainstormViewModel brainstormViewModel = this;
                obj2 = Result.constructor-impl(Uri.parse(brainstormAttachment.getLocalUri()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Uri uri = (Uri) (Result.isFailure-impl(obj2) ? null : obj2);
            if (uri == null) {
                return;
            }
            copy = brainstormAttachment.copy((r33 & 1) != 0 ? brainstormAttachment.attachmentId : null, (r33 & 2) != 0 ? brainstormAttachment.displayName : null, (r33 & 4) != 0 ? brainstormAttachment.mimeType : null, (r33 & 8) != 0 ? brainstormAttachment.sizeBytes : 0L, (r33 & 16) != 0 ? brainstormAttachment.localUri : null, (r33 & 32) != 0 ? brainstormAttachment.isImage : false, (r33 & 64) != 0 ? brainstormAttachment.useImageUpload : false, (r33 & 128) != 0 ? brainstormAttachment.state : AttachmentState.Uploading, (r33 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormAttachment.progress : 0, (r33 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormAttachment.uploadedRef : null, (r33 & 1024) != 0 ? brainstormAttachment.errorMessage : null, (r33 & 2048) != 0 ? brainstormAttachment.notifiedToBot : false, (r33 & 4096) != 0 ? brainstormAttachment.createdAtMs : 0L, (r33 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormAttachment.groupId : null);
            updateAttachment$default(this, attachmentId, false, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$$ExternalSyntheticLambda3
                public final Object invoke(Object obj3) {
                    BrainstormAttachment retryAttachment$lambda$5;
                    retryAttachment$lambda$5 = BrainstormViewModel.retryAttachment$lambda$5(BrainstormAttachment.this, (BrainstormAttachment) obj3);
                    return retryAttachment$lambda$5;
                }
            }, 2, null);
            startUpload(copy, uri);
        }
    }

    public final void cancelAttachment(String attachmentId) {
        Intrinsics.checkNotNullParameter(attachmentId, "attachmentId");
        Job remove = this.attachmentUploadJobs.remove(attachmentId);
        if (remove != null) {
            Job.DefaultImpls.cancel$default(remove, (CancellationException) null, 1, (Object) null);
        }
        updateAttachment$default(this, attachmentId, false, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                BrainstormAttachment cancelAttachment$lambda$6;
                cancelAttachment$lambda$6 = BrainstormViewModel.cancelAttachment$lambda$6((BrainstormAttachment) obj);
                return cancelAttachment$lambda$6;
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrainstormAttachment cancelAttachment$lambda$6(BrainstormAttachment brainstormAttachment) {
        BrainstormAttachment copy;
        Intrinsics.checkNotNullParameter(brainstormAttachment, "current");
        if (brainstormAttachment.getState() == AttachmentState.Uploaded) {
            return brainstormAttachment;
        }
        copy = brainstormAttachment.copy((r33 & 1) != 0 ? brainstormAttachment.attachmentId : null, (r33 & 2) != 0 ? brainstormAttachment.displayName : null, (r33 & 4) != 0 ? brainstormAttachment.mimeType : null, (r33 & 8) != 0 ? brainstormAttachment.sizeBytes : 0L, (r33 & 16) != 0 ? brainstormAttachment.localUri : null, (r33 & 32) != 0 ? brainstormAttachment.isImage : false, (r33 & 64) != 0 ? brainstormAttachment.useImageUpload : false, (r33 & 128) != 0 ? brainstormAttachment.state : AttachmentState.Cancelled, (r33 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormAttachment.progress : 0, (r33 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormAttachment.uploadedRef : null, (r33 & 1024) != 0 ? brainstormAttachment.errorMessage : null, (r33 & 2048) != 0 ? brainstormAttachment.notifiedToBot : false, (r33 & 4096) != 0 ? brainstormAttachment.createdAtMs : 0L, (r33 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormAttachment.groupId : null);
        return copy;
    }

    public final void removeAttachment(String attachmentId) {
        Object value;
        BrainstormUiState copy;
        Intrinsics.checkNotNullParameter(attachmentId, "attachmentId");
        Job remove = this.attachmentUploadJobs.remove(attachmentId);
        if (remove != null) {
            Job.DefaultImpls.cancel$default(remove, (CancellationException) null, 1, (Object) null);
        }
        MutableStateFlow<BrainstormUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            BrainstormUiState brainstormUiState = (BrainstormUiState) value;
            List<BrainstormAttachment> attachments = brainstormUiState.getAttachments();
            ArrayList arrayList = new ArrayList();
            for (Object obj : attachments) {
                if (!Intrinsics.areEqual(((BrainstormAttachment) obj).getAttachmentId(), attachmentId)) {
                    arrayList.add(obj);
                }
            }
            copy = brainstormUiState.copy((r42 & 1) != 0 ? brainstormUiState.phase : null, (r42 & 2) != 0 ? brainstormUiState.subtitleHistory : null, (r42 & 4) != 0 ? brainstormUiState.recordingState : null, (r42 & 8) != 0 ? brainstormUiState.aiReplyState : null, (r42 & 16) != 0 ? brainstormUiState.aiParticipantState : null, (r42 & 32) != 0 ? brainstormUiState.userParticipantState : null, (r42 & 64) != 0 ? brainstormUiState.currentTranscript : null, (r42 & 128) != 0 ? brainstormUiState.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormUiState.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormUiState.isSpeakerOn : false, (r42 & 1024) != 0 ? brainstormUiState.isMicMuted : false, (r42 & 2048) != 0 ? brainstormUiState.isSubtitleMode : false, (r42 & 4096) != 0 ? brainstormUiState.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormUiState.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? brainstormUiState.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? brainstormUiState.timeoutState : null, (65536 & r42) != 0 ? brainstormUiState.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? brainstormUiState.aiStageDescription : null, (r42 & 262144) != 0 ? brainstormUiState.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? brainstormUiState.subTask : null, (r42 & 1048576) != 0 ? brainstormUiState.finishedSubTasks : null, (r42 & 2097152) != 0 ? brainstormUiState.attachments : arrayList);
        } while (!mutableStateFlow.compareAndSet(value, copy));
    }

    public static /* synthetic */ void updateAttachment$default(BrainstormViewModel brainstormViewModel, String str, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        brainstormViewModel.updateAttachment(str, z, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.List] */
    public final void updateAttachment(String attachmentId, boolean moveToEnd, Function1<? super BrainstormAttachment, BrainstormAttachment> updater) {
        Object value;
        BrainstormUiState copy;
        ?? plus;
        Intrinsics.checkNotNullParameter(attachmentId, "attachmentId");
        Intrinsics.checkNotNullParameter(updater, "updater");
        MutableStateFlow<BrainstormUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            BrainstormUiState brainstormUiState = (BrainstormUiState) value;
            List<BrainstormAttachment> attachments = brainstormUiState.getAttachments();
            ArrayList arrayList = new ArrayList();
            BrainstormAttachment brainstormAttachment = null;
            for (BrainstormAttachment brainstormAttachment2 : attachments) {
                if (Intrinsics.areEqual(brainstormAttachment2.getAttachmentId(), attachmentId)) {
                    brainstormAttachment2 = (BrainstormAttachment) updater.invoke(brainstormAttachment2);
                    if (moveToEnd) {
                        brainstormAttachment = brainstormAttachment2;
                        brainstormAttachment2 = null;
                    }
                }
                if (brainstormAttachment2 != null) {
                    arrayList.add(brainstormAttachment2);
                }
            }
            ArrayList arrayList2 = arrayList;
            copy = brainstormUiState.copy((r42 & 1) != 0 ? brainstormUiState.phase : null, (r42 & 2) != 0 ? brainstormUiState.subtitleHistory : null, (r42 & 4) != 0 ? brainstormUiState.recordingState : null, (r42 & 8) != 0 ? brainstormUiState.aiReplyState : null, (r42 & 16) != 0 ? brainstormUiState.aiParticipantState : null, (r42 & 32) != 0 ? brainstormUiState.userParticipantState : null, (r42 & 64) != 0 ? brainstormUiState.currentTranscript : null, (r42 & 128) != 0 ? brainstormUiState.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormUiState.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormUiState.isSpeakerOn : false, (r42 & 1024) != 0 ? brainstormUiState.isMicMuted : false, (r42 & 2048) != 0 ? brainstormUiState.isSubtitleMode : false, (r42 & 4096) != 0 ? brainstormUiState.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormUiState.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? brainstormUiState.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? brainstormUiState.timeoutState : null, (65536 & r42) != 0 ? brainstormUiState.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? brainstormUiState.aiStageDescription : null, (r42 & 262144) != 0 ? brainstormUiState.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? brainstormUiState.subTask : null, (r42 & 1048576) != 0 ? brainstormUiState.finishedSubTasks : null, (r42 & 2097152) != 0 ? brainstormUiState.attachments : (brainstormAttachment == null || (plus = CollectionsKt.plus(arrayList2, brainstormAttachment)) == 0) ? arrayList2 : plus);
        } while (!mutableStateFlow.compareAndSet(value, copy));
    }

    private final void startUpload(BrainstormAttachment attachment, Uri sourceUri) {
        String attachmentId = attachment.getAttachmentId();
        Job job = this.attachmentUploadJobs.get(attachmentId);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        markCurrentRoundUpload();
        this.attachmentUploadJobs.put(attachmentId, BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new BrainstormViewModel$startUpload$job$1(this, sourceUri, attachment, attachmentId, currentTimeMillis, null), 2, (Object) null));
    }

    private final void cancelAllPendingUploads(boolean markUploadingAsCancelled) {
        Object value;
        BrainstormUiState copy;
        Collection<Job> values = this.attachmentUploadJobs.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
        }
        this.attachmentUploadJobs.clear();
        if (markUploadingAsCancelled) {
            MutableStateFlow<BrainstormUiState> mutableStateFlow = this._uiState;
            do {
                value = mutableStateFlow.getValue();
                BrainstormUiState brainstormUiState = (BrainstormUiState) value;
                List<BrainstormAttachment> attachments = brainstormUiState.getAttachments();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(attachments, 10));
                for (BrainstormAttachment brainstormAttachment : attachments) {
                    if (brainstormAttachment.getState() == AttachmentState.Uploading) {
                        brainstormAttachment = brainstormAttachment.copy((r33 & 1) != 0 ? brainstormAttachment.attachmentId : null, (r33 & 2) != 0 ? brainstormAttachment.displayName : null, (r33 & 4) != 0 ? brainstormAttachment.mimeType : null, (r33 & 8) != 0 ? brainstormAttachment.sizeBytes : 0L, (r33 & 16) != 0 ? brainstormAttachment.localUri : null, (r33 & 32) != 0 ? brainstormAttachment.isImage : false, (r33 & 64) != 0 ? brainstormAttachment.useImageUpload : false, (r33 & 128) != 0 ? brainstormAttachment.state : AttachmentState.Cancelled, (r33 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormAttachment.progress : 0, (r33 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormAttachment.uploadedRef : null, (r33 & 1024) != 0 ? brainstormAttachment.errorMessage : null, (r33 & 2048) != 0 ? brainstormAttachment.notifiedToBot : false, (r33 & 4096) != 0 ? brainstormAttachment.createdAtMs : 0L, (r33 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormAttachment.groupId : null);
                    }
                    arrayList.add(brainstormAttachment);
                }
                copy = brainstormUiState.copy((r42 & 1) != 0 ? brainstormUiState.phase : null, (r42 & 2) != 0 ? brainstormUiState.subtitleHistory : null, (r42 & 4) != 0 ? brainstormUiState.recordingState : null, (r42 & 8) != 0 ? brainstormUiState.aiReplyState : null, (r42 & 16) != 0 ? brainstormUiState.aiParticipantState : null, (r42 & 32) != 0 ? brainstormUiState.userParticipantState : null, (r42 & 64) != 0 ? brainstormUiState.currentTranscript : null, (r42 & 128) != 0 ? brainstormUiState.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormUiState.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormUiState.isSpeakerOn : false, (r42 & 1024) != 0 ? brainstormUiState.isMicMuted : false, (r42 & 2048) != 0 ? brainstormUiState.isSubtitleMode : false, (r42 & 4096) != 0 ? brainstormUiState.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormUiState.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? brainstormUiState.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? brainstormUiState.timeoutState : null, (65536 & r42) != 0 ? brainstormUiState.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? brainstormUiState.aiStageDescription : null, (r42 & 262144) != 0 ? brainstormUiState.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? brainstormUiState.subTask : null, (r42 & 1048576) != 0 ? brainstormUiState.finishedSubTasks : null, (r42 & 2097152) != 0 ? brainstormUiState.attachments : arrayList);
            } while (!mutableStateFlow.compareAndSet(value, copy));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAttachmentUploadDone(String attachmentId) {
        maybeNotifyPendingAttachments();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void maybeNotifyPendingAttachments() {
        boolean z;
        boolean z2;
        BrainstormUiState brainstormUiState = (BrainstormUiState) this._uiState.getValue();
        List<BrainstormAttachment> attachments = brainstormUiState.getAttachments();
        if (!(attachments instanceof Collection) || !attachments.isEmpty()) {
            Iterator<T> it = attachments.iterator();
            while (it.hasNext()) {
                if (((BrainstormAttachment) it.next()).getState() == AttachmentState.Uploading) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return;
        }
        List<BrainstormAttachment> attachments2 = brainstormUiState.getAttachments();
        ArrayList arrayList = new ArrayList();
        for (Object obj : attachments2) {
            BrainstormAttachment brainstormAttachment = (BrainstormAttachment) obj;
            if (brainstormAttachment.getState() == AttachmentState.Uploaded) {
                String uploadedRef = brainstormAttachment.getUploadedRef();
                if (!(uploadedRef == null || StringsKt.isBlank(uploadedRef)) && !brainstormAttachment.getNotifiedToBot()) {
                    z2 = true;
                    if (!z2) {
                        arrayList.add(obj);
                    }
                }
            }
            z2 = false;
            if (!z2) {
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return;
        }
        ArrayList<BrainstormAttachment> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        for (BrainstormAttachment brainstormAttachment2 : arrayList3) {
            String attachmentId = brainstormAttachment2.getAttachmentId();
            String uploadedRef2 = brainstormAttachment2.getUploadedRef();
            Intrinsics.checkNotNull(uploadedRef2);
            arrayList4.add(new VoiceSubTaskCoordinator.NotifyAttachmentItem(attachmentId, uploadedRef2, brainstormAttachment2.getDisplayName(), brainstormAttachment2.getUseImageUpload(), brainstormAttachment2.getSizeBytes()));
        }
        ArrayList arrayList5 = arrayList4;
        if (!VoiceSubTaskCoordinator.INSTANCE.notifyAttachmentsToBot(arrayList5)) {
            FLogger.INSTANCE.i(TAG, "maybeNotifyPendingAttachments: refused, count=" + arrayList5.size());
            return;
        }
        FLogger.INSTANCE.i(TAG, "maybeNotifyPendingAttachments: notified " + arrayList5.size() + " items to bot LLM");
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            updateAttachment$default(this, ((BrainstormAttachment) it2.next()).getAttachmentId(), false, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$$ExternalSyntheticLambda2
                public final Object invoke(Object obj2) {
                    BrainstormAttachment maybeNotifyPendingAttachments$lambda$20$lambda$19;
                    maybeNotifyPendingAttachments$lambda$20$lambda$19 = BrainstormViewModel.maybeNotifyPendingAttachments$lambda$20$lambda$19((BrainstormAttachment) obj2);
                    return maybeNotifyPendingAttachments$lambda$20$lambda$19;
                }
            }, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrainstormAttachment maybeNotifyPendingAttachments$lambda$20$lambda$19(BrainstormAttachment brainstormAttachment) {
        BrainstormAttachment copy;
        Intrinsics.checkNotNullParameter(brainstormAttachment, "it");
        copy = brainstormAttachment.copy((r33 & 1) != 0 ? brainstormAttachment.attachmentId : null, (r33 & 2) != 0 ? brainstormAttachment.displayName : null, (r33 & 4) != 0 ? brainstormAttachment.mimeType : null, (r33 & 8) != 0 ? brainstormAttachment.sizeBytes : 0L, (r33 & 16) != 0 ? brainstormAttachment.localUri : null, (r33 & 32) != 0 ? brainstormAttachment.isImage : false, (r33 & 64) != 0 ? brainstormAttachment.useImageUpload : false, (r33 & 128) != 0 ? brainstormAttachment.state : null, (r33 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormAttachment.progress : 0, (r33 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormAttachment.uploadedRef : null, (r33 & 1024) != 0 ? brainstormAttachment.errorMessage : null, (r33 & 2048) != 0 ? brainstormAttachment.notifiedToBot : true, (r33 & 4096) != 0 ? brainstormAttachment.createdAtMs : 0L, (r33 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormAttachment.groupId : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUserFinalText(String text) {
        Object value;
        BrainstormUiState copy;
        Object value2;
        BrainstormUiState copy2;
        if (!StringsKt.isBlank(text)) {
            BrainstormMessage brainstormMessage = new BrainstormMessage("subtitle_user_" + System.currentTimeMillis(), MessageRole.User, text, System.currentTimeMillis(), null, null, null, null, null, 496, null);
            MutableStateFlow<BrainstormUiState> mutableStateFlow = this._uiState;
            do {
                value2 = mutableStateFlow.getValue();
                BrainstormUiState brainstormUiState = (BrainstormUiState) value2;
                copy2 = brainstormUiState.copy((r42 & 1) != 0 ? brainstormUiState.phase : null, (r42 & 2) != 0 ? brainstormUiState.subtitleHistory : CollectionsKt.plus(brainstormUiState.getSubtitleHistory(), brainstormMessage), (r42 & 4) != 0 ? brainstormUiState.recordingState : RecordingState.Idle, (r42 & 8) != 0 ? brainstormUiState.aiReplyState : AiReplyState.Thinking, (r42 & 16) != 0 ? brainstormUiState.aiParticipantState : ParticipantState.Thinking, (r42 & 32) != 0 ? brainstormUiState.userParticipantState : ParticipantState.Idle, (r42 & 64) != 0 ? brainstormUiState.currentTranscript : "", (r42 & 128) != 0 ? brainstormUiState.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormUiState.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormUiState.isSpeakerOn : false, (r42 & 1024) != 0 ? brainstormUiState.isMicMuted : false, (r42 & 2048) != 0 ? brainstormUiState.isSubtitleMode : false, (r42 & 4096) != 0 ? brainstormUiState.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormUiState.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? brainstormUiState.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? brainstormUiState.timeoutState : null, (65536 & r42) != 0 ? brainstormUiState.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? brainstormUiState.aiStageDescription : null, (r42 & 262144) != 0 ? brainstormUiState.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? brainstormUiState.subTask : null, (r42 & 1048576) != 0 ? brainstormUiState.finishedSubTasks : null, (r42 & 2097152) != 0 ? brainstormUiState.attachments : null);
            } while (!mutableStateFlow.compareAndSet(value2, copy2));
            return;
        }
        MutableStateFlow<BrainstormUiState> mutableStateFlow2 = this._uiState;
        do {
            value = mutableStateFlow2.getValue();
            copy = r3.copy((r42 & 1) != 0 ? r3.phase : null, (r42 & 2) != 0 ? r3.subtitleHistory : null, (r42 & 4) != 0 ? r3.recordingState : RecordingState.Idle, (r42 & 8) != 0 ? r3.aiReplyState : null, (r42 & 16) != 0 ? r3.aiParticipantState : null, (r42 & 32) != 0 ? r3.userParticipantState : ParticipantState.Idle, (r42 & 64) != 0 ? r3.currentTranscript : "", (r42 & 128) != 0 ? r3.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r3.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r3.isSpeakerOn : false, (r42 & 1024) != 0 ? r3.isMicMuted : false, (r42 & 2048) != 0 ? r3.isSubtitleMode : false, (r42 & 4096) != 0 ? r3.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r3.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r3.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r3.timeoutState : null, (65536 & r42) != 0 ? r3.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r3.aiStageDescription : null, (r42 & 262144) != 0 ? r3.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r3.subTask : null, (r42 & 1048576) != 0 ? r3.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value).attachments : null);
        } while (!mutableStateFlow2.compareAndSet(value, copy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleBotFinalText(String text) {
        BrainstormUiState copy;
        SubTaskRenderState mapHeadStatusToTerminal;
        Object value;
        BrainstormUiState copy2;
        String str = text;
        FLogger.INSTANCE.d(TAG, "[BotReply] len=" + text.length() + " | content=" + str);
        if (StringsKt.isBlank(str)) {
            MutableStateFlow<BrainstormUiState> mutableStateFlow = this._uiState;
            do {
                value = mutableStateFlow.getValue();
                copy2 = r3.copy((r42 & 1) != 0 ? r3.phase : null, (r42 & 2) != 0 ? r3.subtitleHistory : null, (r42 & 4) != 0 ? r3.recordingState : null, (r42 & 8) != 0 ? r3.aiReplyState : null, (r42 & 16) != 0 ? r3.aiParticipantState : ParticipantState.Idle, (r42 & 32) != 0 ? r3.userParticipantState : null, (r42 & 64) != 0 ? r3.currentTranscript : null, (r42 & 128) != 0 ? r3.botTranscript : "", (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r3.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r3.isSpeakerOn : false, (r42 & 1024) != 0 ? r3.isMicMuted : false, (r42 & 2048) != 0 ? r3.isSubtitleMode : false, (r42 & 4096) != 0 ? r3.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r3.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r3.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r3.timeoutState : null, (65536 & r42) != 0 ? r3.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r3.aiStageDescription : null, (r42 & 262144) != 0 ? r3.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r3.subTask : null, (r42 & 1048576) != 0 ? r3.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value).attachments : null);
            } while (!mutableStateFlow.compareAndSet(value, copy2));
            return;
        }
        ParsedSubTaskTag parseAttachedSubTaskId = BrainstormMessageKt.parseAttachedSubTaskId(text);
        if (parseAttachedSubTaskId.isIncompleteHead()) {
            FLogger.INSTANCE.w(TAG, "[BotReply] final text looks like incomplete head tag, fallback to raw: " + str);
        } else {
            str = parseAttachedSubTaskId.getCleanedText();
        }
        String str2 = str;
        boolean z = parseAttachedSubTaskId.getSourceStatus() != null;
        String sourceTaskId = !z ? parseAttachedSubTaskId.getSourceTaskId() : null;
        SubTaskUiState subTaskUiState = sourceTaskId != null ? ((BrainstormUiState) this._uiState.getValue()).getFinishedSubTasks().get(sourceTaskId) : null;
        BrainstormUiState brainstormUiState = (BrainstormUiState) this._uiState.getValue();
        if (parseAttachedSubTaskId.getSourceTaskId() != null) {
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder append = new StringBuilder("[SubTask] botFinalParsed: taskId=").append(parseAttachedSubTaskId.getSourceTaskId()).append(", role=").append(z ? "result" : "comfort").append(", status=").append(parseAttachedSubTaskId.getSourceStatus()).append(", attachedId=").append(sourceTaskId).append(", pendingTerminal=").append(subTaskUiState != null ? subTaskUiState.getState() : null).append(", active=");
            SubTaskUiState subTask = brainstormUiState.getSubTask();
            StringBuilder append2 = append.append(subTask != null ? subTask.getSourceTaskId() : null).append(':');
            SubTaskUiState subTask2 = brainstormUiState.getSubTask();
            fLogger.d(TAG, append2.append(subTask2 != null ? subTask2.getState() : null).append(", historySize=").append(brainstormUiState.getSubtitleHistory().size()).append(", cleanedLen=").append(str2.length()).append(", incomplete=").append(parseAttachedSubTaskId.isIncompleteHead()).toString());
        }
        String sourceTaskId2 = parseAttachedSubTaskId.getSourceTaskId();
        if (z && sourceTaskId2 != null && (mapHeadStatusToTerminal = SubTaskProtocolKt.mapHeadStatusToTerminal(parseAttachedSubTaskId.getSourceStatus())) != null) {
            applySubTaskTerminal(new SubTaskUiState(sourceTaskId2, "", null, null, null, mapHeadStatusToTerminal, null, mapHeadStatusToTerminal == SubTaskRenderState.Failed ? parseAttachedSubTaskId.getSourceStatus() : null, 0L, false, null, null, 3932, null));
        }
        BrainstormMessage brainstormMessage = r13;
        BrainstormMessage brainstormMessage2 = new BrainstormMessage("subtitle_bot_" + System.currentTimeMillis(), MessageRole.Assistant, str2, System.currentTimeMillis(), sourceTaskId, z ? parseAttachedSubTaskId.getSourceTaskId() : null, parseAttachedSubTaskId.getSourceStatus(), subTaskUiState != null ? subTaskUiState.getState() : null, subTaskUiState != null ? subTaskUiState.getFailureReason() : null);
        if (parseAttachedSubTaskId.getSourceTaskId() != null) {
            FLogger.INSTANCE.d(TAG, "[BotReply] subTask tag parsed: sourceTaskId=" + parseAttachedSubTaskId.getSourceTaskId() + ", status=" + parseAttachedSubTaskId.getSourceStatus() + ", role=" + (z ? "result" : "comfort"));
        }
        MutableStateFlow<BrainstormUiState> mutableStateFlow2 = this._uiState;
        while (true) {
            Object value2 = mutableStateFlow2.getValue();
            BrainstormUiState brainstormUiState2 = (BrainstormUiState) value2;
            BrainstormMessage brainstormMessage3 = brainstormMessage;
            copy = brainstormUiState2.copy((r42 & 1) != 0 ? brainstormUiState2.phase : null, (r42 & 2) != 0 ? brainstormUiState2.subtitleHistory : CollectionsKt.plus(brainstormUiState2.getSubtitleHistory(), brainstormMessage3), (r42 & 4) != 0 ? brainstormUiState2.recordingState : null, (r42 & 8) != 0 ? brainstormUiState2.aiReplyState : AiReplyState.Idle, (r42 & 16) != 0 ? brainstormUiState2.aiParticipantState : ParticipantState.Idle, (r42 & 32) != 0 ? brainstormUiState2.userParticipantState : null, (r42 & 64) != 0 ? brainstormUiState2.currentTranscript : null, (r42 & 128) != 0 ? brainstormUiState2.botTranscript : "", (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormUiState2.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormUiState2.isSpeakerOn : false, (r42 & 1024) != 0 ? brainstormUiState2.isMicMuted : false, (r42 & 2048) != 0 ? brainstormUiState2.isSubtitleMode : false, (r42 & 4096) != 0 ? brainstormUiState2.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormUiState2.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? brainstormUiState2.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? brainstormUiState2.timeoutState : null, (65536 & r42) != 0 ? brainstormUiState2.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? brainstormUiState2.aiStageDescription : null, (r42 & 262144) != 0 ? brainstormUiState2.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? brainstormUiState2.subTask : null, (r42 & 1048576) != 0 ? brainstormUiState2.finishedSubTasks : null, (r42 & 2097152) != 0 ? brainstormUiState2.attachments : null);
            if (mutableStateFlow2.compareAndSet(value2, copy)) {
                return;
            } else {
                brainstormMessage = brainstormMessage3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void logUnrecognizedRtcFrame$default(BrainstormViewModel brainstormViewModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "unrecognized";
        }
        brainstormViewModel.logUnrecognizedRtcFrame(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logUnrecognizedRtcFrame(String uid, String message, String reason) {
        if (message.length() == 0) {
            return;
        }
        FLogger.INSTANCE.w(TAG, rtcDiag("onRtcTextMessage: " + reason + " frame from uid=" + uid + ", length=" + message.length() + ", hash=" + message.hashCode()));
    }

    /* compiled from: BrainstormViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$1", f = "BrainstormViewModel.kt", i = {}, l = {1437}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    static final class C06561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06561(Continuation<? super C06561> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06561(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<SubTaskUiState> activeTask = VoiceSubTaskCoordinator.INSTANCE.getActiveTask();
                final BrainstormViewModel brainstormViewModel = BrainstormViewModel.this;
                this.label = 1;
                if (activeTask.collect(new FlowCollector() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel.1.1
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((SubTaskUiState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(SubTaskUiState subTaskUiState, Continuation<? super Unit> continuation) {
                        BrainstormUiState copy;
                        Object value;
                        BrainstormUiState copy2;
                        FLogger.INSTANCE.d(BrainstormViewModel.TAG, "[SubTask] activeTask=" + subTaskUiState);
                        if (subTaskUiState == null || !BrainstormViewModel.TERMINAL_SUB_TASK_STATES.contains(subTaskUiState.getState())) {
                            MutableStateFlow mutableStateFlow = BrainstormViewModel.this._uiState;
                            while (true) {
                                Object value2 = mutableStateFlow.getValue();
                                MutableStateFlow mutableStateFlow2 = mutableStateFlow;
                                copy = r1.copy((r42 & 1) != 0 ? r1.phase : null, (r42 & 2) != 0 ? r1.subtitleHistory : null, (r42 & 4) != 0 ? r1.recordingState : null, (r42 & 8) != 0 ? r1.aiReplyState : null, (r42 & 16) != 0 ? r1.aiParticipantState : null, (r42 & 32) != 0 ? r1.userParticipantState : null, (r42 & 64) != 0 ? r1.currentTranscript : null, (r42 & 128) != 0 ? r1.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r1.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r1.isSpeakerOn : false, (r42 & 1024) != 0 ? r1.isMicMuted : false, (r42 & 2048) != 0 ? r1.isSubtitleMode : false, (r42 & 4096) != 0 ? r1.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r1.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r1.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r1.timeoutState : null, (65536 & r42) != 0 ? r1.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r1.aiStageDescription : null, (r42 & 262144) != 0 ? r1.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r1.subTask : subTaskUiState, (r42 & 1048576) != 0 ? r1.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value2).attachments : null);
                                if (mutableStateFlow2.compareAndSet(value2, copy)) {
                                    break;
                                }
                                mutableStateFlow = mutableStateFlow2;
                            }
                        } else {
                            MutableStateFlow mutableStateFlow3 = BrainstormViewModel.this._uiState;
                            do {
                                value = mutableStateFlow3.getValue();
                                copy2 = r16.copy((r42 & 1) != 0 ? r16.phase : null, (r42 & 2) != 0 ? r16.subtitleHistory : null, (r42 & 4) != 0 ? r16.recordingState : null, (r42 & 8) != 0 ? r16.aiReplyState : null, (r42 & 16) != 0 ? r16.aiParticipantState : null, (r42 & 32) != 0 ? r16.userParticipantState : null, (r42 & 64) != 0 ? r16.currentTranscript : null, (r42 & 128) != 0 ? r16.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r16.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r16.isSpeakerOn : false, (r42 & 1024) != 0 ? r16.isMicMuted : false, (r42 & 2048) != 0 ? r16.isSubtitleMode : false, (r42 & 4096) != 0 ? r16.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r16.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r16.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r16.timeoutState : null, (65536 & r42) != 0 ? r16.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r16.aiStageDescription : null, (r42 & 262144) != 0 ? r16.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r16.subTask : null, (r42 & 1048576) != 0 ? r16.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value).attachments : null);
                            } while (!mutableStateFlow3.compareAndSet(value, copy2));
                            BrainstormViewModel.this.applySubTaskTerminal(subTaskUiState);
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* compiled from: BrainstormViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$2", f = "BrainstormViewModel.kt", i = {}, l = {1457}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    static final class C06572 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06572(Continuation<? super C06572> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06572(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<SubTaskUiState> parallelTerminalToolResults = VoiceSubTaskCoordinator.INSTANCE.getParallelTerminalToolResults();
                final BrainstormViewModel brainstormViewModel = BrainstormViewModel.this;
                this.label = 1;
                if (parallelTerminalToolResults.collect(new FlowCollector() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel.2.1
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((SubTaskUiState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(SubTaskUiState subTaskUiState, Continuation<? super Unit> continuation) {
                        FLogger.INSTANCE.d(BrainstormViewModel.TAG, "[SubTask] parallelTerminal=" + subTaskUiState);
                        BrainstormViewModel.this.applySubTaskTerminal(subTaskUiState);
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applySubTaskTerminal(SubTaskUiState finished) {
        Object value;
        int size;
        boolean containsKey;
        int i;
        int i2;
        BrainstormUiState copy;
        String sourceTaskId = finished.getSourceTaskId();
        if (StringsKt.isBlank(sourceTaskId)) {
            return;
        }
        MutableStateFlow<BrainstormUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            BrainstormUiState brainstormUiState = (BrainstormUiState) value;
            size = brainstormUiState.getSubtitleHistory().size();
            containsKey = brainstormUiState.getFinishedSubTasks().containsKey(sourceTaskId);
            List<BrainstormMessage> subtitleHistory = brainstormUiState.getSubtitleHistory();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subtitleHistory, 10));
            int i3 = 0;
            int i4 = 0;
            for (BrainstormMessage brainstormMessage : subtitleHistory) {
                if (Intrinsics.areEqual(brainstormMessage.getAttachedSubTaskId(), sourceTaskId)) {
                    i4++;
                    if (brainstormMessage.getSubTaskTerminalState() == null) {
                        i3++;
                        brainstormMessage = brainstormMessage.copy((r22 & 1) != 0 ? brainstormMessage.id : null, (r22 & 2) != 0 ? brainstormMessage.role : null, (r22 & 4) != 0 ? brainstormMessage.content : null, (r22 & 8) != 0 ? brainstormMessage.timestamp : 0L, (r22 & 16) != 0 ? brainstormMessage.attachedSubTaskId : null, (r22 & 32) != 0 ? brainstormMessage.taskResultRefersToTaskId : null, (r22 & 64) != 0 ? brainstormMessage.taskResultStatus : null, (r22 & 128) != 0 ? brainstormMessage.subTaskTerminalState : finished.getState(), (r22 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormMessage.subTaskFailureReason : finished.getFailureReason());
                    }
                }
                arrayList.add(brainstormMessage);
            }
            i = i3;
            i2 = i4;
            copy = brainstormUiState.copy((r42 & 1) != 0 ? brainstormUiState.phase : null, (r42 & 2) != 0 ? brainstormUiState.subtitleHistory : arrayList, (r42 & 4) != 0 ? brainstormUiState.recordingState : null, (r42 & 8) != 0 ? brainstormUiState.aiReplyState : null, (r42 & 16) != 0 ? brainstormUiState.aiParticipantState : null, (r42 & 32) != 0 ? brainstormUiState.userParticipantState : null, (r42 & 64) != 0 ? brainstormUiState.currentTranscript : null, (r42 & 128) != 0 ? brainstormUiState.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormUiState.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormUiState.isSpeakerOn : false, (r42 & 1024) != 0 ? brainstormUiState.isMicMuted : false, (r42 & 2048) != 0 ? brainstormUiState.isSubtitleMode : false, (r42 & 4096) != 0 ? brainstormUiState.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormUiState.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? brainstormUiState.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? brainstormUiState.timeoutState : null, (65536 & r42) != 0 ? brainstormUiState.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? brainstormUiState.aiStageDescription : null, (r42 & 262144) != 0 ? brainstormUiState.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? brainstormUiState.subTask : null, (r42 & 1048576) != 0 ? brainstormUiState.finishedSubTasks : MapsKt.plus(brainstormUiState.getFinishedSubTasks(), TuplesKt.to(sourceTaskId, finished)), (r42 & 2097152) != 0 ? brainstormUiState.attachments : null);
        } while (!mutableStateFlow.compareAndSet(value, copy));
        FLogger.INSTANCE.d(TAG, "[SubTask] applyTerminal: taskId=" + sourceTaskId + ", state=" + finished.getState() + ", matchedAnchors=" + i2 + ", newlyStamped=" + i + ", historySize=" + size + ", existingFinished=" + containsKey);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void initVoiceSession(Context context, String cliCnvId, String parentConversationId, boolean createRemoteParentSession, String cliId, CliType cliType, Mode mode, String parentAgentType, String workspaceDir, Source source, boolean attachmentSubTaskEnabled) {
        boolean z;
        String str;
        String str2 = cliCnvId;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (this.voiceChatSession != null) {
            return;
        }
        this.originConversationId = str2;
        this.parentConversationIdForVoice = (parentConversationId == null || !(StringsKt.isBlank(parentConversationId) ^ true)) ? null : parentConversationId;
        this._voiceMode = mode;
        this._voiceCliType = cliType;
        this.attachmentSubTaskEnabled = attachmentSubTaskEnabled;
        boolean z2 = false;
        if (attachmentSubTaskEnabled && createRemoteParentSession && cliType == CliType.REMOTE) {
            String str3 = str2;
            if (str3 == null || StringsKt.isBlank(str3)) {
                z = true;
                this.needRemoteParentChatSessionForVoice = z;
                str = str2;
                if (str != null || StringsKt.isBlank(str)) {
                    str2 = UUID.randomUUID().toString();
                }
                this._cliConversationId = str2;
                this.perfIsNewSession = str != null || StringsKt.isBlank(str);
                this.voiceChatSession = new BMVoiceChatSessionManager(context, null, null, 6, null);
                if (!attachmentSubTaskEnabled) {
                    VoiceSubTaskCoordinator voiceSubTaskCoordinator = VoiceSubTaskCoordinator.INSTANCE;
                    String str4 = this._cliConversationId;
                    if (str4 == null) {
                        str4 = "";
                    }
                    String str5 = str4;
                    String str6 = (parentConversationId == null || !(StringsKt.isBlank(parentConversationId) ^ true)) ? null : parentConversationId;
                    if (createRemoteParentSession && cliType == CliType.REMOTE) {
                        z2 = true;
                    }
                    voiceSubTaskCoordinator.start(new ProxyConversationConfig(str5, str6, z2, cliId, cliType, mode, (parentAgentType == null || !(StringsKt.isBlank(parentAgentType) ^ true)) ? null : parentAgentType, workspaceDir, source), new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit initVoiceSession$lambda$32;
                            initVoiceSession$lambda$32 = BrainstormViewModel.initVoiceSession$lambda$32(BrainstormViewModel.this, (byte[]) obj);
                            return initVoiceSession$lambda$32;
                        }
                    });
                    return;
                }
                FLogger.INSTANCE.i(TAG, "initVoiceSession: attachment/subtask disabled, skip coordinator start");
                return;
            }
        }
        z = false;
        this.needRemoteParentChatSessionForVoice = z;
        str = str2;
        if (str != null || StringsKt.isBlank(str)) {
        }
        this._cliConversationId = str2;
        this.perfIsNewSession = str != null || StringsKt.isBlank(str);
        this.voiceChatSession = new BMVoiceChatSessionManager(context, null, null, 6, null);
        if (!attachmentSubTaskEnabled) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initVoiceSession$lambda$32(BrainstormViewModel brainstormViewModel, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        BMVoiceChatSessionManager bMVoiceChatSessionManager = brainstormViewModel.voiceChatSession;
        String botName = bMVoiceChatSessionManager != null ? bMVoiceChatSessionManager.getBotName() : null;
        if (botName == null) {
            botName = "";
        }
        if (botName.length() == 0) {
            FLogger.INSTANCE.w(TAG, "sendAckToBot: botName empty, drop ack");
            return Unit.INSTANCE;
        }
        VolcRtcClient.INSTANCE.sendUserBinaryMessageToBot(botName, bArr);
        return Unit.INSTANCE;
    }

    public final void initVoiceAttempt(String attemptId, long startedAtElapsedMs, boolean hasSeenIntro, long clickElapsedMs, long eligibilityPassedElapsedMs, long activityLaunchRequestedElapsedMs) {
        Object obj;
        Intrinsics.checkNotNullParameter(attemptId, "attemptId");
        if (StringsKt.isBlank(attemptId) || startedAtElapsedMs <= 0 || this.voiceDiscussionAttemptTracker != null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (clickElapsedMs >= 0) {
            linkedHashMap.put(VoiceDiscussionAttemptStage.CLICK.getValue(), Long.valueOf(clickElapsedMs));
        }
        if (eligibilityPassedElapsedMs >= 0) {
            linkedHashMap.put(VoiceDiscussionAttemptStage.ELIGIBILITY_PASSED.getValue(), Long.valueOf(eligibilityPassedElapsedMs));
        }
        if (activityLaunchRequestedElapsedMs >= 0) {
            linkedHashMap.put(VoiceDiscussionAttemptStage.ACTIVITY_LAUNCH_REQUESTED.getValue(), Long.valueOf(activityLaunchRequestedElapsedMs));
        }
        List entries = VoiceDiscussionAttemptStage.getEntries();
        ListIterator listIterator = entries.listIterator(entries.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            } else {
                obj = listIterator.previous();
                if (linkedHashMap.containsKey(((VoiceDiscussionAttemptStage) obj).getValue())) {
                    break;
                }
            }
        }
        VoiceDiscussionAttemptStage voiceDiscussionAttemptStage = (VoiceDiscussionAttemptStage) obj;
        String value = voiceDiscussionAttemptStage != null ? voiceDiscussionAttemptStage.getValue() : null;
        String str = value == null ? "" : value;
        CliType cliType = this._voiceCliType;
        Mode mode = this._voiceMode;
        String str2 = this._cliConversationId;
        String str3 = str2 == null ? "" : str2;
        BMVoiceChatSessionManager bMVoiceChatSessionManager = this.voiceChatSession;
        String roomId = bMVoiceChatSessionManager != null ? bMVoiceChatSessionManager.getRoomId() : null;
        this.voiceDiscussionAttemptTracker = new VoiceDiscussionAttemptTracker(new VoiceDiscussionAttemptState(attemptId, startedAtElapsedMs, new VoiceDiscussionAttemptContext(cliType, mode, str3, roomId == null ? "" : roomId, this.perfIsNewSession, hasSeenIntro), linkedHashMap, null, str, null, null, 0, false, 976, null), null, null, null, 14, null);
    }

    public final boolean recordVoiceAttemptStage(VoiceDiscussionAttemptStage stage) {
        Intrinsics.checkNotNullParameter(stage, "stage");
        refreshVoiceAttemptContext();
        VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker = this.voiceDiscussionAttemptTracker;
        return voiceDiscussionAttemptTracker != null && voiceDiscussionAttemptTracker.recordStage(stage);
    }

    public static /* synthetic */ boolean recordVoiceAttemptSignal$default(BrainstormViewModel brainstormViewModel, VoiceDiscussionAttemptSignal voiceDiscussionAttemptSignal, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = voiceDiscussionAttemptSignal.getValue();
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return brainstormViewModel.recordVoiceAttemptSignal(voiceDiscussionAttemptSignal, str, i);
    }

    public final boolean recordVoiceAttemptSignal(VoiceDiscussionAttemptSignal signal, String failureReason, int errorCode) {
        Intrinsics.checkNotNullParameter(signal, "signal");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        refreshVoiceAttemptContext();
        VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker = this.voiceDiscussionAttemptTracker;
        return voiceDiscussionAttemptTracker != null && voiceDiscussionAttemptTracker.recordSignal(signal, failureReason, errorCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshVoiceAttemptContext() {
        VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker = this.voiceDiscussionAttemptTracker;
        if (voiceDiscussionAttemptTracker == null) {
            return;
        }
        VoiceDiscussionAttemptContext context = voiceDiscussionAttemptTracker.snapshot().getContext();
        CliType cliType = this._voiceCliType;
        Mode mode = this._voiceMode;
        String str = this._cliConversationId;
        if (str == null) {
            str = "";
        }
        BMVoiceChatSessionManager bMVoiceChatSessionManager = this.voiceChatSession;
        String roomId = bMVoiceChatSessionManager != null ? bMVoiceChatSessionManager.getRoomId() : null;
        if (roomId == null) {
            roomId = "";
        }
        voiceDiscussionAttemptTracker.updateContext(VoiceDiscussionAttemptContext.copy$default(context, cliType, mode, str, roomId, this.perfIsNewSession, false, 32, null));
    }

    public final void setPerfMicCheckTimestamps(long startMs, long endMs) {
        this.perfMicCheckStartMs = startMs;
        this.perfMicCheckEndMs = endMs;
    }

    public final void startBrainstorm() {
        Object value;
        BrainstormUiState copy;
        recordVoiceAttemptStage(VoiceDiscussionAttemptStage.DISCUSSION_STARTED);
        long currentTimeMillis = System.currentTimeMillis();
        MutableStateFlow<BrainstormUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            copy = r2.copy((r42 & 1) != 0 ? r2.phase : BrainstormPhase.Discussing, (r42 & 2) != 0 ? r2.subtitleHistory : null, (r42 & 4) != 0 ? r2.recordingState : null, (r42 & 8) != 0 ? r2.aiReplyState : null, (r42 & 16) != 0 ? r2.aiParticipantState : null, (r42 & 32) != 0 ? r2.userParticipantState : null, (r42 & 64) != 0 ? r2.currentTranscript : null, (r42 & 128) != 0 ? r2.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r2.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r2.isSpeakerOn : false, (r42 & 1024) != 0 ? r2.isMicMuted : false, (r42 & 2048) != 0 ? r2.isSubtitleMode : false, (r42 & 4096) != 0 ? r2.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r2.sessionStartTimeMs : currentTimeMillis, (r42 & 16384) != 0 ? r2.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r2.timeoutState : TimeoutState.Normal, (65536 & r42) != 0 ? r2.timeoutRemainingSeconds : -1, (r42 & 131072) != 0 ? r2.aiStageDescription : null, (r42 & 262144) != 0 ? r2.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r2.subTask : null, (r42 & 1048576) != 0 ? r2.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value).attachments : null);
        } while (!mutableStateFlow.compareAndSet(value, copy));
        startSessionTimer();
        startRecording();
    }

    public static /* synthetic */ void skipIntroAndStartBrainstorm$default(BrainstormViewModel brainstormViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        brainstormViewModel.skipIntroAndStartBrainstorm(z);
    }

    public final void skipIntroAndStartBrainstorm(boolean autoStartRecording) {
        Object value;
        BrainstormUiState copy;
        if (autoStartRecording) {
            startBrainstorm();
            return;
        }
        recordVoiceAttemptStage(VoiceDiscussionAttemptStage.DISCUSSION_STARTED);
        MutableStateFlow<BrainstormUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            copy = r3.copy((r42 & 1) != 0 ? r3.phase : BrainstormPhase.Discussing, (r42 & 2) != 0 ? r3.subtitleHistory : null, (r42 & 4) != 0 ? r3.recordingState : RecordingState.Idle, (r42 & 8) != 0 ? r3.aiReplyState : null, (r42 & 16) != 0 ? r3.aiParticipantState : null, (r42 & 32) != 0 ? r3.userParticipantState : ParticipantState.Idle, (r42 & 64) != 0 ? r3.currentTranscript : null, (r42 & 128) != 0 ? r3.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r3.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r3.isSpeakerOn : false, (r42 & 1024) != 0 ? r3.isMicMuted : false, (r42 & 2048) != 0 ? r3.isSubtitleMode : false, (r42 & 4096) != 0 ? r3.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r3.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r3.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r3.timeoutState : null, (65536 & r42) != 0 ? r3.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r3.aiStageDescription : null, (r42 & 262144) != 0 ? r3.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r3.subTask : null, (r42 & 1048576) != 0 ? r3.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value).attachments : null);
        } while (!mutableStateFlow.compareAndSet(value, copy));
    }

    public final void startRecording() {
        Object value;
        BrainstormUiState copy;
        BMVoiceChatSessionManager bMVoiceChatSessionManager = this.voiceChatSession;
        if (bMVoiceChatSessionManager == null) {
            FLogger.INSTANCE.w(TAG, rtcDiag("startRecording ignored: voiceChatSession is null"));
            return;
        }
        if (bMVoiceChatSessionManager.getHasStartedVoiceChat()) {
            FLogger.INSTANCE.w(TAG, rtcDiag("startRecording ignored: session already running, room=" + bMVoiceChatSessionManager.getRoomId() + ", task=" + bMVoiceChatSessionManager.getTaskId() + ", isRtcJoined=" + ((BrainstormUiState) this._uiState.getValue()).isRtcJoined()));
            return;
        }
        Job job = this.startRecordingJob;
        boolean z = false;
        if (job != null && job.isActive()) {
            z = true;
        }
        if (z) {
            FLogger.INSTANCE.w(TAG, rtcDiag("startRecording ignored: startRecordingJob active"));
            return;
        }
        recordVoiceAttemptStage(VoiceDiscussionAttemptStage.RECORDING_STARTED);
        MutableStateFlow<BrainstormUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            copy = r4.copy((r42 & 1) != 0 ? r4.phase : null, (r42 & 2) != 0 ? r4.subtitleHistory : null, (r42 & 4) != 0 ? r4.recordingState : RecordingState.Recording, (r42 & 8) != 0 ? r4.aiReplyState : null, (r42 & 16) != 0 ? r4.aiParticipantState : null, (r42 & 32) != 0 ? r4.userParticipantState : ParticipantState.Speaking, (r42 & 64) != 0 ? r4.currentTranscript : "", (r42 & 128) != 0 ? r4.botTranscript : "", (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r4.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r4.isSpeakerOn : false, (r42 & 1024) != 0 ? r4.isMicMuted : false, (r42 & 2048) != 0 ? r4.isSubtitleMode : false, (r42 & 4096) != 0 ? r4.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r4.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r4.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r4.timeoutState : null, (65536 & r42) != 0 ? r4.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r4.aiStageDescription : null, (r42 & 262144) != 0 ? r4.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r4.subTask : null, (r42 & 1048576) != 0 ? r4.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value).attachments : null);
        } while (!mutableStateFlow.compareAndSet(value, copy));
        this.startRecordingJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new BrainstormViewModel$startRecording$2(this, bMVoiceChatSessionManager, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveVoiceConversationIdForRecording(Continuation<? super String> continuation) {
        BrainstormViewModel$resolveVoiceConversationIdForRecording$1 brainstormViewModel$resolveVoiceConversationIdForRecording$1;
        int i;
        boolean z;
        BrainstormViewModel brainstormViewModel;
        String str;
        String str2;
        if (continuation instanceof BrainstormViewModel$resolveVoiceConversationIdForRecording$1) {
            brainstormViewModel$resolveVoiceConversationIdForRecording$1 = (BrainstormViewModel$resolveVoiceConversationIdForRecording$1) continuation;
            if ((brainstormViewModel$resolveVoiceConversationIdForRecording$1.label & Integer.MIN_VALUE) != 0) {
                brainstormViewModel$resolveVoiceConversationIdForRecording$1.label -= Integer.MIN_VALUE;
                Object obj = brainstormViewModel$resolveVoiceConversationIdForRecording$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = brainstormViewModel$resolveVoiceConversationIdForRecording$1.label;
                z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.needRemoteParentChatSessionForVoice) {
                        String str3 = get_cliConversationId();
                        if (str3 == null || !(!StringsKt.isBlank(str3))) {
                            return null;
                        }
                        return str3;
                    }
                    VoiceSubTaskCoordinator voiceSubTaskCoordinator = VoiceSubTaskCoordinator.INSTANCE;
                    brainstormViewModel$resolveVoiceConversationIdForRecording$1.L$0 = this;
                    brainstormViewModel$resolveVoiceConversationIdForRecording$1.label = 1;
                    obj = voiceSubTaskCoordinator.awaitParentChatSessionId(brainstormViewModel$resolveVoiceConversationIdForRecording$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    brainstormViewModel = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    brainstormViewModel = (BrainstormViewModel) brainstormViewModel$resolveVoiceConversationIdForRecording$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                str = (String) obj;
                if (str != null || !(!StringsKt.isBlank(str))) {
                    str = null;
                }
                str2 = str;
                if (str2 != null && !StringsKt.isBlank(str2)) {
                    z = false;
                }
                if (!z) {
                    return null;
                }
                if (!Intrinsics.areEqual(brainstormViewModel._cliConversationId, str)) {
                    FLogger.INSTANCE.d(TAG, "resolveVoiceConversationIdForRecording: switch voice cliConversationId=" + brainstormViewModel._cliConversationId + " -> " + str);
                    brainstormViewModel._cliConversationId = str;
                }
                return str;
            }
        }
        brainstormViewModel$resolveVoiceConversationIdForRecording$1 = new BrainstormViewModel$resolveVoiceConversationIdForRecording$1(this, continuation);
        Object obj2 = brainstormViewModel$resolveVoiceConversationIdForRecording$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = brainstormViewModel$resolveVoiceConversationIdForRecording$1.label;
        z = true;
        if (i != 0) {
        }
        str = (String) obj2;
        if (str != null) {
        }
        str = null;
        str2 = str;
        if (str2 != null) {
            z = false;
        }
        if (!z) {
        }
    }

    public final void toggleMic() {
        BrainstormUiState copy;
        BMVoiceChatSessionManager bMVoiceChatSessionManager = this.voiceChatSession;
        if (bMVoiceChatSessionManager == null) {
            FLogger.INSTANCE.w(TAG, "toggleMic ignored: voiceChatSession is null");
            return;
        }
        BrainstormUiState brainstormUiState = (BrainstormUiState) this._uiState.getValue();
        boolean z = !brainstormUiState.isMicMuted();
        String str = ", isRtcJoined=";
        String str2 = ", room=";
        String str3 = ", task=";
        FLogger.INSTANCE.d(TAG, "toggleMic: oldMuted=" + brainstormUiState.isMicMuted() + ", newMuted=" + z + ", phase=" + brainstormUiState.getPhase() + ", recordingState=" + brainstormUiState.getRecordingState() + ", isRtcJoined=" + brainstormUiState.isRtcJoined() + ", sessionRunning=" + bMVoiceChatSessionManager.getHasStartedVoiceChat() + ", room=" + bMVoiceChatSessionManager.getRoomId() + ", task=" + bMVoiceChatSessionManager.getTaskId());
        if (z) {
            bMVoiceChatSessionManager.muteMic();
        } else {
            bMVoiceChatSessionManager.unmuteMic();
        }
        MutableStateFlow<BrainstormUiState> mutableStateFlow = this._uiState;
        while (true) {
            Object value = mutableStateFlow.getValue();
            String str4 = str3;
            String str5 = str2;
            String str6 = str;
            copy = r5.copy((r42 & 1) != 0 ? r5.phase : null, (r42 & 2) != 0 ? r5.subtitleHistory : null, (r42 & 4) != 0 ? r5.recordingState : null, (r42 & 8) != 0 ? r5.aiReplyState : null, (r42 & 16) != 0 ? r5.aiParticipantState : null, (r42 & 32) != 0 ? r5.userParticipantState : null, (r42 & 64) != 0 ? r5.currentTranscript : null, (r42 & 128) != 0 ? r5.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r5.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r5.isSpeakerOn : false, (r42 & 1024) != 0 ? r5.isMicMuted : z, (r42 & 2048) != 0 ? r5.isSubtitleMode : false, (r42 & 4096) != 0 ? r5.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r5.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r5.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r5.timeoutState : null, (65536 & r42) != 0 ? r5.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r5.aiStageDescription : null, (r42 & 262144) != 0 ? r5.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r5.subTask : null, (r42 & 1048576) != 0 ? r5.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value).attachments : null);
            if (mutableStateFlow.compareAndSet(value, copy)) {
                FLogger.INSTANCE.d(TAG, "toggleMic applied: isMicMuted=" + ((BrainstormUiState) this._uiState.getValue()).isMicMuted() + str6 + ((BrainstormUiState) this._uiState.getValue()).isRtcJoined() + str5 + bMVoiceChatSessionManager.getRoomId() + str4 + bMVoiceChatSessionManager.getTaskId());
                return;
            } else {
                str3 = str4;
                str2 = str5;
                str = str6;
            }
        }
    }

    public final String drainBotSubtitleChars() {
        String sb = this._botSubtitleBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        StringsKt.clear(this._botSubtitleBuffer);
        return sb;
    }

    private final void flushSubtitleBuffers() {
        if (this._botWordAggregateBuffer.length() > 0) {
            this._botSubtitleBuffer.append((CharSequence) this._botWordAggregateBuffer);
            StringsKt.clear(this._botWordAggregateBuffer);
        }
        if (this._userWordAggregateBuffer.length() > 0) {
            this._userSubtitleBuffer.append((CharSequence) this._userWordAggregateBuffer);
            StringsKt.clear(this._userWordAggregateBuffer);
        }
    }

    public final void toggleSpeaker() {
        Object value;
        BrainstormUiState copy;
        boolean z = ((BrainstormUiState) this._uiState.getValue()).getAiParticipantState() == ParticipantState.Speaking;
        MutableStateFlow<BrainstormUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            BrainstormUiState brainstormUiState = (BrainstormUiState) value;
            boolean z2 = !brainstormUiState.isSpeakerOn();
            AudioDevice audioDevice = z2 ? AudioDevice.Speaker : AudioDevice.Earpiece;
            this.audioDeviceManager.switchToDevice(audioDevice);
            copy = brainstormUiState.copy((r42 & 1) != 0 ? brainstormUiState.phase : null, (r42 & 2) != 0 ? brainstormUiState.subtitleHistory : null, (r42 & 4) != 0 ? brainstormUiState.recordingState : null, (r42 & 8) != 0 ? brainstormUiState.aiReplyState : null, (r42 & 16) != 0 ? brainstormUiState.aiParticipantState : null, (r42 & 32) != 0 ? brainstormUiState.userParticipantState : null, (r42 & 64) != 0 ? brainstormUiState.currentTranscript : null, (r42 & 128) != 0 ? brainstormUiState.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? brainstormUiState.currentAudioDevice : audioDevice, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? brainstormUiState.isSpeakerOn : z2, (r42 & 1024) != 0 ? brainstormUiState.isMicMuted : false, (r42 & 2048) != 0 ? brainstormUiState.isSubtitleMode : false, (r42 & 4096) != 0 ? brainstormUiState.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? brainstormUiState.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? brainstormUiState.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? brainstormUiState.timeoutState : null, (65536 & r42) != 0 ? brainstormUiState.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? brainstormUiState.aiStageDescription : null, (r42 & 262144) != 0 ? brainstormUiState.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? brainstormUiState.subTask : null, (r42 & 1048576) != 0 ? brainstormUiState.finishedSubTasks : null, (r42 & 2097152) != 0 ? brainstormUiState.attachments : null);
        } while (!mutableStateFlow.compareAndSet(value, copy));
        if (z) {
            restartOutputVolumeMonitoring("route_changed");
        }
    }

    public final void onHostResumed() {
        if (((BrainstormUiState) this._uiState.getValue()).getAiParticipantState() == ParticipantState.Speaking) {
            restartOutputVolumeMonitoring("host_resumed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restartOutputVolumeMonitoring(String reason) {
        Job job = this.outputVolumeMonitorJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.voiceHealthMonitor.resetOutputVolume();
        this.outputVolumeMonitorJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new BrainstormViewModel$restartOutputVolumeMonitoring$1(this, reason, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopOutputVolumeMonitoring() {
        Job job = this.outputVolumeMonitorJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.outputVolumeMonitorJob = null;
        this.voiceHealthMonitor.resetOutputVolume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitOutputVolumePromptIfNeeded(String reason) {
        VoicePrompt.Health onOutputVolumeCheck = this.voiceHealthMonitor.onOutputVolumeCheck((BrainstormUiState) this._uiState.getValue());
        if (onOutputVolumeCheck == null) {
            return;
        }
        FLogger.INSTANCE.i(TAG, "output_volume_prompt reason=" + reason);
        this._voicePromptEvents.tryEmit(onOutputVolumeCheck);
    }

    public final void toggleSubtitleMode() {
        Object value;
        BrainstormUiState copy;
        try {
            boolean z = !((BrainstormUiState) this._uiState.getValue()).isSubtitleMode();
            if (z) {
                this.sessionHasEverEnabledSubtitle = true;
            }
            MutableStateFlow<BrainstormUiState> mutableStateFlow = this._uiState;
            do {
                value = mutableStateFlow.getValue();
                copy = r3.copy((r42 & 1) != 0 ? r3.phase : null, (r42 & 2) != 0 ? r3.subtitleHistory : null, (r42 & 4) != 0 ? r3.recordingState : null, (r42 & 8) != 0 ? r3.aiReplyState : null, (r42 & 16) != 0 ? r3.aiParticipantState : null, (r42 & 32) != 0 ? r3.userParticipantState : null, (r42 & 64) != 0 ? r3.currentTranscript : null, (r42 & 128) != 0 ? r3.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r3.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r3.isSpeakerOn : false, (r42 & 1024) != 0 ? r3.isMicMuted : false, (r42 & 2048) != 0 ? r3.isSubtitleMode : z, (r42 & 4096) != 0 ? r3.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r3.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r3.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r3.timeoutState : null, (65536 & r42) != 0 ? r3.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r3.aiStageDescription : null, (r42 & 262144) != 0 ? r3.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r3.subTask : null, (r42 & 1048576) != 0 ? r3.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value).attachments : null);
            } while (!mutableStateFlow.compareAndSet(value, copy));
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ void endBrainstorm$default(BrainstormViewModel brainstormViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        brainstormViewModel.endBrainstorm(z);
    }

    public final void endBrainstorm(boolean isAbort) {
        String str;
        stopSessionTimer();
        Job job = this.aiReplyJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.aiReplyJob = null;
        Job job2 = this.startRecordingJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.startRecordingJob = null;
        stopOutputVolumeMonitoring();
        BrainstormUiState brainstormUiState = (BrainstormUiState) this._uiState.getValue();
        boolean hasSummaryWorthyInput = BrainstormSummaryEligibilityKt.hasSummaryWorthyInput(brainstormUiState);
        String str2 = (String) VoiceSubTaskCoordinator.INSTANCE.getParentConversationId().getValue();
        if (str2 == null) {
            str2 = this.parentConversationIdForVoice;
        }
        String str3 = str2;
        if (isAbort) {
            str = "discard";
        } else {
            str = ((BrainstormUiState) this._uiState.getValue()).getTimeoutState() == TimeoutState.Expired ? "timeout" : "normal";
        }
        reportDiscussionSessionPerf(str);
        VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker = this.voiceDiscussionAttemptTracker;
        if (voiceDiscussionAttemptTracker != null) {
            voiceDiscussionAttemptTracker.finishInferred();
        }
        BMVoiceChatSessionManager bMVoiceChatSessionManager = this.voiceChatSession;
        if (bMVoiceChatSessionManager != null) {
            bMVoiceChatSessionManager.release();
        }
        this.voiceChatSession = null;
        VoiceSubTaskCoordinator.INSTANCE.release(isAbort || !hasSummaryWorthyInput, isAbort ? "brainstorm_abort" : !hasSummaryWorthyInput ? "brainstorm_empty_end" : "brainstorm_normal_end");
        cancelAllPendingUploads(true);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new BrainstormViewModel$endBrainstorm$1(brainstormUiState, this, hasSummaryWorthyInput, isAbort, str3, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startSessionTimer() {
        stopSessionTimer();
        this.sessionTimerJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new BrainstormViewModel$startSessionTimer$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopSessionTimer() {
        Job job = this.sessionTimerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.sessionTimerJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportDiscussionStartPerfIfNeeded() {
        VoiceDiscussionAttemptState snapshot;
        try {
            if (!this.discussionStartPerfReported && this.perfMicCheckStartMs > 0) {
                this.discussionStartPerfReported = true;
                long currentTimeMillis = System.currentTimeMillis();
                long max = Math.max(this.perfMicCheckEndMs - this.perfMicCheckStartMs, 0L);
                long max2 = Math.max(this.perfJoinRoomStartMs - this.perfApiRequestStartMs, 0L);
                long max3 = Math.max(this.perfJoinRoomSuccessMs - this.perfJoinRoomStartMs, 0L);
                long j = this.perfBotJoinedMs;
                long max4 = j > 0 ? Math.max(j - this.perfJoinRoomSuccessMs, 0L) : 0L;
                long max5 = Math.max(currentTimeMillis - this.perfMicCheckStartMs, 0L);
                BMVoiceChatSessionManager bMVoiceChatSessionManager = this.voiceChatSession;
                String roomId = bMVoiceChatSessionManager != null ? bMVoiceChatSessionManager.getRoomId() : null;
                String str = "";
                if (roomId == null) {
                    roomId = "";
                }
                JSONObject commonCategory = VoiceDiscussionMetrics.INSTANCE.commonCategory(this._voiceCliType, this._voiceMode);
                commonCategory.put("is_new_session", this.perfIsNewSession ? "1" : "0");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mic_check_ms", max);
                jSONObject.put("start_voice_chat_request_ms", max2);
                jSONObject.put("join_room_ms", max3);
                jSONObject.put("bot_join_ms", max4);
                jSONObject.put("total_ms", max5);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("room_id", roomId);
                VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker = this.voiceDiscussionAttemptTracker;
                String attemptId = (voiceDiscussionAttemptTracker == null || (snapshot = voiceDiscussionAttemptTracker.snapshot()) == null) ? null : snapshot.getAttemptId();
                if (attemptId != null) {
                    str = attemptId;
                }
                jSONObject2.put("attempt_id", str);
                ApmService.INSTANCE.monitorEventForSlardar(EVENT_DISCUSSION_START_PERF, commonCategory, jSONObject, jSONObject2);
            }
        } catch (Throwable th) {
            FLogger.INSTANCE.w(TAG, "reportDiscussionStartPerf failed", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoundDelayRecord currentRound() {
        return (RoundDelayRecord) CollectionsKt.lastOrNull(this.sessionRoundDelays);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markCurrentRoundHasSubtask() {
        RoundDelayRecord currentRound = currentRound();
        if (currentRound != null) {
            currentRound.setHasSubtask(true);
        }
    }

    private final void markCurrentRoundUpload() {
        RoundDelayRecord currentRound = currentRound();
        if (currentRound != null) {
            currentRound.setHasUpload(true);
            currentRound.setAttachmentCount(currentRound.getAttachmentCount() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markCurrentRoundServerTool(String toolName) {
        RoundDelayRecord currentRound;
        if (toolName != null) {
            if (!(!StringsKt.isBlank(toolName))) {
                toolName = null;
            }
            if (toolName == null || (currentRound = currentRound()) == null) {
                return;
            }
            currentRound.getToolNames().add(toolName);
            if (Intrinsics.areEqual(toolName, "web_search")) {
                currentRound.setHasSearch(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportServerToolEnd(ToolResultMessage msg) {
        RoundDelayRecord currentRound = currentRound();
        VoiceDiscussionMetrics voiceDiscussionMetrics = VoiceDiscussionMetrics.INSTANCE;
        CliType cliType = this._voiceCliType;
        Mode mode = this._voiceMode;
        String str = this._cliConversationId;
        BMVoiceChatSessionManager bMVoiceChatSessionManager = this.voiceChatSession;
        String roomId = bMVoiceChatSessionManager != null ? bMVoiceChatSessionManager.getRoomId() : null;
        if (roomId == null) {
            roomId = "";
        }
        voiceDiscussionMetrics.reportServerToolEnd(cliType, mode, str, roomId, currentRound != null ? Integer.valueOf(currentRound.getRoundIndex()) : null, currentRound != null ? Long.valueOf(currentRound.getConvRoundId()) : null, msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportVoiceFileUploadEnd(BrainstormAttachment attachment, long fileSizeBytes, long uploadStartMs, String status, String failureReason) {
        RoundDelayRecord currentRound = currentRound();
        VoiceDiscussionMetrics voiceDiscussionMetrics = VoiceDiscussionMetrics.INSTANCE;
        CliType cliType = this._voiceCliType;
        Mode mode = this._voiceMode;
        String str = this._cliConversationId;
        BMVoiceChatSessionManager bMVoiceChatSessionManager = this.voiceChatSession;
        String roomId = bMVoiceChatSessionManager != null ? bMVoiceChatSessionManager.getRoomId() : null;
        if (roomId == null) {
            roomId = "";
        }
        voiceDiscussionMetrics.reportFileUploadEnd(cliType, mode, str, roomId, currentRound != null ? Integer.valueOf(currentRound.getRoundIndex()) : null, currentRound != null ? Long.valueOf(currentRound.getConvRoundId()) : null, attachment.isImage() ? "image" : "attachment", attachment.getMimeType(), fileSizeBytes, attachment.getUseImageUpload() ? "imagex" : "remote_resource", System.currentTimeMillis() - uploadStartMs, status, failureReason);
    }

    public final void reportWindowStateClick(String action, String windowStateBeforeClick) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(windowStateBeforeClick, "windowStateBeforeClick");
        VoiceDiscussionMetrics voiceDiscussionMetrics = VoiceDiscussionMetrics.INSTANCE;
        CliType cliType = this._voiceCliType;
        Mode mode = this._voiceMode;
        String str = this._cliConversationId;
        BMVoiceChatSessionManager bMVoiceChatSessionManager = this.voiceChatSession;
        String roomId = bMVoiceChatSessionManager != null ? bMVoiceChatSessionManager.getRoomId() : null;
        if (roomId == null) {
            roomId = "";
        }
        voiceDiscussionMetrics.reportWindowStateClick(cliType, mode, str, roomId, action, windowStateBeforeClick);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeLastRoundAsInterruptedIfNeeded(String triggerReason) {
        InterruptPhase interruptPhase;
        RoundDelayRecord currentRound = currentRound();
        if (currentRound == null || currentRound.getReported()) {
            return;
        }
        if (currentRound.getInterrupted()) {
            tryReportRoundIfFinal(currentRound, triggerReason);
            return;
        }
        if (currentRound.getBotFinishMs() != null) {
            tryReportRoundIfFinal(currentRound, triggerReason);
            return;
        }
        currentRound.setInterrupted(true);
        if (currentRound.getBotFirstCharMs() != null) {
            interruptPhase = InterruptPhase.DURING_ANSWERING;
        } else {
            interruptPhase = currentRound.getBotAnsweringMs() == null ? InterruptPhase.BEFORE_ANSWERING : InterruptPhase.BEFORE_FIRST_CHAR;
        }
        currentRound.setInterruptPhase(interruptPhase);
        this.awaitingBotFirstChar = false;
        FLogger.INSTANCE.d(TAG, "closeLastRoundAsInterrupted: idx=" + currentRound.getRoundIndex() + " phase=" + currentRound.getInterruptPhase() + " reason=" + triggerReason);
        tryReportRoundIfFinal(currentRound, triggerReason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryReportRoundIfFinal(RoundDelayRecord record, String finalReason) {
        if (record.getReported()) {
            return;
        }
        if (record.getInterrupted() || record.getBotFinishMs() != null || (record.getBotFirstCharMs() != null && Intrinsics.areEqual(finalReason, "new_thinking")) || Intrinsics.areEqual(finalReason, "session_end")) {
            record.setReported(true);
            reportRoundPerf(record);
        }
    }

    private final void reportRoundPerf(RoundDelayRecord r) {
        String str;
        long j;
        long j2;
        String str2;
        long j3;
        long j4;
        long j5;
        String str3;
        VoiceDiscussionAttemptState snapshot;
        try {
            Long botFirstCharMs = r.getBotFirstCharMs();
            long longValue = botFirstCharMs != null ? botFirstCharMs.longValue() - r.getUserSpeakEndMs() : -1L;
            Long botLatestCharMs = r.getBotLatestCharMs();
            long longValue2 = botLatestCharMs != null ? botLatestCharMs.longValue() - r.getUserSpeakEndMs() : -1L;
            Long botAnsweringMs = r.getBotAnsweringMs();
            long longValue3 = botAnsweringMs != null ? botAnsweringMs.longValue() - r.getUserSpeakEndMs() : -1L;
            if (r.getBotAnsweringMs() == null || r.getBotFirstCharMs() == null) {
                j = -1;
            } else {
                Long botFirstCharMs2 = r.getBotFirstCharMs();
                Intrinsics.checkNotNull(botFirstCharMs2);
                long longValue4 = botFirstCharMs2.longValue();
                Long botAnsweringMs2 = r.getBotAnsweringMs();
                Intrinsics.checkNotNull(botAnsweringMs2);
                j = longValue4 - botAnsweringMs2.longValue();
            }
            if (r.getBotFirstCharMs() == null || r.getBotLatestCharMs() == null) {
                j2 = -1;
            } else {
                Long botLatestCharMs2 = r.getBotLatestCharMs();
                Intrinsics.checkNotNull(botLatestCharMs2);
                long longValue5 = botLatestCharMs2.longValue();
                Long botFirstCharMs3 = r.getBotFirstCharMs();
                Intrinsics.checkNotNull(botFirstCharMs3);
                j2 = longValue5 - botFirstCharMs3.longValue();
            }
            long currentTimeMillis = (r.getInterrupted() && r.getBotFirstCharMs() == null) ? System.currentTimeMillis() - r.getUserSpeakEndMs() : -1L;
            if (r.getUserSpeakStartMs() == null || r.getUserSubtitleFirstCharMs() == null) {
                str2 = TAG;
                j3 = -1;
            } else {
                Long userSubtitleFirstCharMs = r.getUserSubtitleFirstCharMs();
                Intrinsics.checkNotNull(userSubtitleFirstCharMs);
                long longValue6 = userSubtitleFirstCharMs.longValue();
                Long userSpeakStartMs = r.getUserSpeakStartMs();
                Intrinsics.checkNotNull(userSpeakStartMs);
                long longValue7 = userSpeakStartMs.longValue();
                str2 = TAG;
                try {
                    j3 = RangesKt.coerceAtLeast(longValue6 - longValue7, 0L);
                } catch (Throwable th) {
                    th = th;
                    str = str2;
                    FLogger.INSTANCE.w(str, "reportRoundPerf failed", th);
                }
            }
            Long userSubtitleLastCharMs = r.getUserSubtitleLastCharMs();
            if (userSubtitleLastCharMs != null) {
                j4 = j3;
                j5 = RangesKt.coerceAtLeast(userSubtitleLastCharMs.longValue() - r.getUserSpeakEndMs(), 0L);
            } else {
                j4 = j3;
                j5 = -1;
            }
            if (!r.getInterrupted() && r.getBotFinishMs() != null && r.getBotFirstCharMs() != null) {
                str3 = "normal";
            } else if (r.getInterruptPhase() == InterruptPhase.BEFORE_ANSWERING) {
                str3 = "interrupted_before_answering";
            } else if (r.getInterruptPhase() == InterruptPhase.BEFORE_FIRST_CHAR) {
                str3 = "interrupted_before_first_char";
            } else {
                str3 = r.getInterruptPhase() == InterruptPhase.DURING_ANSWERING ? "interrupted_during_answering" : "session_end_dangling";
            }
            int botCharCount = r.getBotCharCount() + r.getBotCurrentParagraphChars();
            int userCharCount = r.getUserCharCount();
            JSONObject jSONObject = new JSONObject();
            long j6 = j5;
            VoiceDiscussionMetrics.INSTANCE.putVoiceCommonParams(jSONObject, this._voiceCliType, this._voiceMode);
            String str4 = this._cliConversationId;
            String str5 = "";
            if (str4 == null) {
                str4 = "";
            }
            jSONObject.put("conversation_id", str4);
            BMVoiceChatSessionManager bMVoiceChatSessionManager = this.voiceChatSession;
            String str6 = null;
            String roomId = bMVoiceChatSessionManager != null ? bMVoiceChatSessionManager.getRoomId() : null;
            if (roomId == null) {
                roomId = "";
            }
            jSONObject.put("room_id", roomId);
            VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker = this.voiceDiscussionAttemptTracker;
            if (voiceDiscussionAttemptTracker != null && (snapshot = voiceDiscussionAttemptTracker.snapshot()) != null) {
                str6 = snapshot.getAttemptId();
            }
            if (str6 != null) {
                str5 = str6;
            }
            jSONObject.put("attempt_id", str5);
            jSONObject.put("round_index", r.getRoundIndex());
            jSONObject.put("conv_round_id", r.getConvRoundId());
            jSONObject.put("round_result", str3);
            jSONObject.put("first_char_on_screen_ms", longValue);
            jSONObject.put("last_char_on_screen_ms", longValue2);
            jSONObject.put("server_thinking_ms", longValue3);
            jSONObject.put("answering_to_first_char_ms", j);
            jSONObject.put("bot_speaking_duration_ms", j2);
            jSONObject.put("waited_before_interrupt_ms", currentTimeMillis);
            jSONObject.put("user_subtitle_first_char_ms", j4);
            jSONObject.put("user_subtitle_last_char_ms", j6);
            jSONObject.put("user_char_count", userCharCount);
            jSONObject.put("bot_char_count", botCharCount);
            jSONObject.put("is_new_session", this.perfIsNewSession ? "1" : "0");
            jSONObject.put("has_search", VoiceDiscussionMetrics.INSTANCE.boolValue(r.getHasSearch()));
            jSONObject.put("has_subtask", VoiceDiscussionMetrics.INSTANCE.boolValue(r.getHasSubtask()));
            jSONObject.put("has_upload", VoiceDiscussionMetrics.INSTANCE.boolValue(r.getHasUpload()));
            jSONObject.put("attachment_count", r.getAttachmentCount());
            jSONObject.put("tool_name", CollectionsKt.joinToString$default(r.getToolNames(), IWeiboService.Scope.EMPTY_SCOPE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            IApplog.INSTANCE.reportEvent(EVENT_DISCUSSION_ROUND_PERF, jSONObject);
            String str7 = "voice_discussion_round_perf: " + jSONObject;
            str = str2;
            try {
                FLogger.INSTANCE.d(str, str7);
                recordVoiceAttemptStage(VoiceDiscussionAttemptStage.ROUND_REPORTED);
                VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker2 = this.voiceDiscussionAttemptTracker;
                if (voiceDiscussionAttemptTracker2 != null) {
                    voiceDiscussionAttemptTracker2.finishInferred();
                }
            } catch (Throwable th2) {
                th = th2;
                FLogger.INSTANCE.w(str, "reportRoundPerf failed", th);
            }
        } catch (Throwable th3) {
            th = th3;
            str = TAG;
        }
    }

    private final void reportDiscussionSessionPerf(String endType) {
        String str;
        Object obj;
        String str2;
        String str3;
        int i;
        int i2;
        int i3;
        long j;
        Object obj2;
        VoiceDiscussionAttemptState snapshot;
        VoiceDiscussionAttemptState snapshot2;
        String str4;
        String str5;
        Long l;
        Iterator it;
        Long l2;
        Iterator it2;
        Long l3;
        String str6 = "max_user_subtitle_first_char_ms";
        String str7 = "avg_user_subtitle_first_char_ms";
        String str8 = "max_last_char_on_screen_ms";
        String str9 = "max_first_char_on_screen_ms";
        String str10 = "avg_first_char_on_screen_ms";
        String str11 = "bot_char_count";
        String str12 = "user_char_count";
        try {
            closeLastRoundAsInterruptedIfNeeded("session_end");
            long sessionElapsedMs = ((BrainstormUiState) this._uiState.getValue()).getSessionElapsedMs();
            int size = this.sessionRoundDelays.size();
            if (size == 0) {
                FLogger.INSTANCE.d(TAG, "reportDiscussionSessionPerf: totalRounds=0, skip both reports");
                return;
            }
            try {
                List<RoundDelayRecord> list = this.sessionRoundDelays;
                ArrayList arrayList = new ArrayList();
                Iterator<T> it3 = list.iterator();
                while (true) {
                    boolean z = true;
                    if (!it3.hasNext()) {
                        break;
                    }
                    String str13 = str6;
                    Object next = it3.next();
                    RoundDelayRecord roundDelayRecord = (RoundDelayRecord) next;
                    if (roundDelayRecord.getInterrupted() || roundDelayRecord.getBotFirstCharMs() == null || roundDelayRecord.getBotFinishMs() == null) {
                        z = false;
                    }
                    if (z) {
                        arrayList.add(next);
                    }
                    str6 = str13;
                }
                String str14 = str6;
                ArrayList arrayList2 = arrayList;
                List<RoundDelayRecord> list2 = this.sessionRoundDelays;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj3 : list2) {
                    String str15 = str7;
                    RoundDelayRecord roundDelayRecord2 = (RoundDelayRecord) obj3;
                    if ((roundDelayRecord2.getInterrupted() || roundDelayRecord2.getBotAnsweringMs() == null) ? false : true) {
                        arrayList3.add(obj3);
                    }
                    str7 = str15;
                }
                String str16 = str7;
                ArrayList arrayList4 = arrayList3;
                List<RoundDelayRecord> list3 = this.sessionRoundDelays;
                ArrayList arrayList5 = new ArrayList();
                for (Object obj4 : list3) {
                    String str17 = str8;
                    RoundDelayRecord roundDelayRecord3 = (RoundDelayRecord) obj4;
                    if (!roundDelayRecord3.getInterrupted() && roundDelayRecord3.getUserFinalReceived()) {
                        arrayList5.add(obj4);
                    }
                    str8 = str17;
                }
                String str18 = str8;
                ArrayList<RoundDelayRecord> arrayList6 = arrayList5;
                ArrayList arrayList7 = new ArrayList();
                Iterator it4 = arrayList2.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    RoundDelayRecord roundDelayRecord4 = (RoundDelayRecord) it4.next();
                    Long botFirstCharMs = roundDelayRecord4.getBotFirstCharMs();
                    obj = botFirstCharMs != null ? Long.valueOf(botFirstCharMs.longValue() - roundDelayRecord4.getUserSpeakEndMs()) : null;
                    Iterator it5 = it4;
                    Object obj5 = obj;
                    if (obj5 != null) {
                        arrayList7.add(obj5);
                    }
                    it4 = it5;
                }
                ArrayList arrayList8 = arrayList7;
                ArrayList arrayList9 = arrayList2;
                ArrayList arrayList10 = new ArrayList();
                Iterator it6 = arrayList9.iterator();
                while (it6.hasNext()) {
                    RoundDelayRecord roundDelayRecord5 = (RoundDelayRecord) it6.next();
                    Long botLatestCharMs = roundDelayRecord5.getBotLatestCharMs();
                    if (botLatestCharMs != null) {
                        Long valueOf = Long.valueOf(botLatestCharMs.longValue() - roundDelayRecord5.getUserSpeakEndMs());
                        it2 = it6;
                        l3 = valueOf;
                    } else {
                        it2 = it6;
                        l3 = null;
                    }
                    if (l3 != null) {
                        arrayList10.add(l3);
                    }
                    it6 = it2;
                }
                ArrayList arrayList11 = arrayList10;
                ArrayList arrayList12 = new ArrayList();
                Iterator it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    RoundDelayRecord roundDelayRecord6 = (RoundDelayRecord) it7.next();
                    Long botAnsweringMs = roundDelayRecord6.getBotAnsweringMs();
                    if (botAnsweringMs != null) {
                        Long valueOf2 = Long.valueOf(botAnsweringMs.longValue() - roundDelayRecord6.getUserSpeakEndMs());
                        it = it7;
                        l2 = valueOf2;
                    } else {
                        it = it7;
                        l2 = null;
                    }
                    if (l2 != null) {
                        arrayList12.add(l2);
                    }
                    it7 = it;
                }
                ArrayList arrayList13 = arrayList12;
                ArrayList arrayList14 = new ArrayList();
                Iterator it8 = arrayList6.iterator();
                while (true) {
                    str2 = str9;
                    str3 = str10;
                    if (!it8.hasNext()) {
                        break;
                    }
                    RoundDelayRecord roundDelayRecord7 = (RoundDelayRecord) it8.next();
                    if (roundDelayRecord7.getUserSpeakStartMs() == null || roundDelayRecord7.getUserSubtitleFirstCharMs() == null) {
                        str4 = str11;
                        str5 = str12;
                        l = null;
                    } else {
                        Long userSubtitleFirstCharMs = roundDelayRecord7.getUserSubtitleFirstCharMs();
                        Intrinsics.checkNotNull(userSubtitleFirstCharMs);
                        long longValue = userSubtitleFirstCharMs.longValue();
                        Long userSpeakStartMs = roundDelayRecord7.getUserSpeakStartMs();
                        Intrinsics.checkNotNull(userSpeakStartMs);
                        long longValue2 = userSpeakStartMs.longValue();
                        str4 = str11;
                        str5 = str12;
                        l = Long.valueOf(RangesKt.coerceAtLeast(longValue - longValue2, 0L));
                    }
                    if (l != null) {
                        arrayList14.add(l);
                    }
                    str11 = str4;
                    str9 = str2;
                    str10 = str3;
                    str12 = str5;
                }
                String str19 = str11;
                String str20 = str12;
                ArrayList arrayList15 = arrayList14;
                ArrayList arrayList16 = new ArrayList();
                for (RoundDelayRecord roundDelayRecord8 : arrayList6) {
                    Long userSubtitleLastCharMs = roundDelayRecord8.getUserSubtitleLastCharMs();
                    Long valueOf3 = userSubtitleLastCharMs != null ? Long.valueOf(RangesKt.coerceAtLeast(userSubtitleLastCharMs.longValue() - roundDelayRecord8.getUserSpeakEndMs(), 0L)) : null;
                    if (valueOf3 != null) {
                        arrayList16.add(valueOf3);
                    }
                }
                ArrayList arrayList17 = arrayList16;
                long avgOrMissing = avgOrMissing(arrayList8);
                long maxOrMissing = maxOrMissing(arrayList8);
                long avgOrMissing2 = avgOrMissing(arrayList11);
                long maxOrMissing2 = maxOrMissing(arrayList11);
                long avgOrMissing3 = avgOrMissing(arrayList13);
                long maxOrMissing3 = maxOrMissing(arrayList13);
                long avgOrMissing4 = avgOrMissing(arrayList15);
                long maxOrMissing4 = maxOrMissing(arrayList15);
                long avgOrMissing5 = avgOrMissing(arrayList17);
                long maxOrMissing5 = maxOrMissing(arrayList17);
                List<RoundDelayRecord> list4 = this.sessionRoundDelays;
                if ((list4 instanceof Collection) && list4.isEmpty()) {
                    i = 0;
                } else {
                    Iterator<T> it9 = list4.iterator();
                    i = 0;
                    while (it9.hasNext()) {
                        if ((((RoundDelayRecord) it9.next()).getInterruptPhase() == InterruptPhase.BEFORE_ANSWERING) && (i = i + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                List<RoundDelayRecord> list5 = this.sessionRoundDelays;
                if ((list5 instanceof Collection) && list5.isEmpty()) {
                    i2 = 0;
                } else {
                    Iterator it10 = list5.iterator();
                    i2 = 0;
                    while (it10.hasNext()) {
                        Iterator it11 = it10;
                        if ((((RoundDelayRecord) it10.next()).getInterruptPhase() == InterruptPhase.BEFORE_FIRST_CHAR) && (i2 = i2 + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        it10 = it11;
                    }
                }
                List<RoundDelayRecord> list6 = this.sessionRoundDelays;
                if ((list6 instanceof Collection) && list6.isEmpty()) {
                    j = maxOrMissing5;
                    i3 = 0;
                } else {
                    Iterator it12 = list6.iterator();
                    i3 = 0;
                    while (it12.hasNext()) {
                        Iterator it13 = it12;
                        long j2 = maxOrMissing5;
                        if ((((RoundDelayRecord) it12.next()).getInterruptPhase() == InterruptPhase.DURING_ANSWERING) && (i3 = i3 + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        it12 = it13;
                        maxOrMissing5 = j2;
                    }
                    j = maxOrMissing5;
                }
                int i4 = i + i2;
                BMVoiceChatSessionManager bMVoiceChatSessionManager = this.voiceChatSession;
                Object roomId = bMVoiceChatSessionManager != null ? bMVoiceChatSessionManager.getRoomId() : null;
                if (roomId == null) {
                    roomId = "";
                    obj2 = roomId;
                } else {
                    obj2 = "";
                }
                Object obj6 = this.originConversationId;
                int i5 = i3;
                if (obj6 == null) {
                    obj6 = obj2;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("total_duration_ms", sessionElapsedMs);
                int i6 = i2;
                jSONObject.put("user_message_count", this.sessionUserMessageCount);
                jSONObject.put("bot_message_count", this.sessionBotMessageCount);
                jSONObject.put(str20, this.sessionUserCharCount);
                jSONObject.put(str19, this.sessionBotCharCount);
                jSONObject.put("avg_response_delay_ms", avgOrMissing3);
                jSONObject.put("max_response_delay_ms", maxOrMissing3);
                jSONObject.put(str3, avgOrMissing);
                jSONObject.put(str2, maxOrMissing);
                jSONObject.put("avg_last_char_on_screen_ms", avgOrMissing2);
                jSONObject.put(str18, maxOrMissing2);
                jSONObject.put(str16, avgOrMissing4);
                jSONObject.put(str14, maxOrMissing4);
                jSONObject.put("avg_user_subtitle_last_char_ms", avgOrMissing5);
                long j3 = j;
                jSONObject.put("max_user_subtitle_last_char_ms", j3);
                jSONObject.put("valid_round_count", arrayList2.size());
                jSONObject.put("total_round_count", size);
                jSONObject.put("interrupted_before_reply_count", i4);
                JSONObject commonCategory = VoiceDiscussionMetrics.INSTANCE.commonCategory(this._voiceCliType, this._voiceMode);
                commonCategory.put("end_type", endType);
                commonCategory.put("subtitle_enabled", this.sessionHasEverEnabledSubtitle ? "1" : "0");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("session_id", obj6);
                jSONObject2.put("room_id", roomId);
                VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker = this.voiceDiscussionAttemptTracker;
                Object attemptId = (voiceDiscussionAttemptTracker == null || (snapshot2 = voiceDiscussionAttemptTracker.snapshot()) == null) ? null : snapshot2.getAttemptId();
                if (attemptId == null) {
                    attemptId = obj2;
                }
                jSONObject2.put("attempt_id", attemptId);
                ApmService.INSTANCE.monitorEventForSlardar(EVENT_DISCUSSION_SESSION_PERF, commonCategory, jSONObject, jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                VoiceDiscussionMetrics.INSTANCE.putVoiceCommonParams(jSONObject3, this._voiceCliType, this._voiceMode);
                Object obj7 = this._cliConversationId;
                if (obj7 == null) {
                    obj7 = obj2;
                }
                jSONObject3.put("conversation_id", obj7);
                jSONObject3.put("room_id", roomId);
                VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker2 = this.voiceDiscussionAttemptTracker;
                if (voiceDiscussionAttemptTracker2 != null && (snapshot = voiceDiscussionAttemptTracker2.snapshot()) != null) {
                    obj = snapshot.getAttemptId();
                }
                jSONObject3.put("attempt_id", obj == null ? obj2 : obj);
                jSONObject3.put("end_type", endType);
                jSONObject3.put("total_duration_ms", sessionElapsedMs);
                jSONObject3.put("total_round_count", size);
                jSONObject3.put("valid_round_count", arrayList2.size());
                jSONObject3.put("interrupted_before_answering_count", i);
                jSONObject3.put("interrupted_before_first_char_count", i6);
                jSONObject3.put("interrupted_during_answering_count", i5);
                jSONObject3.put(str3, avgOrMissing);
                jSONObject3.put(str2, maxOrMissing);
                jSONObject3.put("avg_last_char_on_screen_ms", avgOrMissing2);
                jSONObject3.put(str18, maxOrMissing2);
                jSONObject3.put(str16, avgOrMissing4);
                jSONObject3.put(str14, maxOrMissing4);
                jSONObject3.put("avg_user_subtitle_last_char_ms", avgOrMissing5);
                jSONObject3.put("max_user_subtitle_last_char_ms", j3);
                jSONObject3.put("avg_server_thinking_ms", avgOrMissing3);
                jSONObject3.put("subtitle_enabled", this.sessionHasEverEnabledSubtitle ? "1" : "0");
                jSONObject3.put("is_new_session", this.perfIsNewSession ? "1" : "0");
                jSONObject3.put("user_message_count", this.sessionUserMessageCount);
                jSONObject3.put("bot_message_count", this.sessionBotMessageCount);
                jSONObject3.put(str20, this.sessionUserCharCount);
                jSONObject3.put(str19, this.sessionBotCharCount);
                IApplog.INSTANCE.reportEvent(EVENT_DISCUSSION_SESSION_END, jSONObject3);
                FLogger fLogger = FLogger.INSTANCE;
                StringBuilder sb = new StringBuilder();
                sb.append("reportDiscussionSessionPerf: endType=").append(endType).append(" total=").append(sessionElapsedMs).append("ms rounds=").append(size).append(" valid=").append(arrayList2.size()).append(" interruptBeforeReply=").append(i4).append(" duringAns=").append(i5).append(" avgFirstChar=").append(avgOrMissing).append("ms avgLastChar=").append(avgOrMissing2).append("ms userMsg=").append(this.sessionUserMessageCount).append(" userChar=").append(this.sessionUserCharCount).append(" botMsg=").append(this.sessionBotMessageCount).append(" botChar=");
                sb.append(this.sessionBotCharCount).append(" subtitle=").append(this.sessionHasEverEnabledSubtitle);
                String sb2 = sb.toString();
                str = TAG;
                try {
                    fLogger.d(str, sb2);
                } catch (Throwable th) {
                    th = th;
                    FLogger.INSTANCE.w(str, "reportDiscussionSessionPerf failed", th);
                }
            } catch (Throwable th2) {
                th = th2;
                str = TAG;
            }
        } catch (Throwable th3) {
            th = th3;
            str = TAG;
        }
    }

    public final BMVoiceChatSessionManager.Listener getVoiceChatListenerForHolder$conversation_mainlandRelease() {
        return this.voiceChatListener;
    }

    public final MinimizeResult minimize(String ownerConversationId) {
        if (((BrainstormUiState) this._uiState.getValue()).getPhase() != BrainstormPhase.Discussing) {
            return new MinimizeResult.Refused("Only allowed in Discussing phase");
        }
        if (this.voiceChatSession == null) {
            return new MinimizeResult.Refused("Voice session not ready");
        }
        stopSessionTimer();
        if (!BrainstormSessionHolder.INSTANCE.migrateFromViewModel$conversation_mainlandRelease(this, ownerConversationId)) {
            startSessionTimer();
            return new MinimizeResult.Refused("Holder migration failed");
        }
        this._minimizeRequested.tryEmit(Unit.INSTANCE);
        return MinimizeResult.Success.INSTANCE;
    }

    public final BMVoiceChatSessionManager detachVoiceSession$conversation_mainlandRelease() {
        BMVoiceChatSessionManager bMVoiceChatSessionManager = this.voiceChatSession;
        if (bMVoiceChatSessionManager != null) {
            bMVoiceChatSessionManager.setListener(null);
        }
        this.voiceChatSession = null;
        return bMVoiceChatSessionManager;
    }

    public final void attachVoiceSession$conversation_mainlandRelease(BMVoiceChatSessionManager session) {
        Intrinsics.checkNotNullParameter(session, "session");
        this.voiceChatSession = session;
        session.setListener(this.voiceChatListener);
    }

    /* renamed from: detachAudioDeviceManager$conversation_mainlandRelease, reason: from getter */
    public final AudioDeviceManager getAudioDeviceManager() {
        return this.audioDeviceManager;
    }

    public final void attachAudioDeviceManager$conversation_mainlandRelease(AudioDeviceManager mgr) {
        Intrinsics.checkNotNullParameter(mgr, "mgr");
        AudioDeviceManager audioDeviceManager = this.audioDeviceManager;
        if (audioDeviceManager != mgr) {
            audioDeviceManager.release();
        }
        this.audioDeviceManager = mgr;
        if (((BrainstormUiState) this._uiState.getValue()).getAiParticipantState() == ParticipantState.Speaking) {
            restartOutputVolumeMonitoring("attach_audio_device");
        }
    }

    public final ConversationDebugLogInfo buildDiscussionDebugLogInfo() {
        ConversationDebugLogInfo buildInfo;
        SubTaskRenderState state;
        BrainstormUiState brainstormUiState = (BrainstormUiState) this._uiState.getValue();
        SubTaskUiState subTaskUiState = (SubTaskUiState) VoiceSubTaskCoordinator.INSTANCE.getActiveTask().getValue();
        if (subTaskUiState == null && (subTaskUiState = brainstormUiState.getSubTask()) == null) {
            subTaskUiState = (SubTaskUiState) CollectionsKt.lastOrNull(brainstormUiState.getFinishedSubTasks().values());
        }
        String resolveVoiceDiscussionDebugSubTaskSessionId = BrainstormViewModelKt.resolveVoiceDiscussionDebugSubTaskSessionId(subTaskUiState, (String) VoiceSubTaskCoordinator.INSTANCE.getProxyChatSessionId().getValue());
        ConversationDebugInfoCopier conversationDebugInfoCopier = ConversationDebugInfoCopier.INSTANCE;
        long sessionStartTimeMs = brainstormUiState.getSessionStartTimeMs();
        String str = this._cliConversationId;
        String str2 = str == null ? "" : str;
        BMVoiceChatSessionManager bMVoiceChatSessionManager = this.voiceChatSession;
        String str3 = null;
        String roomId = bMVoiceChatSessionManager != null ? bMVoiceChatSessionManager.getRoomId() : null;
        String str4 = roomId == null ? "" : roomId;
        BMVoiceChatSessionManager bMVoiceChatSessionManager2 = this.voiceChatSession;
        String taskId = bMVoiceChatSessionManager2 != null ? bMVoiceChatSessionManager2.getTaskId() : null;
        String str5 = taskId == null ? "" : taskId;
        String str6 = (String) VoiceSubTaskCoordinator.INSTANCE.getParentConversationId().getValue();
        String str7 = str6 == null ? "" : str6;
        String sourceTaskId = subTaskUiState != null ? subTaskUiState.getSourceTaskId() : null;
        String str8 = sourceTaskId == null ? "" : sourceTaskId;
        String localTaskId = subTaskUiState != null ? subTaskUiState.getLocalTaskId() : null;
        String str9 = localTaskId == null ? "" : localTaskId;
        if (subTaskUiState != null && (state = subTaskUiState.getState()) != null) {
            str3 = state.name();
        }
        buildInfo = conversationDebugInfoCopier.buildInfo(sessionStartTimeMs, (r16 & 2) != 0 ? "" : null, (r16 & 4) != 0 ? "" : null, (r16 & 8) != 0 ? "" : str2, (r16 & 16) != 0 ? null : new VoiceDiscussionDebugLogInfo(str4, str5, resolveVoiceDiscussionDebugSubTaskSessionId, str7, str8, str9, str3 == null ? "" : str3));
        return buildInfo;
    }

    public final HolderSnapshot snapshot$conversation_mainlandRelease() {
        BrainstormUiState brainstormUiState = (BrainstormUiState) this._uiState.getValue();
        String str = this._cliConversationId;
        String str2 = (String) VoiceSubTaskCoordinator.INSTANCE.getParentConversationId().getValue();
        if (str2 == null) {
            str2 = this.parentConversationIdForVoice;
        }
        String str3 = str2;
        String str4 = this.originConversationId;
        CliType cliType = this._voiceCliType;
        Mode mode = this._voiceMode;
        boolean z = this.attachmentSubTaskEnabled;
        long j = this.perfMicCheckStartMs;
        long j2 = this.perfMicCheckEndMs;
        long j3 = this.perfApiRequestStartMs;
        long j4 = this.perfJoinRoomStartMs;
        long j5 = this.perfJoinRoomSuccessMs;
        long j6 = this.perfBotJoinedMs;
        boolean z2 = this.perfIsNewSession;
        boolean z3 = this.discussionStartPerfReported;
        int i = this.sessionUserMessageCount;
        int i2 = this.sessionBotMessageCount;
        List list = CollectionsKt.toList(this.sessionUserSpeakEndTimestamps);
        List list2 = CollectionsKt.toList(this.sessionBotSpeakStartTimestamps);
        boolean z4 = this.sessionHasEverEnabledSubtitle;
        VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker = this.voiceDiscussionAttemptTracker;
        return new HolderSnapshot(brainstormUiState, str, str3, str4, cliType, mode, z, j, j2, j3, j4, j5, j6, z2, z3, i, i2, list, list2, z4, voiceDiscussionAttemptTracker != null ? voiceDiscussionAttemptTracker.snapshot() : null);
    }

    public final void restore$conversation_mainlandRelease(HolderSnapshot snapshot) {
        BrainstormUiState copy;
        Intrinsics.checkNotNullParameter(snapshot, IFileDataCacheService.TYPE_SNAPSHOT);
        MutableStateFlow<BrainstormUiState> mutableStateFlow = this._uiState;
        copy = r3.copy((r42 & 1) != 0 ? r3.phase : null, (r42 & 2) != 0 ? r3.subtitleHistory : null, (r42 & 4) != 0 ? r3.recordingState : null, (r42 & 8) != 0 ? r3.aiReplyState : null, (r42 & 16) != 0 ? r3.aiParticipantState : null, (r42 & 32) != 0 ? r3.userParticipantState : null, (r42 & 64) != 0 ? r3.currentTranscript : null, (r42 & 128) != 0 ? r3.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r3.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r3.isSpeakerOn : false, (r42 & 1024) != 0 ? r3.isMicMuted : false, (r42 & 2048) != 0 ? r3.isSubtitleMode : false, (r42 & 4096) != 0 ? r3.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r3.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r3.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r3.timeoutState : null, (65536 & r42) != 0 ? r3.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r3.aiStageDescription : null, (r42 & 262144) != 0 ? r3.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r3.subTask : null, (r42 & 1048576) != 0 ? r3.finishedSubTasks : MapsKt.emptyMap(), (r42 & 2097152) != 0 ? snapshot.getUiState().attachments : null);
        mutableStateFlow.setValue(copy);
        this._cliConversationId = snapshot.getCliConversationId();
        this.originConversationId = snapshot.getOriginConversationId();
        this.parentConversationIdForVoice = snapshot.getParentConversationId();
        this._voiceCliType = snapshot.getVoiceCliType();
        this._voiceMode = snapshot.getVoiceMode();
        this.attachmentSubTaskEnabled = snapshot.getAttachmentSubTaskEnabled();
        this.perfMicCheckStartMs = snapshot.getPerfMicCheckStartMs();
        this.perfMicCheckEndMs = snapshot.getPerfMicCheckEndMs();
        this.perfApiRequestStartMs = snapshot.getPerfApiRequestStartMs();
        this.perfJoinRoomStartMs = snapshot.getPerfJoinRoomStartMs();
        this.perfJoinRoomSuccessMs = snapshot.getPerfJoinRoomSuccessMs();
        this.perfBotJoinedMs = snapshot.getPerfBotJoinedMs();
        this.perfIsNewSession = snapshot.getPerfIsNewSession();
        this.discussionStartPerfReported = snapshot.getDiscussionStartPerfReported();
        this.sessionUserMessageCount = snapshot.getSessionUserMessageCount();
        this.sessionBotMessageCount = snapshot.getSessionBotMessageCount();
        this.sessionUserSpeakEndTimestamps.clear();
        this.sessionUserSpeakEndTimestamps.addAll(snapshot.getSessionUserSpeakEndTimestamps());
        this.sessionBotSpeakStartTimestamps.clear();
        this.sessionBotSpeakStartTimestamps.addAll(snapshot.getSessionBotSpeakStartTimestamps());
        this.sessionHasEverEnabledSubtitle = snapshot.getSessionHasEverEnabledSubtitle();
        VoiceDiscussionAttemptState voiceDiscussionAttemptState = snapshot.getVoiceDiscussionAttemptState();
        this.voiceDiscussionAttemptTracker = voiceDiscussionAttemptState != null ? new VoiceDiscussionAttemptTracker(voiceDiscussionAttemptState, null, null, null, 14, null) : null;
        if (snapshot.getUiState().getPhase() == BrainstormPhase.Discussing && snapshot.getUiState().getTimeoutState() != TimeoutState.Expired) {
            startSessionTimer();
        }
        if (snapshot.getUiState().getAiParticipantState() == ParticipantState.Speaking) {
            restartOutputVolumeMonitoring("restore");
        }
    }

    private final long avgOrMissing(List<Long> list) {
        if (list.isEmpty()) {
            return -1L;
        }
        return CollectionsKt.sumOfLong(list) / list.size();
    }

    private final long maxOrMissing(List<Long> list) {
        Long l = (Long) CollectionsKt.maxOrNull(list);
        if (l != null) {
            return l.longValue();
        }
        return -1L;
    }

    protected void onCleared() {
        super.onCleared();
        stopSessionTimer();
        Job job = this.aiReplyJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.startRecordingJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.startRecordingJob = null;
        stopOutputVolumeMonitoring();
        cancelAllPendingUploads(false);
        this.attachmentManager.release();
        if (BrainstormSessionHolder.INSTANCE.isMinimized()) {
            return;
        }
        VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker = this.voiceDiscussionAttemptTracker;
        if (voiceDiscussionAttemptTracker != null) {
            voiceDiscussionAttemptTracker.finishInferred();
        }
        this.audioDeviceManager.release();
        BMVoiceChatSessionManager bMVoiceChatSessionManager = this.voiceChatSession;
        if (bMVoiceChatSessionManager != null) {
            bMVoiceChatSessionManager.release();
        }
        this.voiceChatSession = null;
        VoiceSubTaskCoordinator.INSTANCE.release(true, "view_model_cleared");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCjkChar(char ch) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(ch);
        return Intrinsics.areEqual(of, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || Intrinsics.areEqual(of, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || Intrinsics.areEqual(of, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || Intrinsics.areEqual(of, Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || Intrinsics.areEqual(of, Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || Intrinsics.areEqual(of, Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) || Intrinsics.areEqual(of, Character.UnicodeBlock.GENERAL_PUNCTUATION);
    }
}
