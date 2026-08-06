package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SearchDetailCardCreator.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J \u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013H\u0002¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "extractKeywords", "", "collectFileItems", "", "Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;", OnekeyLoginConstants.CU_KEY_RESULT_DATA, "Lcom/google/gson/JsonObject;", "buildNoMatchesView", "Landroid/view/View;", "buildFileListView", "items", "buildFileItemRow", "density", "", "item", "SearchFileItem", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SearchDetailCardCreator extends BaseToolDetailCardCreator {
    private static final int MAX_FILE_ITEMS = 10;
    public static final String TOOL_TAG = "AgentTool";

    /* compiled from: SearchDetailCardCreator.kt */
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

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e5, code lost:
    
        if (((r8 == null || (r8 = r8.get("match_occurrences")) == null || r8.getAsInt() != 0) ? false : true) != false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fc  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ToolDetailCard onCreateDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        boolean z;
        Function1 function1;
        String str;
        int i;
        int i2;
        boolean z2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        String extractKeywords = extractKeywords(toolCallInfo);
        if (extractKeywords.length() > 40) {
            extractKeywords = StringsKt.take(extractKeywords, 40) + (char) 8230;
        }
        boolean z3 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        Function1 function12 = null;
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        ParsedToolCallResult result2 = toolCallInfo.getResult();
        JsonObject data = result2 != null ? result2.getData() : null;
        String str2 = extractKeywords.length() > 0 ? "'" + extractKeywords + '\'' : null;
        if (!z3) {
            String string = context.getString(C0637R.string.trae_chat_tool_searching_codebase);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
            i = C0637R.drawable.ic_tool_search;
            z2 = true;
            i2 = 0;
        } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
            String string2 = context.getString(C0637R.string.trae_chat_tool_search_failed_codebase);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            str = string2;
            i = C0637R.drawable.warning;
            i2 = C0591R.color.trae_status_warning_default;
            z2 = false;
        } else {
            int i3 = C0637R.drawable.ic_tool_search;
            final List<SearchFileItem> collectFileItems = collectFileItems(data);
            if (collectFileItems.isEmpty()) {
                if (!((data == null || data.has("match_occurrences")) ? false : true)) {
                }
                z = true;
                String string3 = context.getString(C0637R.string.trae_chat_tool_searched_codebase);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                if (!z) {
                    function1 = new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            View onCreateDetail$lambda$0;
                            onCreateDetail$lambda$0 = SearchDetailCardCreator.onCreateDetail$lambda$0(SearchDetailCardCreator.this, (Context) obj);
                            return onCreateDetail$lambda$0;
                        }
                    };
                } else {
                    if (true ^ collectFileItems.isEmpty()) {
                        function1 = new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                View onCreateDetail$lambda$1;
                                onCreateDetail$lambda$1 = SearchDetailCardCreator.onCreateDetail$lambda$1(SearchDetailCardCreator.this, collectFileItems, (Context) obj);
                                return onCreateDetail$lambda$1;
                            }
                        };
                    }
                    str = string3;
                    i = i3;
                    i2 = 0;
                    z2 = false;
                }
                function12 = function1;
                str = string3;
                i = i3;
                i2 = 0;
                z2 = false;
            }
            z = false;
            String string32 = context.getString(C0637R.string.trae_chat_tool_searched_codebase);
            Intrinsics.checkNotNullExpressionValue(string32, "getString(...)");
            if (!z) {
            }
            function12 = function1;
            str = string32;
            i = i3;
            i2 = 0;
            z2 = false;
        }
        Function1 function13 = function12;
        FLogger.INSTANCE.i("AgentTool", "[SearchCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString + ", keywords=" + extractKeywords);
        return new ToolDetailCard("", i, i2, str, str2, null, function13, fromString, z2, null, 544, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$0(SearchDetailCardCreator searchDetailCardCreator, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return searchDetailCardCreator.buildNoMatchesView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$1(SearchDetailCardCreator searchDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return searchDetailCardCreator.buildFileListView(context, list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0108, code lost:
    
        if (((r8 == null || (r8 = r8.get("match_occurrences")) == null || r8.getAsInt() != 0) ? false : true) != false) goto L47;
     */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        String extractKeywords = extractKeywords(toolCallInfo);
        if (extractKeywords.length() > 40) {
            extractKeywords = StringsKt.take(extractKeywords, 40) + (char) 8230;
        }
        boolean z = false;
        boolean z2 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        Function1<? super Context, ? extends View> function1 = null;
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        card.setSubtitle(extractKeywords.length() > 0 ? "'" + extractKeywords + '\'' : null);
        if (!z2) {
            String string = context.getString(C0637R.string.trae_chat_tool_searching_codebase);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            card.setTitle(string);
            card.setIconResId(C0637R.drawable.ic_tool_search);
            card.setIconTintColorRes(0);
            card.setShimmerTitle(true);
        } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
            String string2 = context.getString(C0637R.string.trae_chat_tool_search_failed_codebase);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            card.setTitle(string2);
            card.setIconResId(C0637R.drawable.warning);
            card.setIconTintColorRes(C0591R.color.trae_status_warning_default);
            card.setShimmerTitle(false);
        } else {
            String string3 = context.getString(C0637R.string.trae_chat_tool_searched_codebase);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            card.setTitle(string3);
            card.setIconResId(C0637R.drawable.ic_tool_search);
            card.setIconTintColorRes(0);
            card.setShimmerTitle(false);
            ParsedToolCallResult result2 = toolCallInfo.getResult();
            JsonObject data = result2 != null ? result2.getData() : null;
            final List<SearchFileItem> collectFileItems = collectFileItems(data);
            if (collectFileItems.isEmpty()) {
                if (!((data == null || data.has("match_occurrences")) ? false : true)) {
                }
                z = true;
            }
            if (z) {
                function1 = new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        View onUpdateCard$lambda$2;
                        onUpdateCard$lambda$2 = SearchDetailCardCreator.onUpdateCard$lambda$2(SearchDetailCardCreator.this, (Context) obj);
                        return onUpdateCard$lambda$2;
                    }
                };
            } else if (!collectFileItems.isEmpty()) {
                function1 = new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        View onUpdateCard$lambda$3;
                        onUpdateCard$lambda$3 = SearchDetailCardCreator.onUpdateCard$lambda$3(SearchDetailCardCreator.this, collectFileItems, (Context) obj);
                        return onUpdateCard$lambda$3;
                    }
                };
            }
            card.setContentView(function1);
        }
        card.setStatus(fromString);
        FLogger.INSTANCE.i("AgentTool", "[SearchCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString + ", keywords=" + extractKeywords);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onUpdateCard$lambda$2(SearchDetailCardCreator searchDetailCardCreator, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return searchDetailCardCreator.buildNoMatchesView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onUpdateCard$lambda$3(SearchDetailCardCreator searchDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return searchDetailCardCreator.buildFileListView(context, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String extractKeywords(ParsedToolCallInfo toolCallInfo) {
        String str;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        String asString;
        JsonObject params = toolCallInfo.getParams();
        String str2 = null;
        if (params != null && (jsonElement3 = params.get("pattern")) != null) {
            if (!jsonElement3.isJsonPrimitive()) {
                jsonElement3 = null;
            }
            if (jsonElement3 != null && (asString = jsonElement3.getAsString()) != null) {
                return asString;
            }
        }
        JsonObject params2 = toolCallInfo.getParams();
        if (params2 != null && (jsonElement2 = params2.get("query")) != null) {
            if (!jsonElement2.isJsonPrimitive()) {
                jsonElement2 = null;
            }
            if (jsonElement2 != null) {
                str = jsonElement2.getAsString();
                if (str == null) {
                    return str;
                }
                JsonObject params3 = toolCallInfo.getParams();
                if (params3 != null && (jsonElement = params3.get("information_request")) != null) {
                    if (!jsonElement.isJsonPrimitive()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        str2 = jsonElement.getAsString();
                    }
                }
                return str2 == null ? "" : str2;
            }
        }
        str = null;
        if (str == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00da, code lost:
    
        if (r11 != null) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x003b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00c4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<SearchFileItem> collectFileItems(JsonObject resultData) {
        JsonArray jsonArray;
        JsonElement jsonElement;
        JsonArray jsonArray2;
        JsonObject asJsonObject;
        JsonElement jsonElement2;
        String asString;
        JsonArray jsonArray3;
        JsonObject asJsonObject2;
        JsonElement jsonElement3;
        String str;
        JsonElement jsonElement4;
        String substringAfterLast$default;
        JsonElement jsonElement5;
        JsonObject jsonObject;
        Integer num;
        Integer num2;
        JsonElement jsonElement6;
        JsonElement jsonElement7;
        if (resultData == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        JsonElement jsonElement8 = resultData.get("files");
        if (jsonElement8 != null) {
            if (!jsonElement8.isJsonArray()) {
                jsonElement8 = null;
            }
            if (jsonElement8 != null) {
                jsonArray = jsonElement8.getAsJsonArray();
                if (jsonArray != null) {
                    Iterator it = jsonArray.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        JsonElement jsonElement9 = (JsonElement) it.next();
                        if (arrayList.size() >= 10) {
                            break;
                        }
                        if (jsonElement9.isJsonPrimitive()) {
                            String asString2 = jsonElement9.getAsString();
                            Intrinsics.checkNotNull(asString2);
                            arrayList.add(new SearchFileItem(asString2, StringsKt.substringAfterLast$default(asString2, '/', (String) null, 2, (Object) null), null, null, 12, null));
                        } else if (jsonElement9.isJsonObject()) {
                            JsonObject asJsonObject3 = jsonElement9.getAsJsonObject();
                            JsonElement jsonElement10 = asJsonObject3.get("filePath");
                            if (jsonElement10 != null) {
                                if (!jsonElement10.isJsonPrimitive()) {
                                    jsonElement10 = null;
                                }
                                if (jsonElement10 != null && (str = jsonElement10.getAsString()) != null) {
                                    jsonElement4 = asJsonObject3.get("name");
                                    if (jsonElement4 != null) {
                                        if (!jsonElement4.isJsonPrimitive()) {
                                            jsonElement4 = null;
                                        }
                                        if (jsonElement4 != null) {
                                            substringAfterLast$default = jsonElement4.getAsString();
                                        }
                                    }
                                    substringAfterLast$default = StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null);
                                    jsonElement5 = asJsonObject3.get("range");
                                    if (jsonElement5 != null) {
                                        if (!jsonElement5.isJsonObject()) {
                                            jsonElement5 = null;
                                        }
                                        if (jsonElement5 != null) {
                                            jsonObject = jsonElement5.getAsJsonObject();
                                            if (jsonObject != null && (jsonElement7 = jsonObject.get("startLineNumber")) != null) {
                                                if (!jsonElement7.isJsonPrimitive()) {
                                                    jsonElement7 = null;
                                                }
                                                if (jsonElement7 != null) {
                                                    num = Integer.valueOf(jsonElement7.getAsInt());
                                                    if (jsonObject != null && (jsonElement6 = jsonObject.get("endLineNumber")) != null) {
                                                        if (!jsonElement6.isJsonPrimitive()) {
                                                            jsonElement6 = null;
                                                        }
                                                        if (jsonElement6 != null) {
                                                            num2 = Integer.valueOf(jsonElement6.getAsInt());
                                                            arrayList.add(new SearchFileItem(str, substringAfterLast$default, num, num2));
                                                        }
                                                    }
                                                    num2 = null;
                                                    arrayList.add(new SearchFileItem(str, substringAfterLast$default, num, num2));
                                                }
                                            }
                                            num = null;
                                            if (jsonObject != null) {
                                                if (!jsonElement6.isJsonPrimitive()) {
                                                }
                                                if (jsonElement6 != null) {
                                                }
                                            }
                                            num2 = null;
                                            arrayList.add(new SearchFileItem(str, substringAfterLast$default, num, num2));
                                        }
                                    }
                                    jsonObject = null;
                                    if (jsonObject != null) {
                                        if (!jsonElement7.isJsonPrimitive()) {
                                        }
                                        if (jsonElement7 != null) {
                                        }
                                    }
                                    num = null;
                                    if (jsonObject != null) {
                                    }
                                    num2 = null;
                                    arrayList.add(new SearchFileItem(str, substringAfterLast$default, num, num2));
                                }
                            }
                            JsonElement jsonElement11 = asJsonObject3.get("file_path");
                            if (jsonElement11 != null) {
                                if (!jsonElement11.isJsonPrimitive()) {
                                    jsonElement11 = null;
                                }
                                if (jsonElement11 != null) {
                                    str = jsonElement11.getAsString();
                                    if (str == null) {
                                        JsonElement jsonElement12 = asJsonObject3.get("absPath");
                                        if (jsonElement12 != null) {
                                            if (!jsonElement12.isJsonPrimitive()) {
                                                jsonElement12 = null;
                                            }
                                            if (jsonElement12 != null) {
                                                str = jsonElement12.getAsString();
                                                if (str != null) {
                                                }
                                            }
                                        }
                                        str = null;
                                        if (str != null) {
                                        }
                                    }
                                    jsonElement4 = asJsonObject3.get("name");
                                    if (jsonElement4 != null) {
                                    }
                                    substringAfterLast$default = StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null);
                                    jsonElement5 = asJsonObject3.get("range");
                                    if (jsonElement5 != null) {
                                    }
                                    jsonObject = null;
                                    if (jsonObject != null) {
                                    }
                                    num = null;
                                    if (jsonObject != null) {
                                    }
                                    num2 = null;
                                    arrayList.add(new SearchFileItem(str, substringAfterLast$default, num, num2));
                                }
                            }
                            str = null;
                            if (str == null) {
                            }
                            jsonElement4 = asJsonObject3.get("name");
                            if (jsonElement4 != null) {
                            }
                            substringAfterLast$default = StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null);
                            jsonElement5 = asJsonObject3.get("range");
                            if (jsonElement5 != null) {
                            }
                            jsonObject = null;
                            if (jsonObject != null) {
                            }
                            num = null;
                            if (jsonObject != null) {
                            }
                            num2 = null;
                            arrayList.add(new SearchFileItem(str, substringAfterLast$default, num, num2));
                        }
                    }
                }
                jsonElement = resultData.get("results");
                if (jsonElement != null) {
                    if (!jsonElement.isJsonArray()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        jsonArray2 = jsonElement.getAsJsonArray();
                        if (jsonArray2 != null) {
                            Iterator it2 = jsonArray2.iterator();
                            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                            while (it2.hasNext()) {
                                JsonElement jsonElement13 = (JsonElement) it2.next();
                                if (arrayList.size() >= 10) {
                                    break;
                                }
                                if (jsonElement13 != null) {
                                    if (!jsonElement13.isJsonObject()) {
                                        jsonElement13 = null;
                                    }
                                    if (jsonElement13 != null && (asJsonObject = jsonElement13.getAsJsonObject()) != null && (jsonElement2 = asJsonObject.get("file_path")) != null) {
                                        if (!jsonElement2.isJsonPrimitive()) {
                                            jsonElement2 = null;
                                        }
                                        if (jsonElement2 != null && (asString = jsonElement2.getAsString()) != null) {
                                            String substringAfterLast$default2 = StringsKt.substringAfterLast$default(asString, '/', (String) null, 2, (Object) null);
                                            JsonElement jsonElement14 = asJsonObject.get("lines");
                                            if (jsonElement14 != null) {
                                                if (!jsonElement14.isJsonArray()) {
                                                    jsonElement14 = null;
                                                }
                                                if (jsonElement14 != null) {
                                                    jsonArray3 = jsonElement14.getAsJsonArray();
                                                    if (jsonArray3 == null && jsonArray3.size() > 0) {
                                                        Iterator it3 = jsonArray3.iterator();
                                                        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                                                        while (it3.hasNext()) {
                                                            JsonElement jsonElement15 = (JsonElement) it3.next();
                                                            if (arrayList.size() < 10) {
                                                                if (jsonElement15 != null) {
                                                                    if (!jsonElement15.isJsonObject()) {
                                                                        jsonElement15 = null;
                                                                    }
                                                                    if (jsonElement15 != null && (asJsonObject2 = jsonElement15.getAsJsonObject()) != null && (jsonElement3 = asJsonObject2.get("line_number")) != null) {
                                                                        if (!jsonElement3.isJsonPrimitive()) {
                                                                            jsonElement3 = null;
                                                                        }
                                                                        if (jsonElement3 != null) {
                                                                            int asInt = jsonElement3.getAsInt();
                                                                            arrayList.add(new SearchFileItem(asString, substringAfterLast$default2, Integer.valueOf(asInt), Integer.valueOf(asInt)));
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        arrayList.add(new SearchFileItem(asString, substringAfterLast$default2, null, null, 12, null));
                                                    }
                                                }
                                            }
                                            jsonArray3 = null;
                                            if (jsonArray3 == null) {
                                            }
                                            arrayList.add(new SearchFileItem(asString, substringAfterLast$default2, null, null, 12, null));
                                        }
                                    }
                                }
                            }
                        }
                        return arrayList;
                    }
                }
                jsonArray2 = null;
                if (jsonArray2 != null) {
                }
                return arrayList;
            }
        }
        jsonArray = null;
        if (jsonArray != null) {
        }
        jsonElement = resultData.get("results");
        if (jsonElement != null) {
        }
        jsonArray2 = null;
        if (jsonArray2 != null) {
        }
        return arrayList;
    }

    private final View buildNoMatchesView(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        TextView textView = new TextView(context);
        textView.setText(context.getString(C0637R.string.trae_chat_tool_search_no_matches));
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
        textView.setTextSize(2, 13.0f);
        textView.setMaxLines(1);
        textView.setPadding(0, (int) (4 * f), 0, (int) (16 * f));
        return textView;
    }

    private final View buildFileListView(Context context, List<SearchFileItem> items) {
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, (int) (4 * f), 0, (int) (16 * f));
        Iterator<SearchFileItem> it = items.iterator();
        while (it.hasNext()) {
            linearLayout.addView(buildFileItemRow(context, f, it.next()));
        }
        return linearLayout;
    }

    private final View buildFileItemRow(Context context, float density, SearchFileItem item) {
        String sb;
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
        layoutParams.setMarginStart((int) (8 * density));
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        if (item.getStartLine() != null && item.getEndLine() != null) {
            if (Intrinsics.areEqual(item.getStartLine(), item.getEndLine())) {
                sb = String.valueOf(item.getStartLine());
            } else {
                sb = new StringBuilder().append(item.getStartLine()).append('-').append(item.getEndLine()).toString();
            }
            TextView textView2 = new TextView(context);
            textView2.setText(sb);
            textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
            textView2.setTextSize(2, 13.0f);
            textView2.setMaxLines(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMarginStart((int) (4 * density));
            textView2.setLayoutParams(layoutParams2);
            linearLayout.addView(textView2);
        }
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SearchDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ:\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;", "", "filePath", "", "displayName", "startLine", "", "endLine", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getFilePath", "()Ljava/lang/String;", "getDisplayName", "getStartLine", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEndLine", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$SearchFileItem;", "equals", "", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class SearchFileItem {
        private final String displayName;
        private final Integer endLine;
        private final String filePath;
        private final Integer startLine;

        public static /* synthetic */ SearchFileItem copy$default(SearchFileItem searchFileItem, String str, String str2, Integer num, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = searchFileItem.filePath;
            }
            if ((i & 2) != 0) {
                str2 = searchFileItem.displayName;
            }
            if ((i & 4) != 0) {
                num = searchFileItem.startLine;
            }
            if ((i & 8) != 0) {
                num2 = searchFileItem.endLine;
            }
            return searchFileItem.copy(str, str2, num, num2);
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
        public final Integer getStartLine() {
            return this.startLine;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getEndLine() {
            return this.endLine;
        }

        public final SearchFileItem copy(String filePath, String displayName, Integer startLine, Integer endLine) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            return new SearchFileItem(filePath, displayName, startLine, endLine);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchFileItem)) {
                return false;
            }
            SearchFileItem searchFileItem = (SearchFileItem) other;
            return Intrinsics.areEqual(this.filePath, searchFileItem.filePath) && Intrinsics.areEqual(this.displayName, searchFileItem.displayName) && Intrinsics.areEqual(this.startLine, searchFileItem.startLine) && Intrinsics.areEqual(this.endLine, searchFileItem.endLine);
        }

        public int hashCode() {
            int hashCode = ((this.filePath.hashCode() * 31) + this.displayName.hashCode()) * 31;
            Integer num = this.startLine;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.endLine;
            return hashCode2 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "SearchFileItem(filePath=" + this.filePath + ", displayName=" + this.displayName + ", startLine=" + this.startLine + ", endLine=" + this.endLine + ')';
        }

        public SearchFileItem(String str, String str2, Integer num, Integer num2) {
            Intrinsics.checkNotNullParameter(str, "filePath");
            Intrinsics.checkNotNullParameter(str2, "displayName");
            this.filePath = str;
            this.displayName = str2;
            this.startLine = num;
            this.endLine = num2;
        }

        public /* synthetic */ SearchFileItem(String str, String str2, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2);
        }

        public final String getFilePath() {
            return this.filePath;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final Integer getStartLine() {
            return this.startLine;
        }

        public final Integer getEndLine() {
            return this.endLine;
        }
    }
}
