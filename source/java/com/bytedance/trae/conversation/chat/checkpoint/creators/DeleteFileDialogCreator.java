package com.bytedance.trae.conversation.chat.checkpoint.creators;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.FileIconHelper;
import com.bytedance.trae.conversation.chat.checkpoint.CheckpointTypefaces;
import com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DeleteFileDialogCreator.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/DeleteFileDialogCreator;", "Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;", "<init>", "()V", "createContentView", "Landroid/view/View;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "getTitle", "", "getPrimaryButtonText", "getSecondaryButtonText", "getPrimaryButtonBackgroundRes", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeleteFileDialogCreator implements ICheckpointDialogCreator {
    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getTitle(Context context, ParsedToolCallInfo toolCallInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        return "";
    }

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
        JsonElement jsonElement;
        String asString;
        JsonElement jsonElement2;
        Iterable<JsonElement> asJsonArray;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        float f = context.getResources().getDisplayMetrics().density;
        JsonObject params = toolCallInfo.getParams();
        ArrayList arrayList = new ArrayList();
        String str = null;
        if (params != null && (jsonElement2 = params.get("file_paths")) != null) {
            if (!jsonElement2.isJsonArray()) {
                jsonElement2 = null;
            }
            if (jsonElement2 != null && (asJsonArray = jsonElement2.getAsJsonArray()) != null) {
                for (JsonElement jsonElement3 : asJsonArray) {
                    if (jsonElement3.isJsonPrimitive()) {
                        String asString2 = jsonElement3.getAsString();
                        Intrinsics.checkNotNullExpressionValue(asString2, "getAsString(...)");
                        arrayList.add(asString2);
                    }
                }
            }
        }
        if (arrayList.isEmpty() && params != null && (jsonElement = params.get("file_path")) != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null && (asString = jsonElement.getAsString()) != null) {
                arrayList.add(asString);
            }
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        int i = -1;
        int i2 = -2;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        int i3 = 16;
        linearLayout2.setGravity(16);
        int i4 = (int) (20 * f);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(C0637R.drawable.ic_file_warning);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
        layoutParams.setMarginEnd((int) (4 * f));
        imageView.setLayoutParams(layoutParams);
        linearLayout2.addView(imageView);
        TextView textView = new TextView(context);
        textView.setText(context.getString(C0637R.string.trae_checkpoint_delete_file_title));
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        textView.setTextSize(2, 17.0f);
        textView.setTypeface(CheckpointTypefaces.INSTANCE.defaultMedium());
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(1);
        int i5 = (int) (8 * f);
        linearLayout3.setPadding(i5, i5, i5, i5);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l1));
        gradientDrawable.setCornerRadius(10 * f);
        linearLayout3.setBackground(gradientDrawable);
        int i6 = 0;
        for (Object obj : arrayList) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str2 = (String) obj;
            if (i6 > 0) {
                linearLayout3.addView(new View(context), new LinearLayout.LayoutParams(i, i5));
            }
            LinearLayout linearLayout4 = new LinearLayout(context);
            linearLayout4.setOrientation(0);
            linearLayout4.setGravity(i3);
            int i8 = (int) (i3 * f);
            ImageView imageView2 = new ImageView(context);
            imageView2.setImageResource(FileIconHelper.INSTANCE.getFileIconRes(str2));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i8, i8);
            int i9 = (int) (6 * f);
            layoutParams2.setMarginEnd(i9);
            imageView2.setLayoutParams(layoutParams2);
            linearLayout4.addView(imageView2);
            String substringAfterLast$default = StringsKt.substringAfterLast$default(str2, '/', str, 2, str);
            String substringBeforeLast = StringsKt.substringBeforeLast(str2, '/', "");
            TextView textView2 = new TextView(context);
            textView2.setText(substringAfterLast$default);
            textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
            textView2.setTextSize(2, 15.0f);
            textView2.setMaxLines(1);
            linearLayout4.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
            String str3 = substringBeforeLast;
            if (str3.length() > 0) {
                TextView textView3 = new TextView(context);
                textView3.setText(str3);
                textView3.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
                textView3.setTextSize(2, 13.0f);
                textView3.setMaxLines(1);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMarginStart(i9);
                textView3.setLayoutParams(layoutParams3);
                linearLayout4.addView(textView3);
            }
            int i10 = (int) (24 * f);
            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
            horizontalScrollView.setHorizontalScrollBarEnabled(false);
            horizontalScrollView.setOverScrollMode(2);
            horizontalScrollView.addView(linearLayout4, new LinearLayout.LayoutParams(-2, i10));
            linearLayout3.addView(horizontalScrollView, new LinearLayout.LayoutParams(-1, i10));
            i = -1;
            i2 = -2;
            i6 = i7;
            str = null;
            i3 = 16;
        }
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i2);
        layoutParams4.topMargin = (int) (16 * f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(linearLayout3, layoutParams4);
        return linearLayout;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getPrimaryButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(C0637R.string.trae_checkpoint_delete);
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

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public int getPrimaryButtonBackgroundRes() {
        return C0637R.drawable.trae_bg_checkpoint_btn_danger;
    }
}
