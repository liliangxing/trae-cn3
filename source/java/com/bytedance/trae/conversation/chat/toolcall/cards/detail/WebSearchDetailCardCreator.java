package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.PlanItemContext;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard;
import com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.ParsedToolCallResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: WebSearchDetailCardCreator.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J(\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "extractResults", "", "Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;", "buildEmptyView", "Landroid/view/View;", "buildResultList", "results", "buildResultItemRow", "density", "", "index", "", "result", "openUrl", IWeixinService.ResponseConstants.URL, "", "WebSearchResult", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class WebSearchDetailCardCreator extends BaseToolDetailCardCreator {
    private static final int MAX_RESULTS = 5;
    private static final String TOOL_TAG = "AgentTool";

    /* compiled from: WebSearchDetailCardCreator.kt */
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

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        if (r3 != null) goto L14;
     */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ToolDetailCard onCreateDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        String str;
        String str2;
        Function1 function1;
        int i;
        int i2;
        boolean z;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        JsonObject params = toolCallInfo.getParams();
        if (params != null && (jsonElement = params.get("query")) != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                str = jsonElement.getAsString();
            }
        }
        str = "…";
        if (str.length() > 40) {
            str = StringsKt.take(str, 40) + (char) 8230;
        }
        String str3 = str;
        boolean z2 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        if (!z2) {
            String string = context.getString(C0637R.string.trae_chat_tool_web_searching);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str2 = string;
            i = C0637R.drawable.ic_tool_web;
            function1 = null;
            z = true;
            i2 = 0;
        } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
            String string2 = context.getString(C0637R.string.trae_chat_tool_web_search_failed);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            str2 = string2;
            i = C0637R.drawable.warning;
            function1 = null;
            i2 = C0591R.color.trae_status_warning_default;
            z = false;
        } else {
            final List<WebSearchResult> extractResults = extractResults(toolCallInfo);
            String string3 = context.getString(C0637R.string.trae_chat_tool_web_searched);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            int i3 = C0637R.drawable.ic_tool_web;
            str2 = string3;
            function1 = true ^ extractResults.isEmpty() ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    View onCreateDetail$lambda$1;
                    onCreateDetail$lambda$1 = WebSearchDetailCardCreator.onCreateDetail$lambda$1(WebSearchDetailCardCreator.this, extractResults, (Context) obj);
                    return onCreateDetail$lambda$1;
                }
            } : new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    View onCreateDetail$lambda$2;
                    onCreateDetail$lambda$2 = WebSearchDetailCardCreator.onCreateDetail$lambda$2(WebSearchDetailCardCreator.this, (Context) obj);
                    return onCreateDetail$lambda$2;
                }
            };
            i = i3;
            i2 = 0;
            z = false;
        }
        FLogger.INSTANCE.i("AgentTool", "[WebSearchCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString + ", query=" + str3);
        return new ToolDetailCard("", i, i2, str2, str3, null, function1, fromString, z, null, 544, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$1(WebSearchDetailCardCreator webSearchDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return webSearchDetailCardCreator.buildResultList(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$2(WebSearchDetailCardCreator webSearchDetailCardCreator, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return webSearchDetailCardCreator.buildEmptyView(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
    
        if (r10 != null) goto L14;
     */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        String str;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        JsonObject params = toolCallInfo.getParams();
        if (params != null && (jsonElement = params.get("query")) != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                str = jsonElement.getAsString();
            }
        }
        str = "…";
        if (str.length() > 40) {
            str = StringsKt.take(str, 40) + (char) 8230;
        }
        boolean z = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        card.setSubtitle(str);
        if (!z) {
            String string = context.getString(C0637R.string.trae_chat_tool_web_searching);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            card.setTitle(string);
            card.setIconResId(C0637R.drawable.ic_tool_web);
            card.setIconTintColorRes(0);
            card.setShimmerTitle(true);
        } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
            String string2 = context.getString(C0637R.string.trae_chat_tool_web_search_failed);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            card.setTitle(string2);
            card.setIconResId(C0637R.drawable.warning);
            card.setIconTintColorRes(C0591R.color.trae_status_warning_default);
            card.setShimmerTitle(false);
        } else {
            final List<WebSearchResult> extractResults = extractResults(toolCallInfo);
            String string3 = context.getString(C0637R.string.trae_chat_tool_web_searched);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            card.setTitle(string3);
            card.setIconResId(C0637R.drawable.ic_tool_web);
            card.setIconTintColorRes(0);
            card.setShimmerTitle(false);
            card.setContentView(extractResults.isEmpty() ^ true ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    View onUpdateCard$lambda$4;
                    onUpdateCard$lambda$4 = WebSearchDetailCardCreator.onUpdateCard$lambda$4(WebSearchDetailCardCreator.this, extractResults, (Context) obj);
                    return onUpdateCard$lambda$4;
                }
            } : new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    View onUpdateCard$lambda$5;
                    onUpdateCard$lambda$5 = WebSearchDetailCardCreator.onUpdateCard$lambda$5(WebSearchDetailCardCreator.this, (Context) obj);
                    return onUpdateCard$lambda$5;
                }
            });
        }
        card.setStatus(fromString);
        FLogger.INSTANCE.i("AgentTool", "[WebSearchCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString + ", query=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onUpdateCard$lambda$4(WebSearchDetailCardCreator webSearchDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return webSearchDetailCardCreator.buildResultList(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onUpdateCard$lambda$5(WebSearchDetailCardCreator webSearchDetailCardCreator, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return webSearchDetailCardCreator.buildEmptyView(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        if (r0 != null) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<WebSearchResult> extractResults(ParsedToolCallInfo toolCallInfo) {
        JsonObject data;
        JsonArray jsonArray;
        JsonObject asJsonObject;
        JsonElement jsonElement;
        String asString;
        String str;
        JsonElement jsonElement2;
        String str2;
        ParsedToolCallResult result = toolCallInfo.getResult();
        if (result == null || (data = result.getData()) == null) {
            return CollectionsKt.emptyList();
        }
        JsonElement jsonElement3 = data.get("results");
        if (jsonElement3 != null) {
            if (!jsonElement3.isJsonArray()) {
                jsonElement3 = null;
            }
            if (jsonElement3 != null) {
                jsonArray = jsonElement3.getAsJsonArray();
            }
        }
        JsonElement jsonElement4 = data.get("references");
        if (jsonElement4 != null) {
            if (!jsonElement4.isJsonArray()) {
                jsonElement4 = null;
            }
            if (jsonElement4 != null) {
                jsonArray = jsonElement4.getAsJsonArray();
                if (jsonArray == null) {
                    return CollectionsKt.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (JsonElement jsonElement5 : (Iterable) jsonArray) {
                    int i2 = i + 1;
                    if (i >= 5) {
                        break;
                    }
                    if (jsonElement5 != null) {
                        if (!jsonElement5.isJsonObject()) {
                            jsonElement5 = null;
                        }
                        if (jsonElement5 != null && (asJsonObject = jsonElement5.getAsJsonObject()) != null && (jsonElement = asJsonObject.get("title")) != null) {
                            if (!jsonElement.isJsonPrimitive()) {
                                jsonElement = null;
                            }
                            if (jsonElement != null && (asString = jsonElement.getAsString()) != null) {
                                JsonElement jsonElement6 = asJsonObject.get("link");
                                if (jsonElement6 != null) {
                                    if (!jsonElement6.isJsonPrimitive()) {
                                        jsonElement6 = null;
                                    }
                                    if (jsonElement6 != null) {
                                        str = jsonElement6.getAsString();
                                        jsonElement2 = asJsonObject.get("favicon");
                                        if (jsonElement2 != null) {
                                            if (!jsonElement2.isJsonPrimitive()) {
                                                jsonElement2 = null;
                                            }
                                            if (jsonElement2 != null) {
                                                str2 = jsonElement2.getAsString();
                                                arrayList.add(new WebSearchResult(asString, str, str2));
                                            }
                                        }
                                        str2 = null;
                                        arrayList.add(new WebSearchResult(asString, str, str2));
                                    }
                                }
                                str = null;
                                jsonElement2 = asJsonObject.get("favicon");
                                if (jsonElement2 != null) {
                                }
                                str2 = null;
                                arrayList.add(new WebSearchResult(asString, str, str2));
                            }
                        }
                    }
                    i = i2;
                }
                return arrayList;
            }
        }
        jsonArray = null;
        if (jsonArray == null) {
        }
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (r0.hasNext()) {
        }
        return arrayList2;
    }

    private final View buildEmptyView(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        TextView textView = new TextView(context);
        textView.setText(context.getString(C0637R.string.trae_chat_tool_web_search_no_matches));
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
        textView.setTextSize(2, 13.0f);
        textView.setMaxLines(1);
        textView.setPadding(0, (int) (4 * f), 0, (int) (16 * f));
        return textView;
    }

    private final View buildResultList(Context context, List<WebSearchResult> results) {
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Iterator<T> it = results.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            linearLayout.addView(buildResultItemRow(context, f, i, (WebSearchResult) it.next()));
        }
        return linearLayout;
    }

    private final View buildResultItemRow(final Context context, float density, int index, final WebSearchResult result) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight((int) (24 * density));
        int i = (int) (4 * density);
        linearLayout.setPadding(0, i, 0, i);
        if (result.getLink() != null) {
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WebSearchDetailCardCreator.buildResultItemRow$lambda$16$lambda$15(WebSearchDetailCardCreator.this, context, result, view);
                }
            });
        }
        TextView textView = new TextView(context);
        textView.setText(String.valueOf(index));
        textView.setTypeface(Typeface.create("JetBrains Mono", 0));
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
        textView.setTextSize(2, 13.0f);
        textView.setMinWidth((int) (12 * density));
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(17);
        int i2 = (int) (16 * density);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.setMarginStart(i);
        linearLayout2.setLayoutParams(layoutParams);
        int i3 = (int) (13 * density);
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
        simpleDraweeView.getHierarchy().setPlaceholderImage(C0637R.drawable.ic_tool_web);
        linearLayout2.addView((View) simpleDraweeView, new LinearLayout.LayoutParams(i3, i3));
        linearLayout.addView(linearLayout2);
        String favicon = result.getFavicon();
        if (!(favicon == null || favicon.length() == 0)) {
            simpleDraweeView.setImageURI(Uri.parse(result.getFavicon()));
        }
        TextView textView2 = new TextView(context);
        textView2.setText(result.getTitle());
        textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
        textView2.setTextSize(2, 13.0f);
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.setMarginStart((int) (8 * density));
        textView2.setLayoutParams(layoutParams2);
        linearLayout.addView(textView2);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildResultItemRow$lambda$16$lambda$15(WebSearchDetailCardCreator webSearchDetailCardCreator, Context context, WebSearchResult webSearchResult, View view) {
        webSearchDetailCardCreator.openUrl(context, webSearchResult.getLink());
        IApplog.Companion companion = IApplog.INSTANCE;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("tool_name", "WebSearch");
        Unit unit = Unit.INSTANCE;
        companion.reportEvent("tool_call_click", jSONObject);
    }

    private final void openUrl(Context context, String url) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WebSearchDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;", "", "title", "", "link", "favicon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getLink", "getFavicon", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class WebSearchResult {
        private final String favicon;
        private final String link;
        private final String title;

        public static /* synthetic */ WebSearchResult copy$default(WebSearchResult webSearchResult, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = webSearchResult.title;
            }
            if ((i & 2) != 0) {
                str2 = webSearchResult.link;
            }
            if ((i & 4) != 0) {
                str3 = webSearchResult.favicon;
            }
            return webSearchResult.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component2, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        /* renamed from: component3, reason: from getter */
        public final String getFavicon() {
            return this.favicon;
        }

        public final WebSearchResult copy(String title, String link, String favicon) {
            Intrinsics.checkNotNullParameter(title, "title");
            return new WebSearchResult(title, link, favicon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WebSearchResult)) {
                return false;
            }
            WebSearchResult webSearchResult = (WebSearchResult) other;
            return Intrinsics.areEqual(this.title, webSearchResult.title) && Intrinsics.areEqual(this.link, webSearchResult.link) && Intrinsics.areEqual(this.favicon, webSearchResult.favicon);
        }

        public int hashCode() {
            int hashCode = this.title.hashCode() * 31;
            String str = this.link;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.favicon;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "WebSearchResult(title=" + this.title + ", link=" + this.link + ", favicon=" + this.favicon + ')';
        }

        public WebSearchResult(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.link = str2;
            this.favicon = str3;
        }

        public /* synthetic */ WebSearchResult(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : str3);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getLink() {
            return this.link;
        }

        public final String getFavicon() {
            return this.favicon;
        }
    }
}
