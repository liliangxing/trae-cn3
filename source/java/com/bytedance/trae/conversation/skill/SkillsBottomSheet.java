package com.bytedance.trae.conversation.skill;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.widget.StepInterpolator;
import com.bytedance.trae.conversation.network.SkillItem;
import com.bytedance.trae.conversation.tracker.InputTracker;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* compiled from: SkillsBottomSheet.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020#H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/trae/conversation/skill/SkillsViewModel;", "getViewModel", "()Lcom/bytedance/trae/conversation/skill/SkillsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/bytedance/trae/conversation/skill/SkillsAdapter;", "fullSkillsList", "", "Lcom/bytedance/trae/conversation/network/SkillItem;", "onSkillSelected", "Lkotlin/Function1;", "", "getOnSkillSelected", "()Lkotlin/jvm/functions/Function1;", "setOnSkillSelected", "(Lkotlin/jvm/functions/Function1;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onViewCreated", "view", "setupLoadingViews", "Landroid/widget/LinearLayout;", "startLoadingAnimation", "stopLoadingAnimation", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SkillsBottomSheet extends BottomSheetDialogFragment {
    private static final String ARG_AGENT_TYPE = "arg_agent_type";
    private static final String ARG_CLI_ID = "arg_cli_id";
    private static final String ARG_CONFIG_NAME = "arg_config_name";
    private static final String ARG_CONVERSATION_ID = "arg_conversation_id";
    private static final String ARG_IS_IDE_SKILLS = "arg_is_ide_skills";
    private static final String ARG_PROJECT_ID = "arg_project_id";
    private static final String ARG_WORKSPACE_FOLDER = "arg_workspace_folder";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SkillsAdapter adapter;
    private List<SkillItem> fullSkillsList;
    private Function1<? super SkillItem, Unit> onSkillSelected;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public SkillsBottomSheet() {
        final Fragment fragment = (Fragment) this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.bytedance.trae.conversation.skill.SkillsBottomSheet$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m1518invoke() {
                return fragment;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(SkillsViewModel.class), new Function0<ViewModelStore>() { // from class: com.bytedance.trae.conversation.skill.SkillsBottomSheet$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelStore m1519invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.bytedance.trae.conversation.skill.SkillsBottomSheet$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelProvider.Factory m1520invoke() {
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
        this.fullSkillsList = CollectionsKt.emptyList();
    }

    private final SkillsViewModel getViewModel() {
        return (SkillsViewModel) this.viewModel.getValue();
    }

    public final Function1<SkillItem, Unit> getOnSkillSelected() {
        return this.onSkillSelected;
    }

    public final void setOnSkillSelected(Function1<? super SkillItem, Unit> function1) {
        this.onSkillSelected = function1;
    }

    /* compiled from: SkillsBottomSheet.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$Companion;", "", "<init>", "()V", "ARG_CLI_ID", "", "ARG_WORKSPACE_FOLDER", "ARG_PROJECT_ID", "ARG_IS_IDE_SKILLS", "ARG_CONVERSATION_ID", "ARG_CONFIG_NAME", "ARG_AGENT_TYPE", "newInstance", "Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;", "cliId", "workspaceFolder", "projectId", "isIdeSkills", "", "conversationId", "configName", "agentType", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SkillsBottomSheet newInstance(String cliId, String workspaceFolder, String projectId, boolean isIdeSkills, String conversationId, String configName, String agentType) {
            SkillsBottomSheet skillsBottomSheet = new SkillsBottomSheet();
            Bundle bundle = new Bundle();
            if (cliId != null) {
                bundle.putString(SkillsBottomSheet.ARG_CLI_ID, cliId);
            }
            if (workspaceFolder != null) {
                bundle.putString(SkillsBottomSheet.ARG_WORKSPACE_FOLDER, workspaceFolder);
            }
            if (projectId != null) {
                bundle.putString(SkillsBottomSheet.ARG_PROJECT_ID, projectId);
            }
            bundle.putBoolean(SkillsBottomSheet.ARG_IS_IDE_SKILLS, isIdeSkills);
            if (conversationId != null) {
                bundle.putString(SkillsBottomSheet.ARG_CONVERSATION_ID, conversationId);
            }
            if (configName != null) {
                bundle.putString(SkillsBottomSheet.ARG_CONFIG_NAME, configName);
            }
            if (agentType != null) {
                bundle.putString(SkillsBottomSheet.ARG_AGENT_TYPE, agentType);
            }
            skillsBottomSheet.setArguments(bundle);
            return skillsBottomSheet;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.bottom_sheet_skills, container, false);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final Dialog dialog = (BottomSheetDialog) onCreateDialog;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.skill.SkillsBottomSheet$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                SkillsBottomSheet.onCreateDialog$lambda$1(dialog, this, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(BottomSheetDialog bottomSheetDialog, SkillsBottomSheet skillsBottomSheet, DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        if (frameLayout != null) {
            frameLayout.setBackground(new ColorDrawable(0));
            int i = (skillsBottomSheet.getResources().getDisplayMetrics().heightPixels * 9) / 10;
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
        SkillsViewModel viewModel = getViewModel();
        Bundle arguments = getArguments();
        SkillsAdapter skillsAdapter = null;
        viewModel.setCliId(arguments != null ? arguments.getString(ARG_CLI_ID) : null);
        Bundle arguments2 = getArguments();
        boolean z = arguments2 != null ? arguments2.getBoolean(ARG_IS_IDE_SKILLS) : false;
        if (!z) {
            SkillsViewModel viewModel2 = getViewModel();
            Bundle arguments3 = getArguments();
            viewModel2.setConfigName(arguments3 != null ? arguments3.getString(ARG_CONFIG_NAME) : null);
            SkillsViewModel viewModel3 = getViewModel();
            Bundle arguments4 = getArguments();
            viewModel3.setAgentType(arguments4 != null ? arguments4.getString(ARG_AGENT_TYPE) : null);
        }
        SkillsViewModel viewModel4 = getViewModel();
        Bundle arguments5 = getArguments();
        viewModel4.setWorkspaceFolder(arguments5 != null ? arguments5.getString(ARG_WORKSPACE_FOLDER) : null);
        SkillsViewModel viewModel5 = getViewModel();
        Bundle arguments6 = getArguments();
        viewModel5.setProjectId(arguments6 != null ? arguments6.getString(ARG_PROJECT_ID) : null);
        SkillsViewModel viewModel6 = getViewModel();
        Bundle arguments7 = getArguments();
        viewModel6.setConversationId(arguments7 != null ? arguments7.getString(ARG_CONVERSATION_ID) : null);
        getViewModel().loadSkills();
        final TraeTitleBar traeTitleBar = (TraeTitleBar) view.findViewById(C0637R.id.title_bar);
        final RecyclerView findViewById = view.findViewById(C0637R.id.recycler_view);
        final TextView textView = (TextView) view.findViewById(C0637R.id.tv_empty_state);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(C0637R.id.loading_container);
        final LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C0637R.id.error_container);
        final TextView textView2 = (TextView) view.findViewById(C0637R.id.tv_error_content);
        final FrameLayout frameLayout = (FrameLayout) view.findViewById(C0637R.id.search_container);
        final EditText editText = (EditText) view.findViewById(C0637R.id.et_search);
        final ImageView imageView = (ImageView) view.findViewById(C0637R.id.iv_search_clear);
        textView.setText(SkillsEmptyStateTextPolicy.INSTANCE.emptyStateTextRes(z));
        Intrinsics.checkNotNull(linearLayout);
        setupLoadingViews(linearLayout);
        linearLayout.setVisibility(0);
        startLoadingAnimation(linearLayout);
        findViewById.setVisibility(8);
        textView.setVisibility(8);
        frameLayout.setVisibility(8);
        traeTitleBar.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.skill.SkillsBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SkillsBottomSheet.this.dismiss();
            }
        });
        SkillsAdapter skillsAdapter2 = new SkillsAdapter(null, null, 3, null);
        this.adapter = skillsAdapter2;
        skillsAdapter2.setOnItemClickListener(new Function1() { // from class: com.bytedance.trae.conversation.skill.SkillsBottomSheet$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$3;
                onViewCreated$lambda$3 = SkillsBottomSheet.onViewCreated$lambda$3(SkillsBottomSheet.this, (SkillItem) obj);
                return onViewCreated$lambda$3;
            }
        });
        findViewById.setLayoutManager(new LinearLayoutManager(requireContext()));
        SkillsAdapter skillsAdapter3 = this.adapter;
        if (skillsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            skillsAdapter = skillsAdapter3;
        }
        findViewById.setAdapter(skillsAdapter);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.skill.SkillsBottomSheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SkillsBottomSheet.onViewCreated$lambda$4(editText, view2);
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.conversation.skill.SkillsBottomSheet$onViewCreated$4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                List list;
                SkillsAdapter skillsAdapter4;
                SkillsAdapter skillsAdapter5;
                List<SkillItem> list2;
                SkillsAdapter skillsAdapter6 = null;
                String obj = s != null ? s.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                String str = obj;
                imageView.setVisibility(str.length() > 0 ? 0 : 8);
                if (str.length() == 0) {
                    skillsAdapter5 = this.adapter;
                    if (skillsAdapter5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    } else {
                        skillsAdapter6 = skillsAdapter5;
                    }
                    list2 = this.fullSkillsList;
                    skillsAdapter6.updateData(list2);
                    return;
                }
                list = this.fullSkillsList;
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (StringsKt.contains(((SkillItem) obj2).getName(), str, true)) {
                        arrayList.add(obj2);
                    }
                }
                ArrayList arrayList2 = arrayList;
                skillsAdapter4 = this.adapter;
                if (skillsAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    skillsAdapter6 = skillsAdapter4;
                }
                skillsAdapter6.updateData(arrayList2);
            }
        });
        final boolean z2 = z;
        getViewModel().isDeviceProjectOffline().observe(getViewLifecycleOwner(), new SkillsBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.skill.SkillsBottomSheet$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$5;
                onViewCreated$lambda$5 = SkillsBottomSheet.onViewCreated$lambda$5(SkillsBottomSheet.this, linearLayout, findViewById, textView, frameLayout, traeTitleBar, textView2, linearLayout2, (Boolean) obj);
                return onViewCreated$lambda$5;
            }
        }));
        getViewModel().isDeviceOffline().observe(getViewLifecycleOwner(), new SkillsBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.skill.SkillsBottomSheet$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$6;
                onViewCreated$lambda$6 = SkillsBottomSheet.onViewCreated$lambda$6(SkillsBottomSheet.this, linearLayout, findViewById, textView, frameLayout, traeTitleBar, z2, textView2, linearLayout2, (Boolean) obj);
                return onViewCreated$lambda$6;
            }
        }));
        getViewModel().getError().observe(getViewLifecycleOwner(), new SkillsBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.skill.SkillsBottomSheet$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$7;
                onViewCreated$lambda$7 = SkillsBottomSheet.onViewCreated$lambda$7(SkillsBottomSheet.this, linearLayout, findViewById, textView, frameLayout, traeTitleBar, textView2, linearLayout2, (String) obj);
                return onViewCreated$lambda$7;
            }
        }));
        getViewModel().getSkills().observe(getViewLifecycleOwner(), new SkillsBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.skill.SkillsBottomSheet$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$10;
                onViewCreated$lambda$10 = SkillsBottomSheet.onViewCreated$lambda$10(SkillsBottomSheet.this, linearLayout, linearLayout2, textView, findViewById, frameLayout, (List) obj);
                return onViewCreated$lambda$10;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(SkillsBottomSheet skillsBottomSheet, SkillItem skillItem) {
        Intrinsics.checkNotNullParameter(skillItem, "skill");
        InputTracker.INSTANCE.trackSkillSelectClick(skillItem.getName());
        Function1<? super SkillItem, Unit> function1 = skillsBottomSheet.onSkillSelected;
        if (function1 != null) {
            function1.invoke(skillItem);
        }
        skillsBottomSheet.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(EditText editText, View view) {
        editText.getText().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5(SkillsBottomSheet skillsBottomSheet, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, FrameLayout frameLayout, TraeTitleBar traeTitleBar, TextView textView2, LinearLayout linearLayout2, Boolean bool) {
        if (bool.booleanValue()) {
            Intrinsics.checkNotNull(linearLayout);
            skillsBottomSheet.stopLoadingAnimation(linearLayout);
            linearLayout.setVisibility(8);
            recyclerView.setVisibility(8);
            textView.setVisibility(8);
            frameLayout.setVisibility(8);
            traeTitleBar.setTitle(C0637R.string.trae_skills_error_offline_title);
            textView2.setText(C0637R.string.trae_skills_error_project_offline_content);
            linearLayout2.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6(SkillsBottomSheet skillsBottomSheet, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, FrameLayout frameLayout, TraeTitleBar traeTitleBar, boolean z, TextView textView2, LinearLayout linearLayout2, Boolean bool) {
        int i;
        if (bool.booleanValue()) {
            Intrinsics.checkNotNull(linearLayout);
            skillsBottomSheet.stopLoadingAnimation(linearLayout);
            linearLayout.setVisibility(8);
            recyclerView.setVisibility(8);
            textView.setVisibility(8);
            frameLayout.setVisibility(8);
            traeTitleBar.setTitle(C0637R.string.trae_skills_error_offline_title);
            if (z) {
                i = C0637R.string.trae_skills_error_offline_content;
            } else {
                i = C0637R.string.trae_skills_error_lite_offline_content;
            }
            textView2.setText(i);
            linearLayout2.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7(SkillsBottomSheet skillsBottomSheet, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, FrameLayout frameLayout, TraeTitleBar traeTitleBar, TextView textView2, LinearLayout linearLayout2, String str) {
        if (str != null) {
            Intrinsics.checkNotNull(linearLayout);
            skillsBottomSheet.stopLoadingAnimation(linearLayout);
            linearLayout.setVisibility(8);
            recyclerView.setVisibility(8);
            textView.setVisibility(8);
            frameLayout.setVisibility(8);
            traeTitleBar.setTitle(C0637R.string.trae_skills_error_offline_title);
            textView2.setText(com.bytedance.trae.multilanguage.R.string.trae_conversation_network_disconnected);
            linearLayout2.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$10(SkillsBottomSheet skillsBottomSheet, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, RecyclerView recyclerView, FrameLayout frameLayout, List list) {
        int i;
        Intrinsics.checkNotNull(linearLayout);
        skillsBottomSheet.stopLoadingAnimation(linearLayout);
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(8);
        Intrinsics.checkNotNull(list);
        skillsBottomSheet.fullSkillsList = list;
        SkillsAdapter skillsAdapter = skillsBottomSheet.adapter;
        if (skillsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            skillsAdapter = null;
        }
        skillsAdapter.updateData(list);
        try {
            List list2 = list;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                i = 0;
            } else {
                Iterator it = list2.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (((SkillItem) it.next()).getEnabled() && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            InputTracker.INSTANCE.trackSkillsPanelShow(i);
        } catch (Throwable unused) {
        }
        List list3 = list;
        boolean z = true;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator it2 = list3.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (((SkillItem) it2.next()).getEnabled()) {
                    z = false;
                    break;
                }
            }
        }
        linearLayout2.setVisibility(z ? 0 : 8);
        textView.setVisibility(z ? 0 : 8);
        recyclerView.setVisibility(z ? 8 : 0);
        frameLayout.setVisibility(z ? 8 : 0);
        return Unit.INSTANCE;
    }

    private final void setupLoadingViews(LinearLayout container) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        float f = getResources().getDisplayMetrics().density;
        int i = (int) (20 * f);
        ImageView imageView = new ImageView(requireContext);
        imageView.setImageResource(C0637R.drawable.trae_ic_artifact_loading_spinner);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 1;
        imageView.setLayoutParams(layoutParams);
        container.addView(imageView);
        TextView textView = new TextView(requireContext);
        textView.setText(requireContext.getString(C0637R.string.trae_artifact_loading));
        textView.setTextColor(requireContext.getColor(C0591R.color.trae_text_text_disabled));
        textView.setTextSize(2, 15.0f);
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = (int) (8 * f);
        textView.setLayoutParams(layoutParams2);
        container.addView(textView);
    }

    private final void startLoadingAnimation(LinearLayout container) {
        View childAt = container.getChildAt(0);
        if (childAt == null) {
            return;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new StepInterpolator(8));
        childAt.startAnimation(rotateAnimation);
    }

    private final void stopLoadingAnimation(LinearLayout container) {
        View childAt = container.getChildAt(0);
        if (childAt == null) {
            return;
        }
        childAt.clearAnimation();
    }
}
