package com.bytedance.trae.conversation.brainstorm.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.VoiceAttachmentIconResolver;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormMessageKt;
import com.bytedance.trae.conversation.brainstorm.model.ParsedSubTaskTag;
import com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet;
import com.bytedance.trae.conversation.brainstorm.widget.UserHistoryPart;
import com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi;
import com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi;
import com.bytedance.trae.conversation.imageupload.ResourceRepoManager;
import com.bytedance.trae.conversation.products.FileDownloadHelper;
import com.bytedance.trae.conversation.products.InputPreviewActivity;
import com.bytedance.trae.conversation.products.MultiImagePreviewActivity;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.conversation.voice.network.GetVoiceChatHistoryData;
import com.bytedance.trae.conversation.voice.network.VoiceChatHistoryEntry;
import com.bytedance.trae.conversation.voice.subtask.SubTaskProtocolKt;
import com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: BrainstormVoiceHistorySheet.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 E2\u00020\u0001:\n<=>?@ABCDEB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0016J$\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010+\u001a\u00020)H\u0016J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0002J\u0016\u0010/\u001a\u00020)2\f\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0002J \u00103\u001a\u00020)2\f\u00104\u001a\b\u0012\u0004\u0012\u000206052\b\u00107\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u00108\u001a\u00020)H\u0002J\b\u00109\u001a\u00020)H\u0002J\u0010\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001c¨\u0006F"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "statusView", "Landroid/widget/TextView;", "emptyView", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "closeView", "Landroid/widget/ImageView;", "adapter", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;", "imageUploadApi", "Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;", "getImageUploadApi", "()Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;", "imageUploadApi$delegate", "Lkotlin/Lazy;", "resourceUploadApi", "Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "getResourceUploadApi", "()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "resourceUploadApi$delegate", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "conversationId", "getConversationId", "getTheme", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "fetchHistory", "forceRefresh", "", "renderResult", "result", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;", "showEntries", "entries", "", "Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;", "chatSessionId", "showLoading", "showEmpty", "showError", "text", "HistoryRow", "VoiceHistoryAdapter", "TextRowVH", "AssistantRowVH", "AttachmentRowVH", "ImageGroupRowVH", "VoiceHistoryImageRowAdapter", "VoiceHistoryThumbnailLoader", "VoiceHistorySnapshot", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormVoiceHistorySheet extends BottomSheetDialogFragment {
    private static final String ARG_CONVERSATION_ID = "arg_conversation_id";
    private static final String ARG_SESSION_ID = "arg_session_id";
    private static final int CACHE_MAX_SIZE = 16;
    public static final String FRAGMENT_TAG = "BrainstormVoiceHistorySheet";
    private static final String ROLE_USER = "user";
    private static final String SCENE_ID = "chat";
    private static final float SHEET_HEIGHT_RATIO = 0.8f;
    private static final String TAG = "BrainstormVoiceHistory";
    private static final int VIEW_TYPE_ASSISTANT = 0;
    private static final int VIEW_TYPE_USER_ATTACHMENT = 2;
    private static final int VIEW_TYPE_USER_IMAGE_GROUP = 3;
    private static final int VIEW_TYPE_USER_TEXT = 1;
    private VoiceHistoryAdapter adapter;
    private ImageView closeView;
    private View emptyView;
    private RecyclerView recyclerView;
    private TextView statusView;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BrainstormVoiceHistorySheet$Companion$historyCache$1 historyCache = new BrainstormVoiceHistorySheet$Companion$historyCache$1();

    /* renamed from: imageUploadApi$delegate, reason: from kotlin metadata */
    private final Lazy imageUploadApi = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$$ExternalSyntheticLambda4
        public final Object invoke() {
            ConversationCopilotImageUploadApi imageUploadApi_delegate$lambda$1;
            imageUploadApi_delegate$lambda$1 = BrainstormVoiceHistorySheet.imageUploadApi_delegate$lambda$1();
            return imageUploadApi_delegate$lambda$1;
        }
    });

    /* renamed from: resourceUploadApi$delegate, reason: from kotlin metadata */
    private final Lazy resourceUploadApi = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$$ExternalSyntheticLambda5
        public final Object invoke() {
            ConversationCopilotResourceUploadApi resourceUploadApi_delegate$lambda$3;
            resourceUploadApi_delegate$lambda$3 = BrainstormVoiceHistorySheet.resourceUploadApi_delegate$lambda$3();
            return resourceUploadApi_delegate$lambda$3;
        }
    });

    private final ConversationCopilotImageUploadApi getImageUploadApi() {
        return (ConversationCopilotImageUploadApi) this.imageUploadApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationCopilotImageUploadApi imageUploadApi_delegate$lambda$1() {
        return new ConversationCopilotImageUploadApi(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$$ExternalSyntheticLambda0
            public final Object invoke() {
                String imageUploadApi_delegate$lambda$1$lambda$0;
                imageUploadApi_delegate$lambda$1$lambda$0 = BrainstormVoiceHistorySheet.imageUploadApi_delegate$lambda$1$lambda$0();
                return imageUploadApi_delegate$lambda$1$lambda$0;
            }
        }, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String imageUploadApi_delegate$lambda$1$lambda$0() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.AI);
    }

    private final ConversationCopilotResourceUploadApi getResourceUploadApi() {
        return (ConversationCopilotResourceUploadApi) this.resourceUploadApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationCopilotResourceUploadApi resourceUploadApi_delegate$lambda$3() {
        return new ConversationCopilotResourceUploadApi(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$$ExternalSyntheticLambda3
            public final Object invoke() {
                String resourceUploadApi_delegate$lambda$3$lambda$2;
                resourceUploadApi_delegate$lambda$3$lambda$2 = BrainstormVoiceHistorySheet.resourceUploadApi_delegate$lambda$3$lambda$2();
                return resourceUploadApi_delegate$lambda$3$lambda$2;
            }
        }, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resourceUploadApi_delegate$lambda$3$lambda$2() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.AI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getSessionId() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_SESSION_ID) : null;
        return string == null ? "" : string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getConversationId() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_CONVERSATION_ID) : null;
        return string == null ? "" : string;
    }

    public int getTheme() {
        return C0637R.style.Trae_BottomSheetDialog;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(C0637R.layout.trae_layout_brainstorm_voice_history, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(C0637R.id.tv_voice_history_status);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.statusView = (TextView) findViewById;
        View findViewById2 = view.findViewById(C0637R.id.ll_voice_history_empty);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.emptyView = findViewById2;
        RecyclerView findViewById3 = view.findViewById(C0637R.id.rv_voice_history);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.recyclerView = findViewById3;
        View findViewById4 = view.findViewById(C0637R.id.iv_voice_history_close);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.closeView = (ImageView) findViewById4;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.adapter = new VoiceHistoryAdapter(this, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), getImageUploadApi(), getResourceUploadApi());
        RecyclerView recyclerView = this.recyclerView;
        TextView textView = null;
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
        VoiceHistoryAdapter voiceHistoryAdapter = this.adapter;
        if (voiceHistoryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            voiceHistoryAdapter = null;
        }
        recyclerView2.setAdapter(voiceHistoryAdapter);
        ImageView imageView = this.closeView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeView");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BrainstormVoiceHistorySheet.this.dismissAllowingStateLoss();
            }
        });
        TextView textView2 = this.statusView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BrainstormVoiceHistorySheet.this.fetchHistory(true);
            }
        });
        if (StringsKt.isBlank(getSessionId())) {
            String string = getString(C0637R.string.trae_brainstorm_voice_history_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showError(string);
        } else {
            VoiceHistorySnapshot voiceHistorySnapshot = (VoiceHistorySnapshot) historyCache.get((Object) getSessionId());
            if (voiceHistorySnapshot != null) {
                FLogger.INSTANCE.i(TAG, "cache hit: sessionId=" + getSessionId() + ", count=" + voiceHistorySnapshot.getEntries().size());
                showEntries(voiceHistorySnapshot.getEntries(), voiceHistorySnapshot.getChatSessionId());
            } else {
                fetchHistory(false);
            }
        }
    }

    public void onStart() {
        View findViewById;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (findViewById = dialog.findViewById(R.id.design_bottom_sheet)) == null) {
            return;
        }
        int i = (int) (getResources().getDisplayMetrics().heightPixels * 0.8f);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = i;
        findViewById.setLayoutParams(layoutParams);
        BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
        from.setPeekHeight(i);
        from.setHideable(true);
        from.setState(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchHistory(boolean forceRefresh) {
        VoiceHistorySnapshot voiceHistorySnapshot;
        if (!forceRefresh && (voiceHistorySnapshot = (VoiceHistorySnapshot) historyCache.get((Object) getSessionId())) != null) {
            showEntries(voiceHistorySnapshot.getEntries(), voiceHistorySnapshot.getChatSessionId());
        } else {
            showLoading();
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new BrainstormVoiceHistorySheet$fetchHistory$2(this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderResult(HttpDataResult<GetVoiceChatHistoryData> result) {
        String chatSessionId;
        if (result instanceof HttpDataResult.Success) {
            GetVoiceChatHistoryData getVoiceChatHistoryData = (GetVoiceChatHistoryData) ((HttpDataResult.Success) result).getBizResp().getData();
            String str = null;
            List<VoiceChatHistoryEntry> historyContext = getVoiceChatHistoryData != null ? getVoiceChatHistoryData.getHistoryContext() : null;
            if (historyContext == null) {
                historyContext = CollectionsKt.emptyList();
            }
            if (getVoiceChatHistoryData != null && (chatSessionId = getVoiceChatHistoryData.getChatSessionId()) != null && (!StringsKt.isBlank(chatSessionId))) {
                str = chatSessionId;
            }
            String str2 = str;
            FLogger.INSTANCE.i(TAG, "fetch success: sessionId=" + getSessionId() + ", count=" + historyContext.size() + ", hasChatSessionId=" + (true ^ (str2 == null || StringsKt.isBlank(str2))));
            if (historyContext.isEmpty()) {
                showEmpty();
                return;
            } else {
                INSTANCE.putCache(getSessionId(), new VoiceHistorySnapshot(historyContext, str));
                showEntries(historyContext, str);
                return;
            }
        }
        if (!(result instanceof HttpDataResult.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        HttpDataResult.Error error = (HttpDataResult.Error) result;
        FLogger.INSTANCE.w(TAG, "fetch error: sessionId=" + getSessionId() + ", code=" + error.getCode(), error.getThrowable());
        String string = getString(C0637R.string.trae_brainstorm_voice_history_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        showError(string);
    }

    private final void showEntries(List<VoiceChatHistoryEntry> entries, String chatSessionId) {
        VoiceHistoryAdapter voiceHistoryAdapter = this.adapter;
        RecyclerView recyclerView = null;
        if (voiceHistoryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            voiceHistoryAdapter = null;
        }
        voiceHistoryAdapter.submit(entries, chatSessionId);
        TextView textView = this.statusView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
            textView = null;
        }
        textView.setVisibility(8);
        View view = this.emptyView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            view = null;
        }
        view.setVisibility(8);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setVisibility(0);
    }

    private final void showLoading() {
        RecyclerView recyclerView = this.recyclerView;
        TextView textView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        View view = this.emptyView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            view = null;
        }
        view.setVisibility(8);
        TextView textView2 = this.statusView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
            textView2 = null;
        }
        textView2.setVisibility(0);
        TextView textView3 = this.statusView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
            textView3 = null;
        }
        textView3.setText(getString(C0637R.string.trae_brainstorm_voice_history_loading));
        TextView textView4 = this.statusView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        } else {
            textView = textView4;
        }
        textView.setClickable(false);
    }

    private final void showEmpty() {
        RecyclerView recyclerView = this.recyclerView;
        TextView textView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        TextView textView2 = this.statusView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
            textView2 = null;
        }
        textView2.setVisibility(8);
        View view = this.emptyView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            view = null;
        }
        view.setVisibility(0);
        TextView textView3 = this.statusView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        } else {
            textView = textView3;
        }
        textView.setClickable(false);
    }

    private final void showError(String text) {
        RecyclerView recyclerView = this.recyclerView;
        TextView textView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        View view = this.emptyView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            view = null;
        }
        view.setVisibility(8);
        TextView textView2 = this.statusView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
            textView2 = null;
        }
        textView2.setVisibility(0);
        TextView textView3 = this.statusView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
            textView3 = null;
        }
        textView3.setText(text);
        TextView textView4 = this.statusView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        } else {
            textView = textView4;
        }
        textView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BrainstormVoiceHistorySheet.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow;", "", "<init>", "()V", "UserText", "UserAttachment", "UserImageGroup", "AssistantText", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$AssistantText;", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserImageGroup;", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserText;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static abstract class HistoryRow {
        public /* synthetic */ HistoryRow(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: BrainstormVoiceHistorySheet.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserText;", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow;", ReportConstant.COMMON_CONTENT, "", "<init>", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class UserText extends HistoryRow {
            private final String content;

            public static /* synthetic */ UserText copy$default(UserText userText, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = userText.content;
                }
                return userText.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getContent() {
                return this.content;
            }

            public final UserText copy(String content) {
                Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
                return new UserText(content);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UserText) && Intrinsics.areEqual(this.content, ((UserText) other).content);
            }

            public int hashCode() {
                return this.content.hashCode();
            }

            public String toString() {
                return "UserText(content=" + this.content + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UserText(String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, ReportConstant.COMMON_CONTENT);
                this.content = str;
            }

            public final String getContent() {
                return this.content;
            }
        }

        private HistoryRow() {
        }

        /* compiled from: BrainstormVoiceHistorySheet.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JU\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006%"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow;", "uri", "", "filename", "isImage", "", "file_size", "", "previewImageId", "previewResourceUri", "previewChatSessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "getFilename", "()Z", "getFile_size", "()J", "getPreviewImageId", "getPreviewResourceUri", "getPreviewChatSessionId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class UserAttachment extends HistoryRow {
            private final long file_size;
            private final String filename;
            private final boolean isImage;
            private final String previewChatSessionId;
            private final String previewImageId;
            private final String previewResourceUri;
            private final String uri;

            /* renamed from: component1, reason: from getter */
            public final String getUri() {
                return this.uri;
            }

            /* renamed from: component2, reason: from getter */
            public final String getFilename() {
                return this.filename;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsImage() {
                return this.isImage;
            }

            /* renamed from: component4, reason: from getter */
            public final long getFile_size() {
                return this.file_size;
            }

            /* renamed from: component5, reason: from getter */
            public final String getPreviewImageId() {
                return this.previewImageId;
            }

            /* renamed from: component6, reason: from getter */
            public final String getPreviewResourceUri() {
                return this.previewResourceUri;
            }

            /* renamed from: component7, reason: from getter */
            public final String getPreviewChatSessionId() {
                return this.previewChatSessionId;
            }

            public final UserAttachment copy(String uri, String filename, boolean isImage, long file_size, String previewImageId, String previewResourceUri, String previewChatSessionId) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                Intrinsics.checkNotNullParameter(filename, "filename");
                return new UserAttachment(uri, filename, isImage, file_size, previewImageId, previewResourceUri, previewChatSessionId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UserAttachment)) {
                    return false;
                }
                UserAttachment userAttachment = (UserAttachment) other;
                return Intrinsics.areEqual(this.uri, userAttachment.uri) && Intrinsics.areEqual(this.filename, userAttachment.filename) && this.isImage == userAttachment.isImage && this.file_size == userAttachment.file_size && Intrinsics.areEqual(this.previewImageId, userAttachment.previewImageId) && Intrinsics.areEqual(this.previewResourceUri, userAttachment.previewResourceUri) && Intrinsics.areEqual(this.previewChatSessionId, userAttachment.previewChatSessionId);
            }

            public int hashCode() {
                int hashCode = ((((((this.uri.hashCode() * 31) + this.filename.hashCode()) * 31) + Boolean.hashCode(this.isImage)) * 31) + Long.hashCode(this.file_size)) * 31;
                String str = this.previewImageId;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.previewResourceUri;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.previewChatSessionId;
                return hashCode3 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "UserAttachment(uri=" + this.uri + ", filename=" + this.filename + ", isImage=" + this.isImage + ", file_size=" + this.file_size + ", previewImageId=" + this.previewImageId + ", previewResourceUri=" + this.previewResourceUri + ", previewChatSessionId=" + this.previewChatSessionId + ')';
            }

            public /* synthetic */ UserAttachment(String str, String str2, boolean z, long j, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, z, (i & 8) != 0 ? 0L : j, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5);
            }

            public final String getUri() {
                return this.uri;
            }

            public final String getFilename() {
                return this.filename;
            }

            public final boolean isImage() {
                return this.isImage;
            }

            public final long getFile_size() {
                return this.file_size;
            }

            public final String getPreviewImageId() {
                return this.previewImageId;
            }

            public final String getPreviewResourceUri() {
                return this.previewResourceUri;
            }

            public final String getPreviewChatSessionId() {
                return this.previewChatSessionId;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UserAttachment(String str, String str2, boolean z, long j, String str3, String str4, String str5) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "uri");
                Intrinsics.checkNotNullParameter(str2, "filename");
                this.uri = str;
                this.filename = str2;
                this.isImage = z;
                this.file_size = j;
                this.previewImageId = str3;
                this.previewResourceUri = str4;
                this.previewChatSessionId = str5;
            }
        }

        /* compiled from: BrainstormVoiceHistorySheet.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserImageGroup;", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow;", "images", "", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;", "<init>", "(Ljava/util/List;)V", "getImages", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class UserImageGroup extends HistoryRow {
            private final List<UserAttachment> images;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ UserImageGroup copy$default(UserImageGroup userImageGroup, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = userImageGroup.images;
                }
                return userImageGroup.copy(list);
            }

            public final List<UserAttachment> component1() {
                return this.images;
            }

            public final UserImageGroup copy(List<UserAttachment> images) {
                Intrinsics.checkNotNullParameter(images, "images");
                return new UserImageGroup(images);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UserImageGroup) && Intrinsics.areEqual(this.images, ((UserImageGroup) other).images);
            }

            public int hashCode() {
                return this.images.hashCode();
            }

            public String toString() {
                return "UserImageGroup(images=" + this.images + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UserImageGroup(List<UserAttachment> list) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "images");
                this.images = list;
            }

            public final List<UserAttachment> getImages() {
                return this.images;
            }
        }

        /* compiled from: BrainstormVoiceHistorySheet.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$AssistantText;", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow;", ReportConstant.COMMON_CONTENT, "", PageDataManager.EXTRA_STATUS, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getStatus", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class AssistantText extends HistoryRow {
            private final String content;
            private final String status;

            public static /* synthetic */ AssistantText copy$default(AssistantText assistantText, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = assistantText.content;
                }
                if ((i & 2) != 0) {
                    str2 = assistantText.status;
                }
                return assistantText.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getContent() {
                return this.content;
            }

            /* renamed from: component2, reason: from getter */
            public final String getStatus() {
                return this.status;
            }

            public final AssistantText copy(String content, String status) {
                Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
                return new AssistantText(content, status);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AssistantText)) {
                    return false;
                }
                AssistantText assistantText = (AssistantText) other;
                return Intrinsics.areEqual(this.content, assistantText.content) && Intrinsics.areEqual(this.status, assistantText.status);
            }

            public int hashCode() {
                int hashCode = this.content.hashCode() * 31;
                String str = this.status;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "AssistantText(content=" + this.content + ", status=" + this.status + ')';
            }

            public /* synthetic */ AssistantText(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : str2);
            }

            public final String getContent() {
                return this.content;
            }

            public final String getStatus() {
                return this.status;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AssistantText(String str, String str2) {
                super(null);
                Intrinsics.checkNotNullParameter(str, ReportConstant.COMMON_CONTENT);
                this.content = str;
                this.status = str2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BrainstormVoiceHistorySheet.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "imageUploadApi", "Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;", "resourceUploadApi", "Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "<init>", "(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;Landroidx/lifecycle/LifecycleCoroutineScope;Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;)V", "rows", "", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow;", "submit", "", "entries", "", "Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;", "historyChatSessionId", "", "getItemCount", "", "getItemViewType", NewTaskTracker.Param.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "allPreviewImageRows", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class VoiceHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final ConversationCopilotImageUploadApi imageUploadApi;
        private final LifecycleCoroutineScope lifecycleScope;
        private final ConversationCopilotResourceUploadApi resourceUploadApi;
        private final List<HistoryRow> rows;
        final /* synthetic */ BrainstormVoiceHistorySheet this$0;

        public VoiceHistoryAdapter(BrainstormVoiceHistorySheet brainstormVoiceHistorySheet, LifecycleCoroutineScope lifecycleCoroutineScope, ConversationCopilotImageUploadApi conversationCopilotImageUploadApi, ConversationCopilotResourceUploadApi conversationCopilotResourceUploadApi) {
            Intrinsics.checkNotNullParameter(lifecycleCoroutineScope, "lifecycleScope");
            Intrinsics.checkNotNullParameter(conversationCopilotImageUploadApi, "imageUploadApi");
            Intrinsics.checkNotNullParameter(conversationCopilotResourceUploadApi, "resourceUploadApi");
            this.this$0 = brainstormVoiceHistorySheet;
            this.lifecycleScope = lifecycleCoroutineScope;
            this.imageUploadApi = conversationCopilotImageUploadApi;
            this.resourceUploadApi = conversationCopilotResourceUploadApi;
            this.rows = new ArrayList();
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
        
            if (r3 != null) goto L14;
         */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00df A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00d7 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void submit(List<VoiceChatHistoryEntry> entries, String historyChatSessionId) {
            String str;
            HistoryRow.UserAttachment userAttachment;
            Intrinsics.checkNotNullParameter(entries, "entries");
            this.rows.clear();
            for (VoiceChatHistoryEntry voiceChatHistoryEntry : entries) {
                String chatSessionId = voiceChatHistoryEntry.getChatSessionId();
                String str2 = null;
                if (chatSessionId != null) {
                    if (!(!StringsKt.isBlank(chatSessionId))) {
                        chatSessionId = null;
                    }
                }
                chatSessionId = historyChatSessionId;
                if (Intrinsics.areEqual(voiceChatHistoryEntry.getRole(), "user")) {
                    List<UserHistoryPart> parseUserContent = VoiceHistoryContentParser.INSTANCE.parseUserContent(voiceChatHistoryEntry.getContent());
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (UserHistoryPart userHistoryPart : parseUserContent) {
                        if (userHistoryPart instanceof UserHistoryPart.Text) {
                            UserHistoryPart.Text text = (UserHistoryPart.Text) userHistoryPart;
                            if (!text.getFromMultimodalJson() && (!StringsKt.isBlank(text.getContent()))) {
                                this.rows.add(new HistoryRow.UserText(text.getContent()));
                            }
                        } else {
                            if (!(userHistoryPart instanceof UserHistoryPart.Attachment)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            UserHistoryPart.Attachment attachment = (UserHistoryPart.Attachment) userHistoryPart;
                            String uri = attachment.getUri();
                            String filename = attachment.getFilename();
                            boolean isImage = attachment.isImage();
                            long file_size = attachment.getFile_size();
                            String previewImageId = attachment.getPreviewImageId();
                            String previewResourceUri = attachment.getPreviewResourceUri();
                            String previewChatSessionId = attachment.getPreviewChatSessionId();
                            if (previewChatSessionId != null) {
                                if (!(!StringsKt.isBlank(previewChatSessionId))) {
                                    previewChatSessionId = null;
                                }
                                if (previewChatSessionId != null) {
                                    str = previewChatSessionId;
                                    userAttachment = new HistoryRow.UserAttachment(uri, filename, isImage, file_size, previewImageId, previewResourceUri, str);
                                    if (!userAttachment.isImage()) {
                                        arrayList.add(userAttachment);
                                    } else {
                                        arrayList2.add(userAttachment);
                                    }
                                }
                            }
                            str = chatSessionId;
                            userAttachment = new HistoryRow.UserAttachment(uri, filename, isImage, file_size, previewImageId, previewResourceUri, str);
                            if (!userAttachment.isImage()) {
                            }
                        }
                    }
                    submit$appendImageRows(arrayList, this);
                    CollectionsKt.addAll(this.rows, arrayList2);
                } else {
                    String content = voiceChatHistoryEntry.getContent();
                    if (content == null) {
                        content = "";
                    }
                    ParsedSubTaskTag parseAttachedSubTaskId = BrainstormMessageKt.parseAttachedSubTaskId(content);
                    if (!parseAttachedSubTaskId.isIncompleteHead()) {
                        content = parseAttachedSubTaskId.getCleanedText();
                    }
                    if (!StringsKt.isBlank(content)) {
                        String taskStatus = voiceChatHistoryEntry.getTaskStatus();
                        if (taskStatus != null && (!StringsKt.isBlank(taskStatus))) {
                            str2 = taskStatus;
                        }
                        this.rows.add(new HistoryRow.AssistantText(content, str2));
                    }
                }
            }
            notifyDataSetChanged();
        }

        private static final void submit$appendImageRows(ArrayList<HistoryRow.UserAttachment> arrayList, VoiceHistoryAdapter voiceHistoryAdapter) {
            int size = arrayList.size();
            if (size != 0) {
                if (size == 1) {
                    voiceHistoryAdapter.rows.add(CollectionsKt.first(arrayList));
                } else {
                    voiceHistoryAdapter.rows.add(new HistoryRow.UserImageGroup(CollectionsKt.toList(arrayList)));
                }
            }
        }

        public int getItemCount() {
            return this.rows.size();
        }

        public int getItemViewType(int position) {
            HistoryRow historyRow = this.rows.get(position);
            if (historyRow instanceof HistoryRow.UserText) {
                return 1;
            }
            if (historyRow instanceof HistoryRow.UserAttachment) {
                return 2;
            }
            if (historyRow instanceof HistoryRow.UserImageGroup) {
                return 3;
            }
            if (historyRow instanceof HistoryRow.AssistantText) {
                return 0;
            }
            throw new NoWhenBranchMatchedException();
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            LayoutInflater from = LayoutInflater.from(parent.getContext());
            if (viewType == 0) {
                View inflate = from.inflate(C0637R.layout.trae_item_voice_history_assistant, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                return new AssistantRowVH(inflate);
            }
            if (viewType == 1) {
                View inflate2 = from.inflate(C0637R.layout.trae_item_voice_history_user, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
                return new TextRowVH(inflate2);
            }
            if (viewType == 2) {
                View inflate3 = from.inflate(C0637R.layout.trae_item_brainstorm_attachment, parent, false);
                Intrinsics.checkNotNull(inflate3, "null cannot be cast to non-null type android.widget.FrameLayout");
                return new AttachmentRowVH((FrameLayout) inflate3, this.this$0.getConversationId(), this.lifecycleScope, this.imageUploadApi, this.resourceUploadApi);
            }
            if (viewType == 3) {
                View inflate4 = from.inflate(C0637R.layout.trae_item_brainstorm_attachment_group, parent, false);
                Intrinsics.checkNotNull(inflate4, "null cannot be cast to non-null type android.widget.FrameLayout");
                return new ImageGroupRowVH((FrameLayout) inflate4, this.lifecycleScope, this.imageUploadApi, this.resourceUploadApi);
            }
            throw new IllegalStateException("unknown viewType=" + viewType);
        }

        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            HistoryRow historyRow = this.rows.get(position);
            if (historyRow instanceof HistoryRow.UserText) {
                ((TextRowVH) holder).bind(((HistoryRow.UserText) historyRow).getContent());
                return;
            }
            if (historyRow instanceof HistoryRow.AssistantText) {
                ((AssistantRowVH) holder).bind((HistoryRow.AssistantText) historyRow);
            } else if (historyRow instanceof HistoryRow.UserAttachment) {
                ((AttachmentRowVH) holder).bind((HistoryRow.UserAttachment) historyRow, allPreviewImageRows());
            } else {
                if (!(historyRow instanceof HistoryRow.UserImageGroup)) {
                    throw new NoWhenBranchMatchedException();
                }
                ((ImageGroupRowVH) holder).bind(((HistoryRow.UserImageGroup) historyRow).getImages(), allPreviewImageRows());
            }
        }

        private final List<HistoryRow.UserAttachment> allPreviewImageRows() {
            List<HistoryRow.UserAttachment> images;
            List<HistoryRow> list = this.rows;
            ArrayList arrayList = new ArrayList();
            for (HistoryRow historyRow : list) {
                if (historyRow instanceof HistoryRow.UserAttachment) {
                    images = CollectionsKt.listOf(historyRow);
                } else {
                    images = historyRow instanceof HistoryRow.UserImageGroup ? ((HistoryRow.UserImageGroup) historyRow).getImages() : CollectionsKt.emptyList();
                }
                CollectionsKt.addAll(arrayList, images);
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((HistoryRow.UserAttachment) obj).isImage()) {
                    arrayList2.add(obj);
                }
            }
            return arrayList2;
        }
    }

    /* compiled from: BrainstormVoiceHistorySheet.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$TextRowVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "contentView", "Landroid/widget/TextView;", "bind", "", "text", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class TextRowVH extends RecyclerView.ViewHolder {
        private final TextView contentView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextRowVH(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(C0637R.id.tv_voice_history_content);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.contentView = (TextView) findViewById;
        }

        public final void bind(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.contentView.setText(text);
        }
    }

    /* compiled from: BrainstormVoiceHistorySheet.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "contentView", "Landroid/widget/TextView;", "badgeContainer", "badgeIcon", "Landroid/widget/ImageView;", "badgeText", "bind", "", "row", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$AssistantText;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class AssistantRowVH extends RecyclerView.ViewHolder {
        private final View badgeContainer;
        private final ImageView badgeIcon;
        private final TextView badgeText;
        private final TextView contentView;

        /* compiled from: BrainstormVoiceHistorySheet.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SubTaskRenderState.values().length];
                try {
                    iArr[SubTaskRenderState.Done.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SubTaskRenderState.Failed.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AssistantRowVH(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(C0637R.id.tv_voice_history_content);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.contentView = (TextView) findViewById;
            View findViewById2 = view.findViewById(C0637R.id.subtask_badge_container);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.badgeContainer = findViewById2;
            View findViewById3 = view.findViewById(C0637R.id.iv_subtask_status_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.badgeIcon = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(C0637R.id.tv_subtask_status_text);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.badgeText = (TextView) findViewById4;
        }

        public final void bind(HistoryRow.AssistantText row) {
            Intrinsics.checkNotNullParameter(row, "row");
            this.contentView.setText(row.getContent());
            SubTaskRenderState mapHeadStatusToTerminal = SubTaskProtocolKt.mapHeadStatusToTerminal(row.getStatus());
            int i = mapHeadStatusToTerminal == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mapHeadStatusToTerminal.ordinal()];
            if (i == 1) {
                this.badgeContainer.setVisibility(0);
                this.badgeIcon.setImageResource(C0637R.drawable.trae_ic_brainstorm_subtask_done);
                this.badgeText.setText(C0637R.string.trae_brainstorm_subtask_done);
            } else {
                if (i == 2) {
                    this.badgeContainer.setVisibility(0);
                    this.badgeIcon.setImageResource(C0637R.drawable.trae_ic_brainstorm_subtask_failed);
                    this.badgeText.setText(C0637R.string.trae_brainstorm_subtask_failed);
                    return;
                }
                this.badgeContainer.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BrainstormVoiceHistorySheet.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0#J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Landroid/widget/FrameLayout;", "conversationId", "", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "imageUploadApi", "Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;", "resourceUploadApi", "Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "<init>", "(Landroid/widget/FrameLayout;Ljava/lang/String;Landroidx/lifecycle/LifecycleCoroutineScope;Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;)V", "card", "Landroid/view/View;", "nameView", "Landroid/widget/TextView;", "typeIcon", "Landroid/widget/ImageView;", "previewView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "contentView", "Landroid/widget/LinearLayout;", "statusView", "closeView", "loadingOverlay", "failedOverlay", "previewLoader", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;", "bind", "", "row", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;", "previewRows", "", "applyTypeIcon", "applyAttachmentVisuals", "applyCardLayout", "isImage", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AttachmentRowVH extends RecyclerView.ViewHolder {
        private final View card;
        private final ImageView closeView;
        private final LinearLayout contentView;
        private final String conversationId;
        private final View failedOverlay;
        private final ConversationCopilotImageUploadApi imageUploadApi;
        private final LifecycleCoroutineScope lifecycleScope;
        private final View loadingOverlay;
        private final TextView nameView;
        private final VoiceHistoryThumbnailLoader previewLoader;
        private final SimpleDraweeView previewView;
        private final ConversationCopilotResourceUploadApi resourceUploadApi;
        private final TextView statusView;
        private final ImageView typeIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AttachmentRowVH(FrameLayout frameLayout, String str, LifecycleCoroutineScope lifecycleCoroutineScope, ConversationCopilotImageUploadApi conversationCopilotImageUploadApi, ConversationCopilotResourceUploadApi conversationCopilotResourceUploadApi) {
            super(frameLayout);
            Intrinsics.checkNotNullParameter(frameLayout, "container");
            Intrinsics.checkNotNullParameter(str, "conversationId");
            Intrinsics.checkNotNullParameter(lifecycleCoroutineScope, "lifecycleScope");
            Intrinsics.checkNotNullParameter(conversationCopilotImageUploadApi, "imageUploadApi");
            Intrinsics.checkNotNullParameter(conversationCopilotResourceUploadApi, "resourceUploadApi");
            this.conversationId = str;
            this.lifecycleScope = lifecycleCoroutineScope;
            this.imageUploadApi = conversationCopilotImageUploadApi;
            this.resourceUploadApi = conversationCopilotResourceUploadApi;
            View findViewById = frameLayout.findViewById(C0637R.id.card_attachment);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.card = findViewById;
            View findViewById2 = frameLayout.findViewById(C0637R.id.tv_attach_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.nameView = (TextView) findViewById2;
            View findViewById3 = frameLayout.findViewById(C0637R.id.iv_attach_type_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.typeIcon = (ImageView) findViewById3;
            SimpleDraweeView findViewById4 = frameLayout.findViewById(C0637R.id.iv_attach_preview);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            SimpleDraweeView simpleDraweeView = findViewById4;
            this.previewView = simpleDraweeView;
            View findViewById5 = frameLayout.findViewById(C0637R.id.ll_attach_file_content);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.contentView = (LinearLayout) findViewById5;
            View findViewById6 = frameLayout.findViewById(C0637R.id.tv_attach_status);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            TextView textView = (TextView) findViewById6;
            this.statusView = textView;
            View findViewById7 = frameLayout.findViewById(C0637R.id.iv_attach_close);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            ImageView imageView = (ImageView) findViewById7;
            this.closeView = imageView;
            View findViewById8 = frameLayout.findViewById(C0637R.id.overlay_attach_loading);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
            this.loadingOverlay = findViewById8;
            View findViewById9 = frameLayout.findViewById(C0637R.id.overlay_attach_failed);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
            this.failedOverlay = findViewById9;
            this.previewLoader = new VoiceHistoryThumbnailLoader(simpleDraweeView, lifecycleCoroutineScope, conversationCopilotImageUploadApi, conversationCopilotResourceUploadApi);
            textView.setVisibility(8);
            imageView.setVisibility(8);
            findViewById8.setVisibility(8);
            findViewById9.setVisibility(8);
            findViewById.setAlpha(1.0f);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0097  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void bind(final HistoryRow.UserAttachment row, final List<HistoryRow.UserAttachment> previewRows) {
            boolean z;
            View.OnClickListener onClickListener;
            Intrinsics.checkNotNullParameter(row, "row");
            Intrinsics.checkNotNullParameter(previewRows, "previewRows");
            this.nameView.setText(row.getFilename());
            applyTypeIcon(row);
            applyAttachmentVisuals(row);
            if (!row.isImage() && row.getFile_size() > 0) {
                this.statusView.setVisibility(0);
                this.statusView.setText(Formatter.formatShortFileSize(this.itemView.getContext(), row.getFile_size()));
            } else {
                this.statusView.setVisibility(8);
            }
            final String previewImageId = row.getPreviewImageId();
            final String previewResourceUri = row.getPreviewResourceUri();
            View view = this.card;
            String str = previewImageId;
            if (str == null || StringsKt.isBlank(str)) {
                String str2 = previewResourceUri;
                if (str2 == null || StringsKt.isBlank(str2)) {
                    z = false;
                    view.setClickable(z);
                    View view2 = this.card;
                    if (str != null || StringsKt.isBlank(str)) {
                        String str3 = previewResourceUri;
                        if (str3 == null || StringsKt.isBlank(str3)) {
                            onClickListener = null;
                            view2.setOnClickListener(onClickListener);
                        }
                    }
                    onClickListener = new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            BrainstormVoiceHistorySheet.AttachmentRowVH.bind$lambda$0(previewImageId, this, row, previewRows, previewResourceUri, view3);
                        }
                    };
                    view2.setOnClickListener(onClickListener);
                }
            }
            z = true;
            view.setClickable(z);
            View view22 = this.card;
            if (str != null || StringsKt.isBlank(str)) {
            }
            onClickListener = new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    BrainstormVoiceHistorySheet.AttachmentRowVH.bind$lambda$0(previewImageId, this, row, previewRows, previewResourceUri, view3);
                }
            };
            view22.setOnClickListener(onClickListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(String str, AttachmentRowVH attachmentRowVH, HistoryRow.UserAttachment userAttachment, List list, String str2, View view) {
            String str3 = str;
            if (!(str3 == null || StringsKt.isBlank(str3))) {
                Companion companion = BrainstormVoiceHistorySheet.INSTANCE;
                Context context = attachmentRowVH.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                companion.openImagePreview(context, userAttachment, list);
                return;
            }
            if (userAttachment.isImage()) {
                String str4 = str2;
                if (!(str4 == null || StringsKt.isBlank(str4))) {
                    Companion companion2 = BrainstormVoiceHistorySheet.INSTANCE;
                    Context context2 = attachmentRowVH.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    companion2.openImagePreview(context2, userAttachment, list);
                    return;
                }
            }
            String str5 = str2;
            if (str5 == null || StringsKt.isBlank(str5)) {
                return;
            }
            String previewChatSessionId = userAttachment.getPreviewChatSessionId();
            if (previewChatSessionId == null || StringsKt.isBlank(previewChatSessionId)) {
                FLogger.INSTANCE.w(BrainstormVoiceHistorySheet.TAG, "open attachment without chatSessionId: resourceUri=" + str2 + ", fileName=" + userAttachment.getFilename());
            }
            InputPreviewActivity.Companion companion3 = InputPreviewActivity.INSTANCE;
            Context context3 = attachmentRowVH.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            String filename = userAttachment.getFilename();
            String str6 = attachmentRowVH.conversationId;
            String previewChatSessionId2 = userAttachment.getPreviewChatSessionId();
            if (previewChatSessionId2 == null) {
                previewChatSessionId2 = "";
            }
            companion3.start(context3, str2, (r21 & 4) != 0 ? "" : filename, (r21 & 8) != 0 ? "" : str6, (r21 & 16) != 0 ? "" : previewChatSessionId2, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0 ? "" : null);
        }

        private final void applyTypeIcon(HistoryRow.UserAttachment row) {
            this.typeIcon.setImageResource(VoiceAttachmentIconResolver.getFileIconRes$default(VoiceAttachmentIconResolver.INSTANCE, row.getFilename(), null, row.isImage(), 2, null));
        }

        private final void applyAttachmentVisuals(HistoryRow.UserAttachment row) {
            applyCardLayout(row.isImage());
            this.previewView.setVisibility(row.isImage() ? 0 : 8);
            this.contentView.setVisibility(row.isImage() ^ true ? 0 : 8);
            this.typeIcon.setVisibility(row.isImage() ^ true ? 0 : 8);
            this.loadingOverlay.setVisibility(8);
            this.failedOverlay.setVisibility(8);
            this.closeView.setVisibility(8);
            if (row.isImage()) {
                this.previewLoader.load(row);
            } else {
                this.previewLoader.clear();
            }
        }

        private final void applyCardLayout(boolean isImage) {
            ViewGroup.LayoutParams layoutParams = this.card.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            ViewGroup.LayoutParams layoutParams3 = this.closeView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            if (isImage) {
                layoutParams2.width = this.itemView.getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_attachment_image_size);
                layoutParams2.height = this.itemView.getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_attachment_image_size);
                this.card.setBackgroundResource(0);
            } else {
                layoutParams2.width = this.itemView.getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_attachment_file_width);
                layoutParams2.height = this.itemView.getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_attachment_file_height);
                this.card.setBackgroundResource(C0637R.drawable.trae_bg_brainstorm_attachment_card);
            }
            layoutParams4.width = this.itemView.getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_attachment_close_size);
            layoutParams4.height = this.itemView.getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_attachment_close_size);
            layoutParams4.topMargin = this.itemView.getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_attachment_close_margin);
            layoutParams4.setMarginEnd(this.itemView.getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_attachment_close_margin));
            this.closeView.setPadding(this.itemView.getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_attachment_close_padding), this.itemView.getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_attachment_close_padding), this.itemView.getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_attachment_close_padding), this.itemView.getResources().getDimensionPixelSize(C0637R.dimen.trae_brainstorm_attachment_close_padding));
            this.card.setLayoutParams(layoutParams2);
            this.closeView.setLayoutParams(layoutParams4);
        }
    }

    /* compiled from: BrainstormVoiceHistorySheet.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$ImageGroupRowVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Landroid/widget/FrameLayout;", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "imageUploadApi", "Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;", "resourceUploadApi", "Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "<init>", "(Landroid/widget/FrameLayout;Landroidx/lifecycle/LifecycleCoroutineScope;Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;)V", "rowView", "Landroidx/recyclerview/widget/RecyclerView;", "childAdapter", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;", "bind", "", "images", "", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;", "previewRows", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class ImageGroupRowVH extends RecyclerView.ViewHolder {
        private final VoiceHistoryImageRowAdapter childAdapter;
        private final RecyclerView rowView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageGroupRowVH(FrameLayout frameLayout, LifecycleCoroutineScope lifecycleCoroutineScope, ConversationCopilotImageUploadApi conversationCopilotImageUploadApi, ConversationCopilotResourceUploadApi conversationCopilotResourceUploadApi) {
            super(frameLayout);
            Intrinsics.checkNotNullParameter(frameLayout, "container");
            Intrinsics.checkNotNullParameter(lifecycleCoroutineScope, "lifecycleScope");
            Intrinsics.checkNotNullParameter(conversationCopilotImageUploadApi, "imageUploadApi");
            Intrinsics.checkNotNullParameter(conversationCopilotResourceUploadApi, "resourceUploadApi");
            RecyclerView findViewById = frameLayout.findViewById(C0637R.id.rv_image_row);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            RecyclerView recyclerView = findViewById;
            this.rowView = recyclerView;
            VoiceHistoryImageRowAdapter voiceHistoryImageRowAdapter = new VoiceHistoryImageRowAdapter(lifecycleCoroutineScope, conversationCopilotImageUploadApi, conversationCopilotResourceUploadApi);
            this.childAdapter = voiceHistoryImageRowAdapter;
            recyclerView.setLayoutManager(new LinearLayoutManager(frameLayout.getContext(), 0, false));
            recyclerView.setAdapter(voiceHistoryImageRowAdapter);
            final int dimensionPixelSize = frameLayout.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_8);
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet.ImageGroupRowVH.1
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    if (parent.getChildAdapterPosition(view) < (parent.getAdapter() != null ? r4.getItemCount() : 0) - 1) {
                        outRect.right = dimensionPixelSize;
                    }
                }
            });
        }

        public final void bind(List<HistoryRow.UserAttachment> images, List<HistoryRow.UserAttachment> previewRows) {
            Intrinsics.checkNotNullParameter(images, "images");
            Intrinsics.checkNotNullParameter(previewRows, "previewRows");
            this.childAdapter.submit(images, previewRows);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BrainstormVoiceHistorySheet.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0012J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "imageUploadApi", "Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;", "resourceUploadApi", "Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;)V", "images", "", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;", "previewRows", "submit", "", "newImages", "", "newPreviewRows", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "onViewRecycled", "getItemCount", "ImageCellVH", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class VoiceHistoryImageRowAdapter extends RecyclerView.Adapter<ImageCellVH> {
        private final ConversationCopilotImageUploadApi imageUploadApi;
        private final List<HistoryRow.UserAttachment> images;
        private final LifecycleCoroutineScope lifecycleScope;
        private final List<HistoryRow.UserAttachment> previewRows;
        private final ConversationCopilotResourceUploadApi resourceUploadApi;

        public VoiceHistoryImageRowAdapter(LifecycleCoroutineScope lifecycleCoroutineScope, ConversationCopilotImageUploadApi conversationCopilotImageUploadApi, ConversationCopilotResourceUploadApi conversationCopilotResourceUploadApi) {
            Intrinsics.checkNotNullParameter(lifecycleCoroutineScope, "lifecycleScope");
            Intrinsics.checkNotNullParameter(conversationCopilotImageUploadApi, "imageUploadApi");
            Intrinsics.checkNotNullParameter(conversationCopilotResourceUploadApi, "resourceUploadApi");
            this.lifecycleScope = lifecycleCoroutineScope;
            this.imageUploadApi = conversationCopilotImageUploadApi;
            this.resourceUploadApi = conversationCopilotResourceUploadApi;
            this.images = new ArrayList();
            this.previewRows = new ArrayList();
        }

        public final void submit(List<HistoryRow.UserAttachment> newImages, List<HistoryRow.UserAttachment> newPreviewRows) {
            Intrinsics.checkNotNullParameter(newImages, "newImages");
            Intrinsics.checkNotNullParameter(newPreviewRows, "newPreviewRows");
            this.images.clear();
            this.images.addAll(newImages);
            this.previewRows.clear();
            this.previewRows.addAll(newPreviewRows);
            notifyDataSetChanged();
        }

        public ImageCellVH onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_brainstorm_image_cell, parent, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
            return new ImageCellVH((FrameLayout) inflate, this.lifecycleScope, this.imageUploadApi, this.resourceUploadApi);
        }

        public void onBindViewHolder(ImageCellVH holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.bind(this.images.get(position), this.previewRows);
        }

        public void onViewRecycled(ImageCellVH holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.clear();
        }

        public int getItemCount() {
            return this.images.size();
        }

        /* compiled from: BrainstormVoiceHistorySheet.kt */
        @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aJ\u0006\u0010\u001b\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Landroid/widget/FrameLayout;", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "imageUploadApi", "Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;", "resourceUploadApi", "Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "<init>", "(Landroid/widget/FrameLayout;Landroidx/lifecycle/LifecycleCoroutineScope;Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;)V", "card", "Landroid/view/View;", "previewView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "loadingOverlay", "failedOverlay", "closeView", "previewLoader", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;", "bind", "", "row", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;", "previewRows", "", "clear", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class ImageCellVH extends RecyclerView.ViewHolder {
            private final View card;
            private final View closeView;
            private final FrameLayout container;
            private final View failedOverlay;
            private final View loadingOverlay;
            private final VoiceHistoryThumbnailLoader previewLoader;
            private final SimpleDraweeView previewView;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ImageCellVH(FrameLayout frameLayout, LifecycleCoroutineScope lifecycleCoroutineScope, ConversationCopilotImageUploadApi conversationCopilotImageUploadApi, ConversationCopilotResourceUploadApi conversationCopilotResourceUploadApi) {
                super(frameLayout);
                Intrinsics.checkNotNullParameter(frameLayout, "container");
                Intrinsics.checkNotNullParameter(lifecycleCoroutineScope, "lifecycleScope");
                Intrinsics.checkNotNullParameter(conversationCopilotImageUploadApi, "imageUploadApi");
                Intrinsics.checkNotNullParameter(conversationCopilotResourceUploadApi, "resourceUploadApi");
                this.container = frameLayout;
                View findViewById = frameLayout.findViewById(C0637R.id.card_image_cell);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                this.card = findViewById;
                SimpleDraweeView findViewById2 = frameLayout.findViewById(C0637R.id.iv_cell_preview);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                SimpleDraweeView simpleDraweeView = findViewById2;
                this.previewView = simpleDraweeView;
                View findViewById3 = frameLayout.findViewById(C0637R.id.overlay_cell_loading);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
                this.loadingOverlay = findViewById3;
                View findViewById4 = frameLayout.findViewById(C0637R.id.overlay_cell_failed);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
                this.failedOverlay = findViewById4;
                View findViewById5 = frameLayout.findViewById(C0637R.id.iv_cell_close);
                Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
                this.closeView = findViewById5;
                this.previewLoader = new VoiceHistoryThumbnailLoader(simpleDraweeView, lifecycleCoroutineScope, conversationCopilotImageUploadApi, conversationCopilotResourceUploadApi);
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x0050, code lost:
            
                if ((r0 == null || kotlin.text.StringsKt.isBlank(r0)) == false) goto L18;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void bind(final HistoryRow.UserAttachment row, final List<HistoryRow.UserAttachment> previewRows) {
                Intrinsics.checkNotNullParameter(row, "row");
                Intrinsics.checkNotNullParameter(previewRows, "previewRows");
                this.loadingOverlay.setVisibility(8);
                this.failedOverlay.setVisibility(8);
                this.closeView.setVisibility(8);
                this.container.setAlpha(1.0f);
                this.previewLoader.load(row);
                String previewImageId = row.getPreviewImageId();
                boolean z = false;
                if (previewImageId == null || StringsKt.isBlank(previewImageId)) {
                    String previewResourceUri = row.getPreviewResourceUri();
                }
                z = true;
                this.card.setClickable(z);
                this.card.setOnClickListener(z ? new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BrainstormVoiceHistorySheet.VoiceHistoryImageRowAdapter.ImageCellVH.bind$lambda$0(BrainstormVoiceHistorySheet.VoiceHistoryImageRowAdapter.ImageCellVH.this, row, previewRows, view);
                    }
                } : null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void bind$lambda$0(ImageCellVH imageCellVH, HistoryRow.UserAttachment userAttachment, List list, View view) {
                Companion companion = BrainstormVoiceHistorySheet.INSTANCE;
                Context context = imageCellVH.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                companion.openImagePreview(context, userAttachment, list);
            }

            public final void clear() {
                this.previewLoader.clear();
                this.card.setOnClickListener(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BrainstormVoiceHistorySheet.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;", "", "previewView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "imageUploadApi", "Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;", "resourceUploadApi", "Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "<init>", "(Lcom/facebook/drawee/view/SimpleDraweeView;Landroidx/lifecycle/LifecycleCoroutineScope;Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;)V", "fileDownloadHelper", "Lcom/bytedance/trae/conversation/products/FileDownloadHelper;", "boundImageSource", "", "clear", "", "load", "row", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;", "loadPreviewUrl", TimonPipeline.KEY_SOURCE, IWeixinService.ResponseConstants.URL, "needDecode", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class VoiceHistoryThumbnailLoader {
        private String boundImageSource;
        private final FileDownloadHelper fileDownloadHelper;
        private final ConversationCopilotImageUploadApi imageUploadApi;
        private final LifecycleCoroutineScope lifecycleScope;
        private final SimpleDraweeView previewView;
        private final ConversationCopilotResourceUploadApi resourceUploadApi;

        public VoiceHistoryThumbnailLoader(SimpleDraweeView simpleDraweeView, LifecycleCoroutineScope lifecycleCoroutineScope, ConversationCopilotImageUploadApi conversationCopilotImageUploadApi, ConversationCopilotResourceUploadApi conversationCopilotResourceUploadApi) {
            Intrinsics.checkNotNullParameter(simpleDraweeView, "previewView");
            Intrinsics.checkNotNullParameter(lifecycleCoroutineScope, "lifecycleScope");
            Intrinsics.checkNotNullParameter(conversationCopilotImageUploadApi, "imageUploadApi");
            Intrinsics.checkNotNullParameter(conversationCopilotResourceUploadApi, "resourceUploadApi");
            this.previewView = simpleDraweeView;
            this.lifecycleScope = lifecycleCoroutineScope;
            this.imageUploadApi = conversationCopilotImageUploadApi;
            this.resourceUploadApi = conversationCopilotResourceUploadApi;
            this.fileDownloadHelper = new FileDownloadHelper();
        }

        public final void clear() {
            this.boundImageSource = null;
            this.previewView.setController((DraweeController) null);
        }

        public final void load(HistoryRow.UserAttachment row) {
            String str;
            String normalizeRemoteResourceId;
            Intrinsics.checkNotNullParameter(row, "row");
            String previewImageId = row.getPreviewImageId();
            String str2 = previewImageId;
            if (str2 == null || StringsKt.isBlank(str2)) {
                normalizeRemoteResourceId = BrainstormVoiceHistorySheetKt.normalizeRemoteResourceId(row.getPreviewResourceUri());
                str = normalizeRemoteResourceId;
            } else {
                str = null;
            }
            String str3 = previewImageId == null ? str : previewImageId;
            if (str3 == null) {
                clear();
                return;
            }
            this.boundImageSource = str3;
            this.previewView.getHierarchy().setPlaceholderImage(C0591R.drawable.trae_bg_image_loading, ScalingUtils.ScaleType.CENTER_CROP);
            this.previewView.setController((DraweeController) null);
            String str4 = ResourceRepoManager.INSTANCE.get(str3);
            if (str4 != null) {
                loadPreviewUrl(str3, str4, str != null);
            } else {
                BuildersKt.launch$default(this.lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2(this, str3, str, previewImageId, row, null), 3, (Object) null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void loadPreviewUrl(String source, String url, boolean needDecode) {
            if (!needDecode || StringsKt.startsWith$default(url, "content://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "file://", false, 2, (Object) null)) {
                this.previewView.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.parse(url)).setAutoPlayAnimations(true).setOldController(this.previewView.getController()).build());
            } else {
                BuildersKt.launch$default(this.lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new C0679x9b8e62fb(this, source, url, null), 3, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BrainstormVoiceHistorySheet.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistorySnapshot;", "", "entries", "", "Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;", "chatSessionId", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getEntries", "()Ljava/util/List;", "getChatSessionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class VoiceHistorySnapshot {
        private final String chatSessionId;
        private final List<VoiceChatHistoryEntry> entries;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VoiceHistorySnapshot copy$default(VoiceHistorySnapshot voiceHistorySnapshot, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = voiceHistorySnapshot.entries;
            }
            if ((i & 2) != 0) {
                str = voiceHistorySnapshot.chatSessionId;
            }
            return voiceHistorySnapshot.copy(list, str);
        }

        public final List<VoiceChatHistoryEntry> component1() {
            return this.entries;
        }

        /* renamed from: component2, reason: from getter */
        public final String getChatSessionId() {
            return this.chatSessionId;
        }

        public final VoiceHistorySnapshot copy(List<VoiceChatHistoryEntry> entries, String chatSessionId) {
            Intrinsics.checkNotNullParameter(entries, "entries");
            return new VoiceHistorySnapshot(entries, chatSessionId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceHistorySnapshot)) {
                return false;
            }
            VoiceHistorySnapshot voiceHistorySnapshot = (VoiceHistorySnapshot) other;
            return Intrinsics.areEqual(this.entries, voiceHistorySnapshot.entries) && Intrinsics.areEqual(this.chatSessionId, voiceHistorySnapshot.chatSessionId);
        }

        public int hashCode() {
            int hashCode = this.entries.hashCode() * 31;
            String str = this.chatSessionId;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "VoiceHistorySnapshot(entries=" + this.entries + ", chatSessionId=" + this.chatSessionId + ')';
        }

        public VoiceHistorySnapshot(List<VoiceChatHistoryEntry> list, String str) {
            Intrinsics.checkNotNullParameter(list, "entries");
            this.entries = list;
            this.chatSessionId = str;
        }

        public /* synthetic */ VoiceHistorySnapshot(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? null : str);
        }

        public final List<VoiceChatHistoryEntry> getEntries() {
            return this.entries;
        }

        public final String getChatSessionId() {
            return this.chatSessionId;
        }
    }

    /* compiled from: BrainstormVoiceHistorySheet.kt */
    @Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J&\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!H\u0002J\u001e\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006&"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;", "", "<init>", "()V", "TAG", "", "FRAGMENT_TAG", "ARG_SESSION_ID", "ARG_CONVERSATION_ID", "ROLE_USER", "VIEW_TYPE_ASSISTANT", "", "VIEW_TYPE_USER_TEXT", "VIEW_TYPE_USER_ATTACHMENT", "VIEW_TYPE_USER_IMAGE_GROUP", "SCENE_ID", "SHEET_HEIGHT_RATIO", "", "CACHE_MAX_SIZE", "historyCache", "com/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion$historyCache$1", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion$historyCache$1;", "putCache", "", "sessionId", IFileDataCacheService.TYPE_SNAPSHOT, "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistorySnapshot;", "openImagePreview", "context", "Landroid/content/Context;", "row", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;", "previewRows", "", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "conversationId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void putCache(String sessionId, VoiceHistorySnapshot snapshot) {
            BrainstormVoiceHistorySheet.historyCache.put(sessionId, snapshot);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:138:0x01e5 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:142:0x01a5 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0052 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0026 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00be A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0092 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x015d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:98:0x011d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void openImagePreview(Context context, HistoryRow.UserAttachment row, List<HistoryRow.UserAttachment> previewRows) {
            String normalizeRemoteResourceId;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            String previewImageId = row.getPreviewImageId();
            String str = previewImageId;
            if (str == null || StringsKt.isBlank(str)) {
                normalizeRemoteResourceId = BrainstormVoiceHistorySheetKt.normalizeRemoteResourceId(row.getPreviewResourceUri());
                if (normalizeRemoteResourceId == null) {
                    return;
                }
                List<HistoryRow.UserAttachment> list = previewRows;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    HistoryRow.UserAttachment userAttachment = (HistoryRow.UserAttachment) obj;
                    if (userAttachment.isImage()) {
                        String previewImageId2 = userAttachment.getPreviewImageId();
                        if (previewImageId2 == null || StringsKt.isBlank(previewImageId2)) {
                            String previewResourceUri = userAttachment.getPreviewResourceUri();
                            if (!(previewResourceUri == null || StringsKt.isBlank(previewResourceUri))) {
                                z2 = true;
                                if (!z2) {
                                    arrayList.add(obj);
                                }
                            }
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String previewResourceUri2 = ((HistoryRow.UserAttachment) it.next()).getPreviewResourceUri();
                    String normalizeRemoteResourceId2 = previewResourceUri2 != null ? BrainstormVoiceHistorySheetKt.normalizeRemoteResourceId(previewResourceUri2) : null;
                    if (normalizeRemoteResourceId2 != null) {
                        arrayList2.add(normalizeRemoteResourceId2);
                    }
                }
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = arrayList3;
                if (!arrayList4.isEmpty()) {
                    ArrayList arrayList5 = new ArrayList();
                    for (Object obj2 : list) {
                        HistoryRow.UserAttachment userAttachment2 = (HistoryRow.UserAttachment) obj2;
                        if (userAttachment2.isImage()) {
                            String previewImageId3 = userAttachment2.getPreviewImageId();
                            if (previewImageId3 == null || StringsKt.isBlank(previewImageId3)) {
                                String previewResourceUri3 = userAttachment2.getPreviewResourceUri();
                                if (!(previewResourceUri3 == null || StringsKt.isBlank(previewResourceUri3))) {
                                    z = true;
                                    if (!z) {
                                        arrayList5.add(obj2);
                                    }
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                    ArrayList arrayList6 = arrayList5;
                    ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
                    Iterator it2 = arrayList6.iterator();
                    while (it2.hasNext()) {
                        arrayList7.add(((HistoryRow.UserAttachment) it2.next()).getFilename());
                    }
                    MultiImagePreviewActivity.INSTANCE.startWithRemoteResources(context, new ArrayList<>(arrayList4), RangesKt.coerceAtLeast(arrayList3.indexOf(normalizeRemoteResourceId), 0), new ArrayList<>(arrayList7));
                    return;
                }
                return;
            }
            List<HistoryRow.UserAttachment> list2 = previewRows;
            ArrayList arrayList8 = new ArrayList();
            for (Object obj3 : list2) {
                HistoryRow.UserAttachment userAttachment3 = (HistoryRow.UserAttachment) obj3;
                if (userAttachment3.isImage()) {
                    String previewImageId4 = userAttachment3.getPreviewImageId();
                    if (!(previewImageId4 == null || StringsKt.isBlank(previewImageId4))) {
                        z4 = true;
                        if (!z4) {
                            arrayList8.add(obj3);
                        }
                    }
                }
                z4 = false;
                if (!z4) {
                }
            }
            ArrayList arrayList9 = new ArrayList();
            Iterator it3 = arrayList8.iterator();
            while (it3.hasNext()) {
                String previewImageId5 = ((HistoryRow.UserAttachment) it3.next()).getPreviewImageId();
                if (previewImageId5 != null) {
                    arrayList9.add(previewImageId5);
                }
            }
            ArrayList arrayList10 = arrayList9;
            ArrayList arrayList11 = arrayList10;
            if (!arrayList11.isEmpty()) {
                ArrayList arrayList12 = new ArrayList();
                for (Object obj4 : list2) {
                    HistoryRow.UserAttachment userAttachment4 = (HistoryRow.UserAttachment) obj4;
                    if (userAttachment4.isImage()) {
                        String previewImageId6 = userAttachment4.getPreviewImageId();
                        if (!(previewImageId6 == null || StringsKt.isBlank(previewImageId6))) {
                            z3 = true;
                            if (!z3) {
                                arrayList12.add(obj4);
                            }
                        }
                    }
                    z3 = false;
                    if (!z3) {
                    }
                }
                ArrayList arrayList13 = arrayList12;
                ArrayList arrayList14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList13, 10));
                Iterator it4 = arrayList13.iterator();
                while (it4.hasNext()) {
                    arrayList14.add(((HistoryRow.UserAttachment) it4.next()).getFilename());
                }
                MultiImagePreviewActivity.INSTANCE.startWithImageIds(context, new ArrayList<>(arrayList11), RangesKt.coerceAtLeast(arrayList10.indexOf(previewImageId), 0), new ArrayList<>(arrayList14));
            }
        }

        public final void show(FragmentManager fragmentManager, String sessionId, String conversationId) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            if (fragmentManager.findFragmentByTag(BrainstormVoiceHistorySheet.FRAGMENT_TAG) != null) {
                return;
            }
            BrainstormVoiceHistorySheet brainstormVoiceHistorySheet = new BrainstormVoiceHistorySheet();
            Bundle bundle = new Bundle();
            bundle.putString(BrainstormVoiceHistorySheet.ARG_SESSION_ID, sessionId);
            bundle.putString(BrainstormVoiceHistorySheet.ARG_CONVERSATION_ID, conversationId);
            brainstormVoiceHistorySheet.setArguments(bundle);
            brainstormVoiceHistorySheet.show(fragmentManager, BrainstormVoiceHistorySheet.FRAGMENT_TAG);
        }
    }
}
