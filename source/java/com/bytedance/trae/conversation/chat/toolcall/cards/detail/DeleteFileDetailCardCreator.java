package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.FileIconHelper;
import com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.PlanItemContext;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard;
import com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus;
import com.bytedance.trae.im.model.ConfirmInfo;
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

/* compiled from: DeleteFileDetailCardCreator.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J \u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "collectFileItems", "", "Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;", "buildFileListView", "Landroid/view/View;", "items", "buildFileItemRow", "density", "", "item", "Companion", "DeleteFileItem", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeleteFileDetailCardCreator extends BaseToolDetailCardCreator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TOOL_TAG = "AgentTool";

    /* compiled from: DeleteFileDetailCardCreator.kt */
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
            try {
                iArr[ToolExecutionStatus.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: DeleteFileDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$Companion;", "", "<init>", "()V", "TOOL_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0117  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ToolDetailCard onCreateDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        boolean z;
        String str;
        boolean z2;
        int i;
        Function1 function1;
        String str2;
        String str3;
        int i2;
        ConfirmInfo confirmInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z3 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        final List<DeleteFileItem> collectFileItems = collectFileItems(toolCallInfo);
        if (fromString == ToolExecutionStatus.PENDING) {
            if ((planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) ? false : true) {
                z = true;
                if (z3 || z) {
                    String string = context.getString(C0637R.string.trae_chat_tool_deleting);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    int size = collectFileItems.size();
                    String quantityString = size <= 0 ? context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_delete_file_count, size, Integer.valueOf(size)) : null;
                    String string2 = z ? context.getString(C0637R.string.trae_chat_tool_mcp_waiting) : "";
                    int i3 = C0637R.drawable.trash;
                    str = string;
                    z2 = true;
                    i = 0;
                    function1 = !(collectFileItems.isEmpty() ^ true) ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            View onCreateDetail$lambda$0;
                            onCreateDetail$lambda$0 = DeleteFileDetailCardCreator.onCreateDetail$lambda$0(DeleteFileDetailCardCreator.this, collectFileItems, (Context) obj);
                            return onCreateDetail$lambda$0;
                        }
                    } : null;
                    str2 = string2;
                    str3 = quantityString;
                    i2 = i3;
                } else {
                    int i4 = WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()];
                    if (i4 == 1) {
                        DeleteFileItem deleteFileItem = (DeleteFileItem) CollectionsKt.firstOrNull(collectFileItems);
                        String displayName = deleteFileItem != null ? deleteFileItem.getDisplayName() : null;
                        String string3 = context.getString(C0637R.string.trae_chat_tool_failed_delete);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        str = string3;
                        str3 = displayName;
                        i2 = C0637R.drawable.warning;
                        z2 = false;
                        function1 = null;
                        i = C0591R.color.trae_status_warning_default;
                    } else if (i4 == 2) {
                        int size2 = collectFileItems.size();
                        String string4 = context.getString(C0637R.string.trae_chat_tool_deleted);
                        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                        str3 = size2 > 0 ? context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_delete_file_count, size2, Integer.valueOf(size2)) : null;
                        i2 = C0637R.drawable.trash;
                        function1 = true ^ collectFileItems.isEmpty() ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                View onCreateDetail$lambda$1;
                                onCreateDetail$lambda$1 = DeleteFileDetailCardCreator.onCreateDetail$lambda$1(DeleteFileDetailCardCreator.this, collectFileItems, (Context) obj);
                                return onCreateDetail$lambda$1;
                            }
                        } : null;
                        i = 0;
                        z2 = false;
                        str = string4;
                    } else {
                        String string5 = context.getString(C0637R.string.trae_chat_tool_delete);
                        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                        int i5 = C0637R.drawable.trash;
                        str2 = context.getString(C0637R.string.trae_chat_tool_canceled);
                        str = string5;
                        function1 = true ^ collectFileItems.isEmpty() ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                View onCreateDetail$lambda$2;
                                onCreateDetail$lambda$2 = DeleteFileDetailCardCreator.onCreateDetail$lambda$2(DeleteFileDetailCardCreator.this, collectFileItems, (Context) obj);
                                return onCreateDetail$lambda$2;
                            }
                        } : null;
                        i = 0;
                        z2 = false;
                        str3 = null;
                        i2 = i5;
                    }
                    str2 = "";
                }
                DeleteFileItem deleteFileItem2 = (DeleteFileItem) CollectionsKt.firstOrNull(collectFileItems);
                FLogger.INSTANCE.i("AgentTool", "[DeleteFileCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString + ", filePath=" + (deleteFileItem2 != null ? deleteFileItem2.getFilePath() : null));
                return new ToolDetailCard("", i2, i, str, str3, str2, function1, fromString, z2, null, StatusBarUtils.FLAG_NOTCH_PORTRAIT, null);
            }
        }
        z = false;
        if (z3) {
        }
        String string6 = context.getString(C0637R.string.trae_chat_tool_deleting);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        int size3 = collectFileItems.size();
        if (size3 <= 0) {
        }
        if (z) {
        }
        int i32 = C0637R.drawable.trash;
        str = string6;
        z2 = true;
        i = 0;
        function1 = !(collectFileItems.isEmpty() ^ true) ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                View onCreateDetail$lambda$0;
                onCreateDetail$lambda$0 = DeleteFileDetailCardCreator.onCreateDetail$lambda$0(DeleteFileDetailCardCreator.this, collectFileItems, (Context) obj);
                return onCreateDetail$lambda$0;
            }
        } : null;
        str2 = string2;
        str3 = quantityString;
        i2 = i32;
        DeleteFileItem deleteFileItem22 = (DeleteFileItem) CollectionsKt.firstOrNull(collectFileItems);
        FLogger.INSTANCE.i("AgentTool", "[DeleteFileCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString + ", filePath=" + (deleteFileItem22 != null ? deleteFileItem22.getFilePath() : null));
        return new ToolDetailCard("", i2, i, str, str3, str2, function1, fromString, z2, null, StatusBarUtils.FLAG_NOTCH_PORTRAIT, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$0(DeleteFileDetailCardCreator deleteFileDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return deleteFileDetailCardCreator.buildFileListView(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$1(DeleteFileDetailCardCreator deleteFileDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return deleteFileDetailCardCreator.buildFileListView(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$2(DeleteFileDetailCardCreator deleteFileDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return deleteFileDetailCardCreator.buildFileListView(context, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013f  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        boolean z;
        ConfirmInfo confirmInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z2 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        final List<DeleteFileItem> collectFileItems = collectFileItems(toolCallInfo);
        if (fromString == ToolExecutionStatus.PENDING) {
            if ((planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) ? false : true) {
                z = true;
                if (z2 || z) {
                    int size = collectFileItems.size();
                    String string = context.getString(C0637R.string.trae_chat_tool_deleting);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    card.setTitle(string);
                    card.setSubtitle(size <= 0 ? context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_delete_file_count, size, Integer.valueOf(size)) : null);
                    card.setBadgeText(!z ? context.getString(C0637R.string.trae_chat_tool_mcp_waiting) : null);
                    card.setIconResId(C0637R.drawable.trash);
                    card.setIconTintColorRes(0);
                    card.setShimmerTitle(true);
                } else {
                    int i = WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()];
                    if (i == 1) {
                        String string2 = context.getString(C0637R.string.trae_chat_tool_failed_delete);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        card.setTitle(string2);
                        DeleteFileItem deleteFileItem = (DeleteFileItem) CollectionsKt.firstOrNull(collectFileItems);
                        card.setSubtitle(deleteFileItem != null ? deleteFileItem.getDisplayName() : null);
                        card.setIconResId(C0637R.drawable.warning);
                        card.setIconTintColorRes(C0591R.color.trae_status_warning_default);
                        card.setShimmerTitle(false);
                        card.setBadgeText(null);
                    } else if (i == 2) {
                        int size2 = collectFileItems.size();
                        String string3 = context.getString(C0637R.string.trae_chat_tool_deleted);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        card.setTitle(string3);
                        card.setSubtitle(size2 > 0 ? context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_delete_file_count, size2, Integer.valueOf(size2)) : null);
                        card.setIconResId(C0637R.drawable.trash);
                        card.setIconTintColorRes(0);
                        card.setShimmerTitle(false);
                        card.setBadgeText(null);
                        card.setContentView(collectFileItems.isEmpty() ^ true ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj) {
                                View onUpdateCard$lambda$3;
                                onUpdateCard$lambda$3 = DeleteFileDetailCardCreator.onUpdateCard$lambda$3(DeleteFileDetailCardCreator.this, collectFileItems, (Context) obj);
                                return onUpdateCard$lambda$3;
                            }
                        } : null);
                    } else {
                        card.setStatus(ToolExecutionStatus.CANCELED);
                        String string4 = context.getString(C0637R.string.trae_chat_tool_delete);
                        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                        card.setTitle(string4);
                        card.setSubtitle(null);
                        card.setIconResId(C0637R.drawable.trash);
                        card.setIconTintColorRes(0);
                        card.setShimmerTitle(false);
                        card.setBadgeText(context.getString(C0637R.string.trae_chat_tool_canceled));
                        card.setContentView(collectFileItems.isEmpty() ^ true ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj) {
                                View onUpdateCard$lambda$4;
                                onUpdateCard$lambda$4 = DeleteFileDetailCardCreator.onUpdateCard$lambda$4(DeleteFileDetailCardCreator.this, collectFileItems, (Context) obj);
                                return onUpdateCard$lambda$4;
                            }
                        } : null);
                    }
                }
                card.setStatus(fromString);
                FLogger fLogger = FLogger.INSTANCE;
                StringBuilder append = new StringBuilder("[DeleteFileCard] onUpdateCard: name=").append(toolCallInfo.getName()).append(", status=").append(fromString).append(", filePath=");
                DeleteFileItem deleteFileItem2 = (DeleteFileItem) CollectionsKt.firstOrNull(collectFileItems);
                fLogger.i("AgentTool", append.append(deleteFileItem2 != null ? deleteFileItem2.getFilePath() : null).toString());
            }
        }
        z = false;
        if (z2) {
        }
        int size3 = collectFileItems.size();
        String string5 = context.getString(C0637R.string.trae_chat_tool_deleting);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        card.setTitle(string5);
        card.setSubtitle(size3 <= 0 ? context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_delete_file_count, size3, Integer.valueOf(size3)) : null);
        card.setBadgeText(!z ? context.getString(C0637R.string.trae_chat_tool_mcp_waiting) : null);
        card.setIconResId(C0637R.drawable.trash);
        card.setIconTintColorRes(0);
        card.setShimmerTitle(true);
        card.setStatus(fromString);
        FLogger fLogger2 = FLogger.INSTANCE;
        StringBuilder append2 = new StringBuilder("[DeleteFileCard] onUpdateCard: name=").append(toolCallInfo.getName()).append(", status=").append(fromString).append(", filePath=");
        DeleteFileItem deleteFileItem22 = (DeleteFileItem) CollectionsKt.firstOrNull(collectFileItems);
        fLogger2.i("AgentTool", append2.append(deleteFileItem22 != null ? deleteFileItem22.getFilePath() : null).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onUpdateCard$lambda$3(DeleteFileDetailCardCreator deleteFileDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return deleteFileDetailCardCreator.buildFileListView(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onUpdateCard$lambda$4(DeleteFileDetailCardCreator deleteFileDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return deleteFileDetailCardCreator.buildFileListView(context, list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        if (r0 != null) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<DeleteFileItem> collectFileItems(ParsedToolCallInfo toolCallInfo) {
        JsonArray jsonArray;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        String str;
        String asString;
        JsonObject params = toolCallInfo.getParams();
        if (params == null) {
            return CollectionsKt.emptyList();
        }
        JsonElement jsonElement3 = params.get("file_paths");
        if (jsonElement3 != null) {
            if (!jsonElement3.isJsonArray()) {
                jsonElement3 = null;
            }
            if (jsonElement3 != null) {
                jsonArray = jsonElement3.getAsJsonArray();
                if (jsonArray == null && jsonArray.size() > 0) {
                    List createListBuilder = CollectionsKt.createListBuilder();
                    int size = jsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonElement jsonElement4 = jsonArray.get(i);
                        if (jsonElement4 != null) {
                            if (!jsonElement4.isJsonPrimitive()) {
                                jsonElement4 = null;
                            }
                            if (jsonElement4 != null && (asString = jsonElement4.getAsString()) != null) {
                                createListBuilder.add(new DeleteFileItem(asString, StringsKt.substringAfterLast$default(asString, '/', (String) null, 2, (Object) null)));
                            }
                        }
                    }
                    return CollectionsKt.build(createListBuilder);
                }
                jsonElement = params.get("file_path");
                if (jsonElement != null) {
                    if (!jsonElement.isJsonPrimitive()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        str = jsonElement.getAsString();
                    }
                }
                jsonElement2 = params.get("path");
                if (jsonElement2 != null) {
                    if (!jsonElement2.isJsonPrimitive()) {
                        jsonElement2 = null;
                    }
                    if (jsonElement2 != null) {
                        str = jsonElement2.getAsString();
                        if (str == null) {
                            return CollectionsKt.emptyList();
                        }
                        return CollectionsKt.listOf(new DeleteFileItem(str, StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null)));
                    }
                }
                str = null;
                if (str == null) {
                }
                return CollectionsKt.listOf(new DeleteFileItem(str, StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null)));
            }
        }
        jsonArray = null;
        if (jsonArray == null) {
        }
        jsonElement = params.get("file_path");
        if (jsonElement != null) {
        }
        jsonElement2 = params.get("path");
        if (jsonElement2 != null) {
        }
        str = null;
        if (str == null) {
        }
        return CollectionsKt.listOf(new DeleteFileItem(str, StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null)));
    }

    private final View buildFileListView(Context context, List<DeleteFileItem> items) {
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Iterator<DeleteFileItem> it = items.iterator();
        while (it.hasNext()) {
            linearLayout.addView(buildFileItemRow(context, f, it.next()));
        }
        return linearLayout;
    }

    private final View buildFileItemRow(Context context, float density, DeleteFileItem item) {
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
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeleteFileDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator$DeleteFileItem;", "", "filePath", "", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFilePath", "()Ljava/lang/String;", "getDisplayName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class DeleteFileItem {
        private final String displayName;
        private final String filePath;

        public static /* synthetic */ DeleteFileItem copy$default(DeleteFileItem deleteFileItem, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deleteFileItem.filePath;
            }
            if ((i & 2) != 0) {
                str2 = deleteFileItem.displayName;
            }
            return deleteFileItem.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getFilePath() {
            return this.filePath;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        public final DeleteFileItem copy(String filePath, String displayName) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            return new DeleteFileItem(filePath, displayName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeleteFileItem)) {
                return false;
            }
            DeleteFileItem deleteFileItem = (DeleteFileItem) other;
            return Intrinsics.areEqual(this.filePath, deleteFileItem.filePath) && Intrinsics.areEqual(this.displayName, deleteFileItem.displayName);
        }

        public int hashCode() {
            return (this.filePath.hashCode() * 31) + this.displayName.hashCode();
        }

        public String toString() {
            return "DeleteFileItem(filePath=" + this.filePath + ", displayName=" + this.displayName + ')';
        }

        public DeleteFileItem(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "filePath");
            Intrinsics.checkNotNullParameter(str2, "displayName");
            this.filePath = str;
            this.displayName = str2;
        }

        public final String getFilePath() {
            return this.filePath;
        }

        public final String getDisplayName() {
            return this.displayName;
        }
    }
}
