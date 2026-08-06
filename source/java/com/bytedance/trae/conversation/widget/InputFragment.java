package com.bytedance.trae.conversation.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.PermissionRationaleDialog;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.AccountSettingsKeva;
import com.bytedance.trae.conversation.AgentResolver;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.ExpressPassBenefitManager;
import com.bytedance.trae.conversation.IDEProjectAvailabilityPolicy;
import com.bytedance.trae.conversation.LoginUtils;
import com.bytedance.trae.conversation.TocCreditsPolicy;
import com.bytedance.trae.conversation.chat.UserPayIdentityService;
import com.bytedance.trae.conversation.databinding.TraeFragmentInputBinding;
import com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment;
import com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment;
import com.bytedance.trae.conversation.devices.DirectoryNode;
import com.bytedance.trae.conversation.devices.SelectedDeviceItem;
import com.bytedance.trae.conversation.git.BranchItem;
import com.bytedance.trae.conversation.git.BranchSelectBottomSheet;
import com.bytedance.trae.conversation.git.GitConnectionState;
import com.bytedance.trae.conversation.git.GitRepoItem;
import com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet;
import com.bytedance.trae.conversation.git.GitSelectionViewModel;
import com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet;
import com.bytedance.trae.conversation.ideproject.IDEProjectNameUtil;
import com.bytedance.trae.conversation.mediachoose.data.MediaStoreRepository;
import com.bytedance.trae.conversation.mediachoose.model.MediaChooseContract;
import com.bytedance.trae.conversation.mediachoose.model.MediaItem;
import com.bytedance.trae.conversation.mediachoose.p008ui.MediaChooseActivity;
import com.bytedance.trae.conversation.model.QueryItem;
import com.bytedance.trae.conversation.network.IRemoteModelsApi;
import com.bytedance.trae.conversation.network.ModelSelectionRepository;
import com.bytedance.trae.conversation.network.PluginItem;
import com.bytedance.trae.conversation.network.ProjectItem;
import com.bytedance.trae.conversation.network.RemoteModelItem;
import com.bytedance.trae.conversation.network.TaskTemplate;
import com.bytedance.trae.conversation.network.TaskTemplateRepository;
import com.bytedance.trae.conversation.network.TaskTemplatesData;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.conversation.plugin.PluginsBottomSheet;
import com.bytedance.trae.conversation.skill.SkillEntryAction;
import com.bytedance.trae.conversation.skill.SkillEntryPolicy;
import com.bytedance.trae.conversation.skill.SkillEntryUnavailableToast;
import com.bytedance.trae.conversation.skill.SkillsBottomSheet;
import com.bytedance.trae.conversation.tracker.AsrRecogAction;
import com.bytedance.trae.conversation.tracker.InputTracker;
import com.bytedance.trae.conversation.tracker.TraeAITracker;
import com.bytedance.trae.conversation.voice.TranscriptionVoiceManager;
import com.bytedance.trae.conversation.widget.ChatAttachmentDialog;
import com.bytedance.trae.conversation.widget.InputFragment;
import com.bytedance.trae.conversation.widget.ModelSelectBottomSheet;
import com.bytedance.trae.conversation.widget.TaskTemplateDeviceSelectionPolicy;
import com.bytedance.trae.conversation.widget.TranscriptEditText;
import com.bytedance.trae.conversation.widget.VoiceRecordingOverlay;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Mode;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.multilanguage.I18nTextProvider;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.facebook.common.logging.FLog;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: InputFragment.kt */
@Metadata(d1 = {"\u0000Õ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0019*\u0003=¥\u0001\u0018\u0000 Ë\u00022\u00020\u0001:\nÇ\u0002È\u0002É\u0002Ê\u0002Ë\u0002B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010A\u001a\u00020\u0005H\u0002J\u0007\u0010\u0096\u0001\u001a\u00020EJ+\u0010½\u0001\u001a\u00020'2\b\u0010¾\u0001\u001a\u00030¿\u00012\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00012\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0016J\u0010\u0010Ä\u0001\u001a\u00020K2\u0007\u0010Å\u0001\u001a\u00020)J\u001e\u0010É\u0001\u001a\u00020K2\u0007\u0010Ê\u0001\u001a\u00020'2\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0016J\t\u0010Ë\u0001\u001a\u00020KH\u0002J\t\u0010Ì\u0001\u001a\u00020KH\u0002J\u0012\u0010Í\u0001\u001a\u00020K2\u0007\u0010Î\u0001\u001a\u00020)H\u0002J\t\u0010Ï\u0001\u001a\u00020KH\u0002J\t\u0010Ð\u0001\u001a\u00020KH\u0002J\t\u0010Ñ\u0001\u001a\u00020KH\u0002J\t\u0010Ò\u0001\u001a\u00020KH\u0002J\t\u0010Ó\u0001\u001a\u00020KH\u0002J\u0007\u0010Ô\u0001\u001a\u00020KJ\t\u0010Õ\u0001\u001a\u00020KH\u0003J\t\u0010Ö\u0001\u001a\u00020KH\u0002J\u0015\u0010×\u0001\u001a\u00020K2\n\u0010Ø\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0002J\t\u0010Ù\u0001\u001a\u00020KH\u0002J\u0015\u0010Ú\u0001\u001a\u00020K2\n\u0010Ø\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0002J\t\u0010Û\u0001\u001a\u00020KH\u0002J\u0007\u0010Ü\u0001\u001a\u00020\u0005J\u0018\u0010Ý\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050m2\u0007\u0010Þ\u0001\u001a\u000209H\u0002J@\u0010ß\u0001\u001a\u00020K2\t\u0010à\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010á\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010â\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010ã\u0001\u001a\u00020)2\u000b\b\u0002\u0010ä\u0001\u001a\u0004\u0018\u00010\u0005H\u0002J\u001e\u0010å\u0001\u001a\u00020K2\b\u0010Ø\u0001\u001a\u00030\u0082\u00012\t\b\u0002\u0010æ\u0001\u001a\u00020)H\u0002J\t\u0010ç\u0001\u001a\u00020KH\u0002J\u0013\u0010è\u0001\u001a\u00020K2\b\u0010é\u0001\u001a\u00030ê\u0001H\u0002J\t\u0010ë\u0001\u001a\u00020)H\u0002J\t\u0010ì\u0001\u001a\u00020KH\u0002J\t\u0010í\u0001\u001a\u00020KH\u0002J\t\u0010î\u0001\u001a\u00020KH\u0002J\t\u0010ï\u0001\u001a\u00020KH\u0002J\u0012\u0010ð\u0001\u001a\u00020K2\u0007\u0010ñ\u0001\u001a\u00020)H\u0002J\u0012\u0010ò\u0001\u001a\u00020K2\u0007\u0010ñ\u0001\u001a\u00020)H\u0002J\t\u0010ó\u0001\u001a\u00020KH\u0002J\u0007\u0010ô\u0001\u001a\u00020KJ\t\u0010õ\u0001\u001a\u0004\u0018\u00010\u0005J\t\u0010ö\u0001\u001a\u0004\u0018\u000107J\u0012\u0010÷\u0001\u001a\u00020K2\t\u0010ä\u0001\u001a\u0004\u0018\u00010\u0005J\u0007\u0010ø\u0001\u001a\u00020KJ\u001b\u0010ù\u0001\u001a\u00020K2\u0007\u0010ú\u0001\u001a\u0002072\u0007\u0010û\u0001\u001a\u00020)H\u0002J\t\u0010ü\u0001\u001a\u00020\u0005H\u0002J\t\u0010ý\u0001\u001a\u00020\u0005H\u0002J\u0010\u0010þ\u0001\u001a\u00020K2\u0007\u0010ÿ\u0001\u001a\u00020\u0005J\u000f\u0010\u0080\u0002\u001a\u00020K2\u0006\u0010D\u001a\u00020)J\u0013\u0010\u0081\u0002\u001a\u00020K2\b\u0010Ø\u0001\u001a\u00030\u0082\u0001H\u0002J\u0011\u0010\u0082\u0002\u001a\u00020K2\b\u0010Ø\u0001\u001a\u00030\u0082\u0001J\t\u0010\u0083\u0002\u001a\u00020KH\u0002J\u0014\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010\u0085\u0002\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0086\u0002\u001a\u00020K2\u0007\u0010ñ\u0001\u001a\u00020)J\u0010\u0010\u0087\u0002\u001a\u00020K2\u0007\u0010\u0088\u0002\u001a\u00020)J\u0010\u0010\u0089\u0002\u001a\u00020K2\u0007\u0010\u0088\u0002\u001a\u00020)J\u0007\u0010\u008a\u0002\u001a\u00020KJ\u0007\u0010\u008b\u0002\u001a\u00020KJ\t\u0010\u008c\u0002\u001a\u00020KH\u0002J\t\u0010\u008d\u0002\u001a\u00020KH\u0002J\u0010\u0010\u008e\u0002\u001a\u00020K2\u0007\u0010\u008f\u0002\u001a\u00020)J\u0010\u0010\u0090\u0002\u001a\u00020K2\u0007\u0010\u0091\u0002\u001a\u00020)J\u0010\u0010\u0092\u0002\u001a\u00020K2\u0007\u0010\u0093\u0002\u001a\u00020)J\u0007\u0010\u0094\u0002\u001a\u00020KJ\u0010\u0010\u0095\u0002\u001a\u00020K2\u0007\u0010\u0096\u0002\u001a\u00020\u001fJ\u0010\u0010\u0097\u0002\u001a\u00020K2\u0007\u0010\u0096\u0002\u001a\u00020\u001fJ\u0007\u0010\u0098\u0002\u001a\u00020)J\t\u0010\u0099\u0002\u001a\u00020)H\u0002J\t\u0010\u009a\u0002\u001a\u00020)H\u0002J\t\u0010\u009b\u0002\u001a\u00020)H\u0002J\t\u0010\u009c\u0002\u001a\u00020)H\u0002J\b\u0010\u009d\u0002\u001a\u00030\u009e\u0002J\u0010\u0010\u009f\u0002\u001a\u00020\u00052\u0007\u0010 \u0002\u001a\u00020\u0005J\u0007\u0010¡\u0002\u001a\u00020KJ\u000e\u0010¢\u0002\u001a\u00020\u0005*\u00030£\u0002H\u0002J\n\u0010¤\u0002\u001a\u0005\u0018\u00010¥\u0002J\u0011\u0010¦\u0002\u001a\u00020K2\b\u0010§\u0002\u001a\u00030¥\u0002J\u0010\u0010¨\u0002\u001a\u00020K2\u0007\u0010©\u0002\u001a\u00020\u0005J\u0007\u0010ª\u0002\u001a\u00020KJ\u0011\u0010«\u0002\u001a\u00020K2\b\u0010¬\u0002\u001a\u00030\u00ad\u0002J\t\u0010®\u0002\u001a\u00020)H\u0002J4\u0010¯\u0002\u001a\u00020K2\u0007\u0010°\u0002\u001a\u00020E2\u0010\u0010±\u0002\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00050¼\u00012\b\u0010²\u0002\u001a\u00030³\u0002H\u0016¢\u0006\u0003\u0010´\u0002J\u0010\u0010µ\u0002\u001a\u00020K2\u0007\u0010¶\u0002\u001a\u00020\u0019J\t\u0010·\u0002\u001a\u00020KH\u0002J\t\u0010¸\u0002\u001a\u00020)H\u0002J\t\u0010¹\u0002\u001a\u00020)H\u0002J\u0010\u0010º\u0002\u001a\u00020K2\u0007\u0010¶\u0002\u001a\u00020\u0019J\t\u0010»\u0002\u001a\u00020KH\u0016J\t\u0010¼\u0002\u001a\u00020KH\u0002J\u000b\u0010½\u0002\u001a\u0004\u0018\u00010rH\u0002J\u001c\u0010¾\u0002\u001a\u00020K2\b\u0010¿\u0002\u001a\u00030Á\u00012\u0007\u0010ñ\u0001\u001a\u00020)H\u0002J\u0007\u0010À\u0002\u001a\u00020KJ\t\u0010Á\u0002\u001a\u00020KH\u0002J\t\u0010Â\u0002\u001a\u00020KH\u0002J\u0012\u0010Ã\u0002\u001a\u00020K2\u0007\u0010ñ\u0001\u001a\u00020)H\u0002J\t\u0010Ä\u0002\u001a\u00020KH\u0002J\u0007\u0010Å\u0002\u001a\u00020KJ\u0007\u0010Æ\u0002\u001a\u00020KR\u001c\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\b\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010F\u001a\u00020E2\u0006\u0010D\u001a\u00020E@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\"\u0010I\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR(\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020K\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR.\u0010V\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020K\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R(\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020K\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010S\"\u0004\b_\u0010UR\"\u0010`\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010M\"\u0004\bb\u0010OR\"\u0010c\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010M\"\u0004\be\u0010OR\"\u0010f\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010M\"\u0004\bh\u0010OR\"\u0010i\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010M\"\u0004\bk\u0010OR.\u0010l\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020n0m\u0012\u0004\u0012\u00020K\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010S\"\u0004\bp\u0010UR(\u0010q\u001a\u0010\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020K\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010S\"\u0004\bt\u0010UR(\u0010u\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020K\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010S\"\u0004\bw\u0010UR(\u0010x\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020K\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010S\"\u0004\bz\u0010UR(\u0010{\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020K\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010S\"\u0004\b}\u0010UR#\u0010~\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010JX\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010M\"\u0005\b\u0080\u0001\u0010OR,\u0010\u0081\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0004\u0012\u00020K\u0018\u00010QX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010S\"\u0005\b\u0084\u0001\u0010UR:\u0010\u0085\u0001\u001a\u001f\u0012\u0013\u0012\u0011\u0012\u0007\u0012\u0005\u0018\u00010\u0082\u0001\u0012\u0004\u0012\u00020K0Q\u0012\u0004\u0012\u00020K\u0018\u00010QX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010S\"\u0005\b\u0087\u0001\u0010UR%\u0010\u0088\u0001\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010JX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010M\"\u0005\b\u008a\u0001\u0010OR%\u0010\u008b\u0001\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010JX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010M\"\u0005\b\u008d\u0001\u0010OR%\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010JX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010M\"\u0005\b\u008f\u0001\u0010OR\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0011\u0010\u0097\u0001\u001a\u0004\u0018\u00010rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0099\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u009d\u0001\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u009e\u0001\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u009f\u0001\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010 \u0001\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¡\u0001\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¢\u0001\u001a\u00030£\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010¤\u0001\u001a\u00030¥\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¦\u0001R\u0012\u0010§\u0001\u001a\u0005\u0018\u00010\u0082\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¨\u0001\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010©\u0001\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010ª\u0001\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¯\u0001\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010°\u0001\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010±\u0001\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010²\u0001\u001a\u00030³\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010´\u0001\u001a\u00030³\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010µ\u0001\u001a\u0012\u0012\r\u0012\u000b ·\u0001*\u0004\u0018\u00010\u00050\u00050¶\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010¸\u0001\u001a\u0012\u0012\r\u0012\u000b ·\u0001*\u0004\u0018\u00010r0r0¶\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010¹\u0001\u001a\u0014\u0012\u000f\u0012\r ·\u0001*\u0005\u0018\u00010º\u00010º\u00010¶\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010»\u0001\u001a \u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0005 ·\u0001*\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010¼\u00010¼\u00010¶\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010Æ\u0001\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010JX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÇ\u0001\u0010M\"\u0005\bÈ\u0001\u0010O¨\u0006Ì\u0002"}, d2 = {"Lcom/bytedance/trae/conversation/widget/InputFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "TAG$1", "_binding", "Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;", "binding", "getBinding", "()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;", "gitViewModel", "Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;", "inputViewModel", "Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;", "getInputViewModel", "()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;", "inputViewModel$delegate", "Lkotlin/Lazy;", "currentMode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "getCurrentMode", "()Lcom/bytedance/trae/conversation/widget/ChatMode;", "setCurrentMode", "(Lcom/bytedance/trae/conversation/widget/ChatMode;)V", "currentInputState", "Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;", "getCurrentInputState", "()Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;", "setCurrentInputState", "(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V", "holdToTalkState", "Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;", "voiceLoadingView", "Landroid/view/View;", "isNewConversation", "", "()Z", "setNewConversation", "(Z)V", "isLongPressRecording", "isLongPressCancelled", "longPressHandler", "Landroid/os/Handler;", "longPressRunnable", "Ljava/lang/Runnable;", "lastHoldToTalkPressTime", "", "needTranscript", "selectedRemoteModel", "Lcom/bytedance/trae/conversation/network/RemoteModelItem;", "currentCliType", "Lcom/bytedance/trae/im/service/CliType;", "voiceChatSessionManager", "Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;", "voiceChatListener", "com/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1", "Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;", "contextualBarVisibilityState", "Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;", "currentInputStateNameForMetrics", "bottomBarVisible", "initInputText", "value", "", "asrCount", "getAsrCount", "()I", "onPauseClickListener", "Lkotlin/Function0;", "", "getOnPauseClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnPauseClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onSendText", "Lkotlin/Function1;", "getOnSendText", "()Lkotlin/jvm/functions/Function1;", "setOnSendText", "(Lkotlin/jvm/functions/Function1;)V", "onSendAudioText", "Lkotlin/Function2;", "getOnSendAudioText", "()Lkotlin/jvm/functions/Function2;", "setOnSendAudioText", "(Lkotlin/jvm/functions/Function2;)V", "onAttachmentSelected", "Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;", "getOnAttachmentSelected", "setOnAttachmentSelected", "onChatNewClick", "getOnChatNewClick", "setOnChatNewClick", "onCloudClick", "getOnCloudClick", "setOnCloudClick", "onGitHubClick", "getOnGitHubClick", "setOnGitHubClick", "onReady", "getOnReady", "setOnReady", "onImageSelected", "", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "getOnImageSelected", "setOnImageSelected", "onFileSelected", "Landroid/net/Uri;", "getOnFileSelected", "setOnFileSelected", "onSwitchMode", "getOnSwitchMode", "setOnSwitchMode", "onRecordingStateChanged", "getOnRecordingStateChanged", "setOnRecordingStateChanged", "onTemplateClick", "getOnTemplateClick", "setOnTemplateClick", "onDeviceClick", "getOnDeviceClick", "setOnDeviceClick", "onSelectedDeviceChanged", "Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "getOnSelectedDeviceChanged", "setOnSelectedDeviceChanged", "onRequestSkillProjectCheck", "getOnRequestSkillProjectCheck", "setOnRequestSkillProjectCheck", "onAuthFailed", "getOnAuthFailed", "setOnAuthFailed", "onInputFocus", "getOnInputFocus", "setOnInputFocus", "isTaskRunning", "setTaskRunning", "voiceRecordingOverlay", "Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;", "getVoiceRecordingOverlay", "()Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;", "setVoiceRecordingOverlay", "(Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;)V", "consumeAsrCount", "pendingCameraUri", "deviceTipsPopWindow", "Landroid/widget/PopupWindow;", "expressPassPopWindow", "expressPassPopDismissRunnable", "expressPassTogglePopWindow", "tooltipDismissRunnable", "tooltipArrowRunnable", "tooltipPopView", "infinite", "isExpressPassVisible", "remainingChangedListener", "Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnRemainingChangedListener;", "benefitSwitchListener", "com/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1", "Lcom/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1;", "currentDevice", "isCheckingSkillProject", "hasMultipleProducts", "currentConversationId", "taskTemplatesRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "taskTemplateAdapter", "Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;", "isKeyboardVisible", "isKeyboardVisibleForTemplates", "isKeyboardListenerRegistered", "inputKeyboardLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "keyboardLayoutListener", "cameraPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "takePictureLauncher", "mediaChooseLauncher", "Landroid/content/Intent;", "filePickerLauncher", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setMinimizedVoiceMode", "active", "onMaximizeBrainstormClick", "getOnMaximizeBrainstormClick", "setOnMaximizeBrainstormClick", "onViewCreated", "view", "resetInputBar", "setupFileTooLargeObserver", "showExpressPassBtn", "show", "setupExpressPassBenefit", "setupAttachmentsRecyclerView", "setupInputWatcher", "updateHoldToTalkUI", "setupGitObservers", "send", "setupClickListeners", "showSkillsForCurrentDevice", "showSkillsBottomSheetForDevice", "device", "checkHistoricalIdeProjectThenShowSkills", "showCheckedIdeSkillsUnavailableToast", "showCurrentDeviceOfflineToast", "getSkillsForRequest", "resolveModelFunctions", "cliType", "showSkillsBottomSheet", "cliId", "workspaceFolder", "projectId", "isIdeSkills", "conversationId", "showIDEProjectPicker", "openSkillsAfterSelection", "startLongPressRecording", "handleLongPressTouch", Fields.EVENT, "Landroid/view/MotionEvent;", "isNetworkAvailable", "audioRecordingRelease", "showVoiceLoading", "hideVoiceLoading", "updateBranchColor", "updateBranchEnabled", "enabled", "updateGithubEnabled", "updateRepoIconForLoginPlatform", "loadGitRepos", "getSelectedModelNameForRequest", "getSelectedModelForRequest", "setConversationId", "restoreSelectedModelFromCache", "saveSelectedModel", "model", "saveMode", "currentEnvironmentKey", "currentModeKey", "setCloudName", "name", "setMultipleProducts", "preloadPlugins", "setSelectedDevice", "updateContextualBar", "parseWorkspaceDisplayName", MessagePart.TYPE_WORKSPACE, "setCloudEnabled", "setBottomContextualBarVisible", "visible", "setDeviceFolderBarVisible", "showTaskTemplates", "hideTaskTemplates", "registerKeyboardListener", "unregisterKeyboardListener", "setSendingState", "isSending", "cancelTask", "isSuccess", "onStreaming", "isDone", "switchInputSended", "switchInputState", "state", "setInputState", "hasInputMessage", "hasUploadedAttachments", "hasUploadingAttachments", "hasFailedAttachments", "canSend", "getInputPayload", "Lcom/bytedance/trae/conversation/widget/InputFragment$InputPayload;", "getQuery", "input", "clearInput", "getQueryFileName", "Lcom/bytedance/trae/conversation/widget/AttachmentItem;", "saveDraft", "Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;", "restoreDraft", "draft", "setInputText", "text", "resetSendButton", "addRevertMessage", "message", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "ensureRecordAudioPermission", "onRequestPermissionsResult", "requestCode", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "setMode", "mode", "updateModelSelectorVisibility", "isManualModelSelectionSupported", "isModelSelectorTaskLocked", "switchMode", "onDestroyView", "openCamera", "createImageUri", "setViewGroupEnabled", "viewGroup", "hideKeyboard", "showExpressPassPopWindow", "dismissExpressPassPopWindow", "showExpressPassToggleTooltip", "dismissExpressPassToggleTooltip", "showDeviceTipsPopWindow", "dismissDeviceTipsPopWindow", "InputState", "HoldToTalkState", "InputPayload", "ModeDraft", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputFragment extends Fragment {
    private static final long CUSTOM_LONG_PRESS_TIMEOUT_MS = 250;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long HOLD_TO_TALK_DEBOUNCE_MS = 300;
    private static final String KEY_DEVICE_TIPS_SHOWN = "device_tips_shown";
    private static final long PLEASE_SPEAK_DELAY_MS = 500;
    private static final int REQUEST_CODE_RECORD_AUDIO = 10001;
    public static final String TAG = "InputFragment";

    /* renamed from: TAG$1, reason: from kotlin metadata */
    private String TAG = TAG;
    private TraeFragmentInputBinding _binding;
    private int asrCount;
    private final InputFragment$benefitSwitchListener$1 benefitSwitchListener;
    private boolean bottomBarVisible;
    private final ActivityResultLauncher<String> cameraPermissionLauncher;
    private final InputContextualBarVisibilityState contextualBarVisibilityState;
    private CliType currentCliType;
    private String currentConversationId;
    private SelectedDeviceItem currentDevice;
    private InputState currentInputState;
    private ChatMode currentMode;
    private PopupWindow deviceTipsPopWindow;
    private Runnable expressPassPopDismissRunnable;
    private PopupWindow expressPassPopWindow;
    private PopupWindow expressPassTogglePopWindow;
    private final ActivityResultLauncher<String[]> filePickerLauncher;
    private GitSelectionViewModel gitViewModel;
    private boolean hasMultipleProducts;
    private HoldToTalkState holdToTalkState;
    private boolean infinite;
    private String initInputText;
    private final ViewTreeObserver.OnGlobalLayoutListener inputKeyboardLayoutListener;

    /* renamed from: inputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy inputViewModel;
    private boolean isCheckingSkillProject;
    private boolean isExpressPassVisible;
    private boolean isKeyboardListenerRegistered;
    private boolean isKeyboardVisible;
    private boolean isKeyboardVisibleForTemplates;
    private boolean isLongPressCancelled;
    private boolean isLongPressRecording;
    private boolean isNewConversation;
    private Function0<Boolean> isTaskRunning;
    private final ViewTreeObserver.OnGlobalLayoutListener keyboardLayoutListener;
    private long lastHoldToTalkPressTime;
    private final Handler longPressHandler;
    private Runnable longPressRunnable;
    private final ActivityResultLauncher<Intent> mediaChooseLauncher;
    private boolean needTranscript;
    private Function1<? super ChatAttachmentDialog.AttachmentType, Unit> onAttachmentSelected;
    private Function0<Unit> onAuthFailed;
    private Function0<Unit> onChatNewClick;
    private Function0<Unit> onCloudClick;
    private Function0<Unit> onDeviceClick;
    private Function1<? super Uri, Unit> onFileSelected;
    private Function0<Unit> onGitHubClick;
    private Function1<? super List<MediaItem>, Unit> onImageSelected;
    private Function0<Unit> onInputFocus;
    private Function0<Unit> onMaximizeBrainstormClick;
    private Function0<Unit> onPauseClickListener;
    private Function0<Unit> onReady;
    private Function1<? super Boolean, Unit> onRecordingStateChanged;
    private Function1<? super Function1<? super SelectedDeviceItem, Unit>, Unit> onRequestSkillProjectCheck;
    private Function1<? super SelectedDeviceItem, Unit> onSelectedDeviceChanged;
    private Function2<? super String, ? super String, Unit> onSendAudioText;
    private Function1<? super String, Unit> onSendText;
    private Function1<? super ChatMode, Unit> onSwitchMode;
    private Function1<? super String, Unit> onTemplateClick;
    private Uri pendingCameraUri;
    private final ExpressPassBenefitManager.OnRemainingChangedListener remainingChangedListener;
    private RemoteModelItem selectedRemoteModel;
    private final ActivityResultLauncher<Uri> takePictureLauncher;
    private TaskTemplateAdapter taskTemplateAdapter;
    private RecyclerView taskTemplatesRecyclerView;
    private Runnable tooltipArrowRunnable;
    private Runnable tooltipDismissRunnable;
    private View tooltipPopView;
    private final InputFragment$voiceChatListener$1 voiceChatListener;
    private TranscriptionVoiceManager voiceChatSessionManager;
    private View voiceLoadingView;
    private VoiceRecordingOverlay voiceRecordingOverlay;

    /* compiled from: InputFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;

        static {
            int[] iArr = new int[HoldToTalkState.values().length];
            try {
                iArr[HoldToTalkState.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HoldToTalkState.HOLD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ChatAttachmentDialog.AttachmentType.values().length];
            try {
                iArr2[ChatAttachmentDialog.AttachmentType.SKILLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ChatAttachmentDialog.AttachmentType.PLUGINS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ChatAttachmentDialog.AttachmentType.PHOTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ChatAttachmentDialog.AttachmentType.FILES.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ChatAttachmentDialog.AttachmentType.CAMERA.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[SkillEntryAction.values().length];
            try {
                iArr3[SkillEntryAction.OPEN_SKILLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[SkillEntryAction.OPEN_IDE_PROJECT_PICKER.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[SkillEntryAction.CHECK_HISTORICAL_IDE_PROJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[CliType.values().length];
            try {
                iArr4[CliType.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[CliType.IDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[SkillEntryUnavailableToast.values().length];
            try {
                iArr5[SkillEntryUnavailableToast.WORKSPACE_CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr5[SkillEntryUnavailableToast.DEVICE_OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[ChatMode.values().length];
            try {
                iArr6[ChatMode.CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr6[ChatMode.MTC.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[TaskTemplateDeviceSelectionPolicy.Action.values().length];
            try {
                iArr7[TaskTemplateDeviceSelectionPolicy.Action.KEEP.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr7[TaskTemplateDeviceSelectionPolicy.Action.HIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr7[TaskTemplateDeviceSelectionPolicy.Action.REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            $EnumSwitchMapping$6 = iArr7;
            int[] iArr8 = new int[InputState.values().length];
            try {
                iArr8[InputState.Empty.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr8[InputState.Input.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr8[InputState.Sending.ordinal()] = 3;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr8[InputState.Sended.ordinal()] = 4;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr8[InputState.Stopped.ordinal()] = 5;
            } catch (NoSuchFieldError unused24) {
            }
            $EnumSwitchMapping$7 = iArr8;
        }
    }

    private final boolean isManualModelSelectionSupported() {
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.bytedance.trae.conversation.widget.InputFragment$voiceChatListener$1] */
    public InputFragment() {
        final InputFragment inputFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.bytedance.trae.conversation.widget.InputFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m1568invoke() {
                return inputFragment;
            }
        };
        this.inputViewModel = FragmentViewModelLazyKt.createViewModelLazy(inputFragment, Reflection.getOrCreateKotlinClass(InputAttachmentListModel.class), new Function0<ViewModelStore>() { // from class: com.bytedance.trae.conversation.widget.InputFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelStore m1569invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.bytedance.trae.conversation.widget.InputFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelProvider.Factory m1570invoke() {
                Object invoke = function0.invoke();
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = invoke instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) invoke : null;
                ViewModelProvider.Factory defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = inputFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.currentMode = ChatMode.MTC;
        this.currentInputState = InputState.Empty;
        this.holdToTalkState = HoldToTalkState.Normal;
        this.longPressHandler = new Handler(Looper.getMainLooper());
        this.needTranscript = true;
        this.selectedRemoteModel = RemoteModelItem.INSTANCE.auto();
        this.currentCliType = CliType.REMOTE;
        this.voiceChatListener = new TranscriptionVoiceManager.Listener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$voiceChatListener$1
            @Override // com.bytedance.trae.conversation.voice.TranscriptionVoiceManager.Listener
            public void onStatus(TranscriptionVoiceManager.Status status) {
                Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
                Log.e("VoiceChatSession", "onStatus:" + status);
            }

            @Override // com.bytedance.trae.conversation.voice.TranscriptionVoiceManager.Listener
            public void onRecognizedText(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                Log.e("VoiceChatSession", "onRecognizedText:" + text);
            }

            @Override // com.bytedance.trae.conversation.voice.TranscriptionVoiceManager.Listener
            public void onFinalText(String text) {
                boolean z;
                String currentInputStateNameForMetrics;
                TraeFragmentInputBinding traeFragmentInputBinding;
                boolean z2;
                TranscriptionVoiceManager transcriptionVoiceManager;
                TranscriptionVoiceManager transcriptionVoiceManager2;
                boolean z3;
                TranscriptionVoiceManager transcriptionVoiceManager3;
                TraeFragmentInputBinding binding;
                TranscriptionVoiceManager transcriptionVoiceManager4;
                TranscriptionVoiceManager transcriptionVoiceManager5;
                TranscriptionVoiceManager transcriptionVoiceManager6;
                Intrinsics.checkNotNullParameter(text, "text");
                StringBuilder append = new StringBuilder("onFinalText:").append(text).append(' ');
                z = InputFragment.this.needTranscript;
                Log.e("VoiceChatSession", append.append(z).toString());
                currentInputStateNameForMetrics = InputFragment.this.currentInputStateNameForMetrics();
                traeFragmentInputBinding = InputFragment.this._binding;
                TranscriptionVoiceManager transcriptionVoiceManager7 = null;
                if (traeFragmentInputBinding == null) {
                    transcriptionVoiceManager6 = InputFragment.this.voiceChatSessionManager;
                    if (transcriptionVoiceManager6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("voiceChatSessionManager");
                    } else {
                        transcriptionVoiceManager7 = transcriptionVoiceManager6;
                    }
                    transcriptionVoiceManager7.reportAttemptOutcome("error", currentInputStateNameForMetrics, "binding_missing");
                    return;
                }
                TraeAITracker.INSTANCE.trackAsrRecog(AsrRecogAction.RECOG_END);
                String str = text;
                boolean z4 = false;
                if (str.length() > 0) {
                    z3 = InputFragment.this.needTranscript;
                    if (z3) {
                        InputFragment.this.asrCount = InputFragment.this.getAsrCount() + 1;
                        if (InputFragment.this.getCurrentInputState() != InputFragment.InputState.Sending && InputFragment.this.getCurrentInputState() != InputFragment.InputState.Sended && InputFragment.this.getCurrentInputState() != InputFragment.InputState.Stopped) {
                            Function0<Boolean> isTaskRunning = InputFragment.this.isTaskRunning();
                            if (!(isTaskRunning != null && ((Boolean) isTaskRunning.invoke()).booleanValue())) {
                                z4 = true;
                            }
                        }
                        if (!z4) {
                            InputFragment.this.holdToTalkState = InputFragment.HoldToTalkState.Normal;
                            InputFragment.this.updateHoldToTalkUI();
                            binding = InputFragment.this.getBinding();
                            binding.etInput.setText(str);
                            transcriptionVoiceManager4 = InputFragment.this.voiceChatSessionManager;
                            if (transcriptionVoiceManager4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("voiceChatSessionManager");
                            } else {
                                transcriptionVoiceManager7 = transcriptionVoiceManager4;
                            }
                            TranscriptionVoiceManager.reportAttemptOutcome$default(transcriptionVoiceManager7, "fill_input", currentInputStateNameForMetrics, null, 4, null);
                            Log.e("VoiceChatSession", "setText");
                        } else {
                            String query = InputFragment.this.getQuery(text);
                            InputFragment.this.hideKeyboard();
                            InputFragment.this.setSendingState(true);
                            Function2<String, String, Unit> onSendAudioText = InputFragment.this.getOnSendAudioText();
                            if (onSendAudioText != null) {
                                onSendAudioText.invoke(query, text);
                            }
                            transcriptionVoiceManager5 = InputFragment.this.voiceChatSessionManager;
                            if (transcriptionVoiceManager5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("voiceChatSessionManager");
                            } else {
                                transcriptionVoiceManager7 = transcriptionVoiceManager5;
                            }
                            TranscriptionVoiceManager.reportAttemptOutcome$default(transcriptionVoiceManager7, "auto_send", currentInputStateNameForMetrics, null, 4, null);
                            Log.e("VoiceChatSession", "onSendAudioText");
                        }
                    } else {
                        transcriptionVoiceManager3 = InputFragment.this.voiceChatSessionManager;
                        if (transcriptionVoiceManager3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("voiceChatSessionManager");
                        } else {
                            transcriptionVoiceManager7 = transcriptionVoiceManager3;
                        }
                        TranscriptionVoiceManager.reportAttemptOutcome$default(transcriptionVoiceManager7, "cancel", currentInputStateNameForMetrics, null, 4, null);
                    }
                } else {
                    z2 = InputFragment.this.needTranscript;
                    if (!z2) {
                        transcriptionVoiceManager = InputFragment.this.voiceChatSessionManager;
                        if (transcriptionVoiceManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("voiceChatSessionManager");
                        } else {
                            transcriptionVoiceManager7 = transcriptionVoiceManager;
                        }
                        TranscriptionVoiceManager.reportAttemptOutcome$default(transcriptionVoiceManager7, "cancel", currentInputStateNameForMetrics, null, 4, null);
                    } else {
                        Toast.makeText(InputFragment.this.requireContext(), InputFragment.this.getString(R.string.voice_no_text_recognized), 0).show();
                        transcriptionVoiceManager2 = InputFragment.this.voiceChatSessionManager;
                        if (transcriptionVoiceManager2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("voiceChatSessionManager");
                        } else {
                            transcriptionVoiceManager7 = transcriptionVoiceManager2;
                        }
                        TranscriptionVoiceManager.reportAttemptOutcome$default(transcriptionVoiceManager7, "empty_text", currentInputStateNameForMetrics, null, 4, null);
                    }
                }
                InputFragment.this.hideVoiceLoading();
                InputFragment.this.resetInputBar();
            }

            @Override // com.bytedance.trae.conversation.voice.TranscriptionVoiceManager.Listener
            public void onError(Throwable error) {
                String currentInputStateNameForMetrics;
                TranscriptionVoiceManager transcriptionVoiceManager;
                TraeFragmentInputBinding traeFragmentInputBinding;
                Intrinsics.checkNotNullParameter(error, "error");
                currentInputStateNameForMetrics = InputFragment.this.currentInputStateNameForMetrics();
                transcriptionVoiceManager = InputFragment.this.voiceChatSessionManager;
                if (transcriptionVoiceManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("voiceChatSessionManager");
                    transcriptionVoiceManager = null;
                }
                transcriptionVoiceManager.reportAttemptOutcome("error", currentInputStateNameForMetrics, TranscriptionVoiceManager.INSTANCE.failureReasonFor(error));
                traeFragmentInputBinding = InputFragment.this._binding;
                if (traeFragmentInputBinding == null) {
                    return;
                }
                Context requireContext = InputFragment.this.requireContext();
                String message = error.getMessage();
                if (message == null) {
                    message = InputFragment.this.getString(R.string.trae_voice_error);
                    Intrinsics.checkNotNullExpressionValue(message, "getString(...)");
                }
                Toast.makeText(requireContext, message, 0).show();
                InputFragment.this.hideVoiceLoading();
                InputFragment.this.resetInputBar();
            }

            @Override // com.bytedance.trae.conversation.voice.TranscriptionVoiceManager.Listener
            public void onLocalAudioVolume(float volume) {
                VoiceRecordingOverlay voiceRecordingOverlay = InputFragment.this.getVoiceRecordingOverlay();
                if (voiceRecordingOverlay != null) {
                    voiceRecordingOverlay.updateVolume(volume);
                }
            }
        };
        this.contextualBarVisibilityState = new InputContextualBarVisibilityState(false, 1, null);
        this.initInputText = "";
        this.remainingChangedListener = new ExpressPassBenefitManager.OnRemainingChangedListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda32
            @Override // com.bytedance.trae.conversation.ExpressPassBenefitManager.OnRemainingChangedListener
            public final void onRemainingChanged(long j, long j2, boolean z) {
                InputFragment.remainingChangedListener$lambda$2(InputFragment.this, j, j2, z);
            }
        };
        this.benefitSwitchListener = new InputFragment$benefitSwitchListener$1(this);
        this.inputKeyboardLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda34
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                InputFragment.inputKeyboardLayoutListener$lambda$3(InputFragment.this);
            }
        };
        this.keyboardLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda35
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                InputFragment.keyboardLayoutListener$lambda$4(InputFragment.this);
            }
        };
        ActivityResultLauncher<String> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda36
            public final void onActivityResult(Object obj) {
                InputFragment.cameraPermissionLauncher$lambda$5(InputFragment.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.cameraPermissionLauncher = registerForActivityResult;
        ActivityResultLauncher<Uri> registerForActivityResult2 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.TakePicture(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda37
            public final void onActivityResult(Object obj) {
                InputFragment.takePictureLauncher$lambda$7(InputFragment.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.takePictureLauncher = registerForActivityResult2;
        ActivityResultLauncher<Intent> registerForActivityResult3 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda38
            public final void onActivityResult(Object obj) {
                InputFragment.mediaChooseLauncher$lambda$8(InputFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult3, "registerForActivityResult(...)");
        this.mediaChooseLauncher = registerForActivityResult3;
        ActivityResultLauncher<String[]> registerForActivityResult4 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.OpenMultipleDocuments(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda39
            public final void onActivityResult(Object obj) {
                InputFragment.filePickerLauncher$lambda$11(InputFragment.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult4, "registerForActivityResult(...)");
        this.filePickerLauncher = registerForActivityResult4;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final void setTAG(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.TAG = str;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: InputFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;", "", "<init>", "(Ljava/lang/String;I)V", "Empty", "Input", "Sending", "Sended", "Stopped", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class InputState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ InputState[] $VALUES;
        public static final InputState Empty = new InputState("Empty", 0);
        public static final InputState Input = new InputState("Input", 1);
        public static final InputState Sending = new InputState("Sending", 2);
        public static final InputState Sended = new InputState("Sended", 3);
        public static final InputState Stopped = new InputState("Stopped", 4);

        private static final /* synthetic */ InputState[] $values() {
            return new InputState[]{Empty, Input, Sending, Sended, Stopped};
        }

        public static EnumEntries<InputState> getEntries() {
            return $ENTRIES;
        }

        private InputState(String str, int i) {
        }

        static {
            InputState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static InputState valueOf(String str) {
            return (InputState) Enum.valueOf(InputState.class, str);
        }

        public static InputState[] values() {
            return (InputState[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: InputFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "HOLD", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class HoldToTalkState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HoldToTalkState[] $VALUES;
        public static final HoldToTalkState Normal = new HoldToTalkState("Normal", 0);
        public static final HoldToTalkState HOLD = new HoldToTalkState("HOLD", 1);

        private static final /* synthetic */ HoldToTalkState[] $values() {
            return new HoldToTalkState[]{Normal, HOLD};
        }

        public static EnumEntries<HoldToTalkState> getEntries() {
            return $ENTRIES;
        }

        private HoldToTalkState(String str, int i) {
        }

        static {
            HoldToTalkState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static HoldToTalkState valueOf(String str) {
            return (HoldToTalkState) Enum.valueOf(HoldToTalkState.class, str);
        }

        public static HoldToTalkState[] values() {
            return (HoldToTalkState[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TraeFragmentInputBinding getBinding() {
        TraeFragmentInputBinding traeFragmentInputBinding = this._binding;
        Intrinsics.checkNotNull(traeFragmentInputBinding);
        return traeFragmentInputBinding;
    }

    private final InputAttachmentListModel getInputViewModel() {
        return (InputAttachmentListModel) this.inputViewModel.getValue();
    }

    public final ChatMode getCurrentMode() {
        return this.currentMode;
    }

    public final void setCurrentMode(ChatMode chatMode) {
        Intrinsics.checkNotNullParameter(chatMode, "<set-?>");
        this.currentMode = chatMode;
    }

    public final InputState getCurrentInputState() {
        return this.currentInputState;
    }

    public final void setCurrentInputState(InputState inputState) {
        Intrinsics.checkNotNullParameter(inputState, "<set-?>");
        this.currentInputState = inputState;
    }

    /* renamed from: isNewConversation, reason: from getter */
    public final boolean getIsNewConversation() {
        return this.isNewConversation;
    }

    public final void setNewConversation(boolean z) {
        this.isNewConversation = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String currentInputStateNameForMetrics() {
        String name = this.currentInputState.name();
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = name.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final int getAsrCount() {
        return this.asrCount;
    }

    public final Function0<Unit> getOnPauseClickListener() {
        return this.onPauseClickListener;
    }

    public final void setOnPauseClickListener(Function0<Unit> function0) {
        this.onPauseClickListener = function0;
    }

    public final Function1<String, Unit> getOnSendText() {
        return this.onSendText;
    }

    public final void setOnSendText(Function1<? super String, Unit> function1) {
        this.onSendText = function1;
    }

    public final Function2<String, String, Unit> getOnSendAudioText() {
        return this.onSendAudioText;
    }

    public final void setOnSendAudioText(Function2<? super String, ? super String, Unit> function2) {
        this.onSendAudioText = function2;
    }

    public final Function1<ChatAttachmentDialog.AttachmentType, Unit> getOnAttachmentSelected() {
        return this.onAttachmentSelected;
    }

    public final void setOnAttachmentSelected(Function1<? super ChatAttachmentDialog.AttachmentType, Unit> function1) {
        this.onAttachmentSelected = function1;
    }

    public final Function0<Unit> getOnChatNewClick() {
        return this.onChatNewClick;
    }

    public final void setOnChatNewClick(Function0<Unit> function0) {
        this.onChatNewClick = function0;
    }

    public final Function0<Unit> getOnCloudClick() {
        return this.onCloudClick;
    }

    public final void setOnCloudClick(Function0<Unit> function0) {
        this.onCloudClick = function0;
    }

    public final Function0<Unit> getOnGitHubClick() {
        return this.onGitHubClick;
    }

    public final void setOnGitHubClick(Function0<Unit> function0) {
        this.onGitHubClick = function0;
    }

    public final Function0<Unit> getOnReady() {
        return this.onReady;
    }

    public final void setOnReady(Function0<Unit> function0) {
        this.onReady = function0;
    }

    public final Function1<List<MediaItem>, Unit> getOnImageSelected() {
        return this.onImageSelected;
    }

    public final void setOnImageSelected(Function1<? super List<MediaItem>, Unit> function1) {
        this.onImageSelected = function1;
    }

    public final Function1<Uri, Unit> getOnFileSelected() {
        return this.onFileSelected;
    }

    public final void setOnFileSelected(Function1<? super Uri, Unit> function1) {
        this.onFileSelected = function1;
    }

    public final Function1<ChatMode, Unit> getOnSwitchMode() {
        return this.onSwitchMode;
    }

    public final void setOnSwitchMode(Function1<? super ChatMode, Unit> function1) {
        this.onSwitchMode = function1;
    }

    public final Function1<Boolean, Unit> getOnRecordingStateChanged() {
        return this.onRecordingStateChanged;
    }

    public final void setOnRecordingStateChanged(Function1<? super Boolean, Unit> function1) {
        this.onRecordingStateChanged = function1;
    }

    public final Function1<String, Unit> getOnTemplateClick() {
        return this.onTemplateClick;
    }

    public final void setOnTemplateClick(Function1<? super String, Unit> function1) {
        this.onTemplateClick = function1;
    }

    public final Function0<Unit> getOnDeviceClick() {
        return this.onDeviceClick;
    }

    public final void setOnDeviceClick(Function0<Unit> function0) {
        this.onDeviceClick = function0;
    }

    public final Function1<SelectedDeviceItem, Unit> getOnSelectedDeviceChanged() {
        return this.onSelectedDeviceChanged;
    }

    public final void setOnSelectedDeviceChanged(Function1<? super SelectedDeviceItem, Unit> function1) {
        this.onSelectedDeviceChanged = function1;
    }

    public final Function1<Function1<? super SelectedDeviceItem, Unit>, Unit> getOnRequestSkillProjectCheck() {
        return this.onRequestSkillProjectCheck;
    }

    public final void setOnRequestSkillProjectCheck(Function1<? super Function1<? super SelectedDeviceItem, Unit>, Unit> function1) {
        this.onRequestSkillProjectCheck = function1;
    }

    public final Function0<Unit> getOnAuthFailed() {
        return this.onAuthFailed;
    }

    public final void setOnAuthFailed(Function0<Unit> function0) {
        this.onAuthFailed = function0;
    }

    public final Function0<Unit> getOnInputFocus() {
        return this.onInputFocus;
    }

    public final void setOnInputFocus(Function0<Unit> function0) {
        this.onInputFocus = function0;
    }

    public final Function0<Boolean> isTaskRunning() {
        return this.isTaskRunning;
    }

    public final void setTaskRunning(Function0<Boolean> function0) {
        this.isTaskRunning = function0;
    }

    public final VoiceRecordingOverlay getVoiceRecordingOverlay() {
        return this.voiceRecordingOverlay;
    }

    public final void setVoiceRecordingOverlay(VoiceRecordingOverlay voiceRecordingOverlay) {
        this.voiceRecordingOverlay = voiceRecordingOverlay;
    }

    public final int consumeAsrCount() {
        int i = this.asrCount;
        this.asrCount = 0;
        return i;
    }

    /* compiled from: InputFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/widget/InputFragment$InputPayload;", "", "query", "", "plugins", "", "Lcom/bytedance/trae/conversation/widget/PluginTagItem;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getQuery", "()Ljava/lang/String;", "getPlugins", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class InputPayload {
        private final List<PluginTagItem> plugins;
        private final String query;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InputPayload copy$default(InputPayload inputPayload, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = inputPayload.query;
            }
            if ((i & 2) != 0) {
                list = inputPayload.plugins;
            }
            return inputPayload.copy(str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        public final List<PluginTagItem> component2() {
            return this.plugins;
        }

        public final InputPayload copy(String query, List<PluginTagItem> plugins) {
            Intrinsics.checkNotNullParameter(query, "query");
            Intrinsics.checkNotNullParameter(plugins, "plugins");
            return new InputPayload(query, plugins);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InputPayload)) {
                return false;
            }
            InputPayload inputPayload = (InputPayload) other;
            return Intrinsics.areEqual(this.query, inputPayload.query) && Intrinsics.areEqual(this.plugins, inputPayload.plugins);
        }

        public int hashCode() {
            return (this.query.hashCode() * 31) + this.plugins.hashCode();
        }

        public String toString() {
            return "InputPayload(query=" + this.query + ", plugins=" + this.plugins + ')';
        }

        public InputPayload(String str, List<PluginTagItem> list) {
            Intrinsics.checkNotNullParameter(str, "query");
            Intrinsics.checkNotNullParameter(list, "plugins");
            this.query = str;
            this.plugins = list;
        }

        public final String getQuery() {
            return this.query;
        }

        public final List<PluginTagItem> getPlugins() {
            return this.plugins;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void remainingChangedListener$lambda$2(final InputFragment inputFragment, final long j, final long j2, final boolean z) {
        FragmentActivity activity = inputFragment.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    InputFragment.remainingChangedListener$lambda$2$lambda$1(InputFragment.this, z, j2, j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void remainingChangedListener$lambda$2$lambda$1(InputFragment inputFragment, boolean z, long j, long j2) {
        boolean z2;
        try {
            if (inputFragment._binding == null) {
                return;
            }
            if (TocCreditsPolicy.INSTANCE.isEnabled()) {
                inputFragment.isExpressPassVisible = false;
                inputFragment.getBinding().btnExpressPass.setVisibility(8);
                return;
            }
            inputFragment.infinite = z;
            FLog.d("ExpressPassBenefitManager", "runOnUiThread:" + inputFragment.infinite + ' ' + j + ' ' + j2);
            if (!inputFragment.infinite && j <= 0) {
                z2 = false;
                inputFragment.showExpressPassBtn(z2);
                if (z2 && inputFragment.deviceTipsPopWindow == null && !ExpressPassBenefitManager.INSTANCE.getKeva().getBoolean(ExpressPassBenefitManager.KEY_EXPRESS_PASS_SWITCH_TIPS, false)) {
                    ExpressPassBenefitManager.INSTANCE.getKeva().storeBoolean(ExpressPassBenefitManager.KEY_EXPRESS_PASS_SWITCH_TIPS, true);
                    inputFragment.showExpressPassPopWindow();
                }
                FLog.d("ExpressPassBenefitManager", "runOnUiThread:" + z2 + ' ' + inputFragment.infinite + ' ' + ExpressPassBenefitManager.INSTANCE.getNotifyCount());
                if (!z2 && !inputFragment.infinite && j < ExpressPassBenefitManager.INSTANCE.getNotifyCount()) {
                    long j3 = AccountSettingsKeva.INSTANCE.getKeva().getLong(ExpressPassBenefitManager.KEY_EXPRESS_PASS_BENEFIT_CLOSE_TIME, 0L);
                    if (j3 != 0 && System.currentTimeMillis() - j3 <= ExpressPassBenefitManager.INSTANCE.getNotifyInterval()) {
                        inputFragment.getBinding().llExpressPassBenefit.setVisibility(8);
                        return;
                    }
                    Context context = inputFragment.getContext();
                    if (context != null) {
                        TextView textView = inputFragment.getBinding().tvExpressPassBenefit;
                        I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
                        Resources resources = context.getResources();
                        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                        textView.setText(i18nTextProvider.getString(resources, R.string.imkit_fast_pass_remaining, new Object[]{Long.valueOf(j)}));
                    }
                    inputFragment.getBinding().llExpressPassBenefit.setVisibility(0);
                    return;
                }
                inputFragment.getBinding().llExpressPassBenefit.setVisibility(8);
            }
            z2 = true;
            inputFragment.showExpressPassBtn(z2);
            if (z2) {
                ExpressPassBenefitManager.INSTANCE.getKeva().storeBoolean(ExpressPassBenefitManager.KEY_EXPRESS_PASS_SWITCH_TIPS, true);
                inputFragment.showExpressPassPopWindow();
            }
            FLog.d("ExpressPassBenefitManager", "runOnUiThread:" + z2 + ' ' + inputFragment.infinite + ' ' + ExpressPassBenefitManager.INSTANCE.getNotifyCount());
            if (!z2) {
            }
            inputFragment.getBinding().llExpressPassBenefit.setVisibility(8);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void inputKeyboardLayoutListener$lambda$3(InputFragment inputFragment) {
        TranscriptEditText transcriptEditText;
        TranscriptEditText transcriptEditText2;
        View view = inputFragment.getView();
        if (view == null) {
            return;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int height = view.getRootView().getHeight();
        int i = height - rect.bottom;
        boolean z = inputFragment.isKeyboardVisible;
        boolean z2 = ((double) i) > ((double) height) * 0.15d;
        inputFragment.isKeyboardVisible = z2;
        if (z2 != z) {
            if (z2) {
                TraeFragmentInputBinding traeFragmentInputBinding = inputFragment._binding;
                if (traeFragmentInputBinding == null || (transcriptEditText2 = traeFragmentInputBinding.etInput) == null) {
                    return;
                }
                transcriptEditText2.setHint(inputFragment.getString(R.string.trae_input_hint_keyboard));
                return;
            }
            TraeFragmentInputBinding traeFragmentInputBinding2 = inputFragment._binding;
            if (traeFragmentInputBinding2 == null || (transcriptEditText = traeFragmentInputBinding2.etInput) == null) {
                return;
            }
            transcriptEditText.setHint(inputFragment.getString(R.string.trae_input_hint));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void keyboardLayoutListener$lambda$4(InputFragment inputFragment) {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        View view = inputFragment.getView();
        if (view == null) {
            return;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int height = view.getRootView().getHeight();
        int i = height - rect.bottom;
        boolean z = inputFragment.isKeyboardVisibleForTemplates;
        boolean z2 = ((double) i) > ((double) height) * 0.15d;
        inputFragment.isKeyboardVisibleForTemplates = z2;
        if (z2 != z) {
            if (z2) {
                RecyclerView recyclerView2 = inputFragment.taskTemplatesRecyclerView;
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(8);
                    return;
                }
                return;
            }
            if (inputFragment.isNewConversation) {
                SelectedDeviceItem selectedDeviceItem = inputFragment.currentDevice;
                if ((selectedDeviceItem != null ? selectedDeviceItem.getType() : null) != CliType.IDE) {
                    RecyclerView recyclerView3 = inputFragment.taskTemplatesRecyclerView;
                    if (((recyclerView3 == null || (adapter = recyclerView3.getAdapter()) == null) ? 0 : adapter.getItemCount()) <= 0 || (recyclerView = inputFragment.taskTemplatesRecyclerView) == null) {
                        return;
                    }
                    recyclerView.setVisibility(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cameraPermissionLauncher$lambda$5(InputFragment inputFragment, Boolean bool) {
        if (!bool.booleanValue()) {
            Toast.makeText(inputFragment.requireContext(), R.string.trae_media_choose_camera_permission_denied, 0).show();
        } else {
            inputFragment.openCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void takePictureLauncher$lambda$7(InputFragment inputFragment, Boolean bool) {
        Uri uri = inputFragment.pendingCameraUri;
        inputFragment.pendingCameraUri = null;
        if (!bool.booleanValue() || uri == null) {
            if (uri != null) {
                try {
                    inputFragment.requireContext().getContentResolver().delete(uri, null, null);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        if (inputFragment.currentMode == ChatMode.CODE) {
            MediaStoreRepository.Companion companion = MediaStoreRepository.INSTANCE;
            Context requireContext = inputFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            MediaItem queryMediaItem = companion.queryMediaItem(requireContext, uri);
            if (queryMediaItem != null) {
                inputFragment.getInputViewModel().addImages(CollectionsKt.listOf(queryMediaItem));
                return;
            }
            return;
        }
        InputAttachmentListModel inputViewModel = inputFragment.getInputViewModel();
        Context applicationContext = inputFragment.requireContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        inputViewModel.addAttachment(uri, applicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mediaChooseLauncher$lambda$8(InputFragment inputFragment, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            ArrayList parcelableArrayListExtra = data != null ? data.getParcelableArrayListExtra(MediaChooseContract.RESULT_SELECTED) : null;
            ArrayList arrayList = parcelableArrayListExtra;
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            if (inputFragment.currentMode == ChatMode.CODE) {
                inputFragment.getInputViewModel().addImages(parcelableArrayListExtra);
            } else {
                FLogger.INSTANCE.e(inputFragment.TAG, "mediaChooseLauncher:" + parcelableArrayListExtra.size());
                inputFragment.getInputViewModel().addImageAttachments(parcelableArrayListExtra);
            }
            Function1<? super List<MediaItem>, Unit> function1 = inputFragment.onImageSelected;
            if (function1 != null) {
                function1.invoke(parcelableArrayListExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filePickerLauncher$lambda$11(InputFragment inputFragment, List list) {
        Function1<? super Uri, Unit> function1;
        Intrinsics.checkNotNullParameter(list, "uris");
        if (list.isEmpty()) {
            return;
        }
        Context applicationContext = inputFragment.requireContext().getApplicationContext();
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (inputFragment.getInputViewModel().isCanAddAttachment()) {
                InputAttachmentListModel inputViewModel = inputFragment.getInputViewModel();
                Intrinsics.checkNotNull(applicationContext);
                inputViewModel.addAttachment(uri, applicationContext);
            } else {
                i++;
            }
        }
        if (i > 0) {
            Toast.makeText(applicationContext, inputFragment.getString(R.string.trae_attachment_count_limit, new Object[]{Long.valueOf(inputFragment.getInputViewModel().getWorkAttachmentTotalCount())}), 0).show();
        }
        Uri uri2 = (Uri) CollectionsKt.firstOrNull(list);
        if (uri2 == null || (function1 = inputFragment.onFileSelected) == null) {
            return;
        }
        function1.invoke(uri2);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = TraeFragmentInputBinding.inflate(inflater, container, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setMinimizedVoiceMode(boolean active) {
        if (this._binding == null) {
            return;
        }
        getBinding().fullInputContainer.setVisibility(active ? 8 : 0);
        getBinding().minimizedVoiceBar.setVisibility(active ? 0 : 8);
        if (active) {
            MinimizedVoiceBar minimizedVoiceBar = getBinding().minimizedVoiceBar;
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            minimizedVoiceBar.bindHolder(viewLifecycleOwner);
            getBinding().minimizedVoiceBar.setOnMaximizeClick(this.onMaximizeBrainstormClick);
            return;
        }
        getBinding().minimizedVoiceBar.unbind();
        getBinding().minimizedVoiceBar.setOnMaximizeClick(null);
    }

    public final Function0<Unit> getOnMaximizeBrainstormClick() {
        return this.onMaximizeBrainstormClick;
    }

    public final void setOnMaximizeBrainstormClick(Function0<Unit> function0) {
        this.onMaximizeBrainstormClick = function0;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.voiceChatSessionManager = new TranscriptionVoiceManager(null, 1, null);
        ViewModelStoreOwner requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.gitViewModel = (GitSelectionViewModel) new ViewModelProvider(requireActivity).get(GitSelectionViewModel.class);
        setMode(this.currentMode);
        setInputState(InputState.Empty);
        setupAttachmentsRecyclerView();
        getBinding().etInput.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda55
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view2, int i, int i2, int i3, int i4) {
                InputFragment.onViewCreated$lambda$12(view2, i, i2, i3, i4);
            }
        });
        setupInputWatcher();
        setupGitObservers();
        setupClickListeners();
        getBinding().etInput.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda56
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z) {
                InputFragment.onViewCreated$lambda$13(InputFragment.this, view2, z);
            }
        });
        updateRepoIconForLoginPlatform();
        updateBranchEnabled(false);
        setupFileTooLargeObserver();
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.inputKeyboardLayoutListener);
        setupExpressPassBenefit();
        Function0<Unit> function0 = this.onReady;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$12(View view, int i, int i2, int i3, int i4) {
        ViewParent parent = view.getParent();
        if (parent != null) {
            boolean z = true;
            if (!view.canScrollVertically(1) && !view.canScrollVertically(-1)) {
                z = false;
            }
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$13(InputFragment inputFragment, View view, boolean z) {
        Function0<Unit> function0;
        if (!z || (function0 = inputFragment.onInputFocus) == null) {
            return;
        }
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetInputBar() {
        getBinding().inputBottom.setVisibility(0);
        if (getBinding().bottomContextualBar.getVisibility() == 0) {
            FrameLayout frameLayout = getBinding().bottomContextualBar;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "bottomContextualBar");
            setViewGroupEnabled(frameLayout, true);
            getBinding().bottomContextualBar.setAlpha(1.0f);
        }
        if (getBinding().llDeviceFolderBar.getVisibility() == 0) {
            LinearLayout linearLayout = getBinding().llDeviceFolderBar;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "llDeviceFolderBar");
            setViewGroupEnabled(linearLayout, true);
            getBinding().llDeviceFolderBar.setAlpha(1.0f);
        }
        Function1<? super Boolean, Unit> function1 = this.onRecordingStateChanged;
        if (function1 != null) {
            function1.invoke(false);
        }
    }

    private final void setupFileTooLargeObserver() {
        long j = 1024;
        final String str = ((getInputViewModel().getSingleSize() / j) / j) + "MB";
        getInputViewModel().getFileTooLarge().observe(getViewLifecycleOwner(), new InputFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupFileTooLargeObserver$lambda$14(InputFragment.this, str, (Unit) obj);
                return unit;
            }
        }));
        final String str2 = ((getInputViewModel().getWorkAttachmentTotalSize() / j) / j) + "MB";
        getInputViewModel().getTotalSizeTooLarge().observe(getViewLifecycleOwner(), new InputFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupFileTooLargeObserver$lambda$15(InputFragment.this, str2, (Unit) obj);
                return unit;
            }
        }));
        getInputViewModel().getUploadError().observe(getViewLifecycleOwner(), new InputFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda33
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupFileTooLargeObserver$lambda$16(InputFragment.this, (String) obj);
                return unit;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupFileTooLargeObserver$lambda$14(InputFragment inputFragment, String str, Unit unit) {
        Toast.makeText(inputFragment.requireContext(), inputFragment.requireContext().getString(R.string.trae_file_too_large_message, str), 1).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupFileTooLargeObserver$lambda$15(InputFragment inputFragment, String str, Unit unit) {
        Toast.makeText(inputFragment.requireContext(), inputFragment.requireContext().getString(R.string.trae_total_size_too_large_message, str), 1).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupFileTooLargeObserver$lambda$16(InputFragment inputFragment, String str) {
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            Toast.makeText(inputFragment.requireContext(), str2, 1).show();
        }
        return Unit.INSTANCE;
    }

    private final void showExpressPassBtn(boolean show) {
        if (TocCreditsPolicy.INSTANCE.isEnabled()) {
            this.isExpressPassVisible = false;
            getBinding().btnExpressPass.setVisibility(8);
            return;
        }
        this.isExpressPassVisible = show;
        if (show) {
            getBinding().btnExpressPass.setVisibility(0);
            if (this.infinite) {
                getBinding().btnExpressPass.setImageResource(C0637R.drawable.ic_input_bar_express_999);
                return;
            } else if (ExpressPassBenefitManager.INSTANCE.isOpenAutoUseExpressPass()) {
                getBinding().btnExpressPass.setImageResource(C0637R.drawable.ic_input_bar_use_express_pass);
                return;
            } else {
                getBinding().btnExpressPass.setImageResource(C0637R.drawable.ic_input_bar_no_use_express_pass);
                return;
            }
        }
        getBinding().btnExpressPass.setVisibility(8);
    }

    private final void setupExpressPassBenefit() {
        if (TocCreditsPolicy.INSTANCE.isEnabled()) {
            getBinding().btnExpressPass.setVisibility(8);
            getBinding().llExpressPassBenefit.setVisibility(8);
            return;
        }
        getBinding().ivExpressPassBenefitClose.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputFragment.setupExpressPassBenefit$lambda$17(InputFragment.this, view);
            }
        });
        if (AppHost.INSTANCE.isOversea() || LoginUtils.INSTANCE.shouldSkipTocCommercialFeatures()) {
            return;
        }
        ExpressPassBenefitManager.INSTANCE.addRemainingChangedListener(this.remainingChangedListener);
        ExpressPassBenefitManager.INSTANCE.addBenefitSwitchListener(this.benefitSwitchListener);
        ExpressPassBenefitManager.INSTANCE.fetchUserPayIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupExpressPassBenefit$lambda$17(InputFragment inputFragment, View view) {
        inputFragment.getBinding().llExpressPassBenefit.setVisibility(8);
        AccountSettingsKeva.INSTANCE.getKeva().storeLong(ExpressPassBenefitManager.KEY_EXPRESS_PASS_BENEFIT_CLOSE_TIME, System.currentTimeMillis());
    }

    private final void setupAttachmentsRecyclerView() {
        final RecyclerView.Adapter inputAttachmentAdapter = new InputAttachmentAdapter(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupAttachmentsRecyclerView$lambda$18(InputFragment.this, (AttachmentItem) obj);
                return unit;
            }
        }, new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupAttachmentsRecyclerView$lambda$19(InputFragment.this, (AttachmentItem) obj);
                return unit;
            }
        });
        getBinding().rvAttachments.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        getBinding().rvAttachments.setAdapter(inputAttachmentAdapter);
        getInputViewModel().getAttachments().observe(getViewLifecycleOwner(), new InputFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupAttachmentsRecyclerView$lambda$20(InputAttachmentAdapter.this, this, (List) obj);
                return unit;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupAttachmentsRecyclerView$lambda$18(InputFragment inputFragment, AttachmentItem attachmentItem) {
        Intrinsics.checkNotNullParameter(attachmentItem, "item");
        inputFragment.getInputViewModel().removeAttachment(attachmentItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupAttachmentsRecyclerView$lambda$19(InputFragment inputFragment, AttachmentItem attachmentItem) {
        Intrinsics.checkNotNullParameter(attachmentItem, "item");
        inputFragment.getInputViewModel().retryUpload(attachmentItem, inputFragment.currentMode);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupAttachmentsRecyclerView$lambda$20(InputAttachmentAdapter inputAttachmentAdapter, InputFragment inputFragment, List list) {
        inputAttachmentAdapter.submitList(list);
        inputFragment.getBinding().rvAttachments.setVisibility(list.isEmpty() ? 8 : 0);
        return Unit.INSTANCE;
    }

    private final void setupInputWatcher() {
        getBinding().etInput.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.conversation.widget.InputFragment$setupInputWatcher$1

            /* compiled from: InputFragment.kt */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[InputFragment.InputState.values().length];
                    try {
                        iArr[InputFragment.InputState.Empty.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[InputFragment.InputState.Input.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[InputFragment.InputState.Sending.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[InputFragment.InputState.Sended.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[InputFragment.InputState.Stopped.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0086 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00ae  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x00cb  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x0092  */
            @Override // android.text.TextWatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void afterTextChanged(Editable s) {
                boolean z;
                TraeFragmentInputBinding binding;
                boolean z2;
                TraeFragmentInputBinding binding2;
                TraeFragmentInputBinding binding3;
                TraeFragmentInputBinding binding4;
                TraeFragmentInputBinding binding5;
                TraeFragmentInputBinding binding6;
                InputFragment.HoldToTalkState holdToTalkState;
                InputFragment.HoldToTalkState holdToTalkState2;
                int i;
                TraeFragmentInputBinding binding7;
                boolean hasUploadedAttachments;
                if (s != null) {
                    if (s.length() > 0) {
                        z = true;
                        binding = InputFragment.this.getBinding();
                        boolean hasInputTag = binding.etInput.hasInputTag();
                        if (!z) {
                            hasUploadedAttachments = InputFragment.this.hasUploadedAttachments();
                            if (!hasUploadedAttachments && !hasInputTag) {
                                z2 = false;
                                binding2 = InputFragment.this.getBinding();
                                binding2.btnSendText.setEnabled(z2);
                                binding3 = InputFragment.this.getBinding();
                                binding3.btnSendText.setClickable(z2);
                                binding4 = InputFragment.this.getBinding();
                                binding4.btnMicrophone.setEnabled(true);
                                binding5 = InputFragment.this.getBinding();
                                binding5.btnMicrophone.setClickable(true);
                                binding6 = InputFragment.this.getBinding();
                                binding6.btnMicrophone.setAlpha(1.0f);
                                holdToTalkState = InputFragment.this.holdToTalkState;
                                if (holdToTalkState == InputFragment.HoldToTalkState.Normal) {
                                    binding7 = InputFragment.this.getBinding();
                                    binding7.btnMicrophone.setVisibility((z || hasInputTag) ? 8 : 0);
                                }
                                if (!z || hasInputTag) {
                                    holdToTalkState2 = InputFragment.this.holdToTalkState;
                                    if (holdToTalkState2 == InputFragment.HoldToTalkState.HOLD) {
                                        InputFragment.this.holdToTalkState = InputFragment.HoldToTalkState.Normal;
                                        InputFragment.this.updateHoldToTalkUI();
                                    }
                                }
                                i = WhenMappings.$EnumSwitchMapping$0[InputFragment.this.getCurrentInputState().ordinal()];
                                if (i == 1) {
                                    if (z2) {
                                        InputFragment.this.setInputState(InputFragment.InputState.Input);
                                        return;
                                    }
                                    return;
                                } else if (i == 2) {
                                    if (z2) {
                                        return;
                                    }
                                    InputFragment.this.setInputState(InputFragment.InputState.Empty);
                                    return;
                                } else {
                                    if (i != 3 && i != 4 && i != 5) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    return;
                                }
                            }
                        }
                        z2 = true;
                        binding2 = InputFragment.this.getBinding();
                        binding2.btnSendText.setEnabled(z2);
                        binding3 = InputFragment.this.getBinding();
                        binding3.btnSendText.setClickable(z2);
                        binding4 = InputFragment.this.getBinding();
                        binding4.btnMicrophone.setEnabled(true);
                        binding5 = InputFragment.this.getBinding();
                        binding5.btnMicrophone.setClickable(true);
                        binding6 = InputFragment.this.getBinding();
                        binding6.btnMicrophone.setAlpha(1.0f);
                        holdToTalkState = InputFragment.this.holdToTalkState;
                        if (holdToTalkState == InputFragment.HoldToTalkState.Normal) {
                        }
                        if (!z) {
                        }
                        holdToTalkState2 = InputFragment.this.holdToTalkState;
                        if (holdToTalkState2 == InputFragment.HoldToTalkState.HOLD) {
                        }
                        i = WhenMappings.$EnumSwitchMapping$0[InputFragment.this.getCurrentInputState().ordinal()];
                        if (i == 1) {
                        }
                    }
                }
                z = false;
                binding = InputFragment.this.getBinding();
                boolean hasInputTag2 = binding.etInput.hasInputTag();
                if (!z) {
                }
                z2 = true;
                binding2 = InputFragment.this.getBinding();
                binding2.btnSendText.setEnabled(z2);
                binding3 = InputFragment.this.getBinding();
                binding3.btnSendText.setClickable(z2);
                binding4 = InputFragment.this.getBinding();
                binding4.btnMicrophone.setEnabled(true);
                binding5 = InputFragment.this.getBinding();
                binding5.btnMicrophone.setClickable(true);
                binding6 = InputFragment.this.getBinding();
                binding6.btnMicrophone.setAlpha(1.0f);
                holdToTalkState = InputFragment.this.holdToTalkState;
                if (holdToTalkState == InputFragment.HoldToTalkState.Normal) {
                }
                if (!z) {
                }
                holdToTalkState2 = InputFragment.this.holdToTalkState;
                if (holdToTalkState2 == InputFragment.HoldToTalkState.HOLD) {
                }
                i = WhenMappings.$EnumSwitchMapping$0[InputFragment.this.getCurrentInputState().ordinal()];
                if (i == 1) {
                }
            }
        });
        getInputViewModel().getAttachments().observe(getViewLifecycleOwner(), new InputFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupInputWatcher$lambda$21(InputFragment.this, (List) obj);
                return unit;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupInputWatcher$lambda$21(InputFragment inputFragment, List list) {
        if (inputFragment.currentInputState == InputState.Sending || inputFragment.currentInputState == InputState.Sended || inputFragment.currentInputState == InputState.Stopped) {
            return Unit.INSTANCE;
        }
        boolean canSend = inputFragment.canSend();
        inputFragment.getBinding().btnSendText.setEnabled(canSend);
        inputFragment.getBinding().btnSendText.setClickable(canSend);
        if (canSend) {
            inputFragment.setInputState(InputState.Input);
        } else if (!inputFragment.hasInputMessage()) {
            inputFragment.setInputState(InputState.Empty);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateHoldToTalkUI() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.holdToTalkState.ordinal()];
        boolean z = true;
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            getBinding().btnHoldToTalk.setVisibility(0);
            getBinding().btnMicrophone.setVisibility(8);
            getBinding().tvHoldToTalk.setVisibility(0);
            getBinding().etInput.setVisibility(8);
            getBinding().modelSelector.setVisibility(8);
            getBinding().btnExpressPass.setVisibility(8);
            return;
        }
        getBinding().btnHoldToTalk.setVisibility(8);
        if (!hasInputMessage() && !getBinding().etInput.hasInputTag()) {
            z = false;
        }
        getBinding().btnMicrophone.setVisibility(z ? 8 : 0);
        getBinding().tvHoldToTalk.setVisibility(8);
        getBinding().etInput.setVisibility(0);
        updateModelSelectorVisibility();
        if (!TocCreditsPolicy.INSTANCE.isEnabled() && this.isExpressPassVisible) {
            getBinding().btnExpressPass.setVisibility(0);
        } else {
            getBinding().btnExpressPass.setVisibility(8);
        }
    }

    private final void setupGitObservers() {
        GitSelectionViewModel gitSelectionViewModel = this.gitViewModel;
        GitSelectionViewModel gitSelectionViewModel2 = null;
        if (gitSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel = null;
        }
        gitSelectionViewModel.getGitConnectionState().observe(getViewLifecycleOwner(), new InputFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda51
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupGitObservers$lambda$22(InputFragment.this, (GitConnectionState) obj);
                return unit;
            }
        }));
        GitSelectionViewModel gitSelectionViewModel3 = this.gitViewModel;
        if (gitSelectionViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel3 = null;
        }
        gitSelectionViewModel3.getSelectedRepo().observe(getViewLifecycleOwner(), new InputFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda52
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupGitObservers$lambda$23(InputFragment.this, (GitRepoItem) obj);
                return unit;
            }
        }));
        GitSelectionViewModel gitSelectionViewModel4 = this.gitViewModel;
        if (gitSelectionViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
        } else {
            gitSelectionViewModel2 = gitSelectionViewModel4;
        }
        gitSelectionViewModel2.getSelectedBranch().observe(getViewLifecycleOwner(), new InputFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda53
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupGitObservers$lambda$24(InputFragment.this, (BranchItem) obj);
                return unit;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        if (android.text.TextUtils.isEmpty(r15 != null ? r15.getId() : null) != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0070 A[Catch: all -> 0x00c6, TryCatch #0 {all -> 0x00c6, blocks: (B:8:0x001b, B:11:0x0022, B:12:0x0026, B:14:0x0030, B:16:0x0034, B:17:0x0038, B:19:0x0044, B:20:0x004a, B:23:0x0052, B:25:0x0064, B:30:0x0070, B:32:0x00ab, B:33:0x00b0, B:35:0x00b4), top: B:7:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4 A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #0 {all -> 0x00c6, blocks: (B:8:0x001b, B:11:0x0022, B:12:0x0026, B:14:0x0030, B:16:0x0034, B:17:0x0038, B:19:0x0044, B:20:0x004a, B:23:0x0052, B:25:0x0064, B:30:0x0070, B:32:0x00ab, B:33:0x00b0, B:35:0x00b4), top: B:7:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit setupGitObservers$lambda$22(InputFragment inputFragment, GitConnectionState gitConnectionState) {
        boolean z;
        if (gitConnectionState == GitConnectionState.DISCONNECTED) {
            inputFragment.getBinding().tvRepoName.setText(inputFragment.getString(R.string.trae_connect_github));
        } else {
            try {
                GitSelectionViewModel gitSelectionViewModel = inputFragment.gitViewModel;
                GitSelectionViewModel gitSelectionViewModel2 = null;
                if (gitSelectionViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                    gitSelectionViewModel = null;
                }
                if (gitSelectionViewModel.getSelectedRepo().getValue() != null) {
                    GitSelectionViewModel gitSelectionViewModel3 = inputFragment.gitViewModel;
                    if (gitSelectionViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                        gitSelectionViewModel3 = null;
                    }
                    GitRepoItem gitRepoItem = (GitRepoItem) gitSelectionViewModel3.getSelectedRepo().getValue();
                }
                String string = AccountSettingsKeva.INSTANCE.getKeva().getString(GitSelectionViewModel.KEY_SELECTED_REPO, "");
                String str = string;
                if (str != null && str.length() != 0) {
                    z = false;
                    if (z) {
                        JSONObject jSONObject = new JSONObject(string);
                        String optString = jSONObject.optString("id", "");
                        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                        String optString2 = jSONObject.optString("title", "");
                        Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
                        String optString3 = jSONObject.optString("subtitle", "");
                        Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
                        String optString4 = jSONObject.optString("repoUrl", "");
                        Intrinsics.checkNotNullExpressionValue(optString4, "optString(...)");
                        GitRepoItem gitRepoItem2 = new GitRepoItem(optString, optString2, optString3, optString4, false, false, 48, null);
                        GitSelectionViewModel gitSelectionViewModel4 = inputFragment.gitViewModel;
                        if (gitSelectionViewModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                        } else {
                            gitSelectionViewModel2 = gitSelectionViewModel4;
                        }
                        gitSelectionViewModel2.updateSelectRepo(gitRepoItem2);
                    } else {
                        inputFragment.getBinding().tvRepoName.setText(inputFragment.getString(R.string.trae_input_select_repo));
                    }
                }
                z = true;
                if (z) {
                }
            } catch (Throwable unused) {
                inputFragment.getBinding().tvRepoName.setText(inputFragment.getString(R.string.trae_input_select_repo));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupGitObservers$lambda$23(InputFragment inputFragment, GitRepoItem gitRepoItem) {
        if (gitRepoItem != null) {
            inputFragment.getBinding().tvRepoName.setText(gitRepoItem.getSubtitle());
            inputFragment.getBinding().tvRepoName.setTextColor(ContextCompat.getColor(inputFragment.requireContext(), C0591R.color.trae_text_text_default));
            inputFragment.updateBranchEnabled(true);
            inputFragment.updateGithubEnabled(true);
        } else {
            inputFragment.getBinding().tvRepoName.setText(inputFragment.getString(R.string.trae_input_select_repo));
            inputFragment.getBinding().tvRepoName.setTextColor(ContextCompat.getColor(inputFragment.requireContext(), C0591R.color.trae_text_text_default));
            inputFragment.updateGithubEnabled(true);
            inputFragment.updateBranchEnabled(false);
        }
        inputFragment.updateBranchColor();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupGitObservers$lambda$24(InputFragment inputFragment, BranchItem branchItem) {
        GitSelectionViewModel gitSelectionViewModel = inputFragment.gitViewModel;
        if (gitSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel = null;
        }
        if (gitSelectionViewModel.getSelectedRepo().getValue() != null) {
            GitSelectionViewModel gitSelectionViewModel2 = inputFragment.gitViewModel;
            if (gitSelectionViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                gitSelectionViewModel2 = null;
            }
            GitRepoItem gitRepoItem = (GitRepoItem) gitSelectionViewModel2.getSelectedRepo().getValue();
            if ((gitRepoItem != null ? gitRepoItem.getRepoUrl() : null) != null && branchItem != null) {
                inputFragment.getBinding().tvBranchName.setText(branchItem.getName());
                inputFragment.getBinding().tvBranchName.setTextColor(ContextCompat.getColor(inputFragment.requireContext(), C0591R.color.trae_text_text_default));
                inputFragment.updateBranchColor();
                return Unit.INSTANCE;
            }
        }
        inputFragment.getBinding().tvBranchName.setText(inputFragment.getString(R.string.trae_input_select_branch));
        GitSelectionViewModel gitSelectionViewModel3 = inputFragment.gitViewModel;
        if (gitSelectionViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel3 = null;
        }
        if (gitSelectionViewModel3.getSelectedRepo().getValue() != null) {
            GitSelectionViewModel gitSelectionViewModel4 = inputFragment.gitViewModel;
            if (gitSelectionViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                gitSelectionViewModel4 = null;
            }
            GitRepoItem gitRepoItem2 = (GitRepoItem) gitSelectionViewModel4.getSelectedRepo().getValue();
            if ((gitRepoItem2 != null ? gitRepoItem2.getRepoUrl() : null) != null) {
                inputFragment.updateBranchEnabled(true);
                inputFragment.updateBranchColor();
                return Unit.INSTANCE;
            }
        }
        inputFragment.updateBranchEnabled(false);
        inputFragment.updateBranchColor();
        return Unit.INSTANCE;
    }

    public final void send() {
        Editable text = getBinding().etInput.getText();
        String obj = text != null ? text.toString() : null;
        if (obj == null) {
            obj = "";
        }
        List list = (List) getInputViewModel().getAttachments().getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (!list.isEmpty()) {
            if (hasUploadingAttachments()) {
                Toast.makeText(requireContext(), getString(R.string.trae_attachment_uploading), 0).show();
                return;
            } else if (hasFailedAttachments()) {
                Toast.makeText(requireContext(), getString(R.string.trae_attachment_upload_failed), 0).show();
                return;
            }
        }
        if ((obj.length() > 0) || hasUploadedAttachments() || getBinding().etInput.hasInputTag()) {
            hideKeyboard();
            setSendingState(true);
            Function1<? super String, Unit> function1 = this.onSendText;
            if (function1 != null) {
                function1.invoke(obj);
            }
        }
    }

    private final void setupClickListeners() {
        getBinding().btnSendText.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputFragment.this.send();
            }
        });
        getBinding().btnPause.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputFragment.setupClickListeners$lambda$26(InputFragment.this, view);
            }
        });
        getBinding().btnPlus.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputFragment.setupClickListeners$lambda$35(InputFragment.this, view);
            }
        });
        getBinding().btnExpressPass.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputFragment.setupClickListeners$lambda$38(InputFragment.this, view);
            }
        });
        getBinding().btnChatNew.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputFragment.setupClickListeners$lambda$39(InputFragment.this, view);
            }
        });
        getBinding().btnMicrophone.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputFragment.setupClickListeners$lambda$40(InputFragment.this, view);
            }
        });
        getBinding().btnHoldToTalk.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputFragment.setupClickListeners$lambda$41(InputFragment.this, view);
            }
        });
        getBinding().tvHoldToTalk.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda26
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = InputFragment.setupClickListeners$lambda$42(InputFragment.this, view, motionEvent);
                return z;
            }
        });
        getBinding().btnMicrophone.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda27
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean z;
                z = InputFragment.setupClickListeners$lambda$43(InputFragment.this, view);
                return z;
            }
        });
        getBinding().btnMicrophone.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda28
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = InputFragment.setupClickListeners$lambda$44(InputFragment.this, view, motionEvent);
                return z;
            }
        });
        getBinding().etInput.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean z;
                z = InputFragment.setupClickListeners$lambda$45(InputFragment.this, view);
                return z;
            }
        });
        getBinding().inputBottom.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = InputFragment.setupClickListeners$lambda$48(InputFragment.this, view, motionEvent);
                return z;
            }
        });
        getBinding().etInput.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = InputFragment.setupClickListeners$lambda$49(InputFragment.this, view, motionEvent);
                return z;
            }
        });
        getBinding().llCloudContent.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputFragment.setupClickListeners$lambda$50(InputFragment.this, view);
            }
        });
        getBinding().modelSelector.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputFragment.setupClickListeners$lambda$54(InputFragment.this, view);
            }
        });
        getBinding().btnGithub.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputFragment.setupClickListeners$lambda$58(InputFragment.this, view);
            }
        });
        getBinding().btnBranch.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputFragment.setupClickListeners$lambda$61(InputFragment.this, view);
            }
        });
        getBinding().btnDevice.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputFragment.setupClickListeners$lambda$62(InputFragment.this, view);
            }
        });
        getBinding().btnSelectFolder.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputFragment.setupClickListeners$lambda$63(InputFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$26(InputFragment inputFragment, View view) {
        inputFragment.switchInputState(InputState.Stopped);
        Function0<Unit> function0 = inputFragment.onPauseClickListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$35(final InputFragment inputFragment, View view) {
        SelectedDeviceItem selectedDeviceItem = inputFragment.currentDevice;
        boolean z = (selectedDeviceItem != null ? selectedDeviceItem.getType() : null) == CliType.LOCAL;
        SelectedDeviceItem selectedDeviceItem2 = inputFragment.currentDevice;
        boolean z2 = (selectedDeviceItem2 != null ? selectedDeviceItem2.getType() : null) == CliType.IDE;
        SelectedDeviceItem selectedDeviceItem3 = inputFragment.currentDevice;
        final ChatAttachmentDialog newInstance = ChatAttachmentDialog.INSTANCE.newInstance(inputFragment.currentMode, z, z2, selectedDeviceItem3 != null ? selectedDeviceItem3.getIdeVersion() : null);
        newInstance.setOnAttachmentSelected(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupClickListeners$lambda$35$lambda$34$lambda$33(InputFragment.this, newInstance, (ChatAttachmentDialog.AttachmentType) obj);
                return unit;
            }
        });
        FragmentManager parentFragmentManager = inputFragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
        newInstance.showOnce(parentFragmentManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0219  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit setupClickListeners$lambda$35$lambda$34$lambda$33(final InputFragment inputFragment, ChatAttachmentDialog chatAttachmentDialog, ChatAttachmentDialog.AttachmentType attachmentType) {
        String str;
        SelectedDeviceItem selectedDeviceItem;
        long j;
        long codeImageMaxCount;
        Intrinsics.checkNotNullParameter(attachmentType, DBData.FIELD_TYPE);
        int i = WhenMappings.$EnumSwitchMapping$1[attachmentType.ordinal()];
        if (i == 1) {
            inputFragment.showSkillsForCurrentDevice();
        } else if (i == 2) {
            SelectedDeviceItem selectedDeviceItem2 = inputFragment.currentDevice;
            String str2 = null;
            if (selectedDeviceItem2 != null) {
                if (!(selectedDeviceItem2.getType() == CliType.LOCAL)) {
                    selectedDeviceItem2 = null;
                }
                if (selectedDeviceItem2 != null) {
                    str = selectedDeviceItem2.getId();
                    selectedDeviceItem = inputFragment.currentDevice;
                    if (selectedDeviceItem != null) {
                        if (!(selectedDeviceItem.getType() == CliType.LOCAL)) {
                            selectedDeviceItem = null;
                        }
                        if (selectedDeviceItem != null) {
                            str2 = selectedDeviceItem.getSelectedDirectory();
                        }
                    }
                    PluginsBottomSheet newInstance = PluginsBottomSheet.INSTANCE.newInstance(str, str2);
                    newInstance.setOnPluginSelected(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda57
                        public final Object invoke(Object obj) {
                            Unit unit;
                            unit = InputFragment.setupClickListeners$lambda$35$lambda$34$lambda$33$lambda$29(InputFragment.this, (PluginItem) obj);
                            return unit;
                        }
                    });
                    newInstance.show(chatAttachmentDialog.getParentFragmentManager(), "PluginsBottomSheet");
                }
            }
            str = null;
            selectedDeviceItem = inputFragment.currentDevice;
            if (selectedDeviceItem != null) {
            }
            PluginsBottomSheet newInstance2 = PluginsBottomSheet.INSTANCE.newInstance(str, str2);
            newInstance2.setOnPluginSelected(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda57
                public final Object invoke(Object obj) {
                    Unit unit;
                    unit = InputFragment.setupClickListeners$lambda$35$lambda$34$lambda$33$lambda$29(InputFragment.this, (PluginItem) obj);
                    return unit;
                }
            });
            newInstance2.show(chatAttachmentDialog.getParentFragmentManager(), "PluginsBottomSheet");
        } else if (i != 3) {
            if (i != 4) {
                if (i == 5) {
                    if (inputFragment.currentMode == ChatMode.MTC && !inputFragment.getInputViewModel().isCanAddAttachment()) {
                        Toast.makeText(chatAttachmentDialog.requireContext(), chatAttachmentDialog.getString(R.string.trae_attachment_count_limit, new Object[]{Long.valueOf(inputFragment.getInputViewModel().getWorkAttachmentTotalCount())}), 0).show();
                        return Unit.INSTANCE;
                    }
                    if (ContextCompat.checkSelfPermission(chatAttachmentDialog.requireContext(), "android.permission.CAMERA") != 0) {
                        PermissionRationaleDialog.Companion companion = PermissionRationaleDialog.INSTANCE;
                        Context requireContext = chatAttachmentDialog.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                        companion.showForPermission(requireContext, C0591R.drawable.trae_ic_permission_camera, R.string.trae_permission_camera_title, R.string.trae_permission_camera_message, R.string.trae_permission_allow, R.string.trae_permission_deny, new Function0() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda58
                            public final Object invoke() {
                                Unit unit;
                                unit = InputFragment.setupClickListeners$lambda$35$lambda$34$lambda$33$lambda$32(InputFragment.this);
                                return unit;
                            }
                        }, (r19 & 128) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.PermissionRationaleDialog$Companion$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        } : null);
                    } else {
                        inputFragment.openCamera();
                    }
                } else {
                    Function1<? super ChatAttachmentDialog.AttachmentType, Unit> function1 = inputFragment.onAttachmentSelected;
                    if (function1 != null) {
                        function1.invoke(attachmentType);
                    }
                }
            } else {
                if (!inputFragment.getInputViewModel().isCanAddAttachment()) {
                    Toast.makeText(chatAttachmentDialog.requireContext(), chatAttachmentDialog.getString(R.string.trae_attachment_count_limit, new Object[]{Long.valueOf(inputFragment.getInputViewModel().getWorkAttachmentTotalCount())}), 0).show();
                    return Unit.INSTANCE;
                }
                inputFragment.filePickerLauncher.launch(new String[]{"*/*"});
            }
        } else {
            if (inputFragment.currentMode == ChatMode.MTC && !inputFragment.getInputViewModel().isCanAddAttachment()) {
                Toast.makeText(chatAttachmentDialog.requireContext(), chatAttachmentDialog.getString(R.string.trae_attachment_count_limit, new Object[]{Long.valueOf(inputFragment.getInputViewModel().getWorkAttachmentTotalCount())}), 0).show();
                return Unit.INSTANCE;
            }
            Intent intent = new Intent(chatAttachmentDialog.requireContext(), (Class<?>) MediaChooseActivity.class);
            List<MediaItem> selectedMediaItems = inputFragment.getInputViewModel().getSelectedMediaItems();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = selectedMediaItems.iterator();
            while (true) {
                j = 0;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((MediaItem) next).getId() > 0) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = arrayList2;
            if (true ^ arrayList3.isEmpty()) {
                intent.putParcelableArrayListExtra(MediaChooseContract.EXTRA_INITIAL_SELECTED, new ArrayList<>(arrayList3));
            }
            if (inputFragment.currentMode == ChatMode.MTC) {
                codeImageMaxCount = inputFragment.getInputViewModel().getRemainCount() + arrayList2.size();
            } else {
                codeImageMaxCount = inputFragment.getInputViewModel().getCodeImageMaxCount();
            }
            FLogger.INSTANCE.d(inputFragment.TAG, "PHOTO::" + inputFragment.getInputViewModel().getRemainCount() + ' ' + arrayList2.size());
            intent.putExtra(MediaChooseContract.EXTRA_MAIN_COUNT, codeImageMaxCount);
            if (inputFragment.currentMode == ChatMode.MTC) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    j += ((MediaItem) it2.next()).getSizeBytes();
                }
                intent.putExtra(MediaChooseContract.EXTRA_MAX_SINGLE_SIZE, inputFragment.getInputViewModel().getWorkSingleImageSize());
                intent.putExtra(MediaChooseContract.EXTRA_MAX_TOTAL_SIZE, inputFragment.getInputViewModel().getWorkAttachmentRemainTotalSize() + j);
            } else {
                intent.putExtra(MediaChooseContract.EXTRA_MAX_SINGLE_SIZE, inputFragment.getInputViewModel().getCodeImageSize());
            }
            inputFragment.mediaChooseLauncher.launch(intent);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupClickListeners$lambda$35$lambda$34$lambda$33$lambda$29(InputFragment inputFragment, PluginItem pluginItem) {
        Intrinsics.checkNotNullParameter(pluginItem, "plugin");
        String name = pluginItem.getName();
        String displayName = pluginItem.getDisplayName();
        if (displayName == null) {
            displayName = pluginItem.getName();
        }
        PluginTagItem pluginTagItem = new PluginTagItem(name, displayName, C0637R.drawable.ic_chat_attachment_plugins, pluginItem.getIconUrl());
        inputFragment.holdToTalkState = HoldToTalkState.Normal;
        inputFragment.getBinding().etInput.insertPluginTag(pluginTagItem);
        inputFragment.updateHoldToTalkUI();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupClickListeners$lambda$35$lambda$34$lambda$33$lambda$32(InputFragment inputFragment) {
        inputFragment.cameraPermissionLauncher.launch("android.permission.CAMERA");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$38(InputFragment inputFragment, View view) {
        if (TocCreditsPolicy.INSTANCE.isEnabled()) {
            inputFragment.getBinding().btnExpressPass.setVisibility(8);
            return;
        }
        try {
            if (inputFragment.infinite) {
                inputFragment.getBinding().btnExpressPass.setImageResource(C0637R.drawable.ic_input_bar_express_999);
                inputFragment.showExpressPassToggleTooltip(true);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PageDataManager.EXTRA_STATUS, 1);
                jSONObject.put("identity", 100);
                IApplog.INSTANCE.reportEvent("im_input_flash_icon_click", jSONObject);
                return;
            }
            boolean z = !ExpressPassBenefitManager.INSTANCE.isOpenAutoUseExpressPass();
            ExpressPassBenefitManager.INSTANCE.saveAutoUseExpressPass(z);
            if (z) {
                inputFragment.getBinding().btnExpressPass.setImageResource(C0637R.drawable.ic_input_bar_use_express_pass);
            } else {
                inputFragment.getBinding().btnExpressPass.setImageResource(C0637R.drawable.ic_input_bar_no_use_express_pass);
            }
            inputFragment.showExpressPassToggleTooltip(z);
            JSONObject jSONObject2 = new JSONObject();
            if (z) {
                jSONObject2.put(PageDataManager.EXTRA_STATUS, 1);
            } else {
                jSONObject2.put(PageDataManager.EXTRA_STATUS, 0);
            }
            jSONObject2.put("identity", UserPayIdentityService.getUserPayIdentity());
            IApplog.INSTANCE.reportEvent("im_input_flash_icon_click", jSONObject2);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$39(InputFragment inputFragment, View view) {
        Function0<Unit> function0 = inputFragment.onChatNewClick;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$40(InputFragment inputFragment, View view) {
        if (inputFragment.hasInputMessage()) {
            return;
        }
        InputTracker.INSTANCE.trackVoiceInputClick(inputFragment.isNewConversation ? ConnectComputerGuideFragment.ENTER_FROM_NEW_TASK : "task_detail");
        inputFragment.holdToTalkState = HoldToTalkState.HOLD;
        inputFragment.updateHoldToTalkUI();
        TraeAITracker.INSTANCE.trackAsrRecog(AsrRecogAction.BUTTON_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$41(InputFragment inputFragment, View view) {
        inputFragment.holdToTalkState = HoldToTalkState.Normal;
        inputFragment.updateHoldToTalkUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if (r6 != 3) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean setupClickListeners$lambda$42(InputFragment inputFragment, View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - inputFragment.lastHoldToTalkPressTime < HOLD_TO_TALK_DEBOUNCE_MS) {
                return true;
            }
            inputFragment.lastHoldToTalkPressTime = currentTimeMillis;
            inputFragment.startLongPressRecording();
        } else {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (inputFragment.isLongPressRecording) {
                        Intrinsics.checkNotNull(motionEvent);
                        inputFragment.handleLongPressTouch(motionEvent);
                    }
                }
            }
            if (inputFragment.isLongPressRecording) {
                Intrinsics.checkNotNull(motionEvent);
                inputFragment.handleLongPressTouch(motionEvent);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupClickListeners$lambda$43(InputFragment inputFragment, View view) {
        if (inputFragment.hasInputMessage()) {
            return false;
        }
        inputFragment.startLongPressRecording();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupClickListeners$lambda$44(InputFragment inputFragment, View view, MotionEvent motionEvent) {
        if (!inputFragment.isLongPressRecording) {
            return false;
        }
        Intrinsics.checkNotNull(motionEvent);
        inputFragment.handleLongPressTouch(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupClickListeners$lambda$45(InputFragment inputFragment, View view) {
        if (inputFragment.hasInputMessage() || inputFragment.getBinding().etInput.hasFocus()) {
            return false;
        }
        inputFragment.startLongPressRecording();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupClickListeners$lambda$48(final InputFragment inputFragment, View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (inputFragment.hasInputMessage() || inputFragment.getBinding().etInput.hasFocus()) {
                return false;
            }
            Runnable runnable = new Runnable() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda48
                @Override // java.lang.Runnable
                public final void run() {
                    InputFragment.this.startLongPressRecording();
                }
            };
            inputFragment.longPressRunnable = runnable;
            Handler handler = inputFragment.longPressHandler;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, 250L);
        } else {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return false;
                    }
                } else if (inputFragment.isLongPressRecording) {
                    Intrinsics.checkNotNull(motionEvent);
                    inputFragment.handleLongPressTouch(motionEvent);
                }
            }
            Runnable runnable2 = inputFragment.longPressRunnable;
            if (runnable2 != null) {
                inputFragment.longPressHandler.removeCallbacks(runnable2);
            }
            inputFragment.longPressRunnable = null;
            if (inputFragment.isLongPressRecording) {
                Intrinsics.checkNotNull(motionEvent);
                inputFragment.handleLongPressTouch(motionEvent);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupClickListeners$lambda$49(InputFragment inputFragment, View view, MotionEvent motionEvent) {
        if (!inputFragment.isLongPressRecording) {
            return false;
        }
        Intrinsics.checkNotNull(motionEvent);
        inputFragment.handleLongPressTouch(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$50(InputFragment inputFragment, View view) {
        Function0<Unit> function0 = inputFragment.onCloudClick;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$54(final InputFragment inputFragment, View view) {
        CliType cliType;
        if (inputFragment.isModelSelectorTaskLocked()) {
            return;
        }
        SelectedDeviceItem selectedDeviceItem = inputFragment.currentDevice;
        if (selectedDeviceItem == null || (cliType = selectedDeviceItem.getType()) == null) {
            cliType = inputFragment.currentCliType;
        }
        CliType cliType2 = cliType;
        ModelSelectBottomSheet.Companion companion = ModelSelectBottomSheet.INSTANCE;
        String id = inputFragment.selectedRemoteModel.getId();
        ChatMode chatMode = inputFragment.currentMode;
        String id2 = selectedDeviceItem != null ? selectedDeviceItem.getId() : null;
        if (id2 == null) {
            id2 = "";
        }
        ModelSelectBottomSheet newInstance = companion.newInstance(id, cliType2, chatMode, id2, selectedDeviceItem != null ? selectedDeviceItem.getIdeVersion() : null);
        newInstance.setOnModelListLoaded(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda45
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupClickListeners$lambda$54$lambda$53$lambda$51(InputFragment.this, (List) obj);
                return unit;
            }
        });
        newInstance.setOnModelSelected(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda46
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupClickListeners$lambda$54$lambda$53$lambda$52(InputFragment.this, (RemoteModelItem) obj);
                return unit;
            }
        });
        newInstance.show(inputFragment.getParentFragmentManager(), ModelSelectBottomSheet.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupClickListeners$lambda$54$lambda$53$lambda$51(InputFragment inputFragment, List list) {
        String displayName;
        Intrinsics.checkNotNullParameter(list, "models");
        RemoteModelItem resolveValidSelection = ModelSelectionRepository.INSTANCE.resolveValidSelection(inputFragment.selectedRemoteModel, list);
        if (!Intrinsics.areEqual(resolveValidSelection.getId(), inputFragment.selectedRemoteModel.getId())) {
            TraeFragmentInputBinding traeFragmentInputBinding = inputFragment._binding;
            if (traeFragmentInputBinding == null) {
                return Unit.INSTANCE;
            }
            inputFragment.selectedRemoteModel = resolveValidSelection;
            String str = inputFragment.currentConversationId;
            inputFragment.saveSelectedModel(resolveValidSelection, str == null || StringsKt.isBlank(str));
            TextView textView = traeFragmentInputBinding.tvModelName;
            if (inputFragment.isManualModelSelectionSupported()) {
                displayName = resolveValidSelection.getDisplayName();
            } else {
                displayName = RemoteModelItem.INSTANCE.auto().getDisplayName();
            }
            textView.setText(displayName);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupClickListeners$lambda$54$lambda$53$lambda$52(InputFragment inputFragment, RemoteModelItem remoteModelItem) {
        Intrinsics.checkNotNullParameter(remoteModelItem, "model");
        TraeFragmentInputBinding traeFragmentInputBinding = inputFragment._binding;
        if (traeFragmentInputBinding == null) {
            return Unit.INSTANCE;
        }
        inputFragment.selectedRemoteModel = remoteModelItem;
        inputFragment.saveSelectedModel(remoteModelItem, true);
        traeFragmentInputBinding.tvModelName.setText(remoteModelItem.getDisplayName());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$58(final InputFragment inputFragment, View view) {
        GitRepoSelectBottomSheet.Companion companion = GitRepoSelectBottomSheet.INSTANCE;
        GitSelectionViewModel gitSelectionViewModel = inputFragment.gitViewModel;
        if (gitSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel = null;
        }
        GitRepoSelectBottomSheet newInstance = companion.newInstance((GitRepoItem) gitSelectionViewModel.getSelectedRepo().getValue());
        newInstance.setOnRepoSelected(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda44
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupClickListeners$lambda$58$lambda$57$lambda$55(InputFragment.this, (GitRepoItem) obj);
                return unit;
            }
        });
        newInstance.setOnAuthFailed(new Function0() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda54
            public final Object invoke() {
                Unit unit;
                unit = InputFragment.setupClickListeners$lambda$58$lambda$57$lambda$56(InputFragment.this);
                return unit;
            }
        });
        newInstance.show(inputFragment.getParentFragmentManager(), GitRepoSelectBottomSheet.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupClickListeners$lambda$58$lambda$57$lambda$55(InputFragment inputFragment, GitRepoItem gitRepoItem) {
        Intrinsics.checkNotNullParameter(gitRepoItem, "repo");
        GitSelectionViewModel gitSelectionViewModel = inputFragment.gitViewModel;
        if (gitSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel = null;
        }
        gitSelectionViewModel.selectRepo(gitRepoItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupClickListeners$lambda$58$lambda$57$lambda$56(InputFragment inputFragment) {
        Function0<Unit> function0 = inputFragment.onAuthFailed;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$61(final InputFragment inputFragment, View view) {
        GitSelectionViewModel gitSelectionViewModel = inputFragment.gitViewModel;
        if (gitSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel = null;
        }
        BranchItem branchItem = (BranchItem) gitSelectionViewModel.getSelectedBranch().getValue();
        BranchSelectBottomSheet newInstance = BranchSelectBottomSheet.INSTANCE.newInstance(branchItem != null ? branchItem.getId() : null);
        newInstance.setOnBranchSelected(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda50
            public final Object invoke(Object obj) {
                Unit unit;
                unit = InputFragment.setupClickListeners$lambda$61$lambda$60$lambda$59(InputFragment.this, (BranchItem) obj);
                return unit;
            }
        });
        newInstance.show(inputFragment.getParentFragmentManager(), BranchSelectBottomSheet.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupClickListeners$lambda$61$lambda$60$lambda$59(InputFragment inputFragment, BranchItem branchItem) {
        GitSelectionViewModel gitSelectionViewModel = inputFragment.gitViewModel;
        if (gitSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel = null;
        }
        gitSelectionViewModel.selectBranch(branchItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$62(InputFragment inputFragment, View view) {
        Function0<Unit> function0 = inputFragment.onDeviceClick;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$63(final InputFragment inputFragment, View view) {
        SelectedDeviceItem selectedDeviceItem = inputFragment.currentDevice;
        if (selectedDeviceItem == null) {
            return;
        }
        String id = selectedDeviceItem.getId();
        if (selectedDeviceItem.getType() == CliType.IDE) {
            if (!inputFragment.isNewConversation && IDEProjectAvailabilityPolicy.INSTANCE.isUnavailable(selectedDeviceItem)) {
                inputFragment.showCurrentDeviceOfflineToast();
                return;
            } else {
                showIDEProjectPicker$default(inputFragment, selectedDeviceItem, false, 2, null);
                return;
            }
        }
        DirectoryBottomSheetFragment.Companion companion = DirectoryBottomSheetFragment.INSTANCE;
        ChatMode chatMode = inputFragment.currentMode;
        SelectedDeviceItem selectedDeviceItem2 = inputFragment.currentDevice;
        DirectoryBottomSheetFragment newInstance$default = DirectoryBottomSheetFragment.Companion.newInstance$default(companion, id, chatMode, selectedDeviceItem2 != null ? selectedDeviceItem2.getSelectedDirectory() : null, false, 8, null);
        newInstance$default.setOnDirectorySelectedListener(new DirectoryBottomSheetFragment.OnDirectorySelectedListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$setupClickListeners$19$1
            @Override // com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment.OnDirectorySelectedListener
            public void onDirectorySelected(DirectoryNode node) {
                SelectedDeviceItem selectedDeviceItem3;
                SelectedDeviceItem copy;
                TraeFragmentInputBinding binding;
                Intrinsics.checkNotNullParameter(node, "node");
                selectedDeviceItem3 = InputFragment.this.currentDevice;
                if (selectedDeviceItem3 != null) {
                    InputFragment inputFragment2 = InputFragment.this;
                    copy = selectedDeviceItem3.copy((r20 & 1) != 0 ? selectedDeviceItem3.id : null, (r20 & 2) != 0 ? selectedDeviceItem3.name : null, (r20 & 4) != 0 ? selectedDeviceItem3.type : null, (r20 & 8) != 0 ? selectedDeviceItem3.selectedDirectory : node.getPath(), (r20 & 16) != 0 ? selectedDeviceItem3.ideVersion : null, (r20 & 32) != 0 ? selectedDeviceItem3.projectId : null, (r20 & 64) != 0 ? selectedDeviceItem3.isProjectAvailable : false, (r20 & 128) != 0 ? selectedDeviceItem3.projectName : null, (r20 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? selectedDeviceItem3.showProductType : false);
                    inputFragment2.setSelectedDevice(copy);
                    Function1<SelectedDeviceItem, Unit> onSelectedDeviceChanged = inputFragment2.getOnSelectedDeviceChanged();
                    if (onSelectedDeviceChanged != null) {
                        onSelectedDeviceChanged.invoke(copy);
                    }
                    binding = inputFragment2.getBinding();
                    binding.tvFolderName.setText(inputFragment2.parseWorkspaceDisplayName(node.getPath()));
                }
            }
        });
        newInstance$default.show(inputFragment.getParentFragmentManager(), DirectoryBottomSheetFragment.TAG);
    }

    private final void showSkillsForCurrentDevice() {
        SelectedDeviceItem selectedDeviceItem = this.currentDevice;
        int i = WhenMappings.$EnumSwitchMapping$2[SkillEntryPolicy.INSTANCE.actionFor(selectedDeviceItem, this.isNewConversation).ordinal()];
        if (i == 1) {
            showSkillsBottomSheetForDevice(selectedDeviceItem);
            return;
        }
        if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            showSkillsBottomSheetForDevice(this.currentDevice);
        } else {
            if ((selectedDeviceItem != null ? selectedDeviceItem.getType() : null) == CliType.IDE) {
                showIDEProjectPicker(selectedDeviceItem, true);
            } else {
                showCurrentDeviceOfflineToast();
            }
        }
    }

    private final void showSkillsBottomSheetForDevice(SelectedDeviceItem device) {
        CliType type = device != null ? device.getType() : null;
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$3[type.ordinal()];
        if (i == 1) {
            showSkillsBottomSheet$default(this, device.getId(), device.getSelectedDirectory(), null, false, null, 16, null);
        } else if (i == 2) {
            showSkillsBottomSheet(device.getId(), device.getSelectedDirectory(), device.getProjectId(), true, this.currentConversationId);
        } else {
            showSkillsBottomSheet$default(this, null, null, null, false, null, 16, null);
        }
    }

    private final void checkHistoricalIdeProjectThenShowSkills() {
        if (this.isCheckingSkillProject) {
            return;
        }
        Function1<? super Function1<? super SelectedDeviceItem, Unit>, Unit> function1 = this.onRequestSkillProjectCheck;
        if (function1 == null) {
            showCurrentDeviceOfflineToast();
        } else {
            this.isCheckingSkillProject = true;
            function1.invoke(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    Unit checkHistoricalIdeProjectThenShowSkills$lambda$65;
                    checkHistoricalIdeProjectThenShowSkills$lambda$65 = InputFragment.checkHistoricalIdeProjectThenShowSkills$lambda$65(InputFragment.this, (SelectedDeviceItem) obj);
                    return checkHistoricalIdeProjectThenShowSkills$lambda$65;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkHistoricalIdeProjectThenShowSkills$lambda$65(InputFragment inputFragment, SelectedDeviceItem selectedDeviceItem) {
        inputFragment.isCheckingSkillProject = false;
        if (inputFragment._binding == null || !inputFragment.isAdded()) {
            return Unit.INSTANCE;
        }
        if (!SkillEntryPolicy.INSTANCE.canOpenCheckedIdeSkills(selectedDeviceItem)) {
            inputFragment.showCheckedIdeSkillsUnavailableToast(selectedDeviceItem);
        } else if (selectedDeviceItem != null) {
            inputFragment.setSelectedDevice(selectedDeviceItem);
            TextView textView = inputFragment.getBinding().tvFolderName;
            String projectName = selectedDeviceItem.getProjectName();
            if (projectName == null) {
                projectName = inputFragment.parseWorkspaceDisplayName(selectedDeviceItem.getSelectedDirectory());
            }
            textView.setText(projectName);
            inputFragment.showSkillsBottomSheetForDevice(selectedDeviceItem);
        }
        return Unit.INSTANCE;
    }

    private final void showCheckedIdeSkillsUnavailableToast(SelectedDeviceItem device) {
        int i;
        int i2 = WhenMappings.$EnumSwitchMapping$4[SkillEntryPolicy.INSTANCE.unavailableToastForCheckedIdeSkills(device).ordinal()];
        if (i2 == 1) {
            i = R.string.trae_device_workspace_closed;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.trae_device_currently_offline;
        }
        Toast.makeText(requireContext(), i, 0).show();
    }

    private final void showCurrentDeviceOfflineToast() {
        Toast.makeText(requireContext(), R.string.trae_device_currently_offline, 0).show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
    
        if (r2 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getSkillsForRequest() {
        CliType cliType;
        RemoteModelItem remoteModelItem;
        Object obj;
        RemoteModelItem selectedModelForRequest = getSelectedModelForRequest();
        if (selectedModelForRequest != null) {
            return selectedModelForRequest.getName();
        }
        SelectedDeviceItem selectedDeviceItem = this.currentDevice;
        if (selectedDeviceItem == null || (cliType = selectedDeviceItem.getType()) == null) {
            cliType = this.currentCliType;
        }
        List<String> resolveModelFunctions = resolveModelFunctions(cliType);
        IRemoteModelsApi.Companion companion = IRemoteModelsApi.INSTANCE;
        SelectedDeviceItem selectedDeviceItem2 = this.currentDevice;
        String id = selectedDeviceItem2 != null ? selectedDeviceItem2.getId() : null;
        if (id == null) {
            id = "";
        }
        List<RemoteModelItem> cachedModelsForUi = companion.getCachedModelsForUi(cliType, id, resolveModelFunctions);
        if (cachedModelsForUi != null) {
            Iterator<T> it = cachedModelsForUi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((RemoteModelItem) obj).isDefault()) {
                    break;
                }
            }
            remoteModelItem = (RemoteModelItem) obj;
        }
        remoteModelItem = cachedModelsForUi != null ? (RemoteModelItem) CollectionsKt.firstOrNull(cachedModelsForUi) : null;
        String name = remoteModelItem != null ? remoteModelItem.getName() : null;
        return name == null ? "" : name;
    }

    private final List<String> resolveModelFunctions(CliType cliType) {
        return cliType == CliType.IDE ? CollectionsKt.listOf("solo_agent") : (cliType == CliType.LOCAL && this.currentMode == ChatMode.CODE) ? CollectionsKt.listOf("solo_agent_lite") : (cliType == CliType.LOCAL && this.currentMode == ChatMode.MTC) ? CollectionsKt.listOf("solo_work_lite") : (cliType == CliType.REMOTE && this.currentMode == ChatMode.CODE) ? CollectionsKt.listOf("solo_agent_remote") : (cliType == CliType.REMOTE && this.currentMode == ChatMode.MTC) ? CollectionsKt.listOf("solo_work_remote") : CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void showSkillsBottomSheet$default(InputFragment inputFragment, String str, String str2, String str3, boolean z, String str4, int i, Object obj) {
        if ((i & 16) != 0) {
            str4 = null;
        }
        inputFragment.showSkillsBottomSheet(str, str2, str3, z, str4);
    }

    private final void showSkillsBottomSheet(String cliId, String workspaceFolder, String projectId, boolean isIdeSkills, String conversationId) {
        String str;
        CliType type;
        SkillsBottomSheet.Companion companion = SkillsBottomSheet.INSTANCE;
        String skillsForRequest = getSkillsForRequest();
        SelectedDeviceItem selectedDeviceItem = this.currentDevice;
        if (selectedDeviceItem == null || (type = selectedDeviceItem.getType()) == null) {
            str = null;
        } else {
            str = AgentResolver.INSTANCE.resolveDefaultAgentType(this.currentMode == ChatMode.CODE ? Mode.CODE : Mode.WORK, type);
        }
        SkillsBottomSheet newInstance = companion.newInstance(cliId, workspaceFolder, projectId, isIdeSkills, conversationId, skillsForRequest, str);
        newInstance.setOnSkillSelected(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda31
            public final Object invoke(Object obj) {
                Unit showSkillsBottomSheet$lambda$68;
                showSkillsBottomSheet$lambda$68 = InputFragment.showSkillsBottomSheet$lambda$68(InputFragment.this, (com.bytedance.trae.conversation.network.SkillItem) obj);
                return showSkillsBottomSheet$lambda$68;
            }
        });
        newInstance.show(getParentFragmentManager(), "SkillsBottomSheet");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showSkillsBottomSheet$lambda$68(InputFragment inputFragment, com.bytedance.trae.conversation.network.SkillItem skillItem) {
        Intrinsics.checkNotNullParameter(skillItem, "networkSkill");
        String skillId = skillItem.getSkillId();
        if (skillId == null) {
            skillId = "";
        }
        SkillItem skillItem2 = new SkillItem(skillId, skillItem.getName(), C0637R.drawable.ic_input_skill);
        inputFragment.holdToTalkState = HoldToTalkState.Normal;
        inputFragment.getBinding().etInput.insertSkillTag(skillItem2);
        inputFragment.updateHoldToTalkUI();
        return Unit.INSTANCE;
    }

    static /* synthetic */ void showIDEProjectPicker$default(InputFragment inputFragment, SelectedDeviceItem selectedDeviceItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        inputFragment.showIDEProjectPicker(selectedDeviceItem, z);
    }

    private final void showIDEProjectPicker(final SelectedDeviceItem device, final boolean openSkillsAfterSelection) {
        if (StringsKt.isBlank(device.getId())) {
            return;
        }
        IDEProjectBottomSheet newInstance = IDEProjectBottomSheet.INSTANCE.newInstance(device.getId(), device.getProjectId());
        newInstance.setProjectSelected(new IDEProjectBottomSheet.OnProjectSelectedListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$showIDEProjectPicker$1
            @Override // com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet.OnProjectSelectedListener
            public void onProjectSelected(ProjectItem node) {
                SelectedDeviceItem copy;
                TraeFragmentInputBinding binding;
                Intrinsics.checkNotNullParameter(node, "node");
                String projectId = node.getProjectId();
                IDEProjectNameUtil iDEProjectNameUtil = IDEProjectNameUtil.INSTANCE;
                Context requireContext = InputFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                copy = r1.copy((r20 & 1) != 0 ? r1.id : null, (r20 & 2) != 0 ? r1.name : null, (r20 & 4) != 0 ? r1.type : null, (r20 & 8) != 0 ? r1.selectedDirectory : node.getFolderPath(), (r20 & 16) != 0 ? r1.ideVersion : null, (r20 & 32) != 0 ? r1.projectId : projectId, (r20 & 64) != 0 ? r1.isProjectAvailable : false, (r20 & 128) != 0 ? r1.projectName : iDEProjectNameUtil.getProjectName(requireContext, node.getFolderPath(), node.getWorkspaceType()), (r20 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? device.showProductType : false);
                InputFragment.this.setSelectedDevice(copy);
                Function1<SelectedDeviceItem, Unit> onSelectedDeviceChanged = InputFragment.this.getOnSelectedDeviceChanged();
                if (onSelectedDeviceChanged != null) {
                    onSelectedDeviceChanged.invoke(copy);
                }
                binding = InputFragment.this.getBinding();
                TextView textView = binding.tvFolderName;
                String projectName = copy.getProjectName();
                textView.setText(projectName != null ? projectName : InputFragment.this.parseWorkspaceDisplayName(node.getFolderPath()));
                if (openSkillsAfterSelection) {
                    InputFragment.showSkillsBottomSheet$default(InputFragment.this, copy.getId(), copy.getSelectedDirectory(), copy.getProjectId(), true, null, 16, null);
                }
            }
        });
        newInstance.show(getParentFragmentManager(), IDEProjectBottomSheet.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startLongPressRecording() {
        if (!isNetworkAvailable()) {
            Toast.makeText(requireContext(), R.string.voice_network_unavailable, 0).show();
            TranscriptionVoiceManager.INSTANCE.reportImmediateAttemptEnd("start_failed", "network_unavailable", currentInputStateNameForMetrics());
            return;
        }
        this.isLongPressRecording = true;
        this.isLongPressCancelled = false;
        this.needTranscript = true;
        if (ensureRecordAudioPermission()) {
            VoiceRecordingOverlay voiceRecordingOverlay = this.voiceRecordingOverlay;
            if (voiceRecordingOverlay != null) {
                voiceRecordingOverlay.show();
            }
            TranscriptionVoiceManager transcriptionVoiceManager = this.voiceChatSessionManager;
            if (transcriptionVoiceManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("voiceChatSessionManager");
                transcriptionVoiceManager = null;
            }
            transcriptionVoiceManager.start(this.voiceChatListener);
            TraeAITracker.INSTANCE.trackAsrRecog(AsrRecogAction.RECOG_START);
            return;
        }
        TranscriptionVoiceManager.INSTANCE.reportImmediateAttemptEnd("start_failed", "permission_not_granted", currentInputStateNameForMetrics());
    }

    private final void handleLongPressTouch(MotionEvent event) {
        VoiceRecordingOverlay voiceRecordingOverlay = this.voiceRecordingOverlay;
        if (voiceRecordingOverlay == null) {
            return;
        }
        int action = event.getAction();
        if (action != 1) {
            if (action == 2) {
                if (this.isLongPressRecording) {
                    float rawX = event.getRawX();
                    float rawY = event.getRawY();
                    if (voiceRecordingOverlay.shouldCancel(rawY)) {
                        voiceRecordingOverlay.updateState(VoiceRecordingOverlay.RecordingState.CANCELING, rawX, rawY);
                        return;
                    } else {
                        voiceRecordingOverlay.updateState(VoiceRecordingOverlay.RecordingState.SPEAKING, rawX, rawY);
                        return;
                    }
                }
                return;
            }
            if (action != 3) {
                return;
            }
        }
        if (this.isLongPressRecording) {
            boolean z = event.getAction() == 3 || voiceRecordingOverlay.shouldCancel(event.getRawY());
            this.isLongPressRecording = false;
            this.isLongPressCancelled = z;
            voiceRecordingOverlay.hide();
            if (z) {
                this.needTranscript = false;
                audioRecordingRelease();
                TraeAITracker.INSTANCE.trackAsrRecog(AsrRecogAction.RECOG_CANCEL);
                return;
            }
            this.needTranscript = true;
            TranscriptionVoiceManager transcriptionVoiceManager = this.voiceChatSessionManager;
            if (transcriptionVoiceManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("voiceChatSessionManager");
                transcriptionVoiceManager = null;
            }
            if (transcriptionVoiceManager.getHasStartedVoiceChat()) {
                showVoiceLoading();
                TranscriptionVoiceManager transcriptionVoiceManager2 = this.voiceChatSessionManager;
                if (transcriptionVoiceManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("voiceChatSessionManager");
                    transcriptionVoiceManager2 = null;
                }
                TranscriptionVoiceManager.stop$default(transcriptionVoiceManager2, false, 1, null);
            }
            TraeAITracker.INSTANCE.trackAsrRecog(AsrRecogAction.RECOG_KEEP);
        }
    }

    private final boolean isNetworkAvailable() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            Object systemService = requireContext().getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return networkCapabilities.hasCapability(12);
        } catch (Throwable unused) {
            return true;
        }
    }

    private final void audioRecordingRelease() {
        TranscriptionVoiceManager transcriptionVoiceManager = this.voiceChatSessionManager;
        TranscriptionVoiceManager transcriptionVoiceManager2 = null;
        if (transcriptionVoiceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voiceChatSessionManager");
            transcriptionVoiceManager = null;
        }
        if (transcriptionVoiceManager.getHasStartedVoiceChat()) {
            TranscriptionVoiceManager transcriptionVoiceManager3 = this.voiceChatSessionManager;
            if (transcriptionVoiceManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("voiceChatSessionManager");
            } else {
                transcriptionVoiceManager2 = transcriptionVoiceManager3;
            }
            transcriptionVoiceManager2.stop(true);
        }
        getBinding().etInput.setText(this.initInputText);
        getBinding().inputBottom.setVisibility(0);
        this.isLongPressRecording = false;
        this.isLongPressCancelled = false;
        resetInputBar();
    }

    private final void showVoiceLoading() {
        FragmentActivity activity;
        try {
            if (this.voiceLoadingView == null && (activity = getActivity()) != null) {
                View decorView = activity.getWindow().getDecorView();
                ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
                if (viewGroup == null) {
                    return;
                }
                View inflate = LayoutInflater.from(requireContext()).inflate(C0637R.layout.loading_progress_bar_voice, viewGroup, false);
                viewGroup.addView(inflate);
                this.voiceLoadingView = inflate;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideVoiceLoading() {
        Window window;
        try {
            View view = this.voiceLoadingView;
            if (view == null) {
                return;
            }
            FragmentActivity activity = getActivity();
            View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
            ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            this.voiceLoadingView = null;
        } catch (Throwable unused) {
        }
    }

    private final void updateBranchColor() {
        GitSelectionViewModel gitSelectionViewModel = this.gitViewModel;
        GitSelectionViewModel gitSelectionViewModel2 = null;
        if (gitSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel = null;
        }
        if (gitSelectionViewModel.getSelectedRepo().getValue() != null) {
            GitSelectionViewModel gitSelectionViewModel3 = this.gitViewModel;
            if (gitSelectionViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                gitSelectionViewModel3 = null;
            }
            GitRepoItem gitRepoItem = (GitRepoItem) gitSelectionViewModel3.getSelectedRepo().getValue();
            if (!TextUtils.isEmpty(gitRepoItem != null ? gitRepoItem.getRepoUrl() : null)) {
                getBinding().btnBranch.setEnabled(true);
                getBinding().btnBranch.setAlpha(1.0f);
                GitSelectionViewModel gitSelectionViewModel4 = this.gitViewModel;
                if (gitSelectionViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                } else {
                    gitSelectionViewModel2 = gitSelectionViewModel4;
                }
                if (gitSelectionViewModel2.getSelectedBranch().getValue() == null) {
                    getBinding().tvBranchName.setText(R.string.trae_input_select_branch);
                    getBinding().imgSelectBranch.setImageResource(C0637R.drawable.git_branches_pupple);
                    getBinding().tvBranchName.setTextColor(ContextCompat.getColor(requireContext(), C0591R.color.trae_text_text_brand));
                    return;
                } else {
                    getBinding().imgSelectBranch.setImageResource(C0637R.drawable.git_branches_enable);
                    getBinding().tvBranchName.setTextColor(ContextCompat.getColor(requireContext(), C0591R.color.trae_text_text_default));
                    return;
                }
            }
        }
        getBinding().tvBranchName.setText(R.string.trae_input_select_branch);
        getBinding().btnBranch.setAlpha(0.5f);
        getBinding().btnBranch.setEnabled(false);
        getBinding().tvBranchName.setTextColor(ContextCompat.getColor(requireContext(), C0591R.color.trae_text_text_tertiary));
        getBinding().imgSelectBranch.setImageResource(C0637R.drawable.git_branches);
    }

    private final void updateBranchEnabled(boolean enabled) {
        getBinding().btnBranch.setEnabled(enabled);
        getBinding().btnBranch.setAlpha(enabled ? 1.0f : 0.5f);
        getBinding().imgSelectBranch.setImageResource(enabled ? C0637R.drawable.git_branches_enable : C0637R.drawable.git_branches);
        if (!enabled) {
            getBinding().tvBranchName.setTextColor(ContextCompat.getColor(requireContext(), C0591R.color.trae_text_text_tertiary));
        } else {
            getBinding().tvBranchName.setTextColor(ContextCompat.getColor(requireContext(), C0591R.color.trae_text_text_default));
        }
    }

    private final void updateGithubEnabled(boolean enabled) {
        getBinding().btnGithub.setEnabled(enabled);
        getBinding().btnGithub.setAlpha(enabled ? 1.0f : 0.5f);
    }

    private final void updateRepoIconForLoginPlatform() {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (Intrinsics.areEqual((iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getLoginPlatform(), ThirdPartyTokenRepository.TYPE_BYTECLOUD)) {
            getBinding().ivRepoIcon.setImageResource(C0637R.drawable.ic_input_bar_bytecloud);
            getBinding().ivRepoIcon.setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
        }
    }

    public final void loadGitRepos() {
        GitSelectionViewModel gitSelectionViewModel = this.gitViewModel;
        if (gitSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel = null;
        }
        gitSelectionViewModel.loadRepos();
    }

    public final String getSelectedModelNameForRequest() {
        String name = this.selectedRemoteModel.getName();
        if (isManualModelSelectionSupported() && !Intrinsics.areEqual(this.selectedRemoteModel.getId(), RemoteModelItem.INSTANCE.auto().getId())) {
            return name;
        }
        return null;
    }

    public final RemoteModelItem getSelectedModelForRequest() {
        RemoteModelItem remoteModelItem = this.selectedRemoteModel;
        if (isManualModelSelectionSupported() && !Intrinsics.areEqual(remoteModelItem.getId(), RemoteModelItem.INSTANCE.auto().getId())) {
            return remoteModelItem;
        }
        return null;
    }

    public final void setConversationId(String conversationId) {
        if (Intrinsics.areEqual(this.currentConversationId, conversationId)) {
            return;
        }
        this.currentConversationId = conversationId;
        restoreSelectedModelFromCache();
    }

    public final void restoreSelectedModelFromCache() {
        RemoteModelItem auto;
        if (isManualModelSelectionSupported()) {
            auto = ModelSelectionRepository.INSTANCE.loadSelection(currentEnvironmentKey(), currentModeKey(), this.currentConversationId);
        } else {
            auto = RemoteModelItem.INSTANCE.auto();
        }
        this.selectedRemoteModel = auto;
        updateModelSelectorVisibility();
    }

    private final void saveSelectedModel(RemoteModelItem model, boolean saveMode) {
        if (isManualModelSelectionSupported() || Intrinsics.areEqual(model.getId(), RemoteModelItem.INSTANCE.auto().getId())) {
            String currentEnvironmentKey = currentEnvironmentKey();
            String currentModeKey = currentModeKey();
            if (saveMode) {
                ModelSelectionRepository.INSTANCE.saveModeSelection(currentEnvironmentKey, currentModeKey, model);
            }
            ModelSelectionRepository.INSTANCE.saveSessionSelection(currentEnvironmentKey, currentModeKey, this.currentConversationId, model);
        }
    }

    private final String currentEnvironmentKey() {
        CliType cliType;
        ModelSelectionRepository modelSelectionRepository = ModelSelectionRepository.INSTANCE;
        SelectedDeviceItem selectedDeviceItem = this.currentDevice;
        if (selectedDeviceItem == null || (cliType = selectedDeviceItem.getType()) == null) {
            cliType = this.currentCliType;
        }
        return modelSelectionRepository.environmentKey(cliType);
    }

    private final String currentModeKey() {
        int i = WhenMappings.$EnumSwitchMapping$5[this.currentMode.ordinal()];
        if (i == 1) {
            return "code";
        }
        if (i == 2) {
            return ModelSelectionRepository.MODE_MTC;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setCloudName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        getBinding().tvCloudName.setText(name);
    }

    public final void setMultipleProducts(boolean value) {
        this.hasMultipleProducts = value;
    }

    private final void preloadPlugins(SelectedDeviceItem device) {
        SelectedDeviceItem selectedDeviceItem = device.getType() == CliType.LOCAL ? device : null;
        String id = selectedDeviceItem != null ? selectedDeviceItem.getId() : null;
        if (!(device.getType() == CliType.LOCAL)) {
            device = null;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), Dispatchers.getIO(), (CoroutineStart) null, new InputFragment$preloadPlugins$1(id, device != null ? device.getSelectedDirectory() : null, null), 2, (Object) null);
    }

    public final void setSelectedDevice(SelectedDeviceItem device) {
        RemoteModelItem auto;
        Intrinsics.checkNotNullParameter(device, "device");
        SelectedDeviceItem selectedDeviceItem = this.currentDevice;
        CliType type = selectedDeviceItem != null ? selectedDeviceItem.getType() : null;
        this.currentDevice = device;
        this.currentCliType = device.getType();
        preloadPlugins(device);
        if (isManualModelSelectionSupported()) {
            auto = ModelSelectionRepository.INSTANCE.loadSelection(currentEnvironmentKey(), currentModeKey(), this.currentConversationId);
        } else {
            auto = RemoteModelItem.INSTANCE.auto();
        }
        this.selectedRemoteModel = auto;
        setInputState(this.currentInputState);
        if (this._binding == null) {
            return;
        }
        updateContextualBar();
        int i = WhenMappings.$EnumSwitchMapping$6[TaskTemplateDeviceSelectionPolicy.INSTANCE.actionForDeviceChange(this.isNewConversation, type, device.getType()).ordinal()];
        if (i != 1) {
            if (i == 2) {
                hideTaskTemplates();
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                showTaskTemplates();
            }
        }
    }

    private final void updateContextualBar() {
        String str;
        String str2;
        SelectedDeviceItem selectedDeviceItem = this.currentDevice;
        if (!this.contextualBarVisibilityState.shouldShowForDevice(selectedDeviceItem != null) || selectedDeviceItem == null) {
            getBinding().bottomContextualBar.setVisibility(8);
            updateModelSelectorVisibility();
            return;
        }
        if (selectedDeviceItem.getType() == CliType.REMOTE) {
            getBinding().bottomContextualBar.setVisibility(0);
            getBinding().llCloudContent.setVisibility(0);
            getBinding().llCloud.setVisibility(0);
            getBinding().llDeviceFolderBar.setVisibility(8);
            getBinding().tvCloudName.setText(getString(R.string.trae_input_cloud));
            getBinding().ivCloudIcon.setImageResource(C0637R.drawable.ic_input_bar_remote);
            boolean z = this.currentMode == ChatMode.CODE;
            getBinding().btnGithub.setVisibility(z ? 0 : 8);
            getBinding().btnBranch.setVisibility(z ? 0 : 8);
        } else {
            getBinding().bottomContextualBar.setVisibility(0);
            getBinding().llDeviceFolderBar.setVisibility(0);
            getBinding().llCloudContent.setVisibility(8);
            getBinding().llCloud.setVisibility(8);
            if (this.hasMultipleProducts) {
                if (selectedDeviceItem.getType() == CliType.LOCAL) {
                    getBinding().ivDeviceBadge.setVisibility(0);
                    getBinding().ivDeviceBadge.setImageResource(C0637R.drawable.ic_device_badge_lite);
                } else {
                    getBinding().ivDeviceBadge.setVisibility(0);
                    getBinding().ivDeviceBadge.setImageResource(C0637R.drawable.ic_device_badge_ide);
                }
            } else {
                getBinding().ivDeviceBadge.setVisibility(8);
            }
            getBinding().tvDeviceName.setText(selectedDeviceItem.getName());
            if (selectedDeviceItem.getType() == CliType.IDE) {
                TextView textView = getBinding().tvFolderName;
                String projectName = selectedDeviceItem.getProjectName();
                if (projectName != null) {
                    str2 = projectName;
                } else {
                    String string = getString(R.string.trae_input_select_folder);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    str2 = string;
                }
                textView.setText(str2);
            } else {
                String parseWorkspaceDisplayName = parseWorkspaceDisplayName(selectedDeviceItem.getSelectedDirectory());
                TextView textView2 = getBinding().tvFolderName;
                if (parseWorkspaceDisplayName != null) {
                    str = parseWorkspaceDisplayName;
                } else {
                    String string2 = getString(R.string.trae_input_select_folder);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    str = string2;
                }
                textView2.setText(str);
            }
            SelectedDeviceItem selectedDeviceItem2 = this.currentDevice;
            if ((selectedDeviceItem2 != null ? selectedDeviceItem2.getType() : null) != CliType.IDE) {
                getBinding().btnChatNew.setVisibility(0);
            } else {
                getBinding().btnSendText.setVisibility(0);
            }
        }
        updateModelSelectorVisibility();
    }

    public final String parseWorkspaceDisplayName(String workspace) {
        String str = workspace;
        Object obj = null;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        List split$default = StringsKt.split$default(StringsKt.trimEnd(StringsKt.replace$default(workspace, '\\', '/', false, 4, (Object) null), new char[]{'/'}), new char[]{'/'}, false, 0, 6, (Object) null);
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

    public final void setCloudEnabled(boolean enabled) {
        getBinding().llCloudContent.setEnabled(enabled);
        getBinding().llCloudContent.setClickable(enabled);
        getBinding().llCloudContent.setAlpha(enabled ? 1.0f : 0.5f);
    }

    public final void setBottomContextualBarVisible(boolean visible) {
        this.contextualBarVisibilityState.setRequestedVisible(visible);
        if (visible) {
            updateContextualBar();
        } else {
            getBinding().bottomContextualBar.setVisibility(8);
            updateModelSelectorVisibility();
        }
    }

    public final void setDeviceFolderBarVisible(boolean visible) {
        getBinding().llDeviceFolderBar.setVisibility(visible ? 0 : 8);
    }

    public final void showTaskTemplates() {
        String str;
        BizResponse bizResp;
        TaskTemplatesData taskTemplatesData;
        if (this._binding == null) {
            return;
        }
        if (!this.isNewConversation) {
            hideTaskTemplates();
            return;
        }
        SelectedDeviceItem selectedDeviceItem = this.currentDevice;
        if ((selectedDeviceItem != null ? selectedDeviceItem.getType() : null) == CliType.IDE) {
            hideTaskTemplates();
            return;
        }
        if (TaskTemplateRepository.INSTANCE.isShow()) {
            HttpDataResult.Success cacheTaskTemplates = TaskTemplateRepository.INSTANCE.getCacheTaskTemplates();
            HttpDataResult.Success success = cacheTaskTemplates instanceof HttpDataResult.Success ? cacheTaskTemplates : null;
            List<TaskTemplate> templates = (success == null || (bizResp = success.getBizResp()) == null || (taskTemplatesData = (TaskTemplatesData) bizResp.getData()) == null) ? null : taskTemplatesData.getTemplates();
            List<TaskTemplate> list = templates;
            if (list == null || list.isEmpty()) {
                hideTaskTemplates();
                return;
            }
            int i = WhenMappings.$EnumSwitchMapping$5[this.currentMode.ordinal()];
            if (i == 1) {
                str = "code";
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "work";
            }
            List<TaskTemplateRepository.TaskTemplateModel> taskTemplateModels = TaskTemplateRepository.INSTANCE.toTaskTemplateModels(templates, str);
            if (taskTemplateModels.isEmpty()) {
                hideTaskTemplates();
                return;
            }
            InputTracker.INSTANCE.trackShowcaseShow(taskTemplateModels.size());
            RecyclerView recyclerView = this.taskTemplatesRecyclerView;
            if (recyclerView != null) {
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
                TaskTemplateAdapter taskTemplateAdapter = this.taskTemplateAdapter;
                if (taskTemplateAdapter != null) {
                    taskTemplateAdapter.submitList(taskTemplateModels);
                }
                registerKeyboardListener();
                return;
            }
            RecyclerView inflate = getBinding().vsTaskTemplates.inflate();
            RecyclerView recyclerView2 = inflate instanceof RecyclerView ? inflate : null;
            if (recyclerView2 == null) {
                recyclerView2 = (RecyclerView) inflate.findViewById(C0637R.id.rv_task_templates);
            }
            this.taskTemplatesRecyclerView = recyclerView2;
            if (recyclerView2 == null) {
                return;
            }
            RecyclerView.Adapter taskTemplateAdapter2 = new TaskTemplateAdapter(new Function1() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda47
                public final Object invoke(Object obj) {
                    Unit showTaskTemplates$lambda$74;
                    showTaskTemplates$lambda$74 = InputFragment.showTaskTemplates$lambda$74(InputFragment.this, (TaskTemplateRepository.TaskTemplateModel) obj);
                    return showTaskTemplates$lambda$74;
                }
            });
            this.taskTemplateAdapter = taskTemplateAdapter2;
            recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            recyclerView2.setItemAnimator((RecyclerView.ItemAnimator) null);
            recyclerView2.setAdapter(taskTemplateAdapter2);
            final int dimensionPixelSize = getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_12);
            recyclerView2.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.bytedance.trae.conversation.widget.InputFragment$showTaskTemplates$1
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    if (parent.getChildAdapterPosition(view) > 0) {
                        outRect.top = dimensionPixelSize;
                    }
                }
            });
            taskTemplateAdapter2.submitList(taskTemplateModels);
            registerKeyboardListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showTaskTemplates$lambda$74(InputFragment inputFragment, TaskTemplateRepository.TaskTemplateModel taskTemplateModel) {
        Intrinsics.checkNotNullParameter(taskTemplateModel, "template");
        inputFragment.hideKeyboard();
        inputFragment.setSendingState(true);
        if (inputFragment.currentMode == ChatMode.CODE) {
            GitSelectionViewModel gitSelectionViewModel = inputFragment.gitViewModel;
            if (gitSelectionViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                gitSelectionViewModel = null;
            }
            if (gitSelectionViewModel.getSelectedRepo().getValue() != null) {
                if (!TextUtils.isEmpty(taskTemplateModel.getGitPrompt())) {
                    Function1<? super String, Unit> function1 = inputFragment.onTemplateClick;
                    if (function1 != null) {
                        function1.invoke(taskTemplateModel.getGitPrompt());
                    }
                } else {
                    Function1<? super String, Unit> function12 = inputFragment.onTemplateClick;
                    if (function12 != null) {
                        function12.invoke(taskTemplateModel.getPrompt());
                    }
                }
            } else {
                Function1<? super String, Unit> function13 = inputFragment.onTemplateClick;
                if (function13 != null) {
                    function13.invoke(taskTemplateModel.getPrompt());
                }
            }
        } else {
            Function1<? super String, Unit> function14 = inputFragment.onTemplateClick;
            if (function14 != null) {
                function14.invoke(taskTemplateModel.getPrompt());
            }
        }
        inputFragment.hideTaskTemplates();
        return Unit.INSTANCE;
    }

    public final void hideTaskTemplates() {
        RecyclerView recyclerView = this.taskTemplatesRecyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        unregisterKeyboardListener();
    }

    private final void registerKeyboardListener() {
        ViewTreeObserver viewTreeObserver;
        if (this.isKeyboardListenerRegistered) {
            return;
        }
        View view = getView();
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this.keyboardLayoutListener);
        }
        this.isKeyboardListenerRegistered = true;
    }

    private final void unregisterKeyboardListener() {
        ViewTreeObserver viewTreeObserver;
        if (this.isKeyboardListenerRegistered) {
            View view = getView();
            if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.keyboardLayoutListener);
            }
            this.isKeyboardListenerRegistered = false;
        }
    }

    public final void setSendingState(boolean isSending) {
        if (isSending) {
            setInputState(InputState.Sending);
        } else if (canSend()) {
            setInputState(InputState.Input);
        } else {
            setInputState(InputState.Empty);
        }
    }

    public final void cancelTask(boolean isSuccess) {
        if (isSuccess) {
            switchInputState(InputState.Input);
        } else if (this.currentInputState == InputState.Stopped) {
            switchInputState(InputState.Input);
        }
    }

    public final void onStreaming(boolean isDone) {
        if (isDone) {
            if (canSend()) {
                setInputState(InputState.Input);
                return;
            } else {
                setInputState(InputState.Empty);
                return;
            }
        }
        if (this.currentInputState != InputState.Stopped) {
            switchInputState(InputState.Sended);
        }
    }

    public final void switchInputSended() {
        if (this.currentInputState == InputState.Stopped) {
            setInputState(InputState.Sended);
        }
    }

    public final void switchInputState(InputState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == InputState.Sending || state == InputState.Sended || state == InputState.Stopped) {
            setInputState(state);
        } else if (canSend()) {
            setInputState(InputState.Input);
        } else {
            setInputState(InputState.Empty);
        }
    }

    public final void setInputState(InputState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.currentInputState = state;
        if (this._binding == null) {
            return;
        }
        getBinding().btnChatNew.setVisibility(8);
        getBinding().btnSendText.setVisibility(8);
        getBinding().sending.setVisibility(8);
        getBinding().btnPause.setVisibility(8);
        int i = WhenMappings.$EnumSwitchMapping$7[state.ordinal()];
        if (i == 1) {
            SelectedDeviceItem selectedDeviceItem = this.currentDevice;
            if ((selectedDeviceItem != null ? selectedDeviceItem.getType() : null) != CliType.IDE) {
                getBinding().btnChatNew.setVisibility(0);
            } else {
                getBinding().btnSendText.setVisibility(0);
            }
        } else if (i == 2) {
            getBinding().btnSendText.setVisibility(0);
        } else if (i == 3) {
            getBinding().sending.setVisibility(0);
        } else if (i == 4) {
            getBinding().btnPause.setVisibility(0);
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            getBinding().sending.setVisibility(0);
        }
        updateModelSelectorVisibility();
    }

    public final boolean hasInputMessage() {
        Editable text = getBinding().etInput.getText();
        if (text != null) {
            return text.length() > 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasUploadedAttachments() {
        boolean z;
        List list = (List) getInputViewModel().getAttachments().getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (!list.isEmpty()) {
            List list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    if (!(((AttachmentItem) it.next()).getUploadStatus() == AttachmentUploadStatus.Success)) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    private final boolean hasUploadingAttachments() {
        List list = (List) getInputViewModel().getAttachments().getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<AttachmentItem> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        for (AttachmentItem attachmentItem : list2) {
            if (attachmentItem.getUploadStatus() == AttachmentUploadStatus.Uploading || attachmentItem.getUploadStatus() == AttachmentUploadStatus.Pending) {
                return true;
            }
        }
        return false;
    }

    private final boolean hasFailedAttachments() {
        List list = (List) getInputViewModel().getAttachments().getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            if (((AttachmentItem) it.next()).getUploadStatus() == AttachmentUploadStatus.Error) {
                return true;
            }
        }
        return false;
    }

    private final boolean canSend() {
        return hasInputMessage() || hasUploadedAttachments();
    }

    public final InputPayload getInputPayload() {
        List<TranscriptEditText.ContentSegment> contentSegments = getBinding().etInput.getContentSegments();
        ArrayList arrayList = new ArrayList();
        List<AttachmentItem> uploadedImages = getInputViewModel().getUploadedImages();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = uploadedImages.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String uploadedOid = ((AttachmentItem) it.next()).getUploadedOid();
            QueryItem image$default = uploadedOid != null ? QueryItem.Companion.image$default(QueryItem.INSTANCE, uploadedOid, null, 2, null) : null;
            if (image$default != null) {
                arrayList2.add(image$default);
            }
        }
        ArrayList arrayList3 = arrayList2;
        List<AttachmentItem> uploadedFiles = getInputViewModel().getUploadedFiles();
        ArrayList arrayList4 = new ArrayList();
        for (AttachmentItem attachmentItem : uploadedFiles) {
            String uploadedOid2 = attachmentItem.getUploadedOid();
            QueryItem attachment$default = uploadedOid2 == null ? null : QueryItem.Companion.attachment$default(QueryItem.INSTANCE, "trae-res://remote_resource/" + uploadedOid2, getQueryFileName(attachmentItem), 0L, null, 12, null);
            if (attachment$default != null) {
                arrayList4.add(attachment$default);
            }
        }
        ArrayList arrayList5 = arrayList4;
        Gson gson = new Gson();
        List createListBuilder = CollectionsKt.createListBuilder();
        for (TranscriptEditText.ContentSegment contentSegment : contentSegments) {
            if (contentSegment instanceof TranscriptEditText.ContentSegment.Text) {
                createListBuilder.add(QueryItem.INSTANCE.text(((TranscriptEditText.ContentSegment.Text) contentSegment).getContent()));
            } else if (contentSegment instanceof TranscriptEditText.ContentSegment.Skill) {
                TranscriptEditText.ContentSegment.Skill skill = (TranscriptEditText.ContentSegment.Skill) contentSegment;
                createListBuilder.add(QueryItem.INSTANCE.skill(skill.getSkillItem().getId(), skill.getSkillItem().getName()));
            } else {
                if (!(contentSegment instanceof TranscriptEditText.ContentSegment.Plugin)) {
                    throw new NoWhenBranchMatchedException();
                }
                TranscriptEditText.ContentSegment.Plugin plugin = (TranscriptEditText.ContentSegment.Plugin) contentSegment;
                arrayList.add(plugin.getPluginItem());
                createListBuilder.add(QueryItem.INSTANCE.plugin(plugin.getPluginItem().getId(), plugin.getPluginItem().getId(), plugin.getPluginItem().getDisplayName(), plugin.getPluginItem().getIconUrl()));
            }
        }
        if (this.currentMode == ChatMode.CODE) {
            ArrayList arrayList6 = arrayList3;
            if (!arrayList6.isEmpty()) {
                createListBuilder.addAll(arrayList6);
            }
        } else {
            ArrayList arrayList7 = arrayList5;
            if (!arrayList7.isEmpty()) {
                createListBuilder.addAll(arrayList7);
            }
        }
        String json = gson.toJson(CollectionsKt.build(createListBuilder));
        Intrinsics.checkNotNull(json);
        return new InputPayload(json, arrayList);
    }

    public final String getQuery(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        List<AttachmentItem> uploadedImages = getInputViewModel().getUploadedImages();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = uploadedImages.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String uploadedOid = ((AttachmentItem) it.next()).getUploadedOid();
            QueryItem image$default = uploadedOid != null ? QueryItem.Companion.image$default(QueryItem.INSTANCE, uploadedOid, null, 2, null) : null;
            if (image$default != null) {
                arrayList.add(image$default);
            }
        }
        ArrayList arrayList2 = arrayList;
        List<AttachmentItem> uploadedFiles = getInputViewModel().getUploadedFiles();
        ArrayList arrayList3 = new ArrayList();
        for (AttachmentItem attachmentItem : uploadedFiles) {
            String uploadedOid2 = attachmentItem.getUploadedOid();
            QueryItem attachment$default = uploadedOid2 == null ? null : QueryItem.Companion.attachment$default(QueryItem.INSTANCE, "trae-res://remote_resource/" + uploadedOid2, getQueryFileName(attachmentItem), 0L, null, 12, null);
            if (attachment$default != null) {
                arrayList3.add(attachment$default);
            }
        }
        ArrayList arrayList4 = arrayList3;
        Gson gson = new Gson();
        List createListBuilder = CollectionsKt.createListBuilder();
        createListBuilder.add(QueryItem.INSTANCE.text(input));
        if (this.currentMode == ChatMode.CODE) {
            ArrayList arrayList5 = arrayList2;
            if (!arrayList5.isEmpty()) {
                createListBuilder.addAll(arrayList5);
            }
        } else {
            ArrayList arrayList6 = arrayList4;
            if (!arrayList6.isEmpty()) {
                createListBuilder.addAll(arrayList6);
            }
        }
        String json = gson.toJson(CollectionsKt.build(createListBuilder));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public final void clearInput() {
        Editable text = getBinding().etInput.getText();
        if (text != null) {
            text.clear();
        }
        getInputViewModel().clearAttachments();
    }

    private final String getQueryFileName(AttachmentItem attachmentItem) {
        String extensionFromMimeType;
        String fileName = attachmentItem.getFileName();
        String str = null;
        if (fileName != null) {
            if (!(!StringsKt.isBlank(fileName))) {
                fileName = null;
            }
            if (fileName != null) {
                return fileName;
            }
        }
        String mimeType = attachmentItem.getMimeType();
        if (mimeType != null && (extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType)) != null && (!StringsKt.isBlank(extensionFromMimeType))) {
            str = extensionFromMimeType;
        }
        return str == null ? "attachment" : "attachment." + str;
    }

    /* compiled from: InputFragment.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;", "", "editable", "", "currentSkill", "Lcom/bytedance/trae/conversation/widget/SkillItem;", "attachments", "", "Lcom/bytedance/trae/conversation/widget/AttachmentItem;", "currentDevice", "Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "<init>", "(Ljava/lang/CharSequence;Lcom/bytedance/trae/conversation/widget/SkillItem;Ljava/util/List;Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V", "getEditable", "()Ljava/lang/CharSequence;", "getCurrentSkill", "()Lcom/bytedance/trae/conversation/widget/SkillItem;", "getAttachments", "()Ljava/util/List;", "getCurrentDevice", "()Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ModeDraft {
        private final List<AttachmentItem> attachments;
        private final SelectedDeviceItem currentDevice;
        private final SkillItem currentSkill;
        private final CharSequence editable;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ModeDraft copy$default(ModeDraft modeDraft, CharSequence charSequence, SkillItem skillItem, List list, SelectedDeviceItem selectedDeviceItem, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = modeDraft.editable;
            }
            if ((i & 2) != 0) {
                skillItem = modeDraft.currentSkill;
            }
            if ((i & 4) != 0) {
                list = modeDraft.attachments;
            }
            if ((i & 8) != 0) {
                selectedDeviceItem = modeDraft.currentDevice;
            }
            return modeDraft.copy(charSequence, skillItem, list, selectedDeviceItem);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getEditable() {
            return this.editable;
        }

        /* renamed from: component2, reason: from getter */
        public final SkillItem getCurrentSkill() {
            return this.currentSkill;
        }

        public final List<AttachmentItem> component3() {
            return this.attachments;
        }

        /* renamed from: component4, reason: from getter */
        public final SelectedDeviceItem getCurrentDevice() {
            return this.currentDevice;
        }

        public final ModeDraft copy(CharSequence editable, SkillItem currentSkill, List<AttachmentItem> attachments, SelectedDeviceItem currentDevice) {
            Intrinsics.checkNotNullParameter(editable, "editable");
            Intrinsics.checkNotNullParameter(attachments, "attachments");
            return new ModeDraft(editable, currentSkill, attachments, currentDevice);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModeDraft)) {
                return false;
            }
            ModeDraft modeDraft = (ModeDraft) other;
            return Intrinsics.areEqual(this.editable, modeDraft.editable) && Intrinsics.areEqual(this.currentSkill, modeDraft.currentSkill) && Intrinsics.areEqual(this.attachments, modeDraft.attachments) && Intrinsics.areEqual(this.currentDevice, modeDraft.currentDevice);
        }

        public int hashCode() {
            int hashCode = this.editable.hashCode() * 31;
            SkillItem skillItem = this.currentSkill;
            int hashCode2 = (((hashCode + (skillItem == null ? 0 : skillItem.hashCode())) * 31) + this.attachments.hashCode()) * 31;
            SelectedDeviceItem selectedDeviceItem = this.currentDevice;
            return hashCode2 + (selectedDeviceItem != null ? selectedDeviceItem.hashCode() : 0);
        }

        public String toString() {
            return "ModeDraft(editable=" + ((Object) this.editable) + ", currentSkill=" + this.currentSkill + ", attachments=" + this.attachments + ", currentDevice=" + this.currentDevice + ')';
        }

        public ModeDraft(CharSequence charSequence, SkillItem skillItem, List<AttachmentItem> list, SelectedDeviceItem selectedDeviceItem) {
            Intrinsics.checkNotNullParameter(charSequence, "editable");
            Intrinsics.checkNotNullParameter(list, "attachments");
            this.editable = charSequence;
            this.currentSkill = skillItem;
            this.attachments = list;
            this.currentDevice = selectedDeviceItem;
        }

        public final CharSequence getEditable() {
            return this.editable;
        }

        public final SkillItem getCurrentSkill() {
            return this.currentSkill;
        }

        public final List<AttachmentItem> getAttachments() {
            return this.attachments;
        }

        public final SelectedDeviceItem getCurrentDevice() {
            return this.currentDevice;
        }
    }

    public final ModeDraft saveDraft() {
        Editable text = getBinding().etInput.getText();
        if (text == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        SkillItem currentSkill = getBinding().etInput.getCurrentSkill();
        List list = (List) getInputViewModel().getAttachments().getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((AttachmentItem) obj).getUploadStatus() == AttachmentUploadStatus.Success) {
                arrayList.add(obj);
            }
        }
        return new ModeDraft(spannableStringBuilder, currentSkill, arrayList, this.currentDevice);
    }

    public final void restoreDraft(ModeDraft draft) {
        Intrinsics.checkNotNullParameter(draft, "draft");
        getBinding().etInput.setText(draft.getEditable(), TextView.BufferType.EDITABLE);
        TranscriptEditText transcriptEditText = getBinding().etInput;
        Editable text = getBinding().etInput.getText();
        transcriptEditText.setSelection(text != null ? text.length() : 0);
        getBinding().etInput.setCurrentSkill(draft.getCurrentSkill());
        if (!draft.getAttachments().isEmpty()) {
            getInputViewModel().setAttachments(draft.getAttachments());
        }
        if (draft.getCurrentDevice() != null) {
            setSelectedDevice(draft.getCurrentDevice());
            return;
        }
        this.currentDevice = null;
        this.currentCliType = CliType.REMOTE;
        updateModelSelectorVisibility();
    }

    public final void setInputText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        getBinding().etInput.setText(text);
        getBinding().etInput.setSelection(text.length());
    }

    public final void resetSendButton() {
        boolean canSend = canSend();
        getBinding().btnSendText.setEnabled(canSend);
        getBinding().btnSendText.setClickable(canSend);
    }

    public final void addRevertMessage(ParsedChatMessage message) {
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(message, "message");
        List<MessagePart> query = message.getQuery();
        if (query == null) {
            query = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : query) {
            if (Intrinsics.areEqual(((MessagePart) obj).getType(), "text")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            JsonObject data = ((MessagePart) it.next()).getData();
            String str = null;
            if (data != null && (jsonElement = data.get(ReportConstant.COMMON_CONTENT)) != null) {
                if (!jsonElement.isJsonPrimitive()) {
                    jsonElement = null;
                }
                if (jsonElement != null) {
                    str = jsonElement.getAsString();
                }
            }
            if (str != null) {
                arrayList2.add(str);
            }
        }
        String joinToString$default = CollectionsKt.joinToString$default(arrayList2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        if (joinToString$default.length() > 0) {
            setInputText(joinToString$default);
        }
    }

    private final boolean ensureRecordAudioPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.RECORD_AUDIO") == 0) {
            return true;
        }
        PermissionRationaleDialog.Companion companion = PermissionRationaleDialog.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        companion.showForPermission(requireContext, C0591R.drawable.trae_ic_permission_microphone, R.string.trae_permission_microphone_title, R.string.trae_permission_microphone_message, R.string.trae_permission_allow, R.string.trae_permission_deny, new Function0() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda5
            public final Object invoke() {
                Unit ensureRecordAudioPermission$lambda$94;
                ensureRecordAudioPermission$lambda$94 = InputFragment.ensureRecordAudioPermission$lambda$94(InputFragment.this);
                return ensureRecordAudioPermission$lambda$94;
            }
        }, (r19 & 128) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.PermissionRationaleDialog$Companion$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ensureRecordAudioPermission$lambda$94(InputFragment inputFragment) {
        inputFragment.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 10001);
        return Unit.INSTANCE;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10001) {
            if (((grantResults.length == 0) ^ true) && grantResults[0] == 0) {
                return;
            }
            Toast.makeText(requireContext(), R.string.trae_conversation_mic_permission_denied, 0).show();
        }
    }

    public final void setMode(ChatMode mode) {
        RemoteModelItem auto;
        CliType cliType;
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.currentMode = mode;
        if (this._binding == null) {
            return;
        }
        if (isManualModelSelectionSupported()) {
            auto = ModelSelectionRepository.INSTANCE.loadSelection(currentEnvironmentKey(), currentModeKey(), this.currentConversationId);
        } else {
            auto = RemoteModelItem.INSTANCE.auto();
        }
        this.selectedRemoteModel = auto;
        if (this.isNewConversation) {
            int i = WhenMappings.$EnumSwitchMapping$5[mode.ordinal()];
            if (i == 1) {
                getBinding().llCloud.setVisibility(0);
                getBinding().llCloudContent.setVisibility(0);
                getBinding().llDeviceFolderBar.setVisibility(8);
                getBinding().btnGithub.setVisibility(0);
                getBinding().btnBranch.setVisibility(0);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                getBinding().llCloud.setVisibility(0);
                getBinding().llCloudContent.setVisibility(0);
                getBinding().llDeviceFolderBar.setVisibility(8);
                getBinding().btnGithub.setVisibility(8);
                getBinding().btnBranch.setVisibility(8);
            }
        } else {
            getBinding().btnGithub.setVisibility(8);
            getBinding().btnBranch.setVisibility(8);
        }
        updateModelSelectorVisibility();
        TaskTemplateDeviceSelectionPolicy taskTemplateDeviceSelectionPolicy = TaskTemplateDeviceSelectionPolicy.INSTANCE;
        boolean z = this.isNewConversation;
        SelectedDeviceItem selectedDeviceItem = this.currentDevice;
        if (selectedDeviceItem == null || (cliType = selectedDeviceItem.getType()) == null) {
            cliType = this.currentCliType;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$6[taskTemplateDeviceSelectionPolicy.actionForModeChange(z, cliType).ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                hideTaskTemplates();
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                showTaskTemplates();
            }
        }
    }

    private final void updateModelSelectorVisibility() {
        String displayName;
        if (this._binding == null) {
            return;
        }
        TextView textView = getBinding().tvModelName;
        if (isManualModelSelectionSupported()) {
            displayName = this.selectedRemoteModel.getDisplayName();
        } else {
            displayName = RemoteModelItem.INSTANCE.auto().getDisplayName();
        }
        textView.setText(displayName);
        getBinding().modelSelector.setVisibility(this.holdToTalkState == HoldToTalkState.Normal ? 0 : 8);
        boolean z = !isModelSelectorTaskLocked();
        getBinding().modelSelector.setEnabled(z);
        getBinding().modelSelector.setClickable(z);
        getBinding().modelSelector.setAlpha(z ? 1.0f : 0.5f);
    }

    private final boolean isModelSelectorTaskLocked() {
        if (this.currentInputState == InputState.Sending || this.currentInputState == InputState.Sended || this.currentInputState == InputState.Stopped) {
            return true;
        }
        Function0<Boolean> function0 = this.isTaskRunning;
        return function0 != null && ((Boolean) function0.invoke()).booleanValue();
    }

    public final void switchMode(ChatMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (this.currentMode == mode) {
            return;
        }
        setMode(mode);
        Function1<? super ChatMode, Unit> function1 = this.onSwitchMode;
        if (function1 != null) {
            function1.invoke(mode);
        }
    }

    public void onDestroyView() {
        ViewTreeObserver viewTreeObserver;
        ExpressPassBenefitManager.INSTANCE.removeRemainingChangedListener(this.remainingChangedListener);
        ExpressPassBenefitManager.INSTANCE.removeBenefitSwitchListener(this.benefitSwitchListener);
        View view = getView();
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this.inputKeyboardLayoutListener);
        }
        unregisterKeyboardListener();
        dismissDeviceTipsPopWindow();
        dismissExpressPassToggleTooltip();
        dismissExpressPassPopWindow();
        Runnable runnable = this.longPressRunnable;
        if (runnable != null) {
            this.longPressHandler.removeCallbacks(runnable);
        }
        this.longPressRunnable = null;
        hideVoiceLoading();
        super.onDestroyView();
        TranscriptionVoiceManager transcriptionVoiceManager = this.voiceChatSessionManager;
        if (transcriptionVoiceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voiceChatSessionManager");
            transcriptionVoiceManager = null;
        }
        transcriptionVoiceManager.release();
        this.taskTemplatesRecyclerView = null;
        this.taskTemplateAdapter = null;
        this._binding = null;
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
            return FileProvider.getUriForFile(requireContext, requireContext.getPackageName() + ".uri.key", new File(file, "trae_media_choose_" + System.currentTimeMillis() + ".jpg"));
        } catch (Exception unused) {
            return null;
        }
    }

    private final void setViewGroupEnabled(ViewGroup viewGroup, boolean enabled) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(enabled);
            childAt.setClickable(enabled);
            if (childAt instanceof ViewGroup) {
                setViewGroupEnabled((ViewGroup) childAt, enabled);
            }
        }
    }

    public final void hideKeyboard() {
        Object systemService = requireContext().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        IBinder windowToken = getBinding().etInput.getWindowToken();
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        }
        getBinding().etInput.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showExpressPassPopWindow() {
        TextView textView;
        TextView textView2;
        try {
            if (this._binding == null) {
                return;
            }
            dismissExpressPassPopWindow();
            float f = getResources().getDisplayMetrics().density;
            View inflate = LayoutInflater.from(requireContext()).inflate(C0637R.layout.trae_express_pass_pop_window, (ViewGroup) null);
            Context context = getContext();
            if (context != null && (textView2 = (TextView) inflate.findViewById(C0637R.id.tv_express_pass_title)) != null) {
                I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
                Resources resources = context.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                textView2.setText(i18nTextProvider.getString(resources, R.string.imkit_fast_pass_onbording_title, new Object[0]));
            }
            Context context2 = getContext();
            if (context2 != null && (textView = (TextView) inflate.findViewById(C0637R.id.tv_express_pass_subtitle)) != null) {
                I18nTextProvider i18nTextProvider2 = I18nTextProvider.INSTANCE;
                Resources resources2 = context2.getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
                textView.setText(i18nTextProvider2.getString(resources2, R.string.imkit_fast_pass_onbording_desc, new Object[0]));
            }
            View findViewById = inflate.findViewById(C0637R.id.express_pass_close);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda40
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        InputFragment.this.dismissExpressPassPopWindow();
                    }
                });
            }
            inflate.setBackground(new BubbleDrawable(requireContext()));
            inflate.setLayerType(1, null);
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredWidth = inflate.getMeasuredWidth();
            int measuredHeight = inflate.getMeasuredHeight();
            ImageView imageView = getBinding().btnExpressPass;
            Intrinsics.checkNotNullExpressionValue(imageView, "btnExpressPass");
            if (imageView.isAttachedToWindow()) {
                FLog.d("ExpressPassBenefitManager", "defaultArrowCenterPx:" + imageView.getWidth());
                PopupWindow popupWindow = new PopupWindow(inflate, measuredWidth, measuredHeight, true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAsDropDown(imageView, (int) (((int) (16 * f)) - (53.0f * f)), -(measuredHeight + ((int) (32 * f))));
                this.expressPassPopWindow = popupWindow;
                inflate.setAlpha(0.0f);
                inflate.setTranslationY(f * 6.0f);
                inflate.animate().alpha(1.0f).translationY(0.0f).setDuration(220L).setInterpolator(new DecelerateInterpolator()).start();
                Runnable runnable = new Runnable() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda41
                    @Override // java.lang.Runnable
                    public final void run() {
                        InputFragment.this.dismissExpressPassPopWindow();
                    }
                };
                this.expressPassPopDismissRunnable = runnable;
                Intrinsics.checkNotNull(runnable);
                inflate.postDelayed(runnable, 2000L);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissExpressPassPopWindow() {
        ViewPropertyAnimator animate;
        try {
            PopupWindow popupWindow = this.expressPassPopWindow;
            View contentView = popupWindow != null ? popupWindow.getContentView() : null;
            Runnable runnable = this.expressPassPopDismissRunnable;
            if (runnable != null) {
                if (contentView != null) {
                    contentView.removeCallbacks(runnable);
                }
                this.expressPassPopDismissRunnable = null;
            }
            if (contentView != null && (animate = contentView.animate()) != null) {
                animate.cancel();
            }
            PopupWindow popupWindow2 = this.expressPassPopWindow;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
            }
            this.expressPassPopWindow = null;
        } catch (Throwable unused) {
        }
    }

    private final void showExpressPassToggleTooltip(boolean enabled) {
        int i;
        try {
            if (this._binding == null) {
                return;
            }
            dismissExpressPassToggleTooltip();
            final float f = getResources().getDisplayMetrics().density;
            final View inflate = LayoutInflater.from(requireContext()).inflate(C0637R.layout.trae_express_pass_toggle_tooltip, (ViewGroup) null);
            BubbleDrawable bubbleDrawable = new BubbleDrawable(requireContext());
            bubbleDrawable.setCornerRadius(12.0f, f);
            inflate.setBackground(bubbleDrawable);
            inflate.setLayerType(1, null);
            TextView textView = (TextView) inflate.findViewById(C0637R.id.tv_toggle_text);
            if (this.infinite) {
                Context context = getContext();
                if (context != null) {
                    I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
                    Resources resources = context.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                    textView.setText(i18nTextProvider.getString(resources, R.string.imkit_fast_pass_999, new Object[0]));
                }
            } else {
                Context context2 = getContext();
                if (context2 != null) {
                    I18nTextProvider i18nTextProvider2 = I18nTextProvider.INSTANCE;
                    Resources resources2 = context2.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
                    if (enabled) {
                        i = R.string.imkit_fast_pass_activated;
                    } else {
                        i = R.string.imkit_fast_pass_disabled;
                    }
                    textView.setText(i18nTextProvider2.getString(resources2, i, new Object[0]));
                }
            }
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredWidth = inflate.getMeasuredWidth();
            int measuredHeight = inflate.getMeasuredHeight();
            final ImageView imageView = getBinding().btnExpressPass;
            Intrinsics.checkNotNullExpressionValue(imageView, "btnExpressPass");
            if (imageView.isAttachedToWindow()) {
                this.tooltipPopView = inflate;
                PopupWindow popupWindow = new PopupWindow(inflate, measuredWidth, measuredHeight, true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0));
                popupWindow.setElevation(12.0f * f);
                ImageView imageView2 = getBinding().btnExpressPass;
                Intrinsics.checkNotNullExpressionValue(imageView2, "btnExpressPass");
                int[] iArr = new int[2];
                imageView2.getLocationInWindow(iArr);
                popupWindow.showAsDropDown(imageView2, ((int) (18 * f)) - iArr[0], -(measuredHeight + ((int) (32 * f))));
                this.expressPassTogglePopWindow = popupWindow;
                Runnable runnable = new Runnable() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda42
                    @Override // java.lang.Runnable
                    public final void run() {
                        InputFragment.showExpressPassToggleTooltip$lambda$108(InputFragment.this, imageView, inflate, f);
                    }
                };
                this.tooltipArrowRunnable = runnable;
                inflate.post(runnable);
                inflate.setAlpha(0.0f);
                inflate.setTranslationY(f * 6.0f);
                inflate.animate().alpha(1.0f).translationY(0.0f).setDuration(220L).setInterpolator(new DecelerateInterpolator()).start();
                Runnable runnable2 = new Runnable() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda43
                    @Override // java.lang.Runnable
                    public final void run() {
                        InputFragment.this.dismissExpressPassToggleTooltip();
                    }
                };
                this.tooltipDismissRunnable = runnable2;
                Intrinsics.checkNotNull(runnable2);
                inflate.postDelayed(runnable2, 2000L);
            }
        } catch (Throwable unused) {
            dismissExpressPassToggleTooltip();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showExpressPassToggleTooltip$lambda$108(InputFragment inputFragment, ImageView imageView, View view, float f) {
        if (inputFragment._binding == null) {
            return;
        }
        imageView.getLocationOnScreen(new int[2]);
        view.getLocationOnScreen(new int[2]);
        float width = (r0[0] + (imageView.getWidth() / 2.0f)) - r3[0];
        Drawable background = view.getBackground();
        BubbleDrawable bubbleDrawable = background instanceof BubbleDrawable ? (BubbleDrawable) background : null;
        if (bubbleDrawable != null) {
            bubbleDrawable.setArrowCenterX(width / f, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissExpressPassToggleTooltip() {
        View contentView;
        ViewPropertyAnimator animate;
        try {
            View view = this.tooltipPopView;
            if (view != null) {
                Runnable runnable = this.tooltipArrowRunnable;
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
                Runnable runnable2 = this.tooltipDismissRunnable;
                if (runnable2 != null) {
                    view.removeCallbacks(runnable2);
                }
            }
            this.tooltipArrowRunnable = null;
            this.tooltipDismissRunnable = null;
            PopupWindow popupWindow = this.expressPassTogglePopWindow;
            if (popupWindow != null && (contentView = popupWindow.getContentView()) != null && (animate = contentView.animate()) != null) {
                animate.cancel();
            }
            PopupWindow popupWindow2 = this.expressPassTogglePopWindow;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
            }
            this.expressPassTogglePopWindow = null;
            this.tooltipPopView = null;
        } catch (Throwable unused) {
        }
    }

    public final void showDeviceTipsPopWindow() {
        try {
            if (this._binding == null || AccountSettingsKeva.INSTANCE.getKeva().getBoolean(KEY_DEVICE_TIPS_SHOWN, false)) {
                return;
            }
            AccountSettingsKeva.INSTANCE.getKeva().storeBoolean(KEY_DEVICE_TIPS_SHOWN, true);
            dismissDeviceTipsPopWindow();
            float f = getResources().getDisplayMetrics().density;
            View inflate = LayoutInflater.from(requireContext()).inflate(C0637R.layout.trae_device_tips_pop_window, (ViewGroup) null);
            View findViewById = inflate.findViewById(C0637R.id.iv_close);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda29
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        InputFragment.this.dismissDeviceTipsPopWindow();
                    }
                });
            }
            inflate.measure(View.MeasureSpec.makeMeasureSpec((int) (246 * f), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredWidth = inflate.getMeasuredWidth();
            int measuredHeight = inflate.getMeasuredHeight();
            PopupWindow popupWindow = new PopupWindow(inflate, measuredWidth, measuredHeight, true);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            popupWindow.setElevation(0.0f);
            popupWindow.setAnimationStyle(0);
            ImageView imageView = getBinding().ivCloudIcon;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivCloudIcon");
            int[] iArr = new int[2];
            imageView.getLocationInWindow(iArr);
            int i = (int) (16 * f);
            popupWindow.showAsDropDown(imageView, RangesKt.coerceIn((iArr[0] + (imageView.getWidth() / 2)) - ((int) (53 * f)), i, (getResources().getDisplayMetrics().widthPixels - i) - measuredWidth) - iArr[0], -(measuredHeight + imageView.getHeight()));
            this.deviceTipsPopWindow = popupWindow;
            inflate.setAlpha(0.0f);
            inflate.setTranslationY(f * 6.0f);
            inflate.animate().alpha(1.0f).translationY(0.0f).setDuration(220L).setInterpolator(new DecelerateInterpolator()).start();
        } catch (Throwable unused) {
        }
    }

    public final void dismissDeviceTipsPopWindow() {
        final PopupWindow popupWindow = this.deviceTipsPopWindow;
        if (popupWindow == null) {
            return;
        }
        this.deviceTipsPopWindow = null;
        View contentView = popupWindow.getContentView();
        if (contentView == null) {
            popupWindow.dismiss();
        } else {
            contentView.animate().alpha(0.0f).translationY(getResources().getDisplayMetrics().density * 4.0f).setDuration(180L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: com.bytedance.trae.conversation.widget.InputFragment$$ExternalSyntheticLambda49
                @Override // java.lang.Runnable
                public final void run() {
                    popupWindow.dismiss();
                }
            }).start();
        }
    }

    /* compiled from: InputFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/widget/InputFragment$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_CODE_RECORD_AUDIO", "", "PLEASE_SPEAK_DELAY_MS", "", "KEY_DEVICE_TIPS_SHOWN", "HOLD_TO_TALK_DEBOUNCE_MS", "CUSTOM_LONG_PRESS_TIMEOUT_MS", "newInstance", "Lcom/bytedance/trae/conversation/widget/InputFragment;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InputFragment newInstance() {
            return new InputFragment();
        }
    }
}
