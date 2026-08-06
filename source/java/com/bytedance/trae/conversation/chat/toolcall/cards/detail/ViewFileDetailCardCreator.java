package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.FileIconHelper;
import com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.PlanItemContext;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard;
import com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.ParsedToolCallResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ViewFileDetailCardCreator.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u0016H\u0002¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J \u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J#\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u00152\b\u0010#\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "collectFileItems", "", "Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;", "isViewFiles", "", "safeAsInt", "", "Lcom/google/gson/JsonElement;", "(Lcom/google/gson/JsonElement;)Ljava/lang/Integer;", "buildFileListView", "Landroid/view/View;", "items", "buildFileItemRow", "density", "", "item", "buildNoMatchesView", "formatLineRange", "", "offset", "limit", "(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;", "Companion", "FileItem", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ViewFileDetailCardCreator extends BaseToolDetailCardCreator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TOOL_TAG = "AgentTool";

    /* compiled from: ViewFileDetailCardCreator.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToolExecutionStatus.values().length];
            try {
                iArr[ToolExecutionStatus.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: ViewFileDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$Companion;", "", "<init>", "()V", "TOOL_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected ToolDetailCard onCreateDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        Function1 function1;
        String str;
        Function1 function12;
        int i;
        int i2;
        boolean z;
        String str2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z2 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        final List<FileItem> collectFileItems = collectFileItems(toolCallInfo, Intrinsics.areEqual(toolCallInfo.getName(), "view_files"));
        if (!z2) {
            String string = context.getString(C0637R.string.trae_chat_tool_reading_files, Integer.valueOf(collectFileItems.size()));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str2 = string;
            i = C0637R.drawable.glasses_read;
            z = true;
            i2 = 0;
            str = null;
            function12 = collectFileItems.isEmpty() ^ true ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    View onCreateDetail$lambda$0;
                    onCreateDetail$lambda$0 = ViewFileDetailCardCreator.onCreateDetail$lambda$0(ViewFileDetailCardCreator.this, collectFileItems, (Context) obj);
                    return onCreateDetail$lambda$0;
                }
            } : null;
        } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
            FileItem fileItem = (FileItem) CollectionsKt.firstOrNull(collectFileItems);
            String displayName = fileItem != null ? fileItem.getDisplayName() : null;
            String string2 = context.getString(C0637R.string.trae_chat_tool_failed_read);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            str2 = string2;
            str = displayName;
            i = C0637R.drawable.warning;
            z = false;
            function12 = null;
            i2 = C0591R.color.trae_status_warning_default;
        } else {
            int size = collectFileItems.size();
            String string3 = context.getString(C0637R.string.trae_chat_tool_read_done);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String quantityString = size > 0 ? context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_read_file_count, size, Integer.valueOf(size)) : null;
            int i3 = C0637R.drawable.glasses_read;
            if (size > 0) {
                function1 = new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        View onCreateDetail$lambda$1;
                        onCreateDetail$lambda$1 = ViewFileDetailCardCreator.onCreateDetail$lambda$1(ViewFileDetailCardCreator.this, collectFileItems, (Context) obj);
                        return onCreateDetail$lambda$1;
                    }
                };
            } else {
                function1 = new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        View onCreateDetail$lambda$2;
                        onCreateDetail$lambda$2 = ViewFileDetailCardCreator.onCreateDetail$lambda$2(ViewFileDetailCardCreator.this, (Context) obj);
                        return onCreateDetail$lambda$2;
                    }
                };
            }
            str = quantityString;
            function12 = function1;
            i = i3;
            i2 = 0;
            z = false;
            str2 = string3;
        }
        FileItem fileItem2 = (FileItem) CollectionsKt.firstOrNull(collectFileItems);
        FLogger.INSTANCE.i("AgentTool", "[ViewFileCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString + ", filePath=" + (fileItem2 != null ? fileItem2.getFilePath() : null));
        return new ToolDetailCard("", i, i2, str2, str, null, function12, fromString, z, null, 544, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$0(ViewFileDetailCardCreator viewFileDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return viewFileDetailCardCreator.buildFileListView(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$1(ViewFileDetailCardCreator viewFileDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return viewFileDetailCardCreator.buildFileListView(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$2(ViewFileDetailCardCreator viewFileDetailCardCreator, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return viewFileDetailCardCreator.buildNoMatchesView(context);
    }

    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        final List<FileItem> collectFileItems = collectFileItems(toolCallInfo, Intrinsics.areEqual(toolCallInfo.getName(), "view_files"));
        if (!z) {
            String string = context.getString(C0637R.string.trae_chat_tool_reading_files, Integer.valueOf(collectFileItems.size()));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            card.setTitle(string);
            card.setSubtitle(null);
            card.setIconResId(C0637R.drawable.glasses_read);
            card.setIconTintColorRes(0);
            card.setShimmerTitle(true);
        } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
            String string2 = context.getString(C0637R.string.trae_chat_tool_failed_read);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            card.setTitle(string2);
            FileItem fileItem = (FileItem) CollectionsKt.firstOrNull(collectFileItems);
            card.setSubtitle(fileItem != null ? fileItem.getDisplayName() : null);
            card.setIconResId(C0637R.drawable.warning);
            card.setIconTintColorRes(C0591R.color.trae_status_warning_default);
            card.setShimmerTitle(false);
        } else {
            int size = collectFileItems.size();
            String string3 = context.getString(C0637R.string.trae_chat_tool_read_done);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            card.setTitle(string3);
            card.setSubtitle(size > 0 ? context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_read_file_count, size, Integer.valueOf(size)) : null);
            card.setIconResId(C0637R.drawable.glasses_read);
            card.setIconTintColorRes(0);
            card.setShimmerTitle(false);
            card.setContentView(size > 0 ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    View onUpdateCard$lambda$3;
                    onUpdateCard$lambda$3 = ViewFileDetailCardCreator.onUpdateCard$lambda$3(ViewFileDetailCardCreator.this, collectFileItems, (Context) obj);
                    return onUpdateCard$lambda$3;
                }
            } : new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    View onUpdateCard$lambda$4;
                    onUpdateCard$lambda$4 = ViewFileDetailCardCreator.onUpdateCard$lambda$4(ViewFileDetailCardCreator.this, (Context) obj);
                    return onUpdateCard$lambda$4;
                }
            });
        }
        card.setStatus(fromString);
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder append = new StringBuilder("[ViewFileCard] onUpdateCard: name=").append(toolCallInfo.getName()).append(", status=").append(fromString).append(", filePath=");
        FileItem fileItem2 = (FileItem) CollectionsKt.firstOrNull(collectFileItems);
        fLogger.i("AgentTool", append.append(fileItem2 != null ? fileItem2.getFilePath() : null).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onUpdateCard$lambda$3(ViewFileDetailCardCreator viewFileDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return viewFileDetailCardCreator.buildFileListView(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onUpdateCard$lambda$4(ViewFileDetailCardCreator viewFileDetailCardCreator, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return viewFileDetailCardCreator.buildNoMatchesView(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00c0, code lost:
    
        if (r4 != null) goto L84;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x003a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<FileItem> collectFileItems(ParsedToolCallInfo toolCallInfo, boolean isViewFiles) {
        String str;
        String str2;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        JsonElement jsonElement4;
        JsonElement jsonElement5;
        FileItem fileItem;
        JsonObject asJsonObject;
        JsonElement jsonElement6;
        String asString;
        if (isViewFiles) {
            JsonObject params = toolCallInfo.getParams();
            JsonElement jsonElement7 = params != null ? params.get("files") : null;
            if (jsonElement7 != null && jsonElement7.isJsonArray()) {
                Iterable<JsonElement> asJsonArray = jsonElement7.getAsJsonArray();
                Intrinsics.checkNotNullExpressionValue(asJsonArray, "getAsJsonArray(...)");
                ArrayList arrayList = new ArrayList();
                for (JsonElement jsonElement8 : asJsonArray) {
                    if (jsonElement8 != null) {
                        if (!jsonElement8.isJsonObject()) {
                            jsonElement8 = null;
                        }
                        if (jsonElement8 != null && (asJsonObject = jsonElement8.getAsJsonObject()) != null && (jsonElement6 = asJsonObject.get("file_path")) != null) {
                            if (!jsonElement6.isJsonPrimitive()) {
                                jsonElement6 = null;
                            }
                            if (jsonElement6 != null && (asString = jsonElement6.getAsString()) != null) {
                                JsonElement jsonElement9 = asJsonObject.get("offset");
                                Integer safeAsInt = jsonElement9 != null ? safeAsInt(jsonElement9) : null;
                                JsonElement jsonElement10 = asJsonObject.get("limit");
                                fileItem = new FileItem(asString, StringsKt.substringAfterLast$default(asString, '/', (String) null, 2, (Object) null), safeAsInt, jsonElement10 != null ? safeAsInt(jsonElement10) : null, false);
                                if (fileItem == null) {
                                    arrayList.add(fileItem);
                                }
                            }
                        }
                    }
                    fileItem = null;
                    if (fileItem == null) {
                    }
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        }
        JsonObject params2 = toolCallInfo.getParams();
        if (params2 != null && (jsonElement5 = params2.get("file_path")) != null) {
            if (!jsonElement5.isJsonPrimitive()) {
                jsonElement5 = null;
            }
            if (jsonElement5 != null) {
                str = jsonElement5.getAsString();
            }
        }
        JsonObject params3 = toolCallInfo.getParams();
        if (params3 != null && (jsonElement2 = params3.get("path")) != null) {
            if (!jsonElement2.isJsonPrimitive()) {
                jsonElement2 = null;
            }
            if (jsonElement2 != null) {
                str = jsonElement2.getAsString();
                if (str == null) {
                    JsonObject params4 = toolCallInfo.getParams();
                    if (params4 != null && (jsonElement = params4.get("search_directory")) != null) {
                        if (!jsonElement.isJsonPrimitive()) {
                            jsonElement = null;
                        }
                        if (jsonElement != null) {
                            str = jsonElement.getAsString();
                        }
                    }
                    str2 = null;
                    if (str2 == null) {
                        return CollectionsKt.emptyList();
                    }
                    JsonObject params5 = toolCallInfo.getParams();
                    Integer safeAsInt2 = (params5 == null || (jsonElement4 = params5.get("offset")) == null) ? null : safeAsInt(jsonElement4);
                    JsonObject params6 = toolCallInfo.getParams();
                    Integer safeAsInt3 = (params6 == null || (jsonElement3 = params6.get("limit")) == null) ? null : safeAsInt(jsonElement3);
                    boolean z = StringsKt.endsWith$default(str2, "/", false, 2, (Object) null) || Intrinsics.areEqual(toolCallInfo.getName(), "LS");
                    return CollectionsKt.listOf(new FileItem(str2, z ? str2 : StringsKt.substringAfterLast$default(str2, '/', (String) null, 2, (Object) null), safeAsInt2, safeAsInt3, z));
                }
                str2 = str;
                if (str2 == null) {
                }
            }
        }
        str = null;
        if (str == null) {
        }
        str2 = str;
        if (str2 == null) {
        }
    }

    private final Integer safeAsInt(JsonElement jsonElement) {
        if (!jsonElement.isJsonPrimitive()) {
            return null;
        }
        try {
            return Integer.valueOf(jsonElement.getAsInt());
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final View buildFileListView(Context context, List<FileItem> items) {
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Iterator<FileItem> it = items.iterator();
        while (it.hasNext()) {
            linearLayout.addView(buildFileItemRow(context, f, it.next()));
        }
        return linearLayout;
    }

    private final View buildFileItemRow(Context context, float density, FileItem item) {
        int fileIconRes;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight((int) (24 * density));
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int i = (int) (16 * density);
        if (item.isFolder()) {
            fileIconRes = FileIconHelper.getFolderIconRes$default(FileIconHelper.INSTANCE, false, 1, null);
        } else {
            fileIconRes = FileIconHelper.INSTANCE.getFileIconRes(item.getFilePath());
        }
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(fileIconRes);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(i, i));
        TextView textView = new TextView(context);
        textView.setText(item.getDisplayName());
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
        textView.setTextSize(2, 13.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i2 = (int) (4 * density);
        layoutParams.setMarginStart(i2);
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        String formatLineRange = formatLineRange(item.getOffset(), item.getLimit());
        if (formatLineRange != null) {
            TextView textView2 = new TextView(context);
            textView2.setText(formatLineRange);
            textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
            textView2.setTextSize(2, 11.0f);
            textView2.setMaxLines(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMarginStart(i2);
            textView2.setLayoutParams(layoutParams2);
            linearLayout.addView(textView2);
        }
        return linearLayout;
    }

    private final View buildNoMatchesView(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        TextView textView = new TextView(context);
        textView.setText(context.getString(C0637R.string.trae_chat_tool_no_matches));
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
        textView.setTextSize(2, 13.0f);
        textView.setMaxLines(1);
        textView.setMinimumHeight((int) (24 * f));
        textView.setGravity(16);
        return textView;
    }

    private final String formatLineRange(Integer offset, Integer limit) {
        if (offset == null) {
            return null;
        }
        if (limit != null && limit.intValue() > 0) {
            return new StringBuilder().append(offset).append('-').append(offset.intValue() + limit.intValue()).toString();
        }
        return new StringBuilder().append(offset).append('-').toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewFileDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JD\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;", "", "filePath", "", "displayName", "offset", "", "limit", "isFolder", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "getFilePath", "()Ljava/lang/String;", "getDisplayName", "getOffset", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLimit", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Z)Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$FileItem;", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class FileItem {
        private final String displayName;
        private final String filePath;
        private final boolean isFolder;
        private final Integer limit;
        private final Integer offset;

        public static /* synthetic */ FileItem copy$default(FileItem fileItem, String str, String str2, Integer num, Integer num2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileItem.filePath;
            }
            if ((i & 2) != 0) {
                str2 = fileItem.displayName;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                num = fileItem.offset;
            }
            Integer num3 = num;
            if ((i & 8) != 0) {
                num2 = fileItem.limit;
            }
            Integer num4 = num2;
            if ((i & 16) != 0) {
                z = fileItem.isFolder;
            }
            return fileItem.copy(str, str3, num3, num4, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getFilePath() {
            return this.filePath;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getOffset() {
            return this.offset;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getLimit() {
            return this.limit;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsFolder() {
            return this.isFolder;
        }

        public final FileItem copy(String filePath, String displayName, Integer offset, Integer limit, boolean isFolder) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            return new FileItem(filePath, displayName, offset, limit, isFolder);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileItem)) {
                return false;
            }
            FileItem fileItem = (FileItem) other;
            return Intrinsics.areEqual(this.filePath, fileItem.filePath) && Intrinsics.areEqual(this.displayName, fileItem.displayName) && Intrinsics.areEqual(this.offset, fileItem.offset) && Intrinsics.areEqual(this.limit, fileItem.limit) && this.isFolder == fileItem.isFolder;
        }

        public int hashCode() {
            int hashCode = ((this.filePath.hashCode() * 31) + this.displayName.hashCode()) * 31;
            Integer num = this.offset;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.limit;
            return ((hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31) + Boolean.hashCode(this.isFolder);
        }

        public String toString() {
            return "FileItem(filePath=" + this.filePath + ", displayName=" + this.displayName + ", offset=" + this.offset + ", limit=" + this.limit + ", isFolder=" + this.isFolder + ')';
        }

        public FileItem(String str, String str2, Integer num, Integer num2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "filePath");
            Intrinsics.checkNotNullParameter(str2, "displayName");
            this.filePath = str;
            this.displayName = str2;
            this.offset = num;
            this.limit = num2;
            this.isFolder = z;
        }

        public /* synthetic */ FileItem(String str, String str2, Integer num, Integer num2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? false : z);
        }

        public final String getFilePath() {
            return this.filePath;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final Integer getOffset() {
            return this.offset;
        }

        public final Integer getLimit() {
            return this.limit;
        }

        public final boolean isFolder() {
            return this.isFolder;
        }
    }
}
