package com.bytedance.trae.conversation.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.theme.ThemeManager;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.LoginUtils;
import com.bytedance.trae.conversation.chat.UserPayIdentityService;
import com.bytedance.trae.conversation.network.IRemoteModelsApi;
import com.bytedance.trae.conversation.network.ModelDiscountTag;
import com.bytedance.trae.conversation.network.ModelFeatureAccess;
import com.bytedance.trae.conversation.network.ModelFeatureAccessData;
import com.bytedance.trae.conversation.network.ModelFeatures;
import com.bytedance.trae.conversation.network.ModelFeaturesParser;
import com.bytedance.trae.conversation.network.ModelPricingPolicy;
import com.bytedance.trae.conversation.network.ModelPricingPresentation;
import com.bytedance.trae.conversation.network.RemoteModelItem;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.multilanguage.I18nTextProvider;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ModelSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 N2\u00020\u0001:\u0003LMNB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010)\u001a\u00020\u0007H\u0002J.\u0010*\u001a\u00020\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020\u00110\rH\u0002J\u001e\u00102\u001a\u00020\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u0002030\r2\u0006\u0010/\u001a\u000200H\u0002J(\u00104\u001a\u00020\u00072\u0006\u0010/\u001a\u0002002\b\b\u0001\u00105\u001a\u0002062\f\u0010+\u001a\b\u0012\u0004\u0012\u0002030\rH\u0002J\u0018\u00107\u001a\u00020\"2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u000203H\u0002J\u0018\u00109\u001a\u00020\"2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u000203H\u0002J\u0018\u0010:\u001a\u00020;2\u0006\u0010/\u001a\u0002002\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010>\u001a\u00020;2\u0006\u0010/\u001a\u0002002\u0006\u0010?\u001a\u00020@H\u0002J\u0018\u0010A\u001a\u00020\"2\u0006\u0010/\u001a\u0002002\u0006\u0010B\u001a\u00020\u0006H\u0002J\u0010\u0010C\u001a\u00020D2\u0006\u0010/\u001a\u000200H\u0002J\u001a\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010/\u001a\u0002002\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020H2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020\u0011H\u0002R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR.\u0010\f\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onModelSelected", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/network/RemoteModelItem;", "", "getOnModelSelected", "()Lkotlin/jvm/functions/Function1;", "setOnModelSelected", "(Lkotlin/jvm/functions/Function1;)V", "onModelListLoaded", "", "getOnModelListLoaded", "setOnModelListLoaded", "selectedModelId", "", "cliType", "Lcom/bytedance/trae/im/service/CliType;", "chatMode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "cliId", "ideVersion", "contentLayout", "Landroid/widget/LinearLayout;", "progressBar", "Landroid/widget/ProgressBar;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "loadModels", "updateModelList", "models", TimonPipeline.KEY_SOURCE, "notifyLoaded", "", "context", "Landroid/content/Context;", "resolveFunctions", "renderModels", "Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;", "addSection", "titleRes", "", "buildModelRow", "row", "buildModelContent", "buildDiscountTag", "Landroid/widget/TextView;", "tag", "Lcom/bytedance/trae/conversation/network/ModelDiscountTag;", "buildConsumptionRate", "rate", "Ljava/math/BigDecimal;", "buildModelIcon", "model", "buildFallbackModelIcon", "Landroid/widget/ImageView;", "tintedModelLogo", "Landroid/graphics/drawable/Drawable;", "colorFilter", "Landroid/graphics/PorterDuffColorFilter;", "modelIconColorFilter", "isSvgUrl", IWeixinService.ResponseConstants.URL, "ModelRowItem", "ModelListScrollView", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ModelSelectBottomSheet extends BottomSheetDialogFragment {
    private static final String ARG_CHAT_MODE = "chat_mode";
    private static final String ARG_CLI_ID = "cli_id";
    private static final String ARG_CLI_TYPE = "cli_type";
    private static final String ARG_FROM_IDE = "from_ide";
    private static final String ARG_IDE_VERSION = "ide_version";
    private static final String ARG_SELECTED_MODEL_ID = "selected_model_id";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "ModelSelectBottomSheet";
    private LinearLayout contentLayout;
    private String ideVersion;
    private Function1<? super List<RemoteModelItem>, Unit> onModelListLoaded;
    private Function1<? super RemoteModelItem, Unit> onModelSelected;
    private ProgressBar progressBar;
    private String selectedModelId = RemoteModelItem.INSTANCE.auto().getId();
    private CliType cliType = CliType.REMOTE;
    private ChatMode chatMode = ChatMode.MTC;
    private String cliId = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModelSelectBottomSheet.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;", "", "model", "Lcom/bytedance/trae/conversation/network/RemoteModelItem;", "pricing", "Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;", "<init>", "(Lcom/bytedance/trae/conversation/network/RemoteModelItem;Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;)V", "getModel", "()Lcom/bytedance/trae/conversation/network/RemoteModelItem;", "getPricing", "()Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ModelRowItem {
        private final RemoteModelItem model;
        private final ModelPricingPresentation pricing;

        public static /* synthetic */ ModelRowItem copy$default(ModelRowItem modelRowItem, RemoteModelItem remoteModelItem, ModelPricingPresentation modelPricingPresentation, int i, Object obj) {
            if ((i & 1) != 0) {
                remoteModelItem = modelRowItem.model;
            }
            if ((i & 2) != 0) {
                modelPricingPresentation = modelRowItem.pricing;
            }
            return modelRowItem.copy(remoteModelItem, modelPricingPresentation);
        }

        /* renamed from: component1, reason: from getter */
        public final RemoteModelItem getModel() {
            return this.model;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelPricingPresentation getPricing() {
            return this.pricing;
        }

        public final ModelRowItem copy(RemoteModelItem model, ModelPricingPresentation pricing) {
            Intrinsics.checkNotNullParameter(model, "model");
            Intrinsics.checkNotNullParameter(pricing, "pricing");
            return new ModelRowItem(model, pricing);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModelRowItem)) {
                return false;
            }
            ModelRowItem modelRowItem = (ModelRowItem) other;
            return Intrinsics.areEqual(this.model, modelRowItem.model) && Intrinsics.areEqual(this.pricing, modelRowItem.pricing);
        }

        public int hashCode() {
            return (this.model.hashCode() * 31) + this.pricing.hashCode();
        }

        public String toString() {
            return "ModelRowItem(model=" + this.model + ", pricing=" + this.pricing + ')';
        }

        public ModelRowItem(RemoteModelItem remoteModelItem, ModelPricingPresentation modelPricingPresentation) {
            Intrinsics.checkNotNullParameter(remoteModelItem, "model");
            Intrinsics.checkNotNullParameter(modelPricingPresentation, "pricing");
            this.model = remoteModelItem;
            this.pricing = modelPricingPresentation;
        }

        public final RemoteModelItem getModel() {
            return this.model;
        }

        public /* synthetic */ ModelRowItem(RemoteModelItem remoteModelItem, ModelPricingPresentation modelPricingPresentation, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(remoteModelItem, (i & 2) != 0 ? new ModelPricingPresentation(null, null, 3, null) : modelPricingPresentation);
        }

        public final ModelPricingPresentation getPricing() {
            return this.pricing;
        }
    }

    public final Function1<RemoteModelItem, Unit> getOnModelSelected() {
        return this.onModelSelected;
    }

    public final void setOnModelSelected(Function1<? super RemoteModelItem, Unit> function1) {
        this.onModelSelected = function1;
    }

    public final Function1<List<RemoteModelItem>, Unit> getOnModelListLoaded() {
        return this.onModelListLoaded;
    }

    public final void setOnModelListLoaded(Function1<? super List<RemoteModelItem>, Unit> function1) {
        this.onModelListLoaded = function1;
    }

    public void onCreate(Bundle savedInstanceState) {
        String id;
        CliType cliType;
        ChatMode chatMode;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (id = arguments.getString(ARG_SELECTED_MODEL_ID)) == null) {
            id = RemoteModelItem.INSTANCE.auto().getId();
        }
        this.selectedModelId = id;
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString(ARG_CLI_TYPE) : null;
        if (Intrinsics.areEqual(string, CliType.LOCAL.getValue())) {
            cliType = CliType.LOCAL;
        } else {
            cliType = Intrinsics.areEqual(string, CliType.IDE.getValue()) ? CliType.IDE : CliType.REMOTE;
        }
        this.cliType = cliType;
        Bundle arguments3 = getArguments();
        String string2 = arguments3 != null ? arguments3.getString(ARG_CHAT_MODE) : null;
        if (string2 != null && string2.hashCode() == 2074093 && string2.equals("CODE")) {
            chatMode = ChatMode.CODE;
        } else {
            chatMode = ChatMode.MTC;
        }
        this.chatMode = chatMode;
        Bundle arguments4 = getArguments();
        String string3 = arguments4 != null ? arguments4.getString(ARG_CLI_ID) : null;
        if (string3 == null) {
            string3 = "";
        }
        this.cliId = string3;
        Bundle arguments5 = getArguments();
        this.ideVersion = arguments5 != null ? arguments5.getString(ARG_IDE_VERSION) : null;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final Dialog dialog = (BottomSheetDialog) onCreateDialog;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.widget.ModelSelectBottomSheet$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ModelSelectBottomSheet.onCreateDialog$lambda$2(dialog, this, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$2(BottomSheetDialog bottomSheetDialog, ModelSelectBottomSheet modelSelectBottomSheet, DialogInterface dialogInterface) {
        View findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        if (findViewById != null) {
            findViewById.setBackgroundResource(android.R.color.transparent);
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            int i = (int) (modelSelectBottomSheet.getResources().getDisplayMetrics().heightPixels * 0.95f);
            from.setPeekHeight(i);
            from.setState(3);
            from.setSkipCollapsed(true);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundResource(C0637R.drawable.trae_bg_bottom_sheet_rounded);
        TraeTitleBar traeTitleBar = new TraeTitleBar(requireContext, null, 0, 6, null);
        TraeTitleBar.setMode$default(traeTitleBar, TraeTitleBar.Mode.SHEET, false, 2, null);
        traeTitleBar.setTitle(C0637R.string.imkit_model_title);
        traeTitleBar.setRightAction(TraeTitleBar.Action.CLOSE);
        traeTitleBar.setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.ModelSelectBottomSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModelSelectBottomSheet.this.dismissAllowingStateLoss();
            }
        });
        linearLayout.addView(traeTitleBar, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(requireContext);
        ModelListScrollView modelListScrollView = new ModelListScrollView(requireContext);
        LinearLayout linearLayout2 = new LinearLayout(requireContext);
        linearLayout2.setOrientation(1);
        linearLayout2.setPadding(0, 0, 0, linearLayout2.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_24));
        this.contentLayout = linearLayout2;
        modelListScrollView.addView(linearLayout2);
        frameLayout.addView((View) modelListScrollView, -1, -1);
        ProgressBar progressBar = new ProgressBar(requireContext);
        progressBar.setIndeterminateTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext, C0591R.color.trae_text_text_tertiary)));
        progressBar.setVisibility(8);
        this.progressBar = progressBar;
        frameLayout.addView(progressBar, new FrameLayout.LayoutParams(-2, -2, 17));
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return linearLayout;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        loadModels();
    }

    private final void loadModels() {
        List<RemoteModelItem> cachedModelsForUi;
        TraeLogUtil.INSTANCE.i(TAG, "loadModels: start, cliType=" + this.cliType + ", chatMode=" + this.chatMode + ", cliId=" + this.cliId + ", ideVersion=" + this.ideVersion);
        Context context = getContext();
        if (context == null) {
            TraeLogUtil.INSTANCE.i(TAG, "loadModels: skip, fragment context is null");
            return;
        }
        List<String> resolveFunctions = resolveFunctions();
        if (resolveFunctions.isEmpty()) {
            cachedModelsForUi = CollectionsKt.listOf(RemoteModelItem.INSTANCE.auto());
        } else {
            cachedModelsForUi = IRemoteModelsApi.INSTANCE.getCachedModelsForUi(this.cliType, this.cliId, resolveFunctions);
        }
        List<RemoteModelItem> list = cachedModelsForUi;
        if (list != null) {
            updateModelList(list, "cache", false, context);
        }
        ProgressBar progressBar = null;
        if (resolveFunctions.isEmpty()) {
            ProgressBar progressBar2 = this.progressBar;
            if (progressBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            } else {
                progressBar = progressBar2;
            }
            progressBar.setVisibility(8);
            if (list == null) {
                list = CollectionsKt.listOf(RemoteModelItem.INSTANCE.auto());
            }
            updateModelList(list, "local", true, context);
            return;
        }
        boolean z = list != null;
        ProgressBar progressBar3 = this.progressBar;
        if (progressBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        } else {
            progressBar = progressBar3;
        }
        progressBar.setVisibility(z ? 8 : 0);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ModelSelectBottomSheet$loadModels$1(this, resolveFunctions, z, list, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateModelList(List<RemoteModelItem> models, String source, boolean notifyLoaded, Context context) {
        Function1<? super List<RemoteModelItem>, Unit> function1;
        Function1<? super List<RemoteModelItem>, Unit> function12;
        boolean z;
        ModelRowItem modelRowItem;
        ModelFeatureAccess access;
        TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
        StringBuilder append = new StringBuilder("updateModelList: source=").append(source).append(", count=").append(models.size()).append(", names=");
        List<RemoteModelItem> list = models;
        List take = CollectionsKt.take(list, 6);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
        Iterator it = take.iterator();
        while (it.hasNext()) {
            arrayList.add(((RemoteModelItem) it.next()).getName());
        }
        traeLogUtil.i(TAG, append.append(arrayList).toString());
        ModelPricingPresentation modelPricingPresentation = null;
        boolean z2 = false;
        if (!AppHost.INSTANCE.isOversea() && !LoginUtils.INSTANCE.shouldSkipTocCommercialFeatures()) {
            int userPayIdentity = UserPayIdentityService.getUserPayIdentity();
            ArrayList arrayList2 = new ArrayList();
            for (RemoteModelItem remoteModelItem : list) {
                ModelFeatures parse = ModelFeaturesParser.INSTANCE.parse(remoteModelItem.getFeatures());
                if ((parse == null || (access = parse.getAccess()) == null || !access.getEnable()) ? false : true) {
                    ModelFeatureAccessData data = parse.getAccess().getData();
                    List<Integer> identityList = data != null ? data.getIdentityList() : null;
                    List<Integer> list2 = identityList;
                    if (!(list2 == null || list2.isEmpty()) && !identityList.contains(Integer.valueOf(userPayIdentity))) {
                        z = false;
                        modelRowItem = z ? null : new ModelRowItem(remoteModelItem, ModelPricingPolicy.INSTANCE.resolve(parse));
                        if (modelRowItem == null) {
                            arrayList2.add(modelRowItem);
                        }
                    }
                }
                z = true;
                if (z) {
                }
                if (modelRowItem == null) {
                }
            }
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                arrayList5.add(((ModelRowItem) it2.next()).getModel());
            }
            ArrayList arrayList6 = arrayList5;
            ArrayList arrayList7 = arrayList6;
            if (!(arrayList7 instanceof Collection) || !arrayList7.isEmpty()) {
                Iterator it3 = arrayList7.iterator();
                while (it3.hasNext()) {
                    if (Intrinsics.areEqual(((RemoteModelItem) it3.next()).getId(), this.selectedModelId)) {
                        break;
                    }
                }
            }
            z2 = true;
            if (z2) {
                this.selectedModelId = RemoteModelItem.INSTANCE.auto().getId();
            }
            if (notifyLoaded && (function12 = this.onModelListLoaded) != null) {
                function12.invoke(arrayList6);
            }
            renderModels(arrayList3, context);
            return;
        }
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it4 = list.iterator();
            while (it4.hasNext()) {
                if (Intrinsics.areEqual(((RemoteModelItem) it4.next()).getId(), this.selectedModelId)) {
                    break;
                }
            }
        }
        z2 = true;
        if (z2) {
            this.selectedModelId = RemoteModelItem.INSTANCE.auto().getId();
        }
        if (notifyLoaded && (function1 = this.onModelListLoaded) != null) {
            function1.invoke(models);
        }
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList8.add(new ModelRowItem((RemoteModelItem) it5.next(), modelPricingPresentation, 2, modelPricingPresentation));
        }
        renderModels(arrayList8, context);
    }

    private final List<String> resolveFunctions() {
        return this.cliType == CliType.IDE ? CollectionsKt.listOf("solo_agent") : (this.cliType == CliType.LOCAL && this.chatMode == ChatMode.CODE) ? CollectionsKt.listOf("solo_agent_lite") : (this.cliType == CliType.LOCAL && this.chatMode == ChatMode.MTC) ? CollectionsKt.listOf("solo_work_lite") : (this.cliType == CliType.REMOTE && this.chatMode == ChatMode.CODE) ? CollectionsKt.listOf("solo_agent_remote") : (this.cliType == CliType.REMOTE && this.chatMode == ChatMode.MTC) ? CollectionsKt.listOf("solo_work_remote") : CollectionsKt.emptyList();
    }

    private final void renderModels(List<ModelRowItem> models, Context context) {
        LinearLayout linearLayout = this.contentLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        List<ModelRowItem> list = models;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ModelRowItem) obj).getModel().isBuiltin()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (!((ModelRowItem) obj2).getModel().isBuiltin()) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = arrayList3;
        addSection(context, C0637R.string.imkit_model_builtin_models, arrayList2);
        if (!arrayList4.isEmpty()) {
            addSection(context, C0637R.string.imkit_model_custom_models, arrayList4);
        }
    }

    private final void addSection(Context context, int titleRes, List<ModelRowItem> models) {
        if (models.isEmpty()) {
            return;
        }
        LinearLayout linearLayout = this.contentLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            linearLayout = null;
        }
        TextView textView = new TextView(context);
        TextViewCompat.setTextAppearance(textView, C0637R.style.Trae_Text_ModelList_Footnote);
        textView.setText(context.getString(titleRes));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(C0591R.dimen.trae_footnote_footnote_line_height_dp));
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_12);
        layoutParams.setMarginStart(context.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_16));
        layoutParams.setMarginEnd(context.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_16));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView, layoutParams);
        LinearLayout linearLayout2 = this.contentLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            linearLayout2 = null;
        }
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(C0637R.dimen.trae_action_bar_divider_width));
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_8);
        layoutParams2.bottomMargin = context.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_8);
        layoutParams2.setMarginStart(context.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_16));
        layoutParams2.setMarginEnd(context.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_16));
        Unit unit2 = Unit.INSTANCE;
        linearLayout2.addView(view, layoutParams2);
        for (ModelRowItem modelRowItem : models) {
            LinearLayout linearLayout3 = this.contentLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                linearLayout3 = null;
            }
            linearLayout3.addView(buildModelRow(context, modelRowItem), new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(C0637R.dimen.trae_model_list_row_height)));
        }
    }

    private final View buildModelRow(Context context, ModelRowItem row) {
        final RemoteModelItem model = row.getModel();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        int dimensionPixelSize = linearLayout.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_16);
        linearLayout.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.ModelSelectBottomSheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModelSelectBottomSheet.buildModelRow$lambda$28$lambda$23(ModelSelectBottomSheet.this, model, view);
            }
        });
        linearLayout.addView(buildModelContent(context, row), new LinearLayout.LayoutParams(0, -2, 1.0f));
        BigDecimal consumptionRate = row.getPricing().getConsumptionRate();
        if (consumptionRate != null) {
            TextView buildConsumptionRate = buildConsumptionRate(context, consumptionRate);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMarginStart(linearLayout.getResources().getDimensionPixelSize(C0637R.dimen.trae_model_list_content_rate_gap));
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(buildConsumptionRate, layoutParams);
        }
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(C0637R.drawable.ic_checkmark);
        imageView.setVisibility(Intrinsics.areEqual(model.getId(), this.selectedModelId) ? 0 : 4);
        imageView.setColorFilter(ContextCompat.getColor(context, C0591R.color.trae_icon_icon_brand));
        ImageView imageView2 = imageView;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(linearLayout.getResources().getDimensionPixelSize(C0637R.dimen.trae_model_list_icon_size), linearLayout.getResources().getDimensionPixelSize(C0637R.dimen.trae_model_list_icon_size));
        layoutParams2.setMarginStart(linearLayout.getResources().getDimensionPixelSize(row.getPricing().getConsumptionRate() == null ? C0637R.dimen.trae_dp_8 : C0637R.dimen.trae_model_list_content_rate_gap));
        Unit unit2 = Unit.INSTANCE;
        linearLayout.addView(imageView2, layoutParams2);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildModelRow$lambda$28$lambda$23(ModelSelectBottomSheet modelSelectBottomSheet, RemoteModelItem remoteModelItem, View view) {
        Function1<? super RemoteModelItem, Unit> function1 = modelSelectBottomSheet.onModelSelected;
        if (function1 != null) {
            function1.invoke(remoteModelItem);
        }
        modelSelectBottomSheet.dismissAllowingStateLoss();
    }

    private final View buildModelContent(Context context, ModelRowItem row) {
        TextView textView;
        View constraintLayout = new ConstraintLayout(context);
        View buildModelIcon = buildModelIcon(context, row.getModel());
        buildModelIcon.setId(View.generateViewId());
        TextView textView2 = new TextView(context);
        textView2.setId(View.generateViewId());
        TextViewCompat.setTextAppearance(textView2, C0637R.style.Trae_Text_ModelList_Name);
        textView2.setText(row.getModel().getDisplayName());
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        ModelDiscountTag discountTag = row.getPricing().getDiscountTag();
        if (discountTag != null) {
            textView = buildDiscountTag(context, discountTag);
            textView.setId(View.generateViewId());
        } else {
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(constraintLayout.getResources().getDimensionPixelSize(C0637R.dimen.trae_model_list_icon_size), constraintLayout.getResources().getDimensionPixelSize(C0637R.dimen.trae_model_list_icon_size));
        ((ConstraintLayout.LayoutParams) layoutParams).startToStart = 0;
        ((ConstraintLayout.LayoutParams) layoutParams).endToStart = textView2.getId();
        ((ConstraintLayout.LayoutParams) layoutParams).topToTop = 0;
        ((ConstraintLayout.LayoutParams) layoutParams).bottomToBottom = 0;
        ((ConstraintLayout.LayoutParams) layoutParams).horizontalChainStyle = 2;
        ((ConstraintLayout.LayoutParams) layoutParams).horizontalBias = 0.0f;
        Unit unit = Unit.INSTANCE;
        constraintLayout.addView(buildModelIcon, layoutParams);
        TextView textView3 = textView2;
        ViewGroup.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ConstraintLayout.LayoutParams) layoutParams2).startToEnd = buildModelIcon.getId();
        if (textView == null) {
            ((ConstraintLayout.LayoutParams) layoutParams2).endToEnd = 0;
        } else {
            ((ConstraintLayout.LayoutParams) layoutParams2).endToStart = textView.getId();
        }
        ((ConstraintLayout.LayoutParams) layoutParams2).topToTop = 0;
        ((ConstraintLayout.LayoutParams) layoutParams2).bottomToBottom = 0;
        layoutParams2.setMarginStart(constraintLayout.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_8));
        ((ConstraintLayout.LayoutParams) layoutParams2).constrainedWidth = true;
        Unit unit2 = Unit.INSTANCE;
        constraintLayout.addView(textView3, layoutParams2);
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, constraintLayout.getResources().getDimensionPixelSize(C0637R.dimen.trae_model_list_tag_height));
            ((ConstraintLayout.LayoutParams) layoutParams3).startToEnd = textView2.getId();
            ((ConstraintLayout.LayoutParams) layoutParams3).endToEnd = 0;
            ((ConstraintLayout.LayoutParams) layoutParams3).topToTop = 0;
            ((ConstraintLayout.LayoutParams) layoutParams3).bottomToBottom = 0;
            layoutParams3.setMarginStart(constraintLayout.getResources().getDimensionPixelSize(C0637R.dimen.trae_model_list_name_tag_gap));
            ((ConstraintLayout.LayoutParams) layoutParams3).constrainedWidth = true;
            Unit unit3 = Unit.INSTANCE;
            constraintLayout.addView(textView, layoutParams3);
        }
        return constraintLayout;
    }

    private final TextView buildDiscountTag(Context context, ModelDiscountTag tag) {
        String string;
        TextView textView = new TextView(context);
        TextViewCompat.setTextAppearance(textView, C0637R.style.Trae_Text_ModelList_Tag);
        if (tag instanceof ModelDiscountTag.Member) {
            I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ModelDiscountTag.Member member = (ModelDiscountTag.Member) tag;
            string = i18nTextProvider.getString(resources, com.bytedance.trae.multilanguage.R.string.business_member_discount, new Object[]{member.getDiscountFactor(), member.getOffPercent()});
        } else {
            if (!Intrinsics.areEqual(tag, ModelDiscountTag.Exclusive.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            I18nTextProvider i18nTextProvider2 = I18nTextProvider.INSTANCE;
            Resources resources2 = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
            string = i18nTextProvider2.getString(resources2, com.bytedance.trae.multilanguage.R.string.business_exclusive_discount, new Object[0]);
        }
        textView.setText(string);
        textView.setGravity(17);
        textView.setMinWidth(textView.getResources().getDimensionPixelSize(C0637R.dimen.trae_model_list_tag_min_width));
        textView.setPadding(textView.getResources().getDimensionPixelSize(C0637R.dimen.trae_model_list_tag_padding_start), 0, textView.getResources().getDimensionPixelSize(C0637R.dimen.trae_model_list_tag_padding_end), 0);
        textView.setBackgroundResource(C0637R.drawable.trae_bg_model_discount_tag);
        return textView;
    }

    private final TextView buildConsumptionRate(Context context, BigDecimal rate) {
        TextView textView = new TextView(context);
        TextViewCompat.setTextAppearance(textView, C0637R.style.Trae_Text_ModelList_Footnote);
        textView.setText(context.getString(C0637R.string.imkit_model_discount_rate_format, ModelPricingPolicy.INSTANCE.formatRateNumber(rate)));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    private final View buildModelIcon(Context context, RemoteModelItem model) {
        String iconLight;
        if (Intrinsics.areEqual(model.getId(), RemoteModelItem.INSTANCE.auto().getId())) {
            return buildFallbackModelIcon(context);
        }
        if (ThemeManager.INSTANCE.isDarkMode()) {
            iconLight = model.getIconDark();
            if (iconLight == null) {
                iconLight = model.getIconLight();
            }
        } else {
            iconLight = model.getIconLight();
            if (iconLight == null) {
                iconLight = model.getIconDark();
            }
        }
        String str = iconLight;
        if (str == null || StringsKt.isBlank(str)) {
            return buildFallbackModelIcon(context);
        }
        View simpleDraweeView = new SimpleDraweeView(context);
        PorterDuffColorFilter modelIconColorFilter = modelIconColorFilter(context);
        simpleDraweeView.setHierarchy(GenericDraweeHierarchyBuilder.newInstance(context.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setActualImageColorFilter(modelIconColorFilter).setPlaceholderImage(tintedModelLogo(context, modelIconColorFilter)).setFailureImage(tintedModelLogo(context, modelIconColorFilter)).build());
        if (isSvgUrl(iconLight)) {
            simpleDraweeView.setLayerType(1, (Paint) null);
        }
        simpleDraweeView.setImageURI(Uri.parse(iconLight));
        return simpleDraweeView;
    }

    private final ImageView buildFallbackModelIcon(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(tintedModelLogo(context, modelIconColorFilter(context)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return imageView;
    }

    private final Drawable tintedModelLogo(Context context, PorterDuffColorFilter colorFilter) {
        Drawable mutate;
        Drawable drawable = ContextCompat.getDrawable(context, C0637R.drawable.logo);
        if (drawable == null || (mutate = drawable.mutate()) == null) {
            return null;
        }
        mutate.setColorFilter(colorFilter);
        return mutate;
    }

    private final PorterDuffColorFilter modelIconColorFilter(Context context) {
        return new PorterDuffColorFilter(ContextCompat.getColor(context, C0591R.color.trae_icon_icon_default), PorterDuff.Mode.SRC_IN);
    }

    private final boolean isSvgUrl(String url) {
        String path = Uri.parse(url).getPath();
        return path != null && StringsKt.endsWith(path, ".svg", true);
    }

    /* compiled from: ModelSelectBottomSheet.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelListScrollView;", "Landroidx/core/widget/NestedScrollView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "lastY", "", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class ModelListScrollView extends NestedScrollView {
        private float lastY;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModelListScrollView(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
        
            if (r0 != 3) goto L29;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean dispatchTouchEvent(MotionEvent ev) {
            Intrinsics.checkNotNullParameter(ev, "ev");
            int actionMasked = ev.getActionMasked();
            if (actionMasked == 0) {
                this.lastY = ev.getY();
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else {
                boolean z = false;
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        if ((ev.getY() > this.lastY) && !canScrollVertically(-1)) {
                            z = true;
                        }
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true ^ z);
                        }
                        this.lastY = ev.getY();
                    }
                }
                ViewParent parent3 = getParent();
                if (parent3 != null) {
                    parent3.requestDisallowInterceptTouchEvent(false);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
    }

    /* compiled from: ModelSelectBottomSheet.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "ARG_SELECTED_MODEL_ID", "ARG_CLI_TYPE", "ARG_CHAT_MODE", "ARG_CLI_ID", "ARG_IDE_VERSION", "ARG_FROM_IDE", "newInstance", "Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;", "selectedModelId", "cliType", "Lcom/bytedance/trae/im/service/CliType;", "chatMode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "cliId", "ideVersion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ModelSelectBottomSheet newInstance(String selectedModelId, CliType cliType, ChatMode chatMode, String cliId, String ideVersion) {
            Intrinsics.checkNotNullParameter(selectedModelId, "selectedModelId");
            Intrinsics.checkNotNullParameter(cliType, "cliType");
            Intrinsics.checkNotNullParameter(chatMode, "chatMode");
            Intrinsics.checkNotNullParameter(cliId, "cliId");
            ModelSelectBottomSheet modelSelectBottomSheet = new ModelSelectBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(ModelSelectBottomSheet.ARG_SELECTED_MODEL_ID, selectedModelId);
            bundle.putString(ModelSelectBottomSheet.ARG_CLI_TYPE, cliType.getValue());
            bundle.putString(ModelSelectBottomSheet.ARG_CHAT_MODE, chatMode.name());
            bundle.putString(ModelSelectBottomSheet.ARG_CLI_ID, cliId);
            bundle.putString(ModelSelectBottomSheet.ARG_IDE_VERSION, ideVersion);
            modelSelectBottomSheet.setArguments(bundle);
            return modelSelectBottomSheet;
        }
    }
}
