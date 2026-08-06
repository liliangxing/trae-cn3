package com.bytedance.trae.home.solo.task;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.sysoptimizer.SuspendByPeerOpt;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.ContextMenuPopupWindow;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.ConversationActivity;
import com.bytedance.trae.conversation.extract.ExtractHelper;
import com.bytedance.trae.conversation.extract.FileLogger;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet;
import com.bytedance.trae.home.solo.setting.CmpAccountSettingsBottomSheet;
import com.bytedance.trae.home.solo.setting.platform.CmpPageSettings;
import com.bytedance.trae.home.solo.task.FilterOption;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.settings.api.feature.Feature;
import com.bytedance.trae.settings.api.feature.FeatureCapability;
import com.bytedance.trae.utils.logger.FLogger;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.common.util.ToolUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: TaskFragment.kt */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002cdB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010&\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020%H\u0016J\b\u0010*\u001a\u00020%H\u0016J\b\u0010+\u001a\u00020%H\u0016J\u0010\u0010,\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001dH\u0002J \u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0014H\u0002J\u0018\u00101\u001a\u00020%2\u0006\u00102\u001a\u0002032\u0006\u00100\u001a\u00020\u0014H\u0002J\u0010\u00104\u001a\u00020%2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00105\u001a\u00020%2\u0006\u00102\u001a\u000203H\u0002J\u0018\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020%H\u0002J\u0010\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020\u001dH\u0002J\u0010\u0010=\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001dH\u0002J\u001a\u0010>\u001a\u00020%2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020\u0011H\u0002J \u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020FH\u0002J&\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u00142\f\u0010K\u001a\b\u0012\u0004\u0012\u00020%0LH\u0002J\u001e\u0010M\u001a\u00020%2\u0006\u0010I\u001a\u00020\u00142\f\u0010K\u001a\b\u0012\u0004\u0012\u00020%0LH\u0002J\b\u0010O\u001a\u00020%H\u0002J\u0010\u0010P\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020RH\u0002JL\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020U2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010V\u001a\u0004\u0018\u00010\u001d2\b\u0010W\u001a\u0004\u0018\u00010\u001d2\b\u0010X\u001a\u0004\u0018\u00010\u001d2\b\u0010Y\u001a\u0004\u0018\u00010Z2\b\u0010[\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\\\u001a\u00020%H\u0002J\u0010\u0010]\u001a\u00020%2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010`\u001a\u00020%2\u0006\u0010a\u001a\u00020bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "viewModel", "Lcom/bytedance/trae/home/solo/task/TaskViewModel;", "adapter", "Lcom/bytedance/trae/home/solo/task/TaskAdapter;", "swipeRefresh", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "filterPopup", "Landroid/widget/PopupWindow;", "actionPopup", "Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;", "isFilterOpen", "", "shouldScrollToTop", "suppressNextTopChangedScrollTaskId", "", "isFirstResume", "hasSuspendByPeerCrashFixed", "isSearchHeaderRendered", "operationIconVisibilityBeforeSearch", "", "defaultTaskListItemAnimator", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupTaskTitleBar", "Lcom/bytedance/trae/common/widget/TraeTitleBar;", "onResume", "onPause", "onDestroyView", "setupHeader", "renderSearchHeader", "root", "isSearchMode", "query", "syncSearchInputText", "searchInput", "Landroid/widget/EditText;", "requestSearchInputFocus", "hideKeyboard", "showFilterPopup", "anchor", "chevron", "Landroid/widget/ImageView;", "dismissFilterPopup", "setupFilterItems", "popupView", "setupRecyclerView", "setTaskListItemAnimationsSuppressed", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "suppress", "showActionPopup", "task", "Lcom/bytedance/trae/home/solo/task/TaskModel;", "rawX", "", "rawY", "showRenameDialog", "taskId", "currentTitle", "closeAction", "Lkotlin/Function0;", "showDeleteDialog", "topTaskId", "observeViewModel", "titleForFilter", "filter", "Lcom/bytedance/trae/home/solo/task/FilterOption;", "renderTaskContent", "state", "Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;", "emptyStateView", "searchLoadingView", "searchEmptyView", "searchEmptyText", "Landroid/widget/TextView;", "networkErrorView", "observeCustomActivity", "loadAvatar", "iv", "Lcom/facebook/drawee/view/SimpleDraweeView;", "fixSuspendByPeerCrash", "context", "Landroid/content/Context;", "RawTaskContentState", "TaskContentState", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskFragment extends Fragment {
    public static final int $stable = 8;
    private ContextMenuPopupWindow actionPopup;
    private TaskAdapter adapter;
    private RecyclerView.ItemAnimator defaultTaskListItemAnimator;
    private PopupWindow filterPopup;
    private boolean hasSuspendByPeerCrashFixed;
    private boolean isFilterOpen;
    private boolean isSearchHeaderRendered;
    private boolean shouldScrollToTop;
    private String suppressNextTopChangedScrollTaskId;
    private SwipeRefreshLayout swipeRefresh;
    private String topTaskId;
    private TaskViewModel viewModel;
    private final FpsTracer fpsTracer = new FpsTracer(NewTaskTracker.EnterFrom.TASK_LIST, false);
    private boolean isFirstResume = true;
    private int operationIconVisibilityBeforeSearch = 8;

    public static final Unit extractConversation(TaskFragment taskFragment, TaskModel taskModel) {
        Conversation conversation;
        String id;
        try {
            Log.e("ExtractConversation", ">>> extractConversation() entered <<<");
            FileLogger.log("ExtractConversation", ">>> extractConversation() entered <<<");
            Context requireActivity = taskFragment.requireActivity();
            Toast.makeText(requireActivity, "[Extract] A: entered", 1).show();
            String title = taskModel.getTitle();
            if (title == null) {
                title = "conversation";
            }
            String id2 = taskModel.getId();
            if (id2 == null) {
                id2 = "";
            }
            String str = id2;
            Toast.makeText(requireActivity, "[Extract] B: title=" + title + " id=" + str, 1).show();
            TaskViewModel taskViewModel = taskFragment.viewModel;
            if (taskViewModel != null && (conversation = taskViewModel.getConversation(id2)) != null && (id = conversation.getId()) != null) {
                str = id;
            }
            Toast.makeText(requireActivity, "[Extract] C: calling helper taskId=" + str, 1).show();
            Activity activity = (Activity) requireActivity;
            ExtractHelper.INSTANCE.start(activity, str, title);
            Toast.makeText(activity, "[Extract] D: helper returned OK", 1).show();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            Log.e("ExtractConversation", "Failed", th);
            FileLogger.log("ExtractConversation", "Failed", th);
            try {
                Context requireActivity2 = taskFragment.requireActivity();
                StringBuilder sb = new StringBuilder();
                sb.append("[Extract] ERROR: ");
                String message = th.getMessage();
                if (message == null) {
                    message = th.getClass().getName();
                }
                sb.append(message);
                Toast.makeText(requireActivity2, sb.toString(), 1).show();
            } catch (Throwable th2) {
                Log.e("ExtractConversation", "Catch toast also failed", th2);
            }
            return Unit.INSTANCE;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_task, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModelStoreOwner requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.viewModel = new ViewModelProvider(requireActivity).get(TaskViewModel.class);
        TraeTitleBar traeTitleBar = setupTaskTitleBar(view);
        setupRecyclerView(view);
        setupHeader(view);
        observeViewModel();
        final SimpleDraweeView taskAvatarView = traeTitleBar.getTaskAvatarView();
        loadAvatar(taskAvatarView);
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        AccountInfo accountInfo = iLoginService != null ? iLoginService.getAccountInfo() : null;
        boolean areEqual = Intrinsics.areEqual(accountInfo != null ? accountInfo.getLoginPlatform() : null, ThirdPartyTokenRepository.TYPE_BYTECLOUD);
        traeTitleBar.setTaskAvatarBadgeVisible(areEqual);
        traeTitleBar.setOnTaskAvatarClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TaskFragment.onViewCreated$lambda$0(TaskFragment.this, view2);
            }
        });
        boolean z = (accountInfo != null ? accountInfo.getAccountType() : null) == AccountType.TOB;
        if (z) {
            traeTitleBar.setTaskEnterpriseMode(true);
        }
        ViewGroup viewGroup = (ViewGroup) view.findViewById(C0820R.id.fl_avatar_container);
        if (!areEqual && !z) {
            View view2 = new View(requireContext());
            view2.setId(C0820R.id.v_unread_dot);
            int i = (int) (8 * view2.getResources().getDisplayMetrics().density);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i, 8388661);
            layoutParams.topMargin = i;
            layoutParams.setMarginEnd(i);
            view2.setLayoutParams(layoutParams);
            view2.setBackgroundResource(C0820R.drawable.bg_solo_notification_dot);
            view2.setVisibility(8);
            viewGroup.addView(view2);
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new TaskFragment$onViewCreated$2(view2, null), 3, (Object) null);
        }
        getChildFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$onViewCreated$3
            public void onFragmentDestroyed(FragmentManager fm, Fragment f) {
                Intrinsics.checkNotNullParameter(fm, "fm");
                Intrinsics.checkNotNullParameter(f, "f");
                if ((f instanceof AccountSettingsBottomSheet) || (f instanceof CmpAccountSettingsBottomSheet)) {
                    TaskFragment.this.loadAvatar(taskAvatarView);
                }
            }
        }, false);
        View findViewById = view.findViewById(C0820R.id.btn_retry_network);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    TaskFragment.onViewCreated$lambda$3(TaskFragment.this, view3);
                }
            });
        }
        view.findViewById(C0820R.id.fab_add).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TaskFragment.onViewCreated$lambda$5(TaskFragment.this, view3);
            }
        });
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        fixSuspendByPeerCrash(requireContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(TaskFragment taskFragment, View view) {
        if (!taskFragment.getChildFragmentManager().isStateSaved() && taskFragment.getChildFragmentManager().findFragmentByTag(AccountSettingsBottomSheet.TAG) == null && taskFragment.getChildFragmentManager().findFragmentByTag(CmpAccountSettingsBottomSheet.TAG) == null) {
            if (CmpPageSettings.INSTANCE.isSettingsEntryEnabled()) {
                CmpAccountSettingsBottomSheet.INSTANCE.newInstance().show(taskFragment.getChildFragmentManager(), CmpAccountSettingsBottomSheet.TAG);
            } else {
                AccountSettingsBottomSheet.INSTANCE.newInstance().show(taskFragment.getChildFragmentManager(), AccountSettingsBottomSheet.TAG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(TaskFragment taskFragment, View view) {
        TaskViewModel taskViewModel = taskFragment.viewModel;
        if (taskViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            taskViewModel = null;
        }
        taskViewModel.retry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(TaskFragment taskFragment, View view) {
        Intent intent = new Intent(taskFragment.requireContext(), Class.forName("com.bytedance.trae.conversation.ConversationActivity"));
        intent.putExtra(ConversationActivity.EXTRA_ENTER_FROM, NewTaskTracker.EnterFrom.TASK_LIST);
        taskFragment.startActivity(intent);
    }

    private final TraeTitleBar setupTaskTitleBar(View view) {
        View findViewById = view.findViewById(C0820R.id.title_bar);
        TraeTitleBar traeTitleBar = (TraeTitleBar) findViewById;
        traeTitleBar.showTaskListHeader();
        traeTitleBar.setTitle(C0820R.string.solo_task_title);
        traeTitleBar.setTaskHeaderViewIds(C0820R.id.ll_title_filter, C0820R.id.tv_title, C0820R.id.iv_chevron, C0820R.id.btn_task_search_entry, C0820R.id.fl_avatar_container, C0820R.id.iv_avatar, C0820R.id.iv_bytecloud_badge, C0820R.id.iv_operation_icon);
        traeTitleBar.setTaskTitleTrailingIcon(C0820R.drawable.ic_solo_drop_down);
        traeTitleBar.setTaskSearchIcon(C0820R.drawable.ic_task_search);
        traeTitleBar.setTaskSearchContentDescription(getString(C0820R.string.solo_task_search_entry_content_description));
        traeTitleBar.setTaskSearchButtonVisible(FeatureCapability.INSTANCE.isEnabled(Feature.TASK_LIST_SEARCH));
        traeTitleBar.setTaskAvatarBadgeImageResource(C0820R.drawable.trae_ic_bytecloud_badge_small);
        Intrinsics.checkNotNullExpressionValue(findViewById, "apply(...)");
        return traeTitleBar;
    }

    public void onResume() {
        int i;
        int i2;
        super.onResume();
        TaskViewModel taskViewModel = this.viewModel;
        if (taskViewModel != null) {
            TaskViewModel taskViewModel2 = null;
            if (taskViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                taskViewModel = null;
            }
            taskViewModel.forceLoadTasks();
            TaskViewModel taskViewModel3 = this.viewModel;
            if (taskViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                taskViewModel3 = null;
            }
            taskViewModel3.loadDevices();
            TaskViewModel taskViewModel4 = this.viewModel;
            if (taskViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                taskViewModel4 = null;
            }
            taskViewModel4.startPollingIfNeeded();
            String str = this.isFirstResume ? "new_create" : "";
            int i3 = 0;
            this.isFirstResume = false;
            TaskViewModel taskViewModel5 = this.viewModel;
            if (taskViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                taskViewModel2 = taskViewModel5;
            }
            List list = (List) taskViewModel2.getTasks().getValue();
            NewTaskTracker newTaskTracker = NewTaskTracker.INSTANCE;
            int size = list.size();
            List list2 = list;
            boolean z = list2 instanceof Collection;
            if (z && list2.isEmpty()) {
                i = 0;
            } else {
                Iterator it = list2.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((TaskModel) it.next()).getCliType(), "local_ide") && (i4 = i4 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
                i = i4;
            }
            if (z && list2.isEmpty()) {
                i2 = 0;
            } else {
                Iterator it2 = list2.iterator();
                int i5 = 0;
                while (it2.hasNext()) {
                    if (Intrinsics.areEqual(((TaskModel) it2.next()).getCliType(), "local") && (i5 = i5 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
                i2 = i5;
            }
            if (!z || !list2.isEmpty()) {
                Iterator it3 = list2.iterator();
                while (it3.hasNext()) {
                    if (Intrinsics.areEqual(((TaskModel) it3.next()).getCliType(), "remote") && (i3 = i3 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            newTaskTracker.trackTaskListPageView(size, str, i, i2, i3);
        }
    }

    public void onPause() {
        super.onPause();
        TaskViewModel taskViewModel = this.viewModel;
        if (taskViewModel != null) {
            if (taskViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                taskViewModel = null;
            }
            taskViewModel.stopPolling();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        PopupWindow popupWindow = this.filterPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.filterPopup = null;
        ContextMenuPopupWindow contextMenuPopupWindow = this.actionPopup;
        if (contextMenuPopupWindow != null) {
            contextMenuPopupWindow.dismiss();
        }
        this.actionPopup = null;
    }

    private final void setupHeader(View view) {
        TraeTitleBar traeTitleBar = (TraeTitleBar) view.findViewById(C0820R.id.title_bar);
        final ImageView imageView = (ImageView) view.findViewById(C0820R.id.iv_chevron);
        final View findViewById = view.findViewById(C0820R.id.ll_title_filter);
        EditText editText = (EditText) view.findViewById(C0820R.id.et_task_search);
        View findViewById2 = view.findViewById(C0820R.id.btn_task_search_clear);
        View findViewById3 = view.findViewById(C0820R.id.btn_task_search_exit);
        traeTitleBar.setOnTaskTitleClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TaskFragment.setupHeader$lambda$10(TaskFragment.this, findViewById, imageView, view2);
            }
        });
        traeTitleBar.setOnTaskSearchClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TaskFragment.setupHeader$lambda$11(TaskFragment.this, view2);
            }
        });
        Intrinsics.checkNotNull(editText);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$setupHeader$$inlined$doAfterTextChanged$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                TaskViewModel taskViewModel;
                taskViewModel = TaskFragment.this.viewModel;
                if (taskViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    taskViewModel = null;
                }
                String obj = s != null ? s.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                taskViewModel.updateSearchQuery(obj);
            }
        });
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TaskFragment.setupHeader$lambda$13(TaskFragment.this, view2);
            }
        });
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TaskFragment.setupHeader$lambda$14(TaskFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupHeader$lambda$10(TaskFragment taskFragment, View view, ImageView imageView, View view2) {
        TaskAdapter taskAdapter = taskFragment.adapter;
        if (taskAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            taskAdapter = null;
        }
        taskAdapter.closeOpenItem();
        if (taskFragment.isFilterOpen) {
            taskFragment.dismissFilterPopup();
            return;
        }
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNull(imageView);
        taskFragment.showFilterPopup(view, imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupHeader$lambda$11(TaskFragment taskFragment, View view) {
        TaskAdapter taskAdapter = taskFragment.adapter;
        TaskViewModel taskViewModel = null;
        if (taskAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            taskAdapter = null;
        }
        taskAdapter.closeOpenItem();
        taskFragment.dismissFilterPopup();
        TaskViewModel taskViewModel2 = taskFragment.viewModel;
        if (taskViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            taskViewModel = taskViewModel2;
        }
        taskViewModel.enterSearchMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupHeader$lambda$13(TaskFragment taskFragment, View view) {
        TaskViewModel taskViewModel = taskFragment.viewModel;
        if (taskViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            taskViewModel = null;
        }
        taskViewModel.clearSearchQuery();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupHeader$lambda$14(TaskFragment taskFragment, View view) {
        TaskViewModel taskViewModel = taskFragment.viewModel;
        if (taskViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            taskViewModel = null;
        }
        taskViewModel.exitSearchMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderSearchHeader(View root, boolean isSearchMode, String query) {
        TraeTitleBar traeTitleBar = (TraeTitleBar) root.findViewById(C0820R.id.title_bar);
        View findViewById = root.findViewById(C0820R.id.layout_task_search_header);
        EditText editText = (EditText) root.findViewById(C0820R.id.et_task_search);
        View findViewById2 = root.findViewById(C0820R.id.btn_task_search_clear);
        View findViewById3 = root.findViewById(C0820R.id.fab_add);
        if (isSearchMode) {
            if (!this.isSearchHeaderRendered) {
                this.operationIconVisibilityBeforeSearch = traeTitleBar.getTaskOperationVisible() ? 0 : 8;
            }
            this.isSearchHeaderRendered = true;
            traeTitleBar.setVisibility(4);
            findViewById.setVisibility(0);
            findViewById3.setVisibility(8);
            Intrinsics.checkNotNull(editText);
            syncSearchInputText(editText, query);
            findViewById2.setVisibility(query.length() > 0 ? 0 : 8);
            requestSearchInputFocus(editText);
            return;
        }
        Intrinsics.checkNotNull(editText);
        syncSearchInputText(editText, "");
        findViewById2.setVisibility(8);
        findViewById.setVisibility(8);
        traeTitleBar.setVisibility(0);
        if (this.isSearchHeaderRendered) {
            traeTitleBar.setTaskOperationIconVisible(this.operationIconVisibilityBeforeSearch == 0);
        }
        findViewById3.setVisibility(0);
        this.isSearchHeaderRendered = false;
        hideKeyboard(editText);
    }

    private final void syncSearchInputText(EditText searchInput, String query) {
        Editable text = searchInput.getText();
        String obj = text != null ? text.toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (Intrinsics.areEqual(obj, query)) {
            return;
        }
        searchInput.setText(query);
        searchInput.setSelection(query.length());
    }

    private final void requestSearchInputFocus(final EditText searchInput) {
        if (searchInput.hasFocus()) {
            return;
        }
        searchInput.post(new Runnable() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                TaskFragment.requestSearchInputFocus$lambda$15(TaskFragment.this, searchInput);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestSearchInputFocus$lambda$15(TaskFragment taskFragment, EditText editText) {
        if (taskFragment.isAdded()) {
            TaskViewModel taskViewModel = taskFragment.viewModel;
            if (taskViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                taskViewModel = null;
            }
            if (((Boolean) taskViewModel.isSearchMode().getValue()).booleanValue()) {
                editText.requestFocus();
                Object systemService = taskFragment.requireContext().getSystemService("input_method");
                InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(editText, 1);
                }
            }
        }
    }

    private final void hideKeyboard(EditText searchInput) {
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(searchInput.getWindowToken(), 0);
        }
        searchInput.clearFocus();
    }

    private final void showFilterPopup(View anchor, final ImageView chevron) {
        View inflate = LayoutInflater.from(requireContext()).inflate(C0820R.layout.dialog_task_filter, (ViewGroup) null);
        float f = getResources().getDisplayMetrics().density;
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
        popupWindow.setElevation(8.0f * f);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda12
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                TaskFragment.showFilterPopup$lambda$17$lambda$16(TaskFragment.this, chevron);
            }
        });
        this.filterPopup = popupWindow;
        inflate.setMinimumWidth((int) (200 * f));
        Intrinsics.checkNotNull(inflate);
        setupFilterItems(inflate);
        this.isFilterOpen = true;
        chevron.setRotation(180.0f);
        int i = (int) (8 * f);
        PopupWindow popupWindow2 = this.filterPopup;
        if (popupWindow2 != null) {
            popupWindow2.showAsDropDown(anchor, 0, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFilterPopup$lambda$17$lambda$16(TaskFragment taskFragment, ImageView imageView) {
        taskFragment.isFilterOpen = false;
        imageView.setRotation(0.0f);
    }

    private final void dismissFilterPopup() {
        PopupWindow popupWindow = this.filterPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.filterPopup = null;
    }

    private final void setupFilterItems(View popupView) {
        boolean z;
        boolean z2;
        float f;
        float f2;
        SimpleDraweeView simpleDraweeView;
        TaskViewModel taskViewModel = this.viewModel;
        TaskViewModel taskViewModel2 = null;
        if (taskViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            taskViewModel = null;
        }
        List<DeviceInfo> list = (List) taskViewModel.getDevices().getValue();
        List list2 = list;
        boolean z3 = list2 instanceof Collection;
        if (!z3 || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((DeviceInfo) it.next()).getType(), CliType.LOCAL.getValue())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z3 || !list2.isEmpty()) {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                if (Intrinsics.areEqual(((DeviceInfo) it2.next()).getType(), CliType.IDE.getValue())) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        boolean z4 = z && z2;
        TaskViewModel taskViewModel3 = this.viewModel;
        if (taskViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            taskViewModel2 = taskViewModel3;
        }
        FilterOption filterOption = (FilterOption) taskViewModel2.getSelectedFilter().getValue();
        LinearLayout linearLayout = (LinearLayout) popupView.findViewById(C0820R.id.ll_device_container);
        popupView.findViewById(C0820R.id.iv_check_all).setVisibility(filterOption instanceof FilterOption.All ? 0 : 8);
        if (z4) {
            f = 12;
            f2 = getResources().getDisplayMetrics().density;
        } else {
            f = 8;
            f2 = getResources().getDisplayMetrics().density;
        }
        int i = (int) (f * f2);
        popupView.findViewById(C0820R.id.iv_check_cloud).setVisibility(filterOption instanceof FilterOption.Cloud ? 0 : 8);
        View findViewById = popupView.findViewById(C0820R.id.item_cloud);
        findViewById.setPadding(findViewById.getPaddingLeft(), i, findViewById.getPaddingRight(), i);
        popupView.findViewById(C0820R.id.item_all).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskFragment.setupFilterItems$lambda$20(TaskFragment.this, view);
            }
        });
        View findViewById2 = popupView.findViewById(C0820R.id.item_all);
        findViewById2.setPadding(findViewById2.getPaddingLeft(), i, findViewById2.getPaddingRight(), i);
        popupView.findViewById(C0820R.id.item_cloud).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskFragment.setupFilterItems$lambda$21(TaskFragment.this, view);
            }
        });
        LayoutInflater from = LayoutInflater.from(requireContext());
        for (final DeviceInfo deviceInfo : list) {
            View inflate = from.inflate(C0820R.layout.item_filter_device, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) inflate.findViewById(C0820R.id.tv_device_name);
            ImageView imageView = (ImageView) inflate.findViewById(C0820R.id.iv_device_icon);
            View findViewById3 = inflate.findViewById(C0820R.id.iv_check_device);
            textView.setText(deviceInfo.getName());
            if (!deviceInfo.isOnline()) {
                imageView.setImageResource(C0820R.drawable.ic_solo_filter_computer_off);
            }
            View findViewById4 = inflate.findViewById(C0820R.id.ll_product_tag);
            TextView textView2 = (TextView) inflate.findViewById(C0820R.id.tv_product_type);
            if (!z4) {
                findViewById4.setVisibility(8);
            } else if (Intrinsics.areEqual(deviceInfo.getType(), CliType.LOCAL.getValue())) {
                findViewById4.setVisibility(0);
                findViewById4.setBackgroundResource(C0637R.drawable.trae_bg_trae_work);
                textView2.setText("TRAE Work");
                textView2.setTextColor(ContextCompat.getColor(requireContext(), C0820R.color.solo_filter_tag_trae_work));
            } else if (Intrinsics.areEqual(deviceInfo.getType(), CliType.IDE.getValue())) {
                findViewById4.setVisibility(0);
                findViewById4.setBackgroundResource(C0637R.drawable.trae_bg_trae_ide);
                textView2.setText("TRAE IDE");
                textView2.setTextColor(ContextCompat.getColor(requireContext(), C0820R.color.solo_filter_tag_trae_ide));
            } else {
                findViewById4.setVisibility(8);
            }
            findViewById3.setVisibility(((filterOption instanceof FilterOption.Device) && Intrinsics.areEqual(((FilterOption.Device) filterOption).getCliId(), deviceInfo.getCliId())) ? 0 : 8);
            inflate.findViewById(C0820R.id.item_device).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskFragment.setupFilterItems$lambda$22(TaskFragment.this, deviceInfo, view);
                }
            });
            linearLayout.addView(inflate);
        }
        View view = getView();
        if (view == null || (simpleDraweeView = (SimpleDraweeView) view.findViewById(C0820R.id.iv_avatar)) == null) {
            return;
        }
        loadAvatar(simpleDraweeView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFilterItems$lambda$20(TaskFragment taskFragment, View view) {
        TextView textView;
        TaskViewModel taskViewModel = taskFragment.viewModel;
        if (taskViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            taskViewModel = null;
        }
        taskViewModel.setFilter(FilterOption.All.INSTANCE);
        View view2 = taskFragment.getView();
        if (view2 != null && (textView = (TextView) view2.findViewById(C0820R.id.tv_title)) != null) {
            textView.setText(taskFragment.getString(C0820R.string.solo_task_title));
        }
        taskFragment.dismissFilterPopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFilterItems$lambda$21(TaskFragment taskFragment, View view) {
        TextView textView;
        TaskViewModel taskViewModel = taskFragment.viewModel;
        if (taskViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            taskViewModel = null;
        }
        taskViewModel.setFilter(FilterOption.Cloud.INSTANCE);
        View view2 = taskFragment.getView();
        if (view2 != null && (textView = (TextView) view2.findViewById(C0820R.id.tv_title)) != null) {
            textView.setText(taskFragment.getString(C0820R.string.solo_filter_cloud));
        }
        taskFragment.dismissFilterPopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFilterItems$lambda$22(TaskFragment taskFragment, DeviceInfo deviceInfo, View view) {
        TextView textView;
        TaskViewModel taskViewModel = taskFragment.viewModel;
        if (taskViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            taskViewModel = null;
        }
        taskViewModel.setFilter(new FilterOption.Device(deviceInfo.getCliId(), deviceInfo.getName()));
        View view2 = taskFragment.getView();
        if (view2 != null && (textView = (TextView) view2.findViewById(C0820R.id.tv_title)) != null) {
            textView.setText(deviceInfo.getName());
        }
        taskFragment.dismissFilterPopup();
    }

    private final void setupRecyclerView(View view) {
        RecyclerView findViewById = view.findViewById(C0820R.id.rv_tasks);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        RecyclerView recyclerView = findViewById;
        this.fpsTracer.startRecyclerView(recyclerView);
        SwipeRefreshLayout findViewById2 = view.findViewById(C0820R.id.swipe_refresh);
        this.swipeRefresh = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda13
                public final void onRefresh() {
                    TaskFragment.setupRecyclerView$lambda$24(TaskFragment.this);
                }
            });
        }
        this.adapter = new TaskAdapter(new Function2() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda14
            public final Object invoke(Object obj, Object obj2) {
                Unit unit;
                unit = TaskFragment.setupRecyclerView$lambda$26(TaskFragment.this, (TaskModel) obj, ((Integer) obj2).intValue());
                return unit;
            }
        }, new Function1() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                Unit unit;
                unit = TaskFragment.setupRecyclerView$lambda$27((TaskModel) obj);
                return unit;
            }
        }, new Function3() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda16
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit unit;
                unit = TaskFragment.setupRecyclerView$lambda$28(TaskFragment.this, (TaskModel) obj, ((Float) obj2).floatValue(), ((Float) obj3).floatValue());
                return unit;
            }
        }, new Function2() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda17
            public final Object invoke(Object obj, Object obj2) {
                Unit unit;
                unit = TaskFragment.setupRecyclerView$lambda$29(TaskFragment.this, (TaskModel) obj, (Function0) obj2);
                return unit;
            }
        }, new Function2() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda18
            public final Object invoke(Object obj, Object obj2) {
                Unit unit;
                unit = TaskFragment.setupRecyclerView$lambda$30(TaskFragment.this, (TaskModel) obj, (Function0) obj2);
                return unit;
            }
        }, new Function2() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda19
            public final Object invoke(Object obj, Object obj2) {
                Unit unit;
                unit = TaskFragment.setupRecyclerView$lambda$31(TaskFragment.this, (TaskModel) obj, (Function0) obj2);
                return unit;
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        TaskAdapter taskAdapter = this.adapter;
        if (taskAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            taskAdapter = null;
        }
        recyclerView.setAdapter((RecyclerView.Adapter) taskAdapter);
        this.defaultTaskListItemAnimator = recyclerView.getItemAnimator();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$setupRecyclerView$8
            public void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                TaskAdapter taskAdapter2;
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                if (newState == 1) {
                    taskAdapter2 = TaskFragment.this.adapter;
                    if (taskAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        taskAdapter2 = null;
                    }
                    taskAdapter2.closeOpenItem();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRecyclerView$lambda$24(TaskFragment taskFragment) {
        TaskViewModel taskViewModel = taskFragment.viewModel;
        if (taskViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            taskViewModel = null;
        }
        taskViewModel.refreshTasks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupRecyclerView$lambda$26(TaskFragment taskFragment, TaskModel taskModel, int i) {
        Intrinsics.checkNotNullParameter(taskModel, "task");
        NewTaskTracker newTaskTracker = NewTaskTracker.INSTANCE;
        String id = taskModel.getId();
        String lowerCase = taskModel.getStatus().getLabel().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        newTaskTracker.trackTaskCardClick(id, lowerCase, i);
        Intent intent = new Intent(taskFragment.requireContext(), (Class<?>) ConversationActivity.class);
        String searchAnchorCreatedAtMs = taskModel.getSearchAnchorCreatedAtMs();
        if (searchAnchorCreatedAtMs != null) {
            intent.putExtra(ConversationActivity.EXTRA_ANCHOR_CREATED_AT_MS, searchAnchorCreatedAtMs);
        }
        intent.putExtra(ConversationActivity.EXTRA_ENTER_FROM, NewTaskTracker.EnterFrom.TASK_LIST);
        TaskViewModel taskViewModel = taskFragment.viewModel;
        if (taskViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            taskViewModel = null;
        }
        Conversation conversation = taskViewModel.getConversation(taskModel.getId());
        if (conversation == null) {
            String id2 = taskModel.getId();
            String title = taskModel.getTitle();
            String cliId = taskModel.getCliId();
            String mode = taskModel.getMode();
            String cliType = taskModel.getCliType();
            String valueOf = String.valueOf(taskModel.getStatus().getStatusCode());
            boolean isPinned = taskModel.isPinned();
            String pinnedAt = taskModel.getPinnedAt();
            String updatedAt = taskModel.getUpdatedAt();
            String lowerCase2 = taskModel.getIconType().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            conversation = new Conversation(id2, null, null, null, null, cliId, title, null, null, mode, valueOf, cliType, null, null, null, null, updatedAt, null, lowerCase2, null, null, null, null, null, Boolean.valueOf(isPinned), pinnedAt, 16445854, null);
        }
        if (Intrinsics.areEqual(conversation.getEnvironment(), CliType.REMOTE.getValue())) {
            intent.putExtra(ConversationActivity.EXTRA_CONVERSATION, conversation);
            intent.putExtra(ConversationActivity.EXTRA_ICON_TYPE, taskModel.getIconType());
            taskFragment.startActivity(intent);
        } else if (CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId()) != null) {
            conversation.setEnvironment(CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId()));
            intent.putExtra(ConversationActivity.EXTRA_CONVERSATION, conversation);
            intent.putExtra(ConversationActivity.EXTRA_ICON_TYPE, taskModel.getIconType());
            taskFragment.startActivity(intent);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupRecyclerView$lambda$27(TaskModel taskModel) {
        Intrinsics.checkNotNullParameter(taskModel, "task");
        NewTaskTracker.INSTANCE.trackTaskCardSlide(taskModel.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupRecyclerView$lambda$28(TaskFragment taskFragment, TaskModel taskModel, float f, float f2) {
        Intrinsics.checkNotNullParameter(taskModel, "task");
        taskFragment.showActionPopup(taskModel, f, f2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupRecyclerView$lambda$29(TaskFragment taskFragment, TaskModel taskModel, Function0 function0) {
        Intrinsics.checkNotNullParameter(taskModel, "task");
        Intrinsics.checkNotNullParameter(function0, "closeAction");
        TaskViewModel taskViewModel = null;
        if (taskModel.isPinned()) {
            TaskViewModel taskViewModel2 = taskFragment.viewModel;
            if (taskViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                taskViewModel = taskViewModel2;
            }
            taskViewModel.unpinConversation(taskModel);
        } else {
            taskFragment.suppressNextTopChangedScrollTaskId = taskModel.getId();
            TaskViewModel taskViewModel3 = taskFragment.viewModel;
            if (taskViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                taskViewModel = taskViewModel3;
            }
            taskViewModel.pinConversation(taskModel);
        }
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupRecyclerView$lambda$30(TaskFragment taskFragment, TaskModel taskModel, Function0 function0) {
        Intrinsics.checkNotNullParameter(taskModel, "task");
        Intrinsics.checkNotNullParameter(function0, "closeAction");
        NewTaskTracker.INSTANCE.trackTaskRenameClick(taskModel.getId());
        taskFragment.showRenameDialog(taskModel.getId(), taskModel.getTitle(), function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupRecyclerView$lambda$31(TaskFragment taskFragment, TaskModel taskModel, Function0 function0) {
        Intrinsics.checkNotNullParameter(taskModel, "task");
        Intrinsics.checkNotNullParameter(function0, "closeAction");
        NewTaskTracker.INSTANCE.trackTaskDeleteClick(taskModel.getId());
        taskFragment.showDeleteDialog(taskModel.getId(), function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTaskListItemAnimationsSuppressed(RecyclerView recyclerView, boolean suppress) {
        if (recyclerView == null) {
            return;
        }
        if (suppress) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator != null) {
                itemAnimator.endAnimations();
            }
            recyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
            return;
        }
        if (recyclerView.getItemAnimator() == null) {
            recyclerView.setItemAnimator(this.defaultTaskListItemAnimator);
        }
    }

    private final void showActionPopup(final TaskModel task, float rawX, float rawY) {
        int i;
        int i2;
        ContextMenuPopupWindow contextMenuPopupWindow = this.actionPopup;
        if (contextMenuPopupWindow != null) {
            contextMenuPopupWindow.dismiss();
        }
        TaskAdapter taskAdapter = this.adapter;
        if (taskAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            taskAdapter = null;
        }
        taskAdapter.closeOpenItem();
        List createListBuilder = CollectionsKt.createListBuilder();
        String string = getString(C0637R.string.trae_conversation_menu_extract);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        createListBuilder.add(new ContextMenuPopupWindow.Item(C0637R.drawable.file_document, string, false, null, null, C0637R.id.menu_extract, new Function0() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda27
            public final Object invoke() {
                Log.e("ExtractConversation", ">>> Lambda27.invoke() CLICKED - button was tapped <<<");
                try {
                    Toast.makeText(TaskFragment.this.requireActivity(), "[Extract] Button clicked!", 1).show();
                } catch (Throwable th) {
                    Log.e("ExtractConversation", "Toast0 failed", th);
                }
                FileLogger.log("ExtractConversation", "Lambda27.invoke() calling extractConversation");
                TaskFragment.extractConversation(TaskFragment.this, task);
                return Unit.INSTANCE;
            }
        }, 28, null));
        if (task.getSupportsPin() && FeatureCapability.INSTANCE.isEnabled(Feature.TASK_LIST_PIN)) {
            if (task.isPinned()) {
                i = C0591R.drawable.trae_ic_context_menu_unpin;
            } else {
                i = C0591R.drawable.trae_ic_context_menu_pin;
            }
            int i3 = i;
            if (task.isPinned()) {
                i2 = C0820R.string.solo_context_menu_unpin;
            } else {
                i2 = C0820R.string.solo_context_menu_pin;
            }
            String string2 = getString(i2);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            createListBuilder.add(new ContextMenuPopupWindow.Item(i3, string2, false, null, null, C0820R.id.menu_pin, new Function0() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda24
                public final Object invoke() {
                    Unit showActionPopup$lambda$37$lambda$32;
                    showActionPopup$lambda$37$lambda$32 = TaskFragment.showActionPopup$lambda$37$lambda$32(TaskModel.this, this);
                    return showActionPopup$lambda$37$lambda$32;
                }
            }, 28, null));
        }
        int i4 = C0591R.drawable.trae_ic_context_menu_rename;
        String string3 = getString(C0820R.string.solo_context_menu_rename);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        createListBuilder.add(new ContextMenuPopupWindow.Item(i4, string3, false, null, null, C0820R.id.menu_rename, new Function0() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda25
            public final Object invoke() {
                Unit showActionPopup$lambda$37$lambda$34;
                showActionPopup$lambda$37$lambda$34 = TaskFragment.showActionPopup$lambda$37$lambda$34(TaskFragment.this, task);
                return showActionPopup$lambda$37$lambda$34;
            }
        }, 28, null));
        int i5 = C0591R.drawable.trae_ic_context_menu_delete;
        String string4 = getString(C0820R.string.solo_context_menu_delete);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        createListBuilder.add(new ContextMenuPopupWindow.Item(i5, string4, true, null, null, C0820R.id.menu_delete, new Function0() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda26
            public final Object invoke() {
                Unit showActionPopup$lambda$37$lambda$36;
                showActionPopup$lambda$37$lambda$36 = TaskFragment.showActionPopup$lambda$37$lambda$36(TaskFragment.this, task);
                return showActionPopup$lambda$37$lambda$36;
            }
        }, 24, null));
        List build = CollectionsKt.build(createListBuilder);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        ContextMenuPopupWindow contextMenuPopupWindow2 = new ContextMenuPopupWindow(requireContext, build, 0, 4, null);
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView(...)");
        contextMenuPopupWindow2.showNear(requireView, rawX, rawY);
        this.actionPopup = contextMenuPopupWindow2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showActionPopup$lambda$37$lambda$32(TaskModel taskModel, TaskFragment taskFragment) {
        TaskViewModel taskViewModel = null;
        if (taskModel.isPinned()) {
            TaskViewModel taskViewModel2 = taskFragment.viewModel;
            if (taskViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                taskViewModel = taskViewModel2;
            }
            taskViewModel.unpinConversation(taskModel);
        } else {
            taskFragment.suppressNextTopChangedScrollTaskId = taskModel.getId();
            TaskViewModel taskViewModel3 = taskFragment.viewModel;
            if (taskViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                taskViewModel = taskViewModel3;
            }
            taskViewModel.pinConversation(taskModel);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showActionPopup$lambda$37$lambda$34(TaskFragment taskFragment, TaskModel taskModel) {
        taskFragment.showRenameDialog(taskModel.getId(), taskModel.getTitle(), new Function0() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda23
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showActionPopup$lambda$37$lambda$36(TaskFragment taskFragment, TaskModel taskModel) {
        taskFragment.showDeleteDialog(taskModel.getId(), new Function0() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda27
            public final Object invoke() {
                Log.e("ExtractConversation", ">>> Lambda27.invoke() CLICKED - button was tapped <<<");
                try {
                    Toast.makeText(TaskFragment.this.requireActivity(), "[Extract] Button clicked!", 1).show();
                } catch (Throwable th) {
                    Log.e("ExtractConversation", "Toast0 failed", th);
                }
                FileLogger.log("ExtractConversation", "Lambda27.invoke() calling extractConversation");
                TaskFragment.extractConversation(TaskFragment.this, task);
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }

    private final void showRenameDialog(final String taskId, String currentTitle, final Function0<Unit> closeAction) {
        CustomConfirmDialog rename;
        CustomConfirmDialog.Companion companion = CustomConfirmDialog.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string = getString(C0820R.string.solo_dialog_rename_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(C0820R.string.solo_dialog_btn_cancel);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(C0820R.string.solo_dialog_btn_confirm);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        rename = companion.rename(requireContext, string, currentTitle, (r20 & 8) != 0 ? null : null, string2, string3, new Function1() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit showRenameDialog$lambda$39;
                showRenameDialog$lambda$39 = TaskFragment.showRenameDialog$lambda$39(TaskFragment.this, taskId, (String) obj);
                return showRenameDialog$lambda$39;
            }
        }, (r20 & 128) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.CustomConfirmDialog$Companion$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : null);
        rename.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                closeAction.invoke();
            }
        });
        rename.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRenameDialog$lambda$39(TaskFragment taskFragment, String str, String str2) {
        String str3 = str2;
        if (!(str3 == null || StringsKt.isBlank(str3))) {
            taskFragment.shouldScrollToTop = true;
            TaskViewModel taskViewModel = taskFragment.viewModel;
            if (taskViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                taskViewModel = null;
            }
            taskViewModel.renameConversation(str, str2);
        }
        return Unit.INSTANCE;
    }

    private final void showDeleteDialog(final String taskId, final Function0<Unit> closeAction) {
        CustomConfirmDialog delete;
        CustomConfirmDialog.Companion companion = CustomConfirmDialog.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string = getString(C0820R.string.solo_dialog_delete_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(C0820R.string.solo_dialog_delete_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(C0820R.string.solo_dialog_btn_cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(C0820R.string.solo_dialog_btn_delete);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        delete = companion.delete(requireContext, string, string2, (r38 & 8) != 0 ? "" : string3, string4, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : null, (r38 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? 0 : 0, (r38 & 16384) != 0 ? C0591R.drawable.trae_bg_custom_dialog_btn_primary : 0, new Function0() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda21
            public final Object invoke() {
                Unit showDeleteDialog$lambda$41;
                showDeleteDialog$lambda$41 = TaskFragment.showDeleteDialog$lambda$41(TaskFragment.this, taskId);
                return showDeleteDialog$lambda$41;
            }
        }, (r38 & 65536) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.CustomConfirmDialog$Companion$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : null);
        delete.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$$ExternalSyntheticLambda22
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                closeAction.invoke();
            }
        });
        delete.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showDeleteDialog$lambda$41(TaskFragment taskFragment, String str) {
        TaskViewModel taskViewModel = taskFragment.viewModel;
        if (taskViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            taskViewModel = null;
        }
        taskViewModel.deleteConversation(str);
        return Unit.INSTANCE;
    }

    private final void observeViewModel() {
        View view = getView();
        View findViewById = view != null ? view.findViewById(C0820R.id.layout_empty_state) : null;
        View view2 = getView();
        View findViewById2 = view2 != null ? view2.findViewById(C0820R.id.layout_task_search_loading) : null;
        View view3 = getView();
        View findViewById3 = view3 != null ? view3.findViewById(C0820R.id.layout_task_search_empty_state) : null;
        View view4 = getView();
        TextView textView = view4 != null ? (TextView) view4.findViewById(C0820R.id.tv_task_search_empty_text) : null;
        View view5 = getView();
        RecyclerView recyclerView = view5 != null ? (RecyclerView) view5.findViewById(C0820R.id.rv_tasks) : null;
        View view6 = getView();
        View findViewById4 = view6 != null ? view6.findViewById(C0820R.id.layout_network_error) : null;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new TaskFragment$observeViewModel$1(this, recyclerView, findViewById, findViewById2, findViewById3, textView, findViewById4, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), (CoroutineContext) null, (CoroutineStart) null, new TaskFragment$observeViewModel$2(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), (CoroutineContext) null, (CoroutineStart) null, new TaskFragment$observeViewModel$3(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), (CoroutineContext) null, (CoroutineStart) null, new TaskFragment$observeViewModel$4(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5), (CoroutineContext) null, (CoroutineStart) null, new TaskFragment$observeViewModel$5(this, null), 3, (Object) null);
        observeCustomActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String titleForFilter(FilterOption filter) {
        if (Intrinsics.areEqual(filter, FilterOption.All.INSTANCE)) {
            String string = getString(C0820R.string.solo_task_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (Intrinsics.areEqual(filter, FilterOption.Cloud.INSTANCE)) {
            String string2 = getString(C0820R.string.solo_filter_cloud);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (filter instanceof FilterOption.Device) {
            return ((FilterOption.Device) filter).getName();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void renderTaskContent(TaskContentState state, RecyclerView recyclerView, View emptyStateView, View searchLoadingView, View searchEmptyView, TextView searchEmptyText, View networkErrorView) {
        boolean z;
        String obj = StringsKt.trim(state.getQuery()).toString();
        if (state.isSearchMode()) {
            if (obj.length() > 0) {
                z = true;
                if (!state.getHasError() && !z) {
                    if (networkErrorView != null) {
                        networkErrorView.setVisibility(0);
                    }
                    if (recyclerView != null) {
                        recyclerView.setVisibility(8);
                    }
                    if (emptyStateView != null) {
                        emptyStateView.setVisibility(8);
                    }
                    if (searchLoadingView != null) {
                        searchLoadingView.setVisibility(8);
                    }
                    if (searchEmptyView != null) {
                        searchEmptyView.setVisibility(8);
                    }
                    SwipeRefreshLayout swipeRefreshLayout = this.swipeRefresh;
                    if (swipeRefreshLayout != null) {
                        swipeRefreshLayout.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (networkErrorView != null) {
                    networkErrorView.setVisibility(8);
                }
                if (!TaskSearchContentResolver.INSTANCE.isSearchPending(state.isSearchMode(), state.getQuery(), state.isSearchLoading(), state.getSearchResults())) {
                    SwipeRefreshLayout swipeRefreshLayout2 = this.swipeRefresh;
                    if (swipeRefreshLayout2 != null) {
                        swipeRefreshLayout2.setVisibility(8);
                    }
                    if (recyclerView != null) {
                        recyclerView.setVisibility(8);
                    }
                    if (emptyStateView != null) {
                        emptyStateView.setVisibility(8);
                    }
                    if (searchEmptyView != null) {
                        searchEmptyView.setVisibility(8);
                    }
                    if (searchLoadingView != null) {
                        searchLoadingView.setVisibility(0);
                        return;
                    }
                    return;
                }
                if (searchLoadingView != null) {
                    searchLoadingView.setVisibility(8);
                }
                if (z && state.getTasks().isEmpty()) {
                    SwipeRefreshLayout swipeRefreshLayout3 = this.swipeRefresh;
                    if (swipeRefreshLayout3 != null) {
                        swipeRefreshLayout3.setVisibility(8);
                    }
                    if (recyclerView != null) {
                        recyclerView.setVisibility(8);
                    }
                    if (emptyStateView != null) {
                        emptyStateView.setVisibility(8);
                    }
                    if (searchEmptyText != null) {
                        searchEmptyText.setText(getString(C0820R.string.solo_task_search_empty_format, new Object[]{obj}));
                    }
                    if (searchEmptyView != null) {
                        searchEmptyView.setVisibility(0);
                        return;
                    }
                    return;
                }
                if (searchEmptyView != null) {
                    searchEmptyView.setVisibility(8);
                }
                SwipeRefreshLayout swipeRefreshLayout4 = this.swipeRefresh;
                if (swipeRefreshLayout4 != null) {
                    swipeRefreshLayout4.setVisibility(0);
                }
                if (!state.getTasks().isEmpty()) {
                    if (recyclerView != null) {
                        recyclerView.setVisibility(0);
                    }
                    if (emptyStateView != null) {
                        emptyStateView.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
                if (emptyStateView != null) {
                    emptyStateView.setVisibility(0);
                    return;
                }
                return;
            }
        }
        z = false;
        if (!state.getHasError()) {
        }
        if (networkErrorView != null) {
        }
        if (!TaskSearchContentResolver.INSTANCE.isSearchPending(state.isSearchMode(), state.getQuery(), state.isSearchLoading(), state.getSearchResults())) {
        }
    }

    private final void observeCustomActivity() {
        TraeTitleBar traeTitleBar;
        View view = getView();
        if (view == null || (traeTitleBar = (TraeTitleBar) view.findViewById(C0820R.id.title_bar)) == null) {
            return;
        }
        SimpleDraweeView taskOperationIcon = traeTitleBar.getTaskOperationIcon();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new TaskFragment$observeCustomActivity$1(this, traeTitleBar, taskOperationIcon, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadAvatar(SimpleDraweeView iv) {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String avatarUrl = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getAvatarUrl();
        String str = avatarUrl;
        if (!(str == null || str.length() == 0)) {
            iv.setImageURI(Uri.parse(avatarUrl));
        } else {
            iv.setActualImageResource(C0820R.drawable.trae_default_avatar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TaskFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;", "", "tasks", "", "Lcom/bytedance/trae/home/solo/task/TaskModel;", "hasError", "", "isSearchMode", "query", "", "isSearchLoading", "<init>", "(Ljava/util/List;ZZLjava/lang/String;Z)V", "getTasks", "()Ljava/util/List;", "getHasError", "()Z", "getQuery", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class RawTaskContentState {
        private final boolean hasError;
        private final boolean isSearchLoading;
        private final boolean isSearchMode;
        private final String query;
        private final List<TaskModel> tasks;

        public static /* synthetic */ RawTaskContentState copy$default(RawTaskContentState rawTaskContentState, List list, boolean z, boolean z2, String str, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = rawTaskContentState.tasks;
            }
            if ((i & 2) != 0) {
                z = rawTaskContentState.hasError;
            }
            boolean z4 = z;
            if ((i & 4) != 0) {
                z2 = rawTaskContentState.isSearchMode;
            }
            boolean z5 = z2;
            if ((i & 8) != 0) {
                str = rawTaskContentState.query;
            }
            String str2 = str;
            if ((i & 16) != 0) {
                z3 = rawTaskContentState.isSearchLoading;
            }
            return rawTaskContentState.copy(list, z4, z5, str2, z3);
        }

        public final List<TaskModel> component1() {
            return this.tasks;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getHasError() {
            return this.hasError;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsSearchMode() {
            return this.isSearchMode;
        }

        /* renamed from: component4, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsSearchLoading() {
            return this.isSearchLoading;
        }

        public final RawTaskContentState copy(List<TaskModel> tasks, boolean hasError, boolean isSearchMode, String query, boolean isSearchLoading) {
            Intrinsics.checkNotNullParameter(tasks, "tasks");
            Intrinsics.checkNotNullParameter(query, "query");
            return new RawTaskContentState(tasks, hasError, isSearchMode, query, isSearchLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RawTaskContentState)) {
                return false;
            }
            RawTaskContentState rawTaskContentState = (RawTaskContentState) other;
            return Intrinsics.areEqual(this.tasks, rawTaskContentState.tasks) && this.hasError == rawTaskContentState.hasError && this.isSearchMode == rawTaskContentState.isSearchMode && Intrinsics.areEqual(this.query, rawTaskContentState.query) && this.isSearchLoading == rawTaskContentState.isSearchLoading;
        }

        public int hashCode() {
            return (((((((this.tasks.hashCode() * 31) + Boolean.hashCode(this.hasError)) * 31) + Boolean.hashCode(this.isSearchMode)) * 31) + this.query.hashCode()) * 31) + Boolean.hashCode(this.isSearchLoading);
        }

        public String toString() {
            return "RawTaskContentState(tasks=" + this.tasks + ", hasError=" + this.hasError + ", isSearchMode=" + this.isSearchMode + ", query=" + this.query + ", isSearchLoading=" + this.isSearchLoading + ')';
        }

        public RawTaskContentState(List<TaskModel> list, boolean z, boolean z2, String str, boolean z3) {
            Intrinsics.checkNotNullParameter(list, "tasks");
            Intrinsics.checkNotNullParameter(str, "query");
            this.tasks = list;
            this.hasError = z;
            this.isSearchMode = z2;
            this.query = str;
            this.isSearchLoading = z3;
        }

        public final List<TaskModel> getTasks() {
            return this.tasks;
        }

        public final boolean getHasError() {
            return this.hasError;
        }

        public final boolean isSearchMode() {
            return this.isSearchMode;
        }

        public final String getQuery() {
            return this.query;
        }

        public final boolean isSearchLoading() {
            return this.isSearchLoading;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TaskFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003JS\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\tHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;", "", "tasks", "", "Lcom/bytedance/trae/home/solo/task/TaskModel;", "hasError", "", "isSearchMode", "query", "", "searchResults", "isSearchLoading", "<init>", "(Ljava/util/List;ZZLjava/lang/String;Ljava/util/List;Z)V", "getTasks", "()Ljava/util/List;", "getHasError", "()Z", "getQuery", "()Ljava/lang/String;", "getSearchResults", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class TaskContentState {
        private final boolean hasError;
        private final boolean isSearchLoading;
        private final boolean isSearchMode;
        private final String query;
        private final List<TaskModel> searchResults;
        private final List<TaskModel> tasks;

        public static /* synthetic */ TaskContentState copy$default(TaskContentState taskContentState, List list, boolean z, boolean z2, String str, List list2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = taskContentState.tasks;
            }
            if ((i & 2) != 0) {
                z = taskContentState.hasError;
            }
            boolean z4 = z;
            if ((i & 4) != 0) {
                z2 = taskContentState.isSearchMode;
            }
            boolean z5 = z2;
            if ((i & 8) != 0) {
                str = taskContentState.query;
            }
            String str2 = str;
            if ((i & 16) != 0) {
                list2 = taskContentState.searchResults;
            }
            List list3 = list2;
            if ((i & 32) != 0) {
                z3 = taskContentState.isSearchLoading;
            }
            return taskContentState.copy(list, z4, z5, str2, list3, z3);
        }

        public final List<TaskModel> component1() {
            return this.tasks;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getHasError() {
            return this.hasError;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsSearchMode() {
            return this.isSearchMode;
        }

        /* renamed from: component4, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        public final List<TaskModel> component5() {
            return this.searchResults;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsSearchLoading() {
            return this.isSearchLoading;
        }

        public final TaskContentState copy(List<TaskModel> tasks, boolean hasError, boolean isSearchMode, String query, List<TaskModel> searchResults, boolean isSearchLoading) {
            Intrinsics.checkNotNullParameter(tasks, "tasks");
            Intrinsics.checkNotNullParameter(query, "query");
            return new TaskContentState(tasks, hasError, isSearchMode, query, searchResults, isSearchLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskContentState)) {
                return false;
            }
            TaskContentState taskContentState = (TaskContentState) other;
            return Intrinsics.areEqual(this.tasks, taskContentState.tasks) && this.hasError == taskContentState.hasError && this.isSearchMode == taskContentState.isSearchMode && Intrinsics.areEqual(this.query, taskContentState.query) && Intrinsics.areEqual(this.searchResults, taskContentState.searchResults) && this.isSearchLoading == taskContentState.isSearchLoading;
        }

        public int hashCode() {
            int hashCode = ((((((this.tasks.hashCode() * 31) + Boolean.hashCode(this.hasError)) * 31) + Boolean.hashCode(this.isSearchMode)) * 31) + this.query.hashCode()) * 31;
            List<TaskModel> list = this.searchResults;
            return ((hashCode + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.isSearchLoading);
        }

        public String toString() {
            return "TaskContentState(tasks=" + this.tasks + ", hasError=" + this.hasError + ", isSearchMode=" + this.isSearchMode + ", query=" + this.query + ", searchResults=" + this.searchResults + ", isSearchLoading=" + this.isSearchLoading + ')';
        }

        public TaskContentState(List<TaskModel> list, boolean z, boolean z2, String str, List<TaskModel> list2, boolean z3) {
            Intrinsics.checkNotNullParameter(list, "tasks");
            Intrinsics.checkNotNullParameter(str, "query");
            this.tasks = list;
            this.hasError = z;
            this.isSearchMode = z2;
            this.query = str;
            this.searchResults = list2;
            this.isSearchLoading = z3;
        }

        public final List<TaskModel> getTasks() {
            return this.tasks;
        }

        public final boolean getHasError() {
            return this.hasError;
        }

        public final boolean isSearchMode() {
            return this.isSearchMode;
        }

        public final String getQuery() {
            return this.query;
        }

        public final List<TaskModel> getSearchResults() {
            return this.searchResults;
        }

        public final boolean isSearchLoading() {
            return this.isSearchLoading;
        }
    }

    private final void fixSuspendByPeerCrash(Context context) {
        if (this.hasSuspendByPeerCrashFixed) {
            return;
        }
        this.hasSuspendByPeerCrashFixed = true;
        if (ToolUtils.isMainProcess(context)) {
            boolean isDebug = AppHost.INSTANCE.isDebug();
            boolean isTestChannel = AppHost.INSTANCE.isTestChannel();
            boolean isFixSuspendByPeerCrashEnable = FixCrashSettingsService.INSTANCE.isFixSuspendByPeerCrashEnable();
            if (isDebug || isTestChannel || isFixSuspendByPeerCrashEnable) {
                FLogger.INSTANCE.i("fixSuspendByPeerCrash", "runInternal, isDebug: " + isDebug + ", isTestChannel: " + isTestChannel + ", isFixSuspendByPeerCrashEnable: " + isFixSuspendByPeerCrashEnable);
                SuspendByPeerOpt.start(context, false);
            }
        }
    }
}
