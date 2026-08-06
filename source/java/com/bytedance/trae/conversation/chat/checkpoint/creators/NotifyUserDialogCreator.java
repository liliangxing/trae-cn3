package com.bytedance.trae.conversation.chat.checkpoint.creators;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.FileIconHelper;
import com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NotifyUserDialogCreator.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\u00072\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0006H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator;", "Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;", "<init>", "()V", "fileClickListener", "Lkotlin/Function1;", "", "", "setFileClickListener", "listener", "createContentView", "Landroid/view/View;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "getTitle", "getPrimaryButtonText", "getSecondaryButtonText", "getContentTopMarginDp", "", "getFileIconRes", "path", "ChipFlowLayout", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NotifyUserDialogCreator implements ICheckpointDialogCreator {
    private Function1<? super String, Unit> fileClickListener;

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public int getContentTopMarginDp() {
        return 12;
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
    public void setResolvedDisplayName(String str) {
        ICheckpointDialogCreator.DefaultImpls.setResolvedDisplayName(this, str);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public boolean showCloseButton() {
        return ICheckpointDialogCreator.DefaultImpls.showCloseButton(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void setFileClickListener(Function1<? super String, Unit> listener) {
        this.fileClickListener = listener;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0113  */
    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View createContentView(Context context, ParsedToolCallInfo toolCallInfo, ConfirmInfo confirmInfo) {
        String str;
        String str2;
        ArrayList<String> arrayList;
        String str3;
        JsonElement jsonElement;
        Iterable<JsonElement> asJsonArray;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        FLogger.INSTANCE.i(getCHECK_POINT_TAG(), "[NotifyUserDialogCreator] createContentView: toolCallInfo=" + toolCallInfo);
        float f = context.getResources().getDisplayMetrics().density;
        JsonObject params = toolCallInfo.getParams();
        if (params != null && (jsonElement3 = params.get("explanation")) != null) {
            if (!jsonElement3.isJsonPrimitive()) {
                jsonElement3 = null;
            }
            if (jsonElement3 != null) {
                str = jsonElement3.getAsString();
                if (params != null && (jsonElement2 = params.get("message")) != null) {
                    if (!jsonElement2.isJsonPrimitive()) {
                        jsonElement2 = null;
                    }
                    if (jsonElement2 != null) {
                        str2 = jsonElement2.getAsString();
                        arrayList = new ArrayList();
                        if (params != null && (jsonElement = params.get("file_paths")) != null) {
                            if (!jsonElement.isJsonArray()) {
                                jsonElement = null;
                            }
                            if (jsonElement != null && (asJsonArray = jsonElement.getAsJsonArray()) != null) {
                                for (JsonElement jsonElement4 : asJsonArray) {
                                    if (jsonElement4.isJsonPrimitive()) {
                                        String asString = jsonElement4.getAsString();
                                        Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
                                        arrayList.add(asString);
                                    }
                                }
                            }
                        }
                        LinearLayout linearLayout = new LinearLayout(context);
                        boolean z = true;
                        linearLayout.setOrientation(1);
                        int i = -2;
                        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                        if (str == null) {
                            str = str2;
                        }
                        str3 = str;
                        if (!(str3 != null || str3.length() == 0)) {
                            TextView textView = new TextView(context);
                            textView.setText(str3);
                            textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
                            textView.setTextSize(2, 15.0f);
                            textView.setIncludeFontPadding(false);
                            TextViewCompat.setLineHeight(textView, (int) (20 * f));
                            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
                        }
                        if (!arrayList.isEmpty()) {
                            ChipFlowLayout chipFlowLayout = new ChipFlowLayout(context);
                            int i2 = (int) (12 * f);
                            chipFlowLayout.setHorizontalGap(i2);
                            chipFlowLayout.setVerticalGap(i2);
                            for (final String str4 : arrayList) {
                                LinearLayout linearLayout2 = new LinearLayout(context);
                                linearLayout2.setId(C0637R.id.notify_file_chip);
                                linearLayout2.setOrientation(0);
                                linearLayout2.setGravity(16);
                                linearLayout2.setClickable(z);
                                linearLayout2.setFocusable(z);
                                int i3 = (int) (8 * f);
                                int i4 = (int) (4 * f);
                                linearLayout2.setPadding(i3, i4, i3, i4);
                                linearLayout2.setBackground(ContextCompat.getDrawable(context, C0637R.drawable.trae_bg_notify_file_chip));
                                linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.NotifyUserDialogCreator$$ExternalSyntheticLambda0
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        NotifyUserDialogCreator.createContentView$lambda$12$lambda$8$lambda$7(NotifyUserDialogCreator.this, str4, view);
                                    }
                                });
                                int i5 = (int) (16 * f);
                                ImageView imageView = new ImageView(context);
                                imageView.setImageResource(getFileIconRes(str4));
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i5, i5);
                                layoutParams.setMarginEnd(i4);
                                imageView.setLayoutParams(layoutParams);
                                linearLayout2.addView(imageView);
                                String substringAfterLast$default = StringsKt.substringAfterLast$default(str4, '/', (String) null, 2, (Object) null);
                                TextView textView2 = new TextView(context);
                                textView2.setText(substringAfterLast$default);
                                textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
                                textView2.setTextSize(2, 14.0f);
                                textView2.setIncludeFontPadding(false);
                                TextViewCompat.setLineHeight(textView2, (int) (20 * f));
                                textView2.setMaxLines(1);
                                textView2.setEllipsize(TextUtils.TruncateAt.END);
                                linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
                                chipFlowLayout.addView(linearLayout2);
                                z = true;
                                i = -2;
                            }
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, i);
                            layoutParams2.topMargin = i2;
                            Unit unit = Unit.INSTANCE;
                            linearLayout.addView(chipFlowLayout, layoutParams2);
                        }
                        return linearLayout;
                    }
                }
                str2 = null;
                arrayList = new ArrayList();
                if (params != null) {
                    if (!jsonElement.isJsonArray()) {
                    }
                    if (jsonElement != null) {
                        while (r2.hasNext()) {
                        }
                    }
                }
                LinearLayout linearLayout3 = new LinearLayout(context);
                boolean z2 = true;
                linearLayout3.setOrientation(1);
                int i6 = -2;
                linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                if (str == null) {
                }
                str3 = str;
                if (!(str3 != null || str3.length() == 0)) {
                }
                if (!arrayList.isEmpty()) {
                }
                return linearLayout3;
            }
        }
        str = null;
        if (params != null) {
            if (!jsonElement2.isJsonPrimitive()) {
            }
            if (jsonElement2 != null) {
            }
        }
        str2 = null;
        arrayList = new ArrayList();
        if (params != null) {
        }
        LinearLayout linearLayout32 = new LinearLayout(context);
        boolean z22 = true;
        linearLayout32.setOrientation(1);
        int i62 = -2;
        linearLayout32.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (str == null) {
        }
        str3 = str;
        if (!(str3 != null || str3.length() == 0)) {
        }
        if (!arrayList.isEmpty()) {
        }
        return linearLayout32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createContentView$lambda$12$lambda$8$lambda$7(NotifyUserDialogCreator notifyUserDialogCreator, String str, View view) {
        Function1<? super String, Unit> function1 = notifyUserDialogCreator.fileClickListener;
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getTitle(Context context, ParsedToolCallInfo toolCallInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        String string = context.getString(C0637R.string.trae_checkpoint_notify_user_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getPrimaryButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(C0637R.string.trae_checkpoint_confirm);
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

    private final int getFileIconRes(String path) {
        String lowerCase = StringsKt.substringAfterLast(StringsKt.substringAfterLast$default(path, '/', (String) null, 2, (Object) null), '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int hashCode = lowerCase.hashCode();
        if (hashCode == 3479 ? lowerCase.equals("md") : hashCode == 107969 ? lowerCase.equals("mdx") : hashCode == 246938863 && lowerCase.equals("markdown")) {
            return C0637R.drawable.trae_ic_notify_markdown_file;
        }
        return FileIconHelper.INSTANCE.getFileIconRes(path);
    }

    /* compiled from: NotifyUserDialogCreator.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0014J0\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010 \u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u001bH\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator$ChipFlowLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "horizontalGap", "", "getHorizontalGap", "()I", "setHorizontalGap", "(I)V", "verticalGap", "getVerticalGap", "setVerticalGap", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "l", "t", "r", "b", "generateDefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "generateLayoutParams", "attrs", "Landroid/util/AttributeSet;", "p", "checkLayoutParams", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class ChipFlowLayout extends ViewGroup {
        private int horizontalGap;
        private int verticalGap;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChipFlowLayout(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public final int getHorizontalGap() {
            return this.horizontalGap;
        }

        public final void setHorizontalGap(int i) {
            this.horizontalGap = i;
        }

        public final int getVerticalGap() {
            return this.verticalGap;
        }

        public final void setVerticalGap(int i) {
            this.verticalGap = i;
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = (View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft()) - getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childCount = getChildCount();
            int i = paddingTop;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8) {
                    measureChildWithMargins(childAt, widthMeasureSpec, 0, heightMeasureSpec, 0);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    if (i4 > 0 && this.horizontalGap + i4 + measuredWidth > size) {
                        i += i2 + this.verticalGap;
                        i3 = Math.max(i3, i4);
                        i4 = measuredWidth;
                        i2 = measuredHeight;
                    } else {
                        if (i4 != 0) {
                            measuredWidth += this.horizontalGap;
                        }
                        i4 += measuredWidth;
                        i2 = Math.max(i2, measuredHeight);
                    }
                }
            }
            setMeasuredDimension(ViewGroup.resolveSize(Math.max(i3, i4) + getPaddingLeft() + getPaddingRight(), widthMeasureSpec), ViewGroup.resolveSize(i + i2, heightMeasureSpec));
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            int paddingLeft = ((r - l) - getPaddingLeft()) - getPaddingRight();
            int paddingLeft2 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int childCount = getChildCount();
            int i = 0;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    if (paddingLeft2 > getPaddingLeft() && (paddingLeft2 - getPaddingLeft()) + this.horizontalGap + measuredWidth > paddingLeft) {
                        paddingLeft2 = getPaddingLeft();
                        paddingTop += i + this.verticalGap;
                        i = 0;
                    } else if (paddingLeft2 > getPaddingLeft()) {
                        paddingLeft2 += this.horizontalGap;
                    }
                    int i3 = marginLayoutParams.leftMargin + paddingLeft2;
                    int i4 = marginLayoutParams.topMargin + paddingTop;
                    childAt.layout(i3, i4, childAt.getMeasuredWidth() + i3, childAt.getMeasuredHeight() + i4);
                    paddingLeft2 += measuredWidth;
                    i = Math.max(i, measuredHeight);
                }
            }
        }

        @Override // android.view.ViewGroup
        protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
            return new ViewGroup.MarginLayoutParams(-2, -2);
        }

        @Override // android.view.ViewGroup
        public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
            return new ViewGroup.MarginLayoutParams(getContext(), attrs);
        }

        @Override // android.view.ViewGroup
        protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
            return new ViewGroup.MarginLayoutParams(p);
        }

        @Override // android.view.ViewGroup
        protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
            return p instanceof ViewGroup.MarginLayoutParams;
        }
    }
}
