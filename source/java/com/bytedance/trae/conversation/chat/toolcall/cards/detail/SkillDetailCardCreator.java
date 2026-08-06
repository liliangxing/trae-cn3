package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.PlanItemContext;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard;
import com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.ParsedToolCallResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* compiled from: SkillDetailCardCreator.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "extractSkillName", "", "extractSkillDetail", "readString", "obj", "Lcom/google/gson/JsonObject;", "key", "buildDescriptionView", "Landroid/view/View;", "name", "description", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SkillDetailCardCreator extends BaseToolDetailCardCreator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TOOL_TAG = "AgentTool";

    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected ToolDetailCard onCreateDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        final String extractSkillName = extractSkillName(toolCallInfo);
        final Companion.SkillDetailParsed parseSkillDetail = INSTANCE.parseSkillDetail(extractSkillDetail(toolCallInfo));
        String str2 = extractSkillName;
        if (str2 == null || str2.length() == 0) {
            str = "Skill";
        } else if (fromString == ToolExecutionStatus.RUNNING) {
            str = context.getString(C0637R.string.trae_chat_tool_launching_skill, extractSkillName);
        } else {
            str = context.getString(C0637R.string.trae_chat_tool_launched_skill, extractSkillName);
        }
        String str3 = str;
        Intrinsics.checkNotNull(str3);
        String name = parseSkillDetail.getName();
        String str4 = (name.length() > 0) && !Intrinsics.areEqual(name, extractSkillName) ? name : null;
        FLogger.INSTANCE.i("AgentTool", "[SkillCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString);
        return new ToolDetailCard("⚡", C0637R.drawable.ic_toolcall_skill, 0, str3, str4, null, parseSkillDetail.getDescription().length() > 0 ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.SkillDetailCardCreator$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                View onCreateDetail$lambda$1;
                onCreateDetail$lambda$1 = SkillDetailCardCreator.onCreateDetail$lambda$1(SkillDetailCardCreator.this, extractSkillName, parseSkillDetail, (Context) obj);
                return onCreateDetail$lambda$1;
            }
        } : null, fromString, false, null, 804, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$1(SkillDetailCardCreator skillDetailCardCreator, String str, Companion.SkillDetailParsed skillDetailParsed, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return skillDetailCardCreator.buildDescriptionView(context, str, skillDetailParsed.getDescription());
    }

    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        final String extractSkillName = extractSkillName(toolCallInfo);
        final Companion.SkillDetailParsed parseSkillDetail = INSTANCE.parseSkillDetail(extractSkillDetail(toolCallInfo));
        String str2 = extractSkillName;
        boolean z = false;
        if (str2 == null || str2.length() == 0) {
            str = "Skill";
        } else if (fromString == ToolExecutionStatus.RUNNING) {
            str = context.getString(C0637R.string.trae_chat_tool_launching_skill, extractSkillName);
            Intrinsics.checkNotNull(str);
        } else {
            str = context.getString(C0637R.string.trae_chat_tool_launched_skill, extractSkillName);
            Intrinsics.checkNotNull(str);
        }
        card.setTitle(str);
        card.setContentView(parseSkillDetail.getDescription().length() > 0 ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.SkillDetailCardCreator$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                View onUpdateCard$lambda$2;
                onUpdateCard$lambda$2 = SkillDetailCardCreator.onUpdateCard$lambda$2(SkillDetailCardCreator.this, extractSkillName, parseSkillDetail, (Context) obj);
                return onUpdateCard$lambda$2;
            }
        } : null);
        String name = parseSkillDetail.getName();
        if ((name.length() > 0) && !Intrinsics.areEqual(name, extractSkillName)) {
            z = true;
        }
        card.setSubtitle(z ? name : null);
        card.setStatus(fromString);
        FLogger.INSTANCE.i("AgentTool", "[SkillCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onUpdateCard$lambda$2(SkillDetailCardCreator skillDetailCardCreator, String str, Companion.SkillDetailParsed skillDetailParsed, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return skillDetailCardCreator.buildDescriptionView(context, str, skillDetailParsed.getDescription());
    }

    private final String extractSkillName(ParsedToolCallInfo toolCallInfo) {
        JsonObject params = toolCallInfo.getParams();
        if (params == null) {
            return null;
        }
        String readString = readString(params, "name");
        return readString == null ? readString(params, "skill_name") : readString;
    }

    private final String extractSkillDetail(ParsedToolCallInfo toolCallInfo) {
        JsonObject data;
        ParsedToolCallResult result = toolCallInfo.getResult();
        if (result == null || (data = result.getData()) == null) {
            return null;
        }
        return readString(data, "skill_detail");
    }

    private final String readString(JsonObject obj, String key) {
        JsonElement jsonElement;
        String asString;
        String obj2;
        if (obj == null || (jsonElement = obj.get(key)) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null || (asString = jsonElement.getAsString()) == null || (obj2 = StringsKt.trim(asString).toString()) == null) {
            return null;
        }
        if (obj2.length() > 0) {
            return obj2;
        }
        return null;
    }

    private final View buildDescriptionView(Context context, String name, String description) {
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        if (name != null) {
            String str = name;
            if (!TextUtils.isEmpty(str)) {
                TextView textView = new TextView(context);
                textView.setTextSize(2, 13.0f);
                textView.setTypeface(Typeface.defaultFromStyle(1));
                textView.setTextColor(Color.parseColor("#484847"));
                TextViewCompat.setLineHeight(textView, (int) (17 * f));
                textView.setText(description);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setText(str);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
            }
        }
        TextView textView2 = new TextView(context);
        textView2.setTextAppearance(context, C0591R.style.Trae_Text_Body_Sm);
        textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
        textView2.setText(description);
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    /* compiled from: SkillDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion;", "", "<init>", "()V", "TOOL_TAG", "", "parseSkillDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;", "skillDetail", "SkillDetailParsed", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* compiled from: SkillDetailCardCreator.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;", "", "name", "", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getDescription", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class SkillDetailParsed {
            private final String description;
            private final String name;

            public static /* synthetic */ SkillDetailParsed copy$default(SkillDetailParsed skillDetailParsed, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = skillDetailParsed.name;
                }
                if ((i & 2) != 0) {
                    str2 = skillDetailParsed.description;
                }
                return skillDetailParsed.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* renamed from: component2, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            public final SkillDetailParsed copy(String name, String description) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(description, "description");
                return new SkillDetailParsed(name, description);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SkillDetailParsed)) {
                    return false;
                }
                SkillDetailParsed skillDetailParsed = (SkillDetailParsed) other;
                return Intrinsics.areEqual(this.name, skillDetailParsed.name) && Intrinsics.areEqual(this.description, skillDetailParsed.description);
            }

            public int hashCode() {
                return (this.name.hashCode() * 31) + this.description.hashCode();
            }

            public String toString() {
                return "SkillDetailParsed(name=" + this.name + ", description=" + this.description + ')';
            }

            public SkillDetailParsed(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "name");
                Intrinsics.checkNotNullParameter(str2, "description");
                this.name = str;
                this.description = str2;
            }

            public final String getDescription() {
                return this.description;
            }

            public final String getName() {
                return this.name;
            }
        }

        public final SkillDetailParsed parseSkillDetail(String skillDetail) {
            String str;
            List groupValues;
            String str2;
            String obj;
            List groupValues2;
            String str3;
            String str4 = skillDetail;
            String str5 = "";
            if (str4 == null || StringsKt.isBlank(str4)) {
                return new SkillDetailParsed("", "");
            }
            MatchResult find$default = Regex.find$default(new Regex("^#\\s*(.+?)$", RegexOption.MULTILINE), str4, 0, 2, (Object) null);
            if (find$default == null || (groupValues2 = find$default.getGroupValues()) == null || (str3 = (String) CollectionsKt.getOrNull(groupValues2, 1)) == null || (str = StringsKt.trim(str3).toString()) == null) {
                str = "";
            }
            MatchResult find$default2 = Regex.find$default(new Regex("\\*\\*Description:\\*\\*\\s*(.+?)(?=\\*\\*Details:\\*\\*|$)", RegexOption.DOT_MATCHES_ALL), str4, 0, 2, (Object) null);
            if (find$default2 != null && (groupValues = find$default2.getGroupValues()) != null && (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) != null && (obj = StringsKt.trim(str2).toString()) != null) {
                str5 = obj;
            }
            return new SkillDetailParsed(str, str5);
        }
    }
}
