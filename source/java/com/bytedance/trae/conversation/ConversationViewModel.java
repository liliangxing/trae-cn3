package com.bytedance.trae.conversation;

import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.keva.Keva;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.brainstorm.BrainstormSummaryRepository;
import com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload;
import com.bytedance.trae.conversation.chat.block.VoiceSummaryPayloadParser;
import com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefStreamGuard;
import com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision;
import com.bytedance.trae.conversation.chat.error.AgentErrorCodeRegistry;
import com.bytedance.trae.conversation.devices.DeviceItem;
import com.bytedance.trae.conversation.devices.SelectedDeviceItem;
import com.bytedance.trae.conversation.git.GitRepoItem;
import com.bytedance.trae.conversation.git.GitSelectionViewModel;
import com.bytedance.trae.conversation.network.IRemoteModelsApi;
import com.bytedance.trae.conversation.network.ModelSelectionRepository;
import com.bytedance.trae.conversation.network.RemoteModelItem;
import com.bytedance.trae.conversation.network.TaskPinCapability;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.conversation.perf.VoiceSummaryRenderTracker;
import com.bytedance.trae.conversation.tracker.CancelTaskMonitor;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.conversation.upgrade.UpgradeReminderConfig;
import com.bytedance.trae.conversation.upgrade.UpgradeReminderDismissStore;
import com.bytedance.trae.conversation.upgrade.UpgradeReminderSettings;
import com.bytedance.trae.conversation.upgrade.UpgradeReminderUiState;
import com.bytedance.trae.conversation.voice.VoiceDiscussionMetrics;
import com.bytedance.trae.conversation.widget.ChatMode;
import com.bytedance.trae.im.database.ConversationDetailDao;
import com.bytedance.trae.im.database.DatabaseManager;
import com.bytedance.trae.im.model.ChatMessage;
import com.bytedance.trae.im.model.ChatMessageParser;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.model.MessagePartNormalizer;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedError;
import com.bytedance.trae.im.model.ParsedPlanItem;
import com.bytedance.trae.im.model.ParsedPlanItemMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.repository.ConversationDetailCacheRepository;
import com.bytedance.trae.im.service.Cli;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.CommonParams;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.im.service.ConversationFullDetailResponse;
import com.bytedance.trae.im.service.CreateTaskCheckRequest;
import com.bytedance.trae.im.service.CreateTaskCheckResponse;
import com.bytedance.trae.im.service.ICreateTaskCheck;
import com.bytedance.trae.im.service.IMService;
import com.bytedance.trae.im.service.ListMessagesResponse;
import com.bytedance.trae.im.service.Mode;
import com.bytedance.trae.im.service.PinConversationResponse;
import com.bytedance.trae.im.service.SummaryMessagePart;
import com.bytedance.trae.im.service.UserMessageContext;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
import com.bytedance.trae.multilanguage.I18nTextProvider;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.platform.service.ApmService;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.AbstractList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONObject;

