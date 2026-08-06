package com.bytedance.trae.conversation.chat.checkpoint.creators;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.checkpoint.CheckpointTypefaces;
import com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrowserActionDialogCreator.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u001d\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator;", "Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;", "<init>", "()V", "btnConfirm", "Landroid/widget/TextView;", "btnSkip", "createContentView", "Landroid/view/View;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "bindActions", "", "contentView", "onConfirm", "Lkotlin/Function0;", "onSkip", "getTitle", "", "getPrimaryButtonText", "getSecondaryButtonText", "hideDefaultButtons", "", "showCloseButton", "getHeaderLabel", "createActionButton", "density", "", "text", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrowserActionDialogCreator implements ICheckpointDialogCreator {
    private TextView btnConfirm;
    private TextView btnSkip;

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getPrimaryButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "";
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getSecondaryButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "";
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getTitle(Context context, ParsedToolCallInfo toolCallInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        return "";
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public boolean hideDefaultButtons() {
        return true;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public boolean showCloseButton() {
        return true;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void bindActions(View view, Function0<Unit> function0, Function0<Unit> function02, Function1<? super String, Unit> function1) {
        ICheckpointDialogCreator.DefaultImpls.bindActions(this, view, function0, function02, function1);
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
    public int getContentTopMarginRes() {
        return ICheckpointDialogCreator.DefaultImpls.getContentTopMarginRes(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public int getPrimaryButtonBackgroundRes() {
        return ICheckpointDialogCreator.DefaultImpls.getPrimaryButtonBackgroundRes(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public float getTitleLetterSpacing() {
        return ICheckpointDialogCreator.DefaultImpls.getTitleLetterSpacing(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public int getTitleTextColorRes() {
        return ICheckpointDialogCreator.DefaultImpls.getTitleTextColorRes(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void setFileClickListener(Function1<? super String, Unit> function1) {
        ICheckpointDialogCreator.DefaultImpls.setFileClickListener(this, function1);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void setResolvedDisplayName(String str) {
        ICheckpointDialogCreator.DefaultImpls.setResolvedDisplayName(this, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0056, code lost:
    
        if (r3 != null) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View createContentView(Context context, ParsedToolCallInfo toolCallInfo, ConfirmInfo confirmInfo) {
        String str;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        FLogger.INSTANCE.i(getCHECK_POINT_TAG(), "[BrowserActionDialogCreator] createContentView: toolCallInfo=" + toolCallInfo);
        float f = context.getResources().getDisplayMetrics().density;
        JsonObject params = toolCallInfo.getParams();
        boolean areEqual = Intrinsics.areEqual(toolCallInfo.getName(), "browser_hand_over");
        String str2 = null;
        if (params != null && (jsonElement3 = params.get("reason")) != null) {
            if (!jsonElement3.isJsonPrimitive()) {
                jsonElement3 = null;
            }
            if (jsonElement3 != null) {
                str = jsonElement3.getAsString();
            }
        }
        if (params != null && (jsonElement2 = params.get("description")) != null) {
            if (!jsonElement2.isJsonPrimitive()) {
                jsonElement2 = null;
            }
            if (jsonElement2 != null) {
                str = jsonElement2.getAsString();
                if (str == null) {
                    if (params != null && (jsonElement = params.get(IWeixinService.ResponseConstants.URL)) != null) {
                        if (!jsonElement.isJsonPrimitive()) {
                            jsonElement = null;
                        }
                        if (jsonElement != null) {
                            str2 = jsonElement.getAsString();
                        }
                    }
                    if (str2 == null) {
                        str = context.getString(C0637R.string.trae_checkpoint_browser_fallback_desc);
                        Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
                    } else {
                        str = str2;
                    }
                }
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                TextView textView = new TextView(context);
                textView.setText(str);
                textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
                textView.setTextSize(2, 17.0f);
                textView.setTypeface(CheckpointTypefaces.INSTANCE.defaultMedium());
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
                LinearLayout linearLayout2 = new LinearLayout(context);
                linearLayout2.setOrientation(1);
                String string = context.getString(!areEqual ? C0637R.string.trae_checkpoint_browser_hand_over : C0637R.string.trae_checkpoint_browser_confirm);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                TextView createActionButton = createActionButton(context, f, string);
                this.btnConfirm = createActionButton;
                linearLayout2.addView(createActionButton, new LinearLayout.LayoutParams(-1, -2));
                String string2 = context.getString(!areEqual ? C0637R.string.trae_checkpoint_browser_skip_hand_over : C0637R.string.trae_checkpoint_browser_skip);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                TextView createActionButton2 = createActionButton(context, f, string2);
                this.btnSkip = createActionButton2;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = (int) (8 * f);
                Unit unit = Unit.INSTANCE;
                linearLayout2.addView(createActionButton2, layoutParams);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.topMargin = (int) (16 * f);
                Unit unit2 = Unit.INSTANCE;
                linearLayout.addView(linearLayout2, layoutParams2);
                return linearLayout;
            }
        }
        str = null;
        if (str == null) {
        }
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(1);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(context);
        textView2.setText(str);
        textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        textView2.setTextSize(2, 17.0f);
        textView2.setTypeface(CheckpointTypefaces.INSTANCE.defaultMedium());
        linearLayout3.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout22 = new LinearLayout(context);
        linearLayout22.setOrientation(1);
        String string3 = context.getString(!areEqual ? C0637R.string.trae_checkpoint_browser_hand_over : C0637R.string.trae_checkpoint_browser_confirm);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        TextView createActionButton3 = createActionButton(context, f, string3);
        this.btnConfirm = createActionButton3;
        linearLayout22.addView(createActionButton3, new LinearLayout.LayoutParams(-1, -2));
        String string22 = context.getString(!areEqual ? C0637R.string.trae_checkpoint_browser_skip_hand_over : C0637R.string.trae_checkpoint_browser_skip);
        Intrinsics.checkNotNullExpressionValue(string22, "getString(...)");
        TextView createActionButton22 = createActionButton(context, f, string22);
        this.btnSkip = createActionButton22;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = (int) (8 * f);
        Unit unit3 = Unit.INSTANCE;
        linearLayout22.addView(createActionButton22, layoutParams3);
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams22.topMargin = (int) (16 * f);
        Unit unit22 = Unit.INSTANCE;
        linearLayout3.addView(linearLayout22, layoutParams22);
        return linearLayout3;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void bindActions(View contentView, final Function0<Unit> onConfirm, final Function0<Unit> onSkip) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onSkip, "onSkip");
        TextView textView = this.btnConfirm;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.BrowserActionDialogCreator$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    onConfirm.invoke();
                }
            });
        }
        TextView textView2 = this.btnSkip;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.BrowserActionDialogCreator$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    onSkip.invoke();
                }
            });
        }
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getHeaderLabel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(C0637R.string.trae_checkpoint_browser_header_label);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final TextView createActionButton(Context context, float density, String text) {
        TextView textView = new TextView(context);
        textView.setText(text);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        textView.setTextSize(2, 15.0f);
        textView.setTypeface(CheckpointTypefaces.INSTANCE.defaultSemibold());
        int i = (int) (12 * density);
        int i2 = (int) (16 * density);
        textView.setPadding(i, i2, i, i2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l1));
        gradientDrawable.setCornerRadius(10 * density);
        textView.setBackground(gradientDrawable);
        return textView;
    }
}
