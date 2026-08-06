package com.bytedance.trae.conversation.devices;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment;
import com.bytedance.trae.conversation.devices.DirectoryViewModel;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigatorKt;
import com.bytedance.trae.conversation.widget.ChatMode;
import com.bytedance.trae.im.service.Mode;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: DirectoryBottomSheetFragment.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 72\u00020\u0001:\u000278B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0016H\u0002J\b\u0010*\u001a\u00020\u0007H\u0002J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020\u0007H\u0002J\b\u00100\u001a\u000201H\u0002J\b\u00104\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "listener", "Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;", "setOnDirectorySelectedListener", "", "l", "viewModel", "Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;", "getViewModel", "()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "titleBar", "Lcom/bytedance/trae/common/widget/TraeTitleBar;", "btnAddFolder", "Landroid/widget/Button;", "tvEmptyState", "Landroid/view/View;", "progressLoading", "adapter", "Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onAttach", "context", "Landroid/content/Context;", "onDetach", "initViews", "setupRecyclerView", "handleNodeClick", "node", "Lcom/bytedance/trae/conversation/devices/DirectoryNode;", "handleNodeSelect", "handleAddNewFolderClicked", "useFlowRouteBack", "", "forceDocumentRootPath", "", "observeState", "observeEvents", "handleOkClicked", "Companion", "OnDirectorySelectedListener", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DirectoryBottomSheetFragment extends BottomSheetDialogFragment {
    private static final String ARG_CHAT_MODE = "arg_chat_mode";
    private static final String ARG_CLI_ID = "arg_cli_id";
    private static final String ARG_SELECTED_DIRECTORY = "arg_selected_directory";
    private static final String ARG_USE_FLOW_ROUTE_BACK = "arg_use_flow_route_back";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "DirectoryBottomSheet";
    private DirectoryAdapter adapter;
    private Button btnAddFolder;
    private String forceDocumentRootPath;
    private OnDirectorySelectedListener listener;
    private View progressLoading;
    private RecyclerView recyclerView;
    private TraeTitleBar titleBar;
    private View tvEmptyState;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: DirectoryBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;", "", "onDirectorySelected", "", "node", "Lcom/bytedance/trae/conversation/devices/DirectoryNode;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface OnDirectorySelectedListener {
        void onDirectorySelected(DirectoryNode node);
    }

    public DirectoryBottomSheetFragment() {
        final Fragment fragment = (Fragment) this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m1439invoke() {
                return fragment;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DirectoryViewModel.class), new Function0<ViewModelStore>() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelStore m1440invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelProvider.Factory m1441invoke() {
                Object invoke = function0.invoke();
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = invoke instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) invoke : null;
                ViewModelProvider.Factory defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* compiled from: DirectoryBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;", "", "<init>", "()V", "ARG_CLI_ID", "", "TAG", "ARG_CHAT_MODE", "ARG_SELECTED_DIRECTORY", "ARG_USE_FLOW_ROUTE_BACK", "newInstance", "Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;", "cliId", "chatMode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "selectedDirectory", "useFlowRouteBack", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DirectoryBottomSheetFragment newInstance$default(Companion companion, String str, ChatMode chatMode, String str2, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                chatMode = ChatMode.MTC;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                z = true;
            }
            return companion.newInstance(str, chatMode, str2, z);
        }

        public final DirectoryBottomSheetFragment newInstance(String cliId, ChatMode chatMode, String selectedDirectory, boolean useFlowRouteBack) {
            Intrinsics.checkNotNullParameter(cliId, "cliId");
            Intrinsics.checkNotNullParameter(chatMode, "chatMode");
            DirectoryBottomSheetFragment directoryBottomSheetFragment = new DirectoryBottomSheetFragment();
            Bundle bundle = new Bundle();
            bundle.putString(DirectoryBottomSheetFragment.ARG_CLI_ID, cliId);
            bundle.putString(DirectoryBottomSheetFragment.ARG_CHAT_MODE, chatMode.name());
            if (selectedDirectory != null) {
                bundle.putString(DirectoryBottomSheetFragment.ARG_SELECTED_DIRECTORY, selectedDirectory);
            }
            bundle.putBoolean(DirectoryBottomSheetFragment.ARG_USE_FLOW_ROUTE_BACK, useFlowRouteBack);
            directoryBottomSheetFragment.setArguments(bundle);
            return directoryBottomSheetFragment;
        }
    }

    public final void setOnDirectorySelectedListener(OnDirectorySelectedListener l) {
        Intrinsics.checkNotNullParameter(l, "l");
        this.listener = l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DirectoryViewModel getViewModel() {
        return (DirectoryViewModel) this.viewModel.getValue();
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        Dialog dialog = (BottomSheetDialog) onCreateDialog;
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean onCreateDialog$lambda$0;
                onCreateDialog$lambda$0 = DirectoryBottomSheetFragment.onCreateDialog$lambda$0(DirectoryBottomSheetFragment.this, dialogInterface, i, keyEvent);
                return onCreateDialog$lambda$0;
            }
        });
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DirectoryBottomSheetFragment.onCreateDialog$lambda$3(DirectoryBottomSheetFragment.this, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateDialog$lambda$0(DirectoryBottomSheetFragment directoryBottomSheetFragment, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (directoryBottomSheetFragment.useFlowRouteBack() || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        directoryBottomSheetFragment.dismissAllowingStateLoss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$3(DirectoryBottomSheetFragment directoryBottomSheetFragment, DialogInterface dialogInterface) {
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        View findViewById = ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet);
        if (findViewById != null) {
            findViewById.setBackgroundResource(android.R.color.transparent);
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            int i = (int) (directoryBottomSheetFragment.getResources().getDisplayMetrics().heightPixels * 0.9d);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
            from.setPeekHeight(i);
            from.setState(3);
            from.setSkipCollapsed(true);
            findViewById.setBackground(null);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(C0637R.layout.fragment_directory_bottom_sheet, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        ChatMode chatMode;
        Mode mode;
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final int dimensionPixelSize = getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_24);
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$onViewCreated$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View v, Outline outline) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(outline, "outline");
                int width = v.getWidth();
                int height = v.getHeight();
                int i = dimensionPixelSize;
                outline.setRoundRect(0, 0, width, height + i, i);
            }
        });
        view.setClipToOutline(true);
        initViews(view);
        setupRecyclerView();
        observeState();
        observeEvents();
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_CHAT_MODE)) == null || (chatMode = ChatMode.valueOf(string)) == null) {
            chatMode = ChatMode.MTC;
        }
        DirectoryViewModel viewModel = getViewModel();
        if (chatMode == ChatMode.CODE) {
            mode = Mode.CODE;
        } else {
            mode = Mode.WORK;
        }
        viewModel.setChatMode(mode);
        DirectoryViewModel viewModel2 = getViewModel();
        Bundle arguments2 = getArguments();
        viewModel2.setCliId(arguments2 != null ? arguments2.getString(ARG_CLI_ID) : null);
        DirectoryViewModel viewModel3 = getViewModel();
        Bundle arguments3 = getArguments();
        viewModel3.setPreselectedPath(arguments3 != null ? arguments3.getString(ARG_SELECTED_DIRECTORY) : null);
        String str = this.forceDocumentRootPath;
        if (str != null) {
            this.forceDocumentRootPath = null;
            DirectoryViewModel.loadDocumentFolder$default(getViewModel(), str, 0, false, 2, null);
        } else {
            getViewModel().loadInitialData();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (this.listener == null) {
            OnDirectorySelectedListener parentFragment = getParentFragment();
            OnDirectorySelectedListener onDirectorySelectedListener = null;
            OnDirectorySelectedListener onDirectorySelectedListener2 = parentFragment instanceof OnDirectorySelectedListener ? parentFragment : null;
            if (onDirectorySelectedListener2 != null) {
                onDirectorySelectedListener = onDirectorySelectedListener2;
            } else if (context instanceof OnDirectorySelectedListener) {
                onDirectorySelectedListener = (OnDirectorySelectedListener) context;
            }
            this.listener = onDirectorySelectedListener;
        }
    }

    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    private final void initViews(View view) {
        RecyclerView findViewById = view.findViewById(C0637R.id.rv_directory);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.recyclerView = findViewById;
        View findViewById2 = view.findViewById(C0637R.id.title_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.titleBar = (TraeTitleBar) findViewById2;
        View findViewById3 = view.findViewById(C0637R.id.btn_add_folder);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.btnAddFolder = (Button) findViewById3;
        View findViewById4 = view.findViewById(C0637R.id.tv_empty_state);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.tvEmptyState = findViewById4;
        View findViewById5 = view.findViewById(C0637R.id.progress_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.progressLoading = findViewById5;
        TraeTitleBar traeTitleBar = this.titleBar;
        Button button = null;
        if (traeTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            traeTitleBar = null;
        }
        traeTitleBar.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DirectoryBottomSheetFragment.initViews$lambda$5(DirectoryBottomSheetFragment.this, view2);
            }
        });
        Button button2 = this.btnAddFolder;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAddFolder");
        } else {
            button = button2;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DirectoryBottomSheetFragment.this.handleAddNewFolderClicked();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5(DirectoryBottomSheetFragment directoryBottomSheetFragment, View view) {
        if (directoryBottomSheetFragment.useFlowRouteBack()) {
            DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) directoryBottomSheetFragment);
            if (deviceFlowNavigator != null) {
                deviceFlowNavigator.onRouteBack();
                return;
            } else {
                directoryBottomSheetFragment.dismiss();
                return;
            }
        }
        directoryBottomSheetFragment.dismiss();
    }

    private final void setupRecyclerView() {
        this.adapter = new DirectoryAdapter(new Function1() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit unit;
                unit = DirectoryBottomSheetFragment.setupRecyclerView$lambda$7(DirectoryBottomSheetFragment.this, (DirectoryNode) obj);
                return unit;
            }
        }, new Function1() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit unit;
                unit = DirectoryBottomSheetFragment.setupRecyclerView$lambda$8(DirectoryBottomSheetFragment.this, (DirectoryNode) obj);
                return unit;
            }
        }, new Function2() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                Unit unit;
                unit = DirectoryBottomSheetFragment.setupRecyclerView$lambda$9(DirectoryBottomSheetFragment.this, (String) obj, (String) obj2);
                return unit;
            }
        }, new Function1() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit unit;
                unit = DirectoryBottomSheetFragment.setupRecyclerView$lambda$10(DirectoryBottomSheetFragment.this, (String) obj);
                return unit;
            }
        });
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView.Adapter adapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        RecyclerView.Adapter adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            adapter = adapter2;
        }
        recyclerView2.setAdapter(adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupRecyclerView$lambda$7(DirectoryBottomSheetFragment directoryBottomSheetFragment, DirectoryNode directoryNode) {
        Intrinsics.checkNotNullParameter(directoryNode, "node");
        directoryBottomSheetFragment.handleNodeClick(directoryNode);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupRecyclerView$lambda$8(DirectoryBottomSheetFragment directoryBottomSheetFragment, DirectoryNode directoryNode) {
        Intrinsics.checkNotNullParameter(directoryNode, "node");
        directoryBottomSheetFragment.handleNodeSelect(directoryNode);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupRecyclerView$lambda$9(DirectoryBottomSheetFragment directoryBottomSheetFragment, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "placeholderId");
        Intrinsics.checkNotNullParameter(str2, "name");
        directoryBottomSheetFragment.getViewModel().onNewFolderNameConfirmed(str, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupRecyclerView$lambda$10(DirectoryBottomSheetFragment directoryBottomSheetFragment, String str) {
        Intrinsics.checkNotNullParameter(str, "placeholderId");
        directoryBottomSheetFragment.getViewModel().cancelNewFolder(str);
        return Unit.INSTANCE;
    }

    private final void handleNodeClick(DirectoryNode node) {
        if (((DirectoryUiState) getViewModel().getUiState().getValue()).getResolvedMode() == DirectoryViewModel.Mode.RECENT) {
            handleNodeSelect(node);
        } else {
            getViewModel().onNodeClicked(node);
        }
    }

    private final void handleNodeSelect(final DirectoryNode node) {
        DirectoryViewModel.Mode resolvedMode = ((DirectoryUiState) getViewModel().getUiState().getValue()).getResolvedMode();
        getViewModel().onNodeSelected(node);
        if (resolvedMode == DirectoryViewModel.Mode.RECENT) {
            OnDirectorySelectedListener onDirectorySelectedListener = this.listener;
            if (onDirectorySelectedListener != null) {
                onDirectorySelectedListener.onDirectorySelected(node);
            }
            dismiss();
            return;
        }
        getViewModel().checkNeedAuthorization(node.getId(), new Function1() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit handleNodeSelect$lambda$14;
                handleNodeSelect$lambda$14 = DirectoryBottomSheetFragment.handleNodeSelect$lambda$14(DirectoryBottomSheetFragment.this, node, ((Boolean) obj).booleanValue());
                return handleNodeSelect$lambda$14;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleNodeSelect$lambda$14(final DirectoryBottomSheetFragment directoryBottomSheetFragment, final DirectoryNode directoryNode, boolean z) {
        if (z) {
            Context requireContext = directoryBottomSheetFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            new SelectProjectPermissionDialog(requireContext, directoryNode.getName(), new Function0() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$$ExternalSyntheticLambda9
                public final Object invoke() {
                    Unit handleNodeSelect$lambda$14$lambda$12;
                    handleNodeSelect$lambda$14$lambda$12 = DirectoryBottomSheetFragment.handleNodeSelect$lambda$14$lambda$12(DirectoryBottomSheetFragment.this, directoryNode);
                    return handleNodeSelect$lambda$14$lambda$12;
                }
            }, new Function0() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit handleNodeSelect$lambda$14$lambda$13;
                    handleNodeSelect$lambda$14$lambda$13 = DirectoryBottomSheetFragment.handleNodeSelect$lambda$14$lambda$13(DirectoryBottomSheetFragment.this);
                    return handleNodeSelect$lambda$14$lambda$13;
                }
            }).show();
        } else {
            OnDirectorySelectedListener onDirectorySelectedListener = directoryBottomSheetFragment.listener;
            if (onDirectorySelectedListener != null) {
                onDirectorySelectedListener.onDirectorySelected(directoryNode);
            }
            directoryBottomSheetFragment.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleNodeSelect$lambda$14$lambda$12(final DirectoryBottomSheetFragment directoryBottomSheetFragment, final DirectoryNode directoryNode) {
        directoryBottomSheetFragment.getViewModel().submitAuthorizationResult(directoryNode.getId(), "allow", new Function0() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$$ExternalSyntheticLambda6
            public final Object invoke() {
                Unit handleNodeSelect$lambda$14$lambda$12$lambda$11;
                handleNodeSelect$lambda$14$lambda$12$lambda$11 = DirectoryBottomSheetFragment.handleNodeSelect$lambda$14$lambda$12$lambda$11(DirectoryBottomSheetFragment.this, directoryNode);
                return handleNodeSelect$lambda$14$lambda$12$lambda$11;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleNodeSelect$lambda$14$lambda$12$lambda$11(DirectoryBottomSheetFragment directoryBottomSheetFragment, DirectoryNode directoryNode) {
        OnDirectorySelectedListener onDirectorySelectedListener = directoryBottomSheetFragment.listener;
        if (onDirectorySelectedListener != null) {
            onDirectorySelectedListener.onDirectorySelected(directoryNode);
        }
        directoryBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleNodeSelect$lambda$14$lambda$13(DirectoryBottomSheetFragment directoryBottomSheetFragment) {
        directoryBottomSheetFragment.getViewModel().clearSelection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAddNewFolderClicked() {
        String string;
        ChatMode chatMode;
        String string2;
        if (((DirectoryUiState) getViewModel().getUiState().getValue()).getResolvedMode() == DirectoryViewModel.Mode.RECENT) {
            Bundle arguments = getArguments();
            if (arguments == null || (string = arguments.getString(ARG_CLI_ID)) == null) {
                return;
            }
            Bundle arguments2 = getArguments();
            if (arguments2 == null || (string2 = arguments2.getString(ARG_CHAT_MODE)) == null || (chatMode = ChatMode.valueOf(string2)) == null) {
                chatMode = ChatMode.MTC;
            }
            String str = (String) getViewModel().getDefaultFolder().getValue();
            if (str == null) {
                return;
            }
            Companion companion = INSTANCE;
            Bundle arguments3 = getArguments();
            DirectoryBottomSheetFragment newInstance = companion.newInstance(string, chatMode, arguments3 != null ? arguments3.getString(ARG_SELECTED_DIRECTORY) : null, false);
            newInstance.forceDocumentRootPath = str;
            newInstance.setOnDirectorySelectedListener(new OnDirectorySelectedListener() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$handleAddNewFolderClicked$1
                @Override // com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment.OnDirectorySelectedListener
                public void onDirectorySelected(DirectoryNode node) {
                    DirectoryBottomSheetFragment.OnDirectorySelectedListener onDirectorySelectedListener;
                    Intrinsics.checkNotNullParameter(node, "node");
                    onDirectorySelectedListener = DirectoryBottomSheetFragment.this.listener;
                    if (onDirectorySelectedListener != null) {
                        onDirectorySelectedListener.onDirectorySelected(node);
                    }
                    if (DeviceFlowNavigatorKt.deviceFlowNavigator(DirectoryBottomSheetFragment.this) == null) {
                        DirectoryBottomSheetFragment.this.dismiss();
                    }
                }
            });
            newInstance.show(getChildFragmentManager(), "DirectoryBottomSheet_document");
            return;
        }
        getViewModel().onAddNewFolderClicked();
    }

    private final boolean useFlowRouteBack() {
        Bundle arguments = getArguments();
        boolean z = false;
        if (arguments != null && !arguments.getBoolean(ARG_USE_FLOW_ROUTE_BACK, true)) {
            z = true;
        }
        return !z;
    }

    private final void observeState() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new DirectoryBottomSheetFragment$observeState$1(this, null), 3, (Object) null);
    }

    private final void observeEvents() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new DirectoryBottomSheetFragment$observeEvents$1(this, null), 3, (Object) null);
    }

    private final void handleOkClicked() {
        Object obj;
        Iterator<T> it = ((DirectoryUiState) getViewModel().getUiState().getValue()).getNodes().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((DirectoryNode) obj).isSelected()) {
                    break;
                }
            }
        }
        DirectoryNode directoryNode = (DirectoryNode) obj;
        if (directoryNode != null) {
            OnDirectorySelectedListener onDirectorySelectedListener = this.listener;
            if (onDirectorySelectedListener != null) {
                onDirectorySelectedListener.onDirectorySelected(directoryNode);
            }
            dismiss();
            return;
        }
        Toast.makeText(requireContext(), getString(com.bytedance.trae.multilanguage.R.string.trae_dir_please_select), 0).show();
    }
}
