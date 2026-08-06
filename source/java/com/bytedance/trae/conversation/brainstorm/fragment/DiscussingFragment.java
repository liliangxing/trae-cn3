package com.bytedance.trae.conversation.brainstorm.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.MimeTypeMap;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.common.widget.PermissionRationaleDialog;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.BrainstormActivity;
import com.bytedance.trae.conversation.brainstorm.BrainstormHaptics;
import com.bytedance.trae.conversation.brainstorm.BrainstormViewModel;
import com.bytedance.trae.conversation.brainstorm.MinimizeResult;
import com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter;
import com.bytedance.trae.conversation.brainstorm.health.VoiceCheckTrigger;
import com.bytedance.trae.conversation.brainstorm.health.VoiceExceptionGuard;
import com.bytedance.trae.conversation.brainstorm.health.VoicePrompt;
import com.bytedance.trae.conversation.brainstorm.health.VoicePromptCenter;
import com.bytedance.trae.conversation.brainstorm.model.AttachmentState;
import com.bytedance.trae.conversation.brainstorm.model.AudioDevice;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState;
import com.bytedance.trae.conversation.brainstorm.model.MessageRole;
import com.bytedance.trae.conversation.brainstorm.model.ParticipantState;
import com.bytedance.trae.conversation.brainstorm.model.TimeoutState;
import com.bytedance.trae.conversation.brainstorm.widget.AiSubtitleView;
import com.bytedance.trae.conversation.brainstorm.widget.AudioSwitchToast;
import com.bytedance.trae.conversation.brainstorm.widget.BrainstormActionShadowView;
import com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar;
import com.bytedance.trae.conversation.brainstorm.widget.ShimmerTextView;
import com.bytedance.trae.conversation.brainstorm.widget.SphereController;
import com.bytedance.trae.conversation.brainstorm.widget.VoiceStatusWaveIconView;
import com.bytedance.trae.conversation.debug.ConversationDebugInfoCopier;
import com.bytedance.trae.conversation.mediachoose.model.MediaChooseContract;
import com.bytedance.trae.conversation.mediachoose.model.MediaItem;
import com.bytedance.trae.conversation.mediachoose.p008ui.MediaChooseActivity;
import com.bytedance.trae.conversation.products.InputPreviewActivity;
import com.bytedance.trae.conversation.products.MultiImagePreviewActivity;
import com.bytedance.trae.conversation.tracker.AsrDiscussAction;
import com.bytedance.trae.conversation.tracker.TraeAITracker;
import com.bytedance.trae.conversation.voice.VoiceDiscussionMetrics;
import com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState;
import com.bytedance.trae.conversation.voice.subtask.SubTaskUiState;
import com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator;
import com.bytedance.trae.conversation.widget.ChatAttachmentDialog;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.utils.logger.FLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: DiscussingFragment.kt */
@Metadata(d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\u0018\u0000 »\u00012\u00020\u0001:\n»\u0001¼\u0001½\u0001¾\u0001¿\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010`\u001a\u0004\u0018\u00010\t2\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010\u001d2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u001a\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\t2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0010\u0010i\u001a\u00020g2\u0006\u0010h\u001a\u00020\tH\u0002J\b\u0010j\u001a\u00020gH\u0002J\b\u0010k\u001a\u00020gH\u0003J\b\u0010l\u001a\u00020gH\u0002J\b\u0010m\u001a\u00020gH\u0003J\u0010\u0010n\u001a\u00020g2\u0006\u0010h\u001a\u00020\tH\u0002J\b\u0010o\u001a\u00020gH\u0002J\u0018\u0010p\u001a\u00020g2\u0006\u0010q\u001a\u00020\t2\u0006\u0010r\u001a\u00020:H\u0002J\b\u0010s\u001a\u00020gH\u0002J0\u0010t\u001a\u00020g2\u0006\u0010q\u001a\u00020\t2\u0006\u0010u\u001a\u00020:2\u0006\u0010v\u001a\u00020:2\u0006\u0010w\u001a\u00020:2\u0006\u0010x\u001a\u00020:H\u0002J\b\u0010y\u001a\u00020gH\u0002J\u0010\u0010z\u001a\u00020g2\u0006\u0010{\u001a\u00020$H\u0002J\b\u0010|\u001a\u00020gH\u0002J\b\u0010}\u001a\u00020gH\u0002J\b\u0010~\u001a\u00020gH\u0002J\b\u0010\u007f\u001a\u00020gH\u0002J\u000b\u0010\u0080\u0001\u001a\u0004\u0018\u00010(H\u0002J\u001f\u0010\u0081\u0001\u001a\u00020g2\u0007\u0010\u0082\u0001\u001a\u00020(2\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u000105H\u0002J\u0013\u0010\u0084\u0001\u001a\u00020g2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J\t\u0010\u0087\u0001\u001a\u00020gH\u0002J\t\u0010\u0088\u0001\u001a\u00020gH\u0002J\t\u0010\u0089\u0001\u001a\u00020gH\u0002J\t\u0010\u008a\u0001\u001a\u00020gH\u0002J\t\u0010\u008b\u0001\u001a\u00020gH\u0002J\t\u0010\u008c\u0001\u001a\u00020gH\u0002J\t\u0010\u008d\u0001\u001a\u00020gH\u0002J\u0012\u0010\u008e\u0001\u001a\u00020g2\u0007\u0010\u008f\u0001\u001a\u000201H\u0002J\u0013\u0010\u0090\u0001\u001a\u00020g2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u0013\u0010\u0093\u0001\u001a\u00020g2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u0012\u0010\u0094\u0001\u001a\u00020g2\u0007\u0010\u0095\u0001\u001a\u000201H\u0002JD\u0010\u0096\u0001\u001a\u00020g2\u0007\u0010\u0097\u0001\u001a\u0002052\u0007\u0010\u0098\u0001\u001a\u0002052\u0007\u0010\u0099\u0001\u001a\u0002052\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0002J\u0013\u0010\u009e\u0001\u001a\u00020g2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u001b\u0010\u009f\u0001\u001a\u00020g2\u0007\u0010 \u0001\u001a\u00020<2\u0007\u0010¡\u0001\u001a\u00020:H\u0002J\u0012\u0010¢\u0001\u001a\u00020g2\u0007\u0010£\u0001\u001a\u000201H\u0002J\u0013\u0010¤\u0001\u001a\u00020g2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u0013\u0010¥\u0001\u001a\u0002052\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u0013\u0010¦\u0001\u001a\u0002012\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u0013\u0010§\u0001\u001a\u00020g2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u0013\u0010¨\u0001\u001a\u00020>2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u0013\u0010©\u0001\u001a\u0002012\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u0013\u0010ª\u0001\u001a\u0002012\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\t\u0010«\u0001\u001a\u00020>H\u0002J\t\u0010¬\u0001\u001a\u00020gH\u0002J\t\u0010\u00ad\u0001\u001a\u00020gH\u0002J\u0013\u0010®\u0001\u001a\u0002012\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u0013\u0010¯\u0001\u001a\u00020g2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u001d\u0010°\u0001\u001a\u00020g2\u0007\u0010±\u0001\u001a\u00020>2\t\b\u0002\u0010²\u0001\u001a\u000201H\u0002J\u0012\u0010³\u0001\u001a\u00020g2\u0007\u0010´\u0001\u001a\u00020LH\u0002J\u0011\u0010µ\u0001\u001a\u00020g2\u0006\u0010h\u001a\u00020\tH\u0002J\u0011\u0010¶\u0001\u001a\u00020g2\u0006\u0010h\u001a\u00020\tH\u0002J\u0012\u0010·\u0001\u001a\u00020g2\u0007\u0010¸\u0001\u001a\u000201H\u0002J\t\u0010¹\u0001\u001a\u00020gH\u0002J\t\u0010º\u0001\u001a\u00020gH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020504X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u0002050HX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020AX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020AX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020AX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010W\u001a\u0010\u0012\f\u0012\n Y*\u0004\u0018\u000105050XX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010Z\u001a\u0010\u0012\f\u0012\n Y*\u0004\u0018\u000105050XX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010[\u001a\u0010\u0012\f\u0012\n Y*\u0004\u0018\u00010(0(0XX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\\\u001a\u0010\u0012\f\u0012\n Y*\u0004\u0018\u00010]0]0XX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010^\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000205 Y*\n\u0012\u0004\u0012\u000205\u0018\u00010_0_0XX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006À\u0001"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;", "topBar", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;", "chatModeContainer", "Landroid/view/View;", "subtitleModeContainer", "sphereController", "Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;", "tvAiStatus", "Landroid/widget/TextView;", "aiDisplaySwitcher", "Landroid/widget/FrameLayout;", "aiSubtitleContainer", "rvAiSubtitle", "Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;", "bottomStatusCopyArea", "mainWaveform", "Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;", "bottomStatusText", "Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;", "subtitleEmptyHint", "footerContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "bottomBar", "Landroid/view/ViewGroup;", "btnMic", "Landroid/widget/Button;", "btnAttach", "btnConfirm", "bottomActionShadowTargets", "", "Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;", "bottomActionButtonRect", "Landroid/graphics/Rect;", "pendingCameraUri", "Landroid/net/Uri;", "rvHistorySubtitle", "Landroidx/recyclerview/widget/RecyclerView;", "btnScrollToBottom", "Landroid/widget/ImageView;", "subtitleTopGradient", "historySubtitleAdapter", "Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;", "isUserScrolling", "", "isDragging", "lastSubTaskRouteLogs", "", "", "curSphereState", "curIsMicMuted", "curIsSubtitleMode", "curTimerSeconds", "", "curTimeoutState", "Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;", "curBottomStatus", "Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;", "bottomTaskDoneTaskId", "bottomTaskDoneUntilMs", "", "bottomTaskDoneClearRunnable", "Ljava/lang/Runnable;", "taskRunningSinceMs", "taskRunningLongRunnable", "subtitleModeHideRunnable", "seenBottomTerminalTaskIds", "", "lastSubtitleRenderSnapshot", "Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;", "curAiDisplayMode", "Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;", "isWaitingAnswerFinish", "hasEverBeenActive", "displaySwitchDelayMs", "displaySwitchHandler", "Landroid/os/Handler;", "pendingDisplaySwitch", "taskDoneHoldMs", "taskRunningLongDelayMs", "enterMediaPlayer", "Landroid/media/MediaPlayer;", "micPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "cameraPermissionLauncher", "takePictureLauncher", "mediaChooseLauncher", "Landroid/content/Intent;", "filePickerLauncher", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "bindViews", "setupBottomStatusView", "setupBottomDebugCopyGesture", "setupTopBar", "setupSphereWebView", "setupBottomButtons", "layoutBottomActions", "setStartMargin", "target", "marginStart", "setupBottomButtonShadows", "addBottomActionShadow", "backgroundColorRes", "shadowColor", "shadowRadius", "shadowDy", "updateBottomActionShadows", "updateBottomActionShadow", "entry", "showAttachmentPicker", "launchMediaChooser", "requestCameraThenLaunch", "openCamera", "createImageUri", "dispatchPickedUri", "uri", "groupId", "previewAttachment", "attachment", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "showAudioSwitchToast", "playEnterSound", "seedSubtitleHistoryFromState", "setupSubtitleRecyclerView", "showScrollToBottomButton", "hideScrollToBottomButton", "observeState", "updateWaveformAnimating", "isRtcJoined", "updateSubtitleListIfNeeded", "state", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;", "updateSubtitleList", "updateSubtitleEmptyHint", "show", "logSubTaskBadgeRoute", "messageId", "taskId", "route", "badge", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;", "terminalState", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;", "updateTimer", "updateTimeoutState", "timeoutState", "remainingSeconds", "updateMicUi", "isMicMuted", "updateParticipantStates", "resolveSphereState", "isTaskProcessingForSphere", "updateAiDisplay", "resolveBottomStatus", "isAiReplying", "hasMeaningfulUserInput", "resolveTaskRunningStatus", "scheduleTaskRunningLongRefresh", "resetTaskRunningClock", "hasPendingAnchoredSubTask", "updateTaskDoneHold", "updateBottomStatusText", PageDataManager.EXTRA_STATUS, "force", "performAiDisplaySwitch", "targetMode", "fadeInView", "fadeOutView", "updateContentMode", "subtitleMode", "updateSubtitleTopGradient", "onDestroyView", "Companion", "BottomShadowEntry", "AiDisplayMode", "BottomStatus", "SubtitleRenderSnapshot", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DiscussingFragment extends Fragment {
    private static final long SUBTITLE_MODE_EXIT_HOLD_MS = 250;
    private static final String TAG = "DiscussingFragment";
    private FrameLayout aiDisplaySwitcher;
    private FrameLayout aiSubtitleContainer;
    private ViewGroup bottomBar;
    private View bottomStatusCopyArea;
    private ShimmerTextView bottomStatusText;
    private Runnable bottomTaskDoneClearRunnable;
    private String bottomTaskDoneTaskId;
    private long bottomTaskDoneUntilMs;
    private Button btnAttach;
    private Button btnConfirm;
    private Button btnMic;
    private ImageView btnScrollToBottom;
    private final ActivityResultLauncher<String> cameraPermissionLauncher;
    private View chatModeContainer;
    private boolean curIsMicMuted;
    private boolean curIsSubtitleMode;
    private String curSphereState;
    private MediaPlayer enterMediaPlayer;
    private final ActivityResultLauncher<String[]> filePickerLauncher;
    private ConstraintLayout footerContainer;
    private boolean hasEverBeenActive;
    private boolean isDragging;
    private boolean isUserScrolling;
    private boolean isWaitingAnswerFinish;
    private SubtitleRenderSnapshot lastSubtitleRenderSnapshot;
    private VoiceStatusWaveIconView mainWaveform;
    private final ActivityResultLauncher<Intent> mediaChooseLauncher;
    private final ActivityResultLauncher<String> micPermissionLauncher;
    private Uri pendingCameraUri;
    private Runnable pendingDisplaySwitch;
    private AiSubtitleView rvAiSubtitle;
    private RecyclerView rvHistorySubtitle;
    private SphereController sphereController;
    private ShimmerTextView subtitleEmptyHint;
    private View subtitleModeContainer;
    private Runnable subtitleModeHideRunnable;
    private View subtitleTopGradient;
    private final ActivityResultLauncher<Uri> takePictureLauncher;
    private Runnable taskRunningLongRunnable;
    private long taskRunningSinceMs;
    private BrainstormTopBar topBar;
    private TextView tvAiStatus;
    private BrainstormViewModel viewModel;
    private static final Set<SubTaskRenderState> IN_FLIGHT_SUB_TASK_STATES = SetsKt.setOf(new SubTaskRenderState[]{SubTaskRenderState.Creating, SubTaskRenderState.Thinking, SubTaskRenderState.Streaming});
    private static final Set<SubTaskRenderState> TERMINAL_BOTTOM_SUB_TASK_STATES = SetsKt.setOf(new SubTaskRenderState[]{SubTaskRenderState.Done, SubTaskRenderState.Failed});
    private final List<BottomShadowEntry> bottomActionShadowTargets = new ArrayList();
    private final Rect bottomActionButtonRect = new Rect();
    private final HistorySubtitleAdapter historySubtitleAdapter = new HistorySubtitleAdapter();
    private final Map<String, String> lastSubTaskRouteLogs = new LinkedHashMap();
    private int curTimerSeconds = -1;
    private TimeoutState curTimeoutState = TimeoutState.Normal;
    private BottomStatus curBottomStatus = BottomStatus.Prompt;
    private final Set<String> seenBottomTerminalTaskIds = new LinkedHashSet();
    private AiDisplayMode curAiDisplayMode = AiDisplayMode.HIDDEN;
    private final long displaySwitchDelayMs = 200;
    private final Handler displaySwitchHandler = new Handler(Looper.getMainLooper());
    private final long taskDoneHoldMs = 3000;
    private final long taskRunningLongDelayMs = SubTaskUiState.LONG_RUNNING_THRESHOLD_MS;

    /* compiled from: DiscussingFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[ChatAttachmentDialog.AttachmentType.values().length];
            try {
                iArr[ChatAttachmentDialog.AttachmentType.CAMERA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChatAttachmentDialog.AttachmentType.PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ChatAttachmentDialog.AttachmentType.FILES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ChatAttachmentDialog.AttachmentType.SKILLS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ChatAttachmentDialog.AttachmentType.PLUGINS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AudioDevice.values().length];
            try {
                iArr2[AudioDevice.Speaker.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[AudioDevice.Earpiece.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[BottomStatus.values().length];
            try {
                iArr3[BottomStatus.Prompt.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[BottomStatus.Listening.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[BottomStatus.Thinking.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[BottomStatus.Answering.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[BottomStatus.TaskRunning.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[BottomStatus.TaskRunningLong.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[BottomStatus.TaskDone.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[AiDisplayMode.values().length];
            try {
                iArr4[AiDisplayMode.HIDDEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr4[AiDisplayMode.STATUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr4[AiDisplayMode.SUBTITLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    public DiscussingFragment() {
        ActivityResultLauncher<String> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda20
            public final void onActivityResult(Object obj) {
                DiscussingFragment.micPermissionLauncher$lambda$0(DiscussingFragment.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.micPermissionLauncher = registerForActivityResult;
        ActivityResultLauncher<String> registerForActivityResult2 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda21
            public final void onActivityResult(Object obj) {
                DiscussingFragment.cameraPermissionLauncher$lambda$1(DiscussingFragment.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.cameraPermissionLauncher = registerForActivityResult2;
        ActivityResultLauncher<Uri> registerForActivityResult3 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.TakePicture(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda22
            public final void onActivityResult(Object obj) {
                DiscussingFragment.takePictureLauncher$lambda$3(DiscussingFragment.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult3, "registerForActivityResult(...)");
        this.takePictureLauncher = registerForActivityResult3;
        ActivityResultLauncher<Intent> registerForActivityResult4 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda23
            public final void onActivityResult(Object obj) {
                DiscussingFragment.mediaChooseLauncher$lambda$5(DiscussingFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult4, "registerForActivityResult(...)");
        this.mediaChooseLauncher = registerForActivityResult4;
        ActivityResultLauncher<String[]> registerForActivityResult5 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.OpenMultipleDocuments(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda24
            public final void onActivityResult(Object obj) {
                DiscussingFragment.filePickerLauncher$lambda$7(DiscussingFragment.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult5, "registerForActivityResult(...)");
        this.filePickerLauncher = registerForActivityResult5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiscussingFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;", "", "shadowView", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;", "target", "Landroid/view/View;", "radius", "", "paddingTop", "paddingBottom", "<init>", "(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;Landroid/view/View;III)V", "getShadowView", "()Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;", "getTarget", "()Landroid/view/View;", "getRadius", "()I", "getPaddingTop", "getPaddingBottom", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class BottomShadowEntry {
        private final int paddingBottom;
        private final int paddingTop;
        private final int radius;
        private final BrainstormActionShadowView shadowView;
        private final View target;

        public BottomShadowEntry(BrainstormActionShadowView brainstormActionShadowView, View view, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(brainstormActionShadowView, "shadowView");
            Intrinsics.checkNotNullParameter(view, "target");
            this.shadowView = brainstormActionShadowView;
            this.target = view;
            this.radius = i;
            this.paddingTop = i2;
            this.paddingBottom = i3;
        }

        public final BrainstormActionShadowView getShadowView() {
            return this.shadowView;
        }

        public final View getTarget() {
            return this.target;
        }

        public final int getRadius() {
            return this.radius;
        }

        public final int getPaddingTop() {
            return this.paddingTop;
        }

        public final int getPaddingBottom() {
            return this.paddingBottom;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DiscussingFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "STATUS", "SUBTITLE", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class AiDisplayMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AiDisplayMode[] $VALUES;
        public static final AiDisplayMode HIDDEN = new AiDisplayMode("HIDDEN", 0);
        public static final AiDisplayMode STATUS = new AiDisplayMode("STATUS", 1);
        public static final AiDisplayMode SUBTITLE = new AiDisplayMode("SUBTITLE", 2);

        private static final /* synthetic */ AiDisplayMode[] $values() {
            return new AiDisplayMode[]{HIDDEN, STATUS, SUBTITLE};
        }

        public static EnumEntries<AiDisplayMode> getEntries() {
            return $ENTRIES;
        }

        static {
            AiDisplayMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private AiDisplayMode(String str, int i) {
        }

        public static AiDisplayMode valueOf(String str) {
            return (AiDisplayMode) Enum.valueOf(AiDisplayMode.class, str);
        }

        public static AiDisplayMode[] values() {
            return (AiDisplayMode[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DiscussingFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Prompt", "Listening", "Thinking", "Answering", "TaskRunning", "TaskRunningLong", "TaskDone", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class BottomStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BottomStatus[] $VALUES;
        public static final BottomStatus Prompt = new BottomStatus("Prompt", 0);
        public static final BottomStatus Listening = new BottomStatus("Listening", 1);
        public static final BottomStatus Thinking = new BottomStatus("Thinking", 2);
        public static final BottomStatus Answering = new BottomStatus("Answering", 3);
        public static final BottomStatus TaskRunning = new BottomStatus("TaskRunning", 4);
        public static final BottomStatus TaskRunningLong = new BottomStatus("TaskRunningLong", 5);
        public static final BottomStatus TaskDone = new BottomStatus("TaskDone", 6);

        private static final /* synthetic */ BottomStatus[] $values() {
            return new BottomStatus[]{Prompt, Listening, Thinking, Answering, TaskRunning, TaskRunningLong, TaskDone};
        }

        public static EnumEntries<BottomStatus> getEntries() {
            return $ENTRIES;
        }

        private BottomStatus(String str, int i) {
        }

        static {
            BottomStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static BottomStatus valueOf(String str) {
            return (BottomStatus) Enum.valueOf(BottomStatus.class, str);
        }

        public static BottomStatus[] values() {
            return (BottomStatus[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiscussingFragment.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001Ba\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003J\t\u0010(\u001a\u00020\u0011HÆ\u0003Js\u0010)\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010*\u001a\u00020\u00112\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010 ¨\u0006/"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;", "", "subtitleHistory", "", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;", "attachments", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "subTask", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;", "finishedSubTasks", "", "", "botTranscript", "currentTranscript", "aiParticipantState", "Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;", "isSubtitleMode", "", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;Z)V", "getSubtitleHistory", "()Ljava/util/List;", "getAttachments", "getSubTask", "()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;", "getFinishedSubTasks", "()Ljava/util/Map;", "getBotTranscript", "()Ljava/lang/String;", "getCurrentTranscript", "getAiParticipantState", "()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class SubtitleRenderSnapshot {
        private final ParticipantState aiParticipantState;
        private final List<BrainstormAttachment> attachments;
        private final String botTranscript;
        private final String currentTranscript;
        private final Map<String, SubTaskUiState> finishedSubTasks;
        private final boolean isSubtitleMode;
        private final SubTaskUiState subTask;
        private final List<BrainstormMessage> subtitleHistory;

        public final List<BrainstormMessage> component1() {
            return this.subtitleHistory;
        }

        public final List<BrainstormAttachment> component2() {
            return this.attachments;
        }

        /* renamed from: component3, reason: from getter */
        public final SubTaskUiState getSubTask() {
            return this.subTask;
        }

        public final Map<String, SubTaskUiState> component4() {
            return this.finishedSubTasks;
        }

        /* renamed from: component5, reason: from getter */
        public final String getBotTranscript() {
            return this.botTranscript;
        }

        /* renamed from: component6, reason: from getter */
        public final String getCurrentTranscript() {
            return this.currentTranscript;
        }

        /* renamed from: component7, reason: from getter */
        public final ParticipantState getAiParticipantState() {
            return this.aiParticipantState;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getIsSubtitleMode() {
            return this.isSubtitleMode;
        }

        public final SubtitleRenderSnapshot copy(List<BrainstormMessage> subtitleHistory, List<BrainstormAttachment> attachments, SubTaskUiState subTask, Map<String, SubTaskUiState> finishedSubTasks, String botTranscript, String currentTranscript, ParticipantState aiParticipantState, boolean isSubtitleMode) {
            Intrinsics.checkNotNullParameter(subtitleHistory, "subtitleHistory");
            Intrinsics.checkNotNullParameter(attachments, "attachments");
            Intrinsics.checkNotNullParameter(finishedSubTasks, "finishedSubTasks");
            Intrinsics.checkNotNullParameter(botTranscript, "botTranscript");
            Intrinsics.checkNotNullParameter(currentTranscript, "currentTranscript");
            Intrinsics.checkNotNullParameter(aiParticipantState, "aiParticipantState");
            return new SubtitleRenderSnapshot(subtitleHistory, attachments, subTask, finishedSubTasks, botTranscript, currentTranscript, aiParticipantState, isSubtitleMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubtitleRenderSnapshot)) {
                return false;
            }
            SubtitleRenderSnapshot subtitleRenderSnapshot = (SubtitleRenderSnapshot) other;
            return Intrinsics.areEqual(this.subtitleHistory, subtitleRenderSnapshot.subtitleHistory) && Intrinsics.areEqual(this.attachments, subtitleRenderSnapshot.attachments) && Intrinsics.areEqual(this.subTask, subtitleRenderSnapshot.subTask) && Intrinsics.areEqual(this.finishedSubTasks, subtitleRenderSnapshot.finishedSubTasks) && Intrinsics.areEqual(this.botTranscript, subtitleRenderSnapshot.botTranscript) && Intrinsics.areEqual(this.currentTranscript, subtitleRenderSnapshot.currentTranscript) && this.aiParticipantState == subtitleRenderSnapshot.aiParticipantState && this.isSubtitleMode == subtitleRenderSnapshot.isSubtitleMode;
        }

        public int hashCode() {
            int hashCode = ((this.subtitleHistory.hashCode() * 31) + this.attachments.hashCode()) * 31;
            SubTaskUiState subTaskUiState = this.subTask;
            return ((((((((((hashCode + (subTaskUiState == null ? 0 : subTaskUiState.hashCode())) * 31) + this.finishedSubTasks.hashCode()) * 31) + this.botTranscript.hashCode()) * 31) + this.currentTranscript.hashCode()) * 31) + this.aiParticipantState.hashCode()) * 31) + Boolean.hashCode(this.isSubtitleMode);
        }

        public String toString() {
            return "SubtitleRenderSnapshot(subtitleHistory=" + this.subtitleHistory + ", attachments=" + this.attachments + ", subTask=" + this.subTask + ", finishedSubTasks=" + this.finishedSubTasks + ", botTranscript=" + this.botTranscript + ", currentTranscript=" + this.currentTranscript + ", aiParticipantState=" + this.aiParticipantState + ", isSubtitleMode=" + this.isSubtitleMode + ')';
        }

        public SubtitleRenderSnapshot(List<BrainstormMessage> list, List<BrainstormAttachment> list2, SubTaskUiState subTaskUiState, Map<String, SubTaskUiState> map, String str, String str2, ParticipantState participantState, boolean z) {
            Intrinsics.checkNotNullParameter(list, "subtitleHistory");
            Intrinsics.checkNotNullParameter(list2, "attachments");
            Intrinsics.checkNotNullParameter(map, "finishedSubTasks");
            Intrinsics.checkNotNullParameter(str, "botTranscript");
            Intrinsics.checkNotNullParameter(str2, "currentTranscript");
            Intrinsics.checkNotNullParameter(participantState, "aiParticipantState");
            this.subtitleHistory = list;
            this.attachments = list2;
            this.subTask = subTaskUiState;
            this.finishedSubTasks = map;
            this.botTranscript = str;
            this.currentTranscript = str2;
            this.aiParticipantState = participantState;
            this.isSubtitleMode = z;
        }

        public final List<BrainstormMessage> getSubtitleHistory() {
            return this.subtitleHistory;
        }

        public final List<BrainstormAttachment> getAttachments() {
            return this.attachments;
        }

        public final SubTaskUiState getSubTask() {
            return this.subTask;
        }

        public final Map<String, SubTaskUiState> getFinishedSubTasks() {
            return this.finishedSubTasks;
        }

        public final String getBotTranscript() {
            return this.botTranscript;
        }

        public final String getCurrentTranscript() {
            return this.currentTranscript;
        }

        public final ParticipantState getAiParticipantState() {
            return this.aiParticipantState;
        }

        public final boolean isSubtitleMode() {
            return this.isSubtitleMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void micPermissionLauncher$lambda$0(DiscussingFragment discussingFragment, Boolean bool) {
        BrainstormViewModel brainstormViewModel = null;
        if (bool.booleanValue()) {
            BrainstormViewModel brainstormViewModel2 = discussingFragment.viewModel;
            if (brainstormViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                brainstormViewModel = brainstormViewModel2;
            }
            brainstormViewModel.startRecording();
            return;
        }
        View view = discussingFragment.getView();
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null) {
            return;
        }
        VoicePromptCenter.INSTANCE.enqueue(viewGroup, VoicePrompt.Runtime.MicPermissionDeniedRuntime.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cameraPermissionLauncher$lambda$1(DiscussingFragment discussingFragment, Boolean bool) {
        if (!bool.booleanValue()) {
            Toast.makeText(discussingFragment.requireContext(), R.string.trae_permission_camera_message, 0).show();
        } else {
            discussingFragment.openCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void takePictureLauncher$lambda$3(DiscussingFragment discussingFragment, Boolean bool) {
        Uri uri = discussingFragment.pendingCameraUri;
        discussingFragment.pendingCameraUri = null;
        if (bool.booleanValue() && uri != null) {
            dispatchPickedUri$default(discussingFragment, uri, null, 2, null);
        } else if (uri != null) {
            try {
                discussingFragment.requireContext().getContentResolver().delete(uri, null, null);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mediaChooseLauncher$lambda$5(DiscussingFragment discussingFragment, ActivityResult activityResult) {
        Intent data;
        ArrayList parcelableArrayListExtra;
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null || (parcelableArrayListExtra = data.getParcelableArrayListExtra(MediaChooseContract.RESULT_SELECTED)) == null) {
            return;
        }
        String uuid = parcelableArrayListExtra.size() > 1 ? UUID.randomUUID().toString() : null;
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            discussingFragment.dispatchPickedUri(((MediaItem) it.next()).getUri(), uuid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filePickerLauncher$lambda$7(DiscussingFragment discussingFragment, List list) {
        Intrinsics.checkNotNullParameter(list, "uris");
        if (list.isEmpty()) {
            return;
        }
        String uuid = list.size() > 1 ? UUID.randomUUID().toString() : null;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            discussingFragment.dispatchPickedUri((Uri) it.next(), uuid);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.trae_fragment_brainstorm_discuss, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModelStoreOwner requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.viewModel = new ViewModelProvider(requireActivity).get(BrainstormViewModel.class);
        bindViews(view);
        setupBottomStatusView();
        setupTopBar();
        setupSphereWebView();
        setupBottomButtons(view);
        setupSubtitleRecyclerView();
        seedSubtitleHistoryFromState();
        observeState();
        BrainstormActivity activity = getActivity();
        BrainstormActivity brainstormActivity = activity instanceof BrainstormActivity ? activity : null;
        boolean z = false;
        if (brainstormActivity != null && brainstormActivity.getIsRestoredFromMinimized()) {
            z = true;
        }
        if (!z) {
            playEnterSound();
            BrainstormHaptics brainstormHaptics = BrainstormHaptics.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            brainstormHaptics.playSoftImpact(requireContext);
        }
        VoiceExceptionGuard.INSTANCE.checkAndToast((ViewGroup) view, VoiceCheckTrigger.DISCUSSING_ENTERED);
    }

    private final void bindViews(View view) {
        Object findViewById = view.findViewById(C0637R.id.top_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.topBar = (BrainstormTopBar) findViewById;
        View findViewById2 = view.findViewById(C0637R.id.chat_mode_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.chatModeContainer = findViewById2;
        View findViewById3 = view.findViewById(C0637R.id.subtitle_mode_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.subtitleModeContainer = findViewById3;
        View findViewById4 = view.findViewById(C0637R.id.webview_sphere);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        SphereController sphereController = new SphereController((WebView) findViewById4);
        sphereController.setSphereRatio(Float.valueOf(0.68f));
        this.sphereController = sphereController;
        View findViewById5 = view.findViewById(C0637R.id.tv_ai_status);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.tvAiStatus = (TextView) findViewById5;
        View findViewById6 = view.findViewById(C0637R.id.ai_display_switcher);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.aiDisplaySwitcher = (FrameLayout) findViewById6;
        View findViewById7 = view.findViewById(C0637R.id.ai_subtitle_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.aiSubtitleContainer = (FrameLayout) findViewById7;
        Object findViewById8 = view.findViewById(C0637R.id.rv_ai_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.rvAiSubtitle = (AiSubtitleView) findViewById8;
        View findViewById9 = view.findViewById(C0637R.id.test_frame);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.bottomStatusCopyArea = findViewById9;
        View findViewById10 = view.findViewById(C0637R.id.main_waveform);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        this.mainWaveform = (VoiceStatusWaveIconView) findViewById10;
        Object findViewById11 = view.findViewById(C0637R.id.tv_bottom_status);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        this.bottomStatusText = (ShimmerTextView) findViewById11;
        Object findViewById12 = view.findViewById(C0637R.id.tv_subtitle_empty_hint);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        this.subtitleEmptyHint = (ShimmerTextView) findViewById12;
        ConstraintLayout findViewById13 = view.findViewById(C0637R.id.footer_container);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
        this.footerContainer = findViewById13;
        View findViewById14 = view.findViewById(C0637R.id.bottom_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
        this.bottomBar = (ViewGroup) findViewById14;
        View findViewById15 = view.findViewById(C0637R.id.btn_mic);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(...)");
        this.btnMic = (Button) findViewById15;
        View findViewById16 = view.findViewById(C0637R.id.btn_attach);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(...)");
        this.btnAttach = (Button) findViewById16;
        View findViewById17 = view.findViewById(C0637R.id.btn_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(...)");
        this.btnConfirm = (Button) findViewById17;
        RecyclerView findViewById18 = view.findViewById(C0637R.id.rv_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(...)");
        this.rvHistorySubtitle = findViewById18;
        View findViewById19 = view.findViewById(C0637R.id.btn_scroll_to_bottom);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "findViewById(...)");
        this.btnScrollToBottom = (ImageView) findViewById19;
        View findViewById20 = view.findViewById(C0637R.id.subtitle_top_gradient);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "findViewById(...)");
        this.subtitleTopGradient = findViewById20;
    }

    private final void setupBottomStatusView() {
        VoiceStatusWaveIconView voiceStatusWaveIconView = this.mainWaveform;
        FrameLayout frameLayout = null;
        if (voiceStatusWaveIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainWaveform");
            voiceStatusWaveIconView = null;
        }
        voiceStatusWaveIconView.setWaveColor(ContextCompat.getColor(requireContext(), C0591R.color.trae_text_text_tertiary));
        VoiceStatusWaveIconView voiceStatusWaveIconView2 = this.mainWaveform;
        if (voiceStatusWaveIconView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainWaveform");
            voiceStatusWaveIconView2 = null;
        }
        voiceStatusWaveIconView2.setState(VoiceStatusWaveIconView.State.Slow);
        ShimmerTextView shimmerTextView = this.bottomStatusText;
        if (shimmerTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomStatusText");
            shimmerTextView = null;
        }
        shimmerTextView.setShimmerColors(Color.parseColor("#4D5360"), Color.parseColor("#D5DFF6"));
        updateBottomStatusText(BottomStatus.Prompt, true);
        ShimmerTextView shimmerTextView2 = this.subtitleEmptyHint;
        if (shimmerTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitleEmptyHint");
            shimmerTextView2 = null;
        }
        shimmerTextView2.setShimmerColors(Color.parseColor("#4D5360"), Color.parseColor("#D5DFF6"));
        ShimmerTextView shimmerTextView3 = this.subtitleEmptyHint;
        if (shimmerTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitleEmptyHint");
            shimmerTextView3 = null;
        }
        shimmerTextView3.startShimmer();
        if (!this.hasEverBeenActive) {
            TextView textView = this.tvAiStatus;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAiStatus");
                textView = null;
            }
            textView.setText(C0637R.string.trae_brainstorm_sphere_welcome);
            TextView textView2 = this.tvAiStatus;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAiStatus");
                textView2 = null;
            }
            textView2.setVisibility(0);
        } else {
            TextView textView3 = this.tvAiStatus;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAiStatus");
                textView3 = null;
            }
            textView3.setVisibility(8);
        }
        FrameLayout frameLayout2 = this.aiSubtitleContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiSubtitleContainer");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.setVisibility(8);
        setupBottomDebugCopyGesture();
    }

    private final void setupBottomDebugCopyGesture() {
        final GestureDetector gestureDetector = new GestureDetector(requireContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$setupBottomDebugCopyGesture$detector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                BrainstormViewModel brainstormViewModel;
                Intrinsics.checkNotNullParameter(e, "e");
                ConversationDebugInfoCopier conversationDebugInfoCopier = ConversationDebugInfoCopier.INSTANCE;
                Context requireContext = DiscussingFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                brainstormViewModel = DiscussingFragment.this.viewModel;
                if (brainstormViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    brainstormViewModel = null;
                }
                conversationDebugInfoCopier.copy(requireContext, ConversationDebugInfoCopier.CLIP_LABEL_VOICE_DISCUSSION, brainstormViewModel.buildDiscussionDebugLogInfo());
                return true;
            }
        });
        View view = this.bottomStatusCopyArea;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomStatusCopyArea");
            view = null;
        }
        view.setClickable(true);
        View view3 = this.bottomStatusCopyArea;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomStatusCopyArea");
        } else {
            view2 = view3;
        }
        view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view4, MotionEvent motionEvent) {
                boolean z;
                z = DiscussingFragment.setupBottomDebugCopyGesture$lambda$9(gestureDetector, view4, motionEvent);
                return z;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupBottomDebugCopyGesture$lambda$9(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private final void setupTopBar() {
        BrainstormTopBar brainstormTopBar = this.topBar;
        BrainstormTopBar brainstormTopBar2 = null;
        if (brainstormTopBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBar");
            brainstormTopBar = null;
        }
        brainstormTopBar.setMode(BrainstormTopBar.TopBarMode.DISCUSSING);
        BrainstormTopBar brainstormTopBar3 = this.topBar;
        if (brainstormTopBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBar");
            brainstormTopBar3 = null;
        }
        brainstormTopBar3.setOnBackClick(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda12
            public final Object invoke() {
                Unit unit;
                unit = DiscussingFragment.setupTopBar$lambda$10(DiscussingFragment.this);
                return unit;
            }
        });
        BrainstormTopBar brainstormTopBar4 = this.topBar;
        if (brainstormTopBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBar");
            brainstormTopBar4 = null;
        }
        brainstormTopBar4.setOnSubtitleToggleClick(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda13
            public final Object invoke() {
                Unit unit;
                unit = DiscussingFragment.setupTopBar$lambda$11(DiscussingFragment.this);
                return unit;
            }
        });
        BrainstormActivity requireActivity = requireActivity();
        Intrinsics.checkNotNull(requireActivity, "null cannot be cast to non-null type com.bytedance.trae.conversation.brainstorm.BrainstormActivity");
        boolean isMinimizeDisabled = requireActivity.getIsMinimizeDisabled();
        BrainstormTopBar brainstormTopBar5 = this.topBar;
        if (brainstormTopBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBar");
            brainstormTopBar5 = null;
        }
        brainstormTopBar5.setMinimizeVisible(!isMinimizeDisabled);
        if (isMinimizeDisabled) {
            BrainstormTopBar brainstormTopBar6 = this.topBar;
            if (brainstormTopBar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBar");
                brainstormTopBar6 = null;
            }
            brainstormTopBar6.setOnMinimizeClick(null);
            return;
        }
        BrainstormTopBar brainstormTopBar7 = this.topBar;
        if (brainstormTopBar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBar");
        } else {
            brainstormTopBar2 = brainstormTopBar7;
        }
        brainstormTopBar2.setOnMinimizeClick(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda14
            public final Object invoke() {
                Unit unit;
                unit = DiscussingFragment.setupTopBar$lambda$12(DiscussingFragment.this);
                return unit;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTopBar$lambda$10(DiscussingFragment discussingFragment) {
        BrainstormActivity requireActivity = discussingFragment.requireActivity();
        Intrinsics.checkNotNull(requireActivity, "null cannot be cast to non-null type com.bytedance.trae.conversation.brainstorm.BrainstormActivity");
        requireActivity.showExitConfirmDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTopBar$lambda$11(DiscussingFragment discussingFragment) {
        BrainstormViewModel brainstormViewModel = discussingFragment.viewModel;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        brainstormViewModel.toggleSubtitleMode();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupTopBar$lambda$12(DiscussingFragment discussingFragment) {
        String str;
        BrainstormActivity requireActivity = discussingFragment.requireActivity();
        Intrinsics.checkNotNull(requireActivity, "null cannot be cast to non-null type com.bytedance.trae.conversation.brainstorm.BrainstormActivity");
        Intent intent = requireActivity.getIntent();
        if (intent == null || (str = intent.getStringExtra(BrainstormActivity.EXTRA_CLI_CONVERSATION_ID)) == null) {
            BrainstormViewModel brainstormViewModel = discussingFragment.viewModel;
            if (brainstormViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                brainstormViewModel = null;
            }
            str = brainstormViewModel.get_cliConversationId();
        }
        BrainstormViewModel brainstormViewModel2 = discussingFragment.viewModel;
        if (brainstormViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel2 = null;
        }
        brainstormViewModel2.reportWindowStateClick(VoiceDiscussionMetrics.WINDOW_ACTION_MINIMIZE, "normal");
        BrainstormViewModel brainstormViewModel3 = discussingFragment.viewModel;
        if (brainstormViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel3 = null;
        }
        MinimizeResult minimize = brainstormViewModel3.minimize(str);
        if (minimize instanceof MinimizeResult.Refused) {
            FLogger.INSTANCE.w(TAG, "minimize refused: " + ((MinimizeResult.Refused) minimize).getReason());
            View view = discussingFragment.getView();
            ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
            if (viewGroup != null) {
                VoicePromptCenter.INSTANCE.enqueue(viewGroup, VoicePrompt.Runtime.MinimizeRefused.INSTANCE);
            }
        }
        return Unit.INSTANCE;
    }

    private final void setupSphereWebView() {
        SphereController sphereController = this.sphereController;
        if (sphereController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sphereController");
            sphereController = null;
        }
        sphereController.init();
        SphereController sphereController2 = this.sphereController;
        if (sphereController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sphereController");
            sphereController2 = null;
        }
        SphereController.intro$default(sphereController2, 0, 1, null);
        View view = getView();
        WebView webView = view != null ? (WebView) view.findViewById(C0637R.id.webview_sphere) : null;
        if (webView != null) {
            webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean z;
                    z = DiscussingFragment.setupSphereWebView$lambda$13(view2, motionEvent);
                    return z;
                }
            });
        }
        if (webView != null) {
            webView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DiscussingFragment.setupSphereWebView$lambda$14(DiscussingFragment.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupSphereWebView$lambda$13(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            view.performClick();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSphereWebView$lambda$14(DiscussingFragment discussingFragment, View view) {
        BrainstormViewModel brainstormViewModel = discussingFragment.viewModel;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        brainstormViewModel.toggleSubtitleMode();
    }

    private final void setupBottomButtons(View view) {
        layoutBottomActions();
        setupBottomButtonShadows();
        Button button = this.btnMic;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMic");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DiscussingFragment.setupBottomButtons$lambda$15(DiscussingFragment.this, view2);
            }
        });
        BrainstormViewModel brainstormViewModel = this.viewModel;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        if (brainstormViewModel.getAttachmentSubTaskEnabled()) {
            Button button3 = this.btnAttach;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnAttach");
                button3 = null;
            }
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda18
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DiscussingFragment.setupBottomButtons$lambda$16(DiscussingFragment.this, view2);
                }
            });
        } else {
            Button button4 = this.btnAttach;
            if (button4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnAttach");
                button4 = null;
            }
            button4.setOnClickListener(null);
        }
        Button button5 = this.btnConfirm;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
        } else {
            button2 = button5;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DiscussingFragment.setupBottomButtons$lambda$17(DiscussingFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupBottomButtons$lambda$15(DiscussingFragment discussingFragment, View view) {
        BrainstormViewModel brainstormViewModel = discussingFragment.viewModel;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        brainstormViewModel.toggleMic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupBottomButtons$lambda$16(DiscussingFragment discussingFragment, View view) {
        TraeAITracker.trackAsrDiscuss$default(TraeAITracker.INSTANCE, AsrDiscussAction.ATTACH_BUTTON_CLICK, null, 2, null);
        discussingFragment.showAttachmentPicker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupBottomButtons$lambda$17(DiscussingFragment discussingFragment, View view) {
        TraeAITracker.trackAsrDiscuss$default(TraeAITracker.INSTANCE, AsrDiscussAction.END_DISCUSSION_CLICK, null, 2, null);
        BrainstormHaptics brainstormHaptics = BrainstormHaptics.INSTANCE;
        Context requireContext = discussingFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        brainstormHaptics.playEndDismiss(requireContext);
        BrainstormViewModel brainstormViewModel = discussingFragment.viewModel;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        BrainstormViewModel.endBrainstorm$default(brainstormViewModel, false, 1, null);
    }

    private final void layoutBottomActions() {
        Button button = this.btnAttach;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAttach");
            button = null;
        }
        BrainstormViewModel brainstormViewModel = this.viewModel;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        button.setVisibility(brainstormViewModel.getAttachmentSubTaskEnabled() ? 0 : 8);
        BrainstormViewModel brainstormViewModel2 = this.viewModel;
        if (brainstormViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel2 = null;
        }
        if (brainstormViewModel2.getAttachmentSubTaskEnabled()) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_bottom_action_gap);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_bottom_status_height);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_bottom_status_width);
        View view = this.bottomStatusCopyArea;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomStatusCopyArea");
            view = null;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            View view2 = this.bottomStatusCopyArea;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomStatusCopyArea");
                view2 = null;
            }
            viewGroup.removeView(view2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize3, dimensionPixelSize2);
        layoutParams.setMarginStart(dimensionPixelSize);
        layoutParams.setMarginEnd(dimensionPixelSize);
        ViewGroup viewGroup2 = this.bottomBar;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBar");
            viewGroup2 = null;
        }
        View view3 = this.bottomStatusCopyArea;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomStatusCopyArea");
            view3 = null;
        }
        viewGroup2.addView(view3, 1, layoutParams);
        ViewGroup viewGroup3 = this.bottomBar;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBar");
            viewGroup3 = null;
        }
        ConstraintLayout.LayoutParams layoutParams2 = viewGroup3.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams3 = layoutParams2 instanceof ConstraintLayout.LayoutParams ? layoutParams2 : null;
        if (layoutParams3 != null) {
            layoutParams3.topToBottom = -1;
            layoutParams3.topToTop = 0;
            layoutParams3.topMargin = dimensionPixelSize;
            ViewGroup viewGroup4 = this.bottomBar;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomBar");
                viewGroup4 = null;
            }
            viewGroup4.setLayoutParams((ViewGroup.LayoutParams) layoutParams3);
        }
        Button button3 = this.btnConfirm;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            button3 = null;
        }
        setStartMargin(button3, 0);
        Button button4 = this.btnAttach;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAttach");
        } else {
            button2 = button4;
        }
        setStartMargin(button2, 0);
    }

    private final void setStartMargin(View target, int marginStart) {
        ViewGroup.LayoutParams layoutParams = target.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.setMarginStart(marginStart);
            target.setLayoutParams(layoutParams2);
        }
    }

    private final void setupBottomButtonShadows() {
        ConstraintLayout constraintLayout = this.footerContainer;
        ConstraintLayout constraintLayout2 = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
            constraintLayout = null;
        }
        constraintLayout.setClipChildren(false);
        ConstraintLayout constraintLayout3 = this.footerContainer;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
            constraintLayout3 = null;
        }
        constraintLayout3.setClipToPadding(false);
        ViewGroup viewGroup = this.bottomBar;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBar");
            viewGroup = null;
        }
        viewGroup.setClipChildren(false);
        ViewGroup viewGroup2 = this.bottomBar;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBar");
            viewGroup2 = null;
        }
        viewGroup2.setClipToPadding(false);
        ConstraintLayout constraintLayout4 = this.footerContainer;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
            constraintLayout4 = null;
        }
        ViewParent parent = constraintLayout4.getParent();
        ViewGroup viewGroup3 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
        Button[] buttonArr = new Button[3];
        Button button = this.btnMic;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMic");
            button = null;
        }
        buttonArr[0] = button;
        Button button2 = this.btnConfirm;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            button2 = null;
        }
        buttonArr[1] = button2;
        Button button3 = this.btnAttach;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAttach");
            button3 = null;
        }
        buttonArr[2] = button3;
        for (Button button4 : CollectionsKt.listOf(buttonArr)) {
            button4.setElevation(0.0f);
            button4.setTranslationZ(0.0f);
            button4.setStateListAnimator(null);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_action_shadow_blur_radius);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_action_shadow_offset_y);
        int color = ContextCompat.getColor(requireContext(), C0591R.color.trae_brainstorm_action_shadow);
        this.bottomActionShadowTargets.clear();
        Button button5 = this.btnMic;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMic");
            button5 = null;
        }
        addBottomActionShadow(button5, C0591R.color.trae_bg_bg_base_default, color, dimensionPixelSize, dimensionPixelSize2);
        Button button6 = this.btnConfirm;
        if (button6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            button6 = null;
        }
        addBottomActionShadow(button6, C0591R.color.trae_bg_bg_invert, color, dimensionPixelSize, dimensionPixelSize2);
        BrainstormViewModel brainstormViewModel = this.viewModel;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        if (brainstormViewModel.getAttachmentSubTaskEnabled()) {
            Button button7 = this.btnAttach;
            if (button7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnAttach");
                button7 = null;
            }
            addBottomActionShadow(button7, C0591R.color.trae_bg_bg_base_default, color, dimensionPixelSize, dimensionPixelSize2);
        }
        ConstraintLayout constraintLayout5 = this.footerContainer;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
            constraintLayout5 = null;
        }
        constraintLayout5.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda26
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                DiscussingFragment.this.updateBottomActionShadows();
            }
        });
        ViewGroup viewGroup4 = this.bottomBar;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBar");
            viewGroup4 = null;
        }
        viewGroup4.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda27
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                DiscussingFragment.this.updateBottomActionShadows();
            }
        });
        ConstraintLayout constraintLayout6 = this.footerContainer;
        if (constraintLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
        } else {
            constraintLayout2 = constraintLayout6;
        }
        constraintLayout2.post(new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DiscussingFragment.this.updateBottomActionShadows();
            }
        });
    }

    private final void addBottomActionShadow(View target, int backgroundColorRes, int shadowColor, int shadowRadius, int shadowDy) {
        int coerceAtLeast = RangesKt.coerceAtLeast(shadowRadius - shadowDy, 0);
        int i = shadowRadius + shadowDy;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        BrainstormActionShadowView brainstormActionShadowView = new BrainstormActionShadowView(requireContext, null, 0, 6, null);
        brainstormActionShadowView.configure(shadowColor, ContextCompat.getColor(requireContext(), backgroundColorRes), shadowRadius, shadowDy, coerceAtLeast);
        ConstraintLayout constraintLayout = this.footerContainer;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
            constraintLayout = null;
        }
        constraintLayout.addView(brainstormActionShadowView, 0, new ConstraintLayout.LayoutParams(0, 0));
        this.bottomActionShadowTargets.add(new BottomShadowEntry(brainstormActionShadowView, target, shadowRadius, coerceAtLeast, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBottomActionShadows() {
        Iterator<T> it = this.bottomActionShadowTargets.iterator();
        while (it.hasNext()) {
            updateBottomActionShadow((BottomShadowEntry) it.next());
        }
    }

    private final void updateBottomActionShadow(BottomShadowEntry entry) {
        entry.getShadowView().setVisibility(entry.getTarget().getVisibility());
        if (entry.getTarget().getVisibility() != 0 || entry.getTarget().getWidth() <= 0 || entry.getTarget().getHeight() <= 0) {
            return;
        }
        this.bottomActionButtonRect.set(0, 0, entry.getTarget().getWidth(), entry.getTarget().getHeight());
        ConstraintLayout constraintLayout = this.footerContainer;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
            constraintLayout = null;
        }
        constraintLayout.offsetDescendantRectToMyCoords(entry.getTarget(), this.bottomActionButtonRect);
        entry.getShadowView().setContentSize(entry.getTarget().getWidth(), entry.getTarget().getHeight());
        int width = entry.getTarget().getWidth() + (entry.getRadius() * 2);
        int height = entry.getTarget().getHeight() + entry.getPaddingTop() + entry.getPaddingBottom();
        int radius = this.bottomActionButtonRect.left - entry.getRadius();
        int paddingTop = this.bottomActionButtonRect.top - entry.getPaddingTop();
        entry.getShadowView().layout(radius, paddingTop, width + radius, height + paddingTop);
        entry.getShadowView().invalidate();
    }

    private final void showAttachmentPicker() {
        ChatAttachmentDialog.Companion companion = ChatAttachmentDialog.INSTANCE;
        BrainstormViewModel brainstormViewModel = this.viewModel;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        ChatAttachmentDialog newInstance = companion.newInstance(brainstormViewModel.getCurrentChatMode(), false);
        newInstance.setOnAttachmentSelected(new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                Unit showAttachmentPicker$lambda$29$lambda$28;
                showAttachmentPicker$lambda$29$lambda$28 = DiscussingFragment.showAttachmentPicker$lambda$29$lambda$28(DiscussingFragment.this, (ChatAttachmentDialog.AttachmentType) obj);
                return showAttachmentPicker$lambda$29$lambda$28;
            }
        });
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
        newInstance.showOnce(parentFragmentManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAttachmentPicker$lambda$29$lambda$28(DiscussingFragment discussingFragment, ChatAttachmentDialog.AttachmentType attachmentType) {
        Intrinsics.checkNotNullParameter(attachmentType, DBData.FIELD_TYPE);
        int i = WhenMappings.$EnumSwitchMapping$0[attachmentType.ordinal()];
        if (i == 1) {
            discussingFragment.requestCameraThenLaunch();
        } else if (i == 2) {
            discussingFragment.launchMediaChooser();
        } else if (i == 3) {
            discussingFragment.filePickerLauncher.launch(new String[]{"*/*"});
        } else if (i != 4 && i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    private final void launchMediaChooser() {
        this.mediaChooseLauncher.launch(new Intent(requireContext(), (Class<?>) MediaChooseActivity.class));
    }

    private final void requestCameraThenLaunch() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        if (ContextCompat.checkSelfPermission(requireContext, "android.permission.CAMERA") != 0) {
            PermissionRationaleDialog.INSTANCE.showForPermission(requireContext, C0591R.drawable.trae_ic_permission_camera, R.string.trae_permission_camera_title, R.string.trae_permission_camera_message, R.string.trae_permission_allow, R.string.trae_permission_deny, new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit requestCameraThenLaunch$lambda$30;
                    requestCameraThenLaunch$lambda$30 = DiscussingFragment.requestCameraThenLaunch$lambda$30(DiscussingFragment.this);
                    return requestCameraThenLaunch$lambda$30;
                }
            }, (r19 & 128) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.PermissionRationaleDialog$Companion$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            } : null);
        } else {
            openCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestCameraThenLaunch$lambda$30(DiscussingFragment discussingFragment) {
        discussingFragment.cameraPermissionLauncher.launch("android.permission.CAMERA");
        return Unit.INSTANCE;
    }

    private final void openCamera() {
        Uri createImageUri = createImageUri();
        if (createImageUri == null) {
            Toast.makeText(requireContext(), R.string.trae_media_choose_camera_create_failed, 0).show();
        } else {
            this.pendingCameraUri = createImageUri;
            this.takePictureLauncher.launch(createImageUri);
        }
    }

    private final Uri createImageUri() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        File file = new File(requireContext.getCacheDir(), "camera");
        file.mkdirs();
        try {
            return FileProvider.getUriForFile(requireContext, requireContext.getPackageName() + ".uri.key", new File(file, "trae_brainstorm_camera_" + System.currentTimeMillis() + ".jpg"));
        } catch (Exception e) {
            FLogger.INSTANCE.w(TAG, "createImageUri failed", e);
            return null;
        }
    }

    static /* synthetic */ void dispatchPickedUri$default(DiscussingFragment discussingFragment, Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        discussingFragment.dispatchPickedUri(uri, str);
    }

    private final void dispatchPickedUri(Uri uri, String groupId) {
        String string;
        ContentResolver contentResolver = requireContext().getApplicationContext().getContentResolver();
        String type = contentResolver.getType(uri);
        if (type == null && (type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()))) == null) {
            type = "application/octet-stream";
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = "attachment";
        }
        String str = lastPathSegment;
        long j = -1;
        try {
            Cursor query = contentResolver.query(uri, null, null, null, null);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    if (cursor2.moveToFirst()) {
                        int columnIndex = cursor2.getColumnIndex("_display_name");
                        if (columnIndex >= 0 && (string = cursor2.getString(columnIndex)) != null) {
                            str = string;
                        }
                        int columnIndex2 = cursor2.getColumnIndex("_size");
                        if (columnIndex2 >= 0 && !cursor2.isNull(columnIndex2)) {
                            j = cursor2.getLong(columnIndex2);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, (Throwable) null);
                } finally {
                }
            }
        } catch (Exception e) {
            FLogger.INSTANCE.w(TAG, "dispatchPickedUri: resolve meta failed for " + uri, e);
        }
        String str2 = str;
        long j2 = j;
        boolean startsWith$default = StringsKt.startsWith$default(type, "image/", false, 2, (Object) null);
        BrainstormViewModel brainstormViewModel = this.viewModel;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        brainstormViewModel.pickAndUpload(uri, type, str2, j2, startsWith$default, groupId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x014b, code lost:
    
        if (r2 != null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0179, code lost:
    
        if (r2 != null) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void previewAttachment(BrainstormAttachment attachment) {
        String str;
        String str2;
        BrainstormViewModel brainstormViewModel;
        String str3;
        BrainstormViewModel brainstormViewModel2;
        BrainstormViewModel brainstormViewModel3;
        BrainstormViewModel brainstormViewModel4 = null;
        if (attachment.isImage() || StringsKt.startsWith$default(attachment.getMimeType(), "image/", false, 2, (Object) null)) {
            ArrayList currentImageAttachments = this.historySubtitleAdapter.currentImageAttachments();
            if (currentImageAttachments.isEmpty()) {
                BrainstormViewModel brainstormViewModel5 = this.viewModel;
                if (brainstormViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    brainstormViewModel5 = null;
                }
                List<BrainstormAttachment> attachments = ((BrainstormUiState) brainstormViewModel5.getUiState().getValue()).getAttachments();
                ArrayList arrayList = new ArrayList();
                for (Object obj : attachments) {
                    BrainstormAttachment brainstormAttachment = (BrainstormAttachment) obj;
                    if ((brainstormAttachment.isImage() || StringsKt.startsWith$default(brainstormAttachment.getMimeType(), "image/", false, 2, (Object) null)) && (StringsKt.isBlank(brainstormAttachment.getLocalUri()) ^ true)) {
                        arrayList.add(obj);
                    }
                }
                currentImageAttachments = arrayList;
            }
            List<BrainstormAttachment> list = currentImageAttachments;
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String localUri = ((BrainstormAttachment) it.next()).getLocalUri();
                if (!(!StringsKt.isBlank(localUri))) {
                    localUri = null;
                }
                if (localUri != null) {
                    arrayList2.add(localUri);
                }
            }
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((BrainstormAttachment) it2.next()).getDisplayName());
            }
            ArrayList arrayList5 = arrayList4;
            int coerceAtLeast = RangesKt.coerceAtLeast(arrayList3.indexOf(attachment.getLocalUri()), 0);
            ArrayList arrayList6 = arrayList3;
            if (!arrayList6.isEmpty()) {
                MultiImagePreviewActivity.Companion companion = MultiImagePreviewActivity.INSTANCE;
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                companion.startWithLocalUris(requireContext, new ArrayList<>(arrayList6), coerceAtLeast, new ArrayList<>(arrayList5));
                return;
            }
            return;
        }
        String uploadedRef = attachment.getUploadedRef();
        if (attachment.getState() == AttachmentState.Uploaded) {
            String str4 = uploadedRef;
            if (str4 == null || StringsKt.isBlank(str4)) {
                return;
            }
            String str5 = (String) VoiceSubTaskCoordinator.INSTANCE.getProxyConversationId().getValue();
            if (str5 != null) {
                if (!(!StringsKt.isBlank(str5))) {
                    str5 = null;
                }
            }
            BrainstormViewModel brainstormViewModel6 = this.viewModel;
            if (brainstormViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                brainstormViewModel6 = null;
            }
            str5 = brainstormViewModel6.get_cliConversationId();
            if (str5 == null) {
                str = "";
                str2 = (String) VoiceSubTaskCoordinator.INSTANCE.getParentChatSessionId().getValue();
                if (str2 != null) {
                    if (!(!StringsKt.isBlank(str2))) {
                        str2 = null;
                    }
                }
                brainstormViewModel = this.viewModel;
                if (brainstormViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    brainstormViewModel = null;
                }
                str2 = brainstormViewModel.get_cliConversationId();
                if (str2 == null) {
                    str3 = "";
                    InputPreviewActivity.Companion companion2 = InputPreviewActivity.INSTANCE;
                    Context requireContext2 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                    String str6 = "trae-res://remote_resource/" + uploadedRef;
                    String displayName = attachment.getDisplayName();
                    brainstormViewModel2 = this.viewModel;
                    if (brainstormViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        brainstormViewModel2 = null;
                    }
                    String value = brainstormViewModel2.get_voiceCliType().getValue();
                    brainstormViewModel3 = this.viewModel;
                    if (brainstormViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        brainstormViewModel4 = brainstormViewModel3;
                    }
                    companion2.start(requireContext2, str6, (r21 & 4) != 0 ? "" : displayName, (r21 & 8) != 0 ? "" : str, (r21 & 16) != 0 ? "" : str3, (r21 & 32) != 0 ? "" : value, (r21 & 64) != 0 ? "" : brainstormViewModel4.get_voiceMode().getValue(), (r21 & 128) != 0 ? "" : null);
                }
                str3 = str2;
                InputPreviewActivity.Companion companion22 = InputPreviewActivity.INSTANCE;
                Context requireContext22 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext22, "requireContext(...)");
                String str62 = "trae-res://remote_resource/" + uploadedRef;
                String displayName2 = attachment.getDisplayName();
                brainstormViewModel2 = this.viewModel;
                if (brainstormViewModel2 == null) {
                }
                String value2 = brainstormViewModel2.get_voiceCliType().getValue();
                brainstormViewModel3 = this.viewModel;
                if (brainstormViewModel3 == null) {
                }
                companion22.start(requireContext22, str62, (r21 & 4) != 0 ? "" : displayName2, (r21 & 8) != 0 ? "" : str, (r21 & 16) != 0 ? "" : str3, (r21 & 32) != 0 ? "" : value2, (r21 & 64) != 0 ? "" : brainstormViewModel4.get_voiceMode().getValue(), (r21 & 128) != 0 ? "" : null);
            }
            str = str5;
            str2 = (String) VoiceSubTaskCoordinator.INSTANCE.getParentChatSessionId().getValue();
            if (str2 != null) {
            }
            brainstormViewModel = this.viewModel;
            if (brainstormViewModel == null) {
            }
            str2 = brainstormViewModel.get_cliConversationId();
            if (str2 == null) {
            }
            str3 = str2;
            InputPreviewActivity.Companion companion222 = InputPreviewActivity.INSTANCE;
            Context requireContext222 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext222, "requireContext(...)");
            String str622 = "trae-res://remote_resource/" + uploadedRef;
            String displayName22 = attachment.getDisplayName();
            brainstormViewModel2 = this.viewModel;
            if (brainstormViewModel2 == null) {
            }
            String value22 = brainstormViewModel2.get_voiceCliType().getValue();
            brainstormViewModel3 = this.viewModel;
            if (brainstormViewModel3 == null) {
            }
            companion222.start(requireContext222, str622, (r21 & 4) != 0 ? "" : displayName22, (r21 & 8) != 0 ? "" : str, (r21 & 16) != 0 ? "" : str3, (r21 & 32) != 0 ? "" : value22, (r21 & 64) != 0 ? "" : brainstormViewModel4.get_voiceMode().getValue(), (r21 & 128) != 0 ? "" : null);
        }
    }

    private final void showAudioSwitchToast() {
        String string;
        BrainstormViewModel brainstormViewModel = this.viewModel;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[((BrainstormUiState) brainstormViewModel.getUiState().getValue()).getCurrentAudioDevice().ordinal()];
        if (i == 1) {
            string = getString(C0637R.string.trae_brainstorm_device_speaker);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            string = getString(C0637R.string.trae_brainstorm_device_earpiece);
        }
        Intrinsics.checkNotNull(string);
        String string2 = getString(C0637R.string.trae_brainstorm_switched_to_device, new Object[]{string});
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        View view = getView();
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null) {
            return;
        }
        AudioSwitchToast.INSTANCE.show(viewGroup, string2);
    }

    private final void playEnterSound() {
        Object obj;
        MediaPlayer mediaPlayer = this.enterMediaPlayer;
        if (mediaPlayer != null) {
            try {
                Result.Companion companion = Result.Companion;
                mediaPlayer.release();
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Result.box-impl(obj);
        }
        MediaPlayer create = MediaPlayer.create(requireContext(), C0637R.raw.trae_brainstorm_enter);
        if (create != null) {
            create.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda25
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer2) {
                    DiscussingFragment.playEnterSound$lambda$44$lambda$43(DiscussingFragment.this, mediaPlayer2);
                }
            });
            create.start();
        } else {
            create = null;
        }
        this.enterMediaPlayer = create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playEnterSound$lambda$44$lambda$43(DiscussingFragment discussingFragment, MediaPlayer mediaPlayer) {
        mediaPlayer.release();
        if (discussingFragment.enterMediaPlayer == mediaPlayer) {
            discussingFragment.enterMediaPlayer = null;
        }
    }

    private final void seedSubtitleHistoryFromState() {
        BrainstormViewModel brainstormViewModel = this.viewModel;
        RecyclerView recyclerView = null;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        BrainstormUiState brainstormUiState = (BrainstormUiState) brainstormViewModel.getUiState().getValue();
        List<BrainstormMessage> subtitleHistory = brainstormUiState.getSubtitleHistory();
        List<BrainstormAttachment> attachments = brainstormUiState.getAttachments();
        if ((!subtitleHistory.isEmpty()) || (!attachments.isEmpty())) {
            this.historySubtitleAdapter.seedHistoryWithAttachments(subtitleHistory, attachments);
            RecyclerView recyclerView2 = this.rvHistorySubtitle;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvHistorySubtitle");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    DiscussingFragment.seedSubtitleHistoryFromState$lambda$45(DiscussingFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void seedSubtitleHistoryFromState$lambda$45(DiscussingFragment discussingFragment) {
        int totalItemCount = discussingFragment.historySubtitleAdapter.getTotalItemCount();
        if (totalItemCount > 0) {
            RecyclerView recyclerView = discussingFragment.rvHistorySubtitle;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvHistorySubtitle");
                recyclerView = null;
            }
            recyclerView.scrollToPosition(totalItemCount - 1);
        }
    }

    private final void setupSubtitleRecyclerView() {
        RecyclerView recyclerView = this.rvHistorySubtitle;
        ImageView imageView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvHistorySubtitle");
            recyclerView = null;
        }
        recyclerView.setHasFixedSize(true);
        RecyclerView recyclerView2 = this.rvHistorySubtitle;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvHistorySubtitle");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView3 = this.rvHistorySubtitle;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvHistorySubtitle");
            recyclerView3 = null;
        }
        recyclerView3.setAdapter(this.historySubtitleAdapter);
        this.historySubtitleAdapter.setAttachmentCallback(new HistorySubtitleAdapter.AttachmentCallback() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$setupSubtitleRecyclerView$1
            @Override // com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter.AttachmentCallback
            public void onClose(String attachmentId, AttachmentState state) {
                BrainstormViewModel brainstormViewModel;
                BrainstormViewModel brainstormViewModel2;
                Intrinsics.checkNotNullParameter(attachmentId, "attachmentId");
                Intrinsics.checkNotNullParameter(state, "state");
                BrainstormViewModel brainstormViewModel3 = null;
                if (state == AttachmentState.Uploading) {
                    brainstormViewModel2 = DiscussingFragment.this.viewModel;
                    if (brainstormViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        brainstormViewModel3 = brainstormViewModel2;
                    }
                    brainstormViewModel3.cancelAttachment(attachmentId);
                    return;
                }
                brainstormViewModel = DiscussingFragment.this.viewModel;
                if (brainstormViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    brainstormViewModel3 = brainstormViewModel;
                }
                brainstormViewModel3.removeAttachment(attachmentId);
            }

            @Override // com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter.AttachmentCallback
            public void onRetry(String attachmentId) {
                BrainstormViewModel brainstormViewModel;
                Intrinsics.checkNotNullParameter(attachmentId, "attachmentId");
                brainstormViewModel = DiscussingFragment.this.viewModel;
                if (brainstormViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    brainstormViewModel = null;
                }
                brainstormViewModel.retryAttachment(attachmentId);
            }

            @Override // com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter.AttachmentCallback
            public void onPreview(BrainstormAttachment attachment) {
                Intrinsics.checkNotNullParameter(attachment, "attachment");
                DiscussingFragment.this.previewAttachment(attachment);
            }
        });
        RecyclerView recyclerView4 = this.rvHistorySubtitle;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvHistorySubtitle");
            recyclerView4 = null;
        }
        recyclerView4.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$setupSubtitleRecyclerView$2
            public void onScrollStateChanged(RecyclerView recyclerView5, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                if (newState == 1) {
                    DiscussingFragment.this.isUserScrolling = true;
                    DiscussingFragment.this.isDragging = true;
                } else {
                    DiscussingFragment.this.isDragging = false;
                }
            }

            public void onScrolled(RecyclerView recyclerView5, int dx, int dy) {
                boolean z;
                Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                boolean z2 = !recyclerView5.canScrollVertically(1);
                DiscussingFragment.this.updateSubtitleTopGradient();
                if (z2) {
                    DiscussingFragment.this.isUserScrolling = false;
                    DiscussingFragment.this.hideScrollToBottomButton();
                } else {
                    z = DiscussingFragment.this.isUserScrolling;
                    if (z) {
                        DiscussingFragment.this.showScrollToBottomButton();
                    }
                }
            }
        });
        ImageView imageView2 = this.btnScrollToBottom;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnScrollToBottom");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiscussingFragment.setupSubtitleRecyclerView$lambda$46(DiscussingFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSubtitleRecyclerView$lambda$46(DiscussingFragment discussingFragment, View view) {
        discussingFragment.isUserScrolling = false;
        discussingFragment.hideScrollToBottomButton();
        int itemCount = discussingFragment.historySubtitleAdapter.getItemCount();
        if (itemCount > 0) {
            RecyclerView recyclerView = discussingFragment.rvHistorySubtitle;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvHistorySubtitle");
                recyclerView = null;
            }
            recyclerView.smoothScrollToPosition(itemCount - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showScrollToBottomButton() {
        ImageView imageView = this.btnScrollToBottom;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnScrollToBottom");
            imageView = null;
        }
        if (imageView.getVisibility() == 0) {
            return;
        }
        ImageView imageView3 = this.btnScrollToBottom;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnScrollToBottom");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        ImageView imageView4 = this.btnScrollToBottom;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnScrollToBottom");
            imageView4 = null;
        }
        imageView4.setAlpha(0.0f);
        ImageView imageView5 = this.btnScrollToBottom;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnScrollToBottom");
        } else {
            imageView2 = imageView5;
        }
        imageView2.animate().alpha(1.0f).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideScrollToBottomButton() {
        ImageView imageView = this.btnScrollToBottom;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnScrollToBottom");
            imageView = null;
        }
        if (imageView.getVisibility() != 0) {
            return;
        }
        ImageView imageView3 = this.btnScrollToBottom;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnScrollToBottom");
        } else {
            imageView2 = imageView3;
        }
        imageView2.animate().alpha(0.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                DiscussingFragment.hideScrollToBottomButton$lambda$47(DiscussingFragment.this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideScrollToBottomButton$lambda$47(DiscussingFragment discussingFragment) {
        ImageView imageView = discussingFragment.btnScrollToBottom;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnScrollToBottom");
            imageView = null;
        }
        imageView.setVisibility(8);
    }

    private final void observeState() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new DiscussingFragment$observeState$1(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), (CoroutineContext) null, (CoroutineStart) null, new DiscussingFragment$observeState$2(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), (CoroutineContext) null, (CoroutineStart) null, new DiscussingFragment$observeState$3(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateWaveformAnimating(boolean isRtcJoined) {
        VoiceStatusWaveIconView voiceStatusWaveIconView = null;
        if (isRtcJoined && !this.curIsMicMuted) {
            VoiceStatusWaveIconView voiceStatusWaveIconView2 = this.mainWaveform;
            if (voiceStatusWaveIconView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainWaveform");
            } else {
                voiceStatusWaveIconView = voiceStatusWaveIconView2;
            }
            voiceStatusWaveIconView.startAnimating();
            return;
        }
        VoiceStatusWaveIconView voiceStatusWaveIconView3 = this.mainWaveform;
        if (voiceStatusWaveIconView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainWaveform");
        } else {
            voiceStatusWaveIconView = voiceStatusWaveIconView3;
        }
        voiceStatusWaveIconView.stopAnimating();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSubtitleListIfNeeded(BrainstormUiState state) {
        SubtitleRenderSnapshot subtitleRenderSnapshot = new SubtitleRenderSnapshot(state.getSubtitleHistory(), state.getAttachments(), state.getSubTask(), state.getFinishedSubTasks(), state.getBotTranscript(), state.getCurrentTranscript(), state.getAiParticipantState(), state.isSubtitleMode());
        if (Intrinsics.areEqual(subtitleRenderSnapshot, this.lastSubtitleRenderSnapshot)) {
            return;
        }
        this.lastSubtitleRenderSnapshot = subtitleRenderSnapshot;
        updateSubtitleList(state);
    }

    private final void updateSubtitleList(BrainstormUiState state) {
        RecyclerView recyclerView;
        BrainstormMessage brainstormMessage;
        BrainstormMessage brainstormMessage2;
        SubTaskUiState subTaskUiState;
        String str;
        String str2;
        List<BrainstormAttachment> attachments = state.getAttachments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(attachments, 10));
        Iterator<T> it = attachments.iterator();
        while (it.hasNext()) {
            arrayList.add(((BrainstormAttachment) it.next()).getAttachmentId());
        }
        HashSet hashSet = CollectionsKt.toHashSet(arrayList);
        Iterator<T> it2 = state.getAttachments().iterator();
        while (it2.hasNext()) {
            this.historySubtitleAdapter.appendOrUpdateAttachment((BrainstormAttachment) it2.next());
        }
        this.historySubtitleAdapter.pruneAttachmentsExcept(hashSet);
        List<BrainstormMessage> subtitleHistory = state.getSubtitleHistory();
        ListIterator<BrainstormMessage> listIterator = subtitleHistory.listIterator(subtitleHistory.size());
        while (true) {
            recyclerView = null;
            if (listIterator.hasPrevious()) {
                brainstormMessage = listIterator.previous();
                if (brainstormMessage.getRole() == MessageRole.Assistant) {
                    break;
                }
            } else {
                brainstormMessage = null;
                break;
            }
        }
        BrainstormMessage brainstormMessage3 = brainstormMessage;
        this.historySubtitleAdapter.setLiveBot(state.getBotTranscript(), brainstormMessage3 != null ? brainstormMessage3.getId() : null, brainstormMessage3 != null ? brainstormMessage3.getAttachedSubTaskId() : null);
        List<BrainstormMessage> subtitleHistory2 = state.getSubtitleHistory();
        ListIterator<BrainstormMessage> listIterator2 = subtitleHistory2.listIterator(subtitleHistory2.size());
        while (true) {
            if (listIterator2.hasPrevious()) {
                brainstormMessage2 = listIterator2.previous();
                if (brainstormMessage2.getRole() == MessageRole.User) {
                    break;
                }
            } else {
                brainstormMessage2 = null;
                break;
            }
        }
        BrainstormMessage brainstormMessage4 = brainstormMessage2;
        boolean liveUser = this.historySubtitleAdapter.setLiveUser(state.getCurrentTranscript(), brainstormMessage4 != null ? brainstormMessage4.getId() : null);
        for (BrainstormMessage brainstormMessage5 : state.getSubtitleHistory()) {
            String attachedSubTaskId = brainstormMessage5.getAttachedSubTaskId();
            if (attachedSubTaskId != null) {
                SubTaskRenderState subTaskTerminalState = brainstormMessage5.getSubTaskTerminalState();
                SubTaskUiState subTask = state.getSubTask();
                if (subTask == null || !Intrinsics.areEqual(subTask.getSourceTaskId(), attachedSubTaskId)) {
                    subTask = null;
                }
                SubTaskUiState subTaskUiState2 = state.getFinishedSubTasks().get(attachedSubTaskId);
                if (subTaskTerminalState != null) {
                    subTaskUiState = new SubTaskUiState(attachedSubTaskId, "", null, null, null, subTaskTerminalState, null, brainstormMessage5.getSubTaskFailureReason(), 0L, false, null, null, 3932, null);
                    str = "terminal-stamped";
                } else if (subTask != null) {
                    str = "active";
                    subTaskUiState = subTask;
                } else if (subTaskUiState2 == null) {
                    subTaskUiState = new SubTaskUiState(attachedSubTaskId, "", null, null, null, SubTaskRenderState.Creating, null, null, 0L, false, null, null, 4060, null);
                    str = "placeholder";
                } else {
                    str2 = "finished-cache";
                    subTaskUiState = subTaskUiState2;
                    logSubTaskBadgeRoute(brainstormMessage5.getId(), attachedSubTaskId, str2, subTaskUiState, state, subTaskTerminalState);
                    this.historySubtitleAdapter.updateSubTaskBadgeOnMessage(brainstormMessage5.getId(), subTaskUiState);
                }
                str2 = str;
                logSubTaskBadgeRoute(brainstormMessage5.getId(), attachedSubTaskId, str2, subTaskUiState, state, subTaskTerminalState);
                this.historySubtitleAdapter.updateSubTaskBadgeOnMessage(brainstormMessage5.getId(), subTaskUiState);
            }
        }
        boolean thinkingVisible = this.historySubtitleAdapter.setThinkingVisible(state.getAiParticipantState() == ParticipantState.Thinking && StringsKt.isBlank(state.getBotTranscript()));
        this.historySubtitleAdapter.setFooter(null);
        int totalItemCount = this.historySubtitleAdapter.getTotalItemCount();
        updateSubtitleEmptyHint(totalItemCount == 0);
        if ((liveUser || thinkingVisible) && totalItemCount > 0 && !this.isDragging) {
            RecyclerView recyclerView2 = this.rvHistorySubtitle;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvHistorySubtitle");
                recyclerView2 = null;
            }
            recyclerView2.smoothScrollToPosition(totalItemCount - 1);
        }
        if (!state.isSubtitleMode() || totalItemCount <= 0 || this.isUserScrolling) {
            return;
        }
        RecyclerView recyclerView3 = this.rvHistorySubtitle;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvHistorySubtitle");
        } else {
            recyclerView = recyclerView3;
        }
        recyclerView.scrollToPosition(totalItemCount - 1);
    }

    private final void updateSubtitleEmptyHint(boolean show) {
        ShimmerTextView shimmerTextView = this.subtitleEmptyHint;
        if (shimmerTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitleEmptyHint");
            shimmerTextView = null;
        }
        shimmerTextView.setVisibility(show ? 0 : 8);
    }

    private final void logSubTaskBadgeRoute(String messageId, String taskId, String route, SubTaskUiState badge, BrainstormUiState state, SubTaskRenderState terminalState) {
        String str = route + ':' + badge.getState() + ':' + badge.getLongRunning() + ':' + badge.getFailureReason();
        if (Intrinsics.areEqual(this.lastSubTaskRouteLogs.get(messageId), str)) {
            return;
        }
        this.lastSubTaskRouteLogs.put(messageId, str);
        StringBuilder append = new StringBuilder("subTaskBadgeRoute: messageId=").append(messageId).append(", taskId=").append(taskId).append(", route=").append(route).append(", badge=").append(badge.getState()).append(", longRunning=").append(badge.getLongRunning()).append(", terminal=").append(terminalState).append(", active=");
        SubTaskUiState subTask = state.getSubTask();
        StringBuilder append2 = append.append(subTask != null ? subTask.getSourceTaskId() : null).append(':');
        SubTaskUiState subTask2 = state.getSubTask();
        String sb = append2.append(subTask2 != null ? subTask2.getState() : null).append(", finishedHit=").append(state.getFinishedSubTasks().containsKey(taskId)).append(", historySize=").append(state.getSubtitleHistory().size()).toString();
        if (Intrinsics.areEqual(route, "placeholder")) {
            FLogger.INSTANCE.w(TAG, sb);
        } else {
            FLogger.INSTANCE.d(TAG, sb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTimer(BrainstormUiState state) {
        long sessionElapsedMs = state.getSessionElapsedMs();
        int i = (int) (sessionElapsedMs / 1000);
        if (this.curTimerSeconds == i) {
            return;
        }
        this.curTimerSeconds = i;
        BrainstormTopBar brainstormTopBar = this.topBar;
        if (brainstormTopBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBar");
            brainstormTopBar = null;
        }
        brainstormTopBar.updateTimer(sessionElapsedMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTimeoutState(TimeoutState timeoutState, int remainingSeconds) {
        BrainstormTopBar brainstormTopBar = this.topBar;
        if (brainstormTopBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBar");
            brainstormTopBar = null;
        }
        brainstormTopBar.updateTimeoutState(timeoutState, remainingSeconds);
        this.curTimeoutState = timeoutState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMicUi(boolean isMicMuted) {
        if (this.curIsMicMuted == isMicMuted) {
            return;
        }
        this.curIsMicMuted = isMicMuted;
        VoiceStatusWaveIconView voiceStatusWaveIconView = null;
        if (isMicMuted) {
            Button button = this.btnMic;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnMic");
                button = null;
            }
            button.setForeground(ContextCompat.getDrawable(requireContext(), C0637R.drawable.trae_ic_brainstorm_mic_off));
            Button button2 = this.btnMic;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnMic");
                button2 = null;
            }
            button2.setBackgroundResource(C0637R.drawable.trae_bg_brainstorm_circle_button_white);
            VoiceStatusWaveIconView voiceStatusWaveIconView2 = this.mainWaveform;
            if (voiceStatusWaveIconView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainWaveform");
            } else {
                voiceStatusWaveIconView = voiceStatusWaveIconView2;
            }
            voiceStatusWaveIconView.stopAnimating();
            return;
        }
        Button button3 = this.btnMic;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMic");
            button3 = null;
        }
        button3.setForeground(ContextCompat.getDrawable(requireContext(), C0637R.drawable.trae_ic_brainstorm_mic));
        Button button4 = this.btnMic;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMic");
            button4 = null;
        }
        button4.setBackgroundResource(C0637R.drawable.trae_bg_brainstorm_circle_button_white);
        VoiceStatusWaveIconView voiceStatusWaveIconView3 = this.mainWaveform;
        if (voiceStatusWaveIconView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainWaveform");
        } else {
            voiceStatusWaveIconView = voiceStatusWaveIconView3;
        }
        voiceStatusWaveIconView.startAnimating();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateParticipantStates(BrainstormUiState state) {
        String resolveSphereState = resolveSphereState(state);
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder append = new StringBuilder("updateParticipantStates: aiState=").append(state.getAiParticipantState()).append(", userState=").append(state.getUserParticipantState()).append(", subTask=");
        SubTaskUiState subTask = state.getSubTask();
        SphereController sphereController = null;
        fLogger.d(TAG, append.append(subTask != null ? subTask.getState() : null).append(", jsState=").append(resolveSphereState).toString());
        if (Intrinsics.areEqual(this.curSphereState, resolveSphereState)) {
            return;
        }
        this.curSphereState = resolveSphereState;
        SphereController sphereController2 = this.sphereController;
        if (sphereController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sphereController");
        } else {
            sphereController = sphereController2;
        }
        sphereController.setState(resolveSphereState);
    }

    private final String resolveSphereState(BrainstormUiState state) {
        return state.getAiParticipantState() == ParticipantState.Speaking ? "speaking" : isTaskProcessingForSphere(state) ? "processing" : state.getAiParticipantState() == ParticipantState.Thinking ? "thinking" : state.getUserParticipantState() == ParticipantState.Speaking ? "listening" : "idle";
    }

    private final boolean isTaskProcessingForSphere(BrainstormUiState state) {
        SubTaskUiState subTask = state.getSubTask();
        return CollectionsKt.contains(IN_FLIGHT_SUB_TASK_STATES, subTask != null ? subTask.getState() : null) || hasPendingAnchoredSubTask(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAiDisplay(BrainstormUiState state) {
        boolean hasMeaningfulUserInput = hasMeaningfulUserInput(state);
        boolean z = hasMeaningfulUserInput || state.getAiParticipantState() == ParticipantState.Thinking || (StringsKt.isBlank(state.getBotTranscript()) ^ true);
        if (!this.hasEverBeenActive && z) {
            this.hasEverBeenActive = true;
            TextView textView = this.tvAiStatus;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAiStatus");
                textView = null;
            }
            fadeOutView(textView);
        }
        BrainstormViewModel brainstormViewModel = this.viewModel;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        brainstormViewModel.drainBotSubtitleChars();
        if (this.hasEverBeenActive) {
            TextView textView2 = this.tvAiStatus;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAiStatus");
                textView2 = null;
            }
            textView2.setVisibility(8);
        }
        FrameLayout frameLayout = this.aiSubtitleContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiSubtitleContainer");
            frameLayout = null;
        }
        frameLayout.setVisibility(8);
        BottomStatus resolveBottomStatus = resolveBottomStatus(state);
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder append = new StringBuilder("updateBottomStatus: aiState=").append(state.getAiParticipantState()).append(" userState=").append(state.getUserParticipantState()).append(" subTask=");
        SubTaskUiState subTask = state.getSubTask();
        fLogger.d(TAG, append.append(subTask != null ? subTask.getState() : null).append(" botLen=").append(state.getBotTranscript().length()).append(" target=").append(resolveBottomStatus).append(" hasUserInput=").append(hasMeaningfulUserInput).append(" hasEverBeenActive=").append(this.hasEverBeenActive).toString());
        updateBottomStatusText$default(this, resolveBottomStatus, false, 2, null);
    }

    private final BottomStatus resolveBottomStatus(BrainstormUiState state) {
        updateTaskDoneHold(state);
        SubTaskUiState subTask = state.getSubTask();
        if (CollectionsKt.contains(IN_FLIGHT_SUB_TASK_STATES, subTask != null ? subTask.getState() : null)) {
            return resolveTaskRunningStatus();
        }
        if (hasPendingAnchoredSubTask(state)) {
            return resolveTaskRunningStatus();
        }
        resetTaskRunningClock();
        if (System.currentTimeMillis() < this.bottomTaskDoneUntilMs) {
            return BottomStatus.TaskDone;
        }
        boolean z = this.hasEverBeenActive || hasMeaningfulUserInput(state);
        return (isAiReplying(state) && z) ? BottomStatus.Answering : (state.getAiParticipantState() == ParticipantState.Thinking && z) ? BottomStatus.Thinking : StringsKt.isBlank(state.getCurrentTranscript()) ^ true ? BottomStatus.Listening : BottomStatus.Prompt;
    }

    private final boolean isAiReplying(BrainstormUiState state) {
        return state.getAiParticipantState() == ParticipantState.Speaking || (StringsKt.isBlank(state.getBotTranscript()) ^ true);
    }

    private final boolean hasMeaningfulUserInput(BrainstormUiState state) {
        boolean z;
        if ((!StringsKt.isBlank(state.getCurrentTranscript())) || (!state.getAttachments().isEmpty())) {
            return true;
        }
        List<BrainstormMessage> subtitleHistory = state.getSubtitleHistory();
        if (!(subtitleHistory instanceof Collection) || !subtitleHistory.isEmpty()) {
            for (BrainstormMessage brainstormMessage : subtitleHistory) {
                if (brainstormMessage.getRole() == MessageRole.User && (StringsKt.isBlank(brainstormMessage.getContent()) ^ true)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return z;
    }

    private final BottomStatus resolveTaskRunningStatus() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.taskRunningSinceMs == 0) {
            this.taskRunningSinceMs = currentTimeMillis;
            scheduleTaskRunningLongRefresh();
        }
        if (currentTimeMillis - this.taskRunningSinceMs >= this.taskRunningLongDelayMs) {
            return BottomStatus.TaskRunningLong;
        }
        return BottomStatus.TaskRunning;
    }

    private final void scheduleTaskRunningLongRefresh() {
        Runnable runnable = this.taskRunningLongRunnable;
        if (runnable != null) {
            this.displaySwitchHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                DiscussingFragment.scheduleTaskRunningLongRefresh$lambda$55(DiscussingFragment.this);
            }
        };
        this.taskRunningLongRunnable = runnable2;
        this.displaySwitchHandler.postDelayed(runnable2, this.taskRunningLongDelayMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleTaskRunningLongRefresh$lambda$55(DiscussingFragment discussingFragment) {
        BrainstormViewModel brainstormViewModel = null;
        discussingFragment.taskRunningLongRunnable = null;
        BrainstormViewModel brainstormViewModel2 = discussingFragment.viewModel;
        if (brainstormViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            brainstormViewModel = brainstormViewModel2;
        }
        discussingFragment.updateBottomStatusText(discussingFragment.resolveBottomStatus((BrainstormUiState) brainstormViewModel.getUiState().getValue()), true);
    }

    private final void resetTaskRunningClock() {
        if (this.taskRunningSinceMs == 0 && this.taskRunningLongRunnable == null) {
            return;
        }
        this.taskRunningSinceMs = 0L;
        Runnable runnable = this.taskRunningLongRunnable;
        if (runnable != null) {
            this.displaySwitchHandler.removeCallbacks(runnable);
        }
        this.taskRunningLongRunnable = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0083, code lost:
    
        if (r6.contains(r1.getState()) != false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[LOOP:0: B:8:0x001a->B:18:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean hasPendingAnchoredSubTask(BrainstormUiState state) {
        boolean z;
        List<BrainstormMessage> subtitleHistory = state.getSubtitleHistory();
        if ((subtitleHistory instanceof Collection) && subtitleHistory.isEmpty()) {
            return false;
        }
        for (BrainstormMessage brainstormMessage : subtitleHistory) {
            String attachedSubTaskId = brainstormMessage.getAttachedSubTaskId();
            if (attachedSubTaskId != null && brainstormMessage.getSubTaskTerminalState() == null) {
                SubTaskUiState subTask = state.getSubTask();
                if (subTask == null || !Intrinsics.areEqual(subTask.getSourceTaskId(), attachedSubTaskId)) {
                    subTask = null;
                }
                if (!CollectionsKt.contains(IN_FLIGHT_SUB_TASK_STATES, subTask != null ? subTask.getState() : null)) {
                    Set<SubTaskRenderState> set = TERMINAL_BOTTOM_SUB_TASK_STATES;
                    if (!CollectionsKt.contains(set, subTask != null ? subTask.getState() : null)) {
                        SubTaskUiState subTaskUiState = state.getFinishedSubTasks().get(attachedSubTaskId);
                        if (subTaskUiState != null) {
                        }
                    }
                }
                z = true;
                if (!z) {
                    return true;
                }
            }
            z = false;
            if (!z) {
            }
        }
        return false;
    }

    private final void updateTaskDoneHold(BrainstormUiState state) {
        List createListBuilder = CollectionsKt.createListBuilder();
        SubTaskUiState subTask = state.getSubTask();
        Object obj = null;
        if (subTask != null) {
            if (!(subTask.getState() == SubTaskRenderState.Done)) {
                subTask = null;
            }
            if (subTask != null) {
                createListBuilder.add(subTask.getSourceTaskId());
            }
        }
        Collection<SubTaskUiState> values = state.getFinishedSubTasks().values();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : values) {
            if (((SubTaskUiState) obj2).getState() == SubTaskRenderState.Done) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            createListBuilder.add(((SubTaskUiState) it.next()).getSourceTaskId());
        }
        Iterator it2 = CollectionsKt.build(createListBuilder).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (!this.seenBottomTerminalTaskIds.contains((String) next)) {
                obj = next;
                break;
            }
        }
        final String str = (String) obj;
        if (str == null) {
            return;
        }
        this.seenBottomTerminalTaskIds.add(str);
        this.bottomTaskDoneTaskId = str;
        this.bottomTaskDoneUntilMs = System.currentTimeMillis() + this.taskDoneHoldMs;
        Runnable runnable = this.bottomTaskDoneClearRunnable;
        if (runnable != null) {
            this.displaySwitchHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                DiscussingFragment.updateTaskDoneHold$lambda$66(DiscussingFragment.this, str);
            }
        };
        this.bottomTaskDoneClearRunnable = runnable2;
        this.displaySwitchHandler.postDelayed(runnable2, this.taskDoneHoldMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateTaskDoneHold$lambda$66(DiscussingFragment discussingFragment, String str) {
        BrainstormViewModel brainstormViewModel = null;
        discussingFragment.bottomTaskDoneClearRunnable = null;
        if (!Intrinsics.areEqual(discussingFragment.bottomTaskDoneTaskId, str) || System.currentTimeMillis() < discussingFragment.bottomTaskDoneUntilMs) {
            return;
        }
        BrainstormViewModel brainstormViewModel2 = discussingFragment.viewModel;
        if (brainstormViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            brainstormViewModel = brainstormViewModel2;
        }
        discussingFragment.updateBottomStatusText(discussingFragment.resolveBottomStatus((BrainstormUiState) brainstormViewModel.getUiState().getValue()), true);
    }

    static /* synthetic */ void updateBottomStatusText$default(DiscussingFragment discussingFragment, BottomStatus bottomStatus, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        discussingFragment.updateBottomStatusText(bottomStatus, z);
    }

    private final void updateBottomStatusText(BottomStatus status, boolean force) {
        int i;
        ShimmerTextView shimmerTextView = null;
        if (!force && status == this.curBottomStatus) {
            ShimmerTextView shimmerTextView2 = this.bottomStatusText;
            if (shimmerTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomStatusText");
                shimmerTextView2 = null;
            }
            CharSequence text = shimmerTextView2.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            if (text.length() > 0) {
                return;
            }
        }
        this.curBottomStatus = status;
        ShimmerTextView shimmerTextView3 = this.bottomStatusText;
        if (shimmerTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomStatusText");
            shimmerTextView3 = null;
        }
        switch (WhenMappings.$EnumSwitchMapping$2[status.ordinal()]) {
            case 1:
                i = C0637R.string.trae_brainstorm_bottom_status_prompt;
                break;
            case 2:
                i = C0637R.string.trae_brainstorm_bottom_status_listening;
                break;
            case 3:
                i = C0637R.string.trae_brainstorm_bottom_status_thinking;
                break;
            case 4:
                i = C0637R.string.trae_brainstorm_bottom_status_answering;
                break;
            case 5:
                i = C0637R.string.trae_brainstorm_bottom_status_task_running;
                break;
            case 6:
                i = C0637R.string.trae_brainstorm_bottom_status_task_running_long;
                break;
            case 7:
                i = C0637R.string.trae_brainstorm_bottom_status_task_done;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        shimmerTextView3.setText(i);
        if (status == BottomStatus.TaskRunning || status == BottomStatus.TaskRunningLong || status == BottomStatus.TaskDone) {
            ShimmerTextView shimmerTextView4 = this.bottomStatusText;
            if (shimmerTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomStatusText");
            } else {
                shimmerTextView = shimmerTextView4;
            }
            shimmerTextView.startShimmer();
            return;
        }
        ShimmerTextView shimmerTextView5 = this.bottomStatusText;
        if (shimmerTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomStatusText");
        } else {
            shimmerTextView = shimmerTextView5;
        }
        shimmerTextView.stopShimmer();
    }

    private final void performAiDisplaySwitch(AiDisplayMode targetMode) {
        if (this.curAiDisplayMode == targetMode) {
            return;
        }
        this.curAiDisplayMode = targetMode;
        int i = WhenMappings.$EnumSwitchMapping$3[targetMode.ordinal()];
        FrameLayout frameLayout = null;
        if (i == 1) {
            TextView textView = this.tvAiStatus;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAiStatus");
                textView = null;
            }
            fadeOutView(textView);
            FrameLayout frameLayout2 = this.aiSubtitleContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aiSubtitleContainer");
            } else {
                frameLayout = frameLayout2;
            }
            fadeOutView(frameLayout);
            return;
        }
        if (i == 2) {
            TextView textView2 = this.tvAiStatus;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAiStatus");
                textView2 = null;
            }
            fadeInView(textView2);
            FrameLayout frameLayout3 = this.aiSubtitleContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aiSubtitleContainer");
            } else {
                frameLayout = frameLayout3;
            }
            fadeOutView(frameLayout);
            return;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        TextView textView3 = this.tvAiStatus;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAiStatus");
            textView3 = null;
        }
        fadeOutView(textView3);
        FrameLayout frameLayout4 = this.aiSubtitleContainer;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiSubtitleContainer");
        } else {
            frameLayout = frameLayout4;
        }
        fadeInView(frameLayout);
    }

    private final void fadeInView(View view) {
        if (view.getVisibility() == 0) {
            if (view.getAlpha() == 1.0f) {
                return;
            }
        }
        view.setAlpha(0.0f);
        view.setVisibility(0);
        view.animate().alpha(1.0f).setDuration(150L).start();
    }

    private final void fadeOutView(final View view) {
        if (view.getVisibility() == 8) {
            return;
        }
        view.animate().alpha(0.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                view.setVisibility(8);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateContentMode(boolean subtitleMode) {
        if (this.curIsSubtitleMode == subtitleMode) {
            return;
        }
        this.curIsSubtitleMode = subtitleMode;
        BrainstormTopBar brainstormTopBar = this.topBar;
        SphereController sphereController = null;
        if (brainstormTopBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBar");
            brainstormTopBar = null;
        }
        brainstormTopBar.setSubtitleToggleActive(subtitleMode);
        FrameLayout frameLayout = this.aiDisplaySwitcher;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiDisplaySwitcher");
            frameLayout = null;
        }
        frameLayout.animate().cancel();
        View view = this.subtitleModeContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitleModeContainer");
            view = null;
        }
        view.animate().cancel();
        Runnable runnable = this.subtitleModeHideRunnable;
        if (runnable != null) {
            this.displaySwitchHandler.removeCallbacks(runnable);
        }
        this.subtitleModeHideRunnable = null;
        if (subtitleMode) {
            TraeAITracker.trackAsrDiscuss$default(TraeAITracker.INSTANCE, AsrDiscussAction.SUBTITLE_MODE_ENABLE, null, 2, null);
            FrameLayout frameLayout2 = this.aiDisplaySwitcher;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aiDisplaySwitcher");
                frameLayout2 = null;
            }
            frameLayout2.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    DiscussingFragment.updateContentMode$lambda$69(DiscussingFragment.this);
                }
            }).start();
            SphereController sphereController2 = this.sphereController;
            if (sphereController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sphereController");
                sphereController2 = null;
            }
            sphereController2.stop();
            View view2 = this.subtitleModeContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitleModeContainer");
                view2 = null;
            }
            boolean z = view2.getVisibility() == 0;
            View view3 = this.subtitleModeContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitleModeContainer");
                view3 = null;
            }
            view3.setVisibility(0);
            if (!z) {
                View view4 = this.subtitleModeContainer;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleModeContainer");
                    view4 = null;
                }
                view4.setAlpha(0.0f);
            }
            View view5 = this.subtitleModeContainer;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitleModeContainer");
                view5 = null;
            }
            view5.animate().alpha(1.0f).setStartDelay(0L).setDuration(250L).withEndAction(null).start();
            updateSubtitleTopGradient();
            return;
        }
        TraeAITracker.trackAsrDiscuss$default(TraeAITracker.INSTANCE, AsrDiscussAction.SUBTITLE_MODE_DISABLE, null, 2, null);
        this.isUserScrolling = false;
        View view6 = this.subtitleModeContainer;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitleModeContainer");
            view6 = null;
        }
        view6.setVisibility(0);
        View view7 = this.subtitleModeContainer;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitleModeContainer");
            view7 = null;
        }
        view7.setAlpha(1.0f);
        FrameLayout frameLayout3 = this.aiDisplaySwitcher;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiDisplaySwitcher");
            frameLayout3 = null;
        }
        frameLayout3.setVisibility(0);
        FrameLayout frameLayout4 = this.aiDisplaySwitcher;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiDisplaySwitcher");
            frameLayout4 = null;
        }
        frameLayout4.setAlpha(0.0f);
        FrameLayout frameLayout5 = this.aiDisplaySwitcher;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiDisplaySwitcher");
            frameLayout5 = null;
        }
        frameLayout5.animate().alpha(1.0f).setStartDelay(0L).setDuration(250L).start();
        SphereController sphereController3 = this.sphereController;
        if (sphereController3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sphereController");
        } else {
            sphereController = sphereController3;
        }
        sphereController.start();
        Runnable runnable2 = new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                DiscussingFragment.updateContentMode$lambda$70(DiscussingFragment.this);
            }
        };
        this.subtitleModeHideRunnable = runnable2;
        this.displaySwitchHandler.postDelayed(runnable2, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateContentMode$lambda$69(DiscussingFragment discussingFragment) {
        FrameLayout frameLayout = discussingFragment.aiDisplaySwitcher;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiDisplaySwitcher");
            frameLayout = null;
        }
        frameLayout.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateContentMode$lambda$70(DiscussingFragment discussingFragment) {
        if (!discussingFragment.curIsSubtitleMode) {
            View view = discussingFragment.subtitleTopGradient;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitleTopGradient");
                view = null;
            }
            view.setVisibility(8);
            ImageView imageView = discussingFragment.btnScrollToBottom;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnScrollToBottom");
                imageView = null;
            }
            imageView.setVisibility(8);
            View view2 = discussingFragment.subtitleModeContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitleModeContainer");
                view2 = null;
            }
            view2.setVisibility(8);
            View view3 = discussingFragment.subtitleModeContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitleModeContainer");
                view3 = null;
            }
            view3.setAlpha(1.0f);
        }
        discussingFragment.subtitleModeHideRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateSubtitleTopGradient() {
        boolean z;
        View view;
        View view2 = null;
        if (this.curIsSubtitleMode) {
            RecyclerView recyclerView = this.rvHistorySubtitle;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvHistorySubtitle");
                recyclerView = null;
            }
            if (recyclerView.canScrollVertically(-1)) {
                z = true;
                view = this.subtitleTopGradient;
                if (view != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subtitleTopGradient");
                } else {
                    view2 = view;
                }
                view2.setVisibility(z ? 0 : 8);
            }
        }
        z = false;
        view = this.subtitleTopGradient;
        if (view != null) {
        }
        view2.setVisibility(z ? 0 : 8);
    }

    public void onDestroyView() {
        Object obj;
        super.onDestroyView();
        Runnable runnable = this.pendingDisplaySwitch;
        if (runnable != null) {
            this.displaySwitchHandler.removeCallbacks(runnable);
        }
        this.pendingDisplaySwitch = null;
        Runnable runnable2 = this.bottomTaskDoneClearRunnable;
        if (runnable2 != null) {
            this.displaySwitchHandler.removeCallbacks(runnable2);
        }
        this.bottomTaskDoneClearRunnable = null;
        Runnable runnable3 = this.taskRunningLongRunnable;
        if (runnable3 != null) {
            this.displaySwitchHandler.removeCallbacks(runnable3);
        }
        this.taskRunningLongRunnable = null;
        Runnable runnable4 = this.subtitleModeHideRunnable;
        if (runnable4 != null) {
            this.displaySwitchHandler.removeCallbacks(runnable4);
        }
        this.subtitleModeHideRunnable = null;
        ShimmerTextView shimmerTextView = this.bottomStatusText;
        if (shimmerTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomStatusText");
            shimmerTextView = null;
        }
        shimmerTextView.stopShimmer();
        ShimmerTextView shimmerTextView2 = this.subtitleEmptyHint;
        if (shimmerTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitleEmptyHint");
            shimmerTextView2 = null;
        }
        shimmerTextView2.stopShimmer();
        VoiceStatusWaveIconView voiceStatusWaveIconView = this.mainWaveform;
        if (voiceStatusWaveIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainWaveform");
            voiceStatusWaveIconView = null;
        }
        voiceStatusWaveIconView.stopAnimating();
        SphereController sphereController = this.sphereController;
        if (sphereController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sphereController");
            sphereController = null;
        }
        sphereController.destroy();
        MediaPlayer mediaPlayer = this.enterMediaPlayer;
        if (mediaPlayer != null) {
            try {
                Result.Companion companion = Result.Companion;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.release();
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Result.box-impl(obj);
        }
        this.enterMediaPlayer = null;
    }
}
