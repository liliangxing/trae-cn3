package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: EditFileDetailCardCreator.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0002J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J \u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0002¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "collectFileItems", "", "Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;", "lineCount", "", "", "buildFileListView", "Landroid/view/View;", "items", "buildFileItemRow", "density", "", "item", "Companion", "EditFileItem", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class EditFileDetailCardCreator extends BaseToolDetailCardCreator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TOOL_TAG = "AgentTool";

    /* compiled from: EditFileDetailCardCreator.kt */
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

    /* compiled from: EditFileDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$Companion;", "", "<init>", "()V", "TOOL_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
        String str;
        int i;
        int i2;
        boolean z;
        String str2;
        String displayName;
        String string;
        int i3;
        int i4;
        Function1 function1;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        String name = toolCallInfo.getName();
        boolean z2 = name != null && StringsKt.contains(name, "create", true);
        boolean z3 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        final List<EditFileItem> collectFileItems = collectFileItems(toolCallInfo);
        if (z2) {
            EditFileItem editFileItem = (EditFileItem) CollectionsKt.firstOrNull(collectFileItems);
            displayName = editFileItem != null ? editFileItem.getDisplayName() : null;
            if (!z3) {
                String string2 = context.getString(C0637R.string.trae_chat_tool_creating);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                str2 = string2;
                str = displayName;
                z = true;
                i2 = 0;
                i = C0637R.drawable.text_edit;
            } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
                string = context.getString(C0637R.string.trae_chat_tool_failed_create);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                i3 = C0637R.drawable.warning;
                i4 = C0591R.color.trae_status_warning_default;
                str2 = string;
                str = displayName;
                i = i3;
                z = false;
                i2 = i4;
            } else {
                String string3 = context.getString(C0637R.string.trae_chat_tool_created);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                str2 = string3;
                str = displayName;
                i = C0637R.drawable.text_edit;
                i2 = 0;
                z = false;
            }
            function1 = r9;
        } else if (!z3) {
            String string4 = context.getString(C0637R.string.trae_chat_tool_editing);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            str2 = string4;
            i = C0637R.drawable.text_edit;
            z = true;
            i2 = 0;
            function1 = collectFileItems.isEmpty() ^ true ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.EditFileDetailCardCreator$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    View onCreateDetail$lambda$1;
                    onCreateDetail$lambda$1 = EditFileDetailCardCreator.onCreateDetail$lambda$1(EditFileDetailCardCreator.this, collectFileItems, (Context) obj);
                    return onCreateDetail$lambda$1;
                }
            } : null;
            str = null;
        } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
            EditFileItem editFileItem2 = (EditFileItem) CollectionsKt.firstOrNull(collectFileItems);
            displayName = editFileItem2 != null ? editFileItem2.getDisplayName() : null;
            string = context.getString(C0637R.string.trae_chat_tool_failed_edit);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            i3 = C0637R.drawable.warning;
            i4 = C0591R.color.trae_status_warning_default;
            str2 = string;
            str = displayName;
            i = i3;
            z = false;
            i2 = i4;
            function1 = r9;
        } else {
            int size = collectFileItems.size();
            String string5 = context.getString(C0637R.string.trae_chat_tool_edited);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            String quantityString = size > 0 ? context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_edit_file_count, size, Integer.valueOf(size)) : null;
            int i5 = C0637R.drawable.text_edit;
            r9 = true ^ collectFileItems.isEmpty() ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.EditFileDetailCardCreator$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    View onCreateDetail$lambda$2;
                    onCreateDetail$lambda$2 = EditFileDetailCardCreator.onCreateDetail$lambda$2(EditFileDetailCardCreator.this, collectFileItems, (Context) obj);
                    return onCreateDetail$lambda$2;
                }
            } : null;
            str = quantityString;
            i = i5;
            i2 = 0;
            z = false;
            str2 = string5;
            function1 = r9;
        }
        FLogger.INSTANCE.i("AgentTool", "[EditFileCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString + ", files=" + collectFileItems.size());
        return new ToolDetailCard("", i, i2, str2, str, null, function1, fromString, z, null, 544, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$1(EditFileDetailCardCreator editFileDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return editFileDetailCardCreator.buildFileListView(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$2(EditFileDetailCardCreator editFileDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return editFileDetailCardCreator.buildFileListView(context, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x003e  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        String name = toolCallInfo.getName();
        if (name != null) {
            if (StringsKt.contains(name, "create", true) || Intrinsics.areEqual(name, "Write")) {
                z = true;
                boolean z2 = toolCallInfo.getResult() == null;
                ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
                ParsedToolCallResult result = toolCallInfo.getResult();
                ToolExecutionStatus fromString = companion.fromString(result == null ? result.getStatus() : null);
                final List<EditFileItem> collectFileItems = collectFileItems(toolCallInfo);
                if (!z) {
                    EditFileItem editFileItem = (EditFileItem) CollectionsKt.firstOrNull(collectFileItems);
                    String displayName = editFileItem != null ? editFileItem.getDisplayName() : null;
                    if (!z2) {
                        String string = context.getString(C0637R.string.trae_chat_tool_creating);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        card.setTitle(string);
                        card.setSubtitle(displayName);
                        card.setIconResId(C0637R.drawable.text_edit);
                        card.setIconTintColorRes(0);
                        card.setShimmerTitle(true);
                    } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
                        String string2 = context.getString(C0637R.string.trae_chat_tool_failed_create);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        card.setTitle(string2);
                        card.setSubtitle(displayName);
                        card.setIconResId(C0637R.drawable.warning);
                        card.setIconTintColorRes(C0591R.color.trae_status_warning_default);
                        card.setShimmerTitle(false);
                    } else {
                        String string3 = context.getString(C0637R.string.trae_chat_tool_created);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        card.setTitle(string3);
                        card.setSubtitle(displayName);
                        card.setIconResId(C0637R.drawable.text_edit);
                        card.setIconTintColorRes(0);
                        card.setShimmerTitle(false);
                    }
                } else if (!z2) {
                    String string4 = context.getString(C0637R.string.trae_chat_tool_editing);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    card.setTitle(string4);
                    card.setSubtitle(null);
                    card.setIconResId(C0637R.drawable.text_edit);
                    card.setIconTintColorRes(0);
                    card.setShimmerTitle(true);
                } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
                    String string5 = context.getString(C0637R.string.trae_chat_tool_failed_edit);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    card.setTitle(string5);
                    EditFileItem editFileItem2 = (EditFileItem) CollectionsKt.firstOrNull(collectFileItems);
                    card.setSubtitle(editFileItem2 != null ? editFileItem2.getDisplayName() : null);
                    card.setIconResId(C0637R.drawable.warning);
                    card.setIconTintColorRes(C0591R.color.trae_status_warning_default);
                    card.setShimmerTitle(false);
                } else {
                    int size = collectFileItems.size();
                    String string6 = context.getString(C0637R.string.trae_chat_tool_edited);
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    card.setTitle(string6);
                    card.setSubtitle(size > 0 ? context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_edit_file_count, size, Integer.valueOf(size)) : null);
                    card.setIconResId(C0637R.drawable.text_edit);
                    card.setIconTintColorRes(0);
                    card.setShimmerTitle(false);
                    card.setContentView(collectFileItems.isEmpty() ^ true ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.EditFileDetailCardCreator$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            View onUpdateCard$lambda$4;
                            onUpdateCard$lambda$4 = EditFileDetailCardCreator.onUpdateCard$lambda$4(EditFileDetailCardCreator.this, collectFileItems, (Context) obj);
                            return onUpdateCard$lambda$4;
                        }
                    } : null);
                }
                card.setStatus(fromString);
                FLogger.INSTANCE.i("AgentTool", "[EditFileCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString + ", files=" + collectFileItems.size());
            }
        }
        z = false;
        if (toolCallInfo.getResult() == null) {
        }
        ToolExecutionStatus.Companion companion2 = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result2 = toolCallInfo.getResult();
        ToolExecutionStatus fromString2 = companion2.fromString(result2 == null ? result2.getStatus() : null);
        final List collectFileItems2 = collectFileItems(toolCallInfo);
        if (!z) {
        }
        card.setStatus(fromString2);
        FLogger.INSTANCE.i("AgentTool", "[EditFileCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString2 + ", files=" + collectFileItems2.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onUpdateCard$lambda$4(EditFileDetailCardCreator editFileDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return editFileDetailCardCreator.buildFileListView(context, list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r0 != null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0141 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cd A[Catch: all -> 0x00de, TryCatch #0 {all -> 0x00de, blocks: (B:49:0x00ac, B:51:0x00b4, B:55:0x00be, B:56:0x00c4, B:58:0x00cd, B:62:0x00d7), top: B:48:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<EditFileItem> collectFileItems(ParsedToolCallInfo toolCallInfo) {
        String str;
        JsonElement jsonElement;
        JsonArray jsonArray;
        JsonObject params;
        String str2;
        JsonObject params2;
        String str3;
        JsonObject params3;
        String str4;
        int lineCount;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        JsonElement jsonElement4;
        JsonObject asJsonObject;
        JsonElement jsonElement5;
        JsonObject asJsonObject2;
        int i;
        JsonElement jsonElement6;
        int i2;
        JsonElement jsonElement7;
        JsonElement jsonElement8;
        JsonObject params4 = toolCallInfo.getParams();
        if (params4 != null && (jsonElement8 = params4.get("file_path")) != null) {
            if (!jsonElement8.isJsonPrimitive()) {
                jsonElement8 = null;
            }
            if (jsonElement8 != null) {
                str = jsonElement8.getAsString();
            }
        }
        JsonObject params5 = toolCallInfo.getParams();
        if (params5 != null && (jsonElement = params5.get("path")) != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                str = jsonElement.getAsString();
                if (str != null) {
                    return CollectionsKt.emptyList();
                }
                ParsedToolCallResult result = toolCallInfo.getResult();
                JsonObject data = result != null ? result.getData() : null;
                if (data != null && (jsonElement7 = data.get("changes")) != null) {
                    if (!jsonElement7.isJsonArray()) {
                        jsonElement7 = null;
                    }
                    if (jsonElement7 != null) {
                        jsonArray = jsonElement7.getAsJsonArray();
                        int i3 = 0;
                        if (jsonArray == null && jsonArray.size() > 0) {
                            int size = jsonArray.size();
                            int i4 = 0;
                            int i5 = 0;
                            for (int i6 = 0; i6 < size; i6++) {
                                JsonElement jsonElement9 = jsonArray.get(i6);
                                if (jsonElement9 != null) {
                                    if (!jsonElement9.isJsonObject()) {
                                        jsonElement9 = null;
                                    }
                                    if (jsonElement9 != null && (asJsonObject = jsonElement9.getAsJsonObject()) != null && (jsonElement5 = asJsonObject.get("diff_info")) != null) {
                                        if (!jsonElement5.isJsonObject()) {
                                            jsonElement5 = null;
                                        }
                                        if (jsonElement5 != null && (asJsonObject2 = jsonElement5.getAsJsonObject()) != null) {
                                            try {
                                                JsonElement jsonElement10 = asJsonObject2.get("insert_line_count");
                                                if (jsonElement10 != null) {
                                                    if (!jsonElement10.isJsonPrimitive()) {
                                                        jsonElement10 = null;
                                                    }
                                                    if (jsonElement10 != null) {
                                                        i = jsonElement10.getAsInt();
                                                        i4 += i;
                                                        jsonElement6 = asJsonObject2.get("delete_line_count");
                                                        if (jsonElement6 != null) {
                                                            if (!jsonElement6.isJsonPrimitive()) {
                                                                jsonElement6 = null;
                                                            }
                                                            if (jsonElement6 != null) {
                                                                i2 = jsonElement6.getAsInt();
                                                                i5 += i2;
                                                            }
                                                        }
                                                        i2 = 0;
                                                        i5 += i2;
                                                    }
                                                }
                                                i = 0;
                                                i4 += i;
                                                jsonElement6 = asJsonObject2.get("delete_line_count");
                                                if (jsonElement6 != null) {
                                                }
                                                i2 = 0;
                                                i5 += i2;
                                            } catch (Throwable unused) {
                                            }
                                        }
                                    }
                                }
                            }
                            i3 = i4;
                            lineCount = i5;
                        } else {
                            params = toolCallInfo.getParams();
                            if (params != null && (jsonElement4 = params.get("old_str")) != null) {
                                if (!jsonElement4.isJsonPrimitive()) {
                                    jsonElement4 = null;
                                }
                                if (jsonElement4 != null) {
                                    str2 = jsonElement4.getAsString();
                                    params2 = toolCallInfo.getParams();
                                    if (params2 != null && (jsonElement3 = params2.get("new_str")) != null) {
                                        if (!jsonElement3.isJsonPrimitive()) {
                                            jsonElement3 = null;
                                        }
                                        if (jsonElement3 != null) {
                                            str3 = jsonElement3.getAsString();
                                            params3 = toolCallInfo.getParams();
                                            if (params3 != null && (jsonElement2 = params3.get(ReportConstant.COMMON_CONTENT)) != null) {
                                                if (!jsonElement2.isJsonPrimitive()) {
                                                    jsonElement2 = null;
                                                }
                                                if (jsonElement2 != null) {
                                                    str4 = jsonElement2.getAsString();
                                                    if (str2 == null || str3 != null) {
                                                        lineCount = str2 != null ? lineCount(str2) : 0;
                                                        if (str3 != null) {
                                                            i3 = lineCount(str3);
                                                        }
                                                    } else if (str4 != null) {
                                                        i3 = lineCount(str4);
                                                        lineCount = 0;
                                                    } else {
                                                        lineCount = 0;
                                                    }
                                                }
                                            }
                                            str4 = null;
                                            if (str2 == null) {
                                            }
                                            if (str2 != null) {
                                            }
                                            if (str3 != null) {
                                            }
                                        }
                                    }
                                    str3 = null;
                                    params3 = toolCallInfo.getParams();
                                    if (params3 != null) {
                                        if (!jsonElement2.isJsonPrimitive()) {
                                        }
                                        if (jsonElement2 != null) {
                                        }
                                    }
                                    str4 = null;
                                    if (str2 == null) {
                                    }
                                    if (str2 != null) {
                                    }
                                    if (str3 != null) {
                                    }
                                }
                            }
                            str2 = null;
                            params2 = toolCallInfo.getParams();
                            if (params2 != null) {
                                if (!jsonElement3.isJsonPrimitive()) {
                                }
                                if (jsonElement3 != null) {
                                }
                            }
                            str3 = null;
                            params3 = toolCallInfo.getParams();
                            if (params3 != null) {
                            }
                            str4 = null;
                            if (str2 == null) {
                            }
                            if (str2 != null) {
                            }
                            if (str3 != null) {
                            }
                        }
                        return CollectionsKt.listOf(new EditFileItem(str, StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null), i3, lineCount));
                    }
                }
                jsonArray = null;
                int i32 = 0;
                if (jsonArray == null) {
                }
                params = toolCallInfo.getParams();
                if (params != null) {
                    if (!jsonElement4.isJsonPrimitive()) {
                    }
                    if (jsonElement4 != null) {
                    }
                }
                str2 = null;
                params2 = toolCallInfo.getParams();
                if (params2 != null) {
                }
                str3 = null;
                params3 = toolCallInfo.getParams();
                if (params3 != null) {
                }
                str4 = null;
                if (str2 == null) {
                }
                if (str2 != null) {
                }
                if (str3 != null) {
                }
                return CollectionsKt.listOf(new EditFileItem(str, StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null), i32, lineCount));
            }
        }
        str = null;
        if (str != null) {
        }
    }

    private final int lineCount(String str) {
        int i = 1;
        if (str.length() == 0) {
            return 0;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) == '\n') {
                i++;
            }
        }
        return i;
    }

    private final View buildFileListView(Context context, List<EditFileItem> items) {
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Iterator<EditFileItem> it = items.iterator();
        while (it.hasNext()) {
            linearLayout.addView(buildFileItemRow(context, f, it.next()));
        }
        return linearLayout;
    }

    private final View buildFileItemRow(Context context, float density, EditFileItem item) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight((int) (24 * density));
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int i = (int) (16 * density);
        int fileIconRes = FileIconHelper.INSTANCE.getFileIconRes(item.getFilePath());
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
        layoutParams.setMarginStart((int) (4 * density));
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        if (item.getAdditions() > 0) {
            TextView textView2 = new TextView(context);
            textView2.setText("+" + item.getAdditions());
            textView2.setTextColor(Color.parseColor("#34A853"));
            textView2.setTextSize(2, 11.0f);
            textView2.setMaxLines(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMarginStart((int) (6 * density));
            textView2.setLayoutParams(layoutParams2);
            linearLayout.addView(textView2);
        }
        if (item.getDeletions() > 0) {
            TextView textView3 = new TextView(context);
            textView3.setText("-" + item.getDeletions());
            textView3.setTextColor(Color.parseColor("#EA4335"));
            textView3.setTextSize(2, 11.0f);
            textView3.setMaxLines(1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMarginStart((int) (6 * density));
            textView3.setLayoutParams(layoutParams3);
            linearLayout.addView(textView3);
        }
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EditFileDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator$EditFileItem;", "", "filePath", "", "displayName", "additions", "", "deletions", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getFilePath", "()Ljava/lang/String;", "getDisplayName", "getAdditions", "()I", "getDeletions", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class EditFileItem {
        private final int additions;
        private final int deletions;
        private final String displayName;
        private final String filePath;

        public static /* synthetic */ EditFileItem copy$default(EditFileItem editFileItem, String str, String str2, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = editFileItem.filePath;
            }
            if ((i3 & 2) != 0) {
                str2 = editFileItem.displayName;
            }
            if ((i3 & 4) != 0) {
                i = editFileItem.additions;
            }
            if ((i3 & 8) != 0) {
                i2 = editFileItem.deletions;
            }
            return editFileItem.copy(str, str2, i, i2);
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
        public final int getAdditions() {
            return this.additions;
        }

        /* renamed from: component4, reason: from getter */
        public final int getDeletions() {
            return this.deletions;
        }

        public final EditFileItem copy(String filePath, String displayName, int additions, int deletions) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            return new EditFileItem(filePath, displayName, additions, deletions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EditFileItem)) {
                return false;
            }
            EditFileItem editFileItem = (EditFileItem) other;
            return Intrinsics.areEqual(this.filePath, editFileItem.filePath) && Intrinsics.areEqual(this.displayName, editFileItem.displayName) && this.additions == editFileItem.additions && this.deletions == editFileItem.deletions;
        }

        public int hashCode() {
            return (((((this.filePath.hashCode() * 31) + this.displayName.hashCode()) * 31) + Integer.hashCode(this.additions)) * 31) + Integer.hashCode(this.deletions);
        }

        public String toString() {
            return "EditFileItem(filePath=" + this.filePath + ", displayName=" + this.displayName + ", additions=" + this.additions + ", deletions=" + this.deletions + ')';
        }

        public EditFileItem(String str, String str2, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "filePath");
            Intrinsics.checkNotNullParameter(str2, "displayName");
            this.filePath = str;
            this.displayName = str2;
            this.additions = i;
            this.deletions = i2;
        }

        public /* synthetic */ EditFileItem(String str, String str2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
        }

        public final String getFilePath() {
            return this.filePath;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final int getAdditions() {
            return this.additions;
        }

        public final int getDeletions() {
            return this.deletions;
        }
    }
}
