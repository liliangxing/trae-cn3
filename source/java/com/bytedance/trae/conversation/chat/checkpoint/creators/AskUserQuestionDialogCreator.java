package com.bytedance.trae.conversation.chat.checkpoint.creators;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
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

/* compiled from: AskUserQuestionDialogCreator.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/AskUserQuestionDialogCreator;", "Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;", "<init>", "()V", "createContentView", "Landroid/view/View;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "getTitle", "", "getPrimaryButtonText", "getSecondaryButtonText", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AskUserQuestionDialogCreator implements ICheckpointDialogCreator {
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

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public View createContentView(Context context, ParsedToolCallInfo toolCallInfo, ConfirmInfo confirmInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        FLogger.INSTANCE.i(getCHECK_POINT_TAG(), "[AskUserQuestionDialogCreator] createContentView: toolCallInfo=" + toolCallInfo);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getTitle(Context context, ParsedToolCallInfo toolCallInfo) {
        JsonElement jsonElement;
        String asString;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        JsonObject params = toolCallInfo.getParams();
        if (params != null && (jsonElement = params.get("question")) != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null && (asString = jsonElement.getAsString()) != null) {
                return asString;
            }
        }
        String string = context.getString(C0637R.string.trae_checkpoint_ask_user_default_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getPrimaryButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(C0637R.string.trae_checkpoint_submit);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getSecondaryButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(C0637R.string.trae_checkpoint_skip);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
