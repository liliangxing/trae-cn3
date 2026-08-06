package com.bytedance.trae.conversation.chat.checkpoint.creators;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator;
import com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet;
import com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator;
import com.bytedance.trae.conversation.plugin.PluginListCache;
import com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager;
import com.bytedance.trae.conversation.tracker.PluginTracker;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: PluginAuthorizationDialogCreator.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 :2\u00020\u0001:\u00029:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\u001dH\u0016JB\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u000f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0%2\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\f0(H\u0016JV\u0010)\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u000f2\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\f0(H\u0002J^\u0010/\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u000f2\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\f0(H\u0002J^\u00100\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u000f2\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\f0(H\u0002J^\u00101\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u000f2\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\f0(H\u0002J^\u00102\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u000f2\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\f0(H\u0002J\u0010\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0002J \u00105\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0002J\u0010\u00107\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0018\u00108\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;", "Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;", "<init>", "()V", "descriptor", "Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;", "resolvedName", "", "resolvedNameForPlugin", "originalParams", "Lcom/google/gson/JsonObject;", "setResolvedDisplayName", "", "name", "createContentView", "Landroid/view/View;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "getTitle", "getPrimaryButtonText", "getSecondaryButtonText", "hideDefaultButtons", "", "showCloseButton", "getTitleTextColorRes", "", "getTitleLetterSpacing", "", "getHeaderLabel", "getContentTopMarginRes", "bindActions", "contentView", "onConfirm", "Lkotlin/Function0;", "onSkip", "onConfirmWithParams", "Lkotlin/Function1;", "bindQrCodeActions", "provider", "btnCancel", "btnAuthorize", "actionsLayout", "successLayout", "bindBrowserActions", "bindCustomAuthPollingActions", "bindWebViewActions", "bindDesktopRedirectActions", "buildAuthorizationParams", PageDataManager.EXTRA_STATUS, "reportAuthOutcome", "authMethod", "getProviderIconRes", "getLocalizedProviderName", "PluginAuthorizationDescriptor", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginAuthorizationDialogCreator implements ICheckpointDialogCreator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String SERVICE_SEPARATOR = "::";

    @Deprecated
    public static final float TITLE_LETTER_SPACING_EM = -0.0253f;
    private PluginAuthorizationDescriptor descriptor;
    private JsonObject originalParams;
    private String resolvedName;
    private String resolvedNameForPlugin;

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getHeaderLabel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public float getTitleLetterSpacing() {
        return -0.0253f;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public boolean hideDefaultButtons() {
        return true;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public boolean showCloseButton() {
        return false;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void bindActions(View view, Function0<Unit> function0, Function0<Unit> function02) {
        ICheckpointDialogCreator.DefaultImpls.bindActions(this, view, function0, function02);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getCHECK_POINT_TAG() {
        return ICheckpointDialogCreator.DefaultImpls.getCHECK_POINT_TAG(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public int getContentTopMarginDp() {
        return ICheckpointDialogCreator.DefaultImpls.getContentTopMarginDp(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public int getPrimaryButtonBackgroundRes() {
        return ICheckpointDialogCreator.DefaultImpls.getPrimaryButtonBackgroundRes(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void setFileClickListener(Function1<? super String, Unit> function1) {
        ICheckpointDialogCreator.DefaultImpls.setFileClickListener(this, function1);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void setResolvedDisplayName(String name) {
        this.resolvedName = name;
        PluginAuthorizationDescriptor pluginAuthorizationDescriptor = this.descriptor;
        this.resolvedNameForPlugin = pluginAuthorizationDescriptor != null ? pluginAuthorizationDescriptor.getPluginName() : null;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public View createContentView(Context context, ParsedToolCallInfo toolCallInfo, ConfirmInfo confirmInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        this.resolvedName = null;
        this.resolvedNameForPlugin = null;
        this.descriptor = PluginAuthorizationDescriptor.INSTANCE.from(toolCallInfo);
        JsonObject params = toolCallInfo.getParams();
        this.originalParams = params != null ? params.deepCopy() : null;
        PluginAuthorizationDescriptor pluginAuthorizationDescriptor = this.descriptor;
        Intrinsics.checkNotNull(pluginAuthorizationDescriptor);
        pluginAuthorizationDescriptor.getProviderRaw();
        View inflate = LayoutInflater.from(context).inflate(C0637R.layout.trae_plugin_authorization_checkpoint_content, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(C0637R.id.tv_plugin_authorization_body);
        int i = C0637R.string.trae_plugin_authorization_body;
        PluginAuthorizationDescriptor pluginAuthorizationDescriptor2 = this.descriptor;
        Intrinsics.checkNotNull(pluginAuthorizationDescriptor2);
        textView.setText(context.getString(i, getLocalizedProviderName(context, pluginAuthorizationDescriptor2.getProviderRaw())));
        Intrinsics.checkNotNullExpressionValue(inflate, "also(...)");
        return inflate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        if (r2 != null) goto L17;
     */
    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getTitle(Context context, ParsedToolCallInfo toolCallInfo) {
        String localizedProviderName;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        PluginAuthorizationDescriptor from = PluginAuthorizationDescriptor.INSTANCE.from(toolCallInfo);
        this.descriptor = from;
        if (this.originalParams == null) {
            JsonObject params = toolCallInfo.getParams();
            this.originalParams = params != null ? params.deepCopy() : null;
        }
        String str = this.resolvedName;
        if (str != null) {
            localizedProviderName = Intrinsics.areEqual(this.resolvedNameForPlugin, from.getPluginName()) ? str : null;
        }
        localizedProviderName = getLocalizedProviderName(context, from.getProviderRaw());
        String string = context.getString(C0637R.string.trae_plugin_authorization_title, localizedProviderName);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getPrimaryButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(C0637R.string.trae_plugin_authorization_authorize);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getSecondaryButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(C0637R.string.trae_plugin_authorization_cancel);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public int getTitleTextColorRes() {
        return C0637R.color.trae_plugin_authorization_title_text;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public int getContentTopMarginRes() {
        return C0637R.dimen.trae_plugin_authorization_title_body_gap;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void bindActions(View contentView, Function0<Unit> onConfirm, Function0<Unit> onSkip, Function1<? super String, Unit> onConfirmWithParams) {
        String str;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onSkip, "onSkip");
        Intrinsics.checkNotNullParameter(onConfirmWithParams, "onConfirmWithParams");
        Context context = contentView.getContext();
        PluginAuthorizationDescriptor pluginAuthorizationDescriptor = this.descriptor;
        String providerRaw = pluginAuthorizationDescriptor != null ? pluginAuthorizationDescriptor.getProviderRaw() : null;
        String str2 = providerRaw == null ? "" : providerRaw;
        View findViewById = contentView.findViewById(C0637R.id.btn_plugin_authorization_cancel);
        View findViewById2 = contentView.findViewById(C0637R.id.btn_plugin_authorization_authorize);
        View findViewById3 = contentView.findViewById(C0637R.id.layout_plugin_authorization_actions);
        View findViewById4 = contentView.findViewById(C0637R.id.layout_plugin_authorization_success);
        TextView textView = (TextView) contentView.findViewById(C0637R.id.tv_plugin_authorization_success_name);
        if (textView != null) {
            String str3 = this.resolvedName;
            if (str3 != null) {
                str = str3;
            } else {
                PluginAuthorizationDescriptor pluginAuthorizationDescriptor2 = this.descriptor;
                String pluginDisplayName = pluginAuthorizationDescriptor2 != null ? pluginAuthorizationDescriptor2.getPluginDisplayName() : null;
                str = pluginDisplayName != null ? pluginDisplayName : "";
            }
            textView.setText(str);
        }
        if (PluginConnectorOAuthManager.INSTANCE.isDesktopRedirectProvider(str2)) {
            Intrinsics.checkNotNull(context);
            bindDesktopRedirectActions(context, contentView, str2, findViewById, findViewById2, findViewById3, findViewById4, onConfirmWithParams);
            return;
        }
        if (PluginConnectorOAuthManager.INSTANCE.isQrCodeProvider(str2)) {
            bindQrCodeActions(contentView, str2, findViewById, findViewById2, findViewById3, findViewById4, onConfirmWithParams);
            return;
        }
        if (PluginConnectorOAuthManager.INSTANCE.isCustomAuthPollingProvider(str2)) {
            Intrinsics.checkNotNull(context);
            bindCustomAuthPollingActions(context, str2, findViewById, findViewById2, findViewById3, contentView, findViewById4, onConfirmWithParams);
        } else if (PluginConnectorOAuthManager.INSTANCE.isWebViewProvider(str2)) {
            Intrinsics.checkNotNull(context);
            bindWebViewActions(context, str2, findViewById, findViewById2, findViewById3, contentView, findViewById4, onConfirmWithParams);
        } else {
            Intrinsics.checkNotNull(context);
            bindBrowserActions(context, str2, findViewById, findViewById2, findViewById3, contentView, findViewById4, onConfirmWithParams);
        }
    }

    private final void bindQrCodeActions(final View contentView, final String provider, View btnCancel, final View btnAuthorize, final View actionsLayout, final View successLayout, final Function1<? super String, Unit> onConfirmWithParams) {
        if (btnCancel != null) {
            btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PluginAuthorizationDialogCreator.bindQrCodeActions$lambda$2(PluginAuthorizationDialogCreator.this, onConfirmWithParams, view);
                }
            });
        }
        if (btnAuthorize != null) {
            btnAuthorize.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PluginAuthorizationDialogCreator.bindQrCodeActions$lambda$5(btnAuthorize, provider, contentView, this, onConfirmWithParams, actionsLayout, successLayout, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindQrCodeActions$lambda$2(PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, Function1 function1, View view) {
        PluginConnectorOAuthManager.INSTANCE.cancelQrCodeAuth();
        function1.invoke(pluginAuthorizationDialogCreator.buildAuthorizationParams("user_cancel"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindQrCodeActions$lambda$5(final View view, final String str, final View view2, final PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, final Function1 function1, final View view3, final View view4, View view5) {
        view.setEnabled(false);
        PluginTracker.INSTANCE.trackAuthStart(str, "chat_hint");
        FragmentActivity context = view2.getContext();
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? context : null;
        if (fragmentActivity == null) {
            PluginTracker.INSTANCE.trackAuthFail(str, "host_activity_not_found");
            view.setEnabled(true);
            return;
        }
        Context context2 = view2.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        String localizedProviderName = pluginAuthorizationDialogCreator.getLocalizedProviderName(context2, str);
        PluginAuthorizationBottomSheet.Companion companion = PluginAuthorizationBottomSheet.INSTANCE;
        PluginAuthorizationDescriptor pluginAuthorizationDescriptor = pluginAuthorizationDialogCreator.descriptor;
        String providerDisplayName = pluginAuthorizationDescriptor != null ? pluginAuthorizationDescriptor.getProviderDisplayName() : null;
        if (providerDisplayName == null) {
            providerDisplayName = "";
        }
        PluginAuthorizationBottomSheet newInstance$default = PluginAuthorizationBottomSheet.Companion.newInstance$default(companion, str, providerDisplayName, localizedProviderName, 0, 8, null);
        newInstance$default.setOnAuthResult(new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit bindQrCodeActions$lambda$5$lambda$4;
                bindQrCodeActions$lambda$5$lambda$4 = PluginAuthorizationDialogCreator.bindQrCodeActions$lambda$5$lambda$4(PluginAuthorizationDialogCreator.this, str, view2, function1, view3, view4, view, (String) obj);
                return bindQrCodeActions$lambda$5$lambda$4;
            }
        });
        newInstance$default.show(fragmentActivity.getSupportFragmentManager(), PluginAuthorizationBottomSheet.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindQrCodeActions$lambda$5$lambda$4(PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, String str, final View view, Function1 function1, final View view2, final View view3, final View view4, final String str2) {
        Intrinsics.checkNotNullParameter(str2, PageDataManager.EXTRA_STATUS);
        pluginAuthorizationDialogCreator.reportAuthOutcome(str, str2, "bot_scan");
        view.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                PluginAuthorizationDialogCreator.bindQrCodeActions$lambda$5$lambda$4$lambda$3(str2, view2, view, view3, view4);
            }
        });
        function1.invoke(pluginAuthorizationDialogCreator.buildAuthorizationParams(str2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindQrCodeActions$lambda$5$lambda$4$lambda$3(String str, View view, View view2, View view3, View view4) {
        if (Intrinsics.areEqual(str, "success")) {
            if (view != null) {
                view.setVisibility(8);
            }
            View findViewById = view2.findViewById(C0637R.id.tv_plugin_authorization_body);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (view3 != null) {
                view3.setVisibility(0);
            }
        }
        view4.setEnabled(true);
    }

    private final void bindBrowserActions(final Context context, final String provider, View btnCancel, final View btnAuthorize, final View actionsLayout, final View contentView, final View successLayout, final Function1<? super String, Unit> onConfirmWithParams) {
        final View findViewById = contentView.findViewById(C0637R.id.pb_plugin_authorization_loading);
        TextView textView = btnAuthorize instanceof TextView ? (TextView) btnAuthorize : null;
        final ColorStateList textColors = textView != null ? textView.getTextColors() : null;
        if (btnCancel != null) {
            btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PluginAuthorizationDialogCreator.bindBrowserActions$lambda$6(PluginAuthorizationDialogCreator.this, onConfirmWithParams, view);
                }
            });
        }
        if (btnAuthorize != null) {
            final TextView textView2 = textView;
            btnAuthorize.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PluginAuthorizationDialogCreator.bindBrowserActions$lambda$12(btnAuthorize, textView2, findViewById, provider, context, textColors, this, onConfirmWithParams, actionsLayout, contentView, successLayout, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindBrowserActions$lambda$6(PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, Function1 function1, View view) {
        function1.invoke(pluginAuthorizationDialogCreator.buildAuthorizationParams("user_cancel"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindBrowserActions$lambda$12(final View view, final TextView textView, final View view2, final String str, Context context, final ColorStateList colorStateList, final PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, final Function1 function1, final View view3, final View view4, final View view5, View view6) {
        view.setEnabled(false);
        if (textView != null) {
            textView.setTextColor(0);
        }
        if (view2 != null) {
            view2.setVisibility(0);
        }
        PluginTracker.INSTANCE.trackAuthStart(str, "chat_hint");
        PluginConnectorOAuthManager.INSTANCE.startOAuth(context, str, new Function0() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda14
            public final Object invoke() {
                Unit bindBrowserActions$lambda$12$lambda$8;
                bindBrowserActions$lambda$12$lambda$8 = PluginAuthorizationDialogCreator.bindBrowserActions$lambda$12$lambda$8(colorStateList, view2, view, textView);
                return bindBrowserActions$lambda$12$lambda$8;
            }
        }, new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                Unit bindBrowserActions$lambda$12$lambda$11;
                bindBrowserActions$lambda$12$lambda$11 = PluginAuthorizationDialogCreator.bindBrowserActions$lambda$12$lambda$11(PluginAuthorizationDialogCreator.this, str, view, function1, colorStateList, view2, view3, view4, view5, textView, (String) obj);
                return bindBrowserActions$lambda$12$lambda$11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindBrowserActions$lambda$12$lambda$8(ColorStateList colorStateList, View view, View view2, TextView textView) {
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
        if (view != null) {
            view.setVisibility(8);
        }
        view2.setEnabled(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindBrowserActions$lambda$12$lambda$11(PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, String str, final View view, Function1 function1, final ColorStateList colorStateList, final View view2, final View view3, final View view4, final View view5, final TextView textView, final String str2) {
        Intrinsics.checkNotNullParameter(str2, PageDataManager.EXTRA_STATUS);
        pluginAuthorizationDialogCreator.reportAuthOutcome(str, str2, "oauth");
        view.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                PluginAuthorizationDialogCreator.bindBrowserActions$lambda$12$lambda$11$lambda$10(colorStateList, view2, str2, view3, view4, view5, view, textView);
            }
        });
        function1.invoke(pluginAuthorizationDialogCreator.buildAuthorizationParams(str2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindBrowserActions$lambda$12$lambda$11$lambda$10(ColorStateList colorStateList, View view, String str, View view2, View view3, View view4, View view5, TextView textView) {
        if (colorStateList != null && textView != null) {
            textView.setTextColor(colorStateList);
        }
        if (view != null) {
            view.setVisibility(8);
        }
        if (Intrinsics.areEqual(str, "success")) {
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View findViewById = view3.findViewById(C0637R.id.tv_plugin_authorization_body);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (view4 != null) {
                view4.setVisibility(0);
            }
        }
        view5.setEnabled(true);
    }

    private final void bindCustomAuthPollingActions(final Context context, final String provider, View btnCancel, final View btnAuthorize, final View actionsLayout, final View contentView, final View successLayout, final Function1<? super String, Unit> onConfirmWithParams) {
        if (btnCancel != null) {
            btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PluginAuthorizationDialogCreator.bindCustomAuthPollingActions$lambda$13(PluginAuthorizationDialogCreator.this, onConfirmWithParams, view);
                }
            });
        }
        if (btnAuthorize != null) {
            btnAuthorize.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PluginAuthorizationDialogCreator.bindCustomAuthPollingActions$lambda$16(btnAuthorize, provider, context, this, contentView, onConfirmWithParams, actionsLayout, successLayout, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindCustomAuthPollingActions$lambda$13(PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, Function1 function1, View view) {
        PluginConnectorOAuthManager.INSTANCE.cancelCustomAuthPolling();
        function1.invoke(pluginAuthorizationDialogCreator.buildAuthorizationParams("user_cancel"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindCustomAuthPollingActions$lambda$16(final View view, final String str, Context context, final PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, final View view2, final Function1 function1, final View view3, final View view4, View view5) {
        view.setEnabled(false);
        PluginTracker.INSTANCE.trackAuthStart(str, "chat_hint");
        PluginConnectorOAuthManager.INSTANCE.startCustomAuthPollingAuth(context, str, new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindCustomAuthPollingActions$lambda$16$lambda$15;
                bindCustomAuthPollingActions$lambda$16$lambda$15 = PluginAuthorizationDialogCreator.bindCustomAuthPollingActions$lambda$16$lambda$15(PluginAuthorizationDialogCreator.this, str, view2, function1, view3, view4, view, (String) obj);
                return bindCustomAuthPollingActions$lambda$16$lambda$15;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCustomAuthPollingActions$lambda$16$lambda$15(PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, String str, final View view, Function1 function1, final View view2, final View view3, final View view4, final String str2) {
        Intrinsics.checkNotNullParameter(str2, PageDataManager.EXTRA_STATUS);
        pluginAuthorizationDialogCreator.reportAuthOutcome(str, str2, "oauth");
        view.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                PluginAuthorizationDialogCreator.bindCustomAuthPollingActions$lambda$16$lambda$15$lambda$14(str2, view2, view, view3, view4);
            }
        });
        function1.invoke(pluginAuthorizationDialogCreator.buildAuthorizationParams(str2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindCustomAuthPollingActions$lambda$16$lambda$15$lambda$14(String str, View view, View view2, View view3, View view4) {
        if (Intrinsics.areEqual(str, "success")) {
            if (view != null) {
                view.setVisibility(8);
            }
            View findViewById = view2.findViewById(C0637R.id.tv_plugin_authorization_body);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (view3 != null) {
                view3.setVisibility(0);
            }
        }
        view4.setEnabled(true);
    }

    private final void bindWebViewActions(final Context context, final String provider, View btnCancel, final View btnAuthorize, final View actionsLayout, final View contentView, final View successLayout, final Function1<? super String, Unit> onConfirmWithParams) {
        final View findViewById = contentView.findViewById(C0637R.id.pb_plugin_authorization_loading);
        TextView textView = btnAuthorize instanceof TextView ? (TextView) btnAuthorize : null;
        final ColorStateList textColors = textView != null ? textView.getTextColors() : null;
        if (btnCancel != null) {
            btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PluginAuthorizationDialogCreator.bindWebViewActions$lambda$17(PluginAuthorizationDialogCreator.this, onConfirmWithParams, view);
                }
            });
        }
        if (btnAuthorize != null) {
            final TextView textView2 = textView;
            btnAuthorize.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PluginAuthorizationDialogCreator.bindWebViewActions$lambda$21(btnAuthorize, textView2, findViewById, provider, context, this, contentView, onConfirmWithParams, textColors, actionsLayout, successLayout, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindWebViewActions$lambda$17(PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, Function1 function1, View view) {
        PluginConnectorOAuthManager.INSTANCE.cancelWebViewAuth();
        function1.invoke(pluginAuthorizationDialogCreator.buildAuthorizationParams("user_cancel"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindWebViewActions$lambda$21(final View view, final TextView textView, final View view2, final String str, Context context, final PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, final View view3, final Function1 function1, final ColorStateList colorStateList, final View view4, final View view5, View view6) {
        view.setEnabled(false);
        if (textView != null) {
            textView.setTextColor(0);
        }
        if (view2 != null) {
            view2.setVisibility(0);
        }
        PluginTracker.INSTANCE.trackAuthStart(str, "chat_hint");
        PluginConnectorOAuthManager.INSTANCE.startWebViewAuth(context, str, new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit bindWebViewActions$lambda$21$lambda$20;
                bindWebViewActions$lambda$21$lambda$20 = PluginAuthorizationDialogCreator.bindWebViewActions$lambda$21$lambda$20(PluginAuthorizationDialogCreator.this, str, view3, function1, colorStateList, view2, view4, view5, view, textView, (String) obj);
                return bindWebViewActions$lambda$21$lambda$20;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindWebViewActions$lambda$21$lambda$20(PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, String str, final View view, Function1 function1, final ColorStateList colorStateList, final View view2, final View view3, final View view4, final View view5, final TextView textView, final String str2) {
        Intrinsics.checkNotNullParameter(str2, PageDataManager.EXTRA_STATUS);
        pluginAuthorizationDialogCreator.reportAuthOutcome(str, str2, MessagePart.TYPE_WEBVIEW);
        view.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                PluginAuthorizationDialogCreator.bindWebViewActions$lambda$21$lambda$20$lambda$19(colorStateList, view2, str2, view3, view, view4, view5, textView);
            }
        });
        function1.invoke(pluginAuthorizationDialogCreator.buildAuthorizationParams(str2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindWebViewActions$lambda$21$lambda$20$lambda$19(ColorStateList colorStateList, View view, String str, View view2, View view3, View view4, View view5, TextView textView) {
        if (colorStateList != null && textView != null) {
            textView.setTextColor(colorStateList);
        }
        if (view != null) {
            view.setVisibility(8);
        }
        if (Intrinsics.areEqual(str, "success")) {
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View findViewById = view3.findViewById(C0637R.id.tv_plugin_authorization_body);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (view4 != null) {
                view4.setVisibility(0);
            }
        }
        view5.setEnabled(true);
    }

    private final void bindDesktopRedirectActions(Context context, final View contentView, final String provider, View btnCancel, final View btnAuthorize, final View actionsLayout, final View successLayout, final Function1<? super String, Unit> onConfirmWithParams) {
        if (btnCancel != null) {
            btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PluginAuthorizationDialogCreator.bindDesktopRedirectActions$lambda$22(PluginAuthorizationDialogCreator.this, onConfirmWithParams, view);
                }
            });
        }
        if (btnAuthorize != null) {
            btnAuthorize.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PluginAuthorizationDialogCreator.bindDesktopRedirectActions$lambda$25(btnAuthorize, provider, contentView, this, onConfirmWithParams, actionsLayout, successLayout, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDesktopRedirectActions$lambda$22(PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, Function1 function1, View view) {
        function1.invoke(pluginAuthorizationDialogCreator.buildAuthorizationParams("user_cancel"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDesktopRedirectActions$lambda$25(final View view, final String str, final View view2, final PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, final Function1 function1, final View view3, final View view4, View view5) {
        view.setEnabled(false);
        PluginTracker.INSTANCE.trackAuthStart(str, "chat_hint");
        FragmentActivity context = view2.getContext();
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? context : null;
        if (fragmentActivity == null) {
            PluginTracker.INSTANCE.trackAuthFail(str, "host_activity_not_found");
            view.setEnabled(true);
            return;
        }
        Context context2 = view2.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        String localizedProviderName = pluginAuthorizationDialogCreator.getLocalizedProviderName(context2, str);
        PluginAuthorizationBottomSheet.Companion companion = PluginAuthorizationBottomSheet.INSTANCE;
        PluginAuthorizationDescriptor pluginAuthorizationDescriptor = pluginAuthorizationDialogCreator.descriptor;
        String providerDisplayName = pluginAuthorizationDescriptor != null ? pluginAuthorizationDescriptor.getProviderDisplayName() : null;
        if (providerDisplayName == null) {
            providerDisplayName = "";
        }
        PluginAuthorizationBottomSheet newInstance = companion.newInstance(str, providerDisplayName, localizedProviderName, 1);
        newInstance.setOnAuthResult(new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                Unit bindDesktopRedirectActions$lambda$25$lambda$24;
                bindDesktopRedirectActions$lambda$25$lambda$24 = PluginAuthorizationDialogCreator.bindDesktopRedirectActions$lambda$25$lambda$24(PluginAuthorizationDialogCreator.this, str, view2, function1, view3, view4, view, (String) obj);
                return bindDesktopRedirectActions$lambda$25$lambda$24;
            }
        });
        newInstance.show(fragmentActivity.getSupportFragmentManager(), PluginAuthorizationBottomSheet.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindDesktopRedirectActions$lambda$25$lambda$24(PluginAuthorizationDialogCreator pluginAuthorizationDialogCreator, String str, final View view, Function1 function1, final View view2, final View view3, final View view4, final String str2) {
        Intrinsics.checkNotNullParameter(str2, PageDataManager.EXTRA_STATUS);
        pluginAuthorizationDialogCreator.reportAuthOutcome(str, str2, "desktop_redirect");
        view.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                PluginAuthorizationDialogCreator.bindDesktopRedirectActions$lambda$25$lambda$24$lambda$23(str2, view2, view, view3, view4);
            }
        });
        function1.invoke(pluginAuthorizationDialogCreator.buildAuthorizationParams(str2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDesktopRedirectActions$lambda$25$lambda$24$lambda$23(String str, View view, View view2, View view3, View view4) {
        if (Intrinsics.areEqual(str, "success")) {
            if (view != null) {
                view.setVisibility(8);
            }
            View findViewById = view2.findViewById(C0637R.id.tv_plugin_authorization_body);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (view3 != null) {
                view3.setVisibility(0);
            }
        }
        view4.setEnabled(true);
    }

    private final String buildAuthorizationParams(String status) {
        JsonObject jsonObject;
        JsonObject jsonObject2 = this.originalParams;
        if (jsonObject2 == null || (jsonObject = jsonObject2.deepCopy()) == null) {
            jsonObject = new JsonObject();
        }
        JsonElement jsonObject3 = new JsonObject();
        jsonObject3.addProperty(PageDataManager.EXTRA_STATUS, status);
        jsonObject3.addProperty("auth_scope_mode", "all");
        jsonObject3.add("scope_results", new JsonArray());
        jsonObject.add("authorization_result", jsonObject3);
        String json = new Gson().toJson((JsonElement) jsonObject);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    private final void reportAuthOutcome(String provider, String status, String authMethod) {
        PluginAuthorizationDescriptor pluginAuthorizationDescriptor = this.descriptor;
        String pluginName = pluginAuthorizationDescriptor != null ? pluginAuthorizationDescriptor.getPluginName() : null;
        if (pluginName == null) {
            pluginName = "";
        }
        String str = pluginName;
        long authDurationMs = PluginConnectorOAuthManager.INSTANCE.authDurationMs();
        PluginTracker.trackAuthResult$default(PluginTracker.INSTANCE, str, provider, Intrinsics.areEqual(status, "success") ? "success" : "cancel", null, 8, null);
        if (Intrinsics.areEqual(status, "success")) {
            PluginTracker.INSTANCE.trackAuthSuccess(provider, authDurationMs, authMethod);
        } else {
            PluginTracker.INSTANCE.trackAuthFail(provider, status);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PluginAuthorizationDialogCreator.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;", "", "pluginDisplayName", "", "providerDisplayName", "providerRaw", "originalService", "pluginName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPluginDisplayName", "()Ljava/lang/String;", "getProviderDisplayName", "getProviderRaw", "getOriginalService", "getPluginName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class PluginAuthorizationDescriptor {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String originalService;
        private final String pluginDisplayName;
        private final String pluginName;
        private final String providerDisplayName;
        private final String providerRaw;

        public static /* synthetic */ PluginAuthorizationDescriptor copy$default(PluginAuthorizationDescriptor pluginAuthorizationDescriptor, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pluginAuthorizationDescriptor.pluginDisplayName;
            }
            if ((i & 2) != 0) {
                str2 = pluginAuthorizationDescriptor.providerDisplayName;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = pluginAuthorizationDescriptor.providerRaw;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = pluginAuthorizationDescriptor.originalService;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = pluginAuthorizationDescriptor.pluginName;
            }
            return pluginAuthorizationDescriptor.copy(str, str6, str7, str8, str5);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPluginDisplayName() {
            return this.pluginDisplayName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getProviderDisplayName() {
            return this.providerDisplayName;
        }

        /* renamed from: component3, reason: from getter */
        public final String getProviderRaw() {
            return this.providerRaw;
        }

        /* renamed from: component4, reason: from getter */
        public final String getOriginalService() {
            return this.originalService;
        }

        /* renamed from: component5, reason: from getter */
        public final String getPluginName() {
            return this.pluginName;
        }

        public final PluginAuthorizationDescriptor copy(String pluginDisplayName, String providerDisplayName, String providerRaw, String originalService, String pluginName) {
            Intrinsics.checkNotNullParameter(pluginDisplayName, "pluginDisplayName");
            Intrinsics.checkNotNullParameter(providerDisplayName, "providerDisplayName");
            Intrinsics.checkNotNullParameter(providerRaw, "providerRaw");
            Intrinsics.checkNotNullParameter(originalService, "originalService");
            Intrinsics.checkNotNullParameter(pluginName, "pluginName");
            return new PluginAuthorizationDescriptor(pluginDisplayName, providerDisplayName, providerRaw, originalService, pluginName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PluginAuthorizationDescriptor)) {
                return false;
            }
            PluginAuthorizationDescriptor pluginAuthorizationDescriptor = (PluginAuthorizationDescriptor) other;
            return Intrinsics.areEqual(this.pluginDisplayName, pluginAuthorizationDescriptor.pluginDisplayName) && Intrinsics.areEqual(this.providerDisplayName, pluginAuthorizationDescriptor.providerDisplayName) && Intrinsics.areEqual(this.providerRaw, pluginAuthorizationDescriptor.providerRaw) && Intrinsics.areEqual(this.originalService, pluginAuthorizationDescriptor.originalService) && Intrinsics.areEqual(this.pluginName, pluginAuthorizationDescriptor.pluginName);
        }

        public int hashCode() {
            return (((((((this.pluginDisplayName.hashCode() * 31) + this.providerDisplayName.hashCode()) * 31) + this.providerRaw.hashCode()) * 31) + this.originalService.hashCode()) * 31) + this.pluginName.hashCode();
        }

        public String toString() {
            return "PluginAuthorizationDescriptor(pluginDisplayName=" + this.pluginDisplayName + ", providerDisplayName=" + this.providerDisplayName + ", providerRaw=" + this.providerRaw + ", originalService=" + this.originalService + ", pluginName=" + this.pluginName + ')';
        }

        public PluginAuthorizationDescriptor(String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "pluginDisplayName");
            Intrinsics.checkNotNullParameter(str2, "providerDisplayName");
            Intrinsics.checkNotNullParameter(str3, "providerRaw");
            Intrinsics.checkNotNullParameter(str4, "originalService");
            Intrinsics.checkNotNullParameter(str5, "pluginName");
            this.pluginDisplayName = str;
            this.providerDisplayName = str2;
            this.providerRaw = str3;
            this.originalService = str4;
            this.pluginName = str5;
        }

        public final String getPluginDisplayName() {
            return this.pluginDisplayName;
        }

        public final String getProviderDisplayName() {
            return this.providerDisplayName;
        }

        public final String getProviderRaw() {
            return this.providerRaw;
        }

        public final String getOriginalService() {
            return this.originalService;
        }

        public final String getPluginName() {
            return this.pluginName;
        }

        /* compiled from: PluginAuthorizationDialogCreator.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;", "", "<init>", "()V", "from", "Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "displayName", "", "value", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final PluginAuthorizationDescriptor from(ParsedToolCallInfo toolCallInfo) {
                Object obj;
                String str;
                String str2;
                JsonElement jsonElement;
                Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
                try {
                    Result.Companion companion = Result.Companion;
                    Companion companion2 = this;
                    JsonObject params = toolCallInfo.getParams();
                    String asString = (params == null || (jsonElement = params.get(TracingConstants.KEY_TRACE_NAME)) == null) ? null : jsonElement.getAsString();
                    if (asString == null) {
                        asString = "";
                    }
                    obj = Result.constructor-impl(asString);
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                String str3 = (String) (Result.isFailure-impl(obj) ? "" : obj);
                int indexOf$default = StringsKt.indexOf$default(str3, "::", 0, false, 6, (Object) null);
                if (indexOf$default > 0) {
                    String substring = str3.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    str = substring;
                } else {
                    str = str3;
                }
                if (indexOf$default >= 0) {
                    String substring2 = str3.substring(indexOf$default + 2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    str2 = substring2;
                } else {
                    str2 = str3;
                }
                String displayName = displayName(str2);
                String displayName2 = displayName(StringsKt.substringAfterLast$default(str, ':', (String) null, 2, (Object) null));
                String str4 = StringsKt.isBlank(displayName2) ^ true ? displayName2 : null;
                return new PluginAuthorizationDescriptor(str4 == null ? displayName : str4, displayName, str2, str3, str);
            }

            private final String displayName(String value) {
                String str = value;
                String obj = StringsKt.trim(str).toString();
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                String lowerCase = obj.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                switch (lowerCase.hashCode()) {
                    case -1278276362:
                        if (lowerCase.equals("feishu")) {
                            return "Feishu";
                        }
                        break;
                    case 3314286:
                        if (lowerCase.equals("lark")) {
                            return "Lark";
                        }
                        break;
                    case 101905702:
                        if (lowerCase.equals("kdocs")) {
                            return "KDocs";
                        }
                        break;
                    case 113006579:
                        if (lowerCase.equals("wecom")) {
                            return "WeCom";
                        }
                        break;
                    case 133862058:
                        if (lowerCase.equals("dingtalk")) {
                            return "DingTalk";
                        }
                        break;
                    case 136221635:
                        if (lowerCase.equals("tencent-docs")) {
                            return "Tencent Docs";
                        }
                        break;
                }
                List split$default = StringsKt.split$default(StringsKt.trim(str).toString(), new char[]{'-', '_'}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : split$default) {
                    if (!StringsKt.isBlank((String) obj2)) {
                        arrayList.add(obj2);
                    }
                }
                return CollectionsKt.joinToString$default(arrayList, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj3) {
                        CharSequence displayName$lambda$4;
                        displayName$lambda$4 = PluginAuthorizationDialogCreator.PluginAuthorizationDescriptor.Companion.displayName$lambda$4((String) obj3);
                        return displayName$lambda$4;
                    }
                }, 30, (Object) null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final CharSequence displayName$lambda$4(String str) {
                String valueOf;
                Intrinsics.checkNotNullParameter(str, "word");
                if (str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    char charAt = str.charAt(0);
                    if (Character.isLowerCase(charAt)) {
                        Locale locale = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                        valueOf = CharsKt.titlecase(charAt, locale);
                    } else {
                        valueOf = String.valueOf(charAt);
                    }
                    StringBuilder append = sb.append((Object) valueOf);
                    String substring = str.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    str = append.append(substring).toString();
                }
                return str;
            }
        }
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

    /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getLocalizedProviderName(Context context, String provider) {
        int i;
        String pluginName;
        PluginAuthorizationDescriptor pluginAuthorizationDescriptor = this.descriptor;
        String cachedLocalizedDisplayName = (pluginAuthorizationDescriptor == null || (pluginName = pluginAuthorizationDescriptor.getPluginName()) == null) ? null : PluginListCache.INSTANCE.getCachedLocalizedDisplayName(pluginName);
        String str = cachedLocalizedDisplayName;
        if (!(str == null || StringsKt.isBlank(str))) {
            return cachedLocalizedDisplayName;
        }
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = provider.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int hashCode = lowerCase.hashCode();
        if (hashCode == 113006579) {
            if (lowerCase.equals("wecom")) {
                i = C0637R.string.trae_plugin_provider_name_wecom;
                String string = context.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
            PluginAuthorizationDescriptor pluginAuthorizationDescriptor2 = this.descriptor;
            if (pluginAuthorizationDescriptor2 != null) {
            }
            if (r1 == null) {
            }
        } else if (hashCode == 133862058) {
            if (lowerCase.equals("dingtalk")) {
                i = C0637R.string.trae_plugin_provider_name_dingtalk;
                String string2 = context.getString(i);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            }
            PluginAuthorizationDescriptor pluginAuthorizationDescriptor22 = this.descriptor;
            if (pluginAuthorizationDescriptor22 != null) {
            }
            if (r1 == null) {
            }
        } else {
            if (hashCode == 136221635 && lowerCase.equals("tencent-docs")) {
                i = C0637R.string.trae_plugin_provider_name_tencent_docs;
                String string22 = context.getString(i);
                Intrinsics.checkNotNullExpressionValue(string22, "getString(...)");
                return string22;
            }
            PluginAuthorizationDescriptor pluginAuthorizationDescriptor222 = this.descriptor;
            String providerDisplayName = pluginAuthorizationDescriptor222 != null ? pluginAuthorizationDescriptor222.getProviderDisplayName() : null;
            return providerDisplayName == null ? "" : providerDisplayName;
        }
    }

    /* compiled from: PluginAuthorizationDialogCreator.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$Companion;", "", "<init>", "()V", "SERVICE_SEPARATOR", "", "TITLE_LETTER_SPACING_EM", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
