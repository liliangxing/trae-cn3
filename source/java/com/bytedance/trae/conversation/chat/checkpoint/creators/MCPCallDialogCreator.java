package com.bytedance.trae.conversation.chat.checkpoint.creators;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
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

/* compiled from: MCPCallDialogCreator.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/MCPCallDialogCreator;", "Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;", "<init>", "()V", "createContentView", "Landroid/view/View;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "getTitle", "", "getPrimaryButtonText", "getSecondaryButtonText", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MCPCallDialogCreator implements ICheckpointDialogCreator {
    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void bindActions(View view, Function0<Unit> function0, Function0<Unit> function02) {
        ICheckpointDialogCreator.DefaultImpls.bindActions(this, view, function0, function02);
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
    public String getHeaderLabel(Context context) {
        return ICheckpointDialogCreator.DefaultImpls.getHeaderLabel(this, context);
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
    public boolean hideDefaultButtons() {
        return ICheckpointDialogCreator.DefaultImpls.hideDefaultButtons(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void setFileClickListener(Function1<? super String, Unit> function1) {
        ICheckpointDialogCreator.DefaultImpls.setFileClickListener(this, function1);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void setResolvedDisplayName(String str) {
        ICheckpointDialogCreator.DefaultImpls.setResolvedDisplayName(this, str);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public boolean showCloseButton() {
        return ICheckpointDialogCreator.DefaultImpls.showCloseButton(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0056, code lost:
    
        if (r2 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0072, code lost:
    
        if (r3 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0091, code lost:
    
        r0 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0092, code lost:
    
        if (r13 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0094, code lost:
    
        r13 = r13.get("args");
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009a, code lost:
    
        if (r13 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a0, code lost:
    
        if (r13.isJsonObject() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a3, code lost:
    
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a4, code lost:
    
        if (r13 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a6, code lost:
    
        r1 = r13.getAsJsonObject();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00aa, code lost:
    
        r13 = new android.widget.LinearLayout(r12);
        r13.setOrientation(1);
        r13.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        r4 = new android.widget.LinearLayout(r12);
        r4.setOrientation(0);
        r4.setGravity(16);
        r7 = (int) (16 * r14);
        r8 = new android.widget.ImageView(r12);
        r8.setImageResource(com.bytedance.trae.conversation.C0637R.drawable.ic_mcp_tool);
        r9 = new android.widget.LinearLayout.LayoutParams(r7, r7);
        r9.setMarginEnd((int) (8 * r14));
        r8.setLayoutParams(r9);
        r4.addView(r8);
        r0 = r2 + " / " + r0;
        r2 = new android.widget.TextView(r12);
        r2.setText(r0);
        r2.setTextColor(androidx.core.content.ContextCompat.getColor(r12, com.bytedance.trae.common_ui.C0591R.color.trae_text_text_secondary));
        r2.setTextSize(2, 15.0f);
        r9 = (int) (20 * r14);
        androidx.core.widget.TextViewCompat.setLineHeight(r2, r9);
        r4.addView(r2, new android.widget.LinearLayout.LayoutParams(-2, -2));
        r13.addView(r4, new android.widget.LinearLayout.LayoutParams(-1, -2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0141, code lost:
    
        if (r1 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0147, code lost:
    
        if (r1.size() <= 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0149, code lost:
    
        r1 = new com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson((com.google.gson.JsonElement) r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x015e, code lost:
    
        r1 = r1.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008e, code lost:
    
        if (r3 != null) goto L36;
     */
    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View createContentView(Context context, ParsedToolCallInfo toolCallInfo, ConfirmInfo confirmInfo) {
        String str;
        String str2;
        JsonElement jsonElement;
        LinearLayout linearLayout;
        int i;
        int i2;
        String jsonObject;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        FLogger.INSTANCE.i(getCHECK_POINT_TAG(), "[MCPCallDialogCreator] createContentView: toolCallInfo=" + toolCallInfo);
        float f = context.getResources().getDisplayMetrics().density;
        JsonObject params = toolCallInfo.getParams();
        String string = context.getString(C0637R.string.trae_checkpoint_mcp_unknown);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        JsonObject jsonObject2 = null;
        if (params != null && (jsonElement3 = params.get("server_name")) != null) {
            if (!jsonElement3.isJsonPrimitive()) {
                jsonElement3 = null;
            }
            if (jsonElement3 != null) {
                str = jsonElement3.getAsString();
            }
        }
        str = string;
        if (params != null && (jsonElement2 = params.get("tool_name")) != null) {
            if (!jsonElement2.isJsonPrimitive()) {
                jsonElement2 = null;
            }
            if (jsonElement2 != null) {
                str2 = jsonElement2.getAsString();
            }
        }
        if (params != null && (jsonElement = params.get("name")) != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                str2 = jsonElement.getAsString();
            }
        }
        str2 = null;
        NestedScrollView nestedScrollView = new NestedScrollView(context);
        nestedScrollView.setVerticalScrollBarEnabled(true);
        int i3 = (int) (12 * f);
        nestedScrollView.setPadding(i3, i3, i3, i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l1));
        gradientDrawable.setCornerRadius(10 * f);
        nestedScrollView.setBackground(gradientDrawable);
        TextView textView = new TextView(context);
        textView.setText(jsonObject);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        textView.setTextSize(2, 15.0f);
        TextViewCompat.setLineHeight(textView, i2);
        textView.setTypeface(Typeface.MONOSPACE);
        nestedScrollView.addView(textView, new FrameLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) (300 * f));
        layoutParams.topMargin = i;
        Unit unit = Unit.INSTANCE;
        linearLayout.addView((View) nestedScrollView, layoutParams);
        return linearLayout;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getTitle(Context context, ParsedToolCallInfo toolCallInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        String string = context.getString(C0637R.string.trae_checkpoint_mcp_call_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getPrimaryButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(C0637R.string.trae_checkpoint_run);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getSecondaryButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(C0637R.string.trae_checkpoint_deny);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
