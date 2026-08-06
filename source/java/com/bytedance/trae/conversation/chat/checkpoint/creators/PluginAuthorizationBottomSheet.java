package com.bytedance.trae.conversation.chat.checkpoint.creators;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableKt;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager;
import com.bytedance.trae.conversation.widget.ShimmerTextView;
import com.github.alexzhirkevich.customqrgenerator.QrData;
import com.github.alexzhirkevich.customqrgenerator.QrErrorCorrectionLevel;
import com.github.alexzhirkevich.customqrgenerator.vector.QrCodeDrawableKt;
import com.github.alexzhirkevich.customqrgenerator.vector.QrVectorOptions;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorBallShape;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColor;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorColors;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorFrameShape;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorPixelShape;
import com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapes;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.nio.charset.Charset;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PluginAuthorizationBottomSheet.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0006H\u0002J\b\u0010%\u001a\u00020\u0007H\u0002J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0006H\u0002J \u0010(\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0006H\u0002J\u001a\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0012H\u0002J\u0010\u00102\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0006H\u0002R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00064"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onAuthResult", "Lkotlin/Function1;", "", "", "getOnAuthResult", "()Lkotlin/jvm/functions/Function1;", "setOnAuthResult", "(Lkotlin/jvm/functions/Function1;)V", "authStarted", "", "completed", "shimmerTextView", "Lcom/bytedance/trae/conversation/widget/ShimmerTextView;", "mode", "", "getMode", "()I", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "setupQrCodeMode", "provider", "setupDesktopRedirectMode", "cancelAndDismiss", "finishAuth", PageDataManager.EXTRA_STATUS, "startQrCodeAuth", "qrcodeImage", "Landroid/widget/ImageView;", "qrcodeLoading", "Landroid/widget/ProgressBar;", "startDesktopRedirectAuth", "generateQrBitmap", "Landroid/graphics/Bitmap;", ReportConstant.COMMON_CONTENT, "size", "getProviderIconRes", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginAuthorizationBottomSheet extends BottomSheetDialogFragment {
    private static final String ARG_LOCALIZED_NAME = "arg_localized_name";
    private static final String ARG_MODE = "arg_mode";
    private static final String ARG_PROVIDER = "arg_provider";
    private static final String ARG_PROVIDER_DISPLAY_NAME = "arg_provider_display_name";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MODE_DESKTOP_REDIRECT = 1;
    public static final int MODE_QRCODE = 0;
    private static final int QR_CODE_SIZE = 480;
    private static final double SCREEN_RATIO = 0.9d;
    public static final String TAG = "PluginAuthorizationBottomSheet";
    private volatile boolean authStarted;
    private volatile boolean completed;
    private Function1<? super String, Unit> onAuthResult;
    private ShimmerTextView shimmerTextView;

    public final Function1<String, Unit> getOnAuthResult() {
        return this.onAuthResult;
    }

    public final void setOnAuthResult(Function1<? super String, Unit> function1) {
        this.onAuthResult = function1;
    }

    private final int getMode() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getInt(ARG_MODE, 0);
        }
        return 0;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        Dialog dialog = (BottomSheetDialog) onCreateDialog;
        final int i = (int) (getResources().getDisplayMetrics().heightPixels * SCREEN_RATIO);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                PluginAuthorizationBottomSheet.onCreateDialog$lambda$1(PluginAuthorizationBottomSheet.this, i, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(PluginAuthorizationBottomSheet pluginAuthorizationBottomSheet, int i, DialogInterface dialogInterface) {
        View findViewById;
        if (pluginAuthorizationBottomSheet.isAdded()) {
            BottomSheetDialog bottomSheetDialog = dialogInterface instanceof BottomSheetDialog ? (BottomSheetDialog) dialogInterface : null;
            if (bottomSheetDialog == null || (findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet)) == null) {
                return;
            }
            findViewById.setBackgroundResource(android.R.color.transparent);
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            from.setPeekHeight(i);
            from.setState(3);
            from.setSkipCollapsed(true);
            from.setHideable(true);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.trae_bottom_sheet_plugin_auth_qrcode, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_PROVIDER) : null;
        if (string == null) {
            string = "";
        }
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(ARG_PROVIDER_DISPLAY_NAME) : null;
        String str = string2 != null ? string2 : "";
        ((TraeTitleBar) view.findViewById(C0637R.id.title_bar)).setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PluginAuthorizationBottomSheet.this.cancelAndDismiss();
            }
        });
        ((TextView) view.findViewById(C0637R.id.tv_footer)).setText(getString(C0637R.string.trae_plugin_authorization_desktop_footer, new Object[]{str}));
        int mode = getMode();
        if (mode == 0) {
            setupQrCodeMode(view, string);
        } else {
            if (mode != 1) {
                return;
            }
            setupDesktopRedirectMode(view, string);
        }
    }

    public void onDestroyView() {
        if (this.authStarted) {
            int mode = getMode();
            if (mode == 0) {
                PluginConnectorOAuthManager.INSTANCE.cancelQrCodeAuth();
            } else if (mode == 1) {
                PluginConnectorOAuthManager.INSTANCE.cancelDesktopRedirectAuth();
            }
        }
        if (!this.completed) {
            this.completed = true;
            Function1<? super String, Unit> function1 = this.onAuthResult;
            if (function1 != null) {
                function1.invoke("user_cancel");
            }
        }
        super.onDestroyView();
    }

    private final void setupQrCodeMode(View view, String provider) {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_LOCALIZED_NAME) : null;
        if (string == null) {
            string = "";
        }
        view.findViewById(C0637R.id.layout_qrcode_content).setVisibility(0);
        ImageView imageView = (ImageView) view.findViewById(C0637R.id.iv_provider_icon);
        TextView textView = (TextView) view.findViewById(C0637R.id.tv_status);
        TextView textView2 = (TextView) view.findViewById(C0637R.id.tv_desc);
        ImageView imageView2 = (ImageView) view.findViewById(C0637R.id.iv_qrcode);
        ProgressBar progressBar = (ProgressBar) view.findViewById(C0637R.id.pb_qrcode_loading);
        ShimmerTextView shimmerTextView = (ShimmerTextView) view.findViewById(C0637R.id.tv_qr_shimmer);
        this.shimmerTextView = shimmerTextView;
        imageView.setImageResource(getProviderIconRes(provider));
        textView.setText(getString(C0637R.string.trae_plugin_authorization_qrcode_status, new Object[]{string}));
        textView2.setText(getString(C0637R.string.trae_plugin_authorization_qrcode_desc, new Object[]{string}));
        shimmerTextView.setShimmerEnabled(true);
        Intrinsics.checkNotNull(imageView2);
        Intrinsics.checkNotNull(progressBar);
        startQrCodeAuth(provider, imageView2, progressBar);
    }

    private final void setupDesktopRedirectMode(View view, String provider) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.getString(ARG_LOCALIZED_NAME);
        }
        view.findViewById(C0637R.id.layout_desktop_content).setVisibility(0);
        ImageView imageView = (ImageView) view.findViewById(C0637R.id.iv_desktop_provider_icon);
        TextView textView = (TextView) view.findViewById(C0637R.id.tv_desktop_message);
        ShimmerTextView shimmerTextView = (ShimmerTextView) view.findViewById(C0637R.id.tv_desktop_shimmer);
        this.shimmerTextView = shimmerTextView;
        View findViewById = view.findViewById(C0637R.id.btn_desktop_cancel);
        imageView.setImageResource(getProviderIconRes(provider));
        textView.setText(getString(C0637R.string.trae_plugin_authorization_desktop_message));
        shimmerTextView.setShimmerEnabled(true);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PluginAuthorizationBottomSheet.this.cancelAndDismiss();
            }
        });
        startDesktopRedirectAuth(provider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelAndDismiss() {
        finishAuth("user_cancel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishAuth(String status) {
        if (this.completed) {
            return;
        }
        this.completed = true;
        ShimmerTextView shimmerTextView = this.shimmerTextView;
        if (shimmerTextView != null) {
            shimmerTextView.setShimmerEnabled(false);
        }
        int mode = getMode();
        if (mode == 0) {
            PluginConnectorOAuthManager.INSTANCE.cancelQrCodeAuth();
        } else if (mode == 1) {
            PluginConnectorOAuthManager.INSTANCE.cancelDesktopRedirectAuth();
        }
        this.authStarted = false;
        Function1<? super String, Unit> function1 = this.onAuthResult;
        if (function1 != null) {
            function1.invoke(status);
        }
        dismissAllowingStateLoss();
    }

    private final void startQrCodeAuth(String provider, final ImageView qrcodeImage, final ProgressBar qrcodeLoading) {
        this.authStarted = true;
        PluginConnectorOAuthManager.INSTANCE.startQrCodeAuth(provider, new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit startQrCodeAuth$lambda$5;
                startQrCodeAuth$lambda$5 = PluginAuthorizationBottomSheet.startQrCodeAuth$lambda$5(PluginAuthorizationBottomSheet.this, qrcodeLoading, qrcodeImage, (String) obj);
                return startQrCodeAuth$lambda$5;
            }
        }, new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit startQrCodeAuth$lambda$7;
                startQrCodeAuth$lambda$7 = PluginAuthorizationBottomSheet.startQrCodeAuth$lambda$7(PluginAuthorizationBottomSheet.this, (String) obj);
                return startQrCodeAuth$lambda$7;
            }
        }, new Function0() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet$$ExternalSyntheticLambda9
            public final Object invoke() {
                Unit startQrCodeAuth$lambda$9;
                startQrCodeAuth$lambda$9 = PluginAuthorizationBottomSheet.startQrCodeAuth$lambda$9(PluginAuthorizationBottomSheet.this);
                return startQrCodeAuth$lambda$9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startQrCodeAuth$lambda$5(final PluginAuthorizationBottomSheet pluginAuthorizationBottomSheet, final ProgressBar progressBar, final ImageView imageView, final String str) {
        Intrinsics.checkNotNullParameter(str, "qrcodeUrl");
        if (!pluginAuthorizationBottomSheet.isAdded()) {
            return Unit.INSTANCE;
        }
        View view = pluginAuthorizationBottomSheet.getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    PluginAuthorizationBottomSheet.startQrCodeAuth$lambda$5$lambda$4(progressBar, pluginAuthorizationBottomSheet, str, imageView);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startQrCodeAuth$lambda$5$lambda$4(ProgressBar progressBar, PluginAuthorizationBottomSheet pluginAuthorizationBottomSheet, String str, ImageView imageView) {
        progressBar.setVisibility(8);
        imageView.setImageBitmap(pluginAuthorizationBottomSheet.generateQrBitmap(str, QR_CODE_SIZE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startQrCodeAuth$lambda$7(final PluginAuthorizationBottomSheet pluginAuthorizationBottomSheet, final String str) {
        Intrinsics.checkNotNullParameter(str, PageDataManager.EXTRA_STATUS);
        pluginAuthorizationBottomSheet.authStarted = false;
        if (!pluginAuthorizationBottomSheet.isAdded()) {
            return Unit.INSTANCE;
        }
        View view = pluginAuthorizationBottomSheet.getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    PluginAuthorizationBottomSheet.this.finishAuth(str);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startQrCodeAuth$lambda$9(final PluginAuthorizationBottomSheet pluginAuthorizationBottomSheet) {
        pluginAuthorizationBottomSheet.authStarted = false;
        if (!pluginAuthorizationBottomSheet.isAdded()) {
            return Unit.INSTANCE;
        }
        View view = pluginAuthorizationBottomSheet.getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    PluginAuthorizationBottomSheet.this.finishAuth("user_cancel");
                }
            });
        }
        return Unit.INSTANCE;
    }

    private final void startDesktopRedirectAuth(String provider) {
        this.authStarted = true;
        PluginConnectorOAuthManager.INSTANCE.startDesktopRedirectAuth(provider, new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit startDesktopRedirectAuth$lambda$11;
                startDesktopRedirectAuth$lambda$11 = PluginAuthorizationBottomSheet.startDesktopRedirectAuth$lambda$11(PluginAuthorizationBottomSheet.this, (String) obj);
                return startDesktopRedirectAuth$lambda$11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startDesktopRedirectAuth$lambda$11(final PluginAuthorizationBottomSheet pluginAuthorizationBottomSheet, final String str) {
        Intrinsics.checkNotNullParameter(str, PageDataManager.EXTRA_STATUS);
        pluginAuthorizationBottomSheet.authStarted = false;
        if (!pluginAuthorizationBottomSheet.isAdded()) {
            return Unit.INSTANCE;
        }
        View view = pluginAuthorizationBottomSheet.getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    PluginAuthorizationBottomSheet.this.finishAuth(str);
                }
            });
        }
        return Unit.INSTANCE;
    }

    private final Bitmap generateQrBitmap(String content, int size) {
        return DrawableKt.toBitmap$default(QrCodeDrawableKt.QrCodeDrawable$default(new QrData.Url(content), new QrVectorOptions.Builder().setFourthEyeEnabled(false).setErrorCorrectionLevel(QrErrorCorrectionLevel.Low).setColors(new QrVectorColors(new QrVectorColor.Solid(-16777216), new QrVectorColor.Solid(-1), new QrVectorColor.Solid(-16777216), new QrVectorColor.Solid(-16777216))).setShapes(new QrVectorShapes((QrVectorPixelShape) null, (QrVectorPixelShape) null, new QrVectorBallShape.Circle(0.8f), new QrVectorFrameShape.RoundCorners(0.25f, 0.0f, false, false, false, false, 62, (DefaultConstructorMarker) null), false, 19, (DefaultConstructorMarker) null)).build(), (Charset) null, 4, (Object) null), size, size, (Bitmap.Config) null, 4, (Object) null);
    }

    private final int getProviderIconRes(String provider) {
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = provider.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int hashCode = lowerCase.hashCode();
        if (hashCode != 113006579) {
            if (hashCode != 133862058) {
                if (hashCode == 136221635 && lowerCase.equals("tencent-docs")) {
                    return C0637R.drawable.ic_plugin_auth_tencent_docs_logo;
                }
            } else if (lowerCase.equals("dingtalk")) {
                return C0637R.drawable.ic_plugin_auth_dingtalk_logo;
            }
        } else if (lowerCase.equals("wecom")) {
            return C0637R.drawable.ic_plugin_auth_wecom_logo;
        }
        return C0637R.drawable.ic_plugin_auth_link_connector;
    }

    /* compiled from: PluginAuthorizationBottomSheet.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "MODE_QRCODE", "", "MODE_DESKTOP_REDIRECT", "ARG_PROVIDER", "ARG_PROVIDER_DISPLAY_NAME", "ARG_LOCALIZED_NAME", "ARG_MODE", "SCREEN_RATIO", "", "QR_CODE_SIZE", "newInstance", "Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;", "provider", "providerDisplayName", "localizedName", "mode", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ PluginAuthorizationBottomSheet newInstance$default(Companion companion, String str, String str2, String str3, int i, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                i = 0;
            }
            return companion.newInstance(str, str2, str3, i);
        }

        public final PluginAuthorizationBottomSheet newInstance(String provider, String providerDisplayName, String localizedName, int mode) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            Intrinsics.checkNotNullParameter(providerDisplayName, "providerDisplayName");
            Intrinsics.checkNotNullParameter(localizedName, "localizedName");
            PluginAuthorizationBottomSheet pluginAuthorizationBottomSheet = new PluginAuthorizationBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(PluginAuthorizationBottomSheet.ARG_PROVIDER, provider);
            bundle.putString(PluginAuthorizationBottomSheet.ARG_PROVIDER_DISPLAY_NAME, providerDisplayName);
            bundle.putString(PluginAuthorizationBottomSheet.ARG_LOCALIZED_NAME, localizedName);
            bundle.putInt(PluginAuthorizationBottomSheet.ARG_MODE, mode);
            pluginAuthorizationBottomSheet.setArguments(bundle);
            return pluginAuthorizationBottomSheet;
        }
    }
}
