package com.bytedance.trae.conversation.plugin;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.network.PluginItem;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: PluginsBottomSheet.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;", "getViewModel", "()Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;", "onPluginSelected", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/network/PluginItem;", "", "getOnPluginSelected", "()Lkotlin/jvm/functions/Function1;", "setOnPluginSelected", "(Lkotlin/jvm/functions/Function1;)V", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onViewCreated", "view", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginsBottomSheet extends BottomSheetDialogFragment {
    private static final String ARG_CLI_ID = "arg_cli_id";
    private static final String ARG_WORKSPACE_FOLDER = "arg_workspace_folder";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int SHEET_HEIGHT_DP = 326;
    private PluginsAdapter adapter;
    private Function1<? super PluginItem, Unit> onPluginSelected;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public PluginsBottomSheet() {
        final Fragment fragment = (Fragment) this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.bytedance.trae.conversation.plugin.PluginsBottomSheet$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m1470invoke() {
                return fragment;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(PluginsViewModel.class), new Function0<ViewModelStore>() { // from class: com.bytedance.trae.conversation.plugin.PluginsBottomSheet$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelStore m1471invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.bytedance.trae.conversation.plugin.PluginsBottomSheet$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelProvider.Factory m1472invoke() {
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

    private final PluginsViewModel getViewModel() {
        return (PluginsViewModel) this.viewModel.getValue();
    }

    public final Function1<PluginItem, Unit> getOnPluginSelected() {
        return this.onPluginSelected;
    }

    public final void setOnPluginSelected(Function1<? super PluginItem, Unit> function1) {
        this.onPluginSelected = function1;
    }

    /* compiled from: PluginsBottomSheet.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$Companion;", "", "<init>", "()V", "ARG_CLI_ID", "", "ARG_WORKSPACE_FOLDER", "SHEET_HEIGHT_DP", "", "newInstance", "Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;", "cliId", "workspaceFolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ PluginsBottomSheet newInstance$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return companion.newInstance(str, str2);
        }

        public final PluginsBottomSheet newInstance(String cliId, String workspaceFolder) {
            PluginsBottomSheet pluginsBottomSheet = new PluginsBottomSheet();
            Bundle bundle = new Bundle();
            if (cliId != null) {
                bundle.putString(PluginsBottomSheet.ARG_CLI_ID, cliId);
            }
            if (workspaceFolder != null) {
                bundle.putString(PluginsBottomSheet.ARG_WORKSPACE_FOLDER, workspaceFolder);
            }
            pluginsBottomSheet.setArguments(bundle);
            return pluginsBottomSheet;
        }
    }

    public int getTheme() {
        return C0637R.style.Trae_BottomSheetDialog;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.bottom_sheet_plugins, container, false);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final Dialog dialog = (BottomSheetDialog) onCreateDialog;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.plugin.PluginsBottomSheet$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                PluginsBottomSheet.onCreateDialog$lambda$1(dialog, this, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(BottomSheetDialog bottomSheetDialog, PluginsBottomSheet pluginsBottomSheet, DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        if (frameLayout != null) {
            frameLayout.setBackground(new ColorDrawable(0));
            int i = (int) (SHEET_HEIGHT_DP * pluginsBottomSheet.getResources().getDisplayMetrics().density);
            frameLayout.getLayoutParams().height = i;
            frameLayout.requestLayout();
            BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
            from.setPeekHeight(i);
            from.setState(3);
            from.setSkipCollapsed(true);
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        PluginsViewModel viewModel = getViewModel();
        Bundle arguments = getArguments();
        PluginsAdapter pluginsAdapter = null;
        viewModel.setCliId(arguments != null ? arguments.getString(ARG_CLI_ID) : null);
        PluginsViewModel viewModel2 = getViewModel();
        Bundle arguments2 = getArguments();
        viewModel2.setWorkspaceFolder(arguments2 != null ? arguments2.getString(ARG_WORKSPACE_FOLDER) : null);
        getViewModel().loadPlugins();
        TraeTitleBar traeTitleBar = (TraeTitleBar) view.findViewById(C0637R.id.title_bar);
        final RecyclerView findViewById = view.findViewById(C0637R.id.recycler_view);
        final View findViewById2 = view.findViewById(C0637R.id.empty_state_container);
        traeTitleBar.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.plugin.PluginsBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PluginsBottomSheet.this.dismiss();
            }
        });
        PluginsAdapter pluginsAdapter2 = new PluginsAdapter();
        this.adapter = pluginsAdapter2;
        pluginsAdapter2.setOnItemClickListener(new Function1() { // from class: com.bytedance.trae.conversation.plugin.PluginsBottomSheet$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$3;
                onViewCreated$lambda$3 = PluginsBottomSheet.onViewCreated$lambda$3(PluginsBottomSheet.this, (PluginItem) obj);
                return onViewCreated$lambda$3;
            }
        });
        findViewById.setLayoutManager(new LinearLayoutManager(requireContext()));
        PluginsAdapter pluginsAdapter3 = this.adapter;
        if (pluginsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            pluginsAdapter = pluginsAdapter3;
        }
        findViewById.setAdapter(pluginsAdapter);
        getViewModel().getPlugins().observe(getViewLifecycleOwner(), new PluginsBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.plugin.PluginsBottomSheet$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$4;
                onViewCreated$lambda$4 = PluginsBottomSheet.onViewCreated$lambda$4(PluginsBottomSheet.this, findViewById2, findViewById, (List) obj);
                return onViewCreated$lambda$4;
            }
        }));
        getViewModel().isLoading().observe(getViewLifecycleOwner(), new PluginsBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.plugin.PluginsBottomSheet$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$5;
                onViewCreated$lambda$5 = PluginsBottomSheet.onViewCreated$lambda$5(PluginsBottomSheet.this, findViewById2, findViewById, (Boolean) obj);
                return onViewCreated$lambda$5;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(PluginsBottomSheet pluginsBottomSheet, PluginItem pluginItem) {
        Intrinsics.checkNotNullParameter(pluginItem, "plugin");
        Function1<? super PluginItem, Unit> function1 = pluginsBottomSheet.onPluginSelected;
        if (function1 != null) {
            function1.invoke(pluginItem);
        }
        pluginsBottomSheet.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4(PluginsBottomSheet pluginsBottomSheet, View view, RecyclerView recyclerView, List list) {
        PluginsAdapter pluginsAdapter = pluginsBottomSheet.adapter;
        if (pluginsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            pluginsAdapter = null;
        }
        Intrinsics.checkNotNull(list);
        pluginsAdapter.updateData(list);
        if (!list.isEmpty()) {
            view.setVisibility(8);
            recyclerView.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5(PluginsBottomSheet pluginsBottomSheet, View view, RecyclerView recyclerView, Boolean bool) {
        if (!bool.booleanValue()) {
            Collection collection = (Collection) pluginsBottomSheet.getViewModel().getPlugins().getValue();
            if (collection == null || collection.isEmpty()) {
                view.setVisibility(0);
                recyclerView.setVisibility(8);
            }
        }
        return Unit.INSTANCE;
    }
}