/* compiled from: ConversationViewModel.kt */
@Metadata(d1 = {"\u0000\u0096\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u001e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0096\u00032\u00020\u0001:\u000e\u0091\u0003\u0092\u0003\u0093\u0003\u0094\u0003\u0095\u0003\u0096\u0003\u0097\u0003B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0014J\u0016\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020&0\u0010H\u0002J\u0017\u0010H\u001a\u00020\u00142\b\u0010I\u001a\u0004\u0018\u00010JH\u0002¢\u0006\u0002\u0010KJ\u001e\u0010¸\u0001\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u00142\r\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010J*\u0010Å\u0001\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000b\b\u0002\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0014J\u0013\u0010Ç\u0001\u001a\u00020*2\n\u0010È\u0001\u001a\u0005\u0018\u00010É\u0001J\u001f\u0010Ê\u0001\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u000f\u0010Ë\u0001\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u0014J\u001a\u0010Ì\u0001\u001a\u0004\u0018\u00010v2\u0006\u0010\u0015\u001a\u00020\u0014H\u0086@¢\u0006\u0003\u0010Í\u0001J\u001a\u0010Î\u0001\u001a\u0004\u0018\u00010v2\u0006\u0010\u0015\u001a\u00020\u0014H\u0082@¢\u0006\u0003\u0010Í\u0001J\t\u0010Ï\u0001\u001a\u00020*H\u0002J\t\u0010Ð\u0001\u001a\u00020*H\u0014J\u0019\u0010Ñ\u0001\u001a\u00020*2\u0007\u0010Ò\u0001\u001a\u00020&H\u0082@¢\u0006\u0003\u0010Ó\u0001J\u0012\u0010Ô\u0001\u001a\u00020\u001f2\u0007\u0010Ò\u0001\u001a\u00020&H\u0002J\u0013\u0010Õ\u0001\u001a\u00020*2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0011\u0010Ö\u0001\u001a\u00020v2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000f\u0010×\u0001\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\nJ\u0013\u0010Ø\u0001\u001a\u00020*2\b\u0010Ù\u0001\u001a\u00030\u0097\u0001H\u0002J\u0013\u0010Ú\u0001\u001a\u00020*2\b\u0010Û\u0001\u001a\u00030Ü\u0001H\u0002J\u0010\u0010Ý\u0001\u001a\u00020*2\u0007\u0010Þ\u0001\u001a\u00020vJ\u0017\u0010ß\u0001\u001a\u00020*2\u000e\u0010à\u0001\u001a\t\u0012\u0005\u0012\u00030á\u00010\u0010J\u0017\u0010â\u0001\u001a\u00020*2\u000e\u0010à\u0001\u001a\t\u0012\u0005\u0012\u00030á\u00010\u0010J\u0010\u0010ã\u0001\u001a\u00020*2\u0007\u0010ä\u0001\u001a\u00020zJ\u0012\u0010å\u0001\u001a\u00020*2\u0007\u0010Æ\u0001\u001a\u00020\u0014H\u0002JG\u0010æ\u0001\u001a\u000b\u0012\u0005\u0012\u00030ç\u0001\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00142\t\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00142\u0007\u0010è\u0001\u001a\u00020J2\u0007\u0010é\u0001\u001a\u00020J2\u0007\u0010ê\u0001\u001a\u00020\u001fH\u0082@¢\u0006\u0003\u0010ë\u0001Ju\u0010ì\u0001\u001a\u00030í\u00012\u0006\u0010\u0015\u001a\u00020\u00142\t\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00142\u0007\u0010è\u0001\u001a\u00020J2\u0007\u0010é\u0001\u001a\u00020J2\u0007\u0010ê\u0001\u001a\u00020\u001f21\b\u0002\u0010î\u0001\u001a*\b\u0001\u0012\u0005\u0012\u00030ð\u0001\u0012\u0013\u0012\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030ó\u00010ò\u00010ñ\u0001\u0012\u0007\u0012\u0005\u0018\u00010ô\u00010ï\u0001H\u0080@¢\u0006\u0006\bõ\u0001\u0010ö\u0001J>\u0010÷\u0001\u001a\t\u0012\u0005\u0012\u00030ð\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00142\t\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00142\u0007\u0010è\u0001\u001a\u00020J2\u0007\u0010é\u0001\u001a\u00020J2\u0007\u0010ê\u0001\u001a\u00020\u001fH\u0002J\u0015\u0010ø\u0001\u001a\u00020\u001f*\n\u0012\u0005\u0012\u00030ó\u00010ò\u0001H\u0002J!\u0010ù\u0001\u001a\u00020\u001f2\u0007\u0010ú\u0001\u001a\u00020J2\u0007\u0010û\u0001\u001a\u00020JH\u0000¢\u0006\u0003\bü\u0001J\u001a\u0010ý\u0001\u001a\u00020*2\b\u0010þ\u0001\u001a\u00030ÿ\u0001H\u0082@¢\u0006\u0003\u0010\u0080\u0002J\u0007\u0010\u0081\u0002\u001a\u00020\u001fJ\t\u0010\u0082\u0002\u001a\u00020*H\u0002J\u0011\u0010\u0083\u0002\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001b\u0010\u0084\u0002\u001a\u00020\u00142\b\u0010ä\u0001\u001a\u00030\u0099\u00012\b\u0010\u0085\u0002\u001a\u00030\u0097\u0001J\u000f\u0010\u0086\u0002\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u0014J\u0007\u0010\u0087\u0002\u001a\u00020*J\u000f\u0010\u0088\u0002\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u0014J\u0007\u0010\u0089\u0002\u001a\u00020*J\u0017\u0010\u008a\u0002\u001a\u00020*2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0010H\u0002J\t\u0010\u008b\u0002\u001a\u00020*H\u0002J\t\u0010\u008c\u0002\u001a\u00020\u001fH\u0002J\u0007\u0010\u008d\u0002\u001a\u00020*J\u0017\u0010\u008e\u0002\u001a\u00020*2\u000e\u0010\u008f\u0002\u001a\t\u0012\u0004\u0012\u00020*0\u0090\u0002J\u0019\u0010\u0091\u0002\u001a\u00020*2\u0010\b\u0002\u0010\u008f\u0002\u001a\t\u0012\u0004\u0012\u00020*0\u0090\u0002J\u001b\u0010\u0092\u0002\u001a\t\u0012\u0005\u0012\u00030ç\u00010\u0010*\t\u0012\u0005\u0012\u00030ç\u00010\u0010H\u0002J\u001a\u0010\u0093\u0002\u001a\b\u0012\u0004\u0012\u00020&0\u0010*\t\u0012\u0005\u0012\u00030ç\u00010\u0010H\u0002J-\u0010\u0094\u0002\u001a\b\u0012\u0004\u0012\u00020&0\u00102\r\u0010\u0095\u0002\u001a\b\u0012\u0004\u0012\u00020&0\u00102\r\u0010\u0096\u0002\u001a\b\u0012\u0004\u0012\u00020&0\u0010H\u0002J\u0018\u0010\u0097\u0002\u001a\u00020*2\r\u0010\u0096\u0002\u001a\b\u0012\u0004\u0012\u00020&0\u0010H\u0002J\u0018\u0010\u0098\u0002\u001a\u00020*2\r\u0010\u0099\u0002\u001a\b\u0012\u0004\u0012\u00020&0\u0010H\u0002J-\u0010\u009a\u0002\u001a\b\u0012\u0004\u0012\u00020&0\u00102\r\u0010\u0095\u0002\u001a\b\u0012\u0004\u0012\u00020&0\u00102\r\u0010\u0096\u0002\u001a\b\u0012\u0004\u0012\u00020&0\u0010H\u0002J\u0018\u0010\u009b\u0002\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u00142\u0007\u0010\u009c\u0002\u001a\u00020\u0014J\u001f\u0010\u009d\u0002\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140\u009e\u0002J#\u0010\u009f\u0002\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u00142\u0007\u0010\u009c\u0002\u001a\u00020\u00142\t\u0010 \u0002\u001a\u0004\u0018\u00010&J/\u0010¡\u0002\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u00142\r\u0010\u0095\u0002\u001a\b\u0012\u0004\u0012\u00020&0\u00102\r\u0010¢\u0002\u001a\b\u0012\u0004\u0012\u00020&0\u0010H\u0002J)\u0010£\u0002\u001a\u00020\u001f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00102\u0007\u0010Æ\u0001\u001a\u00020\u00142\u0007\u0010¤\u0002\u001a\u00020JH\u0002J)\u0010¥\u0002\u001a\u00020\u001f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00102\u0007\u0010Æ\u0001\u001a\u00020\u00142\u0007\u0010¤\u0002\u001a\u00020JH\u0002J\u0010\u0010¦\u0002\u001a\u00020*2\u0007\u0010§\u0002\u001a\u00020\u0014J\u0007\u0010¨\u0002\u001a\u00020*J\u000f\u0010©\u0002\u001a\u00020*2\u0006\u0010\u000b\u001a\u00020\nJ\u0007\u0010ª\u0002\u001a\u00020\u001fJ\u0007\u0010«\u0002\u001a\u00020*J\u0007\u0010¬\u0002\u001a\u00020*J\u0012\u0010\u00ad\u0002\u001a\u00020*2\u0007\u0010®\u0002\u001a\u00020\u001fH\u0002J&\u0010¯\u0002\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u00142\u0007\u0010®\u0002\u001a\u00020\u001f2\n\u0010°\u0002\u001a\u0005\u0018\u00010±\u0002H\u0002J\u0012\u0010²\u0002\u001a\u00020J2\u0007\u0010®\u0002\u001a\u00020\u001fH\u0002J\u0012\u0010³\u0002\u001a\u00020J2\u0007\u0010®\u0002\u001a\u00020\u001fH\u0002J\u0018\u0010´\u0002\u001a\u00020*2\u0007\u0010µ\u0002\u001a\u00020\u00142\u0006\u0010/\u001a\u00020&J0\u0010¶\u0002\u001a\u00020*2\u0007\u0010·\u0002\u001a\u00020\u00142\b\u0010ä\u0001\u001a\u00030\u0099\u00012\u0007\u0010¸\u0002\u001a\u00020\u00142\u000b\b\u0002\u0010¹\u0002\u001a\u0004\u0018\u00010\u0014J<\u0010º\u0002\u001a\u00020*2\u0007\u0010»\u0002\u001a\u00020\u00142\u0007\u0010¼\u0002\u001a\u00020\u00142\b\u0010ä\u0001\u001a\u00030\u0099\u00012\f\b\u0002\u0010½\u0002\u001a\u0005\u0018\u00010¾\u00022\t\b\u0002\u0010¿\u0002\u001a\u00020\u001fJl\u0010À\u0002\u001a\u00020*2\u0007\u0010»\u0002\u001a\u00020\u00142\u0007\u0010¼\u0002\u001a\u00020\u00142\b\u0010ä\u0001\u001a\u00030\u0099\u00012\u0007\u0010Á\u0002\u001a\u00020\u00142\f\b\u0002\u0010½\u0002\u001a\u0005\u0018\u00010¾\u00022\t\b\u0002\u0010¿\u0002\u001a\u00020\u001f2\u000b\b\u0002\u0010Â\u0002\u001a\u0004\u0018\u00010\u00142\u000b\b\u0002\u0010¸\u0002\u001a\u0004\u0018\u00010\u00142\u000b\b\u0002\u0010¹\u0002\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Ã\u0002\u001a\u00020v2\u0007\u0010Þ\u0001\u001a\u00020vH\u0002J\u000f\u0010Ä\u0002\u001a\u00030Å\u0002*\u00030¾\u0002H\u0002JC\u0010Æ\u0002\u001a\u00020\u001f2\u0007\u0010Ç\u0002\u001a\u00020F2\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\u00142\n\u0010È\u0002\u001a\u0005\u0018\u00010Å\u00022\u0007\u0010Þ\u0001\u001a\u00020v2\b\u0010ä\u0001\u001a\u00030\u0099\u0001H\u0082@¢\u0006\u0003\u0010É\u0002J0\u0010Ê\u0002\u001a\u00020\u001f2\u0007\u0010Ç\u0002\u001a\u00020F2\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\u00142\n\u0010È\u0002\u001a\u0005\u0018\u00010Å\u0002H\u0082@¢\u0006\u0003\u0010Ë\u0002J \u0010Ì\u0002\u001a\u00020*2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00102\u0007\u0010Í\u0002\u001a\u00020\u0014H\u0002J\u001b\u0010Î\u0002\u001a\u00020*2\u0007\u0010Ò\u0001\u001a\u00020&2\u0007\u0010Í\u0002\u001a\u00020\u0014H\u0002J\u001d\u0010Ï\u0002\u001a\u0004\u0018\u00010\u00142\u0007\u0010Ò\u0001\u001a\u00020&2\u0007\u0010Ç\u0002\u001a\u00020FH\u0002J\u001e\u0010Ð\u0002\u001a\u00020\u001f2\u0007\u0010Ç\u0002\u001a\u00020F2\n\u0010È\u0002\u001a\u0005\u0018\u00010Å\u0002H\u0002J,\u0010Ñ\u0002\u001a\u00020*2\u0007\u0010Þ\u0001\u001a\u00020v2\b\u0010ä\u0001\u001a\u00030\u0099\u00012\u0007\u0010Ò\u0002\u001a\u00020\u0014H\u0082@¢\u0006\u0003\u0010Ó\u0002J<\u0010Ô\u0002\u001a\u00020\u00142\u0007\u0010Ç\u0002\u001a\u00020F2\t\u0010Õ\u0002\u001a\u0004\u0018\u00010\u00142\n\u0010È\u0002\u001a\u0005\u0018\u00010Å\u00022\u0007\u0010Þ\u0001\u001a\u00020v2\b\u0010ä\u0001\u001a\u00030\u0099\u0001H\u0002J&\u0010Ö\u0002\u001a\u00020\u00142\b\u0010×\u0002\u001a\u00030Ø\u00022\u0007\u0010Þ\u0001\u001a\u00020v2\b\u0010ä\u0001\u001a\u00030\u0099\u0001H\u0002J\u0016\u0010Ù\u0002\u001a\u00020\u00142\u000b\b\u0002\u0010Ú\u0002\u001a\u0004\u0018\u00010\u0014H\u0002J\t\u0010Û\u0002\u001a\u00020*H\u0002J\"\u0010Ü\u0002\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\u0007\u0010Þ\u0001\u001a\u00020v2\b\u0010ä\u0001\u001a\u00030\u0099\u0001H\u0002J\"\u0010Ý\u0002\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\u0007\u0010Þ\u0001\u001a\u00020v2\b\u0010ä\u0001\u001a\u00030\u0099\u0001H\u0002J\t\u0010Þ\u0002\u001a\u00020\u001fH\u0002J\n\u0010ß\u0002\u001a\u00030\u0099\u0001H\u0002J\n\u0010à\u0002\u001a\u00030\u0099\u0001H\u0002J!\u0010á\u0002\u001a\u0004\u0018\u00010\u001f*\u0005\u0018\u00010Å\u00022\u0007\u0010â\u0002\u001a\u00020\u0014H\u0002¢\u0006\u0003\u0010ã\u0002J\u001b\u0010ä\u0002\u001a\u0004\u0018\u00010\u0014*\u0005\u0018\u00010Å\u00022\u0007\u0010â\u0002\u001a\u00020\u0014H\u0002J<\u0010å\u0002\u001a\u00020*2\u0007\u0010Þ\u0001\u001a\u00020v2\b\u0010ä\u0001\u001a\u00030\u0099\u00012\t\u0010æ\u0002\u001a\u0004\u0018\u00010\u00142\u0007\u0010Á\u0002\u001a\u00020\u00142\n\u0010½\u0002\u001a\u0005\u0018\u00010¾\u0002H\u0002J#\u0010ç\u0002\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\b\u0010\u0085\u0002\u001a\u00030\u0097\u00012\b\u0010ä\u0001\u001a\u00030\u0099\u0001H\u0002J\u0012\u0010è\u0002\u001a\u00020*2\u0007\u0010é\u0002\u001a\u00020\u001fH\u0002J\u0012\u0010ê\u0002\u001a\u00020*2\u0007\u0010é\u0002\u001a\u00020\u001fH\u0002J\u0012\u0010ë\u0002\u001a\u00020*2\u0007\u0010é\u0002\u001a\u00020\u001fH\u0002J\u0012\u0010ì\u0002\u001a\u00020J2\u0007\u0010Ò\u0001\u001a\u00020&H\u0002J\u0013\u0010í\u0002\u001a\u00020\u00142\b\u0010î\u0002\u001a\u00030ï\u0002H\u0002J\u0007\u0010ó\u0002\u001a\u00020*J\u001c\u0010ô\u0002\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u00142\t\u0010õ\u0002\u001a\u0004\u0018\u00010\u0014H\u0002J\u0007\u0010ö\u0002\u001a\u00020*J\u0011\u0010÷\u0002\u001a\u00020*2\b\u0010ø\u0002\u001a\u00030ù\u0002J&\u0010ú\u0002\u001a\u00020*2\b\u0010ø\u0002\u001a\u00030ù\u00022\u0007\u0010û\u0002\u001a\u00020\u00142\b\u0010þ\u0001\u001a\u00030ÿ\u0001H\u0002J\u0014\u0010ü\u0002\u001a\u0004\u0018\u00010\u00142\t\u0010ý\u0002\u001a\u0004\u0018\u00010\u0014J\u0014\u0010þ\u0002\u001a\u0004\u0018\u00010\u00142\t\u0010ÿ\u0002\u001a\u0004\u0018\u00010\u0014J<\u0010\u0080\u0003\u001a\u00020*2\u0007\u0010\u0081\u0003\u001a\u00020\u00142\u0011\b\u0002\u0010\u0082\u0003\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00102\f\b\u0002\u0010½\u0002\u001a\u0005\u0018\u00010¾\u00022\t\b\u0002\u0010¿\u0002\u001a\u00020\u001fJ\u0018\u0010\u0083\u0003\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u00142\u0007\u0010\u0084\u0003\u001a\u00020\u0014J\n\u0010\u0085\u0003\u001a\u00030\u0086\u0003H\u0002J\u0017\u0010\u0087\u0003\u001a\u0004\u0018\u00010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0010JO\u0010\u0088\u0003\u001a\u0004\u0018\u00010&2\u0006\u0010\u0015\u001a\u00020\u00142\u0007\u0010\u009c\u0002\u001a\u00020\u00142\n\u0010\u0089\u0003\u001a\u0005\u0018\u00010ï\u00022\t\u0010\u008a\u0003\u001a\u0004\u0018\u00010J2\t\u0010\u008b\u0003\u001a\u0004\u0018\u00010F2\t\b\u0002\u0010\u008c\u0003\u001a\u00020\u001fH\u0002¢\u0006\u0003\u0010\u008d\u0003J\u0015\u0010\u008e\u0003\u001a\u0004\u0018\u00010\u00142\b\u0010\u008f\u0003\u001a\u00030\u0090\u0003H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00100\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u001a\u001a&\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00140\u0014 \u001b*\u0012\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00140\u0014\u0018\u00010\u001c0\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00100\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000eR\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020&0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020&00¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040\f¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u000eR\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010:\u001a\u0004\u0018\u00010&2\b\u0010+\u001a\u0004\u0018\u00010&@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020&0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020&00¢\u0006\b\n\u0000\u001a\u0004\b?\u00102R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010N\u001a\b\u0012\u0004\u0012\u00020J0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020J00¢\u0006\b\n\u0000\u001a\u0004\bP\u00102R\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00140.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001400¢\u0006\b\n\u0000\u001a\u0004\bS\u00102R\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00140.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001400¢\u0006\b\n\u0000\u001a\u0004\bV\u00102R\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00140.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001400¢\u0006\b\n\u0000\u001a\u0004\bY\u00102R\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020*0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020*00¢\u0006\b\n\u0000\u001a\u0004\b\\\u00102R\"\u0010]\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010&0^0.X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010_\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010&0^00¢\u0006\b\n\u0000\u001a\u0004\b`\u00102R\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020\u001f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001f0\f¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\u000eR\u001a\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00100.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u001000¢\u0006\b\n\u0000\u001a\u0004\be\u00102R\u0014\u0010f\u001a\b\u0012\u0004\u0012\u00020\n0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020\n00¢\u0006\b\n\u0000\u001a\u0004\bh\u00102R\u0014\u0010i\u001a\b\u0012\u0004\u0012\u00020*0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010j\u001a\b\u0012\u0004\u0012\u00020*00¢\u0006\b\n\u0000\u001a\u0004\bk\u00102R\u0014\u0010l\u001a\b\u0012\u0004\u0012\u00020*0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020*00¢\u0006\b\n\u0000\u001a\u0004\bn\u00102R\u0014\u0010o\u001a\b\u0012\u0004\u0012\u00020*0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010p\u001a\b\u0012\u0004\u0012\u00020*00¢\u0006\b\n\u0000\u001a\u0004\bq\u00102R\u0014\u0010r\u001a\b\u0012\u0004\u0012\u00020\u001f0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010s\u001a\b\u0012\u0004\u0012\u00020\u001f00¢\u0006\b\n\u0000\u001a\u0004\bt\u00102R\u0016\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010v0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010v0\f¢\u0006\b\n\u0000\u001a\u0004\bx\u0010\u000eR\u0014\u0010y\u001a\b\u0012\u0004\u0012\u00020z0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010{\u001a\b\u0012\u0004\u0012\u00020z0\f¢\u0006\b\n\u0000\u001a\u0004\b|\u0010\u000eR\u000e\u0010}\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\f¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u000eR\u0015\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010\f¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010\u000eR\u0015\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\f¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u000eR\u0015\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020&0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020&00¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u00102R\u0015\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0092\u0001\u001a\u00020\u001fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010 \"\u0005\b\u0093\u0001\u0010\"R\u000f\u0010\u0094\u0001\u001a\u00020FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0095\u0001\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0096\u0001\u001a\u00030\u0097\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0098\u0001\u001a\u00030\u0099\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0001\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0001\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0001\u001a\u00020FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0001\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0001\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0001\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u0001\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010¡\u0001\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R\"\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R!\u0010¬\u0001\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u00ad\u0001\u0010£\u0001\"\u0006\b®\u0001\u0010¥\u0001R!\u0010¯\u0001\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b°\u0001\u0010£\u0001\"\u0006\b±\u0001\u0010¥\u0001R!\u0010²\u0001\u001a\u00030³\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¶\u0001\u0010·\u0001\u001a\u0006\b´\u0001\u0010µ\u0001R\u0010\u0010º\u0001\u001a\u00030»\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u00020*0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010½\u0001\u001a\b\u0012\u0004\u0012\u00020*00¢\u0006\t\n\u0000\u001a\u0005\b¾\u0001\u00102R\u0010\u0010¿\u0001\u001a\u00030À\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Á\u0001\u001a\u00030Â\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ã\u0001\u001a\u00030Ä\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010ð\u0002\u001a\b\u0012\u0004\u0012\u00020\u001f0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010ñ\u0002\u001a\b\u0012\u0004\u0012\u00020\u001f00¢\u0006\t\n\u0000\u001a\u0005\bò\u0002\u00102¨\u0006\u0098\u0003"}, d2 = {"Lcom/bytedance/trae/conversation/ConversationViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "_conversation", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/trae/im/service/Conversation;", "conversation", "Lkotlinx/coroutines/flow/StateFlow;", "getConversation", "()Lkotlinx/coroutines/flow/StateFlow;", "_conversations", "", "conversations", "getConversations", "_conversationId", "", "conversationId", "getConversationId", "_currentTaskId", "_shownCheckpointToolCallIds", "", "handledModelFallbackErrorKeys", "kotlin.jvm.PlatformType", "", "Ljava/util/Set;", "isTaskRunning", "", "()Z", "setTaskRunning", "(Z)V", "shouldShowCheckpoint", "toolCallId", "_messages", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "messages", "getMessages", "setMessages", "", "value", "runtimeMessageIds", "_newMessage", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "newMessage", "Lkotlinx/coroutines/flow/SharedFlow;", "getNewMessage", "()Lkotlinx/coroutines/flow/SharedFlow;", "_upgradeReminder", "Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUiState;", "upgradeReminder", "getUpgradeReminder", "pendingUpgradeReminderRefresh", "Lcom/bytedance/trae/conversation/ConversationViewModel$PendingUpgradeReminderRefresh;", "isMessageListCommitPendingForUpgradeReminder", "lastDoneMessage", "getLastDoneMessage", "()Lcom/bytedance/trae/im/model/ParsedChatMessage;", "_throttledStreamingMessage", "streamingMessage", "getStreamingMessage", "streamingThrottleMutex", "Lkotlinx/coroutines/sync/Mutex;", "pendingStreamingMessage", "streamingTrailingJob", "Lkotlinx/coroutines/Job;", "lastStreamingEmitTime", "", "createTaskJob", "buildParallelLimitMessage", "limit", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "isUserMessagePending", "bufferedAgentMessage", "_toastMessage", "toastMessage", "getToastMessage", "_toastText", "toastText", "getToastText", "_contentSecurityToastText", "contentSecurityToastText", "getContentSecurityToastText", "_renameSuccess", "renameSuccess", "getRenameSuccess", "_deleteSuccess", "deleteSuccess", "getDeleteSuccess", "_sendMessageSuccess", "Lkotlin/Pair;", "sendMessageSuccess", "getSendMessageSuccess", "_isAnchorWindowLoading", "isAnchorWindowLoading", "_refreshedMessages", "refreshedMessages", "getRefreshedMessages", "_createTask", "createTask", "getCreateTask", "_createTaskFailed", "createTaskFailed", "getCreateTaskFailed", "_modelSelectionResetToAuto", "modelSelectionResetToAuto", "getModelSelectionResetToAuto", "_forceLogout", "forceLogout", "getForceLogout", "_streamingStarted", "streamingStarted", "getStreamingStarted", "_selectedDevice", "Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "selectedDevice", "getSelectedDevice", "_currentMode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "currentMode", "getCurrentMode", "isAnchorWindowMode", "hasMoreNewerAnchorMessages", "isLoadingNewerAnchorMessages", "latestPrefetchMessages", "Lcom/bytedance/trae/conversation/ConversationViewModel$LatestPrefetchMessages;", "_hasMoreMessages", "hasMoreMessages", "getHasMoreMessages", "_isLoadingMore", "_sessionTurnStatus", "Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;", "sessionTurnStatus", "getSessionTurnStatus", "_loadError", "loadError", "getLoadError", "_remoteUserMessage", "remoteUserMessage", "getRemoteUserMessage", "remoteUserMessageIds", "isInited", "isNewConversation", "setNewConversation", "summaryStartTimestamp", "summarySessionId", "summaryCliType", "Lcom/bytedance/trae/im/service/CliType;", "summaryMode", "Lcom/bytedance/trae/im/service/Mode;", "summaryIsNewSession", "isSummaryTracking", "summaryDataFirstCharTimestamp", "summaryCharCount", "summaryReportSubmitted", "pendingSummaryIsSuccess", "summaryReportTimeoutJob", "selectedRepoUrl", "getSelectedRepoUrl", "()Ljava/lang/String;", "setSelectedRepoUrl", "(Ljava/lang/String;)V", "selectedRepo", "Lcom/bytedance/trae/conversation/git/GitRepoItem;", "getSelectedRepo", "()Lcom/bytedance/trae/conversation/git/GitRepoItem;", "setSelectedRepo", "(Lcom/bytedance/trae/conversation/git/GitRepoItem;)V", "selectedRepoName", "getSelectedRepoName", "setSelectedRepoName", "selectedBranchName", "getSelectedBranchName", "setSelectedBranchName", "cacheRepository", "Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;", "getCacheRepository", "()Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;", "cacheRepository$delegate", "Lkotlin/Lazy;", "deleteCachedMessages", "messageIds", "streamingMessageListener", "Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;", "_taskDone", "taskDone", "getTaskDone", "doneListener", "Lcom/bytedance/trae/im/service/IMService$DoneListener;", "remoteUserMessageListener", "Lcom/bytedance/trae/im/service/IMService$RemoteUserMessageListener;", "metadataDoneListener", "Lcom/bytedance/trae/im/service/IMService$MetadataDoneListener;", "init", "anchorCreatedAtMs", "onConversationFullDetailLoaded", "detail", "Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;", "resolveInitialConversation", "createTaskCheck", "checkIdeProjectForSkills", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performCreateTaskCheck", "recoverStreamingMessages", "onCleared", "emitStreamingThrottled", "message", "(Lcom/bytedance/trae/im/model/ParsedChatMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processTraeRefInSummary", "initSelectedDevice", "buildSelectedDeviceFromConversation", "shouldCheckIdeProject", "updateConversationEnvironment", DBData.FIELD_TYPE, "applyCreateTaskCheckResult", "response", "Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;", "setSelectedDevice", "device", "syncCodeSelectedDeviceWithItems", "items", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "syncSelectedDeviceWithItems", "setMode", "mode", "loadAnchorWindow", "loadAnchorMessagesByCreatedAt", "Lcom/bytedance/trae/im/model/ChatMessage;", "beforeLimit", "afterLimit", "includeAnchor", "(Ljava/lang/String;Ljava/lang/String;IIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadMessagesByAnchorRawWithLargeFileRetry", "Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;", "loader", "Lkotlin/Function2;", "Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/ListMessagesResponse;", "", "loadMessagesByAnchorRawWithLargeFileRetry$conversation_mainlandRelease", "(Ljava/lang/String;Ljava/lang/String;IIZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildListMessagesLargeFileRetryRequests", "isDownloadFileTooLargeBizError", "hasMoreHistoryPage", "messageCount", "pageLimit", "hasMoreHistoryPage$conversation_mainlandRelease", "handleAnchorLoadError", "result", "Lcom/bytedance/trae/network/response/HttpDataResult$Error;", "(Lcom/bytedance/trae/network/response/HttpDataResult$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exitAnchorWindowAndLoadLatest", "resetAnchorWindowState", "prefetchLatestMessages", "resolveParentAgentTypeForSubTask", "cliType", "loadMessages", "retryLoad", "dismissUpgradeReminder", "onMessageListCommitComplete", "updateUpgradeReminder", "flushPendingUpgradeReminderIfAllowed", "shouldDeferUpgradeReminder", "refreshMessagesOnResume", "loadMoreMessages", "onComplete", "Lkotlin/Function0;", "loadNewerAnchorMessages", "filterDisplayableMessages", "toParsedHistoryMessages", "mergeMessages", "currentMessages", "newMessages", "upsertMessages", "replaceMessagesPreservingRuntime", "historyMessages", "mergeMessagesIntoState", "deleteMessageAndReplies", "messageId", "deleteMessagesAndReplies", "", "revertMessageAndFollowingUsers", "revertedMessage", "updateMessagesAfterDeletion", "filteredMessages", "hasLoadedOlderSide", "expectedCount", "hasLoadedNewerSide", "renameConversation", "newTitle", "deleteConversation", "updateConversation", "supportsPin", "pinConversation", "unpinConversation", "performPinAction", "shouldPin", "applyPinSuccess", "data", "Lcom/bytedance/trae/im/service/PinConversationResponse;", "pinFailureString", "pinSuccessString", "onUserMessageFixup", "oldMessageId", "handleBrainstormResult", "messagesText", "cliConversationId", "targetConversationId", "sendMessage", "text", "query", "selectedModel", "Lcom/bytedance/trae/conversation/network/RemoteModelItem;", "useFastRequest", "sendMessageIternal", "agentType", "selectedModelName", "recoverHistoricalIdeProjectDevice", "toCreateTaskCustomModel", "Lcom/google/gson/JsonObject;", "handleModelUnavailableCreateTaskErrorIfNeeded", "code", "errorData", "(JLjava/lang/String;Lcom/google/gson/JsonObject;Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;Lcom/bytedance/trae/im/service/Mode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleCreateTaskErrorWithoutModelFallbackIfNeeded", "(JLjava/lang/String;Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleModelUnavailableLoadedMessagesIfNeeded", TimonPipeline.KEY_SOURCE, "handleModelUnavailableMessageErrorIfNeeded", "modelFallbackErrorKey", "shouldSwitchToAutoForModelError", "switchSelectedModelToAuto", "reason", "(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;Lcom/bytedance/trae/im/service/Mode;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildModelUnavailableMessage", "originMessage", "buildInternalUsageLimitMessage", "resources", "Landroid/content/res/Resources;", "contentSecurityBlockedText", "ruleName", "saveSelectedRepo", "internalUsageLimitModelNames", "modelListFunctions", "isInternalUser", "currentTaskMode", "currentConversationMode", "readBoolean", "key", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "readString", "cacheTaskModelSelection", "sessionId", "resolveModelListFunctions", "armSummaryPerfReport", "isSuccess", "submitSummaryPerfReport", "reportDiscussionSummaryPerf", "extractSummaryCharCount", "extractVoiceSummaryText", "summaryElement", "Lcom/google/gson/JsonElement;", "_cancelTaskResult", "cancelTaskResult", "getCancelTaskResult", "cancelCurrentTask", "notifyTaskListStatusChanged", "messageStatus", "handleCliDisconnected", "handleCheckpointDecision", "decision", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;", "reportCheckpointConfirmTaskError", "decisionStr", "parseGitDisplayName", "gitUri", "parseWorkspaceDisplayName", MessagePart.TYPE_WORKSPACE, "retryMessage", "assistantMessageId", "allMessages", "fetchEventsIfNeeded", "taskId", "getKeva", "Lcom/bytedance/keva/Keva;", "getLatestUnpairedUserMessage", "buildRemoteUserMessage", ReportConstant.COMMON_CONTENT, "messageIndex", "createdAt", "isAppendMessage", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Ljava/lang/Integer;Ljava/lang/Long;Z)Lcom/bytedance/trae/im/model/ParsedChatMessage;", "extractQueryFromUserMessageContext", "ctx", "Lcom/bytedance/trae/im/service/UserMessageContext;", "SessionTurnStatus", "ListMessagesByAnchorRequest", "ListMessagesByAnchorRetryResult", "MsgList", "PendingUpgradeReminderRefresh", "Companion", "LatestPrefetchMessages", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel extends ViewModel {
    private static final String AGENT_FLOW_TAG = "AgentDataFlow";
    private static final int ANCHOR_WINDOW_HAS_MORE_SIDE_THRESHOLD = 4;
    private static final long CODE_APPEND_NOT_ALLOWED = 991208;
    public static final long CODE_DEVICE_OFFLINE = 2900101;
    public static final long CODE_IDE_DEVICE_OFFLINE = 2900105;
    private static final long CODE_INSUFFICIENT_RESOURCES = 991209;
    private static final long CODE_INTERNAL_USAGE_LIMIT = 4008;
    private static final long CODE_INVALID_ARGS = 4001;
    private static final long CODE_MODEL_NOT_EXISTED = 4023;
    private static final long CODE_MODEL_OVERLOADED = 4050;
    private static final long CODE_PARALLEL_LIMIT = 991502;
    private static final long CODE_PIN_VERSION_INCOMPATIBLE = 2900104;
    private static final long CODE_REPO_LEVEL_RESTRICTED = 4037;
    private static final long CODE_RISK_CONTROL_LOGOUT = 40141;
    private static final long CODE_RISK_CONTROL_LOGOUT_2 = 4010;
    private static final long CODE_RISK_CONTROL_REJECTED = 40142;
    private static final long CODE_SERVER_ERROR = 500;
    private static final int DEFAULT_PARALLEL_LIMIT = 2;
    private static final String DOWNLOAD_FILE_TOO_LARGE_MESSAGE = "Download file too large";
    private static final String EVENT_CHECKPOINT_CONFIRM_TASK_ERROR = "checkpoint_confirm_task_error";
    private static final String EVENT_DISCUSSION_SUMMARY_END = "voice_discussion_summary_end";
    private static final String EVENT_DISCUSSION_SUMMARY_PERF = "voice_discussion_summary_perf";
    private static final long PERF_MISSING_VALUE = -1;
    private static final long PERF_REPORT_RENDER_TIMEOUT_MS = 800;
    private static final long STREAMING_THROTTLE_MS = 50;
    private static final String TAG = "ConversationViewModel";
    private final MutableSharedFlow<Boolean> _cancelTaskResult;
    private final MutableSharedFlow<String> _contentSecurityToastText;
    private final MutableStateFlow<Conversation> _conversation;
    private final MutableStateFlow<String> _conversationId;
    private final MutableStateFlow<List<Conversation>> _conversations;
    private final MutableSharedFlow<Conversation> _createTask;
    private final MutableSharedFlow<Unit> _createTaskFailed;
    private final MutableStateFlow<ChatMode> _currentMode;
    private String _currentTaskId;
    private final MutableSharedFlow<Unit> _deleteSuccess;
    private final MutableSharedFlow<Unit> _forceLogout;
    private final MutableStateFlow<Boolean> _hasMoreMessages;
    private final MutableStateFlow<Boolean> _isAnchorWindowLoading;
    private final MutableStateFlow<Boolean> _isLoadingMore;
    private final MutableStateFlow<Boolean> _loadError;
    private final MutableStateFlow<List<ParsedChatMessage>> _messages;
    private final MutableSharedFlow<Unit> _modelSelectionResetToAuto;
    private final MutableSharedFlow<ParsedChatMessage> _newMessage;
    private final MutableSharedFlow<List<ParsedChatMessage>> _refreshedMessages;
    private final MutableSharedFlow<ParsedChatMessage> _remoteUserMessage;
    private final MutableSharedFlow<String> _renameSuccess;
    private final MutableStateFlow<SelectedDeviceItem> _selectedDevice;
    private final MutableSharedFlow<Pair<ParsedChatMessage, ParsedChatMessage>> _sendMessageSuccess;
    private final MutableStateFlow<SessionTurnStatus> _sessionTurnStatus;
    private final Set<String> _shownCheckpointToolCallIds;
    private final MutableSharedFlow<Boolean> _streamingStarted;
    private final MutableSharedFlow<Unit> _taskDone;
    private final MutableSharedFlow<ParsedChatMessage> _throttledStreamingMessage;
    private final MutableSharedFlow<Integer> _toastMessage;
    private final MutableSharedFlow<String> _toastText;
    private final MutableStateFlow<UpgradeReminderUiState> _upgradeReminder;
    private ParsedChatMessage bufferedAgentMessage;

    /* renamed from: cacheRepository$delegate, reason: from kotlin metadata */
    private final Lazy cacheRepository;
    private final SharedFlow<Boolean> cancelTaskResult;
    private final SharedFlow<String> contentSecurityToastText;
    private final StateFlow<Conversation> conversation;
    private final StateFlow<String> conversationId;
    private final StateFlow<List<Conversation>> conversations;
    private final SharedFlow<Conversation> createTask;
    private final SharedFlow<Unit> createTaskFailed;
    private Job createTaskJob;
    private final StateFlow<ChatMode> currentMode;
    private final SharedFlow<Unit> deleteSuccess;
    private final IMService.DoneListener doneListener;
    private final SharedFlow<Unit> forceLogout;
    private final Gson gson = new Gson();
    private final Set<String> handledModelFallbackErrorKeys;
    private final StateFlow<Boolean> hasMoreMessages;
    private boolean hasMoreNewerAnchorMessages;
    private final StateFlow<Boolean> isAnchorWindowLoading;
    private boolean isAnchorWindowMode;
    private boolean isInited;
    private boolean isLoadingNewerAnchorMessages;
    private boolean isMessageListCommitPendingForUpgradeReminder;
    private boolean isNewConversation;
    private boolean isSummaryTracking;
    private boolean isTaskRunning;
    private volatile boolean isUserMessagePending;
    private ParsedChatMessage lastDoneMessage;
    private long lastStreamingEmitTime;
    private LatestPrefetchMessages latestPrefetchMessages;
    private final StateFlow<Boolean> loadError;
    private final StateFlow<List<ParsedChatMessage>> messages;
    private final IMService.MetadataDoneListener metadataDoneListener;
    private final SharedFlow<Unit> modelSelectionResetToAuto;
    private final SharedFlow<ParsedChatMessage> newMessage;
    private ParsedChatMessage pendingStreamingMessage;
    private volatile boolean pendingSummaryIsSuccess;
    private PendingUpgradeReminderRefresh pendingUpgradeReminderRefresh;
    private final SharedFlow<List<ParsedChatMessage>> refreshedMessages;
    private final SharedFlow<ParsedChatMessage> remoteUserMessage;
    private final Set<String> remoteUserMessageIds;
    private final IMService.RemoteUserMessageListener remoteUserMessageListener;
    private final SharedFlow<String> renameSuccess;
    private final Set<String> runtimeMessageIds;
    private String selectedBranchName;
    private final StateFlow<SelectedDeviceItem> selectedDevice;
    private GitRepoItem selectedRepo;
    private String selectedRepoName;
    private String selectedRepoUrl;
    private final SharedFlow<Pair<ParsedChatMessage, ParsedChatMessage>> sendMessageSuccess;
    private final StateFlow<SessionTurnStatus> sessionTurnStatus;
    private final SharedFlow<ParsedChatMessage> streamingMessage;
    private final IMService.StreamingMessageListener streamingMessageListener;
    private final SharedFlow<Boolean> streamingStarted;
    private final Mutex streamingThrottleMutex;
    private Job streamingTrailingJob;
    private int summaryCharCount;
    private CliType summaryCliType;
    private long summaryDataFirstCharTimestamp;
    private boolean summaryIsNewSession;
    private Mode summaryMode;
    private volatile boolean summaryReportSubmitted;
    private Job summaryReportTimeoutJob;
    private String summarySessionId;
    private long summaryStartTimestamp;
    private final SharedFlow<Unit> taskDone;
    private final SharedFlow<Integer> toastMessage;
    private final SharedFlow<String> toastText;
    private final StateFlow<UpgradeReminderUiState> upgradeReminder;
    private static final Set<String> SUMMARY_FINISH_TOOLS = SetsKt.setOf(new String[]{"finish", "Finish", "agent_finish", "AgentFinish", "response_to_user", "ResponseToUser", "Task"});

    public final boolean hasMoreHistoryPage$conversation_mainlandRelease(int messageCount, int pageLimit) {
        return pageLimit > 0 && messageCount >= pageLimit;
    }

    public ConversationViewModel() {
        MutableStateFlow<Conversation> MutableStateFlow = StateFlowKt.MutableStateFlow((Object) null);
        this._conversation = MutableStateFlow;
        this.conversation = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<List<Conversation>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._conversations = MutableStateFlow2;
        this.conversations = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow((Object) null);
        this._conversationId = MutableStateFlow3;
        this.conversationId = FlowKt.asStateFlow(MutableStateFlow3);
        this._shownCheckpointToolCallIds = new LinkedHashSet();
        this.handledModelFallbackErrorKeys = Collections.newSetFromMap(new ConcurrentHashMap());
        MutableStateFlow<List<ParsedChatMessage>> MutableStateFlow4 = StateFlowKt.MutableStateFlow(new MsgList(CollectionsKt.emptyList()));
        this._messages = MutableStateFlow4;
        this.messages = FlowKt.asStateFlow(MutableStateFlow4);
        this.runtimeMessageIds = new LinkedHashSet();
        MutableSharedFlow<ParsedChatMessage> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._newMessage = MutableSharedFlow$default;
        this.newMessage = FlowKt.asSharedFlow(MutableSharedFlow$default);
        MutableStateFlow<UpgradeReminderUiState> MutableStateFlow5 = StateFlowKt.MutableStateFlow((Object) null);
        this._upgradeReminder = MutableStateFlow5;
        this.upgradeReminder = FlowKt.asStateFlow(MutableStateFlow5);
        MutableSharedFlow<ParsedChatMessage> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 1, BufferOverflow.DROP_OLDEST, 1, (Object) null);
        this._throttledStreamingMessage = MutableSharedFlow$default2;
        this.streamingMessage = FlowKt.asSharedFlow(MutableSharedFlow$default2);
        this.streamingThrottleMutex = MutexKt.Mutex$default(false, 1, (Object) null);
        MutableSharedFlow<Integer> MutableSharedFlow$default3 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._toastMessage = MutableSharedFlow$default3;
        this.toastMessage = FlowKt.asSharedFlow(MutableSharedFlow$default3);
        MutableSharedFlow<String> MutableSharedFlow$default4 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._toastText = MutableSharedFlow$default4;
        this.toastText = FlowKt.asSharedFlow(MutableSharedFlow$default4);
        MutableSharedFlow<String> MutableSharedFlow$default5 = SharedFlowKt.MutableSharedFlow$default(0, 1, BufferOverflow.DROP_OLDEST, 1, (Object) null);
        this._contentSecurityToastText = MutableSharedFlow$default5;
        this.contentSecurityToastText = FlowKt.asSharedFlow(MutableSharedFlow$default5);
        MutableSharedFlow<String> MutableSharedFlow$default6 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._renameSuccess = MutableSharedFlow$default6;
        this.renameSuccess = FlowKt.asSharedFlow(MutableSharedFlow$default6);
        MutableSharedFlow<Unit> MutableSharedFlow$default7 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._deleteSuccess = MutableSharedFlow$default7;
        this.deleteSuccess = FlowKt.asSharedFlow(MutableSharedFlow$default7);
        MutableSharedFlow<Pair<ParsedChatMessage, ParsedChatMessage>> MutableSharedFlow$default8 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._sendMessageSuccess = MutableSharedFlow$default8;
        this.sendMessageSuccess = FlowKt.asSharedFlow(MutableSharedFlow$default8);
        MutableStateFlow<Boolean> MutableStateFlow6 = StateFlowKt.MutableStateFlow(false);
        this._isAnchorWindowLoading = MutableStateFlow6;
        this.isAnchorWindowLoading = FlowKt.asStateFlow(MutableStateFlow6);
        MutableSharedFlow<List<ParsedChatMessage>> MutableSharedFlow$default9 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._refreshedMessages = MutableSharedFlow$default9;
        this.refreshedMessages = FlowKt.asSharedFlow(MutableSharedFlow$default9);
        MutableSharedFlow<Conversation> MutableSharedFlow$default10 = SharedFlowKt.MutableSharedFlow$default(1, 0, (BufferOverflow) null, 6, (Object) null);
        this._createTask = MutableSharedFlow$default10;
        this.createTask = FlowKt.asSharedFlow(MutableSharedFlow$default10);
        MutableSharedFlow<Unit> MutableSharedFlow$default11 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._createTaskFailed = MutableSharedFlow$default11;
        this.createTaskFailed = FlowKt.asSharedFlow(MutableSharedFlow$default11);
        MutableSharedFlow<Unit> MutableSharedFlow$default12 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._modelSelectionResetToAuto = MutableSharedFlow$default12;
        this.modelSelectionResetToAuto = FlowKt.asSharedFlow(MutableSharedFlow$default12);
        MutableSharedFlow<Unit> MutableSharedFlow$default13 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._forceLogout = MutableSharedFlow$default13;
        this.forceLogout = FlowKt.asSharedFlow(MutableSharedFlow$default13);
        MutableSharedFlow<Boolean> MutableSharedFlow$default14 = SharedFlowKt.MutableSharedFlow$default(0, 1, BufferOverflow.DROP_OLDEST, 1, (Object) null);
        this._streamingStarted = MutableSharedFlow$default14;
        this.streamingStarted = FlowKt.asSharedFlow(MutableSharedFlow$default14);
        MutableStateFlow<SelectedDeviceItem> MutableStateFlow7 = StateFlowKt.MutableStateFlow((Object) null);
        this._selectedDevice = MutableStateFlow7;
        this.selectedDevice = FlowKt.asStateFlow(MutableStateFlow7);
        MutableStateFlow<ChatMode> MutableStateFlow8 = StateFlowKt.MutableStateFlow(ChatMode.MTC);
        this._currentMode = MutableStateFlow8;
        this.currentMode = FlowKt.asStateFlow(MutableStateFlow8);
        MutableStateFlow<Boolean> MutableStateFlow9 = StateFlowKt.MutableStateFlow(true);
        this._hasMoreMessages = MutableStateFlow9;
        this.hasMoreMessages = FlowKt.asStateFlow(MutableStateFlow9);
        this._isLoadingMore = StateFlowKt.MutableStateFlow(false);
        MutableStateFlow<SessionTurnStatus> MutableStateFlow10 = StateFlowKt.MutableStateFlow(SessionTurnStatus.IDLE);
        this._sessionTurnStatus = MutableStateFlow10;
        this.sessionTurnStatus = FlowKt.asStateFlow(MutableStateFlow10);
        MutableStateFlow<Boolean> MutableStateFlow11 = StateFlowKt.MutableStateFlow(false);
        this._loadError = MutableStateFlow11;
        this.loadError = FlowKt.asStateFlow(MutableStateFlow11);
        MutableSharedFlow<ParsedChatMessage> MutableSharedFlow$default15 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._remoteUserMessage = MutableSharedFlow$default15;
        this.remoteUserMessage = FlowKt.asSharedFlow(MutableSharedFlow$default15);
        this.remoteUserMessageIds = new LinkedHashSet();
        this.summarySessionId = "";
        this.summaryCliType = CliType.LOCAL;
        this.summaryMode = Mode.WORK;
        this.cacheRepository = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.ConversationViewModel$$ExternalSyntheticLambda6
            public final Object invoke() {
                ConversationDetailCacheRepository cacheRepository_delegate$lambda$1;
                cacheRepository_delegate$lambda$1 = ConversationViewModel.cacheRepository_delegate$lambda$1();
                return cacheRepository_delegate$lambda$1;
            }
        });
        this.streamingMessageListener = new IMService.StreamingMessageListener() { // from class: com.bytedance.trae.conversation.ConversationViewModel$$ExternalSyntheticLambda7
            @Override // com.bytedance.trae.im.service.IMService.StreamingMessageListener
            public final void onStreamingMessage(ParsedChatMessage parsedChatMessage, boolean z) {
                ConversationViewModel.streamingMessageListener$lambda$2(ConversationViewModel.this, parsedChatMessage, z);
            }
        };
        MutableSharedFlow<Unit> MutableSharedFlow$default16 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._taskDone = MutableSharedFlow$default16;
        this.taskDone = FlowKt.asSharedFlow(MutableSharedFlow$default16);
        this.doneListener = new IMService.DoneListener() { // from class: com.bytedance.trae.conversation.ConversationViewModel$$ExternalSyntheticLambda8
            @Override // com.bytedance.trae.im.service.IMService.DoneListener
            public final void onDone(String str, String str2) {
                ConversationViewModel.doneListener$lambda$3(ConversationViewModel.this, str, str2);
            }
        };
        this.remoteUserMessageListener = new IMService.RemoteUserMessageListener() { // from class: com.bytedance.trae.conversation.ConversationViewModel$$ExternalSyntheticLambda9
            @Override // com.bytedance.trae.im.service.IMService.RemoteUserMessageListener
            public final void onRemoteUserMessage(String str, String str2, JsonElement jsonElement, Integer num, Long l, boolean z) {
                ConversationViewModel.remoteUserMessageListener$lambda$5(ConversationViewModel.this, str, str2, jsonElement, num, l, z);
            }
        };
        this.metadataDoneListener = new IMService.MetadataDoneListener() { // from class: com.bytedance.trae.conversation.ConversationViewModel$$ExternalSyntheticLambda10
            @Override // com.bytedance.trae.im.service.IMService.MetadataDoneListener
            public final void onMetadataDone(String str, String str2, UserMessageContext userMessageContext) {
                ConversationViewModel.metadataDoneListener$lambda$7(ConversationViewModel.this, str, str2, userMessageContext);
            }
        };
        MutableSharedFlow<Boolean> MutableSharedFlow$default17 = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._cancelTaskResult = MutableSharedFlow$default17;
        this.cancelTaskResult = FlowKt.asSharedFlow(MutableSharedFlow$default17);
    }

    /* compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "STREAMING", "FINISHED", "STOPPED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class SessionTurnStatus extends Enum<SessionTurnStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SessionTurnStatus[] $VALUES;
        public static final SessionTurnStatus IDLE = new SessionTurnStatus("IDLE", 0);
        public static final SessionTurnStatus STREAMING = new SessionTurnStatus("STREAMING", 1);
        public static final SessionTurnStatus FINISHED = new SessionTurnStatus("FINISHED", 2);
        public static final SessionTurnStatus STOPPED = new SessionTurnStatus("STOPPED", 3);

        private static final /* synthetic */ SessionTurnStatus[] $values() {
            return new SessionTurnStatus[]{IDLE, STREAMING, FINISHED, STOPPED};
        }

        public static EnumEntries<SessionTurnStatus> getEntries() {
            return $ENTRIES;
        }

        private SessionTurnStatus(String str, int i) {
            super(str, i);
        }

        static {
            SessionTurnStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static SessionTurnStatus valueOf(String str) {
            return (SessionTurnStatus) Enum.valueOf(SessionTurnStatus.class, str);
        }

        public static SessionTurnStatus[] values() {
            return (SessionTurnStatus[]) $VALUES.clone();
        }
    }

    /* compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0080\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;", "", "conversationId", "", "anchorCreatedAtMs", "beforeLimit", "", "afterLimit", "includeAnchor", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIZ)V", "getConversationId", "()Ljava/lang/String;", "getAnchorCreatedAtMs", "getBeforeLimit", "()I", "getAfterLimit", "getIncludeAnchor", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ListMessagesByAnchorRequest {
        private final int afterLimit;
        private final String anchorCreatedAtMs;
        private final int beforeLimit;
        private final String conversationId;
        private final boolean includeAnchor;

        public static /* synthetic */ ListMessagesByAnchorRequest copy$default(ListMessagesByAnchorRequest listMessagesByAnchorRequest, String str, String str2, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = listMessagesByAnchorRequest.conversationId;
            }
            if ((i3 & 2) != 0) {
                str2 = listMessagesByAnchorRequest.anchorCreatedAtMs;
            }
            String str3 = str2;
            if ((i3 & 4) != 0) {
                i = listMessagesByAnchorRequest.beforeLimit;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                i2 = listMessagesByAnchorRequest.afterLimit;
            }
            int i5 = i2;
            if ((i3 & 16) != 0) {
                z = listMessagesByAnchorRequest.includeAnchor;
            }
            return listMessagesByAnchorRequest.copy(str, str3, i4, i5, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getAnchorCreatedAtMs() {
            return this.anchorCreatedAtMs;
        }

        /* renamed from: component3, reason: from getter */
        public final int getBeforeLimit() {
            return this.beforeLimit;
        }

        /* renamed from: component4, reason: from getter */
        public final int getAfterLimit() {
            return this.afterLimit;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIncludeAnchor() {
            return this.includeAnchor;
        }

        public final ListMessagesByAnchorRequest copy(String conversationId, String anchorCreatedAtMs, int beforeLimit, int afterLimit, boolean includeAnchor) {
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            return new ListMessagesByAnchorRequest(conversationId, anchorCreatedAtMs, beforeLimit, afterLimit, includeAnchor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListMessagesByAnchorRequest)) {
                return false;
            }
            ListMessagesByAnchorRequest listMessagesByAnchorRequest = (ListMessagesByAnchorRequest) other;
            return Intrinsics.areEqual(this.conversationId, listMessagesByAnchorRequest.conversationId) && Intrinsics.areEqual(this.anchorCreatedAtMs, listMessagesByAnchorRequest.anchorCreatedAtMs) && this.beforeLimit == listMessagesByAnchorRequest.beforeLimit && this.afterLimit == listMessagesByAnchorRequest.afterLimit && this.includeAnchor == listMessagesByAnchorRequest.includeAnchor;
        }

        public int hashCode() {
            int hashCode = this.conversationId.hashCode() * 31;
            String str = this.anchorCreatedAtMs;
            return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.beforeLimit)) * 31) + Integer.hashCode(this.afterLimit)) * 31) + Boolean.hashCode(this.includeAnchor);
        }

        public String toString() {
            return "ListMessagesByAnchorRequest(conversationId=" + this.conversationId + ", anchorCreatedAtMs=" + this.anchorCreatedAtMs + ", beforeLimit=" + this.beforeLimit + ", afterLimit=" + this.afterLimit + ", includeAnchor=" + this.includeAnchor + ')';
        }

        public ListMessagesByAnchorRequest(String str, String str2, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.conversationId = str;
            this.anchorCreatedAtMs = str2;
            this.beforeLimit = i;
            this.afterLimit = i2;
            this.includeAnchor = z;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final String getAnchorCreatedAtMs() {
            return this.anchorCreatedAtMs;
        }

        public final int getBeforeLimit() {
            return this.beforeLimit;
        }

        public final int getAfterLimit() {
            return this.afterLimit;
        }

        public final boolean getIncludeAnchor() {
            return this.includeAnchor;
        }
    }

    /* compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;", "", "result", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/ListMessagesResponse;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;", "<init>", "(Lcom/bytedance/trae/network/response/HttpDataResult;Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;)V", "getResult", "()Lcom/bytedance/trae/network/response/HttpDataResult;", "getRequest", "()Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ListMessagesByAnchorRetryResult {
        private final ListMessagesByAnchorRequest request;
        private final HttpDataResult<ListMessagesResponse> result;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ListMessagesByAnchorRetryResult copy$default(ListMessagesByAnchorRetryResult listMessagesByAnchorRetryResult, HttpDataResult httpDataResult, ListMessagesByAnchorRequest listMessagesByAnchorRequest, int i, Object obj) {
            if ((i & 1) != 0) {
                httpDataResult = listMessagesByAnchorRetryResult.result;
            }
            if ((i & 2) != 0) {
                listMessagesByAnchorRequest = listMessagesByAnchorRetryResult.request;
            }
            return listMessagesByAnchorRetryResult.copy(httpDataResult, listMessagesByAnchorRequest);
        }

        public final HttpDataResult<ListMessagesResponse> component1() {
            return this.result;
        }

        /* renamed from: component2, reason: from getter */
        public final ListMessagesByAnchorRequest getRequest() {
            return this.request;
        }

        public final ListMessagesByAnchorRetryResult copy(HttpDataResult<ListMessagesResponse> result, ListMessagesByAnchorRequest r3) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(r3, OauthTokenTriggerScene.REQUEST);
            return new ListMessagesByAnchorRetryResult(result, r3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListMessagesByAnchorRetryResult)) {
                return false;
            }
            ListMessagesByAnchorRetryResult listMessagesByAnchorRetryResult = (ListMessagesByAnchorRetryResult) other;
            return Intrinsics.areEqual(this.result, listMessagesByAnchorRetryResult.result) && Intrinsics.areEqual(this.request, listMessagesByAnchorRetryResult.request);
        }

        public int hashCode() {
            return (this.result.hashCode() * 31) + this.request.hashCode();
        }

        public String toString() {
            return "ListMessagesByAnchorRetryResult(result=" + this.result + ", request=" + this.request + ')';
        }

        public ListMessagesByAnchorRetryResult(HttpDataResult<ListMessagesResponse> httpDataResult, ListMessagesByAnchorRequest listMessagesByAnchorRequest) {
            Intrinsics.checkNotNullParameter(httpDataResult, "result");
            Intrinsics.checkNotNullParameter(listMessagesByAnchorRequest, OauthTokenTriggerScene.REQUEST);
            this.result = httpDataResult;
            this.request = listMessagesByAnchorRequest;
        }

        public final HttpDataResult<ListMessagesResponse> getResult() {
            return this.result;
        }

        public final ListMessagesByAnchorRequest getRequest() {
            return this.request;
        }
    }

    public final Gson getGson() {
        return this.gson;
    }

    public final StateFlow<Conversation> getConversation() {
        return this.conversation;
    }

    public final StateFlow<List<Conversation>> getConversations() {
        return this.conversations;
    }

    public final StateFlow<String> getConversationId() {
        return this.conversationId;
    }

    /* renamed from: isTaskRunning, reason: from getter */
    public final boolean getIsTaskRunning() {
        return this.isTaskRunning;
    }

    public final void setTaskRunning(boolean z) {
        this.isTaskRunning = z;
    }

    public final boolean shouldShowCheckpoint(String toolCallId) {
        Intrinsics.checkNotNullParameter(toolCallId, "toolCallId");
        return this._shownCheckpointToolCallIds.add(toolCallId);
    }

    /* compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\nH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/ConversationViewModel$MsgList;", "Lkotlin/collections/AbstractList;", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "delegate", "", "<init>", "(Ljava/util/List;)V", "getDelegate", "()Ljava/util/List;", "size", "", "getSize", "()I", ApiRequest.METHOD_GET, "index", "equals", "", "other", "", "hashCode", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class MsgList extends AbstractList<ParsedChatMessage> {
        private final List<ParsedChatMessage> delegate;

        public boolean equals(Object other) {
            return this == other;
        }

        public MsgList(List<ParsedChatMessage> list) {
            Intrinsics.checkNotNullParameter(list, "delegate");
            this.delegate = list;
        }

        public /* bridge */ boolean contains(ParsedChatMessage parsedChatMessage) {
            return super.contains(parsedChatMessage);
        }

        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof ParsedChatMessage) {
                return contains((ParsedChatMessage) obj);
            }
            return false;
        }

        public final List<ParsedChatMessage> getDelegate() {
            return this.delegate;
        }

        public /* bridge */ int indexOf(ParsedChatMessage parsedChatMessage) {
            return super.indexOf(parsedChatMessage);
        }

        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof ParsedChatMessage) {
                return indexOf((ParsedChatMessage) obj);
            }
            return -1;
        }

        public /* bridge */ int lastIndexOf(ParsedChatMessage parsedChatMessage) {
            return super.lastIndexOf(parsedChatMessage);
        }

        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof ParsedChatMessage) {
                return lastIndexOf((ParsedChatMessage) obj);
            }
            return -1;
        }

        public int getSize() {
            return this.delegate.size();
        }

        /* renamed from: get */
        public ParsedChatMessage m1164get(int i) {
            return this.delegate.get(i);
        }

        public int hashCode() {
            return System.identityHashCode(this);
        }
    }

    public final StateFlow<List<ParsedChatMessage>> getMessages() {
        return this.messages;
    }

    public final void setMessages(List<ParsedChatMessage> value) {
        this.isMessageListCommitPendingForUpgradeReminder = true;
        this._messages.setValue(new MsgList(value));
    }

    public final SharedFlow<ParsedChatMessage> getNewMessage() {
        return this.newMessage;
    }

    /* compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/ConversationViewModel$PendingUpgradeReminderRefresh;", "", "conversationId", "", "messages", "", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getConversationId", "()Ljava/lang/String;", "getMessages", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class PendingUpgradeReminderRefresh {
        private final String conversationId;
        private final List<ParsedChatMessage> messages;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PendingUpgradeReminderRefresh copy$default(PendingUpgradeReminderRefresh pendingUpgradeReminderRefresh, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pendingUpgradeReminderRefresh.conversationId;
            }
            if ((i & 2) != 0) {
                list = pendingUpgradeReminderRefresh.messages;
            }
            return pendingUpgradeReminderRefresh.copy(str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        public final List<ParsedChatMessage> component2() {
            return this.messages;
        }

        public final PendingUpgradeReminderRefresh copy(String conversationId, List<ParsedChatMessage> messages) {
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            Intrinsics.checkNotNullParameter(messages, "messages");
            return new PendingUpgradeReminderRefresh(conversationId, messages);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingUpgradeReminderRefresh)) {
                return false;
            }
            PendingUpgradeReminderRefresh pendingUpgradeReminderRefresh = (PendingUpgradeReminderRefresh) other;
            return Intrinsics.areEqual(this.conversationId, pendingUpgradeReminderRefresh.conversationId) && Intrinsics.areEqual(this.messages, pendingUpgradeReminderRefresh.messages);
        }

        public int hashCode() {
            return (this.conversationId.hashCode() * 31) + this.messages.hashCode();
        }

        public String toString() {
            return "PendingUpgradeReminderRefresh(conversationId=" + this.conversationId + ", messages=" + this.messages + ')';
        }

        public PendingUpgradeReminderRefresh(String str, List<ParsedChatMessage> list) {
            Intrinsics.checkNotNullParameter(str, "conversationId");
            Intrinsics.checkNotNullParameter(list, "messages");
            this.conversationId = str;
            this.messages = list;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final List<ParsedChatMessage> getMessages() {
            return this.messages;
        }
    }

    public final StateFlow<UpgradeReminderUiState> getUpgradeReminder() {
        return this.upgradeReminder;
    }

    public final ParsedChatMessage getLastDoneMessage() {
        return this.lastDoneMessage;
    }

    public final SharedFlow<ParsedChatMessage> getStreamingMessage() {
        return this.streamingMessage;
    }

    public final String buildParallelLimitMessage(Integer limit) {
        int i;
        EnterpriseCommercialErrorMessages enterpriseCommercialErrorMessages = EnterpriseCommercialErrorMessages.INSTANCE;
        Resources resources = AppHost.INSTANCE.getApplication().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        String parallelLimitMessage = enterpriseCommercialErrorMessages.parallelLimitMessage(resources, limit);
        if (parallelLimitMessage != null) {
            return parallelLimitMessage;
        }
        Application application = AppHost.INSTANCE.getApplication();
        int i2 = com.bytedance.trae.multilanguage.R.string.trae_conversation_parallel_limit;
        Object[] objArr = new Object[1];
        if (limit != null) {
            if (!(limit.intValue() > 0)) {
                limit = null;
            }
            if (limit != null) {
                i = limit.intValue();
                objArr[0] = Integer.valueOf(i);
                String string = application.getString(i2, objArr);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
        }
        i = 2;
        objArr[0] = Integer.valueOf(i);
        String string2 = application.getString(i2, objArr);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    public final SharedFlow<Integer> getToastMessage() {
        return this.toastMessage;
    }

    public final SharedFlow<String> getToastText() {
        return this.toastText;
    }

    public final SharedFlow<String> getContentSecurityToastText() {
        return this.contentSecurityToastText;
    }

    public final SharedFlow<String> getRenameSuccess() {
        return this.renameSuccess;
    }

    public final SharedFlow<Unit> getDeleteSuccess() {
        return this.deleteSuccess;
    }

    public final SharedFlow<Pair<ParsedChatMessage, ParsedChatMessage>> getSendMessageSuccess() {
        return this.sendMessageSuccess;
    }

    public final StateFlow<Boolean> isAnchorWindowLoading() {
        return this.isAnchorWindowLoading;
    }

    public final SharedFlow<List<ParsedChatMessage>> getRefreshedMessages() {
        return this.refreshedMessages;
    }

    public final SharedFlow<Conversation> getCreateTask() {
        return this.createTask;
    }

    public final SharedFlow<Unit> getCreateTaskFailed() {
        return this.createTaskFailed;
    }

    public final SharedFlow<Unit> getModelSelectionResetToAuto() {
        return this.modelSelectionResetToAuto;
    }

    public final SharedFlow<Unit> getForceLogout() {
        return this.forceLogout;
    }

    public final SharedFlow<Boolean> getStreamingStarted() {
        return this.streamingStarted;
    }

    public final StateFlow<SelectedDeviceItem> getSelectedDevice() {
        return this.selectedDevice;
    }

    public final StateFlow<ChatMode> getCurrentMode() {
        return this.currentMode;
    }

    /* compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/ConversationViewModel$LatestPrefetchMessages;", "", "messages", "", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "pageLimit", "", "<init>", "(Ljava/util/List;I)V", "getMessages", "()Ljava/util/List;", "getPageLimit", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class LatestPrefetchMessages {
        private final List<ParsedChatMessage> messages;
        private final int pageLimit;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LatestPrefetchMessages copy$default(LatestPrefetchMessages latestPrefetchMessages, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = latestPrefetchMessages.messages;
            }
            if ((i2 & 2) != 0) {
                i = latestPrefetchMessages.pageLimit;
            }
            return latestPrefetchMessages.copy(list, i);
        }

        public final List<ParsedChatMessage> component1() {
            return this.messages;
        }

        /* renamed from: component2, reason: from getter */
        public final int getPageLimit() {
            return this.pageLimit;
        }

        public final LatestPrefetchMessages copy(List<ParsedChatMessage> messages, int pageLimit) {
            Intrinsics.checkNotNullParameter(messages, "messages");
            return new LatestPrefetchMessages(messages, pageLimit);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LatestPrefetchMessages)) {
                return false;
            }
            LatestPrefetchMessages latestPrefetchMessages = (LatestPrefetchMessages) other;
            return Intrinsics.areEqual(this.messages, latestPrefetchMessages.messages) && this.pageLimit == latestPrefetchMessages.pageLimit;
        }

        public int hashCode() {
            return (this.messages.hashCode() * 31) + Integer.hashCode(this.pageLimit);
        }

        public String toString() {
            return "LatestPrefetchMessages(messages=" + this.messages + ", pageLimit=" + this.pageLimit + ')';
        }

        public LatestPrefetchMessages(List<ParsedChatMessage> list, int i) {
            Intrinsics.checkNotNullParameter(list, "messages");
            this.messages = list;
            this.pageLimit = i;
        }

        public final List<ParsedChatMessage> getMessages() {
            return this.messages;
        }

        public final int getPageLimit() {
            return this.pageLimit;
        }
    }

    public final StateFlow<Boolean> getHasMoreMessages() {
        return this.hasMoreMessages;
    }

    public final StateFlow<SessionTurnStatus> getSessionTurnStatus() {
        return this.sessionTurnStatus;
    }

    public final StateFlow<Boolean> getLoadError() {
        return this.loadError;
    }

    public final SharedFlow<ParsedChatMessage> getRemoteUserMessage() {
        return this.remoteUserMessage;
    }

    /* renamed from: isNewConversation, reason: from getter */
    public final boolean getIsNewConversation() {
        return this.isNewConversation;
    }

    public final void setNewConversation(boolean z) {
        this.isNewConversation = z;
    }

    public final String getSelectedRepoUrl() {
        return this.selectedRepoUrl;
    }

    public final void setSelectedRepoUrl(String str) {
        this.selectedRepoUrl = str;
    }

    public final GitRepoItem getSelectedRepo() {
        return this.selectedRepo;
    }

    public final void setSelectedRepo(GitRepoItem gitRepoItem) {
        this.selectedRepo = gitRepoItem;
    }

    public final String getSelectedRepoName() {
        return this.selectedRepoName;
    }

    public final void setSelectedRepoName(String str) {
        this.selectedRepoName = str;
    }

    public final String getSelectedBranchName() {
        return this.selectedBranchName;
    }

    public final void setSelectedBranchName(String str) {
        this.selectedBranchName = str;
    }

    public final ConversationDetailCacheRepository getCacheRepository() {
        return (ConversationDetailCacheRepository) this.cacheRepository.getValue();
    }

    public static final ConversationDetailCacheRepository cacheRepository_delegate$lambda$1() {
        String str;
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (str = accountInfo.getUserId()) == null) {
            str = "anonymous";
        }
        return new ConversationDetailCacheRepository(new ConversationDetailDao(DatabaseManager.INSTANCE.getDatabase(AppHost.INSTANCE.getApplication(), str)));
    }

    public final void deleteCachedMessages(String conversationId, List<String> messageIds) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageIds, "messageIds");
        if (messageIds.isEmpty()) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new ConversationViewModel$deleteCachedMessages$1(this, conversationId, messageIds, null), 2, (Object) null);
    }

    public static final void streamingMessageListener$lambda$2(ConversationViewModel conversationViewModel, ParsedChatMessage parsedChatMessage, boolean z) {
        SessionTurnStatus sessionTurnStatus;
        int extractSummaryCharCount;
        List<ParsedPlanItemMessage> messages;
        Intrinsics.checkNotNullParameter(parsedChatMessage, "message");
        String str = (String) conversationViewModel._conversationId.getValue();
        String str2 = str;
        boolean z2 = true;
        if (str2 == null || str2.length() == 0) {
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node3] streamingListener: SKIP currentId null/empty");
            return;
        }
        if (!Intrinsics.areEqual(parsedChatMessage.getSessionId(), str)) {
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node3] streamingListener: SKIP sessionId mismatch, msg.sessionId=" + parsedChatMessage.getSessionId() + ", currentId=" + str);
            return;
        }
        ParsedTaskContent taskContent = parsedChatMessage.getTaskContent();
        TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node3] streamingListener: EMIT, planItemCount=" + ((taskContent == null || (messages = taskContent.getMessages()) == null) ? 0 : messages.size()) + ", status=" + parsedChatMessage.getStatus() + ", isHistory=" + parsedChatMessage.isHistory() + ", isDone=" + z);
        if (!parsedChatMessage.isHistory()) {
            ParsedTaskContent taskContent2 = parsedChatMessage.getTaskContent();
            conversationViewModel._currentTaskId = taskContent2 != null ? taskContent2.getTaskId() : null;
        }
        if (conversationViewModel.isSummaryTracking && !parsedChatMessage.isHistory() && (extractSummaryCharCount = conversationViewModel.extractSummaryCharCount(parsedChatMessage)) > 0) {
            if (conversationViewModel.summaryDataFirstCharTimestamp == 0) {
                conversationViewModel.summaryDataFirstCharTimestamp = System.currentTimeMillis();
            }
            conversationViewModel.summaryCharCount = extractSummaryCharCount;
        }
        if (!CollectionsKt.contains(CollectionsKt.listOf(new String[]{"completed", "failed", ConfirmInfo.STATUS_CANCELED}), parsedChatMessage.getStatus()) && ((!Intrinsics.areEqual(parsedChatMessage.getStatus(), "in_progress") || !parsedChatMessage.isHistory()) && !parsedChatMessage.isInterjected())) {
            z2 = false;
        }
        if (z2) {
            conversationViewModel.isTaskRunning = false;
            conversationViewModel.handleModelUnavailableMessageErrorIfNeeded(parsedChatMessage, "stream");
            if (conversationViewModel.isSummaryTracking) {
                conversationViewModel.isSummaryTracking = false;
                conversationViewModel.armSummaryPerfReport(Intrinsics.areEqual(parsedChatMessage.getStatus(), "completed"));
            }
        }
        conversationViewModel._streamingStarted.tryEmit(Boolean.valueOf(z2));
        if (!parsedChatMessage.isHistory()) {
            conversationViewModel._sessionTurnStatus.setValue(SessionTurnStatus.STREAMING);
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$streamingMessageListener$1$1(conversationViewModel, parsedChatMessage, null), 3, (Object) null);
            return;
        }
        if (parsedChatMessage.isAssistantMessage()) {
            MutableStateFlow<SessionTurnStatus> mutableStateFlow = conversationViewModel._sessionTurnStatus;
            String status = parsedChatMessage.getStatus();
            if (Intrinsics.areEqual(status, "failed")) {
                sessionTurnStatus = SessionTurnStatus.STOPPED;
            } else {
                sessionTurnStatus = Intrinsics.areEqual(status, ConfirmInfo.STATUS_CANCELED) ? SessionTurnStatus.STOPPED : SessionTurnStatus.FINISHED;
            }
            mutableStateFlow.setValue(sessionTurnStatus);
            conversationViewModel.notifyTaskListStatusChanged(str, parsedChatMessage.getStatus());
        }
        if (z) {
            conversationViewModel.lastDoneMessage = parsedChatMessage;
        }
        ConversationViewModel conversationViewModel2 = conversationViewModel;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel2), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$streamingMessageListener$1$2(conversationViewModel, parsedChatMessage, z, null), 3, (Object) null);
        if (z) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel2), Dispatchers.getIO(), (CoroutineStart) null, new ConversationViewModel$streamingMessageListener$1$3(conversationViewModel, parsedChatMessage, null), 2, (Object) null);
        }
    }

    public final SharedFlow<Unit> getTaskDone() {
        return this.taskDone;
    }

    public static final void doneListener$lambda$3(ConversationViewModel conversationViewModel, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "taskId");
        String str3 = (String) conversationViewModel._conversationId.getValue();
        String str4 = str3;
        if (str4 == null || str4.length() == 0) {
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node3] doneListener: SKIP currentId null/empty");
        } else {
            if (!Intrinsics.areEqual(str2, str3)) {
                TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node3] doneListener: SKIP convId mismatch, convId=" + str2 + ", currentId=" + str3);
                return;
            }
            conversationViewModel._currentTaskId = null;
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node3] doneListener: EMIT taskDone for convId=" + str2);
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$doneListener$1$1(conversationViewModel, null), 3, (Object) null);
        }
    }

    public static final void remoteUserMessageListener$lambda$5(ConversationViewModel conversationViewModel, String str, String str2, JsonElement jsonElement, Integer num, Long l, boolean z) {
        ParsedChatMessage buildRemoteUserMessage;
        Intrinsics.checkNotNullParameter(str, "conversationId");
        Intrinsics.checkNotNullParameter(str2, "messageId");
        String str3 = (String) conversationViewModel._conversationId.getValue();
        String str4 = str3;
        boolean z2 = true;
        if ((str4 == null || str4.length() == 0) || !Intrinsics.areEqual(str, str3) || conversationViewModel.remoteUserMessageIds.contains(str2)) {
            return;
        }
        Iterable iterable = (Iterable) conversationViewModel._messages.getValue();
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((ParsedChatMessage) it.next()).getMessageId(), str2)) {
                    break;
                }
            }
        }
        z2 = false;
        if (z2 || (buildRemoteUserMessage = conversationViewModel.buildRemoteUserMessage(str, str2, jsonElement, num, l, z)) == null) {
            return;
        }
        conversationViewModel.remoteUserMessageIds.add(str2);
        ConversationViewModel conversationViewModel2 = conversationViewModel;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel2), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$remoteUserMessageListener$1$2(conversationViewModel, buildRemoteUserMessage, null), 3, (Object) null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel2), Dispatchers.getIO(), (CoroutineStart) null, new ConversationViewModel$remoteUserMessageListener$1$3(conversationViewModel, str, buildRemoteUserMessage, null), 2, (Object) null);
    }

    public static final void metadataDoneListener$lambda$7(ConversationViewModel conversationViewModel, String str, String str2, UserMessageContext userMessageContext) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "conversationId");
        Intrinsics.checkNotNullParameter(userMessageContext, "userMessageContext");
        String str3 = (String) conversationViewModel._conversationId.getValue();
        String str4 = str3;
        if ((str4 == null || str4.length() == 0) || !Intrinsics.areEqual(str, str3)) {
            return;
        }
        String str5 = str2;
        if ((str5 == null || str5.length() == 0) || conversationViewModel.remoteUserMessageIds.contains(str2)) {
            return;
        }
        Iterable iterable = (Iterable) conversationViewModel._messages.getValue();
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((ParsedChatMessage) it.next()).getMessageId(), str2)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return;
        }
        String extractQueryFromUserMessageContext = conversationViewModel.extractQueryFromUserMessageContext(userMessageContext);
        String str6 = extractQueryFromUserMessageContext;
        if (str6 == null || str6.length() == 0) {
            return;
        }
        List<MessagePart> parseQuery = MessagePartNormalizer.INSTANCE.parseQuery(extractQueryFromUserMessageContext);
        String extractText$default = MessagePartNormalizer.extractText$default(MessagePartNormalizer.INSTANCE, parseQuery, null, 2, null);
        String str7 = extractText$default;
        if (str7 == null || str7.length() == 0) {
            List<MessagePart> list = parseQuery;
            if (list == null || list.isEmpty()) {
                return;
            }
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$metadataDoneListener$1$2(conversationViewModel, str2, new ParsedChatMessage(str, str2, null, null, null, null, ParsedChatMessage.ROLE_USER, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, extractText$default, parseQuery, null, true, Intrinsics.areEqual(userMessageContext.isAppendMsg(), true), false, null, null, null, null, null, null, null, null, null, null, null, null, -68, 8387743, null), str, null), 3, (Object) null);
    }

    public static /* synthetic */ Conversation init$default(ConversationViewModel conversationViewModel, String str, Conversation conversation, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return conversationViewModel.init(str, conversation, str2);
    }

    public final Conversation init(String conversationId, Conversation conversation, String anchorCreatedAtMs) {
        Conversation resolveInitialConversation = resolveInitialConversation(conversationId, conversation);
        String str = null;
        if (Intrinsics.areEqual(resolveInitialConversation != null ? resolveInitialConversation.getEnvironment() : null, CliType.IDE.getValue())) {
            resolveInitialConversation.setMode(Mode.CODE.getValue());
        }
        TraeLogUtil.INSTANCE.d(TAG, "init: conversationId=" + conversationId + ", Conversation=" + resolveInitialConversation + ", conversation.title=" + (resolveInitialConversation != null ? resolveInitialConversation.getTitle() : null));
        MutableStateFlow<String> mutableStateFlow = this._conversationId;
        if (conversationId != null) {
            str = conversationId;
        } else if (resolveInitialConversation != null) {
            str = resolveInitialConversation.getId();
        }
        mutableStateFlow.setValue(str);
        this._conversation.setValue(resolveInitialConversation);
        String str2 = conversationId;
        this.isNewConversation = (str2 == null || str2.length() == 0) && resolveInitialConversation == null;
        initSelectedDevice(resolveInitialConversation);
        IMService.INSTANCE.init();
        IMService.INSTANCE.addStreamingMessageListener(this.streamingMessageListener);
        IMService.INSTANCE.addDoneListener(this.doneListener);
        IMService.INSTANCE.addRemoteUserMessageListener(this.remoteUserMessageListener);
        IMService.INSTANCE.addMetadataDoneListener(this.metadataDoneListener);
        CharSequence charSequence = (CharSequence) this._conversationId.getValue();
        if (!(charSequence == null || charSequence.length() == 0)) {
            String str3 = anchorCreatedAtMs;
            if (!(str3 == null || StringsKt.isBlank(str3))) {
                TraeLogUtil.INSTANCE.d(TAG, "init: loading anchor window for conversationId=" + ((String) this._conversationId.getValue()) + ", anchorCreatedAtMs=" + anchorCreatedAtMs);
                loadAnchorWindow(anchorCreatedAtMs);
            } else {
                TraeLogUtil.INSTANCE.d(TAG, "init: loading messages for conversationId=" + ((String) this._conversationId.getValue()));
                Object value = this._conversationId.getValue();
                Intrinsics.checkNotNull(value);
                loadMessages((String) value);
            }
        } else {
            TraeLogUtil.INSTANCE.d(TAG, "init: no conversationId, skip loadMessages (new conversation)");
        }
        return resolveInitialConversation;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onConversationFullDetailLoaded(ConversationFullDetailResponse detail) {
        Conversation conversation;
        String environment;
        String str;
        Conversation copy;
        if (detail == null || (conversation = detail.getConversation()) == null) {
            return;
        }
        String cliProductType = detail.getCliProductType();
        if (cliProductType != null) {
            int hashCode = cliProductType.hashCode();
            if (hashCode != -934610874) {
                if (hashCode != 777040398) {
                    if (hashCode == 1271977997 && cliProductType.equals("trae_ide")) {
                        environment = CliType.IDE.getValue();
                    }
                } else if (cliProductType.equals("trae_work")) {
                    environment = CliType.LOCAL.getValue();
                }
            } else if (cliProductType.equals("remote")) {
                environment = CliType.REMOTE.getValue();
            }
            str = environment;
            String mode = conversation.getMode();
            if (Intrinsics.areEqual(str, CliType.IDE.getValue())) {
                mode = Mode.CODE.getValue();
            }
            this._selectedDevice.setValue(buildSelectedDeviceFromConversation(conversation));
            MutableStateFlow<Conversation> mutableStateFlow = this._conversation;
            copy = conversation.copy((r44 & 1) != 0 ? conversation.id : null, (r44 & 2) != 0 ? conversation.parentConversationId : null, (r44 & 4) != 0 ? conversation.hiddenStatus : null, (r44 & 8) != 0 ? conversation.cliConversationId : null, (r44 & 16) != 0 ? conversation.userId : null, (r44 & 32) != 0 ? conversation.cliId : null, (r44 & 64) != 0 ? conversation.title : null, (r44 & 128) != 0 ? conversation.workspace : null, (r44 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? conversation.gitUri : null, (r44 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? conversation.mode : mode, (r44 & 1024) != 0 ? conversation.status : null, (r44 & 2048) != 0 ? conversation.environment : str, (r44 & 4096) != 0 ? conversation.latestTaskId : null, (r44 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? conversation.latestTaskStatus : null, (r44 & 16384) != 0 ? conversation.latestTaskUpdateTime : null, (r44 & 32768) != 0 ? conversation.createdAt : null, (r44 & 65536) != 0 ? conversation.updatedAt : null, (r44 & 131072) != 0 ? conversation.source : null, (r44 & 262144) != 0 ? conversation.iconType : null, (r44 & FConstants.SLICE_SIZE) != 0 ? conversation.cliConversationStatus : null, (r44 & 1048576) != 0 ? conversation.ownerProjectId : null, (r44 & 2097152) != 0 ? conversation.latestProjectId : null, (r44 & 4194304) != 0 ? conversation.ownerProjectAbsolutePath : null, (r44 & 8388608) != 0 ? conversation.ownerProjectWorkSpaceStatus : null, (r44 & 16777216) != 0 ? conversation.isPinned : null, (r44 & 33554432) != 0 ? conversation.pinnedAt : null);
            mutableStateFlow.setValue(copy);
        }
        environment = conversation.getEnvironment();
        str = environment;
        String mode2 = conversation.getMode();
        if (Intrinsics.areEqual(str, CliType.IDE.getValue())) {
        }
        this._selectedDevice.setValue(buildSelectedDeviceFromConversation(conversation));
        MutableStateFlow<Conversation> mutableStateFlow2 = this._conversation;
        copy = conversation.copy((r44 & 1) != 0 ? conversation.id : null, (r44 & 2) != 0 ? conversation.parentConversationId : null, (r44 & 4) != 0 ? conversation.hiddenStatus : null, (r44 & 8) != 0 ? conversation.cliConversationId : null, (r44 & 16) != 0 ? conversation.userId : null, (r44 & 32) != 0 ? conversation.cliId : null, (r44 & 64) != 0 ? conversation.title : null, (r44 & 128) != 0 ? conversation.workspace : null, (r44 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? conversation.gitUri : null, (r44 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? conversation.mode : mode2, (r44 & 1024) != 0 ? conversation.status : null, (r44 & 2048) != 0 ? conversation.environment : str, (r44 & 4096) != 0 ? conversation.latestTaskId : null, (r44 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? conversation.latestTaskStatus : null, (r44 & 16384) != 0 ? conversation.latestTaskUpdateTime : null, (r44 & 32768) != 0 ? conversation.createdAt : null, (r44 & 65536) != 0 ? conversation.updatedAt : null, (r44 & 131072) != 0 ? conversation.source : null, (r44 & 262144) != 0 ? conversation.iconType : null, (r44 & FConstants.SLICE_SIZE) != 0 ? conversation.cliConversationStatus : null, (r44 & 1048576) != 0 ? conversation.ownerProjectId : null, (r44 & 2097152) != 0 ? conversation.latestProjectId : null, (r44 & 4194304) != 0 ? conversation.ownerProjectAbsolutePath : null, (r44 & 8388608) != 0 ? conversation.ownerProjectWorkSpaceStatus : null, (r44 & 16777216) != 0 ? conversation.isPinned : null, (r44 & 33554432) != 0 ? conversation.pinnedAt : null);
        mutableStateFlow2.setValue(copy);
    }

    private final Conversation resolveInitialConversation(String conversationId, Conversation conversation) {
        return ConversationUtils.INSTANCE.resolveInitialConversation(conversationId, conversation);
    }

    public final void createTaskCheck(String conversationId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$createTaskCheck$1(this, conversationId, null), 3, (Object) null);
    }

    public final Object checkIdeProjectForSkills(String str, Continuation<? super SelectedDeviceItem> continuation) {
        return performCreateTaskCheck(str, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object performCreateTaskCheck(String str, Continuation<? super SelectedDeviceItem> continuation) {
        ConversationViewModel$performCreateTaskCheck$1 conversationViewModel$performCreateTaskCheck$1;
        int i;
        ConversationViewModel conversationViewModel;
        HttpDataResult.Success success;
        int i2;
        if (continuation instanceof ConversationViewModel$performCreateTaskCheck$1) {
            conversationViewModel$performCreateTaskCheck$1 = (ConversationViewModel$performCreateTaskCheck$1) continuation;
            if ((conversationViewModel$performCreateTaskCheck$1.label & Integer.MIN_VALUE) != 0) {
                conversationViewModel$performCreateTaskCheck$1.label -= Integer.MIN_VALUE;
                Object obj = conversationViewModel$performCreateTaskCheck$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = conversationViewModel$performCreateTaskCheck$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ICreateTaskCheck.Companion companion = ICreateTaskCheck.INSTANCE;
                    CreateTaskCheckRequest createTaskCheckRequest = new CreateTaskCheckRequest(str);
                    conversationViewModel$performCreateTaskCheck$1.L$0 = this;
                    conversationViewModel$performCreateTaskCheck$1.label = 1;
                    obj = companion.createTaskCheckRawCall(createTaskCheckRequest, conversationViewModel$performCreateTaskCheck$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    conversationViewModel = this;
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            return null;
                        }
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return null;
                    }
                    conversationViewModel = (ConversationViewModel) conversationViewModel$performCreateTaskCheck$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if (!(success instanceof HttpDataResult.Success)) {
                    HttpDataResult.Success success2 = success;
                    if (success2.getBizResp().getCode() == CODE_DEVICE_OFFLINE || success2.getBizResp().getCode() == CODE_IDE_DEVICE_OFFLINE) {
                        if (success2.getBizResp().getCode() == CODE_IDE_DEVICE_OFFLINE) {
                            i2 = com.bytedance.trae.multilanguage.R.string.trae_conversation_ide_device_offline;
                        } else {
                            i2 = com.bytedance.trae.multilanguage.R.string.trae_conversation_device_offline;
                        }
                        MutableSharedFlow<String> mutableSharedFlow = conversationViewModel._toastText;
                        String string = AppHost.INSTANCE.getApplication().getString(i2);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        conversationViewModel$performCreateTaskCheck$1.L$0 = null;
                        conversationViewModel$performCreateTaskCheck$1.label = 2;
                        if (mutableSharedFlow.emit(string, conversationViewModel$performCreateTaskCheck$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return null;
                    }
                    BizResponse bizResp = success2.getBizResp();
                    CreateTaskCheckResponse createTaskCheckResponse = bizResp != null ? (CreateTaskCheckResponse) bizResp.getData() : null;
                    if (createTaskCheckResponse != null) {
                        TraeLogUtil.INSTANCE.d(TAG, "createTaskCheck success: projectId=" + createTaskCheckResponse.getProjectId() + ", available=" + createTaskCheckResponse.getAvailable());
                        if (!createTaskCheckResponse.getAvailable()) {
                            MutableSharedFlow<String> mutableSharedFlow2 = conversationViewModel._toastText;
                            String string2 = AppHost.INSTANCE.getApplication().getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_ide_device_offline);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            conversationViewModel$performCreateTaskCheck$1.L$0 = null;
                            conversationViewModel$performCreateTaskCheck$1.label = 3;
                            if (mutableSharedFlow2.emit(string2, conversationViewModel$performCreateTaskCheck$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return null;
                        }
                        conversationViewModel.applyCreateTaskCheckResult(createTaskCheckResponse);
                    }
                    return (SelectedDeviceItem) conversationViewModel._selectedDevice.getValue();
                }
                if (!(success instanceof HttpDataResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                HttpDataResult.Error error = (HttpDataResult.Error) success;
                TraeLogUtil.INSTANCE.e(TAG, "createTaskCheck error: code=" + error.getCode() + ", msg=" + error.getMsg());
                return null;
            }
        }
        conversationViewModel$performCreateTaskCheck$1 = new ConversationViewModel$performCreateTaskCheck$1(this, continuation);
        Object obj2 = conversationViewModel$performCreateTaskCheck$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = conversationViewModel$performCreateTaskCheck$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (!(success instanceof HttpDataResult.Success)) {
        }
    }

    public final void recoverStreamingMessages() {
        Object obj;
        String str = (String) this._conversationId.getValue();
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        List<ParsedChatMessage> streamingMessages = IMService.INSTANCE.getStreamingMessages(str);
        if (streamingMessages.isEmpty()) {
            return;
        }
        Iterable iterable = (Iterable) this._messages.getValue();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : iterable) {
            if (((ParsedChatMessage) obj2).isUserMessage()) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long createdAt = ((ParsedChatMessage) next).getCreatedAt();
                do {
                    Object next2 = it.next();
                    long createdAt2 = ((ParsedChatMessage) next2).getCreatedAt();
                    if (createdAt < createdAt2) {
                        next = next2;
                        createdAt = createdAt2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        ParsedChatMessage parsedChatMessage = (ParsedChatMessage) obj;
        if (parsedChatMessage == null) {
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node3] recoverStreamingMessages: no user message found in _messages, skip recovery");
            return;
        }
        String messageId = parsedChatMessage.getMessageId();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : streamingMessages) {
            if (Intrinsics.areEqual(((ParsedChatMessage) obj3).getReplyToMessageId(), messageId)) {
                arrayList2.add(obj3);
            }
        }
        ArrayList<ParsedChatMessage> arrayList3 = arrayList2;
        TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node3] recoverStreamingMessages: cached=" + streamingMessages.size() + ", latestUserMsgId=" + messageId + ", matched=" + arrayList3.size());
        for (ParsedChatMessage parsedChatMessage2 : arrayList3) {
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node3] recoverStreamingMessages: cached=" + streamingMessages.size() + ", latestUserMsgId=" + messageId + ", matched=" + arrayList3.size() + ' ' + parsedChatMessage2);
            if (parsedChatMessage2.isHistory()) {
                this.streamingMessageListener.onStreamingMessage(parsedChatMessage2, true);
            } else {
                this.streamingMessageListener.onStreamingMessage(parsedChatMessage2, false);
            }
        }
    }

    protected void onCleared() {
        super.onCleared();
        Job job = this.streamingTrailingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.createTaskJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        IMService.INSTANCE.removeStreamingMessageListener(this.streamingMessageListener);
        IMService.INSTANCE.removeRemoteUserMessageListener(this.remoteUserMessageListener);
        IMService.INSTANCE.removeMetadataDoneListener(this.metadataDoneListener);
        IMService.INSTANCE.removeDoneListener(this.doneListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0085 A[Catch: all -> 0x011f, TRY_ENTER, TryCatch #1 {all -> 0x011f, blocks: (B:25:0x0073, B:28:0x0085, B:30:0x008b, B:31:0x008f, B:33:0x00b4, B:37:0x00c6, B:39:0x00ef, B:43:0x00fb), top: B:24:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c6 A[Catch: all -> 0x011f, TryCatch #1 {all -> 0x011f, blocks: (B:25:0x0073, B:28:0x0085, B:30:0x008b, B:31:0x008f, B:33:0x00b4, B:37:0x00c6, B:39:0x00ef, B:43:0x00fb), top: B:24:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emitStreamingThrottled(ParsedChatMessage parsedChatMessage, Continuation<? super Unit> continuation) {
        ConversationViewModel$emitStreamingThrottled$1 conversationViewModel$emitStreamingThrottled$1;
        int i;
        ParsedChatMessage parsedChatMessage2;
        Mutex mutex;
        ConversationViewModel conversationViewModel;
        Mutex mutex2;
        long j;
        try {
            if (continuation instanceof ConversationViewModel$emitStreamingThrottled$1) {
                conversationViewModel$emitStreamingThrottled$1 = (ConversationViewModel$emitStreamingThrottled$1) continuation;
                if ((conversationViewModel$emitStreamingThrottled$1.label & Integer.MIN_VALUE) != 0) {
                    conversationViewModel$emitStreamingThrottled$1.label -= Integer.MIN_VALUE;
                    Object obj = conversationViewModel$emitStreamingThrottled$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = conversationViewModel$emitStreamingThrottled$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex3 = this.streamingThrottleMutex;
                        conversationViewModel$emitStreamingThrottled$1.L$0 = this;
                        parsedChatMessage2 = parsedChatMessage;
                        conversationViewModel$emitStreamingThrottled$1.L$1 = parsedChatMessage2;
                        conversationViewModel$emitStreamingThrottled$1.L$2 = mutex3;
                        conversationViewModel$emitStreamingThrottled$1.label = 1;
                        if (mutex3.lock((Object) null, conversationViewModel$emitStreamingThrottled$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutex = mutex3;
                        conversationViewModel = this;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutex2 = (Mutex) conversationViewModel$emitStreamingThrottled$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                Unit unit = Unit.INSTANCE;
                                mutex2.unlock((Object) null);
                                return Unit.INSTANCE;
                            } catch (Throwable th) {
                                th = th;
                                mutex2.unlock((Object) null);
                                throw th;
                            }
                        }
                        Mutex mutex4 = (Mutex) conversationViewModel$emitStreamingThrottled$1.L$2;
                        ParsedChatMessage parsedChatMessage3 = (ParsedChatMessage) conversationViewModel$emitStreamingThrottled$1.L$1;
                        conversationViewModel = (ConversationViewModel) conversationViewModel$emitStreamingThrottled$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex4;
                        parsedChatMessage2 = parsedChatMessage3;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    j = currentTimeMillis - conversationViewModel.lastStreamingEmitTime;
                    if (j < STREAMING_THROTTLE_MS) {
                        conversationViewModel.lastStreamingEmitTime = currentTimeMillis;
                        Job job = conversationViewModel.streamingTrailingJob;
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        conversationViewModel.pendingStreamingMessage = null;
                        TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node3] throttle: EMIT_IMMEDIATE, elapsed=" + j + "ms");
                        conversationViewModel.upsertMessages(CollectionsKt.listOf(parsedChatMessage2));
                        if (conversationViewModel.processTraeRefInSummary(parsedChatMessage2)) {
                            MutableSharedFlow<ParsedChatMessage> mutableSharedFlow = conversationViewModel._throttledStreamingMessage;
                            conversationViewModel$emitStreamingThrottled$1.L$0 = mutex;
                            conversationViewModel$emitStreamingThrottled$1.L$1 = null;
                            conversationViewModel$emitStreamingThrottled$1.L$2 = null;
                            conversationViewModel$emitStreamingThrottled$1.label = 2;
                            if (mutableSharedFlow.emit(parsedChatMessage2, conversationViewModel$emitStreamingThrottled$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        conversationViewModel.pendingStreamingMessage = parsedChatMessage2;
                        TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
                        StringBuilder append = new StringBuilder("[Node3] throttle: DEFERRED, elapsed=").append(j).append("ms, remaining=");
                        long j2 = STREAMING_THROTTLE_MS - j;
                        traeLogUtil.d(AGENT_FLOW_TAG, append.append(j2).append("ms").toString());
                        Job job2 = conversationViewModel.streamingTrailingJob;
                        if (!(job2 != null && job2.isActive())) {
                            conversationViewModel.streamingTrailingJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(conversationViewModel), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$emitStreamingThrottled$2$1(j2, conversationViewModel, null), 3, (Object) null);
                        }
                    }
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock((Object) null);
                    return Unit.INSTANCE;
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            j = currentTimeMillis2 - conversationViewModel.lastStreamingEmitTime;
            if (j < STREAMING_THROTTLE_MS) {
            }
            mutex2 = mutex;
            Unit unit22 = Unit.INSTANCE;
            mutex2.unlock((Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock((Object) null);
            throw th;
        }
        conversationViewModel$emitStreamingThrottled$1 = new ConversationViewModel$emitStreamingThrottled$1(this, continuation);
        Object obj2 = conversationViewModel$emitStreamingThrottled$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = conversationViewModel$emitStreamingThrottled$1.label;
        if (i != 0) {
        }
    }

    public final boolean processTraeRefInSummary(ParsedChatMessage message) {
        List<ParsedPlanItemMessage> messages;
        ParsedPlanItemMessage parsedPlanItemMessage;
        ParsedPlanItem planItem;
        ParsedToolCallInfo toolCallInfo;
        String name;
        ParsedToolCallInfo toolCallInfo2;
        JsonObject params;
        JsonElement jsonElement;
        String asString;
        Object content = message.getContent();
        ParsedTaskContent parsedTaskContent = content instanceof ParsedTaskContent ? (ParsedTaskContent) content : null;
        return parsedTaskContent == null || (messages = parsedTaskContent.getMessages()) == null || (parsedPlanItemMessage = (ParsedPlanItemMessage) CollectionsKt.lastOrNull(messages)) == null || (planItem = parsedPlanItemMessage.getPlanItem()) == null || (toolCallInfo = planItem.getToolCallInfo()) == null || (name = toolCallInfo.getName()) == null || !SUMMARY_FINISH_TOOLS.contains(name) || (toolCallInfo2 = planItem.getToolCallInfo()) == null || (params = toolCallInfo2.getParams()) == null || (jsonElement = params.get("summary")) == null || !jsonElement.isJsonPrimitive() || (asString = jsonElement.getAsString()) == null || StringsKt.isBlank(asString) || TraeRefStreamGuard.INSTANCE.canEmit(asString);
    }

    private final void initSelectedDevice(Conversation conversation) {
        if (conversation == null) {
            this._selectedDevice.setValue(new SelectedDeviceItem("", "", CliType.REMOTE, null, null, null, false, null, false, 496, null));
            return;
        }
        SelectedDeviceItem buildSelectedDeviceFromConversation = buildSelectedDeviceFromConversation(conversation);
        this._selectedDevice.setValue(buildSelectedDeviceFromConversation);
        updateConversationEnvironment(buildSelectedDeviceFromConversation.getType());
    }

    private final SelectedDeviceItem buildSelectedDeviceFromConversation(Conversation conversation) {
        Object obj;
        Iterator<T> it = CliListRepository.INSTANCE.getInstance().getCacheClis().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Cli) obj).getId(), conversation.getCliId())) {
                break;
            }
        }
        return ConversationDevicePolicy.INSTANCE.buildSelectedDevice(conversation, (Cli) obj, CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId()));
    }

    public final boolean shouldCheckIdeProject(Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        if (Intrinsics.areEqual(conversation.getEnvironment(), CliType.IDE.getValue())) {
            return true;
        }
        if (Intrinsics.areEqual(conversation.getEnvironment(), CliType.LOCAL.getValue())) {
            return Intrinsics.areEqual(CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId()), CliType.IDE.getValue());
        }
        return false;
    }

    private final void updateConversationEnvironment(CliType r32) {
        Conversation copy;
        Conversation copy2;
        Conversation conversation = (Conversation) this._conversation.getValue();
        if (conversation == null) {
            return;
        }
        if (r32 == CliType.IDE) {
            MutableStateFlow<Conversation> mutableStateFlow = this._conversation;
            copy2 = conversation.copy((r44 & 1) != 0 ? conversation.id : null, (r44 & 2) != 0 ? conversation.parentConversationId : null, (r44 & 4) != 0 ? conversation.hiddenStatus : null, (r44 & 8) != 0 ? conversation.cliConversationId : null, (r44 & 16) != 0 ? conversation.userId : null, (r44 & 32) != 0 ? conversation.cliId : null, (r44 & 64) != 0 ? conversation.title : null, (r44 & 128) != 0 ? conversation.workspace : null, (r44 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? conversation.gitUri : null, (r44 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? conversation.mode : Mode.CODE.getValue(), (r44 & 1024) != 0 ? conversation.status : null, (r44 & 2048) != 0 ? conversation.environment : r32.getValue(), (r44 & 4096) != 0 ? conversation.latestTaskId : null, (r44 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? conversation.latestTaskStatus : null, (r44 & 16384) != 0 ? conversation.latestTaskUpdateTime : null, (r44 & 32768) != 0 ? conversation.createdAt : null, (r44 & 65536) != 0 ? conversation.updatedAt : null, (r44 & 131072) != 0 ? conversation.source : null, (r44 & 262144) != 0 ? conversation.iconType : null, (r44 & FConstants.SLICE_SIZE) != 0 ? conversation.cliConversationStatus : null, (r44 & 1048576) != 0 ? conversation.ownerProjectId : null, (r44 & 2097152) != 0 ? conversation.latestProjectId : null, (r44 & 4194304) != 0 ? conversation.ownerProjectAbsolutePath : null, (r44 & 8388608) != 0 ? conversation.ownerProjectWorkSpaceStatus : null, (r44 & 16777216) != 0 ? conversation.isPinned : null, (r44 & 33554432) != 0 ? conversation.pinnedAt : null);
            mutableStateFlow.setValue(copy2);
            return;
        }
        MutableStateFlow<Conversation> mutableStateFlow2 = this._conversation;
        copy = conversation.copy((r44 & 1) != 0 ? conversation.id : null, (r44 & 2) != 0 ? conversation.parentConversationId : null, (r44 & 4) != 0 ? conversation.hiddenStatus : null, (r44 & 8) != 0 ? conversation.cliConversationId : null, (r44 & 16) != 0 ? conversation.userId : null, (r44 & 32) != 0 ? conversation.cliId : null, (r44 & 64) != 0 ? conversation.title : null, (r44 & 128) != 0 ? conversation.workspace : null, (r44 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? conversation.gitUri : null, (r44 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? conversation.mode : null, (r44 & 1024) != 0 ? conversation.status : null, (r44 & 2048) != 0 ? conversation.environment : r32.getValue(), (r44 & 4096) != 0 ? conversation.latestTaskId : null, (r44 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? conversation.latestTaskStatus : null, (r44 & 16384) != 0 ? conversation.latestTaskUpdateTime : null, (r44 & 32768) != 0 ? conversation.createdAt : null, (r44 & 65536) != 0 ? conversation.updatedAt : null, (r44 & 131072) != 0 ? conversation.source : null, (r44 & 262144) != 0 ? conversation.iconType : null, (r44 & FConstants.SLICE_SIZE) != 0 ? conversation.cliConversationStatus : null, (r44 & 1048576) != 0 ? conversation.ownerProjectId : null, (r44 & 2097152) != 0 ? conversation.latestProjectId : null, (r44 & 4194304) != 0 ? conversation.ownerProjectAbsolutePath : null, (r44 & 8388608) != 0 ? conversation.ownerProjectWorkSpaceStatus : null, (r44 & 16777216) != 0 ? conversation.isPinned : null, (r44 & 33554432) != 0 ? conversation.pinnedAt : null);
        mutableStateFlow2.setValue(copy);
    }

    private final void applyCreateTaskCheckResult(CreateTaskCheckResponse response) {
        SelectedDeviceItem selectedDeviceItem = (SelectedDeviceItem) this._selectedDevice.getValue();
        if (selectedDeviceItem == null) {
            return;
        }
        SelectedDeviceItem applyCreateTaskCheck = IDEProjectAvailabilityPolicy.INSTANCE.applyCreateTaskCheck(selectedDeviceItem, response);
        this._selectedDevice.setValue(applyCreateTaskCheck);
        updateConversationEnvironment(CliType.IDE);
        String projectId = applyCreateTaskCheck.getProjectId();
        if (projectId == null || StringsKt.isBlank(projectId)) {
            return;
        }
        CliListRepository.INSTANCE.getInstance().saveCliId(applyCreateTaskCheck.getId(), applyCreateTaskCheck.getType().getValue());
    }

    public final void setSelectedDevice(SelectedDeviceItem device) {
        Intrinsics.checkNotNullParameter(device, "device");
        this._selectedDevice.setValue(device);
    }

    public final void syncCodeSelectedDeviceWithItems(List<DeviceItem> items) {
        Object obj;
        SelectedDeviceItem copy;
        Intrinsics.checkNotNullParameter(items, "items");
        SelectedDeviceItem selectedDeviceItem = (SelectedDeviceItem) this._selectedDevice.getValue();
        if (selectedDeviceItem == null || selectedDeviceItem.getType() == CliType.REMOTE || StringsKt.isBlank(selectedDeviceItem.getId())) {
            return;
        }
        Iterator<T> it = items.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            DeviceItem deviceItem = (DeviceItem) obj;
            if ((deviceItem.getType() == CliType.LOCAL || deviceItem.getType() == CliType.IDE) && Intrinsics.areEqual(deviceItem.getId(), selectedDeviceItem.getId())) {
                break;
            }
        }
        DeviceItem deviceItem2 = (DeviceItem) obj;
        MutableStateFlow<SelectedDeviceItem> mutableStateFlow = this._selectedDevice;
        if (deviceItem2 == null) {
            copy = new SelectedDeviceItem("", "", CliType.REMOTE, null, null, null, false, null, false, 496, null);
        } else {
            copy = selectedDeviceItem.copy((r20 & 1) != 0 ? selectedDeviceItem.id : null, (r20 & 2) != 0 ? selectedDeviceItem.name : deviceItem2.getName(), (r20 & 4) != 0 ? selectedDeviceItem.type : deviceItem2.getType(), (r20 & 8) != 0 ? selectedDeviceItem.selectedDirectory : null, (r20 & 16) != 0 ? selectedDeviceItem.ideVersion : deviceItem2.getIdeVersion(), (r20 & 32) != 0 ? selectedDeviceItem.projectId : null, (r20 & 64) != 0 ? selectedDeviceItem.isProjectAvailable : false, (r20 & 128) != 0 ? selectedDeviceItem.projectName : null, (r20 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? selectedDeviceItem.showProductType : false);
        }
        mutableStateFlow.setValue(copy);
    }

    public final void syncSelectedDeviceWithItems(List<DeviceItem> items) {
        Object obj;
        SelectedDeviceItem copy;
        Intrinsics.checkNotNullParameter(items, "items");
        SelectedDeviceItem selectedDeviceItem = (SelectedDeviceItem) this._selectedDevice.getValue();
        if (selectedDeviceItem == null || selectedDeviceItem.getType() != CliType.LOCAL || StringsKt.isBlank(selectedDeviceItem.getId())) {
            return;
        }
        Iterator<T> it = items.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            DeviceItem deviceItem = (DeviceItem) obj;
            if (deviceItem.getType() == CliType.LOCAL && Intrinsics.areEqual(deviceItem.getId(), selectedDeviceItem.getId())) {
                break;
            }
        }
        DeviceItem deviceItem2 = (DeviceItem) obj;
        MutableStateFlow<SelectedDeviceItem> mutableStateFlow = this._selectedDevice;
        if (deviceItem2 == null) {
            copy = new SelectedDeviceItem("", "", CliType.REMOTE, null, null, null, false, null, false, 496, null);
        } else {
            copy = selectedDeviceItem.copy((r20 & 1) != 0 ? selectedDeviceItem.id : null, (r20 & 2) != 0 ? selectedDeviceItem.name : deviceItem2.getName(), (r20 & 4) != 0 ? selectedDeviceItem.type : null, (r20 & 8) != 0 ? selectedDeviceItem.selectedDirectory : null, (r20 & 16) != 0 ? selectedDeviceItem.ideVersion : deviceItem2.getIdeVersion(), (r20 & 32) != 0 ? selectedDeviceItem.projectId : null, (r20 & 64) != 0 ? selectedDeviceItem.isProjectAvailable : false, (r20 & 128) != 0 ? selectedDeviceItem.projectName : null, (r20 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? selectedDeviceItem.showProductType : false);
        }
        mutableStateFlow.setValue(copy);
    }

    public final void setMode(ChatMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this._currentMode.setValue(mode);
    }

    private final void loadAnchorWindow(String anchorCreatedAtMs) {
        String str = (String) this._conversationId.getValue();
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        this.isAnchorWindowMode = true;
        this._isAnchorWindowLoading.setValue(true);
        setMessages(CollectionsKt.emptyList());
        this._hasMoreMessages.setValue(false);
        this.hasMoreNewerAnchorMessages = false;
        this.latestPrefetchMessages = null;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$loadAnchorWindow$1(this, str, anchorCreatedAtMs, null), 3, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadAnchorMessagesByCreatedAt(String str, String str2, int i, int i2, boolean z, Continuation<? super List<ChatMessage>> continuation) {
        ConversationViewModel$loadAnchorMessagesByCreatedAt$1 conversationViewModel$loadAnchorMessagesByCreatedAt$1;
        int i3;
        ConversationViewModel conversationViewModel;
        HttpDataResult.Success result;
        if (continuation instanceof ConversationViewModel$loadAnchorMessagesByCreatedAt$1) {
            conversationViewModel$loadAnchorMessagesByCreatedAt$1 = (ConversationViewModel$loadAnchorMessagesByCreatedAt$1) continuation;
            if ((conversationViewModel$loadAnchorMessagesByCreatedAt$1.label & Integer.MIN_VALUE) != 0) {
                conversationViewModel$loadAnchorMessagesByCreatedAt$1.label -= Integer.MIN_VALUE;
                ConversationViewModel$loadAnchorMessagesByCreatedAt$1 conversationViewModel$loadAnchorMessagesByCreatedAt$12 = conversationViewModel$loadAnchorMessagesByCreatedAt$1;
                Object obj = conversationViewModel$loadAnchorMessagesByCreatedAt$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = conversationViewModel$loadAnchorMessagesByCreatedAt$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    conversationViewModel$loadAnchorMessagesByCreatedAt$12.L$0 = this;
                    conversationViewModel$loadAnchorMessagesByCreatedAt$12.label = 1;
                    obj = m813x5a29967(this, str, str2, i, i2, z, null, conversationViewModel$loadAnchorMessagesByCreatedAt$12, 32, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    conversationViewModel = this;
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return null;
                    }
                    conversationViewModel = (ConversationViewModel) conversationViewModel$loadAnchorMessagesByCreatedAt$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                result = ((ListMessagesByAnchorRetryResult) obj).getResult();
                if (!(result instanceof HttpDataResult.Success)) {
                    HttpDataResult.Success success = result;
                    if (!success.getBizResp().isSuccess()) {
                        TraeLogUtil.INSTANCE.e(TAG, "loadAnchorMessagesByCreatedAt biz error: code=" + success.getBizResp().getCode() + ", msg=" + success.getBizResp().getMsg());
                        return null;
                    }
                    ListMessagesResponse listMessagesResponse = (ListMessagesResponse) success.getBizResp().getData();
                    List<ChatMessage> messages = listMessagesResponse != null ? listMessagesResponse.getMessages() : null;
                    if (messages == null) {
                        messages = CollectionsKt.emptyList();
                    }
                    return conversationViewModel.filterDisplayableMessages(messages);
                }
                if (!(result instanceof HttpDataResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                conversationViewModel$loadAnchorMessagesByCreatedAt$12.L$0 = null;
                conversationViewModel$loadAnchorMessagesByCreatedAt$12.label = 2;
                if (conversationViewModel.handleAnchorLoadError((HttpDataResult.Error) result, conversationViewModel$loadAnchorMessagesByCreatedAt$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return null;
            }
        }
        conversationViewModel$loadAnchorMessagesByCreatedAt$1 = new ConversationViewModel$loadAnchorMessagesByCreatedAt$1(this, continuation);
        ConversationViewModel$loadAnchorMessagesByCreatedAt$1 conversationViewModel$loadAnchorMessagesByCreatedAt$122 = conversationViewModel$loadAnchorMessagesByCreatedAt$1;
        Object obj2 = conversationViewModel$loadAnchorMessagesByCreatedAt$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = conversationViewModel$loadAnchorMessagesByCreatedAt$122.label;
        if (i3 != 0) {
        }
        result = ((ListMessagesByAnchorRetryResult) obj2).getResult();
        if (!(result instanceof HttpDataResult.Success)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00b4 -> B:17:0x00c0). Please report as a decompilation issue!!! */
    /* renamed from: loadMessagesByAnchorRawWithLargeFileRetry$conversation_mainlandRelease */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m814x9d11ddca(String str, String str2, int i, int i2, boolean z, Function2<? super ListMessagesByAnchorRequest, ? super Continuation<? super HttpDataResult<ListMessagesResponse>>, ? extends Object> function2, Continuation<? super ListMessagesByAnchorRetryResult> continuation) {
        C0632xa56e9acb c0632xa56e9acb;
        ConversationViewModel conversationViewModel;
        int i3;
        int i4;
        boolean z2;
        Function2<? super ListMessagesByAnchorRequest, ? super Continuation<? super HttpDataResult<ListMessagesResponse>>, ? extends Object> function22;
        Iterator<ListMessagesByAnchorRequest> it;
        C0632xa56e9acb c0632xa56e9acb2;
        ConversationViewModel conversationViewModel2;
        Object obj;
        ListMessagesByAnchorRetryResult listMessagesByAnchorRetryResult;
        String str3;
        String str4;
        int i5;
        ListMessagesByAnchorRequest listMessagesByAnchorRequest;
        if (continuation instanceof C0632xa56e9acb) {
            c0632xa56e9acb = (C0632xa56e9acb) continuation;
            if ((c0632xa56e9acb.label & Integer.MIN_VALUE) != 0) {
                c0632xa56e9acb.label -= Integer.MIN_VALUE;
                conversationViewModel = this;
                Object obj2 = c0632xa56e9acb.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = c0632xa56e9acb.label;
                int i6 = 1;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    i4 = i2;
                    z2 = z;
                    function22 = function2;
                    it = buildListMessagesLargeFileRetryRequests(str, str2, i, i2, z).iterator();
                    c0632xa56e9acb2 = c0632xa56e9acb;
                    conversationViewModel2 = conversationViewModel;
                    obj = coroutine_suspended;
                    listMessagesByAnchorRetryResult = null;
                    str3 = str;
                    str4 = str2;
                    i5 = i;
                    if (it.hasNext()) {
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        listMessagesByAnchorRequest = (ListMessagesByAnchorRequest) c0632xa56e9acb.L$0;
                        ResultKt.throwOnFailure(obj2);
                        return new ListMessagesByAnchorRetryResult((HttpDataResult) obj2, listMessagesByAnchorRequest);
                    }
                    boolean z3 = c0632xa56e9acb.Z$0;
                    int i7 = c0632xa56e9acb.I$1;
                    int i8 = c0632xa56e9acb.I$0;
                    ListMessagesByAnchorRequest listMessagesByAnchorRequest2 = (ListMessagesByAnchorRequest) c0632xa56e9acb.L$5;
                    Iterator<ListMessagesByAnchorRequest> it2 = (Iterator) c0632xa56e9acb.L$4;
                    Function2<? super ListMessagesByAnchorRequest, ? super Continuation<? super HttpDataResult<ListMessagesResponse>>, ? extends Object> function23 = (Function2) c0632xa56e9acb.L$3;
                    String str5 = (String) c0632xa56e9acb.L$2;
                    String str6 = (String) c0632xa56e9acb.L$1;
                    conversationViewModel2 = (ConversationViewModel) c0632xa56e9acb.L$0;
                    ResultKt.throwOnFailure(obj2);
                    C0632xa56e9acb c0632xa56e9acb3 = c0632xa56e9acb;
                    str4 = str5;
                    Iterator<ListMessagesByAnchorRequest> it3 = it2;
                    Object obj3 = coroutine_suspended;
                    i5 = i8;
                    z2 = z3;
                    i4 = i7;
                    function22 = function23;
                    HttpDataResult<ListMessagesResponse> httpDataResult = (HttpDataResult) obj2;
                    ListMessagesByAnchorRetryResult listMessagesByAnchorRetryResult2 = new ListMessagesByAnchorRetryResult(httpDataResult, listMessagesByAnchorRequest2);
                    if (conversationViewModel2.isDownloadFileTooLargeBizError(httpDataResult)) {
                        return listMessagesByAnchorRetryResult2;
                    }
                    c0632xa56e9acb2 = c0632xa56e9acb3;
                    obj = obj3;
                    it = it3;
                    str3 = str6;
                    listMessagesByAnchorRetryResult = listMessagesByAnchorRetryResult2;
                    i6 = 1;
                    if (it.hasNext()) {
                        if (listMessagesByAnchorRetryResult != null) {
                            return listMessagesByAnchorRetryResult;
                        }
                        ListMessagesByAnchorRequest listMessagesByAnchorRequest3 = new ListMessagesByAnchorRequest(str3, str4, i5, i4, z2);
                        c0632xa56e9acb2.L$0 = listMessagesByAnchorRequest3;
                        c0632xa56e9acb2.L$1 = null;
                        c0632xa56e9acb2.L$2 = null;
                        c0632xa56e9acb2.L$3 = null;
                        c0632xa56e9acb2.L$4 = null;
                        c0632xa56e9acb2.L$5 = null;
                        c0632xa56e9acb2.label = 2;
                        obj2 = function22.invoke(listMessagesByAnchorRequest3, c0632xa56e9acb2);
                        if (obj2 == obj) {
                            return obj;
                        }
                        listMessagesByAnchorRequest = listMessagesByAnchorRequest3;
                        return new ListMessagesByAnchorRetryResult((HttpDataResult) obj2, listMessagesByAnchorRequest);
                    }
                    ListMessagesByAnchorRequest next = it.next();
                    c0632xa56e9acb2.L$0 = conversationViewModel2;
                    c0632xa56e9acb2.L$1 = str3;
                    c0632xa56e9acb2.L$2 = str4;
                    c0632xa56e9acb2.L$3 = function22;
                    c0632xa56e9acb2.L$4 = it;
                    c0632xa56e9acb2.L$5 = next;
                    c0632xa56e9acb2.I$0 = i5;
                    c0632xa56e9acb2.I$1 = i4;
                    c0632xa56e9acb2.Z$0 = z2;
                    c0632xa56e9acb2.label = i6;
                    Object invoke = function22.invoke(next, c0632xa56e9acb2);
                    if (invoke == obj) {
                        return obj;
                    }
                    str6 = str3;
                    obj2 = invoke;
                    Object obj4 = obj;
                    c0632xa56e9acb3 = c0632xa56e9acb2;
                    listMessagesByAnchorRequest2 = next;
                    it3 = it;
                    obj3 = obj4;
                    HttpDataResult<ListMessagesResponse> httpDataResult2 = (HttpDataResult) obj2;
                    ListMessagesByAnchorRetryResult listMessagesByAnchorRetryResult22 = new ListMessagesByAnchorRetryResult(httpDataResult2, listMessagesByAnchorRequest2);
                    if (conversationViewModel2.isDownloadFileTooLargeBizError(httpDataResult2)) {
                    }
                }
            }
        }
        conversationViewModel = this;
        c0632xa56e9acb = new C0632xa56e9acb(conversationViewModel, continuation);
        Object obj22 = c0632xa56e9acb.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = c0632xa56e9acb.label;
        int i62 = 1;
        if (i3 != 0) {
        }
    }

    /* renamed from: loadMessagesByAnchorRawWithLargeFileRetry$conversation_mainlandRelease$default */
    public static /* synthetic */ Object m813x5a29967(ConversationViewModel conversationViewModel, String str, String str2, int i, int i2, boolean z, Function2 function2, Continuation continuation, int i3, Object obj) {
        return conversationViewModel.m814x9d11ddca(str, str2, i, i2, z, (i3 & 32) != 0 ? new C0633xa56e9acc(null) : function2, continuation);
    }

    private final List<ListMessagesByAnchorRequest> buildListMessagesLargeFileRetryRequests(String conversationId, String anchorCreatedAtMs, int beforeLimit, int afterLimit, boolean includeAnchor) {
        List listOf;
        if (beforeLimit > 0 && afterLimit > 0) {
            listOf = CollectionsKt.listOf(new Pair[]{TuplesKt.to(Integer.valueOf(beforeLimit), Integer.valueOf(afterLimit)), TuplesKt.to(3, 3), TuplesKt.to(1, 1), TuplesKt.to(1, 0)});
        } else if (beforeLimit > 0) {
            listOf = CollectionsKt.listOf(new Pair[]{TuplesKt.to(Integer.valueOf(beforeLimit), Integer.valueOf(afterLimit)), TuplesKt.to(6, 0), TuplesKt.to(2, 0), TuplesKt.to(1, 0)});
        } else if (afterLimit > 0) {
            listOf = CollectionsKt.listOf(new Pair[]{TuplesKt.to(Integer.valueOf(beforeLimit), Integer.valueOf(afterLimit)), TuplesKt.to(0, 6), TuplesKt.to(0, 2), TuplesKt.to(0, 1)});
        } else {
            listOf = CollectionsKt.listOf(TuplesKt.to(Integer.valueOf(beforeLimit), Integer.valueOf(afterLimit)));
        }
        List<Pair> distinct = CollectionsKt.distinct(listOf);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(distinct, 10));
        for (Pair pair : distinct) {
            arrayList.add(new ListMessagesByAnchorRequest(conversationId, anchorCreatedAtMs, ((Number) pair.component1()).intValue(), ((Number) pair.component2()).intValue(), includeAnchor));
        }
        return arrayList;
    }

    private final boolean isDownloadFileTooLargeBizError(HttpDataResult<ListMessagesResponse> httpDataResult) {
        if (!(httpDataResult instanceof HttpDataResult.Success)) {
            return false;
        }
        HttpDataResult.Success success = (HttpDataResult.Success) httpDataResult;
        if (success.getBizResp().getCode() != 0) {
            return false;
        }
        String msg = success.getBizResp().getMsg();
        return msg != null && StringsKt.contains(msg, DOWNLOAD_FILE_TOO_LARGE_MESSAGE, true);
    }

    public final Object handleAnchorLoadError(HttpDataResult.Error error, Continuation<? super Unit> continuation) {
        TraeLogUtil.INSTANCE.e(TAG, "loadAnchorWindow: API error, code=" + error.getCode() + ", msg=" + error.getMsg(), error.getThrowable());
        if (error.getCode() == 401) {
            Object emit = this._forceLogout.emit(Unit.INSTANCE, continuation);
            return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
        }
        if (((List) this._messages.getValue()).isEmpty()) {
            this._loadError.setValue(Boxing.boxBoolean(true));
        }
        return Unit.INSTANCE;
    }

    public final boolean exitAnchorWindowAndLoadLatest() {
        String str = (String) this._conversationId.getValue();
        if (this.isAnchorWindowMode) {
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                resetAnchorWindowState();
                LatestPrefetchMessages latestPrefetchMessages = this.latestPrefetchMessages;
                if (latestPrefetchMessages != null) {
                    setMessages(latestPrefetchMessages.getMessages());
                    this._hasMoreMessages.setValue(Boolean.valueOf(hasMoreHistoryPage$conversation_mainlandRelease(latestPrefetchMessages.getMessages().size(), latestPrefetchMessages.getPageLimit())));
                } else {
                    setMessages(CollectionsKt.emptyList());
                    loadMessages(str);
                }
                return true;
            }
        }
        return false;
    }

    private final void resetAnchorWindowState() {
        this.isAnchorWindowMode = false;
        this._isAnchorWindowLoading.setValue(false);
        this.hasMoreNewerAnchorMessages = false;
        this._hasMoreMessages.setValue(true);
        this._isLoadingMore.setValue(false);
        this.isLoadingNewerAnchorMessages = false;
    }

    public final void prefetchLatestMessages(String conversationId) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$prefetchLatestMessages$1(this, conversationId, null), 3, (Object) null);
    }

    public final String resolveParentAgentTypeForSubTask(Mode mode, CliType cliType) {
        Object obj;
        String agentType;
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Iterator it = CollectionsKt.asReversed((List) this._messages.getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            String agentType2 = ((ParsedChatMessage) obj).getAgentType();
            String str = agentType2;
            boolean z = false;
            if (!(str == null || StringsKt.isBlank(str)) && !Intrinsics.areEqual(agentType2, BrainstormSummaryRepository.AGENT_TYPE_VOICE_SUMMARY)) {
                z = true;
            }
            if (z) {
                break;
            }
        }
        ParsedChatMessage parsedChatMessage = (ParsedChatMessage) obj;
        if (parsedChatMessage != null && (agentType = parsedChatMessage.getAgentType()) != null) {
            String str2 = StringsKt.isBlank(agentType) ^ true ? agentType : null;
            if (str2 != null) {
                return str2;
            }
        }
        return AgentResolver.INSTANCE.resolveDefaultAgentType(mode, cliType);
    }

    public final void loadMessages(String conversationId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        TraeLogUtil.INSTANCE.d(TAG, "loadMessages: start, conversationId=" + conversationId);
        if (!this.isAnchorWindowMode) {
            this.hasMoreNewerAnchorMessages = false;
            this.latestPrefetchMessages = null;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$loadMessages$1(this, conversationId, null), 3, (Object) null);
    }

    public final void retryLoad() {
        this._loadError.setValue(false);
        String str = (String) this._conversationId.getValue();
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        loadMessages(str);
    }

    public final void dismissUpgradeReminder(String conversationId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        UpgradeReminderDismissStore.INSTANCE.markDismissed(conversationId);
        this.pendingUpgradeReminderRefresh = null;
        this._upgradeReminder.setValue(new UpgradeReminderUiState(conversationId, false));
    }

    public final void onMessageListCommitComplete() {
        this.isMessageListCommitPendingForUpgradeReminder = false;
        flushPendingUpgradeReminderIfAllowed();
    }

    public final void updateUpgradeReminder(List<ParsedChatMessage> messages) {
        String str = (String) this._conversationId.getValue();
        if (str != null) {
            if (!(!StringsKt.isBlank(str))) {
                str = null;
            }
            if (str == null) {
                return;
            }
            Long l = (Long) SequencesKt.maxOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(messages), new Function1() { // from class: com.bytedance.trae.conversation.ConversationViewModel$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Long updateUpgradeReminder$lambda$23;
                    updateUpgradeReminder$lambda$23 = ConversationViewModel.updateUpgradeReminder$lambda$23((ParsedChatMessage) obj);
                    return updateUpgradeReminder$lambda$23;
                }
            }));
            if (l != null) {
                long longValue = l.longValue();
                UpgradeReminderConfig config = UpgradeReminderSettings.INSTANCE.getConfig();
                boolean z = config != null && config.getEnabled() && config.getRecommendedHighest() < longValue && !UpgradeReminderDismissStore.INSTANCE.isDismissed(str);
                if (z && shouldDeferUpgradeReminder()) {
                    this.pendingUpgradeReminderRefresh = new PendingUpgradeReminderRefresh(str, messages);
                    return;
                } else {
                    this.pendingUpgradeReminderRefresh = null;
                    this._upgradeReminder.setValue(new UpgradeReminderUiState(str, z));
                    return;
                }
            }
            this.pendingUpgradeReminderRefresh = null;
            this._upgradeReminder.setValue(new UpgradeReminderUiState(str, false));
        }
    }

    public static final Long updateUpgradeReminder$lambda$23(ParsedChatMessage parsedChatMessage) {
        Intrinsics.checkNotNullParameter(parsedChatMessage, "it");
        Long versionCode = parsedChatMessage.getVersionCode();
        if (versionCode != null) {
            if (versionCode.longValue() > 0) {
                return versionCode;
            }
        }
        return null;
    }

    public final void flushPendingUpgradeReminderIfAllowed() {
        PendingUpgradeReminderRefresh pendingUpgradeReminderRefresh = this.pendingUpgradeReminderRefresh;
        if (pendingUpgradeReminderRefresh == null) {
            return;
        }
        if (!Intrinsics.areEqual(this._conversationId.getValue(), pendingUpgradeReminderRefresh.getConversationId())) {
            this.pendingUpgradeReminderRefresh = null;
        } else {
            if (shouldDeferUpgradeReminder()) {
                return;
            }
            this.pendingUpgradeReminderRefresh = null;
            updateUpgradeReminder(pendingUpgradeReminderRefresh.getMessages());
        }
    }

    private final boolean shouldDeferUpgradeReminder() {
        if (this.isTaskRunning || this._sessionTurnStatus.getValue() == SessionTurnStatus.STREAMING) {
            return true;
        }
        Job job = this.createTaskJob;
        if ((job != null && job.isActive()) || this.isUserMessagePending || this.pendingStreamingMessage != null) {
            return true;
        }
        Job job2 = this.streamingTrailingJob;
        return (job2 != null && job2.isActive()) || this.isMessageListCommitPendingForUpgradeReminder;
    }

    public final void refreshMessagesOnResume() {
        String str = (String) this._conversationId.getValue();
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$refreshMessagesOnResume$1(this, str, null), 3, (Object) null);
    }

    public final void loadMoreMessages(Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        if (((Boolean) this._isLoadingMore.getValue()).booleanValue()) {
            TraeLogUtil.INSTANCE.d(TAG, "loadMoreMessages: skip, already loading");
            onComplete.invoke();
            return;
        }
        String str = (String) this._conversationId.getValue();
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            TraeLogUtil.INSTANCE.d(TAG, "loadMoreMessages: skip, conversationId is null");
            this._hasMoreMessages.setValue(false);
            onComplete.invoke();
            return;
        }
        ParsedChatMessage parsedChatMessage = (ParsedChatMessage) CollectionsKt.firstOrNull((List) this._messages.getValue());
        Long valueOf = parsedChatMessage != null ? Long.valueOf(parsedChatMessage.getCreatedAt()) : null;
        if (valueOf == null) {
            TraeLogUtil.INSTANCE.d(TAG, "loadMoreMessages: skip, no anchor created_at_ms");
            this._hasMoreMessages.setValue(false);
            onComplete.invoke();
        } else if (!((Boolean) this._hasMoreMessages.getValue()).booleanValue()) {
            TraeLogUtil.INSTANCE.d(TAG, "loadMoreMessages: skip, hasMoreMessages=false");
            onComplete.invoke();
        } else {
            TraeLogUtil.INSTANCE.d(TAG, "loadMoreMessages: start, conversationId=" + str + ", anchorCreatedAtMs=" + valueOf);
            this._isLoadingMore.setValue(true);
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$loadMoreMessages$1(this, str, valueOf, onComplete, null), 3, (Object) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadNewerAnchorMessages$default(ConversationViewModel conversationViewModel, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new Function0() { // from class: com.bytedance.trae.conversation.ConversationViewModel$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        conversationViewModel.loadNewerAnchorMessages(function0);
    }

    public final void loadNewerAnchorMessages(Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        if (!this.isAnchorWindowMode || this.isLoadingNewerAnchorMessages) {
            onComplete.invoke();
            return;
        }
        String str = (String) this._conversationId.getValue();
        ParsedChatMessage parsedChatMessage = (ParsedChatMessage) CollectionsKt.lastOrNull((List) this._messages.getValue());
        Long valueOf = parsedChatMessage != null ? Long.valueOf(parsedChatMessage.getCreatedAt()) : null;
        String str2 = str;
        if ((str2 == null || str2.length() == 0) || valueOf == null || !this.hasMoreNewerAnchorMessages) {
            onComplete.invoke();
        } else {
            this.isLoadingNewerAnchorMessages = true;
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$loadNewerAnchorMessages$2(this, str, valueOf, onComplete, null), 3, (Object) null);
        }
    }

    public final List<ChatMessage> filterDisplayableMessages(List<ChatMessage> list) {
        List<ParsedChatMessage> parseDisplayableHistoryList = ChatMessageParser.INSTANCE.parseDisplayableHistoryList(list);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parseDisplayableHistoryList, 10));
        Iterator<T> it = parseDisplayableHistoryList.iterator();
        while (it.hasNext()) {
            arrayList.add(((ParsedChatMessage) it.next()).getMessageId());
        }
        Set set = CollectionsKt.toSet(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (CollectionsKt.contains(set, ((ChatMessage) obj).getMessageId())) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public final List<ParsedChatMessage> toParsedHistoryMessages(List<ChatMessage> list) {
        return ChatMessageParser.INSTANCE.parseDisplayableHistoryList(list);
    }

    public final List<ParsedChatMessage> mergeMessages(List<ParsedChatMessage> currentMessages, List<ParsedChatMessage> newMessages) {
        return ConversationMessageStateReducer.INSTANCE.sortMessages(CollectionsKt.plus(currentMessages, newMessages));
    }

    public final void upsertMessages(List<ParsedChatMessage> newMessages) {
        if (newMessages.isEmpty()) {
            return;
        }
        Set<String> set = this.runtimeMessageIds;
        List<ParsedChatMessage> list = newMessages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ParsedChatMessage) it.next()).getMessageId());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        set.addAll(arrayList2);
        setMessages(mergeMessagesIntoState((List) this._messages.getValue(), newMessages));
    }

    public final void replaceMessagesPreservingRuntime(List<ParsedChatMessage> historyMessages) {
        Iterable iterable = (Iterable) this._messages.getValue();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (this.runtimeMessageIds.contains(((ParsedChatMessage) obj).getMessageId())) {
                arrayList.add(obj);
            }
        }
        setMessages(mergeMessagesIntoState(arrayList, historyMessages));
        Iterable iterable2 = (Iterable) this._messages.getValue();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ParsedChatMessage) it.next()).getMessageId());
        }
        Set set = CollectionsKt.toSet(arrayList2);
        Set<String> set2 = this.runtimeMessageIds;
        List<ParsedChatMessage> list = historyMessages;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((ParsedChatMessage) it2.next()).getMessageId());
        }
        set2.removeAll(CollectionsKt.toSet(arrayList3));
        this.runtimeMessageIds.retainAll(set);
    }

    public final List<ParsedChatMessage> mergeMessagesIntoState(List<ParsedChatMessage> currentMessages, List<ParsedChatMessage> newMessages) {
        return ConversationMessageStateReducer.INSTANCE.mergeMessages(currentMessages, newMessages, new Function2() { // from class: com.bytedance.trae.conversation.ConversationViewModel$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                Unit mergeMessagesIntoState$lambda$33;
                mergeMessagesIntoState$lambda$33 = ConversationViewModel.mergeMessagesIntoState$lambda$33(ConversationViewModel.this, (String) obj, (ParsedChatMessage) obj2);
                return mergeMessagesIntoState$lambda$33;
            }
        });
    }

    public static final Unit mergeMessagesIntoState$lambda$33(ConversationViewModel conversationViewModel, String str, ParsedChatMessage parsedChatMessage) {
        Intrinsics.checkNotNullParameter(str, "oldMessageId");
        Intrinsics.checkNotNullParameter(parsedChatMessage, "fixedMessage");
        if (conversationViewModel.runtimeMessageIds.remove(str)) {
            conversationViewModel.runtimeMessageIds.add(parsedChatMessage.getMessageId());
        }
        conversationViewModel.onUserMessageFixup(str, parsedChatMessage);
        return Unit.INSTANCE;
    }

    public final void deleteMessageAndReplies(String conversationId, String messageId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        deleteMessagesAndReplies(conversationId, CollectionsKt.listOf(messageId));
    }

    public final void deleteMessagesAndReplies(String conversationId, Collection<String> messageIds) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageIds, "messageIds");
        if (Intrinsics.areEqual(conversationId, this._conversationId.getValue())) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : messageIds) {
                if (true ^ StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            Set set = CollectionsKt.toSet(arrayList);
            if (set.isEmpty()) {
                return;
            }
            List<ParsedChatMessage> list = (List) this._messages.getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list) {
                ParsedChatMessage parsedChatMessage = (ParsedChatMessage) obj2;
                if ((set.contains(parsedChatMessage.getMessageId()) || CollectionsKt.contains(set, parsedChatMessage.getReplyToMessageId())) ? false : true) {
                    arrayList2.add(obj2);
                }
            }
            updateMessagesAfterDeletion(conversationId, list, arrayList2);
        }
    }

    public final void revertMessageAndFollowingUsers(String conversationId, String messageId, ParsedChatMessage revertedMessage) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        if (Intrinsics.areEqual(conversationId, this._conversationId.getValue())) {
            List<ParsedChatMessage> list = (List) this._messages.getValue();
            long createdAt = revertedMessage != null ? revertedMessage.getCreatedAt() : Long.MAX_VALUE;
            List<ParsedChatMessage> list2 = list;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ParsedChatMessage parsedChatMessage = (ParsedChatMessage) next;
                if (parsedChatMessage.isUserMessage() && parsedChatMessage.getCreatedAt() > createdAt) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((ParsedChatMessage) it2.next()).getMessageId());
            }
            Set set = CollectionsKt.toSet(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            for (Object obj : list2) {
                ParsedChatMessage parsedChatMessage2 = (ParsedChatMessage) obj;
                if ((Intrinsics.areEqual(parsedChatMessage2.getMessageId(), messageId) || Intrinsics.areEqual(parsedChatMessage2.getReplyToMessageId(), messageId) || set.contains(parsedChatMessage2.getMessageId()) || CollectionsKt.contains(set, parsedChatMessage2.getReplyToMessageId())) ? false : true) {
                    arrayList4.add(obj);
                }
            }
            updateMessagesAfterDeletion(conversationId, list, arrayList4);
        }
    }

    private final void updateMessagesAfterDeletion(String conversationId, List<ParsedChatMessage> currentMessages, List<ParsedChatMessage> filteredMessages) {
        List<ParsedChatMessage> list = filteredMessages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ParsedChatMessage) it.next()).getMessageId());
        }
        Set set = CollectionsKt.toSet(arrayList);
        List<ParsedChatMessage> list2 = currentMessages;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((ParsedChatMessage) it2.next()).getMessageId());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (!set.contains((String) obj)) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = arrayList3;
        setMessages(ConversationMessageStateReducer.INSTANCE.sortMessages(filteredMessages));
        this.runtimeMessageIds.removeAll(CollectionsKt.toSet(arrayList4));
        deleteCachedMessages(conversationId, arrayList4);
    }

    public final boolean hasLoadedOlderSide(List<ParsedChatMessage> messages, String anchorCreatedAtMs, int expectedCount) {
        int i;
        Long longOrNull = StringsKt.toLongOrNull(anchorCreatedAtMs);
        if (longOrNull == null) {
            return false;
        }
        long longValue = longOrNull.longValue();
        List<ParsedChatMessage> list = messages;
        if ((list instanceof Collection) && list.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                if ((((ParsedChatMessage) it.next()).getCreatedAt() < longValue) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i >= expectedCount;
    }

    public final boolean hasLoadedNewerSide(List<ParsedChatMessage> messages, String anchorCreatedAtMs, int expectedCount) {
        int i;
        Long longOrNull = StringsKt.toLongOrNull(anchorCreatedAtMs);
        if (longOrNull == null) {
            return false;
        }
        long longValue = longOrNull.longValue();
        List<ParsedChatMessage> list = messages;
        if ((list instanceof Collection) && list.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                if ((((ParsedChatMessage) it.next()).getCreatedAt() > longValue) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i >= expectedCount;
    }

    public final void renameConversation(String newTitle) {
        Intrinsics.checkNotNullParameter(newTitle, "newTitle");
        String str = (String) this._conversationId.getValue();
        if (str == null) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$renameConversation$1(str, newTitle, this, null), 3, (Object) null);
    }

    public final void deleteConversation() {
        String str = (String) this._conversationId.getValue();
        if (str == null) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$deleteConversation$1(str, this, null), 3, (Object) null);
    }

    public final void updateConversation(Conversation conversation) {
        Conversation copy;
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        String str = (String) this._conversationId.getValue();
        String id = conversation.getId();
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            String str3 = id;
            if (!(str3 == null || str3.length() == 0) && !Intrinsics.areEqual(str, id)) {
                return;
            }
        }
        if (str2 == null || str2.length() == 0) {
            String str4 = id;
            if (!(str4 == null || str4.length() == 0)) {
                this._conversationId.setValue(id);
            }
        }
        Conversation conversation2 = (Conversation) this._conversation.getValue();
        String environment = conversation2 != null ? conversation2.getEnvironment() : null;
        String value = Intrinsics.areEqual(environment, CliType.IDE.getValue()) ? Mode.CODE.getValue() : null;
        if (environment == null) {
            environment = conversation.getEnvironment();
        }
        copy = conversation.copy((r44 & 1) != 0 ? conversation.id : null, (r44 & 2) != 0 ? conversation.parentConversationId : null, (r44 & 4) != 0 ? conversation.hiddenStatus : null, (r44 & 8) != 0 ? conversation.cliConversationId : null, (r44 & 16) != 0 ? conversation.userId : null, (r44 & 32) != 0 ? conversation.cliId : null, (r44 & 64) != 0 ? conversation.title : null, (r44 & 128) != 0 ? conversation.workspace : null, (r44 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? conversation.gitUri : null, (r44 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? conversation.mode : value == null ? conversation.getMode() : value, (r44 & 1024) != 0 ? conversation.status : null, (r44 & 2048) != 0 ? conversation.environment : environment, (r44 & 4096) != 0 ? conversation.latestTaskId : null, (r44 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? conversation.latestTaskStatus : null, (r44 & 16384) != 0 ? conversation.latestTaskUpdateTime : null, (r44 & 32768) != 0 ? conversation.createdAt : null, (r44 & 65536) != 0 ? conversation.updatedAt : null, (r44 & 131072) != 0 ? conversation.source : null, (r44 & 262144) != 0 ? conversation.iconType : null, (r44 & FConstants.SLICE_SIZE) != 0 ? conversation.cliConversationStatus : null, (r44 & 1048576) != 0 ? conversation.ownerProjectId : null, (r44 & 2097152) != 0 ? conversation.latestProjectId : null, (r44 & 4194304) != 0 ? conversation.ownerProjectAbsolutePath : null, (r44 & 8388608) != 0 ? conversation.ownerProjectWorkSpaceStatus : null, (r44 & 16777216) != 0 ? conversation.isPinned : null, (r44 & 33554432) != 0 ? conversation.pinnedAt : null);
        this._conversation.setValue(copy);
        initSelectedDevice(copy);
    }

    public final boolean supportsPin() {
        String str;
        Object obj;
        String ideVersion;
        Conversation conversation = (Conversation) this._conversation.getValue();
        if (conversation == null) {
            return false;
        }
        boolean z = !Intrinsics.areEqual(conversation.getDisplayEnvironment(), CliType.REMOTE.getValue());
        Iterator<T> it = CliListRepository.INSTANCE.getInstance().getCacheClis().iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Cli) obj).getId(), conversation.getCliId())) {
                break;
            }
        }
        Cli cli = (Cli) obj;
        if (cli == null || (ideVersion = cli.getIdeVersion()) == null) {
            SelectedDeviceItem selectedDeviceItem = (SelectedDeviceItem) this.selectedDevice.getValue();
            if (selectedDeviceItem != null) {
                if (!Intrinsics.areEqual(selectedDeviceItem.getId(), conversation.getCliId())) {
                    selectedDeviceItem = null;
                }
                if (selectedDeviceItem != null) {
                    str = selectedDeviceItem.getIdeVersion();
                }
            }
        } else {
            str = ideVersion;
        }
        return TaskPinCapability.INSTANCE.isSupported(z, str);
    }

    public final void pinConversation() {
        performPinAction(true);
    }

    public final void unpinConversation() {
        performPinAction(false);
    }

    private final void performPinAction(boolean shouldPin) {
        String str = (String) this._conversationId.getValue();
        if (str == null) {
            Conversation conversation = (Conversation) this._conversation.getValue();
            str = conversation != null ? conversation.getId() : null;
            if (str == null) {
                return;
            }
        }
        if (supportsPin()) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$performPinAction$1(shouldPin, str, this, null), 3, (Object) null);
        }
    }

    public final void applyPinSuccess(String conversationId, boolean shouldPin, PinConversationResponse data) {
        Conversation conversation;
        Boolean isPinned;
        boolean booleanValue = (data == null || (isPinned = data.isPinned()) == null) ? shouldPin : isPinned.booleanValue();
        if (booleanValue) {
            r2 = data != null ? data.getPinnedAt() : null;
            if (r2 == null) {
                r2 = "";
            }
        }
        String str = r2;
        if (data == null || (conversation = data.getConversation()) == null) {
            Conversation conversation2 = (Conversation) this._conversation.getValue();
            if (conversation2 != null) {
                conversation = conversation2.copy((r44 & 1) != 0 ? conversation2.id : null, (r44 & 2) != 0 ? conversation2.parentConversationId : null, (r44 & 4) != 0 ? conversation2.hiddenStatus : null, (r44 & 8) != 0 ? conversation2.cliConversationId : null, (r44 & 16) != 0 ? conversation2.userId : null, (r44 & 32) != 0 ? conversation2.cliId : null, (r44 & 64) != 0 ? conversation2.title : null, (r44 & 128) != 0 ? conversation2.workspace : null, (r44 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? conversation2.gitUri : null, (r44 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? conversation2.mode : null, (r44 & 1024) != 0 ? conversation2.status : null, (r44 & 2048) != 0 ? conversation2.environment : null, (r44 & 4096) != 0 ? conversation2.latestTaskId : null, (r44 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? conversation2.latestTaskStatus : null, (r44 & 16384) != 0 ? conversation2.latestTaskUpdateTime : null, (r44 & 32768) != 0 ? conversation2.createdAt : null, (r44 & 65536) != 0 ? conversation2.updatedAt : null, (r44 & 131072) != 0 ? conversation2.source : null, (r44 & 262144) != 0 ? conversation2.iconType : null, (r44 & FConstants.SLICE_SIZE) != 0 ? conversation2.cliConversationStatus : null, (r44 & 1048576) != 0 ? conversation2.ownerProjectId : null, (r44 & 2097152) != 0 ? conversation2.latestProjectId : null, (r44 & 4194304) != 0 ? conversation2.ownerProjectAbsolutePath : null, (r44 & 8388608) != 0 ? conversation2.ownerProjectWorkSpaceStatus : null, (r44 & 16777216) != 0 ? conversation2.isPinned : Boolean.valueOf(booleanValue), (r44 & 33554432) != 0 ? conversation2.pinnedAt : str);
            } else {
                conversation = new Conversation(conversationId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(booleanValue), str, 16777214, null);
            }
        }
        updateConversation(conversation);
        IMService iMService = IMService.INSTANCE;
        String id = conversation.getId();
        if (id == null) {
            id = conversationId;
        }
        iMService.notifyConversationChanged(new IMService.ConversationChangeEvent("update", id, conversation));
    }

    public final int pinFailureString(boolean shouldPin) {
        if (shouldPin) {
            return com.bytedance.trae.multilanguage.R.string.trae_conversation_toast_pin_failed;
        }
        return com.bytedance.trae.multilanguage.R.string.trae_conversation_toast_unpin_failed;
    }

    public final int pinSuccessString(boolean shouldPin) {
        if (shouldPin) {
            return com.bytedance.trae.multilanguage.R.string.trae_conversation_toast_pin_success;
        }
        return com.bytedance.trae.multilanguage.R.string.trae_conversation_toast_unpin_success;
    }

    public final void onUserMessageFixup(String oldMessageId, ParsedChatMessage newMessage) {
        Intrinsics.checkNotNullParameter(oldMessageId, "oldMessageId");
        Intrinsics.checkNotNullParameter(newMessage, "newMessage");
        String str = (String) this._conversationId.getValue();
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new ConversationViewModel$onUserMessageFixup$1(this, str, oldMessageId, newMessage, null), 2, (Object) null);
    }

    public static /* synthetic */ void handleBrainstormResult$default(ConversationViewModel conversationViewModel, String str, Mode mode, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = null;
        }
        conversationViewModel.handleBrainstormResult(str, mode, str2, str3);
    }

    public final void handleBrainstormResult(String messagesText, Mode mode, String cliConversationId, String targetConversationId) {
        Intrinsics.checkNotNullParameter(messagesText, "messagesText");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(cliConversationId, "cliConversationId");
        sendMessageIternal(messagesText, new SummaryMessagePart(messagesText).toJsonArray(), mode, BrainstormSummaryRepository.AGENT_TYPE_VOICE_SUMMARY, null, false, BrainstormSummaryRepository.AGENT_TYPE_SELECT_MODEL_NAME, cliConversationId, targetConversationId);
    }

    public static /* synthetic */ void sendMessage$default(ConversationViewModel conversationViewModel, String str, String str2, Mode mode, RemoteModelItem remoteModelItem, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            remoteModelItem = null;
        }
        RemoteModelItem remoteModelItem2 = remoteModelItem;
        if ((i & 16) != 0) {
            z = false;
        }
        conversationViewModel.sendMessage(str, str2, mode, remoteModelItem2, z);
    }

    public final void sendMessage(String text, String query, Mode mode, RemoteModelItem selectedModel, boolean useFastRequest) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(mode, "mode");
        SelectedDeviceItem selectedDeviceItem = (SelectedDeviceItem) this._selectedDevice.getValue();
        if (selectedDeviceItem == null) {
            return;
        }
        sendMessageIternal$default(this, text, query, mode, AgentResolver.INSTANCE.resolveDefaultAgentType(mode, selectedDeviceItem.getType()), selectedModel, useFastRequest, null, null, null, 448, null);
    }

    public static /* synthetic */ void sendMessageIternal$default(ConversationViewModel conversationViewModel, String str, String str2, Mode mode, String str3, RemoteModelItem remoteModelItem, boolean z, String str4, String str5, String str6, int i, Object obj) {
        conversationViewModel.sendMessageIternal(str, str2, mode, str3, (i & 16) != 0 ? null : remoteModelItem, (i & 32) != 0 ? false : z, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : str6);
    }

    public final void sendMessageIternal(String text, String query, Mode mode, String agentType, RemoteModelItem selectedModel, boolean useFastRequest, String selectedModelName, String cliConversationId, String targetConversationId) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(agentType, "agentType");
        Job job = this.createTaskJob;
        boolean z = false;
        if (job != null && job.isActive()) {
            z = true;
        }
        if (z) {
            TraeLogUtil.INSTANCE.w(TAG, "sendMessageIternal: skipped, task creation already in progress");
            return;
        }
        this._sessionTurnStatus.setValue(SessionTurnStatus.IDLE);
        SelectedDeviceItem selectedDeviceItem = (SelectedDeviceItem) this._selectedDevice.getValue();
        if (selectedDeviceItem == null) {
            return;
        }
        SelectedDeviceItem recoverHistoricalIdeProjectDevice = recoverHistoricalIdeProjectDevice(selectedDeviceItem);
        CreateTaskWorkspaceFields fromDevice = CreateTaskWorkspacePolicy.INSTANCE.fromDevice(recoverHistoricalIdeProjectDevice);
        if (this.isNewConversation && CreateTaskWorkspacePolicy.INSTANCE.requiresWorkspace(recoverHistoricalIdeProjectDevice) && fromDevice.getWorkspaceDir() == null) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$sendMessageIternal$1(this, null), 3, (Object) null);
            return;
        }
        String json = Intrinsics.areEqual(agentType, BrainstormSummaryRepository.AGENT_TYPE_VOICE_SUMMARY) ? this.gson.toJson(new CommonParams(cliConversationId)) : "";
        Log.e(TAG, "sendMessageIternal: local_common_params_str=" + json);
        this.createTaskJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$sendMessageIternal$2(text, query, this, targetConversationId, recoverHistoricalIdeProjectDevice, mode, selectedModel, selectedModelName, useFastRequest, fromDevice, json, agentType, cliConversationId, null), 3, (Object) null);
    }

    private final SelectedDeviceItem recoverHistoricalIdeProjectDevice(SelectedDeviceItem device) {
        Conversation conversation;
        String ownerIdeProjectId;
        String str;
        SelectedDeviceItem copy;
        String trimEnd;
        String substringAfterLast$default;
        if (!this.isNewConversation && device.getType() == CliType.IDE) {
            String projectId = device.getProjectId();
            if (!(projectId == null || StringsKt.isBlank(projectId)) || (conversation = (Conversation) this._conversation.getValue()) == null || (ownerIdeProjectId = ConversationProjectContextKt.ownerIdeProjectId(conversation)) == null) {
                return device;
            }
            String takeNotBlank = ConversationProjectContextKt.takeNotBlank(device.getSelectedDirectory());
            String ideProjectPath = takeNotBlank == null ? ConversationProjectContextKt.ideProjectPath(conversation) : takeNotBlank;
            String projectName = device.getProjectName();
            if (projectName == null) {
                projectName = null;
                if (ideProjectPath != null && (trimEnd = StringsKt.trimEnd(ideProjectPath, new char[]{'/'})) != null && (substringAfterLast$default = StringsKt.substringAfterLast$default(trimEnd, '/', (String) null, 2, (Object) null)) != null && (true ^ StringsKt.isBlank(substringAfterLast$default))) {
                    str = substringAfterLast$default;
                    copy = device.copy((r20 & 1) != 0 ? device.id : null, (r20 & 2) != 0 ? device.name : null, (r20 & 4) != 0 ? device.type : null, (r20 & 8) != 0 ? device.selectedDirectory : ideProjectPath, (r20 & 16) != 0 ? device.ideVersion : null, (r20 & 32) != 0 ? device.projectId : ownerIdeProjectId, (r20 & 64) != 0 ? device.isProjectAvailable : true, (r20 & 128) != 0 ? device.projectName : str, (r20 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? device.showProductType : false);
                    this._selectedDevice.setValue(copy);
                    return copy;
                }
            }
            str = projectName;
            copy = device.copy((r20 & 1) != 0 ? device.id : null, (r20 & 2) != 0 ? device.name : null, (r20 & 4) != 0 ? device.type : null, (r20 & 8) != 0 ? device.selectedDirectory : ideProjectPath, (r20 & 16) != 0 ? device.ideVersion : null, (r20 & 32) != 0 ? device.projectId : ownerIdeProjectId, (r20 & 64) != 0 ? device.isProjectAvailable : true, (r20 & 128) != 0 ? device.projectName : str, (r20 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? device.showProductType : false);
            this._selectedDevice.setValue(copy);
            return copy;
        }
        return device;
    }

    public final JsonObject toCreateTaskCustomModel(RemoteModelItem remoteModelItem) {
        JsonObject jsonObject;
        JsonObject deepCopy;
        JsonObject rawModel = remoteModelItem.getRawModel();
        if (rawModel == null || (deepCopy = rawModel.deepCopy()) == null || (jsonObject = deepCopy.getAsJsonObject()) == null) {
            jsonObject = new JsonObject();
            jsonObject.addProperty("name", remoteModelItem.getName());
            jsonObject.addProperty(IGoogleService.ResponseKey.DISPLAY_NAME, remoteModelItem.getDisplayName());
            jsonObject.addProperty("model_name", remoteModelItem.getName());
            jsonObject.addProperty("display_model_name", remoteModelItem.getDisplayName());
            Boolean multimodal = remoteModelItem.getMultimodal();
            if (multimodal != null) {
                jsonObject.addProperty("multimodal", Boolean.valueOf(multimodal.booleanValue()));
            }
            Integer configSource = remoteModelItem.getConfigSource();
            if (configSource != null) {
                jsonObject.addProperty("config_source", Integer.valueOf(configSource.intValue()));
            }
            String provider = remoteModelItem.getProvider();
            if (provider != null) {
                if (!(!StringsKt.isBlank(provider))) {
                    provider = null;
                }
                if (provider != null) {
                    jsonObject.addProperty("provider", provider);
                }
            }
            String customModelId = remoteModelItem.getCustomModelId();
            if (customModelId != null) {
                String str = StringsKt.isBlank(customModelId) ^ true ? customModelId : null;
                if (str != null) {
                    jsonObject.addProperty("custom_model_id", str);
                }
            }
        }
        jsonObject.addProperty("config_name", remoteModelItem.getName());
        Integer configSource2 = remoteModelItem.getConfigSource();
        jsonObject.addProperty("is_preset", Boolean.valueOf(configSource2 != null && configSource2.intValue() == 1));
        return jsonObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleModelUnavailableCreateTaskErrorIfNeeded(long j, String str, JsonObject jsonObject, SelectedDeviceItem selectedDeviceItem, Mode mode, Continuation<? super Boolean> continuation) {
        C0629x22372314 c0629x22372314;
        Object coroutine_suspended;
        int i;
        String str2;
        ConversationViewModel conversationViewModel;
        String buildModelUnavailableMessage;
        MutableSharedFlow<String> mutableSharedFlow;
        long j2 = j;
        JsonObject jsonObject2 = jsonObject;
        SelectedDeviceItem selectedDeviceItem2 = selectedDeviceItem;
        Mode mode2 = mode;
        if (continuation instanceof C0629x22372314) {
            c0629x22372314 = (C0629x22372314) continuation;
            if ((c0629x22372314.label & Integer.MIN_VALUE) != 0) {
                c0629x22372314.label -= Integer.MIN_VALUE;
                Object obj = c0629x22372314.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0629x22372314.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (j2 != CODE_MODEL_NOT_EXISTED && !shouldSwitchToAutoForModelError(j2, jsonObject2)) {
                        return Boxing.boxBoolean(false);
                    }
                    String str3 = "create_task_code_" + j2;
                    c0629x22372314.L$0 = this;
                    str2 = str;
                    c0629x22372314.L$1 = str2;
                    c0629x22372314.L$2 = jsonObject2;
                    c0629x22372314.L$3 = selectedDeviceItem2;
                    c0629x22372314.L$4 = mode2;
                    c0629x22372314.J$0 = j2;
                    c0629x22372314.label = 1;
                    if (switchSelectedModelToAuto(selectedDeviceItem2, mode2, str3, c0629x22372314) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    conversationViewModel = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Boxing.boxBoolean(true);
                    }
                    j2 = c0629x22372314.J$0;
                    Mode mode3 = (Mode) c0629x22372314.L$4;
                    selectedDeviceItem2 = (SelectedDeviceItem) c0629x22372314.L$3;
                    JsonObject jsonObject3 = (JsonObject) c0629x22372314.L$2;
                    str2 = (String) c0629x22372314.L$1;
                    conversationViewModel = (ConversationViewModel) c0629x22372314.L$0;
                    ResultKt.throwOnFailure(obj);
                    mode2 = mode3;
                    jsonObject2 = jsonObject3;
                }
                buildModelUnavailableMessage = conversationViewModel.buildModelUnavailableMessage(j2, str2, jsonObject2, selectedDeviceItem2, mode2);
                mutableSharedFlow = conversationViewModel._toastText;
                c0629x22372314.L$0 = null;
                c0629x22372314.L$1 = null;
                c0629x22372314.L$2 = null;
                c0629x22372314.L$3 = null;
                c0629x22372314.L$4 = null;
                c0629x22372314.label = 2;
                if (mutableSharedFlow.emit(buildModelUnavailableMessage, c0629x22372314) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            }
        }
        c0629x22372314 = new C0629x22372314(this, continuation);
        Object obj2 = c0629x22372314.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c0629x22372314.label;
        if (i != 0) {
        }
        buildModelUnavailableMessage = conversationViewModel.buildModelUnavailableMessage(j2, str2, jsonObject2, selectedDeviceItem2, mode2);
        mutableSharedFlow = conversationViewModel._toastText;
        c0629x22372314.L$0 = null;
        c0629x22372314.L$1 = null;
        c0629x22372314.L$2 = null;
        c0629x22372314.L$3 = null;
        c0629x22372314.L$4 = null;
        c0629x22372314.label = 2;
        if (mutableSharedFlow.emit(buildModelUnavailableMessage, c0629x22372314) == coroutine_suspended) {
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleCreateTaskErrorWithoutModelFallbackIfNeeded(long j, String str, JsonObject jsonObject, Continuation<? super Boolean> continuation) {
        C0628x8433ac5e c0628x8433ac5e;
        int i;
        AgentErrorCodeRegistry.DisplayResult displayMessage;
        if (continuation instanceof C0628x8433ac5e) {
            c0628x8433ac5e = (C0628x8433ac5e) continuation;
            if ((c0628x8433ac5e.label & Integer.MIN_VALUE) != 0) {
                c0628x8433ac5e.label -= Integer.MIN_VALUE;
                Object obj = c0628x8433ac5e.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0628x8433ac5e.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (j != CODE_INVALID_ARGS) {
                        return Boxing.boxBoolean(false);
                    }
                    TraeLogUtil.INSTANCE.w(TAG, "sendMessageIternal: create task failed without model fallback, code=" + j + ", msg=" + str);
                    AgentErrorCodeRegistry agentErrorCodeRegistry = AgentErrorCodeRegistry.INSTANCE;
                    Resources resources = AppHost.INSTANCE.getApplication().getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                    displayMessage = agentErrorCodeRegistry.displayMessage(resources, Boxing.boxInt((int) j), (r16 & 4) != 0 ? null : str, (r16 & 8) != 0 ? null : jsonObject, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? TocCreditsPolicy.INSTANCE.isEnabled() : false);
                    String message = displayMessage.getMessage();
                    MutableSharedFlow<String> mutableSharedFlow = this._toastText;
                    String str2 = message;
                    if (StringsKt.isBlank(str2)) {
                        str2 = AppHost.INSTANCE.getApplication().getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_send_retry);
                        Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
                    }
                    c0628x8433ac5e.label = 1;
                    if (mutableSharedFlow.emit(str2, c0628x8433ac5e) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxBoolean(true);
            }
        }
        c0628x8433ac5e = new C0628x8433ac5e(this, continuation);
        Object obj2 = c0628x8433ac5e.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c0628x8433ac5e.label;
        if (i != 0) {
        }
        return Boxing.boxBoolean(true);
    }

    public final void handleModelUnavailableLoadedMessagesIfNeeded(List<ParsedChatMessage> messages, String r9) {
        Conversation conversation = (Conversation) this._conversation.getValue();
        Object obj = null;
        final String latestTaskId = conversation != null ? conversation.getLatestTaskId() : null;
        String str = latestTaskId;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        Iterator it = SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(messages), new Function1() { // from class: com.bytedance.trae.conversation.ConversationViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                boolean handleModelUnavailableLoadedMessagesIfNeeded$lambda$55;
                handleModelUnavailableLoadedMessagesIfNeeded$lambda$55 = ConversationViewModel.handleModelUnavailableLoadedMessagesIfNeeded$lambda$55((ParsedChatMessage) obj2);
                return Boolean.valueOf(handleModelUnavailableLoadedMessagesIfNeeded$lambda$55);
            }
        }), new Function1() { // from class: com.bytedance.trae.conversation.ConversationViewModel$$ExternalSyntheticLambda3
            public final Object invoke(Object obj2) {
                boolean handleModelUnavailableLoadedMessagesIfNeeded$lambda$56;
                handleModelUnavailableLoadedMessagesIfNeeded$lambda$56 = ConversationViewModel.handleModelUnavailableLoadedMessagesIfNeeded$lambda$56((ParsedChatMessage) obj2);
                return Boolean.valueOf(handleModelUnavailableLoadedMessagesIfNeeded$lambda$56);
            }
        }), new Function1() { // from class: com.bytedance.trae.conversation.ConversationViewModel$$ExternalSyntheticLambda4
            public final Object invoke(Object obj2) {
                boolean handleModelUnavailableLoadedMessagesIfNeeded$lambda$57;
                handleModelUnavailableLoadedMessagesIfNeeded$lambda$57 = ConversationViewModel.handleModelUnavailableLoadedMessagesIfNeeded$lambda$57(latestTaskId, (ParsedChatMessage) obj2);
                return Boolean.valueOf(handleModelUnavailableLoadedMessagesIfNeeded$lambda$57);
            }
        }).iterator();
        if (it.hasNext()) {
            obj = it.next();
            if (it.hasNext()) {
                long createdAt = ((ParsedChatMessage) obj).getCreatedAt();
                do {
                    Object next = it.next();
                    long createdAt2 = ((ParsedChatMessage) next).getCreatedAt();
                    if (createdAt < createdAt2) {
                        obj = next;
                        createdAt = createdAt2;
                    }
                } while (it.hasNext());
            }
        }
        ParsedChatMessage parsedChatMessage = (ParsedChatMessage) obj;
        if (parsedChatMessage == null) {
            return;
        }
        handleModelUnavailableMessageErrorIfNeeded(parsedChatMessage, r9);
    }

    public static final boolean handleModelUnavailableLoadedMessagesIfNeeded$lambda$55(ParsedChatMessage parsedChatMessage) {
        Intrinsics.checkNotNullParameter(parsedChatMessage, "it");
        return parsedChatMessage.isAssistantMessage();
    }

    public static final boolean handleModelUnavailableLoadedMessagesIfNeeded$lambda$56(ParsedChatMessage parsedChatMessage) {
        Intrinsics.checkNotNullParameter(parsedChatMessage, "it");
        return Intrinsics.areEqual(parsedChatMessage.getStatus(), "failed") && parsedChatMessage.getError() != null;
    }

    public static final boolean handleModelUnavailableLoadedMessagesIfNeeded$lambda$57(String str, ParsedChatMessage parsedChatMessage) {
        Intrinsics.checkNotNullParameter(parsedChatMessage, "it");
        ParsedTaskContent taskContent = parsedChatMessage.getTaskContent();
        return Intrinsics.areEqual(taskContent != null ? taskContent.getTaskId() : null, str);
    }

    private final void handleModelUnavailableMessageErrorIfNeeded(ParsedChatMessage message, String r18) {
        Integer code;
        SelectedDeviceItem selectedDeviceItem;
        ParsedError error = message.getError();
        if (error == null || (code = error.getCode()) == null) {
            return;
        }
        long intValue = code.intValue();
        if (shouldSwitchToAutoForModelError(intValue, error.getData()) && (selectedDeviceItem = (SelectedDeviceItem) this._selectedDevice.getValue()) != null) {
            Mode currentConversationMode = currentConversationMode();
            String modelFallbackErrorKey = modelFallbackErrorKey(message, intValue);
            if (modelFallbackErrorKey != null && !this.handledModelFallbackErrorKeys.add(modelFallbackErrorKey)) {
                TraeLogUtil.INSTANCE.i(TAG, "handleModelUnavailableMessageErrorIfNeeded: already handled, key=" + modelFallbackErrorKey);
            } else {
                BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C0630xfcb1ac92(this, selectedDeviceItem, currentConversationMode, intValue, r18, message, null), 3, (Object) null);
            }
        }
    }

    private final String modelFallbackErrorKey(ParsedChatMessage message, long code) {
        String messageId = message.getMessageId();
        if (!(!StringsKt.isBlank(messageId))) {
            messageId = null;
        }
        if (messageId == null) {
            ParsedTaskContent taskContent = message.getTaskContent();
            if (taskContent == null || (messageId = taskContent.getTaskId()) == null || !(!StringsKt.isBlank(messageId))) {
                messageId = null;
            }
            if (messageId == null && ((messageId = message.getTaskIdUser()) == null || !(!StringsKt.isBlank(messageId)))) {
                messageId = null;
            }
        }
        if (messageId != null) {
            return message.getSessionId() + '|' + messageId + '|' + code;
        }
        return null;
    }

    private final boolean shouldSwitchToAutoForModelError(long code, JsonObject errorData) {
        if (code == CODE_INTERNAL_USAGE_LIMIT) {
            if (!isInternalUser() || !Intrinsics.areEqual(readBoolean(errorData, "is_internal_usage_limit"), true)) {
                return false;
            }
        } else if (code != CODE_REPO_LEVEL_RESTRICTED) {
            return false;
        }
        return true;
    }

    public final Object switchSelectedModelToAuto(SelectedDeviceItem selectedDeviceItem, Mode mode, String str, Continuation<? super Unit> continuation) {
        String environmentKey = ModelSelectionRepository.INSTANCE.environmentKey(selectedDeviceItem.getType());
        String modeKey = ModelSelectionRepository.INSTANCE.modeKey(mode);
        ModelSelectionRepository.INSTANCE.saveModeSelection(environmentKey, modeKey, RemoteModelItem.INSTANCE.auto());
        ModelSelectionRepository.INSTANCE.saveSessionSelection(environmentKey, modeKey, (String) this._conversationId.getValue(), RemoteModelItem.INSTANCE.auto());
        TraeLogUtil.INSTANCE.w(TAG, "switchSelectedModelToAuto: reason=" + str + ", cliId=" + selectedDeviceItem.getId() + ", cliType=" + selectedDeviceItem.getType() + ", mode=" + mode.getValue());
        Object emit = this._modelSelectionResetToAuto.emit(Unit.INSTANCE, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    private final String buildModelUnavailableMessage(long code, String originMessage, JsonObject errorData, SelectedDeviceItem device, Mode mode) {
        String str;
        AgentErrorCodeRegistry.DisplayResult displayMessage;
        Resources resources = AppHost.INSTANCE.getApplication().getResources();
        if (code == CODE_MODEL_NOT_EXISTED) {
            AgentErrorCodeRegistry agentErrorCodeRegistry = AgentErrorCodeRegistry.INSTANCE;
            Intrinsics.checkNotNull(resources);
            displayMessage = agentErrorCodeRegistry.displayMessage(resources, Integer.valueOf((int) code), (r16 & 4) != 0 ? null : originMessage, (r16 & 8) != 0 ? null : errorData, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? TocCreditsPolicy.INSTANCE.isEnabled() : false);
            str = displayMessage.getMessage();
        } else if (code == CODE_INTERNAL_USAGE_LIMIT) {
            Intrinsics.checkNotNull(resources);
            str = buildInternalUsageLimitMessage(resources, device, mode);
        } else {
            if (code != CODE_REPO_LEVEL_RESTRICTED) {
                str = originMessage == null ? "" : originMessage;
            } else if (Intrinsics.areEqual(readString(errorData, DBData.FIELD_TYPE), "empty_git")) {
                I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
                Intrinsics.checkNotNull(resources);
                str = i18nTextProvider.getString(resources, com.bytedance.trae.multilanguage.R.string.imkit_error_repoLevelModelUnavailable_emptyGit, new Object[0]);
            } else {
                I18nTextProvider i18nTextProvider2 = I18nTextProvider.INSTANCE;
                Intrinsics.checkNotNull(resources);
                int i = com.bytedance.trae.multilanguage.R.string.imkit_error_repoLevelModelUnavailable;
                String readString = readString(errorData, "level");
                str = i18nTextProvider2.getStringWithNamedArgs(resources, i, MapsKt.mapOf(TuplesKt.to("repoLevel", readString != null ? readString : "")));
            }
        }
        String str2 = str;
        if (StringsKt.isBlank(str2)) {
            if (originMessage == null) {
                str2 = AppHost.INSTANCE.getApplication().getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_send_retry);
                Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
            } else {
                str2 = originMessage;
            }
        }
        return str2;
    }

    private final String buildInternalUsageLimitMessage(Resources resources, SelectedDeviceItem device, Mode mode) {
        List<String> internalUsageLimitModelNames = internalUsageLimitModelNames(device, mode);
        if (internalUsageLimitModelNames.isEmpty()) {
            return I18nTextProvider.INSTANCE.getString(resources, com.bytedance.trae.multilanguage.R.string.imkit_error_internalUsageLimit_message, new Object[0]);
        }
        return I18nTextProvider.INSTANCE.getStringWithNamedArgs(resources, com.bytedance.trae.multilanguage.R.string.imkit_error_internalUsageLimit_messageWithModels, MapsKt.mapOf(TuplesKt.to("models", CollectionsKt.joinToString$default(internalUsageLimitModelNames, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null))));
    }

    static /* synthetic */ String contentSecurityBlockedText$default(ConversationViewModel conversationViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return conversationViewModel.contentSecurityBlockedText(str);
    }

    public final String contentSecurityBlockedText(String ruleName) {
        AgentErrorCodeRegistry agentErrorCodeRegistry = AgentErrorCodeRegistry.INSTANCE;
        Resources resources = AppHost.INSTANCE.getApplication().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return agentErrorCodeRegistry.contentSecurityBlockedMessage(resources, ruleName);
    }

    public final void saveSelectedRepo() {
        if (this.isNewConversation) {
            try {
                if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
                    GitRepoItem gitRepoItem = this.selectedRepo;
                    if (gitRepoItem != null) {
                        Intrinsics.checkNotNull(gitRepoItem);
                        if (!TextUtils.isEmpty(gitRepoItem.getId())) {
                            JSONObject jSONObject = new JSONObject();
                            GitRepoItem gitRepoItem2 = this.selectedRepo;
                            jSONObject.put("id", gitRepoItem2 != null ? gitRepoItem2.getId() : null);
                            GitRepoItem gitRepoItem3 = this.selectedRepo;
                            jSONObject.put("title", gitRepoItem3 != null ? gitRepoItem3.getTitle() : null);
                            GitRepoItem gitRepoItem4 = this.selectedRepo;
                            jSONObject.put("subtitle", gitRepoItem4 != null ? gitRepoItem4.getSubtitle() : null);
                            GitRepoItem gitRepoItem5 = this.selectedRepo;
                            jSONObject.put("repoUrl", gitRepoItem5 != null ? gitRepoItem5.getRepoUrl() : null);
                            AccountSettingsKeva.INSTANCE.getKeva().storeString(GitSelectionViewModel.KEY_SELECTED_REPO, jSONObject.toString());
                            return;
                        }
                    }
                    AccountSettingsKeva.INSTANCE.getKeva().erase(GitSelectionViewModel.KEY_SELECTED_REPO);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private final List<String> internalUsageLimitModelNames(SelectedDeviceItem device, Mode mode) {
        List<String> modelListFunctions = modelListFunctions(device, mode);
        if (modelListFunctions.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List<RemoteModelItem> cachedModelsForUi = IRemoteModelsApi.INSTANCE.getCachedModelsForUi(device.getType(), device.getId(), modelListFunctions);
        if (cachedModelsForUi == null) {
            cachedModelsForUi = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : cachedModelsForUi) {
            if (Intrinsics.areEqual(((RemoteModelItem) obj).isInternalUsageLimit(), true)) {
                arrayList.add(obj);
            }
        }
        ArrayList<RemoteModelItem> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (RemoteModelItem remoteModelItem : arrayList2) {
            String displayName = remoteModelItem.getDisplayName();
            if (StringsKt.isBlank(displayName)) {
                displayName = remoteModelItem.getName();
            }
            arrayList3.add(displayName);
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (!StringsKt.isBlank((String) obj2)) {
                arrayList4.add(obj2);
            }
        }
        return CollectionsKt.distinct(arrayList4);
    }

    private final List<String> modelListFunctions(SelectedDeviceItem device, Mode mode) {
        return device.getType() == CliType.IDE ? CollectionsKt.listOf("solo_agent") : (device.getType() == CliType.LOCAL && mode == Mode.CODE) ? CollectionsKt.listOf("solo_agent_lite") : (device.getType() == CliType.LOCAL && mode == Mode.WORK) ? CollectionsKt.listOf("solo_work_lite") : (device.getType() == CliType.REMOTE && mode == Mode.CODE) ? CollectionsKt.listOf("solo_agent_remote") : (device.getType() == CliType.REMOTE && mode == Mode.WORK) ? CollectionsKt.listOf("solo_work_remote") : CollectionsKt.emptyList();
    }

    private final boolean isInternalUser() {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        AccountInfo accountInfo = iLoginService != null ? iLoginService.getAccountInfo() : null;
        if (Intrinsics.areEqual(accountInfo != null ? accountInfo.getLoginPlatform() : null, ThirdPartyTokenRepository.TYPE_BYTECLOUD)) {
            return true;
        }
        return accountInfo != null && accountInfo.getOdinUserType() == 12;
    }

    private final Mode currentTaskMode() {
        return this._currentMode.getValue() == ChatMode.CODE ? Mode.CODE : Mode.WORK;
    }

    private final Mode currentConversationMode() {
        Object obj;
        Iterator it = Mode.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String value = ((Mode) next).getValue();
            Conversation conversation = (Conversation) this._conversation.getValue();
            if (Intrinsics.areEqual(value, conversation != null ? conversation.getMode() : null)) {
                obj = next;
                break;
            }
        }
        Mode mode = (Mode) obj;
        return mode == null ? currentTaskMode() : mode;
    }

    private final Boolean readBoolean(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        Object obj;
        if (jsonObject == null || (jsonElement = jsonObject.get(str)) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Boolean.valueOf(jsonElement.getAsBoolean()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Boolean) (Result.isFailure-impl(obj) ? null : obj);
    }

    private final String readString(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        Object obj;
        if (jsonObject == null || (jsonElement = jsonObject.get(str)) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(jsonElement.getAsString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str2 = (String) obj;
        if (str2 == null || !(!StringsKt.isBlank(str2))) {
            return null;
        }
        return str2;
    }

    public final void cacheTaskModelSelection(SelectedDeviceItem device, Mode mode, String sessionId, String agentType, RemoteModelItem selectedModel) {
        if (Intrinsics.areEqual(agentType, BrainstormSummaryRepository.AGENT_TYPE_VOICE_SUMMARY)) {
            return;
        }
        String environmentKey = ModelSelectionRepository.INSTANCE.environmentKey(device.getType());
        String modeKey = ModelSelectionRepository.INSTANCE.modeKey(mode);
        ModelSelectionRepository modelSelectionRepository = ModelSelectionRepository.INSTANCE;
        if (selectedModel == null) {
            selectedModel = RemoteModelItem.INSTANCE.auto();
        }
        modelSelectionRepository.saveSessionSelection(environmentKey, modeKey, sessionId, selectedModel);
    }

    private final List<String> resolveModelListFunctions(CliType cliType, Mode mode) {
        return (cliType == CliType.LOCAL && mode == Mode.CODE) ? CollectionsKt.listOf("solo_agent_lite") : cliType == CliType.LOCAL ? CollectionsKt.listOf("solo_work_lite") : (cliType == CliType.REMOTE && mode == Mode.CODE) ? CollectionsKt.listOf("solo_agent_remote") : (cliType == CliType.REMOTE && mode == Mode.WORK) ? CollectionsKt.listOf("solo_work_remote") : CollectionsKt.emptyList();
    }

    private final void armSummaryPerfReport(boolean isSuccess) {
        this.pendingSummaryIsSuccess = isSuccess;
        if (VoiceSummaryRenderTracker.INSTANCE.getLastCharOnScreenMs() > 0) {
            submitSummaryPerfReport(isSuccess);
            return;
        }
        Job job = this.summaryReportTimeoutJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.summaryReportTimeoutJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$armSummaryPerfReport$1(this, null), 3, (Object) null);
    }

    public final void submitSummaryPerfReport(boolean isSuccess) {
        if (this.summaryReportSubmitted) {
            return;
        }
        this.summaryReportSubmitted = true;
        Job job = this.summaryReportTimeoutJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.summaryReportTimeoutJob = null;
        reportDiscussionSummaryPerf(isSuccess);
    }

    private final void reportDiscussionSummaryPerf(boolean isSuccess) {
        String str;
        String str2;
        String str3;
        long j;
        long j2;
        String str4;
        String str5;
        long j3;
        long j4;
        String str6;
        String str7;
        long j5;
        long j6;
        long j7;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            try {
                long max = Math.max(System.currentTimeMillis() - this.summaryStartTimestamp, 0L);
                long firstCharOnScreenMs = VoiceSummaryRenderTracker.INSTANCE.getFirstCharOnScreenMs();
                long lastCharOnScreenMs = VoiceSummaryRenderTracker.INSTANCE.getLastCharOnScreenMs();
                long j8 = -1;
                if (firstCharOnScreenMs > 0) {
                    str2 = "conversation_id";
                    str3 = "is_new_session";
                    j = 0;
                    j2 = Math.max(firstCharOnScreenMs - this.summaryStartTimestamp, 0L);
                } else {
                    str2 = "conversation_id";
                    str3 = "is_new_session";
                    j = 0;
                    j2 = -1;
                }
                if (lastCharOnScreenMs > j) {
                    str4 = "is_success";
                    str5 = "render_first_char_lag_ms";
                    j3 = 0;
                    j4 = Math.max(lastCharOnScreenMs - this.summaryStartTimestamp, 0L);
                } else {
                    str4 = "is_success";
                    str5 = "render_first_char_lag_ms";
                    j3 = j;
                    j4 = -1;
                }
                if (firstCharOnScreenMs <= 0 || lastCharOnScreenMs <= j) {
                    str6 = "data_first_char_ms";
                    str7 = "char_count";
                    j5 = -1;
                } else {
                    str6 = "data_first_char_ms";
                    str7 = "char_count";
                    j5 = Math.max(lastCharOnScreenMs - firstCharOnScreenMs, j3);
                }
                long j9 = this.summaryDataFirstCharTimestamp;
                if (j9 > j3) {
                    j3 = 0;
                    j6 = Math.max(j9 - this.summaryStartTimestamp, 0L);
                } else {
                    j6 = -1;
                }
                if (firstCharOnScreenMs > 0) {
                    j7 = j6;
                    long j10 = this.summaryDataFirstCharTimestamp;
                    if (j10 > j3) {
                        j8 = Math.max(firstCharOnScreenMs - j10, j3);
                    }
                } else {
                    j7 = j6;
                }
                long j11 = j8;
                int i = this.summaryCharCount;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("total_ms", max);
                jSONObject.put("first_char_ms", j2);
                jSONObject.put("last_char_ms", j4);
                long j12 = j4;
                long j13 = j5;
                jSONObject.put("streaming_ms", j13);
                String str8 = str7;
                jSONObject.put(str8, i);
                String str9 = str6;
                long j14 = j7;
                jSONObject.put(str9, j14);
                String str10 = str5;
                jSONObject.put(str10, j11);
                JSONObject commonCategory = VoiceDiscussionMetrics.INSTANCE.commonCategory(this.summaryCliType, this.summaryMode);
                if (isSuccess) {
                    obj2 = "1";
                    obj = obj2;
                } else {
                    obj = "1";
                    obj2 = "0";
                }
                String str11 = str4;
                commonCategory.put(str11, obj2);
                if (this.summaryIsNewSession) {
                    obj4 = "0";
                    obj3 = obj;
                } else {
                    obj3 = "0";
                    obj4 = obj3;
                }
                String str12 = str3;
                commonCategory.put(str12, obj3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("session_id", this.summarySessionId);
                String str13 = str2;
                jSONObject2.put(str13, this.summarySessionId);
                jSONObject2.put("room_id", "");
                ApmService.INSTANCE.monitorEventForSlardar(EVENT_DISCUSSION_SUMMARY_PERF, commonCategory, jSONObject, jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                VoiceDiscussionMetrics.INSTANCE.putVoiceCommonParams(jSONObject3, this.summaryCliType, this.summaryMode);
                jSONObject3.put(str13, this.summarySessionId);
                jSONObject3.put(str11, isSuccess ? obj : obj4);
                jSONObject3.put(str12, this.summaryIsNewSession ? obj : obj4);
                jSONObject3.put("total_ms", max);
                jSONObject3.put("first_char_ms", j2);
                jSONObject3.put("last_char_ms", j12);
                jSONObject3.put("streaming_ms", j13);
                jSONObject3.put(str8, i);
                jSONObject3.put(str9, j14);
                jSONObject3.put(str10, j11);
                IApplog.INSTANCE.reportEvent(EVENT_DISCUSSION_SUMMARY_END, jSONObject3);
                String str14 = "reportDiscussionSummaryPerf: success=" + isSuccess + " total=" + max + "ms first=" + j2 + "ms last=" + j12 + "ms streaming=" + j13 + "ms data_first=" + j14 + "ms render_first_lag=" + j11 + "ms chars=" + i;
                str = TAG;
                try {
                    Log.d(str, str14);
                } catch (Throwable th) {
                    th = th;
                    try {
                        Log.w(str, "reportDiscussionSummaryPerf failed", th);
                    } finally {
                        VoiceSummaryRenderTracker.INSTANCE.stop();
                    }
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

    private final int extractSummaryCharCount(ParsedChatMessage message) {
        List<ParsedPlanItemMessage> messages;
        Integer num;
        ParsedToolCallInfo toolCallInfo;
        JsonObject params;
        JsonElement jsonElement;
        ParsedTaskContent taskContent = message.getTaskContent();
        if (taskContent == null || (messages = taskContent.getMessages()) == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = messages.iterator();
        while (it.hasNext()) {
            ParsedPlanItem planItem = ((ParsedPlanItemMessage) it.next()).getPlanItem();
            if (planItem != null) {
                arrayList.add(planItem);
            }
        }
        ArrayList<ParsedPlanItem> arrayList2 = arrayList;
        int i = 0;
        for (ParsedPlanItem parsedPlanItem : arrayList2) {
            ParsedToolCallInfo toolCallInfo2 = parsedPlanItem.getToolCallInfo();
            String name = toolCallInfo2 != null ? toolCallInfo2.getName() : null;
            i += (name == null || !SUMMARY_FINISH_TOOLS.contains(name) || (toolCallInfo = parsedPlanItem.getToolCallInfo()) == null || (params = toolCallInfo.getParams()) == null || (jsonElement = params.get("summary")) == null) ? 0 : extractVoiceSummaryText(jsonElement).length();
        }
        if (i > 0) {
            return i;
        }
        if (Intrinsics.areEqual(message.getAgentType(), BrainstormSummaryRepository.AGENT_TYPE_VOICE_SUMMARY) && (num = (Integer) SequencesKt.lastOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(arrayList2), new Function1() { // from class: com.bytedance.trae.conversation.ConversationViewModel$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Integer extractSummaryCharCount$lambda$85;
                extractSummaryCharCount$lambda$85 = ConversationViewModel.extractSummaryCharCount$lambda$85((ParsedPlanItem) obj);
                return extractSummaryCharCount$lambda$85;
            }
        }))) != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final Integer extractSummaryCharCount$lambda$85(ParsedPlanItem parsedPlanItem) {
        String markdown;
        Intrinsics.checkNotNullParameter(parsedPlanItem, "it");
        VoiceSummaryPayload parseThought = VoiceSummaryPayloadParser.INSTANCE.parseThought(parsedPlanItem.getThought());
        if (parseThought == null || (markdown = parseThought.getMarkdown()) == null) {
            return null;
        }
        return Integer.valueOf(markdown.length());
    }

    private final String extractVoiceSummaryText(JsonElement summaryElement) {
        return VoiceSummaryPayloadParser.INSTANCE.extractSummaryText(summaryElement);
    }

    public final SharedFlow<Boolean> getCancelTaskResult() {
        return this.cancelTaskResult;
    }

    public final void cancelCurrentTask() {
        String str = (String) this._conversationId.getValue();
        String str2 = this._currentTaskId;
        String str3 = str;
        if (!(str3 == null || str3.length() == 0)) {
            String str4 = str2;
            if (!(str4 == null || str4.length() == 0)) {
                BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$cancelCurrentTask$1(str, str2, this, null), 3, (Object) null);
                return;
            }
        }
        CancelTaskMonitor.INSTANCE.report("skipped_null_id", "user_click", (r25 & 4) != 0 ? null : str2, (r25 & 8) != 0 ? null : str, (r25 & 16) != 0 ? null : null, (r25 & 32) != 0 ? 0L : 0L, (r25 & 64) != 0 ? null : null, (r25 & 128) != 0 ? false : this.isTaskRunning, (r25 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : null);
    }

    private final void notifyTaskListStatusChanged(String conversationId, String messageStatus) {
        String str;
        Conversation copy;
        if (messageStatus != null) {
            switch (messageStatus.hashCode()) {
                case -1402931637:
                    if (messageStatus.equals("completed")) {
                        str = "5";
                        break;
                    } else {
                        return;
                    }
                case -1281977283:
                    if (messageStatus.equals("failed")) {
                        str = "6";
                        break;
                    } else {
                        return;
                    }
                case -753541113:
                    if (messageStatus.equals("in_progress")) {
                        str = OnekeyLoginConstants.TELECOM_TYPE;
                        break;
                    } else {
                        return;
                    }
                case -123173735:
                    if (messageStatus.equals(ConfirmInfo.STATUS_CANCELED)) {
                        str = "4";
                        break;
                    } else {
                        return;
                    }
                default:
                    return;
            }
            String str2 = str;
            Conversation conversation = (Conversation) this._conversation.getValue();
            if (conversation == null) {
                return;
            }
            copy = conversation.copy((r44 & 1) != 0 ? conversation.id : null, (r44 & 2) != 0 ? conversation.parentConversationId : null, (r44 & 4) != 0 ? conversation.hiddenStatus : null, (r44 & 8) != 0 ? conversation.cliConversationId : null, (r44 & 16) != 0 ? conversation.userId : null, (r44 & 32) != 0 ? conversation.cliId : null, (r44 & 64) != 0 ? conversation.title : null, (r44 & 128) != 0 ? conversation.workspace : null, (r44 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? conversation.gitUri : null, (r44 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? conversation.mode : null, (r44 & 1024) != 0 ? conversation.status : str2, (r44 & 2048) != 0 ? conversation.environment : null, (r44 & 4096) != 0 ? conversation.latestTaskId : null, (r44 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? conversation.latestTaskStatus : null, (r44 & 16384) != 0 ? conversation.latestTaskUpdateTime : null, (r44 & 32768) != 0 ? conversation.createdAt : null, (r44 & 65536) != 0 ? conversation.updatedAt : null, (r44 & 131072) != 0 ? conversation.source : null, (r44 & 262144) != 0 ? conversation.iconType : null, (r44 & FConstants.SLICE_SIZE) != 0 ? conversation.cliConversationStatus : null, (r44 & 1048576) != 0 ? conversation.ownerProjectId : null, (r44 & 2097152) != 0 ? conversation.latestProjectId : null, (r44 & 4194304) != 0 ? conversation.ownerProjectAbsolutePath : null, (r44 & 8388608) != 0 ? conversation.ownerProjectWorkSpaceStatus : null, (r44 & 16777216) != 0 ? conversation.isPinned : null, (r44 & 33554432) != 0 ? conversation.pinnedAt : null);
            this._conversation.setValue(copy);
            IMService.INSTANCE.notifyConversationChanged(new IMService.ConversationChangeEvent("update", conversationId, copy));
        }
    }

    public final void handleCliDisconnected() {
        Conversation copy;
        this._sessionTurnStatus.setValue(SessionTurnStatus.STOPPED);
        this._currentTaskId = null;
        this.isTaskRunning = false;
        String str = (String) this._conversationId.getValue();
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            Conversation conversation = (Conversation) this._conversation.getValue();
            if (conversation == null) {
                return;
            }
            copy = conversation.copy((r44 & 1) != 0 ? conversation.id : null, (r44 & 2) != 0 ? conversation.parentConversationId : null, (r44 & 4) != 0 ? conversation.hiddenStatus : null, (r44 & 8) != 0 ? conversation.cliConversationId : null, (r44 & 16) != 0 ? conversation.userId : null, (r44 & 32) != 0 ? conversation.cliId : null, (r44 & 64) != 0 ? conversation.title : null, (r44 & 128) != 0 ? conversation.workspace : null, (r44 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? conversation.gitUri : null, (r44 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? conversation.mode : null, (r44 & 1024) != 0 ? conversation.status : "4", (r44 & 2048) != 0 ? conversation.environment : null, (r44 & 4096) != 0 ? conversation.latestTaskId : null, (r44 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? conversation.latestTaskStatus : null, (r44 & 16384) != 0 ? conversation.latestTaskUpdateTime : null, (r44 & 32768) != 0 ? conversation.createdAt : null, (r44 & 65536) != 0 ? conversation.updatedAt : null, (r44 & 131072) != 0 ? conversation.source : null, (r44 & 262144) != 0 ? conversation.iconType : null, (r44 & FConstants.SLICE_SIZE) != 0 ? conversation.cliConversationStatus : null, (r44 & 1048576) != 0 ? conversation.ownerProjectId : null, (r44 & 2097152) != 0 ? conversation.latestProjectId : null, (r44 & 4194304) != 0 ? conversation.ownerProjectAbsolutePath : null, (r44 & 8388608) != 0 ? conversation.ownerProjectWorkSpaceStatus : null, (r44 & 16777216) != 0 ? conversation.isPinned : null, (r44 & 33554432) != 0 ? conversation.pinnedAt : null);
            this._conversation.setValue(copy);
            IMService.INSTANCE.notifyConversationChanged(new IMService.ConversationChangeEvent("update", str, copy));
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$handleCliDisconnected$1(this, null), 3, (Object) null);
        flushPendingUpgradeReminderIfAllowed();
    }

    public final void handleCheckpointDecision(CheckpointDecision decision) {
        Intrinsics.checkNotNullParameter(decision, "decision");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$handleCheckpointDecision$1(decision, this, null), 3, (Object) null);
    }

    public final void reportCheckpointConfirmTaskError(CheckpointDecision decision, String decisionStr, HttpDataResult.Error result) {
        Class<?> cls;
        String name;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("decision", decisionStr);
            String toolName = decision.getToolName();
            String str = "";
            if (toolName == null) {
                toolName = "";
            }
            jSONObject.put("tool_name", toolName);
            jSONObject.put("error_code", String.valueOf(result.getCode()));
            jSONObject.put("has_throwable", result.getThrowable() != null ? "1" : "0");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("error_code", result.getCode());
            JSONObject jSONObject3 = new JSONObject();
            String conversationId = decision.getConversationId();
            if (conversationId != null) {
                str = conversationId;
            }
            jSONObject3.put("conversation_id", str);
            jSONObject3.put(NewTaskTracker.Param.TASK_ID, decision.getTaskId());
            jSONObject3.put("plan_item_id", decision.getPlanItemId());
            jSONObject3.put("error_msg", result.getMsg());
            Throwable throwable = result.getThrowable();
            if (throwable != null && (cls = throwable.getClass()) != null && (name = cls.getName()) != null) {
                jSONObject3.put("throwable_type", name);
            }
            ApmService.INSTANCE.monitorEventForSlardar(EVENT_CHECKPOINT_CONFIRM_TASK_ERROR, jSONObject, jSONObject2, jSONObject3);
        } catch (Throwable th) {
            FLogger.INSTANCE.w(TAG, "reportCheckpointConfirmTaskError failed", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0015 A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:3:0x0001, B:5:0x0008, B:12:0x0015, B:14:0x0026, B:16:0x0031, B:18:0x0040), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String parseGitDisplayName(String gitUri) {
        String str;
        boolean z;
        try {
            str = gitUri;
        } catch (Throwable unused) {
        }
        if (str != null && !StringsKt.isBlank(str)) {
            z = false;
            if (!z) {
                return null;
            }
            MatchResult find$default = Regex.find$default(new Regex("^git@[^:]+:(.+?)(\\.git)?$"), gitUri, 0, 2, (Object) null);
            if (find$default != null) {
                return (String) find$default.getGroupValues().get(1);
            }
            MatchResult find$default2 = Regex.find$default(new Regex("^https?://[^/]+/(.+?)(\\.git)?$"), gitUri, 0, 2, (Object) null);
            if (find$default2 != null) {
                return (String) find$default2.getGroupValues().get(1);
            }
            return null;
        }
        z = true;
        if (!z) {
        }
    }

    public final String parseWorkspaceDisplayName(String r12) {
        String str = r12;
        Object obj = null;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        List split$default = StringsKt.split$default(StringsKt.trimEnd(StringsKt.replace$default(r12, '\\', '/', false, 4, (Object) null), new char[]{'/'}), new char[]{'/'}, false, 0, 6, (Object) null);
        ListIterator listIterator = split$default.listIterator(split$default.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Object previous = listIterator.previous();
            if (((String) previous).length() > 0) {
                obj = previous;
                break;
            }
        }
        return (String) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void retryMessage$default(ConversationViewModel conversationViewModel, String str, List list, RemoteModelItem remoteModelItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        if ((i & 4) != 0) {
            remoteModelItem = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        conversationViewModel.retryMessage(str, list, remoteModelItem, z);
    }

    public final void retryMessage(String assistantMessageId, List<ParsedChatMessage> allMessages, RemoteModelItem selectedModel, boolean useFastRequest) {
        ParsedChatMessage parsedChatMessage;
        ParsedChatMessage parsedChatMessage2;
        Object obj;
        Mode mode;
        Mode mode2;
        Mode mode3;
        Object obj2;
        Object obj3;
        JsonObject data;
        JsonElement jsonElement;
        String asString;
        Object obj4;
        Intrinsics.checkNotNullParameter(assistantMessageId, "assistantMessageId");
        if (this._sessionTurnStatus.getValue() == SessionTurnStatus.STREAMING) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationViewModel$retryMessage$1(this, null), 3, (Object) null);
            return;
        }
        if (allMessages == null) {
            allMessages = (List) this._messages.getValue();
        }
        Iterator<ParsedChatMessage> it = allMessages.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getMessageId(), assistantMessageId)) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            TraeLogUtil.INSTANCE.e(TAG, "retryMessage: assistant message not found, id=" + assistantMessageId);
            return;
        }
        String replyToMessageId = allMessages.get(i).getReplyToMessageId();
        if (replyToMessageId == null) {
            List<ParsedChatMessage> subList = allMessages.subList(0, i);
            ListIterator<ParsedChatMessage> listIterator = subList.listIterator(subList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    parsedChatMessage = null;
                    break;
                } else {
                    parsedChatMessage = listIterator.previous();
                    if (parsedChatMessage.isUserMessage()) {
                        break;
                    }
                }
            }
            parsedChatMessage2 = parsedChatMessage;
        } else {
            Iterator<T> it2 = allMessages.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj4 = null;
                    break;
                }
                obj4 = it2.next();
                ParsedChatMessage parsedChatMessage3 = (ParsedChatMessage) obj4;
                if (parsedChatMessage3.isUserMessage() && Intrinsics.areEqual(parsedChatMessage3.getMessageId(), replyToMessageId)) {
                    break;
                }
            }
            parsedChatMessage2 = (ParsedChatMessage) obj4;
        }
        if (parsedChatMessage2 == null) {
            TraeLogUtil.INSTANCE.e(TAG, "retryMessage: user message not found for assistant=" + assistantMessageId);
            return;
        }
        List<MessagePart> query = parsedChatMessage2.getQuery();
        if (query == null || query.isEmpty()) {
            return;
        }
        String userContent = parsedChatMessage2.getUserContent();
        String obj5 = userContent != null ? StringsKt.trim(userContent).toString() : null;
        String str = obj5;
        if (str == null || str.length() == 0) {
            List<MessagePart> query2 = parsedChatMessage2.getQuery();
            if (query2 != null) {
                Iterator<T> it3 = query2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj3 = null;
                        break;
                    } else {
                        obj3 = it3.next();
                        if (Intrinsics.areEqual(((MessagePart) obj3).getType(), "text")) {
                            break;
                        }
                    }
                }
                MessagePart messagePart = (MessagePart) obj3;
                if (messagePart != null && (data = messagePart.getData()) != null && (jsonElement = data.get(ReportConstant.COMMON_CONTENT)) != null) {
                    if (!jsonElement.isJsonPrimitive()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null && (asString = jsonElement.getAsString()) != null) {
                        obj5 = StringsKt.trim(asString).toString();
                    }
                }
            }
            obj5 = null;
        }
        String json = this.gson.toJson(parsedChatMessage2.getQuery());
        SelectedDeviceItem selectedDeviceItem = (SelectedDeviceItem) this._selectedDevice.getValue();
        if (selectedDeviceItem == null) {
            return;
        }
        if (selectedDeviceItem.getType() == CliType.REMOTE) {
            Iterator it4 = Mode.getEntries().iterator();
            while (true) {
                if (!it4.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it4.next();
                String value = ((Mode) obj2).getValue();
                Conversation conversation = (Conversation) this._conversation.getValue();
                if (Intrinsics.areEqual(value, conversation != null ? conversation.getMode() : null)) {
                    break;
                }
            }
            mode = (Mode) obj2;
            if (mode == null) {
                mode2 = Mode.WORK;
                mode3 = mode2;
            }
            mode3 = mode;
        } else {
            Iterator it5 = Mode.getEntries().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it5.next();
                String value2 = ((Mode) obj).getValue();
                Conversation conversation2 = (Conversation) this._conversation.getValue();
                if (Intrinsics.areEqual(value2, conversation2 != null ? conversation2.getMode() : null)) {
                    break;
                }
            }
            mode = (Mode) obj;
            if (mode == null) {
                mode2 = Mode.WORK;
                mode3 = mode2;
            }
            mode3 = mode;
        }
        TraeLogUtil.INSTANCE.d(TAG, "retryMessage: re-sending userMessage=" + parsedChatMessage2.getMessageId() + " for assistant=" + assistantMessageId + ", selectedModel=" + (selectedModel != null ? selectedModel.getName() : null));
        if (obj5 == null) {
            obj5 = "";
        }
        Intrinsics.checkNotNull(json);
        sendMessage(obj5, json, mode3, selectedModel, useFastRequest);
    }

    public final void fetchEventsIfNeeded(String conversationId, String taskId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        IMService.INSTANCE.fetchEventsIfNeeded(taskId, conversationId, getKeva());
    }

    public final Keva getKeva() {
        String str;
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (str = accountInfo.getUserId()) == null) {
            str = "";
        }
        Keva repo = Keva.getRepo(str + "events");
        Intrinsics.checkNotNullExpressionValue(repo, "getRepo(...)");
        return repo;
    }

    public final ParsedChatMessage getLatestUnpairedUserMessage(List<ParsedChatMessage> messages) {
        Object obj;
        Intrinsics.checkNotNullParameter(messages, "messages");
        List<ParsedChatMessage> list = messages;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (((ParsedChatMessage) obj2).isAssistantMessage()) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String replyToMessageId = ((ParsedChatMessage) it.next()).getReplyToMessageId();
            if (replyToMessageId != null) {
                arrayList2.add(replyToMessageId);
            }
        }
        Set set = CollectionsKt.toSet(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list) {
            ParsedChatMessage parsedChatMessage = (ParsedChatMessage) obj3;
            if (parsedChatMessage.isUserMessage() && !set.contains(parsedChatMessage.getMessageId())) {
                arrayList3.add(obj3);
            }
        }
        Iterator it2 = arrayList3.iterator();
        if (it2.hasNext()) {
            Object next = it2.next();
            if (it2.hasNext()) {
                long createdAt = ((ParsedChatMessage) next).getCreatedAt();
                do {
                    Object next2 = it2.next();
                    long createdAt2 = ((ParsedChatMessage) next2).getCreatedAt();
                    if (createdAt < createdAt2) {
                        next = next2;
                        createdAt = createdAt2;
                    }
                } while (it2.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (ParsedChatMessage) obj;
    }

    static /* synthetic */ ParsedChatMessage buildRemoteUserMessage$default(ConversationViewModel conversationViewModel, String str, String str2, JsonElement jsonElement, Integer num, Long l, boolean z, int i, Object obj) {
        if ((i & 32) != 0) {
            z = false;
        }
        return conversationViewModel.buildRemoteUserMessage(str, str2, jsonElement, num, l, z);
    }

    private final ParsedChatMessage buildRemoteUserMessage(String conversationId, String messageId, JsonElement r65, Integer messageIndex, Long createdAt, boolean isAppendMessage) {
        long currentTimeMillis;
        List<MessagePart> parseContent = MessagePartNormalizer.INSTANCE.parseContent(r65);
        String extractText$default = MessagePartNormalizer.extractText$default(MessagePartNormalizer.INSTANCE, parseContent, null, 2, null);
        String str = extractText$default;
        boolean z = true;
        if (str == null || str.length() == 0) {
            List<MessagePart> list = parseContent;
            if (list != null && !list.isEmpty()) {
                z = false;
            }
            if (z) {
                return null;
            }
        }
        int intValue = messageIndex != null ? messageIndex.intValue() : 0;
        if (createdAt != null) {
            currentTimeMillis = ParsedChatMessage.INSTANCE.normalizeToMillis(createdAt.longValue());
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        return new ParsedChatMessage(conversationId, messageId, null, null, null, null, ParsedChatMessage.ROLE_USER, intValue, null, null, null, null, null, null, null, null, null, null, null, null, null, null, currentTimeMillis, null, null, null, null, null, null, null, null, null, null, null, null, null, null, extractText$default, parseContent, null, true, isAppendMessage, false, null, null, null, null, null, null, null, null, null, null, null, null, -4194500, 8387743, null);
    }

    private final String extractQueryFromUserMessageContext(UserMessageContext ctx) {
        Object query = ctx.getQuery();
        String str = null;
        if (query == null) {
            return null;
        }
        if (query instanceof String) {
            return (String) query;
        }
        try {
            str = new Gson().toJson(query);
        } catch (Exception unused) {
        }
        return str;
    }
}
