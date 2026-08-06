package com.bytedance.trae.conversation.products;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.products.IShareLinkApi;
import com.bytedance.trae.network.response.HttpDataResult;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: ShareLinkBottomSheet.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 82\u00020\u0001:\u000278B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J(\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J.\u0010.\u001a\u00020%2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0082@¢\u0006\u0002\u0010/J.\u00100\u001a\u00020%2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0082@¢\u0006\u0002\u0010/J\b\u00101\u001a\u00020%H\u0002J(\u00102\u001a\u00020%2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\b\u00103\u001a\u00020%H\u0016J\b\u00104\u001a\u00020%H\u0002J\b\u00105\u001a\u00020%H\u0002J\b\u00106\u001a\u00020%H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onShareStateChangedListener", "Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$OnShareStateChangedListener;", "getOnShareStateChangedListener", "()Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$OnShareStateChangedListener;", "setOnShareStateChangedListener", "(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$OnShareStateChangedListener;)V", "shareUrl", "", "shareId", "shareSessionId", "chatSessionId", "messageId", "artifactPath", "conversationId", "isLocal", "", "initialShareUrl", "initialShareId", "autoDismissHandler", "Landroid/os/Handler;", "revertCopyStateRunnable", "Ljava/lang/Runnable;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "requestShareLink", "loadingContainer", "successContainer", "loadingIcon", "Landroid/widget/ImageView;", "tvShareUrl", "Landroid/widget/TextView;", "requestRemoteShareLink", "(Landroid/view/View;Landroid/view/View;Landroid/widget/ImageView;Landroid/widget/TextView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestLocalShareLink", "copyToClipboard", "showSuccess", "onDestroyView", "trackShareStop", "trackShareShow", "trackShareShowSuccess", "OnShareStateChangedListener", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ShareLinkBottomSheet extends BottomSheetDialogFragment {
    private static final long AUTO_DISMISS_DELAY_MS = 5000;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "ShareLinkBottomSheet";
    private String initialShareId;
    private String initialShareUrl;
    private boolean isLocal;
    private String messageId;
    private OnShareStateChangedListener onShareStateChangedListener;
    private String shareId;
    private String shareSessionId;
    private String shareUrl;
    private String chatSessionId = "";
    private String artifactPath = "";
    private String conversationId = "";
    private final Handler autoDismissHandler = new Handler(Looper.getMainLooper());
    private final Runnable revertCopyStateRunnable = new Runnable() { // from class: com.bytedance.trae.conversation.products.ShareLinkBottomSheet$$ExternalSyntheticLambda5
        @Override // java.lang.Runnable
        public final void run() {
            ShareLinkBottomSheet.revertCopyStateRunnable$lambda$0(ShareLinkBottomSheet.this);
        }
    };

    /* compiled from: ShareLinkBottomSheet.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$OnShareStateChangedListener;", "", "onShareCreated", "", "shareUrl", "", "shareId", "onShareStopped", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface OnShareStateChangedListener {
        void onShareCreated(String shareUrl, String shareId);

        void onShareStopped();
    }

    public final OnShareStateChangedListener getOnShareStateChangedListener() {
        return this.onShareStateChangedListener;
    }

    public final void setOnShareStateChangedListener(OnShareStateChangedListener onShareStateChangedListener) {
        this.onShareStateChangedListener = onShareStateChangedListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void revertCopyStateRunnable$lambda$0(ShareLinkBottomSheet shareLinkBottomSheet) {
        View view;
        if (shareLinkBottomSheet.isAdded() && (view = shareLinkBottomSheet.getView()) != null) {
            View findViewById = view.findViewById(C0637R.id.btn_copy_link);
            view.findViewById(C0637R.id.btn_copied).setVisibility(8);
            findViewById.setVisibility(0);
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        Dialog dialog = (BottomSheetDialog) onCreateDialog;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.products.ShareLinkBottomSheet$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ShareLinkBottomSheet.onCreateDialog$lambda$1(ShareLinkBottomSheet.this, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(ShareLinkBottomSheet shareLinkBottomSheet, DialogInterface dialogInterface) {
        View findViewById;
        if (shareLinkBottomSheet.isAdded()) {
            BottomSheetDialog bottomSheetDialog = dialogInterface instanceof BottomSheetDialog ? (BottomSheetDialog) dialogInterface : null;
            if (bottomSheetDialog == null || (findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet)) == null) {
                return;
            }
            findViewById.setBackgroundResource(android.R.color.transparent);
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            from.setState(3);
            from.setSkipCollapsed(true);
            from.setHideable(true);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.trae_dialog_share_link, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TraeTitleBar traeTitleBar = (TraeTitleBar) view.findViewById(C0637R.id.title_bar);
        final View findViewById = view.findViewById(C0637R.id.btn_generate_container);
        final View findViewById2 = view.findViewById(C0637R.id.btn_generate_link);
        final View findViewById3 = view.findViewById(C0637R.id.ll_generating);
        final View findViewById4 = view.findViewById(C0637R.id.success_container);
        final ImageView imageView = (ImageView) view.findViewById(C0637R.id.iv_loading);
        final TextView textView = (TextView) view.findViewById(C0637R.id.tv_share_url);
        View findViewById5 = view.findViewById(C0637R.id.btn_stop_sharing);
        final View findViewById6 = view.findViewById(C0637R.id.btn_copy_link);
        final View findViewById7 = view.findViewById(C0637R.id.btn_copied);
        final TextView textView2 = (TextView) view.findViewById(C0637R.id.share_link_desc);
        traeTitleBar.setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.ShareLinkBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShareLinkBottomSheet.this.dismiss();
            }
        });
        String str = this.initialShareUrl;
        if (!(str == null || str.length() == 0)) {
            textView2.setText(C0637R.string.trae_html_artifact_share_link_desc_shared);
            this.shareUrl = this.initialShareUrl;
            if (this.isLocal) {
                this.shareId = this.initialShareId;
            } else {
                this.shareSessionId = this.initialShareId;
            }
            findViewById.setVisibility(8);
            findViewById3.setVisibility(8);
            Object drawable = imageView.getDrawable();
            Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
            if (animatable != null) {
                animatable.stop();
            }
            findViewById4.setVisibility(0);
            textView.setText(this.shareUrl);
            trackShareShowSuccess();
        }
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.ShareLinkBottomSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShareLinkBottomSheet.onViewCreated$lambda$3(findViewById2, findViewById3, imageView, this, findViewById, findViewById4, textView, view2);
            }
        });
        findViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.ShareLinkBottomSheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShareLinkBottomSheet.onViewCreated$lambda$4(ShareLinkBottomSheet.this, textView2, findViewById4, findViewById, findViewById3, findViewById2, view2);
            }
        });
        findViewById6.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.ShareLinkBottomSheet$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShareLinkBottomSheet.onViewCreated$lambda$5(ShareLinkBottomSheet.this, findViewById6, findViewById7, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(View view, View view2, ImageView imageView, ShareLinkBottomSheet shareLinkBottomSheet, View view3, View view4, TextView textView, View view5) {
        view.setVisibility(8);
        view2.setVisibility(0);
        Object drawable = imageView.getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable != null) {
            animatable.start();
        }
        Intrinsics.checkNotNull(view3);
        Intrinsics.checkNotNull(view4);
        Intrinsics.checkNotNull(imageView);
        Intrinsics.checkNotNull(textView);
        shareLinkBottomSheet.requestShareLink(view3, view4, imageView, textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(ShareLinkBottomSheet shareLinkBottomSheet, TextView textView, View view, View view2, View view3, View view4, View view5) {
        shareLinkBottomSheet.trackShareStop();
        if (!shareLinkBottomSheet.isLocal) {
            String str = shareLinkBottomSheet.shareSessionId;
            if (str != null) {
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) shareLinkBottomSheet), (CoroutineContext) null, (CoroutineStart) null, new ShareLinkBottomSheet$onViewCreated$3$1(str, null), 3, (Object) null);
            }
            shareLinkBottomSheet.shareSessionId = null;
        } else {
            String str2 = shareLinkBottomSheet.shareId;
            if (str2 != null) {
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) shareLinkBottomSheet), (CoroutineContext) null, (CoroutineStart) null, new ShareLinkBottomSheet$onViewCreated$3$2(shareLinkBottomSheet, str2, null), 3, (Object) null);
            }
            shareLinkBottomSheet.shareId = null;
        }
        shareLinkBottomSheet.autoDismissHandler.removeCallbacks(shareLinkBottomSheet.revertCopyStateRunnable);
        shareLinkBottomSheet.shareUrl = null;
        OnShareStateChangedListener onShareStateChangedListener = shareLinkBottomSheet.onShareStateChangedListener;
        if (onShareStateChangedListener != null) {
            onShareStateChangedListener.onShareStopped();
        }
        textView.setText(C0637R.string.trae_html_artifact_share_link_desc);
        view.setVisibility(8);
        view2.setVisibility(0);
        view3.setVisibility(8);
        view4.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(ShareLinkBottomSheet shareLinkBottomSheet, View view, View view2, View view3) {
        shareLinkBottomSheet.copyToClipboard();
        view.setVisibility(8);
        view2.setVisibility(0);
        shareLinkBottomSheet.autoDismissHandler.removeCallbacks(shareLinkBottomSheet.revertCopyStateRunnable);
        shareLinkBottomSheet.autoDismissHandler.postDelayed(shareLinkBottomSheet.revertCopyStateRunnable, 5000L);
    }

    private final void requestShareLink(View loadingContainer, View successContainer, ImageView loadingIcon, TextView tvShareUrl) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ShareLinkBottomSheet$requestShareLink$1(this, loadingContainer, successContainer, loadingIcon, tvShareUrl, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestRemoteShareLink(View view, View view2, ImageView imageView, TextView textView, Continuation<? super Unit> continuation) {
        ShareLinkBottomSheet$requestRemoteShareLink$1 shareLinkBottomSheet$requestRemoteShareLink$1;
        Object coroutine_suspended;
        int i;
        View view3;
        ImageView imageView2;
        TextView textView2;
        ShareLinkBottomSheet shareLinkBottomSheet;
        View view4;
        CoroutineContext main;
        ShareLinkBottomSheet$requestRemoteShareLink$2 shareLinkBottomSheet$requestRemoteShareLink$2;
        if (continuation instanceof ShareLinkBottomSheet$requestRemoteShareLink$1) {
            shareLinkBottomSheet$requestRemoteShareLink$1 = (ShareLinkBottomSheet$requestRemoteShareLink$1) continuation;
            if ((shareLinkBottomSheet$requestRemoteShareLink$1.label & Integer.MIN_VALUE) != 0) {
                shareLinkBottomSheet$requestRemoteShareLink$1.label -= Integer.MIN_VALUE;
                Object obj = shareLinkBottomSheet$requestRemoteShareLink$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = shareLinkBottomSheet$requestRemoteShareLink$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    IShareLinkApi.Companion companion = IShareLinkApi.INSTANCE;
                    String str = this.chatSessionId;
                    String str2 = this.artifactPath;
                    ShareLinkRequest shareLinkRequest = new ShareLinkRequest(str, str2, StringsKt.substringAfterLast$default(str2, "/", (String) null, 2, (Object) null));
                    shareLinkBottomSheet$requestRemoteShareLink$1.L$0 = this;
                    shareLinkBottomSheet$requestRemoteShareLink$1.L$1 = view;
                    shareLinkBottomSheet$requestRemoteShareLink$1.L$2 = view2;
                    shareLinkBottomSheet$requestRemoteShareLink$1.L$3 = imageView;
                    shareLinkBottomSheet$requestRemoteShareLink$1.L$4 = textView;
                    shareLinkBottomSheet$requestRemoteShareLink$1.label = 1;
                    obj = companion.createShareLink(shareLinkRequest, shareLinkBottomSheet$requestRemoteShareLink$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    view3 = view2;
                    imageView2 = imageView;
                    textView2 = textView;
                    shareLinkBottomSheet = this;
                    view4 = view;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    TextView textView3 = (TextView) shareLinkBottomSheet$requestRemoteShareLink$1.L$4;
                    ImageView imageView3 = (ImageView) shareLinkBottomSheet$requestRemoteShareLink$1.L$3;
                    View view5 = (View) shareLinkBottomSheet$requestRemoteShareLink$1.L$2;
                    View view6 = (View) shareLinkBottomSheet$requestRemoteShareLink$1.L$1;
                    ShareLinkBottomSheet shareLinkBottomSheet2 = (ShareLinkBottomSheet) shareLinkBottomSheet$requestRemoteShareLink$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    textView2 = textView3;
                    imageView2 = imageView3;
                    view3 = view5;
                    view4 = view6;
                    shareLinkBottomSheet = shareLinkBottomSheet2;
                }
                HttpDataResult httpDataResult = (HttpDataResult) obj;
                main = Dispatchers.getMain();
                shareLinkBottomSheet$requestRemoteShareLink$2 = new ShareLinkBottomSheet$requestRemoteShareLink$2(shareLinkBottomSheet, httpDataResult, view4, view3, imageView2, textView2, null);
                shareLinkBottomSheet$requestRemoteShareLink$1.L$0 = null;
                shareLinkBottomSheet$requestRemoteShareLink$1.L$1 = null;
                shareLinkBottomSheet$requestRemoteShareLink$1.L$2 = null;
                shareLinkBottomSheet$requestRemoteShareLink$1.L$3 = null;
                shareLinkBottomSheet$requestRemoteShareLink$1.L$4 = null;
                shareLinkBottomSheet$requestRemoteShareLink$1.label = 2;
                if (BuildersKt.withContext(main, shareLinkBottomSheet$requestRemoteShareLink$2, shareLinkBottomSheet$requestRemoteShareLink$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        shareLinkBottomSheet$requestRemoteShareLink$1 = new ShareLinkBottomSheet$requestRemoteShareLink$1(this, continuation);
        Object obj2 = shareLinkBottomSheet$requestRemoteShareLink$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = shareLinkBottomSheet$requestRemoteShareLink$1.label;
        if (i != 0) {
        }
        HttpDataResult httpDataResult2 = (HttpDataResult) obj2;
        main = Dispatchers.getMain();
        shareLinkBottomSheet$requestRemoteShareLink$2 = new ShareLinkBottomSheet$requestRemoteShareLink$2(shareLinkBottomSheet, httpDataResult2, view4, view3, imageView2, textView2, null);
        shareLinkBottomSheet$requestRemoteShareLink$1.L$0 = null;
        shareLinkBottomSheet$requestRemoteShareLink$1.L$1 = null;
        shareLinkBottomSheet$requestRemoteShareLink$1.L$2 = null;
        shareLinkBottomSheet$requestRemoteShareLink$1.L$3 = null;
        shareLinkBottomSheet$requestRemoteShareLink$1.L$4 = null;
        shareLinkBottomSheet$requestRemoteShareLink$1.label = 2;
        if (BuildersKt.withContext(main, shareLinkBottomSheet$requestRemoteShareLink$2, shareLinkBottomSheet$requestRemoteShareLink$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestLocalShareLink(View view, View view2, ImageView imageView, TextView textView, Continuation<? super Unit> continuation) {
        ShareLinkBottomSheet$requestLocalShareLink$1 shareLinkBottomSheet$requestLocalShareLink$1;
        Object coroutine_suspended;
        int i;
        ImageView imageView2;
        TextView textView2;
        View view3;
        View view4;
        ShareLinkBottomSheet shareLinkBottomSheet;
        CoroutineContext main;
        ShareLinkBottomSheet$requestLocalShareLink$2 shareLinkBottomSheet$requestLocalShareLink$2;
        if (continuation instanceof ShareLinkBottomSheet$requestLocalShareLink$1) {
            shareLinkBottomSheet$requestLocalShareLink$1 = (ShareLinkBottomSheet$requestLocalShareLink$1) continuation;
            if ((shareLinkBottomSheet$requestLocalShareLink$1.label & Integer.MIN_VALUE) != 0) {
                shareLinkBottomSheet$requestLocalShareLink$1.label -= Integer.MIN_VALUE;
                Object obj = shareLinkBottomSheet$requestLocalShareLink$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = shareLinkBottomSheet$requestLocalShareLink$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    IShareLinkApi.Companion companion = IShareLinkApi.INSTANCE;
                    LocalShareLinkRequest localShareLinkRequest = new LocalShareLinkRequest(this.conversationId, this.artifactPath);
                    shareLinkBottomSheet$requestLocalShareLink$1.L$0 = this;
                    shareLinkBottomSheet$requestLocalShareLink$1.L$1 = view;
                    shareLinkBottomSheet$requestLocalShareLink$1.L$2 = view2;
                    shareLinkBottomSheet$requestLocalShareLink$1.L$3 = imageView;
                    shareLinkBottomSheet$requestLocalShareLink$1.L$4 = textView;
                    shareLinkBottomSheet$requestLocalShareLink$1.label = 1;
                    obj = companion.createLocalShareLink(localShareLinkRequest, shareLinkBottomSheet$requestLocalShareLink$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    imageView2 = imageView;
                    textView2 = textView;
                    view3 = view;
                    view4 = view2;
                    shareLinkBottomSheet = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    TextView textView3 = (TextView) shareLinkBottomSheet$requestLocalShareLink$1.L$4;
                    ImageView imageView3 = (ImageView) shareLinkBottomSheet$requestLocalShareLink$1.L$3;
                    View view5 = (View) shareLinkBottomSheet$requestLocalShareLink$1.L$2;
                    View view6 = (View) shareLinkBottomSheet$requestLocalShareLink$1.L$1;
                    ShareLinkBottomSheet shareLinkBottomSheet2 = (ShareLinkBottomSheet) shareLinkBottomSheet$requestLocalShareLink$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    textView2 = textView3;
                    imageView2 = imageView3;
                    view4 = view5;
                    shareLinkBottomSheet = shareLinkBottomSheet2;
                    view3 = view6;
                }
                HttpDataResult httpDataResult = (HttpDataResult) obj;
                main = Dispatchers.getMain();
                shareLinkBottomSheet$requestLocalShareLink$2 = new ShareLinkBottomSheet$requestLocalShareLink$2(shareLinkBottomSheet, httpDataResult, view3, view4, imageView2, textView2, null);
                shareLinkBottomSheet$requestLocalShareLink$1.L$0 = null;
                shareLinkBottomSheet$requestLocalShareLink$1.L$1 = null;
                shareLinkBottomSheet$requestLocalShareLink$1.L$2 = null;
                shareLinkBottomSheet$requestLocalShareLink$1.L$3 = null;
                shareLinkBottomSheet$requestLocalShareLink$1.L$4 = null;
                shareLinkBottomSheet$requestLocalShareLink$1.label = 2;
                if (BuildersKt.withContext(main, shareLinkBottomSheet$requestLocalShareLink$2, shareLinkBottomSheet$requestLocalShareLink$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        shareLinkBottomSheet$requestLocalShareLink$1 = new ShareLinkBottomSheet$requestLocalShareLink$1(this, continuation);
        Object obj2 = shareLinkBottomSheet$requestLocalShareLink$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = shareLinkBottomSheet$requestLocalShareLink$1.label;
        if (i != 0) {
        }
        HttpDataResult httpDataResult2 = (HttpDataResult) obj2;
        main = Dispatchers.getMain();
        shareLinkBottomSheet$requestLocalShareLink$2 = new ShareLinkBottomSheet$requestLocalShareLink$2(shareLinkBottomSheet, httpDataResult2, view3, view4, imageView2, textView2, null);
        shareLinkBottomSheet$requestLocalShareLink$1.L$0 = null;
        shareLinkBottomSheet$requestLocalShareLink$1.L$1 = null;
        shareLinkBottomSheet$requestLocalShareLink$1.L$2 = null;
        shareLinkBottomSheet$requestLocalShareLink$1.L$3 = null;
        shareLinkBottomSheet$requestLocalShareLink$1.L$4 = null;
        shareLinkBottomSheet$requestLocalShareLink$1.label = 2;
        if (BuildersKt.withContext(main, shareLinkBottomSheet$requestLocalShareLink$2, shareLinkBottomSheet$requestLocalShareLink$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void copyToClipboard() {
        Context context;
        String str = this.shareUrl;
        if (str == null || (context = getContext()) == null) {
            return;
        }
        Object systemService = context.getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("share_link", str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSuccess(View loadingContainer, View successContainer, ImageView loadingIcon, TextView tvShareUrl) {
        TextView textView;
        loadingContainer.setVisibility(8);
        successContainer.setVisibility(0);
        Object drawable = loadingIcon.getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable != null) {
            animatable.stop();
        }
        tvShareUrl.setText(this.shareUrl);
        View view = getView();
        if (view != null && (textView = (TextView) view.findViewById(C0637R.id.share_link_desc)) != null) {
            textView.setText(C0637R.string.trae_html_artifact_share_link_desc_shared);
        }
        View view2 = getView();
        View findViewById = view2 != null ? view2.findViewById(C0637R.id.btn_copy_link) : null;
        View view3 = getView();
        View findViewById2 = view3 != null ? view3.findViewById(C0637R.id.btn_copied) : null;
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
        }
        this.autoDismissHandler.removeCallbacks(this.revertCopyStateRunnable);
        this.autoDismissHandler.postDelayed(this.revertCopyStateRunnable, 5000L);
    }

    public void onDestroyView() {
        this.autoDismissHandler.removeCallbacks(this.revertCopyStateRunnable);
        super.onDestroyView();
    }

    private final void trackShareStop() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("artifact_type", this.isLocal ? "local" : "remote");
            jSONObject.put("share_url", this.shareUrl);
            if (this.isLocal) {
                jSONObject.put("share_id", this.shareId);
            } else {
                jSONObject.put("share_id", this.shareSessionId);
            }
            jSONObject.put("artifact_id", this.messageId + '_' + this.artifactPath);
            IApplog.INSTANCE.reportEvent("icube_artifact_html_share_stop_click", jSONObject);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackShareShow() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("artifact_type", this.isLocal ? "local" : "remote");
            jSONObject.put(PageDataManager.EXTRA_STATUS, "fail");
            jSONObject.put("artifact_id", this.messageId + '_' + this.artifactPath);
            IApplog.INSTANCE.reportEvent("icube_artifact_html_share_show", jSONObject);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackShareShowSuccess() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("artifact_type", this.isLocal ? "local" : "remote");
            jSONObject.put("share_url", this.shareUrl);
            jSONObject.put(PageDataManager.EXTRA_STATUS, "success");
            if (this.isLocal) {
                jSONObject.put("share_id", this.shareId);
            } else {
                jSONObject.put("share_id", this.shareSessionId);
            }
            jSONObject.put("artifact_id", this.messageId + '_' + this.artifactPath);
            IApplog.INSTANCE.reportEvent("icube_artifact_html_share_show", jSONObject);
        } catch (Throwable unused) {
        }
    }

    /* compiled from: ShareLinkBottomSheet.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0005JN\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "AUTO_DISMISS_DELAY_MS", "", "getShareHost", "newInstance", "Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;", "chatSessionId", "artifactPath", "conversationId", "isLocal", "", "existingShareUrl", "existingShareId", "messageId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getShareHost() {
            return AppHost.INSTANCE.isOversea() ? "https://share.traecontent.com/artifact/" : "https://share.traecontent.cn/artifact/";
        }

        public final ShareLinkBottomSheet newInstance(String chatSessionId, String artifactPath, String conversationId, boolean isLocal, String existingShareUrl, String existingShareId, String messageId) {
            Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
            Intrinsics.checkNotNullParameter(artifactPath, "artifactPath");
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            ShareLinkBottomSheet shareLinkBottomSheet = new ShareLinkBottomSheet();
            shareLinkBottomSheet.chatSessionId = chatSessionId;
            shareLinkBottomSheet.artifactPath = artifactPath;
            shareLinkBottomSheet.conversationId = conversationId;
            shareLinkBottomSheet.isLocal = isLocal;
            shareLinkBottomSheet.initialShareUrl = existingShareUrl;
            shareLinkBottomSheet.initialShareId = existingShareId;
            shareLinkBottomSheet.messageId = messageId;
            return shareLinkBottomSheet;
        }
    }
}
